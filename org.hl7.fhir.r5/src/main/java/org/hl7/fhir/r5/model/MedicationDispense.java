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
 * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
 */
@ResourceDef(name="MedicationDispense", profile="http://hl7.org/fhir/StructureDefinition/MedicationDispense")
public class MedicationDispense extends DomainResource {

    public enum MedicationDispenseStatusCodes {
        /**
         * The core event has not started yet, but some staging activities have begun (e.g. initial compounding or packaging of medication). Preparation stages may be tracked for billing purposes.
         */
        PREPARATION, 
        /**
         * The dispensed product is ready for pickup.
         */
        INPROGRESS, 
        /**
         * The dispensed product was not and will never be picked up by the patient.
         */
        CANCELLED, 
        /**
         * The dispense process is paused while waiting for an external event to reactivate the dispense.  For example, new stock has arrived or the prescriber has called.
         */
        ONHOLD, 
        /**
         * The dispensed product has been picked up.
         */
        COMPLETED, 
        /**
         * The dispense was entered in error and therefore nullified.
         */
        ENTEREDINERROR, 
        /**
         * Actions implied by the dispense have been permanently halted, before all of them occurred.
         */
        STOPPED, 
        /**
         * The dispense was declined and not performed.
         */
        DECLINED, 
        /**
         * The authoring system does not know which of the status values applies for this medication dispense.  Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just now known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationDispenseStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return PREPARATION;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("declined".equals(codeString))
          return DECLINED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MedicationDispenseStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREPARATION: return "preparation";
            case INPROGRESS: return "in-progress";
            case CANCELLED: return "cancelled";
            case ONHOLD: return "on-hold";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case STOPPED: return "stopped";
            case DECLINED: return "declined";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREPARATION: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case INPROGRESS: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case CANCELLED: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case ONHOLD: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case COMPLETED: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case STOPPED: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case DECLINED: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case UNKNOWN: return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREPARATION: return "The core event has not started yet, but some staging activities have begun (e.g. initial compounding or packaging of medication). Preparation stages may be tracked for billing purposes.";
            case INPROGRESS: return "The dispensed product is ready for pickup.";
            case CANCELLED: return "The dispensed product was not and will never be picked up by the patient.";
            case ONHOLD: return "The dispense process is paused while waiting for an external event to reactivate the dispense.  For example, new stock has arrived or the prescriber has called.";
            case COMPLETED: return "The dispensed product has been picked up.";
            case ENTEREDINERROR: return "The dispense was entered in error and therefore nullified.";
            case STOPPED: return "Actions implied by the dispense have been permanently halted, before all of them occurred.";
            case DECLINED: return "The dispense was declined and not performed.";
            case UNKNOWN: return "The authoring system does not know which of the status values applies for this medication dispense.  Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just now known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREPARATION: return "Preparation";
            case INPROGRESS: return "In Progress";
            case CANCELLED: return "Cancelled";
            case ONHOLD: return "On Hold";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case STOPPED: return "Stopped";
            case DECLINED: return "Declined";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MedicationDispenseStatusCodesEnumFactory implements EnumFactory<MedicationDispenseStatusCodes> {
    public MedicationDispenseStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return MedicationDispenseStatusCodes.PREPARATION;
        if ("in-progress".equals(codeString))
          return MedicationDispenseStatusCodes.INPROGRESS;
        if ("cancelled".equals(codeString))
          return MedicationDispenseStatusCodes.CANCELLED;
        if ("on-hold".equals(codeString))
          return MedicationDispenseStatusCodes.ONHOLD;
        if ("completed".equals(codeString))
          return MedicationDispenseStatusCodes.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return MedicationDispenseStatusCodes.ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return MedicationDispenseStatusCodes.STOPPED;
        if ("declined".equals(codeString))
          return MedicationDispenseStatusCodes.DECLINED;
        if ("unknown".equals(codeString))
          return MedicationDispenseStatusCodes.UNKNOWN;
        throw new IllegalArgumentException("Unknown MedicationDispenseStatusCodes code '"+codeString+"'");
        }
        public Enumeration<MedicationDispenseStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.NULL, code);
        if ("preparation".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.PREPARATION, code);
        if ("in-progress".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.INPROGRESS, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.CANCELLED, code);
        if ("on-hold".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.ONHOLD, code);
        if ("completed".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.COMPLETED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.ENTEREDINERROR, code);
        if ("stopped".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.STOPPED, code);
        if ("declined".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.DECLINED, code);
        if ("unknown".equals(codeString))
          return new Enumeration<MedicationDispenseStatusCodes>(this, MedicationDispenseStatusCodes.UNKNOWN, code);
        throw new FHIRException("Unknown MedicationDispenseStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationDispenseStatusCodes code) {
      if (code == MedicationDispenseStatusCodes.PREPARATION)
        return "preparation";
      if (code == MedicationDispenseStatusCodes.INPROGRESS)
        return "in-progress";
      if (code == MedicationDispenseStatusCodes.CANCELLED)
        return "cancelled";
      if (code == MedicationDispenseStatusCodes.ONHOLD)
        return "on-hold";
      if (code == MedicationDispenseStatusCodes.COMPLETED)
        return "completed";
      if (code == MedicationDispenseStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == MedicationDispenseStatusCodes.STOPPED)
        return "stopped";
      if (code == MedicationDispenseStatusCodes.DECLINED)
        return "declined";
      if (code == MedicationDispenseStatusCodes.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(MedicationDispenseStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MedicationDispensePerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who performed the dispense and what they did", formalDefinition="Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationdispense-performer-function")
        protected CodeableConcept function;

        /**
         * The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, Device.class, RelatedPerson.class, CareTeam.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual who was performing", formalDefinition="The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public MedicationDispensePerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationDispensePerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationDispensePerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.)
         */
        public MedicationDispensePerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationDispensePerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.)
         */
        public MedicationDispensePerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson|CareTeam)", "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson|CareTeam)", "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.", 0, 1, actor);
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = null;
        } else if (name.equals("actor")) {
          this.actor = null;
        } else
          super.removeChild(name, value);
        
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

      public MedicationDispensePerformerComponent copy() {
        MedicationDispensePerformerComponent dst = new MedicationDispensePerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationDispensePerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationDispensePerformerComponent))
          return false;
        MedicationDispensePerformerComponent o = (MedicationDispensePerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationDispensePerformerComponent))
          return false;
        MedicationDispensePerformerComponent o = (MedicationDispensePerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "MedicationDispense.performer";

  }

  }

    @Block()
    public static class MedicationDispenseSubstitutionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * True if the dispenser dispensed a different drug or product from what was prescribed.
         */
        @Child(name = "wasSubstituted", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether a substitution was or was not performed on the dispense", formalDefinition="True if the dispenser dispensed a different drug or product from what was prescribed." )
        protected BooleanType wasSubstituted;

        /**
         * A code signifying whether a different drug was dispensed from what was prescribed.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code signifying whether a different drug was dispensed from what was prescribed", formalDefinition="A code signifying whether a different drug was dispensed from what was prescribed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActSubstanceAdminSubstitutionCode")
        protected CodeableConcept type;

        /**
         * Indicates the reason for the substitution (or lack of substitution) from what was prescribed.
         */
        @Child(name = "reason", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Why was substitution made", formalDefinition="Indicates the reason for the substitution (or lack of substitution) from what was prescribed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-SubstanceAdminSubstitutionReason")
        protected List<CodeableConcept> reason;

        /**
         * The person or organization that has primary responsibility for the substitution.
         */
        @Child(name = "responsibleParty", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who is responsible for the substitution", formalDefinition="The person or organization that has primary responsibility for the substitution." )
        protected Reference responsibleParty;

        private static final long serialVersionUID = 431402218L;

    /**
     * Constructor
     */
      public MedicationDispenseSubstitutionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationDispenseSubstitutionComponent(boolean wasSubstituted) {
        super();
        this.setWasSubstituted(wasSubstituted);
      }

        /**
         * @return {@link #wasSubstituted} (True if the dispenser dispensed a different drug or product from what was prescribed.). This is the underlying object with id, value and extensions. The accessor "getWasSubstituted" gives direct access to the value
         */
        public BooleanType getWasSubstitutedElement() { 
          if (this.wasSubstituted == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationDispenseSubstitutionComponent.wasSubstituted");
            else if (Configuration.doAutoCreate())
              this.wasSubstituted = new BooleanType(); // bb
          return this.wasSubstituted;
        }

        public boolean hasWasSubstitutedElement() { 
          return this.wasSubstituted != null && !this.wasSubstituted.isEmpty();
        }

        public boolean hasWasSubstituted() { 
          return this.wasSubstituted != null && !this.wasSubstituted.isEmpty();
        }

        /**
         * @param value {@link #wasSubstituted} (True if the dispenser dispensed a different drug or product from what was prescribed.). This is the underlying object with id, value and extensions. The accessor "getWasSubstituted" gives direct access to the value
         */
        public MedicationDispenseSubstitutionComponent setWasSubstitutedElement(BooleanType value) { 
          this.wasSubstituted = value;
          return this;
        }

        /**
         * @return True if the dispenser dispensed a different drug or product from what was prescribed.
         */
        public boolean getWasSubstituted() { 
          return this.wasSubstituted == null || this.wasSubstituted.isEmpty() ? false : this.wasSubstituted.getValue();
        }

        /**
         * @param value True if the dispenser dispensed a different drug or product from what was prescribed.
         */
        public MedicationDispenseSubstitutionComponent setWasSubstituted(boolean value) { 
            if (this.wasSubstituted == null)
              this.wasSubstituted = new BooleanType();
            this.wasSubstituted.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (A code signifying whether a different drug was dispensed from what was prescribed.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationDispenseSubstitutionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code signifying whether a different drug was dispensed from what was prescribed.)
         */
        public MedicationDispenseSubstitutionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #reason} (Indicates the reason for the substitution (or lack of substitution) from what was prescribed.)
         */
        public List<CodeableConcept> getReason() { 
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          return this.reason;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationDispenseSubstitutionComponent setReason(List<CodeableConcept> theReason) { 
          this.reason = theReason;
          return this;
        }

        public boolean hasReason() { 
          if (this.reason == null)
            return false;
          for (CodeableConcept item : this.reason)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addReason() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return t;
        }

        public MedicationDispenseSubstitutionComponent addReason(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
         */
        public CodeableConcept getReasonFirstRep() { 
          if (getReason().isEmpty()) {
            addReason();
          }
          return getReason().get(0);
        }

        /**
         * @return {@link #responsibleParty} (The person or organization that has primary responsibility for the substitution.)
         */
        public Reference getResponsibleParty() { 
          if (this.responsibleParty == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationDispenseSubstitutionComponent.responsibleParty");
            else if (Configuration.doAutoCreate())
              this.responsibleParty = new Reference(); // cc
          return this.responsibleParty;
        }

        public boolean hasResponsibleParty() { 
          return this.responsibleParty != null && !this.responsibleParty.isEmpty();
        }

        /**
         * @param value {@link #responsibleParty} (The person or organization that has primary responsibility for the substitution.)
         */
        public MedicationDispenseSubstitutionComponent setResponsibleParty(Reference value) { 
          this.responsibleParty = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("wasSubstituted", "boolean", "True if the dispenser dispensed a different drug or product from what was prescribed.", 0, 1, wasSubstituted));
          children.add(new Property("type", "CodeableConcept", "A code signifying whether a different drug was dispensed from what was prescribed.", 0, 1, type));
          children.add(new Property("reason", "CodeableConcept", "Indicates the reason for the substitution (or lack of substitution) from what was prescribed.", 0, java.lang.Integer.MAX_VALUE, reason));
          children.add(new Property("responsibleParty", "Reference(Practitioner|PractitionerRole|Organization)", "The person or organization that has primary responsibility for the substitution.", 0, 1, responsibleParty));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -592113567: /*wasSubstituted*/  return new Property("wasSubstituted", "boolean", "True if the dispenser dispensed a different drug or product from what was prescribed.", 0, 1, wasSubstituted);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code signifying whether a different drug was dispensed from what was prescribed.", 0, 1, type);
          case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "Indicates the reason for the substitution (or lack of substitution) from what was prescribed.", 0, java.lang.Integer.MAX_VALUE, reason);
          case 1511509392: /*responsibleParty*/  return new Property("responsibleParty", "Reference(Practitioner|PractitionerRole|Organization)", "The person or organization that has primary responsibility for the substitution.", 0, 1, responsibleParty);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -592113567: /*wasSubstituted*/ return this.wasSubstituted == null ? new Base[0] : new Base[] {this.wasSubstituted}; // BooleanType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableConcept
        case 1511509392: /*responsibleParty*/ return this.responsibleParty == null ? new Base[0] : new Base[] {this.responsibleParty}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -592113567: // wasSubstituted
          this.wasSubstituted = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1511509392: // responsibleParty
          this.responsibleParty = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("wasSubstituted")) {
          this.wasSubstituted = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("responsibleParty")) {
          this.responsibleParty = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("wasSubstituted")) {
          this.wasSubstituted = null;
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("reason")) {
          this.getReason().remove(value);
        } else if (name.equals("responsibleParty")) {
          this.responsibleParty = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -592113567:  return getWasSubstitutedElement();
        case 3575610:  return getType();
        case -934964668:  return addReason(); 
        case 1511509392:  return getResponsibleParty();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -592113567: /*wasSubstituted*/ return new String[] {"boolean"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        case 1511509392: /*responsibleParty*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("wasSubstituted")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.substitution.wasSubstituted");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("responsibleParty")) {
          this.responsibleParty = new Reference();
          return this.responsibleParty;
        }
        else
          return super.addChild(name);
      }

      public MedicationDispenseSubstitutionComponent copy() {
        MedicationDispenseSubstitutionComponent dst = new MedicationDispenseSubstitutionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationDispenseSubstitutionComponent dst) {
        super.copyValues(dst);
        dst.wasSubstituted = wasSubstituted == null ? null : wasSubstituted.copy();
        dst.type = type == null ? null : type.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reason)
            dst.reason.add(i.copy());
        };
        dst.responsibleParty = responsibleParty == null ? null : responsibleParty.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationDispenseSubstitutionComponent))
          return false;
        MedicationDispenseSubstitutionComponent o = (MedicationDispenseSubstitutionComponent) other_;
        return compareDeep(wasSubstituted, o.wasSubstituted, true) && compareDeep(type, o.type, true) && compareDeep(reason, o.reason, true)
           && compareDeep(responsibleParty, o.responsibleParty, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationDispenseSubstitutionComponent))
          return false;
        MedicationDispenseSubstitutionComponent o = (MedicationDispenseSubstitutionComponent) other_;
        return compareValues(wasSubstituted, o.wasSubstituted, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(wasSubstituted, type, reason
          , responsibleParty);
      }

  public String fhirType() {
    return "MedicationDispense.substitution";

  }

  }

    /**
     * Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="External identifier", formalDefinition="Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A plan that is fulfilled in whole or in part by this MedicationDispense.
     */
    @Child(name = "basedOn", type = {CarePlan.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Plan that is fulfilled by this dispense", formalDefinition="A plan that is fulfilled in whole or in part by this MedicationDispense." )
    protected List<Reference> basedOn;

    /**
     * The procedure or medication administration that triggered the dispense.
     */
    @Child(name = "partOf", type = {Procedure.class, MedicationAdministration.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Event that dispense is part of", formalDefinition="The procedure or medication administration that triggered the dispense." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the set of dispense events.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped | declined | unknown", formalDefinition="A code specifying the state of the set of dispense events." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationdispense-status")
    protected Enumeration<MedicationDispenseStatusCodes> status;

    /**
     * Indicates the reason why a dispense was not performed.
     */
    @Child(name = "notPerformedReason", type = {CodeableReference.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why a dispense was not performed", formalDefinition="Indicates the reason why a dispense was not performed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationdispense-status-reason")
    protected CodeableReference notPerformedReason;

    /**
     * The date (and maybe time) when the status of the dispense record changed.
     */
    @Child(name = "statusChanged", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the status changed", formalDefinition="The date (and maybe time) when the status of the dispense record changed." )
    protected DateTimeType statusChanged;

    /**
     * Indicates the type of medication dispense (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Type of medication dispense", formalDefinition="Indicates the type of medication dispense (for example, drug classification like ATC, where meds would be administered, legal category of the medication.)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationdispense-admin-location")
    protected List<CodeableConcept> category;

    /**
     * Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.
     */
    @Child(name = "medication", type = {CodeableReference.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What medication was supplied", formalDefinition="Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableReference medication;

    /**
     * A link to a resource representing the person or the group to whom the medication will be given.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who the dispense is for", formalDefinition="A link to a resource representing the person or the group to whom the medication will be given." )
    protected Reference subject;

    /**
     * The encounter that establishes the context for this event.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Encounter associated with event", formalDefinition="The encounter that establishes the context for this event." )
    protected Reference encounter;

    /**
     * Additional information that supports the medication being dispensed.  For example, there may be requirements that a specific lab test has been completed prior to dispensing or the patient's weight at the time of dispensing is documented.
     */
    @Child(name = "supportingInformation", type = {Reference.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information that supports the dispensing of the medication", formalDefinition="Additional information that supports the medication being dispensed.  For example, there may be requirements that a specific lab test has been completed prior to dispensing or the patient's weight at the time of dispensing is documented." )
    protected List<Reference> supportingInformation;

    /**
     * Indicates who or what performed the event.
     */
    @Child(name = "performer", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who performed event", formalDefinition="Indicates who or what performed the event." )
    protected List<MedicationDispensePerformerComponent> performer;

    /**
     * The principal physical location where the dispense was performed.
     */
    @Child(name = "location", type = {Location.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the dispense occurred", formalDefinition="The principal physical location where the dispense was performed." )
    protected Reference location;

    /**
     * Indicates the medication order that is being dispensed against.
     */
    @Child(name = "authorizingPrescription", type = {MedicationRequest.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Medication order that authorizes the dispense", formalDefinition="Indicates the medication order that is being dispensed against." )
    protected List<Reference> authorizingPrescription;

    /**
     * Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Trial fill, partial fill, emergency fill, etc", formalDefinition="Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActPharmacySupplyType")
    protected CodeableConcept type;

    /**
     * The amount of medication that has been dispensed. Includes unit of measure.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Amount dispensed", formalDefinition="The amount of medication that has been dispensed. Includes unit of measure." )
    protected Quantity quantity;

    /**
     * The amount of medication expressed as a timing amount.
     */
    @Child(name = "daysSupply", type = {Quantity.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Amount of medication expressed as a timing amount", formalDefinition="The amount of medication expressed as a timing amount." )
    protected Quantity daysSupply;

    /**
     * The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.
     */
    @Child(name = "recorded", type = {DateTimeType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the recording of the dispense started", formalDefinition="The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated." )
    protected DateTimeType recorded;

    /**
     * The time when the dispensed product was packaged and reviewed.
     */
    @Child(name = "whenPrepared", type = {DateTimeType.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When product was packaged and reviewed", formalDefinition="The time when the dispensed product was packaged and reviewed." )
    protected DateTimeType whenPrepared;

    /**
     * The time the dispensed product was provided to the patient or their representative.
     */
    @Child(name = "whenHandedOver", type = {DateTimeType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When product was given out", formalDefinition="The time the dispensed product was provided to the patient or their representative." )
    protected DateTimeType whenHandedOver;

    /**
     * Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event.
     */
    @Child(name = "destination", type = {Location.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the medication was/will be sent", formalDefinition="Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event." )
    protected Reference destination;

    /**
     * Identifies the person who picked up the medication or the location of where the medication was delivered.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.
     */
    @Child(name = "receiver", type = {Patient.class, Practitioner.class, RelatedPerson.class, Location.class, PractitionerRole.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who collected the medication or where the medication was delivered", formalDefinition="Identifies the person who picked up the medication or the location of where the medication was delivered.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location." )
    protected List<Reference> receiver;

    /**
     * Extra information about the dispense that could not be conveyed in the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information about the dispense", formalDefinition="Extra information about the dispense that could not be conveyed in the other attributes." )
    protected List<Annotation> note;

    /**
     * The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    @Child(name = "renderedDosageInstruction", type = {MarkdownType.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Full representation of the dosage instructions", formalDefinition="The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses." )
    protected MarkdownType renderedDosageInstruction;

    /**
     * Indicates how the medication is to be used by the patient.
     */
    @Child(name = "dosageInstruction", type = {Dosage.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="How the medication is to be used by the patient or administered by the caregiver", formalDefinition="Indicates how the medication is to be used by the patient." )
    protected List<Dosage> dosageInstruction;

    /**
     * Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.
     */
    @Child(name = "substitution", type = {}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Whether a substitution was performed on the dispense", formalDefinition="Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done." )
    protected MedicationDispenseSubstitutionComponent substitution;

    /**
     * A summary of the events of interest that have occurred, such as when the dispense was verified.
     */
    @Child(name = "eventHistory", type = {Provenance.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A list of relevant lifecycle events", formalDefinition="A summary of the events of interest that have occurred, such as when the dispense was verified." )
    protected List<Reference> eventHistory;

    private static final long serialVersionUID = 88138059L;

  /**
   * Constructor
   */
    public MedicationDispense() {
      super();
    }

  /**
   * Constructor
   */
    public MedicationDispense(MedicationDispenseStatusCodes status, CodeableReference medication, Reference subject) {
      super();
      this.setStatus(status);
      this.setMedication(medication);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setIdentifier(List<Identifier> theIdentifier) { 
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

    public MedicationDispense addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan that is fulfilled in whole or in part by this MedicationDispense.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setBasedOn(List<Reference> theBasedOn) { 
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

    public MedicationDispense addBasedOn(Reference t) { //3
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
     * @return {@link #partOf} (The procedure or medication administration that triggered the dispense.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public MedicationDispense addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #status} (A code specifying the state of the set of dispense events.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<MedicationDispenseStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<MedicationDispenseStatusCodes>(new MedicationDispenseStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the set of dispense events.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MedicationDispense setStatusElement(Enumeration<MedicationDispenseStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the set of dispense events.
     */
    public MedicationDispenseStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the set of dispense events.
     */
    public MedicationDispense setStatus(MedicationDispenseStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<MedicationDispenseStatusCodes>(new MedicationDispenseStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #notPerformedReason} (Indicates the reason why a dispense was not performed.)
     */
    public CodeableReference getNotPerformedReason() { 
      if (this.notPerformedReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.notPerformedReason");
        else if (Configuration.doAutoCreate())
          this.notPerformedReason = new CodeableReference(); // cc
      return this.notPerformedReason;
    }

    public boolean hasNotPerformedReason() { 
      return this.notPerformedReason != null && !this.notPerformedReason.isEmpty();
    }

    /**
     * @param value {@link #notPerformedReason} (Indicates the reason why a dispense was not performed.)
     */
    public MedicationDispense setNotPerformedReason(CodeableReference value) { 
      this.notPerformedReason = value;
      return this;
    }

    /**
     * @return {@link #statusChanged} (The date (and maybe time) when the status of the dispense record changed.). This is the underlying object with id, value and extensions. The accessor "getStatusChanged" gives direct access to the value
     */
    public DateTimeType getStatusChangedElement() { 
      if (this.statusChanged == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.statusChanged");
        else if (Configuration.doAutoCreate())
          this.statusChanged = new DateTimeType(); // bb
      return this.statusChanged;
    }

    public boolean hasStatusChangedElement() { 
      return this.statusChanged != null && !this.statusChanged.isEmpty();
    }

    public boolean hasStatusChanged() { 
      return this.statusChanged != null && !this.statusChanged.isEmpty();
    }

    /**
     * @param value {@link #statusChanged} (The date (and maybe time) when the status of the dispense record changed.). This is the underlying object with id, value and extensions. The accessor "getStatusChanged" gives direct access to the value
     */
    public MedicationDispense setStatusChangedElement(DateTimeType value) { 
      this.statusChanged = value;
      return this;
    }

    /**
     * @return The date (and maybe time) when the status of the dispense record changed.
     */
    public Date getStatusChanged() { 
      return this.statusChanged == null ? null : this.statusChanged.getValue();
    }

    /**
     * @param value The date (and maybe time) when the status of the dispense record changed.
     */
    public MedicationDispense setStatusChanged(Date value) { 
      if (value == null)
        this.statusChanged = null;
      else {
        if (this.statusChanged == null)
          this.statusChanged = new DateTimeType();
        this.statusChanged.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (Indicates the type of medication dispense (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public MedicationDispense addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #medication} (Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.)
     */
    public CodeableReference getMedication() { 
      if (this.medication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.medication");
        else if (Configuration.doAutoCreate())
          this.medication = new CodeableReference(); // cc
      return this.medication;
    }

    public boolean hasMedication() { 
      return this.medication != null && !this.medication.isEmpty();
    }

    /**
     * @param value {@link #medication} (Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.)
     */
    public MedicationDispense setMedication(CodeableReference value) { 
      this.medication = value;
      return this;
    }

    /**
     * @return {@link #subject} (A link to a resource representing the person or the group to whom the medication will be given.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (A link to a resource representing the person or the group to whom the medication will be given.)
     */
    public MedicationDispense setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter that establishes the context for this event.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter that establishes the context for this event.)
     */
    public MedicationDispense setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #supportingInformation} (Additional information that supports the medication being dispensed.  For example, there may be requirements that a specific lab test has been completed prior to dispensing or the patient's weight at the time of dispensing is documented.)
     */
    public List<Reference> getSupportingInformation() { 
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      return this.supportingInformation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setSupportingInformation(List<Reference> theSupportingInformation) { 
      this.supportingInformation = theSupportingInformation;
      return this;
    }

    public boolean hasSupportingInformation() { 
      if (this.supportingInformation == null)
        return false;
      for (Reference item : this.supportingInformation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInformation() { //3
      Reference t = new Reference();
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return t;
    }

    public MedicationDispense addSupportingInformation(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInformation}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInformationFirstRep() { 
      if (getSupportingInformation().isEmpty()) {
        addSupportingInformation();
      }
      return getSupportingInformation().get(0);
    }

    /**
     * @return {@link #performer} (Indicates who or what performed the event.)
     */
    public List<MedicationDispensePerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<MedicationDispensePerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setPerformer(List<MedicationDispensePerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (MedicationDispensePerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationDispensePerformerComponent addPerformer() { //3
      MedicationDispensePerformerComponent t = new MedicationDispensePerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<MedicationDispensePerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public MedicationDispense addPerformer(MedicationDispensePerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<MedicationDispensePerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public MedicationDispensePerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #location} (The principal physical location where the dispense was performed.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The principal physical location where the dispense was performed.)
     */
    public MedicationDispense setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #authorizingPrescription} (Indicates the medication order that is being dispensed against.)
     */
    public List<Reference> getAuthorizingPrescription() { 
      if (this.authorizingPrescription == null)
        this.authorizingPrescription = new ArrayList<Reference>();
      return this.authorizingPrescription;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setAuthorizingPrescription(List<Reference> theAuthorizingPrescription) { 
      this.authorizingPrescription = theAuthorizingPrescription;
      return this;
    }

    public boolean hasAuthorizingPrescription() { 
      if (this.authorizingPrescription == null)
        return false;
      for (Reference item : this.authorizingPrescription)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAuthorizingPrescription() { //3
      Reference t = new Reference();
      if (this.authorizingPrescription == null)
        this.authorizingPrescription = new ArrayList<Reference>();
      this.authorizingPrescription.add(t);
      return t;
    }

    public MedicationDispense addAuthorizingPrescription(Reference t) { //3
      if (t == null)
        return this;
      if (this.authorizingPrescription == null)
        this.authorizingPrescription = new ArrayList<Reference>();
      this.authorizingPrescription.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #authorizingPrescription}, creating it if it does not already exist {3}
     */
    public Reference getAuthorizingPrescriptionFirstRep() { 
      if (getAuthorizingPrescription().isEmpty()) {
        addAuthorizingPrescription();
      }
      return getAuthorizingPrescription().get(0);
    }

    /**
     * @return {@link #type} (Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.)
     */
    public MedicationDispense setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The amount of medication that has been dispensed. Includes unit of measure.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The amount of medication that has been dispensed. Includes unit of measure.)
     */
    public MedicationDispense setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #daysSupply} (The amount of medication expressed as a timing amount.)
     */
    public Quantity getDaysSupply() { 
      if (this.daysSupply == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.daysSupply");
        else if (Configuration.doAutoCreate())
          this.daysSupply = new Quantity(); // cc
      return this.daysSupply;
    }

    public boolean hasDaysSupply() { 
      return this.daysSupply != null && !this.daysSupply.isEmpty();
    }

    /**
     * @param value {@link #daysSupply} (The amount of medication expressed as a timing amount.)
     */
    public MedicationDispense setDaysSupply(Quantity value) { 
      this.daysSupply = value;
      return this;
    }

    /**
     * @return {@link #recorded} (The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public DateTimeType getRecordedElement() { 
      if (this.recorded == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.recorded");
        else if (Configuration.doAutoCreate())
          this.recorded = new DateTimeType(); // bb
      return this.recorded;
    }

    public boolean hasRecordedElement() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    public boolean hasRecorded() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    /**
     * @param value {@link #recorded} (The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public MedicationDispense setRecordedElement(DateTimeType value) { 
      this.recorded = value;
      return this;
    }

    /**
     * @return The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.
     */
    public Date getRecorded() { 
      return this.recorded == null ? null : this.recorded.getValue();
    }

    /**
     * @param value The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.
     */
    public MedicationDispense setRecorded(Date value) { 
      if (value == null)
        this.recorded = null;
      else {
        if (this.recorded == null)
          this.recorded = new DateTimeType();
        this.recorded.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #whenPrepared} (The time when the dispensed product was packaged and reviewed.). This is the underlying object with id, value and extensions. The accessor "getWhenPrepared" gives direct access to the value
     */
    public DateTimeType getWhenPreparedElement() { 
      if (this.whenPrepared == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.whenPrepared");
        else if (Configuration.doAutoCreate())
          this.whenPrepared = new DateTimeType(); // bb
      return this.whenPrepared;
    }

    public boolean hasWhenPreparedElement() { 
      return this.whenPrepared != null && !this.whenPrepared.isEmpty();
    }

    public boolean hasWhenPrepared() { 
      return this.whenPrepared != null && !this.whenPrepared.isEmpty();
    }

    /**
     * @param value {@link #whenPrepared} (The time when the dispensed product was packaged and reviewed.). This is the underlying object with id, value and extensions. The accessor "getWhenPrepared" gives direct access to the value
     */
    public MedicationDispense setWhenPreparedElement(DateTimeType value) { 
      this.whenPrepared = value;
      return this;
    }

    /**
     * @return The time when the dispensed product was packaged and reviewed.
     */
    public Date getWhenPrepared() { 
      return this.whenPrepared == null ? null : this.whenPrepared.getValue();
    }

    /**
     * @param value The time when the dispensed product was packaged and reviewed.
     */
    public MedicationDispense setWhenPrepared(Date value) { 
      if (value == null)
        this.whenPrepared = null;
      else {
        if (this.whenPrepared == null)
          this.whenPrepared = new DateTimeType();
        this.whenPrepared.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #whenHandedOver} (The time the dispensed product was provided to the patient or their representative.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public DateTimeType getWhenHandedOverElement() { 
      if (this.whenHandedOver == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.whenHandedOver");
        else if (Configuration.doAutoCreate())
          this.whenHandedOver = new DateTimeType(); // bb
      return this.whenHandedOver;
    }

    public boolean hasWhenHandedOverElement() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    public boolean hasWhenHandedOver() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    /**
     * @param value {@link #whenHandedOver} (The time the dispensed product was provided to the patient or their representative.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public MedicationDispense setWhenHandedOverElement(DateTimeType value) { 
      this.whenHandedOver = value;
      return this;
    }

    /**
     * @return The time the dispensed product was provided to the patient or their representative.
     */
    public Date getWhenHandedOver() { 
      return this.whenHandedOver == null ? null : this.whenHandedOver.getValue();
    }

    /**
     * @param value The time the dispensed product was provided to the patient or their representative.
     */
    public MedicationDispense setWhenHandedOver(Date value) { 
      if (value == null)
        this.whenHandedOver = null;
      else {
        if (this.whenHandedOver == null)
          this.whenHandedOver = new DateTimeType();
        this.whenHandedOver.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #destination} (Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event.)
     */
    public Reference getDestination() { 
      if (this.destination == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.destination");
        else if (Configuration.doAutoCreate())
          this.destination = new Reference(); // cc
      return this.destination;
    }

    public boolean hasDestination() { 
      return this.destination != null && !this.destination.isEmpty();
    }

    /**
     * @param value {@link #destination} (Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event.)
     */
    public MedicationDispense setDestination(Reference value) { 
      this.destination = value;
      return this;
    }

    /**
     * @return {@link #receiver} (Identifies the person who picked up the medication or the location of where the medication was delivered.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.)
     */
    public List<Reference> getReceiver() { 
      if (this.receiver == null)
        this.receiver = new ArrayList<Reference>();
      return this.receiver;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setReceiver(List<Reference> theReceiver) { 
      this.receiver = theReceiver;
      return this;
    }

    public boolean hasReceiver() { 
      if (this.receiver == null)
        return false;
      for (Reference item : this.receiver)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReceiver() { //3
      Reference t = new Reference();
      if (this.receiver == null)
        this.receiver = new ArrayList<Reference>();
      this.receiver.add(t);
      return t;
    }

    public MedicationDispense addReceiver(Reference t) { //3
      if (t == null)
        return this;
      if (this.receiver == null)
        this.receiver = new ArrayList<Reference>();
      this.receiver.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #receiver}, creating it if it does not already exist {3}
     */
    public Reference getReceiverFirstRep() { 
      if (getReceiver().isEmpty()) {
        addReceiver();
      }
      return getReceiver().get(0);
    }

    /**
     * @return {@link #note} (Extra information about the dispense that could not be conveyed in the other attributes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setNote(List<Annotation> theNote) { 
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

    public MedicationDispense addNote(Annotation t) { //3
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
     * @return {@link #renderedDosageInstruction} (The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.). This is the underlying object with id, value and extensions. The accessor "getRenderedDosageInstruction" gives direct access to the value
     */
    public MarkdownType getRenderedDosageInstructionElement() { 
      if (this.renderedDosageInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.renderedDosageInstruction");
        else if (Configuration.doAutoCreate())
          this.renderedDosageInstruction = new MarkdownType(); // bb
      return this.renderedDosageInstruction;
    }

    public boolean hasRenderedDosageInstructionElement() { 
      return this.renderedDosageInstruction != null && !this.renderedDosageInstruction.isEmpty();
    }

    public boolean hasRenderedDosageInstruction() { 
      return this.renderedDosageInstruction != null && !this.renderedDosageInstruction.isEmpty();
    }

    /**
     * @param value {@link #renderedDosageInstruction} (The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.). This is the underlying object with id, value and extensions. The accessor "getRenderedDosageInstruction" gives direct access to the value
     */
    public MedicationDispense setRenderedDosageInstructionElement(MarkdownType value) { 
      this.renderedDosageInstruction = value;
      return this;
    }

    /**
     * @return The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    public String getRenderedDosageInstruction() { 
      return this.renderedDosageInstruction == null ? null : this.renderedDosageInstruction.getValue();
    }

    /**
     * @param value The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    public MedicationDispense setRenderedDosageInstruction(String value) { 
      if (Utilities.noString(value))
        this.renderedDosageInstruction = null;
      else {
        if (this.renderedDosageInstruction == null)
          this.renderedDosageInstruction = new MarkdownType();
        this.renderedDosageInstruction.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dosageInstruction} (Indicates how the medication is to be used by the patient.)
     */
    public List<Dosage> getDosageInstruction() { 
      if (this.dosageInstruction == null)
        this.dosageInstruction = new ArrayList<Dosage>();
      return this.dosageInstruction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setDosageInstruction(List<Dosage> theDosageInstruction) { 
      this.dosageInstruction = theDosageInstruction;
      return this;
    }

    public boolean hasDosageInstruction() { 
      if (this.dosageInstruction == null)
        return false;
      for (Dosage item : this.dosageInstruction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Dosage addDosageInstruction() { //3
      Dosage t = new Dosage();
      if (this.dosageInstruction == null)
        this.dosageInstruction = new ArrayList<Dosage>();
      this.dosageInstruction.add(t);
      return t;
    }

    public MedicationDispense addDosageInstruction(Dosage t) { //3
      if (t == null)
        return this;
      if (this.dosageInstruction == null)
        this.dosageInstruction = new ArrayList<Dosage>();
      this.dosageInstruction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosageInstruction}, creating it if it does not already exist {3}
     */
    public Dosage getDosageInstructionFirstRep() { 
      if (getDosageInstruction().isEmpty()) {
        addDosageInstruction();
      }
      return getDosageInstruction().get(0);
    }

    /**
     * @return {@link #substitution} (Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.)
     */
    public MedicationDispenseSubstitutionComponent getSubstitution() { 
      if (this.substitution == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispense.substitution");
        else if (Configuration.doAutoCreate())
          this.substitution = new MedicationDispenseSubstitutionComponent(); // cc
      return this.substitution;
    }

    public boolean hasSubstitution() { 
      return this.substitution != null && !this.substitution.isEmpty();
    }

    /**
     * @param value {@link #substitution} (Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.)
     */
    public MedicationDispense setSubstitution(MedicationDispenseSubstitutionComponent value) { 
      this.substitution = value;
      return this;
    }

    /**
     * @return {@link #eventHistory} (A summary of the events of interest that have occurred, such as when the dispense was verified.)
     */
    public List<Reference> getEventHistory() { 
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      return this.eventHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispense setEventHistory(List<Reference> theEventHistory) { 
      this.eventHistory = theEventHistory;
      return this;
    }

    public boolean hasEventHistory() { 
      if (this.eventHistory == null)
        return false;
      for (Reference item : this.eventHistory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEventHistory() { //3
      Reference t = new Reference();
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      this.eventHistory.add(t);
      return t;
    }

    public MedicationDispense addEventHistory(Reference t) { //3
      if (t == null)
        return this;
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      this.eventHistory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #eventHistory}, creating it if it does not already exist {3}
     */
    public Reference getEventHistoryFirstRep() { 
      if (getEventHistory().isEmpty()) {
        addEventHistory();
      }
      return getEventHistory().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(CarePlan)", "A plan that is fulfilled in whole or in part by this MedicationDispense.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(Procedure|MedicationAdministration)", "The procedure or medication administration that triggered the dispense.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the set of dispense events.", 0, 1, status));
        children.add(new Property("notPerformedReason", "CodeableReference(DetectedIssue)", "Indicates the reason why a dispense was not performed.", 0, 1, notPerformedReason));
        children.add(new Property("statusChanged", "dateTime", "The date (and maybe time) when the status of the dispense record changed.", 0, 1, statusChanged));
        children.add(new Property("category", "CodeableConcept", "Indicates the type of medication dispense (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("medication", "CodeableReference(Medication)", "Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication));
        children.add(new Property("subject", "Reference(Patient|Group)", "A link to a resource representing the person or the group to whom the medication will be given.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this event.", 0, 1, encounter));
        children.add(new Property("supportingInformation", "Reference(Any)", "Additional information that supports the medication being dispensed.  For example, there may be requirements that a specific lab test has been completed prior to dispensing or the patient's weight at the time of dispensing is documented.", 0, java.lang.Integer.MAX_VALUE, supportingInformation));
        children.add(new Property("performer", "", "Indicates who or what performed the event.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "Reference(Location)", "The principal physical location where the dispense was performed.", 0, 1, location));
        children.add(new Property("authorizingPrescription", "Reference(MedicationRequest)", "Indicates the medication order that is being dispensed against.", 0, java.lang.Integer.MAX_VALUE, authorizingPrescription));
        children.add(new Property("type", "CodeableConcept", "Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.", 0, 1, type));
        children.add(new Property("quantity", "Quantity", "The amount of medication that has been dispensed. Includes unit of measure.", 0, 1, quantity));
        children.add(new Property("daysSupply", "Quantity", "The amount of medication expressed as a timing amount.", 0, 1, daysSupply));
        children.add(new Property("recorded", "dateTime", "The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.", 0, 1, recorded));
        children.add(new Property("whenPrepared", "dateTime", "The time when the dispensed product was packaged and reviewed.", 0, 1, whenPrepared));
        children.add(new Property("whenHandedOver", "dateTime", "The time the dispensed product was provided to the patient or their representative.", 0, 1, whenHandedOver));
        children.add(new Property("destination", "Reference(Location)", "Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event.", 0, 1, destination));
        children.add(new Property("receiver", "Reference(Patient|Practitioner|RelatedPerson|Location|PractitionerRole)", "Identifies the person who picked up the medication or the location of where the medication was delivered.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.", 0, java.lang.Integer.MAX_VALUE, receiver));
        children.add(new Property("note", "Annotation", "Extra information about the dispense that could not be conveyed in the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("renderedDosageInstruction", "markdown", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction));
        children.add(new Property("dosageInstruction", "Dosage", "Indicates how the medication is to be used by the patient.", 0, java.lang.Integer.MAX_VALUE, dosageInstruction));
        children.add(new Property("substitution", "", "Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.", 0, 1, substitution));
        children.add(new Property("eventHistory", "Reference(Provenance)", "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0, java.lang.Integer.MAX_VALUE, eventHistory));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan)", "A plan that is fulfilled in whole or in part by this MedicationDispense.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Procedure|MedicationAdministration)", "The procedure or medication administration that triggered the dispense.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the set of dispense events.", 0, 1, status);
        case -820839727: /*notPerformedReason*/  return new Property("notPerformedReason", "CodeableReference(DetectedIssue)", "Indicates the reason why a dispense was not performed.", 0, 1, notPerformedReason);
        case -1174686110: /*statusChanged*/  return new Property("statusChanged", "dateTime", "The date (and maybe time) when the status of the dispense record changed.", 0, 1, statusChanged);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Indicates the type of medication dispense (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category);
        case 1998965455: /*medication*/  return new Property("medication", "CodeableReference(Medication)", "Identifies the medication supplied. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "A link to a resource representing the person or the group to whom the medication will be given.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this event.", 0, 1, encounter);
        case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "Reference(Any)", "Additional information that supports the medication being dispensed.  For example, there may be requirements that a specific lab test has been completed prior to dispensing or the patient's weight at the time of dispensing is documented.", 0, java.lang.Integer.MAX_VALUE, supportingInformation);
        case 481140686: /*performer*/  return new Property("performer", "", "Indicates who or what performed the event.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The principal physical location where the dispense was performed.", 0, 1, location);
        case -1237557856: /*authorizingPrescription*/  return new Property("authorizingPrescription", "Reference(MedicationRequest)", "Indicates the medication order that is being dispensed against.", 0, java.lang.Integer.MAX_VALUE, authorizingPrescription);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.", 0, 1, type);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The amount of medication that has been dispensed. Includes unit of measure.", 0, 1, quantity);
        case 197175334: /*daysSupply*/  return new Property("daysSupply", "Quantity", "The amount of medication expressed as a timing amount.", 0, 1, daysSupply);
        case -799233872: /*recorded*/  return new Property("recorded", "dateTime", "The date (and maybe time) when the dispense activity started if whenPrepared or whenHandedOver is not populated.", 0, 1, recorded);
        case -562837097: /*whenPrepared*/  return new Property("whenPrepared", "dateTime", "The time when the dispensed product was packaged and reviewed.", 0, 1, whenPrepared);
        case -940241380: /*whenHandedOver*/  return new Property("whenHandedOver", "dateTime", "The time the dispensed product was provided to the patient or their representative.", 0, 1, whenHandedOver);
        case -1429847026: /*destination*/  return new Property("destination", "Reference(Location)", "Identification of the facility/location where the medication was/will be shipped to, as part of the dispense event.", 0, 1, destination);
        case -808719889: /*receiver*/  return new Property("receiver", "Reference(Patient|Practitioner|RelatedPerson|Location|PractitionerRole)", "Identifies the person who picked up the medication or the location of where the medication was delivered.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.", 0, java.lang.Integer.MAX_VALUE, receiver);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Extra information about the dispense that could not be conveyed in the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1718902050: /*renderedDosageInstruction*/  return new Property("renderedDosageInstruction", "markdown", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction);
        case -1201373865: /*dosageInstruction*/  return new Property("dosageInstruction", "Dosage", "Indicates how the medication is to be used by the patient.", 0, java.lang.Integer.MAX_VALUE, dosageInstruction);
        case 826147581: /*substitution*/  return new Property("substitution", "", "Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.", 0, 1, substitution);
        case 1835190426: /*eventHistory*/  return new Property("eventHistory", "Reference(Provenance)", "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0, java.lang.Integer.MAX_VALUE, eventHistory);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationDispenseStatusCodes>
        case -820839727: /*notPerformedReason*/ return this.notPerformedReason == null ? new Base[0] : new Base[] {this.notPerformedReason}; // CodeableReference
        case -1174686110: /*statusChanged*/ return this.statusChanged == null ? new Base[0] : new Base[] {this.statusChanged}; // DateTimeType
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 1998965455: /*medication*/ return this.medication == null ? new Base[0] : new Base[] {this.medication}; // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // MedicationDispensePerformerComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -1237557856: /*authorizingPrescription*/ return this.authorizingPrescription == null ? new Base[0] : this.authorizingPrescription.toArray(new Base[this.authorizingPrescription.size()]); // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 197175334: /*daysSupply*/ return this.daysSupply == null ? new Base[0] : new Base[] {this.daysSupply}; // Quantity
        case -799233872: /*recorded*/ return this.recorded == null ? new Base[0] : new Base[] {this.recorded}; // DateTimeType
        case -562837097: /*whenPrepared*/ return this.whenPrepared == null ? new Base[0] : new Base[] {this.whenPrepared}; // DateTimeType
        case -940241380: /*whenHandedOver*/ return this.whenHandedOver == null ? new Base[0] : new Base[] {this.whenHandedOver}; // DateTimeType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // Reference
        case -808719889: /*receiver*/ return this.receiver == null ? new Base[0] : this.receiver.toArray(new Base[this.receiver.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1718902050: /*renderedDosageInstruction*/ return this.renderedDosageInstruction == null ? new Base[0] : new Base[] {this.renderedDosageInstruction}; // MarkdownType
        case -1201373865: /*dosageInstruction*/ return this.dosageInstruction == null ? new Base[0] : this.dosageInstruction.toArray(new Base[this.dosageInstruction.size()]); // Dosage
        case 826147581: /*substitution*/ return this.substitution == null ? new Base[0] : new Base[] {this.substitution}; // MedicationDispenseSubstitutionComponent
        case 1835190426: /*eventHistory*/ return this.eventHistory == null ? new Base[0] : this.eventHistory.toArray(new Base[this.eventHistory.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new MedicationDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationDispenseStatusCodes>
          return value;
        case -820839727: // notPerformedReason
          this.notPerformedReason = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1174686110: // statusChanged
          this.statusChanged = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1998965455: // medication
          this.medication = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1248768647: // supportingInformation
          this.getSupportingInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 481140686: // performer
          this.getPerformer().add((MedicationDispensePerformerComponent) value); // MedicationDispensePerformerComponent
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1237557856: // authorizingPrescription
          this.getAuthorizingPrescription().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 197175334: // daysSupply
          this.daysSupply = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -799233872: // recorded
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -562837097: // whenPrepared
          this.whenPrepared = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -940241380: // whenHandedOver
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToReference(value); // Reference
          return value;
        case -808719889: // receiver
          this.getReceiver().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1718902050: // renderedDosageInstruction
          this.renderedDosageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1201373865: // dosageInstruction
          this.getDosageInstruction().add(TypeConvertor.castToDosage(value)); // Dosage
          return value;
        case 826147581: // substitution
          this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
          return value;
        case 1835190426: // eventHistory
          this.getEventHistory().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new MedicationDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationDispenseStatusCodes>
        } else if (name.equals("notPerformedReason")) {
          this.notPerformedReason = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("statusChanged")) {
          this.statusChanged = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("medication")) {
          this.medication = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("performer")) {
          this.getPerformer().add((MedicationDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("authorizingPrescription")) {
          this.getAuthorizingPrescription().add(TypeConvertor.castToReference(value));
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("daysSupply")) {
          this.daysSupply = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("recorded")) {
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("whenPrepared")) {
          this.whenPrepared = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("receiver")) {
          this.getReceiver().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("renderedDosageInstruction")) {
          this.renderedDosageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("dosageInstruction")) {
          this.getDosageInstruction().add(TypeConvertor.castToDosage(value));
        } else if (name.equals("substitution")) {
          this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
        } else if (name.equals("eventHistory")) {
          this.getEventHistory().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("basedOn")) {
          this.getBasedOn().remove(value);
        } else if (name.equals("partOf")) {
          this.getPartOf().remove(value);
        } else if (name.equals("status")) {
          value = new MedicationDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationDispenseStatusCodes>
        } else if (name.equals("notPerformedReason")) {
          this.notPerformedReason = null;
        } else if (name.equals("statusChanged")) {
          this.statusChanged = null;
        } else if (name.equals("category")) {
          this.getCategory().remove(value);
        } else if (name.equals("medication")) {
          this.medication = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("encounter")) {
          this.encounter = null;
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().remove(value);
        } else if (name.equals("performer")) {
          this.getPerformer().add((MedicationDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("authorizingPrescription")) {
          this.getAuthorizingPrescription().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("daysSupply")) {
          this.daysSupply = null;
        } else if (name.equals("recorded")) {
          this.recorded = null;
        } else if (name.equals("whenPrepared")) {
          this.whenPrepared = null;
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = null;
        } else if (name.equals("destination")) {
          this.destination = null;
        } else if (name.equals("receiver")) {
          this.getReceiver().remove(value);
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("renderedDosageInstruction")) {
          this.renderedDosageInstruction = null;
        } else if (name.equals("dosageInstruction")) {
          this.getDosageInstruction().remove(value);
        } else if (name.equals("substitution")) {
          this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
        } else if (name.equals("eventHistory")) {
          this.getEventHistory().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case -820839727:  return getNotPerformedReason();
        case -1174686110:  return getStatusChangedElement();
        case 50511102:  return addCategory(); 
        case 1998965455:  return getMedication();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -1248768647:  return addSupportingInformation(); 
        case 481140686:  return addPerformer(); 
        case 1901043637:  return getLocation();
        case -1237557856:  return addAuthorizingPrescription(); 
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case 197175334:  return getDaysSupply();
        case -799233872:  return getRecordedElement();
        case -562837097:  return getWhenPreparedElement();
        case -940241380:  return getWhenHandedOverElement();
        case -1429847026:  return getDestination();
        case -808719889:  return addReceiver(); 
        case 3387378:  return addNote(); 
        case 1718902050:  return getRenderedDosageInstructionElement();
        case -1201373865:  return addDosageInstruction(); 
        case 826147581:  return getSubstitution();
        case 1835190426:  return addEventHistory(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -820839727: /*notPerformedReason*/ return new String[] {"CodeableReference"};
        case -1174686110: /*statusChanged*/ return new String[] {"dateTime"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1998965455: /*medication*/ return new String[] {"CodeableReference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1248768647: /*supportingInformation*/ return new String[] {"Reference"};
        case 481140686: /*performer*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -1237557856: /*authorizingPrescription*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 197175334: /*daysSupply*/ return new String[] {"Quantity"};
        case -799233872: /*recorded*/ return new String[] {"dateTime"};
        case -562837097: /*whenPrepared*/ return new String[] {"dateTime"};
        case -940241380: /*whenHandedOver*/ return new String[] {"dateTime"};
        case -1429847026: /*destination*/ return new String[] {"Reference"};
        case -808719889: /*receiver*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1718902050: /*renderedDosageInstruction*/ return new String[] {"markdown"};
        case -1201373865: /*dosageInstruction*/ return new String[] {"Dosage"};
        case 826147581: /*substitution*/ return new String[] {};
        case 1835190426: /*eventHistory*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.status");
        }
        else if (name.equals("notPerformedReason")) {
          this.notPerformedReason = new CodeableReference();
          return this.notPerformedReason;
        }
        else if (name.equals("statusChanged")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.statusChanged");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("medication")) {
          this.medication = new CodeableReference();
          return this.medication;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("supportingInformation")) {
          return addSupportingInformation();
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("authorizingPrescription")) {
          return addAuthorizingPrescription();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("daysSupply")) {
          this.daysSupply = new Quantity();
          return this.daysSupply;
        }
        else if (name.equals("recorded")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.recorded");
        }
        else if (name.equals("whenPrepared")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.whenPrepared");
        }
        else if (name.equals("whenHandedOver")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.whenHandedOver");
        }
        else if (name.equals("destination")) {
          this.destination = new Reference();
          return this.destination;
        }
        else if (name.equals("receiver")) {
          return addReceiver();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("renderedDosageInstruction")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.renderedDosageInstruction");
        }
        else if (name.equals("dosageInstruction")) {
          return addDosageInstruction();
        }
        else if (name.equals("substitution")) {
          this.substitution = new MedicationDispenseSubstitutionComponent();
          return this.substitution;
        }
        else if (name.equals("eventHistory")) {
          return addEventHistory();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MedicationDispense";

  }

      public MedicationDispense copy() {
        MedicationDispense dst = new MedicationDispense();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationDispense dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.notPerformedReason = notPerformedReason == null ? null : notPerformedReason.copy();
        dst.statusChanged = statusChanged == null ? null : statusChanged.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.medication = medication == null ? null : medication.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        if (supportingInformation != null) {
          dst.supportingInformation = new ArrayList<Reference>();
          for (Reference i : supportingInformation)
            dst.supportingInformation.add(i.copy());
        };
        if (performer != null) {
          dst.performer = new ArrayList<MedicationDispensePerformerComponent>();
          for (MedicationDispensePerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (authorizingPrescription != null) {
          dst.authorizingPrescription = new ArrayList<Reference>();
          for (Reference i : authorizingPrescription)
            dst.authorizingPrescription.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.daysSupply = daysSupply == null ? null : daysSupply.copy();
        dst.recorded = recorded == null ? null : recorded.copy();
        dst.whenPrepared = whenPrepared == null ? null : whenPrepared.copy();
        dst.whenHandedOver = whenHandedOver == null ? null : whenHandedOver.copy();
        dst.destination = destination == null ? null : destination.copy();
        if (receiver != null) {
          dst.receiver = new ArrayList<Reference>();
          for (Reference i : receiver)
            dst.receiver.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.renderedDosageInstruction = renderedDosageInstruction == null ? null : renderedDosageInstruction.copy();
        if (dosageInstruction != null) {
          dst.dosageInstruction = new ArrayList<Dosage>();
          for (Dosage i : dosageInstruction)
            dst.dosageInstruction.add(i.copy());
        };
        dst.substitution = substitution == null ? null : substitution.copy();
        if (eventHistory != null) {
          dst.eventHistory = new ArrayList<Reference>();
          for (Reference i : eventHistory)
            dst.eventHistory.add(i.copy());
        };
      }

      protected MedicationDispense typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationDispense))
          return false;
        MedicationDispense o = (MedicationDispense) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(notPerformedReason, o.notPerformedReason, true)
           && compareDeep(statusChanged, o.statusChanged, true) && compareDeep(category, o.category, true)
           && compareDeep(medication, o.medication, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(supportingInformation, o.supportingInformation, true) && compareDeep(performer, o.performer, true)
           && compareDeep(location, o.location, true) && compareDeep(authorizingPrescription, o.authorizingPrescription, true)
           && compareDeep(type, o.type, true) && compareDeep(quantity, o.quantity, true) && compareDeep(daysSupply, o.daysSupply, true)
           && compareDeep(recorded, o.recorded, true) && compareDeep(whenPrepared, o.whenPrepared, true) && compareDeep(whenHandedOver, o.whenHandedOver, true)
           && compareDeep(destination, o.destination, true) && compareDeep(receiver, o.receiver, true) && compareDeep(note, o.note, true)
           && compareDeep(renderedDosageInstruction, o.renderedDosageInstruction, true) && compareDeep(dosageInstruction, o.dosageInstruction, true)
           && compareDeep(substitution, o.substitution, true) && compareDeep(eventHistory, o.eventHistory, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationDispense))
          return false;
        MedicationDispense o = (MedicationDispense) other_;
        return compareValues(status, o.status, true) && compareValues(statusChanged, o.statusChanged, true)
           && compareValues(recorded, o.recorded, true) && compareValues(whenPrepared, o.whenPrepared, true) && compareValues(whenHandedOver, o.whenHandedOver, true)
           && compareValues(renderedDosageInstruction, o.renderedDosageInstruction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, notPerformedReason, statusChanged, category, medication, subject, encounter
          , supportingInformation, performer, location, authorizingPrescription, type, quantity
          , daysSupply, recorded, whenPrepared, whenHandedOver, destination, receiver, note
          , renderedDosageInstruction, dosageInstruction, substitution, eventHistory);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationDispense;
   }

 /**
   * Search parameter: <b>destination</b>
   * <p>
   * Description: <b>Returns dispenses that should be sent to a specific destination</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.destination</b><br>
   * </p>
   */
  @SearchParamDefinition(name="destination", path="MedicationDispense.destination", description="Returns dispenses that should be sent to a specific destination", type="reference", target={Location.class } )
  public static final String SP_DESTINATION = "destination";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>destination</b>
   * <p>
   * Description: <b>Returns dispenses that should be sent to a specific destination</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.destination</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DESTINATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DESTINATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:destination</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DESTINATION = new ca.uhn.fhir.model.api.Include("MedicationDispense:destination").toLocked();

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Returns dispense for a given location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="MedicationDispense.location", description="Returns dispense for a given location", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Returns dispense for a given location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("MedicationDispense:location").toLocked();

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>Returns dispenses performed by a specific individual</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="MedicationDispense.performer.actor", description="Returns dispenses performed by a specific individual", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>Returns dispenses performed by a specific individual</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.performer.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("MedicationDispense:performer").toLocked();

 /**
   * Search parameter: <b>receiver</b>
   * <p>
   * Description: <b>The identity of a receiver to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.receiver</b><br>
   * </p>
   */
  @SearchParamDefinition(name="receiver", path="MedicationDispense.receiver", description="The identity of a receiver to list dispenses for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Location.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_RECEIVER = "receiver";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>receiver</b>
   * <p>
   * Description: <b>The identity of a receiver to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.receiver</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECEIVER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RECEIVER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:receiver</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECEIVER = new ca.uhn.fhir.model.api.Include("MedicationDispense:receiver").toLocked();

 /**
   * Search parameter: <b>recorded</b>
   * <p>
   * Description: <b>Returns dispenses where dispensing activity began on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.recorded</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recorded", path="MedicationDispense.recorded", description="Returns dispenses where dispensing activity began on this date", type="date" )
  public static final String SP_RECORDED = "recorded";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recorded</b>
   * <p>
   * Description: <b>Returns dispenses where dispensing activity began on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.recorded</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam RECORDED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_RECORDED);

 /**
   * Search parameter: <b>responsibleparty</b>
   * <p>
   * Description: <b>Returns dispenses with the specified responsible party</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.substitution.responsibleParty</b><br>
   * </p>
   */
  @SearchParamDefinition(name="responsibleparty", path="MedicationDispense.substitution.responsibleParty", description="Returns dispenses with the specified responsible party", type="reference", target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_RESPONSIBLEPARTY = "responsibleparty";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>responsibleparty</b>
   * <p>
   * Description: <b>Returns dispenses with the specified responsible party</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.substitution.responsibleParty</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RESPONSIBLEPARTY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RESPONSIBLEPARTY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:responsibleparty</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RESPONSIBLEPARTY = new ca.uhn.fhir.model.api.Include("MedicationDispense:responsibleparty").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="MedicationDispense.subject", description="The identity of a patient for whom to list dispenses", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("MedicationDispense:subject").toLocked();

 /**
   * Search parameter: <b>whenhandedover</b>
   * <p>
   * Description: <b>Returns dispenses handed over on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenHandedOver</b><br>
   * </p>
   */
  @SearchParamDefinition(name="whenhandedover", path="MedicationDispense.whenHandedOver", description="Returns dispenses handed over on this date", type="date" )
  public static final String SP_WHENHANDEDOVER = "whenhandedover";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>whenhandedover</b>
   * <p>
   * Description: <b>Returns dispenses handed over on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenHandedOver</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam WHENHANDEDOVER = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_WHENHANDEDOVER);

 /**
   * Search parameter: <b>whenprepared</b>
   * <p>
   * Description: <b>Returns dispenses prepared on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenPrepared</b><br>
   * </p>
   */
  @SearchParamDefinition(name="whenprepared", path="MedicationDispense.whenPrepared", description="Returns dispenses prepared on this date", type="date" )
  public static final String SP_WHENPREPARED = "whenprepared";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>whenprepared</b>
   * <p>
   * Description: <b>Returns dispenses prepared on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenPrepared</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam WHENPREPARED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_WHENPREPARED);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [AuditEvent](auditevent.html): More specific code for the event\r\n* [Basic](basic.html): Kind of Resource\r\n* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code\r\n* [Condition](condition.html): Code for the condition\r\n* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [ImagingSelection](imagingselection.html): The imaging selection status\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationStatement](medicationstatement.html): Return statements of this medication code\r\n* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [RequestOrchestration](requestorchestration.html): The code of the request orchestration\r\n* [Task](task.html): Search by task code\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("MedicationDispense:encounter").toLocked();

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
   * the path value of "<b>MedicationDispense:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("MedicationDispense:patient").toLocked();

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

 /**
   * Search parameter: <b>medication</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource
* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference
* [MedicationStatement](medicationstatement.html): Return statements of this medication reference
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationStatement.medication.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="medication", path="MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationStatement.medication.reference", description="Multiple Resources: \r\n\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference\r\n* [MedicationStatement](medicationstatement.html): Return statements of this medication reference\r\n", type="reference", target={Medication.class } )
  public static final String SP_MEDICATION = "medication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>medication</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource
* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference
* [MedicationStatement](medicationstatement.html): Return statements of this medication reference
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationStatement.medication.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEDICATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MEDICATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:medication</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEDICATION = new ca.uhn.fhir.model.api.Include("MedicationDispense:medication").toLocked();

 /**
   * Search parameter: <b>prescription</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationDispense](medicationdispense.html): The identity of a prescription to list dispenses from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.authorizingPrescription</b><br>
   * </p>
   */
  @SearchParamDefinition(name="prescription", path="MedicationDispense.authorizingPrescription", description="Multiple Resources: \r\n\r\n* [MedicationDispense](medicationdispense.html): The identity of a prescription to list dispenses from\r\n", type="reference", target={MedicationRequest.class } )
  public static final String SP_PRESCRIPTION = "prescription";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>prescription</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationDispense](medicationdispense.html): The identity of a prescription to list dispenses from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.authorizingPrescription</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRESCRIPTION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRESCRIPTION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:prescription</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRESCRIPTION = new ca.uhn.fhir.model.api.Include("MedicationDispense:prescription").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status
* [MedicationRequest](medicationrequest.html): Status of the prescription
* [MedicationStatement](medicationstatement.html): Return statements that match the given status
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationStatement.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationStatement.status", description="Multiple Resources: \r\n\r\n* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status\r\n* [MedicationRequest](medicationrequest.html): Status of the prescription\r\n* [MedicationStatement](medicationstatement.html): Return statements that match the given status\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status
* [MedicationRequest](medicationrequest.html): Status of the prescription
* [MedicationStatement](medicationstatement.html): Return statements that match the given status
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationStatement.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

