package org.hl7.fhir.validation.tests;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.FhirPublication;

import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.CacheVerificationLogger;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationEngineTests {

  private static final String DEF_TX = FhirSettings.getTxFhirDevelopment();
//  private static final String DEF_TX = FhirSettings.getTxFhirLocal();

  public static boolean inbuild;

  @Test
  public void test401Xml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentXml: Validate patient-example.xml in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient-example.xml"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    if (!TestUtilities.silent) {
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    " + iss.getDetails().getText());
      }
    }
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(1, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void test401Json() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentJson: Validate patient-example.json in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, FhirPublication.R4, "4.0.1");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(1, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }

  @Test
  public void test430Xml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentXml: Validate patient-example.xml in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", DEF_TX, FhirPublication.R4, "4.3.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient-example.xml"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    if (!TestUtilities.silent) {
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    " + iss.getDetails().getText());
      }
    }
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(1, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
  }

  @Test
  public void test430Json() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestCurrentJson: Validate patient-example.json in Current version");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", DEF_TX, FhirPublication.R4, "4.3.0");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    if (!TestUtilities.silent) {
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    " + iss.getDetails().getText());
      }
    }
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(1, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
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
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient140.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    " + iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(1, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(0, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
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
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient102.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("  " + iss.getSeverity().toCode() + ": " + iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(1, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(0, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
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
    ve.getContext().getTxClient().setLogger(logger);
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "observation102.json"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    " + iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(1, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(1, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }


  @Test
  public void test301() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test301: Validate observation301.xml against Core");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, FhirPublication.STU3, "3.0.2");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "observation301.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - " + issue.getDetails().getText()+" ("+issue.getSeverity().toCode()+")");
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(0, e);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }

  @Test
  public void test301USCore() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Test301USCore: Validate patient300.xml against US-Core");
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, FhirPublication.STU3, "3.0.2");
    CacheVerificationLogger logger = new CacheVerificationLogger();
    ve.getContext().getTxClient().setLogger(logger);
    IgLoader igLoader = new IgLoader(ve.getPcm(), ve.getContext(), ve.getVersion(), true);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    igLoader.loadIg(ve.getIgs(), ve.getBinaries(), "hl7.fhir.us.core#1.0.1", false);
    List<String> profiles = new ArrayList<>();
    profiles.add("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "patient301.xml"), profiles);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - " + issue.getDetails().getText());
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(1, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(0, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
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
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - " + issue.getDetails().getText());
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(2, w);
    Assertions.assertEquals(0, h);
    assertTrue(logger.verifyHasNoRequests(), "Unexpected request to TX server");
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }

  
  private int errors(OperationOutcome op) {
    int i = 0;
    for (OperationOutcomeIssueComponent vm : op.getIssue()) {
      if (vm.getSeverity() == IssueSeverity.ERROR || vm.getSeverity() == IssueSeverity.FATAL)
        i++;
    }
    return i;
  }

  private int warnings(OperationOutcome op) {
    int i = 0;
    for (OperationOutcomeIssueComponent vm : op.getIssue()) {
      if (vm.getSeverity() == IssueSeverity.WARNING)
        i++;
    }
    return i;
  }

  private int hints(OperationOutcome op) {
    int i = 0;
    for (OperationOutcomeIssueComponent vm : op.getIssue()) {
      if (vm.getSeverity() == IssueSeverity.INFORMATION || vm.getSeverity() == IssueSeverity.SUCCESS)
        i++;
    }
    return i;
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