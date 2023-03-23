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
 * This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
 */
@ResourceDef(name="Medication", profile="http://hl7.org/fhir/StructureDefinition/Medication")
public class Medication extends DomainResource {

    public enum MedicationStatusCodes {
        /**
         * The medication record is current and is appropriate for reference in new instances.
         */
        ACTIVE, 
        /**
         * The medication record is not current and is not is appropriate for reference in new instances.
         */
        INACTIVE, 
        /**
         * The medication record was created erroneously and is not appropriated for reference in new instances.
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
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/medication-status";
            case INACTIVE: return "http://hl7.org/fhir/CodeSystem/medication-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medication-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The medication record is current and is appropriate for reference in new instances.";
            case INACTIVE: return "The medication record is not current and is not is appropriate for reference in new instances.";
            case ENTEREDINERROR: return "The medication record was created erroneously and is not appropriated for reference in new instances.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
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
        public Enumeration<MedicationStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.ACTIVE, code);
        if ("inactive".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.INACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationStatusCodes>(this, MedicationStatusCodes.ENTEREDINERROR, code);
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
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
            throw new FHIRException("Not the right type for Medication.ingredient.strength[x]: "+value.fhirType());
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
     * The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations).
     */
    @Child(name = "marketingAuthorizationHolder", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization that has authorization to market medication", formalDefinition="The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations)." )
    protected Reference marketingAuthorizationHolder;

