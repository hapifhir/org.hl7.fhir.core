package org.hl7.fhir.standalone.terminology.client;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.utilities.EFhirClientException;
import org.hl7.fhir.model.utilities.formats.IParser;
import org.hl7.fhir.model.utilities.formats.OutputStyle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ByteUtils {

  public static <T extends Resource> byte[] resourceToByteArray(T resource, boolean pretty, boolean isJson, boolean noXhtml, IModelContext context) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    baos = new ByteArrayOutputStream();
    try {
      IParser parser = null;
      if (isJson) {
        parser = new JsonParser(context);
      } else {
        parser = new XmlParser(context);
      }
      parser.setOutputStyle(pretty ? OutputStyle.PRETTY : OutputStyle.NORMAL);
      if (noXhtml) {
        parser.setSuppressXhtml("Narrative removed");
      }      
      parser.compose(baos, resource);
      baos.close();
      byteArray = baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try {
        baos.close();
      } catch (Exception ex) {
        throw new EFhirClientException(0, "Error closing output stream", ex);
      }
      throw new EFhirClientException(0, "Error converting output stream to byte array", e);
    }
    return byteArray;
  }

  public static byte[] encodeFormSubmission(Map<String, String> parameters, String resourceName, Resource resource, String boundary) throws IOException {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    OutputStreamWriter w = new OutputStreamWriter(b, StandardCharsets.UTF_8);
    for (String name : parameters.keySet()) {
      w.write("--");
      w.write(boundary);
      w.write("\r\nContent-Disposition: form-data; name=\"" + name + "\"\r\n\r\n");
      w.write(parameters.get(name) + "\r\n");
    }
    w.write("--");
    w.write(boundary);
    w.write("\r\nContent-Disposition: form-data; name=\"" + resourceName + "\"\r\n\r\n");
    w.close();
    JsonParser json = new JsonParser(resource.getModelContext());
    json.setOutputStyle(OutputStyle.NORMAL);
    json.compose(b, resource);
    b.close();
    w = new OutputStreamWriter(b, StandardCharsets.UTF_8);
    w.write("\r\n--");
    w.write(boundary);
    w.write("--");
    w.close();
    return b.toByteArray();
  }
}
