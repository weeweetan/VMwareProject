/* **********************************************************
 * Copyright 2011-2012 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.vsphere.ArrayOfManagedObjectReference;
import com.vmware.vsphere.ManagedObjectReference;
import com.vmware.vsphere.RuntimeFaultFaultMsg;

/**
 * <code>VcUtils</code> is a toolbox of various helper methods for vCenter
 * objects.
 */
public class VcUtils {

   private final VimConnection _vimConnection;

   public VcUtils(VimConnection vimConnection) {
      _vimConnection = vimConnection;
   }

   /**
    * @return All vCenter datacenters
    * @throws RuntimeFaultFaultMsg
    */
   public List<ManagedObjectReference> getDatacenters(ManagedObjectReference folder)
      throws RuntimeFaultFaultMsg {
      List<ManagedObjectReference> datacenters = new ArrayList<ManagedObjectReference>();
      if (folder == null) {
         folder = _vimConnection.getRootFolder();
      }
      ArrayOfManagedObjectReference folderChildren = _vimConnection.getProperty(folder,
                                                                                "childEntity");
      if (folderChildren != null) {
         for (ManagedObjectReference child : folderChildren.getManagedObjectReference()) {
            if (child.getType().equals("Datacenter")) {
               datacenters.add(child);
            } else if (child.getType().equals("Folder")) {
               datacenters.addAll(getDatacenters(child));
            }
         }
      }

      return datacenters;
   }

   /**
    * Returns a map containing <compute resource name, compute resource
    * reference.
    *
    * @return map with all vCenter's compute resources and their name
    * @throws RuntimeFaultFaultMsg
    */
   public Map<String, ManagedObjectReference> getComputeResources()
      throws RuntimeFaultFaultMsg {
      Map<String, ManagedObjectReference> computeResources = new HashMap<String, ManagedObjectReference>();
      for (ManagedObjectReference datacenter : getDatacenters(null)) {
         ManagedObjectReference hostFolder = (ManagedObjectReference) _vimConnection.getProperty(datacenter,
                                                                                                 "hostFolder");
         getComputeResourcesFromFolder(hostFolder, computeResources /* out */);
      }
      return computeResources;
   }

   /**
    * Recursively traverse folder and all its children folders to collect
    * vCenter compute resources
    *
    * @param folder current folder to scan for compute resources
    * @param crs map of all found compute resources
    * @throws RuntimeFaultFaultMsg
    */
   private void getComputeResourcesFromFolder(ManagedObjectReference folder,
                                              Map<String, ManagedObjectReference> crs)
      throws RuntimeFaultFaultMsg {
      assert folder != null;
      ArrayOfManagedObjectReference folderChildren = _vimConnection.getProperty(folder,
                                                                                "childEntity");

      for (ManagedObjectReference child : folderChildren.getManagedObjectReference()) {
         if (child.getType().equals("ComputeResource")
               || child.getType().equals("ClusterComputeResource")) {
            String name = (String) _vimConnection.getProperty(child, "name");
            crs.put(name, child);
         } else if (child.getType().equals("Folder")) {
            getComputeResourcesFromFolder(child, crs);
         }
      }
   }
}
