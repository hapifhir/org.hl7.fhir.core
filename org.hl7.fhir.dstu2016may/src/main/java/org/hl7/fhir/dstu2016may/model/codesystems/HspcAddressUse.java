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

public enum HspcAddressUse {

        /**
         * null
         */
        BAD, 
        /**
         * null
         */
        PHYS, 
        /**
         * null
         */
        PST, 
        /**
         * null
         */
        HP, 
        /**
         * null
         */
        PUB, 
        /**
         * null
         */
        TMP, 
        /**
         * null
         */
        HV, 
        /**
         * null
         */
        WP, 
        /**
         * null
         */
        H, 
        /**
         * null
         */
        DIR, 
        /**
         * null
         */
        CONF, 
        /**
         * added to help the parsers
         */
        NULL;
        public static HspcAddressUse fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("BAD".equals(codeString))
          return BAD;
        if ("PHYS".equals(codeString))
          return PHYS;
        if ("PST".equals(codeString))
          return PST;
        if ("HP".equals(codeString))
          return HP;
        if ("PUB".equals(codeString))
          return PUB;
        if ("TMP".equals(codeString))
          return TMP;
        if ("HV".equals(codeString))
          return HV;
        if ("WP".equals(codeString))
          return WP;
        if ("H".equals(codeString))
          return H;
        if ("DIR".equals(codeString))
          return DIR;
        if ("CONF".equals(codeString))
          return CONF;
        throw new FHIRException("Unknown HspcAddressUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BAD: return "BAD";
            case PHYS: return "PHYS";
            case PST: return "PST";
            case HP: return "HP";
            case PUB: return "PUB";
            case TMP: return "TMP";
            case HV: return "HV";
            case WP: return "WP";
            case H: return "H";
            case DIR: return "DIR";
            case CONF: return "CONF";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/addressUse";
        }
        public String getDefinition() {
          switch (this) {
            case BAD: return "";
            case PHYS: return "";
            case PST: return "";
            case HP: return "";
            case PUB: return "";
            case TMP: return "";
            case HV: return "";
            case WP: return "";
            case H: return "";
            case DIR: return "";
            case CONF: return "";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BAD: return "Bad address";
            case PHYS: return "Physical visit address";
            case PST: return "Postal address";
            case HP: return "Primary home";
            case PUB: return "Public";
            case TMP: return "Temporary address";
            case HV: return "Vacation home";
            case WP: return "Work place";
            case H: return "Home address";
            case DIR: return "Direct address";
            case CONF: return "Conficential address";
            case NULL: return null;
            default: return "?";
          }
    }


}