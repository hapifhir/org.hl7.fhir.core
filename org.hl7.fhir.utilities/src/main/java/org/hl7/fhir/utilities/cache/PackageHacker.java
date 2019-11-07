package org.hl7.fhir.utilities.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

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
    new PackageHacker().edit("C:\\web\\hl7.org\\fhir\\us\\qicore\\STU2\\package.tgz");
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

  private void change(JsonObject npm, Map<String, byte[]> content) {
    npm.remove("version");
    npm.addProperty("version", "2.0.0");
//    JsonArray fhirVersions = new JsonArray();
//    fhirVersions.add("1.9.0");
//    npm.add("fhirVersions", fhirVersions);
//    JsonObject dependencies = new JsonObject();
//    dependencies.addProperty("hl7.fhir.r3.core", "3.0.2");
//    npm.remove("dependencies");
//    npm.add("dependencies", dependencies);
  }

}
