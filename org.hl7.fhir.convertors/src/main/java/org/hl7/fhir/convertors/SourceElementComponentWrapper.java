package org.hl7.fhir.convertors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceElementComponentWrapper<T> {
  public T comp;
  public String source;
  public String target;
}
