package org.hl7.fhir.validation.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
// import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
// import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MultipleIgVersionTests {
  private static final String DEF_TX = "http://tx.fhir.org";
  private static ValidationEngine ve;

  @Test
  public void testV1ResourceAgainstV1Profile() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestV1ResourceAgainstV1Profile: v0.1.0 resource is valid against the v0.1.0 profile");

    int e = validateVersionedResource(ve, "0.1.0", "0.1.0");

    Assertions.assertEquals(0, e, "Version 0.1.0 resource failed validation against version 0.1.0 profile");

    if (!TestUtilities.silent)
      System.out.println("  .. done.");
  }

  @Test
  public void testV2ResourceAgainstV2Profile() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestV1ResourceAgainstV1Profile: v0.2.0 resource is valid against the v0.2.0 profile");

    int e = validateVersionedResource(ve, "0.2.0", "0.2.0");

    Assertions.assertEquals(0, e, "Version 0.2.0 resource failed validation against version 0.2.0 profile");

    if (!TestUtilities.silent)
      System.out.println("  .. done.");
  }

  @Test
  public void testV1ResourceAgainstV2Profile() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestV1ResourceAgainstV2Profile: v0.1.0 resource is invalid against the v0.2.0 profile");

    int e = validateVersionedResource(ve, "0.1.0", "0.2.0");

    Assertions.assertNotEquals(0, e, "Version 0.1.0 sucessfully validated against version 0.2.0 profile");
    /*
      - active field is required but not present
      - extension doesn't match closed slice
      - extension has the wrong type
      - coding.code not allowed
      - coding.system not allowed
     */
    Assertions.assertEquals(5, e, "Expected 5 validation errors when validating version 0.1.0 resource against version 0.2.0 profile, but found " + e);

    if (!TestUtilities.silent)
      System.out.println("  .. done.");
  }

  @Test
  public void testV2ResourceAgainstV1Profile() throws Exception {
    if (!TestUtilities.silent)
      System.out.println("TestV2ResourceAgainstV1Profile: v0.2.0 resource is invalid against the v0.1.0 profile");

    int e = validateVersionedResource(ve, "0.2.0", "0.1.0");

    Assertions.assertNotEquals(0, e, "Version 0.2.0 sucessfully validated against version 0.1.0 profile");
    /*
      - active field is forbidden but present
      - extension doesn't match closed slice
      - extension has the wrong type
      - CodeableConcept.coding not allowed
    */
    Assertions.assertEquals(4, e, "Expected 4 validation errors when validating version 0.2.0 resource against version 0.1.0 profile, but found " + e);

    if (!TestUtilities.silent)
      System.out.println("  .. done.");
  }

  @BeforeAll
  private static void loadIgs() throws Exception {
    ve = new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, null, FhirPublication.R4, "4.0.1");
    String fixturePath =
      Utilities.path(System.getProperty("user.dir"), "src", "test", "resources", "multi-version-validation");
    String igPath = Utilities.path(fixturePath, "igs");
    File igDir = new File(igPath);
    File[] igFiles = igDir.listFiles((d, name) -> name.endsWith(".tgz"));
    for (File igFile : igFiles) {
      if (!TestUtilities.silent)
        System.out.println("  .. load " + igFile);
      ve.getIgLoader().loadIg(ve.getIgs(), ve.getBinaries(), igFile.getAbsolutePath(), true);
    }
  }

  private int validateVersionedResource(ValidationEngine ve, String resourceVersion, String profileVersion) throws Exception {
    String fixturePath =
      Utilities.path(System.getProperty("user.dir"), "src", "test", "resources", "multi-version-validation");
    String resourcesPath = Utilities.path(fixturePath, "resources");
    String resourceFileName = "multi-version-patient-" + resourceVersion + ".json";
    String profileUrl = "http://example.org/validator-versions-test/StructureDefinition/multi-version-test-patient|" + profileVersion;
    FileInputStream resource = new FileInputStream(Utilities.path(resourcesPath, resourceFileName));
    List<String> profiles = new ArrayList<>();
    profiles.add(profileUrl);
    OperationOutcome op = ve.validate(FhirFormat.JSON, resource, profiles);

    if (!TestUtilities.silent)
      for (OperationOutcomeIssueComponent issue : op.getIssue())
        System.out.println("  - " + issue.getDetails().getText());
    return errors(op);
  }

  private int errors(OperationOutcome op) {
    int i = 0;
    for (OperationOutcomeIssueComponent vm : op.getIssue()) {
      if (vm.getSeverity() == IssueSeverity.ERROR || vm.getSeverity() == IssueSeverity.FATAL)
        i++;
    }
    return i;
  }
};
