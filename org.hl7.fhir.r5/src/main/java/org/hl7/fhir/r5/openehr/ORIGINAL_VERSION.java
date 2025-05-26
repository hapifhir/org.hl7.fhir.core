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
 * A Version containing locally created content and optional attestations.
 */
@DatatypeDef(name="ORIGINAL_VERSION")
public class ORIGINAL_VERSION extends VERSION implements ICompositeType {

    /**
     * Stored version of inheritance precursor.
     */
    @Child(name = "uid", type = {OBJECT_VERSION_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Stored version of inheritance precursor", formalDefinition="Stored version of inheritance precursor." )
    protected OBJECT_VERSION_ID uid;

    /**
     * Stored version of inheritance precursor.
     */
    @Child(name = "preceding_version_uid", type = {OBJECT_VERSION_ID.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Stored version of inheritance precursor", formalDefinition="Stored version of inheritance precursor." )
    protected OBJECT_VERSION_ID preceding_version_uid;

    /**
     * Identifiers of other versions whose content was merged into this version, if any.
     */
    @Child(name = "other_input_version_uids", type = {OBJECT_VERSION_ID.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers of other versions whose content was merged into this version, if any", formalDefinition="Identifiers of other versions whose content was merged into this version, if any." )
    protected List<OBJECT_VERSION_ID> other_input_version_uidsList;

    /**
     * Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state.
     */
    @Child(name = "lifecycle_state", type = {DV_CODED_TEXT.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Lifecycle state of the content item in this version", formalDefinition="Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-version_lifecycle_state")
    protected DV_CODED_TEXT lifecycle_state;

    /**
     * Set of attestations relating to this version.
     */
    @Child(name = "attestations", type = {ATTESTATION.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Set of attestations relating to this version", formalDefinition="Set of attestations relating to this version." )
    protected List<ATTESTATION> attestationsList;

    /**
     * Data content of this Version.
     */
    @Child(name = "data", type = {Reference.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Data content of this Version", formalDefinition="Data content of this Version." )
    protected Any data;

    private static final long serialVersionUID = 622601284L;

  /**
   * Constructor
   */
    public ORIGINAL_VERSION() {
      super();
    }

  /**
   * Constructor
   */
    public ORIGINAL_VERSION(OBJECT_VERSION_ID uid, OBJECT_VERSION_ID preceding_version_uid, DV_CODED_TEXT lifecycle_state) {
      super();
      this.setUid(uid);
      this.setPreceding_version_uid(preceding_version_uid);
      this.setLifecycle_state(lifecycle_state);
    }

    /**
     * @return {@link #uid} (Stored version of inheritance precursor.)
     */
    public OBJECT_VERSION_ID getUid() { 
      if (this.uid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ORIGINAL_VERSION.uid");
        else if (Configuration.doAutoCreate())
          this.uid = new OBJECT_VERSION_ID(); // cc
      return this.uid;
    }

    public boolean hasUid() { 
      return this.uid != null && !this.uid.isEmpty();
    }

    /**
     * @param value {@link #uid} (Stored version of inheritance precursor.)
     */
    public ORIGINAL_VERSION setUid(OBJECT_VERSION_ID value) { 
      this.uid = value;
      return this;
    }

    /**
     * @return {@link #preceding_version_uid} (Stored version of inheritance precursor.)
     */
    public OBJECT_VERSION_ID getPreceding_version_uid() { 
      if (this.preceding_version_uid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ORIGINAL_VERSION.preceding_version_uid");
        else if (Configuration.doAutoCreate())
          this.preceding_version_uid = new OBJECT_VERSION_ID(); // cc
      return this.preceding_version_uid;
    }

    public boolean hasPreceding_version_uid() { 
      return this.preceding_version_uid != null && !this.preceding_version_uid.isEmpty();
    }

    /**
     * @param value {@link #preceding_version_uid} (Stored version of inheritance precursor.)
     */
    public ORIGINAL_VERSION setPreceding_version_uid(OBJECT_VERSION_ID value) { 
      this.preceding_version_uid = value;
      return this;
    }

    /**
     * @return {@link #other_input_version_uids} (Identifiers of other versions whose content was merged into this version, if any.)
     */
    public List<OBJECT_VERSION_ID> getOther_input_version_uidsList() { 
      if (this.other_input_version_uidsList == null)
        this.other_input_version_uidsList = new ArrayList<OBJECT_VERSION_ID>();
      return this.other_input_version_uidsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ORIGINAL_VERSION setOther_input_version_uidsList(List<OBJECT_VERSION_ID> theOther_input_version_uids) { 
      this.other_input_version_uidsList = theOther_input_version_uids;
      return this;
    }

    public boolean hasOther_input_version_uids() { 
      if (this.other_input_version_uidsList == null)
        return false;
      for (OBJECT_VERSION_ID item : this.other_input_version_uidsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_VERSION_ID addOther_input_version_uids() { //3a
      OBJECT_VERSION_ID t = new OBJECT_VERSION_ID();
      if (this.other_input_version_uidsList == null)
        this.other_input_version_uidsList = new ArrayList<OBJECT_VERSION_ID>();
      this.other_input_version_uidsList.add(t);
      return t;
    }

    public ORIGINAL_VERSION addOther_input_version_uids(OBJECT_VERSION_ID t) { //3b
      if (t == null)
        return this;
      if (this.other_input_version_uidsList == null)
        this.other_input_version_uidsList = new ArrayList<OBJECT_VERSION_ID>();
      this.other_input_version_uidsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #other_input_version_uids}, creating it if it does not already exist {3}
     */
    public OBJECT_VERSION_ID getOther_input_version_uidsFirstRep() { 
      if (getOther_input_version_uidsList().isEmpty()) {
        addOther_input_version_uids();
      }
      return getOther_input_version_uidsList().get(0);
    }

    /**
     * @return {@link #lifecycle_state} (Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state.)
     */
    public DV_CODED_TEXT getLifecycle_state() { 
      if (this.lifecycle_state == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ORIGINAL_VERSION.lifecycle_state");
        else if (Configuration.doAutoCreate())
          this.lifecycle_state = new DV_CODED_TEXT(); // cc
      return this.lifecycle_state;
    }

    public boolean hasLifecycle_state() { 
      return this.lifecycle_state != null && !this.lifecycle_state.isEmpty();
    }

    /**
     * @param value {@link #lifecycle_state} (Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state.)
     */
    public ORIGINAL_VERSION setLifecycle_state(DV_CODED_TEXT value) { 
      this.lifecycle_state = value;
      return this;
    }

    /**
     * @return {@link #attestations} (Set of attestations relating to this version.)
     */
    public List<ATTESTATION> getAttestationsList() { 
      if (this.attestationsList == null)
        this.attestationsList = new ArrayList<ATTESTATION>();
      return this.attestationsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ORIGINAL_VERSION setAttestationsList(List<ATTESTATION> theAttestations) { 
      this.attestationsList = theAttestations;
      return this;
    }

    public boolean hasAttestations() { 
      if (this.attestationsList == null)
        return false;
      for (ATTESTATION item : this.attestationsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ATTESTATION addAttestations() { //3a
      ATTESTATION t = new ATTESTATION();
      if (this.attestationsList == null)
        this.attestationsList = new ArrayList<ATTESTATION>();
      this.attestationsList.add(t);
      return t;
    }

    public ORIGINAL_VERSION addAttestations(ATTESTATION t) { //3b
      if (t == null)
        return this;
      if (this.attestationsList == null)
        this.attestationsList = new ArrayList<ATTESTATION>();
      this.attestationsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #attestations}, creating it if it does not already exist {3}
     */
    public ATTESTATION getAttestationsFirstRep() { 
      if (getAttestationsList().isEmpty()) {
        addAttestations();
      }
      return getAttestationsList().get(0);
    }

    /**
     * @return {@link #data} (Data content of this Version.)
     */
    public Any getData() { 
      return this.data;
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (Data content of this Version.)
     */
    public ORIGINAL_VERSION setData(Any value) { 
      this.data = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("uid", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Stored version of inheritance precursor.", 0, 1, uid));
        children.add(new Property("preceding_version_uid", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Stored version of inheritance precursor.", 0, 1, preceding_version_uid));
        children.add(new Property("other_input_version_uids", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Identifiers of other versions whose content was merged into this version, if any.", 0, java.lang.Integer.MAX_VALUE, other_input_version_uidsList));
        children.add(new Property("lifecycle_state", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state.", 0, 1, lifecycle_state));
        children.add(new Property("attestations", "http://openehr.org/fhir/StructureDefinition/ATTESTATION", "Set of attestations relating to this version.", 0, java.lang.Integer.MAX_VALUE, attestationsList));
        children.add(new Property("data", "http://openehr.org/fhir/StructureDefinition/Any", "Data content of this Version.", 0, 1, data));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 115792: /*uid*/  return new Property("uid", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Stored version of inheritance precursor.", 0, 1, uid);
        case -1532609811: /*preceding_version_uid*/  return new Property("preceding_version_uid", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Stored version of inheritance precursor.", 0, 1, preceding_version_uid);
        case -653393650: /*other_input_version_uids*/  return new Property("other_input_version_uids", "http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID", "Identifiers of other versions whose content was merged into this version, if any.", 0, java.lang.Integer.MAX_VALUE, other_input_version_uidsList);
        case 1508726652: /*lifecycle_state*/  return new Property("lifecycle_state", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Lifecycle state of the content item in this version; coded by openEHR vocabulary version lifecycle state.", 0, 1, lifecycle_state);
        case -523510877: /*attestations*/  return new Property("attestations", "http://openehr.org/fhir/StructureDefinition/ATTESTATION", "Set of attestations relating to this version.", 0, java.lang.Integer.MAX_VALUE, attestationsList);
        case 3076010: /*data*/  return new Property("data", "http://openehr.org/fhir/StructureDefinition/Any", "Data content of this Version.", 0, 1, data);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // OBJECT_VERSION_ID
        case -1532609811: /*preceding_version_uid*/ return this.preceding_version_uid == null ? new Base[0] : new Base[] {this.preceding_version_uid}; // OBJECT_VERSION_ID
        case -653393650: /*other_input_version_uids*/ return this.other_input_version_uidsList == null ? new Base[0] : this.other_input_version_uidsList.toArray(new Base[this.other_input_version_uidsList.size()]); // OBJECT_VERSION_ID
        case 1508726652: /*lifecycle_state*/ return this.lifecycle_state == null ? new Base[0] : new Base[] {this.lifecycle_state}; // DV_CODED_TEXT
        case -523510877: /*attestations*/ return this.attestationsList == null ? new Base[0] : this.attestationsList.toArray(new Base[this.attestationsList.size()]); // ATTESTATION
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // Any
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
          return value;
        case -1532609811: // preceding_version_uid
          this.preceding_version_uid = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
          return value;
        case -653393650: // other_input_version_uids
          this.getOther_input_version_uidsList().add((OBJECT_VERSION_ID) value); // OBJECT_VERSION_ID
          return value;
        case 1508726652: // lifecycle_state
          this.lifecycle_state = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -523510877: // attestations
          this.getAttestationsList().add((ATTESTATION) value); // ATTESTATION
          return value;
        case 3076010: // data
          this.data = (Any) value; // Any
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
        } else if (name.equals("preceding_version_uid")) {
          this.preceding_version_uid = (OBJECT_VERSION_ID) value; // OBJECT_VERSION_ID
        } else if (name.equals("other_input_version_uids")) {
          this.getOther_input_version_uidsList().add((OBJECT_VERSION_ID) value); // OBJECT_VERSION_ID
        } else if (name.equals("lifecycle_state")) {
          this.lifecycle_state = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("attestations")) {
          this.getAttestationsList().add((ATTESTATION) value); // ATTESTATION
        } else if (name.equals("data")) {
          this.data = (Any) value; // Any
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUid();
        case -1532609811:  return getPreceding_version_uid();
        case -653393650:  return addOther_input_version_uids(); 
        case 1508726652:  return getLifecycle_state();
        case -523510877:  return addAttestations(); 
        case 3076010: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'data'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID"};
        case -1532609811: /*preceding_version_uid*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID"};
        case -653393650: /*other_input_version_uids*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-VERSION-ID"};
        case 1508726652: /*lifecycle_state*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -523510877: /*attestations*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ATTESTATION"};
        case 3076010: /*data*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/Any"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = new OBJECT_VERSION_ID();
          return this.uid;
        }
        else if (name.equals("preceding_version_uid")) {
          this.preceding_version_uid = new OBJECT_VERSION_ID();
          return this.preceding_version_uid;
        }
        else if (name.equals("other_input_version_uids")) {
          return addOther_input_version_uids();
        }
        else if (name.equals("lifecycle_state")) {
          this.lifecycle_state = new DV_CODED_TEXT();
          return this.lifecycle_state;
        }
        else if (name.equals("attestations")) {
          return addAttestations();
        }
        else if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on an abstract type ORIGINAL_VERSION.data");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ORIGINAL_VERSION";

  }

      public ORIGINAL_VERSION copy() {
        ORIGINAL_VERSION dst = new ORIGINAL_VERSION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ORIGINAL_VERSION dst) {
        super.copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.preceding_version_uid = preceding_version_uid == null ? null : preceding_version_uid.copy();
        if (other_input_version_uidsList != null) {
          dst.other_input_version_uidsList = new ArrayList<OBJECT_VERSION_ID>();
          for (OBJECT_VERSION_ID i : other_input_version_uidsList)
            dst.other_input_version_uidsList.add(i.copy());
        };
        dst.lifecycle_state = lifecycle_state == null ? null : lifecycle_state.copy();
        if (attestationsList != null) {
          dst.attestationsList = new ArrayList<ATTESTATION>();
          for (ATTESTATION i : attestationsList)
            dst.attestationsList.add(i.copy());
        };
        dst.data = data == null ? null : data.copy();
      }

      protected ORIGINAL_VERSION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ORIGINAL_VERSION))
          return false;
        ORIGINAL_VERSION o = (ORIGINAL_VERSION) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(preceding_version_uid, o.preceding_version_uid, true)
           && compareDeep(other_input_version_uidsList, o.other_input_version_uidsList, true) && compareDeep(lifecycle_state, o.lifecycle_state, true)
           && compareDeep(attestationsList, o.attestationsList, true) && compareDeep(data, o.data, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ORIGINAL_VERSION))
          return false;
        ORIGINAL_VERSION o = (ORIGINAL_VERSION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, preceding_version_uid
          , other_input_version_uidsList, lifecycle_state, attestationsList, data);
      }


}

