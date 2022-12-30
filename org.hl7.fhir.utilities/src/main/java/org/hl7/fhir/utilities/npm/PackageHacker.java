package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;



/**
 * intenral use only - set the file name to edit in main(), and fill out the edit routine
 * 
 * @author grahame
 *
 */
public class PackageHacker {

  private static boolean useSecureReferences = false;
  
  public static void main(String[] args) throws FileNotFoundException, IOException {
    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/5.0.0-snapshot3/hl7.fhir.r5.expansions.tgz");
  }

  private void edit(String name) throws FileNotFoundException, IOException {
    File f = new File(name);
    if (!f.exists())
      throw new Error("Unable to find "+f.getAbsolutePath());
    
    NpmPackage pck = NpmPackage.fromPackage(new FileInputStream(f));
    System.out.println("Altering Package "+f.getAbsolutePath());
    System.out.println(nice(pck.getNpm()));
    
    change(pck.getNpm());
    fixContent(pck.getFolders().get("package").getContent());
    if (pck.getFolders().containsKey("openapi")) {
      fixContent(pck.getFolders().get("openapi").getContent());
    }
    if (pck.getFolders().containsKey("xml")) {
      fixContent(pck.getFolders().get("xml").getContent());
    }
//    fixExampleContent(pck.getFolders().get("example").getContent());
    
    System.out.println("Revised Package");
    System.out.println("=======================");
    System.out.println(nice(pck.getNpm()));
    System.out.println("=======================");
    System.out.print("save? y/n: ");
    int r = System.in.read();
    if (r == 'y') {
      f.renameTo(new File(Utilities.changeFileExt(name, ".tgz.bak")));
      pck.save(new FileOutputStream(f));
    }   
  }

  private void fixExampleContent(Map<String, byte[]> content) {
//    byte[] cnt = content.get("ServiceRequest-SDOHCC-ServiceRequestCompletedFoodPantryApplicationAssistExample.json");
//    content.put("ServiceRequest-SDOHCC-ServiceRequestCompletedFoodPantryApplicationAssist.json", cnt);
//    content.remove("ServiceRequest-SDOHCC-ServiceRequestCompletedFoodPantryApplicationAssistExample.json");
  }

  private void fixContent(Map<String, byte[]> content) {
//    fixVersionInContent(content);

  }

  private String nice(JsonObject json) {
    return JsonParser.compose(json, true);
  }

  private void change(JsonObject npm) throws FileNotFoundException, IOException {
//    fixVersions(npm);
    npm.remove("notForPublication");
//    npm.remove("url");
//    npm.add("url", "https://hl7chile.cl/fhir/ig/CoreCL/1.7.0");
//    npm.remove("name");
//    npm.addProperty("name", "hl7.fhir.uv.smart-app-launch");
//    npm.remove("canonical");
//    npm.addProperty("canonical", "http://hl7.org/fhir/us/davinci-drug-formulary");
////    npm.remove("description");
////    npm.addProperty("description", "Group Wrapper that includes all the R4 packages");
//    npm.remove("url");
//    npm.addProperty("url", "http://hl7.org/fhir/R4B");
//    npm.remove("homepage");
//    npm.addProperty("homepage", "http://hl7.org/fhir/R4B");
//    npm.remove("dependencies");
//    JsonObject dep = new JsonObject();
//    npm.add("dependencies", dep);
//    dep.addProperty("hl7.fhir.r4.core", "4.0.1");
//    dep.addProperty("ch.fhir.ig.ch-core", "2.0.0");
//    dep.addProperty("ch.fhir.ig.ch-epr-term", "2.0.4");
//    dep.addProperty("ch.fhir.ig.ch-emed","current");

//    dep.addProperty("hl7.fhir.r4.examples", "4.0.1");
//    dep.addProperty("hl7.fhir.r4.expansions", "4.0.1");
//    dep.addProperty("hl7.fhir.r4.elements", "4.0.1");
//    npm.addProperty("jurisdiction", "urn:iso:std:iso:3166#CL");
  }

  private void fixVersionInContent(Map<String, byte[]> content) {
    for (String n : content.keySet()) {
      if (n.endsWith(".json") || n.endsWith(".xml") || n.endsWith(".xsd")) {
        String json = new String(content.get(n));
        if (json.contains("4.3.0-cibuild") && !json.contains("4.3.0-snapshot1")) {
          json = json.replace("4.3.0-cibuild", "4.3.0");
          content.put(n, json.getBytes(StandardCharsets.UTF_8));
        }
      }
    }
    
  }

  private void fixVersions(JsonObject npm) {
    npm.remove("fhirVersions");
    JsonArray a = new JsonArray();
    npm.add("fhirVersions", a);
    a.add("3.0.1");
  }

  private void setProperty(JsonObject npm, String name, String value) {
    npm.remove("homepage");
    npm.add("homepage", "http://hl7.org/fhir");    
  }

