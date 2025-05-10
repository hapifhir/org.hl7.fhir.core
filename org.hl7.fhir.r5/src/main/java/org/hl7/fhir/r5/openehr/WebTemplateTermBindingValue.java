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
 * 
 */
@DatatypeDef(name="WebTemplateTermBindingValue")
public class WebTemplateTermBindingValue extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "value", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType value;

    /**
     * 
     */
    @Child(name = "terminologyId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType terminologyId;

    private static final long serialVersionUID = 1023496547L;

  /**
   * Constructor
   */
    public WebTemplateTermBindingValue() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplateTermBindingValue(String value, String terminologyId) {
      super();
      this.setValue(value);
      this.setTerminologyId(terminologyId);
    }

    /**
     * @return {@link #value} (). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateTermBindingValue.value");
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
     * @param value {@link #value} (). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public WebTemplateTermBindingValue setValueElement(StringType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return 
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateTermBindingValue setValue(String value) { 
        if (this.value == null)
          this.value = new StringType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #terminologyId} (). This is the underlying object with id, value and extensions. The accessor "getTerminologyId" gives direct access to the value
     */
    public StringType getTerminologyIdElement() { 
      if (this.terminologyId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateTermBindingValue.terminologyId");
        else if (Configuration.doAutoCreate())
          this.terminologyId = new StringType(); // bb
      return this.terminologyId;
    }

    public boolean hasTerminologyIdElement() { 
      return this.terminologyId != null && !this.terminologyId.isEmpty();
    }

    public boolean hasTerminologyId() { 
      return this.terminologyId != null && !this.terminologyId.isEmpty();
    }

    /**
     * @param value {@link #terminologyId} (). This is the underlying object with id, value and extensions. The accessor "getTerminologyId" gives direct access to the value
     */
    public WebTemplateTermBindingValue setTerminologyIdElement(StringType value) { 
      this.terminologyId = value;
      return this;
    }

    /**
     * @return 
     */
    public String getTerminologyId() { 
      return this.terminologyId == null ? null : this.terminologyId.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateTermBindingValue setTerminologyId(String value) { 
        if (this.terminologyId == null)
          this.terminologyId = new StringType();
        this.terminologyId.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "string", "", 0, 1, value));
        children.add(new Property("terminologyId", "string", "", 0, 1, terminologyId));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "string", "", 0, 1, value);
        case -1898927314: /*terminologyId*/  return new Property("terminologyId", "string", "", 0, 1, terminologyId);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case -1898927314: /*terminologyId*/ return this.terminologyId == null ? new Base[0] : new Base[] {this.terminologyId}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case -1898927314: // terminologyId
          this.terminologyId = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("terminologyId")) {
          this.terminologyId = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case -1898927314:  return getTerminologyIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"string"};
        case -1898927314: /*terminologyId*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateTermBindingValue.value");
        }
        else if (name.equals("terminologyId")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateTermBindingValue.terminologyId");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateTermBindingValue";

  }

      public WebTemplateTermBindingValue copy() {
        WebTemplateTermBindingValue dst = new WebTemplateTermBindingValue();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateTermBindingValue dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.terminologyId = terminologyId == null ? null : terminologyId.copy();
      }

      protected WebTemplateTermBindingValue typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateTermBindingValue))
          return false;
        WebTemplateTermBindingValue o = (WebTemplateTermBindingValue) other_;
        return compareDeep(value, o.value, true) && compareDeep(terminologyId, o.terminologyId, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateTermBindingValue))
          return false;
        WebTemplateTermBindingValue o = (WebTemplateTermBindingValue) other_;
        return compareValues(value, o.value, true) && compareValues(terminologyId, o.terminologyId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, terminologyId);
      }


}

