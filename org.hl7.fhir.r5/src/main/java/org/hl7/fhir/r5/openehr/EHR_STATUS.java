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
 * Single object per EHR containing various EHR-wide status flags and settings, including whether this EHR can be queried, modified etc. This object is always modifiable, in order to change the status of the EHR as a whole.
 */
@DatatypeDef(name="EHR_STATUS")
public class EHR_STATUS extends LOCATABLE implements ICompositeType {

    /**
     * The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons.
     */
    @Child(name = "subject", type = {PARTY_SELF.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons", formalDefinition="The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons." )
    protected PARTY_SELF subject;

    /**
     * True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.
     */
    @Child(name = "is_queryable", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population", formalDefinition="True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population." )
    protected BooleanType is_queryable;

    /**
     * True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.
     */
    @Child(name = "is_modifiable", type = {BooleanType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to", formalDefinition="True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to." )
    protected BooleanType is_modifiable;

    /**
     * Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE.
     */
    @Child(name = "other_details", type = {ITEM_STRUCTURE.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE", formalDefinition="Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE." )
    protected ITEM_STRUCTURE other_details;

    private static final long serialVersionUID = -1523453193L;

  /**
   * Constructor
   */
    public EHR_STATUS() {
      super();
    }

  /**
   * Constructor
   */
    public EHR_STATUS(PARTY_SELF subject, boolean is_queryable, boolean is_modifiable) {
      super();
      this.setSubject(subject);
      this.setIs_queryable(is_queryable);
      this.setIs_modifiable(is_modifiable);
    }

    /**
     * @return {@link #subject} (The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons.)
     */
    public PARTY_SELF getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR_STATUS.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new PARTY_SELF(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons.)
     */
    public EHR_STATUS setSubject(PARTY_SELF value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #is_queryable} (True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.). This is the underlying object with id, value and extensions. The accessor "getIs_queryable" gives direct access to the value
     */
    public BooleanType getIs_queryableElement() { 
      if (this.is_queryable == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR_STATUS.is_queryable");
        else if (Configuration.doAutoCreate())
          this.is_queryable = new BooleanType(); // bb
      return this.is_queryable;
    }

    public boolean hasIs_queryableElement() { 
      return this.is_queryable != null && !this.is_queryable.isEmpty();
    }

    public boolean hasIs_queryable() { 
      return this.is_queryable != null && !this.is_queryable.isEmpty();
    }

    /**
     * @param value {@link #is_queryable} (True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.). This is the underlying object with id, value and extensions. The accessor "getIs_queryable" gives direct access to the value
     */
    public EHR_STATUS setIs_queryableElement(BooleanType value) { 
      this.is_queryable = value;
      return this;
    }

    /**
     * @return True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.
     */
    public boolean getIs_queryable() { 
      return this.is_queryable == null || this.is_queryable.isEmpty() ? false : this.is_queryable.getValue();
    }

    /**
     * @param value True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.
     */
    public EHR_STATUS setIs_queryable(boolean value) { 
        if (this.is_queryable == null)
          this.is_queryable = new BooleanType();
        this.is_queryable.setValue(value);
      return this;
    }

    /**
     * @return {@link #is_modifiable} (True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.). This is the underlying object with id, value and extensions. The accessor "getIs_modifiable" gives direct access to the value
     */
    public BooleanType getIs_modifiableElement() { 
      if (this.is_modifiable == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR_STATUS.is_modifiable");
        else if (Configuration.doAutoCreate())
          this.is_modifiable = new BooleanType(); // bb
      return this.is_modifiable;
    }

    public boolean hasIs_modifiableElement() { 
      return this.is_modifiable != null && !this.is_modifiable.isEmpty();
    }

    public boolean hasIs_modifiable() { 
      return this.is_modifiable != null && !this.is_modifiable.isEmpty();
    }

    /**
     * @param value {@link #is_modifiable} (True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.). This is the underlying object with id, value and extensions. The accessor "getIs_modifiable" gives direct access to the value
     */
    public EHR_STATUS setIs_modifiableElement(BooleanType value) { 
      this.is_modifiable = value;
      return this;
    }

    /**
     * @return True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.
     */
    public boolean getIs_modifiable() { 
      return this.is_modifiable == null || this.is_modifiable.isEmpty() ? false : this.is_modifiable.getValue();
    }

    /**
     * @param value True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.
     */
    public EHR_STATUS setIs_modifiable(boolean value) { 
        if (this.is_modifiable == null)
          this.is_modifiable = new BooleanType();
        this.is_modifiable.setValue(value);
      return this;
    }

    /**
     * @return {@link #other_details} (Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE.)
     */
    public ITEM_STRUCTURE getOther_details() { 
      return this.other_details;
    }

    public boolean hasOther_details() { 
      return this.other_details != null && !this.other_details.isEmpty();
    }

    /**
     * @param value {@link #other_details} (Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE.)
     */
    public EHR_STATUS setOther_details(ITEM_STRUCTURE value) { 
      this.other_details = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-SELF", "The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons.", 0, 1, subject));
        children.add(new Property("is_queryable", "boolean", "True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.", 0, 1, is_queryable));
        children.add(new Property("is_modifiable", "boolean", "True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.", 0, 1, is_modifiable));
        children.add(new Property("other_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE.", 0, 1, other_details));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1867885268: /*subject*/  return new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-SELF", "The subject of this EHR. The external_ref attribute can be used to contain a direct reference to the subject in a demographic or identity service. Alternatively, the association between patients and their records may be done elsewhere for security reasons.", 0, 1, subject);
        case 1177363789: /*is_queryable*/  return new Property("is_queryable", "boolean", "True if this EHR should be included in population queries, i.e. if this EHR is considered active in the population.", 0, 1, is_queryable);
        case -792595655: /*is_modifiable*/  return new Property("is_modifiable", "boolean", "True if the EHR, other than the EHR_STATUS object, is allowed to be written to. The EHR_STATUS object itself can always be written to.", 0, 1, is_modifiable);
        case -1257043949: /*other_details*/  return new Property("other_details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Any other details of the EHR summary object, in the form of an archetyped ITEM_STRUCTURE.", 0, 1, other_details);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // PARTY_SELF
        case 1177363789: /*is_queryable*/ return this.is_queryable == null ? new Base[0] : new Base[] {this.is_queryable}; // BooleanType
        case -792595655: /*is_modifiable*/ return this.is_modifiable == null ? new Base[0] : new Base[] {this.is_modifiable}; // BooleanType
        case -1257043949: /*other_details*/ return this.other_details == null ? new Base[0] : new Base[] {this.other_details}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1867885268: // subject
          this.subject = (PARTY_SELF) value; // PARTY_SELF
          return value;
        case 1177363789: // is_queryable
          this.is_queryable = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -792595655: // is_modifiable
          this.is_modifiable = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1257043949: // other_details
          this.other_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("subject")) {
          this.subject = (PARTY_SELF) value; // PARTY_SELF
        } else if (name.equals("is_queryable")) {
          this.is_queryable = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("is_modifiable")) {
          this.is_modifiable = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("other_details")) {
          this.other_details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1867885268:  return getSubject();
        case 1177363789:  return getIs_queryableElement();
        case -792595655:  return getIs_modifiableElement();
        case -1257043949: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'other_details'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1867885268: /*subject*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-SELF"};
        case 1177363789: /*is_queryable*/ return new String[] {"boolean"};
        case -792595655: /*is_modifiable*/ return new String[] {"boolean"};
        case -1257043949: /*other_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("subject")) {
          this.subject = new PARTY_SELF();
          return this.subject;
        }
        else if (name.equals("is_queryable")) {
          throw new FHIRException("Cannot call addChild on a singleton property EHR_STATUS.is_queryable");
        }
        else if (name.equals("is_modifiable")) {
          throw new FHIRException("Cannot call addChild on a singleton property EHR_STATUS.is_modifiable");
        }
        else if (name.equals("other_details")) {
          throw new FHIRException("Cannot call addChild on an abstract type EHR_STATUS.other_details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EHR_STATUS";

  }

      public EHR_STATUS copy() {
        EHR_STATUS dst = new EHR_STATUS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EHR_STATUS dst) {
        super.copyValues(dst);
        dst.subject = subject == null ? null : subject.copy();
        dst.is_queryable = is_queryable == null ? null : is_queryable.copy();
        dst.is_modifiable = is_modifiable == null ? null : is_modifiable.copy();
        dst.other_details = other_details == null ? null : other_details.copy();
      }

      protected EHR_STATUS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EHR_STATUS))
          return false;
        EHR_STATUS o = (EHR_STATUS) other_;
        return compareDeep(subject, o.subject, true) && compareDeep(is_queryable, o.is_queryable, true)
           && compareDeep(is_modifiable, o.is_modifiable, true) && compareDeep(other_details, o.other_details, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EHR_STATUS))
          return false;
        EHR_STATUS o = (EHR_STATUS) other_;
        return compareValues(is_queryable, o.is_queryable, true) && compareValues(is_modifiable, o.is_modifiable, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(subject, is_queryable, is_modifiable
          , other_details);
      }


}

