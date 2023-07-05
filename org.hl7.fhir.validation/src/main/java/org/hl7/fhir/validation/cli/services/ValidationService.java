package org.hl7.fhir.validation.cli.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.AdministrableProductDefinition;
import org.hl7.fhir.r5.conformance.R5ExtensionsLoader;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SystemOutLoggingService;
import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.spreadsheets.CodeSystemSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ConceptMapSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.StructureDefinitionSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ValueSetSpreadsheetGenerator;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.JsonLangFileProducer;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer;
import org.hl7.fhir.utilities.i18n.XLIFFProducer;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.Content;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidationEngine.IValidationEngineLoader;
import org.hl7.fhir.validation.ValidationRecord;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.FileInfo;
import org.hl7.fhir.validation.cli.model.ValidationOutcome;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.hl7.fhir.validation.cli.model.ValidationResponse;
import org.hl7.fhir.validation.cli.renderers.CSVRenderer;
import org.hl7.fhir.validation.cli.renderers.CompactRenderer;
import org.hl7.fhir.validation.cli.renderers.DefaultRenderer;
import org.hl7.fhir.validation.cli.renderers.ESLintCompactRenderer;
import org.hl7.fhir.validation.cli.renderers.NativeRenderer;
import org.hl7.fhir.validation.cli.renderers.ValidationOutputRenderer;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.cli.utils.VersionSourceInformation;

import javax.annotation.Nonnull;

public class ValidationService {

  private final SessionCache sessionCache;
  private String runDate;

  public ValidationService() {
    sessionCache = new SessionCache();
    runDate = new SimpleDateFormat("hh:mm:ss", new Locale("en", "US")).format(new Date());
  }

  protected ValidationService(SessionCache cache) {
    this.sessionCache = cache;
  }

  public ValidationResponse validateSources(ValidationRequest request) throws Exception {
    if (request.getCliContext().getSv() == null) {
      String sv = determineVersion(request.getCliContext(), request.sessionId);
      request.getCliContext().setSv(sv);
    }

    String definitions = VersionUtilities.packageForVersion(request.getCliContext().getSv()) + "#" + VersionUtilities.getCurrentVersion(request.getCliContext().getSv());

    String sessionId = initializeValidator(request.getCliContext(), definitions, new TimeTracker(), request.sessionId);
    ValidationEngine validator = sessionCache.fetchSessionValidatorEngine(sessionId);

    if (request.getCliContext().getProfiles().size() > 0) {
      System.out.println("  .. validate " + request.listSourceFiles() + " against " + request.getCliContext().getProfiles().toString());
    } else {
      System.out.println("  .. validate " + request.listSourceFiles());
    }

    ValidationResponse response = new ValidationResponse().setSessionId(sessionId);

    for (FileInfo fp : request.getFilesToValidate()) {
      List<ValidationMessage> messages = new ArrayList<>();
      validator.validate(fp.getFileContent().getBytes(), Manager.FhirFormat.getFhirFormat(fp.getFileType()),
        request.getCliContext().getProfiles(), messages);
      ValidationOutcome outcome = new ValidationOutcome().setFileInfo(fp);
      messages.forEach(outcome::addMessage);
      response.addOutcome(outcome);
    }
    System.out.println("  Max Memory: "+Runtime.getRuntime().maxMemory());
    return response;
  }

