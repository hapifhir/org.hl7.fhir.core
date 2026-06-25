package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.*;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.elementmodel.ParserBase;
import org.hl7.fhir.r5.elementmodel.SHCParser;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.liquid.BaseTableWrapper;
import org.hl7.fhir.r5.liquid.GlobalObject.GlobalObjectRandomFunction;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.testfactory.ProfileBasedFactory;
import org.hl7.fhir.r5.testfactory.ProfileBasedManipulator;
import org.hl7.fhir.r5.testfactory.TestDataFactory;
import org.hl7.fhir.r5.testfactory.TestDataHostServices;
import org.hl7.fhir.r5.testfactory.dataprovider.InlineTableDataProvider;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
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
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.NamingSystemUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ResourceDependencyWalker;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.SIDUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.BaseValidator.ValidationControl;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidatedFragments;
import org.hl7.fhir.validation.service.model.ValidationTime;
import org.hl7.fhir.validation.service.IPackageInstaller;
import org.hl7.fhir.validation.service.utils.ProfileLoader;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.SchemaValidator;
import org.hl7.fhir.validation.service.utils.ValidationLevel;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.MatchetypeValidator;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.instance.utils.ValidationContext;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import lombok.Getter;
import lombok.Setter;
import lombok.With;
import lombok.experimental.Accessors;

import javax.annotation.Nonnull;

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
@Slf4j
@Accessors(chain = true)
public class ValidationEngine implements IValidatorResourceFetcher, IValidationPolicyAdvisor, IPackageInstaller, IWorkerContextManager.IPackageLoadingTracker {


  public interface IValidationEngineLoader {

    void load(Content cnt) throws FHIRException, IOException;

  }

  @Getter @Setter private SimpleWorkerContext context;
  @Getter @Setter private Map<String, ByteProvider> binaries = new HashMap<>();
  @Getter @Setter private boolean doNative;
  @Getter @Setter private boolean displayWarnings;
  @Getter @Setter private boolean logValidationProgress;
  @Getter @Setter private boolean anyExtensionsAllowed = false;
  @Getter @Setter private String version;
  @Getter @Setter private String language;
  @Setter private FilesystemPackageCacheManager pcm;
  @Getter private PrintWriter mapLog;
  @Getter @Setter private boolean debug = false;
  @Getter @Setter private IValidatorResourceFetcher fetcher;
  @Getter @Setter private IValidationPolicyAdvisor policyAdvisor;
  @Getter @Setter private IWorkerContextManager.ICanonicalResourceLocator locator;
  @Getter @Setter private boolean noExtensibleBindingMessages;
  @Getter @Setter private String aiService;
  @Getter @Setter private Locale locale;
  @Getter @Setter private List<ImplementationGuide> igs = new ArrayList<>();
  @Getter @Setter private List<String> extensionDomains = new ArrayList<>();
  @Getter @Setter private List<String> certSources = new ArrayList<>();
  @Getter @Setter private List<String> matchetypes = new ArrayList<>();

  // Default validation time out equal to 0 seconds (disabled)
  @Getter @Setter private boolean showTimes;
  @Getter @Setter private FHIRPathEngine fhirPathEngine;
  @Getter @Setter private IgLoader igLoader;

  @Getter
  @Nonnull
  private final InstanceValidatorParameters defaultInstanceValidatorParameters;

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
    anyExtensionsAllowed = other.anyExtensionsAllowed;
    version = other.version;
    language = other.language;
    pcm = other.pcm;
    mapLog = other.mapLog;
    debug = other.debug;
    logValidationProgress = other.logValidationProgress;
    fetcher = other.fetcher;
    policyAdvisor = other.policyAdvisor;
    locator = other.locator;
    noExtensibleBindingMessages = other.noExtensibleBindingMessages;
    aiService = other.aiService;
    locale = other.locale;
    igs.addAll(other.igs);
    extensionDomains.addAll(other.extensionDomains);
    certSources.addAll(other.certSources);
    matchetypes.addAll(other.matchetypes);
    showTimes = other.showTimes;
    fhirPathEngine = other.fhirPathEngine;
    igLoader = other.igLoader;
    displayWarnings = other.displayWarnings;
    defaultInstanceValidatorParameters = new InstanceValidatorParameters(other.defaultInstanceValidatorParameters);
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
  private final Map<String, Boolean> resolvedUrls = new HashMap<>();

  private ValidationEngine()  {
    defaultInstanceValidatorParameters = new InstanceValidatorParameters();
  }

