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
 * This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
 */
@ResourceDef(name="Medication", profile="http://hl7.org/fhir/StructureDefinition/Medication")
public class Medication extends DomainResource {

    public enum MedicationStatusCodes {
        /**
         * The medication is available for use.
         */
        ACTIVE, 
        /**
         * The medication is not available for use.
         */
        INACTIVE, 
        /**
         * The medication was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MedicationStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/medication-status";
            case INACTIVE: return "http://hl7.org/fhir/CodeSystem/medication-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medication-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The medication is available for use.";
            case INACTIVE: return "The medication is not available for use.";
            case ENTEREDINERROR: return "The medication was entered in error.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            default: return "?";
          }
        }
    }

  public static class MedicationStatusCodesEnumFactory implements EnumFactory<MedicationStatusCodes> {
    public MedicationStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return MedicationStatusCodes.ACTIVE;
        if ("inactive".equals(codeString))
          return MedicationStatusCodes.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return MedicationStatusCodes.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown MedicationStatusCodes code '"+codeString+"'");
        }
        public Enumeration<MedicationStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.ACTIVE);
        if ("inactive".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.INACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.ENTEREDINERROR);
        throw new FHIRException("Unknown MedicationStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationStatusCodes code) {
      if (code == MedicationStatusCodes.ACTIVE)
        return "active";
      if (code == MedicationStatusCodes.INACTIVE)
        return "inactive";
      if (code == MedicationStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(MedicationStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MedicationIngredientComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication).
         */
        @Child(name = "item", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The ingredient (substance or medication) that the ingredient.strength relates to", formalDefinition="The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication)." )
        protected CodeableReference item;

