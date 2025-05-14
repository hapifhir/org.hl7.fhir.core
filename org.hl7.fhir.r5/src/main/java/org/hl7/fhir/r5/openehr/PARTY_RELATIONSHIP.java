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
 * Generic description of a relationship between parties.
 */
@DatatypeDef(name="PARTY_RELATIONSHIP")
public class PARTY_RELATIONSHIP extends LOCATABLE implements ICompositeType {

    /**
     * The detailed description of the relationship.
     */
    @Child(name = "details", type = {ITEM_STRUCTURE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The detailed description of the relationship", formalDefinition="The detailed description of the relationship." )
    protected ITEM_STRUCTURE details;

    /**
     * Target of relationship.
     */
    @Child(name = "target", type = {PARTY_REF.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Target of relationship", formalDefinition="Target of relationship." )
    protected PARTY_REF target;

    /**
     * Valid time interval for this relationship.
     */
    @Child(name = "time_validity", type = {DV_INTERVAL.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Valid time interval for this relationship", formalDefinition="Valid time interval for this relationship." )
    protected DV_INTERVAL time_validity;

    /**
     * Source of relationship.
     */
    @Child(name = "source", type = {PARTY_REF.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Source of relationship", formalDefinition="Source of relationship." )
    protected PARTY_REF source;

    private static final long serialVersionUID = -1906999521L;

  /**
   * Constructor
   */
    public PARTY_RELATIONSHIP() {
      super();
    }

  /**
   * Constructor
   */
    public PARTY_RELATIONSHIP(PARTY_REF target, PARTY_REF source) {
      super();
      this.setTarget(target);
      this.setSource(source);
    }

    /**
     * @return {@link #details} (The detailed description of the relationship.)
     */
    public ITEM_STRUCTURE getDetails() { 
      return this.details;
    }

    public boolean hasDetails() { 
      return this.details != null && !this.details.isEmpty();
    }

    /**
     * @param value {@link #details} (The detailed description of the relationship.)
     */
    public PARTY_RELATIONSHIP setDetails(ITEM_STRUCTURE value) { 
      this.details = value;
      return this;
    }

    /**
     * @return {@link #target} (Target of relationship.)
     */
    public PARTY_REF getTarget() { 
      if (this.target == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_RELATIONSHIP.target");
        else if (Configuration.doAutoCreate())
          this.target = new PARTY_REF(); // cc
      return this.target;
    }

    public boolean hasTarget() { 
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (Target of relationship.)
     */
    public PARTY_RELATIONSHIP setTarget(PARTY_REF value) { 
      this.target = value;
      return this;
    }

    /**
     * @return {@link #time_validity} (Valid time interval for this relationship.)
     */
    public DV_INTERVAL getTime_validity() { 
      if (this.time_validity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_RELATIONSHIP.time_validity");
        else if (Configuration.doAutoCreate())
          this.time_validity = new DV_INTERVAL(); // cc
      return this.time_validity;
    }

    public boolean hasTime_validity() { 
      return this.time_validity != null && !this.time_validity.isEmpty();
    }

    /**
     * @param value {@link #time_validity} (Valid time interval for this relationship.)
     */
    public PARTY_RELATIONSHIP setTime_validity(DV_INTERVAL value) { 
      this.time_validity = value;
      return this;
    }

    /**
     * @return {@link #source} (Source of relationship.)
     */
    public PARTY_REF getSource() { 
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_RELATIONSHIP.source");
        else if (Configuration.doAutoCreate())
          this.source = new PARTY_REF(); // cc
      return this.source;
    }

    public boolean hasSource() { 
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (Source of relationship.)
     */
    public PARTY_RELATIONSHIP setSource(PARTY_REF value) { 
      this.source = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The detailed description of the relationship.", 0, 1, details));
        children.add(new Property("target", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Target of relationship.", 0, 1, target));
        children.add(new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for this relationship.", 0, 1, time_validity));
        children.add(new Property("source", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Source of relationship.", 0, 1, source));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1557721666: /*details*/  return new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The detailed description of the relationship.", 0, 1, details);
        case -880905839: /*target*/  return new Property("target", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Target of relationship.", 0, 1, target);
        case -1304171420: /*time_validity*/  return new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for this relationship.", 0, 1, time_validity);
        case -896505829: /*source*/  return new Property("source", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Source of relationship.", 0, 1, source);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1557721666: /*details*/ return this.details == null ? new Base[0] : new Base[] {this.details}; // ITEM_STRUCTURE
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // PARTY_REF
        case -1304171420: /*time_validity*/ return this.time_validity == null ? new Base[0] : new Base[] {this.time_validity}; // DV_INTERVAL
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // PARTY_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1557721666: // details
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case -880905839: // target
          this.target = (PARTY_REF) value; // PARTY_REF
          return value;
        case -1304171420: // time_validity
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        case -896505829: // source
          this.source = (PARTY_REF) value; // PARTY_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("details")) {
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("target")) {
          this.target = (PARTY_REF) value; // PARTY_REF
        } else if (name.equals("time_validity")) {
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
        } else if (name.equals("source")) {
          this.source = (PARTY_REF) value; // PARTY_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1557721666: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'details'");
        case -880905839:  return getTarget();
        case -1304171420:  return getTime_validity();
        case -896505829:  return getSource();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1557721666: /*details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case -880905839: /*target*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-REF"};
        case -1304171420: /*time_validity*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        case -896505829: /*source*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("details")) {
          throw new FHIRException("Cannot call addChild on an abstract type PARTY_RELATIONSHIP.details");
        }
        else if (name.equals("target")) {
          this.target = new PARTY_REF();
          return this.target;
        }
        else if (name.equals("time_validity")) {
          this.time_validity = new DV_INTERVAL();
          return this.time_validity;
        }
        else if (name.equals("source")) {
          this.source = new PARTY_REF();
          return this.source;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY_RELATIONSHIP";

  }

      public PARTY_RELATIONSHIP copy() {
        PARTY_RELATIONSHIP dst = new PARTY_RELATIONSHIP();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PARTY_RELATIONSHIP dst) {
        super.copyValues(dst);
        dst.details = details == null ? null : details.copy();
        dst.target = target == null ? null : target.copy();
        dst.time_validity = time_validity == null ? null : time_validity.copy();
        dst.source = source == null ? null : source.copy();
      }

      protected PARTY_RELATIONSHIP typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY_RELATIONSHIP))
          return false;
        PARTY_RELATIONSHIP o = (PARTY_RELATIONSHIP) other_;
        return compareDeep(details, o.details, true) && compareDeep(target, o.target, true) && compareDeep(time_validity, o.time_validity, true)
           && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY_RELATIONSHIP))
          return false;
        PARTY_RELATIONSHIP o = (PARTY_RELATIONSHIP) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(details, target, time_validity
          , source);
      }


}

