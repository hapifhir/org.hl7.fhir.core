package org.hl7.fhir.validation.instance.utils;

public class MimeTypeUtil {
  public static String checkValidMimeType(String mt) {
    if (!mt.matches("^(\\w+|\\*)/([\\w-+]+|\\*)((;\\s*(\\w+)=\\s*(\\S+))?)$")) {
      return "Mime type invalid";
    }
    return null;
  }
}
