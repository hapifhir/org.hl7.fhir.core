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

public enum EligibilityrequestPurpose {

  /**
   * The prior authorization requirements for the listed, or discovered if
   * specified, converages for the categories of service and/or specifed biling
   * codes are requested.
   */
  AUTHREQUIREMENTS,
  /**
   * The plan benefits and optionally benefits consumed for the listed, or
   * discovered if specified, converages are requested.
   */
  BENEFITS,
  /**
   * The insurer is requested to report on any coverages which they are aware of
   * in addition to any specifed.
   */
  DISCOVERY,
  /**
   * A check that the specified coverages are in-force is requested.
   */
  VALIDATION,
  /**
   * added to help the parsers
   */
  NULL;

  public static EligibilityrequestPurpose fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("auth-requirements".equals(codeString))
      return AUTHREQUIREMENTS;
    if ("benefits".equals(codeString))
      return BENEFITS;
    if ("discovery".equals(codeString))
      return DISCOVERY;
    if ("validation".equals(codeString))
      return VALIDATION;
    throw new FHIRException("Unknown EligibilityrequestPurpose code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case AUTHREQUIREMENTS:
      return "auth-requirements";
    case BENEFITS:
      return "benefits";
    case DISCOVERY:
      return "discovery";
    case VALIDATION:
      return "validation";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/eligibilityrequest-purpose";
  }

  public String getDefinition() {
    switch (this) {
    case AUTHREQUIREMENTS:
      return "The prior authorization requirements for the listed, or discovered if specified, converages for the categories of service and/or specifed biling codes are requested.";
    case BENEFITS:
      return "The plan benefits and optionally benefits consumed  for the listed, or discovered if specified, converages are requested.";
    case DISCOVERY:
      return "The insurer is requested to report on any coverages which they are aware of in addition to any specifed.";
    case VALIDATION:
      return "A check that the specified coverages are in-force is requested.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case AUTHREQUIREMENTS:
      return "Coverage auth-requirements";
    case BENEFITS:
      return "Coverage benefits";
    case DISCOVERY:
      return "Coverage Discovery";
    case VALIDATION:
      return "Coverage Validation";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}