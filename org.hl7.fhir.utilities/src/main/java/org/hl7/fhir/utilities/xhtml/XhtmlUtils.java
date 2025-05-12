package org.hl7.fhir.utilities.xhtml;

public class XhtmlUtils {

  public static String convertHtmlToText(String source, String desc) {
    try {
      XhtmlDocument doc = new XhtmlParser().parse(source, "html");
      return doc.getDocumentElement().allText();
    } catch (Exception e) {
      // todo - should we try another way?
      System.err.println("XHTML content could not be parsed from "+desc);
      e.printStackTrace();
      System.err.println(source);
      return "Unparseable HTML";
    }
  }

}
