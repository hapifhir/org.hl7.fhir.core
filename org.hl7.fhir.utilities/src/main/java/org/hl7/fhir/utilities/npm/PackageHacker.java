package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * intenral use only - set the file name to edit in main(), and fill out the edit routine
 * 
 * @author grahame
 *
 */
public class PackageHacker {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new PackageHacker().edit("M:\\web\\hl7.org\\fhir\\us\\carin-rtpbc\\package.tgz");
  }

  private void edit(String name) throws FileNotFoundException, IOException {
    File f = new File(name);
    if (!f.exists())
      throw new Error("Unable to find "+f.getAbsolutePath());
    
    NpmPackage pck = NpmPackage.fromPackage(new FileInputStream(f));
    System.out.println("Altering Package "+f.getAbsolutePath());
    System.out.println(nice(pck.getNpm()));
    
    change(pck.getNpm(), pck.getFolders().get("package").getContent());
    
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

  private String nice(JsonObject json) {
    return new GsonBuilder().setPrettyPrinting().create().toJson(json);
  }

  private void change(JsonObject npm, Map<String, byte[]> content) throws FileNotFoundException, IOException {
    fixVersions(npm);
    npm.remove("url");
    npm.addProperty("url", "http://hl7.org/fhir/us/carin-rtpbc/STU1");
//    npm.remove("name");
//    npm.addProperty("name", "hl7.fhir.uv.smart-app-launch");
//    npm.remove("canonical");
//    npm.addProperty("canonical", "http://hl7.org/fhir/us/davinci-drug-formulary");
////    npm.remove("description");
////    npm.addProperty("description", "Group Wrapper that includes all the R4 packages");
//    npm.remove("url");
//    npm.addProperty("url", "https://terminology.hl7.org/1.0.0/");
//    npm.remove("dependencies");
//    JsonObject dep = new JsonObject();
//    npm.add("dependencies", dep);
//    dep.addProperty("hl7.fhir.r3.core", "3.0.1");
//    dep.addProperty("hl7.fhir.r4.examples", "4.0.1");
//    dep.addProperty("hl7.fhir.r4.expansions", "4.0.1");
//    dep.addProperty("hl7.fhir.r4.elements", "4.0.1");
  }

  private void fixVersions(JsonObject npm) {
    npm.remove("fhirVersions");
    JsonArray a = new JsonArray();
    npm.add("fhirVersions", a);
    a.add("3.0.1");
  }

  private void setProperty(JsonObject npm, String name, String value) {
    npm.remove("homepage");
    npm.addProperty("homepage", "http://hl7.org/fhir");    
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
    }
    return webref;  
  }

}