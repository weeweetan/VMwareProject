/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import com.vmware.eam.sample.solution.util.EamConnection;
import com.vmware.eam.sample.solution.util.Pair;
import com.vmware.eam.sample.solution.util.VcUtils;
import com.vmware.vsphere.AgencyComputeResourceScope;
import com.vmware.vsphere.AgencyConfigInfo;
import com.vmware.vsphere.AgentConfigInfo;
import com.vmware.vsphere.AgentOvfEnvironmentInfo;
import com.vmware.vsphere.AgentOvfEnvironmentInfoOvfProperty;
import com.vmware.vsphere.EamObjectRuntimeInfo;
import com.vmware.vsphere.EamObjectRuntimeInfoGoalState;
import com.vmware.vsphere.EamPortType;
import com.vmware.vsphere.InvalidAgencyScopeFaultMsg;
import com.vmware.vsphere.InvalidAgentConfigurationFaultMsg;
import com.vmware.vsphere.InvalidUrlFaultMsg;
import com.vmware.vsphere.Issue;
import com.vmware.vsphere.ManagedObjectReference;
import com.vmware.vsphere.NotFoundFaultMsg;
import com.vmware.vsphere.RuntimeFaultFaultMsg;

/**
 * Class handles all the interaction with the agency in the ESX Agent Manager.
 */
public class AgentHandler {

   // logger for the agent handler
   private final Logger _log = Logger.getLogger(AgentHandler.class.getName());

   // The ESX Agent Manager connection.
   private EamConnection _eamConnection;

   /*
    * Config info, describing urls, ovf env. This is used to specify agents on
    * 4.x hosts.
    */
   private final AgentConfigInfo _agentConfigInfo4x;

   /*
    * Config info, describing urls, ovf env. This is used to specify agents on
    * 5.0 hosts.
    */
   private final AgentConfigInfo _agentConfigInfo50;

   // Config info, describing agent configuration and scope
   private AgencyConfigInfo _agencyConfigInfo;

   // Solution's agency in EAM
   private ManagedObjectReference _agency;

   // Solution unregister flag
   private boolean _unregistered = false;

   private boolean _isSetup = false;

   private final VcUtils _vcUtils;

   /**
    * Constructor for the AgentHandler class
    *
    * Sets up the agency configuration, ovf environment, and initial empty scope
    */
   public AgentHandler(String selfUrl,
                       String selfIp,
                       String ovfUrl4x,
                       String ovfUrl50,
                       String vibUrl4x,
                       String vibUrl50,
                       boolean deployVibs,
                       Map<String, String> ovfEnvironment,
                       VcUtils vcUtils) {
      _vcUtils = vcUtils;

      _agentConfigInfo4x = new AgentConfigInfo();
      _agentConfigInfo50 = new AgentConfigInfo();

      String urlPrefix = Manager.expandUrl(selfUrl, selfIp) + "/";

      // Set vib and ovf url
      _agentConfigInfo4x.setOvfPackageUrl(urlPrefix + ovfUrl4x);
      _agentConfigInfo50.setOvfPackageUrl(urlPrefix + ovfUrl50);

      if (deployVibs) {
         _agentConfigInfo4x.setVibUrl(urlPrefix + vibUrl4x);
         _agentConfigInfo50.setVibUrl(urlPrefix + vibUrl50);

         // Enable dvFilter.
         _agentConfigInfo4x.setDvFilterEnabled(true);
         _agentConfigInfo50.setDvFilterEnabled(true);
      }

      // Set solution default ovf environment
      AgentOvfEnvironmentInfo ovfEnv = new AgentOvfEnvironmentInfo();
      for (final Entry<String, String> entry : ovfEnvironment.entrySet()) {
         ovfEnv.getOvfProperty().add(new AgentOvfEnvironmentInfoOvfProperty() {
            {
               setKey(entry.getKey());
               setValue(entry.getValue());
            }
         });
      }
      _agentConfigInfo4x.setOvfEnvironment(ovfEnv);
      _agentConfigInfo50.setOvfEnvironment(ovfEnv);

      _agencyConfigInfo = new AgencyConfigInfo();
      _agencyConfigInfo.setAgencyName("Sample Service");
      _agencyConfigInfo.setAgentName("Sample Service");
      _agencyConfigInfo.getAgentConfig().add(_agentConfigInfo4x);
      _agencyConfigInfo.getAgentConfig().add(_agentConfigInfo50);

      // Set solution scope (empty to start with)
      _agencyConfigInfo.setScope(null);
   }

