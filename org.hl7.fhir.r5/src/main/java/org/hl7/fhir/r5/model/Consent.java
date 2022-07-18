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
 * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
 */
@ResourceDef(name="Consent", profile="http://hl7.org/fhir/StructureDefinition/Consent")
public class Consent extends DomainResource {

    public enum ConsentDataMeaning {
        /**
         * The consent applies directly to the instance of the resource.
         */
        INSTANCE, 
        /**
         * The consent applies directly to the instance of the resource and instances it refers to.
         */
        RELATED, 
        /**
         * The consent applies directly to the instance of the resource and instances that refer to it.
         */
        DEPENDENTS, 
        /**
         * The consent applies to instances of resources that are authored by.
         */
        AUTHOREDBY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConsentDataMeaning fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return INSTANCE;
        if ("related".equals(codeString))
          return RELATED;
        if ("dependents".equals(codeString))
          return DEPENDENTS;
        if ("authoredby".equals(codeString))
          return AUTHOREDBY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INSTANCE: return "instance";
            case RELATED: return "related";
            case DEPENDENTS: return "dependents";
            case AUTHOREDBY: return "authoredby";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INSTANCE: return "http://hl7.org/fhir/consent-data-meaning";
            case RELATED: return "http://hl7.org/fhir/consent-data-meaning";
            case DEPENDENTS: return "http://hl7.org/fhir/consent-data-meaning";
            case AUTHOREDBY: return "http://hl7.org/fhir/consent-data-meaning";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INSTANCE: return "The consent applies directly to the instance of the resource.";
            case RELATED: return "The consent applies directly to the instance of the resource and instances it refers to.";
            case DEPENDENTS: return "The consent applies directly to the instance of the resource and instances that refer to it.";
            case AUTHOREDBY: return "The consent applies to instances of resources that are authored by.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTANCE: return "Instance";
            case RELATED: return "Related";
            case DEPENDENTS: return "Dependents";
            case AUTHOREDBY: return "AuthoredBy";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConsentDataMeaningEnumFactory implements EnumFactory<ConsentDataMeaning> {
    public ConsentDataMeaning fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return ConsentDataMeaning.INSTANCE;
        if ("related".equals(codeString))
          return ConsentDataMeaning.RELATED;
        if ("dependents".equals(codeString))
          return ConsentDataMeaning.DEPENDENTS;
        if ("authoredby".equals(codeString))
          return ConsentDataMeaning.AUTHOREDBY;
        throw new IllegalArgumentException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
        public Enumeration<ConsentDataMeaning> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentDataMeaning>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("instance".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.INSTANCE);
        if ("related".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.RELATED);
        if ("dependents".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.DEPENDENTS);
        if ("authoredby".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.AUTHOREDBY);
        throw new FHIRException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
    public String toCode(ConsentDataMeaning code) {
      if (code == ConsentDataMeaning.INSTANCE)
        return "instance";
      if (code == ConsentDataMeaning.RELATED)
        return "related";
      if (code == ConsentDataMeaning.DEPENDENTS)
        return "dependents";
      if (code == ConsentDataMeaning.AUTHOREDBY)
        return "authoredby";
      return "?";
      }
    public String toSystem(ConsentDataMeaning code) {
      return code.getSystem();
      }
    }

    public enum ConsentProvisionType {
        /**
         * Consent is denied for actions meeting these rules.
         */
        DENY, 
        /**
         * Consent is provided for actions meeting these rules.
         */
        PERMIT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConsentProvisionType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny".equals(codeString))
          return DENY;
        if ("permit".equals(codeString))
          return PERMIT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DENY: return "deny";
            case PERMIT: return "permit";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DENY: return "http://hl7.org/fhir/consent-provision-type";
            case PERMIT: return "http://hl7.org/fhir/consent-provision-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DENY: return "Consent is denied for actions meeting these rules.";
            case PERMIT: return "Consent is provided for actions meeting these rules.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DENY: return "Deny";
            case PERMIT: return "Permit";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConsentProvisionTypeEnumFactory implements EnumFactory<ConsentProvisionType> {
    public ConsentProvisionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny".equals(codeString))
          return ConsentProvisionType.DENY;
        if ("permit".equals(codeString))
          return ConsentProvisionType.PERMIT;
        throw new IllegalArgumentException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
        public Enumeration<ConsentProvisionType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentProvisionType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("deny".equals(codeString))
          return new Enumeration<ConsentProvisionType>(this, ConsentProvisionType.DENY);
        if ("permit".equals(codeString))
          return new Enumeration<ConsentProvisionType>(this, ConsentProvisionType.PERMIT);
        throw new FHIRException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
    public String toCode(ConsentProvisionType code) {
      if (code == ConsentProvisionType.DENY)
        return "deny";
      if (code == ConsentProvisionType.PERMIT)
        return "permit";
      return "?";
      }
    public String toSystem(ConsentProvisionType code) {
      return code.getSystem();
      }
    }

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
        public Enumeration<ConsentState> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentState>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.ACTIVE);
        if ("inactive".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.INACTIVE);
        if ("not-done".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.NOTDONE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<ConsentState>(this, ConsentState.UNKNOWN);
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
         * Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=true, summary=true)
        @Description(shortDefinition="deny | permit", formalDefinition="Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-provision-type")
        protected Enumeration<ConsentProvisionType> type;

