package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationService {

  public static ValidationResponse validateSources(ValidationRequest request, ValidationEngine validator) throws Exception {
    if (request.getCliContext().getProfiles().size() > 0) {
      System.out.println("  .. validate " + request.listSourceFiles() + " against " + request.getCliContext().getProfiles().toString());
    } else {
      System.out.println("  .. validate " + request.listSourceFiles());
    }
    validator.prepare(); // generate any missing snapshots

    ValidationResponse response = new ValidationResponse();
    for (FileInfo fp : request.getFilesToValidate()) {
      OperationOutcome operationOutcome = validator.validate(fp.getFileContent().getBytes(), fp.getFileType(),
        request.getCliContext().getProfiles());
      ValidationOutcome outcome = new ValidationOutcome();

      // Need to set file content to null as server can't handle json in json
      fp.setFileContent(null);
      outcome.setFileInfo(fp);
      operationOutcome.getIssue().forEach(outcome::addIssue);
      response.addOutcome(outcome);
    }
    return response;
  }

  public static void validateSources(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (cliContext.getProfiles().size() > 0) {
      System.out.println("  .. validate " + cliContext.getSources() + " against " + cliContext.getProfiles().toString());
    } else {
      System.out.println("  .. validate " + cliContext.getSources());
    }
    validator.prepare(); // generate any missing snapshots
    Resource r = validator.validate(cliContext.getSources(), cliContext.getProfiles());
    int ec = 0;
    if (cliContext.getOutput() == null) {
      if (r instanceof Bundle)
        for (Bundle.BundleEntryComponent e : ((Bundle) r).getEntry())
          ec = displayOperationOutcome((OperationOutcome) e.getResource()) + ec;
      else
        ec = displayOperationOutcome((OperationOutcome) r);
    } else {
      IParser x;
      if (cliContext.getOutput() != null && cliContext.getOutput().endsWith(".json")) {
        x = new JsonParser();
      } else {
        x = new XmlParser();
      }
      x.setOutputStyle(IParser.OutputStyle.PRETTY);
      FileOutputStream s = new FileOutputStream(cliContext.getOutput());
      x.compose(s, r);
      s.close();
    }
    System.exit(ec > 0 ? 1 : 0);
  }

  public static void validateScan(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (Utilities.noString(cliContext.getOutput()))
      throw new Exception("Output parameter required when scanning");
    if (!(new File(cliContext.getOutput()).isDirectory()))
      throw new Exception("Output '" + cliContext.getOutput() + "' must be a directory when scanning");
    System.out.println("  .. scan " + cliContext.getSources() + " against loaded IGs");
    Set<String> urls = new HashSet<>();
    for (ImplementationGuide ig : validator.getContext().allImplementationGuides()) {
      if (ig.getUrl().contains("/ImplementationGuide") && !ig.getUrl().equals("http://hl7.org/fhir/ImplementationGuide/fhir"))
        urls.add(ig.getUrl());
    }
    List<ValidationEngine.ScanOutputItem> res = validator.validateScan(cliContext.getSources(), urls);
    validator.genScanOutput(cliContext.getOutput(), res);
    System.out.println("Done. output in " + Utilities.path(cliContext.getOutput(), "scan.html"));
  }

  public static void convertSources(CliContext cliContext, ValidationEngine validator) throws Exception {
    validator.convert(cliContext.getSources().get(0), cliContext.getOutput());
    System.out.println(" ...convert");
  }

  public static void evaluateFhirpath(CliContext cliContext, ValidationEngine validator) throws Exception {
    System.out.println(" ...evaluating " + cliContext.getFhirpath());
    System.out.println(validator.evaluateFhirPath(cliContext.getSources().get(0), cliContext.getFhirpath()));
  }

  public static void generateSnapshot(CliContext cliContext, ValidationEngine validator) throws Exception {
    StructureDefinition r = validator.snapshot(cliContext.getSources().get(0), cliContext.getSv());
    System.out.println(" ...generated snapshot successfully");
    if (cliContext.getOutput() != null) {
      validator.handleOutput(r, cliContext.getOutput(), cliContext.getSv());
    }
  }

  public static void generateNarrative(CliContext cliContext, ValidationEngine validator) throws Exception {
    DomainResource r = validator.generate(cliContext.getSources().get(0), cliContext.getSv());
    System.out.println(" ...generated narrative successfully");
    if (cliContext.getOutput() != null) {
      validator.handleOutput(r, cliContext.getOutput(), cliContext.getSv());
    }
  }

  public static void transform(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (cliContext.getSources().size() > 1)
      throw new Exception("Can only have one source when doing a transform (found " + cliContext.getSources() + ")");
    if (cliContext.getTxServer() == null)
      throw new Exception("Must provide a terminology server when doing a transform");
    if (cliContext.getMap() == null)
      throw new Exception("Must provide a map when doing a transform");
    try {
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

  public static void transformVersion(CliContext cliContext, ValidationEngine validator) throws Exception {
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

  public static ValidationEngine getValidator(CliContext cliContext, String definitions) throws Exception {
    System.out.println("  .. FHIR Version " + cliContext.getSv() + ", definitions from " + definitions);
    System.out.println("  .. connect to tx server @ " + cliContext.getTxServer());
    ValidationEngine validator = new ValidationEngine(definitions, cliContext.getTxServer(), cliContext.getTxLog(), FhirPublication.fromCode(cliContext.getSv()), cliContext.getSv());
    validator.setDebug(cliContext.isDoDebug());
    System.out.println("    (v" + validator.getContext().getVersion() + ")");
    for (String src : cliContext.getIgs()) {
      System.out.println("+  .. load IG from " + src);
      validator.loadIg(src, cliContext.isRecursive());
    }
    validator.setQuestionnaires(cliContext.getQuestionnaires());
    validator.setNative(cliContext.isDoNative());
    validator.setHintAboutNonMustSupport(cliContext.isHintAboutNonMustSupport());
    validator.setAnyExtensionsAllowed(cliContext.isAnyExtensionsAllowed());
    validator.setLanguage(cliContext.getLang());
    validator.setLocale(cliContext.getLocale());
    validator.setSnomedExtension(cliContext.getSnomedCTCode());
    validator.setAssumeValidRestReferences(cliContext.isAssumeValidRestReferences());
    validator.setNoExtensibleBindingMessages(cliContext.isNoExtensibleBindingMessages());
    TerminologyCache.setNoCaching(cliContext.isNoInternalCaching());
    return validator;
  }

  public static int displayOperationOutcome(OperationOutcome oo) {
    int error = 0;
    int warn = 0;
    int info = 0;
    String file = ToolingExtensions.readStringExtension(oo, ToolingExtensions.EXT_OO_FILE);

    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
      else if (issue.getSeverity() == OperationOutcome.IssueSeverity.WARNING)
        warn++;
      else
        info++;
    }

    System.out.println((error == 0 ? "Success..." : "*FAILURE* ") + "validating " + file + ": " + " error:" + Integer.toString(error) + " warn:" + Integer.toString(warn) + " info:" + Integer.toString(info));
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      System.out.println(getIssueSummary(issue));
    }
    System.out.println();
    return error;
  }

  private static String getIssueSummary(OperationOutcome.OperationOutcomeIssueComponent issue) {
    String loc = null;
    if (issue.hasExpression()) {
      int line = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, -1);
      int col = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, -1);
      loc = issue.getExpression().get(0).asStringValue() + (line >= 0 && col >= 0 ? " (line " + Integer.toString(line) + ", col" + Integer.toString(col) + ")" : "");
    } else if (issue.hasLocation()) {
      loc = issue.getLocation().get(0).asStringValue();
    } else {
      int line = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, -1);
      int col = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, -1);
      loc = (line >= 0 && col >= 0 ? "line " + Integer.toString(line) + ", col" + Integer.toString(col) : "??");
    }
    return "  " + issue.getSeverity().getDisplay() + " @ " + loc + " : " + issue.getDetails().getText();
  }
}