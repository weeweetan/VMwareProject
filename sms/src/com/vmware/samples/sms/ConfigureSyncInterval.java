package com.vmware.samples.sms;

import com.vmware.apputils.*;
import com.vmware.vim.sms.*;

/**
 * <pre>
 * 
 * ConfigureSyncInterval
 *
 * This sample configures the interval at which the Storage 
 * Monitoring Service synchronizes data from the vCenter database.
 *
 * <b>Parameters:</b>
 * url             [required] : url of the vCenter web service (https://<ip>/sdk)
 * username        [required] : username for authenticating with vCenter
 * password        [required] : password for authenticating with vCenter
 * syncInterval    [required] : time in seconds between syncs
 *
 * Command:
 * java com.vmware.samples.sms.ConfigureSyncInterval --url [webserviceurl]
 * --username [username] --password [password]
 * --syncInterval [syncInterval]
 *
 * </pre>
 */
public class ConfigureSyncInterval {
   private static void printUsage() {
      System.out.println("This sample demonstrates how to configure the interval at with SMS synchronizes data from vCenter");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the vCenter web service.");
      System.out.println("username        [required] : username for authentication with vCenter");
      System.out.println("password        [required] : password for authentication with vCenter");
      System.out.println("syncInterval    [required] : time in seconds between syncs");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.ConfigureSyncInterval --url [webserviceurl]");
      System.out.println("--username [username] --password [password] -- syncInterval [interval]");
   }

   public static void main(String[] args) throws Exception {
         OptionsHelper oh = new OptionsHelper();
         oh.load(args);

         if(oh.isSet("help") || !oh.isSet("url") ||
            !oh.isSet("username") || !oh.isSet("password") ||
            !oh.isSet("syncInterval")) {
            printUsage();
            return;
         }

         String url = oh.get("url");
         String username = oh.get("username");
         String password = oh.get("password");
         int syncInterval = Integer.parseInt(oh.get("syncInterval"));

         SmServiceConnection conn = new SmServiceConnection(url, username, password);

         conn.configureSyncInterval(syncInterval);
         System.out.println("Configured sync interval to " + syncInterval + " seconds.");
   }
}
