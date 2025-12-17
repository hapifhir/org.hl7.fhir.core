package org.hl7.fhir.validation.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.Slf4JLoggingService;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ValidatedFragment;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.liquid.BaseTableWrapper;
import org.hl7.fhir.r5.liquid.GlobalObject.GlobalObjectRandomFunction;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator.ExtensionPolicy;
import org.hl7.fhir.r5.renderers.spreadsheets.CodeSystemSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ConceptMapSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.StructureDefinitionSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ValueSetSpreadsheetGenerator;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.InternalLogEvent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.testfactory.TestDataFactory;
import org.hl7.fhir.r5.testfactory.TestDataHostServices;
import org.hl7.fhir.r5.Constants;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.i18n.JsonLangFileProducer;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer;
import org.hl7.fhir.utilities.i18n.XLIFFProducer;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ResourceChecker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidationRecord;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;

import org.hl7.fhir.validation.service.model.*;
import org.hl7.fhir.validation.service.renderers.CSVRenderer;
import org.hl7.fhir.validation.service.renderers.CompactRenderer;
import org.hl7.fhir.validation.service.renderers.DefaultRenderer;
import org.hl7.fhir.validation.service.renderers.ESLintCompactRenderer;
import org.hl7.fhir.validation.service.renderers.NativeRenderer;
import org.hl7.fhir.validation.service.renderers.ValidationOutputRenderer;
import org.hl7.fhir.validation.service.utils.Common;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.hl7.fhir.validation.service.utils.Slf4JOutputStream;
import org.hl7.fhir.validation.service.utils.VersionSourceInformation;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.instance.advisor.JsonDrivenPolicyAdvisor;
import org.hl7.fhir.validation.instance.advisor.TextDrivenPolicyAdvisor;

@Slf4j
public class ValidationService {

  private final SessionCache sessionCache;
  private String runDate;

  private final Map<String, ValidationEngine> baseEngines = new ConcurrentHashMap<>();



  @Deprecated(since="2025-11-07")
  public void putBaseEngine(String key, ValidationContext validationContext) throws IOException, URISyntaxException {
      ValidationEngineParameters  validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
      InstanceValidatorParameters instanceValidatorParameters = ValidationContextUtilities.getInstanceValidatorParameters(validationContext);
      putBaseEngine(key, validationEngineParameters, instanceValidatorParameters);
  }
  public void putBaseEngine(String key, ValidationEngineParameters validationEngineParameters, InstanceValidatorParameters defaultInstanceValidatorParameters) throws IOException, URISyntaxException {


    if (validationEngineParameters.getSv() == null) {
      throw new IllegalArgumentException("Cannot create a base engine without an explicit version");
    }
    String definitions = VersionUtilities.packageForVersion(validationEngineParameters.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationEngineParameters.getSv());

    ValidationEngine baseEngine = buildValidationEngine(validationEngineParameters, defaultInstanceValidatorParameters, definitions, new TimeTracker());
    baseEngines.put(key, baseEngine);
  }

  public ValidationEngine getBaseEngine(String key) {
    return baseEngines.get(key);
  }

  public Set<String> getBaseEngineKeys() { return baseEngines.keySet(); }

  public boolean hasBaseEngineForKey(String key) { return baseEngines.containsKey(key); }

  public ValidationService() {
    sessionCache = new PassiveExpiringSessionCache();
    runDate = new SimpleDateFormat("hh:mm:ss", new Locale("en", "US")).format(new Date());
  }



  public ValidationService(SessionCache cache) {
    this.sessionCache = cache;
  }

  /**
   * Primarily for use by validator-wrapper and other web-based validation methods.
   *
   * @param request
   * @return
   * @throws Exception
   */
  public ValidationResponse validateSources(ValidationRequest request) throws Exception {

    TimeTracker timeTracker = new TimeTracker();

    final ValidationEngineParameters validationEngineParameters;
    final InstanceValidatorParameters instanceValidatorParameters;
    final List<String> sources;

    if (request.getValidationContext() != null) {
      validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(request.getValidationContext());
      instanceValidatorParameters = ValidationContextUtilities.getInstanceValidatorParameters(request.getValidationContext());
      sources = request.getValidationContext().getSources();
      // The getMode() method is deprecated, but may still be in use by web services.
      if (request.getValidationContext().getMode() == EngineMode.INSTALL
        || request.getValidationContext().getMode() == EngineMode.VALIDATION) {
        validationEngineParameters.setInferFhirVersion(Boolean.TRUE);
      }

    } else {
      validationEngineParameters = request.getValidationEngineParameters();
      instanceValidatorParameters = request.getInstanceValidatorParameters() == null? new InstanceValidatorParameters() : request.getInstanceValidatorParameters();
      sources = request.getSources();
    }
    String sessionId = initializeValidator(validationEngineParameters, instanceValidatorParameters, null,  timeTracker, sources, request.sessionId);
    ValidationEngine validationEngine = sessionCache.fetchSessionValidatorEngine(sessionId);

    /* Cached validation engines already have expensive setup like loading definitions complete. But it wouldn't make
       sense to rebuild a whole engine to change the language, so we manually change it here.
     */
    validationEngine.setLanguage(validationEngineParameters.getLang());
    validationEngine.setLocale(validationEngineParameters.getLocale());
    if (instanceValidatorParameters.getProfiles().isEmpty()) {
      log.info("  .. validate " + request.listSourceFiles());
    } else {
      log.info("  .. validate " + request.listSourceFiles() + " against " + instanceValidatorParameters.getProfiles().toString());
    }

    ValidationResponse response = new ValidationResponse().setSessionId(sessionId).setValidationTimes(new HashMap<>());

    for (FileInfo fileToValidate : request.getFilesToValidate()) {
      if (fileToValidate.getFileType() == null) {
        Manager.FhirFormat format = ResourceChecker.checkIsResource(validationEngine.getContext(),
          fileToValidate.getFileContent().getBytes(),
          fileToValidate.getFileName(),
          false);
        if (format != null) {
          fileToValidate.setFileType(format.getExtension());
        }
      }

      List<ValidationMessage> messages = new ArrayList<>();

      if (fileToValidate.getFileType() == null) {
          ValidationOutcome outcome = getValidationOutcomeForUnknownFileFormat(
            new FileInfo(fileToValidate.getFileName(), fileToValidate.getFileContent(), null));
          response.addOutcome(outcome);
      } else {
        ValidatedFragments validatedFragments = validationEngine.validateAsFragments(fileToValidate.getFileContent().getBytes(), Manager.FhirFormat.getFhirFormat(fileToValidate.getFileType()),
          instanceValidatorParameters.getProfiles(), messages);

        List<ValidationOutcome> validationOutcomes = getValidationOutcomesFromValidatedFragments(fileToValidate, validatedFragments);
        for (ValidationOutcome validationOutcome : validationOutcomes) {
          response.addOutcome(validationOutcome);
        }

        if (validationEngineParameters.isShowTimes()) {
          response.getValidationTimes().put(fileToValidate.getFileName(), validatedFragments.getValidationTime());
        }
        
      }
    }

    log.info("  Max Memory: "+Runtime.getRuntime().maxMemory());
    return response;
  }

