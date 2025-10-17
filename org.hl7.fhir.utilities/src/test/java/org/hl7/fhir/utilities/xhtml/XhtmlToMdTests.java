package org.hl7.fhir.utilities.xhtml;

import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XhtmlToMdTests {
  @Test
  public void testConvertPage1() throws Exception {
    XhtmlNode page = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "page1.html"), "html");
    XhtmlToMarkdownConverter conv = new XhtmlToMarkdownConverter(false);
    conv.configureForIGs(false);

    String output = conv.convert(page);
    String expected = BaseTestingUtilities.loadTestResource("xhtml", "page1.md");
//    FileUtilities.stringToFile(output, "/Users/grahamegrieve/work/test-cases/xhtml/page1.output.md");
    Assertions.assertEquals(expected, output);
  }

  @Test
  public void testConvertPage2() throws Exception {
    XhtmlNode page = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "page2.html"), "html");
    XhtmlToMarkdownConverter conv = new XhtmlToMarkdownConverter(false);
    conv.configureForIGs(false);

    String output = conv.convert(page);
    String expected = BaseTestingUtilities.loadTestResource("xhtml", "page2.md");
//    FileUtilities.stringToFile(output, "/Users/grahamegrieve/work/test-cases/xhtml/page2.output.md");
    Assertions.assertEquals(expected, output);
  }
  @Test
  public void testConvertPage3() throws Exception {
    XhtmlNode page = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "page3.html"), "html");
    XhtmlToMarkdownConverter conv = new XhtmlToMarkdownConverter(false);
    conv.configureForIGs(false);

    String output = conv.convert(page);
    String expected = BaseTestingUtilities.loadTestResource("xhtml", "page3.md");
//    FileUtilities.stringToFile(output, "/Users/grahamegrieve/work/test-cases/xhtml/page3.output.md");
    Assertions.assertEquals(expected, output);
  }
}
