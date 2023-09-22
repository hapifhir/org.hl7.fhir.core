package org.hl7.fhir.convertors.misc;

import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.elementmodel.Manager;
import org.hl7.fhir.r4.formats.FormatUtilities;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.utils.BatchLoader;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

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
    fhirToolingClient.setTimeout(600000);

    int i = 0;
    int j = 0;
    while (csv.line()) {
      String oid = csv.cell("OID");
      try {
        if (!onlyNew || !(new File(Utilities.path(dest, "ValueSet-" + oid + ".json")).exists())) {
          ValueSet vs = fhirToolingClient.read(ValueSet.class, oid);
          try {
            ValueSet vse = fhirToolingClient.expandValueset(vs.getUrl(), null);
            vs.setExpansion(vse.getExpansion());
            j++;
          } catch (Exception e) {
            errs.put(oid, "Expansion: " +e.getMessage());
            System.out.println(e.getMessage());
          }
          if (vs.hasTitle()) {
            if (vs.getTitle().equals(vs.getDescription())) {
              vs.setTitle(vs.getName());              
            } else {
              System.out.println(oid);
              System.out.println("  name: "+vs.getName());
              System.out.println("  title: "+vs.getTitle());
              System.out.println("  desc: "+vs.getDescription());
            }
          } else {
            vs.setTitle(vs.getName());
          }
          vs.setName(makeValidName(vs.getName()));
          FormatUtilities.makeParser(Manager.FhirFormat.JSON).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "ValueSet-" + oid + ".json")), vs);
        }
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
    FormatUtilities.makeParser(Manager.FhirFormat.JSON).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "other", "OperationOutcome-vsac-errors.json")), oo);
    System.out.println("Done. " + i + " ValueSets");
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
    System.out.println(b.toString()+" from "+name);
    return b.toString();
  }

  /**
   * Generates expansions of a provided list of VSAC value sets and writes details of the value set expansions (including the code systems used) to an output file.
   */
  public void getValueSetList(File inputFile, String apiKey, String separator, File outputFile) throws FHIRException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(new FileInputStream(inputFile));
    csv.readHeaders();
    Map<String, String> errs = new HashMap<>();

    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setUsername("apikey");
    fhirToolingClient.setPassword(apiKey);
    fhirToolingClient.setTimeout(360000);

    int i = 0;
    BufferedWriter bwr = new BufferedWriter(new FileWriter(outputFile));

    String csvOutputHeader = ("NUM" + separator + "OID" + separator + "Name" + separator + "Title" + separator + "URL" + separator + "Version" + separator + "Status" + separator + "Code systems in expansion" + separator + "Code systems in expansion");
    bwr.write(csvOutputHeader + "\n");
    bwr.flush();

    long startTime = System.currentTimeMillis();
    while (csv.line()) {
      StringBuffer csvOutputLine = new StringBuffer();
      csvOutputLine.append(i+1).append(separator);
      String oid = csv.cell("OID");
      csvOutputLine.append(oid).append(separator);
      try {
          ValueSet vs = fhirToolingClient.read(ValueSet.class, oid);
          if (vs.getName() != null) {
            csvOutputLine.append(vs.getName()).append(separator);
          } else {
            csvOutputLine.append("No 'name' Value").append(separator);
          }
          if (vs.getTitle() != null) {
            csvOutputLine.append(vs.getTitle()).append(separator);
          } else {
            csvOutputLine.append("No 'title' Value").append(separator);
          }
          if (vs.getUrl() != null) {
            csvOutputLine.append(vs.getUrl()).append(separator);
          } else {
            csvOutputLine.append("No 'url' Value").append(separator);
          }
          if (vs.getVersion() != null) {
            csvOutputLine.append(vs.getVersion()).append(separator);
          } else {
            csvOutputLine.append("No 'version' Value").append(separator);
          }
          if (vs.getStatus() != null) {
            csvOutputLine.append(vs.getStatus()).append(separator);
          } else {
            csvOutputLine.append("No 'status' Value").append(separator);
          }
        ValueSet vse = null;
        try {
          vse = fhirToolingClient.expandValueset(vs.getUrl(), null);
        } catch (Exception e) {
          e.printStackTrace();
        }

          if (vse != null) {
          if (vse.getCompose() != null && vse.getExpansion().getContains() != null) {
            List<String> systems = new ArrayList<String>();
            for (ValueSet.ValueSetExpansionContainsComponent nextInclude : vse.getExpansion().getContains()) {
              if (nextInclude.getSystem() != null) {
                if (nextInclude.getVersion() != null) {
                  String systemAndVersion = nextInclude.getSystem() + "|" + nextInclude.getVersion();
                  if (!systems.contains(systemAndVersion)) {
                    systems.add(systemAndVersion);
                  }
                } else {
                  if (!systems.contains(nextInclude.getSystem())) {
                    systems.add(nextInclude.getSystem());
                  }
                }
              }
            }
            csvOutputLine.append(systems.size()).append(separator);
            for (String containedSystem : systems) {
              csvOutputLine.append(containedSystem).append(separator);
            }
            csvOutputLine.append("\n");
          }
          bwr.write(csvOutputLine.toString());
          bwr.flush();
        }
        i++;
      } catch (Exception e) {
        System.out.println("Unable to fetch OID " + oid + ": " + e.getMessage());
        errs.put(oid, e.getMessage());
      }
    }
    long timeTakenMs = System.currentTimeMillis() - startTime;
    System.out.println("Done. " + i + " ValueSets in " + timeTakenMs + " milliseconds.");
  }

  /**
   * Download VSAC code systems as FHIR CodeSystem resources.
   */
  public void getCodeSystems(File inputFile, String apiKey, String fhirFormat, File destinationFolder) throws FHIRException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(new FileInputStream(inputFile));
    csv.readHeaders();
    Map<String, String> errs = new HashMap<>();

    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setUsername("apikey");
    fhirToolingClient.setPassword(apiKey);
    fhirToolingClient.setTimeout(360000);

    int i = 0;
    long startTime = System.currentTimeMillis();
    while (csv.line()) {
      String id = csv.cell("id");
      String vid = csv.cell("vid");
      String filenamePrefix = csv.cell("filenamePrefix");
      try {
          CodeSystem cs = fhirToolingClient.vread(CodeSystem.class, id, vid);
          Manager.FhirFormat format = null;
          switch (fhirFormat) {
            case "json" : {
              format = Manager.FhirFormat.JSON;
              break;
            }
            case "xml" : {
              format = Manager.FhirFormat.XML;
              break;
            }
            default: {
              format = Manager.FhirFormat.JSON;
            }
          }
          FormatUtilities.makeParser(format).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(destinationFolder, filenamePrefix + "-" + id + "-" + vid + "." + fhirFormat)), cs);
        i++;
      } catch (Exception e) {
        System.out.println("Unable to fetch code systems with id " + id + " and vid " + vid + ": " + e.getMessage());
        errs.put(id + ":" + vid, e.getMessage());
      }
    }
    OperationOutcome oo = new OperationOutcome();
    for (String oid : errs.keySet()) {
      oo.addIssue().setSeverity(IssueSeverity.ERROR).setCode(IssueType.EXCEPTION).setDiagnostics(errs.get(oid)).addLocation(oid);
    }
    FormatUtilities.makeParser(Manager.FhirFormat.JSON).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(destinationFolder, "OperationOutcome-vsac-errors.json")), oo);
    long timeTakenMs = System.currentTimeMillis() - startTime;
    System.out.println("Downloaded " + i + " VSAC code systems in " + timeTakenMs + " milliseconds.");
  }
}
