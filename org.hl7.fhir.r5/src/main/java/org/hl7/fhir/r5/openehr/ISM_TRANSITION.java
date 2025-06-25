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
 * Model of a transition in the Instruction State Machine, caused by a careflow step. The attributes document the careflow step as well as the ISM transition.
 */
@DatatypeDef(name="ISM_TRANSITION")
public class ISM_TRANSITION extends PATHABLE implements ICompositeType {

    /**
     * The ISM current state. Coded by openEHR terminology group Instruction states.
     */
    @Child(name = "current_state", type = {DV_CODED_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The ISM current state. Coded by openEHR terminology group Instruction states", formalDefinition="The ISM current state. Coded by openEHR terminology group Instruction states." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-instruction_states")
    protected DV_CODED_TEXT current_state;

    /**
     * The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions.
     */
    @Child(name = "transition", type = {DV_CODED_TEXT.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The ISM transition which occurred to arrive in the current_state", formalDefinition="The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-instruction_transitions")
    protected DV_CODED_TEXT transition;

    /**
     * The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype.
     */
    @Child(name = "careflow_step", type = {DV_CODED_TEXT.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The step in the careflow process which occurred as part of generating this action", formalDefinition="The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype." )
    protected DV_CODED_TEXT careflow_step;

    /**
     * Optional possibility of adding one or more reasons for this careflow step having been taken. Multiple reasons may occur in medication management for example.
     */
    @Child(name = "reason", type = {DV_TEXT.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Optional possibility of adding one or more reasons for this careflow step having been taken", formalDefinition="Optional possibility of adding one or more reasons for this careflow step having been taken. Multiple reasons may occur in medication management for example." )
    protected List<DV_TEXT> reasonList;

    private static final long serialVersionUID = 2077167668L;

  /**
   * Constructor
   */
    public ISM_TRANSITION() {
      super();
    }

  /**
   * Constructor
   */
    public ISM_TRANSITION(DV_CODED_TEXT current_state) {
      super();
      this.setCurrent_state(current_state);
    }

    /**
     * @return {@link #current_state} (The ISM current state. Coded by openEHR terminology group Instruction states.)
     */
    public DV_CODED_TEXT getCurrent_state() { 
      if (this.current_state == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ISM_TRANSITION.current_state");
        else if (Configuration.doAutoCreate())
          this.current_state = new DV_CODED_TEXT(); // cc
      return this.current_state;
    }

    public boolean hasCurrent_state() { 
      return this.current_state != null && !this.current_state.isEmpty();
    }

    /**
     * @param value {@link #current_state} (The ISM current state. Coded by openEHR terminology group Instruction states.)
     */
    public ISM_TRANSITION setCurrent_state(DV_CODED_TEXT value) { 
      this.current_state = value;
      return this;
    }

    /**
     * @return {@link #transition} (The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions.)
     */
    public DV_CODED_TEXT getTransition() { 
      if (this.transition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ISM_TRANSITION.transition");
        else if (Configuration.doAutoCreate())
          this.transition = new DV_CODED_TEXT(); // cc
      return this.transition;
    }

    public boolean hasTransition() { 
      return this.transition != null && !this.transition.isEmpty();
    }

    /**
     * @param value {@link #transition} (The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions.)
     */
    public ISM_TRANSITION setTransition(DV_CODED_TEXT value) { 
      this.transition = value;
      return this;
    }

    /**
     * @return {@link #careflow_step} (The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype.)
     */
    public DV_CODED_TEXT getCareflow_step() { 
      if (this.careflow_step == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ISM_TRANSITION.careflow_step");
        else if (Configuration.doAutoCreate())
          this.careflow_step = new DV_CODED_TEXT(); // cc
      return this.careflow_step;
    }

    public boolean hasCareflow_step() { 
      return this.careflow_step != null && !this.careflow_step.isEmpty();
    }

    /**
     * @param value {@link #careflow_step} (The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype.)
     */
    public ISM_TRANSITION setCareflow_step(DV_CODED_TEXT value) { 
      this.careflow_step = value;
      return this;
    }

    /**
     * @return {@link #reason} (Optional possibility of adding one or more reasons for this careflow step having been taken. Multiple reasons may occur in medication management for example.)
     */
    public List<DV_TEXT> getReasonList() { 
      if (this.reasonList == null)
        this.reasonList = new ArrayList<DV_TEXT>();
      return this.reasonList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ISM_TRANSITION setReasonList(List<DV_TEXT> theReason) { 
      this.reasonList = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reasonList == null)
        return false;
      for (DV_TEXT item : this.reasonList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_TEXT addReason() { //3a
      DV_TEXT t = new DV_TEXT();
      if (this.reasonList == null)
        this.reasonList = new ArrayList<DV_TEXT>();
      this.reasonList.add(t);
      return t;
    }

    public ISM_TRANSITION addReason(DV_TEXT t) { //3b
      if (t == null)
        return this;
      if (this.reasonList == null)
        this.reasonList = new ArrayList<DV_TEXT>();
      this.reasonList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public DV_TEXT getReasonFirstRep() { 
      if (getReasonList().isEmpty()) {
        addReason();
      }
      return getReasonList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("current_state", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The ISM current state. Coded by openEHR terminology group Instruction states.", 0, 1, current_state));
        children.add(new Property("transition", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions.", 0, 1, transition));
        children.add(new Property("careflow_step", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype.", 0, 1, careflow_step));
        children.add(new Property("reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional possibility of adding one or more reasons for this careflow step having been taken. Multiple reasons may occur in medication management for example.", 0, java.lang.Integer.MAX_VALUE, reasonList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1708972469: /*current_state*/  return new Property("current_state", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The ISM current state. Coded by openEHR terminology group Instruction states.", 0, 1, current_state);
        case -1724158635: /*transition*/  return new Property("transition", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The ISM transition which occurred to arrive in the current_state. Coded by openEHR terminology group Instruction transitions.", 0, 1, transition);
        case 2086974284: /*careflow_step*/  return new Property("careflow_step", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The step in the careflow process which occurred as part of generating this action, e.g. dispense , start_administration. This attribute represents the clinical label for the activity, as opposed to current_state which represents the state machine (ISM) computable form. Defined in archetype.", 0, 1, careflow_step);
        case -934964668: /*reason*/  return new Property("reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Optional possibility of adding one or more reasons for this careflow step having been taken. Multiple reasons may occur in medication management for example.", 0, java.lang.Integer.MAX_VALUE, reasonList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1708972469: /*current_state*/ return this.current_state == null ? new Base[0] : new Base[] {this.current_state}; // DV_CODED_TEXT
        case -1724158635: /*transition*/ return this.transition == null ? new Base[0] : new Base[] {this.transition}; // DV_CODED_TEXT
        case 2086974284: /*careflow_step*/ return this.careflow_step == null ? new Base[0] : new Base[] {this.careflow_step}; // DV_CODED_TEXT
        case -934964668: /*reason*/ return this.reasonList == null ? new Base[0] : this.reasonList.toArray(new Base[this.reasonList.size()]); // DV_TEXT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1708972469: // current_state
          this.current_state = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -1724158635: // transition
          this.transition = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case 2086974284: // careflow_step
          this.careflow_step = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -934964668: // reason
          this.getReasonList().add((DV_TEXT) value); // DV_TEXT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("current_state")) {
          this.current_state = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("transition")) {
          this.transition = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("careflow_step")) {
          this.careflow_step = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("reason")) {
          this.getReasonList().add((DV_TEXT) value); // DV_TEXT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1708972469:  return getCurrent_state();
        case -1724158635:  return getTransition();
        case 2086974284:  return getCareflow_step();
        case -934964668:  return addReason(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1708972469: /*current_state*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -1724158635: /*transition*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case 2086974284: /*careflow_step*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -934964668: /*reason*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("current_state")) {
          this.current_state = new DV_CODED_TEXT();
          return this.current_state;
        }
        else if (name.equals("transition")) {
          this.transition = new DV_CODED_TEXT();
          return this.transition;
        }
        else if (name.equals("careflow_step")) {
          this.careflow_step = new DV_CODED_TEXT();
          return this.careflow_step;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ISM_TRANSITION";

  }

      public ISM_TRANSITION copy() {
        ISM_TRANSITION dst = new ISM_TRANSITION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ISM_TRANSITION dst) {
        super.copyValues(dst);
        dst.current_state = current_state == null ? null : current_state.copy();
        dst.transition = transition == null ? null : transition.copy();
        dst.careflow_step = careflow_step == null ? null : careflow_step.copy();
        if (reasonList != null) {
          dst.reasonList = new ArrayList<DV_TEXT>();
          for (DV_TEXT i : reasonList)
            dst.reasonList.add(i.copy());
        };
      }

      protected ISM_TRANSITION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ISM_TRANSITION))
          return false;
        ISM_TRANSITION o = (ISM_TRANSITION) other_;
        return compareDeep(current_state, o.current_state, true) && compareDeep(transition, o.transition, true)
           && compareDeep(careflow_step, o.careflow_step, true) && compareDeep(reasonList, o.reasonList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ISM_TRANSITION))
          return false;
        ISM_TRANSITION o = (ISM_TRANSITION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(current_state, transition
          , careflow_step, reasonList);
      }


}

