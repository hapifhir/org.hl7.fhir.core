package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r4.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;

@SuppressWarnings("checkstyle:systemout")
public class VSACImporter extends OIDBasedValueSetImporter {

  public VSACImporter() throws FHIRException, IOException {
    super();
    init();
  }

  public static void main(String[] args) throws FHIRException, IOException, ParseException, URISyntaxException {
    VSACImporter self = new VSACImporter();
    self.process(args[0], args[1], "true".equals(args[2]), "true".equals(args[3]));
  }

  private void process(String source, String dest, boolean onlyNew, boolean onlyActive) throws FHIRException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(ManagedFileAccess.inStream(source));
    csv.readHeaders();
    Map<String, String> errs = new HashMap<>();

    ManagedWebAccess.loadFromFHIRSettings();
    FHIRToolingClient fhirToolingClient = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", "fhir/vsac");
    fhirToolingClient.setTimeoutNormal(30000);
    fhirToolingClient.setTimeoutExpand(30000);

    CapabilityStatement cs = fhirToolingClient.getCapabilitiesStatement();
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", "vsac-capability-statement.json")), cs);

    System.out.println("CodeSystems");
    CodeSystem css = fhirToolingClient.fetchResource(CodeSystem.class, "CDCREC");
    checkHierarchy(fhirToolingClient, css);
    json.setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(dest, "CodeSystem-CDCREC.json")), css);
    css = fhirToolingClient.fetchResource(CodeSystem.class, "CDCNHSN");
    json.setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(dest, "CodeSystem-CDCNHSN.json")), css);
    css = fhirToolingClient.fetchResource(CodeSystem.class, "HSLOC");
    json.setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(dest, "CodeSystem-HSLOC.json")), css);
    css = fhirToolingClient.fetchResource(CodeSystem.class, "SOP");
    json.setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(dest, "CodeSystem-SOP.json")), css);

    System.out.println("Loading");
    List<String> oids = new ArrayList<>();
    List<String> allOids = new ArrayList<>();
    while (csv.line()) {
      String status = csv.cell("Expansion Status");
      if (!onlyActive || "Active".equals(status)) {
        String oid = csv.cell("OID");
        allOids.add(oid);
        if (!onlyNew || !(ManagedFileAccess.file(Utilities.path(dest, "ValueSet-" + oid + ".json")).exists())) {
          oids.add(oid);
        }
      }
    }
    Collections.sort(oids);
    System.out.println("Cleaning");
    cleanValueSets(allOids, dest);
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
        e.printStackTrace();
        System.out.println("Unable to fetch OID " + oid + ": " + e.getMessage());
        errs.put(oid, e.getMessage());
      }
    }

    OperationOutcome oo = new OperationOutcome();
    for (String oid : errs.keySet()) {
      oo.addIssue().setSeverity(IssueSeverity.ERROR).setCode(IssueType.EXCEPTION).setDiagnostics(errs.get(oid)).addLocation(oid);
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(dest, "other", "OperationOutcome-vsac-errors.json")), oo);
    System.out.println();
    System.out.println("Done. " + i + " ValueSets in "+Utilities.describeDuration(System.currentTimeMillis() - tt));
  }

  private void checkHierarchy(FHIRToolingClient client, CodeSystem css) {
    IniFile ini = new IniFile("/Users/grahamegrieve/temp/vsac-cdc-rec.ini");
    System.out.println("hierarchy:");
    List<ConceptDefinitionComponent> codes = new ArrayList<>();
    int c = 0;
    List<ConceptDefinitionComponent> list = new ArrayList<>();
    Map<String,ConceptDefinitionComponent> map = new HashMap<>();
    for (ConceptDefinitionComponent cc : css.getConcept()) {
      list.add(cc);
      map.put(cc.getCode(), cc);
    }
    css.getConcept().clear();
    for (ConceptDefinitionComponent cc : list) {
      String code = cc.getCode();
      ConceptDefinitionComponent parent = map.get(ini.getStringProperty("parents-"+css.getVersion(), code));
      if (parent == null) {
        parent = findParent(client, css, css.getConcept(), code);
        if (parent == null) {
          ini.setStringProperty("parents-"+css.getVersion(), code, "null", null);
        } else {
          ini.setStringProperty("parents-"+css.getVersion(), code, parent.getCode(), null);
        }
        ini.save();
      }
      if (parent == null) {
        css.getConcept().add(cc);
      } else {
        parent.getConcept().add(cc);        
      }

      codes.add(0, cc);
      c++;
      if (c % 20 == 0) {
        System.out.print("."+c);
      }
    }    
    System.out.println("Done. "+c+" concepts");
  }

  private ConceptDefinitionComponent findParent(FHIRToolingClient client, CodeSystem css, List<ConceptDefinitionComponent> concepts, String code) {
    if (concepts.size() == 0) {
      return null;
    }
    ConceptDefinitionComponent last = concepts.get(concepts.size() -1);
    if (last.hasConcept()) {
      ConceptDefinitionComponent parent = findParent(client, css, last.getConcept(), code);
      if (parent != null) {
        return parent;
      }      
    } 

    String reln = getRelationship(client, css, code, last.getCode());
    if ("subsumes".equals(reln)) {
      return last;
    } else {
      for (ConceptDefinitionComponent cc : concepts) {
        reln = getRelationship(client, css, code, cc.getCode());
        if ("subsumes".equals(reln)) {
          return cc;        
        }
      }
      return null;
    }
  }

      
  private String getRelationship(FHIRToolingClient client, CodeSystem css, String codeA, String codeB) {
    Map<String, String> params = new HashMap<>();
    params.put("system", css.getUrl());
    params.put("codeA", codeB);
    params.put("codeB", codeA);    
    Parameters p = client.subsumes(params);
    for (ParametersParameterComponent pp : p.getParameter()) {
      if ("outcome".equals(pp.getName())) {
        return pp.getValue().primitiveValue();
      }
    }
    return null;
  }

  private void cleanValueSets(List<String> allOids, String dest) throws IOException {
    cleanValueSets(allOids, ManagedFileAccess.file(Utilities.path(dest)));
  }

  private void cleanValueSets(List<String> allOids, File file) {
    for (File f : file.listFiles()) {
      if (f.getName().startsWith("ValueSet-")) {
        String oid = f.getName().substring(9).replace(".json", "");
        if (!allOids.contains(oid)) {
          f.delete();
        }
      }
    }

  }

  private long estimate(int i, int size, long tt) {
    long elapsed = System.currentTimeMillis() - tt;
    long average = elapsed / i;
    return (size - i) * average;
  }

  private boolean processOid(String dest, boolean onlyNew, Map<String, String> errs, FHIRToolingClient fhirToolingClient, String oid)
      throws IOException, InterruptedException, FileNotFoundException {

    while (true) {
      boolean ok = true;
      long t = System.currentTimeMillis();
      ValueSet vs = null;
      try {
        vs = fhirToolingClient.read(ValueSet.class, oid);
      } catch (Exception e) {
        if (e.getMessage().contains("timed out")) {
          ok = false;
        } else {
          errs.put(oid, "Read: " +e.getMessage());
          System.out.println("Read "+oid+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e.getMessage());
          return false;
        }
      }
      if (ok) {
        t = System.currentTimeMillis();
        try {
          Parameters p = new Parameters();
          p.addParameter("url", new UriType(vs.getUrl()));
          ValueSet vse = fhirToolingClient.expandValueset(null, p);
          vs.setExpansion(vse.getExpansion());
        } catch (Exception e) {
          if (e.getMessage().contains("timed out")) {
            ok = false;
          } else {
            errs.put(oid, "Expansion: " +e.getMessage());
            System.out.println("Expand "+oid+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e.getMessage());
            return false;
          }
        }
      }
      if (ok) {
        while (isIncomplete(vs.getExpansion())) {
          Parameters p = new Parameters();
          int offset = vs.getExpansion().getParameter("offset").getValueIntegerType().getValue() + vs.getExpansion().getParameter("count").getValueIntegerType().getValue();
          p.addParameter("offset", offset);
          p.addParameter("url", new UriType(vs.getUrl()));
          t = System.currentTimeMillis();
          try {
            ValueSet vse = fhirToolingClient.expandValueset(null, p);    
            vs.getExpansion().getContains().addAll(vse.getExpansion().getContains());
            vs.getExpansion().setParameter(vse.getExpansion().getParameter());
          } catch (Exception e2) {
            if (e2.getMessage().contains("timed out")) {
              ok = false;
              break;
            } else {
              errs.put(oid, "Expansion: " +e2.getMessage()+" @ "+offset);
              System.out.println("Expand "+oid+" @ "+offset+" failed @ "+Utilities.describeDuration(System.currentTimeMillis()-t)+"ms: "+e2.getMessage());
              return false;
            }
          } 
        }
      }
      if (ok) {
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
        if (vs.getUrl().startsWith("https://")) {
          System.out.println("URL is https: "+vs.getUrl());
        }
        vs.setName(makeValidName(vs.getName()));
        JurisdictionUtilities.setJurisdictionCountry(vs.getJurisdiction(), "US");
        new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(ManagedFileAccess.outStream(Utilities.path(dest, "ValueSet-" + oid + ".json")), vs);
        return true;
      }
    }
  }

  private boolean isIncomplete(ValueSetExpansionComponent expansion) {
    IntegerType c = expansion.getParameter("count") != null ? expansion.getParameter("count").getValueIntegerType() : new IntegerType(0);
    IntegerType offset = expansion.getParameter("offset") != null ? expansion.getParameter("offset").getValueIntegerType() : new IntegerType(0);
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