   private boolean equals(Object o1, Object o2) {
      if (o1 == null) {
         return (o2 == null);
      }

      return o1.equals(o2);
   }

   /**
    * Update the agency's configuration based on an array of key value pair
    * passed via the web ui
    *
    * @param updates
    * @throws RuntimeFaultFaultMsg
    */
   public void updateConfig(String[] updates) throws RuntimeFaultFaultMsg {
      waitForSetup();

      boolean changed = false;
      Map<String, ManagedObjectReference> crs = _vcUtils.getComputeResources();
      Set<ManagedObjectReference> newScope = new HashSet<ManagedObjectReference>();

      for (String update : updates) {
         String[] kv = update.split("=", 2);
         if (kv[0].equals("scope")) {
            try {
               ManagedObjectReference cr = crs.get(kv[1]);
               if (cr == null) {
                  continue;
               }
               ManagedObjectReference moRef = new ManagedObjectReference();
               moRef.setType(cr.getType());
               moRef.setValue(cr.getValue());
               newScope.add(moRef);
            } catch (NullPointerException e) {
               // ignore
            }
         }
      }

      AgencyConfigInfo agencyConfigInfo = new AgencyConfigInfo();

      AgencyComputeResourceScope scopeDO = (AgencyComputeResourceScope) _agencyConfigInfo.getScope();
      Set<ManagedObjectReference> oldScope = new HashSet<ManagedObjectReference>(scopeDO.getComputeResource());

      if (!oldScope.containsAll(newScope) || oldScope.size() != newScope.size()) {
         AgencyComputeResourceScope scope = new AgencyComputeResourceScope();
         scope.getComputeResource().addAll(newScope);
         agencyConfigInfo.setScope(scope);
         changed = true;
      }

      if (changed) {
         // Call agency.update with new spec
         assert _agency != null;
         try {
            _eamConnection.getStub().update(_agency, agencyConfigInfo);
         } catch (Exception e) {
            _log.error("Failed to update agency. Reason: " + e.getMessage());
         }
         updateConfiguration();
      }
   }

   /**
    * Updates the goal state of the agency.
    *
    * @param params The input parameters from the goal state UI.
    * @throws RuntimeFaultFaultMsg
    * @throws NotFoundFaultMsg
    */
   public void updateGoalState(String params) throws RuntimeFaultFaultMsg,
      NotFoundFaultMsg {
      String[] kv = params.split("=", 2);
      assert kv[0].equals("goalState");

      String goalState = kv[1];
      String currentGoalState = getRuntime().getGoalState().toString();

      if (goalState.equals(currentGoalState)) {
         return;
      }

      if (goalState.equals(EamObjectRuntimeInfoGoalState.ENABLED.toString()
                                                                .toLowerCase())) {
         enable();
      } else if (goalState.equals(EamObjectRuntimeInfoGoalState.DISABLED.toString()
                                                                        .toLowerCase())) {
         disable();
      } else {
         assert goalState.equals(EamObjectRuntimeInfoGoalState.UNINSTALLED.toString()
                                                                          .toLowerCase());
         _unregistered = true;
         Manager.getInstance().cleanup();
      }
   }

   /**
    * Create the solution's agency in EAM based on the agency configuration
    * initialized in the constructor.
    *
    * @param eamConnection
    */
   public void setup(EamConnection eamConnection) {
      assert eamConnection != null;
      _eamConnection = eamConnection;

      ManagedObjectReference eamRef = _eamConnection.getEsxAgentManager();
      EamPortType stub = _eamConnection.getStub();
      try {
         List<ManagedObjectReference> agencyRefs = stub.queryAgency(eamRef);

         if (agencyRefs != null && agencyRefs.size() > 0) {
            _agency = agencyRefs.get(0);
         } else {
            // Create agency from deployment spec
            _agency = stub.createAgency(eamRef,
                                        _agencyConfigInfo,
                                        EamObjectRuntimeInfoGoalState.ENABLED.toString()
                                                                             .toLowerCase());
         }

         // Retrieve configInfo back to fill in defaults
         _agencyConfigInfo = stub.queryConfig(_agency);
         _isSetup = true;
      } catch (RuntimeFaultFaultMsg e) {
         _log.error(e, e);
      } catch (InvalidAgencyScopeFaultMsg e) {
         _log.error(e, e);
      } catch (InvalidAgentConfigurationFaultMsg e) {
         _log.error(e, e);
      } catch (InvalidUrlFaultMsg e) {
         _log.error(e, e);
      }
   }

