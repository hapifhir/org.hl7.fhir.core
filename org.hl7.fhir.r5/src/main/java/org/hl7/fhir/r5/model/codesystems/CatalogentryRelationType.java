package org.hl7.fhir.r5.model.codesystems;

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

public enum CatalogentryRelationType {

        /**
         * Depending on the context, the item of the related catalog entry may be added by the performer.
         */
        TRIGGERS, 
        /**
         * the related catalog entry supersedes this one when it is not active.
         */
        ISREPLACEDBY, 
        /**
         * The related catalog entry is excluded by this one.
         */
        EXCLUDES, 
        /**
         * The item of the related catalog entry  will be part of the orders containing the current item.
         */
        INCLUDES, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CatalogentryRelationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("triggers".equals(codeString))
          return TRIGGERS;
        if ("is-replaced-by".equals(codeString))
          return ISREPLACEDBY;
        if ("excludes".equals(codeString))
          return EXCLUDES;
        if ("includes".equals(codeString))
          return INCLUDES;
        throw new FHIRException("Unknown CatalogentryRelationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case TRIGGERS: return "triggers";
            case ISREPLACEDBY: return "is-replaced-by";
            case EXCLUDES: return "excludes";
            case INCLUDES: return "includes";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/catalogentry-relation-type";
        }
        public String getDefinition() {
          switch (this) {
            case TRIGGERS: return "Depending on the context, the item of the related catalog entry may be added by the performer.";
            case ISREPLACEDBY: return "the related catalog entry supersedes this one when it is not active.";
            case EXCLUDES: return "The related catalog entry is excluded by this one.";
            case INCLUDES: return "The item of the related catalog entry  will be part of the orders containing the current item.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case TRIGGERS: return "Triggers";
            case ISREPLACEDBY: return "Is replaced by";
            case EXCLUDES: return "Excludes";
            case INCLUDES: return "Includes";
            default: return "?";
          }
    }


}

