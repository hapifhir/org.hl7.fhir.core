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

public enum ListStatus {

  /**
   * The list is considered to be an active part of the patient's record.
   */
  CURRENT,
  /**
   * The list is "old" and should no longer be considered accurate or relevant.
   */
  RETIRED,
  /**
   * The list was never accurate. It is retained for medico-legal purposes only.
   */
  ENTEREDINERROR,
  /**
   * added to help the parsers
   */
  NULL;

  public static ListStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("current".equals(codeString))
      return CURRENT;
    if ("retired".equals(codeString))
      return RETIRED;
    if ("entered-in-error".equals(codeString))
      return ENTEREDINERROR;
    throw new FHIRException("Unknown ListStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case CURRENT:
      return "current";
    case RETIRED:
      return "retired";
    case ENTEREDINERROR:
      return "entered-in-error";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/list-status";
  }

  public String getDefinition() {
    switch (this) {
    case CURRENT:
      return "The list is considered to be an active part of the patient's record.";
    case RETIRED:
      return "The list is \"old\" and should no longer be considered accurate or relevant.";
    case ENTEREDINERROR:
      return "The list was never accurate.  It is retained for medico-legal purposes only.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case CURRENT:
      return "Current";
    case RETIRED:
      return "Retired";
    case ENTEREDINERROR:
      return "Entered In Error";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}