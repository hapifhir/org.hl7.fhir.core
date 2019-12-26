package org.hl7.fhir.core.generator.engine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.codegen.Configuration;
import org.hl7.fhir.core.generator.codegen.JavaEnumerationsGenerator;
import org.hl7.fhir.core.generator.codegen.JavaResourceGenerator;
import org.hl7.fhir.core.generator.loader.DefinitionsLoader;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;

public class JavaCoreGenerator {

  // C:\work\org.hl7.fhir\org.hl7.fhir.core\org.hl7.fhir.r5
  // C:\work\org.hl7.fhir\org.hl7.fhir.core\org.hl7.fhir.r5.new
  
  public static void main(String[] args) throws Exception {
    System.out.println("HAPI CORE Code Generator");
    if (args.length != 3) {
      System.out.println("Usage: invoke with 3 command line parameters to generate HAPI R5 code");
      System.out.println("1: fhir version to generate from (e.g. 4.1.0 or 'current'");
      System.out.println("2: project directory to read java-adorment from - e.g. C:\\work\\org.hl7.fhir\\org.hl7.fhir.core\\org.hl7.fhir.r5");
      System.out.println("3: project directory to generate code into - e.g. C:\\work\\org.hl7.fhir\\org.hl7.fhir.core\\org.hl7.fhir.r5.new");
    } else {
      String version = args[0];
      String src = args[1];
      String dest = args[2];
      new JavaCoreGenerator().generate(version, src, dest);
    }
  }
  

  private void generate(String version, String src, String dest) throws Exception {
    Date date = new Date();
    
    String ap = Utilities.path(src, "src", "main", "resources");
    System.out.println("Load Configuration from "+ap);
    Configuration config = new Configuration(ap);
    

    PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    System.out.println("Cache: "+pcm.userDir());
    System.out.println("Load hl7.fhir.r5.core");
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core", version);
    Definitions master = DefinitionsLoader.load(npm); 
    
    markValueSets(master, config);
    
    System.out.println("Load hl7.fhir.r5.expansions");
    Definitions expansions = DefinitionsLoader.load(pcm.loadPackage("hl7.fhir.r5.expansions", version));
    
    System.out.println("Process Expansions");
    updateExpansions(master, expansions);
    
    System.out.println("Generate Model");   
    System.out.println(" .. Enumerations");
    JavaEnumerationsGenerator egen = new JavaEnumerationsGenerator(new FileOutputStream(Utilities.path(dest, "src", "org", "hl7", "fhir", "r5", "model", "Enumerations.java")), master, config, date, npm.version());
    egen.generate();
    
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          String name = javaName(sd.getName());

          System.out.println(" .. "+name);
          String fn = Utilities.path(dest, "src", "org", "hl7", "fhir", "r5", "model", name+".java");
          JavaResourceGenerator gen = new JavaResourceGenerator(new FileOutputStream(fn), master, config, date, npm.version());
          gen.generate(sd, name, getSearchParams(master, sd.getName()));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          String name = javaName(sd.getName());

          System.out.println(" .. "+name);
          String fn = Utilities.path(dest, "src", "org", "hl7", "fhir", "r5", "model", name+".java");
          JavaResourceGenerator gen = new JavaResourceGenerator(new FileOutputStream(fn), master, config, date, npm.version());
          gen.generate(sd, name, getSearchParams(master, sd.getName()));
        }
      }
    }
    System.out.println("Done");   
    
  }

  @SuppressWarnings("unchecked")
  private void markValueSets(Definitions defns, Configuration config) {
    for (StructureDefinition sd : defns.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE && !sd.getName().contains(".")) {
        for (ElementDefinition ed : sd.getSnapshot().getElement()) {
          if (ed.hasBinding() && ed.getBinding().hasValueSet() && ed.getBinding().getStrength() == BindingStrength.REQUIRED) {
            ValueSet vs = defns.getValuesets().get(ed.getBinding().getValueSet());
            if (vs != null) {
              if (!vs.hasUserData("usages")) {
                vs.setUserData("usages", new ArrayList<>());
              }
              List<String> list = (List<String>) vs.getUserData("usages");
              if (!list.contains(sd.getName())) {
                list.add(sd.getName());
              }
            }
          }
        }
      }
    }
    
    for (StructureDefinition sd : defns.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE) {
        for (ElementDefinition ed : sd.getSnapshot().getElement()) {
          if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
            ValueSet vs = defns.getValuesets().get(ed.getBinding().getValueSet());
            boolean shared = false;
            if (vs != null) {
              List<String> list = (List<String>) vs.getUserData("usages");
              if (list != null && list.size() > 1) {
                shared = true;
              }
            }
            if (config.getIni().hasProperty("shared", ed.getPath())) {
              shared = config.getIni().getBooleanProperty("shared", ed.getPath());
            }
            if (shared) {
              ed.getBinding().setUserData("shared", true);
            }
          }
        }
      }
    }
  }


  private List<SearchParameter> getSearchParams(Definitions defns, String name) {
    List<SearchParameter> res = new ArrayList<>();
    if (!Utilities.existsInList(name, "Resource")) {
      for (SearchParameter sp : defns.getSearchParams().getList()) {
        boolean relevant = false;
        for (CodeType c : sp.getBase()) {
          if (c.getValue().equals(name)) {
            relevant = true;
            break;
          }
        }
        if (relevant) {
          res.add(sp);
        }
      }
    }
    return res;
  }


  private String javaName(String name) {
    return "List".equals(name) ? "ListResource" : name;
  }

  private void updateExpansions(Definitions master, Definitions expansions) {
    for (StructureDefinition sd : master.getStructures().getList()) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
          String ref = ed.getBinding().getValueSet();
          if (ref.contains("|")) {
            ref = ref.substring(0, ref.indexOf("|"));
          }
          ValueSet exp = expansions.getValuesets().get(ref);
          if (exp != null) {
            ed.getBinding().setUserData("expansion", exp);
          }
        }
      }
    }
    
  }




}
