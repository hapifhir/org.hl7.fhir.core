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
 * Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.
 */
@ResourceDef(name="DeviceRequest", profile="http://hl7.org/fhir/StructureDefinition/DeviceRequest")
public class DeviceRequest extends DomainResource {

    @Block()
    public static class DeviceRequestParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code or string that identifies the device detail being asserted.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device detail", formalDefinition="A code or string that identifies the device detail being asserted." )
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
      public DeviceRequestParameterComponent() {
        super();
      }

        /**
         * @return {@link #code} (A code or string that identifies the device detail being asserted.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceRequestParameterComponent.code");
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
        public DeviceRequestParameterComponent setCode(CodeableConcept value) { 
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
        public DeviceRequestParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof Range || value instanceof BooleanType))
            throw new Error("Not the right type for DeviceRequest.parameter.value[x]: "+value.fhirType());
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

      public DeviceRequestParameterComponent copy() {
        DeviceRequestParameterComponent dst = new DeviceRequestParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceRequestParameterComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceRequestParameterComponent))
          return false;
        DeviceRequestParameterComponent o = (DeviceRequestParameterComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceRequestParameterComponent))
          return false;
        DeviceRequestParameterComponent o = (DeviceRequestParameterComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value);
      }

  public String fhirType() {
    return "DeviceRequest.parameter";

  }

  }

    /**
     * Identifiers assigned to this order by the orderer or by the receiver.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Request identifier", formalDefinition="Identifiers assigned to this order by the orderer or by the receiver." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest." )
    protected List<UriType> instantiatesUri;

    /**
     * Plan/proposal/order fulfilled by this request.
     */
    @Child(name = "basedOn", type = {Reference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What request fulfills", formalDefinition="Plan/proposal/order fulfilled by this request." )
    protected List<Reference> basedOn;

    /**
     * The request takes the place of the referenced completed or terminated request(s).
     */
    @Child(name = "priorRequest", type = {Reference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What request replaces", formalDefinition="The request takes the place of the referenced completed or terminated request(s)." )
    protected List<Reference> priorRequest;

    /**
     * Composite request this is part of.
     */
    @Child(name = "groupIdentifier", type = {Identifier.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identifier of composite request", formalDefinition="Composite request this is part of." )
    protected Identifier groupIdentifier;

    /**
     * The status of the request.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="The status of the request." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-status")
    protected Enumeration<RequestStatus> status;

    /**
     * Whether the request is a proposal, plan, an original order or a reflex order.
     */
    @Child(name = "intent", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order | option", formalDefinition="Whether the request is a proposal, plan, an original order or a reflex order." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-intent")
    protected Enumeration<RequestIntent> intent;

    /**
     * Indicates how quickly the device request should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the device request should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * The details of the device to be used.
     */
    @Child(name = "code", type = {CodeableReference.class}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Device requested", formalDefinition="The details of the device to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-kind")
    protected CodeableReference code;

    /**
     * Specific parameters for the ordered item.  For example, the prism value for lenses.
     */
    @Child(name = "parameter", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Device details", formalDefinition="Specific parameters for the ordered item.  For example, the prism value for lenses." )
    protected List<DeviceRequestParameterComponent> parameter;

    /**
     * The patient who will use the device.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Location.class, Device.class}, order=11, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Focus of request", formalDefinition="The patient who will use the device." )
    protected Reference subject;

    /**
     * An encounter that provides additional context in which this request is made.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter motivating request", formalDefinition="An encounter that provides additional context in which this request is made." )
    protected Reference encounter;

    /**
     * The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Desired time or schedule for use", formalDefinition="The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\"." )
    protected DataType occurrence;

    /**
     * When the request transitioned to being actionable.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When recorded", formalDefinition="When the request transitioned to being actionable." )
    protected DateTimeType authoredOn;

    /**
     * The individual who initiated the request and has responsibility for its activation.
     */
    @Child(name = "requester", type = {Device.class, Practitioner.class, PractitionerRole.class, Organization.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what is requesting diagnostics", formalDefinition="The individual who initiated the request and has responsibility for its activation." )
    protected Reference requester;

    /**
     * Desired type of performer for doing the diagnostic testing.
     */
    @Child(name = "performerType", type = {CodeableConcept.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Filler role", formalDefinition="Desired type of performer for doing the diagnostic testing." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-role")
    protected CodeableConcept performerType;

    /**
     * The desired performer for doing the diagnostic testing.
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, HealthcareService.class, Patient.class, Device.class, RelatedPerson.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Requested Filler", formalDefinition="The desired performer for doing the diagnostic testing." )
    protected Reference performer;

    /**
     * Reason or justification for the use of this device.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Coded/Linked Reason for request", formalDefinition="Reason or justification for the use of this device." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableReference> reason;

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be required for delivering the requested service.
     */
    @Child(name = "insurance", type = {Coverage.class, ClaimResponse.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated insurance coverage", formalDefinition="Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be required for delivering the requested service." )
    protected List<Reference> insurance;

    /**
     * Additional clinical information about the patient that may influence the request fulfilment.  For example, this may include where on the subject's body the device will be used (i.e. the target site).
     */
    @Child(name = "supportingInfo", type = {Reference.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional clinical information", formalDefinition="Additional clinical information about the patient that may influence the request fulfilment.  For example, this may include where on the subject's body the device will be used (i.e. the target site)." )
    protected List<Reference> supportingInfo;

    /**
     * Details about this request that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.
     */
    @Child(name = "note", type = {Annotation.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Notes or comments", formalDefinition="Details about this request that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement." )
    protected List<Annotation> note;

    /**
     * Key events in the history of the request.
     */
    @Child(name = "relevantHistory", type = {Provenance.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Request provenance", formalDefinition="Key events in the history of the request." )
    protected List<Reference> relevantHistory;

    private static final long serialVersionUID = 1727309364L;

  /**
   * Constructor
   */
    public DeviceRequest() {
      super();
    }

  /**
   * Constructor
   */
    public DeviceRequest(RequestIntent intent, CodeableReference code, Reference subject) {
      super();
      this.setIntent(intent);
      this.setCode(code);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers assigned to this order by the orderer or by the receiver.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setIdentifier(List<Identifier> theIdentifier) { 
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

    public DeviceRequest addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
      this.instantiatesCanonical = theInstantiatesCanonical;
      return this;
    }

    public boolean hasInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType item : this.instantiatesCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public DeviceRequest addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public boolean hasInstantiatesCanonical(String value) { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType v : this.instantiatesCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setInstantiatesUri(List<UriType> theInstantiatesUri) { 
      this.instantiatesUri = theInstantiatesUri;
      return this;
    }

    public boolean hasInstantiatesUri() { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType item : this.instantiatesUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public DeviceRequest addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.)
     */
    public boolean hasInstantiatesUri(String value) { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType v : this.instantiatesUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #basedOn} (Plan/proposal/order fulfilled by this request.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setBasedOn(List<Reference> theBasedOn) { 
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

    public DeviceRequest addBasedOn(Reference t) { //3
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
     * @return {@link #priorRequest} (The request takes the place of the referenced completed or terminated request(s).)
     */
    public List<Reference> getPriorRequest() { 
      if (this.priorRequest == null)
        this.priorRequest = new ArrayList<Reference>();
      return this.priorRequest;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setPriorRequest(List<Reference> thePriorRequest) { 
      this.priorRequest = thePriorRequest;
      return this;
    }

    public boolean hasPriorRequest() { 
      if (this.priorRequest == null)
        return false;
      for (Reference item : this.priorRequest)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPriorRequest() { //3
      Reference t = new Reference();
      if (this.priorRequest == null)
        this.priorRequest = new ArrayList<Reference>();
      this.priorRequest.add(t);
      return t;
    }

    public DeviceRequest addPriorRequest(Reference t) { //3
      if (t == null)
        return this;
      if (this.priorRequest == null)
        this.priorRequest = new ArrayList<Reference>();
      this.priorRequest.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #priorRequest}, creating it if it does not already exist {3}
     */
    public Reference getPriorRequestFirstRep() { 
      if (getPriorRequest().isEmpty()) {
        addPriorRequest();
      }
      return getPriorRequest().get(0);
    }

    /**
     * @return {@link #groupIdentifier} (Composite request this is part of.)
     */
    public Identifier getGroupIdentifier() { 
      if (this.groupIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.groupIdentifier");
        else if (Configuration.doAutoCreate())
          this.groupIdentifier = new Identifier(); // cc
      return this.groupIdentifier;
    }

    public boolean hasGroupIdentifier() { 
      return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
    }

    /**
     * @param value {@link #groupIdentifier} (Composite request this is part of.)
     */
    public DeviceRequest setGroupIdentifier(Identifier value) { 
      this.groupIdentifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the request.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the request.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DeviceRequest setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the request.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the request.
     */
    public DeviceRequest setStatus(RequestStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #intent} (Whether the request is a proposal, plan, an original order or a reflex order.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory()); // bb
      return this.intent;
    }

    public boolean hasIntentElement() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (Whether the request is a proposal, plan, an original order or a reflex order.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public DeviceRequest setIntentElement(Enumeration<RequestIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Whether the request is a proposal, plan, an original order or a reflex order.
     */
    public RequestIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Whether the request is a proposal, plan, an original order or a reflex order.
     */
    public DeviceRequest setIntent(RequestIntent value) { 
        if (this.intent == null)
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory());
        this.intent.setValue(value);
      return this;
    }

    /**
     * @return {@link #priority} (Indicates how quickly the device request should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.priority");
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
     * @param value {@link #priority} (Indicates how quickly the device request should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public DeviceRequest setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly the device request should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly the device request should be addressed with respect to other requests.
     */
    public DeviceRequest setPriority(RequestPriority value) { 
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
     * @return {@link #code} (The details of the device to be used.)
     */
    public CodeableReference getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableReference(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The details of the device to be used.)
     */
    public DeviceRequest setCode(CodeableReference value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #parameter} (Specific parameters for the ordered item.  For example, the prism value for lenses.)
     */
    public List<DeviceRequestParameterComponent> getParameter() { 
      if (this.parameter == null)
        this.parameter = new ArrayList<DeviceRequestParameterComponent>();
      return this.parameter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setParameter(List<DeviceRequestParameterComponent> theParameter) { 
      this.parameter = theParameter;
      return this;
    }

    public boolean hasParameter() { 
      if (this.parameter == null)
        return false;
      for (DeviceRequestParameterComponent item : this.parameter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceRequestParameterComponent addParameter() { //3
      DeviceRequestParameterComponent t = new DeviceRequestParameterComponent();
      if (this.parameter == null)
        this.parameter = new ArrayList<DeviceRequestParameterComponent>();
      this.parameter.add(t);
      return t;
    }

    public DeviceRequest addParameter(DeviceRequestParameterComponent t) { //3
      if (t == null)
        return this;
      if (this.parameter == null)
        this.parameter = new ArrayList<DeviceRequestParameterComponent>();
      this.parameter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
     */
    public DeviceRequestParameterComponent getParameterFirstRep() { 
      if (getParameter().isEmpty()) {
        addParameter();
      }
      return getParameter().get(0);
    }

    /**
     * @return {@link #subject} (The patient who will use the device.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient who will use the device.)
     */
    public DeviceRequest setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (An encounter that provides additional context in which this request is made.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (An encounter that provides additional context in which this request is made.)
     */
    public DeviceRequest setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".)
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
     * @return {@link #occurrence} (The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".)
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
     * @return {@link #occurrence} (The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".)
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
     * @param value {@link #occurrence} (The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".)
     */
    public DeviceRequest setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new Error("Not the right type for DeviceRequest.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (When the request transitioned to being actionable.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.authoredOn");
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
     * @param value {@link #authoredOn} (When the request transitioned to being actionable.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DeviceRequest setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return When the request transitioned to being actionable.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value When the request transitioned to being actionable.
     */
    public DeviceRequest setAuthoredOn(Date value) { 
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
     * @return {@link #requester} (The individual who initiated the request and has responsibility for its activation.)
     */
    public Reference getRequester() { 
      if (this.requester == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.requester");
        else if (Configuration.doAutoCreate())
          this.requester = new Reference(); // cc
      return this.requester;
    }

    public boolean hasRequester() { 
      return this.requester != null && !this.requester.isEmpty();
    }

    /**
     * @param value {@link #requester} (The individual who initiated the request and has responsibility for its activation.)
     */
    public DeviceRequest setRequester(Reference value) { 
      this.requester = value;
      return this;
    }

    /**
     * @return {@link #performerType} (Desired type of performer for doing the diagnostic testing.)
     */
    public CodeableConcept getPerformerType() { 
      if (this.performerType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.performerType");
        else if (Configuration.doAutoCreate())
          this.performerType = new CodeableConcept(); // cc
      return this.performerType;
    }

    public boolean hasPerformerType() { 
      return this.performerType != null && !this.performerType.isEmpty();
    }

    /**
     * @param value {@link #performerType} (Desired type of performer for doing the diagnostic testing.)
     */
    public DeviceRequest setPerformerType(CodeableConcept value) { 
      this.performerType = value;
      return this;
    }

    /**
     * @return {@link #performer} (The desired performer for doing the diagnostic testing.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceRequest.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (The desired performer for doing the diagnostic testing.)
     */
    public DeviceRequest setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #reason} (Reason or justification for the use of this device.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setReason(List<CodeableReference> theReason) { 
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

    public DeviceRequest addReason(CodeableReference t) { //3
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
     * @return {@link #insurance} (Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be required for delivering the requested service.)
     */
    public List<Reference> getInsurance() { 
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      return this.insurance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setInsurance(List<Reference> theInsurance) { 
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

    public DeviceRequest addInsurance(Reference t) { //3
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
     * @return {@link #supportingInfo} (Additional clinical information about the patient that may influence the request fulfilment.  For example, this may include where on the subject's body the device will be used (i.e. the target site).)
     */
    public List<Reference> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setSupportingInfo(List<Reference> theSupportingInfo) { 
      this.supportingInfo = theSupportingInfo;
      return this;
    }

    public boolean hasSupportingInfo() { 
      if (this.supportingInfo == null)
        return false;
      for (Reference item : this.supportingInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInfo() { //3
      Reference t = new Reference();
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return t;
    }

    public DeviceRequest addSupportingInfo(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInfoFirstRep() { 
      if (getSupportingInfo().isEmpty()) {
        addSupportingInfo();
      }
      return getSupportingInfo().get(0);
    }

    /**
     * @return {@link #note} (Details about this request that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setNote(List<Annotation> theNote) { 
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

    public DeviceRequest addNote(Annotation t) { //3
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
     * @return {@link #relevantHistory} (Key events in the history of the request.)
     */
    public List<Reference> getRelevantHistory() { 
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      return this.relevantHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceRequest setRelevantHistory(List<Reference> theRelevantHistory) { 
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

    public DeviceRequest addRelevantHistory(Reference t) { //3
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this order by the orderer or by the receiver.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(ActivityDefinition|PlanDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(Any)", "Plan/proposal/order fulfilled by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("priorRequest", "Reference(Any)", "The request takes the place of the referenced completed or terminated request(s).", 0, java.lang.Integer.MAX_VALUE, priorRequest));
        children.add(new Property("groupIdentifier", "Identifier", "Composite request this is part of.", 0, 1, groupIdentifier));
        children.add(new Property("status", "code", "The status of the request.", 0, 1, status));
        children.add(new Property("intent", "code", "Whether the request is a proposal, plan, an original order or a reflex order.", 0, 1, intent));
        children.add(new Property("priority", "code", "Indicates how quickly the device request should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("code", "CodeableReference(Device|DeviceDefinition)", "The details of the device to be used.", 0, 1, code));
        children.add(new Property("parameter", "", "Specific parameters for the ordered item.  For example, the prism value for lenses.", 0, java.lang.Integer.MAX_VALUE, parameter));
        children.add(new Property("subject", "Reference(Patient|Group|Location|Device)", "The patient who will use the device.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "An encounter that provides additional context in which this request is made.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence));
        children.add(new Property("authoredOn", "dateTime", "When the request transitioned to being actionable.", 0, 1, authoredOn));
        children.add(new Property("requester", "Reference(Device|Practitioner|PractitionerRole|Organization)", "The individual who initiated the request and has responsibility for its activation.", 0, 1, requester));
        children.add(new Property("performerType", "CodeableConcept", "Desired type of performer for doing the diagnostic testing.", 0, 1, performerType));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "The desired performer for doing the diagnostic testing.", 0, 1, performer));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Reason or justification for the use of this device.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be required for delivering the requested service.", 0, java.lang.Integer.MAX_VALUE, insurance));
        children.add(new Property("supportingInfo", "Reference(Any)", "Additional clinical information about the patient that may influence the request fulfilment.  For example, this may include where on the subject's body the device will be used (i.e. the target site).", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
        children.add(new Property("note", "Annotation", "Details about this request that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("relevantHistory", "Reference(Provenance)", "Key events in the history of the request.", 0, java.lang.Integer.MAX_VALUE, relevantHistory));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this order by the orderer or by the receiver.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(ActivityDefinition|PlanDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this DeviceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Any)", "Plan/proposal/order fulfilled by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case 237568101: /*priorRequest*/  return new Property("priorRequest", "Reference(Any)", "The request takes the place of the referenced completed or terminated request(s).", 0, java.lang.Integer.MAX_VALUE, priorRequest);
        case -445338488: /*groupIdentifier*/  return new Property("groupIdentifier", "Identifier", "Composite request this is part of.", 0, 1, groupIdentifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the request.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Whether the request is a proposal, plan, an original order or a reflex order.", 0, 1, intent);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the device request should be addressed with respect to other requests.", 0, 1, priority);
        case 3059181: /*code*/  return new Property("code", "CodeableReference(Device|DeviceDefinition)", "The details of the device to be used.", 0, 1, code);
        case 1954460585: /*parameter*/  return new Property("parameter", "", "Specific parameters for the ordered item.  For example, the prism value for lenses.", 0, java.lang.Integer.MAX_VALUE, parameter);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Location|Device)", "The patient who will use the device.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "An encounter that provides additional context in which this request is made.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "The timing schedule for the use of the device. The Schedule data type allows many different expressions, for example. \"Every 8 hours\"; \"Three times a day\"; \"1/2 an hour before breakfast for 10 days from 23-Dec 2011:\"; \"15 Oct 2013, 17 Oct 2013 and 1 Nov 2013\".", 0, 1, occurrence);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "When the request transitioned to being actionable.", 0, 1, authoredOn);
        case 693933948: /*requester*/  return new Property("requester", "Reference(Device|Practitioner|PractitionerRole|Organization)", "The individual who initiated the request and has responsibility for its activation.", 0, 1, requester);
        case -901444568: /*performerType*/  return new Property("performerType", "CodeableConcept", "Desired type of performer for doing the diagnostic testing.", 0, 1, performerType);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "The desired performer for doing the diagnostic testing.", 0, 1, performer);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Reason or justification for the use of this device.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 73049818: /*insurance*/  return new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be required for delivering the requested service.", 0, java.lang.Integer.MAX_VALUE, insurance);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "Reference(Any)", "Additional clinical information about the patient that may influence the request fulfilment.  For example, this may include where on the subject's body the device will be used (i.e. the target site).", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Details about this request that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1538891575: /*relevantHistory*/  return new Property("relevantHistory", "Reference(Provenance)", "Key events in the history of the request.", 0, java.lang.Integer.MAX_VALUE, relevantHistory);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case 237568101: /*priorRequest*/ return this.priorRequest == null ? new Base[0] : this.priorRequest.toArray(new Base[this.priorRequest.size()]); // Reference
        case -445338488: /*groupIdentifier*/ return this.groupIdentifier == null ? new Base[0] : new Base[] {this.groupIdentifier}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<RequestStatus>
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<RequestIntent>
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableReference
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // DeviceRequestParameterComponent
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case 693933948: /*requester*/ return this.requester == null ? new Base[0] : new Base[] {this.requester}; // Reference
        case -901444568: /*performerType*/ return this.performerType == null ? new Base[0] : new Base[] {this.performerType}; // CodeableConcept
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 73049818: /*insurance*/ return this.insurance == null ? new Base[0] : this.insurance.toArray(new Base[this.insurance.size()]); // Reference
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1538891575: /*relevantHistory*/ return this.relevantHistory == null ? new Base[0] : this.relevantHistory.toArray(new Base[this.relevantHistory.size()]); // Reference
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
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 237568101: // priorRequest
          this.getPriorRequest().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -445338488: // groupIdentifier
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
          return value;
        case -1183762788: // intent
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 1954460585: // parameter
          this.getParameter().add((DeviceRequestParameterComponent) value); // DeviceRequestParameterComponent
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
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
        case -901444568: // performerType
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 73049818: // insurance
          this.getInsurance().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1538891575: // relevantHistory
          this.getRelevantHistory().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("priorRequest")) {
          this.getPriorRequest().add(TypeConvertor.castToReference(value));
        } else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
        } else if (name.equals("intent")) {
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("parameter")) {
          this.getParameter().add((DeviceRequestParameterComponent) value);
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("requester")) {
          this.requester = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performerType")) {
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("insurance")) {
          this.getInsurance().add(TypeConvertor.castToReference(value));
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("relevantHistory")) {
          this.getRelevantHistory().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case -332612366:  return addBasedOn(); 
        case 237568101:  return addPriorRequest(); 
        case -445338488:  return getGroupIdentifier();
        case -892481550:  return getStatusElement();
        case -1183762788:  return getIntentElement();
        case -1165461084:  return getPriorityElement();
        case 3059181:  return getCode();
        case 1954460585:  return addParameter(); 
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -1500852503:  return getAuthoredOnElement();
        case 693933948:  return getRequester();
        case -901444568:  return getPerformerType();
        case 481140686:  return getPerformer();
        case -934964668:  return addReason(); 
        case 73049818:  return addInsurance(); 
        case 1922406657:  return addSupportingInfo(); 
        case 3387378:  return addNote(); 
        case 1538891575:  return addRelevantHistory(); 
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
        case 237568101: /*priorRequest*/ return new String[] {"Reference"};
        case -445338488: /*groupIdentifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableReference"};
        case 1954460585: /*parameter*/ return new String[] {};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case 693933948: /*requester*/ return new String[] {"Reference"};
        case -901444568: /*performerType*/ return new String[] {"CodeableConcept"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 73049818: /*insurance*/ return new String[] {"Reference"};
        case 1922406657: /*supportingInfo*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1538891575: /*relevantHistory*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("priorRequest")) {
          return addPriorRequest();
        }
        else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = new Identifier();
          return this.groupIdentifier;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.status");
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.intent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.priority");
        }
        else if (name.equals("code")) {
          this.code = new CodeableReference();
          return this.code;
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
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
          throw new FHIRException("Cannot call addChild on a primitive type DeviceRequest.authoredOn");
        }
        else if (name.equals("requester")) {
          this.requester = new Reference();
          return this.requester;
        }
        else if (name.equals("performerType")) {
          this.performerType = new CodeableConcept();
          return this.performerType;
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("insurance")) {
          return addInsurance();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("relevantHistory")) {
          return addRelevantHistory();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DeviceRequest";

  }

      public DeviceRequest copy() {
        DeviceRequest dst = new DeviceRequest();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceRequest dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (priorRequest != null) {
          dst.priorRequest = new ArrayList<Reference>();
          for (Reference i : priorRequest)
            dst.priorRequest.add(i.copy());
        };
        dst.groupIdentifier = groupIdentifier == null ? null : groupIdentifier.copy();
        dst.status = status == null ? null : status.copy();
        dst.intent = intent == null ? null : intent.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.code = code == null ? null : code.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<DeviceRequestParameterComponent>();
          for (DeviceRequestParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.requester = requester == null ? null : requester.copy();
        dst.performerType = performerType == null ? null : performerType.copy();
        dst.performer = performer == null ? null : performer.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (insurance != null) {
          dst.insurance = new ArrayList<Reference>();
          for (Reference i : insurance)
            dst.insurance.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<Reference>();
          for (Reference i : supportingInfo)
            dst.supportingInfo.add(i.copy());
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
      }

      protected DeviceRequest typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceRequest))
          return false;
        DeviceRequest o = (DeviceRequest) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(priorRequest, o.priorRequest, true) && compareDeep(groupIdentifier, o.groupIdentifier, true)
           && compareDeep(status, o.status, true) && compareDeep(intent, o.intent, true) && compareDeep(priority, o.priority, true)
           && compareDeep(code, o.code, true) && compareDeep(parameter, o.parameter, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(occurrence, o.occurrence, true) && compareDeep(authoredOn, o.authoredOn, true)
           && compareDeep(requester, o.requester, true) && compareDeep(performerType, o.performerType, true)
           && compareDeep(performer, o.performer, true) && compareDeep(reason, o.reason, true) && compareDeep(insurance, o.insurance, true)
           && compareDeep(supportingInfo, o.supportingInfo, true) && compareDeep(note, o.note, true) && compareDeep(relevantHistory, o.relevantHistory, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceRequest))
          return false;
        DeviceRequest o = (DeviceRequest) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(priority, o.priority, true)
           && compareValues(authoredOn, o.authoredOn, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, priorRequest, groupIdentifier, status, intent, priority
          , code, parameter, subject, encounter, occurrence, authoredOn, requester, performerType
          , performer, reason, insurance, supportingInfo, note, relevantHistory);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DeviceRequest;
   }

 /**
   * Search parameter: <b>authored-on</b>
   * <p>
   * Description: <b>When the request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DeviceRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored-on", path="DeviceRequest.authoredOn", description="When the request transitioned to being actionable", type="date" )
  public static final String SP_AUTHORED_ON = "authored-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored-on</b>
   * <p>
   * Description: <b>When the request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DeviceRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED_ON = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED_ON);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Plan/proposal/order fulfilled by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="DeviceRequest.basedOn", description="Plan/proposal/order fulfilled by this request", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Plan/proposal/order fulfilled by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("DeviceRequest:based-on").toLocked();

 /**
   * Search parameter: <b>device</b>
   * <p>
   * Description: <b>Reference to resource that is being requested/ordered</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.code.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device", path="DeviceRequest.code.reference", description="Reference to resource that is being requested/ordered", type="reference" )
  public static final String SP_DEVICE = "device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device</b>
   * <p>
   * Description: <b>Reference to resource that is being requested/ordered</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.code.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:device</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEVICE = new ca.uhn.fhir.model.api.Include("DeviceRequest:device").toLocked();

 /**
   * Search parameter: <b>event-date</b>
   * <p>
   * Description: <b>When service should occur</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(DeviceRequest.occurrence as dateTime) | (DeviceRequest.occurrence as Period)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="event-date", path="(DeviceRequest.occurrence as dateTime) | (DeviceRequest.occurrence as Period)", description="When service should occur", type="date" )
  public static final String SP_EVENT_DATE = "event-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>event-date</b>
   * <p>
   * Description: <b>When service should occur</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(DeviceRequest.occurrence as dateTime) | (DeviceRequest.occurrence as Period)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EVENT_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EVENT_DATE);

 /**
   * Search parameter: <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.groupIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group-identifier", path="DeviceRequest.groupIdentifier", description="Composite request this is part of", type="token" )
  public static final String SP_GROUP_IDENTIFIER = "group-identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.groupIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GROUP_IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_GROUP_IDENTIFIER);

 /**
   * Search parameter: <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.instantiatesCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-canonical", path="DeviceRequest.instantiatesCanonical", description="Instantiates FHIR protocol or definition", type="reference", target={ActivityDefinition.class, PlanDefinition.class } )
  public static final String SP_INSTANTIATES_CANONICAL = "instantiates-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.instantiatesCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSTANTIATES_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSTANTIATES_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:instantiates-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSTANTIATES_CANONICAL = new ca.uhn.fhir.model.api.Include("DeviceRequest:instantiates-canonical").toLocked();

 /**
   * Search parameter: <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DeviceRequest.instantiatesUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-uri", path="DeviceRequest.instantiatesUri", description="Instantiates external protocol or definition", type="uri" )
  public static final String SP_INSTANTIATES_URI = "instantiates-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DeviceRequest.instantiatesUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam INSTANTIATES_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_INSTANTIATES_URI);

 /**
   * Search parameter: <b>insurance</b>
   * <p>
   * Description: <b>Associated insurance coverage</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.insurance</b><br>
   * </p>
   */
  @SearchParamDefinition(name="insurance", path="DeviceRequest.insurance", description="Associated insurance coverage", type="reference", target={ClaimResponse.class, Coverage.class } )
  public static final String SP_INSURANCE = "insurance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>insurance</b>
   * <p>
   * Description: <b>Associated insurance coverage</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.insurance</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSURANCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSURANCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:insurance</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSURANCE = new ca.uhn.fhir.model.api.Include("DeviceRequest:insurance").toLocked();

 /**
   * Search parameter: <b>intent</b>
   * <p>
   * Description: <b>proposal | plan | original-order |reflex-order</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.intent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="intent", path="DeviceRequest.intent", description="proposal | plan | original-order |reflex-order", type="token" )
  public static final String SP_INTENT = "intent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>intent</b>
   * <p>
   * Description: <b>proposal | plan | original-order |reflex-order</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.intent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTENT);

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>Desired performer for service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.performer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="DeviceRequest.performer", description="Desired performer for service", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={CareTeam.class, Device.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>Desired performer for service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.performer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("DeviceRequest:performer").toLocked();

 /**
   * Search parameter: <b>prior-request</b>
   * <p>
   * Description: <b>Request takes the place of referenced completed or terminated requests</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.priorRequest</b><br>
   * </p>
   */
  @SearchParamDefinition(name="prior-request", path="DeviceRequest.priorRequest", description="Request takes the place of referenced completed or terminated requests", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_PRIOR_REQUEST = "prior-request";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>prior-request</b>
   * <p>
   * Description: <b>Request takes the place of referenced completed or terminated requests</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.priorRequest</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRIOR_REQUEST = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRIOR_REQUEST);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:prior-request</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRIOR_REQUEST = new ca.uhn.fhir.model.api.Include("DeviceRequest:prior-request").toLocked();

 /**
   * Search parameter: <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.requester</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requester", path="DeviceRequest.requester", description="Who/what is requesting service", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_REQUESTER = "requester";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.requester</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:requester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTER = new ca.uhn.fhir.model.api.Include("DeviceRequest:requester").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>entered-in-error | draft | active |suspended | completed</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="DeviceRequest.status", description="entered-in-error | draft | active |suspended | completed", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>entered-in-error | draft | active |suspended | completed</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceRequest.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Individual the service is ordered for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="DeviceRequest.subject", description="Individual the service is ordered for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Device.class, Group.class, Location.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Individual the service is ordered for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceRequest.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("DeviceRequest:subject").toLocked();

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [Condition](condition.html): Code for the condition\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationUsage](medicationusage.html): Return statements of this medication code\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [ServiceRequest](servicerequest.html): What is being requested/ordered\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [Composition](composition.html): Context of the Composition\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [DocumentReference](documentreference.html): Context of the document  content\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [List](list.html): Context in which list created\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("DeviceRequest:encounter").toLocked();

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

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
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
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient or group assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient or group present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Group.class, Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
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
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceRequest:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DeviceRequest:patient").toLocked();


}