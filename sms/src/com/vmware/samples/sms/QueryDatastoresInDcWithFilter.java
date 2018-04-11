package com.vmware.samples.sms;

import com.vmware.apputils.*;
import com.vmware.vim.sms.*;

import java.text.*;

/**
 * <pre>
 * 
 * QueryDatastoresInDcWithFilter
 *
 * This sample iterates over the list of all datacenter instances in the vCenter 
 * inventory and queries for associated datastores that match the criteria
 * provided in the QuerySpec. The filter constraints are hard coded in the sample
 * but the sort property can be specifiec as input to the program.
 *
 * <b>Parameters:</b>
 * url               [required] : url of the vCenter web service (https://<ip>/sdk)
 * username          [required] : username for authenticating with vCenter
 * password          [required] : password for authenticating with vCenter
 * sortPropertyName  [required] : property on which to sort the results
 *
 * Command:
 * java com.vmware.samples.sms.QueryDatastoresInDcWithFilter --url [webserviceurl]
 * --username [username] --password [password]
 * --sortPropertyName [sortPropertyName]
 *
 * </pre>
 */
public class QueryDatastoresInDcWithFilter {

   // Hardcoded entityType and relEntityType values
   private EntityReferenceEntityType entityType = EntityReferenceEntityType.DATACENTER;
   private EntityReferenceEntityType relEntityType = EntityReferenceEntityType.DATASTORE;

   // User defined value of sortPropertyName
   private SmServiceConnection conn;
   private String sortPropertyName;

   public QueryDatastoresInDcWithFilter(SmServiceConnection conn, String sortPropertyName) {
      this.conn = conn;
      this.sortPropertyName = sortPropertyName;
   }

   public void execute() throws Exception {
      boolean relEntityTypeSpecified = false;

      SortSpec[] sortSpec = getSortSpec();
      FilterSpec filterSpec = getFilterSpec();

      QuerySpec querySpec = new QuerySpec();
      querySpec.setMaxCount(0);
      querySpec.setOffset(0);
      querySpec.setFilterSpec(filterSpec);
      if(sortSpec != null) {
         for(SortSpec s : sortSpec) {
            querySpec.getSortSpec().add(s);
         }
      }

      // Get all instances of entityType without using any QuerySpec
      QueryResult entityResult =                                                            
         conn.queryList(null, entityType, null);                                              

      Metadata metadata = entityResult.getMetadata();
      System.out.println("Retrieved " + metadata.getNumRows() + " datacenter(s)");
      printFormattedQueryListResult(entityResult,relEntityTypeSpecified);

      RowData[] rowData = entityResult.getRow().toArray(new RowData[0]);

      int entityIdIdx = 0;
      String[] propertyNames = metadata.getPropertyName().toArray(new String[0]);
      for(int i = 0; i < propertyNames.length; ++i) {
         if(propertyNames[i].equalsIgnoreCase("entityid")) {
            entityIdIdx = i;
         }
      }

      // Iterates over each instance of entityType and lists instances
      // of relEntity associated with it after applying QuerySpec. 
      for(int j = 0; j < metadata.getNumRows(); ++j) {
         String entityId = (String) rowData[j].getColumn().get(entityIdIdx);
         EntityReference entityRef = new EntityReference();
         entityRef.setId(entityId);
         entityRef.setType(entityType);
         relEntityTypeSpecified = true;

         QueryResult relEntityResult =                                                               
            conn.queryList(entityRef, relEntityType, querySpec);                                              

         System.out.println("For datacenter - " + (j+1) + 
                            " Retrieved " + relEntityResult.getMetadata().getNumRows() + " datastore(s)");

         printFormattedQueryListResult(relEntityResult,relEntityTypeSpecified);
      }
   }

   private SortSpec[] getSortSpec() throws Exception {
      if (sortPropertyName != null) {
         // Defining the sort Spec with user defined options
         SortSpec[] sortSpec = new SortSpec[1];
         sortSpec[0] = new SortSpec();
         sortSpec[0].setPropertyName(sortPropertyName);
         sortSpec[0].setAscending(true);
         return sortSpec;
      }
      return null;
   }

