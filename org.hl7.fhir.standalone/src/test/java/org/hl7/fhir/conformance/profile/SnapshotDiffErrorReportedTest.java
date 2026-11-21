package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 * SNAPSHOT_DIFF_ERROR_REPORTED marks a differential element that has had a specific error, so the generic 'No match
 * found' error isn't given for it as well. It's only about one generation of the snapshot: one left on the
 * differential from an earlier generation mustn't stop the error being given again
 */
class SnapshotDiffErrorReportedTest {

  private static IWorkerContext context;

  @BeforeAll
  static void setUp() {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
  }

  @Test
  void markerLeftOnTheDifferentialDoesNotHideNoMatchFound() {
    StructureDefinition sd = profileWithAnElementThatIsNotInPatient();
    ElementDefinition bad = sd.getDifferential().getElementList().get(1);
    bad.setUserData(UserDataNames.SNAPSHOT_DIFF_ERROR_REPORTED, true);

    List<ValidationMessage> messages = generateSnapshot(sd);

    assertTrue(hasNoMatchFound(messages), messages.toString());
    assertFalse(bad.hasUserData(UserDataNames.SNAPSHOT_DIFF_ERROR_REPORTED));
  }

  @Test
  void noMatchFoundIsGivenEachTimeTheSnapshotIsGenerated() {
    StructureDefinition sd = profileWithAnElementThatIsNotInPatient();

    assertTrue(hasNoMatchFound(generateSnapshot(sd)));
    sd.setSnapshot(null);
    assertTrue(hasNoMatchFound(generateSnapshot(sd)));
  }

  private static boolean hasNoMatchFound(List<ValidationMessage> messages) {
    return messages.stream().anyMatch(m -> m.getMessage().startsWith("No match found for Patient.notAnElement"));
  }

  private static List<ValidationMessage> generateSnapshot(StructureDefinition sd) {
    List<ValidationMessage> messages = new ArrayList<>();
    ProfileUtilities pu = new ProfileUtilities(context, messages, null);
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    pu.generateSnapshot(base, sd, sd.getUrl(), "http://example.org", sd.getName());
    return messages;
  }

  private static StructureDefinition profileWithAnElementThatIsNotInPatient() {
    StructureDefinition sd = new StructureDefinition();
    sd.setId("DiffErrorReported");
    sd.setUrl("http://example.org/StructureDefinition/DiffErrorReported");
    sd.setName("DiffErrorReported");
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setType("Patient");
    sd.setKind(StructureDefinitionKind.RESOURCE);
    sd.setAbstract(false);
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Patient");
    sd.getDifferential().addElement().setPath("Patient").setId("Patient");
    sd.getDifferential().addElement().setPath("Patient.notAnElement").setMin(1).setId("Patient.notAnElement");
    return sd;
  }
}
