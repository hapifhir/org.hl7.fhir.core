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

// Generated on Mon, Mar 21, 2016 12:03+1100 for FHIR v1.3.0

import org.hl7.fhir.exceptions.FHIRException;

public enum GuidanceResponseActionType {

  /**
   * The action is to create a new resource
   */
  CREATE,
  /**
   * The action is to update an existing resource
   */
  UPDATE,
  /**
   * The action is to remove an existing resource
   */
  REMOVE,
  /**
   * The action is to fire a specific event
   */
  FIREEVENT,
  /**
   * added to help the parsers
   */
  NULL;

  public static GuidanceResponseActionType fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("create".equals(codeString))
      return CREATE;
    if ("update".equals(codeString))
      return UPDATE;
    if ("remove".equals(codeString))
      return REMOVE;
    if ("fire-event".equals(codeString))
      return FIREEVENT;
    throw new FHIRException("Unknown GuidanceResponseActionType code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case CREATE:
      return "create";
    case UPDATE:
      return "update";
    case REMOVE:
      return "remove";
    case FIREEVENT:
      return "fire-event";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/guidance-response-action-type";
  }

  public String getDefinition() {
    switch (this) {
    case CREATE:
      return "The action is to create a new resource";
    case UPDATE:
      return "The action is to update an existing resource";
    case REMOVE:
      return "The action is to remove an existing resource";
    case FIREEVENT:
      return "The action is to fire a specific event";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case CREATE:
      return "Create";
    case UPDATE:
      return "Update";
    case REMOVE:
      return "Remove";
    case FIREEVENT:
      return "Fire Event";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}