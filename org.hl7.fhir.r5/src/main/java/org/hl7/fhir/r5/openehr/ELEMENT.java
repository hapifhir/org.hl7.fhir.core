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
 * The leaf variant of ITEM, to which a DATA_VALUE instance is attached.
 */
@DatatypeDef(name="ELEMENT")
public class ELEMENT extends ITEM implements ICompositeType {

    /**
     * Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|.
     */
    @Child(name = "null_flavour", type = {DV_CODED_TEXT.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|", formalDefinition="Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-null_flavours")
    protected DV_CODED_TEXT null_flavour;

    /**
     * Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used.
     */
    @Child(name = "value", type = {DATA_VALUE.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Property representing leaf value object of ELEMENT (any concrete subtype of DATA_VALUE)", formalDefinition="Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used." )
    protected DATA_VALUE value;

    /**
     * Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts.
     */
    @Child(name = "null_reason", type = {DV_TEXT.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional specific reason for null value; if set, null_flavour must be set", formalDefinition="Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts." )
    protected DV_TEXT null_reason;

    private static final long serialVersionUID = -741031778L;

  /**
   * Constructor
   */
    public ELEMENT() {
      super();
    }

    /**
     * @return {@link #null_flavour} (Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|.)
     */
    public DV_CODED_TEXT getNull_flavour() { 
      if (this.null_flavour == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ELEMENT.null_flavour");
        else if (Configuration.doAutoCreate())
          this.null_flavour = new DV_CODED_TEXT(); // cc
      return this.null_flavour;
    }

    public boolean hasNull_flavour() { 
      return this.null_flavour != null && !this.null_flavour.isEmpty();
    }

    /**
     * @param value {@link #null_flavour} (Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|.)
     */
    public ELEMENT setNull_flavour(DV_CODED_TEXT value) { 
      this.null_flavour = value;
      return this;
    }

    /**
     * @return {@link #value} (Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used.)
     */
    public DATA_VALUE getValue() { 
      return this.value;
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used.)
     */
    public ELEMENT setValue(DATA_VALUE value) { 
      this.value = value;
      return this;
    }

    /**
     * @return {@link #null_reason} (Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts.)
     */
    public DV_TEXT getNull_reason() { 
      if (this.null_reason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ELEMENT.null_reason");
        else if (Configuration.doAutoCreate())
          this.null_reason = new DV_TEXT(); // cc
      return this.null_reason;
    }

    public boolean hasNull_reason() { 
      return this.null_reason != null && !this.null_reason.isEmpty();
    }

    /**
     * @param value {@link #null_reason} (Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts.)
     */
    public ELEMENT setNull_reason(DV_TEXT value) { 
      this.null_reason = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("null_flavour", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|.", 0, 1, null_flavour));
        children.add(new Property("value", "http://openehr.org/fhir/StructureDefinition/DATA-VALUE", "Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used.", 0, 1, value));
        children.add(new Property("null_reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts.", 0, 1, null_reason));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1423585081: /*null_flavour*/  return new Property("null_flavour", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Flavour of null value, e.g. 253|unknown|, 271|no information|, 272|masked|, and 273|not applicable|.", 0, 1, null_flavour);
        case 111972721: /*value*/  return new Property("value", "http://openehr.org/fhir/StructureDefinition/DATA-VALUE", "Property representing leaf value object of ELEMENT. In real data, any concrete subtype of DATA_VALUE can be used.", 0, 1, value);
        case 1768477692: /*null_reason*/  return new Property("null_reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional specific reason for null value; if set, null_flavour must be set. Null reason may apply only to a minority of clinical data, commonly needed in reporting contexts.", 0, 1, null_reason);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1423585081: /*null_flavour*/ return this.null_flavour == null ? new Base[0] : new Base[] {this.null_flavour}; // DV_CODED_TEXT
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DATA_VALUE
        case 1768477692: /*null_reason*/ return this.null_reason == null ? new Base[0] : new Base[] {this.null_reason}; // DV_TEXT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1423585081: // null_flavour
          this.null_flavour = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case 111972721: // value
          this.value = (DATA_VALUE) value; // DATA_VALUE
          return value;
        case 1768477692: // null_reason
          this.null_reason = (DV_TEXT) value; // DV_TEXT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("null_flavour")) {
          this.null_flavour = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("value")) {
          this.value = (DATA_VALUE) value; // DATA_VALUE
        } else if (name.equals("null_reason")) {
          this.null_reason = (DV_TEXT) value; // DV_TEXT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1423585081:  return getNull_flavour();
        case 111972721: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'value'");
        case 1768477692:  return getNull_reason();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1423585081: /*null_flavour*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case 111972721: /*value*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DATA-VALUE"};
        case 1768477692: /*null_reason*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("null_flavour")) {
          this.null_flavour = new DV_CODED_TEXT();
          return this.null_flavour;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on an abstract type ELEMENT.value");
        }
        else if (name.equals("null_reason")) {
          this.null_reason = new DV_TEXT();
          return this.null_reason;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ELEMENT";

  }

      public ELEMENT copy() {
        ELEMENT dst = new ELEMENT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ELEMENT dst) {
        super.copyValues(dst);
        dst.null_flavour = null_flavour == null ? null : null_flavour.copy();
        dst.value = value == null ? null : value.copy();
        dst.null_reason = null_reason == null ? null : null_reason.copy();
      }

      protected ELEMENT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ELEMENT))
          return false;
        ELEMENT o = (ELEMENT) other_;
        return compareDeep(null_flavour, o.null_flavour, true) && compareDeep(value, o.value, true) && compareDeep(null_reason, o.null_reason, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ELEMENT))
          return false;
        ELEMENT o = (ELEMENT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(null_flavour, value, null_reason
          );
      }


}

