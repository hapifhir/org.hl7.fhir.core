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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

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
 * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this “document” encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
 */
@ResourceDef(name="DocumentReference", profile="http://hl7.org/fhir/StructureDefinition/DocumentReference")
public class DocumentReference extends DomainResource {

    public enum DocumentReferenceStatus {
        /**
         * This is the current reference for this document.
         */
        CURRENT, 
        /**
         * This reference has been superseded by another reference.
         */
        SUPERSEDED, 
        /**
         * This reference was created in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DocumentReferenceStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("current".equals(codeString))
          return CURRENT;
        if ("superseded".equals(codeString))
          return SUPERSEDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CURRENT: return "current";
            case SUPERSEDED: return "superseded";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CURRENT: return "http://hl7.org/fhir/document-reference-status";
            case SUPERSEDED: return "http://hl7.org/fhir/document-reference-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/document-reference-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CURRENT: return "This is the current reference for this document.";
            case SUPERSEDED: return "This reference has been superseded by another reference.";
            case ENTEREDINERROR: return "This reference was created in error.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CURRENT: return "Current";
            case SUPERSEDED: return "Superseded";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DocumentReferenceStatusEnumFactory implements EnumFactory<DocumentReferenceStatus> {
    public DocumentReferenceStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("current".equals(codeString))
          return DocumentReferenceStatus.CURRENT;
        if ("superseded".equals(codeString))
          return DocumentReferenceStatus.SUPERSEDED;
        if ("entered-in-error".equals(codeString))
          return DocumentReferenceStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
        public Enumeration<DocumentReferenceStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.NULL, code);
        if ("current".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.CURRENT, code);
        if ("superseded".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.SUPERSEDED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
    public String toCode(DocumentReferenceStatus code) {
      if (code == DocumentReferenceStatus.CURRENT)
        return "current";
      if (code == DocumentReferenceStatus.SUPERSEDED)
        return "superseded";
      if (code == DocumentReferenceStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(DocumentReferenceStatus code) {
      return code.getSystem();
      }
    }

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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          this.mode = null;
        } else if (name.equals("time")) {
          this.time = null;
        } else if (name.equals("party")) {
          this.party = null;
        } else
          super.removeChild(name, value);
        
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
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.attester.time");
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("target")) {
          this.target = null;
        } else
          super.removeChild(name, value);
        
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("attachment")) {
          this.attachment = null;
        } else if (name.equals("profile")) {
          this.getProfile().remove((DocumentReferenceContentProfileComponent) value);
        } else
          super.removeChild(name, value);
        
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-HL7FormatCodes")
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
            throw new FHIRException("Not the right type for DocumentReference.content.profile.value[x]: "+value.fhirType());
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
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
     * An explicitly assigned identifer of a variation of the content in the DocumentReference.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="An explicitly assigned identifer of a variation of the content in the DocumentReference", formalDefinition="An explicitly assigned identifer of a variation of the content in the DocumentReference." )
    protected StringType version;

    /**
     * A procedure that is fulfilled in whole or in part by the creation of this media.
     */
    @Child(name = "basedOn", type = {Appointment.class, AppointmentResponse.class, CarePlan.class, Claim.class, CommunicationRequest.class, Contract.class, CoverageEligibilityRequest.class, DeviceRequest.class, EnrollmentRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, RequestOrchestration.class, ServiceRequest.class, SupplyRequest.class, VisionPrescription.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Procedure that caused this media to be created", formalDefinition="A procedure that is fulfilled in whole or in part by the creation of this media." )
    protected List<Reference> basedOn;

    /**
     * The status of this document reference.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="current | superseded | entered-in-error", formalDefinition="The status of this document reference." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-reference-status")
    protected Enumeration<DocumentReferenceStatus> status;

    /**
     * The status of the underlying document.
     */
    @Child(name = "docStatus", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="registered | partial | preliminary | final | amended | corrected | appended | cancelled | entered-in-error | deprecated | unknown", formalDefinition="The status of the underlying document." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/composition-status")
    protected Enumeration<CompositionStatus> docStatus;

    /**
     * Imaging modality used. This may include both acquisition and non-acquisition modalities.
     */
    @Child(name = "modality", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Imaging modality used", formalDefinition="Imaging modality used. This may include both acquisition and non-acquisition modalities." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_33.html")
    protected List<CodeableConcept> modality;

    /**
     * Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of document (LOINC if possible)", formalDefinition="Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/doc-typecodes")
    protected CodeableConcept type;

    /**
     * A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Categorization of document", formalDefinition="A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referenced-item-category")
    protected List<CodeableConcept> category;

    /**
     * Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).
     */
    @Child(name = "subject", type = {Reference.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what is the subject of the document", formalDefinition="Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure)." )
    protected Reference subject;

    /**
     * Describes the clinical encounter or type of care that the document content is associated with.
     */
    @Child(name = "context", type = {Appointment.class, Encounter.class, EpisodeOfCare.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Context of the document content", formalDefinition="Describes the clinical encounter or type of care that the document content is associated with." )
    protected List<Reference> context;

    /**
     * This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.
     */
    @Child(name = "event", type = {CodeableReference.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Main clinical acts documented", formalDefinition="This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActCode")
    protected List<CodeableReference> event;

    /**
     * The anatomic structures included in the document.
     */
    @Child(name = "bodySite", type = {CodeableReference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Body part included", formalDefinition="The anatomic structures included in the document." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableReference> bodySite;

    /**
     * The kind of facility where the patient was seen.
     */
    @Child(name = "facilityType", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Kind of facility where patient was seen", formalDefinition="The kind of facility where the patient was seen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-facilitycodes")
    protected CodeableConcept facilityType;

    /**
     * This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.
     */
    @Child(name = "practiceSetting", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional details about where the content was created (e.g. clinical specialty)", formalDefinition="This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected CodeableConcept practiceSetting;

    /**
     * The time period over which the service that is described by the document was provided.
     */
    @Child(name = "period", type = {Period.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time of service that is being documented", formalDefinition="The time period over which the service that is described by the document was provided." )
    protected Period period;

    /**
     * When the document reference was created.
     */
    @Child(name = "date", type = {InstantType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When this document reference was created", formalDefinition="When the document reference was created." )
    protected InstantType date;

    /**
     * Identifies who is responsible for adding the information to the document.
     */
    @Child(name = "author", type = {Practitioner.class, PractitionerRole.class, Organization.class, Device.class, Patient.class, RelatedPerson.class, CareTeam.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who and/or what authored the document", formalDefinition="Identifies who is responsible for adding the information to the document." )
    protected List<Reference> author;

    /**
     * A participant who has authenticated the accuracy of the document.
     */
    @Child(name = "attester", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Attests to accuracy of the document", formalDefinition="A participant who has authenticated the accuracy of the document." )
    protected List<DocumentReferenceAttesterComponent> attester;

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.
     */
    @Child(name = "custodian", type = {Organization.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization which maintains the document", formalDefinition="Identifies the organization or group who is responsible for ongoing maintenance of and access to the document." )
    protected Reference custodian;

    /**
     * Relationships that this document has with other document references that already exist.
     */
    @Child(name = "relatesTo", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Relationships to other documents", formalDefinition="Relationships that this document has with other document references that already exist." )
    protected List<DocumentReferenceRelatesToComponent> relatesTo;

    /**
     * Human-readable description of the source document.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable description", formalDefinition="Human-readable description of the source document." )
    protected MarkdownType description;

    /**
     * A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened.
     */
    @Child(name = "securityLabel", type = {CodeableConcept.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document security-tags", formalDefinition="A set of Security-Tag codes specifying the level of privacy/security of the Document found at DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains the security labels of the data elements in DocumentReference, while DocumentReference.securityLabel contains the security labels for the document the reference refers to. The distinction recognizes that the document may contain sensitive information, while the DocumentReference is metadata about the document and thus might not be as sensitive as the document. For example: a psychotherapy episode may contain highly sensitive information, while the metadata may simply indicate that some episode happened." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-examples")
    protected List<CodeableConcept> securityLabel;

    /**
     * The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata.
     */
    @Child(name = "content", type = {}, order=22, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document referenced", formalDefinition="The document and format referenced.  If there are multiple content element repetitions, these must all represent the same document in different format, or attachment metadata." )
    protected List<DocumentReferenceContentComponent> content;

    private static final long serialVersionUID = -981268007L;

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
     * @return {@link #version} (An explicitly assigned identifer of a variation of the content in the DocumentReference.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (An explicitly assigned identifer of a variation of the content in the DocumentReference.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public DocumentReference setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return An explicitly assigned identifer of a variation of the content in the DocumentReference.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value An explicitly assigned identifer of a variation of the content in the DocumentReference.
     */
    public DocumentReference setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
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
     * @return {@link #modality} (Imaging modality used. This may include both acquisition and non-acquisition modalities.)
     */
    public List<CodeableConcept> getModality() { 
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      return this.modality;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setModality(List<CodeableConcept> theModality) { 
      this.modality = theModality;
      return this;
    }

    public boolean hasModality() { 
      if (this.modality == null)
        return false;
      for (CodeableConcept item : this.modality)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addModality() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      this.modality.add(t);
      return t;
    }

    public DocumentReference addModality(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      this.modality.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #modality}, creating it if it does not already exist {3}
     */
    public CodeableConcept getModalityFirstRep() { 
      if (getModality().isEmpty()) {
        addModality();
      }
      return getModality().get(0);
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
     * @return {@link #bodySite} (The anatomic structures included in the document.)
     */
    public List<CodeableReference> getBodySite() { 
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableReference>();
      return this.bodySite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setBodySite(List<CodeableReference> theBodySite) { 
      this.bodySite = theBodySite;
      return this;
    }

    public boolean hasBodySite() { 
      if (this.bodySite == null)
        return false;
      for (CodeableReference item : this.bodySite)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addBodySite() { //3
      CodeableReference t = new CodeableReference();
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableReference>();
      this.bodySite.add(t);
      return t;
    }

    public DocumentReference addBodySite(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableReference>();
      this.bodySite.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #bodySite}, creating it if it does not already exist {3}
     */
    public CodeableReference getBodySiteFirstRep() { 
      if (getBodySite().isEmpty()) {
        addBodySite();
      }
      return getBodySite().get(0);
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
      if (Utilities.noString(value))
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Other business identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "An explicitly assigned identifer of a variation of the content in the DocumentReference.", 0, 1, version));
        children.add(new Property("basedOn", "Reference(Appointment|AppointmentResponse|CarePlan|Claim|CommunicationRequest|Contract|CoverageEligibilityRequest|DeviceRequest|EnrollmentRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|RequestOrchestration|ServiceRequest|SupplyRequest|VisionPrescription)", "A procedure that is fulfilled in whole or in part by the creation of this media.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("status", "code", "The status of this document reference.", 0, 1, status));
        children.add(new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus));
        children.add(new Property("modality", "CodeableConcept", "Imaging modality used. This may include both acquisition and non-acquisition modalities.", 0, java.lang.Integer.MAX_VALUE, modality));
        children.add(new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type));
        children.add(new Property("category", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("subject", "Reference(Any)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject));
        children.add(new Property("context", "Reference(Appointment|Encounter|EpisodeOfCare)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, java.lang.Integer.MAX_VALUE, context));
        children.add(new Property("event", "CodeableReference", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event));
        children.add(new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures included in the document.", 0, java.lang.Integer.MAX_VALUE, bodySite));
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
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Other business identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "An explicitly assigned identifer of a variation of the content in the DocumentReference.", 0, 1, version);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Appointment|AppointmentResponse|CarePlan|Claim|CommunicationRequest|Contract|CoverageEligibilityRequest|DeviceRequest|EnrollmentRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|RequestOrchestration|ServiceRequest|SupplyRequest|VisionPrescription)", "A procedure that is fulfilled in whole or in part by the creation of this media.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this document reference.", 0, 1, status);
        case -23496886: /*docStatus*/  return new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus);
        case -622722335: /*modality*/  return new Property("modality", "CodeableConcept", "Imaging modality used. This may include both acquisition and non-acquisition modalities.", 0, java.lang.Integer.MAX_VALUE, modality);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Any)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject);
        case 951530927: /*context*/  return new Property("context", "Reference(Appointment|Encounter|EpisodeOfCare)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, java.lang.Integer.MAX_VALUE, context);
        case 96891546: /*event*/  return new Property("event", "CodeableReference", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the type Code, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures included in the document.", 0, java.lang.Integer.MAX_VALUE, bodySite);
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
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DocumentReferenceStatus>
        case -23496886: /*docStatus*/ return this.docStatus == null ? new Base[0] : new Base[] {this.docStatus}; // Enumeration<CompositionStatus>
        case -622722335: /*modality*/ return this.modality == null ? new Base[0] : this.modality.toArray(new Base[this.modality.size()]); // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 951530927: /*context*/ return this.context == null ? new Base[0] : this.context.toArray(new Base[this.context.size()]); // Reference
        case 96891546: /*event*/ return this.event == null ? new Base[0] : this.event.toArray(new Base[this.event.size()]); // CodeableReference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : this.bodySite.toArray(new Base[this.bodySite.size()]); // CodeableReference
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
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
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
        case -622722335: // modality
          this.getModality().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        case 1702620169: // bodySite
          this.getBodySite().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
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
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new DocumentReferenceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
        } else if (name.equals("docStatus")) {
          value = new CompositionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<CompositionStatus>
        } else if (name.equals("modality")) {
          this.getModality().add(TypeConvertor.castToCodeableConcept(value));
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
        } else if (name.equals("bodySite")) {
          this.getBodySite().add(TypeConvertor.castToCodeableReference(value));
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
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("basedOn")) {
          this.getBasedOn().remove(value);
        } else if (name.equals("status")) {
          value = new DocumentReferenceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
        } else if (name.equals("docStatus")) {
          value = new CompositionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<CompositionStatus>
        } else if (name.equals("modality")) {
          this.getModality().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("category")) {
          this.getCategory().remove(value);
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("context")) {
          this.getContext().remove(value);
        } else if (name.equals("event")) {
          this.getEvent().remove(value);
        } else if (name.equals("bodySite")) {
          this.getBodySite().remove(value);
        } else if (name.equals("facilityType")) {
          this.facilityType = null;
        } else if (name.equals("practiceSetting")) {
          this.practiceSetting = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("author")) {
          this.getAuthor().remove(value);
        } else if (name.equals("attester")) {
          this.getAttester().remove((DocumentReferenceAttesterComponent) value);
        } else if (name.equals("custodian")) {
          this.custodian = null;
        } else if (name.equals("relatesTo")) {
          this.getRelatesTo().remove((DocumentReferenceRelatesToComponent) value);
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().remove(value);
        } else if (name.equals("content")) {
          this.getContent().remove((DocumentReferenceContentComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case -332612366:  return addBasedOn(); 
        case -892481550:  return getStatusElement();
        case -23496886:  return getDocStatusElement();
        case -622722335:  return addModality(); 
        case 3575610:  return getType();
        case 50511102:  return addCategory(); 
        case -1867885268:  return getSubject();
        case 951530927:  return addContext(); 
        case 96891546:  return addEvent(); 
        case 1702620169:  return addBodySite(); 
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
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -23496886: /*docStatus*/ return new String[] {"code"};
        case -622722335: /*modality*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 951530927: /*context*/ return new String[] {"Reference"};
        case 96891546: /*event*/ return new String[] {"CodeableReference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableReference"};
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
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.version");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.status");
        }
        else if (name.equals("docStatus")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.docStatus");
        }
        else if (name.equals("modality")) {
          return addModality();
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
        else if (name.equals("bodySite")) {
          return addBodySite();
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
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.date");
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
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.description");
        }
        else if (name.equals("securityLabel")) {
          return addSecurityLabel();
        }
        else if (name.equals("content")) {
          return addContent();
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
        dst.version = version == null ? null : version.copy();
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.docStatus = docStatus == null ? null : docStatus.copy();
        if (modality != null) {
          dst.modality = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : modality)
            dst.modality.add(i.copy());
        };
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
        if (bodySite != null) {
          dst.bodySite = new ArrayList<CodeableReference>();
          for (CodeableReference i : bodySite)
            dst.bodySite.add(i.copy());
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(status, o.status, true) && compareDeep(docStatus, o.docStatus, true) && compareDeep(modality, o.modality, true)
           && compareDeep(type, o.type, true) && compareDeep(category, o.category, true) && compareDeep(subject, o.subject, true)
           && compareDeep(context, o.context, true) && compareDeep(event, o.event, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(facilityType, o.facilityType, true) && compareDeep(practiceSetting, o.practiceSetting, true)
           && compareDeep(period, o.period, true) && compareDeep(date, o.date, true) && compareDeep(author, o.author, true)
           && compareDeep(attester, o.attester, true) && compareDeep(custodian, o.custodian, true) && compareDeep(relatesTo, o.relatesTo, true)
           && compareDeep(description, o.description, true) && compareDeep(securityLabel, o.securityLabel, true)
           && compareDeep(content, o.content, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReference))
          return false;
        DocumentReference o = (DocumentReference) other_;
        return compareValues(version, o.version, true) && compareValues(status, o.status, true) && compareValues(docStatus, o.docStatus, true)
           && compareValues(date, o.date, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, version, basedOn
          , status, docStatus, modality, type, category, subject, context, event, bodySite
          , facilityType, practiceSetting, period, date, author, attester, custodian, relatesTo
          , description, securityLabel, content);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DocumentReference;
   }

 /**
   * Search parameter: <b>attester</b>
   * <p>
   * Description: <b>Who attested the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.attester.party</b><br>
   * </p>
   */
  @SearchParamDefinition(name="attester", path="DocumentReference.attester.party", description="Who attested the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_ATTESTER = "attester";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>attester</b>
   * <p>
   * Description: <b>Who attested the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.attester.party</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ATTESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ATTESTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:attester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ATTESTER = new ca.uhn.fhir.model.api.Include("DocumentReference:attester").toLocked();

 /**
   * Search parameter: <b>author</b>
   * <p>
   * Description: <b>Who and/or what authored the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.author</b><br>
   * </p>
   */
  @SearchParamDefinition(name="author", path="DocumentReference.author", description="Who and/or what authored the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_AUTHOR = "author";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>author</b>
   * <p>
   * Description: <b>Who and/or what authored the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.author</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:author</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHOR = new ca.uhn.fhir.model.api.Include("DocumentReference:author").toLocked();

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Procedure that caused this media to be created</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="DocumentReference.basedOn", description="Procedure that caused this media to be created", type="reference", target={Appointment.class, AppointmentResponse.class, CarePlan.class, Claim.class, CommunicationRequest.class, Contract.class, CoverageEligibilityRequest.class, DeviceRequest.class, EnrollmentRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, RequestOrchestration.class, ServiceRequest.class, SupplyRequest.class, VisionPrescription.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Procedure that caused this media to be created</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("DocumentReference:based-on").toLocked();

 /**
   * Search parameter: <b>bodysite-reference</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.bodySite.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="bodysite-reference", path="DocumentReference.bodySite.reference", description="The body site studied", type="reference", target={BodyStructure.class } )
  public static final String SP_BODYSITE_REFERENCE = "bodysite-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>bodysite-reference</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.bodySite.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BODYSITE_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BODYSITE_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:bodysite-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BODYSITE_REFERENCE = new ca.uhn.fhir.model.api.Include("DocumentReference:bodysite-reference").toLocked();

 /**
   * Search parameter: <b>bodysite</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.bodySite.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="bodysite", path="DocumentReference.bodySite.concept", description="The body site studied", type="token" )
  public static final String SP_BODYSITE = "bodysite";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>bodysite</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.bodySite.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODYSITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODYSITE);

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Categorization of document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="DocumentReference.category", description="Categorization of document", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Categorization of document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>contenttype</b>
   * <p>
   * Description: <b>Mime type of the content, with charset etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.contentType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contenttype", path="DocumentReference.content.attachment.contentType", description="Mime type of the content, with charset etc.", type="token" )
  public static final String SP_CONTENTTYPE = "contenttype";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contenttype</b>
   * <p>
   * Description: <b>Mime type of the content, with charset etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.contentType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTENTTYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTENTTYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Context of the document content</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="DocumentReference.context", description="Context of the document content", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Appointment.class, Encounter.class, EpisodeOfCare.class } )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Context of the document content</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTEXT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:context</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTEXT = new ca.uhn.fhir.model.api.Include("DocumentReference:context").toLocked();

 /**
   * Search parameter: <b>creation</b>
   * <p>
   * Description: <b>Date attachment was first created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.content.attachment.creation</b><br>
   * </p>
   */
  @SearchParamDefinition(name="creation", path="DocumentReference.content.attachment.creation", description="Date attachment was first created", type="date" )
  public static final String SP_CREATION = "creation";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>creation</b>
   * <p>
   * Description: <b>Date attachment was first created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.content.attachment.creation</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam CREATION = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_CREATION);

 /**
   * Search parameter: <b>custodian</b>
   * <p>
   * Description: <b>Organization which maintains the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.custodian</b><br>
   * </p>
   */
  @SearchParamDefinition(name="custodian", path="DocumentReference.custodian", description="Organization which maintains the document", type="reference", target={Organization.class } )
  public static final String SP_CUSTODIAN = "custodian";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>custodian</b>
   * <p>
   * Description: <b>Organization which maintains the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.custodian</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CUSTODIAN = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CUSTODIAN);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:custodian</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CUSTODIAN = new ca.uhn.fhir.model.api.Include("DocumentReference:custodian").toLocked();

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Human-readable description</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="DocumentReference.description", description="Human-readable description", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Human-readable description</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>doc-status</b>
   * <p>
   * Description: <b>preliminary | final | amended | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.docStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="doc-status", path="DocumentReference.docStatus", description="preliminary | final | amended | entered-in-error", type="token" )
  public static final String SP_DOC_STATUS = "doc-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>doc-status</b>
   * <p>
   * Description: <b>preliminary | final | amended | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.docStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOC_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOC_STATUS);

 /**
   * Search parameter: <b>event-code</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.event.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="event-code", path="DocumentReference.event.concept", description="Main clinical acts documented", type="token" )
  public static final String SP_EVENT_CODE = "event-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>event-code</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.event.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EVENT_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EVENT_CODE);

 /**
   * Search parameter: <b>event-reference</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.event.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="event-reference", path="DocumentReference.event.reference", description="Main clinical acts documented", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_EVENT_REFERENCE = "event-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>event-reference</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.event.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam EVENT_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_EVENT_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:event-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_EVENT_REFERENCE = new ca.uhn.fhir.model.api.Include("DocumentReference:event-reference").toLocked();

 /**
   * Search parameter: <b>facility</b>
   * <p>
   * Description: <b>Kind of facility where patient was seen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.facilityType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="facility", path="DocumentReference.facilityType", description="Kind of facility where patient was seen", type="token" )
  public static final String SP_FACILITY = "facility";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>facility</b>
   * <p>
   * Description: <b>Kind of facility where patient was seen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.facilityType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FACILITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FACILITY);

 /**
   * Search parameter: <b>format-canonical</b>
   * <p>
   * Description: <b>Profile canonical content rules for the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(canonical))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format-canonical", path="(DocumentReference.content.profile.value.ofType(canonical))", description="Profile canonical content rules for the document", type="reference", target={ActivityDefinition.class, ActorDefinition.class, CapabilityStatement.class, ChargeItemDefinition.class, Citation.class, CodeSystem.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, ConditionDefinition.class, Contract.class, Device.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, GraphDefinition.class, ImplementationGuide.class, Library.class, Measure.class, MessageDefinition.class, NamingSystem.class, ObservationDefinition.class, OperationDefinition.class, PlanDefinition.class, Questionnaire.class, Requirements.class, ResearchStudy.class, SearchParameter.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, SubscriptionTopic.class, TerminologyCapabilities.class, TestPlan.class, TestScript.class, ValueSet.class } )
  public static final String SP_FORMAT_CANONICAL = "format-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format-canonical</b>
   * <p>
   * Description: <b>Profile canonical content rules for the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(canonical))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FORMAT_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FORMAT_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:format-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FORMAT_CANONICAL = new ca.uhn.fhir.model.api.Include("DocumentReference:format-canonical").toLocked();

 /**
   * Search parameter: <b>format-code</b>
   * <p>
   * Description: <b>Format code content rules for the document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(Coding))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format-code", path="(DocumentReference.content.profile.value.ofType(Coding))", description="Format code content rules for the document", type="token" )
  public static final String SP_FORMAT_CODE = "format-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format-code</b>
   * <p>
   * Description: <b>Format code content rules for the document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(Coding))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FORMAT_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FORMAT_CODE);

 /**
   * Search parameter: <b>format-uri</b>
   * <p>
   * Description: <b>Profile URI content rules for the document</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(uri))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format-uri", path="(DocumentReference.content.profile.value.ofType(uri))", description="Profile URI content rules for the document", type="uri" )
  public static final String SP_FORMAT_URI = "format-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format-uri</b>
   * <p>
   * Description: <b>Profile URI content rules for the document</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(DocumentReference.content.profile.value.ofType(uri))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam FORMAT_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_FORMAT_URI);

 /**
   * Search parameter: <b>language</b>
   * <p>
   * Description: <b>Human language of the content (BCP-47)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.language</b><br>
   * </p>
   */
  @SearchParamDefinition(name="language", path="DocumentReference.content.attachment.language", description="Human language of the content (BCP-47)", type="token" )
  public static final String SP_LANGUAGE = "language";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>language</b>
   * <p>
   * Description: <b>Human language of the content (BCP-47)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.language</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam LANGUAGE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_LANGUAGE);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Uri where the data can be found</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DocumentReference.content.attachment.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="DocumentReference.content.attachment.url", description="Uri where the data can be found", type="uri" )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Uri where the data can be found</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DocumentReference.content.attachment.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam LOCATION = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_LOCATION);

 /**
   * Search parameter: <b>modality</b>
   * <p>
   * Description: <b>The modality used</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.modality</b><br>
   * </p>
   */
  @SearchParamDefinition(name="modality", path="DocumentReference.modality", description="The modality used", type="token" )
  public static final String SP_MODALITY = "modality";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>modality</b>
   * <p>
   * Description: <b>The modality used</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.modality</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MODALITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MODALITY);

 /**
   * Search parameter: <b>period</b>
   * <p>
   * Description: <b>Time of service that is being documented</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="period", path="DocumentReference.period", description="Time of service that is being documented", type="date" )
  public static final String SP_PERIOD = "period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>period</b>
   * <p>
   * Description: <b>Time of service that is being documented</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_PERIOD);

 /**
   * Search parameter: <b>relatesto</b>
   * <p>
   * Description: <b>Target of the relationship</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.relatesTo.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relatesto", path="DocumentReference.relatesTo.target", description="Target of the relationship", type="reference", target={DocumentReference.class } )
  public static final String SP_RELATESTO = "relatesto";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relatesto</b>
   * <p>
   * Description: <b>Target of the relationship</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.relatesTo.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RELATESTO = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RELATESTO);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:relatesto</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RELATESTO = new ca.uhn.fhir.model.api.Include("DocumentReference:relatesto").toLocked();

 /**
   * Search parameter: <b>relation</b>
   * <p>
   * Description: <b>replaces | transforms | signs | appends</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.relatesTo.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relation", path="DocumentReference.relatesTo.code", description="replaces | transforms | signs | appends", type="token" )
  public static final String SP_RELATION = "relation";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relation</b>
   * <p>
   * Description: <b>replaces | transforms | signs | appends</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.relatesTo.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RELATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RELATION);

 /**
   * Search parameter: <b>relationship</b>
   * <p>
   * Description: <b>Combination of relation and relatesTo</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>DocumentReference.relatesTo</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relationship", path="DocumentReference.relatesTo", description="Combination of relation and relatesTo", type="composite", compositeOf={"relatesto", "relation"} )
  public static final String SP_RELATIONSHIP = "relationship";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relationship</b>
   * <p>
   * Description: <b>Combination of relation and relatesTo</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>DocumentReference.relatesTo</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.ReferenceClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> RELATIONSHIP = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.ReferenceClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_RELATIONSHIP);

 /**
   * Search parameter: <b>security-label</b>
   * <p>
   * Description: <b>Document security-tags</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.securityLabel</b><br>
   * </p>
   */
  @SearchParamDefinition(name="security-label", path="DocumentReference.securityLabel", description="Document security-tags", type="token" )
  public static final String SP_SECURITY_LABEL = "security-label";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>security-label</b>
   * <p>
   * Description: <b>Document security-tags</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.securityLabel</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SECURITY_LABEL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SECURITY_LABEL);

 /**
   * Search parameter: <b>setting</b>
   * <p>
   * Description: <b>Additional details about where the content was created (e.g. clinical specialty)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.practiceSetting</b><br>
   * </p>
   */
  @SearchParamDefinition(name="setting", path="DocumentReference.practiceSetting", description="Additional details about where the content was created (e.g. clinical specialty)", type="token" )
  public static final String SP_SETTING = "setting";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>setting</b>
   * <p>
   * Description: <b>Additional details about where the content was created (e.g. clinical specialty)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.practiceSetting</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SETTING = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SETTING);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>current | superseded | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="DocumentReference.status", description="current | superseded | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>current | superseded | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="DocumentReference.subject", description="Who/what is the subject of the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("DocumentReference:subject").toLocked();

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version identifier</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="DocumentReference.version", description="The business version identifier", type="string" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version identifier</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam VERSION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_VERSION);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): When the event occurred\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [Appointment](appointment.html): Appointment date/time.\r\n* [AuditEvent](auditevent.html): Time when the event was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [DocumentReference](documentreference.html): When this document reference was created\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created\r\n* [Invoice](invoice.html): Invoice date / posting date\r\n* [List](list.html): When the list was prepared\r\n* [MeasureReport](measurereport.html): The date of the measure report\r\n* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication\r\n* [Observation](observation.html): Clinically relevant time/time-period for observation\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [ResearchSubject](researchsubject.html): Start and end of participation\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DocumentReference:patient").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type", description="Multiple Resources: \r\n\r\n* [Account](account.html): E.g. patient, expense, depreciation\r\n* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)\r\n* [Composition](composition.html): Kind of composition (LOINC if possible)\r\n* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)\r\n* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)\r\n* [Encounter](encounter.html): Specific type of encounter\r\n* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management\r\n* [Invoice](invoice.html): Type of Invoice\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type\r\n* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence\r\n* [Specimen](specimen.html): The specimen type\r\n", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

