package org.hl7.fhir.convertors.txClient;

import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.utilities.FhirPublication;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerminologyClientFactoryTest {
  @Test
  public void testMakeClient() throws URISyntaxException {
    TerminologyClient terminologyClient = TerminologyClientFactory.makeClient("https://tx.fhir.org", "dummyUserAgent", FhirPublication.R4);
    String expectedAddress = "https://tx.fhir.org/r4";
    assertEquals(expectedAddress, terminologyClient.getAddress());
  }
}
