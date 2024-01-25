package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.r4.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;

public class VSACImporter extends OIDBasedValueSetImporter {
  
  public VSACImporter() throws FHIRException, IOException {
    super();
    init();
  }

  public static void main(String[] args) throws FHIRException, IOException, ParseException, URISyntaxException {
    VSACImporter self = new VSACImporter();
    self.process(args[0], args[1], args[2], "true".equals(args[3]));
  }

  private void process(String source, String dest, String apiKey, boolean onlyNew) throws FHIRException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(new FileInputStream(source));
    csv.readHeaders();
    Map<String, String> errs = new HashMap<>();

    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setUsername("apikey");
    fhirToolingClient.setPassword(apiKey);
    fhirToolingClient.setTimeoutNormal(30000);
    fhirToolingClient.setTimeoutExpand(30000);

    CapabilityStatement cs = fhirToolingClient.getCapabilitiesStatement();
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "vsac-capability-statmenet.json")), cs);

    System.out.println("Loading");
    List<String> oids = new ArrayList<>();
    while (csv.line()) {
      String oid = csv.cell("OID");
      if (!onlyNew || !(new File(Utilities.path(dest, "ValueSet-" + oid + ".json")).exists())) {
        oids.add(oid);
      }
    }
    Collections.sort(oids);
    System.out.println("Go: "+oids.size()+" oids");
    int i = 0;
    int j = 0;
    long t = System.currentTimeMillis();
    long tt = System.currentTimeMillis();
    for (String oid : oids) {
      try {
        long t3 = System.currentTimeMillis();
        if (processOid(dest, onlyNew, errs, fhirToolingClient, oid.trim())) {
          j++;
        }
        i++;
        System.out.print(":"+((System.currentTimeMillis() - t3) / 1000));
        if (i % 100 == 0) {
          long elapsed = System.currentTimeMillis() - t;
          System.out.println("");
          System.out.println(i+": "+j+" ("+((j * 100) / i)+"%) @ "+Utilities.describeDuration(elapsed)
              +", "+(elapsed/100000)+"sec/vs, estimated "+Utilities.describeDuration(estimate(i, oids.size(), tt))+" remaining");
          t = System.currentTimeMillis();
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
    System.out.println("Done. " + i + " ValueSets in "+Utilities.describeDuration(System.currentTimeMillis() - tt));
  }

  private long estimate(int i, int size, long tt) {
    long elapsed = System.currentTimeMillis() - tt;
    long average = elapsed / i;
    return (size - i) * average;
  }

  private boolean processOid(String dest, boolean onlyNew, Map<String, String> errs, FHIRToolingClient fhirToolingClient, String oid)
      throws IOException, InterruptedException, FileNotFoundException {
    
      long t = System.currentTimeMillis();
      ValueSet vs = null;
      try {
        vs = fhirToolingClient.read(ValueSet.class, oid);
      } catch (Exception e) {
        errs.put(oid, "Read: " +e.getMessage());
        System.out.println("Read "+oid+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e.getMessage());
        return false;
      }
      t = System.currentTimeMillis();
      try {
        Parameters p = new Parameters();
        p.addParameter("url", new UriType(vs.getUrl()));
        ValueSet vse = fhirToolingClient.expandValueset(vs, p);
        vs.setExpansion(vse.getExpansion());
      } catch (Exception e) {
        errs.put(oid, "Expansion: " +e.getMessage());
        System.out.println("Expand "+oid+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e.getMessage());
      }
      while (isIncomplete(vs.getExpansion())) {
        Parameters p = new Parameters();
        int offset = vs.getExpansion().getParameter("offset").getValueIntegerType().getValue() + vs.getExpansion().getParameter("count").getValueIntegerType().getValue();
        p.addParameter("offset", offset);
        p.addParameter("url", new UriType(vs.getUrl()));
        t = System.currentTimeMillis();
        try {
          ValueSet vse = fhirToolingClient.expandValueset(vs, p);    
          vs.getExpansion().getContains().addAll(vse.getExpansion().getContains());
          vs.getExpansion().setParameter(vse.getExpansion().getParameter());
        } catch (Exception e2) {
          errs.put(oid, "Expansion: " +e2.getMessage()+" @ "+offset);
          System.out.println("Expand "+oid+" @ "+offset+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e2.getMessage());
        } 
      }
      vs.getExpansion().setOffsetElement(null);
      vs.getExpansion().getParameter().clear();


      if (vs.hasTitle()) {
        if (vs.getTitle().equals(vs.getDescription())) {
          vs.setTitle(vs.getName());              
        } else {
          //              System.out.println(oid);
          //              System.out.println("  name: "+vs.getName());
          //              System.out.println("  title: "+vs.getTitle());
          //              System.out.println("  desc: "+vs.getDescription());
        }
      } else {
        vs.setTitle(vs.getName());
      }
      vs.setName(makeValidName(vs.getName()));
      JurisdictionUtilities.setJurisdictionCountry(vs.getJurisdiction(), "US");
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "ValueSet-" + oid + ".json")), vs);
    
    return true;
  }

  private boolean isIncomplete(ValueSetExpansionComponent expansion) {
    IntegerType c = expansion.getParameter("count").getValueIntegerType();
    IntegerType offset = expansion.getParameter("offset").getValueIntegerType();
    return c.getValue() + offset.getValue() < expansion.getTotal();
  }

  private String makeValidName(String name) {
    StringBuilder b = new StringBuilder();
    boolean upper = true;
    for (char ch : name.toCharArray()) {
      if (ch == ' ') {
        upper = true;
      } else if (Character.isAlphabetic(ch)) {
        if (upper) {
          b.append(Character.toUpperCase(ch));
        } else {
          b.append(ch);
        }
        upper = false;
      } else if (Character.isDigit(ch)) {
        if (b.length() == 0) {
          b.append('N');
        }
        b.append(ch);
      } else if (ch == '_' && b.length() != 0) {
        b.append(ch);
      } else {
        upper = true;
      }
    }
//    System.out.println(b.toString()+" from "+name);
    return b.toString();
  }
}
