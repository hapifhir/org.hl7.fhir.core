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
 * Encapsulated data expressed as a parsable String. The internal model of the data item is not described in the openEHR model in common with other encapsulated types, but in this case, the form of the data is assumed to be plaintext, rather than compressed or other types of large binary data.
 */
@DatatypeDef(name="DV_PARSABLE")
public class DV_PARSABLE extends DV_ENCAPSULATED implements ICompositeType {

    /**
     * The string, which may validly be empty in some syntaxes.
     */
    @Child(name = "value", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The string, which may validly be empty in some syntaxes", formalDefinition="The string, which may validly be empty in some syntaxes." )
    protected StringType value;

    /**
     * Name of the formalism, e.g. GLIF 1.0 , Proforma etc.
     */
    @Child(name = "formalism", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of the formalism, e.g. GLIF 1.0 , Proforma etc", formalDefinition="Name of the formalism, e.g. GLIF 1.0 , Proforma etc." )
    protected StringType formalism;

    private static final long serialVersionUID = -1693649635L;

  /**
   * Constructor
   */
    public DV_PARSABLE() {
      super();
    }

  /**
   * Constructor
   */
    public DV_PARSABLE(String value, String formalism) {
      super();
      this.setValue(value);
      this.setFormalism(formalism);
    }

    /**
     * @return {@link #value} (The string, which may validly be empty in some syntaxes.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PARSABLE.value");
        else if (Configuration.doAutoCreate())
          this.value = new StringType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The string, which may validly be empty in some syntaxes.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DV_PARSABLE setValueElement(StringType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return The string, which may validly be empty in some syntaxes.
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value The string, which may validly be empty in some syntaxes.
     */
    public DV_PARSABLE setValue(String value) { 
        if (this.value == null)
          this.value = new StringType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #formalism} (Name of the formalism, e.g. GLIF 1.0 , Proforma etc.). This is the underlying object with id, value and extensions. The accessor "getFormalism" gives direct access to the value
     */
    public StringType getFormalismElement() { 
      if (this.formalism == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_PARSABLE.formalism");
        else if (Configuration.doAutoCreate())
          this.formalism = new StringType(); // bb
      return this.formalism;
    }

    public boolean hasFormalismElement() { 
      return this.formalism != null && !this.formalism.isEmpty();
    }

    public boolean hasFormalism() { 
      return this.formalism != null && !this.formalism.isEmpty();
    }

    /**
     * @param value {@link #formalism} (Name of the formalism, e.g. GLIF 1.0 , Proforma etc.). This is the underlying object with id, value and extensions. The accessor "getFormalism" gives direct access to the value
     */
    public DV_PARSABLE setFormalismElement(StringType value) { 
      this.formalism = value;
      return this;
    }

    /**
     * @return Name of the formalism, e.g. GLIF 1.0 , Proforma etc.
     */
    public String getFormalism() { 
      return this.formalism == null ? null : this.formalism.getValue();
    }

    /**
     * @param value Name of the formalism, e.g. GLIF 1.0 , Proforma etc.
     */
    public DV_PARSABLE setFormalism(String value) { 
        if (this.formalism == null)
          this.formalism = new StringType();
        this.formalism.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "string", "The string, which may validly be empty in some syntaxes.", 0, 1, value));
        children.add(new Property("formalism", "string", "Name of the formalism, e.g. GLIF 1.0 , Proforma etc.", 0, 1, formalism));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "string", "The string, which may validly be empty in some syntaxes.", 0, 1, value);
        case 1811342900: /*formalism*/  return new Property("formalism", "string", "Name of the formalism, e.g. GLIF 1.0 , Proforma etc.", 0, 1, formalism);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 1811342900: /*formalism*/ return this.formalism == null ? new Base[0] : new Base[] {this.formalism}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 1811342900: // formalism
          this.formalism = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("formalism")) {
          this.formalism = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case 1811342900:  return getFormalismElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"string"};
        case 1811342900: /*formalism*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PARSABLE.value");
        }
        else if (name.equals("formalism")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_PARSABLE.formalism");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_PARSABLE";

  }

      public DV_PARSABLE copy() {
        DV_PARSABLE dst = new DV_PARSABLE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_PARSABLE dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.formalism = formalism == null ? null : formalism.copy();
      }

      protected DV_PARSABLE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_PARSABLE))
          return false;
        DV_PARSABLE o = (DV_PARSABLE) other_;
        return compareDeep(value, o.value, true) && compareDeep(formalism, o.formalism, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_PARSABLE))
          return false;
        DV_PARSABLE o = (DV_PARSABLE) other_;
        return compareValues(value, o.value, true) && compareValues(formalism, o.formalism, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, formalism);
      }


}