        /**
         * The timeframe in this rule is valid.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Timeframe for this rule", formalDefinition="The timeframe in this rule is valid." )
        protected Period period;

        /**
         * Who or what is controlled by this rule. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').
         */
        @Child(name = "actor", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who|what controlled by this rule (or group, by role)", formalDefinition="Who or what is controlled by this rule. Use group to identify a set of actors by some property they share (e.g. 'admitting officers')." )
        protected List<ProvisionActorComponent> actor;

        /**
         * Actions controlled by this Rule.
         */
        @Child(name = "action", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Actions controlled by this rule", formalDefinition="Actions controlled by this Rule." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-action")
        protected List<CodeableConcept> action;

        /**
         * A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.
         */
        @Child(name = "securityLabel", type = {Coding.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Security Labels that define affected resources", formalDefinition="A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-examples")
        protected List<Coding> securityLabel;

        /**
         * The context of the activities a user is taking - why the user is accessing the data - that are controlled by this rule.
         */
        @Child(name = "purpose", type = {Coding.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Context of activities covered by this rule", formalDefinition="The context of the activities a user is taking - why the user is accessing the data - that are controlled by this rule." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
        protected List<Coding> purpose;

        /**
         * The class of information covered by this rule. The type can be a FHIR resource type, a profile on a type, or a CDA document, or some other type that indicates what sort of information the consent relates to.
         */
        @Child(name = "class", type = {Coding.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="e.g. Resource Type, Profile, CDA, etc.", formalDefinition="The class of information covered by this rule. The type can be a FHIR resource type, a profile on a type, or a CDA document, or some other type that indicates what sort of information the consent relates to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-content-class")
        protected List<Coding> class_;

        /**
         * If this code is found in an instance, then the rule applies.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="e.g. LOINC or SNOMED CT code, etc. in the content", formalDefinition="If this code is found in an instance, then the rule applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-content-code")
        protected List<CodeableConcept> code;

        /**
         * Clinical or Operational Relevant period of time that bounds the data controlled by this rule.
         */
        @Child(name = "dataPeriod", type = {Period.class}, order=9, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Timeframe for data controlled by this rule", formalDefinition="Clinical or Operational Relevant period of time that bounds the data controlled by this rule." )
        protected Period dataPeriod;

        /**
         * The resources controlled by this rule if specific resources are referenced.
         */
        @Child(name = "data", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Data controlled by this rule", formalDefinition="The resources controlled by this rule if specific resources are referenced." )
        protected List<ProvisionDataComponent> data;

        /**
         * A computable (FHIRPath or other) definition of what is controlled by this consent.
         */
        @Child(name = "expression", type = {Expression.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A computable expression of the consent", formalDefinition="A computable (FHIRPath or other) definition of what is controlled by this consent." )
        protected Expression expression;

        /**
         * Rules which provide exceptions to the base rule or subrules.
         */
        @Child(name = "provision", type = {ProvisionComponent.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Nested Exception Rules", formalDefinition="Rules which provide exceptions to the base rule or subrules." )
        protected List<ProvisionComponent> provision;

        private static final long serialVersionUID = 649023539L;

    /**
     * Constructor
     */
      public ProvisionComponent() {
        super();
      }

        /**
         * @return {@link #type} (Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ConsentProvisionType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvisionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ProvisionComponent setTypeElement(Enumeration<ConsentProvisionType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.
         */
        public ConsentProvisionType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.
         */
        public ProvisionComponent setType(ConsentProvisionType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #period} (The timeframe in this rule is valid.)
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
         * @param value {@link #period} (The timeframe in this rule is valid.)
         */
        public ProvisionComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #actor} (Who or what is controlled by this rule. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').)
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
         * @return {@link #action} (Actions controlled by this Rule.)
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
         * @return {@link #purpose} (The context of the activities a user is taking - why the user is accessing the data - that are controlled by this rule.)
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
         * @return {@link #class_} (The class of information covered by this rule. The type can be a FHIR resource type, a profile on a type, or a CDA document, or some other type that indicates what sort of information the consent relates to.)
         */
        public List<Coding> getClass_() { 
          if (this.class_ == null)
            this.class_ = new ArrayList<Coding>();
          return this.class_;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvisionComponent setClass_(List<Coding> theClass_) { 
          this.class_ = theClass_;
          return this;
        }

        public boolean hasClass_() { 
          if (this.class_ == null)
            return false;
          for (Coding item : this.class_)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addClass_() { //3
          Coding t = new Coding();
          if (this.class_ == null)
            this.class_ = new ArrayList<Coding>();
          this.class_.add(t);
          return t;
        }

        public ProvisionComponent addClass_(Coding t) { //3
          if (t == null)
            return this;
          if (this.class_ == null)
            this.class_ = new ArrayList<Coding>();
          this.class_.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #class_}, creating it if it does not already exist {3}
         */
        public Coding getClass_FirstRep() { 
          if (getClass_().isEmpty()) {
            addClass_();
          }
          return getClass_().get(0);
        }

        /**
         * @return {@link #code} (If this code is found in an instance, then the rule applies.)
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
         * @return {@link #dataPeriod} (Clinical or Operational Relevant period of time that bounds the data controlled by this rule.)
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
         * @param value {@link #dataPeriod} (Clinical or Operational Relevant period of time that bounds the data controlled by this rule.)
         */
        public ProvisionComponent setDataPeriod(Period value) { 
          this.dataPeriod = value;
          return this;
        }

        /**
         * @return {@link #data} (The resources controlled by this rule if specific resources are referenced.)
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
         * @return {@link #provision} (Rules which provide exceptions to the base rule or subrules.)
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
          children.add(new Property("type", "code", "Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.", 0, 1, type));
          children.add(new Property("period", "Period", "The timeframe in this rule is valid.", 0, 1, period));
          children.add(new Property("actor", "", "Who or what is controlled by this rule. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, java.lang.Integer.MAX_VALUE, actor));
          children.add(new Property("action", "CodeableConcept", "Actions controlled by this Rule.", 0, java.lang.Integer.MAX_VALUE, action));
          children.add(new Property("securityLabel", "Coding", "A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.", 0, java.lang.Integer.MAX_VALUE, securityLabel));
          children.add(new Property("purpose", "Coding", "The context of the activities a user is taking - why the user is accessing the data - that are controlled by this rule.", 0, java.lang.Integer.MAX_VALUE, purpose));
          children.add(new Property("class", "Coding", "The class of information covered by this rule. The type can be a FHIR resource type, a profile on a type, or a CDA document, or some other type that indicates what sort of information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, class_));
          children.add(new Property("code", "CodeableConcept", "If this code is found in an instance, then the rule applies.", 0, java.lang.Integer.MAX_VALUE, code));
          children.add(new Property("dataPeriod", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this rule.", 0, 1, dataPeriod));
          children.add(new Property("data", "", "The resources controlled by this rule if specific resources are referenced.", 0, java.lang.Integer.MAX_VALUE, data));
          children.add(new Property("expression", "Expression", "A computable (FHIRPath or other) definition of what is controlled by this consent.", 0, 1, expression));
          children.add(new Property("provision", "@Consent.provision", "Rules which provide exceptions to the base rule or subrules.", 0, java.lang.Integer.MAX_VALUE, provision));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "Action  to take - permit or deny - when the rule conditions are met.  Not permitted in root rule, required in all nested rules.", 0, 1, type);
          case -991726143: /*period*/  return new Property("period", "Period", "The timeframe in this rule is valid.", 0, 1, period);
          case 92645877: /*actor*/  return new Property("actor", "", "Who or what is controlled by this rule. Use group to identify a set of actors by some property they share (e.g. 'admitting officers').", 0, java.lang.Integer.MAX_VALUE, actor);
          case -1422950858: /*action*/  return new Property("action", "CodeableConcept", "Actions controlled by this Rule.", 0, java.lang.Integer.MAX_VALUE, action);
          case -722296940: /*securityLabel*/  return new Property("securityLabel", "Coding", "A security label, comprised of 0..* security label fields (Privacy tags), which define which resources are controlled by this exception.", 0, java.lang.Integer.MAX_VALUE, securityLabel);
          case -220463842: /*purpose*/  return new Property("purpose", "Coding", "The context of the activities a user is taking - why the user is accessing the data - that are controlled by this rule.", 0, java.lang.Integer.MAX_VALUE, purpose);
          case 94742904: /*class*/  return new Property("class", "Coding", "The class of information covered by this rule. The type can be a FHIR resource type, a profile on a type, or a CDA document, or some other type that indicates what sort of information the consent relates to.", 0, java.lang.Integer.MAX_VALUE, class_);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "If this code is found in an instance, then the rule applies.", 0, java.lang.Integer.MAX_VALUE, code);
          case 1177250315: /*dataPeriod*/  return new Property("dataPeriod", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this rule.", 0, 1, dataPeriod);
          case 3076010: /*data*/  return new Property("data", "", "The resources controlled by this rule if specific resources are referenced.", 0, java.lang.Integer.MAX_VALUE, data);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "A computable (FHIRPath or other) definition of what is controlled by this consent.", 0, 1, expression);
          case -547120939: /*provision*/  return new Property("provision", "@Consent.provision", "Rules which provide exceptions to the base rule or subrules.", 0, java.lang.Integer.MAX_VALUE, provision);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ConsentProvisionType>
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // ProvisionActorComponent
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // CodeableConcept
        case -722296940: /*securityLabel*/ return this.securityLabel == null ? new Base[0] : this.securityLabel.toArray(new Base[this.securityLabel.size()]); // Coding
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // Coding
        case 94742904: /*class*/ return this.class_ == null ? new Base[0] : this.class_.toArray(new Base[this.class_.size()]); // Coding
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
        case 3575610: // type
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConsentProvisionType>
          return value;
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
        case 94742904: // class
          this.getClass_().add(TypeConvertor.castToCoding(value)); // Coding
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
        if (name.equals("type")) {
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConsentProvisionType>
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("actor")) {
          this.getActor().add((ProvisionActorComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("purpose")) {
          this.getPurpose().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("class")) {
          this.getClass_().add(TypeConvertor.castToCoding(value));
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
        case 3575610:  return getTypeElement();
        case -991726143:  return getPeriod();
        case 92645877:  return addActor(); 
        case -1422950858:  return addAction(); 
        case -722296940:  return addSecurityLabel(); 
        case -220463842:  return addPurpose(); 
        case 94742904:  return addClass_(); 
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
        case 3575610: /*type*/ return new String[] {"code"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 92645877: /*actor*/ return new String[] {};
        case -1422950858: /*action*/ return new String[] {"CodeableConcept"};
        case -722296940: /*securityLabel*/ return new String[] {"Coding"};
        case -220463842: /*purpose*/ return new String[] {"Coding"};
        case 94742904: /*class*/ return new String[] {"Coding"};
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
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.provision.type");
        }
        else if (name.equals("period")) {
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
        else if (name.equals("class")) {
          return addClass_();
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
        dst.type = type == null ? null : type.copy();
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
        if (class_ != null) {
          dst.class_ = new ArrayList<Coding>();
          for (Coding i : class_)
            dst.class_.add(i.copy());
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
        return compareDeep(type, o.type, true) && compareDeep(period, o.period, true) && compareDeep(actor, o.actor, true)
           && compareDeep(action, o.action, true) && compareDeep(securityLabel, o.securityLabel, true) && compareDeep(purpose, o.purpose, true)
           && compareDeep(class_, o.class_, true) && compareDeep(code, o.code, true) && compareDeep(dataPeriod, o.dataPeriod, true)
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
        return compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, period, actor, action
          , securityLabel, purpose, class_, code, dataPeriod, data, expression, provision
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
     * Date and time the consent instance was agreed to.
     */
    @Child(name = "dateTime", type = {DateTimeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When consent was agreed to", formalDefinition="Date and time the consent instance was agreed to." )
    protected DateTimeType dateTime;

    /**
     * The entity responsible for granting the rights listed in a Consent Directive.
     */
    @Child(name = "grantor", type = {CareTeam.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is granting rights according to the policy and rules", formalDefinition="The entity responsible for granting the rights listed in a Consent Directive." )
    protected List<Reference> grantor;

    /**
     * The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions.
     */
    @Child(name = "grantee", type = {CareTeam.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is agreeing to the policy and rules", formalDefinition="The entity responsible for complying with the Consent Directive, including any obligations or limitations on authorizations and enforcement of prohibitions." )
    protected List<Reference> grantee;

    /**
     * The actor that manages the consent through its lifecycle.
     */
    @Child(name = "manager", type = {HealthcareService.class, Organization.class, Patient.class, Practitioner.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Consent workflow management", formalDefinition="The actor that manages the consent through its lifecycle." )
    protected List<Reference> manager;

    /**
     * The actor that controls/enforces the access according to the consent.
     */
    @Child(name = "controller", type = {HealthcareService.class, Organization.class, Patient.class, Practitioner.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Consent Enforcer", formalDefinition="The actor that controls/enforces the access according to the consent." )
    protected List<Reference> controller;

    /**
     * The source on which this consent statement is based. The source might be a scanned original paper form.
     */
    @Child(name = "sourceAttachment", type = {Attachment.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Source from which this consent is taken", formalDefinition="The source on which this consent statement is based. The source might be a scanned original paper form." )
    protected List<Attachment> sourceAttachment;

    /**
     * A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document.
     */
    @Child(name = "sourceReference", type = {Consent.class, DocumentReference.class, Contract.class, QuestionnaireResponse.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Source from which this consent is taken", formalDefinition="A reference to a consent that links back to such a source, a reference to a document repository (e.g. XDS) that stores the original consent document." )
    protected List<Reference> sourceReference;

    /**
     * A set of codes that indicate the regulatory basis (if any) that this consent supports.
     */
    @Child(name = "regulatoryBasis", type = {CodeableConcept.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Regulations establishing base Consent", formalDefinition="A set of codes that indicate the regulatory basis (if any) that this consent supports." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-policy")
    protected List<CodeableConcept> regulatoryBasis;

    /**
     * A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form.
     */
    @Child(name = "policyBasis", type = {}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Computable version of the backing policy", formalDefinition="A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent. This Reference or URL should be specific to the version of the policy and should be dereferencable to a computable policy of some form." )
    protected ConsentPolicyBasisComponent policyBasis;

    /**
     * A Reference to the human readable policy explaining the basis for the Consent.
     */
    @Child(name = "policyText", type = {DocumentReference.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Human Readable Policy", formalDefinition="A Reference to the human readable policy explaining the basis for the Consent." )
    protected List<Reference> policyText;

    /**
     * Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person.
     */
    @Child(name = "verification", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Consent Verified by patient or family", formalDefinition="Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her family or another authorized person." )
    protected List<ConsentVerificationComponent> verification;

    /**
     * An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.
     */
    @Child(name = "provision", type = {}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Constraints to the base Consent.policyRule/Consent.policy", formalDefinition="An exception to the base policy of this consent. An exception can be an addition or removal of access permissions." )
    protected ProvisionComponent provision;

    private static final long serialVersionUID = 1252772004L;

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
     * @return {@link #dateTime} (Date and time the consent instance was agreed to.). This is the underlying object with id, value and extensions. The accessor "getDateTime" gives direct access to the value
     */
    public DateTimeType getDateTimeElement() { 
      if (this.dateTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.dateTime");
        else if (Configuration.doAutoCreate())
          this.dateTime = new DateTimeType(); // bb
      return this.dateTime;
    }

    public boolean hasDateTimeElement() { 
      return this.dateTime != null && !this.dateTime.isEmpty();
    }

    public boolean hasDateTime() { 
      return this.dateTime != null && !this.dateTime.isEmpty();
    }

    /**
     * @param value {@link #dateTime} (Date and time the consent instance was agreed to.). This is the underlying object with id, value and extensions. The accessor "getDateTime" gives direct access to the value
     */
    public Consent setDateTimeElement(DateTimeType value) { 
      this.dateTime = value;
      return this;
    }

    /**
     * @return Date and time the consent instance was agreed to.
     */
    public Date getDateTime() { 
      return this.dateTime == null ? null : this.dateTime.getValue();
    }

    /**
     * @param value Date and time the consent instance was agreed to.
     */
    public Consent setDateTime(Date value) { 
      if (value == null)
        this.dateTime = null;
      else {
        if (this.dateTime == null)
          this.dateTime = new DateTimeType();
        this.dateTime.setValue(value);
      }
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
     * @return {@link #provision} (An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.)
     */
    public ProvisionComponent getProvision() { 
      if (this.provision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Consent.provision");
        else if (Configuration.doAutoCreate())
          this.provision = new ProvisionComponent(); // cc
      return this.provision;
    }

    public boolean hasProvision() { 
      return this.provision != null && !this.provision.isEmpty();
    }

    /**
     * @param value {@link #provision} (An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.)
     */
    public Consent setProvision(ProvisionComponent value) { 
      this.provision = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier for this copy of the Consent Statement.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Indicates the current state of this Consent resource.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("subject", "Reference(Patient|Practitioner|Group)", "The patient/healthcare practitioner or group of persons to whom this consent applies.", 0, 1, subject));
        children.add(new Property("dateTime", "dateTime", "Date and time the consent instance was agreed to.", 0, 1, dateTime));
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
        children.add(new Property("provision", "", "An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.", 0, 1, provision));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier for this copy of the Consent Statement.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates the current state of this Consent resource.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A classification of the type of consents found in the statement. This element supports indexing and retrieval of consent statements.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Practitioner|Group)", "The patient/healthcare practitioner or group of persons to whom this consent applies.", 0, 1, subject);
        case 1792749467: /*dateTime*/  return new Property("dateTime", "dateTime", "Date and time the consent instance was agreed to.", 0, 1, dateTime);
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
        case -547120939: /*provision*/  return new Property("provision", "", "An exception to the base policy of this consent. An exception can be an addition or removal of access permissions.", 0, 1, provision);
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
        case 1792749467: /*dateTime*/ return this.dateTime == null ? new Base[0] : new Base[] {this.dateTime}; // DateTimeType
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
        case -547120939: /*provision*/ return this.provision == null ? new Base[0] : new Base[] {this.provision}; // ProvisionComponent
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
        case 1792749467: // dateTime
          this.dateTime = TypeConvertor.castToDateTime(value); // DateTimeType
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
        case -547120939: // provision
          this.provision = (ProvisionComponent) value; // ProvisionComponent
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
        } else if (name.equals("dateTime")) {
          this.dateTime = TypeConvertor.castToDateTime(value); // DateTimeType
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
        } else if (name.equals("provision")) {
          this.provision = (ProvisionComponent) value; // ProvisionComponent
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
        case 1792749467:  return getDateTimeElement();
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
        case -547120939:  return getProvision();
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
        case 1792749467: /*dateTime*/ return new String[] {"dateTime"};
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
        else if (name.equals("dateTime")) {
          throw new FHIRException("Cannot call addChild on a primitive type Consent.dateTime");
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
        else if (name.equals("provision")) {
          this.provision = new ProvisionComponent();
          return this.provision;
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
        dst.dateTime = dateTime == null ? null : dateTime.copy();
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
        dst.provision = provision == null ? null : provision.copy();
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
           && compareDeep(subject, o.subject, true) && compareDeep(dateTime, o.dateTime, true) && compareDeep(grantor, o.grantor, true)
           && compareDeep(grantee, o.grantee, true) && compareDeep(manager, o.manager, true) && compareDeep(controller, o.controller, true)
           && compareDeep(sourceAttachment, o.sourceAttachment, true) && compareDeep(sourceReference, o.sourceReference, true)
           && compareDeep(regulatoryBasis, o.regulatoryBasis, true) && compareDeep(policyBasis, o.policyBasis, true)
           && compareDeep(policyText, o.policyText, true) && compareDeep(verification, o.verification, true)
           && compareDeep(provision, o.provision, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Consent))
          return false;
        Consent o = (Consent) other_;
        return compareValues(status, o.status, true) && compareValues(dateTime, o.dateTime, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, category
          , subject, dateTime, grantor, grantee, manager, controller, sourceAttachment, sourceReference
          , regulatoryBasis, policyBasis, policyText, verification, provision);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Consent;
   }


}

