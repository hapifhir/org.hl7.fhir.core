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

public enum HspcPractitionerPrivilege {

        /**
         * The provider is allowed to practice and admit
         */
        E631014153084062A1760A03197FB489, 
        /**
         * The provider is not allowed to practice or admit
         */
        _0A9A9B654F9F42FAADE80D2592BDE220, 
        /**
         * The provider is not allowed to practice or admit at this time
         */
        _77F1B390A4334708AD3B070E358868F4, 
        /**
         * The provider is allowed to practice only, cannot admit patients
         */
        _5750552B25D44EB886F98233756449F0, 
        /**
         * The provider is allowed to practice and admit for a limited time
         */
        _45FC874FD78743F2A2AA5954446B163D, 
        /**
         * added to help the parsers
         */
        NULL;
        public static HspcPractitionerPrivilege fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("e6310141-5308-4062-a176-0a03197fb489".equals(codeString))
          return E631014153084062A1760A03197FB489;
        if ("0a9a9b65-4f9f-42fa-ade8-0d2592bde220".equals(codeString))
          return _0A9A9B654F9F42FAADE80D2592BDE220;
        if ("77f1b390-a433-4708-ad3b-070e358868f4".equals(codeString))
          return _77F1B390A4334708AD3B070E358868F4;
        if ("5750552b-25d4-4eb8-86f9-8233756449f0".equals(codeString))
          return _5750552B25D44EB886F98233756449F0;
        if ("45fc874f-d787-43f2-a2aa-5954446b163d".equals(codeString))
          return _45FC874FD78743F2A2AA5954446B163D;
        throw new FHIRException("Unknown HspcPractitionerPrivilege code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case E631014153084062A1760A03197FB489: return "e6310141-5308-4062-a176-0a03197fb489";
            case _0A9A9B654F9F42FAADE80D2592BDE220: return "0a9a9b65-4f9f-42fa-ade8-0d2592bde220";
            case _77F1B390A4334708AD3B070E358868F4: return "77f1b390-a433-4708-ad3b-070e358868f4";
            case _5750552B25D44EB886F98233756449F0: return "5750552b-25d4-4eb8-86f9-8233756449f0";
            case _45FC874FD78743F2A2AA5954446B163D: return "45fc874f-d787-43f2-a2aa-5954446b163d";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/practitioner-hspc-privilege";
        }
        public String getDefinition() {
          switch (this) {
            case E631014153084062A1760A03197FB489: return "The provider is allowed to practice and admit";
            case _0A9A9B654F9F42FAADE80D2592BDE220: return "The provider is not allowed to practice or admit";
            case _77F1B390A4334708AD3B070E358868F4: return "The provider is not allowed to practice or admit at this time";
            case _5750552B25D44EB886F98233756449F0: return "The provider is allowed to practice only, cannot admit patients";
            case _45FC874FD78743F2A2AA5954446B163D: return "The provider is allowed to practice and admit for a limited time";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case E631014153084062A1760A03197FB489: return "Full Privilege";
            case _0A9A9B654F9F42FAADE80D2592BDE220: return "No Privileges to practice or admit";
            case _77F1B390A4334708AD3B070E358868F4: return "Privileges Suspended";
            case _5750552B25D44EB886F98233756449F0: return "Practice Privileges Only (not allowed to admit)";
            case _45FC874FD78743F2A2AA5954446B163D: return "Temporary Privileges";
            case NULL: return null;
            default: return "?";
          }
    }


}