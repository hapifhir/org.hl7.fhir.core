package org.hl7.fhir.services.conformance;

import org.hl7.fhir.model.core.ElementDefinition;



public class ElementRedirection {

  private String path;
  private ElementDefinition element;

  public ElementRedirection(ElementDefinition element, String path) {
    this.path = path;
    this.element = element;
  }

  public ElementDefinition getElement() {
    return element;
  }

  @Override
  public String toString() {
    return element.toString() + " : " + path;
  }

  public String getPath() {
    return path;
  }

}
