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

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;



/**
 * intenral use only - set the file name to edit in main(), and fill out the edit routine
 * 
 * @author grahame
 *
 */
@SuppressWarnings("checkstyle:systemout")
public class PackageHacker {

  private static boolean useSecureReferences = false;

  public static void main(String[] args) throws FileNotFoundException, IOException {
//    new PackageHacker().massEdit(ManagedFileAccess.file("/Users/grahamegrieve/web/hl7.org/fhir"));
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot1/hl7.fhir.r6.core.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot1/hl7.fhir.r6.corexml.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot1/hl7.fhir.r6.examples.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot1/hl7.fhir.r6.expansions.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot1/hl7.fhir.r6.search.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot2/hl7.fhir.r6.core.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot2/hl7.fhir.r6.corexml.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot2/hl7.fhir.r6.examples.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot2/hl7.fhir.r6.expansions.tgz");
//    new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/6.0.0-ballot2/hl7.fhir.r6.search.tgz");
    
//      new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/us/core/v311/package.tgz", "http://hl7.org/fhir/us/core/STU3.1.1");
     // new PackageHacker().edit("/Users/grahamegrieve/web/hl7.org/fhir/us/core/v700/package.tgz", "http://hl7.org/fhir/us/core/STU7");
    
    PackageHacker self = new PackageHacker();
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/1.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/1.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/2.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/2.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/2.1.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/2.1.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/3.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/3.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/3.1.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/3.1.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/4.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/4.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.1.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.1.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.2.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.2.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.3.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.3.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.4.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.4.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/5.5.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/5.5.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/6.0.0/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/6.0.0/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/6.0.1/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/6.0.1/hl7.terminology.r4b.tgz");
//    self.cloneToR4B("/Users/grahamegrieve/web/terminology.hl7.org/6.0.2/hl7.terminology.r4.tgz", "/Users/grahamegrieve/web/terminology.hl7.org/6.0.2/hl7.terminology.r4b.tgz");  
   // self.packFolder("/Users/grahamegrieve/web/hl7.org/fhir/us/core/v610/package");
    self.edit("/Users/grahamegrieve/web/www.hl7.org.fhir/us/womens-health-registries/0.2.0-withdrawal/package.tgz");
  }

  private void packFolder(String src) throws FileNotFoundException, IOException {
    NpmPackage npm = NpmPackage.fromFolder(src);
    npm.save(new FileOutputStream(src+".tgz"));
    
  }

  private void cloneToR4B(String src, String dst) throws IOException {
    FileInputStream fs = ManagedFileAccess.inStream(src);
    NpmPackage pck = NpmPackage.fromPackage(fs);
    System.out.println(nice(pck.getNpm()));
    JsonObject json = pck.getNpm();
    String name = json.asString("name");
    json.remove("name");
    json.add("name", name.replace(".r4", ".r4b"));
    json.remove("fhirVersions");
    json.remove("dependencies");
    JsonArray fv = new JsonArray();
    json.add("fhirVersions", fv);
    fv.add("4.3.0");
    JsonObject dep = new JsonObject();
    json.add("dependencies", dep);
    dep.add(VersionUtilities.packageForVersion("4.3.0"), "4.3.0");
    pck.save(new FileOutputStream(dst));
  }

//  private void massEdit(File dir) throws IOException {
//    System.out.println("process "+dir.getAbsolutePath());
//    for (File f : dir.listFiles()) {
//      if (f.isDirectory()) {
//        massEdit(f);
//      } else if (f.getName().equals("package.tgz")) {
//        try {
//          FileInputStream fs = ManagedFileAccess.inStream(f);
//          NpmPackage pck = NpmPackage.fromPackage(fs);
//          if ("fhir.core".equals(pck.getNpm().str("type"))) {
//            System.out.println("!!change "+f.getAbsolutePath());
//            pck.getNpm().remove("type");
//            pck.getNpm().set("type", "Core");
//            FileOutputStream fso = ManagedFileAccess.outStream(f);
//            try {
//              pck.save(fso);
//            } finally {
//              fso.close();
//            }
//          }
//        } catch (Exception e) {
//          System.out.println("!!Error: "+e.getMessage());
//        }
//      } else if (f.getName().startsWith("hl7.fhir.r") && f.getName().endsWith(".examples.tgz")) {
//        try {
//          FileInputStream fs = ManagedFileAccess.inStream(f);
//          NpmPackage pck = NpmPackage.fromPackage(fs);
//          if ("fhir.examples".equals(pck.getNpm().str("type"))) {
//            System.out.println("!!change "+f.getAbsolutePath());
//            pck.getNpm().remove("type");
//            pck.getNpm().set("type", "Examples");
//            FileOutputStream fso = ManagedFileAccess.outStream(f);
//            try {
//              pck.save(fso);
//            } finally {
//              fso.close();
//            }
//          }
//        } catch (Exception e) {
//          System.out.println("!!Error: "+e.getMessage());
//        }
//
//      }
//    }
//  }

  private void edit(String name) throws FileNotFoundException, IOException {
    File f = ManagedFileAccess.file(name);
    if (!f.exists())
      throw new Error("Unable to find "+f.getAbsolutePath());

    System.out.println("Loading Package "+f.getAbsolutePath());
    NpmPackage pck = null;
    FileInputStream fs = ManagedFileAccess.inStream(f);
    try {
      pck = NpmPackage.fromPackage(fs);
    } finally {
      fs.close();
    }
    System.out.println("Altering Package "+f.getAbsolutePath());
    System.out.println(nice(pck.getNpm()));

    if (change(pck.getNpm())) {

      System.out.println("Revised Package");
      System.out.println("=======================");
      System.out.println(nice(pck.getNpm()));
      System.out.println("=======================");
      System.out.print("save? y/n: ");
      int r = System.in.read();
      if (r == 'y') {
        f.renameTo(ManagedFileAccess.file(FileUtilities.changeFileExt(name, ".tgz.bak")));
        FileOutputStream fso = ManagedFileAccess.outStream(f);
        try {
          pck.save(fso);
        } finally {
          fso.close();
        }
      } 
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

  private boolean change(JsonObject npm) throws FileNotFoundException, IOException {
    npm.remove("version");
    npm.add("version", "0.2.0-withdrawal");
    return true;
//    if (npm.has("notForPublication")) {
//      npm.remove("notForPublication");
//      return true;
//    }
//    return false;
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
    for (File f : ManagedFileAccess.file(folder).listFiles()) {
      if (f.getName().endsWith(".json") && !f.getName().endsWith(".canonical.json")) {
        String cnt = FileUtilities.fileToString(f);
        if (cnt.contains("\"resourceType\"")) {
          content.put("package/"+f.getName(), FileUtilities.fileToBytes(f));
        }
      }
    }
  }


  public static JsonObject fixPackageOnLoad(JsonObject npm)  {
    String ref = npm.asString("url");
    if (ref != null) {
      String nref = fixPackageUrl(ref);
      if (!nref.equals(ref)) {
        npm.set("url", nref);
      }
    }
    return npm;
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
    if (webref.equals("http://hl7.org/fhir/us/core/v311")) {
      return "https://hl7.org/fhir/us/core/STU3.1.1";
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