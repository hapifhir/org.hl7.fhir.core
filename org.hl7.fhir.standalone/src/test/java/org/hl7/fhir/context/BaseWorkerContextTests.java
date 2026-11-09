package org.hl7.fhir.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.client.EFhirClientException;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.services.context.IContextResourceLoaderN;
import org.hl7.fhir.services.terminology.*;
import org.hl7.fhir.services.validation.IResourceValidator;
import org.hl7.fhir.standalone.context.BaseWorkerContext;
import org.hl7.fhir.standalone.terminology.expansion.ValueSetExpander;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyCache;
import org.hl7.fhir.standalone.terminology.validation.VSCheckerException;
import org.hl7.fhir.standalone.terminology.validation.ValueSetValidator;
import org.hl7.fhir.model.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.UUIDUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.IPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageLoadController;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.standalone.terminology.client.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.hl7.fhir.model.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.provider.MethodSource;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class BaseWorkerContextTests {

  private static final String DUMMY_URL = "http://dummyUrl";

  @Spy
  BaseWorkerContext context = new BaseWorkerContext(ModelContext.fullCoreContext()) {
    @Override
    public String getFHIRVersion() {
      return "4.0.1";
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
    public IResourceValidator newValidator() throws FHIRException {
      return null;
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
    public int loadFromPackage(NpmPackage pi, IContextResourceLoaderN loader, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
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
    public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoaderN loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException {
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
  ITerminologyClientN terminologyClient;

  @Mock
  CacheToken cacheToken;

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
  static {  terminologyCapabilities.getExpansion().setParameterList(Arrays.asList());}

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
    context.setExpansionParameters(new AtomicReference<>(expParameters));
    context.getTerminologyClientManager().setMasterClient(terminologyClient, null);
    context.setTxLog(txLog);
  }

  public BaseWorkerContextTests() throws IOException {
  }

  private BaseWorkerContext getBaseWorkerContext() throws IOException {
    BaseWorkerContext baseWorkerContext = new BaseWorkerContext(ModelContext.fullCoreContext()) {
      @Override
      public String getFHIRVersion() {
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
      public IResourceValidator newValidator() throws FHIRException {
        return null;
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
      public int loadFromPackage(NpmPackage pi, IContextResourceLoaderN loader, boolean isMaster) throws FileNotFoundException, IOException, FHIRException {
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
      public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoaderN loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException {
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
    baseWorkerContext.setExpansionParameters(new AtomicReference<>(new Parameters()));
    return baseWorkerContext;
  }

  @Test
  public void testAddServerValidationParametersDisplayWarning() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getFHIRVersion())).setDisplayWarningMode(true));
    assertEquals("lenient-display-validation", pin.getParameter("mode").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersVsAsUrl() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet().setUrl("http://dummy.org/vs"), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getFHIRVersion())).setVsAsUrl(true));
    assertEquals("uri", pin.getParameter("url").getValue().fhirType());
    assertEquals("http://dummy.org/vs", pin.getParameter("url").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersDisplayError() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(null, baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getFHIRVersion())));
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

  private static final String UNKNOWN_SYSTEM = "http://example.org/unknown-system";

  /**
   * Set up a code from a system that neither the context nor the server knows, as the renderers ask
   * for displays: no value set, and the local check throws to the server
   */
  private ValidationOptions setUpUnknownSystem() {
    ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R5);
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(same(validationOptions), any(Coding.class), isNull(), any(), eq("Coding"));
    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), isNull(), any());
    AtomicReference<Set<String>> unknownSystems = new AtomicReference<>();
    Mockito.doAnswer(inv -> {
      unknownSystems.set(inv.getArgument(0));
      return null;
    }).when(valueSetCheckerSimple).setUnknownSystems(any());
    Mockito.doAnswer(inv -> {
      unknownSystems.get().add(UNKNOWN_SYSTEM);
      throw new VSCheckerException("A definition for CodeSystem '" + UNKNOWN_SYSTEM + "' could not be found, so the code cannot be validated", new ArrayList<>(), TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
    }).when(valueSetCheckerSimple).validateCode(eq("Coding"), any(Coding.class));
    return validationOptions;
  }

  private static ValidationResult unknownSystemAnswer() {
    ValidationResult res = new ValidationResult(ValidationMessage.IssueSeverity.ERROR, "A definition for CodeSystem '" + UNKNOWN_SYSTEM + "' could not be found", TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, new ArrayList<>());
    res.setUnknownSystems(new HashSet<>(Set.of(UNKNOWN_SYSTEM)));
    return res;
  }

  @Test
  void unknownCodeSystemIsOnlyAskedAboutOnce() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    Mockito.doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), isNull(), any(), any(), any());

    ValidationResult first = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);
    ValidationResult second = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "b", null), null, null);
    ValidationResult third = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);

    Mockito.verify(context, times(1)).validateOnServer2(any(), isNull(), any(), any(), any());
    // the local warning, as without the shortcut
    String localWarning = "A definition for CodeSystem '" + UNKNOWN_SYSTEM + "' could not be found, so the code cannot be validated";
    assertEquals(localWarning, first.getMessage());
    assertEquals("Local Warning: " + localWarning + ". Server Error: " + localWarning, first.getDiagnostics());
    for (ValidationResult res : List.of(first, second, third)) {
      assertEquals(ValidationMessage.IssueSeverity.WARNING, res.getSeverity());
      assertEquals(first.getMessage(), res.getMessage());
      assertEquals(first.getDiagnostics(), res.getDiagnostics());
      assertNull(res.getErrorClass());
    }
    // the answer is held for this run only: it isn't put in the terminology cache
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  void failedRequestAboutUnknownCodeSystemIsAskedAgain() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    Mockito.doThrow(new FHIRException("Read timed out")).doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), isNull(), any(), any(), any());

    ValidationResult failed = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);
    assertEquals(TerminologyServiceErrorClass.SERVER_ERROR, failed.getErrorClass());
    ValidationResult answered = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "b", null), null, null);
    assertEquals(ValidationMessage.IssueSeverity.WARNING, answered.getSeverity());
    Mockito.verify(context, times(2)).validateOnServer2(any(), isNull(), any(), any(), any());

    // the real answer is remembered
    context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "c", null), null, null);
    Mockito.verify(context, times(2)).validateOnServer2(any(), isNull(), any(), any(), any());
  }

  @Test
  void unknownCodeSystemIsAskedAgainForAVersion() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    Mockito.doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), isNull(), any(), any(), any());
    context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);
    context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null).setVersion("1.0"), null, null);

    Mockito.verify(context, times(2)).validateOnServer2(any(), isNull(), any(), any(), any());
  }

  private ValueSet unknownSystemValueSet(ValidationOptions validationOptions, ValueSetValidator checker) {
    ValueSet valueSet = new ValueSet();
    valueSet.setUrl("http://example.org/vs");
    valueSet.getCompose().addInclude().setSystem(UNKNOWN_SYSTEM);
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(same(validationOptions), any(Coding.class), same(valueSet), any(), eq("Coding"));
    Mockito.doReturn(checker).when(context).constructValueSetCheckerSimple(any(), same(valueSet), any());
    return valueSet;
  }

  @Test
  void unknownCodeSystemWithAValueSetKeepsTheError() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    Mockito.doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), isNull(), any(), any(), any());
    context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);

    ValueSet valueSet = unknownSystemValueSet(validationOptions, valueSetCheckerSimple);
    ValidationResult res = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "b", null), valueSet, null);

    assertEquals(ValidationMessage.IssueSeverity.ERROR, res.getSeverity());
    assertEquals(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, res.getErrorClass());
    Mockito.verify(context, Mockito.never()).validateOnServer2(any(), same(valueSet), any(), any(), any());
  }

  @Test
  void unknownCodeSystemWithoutALocalCheckKeepsTheError() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    Mockito.doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), isNull(), any(), any(), any());
    context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), null, null);

    // no local check, so no local warning to give
    ValidationOptions noClient = validationOptions.withNoClient();
    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(same(noClient), any(Coding.class), isNull(), any(), eq("Coding"));
    ValidationResult res = context.validateCode(noClient, new Coding(UNKNOWN_SYSTEM, "b", null), null, null);

    assertEquals(ValidationMessage.IssueSeverity.ERROR, res.getSeverity());
    assertEquals(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, res.getErrorClass());
    Mockito.verify(context, times(1)).validateOnServer2(any(), isNull(), any(), any(), any());
  }

  @Test
  void unknownCodeSystemFirstSeenWithAValueSetGetsTheWarningWithoutOne() throws IOException {
    ValidationOptions validationOptions = setUpUnknownSystem();
    // checked against a value set first: the local check hands it to the server, which doesn't know the
    // system, so the system is recorded as unsupported
    ValueSetValidator valueSetChecker = Mockito.mock(ValueSetValidator.class);
    Mockito.doThrow(new FHIRException(ValueSetValidator.NO_TRY_THE_SERVER)).when(valueSetChecker).validateCode(eq("Coding"), any(Coding.class));
    ValueSet valueSet = unknownSystemValueSet(validationOptions, valueSetChecker);
    Mockito.doReturn(unknownSystemAnswer()).when(context).validateOnServer2(any(), same(valueSet), any(), any(), any());
    ValidationResult withValueSet = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "a", null), valueSet, null);
    assertEquals(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, withValueSet.getErrorClass());

    // then against no value set: the warning the server would have given, without asking it
    ValidationResult res = context.validateCode(validationOptions, new Coding(UNKNOWN_SYSTEM, "b", null), null, null);

    String localWarning = "A definition for CodeSystem '" + UNKNOWN_SYSTEM + "' could not be found, so the code cannot be validated";
    assertEquals(ValidationMessage.IssueSeverity.WARNING, res.getSeverity());
    assertEquals(localWarning, res.getMessage());
    assertEquals("Local Warning: " + localWarning + ". Server Error: " + localWarning, res.getDiagnostics());
    assertNull(res.getErrorClass());
    Mockito.verify(context, Mockito.never()).validateOnServer2(any(), isNull(), any(), any(), any());
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
    vs.getCompose().getIncludeList().add(inc);

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
    vs.getCompose().getIncludeList().add(inc);
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

  private static OperationOutcome serverError(OperationOutcome.IssueType type, String text) {
    OperationOutcome oo = new OperationOutcome();
    oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(type).getDetails().setText(text);
    return oo;
  }

  private static EFhirClientException status(int code) {
    // the way the client reports an error page from a proxy or gateway: an 'exception' issue with only a text
    return new EFhirClientException(code, "HTTP " + code, OperationOutcomeUtilities.createError("<html><body>" + code + "</body></html>"));
  }

  /**
   * $expand failures where the server couldn't be reached just then
   */
  static List<Exception> unavailableFailures() {
    return List.of(
      new FHIRException(new java.net.SocketTimeoutException("timed out")), // as the R5 client reports it
      new EFhirClientException(0, "timed out", new EFhirClientException(0, "timed out", new java.net.SocketTimeoutException("timed out"))), // the R4 client
      new FHIRException(new java.net.ConnectException("connection refused")),
      status(408), status(429), status(502), status(503), status(504));
  }

  /**
   * $expand failures that are the server's answer, so they are kept for later runs
   */
  static List<Exception> serverAnswers() {
    return List.of(
      // how FHIRsmith reports a failure it didn't anticipate
      new EFhirClientException(500, "Error from server: unexpected", OperationOutcomeUtilities.createError("Unexpected error expanding the value set")),
      new EFhirClientException(404, "unknown value set", serverError(OperationOutcome.IssueType.NOTFOUND, "unknown value set")),
      // there was a response, so its status decides
      new EFhirClientException(500, "Error reading Http Response", new IOException("unexpected end of stream")),
      new EFhirClientException(401, "unauthorized"));
  }

  private interface Expansion {
    ValueSetExpansionOutcome expand() throws IOException;
  }

  /**
   * With a real cache: a failed $expand is answered from the cache for the rest of the run. A new cache on the same
   * folder (the next run) has it only if it was the server's answer.
   */
  private void expandTwiceThenReload(Exception failure, boolean expectReloaded, java.nio.file.Path folder, Expansion expansion,
                                     java.util.function.Function<TerminologyCache, CacheToken> token) throws IOException {
    TerminologyCache cache = new TerminologyCache(new Object(), folder.toString(), context);
    context.initTxCache(cache);
    Mockito.doThrow(failure).when(terminologyClient).expandValueset(any(), any(Parameters.class));

    ValueSetExpansionOutcome res = expansion.expand();
    assertNull(res.getValueset());
    assertEquals(!expectReloaded, res.getErrorClass() == TerminologyServiceErrorClass.SERVER_ERROR, "error class " + res.getErrorClass());
    assertSame(res, expansion.expand());
    Mockito.verify(terminologyClient, times(1)).expandValueset(any(), any(Parameters.class));
    cache.save();

    TerminologyCache next = new TerminologyCache(new Object(), folder.toString(), context);
    ValueSetExpansionOutcome reloaded = next.getExpansion(token.apply(next));
    if (expectReloaded) {
      assertNotNull(reloaded);
      assertEquals(res.getError(), reloaded.getError());
      assertEquals(res.getErrorClass(), reloaded.getErrorClass());
    } else {
      assertNull(reloaded);
    }
  }

  private void expandIncludeTwiceThenReload(Exception failure, boolean expectReloaded, java.nio.file.Path folder) throws IOException {
    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent().setSystem("http://example.org/cs");
    Mockito.doReturn(new Parameters()).when(context).constructParameters(any(), any(), any(ValueSet.class), anyBoolean());
    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().setInactive(true);
    vs.getCompose().getIncludeList().add(inc);
    expandTwiceThenReload(failure, expectReloaded, folder, () -> context.expandVS(null, inc, true, false),
      cache -> cache.generateExpandToken(vs, new ExpansionOptions().withHierarchical(true)));
  }

  @ParameterizedTest
  @MethodSource("unavailableFailures")
  void testExpandIncludeUnavailableIsForThisRun(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandIncludeTwiceThenReload(failure, false, folder);
  }

  @ParameterizedTest
  @MethodSource("serverAnswers")
  void testExpandIncludeServerAnswerIsReloaded(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandIncludeTwiceThenReload(failure, true, folder);
  }

  private void expandUrlTwiceThenReload(Exception failure, boolean expectReloaded, java.nio.file.Path folder) throws IOException {
    // an https master, so chooseServer(url) finds it as is
    Mockito.doReturn("https://tx.example.org").when(terminologyClient).getAddress();
    context.getTerminologyClientManager().setMasterClient(terminologyClient, null);
    context.setExpansionParameters(new AtomicReference<>(new Parameters()));
    ExpansionOptions opt = new ExpansionOptions().withCacheOk(true);
    expandTwiceThenReload(failure, expectReloaded, folder, () -> context.expandVS(opt, DUMMY_URL),
      cache -> cache.generateExpandToken(DUMMY_URL, opt));
  }

  @ParameterizedTest
  @MethodSource("unavailableFailures")
  void testExpandUrlUnavailableIsForThisRun(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandUrlTwiceThenReload(failure, false, folder);
  }

  @ParameterizedTest
  @MethodSource("serverAnswers")
  void testExpandUrlServerAnswerIsReloaded(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandUrlTwiceThenReload(failure, true, folder);
  }

  @Test
  void testExpandUrlRegistryDownIsForThisRun(@TempDir java.nio.file.Path folder) throws IOException {
    org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy policy = org.hl7.fhir.utilities.http.ManagedWebAccess.getAccessPolicy();
    // the registry call fails with an IOException, as a timeout does, so there's no server to ask
    org.hl7.fhir.utilities.http.ManagedWebAccess.setAccessPolicy(org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    try {
      // before the real cache, which can't save the mock's capabilities
      context.getTerminologyClientManager().setMasterClient(terminologyClient, "http://tx-registry.example.org");
      TerminologyCache cache = new TerminologyCache(new Object(), folder.toString(), context);
      context.initTxCache(cache);
      context.setExpansionParameters(new AtomicReference<>(new Parameters()));
      ExpansionOptions opt = new ExpansionOptions().withCacheOk(true);

      ValueSetExpansionOutcome res = context.expandVS(opt, DUMMY_URL);
      assertEquals(TerminologyServiceErrorClass.SERVER_ERROR, res.getErrorClass(), res.getError());
      assertSame(res, context.expandVS(opt, DUMMY_URL));
      cache.save();
      TerminologyCache next = new TerminologyCache(new Object(), folder.toString(), context);
      assertNull(next.getExpansion(next.generateExpandToken(DUMMY_URL, opt)));
    } finally {
      org.hl7.fhir.utilities.http.ManagedWebAccess.setAccessPolicy(policy);
    }
  }

  @Test
  void testExpandUrlNoServerIsReloaded(@TempDir java.nio.file.Path folder) throws IOException {
    // no server at all, with no failed registry call: that's an answer, kept for later runs
    BaseWorkerContext ctx = getBaseWorkerContext();
    TerminologyCache cache = new TerminologyCache(new Object(), folder.toString(), ctx);
    ctx.initTxCache(cache);
    ctx.setExpansionParameters(new AtomicReference<>(new Parameters()));
    ExpansionOptions opt = new ExpansionOptions().withCacheOk(true);

    ValueSetExpansionOutcome res = ctx.expandVS(opt, DUMMY_URL);
    assertEquals(TerminologyServiceErrorClass.UNKNOWN, res.getErrorClass(), res.getError());
    cache.save();
    TerminologyCache next = new TerminologyCache(new Object(), folder.toString(), ctx);
    assertNotNull(next.getExpansion(next.generateExpandToken(DUMMY_URL, opt)));
  }

  private void expandValueSetTwiceThenReload(Exception failure, boolean expectReloaded, java.nio.file.Path folder) throws IOException {
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().addInclude().setSystem("http://example.org/cs");
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);
    // the local expansion gives up, so the server is asked
    Mockito.doReturn(new ValueSetExpansionOutcome("not expanded locally", TerminologyServiceErrorClass.UNKNOWN, false))
      .when(valueSetExpanderSimple).expand(eq(vs), any(Parameters.class));
    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(any(ValidationOptions.class));
    expandTwiceThenReload(failure, expectReloaded, folder, () -> context.expandVS(opt, vs, new Parameters(), false),
      cache -> cache.generateExpandToken(vs, opt));
  }

  @ParameterizedTest
  @MethodSource("unavailableFailures")
  void testExpandValueSetUnavailableIsForThisRun(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandValueSetTwiceThenReload(failure, false, folder);
  }

  @ParameterizedTest
  @MethodSource("serverAnswers")
  void testExpandValueSetServerAnswerIsReloaded(Exception failure, @TempDir java.nio.file.Path folder) throws IOException {
    expandValueSetTwiceThenReload(failure, true, folder);
  }

  @Test
  void setLocaleSetsDefaultDisplayLanguageIfNoDisplayLanguage() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameterList().size()).isEqualTo(1);
    assertThat(actualParameters.getParameterList().get(0).getName()).isEqualTo("defaultDisplayLanguage");
    assertThat(actualParameters.getParameterList().get(0).getValue().toString()).isEqualTo(Locale.CHINA.toLanguageTag());
  }

  @Test
  void setLocaleResetsDisplayLanguageIfSetAutomatically() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters expansionParameters = new Parameters();
    expansionParameters.addParameter().setName("displayLanguage").setValue(new CodeType(Locale.FRANCE.toLanguageTag())).setUserData(UserDataNames.auto_added_parameter, "groovy");
    baseWorkerContext.setExpansionParameters(new AtomicReference<>(expansionParameters));

    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameterList().size()).isEqualTo(1);
    assertThat(actualParameters.getParameterList().get(0).getName()).isEqualTo("displayLanguage");
    assertThat(actualParameters.getParameterList().get(0).getValue().toString()).isEqualTo(Locale.CHINA.toLanguageTag());
  }

  @Test
  void setLocaleDoesntChangeDisplayLanguageIfNotSetAutomatically() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters expansionParameters = new Parameters();
    expansionParameters.addParameter().setName("displayLanguage").setValue(new CodeType(Locale.FRANCE.toLanguageTag()));
    baseWorkerContext.setExpansionParameters(new AtomicReference<>(expansionParameters));
    baseWorkerContext.setLocale(Locale.CHINA);
    Parameters actualParameters = baseWorkerContext.getExpansionParameters();
    assertThat(actualParameters.getParameterList().size()).isEqualTo(1);
    assertThat(actualParameters.getParameterList().get(0).getName()).isEqualTo("displayLanguage");
    assertThat(actualParameters.getParameterList().get(0).getValue().toString()).isEqualTo(Locale.FRANCE.toLanguageTag());

  }

  @Test
  void setLocaleDoesNotCreateDuplicateParams() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    for (int i = 0; i < 10; i++) {
      baseWorkerContext.setLocale(Locale.US);
      Parameters actualParameters = baseWorkerContext.getExpansionParameters();
      assertThat(actualParameters.getParameterList().size()).isEqualTo(1);
      assertThat(actualParameters.getParameterList().get(0).getName()).isEqualTo("defaultDisplayLanguage");
      assertThat(actualParameters.getParameterList().get(0).getValue().toString()).isEqualTo("en-US");
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
            for (Parameters.ParametersParameterComponent component : parameters.getParameterList()) {
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

  @Test
  void externalLookupAnswerIsPersisted() {
    // the lookups didn't fail, so their 'not found' is kept for later runs
    assertExternalLookupsCached(true);
  }

  @Test
  void failedExternalLookupIsForThisRun() throws IOException {
    org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy policy = org.hl7.fhir.utilities.http.ManagedWebAccess.getAccessPolicy();
    // the registry call fails with an IOException, as a timeout does
    org.hl7.fhir.utilities.http.ManagedWebAccess.setAccessPolicy(org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    try {
      context.getTerminologyClientManager().setMasterClient(terminologyClient, "http://tx-registry.example.org");
      assertExternalLookupsCached(false);
    } finally {
      org.hl7.fhir.utilities.http.ManagedWebAccess.setAccessPolicy(policy);
    }
  }

  private void assertExternalLookupsCached(boolean persistent) {
    String vs = "http://example.org/ValueSet/unknown";
    String cs = "http://example.org/CodeSystem/unknown";
    // the server has no such value set
    Mockito.doReturn(new Bundle()).when(terminologyClient).search(Mockito.eq("ValueSet"), Mockito.anyString());
    assertNull(context.findTxResource(ValueSet.class, vs, VersionResolutionRules.defaultRule()));
    assertNull(context.findTxResource(CodeSystem.class, cs, VersionResolutionRules.defaultRule()));
    Mockito.verify(terminologyCache).cacheValueSet(vs, null, persistent);
    Mockito.verify(terminologyCache).cacheCodeSystem(cs, null, persistent);
  }
}
