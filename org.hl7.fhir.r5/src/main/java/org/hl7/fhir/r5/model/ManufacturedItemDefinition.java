package org.hl7.fhir.r5.model;


/*
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0

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
 * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
 */
@ResourceDef(name="ManufacturedItemDefinition", profile="http://hl7.org/fhir/StructureDefinition/ManufacturedItemDefinition")
public class ManufacturedItemDefinition extends DomainResource {

    @Block()
    public static class ManufacturedItemDefinitionCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code expressing the type of characteristic.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code expressing the type of characteristic", formalDefinition="A code expressing the type of characteristic." )
        protected CodeableConcept code;

        /**
         * A value for the characteristic.
         */
        @Child(name = "value", type = {Coding.class, Quantity.class, StringType.class, DateType.class, BooleanType.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the characteristic", formalDefinition="A value for the characteristic." )
        protected DataType value;

        private static final long serialVersionUID = -1950789033L;

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ManufacturedItemDefinitionCharacteristicComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ManufacturedItemDefinitionCharacteristicComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code expressing the type of characteristic.)
         */
        public ManufacturedItemDefinitionCharacteristicComponent setCode(CodeableConcept value) { 
          this.code = value;
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (A value for the characteristic.)
         */
        public ManufacturedItemDefinitionCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Coding || value instanceof Quantity || value instanceof StringType || value instanceof DateType || value instanceof BooleanType || value instanceof Attachment))
            throw new Error("Not the right type for ManufacturedItemDefinition.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, code));
          children.add(new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "A value for the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "A value for the characteristic.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "A value for the characteristic.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "A value for the characteristic.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "A value for the characteristic.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "A value for the characteristic.", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"Coding", "Quantity", "string", "date", "boolean", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
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
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public ManufacturedItemDefinitionCharacteristicComponent copy() {
        ManufacturedItemDefinitionCharacteristicComponent dst = new ManufacturedItemDefinitionCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ManufacturedItemDefinitionCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionCharacteristicComponent))
          return false;
        ManufacturedItemDefinitionCharacteristicComponent o = (ManufacturedItemDefinitionCharacteristicComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinitionCharacteristicComponent))
          return false;
        ManufacturedItemDefinitionCharacteristicComponent o = (ManufacturedItemDefinitionCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value);
      }

  public String fhirType() {
    return "ManufacturedItemDefinition.characteristic";

  }

  }

    /**
     * Unique identifier.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier", formalDefinition="Unique identifier." )
    protected List<Identifier> identifier;

    /**
     * Dose form as manufactured and before any transformation into the pharmaceutical product.
     */
    @Child(name = "manufacturedDoseForm", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Dose form as manufactured and before any transformation into the pharmaceutical product", formalDefinition="Dose form as manufactured and before any transformation into the pharmaceutical product." )
    protected CodeableConcept manufacturedDoseForm;

    /**
     * The “real world” units in which the quantity of the manufactured item is described.
     */
    @Child(name = "unitOfPresentation", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The “real world” units in which the quantity of the manufactured item is described", formalDefinition="The “real world” units in which the quantity of the manufactured item is described." )
    protected CodeableConcept unitOfPresentation;

    /**
     * Manufacturer of the item (Note that this should be named "manufacturer" but it currently causes technical issues).
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of the item (Note that this should be named \"manufacturer\" but it currently causes technical issues)", formalDefinition="Manufacturer of the item (Note that this should be named \"manufacturer\" but it currently causes technical issues)." )
    protected List<Reference> manufacturer;

    /**
     * The ingredients that make up this manufactured item.
     */
    @Child(name = "ingredient", type = {Ingredient.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The ingredients that make up this manufactured item", formalDefinition="The ingredients that make up this manufactured item." )
    protected List<Reference> ingredient;

    /**
     * General characteristics of this item.
     */
    @Child(name = "characteristic", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="General characteristics of this item", formalDefinition="General characteristics of this item." )
    protected List<ManufacturedItemDefinitionCharacteristicComponent> characteristic;

    private static final long serialVersionUID = -2112474361L;

  /**
   * Constructor
   */
    public ManufacturedItemDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ManufacturedItemDefinition(CodeableConcept manufacturedDoseForm) {
      super();
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
     * @return {@link #unitOfPresentation} (The “real world” units in which the quantity of the manufactured item is described.)
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
     * @param value {@link #unitOfPresentation} (The “real world” units in which the quantity of the manufactured item is described.)
     */
    public ManufacturedItemDefinition setUnitOfPresentation(CodeableConcept value) { 
      this.unitOfPresentation = value;
      return this;
    }

    /**
     * @return {@link #manufacturer} (Manufacturer of the item (Note that this should be named "manufacturer" but it currently causes technical issues).)
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
     * @return {@link #ingredient} (The ingredients that make up this manufactured item.)
     */
    public List<Reference> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setIngredient(List<Reference> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (Reference item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addIngredient() { //3
      Reference t = new Reference();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      this.ingredient.add(t);
      return t;
    }

    public ManufacturedItemDefinition addIngredient(Reference t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public Reference getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #characteristic} (General characteristics of this item.)
     */
    public List<ManufacturedItemDefinitionCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<ManufacturedItemDefinitionCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ManufacturedItemDefinition setCharacteristic(List<ManufacturedItemDefinitionCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (ManufacturedItemDefinitionCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ManufacturedItemDefinitionCharacteristicComponent addCharacteristic() { //3
      ManufacturedItemDefinitionCharacteristicComponent t = new ManufacturedItemDefinitionCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<ManufacturedItemDefinitionCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public ManufacturedItemDefinition addCharacteristic(ManufacturedItemDefinitionCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<ManufacturedItemDefinitionCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public ManufacturedItemDefinitionCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("manufacturedDoseForm", "CodeableConcept", "Dose form as manufactured and before any transformation into the pharmaceutical product.", 0, 1, manufacturedDoseForm));
        children.add(new Property("unitOfPresentation", "CodeableConcept", "The “real world” units in which the quantity of the manufactured item is described.", 0, 1, unitOfPresentation));
        children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of the item (Note that this should be named \"manufacturer\" but it currently causes technical issues).", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("ingredient", "Reference(Ingredient)", "The ingredients that make up this manufactured item.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("characteristic", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, characteristic));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1451400348: /*manufacturedDoseForm*/  return new Property("manufacturedDoseForm", "CodeableConcept", "Dose form as manufactured and before any transformation into the pharmaceutical product.", 0, 1, manufacturedDoseForm);
        case -1427765963: /*unitOfPresentation*/  return new Property("unitOfPresentation", "CodeableConcept", "The “real world” units in which the quantity of the manufactured item is described.", 0, 1, unitOfPresentation);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of the item (Note that this should be named \"manufacturer\" but it currently causes technical issues).", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case -206409263: /*ingredient*/  return new Property("ingredient", "Reference(Ingredient)", "The ingredients that make up this manufactured item.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, characteristic);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1451400348: /*manufacturedDoseForm*/ return this.manufacturedDoseForm == null ? new Base[0] : new Base[] {this.manufacturedDoseForm}; // CodeableConcept
        case -1427765963: /*unitOfPresentation*/ return this.unitOfPresentation == null ? new Base[0] : new Base[] {this.unitOfPresentation}; // CodeableConcept
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // Reference
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // ManufacturedItemDefinitionCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
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
        case -206409263: // ingredient
          this.getIngredient().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((ManufacturedItemDefinitionCharacteristicComponent) value); // ManufacturedItemDefinitionCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("manufacturedDoseForm")) {
          this.manufacturedDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("unitOfPresentation")) {
          this.unitOfPresentation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add(TypeConvertor.castToReference(value));
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((ManufacturedItemDefinitionCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1451400348:  return getManufacturedDoseForm();
        case -1427765963:  return getUnitOfPresentation();
        case -1969347631:  return addManufacturer(); 
        case -206409263:  return addIngredient(); 
        case 366313883:  return addCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1451400348: /*manufacturedDoseForm*/ return new String[] {"CodeableConcept"};
        case -1427765963: /*unitOfPresentation*/ return new String[] {"CodeableConcept"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -206409263: /*ingredient*/ return new String[] {"Reference"};
        case 366313883: /*characteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
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
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
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
        dst.manufacturedDoseForm = manufacturedDoseForm == null ? null : manufacturedDoseForm.copy();
        dst.unitOfPresentation = unitOfPresentation == null ? null : unitOfPresentation.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<Reference>();
          for (Reference i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (characteristic != null) {
          dst.characteristic = new ArrayList<ManufacturedItemDefinitionCharacteristicComponent>();
          for (ManufacturedItemDefinitionCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(manufacturedDoseForm, o.manufacturedDoseForm, true)
           && compareDeep(unitOfPresentation, o.unitOfPresentation, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(ingredient, o.ingredient, true) && compareDeep(characteristic, o.characteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ManufacturedItemDefinition))
          return false;
        ManufacturedItemDefinition o = (ManufacturedItemDefinition) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, manufacturedDoseForm
          , unitOfPresentation, manufacturer, ingredient, characteristic);
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


}

