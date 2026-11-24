package org.hl7.fhir.validation.instance;

import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * What the terminology server has already said about a CodeableConcept's codings isn't said again. The server's
 * message is matched on the codings and the map it names - not its words, which are in whatever language it answered
 * in, and not the order it lists the codings in
 */
class TranslationValidatorServerSaidTests {

  private static final String PATH = "Observation.code";
  private static final String A = "http://example.org/a";
  private static final String B = "http://example.org/b";
  private static final String MAP = "http://example.org/ConceptMap/ab|1.0";

  private static SimpleWorkerContext ctxt;

  @BeforeAll
  static void setUp() throws Exception {
    ctxt = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    ConceptMap cm = new ConceptMap(ctxt.getModelContext());
    cm.setUrl("http://example.org/ConceptMap/ab");
    cm.setVersion("1.0");
    ConceptMapGroupComponent g = cm.addGroup().setSource(A).setTarget(B);
    g.addElement().setCode("x").setNoMap(true);
    ctxt.cacheResource(cm);
  }

  /**
   * a#x, b#y1 and b#y2, which the map says has no mapping to b. Returns what the validator added
   */
  private static List<ValidationMessage> check(String serverText) {
    TranslationValidator tv = new TranslationValidator(new BaseValidator(ctxt, new ValidatorSettings(), null, null));
    CodeableConcept cc = new CodeableConcept(ctxt.getModelContext());
    cc.addCoding().setSystem(A).setCode("x");
    cc.addCoding().setSystem(B).setCode("y1");
    cc.addCoding().setSystem(B).setCode("y2");
    NodeStack stack = Mockito.mock(NodeStack.class);
    Mockito.when(stack.getLiteralPath()).thenReturn(PATH);
    List<ValidationMessage> errors = new ArrayList<>();
    ValidationMessage server = null;
    if (serverText != null) {
      server = new ValidationMessage(ValidationMessage.Source.TerminologyEngine, IssueType.BUSINESSRULE, PATH, serverText, IssueSeverity.WARNING);
      server.setMessageId("TRANSLATION_WARNING_NOMAP_one");
      errors.add(server);
    }
    tv.checkCodeableConcept(errors, stack, cc);
    errors.remove(server);
    return errors;
  }

  @Test
  void withoutTheServerTheWarningIsGiven() {
    List<ValidationMessage> said = check(null);
    assertEquals(1, said.size());
    assertTrue(said.get(0).getMessage().contains(B + "#y1, " + B + "#y2"), said.get(0).getMessage());
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource(delimiter = ';', value = {
    "the same order;This CodeableConcept has the codes http://example.org/a#x and http://example.org/b#y1, http://example.org/b#y2, but the ConceptMap http://example.org/ConceptMap/ab|1.0 says that http://example.org/a#x has no mapping to http://example.org/b",
    "another order;This CodeableConcept has the codes http://example.org/a#x and http://example.org/b#y2, http://example.org/b#y1, but the ConceptMap http://example.org/ConceptMap/ab|1.0 says that http://example.org/a#x has no mapping to http://example.org/b",
    "another language;ConceptMap http://example.org/ConceptMap/ab|1.0によると、http://example.org/a#xはhttp://example.org/bへのマッピングがありません (http://example.org/b#y1、http://example.org/b#y2)",
    "a map at the end of a sentence;http://example.org/a#x, http://example.org/b#y1, http://example.org/b#y2: kein Mapping laut http://example.org/ConceptMap/ab|1.0.",
  })
  void whatTheServerSaidIsNotSaidAgain(String name, String serverText) {
    assertEquals(0, check(serverText).size());
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource(delimiter = ';', value = {
    "another version of the map;This CodeableConcept has the codes http://example.org/a#x and http://example.org/b#y1, http://example.org/b#y2, but the ConceptMap http://example.org/ConceptMap/ab|1.0.1 says that http://example.org/a#x has no mapping to http://example.org/b",
    "another coding;This CodeableConcept has the codes http://example.org/a#x and http://example.org/b#y12, http://example.org/b#y2, but the ConceptMap http://example.org/ConceptMap/ab|1.0 says that http://example.org/a#x has no mapping to http://example.org/b",
    "one coding missing;This CodeableConcept has the codes http://example.org/a#x and http://example.org/b#y2, but the ConceptMap http://example.org/ConceptMap/ab|1.0 says that http://example.org/a#x has no mapping to http://example.org/b",
  })
  void somethingTheServerDidntSayIsSaid(String name, String serverText) {
    assertEquals(1, check(serverText).size());
  }

  @Test
  void namesFindsWholeTokensOnly() {
    assertTrue(TranslationValidator.names("map " + MAP + ", and", MAP));
    assertTrue(TranslationValidator.names("map " + MAP + ".", MAP));
    assertTrue(TranslationValidator.names("map " + MAP + "の", MAP));
    assertFalse(TranslationValidator.names("map " + MAP + ".1", MAP));
    assertFalse(TranslationValidator.names("map " + MAP + "-beta", MAP));
    assertFalse(TranslationValidator.names("map http://x" + MAP, MAP));
  }
}
