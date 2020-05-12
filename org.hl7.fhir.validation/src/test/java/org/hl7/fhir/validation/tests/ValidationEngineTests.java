package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidationEngineTests {

  private static final String DEF_TX = "http://tx.fhir.org";
  private static final String DBG_TX = "http://local.fhir.org:960";

  public static boolean inbuild;

  @Test
  public void testCurrentXml() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate patient-example.xml in Current version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, null, FhirPublication.R4, "4.0.1");
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
    Assertions.assertEquals(0, h);
  }

  @Test
  public void testCurrentJson() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate patient-example.json in Current version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, null, FhirPublication.R4, "4.0.1");
    OperationOutcome op = ve.validate(FhirFormat.JSON, TestingUtilities.loadTestResourceStream("validator", "patient-example.json"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(0, e);
    Assertions.assertEquals(0, w);
    Assertions.assertEquals(0, h);
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
      System.out.println("Validate patient-example.xml in v1.4.0 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r2b.core#1.4.0", DEF_TX, null, FhirPublication.DSTU2016May, "1.4.0");
    ve.setNoInvariantChecks(true);
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
      System.out.println("Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, null, FhirPublication.DSTU2, "41.0.2");
    ve.setNoInvariantChecks(true);
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
      System.out.println("Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, null, FhirPublication.DSTU2, "1.0.2");
    ve.setNoInvariantChecks(true);
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
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }


  @Test
  public void test301() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate observation301.xml against Core");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, null, FhirPublication.STU3, "3.0.2");
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    OperationOutcome op = ve.validate(FhirFormat.XML, TestingUtilities.loadTestResourceStream("validator", "observation301.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - " + issue.getDetails().getText());
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assertions.assertEquals(0, e);
    if (!TestUtilities.silent)
      System.out.println("  .. done: " + Integer.toString(e) + " errors, " + Integer.toString(w) + " warnings, " + Integer.toString(h) + " information messages");
  }

  @Test
  public void test301USCore() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate patient300.xml against US-Core");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, null, FhirPublication.STU3, "3.0.2");
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    ve.loadIg("hl7.fhir.us.core#1.0.1", false);
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
      if (vm.getSeverity() == IssueSeverity.INFORMATION)
        i++;
    }
    return i;
  }

  public static void execute() throws Exception {
    ValidationEngineTests self = new ValidationEngineTests();
    self.testCurrentXml();
    self.testCurrentJson();
    self.test102();
    self.test140();
    self.test301USCore();
    System.out.println("Finished");
  }

}