package org.hl7.fhir.convertors.conv43_50;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorDefinition43_50Test {

  @Test
  @DisplayName("Test r5 -> r4 ActorDefinition conversion.")
  public void testR5_R4() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/actordefinition_50_example.json");

    org.hl7.fhir.r5.model.ActorDefinition r5_actual = (org.hl7.fhir.r5.model.ActorDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.r4b.model.Resource r4_conv = VersionConvertorFactory_43_50.convertResource(r5_actual);

    org.hl7.fhir.r4b.formats.XmlParser r4_parser = new org.hl7.fhir.r4b.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4_parser.compose(stream, r4_conv);

    org.hl7.fhir.r4b.model.Resource r4_streamed = (org.hl7.fhir.r4b.model.Basic) new org.hl7.fhir.r4b.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }

//  @Test
//  @DisplayName("Test r5 -> r4 AuditEvent conversion.")
//  public void testR4_R5() throws IOException {
//    InputStream r4_input = this.getClass().getResourceAsStream("/auditevent_40_with_base64binary.xml");
//
//    org.hl7.fhir.r4b.model.AuditEvent r4_actual = (org.hl7.fhir.r4b.model.AuditEvent) new org.hl7.fhir.r4b.formats.XmlParser().parse(r4_input);
//    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4_actual);
//
//    org.hl7.fhir.r5.formats.XmlParser r5_parser = new org.hl7.fhir.r5.formats.XmlParser();
//
//    ByteArrayOutputStream stream
//      = new ByteArrayOutputStream();
//
//    r5_parser.compose(stream, r5_conv);
//
//    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.AuditEvent) new org.hl7.fhir.r5.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
//
//    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_conv).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);
//    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_streamed).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);
//
//  }
//
//  @Test
//  @DisplayName("Test r5 -> r4 AuditEvent conversion with invalid Base64Binary.")
//  public void testR4_R5BadBase64Binary() throws IOException {
//    InputStream r4_input = this.getClass().getResourceAsStream("/auditevent_40_with_invalid_base64binary.xml");
//
//    org.hl7.fhir.r4b.model.AuditEvent r4_actual = (org.hl7.fhir.r4b.model.AuditEvent) new org.hl7.fhir.r4b.formats.XmlParser().parse(r4_input);
//
//    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4_actual);
//
//    org.hl7.fhir.r5.formats.XmlParser r5_parser = new org.hl7.fhir.r5.formats.XmlParser();
//
//    ByteArrayOutputStream stream
//      = new ByteArrayOutputStream();
//
//    r5_parser.compose(stream, r5_conv);
//
//    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.AuditEvent) new org.hl7.fhir.r5.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
//
//    System.out.println(((org.hl7.fhir.r5.model.AuditEvent)r5_conv).getEntity().get(0).getQueryElement().getValueAsString());
//
//    //FIXME we should not be even getting this far.
//    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_conv).getEntity().get(0).getQuery(), INVALID_BASE_64_BINARY_BYTE_ARRAY);
//    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_streamed).getEntity().get(0).getQuery(), INVALID_BASE_64_BINARY_BYTE_ARRAY);
//
//  }
}