   /**
    * @return Status of agency in EAM
    * @throws RuntimeFaultFaultMsg
    */
   public EamObjectRuntimeInfo getRuntime() throws RuntimeFaultFaultMsg {
      waitForSetup();
      return _eamConnection.getStub().agencyQueryRuntime(_agency);
   }

   public void updateConfiguration() throws RuntimeFaultFaultMsg {
      waitForSetup();
      _agencyConfigInfo = _eamConnection.getStub().queryConfig(_agency);
   }

   /**
    * Returns the configuration of the solution's agency
    *
    * @return Agency's configuration
    */
   public AgencyConfigInfo getConfiguration() {
      return _agencyConfigInfo;
   }

   /**
    * Remediates all currently outstanding issues on the agency.
    *
    * @throws RuntimeFaultFaultMsg
    */
   public void resolveAll() throws RuntimeFaultFaultMsg {
      waitForSetup();
      _eamConnection.getStub().resolveAll(_agency);
   }

   /**
    * Remediates the input issue on the agency.
    *
    * @throws RuntimeFaultFaultMsg
    * @throws NumberFormatException
    */
   public void resolve(String issueId) throws NumberFormatException,
      RuntimeFaultFaultMsg {
      waitForSetup();
      List<Integer> unknownIssueIds = _eamConnection.getStub()
                                                    .resolve(_agency,
                                                             Collections.singletonList(Integer.parseInt(issueId)));
      if (unknownIssueIds != null) {
         _log.error("Failed to resolve issue:" + issueId);
      }
   }

   /**
    * Finds a specific issue based on the issue id.
    *
    * @param issueId
    * @return issue if found, null if not
    * @throws RuntimeFaultFaultMsg
    */
   public Issue getIssue(String issueId) throws RuntimeFaultFaultMsg {
      waitForSetup();
      EamObjectRuntimeInfo runtime = getRuntime();
      assert runtime != null;
      List<Issue> issues = _eamConnection.getStub().queryIssue(_agency, null);
      if (issues == null) {
         return null;
      }
      for (Issue issue : issues) {
         if (getIssueId(issue).equals(issueId)) {
            return issue;
         }
      }
      return null;
   }

   /**
    * Computes the id for this given issue.
    *
    * @param issue
    * @return issue's id
    */
   public String getIssueId(Issue issue) {
      return Integer.toString(issue.getKey());
   }

   /**
    * Enables all agents in the solution
    *
    * @throws RuntimeFaultFaultMsg
    */
   public void enable() throws RuntimeFaultFaultMsg {
      waitForSetup();
      _eamConnection.getStub().enable(_agency);
   }

   /**
    * Disables all agents in the solution
    *
    * @throws RuntimeFaultFaultMsg
    */
   public void disable() throws RuntimeFaultFaultMsg {
      waitForSetup();
      _eamConnection.getStub().disable(_agency);
   }

   /**
    * Uninstalls all agents in the solution
    *
    * @throws RuntimeFaultFaultMsg
    */
   public void uninstall() throws RuntimeFaultFaultMsg {
      waitForSetup();
      _eamConnection.getStub().uninstall(_agency);
   }

   /**
    * @return Unregistered flag
    */
   public boolean isUnregistered() {
      return _unregistered;
   }

   public Collection<Pair<String, Boolean>> getComputeResources()
      throws RuntimeFaultFaultMsg {
      // Current scope
      AgencyComputeResourceScope scopeDO = (AgencyComputeResourceScope) _agencyConfigInfo.getScope();
      Set<String> scope = new HashSet<String>();
      for (ManagedObjectReference moRef : scopeDO.getComputeResource()) {
         scope.add(moRef.getType() + ":" + moRef.getValue());
      }

      /*
       * Iterate over all compute resources and create collection with scope
       * boolean.
       */
      Map<String, ManagedObjectReference> crs = _vcUtils.getComputeResources();
      ArrayList<Pair<String, Boolean>> crList = new ArrayList<Pair<String, Boolean>>();
      for (Entry<String, ManagedObjectReference> crEntry : crs.entrySet()) {
         ManagedObjectReference moRef = crEntry.getValue();
         Boolean inScope = new Boolean(scope.contains(moRef.getType() + ":"
               + moRef.getValue()));
         crList.add(Pair.create(crEntry.getKey(), inScope));
      }
      return crList;
   }

   private void waitForSetup() {
      while (!_isSetup) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
      }
   }
}
