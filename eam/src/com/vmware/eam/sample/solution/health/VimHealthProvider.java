/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.health;

/**
 *  An interface used by the HealthStatusServlet to collect
 *  status from a provider and integrate it with the vCenter
 *  health monitoring.
 *
 */
public interface VimHealthProvider {

   /** Constant for ALERT level */
   public final String LEVEL_ALERT   = "alert";

   /** Constant for WARNING level */
   public final String LEVEL_WARNING = "warning";

   /** Constant for INFO level */
   public final String LEVEL_INFO    = "info";

   /**
    *  A helper class to encapsulate the VIM health
    */
   public static class VimHealth {
      private String _level;
      private String _message;

      /**
       *   Creates an instance with level = INFO and message = "Running".
       */
      public VimHealth() {
         this(LEVEL_INFO, "Running");
      }

      /**
       * Creates an instance
       *
       * @param level the health level (alert/warning/info)
       * @param message a message to describe the error
       */
      public VimHealth(String level, String message) {
         super();
         _level = level;
         _message = message;
      }

      /**
       * @param level
       */
      public void setLevel(String level) {
         _level = level;
      }

      /**
       * @return the health level (red/yellow/green)
       */
      public String getLevel() {
         return _level;
      }

      /**
       * @param message the message to display
       */
      public void setMessage(String message) {
         _message = message;
      }

      /**
       * @return the message
       */
      public String getMessage() {
         return _message;
      }

      @Override
      public String toString() {
         return _level + ":" + _message;
      }
   }

   /**
    * @return the current VIM Health
    */
   public VimHealth getVimHealth();
}
