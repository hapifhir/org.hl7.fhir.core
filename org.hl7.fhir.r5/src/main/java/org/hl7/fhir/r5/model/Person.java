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

// Generated on Tue, Dec 28, 2021 07:16+1100 for FHIR v5.0.0-snapshot1

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
 * Demographics and administrative information about a person independent of a specific health-related context.
 */
@ResourceDef(name="Person", profile="http://hl7.org/fhir/StructureDefinition/Person")
public class Person extends DomainResource {

    public enum IdentityAssuranceLevel {
        /**
         * Little or no confidence in the asserted identity's accuracy.
         */
        LEVEL1, 
        /**
         * Some confidence in the asserted identity's accuracy.
         */
        LEVEL2, 
        /**
         * High confidence in the asserted identity's accuracy.
         */
        LEVEL3, 
        /**
         * Very high confidence in the asserted identity's accuracy.
         */
        LEVEL4, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static IdentityAssuranceLevel fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("level1".equals(codeString))
          return LEVEL1;
        if ("level2".equals(codeString))
          return LEVEL2;
        if ("level3".equals(codeString))
          return LEVEL3;
        if ("level4".equals(codeString))
          return LEVEL4;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown IdentityAssuranceLevel code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LEVEL1: return "level1";
            case LEVEL2: return "level2";
            case LEVEL3: return "level3";
            case LEVEL4: return "level4";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case LEVEL1: return "http://hl7.org/fhir/identity-assuranceLevel";
            case LEVEL2: return "http://hl7.org/fhir/identity-assuranceLevel";
            case LEVEL3: return "http://hl7.org/fhir/identity-assuranceLevel";
            case LEVEL4: return "http://hl7.org/fhir/identity-assuranceLevel";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case LEVEL1: return "Little or no confidence in the asserted identity's accuracy.";
            case LEVEL2: return "Some confidence in the asserted identity's accuracy.";
            case LEVEL3: return "High confidence in the asserted identity's accuracy.";
            case LEVEL4: return "Very high confidence in the asserted identity's accuracy.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LEVEL1: return "Level 1";
            case LEVEL2: return "Level 2";
            case LEVEL3: return "Level 3";
            case LEVEL4: return "Level 4";
            default: return "?";
          }
        }
    }

  public static class IdentityAssuranceLevelEnumFactory implements EnumFactory<IdentityAssuranceLevel> {
    public IdentityAssuranceLevel fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("level1".equals(codeString))
          return IdentityAssuranceLevel.LEVEL1;
        if ("level2".equals(codeString))
          return IdentityAssuranceLevel.LEVEL2;
        if ("level3".equals(codeString))
          return IdentityAssuranceLevel.LEVEL3;
        if ("level4".equals(codeString))
          return IdentityAssuranceLevel.LEVEL4;
        throw new IllegalArgumentException("Unknown IdentityAssuranceLevel code '"+codeString+"'");
        }
        public Enumeration<IdentityAssuranceLevel> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<IdentityAssuranceLevel>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("level1".equals(codeString))
          return new Enumeration<IdentityAssuranceLevel>(this, IdentityAssuranceLevel.LEVEL1);
        if ("level2".equals(codeString))
          return new Enumeration<IdentityAssuranceLevel>(this, IdentityAssuranceLevel.LEVEL2);
        if ("level3".equals(codeString))
          return new Enumeration<IdentityAssuranceLevel>(this, IdentityAssuranceLevel.LEVEL3);
        if ("level4".equals(codeString))
          return new Enumeration<IdentityAssuranceLevel>(this, IdentityAssuranceLevel.LEVEL4);
        throw new FHIRException("Unknown IdentityAssuranceLevel code '"+codeString+"'");
        }
    public String toCode(IdentityAssuranceLevel code) {
      if (code == IdentityAssuranceLevel.LEVEL1)
        return "level1";
      if (code == IdentityAssuranceLevel.LEVEL2)
        return "level2";
      if (code == IdentityAssuranceLevel.LEVEL3)
        return "level3";
      if (code == IdentityAssuranceLevel.LEVEL4)
        return "level4";
      return "?";
      }
    public String toSystem(IdentityAssuranceLevel code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class PersonCommunicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-EN" for England English.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The language which can be used to communicate with the person about his or her health", formalDefinition="The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * Indicates whether or not the person prefers this language (over other languages he masters up a certain level).
         */
        @Child(name = "preferred", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Language preference indicator", formalDefinition="Indicates whether or not the person prefers this language (over other languages he masters up a certain level)." )
        protected BooleanType preferred;

        private static final long serialVersionUID = 633792918L;

    /**
     * Constructor
     */
      public PersonCommunicationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PersonCommunicationComponent(CodeableConcept language) {
        super();
        this.setLanguage(language);
      }

        /**
         * @return {@link #language} (The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-EN" for England English.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PersonCommunicationComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-EN" for England English.)
         */
        public PersonCommunicationComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #preferred} (Indicates whether or not the person prefers this language (over other languages he masters up a certain level).). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public BooleanType getPreferredElement() { 
          if (this.preferred == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PersonCommunicationComponent.preferred");
            else if (Configuration.doAutoCreate())
              this.preferred = new BooleanType(); // bb
          return this.preferred;
        }

        public boolean hasPreferredElement() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        public boolean hasPreferred() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        /**
         * @param value {@link #preferred} (Indicates whether or not the person prefers this language (over other languages he masters up a certain level).). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public PersonCommunicationComponent setPreferredElement(BooleanType value) { 
          this.preferred = value;
          return this;
        }

        /**
         * @return Indicates whether or not the person prefers this language (over other languages he masters up a certain level).
         */
        public boolean getPreferred() { 
          return this.preferred == null || this.preferred.isEmpty() ? false : this.preferred.getValue();
        }

        /**
         * @param value Indicates whether or not the person prefers this language (over other languages he masters up a certain level).
         */
        public PersonCommunicationComponent setPreferred(boolean value) { 
            if (this.preferred == null)
              this.preferred = new BooleanType();
            this.preferred.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English.", 0, 1, language));
          children.add(new Property("preferred", "boolean", "Indicates whether or not the person prefers this language (over other languages he masters up a certain level).", 0, 1, preferred));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English.", 0, 1, language);
          case -1294005119: /*preferred*/  return new Property("preferred", "boolean", "Indicates whether or not the person prefers this language (over other languages he masters up a certain level).", 0, 1, preferred);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case -1294005119: /*preferred*/ return this.preferred == null ? new Base[0] : new Base[] {this.preferred}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1294005119: // preferred
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("preferred")) {
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguage();
        case -1294005119:  return getPreferredElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case -1294005119: /*preferred*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("preferred")) {
          throw new FHIRException("Cannot call addChild on a primitive type Person.communication.preferred");
        }
        else
          return super.addChild(name);
      }

      public PersonCommunicationComponent copy() {
        PersonCommunicationComponent dst = new PersonCommunicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PersonCommunicationComponent dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.preferred = preferred == null ? null : preferred.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PersonCommunicationComponent))
          return false;
        PersonCommunicationComponent o = (PersonCommunicationComponent) other_;
        return compareDeep(language, o.language, true) && compareDeep(preferred, o.preferred, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PersonCommunicationComponent))
          return false;
        PersonCommunicationComponent o = (PersonCommunicationComponent) other_;
        return compareValues(preferred, o.preferred, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, preferred);
      }

  public String fhirType() {
    return "Person.communication";

  }

  }

    @Block()
    public static class PersonLinkComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The resource to which this actual person is associated.
         */
        @Child(name = "target", type = {Patient.class, Practitioner.class, RelatedPerson.class, Person.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The resource to which this actual person is associated", formalDefinition="The resource to which this actual person is associated." )
        protected Reference target;

        /**
         * Level of assurance that this link is associated with the target resource.
         */
        @Child(name = "assurance", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="level1 | level2 | level3 | level4", formalDefinition="Level of assurance that this link is associated with the target resource." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/identity-assuranceLevel")
        protected Enumeration<IdentityAssuranceLevel> assurance;

        private static final long serialVersionUID = -1393523223L;

    /**
     * Constructor
     */
      public PersonLinkComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PersonLinkComponent(Reference target) {
        super();
        this.setTarget(target);
      }

        /**
         * @return {@link #target} (The resource to which this actual person is associated.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PersonLinkComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (The resource to which this actual person is associated.)
         */
        public PersonLinkComponent setTarget(Reference value) { 
          this.target = value;
          return this;
        }

        /**
         * @return {@link #assurance} (Level of assurance that this link is associated with the target resource.). This is the underlying object with id, value and extensions. The accessor "getAssurance" gives direct access to the value
         */
        public Enumeration<IdentityAssuranceLevel> getAssuranceElement() { 
          if (this.assurance == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PersonLinkComponent.assurance");
            else if (Configuration.doAutoCreate())
              this.assurance = new Enumeration<IdentityAssuranceLevel>(new IdentityAssuranceLevelEnumFactory()); // bb
          return this.assurance;
        }

        public boolean hasAssuranceElement() { 
          return this.assurance != null && !this.assurance.isEmpty();
        }

        public boolean hasAssurance() { 
          return this.assurance != null && !this.assurance.isEmpty();
        }

        /**
         * @param value {@link #assurance} (Level of assurance that this link is associated with the target resource.). This is the underlying object with id, value and extensions. The accessor "getAssurance" gives direct access to the value
         */
        public PersonLinkComponent setAssuranceElement(Enumeration<IdentityAssuranceLevel> value) { 
          this.assurance = value;
          return this;
        }

        /**
         * @return Level of assurance that this link is associated with the target resource.
         */
        public IdentityAssuranceLevel getAssurance() { 
          return this.assurance == null ? null : this.assurance.getValue();
        }

        /**
         * @param value Level of assurance that this link is associated with the target resource.
         */
        public PersonLinkComponent setAssurance(IdentityAssuranceLevel value) { 
          if (value == null)
            this.assurance = null;
          else {
            if (this.assurance == null)
              this.assurance = new Enumeration<IdentityAssuranceLevel>(new IdentityAssuranceLevelEnumFactory());
            this.assurance.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("target", "Reference(Patient|Practitioner|RelatedPerson|Person)", "The resource to which this actual person is associated.", 0, 1, target));
          children.add(new Property("assurance", "code", "Level of assurance that this link is associated with the target resource.", 0, 1, assurance));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -880905839: /*target*/  return new Property("target", "Reference(Patient|Practitioner|RelatedPerson|Person)", "The resource to which this actual person is associated.", 0, 1, target);
          case 1771900717: /*assurance*/  return new Property("assurance", "code", "Level of assurance that this link is associated with the target resource.", 0, 1, assurance);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        case 1771900717: /*assurance*/ return this.assurance == null ? new Base[0] : new Base[] {this.assurance}; // Enumeration<IdentityAssuranceLevel>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -880905839: // target
          this.target = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1771900717: // assurance
          value = new IdentityAssuranceLevelEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.assurance = (Enumeration) value; // Enumeration<IdentityAssuranceLevel>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("target")) {
          this.target = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("assurance")) {
          value = new IdentityAssuranceLevelEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.assurance = (Enumeration) value; // Enumeration<IdentityAssuranceLevel>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -880905839:  return getTarget();
        case 1771900717:  return getAssuranceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -880905839: /*target*/ return new String[] {"Reference"};
        case 1771900717: /*assurance*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else if (name.equals("assurance")) {
          throw new FHIRException("Cannot call addChild on a primitive type Person.link.assurance");
        }
        else
          return super.addChild(name);
      }

      public PersonLinkComponent copy() {
        PersonLinkComponent dst = new PersonLinkComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PersonLinkComponent dst) {
        super.copyValues(dst);
        dst.target = target == null ? null : target.copy();
        dst.assurance = assurance == null ? null : assurance.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PersonLinkComponent))
          return false;
        PersonLinkComponent o = (PersonLinkComponent) other_;
        return compareDeep(target, o.target, true) && compareDeep(assurance, o.assurance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PersonLinkComponent))
          return false;
        PersonLinkComponent o = (PersonLinkComponent) other_;
        return compareValues(assurance, o.assurance, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(target, assurance);
      }

  public String fhirType() {
    return "Person.link";

  }

  }

    /**
     * Identifier for a person within a particular scope.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A human identifier for this person", formalDefinition="Identifier for a person within a particular scope." )
    protected List<Identifier> identifier;

    /**
     * Whether this person's record is in active use.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="This person's record is in active use", formalDefinition="Whether this person's record is in active use." )
    protected BooleanType active;

    /**
     * A name associated with the person.
     */
    @Child(name = "name", type = {HumanName.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A name associated with the person", formalDefinition="A name associated with the person." )
    protected List<HumanName> name;

    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     */
    @Child(name = "telecom", type = {ContactPoint.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A contact detail for the person", formalDefinition="A contact detail for the person, e.g. a telephone number or an email address." )
    protected List<ContactPoint> telecom;

    /**
     * Administrative Gender.
     */
    @Child(name = "gender", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="male | female | other | unknown", formalDefinition="Administrative Gender." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrative-gender")
    protected Enumeration<AdministrativeGender> gender;

    /**
     * The birth date for the person.
     */
    @Child(name = "birthDate", type = {DateType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date on which the person was born", formalDefinition="The birth date for the person." )
    protected DateType birthDate;

    /**
     * Indicates if the individual is deceased or not.
     */
    @Child(name = "deceased", type = {BooleanType.class, DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Indicates if the individual is deceased or not", formalDefinition="Indicates if the individual is deceased or not." )
    protected DataType deceased;

    /**
     * One or more addresses for the person.
     */
    @Child(name = "address", type = {Address.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="One or more addresses for the person", formalDefinition="One or more addresses for the person." )
    protected List<Address> address;

    /**
     * This field contains a person's most recent marital (civil) status.
     */
    @Child(name = "maritalStatus", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Marital (civil) status of a person", formalDefinition="This field contains a person's most recent marital (civil) status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/marital-status")
    protected CodeableConcept maritalStatus;

    /**
     * An image that can be displayed as a thumbnail of the person to enhance the identification of the individual.
     */
    @Child(name = "photo", type = {Attachment.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Image of the person", formalDefinition="An image that can be displayed as a thumbnail of the person to enhance the identification of the individual." )
    protected List<Attachment> photo;

    /**
     * The organization that is the custodian of the person record.
     */
    @Child(name = "managingOrganization", type = {Organization.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The organization that is the custodian of the person record", formalDefinition="The organization that is the custodian of the person record." )
    protected Reference managingOrganization;

    /**
     * A language which may be used to communicate with the person about his or her health.
     */
    @Child(name = "communication", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A language which may be used to communicate with the person about his or her health", formalDefinition="A language which may be used to communicate with the person about his or her health." )
    protected List<PersonCommunicationComponent> communication;

    /**
     * Link to a resource that concerns the same actual person.
     */
    @Child(name = "link", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link to a resource that concerns the same actual person", formalDefinition="Link to a resource that concerns the same actual person." )
    protected List<PersonLinkComponent> link;

    private static final long serialVersionUID = -1013247270L;

  /**
   * Constructor
   */
    public Person() {
      super();
    }

    /**
     * @return {@link #identifier} (Identifier for a person within a particular scope.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setIdentifier(List<Identifier> theIdentifier) { 
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

    public Person addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (Whether this person's record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Person.active");
        else if (Configuration.doAutoCreate())
          this.active = new BooleanType(); // bb
      return this.active;
    }

    public boolean hasActiveElement() { 
      return this.active != null && !this.active.isEmpty();
    }

    public boolean hasActive() { 
      return this.active != null && !this.active.isEmpty();
    }

    /**
     * @param value {@link #active} (Whether this person's record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public Person setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return Whether this person's record is in active use.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value Whether this person's record is in active use.
     */
    public Person setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #name} (A name associated with the person.)
     */
    public List<HumanName> getName() { 
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setName(List<HumanName> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (HumanName item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public HumanName addName() { //3
      HumanName t = new HumanName();
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      this.name.add(t);
      return t;
    }

    public Person addName(HumanName t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public HumanName getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #telecom} (A contact detail for the person, e.g. a telephone number or an email address.)
     */
    public List<ContactPoint> getTelecom() { 
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      return this.telecom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setTelecom(List<ContactPoint> theTelecom) { 
      this.telecom = theTelecom;
      return this;
    }

    public boolean hasTelecom() { 
      if (this.telecom == null)
        return false;
      for (ContactPoint item : this.telecom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addTelecom() { //3
      ContactPoint t = new ContactPoint();
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return t;
    }

    public Person addTelecom(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #telecom}, creating it if it does not already exist {3}
     */
    public ContactPoint getTelecomFirstRep() { 
      if (getTelecom().isEmpty()) {
        addTelecom();
      }
      return getTelecom().get(0);
    }

    /**
     * @return {@link #gender} (Administrative Gender.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
     */
    public Enumeration<AdministrativeGender> getGenderElement() { 
      if (this.gender == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Person.gender");
        else if (Configuration.doAutoCreate())
          this.gender = new Enumeration<AdministrativeGender>(new AdministrativeGenderEnumFactory()); // bb
      return this.gender;
    }

    public boolean hasGenderElement() { 
      return this.gender != null && !this.gender.isEmpty();
    }

    public boolean hasGender() { 
      return this.gender != null && !this.gender.isEmpty();
    }

    /**
     * @param value {@link #gender} (Administrative Gender.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
     */
    public Person setGenderElement(Enumeration<AdministrativeGender> value) { 
      this.gender = value;
      return this;
    }

    /**
     * @return Administrative Gender.
     */
    public AdministrativeGender getGender() { 
      return this.gender == null ? null : this.gender.getValue();
    }

    /**
     * @param value Administrative Gender.
     */
    public Person setGender(AdministrativeGender value) { 
      if (value == null)
        this.gender = null;
      else {
        if (this.gender == null)
          this.gender = new Enumeration<AdministrativeGender>(new AdministrativeGenderEnumFactory());
        this.gender.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #birthDate} (The birth date for the person.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public DateType getBirthDateElement() { 
      if (this.birthDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Person.birthDate");
        else if (Configuration.doAutoCreate())
          this.birthDate = new DateType(); // bb
      return this.birthDate;
    }

    public boolean hasBirthDateElement() { 
      return this.birthDate != null && !this.birthDate.isEmpty();
    }

    public boolean hasBirthDate() { 
      return this.birthDate != null && !this.birthDate.isEmpty();
    }

    /**
     * @param value {@link #birthDate} (The birth date for the person.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public Person setBirthDateElement(DateType value) { 
      this.birthDate = value;
      return this;
    }

    /**
     * @return The birth date for the person.
     */
    public Date getBirthDate() { 
      return this.birthDate == null ? null : this.birthDate.getValue();
    }

    /**
     * @param value The birth date for the person.
     */
    public Person setBirthDate(Date value) { 
      if (value == null)
        this.birthDate = null;
      else {
        if (this.birthDate == null)
          this.birthDate = new DateType();
        this.birthDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #deceased} (Indicates if the individual is deceased or not.)
     */
    public DataType getDeceased() { 
      return this.deceased;
    }

    /**
     * @return {@link #deceased} (Indicates if the individual is deceased or not.)
     */
    public BooleanType getDeceasedBooleanType() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new BooleanType();
      if (!(this.deceased instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (BooleanType) this.deceased;
    }

    public boolean hasDeceasedBooleanType() { 
      return this != null && this.deceased instanceof BooleanType;
    }

    /**
     * @return {@link #deceased} (Indicates if the individual is deceased or not.)
     */
    public DateTimeType getDeceasedDateTimeType() throws FHIRException { 
      if (this.deceased == null)
        this.deceased = new DateTimeType();
      if (!(this.deceased instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.deceased.getClass().getName()+" was encountered");
      return (DateTimeType) this.deceased;
    }

    public boolean hasDeceasedDateTimeType() { 
      return this != null && this.deceased instanceof DateTimeType;
    }

    public boolean hasDeceased() { 
      return this.deceased != null && !this.deceased.isEmpty();
    }

    /**
     * @param value {@link #deceased} (Indicates if the individual is deceased or not.)
     */
    public Person setDeceased(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof DateTimeType))
        throw new Error("Not the right type for Person.deceased[x]: "+value.fhirType());
      this.deceased = value;
      return this;
    }

    /**
     * @return {@link #address} (One or more addresses for the person.)
     */
    public List<Address> getAddress() { 
      if (this.address == null)
        this.address = new ArrayList<Address>();
      return this.address;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setAddress(List<Address> theAddress) { 
      this.address = theAddress;
      return this;
    }

    public boolean hasAddress() { 
      if (this.address == null)
        return false;
      for (Address item : this.address)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Address addAddress() { //3
      Address t = new Address();
      if (this.address == null)
        this.address = new ArrayList<Address>();
      this.address.add(t);
      return t;
    }

    public Person addAddress(Address t) { //3
      if (t == null)
        return this;
      if (this.address == null)
        this.address = new ArrayList<Address>();
      this.address.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #address}, creating it if it does not already exist {3}
     */
    public Address getAddressFirstRep() { 
      if (getAddress().isEmpty()) {
        addAddress();
      }
      return getAddress().get(0);
    }

    /**
     * @return {@link #maritalStatus} (This field contains a person's most recent marital (civil) status.)
     */
    public CodeableConcept getMaritalStatus() { 
      if (this.maritalStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Person.maritalStatus");
        else if (Configuration.doAutoCreate())
          this.maritalStatus = new CodeableConcept(); // cc
      return this.maritalStatus;
    }

    public boolean hasMaritalStatus() { 
      return this.maritalStatus != null && !this.maritalStatus.isEmpty();
    }

    /**
     * @param value {@link #maritalStatus} (This field contains a person's most recent marital (civil) status.)
     */
    public Person setMaritalStatus(CodeableConcept value) { 
      this.maritalStatus = value;
      return this;
    }

    /**
     * @return {@link #photo} (An image that can be displayed as a thumbnail of the person to enhance the identification of the individual.)
     */
    public List<Attachment> getPhoto() { 
      if (this.photo == null)
        this.photo = new ArrayList<Attachment>();
      return this.photo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setPhoto(List<Attachment> thePhoto) { 
      this.photo = thePhoto;
      return this;
    }

    public boolean hasPhoto() { 
      if (this.photo == null)
        return false;
      for (Attachment item : this.photo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addPhoto() { //3
      Attachment t = new Attachment();
      if (this.photo == null)
        this.photo = new ArrayList<Attachment>();
      this.photo.add(t);
      return t;
    }

    public Person addPhoto(Attachment t) { //3
      if (t == null)
        return this;
      if (this.photo == null)
        this.photo = new ArrayList<Attachment>();
      this.photo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #photo}, creating it if it does not already exist {3}
     */
    public Attachment getPhotoFirstRep() { 
      if (getPhoto().isEmpty()) {
        addPhoto();
      }
      return getPhoto().get(0);
    }

    /**
     * @return {@link #managingOrganization} (The organization that is the custodian of the person record.)
     */
    public Reference getManagingOrganization() { 
      if (this.managingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Person.managingOrganization");
        else if (Configuration.doAutoCreate())
          this.managingOrganization = new Reference(); // cc
      return this.managingOrganization;
    }

    public boolean hasManagingOrganization() { 
      return this.managingOrganization != null && !this.managingOrganization.isEmpty();
    }

    /**
     * @param value {@link #managingOrganization} (The organization that is the custodian of the person record.)
     */
    public Person setManagingOrganization(Reference value) { 
      this.managingOrganization = value;
      return this;
    }

    /**
     * @return {@link #communication} (A language which may be used to communicate with the person about his or her health.)
     */
    public List<PersonCommunicationComponent> getCommunication() { 
      if (this.communication == null)
        this.communication = new ArrayList<PersonCommunicationComponent>();
      return this.communication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setCommunication(List<PersonCommunicationComponent> theCommunication) { 
      this.communication = theCommunication;
      return this;
    }

    public boolean hasCommunication() { 
      if (this.communication == null)
        return false;
      for (PersonCommunicationComponent item : this.communication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PersonCommunicationComponent addCommunication() { //3
      PersonCommunicationComponent t = new PersonCommunicationComponent();
      if (this.communication == null)
        this.communication = new ArrayList<PersonCommunicationComponent>();
      this.communication.add(t);
      return t;
    }

    public Person addCommunication(PersonCommunicationComponent t) { //3
      if (t == null)
        return this;
      if (this.communication == null)
        this.communication = new ArrayList<PersonCommunicationComponent>();
      this.communication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #communication}, creating it if it does not already exist {3}
     */
    public PersonCommunicationComponent getCommunicationFirstRep() { 
      if (getCommunication().isEmpty()) {
        addCommunication();
      }
      return getCommunication().get(0);
    }

    /**
     * @return {@link #link} (Link to a resource that concerns the same actual person.)
     */
    public List<PersonLinkComponent> getLink() { 
      if (this.link == null)
        this.link = new ArrayList<PersonLinkComponent>();
      return this.link;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Person setLink(List<PersonLinkComponent> theLink) { 
      this.link = theLink;
      return this;
    }

    public boolean hasLink() { 
      if (this.link == null)
        return false;
      for (PersonLinkComponent item : this.link)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PersonLinkComponent addLink() { //3
      PersonLinkComponent t = new PersonLinkComponent();
      if (this.link == null)
        this.link = new ArrayList<PersonLinkComponent>();
      this.link.add(t);
      return t;
    }

    public Person addLink(PersonLinkComponent t) { //3
      if (t == null)
        return this;
      if (this.link == null)
        this.link = new ArrayList<PersonLinkComponent>();
      this.link.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #link}, creating it if it does not already exist {3}
     */
    public PersonLinkComponent getLinkFirstRep() { 
      if (getLink().isEmpty()) {
        addLink();
      }
      return getLink().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for a person within a particular scope.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "Whether this person's record is in active use.", 0, 1, active));
        children.add(new Property("name", "HumanName", "A name associated with the person.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("telecom", "ContactPoint", "A contact detail for the person, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom));
        children.add(new Property("gender", "code", "Administrative Gender.", 0, 1, gender));
        children.add(new Property("birthDate", "date", "The birth date for the person.", 0, 1, birthDate));
        children.add(new Property("deceased[x]", "boolean|dateTime", "Indicates if the individual is deceased or not.", 0, 1, deceased));
        children.add(new Property("address", "Address", "One or more addresses for the person.", 0, java.lang.Integer.MAX_VALUE, address));
        children.add(new Property("maritalStatus", "CodeableConcept", "This field contains a person's most recent marital (civil) status.", 0, 1, maritalStatus));
        children.add(new Property("photo", "Attachment", "An image that can be displayed as a thumbnail of the person to enhance the identification of the individual.", 0, java.lang.Integer.MAX_VALUE, photo));
        children.add(new Property("managingOrganization", "Reference(Organization)", "The organization that is the custodian of the person record.", 0, 1, managingOrganization));
        children.add(new Property("communication", "", "A language which may be used to communicate with the person about his or her health.", 0, java.lang.Integer.MAX_VALUE, communication));
        children.add(new Property("link", "", "Link to a resource that concerns the same actual person.", 0, java.lang.Integer.MAX_VALUE, link));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for a person within a particular scope.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "Whether this person's record is in active use.", 0, 1, active);
        case 3373707: /*name*/  return new Property("name", "HumanName", "A name associated with the person.", 0, java.lang.Integer.MAX_VALUE, name);
        case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "A contact detail for the person, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom);
        case -1249512767: /*gender*/  return new Property("gender", "code", "Administrative Gender.", 0, 1, gender);
        case -1210031859: /*birthDate*/  return new Property("birthDate", "date", "The birth date for the person.", 0, 1, birthDate);
        case -1311442804: /*deceased[x]*/  return new Property("deceased[x]", "boolean|dateTime", "Indicates if the individual is deceased or not.", 0, 1, deceased);
        case 561497972: /*deceased*/  return new Property("deceased[x]", "boolean|dateTime", "Indicates if the individual is deceased or not.", 0, 1, deceased);
        case 497463828: /*deceasedBoolean*/  return new Property("deceased[x]", "boolean", "Indicates if the individual is deceased or not.", 0, 1, deceased);
        case -1971804369: /*deceasedDateTime*/  return new Property("deceased[x]", "dateTime", "Indicates if the individual is deceased or not.", 0, 1, deceased);
        case -1147692044: /*address*/  return new Property("address", "Address", "One or more addresses for the person.", 0, java.lang.Integer.MAX_VALUE, address);
        case 1756919302: /*maritalStatus*/  return new Property("maritalStatus", "CodeableConcept", "This field contains a person's most recent marital (civil) status.", 0, 1, maritalStatus);
        case 106642994: /*photo*/  return new Property("photo", "Attachment", "An image that can be displayed as a thumbnail of the person to enhance the identification of the individual.", 0, java.lang.Integer.MAX_VALUE, photo);
        case -2058947787: /*managingOrganization*/  return new Property("managingOrganization", "Reference(Organization)", "The organization that is the custodian of the person record.", 0, 1, managingOrganization);
        case -1035284522: /*communication*/  return new Property("communication", "", "A language which may be used to communicate with the person about his or her health.", 0, java.lang.Integer.MAX_VALUE, communication);
        case 3321850: /*link*/  return new Property("link", "", "Link to a resource that concerns the same actual person.", 0, java.lang.Integer.MAX_VALUE, link);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // HumanName
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case -1249512767: /*gender*/ return this.gender == null ? new Base[0] : new Base[] {this.gender}; // Enumeration<AdministrativeGender>
        case -1210031859: /*birthDate*/ return this.birthDate == null ? new Base[0] : new Base[] {this.birthDate}; // DateType
        case 561497972: /*deceased*/ return this.deceased == null ? new Base[0] : new Base[] {this.deceased}; // DataType
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // Address
        case 1756919302: /*maritalStatus*/ return this.maritalStatus == null ? new Base[0] : new Base[] {this.maritalStatus}; // CodeableConcept
        case 106642994: /*photo*/ return this.photo == null ? new Base[0] : this.photo.toArray(new Base[this.photo.size()]); // Attachment
        case -2058947787: /*managingOrganization*/ return this.managingOrganization == null ? new Base[0] : new Base[] {this.managingOrganization}; // Reference
        case -1035284522: /*communication*/ return this.communication == null ? new Base[0] : this.communication.toArray(new Base[this.communication.size()]); // PersonCommunicationComponent
        case 3321850: /*link*/ return this.link == null ? new Base[0] : this.link.toArray(new Base[this.link.size()]); // PersonLinkComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1422950650: // active
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3373707: // name
          this.getName().add(TypeConvertor.castToHumanName(value)); // HumanName
          return value;
        case -1429363305: // telecom
          this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case -1249512767: // gender
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
          return value;
        case -1210031859: // birthDate
          this.birthDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case 561497972: // deceased
          this.deceased = TypeConvertor.castToType(value); // DataType
          return value;
        case -1147692044: // address
          this.getAddress().add(TypeConvertor.castToAddress(value)); // Address
          return value;
        case 1756919302: // maritalStatus
          this.maritalStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 106642994: // photo
          this.getPhoto().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -2058947787: // managingOrganization
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1035284522: // communication
          this.getCommunication().add((PersonCommunicationComponent) value); // PersonCommunicationComponent
          return value;
        case 3321850: // link
          this.getLink().add((PersonLinkComponent) value); // PersonLinkComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("active")) {
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("name")) {
          this.getName().add(TypeConvertor.castToHumanName(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("gender")) {
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
        } else if (name.equals("birthDate")) {
          this.birthDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("deceased[x]")) {
          this.deceased = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("address")) {
          this.getAddress().add(TypeConvertor.castToAddress(value));
        } else if (name.equals("maritalStatus")) {
          this.maritalStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("photo")) {
          this.getPhoto().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("managingOrganization")) {
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("communication")) {
          this.getCommunication().add((PersonCommunicationComponent) value);
        } else if (name.equals("link")) {
          this.getLink().add((PersonLinkComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case 3373707:  return addName(); 
        case -1429363305:  return addTelecom(); 
        case -1249512767:  return getGenderElement();
        case -1210031859:  return getBirthDateElement();
        case -1311442804:  return getDeceased();
        case 561497972:  return getDeceased();
        case -1147692044:  return addAddress(); 
        case 1756919302:  return getMaritalStatus();
        case 106642994:  return addPhoto(); 
        case -2058947787:  return getManagingOrganization();
        case -1035284522:  return addCommunication(); 
        case 3321850:  return addLink(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1422950650: /*active*/ return new String[] {"boolean"};
        case 3373707: /*name*/ return new String[] {"HumanName"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case -1249512767: /*gender*/ return new String[] {"code"};
        case -1210031859: /*birthDate*/ return new String[] {"date"};
        case 561497972: /*deceased*/ return new String[] {"boolean", "dateTime"};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case 1756919302: /*maritalStatus*/ return new String[] {"CodeableConcept"};
        case 106642994: /*photo*/ return new String[] {"Attachment"};
        case -2058947787: /*managingOrganization*/ return new String[] {"Reference"};
        case -1035284522: /*communication*/ return new String[] {};
        case 3321850: /*link*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type Person.active");
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("gender")) {
          throw new FHIRException("Cannot call addChild on a primitive type Person.gender");
        }
        else if (name.equals("birthDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Person.birthDate");
        }
        else if (name.equals("deceasedBoolean")) {
          this.deceased = new BooleanType();
          return this.deceased;
        }
        else if (name.equals("deceasedDateTime")) {
          this.deceased = new DateTimeType();
          return this.deceased;
        }
        else if (name.equals("address")) {
          return addAddress();
        }
        else if (name.equals("maritalStatus")) {
          this.maritalStatus = new CodeableConcept();
          return this.maritalStatus;
        }
        else if (name.equals("photo")) {
          return addPhoto();
        }
        else if (name.equals("managingOrganization")) {
          this.managingOrganization = new Reference();
          return this.managingOrganization;
        }
        else if (name.equals("communication")) {
          return addCommunication();
        }
        else if (name.equals("link")) {
          return addLink();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Person";

  }

      public Person copy() {
        Person dst = new Person();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Person dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        if (name != null) {
          dst.name = new ArrayList<HumanName>();
          for (HumanName i : name)
            dst.name.add(i.copy());
        };
        if (telecom != null) {
          dst.telecom = new ArrayList<ContactPoint>();
          for (ContactPoint i : telecom)
            dst.telecom.add(i.copy());
        };
        dst.gender = gender == null ? null : gender.copy();
        dst.birthDate = birthDate == null ? null : birthDate.copy();
        dst.deceased = deceased == null ? null : deceased.copy();
        if (address != null) {
          dst.address = new ArrayList<Address>();
          for (Address i : address)
            dst.address.add(i.copy());
        };
        dst.maritalStatus = maritalStatus == null ? null : maritalStatus.copy();
        if (photo != null) {
          dst.photo = new ArrayList<Attachment>();
          for (Attachment i : photo)
            dst.photo.add(i.copy());
        };
        dst.managingOrganization = managingOrganization == null ? null : managingOrganization.copy();
        if (communication != null) {
          dst.communication = new ArrayList<PersonCommunicationComponent>();
          for (PersonCommunicationComponent i : communication)
            dst.communication.add(i.copy());
        };
        if (link != null) {
          dst.link = new ArrayList<PersonLinkComponent>();
          for (PersonLinkComponent i : link)
            dst.link.add(i.copy());
        };
      }

      protected Person typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Person))
          return false;
        Person o = (Person) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(name, o.name, true)
           && compareDeep(telecom, o.telecom, true) && compareDeep(gender, o.gender, true) && compareDeep(birthDate, o.birthDate, true)
           && compareDeep(deceased, o.deceased, true) && compareDeep(address, o.address, true) && compareDeep(maritalStatus, o.maritalStatus, true)
           && compareDeep(photo, o.photo, true) && compareDeep(managingOrganization, o.managingOrganization, true)
           && compareDeep(communication, o.communication, true) && compareDeep(link, o.link, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Person))
          return false;
        Person o = (Person) other_;
        return compareValues(active, o.active, true) && compareValues(gender, o.gender, true) && compareValues(birthDate, o.birthDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, name
          , telecom, gender, birthDate, deceased, address, maritalStatus, photo, managingOrganization
          , communication, link);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Person;
   }

 /**
   * Search parameter: <b>death-date</b>
   * <p>
   * Description: <b>The date of death has been provided and satisfies this search value</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(Person.deceased as dateTime)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="death-date", path="(Person.deceased as dateTime)", description="The date of death has been provided and satisfies this search value", type="date" )
  public static final String SP_DEATH_DATE = "death-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>death-date</b>
   * <p>
   * Description: <b>The date of death has been provided and satisfies this search value</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(Person.deceased as dateTime)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DEATH_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DEATH_DATE);

 /**
   * Search parameter: <b>deceased</b>
   * <p>
   * Description: <b>This person has been marked as deceased, or has a death date entered</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Person.deceased.exists() and Person.deceased != false</b><br>
   * </p>
   */
  @SearchParamDefinition(name="deceased", path="Person.deceased.exists() and Person.deceased != false", description="This person has been marked as deceased, or has a death date entered", type="token" )
  public static final String SP_DECEASED = "deceased";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>deceased</b>
   * <p>
   * Description: <b>This person has been marked as deceased, or has a death date entered</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Person.deceased.exists() and Person.deceased != false</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DECEASED = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DECEASED);

 /**
   * Search parameter: <b>family</b>
   * <p>
   * Description: <b>A portion of the family name of the person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name.family</b><br>
   * </p>
   */
  @SearchParamDefinition(name="family", path="Person.name.family", description="A portion of the family name of the person", type="string" )
  public static final String SP_FAMILY = "family";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>family</b>
   * <p>
   * Description: <b>A portion of the family name of the person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name.family</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam FAMILY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_FAMILY);

 /**
   * Search parameter: <b>given</b>
   * <p>
   * Description: <b>A portion of the given name of the person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name.given</b><br>
   * </p>
   */
  @SearchParamDefinition(name="given", path="Person.name.given", description="A portion of the given name of the person", type="string" )
  public static final String SP_GIVEN = "given";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>given</b>
   * <p>
   * Description: <b>A portion of the given name of the person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name.given</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam GIVEN = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_GIVEN);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>A person Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Person.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Person.identifier", description="A person Identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>A person Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Person.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>link</b>
   * <p>
   * Description: <b>Any link has this Patient, Person, RelatedPerson or Practitioner reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="link", path="Person.link.target", description="Any link has this Patient, Person, RelatedPerson or Practitioner reference", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Patient.class, Person.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_LINK = "link";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>link</b>
   * <p>
   * Description: <b>Any link has this Patient, Person, RelatedPerson or Practitioner reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LINK = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LINK);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Person:link</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LINK = new ca.uhn.fhir.model.api.Include("Person:link").toLocked();

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="Person.name", description="A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Person.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization at which this person record is being managed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.managingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="Person.managingOrganization", description="The organization at which this person record is being managed", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization at which this person record is being managed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.managingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Person:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("Person:organization").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The Person links to this Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Person.link.target.where(resolve() is Patient)", description="The Person links to this Patient", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class, Person.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The Person links to this Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Person:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Person:patient").toLocked();

 /**
   * Search parameter: <b>practitioner</b>
   * <p>
   * Description: <b>The Person links to this Practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="practitioner", path="Person.link.target.where(resolve() is Practitioner)", description="The Person links to this Practitioner", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Patient.class, Person.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_PRACTITIONER = "practitioner";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>practitioner</b>
   * <p>
   * Description: <b>The Person links to this Practitioner</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRACTITIONER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRACTITIONER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Person:practitioner</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRACTITIONER = new ca.uhn.fhir.model.api.Include("Person:practitioner").toLocked();

 /**
   * Search parameter: <b>relatedperson</b>
   * <p>
   * Description: <b>The Person links to this RelatedPerson</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is RelatedPerson)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relatedperson", path="Person.link.target.where(resolve() is RelatedPerson)", description="The Person links to this RelatedPerson", type="reference", target={Patient.class, Person.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_RELATEDPERSON = "relatedperson";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relatedperson</b>
   * <p>
   * Description: <b>The Person links to this RelatedPerson</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Person.link.target.where(resolve() is RelatedPerson)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RELATEDPERSON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RELATEDPERSON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Person:relatedperson</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RELATEDPERSON = new ca.uhn.fhir.model.api.Include("Person:relatedperson").toLocked();

 /**
   * Search parameter: <b>address-city</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A city specified in an address
* [Person](person.html): A city specified in an address
* [Practitioner](practitioner.html): A city specified in an address
* [RelatedPerson](relatedperson.html): A city specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.city | Person.address.city | Practitioner.address.city | RelatedPerson.address.city</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-city", path="Patient.address.city | Person.address.city | Practitioner.address.city | RelatedPerson.address.city", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A city specified in an address\r\n* [Person](person.html): A city specified in an address\r\n* [Practitioner](practitioner.html): A city specified in an address\r\n* [RelatedPerson](relatedperson.html): A city specified in an address\r\n", type="string" )
  public static final String SP_ADDRESS_CITY = "address-city";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-city</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A city specified in an address
* [Person](person.html): A city specified in an address
* [Practitioner](practitioner.html): A city specified in an address
* [RelatedPerson](relatedperson.html): A city specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.city | Person.address.city | Practitioner.address.city | RelatedPerson.address.city</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_CITY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_CITY);

 /**
   * Search parameter: <b>address-country</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A country specified in an address
* [Person](person.html): A country specified in an address
* [Practitioner](practitioner.html): A country specified in an address
* [RelatedPerson](relatedperson.html): A country specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.country | Person.address.country | Practitioner.address.country | RelatedPerson.address.country</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-country", path="Patient.address.country | Person.address.country | Practitioner.address.country | RelatedPerson.address.country", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A country specified in an address\r\n* [Person](person.html): A country specified in an address\r\n* [Practitioner](practitioner.html): A country specified in an address\r\n* [RelatedPerson](relatedperson.html): A country specified in an address\r\n", type="string" )
  public static final String SP_ADDRESS_COUNTRY = "address-country";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-country</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A country specified in an address
* [Person](person.html): A country specified in an address
* [Practitioner](practitioner.html): A country specified in an address
* [RelatedPerson](relatedperson.html): A country specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.country | Person.address.country | Practitioner.address.country | RelatedPerson.address.country</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_COUNTRY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_COUNTRY);

 /**
   * Search parameter: <b>address-postalcode</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A postalCode specified in an address
* [Person](person.html): A postal code specified in an address
* [Practitioner](practitioner.html): A postalCode specified in an address
* [RelatedPerson](relatedperson.html): A postal code specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.postalCode | Person.address.postalCode | Practitioner.address.postalCode | RelatedPerson.address.postalCode</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-postalcode", path="Patient.address.postalCode | Person.address.postalCode | Practitioner.address.postalCode | RelatedPerson.address.postalCode", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A postalCode specified in an address\r\n* [Person](person.html): A postal code specified in an address\r\n* [Practitioner](practitioner.html): A postalCode specified in an address\r\n* [RelatedPerson](relatedperson.html): A postal code specified in an address\r\n", type="string" )
  public static final String SP_ADDRESS_POSTALCODE = "address-postalcode";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-postalcode</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A postalCode specified in an address
* [Person](person.html): A postal code specified in an address
* [Practitioner](practitioner.html): A postalCode specified in an address
* [RelatedPerson](relatedperson.html): A postal code specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.postalCode | Person.address.postalCode | Practitioner.address.postalCode | RelatedPerson.address.postalCode</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_POSTALCODE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_POSTALCODE);

 /**
   * Search parameter: <b>address-state</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A state specified in an address
* [Person](person.html): A state specified in an address
* [Practitioner](practitioner.html): A state specified in an address
* [RelatedPerson](relatedperson.html): A state specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.state | Person.address.state | Practitioner.address.state | RelatedPerson.address.state</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-state", path="Patient.address.state | Person.address.state | Practitioner.address.state | RelatedPerson.address.state", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A state specified in an address\r\n* [Person](person.html): A state specified in an address\r\n* [Practitioner](practitioner.html): A state specified in an address\r\n* [RelatedPerson](relatedperson.html): A state specified in an address\r\n", type="string" )
  public static final String SP_ADDRESS_STATE = "address-state";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-state</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A state specified in an address
* [Person](person.html): A state specified in an address
* [Practitioner](practitioner.html): A state specified in an address
* [RelatedPerson](relatedperson.html): A state specified in an address
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address.state | Person.address.state | Practitioner.address.state | RelatedPerson.address.state</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_STATE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_STATE);

 /**
   * Search parameter: <b>address-use</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A use code specified in an address
* [Person](person.html): A use code specified in an address
* [Practitioner](practitioner.html): A use code specified in an address
* [RelatedPerson](relatedperson.html): A use code specified in an address
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.address.use | Person.address.use | Practitioner.address.use | RelatedPerson.address.use</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-use", path="Patient.address.use | Person.address.use | Practitioner.address.use | RelatedPerson.address.use", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A use code specified in an address\r\n* [Person](person.html): A use code specified in an address\r\n* [Practitioner](practitioner.html): A use code specified in an address\r\n* [RelatedPerson](relatedperson.html): A use code specified in an address\r\n", type="token" )
  public static final String SP_ADDRESS_USE = "address-use";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-use</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A use code specified in an address
* [Person](person.html): A use code specified in an address
* [Practitioner](practitioner.html): A use code specified in an address
* [RelatedPerson](relatedperson.html): A use code specified in an address
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.address.use | Person.address.use | Practitioner.address.use | RelatedPerson.address.use</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ADDRESS_USE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ADDRESS_USE);

 /**
   * Search parameter: <b>address</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [Person](person.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [Practitioner](practitioner.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [RelatedPerson](relatedperson.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address | Person.address | Practitioner.address | RelatedPerson.address</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address", path="Patient.address | Person.address | Practitioner.address | RelatedPerson.address", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [Person](person.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [Practitioner](practitioner.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [RelatedPerson](relatedperson.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n", type="string" )
  public static final String SP_ADDRESS = "address";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [Person](person.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [Practitioner](practitioner.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
* [RelatedPerson](relatedperson.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.address | Person.address | Practitioner.address | RelatedPerson.address</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS);

 /**
   * Search parameter: <b>birthdate</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The patient's date of birth
* [Person](person.html): The person's date of birth
* [RelatedPerson](relatedperson.html): The Related Person's date of birth
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Patient.birthDate | Person.birthDate | RelatedPerson.birthDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="birthdate", path="Patient.birthDate | Person.birthDate | RelatedPerson.birthDate", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): The patient's date of birth\r\n* [Person](person.html): The person's date of birth\r\n* [RelatedPerson](relatedperson.html): The Related Person's date of birth\r\n", type="date" )
  public static final String SP_BIRTHDATE = "birthdate";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>birthdate</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The patient's date of birth
* [Person](person.html): The person's date of birth
* [RelatedPerson](relatedperson.html): The Related Person's date of birth
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Patient.birthDate | Person.birthDate | RelatedPerson.birthDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam BIRTHDATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_BIRTHDATE);

 /**
   * Search parameter: <b>email</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in an email contact
* [Person](person.html): A value in an email contact
* [Practitioner](practitioner.html): A value in an email contact
* [PractitionerRole](practitionerrole.html): A value in an email contact
* [RelatedPerson](relatedperson.html): A value in an email contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="email", path="Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in an email contact\r\n* [Person](person.html): A value in an email contact\r\n* [Practitioner](practitioner.html): A value in an email contact\r\n* [PractitionerRole](practitionerrole.html): A value in an email contact\r\n* [RelatedPerson](relatedperson.html): A value in an email contact\r\n", type="token" )
  public static final String SP_EMAIL = "email";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>email</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in an email contact
* [Person](person.html): A value in an email contact
* [Practitioner](practitioner.html): A value in an email contact
* [PractitionerRole](practitionerrole.html): A value in an email contact
* [RelatedPerson](relatedperson.html): A value in an email contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EMAIL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EMAIL);

 /**
   * Search parameter: <b>gender</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): Gender of the patient
* [Person](person.html): The gender of the person
* [Practitioner](practitioner.html): Gender of the practitioner
* [RelatedPerson](relatedperson.html): Gender of the related person
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.gender | Person.gender | Practitioner.gender | RelatedPerson.gender</b><br>
   * </p>
   */
  @SearchParamDefinition(name="gender", path="Patient.gender | Person.gender | Practitioner.gender | RelatedPerson.gender", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): Gender of the patient\r\n* [Person](person.html): The gender of the person\r\n* [Practitioner](practitioner.html): Gender of the practitioner\r\n* [RelatedPerson](relatedperson.html): Gender of the related person\r\n", type="token" )
  public static final String SP_GENDER = "gender";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>gender</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): Gender of the patient
* [Person](person.html): The gender of the person
* [Practitioner](practitioner.html): Gender of the practitioner
* [RelatedPerson](relatedperson.html): Gender of the related person
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.gender | Person.gender | Practitioner.gender | RelatedPerson.gender</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GENDER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_GENDER);

 /**
   * Search parameter: <b>phone</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in a phone contact
* [Person](person.html): A value in a phone contact
* [Practitioner](practitioner.html): A value in a phone contact
* [PractitionerRole](practitionerrole.html): A value in a phone contact
* [RelatedPerson](relatedperson.html): A value in a phone contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="phone", path="Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in a phone contact\r\n* [Person](person.html): A value in a phone contact\r\n* [Practitioner](practitioner.html): A value in a phone contact\r\n* [PractitionerRole](practitionerrole.html): A value in a phone contact\r\n* [RelatedPerson](relatedperson.html): A value in a phone contact\r\n", type="token" )
  public static final String SP_PHONE = "phone";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>phone</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in a phone contact
* [Person](person.html): A value in a phone contact
* [Practitioner](practitioner.html): A value in a phone contact
* [PractitionerRole](practitionerrole.html): A value in a phone contact
* [RelatedPerson](relatedperson.html): A value in a phone contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PHONE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PHONE);

 /**
   * Search parameter: <b>phonetic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A portion of either family or given name using some kind of phonetic matching algorithm
* [Person](person.html): A portion of name using some kind of phonetic matching algorithm
* [Practitioner](practitioner.html): A portion of either family or given name using some kind of phonetic matching algorithm
* [RelatedPerson](relatedperson.html): A portion of name using some kind of phonetic matching algorithm
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.name | Person.name | Practitioner.name | RelatedPerson.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="phonetic", path="Patient.name | Person.name | Practitioner.name | RelatedPerson.name", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A portion of either family or given name using some kind of phonetic matching algorithm\r\n* [Person](person.html): A portion of name using some kind of phonetic matching algorithm\r\n* [Practitioner](practitioner.html): A portion of either family or given name using some kind of phonetic matching algorithm\r\n* [RelatedPerson](relatedperson.html): A portion of name using some kind of phonetic matching algorithm\r\n", type="string" )
  public static final String SP_PHONETIC = "phonetic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>phonetic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A portion of either family or given name using some kind of phonetic matching algorithm
* [Person](person.html): A portion of name using some kind of phonetic matching algorithm
* [Practitioner](practitioner.html): A portion of either family or given name using some kind of phonetic matching algorithm
* [RelatedPerson](relatedperson.html): A portion of name using some kind of phonetic matching algorithm
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Patient.name | Person.name | Practitioner.name | RelatedPerson.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PHONETIC = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PHONETIC);

 /**
   * Search parameter: <b>telecom</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The value in any kind of telecom details of the patient
* [Person](person.html): The value in any kind of contact
* [Practitioner](practitioner.html): The value in any kind of contact
* [PractitionerRole](practitionerrole.html): The value in any kind of contact
* [RelatedPerson](relatedperson.html): The value in any kind of contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="telecom", path="Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.telecom | RelatedPerson.telecom", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): The value in any kind of telecom details of the patient\r\n* [Person](person.html): The value in any kind of contact\r\n* [Practitioner](practitioner.html): The value in any kind of contact\r\n* [PractitionerRole](practitionerrole.html): The value in any kind of contact\r\n* [RelatedPerson](relatedperson.html): The value in any kind of contact\r\n", type="token" )
  public static final String SP_TELECOM = "telecom";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>telecom</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The value in any kind of telecom details of the patient
* [Person](person.html): The value in any kind of contact
* [Practitioner](practitioner.html): The value in any kind of contact
* [PractitionerRole](practitionerrole.html): The value in any kind of contact
* [RelatedPerson](relatedperson.html): The value in any kind of contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TELECOM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TELECOM);


}

