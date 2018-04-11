/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.vmware.eam.sample.solution.AgentHandler;
import com.vmware.eam.sample.solution.Manager;
import com.vmware.eam.sample.solution.util.Pair;
import com.vmware.vsphere.RuntimeFaultFaultMsg;

public class ConfigModel {

    private String _message;

    // Map from internal goal state name to pretty printable names
    Map<String, String> _stateMap = new HashMap<String, String>();

    private final Manager _manager;

    private final AgentHandler _agentHandler;

    public ConfigModel(Manager manager,
                       AgentHandler agentHandler) {
        _manager = manager;
        _agentHandler = agentHandler;

        // Build goal state map
        _stateMap.put("Enable", "enabled");
        _stateMap.put("Temporarily Disable", "disabled");
        _stateMap.put("Uninstall", "uninstalled");
    }

    public void setMessage(String message) {
        _message = message;
    }

    public String getMessage() {
        return _message;
    }

    public String getConfigUrl() {
        return _manager.getURL() + "/config.html";
    }

   public Collection<Pair<String, Boolean>> getComputeResources()
      throws RuntimeFaultFaultMsg {
        return _agentHandler.getComputeResources();
    }

    public boolean isAgentHandlerUnregistered() {
        return _agentHandler.isUnregistered();
    }

    public Collection<String> getStates() {
        return _stateMap.keySet();
    }

    public String getGoalState(String state) {
        return _stateMap.get(state);
    }

   public String getGoalState() throws RuntimeFaultFaultMsg {
       return _agentHandler.getRuntime().getGoalState();
    }
}
