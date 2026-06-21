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
import java.util.concurrent.TimeUnit;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
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

  // A fresh temp directory yields a genuinely empty cache. NOTE: new TerminologyCache(lock, null)
  // does NOT - null resolves to the shared [tmp]/default-tx-cache and loads whatever is on disk,
  // so any test that asserts on cache size/contents must use an isolated directory like this.
  private TerminologyCache createEmptyTerminologyCache() throws IOException {
    return new TerminologyCache(new Object(), createTempCacheDirectory().toString());
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

      // Writes are debounced (see TerminologyCache.SAVE_DELAY_MS), so explicitly flush
      // before constructing a second cache that reads from disk.
      terminologyCacheA.save();

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

      // Writes are debounced (see TerminologyCache.SAVE_DELAY_MS), so explicitly flush
      // before constructing a second cache that reads from disk.
      terminologyCacheA.save();

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
  void testExtractedUnder1000(int max) throws IOException {
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

  @Test
  void testHashJsonNormalizesLoneAndPairedCarriageReturns() throws IOException {
    TerminologyCache terminologyCache = createTerminologyCache();
    // Lone \r and \r\n are both normalized to \n before hashing.
    assertEquals(terminologyCache.hashJson("a\nb\nc"), terminologyCache.hashJson("a\rb\rc"));
    assertEquals(terminologyCache.hashJson("a\nb\nc"), terminologyCache.hashJson("a\r\nb\r\nc"));
    // Mixed line endings collapse to the same value.
    assertEquals(terminologyCache.hashJson("a\nb\nc"), terminologyCache.hashJson("a\rb\r\nc"));
  }

  @Test
  void testHashJsonDistinguishesDifferentContent() throws IOException {
    TerminologyCache terminologyCache = createTerminologyCache();
    assertNotEquals(terminologyCache.hashJson("{\"a\":1}"), terminologyCache.hashJson("{\"a\":2}"));
  }

  @Test
  void testHashJsonAvoidsKnownHashCodeCollision() throws IOException {
    // "Aa" and "BB" share the same 32-bit String.hashCode() (2112); the widened key must
    // give them distinct hashes so they can't collide onto the same cache entry.
    TerminologyCache terminologyCache = createTerminologyCache();
    assertEquals(2112, "Aa".hashCode());
    assertEquals(2112, "BB".hashCode());
    assertNotEquals(terminologyCache.hashJson("Aa"), terminologyCache.hashJson("BB"));
  }

  @Test
  void testDistinctRequestsGetDistinctEntries() throws IOException {
    // Two requests in the same named-cache bucket (same system) must not collide:
    // each token must retrieve its own result, never the other's.
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    Coding coding1 = new Coding().setSystem("http://example.org/sys").setCode("code1");
    Coding coding2 = new Coding().setSystem("http://example.org/sys").setCode("code2");

    TerminologyCache.CacheToken token1 = cache.generateValidationToken(CacheTestUtils.validationOptions, coding1, valueSet, new Parameters());
    TerminologyCache.CacheToken token2 = cache.generateValidationToken(CacheTestUtils.validationOptions, coding2, valueSet, new Parameters());

    assertEquals(token1.getName(), token2.getName());
    assertNotEquals(token1.getRequest(), token2.getRequest());

    cache.cacheValidation(token1, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "first", null), false);
    cache.cacheValidation(token2, new ValidationResult(ValidationMessage.IssueSeverity.ERROR, "second", null), false);

    assertEquals("first", cache.getValidation(token1).getMessage());
    assertEquals(ValidationMessage.IssueSeverity.INFORMATION, cache.getValidation(token1).getSeverity());
    assertEquals("second", cache.getValidation(token2).getMessage());
    assertEquals(ValidationMessage.IssueSeverity.ERROR, cache.getValidation(token2).getSeverity());
  }

  @Test
  void testHitAndMissCountersTrackLookups() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding().setSystem("http://example.org/sys").setCode("code");
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());

    assertNull(cache.getValidation(token));
    assertEquals(1, cache.getRequestCount());
    assertEquals(0, cache.getHitCount());
    assertEquals(1, cache.getNetworkCount());

    cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v", null), false);

    assertNotNull(cache.getValidation(token));
    assertEquals(2, cache.getRequestCount());
    assertEquals(1, cache.getHitCount());
    assertEquals(1, cache.getNetworkCount());
  }

  @Test
  void testPersistentUpdateReplacesEntryRatherThanDuplicating() throws IOException {
    // Re-caching the same token must replace the persisted entry, not append a duplicate.
    // getReport() counts entries across buckets, so it externally reflects the list size.
    // Use an isolated (empty) cache so the count reflects only what this test adds.
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding().setSystem("http://example.org/sys").setCode("code");
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());

    cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "first", null), true);
    assertThat(cache.getReport()).contains("report: 1 entries");

    cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.ERROR, "second", null), true);
    assertThat(cache.getReport()).contains("report: 1 entries");
    assertEquals("second", cache.getValidation(token).getMessage());
  }

  @Test
  void testSubsumesCacheRoundTrip() throws IOException {
    Object lock = new Object();
    Path dir = createTempCacheDirectory();
    TerminologyCache cacheA = new TerminologyCache(lock, dir.toString());

    Coding parent = new Coding().setSystem("http://example.org/sys").setCode("parent");
    Coding child = new Coding().setSystem("http://example.org/sys").setCode("child");

    TerminologyCache.CacheToken token = cacheA.generateSubsumesToken(CacheTestUtils.validationOptions, parent, child, new Parameters());
    assertNull(cacheA.getSubsumes(token));

    cacheA.cacheSubsumes(token, Boolean.TRUE, true);
    assertEquals(Boolean.TRUE, cacheA.getSubsumes(token));

    // Writes are debounced, so flush before reading from a second cache.
    cacheA.save();

    TerminologyCache cacheB = new TerminologyCache(lock, dir.toString());
    Boolean reloaded = cacheB.getSubsumes(cacheA.generateSubsumesToken(CacheTestUtils.validationOptions, parent, child, new Parameters()));
    assertEquals(Boolean.TRUE, reloaded);

    deleteTempCacheDirectory(dir);
  }

  @Test
  void testRemoveCSDropsBucket() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding().setSystem("http://snomed.info/sct").setCode("code");
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());
    assertEquals("snomed", token.getName());

    cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v", null), false);
    assertNotNull(cache.getValidation(token));

    cache.removeCS("http://snomed.info/sct");
    assertNull(cache.getValidation(token));
  }

  @Test
  void testNoCachingDisablesStorage() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding().setSystem("http://example.org/sys").setCode("code");
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());

    TerminologyCache.setNoCaching(true);
    try {
      cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v", null), false);
      assertNull(cache.getValidation(token));
    } finally {
      TerminologyCache.setNoCaching(false);
    }
  }

  @Test
  void testGetServerIdIsStableAndPersists() throws IOException {
    Object lock = new Object();
    Path dir = createTempCacheDirectory();
    TerminologyCache cacheA = new TerminologyCache(lock, dir.toString());

    String id = cacheA.getServerId("http://tx.fhir.org/r4");
    assertEquals("tx.fhir.org.r4", id);
    assertEquals(id, cacheA.getServerId("http://tx.fhir.org/r4"));

    // A fresh cache over the same folder loads the persisted server map from servers.ini.
    TerminologyCache cacheB = new TerminologyCache(lock, dir.toString());
    assertEquals(id, cacheB.getServerId("http://tx.fhir.org/r4"));

    deleteTempCacheDirectory(dir);
  }

  @Test
  void testGetServerIdDisambiguatesCollidingAddresses() throws IOException {
    Object lock = new Object();
    Path dir = createTempCacheDirectory();
    TerminologyCache cache = new TerminologyCache(lock, dir.toString());

    // http:// and https:// of the same host strip to the same base id, so the second must
    // get a clean, well-formed suffix (the old code produced a malformed "..tx.fhir.org.r42").
    assertEquals("tx.fhir.org.r4", cache.getServerId("http://tx.fhir.org/r4"));
    assertEquals("tx.fhir.org.r42", cache.getServerId("https://tx.fhir.org/r4"));
    // Each address keeps its own stable id on repeat lookups.
    assertEquals("tx.fhir.org.r4", cache.getServerId("http://tx.fhir.org/r4"));
    assertEquals("tx.fhir.org.r42", cache.getServerId("https://tx.fhir.org/r4"));

    deleteTempCacheDirectory(dir);
  }

  @Test
  void testLoadSkipsMalformedEntryAndLoadsTheRest() throws IOException {
    // A single malformed entry must be skipped without aborting the rest of the file.
    Object lock = new Object();
    Path dir = createTempCacheDirectory();
    TerminologyCache cacheA = new TerminologyCache(lock, dir.toString());

    ValueSet valueSet = new ValueSet();
    Coding coding1 = new Coding().setSystem("http://example.org/sys").setCode("code1");
    Coding coding2 = new Coding().setSystem("http://example.org/sys").setCode("code2");

    TerminologyCache.CacheToken token1 = cacheA.generateValidationToken(CacheTestUtils.validationOptions, coding1, valueSet, new Parameters());
    TerminologyCache.CacheToken token2 = cacheA.generateValidationToken(CacheTestUtils.validationOptions, coding2, valueSet, new Parameters());

    cacheA.cacheValidation(token1, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "first", null), true);
    cacheA.cacheValidation(token2, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "second", null), true);
    cacheA.save();

    // Both entries share one named-cache file. Inject a malformed entry (no '####' break)
    // as the first segment, ahead of both good entries. The entry separator is the file's
    // own first line, so we don't depend on the private marker constant.
    File cacheFile = findCacheFile(dir);
    String content = new String(Files.readAllBytes(cacheFile.toPath()), java.nio.charset.StandardCharsets.UTF_8);
    int firstLineEnd = content.indexOf('\n') + 1;
    String marker = content.substring(0, firstLineEnd - 1).replace("\r", "");
    String corrupted = content.substring(0, firstLineEnd)
      + "this entry has no break separator\r\n" + marker + "\r\n"
      + content.substring(firstLineEnd);
    Files.write(cacheFile.toPath(), corrupted.getBytes(java.nio.charset.StandardCharsets.UTF_8));

    // Loading the corrupted file must not throw, and both good entries must survive.
    TerminologyCache cacheB = new TerminologyCache(lock, dir.toString());
    ValidationResult r1 = cacheB.getValidation(cacheA.generateValidationToken(CacheTestUtils.validationOptions, coding1, valueSet, new Parameters()));
    ValidationResult r2 = cacheB.getValidation(cacheA.generateValidationToken(CacheTestUtils.validationOptions, coding2, valueSet, new Parameters()));
    assertNotNull(r1);
    assertNotNull(r2);
    assertEquals("first", r1.getMessage());
    assertEquals("second", r2.getMessage());

    deleteTempCacheDirectory(dir);
  }

  @Test
  void testPersistentEntriesAreCappedFifo() throws IOException {
    int original = TerminologyCache.getMaxEntriesPerCache();
    TerminologyCache.setMaxEntriesPerCache(3);
    try {
      TerminologyCache cache = createEmptyTerminologyCache();
      ValueSet valueSet = new ValueSet();
      TerminologyCache.CacheToken[] tokens = new TerminologyCache.CacheToken[5];
      for (int i = 0; i < 5; i++) {
        Coding coding = new Coding().setSystem("http://example.org/sys").setCode("code" + i);
        tokens[i] = cache.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());
        cache.cacheValidation(tokens[i], new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v" + i, null), true);
      }
      // FIFO: the two oldest entries are evicted, the newest three remain.
      assertThat(cache.getReport()).contains("report: 3 entries");
      assertNull(cache.getValidation(tokens[0]));
      assertNull(cache.getValidation(tokens[1]));
      assertEquals("v2", cache.getValidation(tokens[2]).getMessage());
      assertEquals("v3", cache.getValidation(tokens[3]).getMessage());
      assertEquals("v4", cache.getValidation(tokens[4]).getMessage());
    } finally {
      TerminologyCache.setMaxEntriesPerCache(original);
    }
  }

  @Test
  void testLoadTrimsOversizedCacheToLimit() throws IOException {
    int original = TerminologyCache.getMaxEntriesPerCache();
    try {
      Object lock = new Object();
      Path dir = createTempCacheDirectory();
      ValueSet valueSet = new ValueSet();

      // Write 5 entries with a generous limit so the file legitimately holds all of them.
      TerminologyCache.setMaxEntriesPerCache(5000);
      TerminologyCache cacheA = new TerminologyCache(lock, dir.toString());
      for (int i = 0; i < 5; i++) {
        Coding coding = new Coding().setSystem("http://example.org/sys").setCode("code" + i);
        TerminologyCache.CacheToken token = cacheA.generateValidationToken(CacheTestUtils.validationOptions, coding, valueSet, new Parameters());
        cacheA.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v" + i, null), true);
      }
      cacheA.save();

      // Reload with a tighter limit: only the newest 3 entries survive the load.
      TerminologyCache.setMaxEntriesPerCache(3);
      TerminologyCache cacheB = new TerminologyCache(lock, dir.toString());
      assertThat(cacheB.getReport()).contains("3 entries");
      assertNull(cacheB.getValidation(cacheA.generateValidationToken(CacheTestUtils.validationOptions,
        new Coding().setSystem("http://example.org/sys").setCode("code0"), valueSet, new Parameters())));
      assertNotNull(cacheB.getValidation(cacheA.generateValidationToken(CacheTestUtils.validationOptions,
        new Coding().setSystem("http://example.org/sys").setCode("code4"), valueSet, new Parameters())));

      deleteTempCacheDirectory(dir);
    } finally {
      TerminologyCache.setMaxEntriesPerCache(original);
    }
  }

  @Test
  void testGetValidationAfterUnloadThrows() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions,
      new Coding().setSystem("http://example.org/sys").setCode("code"), new ValueSet(), new Parameters());
    cache.unload();
    assertThrows(IllegalStateException.class, () -> cache.getValidation(token));
  }

  @Test
  void testCacheValidationAfterUnloadThrows() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    TerminologyCache.CacheToken token = cache.generateValidationToken(CacheTestUtils.validationOptions,
      new Coding().setSystem("http://example.org/sys").setCode("code"), new ValueSet(), new Parameters());
    cache.unload();
    assertThrows(IllegalStateException.class,
      () -> cache.cacheValidation(token, new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "v", null), false));
  }

  @Test
  void testGetExpansionAfterUnloadThrows() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    ValueSet valueSet = new ValueSet();
    valueSet.setUrl("http://example.org/vs");
    valueSet.setVersion("1.0.0");
    TerminologyCache.CacheToken token = cache.generateExpandToken(valueSet, new ExpansionOptions().withHierarchical(true));
    cache.unload();
    assertThrows(IllegalStateException.class, () -> cache.getExpansion(token));
  }

  @Test
  void testGetSubsumesAfterUnloadThrows() throws IOException {
    TerminologyCache cache = createEmptyTerminologyCache();
    TerminologyCache.CacheToken token = cache.generateSubsumesToken(CacheTestUtils.validationOptions,
      new Coding().setSystem("http://example.org/sys").setCode("parent"),
      new Coding().setSystem("http://example.org/sys").setCode("child"), new Parameters());
    cache.unload();
    assertThrows(IllegalStateException.class, () -> cache.getSubsumes(token));
  }

  private File findCacheFile(Path dir) throws IOException {
    for (File f : ManagedFileAccess.file(dir.toString()).listFiles()) {
      if (f.getName().endsWith(".cache")) {
        return f;
      }
    }
    throw new AssertionError("no .cache file found in " + dir);
  }

  private static final long HASH_JSON_SPEED_SEED = 0xC0FFEEBABEL;



  @Nested
  class HashJsonSpeedTests {
    private static Stream<Arguments> hashJsonSpeedInputs() {
      return Stream.of(
        Arguments.of(1_000_000, 1_000),
        Arguments.of(100_000, 10_000),
        Arguments.of(10_000, 100_000),
        Arguments.of(1_000, 1_000_000)
      );
    }

    TerminologyCache cache;

    @BeforeEach
    void setUp() throws IOException {
      cache = createTerminologyCache();
    }

    @ParameterizedTest
    @MethodSource("hashJsonSpeedInputs")
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testHashJsonSpeed(int inputLength, int iterations) throws IOException {
      Random random = new Random(HASH_JSON_SPEED_SEED);
      char[] chars = new char[inputLength];
      for (int i = 0; i < inputLength; i++) {
        chars[i] = (char) (random.nextInt(94) + 32); // printable ASCII range
      }
      String input = new String(chars);

      for (int i = 0; i < iterations; i++) {
        cache.hashJson(input);
      }
    }
  }
}
