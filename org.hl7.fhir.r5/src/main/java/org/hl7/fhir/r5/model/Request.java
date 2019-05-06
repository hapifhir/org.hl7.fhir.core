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

// Generated on Tue, May 7, 2019 08:21+1000 for FHIR v4.1.0

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
    public List<Identifier> getIdentifier();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setIdentifier(List<Identifier> theIdentifier);

    public boolean hasIdentifier();

    public Identifier addIdentifier();

    public Request addIdentifier(Identifier t);

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
    public Request setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical);

    public boolean hasInstantiatesCanonical();

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public CanonicalType addInstantiatesCanonicalElement();

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Request addInstantiatesCanonical(String value);

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
    public Request setInstantiatesUri(List<UriType> theInstantiatesUri);

    public boolean hasInstantiatesUri();

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public UriType addInstantiatesUriElement();

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this {{title}}.)
     */
    public Request addInstantiatesUri(String value);

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
    public Request setBasedOn(List<Reference> theBasedOn);

    public boolean hasBasedOn();

    public Reference addBasedOn();

    public Request addBasedOn(Reference t);

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
     */
    public Reference getBasedOnFirstRep() ;

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new {{title}}.)
     */
    public List<Reference> getReplaces();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReplaces(List<Reference> theReplaces);

    public boolean hasReplaces();

    public Reference addReplaces();

    public Request addReplaces(Reference t);

    /**
     * @return The first repetition of repeating field {@link #replaces}, creating it if it does not already exist
     */
    public Reference getReplacesFirstRep() ;

    /**
     * @return {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Identifier getGroupIdentifier();

    public boolean hasGroupIdentifier();

    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Request setGroupIdentifier(Identifier value);

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement();

    public boolean hasStatusElement();

    public boolean hasStatus();

    /**
     * @param value {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Request setStatusElement(Enumeration<RequestStatus> value) ;

    /**
     * @return The current state of the {{title}}.
     */
    public RequestStatus getStatus();

    /**
     * @param value The current state of the {{title}}.
     */
    public Request setStatus(RequestStatus value);

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public CodeableConcept getStatusReason();

    public boolean hasStatusReason();

    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the {{title}}.)
     */
    public Request setStatusReason(CodeableConcept value);

    /**
     * @return {@link #intent} (Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement();

    public boolean hasIntentElement();

    public boolean hasIntent();

    /**
     * @param value {@link #intent} (Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Request setIntentElement(Enumeration<RequestIntent> value) ;

    /**
     * @return Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.
     */
    public RequestIntent getIntent();

    /**
     * @param value Indicates the level of authority/intentionality associated with the {{title}} and where the request fits into the workflow chain.
     */
    public Request setIntent(RequestIntent value);

    /**
     * @return {@link #priority} (Indicates how quickly the {{title}} should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement();

    public boolean hasPriorityElement();

    public boolean hasPriority();

    /**
     * @param value {@link #priority} (Indicates how quickly the {{title}} should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Request setPriorityElement(Enumeration<RequestPriority> value) ;

    /**
     * @return Indicates how quickly the {{title}} should be addressed with respect to other requests.
     */
    public RequestPriority getPriority();

    /**
     * @param value Indicates how quickly the {{title}} should be addressed with respect to other requests.
     */
    public Request setPriority(RequestPriority value);

    /**
     * @return {@link #doNotPerform} (If true indicates that the {{title}} is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public BooleanType getDoNotPerformElement();

    public boolean hasDoNotPerformElement();

    public boolean hasDoNotPerform();

    /**
     * @param value {@link #doNotPerform} (If true indicates that the {{title}} is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public Request setDoNotPerformElement(BooleanType value) ;

    /**
     * @return If true indicates that the {{title}} is asking for the specified action to *not* occur.
     */
    public boolean getDoNotPerform();

    /**
     * @param value If true indicates that the {{title}} is asking for the specified action to *not* occur.
     */
    public Request setDoNotPerform(boolean value);

    /**
     * @return {@link #code} (A code that identifies the specific service or action being asked to be done (or not done).)
     */
    public CodeableConcept getCode();

    public boolean hasCode();

    /**
     * @param value {@link #code} (A code that identifies the specific service or action being asked to be done (or not done).)
     */
    public Request setCode(CodeableConcept value);

    /**
     * @return {@link #subject} (The individual or set of individuals the action is to be performed/not performed on or for.)
     */
    public Reference getSubject();

    public boolean hasSubject();

    /**
     * @param value {@link #subject} (The individual or set of individuals the action is to be performed/not performed on or for.)
     */
    public Request setSubject(Reference value);

    /**
     * @return {@link #subject} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The individual or set of individuals the action is to be performed/not performed on or for.)
     */
    public Resource getSubjectTarget();

    /**
     * @param value {@link #subject} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The individual or set of individuals the action is to be performed/not performed on or for.)
     */
    public Request setSubjectTarget(Resource value);

    /**
     * @return {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter();

    public boolean hasEncounter();

    /**
     * @param value {@link #encounter} (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Request setEncounter(Reference value);

    /**
     * @return {@link #encounter} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Encounter getEncounterTarget();

    /**
     * @param value {@link #encounter} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The Encounter during which this {{title}} was created or to which the creation of this record is tightly associated.)
     */
    public Request setEncounterTarget(Encounter value);

    /**
     * @return {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public Type getOccurrence();

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

    public boolean hasOccurrence();

    /**
     * @param value {@link #occurrence} (The date or time(s) at which the activity or service is desired to occur or not occur.)
     */
    public Request setOccurrence(Type value);

    /**
     * @return {@link #authoredOn} (For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement();

    public boolean hasAuthoredOnElement();

    public boolean hasAuthoredOn();

    /**
     * @param value {@link #authoredOn} (For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public Request setAuthoredOnElement(DateTimeType value) ;

    /**
     * @return For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public Date getAuthoredOn();

    /**
     * @param value For draft {{title}}s, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public Request setAuthoredOn(Date value);

    /**
     * @return {@link #requester} (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Reference getRequester();

    public boolean hasRequester();

    /**
     * @param value {@link #requester} (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Request setRequester(Reference value);

    /**
     * @return {@link #requester} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Resource getRequesterTarget();

    /**
     * @param value {@link #requester} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Who initiated the {{request}} and has responsibility for its activation.)
     */
    public Request setRequesterTarget(Resource value);

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
    public Request setReported(Type value);

    /**
     * @return {@link #performerType} (The type of individual that is desired to act upon/ not act upon the {{request}}.)
     */
    public CodeableConcept getPerformerType();

    public boolean hasPerformerType();

    /**
     * @param value {@link #performerType} (The type of individual that is desired to act upon/ not act upon the {{request}}.)
     */
    public Request setPerformerType(CodeableConcept value);

    /**
     * @return {@link #performer} (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Reference getPerformer();

    public boolean hasPerformer();

    /**
     * @param value {@link #performer} (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Request setPerformer(Reference value);

    /**
     * @return {@link #performer} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Resource getPerformerTarget();

    /**
     * @param value {@link #performer} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Indicates who or what is being asked to perform (or not perform) the {{request}}.)
     */
    public Request setPerformerTarget(Resource value);

    /**
     * @return {@link #reasonCode} (Describes why the request is being made in coded or textual form.)
     */
    public List<CodeableConcept> getReasonCode();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReasonCode(List<CodeableConcept> theReasonCode);

    public boolean hasReasonCode();

    public CodeableConcept addReasonCode();

    public Request addReasonCode(CodeableConcept t);

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() ;

    /**
     * @return {@link #reasonReference} (Indicates another resource whose existence justifies this request.)
     */
    public List<Reference> getReasonReference();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setReasonReference(List<Reference> theReasonReference);

    public boolean hasReasonReference();

    public Reference addReasonReference();

    public Request addReasonReference(Reference t);

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() ;

    /**
     * @return {@link #insurance} (Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant in delivering the requested service.)
     */
    public List<Reference> getInsurance();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setInsurance(List<Reference> theInsurance);

    public boolean hasInsurance();

    public Reference addInsurance();

    public Request addInsurance(Reference t);

    /**
     * @return The first repetition of repeating field {@link #insurance}, creating it if it does not already exist
     */
    public Reference getInsuranceFirstRep() ;

    /**
     * @return {@link #supportingInfo} (Information that may be needed by/relevant to the performer in their execution of this {{title}}.)
     */
    public List<Reference> getSupportingInfo();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setSupportingInfo(List<Reference> theSupportingInfo);

    public boolean hasSupportingInfo();

    public Reference addSupportingInfo();

    public Request addSupportingInfo(Reference t);

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist
     */
    public Reference getSupportingInfoFirstRep() ;

    /**
     * @return {@link #note} (Comments made about the {{title}} by the requester, performer, subject or other participants.)
     */
    public List<Annotation> getNote();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setNote(List<Annotation> theNote);

    public boolean hasNote();

    public Annotation addNote();

    public Request addNote(Annotation t);

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
     */
    public Annotation getNoteFirstRep() ;

    /**
     * @return {@link #relevantHistory} (Links to Provenance records for past versions of this resource or fulfilling request or event resources that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the resource.)
     */
    public List<Reference> getRelevantHistory();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Request setRelevantHistory(List<Reference> theRelevantHistory);

    public boolean hasRelevantHistory();

    public Reference addRelevantHistory();

    public Request addRelevantHistory(Reference t);

    /**
     * @return The first repetition of repeating field {@link #relevantHistory}, creating it if it does not already exist
     */
    public Reference getRelevantHistoryFirstRep() ;

  public String fhirType();


}

