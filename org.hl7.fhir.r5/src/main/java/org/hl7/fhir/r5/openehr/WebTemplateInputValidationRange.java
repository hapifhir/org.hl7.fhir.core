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
@DatatypeDef(name="WebTemplateInputValidationRange")
public class WebTemplateInputValidationRange extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "minOp", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-range-minop")
    protected CodeType minOp;

    /**
     * 
     */
    @Child(name = "min", type = {DecimalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected DecimalType min;

    /**
     * 
     */
    @Child(name = "maxOp", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-range-maxop")
    protected CodeType maxOp;

    /**
     * 
     */
    @Child(name = "max", type = {DecimalType.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected DecimalType max;

    private static final long serialVersionUID = 42305724L;

  /**
   * Constructor
   */
    public WebTemplateInputValidationRange() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplateInputValidationRange(String minOp, BigDecimal min, String maxOp, BigDecimal max) {
      super();
      this.setMinOp(minOp);
      this.setMin(min);
      this.setMaxOp(maxOp);
      this.setMax(max);
    }

    /**
     * @return {@link #minOp} (). This is the underlying object with id, value and extensions. The accessor "getMinOp" gives direct access to the value
     */
    public CodeType getMinOpElement() { 
      if (this.minOp == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidationRange.minOp");
        else if (Configuration.doAutoCreate())
          this.minOp = new CodeType(); // bb
      return this.minOp;
    }

    public boolean hasMinOpElement() { 
      return this.minOp != null && !this.minOp.isEmpty();
    }

    public boolean hasMinOp() { 
      return this.minOp != null && !this.minOp.isEmpty();
    }

    /**
     * @param value {@link #minOp} (). This is the underlying object with id, value and extensions. The accessor "getMinOp" gives direct access to the value
     */
    public WebTemplateInputValidationRange setMinOpElement(CodeType value) { 
      this.minOp = value;
      return this;
    }

    /**
     * @return 
     */
    public String getMinOp() { 
      return this.minOp == null ? null : this.minOp.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMinOp(String value) { 
        if (this.minOp == null)
          this.minOp = new CodeType();
        this.minOp.setValue(value);
      return this;
    }

    /**
     * @return {@link #min} (). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public DecimalType getMinElement() { 
      if (this.min == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidationRange.min");
        else if (Configuration.doAutoCreate())
          this.min = new DecimalType(); // bb
      return this.min;
    }

    public boolean hasMinElement() { 
      return this.min != null && !this.min.isEmpty();
    }

    public boolean hasMin() { 
      return this.min != null && !this.min.isEmpty();
    }

    /**
     * @param value {@link #min} (). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public WebTemplateInputValidationRange setMinElement(DecimalType value) { 
      this.min = value;
      return this;
    }

    /**
     * @return 
     */
    public BigDecimal getMin() { 
      return this.min == null ? null : this.min.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMin(BigDecimal value) { 
        if (this.min == null)
          this.min = new DecimalType();
        this.min.setValue(value);
      return this;
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMin(long value) { 
          this.min = new DecimalType();
        this.min.setValue(value);
      return this;
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMin(double value) { 
          this.min = new DecimalType();
        this.min.setValue(value);
      return this;
    }

    /**
     * @return {@link #maxOp} (). This is the underlying object with id, value and extensions. The accessor "getMaxOp" gives direct access to the value
     */
    public CodeType getMaxOpElement() { 
      if (this.maxOp == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidationRange.maxOp");
        else if (Configuration.doAutoCreate())
          this.maxOp = new CodeType(); // bb
      return this.maxOp;
    }

    public boolean hasMaxOpElement() { 
      return this.maxOp != null && !this.maxOp.isEmpty();
    }

    public boolean hasMaxOp() { 
      return this.maxOp != null && !this.maxOp.isEmpty();
    }

    /**
     * @param value {@link #maxOp} (). This is the underlying object with id, value and extensions. The accessor "getMaxOp" gives direct access to the value
     */
    public WebTemplateInputValidationRange setMaxOpElement(CodeType value) { 
      this.maxOp = value;
      return this;
    }

    /**
     * @return 
     */
    public String getMaxOp() { 
      return this.maxOp == null ? null : this.maxOp.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMaxOp(String value) { 
        if (this.maxOp == null)
          this.maxOp = new CodeType();
        this.maxOp.setValue(value);
      return this;
    }

    /**
     * @return {@link #max} (). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public DecimalType getMaxElement() { 
      if (this.max == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidationRange.max");
        else if (Configuration.doAutoCreate())
          this.max = new DecimalType(); // bb
      return this.max;
    }

    public boolean hasMaxElement() { 
      return this.max != null && !this.max.isEmpty();
    }

    public boolean hasMax() { 
      return this.max != null && !this.max.isEmpty();
    }

    /**
     * @param value {@link #max} (). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public WebTemplateInputValidationRange setMaxElement(DecimalType value) { 
      this.max = value;
      return this;
    }

    /**
     * @return 
     */
    public BigDecimal getMax() { 
      return this.max == null ? null : this.max.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMax(BigDecimal value) { 
        if (this.max == null)
          this.max = new DecimalType();
        this.max.setValue(value);
      return this;
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMax(long value) { 
          this.max = new DecimalType();
        this.max.setValue(value);
      return this;
    }

    /**
     * @param value 
     */
    public WebTemplateInputValidationRange setMax(double value) { 
          this.max = new DecimalType();
        this.max.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("minOp", "code", "", 0, 1, minOp));
        children.add(new Property("min", "decimal", "", 0, 1, min));
        children.add(new Property("maxOp", "code", "", 0, 1, maxOp));
        children.add(new Property("max", "decimal", "", 0, 1, max));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 103900115: /*minOp*/  return new Property("minOp", "code", "", 0, 1, minOp);
        case 108114: /*min*/  return new Property("min", "decimal", "", 0, 1, min);
        case 103671397: /*maxOp*/  return new Property("maxOp", "code", "", 0, 1, maxOp);
        case 107876: /*max*/  return new Property("max", "decimal", "", 0, 1, max);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 103900115: /*minOp*/ return this.minOp == null ? new Base[0] : new Base[] {this.minOp}; // CodeType
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // DecimalType
        case 103671397: /*maxOp*/ return this.maxOp == null ? new Base[0] : new Base[] {this.maxOp}; // CodeType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 103900115: // minOp
          this.minOp = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 103671397: // maxOp
          this.maxOp = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("minOp")) {
          this.minOp = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("maxOp")) {
          this.maxOp = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToDecimal(value); // DecimalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 103900115:  return getMinOpElement();
        case 108114:  return getMinElement();
        case 103671397:  return getMaxOpElement();
        case 107876:  return getMaxElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 103900115: /*minOp*/ return new String[] {"code"};
        case 108114: /*min*/ return new String[] {"decimal"};
        case 103671397: /*maxOp*/ return new String[] {"code"};
        case 107876: /*max*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("minOp")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputValidationRange.minOp");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputValidationRange.min");
        }
        else if (name.equals("maxOp")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputValidationRange.maxOp");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputValidationRange.max");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateInputValidationRange";

  }

      public WebTemplateInputValidationRange copy() {
        WebTemplateInputValidationRange dst = new WebTemplateInputValidationRange();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateInputValidationRange dst) {
        super.copyValues(dst);
        dst.minOp = minOp == null ? null : minOp.copy();
        dst.min = min == null ? null : min.copy();
        dst.maxOp = maxOp == null ? null : maxOp.copy();
        dst.max = max == null ? null : max.copy();
      }

      protected WebTemplateInputValidationRange typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputValidationRange))
          return false;
        WebTemplateInputValidationRange o = (WebTemplateInputValidationRange) other_;
        return compareDeep(minOp, o.minOp, true) && compareDeep(min, o.min, true) && compareDeep(maxOp, o.maxOp, true)
           && compareDeep(max, o.max, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputValidationRange))
          return false;
        WebTemplateInputValidationRange o = (WebTemplateInputValidationRange) other_;
        return compareValues(minOp, o.minOp, true) && compareValues(min, o.min, true) && compareValues(maxOp, o.maxOp, true)
           && compareValues(max, o.max, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(minOp, min, maxOp, max
          );
      }


}

