package org.hl7.fhir.convertors.misc;

import com.google.gson.JsonObject;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CorePackageTools {

  public static void main(String[] args) throws FHIRFormatError, IOException {
    if ("-xml".equals(args[0])) {
      new CorePackageTools().buildXml(args[1], args[2], args[3]);
    }
    if ("-pack".equals(args[0])) {
      new CorePackageTools().buildPackage(args[1], args[2]);
    }
  }

  private void buildPackage(String path, String output) throws IOException {
    NpmPackage npm = NpmPackage.fromFolder(path);
    npm.loadAllFiles();
    npm.save(new FileOutputStream(output));

  }

  private void buildXml(String json, String xml, String version) throws FHIRFormatError, IOException {
    for (File f : new File(Utilities.path(json, "package")).listFiles()) {
      if (f.getName().endsWith(".json")) {
        JsonObject j = new JsonTrackingParser().parseJson(f);
        if (j.has("resourceType")) {
          if ("1.4".equals(version)) {
            String n = f.getName();
            System.out.println(n);
            String xn = Utilities.changeFileExt(n, ".xml");
            org.hl7.fhir.dstu2016may.model.Resource r = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new FileInputStream(f));
            new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.NORMAL).compose(new FileOutputStream(Utilities.path(xml, "package", xn)), r);
          }
        }
      }
    }
  }
}