  private List<ValidationOutcome> getValidationOutcomesFromValidatedFragments(FileInfo fileToValidate, ValidatedFragments validatedFragments) {
    List<ValidationOutcome> outcomes = new LinkedList<>();
    if (validatedFragments.getValidatedFragments().size() == 1 && !validatedFragments.getValidatedFragments().get(0).isDerivedContent()) {
      ValidatedFragment validatedFragment = validatedFragments.getValidatedFragments().get(0);
      ValidationOutcome outcome = new ValidationOutcome();
      FileInfo fileInfo = new FileInfo(
        fileToValidate.getFileName(),
        new String(validatedFragment.getContent()),
        validatedFragment.getExtension());
      outcome.setMessages(validatedFragment.getErrors());
      outcome.setFileInfo(fileInfo);
      outcomes.add(outcome);
    } else {
      for (ValidatedFragment validatedFragment : validatedFragments.getValidatedFragments()) {
        ValidationOutcome outcome = new ValidationOutcome();
        FileInfo fileInfo = new FileInfo(
          validatedFragment.getFilename(),
          new String(validatedFragment.getContent()),
          validatedFragment.getExtension());
        outcome.setMessages(validatedFragment.getErrors());
        outcome.setFileInfo(fileInfo);
        outcomes.add(outcome);
      }
    }
    return outcomes;
  }

  private ValidationOutcome getValidationOutcomeForUnknownFileFormat(FileInfo fileInfo) {
    ValidationOutcome outcome = new ValidationOutcome();

    List<ValidationMessage> errorList = new ArrayList<>() {{
      add(new ValidationMessage().setType(ValidationMessage.IssueType.EXCEPTION).setLevel(ValidationMessage.IssueSeverity.FATAL).setMessage("Unable to infer format from file. Please check that your file is in a valid FHIR format."));

    } };
    outcome.setMessages(errorList);
    outcome.setFileInfo(fileInfo);
    return outcome;
  }

  @Deprecated(since="2025-11-07")
  public VersionSourceInformation scanForVersions(ValidationContext validationContext) throws IOException {
    List<String> igs = validationContext.getIgs();
    List<String> sources = validationContext.getSources();
    boolean isRecursive  = validationContext.isRecursive();
    return scanForVersions(igs, sources, isRecursive);
  }

  public VersionSourceInformation scanForVersions(List<String> igs, List<String> sources, boolean isRecursive) throws IOException {
   VersionSourceInformation versions = new VersionSourceInformation();
    IgLoader igLoader = new IgLoader(
      new FilesystemPackageCacheManager.Builder().build(),
      new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing(),
      null);

    for (String src : igs) {
      igLoader.scanForIgVersion(src, isRecursive, versions);
    }
    igLoader.scanForVersions(sources, versions);
    return versions;
  }

  @Deprecated(since="2025-11-05")
  public void validateSources(ValidationContext validationContext, ValidationEngine validator, ValidatorWatchMode watch, int watchScanDelay, int watchSettleTime) throws Exception {
    WatchParameters watchParameters = ValidationContextUtilities.getWatchParameters(validationContext);
    InstanceValidatorParameters instanceValidatorParameters = ValidationContextUtilities.getInstanceValidatorParameters(validationContext);
    List<String> sources = validationContext.getSources();
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    validateSources(validator, new ValidateSourceParameters(instanceValidatorParameters, sources, outputParameters.getOutput(), watchParameters));
  }

