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

public enum HspcVitalsignassociatedprecond {

        /**
         * Occurred after the cardioversion procedure
         */
        _1942, 
        /**
         * Occurred before the cardioversion procedure
         */
        _1966, 
        /**
         * Occurred during the cardioversion procedure
         */
        _2029, 
        /**
         * Occurred at birth
         */
        _219101, 
        /**
         * added to help the parsers
         */
        NULL;
        public static HspcVitalsignassociatedprecond fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("1942".equals(codeString))
          return _1942;
        if ("1966".equals(codeString))
          return _1966;
        if ("2029".equals(codeString))
          return _2029;
        if ("219101".equals(codeString))
          return _219101;
        throw new FHIRException("Unknown HspcVitalsignassociatedprecond code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _1942: return "1942";
            case _1966: return "1966";
            case _2029: return "2029";
            case _219101: return "219101";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/hspc-vitalsignassociatedprecond";
        }
        public String getDefinition() {
          switch (this) {
            case _1942: return "Occurred after the cardioversion procedure";
            case _1966: return "Occurred before the cardioversion procedure";
            case _2029: return "Occurred during the cardioversion procedure";
            case _219101: return "Occurred at birth";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _1942: return "After cardioversion";
            case _1966: return "Before cardioversion";
            case _2029: return "During cardioversion";
            case _219101: return "At birth";
            case NULL: return null;
            default: return "?";
          }
    }


}