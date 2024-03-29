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

public enum TestscriptProfileDestinationTypes {

  /**
   * General FHIR server used to respond to operations sent from a FHIR client.
   */
  FHIRSERVER,
  /**
   * A FHIR server acting as a Structured Data Capture Form Manager.
   */
  FHIRSDCFORMMANAGER,
  /**
   * A FHIR server acting as a Structured Data Capture Form Processor.
   */
  FHIRSDCFORMPROCESSOR,
  /**
   * A FHIR server acting as a Structured Data Capture Form Receiver.
   */
  FHIRSDCFORMRECEIVER,
  /**
   * added to help the parsers
   */
  NULL;

  public static TestscriptProfileDestinationTypes fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("FHIR-Server".equals(codeString))
      return FHIRSERVER;
    if ("FHIR-SDC-FormManager".equals(codeString))
      return FHIRSDCFORMMANAGER;
    if ("FHIR-SDC-FormProcessor".equals(codeString))
      return FHIRSDCFORMPROCESSOR;
    if ("FHIR-SDC-FormReceiver".equals(codeString))
      return FHIRSDCFORMRECEIVER;
    throw new FHIRException("Unknown TestscriptProfileDestinationTypes code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case FHIRSERVER:
      return "FHIR-Server";
    case FHIRSDCFORMMANAGER:
      return "FHIR-SDC-FormManager";
    case FHIRSDCFORMPROCESSOR:
      return "FHIR-SDC-FormProcessor";
    case FHIRSDCFORMRECEIVER:
      return "FHIR-SDC-FormReceiver";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://terminology.hl7.org/CodeSystem/testscript-profile-destination-types";
  }

  public String getDefinition() {
    switch (this) {
    case FHIRSERVER:
      return "General FHIR server used to respond to operations sent from a FHIR client.";
    case FHIRSDCFORMMANAGER:
      return "A FHIR server acting as a Structured Data Capture Form Manager.";
    case FHIRSDCFORMPROCESSOR:
      return "A FHIR server acting as a Structured Data Capture Form Processor.";
    case FHIRSDCFORMRECEIVER:
      return "A FHIR server acting as a Structured Data Capture Form Receiver.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case FHIRSERVER:
      return "FHIR Server";
    case FHIRSDCFORMMANAGER:
      return "FHIR SDC FormManager";
    case FHIRSDCFORMPROCESSOR:
      return "FHIR SDC FormProcessor";
    case FHIRSDCFORMRECEIVER:
      return "FHIR SDC FormReceiver";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}