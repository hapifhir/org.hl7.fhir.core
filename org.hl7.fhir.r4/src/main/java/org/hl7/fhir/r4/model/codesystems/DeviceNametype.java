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

public enum DeviceNametype {

  /**
   * UDI Label name.
   */
  UDILABELNAME,
  /**
   * User Friendly name.
   */
  USERFRIENDLYNAME,
  /**
   * Patient Reported name.
   */
  PATIENTREPORTEDNAME,
  /**
   * Manufacturer name.
   */
  MANUFACTURERNAME,
  /**
   * Model name.
   */
  MODELNAME,
  /**
   * other.
   */
  OTHER,
  /**
   * added to help the parsers
   */
  NULL;

  public static DeviceNametype fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("udi-label-name".equals(codeString))
      return UDILABELNAME;
    if ("user-friendly-name".equals(codeString))
      return USERFRIENDLYNAME;
    if ("patient-reported-name".equals(codeString))
      return PATIENTREPORTEDNAME;
    if ("manufacturer-name".equals(codeString))
      return MANUFACTURERNAME;
    if ("model-name".equals(codeString))
      return MODELNAME;
    if ("other".equals(codeString))
      return OTHER;
    throw new FHIRException("Unknown DeviceNametype code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case UDILABELNAME:
      return "udi-label-name";
    case USERFRIENDLYNAME:
      return "user-friendly-name";
    case PATIENTREPORTEDNAME:
      return "patient-reported-name";
    case MANUFACTURERNAME:
      return "manufacturer-name";
    case MODELNAME:
      return "model-name";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/device-nametype";
  }

  public String getDefinition() {
    switch (this) {
    case UDILABELNAME:
      return "UDI Label name.";
    case USERFRIENDLYNAME:
      return "User Friendly name.";
    case PATIENTREPORTEDNAME:
      return "Patient Reported name.";
    case MANUFACTURERNAME:
      return "Manufacturer name.";
    case MODELNAME:
      return "Model name.";
    case OTHER:
      return "other.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case UDILABELNAME:
      return "UDI Label name";
    case USERFRIENDLYNAME:
      return "User Friendly name";
    case PATIENTREPORTEDNAME:
      return "Patient Reported name";
    case MANUFACTURERNAME:
      return "Manufacturer name";
    case MODELNAME:
      return "Model name";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}