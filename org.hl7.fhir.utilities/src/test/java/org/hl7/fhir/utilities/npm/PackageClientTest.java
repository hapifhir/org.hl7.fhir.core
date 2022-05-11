package org.hl7.fhir.utilities.npm;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageClientTest {

  PackageClient packageClient = new PackageClient(PackageClient.PRIMARY_SERVER);

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
    final JsonObject jsonObject = new Gson().fromJson(Files.newBufferedReader(Paths.get(PackageClientTest.class.getClassLoader().getResource(Paths.get("npm","PackageClient-baseTestCase.json").toString()).getPath())), JsonObject.class);
    final PackageInfo packageInfo = packageClient.getPackageInfoFromJSON(jsonObject, null, null, null);

    assertExpectedFields(packageInfo);
  }

  @Test
  @DisplayName("test getting package from JSON works")
  public void getPackageInfoWithIdFromJSONTest() throws java.io.IOException {
    final JsonObject jsonObject = new Gson().fromJson(Files.newBufferedReader(Paths.get(PackageClientTest.class.getClassLoader().getResource(Paths.get("npm", "PackageClient-testCaseWithId.json").toString()).getPath())), JsonObject.class);
    final PackageInfo packageInfo = packageClient.getPackageInfoFromJSON(jsonObject, null, null, null);

    assertExpectedFields(packageInfo);
  }
}
