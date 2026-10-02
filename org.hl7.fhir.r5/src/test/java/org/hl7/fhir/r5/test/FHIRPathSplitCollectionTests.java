package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IssueMessage;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * split() returns an ordered collection of strings, so first() on its result is legal. Typing it
 * as a SINGLETON raised a spurious FHIRPATH_NOT_A_COLLECTION warning in IG QA (#2640).
 */
public class FHIRPathSplitCollectionTests {

  /** The expression from the bug report. */
  private static final String INVARIANT =
      "entry.resource.language.all($this.split('-').first().lower() = %resource.language.split('-').first().lower())";

  private static FHIRPathEngine fp;
  private static SimpleWorkerContext context;

  @BeforeAll
  public static void setUp() throws FileNotFoundException, FHIRException, IOException {
    context = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    fp = new FHIRPathEngine(context);
  }

  @AfterAll
  static void tearDown() {
    fp = null;
    context = null;
  }

  private List<IssueMessage> checkOnString(String expression) {
    List<IssueMessage> warnings = new ArrayList<>();
    fp.checkOnTypes(null, "Resource", "string", new TypeDetails(CollectionStatus.SINGLETON, TypeDetails.FP_String),
        fp.parse(expression), warnings);
    return warnings;
  }

  private static void assertNoNotACollectionWarning(List<IssueMessage> warnings) {
    for (IssueMessage m : warnings) {
      Assertions.assertNotEquals(I18nConstants.FHIRPATH_NOT_A_COLLECTION, m.getId(),
          "unexpected FHIRPATH_NOT_A_COLLECTION warning: " + m.getMessage());
    }
  }

  // -- static typing ---------------------------------------------------------------------------

  @Test
  void testSplitIsTypedAsAStringCollection() {
    TypeDetails td = fp.checkOnTypes(null, "Resource", "string",
        new TypeDetails(CollectionStatus.SINGLETON, TypeDetails.FP_String),
        fp.parse("'fr-BE'.split('-')"), new ArrayList<>());
    Assertions.assertEquals(CollectionStatus.ORDERED, td.getCollectionStatus(),
        "split() must be typed as an ordered collection, not a singleton");
    Assertions.assertTrue(td.hasType(TypeDetails.FP_String), "split() must be typed as String, was " + td.describe());
  }

  @Test
  void testFirstOnSplitRaisesNoNotACollectionWarning() {
    assertNoNotACollectionWarning(checkOnString("'fr-BE'.split('-').first().lower()"));
  }

  @Test
  void testOtherCollectionFunctionsOnSplitRaiseNoWarning() {
    assertNoNotACollectionWarning(checkOnString("'fr-BE'.split('-').last()"));
    assertNoNotACollectionWarning(checkOnString("'fr-BE'.split('-').tail()"));
    assertNoNotACollectionWarning(checkOnString("'fr-BE'.split('-').skip(1)"));
    assertNoNotACollectionWarning(checkOnString("'fr-BE'.split('-').take(1)"));
  }

  @Test
  void testFirstOnASingletonStillWarns() {
    // guard against over-correcting: first() on a genuine singleton must still be reported
    List<IssueMessage> warnings = checkOnString("'fr-BE'.lower().first()");
    boolean found = false;
    for (IssueMessage m : warnings) {
      found |= I18nConstants.FHIRPATH_NOT_A_COLLECTION.equals(m.getId());
    }
    Assertions.assertTrue(found, "first() on a singleton should still raise FHIRPATH_NOT_A_COLLECTION");
  }

  @Test
  void testInvariantOnBundleRaisesNoNotACollectionWarning() {
    // mirrors StructureDefinitionValidator's check of StructureDefinition.constraint.expression
    List<IssueMessage> warnings = new ArrayList<>();
    fp.checkOnTypes(null, "Resource", "Bundle", new TypeDetails(CollectionStatus.SINGLETON, "Bundle"),
        fp.parse(INVARIANT), warnings);
    assertNoNotACollectionWarning(warnings);
  }

  // -- runtime behaviour (must be unchanged) ---------------------------------------------------

  @Test
  void testSplitStillReturnsAllSegments() {
    List<Base> res = fp.evaluate(new StringType("fr-BE"), fp.parse("$this.split('-')"));
    Assertions.assertEquals(2, res.size());
    Assertions.assertEquals("fr", res.get(0).primitiveValue());
    Assertions.assertEquals("BE", res.get(1).primitiveValue());
  }

  @Test
  void testFirstOnSplitStillEvaluatesToFr() {
    List<Base> res = fp.evaluate(new StringType("fr-BE"), fp.parse("$this.split('-').first().lower()"));
    Assertions.assertEquals(1, res.size());
    Assertions.assertEquals("fr", res.get(0).primitiveValue());
  }

  @Test
  void testInvariantIsTrueForMatchingLanguageSubtag() {
    Assertions.assertTrue(evaluateInvariant("fr-FR", "fr-BE"));
  }

  @Test
  void testInvariantIsFalseForDifferentLanguageSubtag() {
    Assertions.assertFalse(evaluateInvariant("fr-FR", "de-DE"));
  }

  private boolean evaluateInvariant(String bundleLanguage, String entryLanguage) {
    Bundle bundle = new Bundle();
    bundle.setType(BundleType.COLLECTION);
    bundle.setLanguage(bundleLanguage);
    Patient patient = new Patient();
    patient.setId("p1");
    patient.setLanguage(entryLanguage);
    bundle.addEntry().setResource(patient);

    ExpressionNode node = fp.parse(INVARIANT);
    return fp.evaluateToBoolean(bundle, bundle, bundle, node);
  }
}
