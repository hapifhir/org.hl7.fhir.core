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
 * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
 */
@ResourceDef(name="AppointmentResponse", profile="http://hl7.org/fhir/StructureDefinition/AppointmentResponse")
public class AppointmentResponse extends DomainResource {

    /**
     * This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this item", formalDefinition="This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate." )
    protected List<Identifier> identifier;

    /**
     * Appointment that this response is replying to.
     */
    @Child(name = "appointment", type = {Appointment.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Appointment this response relates to", formalDefinition="Appointment that this response is replying to." )
    protected Reference appointment;

    /**
     * Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.
     */
    @Child(name = "proposedNewTime", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Indicator for a counter proposal", formalDefinition="Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties." )
    protected BooleanType proposedNewTime;

    /**
     * Date/Time that the appointment is to take place, or requested new start time.
     */
    @Child(name = "start", type = {InstantType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time from appointment, or requested new start time", formalDefinition="Date/Time that the appointment is to take place, or requested new start time." )
    protected InstantType start;

    /**
     * This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    @Child(name = "end", type = {InstantType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time from appointment, or requested new end time", formalDefinition="This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time." )
    protected InstantType end;

    /**
     * Role of participant in the appointment.
     */
    @Child(name = "participantType", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Role of participant in the appointment", formalDefinition="Role of participant in the appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-participant-type")
    protected List<CodeableConcept> participantType;

    /**
     * A Person, Location, HealthcareService, or Device that is participating in the appointment.
     */
    @Child(name = "actor", type = {Patient.class, Group.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Device.class, HealthcareService.class, Location.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Person(s), Location, HealthcareService, or Device", formalDefinition="A Person, Location, HealthcareService, or Device that is participating in the appointment." )
    protected Reference actor;

    /**
     * Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    @Child(name = "participantStatus", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="accepted | declined | tentative | needs-action", formalDefinition="Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participationstatus")
    protected Enumeration<ParticipationStatus> participantStatus;

    /**
     * Additional comments about the appointment.
     */
    @Child(name = "comment", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional comments", formalDefinition="Additional comments about the appointment." )
    protected StringType comment;

    /**
     * Indicates that this AppointmentResponse applies to all occurrences in a recurring request.
     */
    @Child(name = "recurring", type = {BooleanType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="This response is for all occurrences in a recurring request", formalDefinition="Indicates that this AppointmentResponse applies to all occurrences in a recurring request." )
    protected BooleanType recurring;

    /**
     * The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).
     */
    @Child(name = "occurrenceDate", type = {DateType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Original date within a recurring request", formalDefinition="The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`)." )
    protected DateType occurrenceDate;

    /**
     * The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.
     */
    @Child(name = "recurrenceId", type = {PositiveIntType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The recurrence ID of the specific recurring request", formalDefinition="The recurrence ID (sequence number) of the specific appointment when responding to a recurring request." )
    protected PositiveIntType recurrenceId;

    private static final long serialVersionUID = 1970686636L;

  /**
   * Constructor
   */
    public AppointmentResponse() {
      super();
    }

  /**
   * Constructor
   */
    public AppointmentResponse(Reference appointment, ParticipationStatus participantStatus) {
      super();
      this.setAppointment(appointment);
      this.setParticipantStatus(participantStatus);
    }

    /**
     * @return {@link #identifier} (This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AppointmentResponse setIdentifier(List<Identifier> theIdentifier) { 
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

    public AppointmentResponse addIdentifier(Identifier t) { //3
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
     * @return {@link #appointment} (Appointment that this response is replying to.)
     */
    public Reference getAppointment() { 
      if (this.appointment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.appointment");
        else if (Configuration.doAutoCreate())
          this.appointment = new Reference(); // cc
      return this.appointment;
    }

    public boolean hasAppointment() { 
      return this.appointment != null && !this.appointment.isEmpty();
    }

    /**
     * @param value {@link #appointment} (Appointment that this response is replying to.)
     */
    public AppointmentResponse setAppointment(Reference value) { 
      this.appointment = value;
      return this;
    }

    /**
     * @return {@link #proposedNewTime} (Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.). This is the underlying object with id, value and extensions. The accessor "getProposedNewTime" gives direct access to the value
     */
    public BooleanType getProposedNewTimeElement() { 
      if (this.proposedNewTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.proposedNewTime");
        else if (Configuration.doAutoCreate())
          this.proposedNewTime = new BooleanType(); // bb
      return this.proposedNewTime;
    }

    public boolean hasProposedNewTimeElement() { 
      return this.proposedNewTime != null && !this.proposedNewTime.isEmpty();
    }

    public boolean hasProposedNewTime() { 
      return this.proposedNewTime != null && !this.proposedNewTime.isEmpty();
    }

    /**
     * @param value {@link #proposedNewTime} (Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.). This is the underlying object with id, value and extensions. The accessor "getProposedNewTime" gives direct access to the value
     */
    public AppointmentResponse setProposedNewTimeElement(BooleanType value) { 
      this.proposedNewTime = value;
      return this;
    }

    /**
     * @return Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.
     */
    public boolean getProposedNewTime() { 
      return this.proposedNewTime == null || this.proposedNewTime.isEmpty() ? false : this.proposedNewTime.getValue();
    }

    /**
     * @param value Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.
     */
    public AppointmentResponse setProposedNewTime(boolean value) { 
        if (this.proposedNewTime == null)
          this.proposedNewTime = new BooleanType();
        this.proposedNewTime.setValue(value);
      return this;
    }

    /**
     * @return {@link #start} (Date/Time that the appointment is to take place, or requested new start time.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public InstantType getStartElement() { 
      if (this.start == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.start");
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
     * @param value {@link #start} (Date/Time that the appointment is to take place, or requested new start time.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public AppointmentResponse setStartElement(InstantType value) { 
      this.start = value;
      return this;
    }

    /**
     * @return Date/Time that the appointment is to take place, or requested new start time.
     */
    public Date getStart() { 
      return this.start == null ? null : this.start.getValue();
    }

    /**
     * @param value Date/Time that the appointment is to take place, or requested new start time.
     */
    public AppointmentResponse setStart(Date value) { 
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
     * @return {@link #end} (This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public InstantType getEndElement() { 
      if (this.end == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.end");
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
     * @param value {@link #end} (This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public AppointmentResponse setEndElement(InstantType value) { 
      this.end = value;
      return this;
    }

    /**
     * @return This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    public Date getEnd() { 
      return this.end == null ? null : this.end.getValue();
    }

    /**
     * @param value This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    public AppointmentResponse setEnd(Date value) { 
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
     * @return {@link #participantType} (Role of participant in the appointment.)
     */
    public List<CodeableConcept> getParticipantType() { 
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      return this.participantType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AppointmentResponse setParticipantType(List<CodeableConcept> theParticipantType) { 
      this.participantType = theParticipantType;
      return this;
    }

    public boolean hasParticipantType() { 
      if (this.participantType == null)
        return false;
      for (CodeableConcept item : this.participantType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addParticipantType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      this.participantType.add(t);
      return t;
    }

    public AppointmentResponse addParticipantType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      this.participantType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participantType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getParticipantTypeFirstRep() { 
      if (getParticipantType().isEmpty()) {
        addParticipantType();
      }
      return getParticipantType().get(0);
    }

    /**
     * @return {@link #actor} (A Person, Location, HealthcareService, or Device that is participating in the appointment.)
     */
    public Reference getActor() { 
      if (this.actor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.actor");
        else if (Configuration.doAutoCreate())
          this.actor = new Reference(); // cc
      return this.actor;
    }

    public boolean hasActor() { 
      return this.actor != null && !this.actor.isEmpty();
    }

    /**
     * @param value {@link #actor} (A Person, Location, HealthcareService, or Device that is participating in the appointment.)
     */
    public AppointmentResponse setActor(Reference value) { 
      this.actor = value;
      return this;
    }

    /**
     * @return {@link #participantStatus} (Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.). This is the underlying object with id, value and extensions. The accessor "getParticipantStatus" gives direct access to the value
     */
    public Enumeration<ParticipationStatus> getParticipantStatusElement() { 
      if (this.participantStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.participantStatus");
        else if (Configuration.doAutoCreate())
          this.participantStatus = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory()); // bb
      return this.participantStatus;
    }

    public boolean hasParticipantStatusElement() { 
      return this.participantStatus != null && !this.participantStatus.isEmpty();
    }

    public boolean hasParticipantStatus() { 
      return this.participantStatus != null && !this.participantStatus.isEmpty();
    }

    /**
     * @param value {@link #participantStatus} (Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.). This is the underlying object with id, value and extensions. The accessor "getParticipantStatus" gives direct access to the value
     */
    public AppointmentResponse setParticipantStatusElement(Enumeration<ParticipationStatus> value) { 
      this.participantStatus = value;
      return this;
    }

    /**
     * @return Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    public ParticipationStatus getParticipantStatus() { 
      return this.participantStatus == null ? null : this.participantStatus.getValue();
    }

    /**
     * @param value Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    public AppointmentResponse setParticipantStatus(ParticipationStatus value) { 
        if (this.participantStatus == null)
          this.participantStatus = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory());
        this.participantStatus.setValue(value);
      return this;
    }

    /**
     * @return {@link #comment} (Additional comments about the appointment.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public StringType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new StringType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Additional comments about the appointment.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public AppointmentResponse setCommentElement(StringType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return Additional comments about the appointment.
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Additional comments about the appointment.
     */
    public AppointmentResponse setComment(String value) { 
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new StringType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #recurring} (Indicates that this AppointmentResponse applies to all occurrences in a recurring request.). This is the underlying object with id, value and extensions. The accessor "getRecurring" gives direct access to the value
     */
    public BooleanType getRecurringElement() { 
      if (this.recurring == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.recurring");
        else if (Configuration.doAutoCreate())
          this.recurring = new BooleanType(); // bb
      return this.recurring;
    }

    public boolean hasRecurringElement() { 
      return this.recurring != null && !this.recurring.isEmpty();
    }

    public boolean hasRecurring() { 
      return this.recurring != null && !this.recurring.isEmpty();
    }

    /**
     * @param value {@link #recurring} (Indicates that this AppointmentResponse applies to all occurrences in a recurring request.). This is the underlying object with id, value and extensions. The accessor "getRecurring" gives direct access to the value
     */
    public AppointmentResponse setRecurringElement(BooleanType value) { 
      this.recurring = value;
      return this;
    }

    /**
     * @return Indicates that this AppointmentResponse applies to all occurrences in a recurring request.
     */
    public boolean getRecurring() { 
      return this.recurring == null || this.recurring.isEmpty() ? false : this.recurring.getValue();
    }

    /**
     * @param value Indicates that this AppointmentResponse applies to all occurrences in a recurring request.
     */
    public AppointmentResponse setRecurring(boolean value) { 
        if (this.recurring == null)
          this.recurring = new BooleanType();
        this.recurring.setValue(value);
      return this;
    }

    /**
     * @return {@link #occurrenceDate} (The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).). This is the underlying object with id, value and extensions. The accessor "getOccurrenceDate" gives direct access to the value
     */
    public DateType getOccurrenceDateElement() { 
      if (this.occurrenceDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.occurrenceDate");
        else if (Configuration.doAutoCreate())
          this.occurrenceDate = new DateType(); // bb
      return this.occurrenceDate;
    }

    public boolean hasOccurrenceDateElement() { 
      return this.occurrenceDate != null && !this.occurrenceDate.isEmpty();
    }

    public boolean hasOccurrenceDate() { 
      return this.occurrenceDate != null && !this.occurrenceDate.isEmpty();
    }

    /**
     * @param value {@link #occurrenceDate} (The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).). This is the underlying object with id, value and extensions. The accessor "getOccurrenceDate" gives direct access to the value
     */
    public AppointmentResponse setOccurrenceDateElement(DateType value) { 
      this.occurrenceDate = value;
      return this;
    }

    /**
     * @return The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).
     */
    public Date getOccurrenceDate() { 
      return this.occurrenceDate == null ? null : this.occurrenceDate.getValue();
    }

    /**
     * @param value The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).
     */
    public AppointmentResponse setOccurrenceDate(Date value) { 
      if (value == null)
        this.occurrenceDate = null;
      else {
        if (this.occurrenceDate == null)
          this.occurrenceDate = new DateType();
        this.occurrenceDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #recurrenceId} (The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.). This is the underlying object with id, value and extensions. The accessor "getRecurrenceId" gives direct access to the value
     */
    public PositiveIntType getRecurrenceIdElement() { 
      if (this.recurrenceId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.recurrenceId");
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
     * @param value {@link #recurrenceId} (The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.). This is the underlying object with id, value and extensions. The accessor "getRecurrenceId" gives direct access to the value
     */
    public AppointmentResponse setRecurrenceIdElement(PositiveIntType value) { 
      this.recurrenceId = value;
      return this;
    }

    /**
     * @return The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.
     */
    public int getRecurrenceId() { 
      return this.recurrenceId == null || this.recurrenceId.isEmpty() ? 0 : this.recurrenceId.getValue();
    }

    /**
     * @param value The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.
     */
    public AppointmentResponse setRecurrenceId(int value) { 
        if (this.recurrenceId == null)
          this.recurrenceId = new PositiveIntType();
        this.recurrenceId.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("appointment", "Reference(Appointment)", "Appointment that this response is replying to.", 0, 1, appointment));
        children.add(new Property("proposedNewTime", "boolean", "Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.", 0, 1, proposedNewTime));
        children.add(new Property("start", "instant", "Date/Time that the appointment is to take place, or requested new start time.", 0, 1, start));
        children.add(new Property("end", "instant", "This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.", 0, 1, end));
        children.add(new Property("participantType", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, participantType));
        children.add(new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location, HealthcareService, or Device that is participating in the appointment.", 0, 1, actor));
        children.add(new Property("participantStatus", "code", "Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.", 0, 1, participantStatus));
        children.add(new Property("comment", "string", "Additional comments about the appointment.", 0, 1, comment));
        children.add(new Property("recurring", "boolean", "Indicates that this AppointmentResponse applies to all occurrences in a recurring request.", 0, 1, recurring));
        children.add(new Property("occurrenceDate", "date", "The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).", 0, 1, occurrenceDate));
        children.add(new Property("recurrenceId", "positiveInt", "The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.", 0, 1, recurrenceId));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1474995297: /*appointment*/  return new Property("appointment", "Reference(Appointment)", "Appointment that this response is replying to.", 0, 1, appointment);
        case -577024441: /*proposedNewTime*/  return new Property("proposedNewTime", "boolean", "Indicates that the response is proposing a different time that was initially requested.  The new proposed time will be indicated in the start and end properties.", 0, 1, proposedNewTime);
        case 109757538: /*start*/  return new Property("start", "instant", "Date/Time that the appointment is to take place, or requested new start time.", 0, 1, start);
        case 100571: /*end*/  return new Property("end", "instant", "This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.", 0, 1, end);
        case 841294093: /*participantType*/  return new Property("participantType", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, participantType);
        case 92645877: /*actor*/  return new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location, HealthcareService, or Device that is participating in the appointment.", 0, 1, actor);
        case 996096261: /*participantStatus*/  return new Property("participantStatus", "code", "Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.", 0, 1, participantStatus);
        case 950398559: /*comment*/  return new Property("comment", "string", "Additional comments about the appointment.", 0, 1, comment);
        case 1165749981: /*recurring*/  return new Property("recurring", "boolean", "Indicates that this AppointmentResponse applies to all occurrences in a recurring request.", 0, 1, recurring);
        case 1721761055: /*occurrenceDate*/  return new Property("occurrenceDate", "date", "The original date within a recurring request. This could be used in place of the recurrenceId to be more direct (or where the template is provided through the simple list of dates in `Appointment.occurrenceDate`).", 0, 1, occurrenceDate);
        case -362407829: /*recurrenceId*/  return new Property("recurrenceId", "positiveInt", "The recurrence ID (sequence number) of the specific appointment when responding to a recurring request.", 0, 1, recurrenceId);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1474995297: /*appointment*/ return this.appointment == null ? new Base[0] : new Base[] {this.appointment}; // Reference
        case -577024441: /*proposedNewTime*/ return this.proposedNewTime == null ? new Base[0] : new Base[] {this.proposedNewTime}; // BooleanType
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // InstantType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case 841294093: /*participantType*/ return this.participantType == null ? new Base[0] : this.participantType.toArray(new Base[this.participantType.size()]); // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        case 996096261: /*participantStatus*/ return this.participantStatus == null ? new Base[0] : new Base[] {this.participantStatus}; // Enumeration<ParticipationStatus>
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        case 1165749981: /*recurring*/ return this.recurring == null ? new Base[0] : new Base[] {this.recurring}; // BooleanType
        case 1721761055: /*occurrenceDate*/ return this.occurrenceDate == null ? new Base[0] : new Base[] {this.occurrenceDate}; // DateType
        case -362407829: /*recurrenceId*/ return this.recurrenceId == null ? new Base[0] : new Base[] {this.recurrenceId}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1474995297: // appointment
          this.appointment = TypeConvertor.castToReference(value); // Reference
          return value;
        case -577024441: // proposedNewTime
          this.proposedNewTime = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 109757538: // start
          this.start = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 841294093: // participantType
          this.getParticipantType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        case 996096261: // participantStatus
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.participantStatus = (Enumeration) value; // Enumeration<ParticipationStatus>
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        case 1165749981: // recurring
          this.recurring = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1721761055: // occurrenceDate
          this.occurrenceDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -362407829: // recurrenceId
          this.recurrenceId = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("appointment")) {
          this.appointment = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("proposedNewTime")) {
          this.proposedNewTime = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("start")) {
          this.start = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("participantType")) {
          this.getParticipantType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participantStatus")) {
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.participantStatus = (Enumeration) value; // Enumeration<ParticipationStatus>
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("recurring")) {
          this.recurring = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("occurrenceDate")) {
          this.occurrenceDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("recurrenceId")) {
          this.recurrenceId = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1474995297:  return getAppointment();
        case -577024441:  return getProposedNewTimeElement();
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case 841294093:  return addParticipantType(); 
        case 92645877:  return getActor();
        case 996096261:  return getParticipantStatusElement();
        case 950398559:  return getCommentElement();
        case 1165749981:  return getRecurringElement();
        case 1721761055:  return getOccurrenceDateElement();
        case -362407829:  return getRecurrenceIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1474995297: /*appointment*/ return new String[] {"Reference"};
        case -577024441: /*proposedNewTime*/ return new String[] {"boolean"};
        case 109757538: /*start*/ return new String[] {"instant"};
        case 100571: /*end*/ return new String[] {"instant"};
        case 841294093: /*participantType*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case 996096261: /*participantStatus*/ return new String[] {"code"};
        case 950398559: /*comment*/ return new String[] {"string"};
        case 1165749981: /*recurring*/ return new String[] {"boolean"};
        case 1721761055: /*occurrenceDate*/ return new String[] {"date"};
        case -362407829: /*recurrenceId*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("appointment")) {
          this.appointment = new Reference();
          return this.appointment;
        }
        else if (name.equals("proposedNewTime")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.proposedNewTime");
        }
        else if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.end");
        }
        else if (name.equals("participantType")) {
          return addParticipantType();
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else if (name.equals("participantStatus")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.participantStatus");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.comment");
        }
        else if (name.equals("recurring")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.recurring");
        }
        else if (name.equals("occurrenceDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.occurrenceDate");
        }
        else if (name.equals("recurrenceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.recurrenceId");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AppointmentResponse";

  }

      public AppointmentResponse copy() {
        AppointmentResponse dst = new AppointmentResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentResponse dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.appointment = appointment == null ? null : appointment.copy();
        dst.proposedNewTime = proposedNewTime == null ? null : proposedNewTime.copy();
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        if (participantType != null) {
          dst.participantType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : participantType)
            dst.participantType.add(i.copy());
        };
        dst.actor = actor == null ? null : actor.copy();
        dst.participantStatus = participantStatus == null ? null : participantStatus.copy();
        dst.comment = comment == null ? null : comment.copy();
        dst.recurring = recurring == null ? null : recurring.copy();
        dst.occurrenceDate = occurrenceDate == null ? null : occurrenceDate.copy();
        dst.recurrenceId = recurrenceId == null ? null : recurrenceId.copy();
      }

      protected AppointmentResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentResponse))
          return false;
        AppointmentResponse o = (AppointmentResponse) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(appointment, o.appointment, true)
           && compareDeep(proposedNewTime, o.proposedNewTime, true) && compareDeep(start, o.start, true) && compareDeep(end, o.end, true)
           && compareDeep(participantType, o.participantType, true) && compareDeep(actor, o.actor, true) && compareDeep(participantStatus, o.participantStatus, true)
           && compareDeep(comment, o.comment, true) && compareDeep(recurring, o.recurring, true) && compareDeep(occurrenceDate, o.occurrenceDate, true)
           && compareDeep(recurrenceId, o.recurrenceId, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentResponse))
          return false;
        AppointmentResponse o = (AppointmentResponse) other_;
        return compareValues(proposedNewTime, o.proposedNewTime, true) && compareValues(start, o.start, true)
           && compareValues(end, o.end, true) && compareValues(participantStatus, o.participantStatus, true) && compareValues(comment, o.comment, true)
           && compareValues(recurring, o.recurring, true) && compareValues(occurrenceDate, o.occurrenceDate, true)
           && compareValues(recurrenceId, o.recurrenceId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, appointment, proposedNewTime
          , start, end, participantType, actor, participantStatus, comment, recurring, occurrenceDate
          , recurrenceId);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AppointmentResponse;
   }

 /**
   * Search parameter: <b>actor</b>
   * <p>
   * Description: <b>The Person, Location/HealthcareService or Device that this appointment response replies for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="actor", path="AppointmentResponse.actor", description="The Person, Location/HealthcareService or Device that this appointment response replies for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Group.class, HealthcareService.class, Location.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_ACTOR = "actor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>actor</b>
   * <p>
   * Description: <b>The Person, Location/HealthcareService or Device that this appointment response replies for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:actor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACTOR = new ca.uhn.fhir.model.api.Include("AppointmentResponse:actor").toLocked();

 /**
   * Search parameter: <b>appointment</b>
   * <p>
   * Description: <b>The appointment that the response is attached to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.appointment</b><br>
   * </p>
   */
  @SearchParamDefinition(name="appointment", path="AppointmentResponse.appointment", description="The appointment that the response is attached to", type="reference", target={Appointment.class } )
  public static final String SP_APPOINTMENT = "appointment";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>appointment</b>
   * <p>
   * Description: <b>The appointment that the response is attached to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.appointment</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam APPOINTMENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_APPOINTMENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:appointment</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_APPOINTMENT = new ca.uhn.fhir.model.api.Include("AppointmentResponse:appointment").toLocked();

 /**
   * Search parameter: <b>group</b>
   * <p>
   * Description: <b>This Response is for this Group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Group)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group", path="AppointmentResponse.actor.where(resolve() is Group)", description="This Response is for this Group", type="reference", target={Group.class } )
  public static final String SP_GROUP = "group";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group</b>
   * <p>
   * Description: <b>This Response is for this Group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Group)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam GROUP = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_GROUP);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:group</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_GROUP = new ca.uhn.fhir.model.api.Include("AppointmentResponse:group").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>An Identifier in this appointment response</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AppointmentResponse.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AppointmentResponse.identifier", description="An Identifier in this appointment response", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>An Identifier in this appointment response</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AppointmentResponse.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>This Response is for this Location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Location)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="AppointmentResponse.actor.where(resolve() is Location)", description="This Response is for this Location", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>This Response is for this Location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Location)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("AppointmentResponse:location").toLocked();

 /**
   * Search parameter: <b>part-status</b>
   * <p>
   * Description: <b>The participants acceptance status for this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AppointmentResponse.participantStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-status", path="AppointmentResponse.participantStatus", description="The participants acceptance status for this appointment", type="token" )
  public static final String SP_PART_STATUS = "part-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-status</b>
   * <p>
   * Description: <b>The participants acceptance status for this appointment</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AppointmentResponse.participantStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PART_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PART_STATUS);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>This Response is for this Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AppointmentResponse.actor.where(resolve() is Patient)", description="This Response is for this Patient", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>This Response is for this Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("AppointmentResponse:patient").toLocked();

 /**
   * Search parameter: <b>practitioner</b>
   * <p>
   * Description: <b>This Response is for this Practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="practitioner", path="AppointmentResponse.actor.where(resolve() is Practitioner)", description="This Response is for this Practitioner", type="reference", target={Practitioner.class } )
  public static final String SP_PRACTITIONER = "practitioner";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>practitioner</b>
   * <p>
   * Description: <b>This Response is for this Practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AppointmentResponse.actor.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRACTITIONER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRACTITIONER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AppointmentResponse:practitioner</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRACTITIONER = new ca.uhn.fhir.model.api.Include("AppointmentResponse:practitioner").toLocked();


}

