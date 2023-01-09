package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuditEvent40_50Test {

  public static final String THE_BASE_64_BINARY_STRING = "dGhpcyBpcyB2YWxpZCBiYXNlNjQ=";
  public static final byte[] THE_BASE_64_BINARY_BYTE_ARRAY = Base64.decodeBase64(THE_BASE_64_BINARY_STRING.getBytes(ca.uhn.fhir.rest.api.Constants.CHARSET_UTF8));

  public static final String INVALID_BASE_64_BINARY_STRING = "Picard was the best starship captain";
  public static final byte[] INVALID_BASE_64_BINARY_BYTE_ARRAY = Base64.decodeBase64(INVALID_BASE_64_BINARY_STRING.getBytes(ca.uhn.fhir.rest.api.Constants.CHARSET_UTF8));


  @Test
  @DisplayName("Test r5 -> r4 AuditEvent conversion.")
  public void testR5_R4() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/auditevent_50_with_base64binary.xml");

    org.hl7.fhir.r5.model.AuditEvent r5_actual = (org.hl7.fhir.r5.model.AuditEvent) new org.hl7.fhir.r5.formats.XmlParser().parse(r5_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_actual);

    org.hl7.fhir.r4.formats.XmlParser r4_parser = new org.hl7.fhir.r4.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4_parser.compose(stream, r4_conv);

    org.hl7.fhir.r4.model.Resource r4_streamed = (org.hl7.fhir.r4.model.AuditEvent) new org.hl7.fhir.r4.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));

    assertArrayEquals(((org.hl7.fhir.r4.model.AuditEvent)r4_conv).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);
    assertArrayEquals(((org.hl7.fhir.r4.model.AuditEvent)r4_streamed).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);
  }

  @Test
  @DisplayName("Test r5 -> r4 AuditEvent conversion.")
  public void testR4_R5() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/auditevent_40_with_base64binary.xml");

    org.hl7.fhir.r4.model.AuditEvent r4_actual = (org.hl7.fhir.r4.model.AuditEvent) new org.hl7.fhir.r4.formats.XmlParser().parse(r4_input);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_actual);

    org.hl7.fhir.r5.formats.XmlParser r5_parser = new org.hl7.fhir.r5.formats.XmlParser();

    ByteArrayOutputStream stream
      = new ByteArrayOutputStream();

    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.AuditEvent) new org.hl7.fhir.r5.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));

    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_conv).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);
    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_streamed).getEntity().get(0).getQuery(), THE_BASE_64_BINARY_BYTE_ARRAY);

  }

  @Test
  @DisplayName("Test r5 -> r4 AuditEvent conversion with invalid Base64Binary.")
  public void testR4_R5BadBase64Binary() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/auditevent_40_with_invalid_base64binary.xml");

    org.hl7.fhir.r4.model.AuditEvent r4_actual = (org.hl7.fhir.r4.model.AuditEvent) new org.hl7.fhir.r4.formats.XmlParser().parse(r4_input);

    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_actual);

    org.hl7.fhir.r5.formats.XmlParser r5_parser = new org.hl7.fhir.r5.formats.XmlParser();

    ByteArrayOutputStream stream
      = new ByteArrayOutputStream();

    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.AuditEvent) new org.hl7.fhir.r5.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));

  

    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_conv).getEntity().get(0).getQuery(), INVALID_BASE_64_BINARY_BYTE_ARRAY);
    assertArrayEquals(((org.hl7.fhir.r5.model.AuditEvent)r5_streamed).getEntity().get(0).getQuery(), INVALID_BASE_64_BINARY_BYTE_ARRAY);

  }
}
