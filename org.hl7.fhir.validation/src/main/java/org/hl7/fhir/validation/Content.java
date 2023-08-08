package org.hl7.fhir.validation;

import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.utilities.ByteProvider;

public class Content {
  private ByteProvider focus = null;
  private Manager.FhirFormat cntType = null;

  public ByteProvider getFocus() {
    return focus;
  }
  public Manager.FhirFormat getCntType() {
    return cntType;
  }
  public void setFocus(ByteProvider focus) {
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
