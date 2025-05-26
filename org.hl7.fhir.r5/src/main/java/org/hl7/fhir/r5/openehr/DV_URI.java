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
 * A reference to an object which structurally conforms to the Universal Resource Identifier (URI) RFC-3986 standard. The reference is contained in the value attribute, which is a String. So-called 'plain-text URIs' that contain RFC-3986 forbidden characters such as spaces etc, are allowed on the basis that they need to be RFC-3986 encoded prior to use in e.g. REST APIs or other contexts relying on machine-level conformance.
 */
@DatatypeDef(name="DV_URI")
public class DV_URI extends DATA_VALUE implements ICompositeType {

    /**
     * Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.
     */
    @Child(name = "value", type = {UriType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Value of URI as a String, must be RFC-3986 encoded in use", formalDefinition="Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use." )
    protected UriType value;

    private static final long serialVersionUID = 702163571L;

  /**
   * Constructor
   */
    public DV_URI() {
      super();
    }

  /**
   * Constructor
   */
    public DV_URI(String value) {
      super();
      this.setValue(value);
    }

    /**
     * @return {@link #value} (Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public UriType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_URI.value");
        else if (Configuration.doAutoCreate())
          this.value = new UriType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DV_URI setValueElement(UriType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.
     */
    public DV_URI setValue(String value) { 
        if (this.value == null)
          this.value = new UriType();
        this.value.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "uri", "Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.", 0, 1, value));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "uri", "Value of URI as a String. 'Plain-text' URIs are allowed, enabling better readability, but must be RFC-3986 encoded in use.", 0, 1, value);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_URI.value");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_URI";

  }

      public DV_URI copy() {
        DV_URI dst = new DV_URI();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_URI dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
      }

      protected DV_URI typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_URI))
          return false;
        DV_URI o = (DV_URI) other_;
        return compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_URI))
          return false;
        DV_URI o = (DV_URI) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value);
      }


}

