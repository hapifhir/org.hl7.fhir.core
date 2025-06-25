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
 * The grouping variant of ITEM, which may contain further instances of ITEM, in an ordered list.
 */
@DatatypeDef(name="CLUSTER")
public class CLUSTER extends ITEM implements ICompositeType {

    /**
     * Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER.
     */
    @Child(name = "items", type = {ITEM.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER", formalDefinition="Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER." )
    protected List<ITEM> itemsList;

    private static final long serialVersionUID = -285267557L;

  /**
   * Constructor
   */
    public CLUSTER() {
      super();
    }

    /**
     * @return {@link #items} (Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER.)
     */
    public List<ITEM> getItemsList() { 
      if (this.itemsList == null)
        this.itemsList = new ArrayList<ITEM>();
      return this.itemsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CLUSTER setItemsList(List<ITEM> theItems) { 
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

    public CLUSTER addItems(ITEM t) { //3b
      if (t == null)
        return this;
      if (this.itemsList == null)
        this.itemsList = new ArrayList<ITEM>();
      this.itemsList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("items", "http://openehr.org/fhir/StructureDefinition/ITEM", "Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER.", 0, java.lang.Integer.MAX_VALUE, itemsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 100526016: /*items*/  return new Property("items", "http://openehr.org/fhir/StructureDefinition/ITEM", "Ordered list of items - CLUSTER or ELEMENT objects - under this CLUSTER.", 0, java.lang.Integer.MAX_VALUE, itemsList);
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
          throw new FHIRException("Cannot call addChild on an abstract type CLUSTER.items");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CLUSTER";

  }

      public CLUSTER copy() {
        CLUSTER dst = new CLUSTER();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CLUSTER dst) {
        super.copyValues(dst);
        if (itemsList != null) {
          dst.itemsList = new ArrayList<ITEM>();
          for (ITEM i : itemsList)
            dst.itemsList.add(i.copy());
        };
      }

      protected CLUSTER typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CLUSTER))
          return false;
        CLUSTER o = (CLUSTER) other_;
        return compareDeep(itemsList, o.itemsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CLUSTER))
          return false;
        CLUSTER o = (CLUSTER) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(itemsList);
      }


}

