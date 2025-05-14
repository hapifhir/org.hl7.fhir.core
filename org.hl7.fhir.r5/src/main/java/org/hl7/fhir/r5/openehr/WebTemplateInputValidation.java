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
 * 
 */
@DatatypeDef(name="WebTemplateInputValidation")
public class WebTemplateInputValidation extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "range", type = {WebTemplateInputValidationRange.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected WebTemplateInputValidationRange range;

    /**
     * 
     */
    @Child(name = "precision", type = {WebTemplateInputValidationRange.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected WebTemplateInputValidationRange precision;

    private static final long serialVersionUID = 1147023337L;

  /**
   * Constructor
   */
    public WebTemplateInputValidation() {
      super();
    }

    /**
     * @return {@link #range} ()
     */
    public WebTemplateInputValidationRange getRange() { 
      if (this.range == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidation.range");
        else if (Configuration.doAutoCreate())
          this.range = new WebTemplateInputValidationRange(); // cc
      return this.range;
    }

    public boolean hasRange() { 
      return this.range != null && !this.range.isEmpty();
    }

    /**
     * @param value {@link #range} ()
     */
    public WebTemplateInputValidation setRange(WebTemplateInputValidationRange value) { 
      this.range = value;
      return this;
    }

    /**
     * @return {@link #precision} ()
     */
    public WebTemplateInputValidationRange getPrecision() { 
      if (this.precision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputValidation.precision");
        else if (Configuration.doAutoCreate())
          this.precision = new WebTemplateInputValidationRange(); // cc
      return this.precision;
    }

    public boolean hasPrecision() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    /**
     * @param value {@link #precision} ()
     */
    public WebTemplateInputValidation setPrecision(WebTemplateInputValidationRange value) { 
      this.precision = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("range", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange", "", 0, 1, range));
        children.add(new Property("precision", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange", "", 0, 1, precision));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 108280125: /*range*/  return new Property("range", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange", "", 0, 1, range);
        case -1376177026: /*precision*/  return new Property("precision", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange", "", 0, 1, precision);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // WebTemplateInputValidationRange
        case -1376177026: /*precision*/ return this.precision == null ? new Base[0] : new Base[] {this.precision}; // WebTemplateInputValidationRange
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 108280125: // range
          this.range = (WebTemplateInputValidationRange) value; // WebTemplateInputValidationRange
          return value;
        case -1376177026: // precision
          this.precision = (WebTemplateInputValidationRange) value; // WebTemplateInputValidationRange
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("range")) {
          this.range = (WebTemplateInputValidationRange) value; // WebTemplateInputValidationRange
        } else if (name.equals("precision")) {
          this.precision = (WebTemplateInputValidationRange) value; // WebTemplateInputValidationRange
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 108280125:  return getRange();
        case -1376177026:  return getPrecision();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 108280125: /*range*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange"};
        case -1376177026: /*precision*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidationRange"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("range")) {
          this.range = new WebTemplateInputValidationRange();
          return this.range;
        }
        else if (name.equals("precision")) {
          this.precision = new WebTemplateInputValidationRange();
          return this.precision;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateInputValidation";

  }

      public WebTemplateInputValidation copy() {
        WebTemplateInputValidation dst = new WebTemplateInputValidation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateInputValidation dst) {
        super.copyValues(dst);
        dst.range = range == null ? null : range.copy();
        dst.precision = precision == null ? null : precision.copy();
      }

      protected WebTemplateInputValidation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputValidation))
          return false;
        WebTemplateInputValidation o = (WebTemplateInputValidation) other_;
        return compareDeep(range, o.range, true) && compareDeep(precision, o.precision, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputValidation))
          return false;
        WebTemplateInputValidation o = (WebTemplateInputValidation) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(range, precision);
      }


}

