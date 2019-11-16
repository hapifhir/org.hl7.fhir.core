package org.hl7.fhir.utilities.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.CSVWriter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class PackageScanner {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    new PackageScanner().scan(new File("C:\\web\\hl7.org\\fhir"), "c:\\temp\\package-scan.csv", "http://hl7.org/fhir");
  }

  private void scan(File folder, String dest, String url) throws IOException {
    CSVWriter csv = new CSVWriter(new FileOutputStream(dest));
    csv.line("path", "error", "name", "version", "fhir-version", "canonical", "homepage",
        "url", "type", "#types", "#urls");
    scanFolders(folder, csv, folder.getAbsolutePath(), url);
    csv.close();    
    System.out.println("done");
  }

  private void scanFolders(File folder, CSVWriter csv, String root, String url) {
    System.out.println(folder.getAbsolutePath());
    for (File file : folder.listFiles()) {
      if (file.isDirectory()) {
        scanFolders(file, csv, root, url);
      } else if (file.getName().endsWith(".tgz")) {
        processPackage(file, csv, root, url);
      }
    }
  }

  private void processPackage(File file, CSVWriter csv, String root, String url) {
    try {
      NpmPackage npm = NpmPackage.fromPackage(new FileInputStream(file));
//      fix(npm, file.getAbsolutePath(), root, url);
      csv.line(file.getAbsolutePath(), "", npm.name(), npm.version(), npm.fhirVersion(), npm.canonical(), npm.homepage(),
          npm.url(), npm.type(), Integer.toString(npm.getTypes().size()), Integer.toString(npm.getUrls().size()));
    } catch (Exception e) {
      try {
        csv.line(file.getAbsolutePath(), e.getMessage() == null ? "NPE" : e.getMessage());
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    
    
  }

  private void fix(NpmPackage npm, String filename, String root, String url) throws FileNotFoundException, IOException {
    String u = Utilities.pathURL(url, Utilities.getDirectoryForFile(filename).substring(root.length()).replace("\\", "/"));
    if (Utilities.getDirectoryForFile(filename).equals("C:\\web\\hl7.org\\fhir")) {
      u = "http://hl7.org/fhir/R4";
    }
    boolean save = false;
    if (npm.url() == null || !npm.url().equals(u)) {
      npm.getNpm().remove("url");
      npm.getNpm().addProperty("url", u);
      save = true;
    }
    if (!npm.canonical().startsWith("http://hl7.org")) {
      npm.getNpm().remove("canonical");
      npm.getNpm().addProperty("canonical", "http://hl7.org/fhir/smart-app-launch");
      save = true;
    }

    if (save) {
      npm.save(new FileOutputStream(filename));
    }
  }
 
}
