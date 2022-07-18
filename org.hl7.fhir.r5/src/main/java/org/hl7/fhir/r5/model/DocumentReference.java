package org.hl7.fhir.r5.model;


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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this "document" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
 */
@ResourceDef(name="DocumentReference", profile="http://hl7.org/fhir/StructureDefinition/DocumentReference")
public class DocumentReference extends DomainResource {

    @Block()
    public static class DocumentReferenceAttesterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of attestation the authenticator offers.
         */
        @Child(name = "mode", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="personal | professional | legal | official", formalDefinition="The type of attestation the authenticator offers." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/composition-attestation-mode")
        protected CodeableConcept mode;

        /**
         * When the document was attested by the party.
         */
        @Child(name = "time", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the document was attested", formalDefinition="When the document was attested by the party." )
        protected DateTimeType time;

        /**
         * Who attested the document in the specified way.
         */
        @Child(name = "party", type = {Patient.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class, Organization.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who attested the document", formalDefinition="Who attested the document in the specified way." )
        protected Reference party;

        private static final long serialVersionUID = 545132751L;

    /**
     * Constructor
     */
      public DocumentReferenceAttesterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceAttesterComponent(CodeableConcept mode) {
        super();
        this.setMode(mode);
      }

        /**
         * @return {@link #mode} (The type of attestation the authenticator offers.)
         */
        public CodeableConcept getMode() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceAttesterComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new CodeableConcept(); // cc
          return this.mode;
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (The type of attestation the authenticator offers.)
         */
        public DocumentReferenceAttesterComponent setMode(CodeableConcept value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return {@link #time} (When the document was attested by the party.). This is the underlying object with id, value and extensions. The accessor "getTime" gives direct access to the value
         */
        public DateTimeType getTimeElement() { 
          if (this.time == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceAttesterComponent.time");
            else if (Configuration.doAutoCreate())
              this.time = new DateTimeType(); // bb
          return this.time;
        }

        public boolean hasTimeElement() { 
          return this.time != null && !this.time.isEmpty();
        }

        public boolean hasTime() { 
          return this.time != null && !this.time.isEmpty();
        }

        /**
         * @param value {@link #time} (When the document was attested by the party.). This is the underlying object with id, value and extensions. The accessor "getTime" gives direct access to the value
         */
        public DocumentReferenceAttesterComponent setTimeElement(DateTimeType value) { 
          this.time = value;
          return this;
        }

        /**
         * @return When the document was attested by the party.
         */
        public Date getTime() { 
          return this.time == null ? null : this.time.getValue();
        }

        /**
         * @param value When the document was attested by the party.
         */
        public DocumentReferenceAttesterComponent setTime(Date value) { 
          if (value == null)
            this.time = null;
          else {
            if (this.time == null)
              this.time = new DateTimeType();
            this.time.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #party} (Who attested the document in the specified way.)
         */
        public Reference getParty() { 
          if (this.party == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceAttesterComponent.party");
            else if (Configuration.doAutoCreate())
              this.party = new Reference(); // cc
          return this.party;
        }

        public boolean hasParty() { 
          return this.party != null && !this.party.isEmpty();
        }

        /**
         * @param value {@link #party} (Who attested the document in the specified way.)
         */
        public DocumentReferenceAttesterComponent setParty(Reference value) { 
          this.party = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "CodeableConcept", "The type of attestation the authenticator offers.", 0, 1, mode));
          children.add(new Property("time", "dateTime", "When the document was attested by the party.", 0, 1, time));
          children.add(new Property("party", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Who attested the document in the specified way.", 0, 1, party));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "CodeableConcept", "The type of attestation the authenticator offers.", 0, 1, mode);
          case 3560141: /*time*/  return new Property("time", "dateTime", "When the document was attested by the party.", 0, 1, time);
          case 106437350: /*party*/  return new Property("party", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Who attested the document in the specified way.", 0, 1, party);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // CodeableConcept
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DateTimeType
        case 106437350: /*party*/ return this.party == null ? new Base[0] : new Base[] {this.party}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          this.mode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3560141: // time
          this.time = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 106437350: // party
          this.party = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          this.mode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("time")) {
          this.time = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("party")) {
          this.party = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getMode();
        case 3560141:  return getTimeElement();
        case 106437350:  return getParty();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"CodeableConcept"};
        case 3560141: /*time*/ return new String[] {"dateTime"};
        case 106437350: /*party*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          this.mode = new CodeableConcept();
          return this.mode;
        }
        else if (name.equals("time")) {
          throw new FHIRException("Cannot call addChild on a primitive type DocumentReference.attester.time");
        }
        else if (name.equals("party")) {
          this.party = new Reference();
          return this.party;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceAttesterComponent copy() {
        DocumentReferenceAttesterComponent dst = new DocumentReferenceAttesterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DocumentReferenceAttesterComponent dst) {
        super.copyValues(dst);
        dst.mode = mode == null ? null : mode.copy();
        dst.time = time == null ? null : time.copy();
        dst.party = party == null ? null : party.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceAttesterComponent))
          return false;
        DocumentReferenceAttesterComponent o = (DocumentReferenceAttesterComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(time, o.time, true) && compareDeep(party, o.party, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceAttesterComponent))
          return false;
        DocumentReferenceAttesterComponent o = (DocumentReferenceAttesterComponent) other_;
        return compareValues(time, o.time, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, time, party);
      }

  public String fhirType() {
    return "DocumentReference.attester";

  }

  }

    @Block()
    public static class DocumentReferenceRelatesToComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship that this document has with anther document.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The relationship type with another document", formalDefinition="The type of relationship that this document has with anther document." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-relationship-type")
        protected CodeableConcept code;

        /**
         * The target document of this relationship.
         */
        @Child(name = "target", type = {DocumentReference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Target of the relationship", formalDefinition="The target document of this relationship." )
        protected Reference target;

        private static final long serialVersionUID = -372012026L;

    /**
     * Constructor
     */
      public DocumentReferenceRelatesToComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceRelatesToComponent(CodeableConcept code, Reference target) {
        super();
        this.setCode(code);
        this.setTarget(target);
      }

        /**
         * @return {@link #code} (The type of relationship that this document has with anther document.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceRelatesToComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The type of relationship that this document has with anther document.)
         */
        public DocumentReferenceRelatesToComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #target} (The target document of this relationship.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceRelatesToComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (The target document of this relationship.)
         */
        public DocumentReferenceRelatesToComponent setTarget(Reference value) { 
          this.target = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "The type of relationship that this document has with anther document.", 0, 1, code));
          children.add(new Property("target", "Reference(DocumentReference)", "The target document of this relationship.", 0, 1, target));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The type of relationship that this document has with anther document.", 0, 1, code);
          case -880905839: /*target*/  return new Property("target", "Reference(DocumentReference)", "The target document of this relationship.", 0, 1, target);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -880905839: // target
          this.target = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("target")) {
          this.target = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -880905839:  return getTarget();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -880905839: /*target*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceRelatesToComponent copy() {
        DocumentReferenceRelatesToComponent dst = new DocumentReferenceRelatesToComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DocumentReferenceRelatesToComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.target = target == null ? null : target.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceRelatesToComponent))
          return false;
        DocumentReferenceRelatesToComponent o = (DocumentReferenceRelatesToComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(target, o.target, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceRelatesToComponent))
          return false;
        DocumentReferenceRelatesToComponent o = (DocumentReferenceRelatesToComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, target);
      }

  public String fhirType() {
    return "DocumentReference.relatesTo";

  }

  }

    @Block()
    public static class DocumentReferenceContentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The document or URL of the document along with critical metadata to prove content has integrity.
         */
        @Child(name = "attachment", type = {Attachment.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Where to access the document", formalDefinition="The document or URL of the document along with critical metadata to prove content has integrity." )
        protected Attachment attachment;

        /**
         * An identifier of the document constraints, encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.
         */
        @Child(name = "profile", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Content profile rules for the document", formalDefinition="An identifier of the document constraints, encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType." )
        protected List<DocumentReferenceContentProfileComponent> profile;

        private static final long serialVersionUID = 174089424L;

    /**
     * Constructor
     */
      public DocumentReferenceContentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceContentComponent(Attachment attachment) {
        super();
        this.setAttachment(attachment);
      }

        /**
         * @return {@link #attachment} (The document or URL of the document along with critical metadata to prove content has integrity.)
         */
        public Attachment getAttachment() { 
          if (this.attachment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContentComponent.attachment");
            else if (Configuration.doAutoCreate())
              this.attachment = new Attachment(); // cc
          return this.attachment;
        }

        public boolean hasAttachment() { 
          return this.attachment != null && !this.attachment.isEmpty();
        }

        /**
         * @param value {@link #attachment} (The document or URL of the document along with critical metadata to prove content has integrity.)
         */
        public DocumentReferenceContentComponent setAttachment(Attachment value) { 
          this.attachment = value;
          return this;
        }

        /**
         * @return {@link #profile} (An identifier of the document constraints, encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.)
         */
        public List<DocumentReferenceContentProfileComponent> getProfile() { 
          if (this.profile == null)
            this.profile = new ArrayList<DocumentReferenceContentProfileComponent>();
          return this.profile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DocumentReferenceContentComponent setProfile(List<DocumentReferenceContentProfileComponent> theProfile) { 
          this.profile = theProfile;
          return this;
        }

        public boolean hasProfile() { 
          if (this.profile == null)
            return false;
          for (DocumentReferenceContentProfileComponent item : this.profile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public DocumentReferenceContentProfileComponent addProfile() { //3
          DocumentReferenceContentProfileComponent t = new DocumentReferenceContentProfileComponent();
          if (this.profile == null)
            this.profile = new ArrayList<DocumentReferenceContentProfileComponent>();
          this.profile.add(t);
          return t;
        }

        public DocumentReferenceContentComponent addProfile(DocumentReferenceContentProfileComponent t) { //3
          if (t == null)
            return this;
          if (this.profile == null)
            this.profile = new ArrayList<DocumentReferenceContentProfileComponent>();
          this.profile.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #profile}, creating it if it does not already exist {3}
         */
        public DocumentReferenceContentProfileComponent getProfileFirstRep() { 
          if (getProfile().isEmpty()) {
            addProfile();
          }
          return getProfile().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("attachment", "Attachment", "The document or URL of the document along with critical metadata to prove content has integrity.", 0, 1, attachment));
          children.add(new Property("profile", "", "An identifier of the document constraints, encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.", 0, java.lang.Integer.MAX_VALUE, profile));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1963501277: /*attachment*/  return new Property("attachment", "Attachment", "The document or URL of the document along with critical metadata to prove content has integrity.", 0, 1, attachment);
          case -309425751: /*profile*/  return new Property("profile", "", "An identifier of the document constraints, encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.", 0, java.lang.Integer.MAX_VALUE, profile);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1963501277: /*attachment*/ return this.attachment == null ? new Base[0] : new Base[] {this.attachment}; // Attachment
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : this.profile.toArray(new Base[this.profile.size()]); // DocumentReferenceContentProfileComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1963501277: // attachment
          this.attachment = TypeConvertor.castToAttachment(value); // Attachment
          return value;
        case -309425751: // profile
          this.getProfile().add((DocumentReferenceContentProfileComponent) value); // DocumentReferenceContentProfileComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("attachment")) {
          this.attachment = TypeConvertor.castToAttachment(value); // Attachment
        } else if (name.equals("profile")) {
          this.getProfile().add((DocumentReferenceContentProfileComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1963501277:  return getAttachment();
        case -309425751:  return addProfile(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1963501277: /*attachment*/ return new String[] {"Attachment"};
        case -309425751: /*profile*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("attachment")) {
          this.attachment = new Attachment();
          return this.attachment;
        }
        else if (name.equals("profile")) {
          return addProfile();
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceContentComponent copy() {
        DocumentReferenceContentComponent dst = new DocumentReferenceContentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DocumentReferenceContentComponent dst) {
        super.copyValues(dst);
        dst.attachment = attachment == null ? null : attachment.copy();
        if (profile != null) {
          dst.profile = new ArrayList<DocumentReferenceContentProfileComponent>();
          for (DocumentReferenceContentProfileComponent i : profile)
            dst.profile.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentComponent))
          return false;
        DocumentReferenceContentComponent o = (DocumentReferenceContentComponent) other_;
        return compareDeep(attachment, o.attachment, true) && compareDeep(profile, o.profile, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentComponent))
          return false;
        DocumentReferenceContentComponent o = (DocumentReferenceContentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(attachment, profile);
      }

  public String fhirType() {
    return "DocumentReference.content";

  }

  }

    @Block()
    public static class DocumentReferenceContentProfileComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code|uri|canonical.
         */
        @Child(name = "value", type = {Coding.class, UriType.class, CanonicalType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Code|uri|canonical", formalDefinition="Code|uri|canonical." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/formatcodes")
        protected DataType value;

        private static final long serialVersionUID = -1135414639L;

    /**
     * Constructor
     */
      public DocumentReferenceContentProfileComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceContentProfileComponent(DataType value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (Code|uri|canonical.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Code|uri|canonical.)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() { 
          return this != null && this.value instanceof Coding;
        }

        /**
         * @return {@link #value} (Code|uri|canonical.)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() { 
          return this != null && this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (Code|uri|canonical.)
         */
        public CanonicalType getValueCanonicalType() throws FHIRException { 
          if (this.value == null)
            this.value = new CanonicalType();
          if (!(this.value instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CanonicalType) this.value;
        }

        public boolean hasValueCanonicalType() { 
          return this != null && this.value instanceof CanonicalType;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Code|uri|canonical.)
         */
        public DocumentReferenceContentProfileComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Coding || value instanceof UriType || value instanceof CanonicalType))
            throw new Error("Not the right type for DocumentReference.content.profile.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "Coding|uri|canonical", "Code|uri|canonical.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Coding|uri|canonical", "Code|uri|canonical.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Coding|uri|canonical", "Code|uri|canonical.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "Code|uri|canonical.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "Code|uri|canonical.", 0, 1, value);
          case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "Code|uri|canonical.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"Coding", "uri", "canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueCanonical")) {
          this.value = new CanonicalType();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceContentProfileComponent copy() {
        DocumentReferenceContentProfileComponent dst = new DocumentReferenceContentProfileComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DocumentReferenceContentProfileComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentProfileComponent))
          return false;
        DocumentReferenceContentProfileComponent o = (DocumentReferenceContentProfileComponent) other_;
        return compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentProfileComponent))
          return false;
        DocumentReferenceContentProfileComponent o = (DocumentReferenceContentProfileComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value);
      }

  public String fhirType() {
    return "DocumentReference.content.profile";

  }

  }

    /**
     * Other business identifiers associated with the document, including version independent identifiers.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifiers for the document", formalDefinition="Other business identifiers associated with the document, including version independent identifiers." )
    protected List<Identifier> identifier;

    /**
     * A procedure that is fulfilled in whole or in part by the creation of this media.
     */
    @Child(name = "basedOn", type = {Appointment.class, AppointmentResponse.class, CarePlan.class, Claim.class, CommunicationRequest.class, Contract.class, CoverageEligibilityRequest.class, DeviceRequest.class, EnrollmentRequest.class, EpisodeOfCare.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, RequestGroup.class, ServiceRequest.class, SupplyRequest.class, VisionPrescription.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Procedure that caused this media to be created", formalDefinition="A procedure that is fulfilled in whole or in part by the creation of this media." )
    protected List<Reference> basedOn;

    /**
     * The status of this document reference.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="current | superseded | entered-in-error", formalDefinition="The status of this document reference." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-reference-status")
    protected Enumeration<DocumentReferenceStatus> status;

    /**
     * The status of the underlying document.
     */
    @Child(name = "docStatus", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="preliminary | final | amended | entered-in-error | deprecated", formalDefinition="The status of the underlying document." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/composition-status")
    protected Enumeration<CompositionStatus> docStatus;

    /**
     * Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of document (LOINC if possible)", formalDefinition="Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/doc-typecodes")
    protected CodeableConcept type;

    /**
     * A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Categorization of document", formalDefinition="A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referenced-item-category")
    protected List<CodeableConcept> category;

    /**
     * Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).
     */
    @Child(name = "subject", type = {Reference.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what is the subject of the document", formalDefinition="Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure)." )
    protected Reference subject;

    /**
     * Describes the clinical encounter or type of care that the document content is associated with.
     */
    @Child(name = "context", type = {Appointment.class, Encounter.class, EpisodeOfCare.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Context of the document content", formalDefinition="Describes the clinical encounter or type of care that the document content is associated with." )
    protected List<Reference> context;

    /**
     * This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.
     */
    @Child(name = "event", type = {CodeableReference.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Main clinical acts documented", formalDefinition="This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActCode")
    protected List<CodeableReference> event;

    /**
     * The kind of facility where the patient was seen.
     */
    @Child(name = "facilityType", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Kind of facility where patient was seen", formalDefinition="The kind of facility where the patient was seen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-facilitycodes")
    protected CodeableConcept facilityType;

    /**
     * This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.
     */
    @Child(name = "practiceSetting", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional details about where the content was created (e.g. clinical specialty)", formalDefinition="This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected CodeableConcept practiceSetting;

    /**
     * The time period over which the service that is described by the document was provided.
     */
    @Child(name = "period", type = {Period.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time of service that is being documented", formalDefinition="The time period over which the service that is described by the document was provided." )
    protected Period period;

    /**
     * When the document reference was created.
     */
    @Child(name = "date", type = {InstantType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When this document reference was created", formalDefinition="When the document reference was created." )
    protected InstantType date;

    /**
     * Identifies who is responsible for adding the information to the document.
     */
    @Child(name = "author", type = {Practitioner.class, PractitionerRole.class, Organization.class, Device.class, Patient.class, RelatedPerson.class, CareTeam.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who and/or what authored the document", formalDefinition="Identifies who is responsible for adding the information to the document." )
    protected List<Reference> author;

    /**
     * A participant who has authenticated the accuracy of the document.
     */
    @Child(name = "attester", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Attests to accuracy of the document", formalDefinition="A participant who has authenticated the accuracy of the document." )
    protected List<DocumentReferenceAttesterComponent> attester;

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.
     */
    @Child(name = "custodian", type = {Organization.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization which maintains the document", formalDefinition="Identifies the organization or group who is responsible for ongoing maintenance of and access to the document." )
    protected Reference custodian;

    /**
     * Relationships that this document has with other document references that already exist.
     */
    @Child(name = "relatesTo", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Relationships to other documents", formalDefinition="Relationships that this document has with other document references that already exist." )
    protected List<DocumentReferenceRelatesToComponent> relatesTo;

    /**
     * Human-readable description of the source document.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable description", formalDefinition="Human-readable description of the source document." )
    protected MarkdownType description;

    /**
     * A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened.
     */
    @Child(name = "securityLabel", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document security-tags", formalDefinition="A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-examples")
    protected List<CodeableConcept> securityLabel;

    /**
     * The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata.
     */
    @Child(name = "content", type = {}, order=19, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document referenced", formalDefinition="The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata." )
    protected List<DocumentReferenceContentComponent> content;

    /**
     * The Patient Information as known when the document was published. May be a reference to a version specific, or contained.
     */
    @Child(name = "sourcePatientInfo", type = {Patient.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Patient demographics from source", formalDefinition="The Patient Information as known when the document was published. May be a reference to a version specific, or contained." )
    protected Reference sourcePatientInfo;

    private static final long serialVersionUID = -466177068L;

  /**
   * Constructor
   */
    public DocumentReference() {
      super();
    }

  /**
   * Constructor
   */
    public DocumentReference(DocumentReferenceStatus status, DocumentReferenceContentComponent content) {
      super();
      this.setStatus(status);
      this.addContent(content);
    }

    /**
     * @return {@link #identifier} (Other business identifiers associated with the document, including version independent identifiers.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public DocumentReference addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #basedOn} (A procedure that is fulfilled in whole or in part by the creation of this media.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public DocumentReference addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #status} (The status of this document reference.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<DocumentReferenceStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<DocumentReferenceStatus>(new DocumentReferenceStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this document reference.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DocumentReference setStatusElement(Enumeration<DocumentReferenceStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this document reference.
     */
    public DocumentReferenceStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this document reference.
     */
    public DocumentReference setStatus(DocumentReferenceStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<DocumentReferenceStatus>(new DocumentReferenceStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #docStatus} (The status of the underlying document.). This is the underlying object with id, value and extensions. The accessor "getDocStatus" gives direct access to the value
     */
    public Enumeration<CompositionStatus> getDocStatusElement() { 
      if (this.docStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.docStatus");
        else if (Configuration.doAutoCreate())
          this.docStatus = new Enumeration<CompositionStatus>(new CompositionStatusEnumFactory()); // bb
      return this.docStatus;
    }

    public boolean hasDocStatusElement() { 
      return this.docStatus != null && !this.docStatus.isEmpty();
    }

    public boolean hasDocStatus() { 
      return this.docStatus != null && !this.docStatus.isEmpty();
    }

    /**
     * @param value {@link #docStatus} (The status of the underlying document.). This is the underlying object with id, value and extensions. The accessor "getDocStatus" gives direct access to the value
     */
    public DocumentReference setDocStatusElement(Enumeration<CompositionStatus> value) { 
      this.docStatus = value;
      return this;
    }

    /**
     * @return The status of the underlying document.
     */
    public CompositionStatus getDocStatus() { 
      return this.docStatus == null ? null : this.docStatus.getValue();
    }

    /**
     * @param value The status of the underlying document.
     */
    public DocumentReference setDocStatus(CompositionStatus value) { 
      if (value == null)
        this.docStatus = null;
      else {
        if (this.docStatus == null)
          this.docStatus = new Enumeration<CompositionStatus>(new CompositionStatusEnumFactory());
        this.docStatus.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.)
     */
    public DocumentReference setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #category} (A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public DocumentReference addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #subject} (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public DocumentReference setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #context} (Describes the clinical encounter or type of care that the document content is associated with.)
     */
    public List<Reference> getContext() { 
      if (this.context == null)
        this.context = new ArrayList<Reference>();
      return this.context;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setContext(List<Reference> theContext) { 
      this.context = theContext;
      return this;
    }

    public boolean hasContext() { 
      if (this.context == null)
        return false;
      for (Reference item : this.context)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addContext() { //3
      Reference t = new Reference();
      if (this.context == null)
        this.context = new ArrayList<Reference>();
      this.context.add(t);
      return t;
    }

    public DocumentReference addContext(Reference t) { //3
      if (t == null)
        return this;
      if (this.context == null)
        this.context = new ArrayList<Reference>();
      this.context.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #context}, creating it if it does not already exist {3}
     */
    public Reference getContextFirstRep() { 
      if (getContext().isEmpty()) {
        addContext();
      }
      return getContext().get(0);
    }

    /**
     * @return {@link #event} (This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.)
     */
    public List<CodeableReference> getEvent() { 
      if (this.event == null)
        this.event = new ArrayList<CodeableReference>();
      return this.event;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setEvent(List<CodeableReference> theEvent) { 
      this.event = theEvent;
      return this;
    }

    public boolean hasEvent() { 
      if (this.event == null)
        return false;
      for (CodeableReference item : this.event)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addEvent() { //3
      CodeableReference t = new CodeableReference();
      if (this.event == null)
        this.event = new ArrayList<CodeableReference>();
      this.event.add(t);
      return t;
    }

    public DocumentReference addEvent(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.event == null)
        this.event = new ArrayList<CodeableReference>();
      this.event.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #event}, creating it if it does not already exist {3}
     */
    public CodeableReference getEventFirstRep() { 
      if (getEvent().isEmpty()) {
        addEvent();
      }
      return getEvent().get(0);
    }

    /**
     * @return {@link #facilityType} (The kind of facility where the patient was seen.)
     */
    public CodeableConcept getFacilityType() { 
      if (this.facilityType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.facilityType");
        else if (Configuration.doAutoCreate())
          this.facilityType = new CodeableConcept(); // cc
      return this.facilityType;
    }

    public boolean hasFacilityType() { 
      return this.facilityType != null && !this.facilityType.isEmpty();
    }

    /**
     * @param value {@link #facilityType} (The kind of facility where the patient was seen.)
     */
    public DocumentReference setFacilityType(CodeableConcept value) { 
      this.facilityType = value;
      return this;
    }

    /**
     * @return {@link #practiceSetting} (This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.)
     */
    public CodeableConcept getPracticeSetting() { 
      if (this.practiceSetting == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.practiceSetting");
        else if (Configuration.doAutoCreate())
          this.practiceSetting = new CodeableConcept(); // cc
      return this.practiceSetting;
    }

    public boolean hasPracticeSetting() { 
      return this.practiceSetting != null && !this.practiceSetting.isEmpty();
    }

    /**
     * @param value {@link #practiceSetting} (This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.)
     */
    public DocumentReference setPracticeSetting(CodeableConcept value) { 
      this.practiceSetting = value;
      return this;
    }

    /**
     * @return {@link #period} (The time period over which the service that is described by the document was provided.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The time period over which the service that is described by the document was provided.)
     */
    public DocumentReference setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #date} (When the document reference was created.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public InstantType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.date");
        else if (Configuration.doAutoCreate())
          this.date = new InstantType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (When the document reference was created.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DocumentReference setDateElement(InstantType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return When the document reference was created.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value When the document reference was created.
     */
    public DocumentReference setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new InstantType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #author} (Identifies who is responsible for adding the information to the document.)
     */
    public List<Reference> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setAuthor(List<Reference> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (Reference item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAuthor() { //3
      Reference t = new Reference();
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      this.author.add(t);
      return t;
    }

    public DocumentReference addAuthor(Reference t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public Reference getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #attester} (A participant who has authenticated the accuracy of the document.)
     */
    public List<DocumentReferenceAttesterComponent> getAttester() { 
      if (this.attester == null)
        this.attester = new ArrayList<DocumentReferenceAttesterComponent>();
      return this.attester;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setAttester(List<DocumentReferenceAttesterComponent> theAttester) { 
      this.attester = theAttester;
      return this;
    }

    public boolean hasAttester() { 
      if (this.attester == null)
        return false;
      for (DocumentReferenceAttesterComponent item : this.attester)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DocumentReferenceAttesterComponent addAttester() { //3
      DocumentReferenceAttesterComponent t = new DocumentReferenceAttesterComponent();
      if (this.attester == null)
        this.attester = new ArrayList<DocumentReferenceAttesterComponent>();
      this.attester.add(t);
      return t;
    }

    public DocumentReference addAttester(DocumentReferenceAttesterComponent t) { //3
      if (t == null)
        return this;
      if (this.attester == null)
        this.attester = new ArrayList<DocumentReferenceAttesterComponent>();
      this.attester.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #attester}, creating it if it does not already exist {3}
     */
    public DocumentReferenceAttesterComponent getAttesterFirstRep() { 
      if (getAttester().isEmpty()) {
        addAttester();
      }
      return getAttester().get(0);
    }

    /**
     * @return {@link #custodian} (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public Reference getCustodian() { 
      if (this.custodian == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.custodian");
        else if (Configuration.doAutoCreate())
          this.custodian = new Reference(); // cc
      return this.custodian;
    }

    public boolean hasCustodian() { 
      return this.custodian != null && !this.custodian.isEmpty();
    }

    /**
     * @param value {@link #custodian} (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public DocumentReference setCustodian(Reference value) { 
      this.custodian = value;
      return this;
    }

    /**
     * @return {@link #relatesTo} (Relationships that this document has with other document references that already exist.)
     */
    public List<DocumentReferenceRelatesToComponent> getRelatesTo() { 
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      return this.relatesTo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setRelatesTo(List<DocumentReferenceRelatesToComponent> theRelatesTo) { 
      this.relatesTo = theRelatesTo;
      return this;
    }

    public boolean hasRelatesTo() { 
      if (this.relatesTo == null)
        return false;
      for (DocumentReferenceRelatesToComponent item : this.relatesTo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DocumentReferenceRelatesToComponent addRelatesTo() { //3
      DocumentReferenceRelatesToComponent t = new DocumentReferenceRelatesToComponent();
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      this.relatesTo.add(t);
      return t;
    }

    public DocumentReference addRelatesTo(DocumentReferenceRelatesToComponent t) { //3
      if (t == null)
        return this;
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      this.relatesTo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatesTo}, creating it if it does not already exist {3}
     */
    public DocumentReferenceRelatesToComponent getRelatesToFirstRep() { 
      if (getRelatesTo().isEmpty()) {
        addRelatesTo();
      }
      return getRelatesTo().get(0);
    }

    /**
     * @return {@link #description} (Human-readable description of the source document.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Human-readable description of the source document.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public DocumentReference setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Human-readable description of the source document.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Human-readable description of the source document.
     */
    public DocumentReference setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #securityLabel} (A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened.)
     */
    public List<CodeableConcept> getSecurityLabel() { 
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      return this.securityLabel;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setSecurityLabel(List<CodeableConcept> theSecurityLabel) { 
      this.securityLabel = theSecurityLabel;
      return this;
    }

    public boolean hasSecurityLabel() { 
      if (this.securityLabel == null)
        return false;
      for (CodeableConcept item : this.securityLabel)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSecurityLabel() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      this.securityLabel.add(t);
      return t;
    }

    public DocumentReference addSecurityLabel(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      this.securityLabel.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #securityLabel}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSecurityLabelFirstRep() { 
      if (getSecurityLabel().isEmpty()) {
        addSecurityLabel();
      }
      return getSecurityLabel().get(0);
    }

    /**
     * @return {@link #content} (The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata.)
     */
    public List<DocumentReferenceContentComponent> getContent() { 
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      return this.content;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setContent(List<DocumentReferenceContentComponent> theContent) { 
      this.content = theContent;
      return this;
    }

    public boolean hasContent() { 
      if (this.content == null)
        return false;
      for (DocumentReferenceContentComponent item : this.content)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DocumentReferenceContentComponent addContent() { //3
      DocumentReferenceContentComponent t = new DocumentReferenceContentComponent();
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      this.content.add(t);
      return t;
    }

    public DocumentReference addContent(DocumentReferenceContentComponent t) { //3
      if (t == null)
        return this;
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      this.content.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #content}, creating it if it does not already exist {3}
     */
    public DocumentReferenceContentComponent getContentFirstRep() { 
      if (getContent().isEmpty()) {
        addContent();
      }
      return getContent().get(0);
    }

    /**
     * @return {@link #sourcePatientInfo} (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
     */
    public Reference getSourcePatientInfo() { 
      if (this.sourcePatientInfo == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.sourcePatientInfo");
        else if (Configuration.doAutoCreate())
          this.sourcePatientInfo = new Reference(); // cc
      return this.sourcePatientInfo;
    }

    public boolean hasSourcePatientInfo() { 
      return this.sourcePatientInfo != null && !this.sourcePatientInfo.isEmpty();
    }

    /**
     * @param value {@link #sourcePatientInfo} (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
     */
    public DocumentReference setSourcePatientInfo(Reference value) { 
      this.sourcePatientInfo = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Other business identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(Appointment|AppointmentResponse|CarePlan|Claim|CommunicationRequest|Contract|CoverageEligibilityRequest|DeviceRequest|EnrollmentRequest|EpisodeOfCare|ImmunizationRecommendation|MedicationRequest|NutritionOrder|RequestGroup|ServiceRequest|SupplyRequest|VisionPrescription)", "A procedure that is fulfilled in whole or in part by the creation of this media.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("status", "code", "The status of this document reference.", 0, 1, status));
        children.add(new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus));
        children.add(new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type));
        children.add(new Property("category", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("subject", "Reference(Any)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject));
        children.add(new Property("context", "Reference(Appointment|Encounter|EpisodeOfCare)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, java.lang.Integer.MAX_VALUE, context));
        children.add(new Property("event", "CodeableReference", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event));
        children.add(new Property("facilityType", "CodeableConcept", "The kind of facility where the patient was seen.", 0, 1, facilityType));
        children.add(new Property("practiceSetting", "CodeableConcept", "This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.", 0, 1, practiceSetting));
        children.add(new Property("period", "Period", "The time period over which the service that is described by the document was provided.", 0, 1, period));
        children.add(new Property("date", "instant", "When the document reference was created.", 0, 1, date));
        children.add(new Property("author", "Reference(Practitioner|PractitionerRole|Organization|Device|Patient|RelatedPerson|CareTeam)", "Identifies who is responsible for adding the information to the document.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("attester", "", "A participant who has authenticated the accuracy of the document.", 0, java.lang.Integer.MAX_VALUE, attester));
        children.add(new Property("custodian", "Reference(Organization)", "Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.", 0, 1, custodian));
        children.add(new Property("relatesTo", "", "Relationships that this document has with other document references that already exist.", 0, java.lang.Integer.MAX_VALUE, relatesTo));
        children.add(new Property("description", "markdown", "Human-readable description of the source document.", 0, 1, description));
        children.add(new Property("securityLabel", "CodeableConcept", "A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened.", 0, java.lang.Integer.MAX_VALUE, securityLabel));
        children.add(new Property("content", "", "The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata.", 0, java.lang.Integer.MAX_VALUE, content));
        children.add(new Property("sourcePatientInfo", "Reference(Patient)", "The Patient Information as known when the document was published. May be a reference to a version specific, or contained.", 0, 1, sourcePatientInfo));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Other business identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Appointment|AppointmentResponse|CarePlan|Claim|CommunicationRequest|Contract|CoverageEligibilityRequest|DeviceRequest|EnrollmentRequest|EpisodeOfCare|ImmunizationRecommendation|MedicationRequest|NutritionOrder|RequestGroup|ServiceRequest|SupplyRequest|VisionPrescription)", "A procedure that is fulfilled in whole or in part by the creation of this media.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this document reference.", 0, 1, status);
        case -23496886: /*docStatus*/  return new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Any)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject);
        case 951530927: /*context*/  return new Property("context", "Reference(Appointment|Encounter|EpisodeOfCare)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, java.lang.Integer.MAX_VALUE, context);
        case 96891546: /*event*/  return new Property("event", "CodeableReference", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event);
        case 370698365: /*facilityType*/  return new Property("facilityType", "CodeableConcept", "The kind of facility where the patient was seen.", 0, 1, facilityType);
        case 331373717: /*practiceSetting*/  return new Property("practiceSetting", "CodeableConcept", "This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.", 0, 1, practiceSetting);
        case -991726143: /*period*/  return new Property("period", "Period", "The time period over which the service that is described by the document was provided.", 0, 1, period);
        case 3076014: /*date*/  return new Property("date", "instant", "When the document reference was created.", 0, 1, date);
        case -1406328437: /*author*/  return new Property("author", "Reference(Practitioner|PractitionerRole|Organization|Device|Patient|RelatedPerson|CareTeam)", "Identifies who is responsible for adding the information to the document.", 0, java.lang.Integer.MAX_VALUE, author);
        case 542920370: /*attester*/  return new Property("attester", "", "A participant who has authenticated the accuracy of the document.", 0, java.lang.Integer.MAX_VALUE, attester);
        case 1611297262: /*custodian*/  return new Property("custodian", "Reference(Organization)", "Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.", 0, 1, custodian);
        case -7765931: /*relatesTo*/  return new Property("relatesTo", "", "Relationships that this document has with other document references that already exist.", 0, java.lang.Integer.MAX_VALUE, relatesTo);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Human-readable description of the source document.", 0, 1, description);
        case -722296940: /*securityLabel*/  return new Property("securityLabel", "CodeableConcept", "A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened.", 0, java.lang.Integer.MAX_VALUE, securityLabel);
        case 951530617: /*content*/  return new Property("content", "", "The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata.", 0, java.lang.Integer.MAX_VALUE, content);
        case 2031381048: /*sourcePatientInfo*/  return new Property("sourcePatientInfo", "Reference(Patient)", "The Patient Information as known when the document was published. May be a reference to a version specific, or contained.", 0, 1, sourcePatientInfo);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DocumentReferenceStatus>
        case -23496886: /*docStatus*/ return this.docStatus == null ? new Base[0] : new Base[] {this.docStatus}; // Enumeration<CompositionStatus>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 951530927: /*context*/ return this.context == null ? new Base[0] : this.context.toArray(new Base[this.context.size()]); // Reference
        case 96891546: /*event*/ return this.event == null ? new Base[0] : this.event.toArray(new Base[this.event.size()]); // CodeableReference
        case 370698365: /*facilityType*/ return this.facilityType == null ? new Base[0] : new Base[] {this.facilityType}; // CodeableConcept
        case 331373717: /*practiceSetting*/ return this.practiceSetting == null ? new Base[0] : new Base[] {this.practiceSetting}; // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // InstantType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // Reference
        case 542920370: /*attester*/ return this.attester == null ? new Base[0] : this.attester.toArray(new Base[this.attester.size()]); // DocumentReferenceAttesterComponent
        case 1611297262: /*custodian*/ return this.custodian == null ? new Base[0] : new Base[] {this.custodian}; // Reference
        case -7765931: /*relatesTo*/ return this.relatesTo == null ? new Base[0] : this.relatesTo.toArray(new Base[this.relatesTo.size()]); // DocumentReferenceRelatesToComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -722296940: /*securityLabel*/ return this.securityLabel == null ? new Base[0] : this.securityLabel.toArray(new Base[this.securityLabel.size()]); // CodeableConcept
        case 951530617: /*content*/ return this.content == null ? new Base[0] : this.content.toArray(new Base[this.content.size()]); // DocumentReferenceContentComponent
        case 2031381048: /*sourcePatientInfo*/ return this.sourcePatientInfo == null ? new Base[0] : new Base[] {this.sourcePatientInfo}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new DocumentReferenceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
          return value;
        case -23496886: // docStatus
          value = new CompositionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<CompositionStatus>
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 951530927: // context
          this.getContext().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 96891546: // event
          this.getEvent().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 370698365: // facilityType
          this.facilityType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 331373717: // practiceSetting
          this.practiceSetting = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case -1406328437: // author
          this.getAuthor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 542920370: // attester
          this.getAttester().add((DocumentReferenceAttesterComponent) value); // DocumentReferenceAttesterComponent
          return value;
        case 1611297262: // custodian
          this.custodian = TypeConvertor.castToReference(value); // Reference
          return value;
        case -7765931: // relatesTo
          this.getRelatesTo().add((DocumentReferenceRelatesToComponent) value); // DocumentReferenceRelatesToComponent
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -722296940: // securityLabel
          this.getSecurityLabel().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 951530617: // content
          this.getContent().add((DocumentReferenceContentComponent) value); // DocumentReferenceContentComponent
          return value;
        case 2031381048: // sourcePatientInfo
          this.sourcePatientInfo = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new DocumentReferenceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
        } else if (name.equals("docStatus")) {
          value = new CompositionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<CompositionStatus>
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("context")) {
          this.getContext().add(TypeConvertor.castToReference(value));
        } else if (name.equals("event")) {
          this.getEvent().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("facilityType")) {
          this.facilityType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("practiceSetting")) {
          this.practiceSetting = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("attester")) {
          this.getAttester().add((DocumentReferenceAttesterComponent) value);
        } else if (name.equals("custodian")) {
          this.custodian = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("relatesTo")) {
          this.getRelatesTo().add((DocumentReferenceRelatesToComponent) value);
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("content")) {
          this.getContent().add((DocumentReferenceContentComponent) value);
        } else if (name.equals("sourcePatientInfo")) {
          this.sourcePatientInfo = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -892481550:  return getStatusElement();
        case -23496886:  return getDocStatusElement();
        case 3575610:  return getType();
        case 50511102:  return addCategory(); 
        case -1867885268:  return getSubject();
        case 951530927:  return addContext(); 
        case 96891546:  return addEvent(); 
        case 370698365:  return getFacilityType();
        case 331373717:  return getPracticeSetting();
        case -991726143:  return getPeriod();
        case 3076014:  return getDateElement();
        case -1406328437:  return addAuthor(); 
        case 542920370:  return addAttester(); 
        case 1611297262:  return getCustodian();
        case -7765931:  return addRelatesTo(); 
        case -1724546052:  return getDescriptionElement();
        case -722296940:  return addSecurityLabel(); 
        case 951530617:  return addContent(); 
        case 2031381048:  return getSourcePatientInfo();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -23496886: /*docStatus*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 951530927: /*context*/ return new String[] {"Reference"};
        case 96891546: /*event*/ return new String[] {"CodeableReference"};
        case 370698365: /*facilityType*/ return new String[] {"CodeableConcept"};
        case 331373717: /*practiceSetting*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 3076014: /*date*/ return new String[] {"instant"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case 542920370: /*attester*/ return new String[] {};
        case 1611297262: /*custodian*/ return new String[] {"Reference"};
        case -7765931: /*relatesTo*/ return new String[] {};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -722296940: /*securityLabel*/ return new String[] {"CodeableConcept"};
        case 951530617: /*content*/ return new String[] {};
        case 2031381048: /*sourcePatientInfo*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type DocumentReference.status");
        }
        else if (name.equals("docStatus")) {
          throw new FHIRException("Cannot call addChild on a primitive type DocumentReference.docStatus");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("context")) {
          return addContext();
        }
        else if (name.equals("event")) {
          return addEvent();
        }
        else if (name.equals("facilityType")) {
          this.facilityType = new CodeableConcept();
          return this.facilityType;
        }
        else if (name.equals("practiceSetting")) {
          this.practiceSetting = new CodeableConcept();
          return this.practiceSetting;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type DocumentReference.date");
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("attester")) {
          return addAttester();
        }
        else if (name.equals("custodian")) {
          this.custodian = new Reference();
          return this.custodian;
        }
        else if (name.equals("relatesTo")) {
          return addRelatesTo();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type DocumentReference.description");
        }
        else if (name.equals("securityLabel")) {
          return addSecurityLabel();
        }
        else if (name.equals("content")) {
          return addContent();
        }
        else if (name.equals("sourcePatientInfo")) {
          this.sourcePatientInfo = new Reference();
          return this.sourcePatientInfo;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DocumentReference";

  }

      public DocumentReference copy() {
        DocumentReference dst = new DocumentReference();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DocumentReference dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.docStatus = docStatus == null ? null : docStatus.copy();
        dst.type = type == null ? null : type.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        if (context != null) {
          dst.context = new ArrayList<Reference>();
          for (Reference i : context)
            dst.context.add(i.copy());
        };
        if (event != null) {
          dst.event = new ArrayList<CodeableReference>();
          for (CodeableReference i : event)
            dst.event.add(i.copy());
        };
        dst.facilityType = facilityType == null ? null : facilityType.copy();
        dst.practiceSetting = practiceSetting == null ? null : practiceSetting.copy();
        dst.period = period == null ? null : period.copy();
        dst.date = date == null ? null : date.copy();
        if (author != null) {
          dst.author = new ArrayList<Reference>();
          for (Reference i : author)
            dst.author.add(i.copy());
        };
        if (attester != null) {
          dst.attester = new ArrayList<DocumentReferenceAttesterComponent>();
          for (DocumentReferenceAttesterComponent i : attester)
            dst.attester.add(i.copy());
        };
        dst.custodian = custodian == null ? null : custodian.copy();
        if (relatesTo != null) {
          dst.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
          for (DocumentReferenceRelatesToComponent i : relatesTo)
            dst.relatesTo.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (securityLabel != null) {
          dst.securityLabel = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : securityLabel)
            dst.securityLabel.add(i.copy());
        };
        if (content != null) {
          dst.content = new ArrayList<DocumentReferenceContentComponent>();
          for (DocumentReferenceContentComponent i : content)
            dst.content.add(i.copy());
        };
        dst.sourcePatientInfo = sourcePatientInfo == null ? null : sourcePatientInfo.copy();
      }

      protected DocumentReference typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReference))
          return false;
        DocumentReference o = (DocumentReference) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(status, o.status, true)
           && compareDeep(docStatus, o.docStatus, true) && compareDeep(type, o.type, true) && compareDeep(category, o.category, true)
           && compareDeep(subject, o.subject, true) && compareDeep(context, o.context, true) && compareDeep(event, o.event, true)
           && compareDeep(facilityType, o.facilityType, true) && compareDeep(practiceSetting, o.practiceSetting, true)
           && compareDeep(period, o.period, true) && compareDeep(date, o.date, true) && compareDeep(author, o.author, true)
           && compareDeep(attester, o.attester, true) && compareDeep(custodian, o.custodian, true) && compareDeep(relatesTo, o.relatesTo, true)
           && compareDeep(description, o.description, true) && compareDeep(securityLabel, o.securityLabel, true)
           && compareDeep(content, o.content, true) && compareDeep(sourcePatientInfo, o.sourcePatientInfo, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReference))
          return false;
        DocumentReference o = (DocumentReference) other_;
        return compareValues(status, o.status, true) && compareValues(docStatus, o.docStatus, true) && compareValues(date, o.date, true)
           && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, status
          , docStatus, type, category, subject, context, event, facilityType, practiceSetting
          , period, date, author, attester, custodian, relatesTo, description, securityLabel
          , content, sourcePatientInfo);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DocumentReference;
   }


}

