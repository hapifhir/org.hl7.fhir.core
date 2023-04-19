package org.hl7.fhir.r5.terminologies;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;

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



import org.hl7.fhir.r5.terminologies.ValueSetExpander.ETooCostly;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public interface ValueSetChecker {

  public static class ValidationProcessInfo {
    private TerminologyServiceErrorClass err;
    private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    public TerminologyServiceErrorClass getErr() {
      return err;
    }
    public void setErr(TerminologyServiceErrorClass err) {
      this.err = err;
    }

    public List<OperationOutcomeIssueComponent> getIssues() {
      return issues;
    }
    public void addIssue(List<OperationOutcomeIssueComponent> issues) {
      issues.addAll(issues);
      
    }
    public boolean hasErrors() {
      for (OperationOutcomeIssueComponent issue : issues) {
        if (issue.getSeverity() == IssueSeverity.FATAL || issue.getSeverity() == IssueSeverity.ERROR) {
          return true;
        }
      }
      return false;
    }
    public String summary() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("; ");
      for (OperationOutcomeIssueComponent issue : issues) {
        b.append(issue.getDetails().getText());
      }
      return b.toString();
    }
  }
  Boolean codeInValueSet(String system, String version, String code, ValidationProcessInfo info) throws ETooCostly, EOperationOutcome, Exception;

}