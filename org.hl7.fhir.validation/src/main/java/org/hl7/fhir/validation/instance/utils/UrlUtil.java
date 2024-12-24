package org.hl7.fhir.validation.instance.utils;

import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.instance.utils.Base64Util;

public class UrlUtil {
  public static String checkValidUrl(String value, IWorkerContext context) {
    if (value == null) {
      return null;
    }
    if (Utilities.noString(value)) {
      return context.formatMessage(I18nConstants.XHTML_URL_EMPTY);
    }

    if (value.startsWith("data:")) {
      String[] p = value.substring(5).split("\\,");
      if (p.length < 2) {
        return context.formatMessage(I18nConstants.XHTML_URL_DATA_NO_DATA, value);        
      } else if (p.length > 2) {
        return context.formatMessage(I18nConstants.XHTML_URL_DATA_DATA_INVALID_COMMA, value);                
      } else if (p[0].endsWith(";base64") && !Base64Util.isValidBase64(p[1])) {
        return context.formatMessage(I18nConstants.XHTML_URL_DATA_DATA_INVALID, value);                        
      } else {
        if (p[0].startsWith(" ")) {
          p[0] = Utilities.trimWS(p[0]); 
        }
        String mimetype = (p[0].endsWith(";base64")) ? p[0].substring(0, p[0].lastIndexOf(";")) : p[0];
        if (!mimetype.trim().isEmpty()) {
          String mMsg = MimeTypeUtil.checkValidMimeType(mimetype);
          if (mMsg != null) {
            return context.formatMessage(I18nConstants.XHTML_URL_DATA_MIMETYPE, value, mMsg);                  
          }
        }
      }
      return null;
    } else {
      Set<Character> invalidChars = new HashSet<>();
      int c = 0;
      for (char ch : value.toCharArray()) {
        if (!(Character.isDigit(ch) || Character.isAlphabetic(ch) || Utilities.existsInList(ch, ';', '?', ':', '@', '&', '=', '+', '$', '.', ',', '/', '%', '-', '_', '~', '#', '[', ']', '!', '\'', '(', ')', '*', '|' ))) {
          c++;
          invalidChars.add(ch);
        }
      }
      if (invalidChars.isEmpty()) {
        return null;
      } else {
        Set<String> ss = new HashSet<>();
        for (Character ch : invalidChars) {
          ss.add("'"+ch.toString()+"'");
        }
        return context.formatMessagePlural(c, I18nConstants.XHTML_URL_INVALID_CHARS, CommaSeparatedStringBuilder.join(",", Utilities.sorted(ss)));
      }
    }
  }
}