        /**
         * Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        @Child(name = "isActive", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Active ingredient indicator", formalDefinition="Indication of whether this ingredient affects the therapeutic action of the drug." )
        protected BooleanType isActive;

        /**
         * Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.
         */
        @Child(name = "strength", type = {Ratio.class, CodeableConcept.class, Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Quantity of ingredient present", formalDefinition="Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-ingredientstrength")
        protected DataType strength;

        private static final long serialVersionUID = -979760018L;

    /**
     * Constructor
     */
      public MedicationIngredientComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationIngredientComponent(CodeableReference item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication).)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationIngredientComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication).)
         */
        public MedicationIngredientComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        /**
         * @return {@link #isActive} (Indication of whether this ingredient affects the therapeutic action of the drug.). This is the underlying object with id, value and extensions. The accessor "getIsActive" gives direct access to the value
         */
        public BooleanType getIsActiveElement() { 
          if (this.isActive == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationIngredientComponent.isActive");
            else if (Configuration.doAutoCreate())
              this.isActive = new BooleanType(); // bb
          return this.isActive;
        }

        public boolean hasIsActiveElement() { 
          return this.isActive != null && !this.isActive.isEmpty();
        }

        public boolean hasIsActive() { 
          return this.isActive != null && !this.isActive.isEmpty();
        }

        /**
         * @param value {@link #isActive} (Indication of whether this ingredient affects the therapeutic action of the drug.). This is the underlying object with id, value and extensions. The accessor "getIsActive" gives direct access to the value
         */
        public MedicationIngredientComponent setIsActiveElement(BooleanType value) { 
          this.isActive = value;
          return this;
        }

        /**
         * @return Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        public boolean getIsActive() { 
          return this.isActive == null || this.isActive.isEmpty() ? false : this.isActive.getValue();
        }

        /**
         * @param value Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        public MedicationIngredientComponent setIsActive(boolean value) { 
            if (this.isActive == null)
              this.isActive = new BooleanType();
            this.isActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public DataType getStrength() { 
          return this.strength;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public Ratio getStrengthRatio() throws FHIRException { 
          if (this.strength == null)
            this.strength = new Ratio();
          if (!(this.strength instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (Ratio) this.strength;
        }

        public boolean hasStrengthRatio() { 
          return this != null && this.strength instanceof Ratio;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public CodeableConcept getStrengthCodeableConcept() throws FHIRException { 
          if (this.strength == null)
            this.strength = new CodeableConcept();
          if (!(this.strength instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (CodeableConcept) this.strength;
        }

        public boolean hasStrengthCodeableConcept() { 
          return this != null && this.strength instanceof CodeableConcept;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public Quantity getStrengthQuantity() throws FHIRException { 
          if (this.strength == null)
            this.strength = new Quantity();
          if (!(this.strength instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (Quantity) this.strength;
        }

        public boolean hasStrengthQuantity() { 
          return this != null && this.strength instanceof Quantity;
        }

        public boolean hasStrength() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        /**
         * @param value {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public MedicationIngredientComponent setStrength(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof CodeableConcept || value instanceof Quantity))
            throw new Error("Not the right type for Medication.ingredient.strength[x]: "+value.fhirType());
          this.strength = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "CodeableReference(Substance|Medication)", "The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication).", 0, 1, item));
          children.add(new Property("isActive", "boolean", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, isActive));
          children.add(new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "CodeableReference(Substance|Medication)", "The ingredient (substance or medication) that the ingredient.strength relates to.  This is represented as a concept from a code system or described in another resource (Substance or Medication).", 0, 1, item);
          case -748916528: /*isActive*/  return new Property("isActive", "boolean", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, isActive);
          case 127377567: /*strength[x]*/  return new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case 1791316033: /*strength*/  return new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case 2141786186: /*strengthRatio*/  return new Property("strength[x]", "Ratio", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case -1455903456: /*strengthCodeableConcept*/  return new Property("strength[x]", "CodeableConcept", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case -1793570836: /*strengthQuantity*/  return new Property("strength[x]", "Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        case -748916528: /*isActive*/ return this.isActive == null ? new Base[0] : new Base[] {this.isActive}; // BooleanType
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -748916528: // isActive
          this.isActive = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1791316033: // strength
          this.strength = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("isActive")) {
          this.isActive = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("strength[x]")) {
          this.strength = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return getItem();
        case -748916528:  return getIsActiveElement();
        case 127377567:  return getStrength();
        case 1791316033:  return getStrength();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case -748916528: /*isActive*/ return new String[] {"boolean"};
        case 1791316033: /*strength*/ return new String[] {"Ratio", "CodeableConcept", "Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else if (name.equals("isActive")) {
          throw new FHIRException("Cannot call addChild on a primitive type Medication.ingredient.isActive");
        }
        else if (name.equals("strengthRatio")) {
          this.strength = new Ratio();
          return this.strength;
        }
        else if (name.equals("strengthCodeableConcept")) {
          this.strength = new CodeableConcept();
          return this.strength;
        }
        else if (name.equals("strengthQuantity")) {
          this.strength = new Quantity();
          return this.strength;
        }
        else
          return super.addChild(name);
      }

      public MedicationIngredientComponent copy() {
        MedicationIngredientComponent dst = new MedicationIngredientComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationIngredientComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
        dst.isActive = isActive == null ? null : isActive.copy();
        dst.strength = strength == null ? null : strength.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationIngredientComponent))
          return false;
        MedicationIngredientComponent o = (MedicationIngredientComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(isActive, o.isActive, true) && compareDeep(strength, o.strength, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationIngredientComponent))
          return false;
        MedicationIngredientComponent o = (MedicationIngredientComponent) other_;
        return compareValues(isActive, o.isActive, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, isActive, strength
          );
      }

  public String fhirType() {
    return "Medication.ingredient";

  }

  }

