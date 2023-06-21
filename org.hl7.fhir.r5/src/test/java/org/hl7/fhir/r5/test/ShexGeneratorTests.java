package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// import es.weso.shex.Schema;
// import es.weso.shex.validator.ShExsValidator;
// import es.weso.shex.validator.ShExsValidatorBuilder;
// import fansi.Str;
// import net.sf.saxon.trans.SymbolicName;
// import org.apache.commons.lang3.StringUtils;
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
//    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
//    if (sd == null) {
//      throw new FHIRException("StructuredDefinition for " + name + "was null");
//    }
//    Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
//    FileUtilities. OR TextFile. stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());

    // For Testing Schema Processing and Constraint Mapping related Development
    // If you un-comment the following lines, please comment all other lines in this method.
    // Test with processing constraints flag
    // ----------------- Uncomment following to testing/Debugging -----
        boolean processConstraints = true;
        this.doTestSingleSD(name.toLowerCase(), cat, name,
          false, ShExGenerator.ConstraintTranslationPolicy.ALL,
          true, true, true, processConstraints);
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
  public void testCanonical() throws FHIRException, IOException, UcumException {
    doTest("canonical", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
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
  public void testbodyheight() throws FHIRException, IOException, UcumException {
    doTest("bodyheight", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testQuestionnaireResponse() throws FHIRException, IOException, UcumException {
    doTest("QuestionnaireResponse", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
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

  @Test
  public void testFiveWs() throws FHIRException, IOException, UcumException {
    doTest("FiveWs", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void testxhtml() throws FHIRException, IOException, UcumException {
    doTest("xhtml", ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION);
  }

  @Test
  public void doTestAllSingleSDMode() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.ALL, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process all extensions
      // Process all types of constraints, do not skip
      ShExGenerator.ConstraintTranslationPolicy.ALL,
      // BatchMode - All Shex Schemas in one single file
      false,
      // process constraints or not
      false
    );
  }

  @Test
  public void doTestAllBatchMode() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process all extensions
      // Process all types of constraints, do not skip
      ShExGenerator.ConstraintTranslationPolicy.ALL,
      // BatchMode - All Shex Schemas in one single file
      true,
      // process constraints or not
      false
    );
  }

  @Ignore
  public void doTestGenericExtensionsOnlyPolicy() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.ALL, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process all extensions
      ShExGenerator.ConstraintTranslationPolicy.GENERIC_ONLY,
      // Process generic constraints only, ignore constraints of type 'context of use'
      false,
      // process constraints or not
      true
    );

  }

  @Ignore
  public void doTestContextOfUseExtensionsOnlyPolicy() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.ALL, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process all extensions
      ShExGenerator.ConstraintTranslationPolicy.CONTEXT_OF_USE_ONLY,
      // Process constraints only where context of use found, skip otherwise
      false,
      // process constraints or not
      true
    );
  }

  @Ignore
  public void doTestSelectedExtensions() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.ALL, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      true,  //Process only given/selected extensions, ignore other extensions
      ShExGenerator.ConstraintTranslationPolicy.ALL, // Process all type of constraints
      false,
      // process constraints or not
      true
    );
  }

  @Ignore
  public void testStructureDefinitionsOnly() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.STRUCTURE_DEFINITION, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process only given/selected extensions, ignore other extensions
      ShExGenerator.ConstraintTranslationPolicy.ALL, // Process all type of constraints
      false,
      // process constraints or not
      true
    );
  }

  @Ignore
  public void testExtensionsOnly() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.EXTENSION, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process only given/selected extensions, ignore other extensions
      ShExGenerator.ConstraintTranslationPolicy.ALL, // Process all type of constraints
      false,
      // process constraints or not
      true
    );
  }

  @Ignore
  public void testLogicalNamesOnly() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.LOGICAL_NAME, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process only given/selected extensions, ignore other extensions
      ShExGenerator.ConstraintTranslationPolicy.ALL, // Process all type of constraints
      false,
      // process constraints or not
      true
    );
  }

  @Ignore
  public void testProfilesOnly() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);
    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.PROFILE, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process only given/selected extensions, ignore other extensions
      ShExGenerator.ConstraintTranslationPolicy.ALL, // Process all type of constraints
      false,
      // process constraints or not
      true
    );
  }

  private void processSDList(ShexGeneratorTestUtils.RESOURCE_CATEGORY cat,
                             List<StructureDefinition> sds,
                             boolean useSelectedExtensions,
                             ShExGenerator.ConstraintTranslationPolicy policy,
                             boolean batchMode, boolean processConstraints) {
    if ((sds == null) || (sds.isEmpty())) {
      throw new FHIRException("No StructuredDefinition found!");
    }

    ShexGeneratorTestUtils shexTestUtils = new ShexGeneratorTestUtils();
    List<ShexGeneratorTestUtils.resDef> sdDefs = shexTestUtils.getSDs(sds, cat);

    printList(cat.toString(), sdDefs);
    System.out.println("************************************************************************");
    System.out.println("Processing " + cat);
    System.out.println("************************************************************************");

    if (!batchMode) {
      sdDefs.forEach((ShexGeneratorTestUtils.resDef resDef) -> {
        String name = resDef.url;
        if (resDef.url.indexOf("/") != -1) {
          String els[] = resDef.url.split("/");
          name = els[els.length - 1];
        }
        System.out.println("******************** " + resDef + " *********************");
        doTestSingleSD(name, resDef.kind, resDef.url, useSelectedExtensions, policy, true, true, true, processConstraints);
      });
    } else {
      doTestBatchSD(sds, useSelectedExtensions, policy, true, true, false, processConstraints);
    }

    System.out.println("************************ END PROCESSING ******************************");

    System.out.println("************************************************************************");
    List<String> skipped = this.shexGenerator.getExcludedStructureDefinitionUrls();
    System.out.println("Total Items processed: " + sdDefs.size());
    System.out.println("************************************************************************");
  }

  private void doTestSingleSD(String shortName, ShexGeneratorTestUtils.RESOURCE_CATEGORY cat,
                              String name, boolean useSelectedExtensions,
                              ShExGenerator.ConstraintTranslationPolicy policy,
                              boolean debugMode, boolean validateShEx,
                              boolean excludeMetaSDs, boolean processConstraints) {
    IWorkerContext ctx = TestingUtilities.getSharedWorkerContext();
    StructureDefinition sd = ctx.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "(Kind:" + cat + ") was null");
    }
    //Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas", shortName + ".shex");
    Path auxPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas/aux.shex");


    try {
      this.shexGenerator = new ShExGenerator(ctx);

      this.shexGenerator.debugMode = debugMode;
      this.shexGenerator.processConstraints = processConstraints;
      this.shexGenerator.constraintPolicy = policy;

      if (excludeMetaSDs) {
        // ShEx Generator skips resources which are at Meta level of FHIR Resource definitions
        this.shexGenerator.setExcludedStructureDefinitionUrls(
          ShexGeneratorTestUtils.getMetaStructureDefinitionsToSkip());
      }
      else
        this.shexGenerator.setExcludedStructureDefinitionUrls(null);

      // when ShEx translates only selected resource extensions
      if (useSelectedExtensions) {
        List<StructureDefinition> selExtns = new ArrayList<StructureDefinition>();
        for (String eUrl : ShexGeneratorTestUtils.getSelectedExtensions()) {
          StructureDefinition esd = ctx.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(eUrl, null));
          if (esd != null)
            selExtns.add(esd);
        }
        this.shexGenerator.setSelectedExtension(selExtns);
      }

      String schema = this.shexGenerator.generate(HTMLLinkPolicy.NONE, sd);
      if (!schema.isEmpty()) {

        if (validateShEx) {
          try {
            ShExsValidator validator = ShExsValidatorBuilder.fromStringSync(schema, "ShexC");
            Schema sch = validator.schema();

            Assert.assertNotNull(sch);

            System.out.println("VALIDATION PASSED for ShEx Schema " + sd.getName() + " (Kind:" + cat + ")");
          } catch (Exception e) {
            System.out.println("VALIDATION FAILED for ShEx Schema " + sd.getName() + " (Kind:" + cat + ")");
            e.printStackTrace();
          }
        }
        File auxFile = auxPath.toFile();
        auxFile.createNewFile();
        String auxContent = TextFile.fileToString(auxFile);
        List<String> importsInAux = substringBetweenMarkers(auxContent, "#imported_begin\nIMPORT <", ">\n#imported_end");
        List<String> oomInAux = substringBetweenMarkers(auxContent, "#oneOrMore_begin", "#oneOrMore_end");
        List<String> vsInAux = substringBetweenMarkers(auxContent,"#value_set_begins", "#value_set_ends");

        List<String> importsInSchema = substringBetweenMarkers(schema, "#imported_begin\nIMPORT <", ">\n#imported_end");
        List<String> oomInSchema = substringBetweenMarkers(schema, "#oneOrMore_begin", "#oneOrMore_end");
        List<String> vsInSchema = substringBetweenMarkers(schema,"#value_set_begins", "#value_set_ends");

        // Add this so that aux.shex can have it.
        importsInSchema.add("#imported_begin\nIMPORT <" + shortName + ".shex>\n#imported_end");

        schema = schema.replaceAll("(?s)#oneOrMore_begin.*?#oneOrMore_end", "");
        schema = schema.replaceAll("(?s)#value_set_begins.*?#value_set_ends", "");
//        if (outPath.toString().contains("http"))
//        {
//          System.out.println("Filename may not be valid" + outPath.toString());
//        }
        TextFile.stringToFile(schema, outPath.toString());
        TextFile.stringToFile("PREFIX fhir: <http://hl7.org/fhir/> \n" +
        "PREFIX fhirvs: <http://hl7.org/fhir/ValueSet/> \n" +
        "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
        addItems(importsInAux, importsInSchema, true) + addItems(oomInAux, oomInSchema, false) + addItems(vsInAux, vsInSchema, false), auxPath.toString());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String addItems(List<String> list1, List<String> list2, boolean avoidImports)
  {
      String returnString = "";
      if ((list1 != null) && (list2 != null)){
        for (String x : list2){

          if ((avoidImports) && x.contains("xhtml")){
            System.out.println("Checking ..." + x);
          }

          if ((avoidImports)&&(x.contains("aux.shex") || x.contains("HealthCareService") || x.contains("rendering-xhtml"))){
            if ((avoidImports) && x.contains("xhtml")){
              System.out.println("skipped ..." + x);
            }
              continue;
          }

          if (!list1.contains(x.trim())) {
            list1.add(x);
            if ((avoidImports) && x.contains("xhtml")){
              System.out.println("Added ..." + x);
            }
          }
        }
      }

      return StringUtils.join(list1, "\n");
  }
  private List<String>  substringBetweenMarkers(String str, String pattern1, String pattern2) {
    String regexString = pattern1 + "[\\s\\S]*?" + pattern2;
    Pattern pattern = Pattern.compile(regexString);
    // text contains the full text that you want to extract data
    Matcher matcher = pattern.matcher(str);

    List<String> toReturn = new ArrayList<String>();
    while (matcher.find()) {
      String textInBetween = matcher.group();
      if (!toReturn.contains(textInBetween))
        toReturn.add(textInBetween.trim());
    }

    return toReturn;
  }

  private void doTestBatchSD(List<StructureDefinition> sds, boolean useSelectedExtensions,
                             ShExGenerator.ConstraintTranslationPolicy policy, boolean debugMode,
                             boolean validateShEx, boolean excludeMetaSDs, boolean processConstraints) {
    IWorkerContext ctx = TestingUtilities.getSharedWorkerContext();
    //Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas", "ShEx.shex");
    try {
      this.shexGenerator = new ShExGenerator(ctx);

      this.shexGenerator.debugMode = debugMode;
      this.shexGenerator.processConstraints = processConstraints;
      this.shexGenerator.constraintPolicy = policy;

      if (excludeMetaSDs) {
        // ShEx Generator skips resources which are at Meta level of FHIR Resource definitions
        this.shexGenerator.setExcludedStructureDefinitionUrls(
          ShexGeneratorTestUtils.getMetaStructureDefinitionsToSkip());
      }
      else
        this.shexGenerator.setExcludedStructureDefinitionUrls(null);

      // when ShEx translates only selected resource extensions
      if (useSelectedExtensions) {
        List<StructureDefinition> selExtns = new ArrayList<StructureDefinition>();
        for (String eUrl : ShexGeneratorTestUtils.getSelectedExtensions()) {
          StructureDefinition esd = ctx.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(eUrl, null));
          if (esd != null)
            selExtns.add(esd);
        }
        this.shexGenerator.setSelectedExtension(selExtns);
      }

      String schema = this.shexGenerator.generate(HTMLLinkPolicy.NONE, sds);
      if (!schema.isEmpty()) {
        if (validateShEx) {
          try {
            ShExsValidator validator = ShExsValidatorBuilder.fromStringSync(schema, "ShexC");
            Schema sch = validator.schema();

            Assert.assertNotNull(sch);
            System.out.println("VALIDATION PASSED for ShEx Schema ALL SHEX STRUCTURES");
          } catch (Exception e) {
            System.out.println("VALIDATION FAILED for ShEx Schema ALL SHEX STRUCTURES");
            e.printStackTrace();
          }
        }
        TextFile.stringToFile(schema, outPath.toString());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
