package org.hl7.fhir.convertors.conv43_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubscriptionTopic43_50Test {

  @Test
  @DisplayName("Test r5 -> r4b SubscriptionTopic conversion.")
  public void testR5_R4b() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/subscription_topic_50.json");

    org.hl7.fhir.r5.model.SubscriptionTopic r5_actual = (org.hl7.fhir.r5.model.SubscriptionTopic) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.r4b.model.Resource r4b_conv = VersionConvertorFactory_43_50.convertResource(r5_actual);

    org.hl7.fhir.r4b.formats.JsonParser r4b_parser = new org.hl7.fhir.r4b.formats.JsonParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4b_parser.compose(stream, r4b_conv);

    org.hl7.fhir.r4b.model.Resource r4b_streamed = new org.hl7.fhir.r4b.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4b_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }

  @Test
  @DisplayName("Test r4b -> r5 SubscriptionTopic conversion.")
  public void testR4b_R5() throws IOException {
    InputStream r4b_input = this.getClass().getResourceAsStream("/subscription_topic_43.json");

    org.hl7.fhir.r4b.model.SubscriptionTopic r4b_actual = (org.hl7.fhir.r4b.model.SubscriptionTopic) new org.hl7.fhir.r4b.formats.JsonParser().parse(r4b_input);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4b_actual);

    org.hl7.fhir.r5.formats.JsonParser r5_parser = new org.hl7.fhir.r5.formats.JsonParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5_streamed = new org.hl7.fhir.r5.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r4b.model.Resource r4b_conv = VersionConvertorFactory_43_50.convertResource(r5_streamed);

    assertTrue(r4b_actual.equalsDeep(r4b_conv), "should be the same");
  }
}
