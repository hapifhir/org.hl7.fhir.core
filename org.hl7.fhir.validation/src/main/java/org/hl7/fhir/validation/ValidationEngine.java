package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContextManager;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SystemOutLoggingService;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.elementmodel.ParserBase;
import org.hl7.fhir.r5.elementmodel.SHCParser;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.BaseValidator.ValidationControl;
import org.hl7.fhir.validation.ValidationEngine.IValidationEngineLoader;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;
import org.hl7.fhir.validation.cli.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.cli.services.IPackageInstaller;
import org.hl7.fhir.validation.cli.utils.ProfileLoader;
import org.hl7.fhir.validation.cli.utils.QuestionnaireMode;
import org.hl7.fhir.validation.cli.utils.SchemaValidator;
import org.hl7.fhir.validation.cli.utils.ValidationLevel;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;
import org.xml.sax.SAXException;

import lombok.Getter;
import lombok.Setter;
import lombok.With;
import lombok.experimental.Accessors;

/*
Copyright (c) 2011+, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
   endorse or promote products derived from this software without specific
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.

*/

/**
 * This is just a wrapper around the InstanceValidator class for convenient use
 * <p>
 * The following resource formats are supported: XML, JSON, Turtle
 * The following versions are supported: 1.0.2, 1.4.0, 3.0.2, 4.0.1, and current
 * <p>
 * Note: the validation engine is intended to be threadsafe
 * To Use:
 * <p>
 * 1/ Initialize
 * ValidationEngine validator = new ValidationEngine(src);
 * - this must be the packageId of the relevant core specification
 * for the version you want to validate against (e.g. hl7.fhir.r4.core)
 * <p>
 * validator.connectToTSServer(txServer);
 * - this is optional; in the absence of a terminology service, snomed, loinc etc will not be validated
 * <p>
 * validator.loadIg(src);
 * - call this any number of times for the Implementation Guide(s) of interest.
 * - See https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator for documentation about the src parameter (-ig parameter)
 * <p>
 * validator.loadQuestionnaire(src)
 * - url or filename of a questionnaire to load. Any loaded questionnaires will be used while validating
 * <p>
 * validator.setNative(doNative);
 * - whether to do xml/json/rdf schema validation as well
 * <p>
 * You only need to do this initialization once. You can validate as many times as you like
 * <p>
 * 2. validate
 * validator.validate(src, profiles);
 * - source (as stream, byte[]), or url or filename of a resource to validate.
 * Also validate against any profiles (as canonical URLS, equivalent to listing them in Resource.meta.profile)
 * <p>
 * if the source is provided as byte[] or stream, you need to provide a format too, though you can
 * leave that as null, and the validator will guess
 * <p>
 * 3. Or, instead of validating, transform (see documentation and use in Validator.java)
 *
 * @author Grahame Grieve
 */
@Accessors(chain = true)
public class ValidationEngine implements IValidatorResourceFetcher, IValidationPolicyAdvisor, IPackageInstaller, IWorkerContextManager.IPackageLoadingTracker {


  public interface IValidationEngineLoader {

    void load(Content cnt) throws FHIRException, IOException;

  }

  @Getter @Setter private SimpleWorkerContext context;
  @Getter @Setter private Map<String, byte[]> binaries = new HashMap<>();
  @Getter @Setter private boolean doNative;
  @Getter @Setter private boolean noInvariantChecks;
  @Getter @Setter private boolean displayWarnings;
  @Getter @Setter private boolean wantInvariantInMessage;
  @Getter @Setter private boolean hintAboutNonMustSupport;
  @Getter @Setter private boolean anyExtensionsAllowed = false;
  @Getter @Setter private String version;
  @Getter @Setter private String language;
  @Setter private FilesystemPackageCacheManager pcm;
  @Getter @Setter private PrintWriter mapLog;
  @Getter @Setter private boolean debug = false;
  @Getter @Setter private IValidatorResourceFetcher fetcher;
  @Getter @Setter private IValidationPolicyAdvisor policyAdvisor;
  @Getter @Setter private IWorkerContextManager.ICanonicalResourceLocator locator;
  @Getter @Setter private boolean assumeValidRestReferences;
  @Getter @Setter private boolean noExtensibleBindingMessages;
  @Getter @Setter private boolean noUnicodeBiDiControlChars;
  @Getter @Setter private boolean securityChecks;
  @Getter @Setter private boolean crumbTrails;
  @Getter @Setter private boolean forPublication;
  @Getter @Setter private boolean allowExampleUrls;
  @Getter @Setter private boolean showMessagesFromReferences;
  @Getter @Setter private boolean doImplicitFHIRPathStringConversion;
  @Getter @Setter private HtmlInMarkdownCheck htmlInMarkdownCheck;
  @Getter @Setter private boolean allowDoubleQuotesInFHIRPath;
  @Getter @Setter private Locale locale;
  @Getter @Setter private List<ImplementationGuide> igs = new ArrayList<>();
  @Getter @Setter private List<String> extensionDomains = new ArrayList<>();

