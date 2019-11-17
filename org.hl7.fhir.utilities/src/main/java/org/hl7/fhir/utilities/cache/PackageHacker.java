package org.hl7.fhir.utilities.cache;

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
    new PackageHacker().edit("C:\\web\\hl7.org\\fhir\\uv\\pocd\\2018Jan\\package.tgz");
  }

  private void edit(String name) throws FileNotFoundException, IOException {
    File f = new File(name);
    if (!f.exists())
      throw new Error("Unable to find "+f.getAbsolutePath());
    
    NpmPackage pck = NpmPackage.fromPackage(new FileInputStream(f));
    System.out.println("Altering Package "+f.getAbsolutePath());
    System.out.println(nice(pck.getNpm()));
    
    change(pck.getNpm(), pck.getContent());
    
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
//    addContentFrom("C:\\web\\hl7.org\\fhir\\us\\meds", content);
    fixNames(content);
//    setProperty(npm, "homepage", "http://hl7.org/fhir");

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

}
