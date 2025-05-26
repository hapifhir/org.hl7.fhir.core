package org.hl7.fhir.r5.tools;


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
import org.hl7.fhir.r5.tools.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * This is a concrete subtype of Base that has extensions (though the format in JSON is different)
 */
@DatatypeDef(name="CDSHooksExtensions")
public class CDSHooksExtensions extends LogicalBase implements ICompositeType {

    /**
     * An extension where the name is defined by the extension definition, and the extension definition is of any type (including primitives, though the 'id' element cannot be represented for primitives)
     */
    @Child(name = "extension", type = {Base.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An extension of any type", formalDefinition="An extension where the name is defined by the extension definition, and the extension definition is of any type (including primitives, though the 'id' element cannot be represented for primitives)" )
    protected List<NamedElementExtension> extensionList;

    private static final long serialVersionUID = 163508525L;

  /**
   * Constructor
   */
    public CDSHooksExtensions() {
      super();
    }

    /**
     * @return {@link #extension} (An extension where the name is defined by the extension definition, and the extension definition is of any type (including primitives, though the 'id' element cannot be represented for primitives))
     */
    public List<NamedElementExtension> getExtensionList() { 
      if (this.extensionList == null)
        this.extensionList = new ArrayList<NamedElementExtension>();
      return this.extensionList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CDSHooksExtensions setExtensionList(List<NamedElementExtension> theExtension) { 
      this.extensionList = theExtension;
      return this;
    }

    public boolean hasExtension() { 
      if (this.extensionList == null)
        return false;
      for (NamedElementExtension item : this.extensionList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CDSHooksExtensions addExtension(NamedElementExtension t) { //3b
      if (t == null)
        return this;
      if (this.extensionList == null)
        this.extensionList = new ArrayList<NamedElementExtension>();
      this.extensionList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("extension", "Base", "An extension where the name is defined by the extension definition, and the extension definition is of any type (including primitives, though the 'id' element cannot be represented for primitives)", 0, java.lang.Integer.MAX_VALUE, extensionList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -612557761: /*extension*/  return new Property("extension", "Base", "An extension where the name is defined by the extension definition, and the extension definition is of any type (including primitives, though the 'id' element cannot be represented for primitives)", 0, java.lang.Integer.MAX_VALUE, extensionList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -612557761: /*extension*/ return this.extensionList == null ? new Base[0] : this.extensionList.toArray(new Base[this.extensionList.size()]); // NamedElementExtension
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -612557761: // extension
          this.getExtensionList().add((NamedElementExtension) value); // NamedElementExtension
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("extension")) {
          this.getExtensionList().add((NamedElementExtension) value); // NamedElementExtension
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -612557761: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'extension'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -612557761: /*extension*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("extension")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksExtensions.extension");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CDSHooksExtensions";

  }

      public CDSHooksExtensions copy() {
        CDSHooksExtensions dst = new CDSHooksExtensions();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksExtensions dst) {
        super.copyValues(dst);
        if (extensionList != null) {
          dst.extensionList = new ArrayList<NamedElementExtension>();
          for (NamedElementExtension i : extensionList)
            dst.extensionList.add(i.copy());
        };
      }

      protected CDSHooksExtensions typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksExtensions))
          return false;
        CDSHooksExtensions o = (CDSHooksExtensions) other_;
        return compareDeep(extensionList, o.extensionList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksExtensions))
          return false;
        CDSHooksExtensions o = (CDSHooksExtensions) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(extensionList);
      }


}

