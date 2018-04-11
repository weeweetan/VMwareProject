package com.vmware.samples.sms;

import com.vmware.apputils.*;
import com.vmware.vim.sms.*;

/**
 * <pre>
 * 
 * QueryScsiVolumesInDc
 *
 * This sample iterates over the list of all datacenter instances in the vCenter 
 * inventory and queries for associated SCSI Volumes (LUNs).
 *
 * <b>Parameters:</b>
 * url               [required] : url of the vCenter web service (https://<ip>/sdk)
 * username          [required] : username for authenticating with vCenter
 * password          [required] : password for authenticating with vCenter
 *
 * Command:
 * java com.vmware.samples.sms.QueryScsiVolumesInDc --url [webserviceurl]
 * --username [username] --password [password]
 *
 * </pre>
 */
public class QueryScsiVolumesInDc {
   private SmServiceConnection conn;

   public QueryScsiVolumesInDc(SmServiceConnection conn) {
      this.conn = conn;
   }

   public void execute() throws Exception {
      // Get all instances of datacenter
      QueryResult entityResult =                                                            
         conn.queryList(null, EntityReferenceEntityType.DATACENTER, null);                                              

      Metadata metadata = entityResult.getMetadata();
      System.out.println("Retrieved " + metadata.getNumRows() + " " + "datacenter(s)");
      printDetailedQueryListResult(entityResult);

      RowData[] rowData = entityResult.getRow().toArray(new RowData[0]);

      int entityIdIdx = 0;
      String[] propertyNames = metadata.getPropertyName().toArray(new String[0]);
      for(int i = 0; i < propertyNames.length; ++i) {
         if (propertyNames[i].equalsIgnoreCase("entityid")) {
            entityIdIdx = i;
         }
      }

      //Iterates over each instance of datacenter and lists instances of SCSIVolumes associated with it. 
      for(int j = 0; j < metadata.getNumRows(); ++j) {
         String entityId = (String) rowData[j].getColumn().get(entityIdIdx);
         EntityReference entityRef = new EntityReference();
         entityRef.setId(entityId);
         entityRef.setType(EntityReferenceEntityType.DATACENTER);

         QueryResult relEntityResult =                                                               
            conn.queryList(entityRef, EntityReferenceEntityType.SCSI_VOLUME, null);                                              

         System.out.println("For datacenter - " + (j+1) + 
                            " Retrieved " + relEntityResult.getMetadata().getNumRows() + "scsiVolume(s)");

         printDetailedQueryListResult(relEntityResult);

      }
   }

   private void printDetailedQueryListResult(QueryResult result) throws Exception {

      int numRows = result.getMetadata().getTotalRows();
      RowData[] rows = result.getRow().toArray(new RowData[0]);
      String[] columnNames = result.getMetadata().getPropertyName().toArray(new String[0]);

      // Display the detailed information of all scsiVolumes hosted on this datacenter
      for (int rowCounter = 0; rowCounter < numRows; rowCounter++) {
         System.out.println("--------------------------------------------------------------------");
         int columnCounter=0;
         String[] columnValues = rows[rowCounter].getColumn().toArray(new String[0]);
         while (columnCounter < result.getMetadata().getPropertyName().size()) {
            System.out.println(columnNames[columnCounter] + " : " +columnValues[columnCounter]);
            columnCounter++;
         }
         columnCounter = 0;
      }
   }

   private static void printUsage() {
      System.out.println("This sample iterates over the list of all datacenter instances in the vCenter " +
                         "inventory and queries for associated SCSI Volumes (LUNs).");
      System.out.println("\nParameters:");
      System.out.println("url              [required] : url of the vCenter web service.");
      System.out.println("username         [required] : username for authentication with vCenter");
      System.out.println("password         [required] : password for authentication with vCenter");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.QueryScsiVolumesInDc --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
   }

   public static void main(String[] args) throws Exception {
      OptionsHelper oh = new OptionsHelper();
      oh.load(args);

      if(oh.isSet("help") || !oh.isSet("url") ||
         !oh.isSet("username") || !oh.isSet("password")) {
         printUsage();
         return;
      }

      String url = oh.get("url");
      String username = oh.get("username");
      String password = oh.get("password");

      SmServiceConnection conn = new SmServiceConnection(url, username, password);

      QueryScsiVolumesInDc query = new QueryScsiVolumesInDc(conn);
      query.execute();
   }
}