  @Getter @Setter private boolean showTimes;
  @Getter @Setter private List<BundleValidationRule> bundleValidationRules = new ArrayList<>();
  @Getter @Setter private QuestionnaireMode questionnaireMode;
  @Getter @Setter private ValidationLevel level = ValidationLevel.HINTS;
  @Getter @Setter private FHIRPathEngine fhirPathEngine;
  @Getter @Setter private IgLoader igLoader;
  @Getter @Setter private Coding jurisdiction;


  private ContextUtilities cu = null;
  
  /**
   * Creating a validation engine is an expensive operation - takes seconds. 
   * Once you have a validation engine created, you can quickly clone it to 
   * get one that can load packages without affecting other uses
   * 
   * @param other
   * @throws FHIRException
   * @throws IOException
   */
  public ValidationEngine(ValidationEngine other) throws FHIRException, IOException {
    super();
    context = new SimpleWorkerContext(other.context);
    binaries.putAll(other.binaries);
    doNative = other.doNative;
    noInvariantChecks = other.noInvariantChecks;
    wantInvariantInMessage = other.wantInvariantInMessage;
    hintAboutNonMustSupport = other.hintAboutNonMustSupport;
    anyExtensionsAllowed = other.anyExtensionsAllowed;
    version = other.version;
    language = other.language;
    pcm = other.pcm;
    mapLog = other.mapLog;
    debug = other.debug;
    fetcher = other.fetcher;
    policyAdvisor = other.policyAdvisor;
    locator = other.locator;
    assumeValidRestReferences = other.assumeValidRestReferences;
    noExtensibleBindingMessages = other.noExtensibleBindingMessages;
    noUnicodeBiDiControlChars = other.noUnicodeBiDiControlChars;
    securityChecks = other.securityChecks;
    crumbTrails = other.crumbTrails;
    forPublication = other.forPublication;
    allowExampleUrls = other.allowExampleUrls;
    showMessagesFromReferences = other.showMessagesFromReferences;
    doImplicitFHIRPathStringConversion = other.doImplicitFHIRPathStringConversion;
    htmlInMarkdownCheck = other.htmlInMarkdownCheck;
    allowDoubleQuotesInFHIRPath = other.allowDoubleQuotesInFHIRPath;
    locale = other.locale;
    igs.addAll(other.igs);
    extensionDomains.addAll(other.extensionDomains);
    showTimes = other.showTimes;
    bundleValidationRules.addAll(other.bundleValidationRules);
    questionnaireMode = other.questionnaireMode;
    level = other.level;
    fhirPathEngine = other.fhirPathEngine;
    igLoader = other.igLoader;
    jurisdiction = other.jurisdiction;
  }
  
  /**
   * Systems that host the ValidationEngine can use this to control what validation the validator performs.
   * <p>
   * Using this, you can turn particular kinds of validation on and off. In addition, you can override
   * the error | warning | hint level and make it a different level.
   * <p>
   * Each entry has
   * * 'allowed': a boolean flag. if this is false, the Validator will not report the error.
   * * 'level' : set to error, warning, information
   * <p>
   * Entries are registered by ID, using the IDs in /org.hl7.fhir.utilities/src/main/resources/Messages.properties
   * <p>
   * This feature is not supported by the validator CLI - and won't be. It's for systems hosting
   * the validation framework in their own implementation context
   */
  @Getter @Setter private Map<String, ValidationControl> validationControl = new HashMap<>();
  private Map<String, Boolean> resolvedUrls = new HashMap<>();

  private ValidationEngine()  {

  }

  public static class ValidationEngineBuilder {

    @With
    private final String terminologyCachePath;

    @With
    private final String userAgent;

    @With
    private final String version;

    //All three of these may be required to instantiate a txServer
    private final String txServer;
    private final String txLog;
    private final FhirPublication txVersion;

    @With
    private final TimeTracker timeTracker;

    @With
    private final boolean canRunWithoutTerminologyServer;

    @With
    private final IWorkerContext.ILoggingService loggingService;

    @With
    private boolean THO = true;


    public ValidationEngineBuilder() {
      terminologyCachePath = null;
      userAgent = null;
      version = null;
      txServer = null;
      txLog = null;
      txVersion = null;
      timeTracker = null;
      canRunWithoutTerminologyServer = false;
      loggingService = new SystemOutLoggingService();
    }

    public ValidationEngineBuilder(String terminologyCachePath, String userAgent, String version, String txServer, String txLog, FhirPublication txVersion, TimeTracker timeTracker, boolean canRunWithoutTerminologyServer, IWorkerContext.ILoggingService loggingService, boolean THO) {
      this.terminologyCachePath = terminologyCachePath;
      this.userAgent = userAgent;
      this.version = version;
      this.txServer = txServer;
      this.txLog = txLog;
      this.txVersion = txVersion;
      this.timeTracker = timeTracker;
      this.canRunWithoutTerminologyServer = canRunWithoutTerminologyServer;
      this.loggingService = loggingService;
      this.THO = THO;
    }

    public ValidationEngineBuilder withTxServer(String txServer, String txLog, FhirPublication txVersion) {
      return new ValidationEngineBuilder(terminologyCachePath, userAgent, version, txServer, txLog, txVersion, timeTracker, canRunWithoutTerminologyServer, loggingService, THO);
    }

