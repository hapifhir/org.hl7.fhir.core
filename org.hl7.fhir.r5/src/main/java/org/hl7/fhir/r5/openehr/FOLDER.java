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
 * The concept of a named folder. It is strongly recommended that the inherited attribute uid be populated in top-level (i.e. tree-root) FOLDER objects, using the UID copied from the object_id() of the uid field of the enclosing VERSION object. For example, the ORIGINAL_VERSION.uid 87284370-2D4B-4e3d-A3F3-F303D2F4F34B::uk.nhs.ehr1::2 would be copied to the uid field of the top FOLDER object.
 */
@DatatypeDef(name="FOLDER")
public class FOLDER extends LOCATABLE implements ICompositeType {

    /**
     * The list of references to other (usually) versioned objects logically in this folder.
     */
    @Child(name = "items", type = {OBJECT_REF.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="References to other (usually) versioned objects logically in this folder", formalDefinition="The list of references to other (usually) versioned objects logically in this folder." )
    protected List<OBJECT_REF> itemsList;

    /**
     * Sub-folders of this FOLDER.
     */
    @Child(name = "folders", type = {FOLDER.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Sub-folders of this FOLDER", formalDefinition="Sub-folders of this FOLDER." )
    protected List<FOLDER> foldersList;

    /**
     * Archetypable meta-data for FOLDER.
     */
    @Child(name = "details", type = {ITEM_STRUCTURE.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Archetypable meta-data for FOLDER", formalDefinition="Archetypable meta-data for FOLDER." )
    protected ITEM_STRUCTURE details;

    private static final long serialVersionUID = -979395577L;

  /**
   * Constructor
   */
    public FOLDER() {
      super();
    }

    /**
     * @return {@link #items} (The list of references to other (usually) versioned objects logically in this folder.)
     */
    public List<OBJECT_REF> getItemsList() { 
      if (this.itemsList == null)
        this.itemsList = new ArrayList<OBJECT_REF>();
      return this.itemsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FOLDER setItemsList(List<OBJECT_REF> theItems) { 
      this.itemsList = theItems;
      return this;
    }

    public boolean hasItems() { 
      if (this.itemsList == null)
        return false;
      for (OBJECT_REF item : this.itemsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addItems() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.itemsList == null)
        this.itemsList = new ArrayList<OBJECT_REF>();
      this.itemsList.add(t);
      return t;
    }

    public FOLDER addItems(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.itemsList == null)
        this.itemsList = new ArrayList<OBJECT_REF>();
      this.itemsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #items}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getItemsFirstRep() { 
      if (getItemsList().isEmpty()) {
        addItems();
      }
      return getItemsList().get(0);
    }

    /**
     * @return {@link #folders} (Sub-folders of this FOLDER.)
     */
    public List<FOLDER> getFoldersList() { 
      if (this.foldersList == null)
        this.foldersList = new ArrayList<FOLDER>();
      return this.foldersList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FOLDER setFoldersList(List<FOLDER> theFolders) { 
      this.foldersList = theFolders;
      return this;
    }

    public boolean hasFolders() { 
      if (this.foldersList == null)
        return false;
      for (FOLDER item : this.foldersList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public FOLDER addFolders() { //3a
      FOLDER t = new FOLDER();
      if (this.foldersList == null)
        this.foldersList = new ArrayList<FOLDER>();
      this.foldersList.add(t);
      return t;
    }

    public FOLDER addFolders(FOLDER t) { //3b
      if (t == null)
        return this;
      if (this.foldersList == null)
        this.foldersList = new ArrayList<FOLDER>();
      this.foldersList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #folders}, creating it if it does not already exist {3}
     */
    public FOLDER getFoldersFirstRep() { 
      if (getFoldersList().isEmpty()) {
        addFolders();
      }
      return getFoldersList().get(0);
    }

    /**
     * @return {@link #details} (Archetypable meta-data for FOLDER.)
     */
    public ITEM_STRUCTURE getDetails() { 
      return this.details;
    }

    public boolean hasDetails() { 
      return this.details != null && !this.details.isEmpty();
    }

    /**
     * @param value {@link #details} (Archetypable meta-data for FOLDER.)
     */
    public FOLDER setDetails(ITEM_STRUCTURE value) { 
      this.details = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("items", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "The list of references to other (usually) versioned objects logically in this folder.", 0, java.lang.Integer.MAX_VALUE, itemsList));
        children.add(new Property("folders", "http://openehr.org/fhir/StructureDefinition/FOLDER", "Sub-folders of this FOLDER.", 0, java.lang.Integer.MAX_VALUE, foldersList));
        children.add(new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Archetypable meta-data for FOLDER.", 0, 1, details));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 100526016: /*items*/  return new Property("items", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "The list of references to other (usually) versioned objects logically in this folder.", 0, java.lang.Integer.MAX_VALUE, itemsList);
        case -683249211: /*folders*/  return new Property("folders", "http://openehr.org/fhir/StructureDefinition/FOLDER", "Sub-folders of this FOLDER.", 0, java.lang.Integer.MAX_VALUE, foldersList);
        case 1557721666: /*details*/  return new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Archetypable meta-data for FOLDER.", 0, 1, details);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return this.itemsList == null ? new Base[0] : this.itemsList.toArray(new Base[this.itemsList.size()]); // OBJECT_REF
        case -683249211: /*folders*/ return this.foldersList == null ? new Base[0] : this.foldersList.toArray(new Base[this.foldersList.size()]); // FOLDER
        case 1557721666: /*details*/ return this.details == null ? new Base[0] : new Base[] {this.details}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 100526016: // items
          this.getItemsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case -683249211: // folders
          this.getFoldersList().add((FOLDER) value); // FOLDER
          return value;
        case 1557721666: // details
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("items")) {
          this.getItemsList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("folders")) {
          this.getFoldersList().add((FOLDER) value); // FOLDER
        } else if (name.equals("details")) {
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016:  return addItems(); 
        case -683249211:  return addFolders(); 
        case 1557721666: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'details'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100526016: /*items*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -683249211: /*folders*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/FOLDER"};
        case 1557721666: /*details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("items")) {
          return addItems();
        }
        else if (name.equals("folders")) {
          return addFolders();
        }
        else if (name.equals("details")) {
          throw new FHIRException("Cannot call addChild on an abstract type FOLDER.details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "FOLDER";

  }

      public FOLDER copy() {
        FOLDER dst = new FOLDER();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FOLDER dst) {
        super.copyValues(dst);
        if (itemsList != null) {
          dst.itemsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : itemsList)
            dst.itemsList.add(i.copy());
        };
        if (foldersList != null) {
          dst.foldersList = new ArrayList<FOLDER>();
          for (FOLDER i : foldersList)
            dst.foldersList.add(i.copy());
        };
        dst.details = details == null ? null : details.copy();
      }

      protected FOLDER typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FOLDER))
          return false;
        FOLDER o = (FOLDER) other_;
        return compareDeep(itemsList, o.itemsList, true) && compareDeep(foldersList, o.foldersList, true)
           && compareDeep(details, o.details, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FOLDER))
          return false;
        FOLDER o = (FOLDER) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(itemsList, foldersList, details
          );
      }


}