  /**
   * Uses the passed validationEngine to validate a set of sources.
   *
   * @param validationEngine the engine to use for
   * @param validateSourceParameters the parameters used for validation
   * @throws Exception if the validation setup or actual validation fails..
   */
  public void validateSources(ValidationEngine validationEngine, ValidateSourceParameters validateSourceParameters) throws Exception {
    InstanceValidatorParameters instanceValidatorParameters =
      validateSourceParameters.instanceValidatorParameters() == null
        ? validationEngine.getDefaultInstanceValidatorParameters()
        : validateSourceParameters.instanceValidatorParameters();

    WatchParameters watchParameters = validateSourceParameters.watchParameters() == null
        ? new WatchParameters()
      : validateSourceParameters.watchParameters();

    if (!instanceValidatorParameters.getProfiles().isEmpty()) {
      log.info("  Profiles: " + instanceValidatorParameters.getProfiles());
    }
    IgLoader igLoader = new IgLoader(validationEngine.getPcm(), validationEngine.getContext(), validationEngine.getVersion());

    List<ValidationRecord> records = new ArrayList<>();
    List<SourceFile> refs = new ArrayList<>();

    int ec = 0;
    boolean first = true;

    do {
      long start = System.currentTimeMillis();
      Resource resource = validationEngine.validate(validateSourceParameters.sources(), instanceValidatorParameters.getProfiles(), refs, records, igLoader, watchParameters.getWatchMode() == ValidatorWatchMode.ALL, watchParameters.getWatchSettleTime(), first);
      first = false;
      boolean statusNeeded = false;
      if (resource != null) {
        statusNeeded = true;
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        log.info("Done. " + validationEngine.getContext().clock().report() + ". Memory = " + Utilities.describeSize(mbean.getHeapMemoryUsage().getUsed() + mbean.getNonHeapMemoryUsage().getUsed()));
        log.info("");

        PrintStream dst = null;
        ValidationOutputRenderer renderer = makeValidationOutputRenderer(validateSourceParameters.output(), instanceValidatorParameters.getOutputStyle());
        renderer.setCrumbTrails(instanceValidatorParameters.isCrumbTrails());
        renderer.setShowMessageIds(instanceValidatorParameters.isShowMessageIds());
        renderer.setRunDate(runDate);
        if (renderer.isSingleFile()) {
          if (validateSourceParameters.output() == null) {
            dst = new PrintStream(new Slf4JOutputStream());
          } else {
            dst = new PrintStream(ManagedFileAccess.outStream(Utilities.path(validateSourceParameters.output())));
          }
          renderer.setOutput(dst);
        } else {
          File dir = ManagedFileAccess.file(validateSourceParameters.output());
          if (!dir.isDirectory()) {
            throw new Error("The output location " + dir.getAbsolutePath() + " must be an existing directory for the output style " + renderer.getStyleCode());
          }
          renderer.setFolder(dir);
        }

        if (resource instanceof Bundle) {
          if (renderer.handlesBundleDirectly()) {
            renderer.render((Bundle) resource);
          } else {
            renderer.start(((Bundle) resource).getEntry().size() > 1);
            for (Bundle.BundleEntryComponent e : ((Bundle) resource).getEntry()) {
              OperationOutcome op = (OperationOutcome) e.getResource();
              ec = ec + countErrors(op);
              renderer.render(op);
            }
            renderer.finish();
          }
        } else if (resource == null) {
          ec = ec + 1;
          log.info("No output from validation - nothing to validate");
        } else {
          renderer.start(false);
          OperationOutcome op = (OperationOutcome) resource;
          ec = countErrors(op);
          renderer.render((OperationOutcome) resource);
          renderer.finish();
        }

        if (validateSourceParameters.output() != null && dst != null) {
          dst.close();
        }

        if (instanceValidatorParameters.getHtmlOutput() != null) {
          String html = new HTMLOutputGenerator(records).generate(System.currentTimeMillis() - start);
          FileUtilities.stringToFile(html, instanceValidatorParameters.getHtmlOutput());
          log.info("HTML Summary in " + instanceValidatorParameters.getHtmlOutput());
        }

        if (instanceValidatorParameters.isShowTerminologyRouting()) {
          log.info("");
          log.info("Terminology Routing Dump ---------------------------------------");
          if (validationEngine.getContext().getTxClientManager().getInternalLog().isEmpty()) {
            log.info("(nothing happened)");
          } else {
            for (InternalLogEvent logEvent : validationEngine.getContext().getTxClientManager().getInternalLog()) {
              log.info(logEvent.getMessage() + " -> " + logEvent.getServer() + " (for VS " + logEvent.getVs() + " with systems '" + logEvent.getSystems() + "', choices = '" + logEvent.getChoices() + "')");
            }
          }
          validationEngine.getContext().getTxClientManager().getInternalLog().clear();
        }
      }
      if (watchParameters.getWatchMode() != ValidatorWatchMode.NONE) {
        if (statusNeeded) {
          log.info("Watching for changes (" + Integer.toString(watchParameters.getWatchScanDelay()) + "ms cycle)");
        }
        Thread.sleep(watchParameters.getWatchScanDelay());
      }
    } while (watchParameters.getWatchMode() != ValidatorWatchMode.NONE);
    
    if (ec > 0) {
      SystemExitManager.setError(1);
    }
  }

