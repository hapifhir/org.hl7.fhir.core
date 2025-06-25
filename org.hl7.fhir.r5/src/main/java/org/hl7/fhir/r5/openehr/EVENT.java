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
 * Defines the abstract notion of a single event in a series. This class is generic, allowing types to be generated which are locked to particular spatial types, such as EVENT<ITEM_LIST>. Subtypes express point or intveral data.
 */
@DatatypeDef(name="EVENT")
public abstract class EVENT extends LOCATABLE implements ICompositeType {

    /**
     * Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event
     */
    @Child(name = "time", type = {DV_DATE_TIME.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time of this event", formalDefinition="Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event" )
    protected DV_DATE_TIME time;

    /**
     * Optional state data for this event.
     */
    @Child(name = "state", type = {ITEM_STRUCTURE.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional state data for this event", formalDefinition="Optional state data for this event." )
    protected ITEM_STRUCTURE state;

    /**
     * The data of this event.
     */
    @Child(name = "data", type = {Reference.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The data of this event", formalDefinition="The data of this event." )
    protected Any data;

    private static final long serialVersionUID = 1692464616L;

  /**
   * Constructor
   */
    public EVENT() {
      super();
    }

  /**
   * Constructor
   */
    public EVENT(DV_DATE_TIME time, Any data) {
      super();
      this.setTime(time);
      this.setData(data);
    }

    /**
     * @return {@link #time} (Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event)
     */
    public DV_DATE_TIME getTime() { 
      if (this.time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT.time");
        else if (Configuration.doAutoCreate())
          this.time = new DV_DATE_TIME(); // cc
      return this.time;
    }

    public boolean hasTime() { 
      return this.time != null && !this.time.isEmpty();
    }

    /**
     * @param value {@link #time} (Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event)
     */
    public EVENT setTime(DV_DATE_TIME value) { 
      this.time = value;
      return this;
    }

    /**
     * @return {@link #state} (Optional state data for this event.)
     */
    public ITEM_STRUCTURE getState() { 
      return this.state;
    }

    public boolean hasState() { 
      return this.state != null && !this.state.isEmpty();
    }

    /**
     * @param value {@link #state} (Optional state data for this event.)
     */
    public EVENT setState(ITEM_STRUCTURE value) { 
      this.state = value;
      return this;
    }

    /**
     * @return {@link #data} (The data of this event.)
     */
    public Any getData() { 
      return this.data;
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (The data of this event.)
     */
    public EVENT setData(Any value) { 
      this.data = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event", 0, 1, time));
        children.add(new Property("state", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional state data for this event.", 0, 1, state));
        children.add(new Property("data", "http://openehr.org/fhir/StructureDefinition/Any", "The data of this event.", 0, 1, data));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3560141: /*time*/  return new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of this event. If the width is non-zero, it is the time point of the trailing edge of the event", 0, 1, time);
        case 109757585: /*state*/  return new Property("state", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional state data for this event.", 0, 1, state);
        case 3076010: /*data*/  return new Property("data", "http://openehr.org/fhir/StructureDefinition/Any", "The data of this event.", 0, 1, data);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DV_DATE_TIME
        case 109757585: /*state*/ return this.state == null ? new Base[0] : new Base[] {this.state}; // ITEM_STRUCTURE
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // Any
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3560141: // time
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case 109757585: // state
          this.state = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case 3076010: // data
          this.data = (Any) value; // Any
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("time")) {
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("state")) {
          this.state = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("data")) {
          this.data = (Any) value; // Any
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3560141:  return getTime();
        case 109757585: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'state'");
        case 3076010: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'data'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3560141: /*time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case 109757585: /*state*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case 3076010: /*data*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/Any"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("time")) {
          this.time = new DV_DATE_TIME();
          return this.time;
        }
        else if (name.equals("state")) {
          throw new FHIRException("Cannot call addChild on an abstract type EVENT.state");
        }
        else if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on an abstract type EVENT.data");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EVENT";

  }

      public abstract EVENT copy();

      public void copyValues(EVENT dst) {
        super.copyValues(dst);
        dst.time = time == null ? null : time.copy();
        dst.state = state == null ? null : state.copy();
        dst.data = data == null ? null : data.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EVENT))
          return false;
        EVENT o = (EVENT) other_;
        return compareDeep(time, o.time, true) && compareDeep(state, o.state, true) && compareDeep(data, o.data, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EVENT))
          return false;
        EVENT o = (EVENT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(time, state, data);
      }


}

