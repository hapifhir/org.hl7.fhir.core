package org.hl7.fhir.utilities;

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



import org.hl7.fhir.exceptions.FHIRException;

public enum StandardsStatus {

  EXTERNAL, INFORMATIVE, DRAFT, TRIAL_USE, DEPRECATED, NORMATIVE;

  public String toDisplay() {
    switch (this) {
    case DRAFT : 
      return "Draft";  
    case NORMATIVE  : 
      return "Normative";
    case TRIAL_USE : 
      return "Trial Use";  
    case INFORMATIVE:
      return "Informative";
    case EXTERNAL:
      return "External";
    case DEPRECATED: 
      return "Deprecated";
    }
    return "?";
  }

  public String toCode() {
    switch (this) {
    case DRAFT : 
      return "draft";  
    case NORMATIVE  : 
      return "normative";
    case TRIAL_USE : 
      return "trial-use";  
    case INFORMATIVE:
      return "informative";
    case DEPRECATED: 
    return "deprecated";
    case EXTERNAL:
      return "external";
    }
    return "?";
  }


  public static StandardsStatus fromCode(String value) throws FHIRException {
    if (Utilities.noString(value))
      return null;
    if (value.equalsIgnoreCase("draft"))
      return DRAFT;
    if (value.equalsIgnoreCase("NORMATIVE")) 
      return NORMATIVE;
    if (value.equalsIgnoreCase("TRIAL_USE")) 
      return TRIAL_USE;  
    if (value.equalsIgnoreCase("TRIAL-USE")) 
      return TRIAL_USE;  
    if (value.equalsIgnoreCase("TRIAL USE")) 
      return TRIAL_USE;  
    if (value.equalsIgnoreCase("INFORMATIVE"))
      return INFORMATIVE;
    if (value.equalsIgnoreCase("EXTERNAL"))
      return EXTERNAL;
    if (value.equalsIgnoreCase("DEPRECATED"))
      return DEPRECATED;
    throw new FHIRException("Incorrect Standards Status '"+value+"'");
  }

  public String getAbbrev() {
    switch (this) {
    case DRAFT : 
      return "D";  
    case NORMATIVE  : 
      return "N";
    case TRIAL_USE : 
      return "TU";  
    case INFORMATIVE:
      return "I";
    case DEPRECATED: 
      return "XD";
    case EXTERNAL:
      return "X";
    }
    return "?";
  }

  public String getColor() {
    switch (this) {
    case DRAFT : 
      return "#efefef";  
    case NORMATIVE  : 
      return "#e6ffe6";
    case TRIAL_USE : 
      return "#fff5e6";  
    case INFORMATIVE:
      return "#ffffe6";
    case DEPRECATED: 
      return "#ffcccc";
    case EXTERNAL:
      return "#e6ffff";
    }
    return "?";
  }

  public String getColorSvg() {
    switch (this) {
    case DRAFT : 
      return "#f6f6f6";  
    case NORMATIVE  : 
      return "#ecffec";
    case TRIAL_USE : 
      return "#fff9ec";  
    case INFORMATIVE:
      return "#ffffec";
    case DEPRECATED: 
      return "#ffcccc";
    case EXTERNAL:
      return "#ecffff";
    }
    return "?";
  }

  public boolean canDependOn(StandardsStatus tgtSS) {
    if (this == DRAFT || this == INFORMATIVE || this == EXTERNAL)
      return true;
    if (this == TRIAL_USE)
      return (tgtSS != DRAFT);
    if (this == NORMATIVE)
      return (tgtSS == NORMATIVE || tgtSS == EXTERNAL );
    if (this == DEPRECATED)
      return (tgtSS == DEPRECATED );
    return false;
  }

  public boolean isLowerThan(StandardsStatus status) {
    return this.compareTo(status) <0;
  }
}