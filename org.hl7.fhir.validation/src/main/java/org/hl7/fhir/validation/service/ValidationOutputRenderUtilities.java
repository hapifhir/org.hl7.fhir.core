package org.hl7.fhir.validation.service;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.service.renderers.*;
import org.hl7.fhir.validation.service.utils.Slf4JOutputStream;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

@Slf4j
public class ValidationOutputRenderUtilities {
  public static ValidationOutputRenderSummary renderValidationOutput(Resource resource, String output, String outputStyle, boolean isCrumbTrails, boolean isShowMessageIds, String runDate) throws IOException {
    int errorCount = 0;
    PrintStream outputStream = null;
    ValidationOutputRenderer renderer = makeValidationOutputRenderer(output, outputStyle);
    renderer.setCrumbTrails(isCrumbTrails);
    renderer.setShowMessageIds(isShowMessageIds);
    renderer.setRunDate(runDate);
    if (renderer.isSingleFile()) {
      if (output == null) {
        outputStream = new PrintStream(new Slf4JOutputStream());
      } else {
        outputStream = new PrintStream(ManagedFileAccess.outStream(Utilities.path(output)));
      }
      renderer.setOutput(outputStream);
    } else {
      File folder = ManagedFileAccess.file(output);
      if (!folder.isDirectory()) {
        throw new Error("The output location " + folder.getAbsolutePath() + " must be an existing directory for the output style " + renderer.getStyleCode());
      }
      renderer.setFolder(folder);
    }

    if (resource instanceof Bundle) {
      if (renderer.handlesBundleDirectly()) {
        renderer.render((Bundle) resource);
      } else {
        renderer.start(((Bundle) resource).getEntry().size() > 1);
        for (Bundle.BundleEntryComponent e : ((Bundle) resource).getEntry()) {
          OperationOutcome op = (OperationOutcome) e.getResource();
          errorCount = errorCount + countErrors(op);
          renderer.render(op);
        }
        renderer.finish();
      }
    } else if (resource == null) {
      errorCount = errorCount + 1;
      log.info("No output from validation - nothing to validate");
    } else {
      renderer.start(false);
      OperationOutcome op = (OperationOutcome) resource;
      errorCount = countErrors(op);
      renderer.render((OperationOutcome) resource);
      renderer.finish();
    }

    if (output != null && outputStream != null) {
      outputStream.close();
    }
    return new ValidationOutputRenderSummary.ValidationOutputRenderSummaryBuilder().totalErrors(errorCount).build();
  }

  private static int countErrors(OperationOutcome oo) {
    int error = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
    }
    return error;
  }

  private static ValidationOutputRenderer makeValidationOutputRenderer(String output, String style) {

    // adding to this list?
    // Must document the option at https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-ManagingOutput
    // if you're going to make a PR, document the link where the outputstyle is documented, along with a sentence that describes it, in the PR notes
    if (Utilities.noString(style)) {
      if (output == null) {
        return new DefaultRenderer();
      } else if (output.endsWith(".json")) {
        return new NativeRenderer(Manager.FhirFormat.JSON);
      } else {
        return new NativeRenderer(Manager.FhirFormat.XML);
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
      return new NativeRenderer(Manager.FhirFormat.XML);
    } else if (Utilities.existsInList(style, "json")) {
      return new NativeRenderer(Manager.FhirFormat.JSON);
    } else {
      log.info("Unknown output style '"+style+"'");
      return new DefaultRenderer();
    }
  }
}
