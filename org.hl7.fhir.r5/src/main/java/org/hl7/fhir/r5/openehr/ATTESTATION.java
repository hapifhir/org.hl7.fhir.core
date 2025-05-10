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
 * Record an attestation of a party (the committer) to item(s) of record content. An attestation is an explicit signing by one healthcare agent of particular content for various particular purposes, including:

* for authorisation of a controlled substance or procedure (e.g. sectioning of patient under mental health act);
* witnessing of content by senior clinical professional;
* indicating acknowledgement of content by intended recipient, e.g. GP who ordered a test result.
 */
@DatatypeDef(name="ATTESTATION")
public class ATTESTATION extends AUDIT_DETAILS implements ICompositeType {

    /**
     * Optional visual representation of content attested e.g. screen image.
     */
    @Child(name = "attested_view", type = {DV_MULTIMEDIA.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional visual representation of content attested e.g. screen image", formalDefinition="Optional visual representation of content attested e.g. screen image." )
    protected DV_MULTIMEDIA attested_view;

    /**
     * Proof of attestation.
     */
    @Child(name = "proof", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Proof of attestation", formalDefinition="Proof of attestation." )
    protected StringType proof;

    /**
     * Items attested, expressed as fully qualified runtime paths to the items in question. Although not recommended, these may include fine-grained items which have been attested in some other system. Otherwise it is assumed to be for the entire VERSION with which it is associated.
     */
    @Child(name = "items", type = {DV_EHR_URI.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Items attested, expressed as fully qualified runtime paths to the items in question", formalDefinition="Items attested, expressed as fully qualified runtime paths to the items in question. Although not recommended, these may include fine-grained items which have been attested in some other system. Otherwise it is assumed to be for the entire VERSION with which it is associated." )
    protected List<DV_EHR_URI> itemsList;

    /**
     * Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc.
     */
    @Child(name = "reason", type = {DV_TEXT.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason of this attestation", formalDefinition="Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-attestation_reason")
    protected DV_TEXT reason;

    /**
     * True if this attestation is outstanding; False means it has been completed.
     */
    @Child(name = "is_pending", type = {BooleanType.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="True if this attestation is outstanding; False means it has been completed", formalDefinition="True if this attestation is outstanding; False means it has been completed." )
    protected BooleanType is_pending;

    private static final long serialVersionUID = 1016314460L;

  /**
   * Constructor
   */
    public ATTESTATION() {
      super();
    }

  /**
   * Constructor
   */
    public ATTESTATION(DV_TEXT reason, boolean is_pending) {
      super();
      this.setReason(reason);
      this.setIs_pending(is_pending);
    }

    /**
     * @return {@link #attested_view} (Optional visual representation of content attested e.g. screen image.)
     */
    public DV_MULTIMEDIA getAttested_view() { 
      if (this.attested_view == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ATTESTATION.attested_view");
        else if (Configuration.doAutoCreate())
          this.attested_view = new DV_MULTIMEDIA(); // cc
      return this.attested_view;
    }

    public boolean hasAttested_view() { 
      return this.attested_view != null && !this.attested_view.isEmpty();
    }

    /**
     * @param value {@link #attested_view} (Optional visual representation of content attested e.g. screen image.)
     */
    public ATTESTATION setAttested_view(DV_MULTIMEDIA value) { 
      this.attested_view = value;
      return this;
    }

    /**
     * @return {@link #proof} (Proof of attestation.). This is the underlying object with id, value and extensions. The accessor "getProof" gives direct access to the value
     */
    public StringType getProofElement() { 
      if (this.proof == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ATTESTATION.proof");
        else if (Configuration.doAutoCreate())
          this.proof = new StringType(); // bb
      return this.proof;
    }

    public boolean hasProofElement() { 
      return this.proof != null && !this.proof.isEmpty();
    }

    public boolean hasProof() { 
      return this.proof != null && !this.proof.isEmpty();
    }

    /**
     * @param value {@link #proof} (Proof of attestation.). This is the underlying object with id, value and extensions. The accessor "getProof" gives direct access to the value
     */
    public ATTESTATION setProofElement(StringType value) { 
      this.proof = value;
      return this;
    }

    /**
     * @return Proof of attestation.
     */
    public String getProof() { 
      return this.proof == null ? null : this.proof.getValue();
    }

    /**
     * @param value Proof of attestation.
     */
    public ATTESTATION setProof(String value) { 
      if (Utilities.noString(value))
        this.proof = null;
      else {
        if (this.proof == null)
          this.proof = new StringType();
        this.proof.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #items} (Items attested, expressed as fully qualified runtime paths to the items in question. Although not recommended, these may include fine-grained items which have been attested in some other system. Otherwise it is assumed to be for the entire VERSION with which it is associated.)
     */
    public List<DV_EHR_URI> getItemsList() { 
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_EHR_URI>();
      return this.itemsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ATTESTATION setItemsList(List<DV_EHR_URI> theItems) { 
      this.itemsList = theItems;
      return this;
    }

    public boolean hasItems() { 
      if (this.itemsList == null)
        return false;
      for (DV_EHR_URI item : this.itemsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_EHR_URI addItems() { //3a
      DV_EHR_URI t = new DV_EHR_URI();
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_EHR_URI>();
      this.itemsList.add(t);
      return t;
    }

    public ATTESTATION addItems(DV_EHR_URI t) { //3b
      if (t == null)
        return this;
      if (this.itemsList == null)
        this.itemsList = new ArrayList<DV_EHR_URI>();
      this.itemsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #items}, creating it if it does not already exist {3}
     */
    public DV_EHR_URI getItemsFirstRep() { 
      if (getItemsList().isEmpty()) {
        addItems();
      }
      return getItemsList().get(0);
    }

    /**
     * @return {@link #reason} (Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc.)
     */
    public DV_TEXT getReason() { 
      if (this.reason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ATTESTATION.reason");
        else if (Configuration.doAutoCreate())
          this.reason = new DV_TEXT(); // cc
      return this.reason;
    }

    public boolean hasReason() { 
      return this.reason != null && !this.reason.isEmpty();
    }

    /**
     * @param value {@link #reason} (Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc.)
     */
    public ATTESTATION setReason(DV_TEXT value) { 
      this.reason = value;
      return this;
    }

    /**
     * @return {@link #is_pending} (True if this attestation is outstanding; False means it has been completed.). This is the underlying object with id, value and extensions. The accessor "getIs_pending" gives direct access to the value
     */
    public BooleanType getIs_pendingElement() { 
      if (this.is_pending == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ATTESTATION.is_pending");
        else if (Configuration.doAutoCreate())
          this.is_pending = new BooleanType(); // bb
      return this.is_pending;
    }

    public boolean hasIs_pendingElement() { 
      return this.is_pending != null && !this.is_pending.isEmpty();
    }

    public boolean hasIs_pending() { 
      return this.is_pending != null && !this.is_pending.isEmpty();
    }

    /**
     * @param value {@link #is_pending} (True if this attestation is outstanding; False means it has been completed.). This is the underlying object with id, value and extensions. The accessor "getIs_pending" gives direct access to the value
     */
    public ATTESTATION setIs_pendingElement(BooleanType value) { 
      this.is_pending = value;
      return this;
    }

    /**
     * @return True if this attestation is outstanding; False means it has been completed.
     */
    public boolean getIs_pending() { 
      return this.is_pending == null || this.is_pending.isEmpty() ? false : this.is_pending.getValue();
    }

    /**
     * @param value True if this attestation is outstanding; False means it has been completed.
     */
    public ATTESTATION setIs_pending(boolean value) { 
        if (this.is_pending == null)
          this.is_pending = new BooleanType();
        this.is_pending.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("attested_view", "http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA", "Optional visual representation of content attested e.g. screen image.", 0, 1, attested_view));
        children.add(new Property("proof", "string", "Proof of attestation.", 0, 1, proof));
        children.add(new Property("items", "http://openehr.org/fhir/StructureDefinition/DV-EHR-URI", "Items attested, expressed as fully qualified runtime paths to the items in question. Although not recommended, these may include fine-grained items which have been attested in some other system. Otherwise it is assumed to be for the entire VERSION with which it is associated.", 0, java.lang.Integer.MAX_VALUE, itemsList));
        children.add(new Property("reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc.", 0, 1, reason));
        children.add(new Property("is_pending", "boolean", "True if this attestation is outstanding; False means it has been completed.", 0, 1, is_pending));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -261018784: /*attested_view*/  return new Property("attested_view", "http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA", "Optional visual representation of content attested e.g. screen image.", 0, 1, attested_view);
        case 106940740: /*proof*/  return new Property("proof", "string", "Proof of attestation.", 0, 1, proof);
        case 100526016: /*items*/  return new Property("items", "http://openehr.org/fhir/StructureDefinition/DV-EHR-URI", "Items attested, expressed as fully qualified runtime paths to the items in question. Although not recommended, these may include fine-grained items which have been attested in some other system. Otherwise it is assumed to be for the entire VERSION with which it is associated.", 0, java.lang.Integer.MAX_VALUE, itemsList);
        case -934964668: /*reason*/  return new Property("reason", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Reason of this attestation. Optionally coded by the openEHR Terminology group attestation reason ; includes values like authorisation , witness etc.", 0, 1, reason);
        case 817722242: /*is_pending*/  return new Property("is_pending", "boolean", "True if this attestation is outstanding; False means it has been completed.", 0, 1, is_pending);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -261018784: /*attested_view*/ return this.attested_view == null ? new Base[0] : new Base[] {this.attested_view}; // DV_MULTIMEDIA
        case 106940740: /*proof*/ return this.proof == null ? new Base[0] : new Base[] {this.proof}; // StringType
        case 100526016: /*items*/ return this.itemsList == null ? new Base[0] : this.itemsList.toArray(new Base[this.itemsList.size()]); // DV_EHR_URI
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // DV_TEXT
        case 817722242: /*is_pending*/ return this.is_pending == null ? new Base[0] : new Base[] {this.is_pending}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -261018784: // attested_view
          this.attested_view = (DV_MULTIMEDIA) value; // DV_MULTIMEDIA
          return value;
        case 106940740: // proof
          this.proof = TypeConvertor.castToString(value); // StringType
          return value;
        case 100526016: // items
          this.getItemsList().add((DV_EHR_URI) value); // DV_EHR_URI
          return value;
        case -934964668: // reason
          this.reason = (DV_TEXT) value; // DV_TEXT
          return value;
        case 817722242: // is_pending
          this.is_pending = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("attested_view")) {
          this.attested_view = (DV_MULTIMEDIA) value; // DV_MULTIMEDIA
        } else if (name.equals("proof")) {
          this.proof = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("items")) {
          this.getItemsList().add((DV_EHR_URI) value); // DV_EHR_URI
        } else if (name.equals("reason")) {
          this.reason = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("is_pending")) {
          this.is_pending = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261018784:  return getAttested_view();
        case 106940740:  return getProofElement();
        case 100526016:  return addItems(); 
        case -934964668:  return getReason();
        case 817722242:  return getIs_pendingElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -261018784: /*attested_view*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA"};
        case 106940740: /*proof*/ return new String[] {"string"};
        case 100526016: /*items*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-EHR-URI"};
        case -934964668: /*reason*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 817722242: /*is_pending*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("attested_view")) {
          this.attested_view = new DV_MULTIMEDIA();
          return this.attested_view;
        }
        else if (name.equals("proof")) {
          throw new FHIRException("Cannot call addChild on a singleton property ATTESTATION.proof");
        }
        else if (name.equals("items")) {
          return addItems();
        }
        else if (name.equals("reason")) {
          this.reason = new DV_TEXT();
          return this.reason;
        }
        else if (name.equals("is_pending")) {
          throw new FHIRException("Cannot call addChild on a singleton property ATTESTATION.is_pending");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ATTESTATION";

  }

      public ATTESTATION copy() {
        ATTESTATION dst = new ATTESTATION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ATTESTATION dst) {
        super.copyValues(dst);
        dst.attested_view = attested_view == null ? null : attested_view.copy();
        dst.proof = proof == null ? null : proof.copy();
        if (itemsList != null) {
          dst.itemsList = new ArrayList<DV_EHR_URI>();
          for (DV_EHR_URI i : itemsList)
            dst.itemsList.add(i.copy());
        };
        dst.reason = reason == null ? null : reason.copy();
        dst.is_pending = is_pending == null ? null : is_pending.copy();
      }

      protected ATTESTATION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ATTESTATION))
          return false;
        ATTESTATION o = (ATTESTATION) other_;
        return compareDeep(attested_view, o.attested_view, true) && compareDeep(proof, o.proof, true) && compareDeep(itemsList, o.itemsList, true)
           && compareDeep(reason, o.reason, true) && compareDeep(is_pending, o.is_pending, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ATTESTATION))
          return false;
        ATTESTATION o = (ATTESTATION) other_;
        return compareValues(proof, o.proof, true) && compareValues(is_pending, o.is_pending, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(attested_view, proof, itemsList
          , reason, is_pending);
      }


}

