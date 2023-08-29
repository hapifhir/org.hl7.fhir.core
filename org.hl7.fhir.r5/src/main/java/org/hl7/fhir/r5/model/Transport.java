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
 * Record of transport.
 */
@ResourceDef(name="Transport", profile="http://hl7.org/fhir/StructureDefinition/Transport")
public class Transport extends DomainResource {

    public enum TransportIntent {
        /**
         * The intent is not known.  When dealing with Transport, it's not always known (or relevant) how the transport was initiated - i.e. whether it was proposed, planned, ordered or just done spontaneously.
         */
        UNKNOWN, 
        /**
         * The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.
         */
        PROPOSAL, 
        /**
         * The request represents an intention to ensure something occurs without providing an authorization for others to act.
         */
        PLAN, 
        /**
         * The request represents a request/demand and authorization for action by the requestor.
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
         * The request represents a component or option for a RequestOrchestration that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestOrchestration]]] for additional information on how this status is used.
         */
        OPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TransportIntent fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("proposal".equals(codeString))
          return PROPOSAL;
        if ("plan".equals(codeString))
          return PLAN;
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
          throw new FHIRException("Unknown TransportIntent code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case UNKNOWN: return "unknown";
            case PROPOSAL: return "proposal";
            case PLAN: return "plan";
            case ORDER: return "order";
            case ORIGINALORDER: return "original-order";
            case REFLEXORDER: return "reflex-order";
            case FILLERORDER: return "filler-order";
            case INSTANCEORDER: return "instance-order";
            case OPTION: return "option";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case UNKNOWN: return "http://hl7.org/fhir/transport-intent";
            case PROPOSAL: return "http://hl7.org/fhir/request-intent";
            case PLAN: return "http://hl7.org/fhir/request-intent";
            case ORDER: return "http://hl7.org/fhir/request-intent";
            case ORIGINALORDER: return "http://hl7.org/fhir/request-intent";
            case REFLEXORDER: return "http://hl7.org/fhir/request-intent";
            case FILLERORDER: return "http://hl7.org/fhir/request-intent";
            case INSTANCEORDER: return "http://hl7.org/fhir/request-intent";
            case OPTION: return "http://hl7.org/fhir/request-intent";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case UNKNOWN: return "The intent is not known.  When dealing with Transport, it's not always known (or relevant) how the transport was initiated - i.e. whether it was proposed, planned, ordered or just done spontaneously.";
            case PROPOSAL: return "The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.";
            case PLAN: return "The request represents an intention to ensure something occurs without providing an authorization for others to act.";
            case ORDER: return "The request represents a request/demand and authorization for action by the requestor.";
            case ORIGINALORDER: return "The request represents an original authorization for action.";
            case REFLEXORDER: return "The request represents an automatically generated supplemental authorization for action based on a parent authorization together with initial results of the action taken against that parent authorization.";
            case FILLERORDER: return "The request represents the view of an authorization instantiated by a fulfilling system representing the details of the fulfiller's intention to act upon a submitted order.";
            case INSTANCEORDER: return "An order created in fulfillment of a broader order that represents the authorization for a single activity occurrence.  E.g. The administration of a single dose of a drug.";
            case OPTION: return "The request represents a component or option for a RequestOrchestration that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestOrchestration]]] for additional information on how this status is used.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case UNKNOWN: return "Unknown";
            case PROPOSAL: return "Proposal";
            case PLAN: return "Plan";
            case ORDER: return "Order";
            case ORIGINALORDER: return "Original Order";
            case REFLEXORDER: return "Reflex Order";
            case FILLERORDER: return "Filler Order";
            case INSTANCEORDER: return "Instance Order";
            case OPTION: return "Option";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class TransportIntentEnumFactory implements EnumFactory<TransportIntent> {
    public TransportIntent fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("unknown".equals(codeString))
          return TransportIntent.UNKNOWN;
        if ("proposal".equals(codeString))
          return TransportIntent.PROPOSAL;
        if ("plan".equals(codeString))
          return TransportIntent.PLAN;
        if ("order".equals(codeString))
          return TransportIntent.ORDER;
        if ("original-order".equals(codeString))
          return TransportIntent.ORIGINALORDER;
        if ("reflex-order".equals(codeString))
          return TransportIntent.REFLEXORDER;
        if ("filler-order".equals(codeString))
          return TransportIntent.FILLERORDER;
        if ("instance-order".equals(codeString))
          return TransportIntent.INSTANCEORDER;
        if ("option".equals(codeString))
          return TransportIntent.OPTION;
        throw new IllegalArgumentException("Unknown TransportIntent code '"+codeString+"'");
        }
        public Enumeration<TransportIntent> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TransportIntent>(this, TransportIntent.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<TransportIntent>(this, TransportIntent.NULL, code);
        if ("unknown".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.UNKNOWN, code);
        if ("proposal".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.PROPOSAL, code);
        if ("plan".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.PLAN, code);
        if ("order".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.ORDER, code);
        if ("original-order".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.ORIGINALORDER, code);
        if ("reflex-order".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.REFLEXORDER, code);
        if ("filler-order".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.FILLERORDER, code);
        if ("instance-order".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.INSTANCEORDER, code);
        if ("option".equals(codeString))
          return new Enumeration<TransportIntent>(this, TransportIntent.OPTION, code);
        throw new FHIRException("Unknown TransportIntent code '"+codeString+"'");
        }
    public String toCode(TransportIntent code) {
      if (code == TransportIntent.UNKNOWN)
        return "unknown";
      if (code == TransportIntent.PROPOSAL)
        return "proposal";
      if (code == TransportIntent.PLAN)
        return "plan";
      if (code == TransportIntent.ORDER)
        return "order";
      if (code == TransportIntent.ORIGINALORDER)
        return "original-order";
      if (code == TransportIntent.REFLEXORDER)
        return "reflex-order";
      if (code == TransportIntent.FILLERORDER)
        return "filler-order";
      if (code == TransportIntent.INSTANCEORDER)
        return "instance-order";
      if (code == TransportIntent.OPTION)
        return "option";
      return "?";
      }
    public String toSystem(TransportIntent code) {
      return code.getSystem();
      }
    }

