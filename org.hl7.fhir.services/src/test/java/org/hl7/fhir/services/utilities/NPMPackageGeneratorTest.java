package org.hl7.fhir.services.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.ContactDetail;
import org.hl7.fhir.model.core.ContactPoint;
import org.hl7.fhir.model.core.ContactPoint.ContactPointSystem;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations.FHIRVersion;
import org.hl7.fhir.model.core.Enumerations.FHIRVersionEnumFactory;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.IdType;
import org.hl7.fhir.model.core.ImplementationGuide;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent;
import org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.UrlType;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock("org.hl7.fhir.services.utilities.NPMPackageGenerator.logger")
class NPMPackageGeneratorTest {

  private static final String GUIDE_ID = "example.guide";
  private static final String SUPPLIED_ID = "example.supplied";
  private static final String CANONICAL = "http://example.org/canonical";
  private static final String WEB = "https://example.org/published";
  private static final Date DATE = Date.from(Instant.parse("2020-02-03T04:05:06Z"));

  @TempDir
  Path tempDir;

  private int packageNumber;

  private enum IgConstructor {
    TYPED, SINGLE, LIST
  }

  @ParameterizedTest
  @MethodSource("igConstructorCases")
  void allIgConstructorsApplyR5AndR6DependencyPolicy(IgConstructor constructor, List<FHIRVersion> typed,
      List<String> supplied, List<String> expectedVersions, String expectedDependencies) throws IOException {
    GuideProbe ig = guide();
    for (FHIRVersion version : typed) {
      ig.addFhirVersion(version);
    }
    List<String> versions = new ArrayList<>(supplied);

    Archive archive = finish(create(constructor, ig, PackageType.CONFORMANCE, versions, null, false));

    assertDependencies(archive.packageJson, expectedDependencies);
    assertEquals(expectedVersions, archive.packageJson.getStrings("fhirVersions"));
    assertEquals(expectedVersions, archive.manifest.getStrings("fhirVersion"));
    assertEquals(supplied, versions);
  }

