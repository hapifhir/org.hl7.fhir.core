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
 * The set of attributes required to document the committal of an information item to a repository.
 */
@DatatypeDef(name="AUDIT_DETAILS")
public class AUDIT_DETAILS extends LogicalBase implements ICompositeType {

    /**
     * Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.
     */
    @Child(name = "system_id", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of the logical EHR system where the change was committed", formalDefinition="Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure." )
    protected StringType system_id;

    /**
     * Time of committal of the item.
     */
    @Child(name = "time_committed", type = {DV_DATE_TIME.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time of committal of the item", formalDefinition="Time of committal of the item." )
    protected DV_DATE_TIME time_committed;

    /**
     * Type of change. Coded using the openEHR Terminology audit change type group.
     */
    @Child(name = "change_type", type = {DV_CODED_TEXT.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Type of change", formalDefinition="Type of change. Coded using the openEHR Terminology audit change type group." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-audit_change_type")
    protected DV_CODED_TEXT change_type;

    /**
     * Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar.
     */
    @Child(name = "description", type = {DV_TEXT.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason for committal. This may be used to qualify the value in the change_type field", formalDefinition="Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar." )
    protected DV_TEXT description;

    /**
     * Identity and optional reference into identity management service, of user who committed the item.
     */
    @Child(name = "committer", type = {PARTY_PROXY.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identity and optional reference into identity management service, of user who committed the item", formalDefinition="Identity and optional reference into identity management service, of user who committed the item." )
    protected PARTY_PROXY committer;

    private static final long serialVersionUID = -1398858817L;

  /**
   * Constructor
   */
    public AUDIT_DETAILS() {
      super();
    }

  /**
   * Constructor
   */
    public AUDIT_DETAILS(String system_id, DV_DATE_TIME time_committed, DV_CODED_TEXT change_type, PARTY_PROXY committer) {
      super();
      this.setSystem_id(system_id);
      this.setTime_committed(time_committed);
      this.setChange_type(change_type);
      this.setCommitter(committer);
    }

    /**
     * @return {@link #system_id} (Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.). This is the underlying object with id, value and extensions. The accessor "getSystem_id" gives direct access to the value
     */
    public StringType getSystem_idElement() { 
      if (this.system_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUDIT_DETAILS.system_id");
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
     * @param value {@link #system_id} (Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.). This is the underlying object with id, value and extensions. The accessor "getSystem_id" gives direct access to the value
     */
    public AUDIT_DETAILS setSystem_idElement(StringType value) { 
      this.system_id = value;
      return this;
    }

    /**
     * @return Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.
     */
    public String getSystem_id() { 
      return this.system_id == null ? null : this.system_id.getValue();
    }

    /**
     * @param value Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.
     */
    public AUDIT_DETAILS setSystem_id(String value) { 
        if (this.system_id == null)
          this.system_id = new StringType();
        this.system_id.setValue(value);
      return this;
    }

    /**
     * @return {@link #time_committed} (Time of committal of the item.)
     */
    public DV_DATE_TIME getTime_committed() { 
      if (this.time_committed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUDIT_DETAILS.time_committed");
        else if (Configuration.doAutoCreate())
          this.time_committed = new DV_DATE_TIME(); // cc
      return this.time_committed;
    }

    public boolean hasTime_committed() { 
      return this.time_committed != null && !this.time_committed.isEmpty();
    }

    /**
     * @param value {@link #time_committed} (Time of committal of the item.)
     */
    public AUDIT_DETAILS setTime_committed(DV_DATE_TIME value) { 
      this.time_committed = value;
      return this;
    }

    /**
     * @return {@link #change_type} (Type of change. Coded using the openEHR Terminology audit change type group.)
     */
    public DV_CODED_TEXT getChange_type() { 
      if (this.change_type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUDIT_DETAILS.change_type");
        else if (Configuration.doAutoCreate())
          this.change_type = new DV_CODED_TEXT(); // cc
      return this.change_type;
    }

    public boolean hasChange_type() { 
      return this.change_type != null && !this.change_type.isEmpty();
    }

    /**
     * @param value {@link #change_type} (Type of change. Coded using the openEHR Terminology audit change type group.)
     */
    public AUDIT_DETAILS setChange_type(DV_CODED_TEXT value) { 
      this.change_type = value;
      return this;
    }

    /**
     * @return {@link #description} (Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar.)
     */
    public DV_TEXT getDescription() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUDIT_DETAILS.description");
        else if (Configuration.doAutoCreate())
          this.description = new DV_TEXT(); // cc
      return this.description;
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar.)
     */
    public AUDIT_DETAILS setDescription(DV_TEXT value) { 
      this.description = value;
      return this;
    }

    /**
     * @return {@link #committer} (Identity and optional reference into identity management service, of user who committed the item.)
     */
    public PARTY_PROXY getCommitter() { 
      return this.committer;
    }

    public boolean hasCommitter() { 
      return this.committer != null && !this.committer.isEmpty();
    }

    /**
     * @param value {@link #committer} (Identity and optional reference into identity management service, of user who committed the item.)
     */
    public AUDIT_DETAILS setCommitter(PARTY_PROXY value) { 
      this.committer = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("system_id", "string", "Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.", 0, 1, system_id));
        children.add(new Property("time_committed", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of committal of the item.", 0, 1, time_committed));
        children.add(new Property("change_type", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Type of change. Coded using the openEHR Terminology audit change type group.", 0, 1, change_type));
        children.add(new Property("description", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar.", 0, 1, description));
        children.add(new Property("committer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Identity and optional reference into identity management service, of user who committed the item.", 0, 1, committer));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1129127211: /*system_id*/  return new Property("system_id", "string", "Identifier of the logical EHR system where the change was committed. This is almost always owned by the organisation legally responsible for the EHR, and is distinct from any application, or any hosting infrastructure.", 0, 1, system_id);
        case 2138761354: /*time_committed*/  return new Property("time_committed", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of committal of the item.", 0, 1, time_committed);
        case -1654455703: /*change_type*/  return new Property("change_type", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Type of change. Coded using the openEHR Terminology audit change type group.", 0, 1, change_type);
        case -1724546052: /*description*/  return new Property("description", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Reason for committal. This may be used to qualify the value in the change_type field. For example, if the change affects only the EHR directory, this field might be used to indicate 'Folder `episode 2018-02-16` added' or similar.", 0, 1, description);
        case -1491142774: /*committer*/  return new Property("committer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Identity and optional reference into identity management service, of user who committed the item.", 0, 1, committer);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return this.system_id == null ? new Base[0] : new Base[] {this.system_id}; // StringType
        case 2138761354: /*time_committed*/ return this.time_committed == null ? new Base[0] : new Base[] {this.time_committed}; // DV_DATE_TIME
        case -1654455703: /*change_type*/ return this.change_type == null ? new Base[0] : new Base[] {this.change_type}; // DV_CODED_TEXT
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // DV_TEXT
        case -1491142774: /*committer*/ return this.committer == null ? new Base[0] : new Base[] {this.committer}; // PARTY_PROXY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1129127211: // system_id
          this.system_id = TypeConvertor.castToString(value); // StringType
          return value;
        case 2138761354: // time_committed
          this.time_committed = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -1654455703: // change_type
          this.change_type = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -1724546052: // description
          this.description = (DV_TEXT) value; // DV_TEXT
          return value;
        case -1491142774: // committer
          this.committer = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("system_id")) {
          this.system_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("time_committed")) {
          this.time_committed = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("change_type")) {
          this.change_type = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("description")) {
          this.description = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("committer")) {
          this.committer = (PARTY_PROXY) value; // PARTY_PROXY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211:  return getSystem_idElement();
        case 2138761354:  return getTime_committed();
        case -1654455703:  return getChange_type();
        case -1724546052:  return getDescription();
        case -1491142774: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'committer'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return new String[] {"string"};
        case 2138761354: /*time_committed*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -1654455703: /*change_type*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -1724546052: /*description*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case -1491142774: /*committer*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("system_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property AUDIT_DETAILS.system_id");
        }
        else if (name.equals("time_committed")) {
          this.time_committed = new DV_DATE_TIME();
          return this.time_committed;
        }
        else if (name.equals("change_type")) {
          this.change_type = new DV_CODED_TEXT();
          return this.change_type;
        }
        else if (name.equals("description")) {
          this.description = new DV_TEXT();
          return this.description;
        }
        else if (name.equals("committer")) {
          throw new FHIRException("Cannot call addChild on an abstract type AUDIT_DETAILS.committer");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AUDIT_DETAILS";

  }

      public AUDIT_DETAILS copy() {
        AUDIT_DETAILS dst = new AUDIT_DETAILS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AUDIT_DETAILS dst) {
        super.copyValues(dst);
        dst.system_id = system_id == null ? null : system_id.copy();
        dst.time_committed = time_committed == null ? null : time_committed.copy();
        dst.change_type = change_type == null ? null : change_type.copy();
        dst.description = description == null ? null : description.copy();
        dst.committer = committer == null ? null : committer.copy();
      }

      protected AUDIT_DETAILS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AUDIT_DETAILS))
          return false;
        AUDIT_DETAILS o = (AUDIT_DETAILS) other_;
        return compareDeep(system_id, o.system_id, true) && compareDeep(time_committed, o.time_committed, true)
           && compareDeep(change_type, o.change_type, true) && compareDeep(description, o.description, true)
           && compareDeep(committer, o.committer, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AUDIT_DETAILS))
          return false;
        AUDIT_DETAILS o = (AUDIT_DETAILS) other_;
        return compareValues(system_id, o.system_id, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(system_id, time_committed
          , change_type, description, committer);
      }


}

