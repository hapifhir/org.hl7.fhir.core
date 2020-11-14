package org.hl7.fhir.r5.utils.client.network;

import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;

import java.io.ByteArrayOutputStream;

public class ByteArrayUtils {

  public static <T extends Resource> byte[] resourceToByteArray(T resource, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if(isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? IParser.OutputStyle.PRETTY : IParser.OutputStyle.NORMAL);
      parser.compose(baos, resource);
      baos.close();
      byteArray =  baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try{
        baos.close();
      }catch(Exception ex) {
        throw new EFhirClientException("Error closing output stream", ex);
      }
      throw new EFhirClientException("Error converting output stream to byte array", e);
    }
    return byteArray;
  }

  //TODO Might not need this
//  public byte[] getFeedAsByteArray(Bundle feed, boolean pretty, boolean isJson) {
//    ByteArrayOutputStream baos = null;
//    byte[] byteArray = null;
//    try {
//      baos = new ByteArrayOutputStream();
//      IParser parser = null;
//      if(isJson) {
//        parser = new JsonParser();
//      } else {
//        parser = new XmlParser();
//      }
//      parser.setOutputStyle(pretty ? IParser.OutputStyle.PRETTY : IParser.OutputStyle.NORMAL);
//      parser.compose(baos, feed);
//      baos.close();
//      byteArray =  baos.toByteArray();
//      baos.close();
//    } catch (Exception e) {
//      try{
//        baos.close();
//      }catch(Exception ex) {
//        throw new EFhirClientException("Error closing output stream", ex);
//      }
//      throw new EFhirClientException("Error converting output stream to byte array", e);
//    }
//    return byteArray;
//  }

}
