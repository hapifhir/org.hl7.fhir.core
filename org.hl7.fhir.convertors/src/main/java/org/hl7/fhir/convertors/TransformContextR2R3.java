package org.hl7.fhir.convertors;

import org.hl7.fhir.dstu3.context.SimpleWorkerContext;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransformContextR2R3 {
  private SimpleWorkerContext context;
  private String id;
}
