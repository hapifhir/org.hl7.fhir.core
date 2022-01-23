package org.hl7.fhir.r5.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetExpander;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TerminologyCacheTests {

  private JsonParser jsonParser = new JsonParser();

  private JsonElement getJsonFromFile(String filename) throws URISyntaxException, IOException {
    final Path path = Paths.get("src","test","resources", "context", filename);
    final String stringValue = new String ( Files.readAllBytes(path));
    return jsonParser.parse(stringValue);
  };

  private TerminologyCache createTerminologyCache() throws IOException {
    Object lock = new Object();
    TerminologyCache terminologyCache = new TerminologyCache(lock, null);
    return terminologyCache;
  }

  public Path createTempCacheDirectory() throws IOException {
    Path tmp = Files.createTempDirectory("integrationTestCache");
    tmp.toFile().deleteOnExit();
    return tmp;
  }

  public void deleteTempCacheDirectory(Path path) {
    File directory = new File(path.toUri());
    for (File file : directory.listFiles()) {
      file.delete();
    }
  }

  @Test
  public void testCachePersistence() throws IOException, URISyntaxException {
    Object lock = new Object();
    Path tempCacheDirectory = createTempCacheDirectory();
    ValueSet valueSet = new ValueSet();
    valueSet.setUrl("dummyValueSetURL");

    Coding coding = new Coding();
    coding.setCode("dummyCode");

    // Add dummy results to the cache
    TerminologyCache terminologyCacheA = new TerminologyCache(lock, tempCacheDirectory.toString());

    IWorkerContext.ValidationResult validationResultA = new IWorkerContext.ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyInfo");
    TerminologyCache.CacheToken codingTokenA = terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet);
    terminologyCacheA.cacheValidation(codingTokenA, validationResultA, true);

    TerminologyCache.CacheToken expansionTokenA = terminologyCacheA.generateExpandToken(valueSet, true);
    ValueSetExpander.ValueSetExpansionOutcome expansionOutcomeA = new ValueSetExpander.ValueSetExpansionOutcome(valueSet);

    terminologyCacheA.cacheExpansion(expansionTokenA, expansionOutcomeA, true);
    // Check that the in-memory cache is returning what we put in
    {
      assertValidationResultEquals(validationResultA, terminologyCacheA.getValidation(codingTokenA));
      assertExpansionOutcomeEquals(expansionOutcomeA,terminologyCacheA.getExpansion(expansionTokenA));
    }

    //Create another cache using the same directory, and check that it gives the same results.
    {
    TerminologyCache terminologyCacheB = new TerminologyCache(lock, tempCacheDirectory.toString());

      assertValidationResultEquals(validationResultA, terminologyCacheB.getValidation(terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions,
        coding, valueSet)));
      assertExpansionOutcomeEquals(expansionOutcomeA,terminologyCacheB.getExpansion(terminologyCacheA.generateExpandToken(valueSet, true)));
    }
    deleteTempCacheDirectory(tempCacheDirectory);
  }

  private void assertValidationResultEquals(IWorkerContext.ValidationResult a, IWorkerContext.ValidationResult b) {
    assertEquals(a.getSeverity(), b.getSeverity());
    assertEquals(a.getMessage(), b.getMessage());
  }

  private void assertExpansionOutcomeEquals(ValueSetExpander.ValueSetExpansionOutcome a, ValueSetExpander.ValueSetExpansionOutcome b) {
    assertEquals(a.getValueset().getUrl(), b.getValueset().getUrl());
  }

  @Test
  public void testCodingCacheTokenGeneration() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet );

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codingEmptyValueSet.json");

    assertEquals(expected, actual);
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));
  }

  @Test
  public void testCodableConceptCacheTokenGeneration() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding().setCode("dummyCode"));
    ValueSet valueSet = new ValueSet();
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet );

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codableConceptEmptyValueSet.json");

    assertEquals(expected, actual);
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));
  }

  @Test
  public void testExpansionToken() throws IOException, URISyntaxException {
    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    TerminologyCache.CacheToken expansionToken = terminologyCache.generateExpandToken(valueSet, false);
    TerminologyCache.CacheToken expansionTokenHierarchical = terminologyCache.generateExpandToken(valueSet, true);

    JsonElement actualExpansion = jsonParser.parse(expansionToken.getRequest());
    JsonElement expectedExpansion = getJsonFromFile("expansion.json");

    assertEquals(expectedExpansion, actualExpansion);

    JsonElement actualExpansionHierarchical = jsonParser.parse(expansionTokenHierarchical.getRequest());
    JsonElement expectedExpansionHierarchical = getJsonFromFile("expansionHierarchical.json");

    assertEquals(expectedExpansionHierarchical, actualExpansionHierarchical);
    assertEquals(terminologyCache.hashJson(expectedExpansion.toString()),
      terminologyCache.hashJson(actualExpansion.toString()));
    assertEquals(terminologyCache.hashJson(expectedExpansionHierarchical.toString()),
      terminologyCache.hashJson(actualExpansionHierarchical.toString()));

  }

  @Test
  public void testGetVSEssence() throws IOException {
    ValueSet.ValueSetExpansionParameterComponent vsepc = new ValueSet.ValueSetExpansionParameterComponent().setName("dummyValueSetExpansionParameterComponent");

    ValueSet vs = new ValueSet();
    vs.getExpansion().setParameter(Arrays.asList(vsepc));
    vs.getExpansion().setContains(Arrays.asList(new ValueSet.ValueSetExpansionContainsComponent().setCode("dummyVSExpansionContainsComponent")));
    vs.getExpansion().setIdentifier("dummyIdentifier");
    vs.getExpansion().setTimestamp(new Date());

    assertTrue(vs.getExpansion().hasIdentifier());

    TerminologyCache cache = createTerminologyCache();
    ValueSet vse = cache.getVSEssense(vs);

    assertEquals(vs.getExpansion().getParameter(), vse.getExpansion().getParameter());
    assertEquals(vs.getExpansion().getContains(), vse.getExpansion().getContains());

    assertFalse(vse.getExpansion().hasIdentifier());
    assertFalse(vse.getExpansion().hasTimestamp());
  }

  private List<ValueSet.ValueSetExpansionContainsComponent> createContainsArray(int size) {
    return IntStream.range(0, size).boxed()
      .map(value -> new ValueSet.ValueSetExpansionContainsComponent().setCode("dummyVSExpansionContainsComponent"
        + value)).collect(Collectors.toList());
  }

  private static Stream<Arguments> under1000IntParams() {
    return getIntParams(0, 1000);
  }

  private static Stream<Arguments> over1000IntParams() {
    return getIntParams(1000, 1100);
  }

  private static Stream<Arguments> getIntParams(int min, int max) {
    return new Random().ints(5, min, max).boxed().map( value ->
      Arguments.of(value)
    );
  }

  @ParameterizedTest
  @MethodSource("under1000IntParams")
  public void testExtractedUnder1000(int max) throws IOException {
    TerminologyCache cache = createTerminologyCache();
    ValueSet vs = new ValueSet();

    List<ValueSet.ValueSetExpansionContainsComponent> list = createContainsArray(max);

    vs.setUrl("http://dummy.org");
    vs.getExpansion().setContains(list);

    org.hl7.fhir.r5.formats.JsonParser json = new org.hl7.fhir.r5.formats.JsonParser();
    json.setOutputStyle(IParser.OutputStyle.PRETTY);
    String extracted = cache.extracted(json, vs);

    JsonElement element = jsonParser.parse(extracted);
    assertEquals(max, element.getAsJsonObject().getAsJsonObject("expansion").getAsJsonArray("contains").size());

  }

  @ParameterizedTest
  @MethodSource("over1000IntParams")
  public void testExtractedOver1000(int max) throws IOException {

    TerminologyCache cache = createTerminologyCache();
    ValueSet vs = new ValueSet();

    List<ValueSet.ValueSetExpansionContainsComponent> list = createContainsArray(max);

    vs.setUrl("http://dummy.org");
    vs.getExpansion().setContains(list);

    org.hl7.fhir.r5.formats.JsonParser json = new org.hl7.fhir.r5.formats.JsonParser();
    json.setOutputStyle(IParser.OutputStyle.PRETTY);
    String extracted = cache.extracted(json, vs);

    assertEquals("http://dummy.org", extracted);
  }

  @Test
  public void testDummyCache() throws IOException {
    Object lock = new Object();
    Path path =  Paths.get("src","test","resources", "context", "dummyCache");
    TerminologyCache cache = new TerminologyCache(lock, path.toString());

    assertTrue(cache.hasTerminologyCapabilities());
    assertTrue(cache.hasCapabilityStatement());

  }
}
