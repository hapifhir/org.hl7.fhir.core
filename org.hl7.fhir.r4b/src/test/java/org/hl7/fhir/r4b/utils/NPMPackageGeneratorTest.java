package org.hl7.fhir.r4b.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4b.model.ImplementationGuide;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Tests for {@link NPMPackageGenerator}'s package.json generation.
 * <p>
 * This class is a deliberate verbatim mirror of
 * {@code org.hl7.fhir.r5/.../NPMPackageGenerator}'s version-mapping and dependency-loop region,
 * so these tests cover the same behaviour as {@code org.hl7.fhir.r5}'s
 * {@code NPMPackageGeneratorTest} and the two suites should move together. Note this module uses
 * Gson's {@link JsonObject}, not the {@code org.hl7.fhir.utilities.json.model} one, so
 * {@code size()} replaces {@code getProperties().size()} and {@code addProperty(k, null)} stores
 * {@code JsonNull} rather than rejecting the write.
 */
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

  private NPMPackageGenerator generatorFor(ImplementationGuide ig, PackageType kind, String fhirVersion)
      throws IOException {
    Path destFile = Files.createTempFile("npmgen-test", ".tgz");
    destFile.toFile().deleteOnExit();
    // r4b has no single-String fhirVersion overload.
    return new NPMPackageGenerator(destFile.toString(), CANONICAL, WEB, kind, ig, new Date(),
        List.of(fhirVersion), false);
  }

  private JsonObject dependencies(ImplementationGuide ig, PackageType kind, String fhirVersion) throws IOException {
    return generatorFor(ig, kind, fhirVersion).getPackageJ().getAsJsonObject("dependencies");
  }

  @ParameterizedTest
  @CsvSource({
      "1.0.2, hl7.fhir.r2.core",
      "4.0.1, hl7.fhir.r4.core",
      "4.3.0, hl7.fhir.r4b.core",
      "5.0.0, hl7.fhir.r5.core",
  })
  void mapsCoreVersionsToPackages(String fhirVersion, String expectedPackage) throws IOException {
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.get(expectedPackage).getAsString());
  }

  @ParameterizedTest
  @ValueSource(strings = { "5.0", "5.0.0-cibuild", "5.0.0." })
  void malformedAndUnpublishedVersionsDoNotEmitCoreDep(String fhirVersion) throws IOException {
    // "5.0" fails the segment count, "5.0.0-cibuild" fails on the label, and "5.0.0." pins the
    // split("\\.", -1) limit -- without it the trailing empty segment is dropped and the value
    // is emitted raw by the legacy-code fallback.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertEquals(0, dep.size(), fhirVersion + " must emit no core dependency");
  }

  @ParameterizedTest
  @CsvSource({
      "3.0.1.11917, hl7.fhir.r3.core",
      "1.0.2.7202, hl7.fhir.r2.core",
  })
  void fourSegmentLegacyVersionCodes(String fhirVersion, String expectedPackage) throws IOException {
    // SemverParser rejects a fourth dot-segment, so these reach the FHIRException catch and map
    // via the local prefix table. Emitting the raw non-semver string is deliberate: it fails
    // visibly later rather than silently going missing.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.get(expectedPackage).getAsString());
  }

  @Test
  void versionlessCoreDependsOnDoesNotDropAutoAddedCoreDep() throws IOException {
    ImplementationGuide ig = minimalIg();
    ig.addDependsOn().setUri("http://hl7.org/fhir/R5").setPackageId("hl7.fhir.r5.core");
    NPMPackageGenerator gen = generatorFor(ig, PackageType.CONFORMANCE, "5.0.0");
    JsonObject dep = gen.getPackageJ().getAsJsonObject("dependencies");
    // In memory the bug leaves JsonNull under the key, so dep.has(k) is true either way...
    Assertions.assertFalse(dep.get("hl7.fhir.r5.core").isJsonNull());
    Assertions.assertEquals("5.0.0", dep.get("hl7.fhir.r5.core").getAsString());
    // ...and this is the symptom that actually reaches users: the production serializer is
    // new GsonBuilder().setPrettyPrinting().create() (NPMPackageGenerator.buildPackageJson) with
    // serializeNulls off, so a JsonNull value omits the key from package.json entirely. If
    // production ever gains serializeNulls(), this copy must move with it.
    String json = new GsonBuilder().setPrettyPrinting().create().toJson(gen.getPackageJ());
    Assertions.assertTrue(json.contains("hl7.fhir.r5.core"),
        "the auto-added core dependency must survive serialization, not just exist in memory");
  }

  @Test
  void versionlessNonCoreDependsOnIsOmitted() throws IOException {
    ImplementationGuide ig = minimalIg();
    ig.addDependsOn().setUri("http://example.org/fhir/dep").setPackageId("example.fhir.dep");
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, "5.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"));
    Assertions.assertFalse(dep.has("example.fhir.dep"),
        "a versionless dependsOn must not be emitted with a null version");
  }

  @Test
  void versionlessDependsOnCollectsOneMessagePerVersionlessEntry() throws IOException {
    ImplementationGuide ig = minimalIg();
    ig.addDependsOn().setUri("http://example.org/fhir/a").setPackageId("example.a");
    ig.addDependsOn().setUri("http://example.org/fhir/b").setPackageId("example.b").setVersion("1.0.0");
    ig.addDependsOn().setUri("http://example.org/fhir/c").setPackageId("example.c");
    NPMPackageGenerator gen = generatorFor(ig, PackageType.CONFORMANCE, "5.0.0");
    List<String> warnings = gen.getDependencyWarnings();
    Assertions.assertEquals(2, warnings.size(), "one message per versionless dependsOn entry");
    Assertions.assertTrue(warnings.get(0).contains("dependsOn[0]"));
    Assertions.assertTrue(warnings.get(0).contains("example.a"));
    Assertions.assertTrue(warnings.get(1).contains("dependsOn[2]"));
    Assertions.assertTrue(warnings.get(1).contains("example.c"));
  }
}
