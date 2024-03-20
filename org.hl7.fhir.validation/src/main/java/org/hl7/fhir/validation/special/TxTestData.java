package org.hl7.fhir.validation.special;

import lombok.Getter;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;
import java.util.*;

public class TxTestData {

  @Getter
  private final JsonObject manifest;

  @Getter
  private final JsonObject externals;

  @Getter
  private final List<Object[]> testData;

  private TxTestData(List<Object[]> testData, JsonObject manifest, JsonObject externals) throws IOException {
    this.testData = testData;
    this.manifest = manifest;
    this.externals = externals;
  }

  public static TxTestData loadTestDataFromDefaultClassPath() throws IOException {
    String contents = TestingUtilities.loadTestResource("tx", "test-cases.json");
    String externalSource = TestingUtilities.loadTestResource("tx", "messages-tx.fhir.org.json");
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

    return new TxTestData(testData, manifest, externals);
  }
}
