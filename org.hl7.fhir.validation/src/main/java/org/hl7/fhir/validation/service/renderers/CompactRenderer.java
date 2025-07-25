package org.hl7.fhir.validation.service.renderers;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class CompactRenderer extends ValidationOutputRenderer {

  private boolean split;
  private File dir;

  public CompactRenderer(boolean split) {
    super();
    this.split = split;
  }

  @Override
  public void render(OperationOutcome op) throws IOException {
    if (split) {
      File file = ManagedFileAccess.file(Utilities.path(dir.getAbsolutePath(), FileUtilities.changeFileExt(tail(ExtensionUtilities.readStringExtension(op, ExtensionDefinitions.EXT_OO_FILE)), ".txt")));
      if (op.isSuccess()) {
        if (file.exists()) {
          file.delete();
        }
      } else {
        PrintStream dstF = new PrintStream(ManagedFileAccess.outStream(file));
        render(dstF, op);
        dstF.close();
      }
    } else {
      render(dst, op);
    }
  }

  private void render(PrintStream d, OperationOutcome op) throws IOException {
    if (split) {
      d.println(ManagedFileAccess.file(ExtensionUtilities.readStringExtension(op, ExtensionDefinitions.EXT_OO_FILE)).getName()+" "+getRunDate()+":");
    } else {
      d.println();
      d.println("----------------------------------------------------------------------------------");
      d.println(ExtensionUtilities.readStringExtension(op, ExtensionDefinitions.EXT_OO_FILE)+" "+getRunDate());
    }
    List<String> lines = new ArrayList<>();
    for (OperationOutcome.OperationOutcomeIssueComponent issue : op.getIssue()) {
      String path = issue.hasExpression() ? issue.getExpression().get(0).asStringValue() : "n/a";
      int line = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, -1);
      int col = ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, -1);      
      lines.add(Utilities.padLeft(Integer.toString(line), '0', 8) + ":" + Utilities.padLeft(Integer.toString(col), '0', 8)+":"+
      path+"|["+Integer.toString(line) + ", " + Integer.toString(col)+"] "+path+": "+issue.getSeverity().getDisplay()+" - "+issue.getDetails().getText()+
      renderMessageId(issue));
    }
    Collections.sort(lines);
    for (String s : lines) {
      d.println(s.substring(s.indexOf("|")+1));
    }
    if (split) {
    } else {
      d.println();
    }
  }

  private String tail(String n) {
    return n.contains(File.separator) ? n.substring(n.lastIndexOf(File.separator)+1) : n;
  }

  @Override
  public boolean isSingleFile() {
    return !split;
  }

  @Override
  public String getStyleCode() {
    return split ? "compact-split" : "compact";
  }

  @Override
  public void setFolder(File dir) {
    this.dir = dir;
  }

}
