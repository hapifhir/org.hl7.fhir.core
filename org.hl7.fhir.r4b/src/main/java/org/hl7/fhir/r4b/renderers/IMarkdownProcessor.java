package org.hl7.fhir.r4b.renderers;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.PrimitiveType;

public interface IMarkdownProcessor {

  @SuppressWarnings("rawtypes")
  public String processMarkdown(String location, PrimitiveType md) throws FHIRException;
  
  public String processMarkdown(String location, String text) throws FHIRException;

}