    public enum TransportStatus {
        /**
         * Transport has started but not completed.
         */
        INPROGRESS, 
        /**
         * Transport has been completed.
         */
        COMPLETED, 
        /**
         * Transport was started but not completed.
         */
        ABANDONED, 
        /**
         * Transport was cancelled before started.
         */
        CANCELLED, 
        /**
         * Planned transport that is not yet requested.
         */
        PLANNED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"abandoned\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TransportStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("abandoned".equals(codeString))
          return ABANDONED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("planned".equals(codeString))
          return PLANNED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TransportStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INPROGRESS: return "in-progress";
            case COMPLETED: return "completed";
            case ABANDONED: return "abandoned";
            case CANCELLED: return "cancelled";
            case PLANNED: return "planned";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INPROGRESS: return "http://hl7.org/fhir/transport-status";
            case COMPLETED: return "http://hl7.org/fhir/transport-status";
            case ABANDONED: return "http://hl7.org/fhir/transport-status";
            case CANCELLED: return "http://hl7.org/fhir/transport-status";
            case PLANNED: return "http://hl7.org/fhir/transport-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/transport-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INPROGRESS: return "Transport has started but not completed.";
            case COMPLETED: return "Transport has been completed.";
            case ABANDONED: return "Transport was started but not completed.";
            case CANCELLED: return "Transport was cancelled before started.";
            case PLANNED: return "Planned transport that is not yet requested.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"abandoned\" rather than \"entered-in-error\".).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INPROGRESS: return "In Progress";
            case COMPLETED: return "Completed";
            case ABANDONED: return "Abandoned";
            case CANCELLED: return "Cancelled";
            case PLANNED: return "Planned";
            case ENTEREDINERROR: return "Entered In Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class TransportStatusEnumFactory implements EnumFactory<TransportStatus> {
    public TransportStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return TransportStatus.INPROGRESS;
        if ("completed".equals(codeString))
          return TransportStatus.COMPLETED;
        if ("abandoned".equals(codeString))
          return TransportStatus.ABANDONED;
        if ("cancelled".equals(codeString))
          return TransportStatus.CANCELLED;
        if ("planned".equals(codeString))
          return TransportStatus.PLANNED;
        if ("entered-in-error".equals(codeString))
          return TransportStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown TransportStatus code '"+codeString+"'");
        }
        public Enumeration<TransportStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TransportStatus>(this, TransportStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<TransportStatus>(this, TransportStatus.NULL, code);
        if ("in-progress".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.INPROGRESS, code);
        if ("completed".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.COMPLETED, code);
        if ("abandoned".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.ABANDONED, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.CANCELLED, code);
        if ("planned".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.PLANNED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<TransportStatus>(this, TransportStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown TransportStatus code '"+codeString+"'");
        }
    public String toCode(TransportStatus code) {
      if (code == TransportStatus.INPROGRESS)
        return "in-progress";
      if (code == TransportStatus.COMPLETED)
        return "completed";
      if (code == TransportStatus.ABANDONED)
        return "abandoned";
      if (code == TransportStatus.CANCELLED)
        return "cancelled";
      if (code == TransportStatus.PLANNED)
        return "planned";
      if (code == TransportStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(TransportStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class TransportRestrictionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates the number of times the requested action should occur.
         */
        @Child(name = "repetitions", type = {PositiveIntType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="How many times to repeat", formalDefinition="Indicates the number of times the requested action should occur." )
        protected PositiveIntType repetitions;

        /**
         * Over what time-period is fulfillment sought.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When fulfillment sought", formalDefinition="Over what time-period is fulfillment sought." )
        protected Period period;

        /**
         * For requests that are targeted to more than one potential recipient/target, to identify who is fulfillment is sought for.
         */
        @Child(name = "recipient", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Group.class, Organization.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="For whom is fulfillment sought?", formalDefinition="For requests that are targeted to more than one potential recipient/target, to identify who is fulfillment is sought for." )
        protected List<Reference> recipient;

        private static final long serialVersionUID = 1673996066L;

    /**
     * Constructor
     */
      public TransportRestrictionComponent() {
        super();
      }

        /**
         * @return {@link #repetitions} (Indicates the number of times the requested action should occur.). This is the underlying object with id, value and extensions. The accessor "getRepetitions" gives direct access to the value
         */
        public PositiveIntType getRepetitionsElement() { 
          if (this.repetitions == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TransportRestrictionComponent.repetitions");
            else if (Configuration.doAutoCreate())
              this.repetitions = new PositiveIntType(); // bb
          return this.repetitions;
        }

        public boolean hasRepetitionsElement() { 
          return this.repetitions != null && !this.repetitions.isEmpty();
        }

        public boolean hasRepetitions() { 
          return this.repetitions != null && !this.repetitions.isEmpty();
        }

        /**
         * @param value {@link #repetitions} (Indicates the number of times the requested action should occur.). This is the underlying object with id, value and extensions. The accessor "getRepetitions" gives direct access to the value
         */
        public TransportRestrictionComponent setRepetitionsElement(PositiveIntType value) { 
          this.repetitions = value;
          return this;
        }

        /**
         * @return Indicates the number of times the requested action should occur.
         */
        public int getRepetitions() { 
          return this.repetitions == null || this.repetitions.isEmpty() ? 0 : this.repetitions.getValue();
        }

        /**
         * @param value Indicates the number of times the requested action should occur.
         */
        public TransportRestrictionComponent setRepetitions(int value) { 
            if (this.repetitions == null)
              this.repetitions = new PositiveIntType();
            this.repetitions.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (Over what time-period is fulfillment sought.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TransportRestrictionComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Over what time-period is fulfillment sought.)
         */
        public TransportRestrictionComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #recipient} (For requests that are targeted to more than one potential recipient/target, to identify who is fulfillment is sought for.)
         */
        public List<Reference> getRecipient() { 
          if (this.recipient == null)
            this.recipient = new ArrayList<Reference>();
          return this.recipient;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TransportRestrictionComponent setRecipient(List<Reference> theRecipient) { 
          this.recipient = theRecipient;
          return this;
        }

        public boolean hasRecipient() { 
          if (this.recipient == null)
            return false;
          for (Reference item : this.recipient)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addRecipient() { //3
          Reference t = new Reference();
          if (this.recipient == null)
            this.recipient = new ArrayList<Reference>();
          this.recipient.add(t);
          return t;
        }

        public TransportRestrictionComponent addRecipient(Reference t) { //3
          if (t == null)
            return this;
          if (this.recipient == null)
            this.recipient = new ArrayList<Reference>();
          this.recipient.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #recipient}, creating it if it does not already exist {3}
         */
        public Reference getRecipientFirstRep() { 
          if (getRecipient().isEmpty()) {
            addRecipient();
          }
          return getRecipient().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("repetitions", "positiveInt", "Indicates the number of times the requested action should occur.", 0, 1, repetitions));
          children.add(new Property("period", "Period", "Over what time-period is fulfillment sought.", 0, 1, period));
          children.add(new Property("recipient", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Group|Organization)", "For requests that are targeted to more than one potential recipient/target, to identify who is fulfillment is sought for.", 0, java.lang.Integer.MAX_VALUE, recipient));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 984367650: /*repetitions*/  return new Property("repetitions", "positiveInt", "Indicates the number of times the requested action should occur.", 0, 1, repetitions);
          case -991726143: /*period*/  return new Property("period", "Period", "Over what time-period is fulfillment sought.", 0, 1, period);
          case 820081177: /*recipient*/  return new Property("recipient", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Group|Organization)", "For requests that are targeted to more than one potential recipient/target, to identify who is fulfillment is sought for.", 0, java.lang.Integer.MAX_VALUE, recipient);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 984367650: /*repetitions*/ return this.repetitions == null ? new Base[0] : new Base[] {this.repetitions}; // PositiveIntType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 820081177: /*recipient*/ return this.recipient == null ? new Base[0] : this.recipient.toArray(new Base[this.recipient.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 984367650: // repetitions
          this.repetitions = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 820081177: // recipient
          this.getRecipient().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("repetitions")) {
          this.repetitions = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("recipient")) {
          this.getRecipient().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 984367650:  return getRepetitionsElement();
        case -991726143:  return getPeriod();
        case 820081177:  return addRecipient(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 984367650: /*repetitions*/ return new String[] {"positiveInt"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 820081177: /*recipient*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("repetitions")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.restriction.repetitions");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("recipient")) {
          return addRecipient();
        }
        else
          return super.addChild(name);
      }

      public TransportRestrictionComponent copy() {
        TransportRestrictionComponent dst = new TransportRestrictionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TransportRestrictionComponent dst) {
        super.copyValues(dst);
        dst.repetitions = repetitions == null ? null : repetitions.copy();
        dst.period = period == null ? null : period.copy();
        if (recipient != null) {
          dst.recipient = new ArrayList<Reference>();
          for (Reference i : recipient)
            dst.recipient.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TransportRestrictionComponent))
          return false;
        TransportRestrictionComponent o = (TransportRestrictionComponent) other_;
        return compareDeep(repetitions, o.repetitions, true) && compareDeep(period, o.period, true) && compareDeep(recipient, o.recipient, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TransportRestrictionComponent))
          return false;
        TransportRestrictionComponent o = (TransportRestrictionComponent) other_;
        return compareValues(repetitions, o.repetitions, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(repetitions, period, recipient
          );
      }

  public String fhirType() {
    return "Transport.restriction";

  }

  }

    @Block()
    public static class ParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code or description indicating how the input is intended to be used as part of the transport execution.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for the input", formalDefinition="A code or description indicating how the input is intended to be used as part of the transport execution." )
        protected CodeableConcept type;

        /**
         * The value of the input parameter as a basic type.
         */
        @Child(name = "value", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, CodeableReference.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, RatioRange.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Availability.class, ExtendedContactDetail.class, Dosage.class, Meta.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Content to use in performing the transport", formalDefinition="The value of the input parameter as a basic type." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public ParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ParameterComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (A code or description indicating how the input is intended to be used as part of the transport execution.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ParameterComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code or description indicating how the input is intended to be used as part of the transport execution.)
         */
        public ParameterComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Base64BinaryType getValueBase64BinaryType() throws FHIRException { 
          if (this.value == null)
            this.value = new Base64BinaryType();
          if (!(this.value instanceof Base64BinaryType))
            throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Base64BinaryType) this.value;
        }

        public boolean hasValueBase64BinaryType() { 
          return this != null && this.value instanceof Base64BinaryType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public CanonicalType getValueCanonicalType() throws FHIRException { 
          if (this.value == null)
            this.value = new CanonicalType();
          if (!(this.value instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CanonicalType) this.value;
        }

        public boolean hasValueCanonicalType() { 
          return this != null && this.value instanceof CanonicalType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public CodeType getValueCodeType() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeType();
          if (!(this.value instanceof CodeType))
            throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeType) this.value;
        }

        public boolean hasValueCodeType() { 
          return this != null && this.value instanceof CodeType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public DateType getValueDateType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateType();
          if (!(this.value instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateType) this.value;
        }

        public boolean hasValueDateType() { 
          return this != null && this.value instanceof DateType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() { 
          return this != null && this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public DecimalType getValueDecimalType() throws FHIRException { 
          if (this.value == null)
            this.value = new DecimalType();
          if (!(this.value instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DecimalType) this.value;
        }

        public boolean hasValueDecimalType() { 
          return this != null && this.value instanceof DecimalType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public IdType getValueIdType() throws FHIRException { 
          if (this.value == null)
            this.value = new IdType();
          if (!(this.value instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IdType) this.value;
        }

        public boolean hasValueIdType() { 
          return this != null && this.value instanceof IdType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public InstantType getValueInstantType() throws FHIRException { 
          if (this.value == null)
            this.value = new InstantType();
          if (!(this.value instanceof InstantType))
            throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (InstantType) this.value;
        }

        public boolean hasValueInstantType() { 
          return this != null && this.value instanceof InstantType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Integer64Type getValueInteger64Type() throws FHIRException { 
          if (this.value == null)
            this.value = new Integer64Type();
          if (!(this.value instanceof Integer64Type))
            throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Integer64Type) this.value;
        }

        public boolean hasValueInteger64Type() { 
          return this != null && this.value instanceof Integer64Type;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public MarkdownType getValueMarkdownType() throws FHIRException { 
          if (this.value == null)
            this.value = new MarkdownType();
          if (!(this.value instanceof MarkdownType))
            throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (MarkdownType) this.value;
        }

        public boolean hasValueMarkdownType() { 
          return this != null && this.value instanceof MarkdownType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public OidType getValueOidType() throws FHIRException { 
          if (this.value == null)
            this.value = new OidType();
          if (!(this.value instanceof OidType))
            throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (OidType) this.value;
        }

        public boolean hasValueOidType() { 
          return this != null && this.value instanceof OidType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public PositiveIntType getValuePositiveIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new PositiveIntType();
          if (!(this.value instanceof PositiveIntType))
            throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (PositiveIntType) this.value;
        }

        public boolean hasValuePositiveIntType() { 
          return this != null && this.value instanceof PositiveIntType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public TimeType getValueTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new TimeType();
          if (!(this.value instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TimeType) this.value;
        }

        public boolean hasValueTimeType() { 
          return this != null && this.value instanceof TimeType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public UnsignedIntType getValueUnsignedIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new UnsignedIntType();
          if (!(this.value instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.value;
        }

        public boolean hasValueUnsignedIntType() { 
          return this != null && this.value instanceof UnsignedIntType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() { 
          return this != null && this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public UrlType getValueUrlType() throws FHIRException { 
          if (this.value == null)
            this.value = new UrlType();
          if (!(this.value instanceof UrlType))
            throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UrlType) this.value;
        }

        public boolean hasValueUrlType() { 
          return this != null && this.value instanceof UrlType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public UuidType getValueUuidType() throws FHIRException { 
          if (this.value == null)
            this.value = new UuidType();
          if (!(this.value instanceof UuidType))
            throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UuidType) this.value;
        }

        public boolean hasValueUuidType() { 
          return this != null && this.value instanceof UuidType;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Address getValueAddress() throws FHIRException { 
          if (this.value == null)
            this.value = new Address();
          if (!(this.value instanceof Address))
            throw new FHIRException("Type mismatch: the type Address was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Address) this.value;
        }

        public boolean hasValueAddress() { 
          return this != null && this.value instanceof Address;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Age getValueAge() throws FHIRException { 
          if (this.value == null)
            this.value = new Age();
          if (!(this.value instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Age) this.value;
        }

        public boolean hasValueAge() { 
          return this != null && this.value instanceof Age;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Annotation getValueAnnotation() throws FHIRException { 
          if (this.value == null)
            this.value = new Annotation();
          if (!(this.value instanceof Annotation))
            throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Annotation) this.value;
        }

        public boolean hasValueAnnotation() { 
          return this != null && this.value instanceof Annotation;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public CodeableReference getValueCodeableReference() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableReference();
          if (!(this.value instanceof CodeableReference))
            throw new FHIRException("Type mismatch: the type CodeableReference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableReference) this.value;
        }

        public boolean hasValueCodeableReference() { 
          return this != null && this.value instanceof CodeableReference;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() { 
          return this != null && this.value instanceof Coding;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public ContactPoint getValueContactPoint() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactPoint();
          if (!(this.value instanceof ContactPoint))
            throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactPoint) this.value;
        }

        public boolean hasValueContactPoint() { 
          return this != null && this.value instanceof ContactPoint;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Count getValueCount() throws FHIRException { 
          if (this.value == null)
            this.value = new Count();
          if (!(this.value instanceof Count))
            throw new FHIRException("Type mismatch: the type Count was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Count) this.value;
        }

        public boolean hasValueCount() { 
          return this != null && this.value instanceof Count;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Distance getValueDistance() throws FHIRException { 
          if (this.value == null)
            this.value = new Distance();
          if (!(this.value instanceof Distance))
            throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Distance) this.value;
        }

        public boolean hasValueDistance() { 
          return this != null && this.value instanceof Distance;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Duration getValueDuration() throws FHIRException { 
          if (this.value == null)
            this.value = new Duration();
          if (!(this.value instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Duration) this.value;
        }

        public boolean hasValueDuration() { 
          return this != null && this.value instanceof Duration;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public HumanName getValueHumanName() throws FHIRException { 
          if (this.value == null)
            this.value = new HumanName();
          if (!(this.value instanceof HumanName))
            throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.value.getClass().getName()+" was encountered");
          return (HumanName) this.value;
        }

        public boolean hasValueHumanName() { 
          return this != null && this.value instanceof HumanName;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Identifier getValueIdentifier() throws FHIRException { 
          if (this.value == null)
            this.value = new Identifier();
          if (!(this.value instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Identifier) this.value;
        }

        public boolean hasValueIdentifier() { 
          return this != null && this.value instanceof Identifier;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Money getValueMoney() throws FHIRException { 
          if (this.value == null)
            this.value = new Money();
          if (!(this.value instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Money) this.value;
        }

        public boolean hasValueMoney() { 
          return this != null && this.value instanceof Money;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Period getValuePeriod() throws FHIRException { 
          if (this.value == null)
            this.value = new Period();
          if (!(this.value instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Period) this.value;
        }

        public boolean hasValuePeriod() { 
          return this != null && this.value instanceof Period;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Ratio getValueRatio() throws FHIRException { 
          if (this.value == null)
            this.value = new Ratio();
          if (!(this.value instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Ratio) this.value;
        }

        public boolean hasValueRatio() { 
          return this != null && this.value instanceof Ratio;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public RatioRange getValueRatioRange() throws FHIRException { 
          if (this.value == null)
            this.value = new RatioRange();
          if (!(this.value instanceof RatioRange))
            throw new FHIRException("Type mismatch: the type RatioRange was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RatioRange) this.value;
        }

        public boolean hasValueRatioRange() { 
          return this != null && this.value instanceof RatioRange;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public SampledData getValueSampledData() throws FHIRException { 
          if (this.value == null)
            this.value = new SampledData();
          if (!(this.value instanceof SampledData))
            throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
          return (SampledData) this.value;
        }

        public boolean hasValueSampledData() { 
          return this != null && this.value instanceof SampledData;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Signature getValueSignature() throws FHIRException { 
          if (this.value == null)
            this.value = new Signature();
          if (!(this.value instanceof Signature))
            throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Signature) this.value;
        }

        public boolean hasValueSignature() { 
          return this != null && this.value instanceof Signature;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Timing getValueTiming() throws FHIRException { 
          if (this.value == null)
            this.value = new Timing();
          if (!(this.value instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Timing) this.value;
        }

        public boolean hasValueTiming() { 
          return this != null && this.value instanceof Timing;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public ContactDetail getValueContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactDetail();
          if (!(this.value instanceof ContactDetail))
            throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactDetail) this.value;
        }

        public boolean hasValueContactDetail() { 
          return this != null && this.value instanceof ContactDetail;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public DataRequirement getValueDataRequirement() throws FHIRException { 
          if (this.value == null)
            this.value = new DataRequirement();
          if (!(this.value instanceof DataRequirement))
            throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DataRequirement) this.value;
        }

        public boolean hasValueDataRequirement() { 
          return this != null && this.value instanceof DataRequirement;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Expression getValueExpression() throws FHIRException { 
          if (this.value == null)
            this.value = new Expression();
          if (!(this.value instanceof Expression))
            throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Expression) this.value;
        }

        public boolean hasValueExpression() { 
          return this != null && this.value instanceof Expression;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public ParameterDefinition getValueParameterDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new ParameterDefinition();
          if (!(this.value instanceof ParameterDefinition))
            throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ParameterDefinition) this.value;
        }

        public boolean hasValueParameterDefinition() { 
          return this != null && this.value instanceof ParameterDefinition;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public RelatedArtifact getValueRelatedArtifact() throws FHIRException { 
          if (this.value == null)
            this.value = new RelatedArtifact();
          if (!(this.value instanceof RelatedArtifact))
            throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RelatedArtifact) this.value;
        }

        public boolean hasValueRelatedArtifact() { 
          return this != null && this.value instanceof RelatedArtifact;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public TriggerDefinition getValueTriggerDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new TriggerDefinition();
          if (!(this.value instanceof TriggerDefinition))
            throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TriggerDefinition) this.value;
        }

        public boolean hasValueTriggerDefinition() { 
          return this != null && this.value instanceof TriggerDefinition;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public UsageContext getValueUsageContext() throws FHIRException { 
          if (this.value == null)
            this.value = new UsageContext();
          if (!(this.value instanceof UsageContext))
            throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UsageContext) this.value;
        }

        public boolean hasValueUsageContext() { 
          return this != null && this.value instanceof UsageContext;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Availability getValueAvailability() throws FHIRException { 
          if (this.value == null)
            this.value = new Availability();
          if (!(this.value instanceof Availability))
            throw new FHIRException("Type mismatch: the type Availability was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Availability) this.value;
        }

        public boolean hasValueAvailability() { 
          return this != null && this.value instanceof Availability;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public ExtendedContactDetail getValueExtendedContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ExtendedContactDetail();
          if (!(this.value instanceof ExtendedContactDetail))
            throw new FHIRException("Type mismatch: the type ExtendedContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ExtendedContactDetail) this.value;
        }

        public boolean hasValueExtendedContactDetail() { 
          return this != null && this.value instanceof ExtendedContactDetail;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Dosage getValueDosage() throws FHIRException { 
          if (this.value == null)
            this.value = new Dosage();
          if (!(this.value instanceof Dosage))
            throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Dosage) this.value;
        }

        public boolean hasValueDosage() { 
          return this != null && this.value instanceof Dosage;
        }

        /**
         * @return {@link #value} (The value of the input parameter as a basic type.)
         */
        public Meta getValueMeta() throws FHIRException { 
          if (this.value == null)
            this.value = new Meta();
          if (!(this.value instanceof Meta))
            throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Meta) this.value;
        }

        public boolean hasValueMeta() { 
          return this != null && this.value instanceof Meta;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the input parameter as a basic type.)
         */
        public ParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof CodeableReference || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof RatioRange || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Availability || value instanceof ExtendedContactDetail || value instanceof Dosage || value instanceof Meta))
            throw new FHIRException("Not the right type for Transport.input.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code or description indicating how the input is intended to be used as part of the transport execution.", 0, 1, type));
          children.add(new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the input parameter as a basic type.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code or description indicating how the input is intended to be used as part of the transport execution.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the input parameter as a basic type.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "The value of the input parameter as a basic type.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the input parameter as a basic type.", 0, 1, value);
          case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "The value of the input parameter as a basic type.", 0, 1, value);
          case -766209282: /*valueCode*/  return new Property("value[x]", "code", "The value of the input parameter as a basic type.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the input parameter as a basic type.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The value of the input parameter as a basic type.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1668687056: /*valueInstant*/  return new Property("value[x]", "instant", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1122120181: /*valueInteger64*/  return new Property("value[x]", "integer64", "The value of the input parameter as a basic type.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1410178407: /*valueOid*/  return new Property("value[x]", "oid", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1249932027: /*valuePositiveInt*/  return new Property("value[x]", "positiveInt", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The value of the input parameter as a basic type.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The value of the input parameter as a basic type.", 0, 1, value);
          case 26529417: /*valueUnsignedInt*/  return new Property("value[x]", "unsignedInt", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "The value of the input parameter as a basic type.", 0, 1, value);
          case -765667124: /*valueUuid*/  return new Property("value[x]", "uuid", "The value of the input parameter as a basic type.", 0, 1, value);
          case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1410191922: /*valueAge*/  return new Property("value[x]", "Age", "The value of the input parameter as a basic type.", 0, 1, value);
          case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "The value of the input parameter as a basic type.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The value of the input parameter as a basic type.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the input parameter as a basic type.", 0, 1, value);
          case -257955629: /*valueCodeableReference*/  return new Property("value[x]", "CodeableReference", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The value of the input parameter as a basic type.", 0, 1, value);
          case 944904545: /*valueContactPoint*/  return new Property("value[x]", "ContactPoint", "The value of the input parameter as a basic type.", 0, 1, value);
          case 2017332766: /*valueCount*/  return new Property("value[x]", "Count", "The value of the input parameter as a basic type.", 0, 1, value);
          case -456359802: /*valueDistance*/  return new Property("value[x]", "Distance", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The value of the input parameter as a basic type.", 0, 1, value);
          case -2026205465: /*valueHumanName*/  return new Property("value[x]", "HumanName", "The value of the input parameter as a basic type.", 0, 1, value);
          case -130498310: /*valueIdentifier*/  return new Property("value[x]", "Identifier", "The value of the input parameter as a basic type.", 0, 1, value);
          case 2026560975: /*valueMoney*/  return new Property("value[x]", "Money", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The value of the input parameter as a basic type.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the input parameter as a basic type.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the input parameter as a basic type.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The value of the input parameter as a basic type.", 0, 1, value);
          case -706454461: /*valueRatioRange*/  return new Property("value[x]", "RatioRange", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The value of the input parameter as a basic type.", 0, 1, value);
          case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "The value of the input parameter as a basic type.", 0, 1, value);
          case -540985785: /*valueSignature*/  return new Property("value[x]", "Signature", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1406282469: /*valueTiming*/  return new Property("value[x]", "Timing", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1125200224: /*valueContactDetail*/  return new Property("value[x]", "ContactDetail", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1710554248: /*valueDataRequirement*/  return new Property("value[x]", "DataRequirement", "The value of the input parameter as a basic type.", 0, 1, value);
          case -307517719: /*valueExpression*/  return new Property("value[x]", "Expression", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1387478187: /*valueParameterDefinition*/  return new Property("value[x]", "ParameterDefinition", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1748214124: /*valueRelatedArtifact*/  return new Property("value[x]", "RelatedArtifact", "The value of the input parameter as a basic type.", 0, 1, value);
          case 976830394: /*valueTriggerDefinition*/  return new Property("value[x]", "TriggerDefinition", "The value of the input parameter as a basic type.", 0, 1, value);
          case 588000479: /*valueUsageContext*/  return new Property("value[x]", "UsageContext", "The value of the input parameter as a basic type.", 0, 1, value);
          case 1678530924: /*valueAvailability*/  return new Property("value[x]", "Availability", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1567222041: /*valueExtendedContactDetail*/  return new Property("value[x]", "ExtendedContactDetail", "The value of the input parameter as a basic type.", 0, 1, value);
          case -1858636920: /*valueDosage*/  return new Property("value[x]", "Dosage", "The value of the input parameter as a basic type.", 0, 1, value);
          case -765920490: /*valueMeta*/  return new Property("value[x]", "Meta", "The value of the input parameter as a basic type.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "CodeableReference", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "RatioRange", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Availability", "ExtendedContactDetail", "Dosage", "Meta"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueCanonical")) {
          this.value = new CanonicalType();
          return this.value;
        }
        else if (name.equals("valueCode")) {
          this.value = new CodeType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("valueInstant")) {
          this.value = new InstantType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueInteger64")) {
          this.value = new Integer64Type();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueOid")) {
          this.value = new OidType();
          return this.value;
        }
        else if (name.equals("valuePositiveInt")) {
          this.value = new PositiveIntType();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueUnsignedInt")) {
          this.value = new UnsignedIntType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueUrl")) {
          this.value = new UrlType();
          return this.value;
        }
        else if (name.equals("valueUuid")) {
          this.value = new UuidType();
          return this.value;
        }
        else if (name.equals("valueAddress")) {
          this.value = new Address();
          return this.value;
        }
        else if (name.equals("valueAge")) {
          this.value = new Age();
          return this.value;
        }
        else if (name.equals("valueAnnotation")) {
          this.value = new Annotation();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueCodeableReference")) {
          this.value = new CodeableReference();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueContactPoint")) {
          this.value = new ContactPoint();
          return this.value;
        }
        else if (name.equals("valueCount")) {
          this.value = new Count();
          return this.value;
        }
        else if (name.equals("valueDistance")) {
          this.value = new Distance();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else if (name.equals("valueHumanName")) {
          this.value = new HumanName();
          return this.value;
        }
        else if (name.equals("valueIdentifier")) {
          this.value = new Identifier();
          return this.value;
        }
        else if (name.equals("valueMoney")) {
          this.value = new Money();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueRatioRange")) {
          this.value = new RatioRange();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueSignature")) {
          this.value = new Signature();
          return this.value;
        }
        else if (name.equals("valueTiming")) {
          this.value = new Timing();
          return this.value;
        }
        else if (name.equals("valueContactDetail")) {
          this.value = new ContactDetail();
          return this.value;
        }
        else if (name.equals("valueDataRequirement")) {
          this.value = new DataRequirement();
          return this.value;
        }
        else if (name.equals("valueExpression")) {
          this.value = new Expression();
          return this.value;
        }
        else if (name.equals("valueParameterDefinition")) {
          this.value = new ParameterDefinition();
          return this.value;
        }
        else if (name.equals("valueRelatedArtifact")) {
          this.value = new RelatedArtifact();
          return this.value;
        }
        else if (name.equals("valueTriggerDefinition")) {
          this.value = new TriggerDefinition();
          return this.value;
        }
        else if (name.equals("valueUsageContext")) {
          this.value = new UsageContext();
          return this.value;
        }
        else if (name.equals("valueAvailability")) {
          this.value = new Availability();
          return this.value;
        }
        else if (name.equals("valueExtendedContactDetail")) {
          this.value = new ExtendedContactDetail();
          return this.value;
        }
        else if (name.equals("valueDosage")) {
          this.value = new Dosage();
          return this.value;
        }
        else if (name.equals("valueMeta")) {
          this.value = new Meta();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public ParameterComponent copy() {
        ParameterComponent dst = new ParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ParameterComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ParameterComponent))
          return false;
        ParameterComponent o = (ParameterComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ParameterComponent))
          return false;
        ParameterComponent o = (ParameterComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "Transport.input";

  }

  }

    @Block()
    public static class TransportOutputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the Output parameter.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for output", formalDefinition="The name of the Output parameter." )
        protected CodeableConcept type;

        /**
         * The value of the Output parameter as a basic type.
         */
        @Child(name = "value", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, CodeableReference.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, RatioRange.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Availability.class, ExtendedContactDetail.class, Dosage.class, Meta.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Result of output", formalDefinition="The value of the Output parameter as a basic type." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public TransportOutputComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TransportOutputComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (The name of the Output parameter.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TransportOutputComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The name of the Output parameter.)
         */
        public TransportOutputComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Base64BinaryType getValueBase64BinaryType() throws FHIRException { 
          if (this.value == null)
            this.value = new Base64BinaryType();
          if (!(this.value instanceof Base64BinaryType))
            throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Base64BinaryType) this.value;
        }

        public boolean hasValueBase64BinaryType() { 
          return this != null && this.value instanceof Base64BinaryType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public CanonicalType getValueCanonicalType() throws FHIRException { 
          if (this.value == null)
            this.value = new CanonicalType();
          if (!(this.value instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CanonicalType) this.value;
        }

        public boolean hasValueCanonicalType() { 
          return this != null && this.value instanceof CanonicalType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public CodeType getValueCodeType() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeType();
          if (!(this.value instanceof CodeType))
            throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeType) this.value;
        }

        public boolean hasValueCodeType() { 
          return this != null && this.value instanceof CodeType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public DateType getValueDateType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateType();
          if (!(this.value instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateType) this.value;
        }

        public boolean hasValueDateType() { 
          return this != null && this.value instanceof DateType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() { 
          return this != null && this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public DecimalType getValueDecimalType() throws FHIRException { 
          if (this.value == null)
            this.value = new DecimalType();
          if (!(this.value instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DecimalType) this.value;
        }

        public boolean hasValueDecimalType() { 
          return this != null && this.value instanceof DecimalType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public IdType getValueIdType() throws FHIRException { 
          if (this.value == null)
            this.value = new IdType();
          if (!(this.value instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IdType) this.value;
        }

        public boolean hasValueIdType() { 
          return this != null && this.value instanceof IdType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public InstantType getValueInstantType() throws FHIRException { 
          if (this.value == null)
            this.value = new InstantType();
          if (!(this.value instanceof InstantType))
            throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (InstantType) this.value;
        }

        public boolean hasValueInstantType() { 
          return this != null && this.value instanceof InstantType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Integer64Type getValueInteger64Type() throws FHIRException { 
          if (this.value == null)
            this.value = new Integer64Type();
          if (!(this.value instanceof Integer64Type))
            throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Integer64Type) this.value;
        }

        public boolean hasValueInteger64Type() { 
          return this != null && this.value instanceof Integer64Type;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public MarkdownType getValueMarkdownType() throws FHIRException { 
          if (this.value == null)
            this.value = new MarkdownType();
          if (!(this.value instanceof MarkdownType))
            throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (MarkdownType) this.value;
        }

        public boolean hasValueMarkdownType() { 
          return this != null && this.value instanceof MarkdownType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public OidType getValueOidType() throws FHIRException { 
          if (this.value == null)
            this.value = new OidType();
          if (!(this.value instanceof OidType))
            throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (OidType) this.value;
        }

        public boolean hasValueOidType() { 
          return this != null && this.value instanceof OidType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public PositiveIntType getValuePositiveIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new PositiveIntType();
          if (!(this.value instanceof PositiveIntType))
            throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (PositiveIntType) this.value;
        }

        public boolean hasValuePositiveIntType() { 
          return this != null && this.value instanceof PositiveIntType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public TimeType getValueTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new TimeType();
          if (!(this.value instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TimeType) this.value;
        }

        public boolean hasValueTimeType() { 
          return this != null && this.value instanceof TimeType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public UnsignedIntType getValueUnsignedIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new UnsignedIntType();
          if (!(this.value instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.value;
        }

        public boolean hasValueUnsignedIntType() { 
          return this != null && this.value instanceof UnsignedIntType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() { 
          return this != null && this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public UrlType getValueUrlType() throws FHIRException { 
          if (this.value == null)
            this.value = new UrlType();
          if (!(this.value instanceof UrlType))
            throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UrlType) this.value;
        }

        public boolean hasValueUrlType() { 
          return this != null && this.value instanceof UrlType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public UuidType getValueUuidType() throws FHIRException { 
          if (this.value == null)
            this.value = new UuidType();
          if (!(this.value instanceof UuidType))
            throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UuidType) this.value;
        }

        public boolean hasValueUuidType() { 
          return this != null && this.value instanceof UuidType;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Address getValueAddress() throws FHIRException { 
          if (this.value == null)
            this.value = new Address();
          if (!(this.value instanceof Address))
            throw new FHIRException("Type mismatch: the type Address was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Address) this.value;
        }

        public boolean hasValueAddress() { 
          return this != null && this.value instanceof Address;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Age getValueAge() throws FHIRException { 
          if (this.value == null)
            this.value = new Age();
          if (!(this.value instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Age) this.value;
        }

        public boolean hasValueAge() { 
          return this != null && this.value instanceof Age;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Annotation getValueAnnotation() throws FHIRException { 
          if (this.value == null)
            this.value = new Annotation();
          if (!(this.value instanceof Annotation))
            throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Annotation) this.value;
        }

        public boolean hasValueAnnotation() { 
          return this != null && this.value instanceof Annotation;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public CodeableReference getValueCodeableReference() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableReference();
          if (!(this.value instanceof CodeableReference))
            throw new FHIRException("Type mismatch: the type CodeableReference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableReference) this.value;
        }

        public boolean hasValueCodeableReference() { 
          return this != null && this.value instanceof CodeableReference;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() { 
          return this != null && this.value instanceof Coding;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public ContactPoint getValueContactPoint() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactPoint();
          if (!(this.value instanceof ContactPoint))
            throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactPoint) this.value;
        }

        public boolean hasValueContactPoint() { 
          return this != null && this.value instanceof ContactPoint;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Count getValueCount() throws FHIRException { 
          if (this.value == null)
            this.value = new Count();
          if (!(this.value instanceof Count))
            throw new FHIRException("Type mismatch: the type Count was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Count) this.value;
        }

        public boolean hasValueCount() { 
          return this != null && this.value instanceof Count;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Distance getValueDistance() throws FHIRException { 
          if (this.value == null)
            this.value = new Distance();
          if (!(this.value instanceof Distance))
            throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Distance) this.value;
        }

        public boolean hasValueDistance() { 
          return this != null && this.value instanceof Distance;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Duration getValueDuration() throws FHIRException { 
          if (this.value == null)
            this.value = new Duration();
          if (!(this.value instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Duration) this.value;
        }

        public boolean hasValueDuration() { 
          return this != null && this.value instanceof Duration;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public HumanName getValueHumanName() throws FHIRException { 
          if (this.value == null)
            this.value = new HumanName();
          if (!(this.value instanceof HumanName))
            throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.value.getClass().getName()+" was encountered");
          return (HumanName) this.value;
        }

        public boolean hasValueHumanName() { 
          return this != null && this.value instanceof HumanName;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Identifier getValueIdentifier() throws FHIRException { 
          if (this.value == null)
            this.value = new Identifier();
          if (!(this.value instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Identifier) this.value;
        }

        public boolean hasValueIdentifier() { 
          return this != null && this.value instanceof Identifier;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Money getValueMoney() throws FHIRException { 
          if (this.value == null)
            this.value = new Money();
          if (!(this.value instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Money) this.value;
        }

        public boolean hasValueMoney() { 
          return this != null && this.value instanceof Money;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Period getValuePeriod() throws FHIRException { 
          if (this.value == null)
            this.value = new Period();
          if (!(this.value instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Period) this.value;
        }

        public boolean hasValuePeriod() { 
          return this != null && this.value instanceof Period;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Ratio getValueRatio() throws FHIRException { 
          if (this.value == null)
            this.value = new Ratio();
          if (!(this.value instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Ratio) this.value;
        }

        public boolean hasValueRatio() { 
          return this != null && this.value instanceof Ratio;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public RatioRange getValueRatioRange() throws FHIRException { 
          if (this.value == null)
            this.value = new RatioRange();
          if (!(this.value instanceof RatioRange))
            throw new FHIRException("Type mismatch: the type RatioRange was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RatioRange) this.value;
        }

        public boolean hasValueRatioRange() { 
          return this != null && this.value instanceof RatioRange;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public SampledData getValueSampledData() throws FHIRException { 
          if (this.value == null)
            this.value = new SampledData();
          if (!(this.value instanceof SampledData))
            throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
          return (SampledData) this.value;
        }

        public boolean hasValueSampledData() { 
          return this != null && this.value instanceof SampledData;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Signature getValueSignature() throws FHIRException { 
          if (this.value == null)
            this.value = new Signature();
          if (!(this.value instanceof Signature))
            throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Signature) this.value;
        }

        public boolean hasValueSignature() { 
          return this != null && this.value instanceof Signature;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Timing getValueTiming() throws FHIRException { 
          if (this.value == null)
            this.value = new Timing();
          if (!(this.value instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Timing) this.value;
        }

        public boolean hasValueTiming() { 
          return this != null && this.value instanceof Timing;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public ContactDetail getValueContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactDetail();
          if (!(this.value instanceof ContactDetail))
            throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactDetail) this.value;
        }

        public boolean hasValueContactDetail() { 
          return this != null && this.value instanceof ContactDetail;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public DataRequirement getValueDataRequirement() throws FHIRException { 
          if (this.value == null)
            this.value = new DataRequirement();
          if (!(this.value instanceof DataRequirement))
            throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DataRequirement) this.value;
        }

        public boolean hasValueDataRequirement() { 
          return this != null && this.value instanceof DataRequirement;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Expression getValueExpression() throws FHIRException { 
          if (this.value == null)
            this.value = new Expression();
          if (!(this.value instanceof Expression))
            throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Expression) this.value;
        }

        public boolean hasValueExpression() { 
          return this != null && this.value instanceof Expression;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public ParameterDefinition getValueParameterDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new ParameterDefinition();
          if (!(this.value instanceof ParameterDefinition))
            throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ParameterDefinition) this.value;
        }

        public boolean hasValueParameterDefinition() { 
          return this != null && this.value instanceof ParameterDefinition;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public RelatedArtifact getValueRelatedArtifact() throws FHIRException { 
          if (this.value == null)
            this.value = new RelatedArtifact();
          if (!(this.value instanceof RelatedArtifact))
            throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RelatedArtifact) this.value;
        }

        public boolean hasValueRelatedArtifact() { 
          return this != null && this.value instanceof RelatedArtifact;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public TriggerDefinition getValueTriggerDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new TriggerDefinition();
          if (!(this.value instanceof TriggerDefinition))
            throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TriggerDefinition) this.value;
        }

        public boolean hasValueTriggerDefinition() { 
          return this != null && this.value instanceof TriggerDefinition;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public UsageContext getValueUsageContext() throws FHIRException { 
          if (this.value == null)
            this.value = new UsageContext();
          if (!(this.value instanceof UsageContext))
            throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UsageContext) this.value;
        }

        public boolean hasValueUsageContext() { 
          return this != null && this.value instanceof UsageContext;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Availability getValueAvailability() throws FHIRException { 
          if (this.value == null)
            this.value = new Availability();
          if (!(this.value instanceof Availability))
            throw new FHIRException("Type mismatch: the type Availability was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Availability) this.value;
        }

        public boolean hasValueAvailability() { 
          return this != null && this.value instanceof Availability;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public ExtendedContactDetail getValueExtendedContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ExtendedContactDetail();
          if (!(this.value instanceof ExtendedContactDetail))
            throw new FHIRException("Type mismatch: the type ExtendedContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ExtendedContactDetail) this.value;
        }

        public boolean hasValueExtendedContactDetail() { 
          return this != null && this.value instanceof ExtendedContactDetail;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Dosage getValueDosage() throws FHIRException { 
          if (this.value == null)
            this.value = new Dosage();
          if (!(this.value instanceof Dosage))
            throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Dosage) this.value;
        }

        public boolean hasValueDosage() { 
          return this != null && this.value instanceof Dosage;
        }

        /**
         * @return {@link #value} (The value of the Output parameter as a basic type.)
         */
        public Meta getValueMeta() throws FHIRException { 
          if (this.value == null)
            this.value = new Meta();
          if (!(this.value instanceof Meta))
            throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Meta) this.value;
        }

        public boolean hasValueMeta() { 
          return this != null && this.value instanceof Meta;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the Output parameter as a basic type.)
         */
        public TransportOutputComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof CodeableReference || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof RatioRange || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Availability || value instanceof ExtendedContactDetail || value instanceof Dosage || value instanceof Meta))
            throw new FHIRException("Not the right type for Transport.output.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The name of the Output parameter.", 0, 1, type));
          children.add(new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the Output parameter as a basic type.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The name of the Output parameter.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|CodeableReference|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|RatioRange|Reference|SampledData|Signature|Timing|ContactDetail|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Availability|ExtendedContactDetail|Dosage|Meta", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -766209282: /*valueCode*/  return new Property("value[x]", "code", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1668687056: /*valueInstant*/  return new Property("value[x]", "instant", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1122120181: /*valueInteger64*/  return new Property("value[x]", "integer64", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1410178407: /*valueOid*/  return new Property("value[x]", "oid", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1249932027: /*valuePositiveInt*/  return new Property("value[x]", "positiveInt", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 26529417: /*valueUnsignedInt*/  return new Property("value[x]", "unsignedInt", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -765667124: /*valueUuid*/  return new Property("value[x]", "uuid", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1410191922: /*valueAge*/  return new Property("value[x]", "Age", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -257955629: /*valueCodeableReference*/  return new Property("value[x]", "CodeableReference", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 944904545: /*valueContactPoint*/  return new Property("value[x]", "ContactPoint", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 2017332766: /*valueCount*/  return new Property("value[x]", "Count", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -456359802: /*valueDistance*/  return new Property("value[x]", "Distance", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -2026205465: /*valueHumanName*/  return new Property("value[x]", "HumanName", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -130498310: /*valueIdentifier*/  return new Property("value[x]", "Identifier", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 2026560975: /*valueMoney*/  return new Property("value[x]", "Money", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -706454461: /*valueRatioRange*/  return new Property("value[x]", "RatioRange", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -540985785: /*valueSignature*/  return new Property("value[x]", "Signature", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1406282469: /*valueTiming*/  return new Property("value[x]", "Timing", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1125200224: /*valueContactDetail*/  return new Property("value[x]", "ContactDetail", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1710554248: /*valueDataRequirement*/  return new Property("value[x]", "DataRequirement", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -307517719: /*valueExpression*/  return new Property("value[x]", "Expression", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1387478187: /*valueParameterDefinition*/  return new Property("value[x]", "ParameterDefinition", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1748214124: /*valueRelatedArtifact*/  return new Property("value[x]", "RelatedArtifact", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 976830394: /*valueTriggerDefinition*/  return new Property("value[x]", "TriggerDefinition", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 588000479: /*valueUsageContext*/  return new Property("value[x]", "UsageContext", "The value of the Output parameter as a basic type.", 0, 1, value);
          case 1678530924: /*valueAvailability*/  return new Property("value[x]", "Availability", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1567222041: /*valueExtendedContactDetail*/  return new Property("value[x]", "ExtendedContactDetail", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -1858636920: /*valueDosage*/  return new Property("value[x]", "Dosage", "The value of the Output parameter as a basic type.", 0, 1, value);
          case -765920490: /*valueMeta*/  return new Property("value[x]", "Meta", "The value of the Output parameter as a basic type.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "CodeableReference", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "RatioRange", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Availability", "ExtendedContactDetail", "Dosage", "Meta"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueCanonical")) {
          this.value = new CanonicalType();
          return this.value;
        }
        else if (name.equals("valueCode")) {
          this.value = new CodeType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("valueInstant")) {
          this.value = new InstantType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueInteger64")) {
          this.value = new Integer64Type();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueOid")) {
          this.value = new OidType();
          return this.value;
        }
        else if (name.equals("valuePositiveInt")) {
          this.value = new PositiveIntType();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueUnsignedInt")) {
          this.value = new UnsignedIntType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueUrl")) {
          this.value = new UrlType();
          return this.value;
        }
        else if (name.equals("valueUuid")) {
          this.value = new UuidType();
          return this.value;
        }
        else if (name.equals("valueAddress")) {
          this.value = new Address();
          return this.value;
        }
        else if (name.equals("valueAge")) {
          this.value = new Age();
          return this.value;
        }
        else if (name.equals("valueAnnotation")) {
          this.value = new Annotation();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueCodeableReference")) {
          this.value = new CodeableReference();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueContactPoint")) {
          this.value = new ContactPoint();
          return this.value;
        }
        else if (name.equals("valueCount")) {
          this.value = new Count();
          return this.value;
        }
        else if (name.equals("valueDistance")) {
          this.value = new Distance();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else if (name.equals("valueHumanName")) {
          this.value = new HumanName();
          return this.value;
        }
        else if (name.equals("valueIdentifier")) {
          this.value = new Identifier();
          return this.value;
        }
        else if (name.equals("valueMoney")) {
          this.value = new Money();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueRatioRange")) {
          this.value = new RatioRange();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueSignature")) {
          this.value = new Signature();
          return this.value;
        }
        else if (name.equals("valueTiming")) {
          this.value = new Timing();
          return this.value;
        }
        else if (name.equals("valueContactDetail")) {
          this.value = new ContactDetail();
          return this.value;
        }
        else if (name.equals("valueDataRequirement")) {
          this.value = new DataRequirement();
          return this.value;
        }
        else if (name.equals("valueExpression")) {
          this.value = new Expression();
          return this.value;
        }
        else if (name.equals("valueParameterDefinition")) {
          this.value = new ParameterDefinition();
          return this.value;
        }
        else if (name.equals("valueRelatedArtifact")) {
          this.value = new RelatedArtifact();
          return this.value;
        }
        else if (name.equals("valueTriggerDefinition")) {
          this.value = new TriggerDefinition();
          return this.value;
        }
        else if (name.equals("valueUsageContext")) {
          this.value = new UsageContext();
          return this.value;
        }
        else if (name.equals("valueAvailability")) {
          this.value = new Availability();
          return this.value;
        }
        else if (name.equals("valueExtendedContactDetail")) {
          this.value = new ExtendedContactDetail();
          return this.value;
        }
        else if (name.equals("valueDosage")) {
          this.value = new Dosage();
          return this.value;
        }
        else if (name.equals("valueMeta")) {
          this.value = new Meta();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public TransportOutputComponent copy() {
        TransportOutputComponent dst = new TransportOutputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TransportOutputComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TransportOutputComponent))
          return false;
        TransportOutputComponent o = (TransportOutputComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TransportOutputComponent))
          return false;
        TransportOutputComponent o = (TransportOutputComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "Transport.output";

  }

  }

    /**
     * Identifier for the transport event that is used to identify it across multiple disparate systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="External identifier", formalDefinition="Identifier for the transport event that is used to identify it across multiple disparate systems." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Formal definition of transport", formalDefinition="The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport." )
    protected CanonicalType instantiatesCanonical;

    /**
     * The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Formal definition of transport", formalDefinition="The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport." )
    protected UriType instantiatesUri;

    /**
     * BasedOn refers to a higher-level authorization that triggered the creation of the transport.  It references a "request" resource such as a ServiceRequest or Transport, which is distinct from the "request" resource the Transport is seeking to fulfill.  This latter resource is referenced by FocusOn.  For example, based on a ServiceRequest (= BasedOn), a transport is created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.
     */
    @Child(name = "basedOn", type = {Reference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Request fulfilled by this transport", formalDefinition="BasedOn refers to a higher-level authorization that triggered the creation of the transport.  It references a \"request\" resource such as a ServiceRequest or Transport, which is distinct from the \"request\" resource the Transport is seeking to fulfill.  This latter resource is referenced by FocusOn.  For example, based on a ServiceRequest (= BasedOn), a transport is created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab." )
    protected List<Reference> basedOn;

    /**
     * A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.
     */
    @Child(name = "groupIdentifier", type = {Identifier.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Requisition or grouper id", formalDefinition="A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time." )
    protected Identifier groupIdentifier;

    /**
     * A larger event of which this particular event is a component or step.
     */
    @Child(name = "partOf", type = {Transport.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular event is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the transport event.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="in-progress | completed | abandoned | cancelled | planned | entered-in-error", formalDefinition="A code specifying the state of the transport event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/transport-status")
    protected Enumeration<TransportStatus> status;

    /**
     * An explanation as to why this transport is held, failed, was refused, etc.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reason for current status", formalDefinition="An explanation as to why this transport is held, failed, was refused, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/transport-status-reason")
    protected CodeableConcept statusReason;

    /**
     * Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.
     */
    @Child(name = "intent", type = {CodeType.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="unknown | proposal | plan | order | original-order | reflex-order | filler-order | instance-order | option", formalDefinition="Indicates the \"level\" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/transport-intent")
    protected Enumeration<TransportIntent> intent;

    /**
     * Indicates how quickly the Transport should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the Transport should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * A name or code (or both) briefly describing what the transport involves.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transport Type", formalDefinition="A name or code (or both) briefly describing what the transport involves." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/transport-code")
    protected CodeableConcept code;

    /**
     * A free-text description of what is to be performed.
     */
    @Child(name = "description", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable explanation of transport", formalDefinition="A free-text description of what is to be performed." )
    protected StringType description;

    /**
     * The request being actioned or the resource being manipulated by this transport.
     */
    @Child(name = "focus", type = {Reference.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What transport is acting on", formalDefinition="The request being actioned or the resource being manipulated by this transport." )
    protected Reference focus;

    /**
     * The entity who benefits from the performance of the service specified in the transport (e.g., the patient).
     */
    @Child(name = "for", type = {Reference.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Beneficiary of the Transport", formalDefinition="The entity who benefits from the performance of the service specified in the transport (e.g., the patient)." )
    protected Reference for_;

    /**
     * The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Healthcare event during which this transport originated", formalDefinition="The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created." )
    protected Reference encounter;

    /**
     * Identifies the completion time of the event (the occurrence).
     */
    @Child(name = "completionTime", type = {DateTimeType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Completion time of the event (the occurrence)", formalDefinition="Identifies the completion time of the event (the occurrence)." )
    protected DateTimeType completionTime;

    /**
     * The date and time this transport was created.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Transport Creation Date", formalDefinition="The date and time this transport was created." )
    protected DateTimeType authoredOn;

    /**
     * The date and time of last modification to this transport.
     */
    @Child(name = "lastModified", type = {DateTimeType.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transport Last Modified Date", formalDefinition="The date and time of last modification to this transport." )
    protected DateTimeType lastModified;

    /**
     * The creator of the transport.
     */
    @Child(name = "requester", type = {Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is asking for transport to be done", formalDefinition="The creator of the transport." )
    protected Reference requester;

    /**
     * The kind of participant that should perform the transport.
     */
    @Child(name = "performerType", type = {CodeableConcept.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Requested performer", formalDefinition="The kind of participant that should perform the transport." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/performer-role")
    protected List<CodeableConcept> performerType;

    /**
     * Individual organization or Device currently responsible for transport execution.
     */
    @Child(name = "owner", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, HealthcareService.class, Patient.class, Device.class, RelatedPerson.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Responsible individual", formalDefinition="Individual organization or Device currently responsible for transport execution." )
    protected Reference owner;

    /**
     * Principal physical location where this transport is performed.
     */
    @Child(name = "location", type = {Location.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where transport occurs", formalDefinition="Principal physical location where this transport is performed." )
    protected Reference location;

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant to the Transport.
     */
    @Child(name = "insurance", type = {Coverage.class, ClaimResponse.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated insurance coverage", formalDefinition="Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant to the Transport." )
    protected List<Reference> insurance;

    /**
     * Free-text information captured about the transport as it progresses.
     */
    @Child(name = "note", type = {Annotation.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the transport", formalDefinition="Free-text information captured about the transport as it progresses." )
    protected List<Annotation> note;

    /**
     * Links to Provenance records for past versions of this Transport that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the transport.
     */
    @Child(name = "relevantHistory", type = {Provenance.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Key events in history of the Transport", formalDefinition="Links to Provenance records for past versions of this Transport that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the transport." )
    protected List<Reference> relevantHistory;

    /**
     * If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned.
     */
    @Child(name = "restriction", type = {}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Constraints on fulfillment transports", formalDefinition="If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned." )
    protected TransportRestrictionComponent restriction;

    /**
     * Additional information that may be needed in the execution of the transport.
     */
    @Child(name = "input", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information used to perform transport", formalDefinition="Additional information that may be needed in the execution of the transport." )
    protected List<ParameterComponent> input;

    /**
     * Outputs produced by the Transport.
     */
    @Child(name = "output", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information produced as part of transport", formalDefinition="Outputs produced by the Transport." )
    protected List<TransportOutputComponent> output;

    /**
     * The desired or final location for the transport.
     */
    @Child(name = "requestedLocation", type = {Location.class}, order=28, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The desired location", formalDefinition="The desired or final location for the transport." )
    protected Reference requestedLocation;

    /**
     * The current location for the entity to be transported.
     */
    @Child(name = "currentLocation", type = {Location.class}, order=29, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The entity current location", formalDefinition="The current location for the entity to be transported." )
    protected Reference currentLocation;

    /**
     * A resource reference indicating why this transport needs to be performed.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=30, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why transport is needed", formalDefinition="A resource reference indicating why this transport needs to be performed." )
    protected CodeableReference reason;

    /**
     * The transport event prior to this one.
     */
    @Child(name = "history", type = {Transport.class}, order=31, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Parent (or preceding) transport", formalDefinition="The transport event prior to this one." )
    protected Reference history;

    private static final long serialVersionUID = -2095581755L;

  /**
   * Constructor
   */
    public Transport() {
      super();
    }

  /**
   * Constructor
   */
    public Transport(TransportIntent intent, Reference requestedLocation, Reference currentLocation) {
      super();
      this.setIntent(intent);
      this.setRequestedLocation(requestedLocation);
      this.setCurrentLocation(currentLocation);
    }

    /**
     * @return {@link #identifier} (Identifier for the transport event that is used to identify it across multiple disparate systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setIdentifier(List<Identifier> theIdentifier) { 
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

    public Transport addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
     */
    public CanonicalType getInstantiatesCanonicalElement() { 
      if (this.instantiatesCanonical == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.instantiatesCanonical");
        else if (Configuration.doAutoCreate())
          this.instantiatesCanonical = new CanonicalType(); // bb
      return this.instantiatesCanonical;
    }

    public boolean hasInstantiatesCanonicalElement() { 
      return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
    }

    public boolean hasInstantiatesCanonical() { 
      return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
     */
    public Transport setInstantiatesCanonicalElement(CanonicalType value) { 
      this.instantiatesCanonical = value;
      return this;
    }

    /**
     * @return The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    public String getInstantiatesCanonical() { 
      return this.instantiatesCanonical == null ? null : this.instantiatesCanonical.getValue();
    }

    /**
     * @param value The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    public Transport setInstantiatesCanonical(String value) { 
      if (Utilities.noString(value))
        this.instantiatesCanonical = null;
      else {
        if (this.instantiatesCanonical == null)
          this.instantiatesCanonical = new CanonicalType();
        this.instantiatesCanonical.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
     */
    public UriType getInstantiatesUriElement() { 
      if (this.instantiatesUri == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.instantiatesUri");
        else if (Configuration.doAutoCreate())
          this.instantiatesUri = new UriType(); // bb
      return this.instantiatesUri;
    }

    public boolean hasInstantiatesUriElement() { 
      return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
    }

    public boolean hasInstantiatesUri() { 
      return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
     */
    public Transport setInstantiatesUriElement(UriType value) { 
      this.instantiatesUri = value;
      return this;
    }

    /**
     * @return The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    public String getInstantiatesUri() { 
      return this.instantiatesUri == null ? null : this.instantiatesUri.getValue();
    }

    /**
     * @param value The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.
     */
    public Transport setInstantiatesUri(String value) { 
      if (Utilities.noString(value))
        this.instantiatesUri = null;
      else {
        if (this.instantiatesUri == null)
          this.instantiatesUri = new UriType();
        this.instantiatesUri.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #basedOn} (BasedOn refers to a higher-level authorization that triggered the creation of the transport.  It references a "request" resource such as a ServiceRequest or Transport, which is distinct from the "request" resource the Transport is seeking to fulfill.  This latter resource is referenced by FocusOn.  For example, based on a ServiceRequest (= BasedOn), a transport is created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setBasedOn(List<Reference> theBasedOn) { 
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

    public Transport addBasedOn(Reference t) { //3
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
     * @return {@link #groupIdentifier} (A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.)
     */
    public Identifier getGroupIdentifier() { 
      if (this.groupIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.groupIdentifier");
        else if (Configuration.doAutoCreate())
          this.groupIdentifier = new Identifier(); // cc
      return this.groupIdentifier;
    }

    public boolean hasGroupIdentifier() { 
      return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
    }

    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.)
     */
    public Transport setGroupIdentifier(Identifier value) { 
      this.groupIdentifier = value;
      return this;
    }

    /**
     * @return {@link #partOf} (A larger event of which this particular event is a component or step.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setPartOf(List<Reference> thePartOf) { 
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

    public Transport addPartOf(Reference t) { //3
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
     * @return {@link #status} (A code specifying the state of the transport event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<TransportStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<TransportStatus>(new TransportStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the transport event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Transport setStatusElement(Enumeration<TransportStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the transport event.
     */
    public TransportStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the transport event.
     */
    public Transport setStatus(TransportStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<TransportStatus>(new TransportStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #statusReason} (An explanation as to why this transport is held, failed, was refused, etc.)
     */
    public CodeableConcept getStatusReason() { 
      if (this.statusReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.statusReason");
        else if (Configuration.doAutoCreate())
          this.statusReason = new CodeableConcept(); // cc
      return this.statusReason;
    }

    public boolean hasStatusReason() { 
      return this.statusReason != null && !this.statusReason.isEmpty();
    }

    /**
     * @param value {@link #statusReason} (An explanation as to why this transport is held, failed, was refused, etc.)
     */
    public Transport setStatusReason(CodeableConcept value) { 
      this.statusReason = value;
      return this;
    }

    /**
     * @return {@link #intent} (Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<TransportIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new Enumeration<TransportIntent>(new TransportIntentEnumFactory()); // bb
      return this.intent;
    }

    public boolean hasIntentElement() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Transport setIntentElement(Enumeration<TransportIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.
     */
    public TransportIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.
     */
    public Transport setIntent(TransportIntent value) { 
        if (this.intent == null)
          this.intent = new Enumeration<TransportIntent>(new TransportIntentEnumFactory());
        this.intent.setValue(value);
      return this;
    }

    /**
     * @return {@link #priority} (Indicates how quickly the Transport should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.priority");
        else if (Configuration.doAutoCreate())
          this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory()); // bb
      return this.priority;
    }

    public boolean hasPriorityElement() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    public boolean hasPriority() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    /**
     * @param value {@link #priority} (Indicates how quickly the Transport should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Transport setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly the Transport should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly the Transport should be addressed with respect to other requests.
     */
    public Transport setPriority(RequestPriority value) { 
      if (value == null)
        this.priority = null;
      else {
        if (this.priority == null)
          this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory());
        this.priority.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #code} (A name or code (or both) briefly describing what the transport involves.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A name or code (or both) briefly describing what the transport involves.)
     */
    public Transport setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (A free-text description of what is to be performed.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.description");
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
     * @param value {@link #description} (A free-text description of what is to be performed.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Transport setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free-text description of what is to be performed.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free-text description of what is to be performed.
     */
    public Transport setDescription(String value) { 
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
     * @return {@link #focus} (The request being actioned or the resource being manipulated by this transport.)
     */
    public Reference getFocus() { 
      if (this.focus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.focus");
        else if (Configuration.doAutoCreate())
          this.focus = new Reference(); // cc
      return this.focus;
    }

    public boolean hasFocus() { 
      return this.focus != null && !this.focus.isEmpty();
    }

    /**
     * @param value {@link #focus} (The request being actioned or the resource being manipulated by this transport.)
     */
    public Transport setFocus(Reference value) { 
      this.focus = value;
      return this;
    }

    /**
     * @return {@link #for_} (The entity who benefits from the performance of the service specified in the transport (e.g., the patient).)
     */
    public Reference getFor() { 
      if (this.for_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.for_");
        else if (Configuration.doAutoCreate())
          this.for_ = new Reference(); // cc
      return this.for_;
    }

    public boolean hasFor() { 
      return this.for_ != null && !this.for_.isEmpty();
    }

    /**
     * @param value {@link #for_} (The entity who benefits from the performance of the service specified in the transport (e.g., the patient).)
     */
    public Transport setFor(Reference value) { 
      this.for_ = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created.)
     */
    public Transport setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #completionTime} (Identifies the completion time of the event (the occurrence).). This is the underlying object with id, value and extensions. The accessor "getCompletionTime" gives direct access to the value
     */
    public DateTimeType getCompletionTimeElement() { 
      if (this.completionTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.completionTime");
        else if (Configuration.doAutoCreate())
          this.completionTime = new DateTimeType(); // bb
      return this.completionTime;
    }

    public boolean hasCompletionTimeElement() { 
      return this.completionTime != null && !this.completionTime.isEmpty();
    }

    public boolean hasCompletionTime() { 
      return this.completionTime != null && !this.completionTime.isEmpty();
    }

    /**
     * @param value {@link #completionTime} (Identifies the completion time of the event (the occurrence).). This is the underlying object with id, value and extensions. The accessor "getCompletionTime" gives direct access to the value
     */
    public Transport setCompletionTimeElement(DateTimeType value) { 
      this.completionTime = value;
      return this;
    }

    /**
     * @return Identifies the completion time of the event (the occurrence).
     */
    public Date getCompletionTime() { 
      return this.completionTime == null ? null : this.completionTime.getValue();
    }

    /**
     * @param value Identifies the completion time of the event (the occurrence).
     */
    public Transport setCompletionTime(Date value) { 
      if (value == null)
        this.completionTime = null;
      else {
        if (this.completionTime == null)
          this.completionTime = new DateTimeType();
        this.completionTime.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #authoredOn} (The date and time this transport was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.authoredOn");
        else if (Configuration.doAutoCreate())
          this.authoredOn = new DateTimeType(); // bb
      return this.authoredOn;
    }

    public boolean hasAuthoredOnElement() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    public boolean hasAuthoredOn() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    /**
     * @param value {@link #authoredOn} (The date and time this transport was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public Transport setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return The date and time this transport was created.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value The date and time this transport was created.
     */
    public Transport setAuthoredOn(Date value) { 
      if (value == null)
        this.authoredOn = null;
      else {
        if (this.authoredOn == null)
          this.authoredOn = new DateTimeType();
        this.authoredOn.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastModified} (The date and time of last modification to this transport.). This is the underlying object with id, value and extensions. The accessor "getLastModified" gives direct access to the value
     */
    public DateTimeType getLastModifiedElement() { 
      if (this.lastModified == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.lastModified");
        else if (Configuration.doAutoCreate())
          this.lastModified = new DateTimeType(); // bb
      return this.lastModified;
    }

    public boolean hasLastModifiedElement() { 
      return this.lastModified != null && !this.lastModified.isEmpty();
    }

    public boolean hasLastModified() { 
      return this.lastModified != null && !this.lastModified.isEmpty();
    }

    /**
     * @param value {@link #lastModified} (The date and time of last modification to this transport.). This is the underlying object with id, value and extensions. The accessor "getLastModified" gives direct access to the value
     */
    public Transport setLastModifiedElement(DateTimeType value) { 
      this.lastModified = value;
      return this;
    }

    /**
     * @return The date and time of last modification to this transport.
     */
    public Date getLastModified() { 
      return this.lastModified == null ? null : this.lastModified.getValue();
    }

    /**
     * @param value The date and time of last modification to this transport.
     */
    public Transport setLastModified(Date value) { 
      if (value == null)
        this.lastModified = null;
      else {
        if (this.lastModified == null)
          this.lastModified = new DateTimeType();
        this.lastModified.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #requester} (The creator of the transport.)
     */
    public Reference getRequester() { 
      if (this.requester == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.requester");
        else if (Configuration.doAutoCreate())
          this.requester = new Reference(); // cc
      return this.requester;
    }

    public boolean hasRequester() { 
      return this.requester != null && !this.requester.isEmpty();
    }

    /**
     * @param value {@link #requester} (The creator of the transport.)
     */
    public Transport setRequester(Reference value) { 
      this.requester = value;
      return this;
    }

    /**
     * @return {@link #performerType} (The kind of participant that should perform the transport.)
     */
    public List<CodeableConcept> getPerformerType() { 
      if (this.performerType == null)
        this.performerType = new ArrayList<CodeableConcept>();
      return this.performerType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setPerformerType(List<CodeableConcept> thePerformerType) { 
      this.performerType = thePerformerType;
      return this;
    }

    public boolean hasPerformerType() { 
      if (this.performerType == null)
        return false;
      for (CodeableConcept item : this.performerType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addPerformerType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.performerType == null)
        this.performerType = new ArrayList<CodeableConcept>();
      this.performerType.add(t);
      return t;
    }

    public Transport addPerformerType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.performerType == null)
        this.performerType = new ArrayList<CodeableConcept>();
      this.performerType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performerType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getPerformerTypeFirstRep() { 
      if (getPerformerType().isEmpty()) {
        addPerformerType();
      }
      return getPerformerType().get(0);
    }

    /**
     * @return {@link #owner} (Individual organization or Device currently responsible for transport execution.)
     */
    public Reference getOwner() { 
      if (this.owner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.owner");
        else if (Configuration.doAutoCreate())
          this.owner = new Reference(); // cc
      return this.owner;
    }

    public boolean hasOwner() { 
      return this.owner != null && !this.owner.isEmpty();
    }

    /**
     * @param value {@link #owner} (Individual organization or Device currently responsible for transport execution.)
     */
    public Transport setOwner(Reference value) { 
      this.owner = value;
      return this;
    }

    /**
     * @return {@link #location} (Principal physical location where this transport is performed.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (Principal physical location where this transport is performed.)
     */
    public Transport setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #insurance} (Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant to the Transport.)
     */
    public List<Reference> getInsurance() { 
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      return this.insurance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setInsurance(List<Reference> theInsurance) { 
      this.insurance = theInsurance;
      return this;
    }

    public boolean hasInsurance() { 
      if (this.insurance == null)
        return false;
      for (Reference item : this.insurance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addInsurance() { //3
      Reference t = new Reference();
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      this.insurance.add(t);
      return t;
    }

    public Transport addInsurance(Reference t) { //3
      if (t == null)
        return this;
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      this.insurance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #insurance}, creating it if it does not already exist {3}
     */
    public Reference getInsuranceFirstRep() { 
      if (getInsurance().isEmpty()) {
        addInsurance();
      }
      return getInsurance().get(0);
    }

    /**
     * @return {@link #note} (Free-text information captured about the transport as it progresses.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setNote(List<Annotation> theNote) { 
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

    public Transport addNote(Annotation t) { //3
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
     * @return {@link #relevantHistory} (Links to Provenance records for past versions of this Transport that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the transport.)
     */
    public List<Reference> getRelevantHistory() { 
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      return this.relevantHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setRelevantHistory(List<Reference> theRelevantHistory) { 
      this.relevantHistory = theRelevantHistory;
      return this;
    }

    public boolean hasRelevantHistory() { 
      if (this.relevantHistory == null)
        return false;
      for (Reference item : this.relevantHistory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addRelevantHistory() { //3
      Reference t = new Reference();
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      this.relevantHistory.add(t);
      return t;
    }

    public Transport addRelevantHistory(Reference t) { //3
      if (t == null)
        return this;
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      this.relevantHistory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relevantHistory}, creating it if it does not already exist {3}
     */
    public Reference getRelevantHistoryFirstRep() { 
      if (getRelevantHistory().isEmpty()) {
        addRelevantHistory();
      }
      return getRelevantHistory().get(0);
    }

    /**
     * @return {@link #restriction} (If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned.)
     */
    public TransportRestrictionComponent getRestriction() { 
      if (this.restriction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.restriction");
        else if (Configuration.doAutoCreate())
          this.restriction = new TransportRestrictionComponent(); // cc
      return this.restriction;
    }

    public boolean hasRestriction() { 
      return this.restriction != null && !this.restriction.isEmpty();
    }

    /**
     * @param value {@link #restriction} (If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned.)
     */
    public Transport setRestriction(TransportRestrictionComponent value) { 
      this.restriction = value;
      return this;
    }

    /**
     * @return {@link #input} (Additional information that may be needed in the execution of the transport.)
     */
    public List<ParameterComponent> getInput() { 
      if (this.input == null)
        this.input = new ArrayList<ParameterComponent>();
      return this.input;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setInput(List<ParameterComponent> theInput) { 
      this.input = theInput;
      return this;
    }

    public boolean hasInput() { 
      if (this.input == null)
        return false;
      for (ParameterComponent item : this.input)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ParameterComponent addInput() { //3
      ParameterComponent t = new ParameterComponent();
      if (this.input == null)
        this.input = new ArrayList<ParameterComponent>();
      this.input.add(t);
      return t;
    }

    public Transport addInput(ParameterComponent t) { //3
      if (t == null)
        return this;
      if (this.input == null)
        this.input = new ArrayList<ParameterComponent>();
      this.input.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
     */
    public ParameterComponent getInputFirstRep() { 
      if (getInput().isEmpty()) {
        addInput();
      }
      return getInput().get(0);
    }

    /**
     * @return {@link #output} (Outputs produced by the Transport.)
     */
    public List<TransportOutputComponent> getOutput() { 
      if (this.output == null)
        this.output = new ArrayList<TransportOutputComponent>();
      return this.output;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Transport setOutput(List<TransportOutputComponent> theOutput) { 
      this.output = theOutput;
      return this;
    }

    public boolean hasOutput() { 
      if (this.output == null)
        return false;
      for (TransportOutputComponent item : this.output)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TransportOutputComponent addOutput() { //3
      TransportOutputComponent t = new TransportOutputComponent();
      if (this.output == null)
        this.output = new ArrayList<TransportOutputComponent>();
      this.output.add(t);
      return t;
    }

    public Transport addOutput(TransportOutputComponent t) { //3
      if (t == null)
        return this;
      if (this.output == null)
        this.output = new ArrayList<TransportOutputComponent>();
      this.output.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #output}, creating it if it does not already exist {3}
     */
    public TransportOutputComponent getOutputFirstRep() { 
      if (getOutput().isEmpty()) {
        addOutput();
      }
      return getOutput().get(0);
    }

    /**
     * @return {@link #requestedLocation} (The desired or final location for the transport.)
     */
    public Reference getRequestedLocation() { 
      if (this.requestedLocation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.requestedLocation");
        else if (Configuration.doAutoCreate())
          this.requestedLocation = new Reference(); // cc
      return this.requestedLocation;
    }

    public boolean hasRequestedLocation() { 
      return this.requestedLocation != null && !this.requestedLocation.isEmpty();
    }

    /**
     * @param value {@link #requestedLocation} (The desired or final location for the transport.)
     */
    public Transport setRequestedLocation(Reference value) { 
      this.requestedLocation = value;
      return this;
    }

    /**
     * @return {@link #currentLocation} (The current location for the entity to be transported.)
     */
    public Reference getCurrentLocation() { 
      if (this.currentLocation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.currentLocation");
        else if (Configuration.doAutoCreate())
          this.currentLocation = new Reference(); // cc
      return this.currentLocation;
    }

    public boolean hasCurrentLocation() { 
      return this.currentLocation != null && !this.currentLocation.isEmpty();
    }

    /**
     * @param value {@link #currentLocation} (The current location for the entity to be transported.)
     */
    public Transport setCurrentLocation(Reference value) { 
      this.currentLocation = value;
      return this;
    }

    /**
     * @return {@link #reason} (A resource reference indicating why this transport needs to be performed.)
     */
    public CodeableReference getReason() { 
      if (this.reason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.reason");
        else if (Configuration.doAutoCreate())
          this.reason = new CodeableReference(); // cc
      return this.reason;
    }

    public boolean hasReason() { 
      return this.reason != null && !this.reason.isEmpty();
    }

    /**
     * @param value {@link #reason} (A resource reference indicating why this transport needs to be performed.)
     */
    public Transport setReason(CodeableReference value) { 
      this.reason = value;
      return this;
    }

    /**
     * @return {@link #history} (The transport event prior to this one.)
     */
    public Reference getHistory() { 
      if (this.history == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Transport.history");
        else if (Configuration.doAutoCreate())
          this.history = new Reference(); // cc
      return this.history;
    }

    public boolean hasHistory() { 
      return this.history != null && !this.history.isEmpty();
    }

    /**
     * @param value {@link #history} (The transport event prior to this one.)
     */
    public Transport setHistory(Reference value) { 
      this.history = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for the transport event that is used to identify it across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(ActivityDefinition)", "The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.", 0, 1, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.", 0, 1, instantiatesUri));
        children.add(new Property("basedOn", "Reference(Any)", "BasedOn refers to a higher-level authorization that triggered the creation of the transport.  It references a \"request\" resource such as a ServiceRequest or Transport, which is distinct from the \"request\" resource the Transport is seeking to fulfill.  This latter resource is referenced by FocusOn.  For example, based on a ServiceRequest (= BasedOn), a transport is created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("groupIdentifier", "Identifier", "A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.", 0, 1, groupIdentifier));
        children.add(new Property("partOf", "Reference(Transport)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the transport event.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "An explanation as to why this transport is held, failed, was refused, etc.", 0, 1, statusReason));
        children.add(new Property("intent", "code", "Indicates the \"level\" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.", 0, 1, intent));
        children.add(new Property("priority", "code", "Indicates how quickly the Transport should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("code", "CodeableConcept", "A name or code (or both) briefly describing what the transport involves.", 0, 1, code));
        children.add(new Property("description", "string", "A free-text description of what is to be performed.", 0, 1, description));
        children.add(new Property("focus", "Reference(Any)", "The request being actioned or the resource being manipulated by this transport.", 0, 1, focus));
        children.add(new Property("for", "Reference(Any)", "The entity who benefits from the performance of the service specified in the transport (e.g., the patient).", 0, 1, for_));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created.", 0, 1, encounter));
        children.add(new Property("completionTime", "dateTime", "Identifies the completion time of the event (the occurrence).", 0, 1, completionTime));
        children.add(new Property("authoredOn", "dateTime", "The date and time this transport was created.", 0, 1, authoredOn));
        children.add(new Property("lastModified", "dateTime", "The date and time of last modification to this transport.", 0, 1, lastModified));
        children.add(new Property("requester", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The creator of the transport.", 0, 1, requester));
        children.add(new Property("performerType", "CodeableConcept", "The kind of participant that should perform the transport.", 0, java.lang.Integer.MAX_VALUE, performerType));
        children.add(new Property("owner", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "Individual organization or Device currently responsible for transport execution.", 0, 1, owner));
        children.add(new Property("location", "Reference(Location)", "Principal physical location where this transport is performed.", 0, 1, location));
        children.add(new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant to the Transport.", 0, java.lang.Integer.MAX_VALUE, insurance));
        children.add(new Property("note", "Annotation", "Free-text information captured about the transport as it progresses.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("relevantHistory", "Reference(Provenance)", "Links to Provenance records for past versions of this Transport that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the transport.", 0, java.lang.Integer.MAX_VALUE, relevantHistory));
        children.add(new Property("restriction", "", "If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned.", 0, 1, restriction));
        children.add(new Property("input", "", "Additional information that may be needed in the execution of the transport.", 0, java.lang.Integer.MAX_VALUE, input));
        children.add(new Property("output", "", "Outputs produced by the Transport.", 0, java.lang.Integer.MAX_VALUE, output));
        children.add(new Property("requestedLocation", "Reference(Location)", "The desired or final location for the transport.", 0, 1, requestedLocation));
        children.add(new Property("currentLocation", "Reference(Location)", "The current location for the entity to be transported.", 0, 1, currentLocation));
        children.add(new Property("reason", "CodeableReference(Any)", "A resource reference indicating why this transport needs to be performed.", 0, 1, reason));
        children.add(new Property("history", "Reference(Transport)", "The transport event prior to this one.", 0, 1, history));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for the transport event that is used to identify it across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(ActivityDefinition)", "The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.", 0, 1, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an *externally* maintained  protocol, guideline, orderset or other definition that is adhered to in whole or in part by this Transport.", 0, 1, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Any)", "BasedOn refers to a higher-level authorization that triggered the creation of the transport.  It references a \"request\" resource such as a ServiceRequest or Transport, which is distinct from the \"request\" resource the Transport is seeking to fulfill.  This latter resource is referenced by FocusOn.  For example, based on a ServiceRequest (= BasedOn), a transport is created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -445338488: /*groupIdentifier*/  return new Property("groupIdentifier", "Identifier", "A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.", 0, 1, groupIdentifier);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Transport)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the transport event.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "An explanation as to why this transport is held, failed, was refused, etc.", 0, 1, statusReason);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Indicates the \"level\" of actionability associated with the Transport, i.e. i+R[9]Cs this a proposed transport, a planned transport, an actionable transport, etc.", 0, 1, intent);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the Transport should be addressed with respect to other requests.", 0, 1, priority);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A name or code (or both) briefly describing what the transport involves.", 0, 1, code);
        case -1724546052: /*description*/  return new Property("description", "string", "A free-text description of what is to be performed.", 0, 1, description);
        case 97604824: /*focus*/  return new Property("focus", "Reference(Any)", "The request being actioned or the resource being manipulated by this transport.", 0, 1, focus);
        case 101577: /*for*/  return new Property("for", "Reference(Any)", "The entity who benefits from the performance of the service specified in the transport (e.g., the patient).", 0, 1, for_);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) during which this transport was created.", 0, 1, encounter);
        case 1146641609: /*completionTime*/  return new Property("completionTime", "dateTime", "Identifies the completion time of the event (the occurrence).", 0, 1, completionTime);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "The date and time this transport was created.", 0, 1, authoredOn);
        case 1959003007: /*lastModified*/  return new Property("lastModified", "dateTime", "The date and time of last modification to this transport.", 0, 1, lastModified);
        case 693933948: /*requester*/  return new Property("requester", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The creator of the transport.", 0, 1, requester);
        case -901444568: /*performerType*/  return new Property("performerType", "CodeableConcept", "The kind of participant that should perform the transport.", 0, java.lang.Integer.MAX_VALUE, performerType);
        case 106164915: /*owner*/  return new Property("owner", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "Individual organization or Device currently responsible for transport execution.", 0, 1, owner);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Principal physical location where this transport is performed.", 0, 1, location);
        case 73049818: /*insurance*/  return new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be relevant to the Transport.", 0, java.lang.Integer.MAX_VALUE, insurance);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Free-text information captured about the transport as it progresses.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1538891575: /*relevantHistory*/  return new Property("relevantHistory", "Reference(Provenance)", "Links to Provenance records for past versions of this Transport that identify key state transitions or updates that are likely to be relevant to a user looking at the current version of the transport.", 0, java.lang.Integer.MAX_VALUE, relevantHistory);
        case -1561062452: /*restriction*/  return new Property("restriction", "", "If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the request to be actioned), this element identifies any limitations on what parts of the referenced request should be actioned.", 0, 1, restriction);
        case 100358090: /*input*/  return new Property("input", "", "Additional information that may be needed in the execution of the transport.", 0, java.lang.Integer.MAX_VALUE, input);
        case -1005512447: /*output*/  return new Property("output", "", "Outputs produced by the Transport.", 0, java.lang.Integer.MAX_VALUE, output);
        case -1788392125: /*requestedLocation*/  return new Property("requestedLocation", "Reference(Location)", "The desired or final location for the transport.", 0, 1, requestedLocation);
        case -140429234: /*currentLocation*/  return new Property("currentLocation", "Reference(Location)", "The current location for the entity to be transported.", 0, 1, currentLocation);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Any)", "A resource reference indicating why this transport needs to be performed.", 0, 1, reason);
        case 926934164: /*history*/  return new Property("history", "Reference(Transport)", "The transport event prior to this one.", 0, 1, history);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : new Base[] {this.instantiatesCanonical}; // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : new Base[] {this.instantiatesUri}; // UriType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -445338488: /*groupIdentifier*/ return this.groupIdentifier == null ? new Base[0] : new Base[] {this.groupIdentifier}; // Identifier
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<TransportStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableConcept
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<TransportIntent>
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : new Base[] {this.focus}; // Reference
        case 101577: /*for*/ return this.for_ == null ? new Base[0] : new Base[] {this.for_}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1146641609: /*completionTime*/ return this.completionTime == null ? new Base[0] : new Base[] {this.completionTime}; // DateTimeType
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case 1959003007: /*lastModified*/ return this.lastModified == null ? new Base[0] : new Base[] {this.lastModified}; // DateTimeType
        case 693933948: /*requester*/ return this.requester == null ? new Base[0] : new Base[] {this.requester}; // Reference
        case -901444568: /*performerType*/ return this.performerType == null ? new Base[0] : this.performerType.toArray(new Base[this.performerType.size()]); // CodeableConcept
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 73049818: /*insurance*/ return this.insurance == null ? new Base[0] : this.insurance.toArray(new Base[this.insurance.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1538891575: /*relevantHistory*/ return this.relevantHistory == null ? new Base[0] : this.relevantHistory.toArray(new Base[this.relevantHistory.size()]); // Reference
        case -1561062452: /*restriction*/ return this.restriction == null ? new Base[0] : new Base[] {this.restriction}; // TransportRestrictionComponent
        case 100358090: /*input*/ return this.input == null ? new Base[0] : this.input.toArray(new Base[this.input.size()]); // ParameterComponent
        case -1005512447: /*output*/ return this.output == null ? new Base[0] : this.output.toArray(new Base[this.output.size()]); // TransportOutputComponent
        case -1788392125: /*requestedLocation*/ return this.requestedLocation == null ? new Base[0] : new Base[] {this.requestedLocation}; // Reference
        case -140429234: /*currentLocation*/ return this.currentLocation == null ? new Base[0] : new Base[] {this.currentLocation}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // CodeableReference
        case 926934164: /*history*/ return this.history == null ? new Base[0] : new Base[] {this.history}; // Reference
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
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -445338488: // groupIdentifier
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new TransportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<TransportStatus>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1183762788: // intent
          value = new TransportIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<TransportIntent>
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 97604824: // focus
          this.focus = TypeConvertor.castToReference(value); // Reference
          return value;
        case 101577: // for
          this.for_ = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1146641609: // completionTime
          this.completionTime = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1500852503: // authoredOn
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1959003007: // lastModified
          this.lastModified = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 693933948: // requester
          this.requester = TypeConvertor.castToReference(value); // Reference
          return value;
        case -901444568: // performerType
          this.getPerformerType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 106164915: // owner
          this.owner = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 73049818: // insurance
          this.getInsurance().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1538891575: // relevantHistory
          this.getRelevantHistory().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1561062452: // restriction
          this.restriction = (TransportRestrictionComponent) value; // TransportRestrictionComponent
          return value;
        case 100358090: // input
          this.getInput().add((ParameterComponent) value); // ParameterComponent
          return value;
        case -1005512447: // output
          this.getOutput().add((TransportOutputComponent) value); // TransportOutputComponent
          return value;
        case -1788392125: // requestedLocation
          this.requestedLocation = TypeConvertor.castToReference(value); // Reference
          return value;
        case -140429234: // currentLocation
          this.currentLocation = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.reason = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 926934164: // history
          this.history = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("instantiatesUri")) {
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new TransportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<TransportStatus>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("intent")) {
          value = new TransportIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<TransportIntent>
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("focus")) {
          this.focus = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("for")) {
          this.for_ = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("completionTime")) {
          this.completionTime = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("lastModified")) {
          this.lastModified = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("requester")) {
          this.requester = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performerType")) {
          this.getPerformerType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("owner")) {
          this.owner = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("insurance")) {
          this.getInsurance().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("relevantHistory")) {
          this.getRelevantHistory().add(TypeConvertor.castToReference(value));
        } else if (name.equals("restriction")) {
          this.restriction = (TransportRestrictionComponent) value; // TransportRestrictionComponent
        } else if (name.equals("input")) {
          this.getInput().add((ParameterComponent) value);
        } else if (name.equals("output")) {
          this.getOutput().add((TransportOutputComponent) value);
        } else if (name.equals("requestedLocation")) {
          this.requestedLocation = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("currentLocation")) {
          this.currentLocation = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("history")) {
          this.history = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return getInstantiatesCanonicalElement();
        case -1926393373:  return getInstantiatesUriElement();
        case -332612366:  return addBasedOn(); 
        case -445338488:  return getGroupIdentifier();
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case -1183762788:  return getIntentElement();
        case -1165461084:  return getPriorityElement();
        case 3059181:  return getCode();
        case -1724546052:  return getDescriptionElement();
        case 97604824:  return getFocus();
        case 101577:  return getFor();
        case 1524132147:  return getEncounter();
        case 1146641609:  return getCompletionTimeElement();
        case -1500852503:  return getAuthoredOnElement();
        case 1959003007:  return getLastModifiedElement();
        case 693933948:  return getRequester();
        case -901444568:  return addPerformerType(); 
        case 106164915:  return getOwner();
        case 1901043637:  return getLocation();
        case 73049818:  return addInsurance(); 
        case 3387378:  return addNote(); 
        case 1538891575:  return addRelevantHistory(); 
        case -1561062452:  return getRestriction();
        case 100358090:  return addInput(); 
        case -1005512447:  return addOutput(); 
        case -1788392125:  return getRequestedLocation();
        case -140429234:  return getCurrentLocation();
        case -934964668:  return getReason();
        case 926934164:  return getHistory();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -445338488: /*groupIdentifier*/ return new String[] {"Identifier"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 97604824: /*focus*/ return new String[] {"Reference"};
        case 101577: /*for*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1146641609: /*completionTime*/ return new String[] {"dateTime"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case 1959003007: /*lastModified*/ return new String[] {"dateTime"};
        case 693933948: /*requester*/ return new String[] {"Reference"};
        case -901444568: /*performerType*/ return new String[] {"CodeableConcept"};
        case 106164915: /*owner*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 73049818: /*insurance*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1538891575: /*relevantHistory*/ return new String[] {"Reference"};
        case -1561062452: /*restriction*/ return new String[] {};
        case 100358090: /*input*/ return new String[] {};
        case -1005512447: /*output*/ return new String[] {};
        case -1788392125: /*requestedLocation*/ return new String[] {"Reference"};
        case -140429234: /*currentLocation*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 926934164: /*history*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = new Identifier();
          return this.groupIdentifier;
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableConcept();
          return this.statusReason;
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.intent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.priority");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.description");
        }
        else if (name.equals("focus")) {
          this.focus = new Reference();
          return this.focus;
        }
        else if (name.equals("for")) {
          this.for_ = new Reference();
          return this.for_;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("completionTime")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.completionTime");
        }
        else if (name.equals("authoredOn")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.authoredOn");
        }
        else if (name.equals("lastModified")) {
          throw new FHIRException("Cannot call addChild on a singleton property Transport.lastModified");
        }
        else if (name.equals("requester")) {
          this.requester = new Reference();
          return this.requester;
        }
        else if (name.equals("performerType")) {
          return addPerformerType();
        }
        else if (name.equals("owner")) {
          this.owner = new Reference();
          return this.owner;
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("insurance")) {
          return addInsurance();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("relevantHistory")) {
          return addRelevantHistory();
        }
        else if (name.equals("restriction")) {
          this.restriction = new TransportRestrictionComponent();
          return this.restriction;
        }
        else if (name.equals("input")) {
          return addInput();
        }
        else if (name.equals("output")) {
          return addOutput();
        }
        else if (name.equals("requestedLocation")) {
          this.requestedLocation = new Reference();
          return this.requestedLocation;
        }
        else if (name.equals("currentLocation")) {
          this.currentLocation = new Reference();
          return this.currentLocation;
        }
        else if (name.equals("reason")) {
          this.reason = new CodeableReference();
          return this.reason;
        }
        else if (name.equals("history")) {
          this.history = new Reference();
          return this.history;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Transport";

  }

      public Transport copy() {
        Transport dst = new Transport();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Transport dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.instantiatesCanonical = instantiatesCanonical == null ? null : instantiatesCanonical.copy();
        dst.instantiatesUri = instantiatesUri == null ? null : instantiatesUri.copy();
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.groupIdentifier = groupIdentifier == null ? null : groupIdentifier.copy();
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        dst.intent = intent == null ? null : intent.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.code = code == null ? null : code.copy();
        dst.description = description == null ? null : description.copy();
        dst.focus = focus == null ? null : focus.copy();
        dst.for_ = for_ == null ? null : for_.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.completionTime = completionTime == null ? null : completionTime.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.lastModified = lastModified == null ? null : lastModified.copy();
        dst.requester = requester == null ? null : requester.copy();
        if (performerType != null) {
          dst.performerType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : performerType)
            dst.performerType.add(i.copy());
        };
        dst.owner = owner == null ? null : owner.copy();
        dst.location = location == null ? null : location.copy();
        if (insurance != null) {
          dst.insurance = new ArrayList<Reference>();
          for (Reference i : insurance)
            dst.insurance.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (relevantHistory != null) {
          dst.relevantHistory = new ArrayList<Reference>();
          for (Reference i : relevantHistory)
            dst.relevantHistory.add(i.copy());
        };
        dst.restriction = restriction == null ? null : restriction.copy();
        if (input != null) {
          dst.input = new ArrayList<ParameterComponent>();
          for (ParameterComponent i : input)
            dst.input.add(i.copy());
        };
        if (output != null) {
          dst.output = new ArrayList<TransportOutputComponent>();
          for (TransportOutputComponent i : output)
            dst.output.add(i.copy());
        };
        dst.requestedLocation = requestedLocation == null ? null : requestedLocation.copy();
        dst.currentLocation = currentLocation == null ? null : currentLocation.copy();
        dst.reason = reason == null ? null : reason.copy();
        dst.history = history == null ? null : history.copy();
      }

      protected Transport typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Transport))
          return false;
        Transport o = (Transport) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(groupIdentifier, o.groupIdentifier, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true) && compareDeep(intent, o.intent, true)
           && compareDeep(priority, o.priority, true) && compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
           && compareDeep(focus, o.focus, true) && compareDeep(for_, o.for_, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(completionTime, o.completionTime, true) && compareDeep(authoredOn, o.authoredOn, true)
           && compareDeep(lastModified, o.lastModified, true) && compareDeep(requester, o.requester, true)
           && compareDeep(performerType, o.performerType, true) && compareDeep(owner, o.owner, true) && compareDeep(location, o.location, true)
           && compareDeep(insurance, o.insurance, true) && compareDeep(note, o.note, true) && compareDeep(relevantHistory, o.relevantHistory, true)
           && compareDeep(restriction, o.restriction, true) && compareDeep(input, o.input, true) && compareDeep(output, o.output, true)
           && compareDeep(requestedLocation, o.requestedLocation, true) && compareDeep(currentLocation, o.currentLocation, true)
           && compareDeep(reason, o.reason, true) && compareDeep(history, o.history, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Transport))
          return false;
        Transport o = (Transport) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(priority, o.priority, true)
           && compareValues(description, o.description, true) && compareValues(completionTime, o.completionTime, true)
           && compareValues(authoredOn, o.authoredOn, true) && compareValues(lastModified, o.lastModified, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, groupIdentifier, partOf, status, statusReason, intent
          , priority, code, description, focus, for_, encounter, completionTime, authoredOn
          , lastModified, requester, performerType, owner, location, insurance, note, relevantHistory
          , restriction, input, output, requestedLocation, currentLocation, reason, history
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Transport;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Transport.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Transport.identifier", description="External identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Transport.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Transport.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Transport.status", description="in-progress | completed | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Transport.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

