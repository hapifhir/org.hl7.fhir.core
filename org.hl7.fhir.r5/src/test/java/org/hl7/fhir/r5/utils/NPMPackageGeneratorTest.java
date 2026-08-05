package org.hl7.fhir.r5.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for {@link NPMPackageGenerator}'s package.json generation.
 * <p>
 * Two kinds of test live here. <em>Fix-pinning</em> tests fail if the corresponding fix is
 * reverted: {@code emitsR5CoreDependency}, {@code emitsR6CoreDependency},
 * {@code mapsRawBasePathVersionCodes}, {@code aliasedCoreDependsOnDoesNotSuppressAutoAdd},
 * {@code noCrashAndAuthorWinsWhenDependsOnAlsoDeclaresCore} (the 4.0.1 row),
 * {@code r4BallotVersionsDoNotEmitUnresolvableCoreDep} and
 * {@code versionlessCoreDependsOnDoesNotCrashAndKeepsAutoAddedCoreDep}.
 * <em>Characterization</em> tests document behaviour that is unchanged or deliberately
 * limited, and pass in both directions: {@code preservesR2ThroughR4BMapping},
 * {@code coreKindEmitsNoDependenciesBlock}, {@code r5PreviewVersionsGetNoCoreDependency},
 * {@code currentVersionCodeAddsNoCoreDependency} and
 * {@code nonSemverVersionCodesAddNoCoreDepAndDoNotThrow}.
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
  @ValueSource(strings = { "0.01", "0.06" })
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

  @Test
  void currentVersionCodeAddsNoCoreDependency() throws IOException {
    // "current" is rejected by SemverParser, so it never reaches VersionUtilities'
    // "current" -> hl7.fhir.r5.core branch (VersionUtilities.java:169-171, unreachable).
    // NPMPackageGenerator pins "no core dep" explicitly so this does not silently flip if
    // VersionUtilities is ever reordered.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, "current");
    Assertions.assertFalse(dep.has("hl7.fhir.r5.core"));
  }

  @ParameterizedTest
  @ValueSource(strings = { "3.2.0", "3.3.0", "3.5.0" })
  void r4BallotVersionsDoNotEmitUnresolvableCoreDep(String fhirVersion) throws IOException {
    // VersionUtilities.isR4Ver matches the R4 ballot line (3.2/3.3/3.5), but these are not
    // hl7.fhir.r4.core versions, so emitting them would publish an unresolvable dependency.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertFalse(dep.has("hl7.fhir.r4.core"), fhirVersion + " must not emit hl7.fhir.r4.core");
    Assertions.assertEquals(0, dep.getProperties().size(), fhirVersion + " must emit no core dependency");
  }

  @ParameterizedTest
  @ValueSource(strings = { "4.2.0", "4.4.0", "4.6.0" })
  void r5PreviewVersionsGetNoCoreDependency(String fhirVersion) throws IOException {
    // Known gap, deliberately pinned: VersionUtilities.isR5Ver matches only 4.5* and 5.0*,
    // so the 4.2/4.4/4.6 R5 preview codes -- all legal FHIRVersion enum members -- still get
    // no core dependency. Widening isR5Ver is an upstream change, tracked separately.
    JsonObject dep = dependencies(minimalIg(), PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertFalse(dep.has("hl7.fhir.r5.core"), fhirVersion + " currently maps to no core package");
  }

  @Test
  void corePackagePrefixTableCoversEveryCorePackage() {
    // VersionUtilities.isCorePackage (VersionUtilities.java:372) enumerates the closed set of
    // core packages. If a family is added upstream, this fails loudly rather than silently
    // dropping the dependency.
    for (String pkg : new String[] { "hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core",
        "hl7.fhir.r4.core", "hl7.fhir.r4b.core", "hl7.fhir.r5.core", "hl7.fhir.r6.core" }) {
      Assertions.assertTrue(VersionUtilities.isCorePackage(pkg));
      Assertions.assertNotNull(NPMPackageGenerator.CORE_PACKAGE_VERSION_PREFIXES.get(pkg),
          pkg + " has no entry in CORE_PACKAGE_VERSION_PREFIXES");
    }
    Assertions.assertEquals(7, NPMPackageGenerator.CORE_PACKAGE_VERSION_PREFIXES.size(),
        "a new core package family was added; extend CORE_PACKAGE_VERSION_PREFIXES");
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

  @ParameterizedTest
  @CsvSource({
      "5.0.0, hl7.fhir.r5.core, http://hl7.org/fhir/R5, 5.0.0-ballot",
      "4.0.1, hl7.fhir.r4.core, http://hl7.org/fhir/R4, 4.0.0",
  })
  void noCrashAndAuthorWinsWhenDependsOnAlsoDeclaresCore(String fhirVersion, String corePackage,
      String uri, String authorVersion) throws IOException {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent d = ig.addDependsOn();
    d.setUri(uri);
    d.setPackageId(corePackage);
    d.setVersion(authorVersion);
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, fhirVersion);
    Assertions.assertTrue(dep.has(corePackage));
    // The author-declared dependsOn version wins; the auto-add is suppressed so
    // JsonObject.add is never called twice for the same key (no duplicate-key crash).
    Assertions.assertEquals(authorVersion, dep.asString(corePackage));
  }

  @Test
  void versionlessDependsOnIsWarnedAndOmittedNotRejected() throws IOException {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent d = ig.addDependsOn();
    d.setUri("http://example.org/fhir/ImplementationGuide/example-dependency");
    d.setPackageId("example.fhir.dependency");
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, "5.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"));
    Assertions.assertFalse(dep.has("example.fhir.dependency"),
        "a versionless dependsOn must not be emitted with a null version");
  }

  @Test
  void versionlessCoreDependsOnDoesNotCrashAndKeepsAutoAddedCoreDep() throws IOException {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent d = ig.addDependsOn();
    d.setUri("http://hl7.org/fhir/R5");
    d.setPackageId("hl7.fhir.r5.core");
    JsonObject dep = dependencies(ig, PackageType.CONFORMANCE, "5.0.0");
    Assertions.assertTrue(dep.has("hl7.fhir.r5.core"));
    Assertions.assertEquals("5.0.0", dep.asString("hl7.fhir.r5.core"));
  }

  @Test
  void missingVersionMessageNamesIgAndDependencyIdentity() {
    ImplementationGuide ig = minimalIg();
    ImplementationGuideDependsOnComponent both = new ImplementationGuideDependsOnComponent();
    both.setPackageId("example.fhir.dependency");
    both.setUri("http://example.org/fhir/ImplementationGuide/example-dependency");
    String m = NPMPackageGenerator.missingVersionMessage(ig, 0, both);
    Assertions.assertTrue(m.contains(PID));
    Assertions.assertTrue(m.contains("dependsOn[0]"));
    Assertions.assertTrue(m.contains("example.fhir.dependency"));
    Assertions.assertTrue(m.contains("http://example.org/fhir/ImplementationGuide/example-dependency"));
    Assertions.assertTrue(m.contains("missing a required version"));

    ImplementationGuideDependsOnComponent uriOnly = new ImplementationGuideDependsOnComponent();
    uriOnly.setUri("http://example.org/fhir/ig");
    String u = NPMPackageGenerator.missingVersionMessage(ig, 1, uriOnly);
    Assertions.assertTrue(u.contains("dependsOn[1]"));
    Assertions.assertTrue(u.contains("http://example.org/fhir/ig"));
    Assertions.assertFalse(u.contains("null"), "absent packageId must not render as null");

    String n = NPMPackageGenerator.missingVersionMessage(ig, 2, new ImplementationGuideDependsOnComponent());
    Assertions.assertTrue(n.contains("dependsOn[2]"));
    Assertions.assertFalse(n.contains("null"), "absent identifiers must not render as null");
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
