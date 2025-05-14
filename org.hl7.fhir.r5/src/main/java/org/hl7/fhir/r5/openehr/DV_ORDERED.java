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
 * Abstract class defining the concept of ordered values, which includes ordinals as well as true quantities. It defines the functions < and is_strictly_comparable_to(), the latter of which must evaluate to True for instances being compared with the < function, or used as limits in the DV_INTERVAL<T> class
 */
@DatatypeDef(name="DV_ORDERED")
public abstract class DV_ORDERED extends DATA_VALUE implements ICompositeType {

    /**
     * Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status.
     */
    @Child(name = "normal_status", type = {CODE_PHRASE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional normal status indicator of value with respect to normal range for this value", formalDefinition="Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-normal_statuses")
    protected CODE_PHRASE normal_status;

    /**
     * Optional normal range.
     */
    @Child(name = "normal_range", type = {DV_INTERVAL.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional normal range", formalDefinition="Optional normal range." )
    protected DV_INTERVAL normal_range;

    /**
     * Optional tagged other reference ranges for this value in its particular measurement context.
     */
    @Child(name = "other_reference_ranges", type = {REFERENCE_RANGE.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Optional tagged other reference ranges for this value in its particular measurement context", formalDefinition="Optional tagged other reference ranges for this value in its particular measurement context." )
    protected List<REFERENCE_RANGE> other_reference_rangesList;

    private static final long serialVersionUID = 1994158948L;

  /**
   * Constructor
   */
    public DV_ORDERED() {
      super();
    }

    /**
     * @return {@link #normal_status} (Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status.)
     */
    public CODE_PHRASE getNormal_status() { 
      if (this.normal_status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ORDERED.normal_status");
        else if (Configuration.doAutoCreate())
          this.normal_status = new CODE_PHRASE(); // cc
      return this.normal_status;
    }

    public boolean hasNormal_status() { 
      return this.normal_status != null && !this.normal_status.isEmpty();
    }

    /**
     * @param value {@link #normal_status} (Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status.)
     */
    public DV_ORDERED setNormal_status(CODE_PHRASE value) { 
      this.normal_status = value;
      return this;
    }

    /**
     * @return {@link #normal_range} (Optional normal range.)
     */
    public DV_INTERVAL getNormal_range() { 
      if (this.normal_range == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ORDERED.normal_range");
        else if (Configuration.doAutoCreate())
          this.normal_range = new DV_INTERVAL(); // cc
      return this.normal_range;
    }

    public boolean hasNormal_range() { 
      return this.normal_range != null && !this.normal_range.isEmpty();
    }

    /**
     * @param value {@link #normal_range} (Optional normal range.)
     */
    public DV_ORDERED setNormal_range(DV_INTERVAL value) { 
      this.normal_range = value;
      return this;
    }

    /**
     * @return {@link #other_reference_ranges} (Optional tagged other reference ranges for this value in its particular measurement context.)
     */
    public List<REFERENCE_RANGE> getOther_reference_rangesList() { 
      if (this.other_reference_rangesList == null)
        this.other_reference_rangesList = new ArrayList<REFERENCE_RANGE>();
      return this.other_reference_rangesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DV_ORDERED setOther_reference_rangesList(List<REFERENCE_RANGE> theOther_reference_ranges) { 
      this.other_reference_rangesList = theOther_reference_ranges;
      return this;
    }

    public boolean hasOther_reference_ranges() { 
      if (this.other_reference_rangesList == null)
        return false;
      for (REFERENCE_RANGE item : this.other_reference_rangesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public REFERENCE_RANGE addOther_reference_ranges() { //3a
      REFERENCE_RANGE t = new REFERENCE_RANGE();
      if (this.other_reference_rangesList == null)
        this.other_reference_rangesList = new ArrayList<REFERENCE_RANGE>();
      this.other_reference_rangesList.add(t);
      return t;
    }

    public DV_ORDERED addOther_reference_ranges(REFERENCE_RANGE t) { //3b
      if (t == null)
        return this;
      if (this.other_reference_rangesList == null)
        this.other_reference_rangesList = new ArrayList<REFERENCE_RANGE>();
      this.other_reference_rangesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #other_reference_ranges}, creating it if it does not already exist {3}
     */
    public REFERENCE_RANGE getOther_reference_rangesFirstRep() { 
      if (getOther_reference_rangesList().isEmpty()) {
        addOther_reference_ranges();
      }
      return getOther_reference_rangesList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("normal_status", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status.", 0, 1, normal_status));
        children.add(new Property("normal_range", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Optional normal range.", 0, 1, normal_range));
        children.add(new Property("other_reference_ranges", "http://openehr.org/fhir/StructureDefinition/REFERENCE-RANGE", "Optional tagged other reference ranges for this value in its particular measurement context.", 0, java.lang.Integer.MAX_VALUE, other_reference_rangesList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1868886454: /*normal_status*/  return new Property("normal_status", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional normal status indicator of value with respect to normal range for this value. Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H, (nothing), L, LL, LLL; see openEHR terminology group normal_status.", 0, 1, normal_status);
        case 492425189: /*normal_range*/  return new Property("normal_range", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Optional normal range.", 0, 1, normal_range);
        case -1668425831: /*other_reference_ranges*/  return new Property("other_reference_ranges", "http://openehr.org/fhir/StructureDefinition/REFERENCE-RANGE", "Optional tagged other reference ranges for this value in its particular measurement context.", 0, java.lang.Integer.MAX_VALUE, other_reference_rangesList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1868886454: /*normal_status*/ return this.normal_status == null ? new Base[0] : new Base[] {this.normal_status}; // CODE_PHRASE
        case 492425189: /*normal_range*/ return this.normal_range == null ? new Base[0] : new Base[] {this.normal_range}; // DV_INTERVAL
        case -1668425831: /*other_reference_ranges*/ return this.other_reference_rangesList == null ? new Base[0] : this.other_reference_rangesList.toArray(new Base[this.other_reference_rangesList.size()]); // REFERENCE_RANGE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1868886454: // normal_status
          this.normal_status = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 492425189: // normal_range
          this.normal_range = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        case -1668425831: // other_reference_ranges
          this.getOther_reference_rangesList().add((REFERENCE_RANGE) value); // REFERENCE_RANGE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("normal_status")) {
          this.normal_status = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("normal_range")) {
          this.normal_range = (DV_INTERVAL) value; // DV_INTERVAL
        } else if (name.equals("other_reference_ranges")) {
          this.getOther_reference_rangesList().add((REFERENCE_RANGE) value); // REFERENCE_RANGE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1868886454:  return getNormal_status();
        case 492425189:  return getNormal_range();
        case -1668425831:  return addOther_reference_ranges(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1868886454: /*normal_status*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 492425189: /*normal_range*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        case -1668425831: /*other_reference_ranges*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/REFERENCE-RANGE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("normal_status")) {
          this.normal_status = new CODE_PHRASE();
          return this.normal_status;
        }
        else if (name.equals("normal_range")) {
          this.normal_range = new DV_INTERVAL();
          return this.normal_range;
        }
        else if (name.equals("other_reference_ranges")) {
          return addOther_reference_ranges();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_ORDERED";

  }

      public abstract DV_ORDERED copy();

      public void copyValues(DV_ORDERED dst) {
        super.copyValues(dst);
        dst.normal_status = normal_status == null ? null : normal_status.copy();
        dst.normal_range = normal_range == null ? null : normal_range.copy();
        if (other_reference_rangesList != null) {
          dst.other_reference_rangesList = new ArrayList<REFERENCE_RANGE>();
          for (REFERENCE_RANGE i : other_reference_rangesList)
            dst.other_reference_rangesList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_ORDERED))
          return false;
        DV_ORDERED o = (DV_ORDERED) other_;
        return compareDeep(normal_status, o.normal_status, true) && compareDeep(normal_range, o.normal_range, true)
           && compareDeep(other_reference_rangesList, o.other_reference_rangesList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_ORDERED))
          return false;
        DV_ORDERED o = (DV_ORDERED) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(normal_status, normal_range
          , other_reference_rangesList);
      }


}

