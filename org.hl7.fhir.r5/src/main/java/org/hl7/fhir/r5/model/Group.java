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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
 * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
 */
@ResourceDef(name="Group", profile="http://hl7.org/fhir/StructureDefinition/Group")
public class Group extends DomainResource {

    public enum GroupMembershipBasis {
        /**
         * The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
         */
        DEFINITIONAL, 
        /**
         * The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.
         */
        ENUMERATED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static GroupMembershipBasis fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("definitional".equals(codeString))
          return DEFINITIONAL;
        if ("enumerated".equals(codeString))
          return ENUMERATED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown GroupMembershipBasis code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DEFINITIONAL: return "definitional";
            case ENUMERATED: return "enumerated";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DEFINITIONAL: return "http://hl7.org/fhir/group-membership-basis";
            case ENUMERATED: return "http://hl7.org/fhir/group-membership-basis";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DEFINITIONAL: return "The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.";
            case ENUMERATED: return "The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DEFINITIONAL: return "Definitional";
            case ENUMERATED: return "Enumerated";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class GroupMembershipBasisEnumFactory implements EnumFactory<GroupMembershipBasis> {
    public GroupMembershipBasis fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("definitional".equals(codeString))
          return GroupMembershipBasis.DEFINITIONAL;
        if ("enumerated".equals(codeString))
          return GroupMembershipBasis.ENUMERATED;
        throw new IllegalArgumentException("Unknown GroupMembershipBasis code '"+codeString+"'");
        }
        public Enumeration<GroupMembershipBasis> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<GroupMembershipBasis>(this, GroupMembershipBasis.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<GroupMembershipBasis>(this, GroupMembershipBasis.NULL, code);
        if ("definitional".equals(codeString))
          return new Enumeration<GroupMembershipBasis>(this, GroupMembershipBasis.DEFINITIONAL, code);
        if ("enumerated".equals(codeString))
          return new Enumeration<GroupMembershipBasis>(this, GroupMembershipBasis.ENUMERATED, code);
        throw new FHIRException("Unknown GroupMembershipBasis code '"+codeString+"'");
        }
    public String toCode(GroupMembershipBasis code) {
      if (code == GroupMembershipBasis.DEFINITIONAL)
        return "definitional";
      if (code == GroupMembershipBasis.ENUMERATED)
        return "enumerated";
      return "?";
      }
    public String toSystem(GroupMembershipBasis code) {
      return code.getSystem();
      }
    }

