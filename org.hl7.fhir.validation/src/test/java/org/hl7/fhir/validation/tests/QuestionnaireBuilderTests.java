package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.QuestionnaireBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Covers the answer constraint {@link QuestionnaireBuilder} derives from an element's
 * binding strength.
 *
 * A required binding means the answer must come from the value set, so only the listed
 * options are allowed ({@code optionsOnly}). Any weaker strength - extensible, preferred,
 * example - also permits a value of the element's own type ({@code optionsOrType}).
 */
class QuestionnaireBuilderTests {

  private static IWorkerContext context;

  @BeforeAll
  static void setup() throws Exception {
    ValidationEngine engine = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
    context = engine.getContext();
  }

  private static Questionnaire buildFor(String resourceType) throws Exception {
    StructureDefinition sd = context.fetchResource(StructureDefinition.class,
      "http://hl7.org/fhir/StructureDefinition/" + resourceType);
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
  @DisplayName("Binding strength drives the constraint consistently across a second resource")
  void bindingStrength_secondResource() throws Exception {
    Questionnaire q = buildFor("AllergyIntolerance");
    // type is bound with strength=required; code with strength=example
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSONLY,
      constraintOf(q, "AllergyIntolerance.type.value"));
    assertEquals(QuestionnaireAnswerConstraint.OPTIONSORTYPE,
      constraintOf(q, "AllergyIntolerance.code.coding"));
  }
}
