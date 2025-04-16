package org.hl7.fhir.validation.service.renderers;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;

public abstract class ValidationOutputRenderer {

  private String runDate;
  protected boolean crumbTrails;
  protected boolean moreThanOne;
  protected PrintStream dst;
  protected boolean showMessageIds;

  public boolean isCrumbTrails() {
    return crumbTrails;
  }

  public void setCrumbTrails(boolean crumbTrails) {
    this.crumbTrails = crumbTrails;
  }

  public boolean isShowMessageIds() {
    return showMessageIds;
  }

  public void setShowMessageIds(boolean showMessageIds) {
    this.showMessageIds = showMessageIds;
  }

  public String getRunDate() {
    return runDate;
  }

  public void setRunDate(String runDate) {
    this.runDate = runDate;
  }

  public void start(boolean moreThanOne) {
    this.moreThanOne = moreThanOne;
  }
  
  public abstract void render(OperationOutcome op) throws IOException;
  
  public void render(Bundle bundle) throws IOException {
    throw new Error("Should not call render*Bundle) when handlesBundleDirectly() == false");
  }
  
  public void finish() {  
  }

  public void setOutput(PrintStream dst) {
    this.dst = dst;    
  }
  
  public boolean handlesBundleDirectly() {
    return false;
  }

  public abstract boolean isSingleFile();

  public abstract String getStyleCode();

  public abstract void setFolder(File dir);
  

  protected String renderMessageId(OperationOutcome.OperationOutcomeIssueComponent issue) {
    return showMessageIds ? " {" +issue.getExtensionString("http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id")+"}" : "";
  }

}
