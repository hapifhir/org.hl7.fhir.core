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
 * Abstract class defining the concept of true quantified values, i.e. values which are not only ordered, but which have a precise magnitude.
 */
@DatatypeDef(name="DV_QUANTIFIED")
public abstract class DV_QUANTIFIED extends DV_ORDERED implements ICompositeType {

    /**
     * Optional status of magnitude with values:
* '=' : magnitude is a point value
* '<' : value is < magnitude
* '>' : value is > magnitude
* '<=' : value is <= magnitude
* '>=' : value is >= magnitude
* '~' : value is approximately magnitude

If not present, assumed meaning is '=' .
     */
    @Child(name = "magnitude_status", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional status of magnitude: =, <, >, <=, >=, ~", formalDefinition="Optional status of magnitude with values:\r\n* '=' : magnitude is a point value\r\n* '<' : value is < magnitude\r\n* '>' : value is > magnitude\r\n* '<=' : value is <= magnitude\r\n* '>=' : value is >= magnitude\r\n* '~' : value is approximately magnitude\r\n\r\nIf not present, assumed meaning is '=' ." )
    protected StringType magnitude_status;

    /**
     * Accuracy of measurement. Exact form of expression determined in descendants.
     */
    @Child(name = "accuracy", type = {Base.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Accuracy of measurement. Exact form of expression determined in descendants", formalDefinition="Accuracy of measurement. Exact form of expression determined in descendants." )
    protected Base accuracy;

    private static final long serialVersionUID = 1989595286L;

  /**
   * Constructor
   */
    public DV_QUANTIFIED() {
      super();
    }

    /**
     * @return {@link #magnitude_status} (Optional status of magnitude with values:
* '=' : magnitude is a point value
* '<' : value is < magnitude
* '>' : value is > magnitude
* '<=' : value is <= magnitude
* '>=' : value is >= magnitude
* '~' : value is approximately magnitude

If not present, assumed meaning is '=' .). This is the underlying object with id, value and extensions. The accessor "getMagnitude_status" gives direct access to the value
     */
    public StringType getMagnitude_statusElement() { 
      if (this.magnitude_status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTIFIED.magnitude_status");
        else if (Configuration.doAutoCreate())
          this.magnitude_status = new StringType(); // bb
      return this.magnitude_status;
    }

    public boolean hasMagnitude_statusElement() { 
      return this.magnitude_status != null && !this.magnitude_status.isEmpty();
    }

    public boolean hasMagnitude_status() { 
      return this.magnitude_status != null && !this.magnitude_status.isEmpty();
    }

    /**
     * @param value {@link #magnitude_status} (Optional status of magnitude with values:
* '=' : magnitude is a point value
* '<' : value is < magnitude
* '>' : value is > magnitude
* '<=' : value is <= magnitude
* '>=' : value is >= magnitude
* '~' : value is approximately magnitude

If not present, assumed meaning is '=' .). This is the underlying object with id, value and extensions. The accessor "getMagnitude_status" gives direct access to the value
     */
    public DV_QUANTIFIED setMagnitude_statusElement(StringType value) { 
      this.magnitude_status = value;
      return this;
    }

    /**
     * @return Optional status of magnitude with values:
* '=' : magnitude is a point value
* '<' : value is < magnitude
* '>' : value is > magnitude
* '<=' : value is <= magnitude
* '>=' : value is >= magnitude
* '~' : value is approximately magnitude

If not present, assumed meaning is '=' .
     */
    public String getMagnitude_status() { 
      return this.magnitude_status == null ? null : this.magnitude_status.getValue();
    }

    /**
     * @param value Optional status of magnitude with values:
* '=' : magnitude is a point value
* '<' : value is < magnitude
* '>' : value is > magnitude
* '<=' : value is <= magnitude
* '>=' : value is >= magnitude
* '~' : value is approximately magnitude

If not present, assumed meaning is '=' .
     */
    public DV_QUANTIFIED setMagnitude_status(String value) { 
      if (Utilities.noString(value))
        this.magnitude_status = null;
      else {
        if (this.magnitude_status == null)
          this.magnitude_status = new StringType();
        this.magnitude_status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #accuracy} (Accuracy of measurement. Exact form of expression determined in descendants.)
     */
    public Base getAccuracy() { 
      return this.accuracy;
    }

    public boolean hasAccuracy() { 
      return this.accuracy != null && !this.accuracy.isEmpty();
    }

    /**
     * @param value {@link #accuracy} (Accuracy of measurement. Exact form of expression determined in descendants.)
     */
    public DV_QUANTIFIED setAccuracy(Base value) { 
      this.accuracy = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("magnitude_status", "string", "Optional status of magnitude with values:\r\n* '=' : magnitude is a point value\r\n* '<' : value is < magnitude\r\n* '>' : value is > magnitude\r\n* '<=' : value is <= magnitude\r\n* '>=' : value is >= magnitude\r\n* '~' : value is approximately magnitude\r\n\r\nIf not present, assumed meaning is '=' .", 0, 1, magnitude_status));
        children.add(new Property("accuracy", "Base", "Accuracy of measurement. Exact form of expression determined in descendants.", 0, 1, accuracy));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 195430657: /*magnitude_status*/  return new Property("magnitude_status", "string", "Optional status of magnitude with values:\r\n* '=' : magnitude is a point value\r\n* '<' : value is < magnitude\r\n* '>' : value is > magnitude\r\n* '<=' : value is <= magnitude\r\n* '>=' : value is >= magnitude\r\n* '~' : value is approximately magnitude\r\n\r\nIf not present, assumed meaning is '=' .", 0, 1, magnitude_status);
        case -2131707655: /*accuracy*/  return new Property("accuracy", "Base", "Accuracy of measurement. Exact form of expression determined in descendants.", 0, 1, accuracy);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 195430657: /*magnitude_status*/ return this.magnitude_status == null ? new Base[0] : new Base[] {this.magnitude_status}; // StringType
        case -2131707655: /*accuracy*/ return this.accuracy == null ? new Base[0] : new Base[] {this.accuracy}; // Base
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 195430657: // magnitude_status
          this.magnitude_status = TypeConvertor.castToString(value); // StringType
          return value;
        case -2131707655: // accuracy
          this.accuracy = (Base) value; // Base
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("magnitude_status")) {
          this.magnitude_status = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("accuracy")) {
          this.accuracy = (Base) value; // Base
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 195430657:  return getMagnitude_statusElement();
        case -2131707655: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'accuracy'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 195430657: /*magnitude_status*/ return new String[] {"string"};
        case -2131707655: /*accuracy*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("magnitude_status")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTIFIED.magnitude_status");
        }
        else if (name.equals("accuracy")) {
          throw new FHIRException("Cannot call addChild on an abstract type DV_QUANTIFIED.accuracy");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_QUANTIFIED";

  }

      public abstract DV_QUANTIFIED copy();

      public void copyValues(DV_QUANTIFIED dst) {
        super.copyValues(dst);
        dst.magnitude_status = magnitude_status == null ? null : magnitude_status.copy();
        dst.accuracy = accuracy == null ? null : accuracy.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_QUANTIFIED))
          return false;
        DV_QUANTIFIED o = (DV_QUANTIFIED) other_;
        return compareDeep(magnitude_status, o.magnitude_status, true) && compareDeep(accuracy, o.accuracy, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_QUANTIFIED))
          return false;
        DV_QUANTIFIED o = (DV_QUANTIFIED) other_;
        return compareValues(magnitude_status, o.magnitude_status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(magnitude_status, accuracy
          );
      }


}

