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



import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;


/**
 * The value set system has a collection of value sets 
 * that define code systems, and construct value sets from 
 * them
 * 
 * Large external terminologies - LOINC, Snomed, etc - are too big, and 
 * trying to represent their definition as a native value set is too 
 * large. (e.g. LOINC + properties ~ 500MB). So we don't try. Instead.
 * we assume that there's some external server that provides these 
 * services, using this interface
 * 
 * The FHIR build tool uses http://fhir.healthintersections.com.au for 
 * these services
 * 
 * @author Grahame
 *
 */
public interface ITerminologyServices {
  /**
   * return true if the service handles code or value set resolution on the system
   */
  public boolean supportsSystem(String system);
  
  /** 
   *  given a system|code, return a definition for it. Nil means not valid
   */
  public ConceptDefinitionComponent getCodeDefinition(String system, String code);
  
  public class ValidationResult {
    private IssueSeverity severity;
    private String message;
    public ValidationResult(IssueSeverity severity, String message) {
      super();
      this.severity = severity;
      this.message = message;
    }
    public IssueSeverity getSeverity() {
      return severity;
    }
    public String getMessage() {
      return message;
    }


  }

  /**
   * for this system|code and display, validate the triple against the rules of 
   * the underlying code system
   */
  public ValidationResult validateCode(String system, String code, String display);
  
  /**
   * Expand the value set fragment (system | codes | filters). Note that this 
   * might fail if the expansion is very large. If the expansion fails, then the 
   * checkVS will be called instead
   */
  public ValueSetExpansionComponent expandVS(ConceptSetComponent inc) throws Exception;
//  public ValueSet expandVS(ValueSet vs) throws Exception;
  public ValueSetExpansionOutcome expand(ValueSet vs);
  
  /**
   * Test the value set fragment (system | codes | filters). 
   */
  public boolean checkVS(ConceptSetComponent vsi, String system, String code);
  
  public boolean verifiesSystem(String system);



}