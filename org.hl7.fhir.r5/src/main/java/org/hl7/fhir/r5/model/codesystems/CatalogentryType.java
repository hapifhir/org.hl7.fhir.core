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

public enum CatalogentryType {

        /**
         * null
         */
        ACTIVITYDEFINITION, 
        /**
         * null
         */
        PLANDEFINITION, 
        /**
         * null
         */
        SPECIMENDEFINITION, 
        /**
         * null
         */
        OBSERVATIONDEFINITION, 
        /**
         * null
         */
        DEVICEDEFINITION, 
        /**
         * null
         */
        ORGANIZATION, 
        /**
         * null
         */
        PRACTITIONER, 
        /**
         * null
         */
        PRACTITIONERROLE, 
        /**
         * null
         */
        HEALTHCARESERVICE, 
        /**
         * null
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * null
         */
        MEDICATION, 
        /**
         * null
         */
        SUBSTANCE, 
        /**
         * null
         */
        LOCATION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CatalogentryType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("Location".equals(codeString))
          return LOCATION;
        throw new FHIRException("Unknown CatalogentryType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case PLANDEFINITION: return "PlanDefinition";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case ORGANIZATION: return "Organization";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case HEALTHCARESERVICE: return "HealthcareService";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATION: return "Medication";
            case SUBSTANCE: return "Substance";
            case LOCATION: return "Location";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/catalogentry-type";
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVITYDEFINITION: return "";
            case PLANDEFINITION: return "";
            case SPECIMENDEFINITION: return "";
            case OBSERVATIONDEFINITION: return "";
            case DEVICEDEFINITION: return "";
            case ORGANIZATION: return "";
            case PRACTITIONER: return "";
            case PRACTITIONERROLE: return "";
            case HEALTHCARESERVICE: return "";
            case MEDICATIONKNOWLEDGE: return "";
            case MEDICATION: return "";
            case SUBSTANCE: return "";
            case LOCATION: return "";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case PLANDEFINITION: return "PlanDefinition";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case ORGANIZATION: return "Organization";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case HEALTHCARESERVICE: return "HealthcareService";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATION: return "Medication";
            case SUBSTANCE: return "Substance";
            case LOCATION: return "Location";
            default: return "?";
          }
    }


}

