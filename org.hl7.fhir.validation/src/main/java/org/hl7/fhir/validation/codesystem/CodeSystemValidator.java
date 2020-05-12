package org.hl7.fhir.validation.codesystem;

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



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;

public class CodeSystemValidator extends BaseValidator {

  public CodeSystemValidator(IWorkerContext context) {
    super(context);
  }

  public List<ValidationMessage> validate(CodeSystem cs, boolean forBuild) {
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    
    // this is an invariant on CodeSystem, but the invariant is wrong in R3, and doesn't work 
    checkCodesUnique(cs, errors);
    return errors;
  }

  private void checkCodesUnique(CodeSystem cs, List<ValidationMessage> errors) {
    Set<String> codes = new HashSet<String>();
    checkCodes(codes, cs.getConcept(), "CodeSystem.where(id = '"+cs.getId()+"')", errors);
  }

  private void checkCodes(Set<String> codes, List<ConceptDefinitionComponent> list, String path, List<ValidationMessage> errors) {
    for (ConceptDefinitionComponent cc : list) {
      String npath = path+".concept.descendents().where(code = '"+cc.getCode()+"')";
      rule(errors, IssueType.BUSINESSRULE, npath, !codes.contains(cc.getCode()), "Duplicate Code "+cc.getCode());
      codes.add(cc.getCode());
      checkCodes(codes, cc.getConcept(), npath, errors);
    }
  }
}