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
 * Generic class defining an interval (i.e. range) of a comparable type. An interval is a contiguous subrange of a comparable base type. Used to define intervals of dates, times, quantities (whose units match) and so on. The type parameter, T, must be a descendant of the type DV_ORDERED, which is necessary (but not sufficient) for instances to be compared (strictly_comparable is also needed).

Without the DV_ORDINAL class, quite a few more DV_ classes would be needed to express logical intervals, namely interval versions of all the date/time classes, and of quantity classes. Further, it allows the semantics of intervals to be stated in one place unequivocally, including the conditions for strict comparison.
 */
@DatatypeDef(name="DV_ORDINAL")
public class DV_ORDINAL extends DV_ORDERED implements ICompositeType {

    /**
     * Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3.
     */
    @Child(name = "symbol", type = {DV_CODED_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Coded textual representation of this value in the enumeration", formalDefinition="Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3." )
    protected DV_CODED_TEXT symbol;

    /**
     * Value in ordered enumeration of values. Any integer value can be used.
     */
    @Child(name = "value", type = {IntegerType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Value in ordered enumeration of values", formalDefinition="Value in ordered enumeration of values. Any integer value can be used." )
    protected IntegerType value;

    private static final long serialVersionUID = -1263083887L;

  /**
   * Constructor
   */
    public DV_ORDINAL() {
      super();
    }

  /**
   * Constructor
   */
    public DV_ORDINAL(DV_CODED_TEXT symbol, int value) {
      super();
      this.setSymbol(symbol);
      this.setValue(value);
    }

    /**
     * @return {@link #symbol} (Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3.)
     */
    public DV_CODED_TEXT getSymbol() { 
      if (this.symbol == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ORDINAL.symbol");
        else if (Configuration.doAutoCreate())
          this.symbol = new DV_CODED_TEXT(); // cc
      return this.symbol;
    }

    public boolean hasSymbol() { 
      return this.symbol != null && !this.symbol.isEmpty();
    }

    /**
     * @param value {@link #symbol} (Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3.)
     */
    public DV_ORDINAL setSymbol(DV_CODED_TEXT value) { 
      this.symbol = value;
      return this;
    }

    /**
     * @return {@link #value} (Value in ordered enumeration of values. Any integer value can be used.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public IntegerType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ORDINAL.value");
        else if (Configuration.doAutoCreate())
          this.value = new IntegerType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (Value in ordered enumeration of values. Any integer value can be used.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DV_ORDINAL setValueElement(IntegerType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return Value in ordered enumeration of values. Any integer value can be used.
     */
    public int getValue() { 
      return this.value == null || this.value.isEmpty() ? 0 : this.value.getValue();
    }

    /**
     * @param value Value in ordered enumeration of values. Any integer value can be used.
     */
    public DV_ORDINAL setValue(int value) { 
        if (this.value == null)
          this.value = new IntegerType();
        this.value.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("symbol", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3.", 0, 1, symbol));
        children.add(new Property("value", "integer", "Value in ordered enumeration of values. Any integer value can be used.", 0, 1, value));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -887523944: /*symbol*/  return new Property("symbol", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Coded textual representation of this value in the enumeration, which may be strings made from + symbols, or other enumerations of terms such as mild, moderate, severe, or even the same number series as the values, e.g. 1, 2, 3.", 0, 1, symbol);
        case 111972721: /*value*/  return new Property("value", "integer", "Value in ordered enumeration of values. Any integer value can be used.", 0, 1, value);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -887523944: /*symbol*/ return this.symbol == null ? new Base[0] : new Base[] {this.symbol}; // DV_CODED_TEXT
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // IntegerType
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
          this.value = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("symbol")) {
          this.symbol = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToInteger(value); // IntegerType
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
        case 111972721: /*value*/ return new String[] {"integer"};
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
          throw new FHIRException("Cannot call addChild on a singleton property DV_ORDINAL.value");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_ORDINAL";

  }

      public DV_ORDINAL copy() {
        DV_ORDINAL dst = new DV_ORDINAL();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_ORDINAL dst) {
        super.copyValues(dst);
        dst.symbol = symbol == null ? null : symbol.copy();
        dst.value = value == null ? null : value.copy();
      }

      protected DV_ORDINAL typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_ORDINAL))
          return false;
        DV_ORDINAL o = (DV_ORDINAL) other_;
        return compareDeep(symbol, o.symbol, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_ORDINAL))
          return false;
        DV_ORDINAL o = (DV_ORDINAL) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(symbol, value);
      }


}

