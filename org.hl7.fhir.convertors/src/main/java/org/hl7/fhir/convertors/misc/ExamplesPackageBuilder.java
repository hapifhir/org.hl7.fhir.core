package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.hl7.fhir.r4b.model.SearchParameter;
import org.hl7.fhir.r4b.utils.NPMPackageGenerator;
import org.hl7.fhir.r4b.utils.NPMPackageGenerator.Category;

public class ExamplesPackageBuilder {

  public static void main(String[] args) throws FHIRFormatError, FileNotFoundException, IOException {
    new ExamplesPackageBuilder().process(args[0]);

  }

  private void process(String source) throws FHIRFormatError, FileNotFoundException, IOException {
    Set<String> set = new HashSet<>();
    for (File f : new File(source).listFiles()) {
      if (f.getName().endsWith(".json")) {
        JsonObject obj = JsonTrackingParser.parseJson(new FileInputStream(f));
        if (obj.has("resourceType") && obj.has("id")) {
          String type = obj.get("resourceType").getAsString();
          String id = obj.get("id").getAsString();
          byte[] content = TextFile.fileToBytes(f);
          if (type.equals("ConceptMap")) {
            System.out.println("convert "+f.getName());
            content = r5ToR4B(content);
            TextFile.bytesToFile(content, f);
          }
//          TextFile.bytesToFile(content, Utilities.path(dest2, type+"-"+id+".json"));
//          if (!set.contains(type+"/"+id)) {
//            set.add(type+"/"+id);
//            pck.addFile(Category.RESOURCE, type+"-"+id+".json", content);
//          }
        }
      }
    }
//    pck.finish();
//    
  }

  private byte[] r5ToR4B(byte[] content) throws FHIRFormatError, IOException {
    try {
      org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(content);
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(r5);
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    } catch (Exception e) {
      System.out.println("  .. failed: "+e.getMessage());
      return content;
    }
  }

}
