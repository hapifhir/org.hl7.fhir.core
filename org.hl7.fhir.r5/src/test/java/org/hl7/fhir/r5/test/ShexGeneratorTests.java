package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import es.weso.shex.Schema;
import es.weso.shexsjena.ShExsJenaValidator;
import es.weso.shexsjena.ShExsJenaValidatorBuilder;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.conformance.ShExGenerator.HTMLLinkPolicy;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hl7.fhir.r5.test.ShexGeneratorTestUtils.printList;

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
    TextFile.stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());

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

  @Ignore
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

  @Ignore
  public void doTestAllBatchMode() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);

    processSDList(
      ShexGeneratorTestUtils.RESOURCE_CATEGORY.ALL, // Processing All kinds of Structure Definitions
      sds, // List of Structure Definitions
      false,  //Process all extensions
      // Process all types of constraints, do not skip
      ShExGenerator.ConstraintTranslationPolicy.ALL,
      // BatchMode - All Shex Schemas in one single file
      true,
      // process constraints or not
      true
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
        doTestSingleSD(name, resDef.kind, resDef.url, useSelectedExtensions, policy, true, true, false, processConstraints);
      });
    } else {
      doTestBatchSD(sds, useSelectedExtensions, policy, true, true, false, processConstraints);
    }

    System.out.println("************************ END PROCESSING ******************************");

    System.out.println("************************************************************************");
    List<String> skipped = this.shexGenerator.getExcludedStructureDefinitionUrls();
    System.out.println("Total Items processed: " + sds.size());
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
            ShExsJenaValidator validator =ShExsJenaValidatorBuilder.fromStringSync(schema, "ShexC");
            Schema sch = validator.schema();

            Assert.assertNotNull(sch);

            System.out.println("VALIDATION PASSED for ShEx Schema " + sd.getName() + " (Kind:" + cat + ")");
          } catch (Exception e) {
            System.out.println("VALIDATION FAILED for ShEx Schema " + sd.getName() + " (Kind:" + cat + ")");
            e.printStackTrace();
          }
        }
        TextFile.stringToFile(schema, outPath.toString());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
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
            ShExsJenaValidator validator = ShExsJenaValidatorBuilder.fromStringSync(schema, "ShexC");
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