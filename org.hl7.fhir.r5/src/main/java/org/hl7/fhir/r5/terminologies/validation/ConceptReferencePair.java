package org.hl7.fhir.r5.terminologies.validation;

import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;

public class ConceptReferencePair {

  private ValueSet valueset;
  private ConceptReferenceComponent cc;

  public ConceptReferencePair(ValueSet valueset, ConceptReferenceComponent cc) {
    this.valueset = valueset;
    this.cc = cc;
  }

  public ValueSet getValueset() {
    return valueset;
  }

  public ConceptReferenceComponent getCc() {
    return cc;
  }

}