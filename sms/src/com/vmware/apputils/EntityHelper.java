package com.vmware.apputils;

import java.util.HashMap;
import java.util.regex.*;

import com.vmware.vim.sms.*;
import com.vmware.vim25.ManagedObjectReference;

/**
 * Helper methods for using entity reference objects.
 */
public class EntityHelper {
   /** Maps managed object id prefixes to entity types */
   private static HashMap<String,EntityReferenceEntityType> moIdPrefixToEntityTypeMap = new HashMap<String,EntityReferenceEntityType>();

   /** Maps entity types to managed object id prefixes */
   private static HashMap<EntityReferenceEntityType,String> entityTypeToMoIdPrefixMap = new HashMap<EntityReferenceEntityType,String>();

   /** Maps entity types to MOR types */
   private static HashMap<EntityReferenceEntityType,String> entityTypeToMORTypeMap = new HashMap<EntityReferenceEntityType,String>();

   static {
      moIdPrefixToEntityTypeMap.put("datacenter", EntityReferenceEntityType.DATACENTER);
      moIdPrefixToEntityTypeMap.put("domain-c", EntityReferenceEntityType.CLUSTER);
      moIdPrefixToEntityTypeMap.put("host", EntityReferenceEntityType.HOST);
      moIdPrefixToEntityTypeMap.put("resgroup", EntityReferenceEntityType.RESOURCE_POOL);
      moIdPrefixToEntityTypeMap.put("datastore", EntityReferenceEntityType.DATASTORE);
      moIdPrefixToEntityTypeMap.put("vm", EntityReferenceEntityType.VM);
      moIdPrefixToEntityTypeMap.put("group-p", EntityReferenceEntityType.STORAGE_POD);
      
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.DATACENTER, "datacenter");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.CLUSTER, "domain-c");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.HOST, "host");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.RESOURCE_POOL, "resgroup");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.DATASTORE, "datastore");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.VM, "vm");
      entityTypeToMoIdPrefixMap.put(EntityReferenceEntityType.STORAGE_POD, "group-p");

      entityTypeToMORTypeMap.put(EntityReferenceEntityType.DATACENTER, "Datacenter");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.CLUSTER, "ClusterComputeResource");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.HOST, "HostSystem");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.RESOURCE_POOL, "ResourcePool");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.DATASTORE, "Datastore");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.VM, "VirtualMachine");
      entityTypeToMORTypeMap.put(EntityReferenceEntityType.STORAGE_POD, "StoragePod");
   }
   
   /**
    * Takes a VC ManagedObjectReference Id and constructs a valid
    * EntityReference from it.
    * 
    * @param mor managed object reference to translate
    * 
    * @return EntityReference
    * @throws IllegalArgumentException if input mor is invalid
    */
   public static EntityReference parseEntityReference(ManagedObjectReference mor) 
      throws IllegalArgumentException {
      if (mor == null) {
         return null;
      }

      String extractedEntityTypeStr = null;
      Pattern pattern = Pattern.compile("^[a-z]+\\-[a-z]*");
      Matcher matcher = pattern.matcher(mor.getValue());
      if (matcher.find()) {
         extractedEntityTypeStr = matcher.group();
      }
      if (extractedEntityTypeStr == null) {
         /**
          * This means the user has not sent a valid 
          * ManagedObjectReference 
          */
         System.out.println("Invalid MOR - value field is in invalid format: " + mor.getValue());
         throw new IllegalArgumentException("Invalid MOR - value field is in invalid format");  
      }

      int len = extractedEntityTypeStr.length();
      if (extractedEntityTypeStr.charAt(len - 1) == '-') {
         extractedEntityTypeStr = extractedEntityTypeStr.substring(0, len - 1);
      }

      /** Look up the entity type using the type map */
      EntityReferenceEntityType extractedEntityType = 
         (EntityReferenceEntityType) 
      moIdPrefixToEntityTypeMap.get(extractedEntityTypeStr);

      if (extractedEntityType == null) {
         System.out.println("Invalid MOR - unknown object type : " + mor.getValue());
         throw new IllegalArgumentException("Invalid MOR - unknown object type");  
      }

      /**
       * If we reach here, we expected to find a trailing number Id
       */
      String extractedEntityId = null;
      pattern = Pattern.compile("[0-9]+$");
      matcher = pattern.matcher(mor.getValue());
      if (matcher.find()) {
         extractedEntityId = matcher.group();
      }
      if (extractedEntityId == null) {
         /**
          * This means the user has not sent a VC ManagedObjectReference
          * Id
          */
         System.out.println("Invalid MOR - invalid id : " + mor.getValue());
         throw new IllegalArgumentException("Invalid MOR - invalid id");  
      }

      EntityReference convertedRef = new EntityReference();
      convertedRef.setId(extractedEntityId);
      convertedRef.setType(extractedEntityType);
      return convertedRef;
   }

   /**
    * Converts the given entity reference, which represents a
    * managed object, to a ManagedObjectReference type.
    * 
    * @param entity MO entity reference
    * 
    * @return ManagedObjectReference
    * @throws IllegalArgumentException if an invalid entity is
    *                                  specified
    */
   public static  ManagedObjectReference parseMOR(EntityReference entity) 
      throws IllegalArgumentException {

      EntityReferenceEntityType entityType = entity.getType();

      if (entityType == null) {
         System.out.println("Invalid entity type: " + entity.getType()); 
         throw new IllegalArgumentException("Invalid entity type");  
      }

      String morType = (String) entityTypeToMORTypeMap.get(entityType);
      String idPrefix = (String) entityTypeToMoIdPrefixMap.get(entityType);
      if (idPrefix.indexOf('-') == -1) {
         idPrefix = idPrefix.concat("-");
      }

      String moid = idPrefix.concat(entity.getId());

      ManagedObjectReference mor = new ManagedObjectReference();
      mor.setValue(moid);
      mor.setType(morType);
      return mor; 
   }
}
