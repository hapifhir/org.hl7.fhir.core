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
 * DEPRECATED: use markdown formatted DV_TEXT instead. Original definition: A logical composite text value consisting of a series of DV_TEXTs, i.e. plain text (optionally coded) potentially with simple formatting, to form a larger tract of prose, which may be interpreted for display purposes as a paragraph.
 */
@DatatypeDef(name="DV_PARAGRAPH")
public class DV_PARAGRAPH extends DATA_VALUE implements ICompositeType {

    /**
     * Items making up the paragraph, each of which is a text item (which may have its own formatting, and/or have hyperlinks).
     */
    @Child(name = "items", type = {DV_TEXT.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Items making up the paragraph", formalDefinition="Items making up the paragraph, each of which is a text item (which may have its own formatting, and/or have hyperlinks)." )
    protected List<DV_TEXT> itemsList;

    private static final long serialVersionUID = 356597994L;

  /**
   * Constructor
   */
    public DV_PARAGRAPH() {
      super();
    }

    /**
     * @return {@link #items} (Items making up the paragraph, each of which is a text item (which may have its own formatting, and/or have hyperlinks).)
     */
    public List<DV_TEXT> getItemsList() { 
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_TEXT>();
      return this.itemsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DV_PARAGRAPH setItemsList(List<DV_TEXT> theItems) { 
      this.itemsList = theItems;
      return this;
    }

    public boolean hasItems() { 
      if (this.itemsList == null)
        return false;
      for (DV_TEXT item : this.itemsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_TEXT addItems() { //3a
      DV_TEXT t = new DV_TEXT();
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_TEXT>();
      this.itemsList.add(t);
      return t;
    }

    public DV_PARAGRAPH addItems(DV_TEXT t) { //3b
      if (t == null)
        return this;
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_TEXT>();
      this.itemsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #items}, creating it if it does not already exist {3}
     */
    public DV_TEXT getItemsFirstRep() { 
      if (getItemsList().isEmpty()) {
        addItems();
      }
      return getItemsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("items", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Items making up the paragraph, each of which is a text item (which may have its own formatting, and/or have hyperlinks).", 0, java.lang.Integer.MAX_VALUE, itemsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 100526016: /*items*/  return new Property("items", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Items making up the paragraph, each of which is a text item (which may have its own formatting, and/or have hyperlinks).", 0, java.lang.Integer.MAX_VALUE, itemsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return this.itemsList == null ? new Base[0] : this.itemsList.toArray(new Base[this.itemsList.size()]); // DV_TEXT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 100526016: // items
          this.getItemsList().add((DV_TEXT) value); // DV_TEXT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("items")) {
          this.getItemsList().add((DV_TEXT) value); // DV_TEXT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016:  return addItems(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("items")) {
          return addItems();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_PARAGRAPH";

  }

      public DV_PARAGRAPH copy() {
        DV_PARAGRAPH dst = new DV_PARAGRAPH();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_PARAGRAPH dst) {
        super.copyValues(dst);
        if (itemsList != null) {
          dst.itemsList = new ArrayList<DV_TEXT>();
          for (DV_TEXT i : itemsList)
            dst.itemsList.add(i.copy());
        };
      }

      protected DV_PARAGRAPH typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_PARAGRAPH))
          return false;
        DV_PARAGRAPH o = (DV_PARAGRAPH) other_;
        return compareDeep(itemsList, o.itemsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_PARAGRAPH))
          return false;
        DV_PARAGRAPH o = (DV_PARAGRAPH) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(itemsList);
      }


}

