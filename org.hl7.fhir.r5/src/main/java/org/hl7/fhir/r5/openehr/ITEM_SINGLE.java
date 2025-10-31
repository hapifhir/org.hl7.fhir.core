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
 * Logical single value data structure. Used to represent any data which is logically a single value, such as a person’s height or weight.
 */
@DatatypeDef(name="ITEM_SINGLE")
public class ITEM_SINGLE extends ITEM_STRUCTURE implements ICompositeType {

    /**
     * 
     */
    @Child(name = "item", type = {ELEMENT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="", formalDefinition="" )
    protected ELEMENT item;

    private static final long serialVersionUID = 1729811823L;

  /**
   * Constructor
   */
    public ITEM_SINGLE() {
      super();
    }

  /**
   * Constructor
   */
    public ITEM_SINGLE(ELEMENT item) {
      super();
      this.setItem(item);
    }

    /**
     * @return {@link #item} ()
     */
    public ELEMENT getItem() { 
      if (this.item == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ITEM_SINGLE.item");
        else if (Configuration.doAutoCreate())
          this.item = new ELEMENT(); // cc
      return this.item;
    }

    public boolean hasItem() { 
      return this.item != null && !this.item.isEmpty();
    }

    /**
     * @param value {@link #item} ()
     */
    public ITEM_SINGLE setItem(ELEMENT value) { 
      this.item = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("item", "http://openehr.org/fhir/StructureDefinition/ELEMENT", "", 0, 1, item));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3242771: /*item*/  return new Property("item", "http://openehr.org/fhir/StructureDefinition/ELEMENT", "", 0, 1, item);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // ELEMENT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = (ELEMENT) value; // ELEMENT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.item = (ELEMENT) value; // ELEMENT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ELEMENT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          this.item = new ELEMENT();
          return this.item;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ITEM_SINGLE";

  }

      public ITEM_SINGLE copy() {
        ITEM_SINGLE dst = new ITEM_SINGLE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ITEM_SINGLE dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      protected ITEM_SINGLE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ITEM_SINGLE))
          return false;
        ITEM_SINGLE o = (ITEM_SINGLE) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ITEM_SINGLE))
          return false;
        ITEM_SINGLE o = (ITEM_SINGLE) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }


}

