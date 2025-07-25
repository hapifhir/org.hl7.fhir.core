package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.ListResource;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class R5ExampleFinder {

  public static void main(String... args) throws IOException {
    new R5ExampleFinder().execute(new File("/Users/grahamegrieve/work/r5/source"));
  }

  private void execute(File file) throws IOException {
    JsonObject json = new JsonObject();
    exec(json, file);
    JsonParser.compose(json, new File("/Users/grahamegrieve/temp/r5-examples.json"), true);
  }

  private void exec(JsonObject json, File file) {
    for (File f : file.listFiles()) {
      if (f.isDirectory()) {
        exec(json, f);
      } else if (f.getName().startsWith("list-")) {
        try {
          ListResource r = (ListResource) new XmlParser().parse(new FileInputStream(f));
          for (ListResource.ListResourceEntryComponent entry : r.getEntry()) {
            Reference item = entry.getItem();
            if (item.hasReference() && item.hasDisplay() && entry.hasExtension("http://hl7.org/fhir/build/StructureDefinition/title")) {
              JsonObject e = new JsonObject();
              json.add(item.getReference(), e);
              e.add("name", item.getReference());
              e.add("path", entry.getExtensionString("http://hl7.org/fhir/build/StructureDefinition/title"));
            }
          }
        } catch (Exception e) {
          // hothing
        }
      }
    }
  }
}
