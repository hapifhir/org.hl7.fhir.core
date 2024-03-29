package org.hl7.fhir.r4.model.codesystems;

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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0

import org.hl7.fhir.exceptions.FHIRException;

public enum GoalPriority {

  /**
   * Indicates that the goal is of considerable importance and should be a primary
   * focus of care delivery.
   */
  HIGHPRIORITY,
  /**
   * Indicates that the goal has a reasonable degree of importance and that
   * concrete action should be taken towards the goal. Attainment is not as
   * critical as high-priority goals.
   */
  MEDIUMPRIORITY,
  /**
   * The goal is desirable but is not sufficiently important to devote significant
   * resources to. Achievement of the goal may be sought when incidental to
   * achieving other goals.
   */
  LOWPRIORITY,
  /**
   * added to help the parsers
   */
  NULL;

  public static GoalPriority fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("high-priority".equals(codeString))
      return HIGHPRIORITY;
    if ("medium-priority".equals(codeString))
      return MEDIUMPRIORITY;
    if ("low-priority".equals(codeString))
      return LOWPRIORITY;
    throw new FHIRException("Unknown GoalPriority code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case HIGHPRIORITY:
      return "high-priority";
    case MEDIUMPRIORITY:
      return "medium-priority";
    case LOWPRIORITY:
      return "low-priority";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://terminology.hl7.org/CodeSystem/goal-priority";
  }

  public String getDefinition() {
    switch (this) {
    case HIGHPRIORITY:
      return "Indicates that the goal is of considerable importance and should be a primary focus of care delivery.";
    case MEDIUMPRIORITY:
      return "Indicates that the goal has a reasonable degree of importance and that concrete action should be taken towards the goal.  Attainment is not as critical as high-priority goals.";
    case LOWPRIORITY:
      return "The goal is desirable but is not sufficiently important to devote significant resources to.  Achievement of the goal may be sought when incidental to achieving other goals.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case HIGHPRIORITY:
      return "High Priority";
    case MEDIUMPRIORITY:
      return "Medium Priority";
    case LOWPRIORITY:
      return "Low Priority";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}