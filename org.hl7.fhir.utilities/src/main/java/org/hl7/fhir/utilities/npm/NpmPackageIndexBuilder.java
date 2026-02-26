package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;

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

  public static final Integer CURRENT_INDEX_VERSION = 2;
  private JsonObject index;
  private JsonArray files;
  private String dbFilename;
  private static INpmPackageIndexBuilderDBImpl extension;

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
      /* We are only interested in some string fields on the first level of the JSON file.
       * We can then use a streaming parser to get the values of these fields instead of parsing the whole file and
       * allocating memory for everything in it.
       */
      JsonFactory jsonFactory = new JsonFactory();
      try (final var parser = jsonFactory.createParser(content)) {
        final var fi = new JsonObject();
        int level = 0;

        while (parser.nextToken() != null) {
          if (parser.currentToken() == JsonToken.START_OBJECT || parser.currentToken() == JsonToken.START_ARRAY) {
            level++;
          } else if (parser.currentToken() == JsonToken.END_OBJECT || parser.currentToken() == JsonToken.END_ARRAY) {
            level--;
          }
          if (level != 1) {
            continue;
          }

          String fieldName = parser.currentName();

          if ("resourceType".equals(fieldName)) {
            parser.nextToken();
            files.add(fi);
            fi.add("filename", name);
            fi.add(fieldName, parser.getText());
          }

          if ("id".equals(fieldName)
              || "url".equals(fieldName)
              || "version".equals(fieldName)
              || "kind".equals(fieldName)
              || "type".equals(fieldName)
              || "supplements".equals(fieldName)
              || "content".equals(fieldName)
              || "valueSet".equals(fieldName)
              || "derivation".equals(fieldName)) {
            parser.nextToken();
            fi.add(fieldName, parser.getText());
          }
        }

        if (!fi.has("resourceType")) {
          // We haven't seen the 'resourceType' key, it's not a FHIR resource
          return true;
        }

        if (extension != null) {
          extension.seeFile(name, fi);
        }
      } catch (Exception e) {
        if (name.contains("openapi")) {
          return false;
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