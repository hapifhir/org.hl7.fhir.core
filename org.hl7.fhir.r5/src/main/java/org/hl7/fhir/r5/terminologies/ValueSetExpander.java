package org.hl7.fhir.r5.terminologies;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;

public interface ValueSetExpander {
  public enum TerminologyServiceErrorClass {
    UNKNOWN, NOSERVICE, SERVER_ERROR, VALUESET_UNSUPPORTED, CODESYSTEM_UNSUPPORTED, BLOCKED_BY_OPTIONS, INTERNAL_ERROR, BUSINESS_RULE, TOO_COSTLY;

    public boolean isInfrastructure() {
      return this == NOSERVICE || this == SERVER_ERROR || this == VALUESET_UNSUPPORTED;
    }
  }
  
  public class ETooCostly extends Exception {

    public ETooCostly(String msg) {
      super(msg);
    }

  }

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
    
    public ValueSetExpansionOutcome(ValueSet valueset) {
      super();
      this.valueset = valueset;
      this.error = null;
    }
    public ValueSetExpansionOutcome(ValueSet valueset, String error, TerminologyServiceErrorClass errorClass) {
      super();
      this.valueset = valueset;
      this.error = error;
      this.errorClass = errorClass;
      allErrors.add(error);
    }
    public ValueSetExpansionOutcome(ValueSetChecker service, String error, TerminologyServiceErrorClass errorClass) {
      super();
      this.valueset = null;
      this.error = error;
      this.errorClass = errorClass;
      allErrors.add(error);
    }
    public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass) {
      this.valueset = null;
      this.error = error;
      this.errorClass = errorClass;
      allErrors.add(error);
    }
    public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass, List<String> errList) {
      this.valueset = null;
      this.error = error;
      this.errorClass = errorClass;
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
    
    public boolean isOk() {
      return (allErrors.isEmpty() || (allErrors.size() == 1 && allErrors.get(0) == null)) && error == null;
    }
  }
/**
 * 
 * @param source the value set definition to expand
 * @param profile a set of parameters affecting the outcome. If you don't supply parameters, the default internal parameters will be used.
 *  
 * @return
 * @throws ETooCostly
 * @throws FileNotFoundException
 * @throws IOException
 */
  public ValueSetExpansionOutcome expand(ValueSet source, Parameters parameters) throws ETooCostly, FileNotFoundException, IOException;
}