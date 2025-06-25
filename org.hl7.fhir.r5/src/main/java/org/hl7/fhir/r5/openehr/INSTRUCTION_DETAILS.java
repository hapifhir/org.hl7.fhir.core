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
import org.hl7.fhir.utilities.Utilities;
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
 * Used to record details of the Instruction causing an Action.
 */
@DatatypeDef(name="INSTRUCTION_DETAILS")
public class INSTRUCTION_DETAILS extends PATHABLE implements ICompositeType {

    /**
     * Reference to causing Instruction.
     */
    @Child(name = "instruction_id", type = {LOCATABLE_REF.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to causing Instruction", formalDefinition="Reference to causing Instruction." )
    protected LOCATABLE_REF instruction_id;

    /**
     * Identifier of Activity within Instruction, in the form of its archetype path.
     */
    @Child(name = "activity_id", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of Activity within Instruction, in the form of its archetype path", formalDefinition="Identifier of Activity within Instruction, in the form of its archetype path." )
    protected StringType activity_id;

    /**
     * Various workflow engine state details, potentially including such things as:

* condition that fired to cause this Action to be done (with actual variables substituted);
* list of notifications which actually occurred (with all variables substituted);
* other workflow engine state.

This specification does not currently define the actual structure or semantics of this field.
     */
    @Child(name = "wf_details", type = {ITEM_STRUCTURE.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Various workflow engine state details", formalDefinition="Various workflow engine state details, potentially including such things as:\r\n\r\n* condition that fired to cause this Action to be done (with actual variables substituted);\r\n* list of notifications which actually occurred (with all variables substituted);\r\n* other workflow engine state.\r\n\r\nThis specification does not currently define the actual structure or semantics of this field." )
    protected ITEM_STRUCTURE wf_details;

    private static final long serialVersionUID = -225495980L;

  /**
   * Constructor
   */
    public INSTRUCTION_DETAILS() {
      super();
    }

  /**
   * Constructor
   */
    public INSTRUCTION_DETAILS(LOCATABLE_REF instruction_id, String activity_id) {
      super();
      this.setInstruction_id(instruction_id);
      this.setActivity_id(activity_id);
    }

    /**
     * @return {@link #instruction_id} (Reference to causing Instruction.)
     */
    public LOCATABLE_REF getInstruction_id() { 
      if (this.instruction_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INSTRUCTION_DETAILS.instruction_id");
        else if (Configuration.doAutoCreate())
          this.instruction_id = new LOCATABLE_REF(); // cc
      return this.instruction_id;
    }

    public boolean hasInstruction_id() { 
      return this.instruction_id != null && !this.instruction_id.isEmpty();
    }

    /**
     * @param value {@link #instruction_id} (Reference to causing Instruction.)
     */
    public INSTRUCTION_DETAILS setInstruction_id(LOCATABLE_REF value) { 
      this.instruction_id = value;
      return this;
    }

    /**
     * @return {@link #activity_id} (Identifier of Activity within Instruction, in the form of its archetype path.). This is the underlying object with id, value and extensions. The accessor "getActivity_id" gives direct access to the value
     */
    public StringType getActivity_idElement() { 
      if (this.activity_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INSTRUCTION_DETAILS.activity_id");
        else if (Configuration.doAutoCreate())
          this.activity_id = new StringType(); // bb
      return this.activity_id;
    }

    public boolean hasActivity_idElement() { 
      return this.activity_id != null && !this.activity_id.isEmpty();
    }

    public boolean hasActivity_id() { 
      return this.activity_id != null && !this.activity_id.isEmpty();
    }

    /**
     * @param value {@link #activity_id} (Identifier of Activity within Instruction, in the form of its archetype path.). This is the underlying object with id, value and extensions. The accessor "getActivity_id" gives direct access to the value
     */
    public INSTRUCTION_DETAILS setActivity_idElement(StringType value) { 
      this.activity_id = value;
      return this;
    }

    /**
     * @return Identifier of Activity within Instruction, in the form of its archetype path.
     */
    public String getActivity_id() { 
      return this.activity_id == null ? null : this.activity_id.getValue();
    }

    /**
     * @param value Identifier of Activity within Instruction, in the form of its archetype path.
     */
    public INSTRUCTION_DETAILS setActivity_id(String value) { 
        if (this.activity_id == null)
          this.activity_id = new StringType();
        this.activity_id.setValue(value);
      return this;
    }

    /**
     * @return {@link #wf_details} (Various workflow engine state details, potentially including such things as:

* condition that fired to cause this Action to be done (with actual variables substituted);
* list of notifications which actually occurred (with all variables substituted);
* other workflow engine state.

This specification does not currently define the actual structure or semantics of this field.)
     */
    public ITEM_STRUCTURE getWf_details() { 
      return this.wf_details;
    }

    public boolean hasWf_details() { 
      return this.wf_details != null && !this.wf_details.isEmpty();
    }

    /**
     * @param value {@link #wf_details} (Various workflow engine state details, potentially including such things as:

* condition that fired to cause this Action to be done (with actual variables substituted);
* list of notifications which actually occurred (with all variables substituted);
* other workflow engine state.

This specification does not currently define the actual structure or semantics of this field.)
     */
    public INSTRUCTION_DETAILS setWf_details(ITEM_STRUCTURE value) { 
      this.wf_details = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("instruction_id", "http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF", "Reference to causing Instruction.", 0, 1, instruction_id));
        children.add(new Property("activity_id", "string", "Identifier of Activity within Instruction, in the form of its archetype path.", 0, 1, activity_id));
        children.add(new Property("wf_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Various workflow engine state details, potentially including such things as:\r\n\r\n* condition that fired to cause this Action to be done (with actual variables substituted);\r\n* list of notifications which actually occurred (with all variables substituted);\r\n* other workflow engine state.\r\n\r\nThis specification does not currently define the actual structure or semantics of this field.", 0, 1, wf_details));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1989251692: /*instruction_id*/  return new Property("instruction_id", "http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF", "Reference to causing Instruction.", 0, 1, instruction_id);
        case -917278645: /*activity_id*/  return new Property("activity_id", "string", "Identifier of Activity within Instruction, in the form of its archetype path.", 0, 1, activity_id);
        case -1966053166: /*wf_details*/  return new Property("wf_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Various workflow engine state details, potentially including such things as:\r\n\r\n* condition that fired to cause this Action to be done (with actual variables substituted);\r\n* list of notifications which actually occurred (with all variables substituted);\r\n* other workflow engine state.\r\n\r\nThis specification does not currently define the actual structure or semantics of this field.", 0, 1, wf_details);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1989251692: /*instruction_id*/ return this.instruction_id == null ? new Base[0] : new Base[] {this.instruction_id}; // LOCATABLE_REF
        case -917278645: /*activity_id*/ return this.activity_id == null ? new Base[0] : new Base[] {this.activity_id}; // StringType
        case -1966053166: /*wf_details*/ return this.wf_details == null ? new Base[0] : new Base[] {this.wf_details}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1989251692: // instruction_id
          this.instruction_id = (LOCATABLE_REF) value; // LOCATABLE_REF
          return value;
        case -917278645: // activity_id
          this.activity_id = TypeConvertor.castToString(value); // StringType
          return value;
        case -1966053166: // wf_details
          this.wf_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("instruction_id")) {
          this.instruction_id = (LOCATABLE_REF) value; // LOCATABLE_REF
        } else if (name.equals("activity_id")) {
          this.activity_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("wf_details")) {
          this.wf_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1989251692:  return getInstruction_id();
        case -917278645:  return getActivity_idElement();
        case -1966053166: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'wf_details'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1989251692: /*instruction_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF"};
        case -917278645: /*activity_id*/ return new String[] {"string"};
        case -1966053166: /*wf_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("instruction_id")) {
          this.instruction_id = new LOCATABLE_REF();
          return this.instruction_id;
        }
        else if (name.equals("activity_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property INSTRUCTION_DETAILS.activity_id");
        }
        else if (name.equals("wf_details")) {
          throw new FHIRException("Cannot call addChild on an abstract type INSTRUCTION_DETAILS.wf_details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "INSTRUCTION_DETAILS";

  }

      public INSTRUCTION_DETAILS copy() {
        INSTRUCTION_DETAILS dst = new INSTRUCTION_DETAILS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(INSTRUCTION_DETAILS dst) {
        super.copyValues(dst);
        dst.instruction_id = instruction_id == null ? null : instruction_id.copy();
        dst.activity_id = activity_id == null ? null : activity_id.copy();
        dst.wf_details = wf_details == null ? null : wf_details.copy();
      }

      protected INSTRUCTION_DETAILS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof INSTRUCTION_DETAILS))
          return false;
        INSTRUCTION_DETAILS o = (INSTRUCTION_DETAILS) other_;
        return compareDeep(instruction_id, o.instruction_id, true) && compareDeep(activity_id, o.activity_id, true)
           && compareDeep(wf_details, o.wf_details, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof INSTRUCTION_DETAILS))
          return false;
        INSTRUCTION_DETAILS o = (INSTRUCTION_DETAILS) other_;
        return compareValues(activity_id, o.activity_id, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(instruction_id, activity_id
          , wf_details);
      }


}

