package org.hl7.fhir.r5.model;




/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Catalog entries are wrappers that contextualize items included in a catalog.
 */
@ResourceDef(name="CatalogEntry", profile="http://hl7.org/fhir/StructureDefinition/CatalogEntry")
public class CatalogEntry extends DomainResource {

    public enum CatalogEntryRelationType {
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
         * added to help the parsers with the generic types
         */
        NULL;
        public static CatalogEntryRelationType fromCode(String codeString) throws FHIRException {
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
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CatalogEntryRelationType code '"+codeString+"'");
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
          switch (this) {
            case TRIGGERS: return "http://hl7.org/fhir/catalogentry-relation-type";
            case ISREPLACEDBY: return "http://hl7.org/fhir/catalogentry-relation-type";
            case EXCLUDES: return "http://hl7.org/fhir/catalogentry-relation-type";
            case INCLUDES: return "http://hl7.org/fhir/catalogentry-relation-type";
            default: return "?";
          }
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

  public static class CatalogEntryRelationTypeEnumFactory implements EnumFactory<CatalogEntryRelationType> {
    public CatalogEntryRelationType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("triggers".equals(codeString))
          return CatalogEntryRelationType.TRIGGERS;
        if ("is-replaced-by".equals(codeString))
          return CatalogEntryRelationType.ISREPLACEDBY;
        if ("excludes".equals(codeString))
          return CatalogEntryRelationType.EXCLUDES;
        if ("includes".equals(codeString))
          return CatalogEntryRelationType.INCLUDES;
        throw new IllegalArgumentException("Unknown CatalogEntryRelationType code '"+codeString+"'");
        }
        public Enumeration<CatalogEntryRelationType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CatalogEntryRelationType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("triggers".equals(codeString))
          return new Enumeration<CatalogEntryRelationType>(this, CatalogEntryRelationType.TRIGGERS);
        if ("is-replaced-by".equals(codeString))
          return new Enumeration<CatalogEntryRelationType>(this, CatalogEntryRelationType.ISREPLACEDBY);
        if ("excludes".equals(codeString))
          return new Enumeration<CatalogEntryRelationType>(this, CatalogEntryRelationType.EXCLUDES);
        if ("includes".equals(codeString))
          return new Enumeration<CatalogEntryRelationType>(this, CatalogEntryRelationType.INCLUDES);
        throw new FHIRException("Unknown CatalogEntryRelationType code '"+codeString+"'");
        }
    public String toCode(CatalogEntryRelationType code) {
      if (code == CatalogEntryRelationType.TRIGGERS)
        return "triggers";
      if (code == CatalogEntryRelationType.ISREPLACEDBY)
        return "is-replaced-by";
      if (code == CatalogEntryRelationType.EXCLUDES)
        return "excludes";
      if (code == CatalogEntryRelationType.INCLUDES)
        return "includes";
      return "?";
      }
    public String toSystem(CatalogEntryRelationType code) {
      return code.getSystem();
      }
    }

