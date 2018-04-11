package com.vmware.apputils;

import java.util.HashMap;

/**
 * Java representation of the entity relationship specification for the QueryList
 * API method. It provides methods to query which relationship combinations are
 * supported, what properties are returned in each case and the type information
 * for those properties.
 */
public final class Catalog {
   /**
    * Indicates if any relationship queries are supported for the given entity type.
    * @param entityType type name of the entity.
    * @return true if at least one relationship combination is supported
    *          for the given entity type, false otherwise.
    */
   public static boolean hasRelation(String entityType) {
      return (relPropTypeMap.get(entityType.toUpperCase()) != null);
   }

   /**
    * Indicates if the specified relationship combination is supported.
    * @param entityType type name of the entity for which the query is needed.
    * @param relatedEntityType type name of the required related entities.
    * @return true if the given relationship combination is supported, false
    *          otherwise.
    */
   public static boolean isRelation(String entityType, String relatedEntityType) {
      return hasRelation(entityType) && relPropTypeMap.get(entityType.toUpperCase())
         .get(relatedEntityType.toUpperCase()) != null;
   }

   /**
    * Indicates if the specified property is returned by a query for the given 
    * relationship combination.
    * @param entityType type name of the entity for which the query is needed.
    * @param relatedEntityType type name of the required related entities.
    * @param propertyName property name to be checked.
    * @return true if the property name is supported for the given relationship
    *          combination, false otherwise.
    */
   public static boolean isProperty(String entityType, 
                                    String relatedEntityType,
                                    String propertyName) {
      return isRelation(entityType, relatedEntityType)
         && relPropTypeMap.get(entityType.toUpperCase())
         .get(relatedEntityType.toUpperCase()).get(propertyName.toUpperCase()) != null;
   }

   /**
    * Indicates if the specified property is returned by a query for the given entity type.
    * @param entityType type name of the entity for which the query is needed.
    * @param propertyName property name to be checked.
    * @return true if the property name is supported for a query on the given entity type,
    *          false otherwise.
    */
   public static boolean isProperty(String entityType,
                                    String propertyName) {
      return entityPropTypeMap.get(entityType.toUpperCase()).get(propertyName.toUpperCase()) != null;
   }

   /**
    * Returns the type of the specified property when querying for the given 
    * relationship combination.
    * @param entityType type name of the entity for which the query is needed.
    * @param relatedEntityType type name of the required related entities.
    * @param propertyName property name to be checked.
    * @return type of the specified property or null if the property is not
    *          supported for the given relationship combination.
    */
   public static PropertyType getPropertyType(String entityType,
                                              String relatedEntityType, 
                                              String propertyName) {
      if (!isProperty(entityType, relatedEntityType, propertyName)) {
         return null;
      }
      return relPropTypeMap.get(entityType.toUpperCase())
         .get(relatedEntityType.toUpperCase()).get(propertyName.toUpperCase());
   }

   /**
    * Returns the type of the specified property when querying for the given 
    * entity type.
    * @param entityType type name of the entity for which the query is needed.
    * @param propertyName property name to be checked.
    * @return type of the specified property or null if the property is not
    *          supported for the given entity type.
    */
   public static PropertyType getPropertyType(String entityType,
                                              String propertyName) {
      if (!isProperty(entityType, propertyName)) {
         return null;
      }
      return entityPropTypeMap.get(entityType.toUpperCase())
         .get(propertyName.toUpperCase());
   }

   /**
    * Returns a collection of all properties for a given relationship combination.
    * Each entry contains the name of a property and its type.
    * @param entityType type name of the entity for which the query is needed.
    * @param relatedEntityType type name of the required related entities.
    * @return a hash map with the property name as the key and property type
    *          as the value.
    */
   public static HashMap<String, PropertyType> getSubCatalog(String entityType, 
                                                             String relatedEntityType) {
      if (!isRelation(entityType, relatedEntityType)) {
         return null;
      }
      return relPropTypeMap.get(entityType.toUpperCase()).get(relatedEntityType.toUpperCase());
   }

