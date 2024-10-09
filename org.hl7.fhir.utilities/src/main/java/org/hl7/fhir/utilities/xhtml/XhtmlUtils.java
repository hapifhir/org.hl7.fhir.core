package org.hl7.fhir.utilities.xhtml;

public class XhtmlUtils {

  public static String convertHtmlToText(String source) {
    try {
      XhtmlDocument doc = new XhtmlParser().parse(source, "html");
      return doc.getDocumentElement().allText();
    } catch (Exception e) {
      e.printStackTrace();
      // todo - should we try another way?
      return "Unparseable HTML";
    }
  }

}
