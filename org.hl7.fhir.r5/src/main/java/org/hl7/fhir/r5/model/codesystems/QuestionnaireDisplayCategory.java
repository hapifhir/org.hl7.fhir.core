package org.hl7.fhir.r5.model.codesystems;

/*-
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

// Generated on Sun, Jun 30, 2019 16:52-0400 for FHIR v4.1.0


import org.hl7.fhir.exceptions.FHIRException;

public enum QuestionnaireDisplayCategory {

        /**
         * The text provides guidance on how to populate or use a portion of the questionnaire (or the questionnaire as a whole).
         */
        INSTRUCTIONS, 
        /**
         * The text provides guidance on how the information should be or will be handled from a security/confidentiality/access control perspective when completed
         */
        SECURITY, 
        /**
         * The text provides additional guidance on populating the containing item.  Help text isn't necessarily expected to be rendered as part of the form, but may instead be made available through fly-over, pop-up button, link to a "help" page, etc.
         */
        HELP, 
        /**
         * added to help the parsers
         */
        NULL;
        public static QuestionnaireDisplayCategory fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instructions".equals(codeString))
          return INSTRUCTIONS;
        if ("security".equals(codeString))
          return SECURITY;
        if ("help".equals(codeString))
          return HELP;
        throw new FHIRException("Unknown QuestionnaireDisplayCategory code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INSTRUCTIONS: return "instructions";
            case SECURITY: return "security";
            case HELP: return "help";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/questionnaire-display-category";
        }
        public String getDefinition() {
          switch (this) {
            case INSTRUCTIONS: return "The text provides guidance on how to populate or use a portion of the questionnaire (or the questionnaire as a whole).";
            case SECURITY: return "The text provides guidance on how the information should be or will be handled from a security/confidentiality/access control perspective when completed";
            case HELP: return "The text provides additional guidance on populating the containing item.  Help text isn't necessarily expected to be rendered as part of the form, but may instead be made available through fly-over, pop-up button, link to a \"help\" page, etc.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTRUCTIONS: return "Instructions";
            case SECURITY: return "Security";
            case HELP: return "Help";
            default: return "?";
          }
    }


}

