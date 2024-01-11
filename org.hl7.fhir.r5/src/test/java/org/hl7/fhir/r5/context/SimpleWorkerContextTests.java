package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.*;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientR5.TerminologyClientR5Factory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.terminologies.validation.ValueSetValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleWorkerContextTests {

  private static final String DUMMY_URL = "dummyUrl";
  @Spy
  SimpleWorkerContext context;

  @Mock
  TerminologyCache terminologyCache;

  @Mock
  ToolingClientLogger txLog;

  @Mock
  ITerminologyClient terminologyClient;

  @Mock
  TerminologyCache.CacheToken cacheToken;

  @Mock
  ValidationResult expectedValidationResult;

  @Mock
  ValueSetExpansionOutcome expectedExpansionResult;

  @Mock
  ValueSetValidator valueSetCheckerSimple;

  @Mock
  ValueSetExpander valueSetExpanderSimple;

  @Mock
  Parameters pIn;

  @Mock
  Parameters expParameters;

  public static final TerminologyCapabilities terminologyCapabilities = new TerminologyCapabilities();
  static {  terminologyCapabilities.getExpansion().setParameter(Arrays.asList());}

  public static final CapabilityStatement.CapabilityStatementSoftwareComponent software = new CapabilityStatement.CapabilityStatementSoftwareComponent();
  static { software.setVersion("dummyVersion"); }

  public static final CapabilityStatement capabilitiesStatement = new CapabilityStatement();
  static { capabilitiesStatement.setSoftware(software);}

  @BeforeEach
  public void beforeEach() {

    Mockito.doReturn(DUMMY_URL).when(terminologyClient).getAddress();
    context.txCache = terminologyCache;
    context.expParameters = expParameters;
    context.terminologyClientManager.setMasterClient(terminologyClient);
    context.txLog = txLog;
  }

  private final static Map<String, String> params = new HashMap<>();
  static {
    params.put("_limit", Integer.toString(1000));
    params.put("_incomplete", "true");
  }

  private final static Parameters pInWithDependentResources = new Parameters();
  static {
    pInWithDependentResources.addParameter("includeDefinition", false);
    pInWithDependentResources.addParameter("excludeNester", false);
    pInWithDependentResources.addParameter("incomplete-ok", true);
  }

  public class ValueSetMatcher implements ArgumentMatcher<ValueSet> {

    private ValueSet left;

    ValueSetMatcher(ValueSet left) {
      this.left = left;
    }

    @Override
    public boolean matches(ValueSet right) {
      return left.getStatus().equals(right.getStatus())
        && left.getCompose().equalsDeep(right.getCompose());
    }
  }

  public class ParametersMatcher implements ArgumentMatcher<Parameters> {
    final private Parameters left;

    ParametersMatcher(Parameters left) {
      this.left = left;
    }

    @Override
    public boolean matches(Parameters right) {
      return left.equalsShallow(right);
    }
  }

  public class TerminologyClientContextMatcher implements ArgumentMatcher<TerminologyClientContext> {

    final private TerminologyClientContext left;

    TerminologyClientContextMatcher(TerminologyClientContext left) {
      this.left = left;
    }

    @Override
    public boolean matches(TerminologyClientContext argument) {
      return left.getAddress().equals(argument.getAddress());
    }
  }

  @Test
  public void testValidateCodingWithCache() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters);
    Mockito.doReturn(expectedValidationResult).when(terminologyCache).getValidation(cacheToken);

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("Coding", coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodingWithValueSetChecker() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters);

    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any(), any());
    Mockito.doReturn(expectedValidationResult).when(valueSetCheckerSimple).validateCode(eq("Coding"), any(Coding.class));

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple).validateCode("Coding", coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult,false);
  }


  @Test
  public void testValidateCodingWithServer() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false).withNoClient();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters);
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, coding);

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();

    Mockito.doReturn(expectedValidationResult).when(context).validateOnServer(terminologyClientContext, valueSet, pIn, validationOptions);

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("Coding", coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult,true);
  }

  @Test
  public void testValidateCodableConceptWithCache() throws IOException {
    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet, expParameters);
    Mockito.doReturn(expectedValidationResult).when(terminologyCache).getValidation(cacheToken);

    ValidationResult actualValidationResult = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodableConceptWithValueSetChecker() throws IOException {
    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any());
    Mockito.doReturn(expectedValidationResult).when(valueSetCheckerSimple).validateCode(eq("CodeableConcept"),any(CodeableConcept.class));

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet, expParameters);

    ValidationResult validationResultB = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(expectedValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult, false);
    Mockito.verify(context, times(0)).validateOnServer(any(), any(), any(), any());
  }


  @Test
  public void testValidateCodableConceptWithServer() throws IOException {

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    ValidationOptions validationOptions = CacheTestUtils.validationOptions.withNoClient();
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, codeableConcept);

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();

    Mockito.doReturn(expectedValidationResult).when(context).validateOnServer(terminologyClientContext, valueSet, pIn, validationOptions);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, codeableConcept, valueSet, expParameters);

    ValidationResult validationResultB = context.validateCode(validationOptions, codeableConcept, valueSet);

    assertEquals(expectedValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult, true);
    Mockito.verify(context).validateOnServer(terminologyClientContext, valueSet, pIn, validationOptions);
  }

  @Test
  public void testExpandValueSetWithCache() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().setInactive(true);
    vs.getCompose().getInclude().add(inc);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)),eq(true));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(inc, true, false);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheExpansion(any(), any(), anyBoolean());
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any(), any());
  }

  @Test
  public void testExpandValueSetWithClient() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().setInactive(true);
    vs.getCompose().getInclude().add(inc);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)),eq(true));

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();


    Mockito.doReturn(expParameters).when(context).constructParameters(argThat(new TerminologyClientContextMatcher(terminologyClientContext)),argThat(new ValueSetMatcher(vs)), eq(true));

    ValueSet expectedValueSet = new ValueSet();


    Mockito.doReturn(expectedValueSet).when(terminologyClient).expandValueset(argThat(new ValueSetMatcher(vs)),
      argThat(new ParametersMatcher(pInWithDependentResources)), eq(params));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(inc, true, false);

    assertEquals(expectedValueSet, actualExpansionResult.getValueset());

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult,true);
  }

  @Test
  public void testExpandValueSet4ArgsWithCache() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,true);
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    Parameters pIn = new Parameters();

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(vs, true,  true, true, pIn);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheExpansion(any(), any(), anyBoolean());
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any(), any());
  }

  private class ValidationOptionsFhirPublicationMatcher implements ArgumentMatcher<ValidationOptions> {

    final FhirPublication fhirPublication;

    ValidationOptionsFhirPublicationMatcher(FhirPublication fhirPublication) {
      this.fhirPublication = fhirPublication;
    }
    @Override
    public boolean matches(ValidationOptions argument) {
      return fhirPublication.toCode().equals(argument.getFhirVersion().toCode());
    }
  }

  @Test
  public void testExpandValueSet4ArgsWithValueSetExpanderSimple() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,true);

    Parameters pIn = new Parameters();

    Mockito.doReturn(vs).when(expectedExpansionResult).getValueset();

    Mockito.doReturn(expectedExpansionResult).when(valueSetExpanderSimple).expand(eq(vs),
      argThat(new ParametersMatcher(pInWithDependentResources)));

    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(argThat(new ValidationOptionsFhirPublicationMatcher(vs.getFHIRPublicationVersion())));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(vs, true,  true, true, pIn);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult, false);
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any(), any());
  }

  @Test
  public void testExpandValueSet4ArgsWithClient() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,true);

    Parameters pIn = new Parameters();

    ValueSet expectedValueSet = new ValueSet();
    expectedValueSet.setUrl("dummyUrl2");

    Mockito.doReturn(expectedExpansionResult).when(valueSetExpanderSimple).expand(eq(vs),
      argThat(new ParametersMatcher(pInWithDependentResources)));

    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(argThat(new ValidationOptionsFhirPublicationMatcher(vs.getFHIRPublicationVersion())));

    Mockito.doReturn(expectedValueSet).when(terminologyClient).expandValueset(eq(vs), argThat(new ParametersMatcher(pInWithDependentResources)), eq(params));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(vs, true,  true, true, pIn);

    assertEquals(expectedValueSet, actualExpansionResult.getValueset());

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult, true);
  }


  @Test
  public void testInitializationWithCache() {

    Mockito.doReturn(true).when(terminologyCache).hasTerminologyCapabilities();
    Mockito.doReturn(true).when(terminologyCache).hasCapabilityStatement();

    Mockito.doReturn(terminologyCapabilities).when(terminologyCache).getTerminologyCapabilities();
    Mockito.doReturn(capabilitiesStatement).when(terminologyCache).getCapabilityStatement();

    String actual = context.connectToTSServer(new TerminologyClientR5Factory(), terminologyClient, null);

    assertEquals("dummyVersion", actual);

    Mockito.verify(terminologyCache).getTerminologyCapabilities();
    Mockito.verify(terminologyCache).getCapabilityStatement();

    Mockito.verify(terminologyClient, times(0)).getTerminologyCapabilities();
    Mockito.verify(terminologyClient, times(0)).getCapabilitiesStatementQuick();

    Mockito.verify(context).setTxCaps(terminologyCapabilities);
  }

  @Test
  public void testInitializationWithClient() {

    Mockito.doReturn(false).when(terminologyCache).hasTerminologyCapabilities();
    Mockito.doReturn(false).when(terminologyCache).hasCapabilityStatement();

    Mockito.doReturn(terminologyCapabilities).when(terminologyClient).getTerminologyCapabilities();
    Mockito.doReturn(capabilitiesStatement).when(terminologyClient).getCapabilitiesStatementQuick();

    String actual = context.connectToTSServer(new TerminologyClientR5Factory(), terminologyClient, null);

    assertEquals("dummyVersion", actual);

    Mockito.verify(terminologyCache, times(0)).getTerminologyCapabilities();
    Mockito.verify(terminologyCache, times(0)).getCapabilityStatement();

    Mockito.verify(terminologyClient).getTerminologyCapabilities();
    Mockito.verify(terminologyClient).getCapabilitiesStatementQuick();

    Mockito.verify(context).setTxCaps(terminologyCapabilities);
  }

  public static Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of("zip-slip/zip-slip.zip", "Entry with an illegal path: ../evil.txt"),
      Arguments.of("zip-slip/zip-slip-2.zip", "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of("zip-slip/zip-slip-peer.zip", "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of("zip-slip/zip-slip-win.zip", "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testLoadFromClasspathZipSlip(String classPath, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {new SimpleWorkerContext.SimpleWorkerContextBuilder().fromClassPath(classPath);});
    assertNotNull(thrown);
    assertEquals(expectedMessage, thrown.getMessage());
  }

  @Test
  public void testLoadFromClasspathBinaries() throws IOException {
   SimpleWorkerContext simpleWorkerContext = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromClassPath("zip-slip/zip-normal.zip");

    final String testPath = "zip-normal/depth1/test.txt";
    assertTrue(simpleWorkerContext.getBinaryKeysAsSet().contains(testPath));
    String testFileContent = new String(simpleWorkerContext.getBinaryForKey(testPath), StandardCharsets.UTF_8);
    assertEquals("dummy file content", testFileContent);
  }
}