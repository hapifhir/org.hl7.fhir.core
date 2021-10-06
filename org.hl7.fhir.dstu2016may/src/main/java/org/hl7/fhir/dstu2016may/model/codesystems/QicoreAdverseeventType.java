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

public enum QicoreAdverseeventType {

        /**
         * A safety incident, reaction, medication error, or other untoward medical event affecting a patient
         */
        INCIDENT, 
        /**
         * A safety event that almost happened, but was noticed and prevented in time to prevent harm from occurring to the patient
         */
        NEARMISS, 
        /**
         * Any unsafe condition that poses a elevated risk to patient safety
         */
        UNSAFE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static QicoreAdverseeventType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("incident".equals(codeString))
          return INCIDENT;
        if ("near-miss".equals(codeString))
          return NEARMISS;
        if ("unsafe".equals(codeString))
          return UNSAFE;
        throw new FHIRException("Unknown QicoreAdverseeventType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INCIDENT: return "incident";
            case NEARMISS: return "near-miss";
            case UNSAFE: return "unsafe";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/qicore-adverseevent-type";
        }
        public String getDefinition() {
          switch (this) {
            case INCIDENT: return "A safety incident, reaction, medication error, or other untoward medical event affecting a patient";
            case NEARMISS: return "A safety event that almost happened, but was noticed and prevented in time to prevent harm from occurring to the patient";
            case UNSAFE: return "Any unsafe condition that poses a elevated risk to patient safety";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INCIDENT: return "Incident";
            case NEARMISS: return "Near Miss";
            case UNSAFE: return "Unsafe Condition";
            case NULL: return null;
            default: return "?";
          }
    }


}