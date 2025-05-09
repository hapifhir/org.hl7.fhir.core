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
 * Countable quantities. Used for countable types such as pregnancies and steps (taken by a physiotherapy patient), number of cigarettes smoked in a day.
 */
@DatatypeDef(name="DV_COUNT")
public class DV_COUNT extends DV_AMOUNT implements ICompositeType {

    /**
     * Numeric magnitude.
     */
    @Child(name = "magnitude", type = {DecimalType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Numeric magnitude", formalDefinition="Numeric magnitude." )
    protected DecimalType magnitude;

    private static final long serialVersionUID = -829015249L;

  /**
   * Constructor
   */
    public DV_COUNT() {
      super();
    }

  /**
   * Constructor
   */
    public DV_COUNT(BigDecimal magnitude) {
      super();
      this.setMagnitude(magnitude);
    }

    /**
     * @return {@link #magnitude} (Numeric magnitude.). This is the underlying object with id, value and extensions. The accessor "getMagnitude" gives direct access to the value
     */
    public DecimalType getMagnitudeElement() { 
      if (this.magnitude == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_COUNT.magnitude");
        else if (Configuration.doAutoCreate())
          this.magnitude = new DecimalType(); // bb
      return this.magnitude;
    }

    public boolean hasMagnitudeElement() { 
      return this.magnitude != null && !this.magnitude.isEmpty();
    }

    public boolean hasMagnitude() { 
      return this.magnitude != null && !this.magnitude.isEmpty();
    }

    /**
     * @param value {@link #magnitude} (Numeric magnitude.). This is the underlying object with id, value and extensions. The accessor "getMagnitude" gives direct access to the value
     */
    public DV_COUNT setMagnitudeElement(DecimalType value) { 
      this.magnitude = value;
      return this;
    }

    /**
     * @return Numeric magnitude.
     */
    public BigDecimal getMagnitude() { 
      return this.magnitude == null ? null : this.magnitude.getValue();
    }

    /**
     * @param value Numeric magnitude.
     */
    public DV_COUNT setMagnitude(BigDecimal value) { 
        if (this.magnitude == null)
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

    /**
     * @param value Numeric magnitude.
     */
    public DV_COUNT setMagnitude(long value) { 
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

    /**
     * @param value Numeric magnitude.
     */
    public DV_COUNT setMagnitude(double value) { 
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("magnitude", "decimal", "Numeric magnitude.", 0, 1, magnitude));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -2016783856: /*magnitude*/  return new Property("magnitude", "decimal", "Numeric magnitude.", 0, 1, magnitude);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -2016783856: /*magnitude*/ return this.magnitude == null ? new Base[0] : new Base[] {this.magnitude}; // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -2016783856: // magnitude
          this.magnitude = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("magnitude")) {
          this.magnitude = TypeConvertor.castToDecimal(value); // DecimalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2016783856:  return getMagnitudeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2016783856: /*magnitude*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("magnitude")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_COUNT.magnitude");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_COUNT";

  }

      public DV_COUNT copy() {
        DV_COUNT dst = new DV_COUNT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_COUNT dst) {
        super.copyValues(dst);
        dst.magnitude = magnitude == null ? null : magnitude.copy();
      }

      protected DV_COUNT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_COUNT))
          return false;
        DV_COUNT o = (DV_COUNT) other_;
        return compareDeep(magnitude, o.magnitude, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_COUNT))
          return false;
        DV_COUNT o = (DV_COUNT) other_;
        return compareValues(magnitude, o.magnitude, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(magnitude);
      }


}

