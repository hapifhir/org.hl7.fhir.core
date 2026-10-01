package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hl7.fhir.model.core.Questionnaire;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.utilities.QuestionnaireBuilder;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * R6 copy of the r5 test of the same name: the answer constraint QuestionnaireBuilder derives
 * from a binding follows the binding's strength - required gives {@code optionsOnly}, anything
 * weaker gives {@code optionsOrType}.
 */
class QuestionnaireBuilderTests {

  private static Questionnaire buildFor(String resourceType) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    StructureDefinition sd = context.fetchTypeDefinition(resourceType);
    assertNotNull(sd, resourceType + " profile should be resolvable");
    QuestionnaireBuilder builder = new QuestionnaireBuilder(context, null);
    builder.setProfile(sd);
    builder.build();
    return builder.getQuestionnaire();
  }

  /** Depth-first search for the item with the given linkId. */
  private static QuestionnaireItemComponent find(List<QuestionnaireItemComponent> items, String linkId) {
    for (QuestionnaireItemComponent item : items) {
      if (linkId.equals(item.getLinkId())) {
        return item;
      }
      if (item.hasItem()) {
        QuestionnaireItemComponent hit = find(item.getItemList(), linkId);
        if (hit != null) {
          return hit;
        }
      }
    }
    return null;
  }

  private static QuestionnaireAnswerConstraint constraintOf(Questionnaire q, String linkId) {
    QuestionnaireItemComponent item = find(q.getItemList(), linkId);
    assertNotNull(item, "no questionnaire item for " + linkId);
    return item.getAnswerConstraint();
  }

  @Test
  @DisplayName("A required binding yields optionsOnly")
  void requiredBinding_optionsOnly() throws Exception {
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSONLY,
      constraintOf(buildFor("Observation"), "Observation.status.value"));
  }

  @Test
  @DisplayName("A non-required binding yields optionsOrType")
  void nonRequiredBinding_optionsOrType() throws Exception {
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSORTYPE,
      constraintOf(buildFor("Observation"), "Observation.code.coding"));
  }

  @Test
  @DisplayName("Required, preferred and example strengths, on CodeableConcept elements of one resource")
  void threeStrengths_oneResource() throws Exception {
    Questionnaire q = buildFor("AllergyIntolerance");
    // clinicalStatus: required; type: preferred; code: example. For a CodeableConcept the
    // constraint sits on the generated "coding" item.
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSONLY,
      constraintOf(q, "AllergyIntolerance.clinicalStatus.coding"));
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSORTYPE,
      constraintOf(q, "AllergyIntolerance.type.coding"));
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSORTYPE,
      constraintOf(q, "AllergyIntolerance.code.coding"));
  }
}
