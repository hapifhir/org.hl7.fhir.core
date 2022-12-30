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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * MonetaryComponent Type: Availability data for an {item}.
 */
@DatatypeDef(name="MonetaryComponent")
public class MonetaryComponent extends DataType implements ICompositeType {

    public enum PriceComponentType {
        /**
         * the amount is the base price used for calculating the total price before applying surcharges, discount or taxes.
         */
        BASE, 
        /**
         * the amount is a surcharge applied on the base price.
         */
        SURCHARGE, 
        /**
         * the amount is a deduction applied on the base price.
         */
        DEDUCTION, 
        /**
         * the amount is a discount applied on the base price.
         */
        DISCOUNT, 
        /**
         * the amount is the tax component of the total price.
         */
        TAX, 
        /**
         * the amount is of informational character, it has not been applied in the calculation of the total price.
         */
        INFORMATIONAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static PriceComponentType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("base".equals(codeString))
          return BASE;
        if ("surcharge".equals(codeString))
          return SURCHARGE;
        if ("deduction".equals(codeString))
          return DEDUCTION;
        if ("discount".equals(codeString))
          return DISCOUNT;
        if ("tax".equals(codeString))
          return TAX;
        if ("informational".equals(codeString))
          return INFORMATIONAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown PriceComponentType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BASE: return "base";
            case SURCHARGE: return "surcharge";
            case DEDUCTION: return "deduction";
            case DISCOUNT: return "discount";
            case TAX: return "tax";
            case INFORMATIONAL: return "informational";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BASE: return "http://hl7.org/fhir/price-component-type";
            case SURCHARGE: return "http://hl7.org/fhir/price-component-type";
            case DEDUCTION: return "http://hl7.org/fhir/price-component-type";
            case DISCOUNT: return "http://hl7.org/fhir/price-component-type";
            case TAX: return "http://hl7.org/fhir/price-component-type";
            case INFORMATIONAL: return "http://hl7.org/fhir/price-component-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BASE: return "the amount is the base price used for calculating the total price before applying surcharges, discount or taxes.";
            case SURCHARGE: return "the amount is a surcharge applied on the base price.";
            case DEDUCTION: return "the amount is a deduction applied on the base price.";
            case DISCOUNT: return "the amount is a discount applied on the base price.";
            case TAX: return "the amount is the tax component of the total price.";
            case INFORMATIONAL: return "the amount is of informational character, it has not been applied in the calculation of the total price.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BASE: return "base price";
            case SURCHARGE: return "surcharge";
            case DEDUCTION: return "deduction";
            case DISCOUNT: return "discount";
            case TAX: return "tax";
            case INFORMATIONAL: return "informational";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class PriceComponentTypeEnumFactory implements EnumFactory<PriceComponentType> {
    public PriceComponentType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("base".equals(codeString))
          return PriceComponentType.BASE;
        if ("surcharge".equals(codeString))
          return PriceComponentType.SURCHARGE;
        if ("deduction".equals(codeString))
          return PriceComponentType.DEDUCTION;
        if ("discount".equals(codeString))
          return PriceComponentType.DISCOUNT;
        if ("tax".equals(codeString))
          return PriceComponentType.TAX;
        if ("informational".equals(codeString))
          return PriceComponentType.INFORMATIONAL;
        throw new IllegalArgumentException("Unknown PriceComponentType code '"+codeString+"'");
        }
        public Enumeration<PriceComponentType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PriceComponentType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("base".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.BASE);
        if ("surcharge".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.SURCHARGE);
        if ("deduction".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.DEDUCTION);
        if ("discount".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.DISCOUNT);
        if ("tax".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.TAX);
        if ("informational".equals(codeString))
          return new Enumeration<PriceComponentType>(this, PriceComponentType.INFORMATIONAL);
        throw new FHIRException("Unknown PriceComponentType code '"+codeString+"'");
        }
    public String toCode(PriceComponentType code) {
      if (code == PriceComponentType.BASE)
        return "base";
      if (code == PriceComponentType.SURCHARGE)
        return "surcharge";
      if (code == PriceComponentType.DEDUCTION)
        return "deduction";
      if (code == PriceComponentType.DISCOUNT)
        return "discount";
      if (code == PriceComponentType.TAX)
        return "tax";
      if (code == PriceComponentType.INFORMATIONAL)
        return "informational";
      return "?";
      }
    public String toSystem(PriceComponentType code) {
      return code.getSystem();
      }
    }

    /**
     * base | surcharge | deduction | discount | tax | informational.
     */
    @Child(name = "type", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="base | surcharge | deduction | discount | tax | informational", formalDefinition="base | surcharge | deduction | discount | tax | informational." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/price-component-type")
    protected Enumeration<PriceComponentType> type;

    /**
     * Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.", formalDefinition="Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc." )
    protected CodeableConcept code;

    /**
     * Factor used for calculating this component.
     */
    @Child(name = "factor", type = {DecimalType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Factor used for calculating this component", formalDefinition="Factor used for calculating this component." )
    protected DecimalType factor;

    /**
     * Explicit value amount to be used.
     */
    @Child(name = "amount", type = {Money.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Explicit value amount to be used", formalDefinition="Explicit value amount to be used." )
    protected Money amount;

    private static final long serialVersionUID = 576423679L;

  /**
   * Constructor
   */
    public MonetaryComponent() {
      super();
    }

  /**
   * Constructor
   */
    public MonetaryComponent(PriceComponentType type) {
      super();
      this.setType(type);
    }

    /**
     * @return {@link #type} (base | surcharge | deduction | discount | tax | informational.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<PriceComponentType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MonetaryComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<PriceComponentType>(new PriceComponentTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (base | surcharge | deduction | discount | tax | informational.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public MonetaryComponent setTypeElement(Enumeration<PriceComponentType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return base | surcharge | deduction | discount | tax | informational.
     */
    public PriceComponentType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value base | surcharge | deduction | discount | tax | informational.
     */
    public MonetaryComponent setType(PriceComponentType value) { 
        if (this.type == null)
          this.type = new Enumeration<PriceComponentType>(new PriceComponentTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #code} (Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MonetaryComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.)
     */
    public MonetaryComponent setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #factor} (Factor used for calculating this component.). This is the underlying object with id, value and extensions. The accessor "getFactor" gives direct access to the value
     */
    public DecimalType getFactorElement() { 
      if (this.factor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MonetaryComponent.factor");
        else if (Configuration.doAutoCreate())
          this.factor = new DecimalType(); // bb
      return this.factor;
    }

    public boolean hasFactorElement() { 
      return this.factor != null && !this.factor.isEmpty();
    }

    public boolean hasFactor() { 
      return this.factor != null && !this.factor.isEmpty();
    }

    /**
     * @param value {@link #factor} (Factor used for calculating this component.). This is the underlying object with id, value and extensions. The accessor "getFactor" gives direct access to the value
     */
    public MonetaryComponent setFactorElement(DecimalType value) { 
      this.factor = value;
      return this;
    }

    /**
     * @return Factor used for calculating this component.
     */
    public BigDecimal getFactor() { 
      return this.factor == null ? null : this.factor.getValue();
    }

    /**
     * @param value Factor used for calculating this component.
     */
    public MonetaryComponent setFactor(BigDecimal value) { 
      if (value == null)
        this.factor = null;
      else {
        if (this.factor == null)
          this.factor = new DecimalType();
        this.factor.setValue(value);
      }
      return this;
    }

    /**
     * @param value Factor used for calculating this component.
     */
    public MonetaryComponent setFactor(long value) { 
          this.factor = new DecimalType();
        this.factor.setValue(value);
      return this;
    }

    /**
     * @param value Factor used for calculating this component.
     */
    public MonetaryComponent setFactor(double value) { 
          this.factor = new DecimalType();
        this.factor.setValue(value);
      return this;
    }

    /**
     * @return {@link #amount} (Explicit value amount to be used.)
     */
    public Money getAmount() { 
      if (this.amount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MonetaryComponent.amount");
        else if (Configuration.doAutoCreate())
          this.amount = new Money(); // cc
      return this.amount;
    }

    public boolean hasAmount() { 
      return this.amount != null && !this.amount.isEmpty();
    }

    /**
     * @param value {@link #amount} (Explicit value amount to be used.)
     */
    public MonetaryComponent setAmount(Money value) { 
      this.amount = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("type", "code", "base | surcharge | deduction | discount | tax | informational.", 0, 1, type));
        children.add(new Property("code", "CodeableConcept", "Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.", 0, 1, code));
        children.add(new Property("factor", "decimal", "Factor used for calculating this component.", 0, 1, factor));
        children.add(new Property("amount", "Money", "Explicit value amount to be used.", 0, 1, amount));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3575610: /*type*/  return new Property("type", "code", "base | surcharge | deduction | discount | tax | informational.", 0, 1, type);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.", 0, 1, code);
        case -1282148017: /*factor*/  return new Property("factor", "decimal", "Factor used for calculating this component.", 0, 1, factor);
        case -1413853096: /*amount*/  return new Property("amount", "Money", "Explicit value amount to be used.", 0, 1, amount);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<PriceComponentType>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1282148017: /*factor*/ return this.factor == null ? new Base[0] : new Base[] {this.factor}; // DecimalType
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Money
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new PriceComponentTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<PriceComponentType>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1282148017: // factor
          this.factor = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToMoney(value); // Money
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new PriceComponentTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<PriceComponentType>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("factor")) {
          this.factor = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToMoney(value); // Money
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3059181:  return getCode();
        case -1282148017:  return getFactorElement();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1282148017: /*factor*/ return new String[] {"decimal"};
        case -1413853096: /*amount*/ return new String[] {"Money"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type MonetaryComponent.type");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("factor")) {
          throw new FHIRException("Cannot call addChild on a primitive type MonetaryComponent.factor");
        }
        else if (name.equals("amount")) {
          this.amount = new Money();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MonetaryComponent";

  }

      public MonetaryComponent copy() {
        MonetaryComponent dst = new MonetaryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MonetaryComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.code = code == null ? null : code.copy();
        dst.factor = factor == null ? null : factor.copy();
        dst.amount = amount == null ? null : amount.copy();
      }

      protected MonetaryComponent typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MonetaryComponent))
          return false;
        MonetaryComponent o = (MonetaryComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(code, o.code, true) && compareDeep(factor, o.factor, true)
           && compareDeep(amount, o.amount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MonetaryComponent))
          return false;
        MonetaryComponent o = (MonetaryComponent) other_;
        return compareValues(type, o.type, true) && compareValues(factor, o.factor, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, code, factor, amount
          );
      }


}

