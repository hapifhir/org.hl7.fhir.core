package org.hl7.fhir.r5.terminologies.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r5.context.CacheTestUtils;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TerminologyCacheTests implements ResourceLoaderTests {

  static final ValueSet.ConceptSetComponent include = new ValueSet.ConceptSetComponent();
  static {
    include.setSystem("dummyIncludeSystem");
    include.setVersion("dummyIncludeVersion");
  }

  static final ValueSet.ConceptSetComponent exclude = new ValueSet.ConceptSetComponent();
  static {
    exclude.setSystem("dummyExcludeSystem");
    exclude.setVersion("dummyExcludeVersion");
  }

  static final ValueSet.ValueSetExpansionContainsComponent containsComponent = new ValueSet.ValueSetExpansionContainsComponent();
  static {
    containsComponent.setSystem("dummyContainsSystem");
    containsComponent.setVersion("dummyContainsVersion");
  }

  private JsonParser jsonParser = new JsonParser();

  private JsonElement getJsonFromFile(String filename) throws URISyntaxException, IOException {
    InputStream inputStream = getResourceAsInputStream("context", filename);

    final String stringValue = IOUtils.toString(inputStream, java.nio.charset.StandardCharsets.UTF_8);
    return jsonParser.parse(stringValue);
  };

  private TerminologyCache createTerminologyCache() throws IOException {
    Object lock = new Object();
    TerminologyCache terminologyCache = new TerminologyCache(lock, null);
    return terminologyCache;
  }

  public Path createTempCacheDirectory() throws IOException {
    Path tmp = Files.createTempDirectory("integrationTestCache");
    ManagedFileAccess.fromPath(tmp).deleteOnExit();
    return tmp;
  }

  public void deleteTempCacheDirectory(Path path) throws IOException {
    File directory = ManagedFileAccess.file(path.toString());
    for (File file : directory.listFiles()) {
      file.delete();
    }
  }

  @Nested
  class PersistenceTests {
    final Path tempCacheDirectory;
    final ValueSet valueSet = new ValueSet();
    final String address = "my.dummy.server";

    final TerminologyCapabilities terminologyCapabilities = new TerminologyCapabilities();
    final CapabilityStatement.CapabilityStatementSoftwareComponent software = new CapabilityStatement.CapabilityStatementSoftwareComponent();
    final CapabilityStatement capabilityStatement = new CapabilityStatement();
    Coding coding = new Coding();
    CodeableConcept concept = new CodeableConcept();

    final Object lock = new Object();

    final TerminologyCache terminologyCacheA;
    final ValidationResult codingResultA = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyInfo", null);
    final TerminologyCache.CacheToken codingTokenA;

    final ValidationResult codeableConceptResultA = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyInfo", null);
    final TerminologyCache.CacheToken codeableConceptTokenA;

    final TerminologyCache.CacheToken expansionTokenA;
    final ValueSetExpansionOutcome expansionOutcomeA;

    PersistenceTests() throws IOException {
      tempCacheDirectory = createTempCacheDirectory();
      valueSet.setUrl("dummyValueSetURL");
      terminologyCapabilities.getExpansion().setParameter(Arrays.asList());
      software.setVersion("dummyVersion");
      capabilityStatement.setSoftware(software);
      coding.setCode("dummyCode");
      concept.addCoding(new Coding().setCode("dummyCode"));

      terminologyCacheA = new TerminologyCache(lock, tempCacheDirectory.toString());

      terminologyCacheA.cacheTerminologyCapabilities(address, terminologyCapabilities);
      terminologyCacheA.cacheCapabilityStatement(address, capabilityStatement);

      codingTokenA = terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions,
        coding, valueSet, new Parameters());

      terminologyCacheA.cacheValidation(codingTokenA, codingResultA, true);

      codeableConceptTokenA = terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions,
        concept, valueSet, new Parameters());

      terminologyCacheA.cacheValidation(codeableConceptTokenA, codeableConceptResultA, true);

      expansionTokenA = terminologyCacheA.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true));
      expansionOutcomeA = new ValueSetExpansionOutcome(valueSet);

      terminologyCacheA.cacheExpansion(expansionTokenA, expansionOutcomeA, true);
    }

    @Test
    public void testCachePersistence() throws IOException {
      assertInMemoryCacheContents();

      //Create another cache using the same directory, and check that it gives the same results.

        TerminologyCache terminologyCacheB = new TerminologyCache(lock, tempCacheDirectory.toString());

        assertCanonicalResourceEquals(terminologyCapabilities, terminologyCacheB.getTerminologyCapabilities(address));
        assertCanonicalResourceEquals(capabilityStatement, terminologyCacheB.getCapabilityStatement(address));

        ValidationResult retrievedCodingResultA = terminologyCacheB.getValidation(terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters()));
        assertNotSame(codingResultA, retrievedCodingResultA);
        assertValidationResultEquals(codingResultA, retrievedCodingResultA);

        ValidationResult retrievedCodeableConceptResultA = terminologyCacheB.getValidation(terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions, concept, valueSet, new Parameters()));
        assertNotSame(codeableConceptResultA, retrievedCodeableConceptResultA);
        assertValidationResultEquals(codeableConceptResultA, retrievedCodeableConceptResultA);
        assertExpansionOutcomeEquals(expansionOutcomeA, terminologyCacheB.getExpansion(terminologyCacheA.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true))));

        deleteTempCacheDirectory(tempCacheDirectory);
    }

    @Test
    public void testCacheExpiresCapabilitiesFiles() throws IOException, InterruptedException {
      assertInMemoryCacheContents();

      Thread.sleep(200L);
      TerminologyCache terminologyCacheB = new TerminologyCache(lock, tempCacheDirectory.toString(), 100L);

      assertThat(terminologyCacheB.getTerminologyCapabilities(address)).isNull();
      assertThat(terminologyCacheB.getCapabilityStatement(address)).isNull();

      ValidationResult retrievedCodingResultA = terminologyCacheB.getValidation(terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters()));
      assertNotSame(codingResultA, retrievedCodingResultA);
      assertValidationResultEquals(codingResultA, retrievedCodingResultA);

      ValidationResult retrievedCodeableConceptResultA = terminologyCacheB.getValidation(terminologyCacheA.generateValidationToken(CacheTestUtils.validationOptions, concept, valueSet, new Parameters()));
      assertNotSame(codeableConceptResultA, retrievedCodeableConceptResultA);
      assertValidationResultEquals(codeableConceptResultA, retrievedCodeableConceptResultA);
      assertExpansionOutcomeEquals(expansionOutcomeA, terminologyCacheB.getExpansion(terminologyCacheA.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true))));

      deleteTempCacheDirectory(tempCacheDirectory);
    }

    private void assertInMemoryCacheContents() {
      assertEquals(terminologyCapabilities, terminologyCacheA.getTerminologyCapabilities(address));
      assertEquals(capabilityStatement, terminologyCacheA.getCapabilityStatement(address));

      ValidationResult retrievedCodingResultA = terminologyCacheA.getValidation(codingTokenA);
      assertNotSame(codingResultA, retrievedCodingResultA);
      assertValidationResultEquals(codingResultA, retrievedCodingResultA);

      ValidationResult retrievedCodeableConceptResultA = terminologyCacheA.getValidation(codeableConceptTokenA);
      assertNotSame(codeableConceptResultA, retrievedCodeableConceptResultA);
      assertValidationResultEquals(codeableConceptResultA, retrievedCodeableConceptResultA);
      assertExpansionOutcomeEquals(expansionOutcomeA, terminologyCacheA.getExpansion(expansionTokenA));
    }
  }


  @Test
  public void testCacheMakesCopiesOfResults() throws IOException{

    Object lock = new Object();
    Path tempCacheDirectory = createTempCacheDirectory();

    TerminologyCache terminologyCache = new TerminologyCache(lock, tempCacheDirectory.toString());

    Coding coding = new Coding();
    coding.setCode("dummyCode");

    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding().setCode("dummyCode"));

    ValueSet valueSet = new ValueSet();
    valueSet.setUrl("dummyValueSetURL");

    ValidationResult codingResult = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyInfo", null);
    TerminologyCache.CacheToken codingToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet, new Parameters());
    terminologyCache.cacheValidation(codingToken, codingResult, true);

    ValidationResult retrievedCodingResult = terminologyCache.getValidation(codingToken);
    assertEquals(codingResult, retrievedCodingResult);

    codingResult.setMessage("changed");

    retrievedCodingResult = terminologyCache.getValidation(codingToken);
    assertNotEquals(codingResult, retrievedCodingResult);
    assertEquals("dummyInfo", retrievedCodingResult.getMessage());

    ValidationResult codeableConceptResult = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyInfo", null);
    TerminologyCache.CacheToken codeableConceptToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet, new Parameters());
    terminologyCache.cacheValidation(codeableConceptToken, codeableConceptResult, true);

    ValidationResult retrievedCodeableConceptResult = terminologyCache.getValidation(codeableConceptToken);
    assertEquals(codeableConceptResult, retrievedCodeableConceptResult);

    codeableConceptResult.setMessage("changed");

    retrievedCodeableConceptResult = terminologyCache.getValidation(codeableConceptToken);
    assertNotEquals(codeableConceptResult, retrievedCodeableConceptResult);
    assertEquals("dummyInfo", retrievedCodeableConceptResult.getMessage());
  }

  private void assertCanonicalResourceEquals(CanonicalResource a, CanonicalResource b) {
    assertTrue(a.equalsDeep(b));
  }

  private void assertValidationResultEquals(ValidationResult a, ValidationResult b) {
    assertEquals(a.getSeverity(), b.getSeverity());
    assertEquals(a.getMessage(), b.getMessage());
  }

  private void assertExpansionOutcomeEquals(ValueSetExpansionOutcome a, ValueSetExpansionOutcome b) {
    assertEquals(a.getValueset().getUrl(), b.getValueset().getUrl());
  }

  @Test
  public void testCodingCacheTokenGeneration() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet, new Parameters());

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codingEmptyValueSet.json");

    assertEquals(expected, actual);
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));
  }

  @Test
  public void testCodingWithSystemCacheTokenGeneration() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");
    coding.setSystem("dummySystem");
    coding.setVersion("dummyVersion");
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet, new Parameters());

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codingEmptyValueSetSystem.json");

    assertEquals(expected, actual);
    assertEquals(expected.toString(), actual.toString());
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));
  }

  @Test
  public void testCodingWithSystemCacheTokenGenerationNoSystem() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");

    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet, new Parameters());
    assertEquals("all-systems", cacheToken.getName());
    assertFalse(cacheToken.hasVersion());
  }

  @Test
  public void testCodingWithSystemCacheTokenGenerationWithSystem() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();

    Coding coding = new Coding();
    coding.setCode("dummyCode");
    coding.setSystem("dummySystem");
    coding.setVersion("dummyVersion");
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      coding, valueSet, new Parameters());
    assertEquals("dummySystem", cacheToken.getName());
    assertTrue(cacheToken.hasVersion());
  }



  @Test
  public void testCodableConceptCacheTokenGeneration() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding().setCode("dummyCode"));
    ValueSet valueSet = new ValueSet();
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet, new Parameters());

    assertNull(cacheToken.getName());
    assertEquals(false, cacheToken.hasVersion());

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codableConceptEmptyValueSet.json");

    assertEquals(expected, actual);
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));
  }

  @Test
  public void testCodableConceptCacheTokenGenerationWithSystem() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    CodeableConcept concept = new CodeableConcept();
    Coding coding = new Coding().setCode("dummyCode");
    coding.setSystem("dummySystem");
    coding.setVersion("dummyVersion");
    concept.addCoding(coding);

    ValueSet valueSet = new ValueSet();
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet, new Parameters());

    assertEquals("dummySystem", cacheToken.getName());
    assertEquals(true, cacheToken.hasVersion());

    JsonElement actual = jsonParser.parse(cacheToken.getRequest());
    JsonElement expected = getJsonFromFile("codableConceptEmptyValueSetSystem.json");

    assertEquals(expected, actual);
    assertEquals(terminologyCache.hashJson(expected.toString()), terminologyCache.hashJson(actual.toString()));

  }

  @Test
  public void testCodableConceptCacheTokenGenerationNoSystem() throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    CodeableConcept concept = new CodeableConcept();
    Coding coding = new Coding().setCode("dummyCode");

    concept.addCoding(coding);

    ValueSet valueSet = new ValueSet();
    TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
      concept, valueSet, new Parameters());

    assertNull(cacheToken.getName());
    assertFalse(cacheToken.hasVersion());
  }

  private static Stream<Arguments> getExpansionTokenParams() {
    ValueSet baseValueSet = new ValueSet();
    baseValueSet.setUrl("dummyUrl");

    ValueSet withInclude = baseValueSet.copy();
    withInclude.getCompose().setInclude(Arrays.asList(include));

    ValueSet withExclude = baseValueSet.copy();
    withExclude.getCompose().setExclude(Arrays.asList(exclude));

    ValueSet withExpansion = baseValueSet.copy();
    withExpansion.getExpansion().setContains(Arrays.asList(containsComponent));

    ValueSet allSystem = baseValueSet.copy();
    allSystem.getCompose().setExclude(Arrays.asList(exclude));
    allSystem.getExpansion().setContains(Arrays.asList(containsComponent));

    return Stream.of(
      Arguments.of(baseValueSet, null, false),
      Arguments.of(withInclude, "dummyIncludeSystem", true),
      Arguments.of(withExclude, "dummyExcludeSystem", true),
      Arguments.of(withExpansion, "dummyContainsSystem", true),
      // Essentially, if more than one system is used, we're switching to 'all-systems'
      Arguments.of(allSystem, "all-systems", true)
    );
  }

  @ParameterizedTest
  @MethodSource("getExpansionTokenParams")
  public void testExpansionTokenInclude(ValueSet valueSet, String expectedName, boolean expectedHasVersion) throws IOException, URISyntaxException {
    TerminologyCache terminologyCache = createTerminologyCache();

    TerminologyCache.CacheToken expansionToken = terminologyCache.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(false));
    TerminologyCache.CacheToken expansionTokenHierarchical = terminologyCache.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true));

    assertEquals(expectedName, expansionToken.getName());
    assertEquals(expectedName, expansionTokenHierarchical.getName());
    assertEquals(expectedHasVersion, expansionToken.hasVersion());
    assertEquals(expectedHasVersion, expansionTokenHierarchical.hasVersion());
  }

  @Test
  public void testExpansionToken() throws IOException, URISyntaxException {
    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();
    valueSet.setUrl("dummyUrl");

    valueSet.getCompose().setInclude(Arrays.asList(include));
    valueSet.getCompose().setExclude(Arrays.asList(exclude));
    valueSet.getExpansion().setContains(Arrays.asList(containsComponent));

    TerminologyCache.CacheToken expansionToken = terminologyCache.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(false));
    TerminologyCache.CacheToken expansionTokenHierarchical = terminologyCache.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true));

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
    return getIntParams(1001, 1100);
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
    final int expansionSize = element.getAsJsonObject().has("expansion")
      ? element.getAsJsonObject().getAsJsonObject("expansion").getAsJsonArray("contains").size()
      : 0;
    assertEquals(max, expansionSize);
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

  @ParameterizedTest
  @CsvSource({
    "http://terminology.hl7.org/CodeSystem/id,id",
    "http://hl7.org/fhir/id,id",
    "http://hl7.org/fhir/sid/id,id",
    "http://www.nlm.nih.gov/research/umls/rxnorm,rxnorm",
    "http://snomed.info/sct,snomed",
    "http://www.nlm.nih.gov/research/umls/rxnorm,rxnorm",
    "http://loinc.org,loinc",
    "http://unitsofmeasure.org,ucum",
    "urn:iso:std:iso:id,isoid",
    "urn:ietf:bcp:47,lang",
    "urn:ietf:bcp:13,mimetypes",
    "urn:iso:std:iso:11073:10101,11073",
    "my://random/system?with#chars,my___random_systemXwithXchars",
    "http://dicom.nema.org/resources/ontology/DCM,dicom"
  })
  public void testCacheTokenGeneration(String system, String expectedName) throws IOException, URISyntaxException {

    TerminologyCache terminologyCache = createTerminologyCache();
    ValueSet valueSet = new ValueSet();
    {
      Coding coding = new Coding();
      coding.setSystem(system);
      TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
        coding, valueSet, new Parameters());
      assertEquals(expectedName, cacheToken.getName());
    }
    {
      Coding coding = new Coding();
      coding.setSystem(system + "|dummyVersion");
      TerminologyCache.CacheToken cacheToken = terminologyCache.generateValidationToken(CacheTestUtils.validationOptions,
        coding, valueSet, new Parameters());
      assertEquals(expectedName + "_dummyVersion", cacheToken.getName());
    }
  }

  @Test
  void testHashJsonHandlesDifferentEndOfLine() throws IOException {
    TerminologyCache terminologyCache = createTerminologyCache();
    String newLineJson = "{\n" +
        "  \"resourceType\": \"ValueSet\",\n" +
        "  \"id\": \"dummyId\"\n" +
        "}";
    String newLineAndCarriageReturnJson = "{\r\n" +
        "  \"resourceType\": \"ValueSet\",\r\n" +
        "  \"id\": \"dummyId\"\r\n" +
        "}";
    String newLineToken = terminologyCache.hashJson(newLineJson);
    String newLineAndCarriageReturnToken = terminologyCache.hashJson(newLineAndCarriageReturnJson);

    assertEquals(newLineToken, newLineAndCarriageReturnToken);
  }

  @Test
  void testHashJsonHandlesLeadingAndTrailingWhitespace() throws IOException {
    TerminologyCache terminologyCache = createTerminologyCache();
    String paddedJson = "   {\n" +
      "  \"resourceType\": \"ValueSet\",\n" +
      "  \"id\": \"dummyId\"\n" +
      "}\n   ";
    String json = "{\n" +
      "  \"resourceType\": \"ValueSet\",\n" +
      "  \"id\": \"dummyId\"\n" +
      "}";
    String paddedJsonToken = terminologyCache.hashJson(paddedJson);
    String jsonToken = terminologyCache.hashJson(json);

    assertEquals(paddedJsonToken, jsonToken);
  }
}
