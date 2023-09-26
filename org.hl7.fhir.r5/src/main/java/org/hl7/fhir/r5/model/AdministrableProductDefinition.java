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
 * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).
 */
@ResourceDef(name="AdministrableProductDefinition", profile="http://hl7.org/fhir/StructureDefinition/AdministrableProductDefinition")
public class AdministrableProductDefinition extends DomainResource {

    @Block()
    public static class AdministrableProductDefinitionPropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code expressing the type of characteristic.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code expressing the type of characteristic", formalDefinition="A code expressing the type of characteristic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/product-characteristic-codes")
        protected CodeableConcept type;

        /**
         * A value for the characteristic.
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class, DateType.class, BooleanType.class, MarkdownType.class, Attachment.class, Binary.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the characteristic", formalDefinition="A value for the characteristic." )
        protected DataType value;

        /**
         * The status of characteristic e.g. assigned or pending.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of characteristic e.g. assigned or pending", formalDefinition="The status of characteristic e.g. assigned or pending." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
        protected CodeableConcept status;

        private static final long serialVersionUID = -872048207L;

    /**
     * Constructor
     */
      public AdministrableProductDefinitionPropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdministrableProductDefinitionPropertyComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionPropertyComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code expressing the type of characteristic.)
         */
        public AdministrableProductDefinitionPropertyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (A value for the characteristic.)
         */
        public AdministrableProductDefinitionPropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof DateType || value instanceof BooleanType || value instanceof MarkdownType || value instanceof Attachment || value instanceof Reference))
            throw new FHIRException("Not the right type for AdministrableProductDefinition.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #status} (The status of characteristic e.g. assigned or pending.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionPropertyComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (The status of characteristic e.g. assigned or pending.)
         */
        public AdministrableProductDefinitionPropertyComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|date|boolean|markdown|Attachment|Reference(Binary)", "A value for the characteristic.", 0, 1, value));
          children.add(new Property("status", "CodeableConcept", "The status of characteristic e.g. assigned or pending.", 0, 1, status));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity|date|boolean|markdown|Attachment|Reference(Binary)", "A value for the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity|date|boolean|markdown|Attachment|Reference(Binary)", "A value for the characteristic.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "A value for the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "A value for the characteristic.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "A value for the characteristic.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "A value for the characteristic.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "A value for the characteristic.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "A value for the characteristic.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference(Binary)", "A value for the characteristic.", 0, 1, value);
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status of characteristic e.g. assigned or pending.", 0, 1, status);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
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
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else if (name.equals("status")) {
          this.status = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -892481550:  return getStatus();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "date", "boolean", "markdown", "Attachment", "Reference"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else
          return super.addChild(name);
      }

      public AdministrableProductDefinitionPropertyComponent copy() {
        AdministrableProductDefinitionPropertyComponent dst = new AdministrableProductDefinitionPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdministrableProductDefinitionPropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
        dst.status = status == null ? null : status.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionPropertyComponent))
          return false;
        AdministrableProductDefinitionPropertyComponent o = (AdministrableProductDefinitionPropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true) && compareDeep(status, o.status, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionPropertyComponent))
          return false;
        AdministrableProductDefinitionPropertyComponent o = (AdministrableProductDefinitionPropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value, status);
      }

  public String fhirType() {
    return "AdministrableProductDefinition.property";

  }

  }

    @Block()
    public static class AdministrableProductDefinitionRouteOfAdministrationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded expression for the route.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Coded expression for the route", formalDefinition="Coded expression for the route." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/route-codes")
        protected CodeableConcept code;

        /**
         * The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement.
         */
        @Child(name = "firstDose", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The first dose (dose quantity) administered can be specified for the product", formalDefinition="The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement." )
        protected Quantity firstDose;

        /**
         * The maximum single dose that can be administered, specified using a numerical value and its unit of measurement.
         */
        @Child(name = "maxSingleDose", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The maximum single dose that can be administered", formalDefinition="The maximum single dose that can be administered, specified using a numerical value and its unit of measurement." )
        protected Quantity maxSingleDose;

        /**
         * The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered.
         */
        @Child(name = "maxDosePerDay", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The maximum dose quantity to be administered in any one 24-h period", formalDefinition="The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered." )
        protected Quantity maxDosePerDay;

        /**
         * The maximum dose per treatment period that can be administered.
         */
        @Child(name = "maxDosePerTreatmentPeriod", type = {Ratio.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The maximum dose per treatment period that can be administered", formalDefinition="The maximum dose per treatment period that can be administered." )
        protected Ratio maxDosePerTreatmentPeriod;

        /**
         * The maximum treatment period during which the product can be administered.
         */
        @Child(name = "maxTreatmentPeriod", type = {Duration.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The maximum treatment period during which the product can be administered", formalDefinition="The maximum treatment period during which the product can be administered." )
        protected Duration maxTreatmentPeriod;

        /**
         * A species for which this route applies.
         */
        @Child(name = "targetSpecies", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A species for which this route applies", formalDefinition="A species for which this route applies." )
        protected List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent> targetSpecies;

        private static final long serialVersionUID = 322274730L;

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Coded expression for the route.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded expression for the route.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #firstDose} (The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement.)
         */
        public Quantity getFirstDose() { 
          if (this.firstDose == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.firstDose");
            else if (Configuration.doAutoCreate())
              this.firstDose = new Quantity(); // cc
          return this.firstDose;
        }

        public boolean hasFirstDose() { 
          return this.firstDose != null && !this.firstDose.isEmpty();
        }

        /**
         * @param value {@link #firstDose} (The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setFirstDose(Quantity value) { 
          this.firstDose = value;
          return this;
        }

        /**
         * @return {@link #maxSingleDose} (The maximum single dose that can be administered, specified using a numerical value and its unit of measurement.)
         */
        public Quantity getMaxSingleDose() { 
          if (this.maxSingleDose == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.maxSingleDose");
            else if (Configuration.doAutoCreate())
              this.maxSingleDose = new Quantity(); // cc
          return this.maxSingleDose;
        }

        public boolean hasMaxSingleDose() { 
          return this.maxSingleDose != null && !this.maxSingleDose.isEmpty();
        }

        /**
         * @param value {@link #maxSingleDose} (The maximum single dose that can be administered, specified using a numerical value and its unit of measurement.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setMaxSingleDose(Quantity value) { 
          this.maxSingleDose = value;
          return this;
        }

        /**
         * @return {@link #maxDosePerDay} (The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered.)
         */
        public Quantity getMaxDosePerDay() { 
          if (this.maxDosePerDay == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.maxDosePerDay");
            else if (Configuration.doAutoCreate())
              this.maxDosePerDay = new Quantity(); // cc
          return this.maxDosePerDay;
        }

        public boolean hasMaxDosePerDay() { 
          return this.maxDosePerDay != null && !this.maxDosePerDay.isEmpty();
        }

        /**
         * @param value {@link #maxDosePerDay} (The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setMaxDosePerDay(Quantity value) { 
          this.maxDosePerDay = value;
          return this;
        }

        /**
         * @return {@link #maxDosePerTreatmentPeriod} (The maximum dose per treatment period that can be administered.)
         */
        public Ratio getMaxDosePerTreatmentPeriod() { 
          if (this.maxDosePerTreatmentPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.maxDosePerTreatmentPeriod");
            else if (Configuration.doAutoCreate())
              this.maxDosePerTreatmentPeriod = new Ratio(); // cc
          return this.maxDosePerTreatmentPeriod;
        }

        public boolean hasMaxDosePerTreatmentPeriod() { 
          return this.maxDosePerTreatmentPeriod != null && !this.maxDosePerTreatmentPeriod.isEmpty();
        }

        /**
         * @param value {@link #maxDosePerTreatmentPeriod} (The maximum dose per treatment period that can be administered.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setMaxDosePerTreatmentPeriod(Ratio value) { 
          this.maxDosePerTreatmentPeriod = value;
          return this;
        }

        /**
         * @return {@link #maxTreatmentPeriod} (The maximum treatment period during which the product can be administered.)
         */
        public Duration getMaxTreatmentPeriod() { 
          if (this.maxTreatmentPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationComponent.maxTreatmentPeriod");
            else if (Configuration.doAutoCreate())
              this.maxTreatmentPeriod = new Duration(); // cc
          return this.maxTreatmentPeriod;
        }

        public boolean hasMaxTreatmentPeriod() { 
          return this.maxTreatmentPeriod != null && !this.maxTreatmentPeriod.isEmpty();
        }

        /**
         * @param value {@link #maxTreatmentPeriod} (The maximum treatment period during which the product can be administered.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setMaxTreatmentPeriod(Duration value) { 
          this.maxTreatmentPeriod = value;
          return this;
        }

        /**
         * @return {@link #targetSpecies} (A species for which this route applies.)
         */
        public List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent> getTargetSpecies() { 
          if (this.targetSpecies == null)
            this.targetSpecies = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent>();
          return this.targetSpecies;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AdministrableProductDefinitionRouteOfAdministrationComponent setTargetSpecies(List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent> theTargetSpecies) { 
          this.targetSpecies = theTargetSpecies;
          return this;
        }

        public boolean hasTargetSpecies() { 
          if (this.targetSpecies == null)
            return false;
          for (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent item : this.targetSpecies)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent addTargetSpecies() { //3
          AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent t = new AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent();
          if (this.targetSpecies == null)
            this.targetSpecies = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent>();
          this.targetSpecies.add(t);
          return t;
        }

        public AdministrableProductDefinitionRouteOfAdministrationComponent addTargetSpecies(AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent t) { //3
          if (t == null)
            return this;
          if (this.targetSpecies == null)
            this.targetSpecies = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent>();
          this.targetSpecies.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #targetSpecies}, creating it if it does not already exist {3}
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent getTargetSpeciesFirstRep() { 
          if (getTargetSpecies().isEmpty()) {
            addTargetSpecies();
          }
          return getTargetSpecies().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Coded expression for the route.", 0, 1, code));
          children.add(new Property("firstDose", "Quantity", "The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement.", 0, 1, firstDose));
          children.add(new Property("maxSingleDose", "Quantity", "The maximum single dose that can be administered, specified using a numerical value and its unit of measurement.", 0, 1, maxSingleDose));
          children.add(new Property("maxDosePerDay", "Quantity", "The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered.", 0, 1, maxDosePerDay));
          children.add(new Property("maxDosePerTreatmentPeriod", "Ratio", "The maximum dose per treatment period that can be administered.", 0, 1, maxDosePerTreatmentPeriod));
          children.add(new Property("maxTreatmentPeriod", "Duration", "The maximum treatment period during which the product can be administered.", 0, 1, maxTreatmentPeriod));
          children.add(new Property("targetSpecies", "", "A species for which this route applies.", 0, java.lang.Integer.MAX_VALUE, targetSpecies));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Coded expression for the route.", 0, 1, code);
          case 132551405: /*firstDose*/  return new Property("firstDose", "Quantity", "The first dose (dose quantity) administered can be specified for the product, using a numerical value and its unit of measurement.", 0, 1, firstDose);
          case -259207927: /*maxSingleDose*/  return new Property("maxSingleDose", "Quantity", "The maximum single dose that can be administered, specified using a numerical value and its unit of measurement.", 0, 1, maxSingleDose);
          case -2017475520: /*maxDosePerDay*/  return new Property("maxDosePerDay", "Quantity", "The maximum dose per day (maximum dose quantity to be administered in any one 24-h period) that can be administered.", 0, 1, maxDosePerDay);
          case -608040195: /*maxDosePerTreatmentPeriod*/  return new Property("maxDosePerTreatmentPeriod", "Ratio", "The maximum dose per treatment period that can be administered.", 0, 1, maxDosePerTreatmentPeriod);
          case 920698453: /*maxTreatmentPeriod*/  return new Property("maxTreatmentPeriod", "Duration", "The maximum treatment period during which the product can be administered.", 0, 1, maxTreatmentPeriod);
          case 295481963: /*targetSpecies*/  return new Property("targetSpecies", "", "A species for which this route applies.", 0, java.lang.Integer.MAX_VALUE, targetSpecies);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 132551405: /*firstDose*/ return this.firstDose == null ? new Base[0] : new Base[] {this.firstDose}; // Quantity
        case -259207927: /*maxSingleDose*/ return this.maxSingleDose == null ? new Base[0] : new Base[] {this.maxSingleDose}; // Quantity
        case -2017475520: /*maxDosePerDay*/ return this.maxDosePerDay == null ? new Base[0] : new Base[] {this.maxDosePerDay}; // Quantity
        case -608040195: /*maxDosePerTreatmentPeriod*/ return this.maxDosePerTreatmentPeriod == null ? new Base[0] : new Base[] {this.maxDosePerTreatmentPeriod}; // Ratio
        case 920698453: /*maxTreatmentPeriod*/ return this.maxTreatmentPeriod == null ? new Base[0] : new Base[] {this.maxTreatmentPeriod}; // Duration
        case 295481963: /*targetSpecies*/ return this.targetSpecies == null ? new Base[0] : this.targetSpecies.toArray(new Base[this.targetSpecies.size()]); // AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 132551405: // firstDose
          this.firstDose = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -259207927: // maxSingleDose
          this.maxSingleDose = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -2017475520: // maxDosePerDay
          this.maxDosePerDay = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -608040195: // maxDosePerTreatmentPeriod
          this.maxDosePerTreatmentPeriod = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 920698453: // maxTreatmentPeriod
          this.maxTreatmentPeriod = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 295481963: // targetSpecies
          this.getTargetSpecies().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent) value); // AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("firstDose")) {
          this.firstDose = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("maxSingleDose")) {
          this.maxSingleDose = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("maxDosePerDay")) {
          this.maxDosePerDay = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("maxDosePerTreatmentPeriod")) {
          this.maxDosePerTreatmentPeriod = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("maxTreatmentPeriod")) {
          this.maxTreatmentPeriod = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("targetSpecies")) {
          this.getTargetSpecies().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("firstDose")) {
          this.firstDose = null;
        } else if (name.equals("maxSingleDose")) {
          this.maxSingleDose = null;
        } else if (name.equals("maxDosePerDay")) {
          this.maxDosePerDay = null;
        } else if (name.equals("maxDosePerTreatmentPeriod")) {
          this.maxDosePerTreatmentPeriod = null;
        } else if (name.equals("maxTreatmentPeriod")) {
          this.maxTreatmentPeriod = null;
        } else if (name.equals("targetSpecies")) {
          this.getTargetSpecies().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case 132551405:  return getFirstDose();
        case -259207927:  return getMaxSingleDose();
        case -2017475520:  return getMaxDosePerDay();
        case -608040195:  return getMaxDosePerTreatmentPeriod();
        case 920698453:  return getMaxTreatmentPeriod();
        case 295481963:  return addTargetSpecies(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 132551405: /*firstDose*/ return new String[] {"Quantity"};
        case -259207927: /*maxSingleDose*/ return new String[] {"Quantity"};
        case -2017475520: /*maxDosePerDay*/ return new String[] {"Quantity"};
        case -608040195: /*maxDosePerTreatmentPeriod*/ return new String[] {"Ratio"};
        case 920698453: /*maxTreatmentPeriod*/ return new String[] {"Duration"};
        case 295481963: /*targetSpecies*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("firstDose")) {
          this.firstDose = new Quantity();
          return this.firstDose;
        }
        else if (name.equals("maxSingleDose")) {
          this.maxSingleDose = new Quantity();
          return this.maxSingleDose;
        }
        else if (name.equals("maxDosePerDay")) {
          this.maxDosePerDay = new Quantity();
          return this.maxDosePerDay;
        }
        else if (name.equals("maxDosePerTreatmentPeriod")) {
          this.maxDosePerTreatmentPeriod = new Ratio();
          return this.maxDosePerTreatmentPeriod;
        }
        else if (name.equals("maxTreatmentPeriod")) {
          this.maxTreatmentPeriod = new Duration();
          return this.maxTreatmentPeriod;
        }
        else if (name.equals("targetSpecies")) {
          return addTargetSpecies();
        }
        else
          return super.addChild(name);
      }

      public AdministrableProductDefinitionRouteOfAdministrationComponent copy() {
        AdministrableProductDefinitionRouteOfAdministrationComponent dst = new AdministrableProductDefinitionRouteOfAdministrationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdministrableProductDefinitionRouteOfAdministrationComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.firstDose = firstDose == null ? null : firstDose.copy();
        dst.maxSingleDose = maxSingleDose == null ? null : maxSingleDose.copy();
        dst.maxDosePerDay = maxDosePerDay == null ? null : maxDosePerDay.copy();
        dst.maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod == null ? null : maxDosePerTreatmentPeriod.copy();
        dst.maxTreatmentPeriod = maxTreatmentPeriod == null ? null : maxTreatmentPeriod.copy();
        if (targetSpecies != null) {
          dst.targetSpecies = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent>();
          for (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent i : targetSpecies)
            dst.targetSpecies.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationComponent o = (AdministrableProductDefinitionRouteOfAdministrationComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(firstDose, o.firstDose, true) && compareDeep(maxSingleDose, o.maxSingleDose, true)
           && compareDeep(maxDosePerDay, o.maxDosePerDay, true) && compareDeep(maxDosePerTreatmentPeriod, o.maxDosePerTreatmentPeriod, true)
           && compareDeep(maxTreatmentPeriod, o.maxTreatmentPeriod, true) && compareDeep(targetSpecies, o.targetSpecies, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationComponent o = (AdministrableProductDefinitionRouteOfAdministrationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, firstDose, maxSingleDose
          , maxDosePerDay, maxDosePerTreatmentPeriod, maxTreatmentPeriod, targetSpecies);
      }

  public String fhirType() {
    return "AdministrableProductDefinition.routeOfAdministration";

  }

  }

    @Block()
    public static class AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded expression for the species.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Coded expression for the species", formalDefinition="Coded expression for the species." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/target-species")
        protected CodeableConcept code;

        /**
         * A species specific time during which consumption of animal product is not appropriate.
         */
        @Child(name = "withdrawalPeriod", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A species specific time during which consumption of animal product is not appropriate", formalDefinition="A species specific time during which consumption of animal product is not appropriate." )
        protected List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent> withdrawalPeriod;

        private static final long serialVersionUID = -560311351L;

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Coded expression for the species.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded expression for the species.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #withdrawalPeriod} (A species specific time during which consumption of animal product is not appropriate.)
         */
        public List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent> getWithdrawalPeriod() { 
          if (this.withdrawalPeriod == null)
            this.withdrawalPeriod = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent>();
          return this.withdrawalPeriod;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent setWithdrawalPeriod(List<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent> theWithdrawalPeriod) { 
          this.withdrawalPeriod = theWithdrawalPeriod;
          return this;
        }

        public boolean hasWithdrawalPeriod() { 
          if (this.withdrawalPeriod == null)
            return false;
          for (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent item : this.withdrawalPeriod)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent addWithdrawalPeriod() { //3
          AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent t = new AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent();
          if (this.withdrawalPeriod == null)
            this.withdrawalPeriod = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent>();
          this.withdrawalPeriod.add(t);
          return t;
        }

        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent addWithdrawalPeriod(AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent t) { //3
          if (t == null)
            return this;
          if (this.withdrawalPeriod == null)
            this.withdrawalPeriod = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent>();
          this.withdrawalPeriod.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #withdrawalPeriod}, creating it if it does not already exist {3}
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent getWithdrawalPeriodFirstRep() { 
          if (getWithdrawalPeriod().isEmpty()) {
            addWithdrawalPeriod();
          }
          return getWithdrawalPeriod().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Coded expression for the species.", 0, 1, code));
          children.add(new Property("withdrawalPeriod", "", "A species specific time during which consumption of animal product is not appropriate.", 0, java.lang.Integer.MAX_VALUE, withdrawalPeriod));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Coded expression for the species.", 0, 1, code);
          case -98450730: /*withdrawalPeriod*/  return new Property("withdrawalPeriod", "", "A species specific time during which consumption of animal product is not appropriate.", 0, java.lang.Integer.MAX_VALUE, withdrawalPeriod);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -98450730: /*withdrawalPeriod*/ return this.withdrawalPeriod == null ? new Base[0] : this.withdrawalPeriod.toArray(new Base[this.withdrawalPeriod.size()]); // AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -98450730: // withdrawalPeriod
          this.getWithdrawalPeriod().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent) value); // AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("withdrawalPeriod")) {
          this.getWithdrawalPeriod().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("withdrawalPeriod")) {
          this.getWithdrawalPeriod().add((AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -98450730:  return addWithdrawalPeriod(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -98450730: /*withdrawalPeriod*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("withdrawalPeriod")) {
          return addWithdrawalPeriod();
        }
        else
          return super.addChild(name);
      }

      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent copy() {
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent dst = new AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (withdrawalPeriod != null) {
          dst.withdrawalPeriod = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent>();
          for (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent i : withdrawalPeriod)
            dst.withdrawalPeriod.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent o = (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(withdrawalPeriod, o.withdrawalPeriod, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent o = (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, withdrawalPeriod);
      }

  public String fhirType() {
    return "AdministrableProductDefinition.routeOfAdministration.targetSpecies";

  }

  }

    @Block()
    public static class AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk.
         */
        @Child(name = "tissue", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of tissue for which the withdrawal period applies, e.g. meat, milk", formalDefinition="Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/animal-tissue-type")
        protected CodeableConcept tissue;

        /**
         * A value for the time.
         */
        @Child(name = "value", type = {Quantity.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the time", formalDefinition="A value for the time." )
        protected Quantity value;

        /**
         * Extra information about the withdrawal period.
         */
        @Child(name = "supportingInformation", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Extra information about the withdrawal period", formalDefinition="Extra information about the withdrawal period." )
        protected StringType supportingInformation;

        private static final long serialVersionUID = -1113691238L;

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent(CodeableConcept tissue, Quantity value) {
        super();
        this.setTissue(tissue);
        this.setValue(value);
      }

        /**
         * @return {@link #tissue} (Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk.)
         */
        public CodeableConcept getTissue() { 
          if (this.tissue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent.tissue");
            else if (Configuration.doAutoCreate())
              this.tissue = new CodeableConcept(); // cc
          return this.tissue;
        }

        public boolean hasTissue() { 
          return this.tissue != null && !this.tissue.isEmpty();
        }

        /**
         * @param value {@link #tissue} (Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent setTissue(CodeableConcept value) { 
          this.tissue = value;
          return this;
        }

        /**
         * @return {@link #value} (A value for the time.)
         */
        public Quantity getValue() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new Quantity(); // cc
          return this.value;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (A value for the time.)
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent setValue(Quantity value) { 
          this.value = value;
          return this;
        }

        /**
         * @return {@link #supportingInformation} (Extra information about the withdrawal period.). This is the underlying object with id, value and extensions. The accessor "getSupportingInformation" gives direct access to the value
         */
        public StringType getSupportingInformationElement() { 
          if (this.supportingInformation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent.supportingInformation");
            else if (Configuration.doAutoCreate())
              this.supportingInformation = new StringType(); // bb
          return this.supportingInformation;
        }

        public boolean hasSupportingInformationElement() { 
          return this.supportingInformation != null && !this.supportingInformation.isEmpty();
        }

        public boolean hasSupportingInformation() { 
          return this.supportingInformation != null && !this.supportingInformation.isEmpty();
        }

        /**
         * @param value {@link #supportingInformation} (Extra information about the withdrawal period.). This is the underlying object with id, value and extensions. The accessor "getSupportingInformation" gives direct access to the value
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent setSupportingInformationElement(StringType value) { 
          this.supportingInformation = value;
          return this;
        }

        /**
         * @return Extra information about the withdrawal period.
         */
        public String getSupportingInformation() { 
          return this.supportingInformation == null ? null : this.supportingInformation.getValue();
        }

        /**
         * @param value Extra information about the withdrawal period.
         */
        public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent setSupportingInformation(String value) { 
          if (Utilities.noString(value))
            this.supportingInformation = null;
          else {
            if (this.supportingInformation == null)
              this.supportingInformation = new StringType();
            this.supportingInformation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("tissue", "CodeableConcept", "Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk.", 0, 1, tissue));
          children.add(new Property("value", "Quantity", "A value for the time.", 0, 1, value));
          children.add(new Property("supportingInformation", "string", "Extra information about the withdrawal period.", 0, 1, supportingInformation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -873475867: /*tissue*/  return new Property("tissue", "CodeableConcept", "Coded expression for the type of tissue for which the withdrawal period applies, e.g. meat, milk.", 0, 1, tissue);
          case 111972721: /*value*/  return new Property("value", "Quantity", "A value for the time.", 0, 1, value);
          case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "string", "Extra information about the withdrawal period.", 0, 1, supportingInformation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -873475867: /*tissue*/ return this.tissue == null ? new Base[0] : new Base[] {this.tissue}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // Quantity
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : new Base[] {this.supportingInformation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -873475867: // tissue
          this.tissue = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1248768647: // supportingInformation
          this.supportingInformation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("tissue")) {
          this.tissue = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("supportingInformation")) {
          this.supportingInformation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("tissue")) {
          this.tissue = null;
        } else if (name.equals("value")) {
          this.value = null;
        } else if (name.equals("supportingInformation")) {
          this.supportingInformation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -873475867:  return getTissue();
        case 111972721:  return getValue();
        case -1248768647:  return getSupportingInformationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -873475867: /*tissue*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity"};
        case -1248768647: /*supportingInformation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("tissue")) {
          this.tissue = new CodeableConcept();
          return this.tissue;
        }
        else if (name.equals("value")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("supportingInformation")) {
          throw new FHIRException("Cannot call addChild on a singleton property AdministrableProductDefinition.routeOfAdministration.targetSpecies.withdrawalPeriod.supportingInformation");
        }
        else
          return super.addChild(name);
      }

      public AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent copy() {
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent dst = new AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent dst) {
        super.copyValues(dst);
        dst.tissue = tissue == null ? null : tissue.copy();
        dst.value = value == null ? null : value.copy();
        dst.supportingInformation = supportingInformation == null ? null : supportingInformation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent o = (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent) other_;
        return compareDeep(tissue, o.tissue, true) && compareDeep(value, o.value, true) && compareDeep(supportingInformation, o.supportingInformation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent))
          return false;
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent o = (AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent) other_;
        return compareValues(supportingInformation, o.supportingInformation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(tissue, value, supportingInformation
          );
      }

  public String fhirType() {
    return "AdministrableProductDefinition.routeOfAdministration.targetSpecies.withdrawalPeriod";

  }

  }

    /**
     * An identifier for the administrable product.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An identifier for the administrable product", formalDefinition="An identifier for the administrable product." )
    protected List<Identifier> identifier;

    /**
     * The status of this administrable product. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this administrable product. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole.
     */
    @Child(name = "formOf", type = {MedicinalProductDefinition.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product", formalDefinition="References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole." )
    protected List<Reference> formOf;

    /**
     * The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection').
     */
    @Child(name = "administrableDoseForm", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The dose form of the final product after necessary reconstitution or processing", formalDefinition="The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection')." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrable-dose-form")
    protected CodeableConcept administrableDoseForm;

    /**
     * The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').
     */
    @Child(name = "unitOfPresentation", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The presentation type in which this item is given to a patient. e.g. for a spray - 'puff'", formalDefinition="The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial')." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/unit-of-presentation")
    protected CodeableConcept unitOfPresentation;

    /**
     * Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream.
     */
    @Child(name = "producedFrom", type = {ManufacturedItemDefinition.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form", formalDefinition="Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream." )
    protected List<Reference> producedFrom;

    /**
     * The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton (via AdministrableProductDefinition.producedFrom) to state which component items are used to make this, or using by incoming references from the Ingredient resource, to state in detail which substances exist within this. This element allows a basic coded ingredient to be used.
     */
    @Child(name = "ingredient", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton, or using by incoming references from the Ingredient resource", formalDefinition="The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton (via AdministrableProductDefinition.producedFrom) to state which component items are used to make this, or using by incoming references from the Ingredient resource, to state in detail which substances exist within this. This element allows a basic coded ingredient to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
    protected List<CodeableConcept> ingredient;

    /**
     * A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product. This is not intended for devices that are just co-packaged.
     */
    @Child(name = "device", type = {DeviceDefinition.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product", formalDefinition="A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product. This is not intended for devices that are just co-packaged." )
    protected Reference device;

    /**
     * A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed", formalDefinition="A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere." )
    protected MarkdownType description;

    /**
     * Characteristics e.g. a product's onset of action.
     */
    @Child(name = "property", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Characteristics e.g. a product's onset of action", formalDefinition="Characteristics e.g. a product's onset of action." )
    protected List<AdministrableProductDefinitionPropertyComponent> property;

    /**
     * The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).
     */
    @Child(name = "routeOfAdministration", type = {}, order=10, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The path by which the product is taken into or makes contact with the body", formalDefinition="The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa)." )
    protected List<AdministrableProductDefinitionRouteOfAdministrationComponent> routeOfAdministration;

    private static final long serialVersionUID = -487805677L;

  /**
   * Constructor
   */
    public AdministrableProductDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public AdministrableProductDefinition(PublicationStatus status, AdministrableProductDefinitionRouteOfAdministrationComponent routeOfAdministration) {
      super();
      this.setStatus(status);
      this.addRouteOfAdministration(routeOfAdministration);
    }

    /**
     * @return {@link #identifier} (An identifier for the administrable product.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public AdministrableProductDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of this administrable product. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdministrableProductDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this administrable product. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public AdministrableProductDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this administrable product. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this administrable product. Enables tracking the life-cycle of the content.
     */
    public AdministrableProductDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #formOf} (References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole.)
     */
    public List<Reference> getFormOf() { 
      if (this.formOf == null)
        this.formOf = new ArrayList<Reference>();
      return this.formOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setFormOf(List<Reference> theFormOf) { 
      this.formOf = theFormOf;
      return this;
    }

    public boolean hasFormOf() { 
      if (this.formOf == null)
        return false;
      for (Reference item : this.formOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addFormOf() { //3
      Reference t = new Reference();
      if (this.formOf == null)
        this.formOf = new ArrayList<Reference>();
      this.formOf.add(t);
      return t;
    }

    public AdministrableProductDefinition addFormOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.formOf == null)
        this.formOf = new ArrayList<Reference>();
      this.formOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #formOf}, creating it if it does not already exist {3}
     */
    public Reference getFormOfFirstRep() { 
      if (getFormOf().isEmpty()) {
        addFormOf();
      }
      return getFormOf().get(0);
    }

    /**
     * @return {@link #administrableDoseForm} (The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection').)
     */
    public CodeableConcept getAdministrableDoseForm() { 
      if (this.administrableDoseForm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdministrableProductDefinition.administrableDoseForm");
        else if (Configuration.doAutoCreate())
          this.administrableDoseForm = new CodeableConcept(); // cc
      return this.administrableDoseForm;
    }

    public boolean hasAdministrableDoseForm() { 
      return this.administrableDoseForm != null && !this.administrableDoseForm.isEmpty();
    }

    /**
     * @param value {@link #administrableDoseForm} (The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection').)
     */
    public AdministrableProductDefinition setAdministrableDoseForm(CodeableConcept value) { 
      this.administrableDoseForm = value;
      return this;
    }

    /**
     * @return {@link #unitOfPresentation} (The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').)
     */
    public CodeableConcept getUnitOfPresentation() { 
      if (this.unitOfPresentation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdministrableProductDefinition.unitOfPresentation");
        else if (Configuration.doAutoCreate())
          this.unitOfPresentation = new CodeableConcept(); // cc
      return this.unitOfPresentation;
    }

    public boolean hasUnitOfPresentation() { 
      return this.unitOfPresentation != null && !this.unitOfPresentation.isEmpty();
    }

    /**
     * @param value {@link #unitOfPresentation} (The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').)
     */
    public AdministrableProductDefinition setUnitOfPresentation(CodeableConcept value) { 
      this.unitOfPresentation = value;
      return this;
    }

    /**
     * @return {@link #producedFrom} (Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream.)
     */
    public List<Reference> getProducedFrom() { 
      if (this.producedFrom == null)
        this.producedFrom = new ArrayList<Reference>();
      return this.producedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setProducedFrom(List<Reference> theProducedFrom) { 
      this.producedFrom = theProducedFrom;
      return this;
    }

    public boolean hasProducedFrom() { 
      if (this.producedFrom == null)
        return false;
      for (Reference item : this.producedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addProducedFrom() { //3
      Reference t = new Reference();
      if (this.producedFrom == null)
        this.producedFrom = new ArrayList<Reference>();
      this.producedFrom.add(t);
      return t;
    }

    public AdministrableProductDefinition addProducedFrom(Reference t) { //3
      if (t == null)
        return this;
      if (this.producedFrom == null)
        this.producedFrom = new ArrayList<Reference>();
      this.producedFrom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #producedFrom}, creating it if it does not already exist {3}
     */
    public Reference getProducedFromFirstRep() { 
      if (getProducedFrom().isEmpty()) {
        addProducedFrom();
      }
      return getProducedFrom().get(0);
    }

    /**
     * @return {@link #ingredient} (The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton (via AdministrableProductDefinition.producedFrom) to state which component items are used to make this, or using by incoming references from the Ingredient resource, to state in detail which substances exist within this. This element allows a basic coded ingredient to be used.)
     */
    public List<CodeableConcept> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setIngredient(List<CodeableConcept> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (CodeableConcept item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addIngredient() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      this.ingredient.add(t);
      return t;
    }

    public AdministrableProductDefinition addIngredient(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public CodeableConcept getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #device} (A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product. This is not intended for devices that are just co-packaged.)
     */
    public Reference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdministrableProductDefinition.device");
        else if (Configuration.doAutoCreate())
          this.device = new Reference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product. This is not intended for devices that are just co-packaged.)
     */
    public AdministrableProductDefinition setDevice(Reference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #description} (A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdministrableProductDefinition.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public AdministrableProductDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.
     */
    public AdministrableProductDefinition setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #property} (Characteristics e.g. a product's onset of action.)
     */
    public List<AdministrableProductDefinitionPropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<AdministrableProductDefinitionPropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setProperty(List<AdministrableProductDefinitionPropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (AdministrableProductDefinitionPropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdministrableProductDefinitionPropertyComponent addProperty() { //3
      AdministrableProductDefinitionPropertyComponent t = new AdministrableProductDefinitionPropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<AdministrableProductDefinitionPropertyComponent>();
      this.property.add(t);
      return t;
    }

    public AdministrableProductDefinition addProperty(AdministrableProductDefinitionPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<AdministrableProductDefinitionPropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public AdministrableProductDefinitionPropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

    /**
     * @return {@link #routeOfAdministration} (The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).)
     */
    public List<AdministrableProductDefinitionRouteOfAdministrationComponent> getRouteOfAdministration() { 
      if (this.routeOfAdministration == null)
        this.routeOfAdministration = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationComponent>();
      return this.routeOfAdministration;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdministrableProductDefinition setRouteOfAdministration(List<AdministrableProductDefinitionRouteOfAdministrationComponent> theRouteOfAdministration) { 
      this.routeOfAdministration = theRouteOfAdministration;
      return this;
    }

    public boolean hasRouteOfAdministration() { 
      if (this.routeOfAdministration == null)
        return false;
      for (AdministrableProductDefinitionRouteOfAdministrationComponent item : this.routeOfAdministration)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdministrableProductDefinitionRouteOfAdministrationComponent addRouteOfAdministration() { //3
      AdministrableProductDefinitionRouteOfAdministrationComponent t = new AdministrableProductDefinitionRouteOfAdministrationComponent();
      if (this.routeOfAdministration == null)
        this.routeOfAdministration = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationComponent>();
      this.routeOfAdministration.add(t);
      return t;
    }

    public AdministrableProductDefinition addRouteOfAdministration(AdministrableProductDefinitionRouteOfAdministrationComponent t) { //3
      if (t == null)
        return this;
      if (this.routeOfAdministration == null)
        this.routeOfAdministration = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationComponent>();
      this.routeOfAdministration.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #routeOfAdministration}, creating it if it does not already exist {3}
     */
    public AdministrableProductDefinitionRouteOfAdministrationComponent getRouteOfAdministrationFirstRep() { 
      if (getRouteOfAdministration().isEmpty()) {
        addRouteOfAdministration();
      }
      return getRouteOfAdministration().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "An identifier for the administrable product.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of this administrable product. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("formOf", "Reference(MedicinalProductDefinition)", "References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole.", 0, java.lang.Integer.MAX_VALUE, formOf));
        children.add(new Property("administrableDoseForm", "CodeableConcept", "The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection').", 0, 1, administrableDoseForm));
        children.add(new Property("unitOfPresentation", "CodeableConcept", "The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').", 0, 1, unitOfPresentation));
        children.add(new Property("producedFrom", "Reference(ManufacturedItemDefinition)", "Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream.", 0, java.lang.Integer.MAX_VALUE, producedFrom));
        children.add(new Property("ingredient", "CodeableConcept", "The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton (via AdministrableProductDefinition.producedFrom) to state which component items are used to make this, or using by incoming references from the Ingredient resource, to state in detail which substances exist within this. This element allows a basic coded ingredient to be used.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("device", "Reference(DeviceDefinition)", "A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product. This is not intended for devices that are just co-packaged.", 0, 1, device));
        children.add(new Property("description", "markdown", "A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.", 0, 1, description));
        children.add(new Property("property", "", "Characteristics e.g. a product's onset of action.", 0, java.lang.Integer.MAX_VALUE, property));
        children.add(new Property("routeOfAdministration", "", "The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).", 0, java.lang.Integer.MAX_VALUE, routeOfAdministration));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "An identifier for the administrable product.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this administrable product. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -1268779589: /*formOf*/  return new Property("formOf", "Reference(MedicinalProductDefinition)", "References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole.", 0, java.lang.Integer.MAX_VALUE, formOf);
        case 1446105202: /*administrableDoseForm*/  return new Property("administrableDoseForm", "CodeableConcept", "The dose form of the final product after necessary reconstitution or processing. Contrasts to the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was 'powder for solution for injection', the administrable dose form could be 'solution for injection' (once mixed with another item having manufactured form 'solvent for solution for injection').", 0, 1, administrableDoseForm);
        case -1427765963: /*unitOfPresentation*/  return new Property("unitOfPresentation", "CodeableConcept", "The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').", 0, 1, unitOfPresentation);
        case 588380494: /*producedFrom*/  return new Property("producedFrom", "Reference(ManufacturedItemDefinition)", "Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream.", 0, java.lang.Integer.MAX_VALUE, producedFrom);
        case -206409263: /*ingredient*/  return new Property("ingredient", "CodeableConcept", "The ingredients of this administrable medicinal product. This is only needed if the ingredients are not specified either using ManufacturedItemDefiniton (via AdministrableProductDefinition.producedFrom) to state which component items are used to make this, or using by incoming references from the Ingredient resource, to state in detail which substances exist within this. This element allows a basic coded ingredient to be used.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case -1335157162: /*device*/  return new Property("device", "Reference(DeviceDefinition)", "A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product. This is not intended for devices that are just co-packaged.", 0, 1, device);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A general description of the product, when in its final form, suitable for administration e.g. effervescent blue liquid, to be swallowed. Intended to be used when the other structured properties of this resource are insufficient or cannot be supported. It is not intended to duplicate information already carried elswehere.", 0, 1, description);
        case -993141291: /*property*/  return new Property("property", "", "Characteristics e.g. a product's onset of action.", 0, java.lang.Integer.MAX_VALUE, property);
        case 1742084734: /*routeOfAdministration*/  return new Property("routeOfAdministration", "", "The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).", 0, java.lang.Integer.MAX_VALUE, routeOfAdministration);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -1268779589: /*formOf*/ return this.formOf == null ? new Base[0] : this.formOf.toArray(new Base[this.formOf.size()]); // Reference
        case 1446105202: /*administrableDoseForm*/ return this.administrableDoseForm == null ? new Base[0] : new Base[] {this.administrableDoseForm}; // CodeableConcept
        case -1427765963: /*unitOfPresentation*/ return this.unitOfPresentation == null ? new Base[0] : new Base[] {this.unitOfPresentation}; // CodeableConcept
        case 588380494: /*producedFrom*/ return this.producedFrom == null ? new Base[0] : this.producedFrom.toArray(new Base[this.producedFrom.size()]); // Reference
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // CodeableConcept
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // AdministrableProductDefinitionPropertyComponent
        case 1742084734: /*routeOfAdministration*/ return this.routeOfAdministration == null ? new Base[0] : this.routeOfAdministration.toArray(new Base[this.routeOfAdministration.size()]); // AdministrableProductDefinitionRouteOfAdministrationComponent
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
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -1268779589: // formOf
          this.getFormOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1446105202: // administrableDoseForm
          this.administrableDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1427765963: // unitOfPresentation
          this.unitOfPresentation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 588380494: // producedFrom
          this.getProducedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -206409263: // ingredient
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -993141291: // property
          this.getProperty().add((AdministrableProductDefinitionPropertyComponent) value); // AdministrableProductDefinitionPropertyComponent
          return value;
        case 1742084734: // routeOfAdministration
          this.getRouteOfAdministration().add((AdministrableProductDefinitionRouteOfAdministrationComponent) value); // AdministrableProductDefinitionRouteOfAdministrationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("formOf")) {
          this.getFormOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("administrableDoseForm")) {
          this.administrableDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("producedFrom")) {
          this.getProducedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("property")) {
          this.getProperty().add((AdministrableProductDefinitionPropertyComponent) value);
        } else if (name.equals("routeOfAdministration")) {
          this.getRouteOfAdministration().add((AdministrableProductDefinitionRouteOfAdministrationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("formOf")) {
          this.getFormOf().remove(value);
        } else if (name.equals("administrableDoseForm")) {
          this.administrableDoseForm = null;
        } else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = null;
        } else if (name.equals("producedFrom")) {
          this.getProducedFrom().remove(value);
        } else if (name.equals("ingredient")) {
          this.getIngredient().remove(value);
        } else if (name.equals("device")) {
          this.device = null;
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("property")) {
          this.getProperty().add((AdministrableProductDefinitionPropertyComponent) value);
        } else if (name.equals("routeOfAdministration")) {
          this.getRouteOfAdministration().add((AdministrableProductDefinitionRouteOfAdministrationComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -1268779589:  return addFormOf(); 
        case 1446105202:  return getAdministrableDoseForm();
        case -1427765963:  return getUnitOfPresentation();
        case 588380494:  return addProducedFrom(); 
        case -206409263:  return addIngredient(); 
        case -1335157162:  return getDevice();
        case -1724546052:  return getDescriptionElement();
        case -993141291:  return addProperty(); 
        case 1742084734:  return addRouteOfAdministration(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1268779589: /*formOf*/ return new String[] {"Reference"};
        case 1446105202: /*administrableDoseForm*/ return new String[] {"CodeableConcept"};
        case -1427765963: /*unitOfPresentation*/ return new String[] {"CodeableConcept"};
        case 588380494: /*producedFrom*/ return new String[] {"Reference"};
        case -206409263: /*ingredient*/ return new String[] {"CodeableConcept"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -993141291: /*property*/ return new String[] {};
        case 1742084734: /*routeOfAdministration*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property AdministrableProductDefinition.status");
        }
        else if (name.equals("formOf")) {
          return addFormOf();
        }
        else if (name.equals("administrableDoseForm")) {
          this.administrableDoseForm = new CodeableConcept();
          return this.administrableDoseForm;
        }
        else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = new CodeableConcept();
          return this.unitOfPresentation;
        }
        else if (name.equals("producedFrom")) {
          return addProducedFrom();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property AdministrableProductDefinition.description");
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("routeOfAdministration")) {
          return addRouteOfAdministration();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AdministrableProductDefinition";

  }

      public AdministrableProductDefinition copy() {
        AdministrableProductDefinition dst = new AdministrableProductDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdministrableProductDefinition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (formOf != null) {
          dst.formOf = new ArrayList<Reference>();
          for (Reference i : formOf)
            dst.formOf.add(i.copy());
        };
        dst.administrableDoseForm = administrableDoseForm == null ? null : administrableDoseForm.copy();
        dst.unitOfPresentation = unitOfPresentation == null ? null : unitOfPresentation.copy();
        if (producedFrom != null) {
          dst.producedFrom = new ArrayList<Reference>();
          for (Reference i : producedFrom)
            dst.producedFrom.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : ingredient)
            dst.ingredient.add(i.copy());
        };
        dst.device = device == null ? null : device.copy();
        dst.description = description == null ? null : description.copy();
        if (property != null) {
          dst.property = new ArrayList<AdministrableProductDefinitionPropertyComponent>();
          for (AdministrableProductDefinitionPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        if (routeOfAdministration != null) {
          dst.routeOfAdministration = new ArrayList<AdministrableProductDefinitionRouteOfAdministrationComponent>();
          for (AdministrableProductDefinitionRouteOfAdministrationComponent i : routeOfAdministration)
            dst.routeOfAdministration.add(i.copy());
        };
      }

      protected AdministrableProductDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinition))
          return false;
        AdministrableProductDefinition o = (AdministrableProductDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(formOf, o.formOf, true)
           && compareDeep(administrableDoseForm, o.administrableDoseForm, true) && compareDeep(unitOfPresentation, o.unitOfPresentation, true)
           && compareDeep(producedFrom, o.producedFrom, true) && compareDeep(ingredient, o.ingredient, true)
           && compareDeep(device, o.device, true) && compareDeep(description, o.description, true) && compareDeep(property, o.property, true)
           && compareDeep(routeOfAdministration, o.routeOfAdministration, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdministrableProductDefinition))
          return false;
        AdministrableProductDefinition o = (AdministrableProductDefinition) other_;
        return compareValues(status, o.status, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, formOf
          , administrableDoseForm, unitOfPresentation, producedFrom, ingredient, device, description
          , property, routeOfAdministration);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AdministrableProductDefinition;
   }

 /**
   * Search parameter: <b>device</b>
   * <p>
   * Description: <b>A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product. This is not intended for devices that are just co-packaged</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.device</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device", path="AdministrableProductDefinition.device", description="A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product. This is not intended for devices that are just co-packaged", type="reference", target={DeviceDefinition.class } )
  public static final String SP_DEVICE = "device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device</b>
   * <p>
   * Description: <b>A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product. This is not intended for devices that are just co-packaged</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.device</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdministrableProductDefinition:device</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEVICE = new ca.uhn.fhir.model.api.Include("AdministrableProductDefinition:device").toLocked();

 /**
   * Search parameter: <b>dose-form</b>
   * <p>
   * Description: <b>The administrable dose form, i.e. the dose form of the final product after necessary reconstitution or processing</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.administrableDoseForm</b><br>
   * </p>
   */
  @SearchParamDefinition(name="dose-form", path="AdministrableProductDefinition.administrableDoseForm", description="The administrable dose form, i.e. the dose form of the final product after necessary reconstitution or processing", type="token" )
  public static final String SP_DOSE_FORM = "dose-form";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>dose-form</b>
   * <p>
   * Description: <b>The administrable dose form, i.e. the dose form of the final product after necessary reconstitution or processing</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.administrableDoseForm</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOSE_FORM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOSE_FORM);

 /**
   * Search parameter: <b>form-of</b>
   * <p>
   * Description: <b>The medicinal product that this is an administrable form of. This is not a reference to the item(s) that make up this administrable form - it is the whole product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.formOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="form-of", path="AdministrableProductDefinition.formOf", description="The medicinal product that this is an administrable form of. This is not a reference to the item(s) that make up this administrable form - it is the whole product", type="reference", target={MedicinalProductDefinition.class } )
  public static final String SP_FORM_OF = "form-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>form-of</b>
   * <p>
   * Description: <b>The medicinal product that this is an administrable form of. This is not a reference to the item(s) that make up this administrable form - it is the whole product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.formOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FORM_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FORM_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdministrableProductDefinition:form-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FORM_OF = new ca.uhn.fhir.model.api.Include("AdministrableProductDefinition:form-of").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>An identifier for the administrable product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AdministrableProductDefinition.identifier", description="An identifier for the administrable product", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>An identifier for the administrable product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>The ingredients of this administrable medicinal product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.ingredient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="AdministrableProductDefinition.ingredient", description="The ingredients of this administrable medicinal product", type="token" )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>The ingredients of this administrable medicinal product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.ingredient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT);

 /**
   * Search parameter: <b>manufactured-item</b>
   * <p>
   * Description: <b>The manufactured item(s) that this administrable product is produced from. Either a single item, or several that are mixed before administration (e.g. a power item and a solution item). Note that these are not raw ingredients</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.producedFrom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufactured-item", path="AdministrableProductDefinition.producedFrom", description="The manufactured item(s) that this administrable product is produced from. Either a single item, or several that are mixed before administration (e.g. a power item and a solution item). Note that these are not raw ingredients", type="reference", target={ManufacturedItemDefinition.class } )
  public static final String SP_MANUFACTURED_ITEM = "manufactured-item";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufactured-item</b>
   * <p>
   * Description: <b>The manufactured item(s) that this administrable product is produced from. Either a single item, or several that are mixed before administration (e.g. a power item and a solution item). Note that these are not raw ingredients</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdministrableProductDefinition.producedFrom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURED_ITEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURED_ITEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdministrableProductDefinition:manufactured-item</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURED_ITEM = new ca.uhn.fhir.model.api.Include("AdministrableProductDefinition:manufactured-item").toLocked();

 /**
   * Search parameter: <b>route</b>
   * <p>
   * Description: <b>Coded expression for the route</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.routeOfAdministration.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="route", path="AdministrableProductDefinition.routeOfAdministration.code", description="Coded expression for the route", type="token" )
  public static final String SP_ROUTE = "route";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>route</b>
   * <p>
   * Description: <b>Coded expression for the route</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.routeOfAdministration.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ROUTE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ROUTE);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of this administrable product. Enables tracking the life-cycle of the content.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="AdministrableProductDefinition.status", description="The status of this administrable product. Enables tracking the life-cycle of the content.", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of this administrable product. Enables tracking the life-cycle of the content.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>target-species</b>
   * <p>
   * Description: <b>Coded expression for the species</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.routeOfAdministration.targetSpecies.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target-species", path="AdministrableProductDefinition.routeOfAdministration.targetSpecies.code", description="Coded expression for the species", type="token" )
  public static final String SP_TARGET_SPECIES = "target-species";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target-species</b>
   * <p>
   * Description: <b>Coded expression for the species</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdministrableProductDefinition.routeOfAdministration.targetSpecies.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TARGET_SPECIES = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TARGET_SPECIES);


}