    public ValidationEngine fromNothing() throws IOException {
      ValidationEngine engine = new ValidationEngine();
      SimpleWorkerContext.SimpleWorkerContextBuilder contextBuilder = new SimpleWorkerContext.SimpleWorkerContextBuilder().withLoggingService(loggingService);
      if (terminologyCachePath != null)
        contextBuilder = contextBuilder.withTerminologyCachePath(terminologyCachePath);
      engine.setContext(contextBuilder.build());
      engine.initContext(timeTracker);
      engine.setIgLoader(new IgLoader(engine.getPcm(), engine.getContext(), engine.getVersion(), engine.isDebug()));
      loadTx(engine);
      if (VersionUtilities.isR5Plus(version)) {
        engine.loadPackage("hl7.fhir.uv.extensions", null);
      }
      return engine;
    }

    public ValidationEngine fromSource(String src) throws IOException, URISyntaxException {
      ValidationEngine engine = new ValidationEngine();
      engine.loadCoreDefinitions(src, false, terminologyCachePath, userAgent, timeTracker, loggingService);
      engine.getContext().setCanRunWithoutTerminology(canRunWithoutTerminologyServer);
      engine.getContext().setPackageTracker(engine);    
      if (txServer != null) {
        engine.setTerminologyServer(txServer, txLog, txVersion);
      }
      engine.setVersion(version);
      engine.setIgLoader(new IgLoader(engine.getPcm(), engine.getContext(), engine.getVersion(), engine.isDebug()));
      if (THO) {
        loadTx(engine);
      }
      if (VersionUtilities.isR5Plus(version)) {
        engine.loadPackage("hl7.fhir.uv.extensions", "1.0.0");
      }
      return engine;
    }

    private void loadTx(ValidationEngine engine) throws FHIRException, IOException {
      String pid = null;
      if (VersionUtilities.isR3Ver(version)) {
        pid =  "hl7.terminology.r3";
      }
      if (VersionUtilities.isR4Ver(version)) {
        pid =  "hl7.terminology.r4";
      }
      if (VersionUtilities.isR4BVer(version)) {
        pid =  "hl7.terminology.r4";
      }
      if (VersionUtilities.isR5Plus(version)) {
        pid =  "hl7.terminology.r5";
      }
      if (pid != null) {
        engine.loadPackage(pid, "5.0.0");
      }
      
    }
  }

  /**
   *
   * @param src
   * @param recursive
   * @param terminologyCachePath
   * @param userAgent
   * @param tt
   * @param loggingService
   * @throws FHIRException
   * @throws IOException
   *
   * @see IgLoader#loadIgSource(String, boolean, boolean) loadIgSource for detailed description of the src parameter
   */
  private void loadCoreDefinitions(String src, boolean recursive, String terminologyCachePath, String userAgent, TimeTracker tt, IWorkerContext.ILoggingService loggingService) throws FHIRException, IOException {
    NpmPackage npm = getPcm().loadPackage(src, null);
    if (npm != null) {
      version = npm.fhirVersion();
      SimpleWorkerContext.SimpleWorkerContextBuilder contextBuilder = new SimpleWorkerContext.SimpleWorkerContextBuilder().withLoggingService(loggingService);
      if (terminologyCachePath != null)
        contextBuilder = contextBuilder.withTerminologyCachePath(terminologyCachePath);
      if (userAgent != null) {
        contextBuilder.withUserAgent(userAgent);
      }
      context = contextBuilder.fromPackage(npm, ValidatorUtils.loaderForVersion(version), false);
    } else {
      Map<String, byte[]> source = igLoader.loadIgSource(src, recursive, true);
      if (version == null) {
        version = getVersionFromPack(source);
      }
      SimpleWorkerContext.SimpleWorkerContextBuilder contextBuilder = new SimpleWorkerContext.SimpleWorkerContextBuilder();
      if (terminologyCachePath != null)
        contextBuilder = contextBuilder.withTerminologyCachePath(terminologyCachePath);
      if (userAgent != null) {
        contextBuilder.withUserAgent(userAgent);
      }
      context = contextBuilder.fromDefinitions(source, ValidatorUtils.loaderForVersion(version), new PackageInformation(src, new Date()));
      ValidatorUtils.grabNatives(getBinaries(), source, "http://hl7.org/fhir");
    }
    // ucum-essence.xml should be in the class path. if it's not, ask about how to sort this out 
    // on https://chat.fhir.org/#narrow/stream/179167-hapi
    try {
      ClassLoader classLoader = ValidationEngine.class.getClassLoader();
      InputStream ue = classLoader.getResourceAsStream("ucum-essence.xml");
      context.setUcumService(new UcumEssenceService(ue));
    } catch (Exception e) {
      throw new FHIRException("Error loading UCUM from embedded ucum-essence.xml: "+e.getMessage(), e);
    }
    initContext(tt);
  }

