package org.hl7.fhir.r5.patterns;




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

// Generated on Wed, May 8, 2019 10:40+1000 for FHIR v4.1.0

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Enumeration;
import java.util.*;

import org.hl7.fhir.utilities.Utilities;
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

    public interface EventPerformerComponent extends PatternBase {
        /**
         * @return {@link #function} (Distinguishes the type of involvement of the performer in the {{title}}. [Consider adding examples].)
         */
        public CodeableConcept getFunction() throws FHIRException ;

        /**
         * @return whether there is more than zero values for function
         */
        public boolean hasFunction();
        /**
         * @return minimum allowed cardinality for function. Note that with patterns, this may be different for the underlying resource
         */
        public int getFunctionMin();
        /**
         * @return maximum allowed cardinality for function. Note that with patterns, this may be different for the underlying resource
         */
        public int getFunctionMax();
        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the performer in the {{title}}. [Consider adding examples].)
         */
        public EventPerformerComponent setFunction(CodeableConcept value) throws FHIRException;

        /**
         * @return {@link #actor} (Indicates who or what performed the {{title}}.)
         */
        public Reference getActor() throws FHIRException ;

        /**
         * @return whether there is more than zero values for actor
         */
        public boolean hasActor();
        /**
         * @return minimum allowed cardinality for actor. Note that with patterns, this may be different for the underlying resource
         */
        public int getActorMin();
        /**
         * @return maximum allowed cardinality for actor. Note that with patterns, this may be different for the underlying resource
         */
        public int getActorMax();
        /**
         * @param value {@link #actor} (Indicates who or what performed the {{title}}.)
         */
        public EventPerformerComponent setActor(Reference value) throws FHIRException;

  }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setIdentifier(List<Identifier> theIdentifier) throws FHIRException;

    /**
     * @return whether there is more than zero values for identifier
     */
    public boolean hasIdentifier();
    /**
     * @return minimum allowed cardinality for identifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getIdentifierMin();
    /**
     * @return maximum allowed cardinality for identifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getIdentifierMax();

    public Identifier addIdentifier() throws FHIRException;

    public Event addIdentifier(Identifier t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() throws FHIRException;

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public List<CanonicalType> getInstantiatesCanonical() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) throws FHIRException;

    /**
     * @return whether there is more than zero values for instantiatesCanonical
     */
    public boolean hasInstantiatesCanonical();
    /**
     * @return minimum allowed cardinality for instantiatesCanonical. Note that with patterns, this may be different for the underlying resource
     */
    public int getInstantiatesCanonicalMin();
    /**
     * @return maximum allowed cardinality for instantiatesCanonical. Note that with patterns, this may be different for the underlying resource
     */
    public int getInstantiatesCanonicalMax();

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public CanonicalType addInstantiatesCanonicalElement() throws FHIRException;

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Event addInstantiatesCanonical(String value) throws FHIRException;

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public boolean hasInstantiatesCanonical(String value)  throws FHIRException;

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public List<UriType> getInstantiatesUri() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setInstantiatesUri(List<UriType> theInstantiatesUri) throws FHIRException;

    /**
     * @return whether there is more than zero values for instantiatesUri
     */
    public boolean hasInstantiatesUri();
    /**
     * @return minimum allowed cardinality for instantiatesUri. Note that with patterns, this may be different for the underlying resource
     */
    public int getInstantiatesUriMin();
    /**
     * @return maximum allowed cardinality for instantiatesUri. Note that with patterns, this may be different for the underlying resource
     */
    public int getInstantiatesUriMax();

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public UriType addInstantiatesUriElement() throws FHIRException;

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Event addInstantiatesUri(String value) throws FHIRException;

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public boolean hasInstantiatesUri(String value)  throws FHIRException;

    /**
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this {{title}}.)
     */
    public List<Reference> getBasedOn() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setBasedOn(List<Reference> theBasedOn) throws FHIRException;

    /**
     * @return whether there is more than zero values for basedOn
     */
    public boolean hasBasedOn();
    /**
     * @return minimum allowed cardinality for basedOn. Note that with patterns, this may be different for the underlying resource
     */
    public int getBasedOnMin();
    /**
     * @return maximum allowed cardinality for basedOn. Note that with patterns, this may be different for the underlying resource
     */
    public int getBasedOnMax();

    public Reference addBasedOn() throws FHIRException;

    public Event addBasedOn(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
     */
    public Reference getBasedOnFirstRep() throws FHIRException;

    /**
     * @return {@link #partOf} (A larger event of which this particular {{title}} is a component or step.)
     */
    public List<Reference> getPartOf() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setPartOf(List<Reference> thePartOf) throws FHIRException;

    /**
     * @return whether there is more than zero values for partOf
     */
    public boolean hasPartOf();
    /**
     * @return minimum allowed cardinality for partOf. Note that with patterns, this may be different for the underlying resource
     */
    public int getPartOfMin();
    /**
     * @return maximum allowed cardinality for partOf. Note that with patterns, this may be different for the underlying resource
     */
    public int getPartOfMax();

    public Reference addPartOf() throws FHIRException;

    public Event addPartOf(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist
     */
    public Reference getPartOfFirstRep() throws FHIRException;

    /**
     * @return {@link #researchStudy} (Indicates that this {{title}} is relevant to the specified research study(ies).)
     */
    public List<Reference> getResearchStudy() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setResearchStudy(List<Reference> theResearchStudy) throws FHIRException;

    /**
     * @return whether there is more than zero values for researchStudy
     */
    public boolean hasResearchStudy();
    /**
     * @return minimum allowed cardinality for researchStudy. Note that with patterns, this may be different for the underlying resource
     */
    public int getResearchStudyMin();
    /**
     * @return maximum allowed cardinality for researchStudy. Note that with patterns, this may be different for the underlying resource
     */
    public int getResearchStudyMax();

    public Reference addResearchStudy() throws FHIRException;

    public Event addResearchStudy(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #researchStudy}, creating it if it does not already exist
     */
    public Reference getResearchStudyFirstRep() throws FHIRException;

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EventStatus> getStatusElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for status
     */
    public boolean hasStatus();
    /**
     * @return minimum allowed cardinality for status. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for status. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusMax() throws FHIRException;
    public boolean hasStatusElement();

    /**
     * @param value {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Event setStatusElement(Enumeration<EventStatus> value) throws FHIRException;

    /**
     * @return The current state of the {{title}}.
     */
    public EventStatus getStatus() throws FHIRException;

    /**
     * @param value The current state of the {{title}}.
     */
    public Event setStatus(EventStatus value) throws FHIRException;

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public CodeableConcept getStatusReason() throws FHIRException ;

    /**
     * @return whether there is more than zero values for statusReason
     */
    public boolean hasStatusReason();
    /**
     * @return minimum allowed cardinality for statusReason. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusReasonMin();
    /**
     * @return maximum allowed cardinality for statusReason. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusReasonMax();
    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public Event setStatusReason(CodeableConcept value) throws FHIRException;

    /**
     * @return {@link #code} (A code that identifies the specific service or action that was or is being performed.)
     */
    public CodeableConcept getCode() throws FHIRException ;

    /**
     * @return whether there is more than zero values for code
     */
    public boolean hasCode();
    /**
     * @return minimum allowed cardinality for code. Note that with patterns, this may be different for the underlying resource
     */
    public int getCodeMin();
    /**
     * @return maximum allowed cardinality for code. Note that with patterns, this may be different for the underlying resource
     */
    public int getCodeMax();
    /**
     * @param value {@link #code} (A code that identifies the specific service or action that was or is being performed.)
     */
    public Event setCode(CodeableConcept value) throws FHIRException;

    /**
     * @return {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public Reference getSubject() throws FHIRException ;

    /**
     * @return whether there is more than zero values for subject
     */
    public boolean hasSubject();
    /**
     * @return minimum allowed cardinality for subject. Note that with patterns, this may be different for the underlying resource
     */
    public int getSubjectMin();
    /**
     * @return maximum allowed cardinality for subject. Note that with patterns, this may be different for the underlying resource
     */
    public int getSubjectMax();
    /**
     * @param value {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public Event setSubject(Reference value) throws FHIRException;

    /**
     * @return {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() throws FHIRException ;

    /**
     * @return whether there is more than zero values for encounter
     */
    public boolean hasEncounter();
    /**
     * @return minimum allowed cardinality for encounter. Note that with patterns, this may be different for the underlying resource
     */
    public int getEncounterMin();
    /**
     * @return maximum allowed cardinality for encounter. Note that with patterns, this may be different for the underlying resource
     */
    public int getEncounterMax();
    /**
     * @param value {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Event setEncounter(Reference value) throws FHIRException;

    /**
     * @return {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public DataType getOccurrence() throws FHIRException ;

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

    /**
     * @return whether there is more than zero values for occurrence
     */
    public boolean hasOccurrence();
    /**
     * @return minimum allowed cardinality for occurrence. Note that with patterns, this may be different for the underlying resource
     */
    public int getOccurrenceMin();
    /**
     * @return maximum allowed cardinality for occurrence. Note that with patterns, this may be different for the underlying resource
     */
    public int getOccurrenceMax();
    /**
     * @param value {@link #occurrence} (The date, period or timing when the {{title}} did occur or is occurring.)
     */
    public Event setOccurrence(DataType value) throws FHIRException;

    /**
     * @return {@link #recorded} (The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public DateTimeType getRecordedElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for recorded
     */
    public boolean hasRecorded();
    /**
     * @return minimum allowed cardinality for recorded. Note that with patterns, this may be different for the underlying resource
     */
    public int getRecordedMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for recorded. Note that with patterns, this may be different for the underlying resource
     */
    public int getRecordedMax() throws FHIRException;
    public boolean hasRecordedElement();

    /**
     * @param value {@link #recorded} (The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public Event setRecordedElement(DateTimeType value) throws FHIRException;

    /**
     * @return The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.
     */
    public Date getRecorded() throws FHIRException;

    /**
     * @param value The date the occurrence of the {{title}} was first captured in the record - potentially significantly after the occurrence of the event.
     */
    public Event setRecorded(Date value) throws FHIRException;

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public DataType getReported() throws FHIRException ;

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

    /**
     * @return whether there is more than zero values for reported
     */
    public boolean hasReported();
    /**
     * @return minimum allowed cardinality for reported. Note that with patterns, this may be different for the underlying resource
     */
    public int getReportedMin();
    /**
     * @return maximum allowed cardinality for reported. Note that with patterns, this may be different for the underlying resource
     */
    public int getReportedMax();
    /**
     * @param value {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Event setReported(DataType value) throws FHIRException;

    /**
     * @return {@link #performer} (Indicates who or what performed the {{title}} and how they were involved.)
     */
    public List<EventPerformerComponent> getPerformer() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setPerformer(List<EventPerformerComponent> thePerformer) throws FHIRException;

    /**
     * @return whether there is more than zero values for performer
     */
    public boolean hasPerformer();
    /**
     * @return minimum allowed cardinality for performer. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerMin();
    /**
     * @return maximum allowed cardinality for performer. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerMax();

    public EventPerformerComponent addPerformer() throws FHIRException;

    public Event addPerformer(EventPerformerComponent t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist
     */
    public EventPerformerComponent getPerformerFirstRep() throws FHIRException;

    /**
     * @return {@link #location} (The principal physical location where the {{title}} was performed.)
     */
    public Reference getLocation() throws FHIRException ;

    /**
     * @return whether there is more than zero values for location
     */
    public boolean hasLocation();
    /**
     * @return minimum allowed cardinality for location. Note that with patterns, this may be different for the underlying resource
     */
    public int getLocationMin();
    /**
     * @return maximum allowed cardinality for location. Note that with patterns, this may be different for the underlying resource
     */
    public int getLocationMax();
    /**
     * @param value {@link #location} (The principal physical location where the {{title}} was performed.)
     */
    public Event setLocation(Reference value) throws FHIRException;

    /**
     * @return {@link #reasonCode} (Describes why the {{title}} occurred in coded or textual form.)
     */
    public List<CodeableConcept> getReasonCode() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setReasonCode(List<CodeableConcept> theReasonCode) throws FHIRException;

    /**
     * @return whether there is more than zero values for reasonCode
     */
    public boolean hasReasonCode();
    /**
     * @return minimum allowed cardinality for reasonCode. Note that with patterns, this may be different for the underlying resource
     */
    public int getReasonCodeMin();
    /**
     * @return maximum allowed cardinality for reasonCode. Note that with patterns, this may be different for the underlying resource
     */
    public int getReasonCodeMax();

    public CodeableConcept addReasonCode() throws FHIRException;

    public Event addReasonCode(CodeableConcept t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() throws FHIRException;

    /**
     * @return {@link #reasonReference} (Indicates another resource whose existence justifies this {{title}}.)
     */
    public List<Reference> getReasonReference() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setReasonReference(List<Reference> theReasonReference) throws FHIRException;

    /**
     * @return whether there is more than zero values for reasonReference
     */
    public boolean hasReasonReference();
    /**
     * @return minimum allowed cardinality for reasonReference. Note that with patterns, this may be different for the underlying resource
     */
    public int getReasonReferenceMin();
    /**
     * @return maximum allowed cardinality for reasonReference. Note that with patterns, this may be different for the underlying resource
     */
    public int getReasonReferenceMax();

    public Reference addReasonReference() throws FHIRException;

    public Event addReasonReference(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() throws FHIRException;

    /**
     * @return {@link #note} (Comments made about the {{title}} by the performer, subject or other participants.)
     */
    public List<Annotation> getNote() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Event setNote(List<Annotation> theNote) throws FHIRException;

    /**
     * @return whether there is more than zero values for note
     */
    public boolean hasNote();
    /**
     * @return minimum allowed cardinality for note. Note that with patterns, this may be different for the underlying resource
     */
    public int getNoteMin();
    /**
     * @return maximum allowed cardinality for note. Note that with patterns, this may be different for the underlying resource
     */
    public int getNoteMax();

    public Annotation addNote() throws FHIRException;

    public Event addNote(Annotation t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
     */
    public Annotation getNoteFirstRep() throws FHIRException;

  public String fhirType();


}