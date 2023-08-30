package org.hl7.fhir.validation;

import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;

public class Content {
  private byte[] focus = null;
  private Manager.FhirFormat cntType = null;

  public byte[] getFocus() {
    return focus;
  }
  public Manager.FhirFormat getCntType() {
    return cntType;
  }
  public void setFocus(byte[] focus) {
    this.focus = focus;
  }
  public void setCntType(Manager.FhirFormat cntType) {
    this.cntType = cntType;
  }
  public String getExampleFileName() {
    if (cntType != null) {
      return "file."+cntType.getExtension();
    } else {
      return "file.bin";
    }
  }
  
}
