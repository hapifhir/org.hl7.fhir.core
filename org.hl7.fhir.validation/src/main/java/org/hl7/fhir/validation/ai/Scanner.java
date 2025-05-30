package org.hl7.fhir.validation.ai;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.Property;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationOptions;

@SuppressWarnings("checkstyle:systemout")
public class Scanner {

  public static void main(String[] args) throws IOException {
    new Scanner().execute("/Users/grahamegrieve/web/www.hl7.org.fhir/us", "/Users/grahamegrieve/web/www.hl7.org.fhir/uv", "/Users/grahamegrieve/web/www.hl7.org.fhir/R4");
  }

  private Set<String> combos = new HashSet<>();
  private Map<String, CodeSystem> codesystems = new HashMap<>();
  private SimpleWorkerContext ctxt;
  
  private void execute(String... paths) throws IOException {
    System.out.println("loading");
    NpmPackage npm = new FilesystemPackageCacheManager.Builder().build().loadPackage("hl7.fhir.r5.core");
    ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm);
    for (String p : paths) {
      execute(new File(p));
    }
    System.out.println("saving");
    JsonObject j = new JsonObject();
    for (String s : Utilities.sorted(combos)) {
      JsonObject o = processCombo(s);
      if (o != null) {
        j.forceArray("cases").add(o);
      }
    }
    org.hl7.fhir.utilities.json.parser.JsonParser.compose(j, new File("/Users/grahamegrieve/temp/code-text-cases.json"), true);
    System.out.println("done. see [tmp]/code-text-cases.json");
  }

  private JsonObject processCombo(String s) {
    String path = s.substring(0, s.indexOf("`")+2).trim(); 
    s = s.substring(s.indexOf("`")+1).trim(); 
    String text = s.substring(s.indexOf("::")+2).trim();
    String uri = s.substring(0, s.indexOf("::")).trim();
    String system = uri.substring(0, uri.indexOf("#")).trim();
    String code = uri.substring(uri.indexOf("#")+1).trim();
    String display = getFromCodeSystem(system, code);
    if (display != null && !display.toLowerCase().equals(text.toLowerCase())) {
      JsonObject object = new JsonObject();
      object.add("path", path);
      object.add("system", system);
      object.add("code", code);
      object.add("display", display);
      object.add("lang", "en");
      object.add("text", text);
      object.add("goal", "valid");
      return object;
    } else {
      return null;
    }
  }

  private String getFromCodeSystem(String system, String code) {
    CodeSystem cs = codesystems.get(system);
    if (cs != null) {
      ConceptDefinitionComponent cd = CodeSystemUtilities.findCode(cs.getConcept(), code);
      if (cd != null) {
        return cd.getDisplay();
      }
    }
    ValidationResult vr = ctxt.validateCode(ValidationOptions.defaults(), system, null, code, null);
    if (vr.isOk()) {
      return vr.getDisplay();
    }
    return null;
  }

  private void execute(File folder) {
    System.out.println(folder.getAbsolutePath());
    for (File f : folder.listFiles()) {
      if (f.isDirectory()) {
        execute(f);
      } else if (f.getName().endsWith(".json")) {
        try {
          Resource r = new JsonParser().parse(new FileInputStream(f));
          if (r != null) {
            if (r instanceof CodeSystem) {
              CodeSystem cs = (CodeSystem) r;
              codesystems.put(cs.getUrl(), cs);
            }
            scan(r.fhirType(), r);
          }

        } catch (Exception e) {
          // nothing
        } catch (Error e) {
          // nothing
        }
      }
    }
  }

  private void scan(String path, Base b) {
    for (Property p : b.children()) {
      for (Base v : p.getValues()) {
        if (v.isResource() || Utilities.existsInList(v.fhirType(), "Element", "BackboneElement")) {
          scan(path+"."+p.getName(), v);
        } else if (v instanceof CodeableConcept) {
          see(path+"."+p.getName(), (CodeableConcept) v);
        }
      }
    }
    
  }

  private void see(String path, CodeableConcept cc) {
   if (cc.hasText()) {
     for (Coding c : cc.getCoding()) {
       if (!c.hasDisplay() || !c.getDisplay().toLowerCase().equals(cc.getText().toLowerCase()))
         see(path, c.getSystem(), c.getCode(), cc.getText());
     }
   }
    
  }

  private void see(String path, String system, String code, String text) {
    if (!system.contains("acme") && !system.contains("example")) {
     combos.add(path+"`"+system+"#"+code+" :: "+text);    
    }
  }

}
