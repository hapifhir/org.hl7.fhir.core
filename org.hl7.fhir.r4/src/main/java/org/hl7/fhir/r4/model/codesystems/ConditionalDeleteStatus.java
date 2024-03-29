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

public enum ConditionalDeleteStatus {

  /**
   * No support for conditional deletes.
   */
  NOTSUPPORTED,
  /**
   * Conditional deletes are supported, but only single resources at a time.
   */
  SINGLE,
  /**
   * Conditional deletes are supported, and multiple resources can be deleted in a
   * single interaction.
   */
  MULTIPLE,
  /**
   * added to help the parsers
   */
  NULL;

  public static ConditionalDeleteStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("not-supported".equals(codeString))
      return NOTSUPPORTED;
    if ("single".equals(codeString))
      return SINGLE;
    if ("multiple".equals(codeString))
      return MULTIPLE;
    throw new FHIRException("Unknown ConditionalDeleteStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case NOTSUPPORTED:
      return "not-supported";
    case SINGLE:
      return "single";
    case MULTIPLE:
      return "multiple";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/conditional-delete-status";
  }

  public String getDefinition() {
    switch (this) {
    case NOTSUPPORTED:
      return "No support for conditional deletes.";
    case SINGLE:
      return "Conditional deletes are supported, but only single resources at a time.";
    case MULTIPLE:
      return "Conditional deletes are supported, and multiple resources can be deleted in a single interaction.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case NOTSUPPORTED:
      return "Not Supported";
    case SINGLE:
      return "Single Deletes Supported";
    case MULTIPLE:
      return "Multiple Deletes Supported";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}