package org.hl7.fhir.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.services.context.IContextResourceLoaderN;
import org.hl7.fhir.services.terminology.*;
import org.hl7.fhir.services.validation.IResourceValidator;
import org.hl7.fhir.standalone.context.BaseWorkerContext;
import org.hl7.fhir.standalone.terminology.expansion.ValueSetExpander;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyCache;
import org.hl7.fhir.standalone.terminology.validation.ValueSetValidator;
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
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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


    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)), argThat(new ExpansionOptionsMatcher(opt)), any(), eq(Collections.emptyList()));
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


    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)), argThat(new ExpansionOptionsMatcher(opt)), any(), eq(Collections.emptyList()));

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
      Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), argThat(new ExpansionOptionsMatcher(opt)), any(Parameters.class), eq(Collections.emptyList()));
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

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(Collections.emptyList()));
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
  public void testExpandValueSetKeyHasImportedValueSets() throws IOException {
    // vs imports a, a imports b, and b imports a again; c can't be loaded
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    vs.getCompose().addInclude().addValueSet("http://example.org/a");
    vs.getCompose().addExclude().addValueSet("http://example.org/c");
    ValueSet a = new ValueSet();
    a.setUrl("http://example.org/a");
    a.getCompose().addInclude().addValueSet("http://example.org/b");
    ValueSet b = new ValueSet();
    b.setUrl("http://example.org/b");
    b.getCompose().addInclude().addValueSet("http://example.org/a");
    Mockito.doReturn(a).when(context).fetchResourceWithException(eq(ValueSet.class), eq("http://example.org/a"), any(), any(), any());
    Mockito.doReturn(b).when(context).fetchResourceWithException(eq(ValueSet.class), eq("http://example.org/b"), any(), any(), any());
    Mockito.doThrow(new FHIRException("can't load c")).when(context).fetchResourceWithException(eq(ValueSet.class), eq("http://example.org/c"), any(), any(), any());
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(List.of(a, b)));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    assertEquals(expectedExpansionResult, context.expandVS(opt, vs, new Parameters(), false));
  }

  @Test
  public void testExpandValueSetKeyHasCodeSystemsAndSupplements() throws IOException {
    // the content of the code systems a local definition draws on goes into the key; a stub (not-present) doesn't
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new CanonicalType("http://example.org/supp"));
    vs.getCompose().addInclude().setSystem("http://example.org/cs");
    vs.getCompose().addInclude().setSystem("http://example.org/stub");
    CodeSystem supp = new CodeSystem();
    supp.setUrl("http://example.org/supp");
    supp.setContent(Enumerations.CodeSystemContentMode.SUPPLEMENT);
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://example.org/cs");
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    CodeSystem stub = new CodeSystem();
    stub.setUrl("http://example.org/stub");
    stub.setContent(Enumerations.CodeSystemContentMode.NOTPRESENT);
    Mockito.doReturn(supp).when(context).fetchResourceWithException(eq(CodeSystem.class), eq("http://example.org/supp"), any(), any(), any());
    Mockito.doReturn(cs).when(context).fetchResourceWithException(eq(CodeSystem.class), eq("http://example.org/cs"), any(), any(), any());
    Mockito.doReturn(stub).when(context).fetchResourceWithException(eq(CodeSystem.class), eq("http://example.org/stub"), any(), any(), any());
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(List.of(supp, cs)));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);

    assertEquals(expectedExpansionResult, context.expandVS(opt, vs, new Parameters(), false));
  }

  @Test
  public void testExpandValueSetKeyHasTheExpansionParameters() throws IOException {
    // the parameters as sent: the caller's, plus what the options add
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true).withIncompleteOk(true).withLanguage("de");
    ArgumentCaptor<Parameters> sent = ArgumentCaptor.forClass(Parameters.class);
    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), sent.capture(), eq(Collections.emptyList()));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);
    Parameters pIn = new Parameters();
    pIn.addParameter("system-version", "http://snomed.info/sct|http://snomed.info/sct/900000000000207008/version/20250101");

    assertEquals(expectedExpansionResult, context.expandVS(opt, vs, pIn, false));
    Parameters key = sent.getValue();
    assertEquals("http://snomed.info/sct|http://snomed.info/sct/900000000000207008/version/20250101", key.getParameter("system-version").getValue().primitiveValue());
    assertEquals("de", key.getParameter("displayLanguage").getValue().primitiveValue());
    assertEquals("false", key.getParameter("excludeNested").getValue().primitiveValue());
    assertEquals("true", key.getParameter("incomplete-ok").getValue().primitiveValue());
  }

  @Test
  public void testExpandValueSetWithOptionsWithValueSetExpanderSimple() throws IOException {

    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(Collections.emptyList()));

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

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(Collections.emptyList()));

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

  private static OperationOutcome serverError() {
    OperationOutcome oo = new OperationOutcome();
    oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.TOOCOSTLY).getDetails().setText("too costly");
    return oo;
  }

  @Test
  void testIsServerAnswer() {
    assertTrue(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(422, "too costly", serverError())));
    assertTrue(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(404, "not found", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(500, "internal error", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(502, "bad gateway", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(408, "timeout", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(429, "too many requests", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(401, "unauthorized", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(403, "forbidden", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(407, "proxy authentication required", serverError())));
    assertFalse(BaseWorkerContext.isServerAnswer(new org.hl7.fhir.services.client.EFhirClientException(0, "no response", new java.io.IOException("reset"))));
    assertFalse(BaseWorkerContext.isServerAnswer(new FHIRException(new java.net.SocketTimeoutException("timed out"))));
  }

  /**
   * The local expansion gives up, so the server is asked, and fails with the given exception
   */
  private ValueSetExpansionOutcome expandWithServerFailure(Exception failure) throws IOException {
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    ExpansionOptions opt = new ExpansionOptions().withHierarchical(true).withCacheOk(true);
    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(same(vs), same(opt), any(Parameters.class), eq(Collections.emptyList()));
    Mockito.doReturn(expectedExpansionResult).when(valueSetExpanderSimple).expand(eq(vs), any(Parameters.class));
    Mockito.doReturn(valueSetExpanderSimple).when(context).constructValueSetExpanderSimple(any(ValidationOptions.class));
    Mockito.doThrow(failure).when(terminologyClient).expandValueset(eq(vs), any(Parameters.class));
    return context.expandVS(opt, vs, new Parameters(), false);
  }

  @Test
  void testExpandValueSetServerFailureIsNotPersisted() throws IOException {
    ValueSetExpansionOutcome res = expandWithServerFailure(new FHIRException(new java.net.SocketTimeoutException("timed out")));
    assertNull(res.getValueset());
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, res, false);
  }

  @Test
  void testExpandValueSetServerErrorPageIsNotPersisted() throws IOException {
    ValueSetExpansionOutcome res = expandWithServerFailure(new org.hl7.fhir.services.client.EFhirClientException(503, "service unavailable", serverError()));
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, res, false);
  }

  @Test
  void testExpandValueSetServerAnswerIsPersisted() throws IOException {
    ValueSetExpansionOutcome res = expandWithServerFailure(new org.hl7.fhir.services.client.EFhirClientException(422, "too costly", serverError()));
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, res, true);
  }

  private ValueSetExpansionOutcome expandIncludeWithServerFailure(Exception failure) {
    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent().setSystem("http://example.org/cs");
    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(any(ValueSet.class), any(ExpansionOptions.class), any(), eq(Collections.emptyList()));
    Mockito.doReturn(new Parameters()).when(context).constructParameters(any(), any(), any(ValueSet.class), anyBoolean());
    Mockito.doThrow(failure).when(terminologyClient).expandValueset(any(ValueSet.class), any(Parameters.class));
    return context.expandVS(null, inc, true, false);
  }

  private static CodeSystem supplement(String url, String supplements) {
    CodeSystem supp = new CodeSystem();
    supp.setUrl(url);
    supp.setContent(Enumerations.CodeSystemContentMode.SUPPLEMENT);
    supp.setSupplements(supplements);
    return supp;
  }

  @Test
  void testExpansionDependenciesHaveRegisteredSupplements() {
    // the supplements known for the code system, and for the version the parameters pin it to
    CodeSystem supp = supplement("http://example.org/supp", "http://example.org/cs");
    CodeSystem supp2 = supplement("http://example.org/supp2", "http://example.org/cs|2.0");
    context.cacheResource(supp);
    context.cacheResource(supp2);
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    vs.getCompose().addInclude().setSystem("http://example.org/cs");

    assertEquals(List.of(supp), context.findExpansionDependencies(vs, new Parameters()));
    assertEquals(List.of(supp), context.findExpansionDependencies(vs, null));
    Parameters p = new Parameters();
    p.addParameter("system-version", new CanonicalType("http://example.org/cs|2.0"));
    assertEquals(List.of(supp, supp2), context.findExpansionDependencies(vs, p));
  }

  @Test
  void testExpansionDependenciesHaveTheIncludedVersion() {
    // the server is sent the code system as resolved without a version, the local expander uses the include's
    CodeSystem cs1 = new CodeSystem();
    cs1.setUrl("http://example.org/cs");
    cs1.setVersion("1.0");
    cs1.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    CodeSystem cs2 = new CodeSystem();
    cs2.setUrl("http://example.org/cs");
    cs2.setVersion("2.0");
    cs2.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    CodeSystem supp1 = supplement("http://example.org/supp", "http://example.org/cs|1.0");
    Mockito.doReturn(cs2).when(context).fetchResourceWithException(eq(CodeSystem.class), eq("http://example.org/cs"), any(), isNull(), any());
    Mockito.doReturn(cs1).when(context).fetchResourceWithException(eq(CodeSystem.class), eq("http://example.org/cs"), any(), eq("1.0"), any());
    context.cacheResource(supp1);
    ValueSet vs = new ValueSet();
    vs.setUrl(DUMMY_URL);
    vs.getCompose().addInclude().setSystem("http://example.org/cs").setVersion("1.0");

    List<CanonicalResource> deps = context.findExpansionDependencies(vs, null);
    assertEquals(3, deps.size(), deps.toString());
    assertTrue(deps.containsAll(List.of(cs1, cs2, supp1)), deps.toString());
  }

  @Test
  void testExpandIncludeKeyHasDependencies() {
    // the expansion of a single include is persisted too, and the server is sent the supplements
    CodeSystem supp = supplement("http://example.org/supp", "http://example.org/cs");
    context.cacheResource(supp);
    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent().setSystem("http://example.org/cs");
    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(any(ValueSet.class), any(ExpansionOptions.class), any(), eq(List.of(supp)));
    Mockito.doReturn(expectedExpansionResult).when(terminologyCache).getExpansion(cacheToken);
    assertEquals(expectedExpansionResult, context.expandVS(null, inc, true, false));
  }

  @Test
  void testExpandIncludeServerFailureIsNotPersisted() {
    ValueSetExpansionOutcome res = expandIncludeWithServerFailure(new org.hl7.fhir.services.client.EFhirClientException(503, "service unavailable", serverError()));
    assertNull(res.getValueset());
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, res, false);
  }

  @Test
  void testExpandIncludeServerAnswerIsPersisted() {
    ValueSetExpansionOutcome res = expandIncludeWithServerFailure(new org.hl7.fhir.services.client.EFhirClientException(422, "too costly", serverError()));
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, res, true);
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
}
