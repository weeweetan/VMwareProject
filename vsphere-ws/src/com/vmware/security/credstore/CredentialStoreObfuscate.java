package com.vmware.security.credstore;

import java.util.Random;
import java.io.IOException;

class CredentialStoreObfuscate {
   /*
    * Converts the string into lowercase and return it. This is required so that
    * the hostname is canonicalize before its used in the creation of hash.
    * This is required so that, irrespective of how hostname is specified by user,
    * a uniform representation of hostname is used to obfuscate and de-obfuscate the
    * password.
    */
   private static String canonicalize(String str) {
      return str.toLowerCase();
   }

   /*
    * Let P be the UTF-8 encoding of the password.
    * Let N be the size of P in bytes.
    * Create a byte buffer B of size max(N+1, 128).
    * Copy P followed by a 0 into the beginning of B; fill the rest of B with random bytes.
    * Let H be a hash of host and username equal to the value of the Java expression:
    *      (host+username).hashCode() % 256
    *
    * XOR each element of B with H.
    * Base64-encode B and use the resulting string as the value of the entry.
    */
   public static char[] obfuscate(String hostname, String username, char[] value)
         throws IOException {
      String key = canonicalize(hostname) + username;
      int bufferSize = ((value.length + 1) > 128) ? (value.length + 1) : 128;
      byte[] buffer = new byte[bufferSize];
      int i;

      for (i = 0; i < value.length; ++i) {
         buffer[i] = (byte) value[i];
      }
      buffer[i] = 0;

      Random randObj = new Random();
      for (++i; i < bufferSize; ++i) {
         buffer[i] = (byte) randObj.nextInt();
      }

      byte hashCode = (byte) key.hashCode();
      for (i = 0; i < bufferSize; ++i) {
         buffer[i] = (byte) (buffer[i] ^ hashCode);
      }

      return Base64.encodeToChar(buffer, false);
   }

   public static char[] deObfuscate(String hostname, String username,
         char[] value) throws IOException {
      String key = canonicalize(hostname) + username;

      byte[] decodedVal = Base64.decode(value);

      byte hashCode = (byte) key.hashCode();
      int i;
      for (i = 0; i < decodedVal.length; ++i) {
         decodedVal[i] = (byte) (decodedVal[i] ^ hashCode);
      }
      int pwdLength;
      for (pwdLength = 0; decodedVal[pwdLength] != 0; ++pwdLength)
         ;
      char[] password = new char[pwdLength];
      for (i = 0; i < pwdLength; ++i) {
         password[i] = (char) decodedVal[i];
      }
      return password;
   }

   public static void main(String[] args) {
   }
}
