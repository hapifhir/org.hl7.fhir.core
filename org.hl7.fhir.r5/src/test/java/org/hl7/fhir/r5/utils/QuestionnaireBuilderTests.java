package org.hl7.fhir.r5.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The answer constraint QuestionnaireBuilder derives from a binding follows the binding's
 * strength: a required binding means the answer must come from the value set
 * ({@code optionsOnly}); any weaker strength - extensible, preferred, example - also permits
 * a value of the element's own type ({@code optionsOrType}).
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
        QuestionnaireItemComponent hit = find(item.getItem(), linkId);
        if (hit != null) {
          return hit;
        }
      }
    }
    return null;
  }

  private static QuestionnaireAnswerConstraint constraintOf(Questionnaire q, String linkId) {
    QuestionnaireItemComponent item = find(q.getItem(), linkId);
    assertNotNull(item, "no questionnaire item for " + linkId);
    return item.getAnswerConstraint();
  }

  @Test
  @DisplayName("A required binding yields optionsOnly")
  void requiredBinding_optionsOnly() throws Exception {
    // Observation.status is bound to observation-status with strength=required
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSONLY,
      constraintOf(buildFor("Observation"), "Observation.status.value"));
  }

  @Test
  @DisplayName("A non-required binding yields optionsOrType")
  void nonRequiredBinding_optionsOrType() throws Exception {
    // Observation.code is bound to observation-codes with strength=example
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
