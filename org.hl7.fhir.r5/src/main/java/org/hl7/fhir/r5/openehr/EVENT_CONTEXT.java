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
 * Documents the context information of a healthcare event involving the subject of care and the health system. The context information recorded here are independent of the attributes recorded in the version audit, which document the system interaction context, i.e. the context of a user interacting with the health record system. Healthcare events include patient contacts, and any other business activity, such as pathology investigations which take place on behalf of the patient.
 */
@DatatypeDef(name="EVENT_CONTEXT")
public class EVENT_CONTEXT extends LOCATABLE implements ICompositeType {

    /**
     * Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient.
     */
    @Child(name = "start_time", type = {DV_DATE_TIME.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient", formalDefinition="Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient." )
    protected DV_DATE_TIME start_time;

    /**
     * Optional end time of the clinical session.
     */
    @Child(name = "end_time", type = {DV_DATE_TIME.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional end time of the clinical session", formalDefinition="Optional end time of the clinical session." )
    protected DV_DATE_TIME end_time;

    /**
     * The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.
     */
    @Child(name = "location", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on", formalDefinition="The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-composition_category")
    protected StringType location;

    /**
     * The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.
     */
    @Child(name = "setting", type = {DV_CODED_TEXT.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The clinical session context of this Composition, i.e. the contextual attributes of the clinical session", formalDefinition="The clinical session context of this Composition, i.e. the contextual attributes of the clinical session." )
    protected DV_CODED_TEXT setting;

    /**
     * Other optional context which will be archetyped.
     */
    @Child(name = "other_context", type = {ITEM_STRUCTURE.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Other optional context which will be archetyped", formalDefinition="Other optional context which will be archetyped." )
    protected ITEM_STRUCTURE other_context;

    /**
     * The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability.
     */
    @Child(name = "health_care_facility", type = {PARTY_IDENTIFIED.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The health care facility under whose care the event took place", formalDefinition="The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability." )
    protected PARTY_IDENTIFIED health_care_facility;

    /**
     * Parties involved in the healthcare event. These would normally include the physician(s) and often the patient (but not the latter if the clinical session is a pathology test for example).
     */
    @Child(name = "participations", type = {PARTICIPATION.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Parties involved in the healthcare event", formalDefinition="Parties involved in the healthcare event. These would normally include the physician(s) and often the patient (but not the latter if the clinical session is a pathology test for example)." )
    protected List<PARTICIPATION> participationsList;

    private static final long serialVersionUID = -454658763L;

  /**
   * Constructor
   */
    public EVENT_CONTEXT() {
      super();
    }

  /**
   * Constructor
   */
    public EVENT_CONTEXT(DV_DATE_TIME start_time, DV_CODED_TEXT setting) {
      super();
      this.setStart_time(start_time);
      this.setSetting(setting);
    }

    /**
     * @return {@link #start_time} (Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient.)
     */
    public DV_DATE_TIME getStart_time() { 
      if (this.start_time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT_CONTEXT.start_time");
        else if (Configuration.doAutoCreate())
          this.start_time = new DV_DATE_TIME(); // cc
      return this.start_time;
    }

    public boolean hasStart_time() { 
      return this.start_time != null && !this.start_time.isEmpty();
    }

    /**
     * @param value {@link #start_time} (Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient.)
     */
    public EVENT_CONTEXT setStart_time(DV_DATE_TIME value) { 
      this.start_time = value;
      return this;
    }

    /**
     * @return {@link #end_time} (Optional end time of the clinical session.)
     */
    public DV_DATE_TIME getEnd_time() { 
      if (this.end_time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT_CONTEXT.end_time");
        else if (Configuration.doAutoCreate())
          this.end_time = new DV_DATE_TIME(); // cc
      return this.end_time;
    }

    public boolean hasEnd_time() { 
      return this.end_time != null && !this.end_time.isEmpty();
    }

    /**
     * @param value {@link #end_time} (Optional end time of the clinical session.)
     */
    public EVENT_CONTEXT setEnd_time(DV_DATE_TIME value) { 
      this.end_time = value;
      return this;
    }

    /**
     * @return {@link #location} (The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.). This is the underlying object with id, value and extensions. The accessor "getLocation" gives direct access to the value
     */
    public StringType getLocationElement() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT_CONTEXT.location");
        else if (Configuration.doAutoCreate())
          this.location = new StringType(); // bb
      return this.location;
    }

    public boolean hasLocationElement() { 
      return this.location != null && !this.location.isEmpty();
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.). This is the underlying object with id, value and extensions. The accessor "getLocation" gives direct access to the value
     */
    public EVENT_CONTEXT setLocationElement(StringType value) { 
      this.location = value;
      return this;
    }

    /**
     * @return The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.
     */
    public String getLocation() { 
      return this.location == null ? null : this.location.getValue();
    }

    /**
     * @param value The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.
     */
    public EVENT_CONTEXT setLocation(String value) { 
      if (Utilities.noString(value))
        this.location = null;
      else {
        if (this.location == null)
          this.location = new StringType();
        this.location.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #setting} (The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.)
     */
    public DV_CODED_TEXT getSetting() { 
      if (this.setting == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT_CONTEXT.setting");
        else if (Configuration.doAutoCreate())
          this.setting = new DV_CODED_TEXT(); // cc
      return this.setting;
    }

    public boolean hasSetting() { 
      return this.setting != null && !this.setting.isEmpty();
    }

    /**
     * @param value {@link #setting} (The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.)
     */
    public EVENT_CONTEXT setSetting(DV_CODED_TEXT value) { 
      this.setting = value;
      return this;
    }

    /**
     * @return {@link #other_context} (Other optional context which will be archetyped.)
     */
    public ITEM_STRUCTURE getOther_context() { 
      return this.other_context;
    }

    public boolean hasOther_context() { 
      return this.other_context != null && !this.other_context.isEmpty();
    }

    /**
     * @param value {@link #other_context} (Other optional context which will be archetyped.)
     */
    public EVENT_CONTEXT setOther_context(ITEM_STRUCTURE value) { 
      this.other_context = value;
      return this;
    }

    /**
     * @return {@link #health_care_facility} (The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability.)
     */
    public PARTY_IDENTIFIED getHealth_care_facility() { 
      if (this.health_care_facility == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EVENT_CONTEXT.health_care_facility");
        else if (Configuration.doAutoCreate())
          this.health_care_facility = new PARTY_IDENTIFIED(); // cc
      return this.health_care_facility;
    }

    public boolean hasHealth_care_facility() { 
      return this.health_care_facility != null && !this.health_care_facility.isEmpty();
    }

    /**
     * @param value {@link #health_care_facility} (The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability.)
     */
    public EVENT_CONTEXT setHealth_care_facility(PARTY_IDENTIFIED value) { 
      this.health_care_facility = value;
      return this;
    }

    /**
     * @return {@link #participations} (Parties involved in the healthcare event. These would normally include the physician(s) and often the patient (but not the latter if the clinical session is a pathology test for example).)
     */
    public List<PARTICIPATION> getParticipationsList() { 
      if (this.participationsList == null)
        this.participationsList = new ArrayList<PARTICIPATION>();
      return this.participationsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EVENT_CONTEXT setParticipationsList(List<PARTICIPATION> theParticipations) { 
      this.participationsList = theParticipations;
      return this;
    }

    public boolean hasParticipations() { 
      if (this.participationsList == null)
        return false;
      for (PARTICIPATION item : this.participationsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PARTICIPATION addParticipations() { //3a
      PARTICIPATION t = new PARTICIPATION();
      if (this.participationsList == null)
        this.participationsList = new ArrayList<PARTICIPATION>();
      this.participationsList.add(t);
      return t;
    }

    public EVENT_CONTEXT addParticipations(PARTICIPATION t) { //3b
      if (t == null)
        return this;
      if (this.participationsList == null)
        this.participationsList = new ArrayList<PARTICIPATION>();
      this.participationsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participations}, creating it if it does not already exist {3}
     */
    public PARTICIPATION getParticipationsFirstRep() { 
      if (getParticipationsList().isEmpty()) {
        addParticipations();
      }
      return getParticipationsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("start_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient.", 0, 1, start_time));
        children.add(new Property("end_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Optional end time of the clinical session.", 0, 1, end_time));
        children.add(new Property("location", "string", "The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.", 0, 1, location));
        children.add(new Property("setting", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.", 0, 1, setting));
        children.add(new Property("other_context", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Other optional context which will be archetyped.", 0, 1, other_context));
        children.add(new Property("health_care_facility", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability.", 0, 1, health_care_facility));
        children.add(new Property("participations", "http://openehr.org/fhir/StructureDefinition/PARTICIPATION", "Parties involved in the healthcare event. These would normally include the physician(s) and often the patient (but not the latter if the clinical session is a pathology test for example).", 0, java.lang.Integer.MAX_VALUE, participationsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1573145462: /*start_time*/  return new Property("start_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Start time of the clinical session or other kind of event during which a provider performs a service of any kind for the patient.", 0, 1, start_time);
        case 1725551537: /*end_time*/  return new Property("end_time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Optional end time of the clinical session.", 0, 1, end_time);
        case 1901043637: /*location*/  return new Property("location", "string", "The actual location where the session occurred, e.g. 'microbiology lab 2', 'home', 'ward A3' and so on.", 0, 1, location);
        case 1985941072: /*setting*/  return new Property("setting", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.", 0, 1, setting);
        case -1863234688: /*other_context*/  return new Property("other_context", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Other optional context which will be archetyped.", 0, 1, other_context);
        case 1115786094: /*health_care_facility*/  return new Property("health_care_facility", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "The health care facility under whose care the event took place. This is the most specific workgroup or delivery unit within a care delivery enterprise that has an official identifier in the health system, and can be used to ensure medico-legal accountability.", 0, 1, health_care_facility);
        case 170924882: /*participations*/  return new Property("participations", "http://openehr.org/fhir/StructureDefinition/PARTICIPATION", "Parties involved in the healthcare event. These would normally include the physician(s) and often the patient (but not the latter if the clinical session is a pathology test for example).", 0, java.lang.Integer.MAX_VALUE, participationsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1573145462: /*start_time*/ return this.start_time == null ? new Base[0] : new Base[] {this.start_time}; // DV_DATE_TIME
        case 1725551537: /*end_time*/ return this.end_time == null ? new Base[0] : new Base[] {this.end_time}; // DV_DATE_TIME
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // StringType
        case 1985941072: /*setting*/ return this.setting == null ? new Base[0] : new Base[] {this.setting}; // DV_CODED_TEXT
        case -1863234688: /*other_context*/ return this.other_context == null ? new Base[0] : new Base[] {this.other_context}; // ITEM_STRUCTURE
        case 1115786094: /*health_care_facility*/ return this.health_care_facility == null ? new Base[0] : new Base[] {this.health_care_facility}; // PARTY_IDENTIFIED
        case 170924882: /*participations*/ return this.participationsList == null ? new Base[0] : this.participationsList.toArray(new Base[this.participationsList.size()]); // PARTICIPATION
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1573145462: // start_time
          this.start_time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case 1725551537: // end_time
          this.end_time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToString(value); // StringType
          return value;
        case 1985941072: // setting
          this.setting = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -1863234688: // other_context
          this.other_context = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case 1115786094: // health_care_facility
          this.health_care_facility = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
          return value;
        case 170924882: // participations
          this.getParticipationsList().add((PARTICIPATION) value); // PARTICIPATION
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("start_time")) {
          this.start_time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("end_time")) {
          this.end_time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("setting")) {
          this.setting = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("other_context")) {
          this.other_context = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("health_care_facility")) {
          this.health_care_facility = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
        } else if (name.equals("participations")) {
          this.getParticipationsList().add((PARTICIPATION) value); // PARTICIPATION
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1573145462:  return getStart_time();
        case 1725551537:  return getEnd_time();
        case 1901043637:  return getLocationElement();
        case 1985941072:  return getSetting();
        case -1863234688: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'other_context'");
        case 1115786094:  return getHealth_care_facility();
        case 170924882:  return addParticipations(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1573145462: /*start_time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case 1725551537: /*end_time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case 1901043637: /*location*/ return new String[] {"string"};
        case 1985941072: /*setting*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -1863234688: /*other_context*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case 1115786094: /*health_care_facility*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED"};
        case 170924882: /*participations*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTICIPATION"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("start_time")) {
          this.start_time = new DV_DATE_TIME();
          return this.start_time;
        }
        else if (name.equals("end_time")) {
          this.end_time = new DV_DATE_TIME();
          return this.end_time;
        }
        else if (name.equals("location")) {
          throw new FHIRException("Cannot call addChild on a singleton property EVENT_CONTEXT.location");
        }
        else if (name.equals("setting")) {
          this.setting = new DV_CODED_TEXT();
          return this.setting;
        }
        else if (name.equals("other_context")) {
          throw new FHIRException("Cannot call addChild on an abstract type EVENT_CONTEXT.other_context");
        }
        else if (name.equals("health_care_facility")) {
          this.health_care_facility = new PARTY_IDENTIFIED();
          return this.health_care_facility;
        }
        else if (name.equals("participations")) {
          return addParticipations();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EVENT_CONTEXT";

  }

      public EVENT_CONTEXT copy() {
        EVENT_CONTEXT dst = new EVENT_CONTEXT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EVENT_CONTEXT dst) {
        super.copyValues(dst);
        dst.start_time = start_time == null ? null : start_time.copy();
        dst.end_time = end_time == null ? null : end_time.copy();
        dst.location = location == null ? null : location.copy();
        dst.setting = setting == null ? null : setting.copy();
        dst.other_context = other_context == null ? null : other_context.copy();
        dst.health_care_facility = health_care_facility == null ? null : health_care_facility.copy();
        if (participationsList != null) {
          dst.participationsList = new ArrayList<PARTICIPATION>();
          for (PARTICIPATION i : participationsList)
            dst.participationsList.add(i.copy());
        };
      }

      protected EVENT_CONTEXT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EVENT_CONTEXT))
          return false;
        EVENT_CONTEXT o = (EVENT_CONTEXT) other_;
        return compareDeep(start_time, o.start_time, true) && compareDeep(end_time, o.end_time, true) && compareDeep(location, o.location, true)
           && compareDeep(setting, o.setting, true) && compareDeep(other_context, o.other_context, true) && compareDeep(health_care_facility, o.health_care_facility, true)
           && compareDeep(participationsList, o.participationsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EVENT_CONTEXT))
          return false;
        EVENT_CONTEXT o = (EVENT_CONTEXT) other_;
        return compareValues(location, o.location, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(start_time, end_time, location
          , setting, other_context, health_care_facility, participationsList);
      }


}

