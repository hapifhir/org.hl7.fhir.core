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
 * A person who is directly or indirectly involved in the provisioning of healthcare.
 */
@ResourceDef(name="Practitioner", profile="http://hl7.org/fhir/StructureDefinition/Practitioner")
public class Practitioner extends DomainResource {

    @Block()
    public static class PractitionerQualificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An identifier that applies to this person's qualification in this role.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An identifier for this qualification for the practitioner", formalDefinition="An identifier that applies to this person's qualification in this role." )
        protected List<Identifier> identifier;

        /**
         * Coded representation of the qualification.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Coded representation of the qualification", formalDefinition="Coded representation of the qualification." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0360")
        protected CodeableConcept code;

        /**
         * Period during which the qualification is valid.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Period during which the qualification is valid", formalDefinition="Period during which the qualification is valid." )
        protected Period period;

        /**
         * Organization that regulates and issues the qualification.
         */
        @Child(name = "issuer", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Organization that regulates and issues the qualification", formalDefinition="Organization that regulates and issues the qualification." )
        protected Reference issuer;

        private static final long serialVersionUID = 1561812204L;

    /**
     * Constructor
     */
      public PractitionerQualificationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PractitionerQualificationComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #identifier} (An identifier that applies to this person's qualification in this role.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PractitionerQualificationComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public PractitionerQualificationComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #code} (Coded representation of the qualification.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PractitionerQualificationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded representation of the qualification.)
         */
        public PractitionerQualificationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #period} (Period during which the qualification is valid.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PractitionerQualificationComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Period during which the qualification is valid.)
         */
        public PractitionerQualificationComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #issuer} (Organization that regulates and issues the qualification.)
         */
        public Reference getIssuer() { 
          if (this.issuer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PractitionerQualificationComponent.issuer");
            else if (Configuration.doAutoCreate())
              this.issuer = new Reference(); // cc
          return this.issuer;
        }

        public boolean hasIssuer() { 
          return this.issuer != null && !this.issuer.isEmpty();
        }

        /**
         * @param value {@link #issuer} (Organization that regulates and issues the qualification.)
         */
        public PractitionerQualificationComponent setIssuer(Reference value) { 
          this.issuer = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "An identifier that applies to this person's qualification in this role.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("code", "CodeableConcept", "Coded representation of the qualification.", 0, 1, code));
          children.add(new Property("period", "Period", "Period during which the qualification is valid.", 0, 1, period));
          children.add(new Property("issuer", "Reference(Organization)", "Organization that regulates and issues the qualification.", 0, 1, issuer));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "An identifier that applies to this person's qualification in this role.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Coded representation of the qualification.", 0, 1, code);
          case -991726143: /*period*/  return new Property("period", "Period", "Period during which the qualification is valid.", 0, 1, period);
          case -1179159879: /*issuer*/  return new Property("issuer", "Reference(Organization)", "Organization that regulates and issues the qualification.", 0, 1, issuer);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1179159879: // issuer
          this.issuer = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("issuer")) {
          this.issuer = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3059181:  return getCode();
        case -991726143:  return getPeriod();
        case -1179159879:  return getIssuer();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -1179159879: /*issuer*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("issuer")) {
          this.issuer = new Reference();
          return this.issuer;
        }
        else
          return super.addChild(name);
      }

      public PractitionerQualificationComponent copy() {
        PractitionerQualificationComponent dst = new PractitionerQualificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PractitionerQualificationComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.period = period == null ? null : period.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PractitionerQualificationComponent))
          return false;
        PractitionerQualificationComponent o = (PractitionerQualificationComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(period, o.period, true)
           && compareDeep(issuer, o.issuer, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PractitionerQualificationComponent))
          return false;
        PractitionerQualificationComponent o = (PractitionerQualificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, period
          , issuer);
      }

  public String fhirType() {
    return "Practitioner.qualification";

  }

  }

    /**
     * An identifier that applies to this person in this role.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An identifier for the person as this agent", formalDefinition="An identifier that applies to this person in this role." )
    protected List<Identifier> identifier;

    /**
     * Whether this practitioner's record is in active use.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether this practitioner's record is in active use", formalDefinition="Whether this practitioner's record is in active use." )
    protected BooleanType active;

    /**
     * The name(s) associated with the practitioner.
     */
    @Child(name = "name", type = {HumanName.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The name(s) associated with the practitioner", formalDefinition="The name(s) associated with the practitioner." )
    protected List<HumanName> name;

    /**
     * A contact detail for the practitioner, e.g. a telephone number or an email address.
     */
    @Child(name = "telecom", type = {ContactPoint.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A contact detail for the practitioner (that apply to all roles)", formalDefinition="A contact detail for the practitioner, e.g. a telephone number or an email address." )
    protected List<ContactPoint> telecom;

    /**
     * Indicates if the practitioner is deceased or not.
     */
    @Child(name = "deceased", type = {BooleanType.class, DateTimeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Indicates if the practitioner is deceased or not", formalDefinition="Indicates if the practitioner is deceased or not." )
    protected DataType deceased;

    /**
     * Address(es) of the practitioner that are not role specific (typically home address). Work addresses are not typically entered in this property as they are usually role dependent.
     */
    @Child(name = "address", type = {Address.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Address(es) of the practitioner that are not role specific (typically home address)", formalDefinition="Address(es) of the practitioner that are not role specific (typically home address). \rWork addresses are not typically entered in this property as they are usually role dependent." )
    protected List<Address> address;

    /**
     * Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.
     */
    @Child(name = "gender", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="male | female | other | unknown", formalDefinition="Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrative-gender")
    protected Enumeration<AdministrativeGender> gender;

    /**
     * The date of birth for the practitioner.
     */
    @Child(name = "birthDate", type = {DateType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date  on which the practitioner was born", formalDefinition="The date of birth for the practitioner." )
    protected DateType birthDate;

    /**
     * Image of the person.
     */
    @Child(name = "photo", type = {Attachment.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Image of the person", formalDefinition="Image of the person." )
    protected List<Attachment> photo;

    /**
     * The official certifications, training, and licenses that authorize or otherwise pertain to the provision of care by the practitioner.  For example, a medical license issued by a medical board authorizing the practitioner to practice medicine within a certain locality.
     */
    @Child(name = "qualification", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Certification, licenses, or training pertaining to the provision of care", formalDefinition="The official certifications, training, and licenses that authorize or otherwise pertain to the provision of care by the practitioner.  For example, a medical license issued by a medical board authorizing the practitioner to practice medicine within a certain locality." )
    protected List<PractitionerQualificationComponent> qualification;

    /**
     * A language the practitioner can use in patient communication.
     */
    @Child(name = "communication", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A language the practitioner can use in patient communication", formalDefinition="A language the practitioner can use in patient communication." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
    protected List<CodeableConcept> communication;

    private static final long serialVersionUID = 908417317L;

  /**
   * Constructor
   */
    public Practitioner() {
      super();
    }

    /**
     * @return {@link #identifier} (An identifier that applies to this person in this role.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setIdentifier(List<Identifier> theIdentifier) { 
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

    public Practitioner addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (Whether this practitioner's record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Practitioner.active");
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
     * @param value {@link #active} (Whether this practitioner's record is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public Practitioner setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return Whether this practitioner's record is in active use.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value Whether this practitioner's record is in active use.
     */
    public Practitioner setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #name} (The name(s) associated with the practitioner.)
     */
    public List<HumanName> getName() { 
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setName(List<HumanName> theName) { 
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

    public Practitioner addName(HumanName t) { //3
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
     * @return {@link #telecom} (A contact detail for the practitioner, e.g. a telephone number or an email address.)
     */
    public List<ContactPoint> getTelecom() { 
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      return this.telecom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setTelecom(List<ContactPoint> theTelecom) { 
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

    public Practitioner addTelecom(ContactPoint t) { //3
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
     * @return {@link #deceased} (Indicates if the practitioner is deceased or not.)
     */
    public DataType getDeceased() { 
      return this.deceased;
    }

    /**
     * @return {@link #deceased} (Indicates if the practitioner is deceased or not.)
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
     * @return {@link #deceased} (Indicates if the practitioner is deceased or not.)
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
     * @param value {@link #deceased} (Indicates if the practitioner is deceased or not.)
     */
    public Practitioner setDeceased(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof DateTimeType))
        throw new Error("Not the right type for Practitioner.deceased[x]: "+value.fhirType());
      this.deceased = value;
      return this;
    }

    /**
     * @return {@link #address} (Address(es) of the practitioner that are not role specific (typically home address). Work addresses are not typically entered in this property as they are usually role dependent.)
     */
    public List<Address> getAddress() { 
      if (this.address == null)
        this.address = new ArrayList<Address>();
      return this.address;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setAddress(List<Address> theAddress) { 
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

    public Practitioner addAddress(Address t) { //3
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
     * @return {@link #gender} (Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
     */
    public Enumeration<AdministrativeGender> getGenderElement() { 
      if (this.gender == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Practitioner.gender");
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
    public Practitioner setGenderElement(Enumeration<AdministrativeGender> value) { 
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
    public Practitioner setGender(AdministrativeGender value) { 
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
     * @return {@link #birthDate} (The date of birth for the practitioner.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public DateType getBirthDateElement() { 
      if (this.birthDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Practitioner.birthDate");
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
     * @param value {@link #birthDate} (The date of birth for the practitioner.). This is the underlying object with id, value and extensions. The accessor "getBirthDate" gives direct access to the value
     */
    public Practitioner setBirthDateElement(DateType value) { 
      this.birthDate = value;
      return this;
    }

    /**
     * @return The date of birth for the practitioner.
     */
    public Date getBirthDate() { 
      return this.birthDate == null ? null : this.birthDate.getValue();
    }

    /**
     * @param value The date of birth for the practitioner.
     */
    public Practitioner setBirthDate(Date value) { 
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
    public Practitioner setPhoto(List<Attachment> thePhoto) { 
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

    public Practitioner addPhoto(Attachment t) { //3
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
     * @return {@link #qualification} (The official certifications, training, and licenses that authorize or otherwise pertain to the provision of care by the practitioner.  For example, a medical license issued by a medical board authorizing the practitioner to practice medicine within a certain locality.)
     */
    public List<PractitionerQualificationComponent> getQualification() { 
      if (this.qualification == null)
        this.qualification = new ArrayList<PractitionerQualificationComponent>();
      return this.qualification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setQualification(List<PractitionerQualificationComponent> theQualification) { 
      this.qualification = theQualification;
      return this;
    }

    public boolean hasQualification() { 
      if (this.qualification == null)
        return false;
      for (PractitionerQualificationComponent item : this.qualification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PractitionerQualificationComponent addQualification() { //3
      PractitionerQualificationComponent t = new PractitionerQualificationComponent();
      if (this.qualification == null)
        this.qualification = new ArrayList<PractitionerQualificationComponent>();
      this.qualification.add(t);
      return t;
    }

    public Practitioner addQualification(PractitionerQualificationComponent t) { //3
      if (t == null)
        return this;
      if (this.qualification == null)
        this.qualification = new ArrayList<PractitionerQualificationComponent>();
      this.qualification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #qualification}, creating it if it does not already exist {3}
     */
    public PractitionerQualificationComponent getQualificationFirstRep() { 
      if (getQualification().isEmpty()) {
        addQualification();
      }
      return getQualification().get(0);
    }

    /**
     * @return {@link #communication} (A language the practitioner can use in patient communication.)
     */
    public List<CodeableConcept> getCommunication() { 
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      return this.communication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Practitioner setCommunication(List<CodeableConcept> theCommunication) { 
      this.communication = theCommunication;
      return this;
    }

    public boolean hasCommunication() { 
      if (this.communication == null)
        return false;
      for (CodeableConcept item : this.communication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCommunication() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      this.communication.add(t);
      return t;
    }

    public Practitioner addCommunication(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      this.communication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #communication}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCommunicationFirstRep() { 
      if (getCommunication().isEmpty()) {
        addCommunication();
      }
      return getCommunication().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "An identifier that applies to this person in this role.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "Whether this practitioner's record is in active use.", 0, 1, active));
        children.add(new Property("name", "HumanName", "The name(s) associated with the practitioner.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("telecom", "ContactPoint", "A contact detail for the practitioner, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom));
        children.add(new Property("deceased[x]", "boolean|dateTime", "Indicates if the practitioner is deceased or not.", 0, 1, deceased));
        children.add(new Property("address", "Address", "Address(es) of the practitioner that are not role specific (typically home address). \rWork addresses are not typically entered in this property as they are usually role dependent.", 0, java.lang.Integer.MAX_VALUE, address));
        children.add(new Property("gender", "code", "Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.", 0, 1, gender));
        children.add(new Property("birthDate", "date", "The date of birth for the practitioner.", 0, 1, birthDate));
        children.add(new Property("photo", "Attachment", "Image of the person.", 0, java.lang.Integer.MAX_VALUE, photo));
        children.add(new Property("qualification", "", "The official certifications, training, and licenses that authorize or otherwise pertain to the provision of care by the practitioner.  For example, a medical license issued by a medical board authorizing the practitioner to practice medicine within a certain locality.", 0, java.lang.Integer.MAX_VALUE, qualification));
        children.add(new Property("communication", "CodeableConcept", "A language the practitioner can use in patient communication.", 0, java.lang.Integer.MAX_VALUE, communication));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "An identifier that applies to this person in this role.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "Whether this practitioner's record is in active use.", 0, 1, active);
        case 3373707: /*name*/  return new Property("name", "HumanName", "The name(s) associated with the practitioner.", 0, java.lang.Integer.MAX_VALUE, name);
        case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "A contact detail for the practitioner, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom);
        case -1311442804: /*deceased[x]*/  return new Property("deceased[x]", "boolean|dateTime", "Indicates if the practitioner is deceased or not.", 0, 1, deceased);
        case 561497972: /*deceased*/  return new Property("deceased[x]", "boolean|dateTime", "Indicates if the practitioner is deceased or not.", 0, 1, deceased);
        case 497463828: /*deceasedBoolean*/  return new Property("deceased[x]", "boolean", "Indicates if the practitioner is deceased or not.", 0, 1, deceased);
        case -1971804369: /*deceasedDateTime*/  return new Property("deceased[x]", "dateTime", "Indicates if the practitioner is deceased or not.", 0, 1, deceased);
        case -1147692044: /*address*/  return new Property("address", "Address", "Address(es) of the practitioner that are not role specific (typically home address). \rWork addresses are not typically entered in this property as they are usually role dependent.", 0, java.lang.Integer.MAX_VALUE, address);
        case -1249512767: /*gender*/  return new Property("gender", "code", "Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.", 0, 1, gender);
        case -1210031859: /*birthDate*/  return new Property("birthDate", "date", "The date of birth for the practitioner.", 0, 1, birthDate);
        case 106642994: /*photo*/  return new Property("photo", "Attachment", "Image of the person.", 0, java.lang.Integer.MAX_VALUE, photo);
        case -631333393: /*qualification*/  return new Property("qualification", "", "The official certifications, training, and licenses that authorize or otherwise pertain to the provision of care by the practitioner.  For example, a medical license issued by a medical board authorizing the practitioner to practice medicine within a certain locality.", 0, java.lang.Integer.MAX_VALUE, qualification);
        case -1035284522: /*communication*/  return new Property("communication", "CodeableConcept", "A language the practitioner can use in patient communication.", 0, java.lang.Integer.MAX_VALUE, communication);
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
        case 561497972: /*deceased*/ return this.deceased == null ? new Base[0] : new Base[] {this.deceased}; // DataType
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // Address
        case -1249512767: /*gender*/ return this.gender == null ? new Base[0] : new Base[] {this.gender}; // Enumeration<AdministrativeGender>
        case -1210031859: /*birthDate*/ return this.birthDate == null ? new Base[0] : new Base[] {this.birthDate}; // DateType
        case 106642994: /*photo*/ return this.photo == null ? new Base[0] : this.photo.toArray(new Base[this.photo.size()]); // Attachment
        case -631333393: /*qualification*/ return this.qualification == null ? new Base[0] : this.qualification.toArray(new Base[this.qualification.size()]); // PractitionerQualificationComponent
        case -1035284522: /*communication*/ return this.communication == null ? new Base[0] : this.communication.toArray(new Base[this.communication.size()]); // CodeableConcept
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
        case 561497972: // deceased
          this.deceased = TypeConvertor.castToType(value); // DataType
          return value;
        case -1147692044: // address
          this.getAddress().add(TypeConvertor.castToAddress(value)); // Address
          return value;
        case -1249512767: // gender
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
          return value;
        case -1210031859: // birthDate
          this.birthDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case 106642994: // photo
          this.getPhoto().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -631333393: // qualification
          this.getQualification().add((PractitionerQualificationComponent) value); // PractitionerQualificationComponent
          return value;
        case -1035284522: // communication
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        } else if (name.equals("deceased[x]")) {
          this.deceased = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("address")) {
          this.getAddress().add(TypeConvertor.castToAddress(value));
        } else if (name.equals("gender")) {
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
        } else if (name.equals("birthDate")) {
          this.birthDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("photo")) {
          this.getPhoto().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("qualification")) {
          this.getQualification().add((PractitionerQualificationComponent) value);
        } else if (name.equals("communication")) {
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value));
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
        case -1311442804:  return getDeceased();
        case 561497972:  return getDeceased();
        case -1147692044:  return addAddress(); 
        case -1249512767:  return getGenderElement();
        case -1210031859:  return getBirthDateElement();
        case 106642994:  return addPhoto(); 
        case -631333393:  return addQualification(); 
        case -1035284522:  return addCommunication(); 
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
        case 561497972: /*deceased*/ return new String[] {"boolean", "dateTime"};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case -1249512767: /*gender*/ return new String[] {"code"};
        case -1210031859: /*birthDate*/ return new String[] {"date"};
        case 106642994: /*photo*/ return new String[] {"Attachment"};
        case -631333393: /*qualification*/ return new String[] {};
        case -1035284522: /*communication*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type Practitioner.active");
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
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
        else if (name.equals("gender")) {
          throw new FHIRException("Cannot call addChild on a primitive type Practitioner.gender");
        }
        else if (name.equals("birthDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Practitioner.birthDate");
        }
        else if (name.equals("photo")) {
          return addPhoto();
        }
        else if (name.equals("qualification")) {
          return addQualification();
        }
        else if (name.equals("communication")) {
          return addCommunication();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Practitioner";

  }

      public Practitioner copy() {
        Practitioner dst = new Practitioner();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Practitioner dst) {
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
        dst.deceased = deceased == null ? null : deceased.copy();
        if (address != null) {
          dst.address = new ArrayList<Address>();
          for (Address i : address)
            dst.address.add(i.copy());
        };
        dst.gender = gender == null ? null : gender.copy();
        dst.birthDate = birthDate == null ? null : birthDate.copy();
        if (photo != null) {
          dst.photo = new ArrayList<Attachment>();
          for (Attachment i : photo)
            dst.photo.add(i.copy());
        };
        if (qualification != null) {
          dst.qualification = new ArrayList<PractitionerQualificationComponent>();
          for (PractitionerQualificationComponent i : qualification)
            dst.qualification.add(i.copy());
        };
        if (communication != null) {
          dst.communication = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : communication)
            dst.communication.add(i.copy());
        };
      }

      protected Practitioner typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Practitioner))
          return false;
        Practitioner o = (Practitioner) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(name, o.name, true)
           && compareDeep(telecom, o.telecom, true) && compareDeep(deceased, o.deceased, true) && compareDeep(address, o.address, true)
           && compareDeep(gender, o.gender, true) && compareDeep(birthDate, o.birthDate, true) && compareDeep(photo, o.photo, true)
           && compareDeep(qualification, o.qualification, true) && compareDeep(communication, o.communication, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Practitioner))
          return false;
        Practitioner o = (Practitioner) other_;
        return compareValues(active, o.active, true) && compareValues(gender, o.gender, true) && compareValues(birthDate, o.birthDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, name
          , telecom, deceased, address, gender, birthDate, photo, qualification, communication
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Practitioner;
   }


}

