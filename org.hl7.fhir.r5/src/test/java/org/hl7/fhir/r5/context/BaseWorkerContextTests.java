package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.VersionResolutionRules;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.terminologies.validation.ValueSetValidator;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.UUIDUtilities;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.IPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageLoadController;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BaseWorkerContextTests {

  private static final String DUMMY_URL = "http://dummyUrl";

  @Spy
  BaseWorkerContext context = new BaseWorkerContext() {
    @Override
    public String getVersion() {
      return "4.0.1";
    }

    @Override
    public IResourceValidator newValidator() throws FHIRException {
      return null;
    }

    @Override
    public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri, VersionResolutionRules rules) {
      return null;
    }

    @Override
    public IPackageCacheManager packageManager() {
      return null;
    }

    @Override
    public void setPackageManager(IPackageCacheManager manager) {

    }

    @Override
    public PackageLoadController getPackageLoadController() {
      return null;
    }

    @Override
    public boolean canLoadPackages() {
      return false;
    }

    @Override
    public void cachePackage(PackageInformation packageInfo) {

    }

    @Override
    public List<String> getResourceNames() {
      return List.of();
    }

    @Override
    public int loadFromPackage(NpmPackage pi, IContextResourceLoader loader, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
      return 0;
    }

    @Override
    public int loadPackage(NpmPackage pi, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
      return 0;
    }

    @Override
    public int loadPackage(String idAndVer, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
      return 0;
    }

    @Override
    public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException {
      return 0;
    }

    @Override
    public List<String> getLoadedPackages() {
      return List.of();
    }

    @Override
    public boolean hasPackage(String id, String ver) {
      return false;
    }

    @Override
    public boolean hasPackage(PackageInformation pack) {
      return false;
    }

    @Override
    public PackageInformation getPackage(String id, String ver) {
      return null;
    }

    @Override
    public String getSpecUrl() {
      return "";
    }
  };

  @Mock
  TerminologyCache terminologyCache;

  @Mock
  ToolingClientLogger txLog;

  @Mock
  ITerminologyClient5 terminologyClient;

  @Mock
  TerminologyCache.CacheToken cacheToken;

  ValidationResult cachedValidationResult = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyMessageForCached", List.of());

  ValidationResult createdValidationResult = new ValidationResult(ValidationMessage.IssueSeverity.INFORMATION, "dummyMessageForCreated", List.of());

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

  private final static Parameters pInWithDependentResources = new Parameters();
  static {
    pInWithDependentResources.addParameter("includeDefinition", false);
    pInWithDependentResources.addParameter("excludeNester", false);
    pInWithDependentResources.addParameter("incomplete-ok", true);
  }

  public static class ValueSetMatcher implements ArgumentMatcher<ValueSet> {

    private final ValueSet left;

    ValueSetMatcher(ValueSet left) {
      this.left = left;
    }

    @Override
    public boolean matches(ValueSet right) {
      return left.getStatus().equals(right.getStatus())
        && left.getCompose().equalsDeep(right.getCompose());
    }
  }

  public static class ExpansionOptionsMatcher implements ArgumentMatcher<ExpansionOptions> {

    private final ExpansionOptions left;

    ExpansionOptionsMatcher(ExpansionOptions left) {
      this.left = left;
    }

    @Override
    public boolean matches(ExpansionOptions right) {
      return left.isHierarchical() == right.isHierarchical()
        && left.isIncompleteOk() == right.isIncompleteOk()
        && left.getMaxCount() == right.getMaxCount()
        && left.isCacheOk() == right.isCacheOk()
        && (left.hasLanguage()
        ? left.getLanguage().equals(right.getLanguage())
        : !right.hasLanguage());
    }
  }

  public static class CodingMatcher implements ArgumentMatcher<Coding> {
    final private Coding left;

    CodingMatcher(Coding left) { this.left = left; }

    public boolean matches(Coding right) {
      return left.equalsShallow(right);
    }
  }

  public static class ParametersMatcher implements ArgumentMatcher<Parameters> {
    final private Parameters left;

    ParametersMatcher(Parameters left) {
      this.left = left;
    }

    @Override
    public boolean matches(Parameters right) {
      return left.equalsShallow(right);
    }
  }

  public static class TerminologyClientContextMatcher implements ArgumentMatcher<TerminologyClientContext> {

    final private TerminologyClientContext left;

    TerminologyClientContextMatcher(TerminologyClientContext left) {
      this.left = left;
    }

    @Override
    public boolean matches(TerminologyClientContext argument) {
      return left.getAddress().equals(argument.getAddress());
    }
  }

  @BeforeEach
  public void beforeEach() throws IOException {

    Mockito.doReturn(DUMMY_URL).when(terminologyClient).getAddress();
    context.initTxCache(terminologyCache);
    context.expansionParameters = new AtomicReference<>(expParameters);
    context.terminologyClientManager.setMasterClient(terminologyClient, null);
    context.txLog = txLog;
  }

  public BaseWorkerContextTests() throws IOException {
  }

  private BaseWorkerContext getBaseWorkerContext() throws IOException {
    BaseWorkerContext baseWorkerContext = new BaseWorkerContext() {
      @Override
      public String getVersion() {
        return null;
      }

      @Override
      public IResourceValidator newValidator() throws FHIRException {
        return null;
      }

      @Override
      public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri, VersionResolutionRules rules) {
        return null;
      }

      @Override
      public IPackageCacheManager packageManager() {
        return null;
      }

      @Override
      public void setPackageManager(IPackageCacheManager manager) {

      }

      @Override
      public PackageLoadController getPackageLoadController() {
        return null;
      }

      @Override
      public boolean canLoadPackages() {
        return false;
      }

      @Override
      public void cachePackage(PackageInformation packageInfo) {

      }

      @Override
      public List<String> getResourceNames() {
        return null;
      }

      @Override
      public int loadFromPackage(NpmPackage pi, IContextResourceLoader loader, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public int loadPackage(NpmPackage pi, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public int loadPackage(String idAndVer, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public List<String> getLoadedPackages() {
        return List.of();
      }

      @Override
      public boolean hasPackage(String id, String ver) {
        return false;
      }

      @Override
      public boolean hasPackage(PackageInformation pack) {
        return false;
      }

      @Override
      public PackageInformation getPackage(String id, String ver) {
        return null;
      }

      @Override
      public String getSpecUrl() {
        return null;
      }

      @Override
      public <T extends Resource> List<T> fetchResourceVersions(Class<T> class_, String url) {
        return new ArrayList<>();
      }

    };
    baseWorkerContext.expansionParameters = new AtomicReference<>(new Parameters());
    return baseWorkerContext;
  }

  @Test
  public void testAddServerValidationParametersDisplayWarning() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())).setDisplayWarningMode(true));
    assertEquals("lenient-display-validation", pin.getParameter("mode").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersVsAsUrl() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet().setUrl("http://dummy.org/vs"), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())).setVsAsUrl(true));
    assertEquals("uri", pin.getParameter("url").getValue().fhirType());
    assertEquals("http://dummy.org/vs", pin.getParameter("url").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersDisplayError() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())));
    assertNull(pin.getParameter("mode"));
  }

  @Test
  public void testValidateCodingWithCache() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters, "Coding");
    Mockito.doReturn(cachedValidationResult).when(terminologyCache).getValidation(cacheToken);

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(cachedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("Coding", coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodingWithValueSetChecker() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    valueSet.setUrl(UUIDUtilities.makeUuidUrn());
    Coding coding = new Coding();
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters, "Coding");

    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any(), any());
    Mockito.doReturn(createdValidationResult).when(valueSetCheckerSimple).validateCode(eq("Coding"), any(Coding.class));

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(createdValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple).validateCode(eq("Coding"), argThat(new CodingMatcher(coding)));
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(eq(cacheToken), same(createdValidationResult),eq(false));

  }


  @Test
  public void testValidateCodingWithServer() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5).withGuessSystem().withVersionFlexible(false).withNoClient();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet, expParameters, "Coding");
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, coding);

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();

    Mockito.doReturn(createdValidationResult).when(context).validateOnServer2(same(terminologyClientContext), same(valueSet), same(pIn), same(validationOptions), eq(Collections.emptySet()));

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(createdValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("Coding", coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(eq(cacheToken), same(createdValidationResult),eq(true));
  }

  @Test
  public void testValidateCodableConceptWithCache() throws IOException {
    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet, expParameters);
    Mockito.doReturn(cachedValidationResult).when(terminologyCache).getValidation(cacheToken);

    ValidationResult actualValidationResult = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(cachedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodableConceptWithValueSetChecker() throws IOException {
    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any());
    Mockito.doReturn(createdValidationResult).when(valueSetCheckerSimple).validateCode(eq("CodeableConcept"),any(CodeableConcept.class));

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet, expParameters);

    ValidationResult validationResultB = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(createdValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(eq(cacheToken), same(createdValidationResult), eq(false));
    Mockito.verify(context, times(0)).validateOnServer2(any(), any(), any(), any(), any());
  }


  @Test
  public void testValidateCodeableConceptWithServer() throws IOException {

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    ValidationOptions validationOptions = CacheTestUtils.validationOptions.withNoClient();
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, codeableConcept);

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();

    Mockito.doReturn(createdValidationResult).when(context).validateOnServer2(same(terminologyClientContext), same(valueSet), same(pIn),same(validationOptions), eq(Collections.emptySet()));
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, codeableConcept, valueSet, expParameters);

    ValidationResult validationResultB = context.validateCode(validationOptions, codeableConcept, valueSet);

    assertSame(createdValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode("CodeableConcept", codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(eq(cacheToken), same(createdValidationResult), eq(true));
    Mockito.verify(context).validateOnServer2(same(terminologyClientContext), same(valueSet), same(pIn), same(validationOptions), eq(Collections.emptySet()));
  }

  @Test
  public void testExpandValueSetWithCache() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().setInactive(true);
    vs.getCompose().getInclude().add(inc);

    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true);


    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)), argThat(new ExpansionOptionsMatcher(opt)));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(null, inc, true, false);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheExpansion(any(), any(), anyBoolean());
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any());
  }

  @Test
  public void testExpandValueSetWithClient() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().setInactive(true);
    vs.getCompose().getInclude().add(inc);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true);


    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)),argThat(new ExpansionOptionsMatcher(opt)));

    TerminologyClientContext terminologyClientContext = context.getTxClientManager().getMaster();

    Mockito.doReturn(expParameters).when(context).constructParameters(any(), argThat(new TerminologyClientContextMatcher(terminologyClientContext)),argThat(new ValueSetMatcher(vs)), eq(true));

    ValueSet expectedValueSet = new ValueSet();

    Mockito.doReturn(expectedValueSet).when(terminologyClient).expandValueset(argThat(new ValueSetMatcher(vs)),
      argThat(new ParametersMatcher(pInWithDependentResources)));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(null, inc, true, false);

    assertEquals(expectedValueSet, actualExpansionResult.getValueset());

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult,true);
  }

  @Test
  void testExpandValueSetDeprecated() {
    assertDoesNotThrow(() -> {

      ValueSet vs = new ValueSet();
      vs.setUrl(DUMMY_URL);

      //This is the ExpansionOptions as it should be generated for the deprecated method
      ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true).withIncompleteOk(true).withMaxCount(0);

      //This is the actual test. The ExpansionOptions generated should match the one above, and the rest of the test
      //should then be able to run without exception.
      Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), argThat(new ExpansionOptionsMatcher(opt)));
      Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

      Parameters pIn = new Parameters();

      context.expandVS(vs, true, true, true, pIn);
    });

  }


  @Test
  public void testExpandValueSetWithOptionsWithCache() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,opt);
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    Parameters pIn = new Parameters();

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(opt, vs, pIn, false);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheExpansion(any(), any(), anyBoolean());
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any());
  }

  private static class ValidationOptionsFhirPublicationMatcher implements ArgumentMatcher<ValidationOptions> {

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
  public void testExpandValueSetWithOptionsWithValueSetExpanderSimple() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,opt);

    Parameters pIn = new Parameters();

    Mockito.doReturn(vs).when(expectedExpansionResult).getValueset();

    Mockito.doReturn(expectedExpansionResult).when(valueSetExpanderSimple).expand(eq(vs),
      argThat(new ParametersMatcher(pInWithDependentResources)));

    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(argThat(new ValidationOptionsFhirPublicationMatcher(vs.getFHIRPublicationVersion())));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(opt, vs, pIn, false);

    assertEquals(expectedExpansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult, false);
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any());
  }

  @Test
  public void testExpandValueSetWithOptionsWithClient() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(vs,opt);

    Parameters pIn = new Parameters();

    ValueSet expectedValueSet = new ValueSet();
    expectedValueSet.setUrl("dummyUrl2");

    Mockito.doReturn(expectedExpansionResult).when(valueSetExpanderSimple).expand(eq(vs),
      argThat(new ParametersMatcher(pInWithDependentResources)));

    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(argThat(new ValidationOptionsFhirPublicationMatcher(vs.getFHIRPublicationVersion())));

    Mockito.doReturn(expectedValueSet).when(terminologyClient).expandValueset(eq(vs), argThat(new ParametersMatcher(pInWithDependentResources)));

    ValueSetExpansionOutcome actualExpansionResult = context.expandVS(opt, vs, pIn, false);

    assertEquals(expectedValueSet, actualExpansionResult.getValueset());

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult, true);
  }

  @Test
  void setLocaleSetsDefaultDisplayLanguageIfNoDisplayLanguage() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameter().size()).isEqualTo(1);
    assertThat(actualParameters.getParameter().get(0).getName()).isEqualTo("defaultDisplayLanguage");
    assertThat(actualParameters.getParameter().get(0).getValue().toString()).isEqualTo(Locale.CHINA.toLanguageTag());
  }

  @Test
  void setLocaleResetsDisplayLanguageIfSetAutomatically() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters expansionParameters = new Parameters();
    expansionParameters.addParameter().setName("displayLanguage").setValue(new CodeType(Locale.FRANCE.toLanguageTag())).setUserData(UserDataNames.auto_added_parameter, "groovy");
    baseWorkerContext.expansionParameters = new AtomicReference<>(expansionParameters);

    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameter().size()).isEqualTo(1);
    assertThat(actualParameters.getParameter().get(0).getName()).isEqualTo("displayLanguage");
    assertThat(actualParameters.getParameter().get(0).getValue().toString()).isEqualTo(Locale.CHINA.toLanguageTag());
  }

  @Test
  void setLocaleDoesntChangeDisplayLanguageIfNotSetAutomatically() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters expansionParameters = new Parameters();
    expansionParameters.addParameter().setName("displayLanguage").setValue(new CodeType(Locale.FRANCE.toLanguageTag()));
    baseWorkerContext.expansionParameters = new AtomicReference<>(expansionParameters);
    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameter().size()).isEqualTo(1);
    assertThat(actualParameters.getParameter().get(0).getName()).isEqualTo("displayLanguage");
    assertThat(actualParameters.getParameter().get(0).getValue().toString()).isEqualTo(Locale.FRANCE.toLanguageTag());

  }

  @Test
  void setLocaleDoesNotCreateDuplicateParams() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    for (int i = 0; i < 10; i++) {
      baseWorkerContext.setLocale(Locale.US);
      Parameters actualParameters = baseWorkerContext.getExpansionParameters();
      assertThat(actualParameters.getParameter().size()).isEqualTo(1);
      assertThat(actualParameters.getParameter().get(0).getName()).isEqualTo("defaultDisplayLanguage");
      assertThat(actualParameters.getParameter().get(0).getValue().toString()).isEqualTo("en-US");
    }
  }

  @Test
  void expansionParametersMultithreadTest() throws IOException {
    final BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    List<Thread> threads = new ArrayList<>();
    final AtomicInteger successCount = new AtomicInteger(0);
    final List<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());
    Locale[] locales = {
      Locale.CANADA,
      Locale.FRANCE,
      Locale.US,
      Locale.CHINA,
      Locale.ITALY,
      Locale.JAPAN,
      Locale.TAIWAN
    };
    Random rand = new Random();
    final int numberOfThreads = 1000;
    for (int i = 0; i < numberOfThreads; i++) {
      int threadIndex = i;
      Thread t = new Thread(() -> {
        try {
          if (rand.nextInt(2) == 0) {
            Locale locale = locales[rand.nextInt(locales.length)];
            for (int j = 0; j < 300; j++) {
              baseWorkerContext.setLocale(locale);
            }
            System.out.println("Set Locale ["+ threadIndex +"]: " + locale.toLanguageTag());
          } else {
            Parameters parameters = baseWorkerContext.getExpansionParameters();
            for (Parameters.ParametersParameterComponent component : parameters.getParameter()) {
              // DO NOTHING
            }
            System.out.println("Read Params [" + threadIndex + "]");
          }
          successCount.incrementAndGet();
        } catch (Exception e) {
          exceptions.add(e);
        }
      });
      threads.add(t);
    }

    threads.forEach(Thread::start);
    threads.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
      }
    });
    assertThat(exceptions).isEmpty();
    assertThat(successCount.get()).isEqualTo(numberOfThreads);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = "1.0")
  void externalLookupPreservesOptionalVersion(String version) {
    assertExternalLookupVersion(version, false);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = "1.0")
  void externalLookupWithSourcePreservesOptionalVersion(String version) {
    assertExternalLookupVersion(version, true);
  }

  private void assertExternalLookupVersion(String version, boolean withSource) {
    String url = "http://example.org/CodeSystem/versioned";
    String canonical = version == null ? url : url + "|" + version;
    CodeSystem cs = new CodeSystem().setUrl(url).setVersion(version);
    Mockito.when(terminologyCache.hasCodeSystem(canonical)).thenReturn(true);
    Mockito.when(terminologyCache.getCodeSystem(canonical))
        .thenReturn(new TerminologyCache.SourcedCodeSystem("https://tx.example.org/r4", cs));
    CodeSystem result = withSource
        ? context.findTxResource(CodeSystem.class, url, VersionResolutionRules.defaultRule(), version, new ValueSet())
        : context.findTxResource(CodeSystem.class, url, VersionResolutionRules.defaultRule(), version);
    assertSame(cs, result);
    Mockito.verify(terminologyCache).getCodeSystem(canonical);
  }

  // ---- validateCodeBatch against servers without CodeSystem/$batch-validate-code (e.g. tx-nordics) ----

  private static final String SCT = "http://snomed.info/sct";
  private static final String SCT_DK = "http://snomed.info/sct/554471000005108";

  private static Coding coding(String system, String version, String code) {
    Coding c = new Coding().setSystem(system).setCode(code);
    if (version != null) {
      c.setVersion(version);
    }
    return c;
  }

  /** what tx-nordics answers per entry of CodeSystem/$batch-validate-code: an OperationOutcome, not a Parameters */
  private static Parameters unsupportedCodeSystemBatch(int size) {
    Parameters p = new Parameters();
    for (int i = 0; i < size; i++) {
      OperationOutcome oo = new OperationOutcome();
      oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.PROCESSING)
          .getDetails().setText("Unable to find code to validate (looked for coding | codeableConcept | code+system | code+inferSystem in parameters)");
      p.addParameter().setName("validation").setResource(oo);
    }
    return p;
  }

  /** a ValueSet batch answer that echoes the system and code of each request, as the batch contract requires */
  private static Parameters validBatchFor(CodingValidationRequest... requests) {
    Parameters p = new Parameters();
    for (CodingValidationRequest r : requests) {
      Parameters one = new Parameters();
      one.addParameter("result", true);
      one.addParameter("system", new UriType(r.getCoding().getSystem()));
      one.addParameter("code", new CodeType(r.getCoding().getCode()));
      p.addParameter().setName("validation").setResource(one);
    }
    return p;
  }

  private static String urlOf(Parameters batch) {
    Parameters.ParametersParameterComponent url = batch.getParameter("url");
    assertNotNull(url, "the ValueSet batch must name its value set");
    // HAPI servers (tx-nordics) answer HTTP 400 HAPI-0362 to a string where a uri is expected
    assertInstanceOf(UriType.class, url.getValue());
    return url.getValue().primitiveValue();
  }

  private ValidationOptions batchOptions() {
    // the mocked expParameters answers copy() with null, which constructParameters() needs to work
    context.expansionParameters = new AtomicReference<>(new Parameters());
    return new ValidationOptions(FhirPublication.R5).withNoClient();
  }

  @Test
  public void testValidateCodeBatchRetriesSnomedAgainstTheEditionOfTheCoding() {
    CodingValidationRequest danishOnly = new CodingValidationRequest(coding(SCT, SCT_DK, "554221000005108"));
    CodingValidationRequest danishToo = new CodingValidationRequest(coding(SCT, SCT_DK, "400975005"));
    Mockito.doReturn(unsupportedCodeSystemBatch(2)).when(terminologyClient).batchValidateCS(any());
    Mockito.doReturn(validBatchFor(danishOnly, danishToo)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(danishOnly, danishToo), null, false);

    org.mockito.ArgumentCaptor<Parameters> sent = org.mockito.ArgumentCaptor.forClass(Parameters.class);
    Mockito.verify(terminologyClient, times(1)).batchValidateVS(sent.capture());
    // the bare http://snomed.info/sct?fhir_vs is the international edition, which does not know Danish codes
    assertEquals(SCT_DK + "?fhir_vs", urlOf(sent.getValue()));
    assertEquals(2, sent.getValue().getParameters("validation").size());
    assertTrue(danishOnly.getResult().isOk());
    assertTrue(danishToo.getResult().isOk());
  }

  @Test
  public void testValidateCodeBatchRetriesAgainstTheImplicitValueSetOfTheSystemWithoutVersion() {
    CodingValidationRequest request = new CodingValidationRequest(coding(SCT, null, "271649006"));
    Mockito.doReturn(unsupportedCodeSystemBatch(1)).when(terminologyClient).batchValidateCS(any());
    Mockito.doReturn(validBatchFor(request)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), null, false);

    org.mockito.ArgumentCaptor<Parameters> sent = org.mockito.ArgumentCaptor.forClass(Parameters.class);
    Mockito.verify(terminologyClient).batchValidateVS(sent.capture());
    assertEquals(SCT + "?fhir_vs", urlOf(sent.getValue()));
    assertTrue(request.getResult().isOk());
  }

  @Test
  public void testValidateCodeBatchDoesNotTurnAVersionThatIsNotAnEditionIntoAnEditionUrl() {
    // a plain release version is not an edition URI, and must not be glued on to the implicit value set
    CodingValidationRequest request = new CodingValidationRequest(coding("http://loinc.org", "2.77", "718-7"));
    Mockito.doReturn(unsupportedCodeSystemBatch(1)).when(terminologyClient).batchValidateCS(any());
    Mockito.doReturn(validBatchFor(request)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), null, false);

    org.mockito.ArgumentCaptor<Parameters> sent = org.mockito.ArgumentCaptor.forClass(Parameters.class);
    Mockito.verify(terminologyClient).batchValidateVS(sent.capture());
    assertEquals("http://loinc.org?fhir_vs", urlOf(sent.getValue()));
  }

  @Test
  public void testValidateCodeBatchGroupsTheRetryPerImplicitValueSet() {
    CodingValidationRequest dk = new CodingValidationRequest(coding(SCT, SCT_DK, "554221000005108"));
    CodingValidationRequest international = new CodingValidationRequest(coding(SCT, null, "271649006"));
    Mockito.doReturn(unsupportedCodeSystemBatch(2)).when(terminologyClient).batchValidateCS(any());
    Mockito.doReturn(validBatchFor(dk)).doReturn(validBatchFor(international)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(dk, international), null, false);

    org.mockito.ArgumentCaptor<Parameters> sent = org.mockito.ArgumentCaptor.forClass(Parameters.class);
    Mockito.verify(terminologyClient, times(2)).batchValidateVS(sent.capture());
    assertEquals(SCT_DK + "?fhir_vs", urlOf(sent.getAllValues().get(0)));
    assertEquals(SCT + "?fhir_vs", urlOf(sent.getAllValues().get(1)));
    assertTrue(dk.getResult().isOk());
    assertTrue(international.getResult().isOk());
  }

  @Test
  public void testValidateCodeBatchDoesNotRetryWhatTheCodeSystemBatchAnswered() {
    CodingValidationRequest request = new CodingValidationRequest(coding(SCT, SCT_DK, "554221000005108"));
    Mockito.doReturn(validBatchFor(request)).when(terminologyClient).batchValidateCS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), null, false);

    Mockito.verify(terminologyClient, never()).batchValidateVS(any());
    assertTrue(request.getResult().isOk());
  }

  @Test
  public void testValidateCodeBatchKeepsTheOriginalErrorIfTheRetryFails() {
    CodingValidationRequest request = new CodingValidationRequest(coding(SCT, SCT_DK, "554221000005108"));
    Mockito.doReturn(unsupportedCodeSystemBatch(1)).when(terminologyClient).batchValidateCS(any());
    // EFhirClientException is a RuntimeException, not a FHIRException
    Mockito.doThrow(new RuntimeException("HTTP 400 HAPI-0362")).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), null, false);

    assertFalse(request.getResult().isOk());
    assertThat(request.getResult().getMessage()).contains("Unable to find code to validate");
  }

  @Test
  public void testValidateCodeBatchKeepsTheOriginalErrorIfTheRetryAnswersWithAnotherError() {
    CodingValidationRequest request = new CodingValidationRequest(coding("http://npu-terminology.org", null, "NPU27280"));
    Mockito.doReturn(unsupportedCodeSystemBatch(1)).when(terminologyClient).batchValidateCS(any());
    Mockito.doReturn(unsupportedCodeSystemBatch(1)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), null, false);

    assertFalse(request.getResult().isOk());
  }

  @Test
  public void testValidateCodeBatchWithValueSetIsNotRetried() {
    // with a value set the batch already is a ValueSet batch: nothing falls back to anything
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/ValueSet/vs");
    CodingValidationRequest request = new CodingValidationRequest(coding(SCT, SCT_DK, "554221000005108"));
    Mockito.doReturn(validBatchFor(request)).when(terminologyClient).batchValidateVS(any());

    context.validateCodeBatch(batchOptions(), List.of(request), vs, false);

    Mockito.verify(terminologyClient, times(1)).batchValidateVS(any());
    Mockito.verify(terminologyClient, never()).batchValidateCS(any());
  }
}
