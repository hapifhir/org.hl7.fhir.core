package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

public class VSACImporter extends OIDBasedValueSetImporter {

  public VSACImporter() throws FHIRException, IOException {
    super();
    init();
  }

  public static void main(String[] args) throws FHIRException, IOException, ParseException, URISyntaxException {
    VSACImporter self = new VSACImporter();
    self.process(args[0], args[1], args[2]);
  }

  private void process(String source, String dest, String apiKey) throws FHIRException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(new FileInputStream(source));
    csv.readHeaders();

    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setUsername("apikey");
    fhirToolingClient.setPassword(apiKey);

    int i = 0;
    while (csv.line()) {
      String oid = csv.cell("OID");
      try {
        ValueSet vs = fhirToolingClient.read(ValueSet.class, oid);
        new JsonParser().compose(new FileOutputStream(Utilities.path(dest, "ValueSet-" + oid + ".json")), vs);
        i++;
        if (i % 100 == 0) {
          System.out.println(i);
        }
      } catch (Exception e) {
        System.out.println("Unable to fetch OID " + oid + ": " + e.getMessage());
      }
    }
    System.out.println("Done. " + i + " ValueSets");
  }
}
