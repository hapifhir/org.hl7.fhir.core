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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SystemOutLoggingService;
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
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator.ExtensionPolicy;
import org.hl7.fhir.r5.renderers.spreadsheets.CodeSystemSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ConceptMapSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.StructureDefinitionSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ValueSetSpreadsheetGenerator;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
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
import org.hl7.fhir.validation.service.utils.VersionSourceInformation;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.instance.advisor.JsonDrivenPolicyAdvisor;
import org.hl7.fhir.validation.instance.advisor.TextDrivenPolicyAdvisor;

public class ValidationService {

  private final SessionCache sessionCache;
  private String runDate;

  private final Map<String, ValidationEngine> baseEngines = new ConcurrentHashMap<>();

  public void putBaseEngine(String key, ValidationContext validationContext) throws IOException, URISyntaxException {
    if (validationContext.getSv() == null) {
      throw new IllegalArgumentException("Cannot create a base engine without an explicit version");
    }
    String definitions = VersionUtilities.packageForVersion(validationContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationContext.getSv());

    ValidationEngine baseEngine = buildValidationEngine(validationContext, definitions, new TimeTracker());
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

  public ValidationResponse validateSources(ValidationRequest request) throws Exception {

    TimeTracker timeTracker = new TimeTracker();
    String sessionId = initializeValidator(request.getValidationContext(), null, timeTracker, request.sessionId);
    ValidationEngine validationEngine = sessionCache.fetchSessionValidatorEngine(sessionId);

    /* Cached validation engines already have expensive setup like loading definitions complete. But it wouldn't make
       sense to rebuild a whole engine to change the language, so we manually change it here.
     */
    validationEngine.setLanguage(request.getValidationContext().getLang());
    validationEngine.setLocale(request.getValidationContext().getLocale());
    if (request.getValidationContext().getProfiles().size() > 0) {
      System.out.println("  .. validate " + request.listSourceFiles() + " against " + request.getValidationContext().getProfiles().toString());
    } else {
      System.out.println("  .. validate " + request.listSourceFiles());
    }

    ValidationResponse response = new ValidationResponse().setSessionId(sessionId).setValidationTimes(new HashMap<>());

    for (FileInfo fileToValidate : request.getFilesToValidate()) {
      if (fileToValidate.getFileType() == null) {
        Manager.FhirFormat format = ResourceChecker.checkIsResource(validationEngine.getContext(),
          false,
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
          request.getValidationContext().getProfiles(), messages);

        List<ValidationOutcome> validationOutcomes = getValidationOutcomesFromValidatedFragments(fileToValidate, validatedFragments);
        for (ValidationOutcome validationOutcome : validationOutcomes) {
          response.addOutcome(validationOutcome);
        }

        if (request.getValidationContext().isShowTimes()) {
          response.getValidationTimes().put(fileToValidate.getFileName(), validatedFragments.getValidationTime());
        }
        
      }
    }

    System.out.println("  Max Memory: "+Runtime.getRuntime().maxMemory());
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

  public VersionSourceInformation scanForVersions(ValidationContext validationContext) throws IOException {
    VersionSourceInformation versions = new VersionSourceInformation();
    IgLoader igLoader = new IgLoader(
      new FilesystemPackageCacheManager.Builder().build(),
      new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing(),
      null);
    for (String src : validationContext.getIgs()) {
      igLoader.scanForIgVersion(src, validationContext.isRecursive(), versions);
    }
    igLoader.scanForVersions(validationContext.getSources(), versions);
    return versions;
  }

  public void validateSources(ValidationContext validationContext, ValidationEngine validator, ValidatorWatchMode watch, int watchScanDelay, int watchSettleTime) throws Exception {
    if (validationContext.getProfiles().size() > 0) {
      System.out.println("  Profiles: " + validationContext.getProfiles());
    }
    IgLoader igLoader = new IgLoader(validator.getPcm(), validator.getContext(), validator.getVersion());
        
    List<ValidationRecord> records = new ArrayList<>();
    List<SourceFile> refs = new ArrayList<>();

    int ec = 0;
    boolean first = true;

    do {
      long start = System.currentTimeMillis();
      Resource r = validator.validate(validationContext.getSources(), validationContext.getProfiles(), refs, records, igLoader, watch == ValidatorWatchMode.ALL, watchSettleTime, first);
      first = false;
      boolean statusNeeded = false;
      if (r != null) {
        statusNeeded = true;
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        System.out.println("Done. " + validator.getContext().clock().report()+". Memory = "+Utilities.describeSize(mbean.getHeapMemoryUsage().getUsed()+mbean.getNonHeapMemoryUsage().getUsed()));
        System.out.println();

        PrintStream dst = null;
        ValidationOutputRenderer renderer = makeValidationOutputRenderer(validationContext);
        renderer.setCrumbTrails(validator.isCrumbTrails());
        renderer.setShowMessageIds(validator.isShowMessageIds());
        renderer.setRunDate(runDate);
        if (renderer.isSingleFile()) {
          if (validationContext.getOutput() == null) {
            dst = System.out;
          } else {
            dst = new PrintStream(ManagedFileAccess.outStream(Utilities.path(validationContext.getOutput())));
          }
          renderer.setOutput(dst);
        } else {
          File dir = ManagedFileAccess.file(validationContext.getOutput());
          if (!dir.isDirectory()) {
            throw new Error("The output location "+dir.getAbsolutePath()+" must be an existing directory for the output style "+renderer.getStyleCode());
          }
          renderer.setFolder(dir);
        }

        if (r instanceof Bundle) {
          if (renderer.handlesBundleDirectly()) {
            renderer.render((Bundle) r);
          } else {
            renderer.start(((Bundle) r).getEntry().size() > 1);
            for (Bundle.BundleEntryComponent e : ((Bundle) r).getEntry()) {
              OperationOutcome op = (OperationOutcome) e.getResource();
              ec = ec + countErrors(op);
              renderer.render(op);
            }
            renderer.finish();
          }
        } else if (r == null) {
          ec = ec + 1;
          System.out.println("No output from validation - nothing to validate");
        } else {
          renderer.start(false);
          OperationOutcome op = (OperationOutcome) r;
          ec = countErrors(op);
          renderer.render((OperationOutcome) r);
          renderer.finish();
        }

        if (validationContext.getOutput() != null && dst != null) {
          dst.close();
        }

        if (validationContext.getHtmlOutput() != null) {
          String html = new HTMLOutputGenerator(records).generate(System.currentTimeMillis() - start);
          FileUtilities.stringToFile(html, validationContext.getHtmlOutput());
          System.out.println("HTML Summary in " + validationContext.getHtmlOutput());
        }

        if (validationContext.isShowTerminologyRouting()) {
          System.out.println("");
          System.out.println("Terminology Routing Dump ---------------------------------------");
          if (validator.getContext().getTxClientManager().getInternalLog().isEmpty()) {
            System.out.println("(nothing happened)");            
          } else {
            for (InternalLogEvent log : validator.getContext().getTxClientManager().getInternalLog()) {
              System.out.println(log.getMessage()+" -> "+log.getServer()+" (for VS "+log.getVs()+" with systems '"+log.getSystems()+"', choices = '"+log.getChoices()+"')");
            }
          }
          validator.getContext().getTxClientManager().getInternalLog().clear();
        }
      }
      if (watch != ValidatorWatchMode.NONE) {
        if (statusNeeded) {
          System.out.println("Watching for changes ("+Integer.toString(watchScanDelay)+"ms cycle)");
        }
        Thread.sleep(watchScanDelay);
      }
    } while (watch != ValidatorWatchMode.NONE);
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

  private ValidationOutputRenderer makeValidationOutputRenderer(ValidationContext validationContext) {
    String style = validationContext.getOutputStyle();
    // adding to this list?
    // Must document the option at https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-ManagingOutput
    // if you're going to make a PR, document the link where the outputstyle is documented, along with a sentence that describes it, in the PR notes
    if (Utilities.noString(style)) {
      if (validationContext.getOutput() == null) {
        return new DefaultRenderer();
      } else if (validationContext.getOutput().endsWith(".json")) {
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
      System.out.println("Unknown output style '"+style+"'");
      return new DefaultRenderer();
    }
  }

  public void convertSources(ValidationContext validationContext, ValidationEngine validator) throws Exception {

      if (!((validationContext.getOutput() == null) ^ (validationContext.getOutputSuffix() == null))) {
        throw new Exception("Convert requires one of {-output, -outputSuffix} parameter to be set");
      }

      List<String> sources = validationContext.getSources();
      if ((sources.size() == 1) && (validationContext.getOutput() != null)) {
        System.out.println(" ...convert");
        validator.convert(sources.get(0), validationContext.getOutput());
      } else {
        if (validationContext.getOutputSuffix() == null) {
          throw new Exception("Converting multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < sources.size(); i++) {
            String output = sources.get(i) + "." + validationContext.getOutputSuffix();
            validator.convert(sources.get(i), output);
            System.out.println(" ...convert [" + i +  "] (" + sources.get(i) + " to " + output + ")");
        }
      }
  }

  public void evaluateFhirpath(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    System.out.println(" ...evaluating " + validationContext.getFhirpath());
    System.out.println(validator.evaluateFhirPath(validationContext.getSources().get(0), validationContext.getFhirpath()));
  }

  public void generateSnapshot(ValidationContext validationContext, ValidationEngine validator) throws Exception {

      if (!((validationContext.getOutput() == null) ^ (validationContext.getOutputSuffix() == null))) {
        throw new Exception("Snapshot generation requires one of {-output, -outputSuffix} parameter to be set");
      }

      List<String> sources = validationContext.getSources();
      if ((sources.size() == 1) && (validationContext.getOutput() != null)) {
        StructureDefinition r = validator.snapshot(sources.get(0), validationContext.getSv());
        System.out.println(" ...generated snapshot successfully");
        validator.handleOutput(r, validationContext.getOutput(), validationContext.getSv());
      } else {
        if (validationContext.getOutputSuffix() == null) {
          throw new Exception("Snapshot generation for multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < sources.size(); i++) {
          StructureDefinition r = validator.snapshot(sources.get(i), validationContext.getSv());
          String output = sources.get(i) + "." + validationContext.getOutputSuffix();
          validator.handleOutput(r, output, validationContext.getSv());
          System.out.println(" ...generated snapshot [" + i +  "] successfully (" + sources.get(i) + " to " + output + ")");
        }
      }

  }

  public void generateNarrative(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    Resource r = validator.generate(validationContext.getSources().get(0), validationContext.getSv());
    System.out.println(" ...generated narrative successfully");
    if (validationContext.getOutput() != null) {
      validator.handleOutput(r, validationContext.getOutput(), validationContext.getSv());
    }
  }

  public void transform(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    if (validationContext.getSources().size() > 1)
      throw new Exception("Can only have one source when doing a transform (found " + validationContext.getSources() + ")");
    if (validationContext.getTxServer() == null)
      throw new Exception("Must provide a terminology server when doing a transform");
    if (validationContext.getMap() == null)
      throw new Exception("Must provide a map when doing a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validator.getContext());
      List<StructureDefinition> structures =  cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          cu.generateSnapshot(sd);
        }
      }
      validator.setMapLog(validationContext.getMapLog());
      org.hl7.fhir.r5.elementmodel.Element r = validator.transform(validationContext.getSources().get(0), validationContext.getMap());
      System.out.println(" ...success");
      if (validationContext.getOutput() != null) {
        FileOutputStream s = ManagedFileAccess.outStream(validationContext.getOutput());
        if (validationContext.getOutput() != null && validationContext.getOutput().endsWith(".json"))
          new org.hl7.fhir.r5.elementmodel.JsonParser(validator.getContext()).compose(r, s, IParser.OutputStyle.PRETTY, null);
        else
          new org.hl7.fhir.r5.elementmodel.XmlParser(validator.getContext()).compose(r, s, IParser.OutputStyle.PRETTY, null);
        s.close();
      }
    } catch (Exception e) {
      System.out.println(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void compile(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    if (validationContext.getSources().size() > 0)
      throw new Exception("Cannot specify sources when compling transform (found " + validationContext.getSources() + ")");
    if (validationContext.getMap() == null)
      throw new Exception("Must provide a map when compiling a transform");
    if (validationContext.getOutput() == null)
      throw new Exception("Must provide an output name when compiling a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validator.getContext());
      List<StructureDefinition> structures = cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          cu.generateSnapshot(sd);
        }
      }
      validator.setMapLog(validationContext.getMapLog());
      StructureMap map = validator.compile(validationContext.getMap());
      if (map == null)
        throw new Exception("Unable to locate map " + validationContext.getMap());
      validator.handleOutput(map, validationContext.getOutput(), validator.getVersion());
      System.out.println(" ...success");
    } catch (Exception e) {
      System.out.println(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void transformVersion(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    if (validationContext.getSources().size() > 1) {
      throw new Exception("Can only have one source when converting versions (found " + validationContext.getSources() + ")");
    }
    if (validationContext.getTargetVer() == null) {
      throw new Exception("Must provide a map when converting versions");
    }
    if (validationContext.getOutput() == null) {
      throw new Exception("Must nominate an output when converting versions");
    }
    try {
      if (validationContext.getMapLog() != null) {
        validator.setMapLog(validationContext.getMapLog());
      }
      byte[] r = validator.transformVersion(validationContext.getSources().get(0), validationContext.getTargetVer(), validationContext.getOutput().endsWith(".json") ? Manager.FhirFormat.JSON : Manager.FhirFormat.XML, validationContext.getCanDoNative());
      System.out.println(" ...success");
      FileUtilities.bytesToFile(r, validationContext.getOutput());
    } catch (Exception e) {
      System.out.println(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public ValidationEngine initializeValidator(ValidationContext validationContext, String definitions, TimeTracker tt) throws Exception {
    return sessionCache.fetchSessionValidatorEngine(initializeValidator(validationContext, definitions, tt, null));
  }

  public String initializeValidator(ValidationContext validationContext, String definitions, TimeTracker tt, String sessionId) throws Exception {
    tt.milestone();

    if (!sessionCache.sessionExists(sessionId)) {
      if (sessionId != null) {
        System.out.println("No such cached session exists for session id " + sessionId + ", re-instantiating validator.");
      }
      sessionCache.cleanUp();
      if (validationContext.getSv() == null) {
        String sv = determineVersion(validationContext);
        validationContext.setSv(sv);
      }
      final String engineDefinitions = definitions != null ? definitions : VersionUtilities.packageForVersion(validationContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationContext.getSv());

      ValidationEngine validationEngine = getValidationEngineFromValidationContext(validationContext, engineDefinitions, tt);
      sessionId = sessionCache.cacheSession(validationEngine);
      System.out.println("Cached new session. Cache size = " + sessionCache.getSessionIds().size());

    } else {
      System.out.println("Cached session exists for session id " + sessionId + ", returning stored validator session id. Cache size = " + sessionCache.getSessionIds().size());
    }
    return sessionId;
  }

  private ValidationEngine getValidationEngineFromValidationContext(ValidationContext validationContext, String definitions, TimeTracker tt) throws Exception {
    ValidationEngine validationEngine;
    if (validationContext.getBaseEngine() != null && hasBaseEngineForKey(validationContext.getBaseEngine())) {
      validationEngine = new ValidationEngine(getBaseEngine(validationContext.getBaseEngine()));
    } else {
      if (definitions == null) {
        throw new IllegalArgumentException("Cannot create a validator engine (definitions == null)");
      }
      validationEngine = buildValidationEngine(validationContext, definitions, tt);
    }
    return validationEngine;
  }

  protected ValidationEngine.ValidationEngineBuilder getValidationEngineBuilder() {
    return new ValidationEngine.ValidationEngineBuilder();
  }

  @Nonnull
  protected ValidationEngine buildValidationEngine(ValidationContext validationContext, String definitions, TimeTracker timeTracker) throws IOException, URISyntaxException {
    System.out.print("  Load FHIR v" + validationContext.getSv() + " from " + definitions);
    ValidationEngine validationEngine = getValidationEngineBuilder().withVersion(validationContext.getSv()).withTimeTracker(timeTracker)
        .withUserAgent(Common.getValidatorUserAgent()).withThoVersion(Constants.THO_WORKING_VERSION)
        .withExtensionsVersion(Constants.EXTENSIONS_WORKING_VERSION).fromSource(definitions);

    System.out.println(" - " + validationEngine.getContext().countAllCaches() + " resources (" + timeTracker.milestone() + ")");

    loadIgsAndExtensions(validationEngine, validationContext, timeTracker);
    if (validationContext.getTxCache() != null) {
      TerminologyCache cache = new TerminologyCache(new Object(), validationContext.getTxCache());
      validationEngine.getContext().initTxCache(cache);
    }
    if (validationEngine.getContext().getTxCache() == null || validationEngine.getContext().getTxCache().getFolder() == null) {
      System.out.println("  No Terminology Cache");      
    } else {
      System.out.println("  Terminology Cache at "+validationEngine.getContext().getTxCache().getFolder());
      if (validationContext.isClearTxCache()) {
        System.out.println("  Terminology Cache Entries Cleaned out");
        validationEngine.getContext().getTxCache().clear();
      }
    }
    System.out.print("  Get set... ");
    validationEngine.setQuestionnaireMode(validationContext.getQuestionnaireMode());
    validationEngine.setLevel(validationContext.getLevel());
    validationEngine.setDoNative(validationContext.isDoNative());
    validationEngine.setHintAboutNonMustSupport(validationContext.isHintAboutNonMustSupport());
    for (String s : validationContext.getExtensions()) {
      if ("any".equals(s)) {
        validationEngine.setAnyExtensionsAllowed(true);
      } else {
        validationEngine.getExtensionDomains().add(s);
      }
    }
    validationEngine.setLanguage(validationContext.getLang());
    validationEngine.setLocale(validationContext.getLocale());
    validationEngine.setSnomedExtension(validationContext.getSnomedCTCode());
    validationEngine.setAssumeValidRestReferences(validationContext.isAssumeValidRestReferences());
    validationEngine.setShowMessagesFromReferences(validationContext.isShowMessagesFromReferences());
    validationEngine.setDoImplicitFHIRPathStringConversion(validationContext.isDoImplicitFHIRPathStringConversion());
    validationEngine.setHtmlInMarkdownCheck(validationContext.getHtmlInMarkdownCheck());
    validationEngine.setAllowDoubleQuotesInFHIRPath(validationContext.isAllowDoubleQuotesInFHIRPath());
    validationEngine.setNoExtensibleBindingMessages(validationContext.isNoExtensibleBindingMessages());
    validationEngine.setNoUnicodeBiDiControlChars(validationContext.isNoUnicodeBiDiControlChars());
    validationEngine.setNoInvariantChecks(validationContext.isNoInvariants());
    validationEngine.setDisplayWarnings(validationContext.isDisplayWarnings());
    validationEngine.setBestPracticeLevel(validationContext.getBestPracticeLevel());
    validationEngine.setCheckIPSCodes(validationContext.isCheckIPSCodes());
    validationEngine.setWantInvariantInMessage(validationContext.isWantInvariantsInMessages());
    validationEngine.setSecurityChecks(validationContext.isSecurityChecks());
    validationEngine.setCrumbTrails(validationContext.isCrumbTrails());
    validationEngine.setShowMessageIds(validationContext.isShowMessageIds());
    validationEngine.setForPublication(validationContext.isForPublication());
    validationEngine.setShowTimes(validationContext.isShowTimes());
    validationEngine.setAllowExampleUrls(validationContext.isAllowExampleUrls());
    validationEngine.setAiService(validationContext.getAIService());
    validationEngine.setR5BundleRelativeReferencePolicy(validationContext.getR5BundleRelativeReferencePolicy());
    ReferenceValidationPolicy refpol = ReferenceValidationPolicy.CHECK_VALID;
    if (!validationContext.isDisableDefaultResourceFetcher()) {
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(validationEngine.getPcm(), validationEngine.getContext(), validationEngine);
      validationEngine.setFetcher(fetcher);
      validationEngine.getContext().setLocator(fetcher);
      validationEngine.setPolicyAdvisor(fetcher);
      if (validationContext.isCheckReferences()) {
        fetcher.setReferencePolicy(ReferenceValidationPolicy.CHECK_VALID);
      } else {
        fetcher.setReferencePolicy(ReferenceValidationPolicy.IGNORE);        
      }
      fetcher.setResolutionContext(validationContext.getResolutionContext());
    } else {
      DisabledValidationPolicyAdvisor fetcher = new DisabledValidationPolicyAdvisor();
      validationEngine.setPolicyAdvisor(fetcher);
      refpol = ReferenceValidationPolicy.CHECK_TYPE_IF_EXISTS;
    }
    if (validationContext.getAdvisorFile() != null) {
      if (validationContext.getAdvisorFile().endsWith(".json")) {
        validationEngine.getPolicyAdvisor().setPolicyAdvisor(new JsonDrivenPolicyAdvisor(validationEngine.getPolicyAdvisor().getPolicyAdvisor(), ManagedFileAccess.file(validationContext.getAdvisorFile())));
      } else {
        validationEngine.getPolicyAdvisor().setPolicyAdvisor(new TextDrivenPolicyAdvisor(validationEngine.getPolicyAdvisor().getPolicyAdvisor(), ManagedFileAccess.file(validationContext.getAdvisorFile())));
      }
    } else {
      validationEngine.getPolicyAdvisor().setPolicyAdvisor(new BasePolicyAdvisorForFullValidation(validationEngine.getPolicyAdvisor() == null ? refpol : validationEngine.getPolicyAdvisor().getReferencePolicy()));
    }
    validationEngine.getBundleValidationRules().addAll(validationContext.getBundleValidationRules());
    validationEngine.setJurisdiction(CodeSystemUtilities.readCoding(validationContext.getJurisdiction()));
    validationEngine.setUnknownCodeSystemsCauseErrors(validationContext.isUnknownCodeSystemsCauseErrors());
    validationEngine.setNoExperimentalContent(validationContext.isNoExperimentalContent());
    TerminologyCache.setNoCaching(validationContext.isNoInternalCaching());
    validationEngine.prepare(); // generate any missing snapshots
    System.out.println(" go (" + timeTracker.milestone() + ")");
    return validationEngine;
  }

  protected void loadIgsAndExtensions(ValidationEngine validationEngine, ValidationContext validationContext, TimeTracker timeTracker) throws IOException, URISyntaxException {
    FhirPublication ver = FhirPublication.fromCode(validationContext.getSv());
    IgLoader igLoader = new IgLoader(validationEngine.getPcm(), validationEngine.getContext(), validationEngine.getVersion(), validationEngine.isDebug());
    igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.terminology", false);
    if (!VersionUtilities.isR5Ver(validationEngine.getContext().getVersion())) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.fhir.uv.extensions", false);
    }
    System.out.print("  Terminology server " + validationContext.getTxServer());
    String txver = validationEngine.setTerminologyServer(validationContext.getTxServer(), validationContext.getTxLog(), ver, !validationContext.getNoEcosystem());
    System.out.println(" - Version " + txver + " (" + timeTracker.milestone() + ")");
    validationEngine.setDebug(validationContext.isDoDebug());
    validationEngine.getContext().setLogger(new SystemOutLoggingService(validationContext.isDoDebug()));
    for (String src : validationContext.getIgs()) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), src, validationContext.isRecursive());
    }
    System.out.println("  Package Summary: "+ validationEngine.getContext().loadedPackageSummary());
  }

  public String determineVersion(ValidationContext validationContext) throws IOException {
    if (validationContext.getMode() != EngineMode.VALIDATION && validationContext.getMode() != EngineMode.INSTALL) {
      return "5.0";
    }
    System.out.println("Scanning for versions (no -version parameter):");
    VersionSourceInformation versions = scanForVersions(validationContext);
    for (String s : versions.getReport()) {
      if (!s.equals("(nothing found)")) {
        System.out.println("  " + s);
      }
    }
    if (versions.isEmpty()) {
      System.out.println("  No Version Info found: Using Default version R5");
      return "5.0.0";
    }
    if (versions.size() == 1) {
      System.out.println("-> use version " + versions.version());
      return versions.version();
    }
    throw new IllegalArgumentException("-> Multiple versions found. Specify a particular version using the -version parameter");
  }

  public void generateSpreadsheet(ValidationContext validationContext, ValidationEngine validator) throws Exception {
    CanonicalResource cr = validator.loadCanonicalResource(validationContext.getSources().get(0), validationContext.getSv());
    boolean ok = true;
    if (cr instanceof StructureDefinition) {
      new StructureDefinitionSpreadsheetGenerator(validator.getContext(), false, false).renderStructureDefinition((StructureDefinition) cr, false).finish(ManagedFileAccess.outStream(validationContext.getOutput()));
    } else if (cr instanceof CodeSystem) {
      new CodeSystemSpreadsheetGenerator(validator.getContext()).renderCodeSystem((CodeSystem) cr).finish(ManagedFileAccess.outStream(validationContext.getOutput()));
    } else if (cr instanceof ValueSet) {
      new ValueSetSpreadsheetGenerator(validator.getContext()).renderValueSet((ValueSet) cr).finish(ManagedFileAccess.outStream(validationContext.getOutput()));
    } else if (cr instanceof ConceptMap) {
      new ConceptMapSpreadsheetGenerator(validator.getContext()).renderConceptMap((ConceptMap) cr).finish(ManagedFileAccess.outStream(validationContext.getOutput()));
    } else {
      ok = false;
      System.out.println(" ...Unable to generate spreadsheet for "+ validationContext.getSources().get(0)+": no way to generate a spreadsheet for a "+cr.fhirType());
    }

    if (ok) {
      System.out.println(" ...generated spreadsheet successfully");
    }
  }

  public void transformLang(ValidationContext validationContext, ValidationEngine validator) throws IOException {
    switch (validationContext.getLangTransform()) {
    case "extract":
      transformLangExtract(validationContext, validator);
      break;
    case "inject":
      transformLangInject(validationContext, validator);
      break;
    default:
      System.out.println(" ...Unknown lang transform mode "+ validationContext.getLangTransform());
    }
  }

  private void transformLangExtract(ValidationContext validationContext, ValidationEngine validator) throws IOException {
    String dst = validationContext.getOutput();
    FileUtilities.createDirectory(dst);
    PoGetTextProducer po = new PoGetTextProducer(dst, ".", false);
    XLIFFProducer xliff = new XLIFFProducer(dst, ".", false);
    JsonLangFileProducer jl = new JsonLangFileProducer(dst, ".", false);
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(validationContext.getSources(), refs, validator.getContext());
    for (SourceFile ref : refs) {
      System.out.println("  Extract Translations from " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());
      LanguageProducerSession ps = po.startSession(e.fhirType()+"-"+e.getIdBase(), validationContext.getSrcLang());
      LanguageProducerLanguageSession psl = ps.forLang(validationContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish();
      ps = xliff.startSession(e.fhirType()+"-"+e.getIdBase(), validationContext.getSrcLang());
      psl = ps.forLang(validationContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
      ps = jl.startSession(e.fhirType()+"-"+e.getIdBase(), validationContext.getSrcLang());
      psl = ps.forLang(validationContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
    }
    System.out.println("Done - produced "+(po.fileCount()+xliff.fileCount()) + " files in "+dst);
  }
  
  private void transformLangInject(ValidationContext validationContext, ValidationEngine validator) throws IOException {
    String dst = validationContext.getOutput();
    FileUtilities.createDirectory(dst);
    
    List<TranslationUnit> translations = new ArrayList<>();
    for (String input : validationContext.getInputs()) {
      loadTranslationSource(translations, input);
    }
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(validationContext.getSources(), refs, validator.getContext());
    int t = 0;
    for (SourceFile ref : refs) {
      System.out.println("  Inject Translations into " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus().getBytes()), cnt.getCntType());      
      t = t + new LanguageUtils(validator.getContext()).importFromTranslations(e, translations);
      Manager.compose(validator.getContext(), e, ManagedFileAccess.outStream(Utilities.path(dst, ManagedFileAccess.file(ref.getRef()).getName())), cnt.getCntType(),
          OutputStyle.PRETTY, null);
    }
    System.out.println("Done - imported "+t+" translations into "+refs.size()+ " in "+dst);
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
            System.out.println("Error reading PO File "+f.getAbsolutePath()+": "+e.getMessage());
          }
        } else if (f.getName().endsWith(".xliff")) {
          try {
            translations.addAll(new XLIFFProducer().loadSource(ManagedFileAccess.inStream(f)));
          } catch (Exception e) {
            System.out.println("Error reading XLIFF File "+f.getAbsolutePath()+": "+e.getMessage());
          }          
        } else {
          try {
            translations.addAll(new PoGetTextProducer().loadSource(ManagedFileAccess.inStream(f)));
          } catch (Exception e) {
            try {
              translations.addAll(new XLIFFProducer().loadSource(ManagedFileAccess.inStream(f)));
            } catch (Exception e2) {
              System.out.println("Error reading File "+f.getAbsolutePath()+" as XLIFF: "+e2.getMessage());
              System.out.println("Error reading File "+f.getAbsolutePath()+" as PO: "+e.getMessage());
            }   
          }
        }
      }
    } else {
      System.out.println("Input not found: "+input);
    }    
  }

  private int cp;
  private int cs;
  public void install(ValidationContext validationContext, ValidationEngine validator) throws FHIRException, IOException {
    cp = 0;
    cs = 0;
    System.out.println("Generating Snapshots");
    for (String ig : validationContext.getIgs()) {
      processIG(validator, ig);
    }
    System.out.println("Installed/Processed "+cp+" packages, generated "+cs+" snapshots");
  }

  private void processIG(ValidationEngine validator, String ig) throws FHIRException, IOException {
    validator.loadPackage(ig, null);
    NpmPackage npm = validator.getPcm().loadPackage(ig);
    if (!npm.isCore()) {
      for (String d : npm.dependencies()) {
        processIG(validator, d);
      }
      System.out.println("Processing "+ig);
      cp++;
      for (String d : npm.listResources("StructureDefinition")) {
        String filename = npm.getFilePath(d);
        Resource res = validator.loadResource(FileUtilities.fileToBytes(filename), filename);
        if (!(res instanceof StructureDefinition))
          throw new FHIRException("Require a StructureDefinition for generating a snapshot");
        StructureDefinition sd = (StructureDefinition) res;
        if (!sd.hasSnapshot()) {
          StructureDefinition base = validator.getContext().fetchResource(StructureDefinition.class, sd.getBaseDefinition());
          cs++;
          new ProfileUtilities(validator.getContext(), new ArrayList<ValidationMessage>(), null).setAutoFixSliceNames(true).generateSnapshot(base, sd, sd.getUrl(), null, sd.getName());
          validator.handleOutput(sd, filename, validator.getVersion());
        }
      }
    }
  }

  public void codeGen(ValidationContext validationContext, ValidationEngine validationEngine) throws IOException {
    boolean ok = true;
    if (validationContext.getProfiles().isEmpty()) {
      System.out.println("Must specify at least one profile to generate code for with -profile or -profiles ");
      ok = false;
    }
    if (validationContext.getPackageName() == null) {
      System.out.println("Must provide a Java package name (-package-name)");
      ok = false;
    }
    if (validationContext.getSv() == null) {
      System.out.println("Must specify a version (-version)");
      ok = false;
    } else if (!VersionUtilities.isR4Ver(validationContext.getSv()) && !VersionUtilities.isR5Ver(validationContext.getSv())) {
      System.out.println("Only versions 4 and 5 are supported (-version)");
      ok = false;
    }
    if (validationContext.getOutput() == null) {
      System.out.println("Must provide an output directory (-output)");
      ok = false;
    }
    FileUtilities.createDirectory(validationContext.getOutput());
    if (ok) {
      PECodeGenerator gen = new PECodeGenerator(validationEngine.getContext());
      gen.setFolder(validationContext.getOutput());
      gen.setExtensionPolicy(ExtensionPolicy.Complexes);
      gen.setNarrative(validationContext.getOptions().contains("narrative"));
      gen.setMeta(validationContext.getOptions().contains("meta"));
      gen.setLanguage(Locale.getDefault().toLanguageTag());
      gen.setContained(validationContext.getOptions().contains("contained"));
      gen.setKeyElementsOnly(!validationContext.getOptions().contains("all-elements"));
      gen.setGenDate(new SimpleDateFormat().format(new Date()));
      gen.setPkgName(validationContext.getPackageName());
      if (VersionUtilities.isR4Ver(validationContext.getSv())) {
        gen.setVersion("r4");
      } else {
        gen.setVersion("r5");
      }

      for (String profile : validationContext.getProfiles()) {
        if (profile.endsWith("*")) {
          for (StructureDefinition sd : validationEngine.getContext().fetchResourcesByType(StructureDefinition.class)) {
            if (sd.getUrl().startsWith(profile.replace("*", ""))) {
              gen.setCanonical(sd.getUrl());
              System.out.print("Generate for "+sd.getUrl());
              String s = gen.execute();
              System.out.println(": "+s);
            }
          }
        } else {
          gen.setCanonical(profile);
          System.out.print("Generate for "+profile);
          String s = gen.execute();
          System.out.println(": "+s);
        }
      }
      System.out.println("Done");
    }
  }

  public void instanceFactory(ValidationContext validationContext, ValidationEngine validationEngine) throws IOException {
    boolean ok = true;
    if (validationContext.getSource() == null) {
      System.out.println("Must specify a source (-version)");
      ok = false;
    } else if (!ManagedFileAccess.file(validationContext.getSource()).exists()) {
      System.out.println("Factory source '"+ validationContext.getSource()+"' not found");
      ok = false;
    }

    if (ok) {
      System.out.println("Preparing to execute");
              
      FHIRPathEngine fpe = new FHIRPathEngine(validationEngine.getContext());
      TestDataHostServices hs = new TestDataHostServices(validationEngine.getContext(), new DateTimeType(new Date()), new StringType(VersionUtilities.getSpecUrl(validationEngine.getContext().getVersion())));
      hs.registerFunction(new GlobalObjectRandomFunction());
      hs.registerFunction(new BaseTableWrapper.TableColumnFunction());
      hs.registerFunction(new BaseTableWrapper.TableDateColumnFunction());
      hs.registerFunction(new TestDataFactory.CellLookupFunction());
      hs.registerFunction(new TestDataFactory.TableLookupFunction());
      fpe.setHostServices(hs);
      LiquidEngine liquid = new LiquidEngine(validationEngine.getContext(), hs);
      
      String path = FileUtilities.getDirectoryForFile(validationContext.getSource());
      String log = Utilities.path(path, "log");
      FileUtilities.createDirectory(log);
                  
      JsonObject json = JsonParser.parseObjectFromFile(validationContext.getSource());
      for (JsonObject fact : json.forceArray("factories").asJsonObjects()) {
        TestDataFactory tdf = new TestDataFactory(validationEngine.getContext(), fact, liquid, fpe, "http://hl7.org/fhir/test", path, log, new HashMap<>(), new Locale("us"));
        tdf.setTesting(true); // no randomness
        System.out.println("Execute Test Data Factory '"+tdf.getName()+"'. Log in "+Utilities.path(log, tdf.statedLog()));
        tdf.execute();
      }

      System.out.println("Done");
    }
  }

}
