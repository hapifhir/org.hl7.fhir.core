package org.hl7.fhir.services.utilities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.IdType;
import org.hl7.fhir.model.core.ImplementationGuide;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.services.utilities.PackageDependencyPlanner.Entry;
import org.hl7.fhir.services.utilities.PackageDependencyPlanner.Result;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PackageDependencyPlannerTest {

  // Literal expectations for the policy mirrored from R5 utils/NPMPackageGenerator.java.
  @ParameterizedTest
  @CsvSource({
      "1.0.2, hl7.fhir.r2.core, 1.0.2",
      "1.4.0, hl7.fhir.r2b.core, 1.4.0",
      "3.0.2, hl7.fhir.r3.core, 3.0.2",
      "4.0.1, hl7.fhir.r4.core, 4.0.1",
      "4.1.0, hl7.fhir.r4b.core, 4.1.0",
      "4.3.0, hl7.fhir.r4b.core, 4.3.0",
      "4.5.0, hl7.fhir.r5.core, 4.5.0",
      "5.0.0, hl7.fhir.r5.core, 5.0.0",
      "6.0.0, hl7.fhir.r6.core, 6.0.0",
      "5.0.0-ballot, hl7.fhir.r5.core, 5.0.0-ballot",
      "5.0.0-snapshot1, hl7.fhir.r5.core, 5.0.0-snapshot1",
      "5.0.0-draft-final, hl7.fhir.r5.core, 5.0.0-draft-final",
      "6.0.0-ballot3, hl7.fhir.r6.core, 6.0.0-ballot3",
      "5.0.0+build.1, hl7.fhir.r5.core, 5.0.0+build.1",
      "5.0.0-build.CIBUILD, hl7.fhir.r5.core, 5.0.0-build.CIBUILD",
      "1.0.x, hl7.fhir.r2.core, 1.0.x",
      "1.0.X, hl7.fhir.r2.core, 1.0.X",
      "1.0.*, hl7.fhir.r2.core, 1.0.*",
      "1.4.x, hl7.fhir.r2b.core, 1.4.x",
      "1.4.X, hl7.fhir.r2b.core, 1.4.X",
      "1.4.*, hl7.fhir.r2b.core, 1.4.*",
      "3.0.x, hl7.fhir.r3.core, 3.0.x",
      "3.0.X, hl7.fhir.r3.core, 3.0.X",
      "3.0.*, hl7.fhir.r3.core, 3.0.*",
      "4.0.x, hl7.fhir.r4.core, 4.0.x",
      "4.0.X, hl7.fhir.r4.core, 4.0.X",
      "4.0.*, hl7.fhir.r4.core, 4.0.*",
      "4.1.x, hl7.fhir.r4b.core, 4.1.x",
      "4.3.X, hl7.fhir.r4b.core, 4.3.X",
      "4.3.*, hl7.fhir.r4b.core, 4.3.*",
      "4.5.x, hl7.fhir.r5.core, 4.5.x",
      "5.0.x, hl7.fhir.r5.core, 5.0.x",
      "5.0.X, hl7.fhir.r5.core, 5.0.X",
      "5.0.*, hl7.fhir.r5.core, 5.0.*",
      "6.0.x, hl7.fhir.r6.core, 6.0.x",
      "6.0.X, hl7.fhir.r6.core, 6.0.X",
      "6.0.*, hl7.fhir.r6.core, 6.0.*"
  })
  void supportedVersionsPreserveExactValue(String version, String packageId, String expectedVersion) {
    Result result = PackageDependencyPlanner.plan(guide(), List.of(version), PackageType.CONFORMANCE);

    assertTrue(result.hasDependencies());
    assertEntries(result, entry(packageId, expectedVersion));
    assertTrue(result.getWarnings().isEmpty());
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = {
      "current", "1.0", "1.4", "3.0", "4.0", "4.1", "4.3", "4.5", "5.0", "6.0",
      "0.01", "0.06", "5.0.0.", "5..0.0", "5.0.a", "not-a-version", "01.0.2",
      "4.x", "5.x", "6.x", "x.x.x", "x", "*",
      "3.2.0", "3.3", "3.3.0", "3.5", "3.5.0",
      "4.2.0", "4.4.0", "4.6.0", "2.0.0", "5.1.0", "6.1.0", "7.0.0",
      "1.0.2-cibuild", "1.4.0+CIBUILD", "3.0.2-CiBuild", "4.0.1+cibuild", "4.3.0-CIBUILD",
      "5.0.0-cibuild", "5.0.0-CIBUILD", "6.0.0-CiBuild",
      "5.0.0+cibuild", "5.0.0+CIBUILD", "6.0.0+CiBuild",
      "5.0.0-CIBUILD1", "5.0.0+cibuild.extra",
      "4.0.x-cibuild", "5.0.x-cibuild", "5.0.x-CIBUILD", "6.0.X-CiBuild",
      "5.0.*+CIBUILD", "6.0.x+CiBuild", "5.0.x+CIBUILD"
  })
  void unsupportedVersionsEmitNoCoreEntry(String version) {
    Result result = PackageDependencyPlanner.plan(guide(), Arrays.asList(version), PackageType.CONFORMANCE);

    assertTrue(result.hasDependencies());
    assertEntries(result);
    assertTrue(result.getWarnings().isEmpty());
  }

  @ParameterizedTest
  @CsvSource({
      "3.0.1.11917, hl7.fhir.r3.core, 3.0.1.11917",
      "1.0.2.7202, hl7.fhir.r2.core, 1.0.2.7202",
      "1.0.2-, hl7.fhir.r2.core, 1.0.2-",
      "1.0.2+, hl7.fhir.r2.core, 1.0.2+",
      "1.0.2-!!!, hl7.fhir.r2.core, 1.0.2-!!!",
      "1.0.2-+, hl7.fhir.r2.core, 1.0.2-+",
      "1.0.2-01, hl7.fhir.r2.core, 1.0.2-01"
  })
  void legacyAndMalformedLabelFallbacksPreserveBranchBehavior(String version, String packageId,
      String expectedVersion) {
    Result result = PackageDependencyPlanner.plan(guide(), List.of(version), PackageType.CONFORMANCE);

    assertEntries(result, entry(packageId, expectedVersion));
    assertTrue(result.getWarnings().isEmpty());
  }

  @Test
  @ResourceLock(Resources.LOCALE)
  void ciBuildDetectionIsLocaleIndependent() {
    Locale previous = Locale.getDefault();
    Locale previousDisplay = Locale.getDefault(Locale.Category.DISPLAY);
    Locale previousFormat = Locale.getDefault(Locale.Category.FORMAT);
    try {
      Locale.setDefault(Locale.forLanguageTag("tr-TR"));
      for (String version : List.of("5.0.0-CIBUILD", "6.0.0-CiBuild", "5.0.0+CIBUILD",
          "6.0.0+CiBuild", "5.0.x-CIBUILD", "6.0.X-CiBuild", "5.0.x+CIBUILD", "6.0.*+CiBuild")) {
        assertEntries(PackageDependencyPlanner.plan(guide(), List.of(version), PackageType.CONFORMANCE));
      }
      assertEntries(PackageDependencyPlanner.plan(guide(), List.of("5.0.0-ballot"), PackageType.CONFORMANCE),
          entry("hl7.fhir.r5.core", "5.0.0-ballot"));
    } finally {
      Locale.setDefault(previous);
      Locale.setDefault(Locale.Category.DISPLAY, previousDisplay);
      Locale.setDefault(Locale.Category.FORMAT, previousFormat);
    }
  }

  @Test
  void inferencePreservesSuppliedOrderAndFirstFamilyValue() {
    ImplementationGuide ig = guide();
    ig.addDependsOn(dependency("example.first", "1.2.3"));
    ig.addDependsOn(dependency("example.last", null));
    List<String> versions = List.of("current", "6.0.0-ballot3", "5.0.0-snapshot1", "6.0.0",
        "4.3.0", "4.1.0", "4.5.0", "1.0.2", "3.0.2", "1.4.0", "4.0.1", "5.0.x");

    Result result = PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r6.core", "6.0.0-ballot3"),
        entry("hl7.fhir.r5.core", "5.0.0-snapshot1"), entry("hl7.fhir.r4b.core", "4.3.0"),
        entry("hl7.fhir.r2.core", "1.0.2"), entry("hl7.fhir.r3.core", "3.0.2"),
        entry("hl7.fhir.r2b.core", "1.4.0"), entry("hl7.fhir.r4.core", "4.0.1"),
        entry("example.first", "1.2.3"), entry("example.last", null));
    assertEquals(1, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 1, "example.last");
  }

  @ParameterizedTest
  @CsvSource({
      "4.0.1, hl7.fhir.r4.core, 4.0.0",
      "5.0.0, hl7.fhir.r5.core, 5.0.0-ballot",
      "6.0.0, hl7.fhir.r6.core, 6.0.0-ballot3"
  })
  void ordinaryCoreDeclarationOverridesInference(String version, String packageId, String authorVersion) {
    ImplementationGuide ig = guide();
    ig.addDependsOn(dependency("example.first", "1.2.3"));
    DependencyProbe declared = dependency(packageId, authorVersion);
    declared.storedPackageId().setUserData(UserDataNames.IG_DEP_ALIASED, null);
    ig.addDependsOn(declared);

    Result result = PackageDependencyPlanner.plan(ig, List.of(version, "3.0.2"), PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r3.core", "3.0.2"), entry("example.first", "1.2.3"),
        entry(packageId, authorVersion));
    assertTrue(result.getWarnings().isEmpty());
    assertFalse(declared.storedPackageId().hasUserData(UserDataNames.IG_DEP_ALIASED));
    assertTrue(declared.storedPackageId().getUserDataNames().contains(UserDataNames.IG_DEP_ALIASED));
    assertNull(declared.storedPackageId().getUserData(UserDataNames.IG_DEP_ALIASED));
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void aliasesDoNotSuppressRawCoreInference(boolean marker) {
    ImplementationGuide ig = guide();
    ig.addDependsOn(alias("hl7.fhir.r5.core", "5.0.0-ballot", "r5alias", marker));
    ig.addDependsOn(dependency("example.dep", null));
    ig.addDependsOn(alias("example.dep", "2.0.0", "other", marker));

    Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0", "6.0.0"), PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"), entry("hl7.fhir.r6.core", "6.0.0"),
        entry("r5alias@npm:hl7.fhir.r5.core", "5.0.0-ballot"), entry("example.dep", null),
        entry("other@npm:example.dep", "2.0.0"));
    assertEquals(1, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 1, "example.dep");
    assertTrue(replay(result).getJsonObject("dependencies").hasNull("example.dep"));
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void incompleteDeclarationsCannotDisplaceCompleteOrdinaryEntries(boolean incompleteFirst) {
    ImplementationGuide ig = guide();
    DependencyProbe incomplete = dependency("example.dep", null);
    DependencyProbe complete = dependency("example.dep", "2.3.4");
    ig.addDependsOn(incompleteFirst ? incomplete : complete);
    ig.addDependsOn(incompleteFirst ? complete : incomplete);

    Result result = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);

    assertEntries(result, entry("example.dep", "2.3.4"));
    assertEquals(1, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", incompleteFirst ? 0 : 1, "example.dep");
    assertEquals("2.3.4", replay(result).getJsonObject("dependencies").asString("example.dep"));
  }

  @Test
  void incompleteDeclarationsWarnInOriginalOrder() {
    ImplementationGuide ig = guide();
    ig.addDependsOn(dependency("example.a", null).setUri("http://example.org/a"));
    ig.addDependsOn(dependency("example.complete", "1.0.0"));
    ig.addDependsOn(noSave(new DependencyProbe(), true, false));
    ig.addDependsOn(dependency("example.a", null));
    ig.addDependsOn(dependency("hl7.fhir.r5.core", null).setUri("http://hl7.org/fhir/R5"));
    ig.addDependsOn(new DependencyProbe().setUri("http://example.org/uri-only"));
    ig.addDependsOn(new DependencyProbe());
    ig.addDependsOn(dependency("example.complete", null));

    Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0"), PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"), entry("example.a", null),
        entry("example.complete", "1.0.0"));
    List<String> warnings = result.getWarnings();
    assertEquals(6, warnings.size());
    assertWarning(warnings.get(0), "example.guide", 0, "example.a", "http://example.org/a");
    assertWarning(warnings.get(1), "example.guide", 3, "example.a");
    assertWarning(warnings.get(2), "example.guide", 4, "hl7.fhir.r5.core", "http://hl7.org/fhir/R5");
    assertWarning(warnings.get(3), "example.guide", 5, "http://example.org/uri-only");
    assertWarning(warnings.get(4), "example.guide", 6);
    assertWarning(warnings.get(5), "example.guide", 7, "example.complete");
    assertFalse(warnings.get(3).contains("packageId="));
    assertFalse(warnings.get(4).contains("packageId="));
    assertFalse(warnings.get(4).contains("uri="));
    JsonObject dependencies = replay(result).getJsonObject("dependencies");
    assertTrue(dependencies.hasNull("example.a"));
    assertEquals(3, dependencies.getProperties().size());
  }

  @ParameterizedTest
  @MethodSource("suppressionCases")
  void suppressionIsDeclarationLocal(boolean modifier, boolean extensionValue, boolean suppressedFirst,
      String packageId, String suppressedVersion, String ordinaryVersion) {
    ImplementationGuide ig = guide();
    DependencyProbe suppressed = noSave(dependency(packageId, suppressedVersion), modifier, extensionValue);
    DependencyProbe ordinary = dependency(packageId, ordinaryVersion);
    ig.addDependsOn(suppressedFirst ? suppressed : ordinary);
    ig.addDependsOn(suppressedFirst ? ordinary : suppressed);

    Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0"), PackageType.CONFORMANCE);

    if ("hl7.fhir.r5.core".equals(packageId)) {
      assertEntries(result, entry("hl7.fhir.r5.core", ordinaryVersion));
    } else {
      assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"), entry("example.dep", ordinaryVersion));
    }
    assertEquals(ordinaryVersion == null ? 1 : 0, result.getWarnings().size());
    if (ordinaryVersion == null) {
      assertWarning(result.getWarnings().get(0), "example.guide", suppressedFirst ? 1 : 0, packageId);
      assertTrue(replay(result).getJsonObject("dependencies").hasNull(packageId));
    } else {
      assertEquals("1.2.3", replay(result).getJsonObject("dependencies").asString(packageId));
    }
    assertTrue(suppressed.hasExtension(ExtensionDefinitions.EXT_IGDEP_NO_SAVE));
    List<Extension> extensions = modifier ? suppressed.storedModifiers() : suppressed.storedExtensions();
    assertEquals(1, extensions.size());
    assertEquals(extensionValue, ((BooleanType) extensions.get(0).getValue()).getValue());
    assertNull(modifier ? suppressed.storedExtensions() : suppressed.storedModifiers());
    assertNull(ordinary.storedExtensions());
    assertNull(ordinary.storedModifiers());
  }

  static Stream<Arguments> suppressionCases() {
    List<Arguments> cases = new ArrayList<>();
    for (boolean modifier : List.of(false, true)) {
      for (boolean extensionValue : List.of(false, true)) {
        for (boolean suppressedFirst : List.of(false, true)) {
          for (String packageId : List.of("hl7.fhir.r5.core", "example.dep")) {
            for (String suppressedVersion : Arrays.asList(null, "9.9.9")) {
              for (String ordinaryVersion : Arrays.asList(null, "1.2.3")) {
                cases.add(arguments(modifier, extensionValue, suppressedFirst, packageId,
                    suppressedVersion, ordinaryVersion));
              }
            }
          }
        }
      }
    }
    return cases.stream();
  }

  @ParameterizedTest
  @CsvSource({"false, false", "false, true", "true, false", "true, true"})
  void noSaveAloneSuppressesInferenceAndWarnings(boolean modifier, boolean extensionValue) {
    ImplementationGuide ig = guide();
    ig.addDependsOn(noSave(dependency("hl7.fhir.r5.core", null), modifier, extensionValue));
    ig.addDependsOn(noSave(dependency("example.dep", "9.9.9"), modifier, extensionValue));
    ig.addDependsOn(noSave(new DependencyProbe(), modifier, extensionValue));

    Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0"), PackageType.CONFORMANCE);

    assertTrue(result.hasDependencies());
    assertEntries(result);
    assertTrue(result.getWarnings().isEmpty());
  }

  @ParameterizedTest
  @CsvSource({"false, false", "false, true", "true, false", "true, true"})
  void suppressedAliasesDoNotSuppressRawCoreInference(boolean modifier, boolean extensionValue) {
    for (boolean marker : List.of(false, true)) {
      ImplementationGuide ig = guide();
      ig.addDependsOn(noSave(alias("hl7.fhir.r5.core", null, "alias", marker), modifier, extensionValue));

      Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0"), PackageType.CONFORMANCE);

      assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"));
      assertTrue(result.getWarnings().isEmpty());
    }
  }

  @Test
  void corePlanOmitsDependenciesButKeepsWarnings() {
    ImplementationGuide ig = guide();
    ig.addDependsOn(dependency("example.missing", null));
    ig.addDependsOn(new DependencyProbe().setVersion("1.0.0"));
    ig.addDependsOn(dependency("example.duplicate", "1.0.0"));
    ig.addDependsOn(dependency("example.duplicate", "2.0.0"));
    ig.addDependsOn(new DependencyProbe());
    ig.addDependsOn(noSave(dependency("example.suppressed", null), true, false));
    StringType presentNull = new StringType();
    presentNull.addExtension(extension("http://example.org/present", new BooleanType(false)));
    ig.addDependsOn(new DependencyProbe().setVersionElement(presentNull));

    Result result = assertDoesNotThrow(
        () -> PackageDependencyPlanner.plan(ig, Arrays.asList("6.0.0", null), PackageType.CORE));

    assertFalse(result.hasDependencies());
    assertEntries(result);
    assertEquals(2, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 0, "example.missing");
    assertWarning(result.getWarnings().get(1), "example.guide", 4);
    assertFalse(replay(result).has("dependencies"));
  }

  @ParameterizedTest
  @EnumSource(value = PackageType.class, names = "CORE", mode = EnumSource.Mode.EXCLUDE)
  void nonCorePlansAlwaysOwnDependenciesBlock(PackageType kind) {
    Result result = PackageDependencyPlanner.plan(guide(), List.of(), kind);

    assertTrue(result.hasDependencies());
    assertEntries(result);
    assertTrue(result.getWarnings().isEmpty());
    assertTrue(replay(result).has("dependencies"));
    assertTrue(replay(result).getJsonObject("dependencies").getProperties().isEmpty());
  }

  @Test
  void presencePredicatesAreNotStringNullChecks() {
    ImplementationGuide ig = guide();
    ig.addDependsOn(dependency("hl7.fhir.r5.core", null));
    DependencyProbe presentVersion = dependency("hl7.fhir.r5.core", null);
    StringType version = new StringType();
    version.addExtension(extension("http://example.org/present", new BooleanType(false)));
    presentVersion.setVersionElement(version);
    ig.addDependsOn(presentVersion);

    DependencyProbe metadataPackageId = new DependencyProbe();
    IdType packageId = new IdType();
    packageId.addExtension(extension("http://example.org/present", new BooleanType(false)));
    metadataPackageId.setPackageIdElement(packageId);
    ig.addDependsOn(metadataPackageId);

    DependencyProbe userDataVersion = dependency("example.userdata", null);
    StringType userDataOnly = new StringType();
    Object content = new Object();
    userDataOnly.setUserData("keep", content);
    userDataVersion.setVersionElement(userDataOnly);
    ig.addDependsOn(userDataVersion);
    DependencyProbe metadataUri = new DependencyProbe();
    CanonicalType uri = new CanonicalType();
    uri.addExtension(extension("http://example.org/present", new BooleanType(false)));
    metadataUri.setUriElement(uri);
    ig.addDependsOn(metadataUri);

    Result result = PackageDependencyPlanner.plan(ig, List.of("5.0.0"), PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r5.core", null), entry("example.userdata", null));
    assertTrue(presentVersion.hasVersion());
    assertNull(presentVersion.getVersion());
    assertFalse(metadataPackageId.hasPackageId());
    assertNull(metadataPackageId.getPackageId());
    assertFalse(userDataVersion.hasVersion());
    assertSame(content, userDataOnly.getUserData("keep"));
    assertTrue(metadataUri.hasUri());
    assertNull(metadataUri.getUri());
    assertEquals(4, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 0, "hl7.fhir.r5.core");
    assertWarning(result.getWarnings().get(1), "example.guide", 2);
    assertWarning(result.getWarnings().get(2), "example.guide", 3, "example.userdata");
    assertWarning(result.getWarnings().get(3), "example.guide", 4);
    assertFalse(result.getWarnings().get(3).contains("uri="));
    assertTrue(replay(result).getJsonObject("dependencies").hasNull("hl7.fhir.r5.core"));
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(booleans = {true, false})
  void metadataOnlyPackageIdsStillCarryAliasMarkers(Boolean marker) {
    ImplementationGuide ig = guide();
    DependencyProbe d = new DependencyProbe();
    IdType packageId = new IdType();
    packageId.setUserData(UserDataNames.IG_DEP_ALIASED, marker);
    d.setPackageIdElement(packageId);
    d.setId("metadata-alias");
    d.setVersion("1.2.3");
    ig.addDependsOn(d);

    Result result = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);

    assertEntries(result, entry(marker == null ? null : "metadata-alias@npm:null", "1.2.3"));
    assertFalse(d.hasPackageId());
    assertSame(packageId, d.storedPackageId());
    assertSame(marker, packageId.getUserData(UserDataNames.IG_DEP_ALIASED));
    assertEquals(Set.of(UserDataNames.IG_DEP_ALIASED), packageId.getUserDataNames());
    assertTrue(result.getWarnings().isEmpty());
    if (marker == null) {
      assertThrows(JsonException.class, () -> replay(result));
    } else {
      assertEquals("1.2.3", replay(result).getJsonObject("dependencies").asString("metadata-alias@npm:null"));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"duplicate-complete", "incomplete-alias-first", "null-name", "null-name-and-value"})
  void orderedEntriesRetainStrictSerializationFailures(String scenario) {
    ImplementationGuide ig = guide();
    Entry[] expected;
    int warningCount = 0;
    switch (scenario) {
    case "duplicate-complete":
      ig.addDependsOn(dependency("example.dep", "1.0.0"));
      ig.addDependsOn(dependency("example.dep", "2.0.0"));
      expected = new Entry[] {entry("example.dep", "1.0.0"), entry("example.dep", "2.0.0")};
      break;
    case "incomplete-alias-first":
      ig.addDependsOn(alias("example.dep", null, "alias", false));
      ig.addDependsOn(alias("example.dep", "1.0.0", "alias", true));
      expected = new Entry[] {entry("alias@npm:example.dep", null), entry("alias@npm:example.dep", "1.0.0")};
      warningCount = 1;
      break;
    case "null-name":
      ig.addDependsOn(new DependencyProbe().setVersion("1.0.0"));
      expected = new Entry[] {entry(null, "1.0.0")};
      break;
    case "null-name-and-value":
      StringType presentNull = new StringType();
      presentNull.addExtension(extension("http://example.org/present", new BooleanType(false)));
      ig.addDependsOn(new DependencyProbe().setVersionElement(presentNull));
      expected = new Entry[] {entry(null, null)};
      break;
    default:
      throw new IllegalArgumentException(scenario);
    }

    Result result = assertDoesNotThrow(
        () -> PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE));

    assertEntries(result, expected);
    assertEquals(warningCount, result.getWarnings().size());
    if (warningCount != 0) {
      assertWarning(result.getWarnings().get(0), "example.guide", 0, "example.dep");
    }
    JsonException failure = assertThrows(JsonException.class, () -> replay(result));
    assertTrue(failure.getMessage().contains(scenario.startsWith("null-name") ? "Name is null" : "already exists"));
  }

  @Test
  void completeAliasBeforeIncompleteRetainsExistingKeyGuard() {
    ImplementationGuide ig = guide();
    ig.addDependsOn(alias("example.dep", "1.0.0", "alias", false));
    ig.addDependsOn(alias("example.dep", null, "alias", true));

    Result result = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);

    assertEntries(result, entry("alias@npm:example.dep", "1.0.0"));
    assertEquals(1, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 1, "example.dep");
    assertDoesNotThrow(() -> replay(result));
  }

  @ParameterizedTest
  @CsvSource({"example.dep, false", "alias@npm:example.dep, true"})
  void incompleteAliasesUseEffectiveKeysForOrdinaryLookahead(String rawPackageId, boolean covered) {
    ImplementationGuide ig = guide();
    ig.addDependsOn(alias("example.dep", null, "alias", false));
    ig.addDependsOn(dependency(rawPackageId, "1.0.0"));

    Result result = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);

    if (covered) {
      assertEntries(result, entry("alias@npm:example.dep", "1.0.0"));
    } else {
      assertEntries(result, entry("alias@npm:example.dep", null), entry("example.dep", "1.0.0"));
    }
    assertEquals(1, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "example.guide", 0, "example.dep");
    assertDoesNotThrow(() -> replay(result));
  }

  @Test
  void plannerDoesNotCreateOrRewriteInputStructure() {
    GuideProbe absent = new GuideProbe();
    List<String> versions = new ArrayList<>(Arrays.asList("6.0.0", null, "current"));

    Result absentResult = PackageDependencyPlanner.plan(absent, versions, PackageType.CONFORMANCE);

    assertEntries(absentResult, entry("hl7.fhir.r6.core", "6.0.0"));
    assertTrue(absentResult.getWarnings().isEmpty());
    assertNull(absent.storedDependsOn());
    assertNull(absent.storedPackageId());
    assertNull(absent.storedExtensions());
    assertNull(absent.storedModifiers());
    assertEquals(Arrays.asList("6.0.0", null, "current"), versions);

    GuideProbe allocatedGuide = new GuideProbe();
    List<ImplementationGuideDependsOnComponent> declarations = allocatedGuide.getDependsOnList();
    Result emptyResult = PackageDependencyPlanner.plan(allocatedGuide, List.of(), PackageType.CONFORMANCE);
    assertEntries(emptyResult);
    assertTrue(emptyResult.getWarnings().isEmpty());
    assertSame(declarations, allocatedGuide.storedDependsOn());
    assertTrue(declarations.isEmpty());
    assertNull(allocatedGuide.storedPackageId());

    DependencyProbe empty = new DependencyProbe();
    DependencyProbe allocated = new DependencyProbe();
    IdType packageId = new IdType();
    StringType version = new StringType();
    CanonicalType uri = new CanonicalType();
    StringType id = new StringType();
    allocated.setPackageIdElement(packageId);
    allocated.setVersionElement(version);
    allocated.setUriElement(uri);
    allocated.setIdElement(id);
    List<Extension> extensions = allocated.getExtensionList();
    List<Extension> modifiers = allocated.getModifierExtensionList();
    Object content = new Object();
    empty.setUserData("keep", content);
    allocated.setUserData("keep", content);
    allocatedGuide.addDependsOn(empty);
    allocatedGuide.addDependsOn(allocated);

    Result result = PackageDependencyPlanner.plan(allocatedGuide, versions, PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r6.core", "6.0.0"));
    assertEquals(2, result.getWarnings().size());
    assertWarning(result.getWarnings().get(0), "(packageId not specified)", 0);
    assertWarning(result.getWarnings().get(1), "(packageId not specified)", 1);
    assertFalse(allocatedGuide.hasDependsOn(), "native emptiness must not hide indexed declarations");
    assertSame(declarations, allocatedGuide.storedDependsOn());
    assertEquals(2, declarations.size());
    assertSame(empty, declarations.get(0));
    assertSame(allocated, declarations.get(1));
    assertNull(allocatedGuide.storedPackageId());
    assertNull(allocatedGuide.storedExtensions());
    assertNull(allocatedGuide.storedModifiers());
    assertNull(empty.storedPackageId());
    assertNull(empty.storedVersion());
    assertNull(empty.storedUri());
    assertNull(empty.storedId());
    assertNull(empty.storedExtensions());
    assertNull(empty.storedModifiers());
    assertSame(packageId, allocated.storedPackageId());
    assertSame(version, allocated.storedVersion());
    assertSame(uri, allocated.storedUri());
    assertSame(id, allocated.storedId());
    assertSame(extensions, allocated.storedExtensions());
    assertSame(modifiers, allocated.storedModifiers());
    assertTrue(extensions.isEmpty());
    assertTrue(modifiers.isEmpty());
    assertSame(content, empty.getUserData("keep"));
    assertSame(content, allocated.getUserData("keep"));
    assertEquals(Set.of("keep"), empty.getUserDataNames());
    assertEquals(Set.of("keep"), allocated.getUserDataNames());
    assertEquals(Arrays.asList("6.0.0", null, "current"), versions);
  }

  @Test
  void populatedStructureRetainsIdentityAndContent() {
    GuideProbe ig = guide();
    IdType guideId = ig.storedPackageId();
    DependencyProbe d = alias("example.dep", "1.2.3", "alias", false);
    IdType packageId = d.storedPackageId();
    StringType version = d.storedVersion();
    StringType id = d.storedId();
    CanonicalType uri = new CanonicalType("http://example.org/dep");
    d.setUriElement(uri);
    StringType ordinaryValue = new StringType("ordinary");
    BooleanType modifierValue = new BooleanType(false);
    Extension ordinary = extension("http://example.org/ordinary", ordinaryValue);
    Extension modifier = extension("http://example.org/modifier", modifierValue);
    d.addExtension(ordinary);
    d.addModifierExtension(modifier);
    List<Extension> ordinaryExtensions = d.storedExtensions();
    List<Extension> modifierExtensions = d.storedModifiers();
    Extension idExtension = extension("http://example.org/id", new StringType("id-content"));
    packageId.addExtension(idExtension);
    List<Extension> idExtensions = packageId.getExtensionsForRead();
    Extension guideExtension = extension("http://example.org/guide", new BooleanType(true));
    ig.addExtension(guideExtension);
    List<Extension> guideExtensions = ig.storedExtensions();
    Object content = new Object();
    ig.setUserData("keep", content);
    guideId.setUserData("keep", content);
    d.setUserData("keep", content);
    packageId.setUserData("keep", content);
    version.setUserData("keep", content);
    uri.setUserData("keep", content);
    ordinary.setUserData("keep", content);
    ig.addDependsOn(d);
    List<ImplementationGuideDependsOnComponent> declarations = ig.storedDependsOn();
    List<String> versions = new ArrayList<>(List.of("6.0.0", "5.0.0"));

    Result result = PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE);

    assertEntries(result, entry("hl7.fhir.r6.core", "6.0.0"), entry("hl7.fhir.r5.core", "5.0.0"),
        entry("alias@npm:example.dep", "1.2.3"));
    assertTrue(result.getWarnings().isEmpty());
    assertSame(guideId, ig.storedPackageId());
    assertSame(declarations, ig.storedDependsOn());
    assertEquals(1, declarations.size());
    assertSame(d, declarations.get(0));
    assertSame(packageId, d.storedPackageId());
    assertSame(version, d.storedVersion());
    assertSame(uri, d.storedUri());
    assertSame(id, d.storedId());
    assertSame(ordinaryExtensions, d.storedExtensions());
    assertSame(modifierExtensions, d.storedModifiers());
    assertEquals(1, ordinaryExtensions.size());
    assertEquals(1, modifierExtensions.size());
    assertSame(ordinary, ordinaryExtensions.get(0));
    assertSame(modifier, modifierExtensions.get(0));
    assertEquals("http://example.org/ordinary", ordinary.getUrl());
    assertEquals("http://example.org/modifier", modifier.getUrl());
    assertSame(ordinaryValue, ordinary.getValue());
    assertSame(modifierValue, modifier.getValue());
    assertEquals("ordinary", ordinaryValue.getValue());
    assertEquals(Boolean.FALSE, modifierValue.getValue());
    assertSame(idExtensions, packageId.getExtensionsForRead());
    assertEquals(1, idExtensions.size());
    assertSame(idExtension, idExtensions.get(0));
    assertEquals("http://example.org/id", idExtension.getUrl());
    assertEquals("id-content", ((StringType) idExtension.getValue()).getValue());
    assertSame(guideExtensions, ig.storedExtensions());
    assertEquals(1, guideExtensions.size());
    assertSame(guideExtension, guideExtensions.get(0));
    assertNull(ig.storedModifiers());
    assertEquals("example.guide", guideId.getValue());
    assertEquals("example.dep", packageId.getValue());
    assertEquals("1.2.3", version.getValue());
    assertEquals("http://example.org/dep", uri.getValue());
    assertEquals("alias", id.getValue());
    assertSame(content, ig.getUserData("keep"));
    assertSame(content, guideId.getUserData("keep"));
    assertSame(content, d.getUserData("keep"));
    assertSame(content, packageId.getUserData("keep"));
    assertSame(content, version.getUserData("keep"));
    assertSame(content, uri.getUserData("keep"));
    assertSame(content, ordinary.getUserData("keep"));
    assertEquals(Set.of("keep"), ig.getUserDataNames());
    assertEquals(Set.of("keep"), guideId.getUserDataNames());
    assertEquals(Set.of("keep"), d.getUserDataNames());
    assertEquals(Set.of("keep", UserDataNames.IG_DEP_ALIASED), packageId.getUserDataNames());
    assertSame(Boolean.FALSE, packageId.getUserData(UserDataNames.IG_DEP_ALIASED));
    assertEquals(Set.of("keep"), version.getUserDataNames());
    assertEquals(Set.of("keep"), uri.getUserDataNames());
    assertEquals(Set.of("keep"), ordinary.getUserDataNames());
    assertEquals(List.of("6.0.0", "5.0.0"), versions);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void coldIdsRetainOrdinaryReadSemantics(boolean versioned) {
    GuideProbe ig = new GuideProbe();
    IdType guideId = new IdType((String) null, "example.dep");
    IdType dependencyId = new IdType((String) null, "example.dep");
    DependencyProbe d = new DependencyProbe();
    ig.setPackageIdElement(guideId);
    d.setPackageIdElement(dependencyId);
    if (versioned) {
      d.setVersion("2.0.0");
    }
    ig.addDependsOn(d);
    Object content = new Object();
    guideId.setUserData("keep", content);
    dependencyId.setUserData("keep", content);
    List<String> versions = new ArrayList<>(List.of("6.0.0"));

    // No scalar/presence baseline, copy or serialization before this first call.
    Result first = PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE);

    assertEntries(first, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep", versioned ? "2.0.0" : null));
    List<String> expectedWarnings = versioned ? List.of() : List.of(
        "Implementation guide example.dep dependsOn[0] packageId=example.dep"
            + " is missing a version; specify dependsOn.version.");
    assertEquals(expectedWarnings, first.getWarnings());
    assertSame(guideId, ig.storedPackageId());
    assertSame(dependencyId, d.storedPackageId());
    assertEquals("example.dep", ig.getPackageId());
    assertEquals("example.dep", d.getPackageId());
    assertTrue(d.hasPackageId());
    assertSame(content, guideId.getUserData("keep"));
    assertSame(content, dependencyId.getUserData("keep"));
    assertEquals(Set.of("keep"), guideId.getUserDataNames());
    assertEquals(Set.of("keep"), dependencyId.getUserDataNames());
    assertEquals(List.of("6.0.0"), versions);
    assertNull(ig.storedExtensions());
    assertNull(d.storedExtensions());
    assertNull(d.storedModifiers());
    assertNull(d.storedUri());
    assertNull(d.storedId());

    Result repeated = PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE);
    assertEntries(repeated, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep", versioned ? "2.0.0" : null));
    assertEquals(expectedWarnings, repeated.getWarnings());
    assertEquals(JsonParser.compose(replay(first)), JsonParser.compose(replay(repeated)));
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void metadataIdsRetainPresenceAndContent(boolean throughElementId) {
    GuideProbe ig = new GuideProbe();
    IdType guideId = new IdType((String) null, "example.guide");
    ig.setPackageIdElement(guideId);
    DependencyProbe d = new DependencyProbe();
    IdType dependencyId = new IdType((String) null, "example.dep");
    d.setPackageIdElement(dependencyId);
    StringType version = new StringType();
    StringType metadataOwner = throughElementId ? new StringType() : version;
    if (throughElementId) {
      version.setIdElement(metadataOwner);
    }
    IdType versionMetadataId = new IdType((String) null, "example.version.metadata");
    Extension versionExtension = new Extension().setValue(versionMetadataId);
    metadataOwner.addExtension(versionExtension);
    List<Extension> versionExtensions = metadataOwner.getExtensionsForRead();
    d.setVersionElement(version);
    ig.addDependsOn(d);

    DependencyProbe uriOnly = new DependencyProbe();
    CanonicalType uri = new CanonicalType();
    IdType uriMetadataId = new IdType((String) null, "example.uri.metadata");
    Extension uriExtension = new Extension().setValue(uriMetadataId);
    uri.addExtension(uriExtension);
    List<Extension> uriExtensions = uri.getExtensionsForRead();
    uriOnly.setUriElement(uri);
    ig.addDependsOn(uriOnly);

    DependencyProbe metadataPackage = new DependencyProbe();
    IdType packageId = new IdType();
    IdType packageMetadataId = new IdType((String) null, "example.package.metadata");
    Extension packageExtension = new Extension().setValue(packageMetadataId);
    packageId.addExtension(packageExtension);
    List<Extension> packageExtensions = packageId.getExtensionsForRead();
    packageId.setUserData(UserDataNames.IG_DEP_ALIASED, Boolean.FALSE);
    metadataPackage.setPackageIdElement(packageId);
    metadataPackage.setId("metadata-alias");
    ig.addDependsOn(metadataPackage);
    List<ImplementationGuideDependsOnComponent> declarations = ig.storedDependsOn();
    Object content = new Object();
    versionMetadataId.setUserData("keep", content);
    uriMetadataId.setUserData("keep", content);
    packageMetadataId.setUserData("keep", content);
    version.setUserData("keep", content);

    // Presence checks may populate the existing nested IdType caches; nothing is pre-warmed.
    Result first = PackageDependencyPlanner.plan(ig, List.of("6.0.0"), PackageType.CONFORMANCE);

    assertEntries(first, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep", null));
    assertEquals(2, first.getWarnings().size());
    assertWarning(first.getWarnings().get(0), "example.guide", 1);
    assertWarning(first.getWarnings().get(1), "example.guide", 2);
    assertTrue(d.hasVersion());
    assertNull(d.getVersion());
    assertTrue(uriOnly.hasUri());
    assertNull(uriOnly.getUri());
    assertFalse(metadataPackage.hasPackageId(), "IdType presence ignores metadata without a scalar");
    assertNull(metadataPackage.getPackageId());
    assertSame(guideId, ig.storedPackageId());
    assertSame(dependencyId, d.storedPackageId());
    assertSame(version, d.storedVersion());
    assertSame(uri, uriOnly.storedUri());
    assertSame(packageId, metadataPackage.storedPackageId());
    assertSame(declarations, ig.storedDependsOn());
    assertEquals(3, declarations.size());
    assertSame(d, declarations.get(0));
    assertSame(uriOnly, declarations.get(1));
    assertSame(metadataPackage, declarations.get(2));
    if (throughElementId) {
      assertSame(metadataOwner, version.getNamedValue("id", false)[0]);
      assertTrue(version.getExtensionsForRead().isEmpty());
    } else {
      assertEquals(0, version.getNamedValue("id", false).length);
    }
    assertSame(versionExtensions, metadataOwner.getExtensionsForRead());
    assertSame(uriExtensions, uri.getExtensionsForRead());
    assertSame(packageExtensions, packageId.getExtensionsForRead());
    assertEquals(1, versionExtensions.size());
    assertEquals(1, uriExtensions.size());
    assertEquals(1, packageExtensions.size());
    assertSame(versionExtension, versionExtensions.get(0));
    assertSame(uriExtension, uriExtensions.get(0));
    assertSame(packageExtension, packageExtensions.get(0));
    assertSame(versionMetadataId, versionExtension.getValue());
    assertSame(uriMetadataId, uriExtension.getValue());
    assertSame(packageMetadataId, packageExtension.getValue());
    assertEquals(0, versionExtension.getNamedValue("url", false).length);
    assertEquals(0, uriExtension.getNamedValue("url", false).length);
    assertEquals(0, packageExtension.getNamedValue("url", false).length);
    assertEquals("example.guide", guideId.getValue());
    assertEquals("example.dep", dependencyId.getValue());
    assertEquals("example.version.metadata", versionMetadataId.getValue());
    assertEquals("example.uri.metadata", uriMetadataId.getValue());
    assertEquals("example.package.metadata", packageMetadataId.getValue());
    assertSame(content, versionMetadataId.getUserData("keep"));
    assertSame(content, uriMetadataId.getUserData("keep"));
    assertSame(content, packageMetadataId.getUserData("keep"));
    assertSame(content, version.getUserData("keep"));
    assertEquals(Set.of("keep"), versionMetadataId.getUserDataNames());
    assertEquals(Set.of("keep"), uriMetadataId.getUserDataNames());
    assertEquals(Set.of("keep"), packageMetadataId.getUserDataNames());
    assertEquals(Set.of("keep"), version.getUserDataNames());
    assertSame(Boolean.FALSE, packageId.getUserData(UserDataNames.IG_DEP_ALIASED));
    assertEquals(Set.of(UserDataNames.IG_DEP_ALIASED), packageId.getUserDataNames());

    Result repeated = PackageDependencyPlanner.plan(ig, List.of("6.0.0"), PackageType.CONFORMANCE);
    assertEntries(repeated, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep", null));
    assertEquals(first.getWarnings(), repeated.getWarnings());
  }

  @Test
  void rawIdsAreNotReconstructedFromComponents() {
    GuideProbe ig = new GuideProbe();
    IdType guideId = new IdType((String) null, "old.guide");
    guideId.fromStringValue("/example.guide");
    ig.setPackageIdElement(guideId);
    DependencyProbe raw = new DependencyProbe();
    IdType rawId = new IdType("/example.dep");
    raw.setPackageIdElement(rawId);
    ig.addDependsOn(raw);
    DependencyProbe changed = new DependencyProbe();
    IdType changedId = new IdType("Patient", "old.dep", "old.version");
    changedId.fromStringValue("example.changed");
    changedId.setUserData(UserDataNames.IG_DEP_ALIASED, Boolean.FALSE);
    changed.setPackageIdElement(changedId);
    changed.setId("alias");
    changed.setVersion("2.3.4+local");
    ig.addDependsOn(changed);

    Result first = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);

    assertEntries(first, entry("/example.dep", null), entry("alias@npm:example.changed", "2.3.4+local"));
    assertEquals(List.of("Implementation guide /example.guide dependsOn[0] packageId=/example.dep"
        + " is missing a version; specify dependsOn.version."), first.getWarnings());
    assertSame(guideId, ig.storedPackageId());
    assertSame(rawId, raw.storedPackageId());
    assertSame(changedId, changed.storedPackageId());
    assertEquals("/example.guide", ig.getPackageId());
    assertEquals("/example.dep", raw.getPackageId());
    assertEquals("example.changed", changed.getPackageId());
    assertSame(Boolean.FALSE, changedId.getUserData(UserDataNames.IG_DEP_ALIASED));

    Result repeated = PackageDependencyPlanner.plan(ig, List.of(), PackageType.CONFORMANCE);
    assertEntries(repeated, entry("/example.dep", null), entry("alias@npm:example.changed", "2.3.4+local"));
    assertEquals(first.getWarnings(), repeated.getWarnings());
  }

  @Test
  void resultListsAreImmutableSnapshots() {
    GuideProbe ig = guide();
    DependencyProbe complete = alias("example.complete", "1.0.0", "alias", false);
    DependencyProbe incomplete = dependency("example.missing", null);
    incomplete.setUri("http://example.org/missing");
    ig.addDependsOn(complete);
    ig.addDependsOn(incomplete);
    List<String> versions = new ArrayList<>(List.of("5.0.0", "6.0.0"));

    Result result = PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE);

    assertThrows(UnsupportedOperationException.class, () -> result.getEntries().add(entry("new", "1")));
    assertThrows(UnsupportedOperationException.class, () -> result.getEntries().set(0, entry("new", "1")));
    assertThrows(UnsupportedOperationException.class, () -> result.getEntries().remove(0));
    assertThrows(UnsupportedOperationException.class, () -> result.getWarnings().add("new"));
    assertThrows(UnsupportedOperationException.class, () -> result.getWarnings().set(0, "new"));
    assertThrows(UnsupportedOperationException.class, () -> result.getWarnings().clear());
    ig.setPackageId("changed.guide");
    complete.storedPackageId().setValue("changed.dep");
    complete.storedPackageId().clearUserData();
    complete.storedVersion().setValue("9.9.9");
    complete.setId("changed-alias");
    incomplete.setUri("http://example.org/changed");
    incomplete.setVersion("7.7.7");
    ig.storedDependsOn().clear();
    versions.clear();
    versions.add("1.0.2");

    assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"), entry("hl7.fhir.r6.core", "6.0.0"),
        entry("alias@npm:example.complete", "1.0.0"), entry("example.missing", null));
    assertEquals(List.of("Implementation guide example.guide dependsOn[1] packageId=example.missing"
        + " uri=http://example.org/missing is missing a version; specify dependsOn.version."), result.getWarnings());
    assertTrue(replay(result).getJsonObject("dependencies").hasNull("example.missing"));
    assertEntries(PackageDependencyPlanner.plan(ig, versions, PackageType.CONFORMANCE),
        entry("hl7.fhir.r2.core", "1.0.2"));

    List<Entry> entries = new ArrayList<>(List.of(entry(null, null)));
    List<String> warnings = new ArrayList<>(List.of("original warning"));
    Result copied = new Result(true, entries, warnings);
    entries.clear();
    warnings.set(0, "changed warning");
    assertEntries(copied, entry(null, null));
    assertEquals(List.of("original warning"), copied.getWarnings());
  }

  @Test
  void independentInputsDoNotLeakPlannerState() throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    try {
      List<Future<Result>> futures = new ArrayList<>();
      for (int i = 0; i < 16; i++) {
        int input = i;
        futures.add(executor.submit(() -> {
          GuideProbe ig = new GuideProbe();
          ig.setPackageIdElement(new IdType((String) null, "example.guide." + input));
          DependencyProbe d = new DependencyProbe();
          d.setPackageIdElement(new IdType((String) null, "example.dep." + input));
          ig.addDependsOn(d);
          if (input % 2 == 0) {
            ig.addDependsOn(noSave(dependency("hl7.fhir.r5.core", null), true, false));
          } else {
            d.setVersion("3.4.5");
            ig.addDependsOn(dependency("hl7.fhir.r6.core", "6.0.0-ballot3"));
          }
          return PackageDependencyPlanner.plan(ig, List.of("5.0.0", "6.0.0"), PackageType.CONFORMANCE);
        }));
      }
      for (int i = 0; i < futures.size(); i++) {
        Result result = futures.get(i).get(10, TimeUnit.SECONDS);
        assertTrue(result.hasDependencies());
        if (i % 2 == 0) {
          assertEntries(result, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep." + i, null));
          assertEquals(1, result.getWarnings().size());
          assertWarning(result.getWarnings().get(0), "example.guide." + i, 0, "example.dep." + i);
        } else {
          assertEntries(result, entry("hl7.fhir.r5.core", "5.0.0"), entry("example.dep." + i, "3.4.5"),
              entry("hl7.fhir.r6.core", "6.0.0-ballot3"));
          assertTrue(result.getWarnings().isEmpty());
        }
      }
    } finally {
      executor.shutdownNow();
      assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
    }
  }

  @Test
  void completedResultsCanBeShared() throws Exception {
    GuideProbe ig = new GuideProbe();
    ig.setPackageIdElement(new IdType((String) null, "example.guide"));
    DependencyProbe d = new DependencyProbe();
    d.setPackageIdElement(new IdType((String) null, "example.dep"));
    ig.addDependsOn(d);
    Result completed = PackageDependencyPlanner.plan(ig, List.of("6.0.0"), PackageType.CONFORMANCE);

    // Readers share only the completed result, not a cold model or an archive writer.
    ExecutorService executor = Executors.newFixedThreadPool(4);
    try {
      List<Future<Result>> futures = new ArrayList<>();
      for (int i = 0; i < 12; i++) {
        futures.add(executor.submit(() -> {
          for (int read = 0; read < 100; read++) {
            assertTrue(completed.hasDependencies());
            assertEntries(completed, entry("hl7.fhir.r6.core", "6.0.0"), entry("example.dep", null));
            assertEquals(List.of("Implementation guide example.guide dependsOn[0] packageId=example.dep"
                + " is missing a version; specify dependsOn.version."), completed.getWarnings());
          }
          return completed;
        }));
      }
      for (Future<Result> future : futures) {
        assertSame(completed, future.get(10, TimeUnit.SECONDS));
      }
    } finally {
      executor.shutdownNow();
      assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
    }
  }

  private static GuideProbe guide() {
    GuideProbe ig = new GuideProbe();
    ig.setPackageId("example.guide");
    return ig;
  }

  private static DependencyProbe dependency(String packageId, String version) {
    DependencyProbe d = new DependencyProbe();
    d.setPackageId(packageId);
    d.setVersion(version);
    return d;
  }

  private static DependencyProbe alias(String packageId, String version, String id, boolean marker) {
    DependencyProbe d = dependency(packageId, version);
    d.setId(id);
    d.storedPackageId().setUserData(UserDataNames.IG_DEP_ALIASED, marker);
    return d;
  }

  private static DependencyProbe noSave(DependencyProbe d, boolean modifier, boolean value) {
    Extension extension = extension(ExtensionDefinitions.EXT_IGDEP_NO_SAVE, new BooleanType(value));
    if (modifier) {
      d.addModifierExtension(extension);
    } else {
      d.addExtension(extension);
    }
    return d;
  }

  private static Extension extension(String url, DataType value) {
    return new Extension().setUrl(url).setValue(value);
  }

  private static Entry entry(String name, String value) {
    return new Entry(name, value);
  }

  private static void assertEntries(Result result, Entry... expected) {
    assertEquals(expected.length, result.getEntries().size(), "entry count");
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i].getName(), result.getEntries().get(i).getName(), "entry " + i + " name");
      assertEquals(expected[i].getValue(), result.getEntries().get(i).getValue(), "entry " + i + " value");
    }
  }

  private static void assertWarning(String warning, String guidePackageId, int index, String... identities) {
    assertTrue(warning.contains(guidePackageId), warning);
    assertTrue(warning.contains("dependsOn[" + index + "]"), warning);
    for (String identity : identities) {
      assertTrue(warning.contains(identity), warning);
    }
    assertTrue(warning.contains("specify dependsOn.version"), warning);
    assertFalse(warning.contains("null"), warning);
    assertFalse(warning.contains("omitted"), warning);
  }

  private static JsonObject replay(Result result) {
    JsonObject json = new JsonObject();
    if (result.hasDependencies()) {
      JsonObject dependencies = new JsonObject();
      json.add("dependencies", dependencies);
      for (Entry entry : result.getEntries()) {
        if (entry.getValue() == null) {
          dependencies.addNull(entry.getName());
        } else {
          dependencies.add(entry.getName(), entry.getValue());
        }
      }
    }
    return json;
  }

  private static final class GuideProbe extends ImplementationGuide {
    List<ImplementationGuideDependsOnComponent> storedDependsOn() {
      return dependsOnList;
    }

    IdType storedPackageId() {
      return packageId;
    }

    List<Extension> storedExtensions() {
      return extensionList;
    }

    List<Extension> storedModifiers() {
      return modifierExtensionList;
    }
  }

  private static final class DependencyProbe extends ImplementationGuideDependsOnComponent {
    IdType storedPackageId() {
      return packageId;
    }

    StringType storedVersion() {
      return version;
    }

    CanonicalType storedUri() {
      return uri;
    }

    StringType storedId() {
      return id;
    }

    List<Extension> storedExtensions() {
      return extensionList;
    }

    List<Extension> storedModifiers() {
      return modifierExtensionList;
    }
  }
}
