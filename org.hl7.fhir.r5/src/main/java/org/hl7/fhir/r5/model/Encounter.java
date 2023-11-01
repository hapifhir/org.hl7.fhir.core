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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

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
 * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).
 */
@ResourceDef(name="Encounter", profile="http://hl7.org/fhir/StructureDefinition/Encounter")
public class Encounter extends DomainResource {

    public enum EncounterLocationStatus {
        /**
         * The patient is planned to be moved to this location at some point in the future.
         */
        PLANNED, 
        /**
         * The patient is currently at this location, or was between the period specified.\r\rA system may update these records when the patient leaves the location to either reserved, or completed.
         */
        ACTIVE, 
        /**
         * This location is held empty for this patient.
         */
        RESERVED, 
        /**
         * The patient was at this location during the period specified.\r\rNot to be used when the patient is currently at the location.
         */
        COMPLETED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EncounterLocationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return PLANNED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("reserved".equals(codeString))
          return RESERVED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EncounterLocationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PLANNED: return "planned";
            case ACTIVE: return "active";
            case RESERVED: return "reserved";
            case COMPLETED: return "completed";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PLANNED: return "http://hl7.org/fhir/encounter-location-status";
            case ACTIVE: return "http://hl7.org/fhir/encounter-location-status";
            case RESERVED: return "http://hl7.org/fhir/encounter-location-status";
            case COMPLETED: return "http://hl7.org/fhir/encounter-location-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PLANNED: return "The patient is planned to be moved to this location at some point in the future.";
            case ACTIVE: return "The patient is currently at this location, or was between the period specified.\r\rA system may update these records when the patient leaves the location to either reserved, or completed.";
            case RESERVED: return "This location is held empty for this patient.";
            case COMPLETED: return "The patient was at this location during the period specified.\r\rNot to be used when the patient is currently at the location.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PLANNED: return "Planned";
            case ACTIVE: return "Active";
            case RESERVED: return "Reserved";
            case COMPLETED: return "Completed";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EncounterLocationStatusEnumFactory implements EnumFactory<EncounterLocationStatus> {
    public EncounterLocationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return EncounterLocationStatus.PLANNED;
        if ("active".equals(codeString))
          return EncounterLocationStatus.ACTIVE;
        if ("reserved".equals(codeString))
          return EncounterLocationStatus.RESERVED;
        if ("completed".equals(codeString))
          return EncounterLocationStatus.COMPLETED;
        throw new IllegalArgumentException("Unknown EncounterLocationStatus code '"+codeString+"'");
        }
        public Enumeration<EncounterLocationStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.NULL, code);
        if ("planned".equals(codeString))
          return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.PLANNED, code);
        if ("active".equals(codeString))
          return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.ACTIVE, code);
        if ("reserved".equals(codeString))
          return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.RESERVED, code);
        if ("completed".equals(codeString))
          return new Enumeration<EncounterLocationStatus>(this, EncounterLocationStatus.COMPLETED, code);
        throw new FHIRException("Unknown EncounterLocationStatus code '"+codeString+"'");
        }
    public String toCode(EncounterLocationStatus code) {
      if (code == EncounterLocationStatus.PLANNED)
        return "planned";
      if (code == EncounterLocationStatus.ACTIVE)
        return "active";
      if (code == EncounterLocationStatus.RESERVED)
        return "reserved";
      if (code == EncounterLocationStatus.COMPLETED)
        return "completed";
      return "?";
      }
    public String toSystem(EncounterLocationStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class EncounterParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Role of participant in encounter.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Role of participant in encounter", formalDefinition="Role of participant in encounter." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-participant-type")
        protected List<CodeableConcept> type;

        /**
         * The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Period of time during the encounter that the participant participated", formalDefinition="The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period." )
        protected Period period;

        /**
         * Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times.
         */
        @Child(name = "actor", type = {Patient.class, Group.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class, Device.class, HealthcareService.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The individual, device, or service participating in the encounter", formalDefinition="Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times." )
        protected Reference actor;

        private static final long serialVersionUID = 1982623707L;

    /**
     * Constructor
     */
      public EncounterParticipantComponent() {
        super();
      }

        /**
         * @return {@link #type} (Role of participant in encounter.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EncounterParticipantComponent setType(List<CodeableConcept> theType) { 
          this.type = theType;
          return this;
        }

        public boolean hasType() { 
          if (this.type == null)
            return false;
          for (CodeableConcept item : this.type)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return t;
        }

        public EncounterParticipantComponent addType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTypeFirstRep() { 
          if (getType().isEmpty()) {
            addType();
          }
          return getType().get(0);
        }

        /**
         * @return {@link #period} (The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterParticipantComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period.)
         */
        public EncounterParticipantComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #actor} (Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times.)
         */
        public EncounterParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Role of participant in encounter.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("period", "Period", "The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period.", 0, 1, period));
          children.add(new Property("actor", "Reference(Patient|Group|RelatedPerson|Practitioner|PractitionerRole|Device|HealthcareService)", "Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Role of participant in encounter.", 0, java.lang.Integer.MAX_VALUE, type);
          case -991726143: /*period*/  return new Property("period", "Period", "The period of time that the specified participant participated in the encounter. These can overlap or be sub-sets of the overall encounter's period.", 0, 1, period);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Patient|Group|RelatedPerson|Practitioner|PractitionerRole|Device|HealthcareService)", "Person involved in the encounter, the patient/group is also included here to indicate that the patient was actually participating in the encounter. Not including the patient here covers use cases such as a case meeting between practitioners about a patient - non contact times.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().remove(value);
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("actor")) {
          this.actor = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case -991726143:  return getPeriod();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public EncounterParticipantComponent copy() {
        EncounterParticipantComponent dst = new EncounterParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EncounterParticipantComponent dst) {
        super.copyValues(dst);
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EncounterParticipantComponent))
          return false;
        EncounterParticipantComponent o = (EncounterParticipantComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(period, o.period, true) && compareDeep(actor, o.actor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EncounterParticipantComponent))
          return false;
        EncounterParticipantComponent o = (EncounterParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, period, actor);
      }

  public String fhirType() {
    return "Encounter.participant";

  }

  }

    @Block()
    public static class ReasonComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * What the reason value should be used as e.g. Chief Complaint, Health Concern, Health Maintenance (including screening).
         */
        @Child(name = "use", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="What the reason value should be used for/as", formalDefinition="What the reason value should be used as e.g. Chief Complaint, Health Concern, Health Maintenance (including screening)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-reason-use")
        protected List<CodeableConcept> use;

        /**
         * Reason the encounter takes place, expressed as a code or a reference to another resource. For admissions, this can be used for a coded admission diagnosis.
         */
        @Child(name = "value", type = {CodeableReference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Reason the encounter takes place (core or reference)", formalDefinition="Reason the encounter takes place, expressed as a code or a reference to another resource. For admissions, this can be used for a coded admission diagnosis." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-reason")
        protected List<CodeableReference> value;

        private static final long serialVersionUID = 1305979913L;

    /**
     * Constructor
     */
      public ReasonComponent() {
        super();
      }

        /**
         * @return {@link #use} (What the reason value should be used as e.g. Chief Complaint, Health Concern, Health Maintenance (including screening).)
         */
        public List<CodeableConcept> getUse() { 
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          return this.use;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ReasonComponent setUse(List<CodeableConcept> theUse) { 
          this.use = theUse;
          return this;
        }

        public boolean hasUse() { 
          if (this.use == null)
            return false;
          for (CodeableConcept item : this.use)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addUse() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          this.use.add(t);
          return t;
        }

        public ReasonComponent addUse(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          this.use.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #use}, creating it if it does not already exist {3}
         */
        public CodeableConcept getUseFirstRep() { 
          if (getUse().isEmpty()) {
            addUse();
          }
          return getUse().get(0);
        }

        /**
         * @return {@link #value} (Reason the encounter takes place, expressed as a code or a reference to another resource. For admissions, this can be used for a coded admission diagnosis.)
         */
        public List<CodeableReference> getValue() { 
          if (this.value == null)
            this.value = new ArrayList<CodeableReference>();
          return this.value;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ReasonComponent setValue(List<CodeableReference> theValue) { 
          this.value = theValue;
          return this;
        }

        public boolean hasValue() { 
          if (this.value == null)
            return false;
          for (CodeableReference item : this.value)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addValue() { //3
          CodeableReference t = new CodeableReference();
          if (this.value == null)
            this.value = new ArrayList<CodeableReference>();
          this.value.add(t);
          return t;
        }

        public ReasonComponent addValue(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.value == null)
            this.value = new ArrayList<CodeableReference>();
          this.value.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #value}, creating it if it does not already exist {3}
         */
        public CodeableReference getValueFirstRep() { 
          if (getValue().isEmpty()) {
            addValue();
          }
          return getValue().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("use", "CodeableConcept", "What the reason value should be used as e.g. Chief Complaint, Health Concern, Health Maintenance (including screening).", 0, java.lang.Integer.MAX_VALUE, use));
          children.add(new Property("value", "CodeableReference(Condition|DiagnosticReport|Observation|ImmunizationRecommendation|Procedure)", "Reason the encounter takes place, expressed as a code or a reference to another resource. For admissions, this can be used for a coded admission diagnosis.", 0, java.lang.Integer.MAX_VALUE, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 116103: /*use*/  return new Property("use", "CodeableConcept", "What the reason value should be used as e.g. Chief Complaint, Health Concern, Health Maintenance (including screening).", 0, java.lang.Integer.MAX_VALUE, use);
          case 111972721: /*value*/  return new Property("value", "CodeableReference(Condition|DiagnosticReport|Observation|ImmunizationRecommendation|Procedure)", "Reason the encounter takes place, expressed as a code or a reference to another resource. For admissions, this can be used for a coded admission diagnosis.", 0, java.lang.Integer.MAX_VALUE, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116103: /*use*/ return this.use == null ? new Base[0] : this.use.toArray(new Base[this.use.size()]); // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : this.value.toArray(new Base[this.value.size()]); // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116103: // use
          this.getUse().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 111972721: // value
          this.getValue().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("use")) {
          this.getUse().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("value")) {
          this.getValue().add(TypeConvertor.castToCodeableReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("use")) {
          this.getUse().remove(value);
        } else if (name.equals("value")) {
          this.getValue().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116103:  return addUse(); 
        case 111972721:  return addValue(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116103: /*use*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("use")) {
          return addUse();
        }
        else if (name.equals("value")) {
          return addValue();
        }
        else
          return super.addChild(name);
      }

      public ReasonComponent copy() {
        ReasonComponent dst = new ReasonComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ReasonComponent dst) {
        super.copyValues(dst);
        if (use != null) {
          dst.use = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : use)
            dst.use.add(i.copy());
        };
        if (value != null) {
          dst.value = new ArrayList<CodeableReference>();
          for (CodeableReference i : value)
            dst.value.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ReasonComponent))
          return false;
        ReasonComponent o = (ReasonComponent) other_;
        return compareDeep(use, o.use, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ReasonComponent))
          return false;
        ReasonComponent o = (ReasonComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(use, value);
      }

  public String fhirType() {
    return "Encounter.reason";

  }

  }

    @Block()
    public static class DiagnosisComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The coded diagnosis or a reference to a Condition (with other resources referenced in the evidence.detail), the use property will indicate the purpose of this specific diagnosis.
         */
        @Child(name = "condition", type = {CodeableReference.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The diagnosis relevant to the encounter", formalDefinition="The coded diagnosis or a reference to a Condition (with other resources referenced in the evidence.detail), the use property will indicate the purpose of this specific diagnosis." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
        protected List<CodeableReference> condition;

        /**
         * Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).
         */
        @Child(name = "use", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …)", formalDefinition="Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-diagnosis-use")
        protected List<CodeableConcept> use;

        private static final long serialVersionUID = 1029565663L;

    /**
     * Constructor
     */
      public DiagnosisComponent() {
        super();
      }

        /**
         * @return {@link #condition} (The coded diagnosis or a reference to a Condition (with other resources referenced in the evidence.detail), the use property will indicate the purpose of this specific diagnosis.)
         */
        public List<CodeableReference> getCondition() { 
          if (this.condition == null)
            this.condition = new ArrayList<CodeableReference>();
          return this.condition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DiagnosisComponent setCondition(List<CodeableReference> theCondition) { 
          this.condition = theCondition;
          return this;
        }

        public boolean hasCondition() { 
          if (this.condition == null)
            return false;
          for (CodeableReference item : this.condition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addCondition() { //3
          CodeableReference t = new CodeableReference();
          if (this.condition == null)
            this.condition = new ArrayList<CodeableReference>();
          this.condition.add(t);
          return t;
        }

        public DiagnosisComponent addCondition(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.condition == null)
            this.condition = new ArrayList<CodeableReference>();
          this.condition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
         */
        public CodeableReference getConditionFirstRep() { 
          if (getCondition().isEmpty()) {
            addCondition();
          }
          return getCondition().get(0);
        }

        /**
         * @return {@link #use} (Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).)
         */
        public List<CodeableConcept> getUse() { 
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          return this.use;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DiagnosisComponent setUse(List<CodeableConcept> theUse) { 
          this.use = theUse;
          return this;
        }

        public boolean hasUse() { 
          if (this.use == null)
            return false;
          for (CodeableConcept item : this.use)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addUse() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          this.use.add(t);
          return t;
        }

        public DiagnosisComponent addUse(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.use == null)
            this.use = new ArrayList<CodeableConcept>();
          this.use.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #use}, creating it if it does not already exist {3}
         */
        public CodeableConcept getUseFirstRep() { 
          if (getUse().isEmpty()) {
            addUse();
          }
          return getUse().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("condition", "CodeableReference(Condition)", "The coded diagnosis or a reference to a Condition (with other resources referenced in the evidence.detail), the use property will indicate the purpose of this specific diagnosis.", 0, java.lang.Integer.MAX_VALUE, condition));
          children.add(new Property("use", "CodeableConcept", "Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).", 0, java.lang.Integer.MAX_VALUE, use));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -861311717: /*condition*/  return new Property("condition", "CodeableReference(Condition)", "The coded diagnosis or a reference to a Condition (with other resources referenced in the evidence.detail), the use property will indicate the purpose of this specific diagnosis.", 0, java.lang.Integer.MAX_VALUE, condition);
          case 116103: /*use*/  return new Property("use", "CodeableConcept", "Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).", 0, java.lang.Integer.MAX_VALUE, use);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // CodeableReference
        case 116103: /*use*/ return this.use == null ? new Base[0] : this.use.toArray(new Base[this.use.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -861311717: // condition
          this.getCondition().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 116103: // use
          this.getUse().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("condition")) {
          this.getCondition().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("use")) {
          this.getUse().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("condition")) {
          this.getCondition().remove(value);
        } else if (name.equals("use")) {
          this.getUse().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -861311717:  return addCondition(); 
        case 116103:  return addUse(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -861311717: /*condition*/ return new String[] {"CodeableReference"};
        case 116103: /*use*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("condition")) {
          return addCondition();
        }
        else if (name.equals("use")) {
          return addUse();
        }
        else
          return super.addChild(name);
      }

      public DiagnosisComponent copy() {
        DiagnosisComponent dst = new DiagnosisComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DiagnosisComponent dst) {
        super.copyValues(dst);
        if (condition != null) {
          dst.condition = new ArrayList<CodeableReference>();
          for (CodeableReference i : condition)
            dst.condition.add(i.copy());
        };
        if (use != null) {
          dst.use = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : use)
            dst.use.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DiagnosisComponent))
          return false;
        DiagnosisComponent o = (DiagnosisComponent) other_;
        return compareDeep(condition, o.condition, true) && compareDeep(use, o.use, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DiagnosisComponent))
          return false;
        DiagnosisComponent o = (DiagnosisComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(condition, use);
      }

  public String fhirType() {
    return "Encounter.diagnosis";

  }

  }

    @Block()
    public static class EncounterAdmissionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Pre-admission identifier.
         */
        @Child(name = "preAdmissionIdentifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pre-admission identifier", formalDefinition="Pre-admission identifier." )
        protected Identifier preAdmissionIdentifier;

        /**
         * The location/organization from which the patient came before admission.
         */
        @Child(name = "origin", type = {Location.class, Organization.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The location/organization from which the patient came before admission", formalDefinition="The location/organization from which the patient came before admission." )
        protected Reference origin;

        /**
         * From where patient was admitted (physician referral, transfer).
         */
        @Child(name = "admitSource", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="From where patient was admitted (physician referral, transfer)", formalDefinition="From where patient was admitted (physician referral, transfer)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-admit-source")
        protected CodeableConcept admitSource;

        /**
         * Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed.
         */
        @Child(name = "reAdmission", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates that the patient is being re-admitted", formalDefinition="Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0092")
        protected CodeableConcept reAdmission;

        /**
         * Location/organization to which the patient is discharged.
         */
        @Child(name = "destination", type = {Location.class, Organization.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Location/organization to which the patient is discharged", formalDefinition="Location/organization to which the patient is discharged." )
        protected Reference destination;

        /**
         * Category or kind of location after discharge.
         */
        @Child(name = "dischargeDisposition", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category or kind of location after discharge", formalDefinition="Category or kind of location after discharge." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-discharge-disposition")
        protected CodeableConcept dischargeDisposition;

        private static final long serialVersionUID = -1702856594L;

    /**
     * Constructor
     */
      public EncounterAdmissionComponent() {
        super();
      }

        /**
         * @return {@link #preAdmissionIdentifier} (Pre-admission identifier.)
         */
        public Identifier getPreAdmissionIdentifier() { 
          if (this.preAdmissionIdentifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.preAdmissionIdentifier");
            else if (Configuration.doAutoCreate())
              this.preAdmissionIdentifier = new Identifier(); // cc
          return this.preAdmissionIdentifier;
        }

        public boolean hasPreAdmissionIdentifier() { 
          return this.preAdmissionIdentifier != null && !this.preAdmissionIdentifier.isEmpty();
        }

        /**
         * @param value {@link #preAdmissionIdentifier} (Pre-admission identifier.)
         */
        public EncounterAdmissionComponent setPreAdmissionIdentifier(Identifier value) { 
          this.preAdmissionIdentifier = value;
          return this;
        }

        /**
         * @return {@link #origin} (The location/organization from which the patient came before admission.)
         */
        public Reference getOrigin() { 
          if (this.origin == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.origin");
            else if (Configuration.doAutoCreate())
              this.origin = new Reference(); // cc
          return this.origin;
        }

        public boolean hasOrigin() { 
          return this.origin != null && !this.origin.isEmpty();
        }

        /**
         * @param value {@link #origin} (The location/organization from which the patient came before admission.)
         */
        public EncounterAdmissionComponent setOrigin(Reference value) { 
          this.origin = value;
          return this;
        }

        /**
         * @return {@link #admitSource} (From where patient was admitted (physician referral, transfer).)
         */
        public CodeableConcept getAdmitSource() { 
          if (this.admitSource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.admitSource");
            else if (Configuration.doAutoCreate())
              this.admitSource = new CodeableConcept(); // cc
          return this.admitSource;
        }

        public boolean hasAdmitSource() { 
          return this.admitSource != null && !this.admitSource.isEmpty();
        }

        /**
         * @param value {@link #admitSource} (From where patient was admitted (physician referral, transfer).)
         */
        public EncounterAdmissionComponent setAdmitSource(CodeableConcept value) { 
          this.admitSource = value;
          return this;
        }

        /**
         * @return {@link #reAdmission} (Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed.)
         */
        public CodeableConcept getReAdmission() { 
          if (this.reAdmission == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.reAdmission");
            else if (Configuration.doAutoCreate())
              this.reAdmission = new CodeableConcept(); // cc
          return this.reAdmission;
        }

        public boolean hasReAdmission() { 
          return this.reAdmission != null && !this.reAdmission.isEmpty();
        }

        /**
         * @param value {@link #reAdmission} (Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed.)
         */
        public EncounterAdmissionComponent setReAdmission(CodeableConcept value) { 
          this.reAdmission = value;
          return this;
        }

        /**
         * @return {@link #destination} (Location/organization to which the patient is discharged.)
         */
        public Reference getDestination() { 
          if (this.destination == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.destination");
            else if (Configuration.doAutoCreate())
              this.destination = new Reference(); // cc
          return this.destination;
        }

        public boolean hasDestination() { 
          return this.destination != null && !this.destination.isEmpty();
        }

        /**
         * @param value {@link #destination} (Location/organization to which the patient is discharged.)
         */
        public EncounterAdmissionComponent setDestination(Reference value) { 
          this.destination = value;
          return this;
        }

        /**
         * @return {@link #dischargeDisposition} (Category or kind of location after discharge.)
         */
        public CodeableConcept getDischargeDisposition() { 
          if (this.dischargeDisposition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterAdmissionComponent.dischargeDisposition");
            else if (Configuration.doAutoCreate())
              this.dischargeDisposition = new CodeableConcept(); // cc
          return this.dischargeDisposition;
        }

        public boolean hasDischargeDisposition() { 
          return this.dischargeDisposition != null && !this.dischargeDisposition.isEmpty();
        }

        /**
         * @param value {@link #dischargeDisposition} (Category or kind of location after discharge.)
         */
        public EncounterAdmissionComponent setDischargeDisposition(CodeableConcept value) { 
          this.dischargeDisposition = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("preAdmissionIdentifier", "Identifier", "Pre-admission identifier.", 0, 1, preAdmissionIdentifier));
          children.add(new Property("origin", "Reference(Location|Organization)", "The location/organization from which the patient came before admission.", 0, 1, origin));
          children.add(new Property("admitSource", "CodeableConcept", "From where patient was admitted (physician referral, transfer).", 0, 1, admitSource));
          children.add(new Property("reAdmission", "CodeableConcept", "Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed.", 0, 1, reAdmission));
          children.add(new Property("destination", "Reference(Location|Organization)", "Location/organization to which the patient is discharged.", 0, 1, destination));
          children.add(new Property("dischargeDisposition", "CodeableConcept", "Category or kind of location after discharge.", 0, 1, dischargeDisposition));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -965394961: /*preAdmissionIdentifier*/  return new Property("preAdmissionIdentifier", "Identifier", "Pre-admission identifier.", 0, 1, preAdmissionIdentifier);
          case -1008619738: /*origin*/  return new Property("origin", "Reference(Location|Organization)", "The location/organization from which the patient came before admission.", 0, 1, origin);
          case 538887120: /*admitSource*/  return new Property("admitSource", "CodeableConcept", "From where patient was admitted (physician referral, transfer).", 0, 1, admitSource);
          case 669348630: /*reAdmission*/  return new Property("reAdmission", "CodeableConcept", "Indicates that this encounter is directly related to a prior admission, often because the conditions addressed in the prior admission were not fully addressed.", 0, 1, reAdmission);
          case -1429847026: /*destination*/  return new Property("destination", "Reference(Location|Organization)", "Location/organization to which the patient is discharged.", 0, 1, destination);
          case 528065941: /*dischargeDisposition*/  return new Property("dischargeDisposition", "CodeableConcept", "Category or kind of location after discharge.", 0, 1, dischargeDisposition);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -965394961: /*preAdmissionIdentifier*/ return this.preAdmissionIdentifier == null ? new Base[0] : new Base[] {this.preAdmissionIdentifier}; // Identifier
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : new Base[] {this.origin}; // Reference
        case 538887120: /*admitSource*/ return this.admitSource == null ? new Base[0] : new Base[] {this.admitSource}; // CodeableConcept
        case 669348630: /*reAdmission*/ return this.reAdmission == null ? new Base[0] : new Base[] {this.reAdmission}; // CodeableConcept
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // Reference
        case 528065941: /*dischargeDisposition*/ return this.dischargeDisposition == null ? new Base[0] : new Base[] {this.dischargeDisposition}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -965394961: // preAdmissionIdentifier
          this.preAdmissionIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -1008619738: // origin
          this.origin = TypeConvertor.castToReference(value); // Reference
          return value;
        case 538887120: // admitSource
          this.admitSource = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 669348630: // reAdmission
          this.reAdmission = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToReference(value); // Reference
          return value;
        case 528065941: // dischargeDisposition
          this.dischargeDisposition = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("preAdmissionIdentifier")) {
          this.preAdmissionIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("origin")) {
          this.origin = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("admitSource")) {
          this.admitSource = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reAdmission")) {
          this.reAdmission = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("dischargeDisposition")) {
          this.dischargeDisposition = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("preAdmissionIdentifier")) {
          this.preAdmissionIdentifier = null;
        } else if (name.equals("origin")) {
          this.origin = null;
        } else if (name.equals("admitSource")) {
          this.admitSource = null;
        } else if (name.equals("reAdmission")) {
          this.reAdmission = null;
        } else if (name.equals("destination")) {
          this.destination = null;
        } else if (name.equals("dischargeDisposition")) {
          this.dischargeDisposition = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -965394961:  return getPreAdmissionIdentifier();
        case -1008619738:  return getOrigin();
        case 538887120:  return getAdmitSource();
        case 669348630:  return getReAdmission();
        case -1429847026:  return getDestination();
        case 528065941:  return getDischargeDisposition();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -965394961: /*preAdmissionIdentifier*/ return new String[] {"Identifier"};
        case -1008619738: /*origin*/ return new String[] {"Reference"};
        case 538887120: /*admitSource*/ return new String[] {"CodeableConcept"};
        case 669348630: /*reAdmission*/ return new String[] {"CodeableConcept"};
        case -1429847026: /*destination*/ return new String[] {"Reference"};
        case 528065941: /*dischargeDisposition*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("preAdmissionIdentifier")) {
          this.preAdmissionIdentifier = new Identifier();
          return this.preAdmissionIdentifier;
        }
        else if (name.equals("origin")) {
          this.origin = new Reference();
          return this.origin;
        }
        else if (name.equals("admitSource")) {
          this.admitSource = new CodeableConcept();
          return this.admitSource;
        }
        else if (name.equals("reAdmission")) {
          this.reAdmission = new CodeableConcept();
          return this.reAdmission;
        }
        else if (name.equals("destination")) {
          this.destination = new Reference();
          return this.destination;
        }
        else if (name.equals("dischargeDisposition")) {
          this.dischargeDisposition = new CodeableConcept();
          return this.dischargeDisposition;
        }
        else
          return super.addChild(name);
      }

      public EncounterAdmissionComponent copy() {
        EncounterAdmissionComponent dst = new EncounterAdmissionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EncounterAdmissionComponent dst) {
        super.copyValues(dst);
        dst.preAdmissionIdentifier = preAdmissionIdentifier == null ? null : preAdmissionIdentifier.copy();
        dst.origin = origin == null ? null : origin.copy();
        dst.admitSource = admitSource == null ? null : admitSource.copy();
        dst.reAdmission = reAdmission == null ? null : reAdmission.copy();
        dst.destination = destination == null ? null : destination.copy();
        dst.dischargeDisposition = dischargeDisposition == null ? null : dischargeDisposition.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EncounterAdmissionComponent))
          return false;
        EncounterAdmissionComponent o = (EncounterAdmissionComponent) other_;
        return compareDeep(preAdmissionIdentifier, o.preAdmissionIdentifier, true) && compareDeep(origin, o.origin, true)
           && compareDeep(admitSource, o.admitSource, true) && compareDeep(reAdmission, o.reAdmission, true)
           && compareDeep(destination, o.destination, true) && compareDeep(dischargeDisposition, o.dischargeDisposition, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EncounterAdmissionComponent))
          return false;
        EncounterAdmissionComponent o = (EncounterAdmissionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(preAdmissionIdentifier, origin
          , admitSource, reAdmission, destination, dischargeDisposition);
      }

  public String fhirType() {
    return "Encounter.admission";

  }

  }

    @Block()
    public static class EncounterLocationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The location where the encounter takes place.
         */
        @Child(name = "location", type = {Location.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Location the encounter takes place", formalDefinition="The location where the encounter takes place." )
        protected Reference location;

        /**
         * The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.
         */
        @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="planned | active | reserved | completed", formalDefinition="The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-location-status")
        protected Enumeration<EncounterLocationStatus> status;

        /**
         * This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.
         */
        @Child(name = "form", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The physical type of the location (usually the level in the location hierarchy - bed, room, ward, virtual etc.)", formalDefinition="This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-form")
        protected CodeableConcept form;

        /**
         * Time period during which the patient was present at the location.
         */
        @Child(name = "period", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Time period during which the patient was present at the location", formalDefinition="Time period during which the patient was present at the location." )
        protected Period period;

        private static final long serialVersionUID = -1665957440L;

    /**
     * Constructor
     */
      public EncounterLocationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EncounterLocationComponent(Reference location) {
        super();
        this.setLocation(location);
      }

        /**
         * @return {@link #location} (The location where the encounter takes place.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterLocationComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (The location where the encounter takes place.)
         */
        public EncounterLocationComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #status} (The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public Enumeration<EncounterLocationStatus> getStatusElement() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterLocationComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new Enumeration<EncounterLocationStatus>(new EncounterLocationStatusEnumFactory()); // bb
          return this.status;
        }

        public boolean hasStatusElement() { 
          return this.status != null && !this.status.isEmpty();
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public EncounterLocationComponent setStatusElement(Enumeration<EncounterLocationStatus> value) { 
          this.status = value;
          return this;
        }

        /**
         * @return The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.
         */
        public EncounterLocationStatus getStatus() { 
          return this.status == null ? null : this.status.getValue();
        }

        /**
         * @param value The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.
         */
        public EncounterLocationComponent setStatus(EncounterLocationStatus value) { 
          if (value == null)
            this.status = null;
          else {
            if (this.status == null)
              this.status = new Enumeration<EncounterLocationStatus>(new EncounterLocationStatusEnumFactory());
            this.status.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #form} (This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.)
         */
        public CodeableConcept getForm() { 
          if (this.form == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterLocationComponent.form");
            else if (Configuration.doAutoCreate())
              this.form = new CodeableConcept(); // cc
          return this.form;
        }

        public boolean hasForm() { 
          return this.form != null && !this.form.isEmpty();
        }

        /**
         * @param value {@link #form} (This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.)
         */
        public EncounterLocationComponent setForm(CodeableConcept value) { 
          this.form = value;
          return this;
        }

        /**
         * @return {@link #period} (Time period during which the patient was present at the location.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterLocationComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Time period during which the patient was present at the location.)
         */
        public EncounterLocationComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("location", "Reference(Location)", "The location where the encounter takes place.", 0, 1, location));
          children.add(new Property("status", "code", "The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.", 0, 1, status));
          children.add(new Property("form", "CodeableConcept", "This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.", 0, 1, form));
          children.add(new Property("period", "Period", "Time period during which the patient was present at the location.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location where the encounter takes place.", 0, 1, location);
          case -892481550: /*status*/  return new Property("status", "code", "The status of the participants' presence at the specified location during the period specified. If the participant is no longer at the location, then the period will have an end date/time.", 0, 1, status);
          case 3148996: /*form*/  return new Property("form", "CodeableConcept", "This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.", 0, 1, form);
          case -991726143: /*period*/  return new Property("period", "Period", "Time period during which the patient was present at the location.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EncounterLocationStatus>
        case 3148996: /*form*/ return this.form == null ? new Base[0] : new Base[] {this.form}; // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -892481550: // status
          value = new EncounterLocationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterLocationStatus>
          return value;
        case 3148996: // form
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("status")) {
          value = new EncounterLocationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterLocationStatus>
        } else if (name.equals("form")) {
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("status")) {
          value = new EncounterLocationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterLocationStatus>
        } else if (name.equals("form")) {
          this.form = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637:  return getLocation();
        case -892481550:  return getStatusElement();
        case 3148996:  return getForm();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3148996: /*form*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Encounter.location.status");
        }
        else if (name.equals("form")) {
          this.form = new CodeableConcept();
          return this.form;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public EncounterLocationComponent copy() {
        EncounterLocationComponent dst = new EncounterLocationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EncounterLocationComponent dst) {
        super.copyValues(dst);
        dst.location = location == null ? null : location.copy();
        dst.status = status == null ? null : status.copy();
        dst.form = form == null ? null : form.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EncounterLocationComponent))
          return false;
        EncounterLocationComponent o = (EncounterLocationComponent) other_;
        return compareDeep(location, o.location, true) && compareDeep(status, o.status, true) && compareDeep(form, o.form, true)
           && compareDeep(period, o.period, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EncounterLocationComponent))
          return false;
        EncounterLocationComponent o = (EncounterLocationComponent) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(location, status, form, period
          );
      }

  public String fhirType() {
    return "Encounter.location";

  }

  }

    /**
     * Identifier(s) by which this encounter is known.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifier(s) by which this encounter is known", formalDefinition="Identifier(s) by which this encounter is known." )
    protected List<Identifier> identifier;

    /**
     * The current state of the encounter (not the state of the patient within the encounter - that is subjectState).
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown", formalDefinition="The current state of the encounter (not the state of the patient within the encounter - that is subjectState)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-status")
    protected Enumeration<EncounterStatus> status;

    /**
     * Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.
     */
    @Child(name = "class", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classification of patient encounter context - e.g. Inpatient, outpatient", formalDefinition="Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/encounter-class")
    protected List<CodeableConcept> class_;

    /**
     * Indicates the urgency of the encounter.
     */
    @Child(name = "priority", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates the urgency of the encounter", formalDefinition="Indicates the urgency of the encounter." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActPriority")
    protected CodeableConcept priority;

    /**
     * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specific type of encounter (e.g. e-mail consultation, surgical day-care, ...)", formalDefinition="Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-type")
    protected List<CodeableConcept> type;

    /**
     * Broad categorization of the service that is to be provided (e.g. cardiology).
     */
    @Child(name = "serviceType", type = {CodeableReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specific type of service", formalDefinition="Broad categorization of the service that is to be provided (e.g. cardiology)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-type")
    protected List<CodeableReference> serviceType;

    /**
     * The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient or group related to this encounter", formalDefinition="The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam." )
    protected Reference subject;

    /**
     * The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.
     */
    @Child(name = "subjectStatus", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The current status of the subject in relation to the Encounter", formalDefinition="The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-subject-status")
    protected CodeableConcept subjectStatus;

    /**
     * Where a specific encounter should be classified as a part of a specific episode(s) of care this field should be used. This association can facilitate grouping of related encounters together for a specific purpose, such as government reporting, issue tracking, association via a common problem.  The association is recorded on the encounter as these are typically created after the episode of care and grouped on entry rather than editing the episode of care to append another encounter to it (the episode of care could span years).
     */
    @Child(name = "episodeOfCare", type = {EpisodeOfCare.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Episode(s) of care that this encounter should be recorded against", formalDefinition="Where a specific encounter should be classified as a part of a specific episode(s) of care this field should be used. This association can facilitate grouping of related encounters together for a specific purpose, such as government reporting, issue tracking, association via a common problem.  The association is recorded on the encounter as these are typically created after the episode of care and grouped on entry rather than editing the episode of care to append another encounter to it (the episode of care could span years)." )
    protected List<Reference> episodeOfCare;

    /**
     * The request this encounter satisfies (e.g. incoming referral or procedure request).
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, MedicationRequest.class, ServiceRequest.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The request that initiated this encounter", formalDefinition="The request this encounter satisfies (e.g. incoming referral or procedure request)." )
    protected List<Reference> basedOn;

    /**
     * The group(s) of individuals, organizations that are allocated to participate in this encounter. The participants backbone will record the actuals of when these individuals participated during the encounter.
     */
    @Child(name = "careTeam", type = {CareTeam.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The group(s) that are allocated to participate in this encounter", formalDefinition="The group(s) of individuals, organizations that are allocated to participate in this encounter. The participants backbone will record the actuals of when these individuals participated during the encounter." )
    protected List<Reference> careTeam;

    /**
     * Another Encounter of which this encounter is a part of (administratively or in time).
     */
    @Child(name = "partOf", type = {Encounter.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Another Encounter this encounter is part of", formalDefinition="Another Encounter of which this encounter is a part of (administratively or in time)." )
    protected Reference partOf;

    /**
     * The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab.
     */
    @Child(name = "serviceProvider", type = {Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The organization (facility) responsible for this encounter", formalDefinition="The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab." )
    protected Reference serviceProvider;

    /**
     * The list of people responsible for providing the service.
     */
    @Child(name = "participant", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="List of participants involved in the encounter", formalDefinition="The list of people responsible for providing the service." )
    protected List<EncounterParticipantComponent> participant;

    /**
     * The appointment that scheduled this encounter.
     */
    @Child(name = "appointment", type = {Appointment.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The appointment that scheduled this encounter", formalDefinition="The appointment that scheduled this encounter." )
    protected List<Reference> appointment;

    /**
     * Connection details of a virtual service (e.g. conference call).
     */
    @Child(name = "virtualService", type = {VirtualServiceDetail.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Connection details of a virtual service (e.g. conference call)", formalDefinition="Connection details of a virtual service (e.g. conference call)." )
    protected List<VirtualServiceDetail> virtualService;

    /**
     * The actual start and end time of the encounter.
     */
    @Child(name = "actualPeriod", type = {Period.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The actual start and end time of the encounter", formalDefinition="The actual start and end time of the encounter." )
    protected Period actualPeriod;

    /**
     * The planned start date/time (or admission date) of the encounter.
     */
    @Child(name = "plannedStartDate", type = {DateTimeType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The planned start date/time (or admission date) of the encounter", formalDefinition="The planned start date/time (or admission date) of the encounter." )
    protected DateTimeType plannedStartDate;

    /**
     * The planned end date/time (or discharge date) of the encounter.
     */
    @Child(name = "plannedEndDate", type = {DateTimeType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The planned end date/time (or discharge date) of the encounter", formalDefinition="The planned end date/time (or discharge date) of the encounter." )
    protected DateTimeType plannedEndDate;

    /**
     * Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.
     */
    @Child(name = "length", type = {Duration.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Actual quantity of time the encounter lasted (less time absent)", formalDefinition="Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values." )
    protected Duration length;

    /**
     * The list of medical reasons that are expected to be addressed during the episode of care.
     */
    @Child(name = "reason", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The list of medical reasons that are expected to be addressed during the episode of care", formalDefinition="The list of medical reasons that are expected to be addressed during the episode of care." )
    protected List<ReasonComponent> reason;

    /**
     * The list of diagnosis relevant to this encounter.
     */
    @Child(name = "diagnosis", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The list of diagnosis relevant to this encounter", formalDefinition="The list of diagnosis relevant to this encounter." )
    protected List<DiagnosisComponent> diagnosis;

    /**
     * The set of accounts that may be used for billing for this Encounter.
     */
    @Child(name = "account", type = {Account.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The set of accounts that may be used for billing for this Encounter", formalDefinition="The set of accounts that may be used for billing for this Encounter." )
    protected List<Reference> account;

    /**
     * Diet preferences reported by the patient.
     */
    @Child(name = "dietPreference", type = {CodeableConcept.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Diet preferences reported by the patient", formalDefinition="Diet preferences reported by the patient." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-diet")
    protected List<CodeableConcept> dietPreference;

    /**
     * Any special requests that have been made for this encounter, such as the provision of specific equipment or other things.
     */
    @Child(name = "specialArrangement", type = {CodeableConcept.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Wheelchair, translator, stretcher, etc", formalDefinition="Any special requests that have been made for this encounter, such as the provision of specific equipment or other things." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-special-arrangements")
    protected List<CodeableConcept> specialArrangement;

    /**
     * Special courtesies that may be provided to the patient during the encounter (VIP, board member, professional courtesy).
     */
    @Child(name = "specialCourtesy", type = {CodeableConcept.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Special courtesies (VIP, board member)", formalDefinition="Special courtesies that may be provided to the patient during the encounter (VIP, board member, professional courtesy)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-special-courtesy")
    protected List<CodeableConcept> specialCourtesy;

    /**
     * Details about the stay during which a healthcare service is provided.This does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge.
     */
    @Child(name = "admission", type = {}, order=26, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details about the admission to a healthcare service", formalDefinition="Details about the stay during which a healthcare service is provided.\r\rThis does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge." )
    protected EncounterAdmissionComponent admission;

    /**
     * List of locations where  the patient has been during this encounter.
     */
    @Child(name = "location", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="List of locations where the patient has been", formalDefinition="List of locations where  the patient has been during this encounter." )
    protected List<EncounterLocationComponent> location;

    private static final long serialVersionUID = -1336316477L;

  /**
   * Constructor
   */
    public Encounter() {
      super();
    }

  /**
   * Constructor
   */
    public Encounter(EncounterStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Identifier(s) by which this encounter is known.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setIdentifier(List<Identifier> theIdentifier) { 
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

    public Encounter addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The current state of the encounter (not the state of the patient within the encounter - that is subjectState).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EncounterStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EncounterStatus>(new EncounterStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the encounter (not the state of the patient within the encounter - that is subjectState).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Encounter setStatusElement(Enumeration<EncounterStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the encounter (not the state of the patient within the encounter - that is subjectState).
     */
    public EncounterStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the encounter (not the state of the patient within the encounter - that is subjectState).
     */
    public Encounter setStatus(EncounterStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EncounterStatus>(new EncounterStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #class_} (Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.)
     */
    public List<CodeableConcept> getClass_() { 
      if (this.class_ == null)
        this.class_ = new ArrayList<CodeableConcept>();
      return this.class_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setClass_(List<CodeableConcept> theClass_) { 
      this.class_ = theClass_;
      return this;
    }

    public boolean hasClass_() { 
      if (this.class_ == null)
        return false;
      for (CodeableConcept item : this.class_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClass_() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.class_ == null)
        this.class_ = new ArrayList<CodeableConcept>();
      this.class_.add(t);
      return t;
    }

    public Encounter addClass_(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.class_ == null)
        this.class_ = new ArrayList<CodeableConcept>();
      this.class_.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #class_}, creating it if it does not already exist {3}
     */
    public CodeableConcept getClass_FirstRep() { 
      if (getClass_().isEmpty()) {
        addClass_();
      }
      return getClass_().get(0);
    }

    /**
     * @return {@link #priority} (Indicates the urgency of the encounter.)
     */
    public CodeableConcept getPriority() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.priority");
        else if (Configuration.doAutoCreate())
          this.priority = new CodeableConcept(); // cc
      return this.priority;
    }

    public boolean hasPriority() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    /**
     * @param value {@link #priority} (Indicates the urgency of the encounter.)
     */
    public Encounter setPriority(CodeableConcept value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return {@link #type} (Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setType(List<CodeableConcept> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (CodeableConcept item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public Encounter addType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #serviceType} (Broad categorization of the service that is to be provided (e.g. cardiology).)
     */
    public List<CodeableReference> getServiceType() { 
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      return this.serviceType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setServiceType(List<CodeableReference> theServiceType) { 
      this.serviceType = theServiceType;
      return this;
    }

    public boolean hasServiceType() { 
      if (this.serviceType == null)
        return false;
      for (CodeableReference item : this.serviceType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addServiceType() { //3
      CodeableReference t = new CodeableReference();
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      this.serviceType.add(t);
      return t;
    }

    public Encounter addServiceType(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      this.serviceType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #serviceType}, creating it if it does not already exist {3}
     */
    public CodeableReference getServiceTypeFirstRep() { 
      if (getServiceType().isEmpty()) {
        addServiceType();
      }
      return getServiceType().get(0);
    }

    /**
     * @return {@link #subject} (The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.)
     */
    public Encounter setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #subjectStatus} (The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.)
     */
    public CodeableConcept getSubjectStatus() { 
      if (this.subjectStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.subjectStatus");
        else if (Configuration.doAutoCreate())
          this.subjectStatus = new CodeableConcept(); // cc
      return this.subjectStatus;
    }

    public boolean hasSubjectStatus() { 
      return this.subjectStatus != null && !this.subjectStatus.isEmpty();
    }

    /**
     * @param value {@link #subjectStatus} (The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.)
     */
    public Encounter setSubjectStatus(CodeableConcept value) { 
      this.subjectStatus = value;
      return this;
    }

    /**
     * @return {@link #episodeOfCare} (Where a specific encounter should be classified as a part of a specific episode(s) of care this field should be used. This association can facilitate grouping of related encounters together for a specific purpose, such as government reporting, issue tracking, association via a common problem.  The association is recorded on the encounter as these are typically created after the episode of care and grouped on entry rather than editing the episode of care to append another encounter to it (the episode of care could span years).)
     */
    public List<Reference> getEpisodeOfCare() { 
      if (this.episodeOfCare == null)
        this.episodeOfCare = new ArrayList<Reference>();
      return this.episodeOfCare;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setEpisodeOfCare(List<Reference> theEpisodeOfCare) { 
      this.episodeOfCare = theEpisodeOfCare;
      return this;
    }

    public boolean hasEpisodeOfCare() { 
      if (this.episodeOfCare == null)
        return false;
      for (Reference item : this.episodeOfCare)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEpisodeOfCare() { //3
      Reference t = new Reference();
      if (this.episodeOfCare == null)
        this.episodeOfCare = new ArrayList<Reference>();
      this.episodeOfCare.add(t);
      return t;
    }

    public Encounter addEpisodeOfCare(Reference t) { //3
      if (t == null)
        return this;
      if (this.episodeOfCare == null)
        this.episodeOfCare = new ArrayList<Reference>();
      this.episodeOfCare.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #episodeOfCare}, creating it if it does not already exist {3}
     */
    public Reference getEpisodeOfCareFirstRep() { 
      if (getEpisodeOfCare().isEmpty()) {
        addEpisodeOfCare();
      }
      return getEpisodeOfCare().get(0);
    }

    /**
     * @return {@link #basedOn} (The request this encounter satisfies (e.g. incoming referral or procedure request).)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public Encounter addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #careTeam} (The group(s) of individuals, organizations that are allocated to participate in this encounter. The participants backbone will record the actuals of when these individuals participated during the encounter.)
     */
    public List<Reference> getCareTeam() { 
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      return this.careTeam;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setCareTeam(List<Reference> theCareTeam) { 
      this.careTeam = theCareTeam;
      return this;
    }

    public boolean hasCareTeam() { 
      if (this.careTeam == null)
        return false;
      for (Reference item : this.careTeam)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addCareTeam() { //3
      Reference t = new Reference();
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      this.careTeam.add(t);
      return t;
    }

    public Encounter addCareTeam(Reference t) { //3
      if (t == null)
        return this;
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      this.careTeam.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #careTeam}, creating it if it does not already exist {3}
     */
    public Reference getCareTeamFirstRep() { 
      if (getCareTeam().isEmpty()) {
        addCareTeam();
      }
      return getCareTeam().get(0);
    }

    /**
     * @return {@link #partOf} (Another Encounter of which this encounter is a part of (administratively or in time).)
     */
    public Reference getPartOf() { 
      if (this.partOf == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.partOf");
        else if (Configuration.doAutoCreate())
          this.partOf = new Reference(); // cc
      return this.partOf;
    }

    public boolean hasPartOf() { 
      return this.partOf != null && !this.partOf.isEmpty();
    }

    /**
     * @param value {@link #partOf} (Another Encounter of which this encounter is a part of (administratively or in time).)
     */
    public Encounter setPartOf(Reference value) { 
      this.partOf = value;
      return this;
    }

    /**
     * @return {@link #serviceProvider} (The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab.)
     */
    public Reference getServiceProvider() { 
      if (this.serviceProvider == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.serviceProvider");
        else if (Configuration.doAutoCreate())
          this.serviceProvider = new Reference(); // cc
      return this.serviceProvider;
    }

    public boolean hasServiceProvider() { 
      return this.serviceProvider != null && !this.serviceProvider.isEmpty();
    }

    /**
     * @param value {@link #serviceProvider} (The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab.)
     */
    public Encounter setServiceProvider(Reference value) { 
      this.serviceProvider = value;
      return this;
    }

    /**
     * @return {@link #participant} (The list of people responsible for providing the service.)
     */
    public List<EncounterParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<EncounterParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setParticipant(List<EncounterParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (EncounterParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EncounterParticipantComponent addParticipant() { //3
      EncounterParticipantComponent t = new EncounterParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<EncounterParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public Encounter addParticipant(EncounterParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<EncounterParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public EncounterParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #appointment} (The appointment that scheduled this encounter.)
     */
    public List<Reference> getAppointment() { 
      if (this.appointment == null)
        this.appointment = new ArrayList<Reference>();
      return this.appointment;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setAppointment(List<Reference> theAppointment) { 
      this.appointment = theAppointment;
      return this;
    }

    public boolean hasAppointment() { 
      if (this.appointment == null)
        return false;
      for (Reference item : this.appointment)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAppointment() { //3
      Reference t = new Reference();
      if (this.appointment == null)
        this.appointment = new ArrayList<Reference>();
      this.appointment.add(t);
      return t;
    }

    public Encounter addAppointment(Reference t) { //3
      if (t == null)
        return this;
      if (this.appointment == null)
        this.appointment = new ArrayList<Reference>();
      this.appointment.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #appointment}, creating it if it does not already exist {3}
     */
    public Reference getAppointmentFirstRep() { 
      if (getAppointment().isEmpty()) {
        addAppointment();
      }
      return getAppointment().get(0);
    }

    /**
     * @return {@link #virtualService} (Connection details of a virtual service (e.g. conference call).)
     */
    public List<VirtualServiceDetail> getVirtualService() { 
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      return this.virtualService;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setVirtualService(List<VirtualServiceDetail> theVirtualService) { 
      this.virtualService = theVirtualService;
      return this;
    }

    public boolean hasVirtualService() { 
      if (this.virtualService == null)
        return false;
      for (VirtualServiceDetail item : this.virtualService)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public VirtualServiceDetail addVirtualService() { //3
      VirtualServiceDetail t = new VirtualServiceDetail();
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      this.virtualService.add(t);
      return t;
    }

    public Encounter addVirtualService(VirtualServiceDetail t) { //3
      if (t == null)
        return this;
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      this.virtualService.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #virtualService}, creating it if it does not already exist {3}
     */
    public VirtualServiceDetail getVirtualServiceFirstRep() { 
      if (getVirtualService().isEmpty()) {
        addVirtualService();
      }
      return getVirtualService().get(0);
    }

    /**
     * @return {@link #actualPeriod} (The actual start and end time of the encounter.)
     */
    public Period getActualPeriod() { 
      if (this.actualPeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.actualPeriod");
        else if (Configuration.doAutoCreate())
          this.actualPeriod = new Period(); // cc
      return this.actualPeriod;
    }

    public boolean hasActualPeriod() { 
      return this.actualPeriod != null && !this.actualPeriod.isEmpty();
    }

    /**
     * @param value {@link #actualPeriod} (The actual start and end time of the encounter.)
     */
    public Encounter setActualPeriod(Period value) { 
      this.actualPeriod = value;
      return this;
    }

    /**
     * @return {@link #plannedStartDate} (The planned start date/time (or admission date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedStartDate" gives direct access to the value
     */
    public DateTimeType getPlannedStartDateElement() { 
      if (this.plannedStartDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.plannedStartDate");
        else if (Configuration.doAutoCreate())
          this.plannedStartDate = new DateTimeType(); // bb
      return this.plannedStartDate;
    }

    public boolean hasPlannedStartDateElement() { 
      return this.plannedStartDate != null && !this.plannedStartDate.isEmpty();
    }

    public boolean hasPlannedStartDate() { 
      return this.plannedStartDate != null && !this.plannedStartDate.isEmpty();
    }

    /**
     * @param value {@link #plannedStartDate} (The planned start date/time (or admission date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedStartDate" gives direct access to the value
     */
    public Encounter setPlannedStartDateElement(DateTimeType value) { 
      this.plannedStartDate = value;
      return this;
    }

    /**
     * @return The planned start date/time (or admission date) of the encounter.
     */
    public Date getPlannedStartDate() { 
      return this.plannedStartDate == null ? null : this.plannedStartDate.getValue();
    }

    /**
     * @param value The planned start date/time (or admission date) of the encounter.
     */
    public Encounter setPlannedStartDate(Date value) { 
      if (value == null)
        this.plannedStartDate = null;
      else {
        if (this.plannedStartDate == null)
          this.plannedStartDate = new DateTimeType();
        this.plannedStartDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #plannedEndDate} (The planned end date/time (or discharge date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedEndDate" gives direct access to the value
     */
    public DateTimeType getPlannedEndDateElement() { 
      if (this.plannedEndDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.plannedEndDate");
        else if (Configuration.doAutoCreate())
          this.plannedEndDate = new DateTimeType(); // bb
      return this.plannedEndDate;
    }

    public boolean hasPlannedEndDateElement() { 
      return this.plannedEndDate != null && !this.plannedEndDate.isEmpty();
    }

    public boolean hasPlannedEndDate() { 
      return this.plannedEndDate != null && !this.plannedEndDate.isEmpty();
    }

    /**
     * @param value {@link #plannedEndDate} (The planned end date/time (or discharge date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedEndDate" gives direct access to the value
     */
    public Encounter setPlannedEndDateElement(DateTimeType value) { 
      this.plannedEndDate = value;
      return this;
    }

    /**
     * @return The planned end date/time (or discharge date) of the encounter.
     */
    public Date getPlannedEndDate() { 
      return this.plannedEndDate == null ? null : this.plannedEndDate.getValue();
    }

    /**
     * @param value The planned end date/time (or discharge date) of the encounter.
     */
    public Encounter setPlannedEndDate(Date value) { 
      if (value == null)
        this.plannedEndDate = null;
      else {
        if (this.plannedEndDate == null)
          this.plannedEndDate = new DateTimeType();
        this.plannedEndDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #length} (Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.)
     */
    public Duration getLength() { 
      if (this.length == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.length");
        else if (Configuration.doAutoCreate())
          this.length = new Duration(); // cc
      return this.length;
    }

    public boolean hasLength() { 
      return this.length != null && !this.length.isEmpty();
    }

    /**
     * @param value {@link #length} (Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.)
     */
    public Encounter setLength(Duration value) { 
      this.length = value;
      return this;
    }

    /**
     * @return {@link #reason} (The list of medical reasons that are expected to be addressed during the episode of care.)
     */
    public List<ReasonComponent> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<ReasonComponent>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setReason(List<ReasonComponent> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (ReasonComponent item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ReasonComponent addReason() { //3
      ReasonComponent t = new ReasonComponent();
      if (this.reason == null)
        this.reason = new ArrayList<ReasonComponent>();
      this.reason.add(t);
      return t;
    }

    public Encounter addReason(ReasonComponent t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<ReasonComponent>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public ReasonComponent getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #diagnosis} (The list of diagnosis relevant to this encounter.)
     */
    public List<DiagnosisComponent> getDiagnosis() { 
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      return this.diagnosis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setDiagnosis(List<DiagnosisComponent> theDiagnosis) { 
      this.diagnosis = theDiagnosis;
      return this;
    }

    public boolean hasDiagnosis() { 
      if (this.diagnosis == null)
        return false;
      for (DiagnosisComponent item : this.diagnosis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DiagnosisComponent addDiagnosis() { //3
      DiagnosisComponent t = new DiagnosisComponent();
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      this.diagnosis.add(t);
      return t;
    }

    public Encounter addDiagnosis(DiagnosisComponent t) { //3
      if (t == null)
        return this;
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      this.diagnosis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #diagnosis}, creating it if it does not already exist {3}
     */
    public DiagnosisComponent getDiagnosisFirstRep() { 
      if (getDiagnosis().isEmpty()) {
        addDiagnosis();
      }
      return getDiagnosis().get(0);
    }

    /**
     * @return {@link #account} (The set of accounts that may be used for billing for this Encounter.)
     */
    public List<Reference> getAccount() { 
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      return this.account;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setAccount(List<Reference> theAccount) { 
      this.account = theAccount;
      return this;
    }

    public boolean hasAccount() { 
      if (this.account == null)
        return false;
      for (Reference item : this.account)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAccount() { //3
      Reference t = new Reference();
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      this.account.add(t);
      return t;
    }

    public Encounter addAccount(Reference t) { //3
      if (t == null)
        return this;
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      this.account.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #account}, creating it if it does not already exist {3}
     */
    public Reference getAccountFirstRep() { 
      if (getAccount().isEmpty()) {
        addAccount();
      }
      return getAccount().get(0);
    }

    /**
     * @return {@link #dietPreference} (Diet preferences reported by the patient.)
     */
    public List<CodeableConcept> getDietPreference() { 
      if (this.dietPreference == null)
        this.dietPreference = new ArrayList<CodeableConcept>();
      return this.dietPreference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setDietPreference(List<CodeableConcept> theDietPreference) { 
      this.dietPreference = theDietPreference;
      return this;
    }

    public boolean hasDietPreference() { 
      if (this.dietPreference == null)
        return false;
      for (CodeableConcept item : this.dietPreference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addDietPreference() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.dietPreference == null)
        this.dietPreference = new ArrayList<CodeableConcept>();
      this.dietPreference.add(t);
      return t;
    }

    public Encounter addDietPreference(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.dietPreference == null)
        this.dietPreference = new ArrayList<CodeableConcept>();
      this.dietPreference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dietPreference}, creating it if it does not already exist {3}
     */
    public CodeableConcept getDietPreferenceFirstRep() { 
      if (getDietPreference().isEmpty()) {
        addDietPreference();
      }
      return getDietPreference().get(0);
    }

    /**
     * @return {@link #specialArrangement} (Any special requests that have been made for this encounter, such as the provision of specific equipment or other things.)
     */
    public List<CodeableConcept> getSpecialArrangement() { 
      if (this.specialArrangement == null)
        this.specialArrangement = new ArrayList<CodeableConcept>();
      return this.specialArrangement;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setSpecialArrangement(List<CodeableConcept> theSpecialArrangement) { 
      this.specialArrangement = theSpecialArrangement;
      return this;
    }

    public boolean hasSpecialArrangement() { 
      if (this.specialArrangement == null)
        return false;
      for (CodeableConcept item : this.specialArrangement)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSpecialArrangement() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.specialArrangement == null)
        this.specialArrangement = new ArrayList<CodeableConcept>();
      this.specialArrangement.add(t);
      return t;
    }

    public Encounter addSpecialArrangement(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.specialArrangement == null)
        this.specialArrangement = new ArrayList<CodeableConcept>();
      this.specialArrangement.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specialArrangement}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSpecialArrangementFirstRep() { 
      if (getSpecialArrangement().isEmpty()) {
        addSpecialArrangement();
      }
      return getSpecialArrangement().get(0);
    }

    /**
     * @return {@link #specialCourtesy} (Special courtesies that may be provided to the patient during the encounter (VIP, board member, professional courtesy).)
     */
    public List<CodeableConcept> getSpecialCourtesy() { 
      if (this.specialCourtesy == null)
        this.specialCourtesy = new ArrayList<CodeableConcept>();
      return this.specialCourtesy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setSpecialCourtesy(List<CodeableConcept> theSpecialCourtesy) { 
      this.specialCourtesy = theSpecialCourtesy;
      return this;
    }

    public boolean hasSpecialCourtesy() { 
      if (this.specialCourtesy == null)
        return false;
      for (CodeableConcept item : this.specialCourtesy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSpecialCourtesy() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.specialCourtesy == null)
        this.specialCourtesy = new ArrayList<CodeableConcept>();
      this.specialCourtesy.add(t);
      return t;
    }

    public Encounter addSpecialCourtesy(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.specialCourtesy == null)
        this.specialCourtesy = new ArrayList<CodeableConcept>();
      this.specialCourtesy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specialCourtesy}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSpecialCourtesyFirstRep() { 
      if (getSpecialCourtesy().isEmpty()) {
        addSpecialCourtesy();
      }
      return getSpecialCourtesy().get(0);
    }

    /**
     * @return {@link #admission} (Details about the stay during which a healthcare service is provided.This does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge.)
     */
    public EncounterAdmissionComponent getAdmission() { 
      if (this.admission == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Encounter.admission");
        else if (Configuration.doAutoCreate())
          this.admission = new EncounterAdmissionComponent(); // cc
      return this.admission;
    }

    public boolean hasAdmission() { 
      return this.admission != null && !this.admission.isEmpty();
    }

    /**
     * @param value {@link #admission} (Details about the stay during which a healthcare service is provided.This does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge.)
     */
    public Encounter setAdmission(EncounterAdmissionComponent value) { 
      this.admission = value;
      return this;
    }

    /**
     * @return {@link #location} (List of locations where  the patient has been during this encounter.)
     */
    public List<EncounterLocationComponent> getLocation() { 
      if (this.location == null)
        this.location = new ArrayList<EncounterLocationComponent>();
      return this.location;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Encounter setLocation(List<EncounterLocationComponent> theLocation) { 
      this.location = theLocation;
      return this;
    }

    public boolean hasLocation() { 
      if (this.location == null)
        return false;
      for (EncounterLocationComponent item : this.location)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EncounterLocationComponent addLocation() { //3
      EncounterLocationComponent t = new EncounterLocationComponent();
      if (this.location == null)
        this.location = new ArrayList<EncounterLocationComponent>();
      this.location.add(t);
      return t;
    }

    public Encounter addLocation(EncounterLocationComponent t) { //3
      if (t == null)
        return this;
      if (this.location == null)
        this.location = new ArrayList<EncounterLocationComponent>();
      this.location.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #location}, creating it if it does not already exist {3}
     */
    public EncounterLocationComponent getLocationFirstRep() { 
      if (getLocation().isEmpty()) {
        addLocation();
      }
      return getLocation().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier(s) by which this encounter is known.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the encounter (not the state of the patient within the encounter - that is subjectState).", 0, 1, status));
        children.add(new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, java.lang.Integer.MAX_VALUE, class_));
        children.add(new Property("priority", "CodeableConcept", "Indicates the urgency of the encounter.", 0, 1, priority));
        children.add(new Property("type", "CodeableConcept", "Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("serviceType", "CodeableReference(HealthcareService)", "Broad categorization of the service that is to be provided (e.g. cardiology).", 0, java.lang.Integer.MAX_VALUE, serviceType));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.", 0, 1, subject));
        children.add(new Property("subjectStatus", "CodeableConcept", "The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.", 0, 1, subjectStatus));
        children.add(new Property("episodeOfCare", "Reference(EpisodeOfCare)", "Where a specific encounter should be classified as a part of a specific episode(s) of care this field should be used. This association can facilitate grouping of related encounters together for a specific purpose, such as government reporting, issue tracking, association via a common problem.  The association is recorded on the encounter as these are typically created after the episode of care and grouped on entry rather than editing the episode of care to append another encounter to it (the episode of care could span years).", 0, java.lang.Integer.MAX_VALUE, episodeOfCare));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this encounter satisfies (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("careTeam", "Reference(CareTeam)", "The group(s) of individuals, organizations that are allocated to participate in this encounter. The participants backbone will record the actuals of when these individuals participated during the encounter.", 0, java.lang.Integer.MAX_VALUE, careTeam));
        children.add(new Property("partOf", "Reference(Encounter)", "Another Encounter of which this encounter is a part of (administratively or in time).", 0, 1, partOf));
        children.add(new Property("serviceProvider", "Reference(Organization)", "The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab.", 0, 1, serviceProvider));
        children.add(new Property("participant", "", "The list of people responsible for providing the service.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("appointment", "Reference(Appointment)", "The appointment that scheduled this encounter.", 0, java.lang.Integer.MAX_VALUE, appointment));
        children.add(new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. conference call).", 0, java.lang.Integer.MAX_VALUE, virtualService));
        children.add(new Property("actualPeriod", "Period", "The actual start and end time of the encounter.", 0, 1, actualPeriod));
        children.add(new Property("plannedStartDate", "dateTime", "The planned start date/time (or admission date) of the encounter.", 0, 1, plannedStartDate));
        children.add(new Property("plannedEndDate", "dateTime", "The planned end date/time (or discharge date) of the encounter.", 0, 1, plannedEndDate));
        children.add(new Property("length", "Duration", "Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values.", 0, 1, length));
        children.add(new Property("reason", "", "The list of medical reasons that are expected to be addressed during the episode of care.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("diagnosis", "", "The list of diagnosis relevant to this encounter.", 0, java.lang.Integer.MAX_VALUE, diagnosis));
        children.add(new Property("account", "Reference(Account)", "The set of accounts that may be used for billing for this Encounter.", 0, java.lang.Integer.MAX_VALUE, account));
        children.add(new Property("dietPreference", "CodeableConcept", "Diet preferences reported by the patient.", 0, java.lang.Integer.MAX_VALUE, dietPreference));
        children.add(new Property("specialArrangement", "CodeableConcept", "Any special requests that have been made for this encounter, such as the provision of specific equipment or other things.", 0, java.lang.Integer.MAX_VALUE, specialArrangement));
        children.add(new Property("specialCourtesy", "CodeableConcept", "Special courtesies that may be provided to the patient during the encounter (VIP, board member, professional courtesy).", 0, java.lang.Integer.MAX_VALUE, specialCourtesy));
        children.add(new Property("admission", "", "Details about the stay during which a healthcare service is provided.\r\rThis does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge.", 0, 1, admission));
        children.add(new Property("location", "", "List of locations where  the patient has been during this encounter.", 0, java.lang.Integer.MAX_VALUE, location));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier(s) by which this encounter is known.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the encounter (not the state of the patient within the encounter - that is subjectState).", 0, 1, status);
        case 94742904: /*class*/  return new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, java.lang.Integer.MAX_VALUE, class_);
        case -1165461084: /*priority*/  return new Property("priority", "CodeableConcept", "Indicates the urgency of the encounter.", 0, 1, priority);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).", 0, java.lang.Integer.MAX_VALUE, type);
        case -1928370289: /*serviceType*/  return new Property("serviceType", "CodeableReference(HealthcareService)", "Broad categorization of the service that is to be provided (e.g. cardiology).", 0, java.lang.Integer.MAX_VALUE, serviceType);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.", 0, 1, subject);
        case 110854206: /*subjectStatus*/  return new Property("subjectStatus", "CodeableConcept", "The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.", 0, 1, subjectStatus);
        case -1892140189: /*episodeOfCare*/  return new Property("episodeOfCare", "Reference(EpisodeOfCare)", "Where a specific encounter should be classified as a part of a specific episode(s) of care this field should be used. This association can facilitate grouping of related encounters together for a specific purpose, such as government reporting, issue tracking, association via a common problem.  The association is recorded on the encounter as these are typically created after the episode of care and grouped on entry rather than editing the episode of care to append another encounter to it (the episode of care could span years).", 0, java.lang.Integer.MAX_VALUE, episodeOfCare);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this encounter satisfies (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -7323378: /*careTeam*/  return new Property("careTeam", "Reference(CareTeam)", "The group(s) of individuals, organizations that are allocated to participate in this encounter. The participants backbone will record the actuals of when these individuals participated during the encounter.", 0, java.lang.Integer.MAX_VALUE, careTeam);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Encounter)", "Another Encounter of which this encounter is a part of (administratively or in time).", 0, 1, partOf);
        case 243182534: /*serviceProvider*/  return new Property("serviceProvider", "Reference(Organization)", "The organization that is primarily responsible for this Encounter's services. This MAY be the same as the organization on the Patient record, however it could be different, such as if the actor performing the services was from an external organization (which may be billed seperately) for an external consultation.  Refer to the colonoscopy example on the Encounter examples tab.", 0, 1, serviceProvider);
        case 767422259: /*participant*/  return new Property("participant", "", "The list of people responsible for providing the service.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -1474995297: /*appointment*/  return new Property("appointment", "Reference(Appointment)", "The appointment that scheduled this encounter.", 0, java.lang.Integer.MAX_VALUE, appointment);
        case 1420774698: /*virtualService*/  return new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. conference call).", 0, java.lang.Integer.MAX_VALUE, virtualService);
        case 789194991: /*actualPeriod*/  return new Property("actualPeriod", "Period", "The actual start and end time of the encounter.", 0, 1, actualPeriod);
        case 460857804: /*plannedStartDate*/  return new Property("plannedStartDate", "dateTime", "The planned start date/time (or admission date) of the encounter.", 0, 1, plannedStartDate);
        case 1657534661: /*plannedEndDate*/  return new Property("plannedEndDate", "dateTime", "The planned end date/time (or discharge date) of the encounter.", 0, 1, plannedEndDate);
        case -1106363674: /*length*/  return new Property("length", "Duration", "Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values.", 0, 1, length);
        case -934964668: /*reason*/  return new Property("reason", "", "The list of medical reasons that are expected to be addressed during the episode of care.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 1196993265: /*diagnosis*/  return new Property("diagnosis", "", "The list of diagnosis relevant to this encounter.", 0, java.lang.Integer.MAX_VALUE, diagnosis);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "The set of accounts that may be used for billing for this Encounter.", 0, java.lang.Integer.MAX_VALUE, account);
        case -1360641041: /*dietPreference*/  return new Property("dietPreference", "CodeableConcept", "Diet preferences reported by the patient.", 0, java.lang.Integer.MAX_VALUE, dietPreference);
        case 47410321: /*specialArrangement*/  return new Property("specialArrangement", "CodeableConcept", "Any special requests that have been made for this encounter, such as the provision of specific equipment or other things.", 0, java.lang.Integer.MAX_VALUE, specialArrangement);
        case 1583588345: /*specialCourtesy*/  return new Property("specialCourtesy", "CodeableConcept", "Special courtesies that may be provided to the patient during the encounter (VIP, board member, professional courtesy).", 0, java.lang.Integer.MAX_VALUE, specialCourtesy);
        case 27400201: /*admission*/  return new Property("admission", "", "Details about the stay during which a healthcare service is provided.\r\rThis does not describe the event of admitting the patient, but rather any information that is relevant from the time of admittance until the time of discharge.", 0, 1, admission);
        case 1901043637: /*location*/  return new Property("location", "", "List of locations where  the patient has been during this encounter.", 0, java.lang.Integer.MAX_VALUE, location);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EncounterStatus>
        case 94742904: /*class*/ return this.class_ == null ? new Base[0] : this.class_.toArray(new Base[this.class_.size()]); // CodeableConcept
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1928370289: /*serviceType*/ return this.serviceType == null ? new Base[0] : this.serviceType.toArray(new Base[this.serviceType.size()]); // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 110854206: /*subjectStatus*/ return this.subjectStatus == null ? new Base[0] : new Base[] {this.subjectStatus}; // CodeableConcept
        case -1892140189: /*episodeOfCare*/ return this.episodeOfCare == null ? new Base[0] : this.episodeOfCare.toArray(new Base[this.episodeOfCare.size()]); // Reference
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -7323378: /*careTeam*/ return this.careTeam == null ? new Base[0] : this.careTeam.toArray(new Base[this.careTeam.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : new Base[] {this.partOf}; // Reference
        case 243182534: /*serviceProvider*/ return this.serviceProvider == null ? new Base[0] : new Base[] {this.serviceProvider}; // Reference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // EncounterParticipantComponent
        case -1474995297: /*appointment*/ return this.appointment == null ? new Base[0] : this.appointment.toArray(new Base[this.appointment.size()]); // Reference
        case 1420774698: /*virtualService*/ return this.virtualService == null ? new Base[0] : this.virtualService.toArray(new Base[this.virtualService.size()]); // VirtualServiceDetail
        case 789194991: /*actualPeriod*/ return this.actualPeriod == null ? new Base[0] : new Base[] {this.actualPeriod}; // Period
        case 460857804: /*plannedStartDate*/ return this.plannedStartDate == null ? new Base[0] : new Base[] {this.plannedStartDate}; // DateTimeType
        case 1657534661: /*plannedEndDate*/ return this.plannedEndDate == null ? new Base[0] : new Base[] {this.plannedEndDate}; // DateTimeType
        case -1106363674: /*length*/ return this.length == null ? new Base[0] : new Base[] {this.length}; // Duration
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // ReasonComponent
        case 1196993265: /*diagnosis*/ return this.diagnosis == null ? new Base[0] : this.diagnosis.toArray(new Base[this.diagnosis.size()]); // DiagnosisComponent
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : this.account.toArray(new Base[this.account.size()]); // Reference
        case -1360641041: /*dietPreference*/ return this.dietPreference == null ? new Base[0] : this.dietPreference.toArray(new Base[this.dietPreference.size()]); // CodeableConcept
        case 47410321: /*specialArrangement*/ return this.specialArrangement == null ? new Base[0] : this.specialArrangement.toArray(new Base[this.specialArrangement.size()]); // CodeableConcept
        case 1583588345: /*specialCourtesy*/ return this.specialCourtesy == null ? new Base[0] : this.specialCourtesy.toArray(new Base[this.specialCourtesy.size()]); // CodeableConcept
        case 27400201: /*admission*/ return this.admission == null ? new Base[0] : new Base[] {this.admission}; // EncounterAdmissionComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // EncounterLocationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new EncounterStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterStatus>
          return value;
        case 94742904: // class
          this.getClass_().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1165461084: // priority
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1928370289: // serviceType
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 110854206: // subjectStatus
          this.subjectStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1892140189: // episodeOfCare
          this.getEpisodeOfCare().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -7323378: // careTeam
          this.getCareTeam().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.partOf = TypeConvertor.castToReference(value); // Reference
          return value;
        case 243182534: // serviceProvider
          this.serviceProvider = TypeConvertor.castToReference(value); // Reference
          return value;
        case 767422259: // participant
          this.getParticipant().add((EncounterParticipantComponent) value); // EncounterParticipantComponent
          return value;
        case -1474995297: // appointment
          this.getAppointment().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1420774698: // virtualService
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value)); // VirtualServiceDetail
          return value;
        case 789194991: // actualPeriod
          this.actualPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 460857804: // plannedStartDate
          this.plannedStartDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1657534661: // plannedEndDate
          this.plannedEndDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1106363674: // length
          this.length = TypeConvertor.castToDuration(value); // Duration
          return value;
        case -934964668: // reason
          this.getReason().add((ReasonComponent) value); // ReasonComponent
          return value;
        case 1196993265: // diagnosis
          this.getDiagnosis().add((DiagnosisComponent) value); // DiagnosisComponent
          return value;
        case -1177318867: // account
          this.getAccount().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1360641041: // dietPreference
          this.getDietPreference().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 47410321: // specialArrangement
          this.getSpecialArrangement().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1583588345: // specialCourtesy
          this.getSpecialCourtesy().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 27400201: // admission
          this.admission = (EncounterAdmissionComponent) value; // EncounterAdmissionComponent
          return value;
        case 1901043637: // location
          this.getLocation().add((EncounterLocationComponent) value); // EncounterLocationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new EncounterStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterStatus>
        } else if (name.equals("class")) {
          this.getClass_().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("priority")) {
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("serviceType")) {
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("subjectStatus")) {
          this.subjectStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("episodeOfCare")) {
          this.getEpisodeOfCare().add(TypeConvertor.castToReference(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("careTeam")) {
          this.getCareTeam().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.partOf = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("serviceProvider")) {
          this.serviceProvider = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participant")) {
          this.getParticipant().add((EncounterParticipantComponent) value);
        } else if (name.equals("appointment")) {
          this.getAppointment().add(TypeConvertor.castToReference(value));
        } else if (name.equals("virtualService")) {
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value));
        } else if (name.equals("actualPeriod")) {
          this.actualPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("plannedStartDate")) {
          this.plannedStartDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("plannedEndDate")) {
          this.plannedEndDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("length")) {
          this.length = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("reason")) {
          this.getReason().add((ReasonComponent) value);
        } else if (name.equals("diagnosis")) {
          this.getDiagnosis().add((DiagnosisComponent) value);
        } else if (name.equals("account")) {
          this.getAccount().add(TypeConvertor.castToReference(value));
        } else if (name.equals("dietPreference")) {
          this.getDietPreference().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("specialArrangement")) {
          this.getSpecialArrangement().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("specialCourtesy")) {
          this.getSpecialCourtesy().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("admission")) {
          this.admission = (EncounterAdmissionComponent) value; // EncounterAdmissionComponent
        } else if (name.equals("location")) {
          this.getLocation().add((EncounterLocationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new EncounterStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterStatus>
        } else if (name.equals("class")) {
          this.getClass_().remove(value);
        } else if (name.equals("priority")) {
          this.priority = null;
        } else if (name.equals("type")) {
          this.getType().remove(value);
        } else if (name.equals("serviceType")) {
          this.getServiceType().remove(value);
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("subjectStatus")) {
          this.subjectStatus = null;
        } else if (name.equals("episodeOfCare")) {
          this.getEpisodeOfCare().remove(value);
        } else if (name.equals("basedOn")) {
          this.getBasedOn().remove(value);
        } else if (name.equals("careTeam")) {
          this.getCareTeam().remove(value);
        } else if (name.equals("partOf")) {
          this.partOf = null;
        } else if (name.equals("serviceProvider")) {
          this.serviceProvider = null;
        } else if (name.equals("participant")) {
          this.getParticipant().remove((EncounterParticipantComponent) value);
        } else if (name.equals("appointment")) {
          this.getAppointment().remove(value);
        } else if (name.equals("virtualService")) {
          this.getVirtualService().remove(value);
        } else if (name.equals("actualPeriod")) {
          this.actualPeriod = null;
        } else if (name.equals("plannedStartDate")) {
          this.plannedStartDate = null;
        } else if (name.equals("plannedEndDate")) {
          this.plannedEndDate = null;
        } else if (name.equals("length")) {
          this.length = null;
        } else if (name.equals("reason")) {
          this.getReason().remove((ReasonComponent) value);
        } else if (name.equals("diagnosis")) {
          this.getDiagnosis().remove((DiagnosisComponent) value);
        } else if (name.equals("account")) {
          this.getAccount().remove(value);
        } else if (name.equals("dietPreference")) {
          this.getDietPreference().remove(value);
        } else if (name.equals("specialArrangement")) {
          this.getSpecialArrangement().remove(value);
        } else if (name.equals("specialCourtesy")) {
          this.getSpecialCourtesy().remove(value);
        } else if (name.equals("admission")) {
          this.admission = (EncounterAdmissionComponent) value; // EncounterAdmissionComponent
        } else if (name.equals("location")) {
          this.getLocation().remove((EncounterLocationComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 94742904:  return addClass_(); 
        case -1165461084:  return getPriority();
        case 3575610:  return addType(); 
        case -1928370289:  return addServiceType(); 
        case -1867885268:  return getSubject();
        case 110854206:  return getSubjectStatus();
        case -1892140189:  return addEpisodeOfCare(); 
        case -332612366:  return addBasedOn(); 
        case -7323378:  return addCareTeam(); 
        case -995410646:  return getPartOf();
        case 243182534:  return getServiceProvider();
        case 767422259:  return addParticipant(); 
        case -1474995297:  return addAppointment(); 
        case 1420774698:  return addVirtualService(); 
        case 789194991:  return getActualPeriod();
        case 460857804:  return getPlannedStartDateElement();
        case 1657534661:  return getPlannedEndDateElement();
        case -1106363674:  return getLength();
        case -934964668:  return addReason(); 
        case 1196993265:  return addDiagnosis(); 
        case -1177318867:  return addAccount(); 
        case -1360641041:  return addDietPreference(); 
        case 47410321:  return addSpecialArrangement(); 
        case 1583588345:  return addSpecialCourtesy(); 
        case 27400201:  return getAdmission();
        case 1901043637:  return addLocation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 94742904: /*class*/ return new String[] {"CodeableConcept"};
        case -1165461084: /*priority*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1928370289: /*serviceType*/ return new String[] {"CodeableReference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 110854206: /*subjectStatus*/ return new String[] {"CodeableConcept"};
        case -1892140189: /*episodeOfCare*/ return new String[] {"Reference"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -7323378: /*careTeam*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case 243182534: /*serviceProvider*/ return new String[] {"Reference"};
        case 767422259: /*participant*/ return new String[] {};
        case -1474995297: /*appointment*/ return new String[] {"Reference"};
        case 1420774698: /*virtualService*/ return new String[] {"VirtualServiceDetail"};
        case 789194991: /*actualPeriod*/ return new String[] {"Period"};
        case 460857804: /*plannedStartDate*/ return new String[] {"dateTime"};
        case 1657534661: /*plannedEndDate*/ return new String[] {"dateTime"};
        case -1106363674: /*length*/ return new String[] {"Duration"};
        case -934964668: /*reason*/ return new String[] {};
        case 1196993265: /*diagnosis*/ return new String[] {};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case -1360641041: /*dietPreference*/ return new String[] {"CodeableConcept"};
        case 47410321: /*specialArrangement*/ return new String[] {"CodeableConcept"};
        case 1583588345: /*specialCourtesy*/ return new String[] {"CodeableConcept"};
        case 27400201: /*admission*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Encounter.status");
        }
        else if (name.equals("class")) {
          return addClass_();
        }
        else if (name.equals("priority")) {
          this.priority = new CodeableConcept();
          return this.priority;
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("serviceType")) {
          return addServiceType();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("subjectStatus")) {
          this.subjectStatus = new CodeableConcept();
          return this.subjectStatus;
        }
        else if (name.equals("episodeOfCare")) {
          return addEpisodeOfCare();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("careTeam")) {
          return addCareTeam();
        }
        else if (name.equals("partOf")) {
          this.partOf = new Reference();
          return this.partOf;
        }
        else if (name.equals("serviceProvider")) {
          this.serviceProvider = new Reference();
          return this.serviceProvider;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("appointment")) {
          return addAppointment();
        }
        else if (name.equals("virtualService")) {
          return addVirtualService();
        }
        else if (name.equals("actualPeriod")) {
          this.actualPeriod = new Period();
          return this.actualPeriod;
        }
        else if (name.equals("plannedStartDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Encounter.plannedStartDate");
        }
        else if (name.equals("plannedEndDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Encounter.plannedEndDate");
        }
        else if (name.equals("length")) {
          this.length = new Duration();
          return this.length;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("diagnosis")) {
          return addDiagnosis();
        }
        else if (name.equals("account")) {
          return addAccount();
        }
        else if (name.equals("dietPreference")) {
          return addDietPreference();
        }
        else if (name.equals("specialArrangement")) {
          return addSpecialArrangement();
        }
        else if (name.equals("specialCourtesy")) {
          return addSpecialCourtesy();
        }
        else if (name.equals("admission")) {
          this.admission = new EncounterAdmissionComponent();
          return this.admission;
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Encounter";

  }

      public Encounter copy() {
        Encounter dst = new Encounter();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Encounter dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (class_ != null) {
          dst.class_ = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : class_)
            dst.class_.add(i.copy());
        };
        dst.priority = priority == null ? null : priority.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (serviceType != null) {
          dst.serviceType = new ArrayList<CodeableReference>();
          for (CodeableReference i : serviceType)
            dst.serviceType.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.subjectStatus = subjectStatus == null ? null : subjectStatus.copy();
        if (episodeOfCare != null) {
          dst.episodeOfCare = new ArrayList<Reference>();
          for (Reference i : episodeOfCare)
            dst.episodeOfCare.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (careTeam != null) {
          dst.careTeam = new ArrayList<Reference>();
          for (Reference i : careTeam)
            dst.careTeam.add(i.copy());
        };
        dst.partOf = partOf == null ? null : partOf.copy();
        dst.serviceProvider = serviceProvider == null ? null : serviceProvider.copy();
        if (participant != null) {
          dst.participant = new ArrayList<EncounterParticipantComponent>();
          for (EncounterParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        if (appointment != null) {
          dst.appointment = new ArrayList<Reference>();
          for (Reference i : appointment)
            dst.appointment.add(i.copy());
        };
        if (virtualService != null) {
          dst.virtualService = new ArrayList<VirtualServiceDetail>();
          for (VirtualServiceDetail i : virtualService)
            dst.virtualService.add(i.copy());
        };
        dst.actualPeriod = actualPeriod == null ? null : actualPeriod.copy();
        dst.plannedStartDate = plannedStartDate == null ? null : plannedStartDate.copy();
        dst.plannedEndDate = plannedEndDate == null ? null : plannedEndDate.copy();
        dst.length = length == null ? null : length.copy();
        if (reason != null) {
          dst.reason = new ArrayList<ReasonComponent>();
          for (ReasonComponent i : reason)
            dst.reason.add(i.copy());
        };
        if (diagnosis != null) {
          dst.diagnosis = new ArrayList<DiagnosisComponent>();
          for (DiagnosisComponent i : diagnosis)
            dst.diagnosis.add(i.copy());
        };
        if (account != null) {
          dst.account = new ArrayList<Reference>();
          for (Reference i : account)
            dst.account.add(i.copy());
        };
        if (dietPreference != null) {
          dst.dietPreference = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : dietPreference)
            dst.dietPreference.add(i.copy());
        };
        if (specialArrangement != null) {
          dst.specialArrangement = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialArrangement)
            dst.specialArrangement.add(i.copy());
        };
        if (specialCourtesy != null) {
          dst.specialCourtesy = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialCourtesy)
            dst.specialCourtesy.add(i.copy());
        };
        dst.admission = admission == null ? null : admission.copy();
        if (location != null) {
          dst.location = new ArrayList<EncounterLocationComponent>();
          for (EncounterLocationComponent i : location)
            dst.location.add(i.copy());
        };
      }

      protected Encounter typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Encounter))
          return false;
        Encounter o = (Encounter) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(class_, o.class_, true)
           && compareDeep(priority, o.priority, true) && compareDeep(type, o.type, true) && compareDeep(serviceType, o.serviceType, true)
           && compareDeep(subject, o.subject, true) && compareDeep(subjectStatus, o.subjectStatus, true) && compareDeep(episodeOfCare, o.episodeOfCare, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(careTeam, o.careTeam, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(serviceProvider, o.serviceProvider, true) && compareDeep(participant, o.participant, true)
           && compareDeep(appointment, o.appointment, true) && compareDeep(virtualService, o.virtualService, true)
           && compareDeep(actualPeriod, o.actualPeriod, true) && compareDeep(plannedStartDate, o.plannedStartDate, true)
           && compareDeep(plannedEndDate, o.plannedEndDate, true) && compareDeep(length, o.length, true) && compareDeep(reason, o.reason, true)
           && compareDeep(diagnosis, o.diagnosis, true) && compareDeep(account, o.account, true) && compareDeep(dietPreference, o.dietPreference, true)
           && compareDeep(specialArrangement, o.specialArrangement, true) && compareDeep(specialCourtesy, o.specialCourtesy, true)
           && compareDeep(admission, o.admission, true) && compareDeep(location, o.location, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Encounter))
          return false;
        Encounter o = (Encounter) other_;
        return compareValues(status, o.status, true) && compareValues(plannedStartDate, o.plannedStartDate, true)
           && compareValues(plannedEndDate, o.plannedEndDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, class_
          , priority, type, serviceType, subject, subjectStatus, episodeOfCare, basedOn
          , careTeam, partOf, serviceProvider, participant, appointment, virtualService, actualPeriod
          , plannedStartDate, plannedEndDate, length, reason, diagnosis, account, dietPreference
          , specialArrangement, specialCourtesy, admission, location);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Encounter;
   }

 /**
   * Search parameter: <b>account</b>
   * <p>
   * Description: <b>The set of accounts that may be used for billing for this Encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.account</b><br>
   * </p>
   */
  @SearchParamDefinition(name="account", path="Encounter.account", description="The set of accounts that may be used for billing for this Encounter", type="reference", target={Account.class } )
  public static final String SP_ACCOUNT = "account";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>account</b>
   * <p>
   * Description: <b>The set of accounts that may be used for billing for this Encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.account</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACCOUNT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACCOUNT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:account</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACCOUNT = new ca.uhn.fhir.model.api.Include("Encounter:account").toLocked();

 /**
   * Search parameter: <b>appointment</b>
   * <p>
   * Description: <b>The appointment that scheduled this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.appointment</b><br>
   * </p>
   */
  @SearchParamDefinition(name="appointment", path="Encounter.appointment", description="The appointment that scheduled this encounter", type="reference", target={Appointment.class } )
  public static final String SP_APPOINTMENT = "appointment";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>appointment</b>
   * <p>
   * Description: <b>The appointment that scheduled this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.appointment</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam APPOINTMENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_APPOINTMENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:appointment</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_APPOINTMENT = new ca.uhn.fhir.model.api.Include("Encounter:appointment").toLocked();

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>The ServiceRequest that initiated this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="Encounter.basedOn", description="The ServiceRequest that initiated this encounter", type="reference", target={CarePlan.class, DeviceRequest.class, MedicationRequest.class, ServiceRequest.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>The ServiceRequest that initiated this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("Encounter:based-on").toLocked();

 /**
   * Search parameter: <b>careteam</b>
   * <p>
   * Description: <b>Careteam allocated to participate in the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.careTeam</b><br>
   * </p>
   */
  @SearchParamDefinition(name="careteam", path="Encounter.careTeam", description="Careteam allocated to participate in the encounter", type="reference", target={CareTeam.class } )
  public static final String SP_CARETEAM = "careteam";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>careteam</b>
   * <p>
   * Description: <b>Careteam allocated to participate in the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.careTeam</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CARETEAM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CARETEAM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:careteam</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CARETEAM = new ca.uhn.fhir.model.api.Include("Encounter:careteam").toLocked();

 /**
   * Search parameter: <b>class</b>
   * <p>
   * Description: <b>Classification of patient encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.class</b><br>
   * </p>
   */
  @SearchParamDefinition(name="class", path="Encounter.class", description="Classification of patient encounter", type="token" )
  public static final String SP_CLASS = "class";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>class</b>
   * <p>
   * Description: <b>Classification of patient encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.class</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASS);

 /**
   * Search parameter: <b>date-start</b>
   * <p>
   * Description: <b>The actual start date of the Encounter</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Encounter.actualPeriod.start</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date-start", path="Encounter.actualPeriod.start", description="The actual start date of the Encounter", type="date" )
  public static final String SP_DATE_START = "date-start";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date-start</b>
   * <p>
   * Description: <b>The actual start date of the Encounter</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Encounter.actualPeriod.start</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE_START = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE_START);

 /**
   * Search parameter: <b>diagnosis-code</b>
   * <p>
   * Description: <b>The diagnosis or procedure relevant to the encounter (coded)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.diagnosis.condition.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="diagnosis-code", path="Encounter.diagnosis.condition.concept", description="The diagnosis or procedure relevant to the encounter (coded)", type="token" )
  public static final String SP_DIAGNOSIS_CODE = "diagnosis-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>diagnosis-code</b>
   * <p>
   * Description: <b>The diagnosis or procedure relevant to the encounter (coded)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.diagnosis.condition.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DIAGNOSIS_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DIAGNOSIS_CODE);

 /**
   * Search parameter: <b>diagnosis-reference</b>
   * <p>
   * Description: <b>The diagnosis or procedure relevant to the encounter (resource reference)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.diagnosis.condition.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="diagnosis-reference", path="Encounter.diagnosis.condition.reference", description="The diagnosis or procedure relevant to the encounter (resource reference)", type="reference", target={Condition.class } )
  public static final String SP_DIAGNOSIS_REFERENCE = "diagnosis-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>diagnosis-reference</b>
   * <p>
   * Description: <b>The diagnosis or procedure relevant to the encounter (resource reference)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.diagnosis.condition.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DIAGNOSIS_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DIAGNOSIS_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:diagnosis-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DIAGNOSIS_REFERENCE = new ca.uhn.fhir.model.api.Include("Encounter:diagnosis-reference").toLocked();

 /**
   * Search parameter: <b>end-date</b>
   * <p>
   * Description: <b>The actual end date of the Encounter</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Encounter.actualPeriod.end</b><br>
   * </p>
   */
  @SearchParamDefinition(name="end-date", path="Encounter.actualPeriod.end", description="The actual end date of the Encounter", type="date" )
  public static final String SP_END_DATE = "end-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>end-date</b>
   * <p>
   * Description: <b>The actual end date of the Encounter</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Encounter.actualPeriod.end</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam END_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_END_DATE);

 /**
   * Search parameter: <b>episode-of-care</b>
   * <p>
   * Description: <b>Episode(s) of care that this encounter should be recorded against</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.episodeOfCare</b><br>
   * </p>
   */
  @SearchParamDefinition(name="episode-of-care", path="Encounter.episodeOfCare", description="Episode(s) of care that this encounter should be recorded against", type="reference", target={EpisodeOfCare.class } )
  public static final String SP_EPISODE_OF_CARE = "episode-of-care";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>episode-of-care</b>
   * <p>
   * Description: <b>Episode(s) of care that this encounter should be recorded against</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.episodeOfCare</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam EPISODE_OF_CARE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_EPISODE_OF_CARE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:episode-of-care</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_EPISODE_OF_CARE = new ca.uhn.fhir.model.api.Include("Encounter:episode-of-care").toLocked();

 /**
   * Search parameter: <b>length</b>
   * <p>
   * Description: <b>Length of encounter in days</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Encounter.length</b><br>
   * </p>
   */
  @SearchParamDefinition(name="length", path="Encounter.length", description="Length of encounter in days", type="quantity" )
  public static final String SP_LENGTH = "length";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>length</b>
   * <p>
   * Description: <b>Length of encounter in days</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Encounter.length</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam LENGTH = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_LENGTH);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Location the encounter takes place</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.location.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="Encounter.location.location", description="Location the encounter takes place", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Location the encounter takes place</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.location.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("Encounter:location").toLocked();

 /**
   * Search parameter: <b>part-of</b>
   * <p>
   * Description: <b>Another Encounter this encounter is part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-of", path="Encounter.partOf", description="Another Encounter this encounter is part of", type="reference", target={Encounter.class } )
  public static final String SP_PART_OF = "part-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-of</b>
   * <p>
   * Description: <b>Another Encounter this encounter is part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PART_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PART_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:part-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PART_OF = new ca.uhn.fhir.model.api.Include("Encounter:part-of").toLocked();

 /**
   * Search parameter: <b>participant-type</b>
   * <p>
   * Description: <b>Role of participant in encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.participant.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant-type", path="Encounter.participant.type", description="Role of participant in encounter", type="token" )
  public static final String SP_PARTICIPANT_TYPE = "participant-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant-type</b>
   * <p>
   * Description: <b>Role of participant in encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.participant.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PARTICIPANT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PARTICIPANT_TYPE);

 /**
   * Search parameter: <b>participant</b>
   * <p>
   * Description: <b>Persons involved in the encounter other than the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.participant.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant", path="Encounter.participant.actor", description="Persons involved in the encounter other than the patient", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Group.class, HealthcareService.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PARTICIPANT = "participant";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant</b>
   * <p>
   * Description: <b>Persons involved in the encounter other than the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.participant.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTICIPANT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTICIPANT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:participant</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTICIPANT = new ca.uhn.fhir.model.api.Include("Encounter:participant").toLocked();

 /**
   * Search parameter: <b>practitioner</b>
   * <p>
   * Description: <b>Persons involved in the encounter other than the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.participant.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="practitioner", path="Encounter.participant.actor.where(resolve() is Practitioner)", description="Persons involved in the encounter other than the patient", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class } )
  public static final String SP_PRACTITIONER = "practitioner";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>practitioner</b>
   * <p>
   * Description: <b>Persons involved in the encounter other than the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.participant.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRACTITIONER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRACTITIONER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:practitioner</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRACTITIONER = new ca.uhn.fhir.model.api.Include("Encounter:practitioner").toLocked();

 /**
   * Search parameter: <b>reason-code</b>
   * <p>
   * Description: <b>Reference to a concept (coded)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.reason.value.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason-code", path="Encounter.reason.value.concept", description="Reference to a concept (coded)", type="token" )
  public static final String SP_REASON_CODE = "reason-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason-code</b>
   * <p>
   * Description: <b>Reference to a concept (coded)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.reason.value.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REASON_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REASON_CODE);

 /**
   * Search parameter: <b>reason-reference</b>
   * <p>
   * Description: <b>Reference to a resource (resource reference)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.reason.value.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason-reference", path="Encounter.reason.value.reference", description="Reference to a resource (resource reference)", type="reference", target={Condition.class, DiagnosticReport.class, ImmunizationRecommendation.class, Observation.class, Procedure.class } )
  public static final String SP_REASON_REFERENCE = "reason-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason-reference</b>
   * <p>
   * Description: <b>Reference to a resource (resource reference)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.reason.value.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REASON_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REASON_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:reason-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REASON_REFERENCE = new ca.uhn.fhir.model.api.Include("Encounter:reason-reference").toLocked();

 /**
   * Search parameter: <b>service-provider</b>
   * <p>
   * Description: <b>The organization (facility) responsible for this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.serviceProvider</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-provider", path="Encounter.serviceProvider", description="The organization (facility) responsible for this encounter", type="reference", target={Organization.class } )
  public static final String SP_SERVICE_PROVIDER = "service-provider";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-provider</b>
   * <p>
   * Description: <b>The organization (facility) responsible for this encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.serviceProvider</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SERVICE_PROVIDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SERVICE_PROVIDER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:service-provider</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SERVICE_PROVIDER = new ca.uhn.fhir.model.api.Include("Encounter:service-provider").toLocked();

 /**
   * Search parameter: <b>special-arrangement</b>
   * <p>
   * Description: <b>Wheelchair, translator, stretcher, etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.specialArrangement</b><br>
   * </p>
   */
  @SearchParamDefinition(name="special-arrangement", path="Encounter.specialArrangement", description="Wheelchair, translator, stretcher, etc.", type="token" )
  public static final String SP_SPECIAL_ARRANGEMENT = "special-arrangement";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>special-arrangement</b>
   * <p>
   * Description: <b>Wheelchair, translator, stretcher, etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.specialArrangement</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIAL_ARRANGEMENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIAL_ARRANGEMENT);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>planned | in-progress | on-hold | completed | cancelled | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Encounter.status", description="planned | in-progress | on-hold | completed | cancelled | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>planned | in-progress | on-hold | completed | cancelled | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject-status</b>
   * <p>
   * Description: <b>The current status of the subject in relation to the Encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.subjectStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject-status", path="Encounter.subjectStatus", description="The current status of the subject in relation to the Encounter", type="token" )
  public static final String SP_SUBJECT_STATUS = "subject-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject-status</b>
   * <p>
   * Description: <b>The current status of the subject in relation to the Encounter</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Encounter.subjectStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SUBJECT_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SUBJECT_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The patient or group present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Encounter.subject", description="The patient or group present at the encounter", type="reference", target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The patient or group present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Encounter.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Encounter:subject").toLocked();

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): When the event occurred\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [Appointment](appointment.html): Appointment date/time.\r\n* [AuditEvent](auditevent.html): Time when the event was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [DocumentReference](documentreference.html): When this document reference was created\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created\r\n* [Invoice](invoice.html): Invoice date / posting date\r\n* [List](list.html): When the list was prepared\r\n* [MeasureReport](measurereport.html): The date of the measure report\r\n* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication\r\n* [Observation](observation.html): Clinically relevant time/time-period for observation\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [ResearchSubject](researchsubject.html): Start and end of participation\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Encounter:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Encounter:patient").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type", description="Multiple Resources: \r\n\r\n* [Account](account.html): E.g. patient, expense, depreciation\r\n* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)\r\n* [Composition](composition.html): Kind of composition (LOINC if possible)\r\n* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)\r\n* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)\r\n* [Encounter](encounter.html): Specific type of encounter\r\n* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management\r\n* [Invoice](invoice.html): Type of Invoice\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type\r\n* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence\r\n* [Specimen](specimen.html): The specimen type\r\n", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

