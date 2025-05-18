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
 * Abstract class defining the concept of relative quantified 'amounts'. For relative quantities, the + and - operators are defined (unlike descendants of DV_ABSOLUTE_QUANTITY, such as the date/time types).
 */
@DatatypeDef(name="DV_AMOUNT")
public abstract class DV_AMOUNT extends DV_QUANTIFIED implements ICompositeType {

    /**
     * If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.
     */
    @Child(name = "accuracy_is_percent", type = {BooleanType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value", formalDefinition="If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value." )
    protected BooleanType accuracy_is_percent;

    private static final long serialVersionUID = 421282386L;

  /**
   * Constructor
   */
    public DV_AMOUNT() {
      super();
    }

    /**
     * @return {@link #accuracy_is_percent} (If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.). This is the underlying object with id, value and extensions. The accessor "getAccuracy_is_percent" gives direct access to the value
     */
    public BooleanType getAccuracy_is_percentElement() { 
      if (this.accuracy_is_percent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_AMOUNT.accuracy_is_percent");
        else if (Configuration.doAutoCreate())
          this.accuracy_is_percent = new BooleanType(); // bb
      return this.accuracy_is_percent;
    }

    public boolean hasAccuracy_is_percentElement() { 
      return this.accuracy_is_percent != null && !this.accuracy_is_percent.isEmpty();
    }

    public boolean hasAccuracy_is_percent() { 
      return this.accuracy_is_percent != null && !this.accuracy_is_percent.isEmpty();
    }

    /**
     * @param value {@link #accuracy_is_percent} (If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.). This is the underlying object with id, value and extensions. The accessor "getAccuracy_is_percent" gives direct access to the value
     */
    public DV_AMOUNT setAccuracy_is_percentElement(BooleanType value) { 
      this.accuracy_is_percent = value;
      return this;
    }

    /**
     * @return If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.
     */
    public boolean getAccuracy_is_percent() { 
      return this.accuracy_is_percent == null || this.accuracy_is_percent.isEmpty() ? false : this.accuracy_is_percent.getValue();
    }

    /**
     * @param value If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.
     */
    public DV_AMOUNT setAccuracy_is_percent(boolean value) { 
        if (this.accuracy_is_percent == null)
          this.accuracy_is_percent = new BooleanType();
        this.accuracy_is_percent.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("accuracy_is_percent", "boolean", "If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.", 0, 1, accuracy_is_percent));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 629785910: /*accuracy_is_percent*/  return new Property("accuracy_is_percent", "boolean", "If True, indicates that when this object was created, accuracy was recorded as a percent value; if False, as an absolute quantity value.", 0, 1, accuracy_is_percent);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 629785910: /*accuracy_is_percent*/ return this.accuracy_is_percent == null ? new Base[0] : new Base[] {this.accuracy_is_percent}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 629785910: // accuracy_is_percent
          this.accuracy_is_percent = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("accuracy_is_percent")) {
          this.accuracy_is_percent = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 629785910:  return getAccuracy_is_percentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 629785910: /*accuracy_is_percent*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("accuracy_is_percent")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_AMOUNT.accuracy_is_percent");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_AMOUNT";

  }

      public abstract DV_AMOUNT copy();

      public void copyValues(DV_AMOUNT dst) {
        super.copyValues(dst);
        dst.accuracy_is_percent = accuracy_is_percent == null ? null : accuracy_is_percent.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_AMOUNT))
          return false;
        DV_AMOUNT o = (DV_AMOUNT) other_;
        return compareDeep(accuracy_is_percent, o.accuracy_is_percent, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_AMOUNT))
          return false;
        DV_AMOUNT o = (DV_AMOUNT) other_;
        return compareValues(accuracy_is_percent, o.accuracy_is_percent, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(accuracy_is_percent);
      }


}

