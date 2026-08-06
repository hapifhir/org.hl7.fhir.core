package org.hl7.fhir.r4b.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4b.model.ContactDetail;
import org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.ImplementationGuide;
import org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
 * <p>
 * <em>Fix-pinning</em> tests here: {@code mapsCoreVersionsToPackages},
 * {@code malformedAndUnpublishedVersionsDoNotEmitCoreDep},
 * {@code fourSegmentLegacyVersionCodes},
 * {@code versionlessCoreDependsOnDoesNotDropAutoAddedCoreDep},
 * {@code wildcardFhirVersionsEmitCoreDependencyVerbatim} (the wildcard regression) and
 * {@code wildcardCiBuildVersionsDoNotEmitCoreDep}.
 * <em>Characterization</em>: {@code minorLevelWildcardsStillEmitNoCoreDep}.
 * {@code wildcardR5AndR6VersionsEmitCoreDependency} is in neither group -- those two rows are
 * <em>not</em> master-consistent, being the composition of this branch's r5/r6 mapping fix with
 * the wildcard carve-out.
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

  @ParameterizedTest
  @CsvSource({
      "4.0.x, hl7.fhir.r4.core",
      "4.0.*, hl7.fhir.r4.core",
      "1.0.x, hl7.fhir.r2.core",
      "4.3.x, hl7.fhir.r4b.core",
  })
  void wildcardFhirVersionsEmitCoreDependencyVerbatim(String fhirVersion, String expectedPackage)
      throws IOException {
    // The reported regression, mirrored from r5. Every row here is master-consistent: master
    // emitted the wildcard verbatim and the publishable-shape gate swallowed it.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.get(expectedPackage).getAsString(),
        "the wildcard must be emitted verbatim, not normalized");
  }

  @ParameterizedTest
  @CsvSource({
      "5.0.x, hl7.fhir.r5.core",
      "6.0.x, hl7.fhir.r6.core",
  })
  void wildcardR5AndR6VersionsEmitCoreDependency(String fhirVersion, String expectedPackage)
      throws IOException {
    // Kept separate from the rows above because these two are NOT master-consistent: master
    // mapped no 5.0 or 6.0 line, so it emitted nothing. They are the composition of this
    // branch's r5/r6 mapping fix with the wildcard carve-out.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(expectedPackage), fhirVersion + " should map to " + expectedPackage);
    Assertions.assertEquals(fhirVersion, dep.get(expectedPackage).getAsString());
  }

  @ParameterizedTest
  @ValueSource(strings = { "4.x", "*" })
  void minorLevelWildcardsStillEmitNoCoreDep(String fhirVersion) throws IOException {
    // Characterization: master dropped both too. "*" never clears isSemVerWithWildcards, which
    // requires an integer major (VersionUtilities.java:480); "4.x" clears the gate and is
    // dropped further down, because VersionUtilities.packageForVersion matches on a literal
    // major.minor prefix and returns null.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertEquals(0, dep.size(), fhirVersion + " must emit no core dependency");
  }

  @ParameterizedTest
  @ValueSource(strings = { "5.0.x-cibuild" })
  void wildcardCiBuildVersionsDoNotEmitCoreDep(String fhirVersion) throws IOException {
    // Not vacuous: this clears both versionHasWildcards and isSemVerWithWildcards, so the only
    // thing rejecting it is the !hasCiBuildLabel(v) clause in isResolvableWildcardVersion.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertEquals(0, dep.size(), fhirVersion + " must emit no core dependency");
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
    // NPMPackageGenerator.packageJsonGson(), and a JsonNull value under this key would push the
    // auto-added core dependency out of package.json. The factory is package-private precisely
    // so this test cannot drift from the serializer production actually uses.
    String json = NPMPackageGenerator.packageJsonGson().toJson(gen.getPackageJ());
    Assertions.assertTrue(json.contains("hl7.fhir.r5.core"),
        "the auto-added core dependency must survive serialization, not just exist in memory");
  }

  @Test
  void absentOptionalPropertiesAreOmittedNotSerializedAsNull() throws IOException {
    // serializeNulls is on, so a presence-only guard would turn every unset optional into a
    // JSON null. addIfNotNull guards by value instead, so they stay absent entirely. The
    // quoted tokens below do not collide with "tools-version" or "fhirVersions": neither has a
    // quote immediately before the matched text.
    ImplementationGuide ig = new ImplementationGuide();
    Path destFile = Files.createTempFile("npmgen-test", ".tgz");
    destFile.toFile().deleteOnExit();
    NPMPackageGenerator gen = new NPMPackageGenerator(destFile.toString(), null, null,
        PackageType.CONFORMANCE, ig, new Date(), List.of("5.0.0"), false);
    String json = NPMPackageGenerator.packageJsonGson().toJson(gen.getPackageJ());
    Assertions.assertFalse(json.contains("\"name\""), "an unset packageId must not be written");
    Assertions.assertFalse(json.contains("\"version\""), "an unset version must not be written");
    Assertions.assertFalse(json.contains("\"canonical\""), "a null canonical must not be written");
    Assertions.assertFalse(json.contains("\"url\""), "a null web url must not be written");
  }

  @Test
  void fullyPopulatedIgSerializesNoNullValues() throws IOException {
    // The real blast-radius guard for serializeNulls. The title is deliberately a StringType
    // carrying only an extension: hasTitle() is true (Element.isEmpty() is false once an
    // extension is present) while getTitle() is null, which is exactly the presence-vs-value
    // gap addIfNotNull closes. Without the helper that property serializes as "title": null.
    // If any string-valued property in buildPackageJson ever escapes the helper, this fails.
    // The dependsOn entry is deliberately versioned: a versionless one legitimately produces
    // ": null", which is the one key the serializer change exists to allow.
    ImplementationGuide ig = minimalIg();
    ig.setLicense(SPDXLicense.CC0_1_0);
    StringType extensionOnlyTitle = new StringType();
    extensionOnlyTitle.addExtension("http://hl7.org/fhir/StructureDefinition/data-absent-reason",
        new CodeType("unknown"));
    ig.setTitleElement(extensionOnlyTitle);
    ig.setDescription("A test IG");
    ig.setPublisher("Example Publisher");
    ContactDetail c = ig.addContact();
    c.setName("Example Contact");
    c.addTelecom().setSystem(ContactPointSystem.EMAIL).setValue("test@example.org");
    c.addTelecom().setSystem(ContactPointSystem.URL).setValue("http://example.org/contact");
    ig.getManifest().setRendering("http://example.org/rendering");
    ig.addDependsOn().setUri("http://example.org/fhir/dep").setPackageId("example.dep").setVersion("1.0.0");
    Path destFile = Files.createTempFile("npmgen-test", ".tgz");
    destFile.toFile().deleteOnExit();
    NPMPackageGenerator gen = new NPMPackageGenerator(destFile.toString(), CANONICAL, WEB,
        PackageType.CONFORMANCE, ig, new Date(), List.of("5.0.0"), true);
    Assertions.assertTrue(ig.hasTitle(), "the extension-only title must still satisfy hasTitle()");
    Assertions.assertNull(ig.getTitle(), "...while its value is null -- otherwise this test is vacuous");
    String json = NPMPackageGenerator.packageJsonGson().toJson(gen.getPackageJ());
    Assertions.assertFalse(json.contains(": null"),
        "no property may serialize as a JSON null: " + json);
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
