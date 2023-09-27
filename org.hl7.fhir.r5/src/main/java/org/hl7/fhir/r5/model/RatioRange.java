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
 * RatioRange Type: A range of ratios expressed as a low and high numerator and a denominator.
 */
@DatatypeDef(name="RatioRange")
public class RatioRange extends DataType implements ICompositeType {

    /**
     * The value of the low limit numerator.
     */
    @Child(name = "lowNumerator", type = {Quantity.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Low Numerator limit", formalDefinition="The value of the low limit numerator." )
    protected Quantity lowNumerator;

    /**
     * The value of the high limit numerator.
     */
    @Child(name = "highNumerator", type = {Quantity.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="High Numerator limit", formalDefinition="The value of the high limit numerator." )
    protected Quantity highNumerator;

    /**
     * The value of the denominator.
     */
    @Child(name = "denominator", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Denominator value", formalDefinition="The value of the denominator." )
    protected Quantity denominator;

    private static final long serialVersionUID = -1691080287L;

  /**
   * Constructor
   */
    public RatioRange() {
      super();
    }

    /**
     * @return {@link #lowNumerator} (The value of the low limit numerator.)
     */
    public Quantity getLowNumerator() { 
      if (this.lowNumerator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RatioRange.lowNumerator");
        else if (Configuration.doAutoCreate())
          this.lowNumerator = new Quantity(); // cc
      return this.lowNumerator;
    }

    public boolean hasLowNumerator() { 
      return this.lowNumerator != null && !this.lowNumerator.isEmpty();
    }

    /**
     * @param value {@link #lowNumerator} (The value of the low limit numerator.)
     */
    public RatioRange setLowNumerator(Quantity value) { 
      this.lowNumerator = value;
      return this;
    }

    /**
     * @return {@link #highNumerator} (The value of the high limit numerator.)
     */
    public Quantity getHighNumerator() { 
      if (this.highNumerator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RatioRange.highNumerator");
        else if (Configuration.doAutoCreate())
          this.highNumerator = new Quantity(); // cc
      return this.highNumerator;
    }

    public boolean hasHighNumerator() { 
      return this.highNumerator != null && !this.highNumerator.isEmpty();
    }

    /**
     * @param value {@link #highNumerator} (The value of the high limit numerator.)
     */
    public RatioRange setHighNumerator(Quantity value) { 
      this.highNumerator = value;
      return this;
    }

    /**
     * @return {@link #denominator} (The value of the denominator.)
     */
    public Quantity getDenominator() { 
      if (this.denominator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RatioRange.denominator");
        else if (Configuration.doAutoCreate())
          this.denominator = new Quantity(); // cc
      return this.denominator;
    }

    public boolean hasDenominator() { 
      return this.denominator != null && !this.denominator.isEmpty();
    }

    /**
     * @param value {@link #denominator} (The value of the denominator.)
     */
    public RatioRange setDenominator(Quantity value) { 
      this.denominator = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("lowNumerator", "Quantity", "The value of the low limit numerator.", 0, 1, lowNumerator));
        children.add(new Property("highNumerator", "Quantity", "The value of the high limit numerator.", 0, 1, highNumerator));
        children.add(new Property("denominator", "Quantity", "The value of the denominator.", 0, 1, denominator));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1003958677: /*lowNumerator*/  return new Property("lowNumerator", "Quantity", "The value of the low limit numerator.", 0, 1, lowNumerator);
        case 311013127: /*highNumerator*/  return new Property("highNumerator", "Quantity", "The value of the high limit numerator.", 0, 1, highNumerator);
        case -1983274394: /*denominator*/  return new Property("denominator", "Quantity", "The value of the denominator.", 0, 1, denominator);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1003958677: /*lowNumerator*/ return this.lowNumerator == null ? new Base[0] : new Base[] {this.lowNumerator}; // Quantity
        case 311013127: /*highNumerator*/ return this.highNumerator == null ? new Base[0] : new Base[] {this.highNumerator}; // Quantity
        case -1983274394: /*denominator*/ return this.denominator == null ? new Base[0] : new Base[] {this.denominator}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1003958677: // lowNumerator
          this.lowNumerator = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 311013127: // highNumerator
          this.highNumerator = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1983274394: // denominator
          this.denominator = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("lowNumerator")) {
          this.lowNumerator = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("highNumerator")) {
          this.highNumerator = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("denominator")) {
          this.denominator = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("lowNumerator")) {
          this.lowNumerator = null;
        } else if (name.equals("highNumerator")) {
          this.highNumerator = null;
        } else if (name.equals("denominator")) {
          this.denominator = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1003958677:  return getLowNumerator();
        case 311013127:  return getHighNumerator();
        case -1983274394:  return getDenominator();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1003958677: /*lowNumerator*/ return new String[] {"Quantity"};
        case 311013127: /*highNumerator*/ return new String[] {"Quantity"};
        case -1983274394: /*denominator*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("lowNumerator")) {
          this.lowNumerator = new Quantity();
          return this.lowNumerator;
        }
        else if (name.equals("highNumerator")) {
          this.highNumerator = new Quantity();
          return this.highNumerator;
        }
        else if (name.equals("denominator")) {
          this.denominator = new Quantity();
          return this.denominator;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RatioRange";

  }

      public RatioRange copy() {
        RatioRange dst = new RatioRange();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RatioRange dst) {
        super.copyValues(dst);
        dst.lowNumerator = lowNumerator == null ? null : lowNumerator.copy();
        dst.highNumerator = highNumerator == null ? null : highNumerator.copy();
        dst.denominator = denominator == null ? null : denominator.copy();
      }

      protected RatioRange typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RatioRange))
          return false;
        RatioRange o = (RatioRange) other_;
        return compareDeep(lowNumerator, o.lowNumerator, true) && compareDeep(highNumerator, o.highNumerator, true)
           && compareDeep(denominator, o.denominator, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RatioRange))
          return false;
        RatioRange o = (RatioRange) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(lowNumerator, highNumerator
          , denominator);
      }


}