  private ValidationEngine(InstanceValidatorParameters instanceValidatorParameters)  {
    this.defaultInstanceValidatorParameters = Objects.requireNonNullElseGet(instanceValidatorParameters, InstanceValidatorParameters::new);
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
    private final boolean useEcosystem;

    @With
    private final TimeTracker timeTracker;

    @With
    private final boolean canRunWithoutTerminologyServer;

    @With
    private final ILoggingService loggingService;

    @With
    private String thoVersion;

    @With
    private String extensionsVersion;

    @Nonnull
    private InstanceValidatorParameters defaultInstanceValidatorParameters;

    private static final boolean USE_ECOSYSTEM_DEFAULT = true;

    public ValidationEngineBuilder() {
      terminologyCachePath = null;
      userAgent = null;
      version = null;
      txServer = null;
      txLog = null;
      txVersion = null;
      timeTracker = null;
      canRunWithoutTerminologyServer = false;
      useEcosystem = USE_ECOSYSTEM_DEFAULT;
      loggingService = new org.hl7.fhir.r5.context.Slf4JLoggingService(LoggerFactory.getLogger(ValidationEngine.class));
      thoVersion = null;
      extensionsVersion = null;
      defaultInstanceValidatorParameters = new InstanceValidatorParameters();
    }

    private ValidationEngineBuilder(String terminologyCachePath, String userAgent, String version, String txServer, String txLog, FhirPublication txVersion, boolean useEcosystem, TimeTracker timeTracker, boolean canRunWithoutTerminologyServer, ILoggingService loggingService, String thoVersion, String extensionsVersion, InstanceValidatorParameters defaultInstanceValidatorParameters) {
      this.terminologyCachePath = terminologyCachePath;
      this.userAgent = userAgent;
      this.version = version;
      this.txServer = txServer;
      this.txLog = txLog;
      this.txVersion = txVersion;
      this.timeTracker = timeTracker;
      this.canRunWithoutTerminologyServer = canRunWithoutTerminologyServer;
      this.loggingService = loggingService;
      this.useEcosystem = useEcosystem;
      this.thoVersion = thoVersion;
      this.extensionsVersion = extensionsVersion;
      this.defaultInstanceValidatorParameters = defaultInstanceValidatorParameters;
   }

    public ValidationEngineBuilder withTxServer(String txServer, String txLog, FhirPublication txVersion, boolean useEcosystem) {
      return new ValidationEngineBuilder(terminologyCachePath, userAgent, version, txServer, txLog, txVersion, useEcosystem, timeTracker, canRunWithoutTerminologyServer, loggingService, thoVersion, extensionsVersion, defaultInstanceValidatorParameters);
    }

    public ValidationEngineBuilder withNoTerminologyServer() {
      return new ValidationEngineBuilder(terminologyCachePath, userAgent, version, null, null, txVersion, useEcosystem, timeTracker, true, loggingService, thoVersion, extensionsVersion, defaultInstanceValidatorParameters);
    }

    public ValidationEngineBuilder withDefaultInstanceValidatorParameters(InstanceValidatorParameters defaultInstanceValidatorParameters) {
      final InstanceValidatorParameters instanceValidatorParameters = defaultInstanceValidatorParameters == null ? new InstanceValidatorParameters(): defaultInstanceValidatorParameters;
      return new ValidationEngineBuilder(terminologyCachePath, userAgent, version, txServer, txLog, txVersion, useEcosystem, timeTracker, canRunWithoutTerminologyServer, loggingService, thoVersion, extensionsVersion, instanceValidatorParameters);
    }

    public ValidationEngine fromNothing() throws IOException {
      NpmPackageIndexBuilder.setExtensionFactory(new SQLiteINpmPackageIndexBuilderDBImpl.SQLiteINpmPackageIndexBuilderDBImplFactory());
      ValidationEngine engine = new ValidationEngine(defaultInstanceValidatorParameters);
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
      ValidationEngine engine = new ValidationEngine(defaultInstanceValidatorParameters);
      engine.loadCoreDefinitions(src, false, terminologyCachePath, userAgent, timeTracker, loggingService);
      engine.getContext().setCanRunWithoutTerminology(canRunWithoutTerminologyServer);
      engine.getContext().setPackageTracker(engine);
      if (txServer != null) {
        engine.setTerminologyServer(txServer, txLog, txVersion, useEcosystem);
      }
      engine.setVersion(version);
      engine.setIgLoader(new IgLoader(engine.getPcm(), engine.getContext(), engine.getVersion(), engine.isDebug()));
      if (thoVersion != null) {
        loadTx(engine);
      }
      if (extensionsVersion != null) {
        loadExt(engine);
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
        engine.loadPackage(pid, thoVersion);
      }
    }

    private void loadExt(ValidationEngine engine) throws FHIRException, IOException {
      String pid = null;
      if (VersionUtilities.isR3Ver(version)) {
        pid =  "hl7.fhir.uv.extensions.r3";
      }
      if (VersionUtilities.isR4Ver(version)) {
        pid =  "hl7.fhir.uv.extensions.r4";
      }
      if (VersionUtilities.isR4BVer(version)) {
        pid =  "hl7.fhir.uv.extensions.r4";
      }
      if (VersionUtilities.isR5Plus(version)) {
        pid =  "hl7.fhir.uv.extensions.r5";
      }
      if (pid != null) {
        engine.loadPackage(pid, extensionsVersion);
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
  private void loadCoreDefinitions(String src, boolean recursive, String terminologyCachePath, String userAgent, TimeTracker tt, ILoggingService loggingService) throws FHIRException, IOException {
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
      Map<String, ByteProvider> source = igLoader.loadIgSource(src, recursive, true);
      if (version == null) {
        version = getVersionFromPack(source);
      }
      SimpleWorkerContext.SimpleWorkerContextBuilder contextBuilder = new SimpleWorkerContext.SimpleWorkerContextBuilder();
      if (terminologyCachePath != null)
        contextBuilder = contextBuilder.withTerminologyCachePath(terminologyCachePath);
      if (userAgent != null) {
        contextBuilder.withUserAgent(userAgent);
      }
      context = contextBuilder.fromDefinitions(source, ValidatorUtils.loaderForVersion(version), new PackageInformation(src, version, new Date()));
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
    context.setAllowLoadingDuplicates(true); // because of Forge
    context.setExpansionParameters(makeExpProfile());
    if (tt != null) {
      context.setClock(tt);
    }
    NpmPackage npmX = getPcm().loadPackage(CommonPackages.ID_XVER, CommonPackages.VER_XVER);
    context.loadFromPackage(npmX, null);

    this.fhirPathEngine = new FHIRPathEngine(context);
    this.fhirPathEngine.setAllowDoubleQuotes(false);
  }

  private String getVersionFromPack(Map<String, ByteProvider> source) throws FileNotFoundException, IOException {
    if (source.containsKey("version.info")) {
      IniFile vi = new IniFile(new ByteArrayInputStream(removeBom(source.get("version.info").getBytes())));
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

  public String connectToTSServer(String url, String log, FhirPublication version, boolean useEcosystem) throws URISyntaxException, IOException, FHIRException {
    return connectToTSServer(url, log, null, version, useEcosystem);
  }

  public String connectToTSServer(String url, String log, String txCachePath, FhirPublication version, boolean useEcosystem) throws URISyntaxException, IOException, FHIRException {
    context.setTlogging(false);
    if (url == null) {
      context.setCanRunWithoutTerminology(true);
      context.setNoTerminologyServer(true);
      return "n/a: No Terminology Server";
    } else {
      try {
        TerminologyClientFactory factory = new TerminologyClientFactory(version);
        context.connectToTSServer(factory, url, context.getUserAgent(), log, useEcosystem);
        return "Connected to Terminology Server at "+url;
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

    try {
      byte[] source = ProfileLoader.loadProfileSource(src);
      FhirFormat fmt = FormatUtilities.determineFormat(source);
      Resource r = FormatUtilities.makeParser(fmt).parse(source);
      context.cacheResource(r);
    } catch (Exception e) {
      throw new FHIRException("Error loading profile "+src+": "+e.getMessage(), e);
    }
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

  @Deprecated(since="2026-02-20")
  public OperationOutcome validate(String source, List<String> profiles, IValidationEngineLoader loader, boolean all) throws FHIRException, IOException, InterruptedException {
    List<String> l = new ArrayList<String>();
    List<SourceFile> refs = new ArrayList<>();
    l.add(source);
    return (OperationOutcome) validate(l, new InstanceValidatorParameters().setProfiles(profiles), refs, null, loader, all, 0, true);
  }

  public Resource validate(List<String> sources, InstanceValidatorParameters instanceValidatorParameters, List<SourceFile> refs, List<ValidationRecord> record, IValidationEngineLoader loader, boolean all, int delay, boolean first) throws FHIRException, IOException, InterruptedException {
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
      if ((ref.isProcess() || all) && !ref.isKnownToBeMissing()) {
        ref.setCnt(igLoader.loadContent(ref.getRef(), "validate", false, first));
        if (loader != null && ref.getCnt() != null) {
          try {
            loader.load(ref.getCnt());
          } catch (Throwable t) {
            log.debug("Error during round 1 scanning: "+t.getMessage());
          }
        }
      }
    }

    for (SourceFile ref : refs) {
      if ((ref.isProcess() || all) && ref.getCnt() != null) {
        TimeTracker.Session tts = context.clock().start("validation");
        context.clock().milestone();
        log.info("  Validate " + ref.getRef());

        try {
          OperationOutcome outcome = validate(ref.getRef(), ref.getCnt().getFocus(), ref.getCnt().getCntType(), instanceValidatorParameters, record);
          ExtensionUtilities.addStringExtension(outcome, ExtensionDefinitions.EXT_OO_FILE, ref.getRef());
          log.info(" " + context.clock().milestone());
          results.addEntry().setResource(outcome);
          tts.end();
        } catch (Exception e) {
          log.error("Validation Infrastructure fail validating " + ref + ": " + e.getMessage());
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

  public ValidatedFragments validateAsFragments(byte[] source, FhirFormat cntType, InstanceValidatorParameters instanceValidatorParameters, List<ValidationMessage> messages) throws FHIRException, IOException, EOperationOutcome {
    InstanceValidator validator = getValidator(cntType, instanceValidatorParameters);

    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(instanceValidatorParameters.getProfiles()));
    return new ValidatedFragments(validator.validatedContent,
      ValidationTime.fromTimeTracker(validator.timeTracker));
  }

  /**
   * @deprecated
   */
  @Deprecated(since="2026-02-20")
  public OperationOutcome validate(byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationMessage> messages) throws FHIRException, IOException, EOperationOutcome {
    InstanceValidator validator = getValidator(cntType);

    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public OperationOutcome validate(String location, ByteProvider source, FhirFormat cntType, InstanceValidatorParameters instanceValidatorParameters, List<ValidationRecord> record) throws FHIRException, IOException, EOperationOutcome, SAXException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      SchemaValidator.validateSchema(location, cntType, messages);
    }
    InstanceValidator validator = getValidator(cntType, instanceValidatorParameters);

    Element res = validator.validate(null, messages, new ByteArrayInputStream(source.getBytes()), cntType, asSdList(instanceValidatorParameters.getProfiles()));
    boolean first = true;
    for (String fn : matchetypes) {
      if (first) {
        messages.removeIf(msg -> msg.getLevel() != IssueSeverity.FATAL);
        first = false;
      }
      byte[] cnt = FileUtilities.fileToBytes(fn);
      Element exp = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt), FormatUtilities.determineFormat(cnt));
      log.info("  Validate against matchetype " + fn);
      MatchetypeValidator mv = new MatchetypeValidator(validator.getFHIRPathEngine());
      ValidationMessage vm = new ValidationMessage(Source.MatchetypeValidator, IssueType.INFORMATIONAL, res.fhirType(), "Validate aginast Matchetype "+fn, IssueSeverity.INFORMATION);
      messages.add(vm);
      List<ValidationMessage> mtErrors = new ArrayList<ValidationMessage>();
      mv.compare(mtErrors, res.fhirType(), exp, res);
      if (mtErrors.isEmpty()) {
        vm.setMessage(vm.getMessage()+" - All OK");
      } else {
        messages.addAll(mtErrors);
      }
    }

    if (showTimes) {
      log.info(location + ": " + validator.reportTimes());
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

  /**
   * @deprecated
   */
  @Deprecated(since="2026-02-20")
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

  /**
   * Parse FHIR Mapping Language (FML) text into a {@link StructureMap} resource.
   *
   * @param fml          the FML map source text
   * @param srcName      a name for the source (used in parse error messages); defaults to {@code "map"}
   * @param outputFormat format of the returned bytes (JSON or XML)
   */
  public byte[] parseStructureMap(String fml, String srcName, FhirFormat outputFormat) throws FHIRException, IOException {
    StructureMapUtilities scu = new StructureMapUtilities(context);
    StructureMap map = scu.parse(fml, (srcName == null || srcName.trim().isEmpty()) ? "map" : srcName.trim());
    // Emit the StructureMap in the format that matches the engine's runtime FHIR version.
    // Otherwise an R4-mode validator round-tripping an R5-format SM through /loadResource
    // silently drops R5-only fields (e.g., the typed `parameter` array on group-rule
    // dependents, where R4 expects a `variable` string list). See ITB REST spec § version
    // compatibility.
    String effectiveVersion = version != null ? version : (context != null ? context.getVersion() : null);
    return serialiseStructureMapForVersion(map, effectiveVersion, outputFormat);
  }

  /**
   * Convert {@code map} (an R5 StructureMap) to the structure matching
   * {@code targetVersion}, then serialise it in {@code outputFormat}.
   * If {@code targetVersion} is null, R5, or R6 the map is emitted as R5
   * (no conversion needed); for R3, R4, or R4B it is converted via the
   * matching {@link org.hl7.fhir.convertors.factory.VersionConvertorFactory} first.
   */
  private static byte[] serialiseStructureMapForVersion(StructureMap map, String targetVersion, FhirFormat outputFormat) throws FHIRException, IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (targetVersion == null || targetVersion.startsWith("5.") || targetVersion.startsWith("6.")) {
      // Native R5 — keep as-is.
      if (outputFormat == FhirFormat.XML) new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
      else                                new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
    } else if (targetVersion.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource r4 = org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50.convertResource(map);
      if (outputFormat == FhirFormat.XML) new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(baos, r4);
      else                                new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(baos, r4);
    } else if (targetVersion.startsWith("4.3")) {
      org.hl7.fhir.r4b.model.Resource r4b = org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50.convertResource(map);
      if (outputFormat == FhirFormat.XML) new org.hl7.fhir.r4b.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4b.formats.IParser.OutputStyle.PRETTY).compose(baos, r4b);
      else                                new org.hl7.fhir.r4b.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4b.formats.IParser.OutputStyle.PRETTY).compose(baos, r4b);
    } else if (targetVersion.startsWith("3.")) {
      org.hl7.fhir.dstu3.model.Resource r3 = org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50.convertResource(map);
      if (outputFormat == FhirFormat.XML) new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(baos, r3);
      else                                new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(baos, r3);
    } else {
      // Unknown / unsupported — fall back to native R5.
      if (outputFormat == FhirFormat.XML) new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
      else                                new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
    }
    return baos.toByteArray();
  }

  /**
   * CRMI {@code $package}-style operation: given a root canonical artifact, build a
   * {@code collection} Bundle containing that artifact plus every artifact it transitively
   * references — profiles, extensions, ValueSets, CodeSystems, Library, ActivityDefinition,
   * PlanDefinition, ConceptMap, NamingSystem, etc. Core FHIR resources
   * ({@code hl7.fhir.r5.core}) are not included.
   *
   * <p>Dependency discovery uses {@link ResourceDependencyWalker}. When
   * {@code expandValueSets} is true, each ValueSet entry is replaced by its expansion
   * (best effort — an unexpandable ValueSet is included unexpanded).</p>
   *
   * <p>Not implemented (a subset of the full CRMI {@code $package} parameter surface):
   * paging ({@code count}/{@code offset}), {@code contentEndpoint}/{@code terminologyEndpoint},
   * {@code packageOnly}, {@code manifest}, and capability-based filtering.</p>
   *
   * @param rootUrl         canonical URL of the root artifact to package
   * @param expandValueSets when true, ValueSet entries are expanded
   * @param outputFormat    format of the returned bytes (JSON or XML)
   */
  public byte[] packageResource(String rootUrl, boolean expandValueSets, FhirFormat outputFormat)
      throws FHIRException, IOException {
    return packageResource(rootUrl, expandValueSets, false, outputFormat);
  }

  /**
   * Same as {@link #packageResource(String, boolean, FhirFormat)} but with the option to
   * also follow rule-level canonical references inside {@link org.hl7.fhir.r5.model.StructureMap}
   * resources — notably ConceptMap URLs used by {@code translate(...)} transforms. Defaults
   * to {@code false} on the 3-arg overload because rule-walking can pull in a long tail of
   * additional artifacts that some callers don't want.
   */
  public byte[] packageResource(String rootUrl, boolean expandValueSets, boolean includeRuleReferences, FhirFormat outputFormat)
      throws FHIRException, IOException {
    Resource root = context.fetchResource(Resource.class, rootUrl);
    if (root == null) {
      throw new FHIRException("Resource not found: " + rootUrl);
    }

    final java.util.LinkedHashSet<Resource> collected = new java.util.LinkedHashSet<>();
    final List<String> brokenLinks = new ArrayList<>();
    ResourceDependencyWalker walker = new ResourceDependencyWalker(context,
        new ResourceDependencyWalker.IResourceDependencyNotifier() {
          @Override
          public void seeResource(Resource resource, String summaryId) {
            collected.add(resource);
          }
          @Override
          public void brokenLink(String link) {
            brokenLinks.add(link);
          }
        });
    walker.setIncludeRuleReferences(includeRuleReferences);
    walker.walk(root);

    Bundle bundle = new Bundle();
    bundle.setType(Bundle.BundleType.COLLECTION);
    bundle.getMeta().setLastUpdated(new Date());
    for (Resource r : collected) {
      Resource toAdd = r;
      if (expandValueSets && r instanceof ValueSet) {
        try {
          org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome outcome =
              context.expandVS((ValueSet) r, true, false);
          if (outcome.isOk() && outcome.getValueset() != null) {
            toAdd = outcome.getValueset();
          }
        } catch (Exception e) {
          // best effort: keep the unexpanded ValueSet if expansion fails
        }
      }
      BundleEntryComponent entry = bundle.addEntry();
      entry.setResource(toAdd);
      if (toAdd instanceof CanonicalResource && ((CanonicalResource) toAdd).hasUrl()) {
        entry.setFullUrl(((CanonicalResource) toAdd).getUrl());
      } else if (toAdd.hasId()) {
        entry.setFullUrl(toAdd.fhirType() + "/" + toAdd.getIdPart());
      }
    }
    for (String broken : brokenLinks) {
      if (isLikelyNonCanonical(broken)) {
        log.debug("$package: ignoring non-canonical reference " + broken);
        continue;
      }
      log.warn("$package: could not resolve dependency " + broken);
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (outputFormat == FhirFormat.XML) {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, bundle);
    } else {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, bundle);
    }
    return baos.toByteArray();
  }

  /**
   * URLs the dependency walker sometimes hands us that aren't FHIR canonicals — terminology
   * concept identifiers, OIDs, UUIDs, etc. These can show up inside e.g. {@code useContext.valueReference}
   * and trigger spurious "broken link" warnings. Drop them quietly.
   *
   * <p>Walker reports the URL as {@code "<url> from <pkg.id>#<version>"}; we strip the suffix
   * before testing.</p>
   */
  private static boolean isLikelyNonCanonical(String brokenLinkKey) {
    if (brokenLinkKey == null) return true;
    String url = brokenLinkKey;
    int idx = url.indexOf(" from ");
    if (idx > 0) url = url.substring(0, idx);
    if (url.startsWith("urn:oid:")) return true;
    if (url.startsWith("urn:uuid:")) return true;
    if (url.startsWith("urn:ietf:")) return true;
    if (url.startsWith("mailto:")) return true;
    if (url.startsWith("tel:")) return true;
    if (url.startsWith("http://snomed.info/id/")) return true;          // SNOMED concept IRI
    if (url.startsWith("http://snomed.info/sct/") && url.length() > 22  // SNOMED edition / module URI (numeric)
        && Character.isDigit(url.charAt(22))) return true;
    return false;
  }

  /**
   * Parse a FHIR resource from bytes and register it (or every entry of a Bundle of type
   * {@code collection}/{@code batch}/{@code transaction}) in the validator's context so it can
   * later be resolved by canonical URL — same effect as having loaded it from a package.
   *
   * @param content      serialised FHIR resource (JSON or XML)
   * @param inputFormat  format of {@code content} (JSON or XML)
   * @return list of {@code "ResourceType/id"} descriptors for each resource registered
   */
  public List<String> loadResourceFromBytes(byte[] content, FhirFormat inputFormat) throws FHIRException, IOException {
    return loadResourceFromBytes(content, inputFormat, false);
  }

  /**
   * Same as {@link #loadResourceFromBytes(byte[], FhirFormat)} but with an explicit
   * {@code replace} flag. When {@code replace} is {@code true}, an incoming canonical
   * resource whose URL already exists in the context drops the existing copy first and
   * then registers the new one — the authoring loop, where the author iterates on the
   * same artifact (typically an FML-derived StructureMap) and resubmits under the same
   * canonical URL without bumping {@code version} on every edit.
   *
   * @param replace when true, a same-URL canonical resource overwrites the existing one
   *                rather than being reported as {@code (skipped, already in context)}
   */
  public List<String> loadResourceFromBytes(byte[] content, FhirFormat inputFormat, boolean replace) throws FHIRException, IOException {
    String fakeName = "upload." + (inputFormat == FhirFormat.XML ? "xml" : "json");
    // Prefer the engine's configured version; fall back to the context's, since the
    // ValidationEngineBuilder.fromSource(...) path doesn't propagate version onto the engine.
    String effectiveVersion = version != null ? version : (context != null ? context.getVersion() : null);
    if (effectiveVersion == null) {
      throw new FHIRException("ValidationEngine has no FHIR version configured; cannot parse resource bytes");
    }
    String versionWarning = detectVersionFieldLoss(content, inputFormat, effectiveVersion);
    Resource parsed = igLoader.loadResourceByVersion(effectiveVersion, content, fakeName);
    List<String> loaded = new ArrayList<>();
    if (parsed instanceof Bundle) {
      Bundle b = (Bundle) parsed;
      for (BundleEntryComponent e : b.getEntry()) {
        Resource r = e.getResource();
        if (r != null && registerIfNew(r, loaded, replace)) {
          // already accounted for in loaded
        }
      }
    } else if (parsed != null) {
      registerIfNew(parsed, loaded, replace);
    }
    if (versionWarning != null && !loaded.isEmpty()) {
      // Annotate the last descriptor — that's the one whose bytes we scanned.
      int i = loaded.size() - 1;
      loaded.set(i, loaded.get(i) + " " + versionWarning);
    }
    return loaded;
  }

  /**
   * Defensive check for the silent-data-loss case where an R5-format StructureMap JSON
   * is POSTed to a non-R5 validator. The R4 / R4B / R3 JSON parsers drop the R5-only
   * {@code parameter} array on rule dependents (R4 uses {@code variable} instead); the
   * resource loads without an error but the transform engine then sees zero variables
   * on every dependent invocation, producing a misleading runtime error.
   * <p>
   * Returns a human-readable {@code "(warning: ...)"} string to append to the registered
   * resource's descriptor, or {@code null} if no mismatch is detected.
   */
  private static String detectVersionFieldLoss(byte[] content, FhirFormat inputFormat, String effectiveVersion) {
    if (content == null || effectiveVersion == null) return null;
    if (inputFormat != FhirFormat.JSON) return null;        // XML check would mirror this; not common enough to chase
    if (effectiveVersion.startsWith("5.") || effectiveVersion.startsWith("6.")) return null;
    // Cheap content sniff for a StructureMap with R5-only dependent.parameter.
    // We scan the raw bytes: only StructureMaps emit "dependent" near "parameter".
    String text = new String(content, java.nio.charset.StandardCharsets.UTF_8);
    if (!text.contains("\"resourceType\"") || !text.contains("\"StructureMap\"")) return null;
    int depIdx = text.indexOf("\"dependent\"");
    if (depIdx < 0) return null;
    // Look for "parameter" within a few hundred chars after each "dependent" occurrence.
    while (depIdx >= 0) {
      int endIdx = Math.min(text.length(), depIdx + 600);
      String window = text.substring(depIdx, endIdx);
      if (window.contains("\"parameter\"")) {
        return "(warning: incoming StructureMap JSON contains R5-only field 'dependent.parameter' "
             + "but validator is running in version " + effectiveVersion + "; dependent invocations "
             + "may have been silently truncated — run the validator in R5 mode or post an R4-format "
             + "StructureMap that uses 'dependent.variable' instead)";
      }
      depIdx = text.indexOf("\"dependent\"", depIdx + 1);
    }
    return null;
  }

  /**
   * Register {@code r} on the context.
   * <p>
   * Comparison is by canonical URL. If the URL is already present:
   * <ul>
   *   <li>{@code replace == false}: the new resource is skipped and the descriptor in
   *       {@code loaded} is suffixed with {@code (skipped, already in context)}.</li>
   *   <li>{@code replace == true}: the existing resource is dropped from the context
   *       (by {@code fhirType}/{@code id}) and the new one is registered. The descriptor
   *       in {@code loaded} is suffixed with {@code (replaced)}.</li>
   * </ul>
   * The {@code loaded} list is always appended so the caller can tell what happened.
   *
   * @return true if the resource ended up registered (either fresh or replaced),
   *         false if it was skipped
   */
  private boolean registerIfNew(Resource r, List<String> loaded, boolean replace) throws FHIRException {
    if (r instanceof CanonicalResource && ((CanonicalResource) r).hasUrl()) {
      String url = ((CanonicalResource) r).getUrl();
      Resource existing = null;
      try {
        existing = context.fetchResource(Resource.class, url);
      } catch (Throwable t) {
        // Ambiguous lookup or other resolution error — treat as "already here" and bail.
        if (!replace) {
          loaded.add(describeLoaded(r) + " (skipped, already in context)");
          return false;
        }
      }
      if (existing != null) {
        if (!replace) {
          loaded.add(describeLoaded(r) + " (skipped, already in context)");
          return false;
        }
        // Drop by fhirType + id (the worker context indexes by that pair, not by URL).
        try {
          context.dropResource(existing.fhirType(), existing.getIdPart());
        } catch (Throwable t) {
          // If the drop fails we still try to register; cacheResource overwrites the
          // resource map but not always the type-specific caches, so the drop matters
          // for StructureMap etc.
        }
        seeResource(r);
        loaded.add(describeLoaded(r) + " (replaced)");
        return true;
      }
    }
    seeResource(r);
    loaded.add(describeLoaded(r));
    return true;
  }

  private static String describeLoaded(Resource r) {
    if (r instanceof CanonicalResource && ((CanonicalResource) r).hasUrl()) {
      CanonicalResource cr = (CanonicalResource) r;
      return cr.fhirType() + "/" + (cr.hasId() ? cr.getIdPart() : "?") + " (" + cr.getUrl()
          + (cr.hasVersion() ? "|" + cr.getVersion() : "") + ")";
    }
    return r.fhirType() + "/" + (r.hasId() ? r.getIdPart() : "?");
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(ByteProvider source, FhirFormat cntType, String mapUri) throws FHIRException, IOException {
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
    org.hl7.fhir.r5.elementmodel.Element src = parser.parseSingle(new ByteArrayInputStream(source.getBytes()), null);
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
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus().getBytes(), source);
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
      RendererFactory.factory(res, rc).renderResource(ResourceWrapper.forResource(rc.getContextUtilities(), res));
    }
  }

  public void convert(String source, String output) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());
    Manager.compose(context, e, ManagedFileAccess.outStream(output), (output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML), OutputStyle.PRETTY, null);
  }

  public String evaluateFhirPath(String source, String expression) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    FHIRPathEngine fpe = this.getValidator(null).getFHIRPathEngine();
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());
    ExpressionNode exp = fpe.parse(expression);
    return fpe.evaluateToString(new ValidationContext(context), e, e, e, exp);
  }

