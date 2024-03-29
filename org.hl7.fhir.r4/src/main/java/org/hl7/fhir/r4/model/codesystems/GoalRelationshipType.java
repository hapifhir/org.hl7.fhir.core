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

public enum GoalRelationshipType {

  /**
   * Indicates that the target goal is one which must be met before striving for
   * the current goal.
   */
  PREDECESSOR,
  /**
   * Indicates that the target goal is a desired objective once the current goal
   * is met.
   */
  SUCCESSOR,
  /**
   * Indicates that this goal has been replaced by the target goal.
   */
  REPLACEMENT,
  /**
   * Indicates that the target goal is considered to be a "piece" of attaining
   * this goal.
   */
  MILESTONE,
  /**
   * Indicates that the relationship is not covered by one of the pre-defined
   * codes. (An extension may convey more information about the meaning of the
   * relationship.).
   */
  OTHER,
  /**
   * added to help the parsers
   */
  NULL;

  public static GoalRelationshipType fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("predecessor".equals(codeString))
      return PREDECESSOR;
    if ("successor".equals(codeString))
      return SUCCESSOR;
    if ("replacement".equals(codeString))
      return REPLACEMENT;
    if ("milestone".equals(codeString))
      return MILESTONE;
    if ("other".equals(codeString))
      return OTHER;
    throw new FHIRException("Unknown GoalRelationshipType code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case PREDECESSOR:
      return "predecessor";
    case SUCCESSOR:
      return "successor";
    case REPLACEMENT:
      return "replacement";
    case MILESTONE:
      return "milestone";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://terminology.hl7.org/CodeSystem/goal-relationship-type";
  }

  public String getDefinition() {
    switch (this) {
    case PREDECESSOR:
      return "Indicates that the target goal is one which must be met before striving for the current goal.";
    case SUCCESSOR:
      return "Indicates that the target goal is a desired objective once the current goal is met.";
    case REPLACEMENT:
      return "Indicates that this goal has been replaced by the target goal.";
    case MILESTONE:
      return "Indicates that the target goal is considered to be a \"piece\" of attaining this goal.";
    case OTHER:
      return "Indicates that the relationship is not covered by one of the pre-defined codes.  (An extension may convey more information about the meaning of the relationship.).";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case PREDECESSOR:
      return "Predecessor";
    case SUCCESSOR:
      return "Successor";
    case REPLACEMENT:
      return "Replacement";
    case MILESTONE:
      return "Milestone";
    case OTHER:
      return "Other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}