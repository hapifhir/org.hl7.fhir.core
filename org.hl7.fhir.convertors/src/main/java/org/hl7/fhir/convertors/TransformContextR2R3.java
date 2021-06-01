package org.hl7.fhir.convertors;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;

@AllArgsConstructor
@Data
public class TransformContextR2R3 {
  private SimpleWorkerContext context;
  private String id;
}
