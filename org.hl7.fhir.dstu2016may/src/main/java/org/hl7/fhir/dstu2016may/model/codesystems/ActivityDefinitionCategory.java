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

public enum ActivityDefinitionCategory {

  /**
   * To consume food of a specified nature
   */
  DIET,
  /**
   * To consume/receive a drug, vaccine or other product
   */
  DRUG,
  /**
   * To meet or communicate with the patient (in-patient, out-patient, phone call,
   * etc.)
   */
  ENCOUNTER,
  /**
   * To capture information about a patient (vitals, labs, diagnostic images,
   * etc.)
   */
  OBSERVATION,
  /**
   * To modify the patient in some way (surgery, physiotherapy, education,
   * counseling, etc.)
   */
  PROCEDURE,
  /**
   * To provide something to the patient (medication, medical supply, etc.)
   */
  SUPPLY,
  /**
   * Some other form of action
   */
  OTHER,
  /**
   * added to help the parsers
   */
  NULL;

  public static ActivityDefinitionCategory fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("diet".equals(codeString))
      return DIET;
    if ("drug".equals(codeString))
      return DRUG;
    if ("encounter".equals(codeString))
      return ENCOUNTER;
    if ("observation".equals(codeString))
      return OBSERVATION;
    if ("procedure".equals(codeString))
      return PROCEDURE;
    if ("supply".equals(codeString))
      return SUPPLY;
    if ("other".equals(codeString))
      return OTHER;
    throw new FHIRException("Unknown ActivityDefinitionCategory code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case DIET:
      return "diet";
    case DRUG:
      return "drug";
    case ENCOUNTER:
      return "encounter";
    case OBSERVATION:
      return "observation";
    case PROCEDURE:
      return "procedure";
    case SUPPLY:
      return "supply";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/activity-definition-category";
  }

  public String getDefinition() {
    switch (this) {
    case DIET:
      return "To consume food of a specified nature";
    case DRUG:
      return "To consume/receive a drug, vaccine or other product";
    case ENCOUNTER:
      return "To meet or communicate with the patient (in-patient, out-patient, phone call, etc.)";
    case OBSERVATION:
      return "To capture information about a patient (vitals, labs, diagnostic images, etc.)";
    case PROCEDURE:
      return "To modify the patient in some way (surgery, physiotherapy, education, counseling, etc.)";
    case SUPPLY:
      return "To provide something to the patient (medication, medical supply, etc.)";
    case OTHER:
      return "Some other form of action";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case DIET:
      return "Diet";
    case DRUG:
      return "Drug";
    case ENCOUNTER:
      return "Encounter";
    case OBSERVATION:
      return "Observation";
    case PROCEDURE:
      return "Procedure";
    case SUPPLY:
      return "Supply";
    case OTHER:
      return "Other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}