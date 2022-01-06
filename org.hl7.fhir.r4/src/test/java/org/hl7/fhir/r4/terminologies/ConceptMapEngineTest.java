package org.hl7.fhir.r4.terminologies;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.Enumerations;
import javax.annotation.Nonnull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConceptMapEngineTest {

  private static final String CONCEPT_MAP_URL = "https://test-fhir.com/ConceptMap/fake";
  public static final String SOURCE_CODE_STRING = "body-weight";
  public static final String TARGET_CODE_STRING = "vital-signs";

  @Test
  @DisplayName("Coding is translated according to ConceptMap")
  void codingTranslate() throws IOException {

    final ConceptMap.SourceElementComponent sourceElementComponent = getSourceElementComponent();

    final ConceptMapEngine conceptMapEngine = getConceptMapEngine(Arrays.asList(sourceElementComponent));
    Coding coding = new Coding(null, SOURCE_CODE_STRING, "Body Weight");

    Coding actual = conceptMapEngine.translate(coding, CONCEPT_MAP_URL);

    assertEquals(TARGET_CODE_STRING, actual.getCode());
  }

  @Test
  @DisplayName("Coding fails to translate due to multiple candidate matches in ConceptMap")
  void codingTranslateFailsForMultipleCandidateMatches() throws IOException {

    final ConceptMap.SourceElementComponent sourceElementComponent = getSourceElementComponent();

    final ConceptMapEngine conceptMapEngine = getConceptMapEngine(Arrays.asList(sourceElementComponent,
                                                sourceElementComponent
                                              ));
    Coding coding = new Coding(null, SOURCE_CODE_STRING, "Body Weight");

    assertThrows(FHIRException.class, () -> {
      conceptMapEngine.translate(coding, CONCEPT_MAP_URL);
    });
  }

  @Nonnull
  private ConceptMapEngine getConceptMapEngine(Collection<ConceptMap.SourceElementComponent> elements) throws IOException {
    ConceptMap conceptMap = getConceptMap(elements);

    SimpleWorkerContext simpleWorkerContext = mock(SimpleWorkerContext.class);
    when(simpleWorkerContext.fetchResource(ConceptMap.class, CONCEPT_MAP_URL)).thenReturn(conceptMap);

    return new ConceptMapEngine(simpleWorkerContext);
  }

  @Nonnull
  private ConceptMap.SourceElementComponent getSourceElementComponent() {
    ConceptMap.TargetElementComponent targetElementComponent = new ConceptMap.TargetElementComponent();
    targetElementComponent.setCode(TARGET_CODE_STRING);
    targetElementComponent.setEquivalence(Enumerations.ConceptMapEquivalence.EQUIVALENT);

    ConceptMap.SourceElementComponent sourceElementComponent = new ConceptMap.SourceElementComponent();
    sourceElementComponent.setCode(SOURCE_CODE_STRING);
    sourceElementComponent.setTarget(Collections.singletonList(targetElementComponent));

    return sourceElementComponent;
  }

  @Nonnull
  private ConceptMap getConceptMap(Collection<ConceptMap.SourceElementComponent> elements) {

    ConceptMap.ConceptMapGroupComponent conceptMapGroupComponent = new ConceptMap.ConceptMapGroupComponent();
    for (ConceptMap.SourceElementComponent element : elements) {
      conceptMapGroupComponent.addElement(element);
    }
    return new ConceptMap()
      .addGroup(conceptMapGroupComponent)
      .setUrl(CONCEPT_MAP_URL);
  }
}
