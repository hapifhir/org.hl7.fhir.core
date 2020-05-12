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
 * A pattern to be followed by resources that represent a specific proposal, plan and/or order for some sort of action or service.
 */
public interface Request extends PatternBase {

    public enum RequestStatus {
        /**
         * The request has been created but is not yet complete or ready for action.
         */
        DRAFT, 
        /**
         * The request is in force and ready to be acted upon.
         */
        ACTIVE, 
        /**
         * The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in the future.
         */
        ONHOLD, 
        /**
         * The request (and any implicit authorization to act) has been terminated prior to the known full completion of the intended actions.  No further activity should occur.
         */
        REVOKED, 
        /**
         * The activity described by the request has been fully performed.  No further activity will occur.
         */
        COMPLETED, 
        /**
         * This request should never have existed and should be considered 'void'.  (It is possible that real-world decisions were based on it.  If real-world activity has occurred, the status should be "cancelled" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this request.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RequestStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("revoked".equals(codeString))
          return REVOKED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RequestStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case ONHOLD: return "on-hold";
            case REVOKED: return "revoked";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/request-status";
            case ACTIVE: return "http://hl7.org/fhir/request-status";
            case ONHOLD: return "http://hl7.org/fhir/request-status";
            case REVOKED: return "http://hl7.org/fhir/request-status";
            case COMPLETED: return "http://hl7.org/fhir/request-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/request-status";
            case UNKNOWN: return "http://hl7.org/fhir/request-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "The request has been created but is not yet complete or ready for action.";
            case ACTIVE: return "The request is in force and ready to be acted upon.";
            case ONHOLD: return "The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in the future.";
            case REVOKED: return "The request (and any implicit authorization to act) has been terminated prior to the known full completion of the intended actions.  No further activity should occur.";
            case COMPLETED: return "The activity described by the request has been fully performed.  No further activity will occur.";
            case ENTEREDINERROR: return "This request should never have existed and should be considered 'void'.  (It is possible that real-world decisions were based on it.  If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this request.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case ONHOLD: return "On Hold";
            case REVOKED: return "Revoked";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            default: return "?";
          }
        }
    }

  public class RequestStatusEnumFactory implements EnumFactory<RequestStatus> {
    public RequestStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return RequestStatus.DRAFT;
        if ("active".equals(codeString))
          return RequestStatus.ACTIVE;
        if ("on-hold".equals(codeString))
          return RequestStatus.ONHOLD;
        if ("revoked".equals(codeString))
          return RequestStatus.REVOKED;
        if ("completed".equals(codeString))
          return RequestStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return RequestStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return RequestStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown RequestStatus code '"+codeString+"'");
        }
        public Enumeration<RequestStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ACTIVE);
        if ("on-hold".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ONHOLD);
        if ("revoked".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.REVOKED);
        if ("completed".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.UNKNOWN);
        throw new FHIRException("Unknown RequestStatus code '"+codeString+"'");
        }
    public String toCode(RequestStatus code) {
      if (code == RequestStatus.DRAFT)
        return "draft";
      if (code == RequestStatus.ACTIVE)
        return "active";
      if (code == RequestStatus.ONHOLD)
        return "on-hold";
      if (code == RequestStatus.REVOKED)
        return "revoked";
      if (code == RequestStatus.COMPLETED)
        return "completed";
      if (code == RequestStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == RequestStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(RequestStatus code) {
      return code.getSystem();
      }
    }

    public enum RequestIntent {
        /**
         * The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.
         */
        PROPOSAL, 
        /**
         * The request represents an intention to ensure something occurs without providing an authorization for others to act.
         */
        PLAN, 
        /**
         * The request represents a legally binding instruction authored by a Patient or RelatedPerson.
         */
        DIRECTIVE, 
        /**
         * The request represents a request/demand and authorization for action by a Practitioner.
         */
        ORDER, 
        /**
         * The request represents an original authorization for action.
         */
        ORIGINALORDER, 
        /**
         * The request represents an automatically generated supplemental authorization for action based on a parent authorization together with initial results of the action taken against that parent authorization.
         */
        REFLEXORDER, 
        /**
         * The request represents the view of an authorization instantiated by a fulfilling system representing the details of the fulfiller's intention to act upon a submitted order.
         */
        FILLERORDER, 
        /**
         * An order created in fulfillment of a broader order that represents the authorization for a single activity occurrence.  E.g. The administration of a single dose of a drug.
         */
        INSTANCEORDER, 
        /**
         * The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.
         */
        OPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RequestIntent fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return PROPOSAL;
        if ("plan".equals(codeString))
          return PLAN;
        if ("directive".equals(codeString))
          return DIRECTIVE;
        if ("order".equals(codeString))
          return ORDER;
        if ("original-order".equals(codeString))
          return ORIGINALORDER;
        if ("reflex-order".equals(codeString))
          return REFLEXORDER;
        if ("filler-order".equals(codeString))
          return FILLERORDER;
        if ("instance-order".equals(codeString))
          return INSTANCEORDER;
        if ("option".equals(codeString))
          return OPTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RequestIntent code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROPOSAL: return "proposal";
            case PLAN: return "plan";
            case DIRECTIVE: return "directive";
            case ORDER: return "order";
            case ORIGINALORDER: return "original-order";
            case REFLEXORDER: return "reflex-order";
            case FILLERORDER: return "filler-order";
            case INSTANCEORDER: return "instance-order";
            case OPTION: return "option";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PROPOSAL: return "http://hl7.org/fhir/request-intent";
            case PLAN: return "http://hl7.org/fhir/request-intent";
            case DIRECTIVE: return "http://hl7.org/fhir/request-intent";
            case ORDER: return "http://hl7.org/fhir/request-intent";
            case ORIGINALORDER: return "http://hl7.org/fhir/request-intent";
            case REFLEXORDER: return "http://hl7.org/fhir/request-intent";
            case FILLERORDER: return "http://hl7.org/fhir/request-intent";
            case INSTANCEORDER: return "http://hl7.org/fhir/request-intent";
            case OPTION: return "http://hl7.org/fhir/request-intent";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PROPOSAL: return "The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.";
            case PLAN: return "The request represents an intention to ensure something occurs without providing an authorization for others to act.";
            case DIRECTIVE: return "The request represents a legally binding instruction authored by a Patient or RelatedPerson.";
            case ORDER: return "The request represents a request/demand and authorization for action by a Practitioner.";
            case ORIGINALORDER: return "The request represents an original authorization for action.";
            case REFLEXORDER: return "The request represents an automatically generated supplemental authorization for action based on a parent authorization together with initial results of the action taken against that parent authorization.";
            case FILLERORDER: return "The request represents the view of an authorization instantiated by a fulfilling system representing the details of the fulfiller's intention to act upon a submitted order.";
            case INSTANCEORDER: return "An order created in fulfillment of a broader order that represents the authorization for a single activity occurrence.  E.g. The administration of a single dose of a drug.";
            case OPTION: return "The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROPOSAL: return "Proposal";
            case PLAN: return "Plan";
            case DIRECTIVE: return "Directive";
            case ORDER: return "Order";
            case ORIGINALORDER: return "Original Order";
            case REFLEXORDER: return "Reflex Order";
            case FILLERORDER: return "Filler Order";
            case INSTANCEORDER: return "Instance Order";
            case OPTION: return "Option";
            default: return "?";
          }
        }
    }

  public class RequestIntentEnumFactory implements EnumFactory<RequestIntent> {
    public RequestIntent fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return RequestIntent.PROPOSAL;
        if ("plan".equals(codeString))
          return RequestIntent.PLAN;
        if ("directive".equals(codeString))
          return RequestIntent.DIRECTIVE;
        if ("order".equals(codeString))
          return RequestIntent.ORDER;
        if ("original-order".equals(codeString))
          return RequestIntent.ORIGINALORDER;
        if ("reflex-order".equals(codeString))
          return RequestIntent.REFLEXORDER;
        if ("filler-order".equals(codeString))
          return RequestIntent.FILLERORDER;
        if ("instance-order".equals(codeString))
          return RequestIntent.INSTANCEORDER;
        if ("option".equals(codeString))
          return RequestIntent.OPTION;
        throw new IllegalArgumentException("Unknown RequestIntent code '"+codeString+"'");
        }
        public Enumeration<RequestIntent> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestIntent>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("proposal".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.PROPOSAL);
        if ("plan".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.PLAN);
        if ("directive".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.DIRECTIVE);
        if ("order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.ORDER);
        if ("original-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.ORIGINALORDER);
        if ("reflex-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.REFLEXORDER);
        if ("filler-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.FILLERORDER);
        if ("instance-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.INSTANCEORDER);
        if ("option".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.OPTION);
        throw new FHIRException("Unknown RequestIntent code '"+codeString+"'");
        }
    public String toCode(RequestIntent code) {
      if (code == RequestIntent.PROPOSAL)
        return "proposal";
      if (code == RequestIntent.PLAN)
        return "plan";
      if (code == RequestIntent.DIRECTIVE)
        return "directive";
      if (code == RequestIntent.ORDER)
        return "order";
      if (code == RequestIntent.ORIGINALORDER)
        return "original-order";
      if (code == RequestIntent.REFLEXORDER)
        return "reflex-order";
      if (code == RequestIntent.FILLERORDER)
        return "filler-order";
      if (code == RequestIntent.INSTANCEORDER)
        return "instance-order";
      if (code == RequestIntent.OPTION)
        return "option";
      return "?";
      }
    public String toSystem(RequestIntent code) {
      return code.getSystem();
      }
    }

    public enum RequestPriority {
        /**
         * The request has normal priority.
         */
        ROUTINE, 
        /**
         * The request should be actioned promptly - higher priority than routine.
         */
        URGENT, 
        /**
         * The request should be actioned as soon as possible - higher priority than urgent.
         */
        ASAP, 
        /**
         * The request should be actioned immediately - highest possible priority.  E.g. an emergency.
         */
        STAT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RequestPriority fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("routine".equals(codeString))
          return ROUTINE;
        if ("urgent".equals(codeString))
          return URGENT;
        if ("asap".equals(codeString))
          return ASAP;
        if ("stat".equals(codeString))
          return STAT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RequestPriority code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ROUTINE: return "routine";
            case URGENT: return "urgent";
            case ASAP: return "asap";
            case STAT: return "stat";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ROUTINE: return "http://hl7.org/fhir/request-priority";
            case URGENT: return "http://hl7.org/fhir/request-priority";
            case ASAP: return "http://hl7.org/fhir/request-priority";
            case STAT: return "http://hl7.org/fhir/request-priority";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ROUTINE: return "The request has normal priority.";
            case URGENT: return "The request should be actioned promptly - higher priority than routine.";
            case ASAP: return "The request should be actioned as soon as possible - higher priority than urgent.";
            case STAT: return "The request should be actioned immediately - highest possible priority.  E.g. an emergency.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ROUTINE: return "Routine";
            case URGENT: return "Urgent";
            case ASAP: return "ASAP";
            case STAT: return "STAT";
            default: return "?";
          }
        }
    }

  public class RequestPriorityEnumFactory implements EnumFactory<RequestPriority> {
    public RequestPriority fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("routine".equals(codeString))
          return RequestPriority.ROUTINE;
        if ("urgent".equals(codeString))
          return RequestPriority.URGENT;
        if ("asap".equals(codeString))
          return RequestPriority.ASAP;
        if ("stat".equals(codeString))
          return RequestPriority.STAT;
        throw new IllegalArgumentException("Unknown RequestPriority code '"+codeString+"'");
        }
        public Enumeration<RequestPriority> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestPriority>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("routine".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.ROUTINE);
        if ("urgent".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.URGENT);
        if ("asap".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.ASAP);
        if ("stat".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.STAT);
        throw new FHIRException("Unknown RequestPriority code '"+codeString+"'");
        }
    public String toCode(RequestPriority code) {
      if (code == RequestPriority.ROUTINE)
        return "routine";
      if (code == RequestPriority.URGENT)
        return "urgent";
      if (code == RequestPriority.ASAP)
        return "asap";
      if (code == RequestPriority.STAT)
        return "stat";
      return "?";
      }
    public String toSystem(RequestPriority code) {
      return code.getSystem();
      }
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this {{title}} by the author and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setIdentifier(List<Identifier> theIdentifier) throws FHIRException;

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

    public Request addIdentifier(Identifier t) throws FHIRException;

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
    public Request setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) throws FHIRException;

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
    public Request addInstantiatesCanonical(String value) throws FHIRException;

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
    public Request setInstantiatesUri(List<UriType> theInstantiatesUri) throws FHIRException;

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
    public Request addInstantiatesUri(String value) throws FHIRException;

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
    public Request setBasedOn(List<Reference> theBasedOn) throws FHIRException;

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

    public Request addBasedOn(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
     */
    public Reference getBasedOnFirstRep() throws FHIRException;

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new {{title}}.)
     */
    public List<Reference> getReplaces() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReplaces(List<Reference> theReplaces) throws FHIRException;

    /**
     * @return whether there is more than zero values for replaces
     */
    public boolean hasReplaces();
    /**
     * @return minimum allowed cardinality for replaces. Note that with patterns, this may be different for the underlying resource
     */
    public int getReplacesMin();
    /**
     * @return maximum allowed cardinality for replaces. Note that with patterns, this may be different for the underlying resource
     */
    public int getReplacesMax();

    public Reference addReplaces() throws FHIRException;

    public Request addReplaces(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #replaces}, creating it if it does not already exist
     */
    public Reference getReplacesFirstRep() throws FHIRException;

    /**
     * @return {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Identifier getGroupIdentifier() throws FHIRException ;

    /**
     * @return whether there is more than zero values for groupIdentifier
     */
    public boolean hasGroupIdentifier();
    /**
     * @return minimum allowed cardinality for groupIdentifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getGroupIdentifierMin();
    /**
     * @return maximum allowed cardinality for groupIdentifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getGroupIdentifierMax();
    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Request setGroupIdentifier(Identifier value) throws FHIRException;

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() throws FHIRException;

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
    public Request setStatusElement(Enumeration<RequestStatus> value) throws FHIRException;

    /**
     * @return The current state of the {{title}}.
     */
    public RequestStatus getStatus() throws FHIRException;

    /**
     * @param value The current state of the {{title}}.
     */
    public Request setStatus(RequestStatus value) throws FHIRException;

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
    public Request setStatusReason(CodeableConcept value) throws FHIRException;

    /**
     * @return {@link #intent} (Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for intent
     */
    public boolean hasIntent();
    /**
     * @return minimum allowed cardinality for intent. Note that with patterns, this may be different for the underlying resource
     */
    public int getIntentMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for intent. Note that with patterns, this may be different for the underlying resource
     */
    public int getIntentMax() throws FHIRException;
    public boolean hasIntentElement();

    /**
     * @param value {@link #intent} (Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Request setIntentElement(Enumeration<RequestIntent> value) throws FHIRException;

    /**
     * @return Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.
     */
    public RequestIntent getIntent() throws FHIRException;

    /**
     * @param value Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.
     */
    public Request setIntent(RequestIntent value) throws FHIRException;

    /**
     * @return {@link #priority} (Indicates how quickly the {{title}} should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for priority
     */
    public boolean hasPriority();
    /**
     * @return minimum allowed cardinality for priority. Note that with patterns, this may be different for the underlying resource
     */
    public int getPriorityMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for priority. Note that with patterns, this may be different for the underlying resource
     */
    public int getPriorityMax() throws FHIRException;
    public boolean hasPriorityElement();

    /**
     * @param value {@link #priority} (Indicates how quickly the {{title}} should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Request setPriorityElement(Enumeration<RequestPriority> value) throws FHIRException;

    /**
     * @return Indicates how quickly the {{title}} should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() throws FHIRException;

    /**
     * @param value Indicates how quickly the {{title}} should be addressed with respect to other requests.
     */
    public Request setPriority(RequestPriority value) throws FHIRException;

    /**
     * @return {@link #doNotPerform} (If true indicates that the {{title}} is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public BooleanType getDoNotPerformElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for doNotPerform
     */
    public boolean hasDoNotPerform();
    /**
     * @return minimum allowed cardinality for doNotPerform. Note that with patterns, this may be different for the underlying resource
     */
    public int getDoNotPerformMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for doNotPerform. Note that with patterns, this may be different for the underlying resource
     */
    public int getDoNotPerformMax() throws FHIRException;
    public boolean hasDoNotPerformElement();

    /**
     * @param value {@link #doNotPerform} (If true indicates that the {{title}} is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public Request setDoNotPerformElement(BooleanType value) throws FHIRException;

    /**
     * @return If true indicates that the {{title}} is asking for the specified action to *not* occur.
     */
    public boolean getDoNotPerform() throws FHIRException;

    /**
     * @param value If true indicates that the {{title}} is asking for the specified action to *not* occur.
     */
    public Request setDoNotPerform(boolean value) throws FHIRException;

    /**
     * @return {@link #code} (A code that identifies the specific service or action being asked to be done (or not done).)
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
     * @param value {@link #code} (A code that identifies the specific service or action being asked to be done (or not done).)
     */
    public Request setCode(CodeableConcept value) throws FHIRException;

    /**
     * @return {@link #subject} (The individual or set of individuals the action is to be performed/not performed on or for.)
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
     * @param value {@link #subject} (The individual or set of individuals the action is to be performed/not performed on or for.)
     */
    public Request setSubject(Reference value) throws FHIRException;

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
    public Request setEncounter(Reference value) throws FHIRException;

    /**
     * @return {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public DataType getOccurrence() throws FHIRException ;

    /**
     * @return {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException;

    public boolean hasOccurrenceDateTimeType();

    /**
     * @return {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public Period getOccurrencePeriod() throws FHIRException;

    public boolean hasOccurrencePeriod();

    /**
     * @return {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
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
     * @param value {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public Request setOccurrence(DataType value) throws FHIRException;

    /**
     * @return {@link #authoredOn} (For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for authoredOn
     */
    public boolean hasAuthoredOn();
    /**
     * @return minimum allowed cardinality for authoredOn. Note that with patterns, this may be different for the underlying resource
     */
    public int getAuthoredOnMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for authoredOn. Note that with patterns, this may be different for the underlying resource
     */
    public int getAuthoredOnMax() throws FHIRException;
    public boolean hasAuthoredOnElement();

    /**
     * @param value {@link #authoredOn} (For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public Request setAuthoredOnElement(DateTimeType value) throws FHIRException;

    /**
     * @return For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public Date getAuthoredOn() throws FHIRException;

    /**
     * @param value For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public Request setAuthoredOn(Date value) throws FHIRException;

    /**
     * @return {@link #requester} (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Reference getRequester() throws FHIRException ;

    /**
     * @return whether there is more than zero values for requester
     */
    public boolean hasRequester();
    /**
     * @return minimum allowed cardinality for requester. Note that with patterns, this may be different for the underlying resource
     */
    public int getRequesterMin();
    /**
     * @return maximum allowed cardinality for requester. Note that with patterns, this may be different for the underlying resource
     */
    public int getRequesterMax();
    /**
     * @param value {@link #requester} (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Request setRequester(Reference value) throws FHIRException;

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
    public Request setReported(DataType value) throws FHIRException;

    /**
     * @return {@link #performerType} (The type of individual that is desired to act upon/ not act upon the {{request}}.)
     */
    public CodeableConcept getPerformerType() throws FHIRException ;

    /**
     * @return whether there is more than zero values for performerType
     */
    public boolean hasPerformerType();
    /**
     * @return minimum allowed cardinality for performerType. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerTypeMin();
    /**
     * @return maximum allowed cardinality for performerType. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerTypeMax();
    /**
     * @param value {@link #performerType} (The type of individual that is desired to act upon/ not act upon the {{request}}.)
     */
    public Request setPerformerType(CodeableConcept value) throws FHIRException;

    /**
     * @return {@link #performer} (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Reference getPerformer() throws FHIRException ;

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
    /**
     * @param value {@link #performer} (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Request setPerformer(Reference value) throws FHIRException;

    /**
     * @return {@link #reasonCode} (Describes why the request is being made in coded or textual form.)
     */
    public List<CodeableConcept> getReasonCode() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReasonCode(List<CodeableConcept> theReasonCode) throws FHIRException;

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

    public Request addReasonCode(CodeableConcept t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() throws FHIRException;

    /**
     * @return {@link #reasonReference} (Indicates another resource whose existence justifies this request.)
     */
    public List<Reference> getReasonReference() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReasonReference(List<Reference> theReasonReference) throws FHIRException;

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

    public Request addReasonReference(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() throws FHIRException;

    /**
     * @return {@link #insurance} (Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant in delivering the requested service.)
     */
    public List<Reference> getInsurance() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setInsurance(List<Reference> theInsurance) throws FHIRException;

    /**
     * @return whether there is more than zero values for insurance
     */
    public boolean hasInsurance();
    /**
     * @return minimum allowed cardinality for insurance. Note that with patterns, this may be different for the underlying resource
     */
    public int getInsuranceMin();
    /**
     * @return maximum allowed cardinality for insurance. Note that with patterns, this may be different for the underlying resource
     */
    public int getInsuranceMax();

    public Reference addInsurance() throws FHIRException;

    public Request addInsurance(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #insurance}, creating it if it does not already exist
     */
    public Reference getInsuranceFirstRep() throws FHIRException;

    /**
     * @return {@link #supportingInfo} (Information that may be needed by/relevant to the performer in their execution of this {{title}}.)
     */
    public List<Reference> getSupportingInfo() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setSupportingInfo(List<Reference> theSupportingInfo) throws FHIRException;

    /**
     * @return whether there is more than zero values for supportingInfo
     */
    public boolean hasSupportingInfo();
    /**
     * @return minimum allowed cardinality for supportingInfo. Note that with patterns, this may be different for the underlying resource
     */
    public int getSupportingInfoMin();
    /**
     * @return maximum allowed cardinality for supportingInfo. Note that with patterns, this may be different for the underlying resource
     */
    public int getSupportingInfoMax();

    public Reference addSupportingInfo() throws FHIRException;

    public Request addSupportingInfo(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist
     */
    public Reference getSupportingInfoFirstRep() throws FHIRException;

    /**
     * @return {@link #note} (Comments made about the {{title}} by the requester, performer, subject or other participants.)
     */
    public List<Annotation> getNote() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setNote(List<Annotation> theNote) throws FHIRException;

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

    public Request addNote(Annotation t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
     */
    public Annotation getNoteFirstRep() throws FHIRException;

    /**
     * @return {@link #relevantHistory} (Links to Provenance records for past versions of this resource or fulfilling request or event resources that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the resource.)
     */
    public List<Reference> getRelevantHistory() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setRelevantHistory(List<Reference> theRelevantHistory) throws FHIRException;

    /**
     * @return whether there is more than zero values for relevantHistory
     */
    public boolean hasRelevantHistory();
    /**
     * @return minimum allowed cardinality for relevantHistory. Note that with patterns, this may be different for the underlying resource
     */
    public int getRelevantHistoryMin();
    /**
     * @return maximum allowed cardinality for relevantHistory. Note that with patterns, this may be different for the underlying resource
     */
    public int getRelevantHistoryMax();

    public Reference addRelevantHistory() throws FHIRException;

    public Request addRelevantHistory(Reference t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #relevantHistory}, creating it if it does not already exist
     */
    public Reference getRelevantHistoryFirstRep() throws FHIRException;

  public String fhirType();


}