    @Block()
    public static class MedicationBatchComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The assigned lot number of a batch of the specified product.
         */
        @Child(name = "lotNumber", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identifier assigned to batch", formalDefinition="The assigned lot number of a batch of the specified product." )
        protected StringType lotNumber;

        /**
         * When this specific batch of product will expire.
         */
        @Child(name = "expirationDate", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When batch will expire", formalDefinition="When this specific batch of product will expire." )
        protected DateTimeType expirationDate;

        private static final long serialVersionUID = 1982738755L;

    /**
     * Constructor
     */
      public MedicationBatchComponent() {
        super();
      }

        /**
         * @return {@link #lotNumber} (The assigned lot number of a batch of the specified product.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
         */
        public StringType getLotNumberElement() { 
          if (this.lotNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationBatchComponent.lotNumber");
            else if (Configuration.doAutoCreate())
              this.lotNumber = new StringType(); // bb
          return this.lotNumber;
        }

        public boolean hasLotNumberElement() { 
          return this.lotNumber != null && !this.lotNumber.isEmpty();
        }

        public boolean hasLotNumber() { 
          return this.lotNumber != null && !this.lotNumber.isEmpty();
        }

        /**
         * @param value {@link #lotNumber} (The assigned lot number of a batch of the specified product.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
         */
        public MedicationBatchComponent setLotNumberElement(StringType value) { 
          this.lotNumber = value;
          return this;
        }

        /**
         * @return The assigned lot number of a batch of the specified product.
         */
        public String getLotNumber() { 
          return this.lotNumber == null ? null : this.lotNumber.getValue();
        }

        /**
         * @param value The assigned lot number of a batch of the specified product.
         */
        public MedicationBatchComponent setLotNumber(String value) { 
          if (Utilities.noString(value))
            this.lotNumber = null;
          else {
            if (this.lotNumber == null)
              this.lotNumber = new StringType();
            this.lotNumber.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #expirationDate} (When this specific batch of product will expire.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
         */
        public DateTimeType getExpirationDateElement() { 
          if (this.expirationDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationBatchComponent.expirationDate");
            else if (Configuration.doAutoCreate())
              this.expirationDate = new DateTimeType(); // bb
          return this.expirationDate;
        }

        public boolean hasExpirationDateElement() { 
          return this.expirationDate != null && !this.expirationDate.isEmpty();
        }

        public boolean hasExpirationDate() { 
          return this.expirationDate != null && !this.expirationDate.isEmpty();
        }

        /**
         * @param value {@link #expirationDate} (When this specific batch of product will expire.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
         */
        public MedicationBatchComponent setExpirationDateElement(DateTimeType value) { 
          this.expirationDate = value;
          return this;
        }

        /**
         * @return When this specific batch of product will expire.
         */
        public Date getExpirationDate() { 
          return this.expirationDate == null ? null : this.expirationDate.getValue();
        }

        /**
         * @param value When this specific batch of product will expire.
         */
        public MedicationBatchComponent setExpirationDate(Date value) { 
          if (value == null)
            this.expirationDate = null;
          else {
            if (this.expirationDate == null)
              this.expirationDate = new DateTimeType();
            this.expirationDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("lotNumber", "string", "The assigned lot number of a batch of the specified product.", 0, 1, lotNumber));
          children.add(new Property("expirationDate", "dateTime", "When this specific batch of product will expire.", 0, 1, expirationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 462547450: /*lotNumber*/  return new Property("lotNumber", "string", "The assigned lot number of a batch of the specified product.", 0, 1, lotNumber);
          case -668811523: /*expirationDate*/  return new Property("expirationDate", "dateTime", "When this specific batch of product will expire.", 0, 1, expirationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 462547450: /*lotNumber*/ return this.lotNumber == null ? new Base[0] : new Base[] {this.lotNumber}; // StringType
        case -668811523: /*expirationDate*/ return this.expirationDate == null ? new Base[0] : new Base[] {this.expirationDate}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 462547450: // lotNumber
          this.lotNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -668811523: // expirationDate
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("lotNumber")) {
          this.lotNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expirationDate")) {
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 462547450:  return getLotNumberElement();
        case -668811523:  return getExpirationDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 462547450: /*lotNumber*/ return new String[] {"string"};
        case -668811523: /*expirationDate*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("lotNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type Medication.batch.lotNumber");
        }
        else if (name.equals("expirationDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Medication.batch.expirationDate");
        }
        else
          return super.addChild(name);
      }

      public MedicationBatchComponent copy() {
        MedicationBatchComponent dst = new MedicationBatchComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationBatchComponent dst) {
        super.copyValues(dst);
        dst.lotNumber = lotNumber == null ? null : lotNumber.copy();
        dst.expirationDate = expirationDate == null ? null : expirationDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationBatchComponent))
          return false;
        MedicationBatchComponent o = (MedicationBatchComponent) other_;
        return compareDeep(lotNumber, o.lotNumber, true) && compareDeep(expirationDate, o.expirationDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationBatchComponent))
          return false;
        MedicationBatchComponent o = (MedicationBatchComponent) other_;
        return compareValues(lotNumber, o.lotNumber, true) && compareValues(expirationDate, o.expirationDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(lotNumber, expirationDate
          );
      }

  public String fhirType() {
    return "Medication.batch";

  }

  }

    /**
     * Business identifier for this medication.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this medication", formalDefinition="Business identifier for this medication." )
    protected List<Identifier> identifier;

    /**
     * A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Codes that identify this medication", formalDefinition="A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableConcept code;

    /**
     * A code to indicate if the medication is in active use.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error", formalDefinition="A code to indicate if the medication is in active use." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-status")
    protected Enumeration<MedicationStatusCodes> status;

    /**
     * Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of the item", formalDefinition="Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product." )
    protected Reference manufacturer;

    /**
     * Describes the form of the item.  Powder; tablets; capsule.
     */
    @Child(name = "doseForm", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="powder | tablets | capsule +", formalDefinition="Describes the form of the item.  Powder; tablets; capsule." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-form-codes")
    protected CodeableConcept doseForm;

    /**
     * Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).
     */
    @Child(name = "amount", type = {Ratio.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Amount of drug in package", formalDefinition="Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.)." )
    protected Ratio amount;

    /**
     * Identifies a particular constituent of interest in the product.
     */
    @Child(name = "ingredient", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Active or inactive ingredient", formalDefinition="Identifies a particular constituent of interest in the product." )
    protected List<MedicationIngredientComponent> ingredient;

    /**
     * Information that only applies to packages (not products).
     */
    @Child(name = "batch", type = {}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details about packaged medications", formalDefinition="Information that only applies to packages (not products)." )
    protected MedicationBatchComponent batch;

    private static final long serialVersionUID = 1712967281L;

  /**
   * Constructor
   */
    public Medication() {
      super();
    }

    /**
     * @return {@link #identifier} (Business identifier for this medication.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Medication setIdentifier(List<Identifier> theIdentifier) { 
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

    public Medication addIdentifier(Identifier t) { //3
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
     * @return {@link #code} (A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.)
     */
    public Medication setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #status} (A code to indicate if the medication is in active use.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<MedicationStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<MedicationStatusCodes>(new MedicationStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code to indicate if the medication is in active use.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Medication setStatusElement(Enumeration<MedicationStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code to indicate if the medication is in active use.
     */
    public MedicationStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code to indicate if the medication is in active use.
     */
    public Medication setStatus(MedicationStatusCodes value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<MedicationStatusCodes>(new MedicationStatusCodesEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #manufacturer} (Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.)
     */
    public Reference getManufacturer() { 
      if (this.manufacturer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.manufacturer");
        else if (Configuration.doAutoCreate())
          this.manufacturer = new Reference(); // cc
      return this.manufacturer;
    }

    public boolean hasManufacturer() { 
      return this.manufacturer != null && !this.manufacturer.isEmpty();
    }

    /**
     * @param value {@link #manufacturer} (Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.)
     */
    public Medication setManufacturer(Reference value) { 
      this.manufacturer = value;
      return this;
    }

    /**
     * @return {@link #doseForm} (Describes the form of the item.  Powder; tablets; capsule.)
     */
    public CodeableConcept getDoseForm() { 
      if (this.doseForm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.doseForm");
        else if (Configuration.doAutoCreate())
          this.doseForm = new CodeableConcept(); // cc
      return this.doseForm;
    }

    public boolean hasDoseForm() { 
      return this.doseForm != null && !this.doseForm.isEmpty();
    }

    /**
     * @param value {@link #doseForm} (Describes the form of the item.  Powder; tablets; capsule.)
     */
    public Medication setDoseForm(CodeableConcept value) { 
      this.doseForm = value;
      return this;
    }

    /**
     * @return {@link #amount} (Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public Ratio getAmount() { 
      if (this.amount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.amount");
        else if (Configuration.doAutoCreate())
          this.amount = new Ratio(); // cc
      return this.amount;
    }

    public boolean hasAmount() { 
      return this.amount != null && !this.amount.isEmpty();
    }

    /**
     * @param value {@link #amount} (Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public Medication setAmount(Ratio value) { 
      this.amount = value;
      return this;
    }

    /**
     * @return {@link #ingredient} (Identifies a particular constituent of interest in the product.)
     */
    public List<MedicationIngredientComponent> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationIngredientComponent>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Medication setIngredient(List<MedicationIngredientComponent> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (MedicationIngredientComponent item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationIngredientComponent addIngredient() { //3
      MedicationIngredientComponent t = new MedicationIngredientComponent();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationIngredientComponent>();
      this.ingredient.add(t);
      return t;
    }

    public Medication addIngredient(MedicationIngredientComponent t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationIngredientComponent>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public MedicationIngredientComponent getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #batch} (Information that only applies to packages (not products).)
     */
    public MedicationBatchComponent getBatch() { 
      if (this.batch == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.batch");
        else if (Configuration.doAutoCreate())
          this.batch = new MedicationBatchComponent(); // cc
      return this.batch;
    }

    public boolean hasBatch() { 
      return this.batch != null && !this.batch.isEmpty();
    }

    /**
     * @param value {@link #batch} (Information that only applies to packages (not products).)
     */
    public Medication setBatch(MedicationBatchComponent value) { 
      this.batch = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code));
        children.add(new Property("status", "code", "A code to indicate if the medication is in active use.", 0, 1, status));
        children.add(new Property("manufacturer", "Reference(Organization)", "Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.", 0, 1, manufacturer));
        children.add(new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm));
        children.add(new Property("amount", "Ratio", "Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, amount));
        children.add(new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("batch", "", "Information that only applies to packages (not products).", 0, 1, batch));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the medication is in active use.", 0, 1, status);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.", 0, 1, manufacturer);
        case 1303858817: /*doseForm*/  return new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm);
        case -1413853096: /*amount*/  return new Property("amount", "Ratio", "Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, amount);
        case -206409263: /*ingredient*/  return new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case 93509434: /*batch*/  return new Property("batch", "", "Information that only applies to packages (not products).", 0, 1, batch);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationStatusCodes>
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : new Base[] {this.manufacturer}; // Reference
        case 1303858817: /*doseForm*/ return this.doseForm == null ? new Base[0] : new Base[] {this.doseForm}; // CodeableConcept
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Ratio
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // MedicationIngredientComponent
        case 93509434: /*batch*/ return this.batch == null ? new Base[0] : new Base[] {this.batch}; // MedicationBatchComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          value = new MedicationStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationStatusCodes>
          return value;
        case -1969347631: // manufacturer
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1303858817: // doseForm
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case -206409263: // ingredient
          this.getIngredient().add((MedicationIngredientComponent) value); // MedicationIngredientComponent
          return value;
        case 93509434: // batch
          this.batch = (MedicationBatchComponent) value; // MedicationBatchComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          value = new MedicationStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationStatusCodes>
        } else if (name.equals("manufacturer")) {
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("doseForm")) {
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("ingredient")) {
          this.getIngredient().add((MedicationIngredientComponent) value);
        } else if (name.equals("batch")) {
          this.batch = (MedicationBatchComponent) value; // MedicationBatchComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3059181:  return getCode();
        case -892481550:  return getStatusElement();
        case -1969347631:  return getManufacturer();
        case 1303858817:  return getDoseForm();
        case -1413853096:  return getAmount();
        case -206409263:  return addIngredient(); 
        case 93509434:  return getBatch();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 1303858817: /*doseForm*/ return new String[] {"CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"Ratio"};
        case -206409263: /*ingredient*/ return new String[] {};
        case 93509434: /*batch*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Medication.status");
        }
        else if (name.equals("manufacturer")) {
          this.manufacturer = new Reference();
          return this.manufacturer;
        }
        else if (name.equals("doseForm")) {
          this.doseForm = new CodeableConcept();
          return this.doseForm;
        }
        else if (name.equals("amount")) {
          this.amount = new Ratio();
          return this.amount;
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("batch")) {
          this.batch = new MedicationBatchComponent();
          return this.batch;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Medication";

  }

      public Medication copy() {
        Medication dst = new Medication();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Medication dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.status = status == null ? null : status.copy();
        dst.manufacturer = manufacturer == null ? null : manufacturer.copy();
        dst.doseForm = doseForm == null ? null : doseForm.copy();
        dst.amount = amount == null ? null : amount.copy();
        if (ingredient != null) {
          dst.ingredient = new ArrayList<MedicationIngredientComponent>();
          for (MedicationIngredientComponent i : ingredient)
            dst.ingredient.add(i.copy());
        };
        dst.batch = batch == null ? null : batch.copy();
      }

      protected Medication typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Medication))
          return false;
        Medication o = (Medication) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(status, o.status, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(doseForm, o.doseForm, true) && compareDeep(amount, o.amount, true)
           && compareDeep(ingredient, o.ingredient, true) && compareDeep(batch, o.batch, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Medication))
          return false;
        Medication o = (Medication) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, status
          , manufacturer, doseForm, amount, ingredient, batch);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Medication;
   }

 /**
   * Search parameter: <b>expiration-date</b>
   * <p>
   * Description: <b>Returns medications in a batch with this expiration date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Medication.batch.expirationDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="expiration-date", path="Medication.batch.expirationDate", description="Returns medications in a batch with this expiration date", type="date" )
  public static final String SP_EXPIRATION_DATE = "expiration-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>expiration-date</b>
   * <p>
   * Description: <b>Returns medications in a batch with this expiration date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Medication.batch.expirationDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EXPIRATION_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EXPIRATION_DATE);

 /**
   * Search parameter: <b>form</b>
   * <p>
   * Description: <b>Returns medications for a specific dose form</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  @SearchParamDefinition(name="form", path="", description="Returns medications for a specific dose form", type="token" )
  public static final String SP_FORM = "form";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>form</b>
   * <p>
   * Description: <b>Returns medications for a specific dose form</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FORM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FORM);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Returns medications with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Medication.identifier", description="Returns medications with this external identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Returns medications with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>ingredient-code</b>
   * <p>
   * Description: <b>Returns medications for this ingredient code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.ingredient.item.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient-code", path="Medication.ingredient.item.concept", description="Returns medications for this ingredient code", type="token" )
  public static final String SP_INGREDIENT_CODE = "ingredient-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient-code</b>
   * <p>
   * Description: <b>Returns medications for this ingredient code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.ingredient.item.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT_CODE);

 /**
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>Returns medications for this ingredient reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.ingredient.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="Medication.ingredient.item.reference", description="Returns medications for this ingredient reference", type="reference" )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>Returns medications for this ingredient reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.ingredient.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INGREDIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Medication:ingredient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INGREDIENT = new ca.uhn.fhir.model.api.Include("Medication:ingredient").toLocked();

 /**
   * Search parameter: <b>lot-number</b>
   * <p>
   * Description: <b>Returns medications in a batch with this lot number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.batch.lotNumber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="lot-number", path="Medication.batch.lotNumber", description="Returns medications in a batch with this lot number", type="token" )
  public static final String SP_LOT_NUMBER = "lot-number";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>lot-number</b>
   * <p>
   * Description: <b>Returns medications in a batch with this lot number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.batch.lotNumber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam LOT_NUMBER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_LOT_NUMBER);

 /**
   * Search parameter: <b>manufacturer</b>
   * <p>
   * Description: <b>Returns medications made or sold for this manufacturer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="Medication.manufacturer", description="Returns medications made or sold for this manufacturer", type="reference", target={Organization.class } )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>Returns medications made or sold for this manufacturer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.manufacturer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Medication:manufacturer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURER = new ca.uhn.fhir.model.api.Include("Medication:manufacturer").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Returns medications for this status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Medication.status", description="Returns medications for this status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Returns medications for this status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

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


}