package org.hl7.fhir.utilities.xhtml;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XhtmlUtils {

  public static String convertHtmlToText(String source, String desc) {
    try {
      XhtmlDocument doc = new XhtmlParser().setMustBeWellFormed(false).parse(source, "html");
      return doc.getDocumentElement().allText();
    } catch (Exception e) {
      // todo - should we try another way?
      log.error("XHTML content could not be parsed from "+desc, e);
      log.error(source);
      return "Unparseable HTML Source ("+e.getMessage()+")";
    }
  }

}
