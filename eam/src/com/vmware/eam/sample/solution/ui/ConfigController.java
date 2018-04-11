/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.ui;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vmware.eam.sample.solution.AgentHandler;
import com.vmware.vsphere.NotFoundFaultMsg;
import com.vmware.vsphere.RuntimeFaultFaultMsg;

@Controller
@RequestMapping("/config.html")
public class ConfigController {

   // agent handler used to apply configuration updates
   private final AgentHandler _agentHandler;

   // Model object used to render config UI
   private final ConfigModel _configModel;

   public ConfigController(AgentHandler agentHandler, ConfigModel configModel) {
      _agentHandler = agentHandler;
      _configModel = configModel;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView retrieveConfig(@RequestParam(value = "message", required = false) String message)
      throws RuntimeFaultFaultMsg {

      /*
       * Update the message to display in the config ui view. The message is
       * only set when doing a redirect from the post method handler. If null no
       * message is displayed (default).
       */
      _configModel.setMessage(message);

      // Make sure configuration is updated
      _agentHandler.updateConfiguration();

      return new ModelAndView("config", "model", _configModel);
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView updateConfig(HttpServletRequest request) throws IOException,
      RuntimeFaultFaultMsg, NotFoundFaultMsg {
      String message = null;
      char[] buf = new char[request.getContentLength()];
      int bytesRead = request.getReader().read(buf);
      // assert bytesRead == buf.length;
      try {
         String[] params = URLDecoder.decode(new String(buf), "UTF-8").split("&");
         if (params.length > 0) {
            if (params[0].startsWith("goalState")) {
               _agentHandler.updateGoalState(params[0]);
               message = _agentHandler.isUnregistered() ? "Solution uninstalled"
                     : "Solution state updated";
            } else {
               _agentHandler.updateConfig(params);
               message = "Solution configuration updated";
            }
         }
      } catch (UnsupportedEncodingException e) {
         assert false;
      }

      if (message != null) {
         return new ModelAndView("redirect:config.html?message=" + message);
      } else {
         return new ModelAndView("redirect:config.html");
      }
   }
}
