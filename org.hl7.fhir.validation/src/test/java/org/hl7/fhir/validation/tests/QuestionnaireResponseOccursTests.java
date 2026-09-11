package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.QuestionnaireResponse;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Test;

/**
 * The questionnaire-minOccurs / questionnaire-maxOccurs extensions are inclusive bounds: an item
 * whose minimum is 2 is satisfied by two answers, and one whose maximum is 2 is satisfied by two
 * answers. See https://github.com/hapifhir/org.hl7.fhir.core/issues/2314.
 *
 * QuestionnaireValidator used to test the count with strict inequalities, so an answer count
 * exactly equal to either bound was reported - "The minimum number of answers is 2 but this has 2
 * answers". The control item guards the other direction: a count that really does break its bound
 * must still be reported, so the check cannot be satisfied by dropping it.
 *
 * No terminology server is used - the checks under test are arithmetic on the answer count.
 */
class QuestionnaireResponseOccursTests {

  private static final String Q_URL = "http://hl7.org/fhir/test/Questionnaire/qr-occurs";

  @Test
  void answerCountEqualToMinOrMaxOccursIsAccepted() throws Exception {
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", "n/a", FhirPublication.R5, "5.0.0");
    ve.getContext().cacheResource(questionnaire());

    byte[] qr = new JsonParser().composeBytes(response());
    OperationOutcome op = ve.validate(FhirFormat.JSON, new ByteArrayInputStream(qr), null);

    List<String> reported = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : op.getIssue()) {
      String msg = issue.getDetails().getText();
      if (msg != null && (msg.contains("minimum number of answers") || msg.contains("maximum number of answers"))) {
        reported.add(location(issue) + ": " + msg);
      }
    }

    // 'min-boundary' (2 answers, minimum 2) and 'max-boundary' (2 answers, maximum 2) both sit
    // exactly on their bound and are legal. Only 'min-violated' (1 answer, minimum 2) is not.
    assertEquals(1, reported.size(), "only the item that breaks its bound should be reported, but got: " + reported);
    assertTrue(reported.get(0).contains("The minimum number of answers is 2 but this has 1 answers"), reported.get(0));
  }

  private String location(OperationOutcomeIssueComponent issue) {
    return issue.getExpression().isEmpty() ? "??" : issue.getExpression().get(0).asStringValue();
  }

  private Questionnaire questionnaire() {
    Questionnaire q = new Questionnaire();
    q.setUrl(Q_URL);
    q.setVersion("1.0.0");
    q.setName("QROccursTest");
    q.setStatus(PublicationStatus.ACTIVE);
    q.addItem(item("min-boundary", ExtensionDefinitions.EXT_MINOCCURS, 2));
    q.addItem(item("max-boundary", ExtensionDefinitions.EXT_MAXOCCURS, 2));
    q.addItem(item("min-violated", ExtensionDefinitions.EXT_MINOCCURS, 2));
    return q;
  }

  private QuestionnaireItemComponent item(String linkId, String occursExtension, int value) {
    QuestionnaireItemComponent i = new QuestionnaireItemComponent();
    i.setLinkId(linkId);
    i.setType(QuestionnaireItemType.STRING);
    i.setRepeats(true);
    i.addExtension(occursExtension, new IntegerType(value));
    return i;
  }

  private QuestionnaireResponse response() {
    QuestionnaireResponse qr = new QuestionnaireResponse();
    qr.setQuestionnaire(Q_URL);
    qr.setStatus(QuestionnaireResponseStatus.COMPLETED);
    qr.addItem(answers("min-boundary", 2));
    qr.addItem(answers("max-boundary", 2));
    qr.addItem(answers("min-violated", 1));
    return qr;
  }

  private QuestionnaireResponseItemComponent answers(String linkId, int count) {
    QuestionnaireResponseItemComponent i = new QuestionnaireResponseItemComponent();
    i.setLinkId(linkId);
    for (int c = 0; c < count; c++) {
      i.addAnswer().setValue(new StringType("answer " + c));
    }
    return i;
  }
}
