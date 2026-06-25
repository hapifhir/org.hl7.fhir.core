package org.hl7.fhir.validation.instance.utils;

public class MimeTypeUtil {
  public static String checkValidMimeType(String mt) {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //anchored MIME type format, safe
    boolean validMimeType = mt.matches("^(\\w+|\\*)/([\\w-+]+|\\*)((;\\s*(\\w+)=\\s*(\\S+))?)$");
    if (!validMimeType) {
      return "Mime type invalid";
    }
    return null;
  }
}
