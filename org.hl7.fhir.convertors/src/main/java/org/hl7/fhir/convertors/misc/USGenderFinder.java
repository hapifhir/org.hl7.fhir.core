package org.hl7.fhir.convertors.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.PackageContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.xml.sax.SAXException;

@SuppressWarnings("checkstyle:systemout")
public class USGenderFinder implements IPackageVisitorProcessor {

  public class Issue {
    private String pvid;
    private String rid;
    private String rType;
    private String path;
    private String type;
    private String message;
    public Issue(String pvid, String rid, String rType, String path, String type, String message) {
      super();
      this.pvid = pvid;
      this.rid = rid;
      this.rType = rType;
      this.path = path;
      this.type = type;
      this.message = message;
    }
    public String summary() {
      return /*"Package "+pvid+" resource "+*/rid+"#"+path+": "+message;
    }
    public String csv() {
      return pvid+","+rid+","+rType+","+path+","+type+","+message;
    }

  }

  public static void main(String[] args) throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    new USGenderFinder().execute();
  }

  List<Issue> issues = new ArrayList<>();

  private void execute() throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    PackageVisitor pv = new PackageVisitor();
    pv.setCorePackages(false);
    pv.setClientPackageServer(PackageServer.primaryServer());
    pv.setResourceTypes("StructureDefinition", "Patient", "RelatedPerson", "Practitioner", "Person");
    pv.setProcessor(this);
    pv.visitPackages();
    for (Issue s : issues) {
      System.out.println(s.summary());
    }
    
    StringBuilder csv = new StringBuilder();
    csv.append("Package,Resource,Type,Path,Code,Message\r\n");
    System.out.println("=====================");
    for (Issue s : issues) {
      System.out.println(s.csv());
      csv.append(s.csv());
      csv.append("\r\n");
    }
    FileUtilities.stringToFile(csv.toString(), Utilities.path("[tmp]", "gender-elements.csv"));
  }

  @Override
  public Object startPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {
    if (isUS(context.getNpm())) {
      System.out.println(context.getPid()+" is a US Realm package");
      return this;
    } else {
      return null;
    }
  }

  private boolean isUS(NpmPackage npm) {
    if (npm != null) {
      return npm.name().contains("hl7.fhir.us");
    }
    return false;
  }

  @Override
  public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content)
      throws FHIRException, IOException, EOperationOutcome {
    if (clientContext != null) {
      JsonObject r = JsonParser.parseObject(content);
      if ("StructureDefinition".equals(type)) {
        String rt = r.asString("type");
        if (Utilities.existsInList(rt, "Patient", "RelatedPerson", "Practitioner", "Person")) {
          checkForElement(context, r, rt, rt+".gender", null);
          checkForExtension(context, r, rt, "birth-sex", "http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex");
          checkForExtension(context, r, rt, "core-sex", "http://hl7.org/fhir/us/core/StructureDefinition/us-core-sex");
        }
        if (Utilities.existsInList(rt, "Patient")) {
          checkForElement(context, r, rt, rt+".contact.gender", rt+".contact");
        }
      } else if (r.has("gender")) {
        String gender = r.asString("gender");
        if (!Utilities.existsInList(gender, "male", "female")) {
          issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("resourceType")+"/"+r.asString("id"), r.asString("resourceType"), "gender", "fixed", "resource has a gender that is not male / female ("+gender+")"));
        }
      }
    }
  }

  private void checkForExtension(PackageContext context, JsonObject r, String rt, String name, String url) {
    boolean mentions = false;
    JsonObject diff = r.getJsonObject("differential");
    if (diff != null) {
      for (JsonObject ed : diff.getJsonObjects("element")) {
        if ((rt+".extension").equals(ed.asString("path") )) {
          for (JsonObject tr : ed.getJsonObjects("type")) {
            for (String p : tr.getStrings("profile")) {
              if (url.equals(p)) {
                mentions = true;
              }
            }
          }
        }
      }
    }

    if (mentions) {
      issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, rt+".extension:"+name, "uses", "uses the "+name+" extension"));      
    } else {
      String base = r.asString("baseDefinition");
      if (("http://hl7.org/fhir/StructureDefinition/"+rt).equals(base)) {
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, rt+".extension:"+name, "nouse/code", "inherits from core and does not use the "+name+" extension"));
      } else if (!base.contains("us/core")){
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, rt+".extension:"+name, "nouse/other", "does not inherit from US Core and does not use the "+name+" extension ("+base+")"));
      } else {
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, rt+".extension:"+name, "nouse/us-core", "inherits from US Core and does not use the "+name+" extension"));
      }
    }
  }

  private void checkForElement(PackageContext context, JsonObject r, String rt, String path, String filterPath) {
    boolean constrained = false;
    JsonObject diff = r.getJsonObject("differential");
    if (diff != null) {
      for (JsonObject ed : diff.getJsonObjects("element")) {
        if (filterPath != null && filterPath.equals(ed.asString("path") )) {
          if ("0".equals(ed.asString("max"))) {
            return; // no, we don't care
          }          
        }
        if (path.equals(ed.asString("path") )) {
          if (ed.has("slicing")) {
            throw new Error("Not handled");
          }
          boolean required = !"0".equals(ed.asString("min"));
          if ("0".equals(ed.asString("max"))) {
            constrained = true;
          } else if (ed.has("fixedCode")) {
            String gender = r.asString("fixedCode");
            if (!Utilities.existsInList(gender, "male", "female")) {
              issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "fixed", "gender is fixed to a code that is not male / female ("+gender+")"));
            }
            constrained = true;
          } else if (ed.has("patternCode") ) {
            String gender = r.asString("patternCode");
            if (!Utilities.existsInList(gender, "male", "female")) {
              issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "fixed", "gender is fixed to a code that is not male / female ("+gender+")"));
            }
            constrained = true;
          } else if (ed.has("binding")) {
            String vs = ed.getJsonObject("binding").asString("valueSet");
            if (!Utilities.existsInList(vs, "http://cts.nlm.nih.gov/fhir/ValueSet/1.2.91.13925.17760.26878039")) {
              if (required) {
                issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "binding", "gender is REQUIRED and bound to the value set '"+vs+"' and needs to be changed"));
              } else {
                issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "binding", "gender is bound to the value set '"+vs+"' and needs to be changed"));
              }
            }
            constrained = true;
          } 
        }
      }      
    }
    if (!constrained) {
      String base = r.asString("baseDefinition");
      if (("http://hl7.org/fhir/StructureDefinition/"+rt).equals(base)) {
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "missing/code", "the default UV binding is not overruled"));
      } else if (!base.contains("us/core")){
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "missing/other", "does not inherit from US Core and does not fix the valueset ("+base+")"));
      } else {
        issues.add(new Issue(context.getPid()+"#"+context.getVersion(), r.asString("url")+"|"+r.asString("version"), rt, path, "missing/us-core", "inherits from US Core and does nothing with gender"));
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
