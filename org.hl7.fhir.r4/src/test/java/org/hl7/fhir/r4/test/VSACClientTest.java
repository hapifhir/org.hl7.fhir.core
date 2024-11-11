package org.hl7.fhir.r4.test;

import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

public class VSACClientTest {
  @Test
  public void testVSAC() throws URISyntaxException {
    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setTimeoutNormal(30000);
    fhirToolingClient.setTimeoutExpand(30000);
    CapabilityStatement cs = fhirToolingClient.getCapabilitiesStatement();
    System.out.println(cs);
  }
}
