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
 * Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
 */
@ResourceDef(name="RelatedPerson", profile="http://hl7.org/fhir/StructureDefinition/RelatedPerson")
public class RelatedPerson extends DomainResource {

    @Block()
    public static class RelatedPersonCommunicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-EN" for England English.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The language which can be used to communicate with the related person about the patient's health", formalDefinition="The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).
         */
        @Child(name = "preferred", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Language preference indicator", formalDefinition="Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level)." )
        protected BooleanType preferred;

        private static final long serialVersionUID = 633792918L;

    /**
     * Constructor
     */
      public RelatedPersonCommunicationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RelatedPersonCommunicationComponent(CodeableConcept language) {
        super();
        this.setLanguage(language);
      }

        /**
         * @return {@link #language} (The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-EN" for England English.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RelatedPersonCommunicationComponent.language");
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
        public RelatedPersonCommunicationComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #preferred} (Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public BooleanType getPreferredElement() { 
          if (this.preferred == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RelatedPersonCommunicationComponent.preferred");
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
         * @param value {@link #preferred} (Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public RelatedPersonCommunicationComponent setPreferredElement(BooleanType value) { 
          this.preferred = value;
          return this;
        }

        /**
         * @return Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).
         */
        public boolean getPreferred() { 
          return this.preferred == null || this.preferred.isEmpty() ? false : this.preferred.getValue();
        }

