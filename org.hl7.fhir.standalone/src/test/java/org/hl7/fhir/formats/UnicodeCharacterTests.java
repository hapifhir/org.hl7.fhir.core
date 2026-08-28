package org.hl7.fhir.formats;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class UnicodeCharacterTests {

  @Test
  public void testUnicodeXml() throws FHIRFormatError, IOException {
    XmlParser xml = new XmlParser(TestingUtilities.getSharedWorkerContext());
    xml.setOutputStyle(OutputStyle.PRETTY);
    Parameters p = (Parameters) xml.parse(TestingUtilities.loadTestResource("r5", "unicode-problem.xml"));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
    FileOutputStream o = ManagedFileAccess.outStream(Utilities.path("[tmp]", "unicode-problem.xml"));
    xml.compose(o, p);
    o.close();
    p = (Parameters) xml.parse(ManagedFileAccess.inStream(Utilities.path("[tmp]", "unicode-problem.xml")));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
  }
  

  @Test
  public void testUnicodeJson() throws FHIRFormatError, IOException {
    JsonParser json = new JsonParser(TestingUtilities.getSharedWorkerContext());
    json.setOutputStyle(OutputStyle.PRETTY);
    Parameters p = (Parameters) json.parse(TestingUtilities.loadTestResource("r5", "unicode-problem.json"));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
    FileOutputStream o = ManagedFileAccess.outStream(Utilities.path("[tmp]", "unicode-problem.json"));
    json.compose(o, p);
    o.close();
    p = (Parameters) json.parse(ManagedFileAccess.inStream(Utilities.path("[tmp]", "unicode-problem.json")));
    Assertions.assertEquals("invalid: \u0013, not invalid: \r", p.getParameterFirstRep().getValue().primitiveValue());
  }
  
}
