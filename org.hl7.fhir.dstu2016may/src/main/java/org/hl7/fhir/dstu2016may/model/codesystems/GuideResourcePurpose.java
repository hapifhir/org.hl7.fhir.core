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

// Generated on Tue, Mar 22, 2016 08:00+1100 for FHIR v1.3.0


import org.hl7.fhir.exceptions.FHIRException;

public enum GuideResourcePurpose {

        /**
         * The resource is intended as an example.
         */
        EXAMPLE, 
        /**
         * The resource defines a value set or concept map used in the implementation guide.
         */
        TERMINOLOGY, 
        /**
         * The resource defines a profile (StructureDefinition) that is used in the implementation guide.
         */
        PROFILE, 
        /**
         * The resource defines an extension (StructureDefinition) that is used in the implementation guide.
         */
        EXTENSION, 
        /**
         * The resource contains a dictionary that is part of the implementation guide.
         */
        DICTIONARY, 
        /**
         * The resource defines a logical model (in a StructureDefinition) that is used in the implementation guide.
         */
        LOGICAL, 
        /**
         * added to help the parsers
         */
        NULL;
        public static GuideResourcePurpose fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("example".equals(codeString))
          return EXAMPLE;
        if ("terminology".equals(codeString))
          return TERMINOLOGY;
        if ("profile".equals(codeString))
          return PROFILE;
        if ("extension".equals(codeString))
          return EXTENSION;
        if ("dictionary".equals(codeString))
          return DICTIONARY;
        if ("logical".equals(codeString))
          return LOGICAL;
        throw new FHIRException("Unknown GuideResourcePurpose code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EXAMPLE: return "example";
            case TERMINOLOGY: return "terminology";
            case PROFILE: return "profile";
            case EXTENSION: return "extension";
            case DICTIONARY: return "dictionary";
            case LOGICAL: return "logical";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/guide-resource-purpose";
        }
        public String getDefinition() {
          switch (this) {
            case EXAMPLE: return "The resource is intended as an example.";
            case TERMINOLOGY: return "The resource defines a value set or concept map used in the implementation guide.";
            case PROFILE: return "The resource defines a profile (StructureDefinition) that is used in the implementation guide.";
            case EXTENSION: return "The resource defines an extension (StructureDefinition) that is used in the implementation guide.";
            case DICTIONARY: return "The resource contains a dictionary that is part of the implementation guide.";
            case LOGICAL: return "The resource defines a logical model (in a StructureDefinition) that is used in the implementation guide.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EXAMPLE: return "Example";
            case TERMINOLOGY: return "Terminology";
            case PROFILE: return "Profile";
            case EXTENSION: return "Extension";
            case DICTIONARY: return "Dictionary";
            case LOGICAL: return "Logical Model";
            case NULL: return null;
            default: return "?";
          }
    }


}