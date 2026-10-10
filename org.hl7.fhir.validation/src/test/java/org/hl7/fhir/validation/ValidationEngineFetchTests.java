package org.hl7.fhir.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.elementmodel.ObjectConverter;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * ValidationEngine.fetch() keeps the resources it converted to the element model, and returns a copy on each call
 */
class ValidationEngineFetchTests {

  private static final String URL = "http://hl7.org/fhir/administrative-gender";

  // more than 10 concepts: NamedItemList looks children up in a name map, built lazily, from 10 children on
  private static final String TEST_URL = "http://example.org/fhir/CodeSystem/fetch-test";
  private static final int TEST_CONCEPTS = 25;

  private static ValidationEngine engine;

  @BeforeAll
  static void setUp() throws Exception {
    engine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    String concepts = IntStream.range(0, TEST_CONCEPTS)
      .mapToObj(i -> "{\"code\":\"c" + i + "\",\"display\":\"Concept " + i + "\"}")
      .collect(Collectors.joining(","));
    String cs = "{\"resourceType\":\"CodeSystem\",\"url\":\"" + TEST_URL + "\",\"status\":\"active\",\"content\":\"complete\",\"concept\":[" + concepts + "]}";
    engine.getContext().cacheResource(new JsonParser(engine.getContext().getModelContext()).parse(new ByteArrayInputStream(cs.getBytes(StandardCharsets.UTF_8))));
  }

  @Test
  void testFetchReturnsACopyOfTheConvertedResource() throws Exception {
    Element first = engine.fetch(null, null, URL);
    Element second = engine.fetch(null, null, URL);
    assertNotNull(first);
    assertNotSame(first, second);

    // the same content as the conversion without the cache
    CodeSystem cs = engine.getContext().fetchResource(CodeSystem.class, URL, VersionResolutionRules.defaultRule());
    String expected = compose(new ObjectConverter(engine.getContext()).convert(cs));
    assertEquals(expected, compose(first));
    assertEquals(expected, compose(second));

    // the list items are numbered, as by the parser
    List<Element> concepts = second.getChildrenByName("concept");
    assertEquals(4, concepts.size());
    for (int i = 0; i < concepts.size(); i++) {
      assertEquals(i, concepts.get(i).getIndex());
    }
  }

  @Test
  void testChangesToACopyDontChangeTheNextOne() throws Exception {
    Element first = engine.fetch(null, null, URL);
    String before = compose(first);
    first.getChildrenByName("concept").get(0).getNamedChild("code").setValue("changed");
    first.removeChild("concept");

    assertEquals(before, compose(engine.fetch(null, null, URL)));
  }

  @Test
  void testCopiesDontShareTheNarrative() throws Exception {
    String patient = "{\"resourceType\":\"Patient\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p>Narrative</p></div>\"}}";
    Element original = Manager.parseSingle(engine.getContext(), new ByteArrayInputStream(patient.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
    Element copy = original.copy(EnumSet.allOf(Base.CopyObjectOptions.class));
    var div = original.getNamedChild("text").getNamedChild("div").getXhtml();
    var copiedDiv = copy.getNamedChild("text").getNamedChild("div").getXhtml();
    assertNotSame(div, copiedDiv);
    String text = div.allText();
    assertEquals(text, copiedDiv.allText());

    copiedDiv.addText(" changed");
    assertEquals(text, div.allText());
  }

  /**
   * Concurrent validations fetch the same resource, navigate their copies by name (through the name map
   * of NamedItemList) and change them: each one must see all children
   */
  @Test
  void testConcurrentFetches() throws Exception {
    CodeSystem cs = engine.getContext().fetchResource(CodeSystem.class, TEST_URL, VersionResolutionRules.defaultRule());
    Element converted = new ObjectConverter(engine.getContext()).convert(cs);
    List<String> expectedCodes = codes(converted);
    assertEquals(TEST_CONCEPTS, expectedCodes.size());
    String expected = compose(converted);

    int threads = 8;
    int iterations = 500;
    Queue<String> failures = new ConcurrentLinkedQueue<>();
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService executor = Executors.newFixedThreadPool(threads);
    try {
      List<Future<?>> futures = new ArrayList<>();
      for (int t = 0; t < threads; t++) {
        futures.add(executor.submit(() -> {
          start.await();
          for (int i = 0; i < iterations; i++) {
            Element copy = engine.fetch(null, null, TEST_URL);
            List<String> codes = codes(copy);
            if (!expectedCodes.equals(codes)) {
              failures.add("codes: " + codes);
            }
            if (i % 50 == 0 && !expected.equals(compose(copy))) {
              failures.add("content differs");
            }
            // the validator decorates its copy (e.g. the parents), and changes to a copy must not be seen by the others
            copy.getChildrenByName("concept").forEach(c -> c.setParentForValidator(copy));
            copy.getChildrenByName("concept").get(0).getChildrenByName("code").get(0).setValue("changed");
            copy.removeChild("concept");
          }
          return null;
        }));
      }
      start.countDown();
      for (Future<?> future : futures) {
        future.get();
      }
    } finally {
      executor.shutdownNow();
    }
    assertTrue(failures.isEmpty(), () -> failures.size() + " failures, e.g. " + failures.peek());
    assertEquals(expected, compose(engine.fetch(null, null, TEST_URL)));
  }

  private static List<String> codes(Element codeSystem) {
    return codeSystem.getChildrenByName("concept").stream()
      .map(concept -> concept.getChildrenByName("code").get(0).primitiveValue())
      .toList();
  }

  @Test
  void testUnknownUrl() throws Exception {
    assertNull(engine.fetch(null, null, "http://example.org/fhir/CodeSystem/unknown"));
  }

  private static String compose(Element element) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Manager.compose(engine.getContext(), element, out, FhirFormat.JSON, OutputStyle.PRETTY, null);
    return out.toString(StandardCharsets.UTF_8);
  }
}
