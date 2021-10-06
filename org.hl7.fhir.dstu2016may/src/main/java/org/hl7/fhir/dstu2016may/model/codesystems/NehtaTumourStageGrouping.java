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

public enum NehtaTumourStageGrouping {

        /**
         * null
         */
        _0, 
        /**
         * null
         */
        I, 
        /**
         * null
         */
        IIA, 
        /**
         * null
         */
        IIB, 
        /**
         * null
         */
        IIC, 
        /**
         * null
         */
        IIIA, 
        /**
         * null
         */
        IIIB, 
        /**
         * null
         */
        IIIC, 
        /**
         * null
         */
        IVA, 
        /**
         * null
         */
        IVB, 
        /**
         * added to help the parsers
         */
        NULL;
        public static NehtaTumourStageGrouping fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("0".equals(codeString))
          return _0;
        if ("i".equals(codeString))
          return I;
        if ("iia".equals(codeString))
          return IIA;
        if ("iib".equals(codeString))
          return IIB;
        if ("iic".equals(codeString))
          return IIC;
        if ("iiia".equals(codeString))
          return IIIA;
        if ("iiib".equals(codeString))
          return IIIB;
        if ("iiic".equals(codeString))
          return IIIC;
        if ("iva".equals(codeString))
          return IVA;
        if ("ivb".equals(codeString))
          return IVB;
        throw new FHIRException("Unknown NehtaTumourStageGrouping code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _0: return "0";
            case I: return "i";
            case IIA: return "iia";
            case IIB: return "iib";
            case IIC: return "iic";
            case IIIA: return "iiia";
            case IIIB: return "iiib";
            case IIIC: return "iiic";
            case IVA: return "iva";
            case IVB: return "ivb";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/tumour-stage-grouping";
        }
        public String getDefinition() {
          switch (this) {
            case _0: return "";
            case I: return "";
            case IIA: return "";
            case IIB: return "";
            case IIC: return "";
            case IIIA: return "";
            case IIIB: return "";
            case IIIC: return "";
            case IVA: return "";
            case IVB: return "";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _0: return "0 Tis N0 M0";
            case I: return "I T1 N0 M0\n  T2 N0 M0";
            case IIA: return "IIA T3 N0 M0";
            case IIB: return "IIB T4a N0 M0";
            case IIC: return "IIC T4b N0 M0";
            case IIIA: return "IIIA T1-T2 N1/N1c M0\n       T1       N2a        M0";
            case IIIB: return "IIIB T3-T4a N1/N1c M0\n       T2-T3   N2a        M0\n       T1-T2   N2b        M0";
            case IIIC: return "IIIC T4a       N2a      M0\n       T3-T4a N2b      M0\n       T4b       N1-N2 M0";
            case IVA: return "IVA Any T Any N M1a";
            case IVB: return "IVB Any T Any N M1b";
            case NULL: return null;
            default: return "?";
          }
    }


}