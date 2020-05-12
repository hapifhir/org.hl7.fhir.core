package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;

import org.hl7.fhir.utilities.cache.NpmPackage;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class XMLPackageConvertor {

  public static void main(String[] args) throws FileNotFoundException, IOException {
   new XMLPackageConvertor().process(new File("C:\\web\\hl7.org\\fhir"));
  }

  private void process(File folder) throws FileNotFoundException, IOException {
    for (File f : folder.listFiles()) {
      if (f.isDirectory()) {
        process(f);
      } else {
        if (f.getName().endsWith(".tgz")) {
          System.out.println("Package "+f.getAbsolutePath());
          NpmPackage p = NpmPackage.fromPackage(new FileInputStream(f));
          if (p.getNpm().has("dependencies")) {
            JsonObject dep = p.getNpm().getAsJsonObject("dependencies");
            if (dep.entrySet().isEmpty()) {
              System.out.println("  Dependencies: none");
            } else {
              System.out.println("  Dependencies:");
              for (Entry<String, JsonElement> e : dep.entrySet()) {
                System.out.println("    "+e.getKey()+": "+e.getValue().getAsString());
              }
            }
          } else {
            System.out.println("  Dependencies: n/a");
          }
        }
      }
        
      
    }
    
  }

}