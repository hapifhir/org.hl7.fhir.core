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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
 * A record of a request for a medication, substance or device used in the healthcare setting.
 */
@ResourceDef(name="SupplyRequest", profile="http://hl7.org/fhir/StructureDefinition/SupplyRequest")
public class SupplyRequest extends DomainResource {

    public enum SupplyRequestStatus {
        /**
         * The request has been created but is not yet complete or ready for action.
         */
        DRAFT, 
        /**
         * The request is ready to be acted upon.
         */
        ACTIVE, 
        /**
         * The authorization/request to act has been temporarily withdrawn but is expected to resume in the future.
         */
        SUSPENDED, 
        /**
         * The authorization/request to act has been terminated prior to the full completion of the intended actions.  No further activity should occur.
         */
        CANCELLED, 
        /**
         * Activity against the request has been sufficiently completed to the satisfaction of the requester.
         */
        COMPLETED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SupplyRequestStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("suspended".equals(codeString))
          return SUSPENDED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SupplyRequestStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case CANCELLED: return "cancelled";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/supplyrequest-status";
            case ACTIVE: return "http://hl7.org/fhir/supplyrequest-status";
            case SUSPENDED: return "http://hl7.org/fhir/supplyrequest-status";
            case CANCELLED: return "http://hl7.org/fhir/supplyrequest-status";
            case COMPLETED: return "http://hl7.org/fhir/supplyrequest-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/supplyrequest-status";
            case UNKNOWN: return "http://hl7.org/fhir/supplyrequest-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "The request has been created but is not yet complete or ready for action.";
            case ACTIVE: return "The request is ready to be acted upon.";
            case SUSPENDED: return "The authorization/request to act has been temporarily withdrawn but is expected to resume in the future.";
            case CANCELLED: return "The authorization/request to act has been terminated prior to the full completion of the intended actions.  No further activity should occur.";
            case COMPLETED: return "Activity against the request has been sufficiently completed to the satisfaction of the requester.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case SUSPENDED: return "Suspended";
            case CANCELLED: return "Cancelled";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            default: return "?";
          }
        }
    }

  public static class SupplyRequestStatusEnumFactory implements EnumFactory<SupplyRequestStatus> {
    public SupplyRequestStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return SupplyRequestStatus.DRAFT;
        if ("active".equals(codeString))
          return SupplyRequestStatus.ACTIVE;
        if ("suspended".equals(codeString))
          return SupplyRequestStatus.SUSPENDED;
        if ("cancelled".equals(codeString))
          return SupplyRequestStatus.CANCELLED;
        if ("completed".equals(codeString))
          return SupplyRequestStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return SupplyRequestStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return SupplyRequestStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown SupplyRequestStatus code '"+codeString+"'");
        }
        public Enumeration<SupplyRequestStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SupplyRequestStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.ACTIVE);
        if ("suspended".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.SUSPENDED);
        if ("cancelled".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.CANCELLED);
        if ("completed".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<SupplyRequestStatus>(this, SupplyRequestStatus.UNKNOWN);
        throw new FHIRException("Unknown SupplyRequestStatus code '"+codeString+"'");
        }
    public String toCode(SupplyRequestStatus code) {
      if (code == SupplyRequestStatus.DRAFT)
        return "draft";
      if (code == SupplyRequestStatus.ACTIVE)
        return "active";
      if (code == SupplyRequestStatus.SUSPENDED)
        return "suspended";
      if (code == SupplyRequestStatus.CANCELLED)
        return "cancelled";
      if (code == SupplyRequestStatus.COMPLETED)
        return "completed";
      if (code == SupplyRequestStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == SupplyRequestStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(SupplyRequestStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SupplyRequestParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code or string that identifies the device detail being asserted.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Item detail", formalDefinition="A code or string that identifies the device detail being asserted." )
        protected CodeableConcept code;

        /**
         * The value of the device detail.
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class, Range.class, BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of detail", formalDefinition="The value of the device detail." )
        protected DataType value;

        private static final long serialVersionUID = -1950789033L;

    /**
     * Constructor
     */
      public SupplyRequestParameterComponent() {
        super();
      }

        /**
         * @return {@link #code} (A code or string that identifies the device detail being asserted.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SupplyRequestParameterComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code or string that identifies the device detail being asserted.)
         */
        public SupplyRequestParameterComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the device detail.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the device detail.)
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
         * @return {@link #value} (The value of the device detail.)
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
         * @return {@link #value} (The value of the device detail.)
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
         * @return {@link #value} (The value of the device detail.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the device detail.)
         */
        public SupplyRequestParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof Range || value instanceof BooleanType))
            throw new Error("Not the right type for SupplyRequest.parameter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "A code or string that identifies the device detail being asserted.", 0, 1, code));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|Range|boolean", "The value of the device detail.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code or string that identifies the device detail being asserted.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity|Range|boolean", "The value of the device detail.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity|Range|boolean", "The value of the device detail.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the device detail.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the device detail.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the device detail.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the device detail.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "Range", "boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
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
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public SupplyRequestParameterComponent copy() {
        SupplyRequestParameterComponent dst = new SupplyRequestParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SupplyRequestParameterComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SupplyRequestParameterComponent))
          return false;
        SupplyRequestParameterComponent o = (SupplyRequestParameterComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SupplyRequestParameterComponent))
          return false;
        SupplyRequestParameterComponent o = (SupplyRequestParameterComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value);
      }

  public String fhirType() {
    return "SupplyRequest.parameter";

  }

  }

    /**
     * Business identifiers assigned to this SupplyRequest by the author and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for SupplyRequest", formalDefinition="Business identifiers assigned to this SupplyRequest by the author and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * Status of the supply request.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | suspended +", formalDefinition="Status of the supply request." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplyrequest-status")
    protected Enumeration<SupplyRequestStatus> status;

    /**
     * Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The kind of supply (central, non-stock, etc.)", formalDefinition="Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplyrequest-kind")
    protected CodeableConcept category;

    /**
     * Indicates how quickly this SupplyRequest should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly this SupplyRequest should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.
     */
    @Child(name = "item", type = {CodeableReference.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Medication, Substance, or Device requested to be supplied", formalDefinition="The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supply-item")
    protected CodeableReference item;

    /**
     * The amount that is being ordered of the indicated item.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The requested amount of the item indicated", formalDefinition="The amount that is being ordered of the indicated item." )
    protected Quantity quantity;

    /**
     * Specific parameters for the ordered item.  For example, the size of the indicated item.
     */
    @Child(name = "parameter", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Ordered item details", formalDefinition="Specific parameters for the ordered item.  For example, the size of the indicated item." )
    protected List<SupplyRequestParameterComponent> parameter;

    /**
     * When the request should be fulfilled.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the request should be fulfilled", formalDefinition="When the request should be fulfilled." )
    protected DataType occurrence;

    /**
     * When the request was made.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the request was made", formalDefinition="When the request was made." )
    protected DateTimeType authoredOn;

    /**
     * The device, practitioner, etc. who initiated the request.
     */
    @Child(name = "requester", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, RelatedPerson.class, Device.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Individual making the request", formalDefinition="The device, practitioner, etc. who initiated the request." )
    protected Reference requester;

    /**
     * Who is intended to fulfill the request.
     */
    @Child(name = "supplier", type = {Organization.class, HealthcareService.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is intended to fulfill the request", formalDefinition="Who is intended to fulfill the request." )
    protected List<Reference> supplier;

    /**
     * The reason why the supply item was requested.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The reason why the supply item was requested", formalDefinition="The reason why the supply item was requested." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/supplyrequest-reason")
    protected List<CodeableReference> reason;

    /**
     * Where the supply is expected to come from.
     */
    @Child(name = "deliverFrom", type = {Organization.class, Location.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The origin of the supply", formalDefinition="Where the supply is expected to come from." )
    protected Reference deliverFrom;

    /**
     * Where the supply is destined to go.
     */
    @Child(name = "deliverTo", type = {Organization.class, Location.class, Patient.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The destination of the supply", formalDefinition="Where the supply is destined to go." )
    protected Reference deliverTo;

    private static final long serialVersionUID = -898869904L;

  /**
   * Constructor
   */
    public SupplyRequest() {
      super();
    }

  /**
   * Constructor
   */
    public SupplyRequest(CodeableReference item, Quantity quantity) {
      super();
      this.setItem(item);
      this.setQuantity(quantity);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this SupplyRequest by the author and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyRequest setIdentifier(List<Identifier> theIdentifier) { 
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

    public SupplyRequest addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Status of the supply request.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<SupplyRequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SupplyRequestStatus>(new SupplyRequestStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Status of the supply request.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public SupplyRequest setStatusElement(Enumeration<SupplyRequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Status of the supply request.
     */
    public SupplyRequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Status of the supply request.
     */
    public SupplyRequest setStatus(SupplyRequestStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<SupplyRequestStatus>(new SupplyRequestStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process.)
     */
    public CodeableConcept getCategory() { 
      if (this.category == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.category");
        else if (Configuration.doAutoCreate())
          this.category = new CodeableConcept(); // cc
      return this.category;
    }

    public boolean hasCategory() { 
      return this.category != null && !this.category.isEmpty();
    }

    /**
     * @param value {@link #category} (Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process.)
     */
    public SupplyRequest setCategory(CodeableConcept value) { 
      this.category = value;
      return this;
    }

    /**
     * @return {@link #priority} (Indicates how quickly this SupplyRequest should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.priority");
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
     * @param value {@link #priority} (Indicates how quickly this SupplyRequest should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public SupplyRequest setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly this SupplyRequest should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly this SupplyRequest should be addressed with respect to other requests.
     */
    public SupplyRequest setPriority(RequestPriority value) { 
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
     * @return {@link #item} (The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
     */
    public CodeableReference getItem() { 
      if (this.item == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.item");
        else if (Configuration.doAutoCreate())
          this.item = new CodeableReference(); // cc
      return this.item;
    }

    public boolean hasItem() { 
      return this.item != null && !this.item.isEmpty();
    }

    /**
     * @param value {@link #item} (The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.)
     */
    public SupplyRequest setItem(CodeableReference value) { 
      this.item = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The amount that is being ordered of the indicated item.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The amount that is being ordered of the indicated item.)
     */
    public SupplyRequest setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #parameter} (Specific parameters for the ordered item.  For example, the size of the indicated item.)
     */
    public List<SupplyRequestParameterComponent> getParameter() { 
      if (this.parameter == null)
        this.parameter = new ArrayList<SupplyRequestParameterComponent>();
      return this.parameter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyRequest setParameter(List<SupplyRequestParameterComponent> theParameter) { 
      this.parameter = theParameter;
      return this;
    }

    public boolean hasParameter() { 
      if (this.parameter == null)
        return false;
      for (SupplyRequestParameterComponent item : this.parameter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SupplyRequestParameterComponent addParameter() { //3
      SupplyRequestParameterComponent t = new SupplyRequestParameterComponent();
      if (this.parameter == null)
        this.parameter = new ArrayList<SupplyRequestParameterComponent>();
      this.parameter.add(t);
      return t;
    }

    public SupplyRequest addParameter(SupplyRequestParameterComponent t) { //3
      if (t == null)
        return this;
      if (this.parameter == null)
        this.parameter = new ArrayList<SupplyRequestParameterComponent>();
      this.parameter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
     */
    public SupplyRequestParameterComponent getParameterFirstRep() { 
      if (getParameter().isEmpty()) {
        addParameter();
      }
      return getParameter().get(0);
    }

    /**
     * @return {@link #occurrence} (When the request should be fulfilled.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (When the request should be fulfilled.)
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
     * @return {@link #occurrence} (When the request should be fulfilled.)
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
     * @return {@link #occurrence} (When the request should be fulfilled.)
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
     * @param value {@link #occurrence} (When the request should be fulfilled.)
     */
    public SupplyRequest setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new Error("Not the right type for SupplyRequest.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (When the request was made.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.authoredOn");
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
     * @param value {@link #authoredOn} (When the request was made.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public SupplyRequest setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return When the request was made.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value When the request was made.
     */
    public SupplyRequest setAuthoredOn(Date value) { 
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
     * @return {@link #requester} (The device, practitioner, etc. who initiated the request.)
     */
    public Reference getRequester() { 
      if (this.requester == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.requester");
        else if (Configuration.doAutoCreate())
          this.requester = new Reference(); // cc
      return this.requester;
    }

    public boolean hasRequester() { 
      return this.requester != null && !this.requester.isEmpty();
    }

    /**
     * @param value {@link #requester} (The device, practitioner, etc. who initiated the request.)
     */
    public SupplyRequest setRequester(Reference value) { 
      this.requester = value;
      return this;
    }

    /**
     * @return {@link #supplier} (Who is intended to fulfill the request.)
     */
    public List<Reference> getSupplier() { 
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      return this.supplier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyRequest setSupplier(List<Reference> theSupplier) { 
      this.supplier = theSupplier;
      return this;
    }

    public boolean hasSupplier() { 
      if (this.supplier == null)
        return false;
      for (Reference item : this.supplier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupplier() { //3
      Reference t = new Reference();
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      this.supplier.add(t);
      return t;
    }

    public SupplyRequest addSupplier(Reference t) { //3
      if (t == null)
        return this;
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      this.supplier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supplier}, creating it if it does not already exist {3}
     */
    public Reference getSupplierFirstRep() { 
      if (getSupplier().isEmpty()) {
        addSupplier();
      }
      return getSupplier().get(0);
    }

    /**
     * @return {@link #reason} (The reason why the supply item was requested.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SupplyRequest setReason(List<CodeableReference> theReason) { 
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

    public SupplyRequest addReason(CodeableReference t) { //3
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
     * @return {@link #deliverFrom} (Where the supply is expected to come from.)
     */
    public Reference getDeliverFrom() { 
      if (this.deliverFrom == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.deliverFrom");
        else if (Configuration.doAutoCreate())
          this.deliverFrom = new Reference(); // cc
      return this.deliverFrom;
    }

    public boolean hasDeliverFrom() { 
      return this.deliverFrom != null && !this.deliverFrom.isEmpty();
    }

    /**
     * @param value {@link #deliverFrom} (Where the supply is expected to come from.)
     */
    public SupplyRequest setDeliverFrom(Reference value) { 
      this.deliverFrom = value;
      return this;
    }

    /**
     * @return {@link #deliverTo} (Where the supply is destined to go.)
     */
    public Reference getDeliverTo() { 
      if (this.deliverTo == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SupplyRequest.deliverTo");
        else if (Configuration.doAutoCreate())
          this.deliverTo = new Reference(); // cc
      return this.deliverTo;
    }

    public boolean hasDeliverTo() { 
      return this.deliverTo != null && !this.deliverTo.isEmpty();
    }

    /**
     * @param value {@link #deliverTo} (Where the supply is destined to go.)
     */
    public SupplyRequest setDeliverTo(Reference value) { 
      this.deliverTo = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this SupplyRequest by the author and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Status of the supply request.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process.", 0, 1, category));
        children.add(new Property("priority", "code", "Indicates how quickly this SupplyRequest should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("item", "CodeableReference(Medication|Substance|Device|DeviceDefinition)", "The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item));
        children.add(new Property("quantity", "Quantity", "The amount that is being ordered of the indicated item.", 0, 1, quantity));
        children.add(new Property("parameter", "", "Specific parameters for the ordered item.  For example, the size of the indicated item.", 0, java.lang.Integer.MAX_VALUE, parameter));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "When the request should be fulfilled.", 0, 1, occurrence));
        children.add(new Property("authoredOn", "dateTime", "When the request was made.", 0, 1, authoredOn));
        children.add(new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The device, practitioner, etc. who initiated the request.", 0, 1, requester));
        children.add(new Property("supplier", "Reference(Organization|HealthcareService)", "Who is intended to fulfill the request.", 0, java.lang.Integer.MAX_VALUE, supplier));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "The reason why the supply item was requested.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("deliverFrom", "Reference(Organization|Location)", "Where the supply is expected to come from.", 0, 1, deliverFrom));
        children.add(new Property("deliverTo", "Reference(Organization|Location|Patient)", "Where the supply is destined to go.", 0, 1, deliverTo));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this SupplyRequest by the author and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Status of the supply request.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Category of supply, e.g.  central, non-stock, etc. This is used to support work flows associated with the supply process.", 0, 1, category);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly this SupplyRequest should be addressed with respect to other requests.", 0, 1, priority);
        case 3242771: /*item*/  return new Property("item", "CodeableReference(Medication|Substance|Device|DeviceDefinition)", "The item that is requested to be supplied. This is either a link to a resource representing the details of the item or a code that identifies the item from a known list.", 0, 1, item);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The amount that is being ordered of the indicated item.", 0, 1, quantity);
        case 1954460585: /*parameter*/  return new Property("parameter", "", "Specific parameters for the ordered item.  For example, the size of the indicated item.", 0, java.lang.Integer.MAX_VALUE, parameter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "When the request should be fulfilled.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "When the request should be fulfilled.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "When the request should be fulfilled.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "When the request should be fulfilled.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "When the request should be fulfilled.", 0, 1, occurrence);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "When the request was made.", 0, 1, authoredOn);
        case 693933948: /*requester*/  return new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The device, practitioner, etc. who initiated the request.", 0, 1, requester);
        case -1663305268: /*supplier*/  return new Property("supplier", "Reference(Organization|HealthcareService)", "Who is intended to fulfill the request.", 0, java.lang.Integer.MAX_VALUE, supplier);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "The reason why the supply item was requested.", 0, java.lang.Integer.MAX_VALUE, reason);
        case -949323153: /*deliverFrom*/  return new Property("deliverFrom", "Reference(Organization|Location)", "Where the supply is expected to come from.", 0, 1, deliverFrom);
        case -242327936: /*deliverTo*/  return new Property("deliverTo", "Reference(Organization|Location|Patient)", "Where the supply is destined to go.", 0, 1, deliverTo);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SupplyRequestStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // SupplyRequestParameterComponent
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case 693933948: /*requester*/ return this.requester == null ? new Base[0] : new Base[] {this.requester}; // Reference
        case -1663305268: /*supplier*/ return this.supplier == null ? new Base[0] : this.supplier.toArray(new Base[this.supplier.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case -949323153: /*deliverFrom*/ return this.deliverFrom == null ? new Base[0] : new Base[] {this.deliverFrom}; // Reference
        case -242327936: /*deliverTo*/ return this.deliverTo == null ? new Base[0] : new Base[] {this.deliverTo}; // Reference
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
          value = new SupplyRequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SupplyRequestStatus>
          return value;
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 1954460585: // parameter
          this.getParameter().add((SupplyRequestParameterComponent) value); // SupplyRequestParameterComponent
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -1500852503: // authoredOn
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 693933948: // requester
          this.requester = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1663305268: // supplier
          this.getSupplier().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -949323153: // deliverFrom
          this.deliverFrom = TypeConvertor.castToReference(value); // Reference
          return value;
        case -242327936: // deliverTo
          this.deliverTo = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new SupplyRequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SupplyRequestStatus>
        } else if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("parameter")) {
          this.getParameter().add((SupplyRequestParameterComponent) value);
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("requester")) {
          this.requester = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("supplier")) {
          this.getSupplier().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("deliverFrom")) {
          this.deliverFrom = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("deliverTo")) {
          this.deliverTo = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return getCategory();
        case -1165461084:  return getPriorityElement();
        case 3242771:  return getItem();
        case -1285004149:  return getQuantity();
        case 1954460585:  return addParameter(); 
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -1500852503:  return getAuthoredOnElement();
        case 693933948:  return getRequester();
        case -1663305268:  return addSupplier(); 
        case -934964668:  return addReason(); 
        case -949323153:  return getDeliverFrom();
        case -242327936:  return getDeliverTo();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 1954460585: /*parameter*/ return new String[] {};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case 693933948: /*requester*/ return new String[] {"Reference"};
        case -1663305268: /*supplier*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case -949323153: /*deliverFrom*/ return new String[] {"Reference"};
        case -242327936: /*deliverTo*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type SupplyRequest.status");
        }
        else if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type SupplyRequest.priority");
        }
        else if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("parameter")) {
          return addParameter();
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
        else if (name.equals("authoredOn")) {
          throw new FHIRException("Cannot call addChild on a primitive type SupplyRequest.authoredOn");
        }
        else if (name.equals("requester")) {
          this.requester = new Reference();
          return this.requester;
        }
        else if (name.equals("supplier")) {
          return addSupplier();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("deliverFrom")) {
          this.deliverFrom = new Reference();
          return this.deliverFrom;
        }
        else if (name.equals("deliverTo")) {
          this.deliverTo = new Reference();
          return this.deliverTo;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SupplyRequest";

  }

      public SupplyRequest copy() {
        SupplyRequest dst = new SupplyRequest();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SupplyRequest dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.category = category == null ? null : category.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.item = item == null ? null : item.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<SupplyRequestParameterComponent>();
          for (SupplyRequestParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.requester = requester == null ? null : requester.copy();
        if (supplier != null) {
          dst.supplier = new ArrayList<Reference>();
          for (Reference i : supplier)
            dst.supplier.add(i.copy());
        };
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        dst.deliverFrom = deliverFrom == null ? null : deliverFrom.copy();
        dst.deliverTo = deliverTo == null ? null : deliverTo.copy();
      }

      protected SupplyRequest typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SupplyRequest))
          return false;
        SupplyRequest o = (SupplyRequest) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(category, o.category, true)
           && compareDeep(priority, o.priority, true) && compareDeep(item, o.item, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(parameter, o.parameter, true) && compareDeep(occurrence, o.occurrence, true) && compareDeep(authoredOn, o.authoredOn, true)
           && compareDeep(requester, o.requester, true) && compareDeep(supplier, o.supplier, true) && compareDeep(reason, o.reason, true)
           && compareDeep(deliverFrom, o.deliverFrom, true) && compareDeep(deliverTo, o.deliverTo, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SupplyRequest))
          return false;
        SupplyRequest o = (SupplyRequest) other_;
        return compareValues(status, o.status, true) && compareValues(priority, o.priority, true) && compareValues(authoredOn, o.authoredOn, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, category
          , priority, item, quantity, parameter, occurrence, authoredOn, requester, supplier
          , reason, deliverFrom, deliverTo);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SupplyRequest;
   }

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>The kind of supply (central, non-stock, etc.)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyRequest.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="SupplyRequest.category", description="The kind of supply (central, non-stock, etc.)", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>The kind of supply (central, non-stock, etc.)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyRequest.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>requester</b>
   * <p>
   * Description: <b>Individual making the request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.requester</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requester", path="SupplyRequest.requester", description="Individual making the request", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_REQUESTER = "requester";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requester</b>
   * <p>
   * Description: <b>Individual making the request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.requester</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyRequest:requester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTER = new ca.uhn.fhir.model.api.Include("SupplyRequest:requester").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | suspended +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyRequest.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="SupplyRequest.status", description="draft | active | suspended +", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | suspended +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SupplyRequest.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The destination of the supply</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.deliverTo</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="SupplyRequest.deliverTo", description="The destination of the supply", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Location.class, Organization.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The destination of the supply</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.deliverTo</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyRequest:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("SupplyRequest:subject").toLocked();

 /**
   * Search parameter: <b>supplier</b>
   * <p>
   * Description: <b>Who is intended to fulfill the request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.supplier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supplier", path="SupplyRequest.supplier", description="Who is intended to fulfill the request", type="reference", target={HealthcareService.class, Organization.class } )
  public static final String SP_SUPPLIER = "supplier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supplier</b>
   * <p>
   * Description: <b>Who is intended to fulfill the request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>SupplyRequest.supplier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPLIER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPLIER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>SupplyRequest:supplier</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPLIER = new ca.uhn.fhir.model.api.Include("SupplyRequest:supplier").toLocked();

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [Encounter](encounter.html): A date within the period the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [List](list.html): When the list was prepared\r\n* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

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
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
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
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Master Version Specific Identifier\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
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
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
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
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);


}