  private static Stream<Arguments> igConstructorCases() {
    return Stream.of(
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._5_0_0), List.of(), List.of("5.0.0"),
            "{\"hl7.fhir.r5.core\":\"5.0.0\"}"),
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._6_0_0), List.of(), List.of("6.0.0"),
            "{\"hl7.fhir.r6.core\":\"6.0.0\"}"),
        arguments(IgConstructor.SINGLE, List.of(FHIRVersion._4_0_1), List.of("5.0.0"), List.of("5.0.0"),
            "{\"hl7.fhir.r5.core\":\"5.0.0\"}"),
        arguments(IgConstructor.SINGLE, List.of(FHIRVersion._4_0_1), List.of("6.0.0"), List.of("6.0.0"),
            "{\"hl7.fhir.r6.core\":\"6.0.0\"}"),
        arguments(IgConstructor.LIST, List.of(FHIRVersion._4_0_1), List.of("5.0.0"), List.of("5.0.0"),
            "{\"hl7.fhir.r5.core\":\"5.0.0\"}"),
        arguments(IgConstructor.LIST, List.of(FHIRVersion._4_0_1), List.of("6.0.0"), List.of("6.0.0"),
            "{\"hl7.fhir.r6.core\":\"6.0.0\"}"),
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._5_0), List.of(), List.of("5.0"), "{}"),
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._6_0), List.of(), List.of("6.0"), "{}"),
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._4_3_0CIBUILD), List.of(),
            List.of("4.3.0-cibuild"), "{}"),
        arguments(IgConstructor.TYPED, List.of(FHIRVersion._5_0_0CIBUILD), List.of(),
            List.of("5.0.0-cibuild"), "{}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("5.0.*"), List.of("5.0.*"),
            "{\"hl7.fhir.r5.core\":\"5.0.*\"}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("6.0.X"), List.of("6.0.X"),
            "{\"hl7.fhir.r6.core\":\"6.0.X\"}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("1.0.2.7202"), List.of("1.0.2.7202"),
            "{\"hl7.fhir.r2.core\":\"1.0.2.7202\"}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("3.0.1.11917"), List.of("3.0.1.11917"),
            "{\"hl7.fhir.r3.core\":\"3.0.1.11917\"}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("6.0.0-CiBuild"), List.of("6.0.0-CiBuild"), "{}"),
        arguments(IgConstructor.SINGLE, List.of(), List.of("current"), List.of("current"), "{}"),
        arguments(IgConstructor.LIST, List.of(), List.of("6.0.0-ballot3", "6.0.0", "5.0.0", "4.5.0"),
            List.of("6.0.0-ballot3", "6.0.0", "5.0.0", "4.5.0"),
            "{\"hl7.fhir.r6.core\":\"6.0.0-ballot3\",\"hl7.fhir.r5.core\":\"5.0.0\"}"),
        arguments(IgConstructor.LIST, List.of(FHIRVersion._3_0_2),
            List.of("6.0.0", "4.0.1", "4.3.0", "5.0.0", "6.0.0-ballot3", "4.1.0"),
            List.of("6.0.0", "4.0.1", "4.3.0", "5.0.0", "6.0.0-ballot3", "4.1.0"),
            "{\"hl7.fhir.r6.core\":\"6.0.0\",\"hl7.fhir.r4.core\":\"4.0.1\","
                + "\"hl7.fhir.r4b.core\":\"4.3.0\",\"hl7.fhir.r5.core\":\"5.0.0\"}"));
  }

  @Test
  void typedConstructorRetainsVersionOrderAndEmptyEntries() throws IOException {
    GuideProbe ig = guide();
    ig.addFhirVersion(FHIRVersion._5_0_0BALLOT);
    Enumeration<FHIRVersion> empty = new Enumeration<>(new FHIRVersionEnumFactory(), "");
    ig.getFhirVersionList().add(empty);
    ig.addFhirVersion(FHIRVersion._5_0_0);
    ig.addFhirVersion(FHIRVersion._6_0_0);
    ig.addFhirVersion(FHIRVersion._4_3_0);
    ig.addFhirVersion(FHIRVersion._4_0_1);
    List<Enumeration<FHIRVersion>> versions = ig.storedFhirVersions();
    List<Enumeration<FHIRVersion>> elements = new ArrayList<>(versions);
    Object content = new Object();
    empty.setUserData("keep", content);

    Archive archive = finish(create(IgConstructor.TYPED, ig, PackageType.CONFORMANCE, List.of(), null, false));

    assertEquals(List.of("5.0.0-ballot", "", "5.0.0", "6.0.0", "4.3.0", "4.0.1"),
        archive.packageJson.getStrings("fhirVersions"));
    assertEquals(List.of("5.0.0-ballot", "", "5.0.0", "6.0.0", "4.3.0", "4.0.1"),
        archive.manifest.getStrings("fhirVersion"));
    assertDependencies(archive.packageJson, "{\"hl7.fhir.r5.core\":\"5.0.0-ballot\","
        + "\"hl7.fhir.r6.core\":\"6.0.0\",\"hl7.fhir.r4b.core\":\"4.3.0\",\"hl7.fhir.r4.core\":\"4.0.1\"}");
    assertSame(versions, ig.storedFhirVersions());
    assertSame(empty, versions.get(1));
    assertEquals(6, versions.size());
    for (int i = 0; i < elements.size(); i++) {
      assertSame(elements.get(i), versions.get(i));
    }
    assertTrue(empty.isEmpty());
    assertEquals("", empty.asStringValue());
    assertSame(content, empty.getUserData("keep"));
    assertEquals(Set.of("keep"), empty.getUserDataNames());
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void archivePreservesOverridesAliasesAndGuardedNulls(boolean incompleteFirst) throws IOException {
    GuideProbe ig = guide();
    ig.addDependsOn(dependency("hl7.fhir.r6.core", "6.0.0-ballot3"));
    ig.addDependsOn(alias("hl7.fhir.r5.core", "5.0.0-snapshot1", "alternate", false));
    DependencyProbe incomplete = dependency("example.paired", null);
    DependencyProbe complete = dependency("example.paired", "2.4.6");
    ig.addDependsOn(incompleteFirst ? incomplete : complete);
    ig.addDependsOn(dependency("example.middle", "4.0.0"));
    ig.addDependsOn(incompleteFirst ? complete : incomplete);
    ig.addDependsOn(dependency("example.pending", null));
    ig.addDependsOn(dependency("example.pending", null));
    ig.addDependsOn(dependency("hl7.fhir.r5.core", null));
    ig.addDependsOn(dependency("example.unmatched", null));

    Archive archive = finish(create(IgConstructor.LIST, ig, PackageType.CONFORMANCE,
        List.of("6.0.0", "5.0.0"), null, false));

    String pair = incompleteFirst
        ? "\"example.middle\":\"4.0.0\",\"example.paired\":\"2.4.6\","
        : "\"example.paired\":\"2.4.6\",\"example.middle\":\"4.0.0\",";
    assertDependencies(archive.packageJson, "{\"hl7.fhir.r5.core\":\"5.0.0\","
        + "\"hl7.fhir.r6.core\":\"6.0.0-ballot3\",\"alternate@npm:hl7.fhir.r5.core\":\"5.0.0-snapshot1\","
        + pair + "\"example.pending\":null,\"example.unmatched\":null}");
  }

  @ParameterizedTest
  @MethodSource("suppressionCases")
  void suppressedCoreAllowsIndependentOrdinaryDeclaration(boolean modifier, boolean value,
      boolean suppressedFirst, String ordinaryVersion) throws IOException {
    GuideProbe ig = guide();
    DependencyProbe suppressed = noSave(dependency("hl7.fhir.r6.core", null), modifier, value);
    DependencyProbe ordinary = dependency("hl7.fhir.r6.core", ordinaryVersion);
    ig.addDependsOn(suppressedFirst ? suppressed : ordinary);
    ig.addDependsOn(suppressedFirst ? ordinary : suppressed);
    ig.addDependsOn(noSave(alias("hl7.fhir.r5.core", null, "suppressed-alias", false), modifier, value));
    Extension suppression = (Extension) suppressed.getNamedValue(modifier ? "modifierExtension" : "extension", false)[0];
    BooleanType suppressionValue = (BooleanType) suppression.getValue();

    Archive archive = finish(create(IgConstructor.LIST, ig, PackageType.CONFORMANCE,
        List.of("6.0.0", "5.0.0"), null, false));

    assertDependencies(archive.packageJson, ordinaryVersion == null
        ? "{\"hl7.fhir.r5.core\":\"5.0.0\",\"hl7.fhir.r6.core\":null}"
        : "{\"hl7.fhir.r5.core\":\"5.0.0\",\"hl7.fhir.r6.core\":\"author-version\"}");
    assertTrue(suppressed.hasExtension(ExtensionDefinitions.EXT_IGDEP_NO_SAVE));
    assertSame(suppression, suppressed.getNamedValue(modifier ? "modifierExtension" : "extension", false)[0]);
    assertEquals(ExtensionDefinitions.EXT_IGDEP_NO_SAVE, suppression.getUrl());
    assertSame(suppressionValue, suppression.getValue());
    assertEquals(value, suppressionValue.getValue());
    if (modifier) {
      assertNull(suppressed.storedExtensions());
      assertEquals(1, suppressed.storedModifiers().size());
    } else {
      assertEquals(1, suppressed.storedExtensions().size());
      assertNull(suppressed.storedModifiers());
    }
  }

  private static Stream<Arguments> suppressionCases() {
    List<Arguments> cases = new ArrayList<>();
    for (boolean modifier : new boolean[] {false, true}) {
      for (boolean value : new boolean[] {false, true}) {
        for (boolean suppressedFirst : new boolean[] {false, true}) {
          cases.add(arguments(modifier, value, suppressedFirst, "author-version"));
          cases.add(arguments(modifier, value, suppressedFirst, null));
        }
      }
    }
    return cases.stream();
  }

  @Test
  void missingVersionWarningsAreLoggedOnce() throws IOException {
    GuideProbe ig = guide();
    ig.addDependsOn(dependency("example.complete", "9.0.0"));
    ig.addDependsOn(noSave(dependency("example.suppressed", null), true, false));
    ig.addDependsOn(dependency("hl7.fhir.r6.core", null).setUri("http://example.org/core"));
    ig.addDependsOn(dependency("example.paired", null).setUri("http://example.org/paired"));
    ig.addDependsOn(dependency("example.paired", "2.4.6"));
    ig.addDependsOn(dependency("example.pending", null).setUri("http://example.org/pending"));
    ig.addDependsOn(dependency("example.pending", null));
    ig.addDependsOn(new DependencyProbe().setUri("http://example.org/uri-only"));
    ig.addDependsOn(new DependencyProbe());

    List<String> warnings = captureWarnings(() -> {
      Archive archive = finish(create(IgConstructor.SINGLE, ig, PackageType.CONFORMANCE,
          List.of("6.0.0"), null, false));
      assertDependencies(archive.packageJson, "{\"hl7.fhir.r6.core\":\"6.0.0\","
          + "\"example.complete\":\"9.0.0\",\"example.paired\":\"2.4.6\",\"example.pending\":null}");
    });

    assertEquals(6, warnings.size());
    assertWarning(warnings.get(0), GUIDE_ID, 2, "hl7.fhir.r6.core", "http://example.org/core");
    assertWarning(warnings.get(1), GUIDE_ID, 3, "example.paired", "http://example.org/paired");
    assertWarning(warnings.get(2), GUIDE_ID, 5, "example.pending", "http://example.org/pending");
    assertWarning(warnings.get(3), GUIDE_ID, 6, "example.pending");
    assertWarning(warnings.get(4), GUIDE_ID, 7, "http://example.org/uri-only");
    assertWarning(warnings.get(5), GUIDE_ID, 8);
    assertFalse(warnings.get(4).contains("packageId="));
    assertFalse(warnings.get(5).contains("packageId="));
    assertFalse(warnings.get(5).contains("uri="));
  }

  @Test
  void coreArchiveOmitsDependenciesButLogsWarnings() throws IOException {
    GuideProbe ig = guide();
    ig.addDependsOn(dependency(null, "invalid-complete"));
    ig.addDependsOn(new DependencyProbe().setUri("http://example.org/uri-only"));
    ig.addDependsOn(new DependencyProbe());
    ig.addDependsOn(dependency("example.pending", null).setUri("http://example.org/pending"));
    ig.addDependsOn(noSave(dependency("example.suppressed", null), true, false));
    ig.addDependsOn(dependency("example.duplicate", "1.0.0"));
    ig.addDependsOn(dependency("example.duplicate", "2.0.0"));

    List<String> warnings = captureWarnings(() -> {
      Archive archive = finish(create(IgConstructor.LIST, ig, PackageType.CORE,
          List.of("6.0.0", "5.0.0"), null, false));
      assertFalse(archive.packageJson.has("dependencies"));
      assertEquals("Core", archive.packageJson.asString("type"));
      assertEquals(List.of("6.0.0", "5.0.0"), archive.manifest.getStrings("fhirVersion"));
    });

    assertEquals(3, warnings.size());
    assertWarning(warnings.get(0), GUIDE_ID, 1, "http://example.org/uri-only");
    assertWarning(warnings.get(1), GUIDE_ID, 2);
    assertWarning(warnings.get(2), GUIDE_ID, 3, "example.pending", "http://example.org/pending");
  }

  @ParameterizedTest
  @CsvSource({"false, false", "false, true", "true, false", "true, true"})
  void suppressedDeclarationsDoNotLogWarnings(boolean modifier, boolean value) throws IOException {
    GuideProbe ig = guide();
    ig.addDependsOn(noSave(dependency("hl7.fhir.r6.core", null), modifier, value));
    ig.addDependsOn(noSave(dependency("example.suppressed", null), modifier, value));
    DependencyProbe uriOnly = new DependencyProbe();
    uriOnly.setUri("http://example.org/uri-only");
    ig.addDependsOn(noSave(uriOnly, modifier, value));
    ig.addDependsOn(noSave(new DependencyProbe(), modifier, value));
    ig.addDependsOn(noSave(alias("hl7.fhir.r5.core", null, "alias", false), modifier, value));

    List<String> warnings = captureWarnings(() -> {
      Archive archive = finish(create(IgConstructor.LIST, ig, PackageType.CONFORMANCE,
          List.of("6.0.0", "5.0.0"), null, false));
      assertDependencies(archive.packageJson, "{\"hl7.fhir.r5.core\":\"5.0.0\"}");
    });

    assertTrue(warnings.isEmpty(), warnings.toString());
  }

  @ParameterizedTest
  @MethodSource("metadataCases")
  @ResourceLock(Resources.LOCALE)
  @ResourceLock("java.util.TimeZone.default")
  void nonDependencyMetadataAndManifestRemainCompatible(IgConstructor constructor, boolean notForPublication)
      throws IOException {
    withFixedFormatting(() -> {
      GuideProbe ig = populatedGuide();
      List<String> expectedVersions = constructor == IgConstructor.SINGLE
          ? List.of("5.0.0") : List.of("6.0.0", "5.0.0");
      List<String> versions = new ArrayList<>(expectedVersions);
      Map<String, String> related = new LinkedHashMap<>();
      related.put("example.peer.b", "2.0.0");
      related.put("example.peer.a", null);
      NPMPackageGenerator generator = create(constructor, ig, PackageType.CONFORMANCE,
          versions, related, notForPublication);
      Archive archive = finish(generator);
      JsonObject json = archive.packageJson;

      List<String> names = new ArrayList<>(List.of("name", "version", "tools-version", "type", "date",
          "license", "canonical"));
      if (notForPublication) {
        names.add("notForPublication");
      }
      names.addAll(List.of("url", "title", "description", "fhirVersions", "dependencies", "author",
          "maintainers", "homepage", "directories", "jurisdiction", "peerDependencies"));
      assertEquals(names, propertyNames(json));
      assertEquals(constructor == IgConstructor.LIST ? GUIDE_ID : SUPPLIED_ID, json.asString("name"));
      assertEquals("2.3.4", json.asString("version"));
      assertEquals(ToolsVersion.TOOLS_VERSION, json.asInteger("tools-version").intValue());
      assertEquals("Conformance", json.asString("type"));
      assertEquals("20200203040506", json.asString("date"));
      assertEquals("MIT", json.asString("license"));
      assertEquals(CANONICAL, json.asString("canonical"));
      assertEquals(WEB, json.asString("url"));
      assertEquals("Guide title", json.asString("title"));
      assertEquals("Guide description (built Mon, Feb 3, 2020 04:05+0000+00:00)", json.asString("description"));
      assertEquals(notForPublication, json.has("notForPublication"));
      if (notForPublication) {
        assertTrue(json.asBoolean("notForPublication"));
      }
      assertEquals(expectedVersions, json.getStrings("fhirVersions"));
      assertEquals("Publisher", json.asString("author"));
      assertJsonEquals("[{\"name\":\"Alpha\",\"email\":\"first@example.org\",\"url\":\"https://example.org/first\"},"
          + "{\"name\":\"Beta\",\"url\":\"https://example.org/beta\"}]",
          JsonParser.compose(json.getJsonArray("maintainers")));
      assertEquals("https://example.org/home", json.asString("homepage"));
      assertJsonEquals("{\"lib\":\"package\",\"example\":\"example\"}",
          JsonParser.compose(json.getJsonObject("directories")));
      assertEquals("urn:iso:std:iso:3166#US", json.asString("jurisdiction"));
      assertJsonEquals("{\"example.peer.b\":\"2.0.0\",\"example.peer.a\":null}",
          JsonParser.compose(json.getJsonObject("peerDependencies")));
      assertDependencies(json, constructor == IgConstructor.SINGLE
          ? "{\"hl7.fhir.r5.core\":\"5.0.0\",\"example.dep\":\"7.8.9\"}"
          : "{\"hl7.fhir.r6.core\":\"6.0.0\",\"hl7.fhir.r5.core\":\"5.0.0\",\"example.dep\":\"7.8.9\"}");

      assertEquals(List.of("version", "fhirVersion", "date", "name", "jurisdiction"), propertyNames(archive.manifest));
      assertEquals("2.3.4", archive.manifest.asString("version"));
      assertEquals(expectedVersions, archive.manifest.getStrings("fhirVersion"));
      assertEquals("20200203040506", archive.manifest.asString("date"));
      assertEquals(GUIDE_ID, archive.manifest.asString("name"));
      assertEquals("urn:iso:std:iso:3166#US", archive.manifest.asString("jurisdiction"));
      assertEquals(List.of("index-version", "files"), propertyNames(archive.index));
      assertTrue(archive.index.asInteger("index-version") > 0);
      assertEquals(0, archive.index.getJsonArray("files").size());
      assertTrue(generator.getCreated().contains("package/package.json"));
      assertTrue(generator.getCreated().contains("package/.index.json"));
      assertEquals("2.3.4", generator.version());
      assertJsonEquals(JsonParser.compose(generator.getPackageJ()), JsonParser.compose(json));
      assertEquals(expectedVersions, versions);
      assertEquals(List.of("example.peer.b", "example.peer.a"), new ArrayList<>(related.keySet()));
      assertEquals(Arrays.asList("2.0.0", null), new ArrayList<>(related.values()));
      assertEquals(Instant.parse("2020-02-03T04:05:06Z"), DATE.toInstant());
    });
  }

  private static Stream<Arguments> metadataCases() {
    return Stream.of(
        arguments(IgConstructor.TYPED, false), arguments(IgConstructor.TYPED, true),
        arguments(IgConstructor.SINGLE, false), arguments(IgConstructor.SINGLE, true),
        arguments(IgConstructor.LIST, false), arguments(IgConstructor.LIST, true));
  }

  @ParameterizedTest
  @EnumSource(IgConstructor.class)
  void igConstructorsDoNotCreateOrRewriteInputStructure(IgConstructor constructor) throws IOException {
    GuideProbe absent = guide();
    IdType packageId = absent.storedPackageId();
    StringType version = absent.storedVersion();
    List<String> versions = new ArrayList<>(List.of("current"));

    Archive first = finish(create(constructor, absent, PackageType.CONFORMANCE, versions, null, false));

    assertDependencies(first.packageJson, "{}");
    assertSame(packageId, absent.storedPackageId());
    assertSame(version, absent.storedVersion());
    assertNull(absent.storedFhirVersions());
    assertNull(absent.storedDependsOn());
    assertNull(absent.storedContacts());
    assertNull(absent.storedJurisdictions());
    assertNull(absent.storedManifest());
    assertNull(absent.storedExtensions());
    assertNull(absent.storedModifiers());
    for (String name : List.of("license", "title", "description", "publisher", "definition")) {
      assertEquals(0, absent.getNamedValue(name, false).length, name);
    }
    for (String name : List.of("license", "title", "description", "author", "maintainers", "homepage",
        "jurisdiction", "peerDependencies", "notForPublication")) {
      assertFalse(first.packageJson.has(name), name);
    }
    assertEquals(List.of("version", "fhirVersion", "date", "name"), propertyNames(first.manifest));
    assertEquals(constructor == IgConstructor.TYPED ? List.of() : List.of("current"),
        first.packageJson.getStrings("fhirVersions"));
    assertEquals(List.of("current"), versions);

    GuideProbe allocated = guide();
    List<Enumeration<FHIRVersion>> fhirVersions = allocated.getFhirVersionList();
    List<ImplementationGuideDependsOnComponent> declarations = allocated.getDependsOnList();
    List<ContactDetail> contacts = allocated.getContactList();
    List<CodeableConcept> jurisdictions = allocated.getJurisdictionList();
    List<Extension> extensions = allocated.getExtensionList();
    List<Extension> modifiers = allocated.getModifierExtensionList();
    ImplementationGuideManifestComponent manifest = new ImplementationGuideManifestComponent();
    allocated.setManifest(manifest);
    Map<String, String> related = new LinkedHashMap<>();

    Archive empty = finish(create(constructor, allocated, PackageType.CONFORMANCE, versions, related, false));

    assertDependencies(empty.packageJson, "{}");
    assertSame(fhirVersions, allocated.storedFhirVersions());
    assertTrue(fhirVersions.isEmpty());
    assertSame(declarations, allocated.storedDependsOn());
    assertTrue(declarations.isEmpty());
    assertSame(contacts, allocated.storedContacts());
    assertTrue(contacts.isEmpty());
    assertSame(jurisdictions, allocated.storedJurisdictions());
    assertTrue(jurisdictions.isEmpty());
    assertSame(extensions, allocated.storedExtensions());
    assertTrue(extensions.isEmpty());
    assertSame(modifiers, allocated.storedModifiers());
    assertTrue(modifiers.isEmpty());
    assertSame(manifest, allocated.storedManifest());
    assertEquals(0, manifest.getNamedValue("rendering", false).length);
    assertFalse(empty.packageJson.has("homepage"));
    assertTrue(empty.packageJson.hasObject("peerDependencies"));
    assertTrue(empty.packageJson.getJsonObject("peerDependencies").getNames().isEmpty());
    assertTrue(related.isEmpty());

    ContactProbe noTelecom = new ContactProbe();
    ContactProbe emptyTelecom = new ContactProbe();
    emptyTelecom.setName("No details");
    List<ContactPoint> telecom = emptyTelecom.getTelecomList();
    allocated.addContact(noTelecom);
    allocated.addContact(emptyTelecom);
    DependencyProbe unidentified = new DependencyProbe();
    allocated.addDependsOn(unidentified);
    UrlType rendering = new UrlType();
    manifest.setRenderingElement(rendering);
    Object content = new Object();
    allocated.setUserData("keep", content);
    noTelecom.setUserData("keep", content);
    unidentified.setUserData("keep", content);
    manifest.setUserData("keep", content);
    rendering.setUserData("keep", content);

    List<String> warnings = captureWarnings(() -> {
      Archive populated = finish(create(constructor, allocated, PackageType.CONFORMANCE, versions, related, false));
      assertDependencies(populated.packageJson, "{}");
      assertFalse(populated.packageJson.has("maintainers"));
      assertFalse(populated.packageJson.has("homepage"));
    });

    assertEquals(1, warnings.size());
    assertWarning(warnings.get(0), GUIDE_ID, 0);
    assertSame(contacts, allocated.storedContacts());
    assertEquals(2, contacts.size());
    assertSame(noTelecom, contacts.get(0));
    assertSame(emptyTelecom, contacts.get(1));
    assertNull(noTelecom.storedTelecom());
    assertNull(noTelecom.storedName());
    assertNull(noTelecom.storedExtensions());
    assertSame(telecom, emptyTelecom.storedTelecom());
    assertTrue(telecom.isEmpty());
    assertEquals("No details", emptyTelecom.getName());
    assertSame(manifest, allocated.storedManifest());
    assertSame(rendering, manifest.getNamedValue("rendering", false)[0]);
    assertFalse(manifest.hasRendering());
    assertSame(declarations, allocated.storedDependsOn());
    assertEquals(1, declarations.size());
    assertSame(unidentified, declarations.get(0));
    assertNull(unidentified.storedPackageId());
    assertNull(unidentified.storedVersion());
    assertNull(unidentified.storedUri());
    assertNull(unidentified.storedId());
    assertNull(unidentified.storedExtensions());
    assertNull(unidentified.storedModifiers());
    assertSame(content, allocated.getUserData("keep"));
    assertSame(content, noTelecom.getUserData("keep"));
    assertSame(content, unidentified.getUserData("keep"));
    assertSame(content, manifest.getUserData("keep"));
    assertSame(content, rendering.getUserData("keep"));
    assertEquals(Set.of("keep"), allocated.getUserDataNames());
    assertEquals(Set.of("keep"), noTelecom.getUserDataNames());
    assertEquals(Set.of("keep"), unidentified.getUserDataNames());
    assertEquals(Set.of("keep"), manifest.getUserDataNames());
    assertEquals(Set.of("keep"), rendering.getUserDataNames());
    assertEquals(List.of("current"), versions);
    assertTrue(related.isEmpty());
  }

  @ParameterizedTest
  @EnumSource(IgConstructor.class)
  void firstMatchingNullContactValuesDoNotFallThrough(IgConstructor constructor) throws IOException {
    GuideProbe ig = guide();
    ig.addFhirVersion(FHIRVersion._6_0_0);
    ContactProbe noEmail = new ContactProbe();
    noEmail.setName("No email");
    ContactPoint firstEmail = contactPoint(ContactPointSystem.EMAIL, null);
    noEmail.addTelecom(firstEmail);
    noEmail.addTelecom(contactPoint(ContactPointSystem.EMAIL, "ignored@example.org"));
    noEmail.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/kept"));
    ContactProbe noUrl = new ContactProbe();
    noUrl.setName("No URL");
    ContactPoint firstUrl = contactPoint(ContactPointSystem.URL, null);
    noUrl.addTelecom(firstUrl);
    noUrl.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/ignored"));
    noUrl.addTelecom(contactPoint(ContactPointSystem.EMAIL, "kept@example.org"));
    ContactProbe neither = new ContactProbe();
    neither.setName("Neither");
    neither.addTelecom(contactPoint(ContactPointSystem.EMAIL, null));
    neither.addTelecom(contactPoint(ContactPointSystem.EMAIL, "ignored@example.org"));
    neither.addTelecom(contactPoint(ContactPointSystem.URL, null));
    neither.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/ignored"));
    ContactProbe unnamed = new ContactProbe();
    unnamed.addTelecom(contactPoint(ContactPointSystem.EMAIL, "unnamed@example.org"));
    ig.addContact(noEmail);
    ig.addContact(neither);
    ig.addContact(unnamed);
    ig.addContact(noUrl);
    List<ContactDetail> contacts = ig.storedContacts();
    List<ContactPoint> emails = noEmail.storedTelecom();
    List<ContactPoint> urls = noUrl.storedTelecom();

    Archive archive = finish(create(constructor, ig, PackageType.CONFORMANCE, List.of("6.0.0"), null, false));

    assertJsonEquals("[{\"name\":\"No email\",\"url\":\"https://example.org/kept\"},"
        + "{\"name\":\"No URL\",\"email\":\"kept@example.org\"}]",
        JsonParser.compose(archive.packageJson.getJsonArray("maintainers")));
    assertSame(contacts, ig.storedContacts());
    assertEquals(List.of(noEmail, neither, unnamed, noUrl), contacts);
    assertSame(emails, noEmail.storedTelecom());
    assertSame(urls, noUrl.storedTelecom());
    assertSame(firstEmail, emails.get(0));
    assertSame(firstUrl, urls.get(0));
    assertEquals(3, emails.size());
    assertEquals(3, urls.size());
    assertEquals(0, firstEmail.getNamedValue("value", false).length);
    assertEquals(0, firstUrl.getNamedValue("value", false).length);
    assertNull(unnamed.storedName());
  }

  @ParameterizedTest
  @MethodSource("jurisdictionCases")
  void jurisdictionRetainsNativePresenceAndExactCardinalities(String scenario, boolean nativePresence,
      String expected) throws IOException {
    GuideProbe ig = guide();
    ConceptProbe concept = new ConceptProbe();
    Coding coding = new Coding();
    Object content = new Object();
    concept.setUserData("keep", content);
    coding.setUserData("keep", content);
    IdType metadataId = new IdType((String) null, "example.jurisdiction.metadata");
    Extension metadata = new Extension().setValue(metadataId);
    metadataId.setUserData("keep", content);
    switch (scenario) {
    case "absent":
      break;
    case "allocated-list":
      ig.getJurisdictionList();
      break;
    case "empty-concept":
      ig.addJurisdiction(concept);
      break;
    case "text-only":
      concept.setText("Somewhere");
      ig.addJurisdiction(concept);
      break;
    case "text-empty-codings":
      concept.setText("Somewhere");
      concept.getCodingList();
      ig.addJurisdiction(concept);
      break;
    case "empty-coding":
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "text-empty-coding":
      concept.setText("Somewhere");
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "concept-metadata":
      concept.addExtension(metadata);
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "coding-metadata":
      coding.addExtension(metadata);
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "system-only":
      coding.setSystem("urn:iso:std:iso:3166");
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "code-only":
      coding.setCode("US");
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      break;
    case "single":
    case "two-concepts":
    case "two-codings":
      coding.setSystem("urn:iso:std:iso:3166").setCode("US");
      concept.addCoding(coding);
      ig.addJurisdiction(concept);
      if ("two-concepts".equals(scenario)) {
        ig.addJurisdiction(new ConceptProbe());
      }
      if ("two-codings".equals(scenario)) {
        concept.addCoding(new Coding());
      }
      break;
    default:
      throw new IllegalArgumentException(scenario);
    }
    List<CodeableConcept> jurisdictions = ig.storedJurisdictions();
    List<Coding> codings = concept.storedCodings();
    StringType text = concept.storedText();
    List<Extension> conceptExtensions = concept.storedExtensions();
    List<Extension> codingExtensions = coding.getExtensionsForRead();

    // In the metadata cases, the constructor is the first presence/scalar traversal of the cold ID.
    Archive archive = finish(create(IgConstructor.LIST, ig, PackageType.CONFORMANCE, List.of("6.0.0"), null, false));

    assertEquals(nativePresence, ig.hasJurisdiction());
    assertEquals(expected != null, archive.packageJson.has("jurisdiction"));
    assertEquals(expected != null, archive.manifest.has("jurisdiction"));
    assertEquals(expected, archive.packageJson.asString("jurisdiction"));
    assertEquals(expected, archive.manifest.asString("jurisdiction"));
    assertSame(jurisdictions, ig.storedJurisdictions());
    assertSame(codings, concept.storedCodings());
    assertSame(text, concept.storedText());
    assertSame(conceptExtensions, concept.storedExtensions());
    assertSame(codingExtensions, coding.getExtensionsForRead());
    if (jurisdictions != null && !jurisdictions.isEmpty()) {
      assertSame(concept, jurisdictions.get(0));
      assertEquals("two-concepts".equals(scenario) ? 2 : 1, jurisdictions.size());
    }
    if (codings != null && !codings.isEmpty()) {
      assertSame(coding, codings.get(0));
      assertEquals("two-codings".equals(scenario) ? 2 : 1, codings.size());
    }
    if ("concept-metadata".equals(scenario) || "coding-metadata".equals(scenario)) {
      assertSame(metadata, "concept-metadata".equals(scenario) ? conceptExtensions.get(0) : codingExtensions.get(0));
      assertSame(metadataId, metadata.getValue());
      assertEquals("example.jurisdiction.metadata", metadataId.getValue());
      assertSame(content, metadataId.getUserData("keep"));
      assertEquals(Set.of("keep"), metadataId.getUserDataNames());
      assertEquals(0, metadata.getNamedValue("url", false).length);
      assertEquals(0, coding.getNamedValue("system", false).length);
      assertEquals(0, coding.getNamedValue("code", false).length);
    }
    assertSame(content, concept.getUserData("keep"));
    assertSame(content, coding.getUserData("keep"));
    assertEquals(Set.of("keep"), concept.getUserDataNames());
    assertEquals(Set.of("keep"), coding.getUserDataNames());
  }

  private static Stream<Arguments> jurisdictionCases() {
    return Stream.of(
        arguments("absent", false, null),
        arguments("allocated-list", false, null),
        arguments("empty-concept", false, null),
        arguments("text-only", true, null),
        arguments("text-empty-codings", true, null),
        arguments("empty-coding", false, null),
        arguments("text-empty-coding", true, "null#null"),
        arguments("concept-metadata", true, "null#null"),
        arguments("coding-metadata", true, "null#null"),
        arguments("system-only", true, "urn:iso:std:iso:3166#null"),
        arguments("code-only", true, "null#US"),
        arguments("single", true, "urn:iso:std:iso:3166#US"),
        arguments("two-concepts", true, null),
        arguments("two-codings", true, null));
  }

  @ParameterizedTest
  @MethodSource("coldIdCases")
  void coldIdsRetainOrdinaryValuesAcrossConstructors(IgConstructor constructor, boolean versioned) throws IOException {
    GuideProbe ig = guide();
    IdType guideId = new IdType((String) null, "example.dep");
    IdType dependencyId = new IdType((String) null, "example.dep");
    ig.setPackageIdElement(guideId);
    ig.addFhirVersion(FHIRVersion._6_0_0);
    DependencyProbe d = new DependencyProbe();
    d.setPackageIdElement(dependencyId);
    if (versioned) {
      d.setVersion("2.0.0");
    }
    ig.addDependsOn(d);
    Object content = new Object();
    guideId.setUserData("keep", content);
    dependencyId.setUserData("keep", content);
    Extension guideExtension = extension("http://example.org/guide-id", new StringType("guide metadata"));
    Extension dependencyExtension = extension("http://example.org/dep-id", new StringType("dependency metadata"));
    guideId.addExtension(guideExtension);
    dependencyId.addExtension(dependencyExtension);
    List<Extension> guideExtensions = guideId.getExtensionsForRead();
    List<Extension> dependencyExtensions = dependencyId.getExtensionsForRead();
    List<ImplementationGuideDependsOnComponent> declarations = ig.storedDependsOn();
    List<String> versions = new ArrayList<>(List.of("6.0.0"));

    List<String> warnings = captureWarnings(() -> {
      // No scalar/presence baseline, model copy or serialization before this first constructor call.
      Archive first = finish(create(constructor, ig, PackageType.CONFORMANCE, versions, null, false));

      assertDependencies(first.packageJson, versioned
          ? "{\"hl7.fhir.r6.core\":\"6.0.0\",\"example.dep\":\"2.0.0\"}"
          : "{\"hl7.fhir.r6.core\":\"6.0.0\",\"example.dep\":null}");
      assertEquals(constructor == IgConstructor.LIST ? "example.dep" : SUPPLIED_ID, first.packageJson.asString("name"));
      assertEquals("example.dep", first.manifest.asString("name"));
      assertSame(guideId, ig.storedPackageId());
      assertSame(dependencyId, d.storedPackageId());
      assertEquals("example.dep", ig.getPackageId());
      assertEquals("example.dep", d.getPackageId());
      assertTrue(d.hasPackageId());
      assertEquals(versioned, d.hasVersion());
      assertSame(declarations, ig.storedDependsOn());
      assertEquals(1, declarations.size());
      assertSame(d, declarations.get(0));
      assertSame(guideExtensions, guideId.getExtensionsForRead());
      assertSame(dependencyExtensions, dependencyId.getExtensionsForRead());
      assertEquals(1, guideExtensions.size());
      assertEquals(1, dependencyExtensions.size());
      assertSame(guideExtension, guideExtensions.get(0));
      assertSame(dependencyExtension, dependencyExtensions.get(0));
      assertEquals("http://example.org/guide-id", guideExtension.getUrl());
      assertEquals("http://example.org/dep-id", dependencyExtension.getUrl());
      assertEquals("guide metadata", ((StringType) guideExtension.getValue()).getValue());
      assertEquals("dependency metadata", ((StringType) dependencyExtension.getValue()).getValue());
      assertSame(content, guideId.getUserData("keep"));
      assertSame(content, dependencyId.getUserData("keep"));
      assertEquals(Set.of("keep"), guideId.getUserDataNames());
      assertEquals(Set.of("keep"), dependencyId.getUserDataNames());
      assertNull(ig.storedContacts());
      assertNull(ig.storedManifest());
      assertNull(d.storedUri());
      assertNull(d.storedId());
      assertNull(d.storedExtensions());
      assertNull(d.storedModifiers());
      assertEquals(List.of("6.0.0"), versions);

      Archive repeated = finish(create(constructor, ig, PackageType.CONFORMANCE, versions, null, false));
      assertJsonEquals(JsonParser.compose(first.packageJson), JsonParser.compose(repeated.packageJson));
      assertJsonEquals(JsonParser.compose(first.manifest), JsonParser.compose(repeated.manifest));
    });

    if (versioned) {
      assertTrue(warnings.isEmpty(), warnings.toString());
    } else {
      String warning = "Implementation guide example.dep dependsOn[0] packageId=example.dep"
          + " is missing a version; specify dependsOn.version.";
      assertEquals(List.of(warning, warning), warnings);
    }
  }

  private static Stream<Arguments> coldIdCases() {
    return Stream.of(
        arguments(IgConstructor.TYPED, false), arguments(IgConstructor.TYPED, true),
        arguments(IgConstructor.SINGLE, false), arguments(IgConstructor.SINGLE, true),
        arguments(IgConstructor.LIST, false), arguments(IgConstructor.LIST, true));
  }

  @ParameterizedTest
  @EnumSource(IgConstructor.class)
  void rawIdsAreNotReconstructedAcrossConstructors(IgConstructor constructor) throws IOException {
    GuideProbe ig = guide();
    IdType guideId = new IdType((String) null, "old.guide");
    guideId.fromStringValue("/example.guide");
    ig.setPackageIdElement(guideId);
    ig.addFhirVersion(FHIRVersion._6_0_0);
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

    List<String> warnings = captureWarnings(() -> {
      Archive first = finish(create(constructor, ig, PackageType.CONFORMANCE, List.of("6.0.0"), null, false));

      assertDependencies(first.packageJson, "{\"hl7.fhir.r6.core\":\"6.0.0\","
          + "\"/example.dep\":null,\"alias@npm:example.changed\":\"2.3.4+local\"}");
      assertEquals(constructor == IgConstructor.LIST ? "/example.guide" : SUPPLIED_ID,
          first.packageJson.asString("name"));
      assertEquals("/example.guide", first.manifest.asString("name"));
      assertSame(guideId, ig.storedPackageId());
      assertSame(rawId, raw.storedPackageId());
      assertSame(changedId, changed.storedPackageId());
      assertEquals("/example.guide", ig.getPackageId());
      assertEquals("/example.dep", raw.getPackageId());
      assertEquals("example.changed", changed.getPackageId());
      assertSame(Boolean.FALSE, changedId.getUserData(UserDataNames.IG_DEP_ALIASED));
      assertEquals(Set.of(UserDataNames.IG_DEP_ALIASED), changedId.getUserDataNames());

      Archive repeated = finish(create(constructor, ig, PackageType.CONFORMANCE, List.of("6.0.0"), null, false));
      assertJsonEquals(JsonParser.compose(first.packageJson), JsonParser.compose(repeated.packageJson));
      assertJsonEquals(JsonParser.compose(first.manifest), JsonParser.compose(repeated.manifest));
    });

    String warning = "Implementation guide /example.guide dependsOn[0] packageId=/example.dep"
        + " is missing a version; specify dependsOn.version.";
    assertEquals(List.of(warning, warning), warnings);
  }

  @ParameterizedTest
  @EnumSource(IgConstructor.class)
  void coldMetadataIdsRetainNativePresenceAndInputContent(IgConstructor constructor) throws IOException {
    GuideProbe ig = guide();
    ig.addFhirVersion(FHIRVersion._6_0_0);
    IdType guideId = new IdType((String) null, GUIDE_ID);
    ig.setPackageIdElement(guideId);
    StringType title = new StringType();
    IdType titleId = new IdType((String) null, "example.title.metadata");
    Extension titleExtension = new Extension().setValue(titleId);
    title.addExtension(titleExtension);
    ig.setTitleElement(title);
    List<Extension> titleExtensions = title.getExtensionsForRead();
    ContactProbe contact = new ContactProbe();
    StringType name = new StringType();
    IdType contactId = new IdType((String) null, "example.contact.metadata");
    Extension contactExtension = new Extension().setValue(contactId);
    name.addExtension(contactExtension);
    contact.setNameElement(name);
    contact.addTelecom(contactPoint(ContactPointSystem.EMAIL, "metadata@example.org"));
    ig.addContact(contact);
    List<ContactDetail> contacts = ig.storedContacts();
    List<ContactPoint> telecom = contact.storedTelecom();
    List<Extension> nameExtensions = name.getExtensionsForRead();

    ImplementationGuideManifestComponent manifest = new ImplementationGuideManifestComponent();
    UrlType rendering = new UrlType();
    IdType renderingId = new IdType((String) null, "example.rendering.metadata");
    Extension renderingExtension = new Extension().setValue(renderingId);
    rendering.addExtension(renderingExtension);
    manifest.setRenderingElement(rendering);
    ig.setManifest(manifest);
    List<Extension> renderingExtensions = rendering.getExtensionsForRead();

    ConceptProbe concept = new ConceptProbe();
    Coding coding = new Coding();
    IdType jurisdictionId = new IdType((String) null, "example.coding.metadata");
    Extension jurisdictionExtension = new Extension().setValue(jurisdictionId);
    coding.addExtension(jurisdictionExtension);
    concept.addCoding(coding);
    ig.addJurisdiction(concept);
    List<CodeableConcept> jurisdictions = ig.storedJurisdictions();
    List<Coding> codings = concept.storedCodings();
    List<Extension> codingExtensions = coding.getExtensionsForRead();

    DependencyProbe d = new DependencyProbe();
    IdType dependencyId = new IdType((String) null, "example.dep");
    d.setPackageIdElement(dependencyId);
    StringType version = new StringType();
    IdType versionId = new IdType((String) null, "example.version.metadata");
    Extension versionExtension = new Extension().setValue(versionId);
    version.addExtension(versionExtension);
    d.setVersionElement(version);
    ig.addDependsOn(d);
    List<Extension> versionExtensions = version.getExtensionsForRead();
    DependencyProbe uriOnly = new DependencyProbe();
    CanonicalType uri = new CanonicalType();
    IdType uriId = new IdType((String) null, "example.uri.metadata");
    Extension uriExtension = new Extension().setValue(uriId);
    uri.addExtension(uriExtension);
    uriOnly.setUriElement(uri);
    ig.addDependsOn(uriOnly);
    List<Extension> uriExtensions = uri.getExtensionsForRead();
    DependencyProbe metadataPackage = new DependencyProbe();
    IdType packageId = new IdType();
    IdType packageMetadataId = new IdType((String) null, "example.package.metadata");
    Extension packageExtension = new Extension().setValue(packageMetadataId);
    packageId.addExtension(packageExtension);
    packageId.setUserData(UserDataNames.IG_DEP_ALIASED, Boolean.FALSE);
    metadataPackage.setPackageIdElement(packageId);
    metadataPackage.setId("metadata-alias");
    ig.addDependsOn(metadataPackage);
    List<Extension> packageExtensions = packageId.getExtensionsForRead();
    List<ImplementationGuideDependsOnComponent> declarations = ig.storedDependsOn();
    Object content = new Object();
    for (IdType id : List.of(guideId, dependencyId, titleId, contactId, renderingId, jurisdictionId,
        versionId, uriId, packageMetadataId)) {
      id.setUserData("keep", content);
    }
    name.setUserData("keep", content);
    rendering.setUserData("keep", content);
    version.setUserData("keep", content);

    List<String> warnings = captureWarnings(() -> {
      // These IDs have not been read, copied or serialized. Native presence may populate their existing caches.
      Archive archive = finish(create(constructor, ig, PackageType.CONFORMANCE, List.of("6.0.0"), null, false));

      assertDependencies(archive.packageJson, "{\"hl7.fhir.r6.core\":\"6.0.0\",\"example.dep\":null}");
      assertTrue(archive.packageJson.hasNull("title"));
      assertTrue(archive.packageJson.hasNull("homepage"));
      assertJsonEquals("[{\"name\":null,\"email\":\"metadata@example.org\"}]",
          JsonParser.compose(archive.packageJson.getJsonArray("maintainers")));
      assertEquals("null#null", archive.packageJson.asString("jurisdiction"));
      assertEquals("null#null", archive.manifest.asString("jurisdiction"));
      assertTrue(ig.hasTitle());
      assertNull(ig.getTitle());
      assertTrue(contact.hasName());
      assertNull(contact.getName());
      assertTrue(manifest.hasRendering());
      assertNull(manifest.getRendering());
      assertTrue(ig.hasJurisdiction());
      assertTrue(d.hasVersion());
      assertNull(d.getVersion());
      assertTrue(uriOnly.hasUri());
      assertNull(uriOnly.getUri());
      assertFalse(metadataPackage.hasPackageId(), "IdType presence is scalar-based, unlike StringType presence");
      assertNull(metadataPackage.getPackageId());
    });

    assertEquals(2, warnings.size());
    assertWarning(warnings.get(0), GUIDE_ID, 1);
    assertWarning(warnings.get(1), GUIDE_ID, 2);
    assertFalse(warnings.get(0).contains("uri="));
    assertFalse(warnings.get(1).contains("packageId="));
    assertSame(guideId, ig.storedPackageId());
    assertSame(title, ig.getNamedValue("title", false)[0]);
    assertSame(contacts, ig.storedContacts());
    assertSame(contact, contacts.get(0));
    assertEquals(1, contacts.size());
    assertSame(name, contact.storedName());
    assertSame(telecom, contact.storedTelecom());
    assertEquals(1, telecom.size());
    assertSame(manifest, ig.storedManifest());
    assertSame(rendering, manifest.getNamedValue("rendering", false)[0]);
    assertSame(jurisdictions, ig.storedJurisdictions());
    assertSame(concept, jurisdictions.get(0));
    assertEquals(1, jurisdictions.size());
    assertSame(codings, concept.storedCodings());
    assertSame(coding, codings.get(0));
    assertEquals(1, codings.size());
    assertNull(concept.storedText());
    assertEquals(0, coding.getNamedValue("system", false).length);
    assertEquals(0, coding.getNamedValue("code", false).length);
    assertSame(declarations, ig.storedDependsOn());
    assertEquals(List.of(d, uriOnly, metadataPackage), declarations);
    assertSame(dependencyId, d.storedPackageId());
    assertSame(version, d.storedVersion());
    assertSame(uri, uriOnly.storedUri());
    assertSame(packageId, metadataPackage.storedPackageId());
    assertSame(titleExtensions, title.getExtensionsForRead());
    assertSame(nameExtensions, name.getExtensionsForRead());
    assertSame(renderingExtensions, rendering.getExtensionsForRead());
    assertSame(codingExtensions, coding.getExtensionsForRead());
    assertSame(versionExtensions, version.getExtensionsForRead());
    assertSame(uriExtensions, uri.getExtensionsForRead());
    assertSame(packageExtensions, packageId.getExtensionsForRead());
    assertEquals(List.of(titleExtension), titleExtensions);
    assertEquals(List.of(contactExtension), nameExtensions);
    assertEquals(List.of(renderingExtension), renderingExtensions);
    assertEquals(List.of(jurisdictionExtension), codingExtensions);
    assertEquals(List.of(versionExtension), versionExtensions);
    assertEquals(List.of(uriExtension), uriExtensions);
    assertEquals(List.of(packageExtension), packageExtensions);
    assertSame(titleId, titleExtension.getValue());
    assertSame(contactId, contactExtension.getValue());
    assertSame(renderingId, renderingExtension.getValue());
    assertSame(jurisdictionId, jurisdictionExtension.getValue());
    assertSame(versionId, versionExtension.getValue());
    assertSame(uriId, uriExtension.getValue());
    assertSame(packageMetadataId, packageExtension.getValue());
    assertEquals(GUIDE_ID, guideId.getValue());
    assertEquals("example.dep", dependencyId.getValue());
    assertEquals("example.title.metadata", titleId.getValue());
    assertEquals("example.contact.metadata", contactId.getValue());
    assertEquals("example.rendering.metadata", renderingId.getValue());
    assertEquals("example.coding.metadata", jurisdictionId.getValue());
    assertEquals("example.version.metadata", versionId.getValue());
    assertEquals("example.uri.metadata", uriId.getValue());
    assertEquals("example.package.metadata", packageMetadataId.getValue());
    for (IdType id : List.of(guideId, dependencyId, titleId, contactId, renderingId, jurisdictionId,
        versionId, uriId, packageMetadataId)) {
      assertSame(content, id.getUserData("keep"));
      assertEquals(Set.of("keep"), id.getUserDataNames());
    }
    for (Extension extension : List.of(titleExtension, contactExtension, renderingExtension,
        jurisdictionExtension, versionExtension, uriExtension, packageExtension)) {
      assertEquals(0, extension.getNamedValue("url", false).length);
    }
    assertSame(content, name.getUserData("keep"));
    assertSame(content, rendering.getUserData("keep"));
    assertSame(content, version.getUserData("keep"));
    assertEquals(Set.of("keep"), name.getUserDataNames());
    assertEquals(Set.of("keep"), rendering.getUserDataNames());
    assertEquals(Set.of("keep"), version.getUserDataNames());
    assertSame(Boolean.FALSE, packageId.getUserData(UserDataNames.IG_DEP_ALIASED));
    assertEquals(Set.of(UserDataNames.IG_DEP_ALIASED), packageId.getUserDataNames());
  }

  @ParameterizedTest
  @CsvSource({"false, false", "true, false", "true, true"})
  @ResourceLock(Resources.LOCALE)
  @ResourceLock("java.util.TimeZone.default")
  void rawJsonConstructorsPreserveCallerDependencies(boolean dated, boolean notForPublication) throws IOException {
    withFixedFormatting(() -> {
      JsonObject raw = rawPackage();
      if (!dated) {
        raw.add("notForPublication", true);
      }
      JsonObject dependencies = raw.getJsonObject("dependencies");
      JsonObject expected = raw.deepCopy();
      if (dated) {
        expected.set("date", "20200203040506");
      }

      List<String> warnings = captureWarnings(() -> {
        NPMPackageGenerator generator = dated
            ? new NPMPackageGenerator(destination(), raw, DATE, notForPublication)
            : new NPMPackageGenerator(destination(), raw);
        Archive archive = finish(generator);

        assertSame(raw, generator.getPackageJ());
        assertSame(dependencies, raw.getJsonObject("dependencies"));
        assertJsonEquals(JsonParser.compose(expected), JsonParser.compose(raw));
        assertJsonEquals(JsonParser.compose(expected), JsonParser.compose(archive.packageJson));
        assertDependencies(archive.packageJson,
            "{\"example.caller\":\"caller-version\",\"example.pending\":null,\"hl7.fhir.r5.core\":\"caller-r5\"}");
        assertEquals("example.raw", archive.packageJson.asString("name"));
        assertEquals("9.8.7", archive.packageJson.asString("version"));
        assertEquals("Tool", archive.packageJson.asString("type"));
        assertEquals("Raw title", archive.packageJson.asString("title"));
        assertEquals(List.of("6.0.0", "5.0.0"), archive.packageJson.getStrings("fhirVersions"));
        assertEquals(dated ? "20200203040506" : "caller-date", archive.packageJson.asString("date"));
        assertNull(generator.version());
        if (dated) {
          // The dated raw constructor changes the caller's date, not its publication flag.
          assertFalse(raw.has("notForPublication"));
          assertEquals(notForPublication
              ? List.of("version", "date", "notForPublication", "name")
              : List.of("version", "date", "name"), propertyNames(archive.manifest));
          assertEquals("example.raw", archive.manifest.asString("name"));
          assertEquals("9.8.7", archive.manifest.asString("version"));
          assertEquals("20200203040506", archive.manifest.asString("date"));
          assertEquals(notForPublication, archive.manifest.has("notForPublication"));
          if (notForPublication) {
            assertTrue(archive.manifest.asBoolean("notForPublication"));
          }
        } else {
          assertTrue(archive.packageJson.asBoolean("notForPublication"));
          assertNull(archive.manifest);
        }
        assertEquals(0, archive.index.getJsonArray("files").size());
      });

      assertTrue(warnings.isEmpty(), warnings.toString());
    });
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  @ResourceLock(Resources.LOCALE)
  @ResourceLock("java.util.TimeZone.default")
  void subsetPreservesCopiedDependencies(boolean notForPublication) throws IOException {
    withFixedFormatting(() -> {
      JsonObject raw = rawPackage();
      JsonObject dependencies = raw.getJsonObject("dependencies");
      String original = JsonParser.compose(raw);
      String originalDependencies = JsonParser.compose(dependencies);

      List<String> warnings = captureWarnings(() -> {
        NPMPackageGenerator master = new NPMPackageGenerator(destination(), raw);
        Archive masterArchive = finish(master);
        // Finish the master before starting another archive writer; subset only needs its package JSON.
        NPMPackageGenerator subset = NPMPackageGenerator.subset(master, destination(), "example.subset",
            "Subset title", DATE, notForPublication);
        Archive subsetArchive = finish(subset);

        assertDependencies(masterArchive.packageJson,
            "{\"example.caller\":\"caller-version\",\"example.pending\":null,\"hl7.fhir.r5.core\":\"caller-r5\"}");
        assertDependencies(subsetArchive.packageJson,
            "{\"example.caller\":\"caller-version\",\"example.pending\":null,\"hl7.fhir.r5.core\":\"caller-r5\"}");
        assertNotSame(raw, subset.getPackageJ());
        assertNotSame(dependencies, subset.getPackageJ().getJsonObject("dependencies"));
        assertSame(raw, master.getPackageJ());
        assertSame(dependencies, master.getPackageJ().getJsonObject("dependencies"));
        assertEquals(original, JsonParser.compose(raw));
        assertEquals(originalDependencies, JsonParser.compose(dependencies));
        assertJsonEquals(original, JsonParser.compose(masterArchive.packageJson));
        assertNull(masterArchive.manifest);
        assertEquals("example.subset", subsetArchive.packageJson.asString("name"));
        assertEquals("9.8.7", subsetArchive.packageJson.asString("version"));
        assertEquals("Conformance", subsetArchive.packageJson.asString("type"));
        assertEquals("Subset title", subsetArchive.packageJson.asString("title"));
        assertEquals("20200203040506", subsetArchive.packageJson.asString("date"));
        assertEquals(List.of("6.0.0", "5.0.0"), subsetArchive.packageJson.getStrings("fhirVersions"));
        assertEquals(notForPublication, subsetArchive.packageJson.has("notForPublication"));
        if (notForPublication) {
          assertTrue(subsetArchive.packageJson.asBoolean("notForPublication"));
        }
        assertEquals(notForPublication ? 8 : 7, subsetArchive.packageJson.getNames().size());
        assertEquals(notForPublication
            ? List.of("version", "date", "notForPublication", "name")
            : List.of("version", "date", "name"), propertyNames(subsetArchive.manifest));
        assertEquals("example.subset", subsetArchive.manifest.asString("name"));
        assertEquals("9.8.7", subsetArchive.manifest.asString("version"));
        assertEquals("20200203040506", subsetArchive.manifest.asString("date"));
        assertEquals(notForPublication, subsetArchive.manifest.has("notForPublication"));
        if (notForPublication) {
          assertTrue(subsetArchive.manifest.asBoolean("notForPublication"));
        }
        assertEquals(0, masterArchive.index.getJsonArray("files").size());
        assertEquals(0, subsetArchive.index.getJsonArray("files").size());
      });

      assertTrue(warnings.isEmpty(), warnings.toString());
    });
  }

  private static GuideProbe guide() {
    GuideProbe ig = new GuideProbe();
    ig.setPackageId(GUIDE_ID);
    ig.setVersion("2.3.4");
    return ig;
  }

  private static GuideProbe populatedGuide() {
    GuideProbe ig = guide();
    ig.setUrl("http://example.org/ig-url-not-the-package-canonical");
    ig.setTitle("Guide title");
    ig.setDescription("Guide description");
    ig.setPublisher("Publisher");
    ig.setLicense(SPDXLicense.MIT);
    ig.addFhirVersion(FHIRVersion._6_0_0);
    ig.addFhirVersion(FHIRVersion._5_0_0);
    ContactProbe alpha = new ContactProbe();
    alpha.setName("Alpha");
    alpha.addTelecom(contactPoint(ContactPointSystem.PHONE, "123"));
    alpha.addTelecom(contactPoint(ContactPointSystem.EMAIL, "first@example.org"));
    alpha.addTelecom(contactPoint(ContactPointSystem.EMAIL, "later@example.org"));
    alpha.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/first"));
    alpha.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/later"));
    ContactProbe beta = new ContactProbe();
    beta.setName("Beta");
    beta.addTelecom(contactPoint(ContactPointSystem.URL, "https://example.org/beta"));
    ig.addContact(alpha);
    ig.addContact(new ContactProbe());
    ig.addContact(beta);
    ImplementationGuideManifestComponent manifest = new ImplementationGuideManifestComponent();
    manifest.setRendering("https://example.org/home");
    ig.setManifest(manifest);
    ConceptProbe jurisdiction = new ConceptProbe();
    jurisdiction.addCoding(new Coding().setSystem("urn:iso:std:iso:3166").setCode("US"));
    ig.addJurisdiction(jurisdiction);
    ig.addDependsOn(dependency("example.dep", "7.8.9"));
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

  private static ContactPoint contactPoint(ContactPointSystem system, String value) {
    return new ContactPoint().setSystem(system).setValue(value);
  }

  private static JsonObject rawPackage() throws IOException {
    return JsonParser.parseObject("{\"name\":\"example.raw\",\"version\":\"9.8.7\",\"type\":\"Tool\","
        + "\"title\":\"Raw title\",\"date\":\"caller-date\",\"fhirVersions\":[\"6.0.0\",\"5.0.0\"],"
        + "\"dependencies\":{\"example.caller\":\"caller-version\",\"example.pending\":null,"
        + "\"hl7.fhir.r5.core\":\"caller-r5\"}}");
  }

  private String destination() {
    return tempDir.resolve("package-" + packageNumber++ + ".tgz").toString();
  }

  private NPMPackageGenerator create(IgConstructor constructor, ImplementationGuide ig, PackageType kind,
      List<String> versions, Map<String, String> related, boolean notForPublication) throws IOException {
    switch (constructor) {
    case TYPED:
      return new NPMPackageGenerator(SUPPLIED_ID, destination(), CANONICAL, WEB, kind, ig, DATE,
          related, notForPublication);
    case SINGLE:
      return new NPMPackageGenerator(SUPPLIED_ID, destination(), CANONICAL, WEB, kind, ig, DATE,
          related, notForPublication, versions.get(0));
    case LIST:
      return new NPMPackageGenerator(destination(), CANONICAL, WEB, kind, ig, DATE, versions,
          related, notForPublication);
    default:
      throw new IllegalArgumentException(constructor.name());
    }
  }

  private Archive finish(NPMPackageGenerator generator) throws IOException {
    // Every successful construction is passed here immediately, before any assertion can fail.
    generator.finish();
    NpmPackage npm;
    try (InputStream input = Files.newInputStream(Path.of(generator.filename()))) {
      npm = NpmPackage.fromPackage(input);
    }
    JsonObject packageJson;
    JsonObject index;
    // Read the stored files, not NpmPackage.getNpm(), which applies loader compatibility fixes.
    try (InputStream input = npm.load("package", "package.json");
        InputStream indexInput = npm.load("package", ".index.json")) {
      packageJson = JsonParser.parseObject(input);
      index = JsonParser.parseObject(indexInput);
    }
    JsonObject manifest = null;
    Path sidecar = Path.of(FileUtilities.changeFileExt(generator.filename(), ".manifest.json"));
    if (Files.exists(sidecar)) {
      try (InputStream input = Files.newInputStream(sidecar)) {
        manifest = JsonParser.parseObject(input);
      }
    }
    return new Archive(packageJson, manifest, index);
  }

  private static void assertDependencies(JsonObject packageJson, String expectedJson) throws IOException {
    JsonObject expected = JsonParser.parseObject(expectedJson);
    JsonObject actual = packageJson.getJsonObject("dependencies");
    assertNotNull(actual);
    assertEquals(propertyNames(expected), propertyNames(actual), "dependency order");
    for (String name : propertyNames(expected)) {
      if (expected.hasNull(name)) {
        assertTrue(actual.hasNull(name), name + " must be JSON null");
      } else {
        assertTrue(actual.hasString(name), name + " must be a string");
        assertEquals(expected.asString(name), actual.asString(name), name);
      }
    }
  }

  private static List<String> propertyNames(JsonObject object) {
    return object.getProperties().stream().map(JsonProperty::getName).toList();
  }

  private static void assertJsonEquals(String expected, String actual) throws IOException {
    assertEquals(JsonParser.compose(JsonParser.parse(expected)), JsonParser.compose(JsonParser.parse(actual)));
  }

  private static void assertWarning(String warning, String guideId, int index, String... identities) {
    assertTrue(warning.contains(guideId), warning);
    assertTrue(warning.contains("dependsOn[" + index + "]"), warning);
    for (String identity : identities) {
      assertTrue(warning.contains(identity), warning);
    }
    assertTrue(warning.contains("specify dependsOn.version"), warning);
    assertFalse(warning.contains("null"), warning);
    assertFalse(warning.contains("omitted"), warning);
  }

  private static List<String> captureWarnings(PackageAction action) throws IOException {
    Logger logger = (Logger) LoggerFactory.getLogger(NPMPackageGenerator.class);
    Level previousLevel = logger.getLevel();
    boolean previousAdditivity = logger.isAdditive();
    ListAppender<ILoggingEvent> appender = new ListAppender<>();
    appender.setContext(logger.getLoggerContext());
    try {
      logger.setLevel(Level.WARN);
      logger.setAdditive(false);
      appender.start();
      logger.addAppender(appender);
      action.run();
      return appender.list.stream()
          .filter(event -> event.getLevel() == Level.WARN && event.getFormattedMessage().contains("dependsOn"))
          .map(ILoggingEvent::getFormattedMessage)
          .toList();
    } finally {
      logger.detachAppender(appender);
      appender.stop();
      logger.setLevel(previousLevel);
      logger.setAdditive(previousAdditivity);
    }
  }

  private static void withFixedFormatting(PackageAction action) throws IOException {
    Locale previousLocale = Locale.getDefault();
    Locale previousFormat = Locale.getDefault(Locale.Category.FORMAT);
    Locale previousDisplay = Locale.getDefault(Locale.Category.DISPLAY);
    TimeZone previousTimeZone = TimeZone.getDefault();
    try {
      Locale.setDefault(Locale.US);
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
      action.run();
    } finally {
      TimeZone.setDefault(previousTimeZone);
      Locale.setDefault(previousLocale);
      Locale.setDefault(Locale.Category.FORMAT, previousFormat);
      Locale.setDefault(Locale.Category.DISPLAY, previousDisplay);
    }
  }

  @FunctionalInterface
  private interface PackageAction {
    void run() throws IOException;
  }

  private static final class Archive {
    private final JsonObject packageJson;
    private final JsonObject manifest;
    private final JsonObject index;

    private Archive(JsonObject packageJson, JsonObject manifest, JsonObject index) {
      this.packageJson = packageJson;
      this.manifest = manifest;
      this.index = index;
    }
  }

  private static final class GuideProbe extends ImplementationGuide {
    IdType storedPackageId() {
      return packageId;
    }

    StringType storedVersion() {
      return version;
    }

    List<Enumeration<FHIRVersion>> storedFhirVersions() {
      return fhirVersionList;
    }

    List<ImplementationGuideDependsOnComponent> storedDependsOn() {
      return dependsOnList;
    }

    List<ContactDetail> storedContacts() {
      return contactList;
    }

    List<CodeableConcept> storedJurisdictions() {
      return jurisdictionList;
    }

    ImplementationGuideManifestComponent storedManifest() {
      return manifest;
    }

    List<Extension> storedExtensions() {
      return extensionList;
    }

    List<Extension> storedModifiers() {
      return modifierExtensionList;
    }
  }

  private static final class ContactProbe extends ContactDetail {
    List<ContactPoint> storedTelecom() {
      return telecomList;
    }

    StringType storedName() {
      return name;
    }

    List<Extension> storedExtensions() {
      return extensionList;
    }
  }

  private static final class ConceptProbe extends CodeableConcept {
    List<Coding> storedCodings() {
      return codingList;
    }

    StringType storedText() {
      return text;
    }

    List<Extension> storedExtensions() {
      return extensionList;
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
