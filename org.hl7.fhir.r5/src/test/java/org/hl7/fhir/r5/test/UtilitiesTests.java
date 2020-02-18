package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.lang3.SystemUtils;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.junit.Test;

import junit.framework.Assert;

public class UtilitiesTests {

  private static final String XHTML_SIMPLE = "<div>Some Text</div>";
  private static final String XHTML_LANGS = "<div xml:lang=\"en-US\" lang=\"en-US\">Some Text</div>";

  @Test
  public void testPath() throws IOException {
    Assert.assertEquals(Utilities.path("[tmp]", "test.txt"),  SystemUtils.IS_OS_WINDOWS ? "c:\\temp\\test.txt" : "/tmp/test.txt");
    Assert.assertEquals(Utilities.path("[user]", "test.txt"), System.getProperty("user.home")+"\\test.txt");
    Assert.assertEquals(Utilities.path("[JAVA_HOME]", "test.txt"), System.getenv("JAVA_HOME")+File.separator+"test.txt");
  }

  @Test
  public void testXhtmlLangAttributes() throws IOException {
    run(XHTML_SIMPLE);
    run(XHTML_LANGS);    
  }

  public void run(String src) throws IOException {
    XhtmlNode node = new XhtmlParser().parse(src, "div");
    String xhtml = new XhtmlComposer(false).compose(node);
    Assert.assertTrue(src.equals(xhtml));
  }
}
