package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SystemOutLoggingService;
import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.renderers.spreadsheets.CodeSystemSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ConceptMapSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.StructureDefinitionSpreadsheetGenerator;
import org.hl7.fhir.r5.renderers.spreadsheets.ValueSetSpreadsheetGenerator;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.SimpleTimeTracker;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidationRecord;
import org.hl7.fhir.validation.cli.model.*;
import org.hl7.fhir.validation.cli.renderers.CSVRenderer;
import org.hl7.fhir.validation.cli.renderers.DefaultRenderer;
import org.hl7.fhir.validation.cli.renderers.ESLintCompactRenderer;
import org.hl7.fhir.validation.cli.renderers.NativeRenderer;
import org.hl7.fhir.validation.cli.renderers.ValidationOutputRenderer;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.cli.utils.VersionSourceInformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.List;

public class ValidationService {

  private final SessionCache sessionCache;

  public ValidationService() {
    sessionCache = new SessionCache();
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
      new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION),
      new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing(),
      null);
    for (String src : cliContext.getIgs()) {
      igLoader.scanForIgVersion(src, cliContext.isRecursive(), versions);
    }
    igLoader.scanForVersions(cliContext.getSources(), versions);
    return versions;
  }

  public void validateSources(CliContext cliContext, ValidationEngine validator) throws Exception {
    long start = System.currentTimeMillis();
    List<ValidationRecord> records = new ArrayList<>();
    Resource r = validator.validate(cliContext.getSources(), cliContext.getProfiles(), records);
    MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
    System.out.println("Done. " + validator.getContext().clock().report()+". Memory = "+Utilities.describeSize(mbean.getHeapMemoryUsage().getUsed()+mbean.getNonHeapMemoryUsage().getUsed()));
    System.out.println();

    PrintStream dst = null;
    if (cliContext.getOutput() == null) {
      dst = System.out;
    } else {
      dst = new PrintStream(new FileOutputStream(cliContext.getOutput()));
    }

    ValidationOutputRenderer renderer = makeValidationOutputRenderer(cliContext);
    renderer.setOutput(dst);
    renderer.setCrumbTrails(validator.isCrumbTrails());
    
    int ec = 0;
    
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
    
    if (cliContext.getOutput() != null) {
      dst.close();
    }

    if (cliContext.getHtmlOutput() != null) {
      String html = new HTMLOutputGenerator(records).generate(System.currentTimeMillis() - start);
      TextFile.stringToFile(html, cliContext.getHtmlOutput());
      System.out.println("HTML Summary in " + cliContext.getHtmlOutput());
    }
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
    System.out.println(" ...convert");
    validator.convert(cliContext.getSources().get(0), cliContext.getOutput());
  }

  public void evaluateFhirpath(CliContext cliContext, ValidationEngine validator) throws Exception {
    System.out.println(" ...evaluating " + cliContext.getFhirpath());
    System.out.println(validator.evaluateFhirPath(cliContext.getSources().get(0), cliContext.getFhirpath()));
  }

  public void generateSnapshot(CliContext cliContext, ValidationEngine validator) throws Exception {
    StructureDefinition r = validator.snapshot(cliContext.getSources().get(0), cliContext.getSv());
    System.out.println(" ...generated snapshot successfully");
    if (cliContext.getOutput() != null) {
      validator.handleOutput(r, cliContext.getOutput(), cliContext.getSv());
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
      List<StructureDefinition> structures = validator.getContext().allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          if (sd.getKind() != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
            validator.getContext().generateSnapshot(sd, true);
          } else {
            validator.getContext().generateSnapshot(sd, false);
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
      List<StructureDefinition> structures = validator.getContext().allStructures();
      for (StructureDefinition sd : structures) {
        if (!sd.hasSnapshot()) {
          if (sd.getKind() != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
            validator.getContext().generateSnapshot(sd, true);
          } else {
            validator.getContext().generateSnapshot(sd, false);
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
    if (!sessionCache.sessionExists(sessionId)) {
      if (sessionId != null) {
        System.out.println("No such cached session exists for session id " + sessionId + ", re-instantiating validator.");
      }
      System.out.print("  Load FHIR v" + cliContext.getSv() + " from " + definitions);
      ValidationEngine validator = new ValidationEngine.ValidationEngineBuilder().withVersion(cliContext.getSv()).withTimeTracker(tt).withUserAgent("fhir/validator").fromSource(definitions);

      sessionId = sessionCache.cacheSession(validator);

      FhirPublication ver = FhirPublication.fromCode(cliContext.getSv());
      IgLoader igLoader = new IgLoader(validator.getPcm(), validator.getContext(), validator.getVersion(), validator.isDebug());
      System.out.println(" - " + validator.getContext().countAllCaches() + " resources (" + tt.milestone() + ")");
      igLoader.loadIg(validator.getIgs(), validator.getBinaries(), "hl7.terminology", false);
      System.out.print("  Terminology server " + cliContext.getTxServer());
      String txver = validator.setTerminologyServer(cliContext.getTxServer(), cliContext.getTxLog(), ver);
      System.out.println(" - Version " + txver + " (" + tt.milestone() + ")");
      validator.setDebug(cliContext.isDoDebug());
      validator.getContext().setLogger(new SystemOutLoggingService(cliContext.isDoDebug()));
      for (String src : cliContext.getIgs()) {
        igLoader.loadIg(validator.getIgs(), validator.getBinaries(), src, cliContext.isRecursive());
      }
      System.out.print("  Get set... ");
      validator.setQuestionnaireMode(cliContext.getQuestionnaireMode());
      validator.setLevel(cliContext.getLevel());
      validator.setDoNative(cliContext.isDoNative());
      validator.setHintAboutNonMustSupport(cliContext.isHintAboutNonMustSupport());
      for (String s : cliContext.getExtensions()) {
        if ("any".equals(s)) {
          validator.setAnyExtensionsAllowed(true);
        } else {          
          validator.getExtensionDomains().add(s);
        }
      }
      validator.setLanguage(cliContext.getLang());
      validator.setLocale(cliContext.getLocale());
      validator.setSnomedExtension(cliContext.getSnomedCTCode());
      validator.setAssumeValidRestReferences(cliContext.isAssumeValidRestReferences());
      validator.setShowMessagesFromReferences(cliContext.isShowMessagesFromReferences());
      validator.setDoImplicitFHIRPathStringConversion(cliContext.isDoImplicitFHIRPathStringConversion());
      validator.setNoExtensibleBindingMessages(cliContext.isNoExtensibleBindingMessages());
      validator.setNoUnicodeBiDiControlChars(cliContext.isNoUnicodeBiDiControlChars());
      validator.setNoInvariantChecks(cliContext.isNoInvariants());
      validator.setWantInvariantInMessage(cliContext.isWantInvariantsInMessages());
      validator.setSecurityChecks(cliContext.isSecurityChecks());
      validator.setCrumbTrails(cliContext.isCrumbTrails());
      validator.setShowTimes(cliContext.isShowTimes());
      validator.setAllowExampleUrls(cliContext.isAllowExampleUrls());
      StandAloneValidatorFetcher fetcher = new StandAloneValidatorFetcher(validator.getPcm(), validator.getContext(), validator);    
      validator.setFetcher(fetcher);
      validator.getContext().setLocator(fetcher);
      validator.getBundleValidationRules().addAll(cliContext.getBundleValidationRules());
      validator.setJurisdiction(CodeSystemUtilities.readCoding(cliContext.getJurisdiction()));
      TerminologyCache.setNoCaching(cliContext.isNoInternalCaching());
      validator.prepare(); // generate any missing snapshots
      System.out.println(" go (" + tt.milestone() + ")");
    } else {
      System.out.println("Cached session exists for session id " + sessionId + ", returning stored validator session id.");
    }
    return sessionId;
  }


  public String determineVersion(CliContext cliContext) throws Exception {
    return determineVersion(cliContext, null);
  }

  public String determineVersion(CliContext cliContext, String sessionId) throws Exception {
    if (cliContext.getMode() != EngineMode.VALIDATION) {
      return "current";
    }
    System.out.println("Scanning for versions (no -version parameter):");
    VersionSourceInformation versions = scanForVersions(cliContext);
    for (String s : versions.getReport()) {
      if (!s.equals("(nothing found)")) {
        System.out.println("  " + s);
      }
    }
    if (versions.isEmpty()) {
      System.out.println("  No Version Info found: Using Default version '" + VersionUtilities.CURRENT_DEFAULT_VERSION + "'");
      return VersionUtilities.CURRENT_DEFAULT_FULL_VERSION;
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
      new StructureDefinitionSpreadsheetGenerator(validator.getContext(), false, false).renderStructureDefinition((StructureDefinition) cr).finish(new FileOutputStream(cliContext.getOutput()));
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
}