package org.hl7.fhir.r4.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Disabled
public class JsonDirectTests {

  @Test
  public void test() throws FHIRFormatError {
    assertDoesNotThrow(() -> {
      File src = ManagedFileAccess.file(Utilities.path("[tmp]", "obs.xml"));
      File xml = ManagedFileAccess.file(Utilities.path("[tmp]", "xml.xml"));
      File json = ManagedFileAccess.file(Utilities.path("[tmp]", "json.json"));
      File json2 = ManagedFileAccess.file(Utilities.path("[tmp]", "json2.json"));
      FileUtils.copyFile(ManagedFileAccess.file("C:\\work\\org.hl7.fhir\\build\\publish\\observation-decimal.xml"), src);
      Observation obs = (Observation) new XmlParser().parse(ManagedFileAccess.inStream(src));
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(json), obs);
      obs = (Observation) new JsonParser().parse(ManagedFileAccess.inStream(json));
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(json2), obs);
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(xml), obs);
    });
  }

}