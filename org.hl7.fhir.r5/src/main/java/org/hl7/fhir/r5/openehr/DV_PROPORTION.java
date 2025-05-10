package org.hl7.fhir.r5.openehr;


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
import java.math.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Countable quantities. Used for countable types such as pregnancies and steps (taken by a physiotherapy patient), number of cigarettes smoked in a day.
 */
@DatatypeDef(name="DV_PROPORTION")
public class DV_PROPORTION extends DV_AMOUNT implements ICompositeType {

    /**
     * Numerator of ratio.
     */
    @Child(name = "numerator", type = {DecimalType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Numerator of ratio", formalDefinition="Numerator of ratio." )
    protected DecimalType numerator;

    /**
     * Denominator of ratio.
     */
    @Child(name = "denominator", type = {DecimalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Denominator of ratio", formalDefinition="Denominator of ratio." )
    protected DecimalType denominator;

    /**
     * Indicates semantic type of proportion, including percent, unitary etc.
     */
    @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates semantic type of proportion, including percent, unitary etc", formalDefinition="Indicates semantic type of proportion, including percent, unitary etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-proportion_kind")
    protected CodeType type;

    /**
     * Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.
     */
    @Child(name = "precision", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places", formalDefinition="Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places." )
    protected IntegerType precision;

    private static final long serialVersionUID = 398780922L;

  /**
   * Constructor
   */
    public DV_PROPORTION() {
      super();
    }

  /**
   * Constructor
   */
    public DV_PROPORTION(BigDecimal numerator, BigDecimal denominator, String type) {
      super();
      this.setNumerator(numerator);
      this.setDenominator(denominator);
      this.setType(type);
    }

    /**
     * @return {@link #numerator} (Numerator of ratio.). This is the underlying object with id, value and extensions. The accessor "getNumerator" gives direct access to the value
     */
    public DecimalType getNumeratorElement() { 
      if (this.numerator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PROPORTION.numerator");
        else if (Configuration.doAutoCreate())
          this.numerator = new DecimalType(); // bb
      return this.numerator;
    }

    public boolean hasNumeratorElement() { 
      return this.numerator != null && !this.numerator.isEmpty();
    }

    public boolean hasNumerator() { 
      return this.numerator != null && !this.numerator.isEmpty();
    }

    /**
     * @param value {@link #numerator} (Numerator of ratio.). This is the underlying object with id, value and extensions. The accessor "getNumerator" gives direct access to the value
     */
    public DV_PROPORTION setNumeratorElement(DecimalType value) { 
      this.numerator = value;
      return this;
    }

    /**
     * @return Numerator of ratio.
     */
    public BigDecimal getNumerator() { 
      return this.numerator == null ? null : this.numerator.getValue();
    }

    /**
     * @param value Numerator of ratio.
     */
    public DV_PROPORTION setNumerator(BigDecimal value) { 
        if (this.numerator == null)
          this.numerator = new DecimalType();
        this.numerator.setValue(value);
      return this;
    }

    /**
     * @param value Numerator of ratio.
     */
    public DV_PROPORTION setNumerator(long value) { 
          this.numerator = new DecimalType();
        this.numerator.setValue(value);
      return this;
    }

    /**
     * @param value Numerator of ratio.
     */
    public DV_PROPORTION setNumerator(double value) { 
          this.numerator = new DecimalType();
        this.numerator.setValue(value);
      return this;
    }

    /**
     * @return {@link #denominator} (Denominator of ratio.). This is the underlying object with id, value and extensions. The accessor "getDenominator" gives direct access to the value
     */
    public DecimalType getDenominatorElement() { 
      if (this.denominator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PROPORTION.denominator");
        else if (Configuration.doAutoCreate())
          this.denominator = new DecimalType(); // bb
      return this.denominator;
    }

    public boolean hasDenominatorElement() { 
      return this.denominator != null && !this.denominator.isEmpty();
    }

    public boolean hasDenominator() { 
      return this.denominator != null && !this.denominator.isEmpty();
    }

    /**
     * @param value {@link #denominator} (Denominator of ratio.). This is the underlying object with id, value and extensions. The accessor "getDenominator" gives direct access to the value
     */
    public DV_PROPORTION setDenominatorElement(DecimalType value) { 
      this.denominator = value;
      return this;
    }

    /**
     * @return Denominator of ratio.
     */
    public BigDecimal getDenominator() { 
      return this.denominator == null ? null : this.denominator.getValue();
    }

    /**
     * @param value Denominator of ratio.
     */
    public DV_PROPORTION setDenominator(BigDecimal value) { 
        if (this.denominator == null)
          this.denominator = new DecimalType();
        this.denominator.setValue(value);
      return this;
    }

    /**
     * @param value Denominator of ratio.
     */
    public DV_PROPORTION setDenominator(long value) { 
          this.denominator = new DecimalType();
        this.denominator.setValue(value);
      return this;
    }

    /**
     * @param value Denominator of ratio.
     */
    public DV_PROPORTION setDenominator(double value) { 
          this.denominator = new DecimalType();
        this.denominator.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (Indicates semantic type of proportion, including percent, unitary etc.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public CodeType getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PROPORTION.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeType(); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Indicates semantic type of proportion, including percent, unitary etc.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public DV_PROPORTION setTypeElement(CodeType value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Indicates semantic type of proportion, including percent, unitary etc.
     */
    public String getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Indicates semantic type of proportion, including percent, unitary etc.
     */
    public DV_PROPORTION setType(String value) { 
        if (this.type == null)
          this.type = new CodeType();
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #precision} (Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public IntegerType getPrecisionElement() { 
      if (this.precision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PROPORTION.precision");
        else if (Configuration.doAutoCreate())
          this.precision = new IntegerType(); // bb
      return this.precision;
    }

    public boolean hasPrecisionElement() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    public boolean hasPrecision() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    /**
     * @param value {@link #precision} (Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public DV_PROPORTION setPrecisionElement(IntegerType value) { 
      this.precision = value;
      return this;
    }

    /**
     * @return Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.
     */
    public int getPrecision() { 
      return this.precision == null || this.precision.isEmpty() ? 0 : this.precision.getValue();
    }

    /**
     * @param value Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.
     */
    public DV_PROPORTION setPrecision(int value) { 
        if (this.precision == null)
          this.precision = new IntegerType();
        this.precision.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("numerator", "decimal", "Numerator of ratio.", 0, 1, numerator));
        children.add(new Property("denominator", "decimal", "Denominator of ratio.", 0, 1, denominator));
        children.add(new Property("type", "code", "Indicates semantic type of proportion, including percent, unitary etc.", 0, 1, type));
        children.add(new Property("precision", "integer", "Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.", 0, 1, precision));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1747334793: /*numerator*/  return new Property("numerator", "decimal", "Numerator of ratio.", 0, 1, numerator);
        case -1983274394: /*denominator*/  return new Property("denominator", "decimal", "Denominator of ratio.", 0, 1, denominator);
        case 3575610: /*type*/  return new Property("type", "code", "Indicates semantic type of proportion, including percent, unitary etc.", 0, 1, type);
        case -1376177026: /*precision*/  return new Property("precision", "integer", "Precision to which the numerator and denominator values of the proportion are expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places.", 0, 1, precision);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1747334793: /*numerator*/ return this.numerator == null ? new Base[0] : new Base[] {this.numerator}; // DecimalType
        case -1983274394: /*denominator*/ return this.denominator == null ? new Base[0] : new Base[] {this.denominator}; // DecimalType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeType
        case -1376177026: /*precision*/ return this.precision == null ? new Base[0] : new Base[] {this.precision}; // IntegerType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1747334793: // numerator
          this.numerator = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1983274394: // denominator
          this.denominator = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1376177026: // precision
          this.precision = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("numerator")) {
          this.numerator = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("denominator")) {
          this.denominator = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("precision")) {
          this.precision = TypeConvertor.castToInteger(value); // IntegerType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1747334793:  return getNumeratorElement();
        case -1983274394:  return getDenominatorElement();
        case 3575610:  return getTypeElement();
        case -1376177026:  return getPrecisionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1747334793: /*numerator*/ return new String[] {"decimal"};
        case -1983274394: /*denominator*/ return new String[] {"decimal"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -1376177026: /*precision*/ return new String[] {"integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("numerator")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PROPORTION.numerator");
        }
        else if (name.equals("denominator")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PROPORTION.denominator");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PROPORTION.type");
        }
        else if (name.equals("precision")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PROPORTION.precision");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_PROPORTION";

  }

      public DV_PROPORTION copy() {
        DV_PROPORTION dst = new DV_PROPORTION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_PROPORTION dst) {
        super.copyValues(dst);
        dst.numerator = numerator == null ? null : numerator.copy();
        dst.denominator = denominator == null ? null : denominator.copy();
        dst.type = type == null ? null : type.copy();
        dst.precision = precision == null ? null : precision.copy();
      }

      protected DV_PROPORTION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_PROPORTION))
          return false;
        DV_PROPORTION o = (DV_PROPORTION) other_;
        return compareDeep(numerator, o.numerator, true) && compareDeep(denominator, o.denominator, true)
           && compareDeep(type, o.type, true) && compareDeep(precision, o.precision, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_PROPORTION))
          return false;
        DV_PROPORTION o = (DV_PROPORTION) other_;
        return compareValues(numerator, o.numerator, true) && compareValues(denominator, o.denominator, true)
           && compareValues(type, o.type, true) && compareValues(precision, o.precision, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(numerator, denominator, type
          , precision);
      }


}