  private int countErrors(OperationOutcome oo) {
    int error = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
    }
    return error;
  }

  private ValidationOutputRenderer makeValidationOutputRenderer(String output, String style) {

    // adding to this list?
    // Must document the option at https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-ManagingOutput
    // if you're going to make a PR, document the link where the outputstyle is documented, along with a sentence that describes it, in the PR notes
    if (Utilities.noString(style)) {
      if (output == null) {
        return new DefaultRenderer();
      } else if (output.endsWith(".json")) {
        return new NativeRenderer(FhirFormat.JSON);
      } else {
        return new NativeRenderer(FhirFormat.XML);
      }
    } else if (Utilities.existsInList(style, "eslint-compact")) {
      return new ESLintCompactRenderer();
    } else if (Utilities.existsInList(style, "compact-split")) {
      return new CompactRenderer(true);
    } else if (Utilities.existsInList(style, "compact")) {
      return new CompactRenderer(false);
    } else if (Utilities.existsInList(style, "csv")) {
      return new CSVRenderer();
    } else if (Utilities.existsInList(style, "xml")) {
      return new NativeRenderer(FhirFormat.XML);
    } else if (Utilities.existsInList(style, "json")) {
      return new NativeRenderer(FhirFormat.JSON);
    } else {
      log.info("Unknown output style '"+style+"'");
      return new DefaultRenderer();
    }
  }

  @Deprecated(since="2025-11-05")
  public void convertSources(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    OutputParameters outputParameters =  ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    convertSources(validationEngine, sources, outputParameters.getOutput(), outputParameters.getOutputSuffix());
  }

    public void convertSources(ValidationEngine validationEngine, List<String> sources, String output, String outputSuffix) throws Exception {
      if (!((output == null) ^ (outputSuffix == null))) {
        throw new Exception("Convert requires one of {-output, -outputSuffix} parameter to be set");
      }

      if ((sources.size() == 1) && (output != null)) {
        log.info(" ...convert");
        validationEngine.convert(sources.get(0), output);
      } else {
        if (outputSuffix == null) {
          throw new Exception("Converting multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < sources.size(); i++) {
            String outputPath = sources.get(i) + "." + outputSuffix;
            validationEngine.convert(sources.get(i), outputPath);
            log.info(" ...convert [" + i +  "] (" + sources.get(i) + " to " + outputPath + ")");
        }
      }
  }

  @Deprecated(since="2025-11-05")
  public void evaluateFhirpath(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    FHIRPathParameters fhirPathParameters = ValidationContextUtilities.getFHIRPathParameters(validationContext);
    List<String> sources = validationContext.getSources();
    evaluateFhirpath(validationEngine, fhirPathParameters.getFhirpath(), sources);
  }

  public void evaluateFhirpath(ValidationEngine validationEngine, String fhirPath, List<String> sources) throws Exception {
    log.info(" ...evaluating " + fhirPath);
    log.info(validationEngine.evaluateFhirPath(sources.get(0), fhirPath));
  }

  @Deprecated(since="2025-11-05")
  public void generateSnapshot(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    generateSnapshot(validationEngine, new GenerateSnapshotParameters(validationEngineParameters.getSv(), sources, outputParameters.getOutput(), outputParameters.getOutputSuffix()));
  }

    public void generateSnapshot(ValidationEngine validationEngine, GenerateSnapshotParameters generateSnapshotParameters) throws Exception {
      if (!((generateSnapshotParameters.output() == null) ^ (generateSnapshotParameters.outputSuffix() == null))) {
        throw new Exception("Snapshot generation requires one of {-output, -outputSuffix} parameter to be set");
      }

      if ((generateSnapshotParameters.sources().size() == 1) && (generateSnapshotParameters.output() != null)) {
        StructureDefinition r = validationEngine.snapshot(generateSnapshotParameters.sources().get(0), generateSnapshotParameters.version());
        log.info(" ...generated snapshot successfully");
        validationEngine.handleOutput(r, generateSnapshotParameters.output(), generateSnapshotParameters.version());
      } else {
        if (generateSnapshotParameters.outputSuffix() == null) {
          throw new Exception("Snapshot generation for multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < generateSnapshotParameters.sources().size(); i++) {
          StructureDefinition r = validationEngine.snapshot(generateSnapshotParameters.sources().get(i), generateSnapshotParameters.version());
          String outputDest = generateSnapshotParameters.sources().get(i) + "." + generateSnapshotParameters.outputSuffix();
          validationEngine.handleOutput(r, outputDest, generateSnapshotParameters.version());
          log.info(" ...generated snapshot [" + i +  "] successfully (" + generateSnapshotParameters.sources().get(i) + " to " + outputDest + ")");
        }
      }

  }

  @Deprecated(since="2025-11-05")
  public void generateNarrative(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    generateNarrative(validationEngine, validationEngineParameters.getSv(), sources, outputParameters.getOutput());
  }


  public void generateNarrative(ValidationEngine validationEngine, String version, List<String> sources,
                                String output) throws Exception {
    Resource r = validationEngine.generate(sources.get(0), version);
    log.info(" ...generated narrative successfully");
    if (output != null) {
      validationEngine.handleOutput(r, output, version);
    }
  }

  @Deprecated(since="2025-11-05")
  public void transform(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    MapParameters mapParameters = ValidationContextUtilities.getMapParameters(validationContext);
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    transform(validationEngine, new TransformParameters(mapParameters.getMap(), validationEngineParameters.getMapLog(), validationEngineParameters.getTxServer(), sources, outputParameters.getOutput()));
  }

  public void transform(ValidationEngine validationEngine, TransformParameters transformParameters) throws Exception {
    if (transformParameters.sources().size() > 1)
      throw new Exception("Can only have one source when doing a transform (found " + transformParameters.sources() + ")");
    if (transformParameters.txServer() == null)
      throw new Exception("Must provide a terminology server when doing a transform");
    if (transformParameters.map() == null)
      throw new Exception("Must provide a map when doing a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validationEngine.getContext());
      List<StructureDefinition> structures =  cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          cu.generateSnapshot(sd);
        }
      }
      validationEngine.setMapLog(transformParameters.mapLog());
      org.hl7.fhir.r5.elementmodel.Element r = validationEngine.transform(transformParameters.sources().get(0), transformParameters.map());
      log.info(" ...success");
      if (transformParameters.output() != null) {
        FileOutputStream s = ManagedFileAccess.outStream(transformParameters.output());
        if (transformParameters.output() != null && transformParameters.output().endsWith(".json"))
          new org.hl7.fhir.r5.elementmodel.JsonParser(validationEngine.getContext()).compose(r, s, IParser.OutputStyle.PRETTY, null);
        else
          new org.hl7.fhir.r5.elementmodel.XmlParser(validationEngine.getContext()).compose(r, s, IParser.OutputStyle.PRETTY, null);
        s.close();
      }
    } catch (Exception e) {
      log.info(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Deprecated(since="2025-11-06")
  public void compile(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    MapParameters mapParameters = ValidationContextUtilities.getMapParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    compile(validationEngine, mapParameters.getMap(), validationEngineParameters.getMapLog(), sources, outputParameters.getOutput());
  }

    public void compile(ValidationEngine validationEngine, String map, String mapLog, List<String> sources, String output) throws Exception {
    if (sources.size() > 0)
      throw new Exception("Cannot specify sources when compling transform (found " + sources + ")");
    if (map == null)
      throw new Exception("Must provide a map when compiling a transform");
    if (output == null)
      throw new Exception("Must provide an output name when compiling a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validationEngine.getContext());
      List<StructureDefinition> structures = cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          cu.generateSnapshot(sd);
        }
      }
      validationEngine.setMapLog(mapLog);
      StructureMap structureMap = validationEngine.compile(map);
      if (structureMap == null)
        throw new Exception("Unable to locate map " + map);
      validationEngine.handleOutput(structureMap, output, validationEngine.getVersion());
      log.info(" ...success");
    } catch (Exception e) {
      log.info(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Deprecated(since="2025-11-05")
  public void transformVersion(ValidationContext validationContext, ValidationEngine validationEngine) throws Exception {
      ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
      org.hl7.fhir.validation.service.model.TransformVersionParameters transformVersionParameters = ValidationContextUtilities.getTransformVersionParameters(validationContext);
      OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
      List<String> sources = validationContext.getSources();
      transformVersion(validationEngine, new TransformVersionParameters(transformVersionParameters.getTargetVer(), validationEngineParameters.getMapLog(), transformVersionParameters.getCanDoNative(), sources, outputParameters.getOutput()));
  }

    public void transformVersion(ValidationEngine validationEngine, TransformVersionParameters transformVersionParameters) throws Exception {
    if (transformVersionParameters.sources().size() > 1) {
      throw new Exception("Can only have one source when converting versions (found " + transformVersionParameters.sources() + ")");
    }
    if (transformVersionParameters.targetVer() == null) {
      throw new Exception("Must provide a map when converting versions");
    }
    if (transformVersionParameters.output() == null) {
      throw new Exception("Must nominate an output when converting versions");
    }
    try {
      if (transformVersionParameters.mapLog() != null) {
        validationEngine.setMapLog(transformVersionParameters.mapLog());
      }
      byte[] r = validationEngine.transformVersion(transformVersionParameters.sources().get(0), transformVersionParameters.targetVer(), transformVersionParameters.output().endsWith(".json") ? Manager.FhirFormat.JSON : Manager.FhirFormat.XML, transformVersionParameters.canDoNative());
      log.info(" ...success");
      FileUtilities.bytesToFile(r, transformVersionParameters.output());
    } catch (Exception e) {
      log.info(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Used by ValidationEngineTasks.
   *
   * @param validationContext
   * @param definitions
   * @param tt
   * @return
   * @throws Exception
   */

  @Deprecated(since="2025-11-07")
  public ValidationEngine initializeValidator(ValidationContext validationContext, String definitions, TimeTracker tt) throws Exception {
    return sessionCache.fetchSessionValidatorEngine(initializeValidator(validationContext, definitions, tt, null));
  }

  @Deprecated(since="2025-11-07")
  public String initializeValidator(ValidationContext validationContext, String definitions, TimeTracker tt, String sessionId) throws Exception {
      ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
      InstanceValidatorParameters defaultInstanceValidatorParams = ValidationContextUtilities.getInstanceValidatorParameters(validationContext);
      return initializeValidator(validationEngineParameters, defaultInstanceValidatorParams, definitions, tt, validationContext.getSources(), sessionId);
  }

  public ValidationEngine initializeValidator(ValidationEngineParameters validationEngineParameters, InstanceValidatorParameters defaultInstanceValidatorParameters, String definitions, TimeTracker tt, List<String> sources) throws Exception{
    return sessionCache.fetchSessionValidatorEngine(initializeValidator(validationEngineParameters, defaultInstanceValidatorParameters, definitions, tt, sources, null));
  }

  // Used by:
  // - the method above (in ValidationEngineTasks)
  // - validateSources(ValidationRequest)
  public String initializeValidator(ValidationEngineParameters validationEngineParameters, InstanceValidatorParameters defaultInstanceValidatorParameters, String definitions, TimeTracker tt, List<String> sources, String sessionId) throws Exception {
    tt.milestone();

    if (!sessionCache.sessionExists(sessionId)) {
      if (sessionId != null) {
        log.info("No such cached session exists for session id " + sessionId + ", re-instantiating validator.");
      }
      sessionCache.cleanUp();

      if (validationEngineParameters.getSv() == null) {
        String sv = determineVersion(validationEngineParameters.getIgs(), sources, validationEngineParameters.isRecursive(), validationEngineParameters.isInferFhirVersion());
        validationEngineParameters.setSv(sv);
      }
      final String engineDefinitions = definitions != null ? definitions : VersionUtilities.packageForVersion(validationEngineParameters.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationEngineParameters.getSv());

      ValidationEngine validationEngine = getValidationEngineFromParameters(validationEngineParameters, defaultInstanceValidatorParameters, engineDefinitions, tt);
      sessionId = sessionCache.cacheSession(validationEngine);
      log.info("Cached new session. Cache size = " + sessionCache.getSessionIds().size());

    } else {
      log.info("Cached session exists for session id " + sessionId + ", returning stored validator session id. Cache size = " + sessionCache.getSessionIds().size());
    }
    return sessionId;
  }

  private ValidationEngine getValidationEngineFromParameters(ValidationEngineParameters validationEngineParameters, InstanceValidatorParameters defaultInstanceValidatorParameters, String definitions, TimeTracker tt) throws Exception {
    ValidationEngine validationEngine;
    if (validationEngineParameters.getBaseEngine() != null && hasBaseEngineForKey(validationEngineParameters.getBaseEngine())) {
      validationEngine = new ValidationEngine(getBaseEngine(validationEngineParameters.getBaseEngine()));
    } else {
      if (definitions == null) {
        throw new IllegalArgumentException("Cannot create a validator engine (definitions == null)");
      }
      validationEngine = buildValidationEngine(validationEngineParameters, defaultInstanceValidatorParameters, definitions, tt);
    }
    return validationEngine;
  }

  protected ValidationEngine.ValidationEngineBuilder getValidationEngineBuilder() {
    return new ValidationEngine.ValidationEngineBuilder();
  }

  //Called
  @Nonnull
  protected ValidationEngine buildValidationEngine(ValidationEngineParameters validationEngineParameters, InstanceValidatorParameters defaultInstanceValidatorParameters, String definitions, TimeTracker timeTracker) throws IOException, URISyntaxException {
    log.info("  Loading FHIR v" + validationEngineParameters.getSv() + " from " + definitions);
    final InstanceValidatorParameters instanceValidatorParameters = defaultInstanceValidatorParameters == null ? new InstanceValidatorParameters(): defaultInstanceValidatorParameters;
    ValidationEngine validationEngine = getValidationEngineBuilder()
      .withDefaultInstanceValidatorParameters(new InstanceValidatorParameters(instanceValidatorParameters))
      .withVersion(validationEngineParameters.getSv())
      .withTimeTracker(timeTracker)
      .withUserAgent(Common.getValidatorUserAgent())
      .withThoVersion(Constants.THO_WORKING_VERSION)
      .withExtensionsVersion(Constants.EXTENSIONS_WORKING_VERSION)
      .fromSource(definitions);
    FhirPublication ver = FhirPublication.fromCode(validationEngineParameters.getSv());
    log.info("  Loaded FHIR - " + validationEngine.getContext().countAllCaches() + " resources (" + timeTracker.milestone() + ")");
    final String lineStart = "  Terminology server " + validationEngineParameters.getTxServer();
    final String txver = validationEngine.setTerminologyServer(validationEngineParameters.getTxServer(), validationEngineParameters.getTxLog(), ver, !validationEngineParameters.getNoEcosystem());
    log.info(lineStart + " - Version " + txver + " (" + timeTracker.milestone() + ")");
    validationEngine.setDebug(validationEngineParameters.isDoDebug());
    validationEngine.getContext().setLogger(new Slf4JLoggingService(log));
    loadIgsAndExtensions(validationEngine, validationEngineParameters.getIgs(), validationEngineParameters.isRecursive());
    if (validationEngineParameters.getTxCache() != null) {
      TerminologyCache cache = new TerminologyCache(new Object(), validationEngineParameters.getTxCache());
      validationEngine.getContext().initTxCache(cache);
    }
    if (validationEngine.getContext().getTxCache() == null || validationEngine.getContext().getTxCache().getFolder() == null) {
      log.info("  No Terminology Cache");
    } else {
      log.info("  Terminology Cache at "+validationEngine.getContext().getTxCache().getFolder());
      if (validationEngineParameters.isClearTxCache()) {
        log.info("  Terminology Cache Entries Cleaned out");
        validationEngine.getContext().getTxCache().clear();
      }
    }
    validationEngine.setDoNative(validationEngineParameters.isDoNative());
    log.info("  Get set... ");

    validationEngine.getCertSources().addAll(validationEngineParameters.getCertSources());
    validationEngine.getMatchetypes().addAll(validationEngineParameters.getMatchetypes());
    validationEngine.setShowTimes(validationEngineParameters.isShowTimes());
    validationEngine.setLanguage(validationEngineParameters.getLang());
    validationEngine.setLocale(validationEngineParameters.getLocale());
    validationEngine.setSnomedExtension(validationEngineParameters.getSnomedCTCode());
    validationEngine.setNoExtensibleBindingMessages(validationEngineParameters.isNoExtensibleBindingMessages());
    validationEngine.setDisplayWarnings(validationEngineParameters.isDisplayWarnings());
    validationEngine.setAiService(validationEngineParameters.getAIService());

    ReferenceValidationPolicy refpol = ReferenceValidationPolicy.CHECK_VALID;
    if (!validationEngineParameters.isDisableDefaultResourceFetcher()) {
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(validationEngine.getPcm(), validationEngine.getContext(), validationEngine);
      validationEngine.setFetcher(fetcher);
      validationEngine.getContext().setLocator(fetcher);
      validationEngine.setPolicyAdvisor(fetcher);
      if (validationEngineParameters.isCheckReferences()) {
        fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      } else {
        fetcher.setReferencePolicy(ReferenceValidationPolicy.IGNORE);        
      }
      fetcher.getCheckReferencesTo().addAll(validationEngineParameters.getCheckReferencesTo());
      fetcher.setResolutionContext(validationEngineParameters.getResolutionContext());
    } else {
      DisabledValidationPolicyAdvisor fetcher = new DisabledValidationPolicyAdvisor();
      validationEngine.setPolicyAdvisor(fetcher);
      refpol = ReferenceValidationPolicy.CHECK_TYPE_IF_EXISTS;
    }
    if (validationEngineParameters.getAdvisorFile() != null) {
      if (validationEngineParameters.getAdvisorFile().endsWith(".json")) {
        validationEngine.getPolicyAdvisor().setPolicyAdvisor(new JsonDrivenPolicyAdvisor(validationEngine.getPolicyAdvisor().getPolicyAdvisor(), ManagedFileAccess.file(validationEngineParameters.getAdvisorFile())));
      } else {
        validationEngine.getPolicyAdvisor().setPolicyAdvisor(new TextDrivenPolicyAdvisor(validationEngine.getPolicyAdvisor().getPolicyAdvisor(), ManagedFileAccess.file(validationEngineParameters.getAdvisorFile())));
      }
    } else {
      validationEngine.getPolicyAdvisor().setPolicyAdvisor(new BasePolicyAdvisorForFullValidation(validationEngine.getPolicyAdvisor() == null ? refpol : validationEngine.getPolicyAdvisor().getReferencePolicy(),
        validationEngine.getCheckReferencesTo()));
    }
    TerminologyCache.setNoCaching(validationEngineParameters.isNoInternalCaching());


    validationEngine.prepare(); // generate any missing snapshots
    log.info("  ...go! (" + timeTracker.milestone() + ")");
    return validationEngine;
  }

  protected void loadIgsAndExtensions(ValidationEngine validationEngine, List<String> igs, boolean isRecursive) throws IOException, URISyntaxException {
    IgLoader igLoader = new IgLoader(validationEngine.getPcm(), validationEngine.getContext(), validationEngine.getVersion(), validationEngine.isDebug());
    igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.terminology", false);
    if (!VersionUtilities.isR5Ver(validationEngine.getContext().getVersion())) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.fhir.uv.extensions", false);
    }

    for (String src : igs) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), src, isRecursive);
    }
    log.info("  Package Summary: "+ validationEngine.getContext().loadedPackageSummary());
  }

  @Deprecated(since="2025-11-07")
  public String determineVersion(ValidationContext validationContext) throws IOException {
    return determineVersion(validationContext.getIgs(), validationContext.getSources(), validationContext.isRecursive(), validationContext.isInferFhirVersion());
  }

  public String determineVersion(List<String> igs, List<String> sources, boolean isRecursive, boolean isInferFhirVersion) throws IOException {
    if (!isInferFhirVersion) {
      return "5.0";
    }
    log.info("Scanning for versions (no -version parameter):");
    VersionSourceInformation versions = scanForVersions(igs, sources, isRecursive);
    for (String s : versions.getReport()) {
      if (!s.equals("(nothing found)")) {
        log.info("  " + s);
      }
    }
    if (versions.isEmpty()) {
      log.info("  No Version Info found: Using Default version R5");
      return "5.0.0";
    }
    if (versions.size() == 1) {
      log.info("-> use version " + versions.version());
      return versions.version();
    }
    throw new IllegalArgumentException("-> Multiple versions found. Specify a particular version using the -version parameter");
  }

  @Deprecated(since="2025-11-05")
  public void generateSpreadsheet(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    generateSpreadsheet(validator, validationEngineParameters.getSv(), sources, outputParameters.getOutput());
  }

    public void generateSpreadsheet(ValidationEngine validationEngine, String version, List<String> sources, String output) throws Exception {
    CanonicalResource cr = validationEngine.loadCanonicalResource(sources.get(0), version);
    boolean ok = true;
    if (cr instanceof StructureDefinition) {
      new StructureDefinitionSpreadsheetGenerator(validationEngine.getContext(), false, false).renderStructureDefinition((StructureDefinition) cr, false).finish(ManagedFileAccess.outStream(output));
    } else if (cr instanceof CodeSystem) {
      new CodeSystemSpreadsheetGenerator(validationEngine.getContext()).renderCodeSystem((CodeSystem) cr).finish(ManagedFileAccess.outStream(output));
    } else if (cr instanceof ValueSet) {
      new ValueSetSpreadsheetGenerator(validationEngine.getContext()).renderValueSet((ValueSet) cr).finish(ManagedFileAccess.outStream(output));
    } else if (cr instanceof ConceptMap) {
      new ConceptMapSpreadsheetGenerator(validationEngine.getContext()).renderConceptMap((ConceptMap) cr).finish(ManagedFileAccess.outStream(output));
    } else {
      ok = false;
      log.info(" ...Unable to generate spreadsheet for "+ sources.get(0)+": no way to generate a spreadsheet for a "+cr.fhirType());
    }

    if (ok) {
      log.info(" ...generated spreadsheet successfully");
    }
  }

  @Deprecated(since="2025-11-05")
  public void transformLang(ValidationContext validationContext, ValidationEngine validationEngine) throws IOException {
    org.hl7.fhir.validation.service.model.TransformLangParameters transformLangParameters = ValidationContextUtilities.getTransformLangParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    List<String> sources = validationContext.getSources();
    transformLang(validationEngine, new TransformLangParameters(transformLangParameters.getLangTransform(), transformLangParameters.getInputs(), transformLangParameters.getSrcLang(), transformLangParameters.getTgtLang(), sources, outputParameters.getOutput()));
  }

    public void transformLang(ValidationEngine validationEngine, TransformLangParameters transformLangParameters) throws IOException {
    switch (transformLangParameters.langTransform()) {
    case "extract":
      transformLangExtract(validationEngine, transformLangParameters.srcLang(), transformLangParameters.tgtLang(), transformLangParameters.sources(), transformLangParameters.output());
      break;
    case "inject":
      transformLangInject(validationEngine, transformLangParameters.inputs(), transformLangParameters.sources(), transformLangParameters.output());
      break;
    default:
      log.info(" ...Unknown lang transform mode "+ transformLangParameters.langTransform());
    }
  }

  
  private void transformLangExtract(ValidationEngine validator, String srcLang, String tgtLang, List<String> sources, String output) throws IOException {
    FileUtilities.createDirectory(output);
    PoGetTextProducer po = new PoGetTextProducer(output, ".", false);
    XLIFFProducer xliff = new XLIFFProducer(output, ".", false);
    JsonLangFileProducer jl = new JsonLangFileProducer(output, ".", false);
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(sources, refs, validator.getContext());
    for (SourceFile ref : refs) {
      log.info("  Extract Translations from " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());
      LanguageProducerSession ps = po.startSession(e.fhirType()+"-"+e.getIdBase(), srcLang);
      LanguageProducerLanguageSession psl = ps.forLang(tgtLang);
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish();
      ps = xliff.startSession(e.fhirType()+"-"+e.getIdBase(), srcLang);
      psl = ps.forLang(tgtLang);
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
      ps = jl.startSession(e.fhirType()+"-"+e.getIdBase(), srcLang);
      psl = ps.forLang(tgtLang);
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
    }
    log.info("Done - produced "+(po.fileCount()+xliff.fileCount()) + " files in "+ output);
  }

  
  private void transformLangInject(ValidationEngine validator, List<String> inputs, List<String> sources, String output) throws IOException {
    FileUtilities.createDirectory(output);
    
    List<TranslationUnit> translations = new ArrayList<>();
    for (String input : inputs) {
      loadTranslationSource(translations, input);
    }
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(sources, refs, validator.getContext());
    int t = 0;
    for (SourceFile ref : refs) {
      log.info("  Inject Translations into " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());      
      t = t + new LanguageUtils(validator.getContext()).importFromTranslations(e, translations);
      Manager.compose(validator.getContext(), e, ManagedFileAccess.outStream(Utilities.path(output, ManagedFileAccess.file(ref.getRef()).getName())), cnt.getCntType(),
          OutputStyle.PRETTY, null);
    }
    log.info("Done - imported "+t+" translations into "+refs.size()+ " in "+ output);
  }
  
  private void loadTranslationSource(List<TranslationUnit> translations, String input) throws IOException {
    File f = ManagedFileAccess.file(input);
    if (f.exists()) {
      if (f.isDirectory()) {
        for (File fd : f.listFiles()) {
          loadTranslationSource(translations, fd.getAbsolutePath());
        }
      } else {
        if (f.getName().endsWith(".po")) {
          try {
            translations.addAll(new PoGetTextProducer().loadSource(ManagedFileAccess.inStream(f)));
          } catch (Exception e) {
            log.info("Error reading PO File "+f.getAbsolutePath()+": "+e.getMessage());
          }
        } else if (f.getName().endsWith(".xliff")) {
          try {
            translations.addAll(new XLIFFProducer().loadSource(ManagedFileAccess.inStream(f)));
          } catch (Exception e) {
            log.info("Error reading XLIFF File "+f.getAbsolutePath()+": "+e.getMessage());
          }          
        } else {
          try {
            translations.addAll(new PoGetTextProducer().loadSource(ManagedFileAccess.inStream(f)));
          } catch (Exception e) {
            try {
              translations.addAll(new XLIFFProducer().loadSource(ManagedFileAccess.inStream(f)));
            } catch (Exception e2) {
              log.info("Error reading File "+f.getAbsolutePath()+" as XLIFF: "+e2.getMessage());
              log.info("Error reading File "+f.getAbsolutePath()+" as PO: "+e.getMessage());
            }   
          }
        }
      }
    } else {
      log.info("Input not found: "+input);
    }    
  }

  private int installedPackageCount;
  private int generatedSnapshotCount;

  /**
   * @deprecated
   */
    @Deprecated(since = "2025-09-19")
    public void install(ValidationContext validationContext, ValidationEngine validator) throws FHIRException, IOException {
      install(validationContext.getIgs(), validator);
    }

    public void install(List<String> igs, ValidationEngine validator) throws FHIRException, IOException {
    installedPackageCount = 0;
    generatedSnapshotCount = 0;
    log.info("Generating Snapshots");
    for (String ig : igs) {
      installIG(validator, ig);
    }
    log.info("Installed/Processed "+ installedPackageCount +" packages, generated "+ generatedSnapshotCount +" snapshots");
  }

  private void installIG(ValidationEngine validationEngine, String ig) throws FHIRException, IOException {
    validationEngine.loadPackage(ig, null);
    NpmPackage npm = validationEngine.getPcm().loadPackage(ig);
    if (!npm.isCore()) {
      for (String dependency : npm.dependencies()) {
        installIG(validationEngine, dependency);
      }
      log.info("Processing "+ig);
      installedPackageCount++;
      for (String resourceName : npm.listResources("StructureDefinition")) {
        String filename = npm.getFilePath(resourceName);
        Resource resource = validationEngine.loadResource(FileUtilities.fileToBytes(filename), filename);
        if (!(resource instanceof StructureDefinition))
          throw new FHIRException("Require a StructureDefinition for generating a snapshot");
        StructureDefinition structureDefinition = (StructureDefinition) resource;
        if (!structureDefinition.hasSnapshot()) {
          StructureDefinition baseDefinition = validationEngine.getContext().fetchResource(StructureDefinition.class, structureDefinition.getBaseDefinition());
          generatedSnapshotCount++;
          new ProfileUtilities(validationEngine.getContext(), new ArrayList<>(), null).setAutoFixSliceNames(true).generateSnapshot(baseDefinition, structureDefinition, structureDefinition.getUrl(), null, structureDefinition.getName());
          validationEngine.handleOutput(structureDefinition, filename, validationEngine.getVersion());
        }
      }
    }
  }

  @Deprecated(since="2024-11-06")
  public void codeGen(ValidationContext validationContext, ValidationEngine validationEngine) throws IOException {
    ValidationEngineParameters validationEngineParameters = ValidationContextUtilities.getValidationEngineParameters(validationContext);
    InstanceValidatorParameters instanceValidatorParameters = ValidationContextUtilities.getInstanceValidatorParameters(validationContext);
    PackageNameParameters packageNameParameters = ValidationContextUtilities.getPackageNameParameters(validationContext);
    org.hl7.fhir.validation.service.model.CodeGenParameters codeGenParameters = ValidationContextUtilities.getCodeGenParameters(validationContext);
    OutputParameters outputParameters = ValidationContextUtilities.getOutputParameters(validationContext);
    codeGen(validationEngine, new CodeGenParameters(validationEngineParameters.getSv(), instanceValidatorParameters.getProfiles(), codeGenParameters.getOptions(), packageNameParameters.getPackageName(), outputParameters.getOutput()));
    }

  public void codeGen(ValidationEngine validationEngine, CodeGenParameters codeGenParameters) throws IOException {
    boolean ok = true;
    if (codeGenParameters.profiles().isEmpty()) {
      log.info("Must specify at least one profile to generate code for with -profile or -profiles ");
      ok = false;
    }
    if (codeGenParameters.packageName() == null) {
      log.info("Must provide a Java package name (-package-name)");
      ok = false;
    }
    if (codeGenParameters.version() == null) {
      log.info("Must specify a version (-version)");
      ok = false;
    } else if (!VersionUtilities.isR4Ver(codeGenParameters.version()) && !VersionUtilities.isR5Ver(codeGenParameters.version())) {
      log.info("Only versions 4 and 5 are supported (-version)");
      ok = false;
    }
    if (codeGenParameters.output() == null) {
      log.info("Must provide an output directory (-output)");
      ok = false;
    }
    FileUtilities.createDirectory(codeGenParameters.output());
    if (ok) {
      PECodeGenerator gen = new PECodeGenerator(validationEngine.getContext());
      gen.setFolder(codeGenParameters.output());
      gen.setExtensionPolicy(ExtensionPolicy.Complexes);
      gen.setNarrative(codeGenParameters.options().contains("narrative"));
      gen.setMeta(codeGenParameters.options().contains("meta"));
      gen.setLanguage(Locale.getDefault().toLanguageTag());
      gen.setContained(codeGenParameters.options().contains("contained"));
      gen.setKeyElementsOnly(!codeGenParameters.options().contains("all-elements"));
      gen.setGenDate(new SimpleDateFormat().format(new Date()));
      gen.setPkgName(codeGenParameters.packageName());
      if (VersionUtilities.isR4Ver(codeGenParameters.version())) {
        gen.setVersion("r4");
      } else {
        gen.setVersion("r5");
      }

      for (String profile : codeGenParameters.profiles()) {
        if (profile.endsWith("*")) {
          for (StructureDefinition sd : validationEngine.getContext().fetchResourcesByType(StructureDefinition.class)) {
            if (sd.getUrl().startsWith(profile.replace("*", ""))) {
              gen.setCanonical(sd.getUrl());
              log.info("Generating PE code for "+sd.getUrl());
              String s = gen.execute();
              log.info("Generated PE code for "+sd.getUrl() + ": "+s);
            }
          }
        } else {
          gen.setCanonical(profile);
          log.info("Generating PE code for "+ profile);
          String s = gen.execute();
          log.info("Generated PE code for "+ profile + ": "+s);
        }
      }
      log.info("Done");
    }
  }

  @Deprecated(since="2025-11-05")
  public void instanceFactory(ValidationContext validationContext, ValidationEngine validationEngine) throws IOException {
      InstanceFactoryParameters instanceFactoryParameters = ValidationContextUtilities.getInstanceFactoryParameters(validationContext);
      instanceFactory(validationEngine, instanceFactoryParameters.getSource());
    }


    public void instanceFactory(ValidationEngine validationEngine, String source) throws IOException {
    boolean ok = true;
    if (source == null) {
      log.info("Must specify a source (-version)");
      ok = false;
    } else if (!ManagedFileAccess.file(source).exists()) {
      log.info("Factory source '"+ source+"' not found");
      ok = false;
    }

    if (ok) {
      log.info("Preparing to execute");
              
      FHIRPathEngine fpe = new FHIRPathEngine(validationEngine.getContext());
      TestDataHostServices hs = new TestDataHostServices(validationEngine.getContext(),
        new DateTimeType(new Date()),
        new DateType(new Date()),
        new StringType(VersionUtilities.getSpecUrl(validationEngine.getContext().getVersion())));
      hs.registerFunction(new GlobalObjectRandomFunction());
      hs.registerFunction(new BaseTableWrapper.TableColumnFunction());
      hs.registerFunction(new BaseTableWrapper.TableDateColumnFunction());
      hs.registerFunction(new TestDataFactory.CellLookupFunction());
      hs.registerFunction(new TestDataFactory.TableLookupFunction());
      fpe.setHostServices(hs);
      LiquidEngine liquid = new LiquidEngine(validationEngine.getContext(), hs);
      
      String path = FileUtilities.getDirectoryForFile(source);
      String logPath = Utilities.path(path, "log");
      FileUtilities.createDirectory(logPath);
                  
      JsonObject json = JsonParser.parseObjectFromFile(source);
      for (JsonObject fact : json.forceArray("factories").asJsonObjects()) {
        TestDataFactory tdf = new TestDataFactory(validationEngine.getContext(), fact, liquid, fpe, "http://hl7.org/fhir/test", path, logPath, new HashMap<>(), new Locale("us"));
        tdf.setTesting(true); // no randomness
        log.info("Execute Test Data Factory '"+tdf.getName()+"'. Log in "+Utilities.path(logPath, tdf.statedLog()));
        tdf.execute();
      }

      log.info("Done");
    }
  }

}
