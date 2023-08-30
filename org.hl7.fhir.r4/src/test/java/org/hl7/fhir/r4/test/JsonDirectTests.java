package org.hl7.fhir.r4.test;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;

@Disabled
public class JsonDirectTests {

  @Test
  public void test() throws FHIRFormatError, FileNotFoundException, IOException {
    File src = new File(Utilities.path("[tmp]", "obs.xml"));
    File xml = new File(Utilities.path("[tmp]", "xml.xml"));
    File json = new File(Utilities.path("[tmp]", "json.json"));
    File json2 = new File(Utilities.path("[tmp]", "json2.json"));
    FileUtils.copyFile(new File("C:\\work\\org.hl7.fhir\\build\\publish\\observation-decimal.xml"), src);
    Observation obs = (Observation) new XmlParser().parse(new FileInputStream(src));
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(json), obs);
    obs = (Observation) new JsonParser().parse(new FileInputStream(json));
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(json2), obs);
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(xml), obs);
  }

}