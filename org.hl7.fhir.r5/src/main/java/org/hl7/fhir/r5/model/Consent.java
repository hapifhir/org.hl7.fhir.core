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
 * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
 */
@ResourceDef(name="Consent", profile="http://hl7.org/fhir/StructureDefinition/Consent")
public class Consent extends DomainResource {

    public enum ConsentState {
        /**
         * The consent is in development or awaiting use but is not yet intended to be acted upon.
         */
        DRAFT, 
        /**
         * The consent is to be followed and enforced.
         */
        ACTIVE, 
        /**
         * The consent is terminated or replaced.
         */
        INACTIVE, 
        /**
         * The consent development has been terminated prior to completion.
         */
        NOTDONE, 
        /**
         * The consent was created wrongly (e.g. wrong patient) and should be ignored.
         */
        ENTEREDINERROR, 
        /**
         * The resource is in an indeterminate state.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConsentState fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("not-done".equals(codeString))
          return NOTDONE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConsentState code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case NOTDONE: return "not-done";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/consent-state-codes";
            case ACTIVE: return "http://hl7.org/fhir/consent-state-codes";
            case INACTIVE: return "http://hl7.org/fhir/consent-state-codes";
            case NOTDONE: return "http://hl7.org/fhir/consent-state-codes";
            case ENTEREDINERROR: return "http://hl7.org/fhir/consent-state-codes";
            case UNKNOWN: return "http://hl7.org/fhir/consent-state-codes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "The consent is in development or awaiting use but is not yet intended to be acted upon.";
            case ACTIVE: return "The consent is to be followed and enforced.";
            case INACTIVE: return "The consent is terminated or replaced.";
            case NOTDONE: return "The consent development has been terminated prior to completion.";
            case ENTEREDINERROR: return "The consent was created wrongly (e.g. wrong patient) and should be ignored.";
            case UNKNOWN: return "The resource is in an indeterminate state.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Pending";
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case NOTDONE: return "Abandoned";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConsentStateEnumFactory implements EnumFactory<ConsentState> {
    public ConsentState fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return ConsentState.DRAFT;
        if ("active".equals(codeString))
          return ConsentState.ACTIVE;
        if ("inactive".equals(codeString))
          return ConsentState.INACTIVE;
        if ("not-done".equals(codeString))
          return ConsentState.NOTDONE;
        if ("entered-in-error".equals(codeString))
          return ConsentState.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return ConsentState.UNKNOWN;
        throw new IllegalArgumentException("Unknown ConsentState code '"+codeString+"'");
        }
        public Enumeration<ConsentState> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentState>(this, ConsentState.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ConsentState>(this, ConsentState.NULL, code);
        if ("draft".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.DRAFT, code);
        if ("active".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.ACTIVE, code);
        if ("inactive".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.INACTIVE, code);
        if ("not-done".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.NOTDONE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.ENTEREDINERROR, code);
        if ("unknown".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.UNKNOWN, code);
        throw new FHIRException("Unknown ConsentState code '"+codeString+"'");
        }
    public String toCode(ConsentState code) {
      if (code == ConsentState.DRAFT)
        return "draft";
      if (code == ConsentState.ACTIVE)
        return "active";
      if (code == ConsentState.INACTIVE)
        return "inactive";
      if (code == ConsentState.NOTDONE)
        return "not-done";
      if (code == ConsentState.ENTEREDINERROR)
        return "entered-in-error";
      if (code == ConsentState.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(ConsentState code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ConsentPolicyBasisComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A Reference that identifies the policy the organization will enforce for this Consent.
         */
        @Child(name = "reference", type = {Reference.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference backing policy resource", formalDefinition="A Reference that identifies the policy the organization will enforce for this Consent." )
        protected Reference reference;

        /**
         * A URL that links to a computable version of the policy the organization will enforce for this Consent.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="URL to a computable backing policy", formalDefinition="A URL that links to a computable version of the policy the organization will enforce for this Consent." )
        protected UrlType url;

        private static final long serialVersionUID = 252506182L;

    /**
     * Constructor
     */
      public ConsentPolicyBasisComponent() {
        super();
      }

        /**
         * @return {@link #reference} (A Reference that identifies the policy the organization will enforce for this Consent.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentPolicyBasisComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (A Reference that identifies the policy the organization will enforce for this Consent.)
         */
        public ConsentPolicyBasisComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        /**
         * @return {@link #url} (A URL that links to a computable version of the policy the organization will enforce for this Consent.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentPolicyBasisComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (A URL that links to a computable version of the policy the organization will enforce for this Consent.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public ConsentPolicyBasisComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return A URL that links to a computable version of the policy the organization will enforce for this Consent.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value A URL that links to a computable version of the policy the organization will enforce for this Consent.
         */
        public ConsentPolicyBasisComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("reference", "Reference(Any)", "A Reference that identifies the policy the organization will enforce for this Consent.", 0, 1, reference));
          children.add(new Property("url", "url", "A URL that links to a computable version of the policy the organization will enforce for this Consent.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -925155509: /*reference*/  return new Property("reference", "Reference(Any)", "A Reference that identifies the policy the organization will enforce for this Consent.", 0, 1, reference);
          case 116079: /*url*/  return new Property("url", "url", "A URL that links to a computable version of the policy the organization will enforce for this Consent.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509:  return getReference();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return new String[] {"Reference"};
        case 116079: /*url*/ return new String[] {"url"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.policyBasis.url");
        }
        else
          return super.addChild(name);
      }

      public ConsentPolicyBasisComponent copy() {
        ConsentPolicyBasisComponent dst = new ConsentPolicyBasisComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConsentPolicyBasisComponent dst) {
        super.copyValues(dst);
        dst.reference = reference == null ? null : reference.copy();
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConsentPolicyBasisComponent))
          return false;
        ConsentPolicyBasisComponent o = (ConsentPolicyBasisComponent) other_;
        return compareDeep(reference, o.reference, true) && compareDeep(url, o.url, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConsentPolicyBasisComponent))
          return false;
        ConsentPolicyBasisComponent o = (ConsentPolicyBasisComponent) other_;
        return compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(reference, url);
      }

  public String fhirType() {
    return "Consent.policyBasis";

  }

  }

