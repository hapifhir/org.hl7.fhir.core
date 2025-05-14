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
 * Version control abstraction, defining semantics for versioning one complex object.
 */
@DatatypeDef(name="VERSIONED_OBJECT")
public class VERSIONED_OBJECT extends LogicalBase implements ICompositeType {

    /**
     * Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree.
     */
    @Child(name = "uid", type = {HIER_OBJECT_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Unique identifier of this version container in the form of a UID with no extension", formalDefinition="Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree." )
    protected HIER_OBJECT_ID uid;

    /**
     * Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity.
     */
    @Child(name = "owner_id", type = {OBJECT_REF.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity", formalDefinition="Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity." )
    protected OBJECT_REF owner_id;

    /**
     * Time of initial creation of this versioned object.
     */
    @Child(name = "time_created", type = {DV_DATE_TIME.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time of initial creation of this versioned object", formalDefinition="Time of initial creation of this versioned object." )
    protected DV_DATE_TIME time_created;

    private static final long serialVersionUID = 615162631L;

  /**
   * Constructor
   */
    public VERSIONED_OBJECT() {
      super();
    }

  /**
   * Constructor
   */
    public VERSIONED_OBJECT(HIER_OBJECT_ID uid, OBJECT_REF owner_id, DV_DATE_TIME time_created) {
      super();
      this.setUid(uid);
      this.setOwner_id(owner_id);
      this.setTime_created(time_created);
    }

    /**
     * @return {@link #uid} (Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree.)
     */
    public HIER_OBJECT_ID getUid() { 
      if (this.uid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSIONED_OBJECT.uid");
        else if (Configuration.doAutoCreate())
          this.uid = new HIER_OBJECT_ID(); // cc
      return this.uid;
    }

    public boolean hasUid() { 
      return this.uid != null && !this.uid.isEmpty();
    }

    /**
     * @param value {@link #uid} (Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree.)
     */
    public VERSIONED_OBJECT setUid(HIER_OBJECT_ID value) { 
      this.uid = value;
      return this;
    }

    /**
     * @return {@link #owner_id} (Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity.)
     */
    public OBJECT_REF getOwner_id() { 
      if (this.owner_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSIONED_OBJECT.owner_id");
        else if (Configuration.doAutoCreate())
          this.owner_id = new OBJECT_REF(); // cc
      return this.owner_id;
    }

    public boolean hasOwner_id() { 
      return this.owner_id != null && !this.owner_id.isEmpty();
    }

    /**
     * @param value {@link #owner_id} (Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity.)
     */
    public VERSIONED_OBJECT setOwner_id(OBJECT_REF value) { 
      this.owner_id = value;
      return this;
    }

    /**
     * @return {@link #time_created} (Time of initial creation of this versioned object.)
     */
    public DV_DATE_TIME getTime_created() { 
      if (this.time_created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSIONED_OBJECT.time_created");
        else if (Configuration.doAutoCreate())
          this.time_created = new DV_DATE_TIME(); // cc
      return this.time_created;
    }

    public boolean hasTime_created() { 
      return this.time_created != null && !this.time_created.isEmpty();
    }

    /**
     * @param value {@link #time_created} (Time of initial creation of this versioned object.)
     */
    public VERSIONED_OBJECT setTime_created(DV_DATE_TIME value) { 
      this.time_created = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("uid", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree.", 0, 1, uid));
        children.add(new Property("owner_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity.", 0, 1, owner_id));
        children.add(new Property("time_created", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of initial creation of this versioned object.", 0, 1, time_created));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 115792: /*uid*/  return new Property("uid", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "Unique identifier of this version container in the form of a UID with no extension. This id will be the same in all instances of the same container in a distributed environment, meaning that it can be understood as the uid of the virtual version tree.", 0, 1, uid);
        case 1663147559: /*owner_id*/  return new Property("owner_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to object to which this version container belongs, e.g. the id of the containing EHR or other relevant owning entity.", 0, 1, owner_id);
        case -630236298: /*time_created*/  return new Property("time_created", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of initial creation of this versioned object.", 0, 1, time_created);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // HIER_OBJECT_ID
        case 1663147559: /*owner_id*/ return this.owner_id == null ? new Base[0] : new Base[] {this.owner_id}; // OBJECT_REF
        case -630236298: /*time_created*/ return this.time_created == null ? new Base[0] : new Base[] {this.time_created}; // DV_DATE_TIME
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
          return value;
        case 1663147559: // owner_id
          this.owner_id = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case -630236298: // time_created
          this.time_created = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
        } else if (name.equals("owner_id")) {
          this.owner_id = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("time_created")) {
          this.time_created = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUid();
        case 1663147559:  return getOwner_id();
        case -630236298:  return getTime_created();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID"};
        case 1663147559: /*owner_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -630236298: /*time_created*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = new HIER_OBJECT_ID();
          return this.uid;
        }
        else if (name.equals("owner_id")) {
          this.owner_id = new OBJECT_REF();
          return this.owner_id;
        }
        else if (name.equals("time_created")) {
          this.time_created = new DV_DATE_TIME();
          return this.time_created;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "VERSIONED_OBJECT";

  }

      public VERSIONED_OBJECT copy() {
        VERSIONED_OBJECT dst = new VERSIONED_OBJECT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(VERSIONED_OBJECT dst) {
        super.copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.owner_id = owner_id == null ? null : owner_id.copy();
        dst.time_created = time_created == null ? null : time_created.copy();
      }

      protected VERSIONED_OBJECT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof VERSIONED_OBJECT))
          return false;
        VERSIONED_OBJECT o = (VERSIONED_OBJECT) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(owner_id, o.owner_id, true) && compareDeep(time_created, o.time_created, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof VERSIONED_OBJECT))
          return false;
        VERSIONED_OBJECT o = (VERSIONED_OBJECT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, owner_id, time_created
          );
      }


}

