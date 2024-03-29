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

public enum EncounterAdmitSource {

  /**
   * null
   */
  HOSPTRANS,
  /**
   * null
   */
  EMD,
  /**
   * null
   */
  OUTP,
  /**
   * null
   */
  BORN,
  /**
   * null
   */
  GP,
  /**
   * null
   */
  MP,
  /**
   * null
   */
  NURSING,
  /**
   * null
   */
  PSYCH,
  /**
   * null
   */
  REHAB,
  /**
   * null
   */
  OTHER,
  /**
   * added to help the parsers
   */
  NULL;

  public static EncounterAdmitSource fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("hosp-trans".equals(codeString))
      return HOSPTRANS;
    if ("emd".equals(codeString))
      return EMD;
    if ("outp".equals(codeString))
      return OUTP;
    if ("born".equals(codeString))
      return BORN;
    if ("gp".equals(codeString))
      return GP;
    if ("mp".equals(codeString))
      return MP;
    if ("nursing".equals(codeString))
      return NURSING;
    if ("psych".equals(codeString))
      return PSYCH;
    if ("rehab".equals(codeString))
      return REHAB;
    if ("other".equals(codeString))
      return OTHER;
    throw new FHIRException("Unknown EncounterAdmitSource code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case HOSPTRANS:
      return "hosp-trans";
    case EMD:
      return "emd";
    case OUTP:
      return "outp";
    case BORN:
      return "born";
    case GP:
      return "gp";
    case MP:
      return "mp";
    case NURSING:
      return "nursing";
    case PSYCH:
      return "psych";
    case REHAB:
      return "rehab";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/admit-source";
  }

  public String getDefinition() {
    switch (this) {
    case HOSPTRANS:
      return "";
    case EMD:
      return "";
    case OUTP:
      return "";
    case BORN:
      return "";
    case GP:
      return "";
    case MP:
      return "";
    case NURSING:
      return "";
    case PSYCH:
      return "";
    case REHAB:
      return "";
    case OTHER:
      return "";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case HOSPTRANS:
      return "Transferred from other hospital";
    case EMD:
      return "From accident/emergency department";
    case OUTP:
      return "From outpatient department";
    case BORN:
      return "Born in hospital";
    case GP:
      return "General Practitioner referral";
    case MP:
      return "Medical Practitioner/physician referral";
    case NURSING:
      return "From nursing home";
    case PSYCH:
      return "From psychiatric hospital";
    case REHAB:
      return "From rehabilitation facility";
    case OTHER:
      return "Other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}