package org.hl7.fhir.utilities.xhtml;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XhtmlToMdTests {
  @Test
  public void testConvertPage1() throws Exception {
    XhtmlNode page = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "page1.html"), "html");
    XhtmlToMarkdownConverter conv = new XhtmlToMarkdownConverter(false);
    configureConvertor(conv);

    String output = conv.convert(page);
    String expected = BaseTestingUtilities.loadTestResource("xhtml", "page1.md");
    Assertions.assertEquals(expected, output);
  }

  @Test
  public void testConvertPage2() throws Exception {
    XhtmlNode page = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "page2.html"), "html");
    XhtmlToMarkdownConverter conv = new XhtmlToMarkdownConverter(false);
    configureConvertor(conv);

    String output = conv.convert(page);
    String expected = BaseTestingUtilities.loadTestResource("xhtml", "page2.md");
    Assertions.assertEquals(expected, output);
  }
  private static void configureConvertor(XhtmlToMarkdownConverter conv) {
    conv.getImageFilters().add("^tbl_.*");
    conv.getImageFilters().add("^icon_.*");
    conv.getImageFilters().add("^assets\\/*");
    conv.getImageFilters().add("^https://hl7\\.org/.*");
    conv.getImageFilters().add("^tree-filter");
    conv.getIdFilters().add("^segment-header");
    conv.getIdFilters().add("^segment-navbar");
    conv.getIdFilters().add("^segment-footer");
    conv.getIdFilters().add("^ppprofile");
    conv.setIgnoreGeneratedTables(true);
    conv.setAiMode(true);
  }
}
