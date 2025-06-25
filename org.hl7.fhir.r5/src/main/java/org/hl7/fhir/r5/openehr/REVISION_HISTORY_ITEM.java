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
 * An entry in a revision history, corresponding to a version from a versioned container. Consists of AUDIT_DETAILS instances with revision identifier of the revision to which the AUDIT_DETAILS instance belongs.
 */
@DatatypeDef(name="REVISION_HISTORY_ITEM")
public class REVISION_HISTORY_ITEM extends LogicalBase implements ICompositeType {

    /**
     * Version identifier for this revision.
     */
    @Child(name = "version_id", type = {OBJECT_VERSION_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Version identifier for this revision", formalDefinition="Version identifier for this revision." )
    protected OBJECT_VERSION_ID version_id;

    /**
     * The audits for this revision; there will always be at least one commit audit (which may itself be an ATTESTATION), there may also be further attestations.
     */
    @Child(name = "audits", type = {AUDIT_DETAILS.class}, order=1, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The audits for this revision (at least one)", formalDefinition="The audits for this revision; there will always be at least one commit audit (which may itself be an ATTESTATION), there may also be further attestations." )
    protected List<AUDIT_DETAILS> auditsList;

    private static final long serialVersionUID = -444855928L;

  /**
   * Constructor
   */
    public REVISION_HISTORY_ITEM() {
      super();
    }

  /**
   * Constructor
   */
    public REVISION_HISTORY_ITEM(OBJECT_VERSION_ID version_id, AUDIT_DETAILS audits) {
      super();
      this.setVersion_id(version_id);
      this.addAudits(audits);
    }

    /**
     * @return {@link #version_id} (Version identifier for this revision.)
     */
    public OBJECT_VERSION_ID getVersion_id() { 
      if (this.version_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create REVISION_HISTORY_ITEM.version_id");
        else if (Configuration.doAutoCreate())
          this.version_id = new OBJECT_VERSION_ID(); // cc
      return this.version_id;
    }

    public boolean hasVersion_id() { 
      return this.version_id != null && !this.version_id.isEmpty();
    }

    /**
     * @param value {@link #version_id} (Version identifier for this revision.)
     */
    public REVISION_HISTORY_ITEM setVersion_id(OBJECT_VERSION_ID value) { 
      this.version_id = value;
      return this;
    }

    /**
     * @return {@link #audits} (The audits for this revision; there will always be at least one commit audit (which may itself be an ATTESTATION), there may also be further attestations.)
     */
    public List<AUDIT_DETAILS> getAuditsList() { 
      if (this.auditsList == null)
        this.auditsList = new ArrayList<AUDIT_DETAILS>();
      return this.auditsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public REVISION_HISTORY_ITEM setAuditsList(List<AUDIT_DETAILS> theAudits) { 
      this.auditsList = theAudits;
      return this;
    }

    public boolean hasAudits() { 
      if (this.auditsList == null)
        return false;
      for (AUDIT_DETAILS item : this.auditsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AUDIT_DETAILS addAudits() { //3a
      AUDIT_DETAILS t = new AUDIT_DETAILS();
      if (this.auditsList == null)
        this.auditsList = new ArrayList<AUDIT_DETAILS>();
      this.auditsList.add(t);
      return t;
    }

    public REVISION_HISTORY_ITEM addAudits(AUDIT_DETAILS t) { //3b
      if (t == null)
        return this;
      if (this.auditsList == null)
        this.auditsList = new ArrayList<AUDIT_DETAILS>();
      this.auditsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #audits}, creating it if it does not already exist {3}
     */
    public AUDIT_DETAILS getAuditsFirstRep() { 
      if (getAuditsList().isEmpty()) {
        addAudits();
      }
      return getAuditsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("version_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Version identifier for this revision.", 0, 1, version_id));
        children.add(new Property("audits", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "The audits for this revision; there will always be at least one commit audit (which may itself be an ATTESTATION), there may also be further attestations.", 0, java.lang.Integer.MAX_VALUE, auditsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -670497310: /*version_id*/  return new Property("version_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Version identifier for this revision.", 0, 1, version_id);
        case -1406803976: /*audits*/  return new Property("audits", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "The audits for this revision; there will always be at least one commit audit (which may itself be an ATTESTATION), there may also be further attestations.", 0, java.lang.Integer.MAX_VALUE, auditsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -670497310: /*version_id*/ return this.version_id == null ? new Base[0] : new Base[] {this.version_id}; // OBJECT_VERSION_ID
        case -1406803976: /*audits*/ return this.auditsList == null ? new Base[0] : this.auditsList.toArray(new Base[this.auditsList.size()]); // AUDIT_DETAILS
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -670497310: // version_id
          this.version_id = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
          return value;
        case -1406803976: // audits
          this.getAuditsList().add((AUDIT_DETAILS) value); // AUDIT_DETAILS
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("version_id")) {
          this.version_id = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
        } else if (name.equals("audits")) {
          this.getAuditsList().add((AUDIT_DETAILS) value); // AUDIT_DETAILS
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -670497310:  return getVersion_id();
        case -1406803976:  return addAudits(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -670497310: /*version_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID"};
        case -1406803976: /*audits*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("version_id")) {
          this.version_id = new OBJECT_VERSION_ID();
          return this.version_id;
        }
        else if (name.equals("audits")) {
          return addAudits();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "REVISION_HISTORY_ITEM";

  }

      public REVISION_HISTORY_ITEM copy() {
        REVISION_HISTORY_ITEM dst = new REVISION_HISTORY_ITEM();
        copyValues(dst);
        return dst;
      }

      public void copyValues(REVISION_HISTORY_ITEM dst) {
        super.copyValues(dst);
        dst.version_id = version_id == null ? null : version_id.copy();
        if (auditsList != null) {
          dst.auditsList = new ArrayList<AUDIT_DETAILS>();
          for (AUDIT_DETAILS i : auditsList)
            dst.auditsList.add(i.copy());
        };
      }

      protected REVISION_HISTORY_ITEM typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof REVISION_HISTORY_ITEM))
          return false;
        REVISION_HISTORY_ITEM o = (REVISION_HISTORY_ITEM) other_;
        return compareDeep(version_id, o.version_id, true) && compareDeep(auditsList, o.auditsList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof REVISION_HISTORY_ITEM))
          return false;
        REVISION_HISTORY_ITEM o = (REVISION_HISTORY_ITEM) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(version_id, auditsList);
      }


}

