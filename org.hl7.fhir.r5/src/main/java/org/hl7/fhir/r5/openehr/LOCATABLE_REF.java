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
 * Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to
 */
@DatatypeDef(name="LOCATABLE_REF")
public class LOCATABLE_REF extends OBJECT_REF implements ICompositeType {

    /**
     * Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to
     */
    @Child(name = "path", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute", formalDefinition="Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to" )
    protected StringType path;

    private static final long serialVersionUID = 1599579760L;

  /**
   * Constructor
   */
    public LOCATABLE_REF() {
      super();
    }

    /**
     * @return {@link #path} (Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
     */
    public StringType getPathElement() { 
      if (this.path == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create LOCATABLE_REF.path");
        else if (Configuration.doAutoCreate())
          this.path = new StringType(); // bb
      return this.path;
    }

    public boolean hasPathElement() { 
      return this.path != null && !this.path.isEmpty();
    }

    public boolean hasPath() { 
      return this.path != null && !this.path.isEmpty();
    }

    /**
     * @param value {@link #path} (Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
     */
    public LOCATABLE_REF setPathElement(StringType value) { 
      this.path = value;
      return this;
    }

    /**
     * @return Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to
     */
    public String getPath() { 
      return this.path == null ? null : this.path.getValue();
    }

    /**
     * @param value Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to
     */
    public LOCATABLE_REF setPath(String value) { 
      if (Utilities.noString(value))
        this.path = null;
      else {
        if (this.path == null)
          this.path = new StringType();
        this.path.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("path", "string", "Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to", 0, 1, path));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3433509: /*path*/  return new Property("path", "string", "Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T> identified by the id attribute. The path attribute is applied to the object that VERSION.data points to", 0, 1, path);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property LOCATABLE_REF.path");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "LOCATABLE_REF";

  }

      public LOCATABLE_REF copy() {
        LOCATABLE_REF dst = new LOCATABLE_REF();
        copyValues(dst);
        return dst;
      }

      public void copyValues(LOCATABLE_REF dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
      }

      protected LOCATABLE_REF typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof LOCATABLE_REF))
          return false;
        LOCATABLE_REF o = (LOCATABLE_REF) other_;
        return compareDeep(path, o.path, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof LOCATABLE_REF))
          return false;
        LOCATABLE_REF o = (LOCATABLE_REF) other_;
        return compareValues(path, o.path, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path);
      }


}

