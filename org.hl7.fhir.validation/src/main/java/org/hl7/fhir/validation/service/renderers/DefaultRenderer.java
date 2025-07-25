package org.hl7.fhir.validation.service.renderers;

import java.io.File;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class DefaultRenderer extends ValidationOutputRenderer {

  @Override
  public void render(OperationOutcome oo) {
    int error = 0;
    int warn = 0;
    int info = 0;
    String file = ExtensionUtilities.readStringExtension(oo, ExtensionDefinitions.EXT_OO_FILE);

    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
      else if (issue.getSeverity() == OperationOutcome.IssueSeverity.WARNING)
        warn++;
      else
        info++;
    }

    if (moreThanOne) {
      dst.print("-- ");
      dst.print(file);
      dst.print(" --");
      dst.println(Utilities.padLeft("", '-', Integer.max(38, file.length() + 6)));
    }
    dst.println((error == 0 ? "Success" : "*FAILURE*") + ": " + Integer.toString(error) + " errors, " + Integer.toString(warn) + " warnings, " + Integer.toString(info) + " notes");
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      dst.println(getIssueSummary(issue)+renderMessageId(issue));
      ValidationMessage vm = (ValidationMessage) issue.getUserData(UserDataNames.validator_source_msg);
      if (vm != null && vm.getSliceInfo() != null && (crumbTrails || vm.isCriticalSignpost())) {
        for (ValidationMessage s : vm.getSliceInfo()) {
          dst.println("    slice "+s.getLevel().toShortCode()+": "+s.getMessage());          
          if (s.hasSliceInfo()) {
            for (ValidationMessage si : s.getSliceInfo()) {
              if (si.isError()) {
                dst.println("    - "+si.summaryNoLevel());
              }
            }
          }
        }
      }
    }
    if (moreThanOne) {
      dst.print("---");
      dst.print(Utilities.padLeft("", '-', file.length()));
      dst.print("---");
      dst.println(Utilities.padLeft("", '-', Integer.max(38, file.length() + 6)));
      dst.println();
    }
  }

  private String getIssueSummary(OperationOutcome.OperationOutcomeIssueComponent issue) {
    String loc;
    if (issue.hasExpression()) {
      int line = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, -1);
      int col = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, -1);
      loc = " @ "+issue.getExpression().get(0).asStringValue() + (line >= 0 && col >= 0 ? " (line " + Integer.toString(line) + ", col" + Integer.toString(col) + ")" : "");
    } else if (issue.hasExpressionOrLocation()) {
      loc = " @ "+issue.getExpressionOrLocation().get(0).asStringValue();
    } else {
      int line = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, -1);
      int col = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, -1);
      if (issue.getSeverity() == IssueSeverity.INFORMATION && (line == -1 || col == -1)) {
        loc = "";
      } else {
        loc = " @ "+"line " + Integer.toString(line) + ", col" + Integer.toString(col);
      }
    }
    return "  " + issue.getSeverity().getDisplay() + loc + ": " + issue.getDetails().getText();
  }


  @Override
  public boolean isSingleFile() {
    return true;
  }

  @Override
  public String getStyleCode() {
    return "(default)";
  }

  @Override
  public void setFolder(File dir) {
    throw new Error("Not supported");
    
  }
  
}
