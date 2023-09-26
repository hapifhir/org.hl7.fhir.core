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
 * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
 */
@ResourceDef(name="ManufacturedItemDefinition", profile="http://hl7.org/fhir/StructureDefinition/ManufacturedItemDefinition")
public class ManufacturedItemDefinition extends DomainResource {

    @Block()
    public static class ManufacturedItemDefinitionPropertyComponent extends BackboneElement implements IBaseBackboneElement {
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

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionPropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionPropertyComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ManufacturedItemDefinitionPropertyComponent.type");
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
        public ManufacturedItemDefinitionPropertyComponent setType(CodeableConcept value) { 
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
        public ManufacturedItemDefinitionPropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof DateType || value instanceof BooleanType || value instanceof MarkdownType || value instanceof Attachment || value instanceof Reference))
            throw new FHIRException("Not the right type for ManufacturedItemDefinition.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|date|boolean|markdown|Attachment|Reference(Binary)", "A value for the characteristic.", 0, 1, value));
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
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
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "date", "boolean", "markdown", "Attachment", "Reference"};
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
        else
          return super.addChild(name);
      }

      public ManufacturedItemDefinitionPropertyComponent copy() {
        ManufacturedItemDefinitionPropertyComponent dst = new ManufacturedItemDefinitionPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ManufacturedItemDefinitionPropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionPropertyComponent))
          return false;
        ManufacturedItemDefinitionPropertyComponent o = (ManufacturedItemDefinitionPropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionPropertyComponent))
          return false;
        ManufacturedItemDefinitionPropertyComponent o = (ManufacturedItemDefinitionPropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "ManufacturedItemDefinition.property";

  }

  }

    @Block()
    public static class ManufacturedItemDefinitionComponentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Defining type of the component e.g. shell, layer, ink.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defining type of the component e.g. shell, layer, ink", formalDefinition="Defining type of the component e.g. shell, layer, ink." )
        protected CodeableConcept type;

        /**
         * The function of this component within the item e.g. delivers active ingredient, masks taste.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The function of this component within the item e.g. delivers active ingredient, masks taste", formalDefinition="The function of this component within the item e.g. delivers active ingredient, masks taste." )
        protected List<CodeableConcept> function;

        /**
         * The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume).
         */
        @Child(name = "amount", type = {Quantity.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume)", formalDefinition="The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume)." )
        protected List<Quantity> amount;

        /**
         * A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).
         */
        @Child(name = "constituent", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient)", formalDefinition="A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient)." )
        protected List<ManufacturedItemDefinitionComponentConstituentComponent> constituent;

        /**
         * General characteristics of this component.
         */
        @Child(name = "property", type = {ManufacturedItemDefinitionPropertyComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="General characteristics of this component", formalDefinition="General characteristics of this component." )
        protected List<ManufacturedItemDefinitionPropertyComponent> property;

        /**
         * A component that this component contains or is made from.
         */
        @Child(name = "component", type = {ManufacturedItemDefinitionComponentComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A component that this component contains or is made from", formalDefinition="A component that this component contains or is made from." )
        protected List<ManufacturedItemDefinitionComponentComponent> component;

        private static final long serialVersionUID = 537950590L;

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionComponentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionComponentComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (Defining type of the component e.g. shell, layer, ink.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ManufacturedItemDefinitionComponentComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Defining type of the component e.g. shell, layer, ink.)
         */
        public ManufacturedItemDefinitionComponentComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #function} (The function of this component within the item e.g. delivers active ingredient, masks taste.)
         */
        public List<CodeableConcept> getFunction() { 
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          return this.function;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentComponent setFunction(List<CodeableConcept> theFunction) { 
          this.function = theFunction;
          return this;
        }

        public boolean hasFunction() { 
          if (this.function == null)
            return false;
          for (CodeableConcept item : this.function)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addFunction() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          this.function.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentComponent addFunction(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          this.function.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #function}, creating it if it does not already exist {3}
         */
        public CodeableConcept getFunctionFirstRep() { 
          if (getFunction().isEmpty()) {
            addFunction();
          }
          return getFunction().get(0);
        }

        /**
         * @return {@link #amount} (The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume).)
         */
        public List<Quantity> getAmount() { 
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          return this.amount;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentComponent setAmount(List<Quantity> theAmount) { 
          this.amount = theAmount;
          return this;
        }

        public boolean hasAmount() { 
          if (this.amount == null)
            return false;
          for (Quantity item : this.amount)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Quantity addAmount() { //3
          Quantity t = new Quantity();
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          this.amount.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentComponent addAmount(Quantity t) { //3
          if (t == null)
            return this;
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          this.amount.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #amount}, creating it if it does not already exist {3}
         */
        public Quantity getAmountFirstRep() { 
          if (getAmount().isEmpty()) {
            addAmount();
          }
          return getAmount().get(0);
        }

        /**
         * @return {@link #constituent} (A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).)
         */
        public List<ManufacturedItemDefinitionComponentConstituentComponent> getConstituent() { 
          if (this.constituent == null)
            this.constituent = new ArrayList<ManufacturedItemDefinitionComponentConstituentComponent>();
          return this.constituent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentComponent setConstituent(List<ManufacturedItemDefinitionComponentConstituentComponent> theConstituent) { 
          this.constituent = theConstituent;
          return this;
        }

        public boolean hasConstituent() { 
          if (this.constituent == null)
            return false;
          for (ManufacturedItemDefinitionComponentConstituentComponent item : this.constituent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ManufacturedItemDefinitionComponentConstituentComponent addConstituent() { //3
          ManufacturedItemDefinitionComponentConstituentComponent t = new ManufacturedItemDefinitionComponentConstituentComponent();
          if (this.constituent == null)
            this.constituent = new ArrayList<ManufacturedItemDefinitionComponentConstituentComponent>();
          this.constituent.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentComponent addConstituent(ManufacturedItemDefinitionComponentConstituentComponent t) { //3
          if (t == null)
            return this;
          if (this.constituent == null)
            this.constituent = new ArrayList<ManufacturedItemDefinitionComponentConstituentComponent>();
          this.constituent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #constituent}, creating it if it does not already exist {3}
         */
        public ManufacturedItemDefinitionComponentConstituentComponent getConstituentFirstRep() { 
          if (getConstituent().isEmpty()) {
            addConstituent();
          }
          return getConstituent().get(0);
        }

        /**
         * @return {@link #property} (General characteristics of this component.)
         */
        public List<ManufacturedItemDefinitionPropertyComponent> getProperty() { 
          if (this.property == null)
            this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
          return this.property;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentComponent setProperty(List<ManufacturedItemDefinitionPropertyComponent> theProperty) { 
          this.property = theProperty;
          return this;
        }

        public boolean hasProperty() { 
          if (this.property == null)
            return false;
          for (ManufacturedItemDefinitionPropertyComponent item : this.property)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ManufacturedItemDefinitionPropertyComponent addProperty() { //3
          ManufacturedItemDefinitionPropertyComponent t = new ManufacturedItemDefinitionPropertyComponent();
          if (this.property == null)
            this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
          this.property.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentComponent addProperty(ManufacturedItemDefinitionPropertyComponent t) { //3
          if (t == null)
            return this;
          if (this.property == null)
            this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
          this.property.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
         */
        public ManufacturedItemDefinitionPropertyComponent getPropertyFirstRep() { 
          if (getProperty().isEmpty()) {
            addProperty();
          }
          return getProperty().get(0);
        }

        /**
         * @return {@link #component} (A component that this component contains or is made from.)
         */
        public List<ManufacturedItemDefinitionComponentComponent> getComponent() { 
          if (this.component == null)
            this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
          return this.component;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentComponent setComponent(List<ManufacturedItemDefinitionComponentComponent> theComponent) { 
          this.component = theComponent;
          return this;
        }

        public boolean hasComponent() { 
          if (this.component == null)
            return false;
          for (ManufacturedItemDefinitionComponentComponent item : this.component)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ManufacturedItemDefinitionComponentComponent addComponent() { //3
          ManufacturedItemDefinitionComponentComponent t = new ManufacturedItemDefinitionComponentComponent();
          if (this.component == null)
            this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
          this.component.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentComponent addComponent(ManufacturedItemDefinitionComponentComponent t) { //3
          if (t == null)
            return this;
          if (this.component == null)
            this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
          this.component.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
         */
        public ManufacturedItemDefinitionComponentComponent getComponentFirstRep() { 
          if (getComponent().isEmpty()) {
            addComponent();
          }
          return getComponent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Defining type of the component e.g. shell, layer, ink.", 0, 1, type));
          children.add(new Property("function", "CodeableConcept", "The function of this component within the item e.g. delivers active ingredient, masks taste.", 0, java.lang.Integer.MAX_VALUE, function));
          children.add(new Property("amount", "Quantity", "The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume).", 0, java.lang.Integer.MAX_VALUE, amount));
          children.add(new Property("constituent", "", "A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).", 0, java.lang.Integer.MAX_VALUE, constituent));
          children.add(new Property("property", "@ManufacturedItemDefinition.property", "General characteristics of this component.", 0, java.lang.Integer.MAX_VALUE, property));
          children.add(new Property("component", "@ManufacturedItemDefinition.component", "A component that this component contains or is made from.", 0, java.lang.Integer.MAX_VALUE, component));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Defining type of the component e.g. shell, layer, ink.", 0, 1, type);
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "The function of this component within the item e.g. delivers active ingredient, masks taste.", 0, java.lang.Integer.MAX_VALUE, function);
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "The measurable amount of total quantity of all substances in the component, expressable in different ways (e.g. by mass or volume).", 0, java.lang.Integer.MAX_VALUE, amount);
          case -1846470364: /*constituent*/  return new Property("constituent", "", "A reference to a constituent of the manufactured item as a whole, linked here so that its component location within the item can be indicated. This not where the item's ingredient are primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).", 0, java.lang.Integer.MAX_VALUE, constituent);
          case -993141291: /*property*/  return new Property("property", "@ManufacturedItemDefinition.property", "General characteristics of this component.", 0, java.lang.Integer.MAX_VALUE, property);
          case -1399907075: /*component*/  return new Property("component", "@ManufacturedItemDefinition.component", "A component that this component contains or is made from.", 0, java.lang.Integer.MAX_VALUE, component);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : this.function.toArray(new Base[this.function.size()]); // CodeableConcept
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : this.amount.toArray(new Base[this.amount.size()]); // Quantity
        case -1846470364: /*constituent*/ return this.constituent == null ? new Base[0] : this.constituent.toArray(new Base[this.constituent.size()]); // ManufacturedItemDefinitionComponentConstituentComponent
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // ManufacturedItemDefinitionPropertyComponent
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // ManufacturedItemDefinitionComponentComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1380938712: // function
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1413853096: // amount
          this.getAmount().add(TypeConvertor.castToQuantity(value)); // Quantity
          return value;
        case -1846470364: // constituent
          this.getConstituent().add((ManufacturedItemDefinitionComponentConstituentComponent) value); // ManufacturedItemDefinitionComponentConstituentComponent
          return value;
        case -993141291: // property
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value); // ManufacturedItemDefinitionPropertyComponent
          return value;
        case -1399907075: // component
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value); // ManufacturedItemDefinitionComponentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("function")) {
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("amount")) {
          this.getAmount().add(TypeConvertor.castToQuantity(value));
        } else if (name.equals("constituent")) {
          this.getConstituent().add((ManufacturedItemDefinitionComponentConstituentComponent) value);
        } else if (name.equals("property")) {
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value);
        } else if (name.equals("component")) {
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("function")) {
          this.getFunction().remove(value);
        } else if (name.equals("amount")) {
          this.getAmount().remove(value);
        } else if (name.equals("constituent")) {
          this.getConstituent().add((ManufacturedItemDefinitionComponentConstituentComponent) value);
        } else if (name.equals("property")) {
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value);
        } else if (name.equals("component")) {
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 1380938712:  return addFunction(); 
        case -1413853096:  return addAmount(); 
        case -1846470364:  return addConstituent(); 
        case -993141291:  return addProperty(); 
        case -1399907075:  return addComponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        case -1846470364: /*constituent*/ return new String[] {};
        case -993141291: /*property*/ return new String[] {"@ManufacturedItemDefinition.property"};
        case -1399907075: /*component*/ return new String[] {"@ManufacturedItemDefinition.component"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("function")) {
          return addFunction();
        }
        else if (name.equals("amount")) {
          return addAmount();
        }
        else if (name.equals("constituent")) {
          return addConstituent();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else
          return super.addChild(name);
      }

      public ManufacturedItemDefinitionComponentComponent copy() {
        ManufacturedItemDefinitionComponentComponent dst = new ManufacturedItemDefinitionComponentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ManufacturedItemDefinitionComponentComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (function != null) {
          dst.function = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : function)
            dst.function.add(i.copy());
        };
        if (amount != null) {
          dst.amount = new ArrayList<Quantity>();
          for (Quantity i : amount)
            dst.amount.add(i.copy());
        };
        if (constituent != null) {
          dst.constituent = new ArrayList<ManufacturedItemDefinitionComponentConstituentComponent>();
          for (ManufacturedItemDefinitionComponentConstituentComponent i : constituent)
            dst.constituent.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
          for (ManufacturedItemDefinitionPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        if (component != null) {
          dst.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
          for (ManufacturedItemDefinitionComponentComponent i : component)
            dst.component.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionComponentComponent))
          return false;
        ManufacturedItemDefinitionComponentComponent o = (ManufacturedItemDefinitionComponentComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(function, o.function, true) && compareDeep(amount, o.amount, true)
           && compareDeep(constituent, o.constituent, true) && compareDeep(property, o.property, true) && compareDeep(component, o.component, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionComponentComponent))
          return false;
        ManufacturedItemDefinitionComponentComponent o = (ManufacturedItemDefinitionComponentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, function, amount, constituent
          , property, component);
      }

  public String fhirType() {
    return "ManufacturedItemDefinition.component";

  }

  }

    @Block()
    public static class ManufacturedItemDefinitionComponentConstituentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The measurable amount of the substance, expressable in different ways (e.g. by mass or volume).
         */
        @Child(name = "amount", type = {Quantity.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The measurable amount of the substance, expressable in different ways (e.g. by mass or volume)", formalDefinition="The measurable amount of the substance, expressable in different ways (e.g. by mass or volume)." )
        protected List<Quantity> amount;

        /**
         * The physical location of the constituent/ingredient within the component. Example – if the component is the bead in the capsule, then the location would be where the ingredient resides within the product part – intragranular, extra-granular, etc.
         */
        @Child(name = "location", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The physical location of the constituent/ingredient within the component", formalDefinition="The physical location of the constituent/ingredient within the component. Example – if the component is the bead in the capsule, then the location would be where the ingredient resides within the product part – intragranular, extra-granular, etc." )
        protected List<CodeableConcept> location;

        /**
         * The function of this constituent within the component e.g. binder.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The function of this constituent within the component e.g. binder", formalDefinition="The function of this constituent within the component e.g. binder." )
        protected List<CodeableConcept> function;

        /**
         * The ingredient that is the constituent of the given component.
         */
        @Child(name = "hasIngredient", type = {CodeableReference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The ingredient that is the constituent of the given component", formalDefinition="The ingredient that is the constituent of the given component." )
        protected List<CodeableReference> hasIngredient;

        private static final long serialVersionUID = -708786069L;

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionComponentConstituentComponent() {
        super();
      }

        /**
         * @return {@link #amount} (The measurable amount of the substance, expressable in different ways (e.g. by mass or volume).)
         */
        public List<Quantity> getAmount() { 
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          return this.amount;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentConstituentComponent setAmount(List<Quantity> theAmount) { 
          this.amount = theAmount;
          return this;
        }

        public boolean hasAmount() { 
          if (this.amount == null)
            return false;
          for (Quantity item : this.amount)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Quantity addAmount() { //3
          Quantity t = new Quantity();
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          this.amount.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentConstituentComponent addAmount(Quantity t) { //3
          if (t == null)
            return this;
          if (this.amount == null)
            this.amount = new ArrayList<Quantity>();
          this.amount.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #amount}, creating it if it does not already exist {3}
         */
        public Quantity getAmountFirstRep() { 
          if (getAmount().isEmpty()) {
            addAmount();
          }
          return getAmount().get(0);
        }

        /**
         * @return {@link #location} (The physical location of the constituent/ingredient within the component. Example – if the component is the bead in the capsule, then the location would be where the ingredient resides within the product part – intragranular, extra-granular, etc.)
         */
        public List<CodeableConcept> getLocation() { 
          if (this.location == null)
            this.location = new ArrayList<CodeableConcept>();
          return this.location;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentConstituentComponent setLocation(List<CodeableConcept> theLocation) { 
          this.location = theLocation;
          return this;
        }

        public boolean hasLocation() { 
          if (this.location == null)
            return false;
          for (CodeableConcept item : this.location)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addLocation() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.location == null)
            this.location = new ArrayList<CodeableConcept>();
          this.location.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentConstituentComponent addLocation(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.location == null)
            this.location = new ArrayList<CodeableConcept>();
          this.location.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #location}, creating it if it does not already exist {3}
         */
        public CodeableConcept getLocationFirstRep() { 
          if (getLocation().isEmpty()) {
            addLocation();
          }
          return getLocation().get(0);
        }

        /**
         * @return {@link #function} (The function of this constituent within the component e.g. binder.)
         */
        public List<CodeableConcept> getFunction() { 
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          return this.function;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentConstituentComponent setFunction(List<CodeableConcept> theFunction) { 
          this.function = theFunction;
          return this;
        }

        public boolean hasFunction() { 
          if (this.function == null)
            return false;
          for (CodeableConcept item : this.function)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addFunction() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          this.function.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentConstituentComponent addFunction(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.function == null)
            this.function = new ArrayList<CodeableConcept>();
          this.function.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #function}, creating it if it does not already exist {3}
         */
        public CodeableConcept getFunctionFirstRep() { 
          if (getFunction().isEmpty()) {
            addFunction();
          }
          return getFunction().get(0);
        }

        /**
         * @return {@link #hasIngredient} (The ingredient that is the constituent of the given component.)
         */
        public List<CodeableReference> getHasIngredient() { 
          if (this.hasIngredient == null)
            this.hasIngredient = new ArrayList<CodeableReference>();
          return this.hasIngredient;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ManufacturedItemDefinitionComponentConstituentComponent setHasIngredient(List<CodeableReference> theHasIngredient) { 
          this.hasIngredient = theHasIngredient;
          return this;
        }

        public boolean hasHasIngredient() { 
          if (this.hasIngredient == null)
            return false;
          for (CodeableReference item : this.hasIngredient)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addHasIngredient() { //3
          CodeableReference t = new CodeableReference();
          if (this.hasIngredient == null)
            this.hasIngredient = new ArrayList<CodeableReference>();
          this.hasIngredient.add(t);
          return t;
        }

        public ManufacturedItemDefinitionComponentConstituentComponent addHasIngredient(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.hasIngredient == null)
            this.hasIngredient = new ArrayList<CodeableReference>();
          this.hasIngredient.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #hasIngredient}, creating it if it does not already exist {3}
         */
        public CodeableReference getHasIngredientFirstRep() { 
          if (getHasIngredient().isEmpty()) {
            addHasIngredient();
          }
          return getHasIngredient().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("amount", "Quantity", "The measurable amount of the substance, expressable in different ways (e.g. by mass or volume).", 0, java.lang.Integer.MAX_VALUE, amount));
          children.add(new Property("location", "CodeableConcept", "The physical location of the constituent/ingredient within the component. Example – if the component is the bead in the capsule, then the location would be where the ingredient resides within the product part – intragranular, extra-granular, etc.", 0, java.lang.Integer.MAX_VALUE, location));
          children.add(new Property("function", "CodeableConcept", "The function of this constituent within the component e.g. binder.", 0, java.lang.Integer.MAX_VALUE, function));
          children.add(new Property("hasIngredient", "CodeableReference(Ingredient)", "The ingredient that is the constituent of the given component.", 0, java.lang.Integer.MAX_VALUE, hasIngredient));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "The measurable amount of the substance, expressable in different ways (e.g. by mass or volume).", 0, java.lang.Integer.MAX_VALUE, amount);
          case 1901043637: /*location*/  return new Property("location", "CodeableConcept", "The physical location of the constituent/ingredient within the component. Example – if the component is the bead in the capsule, then the location would be where the ingredient resides within the product part – intragranular, extra-granular, etc.", 0, java.lang.Integer.MAX_VALUE, location);
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "The function of this constituent within the component e.g. binder.", 0, java.lang.Integer.MAX_VALUE, function);
          case 483059723: /*hasIngredient*/  return new Property("hasIngredient", "CodeableReference(Ingredient)", "The ingredient that is the constituent of the given component.", 0, java.lang.Integer.MAX_VALUE, hasIngredient);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : this.amount.toArray(new Base[this.amount.size()]); // Quantity
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // CodeableConcept
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : this.function.toArray(new Base[this.function.size()]); // CodeableConcept
        case 483059723: /*hasIngredient*/ return this.hasIngredient == null ? new Base[0] : this.hasIngredient.toArray(new Base[this.hasIngredient.size()]); // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1413853096: // amount
          this.getAmount().add(TypeConvertor.castToQuantity(value)); // Quantity
          return value;
        case 1901043637: // location
          this.getLocation().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1380938712: // function
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 483059723: // hasIngredient
          this.getHasIngredient().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("amount")) {
          this.getAmount().add(TypeConvertor.castToQuantity(value));
        } else if (name.equals("location")) {
          this.getLocation().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("function")) {
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("hasIngredient")) {
          this.getHasIngredient().add(TypeConvertor.castToCodeableReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("amount")) {
          this.getAmount().remove(value);
        } else if (name.equals("location")) {
          this.getLocation().remove(value);
        } else if (name.equals("function")) {
          this.getFunction().remove(value);
        } else if (name.equals("hasIngredient")) {
          this.getHasIngredient().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1413853096:  return addAmount(); 
        case 1901043637:  return addLocation(); 
        case 1380938712:  return addFunction(); 
        case 483059723:  return addHasIngredient(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        case 1901043637: /*location*/ return new String[] {"CodeableConcept"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 483059723: /*hasIngredient*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("amount")) {
          return addAmount();
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else if (name.equals("function")) {
          return addFunction();
        }
        else if (name.equals("hasIngredient")) {
          return addHasIngredient();
        }
        else
          return super.addChild(name);
      }

      public ManufacturedItemDefinitionComponentConstituentComponent copy() {
        ManufacturedItemDefinitionComponentConstituentComponent dst = new ManufacturedItemDefinitionComponentConstituentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ManufacturedItemDefinitionComponentConstituentComponent dst) {
        super.copyValues(dst);
        if (amount != null) {
          dst.amount = new ArrayList<Quantity>();
          for (Quantity i : amount)
            dst.amount.add(i.copy());
        };
        if (location != null) {
          dst.location = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : location)
            dst.location.add(i.copy());
        };
        if (function != null) {
          dst.function = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : function)
            dst.function.add(i.copy());
        };
        if (hasIngredient != null) {
          dst.hasIngredient = new ArrayList<CodeableReference>();
          for (CodeableReference i : hasIngredient)
            dst.hasIngredient.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionComponentConstituentComponent))
          return false;
        ManufacturedItemDefinitionComponentConstituentComponent o = (ManufacturedItemDefinitionComponentConstituentComponent) other_;
        return compareDeep(amount, o.amount, true) && compareDeep(location, o.location, true) && compareDeep(function, o.function, true)
           && compareDeep(hasIngredient, o.hasIngredient, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionComponentConstituentComponent))
          return false;
        ManufacturedItemDefinitionComponentConstituentComponent o = (ManufacturedItemDefinitionComponentConstituentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(amount, location, function
          , hasIngredient);
      }

  public String fhirType() {
    return "ManufacturedItemDefinition.component.constituent";

  }

  }

    /**
     * Unique identifier.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier", formalDefinition="Unique identifier." )
    protected List<Identifier> identifier;

    /**
     * The status of this item. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this item. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A descriptive name applied to this item.
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A descriptive name applied to this item", formalDefinition="A descriptive name applied to this item." )
    protected StringType name;

    /**
     * Dose form as manufactured and before any transformation into the pharmaceutical product.
     */
    @Child(name = "manufacturedDoseForm", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Dose form as manufactured (before any necessary transformation)", formalDefinition="Dose form as manufactured and before any transformation into the pharmaceutical product." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/manufactured-dose-form")
    protected CodeableConcept manufacturedDoseForm;

    /**
     * The “real-world” units in which the quantity of the manufactured item is described.
     */
    @Child(name = "unitOfPresentation", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The “real-world” units in which the quantity of the item is described", formalDefinition="The “real-world” units in which the quantity of the manufactured item is described." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/unit-of-presentation")
    protected CodeableConcept unitOfPresentation;

    /**
     * Manufacturer of the item, one of several possible.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of the item, one of several possible", formalDefinition="Manufacturer of the item, one of several possible." )
    protected List<Reference> manufacturer;

    /**
     * Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.
     */
    @Child(name = "marketingStatus", type = {MarketingStatus.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated", formalDefinition="Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated." )
    protected List<MarketingStatus> marketingStatus;

    /**
     * The ingredients of this manufactured item. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource.
     */
    @Child(name = "ingredient", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The ingredients of this manufactured item. Only needed if these are not specified by incoming references from the Ingredient resource", formalDefinition="The ingredients of this manufactured item. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
    protected List<CodeableConcept> ingredient;

    /**
     * General characteristics of this item.
     */
    @Child(name = "property", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="General characteristics of this item", formalDefinition="General characteristics of this item." )
    protected List<ManufacturedItemDefinitionPropertyComponent> property;

    /**
     * Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup.
     */
    @Child(name = "component", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup", formalDefinition="Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup." )
    protected List<ManufacturedItemDefinitionComponentComponent> component;

    private static final long serialVersionUID = 516510494L;

  /**
   * Constructor
   */
    public ManufacturedItemDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ManufacturedItemDefinition(PublicationStatus status, CodeableConcept manufacturedDoseForm) {
      super();
      this.setStatus(status);
      this.setManufacturedDoseForm(manufacturedDoseForm);
    }

    /**
     * @return {@link #identifier} (Unique identifier.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public ManufacturedItemDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of this item. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ManufacturedItemDefinition.status");
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
     * @param value {@link #status} (The status of this item. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ManufacturedItemDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this item. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this item. Enables tracking the life-cycle of the content.
     */
    public ManufacturedItemDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #name} (A descriptive name applied to this item.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ManufacturedItemDefinition.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A descriptive name applied to this item.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ManufacturedItemDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A descriptive name applied to this item.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A descriptive name applied to this item.
     */
    public ManufacturedItemDefinition setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #manufacturedDoseForm} (Dose form as manufactured and before any transformation into the pharmaceutical product.)
     */
    public CodeableConcept getManufacturedDoseForm() { 
      if (this.manufacturedDoseForm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ManufacturedItemDefinition.manufacturedDoseForm");
        else if (Configuration.doAutoCreate())
          this.manufacturedDoseForm = new CodeableConcept(); // cc
      return this.manufacturedDoseForm;
    }

    public boolean hasManufacturedDoseForm() { 
      return this.manufacturedDoseForm != null && !this.manufacturedDoseForm.isEmpty();
    }

    /**
     * @param value {@link #manufacturedDoseForm} (Dose form as manufactured and before any transformation into the pharmaceutical product.)
     */
    public ManufacturedItemDefinition setManufacturedDoseForm(CodeableConcept value) { 
      this.manufacturedDoseForm = value;
      return this;
    }

    /**
     * @return {@link #unitOfPresentation} (The “real-world” units in which the quantity of the manufactured item is described.)
     */
    public CodeableConcept getUnitOfPresentation() { 
      if (this.unitOfPresentation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ManufacturedItemDefinition.unitOfPresentation");
        else if (Configuration.doAutoCreate())
          this.unitOfPresentation = new CodeableConcept(); // cc
      return this.unitOfPresentation;
    }

    public boolean hasUnitOfPresentation() { 
      return this.unitOfPresentation != null && !this.unitOfPresentation.isEmpty();
    }

    /**
     * @param value {@link #unitOfPresentation} (The “real-world” units in which the quantity of the manufactured item is described.)
     */
    public ManufacturedItemDefinition setUnitOfPresentation(CodeableConcept value) { 
      this.unitOfPresentation = value;
      return this;
    }

    /**
     * @return {@link #manufacturer} (Manufacturer of the item, one of several possible.)
     */
    public List<Reference> getManufacturer() { 
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      return this.manufacturer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setManufacturer(List<Reference> theManufacturer) { 
      this.manufacturer = theManufacturer;
      return this;
    }

    public boolean hasManufacturer() { 
      if (this.manufacturer == null)
        return false;
      for (Reference item : this.manufacturer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addManufacturer() { //3
      Reference t = new Reference();
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      this.manufacturer.add(t);
      return t;
    }

    public ManufacturedItemDefinition addManufacturer(Reference t) { //3
      if (t == null)
        return this;
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      this.manufacturer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist {3}
     */
    public Reference getManufacturerFirstRep() { 
      if (getManufacturer().isEmpty()) {
        addManufacturer();
      }
      return getManufacturer().get(0);
    }

    /**
     * @return {@link #marketingStatus} (Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.)
     */
    public List<MarketingStatus> getMarketingStatus() { 
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      return this.marketingStatus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setMarketingStatus(List<MarketingStatus> theMarketingStatus) { 
      this.marketingStatus = theMarketingStatus;
      return this;
    }

    public boolean hasMarketingStatus() { 
      if (this.marketingStatus == null)
        return false;
      for (MarketingStatus item : this.marketingStatus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MarketingStatus addMarketingStatus() { //3
      MarketingStatus t = new MarketingStatus();
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      this.marketingStatus.add(t);
      return t;
    }

    public ManufacturedItemDefinition addMarketingStatus(MarketingStatus t) { //3
      if (t == null)
        return this;
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      this.marketingStatus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #marketingStatus}, creating it if it does not already exist {3}
     */
    public MarketingStatus getMarketingStatusFirstRep() { 
      if (getMarketingStatus().isEmpty()) {
        addMarketingStatus();
      }
      return getMarketingStatus().get(0);
    }

    /**
     * @return {@link #ingredient} (The ingredients of this manufactured item. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource.)
     */
    public List<CodeableConcept> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setIngredient(List<CodeableConcept> theIngredient) { 
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

    public ManufacturedItemDefinition addIngredient(CodeableConcept t) { //3
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
     * @return {@link #property} (General characteristics of this item.)
     */
    public List<ManufacturedItemDefinitionPropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setProperty(List<ManufacturedItemDefinitionPropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (ManufacturedItemDefinitionPropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ManufacturedItemDefinitionPropertyComponent addProperty() { //3
      ManufacturedItemDefinitionPropertyComponent t = new ManufacturedItemDefinitionPropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
      this.property.add(t);
      return t;
    }

    public ManufacturedItemDefinition addProperty(ManufacturedItemDefinitionPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public ManufacturedItemDefinitionPropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

    /**
     * @return {@link #component} (Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup.)
     */
    public List<ManufacturedItemDefinitionComponentComponent> getComponent() { 
      if (this.component == null)
        this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
      return this.component;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setComponent(List<ManufacturedItemDefinitionComponentComponent> theComponent) { 
      this.component = theComponent;
      return this;
    }

    public boolean hasComponent() { 
      if (this.component == null)
        return false;
      for (ManufacturedItemDefinitionComponentComponent item : this.component)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ManufacturedItemDefinitionComponentComponent addComponent() { //3
      ManufacturedItemDefinitionComponentComponent t = new ManufacturedItemDefinitionComponentComponent();
      if (this.component == null)
        this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
      this.component.add(t);
      return t;
    }

    public ManufacturedItemDefinition addComponent(ManufacturedItemDefinitionComponentComponent t) { //3
      if (t == null)
        return this;
      if (this.component == null)
        this.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
      this.component.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
     */
    public ManufacturedItemDefinitionComponentComponent getComponentFirstRep() { 
      if (getComponent().isEmpty()) {
        addComponent();
      }
      return getComponent().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of this item. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("name", "string", "A descriptive name applied to this item.", 0, 1, name));
        children.add(new Property("manufacturedDoseForm", "CodeableConcept", "Dose form as manufactured and before any transformation into the pharmaceutical product.", 0, 1, manufacturedDoseForm));
        children.add(new Property("unitOfPresentation", "CodeableConcept", "The “real-world” units in which the quantity of the manufactured item is described.", 0, 1, unitOfPresentation));
        children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of the item, one of several possible.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("marketingStatus", "MarketingStatus", "Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.", 0, java.lang.Integer.MAX_VALUE, marketingStatus));
        children.add(new Property("ingredient", "CodeableConcept", "The ingredients of this manufactured item. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("property", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, property));
        children.add(new Property("component", "", "Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup.", 0, java.lang.Integer.MAX_VALUE, component));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this item. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 3373707: /*name*/  return new Property("name", "string", "A descriptive name applied to this item.", 0, 1, name);
        case -1451400348: /*manufacturedDoseForm*/  return new Property("manufacturedDoseForm", "CodeableConcept", "Dose form as manufactured and before any transformation into the pharmaceutical product.", 0, 1, manufacturedDoseForm);
        case -1427765963: /*unitOfPresentation*/  return new Property("unitOfPresentation", "CodeableConcept", "The “real-world” units in which the quantity of the manufactured item is described.", 0, 1, unitOfPresentation);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of the item, one of several possible.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case 70767032: /*marketingStatus*/  return new Property("marketingStatus", "MarketingStatus", "Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.", 0, java.lang.Integer.MAX_VALUE, marketingStatus);
        case -206409263: /*ingredient*/  return new Property("ingredient", "CodeableConcept", "The ingredients of this manufactured item. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case -993141291: /*property*/  return new Property("property", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, property);
        case -1399907075: /*component*/  return new Property("component", "", "Physical parts of the manufactured item, that it is intrisically made from. This is distinct from the ingredients that are part of its chemical makeup.", 0, java.lang.Integer.MAX_VALUE, component);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1451400348: /*manufacturedDoseForm*/ return this.manufacturedDoseForm == null ? new Base[0] : new Base[] {this.manufacturedDoseForm}; // CodeableConcept
        case -1427765963: /*unitOfPresentation*/ return this.unitOfPresentation == null ? new Base[0] : new Base[] {this.unitOfPresentation}; // CodeableConcept
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case 70767032: /*marketingStatus*/ return this.marketingStatus == null ? new Base[0] : this.marketingStatus.toArray(new Base[this.marketingStatus.size()]); // MarketingStatus
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // CodeableConcept
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // ManufacturedItemDefinitionPropertyComponent
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // ManufacturedItemDefinitionComponentComponent
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
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1451400348: // manufacturedDoseForm
          this.manufacturedDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1427765963: // unitOfPresentation
          this.unitOfPresentation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 70767032: // marketingStatus
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value)); // MarketingStatus
          return value;
        case -206409263: // ingredient
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -993141291: // property
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value); // ManufacturedItemDefinitionPropertyComponent
          return value;
        case -1399907075: // component
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value); // ManufacturedItemDefinitionComponentComponent
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
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("manufacturedDoseForm")) {
          this.manufacturedDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("property")) {
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value);
        } else if (name.equals("component")) {
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value);
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
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("manufacturedDoseForm")) {
          this.manufacturedDoseForm = null;
        } else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = null;
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().remove(value);
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().remove(value);
        } else if (name.equals("ingredient")) {
          this.getIngredient().remove(value);
        } else if (name.equals("property")) {
          this.getProperty().add((ManufacturedItemDefinitionPropertyComponent) value);
        } else if (name.equals("component")) {
          this.getComponent().add((ManufacturedItemDefinitionComponentComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 3373707:  return getNameElement();
        case -1451400348:  return getManufacturedDoseForm();
        case -1427765963:  return getUnitOfPresentation();
        case -1969347631:  return addManufacturer(); 
        case 70767032:  return addMarketingStatus(); 
        case -206409263:  return addIngredient(); 
        case -993141291:  return addProperty(); 
        case -1399907075:  return addComponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1451400348: /*manufacturedDoseForm*/ return new String[] {"CodeableConcept"};
        case -1427765963: /*unitOfPresentation*/ return new String[] {"CodeableConcept"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 70767032: /*marketingStatus*/ return new String[] {"MarketingStatus"};
        case -206409263: /*ingredient*/ return new String[] {"CodeableConcept"};
        case -993141291: /*property*/ return new String[] {};
        case -1399907075: /*component*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property ManufacturedItemDefinition.status");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ManufacturedItemDefinition.name");
        }
        else if (name.equals("manufacturedDoseForm")) {
          this.manufacturedDoseForm = new CodeableConcept();
          return this.manufacturedDoseForm;
        }
        else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = new CodeableConcept();
          return this.unitOfPresentation;
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("marketingStatus")) {
          return addMarketingStatus();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ManufacturedItemDefinition";

  }

      public ManufacturedItemDefinition copy() {
        ManufacturedItemDefinition dst = new ManufacturedItemDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ManufacturedItemDefinition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.name = name == null ? null : name.copy();
        dst.manufacturedDoseForm = manufacturedDoseForm == null ? null : manufacturedDoseForm.copy();
        dst.unitOfPresentation = unitOfPresentation == null ? null : unitOfPresentation.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (marketingStatus != null) {
          dst.marketingStatus = new ArrayList<MarketingStatus>();
          for (MarketingStatus i : marketingStatus)
            dst.marketingStatus.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<ManufacturedItemDefinitionPropertyComponent>();
          for (ManufacturedItemDefinitionPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        if (component != null) {
          dst.component = new ArrayList<ManufacturedItemDefinitionComponentComponent>();
          for (ManufacturedItemDefinitionComponentComponent i : component)
            dst.component.add(i.copy());
        };
      }

      protected ManufacturedItemDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinition))
          return false;
        ManufacturedItemDefinition o = (ManufacturedItemDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(name, o.name, true)
           && compareDeep(manufacturedDoseForm, o.manufacturedDoseForm, true) && compareDeep(unitOfPresentation, o.unitOfPresentation, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(marketingStatus, o.marketingStatus, true)
           && compareDeep(ingredient, o.ingredient, true) && compareDeep(property, o.property, true) && compareDeep(component, o.component, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinition))
          return false;
        ManufacturedItemDefinition o = (ManufacturedItemDefinition) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, name
          , manufacturedDoseForm, unitOfPresentation, manufacturer, marketingStatus, ingredient
          , property, component);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ManufacturedItemDefinition;
   }

 /**
   * Search parameter: <b>dose-form</b>
   * <p>
   * Description: <b>Dose form as manufactured and before any transformation into the pharmaceutical product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.manufacturedDoseForm</b><br>
   * </p>
   */
  @SearchParamDefinition(name="dose-form", path="ManufacturedItemDefinition.manufacturedDoseForm", description="Dose form as manufactured and before any transformation into the pharmaceutical product", type="token" )
  public static final String SP_DOSE_FORM = "dose-form";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>dose-form</b>
   * <p>
   * Description: <b>Dose form as manufactured and before any transformation into the pharmaceutical product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.manufacturedDoseForm</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOSE_FORM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOSE_FORM);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ManufacturedItemDefinition.identifier", description="Unique identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>An ingredient of this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.ingredient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="ManufacturedItemDefinition.ingredient", description="An ingredient of this item", type="token" )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>An ingredient of this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.ingredient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A descriptive name applied to this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ManufacturedItemDefinition.name", description="A descriptive name applied to this item", type="token" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A descriptive name applied to this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam NAME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_NAME);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of this item. Enables tracking the life-cycle of the content.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ManufacturedItemDefinition.status", description="The status of this item. Enables tracking the life-cycle of the content.", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of this item. Enables tracking the life-cycle of the content.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ManufacturedItemDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

