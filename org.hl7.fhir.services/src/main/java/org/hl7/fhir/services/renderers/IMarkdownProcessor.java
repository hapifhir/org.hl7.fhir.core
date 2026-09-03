package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.PrimitiveType;



public interface IMarkdownProcessor {

  @SuppressWarnings("rawtypes")
  public String processMarkdown(String location, PrimitiveType md) throws FHIRException;
  
  public String processMarkdown(String location, String text) throws FHIRException;

}
