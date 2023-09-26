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
 * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
 */
@ResourceDef(name="Invoice", profile="http://hl7.org/fhir/StructureDefinition/Invoice")
public class Invoice extends DomainResource {

    public enum InvoiceStatus {
        /**
         * the invoice has been prepared but not yet finalized.
         */
        DRAFT, 
        /**
         * the invoice has been finalized and sent to the recipient.
         */
        ISSUED, 
        /**
         * the invoice has been balaced / completely paid.
         */
        BALANCED, 
        /**
         * the invoice was cancelled.
         */
        CANCELLED, 
        /**
         * the invoice was determined as entered in error before it was issued.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static InvoiceStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("issued".equals(codeString))
          return ISSUED;
        if ("balanced".equals(codeString))
          return BALANCED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown InvoiceStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ISSUED: return "issued";
            case BALANCED: return "balanced";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/invoice-status";
            case ISSUED: return "http://hl7.org/fhir/invoice-status";
            case BALANCED: return "http://hl7.org/fhir/invoice-status";
            case CANCELLED: return "http://hl7.org/fhir/invoice-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/invoice-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "the invoice has been prepared but not yet finalized.";
            case ISSUED: return "the invoice has been finalized and sent to the recipient.";
            case BALANCED: return "the invoice has been balaced / completely paid.";
            case CANCELLED: return "the invoice was cancelled.";
            case ENTEREDINERROR: return "the invoice was determined as entered in error before it was issued.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "draft";
            case ISSUED: return "issued";
            case BALANCED: return "balanced";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered in error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class InvoiceStatusEnumFactory implements EnumFactory<InvoiceStatus> {
    public InvoiceStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return InvoiceStatus.DRAFT;
        if ("issued".equals(codeString))
          return InvoiceStatus.ISSUED;
        if ("balanced".equals(codeString))
          return InvoiceStatus.BALANCED;
        if ("cancelled".equals(codeString))
          return InvoiceStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return InvoiceStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown InvoiceStatus code '"+codeString+"'");
        }
        public Enumeration<InvoiceStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InvoiceStatus>(this, InvoiceStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<InvoiceStatus>(this, InvoiceStatus.NULL, code);
        if ("draft".equals(codeString))
          return new Enumeration<InvoiceStatus>(this, InvoiceStatus.DRAFT, code);
        if ("issued".equals(codeString))
          return new Enumeration<InvoiceStatus>(this, InvoiceStatus.ISSUED, code);
        if ("balanced".equals(codeString))
          return new Enumeration<InvoiceStatus>(this, InvoiceStatus.BALANCED, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<InvoiceStatus>(this, InvoiceStatus.CANCELLED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<InvoiceStatus>(this, InvoiceStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown InvoiceStatus code '"+codeString+"'");
        }
    public String toCode(InvoiceStatus code) {
      if (code == InvoiceStatus.DRAFT)
        return "draft";
      if (code == InvoiceStatus.ISSUED)
        return "issued";
      if (code == InvoiceStatus.BALANCED)
        return "balanced";
      if (code == InvoiceStatus.CANCELLED)
        return "cancelled";
      if (code == InvoiceStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(InvoiceStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class InvoiceParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of involvement in creation of this Invoice", formalDefinition="Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device." )
        protected CodeableConcept role;

        /**
         * The device, practitioner, etc. who performed or participated in the service.
         */
        @Child(name = "actor", type = {Practitioner.class, Organization.class, Patient.class, PractitionerRole.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual who was involved", formalDefinition="The device, practitioner, etc. who performed or participated in the service." )
        protected Reference actor;

        private static final long serialVersionUID = -1684441509L;

    /**
     * Constructor
     */
      public InvoiceParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InvoiceParticipantComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #role} (Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InvoiceParticipantComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device.)
         */
        public InvoiceParticipantComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #actor} (The device, practitioner, etc. who performed or participated in the service.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InvoiceParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (The device, practitioner, etc. who performed or participated in the service.)
         */
        public InvoiceParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device.", 0, 1, role));
          children.add(new Property("actor", "Reference(Practitioner|Organization|Patient|PractitionerRole|Device|RelatedPerson)", "The device, practitioner, etc. who performed or participated in the service.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has been created automatically, the Participant may be a billing engine or another kind of device.", 0, 1, role);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|Organization|Patient|PractitionerRole|Device|RelatedPerson)", "The device, practitioner, etc. who performed or participated in the service.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = null;
        } else if (name.equals("actor")) {
          this.actor = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public InvoiceParticipantComponent copy() {
        InvoiceParticipantComponent dst = new InvoiceParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InvoiceParticipantComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InvoiceParticipantComponent))
          return false;
        InvoiceParticipantComponent o = (InvoiceParticipantComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InvoiceParticipantComponent))
          return false;
        InvoiceParticipantComponent o = (InvoiceParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, actor);
      }

