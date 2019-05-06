package org.hl7.fhir.r5.model;

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

// Generated on Tue, May 7, 2019 08:29+1000 for FHIR v4.1.0

import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;
/**
 * A pattern to be followed by resources that represent the performance of some activity, possibly in accordance with a request or service definition.
 */
public interface Event extends PatternBase {

    public enum EventStatus {
        /**
         * The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).  Preparation stages may be tracked for billing purposes.
         */
        PREPARATION, 
        /**
         * The event is currently occurring.
         */
        INPROGRESS, 
        /**
         * The event was terminated prior to any activity beyond preparation.  I.e. The 'main' activity has not yet begun.  The boundary between preparatory and the 'main' activity is context-specific.
         */
        NOTDONE, 
        /**
         * The event has been temporarily stopped but is expected to resume in the future.
         */
        ONHOLD, 
        /**
         * The event was terminated prior to the full completion of the intended activity but after at least some of the 'main' activity (beyond preparation) has occurred.
         */
        STOPPED, 
        /**
         * The event has now concluded.
         */
        COMPLETED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be "cancelled" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EventStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return PREPARATION;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("not-done".equals(codeString))
          return NOTDONE;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EventStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREPARATION: return "preparation";
            case INPROGRESS: return "in-progress";
            case NOTDONE: return "not-done";
            case ONHOLD: return "on-hold";
            case STOPPED: return "stopped";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREPARATION: return "http://hl7.org/fhir/event-status";
            case INPROGRESS: return "http://hl7.org/fhir/event-status";
            case NOTDONE: return "http://hl7.org/fhir/event-status";
            case ONHOLD: return "http://hl7.org/fhir/event-status";
            case STOPPED: return "http://hl7.org/fhir/event-status";
            case COMPLETED: return "http://hl7.org/fhir/event-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/event-status";
            case UNKNOWN: return "http://hl7.org/fhir/event-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREPARATION: return "The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).  Preparation stages may be tracked for billing purposes.";
            case INPROGRESS: return "The event is currently occurring.";
            case NOTDONE: return "The event was terminated prior to any activity beyond preparation.  I.e. The 'main' activity has not yet begun.  The boundary between preparatory and the 'main' activity is context-specific.";
            case ONHOLD: return "The event has been temporarily stopped but is expected to resume in the future.";
            case STOPPED: return "The event was terminated prior to the full completion of the intended activity but after at least some of the 'main' activity (beyond preparation) has occurred.";
            case COMPLETED: return "The event has now concluded.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREPARATION: return "Preparation";
            case INPROGRESS: return "In Progress";
            case NOTDONE: return "Not Done";
            case ONHOLD: return "On Hold";
            case STOPPED: return "Stopped";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            default: return "?";
          }
        }
    }

  public class EventStatusEnumFactory implements EnumFactory<EventStatus> {
    public EventStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return EventStatus.PREPARATION;
        if ("in-progress".equals(codeString))
          return EventStatus.INPROGRESS;
        if ("not-done".equals(codeString))
          return EventStatus.NOTDONE;
        if ("on-hold".equals(codeString))
          return EventStatus.ONHOLD;
        if ("stopped".equals(codeString))
          return EventStatus.STOPPED;
        if ("completed".equals(codeString))
          return EventStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return EventStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return EventStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown EventStatus code '"+codeString+"'");
        }
        public Enumeration<EventStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EventStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("preparation".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.PREPARATION);
        if ("in-progress".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.INPROGRESS);
        if ("not-done".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.NOTDONE);
        if ("on-hold".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.ONHOLD);
        if ("stopped".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.STOPPED);
        if ("completed".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.UNKNOWN);
        throw new FHIRException("Unknown EventStatus code '"+codeString+"'");
        }
    public String toCode(EventStatus code) {
      if (code == EventStatus.PREPARATION)
        return "preparation";
      if (code == EventStatus.INPROGRESS)
        return "in-progress";
      if (code == EventStatus.NOTDONE)
        return "not-done";
      if (code == EventStatus.ONHOLD)
        return "on-hold";
      if (code == EventStatus.STOPPED)
        return "stopped";
      if (code == EventStatus.COMPLETED)
        return "completed";
      if (code == EventStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == EventStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(EventStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public interface EventPerformerComponent extends PatternBase {
        /**
         * @return {@link #function} (Distinguishes the type of involvement of the performer in the {{title}}. [Consider adding examples].)
         */
        public CodeableConcept getFunction();

        public boolean hasFunction();

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the performer in the {{title}}. [Consider adding examples].)
         */
        public EventPerformerComponent setFunction(CodeableConcept value);

        /**
         * @return {@link #actor} (Indicates who or what performed the {{title}}.)
         */
        public Reference getActor();

        public boolean hasActor();

        /**
         * @param value {@link #actor} (Indicates who or what performed the {{title}}.)
         */
        public EventPerformerComponent setActor(Reference value);

        /**
         * @return {@link #actor} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Indicates who or what performed the {{title}}.)
         */
        public Resource getActorTarget();

        /**
         * @param value {@link #actor} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Indicates who or what performed the {{title}}.)
         */
        public EventPerformerComponent setActorTarget(Resource value);

  }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setIdentifier(List<Identifier> theIdentifier);

    public boolean hasIdentifier();

    public Identifier addIdentifier();

    public Event addIdentifier(Identifier t);

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() ;

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public List<CanonicalType> getInstantiatesCanonical();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical);

    public boolean hasInstantiatesCanonical();

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public CanonicalType addInstantiatesCanonicalElement();

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Event addInstantiatesCanonical(String value);

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public boolean hasInstantiatesCanonical(String value) ;

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public List<UriType> getInstantiatesUri();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setInstantiatesUri(List<UriType> theInstantiatesUri);

    public boolean hasInstantiatesUri();

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public UriType addInstantiatesUriElement();

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Event addInstantiatesUri(String value);

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public boolean hasInstantiatesUri(String value) ;

    /**
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this {{title}}.)
     */
    public List<Reference> getBasedOn();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setBasedOn(List<Reference> theBasedOn);

    public boolean hasBasedOn();

    public Reference addBasedOn();

    public Event addBasedOn(Reference t);

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
     */
    public Reference getBasedOnFirstRep() ;

    /**
     * @return {@link #partOf} (A larger event of which this particular {{title}} is a component or step.)
     */
    public List<Reference> getPartOf();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setPartOf(List<Reference> thePartOf);

    public boolean hasPartOf();

    public Reference addPartOf();

    public Event addPartOf(Reference t);

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist
     */
    public Reference getPartOfFirstRep() ;

    /**
     * @return {@link #researchStudy} (Indicates that this {{title}} is relevant to the specified research study(ies).)
     */
    public List<Reference> getResearchStudy();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setResearchStudy(List<Reference> theResearchStudy);

    public boolean hasResearchStudy();

    public Reference addResearchStudy();

    public Event addResearchStudy(Reference t);

    /**
     * @return The first repetition of repeating field {@link #researchStudy}, creating it if it does not already exist
     */
    public Reference getResearchStudyFirstRep() ;

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EventStatus> getStatusElement();

    public boolean hasStatusElement();

    public boolean hasStatus();

    /**
     * @param value {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Event setStatusElement(Enumeration<EventStatus> value) ;

    /**
     * @return The current state of the {{title}}.
     */
    public EventStatus getStatus();

    /**
     * @param value The current state of the {{title}}.
     */
    public Event setStatus(EventStatus value);

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public CodeableConcept getStatusReason();

    public boolean hasStatusReason();

    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public Event setStatusReason(CodeableConcept value);

    /**
     * @return {@link #code} (A code that identifies the specific service or action that was or is being performed.)
     */
    public CodeableConcept getCode();

    public boolean hasCode();

    /**
     * @param value {@link #code} (A code that identifies the specific service or action that was or is being performed.)
     */
    public Event setCode(CodeableConcept value);

    /**
     * @return {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public Reference getSubject();

    public boolean hasSubject();

    /**
     * @param value {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public Event setSubject(Reference value);

    /**
     * @return {@link #subject} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The individual or set of individuals the action is being or was performed on.)
     */
    public Resource getSubjectTarget();

    /**
     * @param value {@link #subject} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The individual or set of individuals the action is being or was performed on.)
     */
    public Event setSubjectTarget(Resource value);

    /**
     * @return {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter();

    public boolean hasEncounter();

    /**
     * @param value {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Event setEncounter(Reference value);

    /**
     * @return {@link #encounter} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Encounter getEncounterTarget();

    /**
     * @param value {@link #encounter} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Event setEncounterTarget(Encounter value);

    /**
     * @return {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public Type getOccurrence();

    /**
     * @return {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException;

    public boolean hasOccurrenceDateTimeType();

    /**
     * @return {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public Period getOccurrencePeriod() throws FHIRException;

    public boolean hasOccurrencePeriod();

    /**
     * @return {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public Timing getOccurrenceTiming() throws FHIRException;

    public boolean hasOccurrenceTiming();

    public boolean hasOccurrence();

    /**
     * @param value {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public Event setOccurrence(Type value);

    /**
     * @return {@link #recorded} (The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public DateTimeType getRecordedElement();

    public boolean hasRecordedElement();

    public boolean hasRecorded();

    /**
     * @param value {@link #recorded} (The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public Event setRecordedElement(DateTimeType value) ;

    /**
     * @return The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.
     */
    public Date getRecorded();

    /**
     * @param value The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.
     */
    public Event setRecorded(Date value);

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Type getReported();

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public BooleanType getReportedBooleanType() throws FHIRException;

    public boolean hasReportedBooleanType();

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Reference getReportedReference() throws FHIRException;

    public boolean hasReportedReference();

    public boolean hasReported();

    /**
     * @param value {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Event setReported(Type value);

    /**
     * @return {@link #performer} (Indicates who or what performed the {{title}} and how they were involved.)
     */
    public List<EventPerformerComponent> getPerformer();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setPerformer(List<EventPerformerComponent> thePerformer);

    public boolean hasPerformer();

    public EventPerformerComponent addPerformer();

    public Event addPerformer(EventPerformerComponent t);

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist
     */
    public EventPerformerComponent getPerformerFirstRep() ;

    /**
     * @return {@link #location} (The principal physical location where the {{title}} was performed.)
     */
    public Reference getLocation();

    public boolean hasLocation();

    /**
     * @param value {@link #location} (The principal physical location where the {{title}} was performed.)
     */
    public Event setLocation(Reference value);

    /**
     * @return {@link #location} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The principal physical location where the {{title}} was performed.)
     */
    public Location getLocationTarget();

    /**
     * @param value {@link #location} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The principal physical location where the {{title}} was performed.)
     */
    public Event setLocationTarget(Location value);

    /**
     * @return {@link #reasonCode} (Describes why the {{title}} occurred in coded or textual form.)
     */
    public List<CodeableConcept> getReasonCode();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setReasonCode(List<CodeableConcept> theReasonCode);

    public boolean hasReasonCode();

    public CodeableConcept addReasonCode();

    public Event addReasonCode(CodeableConcept t);

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() ;

    /**
     * @return {@link #reasonReference} (Indicates another resource whose existence justifies this {{title}}.)
     */
    public List<Reference> getReasonReference();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setReasonReference(List<Reference> theReasonReference);

    public boolean hasReasonReference();

    public Reference addReasonReference();

    public Event addReasonReference(Reference t);

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() ;

    /**
     * @return {@link #note} (Comments made about the {{title}} by the performer, subject or other participants.)
     */
    public List<Annotation> getNote();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setNote(List<Annotation> theNote);

    public boolean hasNote();

    public Annotation addNote();

    public Event addNote(Annotation t);

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
     */
    public Annotation getNoteFirstRep() ;

  public String fhirType();


}

