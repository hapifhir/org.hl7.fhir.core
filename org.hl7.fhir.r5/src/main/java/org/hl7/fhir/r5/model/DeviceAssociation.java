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
 * A record of association of a device.
 */
@ResourceDef(name="DeviceAssociation", profile="http://hl7.org/fhir/StructureDefinition/DeviceAssociation")
public class DeviceAssociation extends DomainResource {

    @Block()
    public static class DeviceAssociationOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Device operational condition corresponding to the association.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Device operational condition", formalDefinition="Device operational condition corresponding to the association." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceassociation-operationstatus")
        protected CodeableConcept status;

        /**
         * The individual performing the action enabled by the device.
         */
        @Child(name = "operator", type = {Patient.class, Practitioner.class, RelatedPerson.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The individual performing the action enabled by the device", formalDefinition="The individual performing the action enabled by the device." )
        protected List<Reference> operator;

        /**
         * Begin and end dates and times for the device's operation.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Begin and end dates and times for the device's operation", formalDefinition="Begin and end dates and times for the device's operation." )
        protected Period period;

        private static final long serialVersionUID = -1587836408L;

    /**
     * Constructor
     */
      public DeviceAssociationOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceAssociationOperationComponent(CodeableConcept status) {
        super();
        this.setStatus(status);
      }

        /**
         * @return {@link #status} (Device operational condition corresponding to the association.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceAssociationOperationComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (Device operational condition corresponding to the association.)
         */
        public DeviceAssociationOperationComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        /**
         * @return {@link #operator} (The individual performing the action enabled by the device.)
         */
        public List<Reference> getOperator() { 
          if (this.operator == null)
            this.operator = new ArrayList<Reference>();
          return this.operator;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceAssociationOperationComponent setOperator(List<Reference> theOperator) { 
          this.operator = theOperator;
          return this;
        }

        public boolean hasOperator() { 
          if (this.operator == null)
            return false;
          for (Reference item : this.operator)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addOperator() { //3
          Reference t = new Reference();
          if (this.operator == null)
            this.operator = new ArrayList<Reference>();
          this.operator.add(t);
          return t;
        }

        public DeviceAssociationOperationComponent addOperator(Reference t) { //3
          if (t == null)
            return this;
          if (this.operator == null)
            this.operator = new ArrayList<Reference>();
          this.operator.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #operator}, creating it if it does not already exist {3}
         */
        public Reference getOperatorFirstRep() { 
          if (getOperator().isEmpty()) {
            addOperator();
          }
          return getOperator().get(0);
        }

        /**
         * @return {@link #period} (Begin and end dates and times for the device's operation.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceAssociationOperationComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Begin and end dates and times for the device's operation.)
         */
        public DeviceAssociationOperationComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("status", "CodeableConcept", "Device operational condition corresponding to the association.", 0, 1, status));
          children.add(new Property("operator", "Reference(Patient|Practitioner|RelatedPerson)", "The individual performing the action enabled by the device.", 0, java.lang.Integer.MAX_VALUE, operator));
          children.add(new Property("period", "Period", "Begin and end dates and times for the device's operation.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "Device operational condition corresponding to the association.", 0, 1, status);
          case -500553564: /*operator*/  return new Property("operator", "Reference(Patient|Practitioner|RelatedPerson)", "The individual performing the action enabled by the device.", 0, java.lang.Integer.MAX_VALUE, operator);
          case -991726143: /*period*/  return new Property("period", "Period", "Begin and end dates and times for the device's operation.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case -500553564: /*operator*/ return this.operator == null ? new Base[0] : this.operator.toArray(new Base[this.operator.size()]); // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -500553564: // operator
          this.getOperator().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("operator")) {
          this.getOperator().add(TypeConvertor.castToReference(value));
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550:  return getStatus();
        case -500553564:  return addOperator(); 
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case -500553564: /*operator*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("operator")) {
          return addOperator();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public DeviceAssociationOperationComponent copy() {
        DeviceAssociationOperationComponent dst = new DeviceAssociationOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceAssociationOperationComponent dst) {
        super.copyValues(dst);
        dst.status = status == null ? null : status.copy();
        if (operator != null) {
          dst.operator = new ArrayList<Reference>();
          for (Reference i : operator)
            dst.operator.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceAssociationOperationComponent))
          return false;
        DeviceAssociationOperationComponent o = (DeviceAssociationOperationComponent) other_;
        return compareDeep(status, o.status, true) && compareDeep(operator, o.operator, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceAssociationOperationComponent))
          return false;
        DeviceAssociationOperationComponent o = (DeviceAssociationOperationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(status, operator, period
          );
      }

  public String fhirType() {
    return "DeviceAssociation.operation";

  }

  }

    /**
     * Instance identifier.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instance identifier", formalDefinition="Instance identifier." )
    protected List<Identifier> identifier;

    /**
     * Reference to the devices associated with the patient or group.
     */
    @Child(name = "device", type = {Device.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the devices associated with the patient or group", formalDefinition="Reference to the devices associated with the patient or group." )
    protected Reference device;

    /**
     * Describes the relationship between the device and subject.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Describes the relationship between the device and subject", formalDefinition="Describes the relationship between the device and subject." )
    protected List<CodeableConcept> category;

    /**
     * Indicates the state of the Device association.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="implanted | explanted | attached | entered-in-error | unknown", formalDefinition="Indicates the state of the Device association." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceassociation-status")
    protected CodeableConcept status;

    /**
     * The reasons given for the current association status.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The reasons given for the current association status", formalDefinition="The reasons given for the current association status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceassociation-status-reason")
    protected List<CodeableConcept> statusReason;

    /**
     * The individual, group of individuals or device that the device is on or associated with.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Practitioner.class, RelatedPerson.class, Device.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The individual, group of individuals or device that the device is on or associated with", formalDefinition="The individual, group of individuals or device that the device is on or associated with." )
    protected Reference subject;

    /**
     * Current anatomical location of the device in/on subject.
     */
    @Child(name = "bodyStructure", type = {BodyStructure.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Current anatomical location of the device in/on subject", formalDefinition="Current anatomical location of the device in/on subject." )
    protected Reference bodyStructure;

    /**
     * Begin and end dates and times for the device association.
     */
    @Child(name = "period", type = {Period.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Begin and end dates and times for the device association", formalDefinition="Begin and end dates and times for the device association." )
    protected Period period;

    /**
     * The details about the device when it is in use to describe its operation.
     */
    @Child(name = "operation", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The details about the device when it is in use to describe its operation", formalDefinition="The details about the device when it is in use to describe its operation." )
    protected List<DeviceAssociationOperationComponent> operation;

    private static final long serialVersionUID = 1892071017L;

  /**
   * Constructor
   */
    public DeviceAssociation() {
      super();
    }

  /**
   * Constructor
   */
    public DeviceAssociation(Reference device, CodeableConcept status) {
      super();
      this.setDevice(device);
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Instance identifier.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceAssociation setIdentifier(List<Identifier> theIdentifier) { 
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

    public DeviceAssociation addIdentifier(Identifier t) { //3
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
     * @return {@link #device} (Reference to the devices associated with the patient or group.)
     */
    public Reference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceAssociation.device");
        else if (Configuration.doAutoCreate())
          this.device = new Reference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (Reference to the devices associated with the patient or group.)
     */
    public DeviceAssociation setDevice(Reference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #category} (Describes the relationship between the device and subject.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceAssociation setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public DeviceAssociation addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #status} (Indicates the state of the Device association.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceAssociation.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates the state of the Device association.)
     */
    public DeviceAssociation setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #statusReason} (The reasons given for the current association status.)
     */
    public List<CodeableConcept> getStatusReason() { 
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      return this.statusReason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceAssociation setStatusReason(List<CodeableConcept> theStatusReason) { 
      this.statusReason = theStatusReason;
      return this;
    }

    public boolean hasStatusReason() { 
      if (this.statusReason == null)
        return false;
      for (CodeableConcept item : this.statusReason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addStatusReason() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      this.statusReason.add(t);
      return t;
    }

    public DeviceAssociation addStatusReason(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      this.statusReason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statusReason}, creating it if it does not already exist {3}
     */
    public CodeableConcept getStatusReasonFirstRep() { 
      if (getStatusReason().isEmpty()) {
        addStatusReason();
      }
      return getStatusReason().get(0);
    }

    /**
     * @return {@link #subject} (The individual, group of individuals or device that the device is on or associated with.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceAssociation.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The individual, group of individuals or device that the device is on or associated with.)
     */
    public DeviceAssociation setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #bodyStructure} (Current anatomical location of the device in/on subject.)
     */
    public Reference getBodyStructure() { 
      if (this.bodyStructure == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceAssociation.bodyStructure");
        else if (Configuration.doAutoCreate())
          this.bodyStructure = new Reference(); // cc
      return this.bodyStructure;
    }

    public boolean hasBodyStructure() { 
      return this.bodyStructure != null && !this.bodyStructure.isEmpty();
    }

    /**
     * @param value {@link #bodyStructure} (Current anatomical location of the device in/on subject.)
     */
    public DeviceAssociation setBodyStructure(Reference value) { 
      this.bodyStructure = value;
      return this;
    }

    /**
     * @return {@link #period} (Begin and end dates and times for the device association.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceAssociation.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Begin and end dates and times for the device association.)
     */
    public DeviceAssociation setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #operation} (The details about the device when it is in use to describe its operation.)
     */
    public List<DeviceAssociationOperationComponent> getOperation() { 
      if (this.operation == null)
        this.operation = new ArrayList<DeviceAssociationOperationComponent>();
      return this.operation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceAssociation setOperation(List<DeviceAssociationOperationComponent> theOperation) { 
      this.operation = theOperation;
      return this;
    }

    public boolean hasOperation() { 
      if (this.operation == null)
        return false;
      for (DeviceAssociationOperationComponent item : this.operation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceAssociationOperationComponent addOperation() { //3
      DeviceAssociationOperationComponent t = new DeviceAssociationOperationComponent();
      if (this.operation == null)
        this.operation = new ArrayList<DeviceAssociationOperationComponent>();
      this.operation.add(t);
      return t;
    }

    public DeviceAssociation addOperation(DeviceAssociationOperationComponent t) { //3
      if (t == null)
        return this;
      if (this.operation == null)
        this.operation = new ArrayList<DeviceAssociationOperationComponent>();
      this.operation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
     */
    public DeviceAssociationOperationComponent getOperationFirstRep() { 
      if (getOperation().isEmpty()) {
        addOperation();
      }
      return getOperation().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Instance identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("device", "Reference(Device)", "Reference to the devices associated with the patient or group.", 0, 1, device));
        children.add(new Property("category", "CodeableConcept", "Describes the relationship between the device and subject.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("status", "CodeableConcept", "Indicates the state of the Device association.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "The reasons given for the current association status.", 0, java.lang.Integer.MAX_VALUE, statusReason));
        children.add(new Property("subject", "Reference(Patient|Group|Practitioner|RelatedPerson|Device)", "The individual, group of individuals or device that the device is on or associated with.", 0, 1, subject));
        children.add(new Property("bodyStructure", "Reference(BodyStructure)", "Current anatomical location of the device in/on subject.", 0, 1, bodyStructure));
        children.add(new Property("period", "Period", "Begin and end dates and times for the device association.", 0, 1, period));
        children.add(new Property("operation", "", "The details about the device when it is in use to describe its operation.", 0, java.lang.Integer.MAX_VALUE, operation));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Instance identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "Reference to the devices associated with the patient or group.", 0, 1, device);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Describes the relationship between the device and subject.", 0, java.lang.Integer.MAX_VALUE, category);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "Indicates the state of the Device association.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "The reasons given for the current association status.", 0, java.lang.Integer.MAX_VALUE, statusReason);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Practitioner|RelatedPerson|Device)", "The individual, group of individuals or device that the device is on or associated with.", 0, 1, subject);
        case -1001731599: /*bodyStructure*/  return new Property("bodyStructure", "Reference(BodyStructure)", "Current anatomical location of the device in/on subject.", 0, 1, bodyStructure);
        case -991726143: /*period*/  return new Property("period", "Period", "Begin and end dates and times for the device association.", 0, 1, period);
        case 1662702951: /*operation*/  return new Property("operation", "", "The details about the device when it is in use to describe its operation.", 0, java.lang.Integer.MAX_VALUE, operation);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : this.statusReason.toArray(new Base[this.statusReason.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -1001731599: /*bodyStructure*/ return this.bodyStructure == null ? new Base[0] : new Base[] {this.bodyStructure}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // DeviceAssociationOperationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 2051346646: // statusReason
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1001731599: // bodyStructure
          this.bodyStructure = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 1662702951: // operation
          this.getOperation().add((DeviceAssociationOperationComponent) value); // DeviceAssociationOperationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statusReason")) {
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("bodyStructure")) {
          this.bodyStructure = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("operation")) {
          this.getOperation().add((DeviceAssociationOperationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1335157162:  return getDevice();
        case 50511102:  return addCategory(); 
        case -892481550:  return getStatus();
        case 2051346646:  return addStatusReason(); 
        case -1867885268:  return getSubject();
        case -1001731599:  return getBodyStructure();
        case -991726143:  return getPeriod();
        case 1662702951:  return addOperation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -1001731599: /*bodyStructure*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 1662702951: /*operation*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusReason")) {
          return addStatusReason();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("bodyStructure")) {
          this.bodyStructure = new Reference();
          return this.bodyStructure;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DeviceAssociation";

  }

      public DeviceAssociation copy() {
        DeviceAssociation dst = new DeviceAssociation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceAssociation dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.device = device == null ? null : device.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (statusReason != null) {
          dst.statusReason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : statusReason)
            dst.statusReason.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.bodyStructure = bodyStructure == null ? null : bodyStructure.copy();
        dst.period = period == null ? null : period.copy();
        if (operation != null) {
          dst.operation = new ArrayList<DeviceAssociationOperationComponent>();
          for (DeviceAssociationOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
      }

      protected DeviceAssociation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceAssociation))
          return false;
        DeviceAssociation o = (DeviceAssociation) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(device, o.device, true) && compareDeep(category, o.category, true)
           && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true) && compareDeep(subject, o.subject, true)
           && compareDeep(bodyStructure, o.bodyStructure, true) && compareDeep(period, o.period, true) && compareDeep(operation, o.operation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceAssociation))
          return false;
        DeviceAssociation o = (DeviceAssociation) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, device, category
          , status, statusReason, subject, bodyStructure, period, operation);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DeviceAssociation;
   }

 /**
   * Search parameter: <b>device</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.device</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device", path="DeviceAssociation.device", description="Search for products that match this code", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device") }, target={Device.class } )
  public static final String SP_DEVICE = "device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.device</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceAssociation:device</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEVICE = new ca.uhn.fhir.model.api.Include("DeviceAssociation:device").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the device association</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceAssociation.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="DeviceAssociation.identifier", description="The identifier of the device association", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the device association</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceAssociation.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>operator</b>
   * <p>
   * Description: <b>The identity of a operator for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.operation.operator</b><br>
   * </p>
   */
  @SearchParamDefinition(name="operator", path="DeviceAssociation.operation.operator", description="The identity of a operator for whom to list associations", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Patient.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_OPERATOR = "operator";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>operator</b>
   * <p>
   * Description: <b>The identity of a operator for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.operation.operator</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam OPERATOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_OPERATOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceAssociation:operator</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_OPERATOR = new ca.uhn.fhir.model.api.Include("DeviceAssociation:operator").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="DeviceAssociation.subject.where(resolve() is Patient)", description="The identity of a patient for whom to list associations", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceAssociation:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DeviceAssociation:patient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the device associations</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceAssociation.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="DeviceAssociation.status", description="The status of the device associations", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the device associations</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceAssociation.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="DeviceAssociation.subject.where(resolve() is Patient)", description="The identity of a patient for whom to list associations", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceAssociation.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceAssociation:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("DeviceAssociation:subject").toLocked();


}