  private void fixNames(Map<String, byte[]> content) {
    List<String> names = new ArrayList<>();
    names.addAll(content.keySet());
    for (String s : names) {
      if (s.endsWith("json") && !s.endsWith(".json")) {
        String n = s.substring(0, s.length()-4)+".json";
        content.put(n, content.get(s));
        content.remove(s);
      }
    }
  }

  private void addContentFrom(String folder, Map<String, byte[]> content) throws FileNotFoundException, IOException {
    for (File f : new File(folder).listFiles()) {
      if (f.getName().endsWith(".json") && !f.getName().endsWith(".canonical.json")) {
         String cnt = TextFile.fileToString(f);
         if (cnt.contains("\"resourceType\"")) {
           content.put("package/"+f.getName(), TextFile.fileToBytes(f));
         }
      }
    }
  }

  public static String fixPackageUrl(String webref) {
    if (webref == null) {
      return null;
    }
    // workaround for past publishing problems
    switch (webref) {
    case "file://C:\\GitHub\\hl7.fhir.us.breast-radiology#0.2.0\\output":   return "http://hl7.org/fhir/us/breast-radiology/2020May"; 
    case "file://C:\\GitHub\\hl7.fhir.us.bser#1.0.0\\output":                return "http://hl7.org/fhir/us/bser/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.us.carin-bb#0.1.0\\output":            return "http://hl7.org/fhir/us/carin-bb/2020Feb"; 
    case "file://C:\\GitHub\\hl7.fhir.us.carin-rtpbc#0.1.0\\output":         return "http://hl7.org/fhir/us/carin-rtpbc/2020Feb"; 
    case "file://C:\\GitHub\\hl7.fhir.us.cqfmeasures#1.1.0\\output":         return "http://hl7.org/fhir/us/cqfmeasures/2020Feb"; 
    case "file://C:\\GitHub\\hl7.fhir.us.cqfmeasures#2.0.0\\output":         return "http://hl7.org/fhir/us/cqfmeasures/STU2"; 
    case "file://C:\\GitHub\\hl7.fhir.us.davinci-alerts#0.2.0\\output":      return "http://hl7.org/fhir/us/davinci-alerts/2020Feb"; 
    case "file://C:\\GitHub\\hl7.fhir.us.davinci-atr#0.1.0\\output":         return "http://hl7.org/fhir/us/davinci-atr/2020Feb";  
    case "file://C:\\GitHub\\hl7.fhir.us.davinci-deqm#1.1.0\\output":        return "http://hl7.org/fhir/us/davinci-deqm/2020Feb"; 
    case "file://C:\\GitHub\\hl7.fhir.us.davinci-deqm#1.0.0\\output":        return "http://hl7.org/fhir/us/davinci-deqm/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.us.dme-orders#0.1.1\\output":          return "http://hl7.org/fhir/us/dme-orders/2020May"; 
    case "file://C:\\GitHub\\hl7.fhir.us.ecr#1.0.0\\output":                 return "http://hl7.org/fhir/us/ecr/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.us.mcode#1.0.0\\output":               return "http://hl7.org/fhir/us/mcode/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.us.odh#1.0.0\\output":                 return "http://hl7.org/fhir/us/odh/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.us.qicore#4.0.0\\output":              return "http://hl7.org/fhir/us/qicore/STU4"; 
    case "file://C:\\GitHub\\hl7.fhir.uv.ips#1.0.0\\output":                 return "http://hl7.org/fhir/uv/ips/STU1"; 
    case "file://C:\\GitHub\\hl7.fhir.uv.mhealth-framework#0.1.0\\output":   return "http://hl7.org/fhir/uv/mhealth-framework/2020May"; 
    case "file://C:\\GitHub\\hl7.fhir.uv.security-label-ds4p#0.1.0\\output": return "http://hl7.org/fhir/uv/security-label-ds4p/2020May"; 
    case "file://C:\\GitHub\\hl7.fhir.uv.shorthand#0.12.0\\output":          return "http://hl7.org/fhir/uv/shorthand/2020May"; 
    case "http://build.fhir.org/branches/R4B//":                             return "http://hl7.org/fhir/2021Mar"; 
    }

    // https://github.com/HL7/fhir-ig-publisher/issues/295
    if (webref.contains("hl7.org/fhir/us/core/STU4.0.0")) {
      return webref.replace("hl7.org/fhir/us/core/STU4.0.0", "hl7.org/fhir/us/core/STU4");
    }

    if (isUseSecureReferences()) {
      return webref.replace("http://hl7.org/fhir", "https://hl7.org/fhir").replace("http://build.fhir.org", "https://build.fhir.org");
    } else {
      return webref;
    }
  }

  public static boolean isUseSecureReferences() {
    return useSecureReferences;
  }

  public static void setUseSecureReferences(boolean useSecureReferences) {
    PackageHacker.useSecureReferences = useSecureReferences;
  }

}