    public enum CatalogEntryStatus {
        /**
         * 
         */
        DRAFT, 
        /**
         * 
         */
        ACTIVE, 
        /**
         * 
         */
        RETIRED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CatalogEntryStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("retired".equals(codeString))
          return RETIRED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CatalogEntryStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case RETIRED: return "retired";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/catalogentry-status";
            case ACTIVE: return "http://hl7.org/fhir/catalogentry-status";
            case RETIRED: return "http://hl7.org/fhir/catalogentry-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "";
            case ACTIVE: return "";
            case RETIRED: return "";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case RETIRED: return "Retired";
            default: return "?";
          }
        }
    }

  public static class CatalogEntryStatusEnumFactory implements EnumFactory<CatalogEntryStatus> {
    public CatalogEntryStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return CatalogEntryStatus.DRAFT;
        if ("active".equals(codeString))
          return CatalogEntryStatus.ACTIVE;
        if ("retired".equals(codeString))
          return CatalogEntryStatus.RETIRED;
        throw new IllegalArgumentException("Unknown CatalogEntryStatus code '"+codeString+"'");
        }
        public Enumeration<CatalogEntryStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CatalogEntryStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<CatalogEntryStatus>(this, CatalogEntryStatus.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<CatalogEntryStatus>(this, CatalogEntryStatus.ACTIVE);
        if ("retired".equals(codeString))
          return new Enumeration<CatalogEntryStatus>(this, CatalogEntryStatus.RETIRED);
        throw new FHIRException("Unknown CatalogEntryStatus code '"+codeString+"'");
        }
    public String toCode(CatalogEntryStatus code) {
      if (code == CatalogEntryStatus.DRAFT)
        return "draft";
      if (code == CatalogEntryStatus.ACTIVE)
        return "active";
      if (code == CatalogEntryStatus.RETIRED)
        return "retired";
      return "?";
      }
    public String toSystem(CatalogEntryStatus code) {
      return code.getSystem();
      }
    }

    public enum CatalogEntryType {
        /**
         * 
         */
        ACTIVITYDEFINITION, 
        /**
         * 
         */
        PLANDEFINITION, 
        /**
         * 
         */
        SPECIMENDEFINITION, 
        /**
         * 
         */
        OBSERVATIONDEFINITION, 
        /**
         * 
         */
        DEVICEDEFINITION, 
        /**
         * 
         */
        ORGANIZATION, 
        /**
         * 
         */
        PRACTITIONER, 
        /**
         * 
         */
        PRACTITIONERROLE, 
        /**
         * 
         */
        HEALTHCARESERVICE, 
        /**
         * 
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * 
         */
        MEDICATION, 
        /**
         * 
         */
        SUBSTANCE, 
        /**
         * 
         */
        LOCATION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CatalogEntryType fromCode(String codeString) throws FHIRException {
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
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CatalogEntryType code '"+codeString+"'");
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
          switch (this) {
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/catalogentry-type";
            case PLANDEFINITION: return "http://hl7.org/fhir/catalogentry-type";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/catalogentry-type";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/catalogentry-type";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/catalogentry-type";
            case ORGANIZATION: return "http://hl7.org/fhir/catalogentry-type";
            case PRACTITIONER: return "http://hl7.org/fhir/catalogentry-type";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/catalogentry-type";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/catalogentry-type";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/catalogentry-type";
            case MEDICATION: return "http://hl7.org/fhir/catalogentry-type";
            case SUBSTANCE: return "http://hl7.org/fhir/catalogentry-type";
            case LOCATION: return "http://hl7.org/fhir/catalogentry-type";
            default: return "?";
          }
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

  public static class CatalogEntryTypeEnumFactory implements EnumFactory<CatalogEntryType> {
    public CatalogEntryType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ActivityDefinition".equals(codeString))
          return CatalogEntryType.ACTIVITYDEFINITION;
        if ("PlanDefinition".equals(codeString))
          return CatalogEntryType.PLANDEFINITION;
        if ("SpecimenDefinition".equals(codeString))
          return CatalogEntryType.SPECIMENDEFINITION;
        if ("ObservationDefinition".equals(codeString))
          return CatalogEntryType.OBSERVATIONDEFINITION;
        if ("DeviceDefinition".equals(codeString))
          return CatalogEntryType.DEVICEDEFINITION;
        if ("Organization".equals(codeString))
          return CatalogEntryType.ORGANIZATION;
        if ("Practitioner".equals(codeString))
          return CatalogEntryType.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return CatalogEntryType.PRACTITIONERROLE;
        if ("HealthcareService".equals(codeString))
          return CatalogEntryType.HEALTHCARESERVICE;
        if ("MedicationKnowledge".equals(codeString))
          return CatalogEntryType.MEDICATIONKNOWLEDGE;
        if ("Medication".equals(codeString))
          return CatalogEntryType.MEDICATION;
        if ("Substance".equals(codeString))
          return CatalogEntryType.SUBSTANCE;
        if ("Location".equals(codeString))
          return CatalogEntryType.LOCATION;
        throw new IllegalArgumentException("Unknown CatalogEntryType code '"+codeString+"'");
        }
        public Enumeration<CatalogEntryType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CatalogEntryType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.ACTIVITYDEFINITION);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.PLANDEFINITION);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.SPECIMENDEFINITION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.OBSERVATIONDEFINITION);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.DEVICEDEFINITION);
        if ("Organization".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.ORGANIZATION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.PRACTITIONERROLE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.HEALTHCARESERVICE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.MEDICATIONKNOWLEDGE);
        if ("Medication".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.MEDICATION);
        if ("Substance".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.SUBSTANCE);
        if ("Location".equals(codeString))
          return new Enumeration<CatalogEntryType>(this, CatalogEntryType.LOCATION);
        throw new FHIRException("Unknown CatalogEntryType code '"+codeString+"'");
        }
    public String toCode(CatalogEntryType code) {
      if (code == CatalogEntryType.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == CatalogEntryType.PLANDEFINITION)
        return "PlanDefinition";
      if (code == CatalogEntryType.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == CatalogEntryType.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == CatalogEntryType.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == CatalogEntryType.ORGANIZATION)
        return "Organization";
      if (code == CatalogEntryType.PRACTITIONER)
        return "Practitioner";
      if (code == CatalogEntryType.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == CatalogEntryType.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == CatalogEntryType.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == CatalogEntryType.MEDICATION)
        return "Medication";
      if (code == CatalogEntryType.SUBSTANCE)
        return "Substance";
      if (code == CatalogEntryType.LOCATION)
        return "Location";
      return "?";
      }
    public String toSystem(CatalogEntryType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CatalogEntryRelatedEntryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship to the related entry.
         */
        @Child(name = "relationship", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="triggers | is-replaced-by | excludes | includes", formalDefinition="The type of relationship to the related entry." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/catalogentry-relation-type")
        protected Enumeration<CatalogEntryRelationType> relationship;

        /**
         * The reference to the related entry.
         */
        @Child(name = "target", type = {CatalogEntry.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The reference to the related entry", formalDefinition="The reference to the related entry." )
        protected Reference target;

        private static final long serialVersionUID = -1175541480L;

    /**
     * Constructor
     */
      public CatalogEntryRelatedEntryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CatalogEntryRelatedEntryComponent(CatalogEntryRelationType relationship, Reference target) {
        super();
        this.setRelationship(relationship);
        this.setTarget(target);
      }

        /**
         * @return {@link #relationship} (The type of relationship to the related entry.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<CatalogEntryRelationType> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CatalogEntryRelatedEntryComponent.relationship");
            else if (Configuration.doAutoCreate())
              this.relationship = new Enumeration<CatalogEntryRelationType>(new CatalogEntryRelationTypeEnumFactory()); // bb
          return this.relationship;
        }

        public boolean hasRelationshipElement() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        public boolean hasRelationship() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        /**
         * @param value {@link #relationship} (The type of relationship to the related entry.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public CatalogEntryRelatedEntryComponent setRelationshipElement(Enumeration<CatalogEntryRelationType> value) { 
          this.relationship = value;
          return this;
        }

        /**
         * @return The type of relationship to the related entry.
         */
        public CatalogEntryRelationType getRelationship() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        /**
         * @param value The type of relationship to the related entry.
         */
        public CatalogEntryRelatedEntryComponent setRelationship(CatalogEntryRelationType value) { 
            if (this.relationship == null)
              this.relationship = new Enumeration<CatalogEntryRelationType>(new CatalogEntryRelationTypeEnumFactory());
            this.relationship.setValue(value);
          return this;
        }

        /**
         * @return {@link #target} (The reference to the related entry.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CatalogEntryRelatedEntryComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (The reference to the related entry.)
         */
        public CatalogEntryRelatedEntryComponent setTarget(Reference value) { 
          this.target = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("relationship", "code", "The type of relationship to the related entry.", 0, 1, relationship));
          children.add(new Property("target", "Reference(CatalogEntry)", "The reference to the related entry.", 0, 1, target));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The type of relationship to the related entry.", 0, 1, relationship);
          case -880905839: /*target*/  return new Property("target", "Reference(CatalogEntry)", "The reference to the related entry.", 0, 1, target);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // Enumeration<CatalogEntryRelationType>
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -261851592: // relationship
          value = new CatalogEntryRelationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<CatalogEntryRelationType>
          return value;
        case -880905839: // target
          this.target = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("relationship")) {
          value = new CatalogEntryRelationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<CatalogEntryRelationType>
        } else if (name.equals("target")) {
          this.target = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261851592:  return getRelationshipElement();
        case -880905839:  return getTarget();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261851592: /*relationship*/ return new String[] {"code"};
        case -880905839: /*target*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.relatedEntry.relationship");
        }
        else if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else
          return super.addChild(name);
      }

      public CatalogEntryRelatedEntryComponent copy() {
        CatalogEntryRelatedEntryComponent dst = new CatalogEntryRelatedEntryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CatalogEntryRelatedEntryComponent dst) {
        super.copyValues(dst);
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.target = target == null ? null : target.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CatalogEntryRelatedEntryComponent))
          return false;
        CatalogEntryRelatedEntryComponent o = (CatalogEntryRelatedEntryComponent) other_;
        return compareDeep(relationship, o.relationship, true) && compareDeep(target, o.target, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CatalogEntryRelatedEntryComponent))
          return false;
        CatalogEntryRelatedEntryComponent o = (CatalogEntryRelatedEntryComponent) other_;
        return compareValues(relationship, o.relationship, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relationship, target);
      }

  public String fhirType() {
    return "CatalogEntry.relatedEntry";

  }

  }

    /**
     * Business identifier uniquely assigned to the catalog entry.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier of the catalog entry", formalDefinition="Business identifier uniquely assigned to the catalog entry." )
    protected List<Identifier> identifier;

    /**
     * The name of this catalog entry announces the item that is represented by the entry.
     */
    @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Displayable name assigned to the catalog entry", formalDefinition="The name of this catalog entry announces the item that is represented by the entry." )
    protected StringType name;

    /**
     * The type of resource that is represented by this catalog entry.
     */
    @Child(name = "type", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="ActivityDefinition | PlanDefinition | SpecimenDefinition | ObservationDefinition | DeviceDefinition | Organization | Practitioner | PractitionerRole | HealthcareService | MedicationKnowledge | Medication | Substance | Location", formalDefinition="The type of resource that is represented by this catalog entry." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/catalogentry-type")
    protected Enumeration<CatalogEntryType> type;

    /**
     * Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired", formalDefinition="Indicates whether this catalog entry is open to public usage (active) or not (draft or retired)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/catalogentry-status")
    protected Enumeration<CatalogEntryStatus> status;

    /**
     * Period of usability of the catalog entry.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When this catalog entry is expected to be active", formalDefinition="Period of usability of the catalog entry." )
    protected Period effectivePeriod;

    /**
     * Indicates whether or not the entry represents an item that is orderable.
     */
    @Child(name = "orderable", type = {BooleanType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Is orderable", formalDefinition="Indicates whether or not the entry represents an item that is orderable." )
    protected BooleanType orderable;

    /**
     * The item (resource) that this entry of the catalog represents.
     */
    @Child(name = "referencedItem", type = {DeviceDefinition.class, Organization.class, Practitioner.class, PractitionerRole.class, HealthcareService.class, ActivityDefinition.class, PlanDefinition.class, SpecimenDefinition.class, ObservationDefinition.class, MedicationKnowledge.class, Substance.class, Location.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Item attached to this entry of the catalog", formalDefinition="The item (resource) that this entry of the catalog represents." )
    protected Reference referencedItem;

    /**
     * Used for example, to point to a substance, or to a device used to administer a medication.
     */
    @Child(name = "relatedEntry", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Another entry of the catalog related to this one", formalDefinition="Used for example, to point to a substance, or to a device used to administer a medication." )
    protected List<CatalogEntryRelatedEntryComponent> relatedEntry;

    /**
     * Last actor who recorded (created or updated) this catalog entry.
     */
    @Child(name = "updatedBy", type = {Person.class, Device.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Last updater of this catalog entry", formalDefinition="Last actor who recorded (created or updated) this catalog entry." )
    protected Reference updatedBy;

    /**
     * Notes and comments about this catalog entry.
     */
    @Child(name = "note", type = {Annotation.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Notes and comments about this catalog entry", formalDefinition="Notes and comments about this catalog entry." )
    protected List<Annotation> note;

    /**
     * Estimated duration of the orderable item of this  entry of the catalog.
     */
    @Child(name = "estimatedDuration", type = {Duration.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Estimated duration of the orderable item", formalDefinition="Estimated duration of the orderable item of this  entry of the catalog." )
    protected Duration estimatedDuration;

    /**
     * Billing code associated to the  item in the context of this  entry of the catalog.
     */
    @Child(name = "billingCode", type = {CodeableConcept.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Billing code in the context of this catalog entry", formalDefinition="Billing code associated to the  item in the context of this  entry of the catalog." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cpt-all")
    protected List<CodeableConcept> billingCode;

    /**
     * Billing summary attached to the  item in the context of this  entry of the catalog.
     */
    @Child(name = "billingSummary", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Billing summary in the context of this catalog entry", formalDefinition="Billing summary attached to the  item in the context of this  entry of the catalog." )
    protected StringType billingSummary;

    /**
     * Schedule summary for the  item in the context of this  entry of the catalog.
     */
    @Child(name = "scheduleSummary", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Schedule summary for the catalog entry", formalDefinition="Schedule summary for the  item in the context of this  entry of the catalog." )
    protected StringType scheduleSummary;

    /**
     * Summary of limitations for the  item in the context of this  entry of the catalog.
     */
    @Child(name = "limitationSummary", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Summary of limitations for the catalog entry", formalDefinition="Summary of limitations for the  item in the context of this  entry of the catalog." )
    protected StringType limitationSummary;

    /**
     * Regulatory summary for the  item in the context of this  entry of the catalog.
     */
    @Child(name = "regulatorySummary", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Regulatory  summary for the catalog entry", formalDefinition="Regulatory summary for the  item in the context of this  entry of the catalog." )
    protected StringType regulatorySummary;

    private static final long serialVersionUID = -2010989359L;

  /**
   * Constructor
   */
    public CatalogEntry() {
      super();
    }

  /**
   * Constructor
   */
    public CatalogEntry(boolean orderable, Reference referencedItem) {
      super();
      this.setOrderable(orderable);
      this.setReferencedItem(referencedItem);
    }

    /**
     * @return {@link #identifier} (Business identifier uniquely assigned to the catalog entry.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CatalogEntry setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CatalogEntry addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #name} (The name of this catalog entry announces the item that is represented by the entry.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (The name of this catalog entry announces the item that is represented by the entry.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public CatalogEntry setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return The name of this catalog entry announces the item that is represented by the entry.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value The name of this catalog entry announces the item that is represented by the entry.
     */
    public CatalogEntry setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (The type of resource that is represented by this catalog entry.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<CatalogEntryType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<CatalogEntryType>(new CatalogEntryTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of resource that is represented by this catalog entry.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public CatalogEntry setTypeElement(Enumeration<CatalogEntryType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of resource that is represented by this catalog entry.
     */
    public CatalogEntryType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of resource that is represented by this catalog entry.
     */
    public CatalogEntry setType(CatalogEntryType value) { 
      if (value == null)
        this.type = null;
      else {
        if (this.type == null)
          this.type = new Enumeration<CatalogEntryType>(new CatalogEntryTypeEnumFactory());
        this.type.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<CatalogEntryStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<CatalogEntryStatus>(new CatalogEntryStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CatalogEntry setStatusElement(Enumeration<CatalogEntryStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).
     */
    public CatalogEntryStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).
     */
    public CatalogEntry setStatus(CatalogEntryStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<CatalogEntryStatus>(new CatalogEntryStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #effectivePeriod} (Period of usability of the catalog entry.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (Period of usability of the catalog entry.)
     */
    public CatalogEntry setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #orderable} (Indicates whether or not the entry represents an item that is orderable.). This is the underlying object with id, value and extensions. The accessor "getOrderable" gives direct access to the value
     */
    public BooleanType getOrderableElement() { 
      if (this.orderable == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.orderable");
        else if (Configuration.doAutoCreate())
          this.orderable = new BooleanType(); // bb
      return this.orderable;
    }

    public boolean hasOrderableElement() { 
      return this.orderable != null && !this.orderable.isEmpty();
    }

    public boolean hasOrderable() { 
      return this.orderable != null && !this.orderable.isEmpty();
    }

    /**
     * @param value {@link #orderable} (Indicates whether or not the entry represents an item that is orderable.). This is the underlying object with id, value and extensions. The accessor "getOrderable" gives direct access to the value
     */
    public CatalogEntry setOrderableElement(BooleanType value) { 
      this.orderable = value;
      return this;
    }

    /**
     * @return Indicates whether or not the entry represents an item that is orderable.
     */
    public boolean getOrderable() { 
      return this.orderable == null || this.orderable.isEmpty() ? false : this.orderable.getValue();
    }

    /**
     * @param value Indicates whether or not the entry represents an item that is orderable.
     */
    public CatalogEntry setOrderable(boolean value) { 
        if (this.orderable == null)
          this.orderable = new BooleanType();
        this.orderable.setValue(value);
      return this;
    }

    /**
     * @return {@link #referencedItem} (The item (resource) that this entry of the catalog represents.)
     */
    public Reference getReferencedItem() { 
      if (this.referencedItem == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.referencedItem");
        else if (Configuration.doAutoCreate())
          this.referencedItem = new Reference(); // cc
      return this.referencedItem;
    }

    public boolean hasReferencedItem() { 
      return this.referencedItem != null && !this.referencedItem.isEmpty();
    }

    /**
     * @param value {@link #referencedItem} (The item (resource) that this entry of the catalog represents.)
     */
    public CatalogEntry setReferencedItem(Reference value) { 
      this.referencedItem = value;
      return this;
    }

    /**
     * @return {@link #relatedEntry} (Used for example, to point to a substance, or to a device used to administer a medication.)
     */
    public List<CatalogEntryRelatedEntryComponent> getRelatedEntry() { 
      if (this.relatedEntry == null)
        this.relatedEntry = new ArrayList<CatalogEntryRelatedEntryComponent>();
      return this.relatedEntry;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CatalogEntry setRelatedEntry(List<CatalogEntryRelatedEntryComponent> theRelatedEntry) { 
      this.relatedEntry = theRelatedEntry;
      return this;
    }

    public boolean hasRelatedEntry() { 
      if (this.relatedEntry == null)
        return false;
      for (CatalogEntryRelatedEntryComponent item : this.relatedEntry)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CatalogEntryRelatedEntryComponent addRelatedEntry() { //3
      CatalogEntryRelatedEntryComponent t = new CatalogEntryRelatedEntryComponent();
      if (this.relatedEntry == null)
        this.relatedEntry = new ArrayList<CatalogEntryRelatedEntryComponent>();
      this.relatedEntry.add(t);
      return t;
    }

    public CatalogEntry addRelatedEntry(CatalogEntryRelatedEntryComponent t) { //3
      if (t == null)
        return this;
      if (this.relatedEntry == null)
        this.relatedEntry = new ArrayList<CatalogEntryRelatedEntryComponent>();
      this.relatedEntry.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedEntry}, creating it if it does not already exist {3}
     */
    public CatalogEntryRelatedEntryComponent getRelatedEntryFirstRep() { 
      if (getRelatedEntry().isEmpty()) {
        addRelatedEntry();
      }
      return getRelatedEntry().get(0);
    }

    /**
     * @return {@link #updatedBy} (Last actor who recorded (created or updated) this catalog entry.)
     */
    public Reference getUpdatedBy() { 
      if (this.updatedBy == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.updatedBy");
        else if (Configuration.doAutoCreate())
          this.updatedBy = new Reference(); // cc
      return this.updatedBy;
    }

    public boolean hasUpdatedBy() { 
      return this.updatedBy != null && !this.updatedBy.isEmpty();
    }

    /**
     * @param value {@link #updatedBy} (Last actor who recorded (created or updated) this catalog entry.)
     */
    public CatalogEntry setUpdatedBy(Reference value) { 
      this.updatedBy = value;
      return this;
    }

    /**
     * @return {@link #note} (Notes and comments about this catalog entry.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CatalogEntry setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public CatalogEntry addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #estimatedDuration} (Estimated duration of the orderable item of this  entry of the catalog.)
     */
    public Duration getEstimatedDuration() { 
      if (this.estimatedDuration == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.estimatedDuration");
        else if (Configuration.doAutoCreate())
          this.estimatedDuration = new Duration(); // cc
      return this.estimatedDuration;
    }

    public boolean hasEstimatedDuration() { 
      return this.estimatedDuration != null && !this.estimatedDuration.isEmpty();
    }

    /**
     * @param value {@link #estimatedDuration} (Estimated duration of the orderable item of this  entry of the catalog.)
     */
    public CatalogEntry setEstimatedDuration(Duration value) { 
      this.estimatedDuration = value;
      return this;
    }

    /**
     * @return {@link #billingCode} (Billing code associated to the  item in the context of this  entry of the catalog.)
     */
    public List<CodeableConcept> getBillingCode() { 
      if (this.billingCode == null)
        this.billingCode = new ArrayList<CodeableConcept>();
      return this.billingCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CatalogEntry setBillingCode(List<CodeableConcept> theBillingCode) { 
      this.billingCode = theBillingCode;
      return this;
    }

    public boolean hasBillingCode() { 
      if (this.billingCode == null)
        return false;
      for (CodeableConcept item : this.billingCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBillingCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.billingCode == null)
        this.billingCode = new ArrayList<CodeableConcept>();
      this.billingCode.add(t);
      return t;
    }

    public CatalogEntry addBillingCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.billingCode == null)
        this.billingCode = new ArrayList<CodeableConcept>();
      this.billingCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #billingCode}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBillingCodeFirstRep() { 
      if (getBillingCode().isEmpty()) {
        addBillingCode();
      }
      return getBillingCode().get(0);
    }

    /**
     * @return {@link #billingSummary} (Billing summary attached to the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getBillingSummary" gives direct access to the value
     */
    public StringType getBillingSummaryElement() { 
      if (this.billingSummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.billingSummary");
        else if (Configuration.doAutoCreate())
          this.billingSummary = new StringType(); // bb
      return this.billingSummary;
    }

    public boolean hasBillingSummaryElement() { 
      return this.billingSummary != null && !this.billingSummary.isEmpty();
    }

    public boolean hasBillingSummary() { 
      return this.billingSummary != null && !this.billingSummary.isEmpty();
    }

    /**
     * @param value {@link #billingSummary} (Billing summary attached to the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getBillingSummary" gives direct access to the value
     */
    public CatalogEntry setBillingSummaryElement(StringType value) { 
      this.billingSummary = value;
      return this;
    }

    /**
     * @return Billing summary attached to the  item in the context of this  entry of the catalog.
     */
    public String getBillingSummary() { 
      return this.billingSummary == null ? null : this.billingSummary.getValue();
    }

    /**
     * @param value Billing summary attached to the  item in the context of this  entry of the catalog.
     */
    public CatalogEntry setBillingSummary(String value) { 
      if (Utilities.noString(value))
        this.billingSummary = null;
      else {
        if (this.billingSummary == null)
          this.billingSummary = new StringType();
        this.billingSummary.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #scheduleSummary} (Schedule summary for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getScheduleSummary" gives direct access to the value
     */
    public StringType getScheduleSummaryElement() { 
      if (this.scheduleSummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.scheduleSummary");
        else if (Configuration.doAutoCreate())
          this.scheduleSummary = new StringType(); // bb
      return this.scheduleSummary;
    }

    public boolean hasScheduleSummaryElement() { 
      return this.scheduleSummary != null && !this.scheduleSummary.isEmpty();
    }

    public boolean hasScheduleSummary() { 
      return this.scheduleSummary != null && !this.scheduleSummary.isEmpty();
    }

    /**
     * @param value {@link #scheduleSummary} (Schedule summary for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getScheduleSummary" gives direct access to the value
     */
    public CatalogEntry setScheduleSummaryElement(StringType value) { 
      this.scheduleSummary = value;
      return this;
    }

    /**
     * @return Schedule summary for the  item in the context of this  entry of the catalog.
     */
    public String getScheduleSummary() { 
      return this.scheduleSummary == null ? null : this.scheduleSummary.getValue();
    }

    /**
     * @param value Schedule summary for the  item in the context of this  entry of the catalog.
     */
    public CatalogEntry setScheduleSummary(String value) { 
      if (Utilities.noString(value))
        this.scheduleSummary = null;
      else {
        if (this.scheduleSummary == null)
          this.scheduleSummary = new StringType();
        this.scheduleSummary.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #limitationSummary} (Summary of limitations for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getLimitationSummary" gives direct access to the value
     */
    public StringType getLimitationSummaryElement() { 
      if (this.limitationSummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.limitationSummary");
        else if (Configuration.doAutoCreate())
          this.limitationSummary = new StringType(); // bb
      return this.limitationSummary;
    }

    public boolean hasLimitationSummaryElement() { 
      return this.limitationSummary != null && !this.limitationSummary.isEmpty();
    }

    public boolean hasLimitationSummary() { 
      return this.limitationSummary != null && !this.limitationSummary.isEmpty();
    }

    /**
     * @param value {@link #limitationSummary} (Summary of limitations for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getLimitationSummary" gives direct access to the value
     */
    public CatalogEntry setLimitationSummaryElement(StringType value) { 
      this.limitationSummary = value;
      return this;
    }

    /**
     * @return Summary of limitations for the  item in the context of this  entry of the catalog.
     */
    public String getLimitationSummary() { 
      return this.limitationSummary == null ? null : this.limitationSummary.getValue();
    }

    /**
     * @param value Summary of limitations for the  item in the context of this  entry of the catalog.
     */
    public CatalogEntry setLimitationSummary(String value) { 
      if (Utilities.noString(value))
        this.limitationSummary = null;
      else {
        if (this.limitationSummary == null)
          this.limitationSummary = new StringType();
        this.limitationSummary.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #regulatorySummary} (Regulatory summary for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getRegulatorySummary" gives direct access to the value
     */
    public StringType getRegulatorySummaryElement() { 
      if (this.regulatorySummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CatalogEntry.regulatorySummary");
        else if (Configuration.doAutoCreate())
          this.regulatorySummary = new StringType(); // bb
      return this.regulatorySummary;
    }

    public boolean hasRegulatorySummaryElement() { 
      return this.regulatorySummary != null && !this.regulatorySummary.isEmpty();
    }

    public boolean hasRegulatorySummary() { 
      return this.regulatorySummary != null && !this.regulatorySummary.isEmpty();
    }

    /**
     * @param value {@link #regulatorySummary} (Regulatory summary for the  item in the context of this  entry of the catalog.). This is the underlying object with id, value and extensions. The accessor "getRegulatorySummary" gives direct access to the value
     */
    public CatalogEntry setRegulatorySummaryElement(StringType value) { 
      this.regulatorySummary = value;
      return this;
    }

    /**
     * @return Regulatory summary for the  item in the context of this  entry of the catalog.
     */
    public String getRegulatorySummary() { 
      return this.regulatorySummary == null ? null : this.regulatorySummary.getValue();
    }

    /**
     * @param value Regulatory summary for the  item in the context of this  entry of the catalog.
     */
    public CatalogEntry setRegulatorySummary(String value) { 
      if (Utilities.noString(value))
        this.regulatorySummary = null;
      else {
        if (this.regulatorySummary == null)
          this.regulatorySummary = new StringType();
        this.regulatorySummary.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier uniquely assigned to the catalog entry.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("name", "string", "The name of this catalog entry announces the item that is represented by the entry.", 0, 1, name));
        children.add(new Property("type", "code", "The type of resource that is represented by this catalog entry.", 0, 1, type));
        children.add(new Property("status", "code", "Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).", 0, 1, status));
        children.add(new Property("effectivePeriod", "Period", "Period of usability of the catalog entry.", 0, 1, effectivePeriod));
        children.add(new Property("orderable", "boolean", "Indicates whether or not the entry represents an item that is orderable.", 0, 1, orderable));
        children.add(new Property("referencedItem", "Reference(DeviceDefinition|Organization|Practitioner|PractitionerRole|HealthcareService|ActivityDefinition|PlanDefinition|SpecimenDefinition|ObservationDefinition|MedicationKnowledge|Substance|Location)", "The item (resource) that this entry of the catalog represents.", 0, 1, referencedItem));
        children.add(new Property("relatedEntry", "", "Used for example, to point to a substance, or to a device used to administer a medication.", 0, java.lang.Integer.MAX_VALUE, relatedEntry));
        children.add(new Property("updatedBy", "Reference(Person|Device)", "Last actor who recorded (created or updated) this catalog entry.", 0, 1, updatedBy));
        children.add(new Property("note", "Annotation", "Notes and comments about this catalog entry.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("estimatedDuration", "Duration", "Estimated duration of the orderable item of this  entry of the catalog.", 0, 1, estimatedDuration));
        children.add(new Property("billingCode", "CodeableConcept", "Billing code associated to the  item in the context of this  entry of the catalog.", 0, java.lang.Integer.MAX_VALUE, billingCode));
        children.add(new Property("billingSummary", "string", "Billing summary attached to the  item in the context of this  entry of the catalog.", 0, 1, billingSummary));
        children.add(new Property("scheduleSummary", "string", "Schedule summary for the  item in the context of this  entry of the catalog.", 0, 1, scheduleSummary));
        children.add(new Property("limitationSummary", "string", "Summary of limitations for the  item in the context of this  entry of the catalog.", 0, 1, limitationSummary));
        children.add(new Property("regulatorySummary", "string", "Regulatory summary for the  item in the context of this  entry of the catalog.", 0, 1, regulatorySummary));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier uniquely assigned to the catalog entry.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3373707: /*name*/  return new Property("name", "string", "The name of this catalog entry announces the item that is represented by the entry.", 0, 1, name);
        case 3575610: /*type*/  return new Property("type", "code", "The type of resource that is represented by this catalog entry.", 0, 1, type);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates whether this catalog entry is open to public usage (active) or not (draft or retired).", 0, 1, status);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "Period of usability of the catalog entry.", 0, 1, effectivePeriod);
        case -391199320: /*orderable*/  return new Property("orderable", "boolean", "Indicates whether or not the entry represents an item that is orderable.", 0, 1, orderable);
        case -1896630996: /*referencedItem*/  return new Property("referencedItem", "Reference(DeviceDefinition|Organization|Practitioner|PractitionerRole|HealthcareService|ActivityDefinition|PlanDefinition|SpecimenDefinition|ObservationDefinition|MedicationKnowledge|Substance|Location)", "The item (resource) that this entry of the catalog represents.", 0, 1, referencedItem);
        case 130178823: /*relatedEntry*/  return new Property("relatedEntry", "", "Used for example, to point to a substance, or to a device used to administer a medication.", 0, java.lang.Integer.MAX_VALUE, relatedEntry);
        case -1949194638: /*updatedBy*/  return new Property("updatedBy", "Reference(Person|Device)", "Last actor who recorded (created or updated) this catalog entry.", 0, 1, updatedBy);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Notes and comments about this catalog entry.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1266497008: /*estimatedDuration*/  return new Property("estimatedDuration", "Duration", "Estimated duration of the orderable item of this  entry of the catalog.", 0, 1, estimatedDuration);
        case 91787016: /*billingCode*/  return new Property("billingCode", "CodeableConcept", "Billing code associated to the  item in the context of this  entry of the catalog.", 0, java.lang.Integer.MAX_VALUE, billingCode);
        case 28404907: /*billingSummary*/  return new Property("billingSummary", "string", "Billing summary attached to the  item in the context of this  entry of the catalog.", 0, 1, billingSummary);
        case -255728369: /*scheduleSummary*/  return new Property("scheduleSummary", "string", "Schedule summary for the  item in the context of this  entry of the catalog.", 0, 1, scheduleSummary);
        case -79871444: /*limitationSummary*/  return new Property("limitationSummary", "string", "Summary of limitations for the  item in the context of this  entry of the catalog.", 0, 1, limitationSummary);
        case 1296867822: /*regulatorySummary*/  return new Property("regulatorySummary", "string", "Regulatory summary for the  item in the context of this  entry of the catalog.", 0, 1, regulatorySummary);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<CatalogEntryType>
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<CatalogEntryStatus>
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -391199320: /*orderable*/ return this.orderable == null ? new Base[0] : new Base[] {this.orderable}; // BooleanType
        case -1896630996: /*referencedItem*/ return this.referencedItem == null ? new Base[0] : new Base[] {this.referencedItem}; // Reference
        case 130178823: /*relatedEntry*/ return this.relatedEntry == null ? new Base[0] : this.relatedEntry.toArray(new Base[this.relatedEntry.size()]); // CatalogEntryRelatedEntryComponent
        case -1949194638: /*updatedBy*/ return this.updatedBy == null ? new Base[0] : new Base[] {this.updatedBy}; // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1266497008: /*estimatedDuration*/ return this.estimatedDuration == null ? new Base[0] : new Base[] {this.estimatedDuration}; // Duration
        case 91787016: /*billingCode*/ return this.billingCode == null ? new Base[0] : this.billingCode.toArray(new Base[this.billingCode.size()]); // CodeableConcept
        case 28404907: /*billingSummary*/ return this.billingSummary == null ? new Base[0] : new Base[] {this.billingSummary}; // StringType
        case -255728369: /*scheduleSummary*/ return this.scheduleSummary == null ? new Base[0] : new Base[] {this.scheduleSummary}; // StringType
        case -79871444: /*limitationSummary*/ return this.limitationSummary == null ? new Base[0] : new Base[] {this.limitationSummary}; // StringType
        case 1296867822: /*regulatorySummary*/ return this.regulatorySummary == null ? new Base[0] : new Base[] {this.regulatorySummary}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new CatalogEntryTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CatalogEntryType>
          return value;
        case -892481550: // status
          value = new CatalogEntryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CatalogEntryStatus>
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -391199320: // orderable
          this.orderable = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1896630996: // referencedItem
          this.referencedItem = TypeConvertor.castToReference(value); // Reference
          return value;
        case 130178823: // relatedEntry
          this.getRelatedEntry().add((CatalogEntryRelatedEntryComponent) value); // CatalogEntryRelatedEntryComponent
          return value;
        case -1949194638: // updatedBy
          this.updatedBy = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1266497008: // estimatedDuration
          this.estimatedDuration = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 91787016: // billingCode
          this.getBillingCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 28404907: // billingSummary
          this.billingSummary = TypeConvertor.castToString(value); // StringType
          return value;
        case -255728369: // scheduleSummary
          this.scheduleSummary = TypeConvertor.castToString(value); // StringType
          return value;
        case -79871444: // limitationSummary
          this.limitationSummary = TypeConvertor.castToString(value); // StringType
          return value;
        case 1296867822: // regulatorySummary
          this.regulatorySummary = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new CatalogEntryTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CatalogEntryType>
        } else if (name.equals("status")) {
          value = new CatalogEntryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CatalogEntryStatus>
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("orderable")) {
          this.orderable = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("referencedItem")) {
          this.referencedItem = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("relatedEntry")) {
          this.getRelatedEntry().add((CatalogEntryRelatedEntryComponent) value);
        } else if (name.equals("updatedBy")) {
          this.updatedBy = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("estimatedDuration")) {
          this.estimatedDuration = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("billingCode")) {
          this.getBillingCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("billingSummary")) {
          this.billingSummary = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("scheduleSummary")) {
          this.scheduleSummary = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("limitationSummary")) {
          this.limitationSummary = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("regulatorySummary")) {
          this.regulatorySummary = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3373707:  return getNameElement();
        case 3575610:  return getTypeElement();
        case -892481550:  return getStatusElement();
        case -403934648:  return getEffectivePeriod();
        case -391199320:  return getOrderableElement();
        case -1896630996:  return getReferencedItem();
        case 130178823:  return addRelatedEntry(); 
        case -1949194638:  return getUpdatedBy();
        case 3387378:  return addNote(); 
        case 1266497008:  return getEstimatedDuration();
        case 91787016:  return addBillingCode(); 
        case 28404907:  return getBillingSummaryElement();
        case -255728369:  return getScheduleSummaryElement();
        case -79871444:  return getLimitationSummaryElement();
        case 1296867822:  return getRegulatorySummaryElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -391199320: /*orderable*/ return new String[] {"boolean"};
        case -1896630996: /*referencedItem*/ return new String[] {"Reference"};
        case 130178823: /*relatedEntry*/ return new String[] {};
        case -1949194638: /*updatedBy*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1266497008: /*estimatedDuration*/ return new String[] {"Duration"};
        case 91787016: /*billingCode*/ return new String[] {"CodeableConcept"};
        case 28404907: /*billingSummary*/ return new String[] {"string"};
        case -255728369: /*scheduleSummary*/ return new String[] {"string"};
        case -79871444: /*limitationSummary*/ return new String[] {"string"};
        case 1296867822: /*regulatorySummary*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.name");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.type");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.status");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("orderable")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.orderable");
        }
        else if (name.equals("referencedItem")) {
          this.referencedItem = new Reference();
          return this.referencedItem;
        }
        else if (name.equals("relatedEntry")) {
          return addRelatedEntry();
        }
        else if (name.equals("updatedBy")) {
          this.updatedBy = new Reference();
          return this.updatedBy;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("estimatedDuration")) {
          this.estimatedDuration = new Duration();
          return this.estimatedDuration;
        }
        else if (name.equals("billingCode")) {
          return addBillingCode();
        }
        else if (name.equals("billingSummary")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.billingSummary");
        }
        else if (name.equals("scheduleSummary")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.scheduleSummary");
        }
        else if (name.equals("limitationSummary")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.limitationSummary");
        }
        else if (name.equals("regulatorySummary")) {
          throw new FHIRException("Cannot call addChild on a primitive type CatalogEntry.regulatorySummary");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CatalogEntry";

  }

      public CatalogEntry copy() {
        CatalogEntry dst = new CatalogEntry();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CatalogEntry dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        dst.status = status == null ? null : status.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        dst.orderable = orderable == null ? null : orderable.copy();
        dst.referencedItem = referencedItem == null ? null : referencedItem.copy();
        if (relatedEntry != null) {
          dst.relatedEntry = new ArrayList<CatalogEntryRelatedEntryComponent>();
          for (CatalogEntryRelatedEntryComponent i : relatedEntry)
            dst.relatedEntry.add(i.copy());
        };
        dst.updatedBy = updatedBy == null ? null : updatedBy.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.estimatedDuration = estimatedDuration == null ? null : estimatedDuration.copy();
        if (billingCode != null) {
          dst.billingCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : billingCode)
            dst.billingCode.add(i.copy());
        };
        dst.billingSummary = billingSummary == null ? null : billingSummary.copy();
        dst.scheduleSummary = scheduleSummary == null ? null : scheduleSummary.copy();
        dst.limitationSummary = limitationSummary == null ? null : limitationSummary.copy();
        dst.regulatorySummary = regulatorySummary == null ? null : regulatorySummary.copy();
      }

      protected CatalogEntry typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CatalogEntry))
          return false;
        CatalogEntry o = (CatalogEntry) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true) && compareDeep(type, o.type, true)
           && compareDeep(status, o.status, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(orderable, o.orderable, true) && compareDeep(referencedItem, o.referencedItem, true)
           && compareDeep(relatedEntry, o.relatedEntry, true) && compareDeep(updatedBy, o.updatedBy, true)
           && compareDeep(note, o.note, true) && compareDeep(estimatedDuration, o.estimatedDuration, true)
           && compareDeep(billingCode, o.billingCode, true) && compareDeep(billingSummary, o.billingSummary, true)
           && compareDeep(scheduleSummary, o.scheduleSummary, true) && compareDeep(limitationSummary, o.limitationSummary, true)
           && compareDeep(regulatorySummary, o.regulatorySummary, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CatalogEntry))
          return false;
        CatalogEntry o = (CatalogEntry) other_;
        return compareValues(name, o.name, true) && compareValues(type, o.type, true) && compareValues(status, o.status, true)
           && compareValues(orderable, o.orderable, true) && compareValues(billingSummary, o.billingSummary, true)
           && compareValues(scheduleSummary, o.scheduleSummary, true) && compareValues(limitationSummary, o.limitationSummary, true)
           && compareValues(regulatorySummary, o.regulatorySummary, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, name, type, status
          , effectivePeriod, orderable, referencedItem, relatedEntry, updatedBy, note, estimatedDuration
          , billingCode, billingSummary, scheduleSummary, limitationSummary, regulatorySummary
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CatalogEntry;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier of the catalog entry</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="CatalogEntry.identifier", description="Business identifier of the catalog entry", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier of the catalog entry</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Displayable name assigned to the catalog entry</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CatalogEntry.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="CatalogEntry.name", description="Displayable name assigned to the catalog entry", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Displayable name assigned to the catalog entry</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CatalogEntry.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>orderable</b>
   * <p>
   * Description: <b>Is orderable</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.orderable</b><br>
   * </p>
   */
  @SearchParamDefinition(name="orderable", path="CatalogEntry.orderable", description="Is orderable", type="token" )
  public static final String SP_ORDERABLE = "orderable";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>orderable</b>
   * <p>
   * Description: <b>Is orderable</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.orderable</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ORDERABLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ORDERABLE);

 /**
   * Search parameter: <b>referenced-item</b>
   * <p>
   * Description: <b>Item attached to this entry of the catalog</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CatalogEntry.referencedItem</b><br>
   * </p>
   */
  @SearchParamDefinition(name="referenced-item", path="CatalogEntry.referencedItem", description="Item attached to this entry of the catalog", type="reference", target={ActivityDefinition.class, DeviceDefinition.class, HealthcareService.class, Location.class, MedicationKnowledge.class, ObservationDefinition.class, Organization.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, SpecimenDefinition.class, Substance.class } )
  public static final String SP_REFERENCED_ITEM = "referenced-item";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>referenced-item</b>
   * <p>
   * Description: <b>Item attached to this entry of the catalog</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CatalogEntry.referencedItem</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REFERENCED_ITEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REFERENCED_ITEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CatalogEntry:referenced-item</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REFERENCED_ITEM = new ca.uhn.fhir.model.api.Include("CatalogEntry:referenced-item").toLocked();

 /**
   * Search parameter: <b>related-entry</b>
   * <p>
   * Description: <b>The reference to the related entry</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CatalogEntry.relatedEntry.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="related-entry", path="CatalogEntry.relatedEntry.target", description="The reference to the related entry", type="reference", target={CatalogEntry.class } )
  public static final String SP_RELATED_ENTRY = "related-entry";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>related-entry</b>
   * <p>
   * Description: <b>The reference to the related entry</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CatalogEntry.relatedEntry.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RELATED_ENTRY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RELATED_ENTRY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CatalogEntry:related-entry</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RELATED_ENTRY = new ca.uhn.fhir.model.api.Include("CatalogEntry:related-entry").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Usability status of this entry in the catalog</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="CatalogEntry.status", description="Usability status of this entry in the catalog", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Usability status of this entry in the catalog</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>ActivityDefinition | PlanDefinition | SpecimenDefinition | ObservationDefinition | DeviceDefinition | Organization | Practitioner | PractitionerRole | HealthcareService | MedicationKnowledge | Medication | Substance | Location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="CatalogEntry.type", description="ActivityDefinition | PlanDefinition | SpecimenDefinition | ObservationDefinition | DeviceDefinition | Organization | Practitioner | PractitionerRole | HealthcareService | MedicationKnowledge | Medication | Substance | Location", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>ActivityDefinition | PlanDefinition | SpecimenDefinition | ObservationDefinition | DeviceDefinition | Organization | Practitioner | PractitionerRole | HealthcareService | MedicationKnowledge | Medication | Substance | Location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CatalogEntry.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}