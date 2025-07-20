package org.hl7.fhir.validation.service.renderers;

import java.io.File;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.OperationOutcome;

public class CSVRenderer extends ValidationOutputRenderer {

  @Override
  public void start(boolean moreThanOne) {
    super.start(moreThanOne);
    dst.println("file, line, col, level, message"+(showMessageIds ? "message-id" : ""));
  }
  
  @Override
  public void render(OperationOutcome oo) {
    String file = ExtensionUtilities.readStringExtension(oo, ExtensionDefinitions.EXT_OO_FILE);
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      int line = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, -1);
      int col = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, -1);      
      dst.println(file+", " + (line == -1 ? "" : Integer.toString(line)) + ", " + (col == -1 ? "" : Integer.toString(col))+", "+issue.getSeverity().getDisplay()+", \""+issue.getDetails().getText()+"\""+
      (showMessageIds ? "," +issue.getExtensionString("http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id") : ""));
    }
  }
  

  @Override
  public boolean isSingleFile() {
    return true;
  }

  @Override
  public String getStyleCode() {
    return "csv";
  }

  @Override
  public void setFolder(File dir) {
    throw new Error("Not supported");
    
  }
  
}