    /**
     * Describes the form of the item.  Powder; tablets; capsule.
     */
    @Child(name = "doseForm", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="powder | tablets | capsule +", formalDefinition="Describes the form of the item.  Powder; tablets; capsule." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-form-codes")
    protected CodeableConcept doseForm;

    /**
     * When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).
     */
    @Child(name = "totalVolume", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the specified product code does not infer a package size, this is the specific amount of drug in the product", formalDefinition="When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.)." )
    protected Quantity totalVolume;

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

    /**
     * A reference to a knowledge resource that provides more information about this medication.
     */
    @Child(name = "definition", type = {MedicationKnowledge.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Knowledge about this medication", formalDefinition="A reference to a knowledge resource that provides more information about this medication." )
    protected Reference definition;

    private static final long serialVersionUID = 603813239L;

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
     * @return {@link #marketingAuthorizationHolder} (The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations).)
     */
    public Reference getMarketingAuthorizationHolder() { 
      if (this.marketingAuthorizationHolder == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.marketingAuthorizationHolder");
        else if (Configuration.doAutoCreate())
          this.marketingAuthorizationHolder = new Reference(); // cc
      return this.marketingAuthorizationHolder;
    }

    public boolean hasMarketingAuthorizationHolder() { 
      return this.marketingAuthorizationHolder != null && !this.marketingAuthorizationHolder.isEmpty();
    }

    /**
     * @param value {@link #marketingAuthorizationHolder} (The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations).)
     */
    public Medication setMarketingAuthorizationHolder(Reference value) { 
      this.marketingAuthorizationHolder = value;
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
     * @return {@link #totalVolume} (When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public Quantity getTotalVolume() { 
      if (this.totalVolume == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.totalVolume");
        else if (Configuration.doAutoCreate())
          this.totalVolume = new Quantity(); // cc
      return this.totalVolume;
    }

    public boolean hasTotalVolume() { 
      return this.totalVolume != null && !this.totalVolume.isEmpty();
    }

    /**
     * @param value {@link #totalVolume} (When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public Medication setTotalVolume(Quantity value) { 
      this.totalVolume = value;
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

    /**
     * @return {@link #definition} (A reference to a knowledge resource that provides more information about this medication.)
     */
    public Reference getDefinition() { 
      if (this.definition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Medication.definition");
        else if (Configuration.doAutoCreate())
          this.definition = new Reference(); // cc
      return this.definition;
    }

    public boolean hasDefinition() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    /**
     * @param value {@link #definition} (A reference to a knowledge resource that provides more information about this medication.)
     */
    public Medication setDefinition(Reference value) { 
      this.definition = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code));
        children.add(new Property("status", "code", "A code to indicate if the medication is in active use.", 0, 1, status));
        children.add(new Property("marketingAuthorizationHolder", "Reference(Organization)", "The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations).", 0, 1, marketingAuthorizationHolder));
        children.add(new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm));
        children.add(new Property("totalVolume", "Quantity", "When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, totalVolume));
        children.add(new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("batch", "", "Information that only applies to packages (not products).", 0, 1, batch));
        children.add(new Property("definition", "Reference(MedicationKnowledge)", "A reference to a knowledge resource that provides more information about this medication.", 0, 1, definition));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code (or set of codes) that specify this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the medication is in active use.", 0, 1, status);
        case -1565971585: /*marketingAuthorizationHolder*/  return new Property("marketingAuthorizationHolder", "Reference(Organization)", "The company or other legal entity that has authorization, from the appropriate drug regulatory authority,  to market a medicine in one or more jurisdictions.  Typically abbreviated MAH.Note:  The MAH may manufacture the product and may also contract the manufacturing of the product to one or more companies (organizations).", 0, 1, marketingAuthorizationHolder);
        case 1303858817: /*doseForm*/  return new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm);
        case -654431362: /*totalVolume*/  return new Property("totalVolume", "Quantity", "When the specified product code does not infer a package size, this is the specific amount of drug in the product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, totalVolume);
        case -206409263: /*ingredient*/  return new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case 93509434: /*batch*/  return new Property("batch", "", "Information that only applies to packages (not products).", 0, 1, batch);
        case -1014418093: /*definition*/  return new Property("definition", "Reference(MedicationKnowledge)", "A reference to a knowledge resource that provides more information about this medication.", 0, 1, definition);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationStatusCodes>
        case -1565971585: /*marketingAuthorizationHolder*/ return this.marketingAuthorizationHolder == null ? new Base[0] : new Base[] {this.marketingAuthorizationHolder}; // Reference
        case 1303858817: /*doseForm*/ return this.doseForm == null ? new Base[0] : new Base[] {this.doseForm}; // CodeableConcept
        case -654431362: /*totalVolume*/ return this.totalVolume == null ? new Base[0] : new Base[] {this.totalVolume}; // Quantity
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // MedicationIngredientComponent
        case 93509434: /*batch*/ return this.batch == null ? new Base[0] : new Base[] {this.batch}; // MedicationBatchComponent
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // Reference
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
        case -1565971585: // marketingAuthorizationHolder
          this.marketingAuthorizationHolder = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1303858817: // doseForm
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -654431362: // totalVolume
          this.totalVolume = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -206409263: // ingredient
          this.getIngredient().add((MedicationIngredientComponent) value); // MedicationIngredientComponent
          return value;
        case 93509434: // batch
          this.batch = (MedicationBatchComponent) value; // MedicationBatchComponent
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToReference(value); // Reference
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
        } else if (name.equals("marketingAuthorizationHolder")) {
          this.marketingAuthorizationHolder = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("doseForm")) {
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("totalVolume")) {
          this.totalVolume = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("ingredient")) {
          this.getIngredient().add((MedicationIngredientComponent) value);
        } else if (name.equals("batch")) {
          this.batch = (MedicationBatchComponent) value; // MedicationBatchComponent
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToReference(value); // Reference
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
        case -1565971585:  return getMarketingAuthorizationHolder();
        case 1303858817:  return getDoseForm();
        case -654431362:  return getTotalVolume();
        case -206409263:  return addIngredient(); 
        case 93509434:  return getBatch();
        case -1014418093:  return getDefinition();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1565971585: /*marketingAuthorizationHolder*/ return new String[] {"Reference"};
        case 1303858817: /*doseForm*/ return new String[] {"CodeableConcept"};
        case -654431362: /*totalVolume*/ return new String[] {"Quantity"};
        case -206409263: /*ingredient*/ return new String[] {};
        case 93509434: /*batch*/ return new String[] {};
        case -1014418093: /*definition*/ return new String[] {"Reference"};
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
        else if (name.equals("marketingAuthorizationHolder")) {
          this.marketingAuthorizationHolder = new Reference();
          return this.marketingAuthorizationHolder;
        }
        else if (name.equals("doseForm")) {
          this.doseForm = new CodeableConcept();
          return this.doseForm;
        }
        else if (name.equals("totalVolume")) {
          this.totalVolume = new Quantity();
          return this.totalVolume;
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("batch")) {
          this.batch = new MedicationBatchComponent();
          return this.batch;
        }
        else if (name.equals("definition")) {
          this.definition = new Reference();
          return this.definition;
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
        dst.marketingAuthorizationHolder = marketingAuthorizationHolder == null ? null : marketingAuthorizationHolder.copy();
        dst.doseForm = doseForm == null ? null : doseForm.copy();
        dst.totalVolume = totalVolume == null ? null : totalVolume.copy();
        if (ingredient != null) {
          dst.ingredient = new ArrayList<MedicationIngredientComponent>();
          for (MedicationIngredientComponent i : ingredient)
            dst.ingredient.add(i.copy());
        };
        dst.batch = batch == null ? null : batch.copy();
        dst.definition = definition == null ? null : definition.copy();
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
           && compareDeep(marketingAuthorizationHolder, o.marketingAuthorizationHolder, true) && compareDeep(doseForm, o.doseForm, true)
           && compareDeep(totalVolume, o.totalVolume, true) && compareDeep(ingredient, o.ingredient, true)
           && compareDeep(batch, o.batch, true) && compareDeep(definition, o.definition, true);
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
          , marketingAuthorizationHolder, doseForm, totalVolume, ingredient, batch, definition
          );
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
  @SearchParamDefinition(name="ingredient", path="Medication.ingredient.item.reference", description="Returns medications for this ingredient reference", type="reference", target={Medication.class, Substance.class } )
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
   * Search parameter: <b>marketingauthorizationholder</b>
   * <p>
   * Description: <b>Returns medications made or sold for this marketing authorization holder</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.marketingAuthorizationHolder</b><br>
   * </p>
   */
  @SearchParamDefinition(name="marketingauthorizationholder", path="Medication.marketingAuthorizationHolder", description="Returns medications made or sold for this marketing authorization holder", type="reference", target={Organization.class } )
  public static final String SP_MARKETINGAUTHORIZATIONHOLDER = "marketingauthorizationholder";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>marketingauthorizationholder</b>
   * <p>
   * Description: <b>Returns medications made or sold for this marketing authorization holder</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Medication.marketingAuthorizationHolder</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MARKETINGAUTHORIZATIONHOLDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MARKETINGAUTHORIZATIONHOLDER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Medication:marketingauthorizationholder</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MARKETINGAUTHORIZATIONHOLDER = new ca.uhn.fhir.model.api.Include("Medication:marketingauthorizationholder").toLocked();

 /**
   * Search parameter: <b>serial-number</b>
   * <p>
   * Description: <b>Returns medications in a batch with this lot number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="serial-number", path="Medication.identifier", description="Returns medications in a batch with this lot number", type="token" )
  public static final String SP_SERIAL_NUMBER = "serial-number";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>serial-number</b>
   * <p>
   * Description: <b>Returns medications in a batch with this lot number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Medication.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERIAL_NUMBER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERIAL_NUMBER);

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

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [AuditEvent](auditevent.html): More specific code for the event\r\n* [Basic](basic.html): Kind of Resource\r\n* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code\r\n* [Condition](condition.html): Code for the condition\r\n* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [ImagingSelection](imagingselection.html): The imaging selection status\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationStatement](medicationstatement.html): Return statements of this medication code\r\n* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [RequestOrchestration](requestorchestration.html): The code of the request orchestration\r\n* [Task](task.html): Search by task code\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);


}