   /**
    * Returns a collection of all properties for a query on the given entity type.
    * Each entry contains the name of a property and its type.
    * @param entityType type name of the entity for which the query is needed.
    * @return a hash map with the property name as the key and property type
    *          as the value.
    */
   public static HashMap<String, PropertyType> getSubCatalog(String entityType) {
      return entityPropTypeMap.get(entityType.toUpperCase());
   }

   /**
    * Main data structure to store the entity relationship query specification.
    */
   private static final HashMap<String, /* entity type */
      HashMap<String, /* related entity type*/
         HashMap<String, /* property name */
            PropertyType>>> relPropTypeMap = new HashMap<String,
                                                   HashMap<String,
                                                      HashMap<String, PropertyType>>>()
   {
      {
         put("STORAGEPOD", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("STATUS", new PropertyType("datastoreStatus"));
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NONVMUSED", PropertyType.LongPropertyType);
                           put("NUMVM", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("VM", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("STORAGEPOD", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("ENTITYSTATUS", new PropertyType("datastoreStatus"));
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("ENTITYPROVISIONED", PropertyType.LongPropertyType);
                           put("ENTITYUNCOMMITTED", PropertyType.LongPropertyType);
                           put("ENTITYNUMVMDISK", PropertyType.LongPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("VMFILE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("PATH", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("vmFileType"));
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("SIZE", PropertyType.LongPropertyType);
                           put("NUMVM", PropertyType.LongPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("DATASTORE", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("VM", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("RESOURCEPOOL", PropertyType.StringPropertyType);
                           put("RESOURCEPOOLENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("ENTITYPROVISIONED", PropertyType.LongPropertyType);
                           put("ENTITYUNCOMMITTED", PropertyType.LongPropertyType);
                           put("ENTITYNUMVMDISK", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("HOST", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                        }
                     }
                  );
                  put("RESOURCEPOOL", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("PATH", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                        }
                     }
                  );
                  put("CLUSTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                        }
                     }
                  );
                  put("VMFILE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("PATH", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("vmFileType"));
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("SIZE", PropertyType.LongPropertyType);
                           put("NUMVM", PropertyType.LongPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("CLUSTER", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("VM", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("RESOURCEPOOL", PropertyType.StringPropertyType);
                           put("RESOURCEPOOLENTITYID", PropertyType.StringPropertyType);
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("STORAGEPOD", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("ENTITYSTATUS", new PropertyType("datastoreStatus"));
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("HOST", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("RESOURCEPOOL", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("PATH", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("RESOURCEPOOL", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("VM", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("STORAGEPOD", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("ENTITYSTATUS", new PropertyType("datastoreStatus"));
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("HOST", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("VM", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("RESOURCEPOOL", PropertyType.StringPropertyType);
                           put("RESOURCEPOOLENTITYID", PropertyType.StringPropertyType);
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("STORAGEPOD", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("ENTITYSTATUS", new PropertyType("datastoreStatus"));
                           put("ENTITYMULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("ENTITYUSED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("ENTITYDISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("ENTITYOTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("ENTITYSHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("CANONICALNAME", PropertyType.StringPropertyType);
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("ENTITYSTATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("NAME", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
         put("DATACENTER", new HashMap<String, HashMap<String, PropertyType>>()
            {
               {
                  put("VM", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("RESOURCEPOOL", PropertyType.StringPropertyType);
                           put("RESOURCEPOOLENTITYID", PropertyType.StringPropertyType);
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("DATASTORE", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("STORAGEPOD", PropertyType.StringPropertyType);
                           put("DATASTORETYPE", new PropertyType("datastoreType"));
                           put("STATUS", new PropertyType("datastoreStatus"));
                           put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("FREESPACE", PropertyType.LongPropertyType);
                           put("PERCENTFREE", PropertyType.DoublePropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("PERCENTUSED", PropertyType.DoublePropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("PERCENTSNAPSHOT", PropertyType.DoublePropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("PERCENTDISKUSED", PropertyType.DoublePropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("PERCENTSWAP", PropertyType.DoublePropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("PERCENTOTHERUSED", PropertyType.DoublePropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("PERCENTSHARED", PropertyType.DoublePropertyType);
                           put("PROVISIONED", PropertyType.LongPropertyType);
                           put("UNCOMMITTED", PropertyType.LongPropertyType);
                           put("NONVMUSED", PropertyType.LongPropertyType);
                           put("NUMVM", PropertyType.LongPropertyType);
                           put("NUMVMDISK", PropertyType.LongPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("HOST", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("RESOURCEPOOL", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("PATH", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("CLUSTER", PropertyType.StringPropertyType);
                           put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("CLUSTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                           put("USED", PropertyType.LongPropertyType);
                           put("SNAPSHOT", PropertyType.LongPropertyType);
                           put("DISKUSED", PropertyType.LongPropertyType);
                           put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                           put("SWAP", PropertyType.LongPropertyType);
                           put("OTHERUSED", PropertyType.LongPropertyType);
                           put("SHARED", PropertyType.LongPropertyType);
                           put("NUMDATASTORE", PropertyType.LongPropertyType);
                        }
                     }
                  );
                  put("SCSIVOLUME", new HashMap<String, PropertyType>()
                     {
                        {
                           put("SCSIID", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiVolumeStatus"));
                           put("CAPACITY", PropertyType.LongPropertyType);
                           put("COMMITTED", PropertyType.LongPropertyType);
                           put("THINPROVISIONED", PropertyType.StringPropertyType);
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("STORAGEARRAY", PropertyType.StringPropertyType);
                           put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                           put("VENDOR", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIPATH", new HashMap<String, PropertyType>()
                     {
                        {
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("RUNTIMENAME", PropertyType.StringPropertyType);
                           put("LUNNUM", PropertyType.LongPropertyType);
                           put("ADAPTER", PropertyType.StringPropertyType);
                           put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                           put("VOLUMEID", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("TARGETPORTWWN", PropertyType.StringPropertyType);
                           put("TARGETNODEWWN", PropertyType.StringPropertyType);
                           put("TARGETISCSINAME", PropertyType.StringPropertyType);
                           put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                           put("STATUS", new PropertyType("scsiPathStatus"));
                           put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                           put("PREFERRED", new PropertyType("scsiPathPreferred"));
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSIADAPTER", new HashMap<String, PropertyType>()
                     {
                        {
                           put("NAME", PropertyType.StringPropertyType);
                           put("HOST", PropertyType.StringPropertyType);
                           put("HOSTENTITYID", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("STATUS", new PropertyType("scsiAdapterStatus"));
                           put("MODEL", PropertyType.StringPropertyType);
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("DRIVER", PropertyType.StringPropertyType);
                           put("PCI", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("SCSITARGET", new HashMap<String, PropertyType>()
                     {
                        {
                           put("TYPE", new PropertyType("scsiAdapterType"));
                           put("WWN", PropertyType.StringPropertyType);
                           put("PORTWWN", PropertyType.StringPropertyType);
                           put("NODEWWN", PropertyType.StringPropertyType);
                           put("ISCSINAME", PropertyType.StringPropertyType);
                           put("ISCSIALIAS", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
                  put("NASMOUNT", new HashMap<String, PropertyType>()
                     {
                        {
                           put("REMOTEHOST", PropertyType.StringPropertyType);
                           put("REMOTEPATH", PropertyType.StringPropertyType);
                           put("USERNAME", PropertyType.StringPropertyType);
                           put("TYPE", new PropertyType("nasMountType"));
                           put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                           put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                           put("DATASTORE", PropertyType.StringPropertyType);
                           put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                           put("ENTITYID", PropertyType.StringPropertyType);
                        }
                     }
                  );
               }
            }
         );
      }
   };

   /**
    * Main data structure to store the entity query specification.
    */
   private static final HashMap<String, /* entity type */
         HashMap<String, /* property name */
            PropertyType>> entityPropTypeMap = new HashMap<String,
                                                      HashMap<String, PropertyType>>()
   {
      {
         put("VM", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("HOST", PropertyType.StringPropertyType);
                  put("HOSTENTITYID", PropertyType.StringPropertyType);
                  put("DATACENTER", PropertyType.StringPropertyType);
                  put("DATACENTERENTITYID", PropertyType.StringPropertyType);
                  put("CLUSTER", PropertyType.StringPropertyType);
                  put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                  put("RESOURCEPOOL", PropertyType.StringPropertyType);
                  put("RESOURCEPOOLENTITYID", PropertyType.StringPropertyType);
                  put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                  put("USED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("PROVISIONED", PropertyType.LongPropertyType);
                  put("UNCOMMITTED", PropertyType.LongPropertyType);
                  put("NUMVMDISK", PropertyType.LongPropertyType);
                  put("NUMDATASTORE", PropertyType.LongPropertyType);
               }
            }
         );
         put("DATASTORE", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("STORAGEPOD", PropertyType.StringPropertyType);
                  put("DATASTORETYPE", new PropertyType("datastoreType"));
                  put("STATUS", new PropertyType("datastoreStatus"));
                  put("MULTIPATHINGSTATUS", new PropertyType("multipathingStatus"));
                  put("CAPACITY", PropertyType.LongPropertyType);
                  put("FREESPACE", PropertyType.LongPropertyType);
                  put("PERCENTFREE", PropertyType.DoublePropertyType);
                  put("USED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("PROVISIONED", PropertyType.LongPropertyType);
                  put("UNCOMMITTED", PropertyType.LongPropertyType);
                  put("NONVMUSED", PropertyType.LongPropertyType);
                  put("NUMVM", PropertyType.LongPropertyType);
                  put("NUMVMDISK", PropertyType.LongPropertyType);
                  put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                  put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
               }
            }
         );
         put("HOST", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("DATACENTER", PropertyType.StringPropertyType);
                  put("DATACENTERENTITYID", PropertyType.StringPropertyType);
                  put("CLUSTER", PropertyType.StringPropertyType);
                  put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                  put("USED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("NUMDATASTORE", PropertyType.LongPropertyType);
               }
            }
         );
         put("STORAGEPOD", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("RESOURCEPOOL", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("PATH", PropertyType.StringPropertyType);
                  put("HOST", PropertyType.StringPropertyType);
                  put("HOSTENTITYID", PropertyType.StringPropertyType);
                  put("CLUSTER", PropertyType.StringPropertyType);
                  put("CLUSTERENTITYID", PropertyType.StringPropertyType);
                  put("DATACENTER", PropertyType.StringPropertyType);
                  put("DATACENTERENTITYID", PropertyType.StringPropertyType);
                  put("USED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("NUMDATASTORE", PropertyType.LongPropertyType);
               }
            }
         );
         put("CLUSTER", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("DATACENTER", PropertyType.StringPropertyType);
                  put("DATACENTERENTITYID", PropertyType.StringPropertyType);
                  put("USED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("NUMDATASTORE", PropertyType.LongPropertyType);
               }
            }
         );
         put("DATACENTER", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
                  put("USED", PropertyType.LongPropertyType);
                  put("DISKUSED", PropertyType.LongPropertyType);
                  put("SNAPSHOT", PropertyType.LongPropertyType);
                  put("SHARED", PropertyType.LongPropertyType);
                  put("SWAP", PropertyType.LongPropertyType);
                  put("OTHERUSED", PropertyType.LongPropertyType);
                  put("CONFIGUREDDISK", PropertyType.LongPropertyType);
                  put("NUMDATASTORE", PropertyType.LongPropertyType);
               }
            }
         );
         put("VMFILE", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("PATH", PropertyType.StringPropertyType);
                  put("TYPE", new PropertyType("vmFileType"));
                  put("DATASTORE", PropertyType.StringPropertyType);
                  put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                  put("SIZE", PropertyType.LongPropertyType);
                  put("NUMVM", PropertyType.LongPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("SCSIVOLUME", new HashMap<String, PropertyType>()
            {
               {
                  put("SCSIID", PropertyType.StringPropertyType);
                  put("STATUS", new PropertyType("scsiVolumeStatus"));
                  put("CAPACITY", PropertyType.LongPropertyType);
                  put("COMMITTED", PropertyType.LongPropertyType);
                  put("THINPROVISIONED", PropertyType.StringPropertyType);
                  put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                  put("STORAGEARRAY", PropertyType.StringPropertyType);
                  put("ARRAYIDENTIFIER", PropertyType.StringPropertyType);
                  put("VENDOR", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("SCSIPATH", new HashMap<String, PropertyType>()
            {
               {
                  put("HOST", PropertyType.StringPropertyType);
                  put("HOSTENTITYID", PropertyType.StringPropertyType);
                  put("RUNTIMENAME", PropertyType.StringPropertyType);
                  put("LUNNUM", PropertyType.LongPropertyType);
                  put("ADAPTER", PropertyType.StringPropertyType);
                  put("ADAPTERTYPE", new PropertyType("scsiAdapterType"));
                  put("VOLUMEID", PropertyType.StringPropertyType);
                  put("WWN", PropertyType.StringPropertyType);
                  put("TARGETPORTWWN", PropertyType.StringPropertyType);
                  put("TARGETNODEWWN", PropertyType.StringPropertyType);
                  put("TARGETISCSINAME", PropertyType.StringPropertyType);
                  put("TARGETISCSIALIAS", PropertyType.StringPropertyType);
                  put("STATUS", new PropertyType("scsiPathStatus"));
                  put("ACTIVITYSTATE", new PropertyType("scsiPathActivityState"));
                  put("PREFERRED", new PropertyType("scsiPathPreferred"));
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("SCSIADAPTER", new HashMap<String, PropertyType>()
            {
               {
                  put("NAME", PropertyType.StringPropertyType);
                  put("DATACENTER", PropertyType.StringPropertyType);
                  put("DATACENTERENTITYID", PropertyType.StringPropertyType);
                  put("HOST", PropertyType.StringPropertyType);
                  put("HOSTENTITYID", PropertyType.StringPropertyType);
                  put("TYPE", new PropertyType("scsiAdapterType"));
                  put("STATUS", new PropertyType("scsiAdapterStatus"));
                  put("MODEL", PropertyType.StringPropertyType);
                  put("WWN", PropertyType.StringPropertyType);
                  put("PORTWWN", PropertyType.StringPropertyType);
                  put("NODEWWN", PropertyType.StringPropertyType);
                  put("ISCSINAME", PropertyType.StringPropertyType);
                  put("ISCSIALIAS", PropertyType.StringPropertyType);
                  put("DRIVER", PropertyType.StringPropertyType);
                  put("PCI", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("SCSITARGET", new HashMap<String, PropertyType>()
            {
               {
                  put("TYPE", new PropertyType("scsiAdapterType"));
                  put("WWN", PropertyType.StringPropertyType);
                  put("PORTWWN", PropertyType.StringPropertyType);
                  put("NODEWWN", PropertyType.StringPropertyType);
                  put("ISCSINAME", PropertyType.StringPropertyType);
                  put("ISCSIALIAS", PropertyType.StringPropertyType);
                  put("VENDOR", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
         put("NASMOUNT", new HashMap<String, PropertyType>()
            {
               {
                  put("REMOTEHOST", PropertyType.StringPropertyType);
                  put("REMOTEPATH", PropertyType.StringPropertyType);
                  put("USERNAME", PropertyType.StringPropertyType);
                  put("TYPE", new PropertyType("nasMountType"));
                  put("SYSTEMCAPABILITY", PropertyType.StringPropertyType);
                  put("CUSTOMCAPABILITY", PropertyType.StringPropertyType);
                  put("DATASTORE", PropertyType.StringPropertyType);
                  put("DATASTOREENTITYID", PropertyType.StringPropertyType);
                  put("ENTITYID", PropertyType.StringPropertyType);
               }
            }
         );
      }
   };

}
