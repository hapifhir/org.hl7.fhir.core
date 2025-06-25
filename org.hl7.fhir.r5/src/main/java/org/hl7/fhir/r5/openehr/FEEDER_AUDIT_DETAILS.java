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
 * Audit details for any system in a feeder system chain. Audit details here means the general notion of who/where/when the information item to which the audit is attached was created. None of the attributes is defined as mandatory, however, in different scenarios, various combinations of attributes will usually be mandatory. This can be controlled by specifying feeder audit details in legacy archetypes.
 */
@DatatypeDef(name="FEEDER_AUDIT_DETAILS")
public class FEEDER_AUDIT_DETAILS extends LogicalBase implements ICompositeType {

    /**
     * Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.
     */
    @Child(name = "system_id", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of the system which handled the information item", formalDefinition="Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system." )
    protected StringType system_id;

    /**
     * Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.
     */
    @Child(name = "location", type = {PARTY_IDENTIFIED.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of the particular site/facility within an organisation which handled the item", formalDefinition="Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object." )
    protected PARTY_IDENTIFIED location;

    /**
     * Identifiers for subject of the received information item.
     */
    @Child(name = "subject", type = {PARTY_PROXY.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers for subject of the received information item", formalDefinition="Identifiers for subject of the received information item." )
    protected PARTY_PROXY subject;

    /**
     * Optional provider(s) who created, committed, forwarded or otherwise handled the item.
     */
    @Child(name = "provider", type = {PARTY_IDENTIFIED.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional provider(s) who created, committed, forwarded or otherwise handled the item", formalDefinition="Optional provider(s) who created, committed, forwarded or otherwise handled the item." )
    protected PARTY_IDENTIFIED provider;

    /**
     * Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available.
     */
    @Child(name = "time", type = {DV_DATE_TIME.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time of handling the item", formalDefinition="Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available." )
    protected DV_DATE_TIME time;

    /**
     * Any identifier used in the system such as `interim` , `final` , or numeric versions if available.
     */
    @Child(name = "version_id", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Any identifier used in the system such as `interim` , `final` , or numeric versions if available", formalDefinition="Any identifier used in the system such as `interim` , `final` , or numeric versions if available." )
    protected StringType version_id;

    /**
     * Optional attribute to carry any custom meta-data. May be archetyped.
     */
    @Child(name = "other_details", type = {ITEM_STRUCTURE.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional attribute to carry any custom meta-data", formalDefinition="Optional attribute to carry any custom meta-data. May be archetyped." )
    protected ITEM_STRUCTURE other_details;

    private static final long serialVersionUID = -31539140L;

  /**
   * Constructor
   */
    public FEEDER_AUDIT_DETAILS() {
      super();
    }

  /**
   * Constructor
   */
    public FEEDER_AUDIT_DETAILS(String system_id) {
      super();
      this.setSystem_id(system_id);
    }

    /**
     * @return {@link #system_id} (Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.). This is the underlying object with id, value and extensions. The accessor "getSystem_id" gives direct access to the value
     */
    public StringType getSystem_idElement() { 
      if (this.system_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT_DETAILS.system_id");
        else if (Configuration.doAutoCreate())
          this.system_id = new StringType(); // bb
      return this.system_id;
    }

    public boolean hasSystem_idElement() { 
      return this.system_id != null && !this.system_id.isEmpty();
    }

    public boolean hasSystem_id() { 
      return this.system_id != null && !this.system_id.isEmpty();
    }

    /**
     * @param value {@link #system_id} (Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.). This is the underlying object with id, value and extensions. The accessor "getSystem_id" gives direct access to the value
     */
    public FEEDER_AUDIT_DETAILS setSystem_idElement(StringType value) { 
      this.system_id = value;
      return this;
    }

    /**
     * @return Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.
     */
    public String getSystem_id() { 
      return this.system_id == null ? null : this.system_id.getValue();
    }

    /**
     * @param value Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.
     */
    public FEEDER_AUDIT_DETAILS setSystem_id(String value) { 
        if (this.system_id == null)
          this.system_id = new StringType();
        this.system_id.setValue(value);
      return this;
    }

    /**
     * @return {@link #location} (Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.)
     */
    public PARTY_IDENTIFIED getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT_DETAILS.location");
        else if (Configuration.doAutoCreate())
          this.location = new PARTY_IDENTIFIED(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.)
     */
    public FEEDER_AUDIT_DETAILS setLocation(PARTY_IDENTIFIED value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #subject} (Identifiers for subject of the received information item.)
     */
    public PARTY_PROXY getSubject() { 
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Identifiers for subject of the received information item.)
     */
    public FEEDER_AUDIT_DETAILS setSubject(PARTY_PROXY value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #provider} (Optional provider(s) who created, committed, forwarded or otherwise handled the item.)
     */
    public PARTY_IDENTIFIED getProvider() { 
      if (this.provider == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT_DETAILS.provider");
        else if (Configuration.doAutoCreate())
          this.provider = new PARTY_IDENTIFIED(); // cc
      return this.provider;
    }

    public boolean hasProvider() { 
      return this.provider != null && !this.provider.isEmpty();
    }

    /**
     * @param value {@link #provider} (Optional provider(s) who created, committed, forwarded or otherwise handled the item.)
     */
    public FEEDER_AUDIT_DETAILS setProvider(PARTY_IDENTIFIED value) { 
      this.provider = value;
      return this;
    }

    /**
     * @return {@link #time} (Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available.)
     */
    public DV_DATE_TIME getTime() { 
      if (this.time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT_DETAILS.time");
        else if (Configuration.doAutoCreate())
          this.time = new DV_DATE_TIME(); // cc
      return this.time;
    }

    public boolean hasTime() { 
      return this.time != null && !this.time.isEmpty();
    }

    /**
     * @param value {@link #time} (Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available.)
     */
    public FEEDER_AUDIT_DETAILS setTime(DV_DATE_TIME value) { 
      this.time = value;
      return this;
    }

    /**
     * @return {@link #version_id} (Any identifier used in the system such as `interim` , `final` , or numeric versions if available.). This is the underlying object with id, value and extensions. The accessor "getVersion_id" gives direct access to the value
     */
    public StringType getVersion_idElement() { 
      if (this.version_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT_DETAILS.version_id");
        else if (Configuration.doAutoCreate())
          this.version_id = new StringType(); // bb
      return this.version_id;
    }

    public boolean hasVersion_idElement() { 
      return this.version_id != null && !this.version_id.isEmpty();
    }

    public boolean hasVersion_id() { 
      return this.version_id != null && !this.version_id.isEmpty();
    }

    /**
     * @param value {@link #version_id} (Any identifier used in the system such as `interim` , `final` , or numeric versions if available.). This is the underlying object with id, value and extensions. The accessor "getVersion_id" gives direct access to the value
     */
    public FEEDER_AUDIT_DETAILS setVersion_idElement(StringType value) { 
      this.version_id = value;
      return this;
    }

    /**
     * @return Any identifier used in the system such as `interim` , `final` , or numeric versions if available.
     */
    public String getVersion_id() { 
      return this.version_id == null ? null : this.version_id.getValue();
    }

    /**
     * @param value Any identifier used in the system such as `interim` , `final` , or numeric versions if available.
     */
    public FEEDER_AUDIT_DETAILS setVersion_id(String value) { 
      if (Utilities.noString(value))
        this.version_id = null;
      else {
        if (this.version_id == null)
          this.version_id = new StringType();
        this.version_id.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #other_details} (Optional attribute to carry any custom meta-data. May be archetyped.)
     */
    public ITEM_STRUCTURE getOther_details() { 
      return this.other_details;
    }

    public boolean hasOther_details() { 
      return this.other_details != null && !this.other_details.isEmpty();
    }

    /**
     * @param value {@link #other_details} (Optional attribute to carry any custom meta-data. May be archetyped.)
     */
    public FEEDER_AUDIT_DETAILS setOther_details(ITEM_STRUCTURE value) { 
      this.other_details = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("system_id", "string", "Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.", 0, 1, system_id));
        children.add(new Property("location", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.", 0, 1, location));
        children.add(new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Identifiers for subject of the received information item.", 0, 1, subject));
        children.add(new Property("provider", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "Optional provider(s) who created, committed, forwarded or otherwise handled the item.", 0, 1, provider));
        children.add(new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available.", 0, 1, time));
        children.add(new Property("version_id", "string", "Any identifier used in the system such as `interim` , `final` , or numeric versions if available.", 0, 1, version_id));
        children.add(new Property("other_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional attribute to carry any custom meta-data. May be archetyped.", 0, 1, other_details));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1129127211: /*system_id*/  return new Property("system_id", "string", "Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data, and at which the data were previously created or passed by an earlier system.", 0, 1, system_id);
        case 1901043637: /*location*/  return new Property("location", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "Identifier of the particular site/facility within an organisation which handled the item. For computability, this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.", 0, 1, location);
        case -1867885268: /*subject*/  return new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Identifiers for subject of the received information item.", 0, 1, subject);
        case -987494927: /*provider*/  return new Property("provider", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED", "Optional provider(s) who created, committed, forwarded or otherwise handled the item.", 0, 1, provider);
        case 3560141: /*time*/  return new Property("time", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system, this will be a time of accession or other time of handling, where available.", 0, 1, time);
        case -670497310: /*version_id*/  return new Property("version_id", "string", "Any identifier used in the system such as `interim` , `final` , or numeric versions if available.", 0, 1, version_id);
        case -1257043949: /*other_details*/  return new Property("other_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional attribute to carry any custom meta-data. May be archetyped.", 0, 1, other_details);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return this.system_id == null ? new Base[0] : new Base[] {this.system_id}; // StringType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // PARTY_IDENTIFIED
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // PARTY_PROXY
        case -987494927: /*provider*/ return this.provider == null ? new Base[0] : new Base[] {this.provider}; // PARTY_IDENTIFIED
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DV_DATE_TIME
        case -670497310: /*version_id*/ return this.version_id == null ? new Base[0] : new Base[] {this.version_id}; // StringType
        case -1257043949: /*other_details*/ return this.other_details == null ? new Base[0] : new Base[] {this.other_details}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1129127211: // system_id
          this.system_id = TypeConvertor.castToString(value); // StringType
          return value;
        case 1901043637: // location
          this.location = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
          return value;
        case -1867885268: // subject
          this.subject = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        case -987494927: // provider
          this.provider = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
          return value;
        case 3560141: // time
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -670497310: // version_id
          this.version_id = TypeConvertor.castToString(value); // StringType
          return value;
        case -1257043949: // other_details
          this.other_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("system_id")) {
          this.system_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("location")) {
          this.location = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
        } else if (name.equals("subject")) {
          this.subject = (PARTY_PROXY) value; // PARTY_PROXY
        } else if (name.equals("provider")) {
          this.provider = (PARTY_IDENTIFIED) value; // PARTY_IDENTIFIED
        } else if (name.equals("time")) {
          this.time = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("version_id")) {
          this.version_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("other_details")) {
          this.other_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211:  return getSystem_idElement();
        case 1901043637:  return getLocation();
        case -1867885268: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'subject'");
        case -987494927:  return getProvider();
        case 3560141:  return getTime();
        case -670497310:  return getVersion_idElement();
        case -1257043949: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'other_details'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return new String[] {"string"};
        case 1901043637: /*location*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED"};
        case -1867885268: /*subject*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        case -987494927: /*provider*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-IDENTIFIED"};
        case 3560141: /*time*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -670497310: /*version_id*/ return new String[] {"string"};
        case -1257043949: /*other_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("system_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property FEEDER_AUDIT_DETAILS.system_id");
        }
        else if (name.equals("location")) {
          this.location = new PARTY_IDENTIFIED();
          return this.location;
        }
        else if (name.equals("subject")) {
          throw new FHIRException("Cannot call addChild on an abstract type FEEDER_AUDIT_DETAILS.subject");
        }
        else if (name.equals("provider")) {
          this.provider = new PARTY_IDENTIFIED();
          return this.provider;
        }
        else if (name.equals("time")) {
          this.time = new DV_DATE_TIME();
          return this.time;
        }
        else if (name.equals("version_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property FEEDER_AUDIT_DETAILS.version_id");
        }
        else if (name.equals("other_details")) {
          throw new FHIRException("Cannot call addChild on an abstract type FEEDER_AUDIT_DETAILS.other_details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "FEEDER_AUDIT_DETAILS";

  }

      public FEEDER_AUDIT_DETAILS copy() {
        FEEDER_AUDIT_DETAILS dst = new FEEDER_AUDIT_DETAILS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FEEDER_AUDIT_DETAILS dst) {
        super.copyValues(dst);
        dst.system_id = system_id == null ? null : system_id.copy();
        dst.location = location == null ? null : location.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.provider = provider == null ? null : provider.copy();
        dst.time = time == null ? null : time.copy();
        dst.version_id = version_id == null ? null : version_id.copy();
        dst.other_details = other_details == null ? null : other_details.copy();
      }

      protected FEEDER_AUDIT_DETAILS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FEEDER_AUDIT_DETAILS))
          return false;
        FEEDER_AUDIT_DETAILS o = (FEEDER_AUDIT_DETAILS) other_;
        return compareDeep(system_id, o.system_id, true) && compareDeep(location, o.location, true) && compareDeep(subject, o.subject, true)
           && compareDeep(provider, o.provider, true) && compareDeep(time, o.time, true) && compareDeep(version_id, o.version_id, true)
           && compareDeep(other_details, o.other_details, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FEEDER_AUDIT_DETAILS))
          return false;
        FEEDER_AUDIT_DETAILS o = (FEEDER_AUDIT_DETAILS) other_;
        return compareValues(system_id, o.system_id, true) && compareValues(version_id, o.version_id, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(system_id, location, subject
          , provider, time, version_id, other_details);
      }


}

