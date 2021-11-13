package org.hl7.fhir.dstu3.utils.client.network;

import org.hl7.fhir.dstu3.formats.IParser;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.utils.client.EFhirClientException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ByteUtils {

  public static <T extends Resource> byte[] resourceToByteArray(T resource, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if (isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? IParser.OutputStyle.PRETTY : IParser.OutputStyle.NORMAL);
      parser.compose(baos, resource);
      baos.close();
      byteArray = baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try {
        baos.close();
      } catch (Exception ex) {
        throw new EFhirClientException("Error closing output stream", ex);
      }
      throw new EFhirClientException("Error converting output stream to byte array", e);
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
    JsonParser json = new JsonParser();
    json.setOutputStyle(IParser.OutputStyle.NORMAL);
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
