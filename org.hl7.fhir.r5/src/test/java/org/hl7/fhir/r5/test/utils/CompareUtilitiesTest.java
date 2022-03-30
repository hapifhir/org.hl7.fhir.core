package org.hl7.fhir.r5.test.utils;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CompareUtilitiesTest {

  public static final String EXPECTED_XML_PATH = Paths.get("src","test","resources", "testUtilities", "expected.xml").toAbsolutePath().toString();

  public static final String ACTUAL_DIFF_XML_PATH = Paths.get("src","test","resources", "testUtilities", "actualDiffText.xml").toAbsolutePath().toString();

  @Test
  public void testCheckXMLIsSame() throws Exception {
    String expected = CompareUtilities.checkXMLIsSame(EXPECTED_XML_PATH , EXPECTED_XML_PATH);
    assertNull(expected);

    String actualDiff = CompareUtilities.checkXMLIsSame(EXPECTED_XML_PATH , ACTUAL_DIFF_XML_PATH);
    assertNotNull(actualDiff);
  }
}