    @Block()
    public static class ConsentVerificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Has the instruction been verified.
         */
        @Child(name = "verified", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Has been verified", formalDefinition="Has the instruction been verified." )
        protected BooleanType verified;

        /**
         * Extensible list of verification type starting with verification and re-validation.
         */
        @Child(name = "verificationType", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Business case of verification", formalDefinition="Extensible list of verification type starting with verification and re-validation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-verification")
        protected CodeableConcept verificationType;

        /**
         * The person who conducted the verification/validation of the Grantor decision.
         */
        @Child(name = "verifiedBy", type = {Organization.class, Practitioner.class, PractitionerRole.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Person conducting verification", formalDefinition="The person who conducted the verification/validation of the Grantor decision." )
        protected Reference verifiedBy;

        /**
         * Who verified the instruction (Patient, Relative or other Authorized Person).
         */
        @Child(name = "verifiedWith", type = {Patient.class, RelatedPerson.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Person who verified", formalDefinition="Who verified the instruction (Patient, Relative or other Authorized Person)." )
        protected Reference verifiedWith;

        /**
         * Date(s) verification was collected.
         */
        @Child(name = "verificationDate", type = {DateTimeType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="When consent verified", formalDefinition="Date(s) verification was collected." )
        protected List<DateTimeType> verificationDate;

        private static final long serialVersionUID = -1266157329L;

    /**
     * Constructor
     */
      public ConsentVerificationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConsentVerificationComponent(boolean verified) {
        super();
        this.setVerified(verified);
      }

        /**
         * @return {@link #verified} (Has the instruction been verified.). This is the underlying object with id, value and extensions. The accessor "getVerified" gives direct access to the value
         */
        public BooleanType getVerifiedElement() { 
          if (this.verified == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentVerificationComponent.verified");
            else if (Configuration.doAutoCreate())
              this.verified = new BooleanType(); // bb
          return this.verified;
        }

        public boolean hasVerifiedElement() { 
          return this.verified != null && !this.verified.isEmpty();
        }

        public boolean hasVerified() { 
          return this.verified != null && !this.verified.isEmpty();
        }

        /**
         * @param value {@link #verified} (Has the instruction been verified.). This is the underlying object with id, value and extensions. The accessor "getVerified" gives direct access to the value
         */
        public ConsentVerificationComponent setVerifiedElement(BooleanType value) { 
          this.verified = value;
          return this;
        }

        /**
         * @return Has the instruction been verified.
         */
        public boolean getVerified() { 
          return this.verified == null || this.verified.isEmpty() ? false : this.verified.getValue();
        }

        /**
         * @param value Has the instruction been verified.
         */
        public ConsentVerificationComponent setVerified(boolean value) { 
            if (this.verified == null)
              this.verified = new BooleanType();
            this.verified.setValue(value);
          return this;
        }

        /**
         * @return {@link #verificationType} (Extensible list of verification type starting with verification and re-validation.)
         */
        public CodeableConcept getVerificationType() { 
          if (this.verificationType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentVerificationComponent.verificationType");
            else if (Configuration.doAutoCreate())
              this.verificationType = new CodeableConcept(); // cc
          return this.verificationType;
        }

        public boolean hasVerificationType() { 
          return this.verificationType != null && !this.verificationType.isEmpty();
        }

        /**
         * @param value {@link #verificationType} (Extensible list of verification type starting with verification and re-validation.)
         */
        public ConsentVerificationComponent setVerificationType(CodeableConcept value) { 
          this.verificationType = value;
          return this;
        }

        /**
         * @return {@link #verifiedBy} (The person who conducted the verification/validation of the Grantor decision.)
         */
        public Reference getVerifiedBy() { 
          if (this.verifiedBy == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentVerificationComponent.verifiedBy");
            else if (Configuration.doAutoCreate())
              this.verifiedBy = new Reference(); // cc
          return this.verifiedBy;
        }

        public boolean hasVerifiedBy() { 
          return this.verifiedBy != null && !this.verifiedBy.isEmpty();
        }

        /**
         * @param value {@link #verifiedBy} (The person who conducted the verification/validation of the Grantor decision.)
         */
        public ConsentVerificationComponent setVerifiedBy(Reference value) { 
          this.verifiedBy = value;
          return this;
        }

        /**
         * @return {@link #verifiedWith} (Who verified the instruction (Patient, Relative or other Authorized Person).)
         */
        public Reference getVerifiedWith() { 
          if (this.verifiedWith == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConsentVerificationComponent.verifiedWith");
            else if (Configuration.doAutoCreate())
              this.verifiedWith = new Reference(); // cc
          return this.verifiedWith;
        }

        public boolean hasVerifiedWith() { 
          return this.verifiedWith != null && !this.verifiedWith.isEmpty();
        }

        /**
         * @param value {@link #verifiedWith} (Who verified the instruction (Patient, Relative or other Authorized Person).)
         */
        public ConsentVerificationComponent setVerifiedWith(Reference value) { 
          this.verifiedWith = value;
          return this;
        }

        /**
         * @return {@link #verificationDate} (Date(s) verification was collected.)
         */
        public List<DateTimeType> getVerificationDate() { 
          if (this.verificationDate == null)
            this.verificationDate = new ArrayList<DateTimeType>();
          return this.verificationDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ConsentVerificationComponent setVerificationDate(List<DateTimeType> theVerificationDate) { 
          this.verificationDate = theVerificationDate;
          return this;
        }

        public boolean hasVerificationDate() { 
          if (this.verificationDate == null)
            return false;
          for (DateTimeType item : this.verificationDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #verificationDate} (Date(s) verification was collected.)
         */
        public DateTimeType addVerificationDateElement() {//2 
          DateTimeType t = new DateTimeType();
          if (this.verificationDate == null)
            this.verificationDate = new ArrayList<DateTimeType>();
          this.verificationDate.add(t);
          return t;
        }

        /**
         * @param value {@link #verificationDate} (Date(s) verification was collected.)
         */
        public ConsentVerificationComponent addVerificationDate(Date value) { //1
          DateTimeType t = new DateTimeType();
          t.setValue(value);
          if (this.verificationDate == null)
            this.verificationDate = new ArrayList<DateTimeType>();
          this.verificationDate.add(t);
          return this;
        }

        /**
         * @param value {@link #verificationDate} (Date(s) verification was collected.)
         */
        public boolean hasVerificationDate(Date value) { 
          if (this.verificationDate == null)
            return false;
          for (DateTimeType v : this.verificationDate)
            if (v.getValue().equals(value)) // dateTime
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("verified", "boolean", "Has the instruction been verified.", 0, 1, verified));
          children.add(new Property("verificationType", "CodeableConcept", "Extensible list of verification type starting with verification and re-validation.", 0, 1, verificationType));
          children.add(new Property("verifiedBy", "Reference(Organization|Practitioner|PractitionerRole)", "The person who conducted the verification/validation of the Grantor decision.", 0, 1, verifiedBy));
          children.add(new Property("verifiedWith", "Reference(Patient|RelatedPerson)", "Who verified the instruction (Patient, Relative or other Authorized Person).", 0, 1, verifiedWith));
          children.add(new Property("verificationDate", "dateTime", "Date(s) verification was collected.", 0, java.lang.Integer.MAX_VALUE, verificationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1994383672: /*verified*/  return new Property("verified", "boolean", "Has the instruction been verified.", 0, 1, verified);
          case 642733045: /*verificationType*/  return new Property("verificationType", "CodeableConcept", "Extensible list of verification type starting with verification and re-validation.", 0, 1, verificationType);
          case -1047292609: /*verifiedBy*/  return new Property("verifiedBy", "Reference(Organization|Practitioner|PractitionerRole)", "The person who conducted the verification/validation of the Grantor decision.", 0, 1, verifiedBy);
          case -1425236050: /*verifiedWith*/  return new Property("verifiedWith", "Reference(Patient|RelatedPerson)", "Who verified the instruction (Patient, Relative or other Authorized Person).", 0, 1, verifiedWith);
          case 642233449: /*verificationDate*/  return new Property("verificationDate", "dateTime", "Date(s) verification was collected.", 0, java.lang.Integer.MAX_VALUE, verificationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1994383672: /*verified*/ return this.verified == null ? new Base[0] : new Base[] {this.verified}; // BooleanType
        case 642733045: /*verificationType*/ return this.verificationType == null ? new Base[0] : new Base[] {this.verificationType}; // CodeableConcept
        case -1047292609: /*verifiedBy*/ return this.verifiedBy == null ? new Base[0] : new Base[] {this.verifiedBy}; // Reference
        case -1425236050: /*verifiedWith*/ return this.verifiedWith == null ? new Base[0] : new Base[] {this.verifiedWith}; // Reference
        case 642233449: /*verificationDate*/ return this.verificationDate == null ? new Base[0] : this.verificationDate.toArray(new Base[this.verificationDate.size()]); // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1994383672: // verified
          this.verified = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 642733045: // verificationType
          this.verificationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1047292609: // verifiedBy
          this.verifiedBy = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1425236050: // verifiedWith
          this.verifiedWith = TypeConvertor.castToReference(value); // Reference
          return value;
        case 642233449: // verificationDate
          this.getVerificationDate().add(TypeConvertor.castToDateTime(value)); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("verified")) {
          this.verified = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("verificationType")) {
          this.verificationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("verifiedBy")) {
          this.verifiedBy = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("verifiedWith")) {
          this.verifiedWith = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("verificationDate")) {
          this.getVerificationDate().add(TypeConvertor.castToDateTime(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1994383672:  return getVerifiedElement();
        case 642733045:  return getVerificationType();
        case -1047292609:  return getVerifiedBy();
        case -1425236050:  return getVerifiedWith();
        case 642233449:  return addVerificationDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1994383672: /*verified*/ return new String[] {"boolean"};
        case 642733045: /*verificationType*/ return new String[] {"CodeableConcept"};
        case -1047292609: /*verifiedBy*/ return new String[] {"Reference"};
        case -1425236050: /*verifiedWith*/ return new String[] {"Reference"};
        case 642233449: /*verificationDate*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("verified")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.verification.verified");
        }
        else if (name.equals("verificationType")) {
          this.verificationType = new CodeableConcept();
          return this.verificationType;
        }
        else if (name.equals("verifiedBy")) {
          this.verifiedBy = new Reference();
          return this.verifiedBy;
        }
        else if (name.equals("verifiedWith")) {
          this.verifiedWith = new Reference();
          return this.verifiedWith;
        }
        else if (name.equals("verificationDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.verification.verificationDate");
        }
        else
          return super.addChild(name);
      }

      public ConsentVerificationComponent copy() {
        ConsentVerificationComponent dst = new ConsentVerificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConsentVerificationComponent dst) {
        super.copyValues(dst);
        dst.verified = verified == null ? null : verified.copy();
        dst.verificationType = verificationType == null ? null : verificationType.copy();
        dst.verifiedBy = verifiedBy == null ? null : verifiedBy.copy();
        dst.verifiedWith = verifiedWith == null ? null : verifiedWith.copy();
        if (verificationDate != null) {
          dst.verificationDate = new ArrayList<DateTimeType>();
          for (DateTimeType i : verificationDate)
            dst.verificationDate.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConsentVerificationComponent))
          return false;
        ConsentVerificationComponent o = (ConsentVerificationComponent) other_;
        return compareDeep(verified, o.verified, true) && compareDeep(verificationType, o.verificationType, true)
           && compareDeep(verifiedBy, o.verifiedBy, true) && compareDeep(verifiedWith, o.verifiedWith, true)
           && compareDeep(verificationDate, o.verificationDate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConsentVerificationComponent))
          return false;
        ConsentVerificationComponent o = (ConsentVerificationComponent) other_;
        return compareValues(verified, o.verified, true) && compareValues(verificationDate, o.verificationDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(verified, verificationType
          , verifiedBy, verifiedWith, verificationDate);
      }

  public String fhirType() {
    return "Consent.verification";

  }

  }

    @Block()
    public static class ProvisionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Timeframe for this provision.
         */
        @Child(name = "period", type = {Period.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Timeframe for this provision", formalDefinition="Timeframe for this provision." )
        protected Period period;

        /**
         * Who or what is controlled by this provision. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').
         */
        @Child(name = "actor", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who|what controlled by this provision (or group, by role)", formalDefinition="Who or what is controlled by this provision. Use group to identify a set of actors by some property they share (e.g. 'admitting officers')." )
        protected List<ProvisionActorComponent> actor;

        /**
         * Actions controlled by this provision.
         */
        @Child(name = "action", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Actions controlled by this provision", formalDefinition="Actions controlled by this provision." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-action")
        protected List<CodeableConcept> action;

        /**
         * A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.
         */
        @Child(name = "securityLabel", type = {Coding.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Security Labels that define affected resources", formalDefinition="A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-examples")
        protected List<Coding> securityLabel;

        /**
         * The context of the activities a user is taking - why the user is accessing the data - that are controlled by this provision.
         */
        @Child(name = "purpose", type = {Coding.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Context of activities covered by this provision", formalDefinition="The context of the activities a user is taking - why the user is accessing the data - that are controlled by this provision." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
        protected List<Coding> purpose;

        /**
         * The documentType(s) covered by this provision. The type can be a CDA document, or some other type that indicates what sort of information the consent relates to.
         */
        @Child(name = "documentType", type = {Coding.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="e.g. Resource Type, Profile, CDA, etc", formalDefinition="The documentType(s) covered by this provision. The type can be a CDA document, or some other type that indicates what sort of information the consent relates to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-content-class")
        protected List<Coding> documentType;

        /**
         * The resourceType(s) covered by this provision. The type can be a FHIR resource type or a profile on a type that indicates what information the consent relates to.
         */
        @Child(name = "resourceType", type = {Coding.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="e.g. Resource Type, Profile, etc", formalDefinition="The resourceType(s) covered by this provision. The type can be a FHIR resource type or a profile on a type that indicates what information the consent relates to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected List<Coding> resourceType;

        /**
         * If this code is found in an instance, then the provision applies.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="e.g. LOINC or SNOMED CT code, etc. in the content", formalDefinition="If this code is found in an instance, then the provision applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-content-code")
        protected List<CodeableConcept> code;

        /**
         * Clinical or Operational Relevant period of time that bounds the data controlled by this provision.
         */
        @Child(name = "dataPeriod", type = {Period.class}, order=9, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Timeframe for data controlled by this provision", formalDefinition="Clinical or Operational Relevant period of time that bounds the data controlled by this provision." )
        protected Period dataPeriod;

        /**
         * The resources controlled by this provision if specific resources are referenced.
         */
        @Child(name = "data", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Data controlled by this provision", formalDefinition="The resources controlled by this provision if specific resources are referenced." )
        protected List<ProvisionDataComponent> data;

        /**
         * A computable (FHIRPath or other) definition of what is controlled by this consent.
         */
        @Child(name = "expression", type = {Expression.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A computable expression of the consent", formalDefinition="A computable (FHIRPath or other) definition of what is controlled by this consent." )
        protected Expression expression;

        /**
         * Provisions which provide exceptions to the base provision or subprovisions.
         */
        @Child(name = "provision", type = {ProvisionComponent.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Nested Exception Provisions", formalDefinition="Provisions which provide exceptions to the base provision or subprovisions." )
        protected List<ProvisionComponent> provision;

        private static final long serialVersionUID = -587666915L;

    /**
     * Constructor
     */
      public ProvisionComponent() {
        super();
      }

        /**
         * @return {@link #period} (Timeframe for this provision.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Timeframe for this provision.)
         */
        public ProvisionComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #actor} (Who or what is controlled by this provision. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').)
         */
        public List<ProvisionActorComponent> getActor() { 
          if (this.actor == null)
            this.actor = new ArrayList<ProvisionActorComponent>();
          return this.actor;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setActor(List<ProvisionActorComponent> theActor) { 
          this.actor = theActor;
          return this;
        }

        public boolean hasActor() { 
          if (this.actor == null)
            return false;
          for (ProvisionActorComponent item : this.actor)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ProvisionActorComponent addActor() { //3
          ProvisionActorComponent t = new ProvisionActorComponent();
          if (this.actor == null)
            this.actor = new ArrayList<ProvisionActorComponent>();
          this.actor.add(t);
          return t;
        }

        public ProvisionComponent addActor(ProvisionActorComponent t) { //3
          if (t == null)
            return this;
          if (this.actor == null)
            this.actor = new ArrayList<ProvisionActorComponent>();
          this.actor.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #actor}, creating it if it does not already exist {3}
         */
        public ProvisionActorComponent getActorFirstRep() { 
          if (getActor().isEmpty()) {
            addActor();
          }
          return getActor().get(0);
        }

        /**
         * @return {@link #action} (Actions controlled by this provision.)
         */
        public List<CodeableConcept> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setAction(List<CodeableConcept> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (CodeableConcept item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAction() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          this.action.add(t);
          return t;
        }

        public ProvisionComponent addAction(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public CodeableConcept getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        /**
         * @return {@link #securityLabel} (A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.)
         */
        public List<Coding> getSecurityLabel() { 
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<Coding>();
          return this.securityLabel;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setSecurityLabel(List<Coding> theSecurityLabel) { 
          this.securityLabel = theSecurityLabel;
          return this;
        }

        public boolean hasSecurityLabel() { 
          if (this.securityLabel == null)
            return false;
          for (Coding item : this.securityLabel)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addSecurityLabel() { //3
          Coding t = new Coding();
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<Coding>();
          this.securityLabel.add(t);
          return t;
        }

        public ProvisionComponent addSecurityLabel(Coding t) { //3
          if (t == null)
            return this;
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<Coding>();
          this.securityLabel.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #securityLabel}, creating it if it does not already exist {3}
         */
        public Coding getSecurityLabelFirstRep() { 
          if (getSecurityLabel().isEmpty()) {
            addSecurityLabel();
          }
          return getSecurityLabel().get(0);
        }

        /**
         * @return {@link #purpose} (The context of the activities a user is taking - why the user is accessing the data - that are controlled by this provision.)
         */
        public List<Coding> getPurpose() { 
          if (this.purpose == null)
            this.purpose = new ArrayList<Coding>();
          return this.purpose;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setPurpose(List<Coding> thePurpose) { 
          this.purpose = thePurpose;
          return this;
        }

        public boolean hasPurpose() { 
          if (this.purpose == null)
            return false;
          for (Coding item : this.purpose)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addPurpose() { //3
          Coding t = new Coding();
          if (this.purpose == null)
            this.purpose = new ArrayList<Coding>();
          this.purpose.add(t);
          return t;
        }

        public ProvisionComponent addPurpose(Coding t) { //3
          if (t == null)
            return this;
          if (this.purpose == null)
            this.purpose = new ArrayList<Coding>();
          this.purpose.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #purpose}, creating it if it does not already exist {3}
         */
        public Coding getPurposeFirstRep() { 
          if (getPurpose().isEmpty()) {
            addPurpose();
          }
          return getPurpose().get(0);
        }

        /**
         * @return {@link #documentType} (The documentType(s) covered by this provision. The type can be a CDA document, or some other type that indicates what sort of information the consent relates to.)
         */
        public List<Coding> getDocumentType() { 
          if (this.documentType == null)
            this.documentType = new ArrayList<Coding>();
          return this.documentType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setDocumentType(List<Coding> theDocumentType) { 
          this.documentType = theDocumentType;
          return this;
        }

        public boolean hasDocumentType() { 
          if (this.documentType == null)
            return false;
          for (Coding item : this.documentType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addDocumentType() { //3
          Coding t = new Coding();
          if (this.documentType == null)
            this.documentType = new ArrayList<Coding>();
          this.documentType.add(t);
          return t;
        }

        public ProvisionComponent addDocumentType(Coding t) { //3
          if (t == null)
            return this;
          if (this.documentType == null)
            this.documentType = new ArrayList<Coding>();
          this.documentType.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #documentType}, creating it if it does not already exist {3}
         */
        public Coding getDocumentTypeFirstRep() { 
          if (getDocumentType().isEmpty()) {
            addDocumentType();
          }
          return getDocumentType().get(0);
        }

        /**
         * @return {@link #resourceType} (The resourceType(s) covered by this provision. The type can be a FHIR resource type or a profile on a type that indicates what information the consent relates to.)
         */
        public List<Coding> getResourceType() { 
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Coding>();
          return this.resourceType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setResourceType(List<Coding> theResourceType) { 
          this.resourceType = theResourceType;
          return this;
        }

        public boolean hasResourceType() { 
          if (this.resourceType == null)
            return false;
          for (Coding item : this.resourceType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addResourceType() { //3
          Coding t = new Coding();
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Coding>();
          this.resourceType.add(t);
          return t;
        }

        public ProvisionComponent addResourceType(Coding t) { //3
          if (t == null)
            return this;
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Coding>();
          this.resourceType.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #resourceType}, creating it if it does not already exist {3}
         */
        public Coding getResourceTypeFirstRep() { 
          if (getResourceType().isEmpty()) {
            addResourceType();
          }
          return getResourceType().get(0);
        }

        /**
         * @return {@link #code} (If this code is found in an instance, then the provision applies.)
         */
        public List<CodeableConcept> getCode() { 
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          return this.code;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setCode(List<CodeableConcept> theCode) { 
          this.code = theCode;
          return this;
        }

        public boolean hasCode() { 
          if (this.code == null)
            return false;
          for (CodeableConcept item : this.code)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addCode() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          this.code.add(t);
          return t;
        }

        public ProvisionComponent addCode(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          this.code.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
         */
        public CodeableConcept getCodeFirstRep() { 
          if (getCode().isEmpty()) {
            addCode();
          }
          return getCode().get(0);
        }

        /**
         * @return {@link #dataPeriod} (Clinical or Operational Relevant period of time that bounds the data controlled by this provision.)
         */
        public Period getDataPeriod() { 
          if (this.dataPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionComponent.dataPeriod");
            else if (Configuration.doAutoCreate())
              this.dataPeriod = new Period(); // cc
          return this.dataPeriod;
        }

        public boolean hasDataPeriod() { 
          return this.dataPeriod != null && !this.dataPeriod.isEmpty();
        }

        /**
         * @param value {@link #dataPeriod} (Clinical or Operational Relevant period of time that bounds the data controlled by this provision.)
         */
        public ProvisionComponent setDataPeriod(Period value) { 
          this.dataPeriod = value;
          return this;
        }

        /**
         * @return {@link #data} (The resources controlled by this provision if specific resources are referenced.)
         */
        public List<ProvisionDataComponent> getData() { 
          if (this.data == null)
            this.data = new ArrayList<ProvisionDataComponent>();
          return this.data;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setData(List<ProvisionDataComponent> theData) { 
          this.data = theData;
          return this;
        }

        public boolean hasData() { 
          if (this.data == null)
            return false;
          for (ProvisionDataComponent item : this.data)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ProvisionDataComponent addData() { //3
          ProvisionDataComponent t = new ProvisionDataComponent();
          if (this.data == null)
            this.data = new ArrayList<ProvisionDataComponent>();
          this.data.add(t);
          return t;
        }

        public ProvisionComponent addData(ProvisionDataComponent t) { //3
          if (t == null)
            return this;
          if (this.data == null)
            this.data = new ArrayList<ProvisionDataComponent>();
          this.data.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #data}, creating it if it does not already exist {3}
         */
        public ProvisionDataComponent getDataFirstRep() { 
          if (getData().isEmpty()) {
            addData();
          }
          return getData().get(0);
        }

        /**
         * @return {@link #expression} (A computable (FHIRPath or other) definition of what is controlled by this consent.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (A computable (FHIRPath or other) definition of what is controlled by this consent.)
         */
        public ProvisionComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        /**
         * @return {@link #provision} (Provisions which provide exceptions to the base provision or subprovisions.)
         */
        public List<ProvisionComponent> getProvision() { 
          if (this.provision == null)
            this.provision = new ArrayList<ProvisionComponent>();
          return this.provision;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setProvision(List<ProvisionComponent> theProvision) { 
          this.provision = theProvision;
          return this;
        }

        public boolean hasProvision() { 
          if (this.provision == null)
            return false;
          for (ProvisionComponent item : this.provision)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ProvisionComponent addProvision() { //3
          ProvisionComponent t = new ProvisionComponent();
          if (this.provision == null)
            this.provision = new ArrayList<ProvisionComponent>();
          this.provision.add(t);
          return t;
        }

        public ProvisionComponent addProvision(ProvisionComponent t) { //3
          if (t == null)
            return this;
          if (this.provision == null)
            this.provision = new ArrayList<ProvisionComponent>();
          this.provision.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #provision}, creating it if it does not already exist {3}
         */
        public ProvisionComponent getProvisionFirstRep() { 
          if (getProvision().isEmpty()) {
            addProvision();
          }
          return getProvision().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("period", "Period", "Timeframe for this provision.", 0, 1, period));
          children.add(new Property("actor", "", "Who or what is controlled by this provision. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, java.lang.Integer.MAX_VALUE, actor));
          children.add(new Property("action", "CodeableConcept", "Actions controlled by this provision.", 0, java.lang.Integer.MAX_VALUE, action));
          children.add(new Property("securityLabel", "Coding", "A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.", 0, java.lang.Integer.MAX_VALUE, securityLabel));
          children.add(new Property("purpose", "Coding", "The context of the activities a user is taking - why the user is accessing the data - that are controlled by this provision.", 0, java.lang.Integer.MAX_VALUE, purpose));
          children.add(new Property("documentType", "Coding", "The documentType(s) covered by this provision. The type can be a CDA document, or some other type that indicates what sort of information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, documentType));
          children.add(new Property("resourceType", "Coding", "The resourceType(s) covered by this provision. The type can be a FHIR resource type or a profile on a type that indicates what information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, resourceType));
          children.add(new Property("code", "CodeableConcept", "If this code is found in an instance, then the provision applies.", 0, java.lang.Integer.MAX_VALUE, code));
          children.add(new Property("dataPeriod", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this provision.", 0, 1, dataPeriod));
          children.add(new Property("data", "", "The resources controlled by this provision if specific resources are referenced.", 0, java.lang.Integer.MAX_VALUE, data));
          children.add(new Property("expression", "Expression", "A computable (FHIRPath or other) definition of what is controlled by this consent.", 0, 1, expression));
          children.add(new Property("provision", "@Consent.provision", "Provisions which provide exceptions to the base provision or subprovisions.", 0, java.lang.Integer.MAX_VALUE, provision));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -991726143: /*period*/  return new Property("period", "Period", "Timeframe for this provision.", 0, 1, period);
          case 92645877: /*actor*/  return new Property("actor", "", "Who or what is controlled by this provision. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, java.lang.Integer.MAX_VALUE, actor);
          case -1422950858: /*action*/  return new Property("action", "CodeableConcept", "Actions controlled by this provision.", 0, java.lang.Integer.MAX_VALUE, action);
          case -722296940: /*securityLabel*/  return new Property("securityLabel", "Coding", "A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.", 0, java.lang.Integer.MAX_VALUE, securityLabel);
          case -220463842: /*purpose*/  return new Property("purpose", "Coding", "The context of the activities a user is taking - why the user is accessing the data - that are controlled by this provision.", 0, java.lang.Integer.MAX_VALUE, purpose);
          case -1473196299: /*documentType*/  return new Property("documentType", "Coding", "The documentType(s) covered by this provision. The type can be a CDA document, or some other type that indicates what sort of information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, documentType);
          case -384364440: /*resourceType*/  return new Property("resourceType", "Coding", "The resourceType(s) covered by this provision. The type can be a FHIR resource type or a profile on a type that indicates what information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, resourceType);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "If this code is found in an instance, then the provision applies.", 0, java.lang.Integer.MAX_VALUE, code);
          case 1177250315: /*dataPeriod*/  return new Property("dataPeriod", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this provision.", 0, 1, dataPeriod);
          case 3076010: /*data*/  return new Property("data", "", "The resources controlled by this provision if specific resources are referenced.", 0, java.lang.Integer.MAX_VALUE, data);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "A computable (FHIRPath or other) definition of what is controlled by this consent.", 0, 1, expression);
          case -547120939: /*provision*/  return new Property("provision", "@Consent.provision", "Provisions which provide exceptions to the base provision or subprovisions.", 0, java.lang.Integer.MAX_VALUE, provision);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // ProvisionActorComponent
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // CodeableConcept
        case -722296940: /*securityLabel*/ return this.securityLabel == null ? new Base[0] : this.securityLabel.toArray(new Base[this.securityLabel.size()]); // Coding
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // Coding
        case -1473196299: /*documentType*/ return this.documentType == null ? new Base[0] : this.documentType.toArray(new Base[this.documentType.size()]); // Coding
        case -384364440: /*resourceType*/ return this.resourceType == null ? new Base[0] : this.resourceType.toArray(new Base[this.resourceType.size()]); // Coding
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // CodeableConcept
        case 1177250315: /*dataPeriod*/ return this.dataPeriod == null ? new Base[0] : new Base[] {this.dataPeriod}; // Period
        case 3076010: /*data*/ return this.data == null ? new Base[0] : this.data.toArray(new Base[this.data.size()]); // ProvisionDataComponent
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // Expression
        case -547120939: /*provision*/ return this.provision == null ? new Base[0] : this.provision.toArray(new Base[this.provision.size()]); // ProvisionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 92645877: // actor
          this.getActor().add((ProvisionActorComponent) value); // ProvisionActorComponent
          return value;
        case -1422950858: // action
          this.getAction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -722296940: // securityLabel
          this.getSecurityLabel().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -220463842: // purpose
          this.getPurpose().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -1473196299: // documentType
          this.getDocumentType().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -384364440: // resourceType
          this.getResourceType().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1177250315: // dataPeriod
          this.dataPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 3076010: // data
          this.getData().add((ProvisionDataComponent) value); // ProvisionDataComponent
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToExpression(value); // Expression
          return value;
        case -547120939: // provision
          this.getProvision().add((ProvisionComponent) value); // ProvisionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("actor")) {
          this.getActor().add((ProvisionActorComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("purpose")) {
          this.getPurpose().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("documentType")) {
          this.getDocumentType().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("resourceType")) {
          this.getResourceType().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("dataPeriod")) {
          this.dataPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("data")) {
          this.getData().add((ProvisionDataComponent) value);
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToExpression(value); // Expression
        } else if (name.equals("provision")) {
          this.getProvision().add((ProvisionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -991726143:  return getPeriod();
        case 92645877:  return addActor(); 
        case -1422950858:  return addAction(); 
        case -722296940:  return addSecurityLabel(); 
        case -220463842:  return addPurpose(); 
        case -1473196299:  return addDocumentType(); 
        case -384364440:  return addResourceType(); 
        case 3059181:  return addCode(); 
        case 1177250315:  return getDataPeriod();
        case 3076010:  return addData(); 
        case -1795452264:  return getExpression();
        case -547120939:  return addProvision(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -991726143: /*period*/ return new String[] {"Period"};
        case 92645877: /*actor*/ return new String[] {};
        case -1422950858: /*action*/ return new String[] {"CodeableConcept"};
        case -722296940: /*securityLabel*/ return new String[] {"Coding"};
        case -220463842: /*purpose*/ return new String[] {"Coding"};
        case -1473196299: /*documentType*/ return new String[] {"Coding"};
        case -384364440: /*resourceType*/ return new String[] {"Coding"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1177250315: /*dataPeriod*/ return new String[] {"Period"};
        case 3076010: /*data*/ return new String[] {};
        case -1795452264: /*expression*/ return new String[] {"Expression"};
        case -547120939: /*provision*/ return new String[] {"@Consent.provision"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("actor")) {
          return addActor();
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else if (name.equals("securityLabel")) {
          return addSecurityLabel();
        }
        else if (name.equals("purpose")) {
          return addPurpose();
        }
        else if (name.equals("documentType")) {
          return addDocumentType();
        }
        else if (name.equals("resourceType")) {
          return addResourceType();
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("dataPeriod")) {
          this.dataPeriod = new Period();
          return this.dataPeriod;
        }
        else if (name.equals("data")) {
          return addData();
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else if (name.equals("provision")) {
          return addProvision();
        }
        else
          return super.addChild(name);
      }

      public ProvisionComponent copy() {
        ProvisionComponent dst = new ProvisionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProvisionComponent dst) {
        super.copyValues(dst);
        dst.period = period == null ? null : period.copy();
        if (actor != null) {
          dst.actor = new ArrayList<ProvisionActorComponent>();
          for (ProvisionActorComponent i : actor)
            dst.actor.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : action)
            dst.action.add(i.copy());
        };
        if (securityLabel != null) {
          dst.securityLabel = new ArrayList<Coding>();
          for (Coding i : securityLabel)
            dst.securityLabel.add(i.copy());
        };
        if (purpose != null) {
          dst.purpose = new ArrayList<Coding>();
          for (Coding i : purpose)
            dst.purpose.add(i.copy());
        };
        if (documentType != null) {
          dst.documentType = new ArrayList<Coding>();
          for (Coding i : documentType)
            dst.documentType.add(i.copy());
        };
        if (resourceType != null) {
          dst.resourceType = new ArrayList<Coding>();
          for (Coding i : resourceType)
            dst.resourceType.add(i.copy());
        };
        if (code != null) {
          dst.code = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : code)
            dst.code.add(i.copy());
        };
        dst.dataPeriod = dataPeriod == null ? null : dataPeriod.copy();
        if (data != null) {
          dst.data = new ArrayList<ProvisionDataComponent>();
          for (ProvisionDataComponent i : data)
            dst.data.add(i.copy());
        };
        dst.expression = expression == null ? null : expression.copy();
        if (provision != null) {
          dst.provision = new ArrayList<ProvisionComponent>();
          for (ProvisionComponent i : provision)
            dst.provision.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProvisionComponent))
          return false;
        ProvisionComponent o = (ProvisionComponent) other_;
        return compareDeep(period, o.period, true) && compareDeep(actor, o.actor, true) && compareDeep(action, o.action, true)
           && compareDeep(securityLabel, o.securityLabel, true) && compareDeep(purpose, o.purpose, true) && compareDeep(documentType, o.documentType, true)
           && compareDeep(resourceType, o.resourceType, true) && compareDeep(code, o.code, true) && compareDeep(dataPeriod, o.dataPeriod, true)
           && compareDeep(data, o.data, true) && compareDeep(expression, o.expression, true) && compareDeep(provision, o.provision, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProvisionComponent))
          return false;
        ProvisionComponent o = (ProvisionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(period, actor, action, securityLabel
          , purpose, documentType, resourceType, code, dataPeriod, data, expression, provision
          );
      }

  public String fhirType() {
    return "Consent.provision";

  }

  }

    @Block()
    public static class ProvisionActorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * How the individual is involved in the resources content that is described in the exception.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="How the actor is involved", formalDefinition="How the individual is involved in the resources content that is described in the exception." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participation-role-type")
        protected CodeableConcept role;

        /**
         * The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers').
         */
        @Child(name = "reference", type = {Device.class, Group.class, CareTeam.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Resource for the actor (or group, by role)", formalDefinition="The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers')." )
        protected Reference reference;

        private static final long serialVersionUID = -1992921787L;

    /**
     * Constructor
     */
      public ProvisionActorComponent() {
        super();
      }

        /**
         * @return {@link #role} (How the individual is involved in the resources content that is described in the exception.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionActorComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (How the individual is involved in the resources content that is described in the exception.)
         */
        public ProvisionActorComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #reference} (The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers').)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionActorComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers').)
         */
        public ProvisionActorComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "How the individual is involved in the resources content that is described in the exception.", 0, 1, role));
          children.add(new Property("reference", "Reference(Device|Group|CareTeam|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "How the individual is involved in the resources content that is described in the exception.", 0, 1, role);
          case -925155509: /*reference*/  return new Property("reference", "Reference(Device|Group|CareTeam|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The resource that identifies the actor. To identify actors by type, use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public ProvisionActorComponent copy() {
        ProvisionActorComponent dst = new ProvisionActorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProvisionActorComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProvisionActorComponent))
          return false;
        ProvisionActorComponent o = (ProvisionActorComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProvisionActorComponent))
          return false;
        ProvisionActorComponent o = (ProvisionActorComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, reference);
      }

  public String fhirType() {
    return "Consent.provision.actor";

  }

  }

    @Block()
    public static class ProvisionDataComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * How the resource reference is interpreted when testing consent restrictions.
         */
        @Child(name = "meaning", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="instance | related | dependents | authoredby", formalDefinition="How the resource reference is interpreted when testing consent restrictions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-data-meaning")
        protected Enumeration<ConsentDataMeaning> meaning;

        /**
         * A reference to a specific resource that defines which resources are covered by this consent.
         */
        @Child(name = "reference", type = {Reference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual data reference", formalDefinition="A reference to a specific resource that defines which resources are covered by this consent." )
        protected Reference reference;

        private static final long serialVersionUID = 1735979153L;

    /**
     * Constructor
     */
      public ProvisionDataComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ProvisionDataComponent(ConsentDataMeaning meaning, Reference reference) {
        super();
        this.setMeaning(meaning);
        this.setReference(reference);
      }

        /**
         * @return {@link #meaning} (How the resource reference is interpreted when testing consent restrictions.). This is the underlying object with id, value and extensions. The accessor "getMeaning" gives direct access to the value
         */
        public Enumeration<ConsentDataMeaning> getMeaningElement() { 
          if (this.meaning == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionDataComponent.meaning");
            else if (Configuration.doAutoCreate())
              this.meaning = new Enumeration<ConsentDataMeaning>(new ConsentDataMeaningEnumFactory()); // bb
          return this.meaning;
        }

        public boolean hasMeaningElement() { 
          return this.meaning != null && !this.meaning.isEmpty();
        }

        public boolean hasMeaning() { 
          return this.meaning != null && !this.meaning.isEmpty();
        }

        /**
         * @param value {@link #meaning} (How the resource reference is interpreted when testing consent restrictions.). This is the underlying object with id, value and extensions. The accessor "getMeaning" gives direct access to the value
         */
        public ProvisionDataComponent setMeaningElement(Enumeration<ConsentDataMeaning> value) { 
          this.meaning = value;
          return this;
        }

        /**
         * @return How the resource reference is interpreted when testing consent restrictions.
         */
        public ConsentDataMeaning getMeaning() { 
          return this.meaning == null ? null : this.meaning.getValue();
        }

        /**
         * @param value How the resource reference is interpreted when testing consent restrictions.
         */
        public ProvisionDataComponent setMeaning(ConsentDataMeaning value) { 
            if (this.meaning == null)
              this.meaning = new Enumeration<ConsentDataMeaning>(new ConsentDataMeaningEnumFactory());
            this.meaning.setValue(value);
          return this;
        }

        /**
         * @return {@link #reference} (A reference to a specific resource that defines which resources are covered by this consent.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionDataComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (A reference to a specific resource that defines which resources are covered by this consent.)
         */
        public ProvisionDataComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("meaning", "code", "How the resource reference is interpreted when testing consent restrictions.", 0, 1, meaning));
          children.add(new Property("reference", "Reference(Any)", "A reference to a specific resource that defines which resources are covered by this consent.", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 938160637: /*meaning*/  return new Property("meaning", "code", "How the resource reference is interpreted when testing consent restrictions.", 0, 1, meaning);
          case -925155509: /*reference*/  return new Property("reference", "Reference(Any)", "A reference to a specific resource that defines which resources are covered by this consent.", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return this.meaning == null ? new Base[0] : new Base[] {this.meaning}; // Enumeration<ConsentDataMeaning>
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 938160637: // meaning
          value = new ConsentDataMeaningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.meaning = (Enumeration) value; // Enumeration<ConsentDataMeaning>
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("meaning")) {
          value = new ConsentDataMeaningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.meaning = (Enumeration) value; // Enumeration<ConsentDataMeaning>
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637:  return getMeaningElement();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return new String[] {"code"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("meaning")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.provision.data.meaning");
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public ProvisionDataComponent copy() {
        ProvisionDataComponent dst = new ProvisionDataComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProvisionDataComponent dst) {
        super.copyValues(dst);
        dst.meaning = meaning == null ? null : meaning.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProvisionDataComponent))
          return false;
        ProvisionDataComponent o = (ProvisionDataComponent) other_;
        return compareDeep(meaning, o.meaning, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProvisionDataComponent))
          return false;
        ProvisionDataComponent o = (ProvisionDataComponent) other_;
        return compareValues(meaning, o.meaning, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(meaning, reference);
      }

  public String fhirType() {
    return "Consent.provision.data";

  }

  }

    /**
     * Unique identifier for this copy of the Consent Statement.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifier for this record (external references)", formalDefinition="Unique identifier for this copy of the Consent Statement." )
    protected List<Identifier> identifier;

    /**
     * Indicates the current state of this Consent resource.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | inactive | not-done | entered-in-error | unknown", formalDefinition="Indicates the current state of this Consent resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-state-codes")
    protected Enumeration<ConsentState> status;

    /**
     * A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classification of the consent statement - for indexing/retrieval", formalDefinition="A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-category")
    protected List<CodeableConcept> category;

    /**
     * The patient/healthcare practitioner or group of persons to whom this consent applies.
     */
    @Child(name = "subject", type = {Patient.class, Practitioner.class, Group.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who the consent applies to", formalDefinition="The patient/healthcare practitioner or group of persons to whom this consent applies." )
    protected Reference subject;

    /**
     * Date the consent instance was agreed to.
     */
    @Child(name = "date", type = {DateType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Fully executed date of the consent", formalDefinition="Date the consent instance was agreed to." )
    protected DateType date;

    /**
     * Effective period for this Consent Resource and all provisions unless specified in that provision.
     */
    @Child(name = "period", type = {Period.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Effective period for this Consent", formalDefinition="Effective period for this Consent Resource and all provisions unless specified in that provision." )
    protected Period period;

    /**
     * The entity responsible for granting the rights listed in a Consent Directive.
     */
    @Child(name = "grantor", type = {CareTeam.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is granting rights according to the policy and rules", formalDefinition="The entity responsible for granting the rights listed in a Consent Directive." )
    protected List<Reference> grantor;

    /**
     * The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions.
     */
    @Child(name = "grantee", type = {CareTeam.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is agreeing to the policy and rules", formalDefinition="The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions." )
    protected List<Reference> grantee;

    /**
     * The actor that manages the consent through its lifecycle.
     */
    @Child(name = "manager", type = {HealthcareService.class, Organization.class, Patient.class, Practitioner.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Consent workflow management", formalDefinition="The actor that manages the consent through its lifecycle." )
    protected List<Reference> manager;

    /**
     * The actor that controls/enforces the access according to the consent.
     */
    @Child(name = "controller", type = {HealthcareService.class, Organization.class, Patient.class, Practitioner.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Consent Enforcer", formalDefinition="The actor that controls/enforces the access according to the consent." )
    protected List<Reference> controller;

    /**
     * The source on which this consent statement is based. The source might be a scanned original paper form.
     */
    @Child(name = "sourceAttachment", type = {Attachment.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Source from which this consent is taken", formalDefinition="The source on which this consent statement is based. The source might be a scanned original paper form." )
    protected List<Attachment> sourceAttachment;

    /**
     * A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document.
     */
    @Child(name = "sourceReference", type = {Consent.class, DocumentReference.class, Contract.class, QuestionnaireResponse.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Source from which this consent is taken", formalDefinition="A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document." )
    protected List<Reference> sourceReference;

    /**
     * A set of codes that indicate the regulatory basis (if any) that this consent supports.
     */
    @Child(name = "regulatoryBasis", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Regulations establishing base Consent", formalDefinition="A set of codes that indicate the regulatory basis (if any) that this consent supports." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-policy")
    protected List<CodeableConcept> regulatoryBasis;

    /**
     * A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.
     */
    @Child(name = "policyBasis", type = {}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Computable version of the backing policy", formalDefinition="A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form." )
    protected ConsentPolicyBasisComponent policyBasis;

    /**
     * A Reference to the human readable policy explaining the basis for the Consent.
     */
    @Child(name = "policyText", type = {DocumentReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Human Readable Policy", formalDefinition="A Reference to the human readable policy explaining the basis for the Consent." )
    protected List<Reference> policyText;

    /**
     * Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person.
     */
    @Child(name = "verification", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Consent Verified by patient or family", formalDefinition="Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person." )
    protected List<ConsentVerificationComponent> verification;

    /**
     * Action to take - permit or deny - as default.
     */
    @Child(name = "decision", type = {CodeType.class}, order=16, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="deny | permit", formalDefinition="Action to take - permit or deny - as default." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-provision-type")
    protected Enumeration<ConsentProvisionType> decision;

    /**
     * An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.
     */
    @Child(name = "provision", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Constraints to the base Consent.policyRule/Consent.policy", formalDefinition="An exception to the base policy of this consent. An exception can be an addition or removal of access permissions." )
    protected List<ProvisionComponent> provision;

    private static final long serialVersionUID = -1133978742L;

  /**
   * Constructor
   */
    public Consent() {
      super();
    }

  /**
   * Constructor
   */
    public Consent(ConsentState status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Unique identifier for this copy of the Consent Statement.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setIdentifier(List<Identifier> theIdentifier) { 
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

    public Consent addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Indicates the current state of this Consent resource.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ConsentState> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ConsentState>(new ConsentStateEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates the current state of this Consent resource.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Consent setStatusElement(Enumeration<ConsentState> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates the current state of this Consent resource.
     */
    public ConsentState getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates the current state of this Consent resource.
     */
    public Consent setStatus(ConsentState value) { 
        if (this.status == null)
          this.status = new Enumeration<ConsentState>(new ConsentStateEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setCategory(List<CodeableConcept> theCategory) { 
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

    public Consent addCategory(CodeableConcept t) { //3
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
     * @return {@link #subject} (The patient/healthcare practitioner or group of persons to whom this consent applies.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient/healthcare practitioner or group of persons to whom this consent applies.)
     */
    public Consent setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #date} (Date the consent instance was agreed to.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (Date the consent instance was agreed to.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Consent setDateElement(DateType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return Date the consent instance was agreed to.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value Date the consent instance was agreed to.
     */
    public Consent setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #period} (Effective period for this Consent Resource and all provisions unless specified in that provision.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Effective period for this Consent Resource and all provisions unless specified in that provision.)
     */
    public Consent setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #grantor} (The entity responsible for granting the rights listed in a Consent Directive.)
     */
    public List<Reference> getGrantor() { 
      if (this.grantor == null)
        this.grantor = new ArrayList<Reference>();
      return this.grantor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setGrantor(List<Reference> theGrantor) { 
      this.grantor = theGrantor;
      return this;
    }

    public boolean hasGrantor() { 
      if (this.grantor == null)
        return false;
      for (Reference item : this.grantor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addGrantor() { //3
      Reference t = new Reference();
      if (this.grantor == null)
        this.grantor = new ArrayList<Reference>();
      this.grantor.add(t);
      return t;
    }

    public Consent addGrantor(Reference t) { //3
      if (t == null)
        return this;
      if (this.grantor == null)
        this.grantor = new ArrayList<Reference>();
      this.grantor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #grantor}, creating it if it does not already exist {3}
     */
    public Reference getGrantorFirstRep() { 
      if (getGrantor().isEmpty()) {
        addGrantor();
      }
      return getGrantor().get(0);
    }

    /**
     * @return {@link #grantee} (The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions.)
     */
    public List<Reference> getGrantee() { 
      if (this.grantee == null)
        this.grantee = new ArrayList<Reference>();
      return this.grantee;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setGrantee(List<Reference> theGrantee) { 
      this.grantee = theGrantee;
      return this;
    }

    public boolean hasGrantee() { 
      if (this.grantee == null)
        return false;
      for (Reference item : this.grantee)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addGrantee() { //3
      Reference t = new Reference();
      if (this.grantee == null)
        this.grantee = new ArrayList<Reference>();
      this.grantee.add(t);
      return t;
    }

    public Consent addGrantee(Reference t) { //3
      if (t == null)
        return this;
      if (this.grantee == null)
        this.grantee = new ArrayList<Reference>();
      this.grantee.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #grantee}, creating it if it does not already exist {3}
     */
    public Reference getGranteeFirstRep() { 
      if (getGrantee().isEmpty()) {
        addGrantee();
      }
      return getGrantee().get(0);
    }

    /**
     * @return {@link #manager} (The actor that manages the consent through its lifecycle.)
     */
    public List<Reference> getManager() { 
      if (this.manager == null)
        this.manager = new ArrayList<Reference>();
      return this.manager;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setManager(List<Reference> theManager) { 
      this.manager = theManager;
      return this;
    }

    public boolean hasManager() { 
      if (this.manager == null)
        return false;
      for (Reference item : this.manager)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addManager() { //3
      Reference t = new Reference();
      if (this.manager == null)
        this.manager = new ArrayList<Reference>();
      this.manager.add(t);
      return t;
    }

    public Consent addManager(Reference t) { //3
      if (t == null)
        return this;
      if (this.manager == null)
        this.manager = new ArrayList<Reference>();
      this.manager.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #manager}, creating it if it does not already exist {3}
     */
    public Reference getManagerFirstRep() { 
      if (getManager().isEmpty()) {
        addManager();
      }
      return getManager().get(0);
    }

    /**
     * @return {@link #controller} (The actor that controls/enforces the access according to the consent.)
     */
    public List<Reference> getController() { 
      if (this.controller == null)
        this.controller = new ArrayList<Reference>();
      return this.controller;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setController(List<Reference> theController) { 
      this.controller = theController;
      return this;
    }

    public boolean hasController() { 
      if (this.controller == null)
        return false;
      for (Reference item : this.controller)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addController() { //3
      Reference t = new Reference();
      if (this.controller == null)
        this.controller = new ArrayList<Reference>();
      this.controller.add(t);
      return t;
    }

    public Consent addController(Reference t) { //3
      if (t == null)
        return this;
      if (this.controller == null)
        this.controller = new ArrayList<Reference>();
      this.controller.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #controller}, creating it if it does not already exist {3}
     */
    public Reference getControllerFirstRep() { 
      if (getController().isEmpty()) {
        addController();
      }
      return getController().get(0);
    }

    /**
     * @return {@link #sourceAttachment} (The source on which this consent statement is based. The source might be a scanned original paper form.)
     */
    public List<Attachment> getSourceAttachment() { 
      if (this.sourceAttachment == null)
        this.sourceAttachment = new ArrayList<Attachment>();
      return this.sourceAttachment;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setSourceAttachment(List<Attachment> theSourceAttachment) { 
      this.sourceAttachment = theSourceAttachment;
      return this;
    }

    public boolean hasSourceAttachment() { 
      if (this.sourceAttachment == null)
        return false;
      for (Attachment item : this.sourceAttachment)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addSourceAttachment() { //3
      Attachment t = new Attachment();
      if (this.sourceAttachment == null)
        this.sourceAttachment = new ArrayList<Attachment>();
      this.sourceAttachment.add(t);
      return t;
    }

    public Consent addSourceAttachment(Attachment t) { //3
      if (t == null)
        return this;
      if (this.sourceAttachment == null)
        this.sourceAttachment = new ArrayList<Attachment>();
      this.sourceAttachment.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #sourceAttachment}, creating it if it does not already exist {3}
     */
    public Attachment getSourceAttachmentFirstRep() { 
      if (getSourceAttachment().isEmpty()) {
        addSourceAttachment();
      }
      return getSourceAttachment().get(0);
    }

    /**
     * @return {@link #sourceReference} (A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document.)
     */
    public List<Reference> getSourceReference() { 
      if (this.sourceReference == null)
        this.sourceReference = new ArrayList<Reference>();
      return this.sourceReference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setSourceReference(List<Reference> theSourceReference) { 
      this.sourceReference = theSourceReference;
      return this;
    }

    public boolean hasSourceReference() { 
      if (this.sourceReference == null)
        return false;
      for (Reference item : this.sourceReference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSourceReference() { //3
      Reference t = new Reference();
      if (this.sourceReference == null)
        this.sourceReference = new ArrayList<Reference>();
      this.sourceReference.add(t);
      return t;
    }

    public Consent addSourceReference(Reference t) { //3
      if (t == null)
        return this;
      if (this.sourceReference == null)
        this.sourceReference = new ArrayList<Reference>();
      this.sourceReference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #sourceReference}, creating it if it does not already exist {3}
     */
    public Reference getSourceReferenceFirstRep() { 
      if (getSourceReference().isEmpty()) {
        addSourceReference();
      }
      return getSourceReference().get(0);
    }

    /**
     * @return {@link #regulatoryBasis} (A set of codes that indicate the regulatory basis (if any) that this consent supports.)
     */
    public List<CodeableConcept> getRegulatoryBasis() { 
      if (this.regulatoryBasis == null)
        this.regulatoryBasis = new ArrayList<CodeableConcept>();
      return this.regulatoryBasis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setRegulatoryBasis(List<CodeableConcept> theRegulatoryBasis) { 
      this.regulatoryBasis = theRegulatoryBasis;
      return this;
    }

    public boolean hasRegulatoryBasis() { 
      if (this.regulatoryBasis == null)
        return false;
      for (CodeableConcept item : this.regulatoryBasis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addRegulatoryBasis() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.regulatoryBasis == null)
        this.regulatoryBasis = new ArrayList<CodeableConcept>();
      this.regulatoryBasis.add(t);
      return t;
    }

    public Consent addRegulatoryBasis(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.regulatoryBasis == null)
        this.regulatoryBasis = new ArrayList<CodeableConcept>();
      this.regulatoryBasis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #regulatoryBasis}, creating it if it does not already exist {3}
     */
    public CodeableConcept getRegulatoryBasisFirstRep() { 
      if (getRegulatoryBasis().isEmpty()) {
        addRegulatoryBasis();
      }
      return getRegulatoryBasis().get(0);
    }

    /**
     * @return {@link #policyBasis} (A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.)
     */
    public ConsentPolicyBasisComponent getPolicyBasis() { 
      if (this.policyBasis == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.policyBasis");
        else if (Configuration.doAutoCreate())
          this.policyBasis = new ConsentPolicyBasisComponent(); // cc
      return this.policyBasis;
    }

    public boolean hasPolicyBasis() { 
      return this.policyBasis != null && !this.policyBasis.isEmpty();
    }

    /**
     * @param value {@link #policyBasis} (A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.)
     */
    public Consent setPolicyBasis(ConsentPolicyBasisComponent value) { 
      this.policyBasis = value;
      return this;
    }

    /**
     * @return {@link #policyText} (A Reference to the human readable policy explaining the basis for the Consent.)
     */
    public List<Reference> getPolicyText() { 
      if (this.policyText == null)
        this.policyText = new ArrayList<Reference>();
      return this.policyText;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setPolicyText(List<Reference> thePolicyText) { 
      this.policyText = thePolicyText;
      return this;
    }

    public boolean hasPolicyText() { 
      if (this.policyText == null)
        return false;
      for (Reference item : this.policyText)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPolicyText() { //3
      Reference t = new Reference();
      if (this.policyText == null)
        this.policyText = new ArrayList<Reference>();
      this.policyText.add(t);
      return t;
    }

    public Consent addPolicyText(Reference t) { //3
      if (t == null)
        return this;
      if (this.policyText == null)
        this.policyText = new ArrayList<Reference>();
      this.policyText.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #policyText}, creating it if it does not already exist {3}
     */
    public Reference getPolicyTextFirstRep() { 
      if (getPolicyText().isEmpty()) {
        addPolicyText();
      }
      return getPolicyText().get(0);
    }

    /**
     * @return {@link #verification} (Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person.)
     */
    public List<ConsentVerificationComponent> getVerification() { 
      if (this.verification == null)
        this.verification = new ArrayList<ConsentVerificationComponent>();
      return this.verification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setVerification(List<ConsentVerificationComponent> theVerification) { 
      this.verification = theVerification;
      return this;
    }

    public boolean hasVerification() { 
      if (this.verification == null)
        return false;
      for (ConsentVerificationComponent item : this.verification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConsentVerificationComponent addVerification() { //3
      ConsentVerificationComponent t = new ConsentVerificationComponent();
      if (this.verification == null)
        this.verification = new ArrayList<ConsentVerificationComponent>();
      this.verification.add(t);
      return t;
    }

    public Consent addVerification(ConsentVerificationComponent t) { //3
      if (t == null)
        return this;
      if (this.verification == null)
        this.verification = new ArrayList<ConsentVerificationComponent>();
      this.verification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #verification}, creating it if it does not already exist {3}
     */
    public ConsentVerificationComponent getVerificationFirstRep() { 
      if (getVerification().isEmpty()) {
        addVerification();
      }
      return getVerification().get(0);
    }

    /**
     * @return {@link #decision} (Action to take - permit or deny - as default.). This is the underlying object with id, value and extensions. The accessor "getDecision" gives direct access to the value
     */
    public Enumeration<ConsentProvisionType> getDecisionElement() { 
      if (this.decision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.decision");
        else if (Configuration.doAutoCreate())
          this.decision = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory()); // bb
      return this.decision;
    }

    public boolean hasDecisionElement() { 
      return this.decision != null && !this.decision.isEmpty();
    }

    public boolean hasDecision() { 
      return this.decision != null && !this.decision.isEmpty();
    }

    /**
     * @param value {@link #decision} (Action to take - permit or deny - as default.). This is the underlying object with id, value and extensions. The accessor "getDecision" gives direct access to the value
     */
    public Consent setDecisionElement(Enumeration<ConsentProvisionType> value) { 
      this.decision = value;
      return this;
    }

    /**
     * @return Action to take - permit or deny - as default.
     */
    public ConsentProvisionType getDecision() { 
      return this.decision == null ? null : this.decision.getValue();
    }

    /**
     * @param value Action to take - permit or deny - as default.
     */
    public Consent setDecision(ConsentProvisionType value) { 
      if (value == null)
        this.decision = null;
      else {
        if (this.decision == null)
          this.decision = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory());
        this.decision.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #provision} (An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.)
     */
    public List<ProvisionComponent> getProvision() { 
      if (this.provision == null)
        this.provision = new ArrayList<ProvisionComponent>();
      return this.provision;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Consent setProvision(List<ProvisionComponent> theProvision) { 
      this.provision = theProvision;
      return this;
    }

    public boolean hasProvision() { 
      if (this.provision == null)
        return false;
      for (ProvisionComponent item : this.provision)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProvisionComponent addProvision() { //3
      ProvisionComponent t = new ProvisionComponent();
      if (this.provision == null)
        this.provision = new ArrayList<ProvisionComponent>();
      this.provision.add(t);
      return t;
    }

    public Consent addProvision(ProvisionComponent t) { //3
      if (t == null)
        return this;
      if (this.provision == null)
        this.provision = new ArrayList<ProvisionComponent>();
      this.provision.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #provision}, creating it if it does not already exist {3}
     */
    public ProvisionComponent getProvisionFirstRep() { 
      if (getProvision().isEmpty()) {
        addProvision();
      }
      return getProvision().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier for this copy of the Consent Statement.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Indicates the current state of this Consent resource.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("subject", "Reference(Patient|Practitioner|Group)", "The patient/healthcare practitioner or group of persons to whom this consent applies.", 0, 1, subject));
        children.add(new Property("date", "date", "Date the consent instance was agreed to.", 0, 1, date));
        children.add(new Property("period", "Period", "Effective period for this Consent Resource and all provisions unless specified in that provision.", 0, 1, period));
        children.add(new Property("grantor", "Reference(CareTeam|HealthcareService|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The entity responsible for granting the rights listed in a Consent Directive.", 0, java.lang.Integer.MAX_VALUE, grantor));
        children.add(new Property("grantee", "Reference(CareTeam|HealthcareService|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions.", 0, java.lang.Integer.MAX_VALUE, grantee));
        children.add(new Property("manager", "Reference(HealthcareService|Organization|Patient|Practitioner)", "The actor that manages the consent through its lifecycle.", 0, java.lang.Integer.MAX_VALUE, manager));
        children.add(new Property("controller", "Reference(HealthcareService|Organization|Patient|Practitioner)", "The actor that controls/enforces the access according to the consent.", 0, java.lang.Integer.MAX_VALUE, controller));
        children.add(new Property("sourceAttachment", "Attachment", "The source on which this consent statement is based. The source might be a scanned original paper form.", 0, java.lang.Integer.MAX_VALUE, sourceAttachment));
        children.add(new Property("sourceReference", "Reference(Consent|DocumentReference|Contract|QuestionnaireResponse)", "A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document.", 0, java.lang.Integer.MAX_VALUE, sourceReference));
        children.add(new Property("regulatoryBasis", "CodeableConcept", "A set of codes that indicate the regulatory basis (if any) that this consent supports.", 0, java.lang.Integer.MAX_VALUE, regulatoryBasis));
        children.add(new Property("policyBasis", "", "A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.", 0, 1, policyBasis));
        children.add(new Property("policyText", "Reference(DocumentReference)", "A Reference to the human readable policy explaining the basis for the Consent.", 0, java.lang.Integer.MAX_VALUE, policyText));
        children.add(new Property("verification", "", "Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person.", 0, java.lang.Integer.MAX_VALUE, verification));
        children.add(new Property("decision", "code", "Action to take - permit or deny - as default.", 0, 1, decision));
        children.add(new Property("provision", "", "An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.", 0, java.lang.Integer.MAX_VALUE, provision));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier for this copy of the Consent Statement.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates the current state of this Consent resource.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Practitioner|Group)", "The patient/healthcare practitioner or group of persons to whom this consent applies.", 0, 1, subject);
        case 3076014: /*date*/  return new Property("date", "date", "Date the consent instance was agreed to.", 0, 1, date);
        case -991726143: /*period*/  return new Property("period", "Period", "Effective period for this Consent Resource and all provisions unless specified in that provision.", 0, 1, period);
        case 280295423: /*grantor*/  return new Property("grantor", "Reference(CareTeam|HealthcareService|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The entity responsible for granting the rights listed in a Consent Directive.", 0, java.lang.Integer.MAX_VALUE, grantor);
        case 280295100: /*grantee*/  return new Property("grantee", "Reference(CareTeam|HealthcareService|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions.", 0, java.lang.Integer.MAX_VALUE, grantee);
        case 835260333: /*manager*/  return new Property("manager", "Reference(HealthcareService|Organization|Patient|Practitioner)", "The actor that manages the consent through its lifecycle.", 0, java.lang.Integer.MAX_VALUE, manager);
        case 637428636: /*controller*/  return new Property("controller", "Reference(HealthcareService|Organization|Patient|Practitioner)", "The actor that controls/enforces the access according to the consent.", 0, java.lang.Integer.MAX_VALUE, controller);
        case 1964406686: /*sourceAttachment*/  return new Property("sourceAttachment", "Attachment", "The source on which this consent statement is based. The source might be a scanned original paper form.", 0, java.lang.Integer.MAX_VALUE, sourceAttachment);
        case -244259472: /*sourceReference*/  return new Property("sourceReference", "Reference(Consent|DocumentReference|Contract|QuestionnaireResponse)", "A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document.", 0, java.lang.Integer.MAX_VALUE, sourceReference);
        case -1780301690: /*regulatoryBasis*/  return new Property("regulatoryBasis", "CodeableConcept", "A set of codes that indicate the regulatory basis (if any) that this consent supports.", 0, java.lang.Integer.MAX_VALUE, regulatoryBasis);
        case 2138287660: /*policyBasis*/  return new Property("policyBasis", "", "A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.", 0, 1, policyBasis);
        case 1593537919: /*policyText*/  return new Property("policyText", "Reference(DocumentReference)", "A Reference to the human readable policy explaining the basis for the Consent.", 0, java.lang.Integer.MAX_VALUE, policyText);
        case -1484401125: /*verification*/  return new Property("verification", "", "Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person.", 0, java.lang.Integer.MAX_VALUE, verification);
        case 565719004: /*decision*/  return new Property("decision", "code", "Action to take - permit or deny - as default.", 0, 1, decision);
        case -547120939: /*provision*/  return new Property("provision", "", "An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.", 0, java.lang.Integer.MAX_VALUE, provision);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ConsentState>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 280295423: /*grantor*/ return this.grantor == null ? new Base[0] : this.grantor.toArray(new Base[this.grantor.size()]); // Reference
        case 280295100: /*grantee*/ return this.grantee == null ? new Base[0] : this.grantee.toArray(new Base[this.grantee.size()]); // Reference
        case 835260333: /*manager*/ return this.manager == null ? new Base[0] : this.manager.toArray(new Base[this.manager.size()]); // Reference
        case 637428636: /*controller*/ return this.controller == null ? new Base[0] : this.controller.toArray(new Base[this.controller.size()]); // Reference
        case 1964406686: /*sourceAttachment*/ return this.sourceAttachment == null ? new Base[0] : this.sourceAttachment.toArray(new Base[this.sourceAttachment.size()]); // Attachment
        case -244259472: /*sourceReference*/ return this.sourceReference == null ? new Base[0] : this.sourceReference.toArray(new Base[this.sourceReference.size()]); // Reference
        case -1780301690: /*regulatoryBasis*/ return this.regulatoryBasis == null ? new Base[0] : this.regulatoryBasis.toArray(new Base[this.regulatoryBasis.size()]); // CodeableConcept
        case 2138287660: /*policyBasis*/ return this.policyBasis == null ? new Base[0] : new Base[] {this.policyBasis}; // ConsentPolicyBasisComponent
        case 1593537919: /*policyText*/ return this.policyText == null ? new Base[0] : this.policyText.toArray(new Base[this.policyText.size()]); // Reference
        case -1484401125: /*verification*/ return this.verification == null ? new Base[0] : this.verification.toArray(new Base[this.verification.size()]); // ConsentVerificationComponent
        case 565719004: /*decision*/ return this.decision == null ? new Base[0] : new Base[] {this.decision}; // Enumeration<ConsentProvisionType>
        case -547120939: /*provision*/ return this.provision == null ? new Base[0] : this.provision.toArray(new Base[this.provision.size()]); // ProvisionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new ConsentStateEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ConsentState>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDate(value); // DateType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 280295423: // grantor
          this.getGrantor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 280295100: // grantee
          this.getGrantee().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 835260333: // manager
          this.getManager().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 637428636: // controller
          this.getController().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1964406686: // sourceAttachment
          this.getSourceAttachment().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -244259472: // sourceReference
          this.getSourceReference().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1780301690: // regulatoryBasis
          this.getRegulatoryBasis().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 2138287660: // policyBasis
          this.policyBasis = (ConsentPolicyBasisComponent) value; // ConsentPolicyBasisComponent
          return value;
        case 1593537919: // policyText
          this.getPolicyText().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1484401125: // verification
          this.getVerification().add((ConsentVerificationComponent) value); // ConsentVerificationComponent
          return value;
        case 565719004: // decision
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.decision = (Enumeration) value; // Enumeration<ConsentProvisionType>
          return value;
        case -547120939: // provision
          this.getProvision().add((ProvisionComponent) value); // ProvisionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new ConsentStateEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ConsentState>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("grantor")) {
          this.getGrantor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("grantee")) {
          this.getGrantee().add(TypeConvertor.castToReference(value));
        } else if (name.equals("manager")) {
          this.getManager().add(TypeConvertor.castToReference(value));
        } else if (name.equals("controller")) {
          this.getController().add(TypeConvertor.castToReference(value));
        } else if (name.equals("sourceAttachment")) {
          this.getSourceAttachment().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("sourceReference")) {
          this.getSourceReference().add(TypeConvertor.castToReference(value));
        } else if (name.equals("regulatoryBasis")) {
          this.getRegulatoryBasis().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("policyBasis")) {
          this.policyBasis = (ConsentPolicyBasisComponent) value; // ConsentPolicyBasisComponent
        } else if (name.equals("policyText")) {
          this.getPolicyText().add(TypeConvertor.castToReference(value));
        } else if (name.equals("verification")) {
          this.getVerification().add((ConsentVerificationComponent) value);
        } else if (name.equals("decision")) {
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.decision = (Enumeration) value; // Enumeration<ConsentProvisionType>
        } else if (name.equals("provision")) {
          this.getProvision().add((ProvisionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case -1867885268:  return getSubject();
        case 3076014:  return getDateElement();
        case -991726143:  return getPeriod();
        case 280295423:  return addGrantor(); 
        case 280295100:  return addGrantee(); 
        case 835260333:  return addManager(); 
        case 637428636:  return addController(); 
        case 1964406686:  return addSourceAttachment(); 
        case -244259472:  return addSourceReference(); 
        case -1780301690:  return addRegulatoryBasis(); 
        case 2138287660:  return getPolicyBasis();
        case 1593537919:  return addPolicyText(); 
        case -1484401125:  return addVerification(); 
        case 565719004:  return getDecisionElement();
        case -547120939:  return addProvision(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"date"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 280295423: /*grantor*/ return new String[] {"Reference"};
        case 280295100: /*grantee*/ return new String[] {"Reference"};
        case 835260333: /*manager*/ return new String[] {"Reference"};
        case 637428636: /*controller*/ return new String[] {"Reference"};
        case 1964406686: /*sourceAttachment*/ return new String[] {"Attachment"};
        case -244259472: /*sourceReference*/ return new String[] {"Reference"};
        case -1780301690: /*regulatoryBasis*/ return new String[] {"CodeableConcept"};
        case 2138287660: /*policyBasis*/ return new String[] {};
        case 1593537919: /*policyText*/ return new String[] {"Reference"};
        case -1484401125: /*verification*/ return new String[] {};
        case 565719004: /*decision*/ return new String[] {"code"};
        case -547120939: /*provision*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.date");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("grantor")) {
          return addGrantor();
        }
        else if (name.equals("grantee")) {
          return addGrantee();
        }
        else if (name.equals("manager")) {
          return addManager();
        }
        else if (name.equals("controller")) {
          return addController();
        }
        else if (name.equals("sourceAttachment")) {
          return addSourceAttachment();
        }
        else if (name.equals("sourceReference")) {
          return addSourceReference();
        }
        else if (name.equals("regulatoryBasis")) {
          return addRegulatoryBasis();
        }
        else if (name.equals("policyBasis")) {
          this.policyBasis = new ConsentPolicyBasisComponent();
          return this.policyBasis;
        }
        else if (name.equals("policyText")) {
          return addPolicyText();
        }
        else if (name.equals("verification")) {
          return addVerification();
        }
        else if (name.equals("decision")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.decision");
        }
        else if (name.equals("provision")) {
          return addProvision();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Consent";

  }

      public Consent copy() {
        Consent dst = new Consent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Consent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.date = date == null ? null : date.copy();
        dst.period = period == null ? null : period.copy();
        if (grantor != null) {
          dst.grantor = new ArrayList<Reference>();
          for (Reference i : grantor)
            dst.grantor.add(i.copy());
        };
        if (grantee != null) {
          dst.grantee = new ArrayList<Reference>();
          for (Reference i : grantee)
            dst.grantee.add(i.copy());
        };
        if (manager != null) {
          dst.manager = new ArrayList<Reference>();
          for (Reference i : manager)
            dst.manager.add(i.copy());
        };
        if (controller != null) {
          dst.controller = new ArrayList<Reference>();
          for (Reference i : controller)
            dst.controller.add(i.copy());
        };
        if (sourceAttachment != null) {
          dst.sourceAttachment = new ArrayList<Attachment>();
          for (Attachment i : sourceAttachment)
            dst.sourceAttachment.add(i.copy());
        };
        if (sourceReference != null) {
          dst.sourceReference = new ArrayList<Reference>();
          for (Reference i : sourceReference)
            dst.sourceReference.add(i.copy());
        };
        if (regulatoryBasis != null) {
          dst.regulatoryBasis = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : regulatoryBasis)
            dst.regulatoryBasis.add(i.copy());
        };
        dst.policyBasis = policyBasis == null ? null : policyBasis.copy();
        if (policyText != null) {
          dst.policyText = new ArrayList<Reference>();
          for (Reference i : policyText)
            dst.policyText.add(i.copy());
        };
        if (verification != null) {
          dst.verification = new ArrayList<ConsentVerificationComponent>();
          for (ConsentVerificationComponent i : verification)
            dst.verification.add(i.copy());
        };
        dst.decision = decision == null ? null : decision.copy();
        if (provision != null) {
          dst.provision = new ArrayList<ProvisionComponent>();
          for (ProvisionComponent i : provision)
            dst.provision.add(i.copy());
        };
      }

      protected Consent typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Consent))
          return false;
        Consent o = (Consent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(category, o.category, true)
           && compareDeep(subject, o.subject, true) && compareDeep(date, o.date, true) && compareDeep(period, o.period, true)
           && compareDeep(grantor, o.grantor, true) && compareDeep(grantee, o.grantee, true) && compareDeep(manager, o.manager, true)
           && compareDeep(controller, o.controller, true) && compareDeep(sourceAttachment, o.sourceAttachment, true)
           && compareDeep(sourceReference, o.sourceReference, true) && compareDeep(regulatoryBasis, o.regulatoryBasis, true)
           && compareDeep(policyBasis, o.policyBasis, true) && compareDeep(policyText, o.policyText, true)
           && compareDeep(verification, o.verification, true) && compareDeep(decision, o.decision, true) && compareDeep(provision, o.provision, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Consent))
          return false;
        Consent o = (Consent) other_;
        return compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(decision, o.decision, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, category
          , subject, date, period, grantor, grantee, manager, controller, sourceAttachment
          , sourceReference, regulatoryBasis, policyBasis, policyText, verification, decision
          , provision);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Consent;
   }

 /**
   * Search parameter: <b>action</b>
   * <p>
   * Description: <b>Actions controlled by this rule</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.action</b><br>
   * </p>
   */
  @SearchParamDefinition(name="action", path="Consent.provision.action", description="Actions controlled by this rule", type="token" )
  public static final String SP_ACTION = "action";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>action</b>
   * <p>
   * Description: <b>Actions controlled by this rule</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.action</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTION);

 /**
   * Search parameter: <b>actor</b>
   * <p>
   * Description: <b>Resource for the actor (or group, by role)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.provision.actor.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="actor", path="Consent.provision.actor.reference", description="Resource for the actor (or group, by role)", type="reference", target={CareTeam.class, Device.class, Group.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_ACTOR = "actor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>actor</b>
   * <p>
   * Description: <b>Resource for the actor (or group, by role)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.provision.actor.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:actor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACTOR = new ca.uhn.fhir.model.api.Include("Consent:actor").toLocked();

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Classification of the consent statement - for indexing/retrieval</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="Consent.category", description="Classification of the consent statement - for indexing/retrieval", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Classification of the consent statement - for indexing/retrieval</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>controller</b>
   * <p>
   * Description: <b>Consent Enforcer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.controller</b><br>
   * </p>
   */
  @SearchParamDefinition(name="controller", path="Consent.controller", description="Consent Enforcer", type="reference", target={HealthcareService.class, Organization.class, Patient.class, Practitioner.class } )
  public static final String SP_CONTROLLER = "controller";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>controller</b>
   * <p>
   * Description: <b>Consent Enforcer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.controller</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTROLLER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTROLLER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:controller</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTROLLER = new ca.uhn.fhir.model.api.Include("Consent:controller").toLocked();

 /**
   * Search parameter: <b>data</b>
   * <p>
   * Description: <b>The actual data reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.provision.data.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="data", path="Consent.provision.data.reference", description="The actual data reference", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DATA = "data";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>data</b>
   * <p>
   * Description: <b>The actual data reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.provision.data.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DATA = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DATA);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:data</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DATA = new ca.uhn.fhir.model.api.Include("Consent:data").toLocked();

 /**
   * Search parameter: <b>grantee</b>
   * <p>
   * Description: <b>Who is agreeing to the policy and rules</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.grantee</b><br>
   * </p>
   */
  @SearchParamDefinition(name="grantee", path="Consent.grantee", description="Who is agreeing to the policy and rules", type="reference", target={CareTeam.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_GRANTEE = "grantee";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>grantee</b>
   * <p>
   * Description: <b>Who is agreeing to the policy and rules</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.grantee</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam GRANTEE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_GRANTEE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:grantee</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_GRANTEE = new ca.uhn.fhir.model.api.Include("Consent:grantee").toLocked();

 /**
   * Search parameter: <b>manager</b>
   * <p>
   * Description: <b>Consent workflow management</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.manager</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manager", path="Consent.manager", description="Consent workflow management", type="reference", target={HealthcareService.class, Organization.class, Patient.class, Practitioner.class } )
  public static final String SP_MANAGER = "manager";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manager</b>
   * <p>
   * Description: <b>Consent workflow management</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.manager</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANAGER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANAGER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:manager</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANAGER = new ca.uhn.fhir.model.api.Include("Consent:manager").toLocked();

 /**
   * Search parameter: <b>period</b>
   * <p>
   * Description: <b>Timeframe for this rule</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Consent.provision.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="period", path="Consent.provision.period", description="Timeframe for this rule", type="date" )
  public static final String SP_PERIOD = "period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>period</b>
   * <p>
   * Description: <b>Timeframe for this rule</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Consent.provision.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_PERIOD);

 /**
   * Search parameter: <b>purpose</b>
   * <p>
   * Description: <b>Context of activities covered by this rule</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.purpose</b><br>
   * </p>
   */
  @SearchParamDefinition(name="purpose", path="Consent.provision.purpose", description="Context of activities covered by this rule", type="token" )
  public static final String SP_PURPOSE = "purpose";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>purpose</b>
   * <p>
   * Description: <b>Context of activities covered by this rule</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.purpose</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PURPOSE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PURPOSE);

 /**
   * Search parameter: <b>security-label</b>
   * <p>
   * Description: <b>Security Labels that define affected resources</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.securityLabel</b><br>
   * </p>
   */
  @SearchParamDefinition(name="security-label", path="Consent.provision.securityLabel", description="Security Labels that define affected resources", type="token" )
  public static final String SP_SECURITY_LABEL = "security-label";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>security-label</b>
   * <p>
   * Description: <b>Security Labels that define affected resources</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.provision.securityLabel</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SECURITY_LABEL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SECURITY_LABEL);

 /**
   * Search parameter: <b>source-reference</b>
   * <p>
   * Description: <b>Search by reference to a Consent, DocumentReference, Contract  or QuestionnaireResponse</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.sourceReference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-reference", path="Consent.sourceReference", description="Search by reference to a Consent, DocumentReference, Contract  or QuestionnaireResponse", type="reference", target={Consent.class, Contract.class, DocumentReference.class, QuestionnaireResponse.class } )
  public static final String SP_SOURCE_REFERENCE = "source-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-reference</b>
   * <p>
   * Description: <b>Search by reference to a Consent, DocumentReference, Contract  or QuestionnaireResponse</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.sourceReference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:source-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE_REFERENCE = new ca.uhn.fhir.model.api.Include("Consent:source-reference").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | inactive | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Consent.status", description="draft | active | inactive | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | inactive | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who the consent applies to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Consent.subject", description="Who the consent applies to", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class, Practitioner.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who the consent applies to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Consent.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Consent:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Consent:subject").toLocked();

 /**
   * Search parameter: <b>verified-date</b>
   * <p>
   * Description: <b>When consent verified</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Consent.verification.verificationDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="verified-date", path="Consent.verification.verificationDate", description="When consent verified", type="date" )
  public static final String SP_VERIFIED_DATE = "verified-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>verified-date</b>
   * <p>
   * Description: <b>When consent verified</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Consent.verification.verificationDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam VERIFIED_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_VERIFIED_DATE);

 /**
   * Search parameter: <b>verified</b>
   * <p>
   * Description: <b>Has been verified</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.verification.verified</b><br>
   * </p>
   */
  @SearchParamDefinition(name="verified", path="Consent.verification.verified", description="Has been verified", type="token" )
  public static final String SP_VERIFIED = "verified";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>verified</b>
   * <p>
   * Description: <b>Has been verified</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Consent.verification.verified</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERIFIED = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERIFIED);

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
   * the path value of "<b>Consent:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Consent:patient").toLocked();


}

