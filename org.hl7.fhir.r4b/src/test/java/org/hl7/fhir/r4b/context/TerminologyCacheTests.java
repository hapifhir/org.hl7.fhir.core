package org.hl7.fhir.r4b.context;

import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerminologyCacheTests implements ResourceLoaderTests {

  private TerminologyCache createTerminologyCache() throws IOException {
    Object lock = new Object();
    TerminologyCache terminologyCache = new TerminologyCache(lock, null);
    return terminologyCache;
  }

  @ParameterizedTest
  @CsvSource({ "http://terminology.hl7.org/CodeSystem/id,id", "http://hl7.org/fhir/id,id",
      "http://hl7.org/fhir/sid/id,id", "http://www.nlm.nih.gov/research/umls/rxnorm,rxnorm",
      "http://snomed.info/sct,snomed", "http://www.nlm.nih.gov/research/umls/rxnorm,rxnorm", "http://loinc.org,loinc",
      "http://unitsofmeasure.org,ucum", "urn:iso:std:iso:id,isoid", "urn:ietf:bcp:47,lang", "urn:ietf:bcp:13,mimetypes",
      "urn:iso:std:iso:11073:10101,11073", "my://random/system?with#chars,my___random_systemXwithXchars",
      "http://dicom.nema.org/resources/ontology/DCM,dicom" })
  public void testCacheTokenGeneration(String system, String expectedName) throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();
    {
      Coding coding = new Coding();
      coding.setSystem(system);
      TerminologyCache.CacheToken cacheToken = terminologyCache
          .generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet);
      assertEquals(expectedName, cacheToken.getName());
    }
    {
      Coding coding = new Coding();
      coding.setSystem(system + "|dummyVersion");
      TerminologyCache.CacheToken cacheToken = terminologyCache
          .generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet);
      assertEquals(expectedName + "_dummyVersion", cacheToken.getName());
    }
  }
}
