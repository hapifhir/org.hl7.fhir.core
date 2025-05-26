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
 * Logical tree data structure. The tree may be empty. Used for representing data which are logically a tree such as audiology results, microbiology results, biochemistry results.
 */
@DatatypeDef(name="ITEM_TREE")
public class ITEM_TREE extends ITEM_STRUCTURE implements ICompositeType {

    /**
     * The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs.
     */
    @Child(name = "items", type = {ITEM.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs", formalDefinition="The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs." )
    protected List<ITEM> itemsList;

    private static final long serialVersionUID = -285267557L;

  /**
   * Constructor
   */
    public ITEM_TREE() {
      super();
    }

    /**
     * @return {@link #items} (The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs.)
     */
    public List<ITEM> getItemsList() { 
      if (this.itemsList == null)
        this.itemsList = new ArrayList<ITEM>();
      return this.itemsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ITEM_TREE setItemsList(List<ITEM> theItems) { 
      this.itemsList = theItems;
      return this;
    }

    public boolean hasItems() { 
      if (this.itemsList == null)
        return false;
      for (ITEM item : this.itemsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ITEM_TREE addItems(ITEM t) { //3b
      if (t == null)
        return this;
      if (this.itemsList == null)
        this.itemsList = new ArrayList<ITEM>();
      this.itemsList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("items", "http://openehr.org/fhir/StructureDefinition/ITEM", "The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs.", 0, java.lang.Integer.MAX_VALUE, itemsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 100526016: /*items*/  return new Property("items", "http://openehr.org/fhir/StructureDefinition/ITEM", "The items comprising the ITEM_TREE. Can include 0 or more CLUSTERs and/or 0 or more individual ELEMENTs.", 0, java.lang.Integer.MAX_VALUE, itemsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return this.itemsList == null ? new Base[0] : this.itemsList.toArray(new Base[this.itemsList.size()]); // ITEM
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 100526016: // items
          this.getItemsList().add((ITEM) value); // ITEM
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("items")) {
          this.getItemsList().add((ITEM) value); // ITEM
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'items'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("items")) {
          throw new FHIRException("Cannot call addChild on an abstract type ITEM_TREE.items");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ITEM_TREE";

  }

      public ITEM_TREE copy() {
        ITEM_TREE dst = new ITEM_TREE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ITEM_TREE dst) {
        super.copyValues(dst);
        if (itemsList != null) {
          dst.itemsList = new ArrayList<ITEM>();
          for (ITEM i : itemsList)
            dst.itemsList.add(i.copy());
        };
      }

      protected ITEM_TREE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ITEM_TREE))
          return false;
        ITEM_TREE o = (ITEM_TREE) other_;
        return compareDeep(itemsList, o.itemsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ITEM_TREE))
          return false;
        ITEM_TREE o = (ITEM_TREE) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(itemsList);
      }


}

