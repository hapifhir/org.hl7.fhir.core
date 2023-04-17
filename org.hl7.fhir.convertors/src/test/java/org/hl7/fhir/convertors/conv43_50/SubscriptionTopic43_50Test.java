package org.hl7.fhir.convertors.conv43_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscriptionTopic43_50Test {

  @Test
  @DisplayName("Test r5 -> r4 SubscriptionTopic conversion.")
  public void testR5_R4() throws IOException {
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

}
