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
 * Model of a participation of a Party (any Actor or Role) in an activity. Used to represent any participation of a Party in some activity, which is not explicitly in the model, e.g. assisting nurse. Can be used to record past or future participations. Should not be used in place of more permanent relationships between demographic entities.
 */
@DatatypeDef(name="PARTICIPATION")
public class PARTICIPATION extends LOCATABLE implements ICompositeType {

    /**
     * Optional reference to more detailed demographic or identification information for this party, in an external system.
     */
    @Child(name = "function", type = {DV_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to more detailed demographic or identification information for this party", formalDefinition="Optional reference to more detailed demographic or identification information for this party, in an external system." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-participation_function")
    protected DV_TEXT function;

    /**
     * Optional reference to more detailed demographic or identification information for this party, in an external system.
     */
    @Child(name = "mode", type = {DV_CODED_TEXT.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to more detailed demographic or identification information for this party", formalDefinition="Optional reference to more detailed demographic or identification information for this party, in an external system." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-participation_mode")
    protected DV_CODED_TEXT mode;

    /**
     * Optional reference to more detailed demographic or identification information for this party, in an external system.
     */
    @Child(name = "performer", type = {PARTY_PROXY.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to more detailed demographic or identification information for this party", formalDefinition="Optional reference to more detailed demographic or identification information for this party, in an external system." )
    protected PARTY_PROXY performer;

    /**
     * Optional reference to more detailed demographic or identification information for this party, in an external system.
     */
    @Child(name = "time", type = {DV_INTERVAL.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to more detailed demographic or identification information for this party", formalDefinition="Optional reference to more detailed demographic or identification information for this party, in an external system." )
    protected DV_INTERVAL time;

    private static final long serialVersionUID = -595665945L;

  /**
   * Constructor
   */
    public PARTICIPATION() {
      super();
    }

  /**
   * Constructor
   */
    public PARTICIPATION(DV_TEXT function, PARTY_PROXY performer) {
      super();
      this.setFunction(function);
      this.setPerformer(performer);
    }

    /**
     * @return {@link #function} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public DV_TEXT getFunction() { 
      if (this.function == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTICIPATION.function");
        else if (Configuration.doAutoCreate())
          this.function = new DV_TEXT(); // cc
      return this.function;
    }

    public boolean hasFunction() { 
      return this.function != null && !this.function.isEmpty();
    }

    /**
     * @param value {@link #function} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTICIPATION setFunction(DV_TEXT value) { 
      this.function = value;
      return this;
    }

    /**
     * @return {@link #mode} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public DV_CODED_TEXT getMode() { 
      if (this.mode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTICIPATION.mode");
        else if (Configuration.doAutoCreate())
          this.mode = new DV_CODED_TEXT(); // cc
      return this.mode;
    }

    public boolean hasMode() { 
      return this.mode != null && !this.mode.isEmpty();
    }

    /**
     * @param value {@link #mode} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTICIPATION setMode(DV_CODED_TEXT value) { 
      this.mode = value;
      return this;
    }

    /**
     * @return {@link #performer} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTY_PROXY getPerformer() { 
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTICIPATION setPerformer(PARTY_PROXY value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #time} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public DV_INTERVAL getTime() { 
      if (this.time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTICIPATION.time");
        else if (Configuration.doAutoCreate())
          this.time = new DV_INTERVAL(); // cc
      return this.time;
    }

    public boolean hasTime() { 
      return this.time != null && !this.time.isEmpty();
    }

    /**
     * @param value {@link #time} (Optional reference to more detailed demographic or identification information for this party, in an external system.)
     */
    public PARTICIPATION setTime(DV_INTERVAL value) { 
      this.time = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("function", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, function));
        children.add(new Property("mode", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, mode));
        children.add(new Property("performer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, performer));
        children.add(new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, time));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1380938712: /*function*/  return new Property("function", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, function);
        case 3357091: /*mode*/  return new Property("mode", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, mode);
        case 481140686: /*performer*/  return new Property("performer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, performer);
        case 3560141: /*time*/  return new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Optional reference to more detailed demographic or identification information for this party, in an external system.", 0, 1, time);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // DV_TEXT
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // DV_CODED_TEXT
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // PARTY_PROXY
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DV_INTERVAL
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = (DV_TEXT) value; // DV_TEXT
          return value;
        case 3357091: // mode
          this.mode = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case 481140686: // performer
          this.performer = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        case 3560141: // time
          this.time = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("mode")) {
          this.mode = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("performer")) {
          this.performer = (PARTY_PROXY) value; // PARTY_PROXY
        } else if (name.equals("time")) {
          this.time = (DV_INTERVAL) value; // DV_INTERVAL
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 3357091:  return getMode();
        case 481140686: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'performer'");
        case 3560141:  return getTime();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 3357091: /*mode*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case 481140686: /*performer*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        case 3560141: /*time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new DV_TEXT();
          return this.function;
        }
        else if (name.equals("mode")) {
          this.mode = new DV_CODED_TEXT();
          return this.mode;
        }
        else if (name.equals("performer")) {
          throw new FHIRException("Cannot call addChild on an abstract type PARTICIPATION.performer");
        }
        else if (name.equals("time")) {
          this.time = new DV_INTERVAL();
          return this.time;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTICIPATION";

  }

      public PARTICIPATION copy() {
        PARTICIPATION dst = new PARTICIPATION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PARTICIPATION dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.mode = mode == null ? null : mode.copy();
        dst.performer = performer == null ? null : performer.copy();
        dst.time = time == null ? null : time.copy();
      }

      protected PARTICIPATION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTICIPATION))
          return false;
        PARTICIPATION o = (PARTICIPATION) other_;
        return compareDeep(function, o.function, true) && compareDeep(mode, o.mode, true) && compareDeep(performer, o.performer, true)
           && compareDeep(time, o.time, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTICIPATION))
          return false;
        PARTICIPATION o = (PARTICIPATION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, mode, performer
          , time);
      }


}

