package org.hl7.fhir.r4.terminologies;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.Enumerations;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConceptMapEngineTest {

  private static final String CONCEPT_MAP_URL = "https://test-fhir.com/ConceptMap/fake";
  public static final String SOURCE_CODE_STRING = "body-weight";
  public static final String TARGET_CODE_STRING = "vital-signs";

  @Test
  @DisplayName("Coding is converted according to ConceptMap")
  void translate() throws IOException {
    ConceptMap conceptMap = getConceptMap();
    ConceptMapEngine conceptMapEngine = getConceptMapEngine(conceptMap);
    Coding coding = new Coding(null, SOURCE_CODE_STRING, "Body Weight");

    Coding actual = conceptMapEngine.translate(coding, CONCEPT_MAP_URL);

    assertEquals(TARGET_CODE_STRING, actual.getCode());
  }

  @NotNull
  private ConceptMapEngine getConceptMapEngine(ConceptMap conceptMap) throws IOException {
    SimpleWorkerContext simpleWorkerContext = new SimpleWorkerContext();
    simpleWorkerContext.cacheResource(conceptMap);

    return new ConceptMapEngine(simpleWorkerContext);
  }

  @NotNull
  private ConceptMap getConceptMap() {
    ConceptMap.TargetElementComponent targetElementComponent = new ConceptMap.TargetElementComponent();
    targetElementComponent.setCode(TARGET_CODE_STRING);
    targetElementComponent.setEquivalence(Enumerations.ConceptMapEquivalence.EQUIVALENT);

    ConceptMap.SourceElementComponent sourceElementComponent = new ConceptMap.SourceElementComponent();
    sourceElementComponent.setCode(SOURCE_CODE_STRING);
    sourceElementComponent.setTarget(Collections.singletonList(targetElementComponent));

    ConceptMap.ConceptMapGroupComponent conceptMapGroupComponent = new ConceptMap.ConceptMapGroupComponent();
    conceptMapGroupComponent.addElement(sourceElementComponent);

    return new ConceptMap()
      .addGroup(conceptMapGroupComponent)
      .setUrl(CONCEPT_MAP_URL);
  }
}