   private FilterSpec getFilterSpec() throws Exception {

      FilterSpec filterSpec = new FilterSpec();

      FilterSpecConstraint[] constraint1 = new FilterSpecConstraint[2];
      constraint1[0] = new FilterSpecConstraint();
      constraint1[0].setPropertyName("MULTIPATHINGSTATUS");
      constraint1[0].setPropertyValue("up"); 
      constraint1[0].setComparisonOperator(FilterSpecComparisonOperator.EQUAL);

      constraint1[1] = new FilterSpecConstraint();
      constraint1[1].setPropertyName("PERCENTFREE");
      constraint1[1].setPropertyValue("50"); 
      constraint1[1].setComparisonOperator(FilterSpecComparisonOperator.GREATER_THAN_OR_EQUAL);

      FilterSpecConstraint[] constraint2 = new FilterSpecConstraint[2];
      constraint2[0] = new FilterSpecConstraint();
      constraint2[0].setPropertyName("NAME");
      constraint2[0].setPropertyValue("LUN"); 
      constraint2[0].setComparisonOperator(FilterSpecComparisonOperator.BEGINS_WITH);

      constraint2[1] = new FilterSpecConstraint();
      constraint2[1].setPropertyName("NUMVM");
      constraint2[1].setPropertyValue("1"); 
      constraint2[1].setComparisonOperator(FilterSpecComparisonOperator.GREATER_THAN_OR_EQUAL);

      FilterSpecConstraint[] parentConstraint = new FilterSpecConstraint[2];
      parentConstraint[0] = new FilterSpecConstraint();
      parentConstraint[0].getChildConstraint().add(constraint1[0]);
      parentConstraint[0].getChildConstraint().add(constraint1[1]);
      parentConstraint[0].setChildConstraintLogicalOperator(FilterSpecLogicalOperator.LOGICAL_OR);

      parentConstraint[1] = new FilterSpecConstraint();
      parentConstraint[1].getChildConstraint().add(constraint2[0]);
      parentConstraint[1].getChildConstraint().add(constraint2[1]);
      parentConstraint[1].setChildConstraintLogicalOperator(FilterSpecLogicalOperator.LOGICAL_AND);

      FilterSpecConstraint[] rootConstraint = new FilterSpecConstraint[1];
      rootConstraint[0] = new FilterSpecConstraint();
      rootConstraint[0].getChildConstraint().add(parentConstraint[0]);
      rootConstraint[0].getChildConstraint().add(parentConstraint[1]);
      rootConstraint[0].setChildConstraintLogicalOperator(FilterSpecLogicalOperator.LOGICAL_AND);

      filterSpec.setConstraint(rootConstraint[0]);
      return filterSpec;
   }

   private void printFormattedQueryListResult(
      QueryResult result,
      boolean relEntityTypeSpecified) throws Exception {

      int numRows = result.getMetadata().getTotalRows();
      RowData[] rows = result.getRow().toArray(new RowData[0]);
      String[] columnNames = result.getMetadata().getPropertyName().toArray(new String[0]);

      for (int rowCounter = 0; rowCounter < numRows; rowCounter++) {
         System.out.println("--------------------------------------------------------------------");
         int columnCounter=0;
         String[] columnValues = rows[rowCounter].getColumn().toArray(new String[0]);
         while (columnCounter < result.getMetadata().getPropertyName().size()) {

            // In order to do special formatting of the output depending on the property type, 
            // get the type of each property.

            PropertyType propertyType = null;
            if (relEntityTypeSpecified) {
               propertyType = Catalog.getPropertyType(
                                                     entityType.value(), relEntityType.value(), 
                                                     columnNames[columnCounter]); 
            } else {
               propertyType = Catalog.getPropertyType(
                                                     entityType.value(),columnNames[columnCounter]); 
            }
            if (propertyType.equals(PropertyType.DoublePropertyType)) {
               if (columnValues[columnCounter] == null) {
                  System.out.println(columnNames[columnCounter] + " : 0 %");
               } else {
                  String pattern = "###.##";
                  DecimalFormat decimalFormatter = new DecimalFormat(pattern);
                  String formattedOutput = decimalFormatter.format(Double.parseDouble(columnValues[columnCounter]));
                  System.out.println(columnNames[columnCounter] + " : " +formattedOutput + " %");
               }
            } else if (propertyType.equals(PropertyType.LongPropertyType)) {
               if (columnValues[columnCounter] == null) {
                  System.out.println(columnNames[columnCounter] + " : 0 bytes");
               } else {
                  if (columnNames[columnCounter].contains("NUM")) {
                     System.out.println(columnNames[columnCounter] + " : " +columnValues[columnCounter]);
                  } else {
                     System.out.println(columnNames[columnCounter] + " : " +columnValues[columnCounter] + " bytes");
                  }
               }
            } else {
               System.out.println(columnNames[columnCounter] + " : " +columnValues[columnCounter]);
            }
            columnCounter++;
         }
         columnCounter = 0;
      }
   }

   private static void printUsage() {
      System.out.println("This sample iterates over the list of all datacenter instances in the vCenter " +
                         "inventory and queries for associated datastores that match the criteria " +
                         "provided in the QuerySpec. The filter constraints are hard coded in the sample " +
                         "but the sort property can be specifiec as input to the program.");
      System.out.println("\nParameters:");
      System.out.println("url              [required] : url of the vCenter web service.");
      System.out.println("username         [required] : username for authentication with vCenter");
      System.out.println("password         [required] : password for authentication with vCenter");
      System.out.println("sortPropertyName [required] : property on which to sort the results");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.QueryDatastoresInDcWithFilter --url [webserviceurl]");
      System.out.println("--username [username] --password [password] -- sortPropertyName [sortPropertyName]");
   }

   public static void main(String[] args) throws Exception {
      OptionsHelper oh = new OptionsHelper();
      oh.load(args);

      if(oh.isSet("help") || !oh.isSet("url") ||
         !oh.isSet("username") || !oh.isSet("password") ||
         !oh.isSet("sortPropertyName")) {
         printUsage();
         return;
      }

      String url = oh.get("url");
      String username = oh.get("username");
      String password = oh.get("password");
      String sortPropertyName = oh.get("sortPropertyName");

      SmServiceConnection conn = new SmServiceConnection(url, username, password);
      
      QueryDatastoresInDcWithFilter query =
         new QueryDatastoresInDcWithFilter(conn, sortPropertyName);
      query.execute();
   }
}
