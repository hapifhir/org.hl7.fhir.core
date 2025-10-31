package org.hl7.fhir.r5.tools;

import java.io.IOException;
import java.util.Arrays;

import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.primitives.Bytes;

class TestCasesSerializer {

  @Test
  void testJson() throws IOException {
    ToolsRegistration.register();
    byte[] cnt = TestingUtilities.loadTestResourceBytes("r5", "testcases.json");
    TestCases tc = (TestCases) new JsonParser().parse(cnt);
    byte[] cnt2 = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(tc);
    if (!Arrays.equals(cnt, cnt2)) {
      JsonObject j1 = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cnt);
      JsonObject j2 = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cnt2);
      String msg = j1.compareTo(j2);
      Assertions.assertNull(msg, msg);
    }
  }

  @Test
  void testXml() throws IOException {
    ToolsRegistration.register();
    byte[] cnt = TestingUtilities.loadTestResourceBytes("r5", "testcases.xml");
    TestCases tc = (TestCases) new XmlParser().parse(cnt);
    byte[] cnt2 = new XmlParser().composeBytes(tc);
    if (!Arrays.equals(cnt, cnt2)) {
      String x1 = new String(cnt);
      String x2 = new String(cnt2);
      Assertions.assertEquals(x1, x2);
    }
  }

}
