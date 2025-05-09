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
 * Logical relational database style table data structure, in which columns are named and ordered with respect to each other. Implemented using Cluster-per-row encoding. Each row Cluster must have an identical number of Elements, each of which in turn must have identical names and value types in the corresponding positions in each row. Some columns may be designated key' columns, containing key data for each row, in the manner of relational tables. This allows row-naming, where each row represents a body site, a blood antigen etc. All values in a column have the same data type. Used for representing any data which is logically a table of values, such as blood pressure, most protocols, many blood tests etc. Misuse: Not to be used for time-based data, which should be represented with the temporal class HISTORY. The table may be empty.
 */
@DatatypeDef(name="ITEM_TABLE")
public class ITEM_TABLE extends ITEM_STRUCTURE implements ICompositeType {

    /**
     * Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table.
     */
    @Child(name = "rows", type = {CLUSTER.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table", formalDefinition="Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table." )
    protected List<CLUSTER> rowsList;

    private static final long serialVersionUID = 514606961L;

  /**
   * Constructor
   */
    public ITEM_TABLE() {
      super();
    }

    /**
     * @return {@link #rows} (Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table.)
     */
    public List<CLUSTER> getRowsList() { 
      if (this.rowsList == null)
        this.rowsList = new ArrayList<CLUSTER>();
      return this.rowsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ITEM_TABLE setRowsList(List<CLUSTER> theRows) { 
      this.rowsList = theRows;
      return this;
    }

    public boolean hasRows() { 
      if (this.rowsList == null)
        return false;
      for (CLUSTER item : this.rowsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CLUSTER addRows() { //3a
      CLUSTER t = new CLUSTER();
      if (this.rowsList == null)
        this.rowsList = new ArrayList<CLUSTER>();
      this.rowsList.add(t);
      return t;
    }

    public ITEM_TABLE addRows(CLUSTER t) { //3b
      if (t == null)
        return this;
      if (this.rowsList == null)
        this.rowsList = new ArrayList<CLUSTER>();
      this.rowsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #rows}, creating it if it does not already exist {3}
     */
    public CLUSTER getRowsFirstRep() { 
      if (getRowsList().isEmpty()) {
        addRows();
      }
      return getRowsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("rows", "http://openehr.org/fhir/StructureDefinition/CLUSTER", "Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table.", 0, java.lang.Integer.MAX_VALUE, rowsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3506649: /*rows*/  return new Property("rows", "http://openehr.org/fhir/StructureDefinition/CLUSTER", "Physical representation of the table as a list of CLUSTERs, each containing the data of one row of the table.", 0, java.lang.Integer.MAX_VALUE, rowsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506649: /*rows*/ return this.rowsList == null ? new Base[0] : this.rowsList.toArray(new Base[this.rowsList.size()]); // CLUSTER
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506649: // rows
          this.getRowsList().add((CLUSTER) value); // CLUSTER
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("rows")) {
          this.getRowsList().add((CLUSTER) value); // CLUSTER
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506649:  return addRows(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506649: /*rows*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CLUSTER"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("rows")) {
          return addRows();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ITEM_TABLE";

  }

      public ITEM_TABLE copy() {
        ITEM_TABLE dst = new ITEM_TABLE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ITEM_TABLE dst) {
        super.copyValues(dst);
        if (rowsList != null) {
          dst.rowsList = new ArrayList<CLUSTER>();
          for (CLUSTER i : rowsList)
            dst.rowsList.add(i.copy());
        };
      }

      protected ITEM_TABLE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ITEM_TABLE))
          return false;
        ITEM_TABLE o = (ITEM_TABLE) other_;
        return compareDeep(rowsList, o.rowsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ITEM_TABLE))
          return false;
        ITEM_TABLE o = (ITEM_TABLE) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(rowsList);
      }


}

