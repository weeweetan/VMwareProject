package com.vmware.apputils;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
* Simple utility to parse and retrieve command line options.
*/
public class OptionsHelper {
   private Map<String, String> optionsMap = new HashMap<String, String>();

   /**
    * Parses options from the given list of strings.
    * @param input string array containing options. It is expected
    *              to be of the format:
    * input[x] == "--optName",
    * input[x + 1] == "optValue"
    */
   public void load(String[] input) throws Exception {
      List<String> options = Arrays.asList(input);

      int len = options.size();
      int i = 0;

      if (len == 0) {
         return;
      }

      while (i < options.size()) {
         String val = "";
         String opt = options.get(i);
         if (opt.startsWith("--") && optionsMap.containsKey(opt.substring(2))) {
            String msg = "Duplicate key : " + opt.substring(2);
            throw new IllegalArgumentException(msg);
         }

         if (options.get(i).startsWith("--")) {
            if (options.size() > i + 1) {
               if (!options.get(i + 1).startsWith("--")) {
                  val = options.get(i + 1);
                  optionsMap.put(opt.substring(2), val);
               } else {
                  optionsMap.put(opt.substring(2), null);
               }
            } else {
               optionsMap.put(opt.substring(2), null);
            }
         }
         i++;
      }
   }

   /**
    * Retrieves option value corresponding to given key.
    * 
    * @param optionKey name of the option
    * 
    * @return String option value
    */
   public String get(String optionKey) {
      return optionsMap.get(optionKey);
   }

   /**
    * Verifies if an option by the given name is present.
    * @param optionName name of the options
    * 
    * @return boolean
    */
   public boolean isSet(String optionName) {
      return optionsMap.containsKey(optionName);
   }
}