  public String evaluateFhirPath(byte[] resource, FhirFormat format, String expression) throws FHIRException, IOException {
    FHIRPathEngine fpe = this.getValidator(null).getFHIRPathEngine();
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(resource), format);
    ExpressionNode exp = fpe.parse(expression);
    return fpe.evaluateToString(new ValidationContext(context), e, e, e, exp);
  }

  public OperationOutcome compareMatchetype(byte[] resource, FhirFormat resourceFormat,
      byte[] matchetype, FhirFormat matchetypeFormat) throws FHIRException, IOException {
    InstanceValidator validator = getValidator(resourceFormat);
    Element res = Manager.parseSingle(context, new ByteArrayInputStream(resource), resourceFormat);
    Element exp = Manager.parseSingle(context, new ByteArrayInputStream(matchetype), matchetypeFormat);

    MatchetypeValidator mv = new MatchetypeValidator(validator.getFHIRPathEngine());
    List<ValidationMessage> messages = new ArrayList<>();
    mv.compare(messages, res.fhirType(), exp, res);

    OperationOutcome oo = new OperationOutcome();
    if (messages.isEmpty()) {
      oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.INFORMATION)
        .setCode(OperationOutcome.IssueType.INFORMATIONAL)
        .getDetails().setText("Matchetype comparison: All OK");
    } else {
      for (ValidationMessage msg : messages) {
        oo.addIssue()
          .setSeverity(OperationOutcome.IssueSeverity.fromCode(msg.getLevel().toCode()))
          .setCode(OperationOutcome.IssueType.fromCode(msg.getType().toCode()))
          .getDetails().setText(msg.getMessage());
      }
    }
    return oo;
  }

  public byte[] generateTestData(String profileUrl, org.hl7.fhir.utilities.json.model.JsonArray data,
      org.hl7.fhir.utilities.json.model.JsonArray mappings, FhirFormat outputFormat, boolean asBundle, boolean requiredOnly) throws Exception {
    StructureDefinition profile = context.fetchResource(StructureDefinition.class, profileUrl);
    if (profile == null) {
      throw new FHIRException("Profile not found: " + profileUrl);
    }
    if (!profile.hasSnapshot()) {
      new ProfileUtilities(context, null, null).setAutoFixSliceNames(true)
          .generateSnapshot(context.fetchResource(StructureDefinition.class, profile.getBaseDefinition()),
              profile, profile.getUrl(), null, profile.getName());
    }

    FHIRPathEngine fpe = new FHIRPathEngine(context);
    TestDataHostServices hs = new TestDataHostServices(context,
        new DateTimeType(new Date()), new DateType(new Date()),
        new StringType(VersionUtilities.getSpecUrl(context.getVersion())));
    hs.registerFunction(new GlobalObjectRandomFunction());
    hs.registerFunction(new BaseTableWrapper.TableColumnFunction());
    hs.registerFunction(new BaseTableWrapper.TableDateColumnFunction());
    hs.registerFunction(new TestDataFactory.CellLookupFunction());
    hs.registerFunction(new TestDataFactory.TableLookupFunction());
    fpe.setHostServices(hs);

    // Ensure base test data SQLite file is available
    String baseDataPath = Utilities.path("[tmp]", "fhir-test-data.db");
    File baseDataFile = new File(baseDataPath);
    if (!baseDataFile.exists()) {
      try {
        org.hl7.fhir.utilities.json.model.JsonObject json = org.hl7.fhir.utilities.json.parser.JsonParser.parseObjectFromUrl("https://www.fhir.org/downloads/test-data-versions.json");
        org.hl7.fhir.utilities.json.model.JsonObject current = json.forceArray("versions").get(0).asJsonObject();
        String filename = current.asString("filename");
        org.hl7.fhir.utilities.http.HTTPResult result = org.hl7.fhir.utilities.http.ManagedWebAccess.get(Utilities.strings("general"), "https://www.fhir.org/downloads/" + filename);
        FileUtilities.bytesToFile(result.getContent(), baseDataFile);
      } catch (Exception e) {
        throw new FHIRException("Unable to download FHIR base test data (fhir-test-data.db). " +
            "Run the validator once with -instance-factory to download it, or check network access: " + e.getMessage(), e);
      }
    }

    InlineTableDataProvider tbl = new InlineTableDataProvider(data);
    ProfileBasedFactory factory = new ProfileBasedFactory(fpe,
        baseDataPath, tbl, new HashMap<>(),
        mappings != null ? mappings : new org.hl7.fhir.utilities.json.model.JsonArray());
    factory.setTesting(true);
    factory.setRequiredOnly(requiredOnly);

    if (asBundle) {
      Element bundle = Manager.parse(context,
          new ByteArrayInputStream("{\"resourceType\":\"Bundle\",\"type\":\"collection\"}".getBytes()), FhirFormat.JSON).get(0).getElement();
      bundle.makeElement("id").setValue(java.util.UUID.randomUUID().toString().toLowerCase());
      while (tbl.nextRow()) {
        Element resource = factory.generate(profile);
        Element be = bundle.makeElement("entry");
        be.makeElement("fullUrl").setValue("urn:uuid:" + java.util.UUID.randomUUID().toString().toLowerCase());
        be.makeElement("resource").getChildren().addAll(resource.getChildren());
      }
      tbl.reset();
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      Manager.compose(context, bundle, bs, outputFormat, OutputStyle.PRETTY, null);
      return bs.toByteArray();
    } else {
      if (tbl.nextRow()) {
        byte[] result = factory.generateFormat(profile, outputFormat);
        tbl.reset();
        return result;
      } else {
        throw new FHIRException("No data rows provided for test data generation");
      }
    }
  }

  public byte[] convertFormat(byte[] resource, FhirFormat inputFormat, FhirFormat outputFormat) throws FHIRException, IOException {
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(resource), inputFormat);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Manager.compose(context, e, baos, outputFormat, OutputStyle.PRETTY, null);
    return baos.toByteArray();
  }

  /**
   * Result of a {@link #manipulateResource} call. {@code resource} is the mutated
   * resource (always populated); {@code outcome} is the post-mutation validation
   * report, populated only when {@code enforce} was true.
   */
  public static class ManipulationResult {
    private final byte[] resource;
    private final OperationOutcome outcome;
    public ManipulationResult(byte[] resource, OperationOutcome outcome) {
      this.resource = resource;
      this.outcome = outcome;
    }
    public byte[] getResource() { return resource; }
    public OperationOutcome getOutcome() { return outcome; }
  }

  /**
   * Mutate an existing FHIR resource by applying a sequence of
   * {@code set} / {@code add} / {@code remove} operations, optionally validating the
   * result against a profile.
   *
   * @param inputBytes    serialised input resource
   * @param inputFormat   format of {@code inputBytes}
   * @param profileUrl    optional canonical URL of a StructureDefinition to validate
   *                      against (when {@code enforce} is true). Ignored otherwise.
   * @param operations    JSON array of operation entries (see ProfileBasedManipulator)
   * @param enforce       when true, post-mutation validation runs against {@code profileUrl}
   *                      (or base FHIR if absent) and the OperationOutcome is returned in
   *                      the result. Validation NEVER throws — callers inspect the outcome.
   * @param outputFormat  format of the result bytes
   */
  public ManipulationResult manipulateResource(byte[] inputBytes, FhirFormat inputFormat,
      String profileUrl, org.hl7.fhir.utilities.json.model.JsonArray operations,
      boolean enforce, FhirFormat outputFormat) throws Exception {
    Element element = Manager.parseSingle(context, new ByteArrayInputStream(inputBytes), inputFormat);

    if (profileUrl != null && !profileUrl.isEmpty()) {
      StructureDefinition profile = context.fetchResource(StructureDefinition.class, profileUrl);
      if (profile == null) {
        throw new FHIRException("Profile not found: " + profileUrl);
      }
      if (!profile.hasSnapshot()) {
        new ProfileUtilities(context, null, null).setAutoFixSliceNames(true)
            .generateSnapshot(context.fetchResource(StructureDefinition.class, profile.getBaseDefinition()),
                profile, profile.getUrl(), null, profile.getName());
      }
    }

    FHIRPathEngine fpe = new FHIRPathEngine(context);
    new ProfileBasedManipulator(fpe).apply(element, operations);

    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context, element, bs, outputFormat, OutputStyle.PRETTY, null);
    byte[] mutated = bs.toByteArray();

    OperationOutcome outcome = null;
    if (enforce) {
      InstanceValidatorParameters params = new InstanceValidatorParameters();
      if (profileUrl != null && !profileUrl.isEmpty()) {
        params.addProfile(profileUrl);
      }
      outcome = validate("manipulate", ByteProvider.forBytes(mutated), outputFormat, params, new ArrayList<>());
    }
    return new ManipulationResult(mutated, outcome);
  }

  public byte[] generateSnapshot(byte[] resource, FhirFormat format) throws FHIRException, IOException {
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(resource), format);
    Resource res = new ObjectConverter(context).convert(e);
    if (!(res instanceof StructureDefinition))
      throw new FHIRException("Require a StructureDefinition for generating a snapshot");
    StructureDefinition sd = (StructureDefinition) res;
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    if (base == null)
      throw new FHIRException("Unable to find base definition: " + sd.getBaseDefinition());
    new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(base, sd, sd.getUrl(), null, sd.getName());
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (format == FhirFormat.XML) {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, sd);
    } else {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, sd);
    }
    return baos.toByteArray();
  }

  public byte[] generateNarrative(byte[] resource, FhirFormat format) throws FHIRException, IOException, EOperationOutcome {
    Element e = Manager.parseSingle(context, new ByteArrayInputStream(resource), format);
    Resource res = new ObjectConverter(context).convert(e);
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    genResource(res, rc);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (format == FhirFormat.XML) {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, res);
    } else {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, res);
    }
    return baos.toByteArray();
  }

  public byte[] transform(byte[] resource, FhirFormat format, String mapUri, FhirFormat outputFormat) throws FHIRException, IOException {
    Element result = transform(ByteProvider.forBytes(resource), format, mapUri);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Manager.compose(context, result, baos, outputFormat, OutputStyle.PRETTY, null);
    return baos.toByteArray();
  }

  /**
   * Build a FHIR Questionnaire from a StructureDefinition profile, covering the
   * whole profile. Equivalent to
   * {@link #generateQuestionnaire(String, FhirFormat, List)} with no selection.
   */
  public byte[] generateQuestionnaire(String profileUrl, FhirFormat outputFormat) throws FHIRException, IOException {
    return generateQuestionnaire(profileUrl, outputFormat, null);
  }

  /**
   * Build a FHIR Questionnaire from a StructureDefinition profile. The Questionnaire
   * is always built from the profile's <b>snapshot</b> (one is generated on the fly if
   * absent). Coded elements have their ValueSets expanded and attached as answer options.
   * The profile must already be resolvable in the engine context (load the containing
   * IG first).
   *
   * <p>When {@code selectExpressions} is non-empty, the full Questionnaire is built and
   * then <b>pruned</b>: each FHIRPath expression is evaluated against every
   * {@code ElementDefinition} of the snapshot, and an element is "selected" if <i>any</i>
   * expression evaluates to {@code true} for it. A Questionnaire item is kept when its
   * element path is selected, is an ancestor of a selected path, or is a descendant of a
   * selected path — so the item tree stays connected. MustSupport filtering is not a
   * special case: pass {@code "mustSupport = true"} as one of the expressions.</p>
   *
   * <p>When {@code selectExpressions} is null/empty the whole Questionnaire is returned.</p>
   *
   * @param profileUrl        canonical URL of the StructureDefinition profile
   * @param outputFormat      format of the returned bytes (JSON or XML)
   * @param selectExpressions FHIRPath expressions evaluated per ElementDefinition;
   *                          null/empty = keep everything
   */
  public byte[] generateQuestionnaire(String profileUrl, FhirFormat outputFormat,
      List<String> selectExpressions) throws FHIRException, IOException {
    StructureDefinition profile = context.fetchResource(StructureDefinition.class, profileUrl);
    if (profile == null) {
      throw new FHIRException("Profile not found: " + profileUrl);
    }
    if (!profile.hasSnapshot()) {
      new ProfileUtilities(context, null, null).setAutoFixSliceNames(true)
          .generateSnapshot(context.fetchResource(StructureDefinition.class, profile.getBaseDefinition()),
              profile, profile.getUrl(), null, profile.getName());
    }

    org.hl7.fhir.r5.utils.QuestionnaireBuilder builder =
        new org.hl7.fhir.r5.utils.QuestionnaireBuilder(context, profile.getUrl());
    builder.setProfile(profile);
    builder.build();
    org.hl7.fhir.r5.model.Questionnaire questionnaire = builder.getQuestionnaire();

    if (selectExpressions != null && !selectExpressions.isEmpty()) {
      java.util.Set<String> selectedPaths = selectElementPaths(profile, selectExpressions);
      if (selectedPaths.isEmpty()) {
        throw new FHIRException("None of the select expressions matched any element in profile " + profileUrl);
      }
      pruneQuestionnaireItems(questionnaire.getItem(), selectedPaths);
      if (questionnaire.getItem().isEmpty()) {
        throw new FHIRException("Element selection pruned the entire Questionnaire for profile " + profileUrl);
      }
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (outputFormat == FhirFormat.XML) {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, questionnaire);
    } else {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, questionnaire);
    }
    return baos.toByteArray();
  }

  /**
   * Evaluate each FHIRPath expression against every {@code ElementDefinition} in the
   * profile's snapshot; collect the {@code path} of every element for which at least
   * one expression evaluates to a singleton {@code true}.
   */
  private java.util.Set<String> selectElementPaths(StructureDefinition profile, List<String> expressions) {
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    List<ExpressionNode> compiled = new ArrayList<>();
    for (String e : expressions) {
      if (e != null && !e.trim().isEmpty()) {
        compiled.add(fpe.parse(e.trim()));
      }
    }
    java.util.Set<String> selected = new java.util.HashSet<>();
    for (ElementDefinition ed : profile.getSnapshot().getElement()) {
      for (ExpressionNode node : compiled) {
        boolean matched;
        try {
          List<Base> outcome = fpe.evaluate(ed, node);
          matched = outcome.size() == 1 && outcome.get(0).isPrimitive()
              && "true".equals(outcome.get(0).primitiveValue());
        } catch (Exception ex) {
          matched = false; // an expression that doesn't apply to this element is just a non-match
        }
        if (matched) {
          selected.add(ed.getPath());
          break;
        }
      }
    }
    return selected;
  }

  /**
   * Recursively prune a Questionnaire item list to the selected element paths.
   * An item is kept when its element path (derived from its {@code linkId}) is
   * selected, is an ancestor of a selected path, or is a descendant of one — or
   * when it still has kept children. Returns true if the list is non-empty after pruning.
   */
  private static boolean pruneQuestionnaireItems(
      List<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent> items,
      java.util.Set<String> selectedPaths) {
    items.removeIf(item -> {
      boolean keptChildren = pruneQuestionnaireItems(item.getItem(), selectedPaths);
      String itemPath = elementPathOfLinkId(item.getLinkId());
      boolean relevant = relatesToSelection(itemPath, selectedPaths);
      return !relevant && !keptChildren;
    });
    return !items.isEmpty();
  }

  /**
   * Derive the element path a Questionnaire item corresponds to from its {@code linkId}.
   * The QuestionnaireBuilder sets linkIds to the element path, sometimes with a
   * {@code -grp} / {@code -display} / {@code -flyover} suffix or a {@code ._type}-style
   * tail; slice names ({@code :sliceName}) are stripped so sliced and unsliced map alike.
   */
  private static String elementPathOfLinkId(String linkId) {
    if (linkId == null) {
      return "";
    }
    String s = linkId;
    for (String suffix : new String[] {"-grp", "-display", "-flyover"}) {
      if (s.endsWith(suffix)) {
        s = s.substring(0, s.length() - suffix.length());
      }
    }
    int us = s.indexOf("._"); // type sub-items, e.g. Patient.deceased._boolean
    if (us >= 0) {
      s = s.substring(0, us);
    }
    StringBuilder b = new StringBuilder();
    for (String seg : s.split("\\.", -1)) {
      int colon = seg.indexOf(':');
      if (b.length() > 0) {
        b.append('.');
      }
      b.append(colon >= 0 ? seg.substring(0, colon) : seg);
    }
    return b.toString();
  }

  private static boolean relatesToSelection(String itemPath, java.util.Set<String> selectedPaths) {
    if (itemPath == null || itemPath.isEmpty()) {
      return false;
    }
    for (String sel : selectedPaths) {
      if (itemPath.equals(sel)                       // the item is itself selected
          || sel.startsWith(itemPath + ".")          // the item is an ancestor of a selection
          || itemPath.startsWith(sel + ".")) {       // the item is a descendant of a selection
        return true;
      }
    }
    return false;
  }

  public byte[] convertVersion(byte[] resource, FhirFormat format, String targetVer) throws Exception {
    Content cnt = new Content();
    cnt.setFocus(ByteProvider.forBytes(resource));
    cnt.setCntType(format);
    Element src = Manager.parseSingle(context, new ByteArrayInputStream(resource), format);
    boolean canDoNative = src.hasChild("url", false);
    if (canDoNative) {
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
      } else {
        throw new FHIRException("Source version not supported yet: " + version);
      }
    }
    throw new FHIRException("Version conversion via StructureMap not supported in HTTP mode. Resource must have a 'url' element for native conversion.");
  }

  public byte[] compileMap(String mapUri, FhirFormat outputFormat) throws FHIRException, IOException {
    StructureMap map = context.fetchResource(StructureMap.class, mapUri);
    if (map == null) throw new FHIRException("Unable to find map: " + mapUri + " (Known Maps = " + context.listMapUrls() + ")");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (outputFormat == FhirFormat.XML) {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
    } else {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(baos, map);
    }
    return baos.toByteArray();
  }

  public StructureDefinition snapshot(String source, String version) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus().getBytes(), Utilities.getFileNameForName(source));

    if (!(res instanceof StructureDefinition))
      throw new FHIRException("Require a StructureDefinition for generating a snapshot");
    StructureDefinition sd = (StructureDefinition) res;
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());

    new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(base, sd, sd.getUrl(), null, sd.getName());
    return sd;
  }

  public CanonicalResource loadCanonicalResource(String source, String version) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    Resource res = igLoader.loadResourceByVersion(version, cnt.getFocus().getBytes(), Utilities.getFileNameForName(source));

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
    return getValidator(format, defaultInstanceValidatorParameters);
  }

  public InstanceValidator getValidator(FhirFormat format, InstanceValidatorParameters instanceValidatorParameters) throws FHIRException, IOException {
    InstanceValidator validator = new InstanceValidator(context, null, null, new ValidatorSession(), new ValidatorSettings());
    context.getTxClientManager().setUsage("validation");

    validator.initializeFromParameters(instanceValidatorParameters);

    validator.getSettings().getCertificateFolders().clear(); // they should be empty though
    validator.getSettings().getCertificates().clear();
    validator.getSettings().getCertificateFolders().addAll(FhirSettings.getCertificateSources());
    for (String s : certSources) {
      File f = ManagedFileAccess.file(s);
      if (f.isDirectory()) {
        validator.getSettings().getCertificateFolders().add(s);
      } else {
        validator.getSettings().getCertificates().put(s, FileUtilities.fileToBytes(f));
      }
    }

    validator.setValidationLanguage(language);
    validator.getSettings().setDisplayWarningMode(isDisplayWarnings());
    if (language != null) {
      if (locale == null) {
        locale = Locale.forLanguageTag(language);
      }
    }
    validator.setAssumeValidRestReferences(instanceValidatorParameters.isAssumeValidRestReferences());
    validator.setNoExtensibleWarnings(noExtensibleBindingMessages);

    validator.getContext().getManager().setLocale(locale);
    validator.setFetcher(this);
    validator.getImplementationGuides().addAll(igs);
    validator.getValidationControl().putAll(validationControl);
    validator.setAIService(aiService);

    validator.setCheckIPSCodes(instanceValidatorParameters.isCheckIPSCodes());

    validator.setCacheFolder(context.getTxCache().getFolder());
    if (format == FhirFormat.SHC) {
      igLoader.loadIg(getIgs(), getBinaries(), SHCParser.CURRENT_PACKAGE, true);
    }

    validator.setLogProgress(logValidationProgress);
    if (policyAdvisor != null) {
      validator.setPolicyAdvisor(policyAdvisor);
    }
    return validator;
  }

  public void prepare() {
    for (StructureDefinition sd : new ContextUtilities(context).allStructures()) {
      try {
        makeSnapshot(sd);
      } catch (Exception e) {
        log.info("Process Note: Unable to generate snapshot for " + sd.present() + ": " + e.getMessage());
        context.getLogger().logDebugMessage(ILoggingService.LogCategory.GENERATE, ExceptionUtils.getStackTrace(e));
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
      HTTPResult res = ManagedWebAccess.post(Arrays.asList("web"), output, bs.toByteArray(), "application/fhir+xml", "application/fhir+xml");
      res.checkThrowException();
    } else {
      FileOutputStream s = ManagedFileAccess.outStream(output);
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
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (VersionUtilities.isR4Ver(version)) {
      org.hl7.fhir.r4.model.Resource res = VersionConvertorFactory_40_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        FileUtilities.stringToStream(org.hl7.fhir.r4.utils.StructureMapUtilities.render((org.hl7.fhir.r4.model.StructureMap) res), s);
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
        FileUtilities.stringToStream(StructureMapUtilities.render((org.hl7.fhir.r5.model.StructureMap) r), s);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else
      throw new FHIRException("Encountered unsupported configured version " + version + " loading " + fn);

    s.close();
  }

  public byte[] transformVersion(String source, String targetVer, FhirFormat format, Boolean canDoNative) throws FHIRException, IOException, Exception {
    Content cnt = igLoader.loadContent(source, "validate", false, true);
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parseSingle(context, new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());

    // if the src has a url, we try to use the java code 
    if ((canDoNative == null && src.hasChild("url", false)) || (canDoNative != null && canDoNative)) {
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
        log.error("Conversion failed using Java convertor: " + e.getMessage());
      }
    }
    // ok, we try converting using the structure maps
    log.info("Loading hl7.fhir.xver.r4");
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

  public String setTerminologyServer(String src, String log, FhirPublication version, boolean useEcosystem) throws FHIRException, URISyntaxException, IOException {
    return connectToTSServer(src, log, version, useEcosystem);
  }

  public ValidationEngine setMapLog(String mapLog) throws FileNotFoundException {
    if (mapLog != null) {
      this.mapLog = new PrintWriter(mapLog);
    }
    return this;
  }

  public ValidationEngine setSnomedExtension(String sct) {
    Parameters p = getContext().getExpansionParameters();
    p.getParameter().removeIf(pp -> "system-version".equals(pp.getName()) && pp.hasValueCanonicalType() && pp.getValueCanonicalType().primitiveValue().startsWith("http://snomed.info/sct|"));
    if (sct != null) {
      p.addParameter("system-version", new CanonicalType("http://snomed.info/sct|http://snomed.info/sct/" + sct));
    }
    getContext().setExpansionParameters(p);
    return this;
  }

  public FilesystemPackageCacheManager getPcm() throws IOException {
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager.Builder().build();
    }
    return pcm;
  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String source) throws IOException {
    HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), source);
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
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url, ReferenceDestinationType destinationType) {
    Resource resource = context.fetchResource(StructureDefinition.class, url);
    if (resource != null) {
      return ReferenceValidationPolicy.CHECK_VALID;
    }
    if (!(url.contains("hl7.org") || url.contains("fhir.org"))) {
      return ReferenceValidationPolicy.IGNORE;
    } else if (policyAdvisor != null) {
      return policyAdvisor.policyForReference(validator, appContext, path, url, destinationType);
    } else {
      return ReferenceValidationPolicy.CHECK_EXISTS_AND_TYPE;
    }
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
      Object appContext,
      StructureDefinition structure,
      ElementDefinition element,
      String containerType,
      String containerId,
      Element.SpecialElement containingResourceType,
      String path,
      String url) {
    return ContainedReferenceValidationPolicy.CHECK_VALID;
  }

  @Override
  public EnumSet<CodedContentValidationAction>  policyForCodedContent(IResourceValidator validator,
      Object appContext,
      String stackPath,
      ElementDefinition definition,
      StructureDefinition structure,
      BindingKind kind,
      AdditionalBindingPurpose purpose,
      ValueSet valueSet,
      List<String> systems) {
    return EnumSet.allOf(CodedContentValidationAction.class);
  }

  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, IWorkerContext.VersionResolutionRules rules, String type, boolean canonical, List<CanonicalType> targets) throws FHIRException {
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
    if (NamingSystemUtilities.hasNamingSystem(context, url)) {
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
        boolean ok = fetcher.resolveURL(validator, appContext, path, url, rules, type, canonical, targets);
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
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, Object appContext, String url) throws URISyntaxException {
    Resource res = context.fetchResource(Resource.class, url);
    if (res != null) {
      if (res instanceof CanonicalResource) {
        return (CanonicalResource) res;
      } else {
        return null;
      }
    }
    return fetcher != null ? fetcher.fetchCanonicalResource(validator, appContext, url) : null;
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

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    return EnumSet.allOf(ResourceValidationAction.class);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    return EnumSet.allOf(ElementValidationAction.class);
  }

  @Override
  public Set<ResourceVersionInformation> fetchCanonicalResourceVersions(IResourceValidator validator, Object appContext, String url) {
    Set<ResourceVersionInformation> res = new HashSet<>();
    for (Resource r : context.fetchResourceVersions(Resource.class, url)) {
      if (r instanceof CanonicalResource) {
        CanonicalResource cr = (CanonicalResource) r;
        res.add(new ResourceVersionInformation(cr.hasVersion() ? cr.getVersion() : "{{unversioned}}", cr.getSourcePackage()));
      }
    }
    if (fetcher != null) {
        res.addAll(fetcher.fetchCanonicalResourceVersions(validator, appContext, url));
    }
    return res;
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
      IMessagingServices msgServices, List<ValidationMessage> messages) {
    return new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.CHECK_VALID, null).getImpliedProfilesForResource(validator, appContext, stackPath,
          definition, structure, resource, valid, msgServices, messages);
  }

  @Override
  public String relativeDatePlaceHolder() {
    return policyAdvisor.relativeDatePlaceHolder();
  }

  @Override
  public boolean isSuppressMessageId(String path, String messageId, Object... theMessageArguments) {
    return policyAdvisor.isSuppressMessageId(path, messageId, theMessageArguments);
  }

  @Override
  public ReferenceValidationPolicy getReferencePolicy() {
    return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public Set<String> getCheckReferencesTo() {
    return policyAdvisor.getCheckReferencesTo();
  }

  public void loadExpansionParameters(String expansionParameters) {
    log.info("Load Expansion Parameters: "+expansionParameters);
    Parameters p = null;
    try {
      p = (Parameters) new XmlParser().parse(new FileInputStream(expansionParameters));
    } catch (Exception e) {
    }
    if (p == null) {
      try {
        p = (Parameters) new JsonParser().parse(new FileInputStream(expansionParameters));
      } catch (Exception e) {
        log.error("Unable to load expansion parameters '"+expansionParameters+"' as either xml or json: "+e.getMessage());
        throw new FHIRException("Unable to load expansion parameters '"+expansionParameters+"' as either xml or json: "+e.getMessage());
      }
    }
    context.setExpansionParameters(p);


  }

  @Override
  public SpecialValidationAction policyForSpecialValidation(IResourceValidator validator, Object appContext, SpecialValidationRule rule, String stackPath, Element resource, Element element) {
    return SpecialValidationAction.CHECK_RULE;
  }

  /*
  * What follows below are the set of methods that used to refer to fields in ValidationEngine that have now been moved
  * to defaultInstanceValidatorParameters. Usages of these methods is strongly discouraged as they will later be removed.
  * */

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isAllowExampleUrls() {
    return defaultInstanceValidatorParameters.isAllowExampleUrls();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setAllowExampleUrls(boolean allowExampleUrls) {
    defaultInstanceValidatorParameters.setAllowExampleUrls(allowExampleUrls);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isAllowDoubleQuotesInFHIRPath() {
    return defaultInstanceValidatorParameters.isAllowDoubleQuotesInFHIRPath();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setAllowDoubleQuotesInFHIRPath(boolean allowDoubleQuotesInFHIRPath) {
    defaultInstanceValidatorParameters.setAllowDoubleQuotesInFHIRPath(allowDoubleQuotesInFHIRPath);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isShowMessagesFromReferences() {
    return defaultInstanceValidatorParameters.isShowMessagesFromReferences();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setShowMessagesFromReferences(boolean showMessagesFromReferences) {
    defaultInstanceValidatorParameters.setShowMessagesFromReferences(showMessagesFromReferences);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isHintAboutNonMustSupport() {
    return defaultInstanceValidatorParameters.isHintAboutNonMustSupport();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    defaultInstanceValidatorParameters.setHintAboutNonMustSupport(hintAboutNonMustSupport);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isAssumeValidRestReferences() {
    return defaultInstanceValidatorParameters.isAssumeValidRestReferences();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    defaultInstanceValidatorParameters.setAssumeValidRestReferences(assumeValidRestReferences);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public BestPracticeWarningLevel getBestPracticeLevel() {
    return defaultInstanceValidatorParameters.getBestPracticeLevel();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setBestPracticeLevel(BestPracticeWarningLevel bestPracticeLevel) {
    defaultInstanceValidatorParameters.setBestPracticeLevel(bestPracticeLevel);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public List<BundleValidationRule> getBundleValidationRules() {
    return defaultInstanceValidatorParameters.getBundleValidationRules();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setBundleValidationRules(List<BundleValidationRule> bundleValidationRules) {
    defaultInstanceValidatorParameters.setBundleValidationRules(bundleValidationRules);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isCheckIPSCodes() {
    return defaultInstanceValidatorParameters.isCheckIPSCodes();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setCheckIPSCodes(boolean checkIPSCodes) {
    defaultInstanceValidatorParameters.setCheckIPSCodes(checkIPSCodes);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isCrumbTrails() {
    return defaultInstanceValidatorParameters.isCrumbTrails();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setCrumbTrails(boolean crumbTrails) {
    defaultInstanceValidatorParameters.setCrumbTrails(crumbTrails);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isDoImplicitFHIRPathStringConversion() {
    return defaultInstanceValidatorParameters.isDoImplicitFHIRPathStringConversion();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setDoImplicitFHIRPathStringConversion(boolean doImplicitFHIRPathStringConversion) {
    defaultInstanceValidatorParameters.setDoImplicitFHIRPathStringConversion(doImplicitFHIRPathStringConversion);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isForPublication() {
    return defaultInstanceValidatorParameters.isForPublication();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setForPublication(boolean forPublication) {
    defaultInstanceValidatorParameters.setForPublication(forPublication);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public HtmlInMarkdownCheck getHtmlInMarkdownCheck() {
    return defaultInstanceValidatorParameters.getHtmlInMarkdownCheck();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setHtmlInMarkdownCheck(HtmlInMarkdownCheck htmlInMarkdownCheck) {
    defaultInstanceValidatorParameters.setHtmlInMarkdownCheck(htmlInMarkdownCheck);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public Coding getJurisdiction() {
    return CodeSystemUtilities.readCoding(defaultInstanceValidatorParameters.getJurisdiction());
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setJurisdiction(Coding jurisdiction) {
    // This may not be entirely correct, but this also a completely unused method.
    defaultInstanceValidatorParameters.setJurisdiction(jurisdiction.getCode());
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationLevel getLevel() {
    return defaultInstanceValidatorParameters.getLevel();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setLevel(ValidationLevel level) {
    defaultInstanceValidatorParameters.setLevel(level);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isNoExperimentalContent() {
    return defaultInstanceValidatorParameters.isNoExperimentalContent();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setNoExperimentalContent(boolean noExperimentalContent) {
    defaultInstanceValidatorParameters.setNoExperimentalContent(noExperimentalContent);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isNoInvariantChecks() {
    return defaultInstanceValidatorParameters.isNoInvariants();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setNoInvariantChecks(boolean noInvariantChecks) {
    defaultInstanceValidatorParameters.setNoInvariants(noInvariantChecks);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isNoUnicodeBiDiControlChars() {
    return defaultInstanceValidatorParameters.isNoUnicodeBiDiControlChars();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setNoUnicodeBiDiControlChars(boolean noUnicodeBiDiControlChars) {
    defaultInstanceValidatorParameters.setNoUnicodeBiDiControlChars(noUnicodeBiDiControlChars);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public QuestionnaireMode getQuestionnaireMode() {
    return defaultInstanceValidatorParameters.getQuestionnaireMode();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setQuestionnaireMode(QuestionnaireMode questionnaireMode) {
    defaultInstanceValidatorParameters.setQuestionnaireMode(questionnaireMode);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public R5BundleRelativeReferencePolicy getR5BundleRelativeReferencePolicy() {
    return defaultInstanceValidatorParameters.getR5BundleRelativeReferencePolicy();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    defaultInstanceValidatorParameters.setR5BundleRelativeReferencePolicy(r5BundleRelativeReferencePolicy);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isSecurityChecks() {
    return defaultInstanceValidatorParameters.isSecurityChecks();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setSecurityChecks(boolean securityChecks) {
    defaultInstanceValidatorParameters.setSecurityChecks(securityChecks);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isShowMessageIds() {
    return defaultInstanceValidatorParameters.isShowMessageIds();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setShowMessageIds(boolean showMessageIds) {
    defaultInstanceValidatorParameters.setShowMessageIds(showMessageIds);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isUnknownCodeSystemsCauseErrors() {
    return defaultInstanceValidatorParameters.isUnknownCodeSystemsCauseErrors();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setUnknownCodeSystemsCauseErrors(boolean unknownCodeSystemsCauseErrors) {
    defaultInstanceValidatorParameters.setUnknownCodeSystemsCauseErrors(unknownCodeSystemsCauseErrors);
    return this;
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public boolean isWantInvariantInMessage() {
    return defaultInstanceValidatorParameters.isWantInvariantsInMessages();
  }

  /**
   * @deprecated This field is now managed by InstanceValidatorParameters. An instance of that parameters object should
   * be used for all getting and setting purposes, and that instance should be passed to ValidationEngine instead of
   * using this method.
   * @since 2025-10-24
   */
  @Deprecated(since = "2025-10-24")
  public ValidationEngine setWantInvariantInMessage(boolean wantInvariantInMessage) {
    defaultInstanceValidatorParameters.setWantInvariantsInMessages(wantInvariantInMessage);
    return this;
  }
}
