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
 * This is an abstract class of which all timing specifications are specialisations. Specifies points in time, possibly linked to the calendar, or a real world repeating event, such as breakfast.
 */
@DatatypeDef(name="DV_TIME_SPECIFICATION")
public abstract class DV_TIME_SPECIFICATION extends DATA_VALUE implements ICompositeType {

    /**
     * The specification, in the HL7v3 syntax for PIVL or EIVL types.
     */
    @Child(name = "DV_PARSABLE", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The specification, in the HL7v3 syntax for PIVL or EIVL types", formalDefinition="The specification, in the HL7v3 syntax for PIVL or EIVL types." )
    protected StringType DV_PARSABLE;

    private static final long serialVersionUID = 6714082L;

  /**
   * Constructor
   */
    public DV_TIME_SPECIFICATION() {
      super();
    }

  /**
   * Constructor
   */
    public DV_TIME_SPECIFICATION(String DV_PARSABLE) {
      super();
      this.setDV_PARSABLE(DV_PARSABLE);
    }

    /**
     * @return {@link #DV_PARSABLE} (The specification, in the HL7v3 syntax for PIVL or EIVL types.). This is the underlying object with id, value and extensions. The accessor "getDV_PARSABLE" gives direct access to the value
     */
    public StringType getDV_PARSABLEElement() { 
      if (this.DV_PARSABLE == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TIME_SPECIFICATION.DV_PARSABLE");
        else if (Configuration.doAutoCreate())
          this.DV_PARSABLE = new StringType(); // bb
      return this.DV_PARSABLE;
    }

    public boolean hasDV_PARSABLEElement() { 
      return this.DV_PARSABLE != null && !this.DV_PARSABLE.isEmpty();
    }

    public boolean hasDV_PARSABLE() { 
      return this.DV_PARSABLE != null && !this.DV_PARSABLE.isEmpty();
    }

    /**
     * @param value {@link #DV_PARSABLE} (The specification, in the HL7v3 syntax for PIVL or EIVL types.). This is the underlying object with id, value and extensions. The accessor "getDV_PARSABLE" gives direct access to the value
     */
    public DV_TIME_SPECIFICATION setDV_PARSABLEElement(StringType value) { 
      this.DV_PARSABLE = value;
      return this;
    }

    /**
     * @return The specification, in the HL7v3 syntax for PIVL or EIVL types.
     */
    public String getDV_PARSABLE() { 
      return this.DV_PARSABLE == null ? null : this.DV_PARSABLE.getValue();
    }

    /**
     * @param value The specification, in the HL7v3 syntax for PIVL or EIVL types.
     */
    public DV_TIME_SPECIFICATION setDV_PARSABLE(String value) { 
        if (this.DV_PARSABLE == null)
          this.DV_PARSABLE = new StringType();
        this.DV_PARSABLE.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("DV_PARSABLE", "string", "The specification, in the HL7v3 syntax for PIVL or EIVL types.", 0, 1, DV_PARSABLE));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 406932825: /*DV_PARSABLE*/  return new Property("DV_PARSABLE", "string", "The specification, in the HL7v3 syntax for PIVL or EIVL types.", 0, 1, DV_PARSABLE);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 406932825: /*DV_PARSABLE*/ return this.DV_PARSABLE == null ? new Base[0] : new Base[] {this.DV_PARSABLE}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 406932825: // DV_PARSABLE
          this.DV_PARSABLE = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("DV_PARSABLE")) {
          this.DV_PARSABLE = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 406932825:  return getDV_PARSABLEElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 406932825: /*DV_PARSABLE*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("DV_PARSABLE")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_TIME_SPECIFICATION.DV_PARSABLE");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_TIME_SPECIFICATION";

  }

      public abstract DV_TIME_SPECIFICATION copy();

      public void copyValues(DV_TIME_SPECIFICATION dst) {
        super.copyValues(dst);
        dst.DV_PARSABLE = DV_PARSABLE == null ? null : DV_PARSABLE.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_TIME_SPECIFICATION))
          return false;
        DV_TIME_SPECIFICATION o = (DV_TIME_SPECIFICATION) other_;
        return compareDeep(DV_PARSABLE, o.DV_PARSABLE, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_TIME_SPECIFICATION))
          return false;
        DV_TIME_SPECIFICATION o = (DV_TIME_SPECIFICATION) other_;
        return compareValues(DV_PARSABLE, o.DV_PARSABLE, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(DV_PARSABLE);
      }


}

