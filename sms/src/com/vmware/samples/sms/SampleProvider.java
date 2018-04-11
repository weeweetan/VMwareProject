package com.vmware.samples.sms;

import com.vmware.vim.sms.*;
import com.vmware.vim25.*;
import com.vmware.apputils.*;

import java.util.List;

/**
 * <pre>
 * 
 * SampleProvider
 *
 * This sample demonstrates registration, listing and deregistration of a VASA
 * provider. It requires access to an active VASA provider.
 *
 * <b>Parameters:</b>
 * url               [required] : url of the vCenter web service (https://<ip>/sdk)
 * username          [required] : username for authenticating with vCenter
 * password          [required] : password for authenticating with vCenter
 * provUrl           [required] : url of the VASA provider web service
 * provUsername      [required] : username for authenticating with the provider
 * provPassword      [required] : password for authenticating with the provider
 *
 * Command:
 * java com.vmware.samples.sms.SampleProvider --url [webserviceurl]
 * --username [username] --password [password]
 * --provUrl [provUrl] provUsername [provUsername] --provPassword [provPassword]
 *
 * </pre>
 */
public class SampleProvider {
   private SmServiceConnection conn;
   private VasaProviderSpec spec;
   private LocalizedMethodFault temp;

   private SmsPortType service;
   private ManagedObjectReference storageMgr;
   private ManagedObjectReference provider;

   private final int MAX_ATTEMPTS = 100;
   private final int SLEEP_INTERVAL = 1000;

   public SampleProvider(SmServiceConnection conn, VasaProviderSpec spec) throws Exception {
      this.conn = conn;
      this.spec = spec;

      ManagedObjectReference si = new ManagedObjectReference();
      si.setType("SmsServiceInstance");
      si.setValue("ServiceInstance");

      service = conn.getSmsPort();
      storageMgr = service.queryStorageManager(si);
   }

   private static class RegistrationResult {
      private ManagedObjectReference provider;
      private MethodFault fault;

      public void setProvider(ManagedObjectReference provider) {
         this.provider = provider;
      }

      public ManagedObjectReference getProvider() {
         return provider;
      }

      public void setFault(MethodFault fault) {
         this.fault = fault;
      }

      public MethodFault getFault() {
         return fault;
      }
   }

   private void registerProvider() throws Exception {
      while(true) {
         RegistrationResult res = registerProvider(spec);
         this.provider = res.getProvider();
         if(this.provider != null) {
            break;
         }

         MethodFault f = res.getFault();
         if(f != null && f instanceof CertificateNotTrusted) {
            spec.setCertificate(((CertificateNotTrusted) f).getCertificate());
            continue;
         }

         throw new RuntimeException("Registration failed");
      }
   }

   private RegistrationResult registerProvider(
      VasaProviderSpec spec) throws Exception {
      ManagedObjectReference regTask =
         service.registerProviderTask(storageMgr, spec);

      SmsTaskInfo taskInfo = waitForTask(regTask);

      RegistrationResult res = new RegistrationResult();
      if(taskInfo != null) {
         if(taskInfo.getState().equals("error")) {
            LocalizedMethodFault f = taskInfo.getError();
            res.setFault(f.getFault());
            return res;
         } else if(taskInfo.getState().equals("success")) {
            res.setProvider((ManagedObjectReference) service.querySmsTaskResult(regTask));
            return res;
         }
      }

      throw new RuntimeException("Register timed out");
   }

   private void listProviders() throws Exception {
      List<ManagedObjectReference> providers = service.queryProvider(storageMgr);

      if(providers == null || providers.isEmpty()) {
         System.out.println("No providers found.");
         return;
      }

      for(ManagedObjectReference provider : providers) {
         VasaProviderInfo info =
            (VasaProviderInfo) service.queryProviderInfo(provider);

         System.out.println("Found provider:");
         System.out.println("Name: " + info.getName());
         System.out.println("Url: " + info.getUrl());
         System.out.println("API Version: " + info.getVasaVersion());
         System.out.println("Status: " + info.getStatus());
      }
   }

   private void unregisterProvider() throws Exception {
      VasaProviderInfo info =
         (VasaProviderInfo) service.queryProviderInfo(provider);

      ManagedObjectReference unregTask =
         service.unregisterProviderTask(provider, info.getUid());

      SmsTaskInfo taskInfo = waitForTask(unregTask);
      if(taskInfo != null) {
         if(taskInfo.getState().equals("error")) {
            throw new RuntimeException("Unregister failed");
         } else if(taskInfo.getState().equals("success")) {
            return;
         }
      }

      throw new RuntimeException("Unregister timed out");
   }

   private SmsTaskInfo waitForTask(ManagedObjectReference smsTask) throws Exception {
      SmsTaskInfo info = null;

      int i = 0;
      while(i < MAX_ATTEMPTS) {
         Thread.sleep(SLEEP_INTERVAL);

         info = service.querySmsTaskInfo(smsTask);

         if(info.getState().equals("running")) {
            ++i;
         } else {
            break;
         }
      }

      return info;
   }

   private static void printUsage() {
      System.out.println("This sample demonstrates registration, listing and deregistration of a VASA " +
                         "provider. It requires access to an active VASA provider.");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the vCenter web service.");
      System.out.println("username        [required] : username for authentication with vCenter");
      System.out.println("password        [required] : password for authentication with vCenter");
      System.out.println("provUrl         [required] : url of the VASA provider web service");
      System.out.println("provUsername    [required] : username for authentication with the provider");
      System.out.println("provPassword    [required] : password for authentication with the provider");
      System.out.println("\nCommand:");
      System.out.println("run[.bat|.sh] com.vmware.samples.sms.SampleProvider --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--provUrl [provUrl] --provUsername [provUsername] --provPassword [provPassword]");
   }

   public static void main(String[] args) throws Exception {
      OptionsHelper oh = new OptionsHelper();
      oh.load(args);

      if(oh.isSet("help") || !oh.isSet("url") ||
         !oh.isSet("username") || !oh.isSet("password") ||
         !oh.isSet("provUsername") || !oh.isSet("provPassword") ||
         !oh.isSet("provUrl")) {
         printUsage();
         return;
      }

      String url = oh.get("url");
      String username = oh.get("username");
      String password = oh.get("password");
      String provUsername = oh.get("provUsername");
      String provPassword = oh.get("provPassword");
      String provUrl = oh.get("provUrl");

      SmServiceConnection conn = new SmServiceConnection(url, username, password);
      VasaProviderSpec spec = new VasaProviderSpec();
      spec.setName("VasaProvider");
      spec.setUrl(provUrl);
      spec.setUsername(provUsername);
      spec.setPassword(provPassword);

      SampleProvider prov = new SampleProvider(conn, spec);

      System.out.println("Querying registered providers...");
      prov.listProviders();

      System.out.println("\n\nRegistering provider...");
      prov.registerProvider();

      System.out.println("\n\nQuerying registered providers...");
      prov.listProviders();

      System.out.println("\n\nUnregistering provider...");
      prov.unregisterProvider();

      System.out.println("\n\nQuerying registered providers...");
      prov.listProviders();
   }
}

