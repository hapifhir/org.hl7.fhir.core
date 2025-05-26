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
 * Generic description of a role performed by an Actor. The role corresponds to a competency of the Party. Roles are used to define the responsibilities undertaken by a Party for a purpose. Roles should have credentials qualifying the performer to perform the role.
 */
@DatatypeDef(name="ROLE")
public class ROLE extends PARTY implements ICompositeType {

    /**
     * Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on.
     */
    @Child(name = "time_validity", type = {DV_INTERVAL.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on", formalDefinition="Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on." )
    protected DV_INTERVAL time_validity;

    /**
     * Contacts for this ROLE.
     */
    @Child(name = "performer", type = {PARTY_REF.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Contacts for this ROLE", formalDefinition="Contacts for this ROLE." )
    protected PARTY_REF performer;

    /**
     * All other details for this ROLE.
     */
    @Child(name = "capabilities", type = {CAPABILITY.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="All other details for this ROLE", formalDefinition="All other details for this ROLE." )
    protected List<CAPABILITY> capabilitiesList;

    private static final long serialVersionUID = 1286378228L;

  /**
   * Constructor
   */
    public ROLE() {
      super();
    }

  /**
   * Constructor
   */
    public ROLE(PARTY_REF performer) {
      super();
      this.setPerformer(performer);
    }

    /**
     * @return {@link #time_validity} (Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on.)
     */
    public DV_INTERVAL getTime_validity() { 
      if (this.time_validity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ROLE.time_validity");
        else if (Configuration.doAutoCreate())
          this.time_validity = new DV_INTERVAL(); // cc
      return this.time_validity;
    }

    public boolean hasTime_validity() { 
      return this.time_validity != null && !this.time_validity.isEmpty();
    }

    /**
     * @param value {@link #time_validity} (Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on.)
     */
    public ROLE setTime_validity(DV_INTERVAL value) { 
      this.time_validity = value;
      return this;
    }

    /**
     * @return {@link #performer} (Contacts for this ROLE.)
     */
    public PARTY_REF getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ROLE.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new PARTY_REF(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (Contacts for this ROLE.)
     */
    public ROLE setPerformer(PARTY_REF value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #capabilities} (All other details for this ROLE.)
     */
    public List<CAPABILITY> getCapabilitiesList() { 
      if (this.capabilitiesList == null)
        this.capabilitiesList = new ArrayList<CAPABILITY>();
      return this.capabilitiesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ROLE setCapabilitiesList(List<CAPABILITY> theCapabilities) { 
      this.capabilitiesList = theCapabilities;
      return this;
    }

    public boolean hasCapabilities() { 
      if (this.capabilitiesList == null)
        return false;
      for (CAPABILITY item : this.capabilitiesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CAPABILITY addCapabilities() { //3a
      CAPABILITY t = new CAPABILITY();
      if (this.capabilitiesList == null)
        this.capabilitiesList = new ArrayList<CAPABILITY>();
      this.capabilitiesList.add(t);
      return t;
    }

    public ROLE addCapabilities(CAPABILITY t) { //3b
      if (t == null)
        return this;
      if (this.capabilitiesList == null)
        this.capabilitiesList = new ArrayList<CAPABILITY>();
      this.capabilitiesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #capabilities}, creating it if it does not already exist {3}
     */
    public CAPABILITY getCapabilitiesFirstRep() { 
      if (getCapabilitiesList().isEmpty()) {
        addCapabilities();
      }
      return getCapabilitiesList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on.", 0, 1, time_validity));
        children.add(new Property("performer", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Contacts for this ROLE.", 0, 1, performer));
        children.add(new Property("capabilities", "http://openehr.org/fhir/StructureDefinition/CAPABILITY", "All other details for this ROLE.", 0, java.lang.Integer.MAX_VALUE, capabilitiesList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1304171420: /*time_validity*/  return new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Identities used by the ROLE to identify itself, such as legal name, stage names, aliases, nicknames and so on.", 0, 1, time_validity);
        case 481140686: /*performer*/  return new Property("performer", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Contacts for this ROLE.", 0, 1, performer);
        case -1487597642: /*capabilities*/  return new Property("capabilities", "http://openehr.org/fhir/StructureDefinition/CAPABILITY", "All other details for this ROLE.", 0, java.lang.Integer.MAX_VALUE, capabilitiesList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1304171420: /*time_validity*/ return this.time_validity == null ? new Base[0] : new Base[] {this.time_validity}; // DV_INTERVAL
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // PARTY_REF
        case -1487597642: /*capabilities*/ return this.capabilitiesList == null ? new Base[0] : this.capabilitiesList.toArray(new Base[this.capabilitiesList.size()]); // CAPABILITY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1304171420: // time_validity
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        case 481140686: // performer
          this.performer = (PARTY_REF) value; // PARTY_REF
          return value;
        case -1487597642: // capabilities
          this.getCapabilitiesList().add((CAPABILITY) value); // CAPABILITY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("time_validity")) {
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
        } else if (name.equals("performer")) {
          this.performer = (PARTY_REF) value; // PARTY_REF
        } else if (name.equals("capabilities")) {
          this.getCapabilitiesList().add((CAPABILITY) value); // CAPABILITY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1304171420:  return getTime_validity();
        case 481140686:  return getPerformer();
        case -1487597642:  return addCapabilities(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1304171420: /*time_validity*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        case 481140686: /*performer*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-REF"};
        case -1487597642: /*capabilities*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CAPABILITY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("time_validity")) {
          this.time_validity = new DV_INTERVAL();
          return this.time_validity;
        }
        else if (name.equals("performer")) {
          this.performer = new PARTY_REF();
          return this.performer;
        }
        else if (name.equals("capabilities")) {
          return addCapabilities();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ROLE";

  }

      public ROLE copy() {
        ROLE dst = new ROLE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ROLE dst) {
        super.copyValues(dst);
        dst.time_validity = time_validity == null ? null : time_validity.copy();
        dst.performer = performer == null ? null : performer.copy();
        if (capabilitiesList != null) {
          dst.capabilitiesList = new ArrayList<CAPABILITY>();
          for (CAPABILITY i : capabilitiesList)
            dst.capabilitiesList.add(i.copy());
        };
      }

      protected ROLE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ROLE))
          return false;
        ROLE o = (ROLE) other_;
        return compareDeep(time_validity, o.time_validity, true) && compareDeep(performer, o.performer, true)
           && compareDeep(capabilitiesList, o.capabilitiesList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ROLE))
          return false;
        ROLE o = (ROLE) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(time_validity, performer, capabilitiesList
          );
      }


}

