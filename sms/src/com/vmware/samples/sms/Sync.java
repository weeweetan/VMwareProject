package com.vmware.samples.sms;
import java.util.*;

import com.vmware.apputils.*;
import com.vmware.vim.sms.*;

/**
 * <pre>
 * 
 * Sync
 *
 * This sample triggers Storage Monitoring Service synchronization 
 * of data from the vCenter database.
 *
 * <b>Parameters:</b>
 * url             [required] : url of the vCenter web service (https://<ip>/sdk)
 * username        [required] : username for authenticating with vCenter
 * password        [required] : password for authenticating with vCenter
 *
 * Command:
 * java com.vmware.samples.sms.Sync --url [webserviceurl]
 * --username [username] --password [password]
 *
 * </pre>
 */
public class Sync {
   private static void printUsage() {
      System.out.println("This sample demonstrates how to trigger a sync on SMS cache from the latest vCenter data");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the vCenter web service.");
      System.out.println("username        [required] : username for authentication with vCenter");
      System.out.println("password        [required] : password for authentication with vCenter");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.Sync --url [webserviceurl]");
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
      conn.sync();

      System.out.println("Provider sync completed successfully!");
   }
}
