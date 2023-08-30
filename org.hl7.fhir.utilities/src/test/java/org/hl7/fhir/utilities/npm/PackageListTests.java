package org.hl7.fhir.utilities.npm;

import java.net.URISyntaxException;

import org.hl7.fhir.utilities.json.model.JsonObject;
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

}
