package org.hl7.fhir.validation.cli.renderers;

import java.io.File;

import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;

public class ESLintCompactRenderer extends ValidationOutputRenderer {

  @Override
  public void render(OperationOutcome oo) {
    String file = ToolingExtensions.readStringExtension(oo, ToolingExtensions.EXT_OO_FILE);
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      int line = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, -1);
      int col = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, -1);      
      dst.println(file+": line " + Integer.toString(line) + ", col" + Integer.toString(col)+", "+issue.getSeverity().getDisplay()+" - "+issue.getDetails().getText());
    }
  }
  

  @Override
  public boolean isSingleFile() {
    return true;
  }

  @Override
  public String getStyleCode() {
    return "eslint-compact";
  }

  @Override
  public void setFolder(File dir) {
    throw new Error("Not supported");
    
  }
  
}
