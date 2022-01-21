package org.hl7.fhir.r5.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.checkerframework.checker.units.qual.C;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerminologyCacheTests {

  private JsonParser jsonParser = new JsonParser();

  private JsonElement getJsonFromFile(String filename) throws URISyntaxException, IOException {
    final Path path = Paths.get("src","test","resources", "context", filename);
    final String stringValue = new String ( Files.readAllBytes(path));
    return jsonParser.parse(stringValue);
  };

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
