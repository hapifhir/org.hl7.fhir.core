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
 * Used to specify actions in the future. Enables simple and complex specifications to be expressed, including in a fully-computable workflow form. Used for any actionable statement such as medication and therapeutic orders, monitoring, recall and review. Enough details must be provided for the specification to be directly executed by an actor, either human or machine. Not to be used for plan items which are only specified in general terms.
 */
@DatatypeDef(name="ACTIVITY")
public class ACTIVITY extends LOCATABLE implements ICompositeType {

    /**
     * Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS.
     */
    @Child(name = "timing", type = {DV_PARSABLE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Timing of the activity, in the form of a parsable string", formalDefinition="Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS." )
    protected DV_PARSABLE timing;

    /**
     * Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.* /, meaning any archetype.
     */
    @Child(name = "action_archetype_id", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Perl-compliant regular expression pattern indicating the valid identifiers of archetypes for Actions corresponding to this Activity", formalDefinition="Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.*/, meaning any archetype." )
    protected StringType action_archetype_id;

    /**
     * Description of the activity, in the form of an archetyped structure.
     */
    @Child(name = "description", type = {ITEM_STRUCTURE.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the activity, in the form of an archetyped structure", formalDefinition="Description of the activity, in the form of an archetyped structure." )
    protected ITEM_STRUCTURE description;

    private static final long serialVersionUID = 1041755607L;

  /**
   * Constructor
   */
    public ACTIVITY() {
      super();
    }

  /**
   * Constructor
   */
    public ACTIVITY(String action_archetype_id, ITEM_STRUCTURE description) {
      super();
      this.setAction_archetype_id(action_archetype_id);
      this.setDescription(description);
    }

    /**
     * @return {@link #timing} (Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS.)
     */
    public DV_PARSABLE getTiming() { 
      if (this.timing == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ACTIVITY.timing");
        else if (Configuration.doAutoCreate())
          this.timing = new DV_PARSABLE(); // cc
      return this.timing;
    }

    public boolean hasTiming() { 
      return this.timing != null && !this.timing.isEmpty();
    }

    /**
     * @param value {@link #timing} (Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS.)
     */
    public ACTIVITY setTiming(DV_PARSABLE value) { 
      this.timing = value;
      return this;
    }

    /**
     * @return {@link #action_archetype_id} (Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.* /, meaning any archetype.). This is the underlying object with id, value and extensions. The accessor "getAction_archetype_id" gives direct access to the value
     */
    public StringType getAction_archetype_idElement() { 
      if (this.action_archetype_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ACTIVITY.action_archetype_id");
        else if (Configuration.doAutoCreate())
          this.action_archetype_id = new StringType(); // bb
      return this.action_archetype_id;
    }

    public boolean hasAction_archetype_idElement() { 
      return this.action_archetype_id != null && !this.action_archetype_id.isEmpty();
    }

    public boolean hasAction_archetype_id() { 
      return this.action_archetype_id != null && !this.action_archetype_id.isEmpty();
    }

    /**
     * @param value {@link #action_archetype_id} (Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.* /, meaning any archetype.). This is the underlying object with id, value and extensions. The accessor "getAction_archetype_id" gives direct access to the value
     */
    public ACTIVITY setAction_archetype_idElement(StringType value) { 
      this.action_archetype_id = value;
      return this;
    }

    /**
     * @return Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.* /, meaning any archetype.
     */
    public String getAction_archetype_id() { 
      return this.action_archetype_id == null ? null : this.action_archetype_id.getValue();
    }

    /**
     * @param value Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.* /, meaning any archetype.
     */
    public ACTIVITY setAction_archetype_id(String value) { 
        if (this.action_archetype_id == null)
          this.action_archetype_id = new StringType();
        this.action_archetype_id.setValue(value);
      return this;
    }

    /**
     * @return {@link #description} (Description of the activity, in the form of an archetyped structure.)
     */
    public ITEM_STRUCTURE getDescription() { 
      return this.description;
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Description of the activity, in the form of an archetyped structure.)
     */
    public ACTIVITY setDescription(ITEM_STRUCTURE value) { 
      this.description = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("timing", "http://openehr.org/fhir/StructureDefinition/DV-PARSABLE", "Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS.", 0, 1, timing));
        children.add(new Property("action_archetype_id", "string", "Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.*/, meaning any archetype.", 0, 1, action_archetype_id));
        children.add(new Property("description", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the activity, in the form of an archetyped structure.", 0, 1, description));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -873664438: /*timing*/  return new Property("timing", "http://openehr.org/fhir/StructureDefinition/DV-PARSABLE", "Timing of the activity, in the form of a parsable string. If used, the preferred syntax is ISO8601 'R' format, but other formats may be used including HL7 GTS.", 0, 1, timing);
        case 1059971578: /*action_archetype_id*/  return new Property("action_archetype_id", "string", "Perl-compliant regular expression pattern, enclosed in '//' delimiters, indicating the valid identifiers of archetypes for Actions corresponding to this Activity specification. Defaults to /.*/, meaning any archetype.", 0, 1, action_archetype_id);
        case -1724546052: /*description*/  return new Property("description", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the activity, in the form of an archetyped structure.", 0, 1, description);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DV_PARSABLE
        case 1059971578: /*action_archetype_id*/ return this.action_archetype_id == null ? new Base[0] : new Base[] {this.action_archetype_id}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -873664438: // timing
          this.timing = (DV_PARSABLE) value; // DV_PARSABLE
          return value;
        case 1059971578: // action_archetype_id
          this.action_archetype_id = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("timing")) {
          this.timing = (DV_PARSABLE) value; // DV_PARSABLE
        } else if (name.equals("action_archetype_id")) {
          this.action_archetype_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -873664438:  return getTiming();
        case 1059971578:  return getAction_archetype_idElement();
        case -1724546052: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'description'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -873664438: /*timing*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-PARSABLE"};
        case 1059971578: /*action_archetype_id*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("timing")) {
          this.timing = new DV_PARSABLE();
          return this.timing;
        }
        else if (name.equals("action_archetype_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property ACTIVITY.action_archetype_id");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on an abstract type ACTIVITY.description");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ACTIVITY";

  }

      public ACTIVITY copy() {
        ACTIVITY dst = new ACTIVITY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ACTIVITY dst) {
        super.copyValues(dst);
        dst.timing = timing == null ? null : timing.copy();
        dst.action_archetype_id = action_archetype_id == null ? null : action_archetype_id.copy();
        dst.description = description == null ? null : description.copy();
      }

      protected ACTIVITY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ACTIVITY))
          return false;
        ACTIVITY o = (ACTIVITY) other_;
        return compareDeep(timing, o.timing, true) && compareDeep(action_archetype_id, o.action_archetype_id, true)
           && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ACTIVITY))
          return false;
        ACTIVITY o = (ACTIVITY) other_;
        return compareValues(action_archetype_id, o.action_archetype_id, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(timing, action_archetype_id
          , description);
      }


}

