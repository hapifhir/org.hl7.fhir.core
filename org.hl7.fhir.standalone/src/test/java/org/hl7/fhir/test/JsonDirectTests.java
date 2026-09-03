package org.hl7.fhir.test;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.utilities.formats.JsonCreatorDirect;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Observation;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JsonDirectTests {

  @Test
  @Disabled // Hard coded path here
  void test() throws FHIRFormatError {
    assertDoesNotThrow(() -> {
      File src = ManagedFileAccess.file(Utilities.path("[tmp]", "obs.xml"));
      File xml = ManagedFileAccess.file(Utilities.path("[tmp]", "xml.xml"));
      File json = ManagedFileAccess.file(Utilities.path("[tmp]", "json.json"));
      File json2 = ManagedFileAccess.file(Utilities.path("[tmp]", "json2.json"));
      FileUtils.copyFile(ManagedFileAccess.file("C:\\work\\org.hl7.fhir\\build\\publish\\observation-decimal.xml"), src);
      Observation obs = (Observation) new XmlParser(TestingUtilities.getSharedWorkerContext()).parse(ManagedFileAccess.inStream(src));
      new JsonParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(json), obs);
      obs = (Observation) new JsonParser(TestingUtilities.getSharedWorkerContext()).parse(ManagedFileAccess.inStream(json));
      new JsonParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(json2), obs);
      new XmlParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(xml), obs);
    });
  }

  @Test
  public void testEmptyObject() throws FHIRFormatError, FileNotFoundException, IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    JsonCreatorDirect json = new JsonCreatorDirect(new OutputStreamWriter(bs, "UTF-8"), false, false);
    json.beginObject();
    json.name("a");
    json.beginObject();
    json.endObject();
    json.name("b");
    json.beginArray();
    json.beginObject();
    json.endObject();
    json.beginObject();
    json.endObject();
    json.endArray();
    json.name("c");
    json.beginArray();
    json.endArray();
    json.name("test");
    json.value("test");
    json.endObject();
    json.finish();
    String s = new String(bs.toByteArray());
    Assert.assertEquals("{\"a\":{},\"b\":[{},{}],\"c\":[],\"test\":\"test\"}", s);
  }

}