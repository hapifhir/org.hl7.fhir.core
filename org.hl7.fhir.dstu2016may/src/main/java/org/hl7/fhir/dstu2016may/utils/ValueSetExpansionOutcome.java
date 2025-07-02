package org.hl7.fhir.dstu2016may.utils;

import org.hl7.fhir.dstu2016may.model.ValueSet; /**
 * Some value sets are just too big to expand. Instead of an expanded value set,
 * you get back an interface that can test membership - usually on a server
 * somewhere
 *
 * @author Grahame
 */
public class ValueSetExpansionOutcome {
  private final ValueSet valueset;
  private final String error;

  public ValueSetExpansionOutcome(ValueSet valueset) {
    super();
    this.valueset = valueset;
    this.error = null;
  }

  public ValueSetExpansionOutcome(ValueSet valueset, String error) {
    super();
    this.valueset = valueset;
    this.error = error;
  }


  public ValueSetExpansionOutcome(String error) {
    this.valueset = null;
    this.error = error;
  }

  public ValueSet getValueset() {
    return valueset;
  }


  public String getError() {
    return error;
  }

}
