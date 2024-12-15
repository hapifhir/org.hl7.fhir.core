package org.hl7.fhir.validation.special;

import lombok.Getter;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.IOException;
import java.util.*;

public class TxTestData {

  @Getter
  private final JsonObject manifest;

  @Getter
  private final JsonObject externals;

  @Getter
  private final List<Object[]> testData;
  
  private final NpmPackage npm;

  private TxTestData(List<Object[]> testData, JsonObject manifest, JsonObject externals, NpmPackage npm) throws IOException {
    this.testData = testData;
    this.manifest = manifest;
    this.externals = externals;
    this.npm = npm;
  }

  public static TxTestData loadTestDataFromPackage(String version) throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage("hl7.fhir.uv.tx-ecosystem", version);
    
    String contents = TextFile.streamToString(npm.load("tests", "test-cases.json"));
    String externalSource = TextFile.streamToString(npm.load("tests", "messages-tx.fhir.org.json"));
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

    return new TxTestData(testData, manifest, externals, npm);
  }

  public String load(String fn) throws IOException {
    return TextFile.streamToString(npm.load("tests", fn)); 
  }

  public byte[] loadBytes(String fn) throws IOException {
    return TextFile.streamToBytes(npm.load("tests", fn)); 
  }

  public boolean hasFile(String filename) throws IOException {
    return npm.hasFile("tests", filename);
  }

  public String loadVersion() throws JsonException, IOException {
    return readHistory(loadBytes("history.json")); 
  }

  private String readHistory(byte[] content) throws JsonException, IOException {
    JsonObject json = JsonParser.parseObject(content);
    return json.getJsonObjects("versions").get(0).asString("version");
  }

  public String describe() {
    return npm.name()+"#"+npm.version();
  }

  
}
