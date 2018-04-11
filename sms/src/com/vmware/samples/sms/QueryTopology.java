package com.vmware.samples.sms;

import com.vmware.vim.sms.*;
import com.vmware.vim25.*;
import com.vmware.apputils.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * <pre>
 * 
 * QueryTopology
 *
 * This sample queries the topology of a given datacenter and displays each node along
 * with all the edges associated with it.
 *
 * <b>Parameters:</b>
 * url            [required] : url of the vCenter web service (https://<ip>/sdk)
 * username       [required] : username for authenticating with vCenter
 * password       [required] : password for authenticating with vCenter
 * dcName         [required] : datacenter name
 *
 * Command:
 * java com.vmware.samples.sms.QueryTopology --url [webserviceurl]
 * --username [username] --password [password] --dcName[dcName]
 *
 * </pre>
 */
public class QueryTopology {
   private SmServiceConnection conn;
   private String dcName;

   public QueryTopology(SmServiceConnection conn, String dcName) {
      this.conn = conn;
      this.dcName = dcName;
   }

   public void execute() throws Exception {
      // Get the EntityReferene corresponding to the datacenter
      EntityReference dcRef = getDcEntityReference();

      com.vmware.vim.sms.Map smsTopologyMap = conn.queryTopology(dcRef);

      // Construct a HashMap containing all nodes for efficient retrieval
      Map<String, Node> nodeMap = new HashMap<String, Node>();
      List<Node> nodeList = smsTopologyMap.getNode();
      ListIterator<Node> nodeListIterator = nodeList.listIterator();
      while(nodeListIterator.hasNext()) {
         Node node = nodeListIterator.next();
         String key = node.getEntity().getType() + ":" + node.getEntity().getId();
         nodeMap.put(key, node);
      }

      //Display each and every node and all the edges containing that node in the topology graph. 
      Iterator nodeIterator = nodeMap.entrySet().iterator();
      while (nodeIterator.hasNext()) {

         Map.Entry entry = (Map.Entry) nodeIterator.next();
         Node node = nodeMap.get(entry.getKey());

         System.out.println("--------------------------------------------------------------------");
         System.out.println("Node Type - " + node.getEntity().getType());
         System.out.println("Node name - " + node.getName());
         System.out.println("Edges containing this node \nOutput Format : <Source Node> <Destination Node> <Edge Status>");

         List<Edge> edgeList = smsTopologyMap.getEdge();
         ListIterator<Edge> edgeListIterator = edgeList.listIterator();
         while (edgeListIterator.hasNext()) {
            Edge edge = edgeListIterator.next();
            if(edge.getSourceEntity().getId().equals(node.getEntity().getId()) || 
               edge.getDestEntity().getId().equals(node.getEntity().getId())) {
               String srcKey = edge.getSourceEntity().getType() + ":" + edge.getSourceEntity().getId();
               String destKey = edge.getDestEntity().getType() + ":" + edge.getDestEntity().getId();
               System.out.println(nodeMap.get(srcKey).getName()+ " " +
                                  nodeMap.get(destKey).getName()+ " " +
                                  edge.getStatus());
            }
         }
      }
   }

   private EntityReference getDcEntityReference() throws Exception {
      ManagedObjectReference dcMoRef = getDatacenterByName(dcName);
      if (dcMoRef == null) {
         System.out.println("Datacenter not found");
         throw new RuntimeException("Datacenter not found");
      }

      return EntityHelper.parseEntityReference(dcMoRef);
   }

   private TraversalSpec getDatacenterTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");

      //TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);
      traversalSpec.getSelectSet().add(sSpec);
      return traversalSpec;
   }

   private ManagedObjectReference getDatacenterByName(String datacenterName) throws Exception {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = conn.getVimServiceContent().getRootFolder();

      TraversalSpec tSpec = getDatacenterTraversalSpec();
      // Create Property Spec
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.getPathSet().add("name");
      propertySpec.setType("Datacenter");

      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(rootFolder);
      objectSpec.setSkip(Boolean.TRUE);
      objectSpec.getSelectSet().add(tSpec);

      // Create PropertyFilterSpec using the PropertySpec and ObjectPec
      // created above.
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      propertyFilterSpec.getPropSet().add(propertySpec);
      propertyFilterSpec.getObjectSet().add(objectSpec);

      List<PropertyFilterSpec> listfps = new ArrayList<PropertyFilterSpec>(1);
      listfps.add(propertyFilterSpec);
      List<ObjectContent> listobcont =
         conn.getVimPort().retrieveProperties(
            conn.getVimServiceContent().getPropertyCollector(), listfps);

      if (listobcont != null) {
         for (ObjectContent oc : listobcont) {
            ManagedObjectReference mr = oc.getObj();
            String dcnm = null;
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
               //Since there is only one property PropertySpec pathset
               //this array contains only one value
               for (DynamicProperty dp : dps) {
                  dcnm = (String) dp.getVal();
               }
            }
            //This is done outside of the previous for loop to break
            //out of the loop as soon as the required datacenter is found.
            if (dcnm != null && dcnm.equals(datacenterName)) {
               retVal = mr;
               break;
            }
         }
      }

      return retVal;
   }

   private static void printUsage() {
      System.out.println("This sample queries the topology of a given datacenter and displays each node along " +
                         "with all the edges associated with it.");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the vCenter web service.");
      System.out.println("username        [required] : username for authentication with vCenter");
      System.out.println("password        [required] : password for authentication with vCenter");
      System.out.println("dcName          [required] : datacenter name");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.QueryTopology --url [webserviceurl]");
      System.out.println("--username [username] --password [password] --dcName [dcName]");
   }

   public static void main(String[] args) throws Exception {
      OptionsHelper oh = new OptionsHelper();
      oh.load(args);

      if(oh.isSet("help") || !oh.isSet("url") ||
         !oh.isSet("username") || !oh.isSet("password") ||
         !oh.isSet("dcName")) {
         printUsage();
         return;
      }

      String url = oh.get("url");
      String username = oh.get("username");
      String password = oh.get("password");
      String dcName = oh.get("dcName");

      SmServiceConnection conn = new SmServiceConnection(url, username, password);

      QueryTopology query = new QueryTopology(conn, dcName);
      query.execute();
   }
}

