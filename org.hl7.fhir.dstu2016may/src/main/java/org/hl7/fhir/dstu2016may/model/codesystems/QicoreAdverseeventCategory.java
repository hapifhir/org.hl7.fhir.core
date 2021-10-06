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

public enum QicoreAdverseeventCategory {

        /**
         * Blood or Blood Product
         */
        BLOOD, 
        /**
         * Device or Medical/Surgical Supply, including Health Information Technology (HIT)
         */
        DEVICE, 
        /**
         * Fall by patient
         */
        FALL, 
        /**
         * Healthcare-related infection
         */
        INFECTION, 
        /**
         * Medication or Other Substance
         */
        SUBSTANCE, 
        /**
         * Perinatal
         */
        PERINATAL, 
        /**
         * Pressure Ulcer
         */
        ULCER, 
        /**
         * Surgery or Anesthesia (includes invasive procedures)
         */
        SURGERY, 
        /**
         * Venous Thromboembolism
         */
        EMBOLISM, 
        /**
         * Other (please specify)
         */
        OTHER, 
        /**
         * added to help the parsers
         */
        NULL;
        public static QicoreAdverseeventCategory fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("blood".equals(codeString))
          return BLOOD;
        if ("device".equals(codeString))
          return DEVICE;
        if ("fall".equals(codeString))
          return FALL;
        if ("infection".equals(codeString))
          return INFECTION;
        if ("substance".equals(codeString))
          return SUBSTANCE;
        if ("perinatal".equals(codeString))
          return PERINATAL;
        if ("ulcer".equals(codeString))
          return ULCER;
        if ("surgery".equals(codeString))
          return SURGERY;
        if ("embolism".equals(codeString))
          return EMBOLISM;
        if ("other".equals(codeString))
          return OTHER;
        throw new FHIRException("Unknown QicoreAdverseeventCategory code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BLOOD: return "blood";
            case DEVICE: return "device";
            case FALL: return "fall";
            case INFECTION: return "infection";
            case SUBSTANCE: return "substance";
            case PERINATAL: return "perinatal";
            case ULCER: return "ulcer";
            case SURGERY: return "surgery";
            case EMBOLISM: return "embolism";
            case OTHER: return "other";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/qicore-adverseevent-category";
        }
        public String getDefinition() {
          switch (this) {
            case BLOOD: return "Blood or Blood Product";
            case DEVICE: return "Device or Medical/Surgical Supply, including Health Information Technology (HIT)";
            case FALL: return "Fall by patient";
            case INFECTION: return "Healthcare-related infection";
            case SUBSTANCE: return "Medication or Other Substance";
            case PERINATAL: return "Perinatal";
            case ULCER: return "Pressure Ulcer";
            case SURGERY: return "Surgery or Anesthesia (includes invasive procedures)";
            case EMBOLISM: return "Venous Thromboembolism";
            case OTHER: return "Other (please specify)";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BLOOD: return "Blood or Blood Product";
            case DEVICE: return "Device, Materials, or Information Technology";
            case FALL: return "Fall";
            case INFECTION: return "Healthcare-Related Infection";
            case SUBSTANCE: return "Medication or Other Substance";
            case PERINATAL: return "Perinatal";
            case ULCER: return "Pressure Ulcer";
            case SURGERY: return "Surgery or Anesthesia";
            case EMBOLISM: return "Venous Thromboembolism";
            case OTHER: return "Other (please specify)";
            case NULL: return null;
            default: return "?";
          }
    }


}