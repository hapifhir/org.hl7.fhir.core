package org.hl7.fhir.utilities.npm;

import ca.uhn.fhir.util.ClasspathUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NpmPackageTest {

  @Test
  public void testPackageWithDotSlashResourcePrefix() throws IOException {
    InputStream stream = ClasspathUtil.loadResourceAsStream("/npm/package-with-dotslash-prefix.tgz");
    assertNotNull(stream);
    NpmPackage pkg = NpmPackage.fromPackage(stream);

    assertEquals("hl7.fhir.us.spl", pkg.getNpm().get("name").asString());
    assertEquals(32639, pkg.getProvider("package", "StructureDefinition-SPLAddress.json").getBytes().length);
  }


}