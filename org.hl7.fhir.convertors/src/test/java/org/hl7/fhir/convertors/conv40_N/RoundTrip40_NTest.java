package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.TestConfig;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Round trip tests for R4 <-> R6 conversion, driven by the examples from the two specifications.
 * <p>
 * Layout, under conversion/roundtrip40_N in fhir-test-cases:
 * <pre>
 *   r4/resource/X.json   - an R4 example (the source)
 *   r4/converted/X.json  - what it converts to in R6
 *   r4/returned/X.json   - what that converts back to in R4
 *   r6/resource/X.json   - an R6 example (the source)
 *   r6/converted/X.json  - what it converts to in R4
 *   r6/returned/X.json   - what that converts back to in R6
 * </pre>
 * Each test converts the source to the other version and back again, and checks that:
 * <ul>
 *   <li>what comes back is exactly the source (the resource files are written by the same composer the
 *     test uses, so this is a string comparison) - nothing is lost or changed in the round trip</li>
 *   <li>the conversion itself is what converted/X.json says it is</li>
 *   <li>what came back is what returned/X.json says it is</li>
 * </ul>
 * The three folders on each side use the same file names, so when a round trip fails, a folder diff of resource
 * vs returned shows what it loses or changes.
 * <p>
 * The converted and returned files are not hand written: they record what the convertors produce. A missing one
 * is a failure, unless the system property {@value #WRITE_PROPERTY} is true, when the test writes what the
 * convertors currently produce (to a local fhir-test-cases checkout). So to accept a change in the convertors,
 * or to see what a failing round trip returns, delete the affected converted and returned files and re-run the
 * tests with -D{@value #WRITE_PROPERTY}=true.
 * <p>
 * The source files are:
 * <ul>
 *   <li>the examples from the specifications, put in place by {@link RoundTrip40_NSeeder}</li>
 *   <li>synthetic-[type]-[n].json: resources that populate nearly every element of each type</li>
 *   <li>choice-[type]-[n].json: resources that between them use every type of every choice element of each type</li>
 *   <li>case-[name].json: hand written cases for particular problems</li>
 * </ul> All of them must be resources the convertors support: the types they don't
 * support are listed in {@link #R4_UNSUPPORTED} and {@link #R6_UNSUPPORTED}, which {@link #testUnsupportedTypes}
 * checks.
 */
class RoundTrip40_NTest {

  static final String ROOT_NAME = "roundtrip40_N";

  /** the system property that says to write missing converted files instead of failing */
  static final String WRITE_PROPERTY = "roundtrip40_N.write";

  /**
   * The R4 resource types the convertors don't handle. The test cases can't exercise these, so this list is what
   * the round trip tests don't cover; {@link #testUnsupportedTypes} fails if it's not right
   */
  static final java.util.Set<String> R4_UNSUPPORTED = new java.util.TreeSet<>(java.util.Arrays.asList(
    "CatalogEntry", "ChargeItem", "ChargeItemDefinition", "ClinicalImpression", "Contract", "DeviceUseStatement",
    "DocumentManifest", "EffectEvidenceSynthesis", "EnrollmentRequest", "EnrollmentResponse",
    "ImmunizationEvaluation", "ImmunizationRecommendation", "InsurancePlan", "Linkage",
    "MedicationKnowledge", "MedicinalProduct", "MedicinalProductAuthorization", "MedicinalProductContraindication",
    "MedicinalProductIndication", "MedicinalProductIngredient", "MedicinalProductInteraction",
    "MedicinalProductManufactured", "MedicinalProductPackaged", "MedicinalProductPharmaceutical",
    "MedicinalProductUndesirableEffect", "MolecularSequence", "ResearchDefinition", "ResearchElementDefinition",
    "RiskEvidenceSynthesis", "SubstanceNucleicAcid", "SubstancePolymer", "SubstanceProtein",
    "SubstanceReferenceInformation", "SubstanceSourceMaterial", "SubstanceSpecification", "SupplyDelivery",
    "SupplyRequest", "VerificationResult"));

  /**
   * The R6 resource types the convertors don't handle (as for {@link #R4_UNSUPPORTED})
   */
  static final java.util.Set<String> R6_UNSUPPORTED = new java.util.TreeSet<>(java.util.Arrays.asList(
    "AdministrableProductDefinition", "ClinicalUseDefinition", "DeviceAlert", "ImagingSelection", "Ingredient",
    "ManufacturedItemDefinition", "MedicinalProductDefinition", "NutritionProduct", "PackagedProductDefinition",
    "RegulatedAuthorization", "SubscriptionStatus", "SubstanceDefinition"));

  /**
   * The local fhir-test-cases checkout if there is one (and then missing outputs can be written),
   * otherwise the copy in the fhir-test-cases jar (read only)
   */
  static Path root() throws IOException {
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && Files.isDirectory(Paths.get(dir))) {
      return Paths.get(dir, "conversion", ROOT_NAME);
    }
    URL url = RoundTrip40_NTest.class.getResource("/org/hl7/fhir/testcases/conversion/" + ROOT_NAME);
    if (url == null) {
      throw new IOException("Unable to find the fhir-test-cases folder conversion/" + ROOT_NAME);
    }
    try {
      URI uri = url.toURI();
      if ("jar".equals(uri.getScheme())) {
        try {
          FileSystems.getFileSystem(uri);
        } catch (FileSystemNotFoundException e) {
          FileSystems.newFileSystem(uri, Collections.emptyMap());
        }
      }
      return Paths.get(uri);
    } catch (URISyntaxException e) {
      throw new IOException(e);
    }
  }

  private static Stream<Arguments> cases(String version) throws IOException {
    Path folder = root().resolve(version).resolve("resource");
    if (!Files.isDirectory(folder)) {
      throw new IOException("The round trip test cases were not found at " + folder.toUri() + " (the fhir-test-cases location comes from the "
        + TestConfig.FHIR_TEST_CASES + " environment variable, or fhirTestCasesPath in fhir-settings.json, or else the fhir-test-cases jar)");
    }
    List<String> names;
    try (Stream<Path> files = Files.list(folder)) {
      names = files.map(f -> f.getFileName().toString()).filter(n -> n.endsWith(".json")).sorted().collect(Collectors.toList());
    }
    if (names.isEmpty()) {
      throw new IOException("No round trip test cases found in " + folder.toUri());
    }
    return names.stream().map(Arguments::of);
  }

  static Stream<Arguments> r4Cases() throws IOException {
    return cases("r4");
  }

  static Stream<Arguments> r6Cases() throws IOException {
    return cases("r6");
  }

  static org.hl7.fhir.r4.formats.JsonParser r4Parser() {
    return (org.hl7.fhir.r4.formats.JsonParser) new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY);
  }

  static org.hl7.fhir.model.core.formats.JsonParser r6Parser() {
    org.hl7.fhir.model.core.formats.JsonParser p = new org.hl7.fhir.model.core.formats.JsonParser(ModelContext.fullCoreContext());
    p.setOutputStyle(OutputStyle.PRETTY);
    return p;
  }

  /**
   * True if the exception is the convertors saying they don't handle this resource type (directly, or
   * because it's in a Bundle or contained)
   */
  static boolean isUnsupported(Exception e) {
    // "The type X cannot be converted" is a bug in a convertor that is supported, not an unsupported resource
    return e instanceof FHIRException && e.getMessage() != null && e.getMessage().startsWith("The resource ") && e.getMessage().contains(" cannot be converted");
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("r4Cases")
  void testR4RoundTrip(String name) throws IOException {
    Path folder = root().resolve("r4");
    org.hl7.fhir.r4.model.Resource src = r4Parser().parse(Files.readAllBytes(folder.resolve("resource").resolve(name)));

    org.hl7.fhir.model.core.Resource converted = VersionConvertorFactory_40_N.convertResource(src);
    String convertedJson = r6Parser().composeString(converted);

    // convert back from the serialised form, so that the converted output has to be valid R6
    org.hl7.fhir.r4.model.Resource returned = VersionConvertorFactory_40_N.convertResource(r6Parser().parse(convertedJson));
    String returnedJson = r4Parser().composeString(returned);

    assertAll(roundTrip(folder, name, returnedJson), check(folder, "converted", name, convertedJson), check(folder, "returned", name, returnedJson));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("r6Cases")
  void testR6RoundTrip(String name) throws IOException {
    Path folder = root().resolve("r6");
    org.hl7.fhir.model.core.Resource src = r6Parser().parse(Files.readAllBytes(folder.resolve("resource").resolve(name)));

    org.hl7.fhir.r4.model.Resource converted = VersionConvertorFactory_40_N.convertResource(src);
    String convertedJson = r4Parser().composeString(converted);

    // convert back from the serialised form, so that the converted output has to be valid R4
    org.hl7.fhir.model.core.Resource returned = VersionConvertorFactory_40_N.convertResource(r4Parser().parse(convertedJson));
    String returnedJson = r6Parser().composeString(returned);

    assertAll(roundTrip(folder, name, returnedJson), check(folder, "converted", name, convertedJson), check(folder, "returned", name, returnedJson));
  }

  /**
   * The types the convertors refuse must be exactly the ones listed as unsupported: so a type that stops
   * being supported is noticed, and so is one that becomes supported (it needs test cases)
   */
  @org.junit.jupiter.api.Test
  void testUnsupportedTypes() {
    java.util.Set<String> r4 = new java.util.TreeSet<>();
    for (org.hl7.fhir.r4.model.ResourceType t : org.hl7.fhir.r4.model.ResourceType.values()) {
      try {
        VersionConvertorFactory_40_N.convertResource(org.hl7.fhir.r4.model.ResourceFactory.createResource(t.name()));
      } catch (Exception e) {
        if (isUnsupported(e)) {
          r4.add(t.name());
        }
      }
    }
    java.util.Set<String> r6 = new java.util.TreeSet<>();
    for (org.hl7.fhir.model.core.Enumerations.FHIRTypes t : org.hl7.fhir.model.core.Enumerations.FHIRTypes.values()) {
      org.hl7.fhir.model.core.Resource res = r6Resource(t.toCode());
      if (res != null) {
        try {
          VersionConvertorFactory_40_N.convertResource(res);
        } catch (Exception e) {
          if (isUnsupported(e)) {
            r6.add(t.toCode());
          }
        }
      }
    }
    assertAll(() -> assertEquals(R4_UNSUPPORTED, r4, "The R4 resource types the convertors don't handle"),
      () -> assertEquals(R6_UNSUPPORTED, r6, "The R6 resource types the convertors don't handle"));
  }

  // an empty instance of the R6 resource type, or null if it isn't a (concrete) resource type
  private static org.hl7.fhir.model.core.Resource r6Resource(String name) {
    if (name == null) {
      return null;
    }
    for (String pkg : new String[] {"core", "api", "testing", "fml"}) {
      try {
        Class<?> c = Class.forName("org.hl7.fhir.model." + pkg + "." + ("List".equals(name) ? "ListResource" : name));
        if (org.hl7.fhir.model.core.Resource.class.isAssignableFrom(c) && !java.lang.reflect.Modifier.isAbstract(c.getModifiers())) {
          return (org.hl7.fhir.model.core.Resource) c.getDeclaredConstructor().newInstance();
        }
      } catch (ReflectiveOperationException e) {
        // not in this package
      }
    }
    return null;
  }

  /**
   * what came back must be exactly what the source was
   */
  private static Executable roundTrip(Path folder, String name, String returned) throws IOException {
    String source = new String(Files.readAllBytes(folder.resolve("resource").resolve(name)), StandardCharsets.UTF_8);
    return () -> assertEquals(normalise(source), normalise(returned), name + ": the round trip doesn't return the source");
  }

  /**
   * The file must be there, and must not have changed (if it's not there, and the system property
   * {@value #WRITE_PROPERTY} is true, it's written)
   */
  private static Executable check(Path folder, String kind, String name, String actual) throws IOException {
    Path file = folder.resolve(kind).resolve(name);
    if (!Files.exists(file)) {
      if (!Boolean.getBoolean(WRITE_PROPERTY)) {
        return () -> fail(kind + "/" + name + " is missing (to write it, run the test with -D" + WRITE_PROPERTY + "=true against a local fhir-test-cases checkout)");
      }
      if (file.getFileSystem() != FileSystems.getDefault()) {
        return () -> fail(kind + "/" + name + " is missing, and can't be created in the fhir-test-cases jar - run the test against a local fhir-test-cases checkout");
      }
      Files.createDirectories(file.getParent());
      Files.write(file, actual.getBytes(StandardCharsets.UTF_8));
      return () -> { };
    }
    String expected = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
    return () -> assertEquals(normalise(expected), normalise(actual),
      kind + "/" + name + " has changed (delete " + file + " to accept the new output)");
  }

  private static String normalise(String s) {
    return s.replace("\r\n", "\n").trim();
  }
}
