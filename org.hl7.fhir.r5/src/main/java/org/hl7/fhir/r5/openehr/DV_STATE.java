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
 * For representing state values which obey a defined state machine, such as a variable representing the states of an instruction or care process.
 */
@DatatypeDef(name="DV_STATE")
public class DV_STATE extends DATA_VALUE implements ICompositeType {

    /**
     * The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype.
     */
    @Child(name = "value", type = {DV_CODED_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The state name", formalDefinition="The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype." )
    protected DV_CODED_TEXT value;

    /**
     * Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.
     */
    @Child(name = "is_terminal", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates whether this state is a terminal state", formalDefinition="Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible." )
    protected BooleanType is_terminal;

    private static final long serialVersionUID = -1675630194L;

  /**
   * Constructor
   */
    public DV_STATE() {
      super();
    }

  /**
   * Constructor
   */
    public DV_STATE(DV_CODED_TEXT value, boolean is_terminal) {
      super();
      this.setValue(value);
      this.setIs_terminal(is_terminal);
    }

    /**
     * @return {@link #value} (The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype.)
     */
    public DV_CODED_TEXT getValue() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_STATE.value");
        else if (Configuration.doAutoCreate())
          this.value = new DV_CODED_TEXT(); // cc
      return this.value;
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype.)
     */
    public DV_STATE setValue(DV_CODED_TEXT value) { 
      this.value = value;
      return this;
    }

    /**
     * @return {@link #is_terminal} (Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.). This is the underlying object with id, value and extensions. The accessor "getIs_terminal" gives direct access to the value
     */
    public BooleanType getIs_terminalElement() { 
      if (this.is_terminal == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_STATE.is_terminal");
        else if (Configuration.doAutoCreate())
          this.is_terminal = new BooleanType(); // bb
      return this.is_terminal;
    }

    public boolean hasIs_terminalElement() { 
      return this.is_terminal != null && !this.is_terminal.isEmpty();
    }

    public boolean hasIs_terminal() { 
      return this.is_terminal != null && !this.is_terminal.isEmpty();
    }

    /**
     * @param value {@link #is_terminal} (Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.). This is the underlying object with id, value and extensions. The accessor "getIs_terminal" gives direct access to the value
     */
    public DV_STATE setIs_terminalElement(BooleanType value) { 
      this.is_terminal = value;
      return this;
    }

    /**
     * @return Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.
     */
    public boolean getIs_terminal() { 
      return this.is_terminal == null || this.is_terminal.isEmpty() ? false : this.is_terminal.getValue();
    }

    /**
     * @param value Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.
     */
    public DV_STATE setIs_terminal(boolean value) { 
        if (this.is_terminal == null)
          this.is_terminal = new BooleanType();
        this.is_terminal.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype.", 0, 1, value));
        children.add(new Property("is_terminal", "boolean", "Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.", 0, 1, is_terminal));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The state name. State names are determined by a state/event table defined in archetypes, and coded using openEHR Terminology or local archetype terms, as specified by the archetype.", 0, 1, value);
        case -1916279311: /*is_terminal*/  return new Property("is_terminal", "boolean", "Indicates whether this state is a terminal state, such as 'aborted', 'completed' etc. from which no further transitions are possible.", 0, 1, is_terminal);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DV_CODED_TEXT
        case -1916279311: /*is_terminal*/ return this.is_terminal == null ? new Base[0] : new Base[] {this.is_terminal}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -1916279311: // is_terminal
          this.is_terminal = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("is_terminal")) {
          this.is_terminal = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValue();
        case -1916279311:  return getIs_terminalElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -1916279311: /*is_terminal*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          this.value = new DV_CODED_TEXT();
          return this.value;
        }
        else if (name.equals("is_terminal")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_STATE.is_terminal");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_STATE";

  }

      public DV_STATE copy() {
        DV_STATE dst = new DV_STATE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_STATE dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.is_terminal = is_terminal == null ? null : is_terminal.copy();
      }

      protected DV_STATE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_STATE))
          return false;
        DV_STATE o = (DV_STATE) other_;
        return compareDeep(value, o.value, true) && compareDeep(is_terminal, o.is_terminal, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_STATE))
          return false;
        DV_STATE o = (DV_STATE) other_;
        return compareValues(is_terminal, o.is_terminal, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, is_terminal);
      }


}