    public enum GroupType {
        /**
         * Group contains \"person\" Patient resources.
         */
        PERSON, 
        /**
         * Group contains \"animal\" Patient resources.
         */
        ANIMAL, 
        /**
         * Group contains healthcare practitioner resources (Practitioner or PractitionerRole).
         */
        PRACTITIONER, 
        /**
         * Group contains Device resources.
         */
        DEVICE, 
        /**
         * Group contains CareTeam resources.
         */
        CARETEAM, 
        /**
         * Group contains HealthcareService resources.
         */
        HEALTHCARESERVICE, 
        /**
         * Group contains Location resources.
         */
        LOCATION, 
        /**
         * Group contains Organization resources.
         */
        ORGANIZATION, 
        /**
         * Group contains RelatedPerson resources.
         */
        RELATEDPERSON, 
        /**
         * Group contains Specimen resources.
         */
        SPECIMEN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static GroupType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return PERSON;
        if ("animal".equals(codeString))
          return ANIMAL;
        if ("practitioner".equals(codeString))
          return PRACTITIONER;
        if ("device".equals(codeString))
          return DEVICE;
        if ("careteam".equals(codeString))
          return CARETEAM;
        if ("healthcareservice".equals(codeString))
          return HEALTHCARESERVICE;
        if ("location".equals(codeString))
          return LOCATION;
        if ("organization".equals(codeString))
          return ORGANIZATION;
        if ("relatedperson".equals(codeString))
          return RELATEDPERSON;
        if ("specimen".equals(codeString))
          return SPECIMEN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown GroupType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PERSON: return "person";
            case ANIMAL: return "animal";
            case PRACTITIONER: return "practitioner";
            case DEVICE: return "device";
            case CARETEAM: return "careteam";
            case HEALTHCARESERVICE: return "healthcareservice";
            case LOCATION: return "location";
            case ORGANIZATION: return "organization";
            case RELATEDPERSON: return "relatedperson";
            case SPECIMEN: return "specimen";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PERSON: return "http://hl7.org/fhir/group-type";
            case ANIMAL: return "http://hl7.org/fhir/group-type";
            case PRACTITIONER: return "http://hl7.org/fhir/group-type";
            case DEVICE: return "http://hl7.org/fhir/group-type";
            case CARETEAM: return "http://hl7.org/fhir/group-type";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/group-type";
            case LOCATION: return "http://hl7.org/fhir/group-type";
            case ORGANIZATION: return "http://hl7.org/fhir/group-type";
            case RELATEDPERSON: return "http://hl7.org/fhir/group-type";
            case SPECIMEN: return "http://hl7.org/fhir/group-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PERSON: return "Group contains \"person\" Patient resources.";
            case ANIMAL: return "Group contains \"animal\" Patient resources.";
            case PRACTITIONER: return "Group contains healthcare practitioner resources (Practitioner or PractitionerRole).";
            case DEVICE: return "Group contains Device resources.";
            case CARETEAM: return "Group contains CareTeam resources.";
            case HEALTHCARESERVICE: return "Group contains HealthcareService resources.";
            case LOCATION: return "Group contains Location resources.";
            case ORGANIZATION: return "Group contains Organization resources.";
            case RELATEDPERSON: return "Group contains RelatedPerson resources.";
            case SPECIMEN: return "Group contains Specimen resources.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PERSON: return "Person";
            case ANIMAL: return "Animal";
            case PRACTITIONER: return "Practitioner";
            case DEVICE: return "Device";
            case CARETEAM: return "CareTeam";
            case HEALTHCARESERVICE: return "HealthcareService";
            case LOCATION: return "Location";
            case ORGANIZATION: return "Organization";
            case RELATEDPERSON: return "RelatedPerson";
            case SPECIMEN: return "Specimen";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class GroupTypeEnumFactory implements EnumFactory<GroupType> {
    public GroupType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return GroupType.PERSON;
        if ("animal".equals(codeString))
          return GroupType.ANIMAL;
        if ("practitioner".equals(codeString))
          return GroupType.PRACTITIONER;
        if ("device".equals(codeString))
          return GroupType.DEVICE;
        if ("careteam".equals(codeString))
          return GroupType.CARETEAM;
        if ("healthcareservice".equals(codeString))
          return GroupType.HEALTHCARESERVICE;
        if ("location".equals(codeString))
          return GroupType.LOCATION;
        if ("organization".equals(codeString))
          return GroupType.ORGANIZATION;
        if ("relatedperson".equals(codeString))
          return GroupType.RELATEDPERSON;
        if ("specimen".equals(codeString))
          return GroupType.SPECIMEN;
        throw new IllegalArgumentException("Unknown GroupType code '"+codeString+"'");
        }
        public Enumeration<GroupType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<GroupType>(this, GroupType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<GroupType>(this, GroupType.NULL, code);
        if ("person".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.PERSON, code);
        if ("animal".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.ANIMAL, code);
        if ("practitioner".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.PRACTITIONER, code);
        if ("device".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.DEVICE, code);
        if ("careteam".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.CARETEAM, code);
        if ("healthcareservice".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.HEALTHCARESERVICE, code);
        if ("location".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.LOCATION, code);
        if ("organization".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.ORGANIZATION, code);
        if ("relatedperson".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.RELATEDPERSON, code);
        if ("specimen".equals(codeString))
          return new Enumeration<GroupType>(this, GroupType.SPECIMEN, code);
        throw new FHIRException("Unknown GroupType code '"+codeString+"'");
        }
    public String toCode(GroupType code) {
      if (code == GroupType.PERSON)
        return "person";
      if (code == GroupType.ANIMAL)
        return "animal";
      if (code == GroupType.PRACTITIONER)
        return "practitioner";
      if (code == GroupType.DEVICE)
        return "device";
      if (code == GroupType.CARETEAM)
        return "careteam";
      if (code == GroupType.HEALTHCARESERVICE)
        return "healthcareservice";
      if (code == GroupType.LOCATION)
        return "location";
      if (code == GroupType.ORGANIZATION)
        return "organization";
      if (code == GroupType.RELATEDPERSON)
        return "relatedperson";
      if (code == GroupType.SPECIMEN)
        return "specimen";
      return "?";
      }
    public String toSystem(GroupType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class GroupCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code that identifies the kind of trait being asserted.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Kind of characteristic", formalDefinition="A code that identifies the kind of trait being asserted." )
        protected CodeableConcept code;

        /**
         * The value of the trait that holds (or does not hold - see 'exclude') for members of the group.
         */
        @Child(name = "value", type = {CodeableConcept.class, BooleanType.class, Quantity.class, Range.class, Reference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Value held by characteristic", formalDefinition="The value of the trait that holds (or does not hold - see 'exclude') for members of the group." )
        protected DataType value;

        /**
         * If true, indicates the characteristic is one that is NOT held by members of the group.
         */
        @Child(name = "exclude", type = {BooleanType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Group includes or excludes", formalDefinition="If true, indicates the characteristic is one that is NOT held by members of the group." )
        protected BooleanType exclude;

        /**
         * The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.
         */
        @Child(name = "period", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Period over which characteristic is tested", formalDefinition="The period over which the characteristic is tested; e.g. the patient had an operation during the month of June." )
        protected Period period;

        private static final long serialVersionUID = 279867823L;

    /**
     * Constructor
     */
      public GroupCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public GroupCharacteristicComponent(CodeableConcept code, DataType value, boolean exclude) {
        super();
        this.setCode(code);
        this.setValue(value);
        this.setExclude(exclude);
      }

        /**
         * @return {@link #code} (A code that identifies the kind of trait being asserted.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupCharacteristicComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code that identifies the kind of trait being asserted.)
         */
        public GroupCharacteristicComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the trait that holds (or does not hold - see 'exclude') for members of the group.)
         */
        public GroupCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof BooleanType || value instanceof Quantity || value instanceof Range || value instanceof Reference))
            throw new Error("Not the right type for Group.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #exclude} (If true, indicates the characteristic is one that is NOT held by members of the group.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public BooleanType getExcludeElement() { 
          if (this.exclude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupCharacteristicComponent.exclude");
            else if (Configuration.doAutoCreate())
              this.exclude = new BooleanType(); // bb
          return this.exclude;
        }

        public boolean hasExcludeElement() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        public boolean hasExclude() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        /**
         * @param value {@link #exclude} (If true, indicates the characteristic is one that is NOT held by members of the group.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public GroupCharacteristicComponent setExcludeElement(BooleanType value) { 
          this.exclude = value;
          return this;
        }

        /**
         * @return If true, indicates the characteristic is one that is NOT held by members of the group.
         */
        public boolean getExclude() { 
          return this.exclude == null || this.exclude.isEmpty() ? false : this.exclude.getValue();
        }

        /**
         * @param value If true, indicates the characteristic is one that is NOT held by members of the group.
         */
        public GroupCharacteristicComponent setExclude(boolean value) { 
            if (this.exclude == null)
              this.exclude = new BooleanType();
            this.exclude.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupCharacteristicComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.)
         */
        public GroupCharacteristicComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "A code that identifies the kind of trait being asserted.", 0, 1, code));
          children.add(new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value));
          children.add(new Property("exclude", "boolean", "If true, indicates the characteristic is one that is NOT held by members of the group.", 0, 1, exclude));
          children.add(new Property("period", "Period", "The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that identifies the kind of trait being asserted.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The value of the trait that holds (or does not hold - see 'exclude') for members of the group.", 0, 1, value);
          case -1321148966: /*exclude*/  return new Property("exclude", "boolean", "If true, indicates the characteristic is one that is NOT held by members of the group.", 0, 1, exclude);
          case -991726143: /*period*/  return new Property("period", "Period", "The period over which the characteristic is tested; e.g. the patient had an operation during the month of June.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1321148966: /*exclude*/ return this.exclude == null ? new Base[0] : new Base[] {this.exclude}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1321148966: // exclude
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("exclude")) {
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -1321148966:  return getExcludeElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "boolean", "Quantity", "Range", "Reference"};
        case -1321148966: /*exclude*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("exclude")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.characteristic.exclude");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public GroupCharacteristicComponent copy() {
        GroupCharacteristicComponent dst = new GroupCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GroupCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
        dst.exclude = exclude == null ? null : exclude.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GroupCharacteristicComponent))
          return false;
        GroupCharacteristicComponent o = (GroupCharacteristicComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true) && compareDeep(exclude, o.exclude, true)
           && compareDeep(period, o.period, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GroupCharacteristicComponent))
          return false;
        GroupCharacteristicComponent o = (GroupCharacteristicComponent) other_;
        return compareValues(exclude, o.exclude, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, exclude, period
          );
      }

  public String fhirType() {
    return "Group.characteristic";

  }

  }

    @Block()
    public static class GroupMemberComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.
         */
        @Child(name = "entity", type = {CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Specimen.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference to the group member", formalDefinition="A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same." )
        protected Reference entity;

        /**
         * The period that the member was in the group, if known.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Period member belonged to the group", formalDefinition="The period that the member was in the group, if known." )
        protected Period period;

        /**
         * A flag to indicate that the member is no longer in the group, but previously may have been a member.
         */
        @Child(name = "inactive", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If member is no longer in group", formalDefinition="A flag to indicate that the member is no longer in the group, but previously may have been a member." )
        protected BooleanType inactive;

        private static final long serialVersionUID = -1206153083L;

    /**
     * Constructor
     */
      public GroupMemberComponent() {
        super();
      }

    /**
     * Constructor
     */
      public GroupMemberComponent(Reference entity) {
        super();
        this.setEntity(entity);
      }

        /**
         * @return {@link #entity} (A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.)
         */
        public Reference getEntity() { 
          if (this.entity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupMemberComponent.entity");
            else if (Configuration.doAutoCreate())
              this.entity = new Reference(); // cc
          return this.entity;
        }

        public boolean hasEntity() { 
          return this.entity != null && !this.entity.isEmpty();
        }

        /**
         * @param value {@link #entity} (A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.)
         */
        public GroupMemberComponent setEntity(Reference value) { 
          this.entity = value;
          return this;
        }

        /**
         * @return {@link #period} (The period that the member was in the group, if known.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupMemberComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The period that the member was in the group, if known.)
         */
        public GroupMemberComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #inactive} (A flag to indicate that the member is no longer in the group, but previously may have been a member.). This is the underlying object with id, value and extensions. The accessor "getInactive" gives direct access to the value
         */
        public BooleanType getInactiveElement() { 
          if (this.inactive == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GroupMemberComponent.inactive");
            else if (Configuration.doAutoCreate())
              this.inactive = new BooleanType(); // bb
          return this.inactive;
        }

        public boolean hasInactiveElement() { 
          return this.inactive != null && !this.inactive.isEmpty();
        }

        public boolean hasInactive() { 
          return this.inactive != null && !this.inactive.isEmpty();
        }

        /**
         * @param value {@link #inactive} (A flag to indicate that the member is no longer in the group, but previously may have been a member.). This is the underlying object with id, value and extensions. The accessor "getInactive" gives direct access to the value
         */
        public GroupMemberComponent setInactiveElement(BooleanType value) { 
          this.inactive = value;
          return this;
        }

        /**
         * @return A flag to indicate that the member is no longer in the group, but previously may have been a member.
         */
        public boolean getInactive() { 
          return this.inactive == null || this.inactive.isEmpty() ? false : this.inactive.getValue();
        }

        /**
         * @param value A flag to indicate that the member is no longer in the group, but previously may have been a member.
         */
        public GroupMemberComponent setInactive(boolean value) { 
            if (this.inactive == null)
              this.inactive = new BooleanType();
            this.inactive.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("entity", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Specimen)", "A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.", 0, 1, entity));
          children.add(new Property("period", "Period", "The period that the member was in the group, if known.", 0, 1, period));
          children.add(new Property("inactive", "boolean", "A flag to indicate that the member is no longer in the group, but previously may have been a member.", 0, 1, inactive));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1298275357: /*entity*/  return new Property("entity", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Specimen)", "A reference to the entity that is a member of the group. Must be consistent with Group.type. If the entity is another group, then the type must be the same.", 0, 1, entity);
          case -991726143: /*period*/  return new Property("period", "Period", "The period that the member was in the group, if known.", 0, 1, period);
          case 24665195: /*inactive*/  return new Property("inactive", "boolean", "A flag to indicate that the member is no longer in the group, but previously may have been a member.", 0, 1, inactive);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1298275357: /*entity*/ return this.entity == null ? new Base[0] : new Base[] {this.entity}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 24665195: /*inactive*/ return this.inactive == null ? new Base[0] : new Base[] {this.inactive}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1298275357: // entity
          this.entity = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 24665195: // inactive
          this.inactive = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("entity")) {
          this.entity = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("inactive")) {
          this.inactive = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1298275357:  return getEntity();
        case -991726143:  return getPeriod();
        case 24665195:  return getInactiveElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1298275357: /*entity*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 24665195: /*inactive*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("entity")) {
          this.entity = new Reference();
          return this.entity;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("inactive")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.member.inactive");
        }
        else
          return super.addChild(name);
      }

      public GroupMemberComponent copy() {
        GroupMemberComponent dst = new GroupMemberComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GroupMemberComponent dst) {
        super.copyValues(dst);
        dst.entity = entity == null ? null : entity.copy();
        dst.period = period == null ? null : period.copy();
        dst.inactive = inactive == null ? null : inactive.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GroupMemberComponent))
          return false;
        GroupMemberComponent o = (GroupMemberComponent) other_;
        return compareDeep(entity, o.entity, true) && compareDeep(period, o.period, true) && compareDeep(inactive, o.inactive, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GroupMemberComponent))
          return false;
        GroupMemberComponent o = (GroupMemberComponent) other_;
        return compareValues(inactive, o.inactive, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(entity, period, inactive
          );
      }

  public String fhirType() {
    return "Group.member";

  }

  }

    /**
     * A unique business identifier for this group.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique id", formalDefinition="A unique business identifier for this group." )
    protected List<Identifier> identifier;

    /**
     * Indicates whether the record for the group is available for use or is merely being retained for historical purposes.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Whether this group's record is in active use", formalDefinition="Indicates whether the record for the group is available for use or is merely being retained for historical purposes." )
    protected BooleanType active;

    /**
     * Identifies the broad classification of the kind of resources the group includes.
     */
    @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="person | animal | practitioner | device | careteam | healthcareservice | location | organization | relatedperson | specimen", formalDefinition="Identifies the broad classification of the kind of resources the group includes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/group-type")
    protected Enumeration<GroupType> type;

    /**
     * Basis for membership in the Group:

* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.
     */
    @Child(name = "membership", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="definitional | enumerated", formalDefinition="Basis for membership in the Group:\n\n* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.\n* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/group-membership-basis")
    protected Enumeration<GroupMembershipBasis> membership;

    /**
     * Provides a specific type of resource the group includes; e.g. "cow", "syringe", etc.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of Group members", formalDefinition="Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc." )
    protected CodeableConcept code;

    /**
     * A label assigned to the group for human identification and communication.
     */
    @Child(name = "name", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Label for Group", formalDefinition="A label assigned to the group for human identification and communication." )
    protected StringType name;

    /**
     * Explanation of what the group represents and how it is intended to be used.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the group", formalDefinition="Explanation of what the group represents and how it is intended to be used." )
    protected MarkdownType description;

    /**
     * A count of the number of resource instances that are part of the group.
     */
    @Child(name = "quantity", type = {UnsignedIntType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of members", formalDefinition="A count of the number of resource instances that are part of the group." )
    protected UnsignedIntType quantity;

    /**
     * Entity responsible for defining and maintaining Group characteristics and/or registered members.
     */
    @Child(name = "managingEntity", type = {Organization.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Entity that is the custodian of the Group's definition", formalDefinition="Entity responsible for defining and maintaining Group characteristics and/or registered members." )
    protected Reference managingEntity;

    /**
     * Identifies traits whose presence r absence is shared by members of the group.
     */
    @Child(name = "characteristic", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Include / Exclude group members by Trait", formalDefinition="Identifies traits whose presence r absence is shared by members of the group." )
    protected List<GroupCharacteristicComponent> characteristic;

    /**
     * Identifies the resource instances that are members of the group.
     */
    @Child(name = "member", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who or what is in group", formalDefinition="Identifies the resource instances that are members of the group." )
    protected List<GroupMemberComponent> member;

    private static final long serialVersionUID = -39542514L;

  /**
   * Constructor
   */
    public Group() {
      super();
    }

  /**
   * Constructor
   */
    public Group(GroupType type, GroupMembershipBasis membership) {
      super();
      this.setType(type);
      this.setMembership(membership);
    }

    /**
     * @return {@link #identifier} (A unique business identifier for this group.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Group setIdentifier(List<Identifier> theIdentifier) { 
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

    public Group addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (Indicates whether the record for the group is available for use or is merely being retained for historical purposes.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.active");
        else if (Configuration.doAutoCreate())
          this.active = new BooleanType(); // bb
      return this.active;
    }

    public boolean hasActiveElement() { 
      return this.active != null && !this.active.isEmpty();
    }

    public boolean hasActive() { 
      return this.active != null && !this.active.isEmpty();
    }

    /**
     * @param value {@link #active} (Indicates whether the record for the group is available for use or is merely being retained for historical purposes.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public Group setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return Indicates whether the record for the group is available for use or is merely being retained for historical purposes.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value Indicates whether the record for the group is available for use or is merely being retained for historical purposes.
     */
    public Group setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (Identifies the broad classification of the kind of resources the group includes.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<GroupType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<GroupType>(new GroupTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Identifies the broad classification of the kind of resources the group includes.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Group setTypeElement(Enumeration<GroupType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Identifies the broad classification of the kind of resources the group includes.
     */
    public GroupType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Identifies the broad classification of the kind of resources the group includes.
     */
    public Group setType(GroupType value) { 
        if (this.type == null)
          this.type = new Enumeration<GroupType>(new GroupTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #membership} (Basis for membership in the Group:

* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.). This is the underlying object with id, value and extensions. The accessor "getMembership" gives direct access to the value
     */
    public Enumeration<GroupMembershipBasis> getMembershipElement() { 
      if (this.membership == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.membership");
        else if (Configuration.doAutoCreate())
          this.membership = new Enumeration<GroupMembershipBasis>(new GroupMembershipBasisEnumFactory()); // bb
      return this.membership;
    }

    public boolean hasMembershipElement() { 
      return this.membership != null && !this.membership.isEmpty();
    }

    public boolean hasMembership() { 
      return this.membership != null && !this.membership.isEmpty();
    }

    /**
     * @param value {@link #membership} (Basis for membership in the Group:

* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.). This is the underlying object with id, value and extensions. The accessor "getMembership" gives direct access to the value
     */
    public Group setMembershipElement(Enumeration<GroupMembershipBasis> value) { 
      this.membership = value;
      return this;
    }

    /**
     * @return Basis for membership in the Group:

* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.
     */
    public GroupMembershipBasis getMembership() { 
      return this.membership == null ? null : this.membership.getValue();
    }

    /**
     * @param value Basis for membership in the Group:

* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.
* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.
     */
    public Group setMembership(GroupMembershipBasis value) { 
        if (this.membership == null)
          this.membership = new Enumeration<GroupMembershipBasis>(new GroupMembershipBasisEnumFactory());
        this.membership.setValue(value);
      return this;
    }

    /**
     * @return {@link #code} (Provides a specific type of resource the group includes; e.g. "cow", "syringe", etc.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Provides a specific type of resource the group includes; e.g. "cow", "syringe", etc.)
     */
    public Group setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #name} (A label assigned to the group for human identification and communication.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.name");
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
     * @param value {@link #name} (A label assigned to the group for human identification and communication.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Group setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A label assigned to the group for human identification and communication.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A label assigned to the group for human identification and communication.
     */
    public Group setName(String value) { 
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
     * @return {@link #description} (Explanation of what the group represents and how it is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Explanation of what the group represents and how it is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Group setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Explanation of what the group represents and how it is intended to be used.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Explanation of what the group represents and how it is intended to be used.
     */
    public Group setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #quantity} (A count of the number of resource instances that are part of the group.). This is the underlying object with id, value and extensions. The accessor "getQuantity" gives direct access to the value
     */
    public UnsignedIntType getQuantityElement() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new UnsignedIntType(); // bb
      return this.quantity;
    }

    public boolean hasQuantityElement() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (A count of the number of resource instances that are part of the group.). This is the underlying object with id, value and extensions. The accessor "getQuantity" gives direct access to the value
     */
    public Group setQuantityElement(UnsignedIntType value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return A count of the number of resource instances that are part of the group.
     */
    public int getQuantity() { 
      return this.quantity == null || this.quantity.isEmpty() ? 0 : this.quantity.getValue();
    }

    /**
     * @param value A count of the number of resource instances that are part of the group.
     */
    public Group setQuantity(int value) { 
        if (this.quantity == null)
          this.quantity = new UnsignedIntType();
        this.quantity.setValue(value);
      return this;
    }

    /**
     * @return {@link #managingEntity} (Entity responsible for defining and maintaining Group characteristics and/or registered members.)
     */
    public Reference getManagingEntity() { 
      if (this.managingEntity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Group.managingEntity");
        else if (Configuration.doAutoCreate())
          this.managingEntity = new Reference(); // cc
      return this.managingEntity;
    }

    public boolean hasManagingEntity() { 
      return this.managingEntity != null && !this.managingEntity.isEmpty();
    }

    /**
     * @param value {@link #managingEntity} (Entity responsible for defining and maintaining Group characteristics and/or registered members.)
     */
    public Group setManagingEntity(Reference value) { 
      this.managingEntity = value;
      return this;
    }

    /**
     * @return {@link #characteristic} (Identifies traits whose presence r absence is shared by members of the group.)
     */
    public List<GroupCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<GroupCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Group setCharacteristic(List<GroupCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (GroupCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public GroupCharacteristicComponent addCharacteristic() { //3
      GroupCharacteristicComponent t = new GroupCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<GroupCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public Group addCharacteristic(GroupCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<GroupCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public GroupCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #member} (Identifies the resource instances that are members of the group.)
     */
    public List<GroupMemberComponent> getMember() { 
      if (this.member == null)
        this.member = new ArrayList<GroupMemberComponent>();
      return this.member;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Group setMember(List<GroupMemberComponent> theMember) { 
      this.member = theMember;
      return this;
    }

    public boolean hasMember() { 
      if (this.member == null)
        return false;
      for (GroupMemberComponent item : this.member)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public GroupMemberComponent addMember() { //3
      GroupMemberComponent t = new GroupMemberComponent();
      if (this.member == null)
        this.member = new ArrayList<GroupMemberComponent>();
      this.member.add(t);
      return t;
    }

    public Group addMember(GroupMemberComponent t) { //3
      if (t == null)
        return this;
      if (this.member == null)
        this.member = new ArrayList<GroupMemberComponent>();
      this.member.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #member}, creating it if it does not already exist {3}
     */
    public GroupMemberComponent getMemberFirstRep() { 
      if (getMember().isEmpty()) {
        addMember();
      }
      return getMember().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique business identifier for this group.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "Indicates whether the record for the group is available for use or is merely being retained for historical purposes.", 0, 1, active));
        children.add(new Property("type", "code", "Identifies the broad classification of the kind of resources the group includes.", 0, 1, type));
        children.add(new Property("membership", "code", "Basis for membership in the Group:\n\n* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.\n* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.", 0, 1, membership));
        children.add(new Property("code", "CodeableConcept", "Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc.", 0, 1, code));
        children.add(new Property("name", "string", "A label assigned to the group for human identification and communication.", 0, 1, name));
        children.add(new Property("description", "markdown", "Explanation of what the group represents and how it is intended to be used.", 0, 1, description));
        children.add(new Property("quantity", "unsignedInt", "A count of the number of resource instances that are part of the group.", 0, 1, quantity));
        children.add(new Property("managingEntity", "Reference(Organization|RelatedPerson|Practitioner|PractitionerRole)", "Entity responsible for defining and maintaining Group characteristics and/or registered members.", 0, 1, managingEntity));
        children.add(new Property("characteristic", "", "Identifies traits whose presence r absence is shared by members of the group.", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("member", "", "Identifies the resource instances that are members of the group.", 0, java.lang.Integer.MAX_VALUE, member));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique business identifier for this group.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "Indicates whether the record for the group is available for use or is merely being retained for historical purposes.", 0, 1, active);
        case 3575610: /*type*/  return new Property("type", "code", "Identifies the broad classification of the kind of resources the group includes.", 0, 1, type);
        case -1340241962: /*membership*/  return new Property("membership", "code", "Basis for membership in the Group:\n\n* 'definitional': The Group.characteristics specified are both necessary and sufficient to determine membership. All entities that meet the criteria are considered to be members of the group, whether referenced by the group or not. If members are present, they are individuals that happen to be known as meeting the Group.characteristics. The list cannot be presumed to be complete.\n* 'enumerated': The Group.characteristics are necessary but not sufficient to determine membership. Membership is determined by being listed as one of the Group.member.", 0, 1, membership);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Provides a specific type of resource the group includes; e.g. \"cow\", \"syringe\", etc.", 0, 1, code);
        case 3373707: /*name*/  return new Property("name", "string", "A label assigned to the group for human identification and communication.", 0, 1, name);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Explanation of what the group represents and how it is intended to be used.", 0, 1, description);
        case -1285004149: /*quantity*/  return new Property("quantity", "unsignedInt", "A count of the number of resource instances that are part of the group.", 0, 1, quantity);
        case -988474523: /*managingEntity*/  return new Property("managingEntity", "Reference(Organization|RelatedPerson|Practitioner|PractitionerRole)", "Entity responsible for defining and maintaining Group characteristics and/or registered members.", 0, 1, managingEntity);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "Identifies traits whose presence r absence is shared by members of the group.", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case -1077769574: /*member*/  return new Property("member", "", "Identifies the resource instances that are members of the group.", 0, java.lang.Integer.MAX_VALUE, member);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<GroupType>
        case -1340241962: /*membership*/ return this.membership == null ? new Base[0] : new Base[] {this.membership}; // Enumeration<GroupMembershipBasis>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // UnsignedIntType
        case -988474523: /*managingEntity*/ return this.managingEntity == null ? new Base[0] : new Base[] {this.managingEntity}; // Reference
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // GroupCharacteristicComponent
        case -1077769574: /*member*/ return this.member == null ? new Base[0] : this.member.toArray(new Base[this.member.size()]); // GroupMemberComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1422950650: // active
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3575610: // type
          value = new GroupTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<GroupType>
          return value;
        case -1340241962: // membership
          value = new GroupMembershipBasisEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.membership = (Enumeration) value; // Enumeration<GroupMembershipBasis>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -988474523: // managingEntity
          this.managingEntity = TypeConvertor.castToReference(value); // Reference
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((GroupCharacteristicComponent) value); // GroupCharacteristicComponent
          return value;
        case -1077769574: // member
          this.getMember().add((GroupMemberComponent) value); // GroupMemberComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("active")) {
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("type")) {
          value = new GroupTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<GroupType>
        } else if (name.equals("membership")) {
          value = new GroupMembershipBasisEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.membership = (Enumeration) value; // Enumeration<GroupMembershipBasis>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("managingEntity")) {
          this.managingEntity = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((GroupCharacteristicComponent) value);
        } else if (name.equals("member")) {
          this.getMember().add((GroupMemberComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case 3575610:  return getTypeElement();
        case -1340241962:  return getMembershipElement();
        case 3059181:  return getCode();
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case -1285004149:  return getQuantityElement();
        case -988474523:  return getManagingEntity();
        case 366313883:  return addCharacteristic(); 
        case -1077769574:  return addMember(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1422950650: /*active*/ return new String[] {"boolean"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -1340241962: /*membership*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1285004149: /*quantity*/ return new String[] {"unsignedInt"};
        case -988474523: /*managingEntity*/ return new String[] {"Reference"};
        case 366313883: /*characteristic*/ return new String[] {};
        case -1077769574: /*member*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.active");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.type");
        }
        else if (name.equals("membership")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.membership");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.description");
        }
        else if (name.equals("quantity")) {
          throw new FHIRException("Cannot call addChild on a primitive type Group.quantity");
        }
        else if (name.equals("managingEntity")) {
          this.managingEntity = new Reference();
          return this.managingEntity;
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("member")) {
          return addMember();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Group";

  }

      public Group copy() {
        Group dst = new Group();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Group dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        dst.type = type == null ? null : type.copy();
        dst.membership = membership == null ? null : membership.copy();
        dst.code = code == null ? null : code.copy();
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.managingEntity = managingEntity == null ? null : managingEntity.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<GroupCharacteristicComponent>();
          for (GroupCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (member != null) {
          dst.member = new ArrayList<GroupMemberComponent>();
          for (GroupMemberComponent i : member)
            dst.member.add(i.copy());
        };
      }

      protected Group typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Group))
          return false;
        Group o = (Group) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(type, o.type, true)
           && compareDeep(membership, o.membership, true) && compareDeep(code, o.code, true) && compareDeep(name, o.name, true)
           && compareDeep(description, o.description, true) && compareDeep(quantity, o.quantity, true) && compareDeep(managingEntity, o.managingEntity, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(member, o.member, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Group))
          return false;
        Group o = (Group) other_;
        return compareValues(active, o.active, true) && compareValues(type, o.type, true) && compareValues(membership, o.membership, true)
           && compareValues(name, o.name, true) && compareValues(description, o.description, true) && compareValues(quantity, o.quantity, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, type
          , membership, code, name, description, quantity, managingEntity, characteristic
          , member);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Group;
   }

 /**
   * Search parameter: <b>characteristic-reference</b>
   * <p>
   * Description: <b>An entity referenced in a characteristic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(Group.characteristic.value.ofType(Reference))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic-reference", path="(Group.characteristic.value.ofType(Reference))", description="An entity referenced in a characteristic", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_CHARACTERISTIC_REFERENCE = "characteristic-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic-reference</b>
   * <p>
   * Description: <b>An entity referenced in a characteristic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(Group.characteristic.value.ofType(Reference))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CHARACTERISTIC_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CHARACTERISTIC_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Group:characteristic-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CHARACTERISTIC_REFERENCE = new ca.uhn.fhir.model.api.Include("Group:characteristic-reference").toLocked();

 /**
   * Search parameter: <b>characteristic-value</b>
   * <p>
   * Description: <b>A composite of both characteristic and value</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Group.characteristic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic-value", path="Group.characteristic", description="A composite of both characteristic and value", type="composite", compositeOf={"characteristic", "value"} )
  public static final String SP_CHARACTERISTIC_VALUE = "characteristic-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic-value</b>
   * <p>
   * Description: <b>A composite of both characteristic and value</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Group.characteristic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CHARACTERISTIC_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CHARACTERISTIC_VALUE);

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>Kind of characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="Group.characteristic.code", description="Kind of characteristic", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>Kind of characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The kind of resources contained</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="Group.code", description="The kind of resources contained", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The kind of resources contained</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>exclude</b>
   * <p>
   * Description: <b>Group includes or excludes</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.exclude</b><br>
   * </p>
   */
  @SearchParamDefinition(name="exclude", path="Group.characteristic.exclude", description="Group includes or excludes", type="token" )
  public static final String SP_EXCLUDE = "exclude";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>exclude</b>
   * <p>
   * Description: <b>Group includes or excludes</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.characteristic.exclude</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXCLUDE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EXCLUDE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique id</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Group.identifier", description="Unique id", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique id</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>managing-entity</b>
   * <p>
   * Description: <b>Entity that is the custodian of the Group's definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.managingEntity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="managing-entity", path="Group.managingEntity", description="Entity that is the custodian of the Group's definition", type="reference", target={Organization.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_MANAGING_ENTITY = "managing-entity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>managing-entity</b>
   * <p>
   * Description: <b>Entity that is the custodian of the Group's definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.managingEntity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANAGING_ENTITY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANAGING_ENTITY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Group:managing-entity</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANAGING_ENTITY = new ca.uhn.fhir.model.api.Include("Group:managing-entity").toLocked();

 /**
   * Search parameter: <b>member</b>
   * <p>
   * Description: <b>Reference to the group member</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.member.entity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="member", path="Group.member.entity", description="Reference to the group member", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Specimen.class } )
  public static final String SP_MEMBER = "member";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>member</b>
   * <p>
   * Description: <b>Reference to the group member</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Group.member.entity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEMBER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MEMBER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Group:member</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEMBER = new ca.uhn.fhir.model.api.Include("Group:member").toLocked();

 /**
   * Search parameter: <b>membership</b>
   * <p>
   * Description: <b>Definitional or enumerated group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.membership</b><br>
   * </p>
   */
  @SearchParamDefinition(name="membership", path="Group.membership", description="Definitional or enumerated group", type="token" )
  public static final String SP_MEMBERSHIP = "membership";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>membership</b>
   * <p>
   * Description: <b>Definitional or enumerated group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.membership</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MEMBERSHIP = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MEMBERSHIP);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A portion of the Group's name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Group.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="Group.name", description="A portion of the Group's name", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A portion of the Group's name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Group.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of resources the group contains</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Group.type", description="The type of resources the group contains", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of resources the group contains</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Group.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>value</b>
   * <p>
   * Description: <b>Value held by characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Group.characteristic.value.ofType(CodeableConcept)) | (Group.characteristic.value.ofType(boolean))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="value", path="(Group.characteristic.value.ofType(CodeableConcept)) | (Group.characteristic.value.ofType(boolean))", description="Value held by characteristic", type="token" )
  public static final String SP_VALUE = "value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>value</b>
   * <p>
   * Description: <b>Value held by characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Group.characteristic.value.ofType(CodeableConcept)) | (Group.characteristic.value.ofType(boolean))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VALUE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VALUE);


}

