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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
 */
@ResourceDef(name="FamilyMemberHistory", profile="http://hl7.org/fhir/StructureDefinition/FamilyMemberHistory")
public class FamilyMemberHistory extends DomainResource {

    public enum FamilyHistoryStatus {
        /**
         * Some health information is known and captured, but not complete - see notes for details.
         */
        PARTIAL, 
        /**
         * All available related health information is captured as of the date (and possibly time) when the family member history was taken.
         */
        COMPLETED, 
        /**
         * This instance should not have been part of this patient's medical record.
         */
        ENTEREDINERROR, 
        /**
         * Health information for this family member is unavailable/unknown.
         */
        HEALTHUNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FamilyHistoryStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("partial".equals(codeString))
          return PARTIAL;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("health-unknown".equals(codeString))
          return HEALTHUNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FamilyHistoryStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PARTIAL: return "partial";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case HEALTHUNKNOWN: return "health-unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PARTIAL: return "http://hl7.org/fhir/history-status";
            case COMPLETED: return "http://hl7.org/fhir/history-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/history-status";
            case HEALTHUNKNOWN: return "http://hl7.org/fhir/history-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PARTIAL: return "Some health information is known and captured, but not complete - see notes for details.";
            case COMPLETED: return "All available related health information is captured as of the date (and possibly time) when the family member history was taken.";
            case ENTEREDINERROR: return "This instance should not have been part of this patient's medical record.";
            case HEALTHUNKNOWN: return "Health information for this family member is unavailable/unknown.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PARTIAL: return "Partial";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case HEALTHUNKNOWN: return "Health Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FamilyHistoryStatusEnumFactory implements EnumFactory<FamilyHistoryStatus> {
    public FamilyHistoryStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("partial".equals(codeString))
          return FamilyHistoryStatus.PARTIAL;
        if ("completed".equals(codeString))
          return FamilyHistoryStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return FamilyHistoryStatus.ENTEREDINERROR;
        if ("health-unknown".equals(codeString))
          return FamilyHistoryStatus.HEALTHUNKNOWN;
        throw new IllegalArgumentException("Unknown FamilyHistoryStatus code '"+codeString+"'");
        }
        public Enumeration<FamilyHistoryStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FamilyHistoryStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("partial".equals(codeString))
          return new Enumeration<FamilyHistoryStatus>(this, FamilyHistoryStatus.PARTIAL);
        if ("completed".equals(codeString))
          return new Enumeration<FamilyHistoryStatus>(this, FamilyHistoryStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<FamilyHistoryStatus>(this, FamilyHistoryStatus.ENTEREDINERROR);
        if ("health-unknown".equals(codeString))
          return new Enumeration<FamilyHistoryStatus>(this, FamilyHistoryStatus.HEALTHUNKNOWN);
        throw new FHIRException("Unknown FamilyHistoryStatus code '"+codeString+"'");
        }
    public String toCode(FamilyHistoryStatus code) {
      if (code == FamilyHistoryStatus.PARTIAL)
        return "partial";
      if (code == FamilyHistoryStatus.COMPLETED)
        return "completed";
      if (code == FamilyHistoryStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == FamilyHistoryStatus.HEALTHUNKNOWN)
        return "health-unknown";
      return "?";
      }
    public String toSystem(FamilyHistoryStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class FamilyMemberHistoryParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the actor in the activities related to the family member history.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of involvement", formalDefinition="Distinguishes the type of involvement of the actor in the activities related to the family member history." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participation-role-type")
        protected CodeableConcept function;

