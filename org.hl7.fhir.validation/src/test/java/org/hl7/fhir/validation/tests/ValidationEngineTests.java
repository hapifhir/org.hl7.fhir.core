package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.CacheVerificationLogger;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.StandAloneValidatorFetcher;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationEngineTests {

  private static final String DEF_TX = FhirSettings.getTxFhirDevelopment();
  //private static final String DEF_TX = FhirSettings.getTxFhirLocal();

  public static boolean inbuild;

  @Test
  @DisplayName("A ValidationEngine copied from another validation engine shouldn't interfere with the original during validations")
  void validateWithParallelCopiedEngine() throws Exception {

    final String INPUT_1 = "patient-duplicate.json";
    final String INPUT_2 = "patient-lang1.json";
    final String INPUT_3 = "patient-id-bad-1.json";

    final String[] ISSUE_CODES_1 = { "invalid" };
    final String[] ISSUE_CODES_2 = {"business-rule"};
    final String[] ISSUE_CODES_3 = {"invalid", "invariant"};

    ValidationEngine originalEngine = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");

    final ValidationEngine[] validationEngines = new ValidationEngine[10];
    validationEngines[0] = originalEngine;

    final OperationOutcome[] outcomes = new OperationOutcome[validationEngines.length];

    for (int i = 1; i < validationEngines.length; i++) {
      validationEngines[i] = new ValidationEngine(originalEngine);
    }

    final String[] testInputs = {
        INPUT_1,
        INPUT_1,
        INPUT_2,
        INPUT_3,
        INPUT_1,
        INPUT_2,
        INPUT_3,
        INPUT_1,
        INPUT_2,
        INPUT_3
    };
    // Pick 3 validation cases
    final String[][] testCodes = {
        ISSUE_CODES_1,
        ISSUE_CODES_1,
        ISSUE_CODES_2,
        ISSUE_CODES_3,
        ISSUE_CODES_1,
        ISSUE_CODES_2,
        ISSUE_CODES_3,
        ISSUE_CODES_1,
        ISSUE_CODES_2,
        ISSUE_CODES_3
    };


    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < validationEngines.length; i++) {
      final int index = i;
      Thread t = new Thread(() -> {
        try {
          final String testInput = testInputs[index];
          outcomes[index] = validationEngines[index].validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator",  testInput), null);
        } catch (Exception e) {
          e.printStackTrace();
          System.err.println("Thread " + index + " failed");
          outcomes[index] = OperationOutcomeUtilities.outcomeFromTextError(e.getMessage());
        }
      });
      t.start();
      threads.add(t);
    }
    threads.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {

      }
    });

    for (int i = 0; i < outcomes.length; i++) {
      assertEquals(testCodes[i].length, outcomes[i].getIssue().size());
      for (int j = 0; j < outcomes[i].getIssue().size(); j++) {
        System.out.print(i + "/" + j+", ");
        assertEquals(testCodes[i][j], outcomes[i].getIssue().get(j).getCode().toCode());
      }
    }
  }

  @Test
  public void test401Xml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentXml: Validate patient-example.xml in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient-example.xml"), null);
    Assertions.assertTrue(checkOutcomes("test401Xml", op, "information/informational @ []: All OK"));
    verifyNoTerminologyRequests(logger);
  }

  /**
   * <p
   * Verify that no terminology requests were made during validation.
   * </p>
   * <p>
   * This test may fail if the terminology caches in src/test/resources/txCache have been cleared.
   * </p>
   * <p>
   * If this is the case, running the test should fail on the first run, and then pass on subsequents runs.
   * </p>
   * <p>
   * Once it passes, the newly generated cache files should be committed to the repository.
   * </p>
   *
   * @param logger A logger that captures terminology requests
   */
  private static void verifyNoTerminologyRequests(CacheVerificationLogger logger) {
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void test401Json() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentJson: Validate patient-example.json in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    Assertions.assertTrue(checkOutcomes("test401Json", op, "information/informational @ []: All OK"));
    verifyNoTerminologyRequests(logger);
  }

  private boolean checkOutcomes(String id, OperationOutcome op, String text) {
    CommaSeparatedStringBuilder lines = new CommaSeparatedStringBuilder("\n");
    for (OperationOutcomeIssueComponent iss : op.getIssue()) {
      lines.append(iss.toString());
    }
    String outcome = lines.toString();
    if (lines.toString().equals(text)) {
      return true;
    } else {
      System.out.println("-- "+id+" -------");
      System.out.println("Expected:");
      System.out.println(text);
      System.out.println("Outcome:");
      System.out.println(outcome);
      return false;
    }
  }

  @Test
  public void test430Xml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentXml: Validate patient-example.xml in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", DEF_TX, FhirPublication.R4, "4.3.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient-example.xml"), null);
    Assertions.assertTrue(checkOutcomes("test430Xml", op, "information/informational @ []: All OK"));
    verifyNoTerminologyRequests(logger);
  }

  @Test
  public void test430Json() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentJson: Validate patient-example.json in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", DEF_TX, FhirPublication.R4, "4.3.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    Assertions.assertTrue(checkOutcomes("test430Json", op, "information/informational @ []: All OK"));
    verifyNoTerminologyRequests(logger);
  }

  @Test
  public void test140() throws Exception {
    if (inbuild) {
      Assertions.assertTrue(true);
      return;
    }
    if (!TestUtilities.silent)
      System.out.println("Test140: Validate patient-example.xml in v1.4.0 version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r2b.core#1.4.0", DEF_TX, FhirPublication.DSTU2016May, "1.4.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient140.xml"), null);
    Assertions.assertTrue(checkOutcomes("test140", op, "error/not-found @ Patient.contact[0].name.family[0].extension[0].value.ofType(code): The System URI could not be determined for the code 'VV' in the ValueSet 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0'\n"
        + "error/code-invalid @ Patient.contact[0].name.family[0].extension[0].value.ofType(code): The value provided ('VV') was not found in the value set 'EntityNamePartQualifier' (http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0), and a code is required from this value set  (error message = The System URI could not be determined for the code 'VV' in the ValueSet 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0'; The provided code '#VV' was not found in the value set 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0')"));
    verifyNoTerminologyRequests(logger);
  }

  @Test
  public void test301() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test301: Validate observation301.xml against Core");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, FhirPublication.STU3, "3.0.2", new InstanceValidatorParameters().setAllowExampleUrls(true));
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);

    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "observation301.xml"), null);
    Assertions.assertTrue(checkOutcomes("test301", op,
        "warning/not-found @ Observation.code.coding[3].system: A definition for CodeSystem 'http://acme.org/devices/clinical-codes' could not be found, so the code cannot be validated\n"
        + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer"));
    verifyNoTerminologyRequests(logger);
  }

  @Test
  public void test301USCore() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test301USCore: Validate patient300.xml against US-Core");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, FhirPublication.STU3, "3.0.2");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    IgLoader igLoader = new IgLoader(ve.getPcm(), ve.getContext(), ve.getVersion(), true);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    igLoader.loadIg(ve.getIgs(), ve.getBinaries(), "hl7.fhir.us.core#1.0.1", false);
    List<String> profiles = new ArrayList<>();
    profiles.add("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient301.xml"), profiles);
    Assertions.assertTrue(checkOutcomes("test301USCore", op, 
        "error/structure @ Patient.name[1]: Patient.name.family: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|1.0.1)"));
    verifyNoTerminologyRequests(logger);
  }


  @Test
  public void test401USCore() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test401USCore: Validate observation401_ucum.json against US-Core with no terminology server");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", "n/a", FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    IgLoader igLoader = new IgLoader(ve.getPcm(), ve.getContext(), ve.getVersion(), true);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    igLoader.loadIg(ve.getIgs(), ve.getBinaries(), "hl7.fhir.us.core#3.1.1", false);
    List<String> profiles = new ArrayList<>();
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "observation401_ucum.json"), profiles);
    Assertions.assertTrue(checkOutcomes("test401USCore", op, 
      "information/invalid @ Observation.meta.source: The URL value '#iLFSV7OLv0KF8dmQ' might be wrong because it appears to point to an internal target, but there is no matching target\n" +
        "warning/code-invalid @ Observation.code: Error Cannot invoke \"org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.getAddress()\" because \"tc\" is null validating CodeableConcept\n" +
        "warning/business-rule @ Observation.value.ofType(Quantity): Unable to validate code 'kg' in system 'http://unitsofmeasure.org' because the validator is running without terminology services\n" +
        "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n" +
        "information/informational @ Observation: Validate Observation against the Body weight profile (http://hl7.org/fhir/StructureDefinition/bodyweight) which is required by the FHIR specification because the LOINC code 29463-7 was found\n" +
        "information/code-invalid @ Observation.code: Could not confirm that the codes provided are from the extensible value set http://hl7.org/fhir/ValueSet/observation-vitalsignresult|4.0.1 because there is no terminology service\n" +
        "warning/informational @ Observation.value.ofType(Quantity).code: Unable to validate code without using server because: Resolved system http://unitsofmeasure.org (v3.0.1), but the definition doesn't include any codes, so the code has not been validated\n" +
        "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer"));
    verifyNoTerminologyRequests(logger);
  }


  public static void execute() throws Exception {
    ValidationEngineTests self = new ValidationEngineTests();
    self.test401Xml();
    self.test401Json();
    self.test140();
    self.test301USCore();
    System.out.println("Finished");
  }


  @Test
  public void testResolveRelativeFileValid() throws Exception {
    String folder = setupFolder();
    try {
      ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
      ve.setFetcher(fetcher);
      ve.getContext().setLocator(fetcher);
      ve.setPolicyAdvisor(fetcher);
      fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      fetcher.setResolutionContext("file:"+folder);
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
      OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "relative-url-valid.json"), null);
      Assertions.assertTrue(checkOutcomes("testResolveRelativeFileValid", op, 
          "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()"));
    } finally {
      FileUtilities.clearDirectory(folder);
      ManagedFileAccess.file(folder).delete();
    } 
  }

  @Test
  public void testResolveRelativeFileInvalid() throws Exception {
    String folder = setupFolder();
    try {
      ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
      ve.setFetcher(fetcher);
      ve.getContext().setLocator(fetcher);
      ve.setPolicyAdvisor(fetcher);
      fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      fetcher.setResolutionContext("file:"+folder);
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
      OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "relative-url-invalid.json"), null);
      Assertions.assertTrue(checkOutcomes("testResolveRelativeFileInvalid", op, 
          "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()\n"
          + "error/structure @ Observation.subject: Unable to find a profile match for Patient/example-newborn among choices: http://hl7.org/fhir/test/StructureDefinition/PatientRule\n"
          + "information/structure @ Observation.subject: Details for Patient/example-newborn matching against profile http://hl7.org/fhir/test/StructureDefinition/PatientRule|0.1.0"));
    } finally {
      FileUtilities.clearDirectory(folder);
      ManagedFileAccess.file(folder).delete();
    } 
  }

  @Test
  public void testResolveRelativeFileError() throws Exception {
    String folder = setupFolder();
    try {
      ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
      ve.setFetcher(fetcher);
      ve.getContext().setLocator(fetcher);
      ve.setPolicyAdvisor(fetcher);
      fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      fetcher.setResolutionContext("file:"+folder);
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
      OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "relative-url-error.json"), null);
      Assertions.assertTrue(checkOutcomes("testResolveRelativeFileError", op, 
          "error/structure @ Observation.subject: Unable to resolve resource with reference 'patient/example-newborn-x'\n"
          + "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()"));
    } finally {
      FileUtilities.clearDirectory(folder);
      ManagedFileAccess.file(folder).delete();
    } 
  }


  @Test
  public void testResolveAbsoluteValid() throws Exception {
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1", new InstanceValidatorParameters().setShowMessagesFromReferences(true));
    StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
    ve.setFetcher(fetcher);
    ve.getContext().setLocator(fetcher);
    ve.setPolicyAdvisor(fetcher);

    fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
    ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
    ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "absolute-url-valid.json"), null);
    Assertions.assertTrue(checkOutcomes("testResolveAbsoluteValid", op, 
        "information/informational @ Observation.subject.resolve().ofType(Patient).managingOrganization: Fetching 'Organization/1' failed. System details: org.hl7.fhir.exceptions.FHIRException: The URL 'Organization/1' is not known to the FHIR validator, and a resolution context has not been provided as part of the setup / parameters\n"
        + "error/structure @ Observation.subject.resolve().ofType(Patient).managingOrganization: Unable to resolve resource with reference 'Organization/1'\n"
        + "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
        + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
        + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()"));
  }

  @Test
  public void testResolveAbsoluteInvalid() throws Exception {
      ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
      ve.setFetcher(fetcher);
      ve.getContext().setLocator(fetcher);
      ve.setPolicyAdvisor(fetcher);
      fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
      OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "absolute-url-invalid.json"), null);
      Assertions.assertTrue(checkOutcomes("testResolveAbsoluteInvalid", op, 
          "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()\n"
          + "error/structure @ Observation.subject: Unable to find a profile match for https://hl7.org/fhir/R4/patient-example-newborn.json among choices: http://hl7.org/fhir/test/StructureDefinition/PatientRule\n"
          + "information/structure @ Observation.subject: Details for https://hl7.org/fhir/R4/patient-example-newborn.json matching against profile http://hl7.org/fhir/test/StructureDefinition/PatientRule|0.1.0"));
  }

  @Test
  public void testResolveAbsoluteError() throws Exception {
      ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(ve.getPcm(), ve.getContext(), ve);
      ve.setFetcher(fetcher);
      ve.getContext().setLocator(fetcher);
      ve.setPolicyAdvisor(fetcher);
      fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Observation.json")));
      ve.seeResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("validator", "resolution", "StructureDefinition-Patient.json")));
      OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "resolution", "absolute-url-error.json"), null);
      Assertions.assertTrue(checkOutcomes("testResolveAbsoluteError", op, 
          "information/informational @ Observation.subject: Fetching 'http://hl7x.org/fhir/R4/Patient/Patient/example-newborn' failed. System details: java.net.UnknownHostException: hl7x.org\n"
          + "error/structure @ Observation.subject: Unable to resolve resource with reference 'http://hl7x.org/fhir/R4/Patient/Patient/example-newborn'\n"
          + "warning/invariant @ Observation: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have a performer\n"
          + "warning/invalid @ Observation: Best Practice Recommendation: In general, all observations should have an effective[x] ()"));
  }

  private String setupFolder() throws IOException {
    String now = new SimpleDateFormat("yyyymmddhhMMss").format(new Date());
    String folder = Utilities.path("[tmp]", "validator-resolution", now);
    FileUtilities.createDirectory(folder);
    for (String s : Utilities.strings("Organization-first.xml", "Patient-example-newborn.json", "patient-example.json")) {
      FileUtilities.bytesToFile( TestingUtilities.loadTestResourceBytes("validator", "resolution", s), Utilities.path(folder, s));
    }
    return folder;
  }
  
}