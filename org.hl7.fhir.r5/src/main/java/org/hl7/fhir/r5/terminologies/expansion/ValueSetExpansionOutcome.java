package org.hl7.fhir.r5.terminologies.expansion;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;

/**
 * Some value sets are just too big to expand. Instead of an expanded value set, 
 * you get back an interface that can test membership - usually on a server somewhere
 * 
 * @author Grahame
 */
public class ValueSetExpansionOutcome {
  private ValueSet valueset;
  private String error;
  private TerminologyServiceErrorClass errorClass;
  private String txLink;
  private List<String> allErrors = new ArrayList<>();
  private boolean fromServer;
  
  public ValueSetExpansionOutcome(ValueSet valueset) {
    super();
    this.valueset = valueset;
    this.error = null;
  }
  public ValueSetExpansionOutcome(ValueSet valueset, String error, TerminologyServiceErrorClass errorClass, boolean fromServer) {
    super();
    this.valueset = valueset;
    this.error = error;
    this.errorClass = errorClass;
    this.fromServer = fromServer;
    allErrors.add(error);
  }

  public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass, boolean fromServer) {
    this.valueset = null;
    this.error = error;
    this.errorClass = errorClass;
    this.fromServer = fromServer;
    allErrors.add(error);
  }
  public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass, List<String> errList, boolean fromServer) {
    this.valueset = null;
    this.error = error;
    this.errorClass = errorClass;
    this.fromServer = fromServer;
    this.allErrors.addAll(errList);
    if (!allErrors.contains(error)) {
      allErrors.add(error);
    }
    if (!errList.contains(error)) {
      errList.add(error);
    }
  }
  
  public ValueSet getValueset() {
    return valueset;
  }
  public String getError() {
    return error;
  }
  public TerminologyServiceErrorClass getErrorClass() {
    return errorClass;
  }
  public String getTxLink() {
    return txLink;
  }
  public ValueSetExpansionOutcome setTxLink(String txLink) {
    this.txLink = txLink;
    return this;
  }
  public List<String> getAllErrors() {
    return allErrors;
  }
  
  public boolean isFromServer() {
    return fromServer;
  }
  public boolean isOk() {
    return (allErrors.isEmpty() || (allErrors.size() == 1 && allErrors.get(0) == null)) && error == null;
  }
  public int count() {
    if (valueset == null) {
      return 0; 
    }
    return ValueSetUtilities.countExpansion(valueset);
  }
}