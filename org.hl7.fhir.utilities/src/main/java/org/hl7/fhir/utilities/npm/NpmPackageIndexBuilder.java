package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * This class builds the .index.json for a package 
 * <br/>
 * it also builds a .index.db since that may provide faster access
 * 
 * @author grahame
 *
 */
@Slf4j
public class NpmPackageIndexBuilder {

  public interface INpmPackageIndexBuilderDBImpl {

    void start(String filename);
    void seeFile(String name, JsonObject fi) throws Exception;
    void close();
  }

  public interface INpmPackageIndexBuilderDBImplFactory {
    INpmPackageIndexBuilderDBImpl create();
  }

  private static INpmPackageIndexBuilderDBImplFactory extensionFactory;
  private static final JsonFactory JSON_FACTORY = new JsonFactory(); // reuse across all seeFile calls
  // the root properties that are indexed, in the order they appear in each .index.json entry (after the filename)
  private static final List<String> INDEXED_PROPERTIES = List.of("resourceType", "id", "url", "version", "kind", "type", "supplements", "content", "valueSet", "derivation");

  public static final Integer CURRENT_INDEX_VERSION = 2;
  private JsonObject index;
  private JsonArray files;
  private String dbFilename;
  private INpmPackageIndexBuilderDBImpl extension; // one per builder: the publisher and the version converter build several packages or folders at once

  public void start(String filename) {
    index = new JsonObject();
    index.add("index-version", CURRENT_INDEX_VERSION);
    files = new JsonArray();
    index.add("files", files);
    if (filename != null) {
      dbFilename = filename;
      try {
        if (extensionFactory != null) {
          extension = extensionFactory.create();
          extension.start(filename);
        }
      } catch (Exception e) {
        // nothing?
      }
    }
  }

  public boolean seeFile(String name, byte[] content) {
    if (name.endsWith(".json")) {
      /* We are only interested in some primitive properties at the root of the JSON file.
       * We can then use a streaming parser to get the values of these properties instead of parsing the whole file and
       * allocating memory for everything in it.
       *
       * Only primitive values are indexed. A root property with one of these names but a complex value (e.g.
       * Media.type, DocumentReference.content) is skipped along with everything inside it, so that properties
       * of nested objects (e.g. Media.content.id) are never mistaken for root properties.
       */
      Map<String, String> values = new HashMap<>();
      try (final var parser = JSON_FACTORY.createParser(content)) {
        if (parser.nextToken() != JsonToken.START_OBJECT) {
          return true;
        }
        while (parser.nextToken() == JsonToken.FIELD_NAME) {
          String fieldName = parser.currentName();
          JsonToken value = parser.nextToken();
          if (value == JsonToken.START_OBJECT || value == JsonToken.START_ARRAY) {
            parser.skipChildren();
          } else if (value != JsonToken.VALUE_NULL && INDEXED_PROPERTIES.contains(fieldName) && !values.containsKey(fieldName)) {
            values.put(fieldName, parser.getText());
          }
        }
      } catch (Exception e) {
        if (name.contains("openapi")) {
          return false;
        }
        return true;
      }

      if (!values.containsKey("resourceType")) {
        // We haven't seen a 'resourceType' property, it's not a FHIR resource
        return true;
      }

      // the entry is only built once the file has been read successfully, so .index.json and .index.db see the same files
      final var fi = new JsonObject();
      fi.add("filename", name);
      for (String n : INDEXED_PROPERTIES) {
        if (values.containsKey(n)) {
          fi.add(n, values.get(n));
        }
      }
      files.add(fi);
      if (extension != null) {
        try {
          extension.seeFile(name, fi);
        } catch (Exception e) {
          log.warn("Unable to add " + name + " to the package index " + dbFilename + ": " + e.getMessage());
        }
      }
    }
    return true;
  }

  public String build() {
    if (extension != null) {
      extension.close();
    }
    String res = JsonParser.compose(index, true);
    index = null;
    files = null;
    return res;
  }
  
//  private Map<String, List<String>> types = new HashMap<>();
//  private Map<String, String> canonicalMap = new HashMap<>();


  public void executeWithStatus(String folder) throws IOException {
    log.info("Indexing Package "+folder+" ... ");
    execute(folder);
    log.info("Indexing Package "+folder+ " done");
  }
  
  public void execute(String folder) throws IOException {
    if (existsFolder(folder, "package")) {
      folder = Utilities.path(folder, "package"); 
    }
    if (!existsFile(folder, "package.json")) {
      throw new FHIRException("Not a proper package? (can't find package.json)");
    }
    start(Utilities.path(folder, ".index.db"));
    File dir = ManagedFileAccess.file(folder);
    for (File f : dir.listFiles()) {
      seeFile(f.getName(), FileUtilities.fileToBytes(f));
    }
    FileUtilities.stringToFile(build(), Utilities.path(folder, ".index.json"));
  }

  private boolean existsFolder(String... args) throws IOException {
    File f = ManagedFileAccess.file(Utilities.path(args));
    return f.exists() && f.isDirectory();
  }

  private boolean existsFile(String... args) throws IOException {
    File f = ManagedFileAccess.file(Utilities.path(args));
    return f.exists() && !f.isDirectory();
  }

  public static void main(String[] args) throws IOException {
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r3");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r4");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r3");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r4");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#1.0.2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#1.4.0");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#3.0.2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#4.0.1");
  }

  public String getDbFilename() {
    return dbFilename;
  }

  public static INpmPackageIndexBuilderDBImplFactory getExtensionFactory() {
    return extensionFactory;
  }

  public static void setExtensionFactory(INpmPackageIndexBuilderDBImplFactory extensionFactory) {
    NpmPackageIndexBuilder.extensionFactory = extensionFactory;
  }

}