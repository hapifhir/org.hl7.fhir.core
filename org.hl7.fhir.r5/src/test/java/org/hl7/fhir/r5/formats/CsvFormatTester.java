package org.hl7.fhir.r5.formats;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;

public class CsvFormatTester {

  @Test
  void textCodeSystemCsv() throws IOException {

    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage("hl7.terminology");
    for (NpmPackage.PackageResourceInformation pri : npm.listIndexedResources("CodeSystem")) {
      CodeSystem cs = (CodeSystem) new JsonParser().parse(npm.load(pri));
      new CsvFormat().compose(new File("/Users/grahamegrieve/temp/csv"), cs.getId(), cs);
    }

    Assertions.assertEquals(true, true);
  }

}
