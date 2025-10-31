package org.hl7.fhir.convertors.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.PackageContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.xml.sax.SAXException;

@SuppressWarnings("checkstyle:systemout")
public class VSACFinder implements IPackageVisitorProcessor {

  public static void main(String[] args) throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    new VSACFinder().execute();

  }
  
  private class VsacVS {
    private String oid;
    private String steward;
    private String status;
    private Set<String> used = new HashSet<>();
    
    public void use(String pid) {
      used.add(pid);  
    }
  }
  
  private Map<String, VsacVS> oids = new HashMap<>();

  private void execute() throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    loadVSACOids();
    PackageVisitor pv = new PackageVisitor();
    pv.setCorePackages(false);
    pv.setClientPackageServer(PackageServer.secondaryServer());
    pv.setResourceTypes("StructureDefinition", "ValueSet");
    pv.setProcessor(this);
    pv.visitPackages();
    for (String oid : Utilities.sorted(oids.keySet())) {
      VsacVS vs = oids.get(oid);
      if (!vs.used.isEmpty()) {
        System.out.println("* "+oid+" ("+vs.status+") @ "+vs.steward+" used by "+vs.used.toString());
      }
    }
  }

  private void loadVSACOids() throws FHIRException, FileNotFoundException, IOException {
    CSVReader csv = new CSVReader(new FileInputStream("/Users/grahamegrieve/Downloads/valuesets.csv"));
    csv.readHeaders();
    while (csv.line()) {
      VsacVS vvs = new VsacVS();
      vvs.oid = csv.cell("OID");
      vvs.steward = csv.cell("Steward");
      vvs.status = csv.cell("Expansion Status");
      oids.put("http://cts.nlm.nih.gov/fhir/ValueSet/"+vvs.oid, vvs);
    }
  }

  @Override
  public Object startPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {
    if (usesVSAC(context.getNpm())) {
      System.out.println(context.getPid()+" uses VSAC");
      return this;
    } else {
      return null;
    }
  }

  private boolean usesVSAC(NpmPackage npm) {
    if (npm != null) {
      for (String s : npm.dependencies()) {
        if (s.contains("vsac")) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content)
      throws FHIRException, IOException, EOperationOutcome {
    if (clientContext != null) {
      JsonObject r = JsonParser.parseObject(content);
      if ("StructureDefinition".equals(type)) {
        JsonObject diff = r.getJsonObject("differential");
        if (diff != null) {
          for (JsonObject ed : diff.getJsonObjects("element")) {
            JsonObject b = ed.getJsonObject("binding");
            if (b != null) {
              String url = b.asString("valueSet");
              checkVSUrl(context, url);
            }
          }
        }
      } else {
        JsonObject compose = r.getJsonObject("compose");
        if (compose != null) {
          for (JsonObject inc : compose.getJsonObjects("include")) {
            for (String url : inc.getStrings("valueSet")) {
              checkVSUrl(context, url);
            }
          }
          for (JsonObject inc : compose.getJsonObjects("exclude")) {
            for (String url : inc.getStrings("valueSet")) {
              if (url.startsWith("http://cts.nlm.nih.gov/fhir/ValueSet/")) {
                checkVSUrl(context, url);
              }
            }
          }
        }
      }
    }
  }

  private void checkVSUrl(PackageContext context, String url) {
    if (url.startsWith("http://cts.nlm.nih.gov/fhir/ValueSet/")) {
      VsacVS vs = oids.get(url);
      if (vs != null) {
        vs.use(context.getPid());
      }
    }
  }

  @Override
  public void finishPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {    
  }

  @Override
  public void alreadyVisited(String pid) throws FHIRException, IOException, EOperationOutcome {
  }

}
