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
 * Used to record a clinical action that has been performed, which may have been ad hoc, or due to the execution of an Activity in an Instruction workflow. Every Action corresponds to a careflow step of some kind or another.
 */
@DatatypeDef(name="ACTION")
public class ACTION extends CARE_ENTRY implements ICompositeType {

    /**
     * Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <.
     */
    @Child(name = "time", type = {DV_DATE_TIME.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Point in time at which this action completed", formalDefinition="Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <." )
    protected DV_DATE_TIME time;

    /**
     * Details of transition in the Instruction state machine caused by this Action.
     */
    @Child(name = "ism_transition", type = {ISM_TRANSITION.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details of transition in the Instruction state machine caused by this Action", formalDefinition="Details of transition in the Instruction state machine caused by this Action." )
    protected ISM_TRANSITION ism_transition;

    /**
     * Details of the Instruction that caused this Action to be performed, if there was one.
     */
    @Child(name = "instruction_details", type = {INSTRUCTION_DETAILS.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details of the Instruction that caused this Action to be performed, if there was one", formalDefinition="Details of the Instruction that caused this Action to be performed, if there was one." )
    protected INSTRUCTION_DETAILS instruction_details;

    /**
     * Description of the action that has been performed, in the form of an archetyped structure.
     */
    @Child(name = "description", type = {ITEM_STRUCTURE.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the action that has been performed, in the form of an archetyped structure", formalDefinition="Description of the action that has been performed, in the form of an archetyped structure." )
    protected ITEM_STRUCTURE description;

    private static final long serialVersionUID = -850420733L;

  /**
   * Constructor
   */
    public ACTION() {
      super();
    }

  /**
   * Constructor
   */
    public ACTION(DV_DATE_TIME time, ISM_TRANSITION ism_transition, ITEM_STRUCTURE description) {
      super();
      this.setTime(time);
      this.setIsm_transition(ism_transition);
      this.setDescription(description);
    }

    /**
     * @return {@link #time} (Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <.)
     */
    public DV_DATE_TIME getTime() { 
      if (this.time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ACTION.time");
        else if (Configuration.doAutoCreate())
          this.time = new DV_DATE_TIME(); // cc
      return this.time;
    }

    public boolean hasTime() { 
      return this.time != null && !this.time.isEmpty();
    }

    /**
     * @param value {@link #time} (Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <.)
     */
    public ACTION setTime(DV_DATE_TIME value) { 
      this.time = value;
      return this;
    }

    /**
     * @return {@link #ism_transition} (Details of transition in the Instruction state machine caused by this Action.)
     */
    public ISM_TRANSITION getIsm_transition() { 
      if (this.ism_transition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ACTION.ism_transition");
        else if (Configuration.doAutoCreate())
          this.ism_transition = new ISM_TRANSITION(); // cc
      return this.ism_transition;
    }

    public boolean hasIsm_transition() { 
      return this.ism_transition != null && !this.ism_transition.isEmpty();
    }

    /**
     * @param value {@link #ism_transition} (Details of transition in the Instruction state machine caused by this Action.)
     */
    public ACTION setIsm_transition(ISM_TRANSITION value) { 
      this.ism_transition = value;
      return this;
    }

    /**
     * @return {@link #instruction_details} (Details of the Instruction that caused this Action to be performed, if there was one.)
     */
    public INSTRUCTION_DETAILS getInstruction_details() { 
      if (this.instruction_details == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ACTION.instruction_details");
        else if (Configuration.doAutoCreate())
          this.instruction_details = new INSTRUCTION_DETAILS(); // cc
      return this.instruction_details;
    }

    public boolean hasInstruction_details() { 
      return this.instruction_details != null && !this.instruction_details.isEmpty();
    }

    /**
     * @param value {@link #instruction_details} (Details of the Instruction that caused this Action to be performed, if there was one.)
     */
    public ACTION setInstruction_details(INSTRUCTION_DETAILS value) { 
      this.instruction_details = value;
      return this;
    }

    /**
     * @return {@link #description} (Description of the action that has been performed, in the form of an archetyped structure.)
     */
    public ITEM_STRUCTURE getDescription() { 
      return this.description;
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Description of the action that has been performed, in the form of an archetyped structure.)
     */
    public ACTION setDescription(ITEM_STRUCTURE value) { 
      this.description = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <.", 0, 1, time));
        children.add(new Property("ism_transition", "http://openehr.org/fhir/StructureDefinition/ISM-TRANSITION", "Details of transition in the Instruction state machine caused by this Action.", 0, 1, ism_transition));
        children.add(new Property("instruction_details", "http://openehr.org/fhir/StructureDefinition/INSTRUCTION-DETAILS", "Details of the Instruction that caused this Action to be performed, if there was one.", 0, 1, instruction_details));
        children.add(new Property("description", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the action that has been performed, in the form of an archetyped structure.", 0, 1, description));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3560141: /*time*/  return new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Point in time at which this action completed. To indicate an unknown time, use a DV_DATE_TIME instance with value set to the time of creation (or some other known time before which the Action is known to have occurred, e.g. data accession timestamp from integration engine), and magnitude_status set to <.", 0, 1, time);
        case -376386927: /*ism_transition*/  return new Property("ism_transition", "http://openehr.org/fhir/StructureDefinition/ISM-TRANSITION", "Details of transition in the Instruction state machine caused by this Action.", 0, 1, ism_transition);
        case -676653167: /*instruction_details*/  return new Property("instruction_details", "http://openehr.org/fhir/StructureDefinition/INSTRUCTION-DETAILS", "Details of the Instruction that caused this Action to be performed, if there was one.", 0, 1, instruction_details);
        case -1724546052: /*description*/  return new Property("description", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the action that has been performed, in the form of an archetyped structure.", 0, 1, description);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DV_DATE_TIME
        case -376386927: /*ism_transition*/ return this.ism_transition == null ? new Base[0] : new Base[] {this.ism_transition}; // ISM_TRANSITION
        case -676653167: /*instruction_details*/ return this.instruction_details == null ? new Base[0] : new Base[] {this.instruction_details}; // INSTRUCTION_DETAILS
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3560141: // time
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -376386927: // ism_transition
          this.ism_transition = (ISM_TRANSITION) value; // ISM_TRANSITION
          return value;
        case -676653167: // instruction_details
          this.instruction_details = (INSTRUCTION_DETAILS) value; // INSTRUCTION_DETAILS
          return value;
        case -1724546052: // description
          this.description = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("time")) {
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("ism_transition")) {
          this.ism_transition = (ISM_TRANSITION) value; // ISM_TRANSITION
        } else if (name.equals("instruction_details")) {
          this.instruction_details = (INSTRUCTION_DETAILS) value; // INSTRUCTION_DETAILS
        } else if (name.equals("description")) {
          this.description = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3560141:  return getTime();
        case -376386927:  return getIsm_transition();
        case -676653167:  return getInstruction_details();
        case -1724546052: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'description'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3560141: /*time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -376386927: /*ism_transition*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ISM-TRANSITION"};
        case -676653167: /*instruction_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/INSTRUCTION-DETAILS"};
        case -1724546052: /*description*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("time")) {
          this.time = new DV_DATE_TIME();
          return this.time;
        }
        else if (name.equals("ism_transition")) {
          this.ism_transition = new ISM_TRANSITION();
          return this.ism_transition;
        }
        else if (name.equals("instruction_details")) {
          this.instruction_details = new INSTRUCTION_DETAILS();
          return this.instruction_details;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on an abstract type ACTION.description");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ACTION";

  }

      public ACTION copy() {
        ACTION dst = new ACTION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ACTION dst) {
        super.copyValues(dst);
        dst.time = time == null ? null : time.copy();
        dst.ism_transition = ism_transition == null ? null : ism_transition.copy();
        dst.instruction_details = instruction_details == null ? null : instruction_details.copy();
        dst.description = description == null ? null : description.copy();
      }

      protected ACTION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ACTION))
          return false;
        ACTION o = (ACTION) other_;
        return compareDeep(time, o.time, true) && compareDeep(ism_transition, o.ism_transition, true) && compareDeep(instruction_details, o.instruction_details, true)
           && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ACTION))
          return false;
        ACTION o = (ACTION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(time, ism_transition, instruction_details
          , description);
      }


}