  public VersionSourceInformation scanForVersions(CliContext cliContext) throws Exception {
    VersionSourceInformation versions = new VersionSourceInformation();
    IgLoader igLoader = new IgLoader(
      new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER),
      new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing(),
      null);
    for (String src : cliContext.getIgs()) {
      igLoader.scanForIgVersion(src, cliContext.isRecursive(), versions);
    }
    igLoader.scanForVersions(cliContext.getSources(), versions);
    return versions;
  }

  public void validateSources(CliContext cliContext, ValidationEngine validator, ValidatorWatchMode watch, int watchScanDelay, int watchSettleTime) throws Exception {
    if (cliContext.getProfiles().size() > 0) {
      System.out.println("  Profiles: " + cliContext.getProfiles());
    }
    IgLoader igLoader = new IgLoader(validator.getPcm(), validator.getContext(), validator.getVersion());
        
    List<ValidationRecord> records = new ArrayList<>();
    List<SourceFile> refs = new ArrayList<>();

    int ec = 0;
    boolean first = true;

    do {
      long start = System.currentTimeMillis();
      Resource r = validator.validate(cliContext.getSources(), cliContext.getProfiles(), refs, records, igLoader, watch == ValidatorWatchMode.ALL, watchSettleTime, first);
      first = false;
      boolean statusNeeded = false;
      if (r != null) {
        statusNeeded = true;
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        System.out.println("Done. " + validator.getContext().clock().report()+". Memory = "+Utilities.describeSize(mbean.getHeapMemoryUsage().getUsed()+mbean.getNonHeapMemoryUsage().getUsed()));
        System.out.println();

        PrintStream dst = null;
        ValidationOutputRenderer renderer = makeValidationOutputRenderer(cliContext);
        renderer.setCrumbTrails(validator.isCrumbTrails());
        renderer.setRunDate(runDate);
        if (renderer.isSingleFile()) {
          if (cliContext.getOutput() == null) {
            dst = System.out;
          } else {
            dst = new PrintStream(new FileOutputStream(cliContext.getOutput()));
          }
          renderer.setOutput(dst);
        } else {
          File dir = new File(cliContext.getOutput());
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

        if (cliContext.getOutput() != null && dst != null) {
          dst.close();
        }

        if (cliContext.getHtmlOutput() != null) {
          String html = new HTMLOutputGenerator(records).generate(System.currentTimeMillis() - start);
          TextFile.stringToFile(html, cliContext.getHtmlOutput());
          System.out.println("HTML Summary in " + cliContext.getHtmlOutput());
        }
      }
      if (watch != ValidatorWatchMode.NONE) {
        if (statusNeeded) {
          System.out.println("Watching for changes ("+Integer.toString(watchScanDelay)+"ms cycle)");
        }
        Thread.sleep(watchScanDelay);
      }
    } while (watch != ValidatorWatchMode.NONE);
    System.exit(ec > 0 ? 1 : 0);
  }

  private int countErrors(OperationOutcome oo) {
    int error = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
    }
    return error;
  }

  private ValidationOutputRenderer makeValidationOutputRenderer(CliContext cliContext) {
    String style = cliContext.getOutputStyle();
    // adding to this list?
    // Must document the option at https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-ManagingOutput
    // if you're going to make a PR, document the link where the outputstyle is documented, along with a sentence that describes it, in the PR notes
    if (Utilities.noString(style)) {
      if (cliContext.getOutput() == null) {
        return new DefaultRenderer();
      } else if (cliContext.getOutput().endsWith(".json")) {
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

  public void convertSources(CliContext cliContext, ValidationEngine validator) throws Exception {

      if (!((cliContext.getOutput() == null) ^ (cliContext.getOutputSuffix() == null))) {
        throw new Exception("Convert requires one of {-output, -outputSuffix} parameter to be set");
      }

      List<String> sources = cliContext.getSources();
      if ((sources.size() == 1) && (cliContext.getOutput() != null)) {
        System.out.println(" ...convert");
        validator.convert(sources.get(0), cliContext.getOutput());
      } else {
        if (cliContext.getOutputSuffix() == null) {
          throw new Exception("Converting multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < sources.size(); i++) {
            String output = sources.get(i) + "." + cliContext.getOutputSuffix();
            validator.convert(sources.get(i), output);
            System.out.println(" ...convert [" + i +  "] (" + sources.get(i) + " to " + output + ")");
        }
      }
  }

  public void evaluateFhirpath(CliContext cliContext, ValidationEngine validator) throws Exception {
    System.out.println(" ...evaluating " + cliContext.getFhirpath());
    System.out.println(validator.evaluateFhirPath(cliContext.getSources().get(0), cliContext.getFhirpath()));
  }

  public void generateSnapshot(CliContext cliContext, ValidationEngine validator) throws Exception {

      if (!((cliContext.getOutput() == null) ^ (cliContext.getOutputSuffix() == null))) {
        throw new Exception("Snapshot generation requires one of {-output, -outputSuffix} parameter to be set");
      }

      List<String> sources = cliContext.getSources();
      if ((sources.size() == 1) && (cliContext.getOutput() != null)) {
        StructureDefinition r = validator.snapshot(sources.get(0), cliContext.getSv());
        System.out.println(" ...generated snapshot successfully");
        validator.handleOutput(r, cliContext.getOutput(), cliContext.getSv());
      } else {
        if (cliContext.getOutputSuffix() == null) {
          throw new Exception("Snapshot generation for multiple/wildcard sources requires a -outputSuffix parameter to be set");
        }
        for (int i = 0; i < sources.size(); i++) {
          StructureDefinition r = validator.snapshot(sources.get(i), cliContext.getSv());
          String output = sources.get(i) + "." + cliContext.getOutputSuffix();
          validator.handleOutput(r, output, cliContext.getSv());
          System.out.println(" ...generated snapshot [" + i +  "] successfully (" + sources.get(i) + " to " + output + ")");
        }
      }

  }

  public void generateNarrative(CliContext cliContext, ValidationEngine validator) throws Exception {
    Resource r = validator.generate(cliContext.getSources().get(0), cliContext.getSv());
    System.out.println(" ...generated narrative successfully");
    if (cliContext.getOutput() != null) {
      validator.handleOutput(r, cliContext.getOutput(), cliContext.getSv());
    }
  }

  public void transform(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (cliContext.getSources().size() > 1)
      throw new Exception("Can only have one source when doing a transform (found " + cliContext.getSources() + ")");
    if (cliContext.getTxServer() == null)
      throw new Exception("Must provide a terminology server when doing a transform");
    if (cliContext.getMap() == null)
      throw new Exception("Must provide a map when doing a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validator.getContext());
      List<StructureDefinition> structures =  cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          if (sd.getKind() != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
            cu.generateSnapshot(sd, true);
          } else {
            cu.generateSnapshot(sd, false);
          }
        }
      }
      validator.setMapLog(cliContext.getMapLog());
      org.hl7.fhir.r5.elementmodel.Element r = validator.transform(cliContext.getSources().get(0), cliContext.getMap());
      System.out.println(" ...success");
      if (cliContext.getOutput() != null) {
        FileOutputStream s = new FileOutputStream(cliContext.getOutput());
        if (cliContext.getOutput() != null && cliContext.getOutput().endsWith(".json"))
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

  public void compile(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (cliContext.getSources().size() > 0)
      throw new Exception("Cannot specify sources when compling transform (found " + cliContext.getSources() + ")");
    if (cliContext.getMap() == null)
      throw new Exception("Must provide a map when compiling a transform");
    if (cliContext.getOutput() == null)
      throw new Exception("Must provide an output name when compiling a transform");
    try {
      ContextUtilities cu = new ContextUtilities(validator.getContext());
      List<StructureDefinition> structures = cu.allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          if (sd.getKind() != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
            cu.generateSnapshot(sd, true);
          } else {
            cu.generateSnapshot(sd, false);
          }
        }
      }
      validator.setMapLog(cliContext.getMapLog());
      StructureMap map = validator.compile(cliContext.getMap());
      if (map == null)
        throw new Exception("Unable to locate map " + cliContext.getMap());
      validator.handleOutput(map, cliContext.getOutput(), validator.getVersion());
      System.out.println(" ...success");
    } catch (Exception e) {
      System.out.println(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void transformVersion(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (cliContext.getSources().size() > 1) {
      throw new Exception("Can only have one source when converting versions (found " + cliContext.getSources() + ")");
    }
    if (cliContext.getTargetVer() == null) {
      throw new Exception("Must provide a map when converting versions");
    }
    if (cliContext.getOutput() == null) {
      throw new Exception("Must nominate an output when converting versions");
    }
    try {
      if (cliContext.getMapLog() != null) {
        validator.setMapLog(cliContext.getMapLog());
      }
      byte[] r = validator.transformVersion(cliContext.getSources().get(0), cliContext.getTargetVer(), cliContext.getOutput().endsWith(".json") ? Manager.FhirFormat.JSON : Manager.FhirFormat.XML, cliContext.getCanDoNative());
      System.out.println(" ...success");
      TextFile.bytesToFile(r, cliContext.getOutput());
    } catch (Exception e) {
      System.out.println(" ...Failure: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public ValidationEngine initializeValidator(CliContext cliContext, String definitions, TimeTracker tt) throws Exception {
    return sessionCache.fetchSessionValidatorEngine(initializeValidator(cliContext, definitions, tt, null));
  }

  public String initializeValidator(CliContext cliContext, String definitions, TimeTracker tt, String sessionId) throws Exception {
    tt.milestone();
    sessionCache.removeExpiredSessions();
    if (!sessionCache.sessionExists(sessionId)) {
      if (sessionId != null) {
        System.out.println("No such cached session exists for session id " + sessionId + ", re-instantiating validator.");
      }
      ValidationEngine validator = buildValidationEngine(cliContext, definitions, tt);
      sessionId = sessionCache.cacheSession(validator);
    } else {
      System.out.println("Cached session exists for session id " + sessionId + ", returning stored validator session id.");
    }
    return sessionId;
  }

  protected ValidationEngine.ValidationEngineBuilder getValidationEngineBuilder() {
    return new ValidationEngine.ValidationEngineBuilder();
  }

  @Nonnull
  protected ValidationEngine buildValidationEngine( CliContext cliContext, String definitions, TimeTracker timeTracker) throws IOException, URISyntaxException {
    System.out.print("  Load FHIR v" + cliContext.getSv() + " from " + definitions);
    ValidationEngine validationEngine = getValidationEngineBuilder().withTHO(false).withVersion(cliContext.getSv()).withTimeTracker(timeTracker).withUserAgent("fhir/validator").fromSource(definitions);

    System.out.println(" - " + validationEngine.getContext().countAllCaches() + " resources (" + timeTracker.milestone() + ")");

    loadIgsAndExtensions(validationEngine, cliContext, timeTracker);
    System.out.print("  Get set... ");
    validationEngine.setQuestionnaireMode(cliContext.getQuestionnaireMode());
    validationEngine.setLevel(cliContext.getLevel());
    validationEngine.setDoNative(cliContext.isDoNative());
    validationEngine.setHintAboutNonMustSupport(cliContext.isHintAboutNonMustSupport());
    for (String s : cliContext.getExtensions()) {
      if ("any".equals(s)) {
        validationEngine.setAnyExtensionsAllowed(true);
      } else {
        validationEngine.getExtensionDomains().add(s);
      }
    }
    validationEngine.setLanguage(cliContext.getLang());
    validationEngine.setLocale(cliContext.getLocale());
    validationEngine.setSnomedExtension(cliContext.getSnomedCTCode());
    validationEngine.setAssumeValidRestReferences(cliContext.isAssumeValidRestReferences());
    validationEngine.setShowMessagesFromReferences(cliContext.isShowMessagesFromReferences());
    validationEngine.setDoImplicitFHIRPathStringConversion(cliContext.isDoImplicitFHIRPathStringConversion());
    validationEngine.setHtmlInMarkdownCheck(cliContext.getHtmlInMarkdownCheck());
    validationEngine.setAllowDoubleQuotesInFHIRPath(cliContext.isAllowDoubleQuotesInFHIRPath());
    validationEngine.setNoExtensibleBindingMessages(cliContext.isNoExtensibleBindingMessages());
    validationEngine.setNoUnicodeBiDiControlChars(cliContext.isNoUnicodeBiDiControlChars());
    validationEngine.setNoInvariantChecks(cliContext.isNoInvariants());
    validationEngine.setDisplayWarnings(cliContext.isDisplayWarnings());
    validationEngine.setWantInvariantInMessage(cliContext.isWantInvariantsInMessages());
    validationEngine.setSecurityChecks(cliContext.isSecurityChecks());
    validationEngine.setCrumbTrails(cliContext.isCrumbTrails());
    validationEngine.setForPublication(cliContext.isForPublication());
    validationEngine.setShowTimes(cliContext.isShowTimes());
    validationEngine.setAllowExampleUrls(cliContext.isAllowExampleUrls());
    StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(validationEngine.getPcm(), validationEngine.getContext(), validationEngine);
    validationEngine.setFetcher(fetcher);
    validationEngine.getContext().setLocator(fetcher);
    validationEngine.getBundleValidationRules().addAll(cliContext.getBundleValidationRules());
    validationEngine.setJurisdiction(CodeSystemUtilities.readCoding(cliContext.getJurisdiction()));
    TerminologyCache.setNoCaching(cliContext.isNoInternalCaching());
    validationEngine.prepare(); // generate any missing snapshots
    System.out.println(" go (" + timeTracker.milestone() + ")");
    return validationEngine;
  }

  protected void loadIgsAndExtensions(ValidationEngine validationEngine, CliContext cliContext, TimeTracker timeTracker) throws IOException, URISyntaxException {
    FhirPublication ver = FhirPublication.fromCode(cliContext.getSv());
    IgLoader igLoader = new IgLoader(validationEngine.getPcm(), validationEngine.getContext(), validationEngine.getVersion(), validationEngine.isDebug());
    igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.terminology", false);
    if (!VersionUtilities.isR5Ver(validationEngine.getContext().getVersion())) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.fhir.uv.extensions", false);
    }
    System.out.print("  Terminology server " + cliContext.getTxServer());
    String txver = validationEngine.setTerminologyServer(cliContext.getTxServer(), cliContext.getTxLog(), ver);
    System.out.println(" - Version " + txver + " (" + timeTracker.milestone() + ")");
    validationEngine.setDebug(cliContext.isDoDebug());
    validationEngine.getContext().setLogger(new SystemOutLoggingService(cliContext.isDoDebug()));
    for (String src : cliContext.getIgs()) {
      igLoader.loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), src, cliContext.isRecursive());
    }
    System.out.println("  Package Summary: "+ validationEngine.getContext().loadedPackageSummary());
  }


  public String determineVersion(CliContext cliContext) throws Exception {
    return determineVersion(cliContext, null);
  }

  public String determineVersion(CliContext cliContext, String sessionId) throws Exception {
    if (cliContext.getMode() != EngineMode.VALIDATION && cliContext.getMode() != EngineMode.INSTALL) {
      return "5.0";
    }
    System.out.println("Scanning for versions (no -version parameter):");
    VersionSourceInformation versions = scanForVersions(cliContext);
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
    throw new Exception("-> Multiple versions found. Specify a particular version using the -version parameter");
  }

  public void generateSpreadsheet(CliContext cliContext, ValidationEngine validator) throws Exception {
    CanonicalResource cr = validator.loadCanonicalResource(cliContext.getSources().get(0), cliContext.getSv());
    boolean ok = true;
    if (cr instanceof StructureDefinition) {
      new StructureDefinitionSpreadsheetGenerator(validator.getContext(), false, false).renderStructureDefinition((StructureDefinition) cr, false).finish(new FileOutputStream(cliContext.getOutput()));
    } else if (cr instanceof CodeSystem) {
      new CodeSystemSpreadsheetGenerator(validator.getContext()).renderCodeSystem((CodeSystem) cr).finish(new FileOutputStream(cliContext.getOutput()));
    } else if (cr instanceof ValueSet) {
      new ValueSetSpreadsheetGenerator(validator.getContext()).renderValueSet((ValueSet) cr).finish(new FileOutputStream(cliContext.getOutput()));
    } else if (cr instanceof ConceptMap) {
      new ConceptMapSpreadsheetGenerator(validator.getContext()).renderConceptMap((ConceptMap) cr).finish(new FileOutputStream(cliContext.getOutput()));
    } else {
      ok = false;
      System.out.println(" ...Unable to generate spreadsheet for "+cliContext.getSources().get(0)+": no way to generate a spreadsheet for a "+cr.fhirType());
    }

    if (ok) {
      System.out.println(" ...generated spreadsheet successfully");
    }
  }

  public void transformLang(CliContext cliContext, ValidationEngine validator) throws IOException {
    switch (cliContext.getLangTransform()) {
    case "extract":
      transformLangExtract(cliContext, validator);
      break;
    case "inject":
      transformLangInject(cliContext, validator);
      break;
    default:
      System.out.println(" ...Unknown lang transform mode "+cliContext.getLangTransform());        
    }
  }

  private void transformLangExtract(CliContext cliContext, ValidationEngine validator) throws IOException { 
    String dst = cliContext.getOutput();
    Utilities.createDirectory(dst);
    PoGetTextProducer po = new PoGetTextProducer(Utilities.path(dst));
    XLIFFProducer xliff = new XLIFFProducer(Utilities.path(dst));
    JsonLangFileProducer jl = new JsonLangFileProducer(Utilities.path(dst));
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(cliContext.getSources(), refs, validator.getContext());    
    for (SourceFile ref : refs) {
      System.out.println("  Extract Translations from " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());
      LanguageProducerSession ps = po.startSession(e.fhirType()+"-"+e.getIdBase(), cliContext.getSrcLang());
      LanguageProducerLanguageSession psl = ps.forLang(cliContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish();
      ps = xliff.startSession(e.fhirType()+"-"+e.getIdBase(), cliContext.getSrcLang());
      psl = ps.forLang(cliContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
      ps = jl.startSession(e.fhirType()+"-"+e.getIdBase(), cliContext.getSrcLang());
      psl = ps.forLang(cliContext.getTgtLang());
      new LanguageUtils(validator.getContext()).generateTranslations(e, psl);
      psl.finish();
      ps.finish(); 
    }
    System.out.println("Done - produced "+(po.fileCount()+xliff.fileCount()) + " files in "+dst);
  }
  
  private void transformLangInject(CliContext cliContext, ValidationEngine validator) throws IOException { 
    String dst = cliContext.getOutput();
    Utilities.createDirectory(dst);
    
    Set<TranslationUnit> translations = new HashSet<>();
    for (String input : cliContext.getInputs()) {
      loadTranslationSource(translations, input);
    }
    
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(cliContext.getSources(), refs, validator.getContext()); 
    int t = 0;
    for (SourceFile ref : refs) {
      System.out.println("  Inject Translations into " + ref);
      org.hl7.fhir.validation.Content cnt = validator.getIgLoader().loadContent(ref.getRef(), "translate", false, true);
      Element e = Manager.parseSingle(validator.getContext(), new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());      
      t = t + new LanguageUtils(validator.getContext()).importFromTranslations(e, translations);
      Manager.compose(validator.getContext(), e, new FileOutputStream(Utilities.path(dst, new File(ref.getRef()).getName())), cnt.getCntType(),
          OutputStyle.PRETTY, null);
    }
    System.out.println("Done - imported "+t+" translations into "+refs.size()+ " in "+dst);
  }
  
  private void loadTranslationSource(Set<TranslationUnit> translations, String input) {
    File f = new File(input);
    if (f.exists()) {
      if (f.isDirectory()) {
        for (File fd : f.listFiles()) {
          loadTranslationSource(translations, fd.getAbsolutePath());
        }
      } else {
        if (f.getName().endsWith(".po")) {
          try {
            translations.addAll(new PoGetTextProducer().loadSource(new FileInputStream(f)));
          } catch (Exception e) {
            System.out.println("Error reading PO File "+f.getAbsolutePath()+": "+e.getMessage());
          }
        } else if (f.getName().endsWith(".xliff")) {
          try {
            translations.addAll(new XLIFFProducer().loadSource(new FileInputStream(f)));
          } catch (Exception e) {
            System.out.println("Error reading XLIFF File "+f.getAbsolutePath()+": "+e.getMessage());
          }          
        } else {
          try {
            translations.addAll(new PoGetTextProducer().loadSource(new FileInputStream(f)));
          } catch (Exception e) {
            try {
              translations.addAll(new XLIFFProducer().loadSource(new FileInputStream(f)));
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
  public void install(CliContext cliContext, ValidationEngine validator) throws FHIRException, IOException {
    cp = 0;
    cs = 0;
    System.out.println("Generating Snapshots");
    for (String ig : cliContext.getIgs()) {
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
        Resource res = validator.loadResource(TextFile.fileToBytes(filename), filename);
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

}
