package org.hl7.fhir.r5.patterns;

import java.util.List;

import org.hl7.fhir.r5.model.Extension;

public interface PatternBase {

  public String getId();
  public PatternBase setId(String value);
  
  public List<Extension> getExtension();

}