  protected void initContext(TimeTracker tt) throws IOException {
    context.setCanNoTS(true);
    context.setCacheId(UUID.randomUUID().toString());
    context.setAllowLoadingDuplicates(true); // because of Forge
    context.setExpansionProfile(makeExpProfile());
    if (tt != null) {
      context.setClock(tt);
    }
    NpmPackage npmX = getPcm().loadPackage(CommonPackages.ID_XVER, CommonPackages.VER_XVER);
    context.loadFromPackage(npmX, null);

    this.fhirPathEngine = new FHIRPathEngine(context);
    this.fhirPathEngine.setAllowDoubleQuotes(false);
  }

  private String getVersionFromPack(Map<String, byte[]> source) {
    if (source.containsKey("version.info")) {
      IniFile vi = new IniFile(new ByteArrayInputStream(removeBom(source.get("version.info"))));
      return vi.getStringProperty("FHIR", "version");
    } else {
      throw new Error("Missing version.info?");
    }
  }

  private byte[] removeBom(byte[] bs) {
    if (bs.length > 3 && bs[0] == -17 && bs[1] == -69 && bs[2] == -65)
      return Arrays.copyOfRange(bs, 3, bs.length);
    else
      return bs;
  }

  private Parameters makeExpProfile() {
    Parameters ep = new Parameters();
    ep.addParameter("profile-url", "http://hl7.org/fhir/ExpansionProfile/dc8fd4bc-091a-424a-8a3b-6198ef146891"); // change this to blow the cache
    // all defaults....
    return ep;
  }

  public String connectToTSServer(String url, String log, FhirPublication version) throws URISyntaxException, IOException, FHIRException {
    return connectToTSServer(url, log, null, version);
  }

  public String connectToTSServer(String url, String log, String txCachePath, FhirPublication version) throws URISyntaxException, IOException, FHIRException {
    context.setTlogging(false);
    if (url == null) {
      context.setCanRunWithoutTerminology(true);
      context.setNoTerminologyServer(true);
      return "n/a: No Terminology Server";
    } else {
      try {
        return context.connectToTSServer(TerminologyClientFactory.makeClient("Tx-Server", url, context.getUserAgent(), version), log);
      } catch (Exception e) {
        if (context.isCanRunWithoutTerminology()) {
          return "n/a: Running without Terminology Server (error: " + e.getMessage() + ")";
        } else
          throw e;
      }
    }
  }

  public void loadProfile(String src) throws FHIRException, IOException {
    if (context.hasResource(StructureDefinition.class, src))
      return;
    if (context.hasResource(ImplementationGuide.class, src))
      return;

    byte[] source = ProfileLoader.loadProfileSource(src);
    FhirFormat fmt = FormatUtilities.determineFormat(source);
    Resource r = FormatUtilities.makeParser(fmt).parse(source);
    context.cacheResource(r);
  }

