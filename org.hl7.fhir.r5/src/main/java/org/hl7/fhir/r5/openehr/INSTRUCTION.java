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
 * Used to specify actions in the future. Enables simple and complex specifications to be expressed, including in a fully-computable workflow form. Used for any actionable statement such as medication and therapeutic orders, monitoring, recall and review. Enough details must be provided for the specification to be directly executed by an actor, either human or machine. Not to be used for plan items which are only specified in general terms.
 */
@DatatypeDef(name="INSTRUCTION")
public class INSTRUCTION extends CARE_ENTRY implements ICompositeType {

    /**
     * Mandatory human-readable version of what the Instruction is about.
     */
    @Child(name = "narrative", type = {DV_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Mandatory human-readable version of what the Instruction is about", formalDefinition="Mandatory human-readable version of what the Instruction is about." )
    protected DV_TEXT narrative;

    /**
     * Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other.
     */
    @Child(name = "expiry_time", type = {DV_DATE_TIME.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired", formalDefinition="Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other." )
    protected DV_DATE_TIME expiry_time;

    /**
     * Optional workflow engine executable expression of the Instruction.
     */
    @Child(name = "wf_definition", type = {DV_PARSABLE.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional workflow engine executable expression of the Instruction", formalDefinition="Optional workflow engine executable expression of the Instruction." )
    protected DV_PARSABLE wf_definition;

    /**
     * List of all activities in Instruction.
     */
    @Child(name = "activities", type = {ACTIVITY.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="List of all activities in Instruction", formalDefinition="List of all activities in Instruction." )
    protected List<ACTIVITY> activitiesList;

    private static final long serialVersionUID = -797234340L;

  /**
   * Constructor
   */
    public INSTRUCTION() {
      super();
    }

  /**
   * Constructor
   */
    public INSTRUCTION(DV_TEXT narrative) {
      super();
      this.setNarrative(narrative);
    }

    /**
     * @return {@link #narrative} (Mandatory human-readable version of what the Instruction is about.)
     */
    public DV_TEXT getNarrative() { 
      if (this.narrative == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INSTRUCTION.narrative");
        else if (Configuration.doAutoCreate())
          this.narrative = new DV_TEXT(); // cc
      return this.narrative;
    }

    public boolean hasNarrative() { 
      return this.narrative != null && !this.narrative.isEmpty();
    }

    /**
     * @param value {@link #narrative} (Mandatory human-readable version of what the Instruction is about.)
     */
    public INSTRUCTION setNarrative(DV_TEXT value) { 
      this.narrative = value;
      return this;
    }

    /**
     * @return {@link #expiry_time} (Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other.)
     */
    public DV_DATE_TIME getExpiry_time() { 
      if (this.expiry_time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INSTRUCTION.expiry_time");
        else if (Configuration.doAutoCreate())
          this.expiry_time = new DV_DATE_TIME(); // cc
      return this.expiry_time;
    }

    public boolean hasExpiry_time() { 
      return this.expiry_time != null && !this.expiry_time.isEmpty();
    }

    /**
     * @param value {@link #expiry_time} (Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other.)
     */
    public INSTRUCTION setExpiry_time(DV_DATE_TIME value) { 
      this.expiry_time = value;
      return this;
    }

    /**
     * @return {@link #wf_definition} (Optional workflow engine executable expression of the Instruction.)
     */
    public DV_PARSABLE getWf_definition() { 
      if (this.wf_definition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create INSTRUCTION.wf_definition");
        else if (Configuration.doAutoCreate())
          this.wf_definition = new DV_PARSABLE(); // cc
      return this.wf_definition;
    }

    public boolean hasWf_definition() { 
      return this.wf_definition != null && !this.wf_definition.isEmpty();
    }

    /**
     * @param value {@link #wf_definition} (Optional workflow engine executable expression of the Instruction.)
     */
    public INSTRUCTION setWf_definition(DV_PARSABLE value) { 
      this.wf_definition = value;
      return this;
    }

    /**
     * @return {@link #activities} (List of all activities in Instruction.)
     */
    public List<ACTIVITY> getActivitiesList() { 
      if (this.activitiesList == null)
        this.activitiesList = new ArrayList<ACTIVITY>();
      return this.activitiesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public INSTRUCTION setActivitiesList(List<ACTIVITY> theActivities) { 
      this.activitiesList = theActivities;
      return this;
    }

    public boolean hasActivities() { 
      if (this.activitiesList == null)
        return false;
      for (ACTIVITY item : this.activitiesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ACTIVITY addActivities() { //3a
      ACTIVITY t = new ACTIVITY();
      if (this.activitiesList == null)
        this.activitiesList = new ArrayList<ACTIVITY>();
      this.activitiesList.add(t);
      return t;
    }

    public INSTRUCTION addActivities(ACTIVITY t) { //3b
      if (t == null)
        return this;
      if (this.activitiesList == null)
        this.activitiesList = new ArrayList<ACTIVITY>();
      this.activitiesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #activities}, creating it if it does not already exist {3}
     */
    public ACTIVITY getActivitiesFirstRep() { 
      if (getActivitiesList().isEmpty()) {
        addActivities();
      }
      return getActivitiesList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("narrative", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Mandatory human-readable version of what the Instruction is about.", 0, 1, narrative));
        children.add(new Property("expiry_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other.", 0, 1, expiry_time));
        children.add(new Property("wf_definition", "http://openehr.org/fhir/StructureDefinition/DV-PARSABLE", "Optional workflow engine executable expression of the Instruction.", 0, 1, wf_definition));
        children.add(new Property("activities", "http://openehr.org/fhir/StructureDefinition/ACTIVITY", "List of all activities in Instruction.", 0, java.lang.Integer.MAX_VALUE, activitiesList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1750452338: /*narrative*/  return new Property("narrative", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Mandatory human-readable version of what the Instruction is about.", 0, 1, narrative);
        case 476403289: /*expiry_time*/  return new Property("expiry_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Optional expiry date/time to assist determination of when an Instruction can be assumed to have expired. This helps prevent false listing of Instructions as Active when they clearly must have been terminated in some way or other.", 0, 1, expiry_time);
        case -199789373: /*wf_definition*/  return new Property("wf_definition", "http://openehr.org/fhir/StructureDefinition/DV-PARSABLE", "Optional workflow engine executable expression of the Instruction.", 0, 1, wf_definition);
        case 2048605165: /*activities*/  return new Property("activities", "http://openehr.org/fhir/StructureDefinition/ACTIVITY", "List of all activities in Instruction.", 0, java.lang.Integer.MAX_VALUE, activitiesList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1750452338: /*narrative*/ return this.narrative == null ? new Base[0] : new Base[] {this.narrative}; // DV_TEXT
        case 476403289: /*expiry_time*/ return this.expiry_time == null ? new Base[0] : new Base[] {this.expiry_time}; // DV_DATE_TIME
        case -199789373: /*wf_definition*/ return this.wf_definition == null ? new Base[0] : new Base[] {this.wf_definition}; // DV_PARSABLE
        case 2048605165: /*activities*/ return this.activitiesList == null ? new Base[0] : this.activitiesList.toArray(new Base[this.activitiesList.size()]); // ACTIVITY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1750452338: // narrative
          this.narrative = (DV_TEXT) value; // DV_TEXT
          return value;
        case 476403289: // expiry_time
          this.expiry_time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -199789373: // wf_definition
          this.wf_definition = (DV_PARSABLE) value; // DV_PARSABLE
          return value;
        case 2048605165: // activities
          this.getActivitiesList().add((ACTIVITY) value); // ACTIVITY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("narrative")) {
          this.narrative = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("expiry_time")) {
          this.expiry_time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("wf_definition")) {
          this.wf_definition = (DV_PARSABLE) value; // DV_PARSABLE
        } else if (name.equals("activities")) {
          this.getActivitiesList().add((ACTIVITY) value); // ACTIVITY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1750452338:  return getNarrative();
        case 476403289:  return getExpiry_time();
        case -199789373:  return getWf_definition();
        case 2048605165:  return addActivities(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1750452338: /*narrative*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 476403289: /*expiry_time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -199789373: /*wf_definition*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-PARSABLE"};
        case 2048605165: /*activities*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ACTIVITY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("narrative")) {
          this.narrative = new DV_TEXT();
          return this.narrative;
        }
        else if (name.equals("expiry_time")) {
          this.expiry_time = new DV_DATE_TIME();
          return this.expiry_time;
        }
        else if (name.equals("wf_definition")) {
          this.wf_definition = new DV_PARSABLE();
          return this.wf_definition;
        }
        else if (name.equals("activities")) {
          return addActivities();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "INSTRUCTION";

  }

      public INSTRUCTION copy() {
        INSTRUCTION dst = new INSTRUCTION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(INSTRUCTION dst) {
        super.copyValues(dst);
        dst.narrative = narrative == null ? null : narrative.copy();
        dst.expiry_time = expiry_time == null ? null : expiry_time.copy();
        dst.wf_definition = wf_definition == null ? null : wf_definition.copy();
        if (activitiesList != null) {
          dst.activitiesList = new ArrayList<ACTIVITY>();
          for (ACTIVITY i : activitiesList)
            dst.activitiesList.add(i.copy());
        };
      }

      protected INSTRUCTION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof INSTRUCTION))
          return false;
        INSTRUCTION o = (INSTRUCTION) other_;
        return compareDeep(narrative, o.narrative, true) && compareDeep(expiry_time, o.expiry_time, true)
           && compareDeep(wf_definition, o.wf_definition, true) && compareDeep(activitiesList, o.activitiesList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof INSTRUCTION))
          return false;
        INSTRUCTION o = (INSTRUCTION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(narrative, expiry_time, wf_definition
          , activitiesList);
      }


}

