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
 * A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
 */
@ResourceDef(name="NutritionIntake", profile="http://hl7.org/fhir/StructureDefinition/NutritionIntake")
public class NutritionIntake extends DomainResource {

    @Block()
    public static class NutritionIntakeConsumedItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of food or fluid product", formalDefinition="Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/edible-substance-type")
        protected CodeableConcept type;

        /**
         * Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.
         */
        @Child(name = "nutritionProduct", type = {CodeableReference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Code that identifies the food or fluid product that was consumed", formalDefinition="Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/food-type")
        protected CodeableReference nutritionProduct;

        /**
         * Scheduled frequency of consumption.
         */
        @Child(name = "schedule", type = {Timing.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Scheduled frequency of consumption", formalDefinition="Scheduled frequency of consumption." )
        protected Timing schedule;

        /**
         * Quantity of the specified food.
         */
        @Child(name = "amount", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Quantity of the specified food", formalDefinition="Quantity of the specified food." )
        protected Quantity amount;

        /**
         * Rate at which enteral feeding was administered.
         */
        @Child(name = "rate", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rate at which enteral feeding was administered", formalDefinition="Rate at which enteral feeding was administered." )
        protected Quantity rate;

        /**
         * Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.
         */
        @Child(name = "notConsumed", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Flag to indicate if the food or fluid item was refused or otherwise not consumed", formalDefinition="Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used." )
        protected BooleanType notConsumed;

        /**
         * Document the reason the food or fluid was not consumed, such as refused, held, etc.
         */
        @Child(name = "notConsumedReason", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reason food or fluid was not consumed", formalDefinition="Document the reason the food or fluid was not consumed, such as refused, held, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/not-consumed-reason")
        protected CodeableConcept notConsumedReason;

        private static final long serialVersionUID = -1625538068L;

    /**
     * Constructor
     */
      public NutritionIntakeConsumedItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NutritionIntakeConsumedItemComponent(CodeableConcept type, CodeableReference nutritionProduct) {
        super();
        this.setType(type);
        this.setNutritionProduct(nutritionProduct);
      }

        /**
         * @return {@link #type} (Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.)
         */
        public NutritionIntakeConsumedItemComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #nutritionProduct} (Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.)
         */
        public CodeableReference getNutritionProduct() { 
          if (this.nutritionProduct == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.nutritionProduct");
            else if (Configuration.doAutoCreate())
              this.nutritionProduct = new CodeableReference(); // cc
          return this.nutritionProduct;
        }

        public boolean hasNutritionProduct() { 
          return this.nutritionProduct != null && !this.nutritionProduct.isEmpty();
        }

        /**
         * @param value {@link #nutritionProduct} (Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.)
         */
        public NutritionIntakeConsumedItemComponent setNutritionProduct(CodeableReference value) { 
          this.nutritionProduct = value;
          return this;
        }

        /**
         * @return {@link #schedule} (Scheduled frequency of consumption.)
         */
        public Timing getSchedule() { 
          if (this.schedule == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.schedule");
            else if (Configuration.doAutoCreate())
              this.schedule = new Timing(); // cc
          return this.schedule;
        }

        public boolean hasSchedule() { 
          return this.schedule != null && !this.schedule.isEmpty();
        }

        /**
         * @param value {@link #schedule} (Scheduled frequency of consumption.)
         */
        public NutritionIntakeConsumedItemComponent setSchedule(Timing value) { 
          this.schedule = value;
          return this;
        }

        /**
         * @return {@link #amount} (Quantity of the specified food.)
         */
        public Quantity getAmount() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new Quantity(); // cc
          return this.amount;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Quantity of the specified food.)
         */
        public NutritionIntakeConsumedItemComponent setAmount(Quantity value) { 
          this.amount = value;
          return this;
        }

        /**
         * @return {@link #rate} (Rate at which enteral feeding was administered.)
         */
        public Quantity getRate() { 
          if (this.rate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.rate");
            else if (Configuration.doAutoCreate())
              this.rate = new Quantity(); // cc
          return this.rate;
        }

        public boolean hasRate() { 
          return this.rate != null && !this.rate.isEmpty();
        }

        /**
         * @param value {@link #rate} (Rate at which enteral feeding was administered.)
         */
        public NutritionIntakeConsumedItemComponent setRate(Quantity value) { 
          this.rate = value;
          return this;
        }

        /**
         * @return {@link #notConsumed} (Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.). This is the underlying object with id, value and extensions. The accessor "getNotConsumed" gives direct access to the value
         */
        public BooleanType getNotConsumedElement() { 
          if (this.notConsumed == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.notConsumed");
            else if (Configuration.doAutoCreate())
              this.notConsumed = new BooleanType(); // bb
          return this.notConsumed;
        }

        public boolean hasNotConsumedElement() { 
          return this.notConsumed != null && !this.notConsumed.isEmpty();
        }

        public boolean hasNotConsumed() { 
          return this.notConsumed != null && !this.notConsumed.isEmpty();
        }

        /**
         * @param value {@link #notConsumed} (Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.). This is the underlying object with id, value and extensions. The accessor "getNotConsumed" gives direct access to the value
         */
        public NutritionIntakeConsumedItemComponent setNotConsumedElement(BooleanType value) { 
          this.notConsumed = value;
          return this;
        }

        /**
         * @return Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.
         */
        public boolean getNotConsumed() { 
          return this.notConsumed == null || this.notConsumed.isEmpty() ? false : this.notConsumed.getValue();
        }

        /**
         * @param value Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.
         */
        public NutritionIntakeConsumedItemComponent setNotConsumed(boolean value) { 
            if (this.notConsumed == null)
              this.notConsumed = new BooleanType();
            this.notConsumed.setValue(value);
          return this;
        }

        /**
         * @return {@link #notConsumedReason} (Document the reason the food or fluid was not consumed, such as refused, held, etc.)
         */
        public CodeableConcept getNotConsumedReason() { 
          if (this.notConsumedReason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.notConsumedReason");
            else if (Configuration.doAutoCreate())
              this.notConsumedReason = new CodeableConcept(); // cc
          return this.notConsumedReason;
        }

        public boolean hasNotConsumedReason() { 
          return this.notConsumedReason != null && !this.notConsumedReason.isEmpty();
        }

        /**
         * @param value {@link #notConsumedReason} (Document the reason the food or fluid was not consumed, such as refused, held, etc.)
         */
        public NutritionIntakeConsumedItemComponent setNotConsumedReason(CodeableConcept value) { 
          this.notConsumedReason = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.", 0, 1, type));
          children.add(new Property("nutritionProduct", "CodeableReference(NutritionProduct)", "Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.", 0, 1, nutritionProduct));
          children.add(new Property("schedule", "Timing", "Scheduled frequency of consumption.", 0, 1, schedule));
          children.add(new Property("amount", "Quantity", "Quantity of the specified food.", 0, 1, amount));
          children.add(new Property("rate", "Quantity", "Rate at which enteral feeding was administered.", 0, 1, rate));
          children.add(new Property("notConsumed", "boolean", "Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.", 0, 1, notConsumed));
          children.add(new Property("notConsumedReason", "CodeableConcept", "Document the reason the food or fluid was not consumed, such as refused, held, etc.", 0, 1, notConsumedReason));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.", 0, 1, type);
          case -1684132297: /*nutritionProduct*/  return new Property("nutritionProduct", "CodeableReference(NutritionProduct)", "Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.", 0, 1, nutritionProduct);
          case -697920873: /*schedule*/  return new Property("schedule", "Timing", "Scheduled frequency of consumption.", 0, 1, schedule);
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "Quantity of the specified food.", 0, 1, amount);
          case 3493088: /*rate*/  return new Property("rate", "Quantity", "Rate at which enteral feeding was administered.", 0, 1, rate);
          case -148762661: /*notConsumed*/  return new Property("notConsumed", "boolean", "Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.", 0, 1, notConsumed);
          case -440795649: /*notConsumedReason*/  return new Property("notConsumedReason", "CodeableConcept", "Document the reason the food or fluid was not consumed, such as refused, held, etc.", 0, 1, notConsumedReason);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1684132297: /*nutritionProduct*/ return this.nutritionProduct == null ? new Base[0] : new Base[] {this.nutritionProduct}; // CodeableReference
        case -697920873: /*schedule*/ return this.schedule == null ? new Base[0] : new Base[] {this.schedule}; // Timing
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        case 3493088: /*rate*/ return this.rate == null ? new Base[0] : new Base[] {this.rate}; // Quantity
        case -148762661: /*notConsumed*/ return this.notConsumed == null ? new Base[0] : new Base[] {this.notConsumed}; // BooleanType
        case -440795649: /*notConsumedReason*/ return this.notConsumedReason == null ? new Base[0] : new Base[] {this.notConsumedReason}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1684132297: // nutritionProduct
          this.nutritionProduct = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -697920873: // schedule
          this.schedule = TypeConvertor.castToTiming(value); // Timing
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 3493088: // rate
          this.rate = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -148762661: // notConsumed
          this.notConsumed = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -440795649: // notConsumedReason
          this.notConsumedReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("nutritionProduct")) {
          this.nutritionProduct = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("schedule")) {
          this.schedule = TypeConvertor.castToTiming(value); // Timing
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("rate")) {
          this.rate = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("notConsumed")) {
          this.notConsumed = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("notConsumedReason")) {
          this.notConsumedReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1684132297:  return getNutritionProduct();
        case -697920873:  return getSchedule();
        case -1413853096:  return getAmount();
        case 3493088:  return getRate();
        case -148762661:  return getNotConsumedElement();
        case -440795649:  return getNotConsumedReason();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1684132297: /*nutritionProduct*/ return new String[] {"CodeableReference"};
        case -697920873: /*schedule*/ return new String[] {"Timing"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        case 3493088: /*rate*/ return new String[] {"Quantity"};
        case -148762661: /*notConsumed*/ return new String[] {"boolean"};
        case -440795649: /*notConsumedReason*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("nutritionProduct")) {
          this.nutritionProduct = new CodeableReference();
          return this.nutritionProduct;
        }
        else if (name.equals("schedule")) {
          this.schedule = new Timing();
          return this.schedule;
        }
        else if (name.equals("amount")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("rate")) {
          this.rate = new Quantity();
          return this.rate;
        }
        else if (name.equals("notConsumed")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.consumedItem.notConsumed");
        }
        else if (name.equals("notConsumedReason")) {
          this.notConsumedReason = new CodeableConcept();
          return this.notConsumedReason;
        }
        else
          return super.addChild(name);
      }

      public NutritionIntakeConsumedItemComponent copy() {
        NutritionIntakeConsumedItemComponent dst = new NutritionIntakeConsumedItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NutritionIntakeConsumedItemComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.nutritionProduct = nutritionProduct == null ? null : nutritionProduct.copy();
        dst.schedule = schedule == null ? null : schedule.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.rate = rate == null ? null : rate.copy();
        dst.notConsumed = notConsumed == null ? null : notConsumed.copy();
        dst.notConsumedReason = notConsumedReason == null ? null : notConsumedReason.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NutritionIntakeConsumedItemComponent))
          return false;
        NutritionIntakeConsumedItemComponent o = (NutritionIntakeConsumedItemComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(nutritionProduct, o.nutritionProduct, true)
           && compareDeep(schedule, o.schedule, true) && compareDeep(amount, o.amount, true) && compareDeep(rate, o.rate, true)
           && compareDeep(notConsumed, o.notConsumed, true) && compareDeep(notConsumedReason, o.notConsumedReason, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NutritionIntakeConsumedItemComponent))
          return false;
        NutritionIntakeConsumedItemComponent o = (NutritionIntakeConsumedItemComponent) other_;
        return compareValues(notConsumed, o.notConsumed, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, nutritionProduct, schedule
          , amount, rate, notConsumed, notConsumedReason);
      }

  public String fhirType() {
    return "NutritionIntake.consumedItem";

  }

  }

    @Block()
    public static class NutritionIntakeIngredientLabelComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.
         */
        @Child(name = "nutrient", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Total nutrient consumed", formalDefinition="Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/nutrient-code")
        protected CodeableReference nutrient;

        /**
         * Total amount of nutrient consumed.
         */
        @Child(name = "amount", type = {Quantity.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Total amount of nutrient consumed", formalDefinition="Total amount of nutrient consumed." )
        protected Quantity amount;

        private static final long serialVersionUID = -193123424L;

    /**
     * Constructor
     */
      public NutritionIntakeIngredientLabelComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NutritionIntakeIngredientLabelComponent(CodeableReference nutrient, Quantity amount) {
        super();
        this.setNutrient(nutrient);
        this.setAmount(amount);
      }

        /**
         * @return {@link #nutrient} (Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.)
         */
        public CodeableReference getNutrient() { 
          if (this.nutrient == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeIngredientLabelComponent.nutrient");
            else if (Configuration.doAutoCreate())
              this.nutrient = new CodeableReference(); // cc
          return this.nutrient;
        }

        public boolean hasNutrient() { 
          return this.nutrient != null && !this.nutrient.isEmpty();
        }

        /**
         * @param value {@link #nutrient} (Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.)
         */
        public NutritionIntakeIngredientLabelComponent setNutrient(CodeableReference value) { 
          this.nutrient = value;
          return this;
        }

        /**
         * @return {@link #amount} (Total amount of nutrient consumed.)
         */
        public Quantity getAmount() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeIngredientLabelComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new Quantity(); // cc
          return this.amount;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Total amount of nutrient consumed.)
         */
        public NutritionIntakeIngredientLabelComponent setAmount(Quantity value) { 
          this.amount = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("nutrient", "CodeableReference(Substance)", "Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.", 0, 1, nutrient));
          children.add(new Property("amount", "Quantity", "Total amount of nutrient consumed.", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1671151641: /*nutrient*/  return new Property("nutrient", "CodeableReference(Substance)", "Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.", 0, 1, nutrient);
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "Total amount of nutrient consumed.", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1671151641: /*nutrient*/ return this.nutrient == null ? new Base[0] : new Base[] {this.nutrient}; // CodeableReference
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1671151641: // nutrient
          this.nutrient = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("nutrient")) {
          this.nutrient = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1671151641:  return getNutrient();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1671151641: /*nutrient*/ return new String[] {"CodeableReference"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("nutrient")) {
          this.nutrient = new CodeableReference();
          return this.nutrient;
        }
        else if (name.equals("amount")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

      public NutritionIntakeIngredientLabelComponent copy() {
        NutritionIntakeIngredientLabelComponent dst = new NutritionIntakeIngredientLabelComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NutritionIntakeIngredientLabelComponent dst) {
        super.copyValues(dst);
        dst.nutrient = nutrient == null ? null : nutrient.copy();
        dst.amount = amount == null ? null : amount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NutritionIntakeIngredientLabelComponent))
          return false;
        NutritionIntakeIngredientLabelComponent o = (NutritionIntakeIngredientLabelComponent) other_;
        return compareDeep(nutrient, o.nutrient, true) && compareDeep(amount, o.amount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NutritionIntakeIngredientLabelComponent))
          return false;
        NutritionIntakeIngredientLabelComponent o = (NutritionIntakeIngredientLabelComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(nutrient, amount);
      }

  public String fhirType() {
    return "NutritionIntake.ingredientLabel";

  }

  }

    @Block()
    public static class NutritionIntakePerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Type of performer.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of performer", formalDefinition="Type of performer." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/performer-role")
        protected CodeableConcept function;

        /**
         * Who performed the intake.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who performed the intake", formalDefinition="Who performed the intake." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public NutritionIntakePerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NutritionIntakePerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Type of performer.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakePerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Type of performer.)
         */
        public NutritionIntakePerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Who performed the intake.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakePerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Who performed the intake.)
         */
        public NutritionIntakePerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Type of performer.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Who performed the intake.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Type of performer.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Who performed the intake.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public NutritionIntakePerformerComponent copy() {
        NutritionIntakePerformerComponent dst = new NutritionIntakePerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NutritionIntakePerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NutritionIntakePerformerComponent))
          return false;
        NutritionIntakePerformerComponent o = (NutritionIntakePerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NutritionIntakePerformerComponent))
          return false;
        NutritionIntakePerformerComponent o = (NutritionIntakePerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "NutritionIntake.performer";

  }

  }

    /**
     * Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifier", formalDefinition="Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * Instantiates FHIR protocol or definition.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="Instantiates FHIR protocol or definition." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * Instantiates external protocol or definition.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="Instantiates external protocol or definition." )
    protected List<UriType> instantiatesUri;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this event.
     */
    @Child(name = "basedOn", type = {NutritionOrder.class, CarePlan.class, ServiceRequest.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfils plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular event is a component or step.
     */
    @Child(name = "partOf", type = {NutritionIntake.class, Procedure.class, Observation.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular event is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown", formalDefinition="A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/event-status")
    protected Enumeration<EventStatus> status;

    /**
     * Captures the reason for the current state of the NutritionIntake.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the NutritionIntake." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reason-medication-status-codes")
    protected List<CodeableConcept> statusReason;

    /**
     * Type of nutrition intake setting/reporting.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of nutrition intake setting/reporting", formalDefinition="Type of nutrition intake setting/reporting." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/diet-type")
    protected CodeableConcept code;

    /**
     * The person, animal or group who is/was consuming the food or fluid.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is/was consuming the food or fluid", formalDefinition="The person, animal or group who is/was consuming the food or fluid." )
    protected Reference subject;

    /**
     * The encounter that establishes the context for this NutritionIntake.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter associated with NutritionIntake", formalDefinition="The encounter that establishes the context for this NutritionIntake." )
    protected Reference encounter;

    /**
     * The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date/time or interval when the food or fluid is/was consumed", formalDefinition="The interval of time during which it is being asserted that the patient is/was consuming the food or fluid." )
    protected DataType occurrence;

    /**
     * The date when the Nutrition Intake was asserted by the information source.
     */
    @Child(name = "recorded", type = {DateTimeType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the intake was recorded", formalDefinition="The date when the Nutrition Intake was asserted by the information source." )
    protected DateTimeType recorded;

    /**
     * The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.
     */
    @Child(name = "reported", type = {BooleanType.class, Patient.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class, Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Person or organization that provided the information about the consumption of this food or fluid", formalDefinition="The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources." )
    protected DataType reported;

    /**
     * What food or fluid product or item was consumed.
     */
    @Child(name = "consumedItem", type = {}, order=13, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What food or fluid product or item was consumed", formalDefinition="What food or fluid product or item was consumed." )
    protected List<NutritionIntakeConsumedItemComponent> consumedItem;

    /**
     * Total nutrient amounts for the whole meal, product, serving, etc.
     */
    @Child(name = "ingredientLabel", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Total nutrient for the whole meal, product, serving", formalDefinition="Total nutrient amounts for the whole meal, product, serving, etc." )
    protected List<NutritionIntakeIngredientLabelComponent> ingredientLabel;

    /**
     * Who performed the intake and how they were involved.
     */
    @Child(name = "performer", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who was performed in the intake", formalDefinition="Who performed the intake and how they were involved." )
    protected List<NutritionIntakePerformerComponent> performer;

    /**
     * Where the intake occurred.
     */
    @Child(name = "location", type = {Location.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the intake occurred", formalDefinition="Where the intake occurred." )
    protected Reference location;

    /**
     * Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.
     */
    @Child(name = "derivedFrom", type = {Reference.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional supporting information", formalDefinition="Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake." )
    protected List<Reference> derivedFrom;

    /**
     * A reason, Condition or observation for why the food or fluid is /was consumed.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for why the food or fluid is /was consumed", formalDefinition="A reason, Condition or observation for why the food or fluid is /was consumed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableReference> reason;

    /**
     * Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Further information about the consumption", formalDefinition="Provides extra information about the Nutrition Intake that is not conveyed by the other attributes." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 890692162L;

  /**
   * Constructor
   */
    public NutritionIntake() {
      super();
    }

  /**
   * Constructor
   */
    public NutritionIntake(EventStatus status, Reference subject, NutritionIntakeConsumedItemComponent consumedItem) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
      this.addConsumedItem(consumedItem);
    }

    /**
     * @return {@link #identifier} (Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setIdentifier(List<Identifier> theIdentifier) { 
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

    public NutritionIntake addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (Instantiates FHIR protocol or definition.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
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
     * @return {@link #instantiatesCanonical} (Instantiates FHIR protocol or definition.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (Instantiates FHIR protocol or definition.)
     */
    public NutritionIntake addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (Instantiates FHIR protocol or definition.)
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
     * @return {@link #instantiatesUri} (Instantiates external protocol or definition.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setInstantiatesUri(List<UriType> theInstantiatesUri) { 
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
     * @return {@link #instantiatesUri} (Instantiates external protocol or definition.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (Instantiates external protocol or definition.)
     */
    public NutritionIntake addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (Instantiates external protocol or definition.)
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
    public NutritionIntake setBasedOn(List<Reference> theBasedOn) { 
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

    public NutritionIntake addBasedOn(Reference t) { //3
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
    public NutritionIntake setPartOf(List<Reference> thePartOf) { 
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

    public NutritionIntake addPartOf(Reference t) { //3
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
     * @return {@link #status} (A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EventStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public NutritionIntake setStatusElement(Enumeration<EventStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    public EventStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    public NutritionIntake setStatus(EventStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the NutritionIntake.)
     */
    public List<CodeableConcept> getStatusReason() { 
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      return this.statusReason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setStatusReason(List<CodeableConcept> theStatusReason) { 
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

    public NutritionIntake addStatusReason(CodeableConcept t) { //3
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
     * @return {@link #code} (Type of nutrition intake setting/reporting.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Type of nutrition intake setting/reporting.)
     */
    public NutritionIntake setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The person, animal or group who is/was consuming the food or fluid.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The person, animal or group who is/was consuming the food or fluid.)
     */
    public NutritionIntake setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter that establishes the context for this NutritionIntake.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter that establishes the context for this NutritionIntake.)
     */
    public NutritionIntake setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
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
     * @return {@link #occurrence} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
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

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public NutritionIntake setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for NutritionIntake.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #recorded} (The date when the Nutrition Intake was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public DateTimeType getRecordedElement() { 
      if (this.recorded == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.recorded");
        else if (Configuration.doAutoCreate())
          this.recorded = new DateTimeType(); // bb
      return this.recorded;
    }

    public boolean hasRecordedElement() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    public boolean hasRecorded() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    /**
     * @param value {@link #recorded} (The date when the Nutrition Intake was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public NutritionIntake setRecordedElement(DateTimeType value) { 
      this.recorded = value;
      return this;
    }

    /**
     * @return The date when the Nutrition Intake was asserted by the information source.
     */
    public Date getRecorded() { 
      return this.recorded == null ? null : this.recorded.getValue();
    }

    /**
     * @param value The date when the Nutrition Intake was asserted by the information source.
     */
    public NutritionIntake setRecorded(Date value) { 
      if (value == null)
        this.recorded = null;
      else {
        if (this.recorded == null)
          this.recorded = new DateTimeType();
        this.recorded.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #reported} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public DataType getReported() { 
      return this.reported;
    }

    /**
     * @return {@link #reported} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public BooleanType getReportedBooleanType() throws FHIRException { 
      if (this.reported == null)
        this.reported = new BooleanType();
      if (!(this.reported instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.reported.getClass().getName()+" was encountered");
      return (BooleanType) this.reported;
    }

    public boolean hasReportedBooleanType() { 
      return this != null && this.reported instanceof BooleanType;
    }

    /**
     * @return {@link #reported} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public Reference getReportedReference() throws FHIRException { 
      if (this.reported == null)
        this.reported = new Reference();
      if (!(this.reported instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.reported.getClass().getName()+" was encountered");
      return (Reference) this.reported;
    }

    public boolean hasReportedReference() { 
      return this != null && this.reported instanceof Reference;
    }

    public boolean hasReported() { 
      return this.reported != null && !this.reported.isEmpty();
    }

    /**
     * @param value {@link #reported} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public NutritionIntake setReported(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof Reference))
        throw new Error("Not the right type for NutritionIntake.reported[x]: "+value.fhirType());
      this.reported = value;
      return this;
    }

    /**
     * @return {@link #consumedItem} (What food or fluid product or item was consumed.)
     */
    public List<NutritionIntakeConsumedItemComponent> getConsumedItem() { 
      if (this.consumedItem == null)
        this.consumedItem = new ArrayList<NutritionIntakeConsumedItemComponent>();
      return this.consumedItem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setConsumedItem(List<NutritionIntakeConsumedItemComponent> theConsumedItem) { 
      this.consumedItem = theConsumedItem;
      return this;
    }

    public boolean hasConsumedItem() { 
      if (this.consumedItem == null)
        return false;
      for (NutritionIntakeConsumedItemComponent item : this.consumedItem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public NutritionIntakeConsumedItemComponent addConsumedItem() { //3
      NutritionIntakeConsumedItemComponent t = new NutritionIntakeConsumedItemComponent();
      if (this.consumedItem == null)
        this.consumedItem = new ArrayList<NutritionIntakeConsumedItemComponent>();
      this.consumedItem.add(t);
      return t;
    }

    public NutritionIntake addConsumedItem(NutritionIntakeConsumedItemComponent t) { //3
      if (t == null)
        return this;
      if (this.consumedItem == null)
        this.consumedItem = new ArrayList<NutritionIntakeConsumedItemComponent>();
      this.consumedItem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #consumedItem}, creating it if it does not already exist {3}
     */
    public NutritionIntakeConsumedItemComponent getConsumedItemFirstRep() { 
      if (getConsumedItem().isEmpty()) {
        addConsumedItem();
      }
      return getConsumedItem().get(0);
    }

    /**
     * @return {@link #ingredientLabel} (Total nutrient amounts for the whole meal, product, serving, etc.)
     */
    public List<NutritionIntakeIngredientLabelComponent> getIngredientLabel() { 
      if (this.ingredientLabel == null)
        this.ingredientLabel = new ArrayList<NutritionIntakeIngredientLabelComponent>();
      return this.ingredientLabel;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setIngredientLabel(List<NutritionIntakeIngredientLabelComponent> theIngredientLabel) { 
      this.ingredientLabel = theIngredientLabel;
      return this;
    }

    public boolean hasIngredientLabel() { 
      if (this.ingredientLabel == null)
        return false;
      for (NutritionIntakeIngredientLabelComponent item : this.ingredientLabel)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public NutritionIntakeIngredientLabelComponent addIngredientLabel() { //3
      NutritionIntakeIngredientLabelComponent t = new NutritionIntakeIngredientLabelComponent();
      if (this.ingredientLabel == null)
        this.ingredientLabel = new ArrayList<NutritionIntakeIngredientLabelComponent>();
      this.ingredientLabel.add(t);
      return t;
    }

    public NutritionIntake addIngredientLabel(NutritionIntakeIngredientLabelComponent t) { //3
      if (t == null)
        return this;
      if (this.ingredientLabel == null)
        this.ingredientLabel = new ArrayList<NutritionIntakeIngredientLabelComponent>();
      this.ingredientLabel.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredientLabel}, creating it if it does not already exist {3}
     */
    public NutritionIntakeIngredientLabelComponent getIngredientLabelFirstRep() { 
      if (getIngredientLabel().isEmpty()) {
        addIngredientLabel();
      }
      return getIngredientLabel().get(0);
    }

    /**
     * @return {@link #performer} (Who performed the intake and how they were involved.)
     */
    public List<NutritionIntakePerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<NutritionIntakePerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setPerformer(List<NutritionIntakePerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (NutritionIntakePerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public NutritionIntakePerformerComponent addPerformer() { //3
      NutritionIntakePerformerComponent t = new NutritionIntakePerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<NutritionIntakePerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public NutritionIntake addPerformer(NutritionIntakePerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<NutritionIntakePerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public NutritionIntakePerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #location} (Where the intake occurred.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (Where the intake occurred.)
     */
    public NutritionIntake setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #derivedFrom} (Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.)
     */
    public List<Reference> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setDerivedFrom(List<Reference> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (Reference item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDerivedFrom() { //3
      Reference t = new Reference();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return t;
    }

    public NutritionIntake addDerivedFrom(Reference t) { //3
      if (t == null)
        return this;
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #derivedFrom}, creating it if it does not already exist {3}
     */
    public Reference getDerivedFromFirstRep() { 
      if (getDerivedFrom().isEmpty()) {
        addDerivedFrom();
      }
      return getDerivedFrom().get(0);
    }

    /**
     * @return {@link #reason} (A reason, Condition or observation for why the food or fluid is /was consumed.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setReason(List<CodeableReference> theReason) { 
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

    public NutritionIntake addReason(CodeableReference t) { //3
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
     * @return {@link #note} (Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setNote(List<Annotation> theNote) { 
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

    public NutritionIntake addNote(Annotation t) { //3
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
        children.add(new Property("identifier", "Identifier", "Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(ActivityDefinition|EventDefinition|EvidenceVariable|Measure|OperationDefinition|PlanDefinition|Questionnaire|SubscriptionTopic)", "Instantiates FHIR protocol or definition.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "Instantiates external protocol or definition.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(NutritionOrder|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(NutritionIntake|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, statusReason));
        children.add(new Property("code", "CodeableConcept", "Type of nutrition intake setting/reporting.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was consuming the food or fluid.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this NutritionIntake.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, occurrence));
        children.add(new Property("recorded", "dateTime", "The date when the Nutrition Intake was asserted by the information source.", 0, 1, recorded));
        children.add(new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, reported));
        children.add(new Property("consumedItem", "", "What food or fluid product or item was consumed.", 0, java.lang.Integer.MAX_VALUE, consumedItem));
        children.add(new Property("ingredientLabel", "", "Total nutrient amounts for the whole meal, product, serving, etc.", 0, java.lang.Integer.MAX_VALUE, ingredientLabel));
        children.add(new Property("performer", "", "Who performed the intake and how they were involved.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "Reference(Location)", "Where the intake occurred.", 0, 1, location));
        children.add(new Property("derivedFrom", "Reference(Any)", "Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "A reason, Condition or observation for why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(ActivityDefinition|EventDefinition|EvidenceVariable|Measure|OperationDefinition|PlanDefinition|Questionnaire|SubscriptionTopic)", "Instantiates FHIR protocol or definition.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "Instantiates external protocol or definition.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(NutritionOrder|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(NutritionIntake|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, statusReason);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Type of nutrition intake setting/reporting.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was consuming the food or fluid.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this NutritionIntake.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, occurrence);
        case -799233872: /*recorded*/  return new Property("recorded", "dateTime", "The date when the Nutrition Intake was asserted by the information source.", 0, 1, recorded);
        case -241505587: /*reported[x]*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, reported);
        case -427039533: /*reported*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, reported);
        case 1219992533: /*reportedBoolean*/  return new Property("reported[x]", "boolean", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, reported);
        case 1198143416: /*reportedReference*/  return new Property("reported[x]", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, reported);
        case -854114533: /*consumedItem*/  return new Property("consumedItem", "", "What food or fluid product or item was consumed.", 0, java.lang.Integer.MAX_VALUE, consumedItem);
        case -936536157: /*ingredientLabel*/  return new Property("ingredientLabel", "", "Total nutrient amounts for the whole meal, product, serving, etc.", 0, java.lang.Integer.MAX_VALUE, ingredientLabel);
        case 481140686: /*performer*/  return new Property("performer", "", "Who performed the intake and how they were involved.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Where the intake occurred.", 0, 1, location);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(Any)", "Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "A reason, Condition or observation for why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
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
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EventStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : this.statusReason.toArray(new Base[this.statusReason.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -799233872: /*recorded*/ return this.recorded == null ? new Base[0] : new Base[] {this.recorded}; // DateTimeType
        case -427039533: /*reported*/ return this.reported == null ? new Base[0] : new Base[] {this.reported}; // DataType
        case -854114533: /*consumedItem*/ return this.consumedItem == null ? new Base[0] : this.consumedItem.toArray(new Base[this.consumedItem.size()]); // NutritionIntakeConsumedItemComponent
        case -936536157: /*ingredientLabel*/ return this.ingredientLabel == null ? new Base[0] : this.ingredientLabel.toArray(new Base[this.ingredientLabel.size()]); // NutritionIntakeIngredientLabelComponent
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // NutritionIntakePerformerComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
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
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
          return value;
        case 2051346646: // statusReason
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
        case -799233872: // recorded
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -427039533: // reported
          this.reported = TypeConvertor.castToType(value); // DataType
          return value;
        case -854114533: // consumedItem
          this.getConsumedItem().add((NutritionIntakeConsumedItemComponent) value); // NutritionIntakeConsumedItemComponent
          return value;
        case -936536157: // ingredientLabel
          this.getIngredientLabel().add((NutritionIntakeIngredientLabelComponent) value); // NutritionIntakeIngredientLabelComponent
          return value;
        case 481140686: // performer
          this.getPerformer().add((NutritionIntakePerformerComponent) value); // NutritionIntakePerformerComponent
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
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
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
        } else if (name.equals("statusReason")) {
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("recorded")) {
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("reported[x]")) {
          this.reported = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("consumedItem")) {
          this.getConsumedItem().add((NutritionIntakeConsumedItemComponent) value);
        } else if (name.equals("ingredientLabel")) {
          this.getIngredientLabel().add((NutritionIntakeIngredientLabelComponent) value);
        } else if (name.equals("performer")) {
          this.getPerformer().add((NutritionIntakePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
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
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return addStatusReason(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -799233872:  return getRecordedElement();
        case -241505587:  return getReported();
        case -427039533:  return getReported();
        case -854114533:  return addConsumedItem(); 
        case -936536157:  return addIngredientLabel(); 
        case 481140686:  return addPerformer(); 
        case 1901043637:  return getLocation();
        case 1077922663:  return addDerivedFrom(); 
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
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
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period"};
        case -799233872: /*recorded*/ return new String[] {"dateTime"};
        case -427039533: /*reported*/ return new String[] {"boolean", "Reference"};
        case -854114533: /*consumedItem*/ return new String[] {};
        case -936536157: /*ingredientLabel*/ return new String[] {};
        case 481140686: /*performer*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.status");
        }
        else if (name.equals("statusReason")) {
          return addStatusReason();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
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
        else if (name.equals("recorded")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.recorded");
        }
        else if (name.equals("reportedBoolean")) {
          this.reported = new BooleanType();
          return this.reported;
        }
        else if (name.equals("reportedReference")) {
          this.reported = new Reference();
          return this.reported;
        }
        else if (name.equals("consumedItem")) {
          return addConsumedItem();
        }
        else if (name.equals("ingredientLabel")) {
          return addIngredientLabel();
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "NutritionIntake";

  }

      public NutritionIntake copy() {
        NutritionIntake dst = new NutritionIntake();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NutritionIntake dst) {
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
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (statusReason != null) {
          dst.statusReason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : statusReason)
            dst.statusReason.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.recorded = recorded == null ? null : recorded.copy();
        dst.reported = reported == null ? null : reported.copy();
        if (consumedItem != null) {
          dst.consumedItem = new ArrayList<NutritionIntakeConsumedItemComponent>();
          for (NutritionIntakeConsumedItemComponent i : consumedItem)
            dst.consumedItem.add(i.copy());
        };
        if (ingredientLabel != null) {
          dst.ingredientLabel = new ArrayList<NutritionIntakeIngredientLabelComponent>();
          for (NutritionIntakeIngredientLabelComponent i : ingredientLabel)
            dst.ingredientLabel.add(i.copy());
        };
        if (performer != null) {
          dst.performer = new ArrayList<NutritionIntakePerformerComponent>();
          for (NutritionIntakePerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected NutritionIntake typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NutritionIntake))
          return false;
        NutritionIntake o = (NutritionIntake) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(partOf, o.partOf, true) && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
           && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(occurrence, o.occurrence, true) && compareDeep(recorded, o.recorded, true) && compareDeep(reported, o.reported, true)
           && compareDeep(consumedItem, o.consumedItem, true) && compareDeep(ingredientLabel, o.ingredientLabel, true)
           && compareDeep(performer, o.performer, true) && compareDeep(location, o.location, true) && compareDeep(derivedFrom, o.derivedFrom, true)
           && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NutritionIntake))
          return false;
        NutritionIntake o = (NutritionIntake) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(recorded, o.recorded, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, partOf, status, statusReason, code, subject, encounter
          , occurrence, recorded, reported, consumedItem, ingredientLabel, performer, location
          , derivedFrom, reason, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.NutritionIntake;
   }

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Returns statements of this code of NutritionIntake</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="NutritionIntake.code", description="Returns statements of this code of NutritionIntake", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Returns statements of this code of NutritionIntake</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NutritionIntake.occurrence</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="NutritionIntake.occurrence", description="Date when patient was taking (or not taking) the medication", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NutritionIntake.occurrence</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Returns statements for a specific encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="NutritionIntake.encounter", description="Returns statements for a specific encounter", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Returns statements for a specific encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("NutritionIntake:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Return statements with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="NutritionIntake.identifier", description="Return statements with this external identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Return statements with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>nutrition</b>
   * <p>
   * Description: <b>Return statements of this medication reference</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.consumedItem.nutritionProduct</b><br>
   * </p>
   */
  @SearchParamDefinition(name="nutrition", path="NutritionIntake.consumedItem.nutritionProduct", description="Return statements of this medication reference", type="token" )
  public static final String SP_NUTRITION = "nutrition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>nutrition</b>
   * <p>
   * Description: <b>Return statements of this medication reference</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.consumedItem.nutritionProduct</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam NUTRITION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_NUTRITION);

 /**
   * Search parameter: <b>part-of</b>
   * <p>
   * Description: <b>Returns statements that are part of another event.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-of", path="NutritionIntake.partOf", description="Returns statements that are part of another event.", type="reference", target={NutritionIntake.class, Observation.class, Procedure.class } )
  public static final String SP_PART_OF = "part-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-of</b>
   * <p>
   * Description: <b>Returns statements that are part of another event.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PART_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PART_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:part-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PART_OF = new ca.uhn.fhir.model.api.Include("NutritionIntake:part-of").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Returns statements for a specific patient.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="NutritionIntake.subject.where(resolve() is Patient)", description="Returns statements for a specific patient.", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Returns statements for a specific patient.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("NutritionIntake:patient").toLocked();

 /**
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(NutritionIntake.reported as Reference)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source", path="(NutritionIntake.reported as Reference)", description="Who or where the information in the statement came from", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SOURCE = "source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(NutritionIntake.reported as Reference)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include("NutritionIntake:source").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Return statements that match the given status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="NutritionIntake.status", description="Return statements that match the given status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Return statements that match the given status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient, animal or group to list statements for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="NutritionIntake.subject", description="The identity of a patient, animal or group to list statements for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient, animal or group to list statements for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("NutritionIntake:subject").toLocked();


}