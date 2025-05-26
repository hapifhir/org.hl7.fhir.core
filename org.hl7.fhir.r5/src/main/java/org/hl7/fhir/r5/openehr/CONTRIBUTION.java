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
 * Documents a Contribution (change set) of one or more versions added to a change-controlled repository.
 */
@DatatypeDef(name="CONTRIBUTION")
public class CONTRIBUTION extends LogicalBase implements ICompositeType {

    /**
     * Unique identifier for this Contribution.
     */
    @Child(name = "uid", type = {HIER_OBJECT_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Unique identifier for this Contribution", formalDefinition="Unique identifier for this Contribution." )
    protected HIER_OBJECT_ID uid;

    /**
     * Set of references to Versions causing changes to this EHR. Each contribution contains a list of versions, which may include paths pointing to any number of versionable items, i.e. items of types such as COMPOSITION and FOLDER.
     */
    @Child(name = "versions", type = {OBJECT_REF.class}, order=1, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Set of references to Versions causing changes to this EHR", formalDefinition="Set of references to Versions causing changes to this EHR. Each contribution contains a list of versions, which may include paths pointing to any number of versionable items, i.e. items of types such as COMPOSITION and FOLDER." )
    protected List<OBJECT_REF> versionsList;

    /**
     * Audit trail corresponding to the committal of this Contribution.
     */
    @Child(name = "audit", type = {AUDIT_DETAILS.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Audit trail corresponding to the committal of this Contribution", formalDefinition="Audit trail corresponding to the committal of this Contribution." )
    protected AUDIT_DETAILS audit;

    private static final long serialVersionUID = 2043766363L;

  /**
   * Constructor
   */
    public CONTRIBUTION() {
      super();
    }

  /**
   * Constructor
   */
    public CONTRIBUTION(HIER_OBJECT_ID uid, OBJECT_REF versions, AUDIT_DETAILS audit) {
      super();
      this.setUid(uid);
      this.addVersions(versions);
      this.setAudit(audit);
    }

    /**
     * @return {@link #uid} (Unique identifier for this Contribution.)
     */
    public HIER_OBJECT_ID getUid() { 
      if (this.uid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CONTRIBUTION.uid");
        else if (Configuration.doAutoCreate())
          this.uid = new HIER_OBJECT_ID(); // cc
      return this.uid;
    }

    public boolean hasUid() { 
      return this.uid != null && !this.uid.isEmpty();
    }

    /**
     * @param value {@link #uid} (Unique identifier for this Contribution.)
     */
    public CONTRIBUTION setUid(HIER_OBJECT_ID value) { 
      this.uid = value;
      return this;
    }

    /**
     * @return {@link #versions} (Set of references to Versions causing changes to this EHR. Each contribution contains a list of versions, which may include paths pointing to any number of versionable items, i.e. items of types such as COMPOSITION and FOLDER.)
     */
    public List<OBJECT_REF> getVersionsList() { 
      if (this.versionsList == null)
        this.versionsList = new ArrayList<OBJECT_REF>();
      return this.versionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CONTRIBUTION setVersionsList(List<OBJECT_REF> theVersions) { 
      this.versionsList = theVersions;
      return this;
    }

    public boolean hasVersions() { 
      if (this.versionsList == null)
        return false;
      for (OBJECT_REF item : this.versionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addVersions() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.versionsList == null)
        this.versionsList = new ArrayList<OBJECT_REF>();
      this.versionsList.add(t);
      return t;
    }

    public CONTRIBUTION addVersions(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.versionsList == null)
        this.versionsList = new ArrayList<OBJECT_REF>();
      this.versionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #versions}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getVersionsFirstRep() { 
      if (getVersionsList().isEmpty()) {
        addVersions();
      }
      return getVersionsList().get(0);
    }

    /**
     * @return {@link #audit} (Audit trail corresponding to the committal of this Contribution.)
     */
    public AUDIT_DETAILS getAudit() { 
      if (this.audit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CONTRIBUTION.audit");
        else if (Configuration.doAutoCreate())
          this.audit = new AUDIT_DETAILS(); // cc
      return this.audit;
    }

    public boolean hasAudit() { 
      return this.audit != null && !this.audit.isEmpty();
    }

    /**
     * @param value {@link #audit} (Audit trail corresponding to the committal of this Contribution.)
     */
    public CONTRIBUTION setAudit(AUDIT_DETAILS value) { 
      this.audit = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("uid", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "Unique identifier for this Contribution.", 0, 1, uid));
        children.add(new Property("versions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Set of references to Versions causing changes to this EHR. Each contribution contains a list of versions, which may include paths pointing to any number of versionable items, i.e. items of types such as COMPOSITION and FOLDER.", 0, java.lang.Integer.MAX_VALUE, versionsList));
        children.add(new Property("audit", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "Audit trail corresponding to the committal of this Contribution.", 0, 1, audit));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 115792: /*uid*/  return new Property("uid", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "Unique identifier for this Contribution.", 0, 1, uid);
        case -1985053029: /*versions*/  return new Property("versions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Set of references to Versions causing changes to this EHR. Each contribution contains a list of versions, which may include paths pointing to any number of versionable items, i.e. items of types such as COMPOSITION and FOLDER.", 0, java.lang.Integer.MAX_VALUE, versionsList);
        case 93166555: /*audit*/  return new Property("audit", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "Audit trail corresponding to the committal of this Contribution.", 0, 1, audit);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // HIER_OBJECT_ID
        case -1985053029: /*versions*/ return this.versionsList == null ? new Base[0] : this.versionsList.toArray(new Base[this.versionsList.size()]); // OBJECT_REF
        case 93166555: /*audit*/ return this.audit == null ? new Base[0] : new Base[] {this.audit}; // AUDIT_DETAILS
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
          return value;
        case -1985053029: // versions
          this.getVersionsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case 93166555: // audit
          this.audit = (AUDIT_DETAILS) value; // AUDIT_DETAILS
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
        } else if (name.equals("versions")) {
          this.getVersionsList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("audit")) {
          this.audit = (AUDIT_DETAILS) value; // AUDIT_DETAILS
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUid();
        case -1985053029:  return addVersions(); 
        case 93166555:  return getAudit();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID"};
        case -1985053029: /*versions*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case 93166555: /*audit*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = new HIER_OBJECT_ID();
          return this.uid;
        }
        else if (name.equals("versions")) {
          return addVersions();
        }
        else if (name.equals("audit")) {
          this.audit = new AUDIT_DETAILS();
          return this.audit;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CONTRIBUTION";

  }

      public CONTRIBUTION copy() {
        CONTRIBUTION dst = new CONTRIBUTION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CONTRIBUTION dst) {
        super.copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        if (versionsList != null) {
          dst.versionsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : versionsList)
            dst.versionsList.add(i.copy());
        };
        dst.audit = audit == null ? null : audit.copy();
      }

      protected CONTRIBUTION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CONTRIBUTION))
          return false;
        CONTRIBUTION o = (CONTRIBUTION) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(versionsList, o.versionsList, true) && compareDeep(audit, o.audit, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CONTRIBUTION))
          return false;
        CONTRIBUTION o = (CONTRIBUTION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, versionsList, audit
          );
      }


}

