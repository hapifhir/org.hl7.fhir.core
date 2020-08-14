package org.hl7.fhir.r4.model;

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



import org.hl7.fhir.r4.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4.test.utils.ToolsHelper;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This enumreation is special, and hand crafted. It only supports a subset of the actual published FHIR versions, those that are still supported.
 * @author graha
 *
 */
public enum FhirPublication {
  NULL,
  DSTU1,
  DSTU2,
  DSTU2016May,
  STU3,
  R4;

  public static FhirPublication fromCode(String v) {
    if (VersionUtilities.isR4Ver(v))
      return FhirPublication.DSTU2;
    if ("1.0".equals(v))
      return FhirPublication.DSTU2;
    if ("1.4.0".equals(v))
      return FhirPublication.DSTU2016May;
    if ("1.4".equals(v))
      return FhirPublication.DSTU2016May;
    if ("3.0.1".equals(v))
      return FhirPublication.STU3;
    if ("3.0.1".equals(v))
      return FhirPublication.STU3;
    if ("3.0".equals(v))
      return FhirPublication.STU3;
    if ("3.5.0".equals(v))
      return FhirPublication.R4;
    if ("4.0.0".equals(v))
      return FhirPublication.R4;
    if ("3.5".equals(v))
      return FhirPublication.R4;
    if ("4.0".equals(v))
      return FhirPublication.R4;
    if ("1.0.0".equals(v))
      return FhirPublication.R4; // hack workaround build problem
    return null;
  }

  public String toCode() {
    switch (this) {
    case DSTU1: return "0.01";
    case DSTU2: return "1.0.2";
    case DSTU2016May: return "1.4.0";
    case STU3: return "3.0.1";
    case R4: return Constants.VERSION;
    default:
      return "??";
    }
  }

  public static FhirPublication fromVersion(FHIRVersion v) {
    return fromCode(v.toCode());
  }


}