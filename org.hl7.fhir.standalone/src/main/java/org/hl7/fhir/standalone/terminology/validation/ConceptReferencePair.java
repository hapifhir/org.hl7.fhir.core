package org.hl7.fhir.standalone.terminology.validation;

import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent;



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