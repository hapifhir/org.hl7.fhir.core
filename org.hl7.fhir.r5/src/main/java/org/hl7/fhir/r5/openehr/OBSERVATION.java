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
 * Entry subtype for all clinical data in the past or present, i.e. which (by the time it is recorded) has already occurred. OBSERVATION data is expressed using the class HISTORY<T>, which guarantees that it is situated in time. OBSERVATION is used for all notionally objective (i.e. measured in some way) observations of phenomena, and patient-reported phenomena, e.g. pain. Not to be used for recording opinion or future statements of any kind, including instructions, intentions, plans etc.
 */
@DatatypeDef(name="OBSERVATION")
public class OBSERVATION extends CARE_ENTRY implements ICompositeType {

    /**
     * The data of this observation, in the form of a history of values which may be of any complexity.
     */
    @Child(name = "data", type = {HISTORY.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The data of this observation, in the form of a history of values which may be of any complexity", formalDefinition="The data of this observation, in the form of a history of values which may be of any complexity." )
    protected HISTORY data;

    /**
     * Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute.
     */
    @Child(name = "state", type = {HISTORY.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional recording of the state of subject of this observation during the observation process", formalDefinition="Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute." )
    protected HISTORY state;

    private static final long serialVersionUID = -787276715L;

  /**
   * Constructor
   */
    public OBSERVATION() {
      super();
    }

  /**
   * Constructor
   */
    public OBSERVATION(HISTORY data) {
      super();
      this.setData(data);
    }

    /**
     * @return {@link #data} (The data of this observation, in the form of a history of values which may be of any complexity.)
     */
    public HISTORY getData() { 
      if (this.data == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OBSERVATION.data");
        else if (Configuration.doAutoCreate())
          this.data = new HISTORY(); // cc
      return this.data;
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (The data of this observation, in the form of a history of values which may be of any complexity.)
     */
    public OBSERVATION setData(HISTORY value) { 
      this.data = value;
      return this;
    }

    /**
     * @return {@link #state} (Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute.)
     */
    public HISTORY getState() { 
      if (this.state == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OBSERVATION.state");
        else if (Configuration.doAutoCreate())
          this.state = new HISTORY(); // cc
      return this.state;
    }

    public boolean hasState() { 
      return this.state != null && !this.state.isEmpty();
    }

    /**
     * @param value {@link #state} (Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute.)
     */
    public OBSERVATION setState(HISTORY value) { 
      this.state = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("data", "http://openehr.org/fhir/StructureDefinition/HISTORY", "The data of this observation, in the form of a history of values which may be of any complexity.", 0, 1, data));
        children.add(new Property("state", "http://openehr.org/fhir/StructureDefinition/HISTORY", "Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute.", 0, 1, state));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3076010: /*data*/  return new Property("data", "http://openehr.org/fhir/StructureDefinition/HISTORY", "The data of this observation, in the form of a history of values which may be of any complexity.", 0, 1, data);
        case 109757585: /*state*/  return new Property("state", "http://openehr.org/fhir/StructureDefinition/HISTORY", "Optional recording of the state of subject of this observation during the observation process, in the form of a separate history of values which may be of any complexity. State may also be recorded within the History of the data attribute.", 0, 1, state);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // HISTORY
        case 109757585: /*state*/ return this.state == null ? new Base[0] : new Base[] {this.state}; // HISTORY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3076010: // data
          this.data = (HISTORY) value; // HISTORY
          return value;
        case 109757585: // state
          this.state = (HISTORY) value; // HISTORY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("data")) {
          this.data = (HISTORY) value; // HISTORY
        } else if (name.equals("state")) {
          this.state = (HISTORY) value; // HISTORY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076010:  return getData();
        case 109757585:  return getState();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076010: /*data*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HISTORY"};
        case 109757585: /*state*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HISTORY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("data")) {
          this.data = new HISTORY();
          return this.data;
        }
        else if (name.equals("state")) {
          this.state = new HISTORY();
          return this.state;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "OBSERVATION";

  }

      public OBSERVATION copy() {
        OBSERVATION dst = new OBSERVATION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OBSERVATION dst) {
        super.copyValues(dst);
        dst.data = data == null ? null : data.copy();
        dst.state = state == null ? null : state.copy();
      }

      protected OBSERVATION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OBSERVATION))
          return false;
        OBSERVATION o = (OBSERVATION) other_;
        return compareDeep(data, o.data, true) && compareDeep(state, o.state, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OBSERVATION))
          return false;
        OBSERVATION o = (OBSERVATION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(data, state);
      }


}

