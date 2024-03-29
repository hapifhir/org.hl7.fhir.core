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

public enum DefinitionStatus {

  /**
   * The definition is in the design stage and is not yet considered to be "ready
   * for use".
   */
  DRAFT,
  /**
   * The definition is considered ready for use.
   */
  ACTIVE,
  /**
   * The definition should no longer be used.
   */
  WITHDRAWN,
  /**
   * The authoring/source system does not know which of the status values
   * currently applies for this resource. Note: This concept is not to be used for
   * "other" - one of the listed statuses is presumed to apply, but the
   * authoring/source system does not know which.
   */
  UNKNOWN,
  /**
   * added to help the parsers
   */
  NULL;

  public static DefinitionStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("draft".equals(codeString))
      return DRAFT;
    if ("active".equals(codeString))
      return ACTIVE;
    if ("withdrawn".equals(codeString))
      return WITHDRAWN;
    if ("unknown".equals(codeString))
      return UNKNOWN;
    throw new FHIRException("Unknown DefinitionStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case DRAFT:
      return "draft";
    case ACTIVE:
      return "active";
    case WITHDRAWN:
      return "withdrawn";
    case UNKNOWN:
      return "unknown";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://terminology.hl7.org/CodeSystem/definition-status";
  }

  public String getDefinition() {
    switch (this) {
    case DRAFT:
      return "The definition is in the design stage and is not yet considered to be \"ready for use\".";
    case ACTIVE:
      return "The definition is considered ready for use.";
    case WITHDRAWN:
      return "The definition should no longer be used.";
    case UNKNOWN:
      return "The authoring/source system does not know which of the status values currently applies for this resource.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case DRAFT:
      return "Draft";
    case ACTIVE:
      return "Active";
    case WITHDRAWN:
      return "Withdrawn";
    case UNKNOWN:
      return "Unknown";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}