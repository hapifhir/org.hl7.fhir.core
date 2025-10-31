package org.hl7.fhir.r5.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@MarkedToMoveToAdjunctPackage
@SuppressWarnings("checkstyle:systemout")
public class JsonResourceTemplateFixer {

  public static void main(String[] args) throws JsonException, IOException {
  new JsonResourceTemplateFixer().execute(
      "/Users/grahamegrieve/work/fhir-tx-ecosystem-ig/tests",
      "/Users/grahamegrieve/temp/tx-tests", "");
  }

  private void execute(String source, String dest, String path) throws JsonException, IOException {
    File src = new File(source);
    for (File f : src.listFiles()) {
      if (f.isDirectory()) {
        execute(f.getAbsolutePath(), dest, "".equals(path) ? f.getName() : Utilities.path(path, f.getName()));
      } else if (f.getName().endsWith(".json")) {
        JsonObject j = JsonParser.parseObject(f);
        if (j.has("resourceType")) {
          FileUtilities.createDirectory(Utilities.path(dest, "in", path));
          JsonParser.compose(j, new File(Utilities.path(dest, "in", path, f.getName())), true);
          checkJsonObject(j);
          FileUtilities.createDirectory(Utilities.path(dest, "out", path));
          File tgt = new File(Utilities.path(dest, "out", path, f.getName()));
          JsonParser.compose(j, tgt, true);
          try {
            var res = new org.hl7.fhir.r5.formats.JsonParser().parse(FileUtilities.fileToBytes(tgt));
            new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(tgt), res);
          } catch (Exception e) {
            System.out.println("Error reading "+tgt.getAbsolutePath()+": "+e.getMessage());
          }
        }
      }
    } 
  }

  private void checkJsonObject(JsonObject j) {
    if (j.has("$optional-properties$")) {
      List<String> names = j.getJsonArray("$optional-properties$").asStrings();
      j.remove("$optional-properties$");
      addExtension(j, "optional-properties", "string", CommaSeparatedStringBuilder.join(",", names));
//      for (String n : names) {
//        if (j.hasObject(n)) {
//          addExtension(j.getJsonObject(n), "optional", true);
//        } else {
////          addExtension(j.forceObject("_"+n), "optional", true);
//          addExtension(j, "optional-property", "code", n);
//        }
//      }
    }
    if (j.has("$optional$")) {
      j.remove("$optional$");
      addExtension(j, "optional", true);
      
    }
    if (j.has("$count-arrays$")) {
      List<String> names = j.getJsonArray("$count-arrays$").asStrings();
      j.remove("$count-arrays$");
      addExtension(j, "count-arrays", "string", CommaSeparatedStringBuilder.join(",", names));
//      for (String n : names) {
//        addExtension(j, "count-array", "code", n);
//      }
    }

    for (int i = j.getProperties().size() -1; i >= 0; i--) {
      JsonProperty p = j.getProperties().get(i);
       if (p.getValue().isJsonArray()) {
         for (JsonElement e : p.getValue().asJsonArray()) {
            checkJsonElement(j, p.getName(), e);
         }
      } else {
        checkJsonElement(j, p.getName(), p.getValue());
      }
    }
  }

  public void addExtension(JsonObject j, String url, String type, String value) {
    JsonObject ext = new JsonObject();
    ext.set("url", "http://hl7.org/fhir/uv/tools/StructureDefinition/test-template-"+url);
    ext.set("value"+Utilities.capitalize(type), value);
    j.forceArray(0, "extension").add(ext);
  }

  public void addExtension(JsonObject j, String url, boolean value) {
    JsonObject ext = new JsonObject();
    ext.set("url", "http://hl7.org/fhir/uv/tools/StructureDefinition/test-template-"+url);
    ext.set("valueBoolean", value);
    j.forceArray(0, "extension").add(ext);
  }

  public void addNamedExtension(JsonObject parent, String name, String url, String type, String value) {
    JsonObject k = parent.getJsonObject("_"+name);
    if (k == null) {
      k = new JsonObject();
      parent.add("_"+name, k);
    }
    JsonObject ext = new JsonObject();
    ext.set("url", "http://hl7.org/fhir/uv/tools/StructureDefinition/test-template-"+url);
    ext.set("value"+Utilities.capitalize(type), value);
    k.forceArray("extension").add(ext);
  }
  
  private void checkJsonElement(JsonObject parent, String name, JsonElement value) {
    if (value.isJsonObject()) {
      checkJsonObject(value.asJsonObject());
    } else if (value.isJsonPrimitive()) {
      checkJsonPrimitive(parent, name, value.asString());
    } else {
      // ignore?
      // System.out.println("What?");
    }
  }

  private void checkJsonPrimitive(JsonObject parent, String name, String value) {
    if (true) {
      return;
    }
    if (value.startsWith("$")) {
      parent.remove(name);
      switch (value) {
      case "$$" : 
        addNamedExtension(parent, name, "value-rule", "string", "string");
        break;
      case "$id$" :
        addNamedExtension(parent, name, "value-rule", "string", "id");
        break;
      case "$semver$" : 
        addNamedExtension(parent, name, "value-rule", "string", "semver");
        break;
      case "$url$" : 
        addNamedExtension(parent, name, "value-rule", "string", "url");
        break;
      case "$token$" : 
        addNamedExtension(parent, name, "value-rule", "string", "token");
        break;
      case "$string$" : 
        addNamedExtension(parent, name, "value-rule", "string", "string");
        break;
      case "$date$" : 
        addNamedExtension(parent, name, "value-rule", "string", "date");
        break;
      case "$version$" : 
        addNamedExtension(parent, name, "value-rule", "string", "version");
        break;
      case "$uuid$" : 
        addNamedExtension(parent, name, "value-rule", "string", "uuid");
        break;
      case "$instant$" : 
        addNamedExtension(parent, name, "value-rule", "string", "instant");
        break;
      default:
        if (value.startsWith("$choice:")) {
          String[] list = value.substring(8).replace("$", "").split("\\|");
          for (String n : list) {
            addNamedExtension(parent, name, "value-choice", "string", n);
          }
        } else {
          System.out.println("not handled yet: "+value);
        }
      }
    } else {
    }
    
  }
}
