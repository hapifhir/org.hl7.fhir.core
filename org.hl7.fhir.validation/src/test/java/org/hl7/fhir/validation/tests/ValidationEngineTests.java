package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.CacheVerificationLogger;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationEngineTests {

  private static final String DEF_TX = FhirSettings.getTxFhirDevelopment();
  //private static final String DEF_TX = FhirSettings.getTxFhirLocal();

  public static boolean inbuild;

  @Test
  public void test401Xml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentXml: Validate patient-example.xml in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient-example.xml"), null);
    Assertions.assertTrue(checkOutcomes("test401Xml", op, "[] null information/informational: All OK"));
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
    Assertions.assertTrue(checkOutcomes("test401Json", op, "[] null information/informational: All OK"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
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
    Assertions.assertTrue(checkOutcomes("test430Xml", op, "[] null information/informational: All OK"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void test430Json() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentJson: Validate patient-example.json in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", DEF_TX, FhirPublication.R4, "4.3.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    Assertions.assertTrue(checkOutcomes("test430Json", op, "[] null information/informational: All OK"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
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
    Assertions.assertTrue(checkOutcomes("test140", op, "Patient.contact[0].name.family[0].extension[0].value.ofType(code) null error/code-invalid: The value provided ('VV') was not found in the value set 'EntityNamePartQualifier' (http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0), and a code is required from this value set  (error message = The System URI could not be determined for the code 'VV' in the ValueSet 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0'; The provided code '#VV' was not found in the value set 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.4.0')"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void test102() throws Exception {
    if (inbuild) {
      Assertions.assertTrue(true);
      return;
    }
    if (!org.hl7.fhir.validation.tests.utilities.TestUtilities.silent)
      System.out.println("Test102: Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, FhirPublication.DSTU2, "1.0.2");
    ve.setNoInvariantChecks(true);
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient102.xml"), null);
    Assertions.assertTrue(checkOutcomes("test102", op, 
        "Patient.contact[0].name.family[0].extension[0].value.ofType(code) null error/code-invalid: The value provided ('VV') was not found in the value set 'EntityNamePartQualifier' (http://hl7.org/fhir/ValueSet/name-part-qualifier|1.0.2), and a code is required from this value set  (error message = The System URI could not be determined for the code 'VV' in the ValueSet 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.0.2'; The provided code '#VV' was not found in the value set 'http://hl7.org/fhir/ValueSet/name-part-qualifier|1.0.2')"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void testObs102() throws Exception {
    if (inbuild) {
      Assertions.assertTrue(true);
      return;
    }
    if (!TestUtilities.silent)
      System.out.println("TestObs102: Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, FhirPublication.DSTU2, "1.0.2");
    ve.setNoInvariantChecks(true);
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "observation102.json"), null);
    Assertions.assertTrue(checkOutcomes("testObs102", op, 
        "Observation.text.div null error/invalid: Wrong namespace on the XHTML ('null', should be 'http://www.w3.org/1999/xhtml')\n"+
        "Observation.category null information/business-rule: Reference to experimental CodeSystem http://hl7.org/fhir/observation-category\n"+
        "Observation.code.coding[2].system null information/not-found: A definition for CodeSystem 'http://acme.org/devices/clinical-codes' could not be found, so the code cannot be validated\n"+
        "Observation null warning/invalid: Best Practice Recommendation: In general, all observations should have a performer\n"+
        "Observation null warning/invalid: Best Practice Recommendation: In general, all observations should have an effective[x] ()"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }


  @Test
  public void test301() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test301: Validate observation301.xml against Core");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, FhirPublication.STU3, "3.0.2");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "observation301.xml"), null);
    Assertions.assertTrue(checkOutcomes("test301", op,
        "Observation.code.coding[3].system null information/not-found: A definition for CodeSystem 'http://acme.org/devices/clinical-codes' could not be found, so the code cannot be validated\n"+
        "Observation null warning/invalid: Best Practice Recommendation: In general, all observations should have a performer"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
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
    Assertions.assertTrue(checkOutcomes("test301USCore", op, "Patient.name[1] null error/structure: Patient.name.family: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|1.0.1)"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
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
      "Observation null information/informational: Validate Observation against the Body weight profile (http://hl7.org/fhir/StructureDefinition/bodyweight) which is required by the FHIR specification because the LOINC code 29463-7 was found\n"+
      "Observation.code.coding[0].system null information/not-found: A definition for CodeSystem 'http://loinc.org' could not be found, so the code cannot be validated\n"+
      "Observation.value.ofType(Quantity) null warning/business-rule: Unable to validate code 'kg' in system 'http://unitsofmeasure.org' because the validator is running without terminology services\n"+
      "Observation.value.ofType(Quantity).code null warning/informational: Unable to validate code without using server because: Resolved system http://unitsofmeasure.org (v3.0.1), but the definition doesn't include any codes, so the code has not been validated\n"+
      "Observation.code null warning/code-invalid: None of the codings provided are in the value set 'Vital Signs' (http://hl7.org/fhir/ValueSet/observation-vitalsignresult|4.0.1), and a coding should come from this value set unless it has no suitable code (note that the validator cannot judge what is suitable) (codes = http://loinc.org#29463-7)\n"+
      "Observation null warning/invalid: Best Practice Recommendation: In general, all observations should have a performer\n"+
      "Observation.code null warning/not-found: Unable to check whether the code is in the value set 'http://hl7.org/fhir/ValueSet/observation-vitalsignresult|4.0.1' because the code system http://loinc.org was not found\n"+
      "Observation null warning/invariant: Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)"));
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }


  public static void execute() throws Exception {
    ValidationEngineTests self = new ValidationEngineTests();
    self.test401Xml();
    self.test401Json();
    self.test102();
    self.test140();
    self.test301USCore();
    System.out.println("Finished");
  }

}