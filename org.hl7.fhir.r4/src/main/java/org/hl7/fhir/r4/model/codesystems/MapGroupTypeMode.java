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

public enum MapGroupTypeMode {

  /**
   * This group is not a default group for the types.
   */
  NONE,
  /**
   * This group is a default mapping group for the specified types and for the
   * primary source type.
   */
  TYPES,
  /**
   * This group is a default mapping group for the specified types.
   */
  TYPEANDTYPES,
  /**
   * added to help the parsers
   */
  NULL;

  public static MapGroupTypeMode fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("none".equals(codeString))
      return NONE;
    if ("types".equals(codeString))
      return TYPES;
    if ("type-and-types".equals(codeString))
      return TYPEANDTYPES;
    throw new FHIRException("Unknown MapGroupTypeMode code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case NONE:
      return "none";
    case TYPES:
      return "types";
    case TYPEANDTYPES:
      return "type-and-types";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/map-group-type-mode";
  }

  public String getDefinition() {
    switch (this) {
    case NONE:
      return "This group is not a default group for the types.";
    case TYPES:
      return "This group is a default mapping group for the specified types and for the primary source type.";
    case TYPEANDTYPES:
      return "This group is a default mapping group for the specified types.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case NONE:
      return "Not a Default";
    case TYPES:
      return "Default for Type Combination";
    case TYPEANDTYPES:
      return "Default for type + combination";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}