  public String fhirType() {
    return "Invoice.participant";

  }

  }

    @Block()
    public static class InvoiceLineItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Sequence in which the items appear on the invoice.
         */
        @Child(name = "sequence", type = {PositiveIntType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Sequence number of line item", formalDefinition="Sequence in which the items appear on the invoice." )
        protected PositiveIntType sequence;

        /**
         * Date/time(s) range when this service was delivered or completed.
         */
        @Child(name = "serviced", type = {DateType.class, Period.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Service data or period", formalDefinition="Date/time(s) range when this service was delivered or completed." )
        protected DataType serviced;

        /**
         * The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.
         */
        @Child(name = "chargeItem", type = {ChargeItem.class, CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference to ChargeItem containing details of this line item or an inline billing code", formalDefinition="The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference." )
        protected DataType chargeItem;

        /**
         * The price for a ChargeItem may be calculated as a base price with surcharges/deductions that apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors and conditions that apply to a billing code is currently under development. The priceComponent element can be used to offer transparency to the recipient of the Invoice as to how the prices have been calculated.
         */
        @Child(name = "priceComponent", type = {MonetaryComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Components of total line item price", formalDefinition="The price for a ChargeItem may be calculated as a base price with surcharges/deductions that apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors and conditions that apply to a billing code is currently under development. The priceComponent element can be used to offer transparency to the recipient of the Invoice as to how the prices have been calculated." )
        protected List<MonetaryComponent> priceComponent;

        private static final long serialVersionUID = -9393053L;

    /**
     * Constructor
     */
      public InvoiceLineItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InvoiceLineItemComponent(DataType chargeItem) {
        super();
        this.setChargeItem(chargeItem);
      }

        /**
         * @return {@link #sequence} (Sequence in which the items appear on the invoice.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
         */
        public PositiveIntType getSequenceElement() { 
          if (this.sequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InvoiceLineItemComponent.sequence");
            else if (Configuration.doAutoCreate())
              this.sequence = new PositiveIntType(); // bb
          return this.sequence;
        }

        public boolean hasSequenceElement() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        public boolean hasSequence() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        /**
         * @param value {@link #sequence} (Sequence in which the items appear on the invoice.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
         */
        public InvoiceLineItemComponent setSequenceElement(PositiveIntType value) { 
          this.sequence = value;
          return this;
        }

        /**
         * @return Sequence in which the items appear on the invoice.
         */
        public int getSequence() { 
          return this.sequence == null || this.sequence.isEmpty() ? 0 : this.sequence.getValue();
        }

        /**
         * @param value Sequence in which the items appear on the invoice.
         */
        public InvoiceLineItemComponent setSequence(int value) { 
            if (this.sequence == null)
              this.sequence = new PositiveIntType();
            this.sequence.setValue(value);
          return this;
        }

        /**
         * @return {@link #serviced} (Date/time(s) range when this service was delivered or completed.)
         */
        public DataType getServiced() { 
          return this.serviced;
        }

        /**
         * @return {@link #serviced} (Date/time(s) range when this service was delivered or completed.)
         */
        public DateType getServicedDateType() throws FHIRException { 
          if (this.serviced == null)
            this.serviced = new DateType();
          if (!(this.serviced instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.serviced.getClass().getName()+" was encountered");
          return (DateType) this.serviced;
        }

        public boolean hasServicedDateType() { 
          return this != null && this.serviced instanceof DateType;
        }

        /**
         * @return {@link #serviced} (Date/time(s) range when this service was delivered or completed.)
         */
        public Period getServicedPeriod() throws FHIRException { 
          if (this.serviced == null)
            this.serviced = new Period();
          if (!(this.serviced instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.serviced.getClass().getName()+" was encountered");
          return (Period) this.serviced;
        }

        public boolean hasServicedPeriod() { 
          return this != null && this.serviced instanceof Period;
        }

        public boolean hasServiced() { 
          return this.serviced != null && !this.serviced.isEmpty();
        }

        /**
         * @param value {@link #serviced} (Date/time(s) range when this service was delivered or completed.)
         */
        public InvoiceLineItemComponent setServiced(DataType value) { 
          if (value != null && !(value instanceof DateType || value instanceof Period))
            throw new FHIRException("Not the right type for Invoice.lineItem.serviced[x]: "+value.fhirType());
          this.serviced = value;
          return this;
        }

        /**
         * @return {@link #chargeItem} (The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.)
         */
        public DataType getChargeItem() { 
          return this.chargeItem;
        }

        /**
         * @return {@link #chargeItem} (The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.)
         */
        public Reference getChargeItemReference() throws FHIRException { 
          if (this.chargeItem == null)
            this.chargeItem = new Reference();
          if (!(this.chargeItem instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.chargeItem.getClass().getName()+" was encountered");
          return (Reference) this.chargeItem;
        }

        public boolean hasChargeItemReference() { 
          return this != null && this.chargeItem instanceof Reference;
        }

        /**
         * @return {@link #chargeItem} (The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.)
         */
        public CodeableConcept getChargeItemCodeableConcept() throws FHIRException { 
          if (this.chargeItem == null)
            this.chargeItem = new CodeableConcept();
          if (!(this.chargeItem instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.chargeItem.getClass().getName()+" was encountered");
          return (CodeableConcept) this.chargeItem;
        }

        public boolean hasChargeItemCodeableConcept() { 
          return this != null && this.chargeItem instanceof CodeableConcept;
        }

        public boolean hasChargeItem() { 
          return this.chargeItem != null && !this.chargeItem.isEmpty();
        }

        /**
         * @param value {@link #chargeItem} (The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.)
         */
        public InvoiceLineItemComponent setChargeItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new FHIRException("Not the right type for Invoice.lineItem.chargeItem[x]: "+value.fhirType());
          this.chargeItem = value;
          return this;
        }

        /**
         * @return {@link #priceComponent} (The price for a ChargeItem may be calculated as a base price with surcharges/deductions that apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors and conditions that apply to a billing code is currently under development. The priceComponent element can be used to offer transparency to the recipient of the Invoice as to how the prices have been calculated.)
         */
        public List<MonetaryComponent> getPriceComponent() { 
          if (this.priceComponent == null)
            this.priceComponent = new ArrayList<MonetaryComponent>();
          return this.priceComponent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public InvoiceLineItemComponent setPriceComponent(List<MonetaryComponent> thePriceComponent) { 
          this.priceComponent = thePriceComponent;
          return this;
        }

        public boolean hasPriceComponent() { 
          if (this.priceComponent == null)
            return false;
          for (MonetaryComponent item : this.priceComponent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MonetaryComponent addPriceComponent() { //3
          MonetaryComponent t = new MonetaryComponent();
          if (this.priceComponent == null)
            this.priceComponent = new ArrayList<MonetaryComponent>();
          this.priceComponent.add(t);
          return t;
        }

        public InvoiceLineItemComponent addPriceComponent(MonetaryComponent t) { //3
          if (t == null)
            return this;
          if (this.priceComponent == null)
            this.priceComponent = new ArrayList<MonetaryComponent>();
          this.priceComponent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #priceComponent}, creating it if it does not already exist {3}
         */
        public MonetaryComponent getPriceComponentFirstRep() { 
          if (getPriceComponent().isEmpty()) {
            addPriceComponent();
          }
          return getPriceComponent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("sequence", "positiveInt", "Sequence in which the items appear on the invoice.", 0, 1, sequence));
          children.add(new Property("serviced[x]", "date|Period", "Date/time(s) range when this service was delivered or completed.", 0, 1, serviced));
          children.add(new Property("chargeItem[x]", "Reference(ChargeItem)|CodeableConcept", "The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.", 0, 1, chargeItem));
          children.add(new Property("priceComponent", "MonetaryComponent", "The price for a ChargeItem may be calculated as a base price with surcharges/deductions that apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors and conditions that apply to a billing code is currently under development. The priceComponent element can be used to offer transparency to the recipient of the Invoice as to how the prices have been calculated.", 0, java.lang.Integer.MAX_VALUE, priceComponent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1349547969: /*sequence*/  return new Property("sequence", "positiveInt", "Sequence in which the items appear on the invoice.", 0, 1, sequence);
          case -1927922223: /*serviced[x]*/  return new Property("serviced[x]", "date|Period", "Date/time(s) range when this service was delivered or completed.", 0, 1, serviced);
          case 1379209295: /*serviced*/  return new Property("serviced[x]", "date|Period", "Date/time(s) range when this service was delivered or completed.", 0, 1, serviced);
          case 363246749: /*servicedDate*/  return new Property("serviced[x]", "date", "Date/time(s) range when this service was delivered or completed.", 0, 1, serviced);
          case 1534966512: /*servicedPeriod*/  return new Property("serviced[x]", "Period", "Date/time(s) range when this service was delivered or completed.", 0, 1, serviced);
          case 351104825: /*chargeItem[x]*/  return new Property("chargeItem[x]", "Reference(ChargeItem)|CodeableConcept", "The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.", 0, 1, chargeItem);
          case 1417779175: /*chargeItem*/  return new Property("chargeItem[x]", "Reference(ChargeItem)|CodeableConcept", "The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.", 0, 1, chargeItem);
          case 753580836: /*chargeItemReference*/  return new Property("chargeItem[x]", "Reference(ChargeItem)", "The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.", 0, 1, chargeItem);
          case 1226532026: /*chargeItemCodeableConcept*/  return new Property("chargeItem[x]", "CodeableConcept", "The ChargeItem contains information such as the billing code, date, amount etc. If no further details are required for the lineItem, inline billing codes can be added using the CodeableConcept data type instead of the Reference.", 0, 1, chargeItem);
          case 1219095988: /*priceComponent*/  return new Property("priceComponent", "MonetaryComponent", "The price for a ChargeItem may be calculated as a base price with surcharges/deductions that apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors and conditions that apply to a billing code is currently under development. The priceComponent element can be used to offer transparency to the recipient of the Invoice as to how the prices have been calculated.", 0, java.lang.Integer.MAX_VALUE, priceComponent);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return this.sequence == null ? new Base[0] : new Base[] {this.sequence}; // PositiveIntType
        case 1379209295: /*serviced*/ return this.serviced == null ? new Base[0] : new Base[] {this.serviced}; // DataType
        case 1417779175: /*chargeItem*/ return this.chargeItem == null ? new Base[0] : new Base[] {this.chargeItem}; // DataType
        case 1219095988: /*priceComponent*/ return this.priceComponent == null ? new Base[0] : this.priceComponent.toArray(new Base[this.priceComponent.size()]); // MonetaryComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1349547969: // sequence
          this.sequence = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 1379209295: // serviced
          this.serviced = TypeConvertor.castToType(value); // DataType
          return value;
        case 1417779175: // chargeItem
          this.chargeItem = TypeConvertor.castToType(value); // DataType
          return value;
        case 1219095988: // priceComponent
          this.getPriceComponent().add(TypeConvertor.castToMonetaryComponent(value)); // MonetaryComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("sequence")) {
          this.sequence = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("serviced[x]")) {
          this.serviced = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("chargeItem[x]")) {
          this.chargeItem = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("priceComponent")) {
          this.getPriceComponent().add(TypeConvertor.castToMonetaryComponent(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("sequence")) {
          this.sequence = null;
        } else if (name.equals("serviced[x]")) {
          this.serviced = null;
        } else if (name.equals("chargeItem[x]")) {
          this.chargeItem = null;
        } else if (name.equals("priceComponent")) {
          this.getPriceComponent().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969:  return getSequenceElement();
        case -1927922223:  return getServiced();
        case 1379209295:  return getServiced();
        case 351104825:  return getChargeItem();
        case 1417779175:  return getChargeItem();
        case 1219095988:  return addPriceComponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return new String[] {"positiveInt"};
        case 1379209295: /*serviced*/ return new String[] {"date", "Period"};
        case 1417779175: /*chargeItem*/ return new String[] {"Reference", "CodeableConcept"};
        case 1219095988: /*priceComponent*/ return new String[] {"MonetaryComponent"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("sequence")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.lineItem.sequence");
        }
        else if (name.equals("servicedDate")) {
          this.serviced = new DateType();
          return this.serviced;
        }
        else if (name.equals("servicedPeriod")) {
          this.serviced = new Period();
          return this.serviced;
        }
        else if (name.equals("chargeItemReference")) {
          this.chargeItem = new Reference();
          return this.chargeItem;
        }
        else if (name.equals("chargeItemCodeableConcept")) {
          this.chargeItem = new CodeableConcept();
          return this.chargeItem;
        }
        else if (name.equals("priceComponent")) {
          return addPriceComponent();
        }
        else
          return super.addChild(name);
      }

      public InvoiceLineItemComponent copy() {
        InvoiceLineItemComponent dst = new InvoiceLineItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InvoiceLineItemComponent dst) {
        super.copyValues(dst);
        dst.sequence = sequence == null ? null : sequence.copy();
        dst.serviced = serviced == null ? null : serviced.copy();
        dst.chargeItem = chargeItem == null ? null : chargeItem.copy();
        if (priceComponent != null) {
          dst.priceComponent = new ArrayList<MonetaryComponent>();
          for (MonetaryComponent i : priceComponent)
            dst.priceComponent.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InvoiceLineItemComponent))
          return false;
        InvoiceLineItemComponent o = (InvoiceLineItemComponent) other_;
        return compareDeep(sequence, o.sequence, true) && compareDeep(serviced, o.serviced, true) && compareDeep(chargeItem, o.chargeItem, true)
           && compareDeep(priceComponent, o.priceComponent, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InvoiceLineItemComponent))
          return false;
        InvoiceLineItemComponent o = (InvoiceLineItemComponent) other_;
        return compareValues(sequence, o.sequence, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(sequence, serviced, chargeItem
          , priceComponent);
      }

  public String fhirType() {
    return "Invoice.lineItem";

  }

  }

    /**
     * Identifier of this Invoice, often used for reference in correspondence about this invoice or for tracking of payments.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for item", formalDefinition="Identifier of this Invoice, often used for reference in correspondence about this invoice or for tracking of payments." )
    protected List<Identifier> identifier;

    /**
     * The current state of the Invoice.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | issued | balanced | cancelled | entered-in-error", formalDefinition="The current state of the Invoice." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/invoice-status")
    protected Enumeration<InvoiceStatus> status;

    /**
     * In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).
     */
    @Child(name = "cancelledReason", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason for cancellation of this Invoice", formalDefinition="In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.)." )
    protected StringType cancelledReason;

    /**
     * Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary).
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of Invoice", formalDefinition="Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary)." )
    protected CodeableConcept type;

    /**
     * The individual or set of individuals receiving the goods and services billed in this invoice.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Recipient(s) of goods and services", formalDefinition="The individual or set of individuals receiving the goods and services billed in this invoice." )
    protected Reference subject;

    /**
     * The individual or Organization responsible for balancing of this invoice.
     */
    @Child(name = "recipient", type = {Organization.class, Patient.class, RelatedPerson.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Recipient of this invoice", formalDefinition="The individual or Organization responsible for balancing of this invoice." )
    protected Reference recipient;

    /**
     * Depricared by the element below.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="DEPRICATED", formalDefinition="Depricared by the element below." )
    protected DateTimeType date;

    /**
     * Date/time(s) of when this Invoice was posted.
     */
    @Child(name = "creation", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When posted", formalDefinition="Date/time(s) of when this Invoice was posted." )
    protected DateTimeType creation;

    /**
     * Date/time(s) range of services included in this invoice.
     */
    @Child(name = "period", type = {DateType.class, Period.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Billing date or period", formalDefinition="Date/time(s) range of services included in this invoice." )
    protected DataType period;

    /**
     * Indicates who or what performed or participated in the charged service.
     */
    @Child(name = "participant", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Participant in creation of this Invoice", formalDefinition="Indicates who or what performed or participated in the charged service." )
    protected List<InvoiceParticipantComponent> participant;

    /**
     * The organizationissuing the Invoice.
     */
    @Child(name = "issuer", type = {Organization.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Issuing Organization of Invoice", formalDefinition="The organizationissuing the Invoice." )
    protected Reference issuer;

    /**
     * Account which is supposed to be balanced with this Invoice.
     */
    @Child(name = "account", type = {Account.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Account that is being balanced", formalDefinition="Account which is supposed to be balanced with this Invoice." )
    protected Reference account;

    /**
     * Each line item represents one charge for goods and services rendered. Details such.ofType(date), code and amount are found in the referenced ChargeItem resource.
     */
    @Child(name = "lineItem", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Line items of this Invoice", formalDefinition="Each line item represents one charge for goods and services rendered. Details such.ofType(date), code and amount are found in the referenced ChargeItem resource." )
    protected List<InvoiceLineItemComponent> lineItem;

    /**
     * The total amount for the Invoice may be calculated as the sum of the line items with surcharges/deductions that apply in certain conditions.  The priceComponent element can be used to offer transparency to the recipient of the Invoice of how the total price was calculated.
     */
    @Child(name = "totalPriceComponent", type = {MonetaryComponent.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Components of Invoice total", formalDefinition="The total amount for the Invoice may be calculated as the sum of the line items with surcharges/deductions that apply in certain conditions.  The priceComponent element can be used to offer transparency to the recipient of the Invoice of how the total price was calculated." )
    protected List<MonetaryComponent> totalPriceComponent;

    /**
     * Invoice total , taxes excluded.
     */
    @Child(name = "totalNet", type = {Money.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Net total of this Invoice", formalDefinition="Invoice total , taxes excluded." )
    protected Money totalNet;

    /**
     * Invoice total, tax included.
     */
    @Child(name = "totalGross", type = {Money.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Gross total of this Invoice", formalDefinition="Invoice total, tax included." )
    protected Money totalGross;

    /**
     * Payment details such as banking details, period of payment, deductibles, methods of payment.
     */
    @Child(name = "paymentTerms", type = {MarkdownType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Payment details", formalDefinition="Payment details such as banking details, period of payment, deductibles, methods of payment." )
    protected MarkdownType paymentTerms;

    /**
     * Comments made about the invoice by the issuer, subject, or other participants.
     */
    @Child(name = "note", type = {Annotation.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the invoice", formalDefinition="Comments made about the invoice by the issuer, subject, or other participants." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 6346282L;

  /**
   * Constructor
   */
    public Invoice() {
      super();
    }

  /**
   * Constructor
   */
    public Invoice(InvoiceStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Identifier of this Invoice, often used for reference in correspondence about this invoice or for tracking of payments.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Invoice setIdentifier(List<Identifier> theIdentifier) { 
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

    public Invoice addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The current state of the Invoice.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<InvoiceStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<InvoiceStatus>(new InvoiceStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the Invoice.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Invoice setStatusElement(Enumeration<InvoiceStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the Invoice.
     */
    public InvoiceStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the Invoice.
     */
    public Invoice setStatus(InvoiceStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<InvoiceStatus>(new InvoiceStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #cancelledReason} (In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).). This is the underlying object with id, value and extensions. The accessor "getCancelledReason" gives direct access to the value
     */
    public StringType getCancelledReasonElement() { 
      if (this.cancelledReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.cancelledReason");
        else if (Configuration.doAutoCreate())
          this.cancelledReason = new StringType(); // bb
      return this.cancelledReason;
    }

    public boolean hasCancelledReasonElement() { 
      return this.cancelledReason != null && !this.cancelledReason.isEmpty();
    }

    public boolean hasCancelledReason() { 
      return this.cancelledReason != null && !this.cancelledReason.isEmpty();
    }

    /**
     * @param value {@link #cancelledReason} (In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).). This is the underlying object with id, value and extensions. The accessor "getCancelledReason" gives direct access to the value
     */
    public Invoice setCancelledReasonElement(StringType value) { 
      this.cancelledReason = value;
      return this;
    }

    /**
     * @return In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).
     */
    public String getCancelledReason() { 
      return this.cancelledReason == null ? null : this.cancelledReason.getValue();
    }

    /**
     * @param value In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).
     */
    public Invoice setCancelledReason(String value) { 
      if (Utilities.noString(value))
        this.cancelledReason = null;
      else {
        if (this.cancelledReason == null)
          this.cancelledReason = new StringType();
        this.cancelledReason.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary).)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary).)
     */
    public Invoice setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #subject} (The individual or set of individuals receiving the goods and services billed in this invoice.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The individual or set of individuals receiving the goods and services billed in this invoice.)
     */
    public Invoice setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #recipient} (The individual or Organization responsible for balancing of this invoice.)
     */
    public Reference getRecipient() { 
      if (this.recipient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.recipient");
        else if (Configuration.doAutoCreate())
          this.recipient = new Reference(); // cc
      return this.recipient;
    }

    public boolean hasRecipient() { 
      return this.recipient != null && !this.recipient.isEmpty();
    }

    /**
     * @param value {@link #recipient} (The individual or Organization responsible for balancing of this invoice.)
     */
    public Invoice setRecipient(Reference value) { 
      this.recipient = value;
      return this;
    }

    /**
     * @return {@link #date} (Depricared by the element below.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.date");
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
     * @param value {@link #date} (Depricared by the element below.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Invoice setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return Depricared by the element below.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value Depricared by the element below.
     */
    public Invoice setDate(Date value) { 
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
     * @return {@link #creation} (Date/time(s) of when this Invoice was posted.). This is the underlying object with id, value and extensions. The accessor "getCreation" gives direct access to the value
     */
    public DateTimeType getCreationElement() { 
      if (this.creation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.creation");
        else if (Configuration.doAutoCreate())
          this.creation = new DateTimeType(); // bb
      return this.creation;
    }

    public boolean hasCreationElement() { 
      return this.creation != null && !this.creation.isEmpty();
    }

    public boolean hasCreation() { 
      return this.creation != null && !this.creation.isEmpty();
    }

    /**
     * @param value {@link #creation} (Date/time(s) of when this Invoice was posted.). This is the underlying object with id, value and extensions. The accessor "getCreation" gives direct access to the value
     */
    public Invoice setCreationElement(DateTimeType value) { 
      this.creation = value;
      return this;
    }

    /**
     * @return Date/time(s) of when this Invoice was posted.
     */
    public Date getCreation() { 
      return this.creation == null ? null : this.creation.getValue();
    }

    /**
     * @param value Date/time(s) of when this Invoice was posted.
     */
    public Invoice setCreation(Date value) { 
      if (value == null)
        this.creation = null;
      else {
        if (this.creation == null)
          this.creation = new DateTimeType();
        this.creation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #period} (Date/time(s) range of services included in this invoice.)
     */
    public DataType getPeriod() { 
      return this.period;
    }

    /**
     * @return {@link #period} (Date/time(s) range of services included in this invoice.)
     */
    public DateType getPeriodDateType() throws FHIRException { 
      if (this.period == null)
        this.period = new DateType();
      if (!(this.period instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.period.getClass().getName()+" was encountered");
      return (DateType) this.period;
    }

    public boolean hasPeriodDateType() { 
      return this != null && this.period instanceof DateType;
    }

    /**
     * @return {@link #period} (Date/time(s) range of services included in this invoice.)
     */
    public Period getPeriodPeriod() throws FHIRException { 
      if (this.period == null)
        this.period = new Period();
      if (!(this.period instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.period.getClass().getName()+" was encountered");
      return (Period) this.period;
    }

    public boolean hasPeriodPeriod() { 
      return this != null && this.period instanceof Period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Date/time(s) range of services included in this invoice.)
     */
    public Invoice setPeriod(DataType value) { 
      if (value != null && !(value instanceof DateType || value instanceof Period))
        throw new FHIRException("Not the right type for Invoice.period[x]: "+value.fhirType());
      this.period = value;
      return this;
    }

    /**
     * @return {@link #participant} (Indicates who or what performed or participated in the charged service.)
     */
    public List<InvoiceParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<InvoiceParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Invoice setParticipant(List<InvoiceParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (InvoiceParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InvoiceParticipantComponent addParticipant() { //3
      InvoiceParticipantComponent t = new InvoiceParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<InvoiceParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public Invoice addParticipant(InvoiceParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<InvoiceParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public InvoiceParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #issuer} (The organizationissuing the Invoice.)
     */
    public Reference getIssuer() { 
      if (this.issuer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.issuer");
        else if (Configuration.doAutoCreate())
          this.issuer = new Reference(); // cc
      return this.issuer;
    }

    public boolean hasIssuer() { 
      return this.issuer != null && !this.issuer.isEmpty();
    }

    /**
     * @param value {@link #issuer} (The organizationissuing the Invoice.)
     */
    public Invoice setIssuer(Reference value) { 
      this.issuer = value;
      return this;
    }

    /**
     * @return {@link #account} (Account which is supposed to be balanced with this Invoice.)
     */
    public Reference getAccount() { 
      if (this.account == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.account");
        else if (Configuration.doAutoCreate())
          this.account = new Reference(); // cc
      return this.account;
    }

    public boolean hasAccount() { 
      return this.account != null && !this.account.isEmpty();
    }

    /**
     * @param value {@link #account} (Account which is supposed to be balanced with this Invoice.)
     */
    public Invoice setAccount(Reference value) { 
      this.account = value;
      return this;
    }

    /**
     * @return {@link #lineItem} (Each line item represents one charge for goods and services rendered. Details such.ofType(date), code and amount are found in the referenced ChargeItem resource.)
     */
    public List<InvoiceLineItemComponent> getLineItem() { 
      if (this.lineItem == null)
        this.lineItem = new ArrayList<InvoiceLineItemComponent>();
      return this.lineItem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Invoice setLineItem(List<InvoiceLineItemComponent> theLineItem) { 
      this.lineItem = theLineItem;
      return this;
    }

    public boolean hasLineItem() { 
      if (this.lineItem == null)
        return false;
      for (InvoiceLineItemComponent item : this.lineItem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InvoiceLineItemComponent addLineItem() { //3
      InvoiceLineItemComponent t = new InvoiceLineItemComponent();
      if (this.lineItem == null)
        this.lineItem = new ArrayList<InvoiceLineItemComponent>();
      this.lineItem.add(t);
      return t;
    }

    public Invoice addLineItem(InvoiceLineItemComponent t) { //3
      if (t == null)
        return this;
      if (this.lineItem == null)
        this.lineItem = new ArrayList<InvoiceLineItemComponent>();
      this.lineItem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #lineItem}, creating it if it does not already exist {3}
     */
    public InvoiceLineItemComponent getLineItemFirstRep() { 
      if (getLineItem().isEmpty()) {
        addLineItem();
      }
      return getLineItem().get(0);
    }

    /**
     * @return {@link #totalPriceComponent} (The total amount for the Invoice may be calculated as the sum of the line items with surcharges/deductions that apply in certain conditions.  The priceComponent element can be used to offer transparency to the recipient of the Invoice of how the total price was calculated.)
     */
    public List<MonetaryComponent> getTotalPriceComponent() { 
      if (this.totalPriceComponent == null)
        this.totalPriceComponent = new ArrayList<MonetaryComponent>();
      return this.totalPriceComponent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Invoice setTotalPriceComponent(List<MonetaryComponent> theTotalPriceComponent) { 
      this.totalPriceComponent = theTotalPriceComponent;
      return this;
    }

    public boolean hasTotalPriceComponent() { 
      if (this.totalPriceComponent == null)
        return false;
      for (MonetaryComponent item : this.totalPriceComponent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MonetaryComponent addTotalPriceComponent() { //3
      MonetaryComponent t = new MonetaryComponent();
      if (this.totalPriceComponent == null)
        this.totalPriceComponent = new ArrayList<MonetaryComponent>();
      this.totalPriceComponent.add(t);
      return t;
    }

    public Invoice addTotalPriceComponent(MonetaryComponent t) { //3
      if (t == null)
        return this;
      if (this.totalPriceComponent == null)
        this.totalPriceComponent = new ArrayList<MonetaryComponent>();
      this.totalPriceComponent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #totalPriceComponent}, creating it if it does not already exist {3}
     */
    public MonetaryComponent getTotalPriceComponentFirstRep() { 
      if (getTotalPriceComponent().isEmpty()) {
        addTotalPriceComponent();
      }
      return getTotalPriceComponent().get(0);
    }

    /**
     * @return {@link #totalNet} (Invoice total , taxes excluded.)
     */
    public Money getTotalNet() { 
      if (this.totalNet == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.totalNet");
        else if (Configuration.doAutoCreate())
          this.totalNet = new Money(); // cc
      return this.totalNet;
    }

    public boolean hasTotalNet() { 
      return this.totalNet != null && !this.totalNet.isEmpty();
    }

    /**
     * @param value {@link #totalNet} (Invoice total , taxes excluded.)
     */
    public Invoice setTotalNet(Money value) { 
      this.totalNet = value;
      return this;
    }

    /**
     * @return {@link #totalGross} (Invoice total, tax included.)
     */
    public Money getTotalGross() { 
      if (this.totalGross == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.totalGross");
        else if (Configuration.doAutoCreate())
          this.totalGross = new Money(); // cc
      return this.totalGross;
    }

    public boolean hasTotalGross() { 
      return this.totalGross != null && !this.totalGross.isEmpty();
    }

    /**
     * @param value {@link #totalGross} (Invoice total, tax included.)
     */
    public Invoice setTotalGross(Money value) { 
      this.totalGross = value;
      return this;
    }

    /**
     * @return {@link #paymentTerms} (Payment details such as banking details, period of payment, deductibles, methods of payment.). This is the underlying object with id, value and extensions. The accessor "getPaymentTerms" gives direct access to the value
     */
    public MarkdownType getPaymentTermsElement() { 
      if (this.paymentTerms == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Invoice.paymentTerms");
        else if (Configuration.doAutoCreate())
          this.paymentTerms = new MarkdownType(); // bb
      return this.paymentTerms;
    }

    public boolean hasPaymentTermsElement() { 
      return this.paymentTerms != null && !this.paymentTerms.isEmpty();
    }

    public boolean hasPaymentTerms() { 
      return this.paymentTerms != null && !this.paymentTerms.isEmpty();
    }

    /**
     * @param value {@link #paymentTerms} (Payment details such as banking details, period of payment, deductibles, methods of payment.). This is the underlying object with id, value and extensions. The accessor "getPaymentTerms" gives direct access to the value
     */
    public Invoice setPaymentTermsElement(MarkdownType value) { 
      this.paymentTerms = value;
      return this;
    }

    /**
     * @return Payment details such as banking details, period of payment, deductibles, methods of payment.
     */
    public String getPaymentTerms() { 
      return this.paymentTerms == null ? null : this.paymentTerms.getValue();
    }

    /**
     * @param value Payment details such as banking details, period of payment, deductibles, methods of payment.
     */
    public Invoice setPaymentTerms(String value) { 
      if (Utilities.noString(value))
        this.paymentTerms = null;
      else {
        if (this.paymentTerms == null)
          this.paymentTerms = new MarkdownType();
        this.paymentTerms.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Comments made about the invoice by the issuer, subject, or other participants.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Invoice setNote(List<Annotation> theNote) { 
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

    public Invoice addNote(Annotation t) { //3
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
        children.add(new Property("identifier", "Identifier", "Identifier of this Invoice, often used for reference in correspondence about this invoice or for tracking of payments.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the Invoice.", 0, 1, status));
        children.add(new Property("cancelledReason", "string", "In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).", 0, 1, cancelledReason));
        children.add(new Property("type", "CodeableConcept", "Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary).", 0, 1, type));
        children.add(new Property("subject", "Reference(Patient|Group)", "The individual or set of individuals receiving the goods and services billed in this invoice.", 0, 1, subject));
        children.add(new Property("recipient", "Reference(Organization|Patient|RelatedPerson)", "The individual or Organization responsible for balancing of this invoice.", 0, 1, recipient));
        children.add(new Property("date", "dateTime", "Depricared by the element below.", 0, 1, date));
        children.add(new Property("creation", "dateTime", "Date/time(s) of when this Invoice was posted.", 0, 1, creation));
        children.add(new Property("period[x]", "date|Period", "Date/time(s) range of services included in this invoice.", 0, 1, period));
        children.add(new Property("participant", "", "Indicates who or what performed or participated in the charged service.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("issuer", "Reference(Organization)", "The organizationissuing the Invoice.", 0, 1, issuer));
        children.add(new Property("account", "Reference(Account)", "Account which is supposed to be balanced with this Invoice.", 0, 1, account));
        children.add(new Property("lineItem", "", "Each line item represents one charge for goods and services rendered. Details such.ofType(date), code and amount are found in the referenced ChargeItem resource.", 0, java.lang.Integer.MAX_VALUE, lineItem));
        children.add(new Property("totalPriceComponent", "MonetaryComponent", "The total amount for the Invoice may be calculated as the sum of the line items with surcharges/deductions that apply in certain conditions.  The priceComponent element can be used to offer transparency to the recipient of the Invoice of how the total price was calculated.", 0, java.lang.Integer.MAX_VALUE, totalPriceComponent));
        children.add(new Property("totalNet", "Money", "Invoice total , taxes excluded.", 0, 1, totalNet));
        children.add(new Property("totalGross", "Money", "Invoice total, tax included.", 0, 1, totalGross));
        children.add(new Property("paymentTerms", "markdown", "Payment details such as banking details, period of payment, deductibles, methods of payment.", 0, 1, paymentTerms));
        children.add(new Property("note", "Annotation", "Comments made about the invoice by the issuer, subject, or other participants.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier of this Invoice, often used for reference in correspondence about this invoice or for tracking of payments.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the Invoice.", 0, 1, status);
        case 1550362357: /*cancelledReason*/  return new Property("cancelledReason", "string", "In case of Invoice cancellation a reason must be given (entered in error, superseded by corrected invoice etc.).", 0, 1, cancelledReason);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental, preliminary).", 0, 1, type);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The individual or set of individuals receiving the goods and services billed in this invoice.", 0, 1, subject);
        case 820081177: /*recipient*/  return new Property("recipient", "Reference(Organization|Patient|RelatedPerson)", "The individual or Organization responsible for balancing of this invoice.", 0, 1, recipient);
        case 3076014: /*date*/  return new Property("date", "dateTime", "Depricared by the element below.", 0, 1, date);
        case 1820421855: /*creation*/  return new Property("creation", "dateTime", "Date/time(s) of when this Invoice was posted.", 0, 1, creation);
        case 566594335: /*period[x]*/  return new Property("period[x]", "date|Period", "Date/time(s) range of services included in this invoice.", 0, 1, period);
        case -991726143: /*period*/  return new Property("period[x]", "date|Period", "Date/time(s) range of services included in this invoice.", 0, 1, period);
        case 383848719: /*periodDate*/  return new Property("period[x]", "date", "Date/time(s) range of services included in this invoice.", 0, 1, period);
        case -141376798: /*periodPeriod*/  return new Property("period[x]", "Period", "Date/time(s) range of services included in this invoice.", 0, 1, period);
        case 767422259: /*participant*/  return new Property("participant", "", "Indicates who or what performed or participated in the charged service.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -1179159879: /*issuer*/  return new Property("issuer", "Reference(Organization)", "The organizationissuing the Invoice.", 0, 1, issuer);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "Account which is supposed to be balanced with this Invoice.", 0, 1, account);
        case 1188332839: /*lineItem*/  return new Property("lineItem", "", "Each line item represents one charge for goods and services rendered. Details such.ofType(date), code and amount are found in the referenced ChargeItem resource.", 0, java.lang.Integer.MAX_VALUE, lineItem);
        case 1731497496: /*totalPriceComponent*/  return new Property("totalPriceComponent", "MonetaryComponent", "The total amount for the Invoice may be calculated as the sum of the line items with surcharges/deductions that apply in certain conditions.  The priceComponent element can be used to offer transparency to the recipient of the Invoice of how the total price was calculated.", 0, java.lang.Integer.MAX_VALUE, totalPriceComponent);
        case -849911879: /*totalNet*/  return new Property("totalNet", "Money", "Invoice total , taxes excluded.", 0, 1, totalNet);
        case -727607968: /*totalGross*/  return new Property("totalGross", "Money", "Invoice total, tax included.", 0, 1, totalGross);
        case -507544799: /*paymentTerms*/  return new Property("paymentTerms", "markdown", "Payment details such as banking details, period of payment, deductibles, methods of payment.", 0, 1, paymentTerms);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments made about the invoice by the issuer, subject, or other participants.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<InvoiceStatus>
        case 1550362357: /*cancelledReason*/ return this.cancelledReason == null ? new Base[0] : new Base[] {this.cancelledReason}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 820081177: /*recipient*/ return this.recipient == null ? new Base[0] : new Base[] {this.recipient}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1820421855: /*creation*/ return this.creation == null ? new Base[0] : new Base[] {this.creation}; // DateTimeType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // DataType
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // InvoiceParticipantComponent
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // Reference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : new Base[] {this.account}; // Reference
        case 1188332839: /*lineItem*/ return this.lineItem == null ? new Base[0] : this.lineItem.toArray(new Base[this.lineItem.size()]); // InvoiceLineItemComponent
        case 1731497496: /*totalPriceComponent*/ return this.totalPriceComponent == null ? new Base[0] : this.totalPriceComponent.toArray(new Base[this.totalPriceComponent.size()]); // MonetaryComponent
        case -849911879: /*totalNet*/ return this.totalNet == null ? new Base[0] : new Base[] {this.totalNet}; // Money
        case -727607968: /*totalGross*/ return this.totalGross == null ? new Base[0] : new Base[] {this.totalGross}; // Money
        case -507544799: /*paymentTerms*/ return this.paymentTerms == null ? new Base[0] : new Base[] {this.paymentTerms}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
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
          value = new InvoiceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InvoiceStatus>
          return value;
        case 1550362357: // cancelledReason
          this.cancelledReason = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 820081177: // recipient
          this.recipient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1820421855: // creation
          this.creation = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToType(value); // DataType
          return value;
        case 767422259: // participant
          this.getParticipant().add((InvoiceParticipantComponent) value); // InvoiceParticipantComponent
          return value;
        case -1179159879: // issuer
          this.issuer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1177318867: // account
          this.account = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1188332839: // lineItem
          this.getLineItem().add((InvoiceLineItemComponent) value); // InvoiceLineItemComponent
          return value;
        case 1731497496: // totalPriceComponent
          this.getTotalPriceComponent().add(TypeConvertor.castToMonetaryComponent(value)); // MonetaryComponent
          return value;
        case -849911879: // totalNet
          this.totalNet = TypeConvertor.castToMoney(value); // Money
          return value;
        case -727607968: // totalGross
          this.totalGross = TypeConvertor.castToMoney(value); // Money
          return value;
        case -507544799: // paymentTerms
          this.paymentTerms = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new InvoiceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InvoiceStatus>
        } else if (name.equals("cancelledReason")) {
          this.cancelledReason = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("recipient")) {
          this.recipient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("creation")) {
          this.creation = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("period[x]")) {
          this.period = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("participant")) {
          this.getParticipant().add((InvoiceParticipantComponent) value);
        } else if (name.equals("issuer")) {
          this.issuer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("account")) {
          this.account = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("lineItem")) {
          this.getLineItem().add((InvoiceLineItemComponent) value);
        } else if (name.equals("totalPriceComponent")) {
          this.getTotalPriceComponent().add(TypeConvertor.castToMonetaryComponent(value));
        } else if (name.equals("totalNet")) {
          this.totalNet = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("totalGross")) {
          this.totalGross = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("paymentTerms")) {
          this.paymentTerms = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new InvoiceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InvoiceStatus>
        } else if (name.equals("cancelledReason")) {
          this.cancelledReason = null;
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("recipient")) {
          this.recipient = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("creation")) {
          this.creation = null;
        } else if (name.equals("period[x]")) {
          this.period = null;
        } else if (name.equals("participant")) {
          this.getParticipant().remove((InvoiceParticipantComponent) value);
        } else if (name.equals("issuer")) {
          this.issuer = null;
        } else if (name.equals("account")) {
          this.account = null;
        } else if (name.equals("lineItem")) {
          this.getLineItem().remove((InvoiceLineItemComponent) value);
        } else if (name.equals("totalPriceComponent")) {
          this.getTotalPriceComponent().remove(value);
        } else if (name.equals("totalNet")) {
          this.totalNet = null;
        } else if (name.equals("totalGross")) {
          this.totalGross = null;
        } else if (name.equals("paymentTerms")) {
          this.paymentTerms = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 1550362357:  return getCancelledReasonElement();
        case 3575610:  return getType();
        case -1867885268:  return getSubject();
        case 820081177:  return getRecipient();
        case 3076014:  return getDateElement();
        case 1820421855:  return getCreationElement();
        case 566594335:  return getPeriod();
        case -991726143:  return getPeriod();
        case 767422259:  return addParticipant(); 
        case -1179159879:  return getIssuer();
        case -1177318867:  return getAccount();
        case 1188332839:  return addLineItem(); 
        case 1731497496:  return addTotalPriceComponent(); 
        case -849911879:  return getTotalNet();
        case -727607968:  return getTotalGross();
        case -507544799:  return getPaymentTermsElement();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1550362357: /*cancelledReason*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 820081177: /*recipient*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1820421855: /*creation*/ return new String[] {"dateTime"};
        case -991726143: /*period*/ return new String[] {"date", "Period"};
        case 767422259: /*participant*/ return new String[] {};
        case -1179159879: /*issuer*/ return new String[] {"Reference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case 1188332839: /*lineItem*/ return new String[] {};
        case 1731497496: /*totalPriceComponent*/ return new String[] {"MonetaryComponent"};
        case -849911879: /*totalNet*/ return new String[] {"Money"};
        case -727607968: /*totalGross*/ return new String[] {"Money"};
        case -507544799: /*paymentTerms*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.status");
        }
        else if (name.equals("cancelledReason")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.cancelledReason");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("recipient")) {
          this.recipient = new Reference();
          return this.recipient;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.date");
        }
        else if (name.equals("creation")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.creation");
        }
        else if (name.equals("periodDate")) {
          this.period = new DateType();
          return this.period;
        }
        else if (name.equals("periodPeriod")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("issuer")) {
          this.issuer = new Reference();
          return this.issuer;
        }
        else if (name.equals("account")) {
          this.account = new Reference();
          return this.account;
        }
        else if (name.equals("lineItem")) {
          return addLineItem();
        }
        else if (name.equals("totalPriceComponent")) {
          return addTotalPriceComponent();
        }
        else if (name.equals("totalNet")) {
          this.totalNet = new Money();
          return this.totalNet;
        }
        else if (name.equals("totalGross")) {
          this.totalGross = new Money();
          return this.totalGross;
        }
        else if (name.equals("paymentTerms")) {
          throw new FHIRException("Cannot call addChild on a singleton property Invoice.paymentTerms");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Invoice";

  }

      public Invoice copy() {
        Invoice dst = new Invoice();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Invoice dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.cancelledReason = cancelledReason == null ? null : cancelledReason.copy();
        dst.type = type == null ? null : type.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.recipient = recipient == null ? null : recipient.copy();
        dst.date = date == null ? null : date.copy();
        dst.creation = creation == null ? null : creation.copy();
        dst.period = period == null ? null : period.copy();
        if (participant != null) {
          dst.participant = new ArrayList<InvoiceParticipantComponent>();
          for (InvoiceParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.account = account == null ? null : account.copy();
        if (lineItem != null) {
          dst.lineItem = new ArrayList<InvoiceLineItemComponent>();
          for (InvoiceLineItemComponent i : lineItem)
            dst.lineItem.add(i.copy());
        };
        if (totalPriceComponent != null) {
          dst.totalPriceComponent = new ArrayList<MonetaryComponent>();
          for (MonetaryComponent i : totalPriceComponent)
            dst.totalPriceComponent.add(i.copy());
        };
        dst.totalNet = totalNet == null ? null : totalNet.copy();
        dst.totalGross = totalGross == null ? null : totalGross.copy();
        dst.paymentTerms = paymentTerms == null ? null : paymentTerms.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected Invoice typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Invoice))
          return false;
        Invoice o = (Invoice) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(cancelledReason, o.cancelledReason, true)
           && compareDeep(type, o.type, true) && compareDeep(subject, o.subject, true) && compareDeep(recipient, o.recipient, true)
           && compareDeep(date, o.date, true) && compareDeep(creation, o.creation, true) && compareDeep(period, o.period, true)
           && compareDeep(participant, o.participant, true) && compareDeep(issuer, o.issuer, true) && compareDeep(account, o.account, true)
           && compareDeep(lineItem, o.lineItem, true) && compareDeep(totalPriceComponent, o.totalPriceComponent, true)
           && compareDeep(totalNet, o.totalNet, true) && compareDeep(totalGross, o.totalGross, true) && compareDeep(paymentTerms, o.paymentTerms, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Invoice))
          return false;
        Invoice o = (Invoice) other_;
        return compareValues(status, o.status, true) && compareValues(cancelledReason, o.cancelledReason, true)
           && compareValues(date, o.date, true) && compareValues(creation, o.creation, true) && compareValues(paymentTerms, o.paymentTerms, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, cancelledReason
          , type, subject, recipient, date, creation, period, participant, issuer, account
          , lineItem, totalPriceComponent, totalNet, totalGross, paymentTerms, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Invoice;
   }

 /**
   * Search parameter: <b>account</b>
   * <p>
   * Description: <b>Account that is being balanced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.account</b><br>
   * </p>
   */
  @SearchParamDefinition(name="account", path="Invoice.account", description="Account that is being balanced", type="reference", target={Account.class } )
  public static final String SP_ACCOUNT = "account";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>account</b>
   * <p>
   * Description: <b>Account that is being balanced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.account</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACCOUNT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACCOUNT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Invoice:account</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACCOUNT = new ca.uhn.fhir.model.api.Include("Invoice:account").toLocked();

 /**
   * Search parameter: <b>issuer</b>
   * <p>
   * Description: <b>Issuing Organization of Invoice</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.issuer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="issuer", path="Invoice.issuer", description="Issuing Organization of Invoice", type="reference", target={Organization.class } )
  public static final String SP_ISSUER = "issuer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>issuer</b>
   * <p>
   * Description: <b>Issuing Organization of Invoice</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.issuer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ISSUER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ISSUER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Invoice:issuer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ISSUER = new ca.uhn.fhir.model.api.Include("Invoice:issuer").toLocked();

 /**
   * Search parameter: <b>participant-role</b>
   * <p>
   * Description: <b>Type of involvement in creation of this Invoice</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Invoice.participant.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant-role", path="Invoice.participant.role", description="Type of involvement in creation of this Invoice", type="token" )
  public static final String SP_PARTICIPANT_ROLE = "participant-role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant-role</b>
   * <p>
   * Description: <b>Type of involvement in creation of this Invoice</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Invoice.participant.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PARTICIPANT_ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PARTICIPANT_ROLE);

 /**
   * Search parameter: <b>participant</b>
   * <p>
   * Description: <b>Individual who was involved</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.participant.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant", path="Invoice.participant.actor", description="Individual who was involved", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PARTICIPANT = "participant";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant</b>
   * <p>
   * Description: <b>Individual who was involved</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.participant.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTICIPANT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTICIPANT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Invoice:participant</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTICIPANT = new ca.uhn.fhir.model.api.Include("Invoice:participant").toLocked();

 /**
   * Search parameter: <b>recipient</b>
   * <p>
   * Description: <b>Recipient of this invoice</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.recipient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recipient", path="Invoice.recipient", description="Recipient of this invoice", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Organization.class, Patient.class, RelatedPerson.class } )
  public static final String SP_RECIPIENT = "recipient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recipient</b>
   * <p>
   * Description: <b>Recipient of this invoice</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.recipient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECIPIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RECIPIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Invoice:recipient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECIPIENT = new ca.uhn.fhir.model.api.Include("Invoice:recipient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | issued | balanced | cancelled | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Invoice.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Invoice.status", description="draft | issued | balanced | cancelled | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | issued | balanced | cancelled | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Invoice.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Recipient(s) of goods and services</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Invoice.subject", description="Recipient(s) of goods and services", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Recipient(s) of goods and services</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Invoice.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Invoice:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Invoice:subject").toLocked();

 /**
   * Search parameter: <b>totalgross</b>
   * <p>
   * Description: <b>Gross total of this Invoice</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Invoice.totalGross</b><br>
   * </p>
   */
  @SearchParamDefinition(name="totalgross", path="Invoice.totalGross", description="Gross total of this Invoice", type="quantity" )
  public static final String SP_TOTALGROSS = "totalgross";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>totalgross</b>
   * <p>
   * Description: <b>Gross total of this Invoice</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Invoice.totalGross</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam TOTALGROSS = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_TOTALGROSS);

 /**
   * Search parameter: <b>totalnet</b>
   * <p>
   * Description: <b>Net total of this Invoice</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Invoice.totalNet</b><br>
   * </p>
   */
  @SearchParamDefinition(name="totalnet", path="Invoice.totalNet", description="Net total of this Invoice", type="quantity" )
  public static final String SP_TOTALNET = "totalnet";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>totalnet</b>
   * <p>
   * Description: <b>Net total of this Invoice</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Invoice.totalNet</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam TOTALNET = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_TOTALNET);

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
   * the path value of "<b>Invoice:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Invoice:patient").toLocked();

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


}

