package org.hl7.fhir.r5.formats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnicodeCharacterTests {

  @Test
  public void testUnicodeXml() throws FHIRFormatError, IOException {
    XmlParser xml = new XmlParser();
    xml.setOutputStyle(OutputStyle.PRETTY);
    Parameters p = (Parameters) xml.parse(TestingUtilities.loadTestResource("r5", "unicode-problem.xml"));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
    FileOutputStream o = new FileOutputStream(Utilities.path("[tmp]", "unicode-problem.xml"));
    xml.compose(o, p);
    o.close();
    p = (Parameters) xml.parse(new FileInputStream(Utilities.path("[tmp]", "unicode-problem.xml")));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
  }
  

  @Test
  public void testUnicodeJson() throws FHIRFormatError, IOException {
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    Parameters p = (Parameters) json.parse(TestingUtilities.loadTestResource("r5", "unicode-problem.json"));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
    FileOutputStream o = new FileOutputStream(Utilities.path("[tmp]", "unicode-problem.json"));
    json.compose(o, p);
    o.close();
    p = (Parameters) json.parse(new FileInputStream(Utilities.path("[tmp]", "unicode-problem.json")));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
  }
  
}
