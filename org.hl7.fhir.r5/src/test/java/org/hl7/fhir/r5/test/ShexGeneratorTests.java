package org.hl7.fhir.r5.test;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ShExGeneratorBase;
import org.hl7.fhir.r5.conformance.ShExGeneratorConfig;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ShExGeneratorR6;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class ShexGeneratorTests {
  private static final Path ROOT_TEST_PATH = Paths.get("testUtilities");
  private static final Path DEFAULT_EXPECTED_SHEX_DIR = ROOT_TEST_PATH.resolve("shex/expected");
  private static final Path DEFAULT_EXPECTED_PROFILE_DIR = ROOT_TEST_PATH.resolve("xml/examples/expected");

  public ShExGenerator shexGenerator;
  private static Path expectedShexDirectory;
  private static Path expectedProfileDirectory;
  private static IWorkerContext r5WorkerContext;
  private static IWorkerContext r6WorkerContext;

  @BeforeAll
  public static void setup() throws IOException {
    expectedShexDirectory = TurtleGeneratorTestUtils.getResourcePath(DEFAULT_EXPECTED_SHEX_DIR);
    expectedProfileDirectory = TurtleGeneratorTestUtils.getResourcePath(DEFAULT_EXPECTED_PROFILE_DIR);
    r5WorkerContext = TestingUtilities.getSharedWorkerContext();
    r6WorkerContext = TurtleGeneratorTestUtils.getVersionOverrideWorkerContext("6.0.0");
  }

  @AfterAll
  public static void tearDown() {
    r5WorkerContext = null;
    r6WorkerContext = null;
    expectedShexDirectory = null;
    expectedProfileDirectory = null;
  }

  /** Calling R5 ShExGenerator with R6 context should preserve the variable settings when redirected to ShExGeneratorR6 */
  @SuppressWarnings("deprecation")
  @Test
  public void testCompleteModelCopiesConfigurationToR6Deprecated() throws IOException {
    ShExGenerator generator = new ShExGenerator(r6WorkerContext);
    generator.completeModel = true;
    generator.withComments = false;

    ShExGeneratorR6 direct = new ShExGeneratorR6(r6WorkerContext);
    direct.completeModel = true;
    direct.withComments = false;

    assertCompleteModelR6MatchesDirectGenerator(generator, direct);
  }

  /** Calling R5 ShExGenerator with R6 context should preserve the config settings when redirected to ShExGeneratorR6 */
  @Test
  public void testCompleteModelCopiesConfigurationToR6Config() throws IOException {
    ShExGeneratorConfig config = new ShExGeneratorConfig(false, false, true, false, false,
      ShExGeneratorBase.ConstraintTranslationPolicy.ALL);

    assertCompleteModelR6MatchesDirectGenerator(
      new ShExGenerator(r6WorkerContext, config),
      new ShExGeneratorR6(r6WorkerContext, config)
    );
  }

  /**
   * Drift detector for {@link ShExGeneratorConfig}: if a new public mutable field is added to
   * {@link ShExGeneratorBase}, this test fails so the new field is either threaded through
   * ShExGeneratorConfig (and the R5→R6 sync) or explicitly added to the ignored set below.
   */
  @Test
  public void shExGeneratorConfigCoversAllPublicBaseSettings() {
    Set<String> covered = Set.of(
        "doDatatypes", "withComments", "completeModel", "debugMode",
        "processConstraints", "constraintPolicy");
    Set<String> ignored = Set.of();

    Set<String> declared = Arrays.stream(ShExGeneratorBase.class.getDeclaredFields())
        .filter(f -> Modifier.isPublic(f.getModifiers()))
        .filter(f -> !Modifier.isStatic(f.getModifiers()))
        .filter(f -> !Modifier.isFinal(f.getModifiers()))
        .map(Field::getName)
        .collect(Collectors.toSet());

    Set<String> unaccounted = new HashSet<>(declared);
    unaccounted.removeAll(covered);
    unaccounted.removeAll(ignored);

    assertThat(unaccounted)
        .as("New ShExGeneratorBase field(s) not covered by ShExGeneratorConfig — add to covered or ignored set")
        .isEmpty();
  }

  /** Generate complete ShEx schema from default org.hl7.fhir.r5 context of StructureDefinitions */
  @Test
  public void testCompleteModelR5() {
    assertDoesNotThrow(() -> {
      Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fhir-r5.shex");
      generateCompleteModel(r5WorkerContext, outPath);
    });
  }

  @Disabled("Run manually - R6 complete model tested elsewhere")
  @Test
  public void testCompleteModelR6() {
    assertDoesNotThrow(() -> {
      Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fhir-r6.shex");
      generateCompleteModel(r6WorkerContext, outPath);
    });
  }

  /** Generate complete ShEx schema from directory of StructureDefinition XML files. This is what Kindling does to produce the published spec. */
  @Disabled("Run manually with provided directory of StructureDefinition XML files")
  @Test
  public void testGenerateShexFromProfileDirectory() throws FHIRException, IOException, UcumException {
    String profileDirectoryPath = "./fhir-spec-r5/site";
    String fhirVersion = "5.0.0";
    generateShexFromProfileDirectory(profileDirectoryPath, fhirVersion);
  }

  /** Generate individual ShEx schemas */
  @Test
  public void testId() throws FHIRException, IOException, UcumException {
    doTestR5("id");
  }

  @Test
  public void testUri() throws FHIRException, IOException, UcumException {
    doTestR5("uri");
  }

  @Test
  public void testPatient() throws FHIRException, IOException, UcumException {
    doTestR5("Patient");
  }

  @Test
  public void testPatientR6() throws FHIRException, IOException, UcumException {
    doTestR6("Patient");
  }

  @Test
  public void testMatchPatientProfileFromFile() throws IOException, UcumException {
    doTestMatchFromFileR5(Paths.get("R5", "patient.profile.xml").toString());
  }
  
  @Test
  public void testMatchPatientProfileFromFileR6() throws IOException, UcumException {
    doTestMatchFromFileR6(Paths.get("R6", "patient.profile.xml").toString());
  }

  @Test
  public void testObservation() throws FHIRException, IOException, UcumException {
    doTestR5("Observation");
  }

  @Test
  public void testRef() throws FHIRException, IOException, UcumException {
    doTestR5("Reference");
  }

  @Test
  public void testAccount() throws FHIRException, IOException, UcumException {
    doTestR5("Account");
  }

  @Test
  public void testAppointment() throws FHIRException, IOException, UcumException {
    doTestR5("Appointment");
  }

  @Test
  public void testBundle() throws FHIRException, IOException, UcumException {
    doTestR5("Bundle");
  }

  @Test
  public void testAge() throws FHIRException, IOException, UcumException {
    doTestR5("Age");
  }

  @Test
  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
    doTestR5("MedicationRequest");
  }

  @Test
  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
    doTestR5("AllergyIntolerance");
  }

  @Test
  public void testCoding() throws FHIRException, IOException, UcumException {
    doTestR5("Coding");
  }

  @Test
  public void testTiming() throws FHIRException, IOException, UcumException {
    doTestR5("Timing");
  }

  @Test
  public void testSignature() throws FHIRException, IOException, UcumException {
    doTestR5("Signature");
  }

  @Test
  public void testCapabilityStatement() throws FHIRException, IOException, UcumException {
    doTestR5("CapabilityStatement");
  }

  @Test
  public void testElement() throws FHIRException, IOException, UcumException {
    doTestR5("Element");
  }

  @ParameterizedTest(name = "ShExComparator: {0} compareTo {1} = {2}")
  @MethodSource("stringsToCompare")
  public void testShExComparator(String o1, String o2, int aCompareBExpected) {
    ShExGenerator.ShExComparator comparator = new ShExGenerator.ShExComparator();
    int aCompareB = comparator.compare(o1, o2);
    int bCompareA = comparator.compare(o2, o1);
    assertThat(aCompareB).isEqualTo(aCompareBExpected);
    assertThat(aCompareB).isEqualTo(-bCompareA);
  }


  // ---------------------------------------------------------------------------
  // Test helpers
  // ---------------------------------------------------------------------------

  private void doTestR5(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    doTest(name, r5WorkerContext);
  }

  private void doTestR6(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    doTest(name, r6WorkerContext);
  }

  private void doTest(String name, IWorkerContext context) throws FileNotFoundException, IOException, FHIRException, UcumException {
    assertDoesNotThrow(() -> {
      // Load StructureDefinition from context. This StructureDefinition is not necessarily stable for the purpose of comparison with generated ShEx. See doTestFromFile()
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
      if (sd == null) throw new FHIRException("StructuredDefinition for " + name + "was null");
      generateShex(name.toLowerCase(), sd, context);
    });
  }


  private void doTestMatchFromFileR5(String relativeProfilePath) throws IOException, UcumException {
    doTestMatchFromFile(relativeProfilePath, expectedShexDirectory.resolve("R5"));
  }

  private void doTestMatchFromFileR6(String relativeProfilePath) throws IOException, UcumException {
    doTestMatchFromFile(relativeProfilePath, expectedShexDirectory.resolve("R6"));
  }

  private void doTestMatchFromFile(String relativeProfilePath, Path expectedDirectory) throws IOException, UcumException {
    // Load StructureDefinition from XML file
    Path profilePath = expectedProfileDirectory.resolve(relativeProfilePath);
    StructureDefinition sd = loadFromXmlFile(profilePath.toString());

    String shexFileName = getExpectedShexBaseName(profilePath);
    Path generatedShexPath = generateShex(shexFileName, sd, getWorkerContextForProfile(sd));

    // Compare with corresponding expected ShEx file if available
    Path expectedShexPath =  expectedDirectory.resolve(shexFileName.toLowerCase() + ".shex"); 
    compareShex(expectedShexPath, generatedShexPath);
  }

  private Path generateShex(String outputName, StructureDefinition sd, IWorkerContext context) throws IOException, UcumException {
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), outputName + ".shex");
    System.out.println("Generated ShEx to " + outPath.toString());
    FileUtilities.stringToFile(new ShExGenerator(context).generate(ShExGeneratorBase.HTMLLinkPolicy.NONE, sd), outPath.toString());
    return outPath;
  }

  private void compareShex(Path actualShexPath, Path expectedShexPath) throws IOException {
    if (Files.exists(expectedShexPath)) {
      System.out.println("Comparing with expected ShEx: " + expectedShexPath.toString());
      assertThat(normalize(Files.readString(actualShexPath))).isEqualTo(normalize(Files.readString(expectedShexPath)));
    } else { 
      fail("File expected for comparison does not exist: " + expectedShexPath); 
    }
  }

  private String getExpectedShexBaseName(Path profilePath) {
    String fileName = profilePath.getFileName().toString().toLowerCase();
    if (fileName.endsWith(".profile.xml")) {
      return fileName.substring(0, fileName.length() - ".profile.xml".length());
    }
    if (fileName.endsWith(".xml")) {
      return fileName.substring(0, fileName.length() - ".xml".length());
    }
    return fileName;
  }

  private static String normalize(String content) {
    // Normalize for string comparison: Remove any UTF-8 BOM, convert all line endings to \n, and trim leading and trailing whitespace
    return content.replace("\uFEFF", "").replaceAll("\\r\\n?", "\n").trim();
  }

  private static StructureDefinition loadFromXmlFile(String filePath) throws IOException {
      XmlParser parser = new XmlParser();
      try (InputStream is = ManagedFileAccess.inStream(filePath)) {
        Resource resource = parser.parse(is);
          if (resource instanceof StructureDefinition) {
              return (StructureDefinition) resource;
          } else if (resource instanceof Bundle) {
              Bundle bundle = (Bundle) resource;
              for (Bundle.BundleEntryComponent entry : bundle.getEntry()) {
                  if (entry.hasResource() && entry.getResource() instanceof StructureDefinition) {
                      return (StructureDefinition) entry.getResource();
                  }
              }
          }
          throw new IllegalArgumentException("File does not contain a StructureDefinition: " + filePath);
      }
  }

  private void generateShexFromProfileDirectory(String profileDirectoryPath, String fhirVersion) throws FHIRException, IOException, UcumException {
      // Read and parse all the StructureDefinition resources from the specified directory
      SimpleWorkerContext testContext = TestingUtilities.getWorkerContext(fhirVersion);
      testContext.loadFromFolder(profileDirectoryPath);

      Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fhir.shex");
      generateCompleteModel(testContext, outPath);
  }

  private void generateCompleteModel(IWorkerContext workerContext, Path outPath) throws IOException {
    // Context should already be loaded with StructureDefinitions

    ShExGenerator shgen = new ShExGenerator(workerContext,
      new ShExGeneratorConfig(false, false, true, false, false, ShExGeneratorBase.ConstraintTranslationPolicy.ALL));

    List<StructureDefinition> list = getCompleteModelStructures(workerContext);
    System.out.println("Generating Complete FHIR ShEx to " + outPath.toString());
    FileUtilities.stringToFile(shgen.generate(ShExGeneratorBase.HTMLLinkPolicy.NONE, list), outPath.toString());
  }

  private List<StructureDefinition> getCompleteModelStructures(IWorkerContext workerContext) {
    List<StructureDefinition> list = new ArrayList<StructureDefinition>();
    for (StructureDefinition sd : new ContextUtilities(workerContext).allStructures()) {
      if (sd.getKind() == StructureDefinition.StructureDefinitionKind.LOGICAL)
        // Skip logical models
        continue;
      // Include <Base> which has no derivation
      if (sd.getDerivation() == null || sd.getDerivation() == TypeDerivationRule.SPECIALIZATION)
        list.add(sd);
    }
    return list;
  }

  private IWorkerContext getWorkerContextForProfile(StructureDefinition sd) {
    if (sd.getFhirVersion() == null) {
      return r5WorkerContext;
    }
    return VersionUtilities.isR6Ver(sd.getFhirVersion().toCode()) ? r6WorkerContext : r5WorkerContext;
  }

  final static String SHEX_STRING_A ="""
  #IgnoreMe
  fhirvs:aaa [\"a\" \"b\"]
  """;
  final static String SHEX_STRING_A_IGNORE_START ="""
  #IgnoreMeA
  fhirvs:aaa [\"a\" \"b\"]
  """;

  final static String SHEX_STRING_A_IGNORE_END ="""
  #IgnoreMe
  fhirvs:aaa [\"a\" \"b\" \"c\"]
  """;

  final static String SHEX_STRING_B = """
  #IgnoreMe
  fhirvs:bbb [\"a\" \"b\"]
  """;;
  final static String SHEX_STRING_MISSING = "";

  public static Stream<Arguments> stringsToCompare() {
    return Stream.of(
      Arguments.of(SHEX_STRING_A, null, 3),
      Arguments.of(SHEX_STRING_A, SHEX_STRING_A, 0),
      Arguments.of(SHEX_STRING_A, SHEX_STRING_A_IGNORE_START, 0),
      Arguments.of(SHEX_STRING_A, SHEX_STRING_A_IGNORE_END, 0),
      Arguments.of(SHEX_STRING_A, SHEX_STRING_B, -1),
      Arguments.of(SHEX_STRING_A, SHEX_STRING_MISSING, 3)
      );
  }

  public static Stream<Arguments> patientProfilePaths() {
    return Stream.of(
      Arguments.of(Paths.get("R5", "patient.profile.xml").toString()),
      Arguments.of(Paths.get("R6", "patient.profile.xml").toString())
    );
  }

  @SuppressWarnings("deprecation")
  private void assertCompleteModelR6MatchesDirectGenerator(ShExGenerator generator, ShExGeneratorR6 direct) throws IOException {
    List<StructureDefinition> list = getCompleteModelStructures(r6WorkerContext);

    assertThat(generator.doDatatypes).isEqualTo(direct.doDatatypes);
    assertThat(generator.withComments).isEqualTo(direct.withComments);
    assertThat(generator.completeModel).isEqualTo(direct.completeModel);
    assertThat(generator.debugMode).isEqualTo(direct.debugMode);
    assertThat(generator.processConstraints).isEqualTo(direct.processConstraints);
    assertThat(generator.constraintPolicy.name()).isEqualTo(direct.constraintPolicy.name());

    assertThat(generator.withComments).isFalse();
    assertThat(generator.completeModel).isTrue();

    String delegated = generator.generate(ShExGeneratorBase.HTMLLinkPolicy.NONE, list);
    String expected = direct.generate(ShExGeneratorBase.HTMLLinkPolicy.NONE, new ArrayList<>(list));

    ShExGeneratorR6 defaults = new ShExGeneratorR6(r6WorkerContext);
    String unconfigured = defaults.generate(ShExGeneratorBase.HTMLLinkPolicy.NONE, new ArrayList<>(list));

    assertThat(delegated).isEqualTo(expected);
    assertThat(delegated).contains("start=@<All>");
    assertThat(unconfigured).doesNotContain("start=@<All>");
  }

}