package org.hl7.fhir.validation.instance;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The index of ConceptMap groups means looking at every ConceptMap in the context: the context keeps it, so every
 * validator (one per request, in server mode) shares it, until what's loaded changes - and then maps loaded since are
 * seen
 */
class TranslationValidatorIndexTests {

  private static ConceptMap map(IModelContext mc, String url, String source, String target) {
    ConceptMap cm = new ConceptMap(mc);
    cm.setUrl(url);
    ConceptMapGroupComponent g = cm.addGroup().setSource(source).setTarget(target);
    g.addElement().setCode("x").addTarget().setCode("y").setRelationship(ConceptMapRelationship.NOTRELATEDTO);
    return cm;
  }

  private static List<ValidationMessage> check(SimpleWorkerContext ctxt, String source, String target) {
    TranslationValidator tv = new TranslationValidator(new BaseValidator(ctxt, new ValidatorSettings(), null, null));
    CodeableConcept cc = new CodeableConcept(ctxt.getModelContext());
    cc.addCoding().setSystem(source).setCode("x");
    cc.addCoding().setSystem(target).setCode("y");
    List<ValidationMessage> errors = new ArrayList<>();
    tv.checkCodeableConcept(errors, org.mockito.Mockito.mock(NodeStack.class), cc);
    return errors;
  }

  @Test
  void theIndexIsSharedUntilTheContentChanges() throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    ctxt.cacheResource(map(ctxt.getModelContext(), "http://example.org/ConceptMap/ab", "http://example.org/a", "http://example.org/b"));

    assertEquals(1, check(ctxt, "http://example.org/a", "http://example.org/b").size());
    Object index = ctxt.retrieveAnalysis(TranslationValidator.class);
    assertNotNull(index);
    // another validator uses the same index
    assertEquals(0, check(ctxt, "http://example.org/c", "http://example.org/d").size());
    assertSame(index, ctxt.retrieveAnalysis(TranslationValidator.class));

    // a map loaded later: the index is dropped, and the new map is seen
    ctxt.cacheResource(map(ctxt.getModelContext(), "http://example.org/ConceptMap/cd", "http://example.org/c", "http://example.org/d"));
    assertNull(ctxt.retrieveAnalysis(TranslationValidator.class));
    assertEquals(1, check(ctxt, "http://example.org/c", "http://example.org/d").size());
  }
}
