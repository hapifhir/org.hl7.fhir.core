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
 * A data type that represents scale values, where there is:

a) implied ordering, b) no implication that the distance between each value is constant, and c) the total number of values is finite; d) non-integer values are allowed.

  Example:
````  
  Borg CR 10 Scale
  
  0    No Breathlessness at all
  0.5  Very Very Slight (Just Noticeable)
  1    Very Slight
  2    Slight Breathlessness
  3    Moderate
  ... etc
````

For scores that include only Integers, DV_SCALE may also be used, but DV_ORDINAL should be supported to accommodate existing data instances of that type.
 */
@DatatypeDef(name="DV_SCALE")
public class DV_SCALE extends DV_ORDERED implements ICompositeType {

    /**
     * Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.

In some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string.
     */
    @Child(name = "symbol", type = {DV_CODED_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms", formalDefinition="Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.\r\n\r\nIn some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string." )
    protected DV_CODED_TEXT symbol;

    /**
     * Real number value of Scale item.
     */
    @Child(name = "value", type = {DecimalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Real number value of Scale item", formalDefinition="Real number value of Scale item." )
    protected DecimalType value;

    private static final long serialVersionUID = -1085111458L;

  /**
   * Constructor
   */
    public DV_SCALE() {
      super();
    }

  /**
   * Constructor
   */
    public DV_SCALE(DV_CODED_TEXT symbol, BigDecimal value) {
      super();
      this.setSymbol(symbol);
      this.setValue(value);
    }

    /**
     * @return {@link #symbol} (Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.

In some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string.)
     */
    public DV_CODED_TEXT getSymbol() { 
      if (this.symbol == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_SCALE.symbol");
        else if (Configuration.doAutoCreate())
          this.symbol = new DV_CODED_TEXT(); // cc
      return this.symbol;
    }

    public boolean hasSymbol() { 
      return this.symbol != null && !this.symbol.isEmpty();
    }

    /**
     * @param value {@link #symbol} (Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.

In some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string.)
     */
    public DV_SCALE setSymbol(DV_CODED_TEXT value) { 
      this.symbol = value;
      return this;
    }

    /**
     * @return {@link #value} (Real number value of Scale item.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DecimalType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_SCALE.value");
        else if (Configuration.doAutoCreate())
          this.value = new DecimalType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (Real number value of Scale item.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DV_SCALE setValueElement(DecimalType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return Real number value of Scale item.
     */
    public BigDecimal getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value Real number value of Scale item.
     */
    public DV_SCALE setValue(BigDecimal value) { 
        if (this.value == null)
          this.value = new DecimalType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @param value Real number value of Scale item.
     */
    public DV_SCALE setValue(long value) { 
          this.value = new DecimalType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @param value Real number value of Scale item.
     */
    public DV_SCALE setValue(double value) { 
          this.value = new DecimalType();
        this.value.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("symbol", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.\r\n\r\nIn some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string.", 0, 1, symbol));
        children.add(new Property("value", "decimal", "Real number value of Scale item.", 0, 1, value));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -887523944: /*symbol*/  return new Property("symbol", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Coded textual representation of this value in the scale range, which may be strings made from symbols or other enumerations of terms such as no breathlessness, very very slight, slight breathlessness. Codes come from archetypes.\r\n\r\nIn some cases, a scale may include values that have no code/symbol. In this case, the symbol will be a DV-CODED-TEXT including the terminology_id and a blank String value for code_string.", 0, 1, symbol);
        case 111972721: /*value*/  return new Property("value", "decimal", "Real number value of Scale item.", 0, 1, value);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -887523944: /*symbol*/ return this.symbol == null ? new Base[0] : new Base[] {this.symbol}; // DV_CODED_TEXT
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -887523944: // symbol
          this.symbol = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("symbol")) {
          this.symbol = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToDecimal(value); // DecimalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -887523944:  return getSymbol();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -887523944: /*symbol*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case 111972721: /*value*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("symbol")) {
          this.symbol = new DV_CODED_TEXT();
          return this.symbol;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_SCALE.value");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_SCALE";

  }

      public DV_SCALE copy() {
        DV_SCALE dst = new DV_SCALE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_SCALE dst) {
        super.copyValues(dst);
        dst.symbol = symbol == null ? null : symbol.copy();
        dst.value = value == null ? null : value.copy();
      }

      protected DV_SCALE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_SCALE))
          return false;
        DV_SCALE o = (DV_SCALE) other_;
        return compareDeep(symbol, o.symbol, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_SCALE))
          return false;
        DV_SCALE o = (DV_SCALE) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(symbol, value);
      }


}

