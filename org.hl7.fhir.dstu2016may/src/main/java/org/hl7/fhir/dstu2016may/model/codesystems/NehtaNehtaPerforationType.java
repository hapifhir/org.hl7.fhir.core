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

public enum NehtaNehtaPerforationType {

        /**
         * The perforation was through tumour prior to surgery
         */
        THROUGHTUMOURPRIORTOSURGERY, 
        /**
         * The perforation was through tumour during surgery mobilisation
         */
        THROUGHTUMOURDURINGSURGERYMOBILISATION, 
        /**
         * The perforation was away from the tumour
         */
        AWAYFROMTUMOUR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static NehtaNehtaPerforationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("through_tumour_prior_to_surgery".equals(codeString))
          return THROUGHTUMOURPRIORTOSURGERY;
        if ("through_tumour_during_surgery_mobilisation".equals(codeString))
          return THROUGHTUMOURDURINGSURGERYMOBILISATION;
        if ("away_from_tumour".equals(codeString))
          return AWAYFROMTUMOUR;
        throw new FHIRException("Unknown NehtaNehtaPerforationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case THROUGHTUMOURPRIORTOSURGERY: return "through_tumour_prior_to_surgery";
            case THROUGHTUMOURDURINGSURGERYMOBILISATION: return "through_tumour_during_surgery_mobilisation";
            case AWAYFROMTUMOUR: return "away_from_tumour";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/nehta-nature-of-perforation";
        }
        public String getDefinition() {
          switch (this) {
            case THROUGHTUMOURPRIORTOSURGERY: return "The perforation was through tumour prior to surgery";
            case THROUGHTUMOURDURINGSURGERYMOBILISATION: return "The perforation was through tumour during surgery mobilisation";
            case AWAYFROMTUMOUR: return "The perforation was away from the tumour";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case THROUGHTUMOURPRIORTOSURGERY: return "Through tumour prior to surgery";
            case THROUGHTUMOURDURINGSURGERYMOBILISATION: return "Through tumour during surgery mobilisation";
            case AWAYFROMTUMOUR: return "Away from tumour";
            case NULL: return null;
            default: return "?";
          }
    }


}