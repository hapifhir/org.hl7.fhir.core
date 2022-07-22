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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
 * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
 */
@ResourceDef(name="Appointment", profile="http://hl7.org/fhir/StructureDefinition/Appointment")
public class Appointment extends DomainResource {

    public enum AppointmentStatus {
        /**
         * None of the participant(s) have finalized their acceptance of the appointment request, and the start/end time might not be set yet.
         */
        PROPOSED, 
        /**
         * Some or all of the participant(s) have not finalized their acceptance of the appointment request.
         */
        PENDING, 
        /**
         * All participant(s) have been considered and the appointment is confirmed to go ahead at the date/times specified.
         */
        BOOKED, 
        /**
         * The patient/patients has/have arrived and is/are waiting to be seen.
         */
        ARRIVED, 
        /**
         * The planning stages of the appointment are now complete, the encounter resource will exist and will track further status changes. Note that an encounter may exist before the appointment status is fulfilled for many reasons.
         */
        FULFILLED, 
        /**
         * The appointment has been cancelled.
         */
        CANCELLED, 
        /**
         * Some or all of the participant(s) have not/did not appear for the appointment (usually the patient).
         */
        NOSHOW, 
        /**
         * This instance should not have been part of this patient's medical record.
         */
        ENTEREDINERROR, 
        /**
         * When checked in, all pre-encounter administrative work is complete, and the encounter may begin. (where multiple patients are involved, they are all present).
         */
        CHECKEDIN, 
        /**
         * The appointment has been placed on a waitlist, to be scheduled/confirmed in the future when a slot/service is available.\nA specific time might or might not be pre-allocated.
         */
        WAITLIST, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AppointmentStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposed".equals(codeString))
          return PROPOSED;
        if ("pending".equals(codeString))
          return PENDING;
        if ("booked".equals(codeString))
          return BOOKED;
        if ("arrived".equals(codeString))
          return ARRIVED;
        if ("fulfilled".equals(codeString))
          return FULFILLED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("noshow".equals(codeString))
          return NOSHOW;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("checked-in".equals(codeString))
          return CHECKEDIN;
        if ("waitlist".equals(codeString))
          return WAITLIST;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AppointmentStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROPOSED: return "proposed";
            case PENDING: return "pending";
            case BOOKED: return "booked";
            case ARRIVED: return "arrived";
            case FULFILLED: return "fulfilled";
            case CANCELLED: return "cancelled";
            case NOSHOW: return "noshow";
            case ENTEREDINERROR: return "entered-in-error";
            case CHECKEDIN: return "checked-in";
            case WAITLIST: return "waitlist";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PROPOSED: return "http://hl7.org/fhir/appointmentstatus";
            case PENDING: return "http://hl7.org/fhir/appointmentstatus";
            case BOOKED: return "http://hl7.org/fhir/appointmentstatus";
            case ARRIVED: return "http://hl7.org/fhir/appointmentstatus";
            case FULFILLED: return "http://hl7.org/fhir/appointmentstatus";
            case CANCELLED: return "http://hl7.org/fhir/appointmentstatus";
            case NOSHOW: return "http://hl7.org/fhir/appointmentstatus";
            case ENTEREDINERROR: return "http://hl7.org/fhir/appointmentstatus";
            case CHECKEDIN: return "http://hl7.org/fhir/appointmentstatus";
            case WAITLIST: return "http://hl7.org/fhir/appointmentstatus";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PROPOSED: return "None of the participant(s) have finalized their acceptance of the appointment request, and the start/end time might not be set yet.";
            case PENDING: return "Some or all of the participant(s) have not finalized their acceptance of the appointment request.";
            case BOOKED: return "All participant(s) have been considered and the appointment is confirmed to go ahead at the date/times specified.";
            case ARRIVED: return "The patient/patients has/have arrived and is/are waiting to be seen.";
            case FULFILLED: return "The planning stages of the appointment are now complete, the encounter resource will exist and will track further status changes. Note that an encounter may exist before the appointment status is fulfilled for many reasons.";
            case CANCELLED: return "The appointment has been cancelled.";
            case NOSHOW: return "Some or all of the participant(s) have not/did not appear for the appointment (usually the patient).";
            case ENTEREDINERROR: return "This instance should not have been part of this patient's medical record.";
            case CHECKEDIN: return "When checked in, all pre-encounter administrative work is complete, and the encounter may begin. (where multiple patients are involved, they are all present).";
            case WAITLIST: return "The appointment has been placed on a waitlist, to be scheduled/confirmed in the future when a slot/service is available.\nA specific time might or might not be pre-allocated.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROPOSED: return "Proposed";
            case PENDING: return "Pending";
            case BOOKED: return "Booked";
            case ARRIVED: return "Arrived";
            case FULFILLED: return "Fulfilled";
            case CANCELLED: return "Cancelled";
            case NOSHOW: return "No Show";
            case ENTEREDINERROR: return "Entered in error";
            case CHECKEDIN: return "Checked In";
            case WAITLIST: return "Waitlisted";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AppointmentStatusEnumFactory implements EnumFactory<AppointmentStatus> {
    public AppointmentStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposed".equals(codeString))
          return AppointmentStatus.PROPOSED;
        if ("pending".equals(codeString))
          return AppointmentStatus.PENDING;
        if ("booked".equals(codeString))
          return AppointmentStatus.BOOKED;
        if ("arrived".equals(codeString))
          return AppointmentStatus.ARRIVED;
        if ("fulfilled".equals(codeString))
          return AppointmentStatus.FULFILLED;
        if ("cancelled".equals(codeString))
          return AppointmentStatus.CANCELLED;
        if ("noshow".equals(codeString))
          return AppointmentStatus.NOSHOW;
        if ("entered-in-error".equals(codeString))
          return AppointmentStatus.ENTEREDINERROR;
        if ("checked-in".equals(codeString))
          return AppointmentStatus.CHECKEDIN;
        if ("waitlist".equals(codeString))
          return AppointmentStatus.WAITLIST;
        throw new IllegalArgumentException("Unknown AppointmentStatus code '"+codeString+"'");
        }
        public Enumeration<AppointmentStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AppointmentStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("proposed".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.PROPOSED);
        if ("pending".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.PENDING);
        if ("booked".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.BOOKED);
        if ("arrived".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.ARRIVED);
        if ("fulfilled".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.FULFILLED);
        if ("cancelled".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.CANCELLED);
        if ("noshow".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.NOSHOW);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.ENTEREDINERROR);
        if ("checked-in".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.CHECKEDIN);
        if ("waitlist".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.WAITLIST);
        throw new FHIRException("Unknown AppointmentStatus code '"+codeString+"'");
        }
    public String toCode(AppointmentStatus code) {
      if (code == AppointmentStatus.PROPOSED)
        return "proposed";
      if (code == AppointmentStatus.PENDING)
        return "pending";
      if (code == AppointmentStatus.BOOKED)
        return "booked";
      if (code == AppointmentStatus.ARRIVED)
        return "arrived";
      if (code == AppointmentStatus.FULFILLED)
        return "fulfilled";
      if (code == AppointmentStatus.CANCELLED)
        return "cancelled";
      if (code == AppointmentStatus.NOSHOW)
        return "noshow";
      if (code == AppointmentStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == AppointmentStatus.CHECKEDIN)
        return "checked-in";
      if (code == AppointmentStatus.WAITLIST)
        return "waitlist";
      return "?";
      }
    public String toSystem(AppointmentStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class AppointmentParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Role of participant in the appointment.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Role of participant in the appointment", formalDefinition="Role of participant in the appointment." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-participant-type")
        protected List<CodeableConcept> type;

        /**
         * Participation period of the actor.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Participation period of the actor", formalDefinition="Participation period of the actor." )
        protected Period period;

        /**
         * A Person, Location/HealthcareService or Device that is participating in the appointment.
         */
        @Child(name = "actor", type = {Patient.class, Group.class, Practitioner.class, PractitionerRole.class, CareTeam.class, RelatedPerson.class, Device.class, HealthcareService.class, Location.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Person, Location/HealthcareService or Device", formalDefinition="A Person, Location/HealthcareService or Device that is participating in the appointment." )
        protected Reference actor;

        /**
         * Whether this participant is required to be present at the meeting. If false, the participant is optional.
         */
        @Child(name = "required", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The participant is required to attend (optional when false)", formalDefinition="Whether this participant is required to be present at the meeting. If false, the participant is optional." )
        protected BooleanType required;

        /**
         * Participation status of the actor.
         */
        @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="accepted | declined | tentative | needs-action", formalDefinition="Participation status of the actor." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participationstatus")
        protected Enumeration<ParticipationStatus> status;

        private static final long serialVersionUID = 1537536134L;

    /**
     * Constructor
     */
      public AppointmentParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AppointmentParticipantComponent(ParticipationStatus status) {
        super();
        this.setStatus(status);
      }

        /**
         * @return {@link #type} (Role of participant in the appointment.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AppointmentParticipantComponent setType(List<CodeableConcept> theType) { 
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

        public AppointmentParticipantComponent addType(CodeableConcept t) { //3
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
         * @return {@link #period} (Participation period of the actor.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentParticipantComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Participation period of the actor.)
         */
        public AppointmentParticipantComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #actor} (A Person, Location/HealthcareService or Device that is participating in the appointment.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (A Person, Location/HealthcareService or Device that is participating in the appointment.)
         */
        public AppointmentParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        /**
         * @return {@link #required} (Whether this participant is required to be present at the meeting. If false, the participant is optional.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public BooleanType getRequiredElement() { 
          if (this.required == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentParticipantComponent.required");
            else if (Configuration.doAutoCreate())
              this.required = new BooleanType(); // bb
          return this.required;
        }

        public boolean hasRequiredElement() { 
          return this.required != null && !this.required.isEmpty();
        }

        public boolean hasRequired() { 
          return this.required != null && !this.required.isEmpty();
        }

        /**
         * @param value {@link #required} (Whether this participant is required to be present at the meeting. If false, the participant is optional.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public AppointmentParticipantComponent setRequiredElement(BooleanType value) { 
          this.required = value;
          return this;
        }

        /**
         * @return Whether this participant is required to be present at the meeting. If false, the participant is optional.
         */
        public boolean getRequired() { 
          return this.required == null || this.required.isEmpty() ? false : this.required.getValue();
        }

        /**
         * @param value Whether this participant is required to be present at the meeting. If false, the participant is optional.
         */
        public AppointmentParticipantComponent setRequired(boolean value) { 
            if (this.required == null)
              this.required = new BooleanType();
            this.required.setValue(value);
          return this;
        }

        /**
         * @return {@link #status} (Participation status of the actor.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public Enumeration<ParticipationStatus> getStatusElement() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentParticipantComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory()); // bb
          return this.status;
        }

        public boolean hasStatusElement() { 
          return this.status != null && !this.status.isEmpty();
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (Participation status of the actor.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public AppointmentParticipantComponent setStatusElement(Enumeration<ParticipationStatus> value) { 
          this.status = value;
          return this;
        }

        /**
         * @return Participation status of the actor.
         */
        public ParticipationStatus getStatus() { 
          return this.status == null ? null : this.status.getValue();
        }

        /**
         * @param value Participation status of the actor.
         */
        public AppointmentParticipantComponent setStatus(ParticipationStatus value) { 
            if (this.status == null)
              this.status = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory());
            this.status.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("period", "Period", "Participation period of the actor.", 0, 1, period));
          children.add(new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|CareTeam|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location/HealthcareService or Device that is participating in the appointment.", 0, 1, actor));
          children.add(new Property("required", "boolean", "Whether this participant is required to be present at the meeting. If false, the participant is optional.", 0, 1, required));
          children.add(new Property("status", "code", "Participation status of the actor.", 0, 1, status));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, type);
          case -991726143: /*period*/  return new Property("period", "Period", "Participation period of the actor.", 0, 1, period);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|CareTeam|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location/HealthcareService or Device that is participating in the appointment.", 0, 1, actor);
          case -393139297: /*required*/  return new Property("required", "boolean", "Whether this participant is required to be present at the meeting. If false, the participant is optional.", 0, 1, required);
          case -892481550: /*status*/  return new Property("status", "code", "Participation status of the actor.", 0, 1, status);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        case -393139297: /*required*/ return this.required == null ? new Base[0] : new Base[] {this.required}; // BooleanType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ParticipationStatus>
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
        case -393139297: // required
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -892481550: // status
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ParticipationStatus>
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
        } else if (name.equals("required")) {
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("status")) {
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ParticipationStatus>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case -991726143:  return getPeriod();
        case 92645877:  return getActor();
        case -393139297:  return getRequiredElement();
        case -892481550:  return getStatusElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case -393139297: /*required*/ return new String[] {"boolean"};
        case -892481550: /*status*/ return new String[] {"code"};
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
        else if (name.equals("required")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.participant.required");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.participant.status");
        }
        else
          return super.addChild(name);
      }

      public AppointmentParticipantComponent copy() {
        AppointmentParticipantComponent dst = new AppointmentParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentParticipantComponent dst) {
        super.copyValues(dst);
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        dst.actor = actor == null ? null : actor.copy();
        dst.required = required == null ? null : required.copy();
        dst.status = status == null ? null : status.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentParticipantComponent))
          return false;
        AppointmentParticipantComponent o = (AppointmentParticipantComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(period, o.period, true) && compareDeep(actor, o.actor, true)
           && compareDeep(required, o.required, true) && compareDeep(status, o.status, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentParticipantComponent))
          return false;
        AppointmentParticipantComponent o = (AppointmentParticipantComponent) other_;
        return compareValues(required, o.required, true) && compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, period, actor, required
          , status);
      }

  public String fhirType() {
    return "Appointment.participant";

  }

  }

    /**
     * This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this item", formalDefinition="This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation)." )
    protected List<Identifier> identifier;

    /**
     * The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposed | pending | booked | arrived | fulfilled | cancelled | noshow | entered-in-error | checked-in | waitlist", formalDefinition="The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/appointmentstatus")
    protected Enumeration<AppointmentStatus> status;

    /**
     * The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.
     */
    @Child(name = "cancellationReason", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The coded reason for the appointment being cancelled", formalDefinition="The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/appointment-cancellation-reason")
    protected CodeableConcept cancellationReason;

    /**
     * A broad categorization of the service that is to be performed during this appointment.
     */
    @Child(name = "serviceCategory", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A broad categorization of the service that is to be performed during this appointment", formalDefinition="A broad categorization of the service that is to be performed during this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-category")
    protected List<CodeableConcept> serviceCategory;

    /**
     * The specific service that is to be performed during this appointment.
     */
    @Child(name = "serviceType", type = {CodeableReference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The specific service that is to be performed during this appointment", formalDefinition="The specific service that is to be performed during this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-type")
    protected List<CodeableReference> serviceType;

    /**
     * The specialty of a practitioner that would be required to perform the service requested in this appointment.
     */
    @Child(name = "specialty", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The specialty of a practitioner that would be required to perform the service requested in this appointment", formalDefinition="The specialty of a practitioner that would be required to perform the service requested in this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected List<CodeableConcept> specialty;

    /**
     * The style of appointment or patient that has been booked in the slot (not service type).
     */
    @Child(name = "appointmentType", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The style of appointment or patient that has been booked in the slot (not service type)", formalDefinition="The style of appointment or patient that has been booked in the slot (not service type)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0276")
    protected CodeableConcept appointmentType;

    /**
     * The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Reason this appointment is scheduled", formalDefinition="The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-reason")
    protected List<CodeableReference> reason;

    /**
     * The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).
     */
    @Child(name = "priority", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Used to make informed decisions if needing to re-prioritize", formalDefinition="The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActPriority")
    protected CodeableConcept priority;

    /**
     * The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.
     */
    @Child(name = "description", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Shown on a subject line in a meeting request, or appointment list", formalDefinition="The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field." )
    protected StringType description;

    /**
     * Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).
     */
    @Child(name = "replaces", type = {Appointment.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Appointment replaced by this Appointment", formalDefinition="Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource)." )
    protected List<Reference> replaces;

    /**
     * Additional information to support the appointment provided when making the appointment.
     */
    @Child(name = "supportingInformation", type = {Reference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional information to support the appointment", formalDefinition="Additional information to support the appointment provided when making the appointment." )
    protected List<Reference> supportingInformation;

    /**
     * Date/Time that the appointment is to take place.
     */
    @Child(name = "start", type = {InstantType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When appointment is to take place", formalDefinition="Date/Time that the appointment is to take place." )
    protected InstantType start;

    /**
     * Date/Time that the appointment is to conclude.
     */
    @Child(name = "end", type = {InstantType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When appointment is to conclude", formalDefinition="Date/Time that the appointment is to conclude." )
    protected InstantType end;

    /**
     * Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.
     */
    @Child(name = "minutesDuration", type = {PositiveIntType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Can be less than start/end (e.g. estimate)", formalDefinition="Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end." )
    protected PositiveIntType minutesDuration;

    /**
     * The slots from the participants' schedules that will be filled by the appointment.
     */
    @Child(name = "slot", type = {Slot.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The slots that this appointment is filling", formalDefinition="The slots from the participants' schedules that will be filled by the appointment." )
    protected List<Reference> slot;

    /**
     * The set of accounts that is expected to be used for billing the activities that result from this Appointment.
     */
    @Child(name = "account", type = {Account.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The set of accounts that may be used for billing for this Appointment", formalDefinition="The set of accounts that is expected to be used for billing the activities that result from this Appointment." )
    protected List<Reference> account;

    /**
     * The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The date that this appointment was initially created", formalDefinition="The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment." )
    protected DateTimeType created;

    /**
     * Additional notes/comments about the appointment.
     */
    @Child(name = "note", type = {Annotation.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional comments", formalDefinition="Additional notes/comments about the appointment." )
    protected List<Annotation> note;

    /**
     * While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).
     */
    @Child(name = "patientInstruction", type = {CodeableReference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Detailed information and instructions for the patient", formalDefinition="While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before)." )
    protected List<CodeableReference> patientInstruction;

    /**
     * The request this appointment is allocated to assess (e.g. incoming referral or procedure request).
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, MedicationRequest.class, ServiceRequest.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The request this appointment is allocated to assess", formalDefinition="The request this appointment is allocated to assess (e.g. incoming referral or procedure request)." )
    protected List<Reference> basedOn;

    /**
     * The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient or group associated with the appointment", formalDefinition="The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element." )
    protected Reference subject;

    /**
     * List of participants involved in the appointment.
     */
    @Child(name = "participant", type = {}, order=22, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Participants involved in appointment", formalDefinition="List of participants involved in the appointment." )
    protected List<AppointmentParticipantComponent> participant;

    /**
     * A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.

The duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.
     */
    @Child(name = "requestedPeriod", type = {Period.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Potential date/time interval(s) requested to allocate the appointment within", formalDefinition="A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system." )
    protected List<Period> requestedPeriod;

    private static final long serialVersionUID = -1643708854L;

  /**
   * Constructor
   */
    public Appointment() {
      super();
    }

  /**
   * Constructor
   */
    public Appointment(AppointmentStatus status, AppointmentParticipantComponent participant) {
      super();
      this.setStatus(status);
      this.addParticipant(participant);
    }

    /**
     * @return {@link #identifier} (This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setIdentifier(List<Identifier> theIdentifier) { 
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

    public Appointment addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<AppointmentStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<AppointmentStatus>(new AppointmentStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Appointment setStatusElement(Enumeration<AppointmentStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.
     */
    public AppointmentStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.
     */
    public Appointment setStatus(AppointmentStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<AppointmentStatus>(new AppointmentStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #cancellationReason} (The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.)
     */
    public CodeableConcept getCancellationReason() { 
      if (this.cancellationReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.cancellationReason");
        else if (Configuration.doAutoCreate())
          this.cancellationReason = new CodeableConcept(); // cc
      return this.cancellationReason;
    }

    public boolean hasCancellationReason() { 
      return this.cancellationReason != null && !this.cancellationReason.isEmpty();
    }

    /**
     * @param value {@link #cancellationReason} (The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.)
     */
    public Appointment setCancellationReason(CodeableConcept value) { 
      this.cancellationReason = value;
      return this;
    }

    /**
     * @return {@link #serviceCategory} (A broad categorization of the service that is to be performed during this appointment.)
     */
    public List<CodeableConcept> getServiceCategory() { 
      if (this.serviceCategory == null)
        this.serviceCategory = new ArrayList<CodeableConcept>();
      return this.serviceCategory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setServiceCategory(List<CodeableConcept> theServiceCategory) { 
      this.serviceCategory = theServiceCategory;
      return this;
    }

    public boolean hasServiceCategory() { 
      if (this.serviceCategory == null)
        return false;
      for (CodeableConcept item : this.serviceCategory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addServiceCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.serviceCategory == null)
        this.serviceCategory = new ArrayList<CodeableConcept>();
      this.serviceCategory.add(t);
      return t;
    }

    public Appointment addServiceCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.serviceCategory == null)
        this.serviceCategory = new ArrayList<CodeableConcept>();
      this.serviceCategory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #serviceCategory}, creating it if it does not already exist {3}
     */
    public CodeableConcept getServiceCategoryFirstRep() { 
      if (getServiceCategory().isEmpty()) {
        addServiceCategory();
      }
      return getServiceCategory().get(0);
    }

    /**
     * @return {@link #serviceType} (The specific service that is to be performed during this appointment.)
     */
    public List<CodeableReference> getServiceType() { 
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      return this.serviceType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setServiceType(List<CodeableReference> theServiceType) { 
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

    public Appointment addServiceType(CodeableReference t) { //3
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
     * @return {@link #specialty} (The specialty of a practitioner that would be required to perform the service requested in this appointment.)
     */
    public List<CodeableConcept> getSpecialty() { 
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      return this.specialty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setSpecialty(List<CodeableConcept> theSpecialty) { 
      this.specialty = theSpecialty;
      return this;
    }

    public boolean hasSpecialty() { 
      if (this.specialty == null)
        return false;
      for (CodeableConcept item : this.specialty)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSpecialty() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      this.specialty.add(t);
      return t;
    }

    public Appointment addSpecialty(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      this.specialty.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specialty}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSpecialtyFirstRep() { 
      if (getSpecialty().isEmpty()) {
        addSpecialty();
      }
      return getSpecialty().get(0);
    }

    /**
     * @return {@link #appointmentType} (The style of appointment or patient that has been booked in the slot (not service type).)
     */
    public CodeableConcept getAppointmentType() { 
      if (this.appointmentType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.appointmentType");
        else if (Configuration.doAutoCreate())
          this.appointmentType = new CodeableConcept(); // cc
      return this.appointmentType;
    }

    public boolean hasAppointmentType() { 
      return this.appointmentType != null && !this.appointmentType.isEmpty();
    }

    /**
     * @param value {@link #appointmentType} (The style of appointment or patient that has been booked in the slot (not service type).)
     */
    public Appointment setAppointmentType(CodeableConcept value) { 
      this.appointmentType = value;
      return this;
    }

    /**
     * @return {@link #reason} (The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setReason(List<CodeableReference> theReason) { 
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

    public Appointment addReason(CodeableReference t) { //3
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
     * @return {@link #priority} (The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).)
     */
    public CodeableConcept getPriority() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.priority");
        else if (Configuration.doAutoCreate())
          this.priority = new CodeableConcept(); // cc
      return this.priority;
    }

    public boolean hasPriority() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    /**
     * @param value {@link #priority} (The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).)
     */
    public Appointment setPriority(CodeableConcept value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return {@link #description} (The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Appointment setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.
     */
    public Appointment setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #replaces} (Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).)
     */
    public List<Reference> getReplaces() { 
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      return this.replaces;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setReplaces(List<Reference> theReplaces) { 
      this.replaces = theReplaces;
      return this;
    }

    public boolean hasReplaces() { 
      if (this.replaces == null)
        return false;
      for (Reference item : this.replaces)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReplaces() { //3
      Reference t = new Reference();
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return t;
    }

    public Appointment addReplaces(Reference t) { //3
      if (t == null)
        return this;
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #replaces}, creating it if it does not already exist {3}
     */
    public Reference getReplacesFirstRep() { 
      if (getReplaces().isEmpty()) {
        addReplaces();
      }
      return getReplaces().get(0);
    }

    /**
     * @return {@link #supportingInformation} (Additional information to support the appointment provided when making the appointment.)
     */
    public List<Reference> getSupportingInformation() { 
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      return this.supportingInformation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setSupportingInformation(List<Reference> theSupportingInformation) { 
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

    public Appointment addSupportingInformation(Reference t) { //3
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
     * @return {@link #start} (Date/Time that the appointment is to take place.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public InstantType getStartElement() { 
      if (this.start == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.start");
        else if (Configuration.doAutoCreate())
          this.start = new InstantType(); // bb
      return this.start;
    }

    public boolean hasStartElement() { 
      return this.start != null && !this.start.isEmpty();
    }

    public boolean hasStart() { 
      return this.start != null && !this.start.isEmpty();
    }

    /**
     * @param value {@link #start} (Date/Time that the appointment is to take place.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public Appointment setStartElement(InstantType value) { 
      this.start = value;
      return this;
    }

    /**
     * @return Date/Time that the appointment is to take place.
     */
    public Date getStart() { 
      return this.start == null ? null : this.start.getValue();
    }

    /**
     * @param value Date/Time that the appointment is to take place.
     */
    public Appointment setStart(Date value) { 
      if (value == null)
        this.start = null;
      else {
        if (this.start == null)
          this.start = new InstantType();
        this.start.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #end} (Date/Time that the appointment is to conclude.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public InstantType getEndElement() { 
      if (this.end == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.end");
        else if (Configuration.doAutoCreate())
          this.end = new InstantType(); // bb
      return this.end;
    }

    public boolean hasEndElement() { 
      return this.end != null && !this.end.isEmpty();
    }

    public boolean hasEnd() { 
      return this.end != null && !this.end.isEmpty();
    }

    /**
     * @param value {@link #end} (Date/Time that the appointment is to conclude.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public Appointment setEndElement(InstantType value) { 
      this.end = value;
      return this;
    }

    /**
     * @return Date/Time that the appointment is to conclude.
     */
    public Date getEnd() { 
      return this.end == null ? null : this.end.getValue();
    }

    /**
     * @param value Date/Time that the appointment is to conclude.
     */
    public Appointment setEnd(Date value) { 
      if (value == null)
        this.end = null;
      else {
        if (this.end == null)
          this.end = new InstantType();
        this.end.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #minutesDuration} (Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.). This is the underlying object with id, value and extensions. The accessor "getMinutesDuration" gives direct access to the value
     */
    public PositiveIntType getMinutesDurationElement() { 
      if (this.minutesDuration == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.minutesDuration");
        else if (Configuration.doAutoCreate())
          this.minutesDuration = new PositiveIntType(); // bb
      return this.minutesDuration;
    }

    public boolean hasMinutesDurationElement() { 
      return this.minutesDuration != null && !this.minutesDuration.isEmpty();
    }

    public boolean hasMinutesDuration() { 
      return this.minutesDuration != null && !this.minutesDuration.isEmpty();
    }

    /**
     * @param value {@link #minutesDuration} (Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.). This is the underlying object with id, value and extensions. The accessor "getMinutesDuration" gives direct access to the value
     */
    public Appointment setMinutesDurationElement(PositiveIntType value) { 
      this.minutesDuration = value;
      return this;
    }

    /**
     * @return Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.
     */
    public int getMinutesDuration() { 
      return this.minutesDuration == null || this.minutesDuration.isEmpty() ? 0 : this.minutesDuration.getValue();
    }

    /**
     * @param value Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.
     */
    public Appointment setMinutesDuration(int value) { 
        if (this.minutesDuration == null)
          this.minutesDuration = new PositiveIntType();
        this.minutesDuration.setValue(value);
      return this;
    }

    /**
     * @return {@link #slot} (The slots from the participants' schedules that will be filled by the appointment.)
     */
    public List<Reference> getSlot() { 
      if (this.slot == null)
        this.slot = new ArrayList<Reference>();
      return this.slot;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setSlot(List<Reference> theSlot) { 
      this.slot = theSlot;
      return this;
    }

    public boolean hasSlot() { 
      if (this.slot == null)
        return false;
      for (Reference item : this.slot)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSlot() { //3
      Reference t = new Reference();
      if (this.slot == null)
        this.slot = new ArrayList<Reference>();
      this.slot.add(t);
      return t;
    }

    public Appointment addSlot(Reference t) { //3
      if (t == null)
        return this;
      if (this.slot == null)
        this.slot = new ArrayList<Reference>();
      this.slot.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #slot}, creating it if it does not already exist {3}
     */
    public Reference getSlotFirstRep() { 
      if (getSlot().isEmpty()) {
        addSlot();
      }
      return getSlot().get(0);
    }

    /**
     * @return {@link #account} (The set of accounts that is expected to be used for billing the activities that result from this Appointment.)
     */
    public List<Reference> getAccount() { 
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      return this.account;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setAccount(List<Reference> theAccount) { 
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

    public Appointment addAccount(Reference t) { //3
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
     * @return {@link #created} (The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public Appointment setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
     */
    public Appointment setCreated(Date value) { 
      if (value == null)
        this.created = null;
      else {
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Additional notes/comments about the appointment.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setNote(List<Annotation> theNote) { 
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

    public Appointment addNote(Annotation t) { //3
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
     * @return {@link #patientInstruction} (While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).)
     */
    public List<CodeableReference> getPatientInstruction() { 
      if (this.patientInstruction == null)
        this.patientInstruction = new ArrayList<CodeableReference>();
      return this.patientInstruction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setPatientInstruction(List<CodeableReference> thePatientInstruction) { 
      this.patientInstruction = thePatientInstruction;
      return this;
    }

    public boolean hasPatientInstruction() { 
      if (this.patientInstruction == null)
        return false;
      for (CodeableReference item : this.patientInstruction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addPatientInstruction() { //3
      CodeableReference t = new CodeableReference();
      if (this.patientInstruction == null)
        this.patientInstruction = new ArrayList<CodeableReference>();
      this.patientInstruction.add(t);
      return t;
    }

    public Appointment addPatientInstruction(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.patientInstruction == null)
        this.patientInstruction = new ArrayList<CodeableReference>();
      this.patientInstruction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #patientInstruction}, creating it if it does not already exist {3}
     */
    public CodeableReference getPatientInstructionFirstRep() { 
      if (getPatientInstruction().isEmpty()) {
        addPatientInstruction();
      }
      return getPatientInstruction().get(0);
    }

    /**
     * @return {@link #basedOn} (The request this appointment is allocated to assess (e.g. incoming referral or procedure request).)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setBasedOn(List<Reference> theBasedOn) { 
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

    public Appointment addBasedOn(Reference t) { //3
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
     * @return {@link #subject} (The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.)
     */
    public Appointment setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #participant} (List of participants involved in the appointment.)
     */
    public List<AppointmentParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<AppointmentParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setParticipant(List<AppointmentParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (AppointmentParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AppointmentParticipantComponent addParticipant() { //3
      AppointmentParticipantComponent t = new AppointmentParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<AppointmentParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public Appointment addParticipant(AppointmentParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<AppointmentParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public AppointmentParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #requestedPeriod} (A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.

The duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.)
     */
    public List<Period> getRequestedPeriod() { 
      if (this.requestedPeriod == null)
        this.requestedPeriod = new ArrayList<Period>();
      return this.requestedPeriod;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setRequestedPeriod(List<Period> theRequestedPeriod) { 
      this.requestedPeriod = theRequestedPeriod;
      return this;
    }

    public boolean hasRequestedPeriod() { 
      if (this.requestedPeriod == null)
        return false;
      for (Period item : this.requestedPeriod)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Period addRequestedPeriod() { //3
      Period t = new Period();
      if (this.requestedPeriod == null)
        this.requestedPeriod = new ArrayList<Period>();
      this.requestedPeriod.add(t);
      return t;
    }

    public Appointment addRequestedPeriod(Period t) { //3
      if (t == null)
        return this;
      if (this.requestedPeriod == null)
        this.requestedPeriod = new ArrayList<Period>();
      this.requestedPeriod.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #requestedPeriod}, creating it if it does not already exist {3}
     */
    public Period getRequestedPeriodFirstRep() { 
      if (getRequestedPeriod().isEmpty()) {
        addRequestedPeriod();
      }
      return getRequestedPeriod().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.", 0, 1, status));
        children.add(new Property("cancellationReason", "CodeableConcept", "The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.", 0, 1, cancellationReason));
        children.add(new Property("serviceCategory", "CodeableConcept", "A broad categorization of the service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceCategory));
        children.add(new Property("serviceType", "CodeableReference(HealthcareService)", "The specific service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceType));
        children.add(new Property("specialty", "CodeableConcept", "The specialty of a practitioner that would be required to perform the service requested in this appointment.", 0, java.lang.Integer.MAX_VALUE, specialty));
        children.add(new Property("appointmentType", "CodeableConcept", "The style of appointment or patient that has been booked in the slot (not service type).", 0, 1, appointmentType));
        children.add(new Property("reason", "CodeableReference(Condition|Procedure|Observation|ImmunizationRecommendation)", "The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("priority", "CodeableConcept", "The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).", 0, 1, priority));
        children.add(new Property("description", "string", "The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.", 0, 1, description));
        children.add(new Property("replaces", "Reference(Appointment)", "Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("supportingInformation", "Reference(Any)", "Additional information to support the appointment provided when making the appointment.", 0, java.lang.Integer.MAX_VALUE, supportingInformation));
        children.add(new Property("start", "instant", "Date/Time that the appointment is to take place.", 0, 1, start));
        children.add(new Property("end", "instant", "Date/Time that the appointment is to conclude.", 0, 1, end));
        children.add(new Property("minutesDuration", "positiveInt", "Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.", 0, 1, minutesDuration));
        children.add(new Property("slot", "Reference(Slot)", "The slots from the participants' schedules that will be filled by the appointment.", 0, java.lang.Integer.MAX_VALUE, slot));
        children.add(new Property("account", "Reference(Account)", "The set of accounts that is expected to be used for billing the activities that result from this Appointment.", 0, java.lang.Integer.MAX_VALUE, account));
        children.add(new Property("created", "dateTime", "The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.", 0, 1, created));
        children.add(new Property("note", "Annotation", "Additional notes/comments about the appointment.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("patientInstruction", "CodeableReference(DocumentReference|Binary|Communication)", "While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).", 0, java.lang.Integer.MAX_VALUE, patientInstruction));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this appointment is allocated to assess (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.", 0, 1, subject));
        children.add(new Property("participant", "", "List of participants involved in the appointment.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("requestedPeriod", "Period", "A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.", 0, java.lang.Integer.MAX_VALUE, requestedPeriod));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.", 0, 1, status);
        case 2135095591: /*cancellationReason*/  return new Property("cancellationReason", "CodeableConcept", "The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.", 0, 1, cancellationReason);
        case 1281188563: /*serviceCategory*/  return new Property("serviceCategory", "CodeableConcept", "A broad categorization of the service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceCategory);
        case -1928370289: /*serviceType*/  return new Property("serviceType", "CodeableReference(HealthcareService)", "The specific service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceType);
        case -1694759682: /*specialty*/  return new Property("specialty", "CodeableConcept", "The specialty of a practitioner that would be required to perform the service requested in this appointment.", 0, java.lang.Integer.MAX_VALUE, specialty);
        case -1596426375: /*appointmentType*/  return new Property("appointmentType", "CodeableConcept", "The style of appointment or patient that has been booked in the slot (not service type).", 0, 1, appointmentType);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Procedure|Observation|ImmunizationRecommendation)", "The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.", 0, java.lang.Integer.MAX_VALUE, reason);
        case -1165461084: /*priority*/  return new Property("priority", "CodeableConcept", "The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).", 0, 1, priority);
        case -1724546052: /*description*/  return new Property("description", "string", "The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the comment field.", 0, 1, description);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(Appointment)", "Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).", 0, java.lang.Integer.MAX_VALUE, replaces);
        case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "Reference(Any)", "Additional information to support the appointment provided when making the appointment.", 0, java.lang.Integer.MAX_VALUE, supportingInformation);
        case 109757538: /*start*/  return new Property("start", "instant", "Date/Time that the appointment is to take place.", 0, 1, start);
        case 100571: /*end*/  return new Property("end", "instant", "Date/Time that the appointment is to conclude.", 0, 1, end);
        case -413630573: /*minutesDuration*/  return new Property("minutesDuration", "positiveInt", "Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.", 0, 1, minutesDuration);
        case 3533310: /*slot*/  return new Property("slot", "Reference(Slot)", "The slots from the participants' schedules that will be filled by the appointment.", 0, java.lang.Integer.MAX_VALUE, slot);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "The set of accounts that is expected to be used for billing the activities that result from this Appointment.", 0, java.lang.Integer.MAX_VALUE, account);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.", 0, 1, created);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Additional notes/comments about the appointment.", 0, java.lang.Integer.MAX_VALUE, note);
        case 737543241: /*patientInstruction*/  return new Property("patientInstruction", "CodeableReference(DocumentReference|Binary|Communication)", "While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).", 0, java.lang.Integer.MAX_VALUE, patientInstruction);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this appointment is allocated to assess (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.", 0, 1, subject);
        case 767422259: /*participant*/  return new Property("participant", "", "List of participants involved in the appointment.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -897241393: /*requestedPeriod*/  return new Property("requestedPeriod", "Period", "A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.", 0, java.lang.Integer.MAX_VALUE, requestedPeriod);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<AppointmentStatus>
        case 2135095591: /*cancellationReason*/ return this.cancellationReason == null ? new Base[0] : new Base[] {this.cancellationReason}; // CodeableConcept
        case 1281188563: /*serviceCategory*/ return this.serviceCategory == null ? new Base[0] : this.serviceCategory.toArray(new Base[this.serviceCategory.size()]); // CodeableConcept
        case -1928370289: /*serviceType*/ return this.serviceType == null ? new Base[0] : this.serviceType.toArray(new Base[this.serviceType.size()]); // CodeableReference
        case -1694759682: /*specialty*/ return this.specialty == null ? new Base[0] : this.specialty.toArray(new Base[this.specialty.size()]); // CodeableConcept
        case -1596426375: /*appointmentType*/ return this.appointmentType == null ? new Base[0] : new Base[] {this.appointmentType}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -430332865: /*replaces*/ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // InstantType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case -413630573: /*minutesDuration*/ return this.minutesDuration == null ? new Base[0] : new Base[] {this.minutesDuration}; // PositiveIntType
        case 3533310: /*slot*/ return this.slot == null ? new Base[0] : this.slot.toArray(new Base[this.slot.size()]); // Reference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : this.account.toArray(new Base[this.account.size()]); // Reference
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 737543241: /*patientInstruction*/ return this.patientInstruction == null ? new Base[0] : this.patientInstruction.toArray(new Base[this.patientInstruction.size()]); // CodeableReference
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // AppointmentParticipantComponent
        case -897241393: /*requestedPeriod*/ return this.requestedPeriod == null ? new Base[0] : this.requestedPeriod.toArray(new Base[this.requestedPeriod.size()]); // Period
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
          value = new AppointmentStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AppointmentStatus>
          return value;
        case 2135095591: // cancellationReason
          this.cancellationReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1281188563: // serviceCategory
          this.getServiceCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1928370289: // serviceType
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1694759682: // specialty
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1596426375: // appointmentType
          this.appointmentType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1165461084: // priority
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -430332865: // replaces
          this.getReplaces().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1248768647: // supportingInformation
          this.getSupportingInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 109757538: // start
          this.start = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case -413630573: // minutesDuration
          this.minutesDuration = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 3533310: // slot
          this.getSlot().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1177318867: // account
          this.getAccount().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 737543241: // patientInstruction
          this.getPatientInstruction().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 767422259: // participant
          this.getParticipant().add((AppointmentParticipantComponent) value); // AppointmentParticipantComponent
          return value;
        case -897241393: // requestedPeriod
          this.getRequestedPeriod().add(TypeConvertor.castToPeriod(value)); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new AppointmentStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AppointmentStatus>
        } else if (name.equals("cancellationReason")) {
          this.cancellationReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("serviceCategory")) {
          this.getServiceCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("serviceType")) {
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("specialty")) {
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("appointmentType")) {
          this.appointmentType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("priority")) {
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("replaces")) {
          this.getReplaces().add(TypeConvertor.castToReference(value));
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("start")) {
          this.start = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("minutesDuration")) {
          this.minutesDuration = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("slot")) {
          this.getSlot().add(TypeConvertor.castToReference(value));
        } else if (name.equals("account")) {
          this.getAccount().add(TypeConvertor.castToReference(value));
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("patientInstruction")) {
          this.getPatientInstruction().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participant")) {
          this.getParticipant().add((AppointmentParticipantComponent) value);
        } else if (name.equals("requestedPeriod")) {
          this.getRequestedPeriod().add(TypeConvertor.castToPeriod(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 2135095591:  return getCancellationReason();
        case 1281188563:  return addServiceCategory(); 
        case -1928370289:  return addServiceType(); 
        case -1694759682:  return addSpecialty(); 
        case -1596426375:  return getAppointmentType();
        case -934964668:  return addReason(); 
        case -1165461084:  return getPriority();
        case -1724546052:  return getDescriptionElement();
        case -430332865:  return addReplaces(); 
        case -1248768647:  return addSupportingInformation(); 
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case -413630573:  return getMinutesDurationElement();
        case 3533310:  return addSlot(); 
        case -1177318867:  return addAccount(); 
        case 1028554472:  return getCreatedElement();
        case 3387378:  return addNote(); 
        case 737543241:  return addPatientInstruction(); 
        case -332612366:  return addBasedOn(); 
        case -1867885268:  return getSubject();
        case 767422259:  return addParticipant(); 
        case -897241393:  return addRequestedPeriod(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2135095591: /*cancellationReason*/ return new String[] {"CodeableConcept"};
        case 1281188563: /*serviceCategory*/ return new String[] {"CodeableConcept"};
        case -1928370289: /*serviceType*/ return new String[] {"CodeableReference"};
        case -1694759682: /*specialty*/ return new String[] {"CodeableConcept"};
        case -1596426375: /*appointmentType*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case -1165461084: /*priority*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -430332865: /*replaces*/ return new String[] {"Reference"};
        case -1248768647: /*supportingInformation*/ return new String[] {"Reference"};
        case 109757538: /*start*/ return new String[] {"instant"};
        case 100571: /*end*/ return new String[] {"instant"};
        case -413630573: /*minutesDuration*/ return new String[] {"positiveInt"};
        case 3533310: /*slot*/ return new String[] {"Reference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 737543241: /*patientInstruction*/ return new String[] {"CodeableReference"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 767422259: /*participant*/ return new String[] {};
        case -897241393: /*requestedPeriod*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.status");
        }
        else if (name.equals("cancellationReason")) {
          this.cancellationReason = new CodeableConcept();
          return this.cancellationReason;
        }
        else if (name.equals("serviceCategory")) {
          return addServiceCategory();
        }
        else if (name.equals("serviceType")) {
          return addServiceType();
        }
        else if (name.equals("specialty")) {
          return addSpecialty();
        }
        else if (name.equals("appointmentType")) {
          this.appointmentType = new CodeableConcept();
          return this.appointmentType;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("priority")) {
          this.priority = new CodeableConcept();
          return this.priority;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.description");
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("supportingInformation")) {
          return addSupportingInformation();
        }
        else if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.end");
        }
        else if (name.equals("minutesDuration")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.minutesDuration");
        }
        else if (name.equals("slot")) {
          return addSlot();
        }
        else if (name.equals("account")) {
          return addAccount();
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type Appointment.created");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("patientInstruction")) {
          return addPatientInstruction();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("requestedPeriod")) {
          return addRequestedPeriod();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Appointment";

  }

      public Appointment copy() {
        Appointment dst = new Appointment();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Appointment dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.cancellationReason = cancellationReason == null ? null : cancellationReason.copy();
        if (serviceCategory != null) {
          dst.serviceCategory = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : serviceCategory)
            dst.serviceCategory.add(i.copy());
        };
        if (serviceType != null) {
          dst.serviceType = new ArrayList<CodeableReference>();
          for (CodeableReference i : serviceType)
            dst.serviceType.add(i.copy());
        };
        if (specialty != null) {
          dst.specialty = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialty)
            dst.specialty.add(i.copy());
        };
        dst.appointmentType = appointmentType == null ? null : appointmentType.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        dst.priority = priority == null ? null : priority.copy();
        dst.description = description == null ? null : description.copy();
        if (replaces != null) {
          dst.replaces = new ArrayList<Reference>();
          for (Reference i : replaces)
            dst.replaces.add(i.copy());
        };
        if (supportingInformation != null) {
          dst.supportingInformation = new ArrayList<Reference>();
          for (Reference i : supportingInformation)
            dst.supportingInformation.add(i.copy());
        };
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        dst.minutesDuration = minutesDuration == null ? null : minutesDuration.copy();
        if (slot != null) {
          dst.slot = new ArrayList<Reference>();
          for (Reference i : slot)
            dst.slot.add(i.copy());
        };
        if (account != null) {
          dst.account = new ArrayList<Reference>();
          for (Reference i : account)
            dst.account.add(i.copy());
        };
        dst.created = created == null ? null : created.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (patientInstruction != null) {
          dst.patientInstruction = new ArrayList<CodeableReference>();
          for (CodeableReference i : patientInstruction)
            dst.patientInstruction.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        if (participant != null) {
          dst.participant = new ArrayList<AppointmentParticipantComponent>();
          for (AppointmentParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        if (requestedPeriod != null) {
          dst.requestedPeriod = new ArrayList<Period>();
          for (Period i : requestedPeriod)
            dst.requestedPeriod.add(i.copy());
        };
      }

      protected Appointment typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Appointment))
          return false;
        Appointment o = (Appointment) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(cancellationReason, o.cancellationReason, true)
           && compareDeep(serviceCategory, o.serviceCategory, true) && compareDeep(serviceType, o.serviceType, true)
           && compareDeep(specialty, o.specialty, true) && compareDeep(appointmentType, o.appointmentType, true)
           && compareDeep(reason, o.reason, true) && compareDeep(priority, o.priority, true) && compareDeep(description, o.description, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(supportingInformation, o.supportingInformation, true)
           && compareDeep(start, o.start, true) && compareDeep(end, o.end, true) && compareDeep(minutesDuration, o.minutesDuration, true)
           && compareDeep(slot, o.slot, true) && compareDeep(account, o.account, true) && compareDeep(created, o.created, true)
           && compareDeep(note, o.note, true) && compareDeep(patientInstruction, o.patientInstruction, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(subject, o.subject, true) && compareDeep(participant, o.participant, true)
           && compareDeep(requestedPeriod, o.requestedPeriod, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Appointment))
          return false;
        Appointment o = (Appointment) other_;
        return compareValues(status, o.status, true) && compareValues(description, o.description, true) && compareValues(start, o.start, true)
           && compareValues(end, o.end, true) && compareValues(minutesDuration, o.minutesDuration, true) && compareValues(created, o.created, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, cancellationReason
          , serviceCategory, serviceType, specialty, appointmentType, reason, priority, description
          , replaces, supportingInformation, start, end, minutesDuration, slot, account
          , created, note, patientInstruction, basedOn, subject, participant, requestedPeriod
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Appointment;
   }


}

