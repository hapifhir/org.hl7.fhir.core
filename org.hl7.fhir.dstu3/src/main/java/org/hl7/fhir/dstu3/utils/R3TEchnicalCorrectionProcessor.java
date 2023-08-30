package org.hl7.fhir.dstu3.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.DomainResource;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;

public class R3TEchnicalCorrectionProcessor {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new R3TEchnicalCorrectionProcessor().execute(args[0], args[1]);

  }

  private void execute(String src, String packageRoot) throws FileNotFoundException, IOException {
    System.out.println("Loading resources from "+src);
    List<Resource> resources = new ArrayList<>();
    Map<String, Resource> definitions = new HashMap<>();
    for (File f : new File(src).listFiles()) {
      if (f.getName().endsWith(".xml") && !(f.getName().endsWith("warnings.xml") || f.getName().endsWith(".diff.xml"))) {
        try {
          Resource r = new XmlParser().parse(new FileInputStream(f));
          if (f.getName().contains("canonical")) {
            resources.add(r);
          }
          if (Utilities.existsInList(f.getName(), "conceptmaps.xml", "dataelements.xml", "extension-definitions.xml", "profiles-others.xml", "profiles-resources.xml", 
                "profiles-types.xml", "search-parameters.xml", "v2-tables.xml", "v3-codesystems.xml", "valuesets.xml")) {
            definitions.put(f.getName(), r);
          }
          r.setUserData("path", f.getName().substring(0, f.getName().indexOf(".")));
//          FileUtils.copyFile(f, new File(f.getAbsolutePath()+"1"));
//          FileUtils.copyFile(f, new File(f.getAbsolutePath()+"2"));
        } catch (Exception e) {
          System.out.println("Unable to load "+f.getName()+": "+e.getMessage());
        }
      }
      if (f.getName().endsWith(".json") && !(f.getName().endsWith("schema.json") || f.getName().endsWith(".diff.json"))) {
        try {
//          new JsonParser().parse(new FileInputStream(f));
//          FileUtils.copyFile(f, new File(f.getAbsolutePath()+"1"));
//          FileUtils.copyFile(f, new File(f.getAbsolutePath()+"2"));
        } catch (Exception e) {
          System.out.println("Unable to load "+f.getName()+": "+e.getMessage());
        }
      }
    }
    System.out.println(Integer.toString(resources.size())+" resources");
    System.out.println(Integer.toString(definitions.size())+" resources");
    produceExamplesXml(resources, src);
    produceDefinitionsXml(definitions, src);
    produceExamplesJson(resources, src);
    produceDefinitionsJson(definitions, src);
    for (Resource r : definitions.values()) {
      if (r instanceof Bundle) {
        Bundle bnd = (Bundle) r;
        for (BundleEntryComponent be : bnd.getEntry()) {
          resources.add(be.getResource());
        }
      }
    }
    extractToPackageMaster(resources, packageRoot);
    System.out.println("Done");
  }

  private void produceDefinitionsXml(Map<String, Resource> definitions, String dest) throws IOException {
    for (String n : definitions.keySet()) {
      File f = new File(Utilities.path(dest, "definitions.xml", n));
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), definitions.get(n));     
    }
  }

  private void produceDefinitionsJson(Map<String, Resource> definitions, String dest) throws IOException {
    for (String n : definitions.keySet()) {
      File f = new File(Utilities.path(dest, "definitions.json", Utilities.changeFileExt(n, ".json")));
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), definitions.get(n));     
    }
  }

  private void produceExamplesJson(List<Resource> resources, String dest) throws FileNotFoundException, IOException {
    for (Resource r : resources) {
      String n = r.fhirType().toLowerCase()+"-"+r.getUserString("path");
      if (!r.getId().equals(r.getUserString("path"))) {
        n = n+"("+r.getId()+")";
      }
      File f = new File(Utilities.path(dest, "examples-json", n+".json"));
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), r);
    }
    
  }

  private void produceExamplesXml(List<Resource> resources, String dest) throws FileNotFoundException, IOException {
    for (Resource r : resources) {
      String n = r.fhirType().toLowerCase()+"-"+r.getUserString("path");
      if (!r.getId().equals(r.getUserString("path"))) {
        n = n+"("+r.getId()+")";
      }
      File f = new File(Utilities.path(dest, "examples", n+".xml"));
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), r);
    }
  }

  private void extractToPackageMaster(List<Resource> list, String root) throws IOException, FHIRFormatError {
    System.out.println("Updating Packages Master");
    String corePath = Utilities.path(root, "hl7.fhir.r3.core", "package");
    String examplesPath = Utilities.path(root, "hl7.fhir.r3.examples", "package");
    String elementsPath = Utilities.path(root, "hl7.fhir.r3.elements", "package");
    int coreTotal = new File(corePath).list().length-1;
    int examplesTotal = new File(examplesPath).list().length-1;
    int elementsTotal = new File(elementsPath).list().length-1;
        
    int coreCount = 0;
    int examplesCount = 0;
    int elementsCount = 0;
    for (Resource r : list) {
      String n = r.fhirType()+"-"+r.getId()+".json";
      FileOutputStream dst = null;
        if (n.startsWith("DataElement-")) {
          elementsCount++;
          dst = new FileOutputStream(Utilities.path(elementsPath, n));
          new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(dst, r);
        } else {
          dst = new FileOutputStream(Utilities.path(examplesPath, n));
          new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(dst, r);
          examplesCount++;
          if (isCoreResource(r.fhirType())) {
            coreCount++;
            DomainResource dr = (DomainResource) r;
            dr.setText(null);
            new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(new FileOutputStream(Utilities.path(corePath, n)), r);
          }
        }
    }
    System.out.println("  Core @ "+corePath+": Replaced "+coreCount+" of "+coreTotal);
    System.out.println("  Examples @ "+examplesPath+": Replaced "+examplesCount+" of "+examplesTotal);
    System.out.println("  Elements @ "+elementsPath+": Replaced "+elementsCount+" of "+elementsTotal);
  }
  
  private boolean isCoreResource(String rt) {
    return Utilities.existsInList(rt, "CapabilityStatement", "CodeSystem", "CompartmentDefinition", "ConceptMap", "NamingSystem", "OperationDefinition", "SearchParameter", "StructureDefinition", "StructureMap", "ValueSet");
  }

}