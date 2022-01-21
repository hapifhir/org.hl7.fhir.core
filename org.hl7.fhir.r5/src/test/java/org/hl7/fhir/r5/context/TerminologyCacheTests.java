package org.hl7.fhir.r5.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.checkerframework.checker.units.qual.C;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetExpander;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TerminologyCacheTests {

  private JsonParser jsonParser = new JsonParser();

  private JsonElement getJsonFromFile(String filename) throws URISyntaxException, IOException {
    final Path path = Paths.get("src","test","resources", "context", filename);
    final String stringValue = new String ( Files.readAllBytes(path));
    return jsonParser.parse(stringValue);
  };

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
    Object lock = new Object();

    TerminologyCache terminologyCache = new TerminologyCache(lock, null);
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet );

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codingEmptyValueSet.json");

    assertEquals(expected, actual);

  }

  @Test
  public void testCodableConceptCacheTokenGeneration() throws IOException, URISyntaxException {
    Object lock = new Object();
    TerminologyCache terminologyCache = new TerminologyCache(lock, null);
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding().setCode("dummyCode"));
    ValueSet valueSet = new ValueSet();
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet );

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codableConceptEmptyValueSet.json");

    assertEquals(expected, actual);
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
