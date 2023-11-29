package org.hl7.fhir.r4.ips;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Base64BinaryType;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IpsBuilderTest {

  @Test
  @Disabled
  @DisplayName("Test IPS Generation")
  void testIpsGeneration() throws URISyntaxException, FileNotFoundException, IOException {
    FHIRToolingClient server = new FHIRToolingClient("https://hl7auconnectathon.salessbx.smiledigitalhealth.com/fhir-request", "FHIR-Validator");
    Bundle bnd = IPSBuilder.generateIPS(server, "wang-li");
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "ips-gen.json")), bnd);
    
  }

}
