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

public enum RemittanceOutcome {

  /**
   * The Claim/Pre-authorization/Pre-determination has been received but
   * processing has not begun.
   */
  QUEUED,
  /**
   * The processing has completed without errors
   */
  COMPLETE,
  /**
   * One or more errors have been detected in the Claim
   */
  ERROR,
  /**
   * No errors have been detected in the Claim and some of the adjudication has
   * been performed.
   */
  PARTIAL,
  /**
   * added to help the parsers
   */
  NULL;

  public static RemittanceOutcome fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("queued".equals(codeString))
      return QUEUED;
    if ("complete".equals(codeString))
      return COMPLETE;
    if ("error".equals(codeString))
      return ERROR;
    if ("partial".equals(codeString))
      return PARTIAL;
    throw new FHIRException("Unknown RemittanceOutcome code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case QUEUED:
      return "queued";
    case COMPLETE:
      return "complete";
    case ERROR:
      return "error";
    case PARTIAL:
      return "partial";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/remittance-outcome";
  }

  public String getDefinition() {
    switch (this) {
    case QUEUED:
      return "The Claim/Pre-authorization/Pre-determination has been received but processing has not begun.";
    case COMPLETE:
      return "The processing has completed without errors";
    case ERROR:
      return "One or more errors have been detected in the Claim";
    case PARTIAL:
      return "No errors have been detected in the Claim and some of the adjudication has been performed.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case QUEUED:
      return "Queued";
    case COMPLETE:
      return "Processing Complete";
    case ERROR:
      return "Error";
    case PARTIAL:
      return "Partial Processing";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}