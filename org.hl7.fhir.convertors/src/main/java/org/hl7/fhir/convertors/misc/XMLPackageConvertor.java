package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.npm.NpmPackage;

@SuppressWarnings("checkstyle:systemout")
public class XMLPackageConvertor {

  public static void main(String[] args) throws IOException {
    new XMLPackageConvertor().process(ManagedFileAccess.file("C:\\web\\hl7.org\\fhir"));
  }

  private void process(File folder) throws IOException {
    for (File f : folder.listFiles()) {
      if (f.isDirectory()) {
        process(f);
      } else {
        if (f.getName().endsWith(".tgz")) {
          System.out.println("Package " + f.getAbsolutePath());
          NpmPackage p = NpmPackage.fromPackage(ManagedFileAccess.inStream(f));
          if (p.getNpm().has("dependencies")) {
            JsonObject dep = p.getNpm().getJsonObject("dependencies");
            if (dep.getProperties().isEmpty()) {
              System.out.println("  Dependencies: none");
            } else {
              System.out.println("  Dependencies:");
              for (JsonProperty e : dep.getProperties()) {
                System.out.println("    " + e.getName() + ": " + e.getValue().toString());
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