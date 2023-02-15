package org.hl7.fhir.utilities.npm;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PackageClientTest implements ResourceLoaderTests {

  PackageClient packageClient = new PackageClient(PackageServer.primaryServer());

  private void assertExpectedFields(final PackageInfo packageInfo) {
    assertEquals("dummy.package", packageInfo.getId());
    assertEquals("1.2.3", packageInfo.getVersion());
    assertEquals("4.5.6", packageInfo.getFhirVersion());
    assertEquals("Dummy description",
      packageInfo.getDescription());
    assertEquals("https://d.e.f", packageInfo.getUrl());
    assertEquals("https://a.b.c", packageInfo.getCanonical());
  }

  @Test
  @DisplayName("test getting package from JSON works")
  public void getPackageInfoFromJSONTest() throws java.io.IOException, URISyntaxException {
    final JsonObject jsonObject = JsonParser.parseObject(getResourceAsInputStream("npm","PackageClient-baseTestCase.json"));
    final PackageInfo packageInfo = packageClient.getPackageInfoFromJSON(jsonObject, null, null, null);

    assertExpectedFields(packageInfo);
  }

  @Test
  @DisplayName("test getting package from JSON works")
  public void getPackageInfoWithIdFromJSONTest() throws java.io.IOException {
    final JsonObject jsonObject = JsonParser.parseObject(getResourceAsInputStream("npm", "PackageClient-testCaseWithId.json"));
    final PackageInfo packageInfo = packageClient.getPackageInfoFromJSON(jsonObject, null, null, null);

    assertExpectedFields(packageInfo);
  }
}
