package org.hl7.fhir.validation.cli.renderers;

import org.hl7.fhir.r5.model.OperationOutcome;

public abstract class ValidationOutputRenderer {

  protected boolean crumbTrails;
  protected boolean moreThanOne;

  public boolean isCrumbTrails() {
    return crumbTrails;
  }

  public void setCrumbTrails(boolean crumbTrails) {
    this.crumbTrails = crumbTrails;
  }

  public void start(boolean moreThanOne) {
    this.moreThanOne = moreThanOne;
  }
  
  public abstract void render(OperationOutcome op);
  
  public void finish() {  
  }
  
}
