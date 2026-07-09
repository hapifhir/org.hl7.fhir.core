package org.hl7.fhir.r5.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NPMPackageGeneratorTest {

  private static final String CANONICAL = "http://example.org/fhir/test";
  private static final String WEB = "http://example.org/fhir/test";
  private static final String PID = "hl7.fhir.test";

  private ImplementationGuide minimalIg() {
    ImplementationGuide ig = new ImplementationGuide();
    ig.setPackageId(PID);
    ig.setVersion("0.1.0");
    return ig;
  }

  /**
   * Builds a generator for the given IG/kind/version and returns the generated
   * package.json {@code dependencies} object (or {@code null} when the manifest
   * has no dependencies block, e.g. for a CORE package).
   */
  private JsonObject dependencies(ImplementationGuide ig, PackageType kind, String fhirVersion) throws IOException {
    Path destFile = Files.createTempFile("npmgen-test", ".tgz");
    destFile.toFile().deleteOnExit();
    NPMPackageGenerator gen = new NPMPackageGenerator(PID, destFile.toString(), CANONICAL, WEB, kind, ig, new Date(),
        null, false, fhirVersion);
    return gen.getPackageJ().getJsonObject("dependencies");
  }

  @Test
  void emitsR5CoreDependency() throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, "5.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"));
    Assertions.assertEquals("5.0.0", dep.asString("hl7.fhir.r5.core"));
  }

  @Test
  void emitsR6CoreDependency() throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, "6.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r6.core"));
    Assertions.assertEquals("6.0.0", dep.asString("hl7.fhir.r6.core"));
  }

  @ParameterizedTest
  @CsvSource({
      "5.0, hl7.fhir.r5.core",
      "5.0.0-ballot, hl7.fhir.r5.core",
      "4.5.0, hl7.fhir.r5.core",
  })
  void mapsRawBasePathVersionCodes(String fhirVersion, String expectedPackage) throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.asString(expectedPackage));
  }

  @ParameterizedTest
  @ValueSource(strings = { "current", "0.01", "0.06" })
  void nonSemverVersionCodesAddNoCoreDepAndDoNotThrow(String fhirVersion) throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertFalse(dep.has("hl7.fhir.r2.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r2b.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r3.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r4.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r4b.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r5.core"));
    Assertions.assertFalse(dep.has("hl7.fhir.r6.core"));
  }

  @ParameterizedTest
  @CsvSource({
      "1.0.2, hl7.fhir.r2.core",
      "1.4.0, hl7.fhir.r2b.core",
      "3.0.2, hl7.fhir.r3.core",
      "4.0.1, hl7.fhir.r4.core",
      "4.3.0, hl7.fhir.r4b.core",
  })
  void preservesR2ThroughR4BMapping(String fhirVersion, String expectedPackage) throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.asString(expectedPackage));
  }

  @Test
  void noCrashAndAuthorWinsWhenDependsOnAlsoDeclaresCore() throws IOException {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent d = ig.addDependsOn();
    d.setUri("http://hl7.org/fhir/R5");
    d.setPackageId("hl7.fhir.r5.core");
    d.setVersion("5.0.0-ballot");
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, "5.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"));
    // The author-declared dependsOn version wins; the auto-add is suppressed
    // so JsonObject.add is never called twice for the same key (no crash).
    Assertions.assertEquals("5.0.0-ballot", dep.asString("hl7.fhir.r5.core"));
  }

  @Test
  void coreKindEmitsNoDependenciesBlock() throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CORE, "5.0.0");
    Assertions.assertNull(dep);
  }

  @Test
  void aliasedCoreDependsOnDoesNotSuppressAutoAdd() throws IOException {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent d = ig.addDependsOn();
    d.setId("r5alias");
    d.setUri("http://hl7.org/fhir/R5");
    d.setPackageId("hl7.fhir.r5.core");
    d.setVersion("5.0.0");
    d.getPackageIdElement().setUserData(UserDataNames.IG_DEP_ALIASED, Boolean.TRUE);
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, "5.0.0");
    // An aliased dependsOn produces key "<id>@npm:<packageId>", which cannot
    // collide with the auto-added core key, so it must not suppress the auto-add.
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"), "auto-added core dep must be present");
    Assertions.assertTrue(dep.has("r5alias@npm:hl7.fhir.r5.core"), "aliased dependsOn must be present");
  }
}
