package org.hl7.fhir.validation.service.renderers;

import java.io.File;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.OperationOutcome;

public class ESLintCompactRenderer extends ValidationOutputRenderer {

  @Override
  public void render(OperationOutcome oo) {
    String file = ExtensionUtilities.readStringExtension(oo, ExtensionDefinitions.EXT_OO_FILE);
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      int line = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, -1);
      int col = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, -1);      
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
