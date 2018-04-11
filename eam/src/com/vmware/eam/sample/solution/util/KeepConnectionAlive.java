package com.vmware.eam.sample.solution.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class KeepConnectionAlive extends Thread {

   private static Log _logger = LogFactory.getLog(KeepConnectionAlive.class);

   private final VimConnection _vimConnection;
   private final EamConnection _eamConnection;

   public KeepConnectionAlive(VimConnection vimConnection, EamConnection eamConnection) {
      _vimConnection = vimConnection;
      _eamConnection = eamConnection;
      setDaemon(true);
   }

   @Override
   public void run() {
      while (true) {
         if (_vimConnection.isConnected()) {
            // Invoke method to keep the connection alive.
            try {
               _vimConnection.ensureConnection();
            } catch (Exception e) {
               _logger.warn("No VIM connection: " + e.getMessage());
            }
         }
         if (_eamConnection.isConnected()) {
            // Invoke method to keep the connection alive.
            try {
               _eamConnection.getStub().queryAgency(_eamConnection.getEsxAgentManager());
            } catch (Exception e) {
               _logger.warn("No EAM connection: " + e.getMessage());
            }
         }

         // Sleep five minutes
         try {
            Thread.sleep(5 * 60 * 1000);
         } catch (InterruptedException e) {
         }
      }
   }

}