  // testing entry point
  public OperationOutcome validate(FhirFormat format, InputStream stream, List<String> profiles) throws FHIRException, IOException, EOperationOutcome {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    InstanceValidator validator = getValidator(format);
    validator.validate(null, messages, stream, format, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public List<StructureDefinition> asSdList(List<String> profiles) throws Error {
    List<StructureDefinition> list = new ArrayList<>();
    if (profiles != null) {
      for (String p : profiles) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
        if (sd == null) {
          throw new Error("Unable to resolve profile " + p);
        }
        list.add(sd);
      }
    }
    return list;
  }

  public OperationOutcome validate(String source, List<String> profiles, IValidationEngineLoader loader, boolean all) throws FHIRException, IOException, InterruptedException {
    List<String> l = new ArrayList<String>();
    List<SourceFile> refs = new ArrayList<>();
    l.add(source);
    return (OperationOutcome) validate(l, profiles, refs, null, loader, all, 0, true);
  }

  public Resource validate(List<String> sources, List<String> profiles, List<SourceFile> refs, List<ValidationRecord> record, IValidationEngineLoader loader, boolean all, int delay, boolean first) throws FHIRException, IOException, InterruptedException {
    boolean asBundle = ValidatorUtils.parseSources(sources, refs, context);
    Bundle results = new Bundle();
    results.setType(Bundle.BundleType.COLLECTION);
    boolean found = false;
    
    for (SourceFile ref : refs) {
      if (ref.isProcess()) {
        found = true;
      }
    }
    if (!found) {
      return null;
    } else if (!first && delay != 0) {
      Thread.sleep(delay);
    }
    
    // round one: try to read them all natively
    // Ignore if it fails.The purpose of this is to make dependencies 
    // available for other resources to depend on. if it fails to load, there'll be an error if there's
    // something that should've been loaded
    for (SourceFile ref : refs) {
      if (ref.isProcess() || all) {
        ref.setCnt(igLoader.loadContent(ref.getRef(), "validate", false, first));
        if (loader != null && ref.getCnt() != null) {
          try {
            loader.load(ref.getCnt());
          } catch (Throwable t) {
            System.out.println(t.getMessage());
          }
        }
      }
    }
    
    for (SourceFile ref : refs) {
      if ((ref.isProcess() || all) && ref.getCnt() != null) {
        TimeTracker.Session tts = context.clock().start("validation");
        context.clock().milestone();
        System.out.println("  Validate " + ref.getRef());
        
        try {
          OperationOutcome outcome = validate(ref.getRef(), ref.getCnt().getFocus(), ref.getCnt().getCntType(), profiles, record);
          ToolingExtensions.addStringExtension(outcome, ToolingExtensions.EXT_OO_FILE, ref.getRef());
          System.out.println(" " + context.clock().milestone());
          results.addEntry().setResource(outcome);
          tts.end();
        } catch (Exception e) {
          System.out.println("Validation Infrastructure fail validating " + ref + ": " + e.getMessage());
          tts.end();
          throw new FHIRException(e);
        }
        ref.setProcess(false);
      }
    }
    if (asBundle)
      return results;
    else
      return results.getEntryFirstRep().getResource();
  }

  public OperationOutcome validate(byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationMessage> messages) throws FHIRException, IOException, EOperationOutcome {
    InstanceValidator validator = getValidator(cntType);

    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationRecord> record) throws FHIRException, IOException, EOperationOutcome, SAXException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      SchemaValidator.validateSchema(location, cntType, messages);
    }
    InstanceValidator validator = getValidator(cntType);
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    if (showTimes) {
      System.out.println(location + ": " + validator.reportTimes());
    }
    if (record != null) {
      boolean found = false;
      for (ValidationRecord t : record) {
        if (t.getLocation().equals(location)) {
          found = true;
          t.setMessages(messages);
        }
      }
      if (!found) {
        record.add(new ValidationRecord(location, messages));
      }
    }
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles, IdStatus resourceIdRule, boolean anyExtensionsAllowed, BestPracticeWarningLevel bpWarnings, CheckDisplayOption displayOption) throws FHIRException, IOException, EOperationOutcome, SAXException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      SchemaValidator.validateSchema(location, cntType, messages);
    }
    InstanceValidator validator = getValidator(cntType);
    validator.setResourceIdRule(resourceIdRule);
    validator.setBestPracticeWarningLevel(bpWarnings);
    validator.setCheckDisplay(displayOption);
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(String source, String map) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    return transform(cnt.getFocus(), cnt.getCntType(), map);
  }

  public StructureMap compile(String mapUri) throws FHIRException, IOException {
    StructureMap map = context.fetchResource(StructureMap.class, mapUri);
    return map;
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(byte[] source, FhirFormat cntType, String mapUri) throws FHIRException, IOException {
    List<Base> outputs = new ArrayList<>();
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs, mapLog, context));
    StructureMap map = context.fetchResource(StructureMap.class, mapUri);
    if (map == null) throw new Error("Unable to find map " + mapUri + " (Known Maps = " + context.listMapUrls() + ")");
    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    StructureDefinition sourceSD = getSourceResourceFromStructureMap(map);
    ParserBase parser = Manager.makeParser(context, cntType);
    if (sourceSD.getKind() == StructureDefinition.StructureDefinitionKind.LOGICAL) {
      parser.setLogical(sourceSD);
    }
    org.hl7.fhir.r5.elementmodel.Element src = parser.parseSingle(new ByteArrayInputStream(source));    
    scu.transform(null, src, map, resource);
    resource.populatePaths(null);
    return resource;
  }

  private org.hl7.fhir.r5.elementmodel.Element getTargetResourceFromStructureMap(StructureMap map) {
    String targetTypeUrl = null;
    for (StructureMap.StructureMapStructureComponent component : map.getStructure()) {
      if (component.getMode() == StructureMap.StructureMapModelMode.TARGET) {
        targetTypeUrl = component.getUrl();
        break;
      }
    }

    if (targetTypeUrl == null) throw new FHIRException("Unable to determine resource URL for target type");

    StructureDefinition structureDefinition = null;
    for (StructureDefinition sd : this.context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getUrl().equalsIgnoreCase(targetTypeUrl)) {
        structureDefinition = sd;
        break;
      }
    }

    if (structureDefinition == null) throw new FHIRException("Unable to find StructureDefinition for target type ('" + targetTypeUrl + "')");

    return Manager.build(getContext(), structureDefinition);
  }
  
  private StructureDefinition getSourceResourceFromStructureMap(StructureMap map) {
	StructureMap.StructureMapGroupComponent g = map.getGroup().get(0);
	String type = null;
	for (StructureMap.StructureMapGroupInputComponent inp : g.getInput()) {
	  if (inp.getMode() == StructureMap.StructureMapInputMode.SOURCE)
	    if (type != null)
	      throw new DefinitionException("This engine does not support multiple source inputs");
	    else
	      type = inp.getType();
	}	  
	  
	String sourceTypeUrl = null;
	for (StructureMap.StructureMapStructureComponent component : map.getStructure()) {
	  if (component.getMode() == StructureMap.StructureMapModelMode.SOURCE
	      && component.getAlias().equalsIgnoreCase(type)) {
	    sourceTypeUrl = component.getUrl();
	    break;
	  }
	}
	    
	StructureDefinition structureDefinition = null;
	for (StructureDefinition sd : this.context.fetchResourcesByType(StructureDefinition.class)) {
	  if (sd.getUrl().equalsIgnoreCase(sourceTypeUrl)) {
	    structureDefinition = sd;
	  	break;
	  }
	}

	if (structureDefinition == null) throw new FHIRException("Unable to find StructureDefinition for source type ('" + sourceTypeUrl + "')");
	return structureDefinition;
  }


  public Resource generate(String source, String version) throws FHIRException, IOException, EOperationOutcome {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus(), source);
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    genResource(res, rc);
    return (Resource) res;
  }

  public void genResource(Resource res, RenderingContext rc) throws IOException, EOperationOutcome {
    if (res instanceof Bundle) {
      Bundle bnd = (Bundle) res;
      for (BundleEntryComponent be : bnd.getEntry()) {
        if (be.hasResource()) {
          genResource(be.getResource(), rc);
        }
      }
    } else {
      RendererFactory.factory(res, rc).render((DomainResource) res);
    }
  }

  public void convert(String source, String output) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());
    Manager.compose(context, e, new FileOutputStream(output), (output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML), OutputStyle.PRETTY, null);
  }

  public String evaluateFhirPath(String source, String expression) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    FHIRPathEngine fpe = this.getValidator(null).getFHIRPathEngine();
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());
    ExpressionNode exp = fpe.parse(expression);
    return fpe.evaluateToString(new ValidatorHostContext(context, e), e, e, e, exp);
  }

  public StructureDefinition snapshot(String source, String version) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus(), Utilities.getFileNameForName(source));

    if (!(res instanceof StructureDefinition))
      throw new FHIRException("Require a StructureDefinition for generating a snapshot");
    StructureDefinition sd = (StructureDefinition) res;
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());

    new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(base, sd, sd.getUrl(), null, sd.getName());
    return sd;
  }

  public CanonicalResource loadCanonicalResource(String source, String version) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus(), Utilities.getFileNameForName(source));

    if (!(res instanceof CanonicalResource))
      throw new FHIRException("Require a CanonicalResource");
    return (CanonicalResource) res;
  }

  public void seeResource(Resource r) throws FHIRException {
    context.cacheResource(r);
  }

  public void dropResource(String type, String id) {
    context.dropResource(type, id);
  }

  public InstanceValidator getValidator(FhirFormat format) throws FHIRException, IOException {
    InstanceValidator validator = new InstanceValidator(context, null, null);
    validator.setHintAboutNonMustSupport(hintAboutNonMustSupport);
    validator.setAnyExtensionsAllowed(anyExtensionsAllowed);
    validator.getExtensionDomains().clear();
    validator.getExtensionDomains().addAll(extensionDomains);
    validator.setNoInvariantChecks(isNoInvariantChecks());
    validator.setWantInvariantInMessage(isWantInvariantInMessage());
    validator.setValidationLanguage(language);
    validator.setDisplayWarnings(isDisplayWarnings());
    if (language != null) {
      validator.getContext().setValidationMessageLanguage(Locale.forLanguageTag(language));
    }
    validator.setAssumeValidRestReferences(assumeValidRestReferences);
    validator.setNoExtensibleWarnings(noExtensibleBindingMessages);
    validator.setSecurityChecks(securityChecks);
    validator.setCrumbTrails(crumbTrails);
    validator.setForPublication(forPublication);
    validator.setAllowExamples(allowExampleUrls);
    validator.setShowMessagesFromReferences(showMessagesFromReferences);
    validator.getContext().setLocale(locale);
    validator.setFetcher(this);
    validator.getImplementationGuides().addAll(igs);
    validator.getBundleValidationRules().addAll(bundleValidationRules);
    validator.getValidationControl().putAll(validationControl);
    validator.setQuestionnaireMode(questionnaireMode);
    validator.setLevel(level);
    validator.setHtmlInMarkdownCheck(htmlInMarkdownCheck);
    validator.setAllowDoubleQuotesInFHIRPath(allowDoubleQuotesInFHIRPath);
    validator.setNoUnicodeBiDiControlChars(noUnicodeBiDiControlChars);
    validator.setDoImplicitFHIRPathStringConversion(doImplicitFHIRPathStringConversion);
    if (format == FhirFormat.SHC) {
      igLoader.loadIg(getIgs(), getBinaries(), SHCParser.CURRENT_PACKAGE, true);      
    }
    validator.setJurisdiction(jurisdiction);
    validator.setLogProgress(true);
    return validator;
  }

  public void prepare() {
    for (StructureDefinition sd : new ContextUtilities(context).allStructures()) {
      try {
        makeSnapshot(sd);
      } catch (Exception e) {
        System.out.println("Process Note: Unable to generate snapshot for " + sd.present() + ": " + e.getMessage());
        if (context.getLogger().isDebugLogging()) {
          e.printStackTrace();
        }
      }
    }
  }

  private void makeSnapshot(StructureDefinition sd) throws DefinitionException, FHIRException {
    if (sd.hasSnapshot())
      return;
    StructureDefinition sdb = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    if (sdb != null) {
      makeSnapshot(sdb);
      new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(sdb, sd, sd.getUrl(), null, sd.getName());
    }
  }

  public void handleOutput(Resource r, String output, String version) throws FHIRException, IOException {
    if (output.startsWith("http://")) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      handleOutputToStream(r, output, bs, version);
      SimpleHTTPClient http = new SimpleHTTPClient();
      HTTPResult res = http.post(output, "application/fhir+xml", bs.toByteArray(), "application/fhir+xml");
      res.checkThrowException();
    } else {
      FileOutputStream s = new FileOutputStream(output);
      handleOutputToStream(r, output, s, version);
    }
  }

  private void handleOutputToStream(Resource r, String fn, OutputStream s, String version) throws FHIRException, IOException {
    if (fn.endsWith(".html") || fn.endsWith(".htm") && r instanceof DomainResource)
      new XhtmlComposer(XhtmlComposer.HTML, true).compose(s, ((DomainResource) r).getText().getDiv());
    else if (VersionUtilities.isR3Ver(version)) {
      org.hl7.fhir.dstu3.model.Resource res = VersionConvertorFactory_30_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        TextFile.stringToStream(org.hl7.fhir.dstu3.utils.StructureMapUtilities.render((org.hl7.fhir.dstu3.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (VersionUtilities.isR4Ver(version)) {
      org.hl7.fhir.r4.model.Resource res = VersionConvertorFactory_40_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        TextFile.stringToStream(org.hl7.fhir.r4.utils.StructureMapUtilities.render((org.hl7.fhir.r4.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (VersionUtilities.isR2BVer(version)) {
      org.hl7.fhir.dstu2016may.model.Resource res = VersionConvertorFactory_14_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (VersionUtilities.isR2Ver(version)) {
      org.hl7.fhir.dstu2.model.Resource res = VersionConvertorFactory_10_50.convertResource(r, new org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor5());
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (VersionUtilities.isR5Plus(version)) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new XmlParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new JsonParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        TextFile.stringToStream(StructureMapUtilities.render((org.hl7.fhir.r5.model.StructureMap) r), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else
      throw new FHIRException("Encountered unsupported configured version " + version + " loading " + fn);

    s.close();
  }

  public byte[] transformVersion(String source, String targetVer, FhirFormat format, Boolean canDoNative) throws FHIRException, IOException, Exception {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());

    // if the src has a url, we try to use the java code 
    if ((canDoNative == null && src.hasChild("url")) || (canDoNative != null && canDoNative)) {
      try {
        if (VersionUtilities.isR2Ver(version)) {
          return VersionConvertor.convertVersionNativeR2(targetVer, cnt, format);
        } else if (VersionUtilities.isR2BVer(version)) {
          return VersionConvertor.convertVersionNativeR2b(targetVer, cnt, format);
        } else if (VersionUtilities.isR3Ver(version)) {
          return VersionConvertor.convertVersionNativeR3(targetVer, cnt, format);
        } else if (VersionUtilities.isR4Ver(version)) {
          return VersionConvertor.convertVersionNativeR4(targetVer, cnt, format);
        } else if (VersionUtilities.isR4BVer(version)) {
          return VersionConvertor.convertVersionNativeR4b(targetVer, cnt, format);
        } else if (VersionUtilities.isR5Ver(version)) {
            return VersionConvertor.convertVersionNativeR5(targetVer, cnt, format);
        }else {
          throw new FHIRException("Source version not supported yet: " + version);
        }
      } catch (Exception e) {
        System.out.println("Conversion failed using Java convertor: " + e.getMessage());
      }
    }
    // ok, we try converting using the structure maps
    System.out.println("Loading hl7.fhir.xver.r4");
    igLoader.loadIg(getIgs(), getBinaries(), "hl7.fhir.xver.r4", false);
    String type = src.fhirType();
    String url = getMapId(type, targetVer);
    List<Base> outputs = new ArrayList<Base>();
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs, mapLog, context));
    StructureMap map = context.fetchResource(StructureMap.class, url);
    if (map == null)
      throw new Error("Unable to find map " + url + " (Known Maps = " + context.listMapUrls() + ")");
    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    scu.transform(null, src, map, resource);
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context, resource, bs, format, OutputStyle.PRETTY, null);
    return bs.toByteArray();
  }

  private String getMapId(String type, String targetVer) {
    if (VersionUtilities.isR2Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "2to3";
      }
    } else if (VersionUtilities.isR3Ver(version)) {
      if (VersionUtilities.isR2Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "3to2";
      } else if (VersionUtilities.isR4Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "3to4";
      }
    } else if (VersionUtilities.isR4Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "4to3";
      }
      else if (VersionUtilities.isR5Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "4to5";
      }
    } else if (VersionUtilities.isR5Ver(version)) {
      if (VersionUtilities.isR4Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "5to4";
      }
    }
    throw new FHIRException("Source/Target version not supported: " + version + " -> " + targetVer);
  }

  public String setTerminologyServer(String src, String log, FhirPublication version) throws FHIRException, URISyntaxException, IOException {
    return connectToTSServer(src, log, version);
  }

  public ValidationEngine setMapLog(String mapLog) throws FileNotFoundException {
    if (mapLog != null) {
      this.mapLog = new PrintWriter(mapLog);
    }
    return this;
  }

  public ValidationEngine setSnomedExtension(String sct) {
    getContext().getExpansionParameters().addParameter("system-version", "http://snomed.info/sct|http://snomed.info/sct/" + sct);
    return this;
  }

  public FilesystemPackageCacheManager getPcm() throws IOException {
    if (pcm == null) {
      //System.out.println("Creating Package manager?");
      pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    }
    return pcm;
  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String source) throws IOException {
    SimpleHTTPClient http = new SimpleHTTPClient();
    HTTPResult res = http.get(source);
    res.checkThrowException();
    return res.getContent();
  }

  @Override
  public boolean packageExists(String id, String ver) throws IOException, FHIRException {
    return getPcm().packageExists(id, ver);
  }

  @Override
  public void loadPackage(String id, String ver) throws IOException, FHIRException {
    igLoader.loadIg(getIgs(), getBinaries(),id + (ver == null ? "" : "#" + ver), true);
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException {
    Resource resource = context.fetchResource(Resource.class, url);
    if (resource != null) {
      return new ObjectConverter(context).convert(resource);
    }
    if (fetcher != null) {
      return fetcher.fetch(validator, appContext, url);
    }
    return null;
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url) {
    Resource resource = context.fetchResource(StructureDefinition.class, url);
    if (resource != null) {
      return ReferenceValidationPolicy.CHECK_VALID;
    }
    if (!(url.contains("hl7.org") || url.contains("fhir.org"))) {
      return ReferenceValidationPolicy.IGNORE;
    } else if (policyAdvisor != null) {
      return policyAdvisor.policyForReference(validator, appContext, path, url);
    } else {
      return ReferenceValidationPolicy.CHECK_EXISTS_AND_TYPE;
    }
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
                                                      Object appContext,
                                                      String containerType,
                                                      String containerId,
                                                      Element.SpecialElement containingResourceType,
                                                      String path,
                                                      String url) {
    return ContainedReferenceValidationPolicy.CHECK_VALID;
  }

  @Override
  public CodedContentValidationPolicy policyForCodedContent(IResourceValidator validator, Object appContext, String stackPath, ElementDefinition definition, StructureDefinition structure, BindingKind kind, ValueSet valueSet, List<String> systems) {
    return CodedContentValidationPolicy.VALUESET;
  }

  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type) throws FHIRException {
    // some of this logic might take a while, and it's not going to change once loaded
    if (resolvedUrls .containsKey(type+"|"+url)) {
      return resolvedUrls.get(type+"|"+url);
    }
    if (!url.startsWith("http://") && !url.startsWith("https://")) { // ignore these
      resolvedUrls.put(type+"|"+url, true);
      return true;
    }
    if (context.fetchResource(Resource.class, url) != null) {
      resolvedUrls.put(type+"|"+url, true);
      return true;
    }
    if (SIDUtilities.isKnownSID(url) || 
        Utilities.existsInList(url, "http://hl7.org/fhir/w5", "http://hl7.org/fhir/fivews", "http://hl7.org/fhir/workflow", "http://hl7.org/fhir/ConsentPolicy/opt-out", "http://hl7.org/fhir/ConsentPolicy/opt-in")) {
      resolvedUrls.put(type+"|"+url, true);
      return true;
    }
    if (Utilities.existsInList(url, "http://loinc.org", "http://unitsofmeasure.org", "http://snomed.info/sct")) {
      resolvedUrls.put(type+"|"+url, true);
      return true;
    }
    if (context.getNSUrlMap().containsKey(url)) {
      resolvedUrls.put(type+"|"+url, true);
      return true;
    }
    if (url.contains("example.org") || url.contains("acme.com")) {
      resolvedUrls.put(type+"|"+url, false);
      return false; // todo... how to access settings from here?
    }
    if (url.contains("*") && !url.contains("?")) {
      if (cu == null) {
        cu = new ContextUtilities(context);
      }
      List<StructureMap> maps = cu.listMaps(url);
      if (!maps.isEmpty()) {
        return true;
      }
      
    }
    if (fetcher != null) {
      try {
        boolean ok = fetcher.resolveURL(validator, appContext, path, url, type);
        resolvedUrls.put(type+"|"+url, ok);
        return ok;
      } catch (Exception e) {
        e.printStackTrace();
        resolvedUrls.put(type+"|"+url, false);
        return false;
      }
    }
    resolvedUrls.put(type+"|"+url, false);
    return false;
  }


  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, String url) throws URISyntaxException {
    Resource res = context.fetchResource(Resource.class, url);
    if (res != null) {
      if (res instanceof CanonicalResource) {
        return (CanonicalResource) res;
      } else {
        return null;
      }
    }
    return fetcher != null ? fetcher.fetchCanonicalResource(validator, url) : null;
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return fetcher != null && fetcher.fetchesCanonicalResource(validator, url);
  }

  @Override
  public void packageLoaded(String pid, String version) {
    resolvedUrls.clear();
    
  }

  public Resource loadResource(byte[] content, String fn) throws FHIRException, IOException {
    return  igLoader.loadResourceByVersion(version, content, fn);

  }

}
