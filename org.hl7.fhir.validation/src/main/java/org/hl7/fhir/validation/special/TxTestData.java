package org.hl7.fhir.validation.special;

import lombok.Getter;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TxTestData {

  @Getter
  private final JsonObject manifest;

  @Getter
  private final JsonObject externals;

  @Getter
  private final List<Object[]> testData;
  
  private final NpmPackage npm;
  private final File folder;
  private final String code;
  private final String version;
  private final String testFileName;

  private TxTestData(List<Object[]> testData, JsonObject manifest, JsonObject externals, NpmPackage npm, String code, String version) throws IOException {
    this.testData = testData;
    this.manifest = manifest;
    this.externals = externals;
    this.npm = npm;
    this.folder = null;
    this.code = code;
    this.version = version;
    this.testFileName = "test-cases.json";
  }
  
  private TxTestData(List<Object[]> testData, JsonObject manifest, JsonObject externals, File folder, String filename, String code, String version) throws IOException {
    this.testData = testData;
    this.manifest = manifest;
    this.externals = externals;
    this.npm = null;
    this.folder = folder;
    this.code = code;
    this.version = version;
    this.testFileName = filename;
  }

  public static TxTestData loadTestDataFromFolder(File folder, String name) throws IOException {
    
    String contents = FileUtilities.streamToString(loadFile(folder, name));
    String externalSource = ManagedFileAccess.file(folder.getAbsolutePath(), "messages-tx.fhir.org.json").exists() ?
        FileUtilities.streamToString(loadFile(folder, "messages-tx.fhir.org.json")) : null;
    JsonObject externals = externalSource == null ? new JsonObject() : org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(externalSource);

    Map<String, TxTestSetup> examples = new HashMap<String, TxTestSetup>();
    JsonObject manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
   
    for (JsonObject suite : manifest.getJsonObjects("suites")) {
      if (!"tx.fhir.org".equals(suite.asString("mode"))) {
        String sn = suite.asString("name");
        for (JsonObject test : suite.getJsonObjects("tests")) {
          String tn = test.asString("name");
          examples.put(sn + "." + tn, new TxTestSetup(suite, test));
        }
      }
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> testData = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      testData.add(new Object[]{id, examples.get(id)});
    }

    return new TxTestData(testData, manifest, externals, folder, name, manifest.asString("code"), manifest.asString("version"));
  }

  private static InputStream loadFile(File folder, String filename) throws IOException {
    File f = ManagedFileAccess.file(Utilities.path(folder.getAbsolutePath(), filename));

    return ManagedFileAccess.inStream(f);
  }
 
  public static TxTestData loadTestDataFromPackage(String source) throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage(source);
    
    String contents = FileUtilities.streamToString(npm.load("tests", "test-cases.json"));
    String externalSource = FileUtilities.streamToString(npm.load("tests", "messages-tx.fhir.org.json"));
    JsonObject externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(externalSource);

    Map<String, TxTestSetup> examples = new HashMap<String, TxTestSetup>();
    JsonObject manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    for (JsonObject suite : manifest.getJsonObjects("suites")) {
      if (!"tx.fhir.org".equals(suite.asString("mode"))) {
        String sn = suite.asString("name");
        for (JsonObject test : suite.getJsonObjects("tests")) {
          String tn = test.asString("name");
          examples.put(sn + "." + tn, new TxTestSetup(suite, test));
        }
      }
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> testData = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      testData.add(new Object[]{id, examples.get(id)});
    }

    return new TxTestData(testData, manifest, externals, npm, manifest.asString("code"), manifest.asString("version"));
  }

  public String load(String fn) throws IOException {
    if (folder != null) {
      return FileUtilities.streamToString(loadFile(folder, fn));
    } else {
      return FileUtilities.streamToString(npm.load("tests", fn));
    }
  }

  public byte[] loadBytes(String fn) throws IOException {
    if (folder != null) {
      return FileUtilities.streamToBytes(loadFile(folder, fn));
    } else {
      return FileUtilities.streamToBytes(npm.load("tests", fn));
    }
  }

  public boolean hasFile(String filename) throws IOException {
    if (folder != null) {
      return ManagedFileAccess.file(Utilities.path(folder.getAbsolutePath(), filename)).exists();
    } else {
      return npm.hasFile("tests", filename);
    }
  }

  public String loadVersion() throws JsonException, IOException {
    if (version == null) {
      return readHistory(loadBytes("history.json"));
    } else {
      return version;
    }
  }

  private String readHistory(byte[] content) throws JsonException, IOException {
    JsonObject json = JsonParser.parseObject(content);
    return json.getJsonObjects("versions").get(0).asString("version");
  }

  public String describe() {
    if (folder != null) {
      return folder.getAbsolutePath();
    } else {
      return npm.name()+"#"+npm.version();
    }
  }

  public String code() {
    return code;
  }

  public String testFileName() {
    return testFileName;
  }

  
}
