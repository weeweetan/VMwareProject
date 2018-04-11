package com.vmware.samples.sms;

import com.vmware.apputils.*;
import com.vmware.vim.sms.*;

/**
 * <pre>
 * 
 * UpdateVcDbConnectionInfo
 *
 * This sample changes the JDBC information used by the Storage Monitoring Service
 * to connect to the vCenter database.
 *
 * <b>Parameters:</b>
 * url               [required] : url of the vCenter web service (https://<ip>/sdk)
 * username          [required] : username for authenticating with vCenter
 * password          [required] : password for authenticating with vCenter
 * jdbcUrl           [required] : url of the JDBC data source for the vCenter database
 * jdbcUsername      [required] : username for authenticating with the database
 * jdbcPassword      [required] : password for authenticating with the database
 *
 * Command:
 * java com.vmware.samples.sms.UpdateVcDbConnectionInfo --url [webserviceurl]
 * --username [username] --password [password]
 * --jdbcUrl [jdbcUrl] jdbcUsername [jdbcUsername] --jdbcPassword [jdbcPassword]
 *
 * </pre>
 */
public class UpdateVcDbConnectionInfo {
   private static void printUsage() {
      System.out.println("This sample changes the JDBC information used by SMS " +
                         "to connect to the vCenter database.");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the vCenter web service.");
      System.out.println("username        [required] : username for authentication with vCenter");
      System.out.println("password        [required] : password for authentication with vCenter");
      System.out.println("jdbcUrl         [required] : url of the JDBC data source for the vCenter database");
      System.out.println("jdbcUsername    [required] : username for authenticating with the database");
      System.out.println("jdbcPassword    [required] : password for authenticating with the database");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.UpdateVcDbConnectionInfo --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--jdbcUrl [jdbcUrl] --jdbcUsername [jdbcUsername] --jdbcPassword [jdbcPassword]");
   }

   public static void main(String[] args) throws Exception {
      OptionsHelper oh = new OptionsHelper();
      oh.load(args);

      if(oh.isSet("help") || !oh.isSet("url") ||
         !oh.isSet("username") || !oh.isSet("password") ||
         !oh.isSet("jdbcUsername") || !oh.isSet("jdbcPassword") ||
         !oh.isSet("jdbcUrl")) {
         printUsage();
         return;
      }

      String url = oh.get("url");
      String username = oh.get("username");
      String password = oh.get("password");
      String jdbcUsername = oh.get("jdbcUsername");
      String jdbcPassword = oh.get("jdbcPassword");
      String jdbcUrl = oh.get("jdbcUrl");

      SmServiceConnection conn = new SmServiceConnection(url, username, password);
      
      DbConnectionSpec dbConnectionSpec = new DbConnectionSpec();
      dbConnectionSpec.setUsername(username);
      dbConnectionSpec.setPassword(password);
      dbConnectionSpec.setUrl(url);

      conn.updateVcDbConnectionInfo(dbConnectionSpec);
      System.out.println("The connection information for the VC database has been updated.");
   }
}
