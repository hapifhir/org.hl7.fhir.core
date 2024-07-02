package org.hl7.fhir.validation.instance.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64InputStream;

import org.hl7.fhir.utilities.Utilities;

public class Base64Util {
   /**
   * Technically this is not bulletproof as some invalid base64 won't be caught,
   * but I think it's good enough. The original code used Java8 Base64 decoder
   * but I've replaced it with a regex for 2 reasons:
   * 1. This code will run on any version of Java
   * 2. This code doesn't actually decode, which is much easier on memory use for big payloads
   */
  public static boolean isValidBase64(String theEncoded) {
    if (theEncoded == null) {
      return false;
    }
    int charCount = 0;
    boolean ok = true;
    for (int i = 0; i < theEncoded.length(); i++) {
      char nextChar = theEncoded.charAt(i);
      if (Utilities.isWhitespace(nextChar)) {
        continue;
      }
      if (Character.isLetterOrDigit(nextChar)) {
        charCount++;
      }
      if (nextChar == '/' || nextChar == '=' || nextChar == '+') {
        charCount++;
      }
    }

    if (charCount > 0 && charCount % 4 != 0) {
      ok = false;
    }
    return ok;
  }

  public static boolean base64HasWhitespace(String theEncoded) {
    if (theEncoded == null) {
      return false;
    }
    for (int i = 0; i < theEncoded.length(); i++) {
      char nextChar = theEncoded.charAt(i);
      if (Utilities.isWhitespace(nextChar)) {
        return true;
      }
    }
    return false;
  }

  public static int countBase64DecodedBytes(String theEncoded) {
    Base64InputStream inputStream = new Base64InputStream(new ByteArrayInputStream(theEncoded.getBytes(StandardCharsets.UTF_8)));
    try {
      try {
        for (int counter = 0; ; counter++) {
          if (inputStream.read() == -1) {
            return counter;
          }
        }
      } finally {
          inputStream.close();
      }
    } catch (IOException e) {
      throw new IllegalStateException(e); // should not happen
    }
  }

}
