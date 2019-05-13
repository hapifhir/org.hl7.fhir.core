package org.hl7.fhir.r5.patterns;

import java.util.List;

import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;

public class PatternBaseImpl implements PatternBase {

  private Base wrapped;
  
  public PatternBaseImpl(Base wrapped) {
    super();
    this.wrapped = wrapped;
  }

  @Override
  public String getId() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getId();
    if (wrapped instanceof Resource)
      return ((Resource) wrapped).getId();
    return null;
  }

  @Override
  public PatternBase setId(String value) {
    if (wrapped instanceof Element)
      ((Element) wrapped).setId(value);
    else if (wrapped instanceof Resource)
      ((Resource) wrapped).setId(value);
    else
      throw new Error("this should not happen? wrapped = "+wrapped.getClass().getName());
    return this;
  }

  @Override
  public List<Extension> getExtension() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getExtension();
    if (wrapped instanceof DomainResource)
      return ((DomainResource) wrapped).getExtension();
    return null;
  }


  protected Annotation convertStringToAnnotation(String value) {
    if (value == null)
      return null;
    else
      return new Annotation().setText(value);
  }
  
  protected String convertAnnotationToString(Annotation value) {
    if (value == null)
      return null;
    else
      return value.getText();
  }


}
