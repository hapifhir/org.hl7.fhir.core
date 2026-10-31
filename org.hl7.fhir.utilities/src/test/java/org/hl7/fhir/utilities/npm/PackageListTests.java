package org.hl7.fhir.utilities.npm;

import java.net.URISyntaxException;

import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PackageListTests {

  @Test
  @DisplayName("test reading package list")
  public void getPackageInfoFromJSONTest() throws java.io.IOException, URISyntaxException {
    PackageList pl = new PackageList(JsonParser.parseObject(BaseTestingUtilities.loadTestResource("npm", "package-new.json")));
    Assertions.assertNotNull(pl.ciBuild());

  }

  @Test
  @DisplayName("release binaries are found at binaries-location if given, else at the version's path")
  public void binariesBaseTest() throws java.io.IOException {
    PackageList pl = new PackageList(JsonParser.parseObject("{\"package-id\": \"example.ig\", \"canonical\": \"http://example.org/ig\", \"list\": [" +
        "{\"version\": \"2.0.0\", \"path\": \"http://example.org/ig/2.0.0\", \"binaries-location\": \"https://github.com/example/ig/releases/download/v2.0.0\"}," +
        "{\"version\": \"1.0.0\", \"path\": \"http://example.org/ig/1.0.0\"}]}"));
    Assertions.assertEquals("https://github.com/example/ig/releases/download/v2.0.0", pl.findByVersion("2.0.0").binariesBase());
    Assertions.assertEquals("http://example.org/ig/1.0.0", pl.findByVersion("1.0.0").binariesBase());
    Assertions.assertNull(pl.findByVersion("1.0.0").binariesLocation());
  }

}
