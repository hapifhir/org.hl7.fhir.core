package org.hl7.fhir.r5.model;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;

import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.utilities.Utilities;
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

    public enum NutritionIntakeStatus {
        /**
         * The nutrition is still being taken.
         */
        ACTIVE, 
        /**
         * The nutrition is no longer being taken.
         */
        COMPLETED, 
        /**
         * Some of the actions that are implied by the nutrition usage may have occurred.  For example, the patient may have taken some of the nutrition.  Clinical decision support systems should take this status into account.
         */
        ENTEREDINERROR, 
        /**
         * The nutrition may be taken at some time in the future.
         */
        INTENDED, 
        /**
         * Actions implied by the usage have been permanently halted, before all of them occurred. This should not be used if the statement was entered in error.
         */
        STOPPED, 
        /**
         * Actions implied by the usage have been temporarily halted, but are expected to continue later. May also be called 'suspended'.
         */
        ONHOLD, 
        /**
         * The state of the nutrition use is not currently known.
         */
        UNKNOWN, 
        /**
         * The nutrition was not consumed by the patient
         */
        NOTTAKEN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static NutritionIntakeStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("intended".equals(codeString))
          return INTENDED;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("not-taken".equals(codeString))
          return NOTTAKEN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown NutritionIntakeStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case INTENDED: return "intended";
            case STOPPED: return "stopped";
            case ONHOLD: return "on-hold";
            case UNKNOWN: return "unknown";
            case NOTTAKEN: return "not-taken";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case COMPLETED: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case INTENDED: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case STOPPED: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case ONHOLD: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case UNKNOWN: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            case NOTTAKEN: return "http://hl7.org/fhir/CodeSystem/nutrition-intake-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The nutrition is still being taken.";
            case COMPLETED: return "The nutrition is no longer being taken.";
            case ENTEREDINERROR: return "Some of the actions that are implied by the nutrition usage may have occurred.  For example, the patient may have taken some of the nutrition.  Clinical decision support systems should take this status into account.";
            case INTENDED: return "The nutrition may be taken at some time in the future.";
            case STOPPED: return "Actions implied by the usage have been permanently halted, before all of them occurred. This should not be used if the statement was entered in error.";
            case ONHOLD: return "Actions implied by the usage have been temporarily halted, but are expected to continue later. May also be called 'suspended'.";
            case UNKNOWN: return "The state of the nutrition use is not currently known.";
            case NOTTAKEN: return "The nutrition was not consumed by the patient";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case INTENDED: return "Intended";
            case STOPPED: return "Stopped";
            case ONHOLD: return "On Hold";
            case UNKNOWN: return "Unknown";
            case NOTTAKEN: return "Not Taken";
            default: return "?";
          }
        }
    }

  public static class NutritionIntakeStatusEnumFactory implements EnumFactory<NutritionIntakeStatus> {
    public NutritionIntakeStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return NutritionIntakeStatus.ACTIVE;
        if ("completed".equals(codeString))
          return NutritionIntakeStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return NutritionIntakeStatus.ENTEREDINERROR;
        if ("intended".equals(codeString))
          return NutritionIntakeStatus.INTENDED;
        if ("stopped".equals(codeString))
          return NutritionIntakeStatus.STOPPED;
        if ("on-hold".equals(codeString))
          return NutritionIntakeStatus.ONHOLD;
        if ("unknown".equals(codeString))
          return NutritionIntakeStatus.UNKNOWN;
        if ("not-taken".equals(codeString))
          return NutritionIntakeStatus.NOTTAKEN;
        throw new IllegalArgumentException("Unknown NutritionIntakeStatus code '"+codeString+"'");
        }
        public Enumeration<NutritionIntakeStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NutritionIntakeStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.ACTIVE);
        if ("completed".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.ENTEREDINERROR);
        if ("intended".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.INTENDED);
        if ("stopped".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.STOPPED);
        if ("on-hold".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.ONHOLD);
        if ("unknown".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.UNKNOWN);
        if ("not-taken".equals(codeString))
          return new Enumeration<NutritionIntakeStatus>(this, NutritionIntakeStatus.NOTTAKEN);
        throw new FHIRException("Unknown NutritionIntakeStatus code '"+codeString+"'");
        }
    public String toCode(NutritionIntakeStatus code) {
      if (code == NutritionIntakeStatus.ACTIVE)
        return "active";
      if (code == NutritionIntakeStatus.COMPLETED)
        return "completed";
      if (code == NutritionIntakeStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == NutritionIntakeStatus.INTENDED)
        return "intended";
      if (code == NutritionIntakeStatus.STOPPED)
        return "stopped";
      if (code == NutritionIntakeStatus.ONHOLD)
        return "on-hold";
      if (code == NutritionIntakeStatus.UNKNOWN)
        return "unknown";
      if (code == NutritionIntakeStatus.NOTTAKEN)
        return "not-taken";
      return "?";
      }
    public String toSystem(NutritionIntakeStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class NutritionIntakeConsumedItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of food or fluid product", formalDefinition="Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc." )
        protected CodeableConcept type;

        /**
         * Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.
         */
        @Child(name = "nutritionProduct", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Code that identifies the food or fluid product that was consumed", formalDefinition="Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods." )
        protected CodeableConcept nutritionProduct;

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
        protected CodeableConcept notConsumedReason;

        private static final long serialVersionUID = -608839799L;

    /**
     * Constructor
     */
      public NutritionIntakeConsumedItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NutritionIntakeConsumedItemComponent(CodeableConcept type, CodeableConcept nutritionProduct) {
        super();
        this.type = type;
        this.nutritionProduct = nutritionProduct;
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
        public CodeableConcept getNutritionProduct() { 
          if (this.nutritionProduct == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeConsumedItemComponent.nutritionProduct");
            else if (Configuration.doAutoCreate())
              this.nutritionProduct = new CodeableConcept(); // cc
          return this.nutritionProduct;
        }

        public boolean hasNutritionProduct() { 
          return this.nutritionProduct != null && !this.nutritionProduct.isEmpty();
        }

        /**
         * @param value {@link #nutritionProduct} (Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.)
         */
        public NutritionIntakeConsumedItemComponent setNutritionProduct(CodeableConcept value) { 
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
          children.add(new Property("nutritionProduct", "CodeableConcept", "Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.", 0, 1, nutritionProduct));
          children.add(new Property("schedule", "Timing", "Scheduled frequency of consumption.", 0, 1, schedule));
          children.add(new Property("amount", "SimpleQuantity", "Quantity of the specified food.", 0, 1, amount));
          children.add(new Property("rate", "SimpleQuantity", "Rate at which enteral feeding was administered.", 0, 1, rate));
          children.add(new Property("notConsumed", "boolean", "Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.", 0, 1, notConsumed));
          children.add(new Property("notConsumedReason", "CodeableConcept", "Document the reason the food or fluid was not consumed, such as refused, held, etc.", 0, 1, notConsumedReason));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates what a category of item that was consumed: eg., food, fluid, enteral, etc.", 0, 1, type);
          case -1684132297: /*nutritionProduct*/  return new Property("nutritionProduct", "CodeableConcept", "Identifies the food or fluid product that was consumed. This is potentially a link to a resource representing the details of the food product (TBD) or a simple attribute carrying a code that identifies the food from a known list of foods.", 0, 1, nutritionProduct);
          case -697920873: /*schedule*/  return new Property("schedule", "Timing", "Scheduled frequency of consumption.", 0, 1, schedule);
          case -1413853096: /*amount*/  return new Property("amount", "SimpleQuantity", "Quantity of the specified food.", 0, 1, amount);
          case 3493088: /*rate*/  return new Property("rate", "SimpleQuantity", "Rate at which enteral feeding was administered.", 0, 1, rate);
          case -148762661: /*notConsumed*/  return new Property("notConsumed", "boolean", "Indicator when a patient is in a setting where it is helpful to know if food was not consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely not be used.", 0, 1, notConsumed);
          case -440795649: /*notConsumedReason*/  return new Property("notConsumedReason", "CodeableConcept", "Document the reason the food or fluid was not consumed, such as refused, held, etc.", 0, 1, notConsumedReason);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1684132297: /*nutritionProduct*/ return this.nutritionProduct == null ? new Base[0] : new Base[] {this.nutritionProduct}; // CodeableConcept
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
          this.type = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1684132297: // nutritionProduct
          this.nutritionProduct = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -697920873: // schedule
          this.schedule = castToTiming(value); // Timing
          return value;
        case -1413853096: // amount
          this.amount = castToQuantity(value); // Quantity
          return value;
        case 3493088: // rate
          this.rate = castToQuantity(value); // Quantity
          return value;
        case -148762661: // notConsumed
          this.notConsumed = castToBoolean(value); // BooleanType
          return value;
        case -440795649: // notConsumedReason
          this.notConsumedReason = castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("nutritionProduct")) {
          this.nutritionProduct = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("schedule")) {
          this.schedule = castToTiming(value); // Timing
        } else if (name.equals("amount")) {
          this.amount = castToQuantity(value); // Quantity
        } else if (name.equals("rate")) {
          this.rate = castToQuantity(value); // Quantity
        } else if (name.equals("notConsumed")) {
          this.notConsumed = castToBoolean(value); // BooleanType
        } else if (name.equals("notConsumedReason")) {
          this.notConsumedReason = castToCodeableConcept(value); // CodeableConcept
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
        case -1684132297: /*nutritionProduct*/ return new String[] {"CodeableConcept"};
        case -697920873: /*schedule*/ return new String[] {"Timing"};
        case -1413853096: /*amount*/ return new String[] {"SimpleQuantity"};
        case 3493088: /*rate*/ return new String[] {"SimpleQuantity"};
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
          this.nutritionProduct = new CodeableConcept();
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
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.notConsumed");
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
        @Child(name = "nutrient", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Total nutrient consumed", formalDefinition="Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral." )
        protected CodeableConcept nutrient;

        /**
         * Total amount of nutrient consumed.
         */
        @Child(name = "amount", type = {Quantity.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Total amount of nutrient consumed", formalDefinition="Total amount of nutrient consumed." )
        protected Quantity amount;

        private static final long serialVersionUID = -1026365827L;

    /**
     * Constructor
     */
      public NutritionIntakeIngredientLabelComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NutritionIntakeIngredientLabelComponent(CodeableConcept nutrient, Quantity amount) {
        super();
        this.nutrient = nutrient;
        this.amount = amount;
      }

        /**
         * @return {@link #nutrient} (Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.)
         */
        public CodeableConcept getNutrient() { 
          if (this.nutrient == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NutritionIntakeIngredientLabelComponent.nutrient");
            else if (Configuration.doAutoCreate())
              this.nutrient = new CodeableConcept(); // cc
          return this.nutrient;
        }

        public boolean hasNutrient() { 
          return this.nutrient != null && !this.nutrient.isEmpty();
        }

        /**
         * @param value {@link #nutrient} (Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.)
         */
        public NutritionIntakeIngredientLabelComponent setNutrient(CodeableConcept value) { 
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
          children.add(new Property("nutrient", "CodeableConcept", "Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.", 0, 1, nutrient));
          children.add(new Property("amount", "SimpleQuantity", "Total amount of nutrient consumed.", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1671151641: /*nutrient*/  return new Property("nutrient", "CodeableConcept", "Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a vitamin and mineral.", 0, 1, nutrient);
          case -1413853096: /*amount*/  return new Property("amount", "SimpleQuantity", "Total amount of nutrient consumed.", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1671151641: /*nutrient*/ return this.nutrient == null ? new Base[0] : new Base[] {this.nutrient}; // CodeableConcept
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1671151641: // nutrient
          this.nutrient = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1413853096: // amount
          this.amount = castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("nutrient")) {
          this.nutrient = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("amount")) {
          this.amount = castToQuantity(value); // Quantity
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
        case -1671151641: /*nutrient*/ return new String[] {"CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"SimpleQuantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("nutrient")) {
          this.nutrient = new CodeableConcept();
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

    /**
     * Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifier", formalDefinition="Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this event.
     */
    @Child(name = "basedOn", type = {NutritionOrder.class, CarePlan.class, ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfils plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular event is a component or step.
     */
    @Child(name = "partOf", type = {NutritionIntake.class, Procedure.class, Observation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular event is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | completed | entered-in-error | intended | stopped | on-hold | unknown | not-taken", formalDefinition="A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/nutrition-intake-status")
    protected Enumeration<NutritionIntakeStatus> status;

    /**
     * Captures the reason for the current state of the NutritionIntake.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the NutritionIntake." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reason-medication-status-codes")
    protected List<CodeableConcept> statusReason;

    /**
     * Indicates where the food or fluid was  consumed or prescribed.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of nutrition intake setting/reporting", formalDefinition="Indicates where the food or fluid was  consumed or prescribed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/nutrition-intake-category")
    protected List<CodeableConcept> category;

    /**
     * What food or fluid product or item was consumed.
     */
    @Child(name = "consumedItem", type = {}, order=6, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What food or fluid product or item was consumed", formalDefinition="What food or fluid product or item was consumed." )
    protected List<NutritionIntakeConsumedItemComponent> consumedItem;

    /**
     * Total nutrient amounts for the whole meal, product, serving, etc.
     */
    @Child(name = "ingredientLabel", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Total nutrient for the whole meal, product, serving", formalDefinition="Total nutrient amounts for the whole meal, product, serving, etc." )
    protected List<NutritionIntakeIngredientLabelComponent> ingredientLabel;

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
    @Child(name = "effective", type = {DateTimeType.class, Period.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date/time or interval when the food or fluid is/was consumed", formalDefinition="The interval of time during which it is being asserted that the patient is/was consuming the food or fluid." )
    protected Type effective;

    /**
     * The date when the Nutrition Intake was asserted by the information source.
     */
    @Child(name = "dateAsserted", type = {DateTimeType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the consumption was asserted?", formalDefinition="The date when the Nutrition Intake was asserted by the information source." )
    protected DateTimeType dateAsserted;

    /**
     * The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.
     */
    @Child(name = "informationSource", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Person or organization that provided the information about the consumption of this food or fluid", formalDefinition="The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources." )
    protected Reference informationSource;

    /**
     * Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.
     */
    @Child(name = "derivedFrom", type = {Reference.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional supporting information", formalDefinition="Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake." )
    protected List<Reference> derivedFrom;

    /**
     * A reason for why the food or fluid is /was consumed.
     */
    @Child(name = "reasonCode", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for why the food or fluid is /was consumed", formalDefinition="A reason for why the food or fluid is /was consumed." )
    protected List<CodeableConcept> reasonCode;

    /**
     * Condition or observation that supports why the food or fluid is /was consumed.
     */
    @Child(name = "reasonReference", type = {Condition.class, Observation.class, DiagnosticReport.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Condition or observation that supports why the food or fluid is /was consumed", formalDefinition="Condition or observation that supports why the food or fluid is /was consumed." )
    protected List<Reference> reasonReference;

    /**
     * Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Further information about the consumption", formalDefinition="Provides extra information about the Nutrition Intake that is not conveyed by the other attributes." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 1482407460L;

  /**
   * Constructor
   */
    public NutritionIntake() {
      super();
    }

  /**
   * Constructor
   */
    public NutritionIntake(Enumeration<NutritionIntakeStatus> status, Reference subject) {
      super();
      this.status = status;
      this.subject = subject;
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
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
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
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
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
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist
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
    public Enumeration<NutritionIntakeStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<NutritionIntakeStatus>(new NutritionIntakeStatusEnumFactory()); // bb
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
    public NutritionIntake setStatusElement(Enumeration<NutritionIntakeStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    public NutritionIntakeStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.
     */
    public NutritionIntake setStatus(NutritionIntakeStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<NutritionIntakeStatus>(new NutritionIntakeStatusEnumFactory());
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
     * @return The first repetition of repeating field {@link #statusReason}, creating it if it does not already exist
     */
    public CodeableConcept getStatusReasonFirstRep() { 
      if (getStatusReason().isEmpty()) {
        addStatusReason();
      }
      return getStatusReason().get(0);
    }

    /**
     * @return {@link #category} (Indicates where the food or fluid was  consumed or prescribed.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setCategory(List<CodeableConcept> theCategory) { 
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

    public NutritionIntake addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
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
     * @return The first repetition of repeating field {@link #consumedItem}, creating it if it does not already exist
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
     * @return The first repetition of repeating field {@link #ingredientLabel}, creating it if it does not already exist
     */
    public NutritionIntakeIngredientLabelComponent getIngredientLabelFirstRep() { 
      if (getIngredientLabel().isEmpty()) {
        addIngredientLabel();
      }
      return getIngredientLabel().get(0);
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
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public Type getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public DateTimeType getEffectiveDateTimeType() throws FHIRException { 
      if (this.effective == null)
        this.effective = new DateTimeType();
      if (!(this.effective instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (DateTimeType) this.effective;
    }

    public boolean hasEffectiveDateTimeType() { 
      return this != null && this.effective instanceof DateTimeType;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public Period getEffectivePeriod() throws FHIRException { 
      if (this.effective == null)
        this.effective = new Period();
      if (!(this.effective instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (Period) this.effective;
    }

    public boolean hasEffectivePeriod() { 
      return this != null && this.effective instanceof Period;
    }

    public boolean hasEffective() { 
      return this.effective != null && !this.effective.isEmpty();
    }

    /**
     * @param value {@link #effective} (The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.)
     */
    public NutritionIntake setEffective(Type value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for NutritionIntake.effective[x]: "+value.fhirType());
      this.effective = value;
      return this;
    }

    /**
     * @return {@link #dateAsserted} (The date when the Nutrition Intake was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public DateTimeType getDateAssertedElement() { 
      if (this.dateAsserted == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.dateAsserted");
        else if (Configuration.doAutoCreate())
          this.dateAsserted = new DateTimeType(); // bb
      return this.dateAsserted;
    }

    public boolean hasDateAssertedElement() { 
      return this.dateAsserted != null && !this.dateAsserted.isEmpty();
    }

    public boolean hasDateAsserted() { 
      return this.dateAsserted != null && !this.dateAsserted.isEmpty();
    }

    /**
     * @param value {@link #dateAsserted} (The date when the Nutrition Intake was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public NutritionIntake setDateAssertedElement(DateTimeType value) { 
      this.dateAsserted = value;
      return this;
    }

    /**
     * @return The date when the Nutrition Intake was asserted by the information source.
     */
    public Date getDateAsserted() { 
      return this.dateAsserted == null ? null : this.dateAsserted.getValue();
    }

    /**
     * @param value The date when the Nutrition Intake was asserted by the information source.
     */
    public NutritionIntake setDateAsserted(Date value) { 
      if (value == null)
        this.dateAsserted = null;
      else {
        if (this.dateAsserted == null)
          this.dateAsserted = new DateTimeType();
        this.dateAsserted.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #informationSource} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public Reference getInformationSource() { 
      if (this.informationSource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NutritionIntake.informationSource");
        else if (Configuration.doAutoCreate())
          this.informationSource = new Reference(); // cc
      return this.informationSource;
    }

    public boolean hasInformationSource() { 
      return this.informationSource != null && !this.informationSource.isEmpty();
    }

    /**
     * @param value {@link #informationSource} (The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.)
     */
    public NutritionIntake setInformationSource(Reference value) { 
      this.informationSource = value;
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
     * @return The first repetition of repeating field {@link #derivedFrom}, creating it if it does not already exist
     */
    public Reference getDerivedFromFirstRep() { 
      if (getDerivedFrom().isEmpty()) {
        addDerivedFrom();
      }
      return getDerivedFrom().get(0);
    }

    /**
     * @return {@link #reasonCode} (A reason for why the food or fluid is /was consumed.)
     */
    public List<CodeableConcept> getReasonCode() { 
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      return this.reasonCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setReasonCode(List<CodeableConcept> theReasonCode) { 
      this.reasonCode = theReasonCode;
      return this;
    }

    public boolean hasReasonCode() { 
      if (this.reasonCode == null)
        return false;
      for (CodeableConcept item : this.reasonCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addReasonCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      this.reasonCode.add(t);
      return t;
    }

    public NutritionIntake addReasonCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      this.reasonCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() { 
      if (getReasonCode().isEmpty()) {
        addReasonCode();
      }
      return getReasonCode().get(0);
    }

    /**
     * @return {@link #reasonReference} (Condition or observation that supports why the food or fluid is /was consumed.)
     */
    public List<Reference> getReasonReference() { 
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      return this.reasonReference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NutritionIntake setReasonReference(List<Reference> theReasonReference) { 
      this.reasonReference = theReasonReference;
      return this;
    }

    public boolean hasReasonReference() { 
      if (this.reasonReference == null)
        return false;
      for (Reference item : this.reasonReference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReasonReference() { //3
      Reference t = new Reference();
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      this.reasonReference.add(t);
      return t;
    }

    public NutritionIntake addReasonReference(Reference t) { //3
      if (t == null)
        return this;
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      this.reasonReference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() { 
      if (getReasonReference().isEmpty()) {
        addReasonReference();
      }
      return getReasonReference().get(0);
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
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
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
        children.add(new Property("basedOn", "Reference(NutritionOrder|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(NutritionIntake|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, statusReason));
        children.add(new Property("category", "CodeableConcept", "Indicates where the food or fluid was  consumed or prescribed.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("consumedItem", "", "What food or fluid product or item was consumed.", 0, java.lang.Integer.MAX_VALUE, consumedItem));
        children.add(new Property("ingredientLabel", "", "Total nutrient amounts for the whole meal, product, serving, etc.", 0, java.lang.Integer.MAX_VALUE, ingredientLabel));
        children.add(new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was consuming the food or fluid.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this NutritionIntake.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, effective));
        children.add(new Property("dateAsserted", "dateTime", "The date when the Nutrition Intake was asserted by the information source.", 0, 1, dateAsserted));
        children.add(new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, informationSource));
        children.add(new Property("derivedFrom", "Reference(Any)", "Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("reasonCode", "CodeableConcept", "A reason for why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reasonCode));
        children.add(new Property("reasonReference", "Reference(Condition|Observation|DiagnosticReport)", "Condition or observation that supports why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reasonReference));
        children.add(new Property("note", "Annotation", "Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers associated with this Nutrition Intake that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(NutritionOrder|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(NutritionIntake|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code representing the patient or other source's judgment about the state of the intake that this assertion is about.  Generally, this will be active or completed.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, statusReason);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Indicates where the food or fluid was  consumed or prescribed.", 0, java.lang.Integer.MAX_VALUE, category);
        case -854114533: /*consumedItem*/  return new Property("consumedItem", "", "What food or fluid product or item was consumed.", 0, java.lang.Integer.MAX_VALUE, consumedItem);
        case -936536157: /*ingredientLabel*/  return new Property("ingredientLabel", "", "Total nutrient amounts for the whole meal, product, serving, etc.", 0, java.lang.Integer.MAX_VALUE, ingredientLabel);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was consuming the food or fluid.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this NutritionIntake.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was consuming the food or fluid.", 0, 1, effective);
        case -1980855245: /*dateAsserted*/  return new Property("dateAsserted", "dateTime", "The date when the Nutrition Intake was asserted by the information source.", 0, 1, dateAsserted);
        case -2123220889: /*informationSource*/  return new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the consumption of this food or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.", 0, 1, informationSource);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(Any)", "Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information, such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case 722137681: /*reasonCode*/  return new Property("reasonCode", "CodeableConcept", "A reason for why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reasonCode);
        case -1146218137: /*reasonReference*/  return new Property("reasonReference", "Reference(Condition|Observation|DiagnosticReport)", "Condition or observation that supports why the food or fluid is /was consumed.", 0, java.lang.Integer.MAX_VALUE, reasonReference);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides extra information about the Nutrition Intake that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<NutritionIntakeStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : this.statusReason.toArray(new Base[this.statusReason.size()]); // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -854114533: /*consumedItem*/ return this.consumedItem == null ? new Base[0] : this.consumedItem.toArray(new Base[this.consumedItem.size()]); // NutritionIntakeConsumedItemComponent
        case -936536157: /*ingredientLabel*/ return this.ingredientLabel == null ? new Base[0] : this.ingredientLabel.toArray(new Base[this.ingredientLabel.size()]); // NutritionIntakeIngredientLabelComponent
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // Type
        case -1980855245: /*dateAsserted*/ return this.dateAsserted == null ? new Base[0] : new Base[] {this.dateAsserted}; // DateTimeType
        case -2123220889: /*informationSource*/ return this.informationSource == null ? new Base[0] : new Base[] {this.informationSource}; // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case 722137681: /*reasonCode*/ return this.reasonCode == null ? new Base[0] : this.reasonCode.toArray(new Base[this.reasonCode.size()]); // CodeableConcept
        case -1146218137: /*reasonReference*/ return this.reasonReference == null ? new Base[0] : this.reasonReference.toArray(new Base[this.reasonReference.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new NutritionIntakeStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<NutritionIntakeStatus>
          return value;
        case 2051346646: // statusReason
          this.getStatusReason().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -854114533: // consumedItem
          this.getConsumedItem().add((NutritionIntakeConsumedItemComponent) value); // NutritionIntakeConsumedItemComponent
          return value;
        case -936536157: // ingredientLabel
          this.getIngredientLabel().add((NutritionIntakeIngredientLabelComponent) value); // NutritionIntakeIngredientLabelComponent
          return value;
        case -1867885268: // subject
          this.subject = castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = castToReference(value); // Reference
          return value;
        case -1468651097: // effective
          this.effective = castToType(value); // Type
          return value;
        case -1980855245: // dateAsserted
          this.dateAsserted = castToDateTime(value); // DateTimeType
          return value;
        case -2123220889: // informationSource
          this.informationSource = castToReference(value); // Reference
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(castToReference(value)); // Reference
          return value;
        case 722137681: // reasonCode
          this.getReasonCode().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1146218137: // reasonReference
          this.getReasonReference().add(castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(castToReference(value));
        } else if (name.equals("status")) {
          value = new NutritionIntakeStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<NutritionIntakeStatus>
        } else if (name.equals("statusReason")) {
          this.getStatusReason().add(castToCodeableConcept(value));
        } else if (name.equals("category")) {
          this.getCategory().add(castToCodeableConcept(value));
        } else if (name.equals("consumedItem")) {
          this.getConsumedItem().add((NutritionIntakeConsumedItemComponent) value);
        } else if (name.equals("ingredientLabel")) {
          this.getIngredientLabel().add((NutritionIntakeIngredientLabelComponent) value);
        } else if (name.equals("subject")) {
          this.subject = castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = castToReference(value); // Reference
        } else if (name.equals("effective[x]")) {
          this.effective = castToType(value); // Type
        } else if (name.equals("dateAsserted")) {
          this.dateAsserted = castToDateTime(value); // DateTimeType
        } else if (name.equals("informationSource")) {
          this.informationSource = castToReference(value); // Reference
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(castToReference(value));
        } else if (name.equals("reasonCode")) {
          this.getReasonCode().add(castToCodeableConcept(value));
        } else if (name.equals("reasonReference")) {
          this.getReasonReference().add(castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(castToAnnotation(value));
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
        case 2051346646:  return addStatusReason(); 
        case 50511102:  return addCategory(); 
        case -854114533:  return addConsumedItem(); 
        case -936536157:  return addIngredientLabel(); 
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case -1980855245:  return getDateAssertedElement();
        case -2123220889:  return getInformationSource();
        case 1077922663:  return addDerivedFrom(); 
        case 722137681:  return addReasonCode(); 
        case -1146218137:  return addReasonReference(); 
        case 3387378:  return addNote(); 
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
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -854114533: /*consumedItem*/ return new String[] {};
        case -936536157: /*ingredientLabel*/ return new String[] {};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1468651097: /*effective*/ return new String[] {"dateTime", "Period"};
        case -1980855245: /*dateAsserted*/ return new String[] {"dateTime"};
        case -2123220889: /*informationSource*/ return new String[] {"Reference"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case 722137681: /*reasonCode*/ return new String[] {"CodeableConcept"};
        case -1146218137: /*reasonReference*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
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
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.status");
        }
        else if (name.equals("statusReason")) {
          return addStatusReason();
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("consumedItem")) {
          return addConsumedItem();
        }
        else if (name.equals("ingredientLabel")) {
          return addIngredientLabel();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("effectiveDateTime")) {
          this.effective = new DateTimeType();
          return this.effective;
        }
        else if (name.equals("effectivePeriod")) {
          this.effective = new Period();
          return this.effective;
        }
        else if (name.equals("dateAsserted")) {
          throw new FHIRException("Cannot call addChild on a primitive type NutritionIntake.dateAsserted");
        }
        else if (name.equals("informationSource")) {
          this.informationSource = new Reference();
          return this.informationSource;
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("reasonCode")) {
          return addReasonCode();
        }
        else if (name.equals("reasonReference")) {
          return addReasonReference();
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
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
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
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.effective = effective == null ? null : effective.copy();
        dst.dateAsserted = dateAsserted == null ? null : dateAsserted.copy();
        dst.informationSource = informationSource == null ? null : informationSource.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        if (reasonCode != null) {
          dst.reasonCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reasonCode)
            dst.reasonCode.add(i.copy());
        };
        if (reasonReference != null) {
          dst.reasonReference = new ArrayList<Reference>();
          for (Reference i : reasonReference)
            dst.reasonReference.add(i.copy());
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true) && compareDeep(category, o.category, true)
           && compareDeep(consumedItem, o.consumedItem, true) && compareDeep(ingredientLabel, o.ingredientLabel, true)
           && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true) && compareDeep(effective, o.effective, true)
           && compareDeep(dateAsserted, o.dateAsserted, true) && compareDeep(informationSource, o.informationSource, true)
           && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(reasonCode, o.reasonCode, true)
           && compareDeep(reasonReference, o.reasonReference, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NutritionIntake))
          return false;
        NutritionIntake o = (NutritionIntake) other_;
        return compareValues(status, o.status, true) && compareValues(dateAsserted, o.dateAsserted, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, statusReason, category, consumedItem, ingredientLabel, subject, encounter
          , effective, dateAsserted, informationSource, derivedFrom, reasonCode, reasonReference
          , note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.NutritionIntake;
   }

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
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NutritionIntake.effective[x]</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="NutritionIntake.effective", description="Date when patient was taking (or not taking) the medication", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NutritionIntake.effective[x]</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

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
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient, animal or group to list statements for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="NutritionIntake.subject", description="The identity of a patient, animal or group to list statements for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient") }, target={Group.class, Patient.class } )
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

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Returns statements for a specific patient.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="NutritionIntake.subject.where(resolve() is Patient)", description="Returns statements for a specific patient.", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Returns statements for a specific patient.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("NutritionIntake:patient").toLocked();

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
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.informationSource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source", path="NutritionIntake.informationSource", description="Who or where the information in the statement came from", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="RelatedPerson") }, target={Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SOURCE = "source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.informationSource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NutritionIntake:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include("NutritionIntake:source").toLocked();

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Returns statements for a specific encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>NutritionIntake.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="NutritionIntake.encounter", description="Returns statements for a specific encounter", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Encounter") }, target={Encounter.class } )
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
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Returns statements of this category of NutritionIntake</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="NutritionIntake.category", description="Returns statements of this category of NutritionIntake", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Returns statements of this category of NutritionIntake</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NutritionIntake.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

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


}

