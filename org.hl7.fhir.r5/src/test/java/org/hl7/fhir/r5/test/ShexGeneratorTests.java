package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.conformance.ShExGenerator.HTMLLinkPolicy;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ShexGeneratorTests {
  public ShExGenerator shexGenerator;

  @BeforeAll
  public static void setup() {
  }

  private void doTest(String name, ShexGeneratorTestUtils.RESOURCE_CATEGORY cat) throws FileNotFoundException, IOException, FHIRException, UcumException {
    // ------- Comment following for debugging/testing
    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    FileUtilities.stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());

    // For Testing Schema Processing and Constraint Mapping related Development
    // If you un-comment the following lines, please comment all other lines in this method.
    // Test with processing constraints flag
    // ----------------- Uncomment following to testing/Debugging -----
    //    boolean processConstraints = false;
    //    this.doTestSingleSD(name.toLowerCase(), cat, name,
    //      false, ShExGenerator.ConstraintTranslationPolicy.ALL,
    //      true, true, false, processConstraints);
  }

  @Test
  public void testCompleteModel() throws FHIRException, IOException, UcumException {
      var workerContext = TestingUtilities.getSharedWorkerContext();
      ShExGenerator shgen = new ShExGenerator(workerContext);
      shgen.completeModel = true;
      shgen.withComments = false;
      Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fhir.shex");
      List<StructureDefinition> list = new ArrayList<StructureDefinition>();
      for (StructureDefinition sd : new ContextUtilities(workerContext).allStructures()) {
        if (sd.getKind() == StructureDefinition.StructureDefinitionKind.LOGICAL)
          // Skip logical models
          continue;
        // Include <Base> which has no derivation
        if (sd.getDerivation() == null || sd.getDerivation() == TypeDerivationRule.SPECIALIZATION)
          list.add(sd);
      }
      System.out.println("Generating Complete FHIR ShEx to " + outPath.toString());
      FileUtilities.stringToFile(shgen.generate(HTMLLinkPolicy.NONE, list), outPath.toString());
  }

  @Test
  public void testId() throws FHIRException, IOException, UcumException {
    doTest("id", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testUri() throws FHIRException, IOException, UcumException {
    doTest("uri", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testPatient() throws FHIRException, IOException, UcumException {
    doTest("Patient", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testObservation() throws FHIRException, IOException, UcumException {
    doTest("Observation", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testRef() throws FHIRException, IOException, UcumException {
    doTest("Reference", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testAccount() throws FHIRException, IOException, UcumException {
    doTest("Account", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testAppointment() throws FHIRException, IOException, UcumException {
    doTest("Appointment", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testBundle() throws FHIRException, IOException, UcumException {
    doTest("Bundle", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testAge() throws FHIRException, IOException, UcumException {
    doTest("Age", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
    doTest("MedicationRequest", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
    doTest("AllergyIntolerance", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testCoding() throws FHIRException, IOException, UcumException {
    doTest("Coding", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testTiming() throws FHIRException, IOException, UcumException {
    doTest("Timing", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testSignature() throws FHIRException, IOException, UcumException {
    doTest("Signature", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testCapabilityStatement() throws FHIRException, IOException, UcumException {
    doTest("CapabilityStatement", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testElement() throws FHIRException, IOException, UcumException {
    doTest("Element", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
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

  @ParameterizedTest(name = "ShExComparator: {0} compareTo {1} = {2}")
  @MethodSource("stringsToCompare")
  public void testShExComparator(String o1, String o2, int aCompareBExpected) {
    ShExGenerator.ShExComparator comparator = new ShExGenerator.ShExComparator();
    int aCompareB = comparator.compare(o1, o2);
    int bCompareA = comparator.compare(o2, o1);
    assertThat(aCompareB).isEqualTo(aCompareBExpected);
    assertThat(aCompareB).isEqualTo(-bCompareA);
  }

}