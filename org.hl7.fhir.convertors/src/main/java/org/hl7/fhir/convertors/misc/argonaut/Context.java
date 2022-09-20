package org.hl7.fhir.convertors.misc.argonaut;

import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Encounter;
import org.hl7.fhir.dstu3.model.Reference;

import lombok.Data;

@Data
public class Context {
  private String baseId;
  private Reference authorRef;
  private Encounter encounter;
  private Coding encClass;
  private int obsId;
  private DateTimeType now = DateTimeType.now();
  private int orgId;
  private Reference subjectRef;
}
