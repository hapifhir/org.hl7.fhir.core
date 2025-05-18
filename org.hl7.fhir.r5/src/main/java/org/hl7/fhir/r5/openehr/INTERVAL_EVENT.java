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
 * Defines a single interval event in a series.
 */
@DatatypeDef(name="INTERVAL_EVENT")
public class INTERVAL_EVENT extends EVENT implements ICompositeType {

    /**
     * Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event.
     */
    @Child(name = "width", type = {DV_DURATION.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Duration of the time interval during which the values recorded under data are true", formalDefinition="Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event." )
    protected DV_DURATION width;

    /**
     * Optional count of original samples to which this event corresponds.
     */
    @Child(name = "sample_count", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional count of original samples to which this event corresponds", formalDefinition="Optional count of original samples to which this event corresponds." )
    protected IntegerType sample_count;

    /**
     * Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'.
     */
    @Child(name = "math_function", type = {DV_CODED_TEXT.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Mathematical function of the data of this event", formalDefinition="Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-event_math_function")
    protected DV_CODED_TEXT math_function;

    private static final long serialVersionUID = 1763307354L;

  /**
   * Constructor
   */
    public INTERVAL_EVENT() {
      super();
    }

  /**
   * Constructor
   */
    public INTERVAL_EVENT(DV_DURATION width, DV_CODED_TEXT math_function) {
      super();
      this.setWidth(width);
      this.setMath_function(math_function);
    }

    /**
     * @return {@link #width} (Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event.)
     */
    public DV_DURATION getWidth() { 
      if (this.width == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INTERVAL_EVENT.width");
        else if (Configuration.doAutoCreate())
          this.width = new DV_DURATION(); // cc
      return this.width;
    }

    public boolean hasWidth() { 
      return this.width != null && !this.width.isEmpty();
    }

    /**
     * @param value {@link #width} (Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event.)
     */
    public INTERVAL_EVENT setWidth(DV_DURATION value) { 
      this.width = value;
      return this;
    }

    /**
     * @return {@link #sample_count} (Optional count of original samples to which this event corresponds.). This is the underlying object with id, value and extensions. The accessor "getSample_count" gives direct access to the value
     */
    public IntegerType getSample_countElement() { 
      if (this.sample_count == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INTERVAL_EVENT.sample_count");
        else if (Configuration.doAutoCreate())
          this.sample_count = new IntegerType(); // bb
      return this.sample_count;
    }

    public boolean hasSample_countElement() { 
      return this.sample_count != null && !this.sample_count.isEmpty();
    }

    public boolean hasSample_count() { 
      return this.sample_count != null && !this.sample_count.isEmpty();
    }

    /**
     * @param value {@link #sample_count} (Optional count of original samples to which this event corresponds.). This is the underlying object with id, value and extensions. The accessor "getSample_count" gives direct access to the value
     */
    public INTERVAL_EVENT setSample_countElement(IntegerType value) { 
      this.sample_count = value;
      return this;
    }

    /**
     * @return Optional count of original samples to which this event corresponds.
     */
    public int getSample_count() { 
      return this.sample_count == null || this.sample_count.isEmpty() ? 0 : this.sample_count.getValue();
    }

    /**
     * @param value Optional count of original samples to which this event corresponds.
     */
    public INTERVAL_EVENT setSample_count(int value) { 
        if (this.sample_count == null)
          this.sample_count = new IntegerType();
        this.sample_count.setValue(value);
      return this;
    }

    /**
     * @return {@link #math_function} (Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'.)
     */
    public DV_CODED_TEXT getMath_function() { 
      if (this.math_function == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INTERVAL_EVENT.math_function");
        else if (Configuration.doAutoCreate())
          this.math_function = new DV_CODED_TEXT(); // cc
      return this.math_function;
    }

    public boolean hasMath_function() { 
      return this.math_function != null && !this.math_function.isEmpty();
    }

    /**
     * @param value {@link #math_function} (Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'.)
     */
    public INTERVAL_EVENT setMath_function(DV_CODED_TEXT value) { 
      this.math_function = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("width", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event.", 0, 1, width));
        children.add(new Property("sample_count", "integer", "Optional count of original samples to which this event corresponds.", 0, 1, sample_count));
        children.add(new Property("math_function", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'.", 0, 1, math_function));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 113126854: /*width*/  return new Property("width", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Duration of the time interval during which the values recorded under data are true and, if set, the values recorded under state are true. Void if an instantaneous event.", 0, 1, width);
        case 440582714: /*sample_count*/  return new Property("sample_count", "integer", "Optional count of original samples to which this event corresponds.", 0, 1, sample_count);
        case -2059073745: /*math_function*/  return new Property("math_function", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Mathematical function of the data of this event, e.g. maximum, mean etc. Coded using openEHR vocabulary event math function. Default value 640|actual|, meaning 'actual value'.", 0, 1, math_function);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 113126854: /*width*/ return this.width == null ? new Base[0] : new Base[] {this.width}; // DV_DURATION
        case 440582714: /*sample_count*/ return this.sample_count == null ? new Base[0] : new Base[] {this.sample_count}; // IntegerType
        case -2059073745: /*math_function*/ return this.math_function == null ? new Base[0] : new Base[] {this.math_function}; // DV_CODED_TEXT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 113126854: // width
          this.width = (DV_DURATION) value; // DV_DURATION
          return value;
        case 440582714: // sample_count
          this.sample_count = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -2059073745: // math_function
          this.math_function = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("width")) {
          this.width = (DV_DURATION) value; // DV_DURATION
        } else if (name.equals("sample_count")) {
          this.sample_count = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("math_function")) {
          this.math_function = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 113126854:  return getWidth();
        case 440582714:  return getSample_countElement();
        case -2059073745:  return getMath_function();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 113126854: /*width*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DURATION"};
        case 440582714: /*sample_count*/ return new String[] {"integer"};
        case -2059073745: /*math_function*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("width")) {
          this.width = new DV_DURATION();
          return this.width;
        }
        else if (name.equals("sample_count")) {
          throw new FHIRException("Cannot call addChild on a singleton property INTERVAL_EVENT.sample_count");
        }
        else if (name.equals("math_function")) {
          this.math_function = new DV_CODED_TEXT();
          return this.math_function;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "INTERVAL_EVENT";

  }

      public INTERVAL_EVENT copy() {
        INTERVAL_EVENT dst = new INTERVAL_EVENT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(INTERVAL_EVENT dst) {
        super.copyValues(dst);
        dst.width = width == null ? null : width.copy();
        dst.sample_count = sample_count == null ? null : sample_count.copy();
        dst.math_function = math_function == null ? null : math_function.copy();
      }

      protected INTERVAL_EVENT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof INTERVAL_EVENT))
          return false;
        INTERVAL_EVENT o = (INTERVAL_EVENT) other_;
        return compareDeep(width, o.width, true) && compareDeep(sample_count, o.sample_count, true) && compareDeep(math_function, o.math_function, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof INTERVAL_EVENT))
          return false;
        INTERVAL_EVENT o = (INTERVAL_EVENT) other_;
        return compareValues(sample_count, o.sample_count, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(width, sample_count, math_function
          );
      }


}

