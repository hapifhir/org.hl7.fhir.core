package org.hl7.fhir.r4.terminologies;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.Enumerations;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConceptMapEngineTest {

  private static final String CONCEPT_MAP_URL = "https://test-fhir.com/ConceptMap/fake";

  @Test
  void translate() throws IOException {
    ConceptMap.TargetElementComponent targetElementComponent = new ConceptMap.TargetElementComponent();
    targetElementComponent.setCode("vital-signs");
    targetElementComponent.setEquivalence(Enumerations.ConceptMapEquivalence.EQUIVALENT);

    ConceptMap.SourceElementComponent sourceElementComponent = new ConceptMap.SourceElementComponent();
    sourceElementComponent.setCode("body-weight");
    sourceElementComponent.setTarget(Collections.singletonList(targetElementComponent));

    ConceptMap.ConceptMapGroupComponent conceptMapGroupComponent = new ConceptMap.ConceptMapGroupComponent();

    ConceptMap conceptMap = new ConceptMap();
    conceptMap.addGroup(conceptMapGroupComponent);
    conceptMap.setUrl(CONCEPT_MAP_URL);

    SimpleWorkerContext simpleWorkerContext = new SimpleWorkerContext();
    simpleWorkerContext.cacheResource(conceptMap);

    ConceptMapEngine conceptMapEngine = new ConceptMapEngine(simpleWorkerContext);

    Coding coding = new Coding(null, "body-weight", "Body Weight");

    Coding actual = conceptMapEngine.translate(coding, CONCEPT_MAP_URL);

    assertEquals("vital-signs", actual.getCode());
  }
}
