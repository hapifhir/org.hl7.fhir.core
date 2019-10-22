package org.hl7.fhir.r5.model.codesystems;

/*
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Oct 17, 2019 09:42+1100 for FHIR v4.1.0


import org.hl7.fhir.exceptions.FHIRException;

public enum ConceptMapRelationship {

        /**
         * The concepts are related to each other, but the exact relationship is not known.
         */
        RELATEDTO, 
        /**
         * The definitions of the concepts mean the same thing.
         */
        EQUIVALENT, 
        /**
         * The target concept is broader in meaning than the source concept.
         */
        BROADER, 
        /**
         * The target concept is narrower in meaning than the source concept.
         */
        NARROWER, 
        /**
         * This is an explicit assertion that the target concept is not related to the source concept.
         */
        NOTRELATEDTO, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ConceptMapRelationship fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("related-to".equals(codeString))
          return RELATEDTO;
        if ("equivalent".equals(codeString))
          return EQUIVALENT;
        if ("broader".equals(codeString))
          return BROADER;
        if ("narrower".equals(codeString))
          return NARROWER;
        if ("not-related-to".equals(codeString))
          return NOTRELATEDTO;
        throw new FHIRException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RELATEDTO: return "related-to";
            case EQUIVALENT: return "equivalent";
            case BROADER: return "broader";
            case NARROWER: return "narrower";
            case NOTRELATEDTO: return "not-related-to";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/concept-map-relationship";
        }
        public String getDefinition() {
          switch (this) {
            case RELATEDTO: return "The concepts are related to each other, but the exact relationship is not known.";
            case EQUIVALENT: return "The definitions of the concepts mean the same thing.";
            case BROADER: return "The target concept is broader in meaning than the source concept.";
            case NARROWER: return "The target concept is narrower in meaning than the source concept.";
            case NOTRELATEDTO: return "This is an explicit assertion that the target concept is not related to the source concept.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RELATEDTO: return "Related To";
            case EQUIVALENT: return "Equivalent";
            case BROADER: return "Broader";
            case NARROWER: return "Narrower";
            case NOTRELATEDTO: return "Not Related To";
            default: return "?";
          }
    }


}

