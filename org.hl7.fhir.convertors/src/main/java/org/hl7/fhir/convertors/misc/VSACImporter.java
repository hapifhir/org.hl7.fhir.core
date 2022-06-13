package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

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
    Map<String, String> errs = new HashMap<>();

    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setUsername("apikey");
    fhirToolingClient.setPassword(apiKey);
    fhirToolingClient.setTimeout(30000);

    int i = 0;
    int j = 0;
    while (csv.line()) {
      String oid = csv.cell("OID");
      try {
        ValueSet vs = fhirToolingClient.read(ValueSet.class, oid);
        try {
          ValueSet vse = fhirToolingClient.expandValueset(vs.getUrl(), null);
          vs.setExpansion(vse.getExpansion());
          j++;
        } catch (Exception e) {
          errs.put(oid, "Expansion: " +e.getMessage());
          System.out.println(e.getMessage());
        }
        new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "ValueSet-" + oid + ".json")), vs);
        i++;
        if (i % 100 == 0) {
          System.out.println(":"+i+" ("+j+")");
        }
      } catch (Exception e) {
        System.out.println("Unable to fetch OID " + oid + ": " + e.getMessage());
        errs.put(oid, e.getMessage());
      }
    }
    OperationOutcome oo = new OperationOutcome();
    for (String oid : errs.keySet()) {
      oo.addIssue().setSeverity(IssueSeverity.ERROR).setCode(IssueType.EXCEPTION).setDiagnostics(errs.get(oid)).addLocation(oid);
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "other", "OperationOutcome-vsac-errors.json")), oo);
    System.out.println("Done. " + i + " ValueSets");
  }
}
