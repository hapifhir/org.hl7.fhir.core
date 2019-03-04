package org.hl7.fhir.r5.terminologies;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.FileNotFoundException;
import java.io.IOException;

import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;

public interface ValueSetExpander {
  public enum TerminologyServiceErrorClass {
    UNKNOWN, NOSERVICE, SERVER_ERROR, VALUESET_UNSUPPORTED;

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
    }
    public ValueSetExpansionOutcome(ValueSetChecker service, String error, TerminologyServiceErrorClass errorClass) {
      super();
      this.valueset = null;
      this.error = error;
      this.errorClass = errorClass;
    }
    public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass) {
      this.valueset = null;
      this.error = error;
      this.errorClass = errorClass;
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


  }
/**
 * 
 * @param source the value set definition to expand
 * @param profile a profile affecting the outcome. If you don't supply a profile, the default internal expansion profile will be used.
 *  
 * @return
 * @throws ETooCostly
 * @throws FileNotFoundException
 * @throws IOException
 */
  public ValueSetExpansionOutcome expand(ValueSet source, Parameters parameters) throws ETooCostly, FileNotFoundException, IOException;
}