        /**
         * Indicates who or what participated in the activities related to the family member history.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class, Device.class, Organization.class, CareTeam.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who or what participated in the activities related to the family member history", formalDefinition="Indicates who or what participated in the activities related to the family member history." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public FamilyMemberHistoryParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public FamilyMemberHistoryParticipantComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the actor in the activities related to the family member history.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryParticipantComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the actor in the activities related to the family member history.)
         */
        public FamilyMemberHistoryParticipantComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Indicates who or what participated in the activities related to the family member history.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Indicates who or what participated in the activities related to the family member history.)
         */
        public FamilyMemberHistoryParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the activities related to the family member history.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Device|Organization|CareTeam)", "Indicates who or what participated in the activities related to the family member history.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the activities related to the family member history.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Device|Organization|CareTeam)", "Indicates who or what participated in the activities related to the family member history.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public FamilyMemberHistoryParticipantComponent copy() {
        FamilyMemberHistoryParticipantComponent dst = new FamilyMemberHistoryParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FamilyMemberHistoryParticipantComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryParticipantComponent))
          return false;
        FamilyMemberHistoryParticipantComponent o = (FamilyMemberHistoryParticipantComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryParticipantComponent))
          return false;
        FamilyMemberHistoryParticipantComponent o = (FamilyMemberHistoryParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "FamilyMemberHistory.participant";

  }

  }

    @Block()
    public static class FamilyMemberHistoryConditionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Condition suffered by relation", formalDefinition="The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
        protected CodeableConcept code;

        /**
         * Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation.
         */
        @Child(name = "outcome", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="deceased | permanent disability | etc.", formalDefinition="Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-outcome")
        protected CodeableConcept outcome;

        /**
         * This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        @Child(name = "contributedToDeath", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the condition contributed to the cause of death", formalDefinition="This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown." )
        protected BooleanType contributedToDeath;

        /**
         * Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.
         */
        @Child(name = "onset", type = {Age.class, Range.class, Period.class, StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When condition first manifested", formalDefinition="Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence." )
        protected DataType onset;

        /**
         * An area where general notes can be placed about this specific condition.
         */
        @Child(name = "note", type = {Annotation.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Extra information about condition", formalDefinition="An area where general notes can be placed about this specific condition." )
        protected List<Annotation> note;

        private static final long serialVersionUID = -91335661L;

    /**
     * Constructor
     */
      public FamilyMemberHistoryConditionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public FamilyMemberHistoryConditionComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryConditionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system.)
         */
        public FamilyMemberHistoryConditionComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #outcome} (Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation.)
         */
        public CodeableConcept getOutcome() { 
          if (this.outcome == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryConditionComponent.outcome");
            else if (Configuration.doAutoCreate())
              this.outcome = new CodeableConcept(); // cc
          return this.outcome;
        }

        public boolean hasOutcome() { 
          return this.outcome != null && !this.outcome.isEmpty();
        }

        /**
         * @param value {@link #outcome} (Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation.)
         */
        public FamilyMemberHistoryConditionComponent setOutcome(CodeableConcept value) { 
          this.outcome = value;
          return this;
        }

        /**
         * @return {@link #contributedToDeath} (This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.). This is the underlying object with id, value and extensions. The accessor "getContributedToDeath" gives direct access to the value
         */
        public BooleanType getContributedToDeathElement() { 
          if (this.contributedToDeath == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryConditionComponent.contributedToDeath");
            else if (Configuration.doAutoCreate())
              this.contributedToDeath = new BooleanType(); // bb
          return this.contributedToDeath;
        }

        public boolean hasContributedToDeathElement() { 
          return this.contributedToDeath != null && !this.contributedToDeath.isEmpty();
        }

        public boolean hasContributedToDeath() { 
          return this.contributedToDeath != null && !this.contributedToDeath.isEmpty();
        }

        /**
         * @param value {@link #contributedToDeath} (This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.). This is the underlying object with id, value and extensions. The accessor "getContributedToDeath" gives direct access to the value
         */
        public FamilyMemberHistoryConditionComponent setContributedToDeathElement(BooleanType value) { 
          this.contributedToDeath = value;
          return this;
        }

        /**
         * @return This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        public boolean getContributedToDeath() { 
          return this.contributedToDeath == null || this.contributedToDeath.isEmpty() ? false : this.contributedToDeath.getValue();
        }

        /**
         * @param value This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        public FamilyMemberHistoryConditionComponent setContributedToDeath(boolean value) { 
            if (this.contributedToDeath == null)
              this.contributedToDeath = new BooleanType();
            this.contributedToDeath.setValue(value);
          return this;
        }

        /**
         * @return {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public DataType getOnset() { 
          return this.onset;
        }

        /**
         * @return {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public Age getOnsetAge() throws FHIRException { 
          if (this.onset == null)
            this.onset = new Age();
          if (!(this.onset instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.onset.getClass().getName()+" was encountered");
          return (Age) this.onset;
        }

        public boolean hasOnsetAge() { 
          return this != null && this.onset instanceof Age;
        }

        /**
         * @return {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public Range getOnsetRange() throws FHIRException { 
          if (this.onset == null)
            this.onset = new Range();
          if (!(this.onset instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.onset.getClass().getName()+" was encountered");
          return (Range) this.onset;
        }

        public boolean hasOnsetRange() { 
          return this != null && this.onset instanceof Range;
        }

        /**
         * @return {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public Period getOnsetPeriod() throws FHIRException { 
          if (this.onset == null)
            this.onset = new Period();
          if (!(this.onset instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.onset.getClass().getName()+" was encountered");
          return (Period) this.onset;
        }

        public boolean hasOnsetPeriod() { 
          return this != null && this.onset instanceof Period;
        }

        /**
         * @return {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public StringType getOnsetStringType() throws FHIRException { 
          if (this.onset == null)
            this.onset = new StringType();
          if (!(this.onset instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.onset.getClass().getName()+" was encountered");
          return (StringType) this.onset;
        }

        public boolean hasOnsetStringType() { 
          return this != null && this.onset instanceof StringType;
        }

        public boolean hasOnset() { 
          return this.onset != null && !this.onset.isEmpty();
        }

        /**
         * @param value {@link #onset} (Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.)
         */
        public FamilyMemberHistoryConditionComponent setOnset(DataType value) { 
          if (value != null && !(value instanceof Age || value instanceof Range || value instanceof Period || value instanceof StringType))
            throw new Error("Not the right type for FamilyMemberHistory.condition.onset[x]: "+value.fhirType());
          this.onset = value;
          return this;
        }

        /**
         * @return {@link #note} (An area where general notes can be placed about this specific condition.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public FamilyMemberHistoryConditionComponent setNote(List<Annotation> theNote) { 
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

        public FamilyMemberHistoryConditionComponent addNote(Annotation t) { //3
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system.", 0, 1, code));
          children.add(new Property("outcome", "CodeableConcept", "Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation.", 0, 1, outcome));
          children.add(new Property("contributedToDeath", "boolean", "This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.", 0, 1, contributedToDeath));
          children.add(new Property("onset[x]", "Age|Range|Period|string", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset));
          children.add(new Property("note", "Annotation", "An area where general notes can be placed about this specific condition.", 0, java.lang.Integer.MAX_VALUE, note));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system.", 0, 1, code);
          case -1106507950: /*outcome*/  return new Property("outcome", "CodeableConcept", "Indicates what happened following the condition.  If the condition resulted in death, deceased date is captured on the relation.", 0, 1, outcome);
          case -363644638: /*contributedToDeath*/  return new Property("contributedToDeath", "boolean", "This condition contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.", 0, 1, contributedToDeath);
          case -1886216323: /*onset[x]*/  return new Property("onset[x]", "Age|Range|Period|string", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case 105901603: /*onset*/  return new Property("onset[x]", "Age|Range|Period|string", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case -1886241828: /*onsetAge*/  return new Property("onset[x]", "Age", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case -186664742: /*onsetRange*/  return new Property("onset[x]", "Range", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case -1545082428: /*onsetPeriod*/  return new Property("onset[x]", "Period", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case -1445342188: /*onsetString*/  return new Property("onset[x]", "string", "Either the age of onset, range of approximate age or descriptive string can be recorded.  For conditions with multiple occurrences, this describes the first known occurrence.", 0, 1, onset);
          case 3387378: /*note*/  return new Property("note", "Annotation", "An area where general notes can be placed about this specific condition.", 0, java.lang.Integer.MAX_VALUE, note);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // CodeableConcept
        case -363644638: /*contributedToDeath*/ return this.contributedToDeath == null ? new Base[0] : new Base[] {this.contributedToDeath}; // BooleanType
        case 105901603: /*onset*/ return this.onset == null ? new Base[0] : new Base[] {this.onset}; // DataType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1106507950: // outcome
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -363644638: // contributedToDeath
          this.contributedToDeath = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 105901603: // onset
          this.onset = TypeConvertor.castToType(value); // DataType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("outcome")) {
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("contributedToDeath")) {
          this.contributedToDeath = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("onset[x]")) {
          this.onset = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1106507950:  return getOutcome();
        case -363644638:  return getContributedToDeathElement();
        case -1886216323:  return getOnset();
        case 105901603:  return getOnset();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1106507950: /*outcome*/ return new String[] {"CodeableConcept"};
        case -363644638: /*contributedToDeath*/ return new String[] {"boolean"};
        case 105901603: /*onset*/ return new String[] {"Age", "Range", "Period", "string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("outcome")) {
          this.outcome = new CodeableConcept();
          return this.outcome;
        }
        else if (name.equals("contributedToDeath")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.condition.contributedToDeath");
        }
        else if (name.equals("onsetAge")) {
          this.onset = new Age();
          return this.onset;
        }
        else if (name.equals("onsetRange")) {
          this.onset = new Range();
          return this.onset;
        }
        else if (name.equals("onsetPeriod")) {
          this.onset = new Period();
          return this.onset;
        }
        else if (name.equals("onsetString")) {
          this.onset = new StringType();
          return this.onset;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

      public FamilyMemberHistoryConditionComponent copy() {
        FamilyMemberHistoryConditionComponent dst = new FamilyMemberHistoryConditionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FamilyMemberHistoryConditionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.contributedToDeath = contributedToDeath == null ? null : contributedToDeath.copy();
        dst.onset = onset == null ? null : onset.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryConditionComponent))
          return false;
        FamilyMemberHistoryConditionComponent o = (FamilyMemberHistoryConditionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(outcome, o.outcome, true) && compareDeep(contributedToDeath, o.contributedToDeath, true)
           && compareDeep(onset, o.onset, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryConditionComponent))
          return false;
        FamilyMemberHistoryConditionComponent o = (FamilyMemberHistoryConditionComponent) other_;
        return compareValues(contributedToDeath, o.contributedToDeath, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, outcome, contributedToDeath
          , onset, note);
      }

  public String fhirType() {
    return "FamilyMemberHistory.condition";

  }

  }

    @Block()
    public static class FamilyMemberHistoryProcedureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Procedures performed on the related person", formalDefinition="The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-code")
        protected CodeableConcept code;

        /**
         * Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation.
         */
        @Child(name = "outcome", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What happened following the procedure", formalDefinition="Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
        protected CodeableConcept outcome;

        /**
         * This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        @Child(name = "contributedToDeath", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the procedure contributed to the cause of death", formalDefinition="This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown." )
        protected BooleanType contributedToDeath;

        /**
         * Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.
         */
        @Child(name = "performed", type = {Age.class, Range.class, Period.class, StringType.class, DateTimeType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the procedure was performed", formalDefinition="Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured." )
        protected DataType performed;

        /**
         * An area where general notes can be placed about this specific procedure.
         */
        @Child(name = "note", type = {Annotation.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Extra information about the procedure", formalDefinition="An area where general notes can be placed about this specific procedure." )
        protected List<Annotation> note;

        private static final long serialVersionUID = 281271062L;

    /**
     * Constructor
     */
      public FamilyMemberHistoryProcedureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public FamilyMemberHistoryProcedureComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryProcedureComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system.)
         */
        public FamilyMemberHistoryProcedureComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #outcome} (Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation.)
         */
        public CodeableConcept getOutcome() { 
          if (this.outcome == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryProcedureComponent.outcome");
            else if (Configuration.doAutoCreate())
              this.outcome = new CodeableConcept(); // cc
          return this.outcome;
        }

        public boolean hasOutcome() { 
          return this.outcome != null && !this.outcome.isEmpty();
        }

        /**
         * @param value {@link #outcome} (Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation.)
         */
        public FamilyMemberHistoryProcedureComponent setOutcome(CodeableConcept value) { 
          this.outcome = value;
          return this;
        }

        /**
         * @return {@link #contributedToDeath} (This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.). This is the underlying object with id, value and extensions. The accessor "getContributedToDeath" gives direct access to the value
         */
        public BooleanType getContributedToDeathElement() { 
          if (this.contributedToDeath == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create FamilyMemberHistoryProcedureComponent.contributedToDeath");
            else if (Configuration.doAutoCreate())
              this.contributedToDeath = new BooleanType(); // bb
          return this.contributedToDeath;
        }

        public boolean hasContributedToDeathElement() { 
          return this.contributedToDeath != null && !this.contributedToDeath.isEmpty();
        }

        public boolean hasContributedToDeath() { 
          return this.contributedToDeath != null && !this.contributedToDeath.isEmpty();
        }

        /**
         * @param value {@link #contributedToDeath} (This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.). This is the underlying object with id, value and extensions. The accessor "getContributedToDeath" gives direct access to the value
         */
        public FamilyMemberHistoryProcedureComponent setContributedToDeathElement(BooleanType value) { 
          this.contributedToDeath = value;
          return this;
        }

        /**
         * @return This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        public boolean getContributedToDeath() { 
          return this.contributedToDeath == null || this.contributedToDeath.isEmpty() ? false : this.contributedToDeath.getValue();
        }

        /**
         * @param value This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.
         */
        public FamilyMemberHistoryProcedureComponent setContributedToDeath(boolean value) { 
            if (this.contributedToDeath == null)
              this.contributedToDeath = new BooleanType();
            this.contributedToDeath.setValue(value);
          return this;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public DataType getPerformed() { 
          return this.performed;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public Age getPerformedAge() throws FHIRException { 
          if (this.performed == null)
            this.performed = new Age();
          if (!(this.performed instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.performed.getClass().getName()+" was encountered");
          return (Age) this.performed;
        }

        public boolean hasPerformedAge() { 
          return this != null && this.performed instanceof Age;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public Range getPerformedRange() throws FHIRException { 
          if (this.performed == null)
            this.performed = new Range();
          if (!(this.performed instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.performed.getClass().getName()+" was encountered");
          return (Range) this.performed;
        }

        public boolean hasPerformedRange() { 
          return this != null && this.performed instanceof Range;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public Period getPerformedPeriod() throws FHIRException { 
          if (this.performed == null)
            this.performed = new Period();
          if (!(this.performed instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.performed.getClass().getName()+" was encountered");
          return (Period) this.performed;
        }

        public boolean hasPerformedPeriod() { 
          return this != null && this.performed instanceof Period;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public StringType getPerformedStringType() throws FHIRException { 
          if (this.performed == null)
            this.performed = new StringType();
          if (!(this.performed instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.performed.getClass().getName()+" was encountered");
          return (StringType) this.performed;
        }

        public boolean hasPerformedStringType() { 
          return this != null && this.performed instanceof StringType;
        }

        /**
         * @return {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public DateTimeType getPerformedDateTimeType() throws FHIRException { 
          if (this.performed == null)
            this.performed = new DateTimeType();
          if (!(this.performed instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.performed.getClass().getName()+" was encountered");
          return (DateTimeType) this.performed;
        }

        public boolean hasPerformedDateTimeType() { 
          return this != null && this.performed instanceof DateTimeType;
        }

        public boolean hasPerformed() { 
          return this.performed != null && !this.performed.isEmpty();
        }

        /**
         * @param value {@link #performed} (Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
         */
        public FamilyMemberHistoryProcedureComponent setPerformed(DataType value) { 
          if (value != null && !(value instanceof Age || value instanceof Range || value instanceof Period || value instanceof StringType || value instanceof DateTimeType))
            throw new Error("Not the right type for FamilyMemberHistory.procedure.performed[x]: "+value.fhirType());
          this.performed = value;
          return this;
        }

        /**
         * @return {@link #note} (An area where general notes can be placed about this specific procedure.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public FamilyMemberHistoryProcedureComponent setNote(List<Annotation> theNote) { 
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

        public FamilyMemberHistoryProcedureComponent addNote(Annotation t) { //3
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system.", 0, 1, code));
          children.add(new Property("outcome", "CodeableConcept", "Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation.", 0, 1, outcome));
          children.add(new Property("contributedToDeath", "boolean", "This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.", 0, 1, contributedToDeath));
          children.add(new Property("performed[x]", "Age|Range|Period|string|dateTime", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed));
          children.add(new Property("note", "Annotation", "An area where general notes can be placed about this specific procedure.", 0, java.lang.Integer.MAX_VALUE, note));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The actual procedure specified. Could be a coded procedure or a less specific string depending on how much is known about the procedure and the capabilities of the creating system.", 0, 1, code);
          case -1106507950: /*outcome*/  return new Property("outcome", "CodeableConcept", "Indicates what happened following the procedure. If the procedure resulted in death, deceased date is captured on the relation.", 0, 1, outcome);
          case -363644638: /*contributedToDeath*/  return new Property("contributedToDeath", "boolean", "This procedure contributed to the cause of death of the related person. If contributedToDeath is not populated, then it is unknown.", 0, 1, contributedToDeath);
          case 1355984064: /*performed[x]*/  return new Property("performed[x]", "Age|Range|Period|string|dateTime", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 481140672: /*performed*/  return new Property("performed[x]", "Age|Range|Period|string|dateTime", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 1355958559: /*performedAge*/  return new Property("performed[x]", "Age", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 1716617565: /*performedRange*/  return new Property("performed[x]", "Range", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 1622094241: /*performedPeriod*/  return new Property("performed[x]", "Period", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 1721834481: /*performedString*/  return new Property("performed[x]", "string", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 1118270331: /*performedDateTime*/  return new Property("performed[x]", "dateTime", "Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, performed);
          case 3387378: /*note*/  return new Property("note", "Annotation", "An area where general notes can be placed about this specific procedure.", 0, java.lang.Integer.MAX_VALUE, note);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // CodeableConcept
        case -363644638: /*contributedToDeath*/ return this.contributedToDeath == null ? new Base[0] : new Base[] {this.contributedToDeath}; // BooleanType
        case 481140672: /*performed*/ return this.performed == null ? new Base[0] : new Base[] {this.performed}; // DataType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1106507950: // outcome
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -363644638: // contributedToDeath
          this.contributedToDeath = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 481140672: // performed
          this.performed = TypeConvertor.castToType(value); // DataType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("outcome")) {
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("contributedToDeath")) {
          this.contributedToDeath = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("performed[x]")) {
          this.performed = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1106507950:  return getOutcome();
        case -363644638:  return getContributedToDeathElement();
        case 1355984064:  return getPerformed();
        case 481140672:  return getPerformed();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1106507950: /*outcome*/ return new String[] {"CodeableConcept"};
        case -363644638: /*contributedToDeath*/ return new String[] {"boolean"};
        case 481140672: /*performed*/ return new String[] {"Age", "Range", "Period", "string", "dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("outcome")) {
          this.outcome = new CodeableConcept();
          return this.outcome;
        }
        else if (name.equals("contributedToDeath")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.procedure.contributedToDeath");
        }
        else if (name.equals("performedAge")) {
          this.performed = new Age();
          return this.performed;
        }
        else if (name.equals("performedRange")) {
          this.performed = new Range();
          return this.performed;
        }
        else if (name.equals("performedPeriod")) {
          this.performed = new Period();
          return this.performed;
        }
        else if (name.equals("performedString")) {
          this.performed = new StringType();
          return this.performed;
        }
        else if (name.equals("performedDateTime")) {
          this.performed = new DateTimeType();
          return this.performed;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

      public FamilyMemberHistoryProcedureComponent copy() {
        FamilyMemberHistoryProcedureComponent dst = new FamilyMemberHistoryProcedureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FamilyMemberHistoryProcedureComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.contributedToDeath = contributedToDeath == null ? null : contributedToDeath.copy();
        dst.performed = performed == null ? null : performed.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryProcedureComponent))
          return false;
        FamilyMemberHistoryProcedureComponent o = (FamilyMemberHistoryProcedureComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(outcome, o.outcome, true) && compareDeep(contributedToDeath, o.contributedToDeath, true)
           && compareDeep(performed, o.performed, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistoryProcedureComponent))
          return false;
        FamilyMemberHistoryProcedureComponent o = (FamilyMemberHistoryProcedureComponent) other_;
        return compareValues(contributedToDeath, o.contributedToDeath, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, outcome, contributedToDeath
          , performed, note);
      }

  public String fhirType() {
    return "FamilyMemberHistory.procedure";

  }

  }

    /**
     * Business identifiers assigned to this family member history by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Id(s) for this record", formalDefinition="Business identifiers assigned to this family member history by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory." )
    protected List<UriType> instantiatesUri;

    /**
     * A code specifying the status of the record of the family history of a specific family member.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="partial | completed | entered-in-error | health-unknown", formalDefinition="A code specifying the status of the record of the family history of a specific family member." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/history-status")
    protected Enumeration<FamilyHistoryStatus> status;

    /**
     * Describes why the family member's history is not available.
     */
    @Child(name = "dataAbsentReason", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="subject-unknown | withheld | unable-to-obtain | deferred", formalDefinition="Describes why the family member's history is not available." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/history-absent-reason")
    protected CodeableConcept dataAbsentReason;

    /**
     * The person who this history concerns.
     */
    @Child(name = "patient", type = {Patient.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Patient history is about", formalDefinition="The person who this history concerns." )
    protected Reference patient;

    /**
     * The date (and possibly time) when the family member history was recorded or last updated.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When history was recorded or last updated", formalDefinition="The date (and possibly time) when the family member history was recorded or last updated." )
    protected DateTimeType date;

    /**
     * Indicates who or what participated in the activities related to the family member history and how they were involved.
     */
    @Child(name = "participant", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who or what participated in the activities related to the family member history and how they were involved", formalDefinition="Indicates who or what participated in the activities related to the family member history and how they were involved." )
    protected List<FamilyMemberHistoryParticipantComponent> participant;

    /**
     * This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".
     */
    @Child(name = "name", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The family member described", formalDefinition="This will either be a name or a description; e.g. \"Aunt Susan\", \"my cousin with the red hair\"." )
    protected StringType name;

    /**
     * The type of relationship this person has to the patient (father, mother, brother etc.).
     */
    @Child(name = "relationship", type = {CodeableConcept.class}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Relationship to the subject", formalDefinition="The type of relationship this person has to the patient (father, mother, brother etc.)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-FamilyMember")
    protected CodeableConcept relationship;

    /**
     * The birth sex of the family member.
     */
    @Child(name = "sex", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="male | female | other | unknown", formalDefinition="The birth sex of the family member." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrative-gender")
    protected CodeableConcept sex;

    /**
     * The actual or approximate date of birth of the relative.
     */
    @Child(name = "born", type = {Period.class, DateType.class, StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="(approximate) date of birth", formalDefinition="The actual or approximate date of birth of the relative." )
    protected DataType born;

    /**
     * The age of the relative at the time the family member history is recorded.
     */
    @Child(name = "age", type = {Age.class, Range.class, StringType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="(approximate) age", formalDefinition="The age of the relative at the time the family member history is recorded." )
    protected DataType age;

    /**
     * If true, indicates that the age value specified is an estimated value.
     */
    @Child(name = "estimatedAge", type = {BooleanType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Age is estimated?", formalDefinition="If true, indicates that the age value specified is an estimated value." )
    protected BooleanType estimatedAge;

    /**
     * Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.
     */
    @Child(name = "deceased", type = {BooleanType.class, Age.class, Range.class, DateType.class, StringType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Dead? How old/when?", formalDefinition="Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record." )
    protected DataType deceased;

    /**
     * Describes why the family member history occurred in coded or textual form, or Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies this family member history event.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why was family member history performed?", formalDefinition="Describes why the family member history occurred in coded or textual form, or Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies this family member history event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
    protected List<CodeableReference> reason;

    /**
     * This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible.
     */
    @Child(name = "note", type = {Annotation.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="General note about related person", formalDefinition="This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible." )
    protected List<Annotation> note;

    /**
     * The significant Conditions (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition.
     */
    @Child(name = "condition", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Condition that the related person had", formalDefinition="The significant Conditions (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition." )
    protected List<FamilyMemberHistoryConditionComponent> condition;

    /**
     * The significant Procedures (or procedure) that the family member had. This is a repeating section to allow a system to represent more than one procedure per resource, though there is nothing stopping multiple resources - one per procedure.
     */
    @Child(name = "procedure", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Procedures that the related person had", formalDefinition="The significant Procedures (or procedure) that the family member had. This is a repeating section to allow a system to represent more than one procedure per resource, though there is nothing stopping multiple resources - one per procedure." )
    protected List<FamilyMemberHistoryProcedureComponent> procedure;

    private static final long serialVersionUID = -1025621277L;

  /**
   * Constructor
   */
    public FamilyMemberHistory() {
      super();
    }

  /**
   * Constructor
   */
    public FamilyMemberHistory(FamilyHistoryStatus status, Reference patient, CodeableConcept relationship) {
      super();
      this.setStatus(status);
      this.setPatient(patient);
      this.setRelationship(relationship);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this family member history by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setIdentifier(List<Identifier> theIdentifier) { 
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

    public FamilyMemberHistory addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
      this.instantiatesCanonical = theInstantiatesCanonical;
      return this;
    }

    public boolean hasInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType item : this.instantiatesCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public FamilyMemberHistory addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public boolean hasInstantiatesCanonical(String value) { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType v : this.instantiatesCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setInstantiatesUri(List<UriType> theInstantiatesUri) { 
      this.instantiatesUri = theInstantiatesUri;
      return this;
    }

    public boolean hasInstantiatesUri() { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType item : this.instantiatesUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public FamilyMemberHistory addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.)
     */
    public boolean hasInstantiatesUri(String value) { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType v : this.instantiatesUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #status} (A code specifying the status of the record of the family history of a specific family member.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FamilyHistoryStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FamilyHistoryStatus>(new FamilyHistoryStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the status of the record of the family history of a specific family member.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public FamilyMemberHistory setStatusElement(Enumeration<FamilyHistoryStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the status of the record of the family history of a specific family member.
     */
    public FamilyHistoryStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the status of the record of the family history of a specific family member.
     */
    public FamilyMemberHistory setStatus(FamilyHistoryStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<FamilyHistoryStatus>(new FamilyHistoryStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #dataAbsentReason} (Describes why the family member's history is not available.)
     */
    public CodeableConcept getDataAbsentReason() { 
      if (this.dataAbsentReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.dataAbsentReason");
        else if (Configuration.doAutoCreate())
          this.dataAbsentReason = new CodeableConcept(); // cc
      return this.dataAbsentReason;
    }

    public boolean hasDataAbsentReason() { 
      return this.dataAbsentReason != null && !this.dataAbsentReason.isEmpty();
    }

    /**
     * @param value {@link #dataAbsentReason} (Describes why the family member's history is not available.)
     */
    public FamilyMemberHistory setDataAbsentReason(CodeableConcept value) { 
      this.dataAbsentReason = value;
      return this;
    }

    /**
     * @return {@link #patient} (The person who this history concerns.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The person who this history concerns.)
     */
    public FamilyMemberHistory setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #date} (The date (and possibly time) when the family member history was recorded or last updated.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date (and possibly time) when the family member history was recorded or last updated.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public FamilyMemberHistory setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date (and possibly time) when the family member history was recorded or last updated.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date (and possibly time) when the family member history was recorded or last updated.
     */
    public FamilyMemberHistory setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #participant} (Indicates who or what participated in the activities related to the family member history and how they were involved.)
     */
    public List<FamilyMemberHistoryParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<FamilyMemberHistoryParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setParticipant(List<FamilyMemberHistoryParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (FamilyMemberHistoryParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public FamilyMemberHistoryParticipantComponent addParticipant() { //3
      FamilyMemberHistoryParticipantComponent t = new FamilyMemberHistoryParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<FamilyMemberHistoryParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public FamilyMemberHistory addParticipant(FamilyMemberHistoryParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<FamilyMemberHistoryParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public FamilyMemberHistoryParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #name} (This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.name");
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
     * @param value {@link #name} (This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public FamilyMemberHistory setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".
     */
    public FamilyMemberHistory setName(String value) { 
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
     * @return {@link #relationship} (The type of relationship this person has to the patient (father, mother, brother etc.).)
     */
    public CodeableConcept getRelationship() { 
      if (this.relationship == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.relationship");
        else if (Configuration.doAutoCreate())
          this.relationship = new CodeableConcept(); // cc
      return this.relationship;
    }

    public boolean hasRelationship() { 
      return this.relationship != null && !this.relationship.isEmpty();
    }

    /**
     * @param value {@link #relationship} (The type of relationship this person has to the patient (father, mother, brother etc.).)
     */
    public FamilyMemberHistory setRelationship(CodeableConcept value) { 
      this.relationship = value;
      return this;
    }

    /**
     * @return {@link #sex} (The birth sex of the family member.)
     */
    public CodeableConcept getSex() { 
      if (this.sex == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.sex");
        else if (Configuration.doAutoCreate())
          this.sex = new CodeableConcept(); // cc
      return this.sex;
    }

    public boolean hasSex() { 
      return this.sex != null && !this.sex.isEmpty();
    }

    /**
     * @param value {@link #sex} (The birth sex of the family member.)
     */
    public FamilyMemberHistory setSex(CodeableConcept value) { 
      this.sex = value;
      return this;
    }

    /**
     * @return {@link #born} (The actual or approximate date of birth of the relative.)
     */
    public DataType getBorn() { 
      return this.born;
    }

    /**
     * @return {@link #born} (The actual or approximate date of birth of the relative.)
     */
    public Period getBornPeriod() throws FHIRException { 
      if (this.born == null)
        this.born = new Period();
      if (!(this.born instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.born.getClass().getName()+" was encountered");
      return (Period) this.born;
    }

    public boolean hasBornPeriod() { 
      return this != null && this.born instanceof Period;
    }

    /**
     * @return {@link #born} (The actual or approximate date of birth of the relative.)
     */
    public DateType getBornDateType() throws FHIRException { 
      if (this.born == null)
        this.born = new DateType();
      if (!(this.born instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.born.getClass().getName()+" was encountered");
      return (DateType) this.born;
    }

    public boolean hasBornDateType() { 
      return this != null && this.born instanceof DateType;
    }

    /**
     * @return {@link #born} (The actual or approximate date of birth of the relative.)
     */
    public StringType getBornStringType() throws FHIRException { 
      if (this.born == null)
        this.born = new StringType();
      if (!(this.born instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.born.getClass().getName()+" was encountered");
      return (StringType) this.born;
    }

    public boolean hasBornStringType() { 
      return this != null && this.born instanceof StringType;
    }

    public boolean hasBorn() { 
      return this.born != null && !this.born.isEmpty();
    }

    /**
     * @param value {@link #born} (The actual or approximate date of birth of the relative.)
     */
    public FamilyMemberHistory setBorn(DataType value) { 
      if (value != null && !(value instanceof Period || value instanceof DateType || value instanceof StringType))
        throw new Error("Not the right type for FamilyMemberHistory.born[x]: "+value.fhirType());
      this.born = value;
      return this;
    }

    /**
     * @return {@link #age} (The age of the relative at the time the family member history is recorded.)
     */
    public DataType getAge() { 
      return this.age;
    }

    /**
     * @return {@link #age} (The age of the relative at the time the family member history is recorded.)
     */
    public Age getAgeAge() throws FHIRException { 
      if (this.age == null)
        this.age = new Age();
      if (!(this.age instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.age.getClass().getName()+" was encountered");
      return (Age) this.age;
    }

    public boolean hasAgeAge() { 
      return this != null && this.age instanceof Age;
    }

    /**
     * @return {@link #age} (The age of the relative at the time the family member history is recorded.)
     */
    public Range getAgeRange() throws FHIRException { 
      if (this.age == null)
        this.age = new Range();
      if (!(this.age instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.age.getClass().getName()+" was encountered");
      return (Range) this.age;
    }

    public boolean hasAgeRange() { 
      return this != null && this.age instanceof Range;
    }

    /**
     * @return {@link #age} (The age of the relative at the time the family member history is recorded.)
     */
    public StringType getAgeStringType() throws FHIRException { 
      if (this.age == null)
        this.age = new StringType();
      if (!(this.age instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.age.getClass().getName()+" was encountered");
      return (StringType) this.age;
    }

    public boolean hasAgeStringType() { 
      return this != null && this.age instanceof StringType;
    }

    public boolean hasAge() { 
      return this.age != null && !this.age.isEmpty();
    }

    /**
     * @param value {@link #age} (The age of the relative at the time the family member history is recorded.)
     */
    public FamilyMemberHistory setAge(DataType value) { 
      if (value != null && !(value instanceof Age || value instanceof Range || value instanceof StringType))
        throw new Error("Not the right type for FamilyMemberHistory.age[x]: "+value.fhirType());
      this.age = value;
      return this;
    }

    /**
     * @return {@link #estimatedAge} (If true, indicates that the age value specified is an estimated value.). This is the underlying object with id, value and extensions. The accessor "getEstimatedAge" gives direct access to the value
     */
    public BooleanType getEstimatedAgeElement() { 
      if (this.estimatedAge == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FamilyMemberHistory.estimatedAge");
        else if (Configuration.doAutoCreate())
          this.estimatedAge = new BooleanType(); // bb
      return this.estimatedAge;
    }

    public boolean hasEstimatedAgeElement() { 
      return this.estimatedAge != null && !this.estimatedAge.isEmpty();
    }

    public boolean hasEstimatedAge() { 
      return this.estimatedAge != null && !this.estimatedAge.isEmpty();
    }

    /**
     * @param value {@link #estimatedAge} (If true, indicates that the age value specified is an estimated value.). This is the underlying object with id, value and extensions. The accessor "getEstimatedAge" gives direct access to the value
     */
    public FamilyMemberHistory setEstimatedAgeElement(BooleanType value) { 
      this.estimatedAge = value;
      return this;
    }

    /**
     * @return If true, indicates that the age value specified is an estimated value.
     */
    public boolean getEstimatedAge() { 
      return this.estimatedAge == null || this.estimatedAge.isEmpty() ? false : this.estimatedAge.getValue();
    }

    /**
     * @param value If true, indicates that the age value specified is an estimated value.
     */
    public FamilyMemberHistory setEstimatedAge(boolean value) { 
        if (this.estimatedAge == null)
          this.estimatedAge = new BooleanType();
        this.estimatedAge.setValue(value);
      return this;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public DataType getDeceased() { 
      return this.deceased;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public BooleanType getDeceasedBooleanType() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new BooleanType();
      if (!(this.deceased instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (BooleanType) this.deceased;
    }

    public boolean hasDeceasedBooleanType() { 
      return this != null && this.deceased instanceof BooleanType;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public Age getDeceasedAge() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new Age();
      if (!(this.deceased instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (Age) this.deceased;
    }

    public boolean hasDeceasedAge() { 
      return this != null && this.deceased instanceof Age;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public Range getDeceasedRange() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new Range();
      if (!(this.deceased instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (Range) this.deceased;
    }

    public boolean hasDeceasedRange() { 
      return this != null && this.deceased instanceof Range;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public DateType getDeceasedDateType() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new DateType();
      if (!(this.deceased instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (DateType) this.deceased;
    }

    public boolean hasDeceasedDateType() { 
      return this != null && this.deceased instanceof DateType;
    }

    /**
     * @return {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public StringType getDeceasedStringType() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new StringType();
      if (!(this.deceased instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (StringType) this.deceased;
    }

    public boolean hasDeceasedStringType() { 
      return this != null && this.deceased instanceof StringType;
    }

    public boolean hasDeceased() { 
      return this.deceased != null && !this.deceased.isEmpty();
    }

    /**
     * @param value {@link #deceased} (Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.)
     */
    public FamilyMemberHistory setDeceased(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof Age || value instanceof Range || value instanceof DateType || value instanceof StringType))
        throw new Error("Not the right type for FamilyMemberHistory.deceased[x]: "+value.fhirType());
      this.deceased = value;
      return this;
    }

    /**
     * @return {@link #reason} (Describes why the family member history occurred in coded or textual form, or Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies this family member history event.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public FamilyMemberHistory addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #note} (This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setNote(List<Annotation> theNote) { 
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

    public FamilyMemberHistory addNote(Annotation t) { //3
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
     * @return {@link #condition} (The significant Conditions (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition.)
     */
    public List<FamilyMemberHistoryConditionComponent> getCondition() { 
      if (this.condition == null)
        this.condition = new ArrayList<FamilyMemberHistoryConditionComponent>();
      return this.condition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setCondition(List<FamilyMemberHistoryConditionComponent> theCondition) { 
      this.condition = theCondition;
      return this;
    }

    public boolean hasCondition() { 
      if (this.condition == null)
        return false;
      for (FamilyMemberHistoryConditionComponent item : this.condition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public FamilyMemberHistoryConditionComponent addCondition() { //3
      FamilyMemberHistoryConditionComponent t = new FamilyMemberHistoryConditionComponent();
      if (this.condition == null)
        this.condition = new ArrayList<FamilyMemberHistoryConditionComponent>();
      this.condition.add(t);
      return t;
    }

    public FamilyMemberHistory addCondition(FamilyMemberHistoryConditionComponent t) { //3
      if (t == null)
        return this;
      if (this.condition == null)
        this.condition = new ArrayList<FamilyMemberHistoryConditionComponent>();
      this.condition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
     */
    public FamilyMemberHistoryConditionComponent getConditionFirstRep() { 
      if (getCondition().isEmpty()) {
        addCondition();
      }
      return getCondition().get(0);
    }

    /**
     * @return {@link #procedure} (The significant Procedures (or procedure) that the family member had. This is a repeating section to allow a system to represent more than one procedure per resource, though there is nothing stopping multiple resources - one per procedure.)
     */
    public List<FamilyMemberHistoryProcedureComponent> getProcedure() { 
      if (this.procedure == null)
        this.procedure = new ArrayList<FamilyMemberHistoryProcedureComponent>();
      return this.procedure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FamilyMemberHistory setProcedure(List<FamilyMemberHistoryProcedureComponent> theProcedure) { 
      this.procedure = theProcedure;
      return this;
    }

    public boolean hasProcedure() { 
      if (this.procedure == null)
        return false;
      for (FamilyMemberHistoryProcedureComponent item : this.procedure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public FamilyMemberHistoryProcedureComponent addProcedure() { //3
      FamilyMemberHistoryProcedureComponent t = new FamilyMemberHistoryProcedureComponent();
      if (this.procedure == null)
        this.procedure = new ArrayList<FamilyMemberHistoryProcedureComponent>();
      this.procedure.add(t);
      return t;
    }

    public FamilyMemberHistory addProcedure(FamilyMemberHistoryProcedureComponent t) { //3
      if (t == null)
        return this;
      if (this.procedure == null)
        this.procedure = new ArrayList<FamilyMemberHistoryProcedureComponent>();
      this.procedure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #procedure}, creating it if it does not already exist {3}
     */
    public FamilyMemberHistoryProcedureComponent getProcedureFirstRep() { 
      if (getProcedure().isEmpty()) {
        addProcedure();
      }
      return getProcedure().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this family member history by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition|Questionnaire|ActivityDefinition|Measure|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("status", "code", "A code specifying the status of the record of the family history of a specific family member.", 0, 1, status));
        children.add(new Property("dataAbsentReason", "CodeableConcept", "Describes why the family member's history is not available.", 0, 1, dataAbsentReason));
        children.add(new Property("patient", "Reference(Patient)", "The person who this history concerns.", 0, 1, patient));
        children.add(new Property("date", "dateTime", "The date (and possibly time) when the family member history was recorded or last updated.", 0, 1, date));
        children.add(new Property("participant", "", "Indicates who or what participated in the activities related to the family member history and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("name", "string", "This will either be a name or a description; e.g. \"Aunt Susan\", \"my cousin with the red hair\".", 0, 1, name));
        children.add(new Property("relationship", "CodeableConcept", "The type of relationship this person has to the patient (father, mother, brother etc.).", 0, 1, relationship));
        children.add(new Property("sex", "CodeableConcept", "The birth sex of the family member.", 0, 1, sex));
        children.add(new Property("born[x]", "Period|date|string", "The actual or approximate date of birth of the relative.", 0, 1, born));
        children.add(new Property("age[x]", "Age|Range|string", "The age of the relative at the time the family member history is recorded.", 0, 1, age));
        children.add(new Property("estimatedAge", "boolean", "If true, indicates that the age value specified is an estimated value.", 0, 1, estimatedAge));
        children.add(new Property("deceased[x]", "boolean|Age|Range|date|string", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|AllergyIntolerance|QuestionnaireResponse|DiagnosticReport|DocumentReference)", "Describes why the family member history occurred in coded or textual form, or Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies this family member history event.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("condition", "", "The significant Conditions (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition.", 0, java.lang.Integer.MAX_VALUE, condition));
        children.add(new Property("procedure", "", "The significant Procedures (or procedure) that the family member had. This is a repeating section to allow a system to represent more than one procedure per resource, though there is nothing stopping multiple resources - one per procedure.", 0, java.lang.Integer.MAX_VALUE, procedure));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this family member history by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition|Questionnaire|ActivityDefinition|Measure|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this FamilyMemberHistory.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the status of the record of the family history of a specific family member.", 0, 1, status);
        case 1034315687: /*dataAbsentReason*/  return new Property("dataAbsentReason", "CodeableConcept", "Describes why the family member's history is not available.", 0, 1, dataAbsentReason);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The person who this history concerns.", 0, 1, patient);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date (and possibly time) when the family member history was recorded or last updated.", 0, 1, date);
        case 767422259: /*participant*/  return new Property("participant", "", "Indicates who or what participated in the activities related to the family member history and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant);
        case 3373707: /*name*/  return new Property("name", "string", "This will either be a name or a description; e.g. \"Aunt Susan\", \"my cousin with the red hair\".", 0, 1, name);
        case -261851592: /*relationship*/  return new Property("relationship", "CodeableConcept", "The type of relationship this person has to the patient (father, mother, brother etc.).", 0, 1, relationship);
        case 113766: /*sex*/  return new Property("sex", "CodeableConcept", "The birth sex of the family member.", 0, 1, sex);
        case 67532951: /*born[x]*/  return new Property("born[x]", "Period|date|string", "The actual or approximate date of birth of the relative.", 0, 1, born);
        case 3029833: /*born*/  return new Property("born[x]", "Period|date|string", "The actual or approximate date of birth of the relative.", 0, 1, born);
        case 1497711210: /*bornPeriod*/  return new Property("born[x]", "Period", "The actual or approximate date of birth of the relative.", 0, 1, born);
        case 2092814999: /*bornDate*/  return new Property("born[x]", "date", "The actual or approximate date of birth of the relative.", 0, 1, born);
        case 1597451450: /*bornString*/  return new Property("born[x]", "string", "The actual or approximate date of birth of the relative.", 0, 1, born);
        case -1419716831: /*age[x]*/  return new Property("age[x]", "Age|Range|string", "The age of the relative at the time the family member history is recorded.", 0, 1, age);
        case 96511: /*age*/  return new Property("age[x]", "Age|Range|string", "The age of the relative at the time the family member history is recorded.", 0, 1, age);
        case -1419742336: /*ageAge*/  return new Property("age[x]", "Age", "The age of the relative at the time the family member history is recorded.", 0, 1, age);
        case 1442748286: /*ageRange*/  return new Property("age[x]", "Range", "The age of the relative at the time the family member history is recorded.", 0, 1, age);
        case 1821821424: /*ageString*/  return new Property("age[x]", "string", "The age of the relative at the time the family member history is recorded.", 0, 1, age);
        case 2130167587: /*estimatedAge*/  return new Property("estimatedAge", "boolean", "If true, indicates that the age value specified is an estimated value.", 0, 1, estimatedAge);
        case -1311442804: /*deceased[x]*/  return new Property("deceased[x]", "boolean|Age|Range|date|string", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case 561497972: /*deceased*/  return new Property("deceased[x]", "boolean|Age|Range|date|string", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case 497463828: /*deceasedBoolean*/  return new Property("deceased[x]", "boolean", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case -1311468309: /*deceasedAge*/  return new Property("deceased[x]", "Age", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case -1880094167: /*deceasedRange*/  return new Property("deceased[x]", "Range", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case -2000727742: /*deceasedDate*/  return new Property("deceased[x]", "date", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case 1892920485: /*deceasedString*/  return new Property("deceased[x]", "string", "Deceased flag or the actual or approximate age of the relative at the time of death for the family member history record.", 0, 1, deceased);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|AllergyIntolerance|QuestionnaireResponse|DiagnosticReport|DocumentReference)", "Describes why the family member history occurred in coded or textual form, or Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies this family member history event.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible.", 0, java.lang.Integer.MAX_VALUE, note);
        case -861311717: /*condition*/  return new Property("condition", "", "The significant Conditions (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition.", 0, java.lang.Integer.MAX_VALUE, condition);
        case -1095204141: /*procedure*/  return new Property("procedure", "", "The significant Procedures (or procedure) that the family member had. This is a repeating section to allow a system to represent more than one procedure per resource, though there is nothing stopping multiple resources - one per procedure.", 0, java.lang.Integer.MAX_VALUE, procedure);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FamilyHistoryStatus>
        case 1034315687: /*dataAbsentReason*/ return this.dataAbsentReason == null ? new Base[0] : new Base[] {this.dataAbsentReason}; // CodeableConcept
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // FamilyMemberHistoryParticipantComponent
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // CodeableConcept
        case 113766: /*sex*/ return this.sex == null ? new Base[0] : new Base[] {this.sex}; // CodeableConcept
        case 3029833: /*born*/ return this.born == null ? new Base[0] : new Base[] {this.born}; // DataType
        case 96511: /*age*/ return this.age == null ? new Base[0] : new Base[] {this.age}; // DataType
        case 2130167587: /*estimatedAge*/ return this.estimatedAge == null ? new Base[0] : new Base[] {this.estimatedAge}; // BooleanType
        case 561497972: /*deceased*/ return this.deceased == null ? new Base[0] : new Base[] {this.deceased}; // DataType
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // FamilyMemberHistoryConditionComponent
        case -1095204141: /*procedure*/ return this.procedure == null ? new Base[0] : this.procedure.toArray(new Base[this.procedure.size()]); // FamilyMemberHistoryProcedureComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -892481550: // status
          value = new FamilyHistoryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FamilyHistoryStatus>
          return value;
        case 1034315687: // dataAbsentReason
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 767422259: // participant
          this.getParticipant().add((FamilyMemberHistoryParticipantComponent) value); // FamilyMemberHistoryParticipantComponent
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -261851592: // relationship
          this.relationship = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 113766: // sex
          this.sex = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3029833: // born
          this.born = TypeConvertor.castToType(value); // DataType
          return value;
        case 96511: // age
          this.age = TypeConvertor.castToType(value); // DataType
          return value;
        case 2130167587: // estimatedAge
          this.estimatedAge = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 561497972: // deceased
          this.deceased = TypeConvertor.castToType(value); // DataType
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -861311717: // condition
          this.getCondition().add((FamilyMemberHistoryConditionComponent) value); // FamilyMemberHistoryConditionComponent
          return value;
        case -1095204141: // procedure
          this.getProcedure().add((FamilyMemberHistoryProcedureComponent) value); // FamilyMemberHistoryProcedureComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("status")) {
          value = new FamilyHistoryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FamilyHistoryStatus>
        } else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("participant")) {
          this.getParticipant().add((FamilyMemberHistoryParticipantComponent) value);
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("relationship")) {
          this.relationship = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("sex")) {
          this.sex = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("born[x]")) {
          this.born = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("age[x]")) {
          this.age = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("estimatedAge")) {
          this.estimatedAge = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("deceased[x]")) {
          this.deceased = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("condition")) {
          this.getCondition().add((FamilyMemberHistoryConditionComponent) value);
        } else if (name.equals("procedure")) {
          this.getProcedure().add((FamilyMemberHistoryProcedureComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case -892481550:  return getStatusElement();
        case 1034315687:  return getDataAbsentReason();
        case -791418107:  return getPatient();
        case 3076014:  return getDateElement();
        case 767422259:  return addParticipant(); 
        case 3373707:  return getNameElement();
        case -261851592:  return getRelationship();
        case 113766:  return getSex();
        case 67532951:  return getBorn();
        case 3029833:  return getBorn();
        case -1419716831:  return getAge();
        case 96511:  return getAge();
        case 2130167587:  return getEstimatedAgeElement();
        case -1311442804:  return getDeceased();
        case 561497972:  return getDeceased();
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
        case -861311717:  return addCondition(); 
        case -1095204141:  return addProcedure(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1034315687: /*dataAbsentReason*/ return new String[] {"CodeableConcept"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 767422259: /*participant*/ return new String[] {};
        case 3373707: /*name*/ return new String[] {"string"};
        case -261851592: /*relationship*/ return new String[] {"CodeableConcept"};
        case 113766: /*sex*/ return new String[] {"CodeableConcept"};
        case 3029833: /*born*/ return new String[] {"Period", "date", "string"};
        case 96511: /*age*/ return new String[] {"Age", "Range", "string"};
        case 2130167587: /*estimatedAge*/ return new String[] {"boolean"};
        case 561497972: /*deceased*/ return new String[] {"boolean", "Age", "Range", "date", "string"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -861311717: /*condition*/ return new String[] {};
        case -1095204141: /*procedure*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.instantiatesUri");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.status");
        }
        else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = new CodeableConcept();
          return this.dataAbsentReason;
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.date");
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.name");
        }
        else if (name.equals("relationship")) {
          this.relationship = new CodeableConcept();
          return this.relationship;
        }
        else if (name.equals("sex")) {
          this.sex = new CodeableConcept();
          return this.sex;
        }
        else if (name.equals("bornPeriod")) {
          this.born = new Period();
          return this.born;
        }
        else if (name.equals("bornDate")) {
          this.born = new DateType();
          return this.born;
        }
        else if (name.equals("bornString")) {
          this.born = new StringType();
          return this.born;
        }
        else if (name.equals("ageAge")) {
          this.age = new Age();
          return this.age;
        }
        else if (name.equals("ageRange")) {
          this.age = new Range();
          return this.age;
        }
        else if (name.equals("ageString")) {
          this.age = new StringType();
          return this.age;
        }
        else if (name.equals("estimatedAge")) {
          throw new FHIRException("Cannot call addChild on a primitive type FamilyMemberHistory.estimatedAge");
        }
        else if (name.equals("deceasedBoolean")) {
          this.deceased = new BooleanType();
          return this.deceased;
        }
        else if (name.equals("deceasedAge")) {
          this.deceased = new Age();
          return this.deceased;
        }
        else if (name.equals("deceasedRange")) {
          this.deceased = new Range();
          return this.deceased;
        }
        else if (name.equals("deceasedDate")) {
          this.deceased = new DateType();
          return this.deceased;
        }
        else if (name.equals("deceasedString")) {
          this.deceased = new StringType();
          return this.deceased;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("condition")) {
          return addCondition();
        }
        else if (name.equals("procedure")) {
          return addProcedure();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "FamilyMemberHistory";

  }

      public FamilyMemberHistory copy() {
        FamilyMemberHistory dst = new FamilyMemberHistory();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FamilyMemberHistory dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.dataAbsentReason = dataAbsentReason == null ? null : dataAbsentReason.copy();
        dst.patient = patient == null ? null : patient.copy();
        dst.date = date == null ? null : date.copy();
        if (participant != null) {
          dst.participant = new ArrayList<FamilyMemberHistoryParticipantComponent>();
          for (FamilyMemberHistoryParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.sex = sex == null ? null : sex.copy();
        dst.born = born == null ? null : born.copy();
        dst.age = age == null ? null : age.copy();
        dst.estimatedAge = estimatedAge == null ? null : estimatedAge.copy();
        dst.deceased = deceased == null ? null : deceased.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (condition != null) {
          dst.condition = new ArrayList<FamilyMemberHistoryConditionComponent>();
          for (FamilyMemberHistoryConditionComponent i : condition)
            dst.condition.add(i.copy());
        };
        if (procedure != null) {
          dst.procedure = new ArrayList<FamilyMemberHistoryProcedureComponent>();
          for (FamilyMemberHistoryProcedureComponent i : procedure)
            dst.procedure.add(i.copy());
        };
      }

      protected FamilyMemberHistory typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistory))
          return false;
        FamilyMemberHistory o = (FamilyMemberHistory) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(status, o.status, true)
           && compareDeep(dataAbsentReason, o.dataAbsentReason, true) && compareDeep(patient, o.patient, true)
           && compareDeep(date, o.date, true) && compareDeep(participant, o.participant, true) && compareDeep(name, o.name, true)
           && compareDeep(relationship, o.relationship, true) && compareDeep(sex, o.sex, true) && compareDeep(born, o.born, true)
           && compareDeep(age, o.age, true) && compareDeep(estimatedAge, o.estimatedAge, true) && compareDeep(deceased, o.deceased, true)
           && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true) && compareDeep(condition, o.condition, true)
           && compareDeep(procedure, o.procedure, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FamilyMemberHistory))
          return false;
        FamilyMemberHistory o = (FamilyMemberHistory) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(name, o.name, true)
           && compareValues(estimatedAge, o.estimatedAge, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, status, dataAbsentReason, patient, date, participant, name
          , relationship, sex, born, age, estimatedAge, deceased, reason, note, condition
          , procedure);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.FamilyMemberHistory;
   }

 /**
   * Search parameter: <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>FamilyMemberHistory.instantiatesCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-canonical", path="FamilyMemberHistory.instantiatesCanonical", description="Instantiates FHIR protocol or definition", type="reference", target={ActivityDefinition.class, Measure.class, OperationDefinition.class, PlanDefinition.class, Questionnaire.class } )
  public static final String SP_INSTANTIATES_CANONICAL = "instantiates-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>FamilyMemberHistory.instantiatesCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSTANTIATES_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSTANTIATES_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>FamilyMemberHistory:instantiates-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSTANTIATES_CANONICAL = new ca.uhn.fhir.model.api.Include("FamilyMemberHistory:instantiates-canonical").toLocked();

 /**
   * Search parameter: <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>FamilyMemberHistory.instantiatesUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-uri", path="FamilyMemberHistory.instantiatesUri", description="Instantiates external protocol or definition", type="uri" )
  public static final String SP_INSTANTIATES_URI = "instantiates-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>FamilyMemberHistory.instantiatesUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam INSTANTIATES_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_INSTANTIATES_URI);

 /**
   * Search parameter: <b>relationship</b>
   * <p>
   * Description: <b>A search by a relationship type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.relationship</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relationship", path="FamilyMemberHistory.relationship", description="A search by a relationship type", type="token" )
  public static final String SP_RELATIONSHIP = "relationship";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relationship</b>
   * <p>
   * Description: <b>A search by a relationship type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.relationship</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RELATIONSHIP = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RELATIONSHIP);

 /**
   * Search parameter: <b>sex</b>
   * <p>
   * Description: <b>A search by a sex code of a family member</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.sex</b><br>
   * </p>
   */
  @SearchParamDefinition(name="sex", path="FamilyMemberHistory.sex", description="A search by a sex code of a family member", type="token" )
  public static final String SP_SEX = "sex";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>sex</b>
   * <p>
   * Description: <b>A search by a sex code of a family member</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.sex</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SEX = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SEX);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>partial | completed | entered-in-error | health-unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="FamilyMemberHistory.status", description="partial | completed | entered-in-error | health-unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>partial | completed | entered-in-error | health-unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FamilyMemberHistory.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [Condition](condition.html): Code for the condition\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationUsage](medicationusage.html): Return statements of this medication code\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.as(dateTime) | DiagnosticReport.effective.as(Period) | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective.as(dateTime) | Observation.effective.as(Period) | Observation.effective.as(Timing) | Observation.effective.as(instant) | Procedure.occurrence.as(dateTime) | Procedure.occurrence.as(Period) | Procedure.occurrence.as(Timing) | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.as(dateTime) | DiagnosticReport.effective.as(Period) | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective.as(dateTime) | Observation.effective.as(Period) | Observation.effective.as(Timing) | Observation.effective.as(instant) | Procedure.occurrence.as(dateTime) | Procedure.occurrence.as(Period) | Procedure.occurrence.as(Timing) | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [List](list.html): When the list was prepared\r\n* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.as(dateTime) | DiagnosticReport.effective.as(Period) | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective.as(dateTime) | Observation.effective.as(Period) | Observation.effective.as(Timing) | Observation.effective.as(instant) | Procedure.occurrence.as(dateTime) | Procedure.occurrence.as(Period) | Procedure.occurrence.as(Timing) | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>FamilyMemberHistory:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("FamilyMemberHistory:patient").toLocked();


}

