package org.hl7.fhir.dstu2016may.model.codesystems;

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

// Generated on Sun, May 8, 2016 03:05+1000 for FHIR v1.4.0

import org.hl7.fhir.exceptions.FHIRException;

public enum QuestionnaireAnswersStatus {

  /**
   * This QuestionnaireResponse has been partially filled out with answers, but
   * changes or additions are still expected to be made to it.
   */
  INPROGRESS,
  /**
   * This QuestionnaireResponse has been filled out with answers, and the current
   * content is regarded as definitive.
   */
  COMPLETED,
  /**
   * This QuestionnaireResponse has been filled out with answers, then marked as
   * complete, yet changes or additions have been made to it afterwards.
   */
  AMENDED,
  /**
   * added to help the parsers
   */
  NULL;

  public static QuestionnaireAnswersStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("in-progress".equals(codeString))
      return INPROGRESS;
    if ("completed".equals(codeString))
      return COMPLETED;
    if ("amended".equals(codeString))
      return AMENDED;
    throw new FHIRException("Unknown QuestionnaireAnswersStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case INPROGRESS:
      return "in-progress";
    case COMPLETED:
      return "completed";
    case AMENDED:
      return "amended";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/questionnaire-answers-status";
  }

  public String getDefinition() {
    switch (this) {
    case INPROGRESS:
      return "This QuestionnaireResponse has been partially filled out with answers, but changes or additions are still expected to be made to it.";
    case COMPLETED:
      return "This QuestionnaireResponse has been filled out with answers, and the current content is regarded as definitive.";
    case AMENDED:
      return "This QuestionnaireResponse has been filled out with answers, then marked as complete, yet changes or additions have been made to it afterwards.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case INPROGRESS:
      return "In Progress";
    case COMPLETED:
      return "Completed";
    case AMENDED:
      return "Amended";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}