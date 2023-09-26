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
 * Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
 */
@ResourceDef(name="RelatedPerson", profile="http://hl7.org/fhir/StructureDefinition/RelatedPerson")
public class RelatedPerson extends DomainResource {

    @Block()
    public static class RelatedPersonCommunicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-AU" for Australian English.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The language which can be used to communicate with the related person about the patient's health", formalDefinition="The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-AU\" for Australian English." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
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
         * @return {@link #language} (The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-AU" for Australian English.)
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
         * @param value {@link #language} (The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or "en-US" for American English versus "en-AU" for Australian English.)
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
          children.add(new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-AU\" for Australian English.", 0, 1, language));
          children.add(new Property("preferred", "boolean", "Indicates whether or not the related person prefers this language (over other languages he or she masters up a certain level).", 0, 1, preferred));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. \"en\" for English, or \"en-US\" for American English versus \"en-AU\" for Australian English.", 0, 1, language);
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = null;
        } else if (name.equals("preferred")) {
          this.preferred = null;
        } else
          super.removeChild(name, value);
        
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
          throw new FHIRException("Cannot call addChild on a singleton property RelatedPerson.communication.preferred");
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("active")) {
          this.active = null;
        } else if (name.equals("patient")) {
          this.patient = null;
        } else if (name.equals("relationship")) {
          this.getRelationship().remove(value);
        } else if (name.equals("name")) {
          this.getName().remove(value);
        } else if (name.equals("telecom")) {
          this.getTelecom().remove(value);
        } else if (name.equals("gender")) {
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
        } else if (name.equals("birthDate")) {
          this.birthDate = null;
        } else if (name.equals("address")) {
          this.getAddress().remove(value);
        } else if (name.equals("photo")) {
          this.getPhoto().remove(value);
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("communication")) {
          this.getCommunication().add((RelatedPersonCommunicationComponent) value);
        } else
          super.removeChild(name, value);
        
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
          throw new FHIRException("Cannot call addChild on a singleton property RelatedPerson.active");
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
          throw new FHIRException("Cannot call addChild on a singleton property RelatedPerson.gender");
        }
        else if (name.equals("birthDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property RelatedPerson.birthDate");
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

 /**
   * Search parameter: <b>active</b>
   * <p>
   * Description: <b>Indicates if the related person record is active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RelatedPerson.active</b><br>
   * </p>
   */
  @SearchParamDefinition(name="active", path="RelatedPerson.active", description="Indicates if the related person record is active", type="token" )
  public static final String SP_ACTIVE = "active";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>active</b>
   * <p>
   * Description: <b>Indicates if the related person record is active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RelatedPerson.active</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTIVE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTIVE);

 /**
   * Search parameter: <b>family</b>
   * <p>
   * Description: <b>A portion of the family name of the related person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name.family</b><br>
   * </p>
   */
  @SearchParamDefinition(name="family", path="RelatedPerson.name.family", description="A portion of the family name of the related person", type="string" )
  public static final String SP_FAMILY = "family";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>family</b>
   * <p>
   * Description: <b>A portion of the family name of the related person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name.family</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam FAMILY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_FAMILY);

 /**
   * Search parameter: <b>given</b>
   * <p>
   * Description: <b>A portion of the given name of the related person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name.given</b><br>
   * </p>
   */
  @SearchParamDefinition(name="given", path="RelatedPerson.name.given", description="A portion of the given name of the related person", type="string" )
  public static final String SP_GIVEN = "given";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>given</b>
   * <p>
   * Description: <b>A portion of the given name of the related person</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name.given</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam GIVEN = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_GIVEN);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="RelatedPerson.name", description="A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text</b><br>
   * Type: <b>string</b><br>
   * Path: <b>RelatedPerson.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>relationship</b>
   * <p>
   * Description: <b>The relationship between the patient and the relatedperson</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RelatedPerson.relationship</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relationship", path="RelatedPerson.relationship", description="The relationship between the patient and the relatedperson", type="token" )
  public static final String SP_RELATIONSHIP = "relationship";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relationship</b>
   * <p>
   * Description: <b>The relationship between the patient and the relatedperson</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RelatedPerson.relationship</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RELATIONSHIP = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RELATIONSHIP);

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
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
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
   * the path value of "<b>RelatedPerson:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("RelatedPerson:patient").toLocked();

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
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="email", path="Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in an email contact\r\n* [Person](person.html): A value in an email contact\r\n* [Practitioner](practitioner.html): A value in an email contact\r\n* [PractitionerRole](practitionerrole.html): A value in an email contact\r\n* [RelatedPerson](relatedperson.html): A value in an email contact\r\n", type="token" )
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
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
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
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="phone", path="Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in a phone contact\r\n* [Person](person.html): A value in a phone contact\r\n* [Practitioner](practitioner.html): A value in a phone contact\r\n* [PractitionerRole](practitionerrole.html): A value in a phone contact\r\n* [RelatedPerson](relatedperson.html): A value in a phone contact\r\n", type="token" )
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
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
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
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="telecom", path="Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): The value in any kind of telecom details of the patient\r\n* [Person](person.html): The value in any kind of contact\r\n* [Practitioner](practitioner.html): The value in any kind of contact\r\n* [PractitionerRole](practitionerrole.html): The value in any kind of contact\r\n* [RelatedPerson](relatedperson.html): The value in any kind of contact\r\n", type="token" )
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
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TELECOM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TELECOM);


}

