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
 * Proxy type for identifying a party and its relationship to the subject of the record. Use where the relationship between the party and the subject of the record must be known.
 */
@DatatypeDef(name="PARTY_RELATED")
public class PARTY_RELATED extends PARTY_IDENTIFIED implements ICompositeType {

    /**
     * Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self.
     */
    @Child(name = "relationship", type = {DV_CODED_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Relationship of subject of this ENTRY to the subject of the record. May be coded", formalDefinition="Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-subject_relationship")
    protected DV_CODED_TEXT relationship;

    private static final long serialVersionUID = -391010544L;

  /**
   * Constructor
   */
    public PARTY_RELATED() {
      super();
    }

  /**
   * Constructor
   */
    public PARTY_RELATED(DV_CODED_TEXT relationship) {
      super();
      this.setRelationship(relationship);
    }

    /**
     * @return {@link #relationship} (Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self.)
     */
    public DV_CODED_TEXT getRelationship() { 
      if (this.relationship == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_RELATED.relationship");
        else if (Configuration.doAutoCreate())
          this.relationship = new DV_CODED_TEXT(); // cc
      return this.relationship;
    }

    public boolean hasRelationship() { 
      return this.relationship != null && !this.relationship.isEmpty();
    }

    /**
     * @param value {@link #relationship} (Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self.)
     */
    public PARTY_RELATED setRelationship(DV_CODED_TEXT value) { 
      this.relationship = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("relationship", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self.", 0, 1, relationship));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -261851592: /*relationship*/  return new Property("relationship", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Relationship of subject of this ENTRY to the subject of the record. May be coded. If it is the patient, coded as self.", 0, 1, relationship);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // DV_CODED_TEXT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -261851592: // relationship
          this.relationship = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("relationship")) {
          this.relationship = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261851592:  return getRelationship();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261851592: /*relationship*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("relationship")) {
          this.relationship = new DV_CODED_TEXT();
          return this.relationship;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY_RELATED";

  }

      public PARTY_RELATED copy() {
        PARTY_RELATED dst = new PARTY_RELATED();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PARTY_RELATED dst) {
        super.copyValues(dst);
        dst.relationship = relationship == null ? null : relationship.copy();
      }

      protected PARTY_RELATED typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY_RELATED))
          return false;
        PARTY_RELATED o = (PARTY_RELATED) other_;
        return compareDeep(relationship, o.relationship, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY_RELATED))
          return false;
        PARTY_RELATED o = (PARTY_RELATED) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relationship);
      }


}

