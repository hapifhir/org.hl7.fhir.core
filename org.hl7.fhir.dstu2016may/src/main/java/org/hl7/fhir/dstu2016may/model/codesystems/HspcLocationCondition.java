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

public enum HspcLocationCondition {

        /**
         * The assigned service delivery location is currently dirty, awaiting cleaning.
         */
        _182845, 
        /**
         * The assigned service delivery location has been cleaned, awaiting occupancy.
         */
        _528112801, 
        /**
         * The assigned service delivery location is currently occupied.
         */
        _182843, 
        /**
         * added to help the parsers
         */
        NULL;
        public static HspcLocationCondition fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("182845".equals(codeString))
          return _182845;
        if ("528112801".equals(codeString))
          return _528112801;
        if ("182843".equals(codeString))
          return _182843;
        throw new FHIRException("Unknown HspcLocationCondition code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _182845: return "182845";
            case _528112801: return "528112801";
            case _182843: return "182843";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/hspc-locationCondition";
        }
        public String getDefinition() {
          switch (this) {
            case _182845: return "The assigned service delivery location is currently dirty, awaiting cleaning.";
            case _528112801: return "The assigned service delivery location has been cleaned, awaiting occupancy.";
            case _182843: return "The assigned service delivery location is currently occupied.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _182845: return "Contaminated";
            case _528112801: return "Clean";
            case _182843: return "Occupied";
            case NULL: return null;
            default: return "?";
          }
    }


}