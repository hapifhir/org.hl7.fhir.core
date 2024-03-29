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

public enum ConformanceStatementKind {

  /**
   * The Conformance instance represents the present capabilities of a specific
   * system instance. This is the kind returned by OPTIONS for a FHIR server
   * end-point.
   */
  INSTANCE,
  /**
   * The Conformance instance represents the capabilities of a system or piece of
   * software, independent of a particular installation.
   */
  CAPABILITY,
  /**
   * The Conformance instance represents a set of requirements for other systems
   * to meet; e.g. as part of an implementation guide or 'request for proposal'.
   */
  REQUIREMENTS,
  /**
   * added to help the parsers
   */
  NULL;

  public static ConformanceStatementKind fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("instance".equals(codeString))
      return INSTANCE;
    if ("capability".equals(codeString))
      return CAPABILITY;
    if ("requirements".equals(codeString))
      return REQUIREMENTS;
    throw new FHIRException("Unknown ConformanceStatementKind code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case INSTANCE:
      return "instance";
    case CAPABILITY:
      return "capability";
    case REQUIREMENTS:
      return "requirements";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/conformance-statement-kind";
  }

  public String getDefinition() {
    switch (this) {
    case INSTANCE:
      return "The Conformance instance represents the present capabilities of a specific system instance.  This is the kind returned by OPTIONS for a FHIR server end-point.";
    case CAPABILITY:
      return "The Conformance instance represents the capabilities of a system or piece of software, independent of a particular installation.";
    case REQUIREMENTS:
      return "The Conformance instance represents a set of requirements for other systems to meet; e.g. as part of an implementation guide or 'request for proposal'.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case INSTANCE:
      return "Instance";
    case CAPABILITY:
      return "Capability";
    case REQUIREMENTS:
      return "Requirements";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}