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
 * Record of delivery of what is supplied.
 */
@ResourceDef(name="SupplyDelivery", profile="http://hl7.org/fhir/StructureDefinition/SupplyDelivery")
public class SupplyDelivery extends DomainResource {

    public enum SupplyDeliveryStatus {
        /**
         * Supply has been requested, but not delivered.
         */
        INPROGRESS, 
        /**
         * Supply has been delivered (\"completed\").
         */
        COMPLETED, 
        /**
         * Delivery was not completed.
         */
        ABANDONED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"abandoned\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SupplyDeliveryStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("abandoned".equals(codeString))
          return ABANDONED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SupplyDeliveryStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INPROGRESS: return "in-progress";
            case COMPLETED: return "completed";
            case ABANDONED: return "abandoned";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INPROGRESS: return "http://hl7.org/fhir/supplydelivery-status";
            case COMPLETED: return "http://hl7.org/fhir/supplydelivery-status";
            case ABANDONED: return "http://hl7.org/fhir/supplydelivery-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/supplydelivery-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INPROGRESS: return "Supply has been requested, but not delivered.";
            case COMPLETED: return "Supply has been delivered (\"completed\").";
            case ABANDONED: return "Delivery was not completed.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"abandoned\" rather than \"entered-in-error\".).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INPROGRESS: return "In Progress";
            case COMPLETED: return "Delivered";
            case ABANDONED: return "Abandoned";
            case ENTEREDINERROR: return "Entered In Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SupplyDeliveryStatusEnumFactory implements EnumFactory<SupplyDeliveryStatus> {
    public SupplyDeliveryStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return SupplyDeliveryStatus.INPROGRESS;
        if ("completed".equals(codeString))
          return SupplyDeliveryStatus.COMPLETED;
        if ("abandoned".equals(codeString))
          return SupplyDeliveryStatus.ABANDONED;
        if ("entered-in-error".equals(codeString))
          return SupplyDeliveryStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown SupplyDeliveryStatus code '"+codeString+"'");
        }
        public Enumeration<SupplyDeliveryStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SupplyDeliveryStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("in-progress".equals(codeString))
          return new Enumeration<SupplyDeliveryStatus>(this, SupplyDeliveryStatus.INPROGRESS);
        if ("completed".equals(codeString))
          return new Enumeration<SupplyDeliveryStatus>(this, SupplyDeliveryStatus.COMPLETED);
        if ("abandoned".equals(codeString))
          return new Enumeration<SupplyDeliveryStatus>(this, SupplyDeliveryStatus.ABANDONED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<SupplyDeliveryStatus>(this, SupplyDeliveryStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown SupplyDeliveryStatus code '"+codeString+"'");
        }
    public String toCode(SupplyDeliveryStatus code) {
      if (code == SupplyDeliveryStatus.INPROGRESS)
        return "in-progress";
      if (code == SupplyDeliveryStatus.COMPLETED)
        return "completed";
      if (code == SupplyDeliveryStatus.ABANDONED)
        return "abandoned";
      if (code == SupplyDeliveryStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(SupplyDeliveryStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SupplyDeliverySuppliedItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The amount of the item that has been supplied.  Unit of measure may be included.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Amount supplied", formalDefinition="The amount of the item that has been supplied.  Unit of measure may be included." )
        protected Quantity quantity;

        /**
         * Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.
         */
        @Child(name = "item", type = {CodeableConcept.class, Medication.class, Substance.class, Device.class, BiologicallyDerivedProduct.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Medication, Substance, Device or Biologically Derived Product supplied", formalDefinition="Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplydelivery-supplyitemtype")
        protected DataType item;

        private static final long serialVersionUID = -615919419L;

    /**
     * Constructor
     */
      public SupplyDeliverySuppliedItemComponent() {
        super();
      }

        /**
         * @return {@link #quantity} (The amount of the item that has been supplied.  Unit of measure may be included.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SupplyDeliverySuppliedItemComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The amount of the item that has been supplied.  Unit of measure may be included.)
         */
        public SupplyDeliverySuppliedItemComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #item} (Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        /**
         * @return {@link #item} (Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
         */
        public SupplyDeliverySuppliedItemComponent setItem(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for SupplyDelivery.suppliedItem.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("quantity", "Quantity", "The amount of the item that has been supplied.  Unit of measure may be included.", 0, 1, quantity));
          children.add(new Property("item[x]", "CodeableConcept|Reference(Medication|Substance|Device|BiologicallyDerivedProduct)", "Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The amount of the item that has been supplied.  Unit of measure may be included.", 0, 1, quantity);
          case 2116201613: /*item[x]*/  return new Property("item[x]", "CodeableConcept|Reference(Medication|Substance|Device|BiologicallyDerivedProduct)", "Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "CodeableConcept|Reference(Medication|Substance|Device|BiologicallyDerivedProduct)", "Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(Medication|Substance|Device|BiologicallyDerivedProduct)", "Identifies the medication, substance, device or biologically derived product being supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149:  return getQuantity();
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 3242771: /*item*/ return new String[] {"CodeableConcept", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public SupplyDeliverySuppliedItemComponent copy() {
        SupplyDeliverySuppliedItemComponent dst = new SupplyDeliverySuppliedItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SupplyDeliverySuppliedItemComponent dst) {
        super.copyValues(dst);
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SupplyDeliverySuppliedItemComponent))
          return false;
        SupplyDeliverySuppliedItemComponent o = (SupplyDeliverySuppliedItemComponent) other_;
        return compareDeep(quantity, o.quantity, true) && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SupplyDeliverySuppliedItemComponent))
          return false;
        SupplyDeliverySuppliedItemComponent o = (SupplyDeliverySuppliedItemComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(quantity, item);
      }

  public String fhirType() {
    return "SupplyDelivery.suppliedItem";

  }

  }

    /**
     * Identifier for the supply delivery event that is used to identify it across multiple disparate systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="External identifier", formalDefinition="Identifier for the supply delivery event that is used to identify it across multiple disparate systems." )
    protected List<Identifier> identifier;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this event.
     */
    @Child(name = "basedOn", type = {SupplyRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular event is a component or step.
     */
    @Child(name = "partOf", type = {SupplyDelivery.class, Contract.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular event is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the dispense event.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="in-progress | completed | abandoned | entered-in-error", formalDefinition="A code specifying the state of the dispense event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplydelivery-status")
    protected Enumeration<SupplyDeliveryStatus> status;

    /**
     * A link to a resource representing the person whom the delivered item is for.
     */
    @Child(name = "patient", type = {Patient.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Patient for whom the item is supplied", formalDefinition="A link to a resource representing the person whom the delivered item is for." )
    protected Reference patient;

    /**
     * Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Category of supply event", formalDefinition="Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplydelivery-supplyitemtype")
    protected CodeableConcept type;

    /**
     * The item that is being delivered or has been supplied.
     */
    @Child(name = "suppliedItem", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The item that is delivered or supplied", formalDefinition="The item that is being delivered or has been supplied." )
    protected List<SupplyDeliverySuppliedItemComponent> suppliedItem;

    /**
     * The date or time(s) the activity occurred.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When event occurred", formalDefinition="The date or time(s) the activity occurred." )
    protected DataType occurrence;

    /**
     * The individual or organization responsible for supplying the delivery.
     */
    @Child(name = "supplier", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The item supplier", formalDefinition="The individual or organization responsible for supplying the delivery." )
    protected Reference supplier;

    /**
     * Identification of the facility/location where the delivery was shipped to.
     */
    @Child(name = "destination", type = {Location.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the delivery was sent", formalDefinition="Identification of the facility/location where the delivery was shipped to." )
    protected Reference destination;

    /**
     * Identifies the individual or organization that received the delivery.
     */
    @Child(name = "receiver", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who received the delivery", formalDefinition="Identifies the individual or organization that received the delivery." )
    protected List<Reference> receiver;

    private static final long serialVersionUID = -734856482L;

  /**
   * Constructor
   */
    public SupplyDelivery() {
      super();
    }

    /**
     * @return {@link #identifier} (Identifier for the supply delivery event that is used to identify it across multiple disparate systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyDelivery setIdentifier(List<Identifier> theIdentifier) { 
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

    public SupplyDelivery addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this event.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyDelivery setBasedOn(List<Reference> theBasedOn) { 
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

    public SupplyDelivery addBasedOn(Reference t) { //3
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
    public SupplyDelivery setPartOf(List<Reference> thePartOf) { 
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

    public SupplyDelivery addPartOf(Reference t) { //3
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
     * @return {@link #status} (A code specifying the state of the dispense event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<SupplyDeliveryStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyDelivery.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SupplyDeliveryStatus>(new SupplyDeliveryStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the dispense event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public SupplyDelivery setStatusElement(Enumeration<SupplyDeliveryStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the dispense event.
     */
    public SupplyDeliveryStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the dispense event.
     */
    public SupplyDelivery setStatus(SupplyDeliveryStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<SupplyDeliveryStatus>(new SupplyDeliveryStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #patient} (A link to a resource representing the person whom the delivered item is for.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyDelivery.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (A link to a resource representing the person whom the delivered item is for.)
     */
    public SupplyDelivery setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #type} (Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyDelivery.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product.)
     */
    public SupplyDelivery setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #suppliedItem} (The item that is being delivered or has been supplied.)
     */
    public List<SupplyDeliverySuppliedItemComponent> getSuppliedItem() { 
      if (this.suppliedItem == null)
        this.suppliedItem = new ArrayList<SupplyDeliverySuppliedItemComponent>();
      return this.suppliedItem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyDelivery setSuppliedItem(List<SupplyDeliverySuppliedItemComponent> theSuppliedItem) { 
      this.suppliedItem = theSuppliedItem;
      return this;
    }

    public boolean hasSuppliedItem() { 
      if (this.suppliedItem == null)
        return false;
      for (SupplyDeliverySuppliedItemComponent item : this.suppliedItem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SupplyDeliverySuppliedItemComponent addSuppliedItem() { //3
      SupplyDeliverySuppliedItemComponent t = new SupplyDeliverySuppliedItemComponent();
      if (this.suppliedItem == null)
        this.suppliedItem = new ArrayList<SupplyDeliverySuppliedItemComponent>();
      this.suppliedItem.add(t);
      return t;
    }

    public SupplyDelivery addSuppliedItem(SupplyDeliverySuppliedItemComponent t) { //3
      if (t == null)
        return this;
      if (this.suppliedItem == null)
        this.suppliedItem = new ArrayList<SupplyDeliverySuppliedItemComponent>();
      this.suppliedItem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #suppliedItem}, creating it if it does not already exist {3}
     */
    public SupplyDeliverySuppliedItemComponent getSuppliedItemFirstRep() { 
      if (getSuppliedItem().isEmpty()) {
        addSuppliedItem();
      }
      return getSuppliedItem().get(0);
    }

    /**
     * @return {@link #occurrence} (The date or time(s) the activity occurred.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The date or time(s) the activity occurred.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (The date or time(s) the activity occurred.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    /**
     * @return {@link #occurrence} (The date or time(s) the activity occurred.)
     */
    public Timing getOccurrenceTiming() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Timing();
      if (!(this.occurrence instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Timing) this.occurrence;
    }

    public boolean hasOccurrenceTiming() { 
      return this != null && this.occurrence instanceof Timing;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The date or time(s) the activity occurred.)
     */
    public SupplyDelivery setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new Error("Not the right type for SupplyDelivery.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #supplier} (The individual or organization responsible for supplying the delivery.)
     */
    public Reference getSupplier() { 
      if (this.supplier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyDelivery.supplier");
        else if (Configuration.doAutoCreate())
          this.supplier = new Reference(); // cc
      return this.supplier;
    }

    public boolean hasSupplier() { 
      return this.supplier != null && !this.supplier.isEmpty();
    }

    /**
     * @param value {@link #supplier} (The individual or organization responsible for supplying the delivery.)
     */
    public SupplyDelivery setSupplier(Reference value) { 
      this.supplier = value;
      return this;
    }

    /**
     * @return {@link #destination} (Identification of the facility/location where the delivery was shipped to.)
     */
    public Reference getDestination() { 
      if (this.destination == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyDelivery.destination");
        else if (Configuration.doAutoCreate())
          this.destination = new Reference(); // cc
      return this.destination;
    }

    public boolean hasDestination() { 
      return this.destination != null && !this.destination.isEmpty();
    }

    /**
     * @param value {@link #destination} (Identification of the facility/location where the delivery was shipped to.)
     */
    public SupplyDelivery setDestination(Reference value) { 
      this.destination = value;
      return this;
    }

    /**
     * @return {@link #receiver} (Identifies the individual or organization that received the delivery.)
     */
    public List<Reference> getReceiver() { 
      if (this.receiver == null)
        this.receiver = new ArrayList<Reference>();
      return this.receiver;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyDelivery setReceiver(List<Reference> theReceiver) { 
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

    public SupplyDelivery addReceiver(Reference t) { //3
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for the supply delivery event that is used to identify it across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(SupplyRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(SupplyDelivery|Contract)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the dispense event.", 0, 1, status));
        children.add(new Property("patient", "Reference(Patient)", "A link to a resource representing the person whom the delivered item is for.", 0, 1, patient));
        children.add(new Property("type", "CodeableConcept", "Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product.", 0, 1, type));
        children.add(new Property("suppliedItem", "", "The item that is being delivered or has been supplied.", 0, java.lang.Integer.MAX_VALUE, suppliedItem));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "The date or time(s) the activity occurred.", 0, 1, occurrence));
        children.add(new Property("supplier", "Reference(Practitioner|PractitionerRole|Organization)", "The individual or organization responsible for supplying the delivery.", 0, 1, supplier));
        children.add(new Property("destination", "Reference(Location)", "Identification of the facility/location where the delivery was shipped to.", 0, 1, destination));
        children.add(new Property("receiver", "Reference(Practitioner|PractitionerRole|Organization)", "Identifies the individual or organization that received the delivery.", 0, java.lang.Integer.MAX_VALUE, receiver));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for the supply delivery event that is used to identify it across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(SupplyRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(SupplyDelivery|Contract)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the dispense event.", 0, 1, status);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "A link to a resource representing the person whom the delivered item is for.", 0, 1, patient);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates the type of supply being provided.  Examples include: Medication, Device, Biologically Derived Product.", 0, 1, type);
        case 1993333233: /*suppliedItem*/  return new Property("suppliedItem", "", "The item that is being delivered or has been supplied.", 0, java.lang.Integer.MAX_VALUE, suppliedItem);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date or time(s) the activity occurred.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date or time(s) the activity occurred.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The date or time(s) the activity occurred.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The date or time(s) the activity occurred.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "The date or time(s) the activity occurred.", 0, 1, occurrence);
        case -1663305268: /*supplier*/  return new Property("supplier", "Reference(Practitioner|PractitionerRole|Organization)", "The individual or organization responsible for supplying the delivery.", 0, 1, supplier);
        case -1429847026: /*destination*/  return new Property("destination", "Reference(Location)", "Identification of the facility/location where the delivery was shipped to.", 0, 1, destination);
        case -808719889: /*receiver*/  return new Property("receiver", "Reference(Practitioner|PractitionerRole|Organization)", "Identifies the individual or organization that received the delivery.", 0, java.lang.Integer.MAX_VALUE, receiver);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SupplyDeliveryStatus>
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1993333233: /*suppliedItem*/ return this.suppliedItem == null ? new Base[0] : this.suppliedItem.toArray(new Base[this.suppliedItem.size()]); // SupplyDeliverySuppliedItemComponent
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -1663305268: /*supplier*/ return this.supplier == null ? new Base[0] : new Base[] {this.supplier}; // Reference
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // Reference
        case -808719889: /*receiver*/ return this.receiver == null ? new Base[0] : this.receiver.toArray(new Base[this.receiver.size()]); // Reference
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
          value = new SupplyDeliveryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SupplyDeliveryStatus>
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1993333233: // suppliedItem
          this.getSuppliedItem().add((SupplyDeliverySuppliedItemComponent) value); // SupplyDeliverySuppliedItemComponent
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -1663305268: // supplier
          this.supplier = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToReference(value); // Reference
          return value;
        case -808719889: // receiver
          this.getReceiver().add(TypeConvertor.castToReference(value)); // Reference
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
          value = new SupplyDeliveryStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SupplyDeliveryStatus>
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("suppliedItem")) {
          this.getSuppliedItem().add((SupplyDeliverySuppliedItemComponent) value);
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("supplier")) {
          this.supplier = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("receiver")) {
          this.getReceiver().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case -791418107:  return getPatient();
        case 3575610:  return getType();
        case 1993333233:  return addSuppliedItem(); 
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -1663305268:  return getSupplier();
        case -1429847026:  return getDestination();
        case -808719889:  return addReceiver(); 
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
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1993333233: /*suppliedItem*/ return new String[] {};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case -1663305268: /*supplier*/ return new String[] {"Reference"};
        case -1429847026: /*destination*/ return new String[] {"Reference"};
        case -808719889: /*receiver*/ return new String[] {"Reference"};
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
          throw new FHIRException("Cannot call addChild on a primitive type SupplyDelivery.status");
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("suppliedItem")) {
          return addSuppliedItem();
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("occurrenceTiming")) {
          this.occurrence = new Timing();
          return this.occurrence;
        }
        else if (name.equals("supplier")) {
          this.supplier = new Reference();
          return this.supplier;
        }
        else if (name.equals("destination")) {
          this.destination = new Reference();
          return this.destination;
        }
        else if (name.equals("receiver")) {
          return addReceiver();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SupplyDelivery";

  }

      public SupplyDelivery copy() {
        SupplyDelivery dst = new SupplyDelivery();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SupplyDelivery dst) {
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
        dst.patient = patient == null ? null : patient.copy();
        dst.type = type == null ? null : type.copy();
        if (suppliedItem != null) {
          dst.suppliedItem = new ArrayList<SupplyDeliverySuppliedItemComponent>();
          for (SupplyDeliverySuppliedItemComponent i : suppliedItem)
            dst.suppliedItem.add(i.copy());
        };
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.supplier = supplier == null ? null : supplier.copy();
        dst.destination = destination == null ? null : destination.copy();
        if (receiver != null) {
          dst.receiver = new ArrayList<Reference>();
          for (Reference i : receiver)
            dst.receiver.add(i.copy());
        };
      }

      protected SupplyDelivery typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SupplyDelivery))
          return false;
        SupplyDelivery o = (SupplyDelivery) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(patient, o.patient, true) && compareDeep(type, o.type, true)
           && compareDeep(suppliedItem, o.suppliedItem, true) && compareDeep(occurrence, o.occurrence, true)
           && compareDeep(supplier, o.supplier, true) && compareDeep(destination, o.destination, true) && compareDeep(receiver, o.receiver, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SupplyDelivery))
          return false;
        SupplyDelivery o = (SupplyDelivery) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, patient, type, suppliedItem, occurrence, supplier, destination, receiver
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SupplyDelivery;
   }

 /**
   * Search parameter: <b>receiver</b>
   * <p>
   * Description: <b>Who collected the Supply</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyDelivery.receiver</b><br>
   * </p>
   */
  @SearchParamDefinition(name="receiver", path="SupplyDelivery.receiver", description="Who collected the Supply", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_RECEIVER = "receiver";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>receiver</b>
   * <p>
   * Description: <b>Who collected the Supply</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyDelivery.receiver</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECEIVER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RECEIVER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyDelivery:receiver</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECEIVER = new ca.uhn.fhir.model.api.Include("SupplyDelivery:receiver").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | abandoned | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyDelivery.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="SupplyDelivery.status", description="in-progress | completed | abandoned | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | abandoned | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyDelivery.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>supplier</b>
   * <p>
   * Description: <b>Dispenser</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyDelivery.supplier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supplier", path="SupplyDelivery.supplier", description="Dispenser", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_SUPPLIER = "supplier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supplier</b>
   * <p>
   * Description: <b>Dispenser</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyDelivery.supplier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPLIER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPLIER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyDelivery:supplier</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPLIER = new ca.uhn.fhir.model.api.Include("SupplyDelivery:supplier").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyDelivery:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("SupplyDelivery:patient").toLocked();


}

