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
        public Enumeration<AppointmentStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AppointmentStatus>(this, AppointmentStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<AppointmentStatus>(this, AppointmentStatus.NULL, code);
        if ("proposed".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.PROPOSED, code);
        if ("pending".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.PENDING, code);
        if ("booked".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.BOOKED, code);
        if ("arrived".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.ARRIVED, code);
        if ("fulfilled".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.FULFILLED, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.CANCELLED, code);
        if ("noshow".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.NOSHOW, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.ENTEREDINERROR, code);
        if ("checked-in".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.CHECKEDIN, code);
        if ("waitlist".equals(codeString))
          return new Enumeration<AppointmentStatus>(this, AppointmentStatus.WAITLIST, code);
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

    public enum ParticipationStatus {
        /**
         * The participant has accepted the appointment.
         */
        ACCEPTED, 
        /**
         * The participant has declined the appointment and will not participate in the appointment.
         */
        DECLINED, 
        /**
         * The participant has  tentatively accepted the appointment. This could be automatically created by a system and requires further processing before it can be accepted. There is no commitment that attendance will occur.
         */
        TENTATIVE, 
        /**
         * The participant needs to indicate if they accept the appointment by changing this status to one of the other statuses.
         */
        NEEDSACTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ParticipationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("accepted".equals(codeString))
          return ACCEPTED;
        if ("declined".equals(codeString))
          return DECLINED;
        if ("tentative".equals(codeString))
          return TENTATIVE;
        if ("needs-action".equals(codeString))
          return NEEDSACTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ParticipationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCEPTED: return "accepted";
            case DECLINED: return "declined";
            case TENTATIVE: return "tentative";
            case NEEDSACTION: return "needs-action";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCEPTED: return "http://hl7.org/fhir/participationstatus";
            case DECLINED: return "http://hl7.org/fhir/participationstatus";
            case TENTATIVE: return "http://hl7.org/fhir/participationstatus";
            case NEEDSACTION: return "http://hl7.org/fhir/participationstatus";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCEPTED: return "The participant has accepted the appointment.";
            case DECLINED: return "The participant has declined the appointment and will not participate in the appointment.";
            case TENTATIVE: return "The participant has  tentatively accepted the appointment. This could be automatically created by a system and requires further processing before it can be accepted. There is no commitment that attendance will occur.";
            case NEEDSACTION: return "The participant needs to indicate if they accept the appointment by changing this status to one of the other statuses.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCEPTED: return "Accepted";
            case DECLINED: return "Declined";
            case TENTATIVE: return "Tentative";
            case NEEDSACTION: return "Needs Action";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ParticipationStatusEnumFactory implements EnumFactory<ParticipationStatus> {
    public ParticipationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("accepted".equals(codeString))
          return ParticipationStatus.ACCEPTED;
        if ("declined".equals(codeString))
          return ParticipationStatus.DECLINED;
        if ("tentative".equals(codeString))
          return ParticipationStatus.TENTATIVE;
        if ("needs-action".equals(codeString))
          return ParticipationStatus.NEEDSACTION;
        throw new IllegalArgumentException("Unknown ParticipationStatus code '"+codeString+"'");
        }
        public Enumeration<ParticipationStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ParticipationStatus>(this, ParticipationStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ParticipationStatus>(this, ParticipationStatus.NULL, code);
        if ("accepted".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.ACCEPTED, code);
        if ("declined".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.DECLINED, code);
        if ("tentative".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.TENTATIVE, code);
        if ("needs-action".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.NEEDSACTION, code);
        throw new FHIRException("Unknown ParticipationStatus code '"+codeString+"'");
        }
    public String toCode(ParticipationStatus code) {
      if (code == ParticipationStatus.ACCEPTED)
        return "accepted";
      if (code == ParticipationStatus.DECLINED)
        return "declined";
      if (code == ParticipationStatus.TENTATIVE)
        return "tentative";
      if (code == ParticipationStatus.NEEDSACTION)
        return "needs-action";
      return "?";
      }
    public String toSystem(ParticipationStatus code) {
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
         * The individual, device, location, or service participating in the appointment.
         */
        @Child(name = "actor", type = {Patient.class, Group.class, Practitioner.class, PractitionerRole.class, CareTeam.class, RelatedPerson.class, Device.class, HealthcareService.class, Location.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The individual, device, location, or service participating in the appointment", formalDefinition="The individual, device, location, or service participating in the appointment." )
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
         * @return {@link #actor} (The individual, device, location, or service participating in the appointment.)
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
         * @param value {@link #actor} (The individual, device, location, or service participating in the appointment.)
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
          children.add(new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|CareTeam|RelatedPerson|Device|HealthcareService|Location)", "The individual, device, location, or service participating in the appointment.", 0, 1, actor));
          children.add(new Property("required", "boolean", "Whether this participant is required to be present at the meeting. If false, the participant is optional.", 0, 1, required));
          children.add(new Property("status", "code", "Participation status of the actor.", 0, 1, status));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, type);
          case -991726143: /*period*/  return new Property("period", "Period", "Participation period of the actor.", 0, 1, period);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|CareTeam|RelatedPerson|Device|HealthcareService|Location)", "The individual, device, location, or service participating in the appointment.", 0, 1, actor);
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
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.participant.required");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.participant.status");
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

    @Block()
    public static class AppointmentRecurrenceTemplateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The timezone of the recurring appointment occurrences.
         */
        @Child(name = "timezone", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The timezone of the occurrences", formalDefinition="The timezone of the recurring appointment occurrences." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/timezones")
        protected CodeableConcept timezone;

        /**
         * How often the appointment series should recur.
         */
        @Child(name = "recurrenceType", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The frequency of the recurrence", formalDefinition="How often the appointment series should recur." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/appointment-recurrrence-type")
        protected CodeableConcept recurrenceType;

        /**
         * Recurring appointments will not occur after this date.
         */
        @Child(name = "lastOccurrenceDate", type = {DateType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date when the recurrence should end", formalDefinition="Recurring appointments will not occur after this date." )
        protected DateType lastOccurrenceDate;

        /**
         * How many appointments are planned in the recurrence.
         */
        @Child(name = "occurrenceCount", type = {PositiveIntType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of planned occurrences", formalDefinition="How many appointments are planned in the recurrence." )
        protected PositiveIntType occurrenceCount;

        /**
         * The list of specific dates that will have appointments generated.
         */
        @Child(name = "occurrenceDate", type = {DateType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specific dates for a recurring set of appointments (no template)", formalDefinition="The list of specific dates that will have appointments generated." )
        protected List<DateType> occurrenceDate;

        /**
         * Information about weekly recurring appointments.
         */
        @Child(name = "weeklyTemplate", type = {}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Information about weekly recurring appointments", formalDefinition="Information about weekly recurring appointments." )
        protected AppointmentRecurrenceTemplateWeeklyTemplateComponent weeklyTemplate;

        /**
         * Information about monthly recurring appointments.
         */
        @Child(name = "monthlyTemplate", type = {}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Information about monthly recurring appointments", formalDefinition="Information about monthly recurring appointments." )
        protected AppointmentRecurrenceTemplateMonthlyTemplateComponent monthlyTemplate;

        /**
         * Information about yearly recurring appointments.
         */
        @Child(name = "yearlyTemplate", type = {}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Information about yearly recurring appointments", formalDefinition="Information about yearly recurring appointments." )
        protected AppointmentRecurrenceTemplateYearlyTemplateComponent yearlyTemplate;

        /**
         * Any dates, such as holidays, that should be excluded from the recurrence.
         */
        @Child(name = "excludingDate", type = {DateType.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Any dates that should be excluded from the series", formalDefinition="Any dates, such as holidays, that should be excluded from the recurrence." )
        protected List<DateType> excludingDate;

        /**
         * Any dates, such as holidays, that should be excluded from the recurrence.
         */
        @Child(name = "excludingRecurrenceId", type = {PositiveIntType.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Any recurrence IDs that should be excluded from the recurrence", formalDefinition="Any dates, such as holidays, that should be excluded from the recurrence." )
        protected List<PositiveIntType> excludingRecurrenceId;

        private static final long serialVersionUID = -1582999176L;

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateComponent(CodeableConcept recurrenceType) {
        super();
        this.setRecurrenceType(recurrenceType);
      }

        /**
         * @return {@link #timezone} (The timezone of the recurring appointment occurrences.)
         */
        public CodeableConcept getTimezone() { 
          if (this.timezone == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.timezone");
            else if (Configuration.doAutoCreate())
              this.timezone = new CodeableConcept(); // cc
          return this.timezone;
        }

        public boolean hasTimezone() { 
          return this.timezone != null && !this.timezone.isEmpty();
        }

        /**
         * @param value {@link #timezone} (The timezone of the recurring appointment occurrences.)
         */
        public AppointmentRecurrenceTemplateComponent setTimezone(CodeableConcept value) { 
          this.timezone = value;
          return this;
        }

        /**
         * @return {@link #recurrenceType} (How often the appointment series should recur.)
         */
        public CodeableConcept getRecurrenceType() { 
          if (this.recurrenceType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.recurrenceType");
            else if (Configuration.doAutoCreate())
              this.recurrenceType = new CodeableConcept(); // cc
          return this.recurrenceType;
        }

        public boolean hasRecurrenceType() { 
          return this.recurrenceType != null && !this.recurrenceType.isEmpty();
        }

        /**
         * @param value {@link #recurrenceType} (How often the appointment series should recur.)
         */
        public AppointmentRecurrenceTemplateComponent setRecurrenceType(CodeableConcept value) { 
          this.recurrenceType = value;
          return this;
        }

        /**
         * @return {@link #lastOccurrenceDate} (Recurring appointments will not occur after this date.). This is the underlying object with id, value and extensions. The accessor "getLastOccurrenceDate" gives direct access to the value
         */
        public DateType getLastOccurrenceDateElement() { 
          if (this.lastOccurrenceDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.lastOccurrenceDate");
            else if (Configuration.doAutoCreate())
              this.lastOccurrenceDate = new DateType(); // bb
          return this.lastOccurrenceDate;
        }

        public boolean hasLastOccurrenceDateElement() { 
          return this.lastOccurrenceDate != null && !this.lastOccurrenceDate.isEmpty();
        }

        public boolean hasLastOccurrenceDate() { 
          return this.lastOccurrenceDate != null && !this.lastOccurrenceDate.isEmpty();
        }

        /**
         * @param value {@link #lastOccurrenceDate} (Recurring appointments will not occur after this date.). This is the underlying object with id, value and extensions. The accessor "getLastOccurrenceDate" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateComponent setLastOccurrenceDateElement(DateType value) { 
          this.lastOccurrenceDate = value;
          return this;
        }

        /**
         * @return Recurring appointments will not occur after this date.
         */
        public Date getLastOccurrenceDate() { 
          return this.lastOccurrenceDate == null ? null : this.lastOccurrenceDate.getValue();
        }

        /**
         * @param value Recurring appointments will not occur after this date.
         */
        public AppointmentRecurrenceTemplateComponent setLastOccurrenceDate(Date value) { 
          if (value == null)
            this.lastOccurrenceDate = null;
          else {
            if (this.lastOccurrenceDate == null)
              this.lastOccurrenceDate = new DateType();
            this.lastOccurrenceDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #occurrenceCount} (How many appointments are planned in the recurrence.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceCount" gives direct access to the value
         */
        public PositiveIntType getOccurrenceCountElement() { 
          if (this.occurrenceCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.occurrenceCount");
            else if (Configuration.doAutoCreate())
              this.occurrenceCount = new PositiveIntType(); // bb
          return this.occurrenceCount;
        }

        public boolean hasOccurrenceCountElement() { 
          return this.occurrenceCount != null && !this.occurrenceCount.isEmpty();
        }

        public boolean hasOccurrenceCount() { 
          return this.occurrenceCount != null && !this.occurrenceCount.isEmpty();
        }

        /**
         * @param value {@link #occurrenceCount} (How many appointments are planned in the recurrence.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceCount" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateComponent setOccurrenceCountElement(PositiveIntType value) { 
          this.occurrenceCount = value;
          return this;
        }

        /**
         * @return How many appointments are planned in the recurrence.
         */
        public int getOccurrenceCount() { 
          return this.occurrenceCount == null || this.occurrenceCount.isEmpty() ? 0 : this.occurrenceCount.getValue();
        }

        /**
         * @param value How many appointments are planned in the recurrence.
         */
        public AppointmentRecurrenceTemplateComponent setOccurrenceCount(int value) { 
            if (this.occurrenceCount == null)
              this.occurrenceCount = new PositiveIntType();
            this.occurrenceCount.setValue(value);
          return this;
        }

        /**
         * @return {@link #occurrenceDate} (The list of specific dates that will have appointments generated.)
         */
        public List<DateType> getOccurrenceDate() { 
          if (this.occurrenceDate == null)
            this.occurrenceDate = new ArrayList<DateType>();
          return this.occurrenceDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AppointmentRecurrenceTemplateComponent setOccurrenceDate(List<DateType> theOccurrenceDate) { 
          this.occurrenceDate = theOccurrenceDate;
          return this;
        }

        public boolean hasOccurrenceDate() { 
          if (this.occurrenceDate == null)
            return false;
          for (DateType item : this.occurrenceDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #occurrenceDate} (The list of specific dates that will have appointments generated.)
         */
        public DateType addOccurrenceDateElement() {//2 
          DateType t = new DateType();
          if (this.occurrenceDate == null)
            this.occurrenceDate = new ArrayList<DateType>();
          this.occurrenceDate.add(t);
          return t;
        }

        /**
         * @param value {@link #occurrenceDate} (The list of specific dates that will have appointments generated.)
         */
        public AppointmentRecurrenceTemplateComponent addOccurrenceDate(Date value) { //1
          DateType t = new DateType();
          t.setValue(value);
          if (this.occurrenceDate == null)
            this.occurrenceDate = new ArrayList<DateType>();
          this.occurrenceDate.add(t);
          return this;
        }

        /**
         * @param value {@link #occurrenceDate} (The list of specific dates that will have appointments generated.)
         */
        public boolean hasOccurrenceDate(Date value) { 
          if (this.occurrenceDate == null)
            return false;
          for (DateType v : this.occurrenceDate)
            if (v.getValue().equals(value)) // date
              return true;
          return false;
        }

        /**
         * @return {@link #weeklyTemplate} (Information about weekly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent getWeeklyTemplate() { 
          if (this.weeklyTemplate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.weeklyTemplate");
            else if (Configuration.doAutoCreate())
              this.weeklyTemplate = new AppointmentRecurrenceTemplateWeeklyTemplateComponent(); // cc
          return this.weeklyTemplate;
        }

        public boolean hasWeeklyTemplate() { 
          return this.weeklyTemplate != null && !this.weeklyTemplate.isEmpty();
        }

        /**
         * @param value {@link #weeklyTemplate} (Information about weekly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateComponent setWeeklyTemplate(AppointmentRecurrenceTemplateWeeklyTemplateComponent value) { 
          this.weeklyTemplate = value;
          return this;
        }

        /**
         * @return {@link #monthlyTemplate} (Information about monthly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent getMonthlyTemplate() { 
          if (this.monthlyTemplate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.monthlyTemplate");
            else if (Configuration.doAutoCreate())
              this.monthlyTemplate = new AppointmentRecurrenceTemplateMonthlyTemplateComponent(); // cc
          return this.monthlyTemplate;
        }

        public boolean hasMonthlyTemplate() { 
          return this.monthlyTemplate != null && !this.monthlyTemplate.isEmpty();
        }

        /**
         * @param value {@link #monthlyTemplate} (Information about monthly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateComponent setMonthlyTemplate(AppointmentRecurrenceTemplateMonthlyTemplateComponent value) { 
          this.monthlyTemplate = value;
          return this;
        }

        /**
         * @return {@link #yearlyTemplate} (Information about yearly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateYearlyTemplateComponent getYearlyTemplate() { 
          if (this.yearlyTemplate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateComponent.yearlyTemplate");
            else if (Configuration.doAutoCreate())
              this.yearlyTemplate = new AppointmentRecurrenceTemplateYearlyTemplateComponent(); // cc
          return this.yearlyTemplate;
        }

        public boolean hasYearlyTemplate() { 
          return this.yearlyTemplate != null && !this.yearlyTemplate.isEmpty();
        }

        /**
         * @param value {@link #yearlyTemplate} (Information about yearly recurring appointments.)
         */
        public AppointmentRecurrenceTemplateComponent setYearlyTemplate(AppointmentRecurrenceTemplateYearlyTemplateComponent value) { 
          this.yearlyTemplate = value;
          return this;
        }

        /**
         * @return {@link #excludingDate} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public List<DateType> getExcludingDate() { 
          if (this.excludingDate == null)
            this.excludingDate = new ArrayList<DateType>();
          return this.excludingDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AppointmentRecurrenceTemplateComponent setExcludingDate(List<DateType> theExcludingDate) { 
          this.excludingDate = theExcludingDate;
          return this;
        }

        public boolean hasExcludingDate() { 
          if (this.excludingDate == null)
            return false;
          for (DateType item : this.excludingDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #excludingDate} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public DateType addExcludingDateElement() {//2 
          DateType t = new DateType();
          if (this.excludingDate == null)
            this.excludingDate = new ArrayList<DateType>();
          this.excludingDate.add(t);
          return t;
        }

        /**
         * @param value {@link #excludingDate} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public AppointmentRecurrenceTemplateComponent addExcludingDate(Date value) { //1
          DateType t = new DateType();
          t.setValue(value);
          if (this.excludingDate == null)
            this.excludingDate = new ArrayList<DateType>();
          this.excludingDate.add(t);
          return this;
        }

        /**
         * @param value {@link #excludingDate} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public boolean hasExcludingDate(Date value) { 
          if (this.excludingDate == null)
            return false;
          for (DateType v : this.excludingDate)
            if (v.getValue().equals(value)) // date
              return true;
          return false;
        }

        /**
         * @return {@link #excludingRecurrenceId} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public List<PositiveIntType> getExcludingRecurrenceId() { 
          if (this.excludingRecurrenceId == null)
            this.excludingRecurrenceId = new ArrayList<PositiveIntType>();
          return this.excludingRecurrenceId;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AppointmentRecurrenceTemplateComponent setExcludingRecurrenceId(List<PositiveIntType> theExcludingRecurrenceId) { 
          this.excludingRecurrenceId = theExcludingRecurrenceId;
          return this;
        }

        public boolean hasExcludingRecurrenceId() { 
          if (this.excludingRecurrenceId == null)
            return false;
          for (PositiveIntType item : this.excludingRecurrenceId)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #excludingRecurrenceId} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public PositiveIntType addExcludingRecurrenceIdElement() {//2 
          PositiveIntType t = new PositiveIntType();
          if (this.excludingRecurrenceId == null)
            this.excludingRecurrenceId = new ArrayList<PositiveIntType>();
          this.excludingRecurrenceId.add(t);
          return t;
        }

        /**
         * @param value {@link #excludingRecurrenceId} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public AppointmentRecurrenceTemplateComponent addExcludingRecurrenceId(int value) { //1
          PositiveIntType t = new PositiveIntType();
          t.setValue(value);
          if (this.excludingRecurrenceId == null)
            this.excludingRecurrenceId = new ArrayList<PositiveIntType>();
          this.excludingRecurrenceId.add(t);
          return this;
        }

        /**
         * @param value {@link #excludingRecurrenceId} (Any dates, such as holidays, that should be excluded from the recurrence.)
         */
        public boolean hasExcludingRecurrenceId(int value) { 
          if (this.excludingRecurrenceId == null)
            return false;
          for (PositiveIntType v : this.excludingRecurrenceId)
            if (v.getValue().equals(value)) // positiveInt
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("timezone", "CodeableConcept", "The timezone of the recurring appointment occurrences.", 0, 1, timezone));
          children.add(new Property("recurrenceType", "CodeableConcept", "How often the appointment series should recur.", 0, 1, recurrenceType));
          children.add(new Property("lastOccurrenceDate", "date", "Recurring appointments will not occur after this date.", 0, 1, lastOccurrenceDate));
          children.add(new Property("occurrenceCount", "positiveInt", "How many appointments are planned in the recurrence.", 0, 1, occurrenceCount));
          children.add(new Property("occurrenceDate", "date", "The list of specific dates that will have appointments generated.", 0, java.lang.Integer.MAX_VALUE, occurrenceDate));
          children.add(new Property("weeklyTemplate", "", "Information about weekly recurring appointments.", 0, 1, weeklyTemplate));
          children.add(new Property("monthlyTemplate", "", "Information about monthly recurring appointments.", 0, 1, monthlyTemplate));
          children.add(new Property("yearlyTemplate", "", "Information about yearly recurring appointments.", 0, 1, yearlyTemplate));
          children.add(new Property("excludingDate", "date", "Any dates, such as holidays, that should be excluded from the recurrence.", 0, java.lang.Integer.MAX_VALUE, excludingDate));
          children.add(new Property("excludingRecurrenceId", "positiveInt", "Any dates, such as holidays, that should be excluded from the recurrence.", 0, java.lang.Integer.MAX_VALUE, excludingRecurrenceId));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -2076227591: /*timezone*/  return new Property("timezone", "CodeableConcept", "The timezone of the recurring appointment occurrences.", 0, 1, timezone);
          case -381221238: /*recurrenceType*/  return new Property("recurrenceType", "CodeableConcept", "How often the appointment series should recur.", 0, 1, recurrenceType);
          case -1262346923: /*lastOccurrenceDate*/  return new Property("lastOccurrenceDate", "date", "Recurring appointments will not occur after this date.", 0, 1, lastOccurrenceDate);
          case 1834480062: /*occurrenceCount*/  return new Property("occurrenceCount", "positiveInt", "How many appointments are planned in the recurrence.", 0, 1, occurrenceCount);
          case 1721761055: /*occurrenceDate*/  return new Property("occurrenceDate", "date", "The list of specific dates that will have appointments generated.", 0, java.lang.Integer.MAX_VALUE, occurrenceDate);
          case 887136283: /*weeklyTemplate*/  return new Property("weeklyTemplate", "", "Information about weekly recurring appointments.", 0, 1, weeklyTemplate);
          case 2142528423: /*monthlyTemplate*/  return new Property("monthlyTemplate", "", "Information about monthly recurring appointments.", 0, 1, monthlyTemplate);
          case -334069468: /*yearlyTemplate*/  return new Property("yearlyTemplate", "", "Information about yearly recurring appointments.", 0, 1, yearlyTemplate);
          case 596601957: /*excludingDate*/  return new Property("excludingDate", "date", "Any dates, such as holidays, that should be excluded from the recurrence.", 0, java.lang.Integer.MAX_VALUE, excludingDate);
          case -797577694: /*excludingRecurrenceId*/  return new Property("excludingRecurrenceId", "positiveInt", "Any dates, such as holidays, that should be excluded from the recurrence.", 0, java.lang.Integer.MAX_VALUE, excludingRecurrenceId);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -2076227591: /*timezone*/ return this.timezone == null ? new Base[0] : new Base[] {this.timezone}; // CodeableConcept
        case -381221238: /*recurrenceType*/ return this.recurrenceType == null ? new Base[0] : new Base[] {this.recurrenceType}; // CodeableConcept
        case -1262346923: /*lastOccurrenceDate*/ return this.lastOccurrenceDate == null ? new Base[0] : new Base[] {this.lastOccurrenceDate}; // DateType
        case 1834480062: /*occurrenceCount*/ return this.occurrenceCount == null ? new Base[0] : new Base[] {this.occurrenceCount}; // PositiveIntType
        case 1721761055: /*occurrenceDate*/ return this.occurrenceDate == null ? new Base[0] : this.occurrenceDate.toArray(new Base[this.occurrenceDate.size()]); // DateType
        case 887136283: /*weeklyTemplate*/ return this.weeklyTemplate == null ? new Base[0] : new Base[] {this.weeklyTemplate}; // AppointmentRecurrenceTemplateWeeklyTemplateComponent
        case 2142528423: /*monthlyTemplate*/ return this.monthlyTemplate == null ? new Base[0] : new Base[] {this.monthlyTemplate}; // AppointmentRecurrenceTemplateMonthlyTemplateComponent
        case -334069468: /*yearlyTemplate*/ return this.yearlyTemplate == null ? new Base[0] : new Base[] {this.yearlyTemplate}; // AppointmentRecurrenceTemplateYearlyTemplateComponent
        case 596601957: /*excludingDate*/ return this.excludingDate == null ? new Base[0] : this.excludingDate.toArray(new Base[this.excludingDate.size()]); // DateType
        case -797577694: /*excludingRecurrenceId*/ return this.excludingRecurrenceId == null ? new Base[0] : this.excludingRecurrenceId.toArray(new Base[this.excludingRecurrenceId.size()]); // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -2076227591: // timezone
          this.timezone = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -381221238: // recurrenceType
          this.recurrenceType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1262346923: // lastOccurrenceDate
          this.lastOccurrenceDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case 1834480062: // occurrenceCount
          this.occurrenceCount = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 1721761055: // occurrenceDate
          this.getOccurrenceDate().add(TypeConvertor.castToDate(value)); // DateType
          return value;
        case 887136283: // weeklyTemplate
          this.weeklyTemplate = (AppointmentRecurrenceTemplateWeeklyTemplateComponent) value; // AppointmentRecurrenceTemplateWeeklyTemplateComponent
          return value;
        case 2142528423: // monthlyTemplate
          this.monthlyTemplate = (AppointmentRecurrenceTemplateMonthlyTemplateComponent) value; // AppointmentRecurrenceTemplateMonthlyTemplateComponent
          return value;
        case -334069468: // yearlyTemplate
          this.yearlyTemplate = (AppointmentRecurrenceTemplateYearlyTemplateComponent) value; // AppointmentRecurrenceTemplateYearlyTemplateComponent
          return value;
        case 596601957: // excludingDate
          this.getExcludingDate().add(TypeConvertor.castToDate(value)); // DateType
          return value;
        case -797577694: // excludingRecurrenceId
          this.getExcludingRecurrenceId().add(TypeConvertor.castToPositiveInt(value)); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("timezone")) {
          this.timezone = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("recurrenceType")) {
          this.recurrenceType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("lastOccurrenceDate")) {
          this.lastOccurrenceDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("occurrenceCount")) {
          this.occurrenceCount = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("occurrenceDate")) {
          this.getOccurrenceDate().add(TypeConvertor.castToDate(value));
        } else if (name.equals("weeklyTemplate")) {
          this.weeklyTemplate = (AppointmentRecurrenceTemplateWeeklyTemplateComponent) value; // AppointmentRecurrenceTemplateWeeklyTemplateComponent
        } else if (name.equals("monthlyTemplate")) {
          this.monthlyTemplate = (AppointmentRecurrenceTemplateMonthlyTemplateComponent) value; // AppointmentRecurrenceTemplateMonthlyTemplateComponent
        } else if (name.equals("yearlyTemplate")) {
          this.yearlyTemplate = (AppointmentRecurrenceTemplateYearlyTemplateComponent) value; // AppointmentRecurrenceTemplateYearlyTemplateComponent
        } else if (name.equals("excludingDate")) {
          this.getExcludingDate().add(TypeConvertor.castToDate(value));
        } else if (name.equals("excludingRecurrenceId")) {
          this.getExcludingRecurrenceId().add(TypeConvertor.castToPositiveInt(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2076227591:  return getTimezone();
        case -381221238:  return getRecurrenceType();
        case -1262346923:  return getLastOccurrenceDateElement();
        case 1834480062:  return getOccurrenceCountElement();
        case 1721761055:  return addOccurrenceDateElement();
        case 887136283:  return getWeeklyTemplate();
        case 2142528423:  return getMonthlyTemplate();
        case -334069468:  return getYearlyTemplate();
        case 596601957:  return addExcludingDateElement();
        case -797577694:  return addExcludingRecurrenceIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2076227591: /*timezone*/ return new String[] {"CodeableConcept"};
        case -381221238: /*recurrenceType*/ return new String[] {"CodeableConcept"};
        case -1262346923: /*lastOccurrenceDate*/ return new String[] {"date"};
        case 1834480062: /*occurrenceCount*/ return new String[] {"positiveInt"};
        case 1721761055: /*occurrenceDate*/ return new String[] {"date"};
        case 887136283: /*weeklyTemplate*/ return new String[] {};
        case 2142528423: /*monthlyTemplate*/ return new String[] {};
        case -334069468: /*yearlyTemplate*/ return new String[] {};
        case 596601957: /*excludingDate*/ return new String[] {"date"};
        case -797577694: /*excludingRecurrenceId*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("timezone")) {
          this.timezone = new CodeableConcept();
          return this.timezone;
        }
        else if (name.equals("recurrenceType")) {
          this.recurrenceType = new CodeableConcept();
          return this.recurrenceType;
        }
        else if (name.equals("lastOccurrenceDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.lastOccurrenceDate");
        }
        else if (name.equals("occurrenceCount")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.occurrenceCount");
        }
        else if (name.equals("occurrenceDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.occurrenceDate");
        }
        else if (name.equals("weeklyTemplate")) {
          this.weeklyTemplate = new AppointmentRecurrenceTemplateWeeklyTemplateComponent();
          return this.weeklyTemplate;
        }
        else if (name.equals("monthlyTemplate")) {
          this.monthlyTemplate = new AppointmentRecurrenceTemplateMonthlyTemplateComponent();
          return this.monthlyTemplate;
        }
        else if (name.equals("yearlyTemplate")) {
          this.yearlyTemplate = new AppointmentRecurrenceTemplateYearlyTemplateComponent();
          return this.yearlyTemplate;
        }
        else if (name.equals("excludingDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.excludingDate");
        }
        else if (name.equals("excludingRecurrenceId")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.excludingRecurrenceId");
        }
        else
          return super.addChild(name);
      }

      public AppointmentRecurrenceTemplateComponent copy() {
        AppointmentRecurrenceTemplateComponent dst = new AppointmentRecurrenceTemplateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentRecurrenceTemplateComponent dst) {
        super.copyValues(dst);
        dst.timezone = timezone == null ? null : timezone.copy();
        dst.recurrenceType = recurrenceType == null ? null : recurrenceType.copy();
        dst.lastOccurrenceDate = lastOccurrenceDate == null ? null : lastOccurrenceDate.copy();
        dst.occurrenceCount = occurrenceCount == null ? null : occurrenceCount.copy();
        if (occurrenceDate != null) {
          dst.occurrenceDate = new ArrayList<DateType>();
          for (DateType i : occurrenceDate)
            dst.occurrenceDate.add(i.copy());
        };
        dst.weeklyTemplate = weeklyTemplate == null ? null : weeklyTemplate.copy();
        dst.monthlyTemplate = monthlyTemplate == null ? null : monthlyTemplate.copy();
        dst.yearlyTemplate = yearlyTemplate == null ? null : yearlyTemplate.copy();
        if (excludingDate != null) {
          dst.excludingDate = new ArrayList<DateType>();
          for (DateType i : excludingDate)
            dst.excludingDate.add(i.copy());
        };
        if (excludingRecurrenceId != null) {
          dst.excludingRecurrenceId = new ArrayList<PositiveIntType>();
          for (PositiveIntType i : excludingRecurrenceId)
            dst.excludingRecurrenceId.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateComponent o = (AppointmentRecurrenceTemplateComponent) other_;
        return compareDeep(timezone, o.timezone, true) && compareDeep(recurrenceType, o.recurrenceType, true)
           && compareDeep(lastOccurrenceDate, o.lastOccurrenceDate, true) && compareDeep(occurrenceCount, o.occurrenceCount, true)
           && compareDeep(occurrenceDate, o.occurrenceDate, true) && compareDeep(weeklyTemplate, o.weeklyTemplate, true)
           && compareDeep(monthlyTemplate, o.monthlyTemplate, true) && compareDeep(yearlyTemplate, o.yearlyTemplate, true)
           && compareDeep(excludingDate, o.excludingDate, true) && compareDeep(excludingRecurrenceId, o.excludingRecurrenceId, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateComponent o = (AppointmentRecurrenceTemplateComponent) other_;
        return compareValues(lastOccurrenceDate, o.lastOccurrenceDate, true) && compareValues(occurrenceCount, o.occurrenceCount, true)
           && compareValues(occurrenceDate, o.occurrenceDate, true) && compareValues(excludingDate, o.excludingDate, true)
           && compareValues(excludingRecurrenceId, o.excludingRecurrenceId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(timezone, recurrenceType, lastOccurrenceDate
          , occurrenceCount, occurrenceDate, weeklyTemplate, monthlyTemplate, yearlyTemplate
          , excludingDate, excludingRecurrenceId);
      }

  public String fhirType() {
    return "Appointment.recurrenceTemplate";

  }

  }

    @Block()
    public static class AppointmentRecurrenceTemplateWeeklyTemplateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates that recurring appointments should occur on Mondays.
         */
        @Child(name = "monday", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Mondays", formalDefinition="Indicates that recurring appointments should occur on Mondays." )
        protected BooleanType monday;

        /**
         * Indicates that recurring appointments should occur on Tuesdays.
         */
        @Child(name = "tuesday", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Tuesday", formalDefinition="Indicates that recurring appointments should occur on Tuesdays." )
        protected BooleanType tuesday;

        /**
         * Indicates that recurring appointments should occur on Wednesdays.
         */
        @Child(name = "wednesday", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Wednesday", formalDefinition="Indicates that recurring appointments should occur on Wednesdays." )
        protected BooleanType wednesday;

        /**
         * Indicates that recurring appointments should occur on Thursdays.
         */
        @Child(name = "thursday", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Thursday", formalDefinition="Indicates that recurring appointments should occur on Thursdays." )
        protected BooleanType thursday;

        /**
         * Indicates that recurring appointments should occur on Fridays.
         */
        @Child(name = "friday", type = {BooleanType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Friday", formalDefinition="Indicates that recurring appointments should occur on Fridays." )
        protected BooleanType friday;

        /**
         * Indicates that recurring appointments should occur on Saturdays.
         */
        @Child(name = "saturday", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Saturday", formalDefinition="Indicates that recurring appointments should occur on Saturdays." )
        protected BooleanType saturday;

        /**
         * Indicates that recurring appointments should occur on Sundays.
         */
        @Child(name = "sunday", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on Sunday", formalDefinition="Indicates that recurring appointments should occur on Sundays." )
        protected BooleanType sunday;

        /**
         * The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.e.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.
         */
        @Child(name = "weekInterval", type = {PositiveIntType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs every nth week", formalDefinition="The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.\r\re.g. For recurring every second week this interval would be 2, or every third week the interval would be 3." )
        protected PositiveIntType weekInterval;

        private static final long serialVersionUID = 588795188L;

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateWeeklyTemplateComponent() {
        super();
      }

        /**
         * @return {@link #monday} (Indicates that recurring appointments should occur on Mondays.). This is the underlying object with id, value and extensions. The accessor "getMonday" gives direct access to the value
         */
        public BooleanType getMondayElement() { 
          if (this.monday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.monday");
            else if (Configuration.doAutoCreate())
              this.monday = new BooleanType(); // bb
          return this.monday;
        }

        public boolean hasMondayElement() { 
          return this.monday != null && !this.monday.isEmpty();
        }

        public boolean hasMonday() { 
          return this.monday != null && !this.monday.isEmpty();
        }

        /**
         * @param value {@link #monday} (Indicates that recurring appointments should occur on Mondays.). This is the underlying object with id, value and extensions. The accessor "getMonday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setMondayElement(BooleanType value) { 
          this.monday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Mondays.
         */
        public boolean getMonday() { 
          return this.monday == null || this.monday.isEmpty() ? false : this.monday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Mondays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setMonday(boolean value) { 
            if (this.monday == null)
              this.monday = new BooleanType();
            this.monday.setValue(value);
          return this;
        }

        /**
         * @return {@link #tuesday} (Indicates that recurring appointments should occur on Tuesdays.). This is the underlying object with id, value and extensions. The accessor "getTuesday" gives direct access to the value
         */
        public BooleanType getTuesdayElement() { 
          if (this.tuesday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.tuesday");
            else if (Configuration.doAutoCreate())
              this.tuesday = new BooleanType(); // bb
          return this.tuesday;
        }

        public boolean hasTuesdayElement() { 
          return this.tuesday != null && !this.tuesday.isEmpty();
        }

        public boolean hasTuesday() { 
          return this.tuesday != null && !this.tuesday.isEmpty();
        }

        /**
         * @param value {@link #tuesday} (Indicates that recurring appointments should occur on Tuesdays.). This is the underlying object with id, value and extensions. The accessor "getTuesday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setTuesdayElement(BooleanType value) { 
          this.tuesday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Tuesdays.
         */
        public boolean getTuesday() { 
          return this.tuesday == null || this.tuesday.isEmpty() ? false : this.tuesday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Tuesdays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setTuesday(boolean value) { 
            if (this.tuesday == null)
              this.tuesday = new BooleanType();
            this.tuesday.setValue(value);
          return this;
        }

        /**
         * @return {@link #wednesday} (Indicates that recurring appointments should occur on Wednesdays.). This is the underlying object with id, value and extensions. The accessor "getWednesday" gives direct access to the value
         */
        public BooleanType getWednesdayElement() { 
          if (this.wednesday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.wednesday");
            else if (Configuration.doAutoCreate())
              this.wednesday = new BooleanType(); // bb
          return this.wednesday;
        }

        public boolean hasWednesdayElement() { 
          return this.wednesday != null && !this.wednesday.isEmpty();
        }

        public boolean hasWednesday() { 
          return this.wednesday != null && !this.wednesday.isEmpty();
        }

        /**
         * @param value {@link #wednesday} (Indicates that recurring appointments should occur on Wednesdays.). This is the underlying object with id, value and extensions. The accessor "getWednesday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setWednesdayElement(BooleanType value) { 
          this.wednesday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Wednesdays.
         */
        public boolean getWednesday() { 
          return this.wednesday == null || this.wednesday.isEmpty() ? false : this.wednesday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Wednesdays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setWednesday(boolean value) { 
            if (this.wednesday == null)
              this.wednesday = new BooleanType();
            this.wednesday.setValue(value);
          return this;
        }

        /**
         * @return {@link #thursday} (Indicates that recurring appointments should occur on Thursdays.). This is the underlying object with id, value and extensions. The accessor "getThursday" gives direct access to the value
         */
        public BooleanType getThursdayElement() { 
          if (this.thursday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.thursday");
            else if (Configuration.doAutoCreate())
              this.thursday = new BooleanType(); // bb
          return this.thursday;
        }

        public boolean hasThursdayElement() { 
          return this.thursday != null && !this.thursday.isEmpty();
        }

        public boolean hasThursday() { 
          return this.thursday != null && !this.thursday.isEmpty();
        }

        /**
         * @param value {@link #thursday} (Indicates that recurring appointments should occur on Thursdays.). This is the underlying object with id, value and extensions. The accessor "getThursday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setThursdayElement(BooleanType value) { 
          this.thursday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Thursdays.
         */
        public boolean getThursday() { 
          return this.thursday == null || this.thursday.isEmpty() ? false : this.thursday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Thursdays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setThursday(boolean value) { 
            if (this.thursday == null)
              this.thursday = new BooleanType();
            this.thursday.setValue(value);
          return this;
        }

        /**
         * @return {@link #friday} (Indicates that recurring appointments should occur on Fridays.). This is the underlying object with id, value and extensions. The accessor "getFriday" gives direct access to the value
         */
        public BooleanType getFridayElement() { 
          if (this.friday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.friday");
            else if (Configuration.doAutoCreate())
              this.friday = new BooleanType(); // bb
          return this.friday;
        }

        public boolean hasFridayElement() { 
          return this.friday != null && !this.friday.isEmpty();
        }

        public boolean hasFriday() { 
          return this.friday != null && !this.friday.isEmpty();
        }

        /**
         * @param value {@link #friday} (Indicates that recurring appointments should occur on Fridays.). This is the underlying object with id, value and extensions. The accessor "getFriday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setFridayElement(BooleanType value) { 
          this.friday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Fridays.
         */
        public boolean getFriday() { 
          return this.friday == null || this.friday.isEmpty() ? false : this.friday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Fridays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setFriday(boolean value) { 
            if (this.friday == null)
              this.friday = new BooleanType();
            this.friday.setValue(value);
          return this;
        }

        /**
         * @return {@link #saturday} (Indicates that recurring appointments should occur on Saturdays.). This is the underlying object with id, value and extensions. The accessor "getSaturday" gives direct access to the value
         */
        public BooleanType getSaturdayElement() { 
          if (this.saturday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.saturday");
            else if (Configuration.doAutoCreate())
              this.saturday = new BooleanType(); // bb
          return this.saturday;
        }

        public boolean hasSaturdayElement() { 
          return this.saturday != null && !this.saturday.isEmpty();
        }

        public boolean hasSaturday() { 
          return this.saturday != null && !this.saturday.isEmpty();
        }

        /**
         * @param value {@link #saturday} (Indicates that recurring appointments should occur on Saturdays.). This is the underlying object with id, value and extensions. The accessor "getSaturday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setSaturdayElement(BooleanType value) { 
          this.saturday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Saturdays.
         */
        public boolean getSaturday() { 
          return this.saturday == null || this.saturday.isEmpty() ? false : this.saturday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Saturdays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setSaturday(boolean value) { 
            if (this.saturday == null)
              this.saturday = new BooleanType();
            this.saturday.setValue(value);
          return this;
        }

        /**
         * @return {@link #sunday} (Indicates that recurring appointments should occur on Sundays.). This is the underlying object with id, value and extensions. The accessor "getSunday" gives direct access to the value
         */
        public BooleanType getSundayElement() { 
          if (this.sunday == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.sunday");
            else if (Configuration.doAutoCreate())
              this.sunday = new BooleanType(); // bb
          return this.sunday;
        }

        public boolean hasSundayElement() { 
          return this.sunday != null && !this.sunday.isEmpty();
        }

        public boolean hasSunday() { 
          return this.sunday != null && !this.sunday.isEmpty();
        }

        /**
         * @param value {@link #sunday} (Indicates that recurring appointments should occur on Sundays.). This is the underlying object with id, value and extensions. The accessor "getSunday" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setSundayElement(BooleanType value) { 
          this.sunday = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur on Sundays.
         */
        public boolean getSunday() { 
          return this.sunday == null || this.sunday.isEmpty() ? false : this.sunday.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur on Sundays.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setSunday(boolean value) { 
            if (this.sunday == null)
              this.sunday = new BooleanType();
            this.sunday.setValue(value);
          return this;
        }

        /**
         * @return {@link #weekInterval} (The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.e.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.). This is the underlying object with id, value and extensions. The accessor "getWeekInterval" gives direct access to the value
         */
        public PositiveIntType getWeekIntervalElement() { 
          if (this.weekInterval == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateWeeklyTemplateComponent.weekInterval");
            else if (Configuration.doAutoCreate())
              this.weekInterval = new PositiveIntType(); // bb
          return this.weekInterval;
        }

        public boolean hasWeekIntervalElement() { 
          return this.weekInterval != null && !this.weekInterval.isEmpty();
        }

        public boolean hasWeekInterval() { 
          return this.weekInterval != null && !this.weekInterval.isEmpty();
        }

        /**
         * @param value {@link #weekInterval} (The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.e.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.). This is the underlying object with id, value and extensions. The accessor "getWeekInterval" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setWeekIntervalElement(PositiveIntType value) { 
          this.weekInterval = value;
          return this;
        }

        /**
         * @return The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.e.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.
         */
        public int getWeekInterval() { 
          return this.weekInterval == null || this.weekInterval.isEmpty() ? 0 : this.weekInterval.getValue();
        }

        /**
         * @param value The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.e.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.
         */
        public AppointmentRecurrenceTemplateWeeklyTemplateComponent setWeekInterval(int value) { 
            if (this.weekInterval == null)
              this.weekInterval = new PositiveIntType();
            this.weekInterval.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("monday", "boolean", "Indicates that recurring appointments should occur on Mondays.", 0, 1, monday));
          children.add(new Property("tuesday", "boolean", "Indicates that recurring appointments should occur on Tuesdays.", 0, 1, tuesday));
          children.add(new Property("wednesday", "boolean", "Indicates that recurring appointments should occur on Wednesdays.", 0, 1, wednesday));
          children.add(new Property("thursday", "boolean", "Indicates that recurring appointments should occur on Thursdays.", 0, 1, thursday));
          children.add(new Property("friday", "boolean", "Indicates that recurring appointments should occur on Fridays.", 0, 1, friday));
          children.add(new Property("saturday", "boolean", "Indicates that recurring appointments should occur on Saturdays.", 0, 1, saturday));
          children.add(new Property("sunday", "boolean", "Indicates that recurring appointments should occur on Sundays.", 0, 1, sunday));
          children.add(new Property("weekInterval", "positiveInt", "The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.\r\re.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.", 0, 1, weekInterval));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1068502768: /*monday*/  return new Property("monday", "boolean", "Indicates that recurring appointments should occur on Mondays.", 0, 1, monday);
          case -977343923: /*tuesday*/  return new Property("tuesday", "boolean", "Indicates that recurring appointments should occur on Tuesdays.", 0, 1, tuesday);
          case 1393530710: /*wednesday*/  return new Property("wednesday", "boolean", "Indicates that recurring appointments should occur on Wednesdays.", 0, 1, wednesday);
          case 1572055514: /*thursday*/  return new Property("thursday", "boolean", "Indicates that recurring appointments should occur on Thursdays.", 0, 1, thursday);
          case -1266285217: /*friday*/  return new Property("friday", "boolean", "Indicates that recurring appointments should occur on Fridays.", 0, 1, friday);
          case -2114201671: /*saturday*/  return new Property("saturday", "boolean", "Indicates that recurring appointments should occur on Saturdays.", 0, 1, saturday);
          case -891186736: /*sunday*/  return new Property("sunday", "boolean", "Indicates that recurring appointments should occur on Sundays.", 0, 1, sunday);
          case -784550695: /*weekInterval*/  return new Property("weekInterval", "positiveInt", "The interval defines if the recurrence is every nth week. The default is every week, so it is expected that this value will be 2 or more.\r\re.g. For recurring every second week this interval would be 2, or every third week the interval would be 3.", 0, 1, weekInterval);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1068502768: /*monday*/ return this.monday == null ? new Base[0] : new Base[] {this.monday}; // BooleanType
        case -977343923: /*tuesday*/ return this.tuesday == null ? new Base[0] : new Base[] {this.tuesday}; // BooleanType
        case 1393530710: /*wednesday*/ return this.wednesday == null ? new Base[0] : new Base[] {this.wednesday}; // BooleanType
        case 1572055514: /*thursday*/ return this.thursday == null ? new Base[0] : new Base[] {this.thursday}; // BooleanType
        case -1266285217: /*friday*/ return this.friday == null ? new Base[0] : new Base[] {this.friday}; // BooleanType
        case -2114201671: /*saturday*/ return this.saturday == null ? new Base[0] : new Base[] {this.saturday}; // BooleanType
        case -891186736: /*sunday*/ return this.sunday == null ? new Base[0] : new Base[] {this.sunday}; // BooleanType
        case -784550695: /*weekInterval*/ return this.weekInterval == null ? new Base[0] : new Base[] {this.weekInterval}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1068502768: // monday
          this.monday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -977343923: // tuesday
          this.tuesday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1393530710: // wednesday
          this.wednesday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1572055514: // thursday
          this.thursday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1266285217: // friday
          this.friday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -2114201671: // saturday
          this.saturday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -891186736: // sunday
          this.sunday = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -784550695: // weekInterval
          this.weekInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("monday")) {
          this.monday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("tuesday")) {
          this.tuesday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("wednesday")) {
          this.wednesday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("thursday")) {
          this.thursday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("friday")) {
          this.friday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("saturday")) {
          this.saturday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("sunday")) {
          this.sunday = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("weekInterval")) {
          this.weekInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1068502768:  return getMondayElement();
        case -977343923:  return getTuesdayElement();
        case 1393530710:  return getWednesdayElement();
        case 1572055514:  return getThursdayElement();
        case -1266285217:  return getFridayElement();
        case -2114201671:  return getSaturdayElement();
        case -891186736:  return getSundayElement();
        case -784550695:  return getWeekIntervalElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1068502768: /*monday*/ return new String[] {"boolean"};
        case -977343923: /*tuesday*/ return new String[] {"boolean"};
        case 1393530710: /*wednesday*/ return new String[] {"boolean"};
        case 1572055514: /*thursday*/ return new String[] {"boolean"};
        case -1266285217: /*friday*/ return new String[] {"boolean"};
        case -2114201671: /*saturday*/ return new String[] {"boolean"};
        case -891186736: /*sunday*/ return new String[] {"boolean"};
        case -784550695: /*weekInterval*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("monday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.monday");
        }
        else if (name.equals("tuesday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.tuesday");
        }
        else if (name.equals("wednesday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.wednesday");
        }
        else if (name.equals("thursday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.thursday");
        }
        else if (name.equals("friday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.friday");
        }
        else if (name.equals("saturday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.saturday");
        }
        else if (name.equals("sunday")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.sunday");
        }
        else if (name.equals("weekInterval")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.weeklyTemplate.weekInterval");
        }
        else
          return super.addChild(name);
      }

      public AppointmentRecurrenceTemplateWeeklyTemplateComponent copy() {
        AppointmentRecurrenceTemplateWeeklyTemplateComponent dst = new AppointmentRecurrenceTemplateWeeklyTemplateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentRecurrenceTemplateWeeklyTemplateComponent dst) {
        super.copyValues(dst);
        dst.monday = monday == null ? null : monday.copy();
        dst.tuesday = tuesday == null ? null : tuesday.copy();
        dst.wednesday = wednesday == null ? null : wednesday.copy();
        dst.thursday = thursday == null ? null : thursday.copy();
        dst.friday = friday == null ? null : friday.copy();
        dst.saturday = saturday == null ? null : saturday.copy();
        dst.sunday = sunday == null ? null : sunday.copy();
        dst.weekInterval = weekInterval == null ? null : weekInterval.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateWeeklyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateWeeklyTemplateComponent o = (AppointmentRecurrenceTemplateWeeklyTemplateComponent) other_;
        return compareDeep(monday, o.monday, true) && compareDeep(tuesday, o.tuesday, true) && compareDeep(wednesday, o.wednesday, true)
           && compareDeep(thursday, o.thursday, true) && compareDeep(friday, o.friday, true) && compareDeep(saturday, o.saturday, true)
           && compareDeep(sunday, o.sunday, true) && compareDeep(weekInterval, o.weekInterval, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateWeeklyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateWeeklyTemplateComponent o = (AppointmentRecurrenceTemplateWeeklyTemplateComponent) other_;
        return compareValues(monday, o.monday, true) && compareValues(tuesday, o.tuesday, true) && compareValues(wednesday, o.wednesday, true)
           && compareValues(thursday, o.thursday, true) && compareValues(friday, o.friday, true) && compareValues(saturday, o.saturday, true)
           && compareValues(sunday, o.sunday, true) && compareValues(weekInterval, o.weekInterval, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(monday, tuesday, wednesday
          , thursday, friday, saturday, sunday, weekInterval);
      }

  public String fhirType() {
    return "Appointment.recurrenceTemplate.weeklyTemplate";

  }

  }

    @Block()
    public static class AppointmentRecurrenceTemplateMonthlyTemplateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.
         */
        @Child(name = "dayOfMonth", type = {PositiveIntType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs on a specific day of the month", formalDefinition="Indicates that appointments in the series of recurring appointments should occur on a specific day of the month." )
        protected PositiveIntType dayOfMonth;

        /**
         * Indicates which week within a month the appointments in the series of recurring appointments should occur on.
         */
        @Child(name = "nthWeekOfMonth", type = {Coding.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates which week of the month the appointment should occur", formalDefinition="Indicates which week within a month the appointments in the series of recurring appointments should occur on." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/week-of-month")
        protected Coding nthWeekOfMonth;

        /**
         * Indicates which day of the week the recurring appointments should occur each nth week.
         */
        @Child(name = "dayOfWeek", type = {Coding.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates which day of the week the appointment should occur", formalDefinition="Indicates which day of the week the recurring appointments should occur each nth week." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/days-of-week")
        protected Coding dayOfWeek;

        /**
         * Indicates that recurring appointments should occur every nth month.
         */
        @Child(name = "monthInterval", type = {PositiveIntType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs every nth month", formalDefinition="Indicates that recurring appointments should occur every nth month." )
        protected PositiveIntType monthInterval;

        private static final long serialVersionUID = -1234046272L;

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateMonthlyTemplateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateMonthlyTemplateComponent(int monthInterval) {
        super();
        this.setMonthInterval(monthInterval);
      }

        /**
         * @return {@link #dayOfMonth} (Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.). This is the underlying object with id, value and extensions. The accessor "getDayOfMonth" gives direct access to the value
         */
        public PositiveIntType getDayOfMonthElement() { 
          if (this.dayOfMonth == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateMonthlyTemplateComponent.dayOfMonth");
            else if (Configuration.doAutoCreate())
              this.dayOfMonth = new PositiveIntType(); // bb
          return this.dayOfMonth;
        }

        public boolean hasDayOfMonthElement() { 
          return this.dayOfMonth != null && !this.dayOfMonth.isEmpty();
        }

        public boolean hasDayOfMonth() { 
          return this.dayOfMonth != null && !this.dayOfMonth.isEmpty();
        }

        /**
         * @param value {@link #dayOfMonth} (Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.). This is the underlying object with id, value and extensions. The accessor "getDayOfMonth" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setDayOfMonthElement(PositiveIntType value) { 
          this.dayOfMonth = value;
          return this;
        }

        /**
         * @return Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.
         */
        public int getDayOfMonth() { 
          return this.dayOfMonth == null || this.dayOfMonth.isEmpty() ? 0 : this.dayOfMonth.getValue();
        }

        /**
         * @param value Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setDayOfMonth(int value) { 
            if (this.dayOfMonth == null)
              this.dayOfMonth = new PositiveIntType();
            this.dayOfMonth.setValue(value);
          return this;
        }

        /**
         * @return {@link #nthWeekOfMonth} (Indicates which week within a month the appointments in the series of recurring appointments should occur on.)
         */
        public Coding getNthWeekOfMonth() { 
          if (this.nthWeekOfMonth == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateMonthlyTemplateComponent.nthWeekOfMonth");
            else if (Configuration.doAutoCreate())
              this.nthWeekOfMonth = new Coding(); // cc
          return this.nthWeekOfMonth;
        }

        public boolean hasNthWeekOfMonth() { 
          return this.nthWeekOfMonth != null && !this.nthWeekOfMonth.isEmpty();
        }

        /**
         * @param value {@link #nthWeekOfMonth} (Indicates which week within a month the appointments in the series of recurring appointments should occur on.)
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setNthWeekOfMonth(Coding value) { 
          this.nthWeekOfMonth = value;
          return this;
        }

        /**
         * @return {@link #dayOfWeek} (Indicates which day of the week the recurring appointments should occur each nth week.)
         */
        public Coding getDayOfWeek() { 
          if (this.dayOfWeek == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateMonthlyTemplateComponent.dayOfWeek");
            else if (Configuration.doAutoCreate())
              this.dayOfWeek = new Coding(); // cc
          return this.dayOfWeek;
        }

        public boolean hasDayOfWeek() { 
          return this.dayOfWeek != null && !this.dayOfWeek.isEmpty();
        }

        /**
         * @param value {@link #dayOfWeek} (Indicates which day of the week the recurring appointments should occur each nth week.)
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setDayOfWeek(Coding value) { 
          this.dayOfWeek = value;
          return this;
        }

        /**
         * @return {@link #monthInterval} (Indicates that recurring appointments should occur every nth month.). This is the underlying object with id, value and extensions. The accessor "getMonthInterval" gives direct access to the value
         */
        public PositiveIntType getMonthIntervalElement() { 
          if (this.monthInterval == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateMonthlyTemplateComponent.monthInterval");
            else if (Configuration.doAutoCreate())
              this.monthInterval = new PositiveIntType(); // bb
          return this.monthInterval;
        }

        public boolean hasMonthIntervalElement() { 
          return this.monthInterval != null && !this.monthInterval.isEmpty();
        }

        public boolean hasMonthInterval() { 
          return this.monthInterval != null && !this.monthInterval.isEmpty();
        }

        /**
         * @param value {@link #monthInterval} (Indicates that recurring appointments should occur every nth month.). This is the underlying object with id, value and extensions. The accessor "getMonthInterval" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setMonthIntervalElement(PositiveIntType value) { 
          this.monthInterval = value;
          return this;
        }

        /**
         * @return Indicates that recurring appointments should occur every nth month.
         */
        public int getMonthInterval() { 
          return this.monthInterval == null || this.monthInterval.isEmpty() ? 0 : this.monthInterval.getValue();
        }

        /**
         * @param value Indicates that recurring appointments should occur every nth month.
         */
        public AppointmentRecurrenceTemplateMonthlyTemplateComponent setMonthInterval(int value) { 
            if (this.monthInterval == null)
              this.monthInterval = new PositiveIntType();
            this.monthInterval.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("dayOfMonth", "positiveInt", "Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.", 0, 1, dayOfMonth));
          children.add(new Property("nthWeekOfMonth", "Coding", "Indicates which week within a month the appointments in the series of recurring appointments should occur on.", 0, 1, nthWeekOfMonth));
          children.add(new Property("dayOfWeek", "Coding", "Indicates which day of the week the recurring appointments should occur each nth week.", 0, 1, dayOfWeek));
          children.add(new Property("monthInterval", "positiveInt", "Indicates that recurring appointments should occur every nth month.", 0, 1, monthInterval));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1181204563: /*dayOfMonth*/  return new Property("dayOfMonth", "positiveInt", "Indicates that appointments in the series of recurring appointments should occur on a specific day of the month.", 0, 1, dayOfMonth);
          case 724728723: /*nthWeekOfMonth*/  return new Property("nthWeekOfMonth", "Coding", "Indicates which week within a month the appointments in the series of recurring appointments should occur on.", 0, 1, nthWeekOfMonth);
          case -730552025: /*dayOfWeek*/  return new Property("dayOfWeek", "Coding", "Indicates which day of the week the recurring appointments should occur each nth week.", 0, 1, dayOfWeek);
          case -251401371: /*monthInterval*/  return new Property("monthInterval", "positiveInt", "Indicates that recurring appointments should occur every nth month.", 0, 1, monthInterval);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1181204563: /*dayOfMonth*/ return this.dayOfMonth == null ? new Base[0] : new Base[] {this.dayOfMonth}; // PositiveIntType
        case 724728723: /*nthWeekOfMonth*/ return this.nthWeekOfMonth == null ? new Base[0] : new Base[] {this.nthWeekOfMonth}; // Coding
        case -730552025: /*dayOfWeek*/ return this.dayOfWeek == null ? new Base[0] : new Base[] {this.dayOfWeek}; // Coding
        case -251401371: /*monthInterval*/ return this.monthInterval == null ? new Base[0] : new Base[] {this.monthInterval}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1181204563: // dayOfMonth
          this.dayOfMonth = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 724728723: // nthWeekOfMonth
          this.nthWeekOfMonth = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -730552025: // dayOfWeek
          this.dayOfWeek = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -251401371: // monthInterval
          this.monthInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("dayOfMonth")) {
          this.dayOfMonth = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("nthWeekOfMonth")) {
          this.nthWeekOfMonth = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("dayOfWeek")) {
          this.dayOfWeek = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("monthInterval")) {
          this.monthInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1181204563:  return getDayOfMonthElement();
        case 724728723:  return getNthWeekOfMonth();
        case -730552025:  return getDayOfWeek();
        case -251401371:  return getMonthIntervalElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1181204563: /*dayOfMonth*/ return new String[] {"positiveInt"};
        case 724728723: /*nthWeekOfMonth*/ return new String[] {"Coding"};
        case -730552025: /*dayOfWeek*/ return new String[] {"Coding"};
        case -251401371: /*monthInterval*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("dayOfMonth")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.monthlyTemplate.dayOfMonth");
        }
        else if (name.equals("nthWeekOfMonth")) {
          this.nthWeekOfMonth = new Coding();
          return this.nthWeekOfMonth;
        }
        else if (name.equals("dayOfWeek")) {
          this.dayOfWeek = new Coding();
          return this.dayOfWeek;
        }
        else if (name.equals("monthInterval")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.monthlyTemplate.monthInterval");
        }
        else
          return super.addChild(name);
      }

      public AppointmentRecurrenceTemplateMonthlyTemplateComponent copy() {
        AppointmentRecurrenceTemplateMonthlyTemplateComponent dst = new AppointmentRecurrenceTemplateMonthlyTemplateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentRecurrenceTemplateMonthlyTemplateComponent dst) {
        super.copyValues(dst);
        dst.dayOfMonth = dayOfMonth == null ? null : dayOfMonth.copy();
        dst.nthWeekOfMonth = nthWeekOfMonth == null ? null : nthWeekOfMonth.copy();
        dst.dayOfWeek = dayOfWeek == null ? null : dayOfWeek.copy();
        dst.monthInterval = monthInterval == null ? null : monthInterval.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateMonthlyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateMonthlyTemplateComponent o = (AppointmentRecurrenceTemplateMonthlyTemplateComponent) other_;
        return compareDeep(dayOfMonth, o.dayOfMonth, true) && compareDeep(nthWeekOfMonth, o.nthWeekOfMonth, true)
           && compareDeep(dayOfWeek, o.dayOfWeek, true) && compareDeep(monthInterval, o.monthInterval, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateMonthlyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateMonthlyTemplateComponent o = (AppointmentRecurrenceTemplateMonthlyTemplateComponent) other_;
        return compareValues(dayOfMonth, o.dayOfMonth, true) && compareValues(monthInterval, o.monthInterval, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(dayOfMonth, nthWeekOfMonth
          , dayOfWeek, monthInterval);
      }

  public String fhirType() {
    return "Appointment.recurrenceTemplate.monthlyTemplate";

  }

  }

    @Block()
    public static class AppointmentRecurrenceTemplateYearlyTemplateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Appointment recurs every nth year.
         */
        @Child(name = "yearInterval", type = {PositiveIntType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recurs every nth year", formalDefinition="Appointment recurs every nth year." )
        protected PositiveIntType yearInterval;

        private static final long serialVersionUID = -120794476L;

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateYearlyTemplateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AppointmentRecurrenceTemplateYearlyTemplateComponent(int yearInterval) {
        super();
        this.setYearInterval(yearInterval);
      }

        /**
         * @return {@link #yearInterval} (Appointment recurs every nth year.). This is the underlying object with id, value and extensions. The accessor "getYearInterval" gives direct access to the value
         */
        public PositiveIntType getYearIntervalElement() { 
          if (this.yearInterval == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AppointmentRecurrenceTemplateYearlyTemplateComponent.yearInterval");
            else if (Configuration.doAutoCreate())
              this.yearInterval = new PositiveIntType(); // bb
          return this.yearInterval;
        }

        public boolean hasYearIntervalElement() { 
          return this.yearInterval != null && !this.yearInterval.isEmpty();
        }

        public boolean hasYearInterval() { 
          return this.yearInterval != null && !this.yearInterval.isEmpty();
        }

        /**
         * @param value {@link #yearInterval} (Appointment recurs every nth year.). This is the underlying object with id, value and extensions. The accessor "getYearInterval" gives direct access to the value
         */
        public AppointmentRecurrenceTemplateYearlyTemplateComponent setYearIntervalElement(PositiveIntType value) { 
          this.yearInterval = value;
          return this;
        }

        /**
         * @return Appointment recurs every nth year.
         */
        public int getYearInterval() { 
          return this.yearInterval == null || this.yearInterval.isEmpty() ? 0 : this.yearInterval.getValue();
        }

        /**
         * @param value Appointment recurs every nth year.
         */
        public AppointmentRecurrenceTemplateYearlyTemplateComponent setYearInterval(int value) { 
            if (this.yearInterval == null)
              this.yearInterval = new PositiveIntType();
            this.yearInterval.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("yearInterval", "positiveInt", "Appointment recurs every nth year.", 0, 1, yearInterval));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 492389410: /*yearInterval*/  return new Property("yearInterval", "positiveInt", "Appointment recurs every nth year.", 0, 1, yearInterval);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 492389410: /*yearInterval*/ return this.yearInterval == null ? new Base[0] : new Base[] {this.yearInterval}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 492389410: // yearInterval
          this.yearInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("yearInterval")) {
          this.yearInterval = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 492389410:  return getYearIntervalElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 492389410: /*yearInterval*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("yearInterval")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceTemplate.yearlyTemplate.yearInterval");
        }
        else
          return super.addChild(name);
      }

      public AppointmentRecurrenceTemplateYearlyTemplateComponent copy() {
        AppointmentRecurrenceTemplateYearlyTemplateComponent dst = new AppointmentRecurrenceTemplateYearlyTemplateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentRecurrenceTemplateYearlyTemplateComponent dst) {
        super.copyValues(dst);
        dst.yearInterval = yearInterval == null ? null : yearInterval.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateYearlyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateYearlyTemplateComponent o = (AppointmentRecurrenceTemplateYearlyTemplateComponent) other_;
        return compareDeep(yearInterval, o.yearInterval, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentRecurrenceTemplateYearlyTemplateComponent))
          return false;
        AppointmentRecurrenceTemplateYearlyTemplateComponent o = (AppointmentRecurrenceTemplateYearlyTemplateComponent) other_;
        return compareValues(yearInterval, o.yearInterval, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(yearInterval);
      }

  public String fhirType() {
    return "Appointment.recurrenceTemplate.yearlyTemplate";

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
     * Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.
     */
    @Child(name = "class", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classification when becoming an encounter", formalDefinition="Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/EncounterClass")
    protected List<CodeableConcept> class_;

    /**
     * A broad categorization of the service that is to be performed during this appointment.
     */
    @Child(name = "serviceCategory", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A broad categorization of the service that is to be performed during this appointment", formalDefinition="A broad categorization of the service that is to be performed during this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-category")
    protected List<CodeableConcept> serviceCategory;

    /**
     * The specific service that is to be performed during this appointment.
     */
    @Child(name = "serviceType", type = {CodeableReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The specific service that is to be performed during this appointment", formalDefinition="The specific service that is to be performed during this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-type")
    protected List<CodeableReference> serviceType;

    /**
     * The specialty of a practitioner that would be required to perform the service requested in this appointment.
     */
    @Child(name = "specialty", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The specialty of a practitioner that would be required to perform the service requested in this appointment", formalDefinition="The specialty of a practitioner that would be required to perform the service requested in this appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected List<CodeableConcept> specialty;

    /**
     * The style of appointment or patient that has been booked in the slot (not service type).
     */
    @Child(name = "appointmentType", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The style of appointment or patient that has been booked in the slot (not service type)", formalDefinition="The style of appointment or patient that has been booked in the slot (not service type)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0276")
    protected CodeableConcept appointmentType;

    /**
     * The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Reason this appointment is scheduled", formalDefinition="The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-reason")
    protected List<CodeableReference> reason;

    /**
     * The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).
     */
    @Child(name = "priority", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Used to make informed decisions if needing to re-prioritize", formalDefinition="The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActPriority")
    protected CodeableConcept priority;

    /**
     * The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.
     */
    @Child(name = "description", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Shown on a subject line in a meeting request, or appointment list", formalDefinition="The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field." )
    protected StringType description;

    /**
     * Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).
     */
    @Child(name = "replaces", type = {Appointment.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Appointment replaced by this Appointment", formalDefinition="Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource)." )
    protected List<Reference> replaces;

    /**
     * Connection details of a virtual service (e.g. conference call).
     */
    @Child(name = "virtualService", type = {VirtualServiceDetail.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Connection details of a virtual service (e.g. conference call)", formalDefinition="Connection details of a virtual service (e.g. conference call)." )
    protected List<VirtualServiceDetail> virtualService;

    /**
     * Additional information to support the appointment provided when making the appointment.
     */
    @Child(name = "supportingInformation", type = {Reference.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional information to support the appointment", formalDefinition="Additional information to support the appointment provided when making the appointment." )
    protected List<Reference> supportingInformation;

    /**
     * The previous appointment in a series of related appointments.
     */
    @Child(name = "previousAppointment", type = {Appointment.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The previous appointment in a series", formalDefinition="The previous appointment in a series of related appointments." )
    protected Reference previousAppointment;

    /**
     * The originating appointment in a recurring set of related appointments.
     */
    @Child(name = "originatingAppointment", type = {Appointment.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The originating appointment in a recurring set of appointments", formalDefinition="The originating appointment in a recurring set of related appointments." )
    protected Reference originatingAppointment;

    /**
     * Date/Time that the appointment is to take place.
     */
    @Child(name = "start", type = {InstantType.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When appointment is to take place", formalDefinition="Date/Time that the appointment is to take place." )
    protected InstantType start;

    /**
     * Date/Time that the appointment is to conclude.
     */
    @Child(name = "end", type = {InstantType.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When appointment is to conclude", formalDefinition="Date/Time that the appointment is to conclude." )
    protected InstantType end;

    /**
     * Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.
     */
    @Child(name = "minutesDuration", type = {PositiveIntType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Can be less than start/end (e.g. estimate)", formalDefinition="Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end." )
    protected PositiveIntType minutesDuration;

    /**
     * A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.

The duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.
     */
    @Child(name = "requestedPeriod", type = {Period.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Potential date/time interval(s) requested to allocate the appointment within", formalDefinition="A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system." )
    protected List<Period> requestedPeriod;

    /**
     * The slots from the participants' schedules that will be filled by the appointment.
     */
    @Child(name = "slot", type = {Slot.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The slots that this appointment is filling", formalDefinition="The slots from the participants' schedules that will be filled by the appointment." )
    protected List<Reference> slot;

    /**
     * The set of accounts that is expected to be used for billing the activities that result from this Appointment.
     */
    @Child(name = "account", type = {Account.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The set of accounts that may be used for billing for this Appointment", formalDefinition="The set of accounts that is expected to be used for billing the activities that result from this Appointment." )
    protected List<Reference> account;

    /**
     * The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The date that this appointment was initially created", formalDefinition="The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment." )
    protected DateTimeType created;

    /**
     * The date/time describing when the appointment was cancelled.
     */
    @Child(name = "cancellationDate", type = {DateTimeType.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the appointment was cancelled", formalDefinition="The date/time describing when the appointment was cancelled." )
    protected DateTimeType cancellationDate;

    /**
     * Additional notes/comments about the appointment.
     */
    @Child(name = "note", type = {Annotation.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional comments", formalDefinition="Additional notes/comments about the appointment." )
    protected List<Annotation> note;

    /**
     * While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).
     */
    @Child(name = "patientInstruction", type = {CodeableReference.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Detailed information and instructions for the patient", formalDefinition="While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before)." )
    protected List<CodeableReference> patientInstruction;

    /**
     * The request this appointment is allocated to assess (e.g. incoming referral or procedure request).
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, MedicationRequest.class, ServiceRequest.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The request this appointment is allocated to assess", formalDefinition="The request this appointment is allocated to assess (e.g. incoming referral or procedure request)." )
    protected List<Reference> basedOn;

    /**
     * The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=27, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient or group associated with the appointment", formalDefinition="The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element." )
    protected Reference subject;

    /**
     * List of participants involved in the appointment.
     */
    @Child(name = "participant", type = {}, order=28, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Participants involved in appointment", formalDefinition="List of participants involved in the appointment." )
    protected List<AppointmentParticipantComponent> participant;

    /**
     * The sequence number that identifies a specific appointment in a recurring pattern.
     */
    @Child(name = "recurrenceId", type = {PositiveIntType.class}, order=29, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The sequence number in the recurrence", formalDefinition="The sequence number that identifies a specific appointment in a recurring pattern." )
    protected PositiveIntType recurrenceId;

    /**
     * This appointment varies from the recurring pattern.
     */
    @Child(name = "occurrenceChanged", type = {BooleanType.class}, order=30, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates that this appointment varies from a recurrence pattern", formalDefinition="This appointment varies from the recurring pattern." )
    protected BooleanType occurrenceChanged;

    /**
     * The details of the recurrence pattern or template that is used to generate recurring appointments.
     */
    @Child(name = "recurrenceTemplate", type = {}, order=31, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details of the recurrence pattern/template used to generate occurrences", formalDefinition="The details of the recurrence pattern or template that is used to generate recurring appointments." )
    protected List<AppointmentRecurrenceTemplateComponent> recurrenceTemplate;

    private static final long serialVersionUID = 883088259L;

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
    public Appointment setClass_(List<CodeableConcept> theClass_) { 
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

    public Appointment addClass_(CodeableConcept t) { //3
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
     * @return {@link #description} (The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
     * @param value {@link #description} (The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Appointment setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.
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
    public Appointment setVirtualService(List<VirtualServiceDetail> theVirtualService) { 
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

    public Appointment addVirtualService(VirtualServiceDetail t) { //3
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
     * @return {@link #previousAppointment} (The previous appointment in a series of related appointments.)
     */
    public Reference getPreviousAppointment() { 
      if (this.previousAppointment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.previousAppointment");
        else if (Configuration.doAutoCreate())
          this.previousAppointment = new Reference(); // cc
      return this.previousAppointment;
    }

    public boolean hasPreviousAppointment() { 
      return this.previousAppointment != null && !this.previousAppointment.isEmpty();
    }

    /**
     * @param value {@link #previousAppointment} (The previous appointment in a series of related appointments.)
     */
    public Appointment setPreviousAppointment(Reference value) { 
      this.previousAppointment = value;
      return this;
    }

    /**
     * @return {@link #originatingAppointment} (The originating appointment in a recurring set of related appointments.)
     */
    public Reference getOriginatingAppointment() { 
      if (this.originatingAppointment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.originatingAppointment");
        else if (Configuration.doAutoCreate())
          this.originatingAppointment = new Reference(); // cc
      return this.originatingAppointment;
    }

    public boolean hasOriginatingAppointment() { 
      return this.originatingAppointment != null && !this.originatingAppointment.isEmpty();
    }

    /**
     * @param value {@link #originatingAppointment} (The originating appointment in a recurring set of related appointments.)
     */
    public Appointment setOriginatingAppointment(Reference value) { 
      this.originatingAppointment = value;
      return this;
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
     * @return {@link #cancellationDate} (The date/time describing when the appointment was cancelled.). This is the underlying object with id, value and extensions. The accessor "getCancellationDate" gives direct access to the value
     */
    public DateTimeType getCancellationDateElement() { 
      if (this.cancellationDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.cancellationDate");
        else if (Configuration.doAutoCreate())
          this.cancellationDate = new DateTimeType(); // bb
      return this.cancellationDate;
    }

    public boolean hasCancellationDateElement() { 
      return this.cancellationDate != null && !this.cancellationDate.isEmpty();
    }

    public boolean hasCancellationDate() { 
      return this.cancellationDate != null && !this.cancellationDate.isEmpty();
    }

    /**
     * @param value {@link #cancellationDate} (The date/time describing when the appointment was cancelled.). This is the underlying object with id, value and extensions. The accessor "getCancellationDate" gives direct access to the value
     */
    public Appointment setCancellationDateElement(DateTimeType value) { 
      this.cancellationDate = value;
      return this;
    }

    /**
     * @return The date/time describing when the appointment was cancelled.
     */
    public Date getCancellationDate() { 
      return this.cancellationDate == null ? null : this.cancellationDate.getValue();
    }

    /**
     * @param value The date/time describing when the appointment was cancelled.
     */
    public Appointment setCancellationDate(Date value) { 
      if (value == null)
        this.cancellationDate = null;
      else {
        if (this.cancellationDate == null)
          this.cancellationDate = new DateTimeType();
        this.cancellationDate.setValue(value);
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
     * @return {@link #recurrenceId} (The sequence number that identifies a specific appointment in a recurring pattern.). This is the underlying object with id, value and extensions. The accessor "getRecurrenceId" gives direct access to the value
     */
    public PositiveIntType getRecurrenceIdElement() { 
      if (this.recurrenceId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.recurrenceId");
        else if (Configuration.doAutoCreate())
          this.recurrenceId = new PositiveIntType(); // bb
      return this.recurrenceId;
    }

    public boolean hasRecurrenceIdElement() { 
      return this.recurrenceId != null && !this.recurrenceId.isEmpty();
    }

    public boolean hasRecurrenceId() { 
      return this.recurrenceId != null && !this.recurrenceId.isEmpty();
    }

    /**
     * @param value {@link #recurrenceId} (The sequence number that identifies a specific appointment in a recurring pattern.). This is the underlying object with id, value and extensions. The accessor "getRecurrenceId" gives direct access to the value
     */
    public Appointment setRecurrenceIdElement(PositiveIntType value) { 
      this.recurrenceId = value;
      return this;
    }

    /**
     * @return The sequence number that identifies a specific appointment in a recurring pattern.
     */
    public int getRecurrenceId() { 
      return this.recurrenceId == null || this.recurrenceId.isEmpty() ? 0 : this.recurrenceId.getValue();
    }

    /**
     * @param value The sequence number that identifies a specific appointment in a recurring pattern.
     */
    public Appointment setRecurrenceId(int value) { 
        if (this.recurrenceId == null)
          this.recurrenceId = new PositiveIntType();
        this.recurrenceId.setValue(value);
      return this;
    }

    /**
     * @return {@link #occurrenceChanged} (This appointment varies from the recurring pattern.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceChanged" gives direct access to the value
     */
    public BooleanType getOccurrenceChangedElement() { 
      if (this.occurrenceChanged == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Appointment.occurrenceChanged");
        else if (Configuration.doAutoCreate())
          this.occurrenceChanged = new BooleanType(); // bb
      return this.occurrenceChanged;
    }

    public boolean hasOccurrenceChangedElement() { 
      return this.occurrenceChanged != null && !this.occurrenceChanged.isEmpty();
    }

    public boolean hasOccurrenceChanged() { 
      return this.occurrenceChanged != null && !this.occurrenceChanged.isEmpty();
    }

    /**
     * @param value {@link #occurrenceChanged} (This appointment varies from the recurring pattern.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceChanged" gives direct access to the value
     */
    public Appointment setOccurrenceChangedElement(BooleanType value) { 
      this.occurrenceChanged = value;
      return this;
    }

    /**
     * @return This appointment varies from the recurring pattern.
     */
    public boolean getOccurrenceChanged() { 
      return this.occurrenceChanged == null || this.occurrenceChanged.isEmpty() ? false : this.occurrenceChanged.getValue();
    }

    /**
     * @param value This appointment varies from the recurring pattern.
     */
    public Appointment setOccurrenceChanged(boolean value) { 
        if (this.occurrenceChanged == null)
          this.occurrenceChanged = new BooleanType();
        this.occurrenceChanged.setValue(value);
      return this;
    }

    /**
     * @return {@link #recurrenceTemplate} (The details of the recurrence pattern or template that is used to generate recurring appointments.)
     */
    public List<AppointmentRecurrenceTemplateComponent> getRecurrenceTemplate() { 
      if (this.recurrenceTemplate == null)
        this.recurrenceTemplate = new ArrayList<AppointmentRecurrenceTemplateComponent>();
      return this.recurrenceTemplate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Appointment setRecurrenceTemplate(List<AppointmentRecurrenceTemplateComponent> theRecurrenceTemplate) { 
      this.recurrenceTemplate = theRecurrenceTemplate;
      return this;
    }

    public boolean hasRecurrenceTemplate() { 
      if (this.recurrenceTemplate == null)
        return false;
      for (AppointmentRecurrenceTemplateComponent item : this.recurrenceTemplate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AppointmentRecurrenceTemplateComponent addRecurrenceTemplate() { //3
      AppointmentRecurrenceTemplateComponent t = new AppointmentRecurrenceTemplateComponent();
      if (this.recurrenceTemplate == null)
        this.recurrenceTemplate = new ArrayList<AppointmentRecurrenceTemplateComponent>();
      this.recurrenceTemplate.add(t);
      return t;
    }

    public Appointment addRecurrenceTemplate(AppointmentRecurrenceTemplateComponent t) { //3
      if (t == null)
        return this;
      if (this.recurrenceTemplate == null)
        this.recurrenceTemplate = new ArrayList<AppointmentRecurrenceTemplateComponent>();
      this.recurrenceTemplate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #recurrenceTemplate}, creating it if it does not already exist {3}
     */
    public AppointmentRecurrenceTemplateComponent getRecurrenceTemplateFirstRep() { 
      if (getRecurrenceTemplate().isEmpty()) {
        addRecurrenceTemplate();
      }
      return getRecurrenceTemplate().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.", 0, 1, status));
        children.add(new Property("cancellationReason", "CodeableConcept", "The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.", 0, 1, cancellationReason));
        children.add(new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, java.lang.Integer.MAX_VALUE, class_));
        children.add(new Property("serviceCategory", "CodeableConcept", "A broad categorization of the service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceCategory));
        children.add(new Property("serviceType", "CodeableReference(HealthcareService)", "The specific service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceType));
        children.add(new Property("specialty", "CodeableConcept", "The specialty of a practitioner that would be required to perform the service requested in this appointment.", 0, java.lang.Integer.MAX_VALUE, specialty));
        children.add(new Property("appointmentType", "CodeableConcept", "The style of appointment or patient that has been booked in the slot (not service type).", 0, 1, appointmentType));
        children.add(new Property("reason", "CodeableReference(Condition|Procedure|Observation|ImmunizationRecommendation)", "The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("priority", "CodeableConcept", "The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).", 0, 1, priority));
        children.add(new Property("description", "string", "The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.", 0, 1, description));
        children.add(new Property("replaces", "Reference(Appointment)", "Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. conference call).", 0, java.lang.Integer.MAX_VALUE, virtualService));
        children.add(new Property("supportingInformation", "Reference(Any)", "Additional information to support the appointment provided when making the appointment.", 0, java.lang.Integer.MAX_VALUE, supportingInformation));
        children.add(new Property("previousAppointment", "Reference(Appointment)", "The previous appointment in a series of related appointments.", 0, 1, previousAppointment));
        children.add(new Property("originatingAppointment", "Reference(Appointment)", "The originating appointment in a recurring set of related appointments.", 0, 1, originatingAppointment));
        children.add(new Property("start", "instant", "Date/Time that the appointment is to take place.", 0, 1, start));
        children.add(new Property("end", "instant", "Date/Time that the appointment is to conclude.", 0, 1, end));
        children.add(new Property("minutesDuration", "positiveInt", "Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.", 0, 1, minutesDuration));
        children.add(new Property("requestedPeriod", "Period", "A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.", 0, java.lang.Integer.MAX_VALUE, requestedPeriod));
        children.add(new Property("slot", "Reference(Slot)", "The slots from the participants' schedules that will be filled by the appointment.", 0, java.lang.Integer.MAX_VALUE, slot));
        children.add(new Property("account", "Reference(Account)", "The set of accounts that is expected to be used for billing the activities that result from this Appointment.", 0, java.lang.Integer.MAX_VALUE, account));
        children.add(new Property("created", "dateTime", "The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.", 0, 1, created));
        children.add(new Property("cancellationDate", "dateTime", "The date/time describing when the appointment was cancelled.", 0, 1, cancellationDate));
        children.add(new Property("note", "Annotation", "Additional notes/comments about the appointment.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("patientInstruction", "CodeableReference(DocumentReference|Binary|Communication)", "While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).", 0, java.lang.Integer.MAX_VALUE, patientInstruction));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this appointment is allocated to assess (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.", 0, 1, subject));
        children.add(new Property("participant", "", "List of participants involved in the appointment.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("recurrenceId", "positiveInt", "The sequence number that identifies a specific appointment in a recurring pattern.", 0, 1, recurrenceId));
        children.add(new Property("occurrenceChanged", "boolean", "This appointment varies from the recurring pattern.", 0, 1, occurrenceChanged));
        children.add(new Property("recurrenceTemplate", "", "The details of the recurrence pattern or template that is used to generate recurring appointments.", 0, java.lang.Integer.MAX_VALUE, recurrenceTemplate));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "This records identifiers associated with this appointment concern that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The overall status of the Appointment. Each of the participants has their own participation status which indicates their involvement in the process, however this status indicates the shared status.", 0, 1, status);
        case 2135095591: /*cancellationReason*/  return new Property("cancellationReason", "CodeableConcept", "The coded reason for the appointment being cancelled. This is often used in reporting/billing/futher processing to determine if further actions are required, or specific fees apply.", 0, 1, cancellationReason);
        case 94742904: /*class*/  return new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, java.lang.Integer.MAX_VALUE, class_);
        case 1281188563: /*serviceCategory*/  return new Property("serviceCategory", "CodeableConcept", "A broad categorization of the service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceCategory);
        case -1928370289: /*serviceType*/  return new Property("serviceType", "CodeableReference(HealthcareService)", "The specific service that is to be performed during this appointment.", 0, java.lang.Integer.MAX_VALUE, serviceType);
        case -1694759682: /*specialty*/  return new Property("specialty", "CodeableConcept", "The specialty of a practitioner that would be required to perform the service requested in this appointment.", 0, java.lang.Integer.MAX_VALUE, specialty);
        case -1596426375: /*appointmentType*/  return new Property("appointmentType", "CodeableConcept", "The style of appointment or patient that has been booked in the slot (not service type).", 0, 1, appointmentType);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Procedure|Observation|ImmunizationRecommendation)", "The reason that this appointment is being scheduled. This is more clinical than administrative. This can be coded, or as specified using information from another resource. When the patient arrives and the encounter begins it may be used as the admission diagnosis. The indication will typically be a Condition (with other resources referenced in the evidence.detail), or a Procedure.", 0, java.lang.Integer.MAX_VALUE, reason);
        case -1165461084: /*priority*/  return new Property("priority", "CodeableConcept", "The priority of the appointment. Can be used to make informed decisions if needing to re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as lowest priority).", 0, 1, priority);
        case -1724546052: /*description*/  return new Property("description", "string", "The brief description of the appointment as would be shown on a subject line in a meeting request, or appointment list. Detailed or expanded information should be put in the note field.", 0, 1, description);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(Appointment)", "Appointment replaced by this Appointment in cases where there is a cancellation, the details of the cancellation can be found in the cancellationReason property (on the referenced resource).", 0, java.lang.Integer.MAX_VALUE, replaces);
        case 1420774698: /*virtualService*/  return new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. conference call).", 0, java.lang.Integer.MAX_VALUE, virtualService);
        case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "Reference(Any)", "Additional information to support the appointment provided when making the appointment.", 0, java.lang.Integer.MAX_VALUE, supportingInformation);
        case -1676044248: /*previousAppointment*/  return new Property("previousAppointment", "Reference(Appointment)", "The previous appointment in a series of related appointments.", 0, 1, previousAppointment);
        case 1841882230: /*originatingAppointment*/  return new Property("originatingAppointment", "Reference(Appointment)", "The originating appointment in a recurring set of related appointments.", 0, 1, originatingAppointment);
        case 109757538: /*start*/  return new Property("start", "instant", "Date/Time that the appointment is to take place.", 0, 1, start);
        case 100571: /*end*/  return new Property("end", "instant", "Date/Time that the appointment is to conclude.", 0, 1, end);
        case -413630573: /*minutesDuration*/  return new Property("minutesDuration", "positiveInt", "Number of minutes that the appointment is to take. This can be less than the duration between the start and end times.  For example, where the actual time of appointment is only an estimate or if a 30 minute appointment is being requested, but any time would work.  Also, if there is, for example, a planned 15 minute break in the middle of a long appointment, the duration may be 15 minutes less than the difference between the start and end.", 0, 1, minutesDuration);
        case -897241393: /*requestedPeriod*/  return new Property("requestedPeriod", "Period", "A set of date ranges (potentially including times) that the appointment is preferred to be scheduled within.\n\nThe duration (usually in minutes) could also be provided to indicate the length of the appointment to fill and populate the start/end times for the actual allocated time. However, in other situations the duration may be calculated by the scheduling system.", 0, java.lang.Integer.MAX_VALUE, requestedPeriod);
        case 3533310: /*slot*/  return new Property("slot", "Reference(Slot)", "The slots from the participants' schedules that will be filled by the appointment.", 0, java.lang.Integer.MAX_VALUE, slot);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "The set of accounts that is expected to be used for billing the activities that result from this Appointment.", 0, java.lang.Integer.MAX_VALUE, account);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date that this appointment was initially created. This could be different to the meta.lastModified value on the initial entry, as this could have been before the resource was created on the FHIR server, and should remain unchanged over the lifespan of the appointment.", 0, 1, created);
        case 806269777: /*cancellationDate*/  return new Property("cancellationDate", "dateTime", "The date/time describing when the appointment was cancelled.", 0, 1, cancellationDate);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Additional notes/comments about the appointment.", 0, java.lang.Integer.MAX_VALUE, note);
        case 737543241: /*patientInstruction*/  return new Property("patientInstruction", "CodeableReference(DocumentReference|Binary|Communication)", "While Appointment.note contains information for internal use, Appointment.patientInstructions is used to capture patient facing information about the Appointment (e.g. please bring your referral or fast from 8pm night before).", 0, java.lang.Integer.MAX_VALUE, patientInstruction);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|MedicationRequest|ServiceRequest)", "The request this appointment is allocated to assess (e.g. incoming referral or procedure request).", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group associated with the appointment, if they are to be present (usually) then they should also be included in the participant backbone element.", 0, 1, subject);
        case 767422259: /*participant*/  return new Property("participant", "", "List of participants involved in the appointment.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -362407829: /*recurrenceId*/  return new Property("recurrenceId", "positiveInt", "The sequence number that identifies a specific appointment in a recurring pattern.", 0, 1, recurrenceId);
        case 1779864483: /*occurrenceChanged*/  return new Property("occurrenceChanged", "boolean", "This appointment varies from the recurring pattern.", 0, 1, occurrenceChanged);
        case 597629898: /*recurrenceTemplate*/  return new Property("recurrenceTemplate", "", "The details of the recurrence pattern or template that is used to generate recurring appointments.", 0, java.lang.Integer.MAX_VALUE, recurrenceTemplate);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<AppointmentStatus>
        case 2135095591: /*cancellationReason*/ return this.cancellationReason == null ? new Base[0] : new Base[] {this.cancellationReason}; // CodeableConcept
        case 94742904: /*class*/ return this.class_ == null ? new Base[0] : this.class_.toArray(new Base[this.class_.size()]); // CodeableConcept
        case 1281188563: /*serviceCategory*/ return this.serviceCategory == null ? new Base[0] : this.serviceCategory.toArray(new Base[this.serviceCategory.size()]); // CodeableConcept
        case -1928370289: /*serviceType*/ return this.serviceType == null ? new Base[0] : this.serviceType.toArray(new Base[this.serviceType.size()]); // CodeableReference
        case -1694759682: /*specialty*/ return this.specialty == null ? new Base[0] : this.specialty.toArray(new Base[this.specialty.size()]); // CodeableConcept
        case -1596426375: /*appointmentType*/ return this.appointmentType == null ? new Base[0] : new Base[] {this.appointmentType}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -430332865: /*replaces*/ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
        case 1420774698: /*virtualService*/ return this.virtualService == null ? new Base[0] : this.virtualService.toArray(new Base[this.virtualService.size()]); // VirtualServiceDetail
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
        case -1676044248: /*previousAppointment*/ return this.previousAppointment == null ? new Base[0] : new Base[] {this.previousAppointment}; // Reference
        case 1841882230: /*originatingAppointment*/ return this.originatingAppointment == null ? new Base[0] : new Base[] {this.originatingAppointment}; // Reference
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // InstantType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case -413630573: /*minutesDuration*/ return this.minutesDuration == null ? new Base[0] : new Base[] {this.minutesDuration}; // PositiveIntType
        case -897241393: /*requestedPeriod*/ return this.requestedPeriod == null ? new Base[0] : this.requestedPeriod.toArray(new Base[this.requestedPeriod.size()]); // Period
        case 3533310: /*slot*/ return this.slot == null ? new Base[0] : this.slot.toArray(new Base[this.slot.size()]); // Reference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : this.account.toArray(new Base[this.account.size()]); // Reference
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case 806269777: /*cancellationDate*/ return this.cancellationDate == null ? new Base[0] : new Base[] {this.cancellationDate}; // DateTimeType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 737543241: /*patientInstruction*/ return this.patientInstruction == null ? new Base[0] : this.patientInstruction.toArray(new Base[this.patientInstruction.size()]); // CodeableReference
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // AppointmentParticipantComponent
        case -362407829: /*recurrenceId*/ return this.recurrenceId == null ? new Base[0] : new Base[] {this.recurrenceId}; // PositiveIntType
        case 1779864483: /*occurrenceChanged*/ return this.occurrenceChanged == null ? new Base[0] : new Base[] {this.occurrenceChanged}; // BooleanType
        case 597629898: /*recurrenceTemplate*/ return this.recurrenceTemplate == null ? new Base[0] : this.recurrenceTemplate.toArray(new Base[this.recurrenceTemplate.size()]); // AppointmentRecurrenceTemplateComponent
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
        case 94742904: // class
          this.getClass_().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        case 1420774698: // virtualService
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value)); // VirtualServiceDetail
          return value;
        case -1248768647: // supportingInformation
          this.getSupportingInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1676044248: // previousAppointment
          this.previousAppointment = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1841882230: // originatingAppointment
          this.originatingAppointment = TypeConvertor.castToReference(value); // Reference
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
        case -897241393: // requestedPeriod
          this.getRequestedPeriod().add(TypeConvertor.castToPeriod(value)); // Period
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
        case 806269777: // cancellationDate
          this.cancellationDate = TypeConvertor.castToDateTime(value); // DateTimeType
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
        case -362407829: // recurrenceId
          this.recurrenceId = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 1779864483: // occurrenceChanged
          this.occurrenceChanged = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 597629898: // recurrenceTemplate
          this.getRecurrenceTemplate().add((AppointmentRecurrenceTemplateComponent) value); // AppointmentRecurrenceTemplateComponent
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
        } else if (name.equals("class")) {
          this.getClass_().add(TypeConvertor.castToCodeableConcept(value));
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
        } else if (name.equals("virtualService")) {
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value));
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("previousAppointment")) {
          this.previousAppointment = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("originatingAppointment")) {
          this.originatingAppointment = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("start")) {
          this.start = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("minutesDuration")) {
          this.minutesDuration = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("requestedPeriod")) {
          this.getRequestedPeriod().add(TypeConvertor.castToPeriod(value));
        } else if (name.equals("slot")) {
          this.getSlot().add(TypeConvertor.castToReference(value));
        } else if (name.equals("account")) {
          this.getAccount().add(TypeConvertor.castToReference(value));
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("cancellationDate")) {
          this.cancellationDate = TypeConvertor.castToDateTime(value); // DateTimeType
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
        } else if (name.equals("recurrenceId")) {
          this.recurrenceId = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("occurrenceChanged")) {
          this.occurrenceChanged = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("recurrenceTemplate")) {
          this.getRecurrenceTemplate().add((AppointmentRecurrenceTemplateComponent) value);
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
        case 94742904:  return addClass_(); 
        case 1281188563:  return addServiceCategory(); 
        case -1928370289:  return addServiceType(); 
        case -1694759682:  return addSpecialty(); 
        case -1596426375:  return getAppointmentType();
        case -934964668:  return addReason(); 
        case -1165461084:  return getPriority();
        case -1724546052:  return getDescriptionElement();
        case -430332865:  return addReplaces(); 
        case 1420774698:  return addVirtualService(); 
        case -1248768647:  return addSupportingInformation(); 
        case -1676044248:  return getPreviousAppointment();
        case 1841882230:  return getOriginatingAppointment();
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case -413630573:  return getMinutesDurationElement();
        case -897241393:  return addRequestedPeriod(); 
        case 3533310:  return addSlot(); 
        case -1177318867:  return addAccount(); 
        case 1028554472:  return getCreatedElement();
        case 806269777:  return getCancellationDateElement();
        case 3387378:  return addNote(); 
        case 737543241:  return addPatientInstruction(); 
        case -332612366:  return addBasedOn(); 
        case -1867885268:  return getSubject();
        case 767422259:  return addParticipant(); 
        case -362407829:  return getRecurrenceIdElement();
        case 1779864483:  return getOccurrenceChangedElement();
        case 597629898:  return addRecurrenceTemplate(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2135095591: /*cancellationReason*/ return new String[] {"CodeableConcept"};
        case 94742904: /*class*/ return new String[] {"CodeableConcept"};
        case 1281188563: /*serviceCategory*/ return new String[] {"CodeableConcept"};
        case -1928370289: /*serviceType*/ return new String[] {"CodeableReference"};
        case -1694759682: /*specialty*/ return new String[] {"CodeableConcept"};
        case -1596426375: /*appointmentType*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case -1165461084: /*priority*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -430332865: /*replaces*/ return new String[] {"Reference"};
        case 1420774698: /*virtualService*/ return new String[] {"VirtualServiceDetail"};
        case -1248768647: /*supportingInformation*/ return new String[] {"Reference"};
        case -1676044248: /*previousAppointment*/ return new String[] {"Reference"};
        case 1841882230: /*originatingAppointment*/ return new String[] {"Reference"};
        case 109757538: /*start*/ return new String[] {"instant"};
        case 100571: /*end*/ return new String[] {"instant"};
        case -413630573: /*minutesDuration*/ return new String[] {"positiveInt"};
        case -897241393: /*requestedPeriod*/ return new String[] {"Period"};
        case 3533310: /*slot*/ return new String[] {"Reference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case 806269777: /*cancellationDate*/ return new String[] {"dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 737543241: /*patientInstruction*/ return new String[] {"CodeableReference"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 767422259: /*participant*/ return new String[] {};
        case -362407829: /*recurrenceId*/ return new String[] {"positiveInt"};
        case 1779864483: /*occurrenceChanged*/ return new String[] {"boolean"};
        case 597629898: /*recurrenceTemplate*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.status");
        }
        else if (name.equals("cancellationReason")) {
          this.cancellationReason = new CodeableConcept();
          return this.cancellationReason;
        }
        else if (name.equals("class")) {
          return addClass_();
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
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.description");
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("virtualService")) {
          return addVirtualService();
        }
        else if (name.equals("supportingInformation")) {
          return addSupportingInformation();
        }
        else if (name.equals("previousAppointment")) {
          this.previousAppointment = new Reference();
          return this.previousAppointment;
        }
        else if (name.equals("originatingAppointment")) {
          this.originatingAppointment = new Reference();
          return this.originatingAppointment;
        }
        else if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.end");
        }
        else if (name.equals("minutesDuration")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.minutesDuration");
        }
        else if (name.equals("requestedPeriod")) {
          return addRequestedPeriod();
        }
        else if (name.equals("slot")) {
          return addSlot();
        }
        else if (name.equals("account")) {
          return addAccount();
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.created");
        }
        else if (name.equals("cancellationDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.cancellationDate");
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
        else if (name.equals("recurrenceId")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.recurrenceId");
        }
        else if (name.equals("occurrenceChanged")) {
          throw new FHIRException("Cannot call addChild on a singleton property Appointment.occurrenceChanged");
        }
        else if (name.equals("recurrenceTemplate")) {
          return addRecurrenceTemplate();
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
        if (class_ != null) {
          dst.class_ = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : class_)
            dst.class_.add(i.copy());
        };
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
        if (virtualService != null) {
          dst.virtualService = new ArrayList<VirtualServiceDetail>();
          for (VirtualServiceDetail i : virtualService)
            dst.virtualService.add(i.copy());
        };
        if (supportingInformation != null) {
          dst.supportingInformation = new ArrayList<Reference>();
          for (Reference i : supportingInformation)
            dst.supportingInformation.add(i.copy());
        };
        dst.previousAppointment = previousAppointment == null ? null : previousAppointment.copy();
        dst.originatingAppointment = originatingAppointment == null ? null : originatingAppointment.copy();
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        dst.minutesDuration = minutesDuration == null ? null : minutesDuration.copy();
        if (requestedPeriod != null) {
          dst.requestedPeriod = new ArrayList<Period>();
          for (Period i : requestedPeriod)
            dst.requestedPeriod.add(i.copy());
        };
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
        dst.cancellationDate = cancellationDate == null ? null : cancellationDate.copy();
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
        dst.recurrenceId = recurrenceId == null ? null : recurrenceId.copy();
        dst.occurrenceChanged = occurrenceChanged == null ? null : occurrenceChanged.copy();
        if (recurrenceTemplate != null) {
          dst.recurrenceTemplate = new ArrayList<AppointmentRecurrenceTemplateComponent>();
          for (AppointmentRecurrenceTemplateComponent i : recurrenceTemplate)
            dst.recurrenceTemplate.add(i.copy());
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
           && compareDeep(class_, o.class_, true) && compareDeep(serviceCategory, o.serviceCategory, true)
           && compareDeep(serviceType, o.serviceType, true) && compareDeep(specialty, o.specialty, true) && compareDeep(appointmentType, o.appointmentType, true)
           && compareDeep(reason, o.reason, true) && compareDeep(priority, o.priority, true) && compareDeep(description, o.description, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(virtualService, o.virtualService, true)
           && compareDeep(supportingInformation, o.supportingInformation, true) && compareDeep(previousAppointment, o.previousAppointment, true)
           && compareDeep(originatingAppointment, o.originatingAppointment, true) && compareDeep(start, o.start, true)
           && compareDeep(end, o.end, true) && compareDeep(minutesDuration, o.minutesDuration, true) && compareDeep(requestedPeriod, o.requestedPeriod, true)
           && compareDeep(slot, o.slot, true) && compareDeep(account, o.account, true) && compareDeep(created, o.created, true)
           && compareDeep(cancellationDate, o.cancellationDate, true) && compareDeep(note, o.note, true) && compareDeep(patientInstruction, o.patientInstruction, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(subject, o.subject, true) && compareDeep(participant, o.participant, true)
           && compareDeep(recurrenceId, o.recurrenceId, true) && compareDeep(occurrenceChanged, o.occurrenceChanged, true)
           && compareDeep(recurrenceTemplate, o.recurrenceTemplate, true);
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
           && compareValues(cancellationDate, o.cancellationDate, true) && compareValues(recurrenceId, o.recurrenceId, true)
           && compareValues(occurrenceChanged, o.occurrenceChanged, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, cancellationReason
          , class_, serviceCategory, serviceType, specialty, appointmentType, reason, priority
          , description, replaces, virtualService, supportingInformation, previousAppointment
          , originatingAppointment, start, end, minutesDuration, requestedPeriod, slot, account
          , created, cancellationDate, note, patientInstruction, basedOn, subject, participant
          , recurrenceId, occurrenceChanged, recurrenceTemplate);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Appointment;
   }

 /**
   * Search parameter: <b>actor</b>
   * <p>
   * Description: <b>Any one of the individuals participating in the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="actor", path="Appointment.participant.actor", description="Any one of the individuals participating in the appointment", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_ACTOR = "actor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>actor</b>
   * <p>
   * Description: <b>Any one of the individuals participating in the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:actor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACTOR = new ca.uhn.fhir.model.api.Include("Appointment:actor").toLocked();

 /**
   * Search parameter: <b>appointment-type</b>
   * <p>
   * Description: <b>The style of appointment or patient that has been booked in the slot (not service type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.appointmentType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="appointment-type", path="Appointment.appointmentType", description="The style of appointment or patient that has been booked in the slot (not service type)", type="token" )
  public static final String SP_APPOINTMENT_TYPE = "appointment-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>appointment-type</b>
   * <p>
   * Description: <b>The style of appointment or patient that has been booked in the slot (not service type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.appointmentType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam APPOINTMENT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_APPOINTMENT_TYPE);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>The service request this appointment is allocated to assess</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="Appointment.basedOn", description="The service request this appointment is allocated to assess", type="reference", target={CarePlan.class, DeviceRequest.class, MedicationRequest.class, ServiceRequest.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>The service request this appointment is allocated to assess</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("Appointment:based-on").toLocked();

 /**
   * Search parameter: <b>group</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Group) | Appointment.subject.where(resolve() is Group)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group", path="Appointment.participant.actor.where(resolve() is Group) | Appointment.subject.where(resolve() is Group)", description="One of the individuals of the appointment is this patient", type="reference", target={Group.class } )
  public static final String SP_GROUP = "group";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Group) | Appointment.subject.where(resolve() is Group)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam GROUP = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_GROUP);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:group</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_GROUP = new ca.uhn.fhir.model.api.Include("Appointment:group").toLocked();

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>This location is listed in the participants of the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Location)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="Appointment.participant.actor.where(resolve() is Location)", description="This location is listed in the participants of the appointment", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>This location is listed in the participants of the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Location)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("Appointment:location").toLocked();

 /**
   * Search parameter: <b>part-status</b>
   * <p>
   * Description: <b>The Participation status of the subject, or other participant on the appointment. Can be used to locate participants that have not responded to meeting requests.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.participant.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-status", path="Appointment.participant.status", description="The Participation status of the subject, or other participant on the appointment. Can be used to locate participants that have not responded to meeting requests.", type="token" )
  public static final String SP_PART_STATUS = "part-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-status</b>
   * <p>
   * Description: <b>The Participation status of the subject, or other participant on the appointment. Can be used to locate participants that have not responded to meeting requests.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.participant.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PART_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PART_STATUS);

 /**
   * Search parameter: <b>practitioner</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="practitioner", path="Appointment.participant.actor.where(resolve() is Practitioner)", description="One of the individuals of the appointment is this practitioner", type="reference", target={Practitioner.class } )
  public static final String SP_PRACTITIONER = "practitioner";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>practitioner</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.participant.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRACTITIONER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRACTITIONER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:practitioner</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRACTITIONER = new ca.uhn.fhir.model.api.Include("Appointment:practitioner").toLocked();

 /**
   * Search parameter: <b>reason-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.reason.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason-code", path="Appointment.reason.concept", description="Reference to a concept (by class)", type="token" )
  public static final String SP_REASON_CODE = "reason-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.reason.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REASON_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REASON_CODE);

 /**
   * Search parameter: <b>reason-reference</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.reason.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason-reference", path="Appointment.reason.reference", description="Reference to a resource (by instance)", type="reference", target={Condition.class, ImmunizationRecommendation.class, Observation.class, Procedure.class } )
  public static final String SP_REASON_REFERENCE = "reason-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason-reference</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.reason.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REASON_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REASON_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:reason-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REASON_REFERENCE = new ca.uhn.fhir.model.api.Include("Appointment:reason-reference").toLocked();

 /**
   * Search parameter: <b>requested-period</b>
   * <p>
   * Description: <b>During what period was the Appointment requested to take place</b><br>
   * Type: <b>date</b><br>
   * Path: <b>requestedPeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requested-period", path="requestedPeriod", description="During what period was the Appointment requested to take place", type="date" )
  public static final String SP_REQUESTED_PERIOD = "requested-period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requested-period</b>
   * <p>
   * Description: <b>During what period was the Appointment requested to take place</b><br>
   * Type: <b>date</b><br>
   * Path: <b>requestedPeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam REQUESTED_PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_REQUESTED_PERIOD);

 /**
   * Search parameter: <b>service-category</b>
   * <p>
   * Description: <b>A broad categorization of the service that is to be performed during this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.serviceCategory</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-category", path="Appointment.serviceCategory", description="A broad categorization of the service that is to be performed during this appointment", type="token" )
  public static final String SP_SERVICE_CATEGORY = "service-category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-category</b>
   * <p>
   * Description: <b>A broad categorization of the service that is to be performed during this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.serviceCategory</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERVICE_CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERVICE_CATEGORY);

 /**
   * Search parameter: <b>service-type-reference</b>
   * <p>
   * Description: <b>The specific service (by HealthcareService) that is to be performed during this appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.serviceType.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-type-reference", path="Appointment.serviceType.reference", description="The specific service (by HealthcareService) that is to be performed during this appointment", type="reference", target={HealthcareService.class } )
  public static final String SP_SERVICE_TYPE_REFERENCE = "service-type-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-type-reference</b>
   * <p>
   * Description: <b>The specific service (by HealthcareService) that is to be performed during this appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.serviceType.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SERVICE_TYPE_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SERVICE_TYPE_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:service-type-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SERVICE_TYPE_REFERENCE = new ca.uhn.fhir.model.api.Include("Appointment:service-type-reference").toLocked();

 /**
   * Search parameter: <b>service-type</b>
   * <p>
   * Description: <b>The specific service (by coding) that is to be performed during this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.serviceType.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-type", path="Appointment.serviceType.concept", description="The specific service (by coding) that is to be performed during this appointment", type="token" )
  public static final String SP_SERVICE_TYPE = "service-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-type</b>
   * <p>
   * Description: <b>The specific service (by coding) that is to be performed during this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.serviceType.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERVICE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERVICE_TYPE);

 /**
   * Search parameter: <b>slot</b>
   * <p>
   * Description: <b>The slots that this appointment is filling</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.slot</b><br>
   * </p>
   */
  @SearchParamDefinition(name="slot", path="Appointment.slot", description="The slots that this appointment is filling", type="reference", target={Slot.class } )
  public static final String SP_SLOT = "slot";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>slot</b>
   * <p>
   * Description: <b>The slots that this appointment is filling</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.slot</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SLOT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SLOT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:slot</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SLOT = new ca.uhn.fhir.model.api.Include("Appointment:slot").toLocked();

 /**
   * Search parameter: <b>specialty</b>
   * <p>
   * Description: <b>The specialty of a practitioner that would be required to perform the service requested in this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.specialty</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specialty", path="Appointment.specialty", description="The specialty of a practitioner that would be required to perform the service requested in this appointment", type="token" )
  public static final String SP_SPECIALTY = "specialty";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specialty</b>
   * <p>
   * Description: <b>The specialty of a practitioner that would be required to perform the service requested in this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.specialty</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIALTY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIALTY);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The overall status of the appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Appointment.status", description="The overall status of the appointment", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The overall status of the appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Appointment.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Appointment.subject", description="One of the individuals of the appointment is this patient", type="reference", target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>One of the individuals of the appointment is this patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Appointment:subject").toLocked();

 /**
   * Search parameter: <b>supporting-info</b>
   * <p>
   * Description: <b>Additional information to support the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.supportingInformation</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supporting-info", path="Appointment.supportingInformation", description="Additional information to support the appointment", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUPPORTING_INFO = "supporting-info";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supporting-info</b>
   * <p>
   * Description: <b>Additional information to support the appointment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Appointment.supportingInformation</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPORTING_INFO = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPORTING_INFO);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Appointment:supporting-info</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPORTING_INFO = new ca.uhn.fhir.model.api.Include("Appointment:supporting-info").toLocked();

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
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
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
   * the path value of "<b>Appointment:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Appointment:patient").toLocked();


}