        /**
         * @param value Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).
         */
        public RelatedPersonCommunicationComponent setPreferred(boolean value) { 
            if (this.preferred == null)
              this.preferred = new BooleanType();
            this.preferred.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English.", 0, 1, language));
          children.add(new Property("preferred", "boolean", "Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).", 0, 1, preferred));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-EN\" for England English.", 0, 1, language);
          case -1294005119: /*preferred*/  return new Property("preferred", "boolean", "Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).", 0, 1, preferred);
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
          throw new FHIRException("Cannot call addChild on a primitive type RelatedPerson.communication.preferred");
        }
        else
          return super.addChild(name);
      }

      public RelatedPersonCommunicationComponent copy() {
        RelatedPersonCommunicationComponent dst = new RelatedPersonCommunicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RelatedPersonCommunicationComponent dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.preferred = preferred == null ? null : preferred.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RelatedPersonCommunicationComponent))
          return false;
        RelatedPersonCommunicationComponent o = (RelatedPersonCommunicationComponent) other_;
        return compareDeep(language, o.language, true) && compareDeep(preferred, o.preferred, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RelatedPersonCommunicationComponent))
          return false;
        RelatedPersonCommunicationComponent o = (RelatedPersonCommunicationComponent) other_;
        return compareValues(preferred, o.preferred, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, preferred);
      }

  public String fhirType() {
    return "RelatedPerson.communication";

  }

  }

    /**
     * Identifier for a person within a particular scope.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A human identifier for this person", formalDefinition="Identifier for a person within a particular scope." )
    protected List<Identifier> identifier;

    /**
     * Whether this related person record is in active use.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Whether this related person's record is in active use", formalDefinition="Whether this related person record is in active use." )
    protected BooleanType active;

    /**
     * The patient this person is related to.
     */
    @Child(name = "patient", type = {Patient.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient this person is related to", formalDefinition="The patient this person is related to." )
    protected Reference patient;

    /**
     * The nature of the relationship between the related person and the patient.
     */
    @Child(name = "relationship", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The relationship of the related person to the patient", formalDefinition="The nature of the relationship between the related person and the patient." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/relatedperson-relationshiptype")
    protected List<CodeableConcept> relationship;

    /**
     * A name associated with the person.
     */
    @Child(name = "name", type = {HumanName.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A name associated with the person", formalDefinition="A name associated with the person." )
    protected List<HumanName> name;

    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     */
    @Child(name = "telecom", type = {ContactPoint.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A contact detail for the person", formalDefinition="A contact detail for the person, e.g. a telephone number or an email address." )
    protected List<ContactPoint> telecom;

    /**
     * Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.
     */
    @Child(name = "gender", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="male | female | other | unknown", formalDefinition="Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrative-gender")
    protected Enumeration<AdministrativeGender> gender;

    /**
     * The date on which the related person was born.
     */
    @Child(name = "birthDate", type = {DateType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date on which the related person was born", formalDefinition="The date on which the related person was born." )
    protected DateType birthDate;

    /**
     * Address where the related person can be contacted or visited.
     */
    @Child(name = "address", type = {Address.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Address where the related person can be contacted or visited", formalDefinition="Address where the related person can be contacted or visited." )
    protected List<Address> address;

    /**
     * Image of the person.
     */
    @Child(name = "photo", type = {Attachment.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Image of the person", formalDefinition="Image of the person." )
    protected List<Attachment> photo;

    /**
     * The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown.
     */
    @Child(name = "period", type = {Period.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Period of time that this relationship is considered valid", formalDefinition="The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown." )
    protected Period period;

    /**
     * A language which may be used to communicate with the related person about the patient's health.
     */
    @Child(name = "communication", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A language which may be used to communicate with the related person about the patient's health", formalDefinition="A language which may be used to communicate with the related person about the patient's health." )
    protected List<RelatedPersonCommunicationComponent> communication;

    private static final long serialVersionUID = -857475397L;

  /**
   * Constructor
   */
    public RelatedPerson() {
      super();
    }

  /**
   * Constructor
   */
    public RelatedPerson(Reference patient) {
      super();
      this.setPatient(patient);
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
    public RelatedPerson setIdentifier(List<Identifier> theIdentifier) { 
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

    public RelatedPerson addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (Whether this related person record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedPerson.active");
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
     * @param value {@link #active} (Whether this related person record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public RelatedPerson setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return Whether this related person record is in active use.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value Whether this related person record is in active use.
     */
    public RelatedPerson setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #patient} (The patient this person is related to.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedPerson.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The patient this person is related to.)
     */
    public RelatedPerson setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #relationship} (The nature of the relationship between the related person and the patient.)
     */
    public List<CodeableConcept> getRelationship() { 
      if (this.relationship == null)
        this.relationship = new ArrayList<CodeableConcept>();
      return this.relationship;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RelatedPerson setRelationship(List<CodeableConcept> theRelationship) { 
      this.relationship = theRelationship;
      return this;
    }

    public boolean hasRelationship() { 
      if (this.relationship == null)
        return false;
      for (CodeableConcept item : this.relationship)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addRelationship() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.relationship == null)
        this.relationship = new ArrayList<CodeableConcept>();
      this.relationship.add(t);
      return t;
    }

    public RelatedPerson addRelationship(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.relationship == null)
        this.relationship = new ArrayList<CodeableConcept>();
      this.relationship.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relationship}, creating it if it does not already exist {3}
     */
    public CodeableConcept getRelationshipFirstRep() { 
      if (getRelationship().isEmpty()) {
        addRelationship();
      }
      return getRelationship().get(0);
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
    public RelatedPerson setName(List<HumanName> theName) { 
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

    public RelatedPerson addName(HumanName t) { //3
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
    public RelatedPerson setTelecom(List<ContactPoint> theTelecom) { 
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

    public RelatedPerson addTelecom(ContactPoint t) { //3
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
     * @return {@link #gender} (Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
     */
    public Enumeration<AdministrativeGender> getGenderElement() { 
      if (this.gender == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedPerson.gender");
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
     * @param value {@link #gender} (Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
     */
    public RelatedPerson setGenderElement(Enumeration<AdministrativeGender> value) { 
      this.gender = value;
      return this;
    }

    /**
     * @return Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.
     */
    public AdministrativeGender getGender() { 
      return this.gender == null ? null : this.gender.getValue();
    }

    /**
     * @param value Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.
     */
    public RelatedPerson setGender(AdministrativeGender value) { 
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
     * @return {@link #birthDate} (The date on which the related person was born.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public DateType getBirthDateElement() { 
      if (this.birthDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedPerson.birthDate");
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
     * @param value {@link #birthDate} (The date on which the related person was born.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public RelatedPerson setBirthDateElement(DateType value) { 
      this.birthDate = value;
      return this;
    }

    /**
     * @return The date on which the related person was born.
     */
    public Date getBirthDate() { 
      return this.birthDate == null ? null : this.birthDate.getValue();
    }

    /**
     * @param value The date on which the related person was born.
     */
    public RelatedPerson setBirthDate(Date value) { 
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
     * @return {@link #address} (Address where the related person can be contacted or visited.)
     */
    public List<Address> getAddress() { 
      if (this.address == null)
        this.address = new ArrayList<Address>();
      return this.address;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RelatedPerson setAddress(List<Address> theAddress) { 
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

    public RelatedPerson addAddress(Address t) { //3
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
     * @return {@link #photo} (Image of the person.)
     */
    public List<Attachment> getPhoto() { 
      if (this.photo == null)
        this.photo = new ArrayList<Attachment>();
      return this.photo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RelatedPerson setPhoto(List<Attachment> thePhoto) { 
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

    public RelatedPerson addPhoto(Attachment t) { //3
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
     * @return {@link #period} (The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedPerson.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown.)
     */
    public RelatedPerson setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #communication} (A language which may be used to communicate with the related person about the patient's health.)
     */
    public List<RelatedPersonCommunicationComponent> getCommunication() { 
      if (this.communication == null)
        this.communication = new ArrayList<RelatedPersonCommunicationComponent>();
      return this.communication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RelatedPerson setCommunication(List<RelatedPersonCommunicationComponent> theCommunication) { 
      this.communication = theCommunication;
      return this;
    }

    public boolean hasCommunication() { 
      if (this.communication == null)
        return false;
      for (RelatedPersonCommunicationComponent item : this.communication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedPersonCommunicationComponent addCommunication() { //3
      RelatedPersonCommunicationComponent t = new RelatedPersonCommunicationComponent();
      if (this.communication == null)
        this.communication = new ArrayList<RelatedPersonCommunicationComponent>();
      this.communication.add(t);
      return t;
    }

    public RelatedPerson addCommunication(RelatedPersonCommunicationComponent t) { //3
      if (t == null)
        return this;
      if (this.communication == null)
        this.communication = new ArrayList<RelatedPersonCommunicationComponent>();
      this.communication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #communication}, creating it if it does not already exist {3}
     */
    public RelatedPersonCommunicationComponent getCommunicationFirstRep() { 
      if (getCommunication().isEmpty()) {
        addCommunication();
      }
      return getCommunication().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for a person within a particular scope.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "Whether this related person record is in active use.", 0, 1, active));
        children.add(new Property("patient", "Reference(Patient)", "The patient this person is related to.", 0, 1, patient));
        children.add(new Property("relationship", "CodeableConcept", "The nature of the relationship between the related person and the patient.", 0, java.lang.Integer.MAX_VALUE, relationship));
        children.add(new Property("name", "HumanName", "A name associated with the person.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("telecom", "ContactPoint", "A contact detail for the person, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom));
        children.add(new Property("gender", "code", "Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.", 0, 1, gender));
        children.add(new Property("birthDate", "date", "The date on which the related person was born.", 0, 1, birthDate));
        children.add(new Property("address", "Address", "Address where the related person can be contacted or visited.", 0, java.lang.Integer.MAX_VALUE, address));
        children.add(new Property("photo", "Attachment", "Image of the person.", 0, java.lang.Integer.MAX_VALUE, photo));
        children.add(new Property("period", "Period", "The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown.", 0, 1, period));
        children.add(new Property("communication", "", "A language which may be used to communicate with the related person about the patient's health.", 0, java.lang.Integer.MAX_VALUE, communication));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for a person within a particular scope.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "Whether this related person record is in active use.", 0, 1, active);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The patient this person is related to.", 0, 1, patient);
        case -261851592: /*relationship*/  return new Property("relationship", "CodeableConcept", "The nature of the relationship between the related person and the patient.", 0, java.lang.Integer.MAX_VALUE, relationship);
        case 3373707: /*name*/  return new Property("name", "HumanName", "A name associated with the person.", 0, java.lang.Integer.MAX_VALUE, name);
        case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "A contact detail for the person, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom);
        case -1249512767: /*gender*/  return new Property("gender", "code", "Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.", 0, 1, gender);
        case -1210031859: /*birthDate*/  return new Property("birthDate", "date", "The date on which the related person was born.", 0, 1, birthDate);
        case -1147692044: /*address*/  return new Property("address", "Address", "Address where the related person can be contacted or visited.", 0, java.lang.Integer.MAX_VALUE, address);
        case 106642994: /*photo*/  return new Property("photo", "Attachment", "Image of the person.", 0, java.lang.Integer.MAX_VALUE, photo);
        case -991726143: /*period*/  return new Property("period", "Period", "The period of time during which this relationship is or was active. If there are no dates defined, then the interval is unknown.", 0, 1, period);
        case -1035284522: /*communication*/  return new Property("communication", "", "A language which may be used to communicate with the related person about the patient's health.", 0, java.lang.Integer.MAX_VALUE, communication);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : this.relationship.toArray(new Base[this.relationship.size()]); // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // HumanName
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case -1249512767: /*gender*/ return this.gender == null ? new Base[0] : new Base[] {this.gender}; // Enumeration<AdministrativeGender>
        case -1210031859: /*birthDate*/ return this.birthDate == null ? new Base[0] : new Base[] {this.birthDate}; // DateType
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // Address
        case 106642994: /*photo*/ return this.photo == null ? new Base[0] : this.photo.toArray(new Base[this.photo.size()]); // Attachment
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -1035284522: /*communication*/ return this.communication == null ? new Base[0] : this.communication.toArray(new Base[this.communication.size()]); // RelatedPersonCommunicationComponent
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
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case -261851592: // relationship
          this.getRelationship().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        case -1147692044: // address
          this.getAddress().add(TypeConvertor.castToAddress(value)); // Address
          return value;
        case 106642994: // photo
          this.getPhoto().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1035284522: // communication
          this.getCommunication().add((RelatedPersonCommunicationComponent) value); // RelatedPersonCommunicationComponent
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
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("relationship")) {
          this.getRelationship().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("name")) {
          this.getName().add(TypeConvertor.castToHumanName(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("gender")) {
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
        } else if (name.equals("birthDate")) {
          this.birthDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("address")) {
          this.getAddress().add(TypeConvertor.castToAddress(value));
        } else if (name.equals("photo")) {
          this.getPhoto().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("communication")) {
          this.getCommunication().add((RelatedPersonCommunicationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case -791418107:  return getPatient();
        case -261851592:  return addRelationship(); 
        case 3373707:  return addName(); 
        case -1429363305:  return addTelecom(); 
        case -1249512767:  return getGenderElement();
        case -1210031859:  return getBirthDateElement();
        case -1147692044:  return addAddress(); 
        case 106642994:  return addPhoto(); 
        case -991726143:  return getPeriod();
        case -1035284522:  return addCommunication(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1422950650: /*active*/ return new String[] {"boolean"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case -261851592: /*relationship*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"HumanName"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case -1249512767: /*gender*/ return new String[] {"code"};
        case -1210031859: /*birthDate*/ return new String[] {"date"};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case 106642994: /*photo*/ return new String[] {"Attachment"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -1035284522: /*communication*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedPerson.active");
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("relationship")) {
          return addRelationship();
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("gender")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedPerson.gender");
        }
        else if (name.equals("birthDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedPerson.birthDate");
        }
        else if (name.equals("address")) {
          return addAddress();
        }
        else if (name.equals("photo")) {
          return addPhoto();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("communication")) {
          return addCommunication();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RelatedPerson";

  }

      public RelatedPerson copy() {
        RelatedPerson dst = new RelatedPerson();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RelatedPerson dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        dst.patient = patient == null ? null : patient.copy();
        if (relationship != null) {
          dst.relationship = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : relationship)
            dst.relationship.add(i.copy());
        };
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
        if (address != null) {
          dst.address = new ArrayList<Address>();
          for (Address i : address)
            dst.address.add(i.copy());
        };
        if (photo != null) {
          dst.photo = new ArrayList<Attachment>();
          for (Attachment i : photo)
            dst.photo.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        if (communication != null) {
          dst.communication = new ArrayList<RelatedPersonCommunicationComponent>();
          for (RelatedPersonCommunicationComponent i : communication)
            dst.communication.add(i.copy());
        };
      }

      protected RelatedPerson typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RelatedPerson))
          return false;
        RelatedPerson o = (RelatedPerson) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(patient, o.patient, true)
           && compareDeep(relationship, o.relationship, true) && compareDeep(name, o.name, true) && compareDeep(telecom, o.telecom, true)
           && compareDeep(gender, o.gender, true) && compareDeep(birthDate, o.birthDate, true) && compareDeep(address, o.address, true)
           && compareDeep(photo, o.photo, true) && compareDeep(period, o.period, true) && compareDeep(communication, o.communication, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RelatedPerson))
          return false;
        RelatedPerson o = (RelatedPerson) other_;
        return compareValues(active, o.active, true) && compareValues(gender, o.gender, true) && compareValues(birthDate, o.birthDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, patient
          , relationship, name, telecom, gender, birthDate, address, photo, period, communication
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.RelatedPerson;
   }


}

