package org.hl7.fhir.validation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.validation.ValidationEngine;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.Assert;
import org.junit.Test;

public class ValidationEngineTests {

  private static final String DEF_TX = "http://tx.fhir.org";
  private static final String DBG_TX = "http://local.fhir.org:960";
  
  public static boolean inbuild;

  @Test
  public void testCurrentXml() throws Exception {
    if (!TestUtilities.silent) 
      System.out.println("Validate patient-example.xml in Current version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#4.0.0", DEF_TX, null, FhirPublication.R4);
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "patient-example.xml"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    if (!TestUtilities.silent) {
      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    "+iss.getDetails().getText());
      }
    }
    Assert.assertTrue(e == 0);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
  }

  @Test
  public void testCurrentJson() throws Exception {
    if (!TestUtilities.silent)
    System.out.println("Validate patient-example.json in Current version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#4.0.0", DEF_TX, null, FhirPublication.R4);
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "patient-example.json"), null);
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 0);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
    if (!TestUtilities.silent)
      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }

  @Test
  public void test140() throws Exception {
    if (inbuild) {
      Assert.assertTrue(true);
      return;
    }
    if (!TestUtilities.silent)
      System.out.println("Validate patient-example.xml in v1.4.0 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#1.4.0", DEF_TX, null, FhirPublication.DSTU2016May);
    ve.setNoInvariantChecks(true);
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "patient140.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    "+iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 1);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
    if (!TestUtilities.silent)
      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }

  @Test
  public void test102() throws Exception {
    if (inbuild) {
      Assert.assertTrue(true);
      return;
    }
    if (!org.hl7.fhir.validation.tests.utilities.TestUtilities.silent)
      System.out.println("Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#1.0.2", DEF_TX, null, FhirPublication.DSTU2);
    ve.setNoInvariantChecks(true);
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "patient102.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    "+iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 1);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
    if (!TestUtilities.silent)
    System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }

  @Test
  public void testObs102() throws Exception {
    if (inbuild) {
      Assert.assertTrue(true);
      return;
    }
    if (!TestUtilities.silent)
      System.out.println("Validate patient-example.xml in v1.0.2 version");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#1.0.2", DEF_TX, null, FhirPublication.DSTU2);
    ve.setNoInvariantChecks(true);
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "observation102.json"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
        System.out.println("    "+iss.getDetails().getText());
      }
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 1);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
    if (!TestUtilities.silent)
    System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }


  @Test
  public void test301() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate observation301.xml against Core");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#3.0.1", DEF_TX, null, FhirPublication.STU3);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "observation301.xml"), null);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - "+issue.getDetails().getText());
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 0);
    if (!TestUtilities.silent)
      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }

  @Test
  public void test301USCore() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("Validate patient300.xml against US-Core");
    ValidationEngine ve = new ValidationEngine("hl7.fhir.core#3.0.1", DEF_TX, null, FhirPublication.STU3);
    if (!TestUtilities.silent)
      System.out.println("  .. load USCore");
    ve.loadIg("hl7.fhir.us.core#1.0.1");
    List<String> profiles = new ArrayList<>();
    profiles.add("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    OperationOutcome op = ve.validate(TestUtilities.resourceNameToFile("validation-examples", "patient301.xml"), profiles);
    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - "+issue.getDetails().getText());
    int e = errors(op);
    int w = warnings(op);
    int h = hints(op);
    Assert.assertTrue(e == 1);
    Assert.assertTrue(w == 0);
    Assert.assertTrue(h == 0);
    if (!TestUtilities.silent)
      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
  }

//  @Test
//  public void testTransform() throws Exception {
//    if (!TestUtilities.silent)
//      System.out.println("Transform CCDA");
//    if (!TestUtilities.silent)
//      System.out.println("  .. load FHIR from " +Utilities.path(TestUtilities.home(),  "publish"));
//    ValidationEngine ve = new ValidationEngine(Utilities.path(TestUtilities.home(),  "publish"), DEF_TX, null, FhirVersion.R4);
//    if (!TestUtilities.silent)
//      System.out.println("  .. load CCDA from " +Utilities.path(TestUtilities.home(),  "guides\\ccda2\\mapping\\logical"));
//    ve.loadIg(Utilities.path(TestUtilities.home(),  "guides\\ccda2\\mapping\\logical"));
//    if (!TestUtilities.silent)
//      System.out.println("  .. load Maps from " +Utilities.path(TestUtilities.home(),  "guides\\ccda2\\mapping\\map"));
//    ve.loadIg(Utilities.path(TestUtilities.home(),  "guides\\ccda2\\mapping\\map"));
//    Resource r = ve.transform(Utilities.path(TestUtilities.home(),  "guides\\ccda2\\mapping\\example\\ccd.xml"), "http://hl7.org/fhir/StructureMap/cda");
//    if (!TestUtilities.silent)
//      System.out.println("  .. done");
//  }

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
//    self.testTransform();
    System.out.println("Finished");
  }

}
