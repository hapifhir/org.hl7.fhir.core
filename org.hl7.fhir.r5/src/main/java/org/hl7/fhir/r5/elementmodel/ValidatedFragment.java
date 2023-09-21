package org.hl7.fhir.r5.elementmodel;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidatedFragment {
  private String name;
  private String extension;
  private Element element;
  private byte[] content;
  private List<ValidationMessage> errors = new ArrayList<>();
  
  public ValidatedFragment(String name, String extension, Element element, byte[] content) {
    super();
    this.name = name;
    this.element = element; 
    this.content = content;
    this.extension = extension;
  }

  public ValidatedFragment(String name, String extension, byte[] content) {
    super();
    this.name = name;
    this.content = content;
    this.extension = extension;
  }
  
  public String getName() {
    return name;
  }
  
  public Element getElement() {
    return element;
  }

  public byte[] getContent() {
    return content;
  }

  public List<ValidationMessage> getErrors() {
    return errors;
  }

  public void setElement(Element element) {
    this.element = element;
  }

  public String getFilename() {
    return name+"."+extension;
  }
  
}