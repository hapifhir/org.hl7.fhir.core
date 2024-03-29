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

public enum ImmunizationRecommendationStatus {

  /**
   * The patient is due for their next vaccination.
   */
  DUE,
  /**
   * The patient is considered overdue for their next vaccination.
   */
  OVERDUE,
  /**
   * The patient is immune to the target disease and further immunization against
   * the disease is not likely to provide benefit.
   */
  IMMUNE,
  /**
   * The patient is contraindicated for futher doses.
   */
  CONTRAINDICATED,
  /**
   * The patient is fully protected and no further doses are recommended.
   */
  COMPLETE,
  /**
   * added to help the parsers
   */
  NULL;

  public static ImmunizationRecommendationStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("due".equals(codeString))
      return DUE;
    if ("overdue".equals(codeString))
      return OVERDUE;
    if ("immune".equals(codeString))
      return IMMUNE;
    if ("contraindicated".equals(codeString))
      return CONTRAINDICATED;
    if ("complete".equals(codeString))
      return COMPLETE;
    throw new FHIRException("Unknown ImmunizationRecommendationStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case DUE:
      return "due";
    case OVERDUE:
      return "overdue";
    case IMMUNE:
      return "immune";
    case CONTRAINDICATED:
      return "contraindicated";
    case COMPLETE:
      return "complete";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status";
  }

  public String getDefinition() {
    switch (this) {
    case DUE:
      return "The patient is due for their next vaccination.";
    case OVERDUE:
      return "The patient is considered overdue for their next vaccination.";
    case IMMUNE:
      return "The patient is immune to the target disease and further immunization against the disease is not likely to provide benefit.";
    case CONTRAINDICATED:
      return "The patient is contraindicated for futher doses.";
    case COMPLETE:
      return "The patient is fully protected and no further doses are recommended.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case DUE:
      return "Due";
    case OVERDUE:
      return "Overdue";
    case IMMUNE:
      return "Immune";
    case CONTRAINDICATED:
      return "Contraindicated";
    case COMPLETE:
      return "Complete";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}