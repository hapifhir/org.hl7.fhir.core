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

public enum ModuleMetadataType {

        /**
         * The resource is a description of a knowledge module
         */
        MODULE, 
        /**
         * The resource is a shareable library of formalized knowledge
         */
        LIBRARY, 
        /**
         * An Event-Condition-Action Rule Artifact
         */
        DECISIONSUPPORTRULE, 
        /**
         * A Documentation Template Artifact
         */
        DOCUMENTATIONTEMPLATE, 
        /**
         * An Order Set Artifact
         */
        ORDERSET, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ModuleMetadataType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("module".equals(codeString))
          return MODULE;
        if ("library".equals(codeString))
          return LIBRARY;
        if ("decision-support-rule".equals(codeString))
          return DECISIONSUPPORTRULE;
        if ("documentation-template".equals(codeString))
          return DOCUMENTATIONTEMPLATE;
        if ("order-set".equals(codeString))
          return ORDERSET;
        throw new FHIRException("Unknown ModuleMetadataType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case MODULE: return "module";
            case LIBRARY: return "library";
            case DECISIONSUPPORTRULE: return "decision-support-rule";
            case DOCUMENTATIONTEMPLATE: return "documentation-template";
            case ORDERSET: return "order-set";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/module-metadata-type";
        }
        public String getDefinition() {
          switch (this) {
            case MODULE: return "The resource is a description of a knowledge module";
            case LIBRARY: return "The resource is a shareable library of formalized knowledge";
            case DECISIONSUPPORTRULE: return "An Event-Condition-Action Rule Artifact";
            case DOCUMENTATIONTEMPLATE: return "A Documentation Template Artifact";
            case ORDERSET: return "An Order Set Artifact";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MODULE: return "Module";
            case LIBRARY: return "Library";
            case DECISIONSUPPORTRULE: return "Decision Support Rule";
            case DOCUMENTATIONTEMPLATE: return "Documentation Template";
            case ORDERSET: return "Order Set";
            case NULL: return null;
            default: return "?";
          }
    }


}