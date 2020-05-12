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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
 * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).
 */
@ResourceDef(name="MedicinalProductDefinition", profile="http://hl7.org/fhir/StructureDefinition/MedicinalProductDefinition")
public class MedicinalProductDefinition extends DomainResource {

    @Block()
    public static class MedicinalProductDefinitionContactComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information", formalDefinition="Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information." )
        protected CodeableConcept type;

        /**
         * A product specific contact, person (in a role), or an organization.
         */
        @Child(name = "contact", type = {Organization.class, PractitionerRole.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A product specific contact, person (in a role), or an organization", formalDefinition="A product specific contact, person (in a role), or an organization." )
        protected Reference contact;

        private static final long serialVersionUID = -587616244L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionContactComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionContactComponent(Reference contact) {
        super();
        this.setContact(contact);
      }

        /**
         * @return {@link #type} (Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionContactComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information.)
         */
        public MedicinalProductDefinitionContactComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #contact} (A product specific contact, person (in a role), or an organization.)
         */
        public Reference getContact() { 
          if (this.contact == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionContactComponent.contact");
            else if (Configuration.doAutoCreate())
              this.contact = new Reference(); // cc
          return this.contact;
        }

        public boolean hasContact() { 
          return this.contact != null && !this.contact.isEmpty();
        }

        /**
         * @param value {@link #contact} (A product specific contact, person (in a role), or an organization.)
         */
        public MedicinalProductDefinitionContactComponent setContact(Reference value) { 
          this.contact = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information.", 0, 1, type));
          children.add(new Property("contact", "Reference(Organization|PractitionerRole)", "A product specific contact, person (in a role), or an organization.", 0, 1, contact));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Allows the contact to be classified, for example QPPV, Pharmacovigilence Enquiry Information.", 0, 1, type);
          case 951526432: /*contact*/  return new Property("contact", "Reference(Organization|PractitionerRole)", "A product specific contact, person (in a role), or an organization.", 0, 1, contact);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : new Base[] {this.contact}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 951526432: // contact
          this.contact = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("contact")) {
          this.contact = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 951526432:  return getContact();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 951526432: /*contact*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("contact")) {
          this.contact = new Reference();
          return this.contact;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionContactComponent copy() {
        MedicinalProductDefinitionContactComponent dst = new MedicinalProductDefinitionContactComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionContactComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.contact = contact == null ? null : contact.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionContactComponent))
          return false;
        MedicinalProductDefinitionContactComponent o = (MedicinalProductDefinitionContactComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(contact, o.contact, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionContactComponent))
          return false;
        MedicinalProductDefinitionContactComponent o = (MedicinalProductDefinitionContactComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, contact);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.contact";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionNameComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The full product name.
         */
        @Child(name = "productName", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The full product name", formalDefinition="The full product name." )
        protected StringType productName;

        /**
         * Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary", formalDefinition="Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary." )
        protected CodeableConcept type;

        /**
         * Coding words or phrases of the name.
         */
        @Child(name = "namePart", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Coding words or phrases of the name", formalDefinition="Coding words or phrases of the name." )
        protected List<MedicinalProductDefinitionNameNamePartComponent> namePart;

        /**
         * Country where the name applies.
         */
        @Child(name = "countryLanguage", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Country where the name applies", formalDefinition="Country where the name applies." )
        protected List<MedicinalProductDefinitionNameCountryLanguageComponent> countryLanguage;

        private static final long serialVersionUID = 829861294L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameComponent(String productName) {
        super();
        this.setProductName(productName);
      }

        /**
         * @return {@link #productName} (The full product name.). This is the underlying object with id, value and extensions. The accessor "getProductName" gives direct access to the value
         */
        public StringType getProductNameElement() { 
          if (this.productName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameComponent.productName");
            else if (Configuration.doAutoCreate())
              this.productName = new StringType(); // bb
          return this.productName;
        }

        public boolean hasProductNameElement() { 
          return this.productName != null && !this.productName.isEmpty();
        }

        public boolean hasProductName() { 
          return this.productName != null && !this.productName.isEmpty();
        }

        /**
         * @param value {@link #productName} (The full product name.). This is the underlying object with id, value and extensions. The accessor "getProductName" gives direct access to the value
         */
        public MedicinalProductDefinitionNameComponent setProductNameElement(StringType value) { 
          this.productName = value;
          return this;
        }

        /**
         * @return The full product name.
         */
        public String getProductName() { 
          return this.productName == null ? null : this.productName.getValue();
        }

        /**
         * @param value The full product name.
         */
        public MedicinalProductDefinitionNameComponent setProductName(String value) { 
            if (this.productName == null)
              this.productName = new StringType();
            this.productName.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.)
         */
        public MedicinalProductDefinitionNameComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #namePart} (Coding words or phrases of the name.)
         */
        public List<MedicinalProductDefinitionNameNamePartComponent> getNamePart() { 
          if (this.namePart == null)
            this.namePart = new ArrayList<MedicinalProductDefinitionNameNamePartComponent>();
          return this.namePart;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionNameComponent setNamePart(List<MedicinalProductDefinitionNameNamePartComponent> theNamePart) { 
          this.namePart = theNamePart;
          return this;
        }

        public boolean hasNamePart() { 
          if (this.namePart == null)
            return false;
          for (MedicinalProductDefinitionNameNamePartComponent item : this.namePart)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicinalProductDefinitionNameNamePartComponent addNamePart() { //3
          MedicinalProductDefinitionNameNamePartComponent t = new MedicinalProductDefinitionNameNamePartComponent();
          if (this.namePart == null)
            this.namePart = new ArrayList<MedicinalProductDefinitionNameNamePartComponent>();
          this.namePart.add(t);
          return t;
        }

        public MedicinalProductDefinitionNameComponent addNamePart(MedicinalProductDefinitionNameNamePartComponent t) { //3
          if (t == null)
            return this;
          if (this.namePart == null)
            this.namePart = new ArrayList<MedicinalProductDefinitionNameNamePartComponent>();
          this.namePart.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #namePart}, creating it if it does not already exist {3}
         */
        public MedicinalProductDefinitionNameNamePartComponent getNamePartFirstRep() { 
          if (getNamePart().isEmpty()) {
            addNamePart();
          }
          return getNamePart().get(0);
        }

        /**
         * @return {@link #countryLanguage} (Country where the name applies.)
         */
        public List<MedicinalProductDefinitionNameCountryLanguageComponent> getCountryLanguage() { 
          if (this.countryLanguage == null)
            this.countryLanguage = new ArrayList<MedicinalProductDefinitionNameCountryLanguageComponent>();
          return this.countryLanguage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionNameComponent setCountryLanguage(List<MedicinalProductDefinitionNameCountryLanguageComponent> theCountryLanguage) { 
          this.countryLanguage = theCountryLanguage;
          return this;
        }

        public boolean hasCountryLanguage() { 
          if (this.countryLanguage == null)
            return false;
          for (MedicinalProductDefinitionNameCountryLanguageComponent item : this.countryLanguage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicinalProductDefinitionNameCountryLanguageComponent addCountryLanguage() { //3
          MedicinalProductDefinitionNameCountryLanguageComponent t = new MedicinalProductDefinitionNameCountryLanguageComponent();
          if (this.countryLanguage == null)
            this.countryLanguage = new ArrayList<MedicinalProductDefinitionNameCountryLanguageComponent>();
          this.countryLanguage.add(t);
          return t;
        }

        public MedicinalProductDefinitionNameComponent addCountryLanguage(MedicinalProductDefinitionNameCountryLanguageComponent t) { //3
          if (t == null)
            return this;
          if (this.countryLanguage == null)
            this.countryLanguage = new ArrayList<MedicinalProductDefinitionNameCountryLanguageComponent>();
          this.countryLanguage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #countryLanguage}, creating it if it does not already exist {3}
         */
        public MedicinalProductDefinitionNameCountryLanguageComponent getCountryLanguageFirstRep() { 
          if (getCountryLanguage().isEmpty()) {
            addCountryLanguage();
          }
          return getCountryLanguage().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("productName", "string", "The full product name.", 0, 1, productName));
          children.add(new Property("type", "CodeableConcept", "Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.", 0, 1, type));
          children.add(new Property("namePart", "", "Coding words or phrases of the name.", 0, java.lang.Integer.MAX_VALUE, namePart));
          children.add(new Property("countryLanguage", "", "Country where the name applies.", 0, java.lang.Integer.MAX_VALUE, countryLanguage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1491817446: /*productName*/  return new Property("productName", "string", "The full product name.", 0, 1, productName);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.", 0, 1, type);
          case 1840452894: /*namePart*/  return new Property("namePart", "", "Coding words or phrases of the name.", 0, java.lang.Integer.MAX_VALUE, namePart);
          case -141141746: /*countryLanguage*/  return new Property("countryLanguage", "", "Country where the name applies.", 0, java.lang.Integer.MAX_VALUE, countryLanguage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1491817446: /*productName*/ return this.productName == null ? new Base[0] : new Base[] {this.productName}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1840452894: /*namePart*/ return this.namePart == null ? new Base[0] : this.namePart.toArray(new Base[this.namePart.size()]); // MedicinalProductDefinitionNameNamePartComponent
        case -141141746: /*countryLanguage*/ return this.countryLanguage == null ? new Base[0] : this.countryLanguage.toArray(new Base[this.countryLanguage.size()]); // MedicinalProductDefinitionNameCountryLanguageComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1491817446: // productName
          this.productName = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1840452894: // namePart
          this.getNamePart().add((MedicinalProductDefinitionNameNamePartComponent) value); // MedicinalProductDefinitionNameNamePartComponent
          return value;
        case -141141746: // countryLanguage
          this.getCountryLanguage().add((MedicinalProductDefinitionNameCountryLanguageComponent) value); // MedicinalProductDefinitionNameCountryLanguageComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("productName")) {
          this.productName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("namePart")) {
          this.getNamePart().add((MedicinalProductDefinitionNameNamePartComponent) value);
        } else if (name.equals("countryLanguage")) {
          this.getCountryLanguage().add((MedicinalProductDefinitionNameCountryLanguageComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1491817446:  return getProductNameElement();
        case 3575610:  return getType();
        case 1840452894:  return addNamePart(); 
        case -141141746:  return addCountryLanguage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1491817446: /*productName*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1840452894: /*namePart*/ return new String[] {};
        case -141141746: /*countryLanguage*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("productName")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.name.productName");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("namePart")) {
          return addNamePart();
        }
        else if (name.equals("countryLanguage")) {
          return addCountryLanguage();
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionNameComponent copy() {
        MedicinalProductDefinitionNameComponent dst = new MedicinalProductDefinitionNameComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionNameComponent dst) {
        super.copyValues(dst);
        dst.productName = productName == null ? null : productName.copy();
        dst.type = type == null ? null : type.copy();
        if (namePart != null) {
          dst.namePart = new ArrayList<MedicinalProductDefinitionNameNamePartComponent>();
          for (MedicinalProductDefinitionNameNamePartComponent i : namePart)
            dst.namePart.add(i.copy());
        };
        if (countryLanguage != null) {
          dst.countryLanguage = new ArrayList<MedicinalProductDefinitionNameCountryLanguageComponent>();
          for (MedicinalProductDefinitionNameCountryLanguageComponent i : countryLanguage)
            dst.countryLanguage.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameComponent))
          return false;
        MedicinalProductDefinitionNameComponent o = (MedicinalProductDefinitionNameComponent) other_;
        return compareDeep(productName, o.productName, true) && compareDeep(type, o.type, true) && compareDeep(namePart, o.namePart, true)
           && compareDeep(countryLanguage, o.countryLanguage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameComponent))
          return false;
        MedicinalProductDefinitionNameComponent o = (MedicinalProductDefinitionNameComponent) other_;
        return compareValues(productName, o.productName, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(productName, type, namePart
          , countryLanguage);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionNameNamePartComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A fragment of a product name.
         */
        @Child(name = "part", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A fragment of a product name", formalDefinition="A fragment of a product name." )
        protected StringType part;

        /**
         * Idenifying type for this part of the name (e.g. strength part).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Idenifying type for this part of the name (e.g. strength part)", formalDefinition="Idenifying type for this part of the name (e.g. strength part)." )
        protected CodeableConcept type;

        private static final long serialVersionUID = -1359126549L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameNamePartComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameNamePartComponent(String part, CodeableConcept type) {
        super();
        this.setPart(part);
        this.setType(type);
      }

        /**
         * @return {@link #part} (A fragment of a product name.). This is the underlying object with id, value and extensions. The accessor "getPart" gives direct access to the value
         */
        public StringType getPartElement() { 
          if (this.part == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameNamePartComponent.part");
            else if (Configuration.doAutoCreate())
              this.part = new StringType(); // bb
          return this.part;
        }

        public boolean hasPartElement() { 
          return this.part != null && !this.part.isEmpty();
        }

        public boolean hasPart() { 
          return this.part != null && !this.part.isEmpty();
        }

        /**
         * @param value {@link #part} (A fragment of a product name.). This is the underlying object with id, value and extensions. The accessor "getPart" gives direct access to the value
         */
        public MedicinalProductDefinitionNameNamePartComponent setPartElement(StringType value) { 
          this.part = value;
          return this;
        }

        /**
         * @return A fragment of a product name.
         */
        public String getPart() { 
          return this.part == null ? null : this.part.getValue();
        }

        /**
         * @param value A fragment of a product name.
         */
        public MedicinalProductDefinitionNameNamePartComponent setPart(String value) { 
            if (this.part == null)
              this.part = new StringType();
            this.part.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Idenifying type for this part of the name (e.g. strength part).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameNamePartComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Idenifying type for this part of the name (e.g. strength part).)
         */
        public MedicinalProductDefinitionNameNamePartComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("part", "string", "A fragment of a product name.", 0, 1, part));
          children.add(new Property("type", "CodeableConcept", "Idenifying type for this part of the name (e.g. strength part).", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433459: /*part*/  return new Property("part", "string", "A fragment of a product name.", 0, 1, part);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Idenifying type for this part of the name (e.g. strength part).", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433459: /*part*/ return this.part == null ? new Base[0] : new Base[] {this.part}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433459: // part
          this.part = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("part")) {
          this.part = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433459:  return getPartElement();
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433459: /*part*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("part")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.name.namePart.part");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionNameNamePartComponent copy() {
        MedicinalProductDefinitionNameNamePartComponent dst = new MedicinalProductDefinitionNameNamePartComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionNameNamePartComponent dst) {
        super.copyValues(dst);
        dst.part = part == null ? null : part.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameNamePartComponent))
          return false;
        MedicinalProductDefinitionNameNamePartComponent o = (MedicinalProductDefinitionNameNamePartComponent) other_;
        return compareDeep(part, o.part, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameNamePartComponent))
          return false;
        MedicinalProductDefinitionNameNamePartComponent o = (MedicinalProductDefinitionNameNamePartComponent) other_;
        return compareValues(part, o.part, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(part, type);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name.namePart";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionNameCountryLanguageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Country code for where this name applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Country code for where this name applies", formalDefinition="Country code for where this name applies." )
        protected CodeableConcept country;

        /**
         * Jurisdiction code for where this name applies.
         */
        @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Jurisdiction code for where this name applies", formalDefinition="Jurisdiction code for where this name applies." )
        protected CodeableConcept jurisdiction;

        /**
         * Language code for this name.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Language code for this name", formalDefinition="Language code for this name." )
        protected CodeableConcept language;

        private static final long serialVersionUID = 1627157564L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameCountryLanguageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameCountryLanguageComponent(CodeableConcept country, CodeableConcept language) {
        super();
        this.setCountry(country);
        this.setLanguage(language);
      }

        /**
         * @return {@link #country} (Country code for where this name applies.)
         */
        public CodeableConcept getCountry() { 
          if (this.country == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameCountryLanguageComponent.country");
            else if (Configuration.doAutoCreate())
              this.country = new CodeableConcept(); // cc
          return this.country;
        }

        public boolean hasCountry() { 
          return this.country != null && !this.country.isEmpty();
        }

        /**
         * @param value {@link #country} (Country code for where this name applies.)
         */
        public MedicinalProductDefinitionNameCountryLanguageComponent setCountry(CodeableConcept value) { 
          this.country = value;
          return this;
        }

        /**
         * @return {@link #jurisdiction} (Jurisdiction code for where this name applies.)
         */
        public CodeableConcept getJurisdiction() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameCountryLanguageComponent.jurisdiction");
            else if (Configuration.doAutoCreate())
              this.jurisdiction = new CodeableConcept(); // cc
          return this.jurisdiction;
        }

        public boolean hasJurisdiction() { 
          return this.jurisdiction != null && !this.jurisdiction.isEmpty();
        }

        /**
         * @param value {@link #jurisdiction} (Jurisdiction code for where this name applies.)
         */
        public MedicinalProductDefinitionNameCountryLanguageComponent setJurisdiction(CodeableConcept value) { 
          this.jurisdiction = value;
          return this;
        }

        /**
         * @return {@link #language} (Language code for this name.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameCountryLanguageComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Language code for this name.)
         */
        public MedicinalProductDefinitionNameCountryLanguageComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("country", "CodeableConcept", "Country code for where this name applies.", 0, 1, country));
          children.add(new Property("jurisdiction", "CodeableConcept", "Jurisdiction code for where this name applies.", 0, 1, jurisdiction));
          children.add(new Property("language", "CodeableConcept", "Language code for this name.", 0, 1, language));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "Country code for where this name applies.", 0, 1, country);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "Jurisdiction code for where this name applies.", 0, 1, jurisdiction);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Language code for this name.", 0, 1, language);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 957831062: /*country*/ return this.country == null ? new Base[0] : new Base[] {this.country}; // CodeableConcept
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : new Base[] {this.jurisdiction}; // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 957831062: // country
          this.country = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -507075711: // jurisdiction
          this.jurisdiction = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("country")) {
          this.country = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("jurisdiction")) {
          this.jurisdiction = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 957831062:  return getCountry();
        case -507075711:  return getJurisdiction();
        case -1613589672:  return getLanguage();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 957831062: /*country*/ return new String[] {"CodeableConcept"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("country")) {
          this.country = new CodeableConcept();
          return this.country;
        }
        else if (name.equals("jurisdiction")) {
          this.jurisdiction = new CodeableConcept();
          return this.jurisdiction;
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionNameCountryLanguageComponent copy() {
        MedicinalProductDefinitionNameCountryLanguageComponent dst = new MedicinalProductDefinitionNameCountryLanguageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionNameCountryLanguageComponent dst) {
        super.copyValues(dst);
        dst.country = country == null ? null : country.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
        dst.language = language == null ? null : language.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameCountryLanguageComponent))
          return false;
        MedicinalProductDefinitionNameCountryLanguageComponent o = (MedicinalProductDefinitionNameCountryLanguageComponent) other_;
        return compareDeep(country, o.country, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(language, o.language, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameCountryLanguageComponent))
          return false;
        MedicinalProductDefinitionNameCountryLanguageComponent o = (MedicinalProductDefinitionNameCountryLanguageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(country, jurisdiction, language
          );
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name.countryLanguage";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionCrossReferenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to another product, e.g. for linking authorised to investigational product.
         */
        @Child(name = "product", type = {Identifier.class, MedicinalProductDefinition.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to another product, e.g. for linking authorised to investigational product", formalDefinition="Reference to another product, e.g. for linking authorised to investigational product." )
        protected DataType product;

        /**
         * The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version", formalDefinition="The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version." )
        protected CodeableConcept type;

        private static final long serialVersionUID = 606573338L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCrossReferenceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCrossReferenceComponent(DataType product) {
        super();
        this.setProduct(product);
      }

        /**
         * @return {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public DataType getProduct() { 
          return this.product;
        }

        /**
         * @return {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public Identifier getProductIdentifier() throws FHIRException { 
          if (this.product == null)
            this.product = new Identifier();
          if (!(this.product instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.product.getClass().getName()+" was encountered");
          return (Identifier) this.product;
        }

        public boolean hasProductIdentifier() { 
          return this != null && this.product instanceof Identifier;
        }

        /**
         * @return {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public Reference getProductReference() throws FHIRException { 
          if (this.product == null)
            this.product = new Reference();
          if (!(this.product instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.product.getClass().getName()+" was encountered");
          return (Reference) this.product;
        }

        public boolean hasProductReference() { 
          return this != null && this.product instanceof Reference;
        }

        public boolean hasProduct() { 
          return this.product != null && !this.product.isEmpty();
        }

        /**
         * @param value {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public MedicinalProductDefinitionCrossReferenceComponent setProduct(DataType value) { 
          if (value != null && !(value instanceof Identifier || value instanceof Reference))
            throw new Error("Not the right type for MedicinalProductDefinition.crossReference.product[x]: "+value.fhirType());
          this.product = value;
          return this;
        }

        /**
         * @return {@link #type} (The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionCrossReferenceComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version.)
         */
        public MedicinalProductDefinitionCrossReferenceComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("product[x]", "Identifier|Reference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product));
          children.add(new Property("type", "CodeableConcept", "The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1753005361: /*product[x]*/  return new Property("product[x]", "Identifier|Reference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product);
          case -309474065: /*product*/  return new Property("product[x]", "Identifier|Reference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product);
          case 2006726392: /*productIdentifier*/  return new Property("product[x]", "Identifier", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product);
          case -669667556: /*productReference*/  return new Property("product[x]", "Reference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of relationship, for instance branded to generic, product to development product (investigational), parallel import version.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // DataType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -309474065: // product
          this.product = TypeConvertor.castToType(value); // DataType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("product[x]")) {
          this.product = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1753005361:  return getProduct();
        case -309474065:  return getProduct();
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return new String[] {"Identifier", "Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("productIdentifier")) {
          this.product = new Identifier();
          return this.product;
        }
        else if (name.equals("productReference")) {
          this.product = new Reference();
          return this.product;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionCrossReferenceComponent copy() {
        MedicinalProductDefinitionCrossReferenceComponent dst = new MedicinalProductDefinitionCrossReferenceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionCrossReferenceComponent dst) {
        super.copyValues(dst);
        dst.product = product == null ? null : product.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionCrossReferenceComponent))
          return false;
        MedicinalProductDefinitionCrossReferenceComponent o = (MedicinalProductDefinitionCrossReferenceComponent) other_;
        return compareDeep(product, o.product, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionCrossReferenceComponent))
          return false;
        MedicinalProductDefinitionCrossReferenceComponent o = (MedicinalProductDefinitionCrossReferenceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(product, type);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.crossReference";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionManufacturingBusinessOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute.
         */
        @Child(name = "type", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute", formalDefinition="The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute." )
        protected CodeableReference type;

        /**
         * Date range of applicability.
         */
        @Child(name = "effectiveDate", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Date range of applicability", formalDefinition="Date range of applicability." )
        protected Period effectiveDate;

        /**
         * The manufacturer or establishment associated with the process.
         */
        @Child(name = "manufacturer", type = {Organization.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The manufacturer or establishment associated with the process", formalDefinition="The manufacturer or establishment associated with the process." )
        protected List<Reference> manufacturer;

        /**
         * An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part.
         */
        @Child(name = "authorization", type = {RegulatedAuthorization.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part", formalDefinition="An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part." )
        protected Reference authorization;

        /**
         * To indicate if this proces is commercially confidential.
         */
        @Child(name = "confidentialityIndicator", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="To indicate if this proces is commercially confidential", formalDefinition="To indicate if this proces is commercially confidential." )
        protected CodeableConcept confidentialityIndicator;

        private static final long serialVersionUID = 1855392466L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionManufacturingBusinessOperationComponent() {
        super();
      }

        /**
         * @return {@link #type} (The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute.)
         */
        public CodeableReference getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionManufacturingBusinessOperationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableReference(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute.)
         */
        public MedicinalProductDefinitionManufacturingBusinessOperationComponent setType(CodeableReference value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #effectiveDate} (Date range of applicability.)
         */
        public Period getEffectiveDate() { 
          if (this.effectiveDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionManufacturingBusinessOperationComponent.effectiveDate");
            else if (Configuration.doAutoCreate())
              this.effectiveDate = new Period(); // cc
          return this.effectiveDate;
        }

        public boolean hasEffectiveDate() { 
          return this.effectiveDate != null && !this.effectiveDate.isEmpty();
        }

        /**
         * @param value {@link #effectiveDate} (Date range of applicability.)
         */
        public MedicinalProductDefinitionManufacturingBusinessOperationComponent setEffectiveDate(Period value) { 
          this.effectiveDate = value;
          return this;
        }

        /**
         * @return {@link #manufacturer} (The manufacturer or establishment associated with the process.)
         */
        public List<Reference> getManufacturer() { 
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          return this.manufacturer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionManufacturingBusinessOperationComponent setManufacturer(List<Reference> theManufacturer) { 
          this.manufacturer = theManufacturer;
          return this;
        }

        public boolean hasManufacturer() { 
          if (this.manufacturer == null)
            return false;
          for (Reference item : this.manufacturer)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addManufacturer() { //3
          Reference t = new Reference();
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          this.manufacturer.add(t);
          return t;
        }

        public MedicinalProductDefinitionManufacturingBusinessOperationComponent addManufacturer(Reference t) { //3
          if (t == null)
            return this;
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          this.manufacturer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist {3}
         */
        public Reference getManufacturerFirstRep() { 
          if (getManufacturer().isEmpty()) {
            addManufacturer();
          }
          return getManufacturer().get(0);
        }

        /**
         * @return {@link #authorization} (An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part.)
         */
        public Reference getAuthorization() { 
          if (this.authorization == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionManufacturingBusinessOperationComponent.authorization");
            else if (Configuration.doAutoCreate())
              this.authorization = new Reference(); // cc
          return this.authorization;
        }

        public boolean hasAuthorization() { 
          return this.authorization != null && !this.authorization.isEmpty();
        }

        /**
         * @param value {@link #authorization} (An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part.)
         */
        public MedicinalProductDefinitionManufacturingBusinessOperationComponent setAuthorization(Reference value) { 
          this.authorization = value;
          return this;
        }

        /**
         * @return {@link #confidentialityIndicator} (To indicate if this proces is commercially confidential.)
         */
        public CodeableConcept getConfidentialityIndicator() { 
          if (this.confidentialityIndicator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionManufacturingBusinessOperationComponent.confidentialityIndicator");
            else if (Configuration.doAutoCreate())
              this.confidentialityIndicator = new CodeableConcept(); // cc
          return this.confidentialityIndicator;
        }

        public boolean hasConfidentialityIndicator() { 
          return this.confidentialityIndicator != null && !this.confidentialityIndicator.isEmpty();
        }

        /**
         * @param value {@link #confidentialityIndicator} (To indicate if this proces is commercially confidential.)
         */
        public MedicinalProductDefinitionManufacturingBusinessOperationComponent setConfidentialityIndicator(CodeableConcept value) { 
          this.confidentialityIndicator = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableReference(ActivityDefinition)", "The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute.", 0, 1, type));
          children.add(new Property("effectiveDate", "Period", "Date range of applicability.", 0, 1, effectiveDate));
          children.add(new Property("manufacturer", "Reference(Organization)", "The manufacturer or establishment associated with the process.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
          children.add(new Property("authorization", "Reference(RegulatedAuthorization)", "An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part.", 0, 1, authorization));
          children.add(new Property("confidentialityIndicator", "CodeableConcept", "To indicate if this proces is commercially confidential.", 0, 1, confidentialityIndicator));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableReference(ActivityDefinition)", "The type of manufacturing operation e.g. manufacturing itself, re-packaging. This may be a subtype of some other wider scope of authorized operation, referenced by the authorization attribute.", 0, 1, type);
          case -930389515: /*effectiveDate*/  return new Property("effectiveDate", "Period", "Date range of applicability.", 0, 1, effectiveDate);
          case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "The manufacturer or establishment associated with the process.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
          case -1385570183: /*authorization*/  return new Property("authorization", "Reference(RegulatedAuthorization)", "An authorization for this process, either as a logical reference, holding just an identifier, or a full refererence to a resource that captures the details. The authorization mayu possibly apply to several products or a wider scope of process of which this is a part.", 0, 1, authorization);
          case -1449404791: /*confidentialityIndicator*/  return new Property("confidentialityIndicator", "CodeableConcept", "To indicate if this proces is commercially confidential.", 0, 1, confidentialityIndicator);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableReference
        case -930389515: /*effectiveDate*/ return this.effectiveDate == null ? new Base[0] : new Base[] {this.effectiveDate}; // Period
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -1385570183: /*authorization*/ return this.authorization == null ? new Base[0] : new Base[] {this.authorization}; // Reference
        case -1449404791: /*confidentialityIndicator*/ return this.confidentialityIndicator == null ? new Base[0] : new Base[] {this.confidentialityIndicator}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -930389515: // effectiveDate
          this.effectiveDate = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1385570183: // authorization
          this.authorization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1449404791: // confidentialityIndicator
          this.confidentialityIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("effectiveDate")) {
          this.effectiveDate = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("authorization")) {
          this.authorization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("confidentialityIndicator")) {
          this.confidentialityIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -930389515:  return getEffectiveDate();
        case -1969347631:  return addManufacturer(); 
        case -1385570183:  return getAuthorization();
        case -1449404791:  return getConfidentialityIndicator();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableReference"};
        case -930389515: /*effectiveDate*/ return new String[] {"Period"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -1385570183: /*authorization*/ return new String[] {"Reference"};
        case -1449404791: /*confidentialityIndicator*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableReference();
          return this.type;
        }
        else if (name.equals("effectiveDate")) {
          this.effectiveDate = new Period();
          return this.effectiveDate;
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("authorization")) {
          this.authorization = new Reference();
          return this.authorization;
        }
        else if (name.equals("confidentialityIndicator")) {
          this.confidentialityIndicator = new CodeableConcept();
          return this.confidentialityIndicator;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionManufacturingBusinessOperationComponent copy() {
        MedicinalProductDefinitionManufacturingBusinessOperationComponent dst = new MedicinalProductDefinitionManufacturingBusinessOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionManufacturingBusinessOperationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.effectiveDate = effectiveDate == null ? null : effectiveDate.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        dst.authorization = authorization == null ? null : authorization.copy();
        dst.confidentialityIndicator = confidentialityIndicator == null ? null : confidentialityIndicator.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionManufacturingBusinessOperationComponent))
          return false;
        MedicinalProductDefinitionManufacturingBusinessOperationComponent o = (MedicinalProductDefinitionManufacturingBusinessOperationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(effectiveDate, o.effectiveDate, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(authorization, o.authorization, true) && compareDeep(confidentialityIndicator, o.confidentialityIndicator, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionManufacturingBusinessOperationComponent))
          return false;
        MedicinalProductDefinitionManufacturingBusinessOperationComponent o = (MedicinalProductDefinitionManufacturingBusinessOperationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, effectiveDate, manufacturer
          , authorization, confidentialityIndicator);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.manufacturingBusinessOperation";

  }

  }

    /**
     * Business identifier for this product. Could be an MPID.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this product. Could be an MPID", formalDefinition="Business identifier for this product. Could be an MPID." )
    protected List<Identifier> identifier;

    /**
     * Regulatory type, e.g. Investigational or Authorized.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Regulatory type, e.g. Investigational or Authorized", formalDefinition="Regulatory type, e.g. Investigational or Authorized." )
    protected CodeableConcept type;

    /**
     * If this medicine applies to human or veterinary uses.
     */
    @Child(name = "domain", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this medicine applies to human or veterinary uses", formalDefinition="If this medicine applies to human or veterinary uses." )
    protected CodeableConcept domain;

    /**
     * A business level identifier of the product.
     */
    @Child(name = "version", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A business level identifier of the product", formalDefinition="A business level identifier of the product." )
    protected StringType version;

    /**
     * The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status", formalDefinition="The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected CodeableConcept status;

    /**
     * The date at which the given status became applicable.
     */
    @Child(name = "statusDate", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date at which the given status became applicable", formalDefinition="The date at which the given status became applicable." )
    protected DateTimeType statusDate;

    /**
     * General description of this product.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General description of this product", formalDefinition="General description of this product." )
    protected MarkdownType description;

    /**
     * The dose form for a single part product, or combined form of a multiple part product.
     */
    @Child(name = "combinedPharmaceuticalDoseForm", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The dose form for a single part product, or combined form of a multiple part product", formalDefinition="The dose form for a single part product, or combined form of a multiple part product." )
    protected CodeableConcept combinedPharmaceuticalDoseForm;

    /**
     * General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.
     */
    @Child(name = "indication", type = {MarkdownType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication", formalDefinition="General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication." )
    protected MarkdownType indication;

    /**
     * The legal status of supply of the medicinal product as classified by the regulator.
     */
    @Child(name = "legalStatusOfSupply", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The legal status of supply of the medicinal product as classified by the regulator", formalDefinition="The legal status of supply of the medicinal product as classified by the regulator." )
    protected CodeableConcept legalStatusOfSupply;

    /**
     * Whether the Medicinal Product is subject to additional monitoring for regulatory reasons.
     */
    @Child(name = "additionalMonitoringIndicator", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether the Medicinal Product is subject to additional monitoring for regulatory reasons", formalDefinition="Whether the Medicinal Product is subject to additional monitoring for regulatory reasons." )
    protected CodeableConcept additionalMonitoringIndicator;

    /**
     * Whether the Medicinal Product is subject to special measures for regulatory reasons.
     */
    @Child(name = "specialMeasures", type = {CodeableConcept.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Whether the Medicinal Product is subject to special measures for regulatory reasons", formalDefinition="Whether the Medicinal Product is subject to special measures for regulatory reasons." )
    protected List<CodeableConcept> specialMeasures;

    /**
     * If authorised for use in children.
     */
    @Child(name = "paediatricUseIndicator", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If authorised for use in children", formalDefinition="If authorised for use in children." )
    protected CodeableConcept paediatricUseIndicator;

    /**
     * Allows the product to be classified by various systems.
     */
    @Child(name = "productClassification", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows the product to be classified by various systems", formalDefinition="Allows the product to be classified by various systems." )
    protected List<CodeableConcept> productClassification;

    /**
     * Allows the key product features to be recorded, such as "suger free", "modified release", "parallel import".
     */
    @Child(name = "characteristic", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows the key product features to be recorded, such as \"suger free\", \"modified release\", \"parallel import\"", formalDefinition="Allows the key product features to be recorded, such as \"suger free\", \"modified release\", \"parallel import\"." )
    protected List<CodeableConcept> characteristic;

    /**
     * Marketing status of the medicinal product, in contrast to marketing authorizaton.
     */
    @Child(name = "marketingStatus", type = {MarketingStatus.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Marketing status of the medicinal product, in contrast to marketing authorizaton", formalDefinition="Marketing status of the medicinal product, in contrast to marketing authorizaton." )
    protected List<MarketingStatus> marketingStatus;

    /**
     * Pharmaceutical aspects of product.
     */
    @Child(name = "pharmaceuticalProduct", type = {AdministrableProductDefinition.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Pharmaceutical aspects of product", formalDefinition="Pharmaceutical aspects of product." )
    protected List<Reference> pharmaceuticalProduct;

    /**
     * Package representation for the product.
     */
    @Child(name = "packagedMedicinalProduct", type = {PackagedProductDefinition.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Package representation for the product", formalDefinition="Package representation for the product." )
    protected List<Reference> packagedMedicinalProduct;

    /**
     * The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here.
     */
    @Child(name = "ingredient", type = {Ingredient.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here", formalDefinition="The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here." )
    protected List<Reference> ingredient;

    /**
     * Supporting documentation, typically for regulatory submission.
     */
    @Child(name = "attachedDocument", type = {DocumentReference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Supporting documentation, typically for regulatory submission", formalDefinition="Supporting documentation, typically for regulatory submission." )
    protected List<Reference> attachedDocument;

    /**
     * A master file for to the medicinal product (e.g. Pharmacovigilance System Master File).
     */
    @Child(name = "masterFile", type = {DocumentReference.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A master file for to the medicinal product (e.g. Pharmacovigilance System Master File)", formalDefinition="A master file for to the medicinal product (e.g. Pharmacovigilance System Master File)." )
    protected List<Reference> masterFile;

    /**
     * A product specific contact, person (in a role), or an organization.
     */
    @Child(name = "contact", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A product specific contact, person (in a role), or an organization", formalDefinition="A product specific contact, person (in a role), or an organization." )
    protected List<MedicinalProductDefinitionContactComponent> contact;

    /**
     * Clinical trials or studies that this product is involved in.
     */
    @Child(name = "clinicalTrial", type = {ResearchStudy.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Clinical trials or studies that this product is involved in", formalDefinition="Clinical trials or studies that this product is involved in." )
    protected List<Reference> clinicalTrial;

    /**
     * The product's name, including full name and possibly coded parts.
     */
    @Child(name = "name", type = {}, order=23, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The product's name, including full name and possibly coded parts", formalDefinition="The product's name, including full name and possibly coded parts." )
    protected List<MedicinalProductDefinitionNameComponent> name;

    /**
     * Reference to another product, e.g. for linking authorised to investigational product.
     */
    @Child(name = "crossReference", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Reference to another product, e.g. for linking authorised to investigational product", formalDefinition="Reference to another product, e.g. for linking authorised to investigational product." )
    protected List<MedicinalProductDefinitionCrossReferenceComponent> crossReference;

    /**
     * An operation applied to the product, for manufacturing or adminsitrative purpose.
     */
    @Child(name = "manufacturingBusinessOperation", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An operation applied to the product, for manufacturing or adminsitrative purpose", formalDefinition="An operation applied to the product, for manufacturing or adminsitrative purpose." )
    protected List<MedicinalProductDefinitionManufacturingBusinessOperationComponent> manufacturingBusinessOperation;

    private static final long serialVersionUID = -585909008L;

  /**
   * Constructor
   */
    public MedicinalProductDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public MedicinalProductDefinition(MedicinalProductDefinitionNameComponent name) {
      super();
      this.addName(name);
    }

    /**
     * @return {@link #identifier} (Business identifier for this product. Could be an MPID.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public MedicinalProductDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #type} (Regulatory type, e.g. Investigational or Authorized.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Regulatory type, e.g. Investigational or Authorized.)
     */
    public MedicinalProductDefinition setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #domain} (If this medicine applies to human or veterinary uses.)
     */
    public CodeableConcept getDomain() { 
      if (this.domain == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.domain");
        else if (Configuration.doAutoCreate())
          this.domain = new CodeableConcept(); // cc
      return this.domain;
    }

    public boolean hasDomain() { 
      return this.domain != null && !this.domain.isEmpty();
    }

    /**
     * @param value {@link #domain} (If this medicine applies to human or veterinary uses.)
     */
    public MedicinalProductDefinition setDomain(CodeableConcept value) { 
      this.domain = value;
      return this;
    }

    /**
     * @return {@link #version} (A business level identifier of the product.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.version");
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
     * @param value {@link #version} (A business level identifier of the product.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public MedicinalProductDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return A business level identifier of the product.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value A business level identifier of the product.
     */
    public MedicinalProductDefinition setVersion(String value) { 
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
     * @return {@link #status} (The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status.)
     */
    public MedicinalProductDefinition setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #statusDate} (The date at which the given status became applicable.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
     */
    public DateTimeType getStatusDateElement() { 
      if (this.statusDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.statusDate");
        else if (Configuration.doAutoCreate())
          this.statusDate = new DateTimeType(); // bb
      return this.statusDate;
    }

    public boolean hasStatusDateElement() { 
      return this.statusDate != null && !this.statusDate.isEmpty();
    }

    public boolean hasStatusDate() { 
      return this.statusDate != null && !this.statusDate.isEmpty();
    }

    /**
     * @param value {@link #statusDate} (The date at which the given status became applicable.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
     */
    public MedicinalProductDefinition setStatusDateElement(DateTimeType value) { 
      this.statusDate = value;
      return this;
    }

    /**
     * @return The date at which the given status became applicable.
     */
    public Date getStatusDate() { 
      return this.statusDate == null ? null : this.statusDate.getValue();
    }

    /**
     * @param value The date at which the given status became applicable.
     */
    public MedicinalProductDefinition setStatusDate(Date value) { 
      if (value == null)
        this.statusDate = null;
      else {
        if (this.statusDate == null)
          this.statusDate = new DateTimeType();
        this.statusDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #description} (General description of this product.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.description");
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
     * @param value {@link #description} (General description of this product.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MedicinalProductDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return General description of this product.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value General description of this product.
     */
    public MedicinalProductDefinition setDescription(String value) { 
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
     * @return {@link #combinedPharmaceuticalDoseForm} (The dose form for a single part product, or combined form of a multiple part product.)
     */
    public CodeableConcept getCombinedPharmaceuticalDoseForm() { 
      if (this.combinedPharmaceuticalDoseForm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.combinedPharmaceuticalDoseForm");
        else if (Configuration.doAutoCreate())
          this.combinedPharmaceuticalDoseForm = new CodeableConcept(); // cc
      return this.combinedPharmaceuticalDoseForm;
    }

    public boolean hasCombinedPharmaceuticalDoseForm() { 
      return this.combinedPharmaceuticalDoseForm != null && !this.combinedPharmaceuticalDoseForm.isEmpty();
    }

    /**
     * @param value {@link #combinedPharmaceuticalDoseForm} (The dose form for a single part product, or combined form of a multiple part product.)
     */
    public MedicinalProductDefinition setCombinedPharmaceuticalDoseForm(CodeableConcept value) { 
      this.combinedPharmaceuticalDoseForm = value;
      return this;
    }

    /**
     * @return {@link #indication} (General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.). This is the underlying object with id, value and extensions. The accessor "getIndication" gives direct access to the value
     */
    public MarkdownType getIndicationElement() { 
      if (this.indication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.indication");
        else if (Configuration.doAutoCreate())
          this.indication = new MarkdownType(); // bb
      return this.indication;
    }

    public boolean hasIndicationElement() { 
      return this.indication != null && !this.indication.isEmpty();
    }

    public boolean hasIndication() { 
      return this.indication != null && !this.indication.isEmpty();
    }

    /**
     * @param value {@link #indication} (General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.). This is the underlying object with id, value and extensions. The accessor "getIndication" gives direct access to the value
     */
    public MedicinalProductDefinition setIndicationElement(MarkdownType value) { 
      this.indication = value;
      return this;
    }

    /**
     * @return General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.
     */
    public String getIndication() { 
      return this.indication == null ? null : this.indication.getValue();
    }

    /**
     * @param value General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.
     */
    public MedicinalProductDefinition setIndication(String value) { 
      if (value == null)
        this.indication = null;
      else {
        if (this.indication == null)
          this.indication = new MarkdownType();
        this.indication.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #legalStatusOfSupply} (The legal status of supply of the medicinal product as classified by the regulator.)
     */
    public CodeableConcept getLegalStatusOfSupply() { 
      if (this.legalStatusOfSupply == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.legalStatusOfSupply");
        else if (Configuration.doAutoCreate())
          this.legalStatusOfSupply = new CodeableConcept(); // cc
      return this.legalStatusOfSupply;
    }

    public boolean hasLegalStatusOfSupply() { 
      return this.legalStatusOfSupply != null && !this.legalStatusOfSupply.isEmpty();
    }

    /**
     * @param value {@link #legalStatusOfSupply} (The legal status of supply of the medicinal product as classified by the regulator.)
     */
    public MedicinalProductDefinition setLegalStatusOfSupply(CodeableConcept value) { 
      this.legalStatusOfSupply = value;
      return this;
    }

    /**
     * @return {@link #additionalMonitoringIndicator} (Whether the Medicinal Product is subject to additional monitoring for regulatory reasons.)
     */
    public CodeableConcept getAdditionalMonitoringIndicator() { 
      if (this.additionalMonitoringIndicator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.additionalMonitoringIndicator");
        else if (Configuration.doAutoCreate())
          this.additionalMonitoringIndicator = new CodeableConcept(); // cc
      return this.additionalMonitoringIndicator;
    }

    public boolean hasAdditionalMonitoringIndicator() { 
      return this.additionalMonitoringIndicator != null && !this.additionalMonitoringIndicator.isEmpty();
    }

    /**
     * @param value {@link #additionalMonitoringIndicator} (Whether the Medicinal Product is subject to additional monitoring for regulatory reasons.)
     */
    public MedicinalProductDefinition setAdditionalMonitoringIndicator(CodeableConcept value) { 
      this.additionalMonitoringIndicator = value;
      return this;
    }

    /**
     * @return {@link #specialMeasures} (Whether the Medicinal Product is subject to special measures for regulatory reasons.)
     */
    public List<CodeableConcept> getSpecialMeasures() { 
      if (this.specialMeasures == null)
        this.specialMeasures = new ArrayList<CodeableConcept>();
      return this.specialMeasures;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setSpecialMeasures(List<CodeableConcept> theSpecialMeasures) { 
      this.specialMeasures = theSpecialMeasures;
      return this;
    }

    public boolean hasSpecialMeasures() { 
      if (this.specialMeasures == null)
        return false;
      for (CodeableConcept item : this.specialMeasures)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSpecialMeasures() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.specialMeasures == null)
        this.specialMeasures = new ArrayList<CodeableConcept>();
      this.specialMeasures.add(t);
      return t;
    }

    public MedicinalProductDefinition addSpecialMeasures(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.specialMeasures == null)
        this.specialMeasures = new ArrayList<CodeableConcept>();
      this.specialMeasures.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specialMeasures}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSpecialMeasuresFirstRep() { 
      if (getSpecialMeasures().isEmpty()) {
        addSpecialMeasures();
      }
      return getSpecialMeasures().get(0);
    }

    /**
     * @return {@link #paediatricUseIndicator} (If authorised for use in children.)
     */
    public CodeableConcept getPaediatricUseIndicator() { 
      if (this.paediatricUseIndicator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.paediatricUseIndicator");
        else if (Configuration.doAutoCreate())
          this.paediatricUseIndicator = new CodeableConcept(); // cc
      return this.paediatricUseIndicator;
    }

    public boolean hasPaediatricUseIndicator() { 
      return this.paediatricUseIndicator != null && !this.paediatricUseIndicator.isEmpty();
    }

    /**
     * @param value {@link #paediatricUseIndicator} (If authorised for use in children.)
     */
    public MedicinalProductDefinition setPaediatricUseIndicator(CodeableConcept value) { 
      this.paediatricUseIndicator = value;
      return this;
    }

    /**
     * @return {@link #productClassification} (Allows the product to be classified by various systems.)
     */
    public List<CodeableConcept> getProductClassification() { 
      if (this.productClassification == null)
        this.productClassification = new ArrayList<CodeableConcept>();
      return this.productClassification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setProductClassification(List<CodeableConcept> theProductClassification) { 
      this.productClassification = theProductClassification;
      return this;
    }

    public boolean hasProductClassification() { 
      if (this.productClassification == null)
        return false;
      for (CodeableConcept item : this.productClassification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addProductClassification() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.productClassification == null)
        this.productClassification = new ArrayList<CodeableConcept>();
      this.productClassification.add(t);
      return t;
    }

    public MedicinalProductDefinition addProductClassification(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.productClassification == null)
        this.productClassification = new ArrayList<CodeableConcept>();
      this.productClassification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #productClassification}, creating it if it does not already exist {3}
     */
    public CodeableConcept getProductClassificationFirstRep() { 
      if (getProductClassification().isEmpty()) {
        addProductClassification();
      }
      return getProductClassification().get(0);
    }

    /**
     * @return {@link #characteristic} (Allows the key product features to be recorded, such as "suger free", "modified release", "parallel import".)
     */
    public List<CodeableConcept> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setCharacteristic(List<CodeableConcept> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (CodeableConcept item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCharacteristic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return t;
    }

    public MedicinalProductDefinition addCharacteristic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #marketingStatus} (Marketing status of the medicinal product, in contrast to marketing authorizaton.)
     */
    public List<MarketingStatus> getMarketingStatus() { 
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      return this.marketingStatus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setMarketingStatus(List<MarketingStatus> theMarketingStatus) { 
      this.marketingStatus = theMarketingStatus;
      return this;
    }

    public boolean hasMarketingStatus() { 
      if (this.marketingStatus == null)
        return false;
      for (MarketingStatus item : this.marketingStatus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MarketingStatus addMarketingStatus() { //3
      MarketingStatus t = new MarketingStatus();
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      this.marketingStatus.add(t);
      return t;
    }

    public MedicinalProductDefinition addMarketingStatus(MarketingStatus t) { //3
      if (t == null)
        return this;
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      this.marketingStatus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #marketingStatus}, creating it if it does not already exist {3}
     */
    public MarketingStatus getMarketingStatusFirstRep() { 
      if (getMarketingStatus().isEmpty()) {
        addMarketingStatus();
      }
      return getMarketingStatus().get(0);
    }

    /**
     * @return {@link #pharmaceuticalProduct} (Pharmaceutical aspects of product.)
     */
    public List<Reference> getPharmaceuticalProduct() { 
      if (this.pharmaceuticalProduct == null)
        this.pharmaceuticalProduct = new ArrayList<Reference>();
      return this.pharmaceuticalProduct;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setPharmaceuticalProduct(List<Reference> thePharmaceuticalProduct) { 
      this.pharmaceuticalProduct = thePharmaceuticalProduct;
      return this;
    }

    public boolean hasPharmaceuticalProduct() { 
      if (this.pharmaceuticalProduct == null)
        return false;
      for (Reference item : this.pharmaceuticalProduct)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPharmaceuticalProduct() { //3
      Reference t = new Reference();
      if (this.pharmaceuticalProduct == null)
        this.pharmaceuticalProduct = new ArrayList<Reference>();
      this.pharmaceuticalProduct.add(t);
      return t;
    }

    public MedicinalProductDefinition addPharmaceuticalProduct(Reference t) { //3
      if (t == null)
        return this;
      if (this.pharmaceuticalProduct == null)
        this.pharmaceuticalProduct = new ArrayList<Reference>();
      this.pharmaceuticalProduct.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #pharmaceuticalProduct}, creating it if it does not already exist {3}
     */
    public Reference getPharmaceuticalProductFirstRep() { 
      if (getPharmaceuticalProduct().isEmpty()) {
        addPharmaceuticalProduct();
      }
      return getPharmaceuticalProduct().get(0);
    }

    /**
     * @return {@link #packagedMedicinalProduct} (Package representation for the product.)
     */
    public List<Reference> getPackagedMedicinalProduct() { 
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<Reference>();
      return this.packagedMedicinalProduct;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setPackagedMedicinalProduct(List<Reference> thePackagedMedicinalProduct) { 
      this.packagedMedicinalProduct = thePackagedMedicinalProduct;
      return this;
    }

    public boolean hasPackagedMedicinalProduct() { 
      if (this.packagedMedicinalProduct == null)
        return false;
      for (Reference item : this.packagedMedicinalProduct)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPackagedMedicinalProduct() { //3
      Reference t = new Reference();
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<Reference>();
      this.packagedMedicinalProduct.add(t);
      return t;
    }

    public MedicinalProductDefinition addPackagedMedicinalProduct(Reference t) { //3
      if (t == null)
        return this;
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<Reference>();
      this.packagedMedicinalProduct.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #packagedMedicinalProduct}, creating it if it does not already exist {3}
     */
    public Reference getPackagedMedicinalProductFirstRep() { 
      if (getPackagedMedicinalProduct().isEmpty()) {
        addPackagedMedicinalProduct();
      }
      return getPackagedMedicinalProduct().get(0);
    }

    /**
     * @return {@link #ingredient} (The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here.)
     */
    public List<Reference> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setIngredient(List<Reference> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (Reference item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addIngredient() { //3
      Reference t = new Reference();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      this.ingredient.add(t);
      return t;
    }

    public MedicinalProductDefinition addIngredient(Reference t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<Reference>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public Reference getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #attachedDocument} (Supporting documentation, typically for regulatory submission.)
     */
    public List<Reference> getAttachedDocument() { 
      if (this.attachedDocument == null)
        this.attachedDocument = new ArrayList<Reference>();
      return this.attachedDocument;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setAttachedDocument(List<Reference> theAttachedDocument) { 
      this.attachedDocument = theAttachedDocument;
      return this;
    }

    public boolean hasAttachedDocument() { 
      if (this.attachedDocument == null)
        return false;
      for (Reference item : this.attachedDocument)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAttachedDocument() { //3
      Reference t = new Reference();
      if (this.attachedDocument == null)
        this.attachedDocument = new ArrayList<Reference>();
      this.attachedDocument.add(t);
      return t;
    }

    public MedicinalProductDefinition addAttachedDocument(Reference t) { //3
      if (t == null)
        return this;
      if (this.attachedDocument == null)
        this.attachedDocument = new ArrayList<Reference>();
      this.attachedDocument.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #attachedDocument}, creating it if it does not already exist {3}
     */
    public Reference getAttachedDocumentFirstRep() { 
      if (getAttachedDocument().isEmpty()) {
        addAttachedDocument();
      }
      return getAttachedDocument().get(0);
    }

    /**
     * @return {@link #masterFile} (A master file for to the medicinal product (e.g. Pharmacovigilance System Master File).)
     */
    public List<Reference> getMasterFile() { 
      if (this.masterFile == null)
        this.masterFile = new ArrayList<Reference>();
      return this.masterFile;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setMasterFile(List<Reference> theMasterFile) { 
      this.masterFile = theMasterFile;
      return this;
    }

    public boolean hasMasterFile() { 
      if (this.masterFile == null)
        return false;
      for (Reference item : this.masterFile)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addMasterFile() { //3
      Reference t = new Reference();
      if (this.masterFile == null)
        this.masterFile = new ArrayList<Reference>();
      this.masterFile.add(t);
      return t;
    }

    public MedicinalProductDefinition addMasterFile(Reference t) { //3
      if (t == null)
        return this;
      if (this.masterFile == null)
        this.masterFile = new ArrayList<Reference>();
      this.masterFile.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #masterFile}, creating it if it does not already exist {3}
     */
    public Reference getMasterFileFirstRep() { 
      if (getMasterFile().isEmpty()) {
        addMasterFile();
      }
      return getMasterFile().get(0);
    }

    /**
     * @return {@link #contact} (A product specific contact, person (in a role), or an organization.)
     */
    public List<MedicinalProductDefinitionContactComponent> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<MedicinalProductDefinitionContactComponent>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setContact(List<MedicinalProductDefinitionContactComponent> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (MedicinalProductDefinitionContactComponent item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionContactComponent addContact() { //3
      MedicinalProductDefinitionContactComponent t = new MedicinalProductDefinitionContactComponent();
      if (this.contact == null)
        this.contact = new ArrayList<MedicinalProductDefinitionContactComponent>();
      this.contact.add(t);
      return t;
    }

    public MedicinalProductDefinition addContact(MedicinalProductDefinitionContactComponent t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<MedicinalProductDefinitionContactComponent>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionContactComponent getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #clinicalTrial} (Clinical trials or studies that this product is involved in.)
     */
    public List<Reference> getClinicalTrial() { 
      if (this.clinicalTrial == null)
        this.clinicalTrial = new ArrayList<Reference>();
      return this.clinicalTrial;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setClinicalTrial(List<Reference> theClinicalTrial) { 
      this.clinicalTrial = theClinicalTrial;
      return this;
    }

    public boolean hasClinicalTrial() { 
      if (this.clinicalTrial == null)
        return false;
      for (Reference item : this.clinicalTrial)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addClinicalTrial() { //3
      Reference t = new Reference();
      if (this.clinicalTrial == null)
        this.clinicalTrial = new ArrayList<Reference>();
      this.clinicalTrial.add(t);
      return t;
    }

    public MedicinalProductDefinition addClinicalTrial(Reference t) { //3
      if (t == null)
        return this;
      if (this.clinicalTrial == null)
        this.clinicalTrial = new ArrayList<Reference>();
      this.clinicalTrial.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #clinicalTrial}, creating it if it does not already exist {3}
     */
    public Reference getClinicalTrialFirstRep() { 
      if (getClinicalTrial().isEmpty()) {
        addClinicalTrial();
      }
      return getClinicalTrial().get(0);
    }

    /**
     * @return {@link #name} (The product's name, including full name and possibly coded parts.)
     */
    public List<MedicinalProductDefinitionNameComponent> getName() { 
      if (this.name == null)
        this.name = new ArrayList<MedicinalProductDefinitionNameComponent>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setName(List<MedicinalProductDefinitionNameComponent> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (MedicinalProductDefinitionNameComponent item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionNameComponent addName() { //3
      MedicinalProductDefinitionNameComponent t = new MedicinalProductDefinitionNameComponent();
      if (this.name == null)
        this.name = new ArrayList<MedicinalProductDefinitionNameComponent>();
      this.name.add(t);
      return t;
    }

    public MedicinalProductDefinition addName(MedicinalProductDefinitionNameComponent t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<MedicinalProductDefinitionNameComponent>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionNameComponent getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #crossReference} (Reference to another product, e.g. for linking authorised to investigational product.)
     */
    public List<MedicinalProductDefinitionCrossReferenceComponent> getCrossReference() { 
      if (this.crossReference == null)
        this.crossReference = new ArrayList<MedicinalProductDefinitionCrossReferenceComponent>();
      return this.crossReference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setCrossReference(List<MedicinalProductDefinitionCrossReferenceComponent> theCrossReference) { 
      this.crossReference = theCrossReference;
      return this;
    }

    public boolean hasCrossReference() { 
      if (this.crossReference == null)
        return false;
      for (MedicinalProductDefinitionCrossReferenceComponent item : this.crossReference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionCrossReferenceComponent addCrossReference() { //3
      MedicinalProductDefinitionCrossReferenceComponent t = new MedicinalProductDefinitionCrossReferenceComponent();
      if (this.crossReference == null)
        this.crossReference = new ArrayList<MedicinalProductDefinitionCrossReferenceComponent>();
      this.crossReference.add(t);
      return t;
    }

    public MedicinalProductDefinition addCrossReference(MedicinalProductDefinitionCrossReferenceComponent t) { //3
      if (t == null)
        return this;
      if (this.crossReference == null)
        this.crossReference = new ArrayList<MedicinalProductDefinitionCrossReferenceComponent>();
      this.crossReference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #crossReference}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionCrossReferenceComponent getCrossReferenceFirstRep() { 
      if (getCrossReference().isEmpty()) {
        addCrossReference();
      }
      return getCrossReference().get(0);
    }

    /**
     * @return {@link #manufacturingBusinessOperation} (An operation applied to the product, for manufacturing or adminsitrative purpose.)
     */
    public List<MedicinalProductDefinitionManufacturingBusinessOperationComponent> getManufacturingBusinessOperation() { 
      if (this.manufacturingBusinessOperation == null)
        this.manufacturingBusinessOperation = new ArrayList<MedicinalProductDefinitionManufacturingBusinessOperationComponent>();
      return this.manufacturingBusinessOperation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setManufacturingBusinessOperation(List<MedicinalProductDefinitionManufacturingBusinessOperationComponent> theManufacturingBusinessOperation) { 
      this.manufacturingBusinessOperation = theManufacturingBusinessOperation;
      return this;
    }

    public boolean hasManufacturingBusinessOperation() { 
      if (this.manufacturingBusinessOperation == null)
        return false;
      for (MedicinalProductDefinitionManufacturingBusinessOperationComponent item : this.manufacturingBusinessOperation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionManufacturingBusinessOperationComponent addManufacturingBusinessOperation() { //3
      MedicinalProductDefinitionManufacturingBusinessOperationComponent t = new MedicinalProductDefinitionManufacturingBusinessOperationComponent();
      if (this.manufacturingBusinessOperation == null)
        this.manufacturingBusinessOperation = new ArrayList<MedicinalProductDefinitionManufacturingBusinessOperationComponent>();
      this.manufacturingBusinessOperation.add(t);
      return t;
    }

    public MedicinalProductDefinition addManufacturingBusinessOperation(MedicinalProductDefinitionManufacturingBusinessOperationComponent t) { //3
      if (t == null)
        return this;
      if (this.manufacturingBusinessOperation == null)
        this.manufacturingBusinessOperation = new ArrayList<MedicinalProductDefinitionManufacturingBusinessOperationComponent>();
      this.manufacturingBusinessOperation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #manufacturingBusinessOperation}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionManufacturingBusinessOperationComponent getManufacturingBusinessOperationFirstRep() { 
      if (getManufacturingBusinessOperation().isEmpty()) {
        addManufacturingBusinessOperation();
      }
      return getManufacturingBusinessOperation().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this product. Could be an MPID.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "CodeableConcept", "Regulatory type, e.g. Investigational or Authorized.", 0, 1, type));
        children.add(new Property("domain", "CodeableConcept", "If this medicine applies to human or veterinary uses.", 0, 1, domain));
        children.add(new Property("version", "string", "A business level identifier of the product.", 0, 1, version));
        children.add(new Property("status", "CodeableConcept", "The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status.", 0, 1, status));
        children.add(new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate));
        children.add(new Property("description", "markdown", "General description of this product.", 0, 1, description));
        children.add(new Property("combinedPharmaceuticalDoseForm", "CodeableConcept", "The dose form for a single part product, or combined form of a multiple part product.", 0, 1, combinedPharmaceuticalDoseForm));
        children.add(new Property("indication", "markdown", "General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.", 0, 1, indication));
        children.add(new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply));
        children.add(new Property("additionalMonitoringIndicator", "CodeableConcept", "Whether the Medicinal Product is subject to additional monitoring for regulatory reasons.", 0, 1, additionalMonitoringIndicator));
        children.add(new Property("specialMeasures", "CodeableConcept", "Whether the Medicinal Product is subject to special measures for regulatory reasons.", 0, java.lang.Integer.MAX_VALUE, specialMeasures));
        children.add(new Property("paediatricUseIndicator", "CodeableConcept", "If authorised for use in children.", 0, 1, paediatricUseIndicator));
        children.add(new Property("productClassification", "CodeableConcept", "Allows the product to be classified by various systems.", 0, java.lang.Integer.MAX_VALUE, productClassification));
        children.add(new Property("characteristic", "CodeableConcept", "Allows the key product features to be recorded, such as \"suger free\", \"modified release\", \"parallel import\".", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("marketingStatus", "MarketingStatus", "Marketing status of the medicinal product, in contrast to marketing authorizaton.", 0, java.lang.Integer.MAX_VALUE, marketingStatus));
        children.add(new Property("pharmaceuticalProduct", "Reference(AdministrableProductDefinition)", "Pharmaceutical aspects of product.", 0, java.lang.Integer.MAX_VALUE, pharmaceuticalProduct));
        children.add(new Property("packagedMedicinalProduct", "Reference(PackagedProductDefinition)", "Package representation for the product.", 0, java.lang.Integer.MAX_VALUE, packagedMedicinalProduct));
        children.add(new Property("ingredient", "Reference(Ingredient)", "The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("attachedDocument", "Reference(DocumentReference)", "Supporting documentation, typically for regulatory submission.", 0, java.lang.Integer.MAX_VALUE, attachedDocument));
        children.add(new Property("masterFile", "Reference(DocumentReference)", "A master file for to the medicinal product (e.g. Pharmacovigilance System Master File).", 0, java.lang.Integer.MAX_VALUE, masterFile));
        children.add(new Property("contact", "", "A product specific contact, person (in a role), or an organization.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("clinicalTrial", "Reference(ResearchStudy)", "Clinical trials or studies that this product is involved in.", 0, java.lang.Integer.MAX_VALUE, clinicalTrial));
        children.add(new Property("name", "", "The product's name, including full name and possibly coded parts.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("crossReference", "", "Reference to another product, e.g. for linking authorised to investigational product.", 0, java.lang.Integer.MAX_VALUE, crossReference));
        children.add(new Property("manufacturingBusinessOperation", "", "An operation applied to the product, for manufacturing or adminsitrative purpose.", 0, java.lang.Integer.MAX_VALUE, manufacturingBusinessOperation));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this product. Could be an MPID.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Regulatory type, e.g. Investigational or Authorized.", 0, 1, type);
        case -1326197564: /*domain*/  return new Property("domain", "CodeableConcept", "If this medicine applies to human or veterinary uses.", 0, 1, domain);
        case 351608024: /*version*/  return new Property("version", "string", "A business level identifier of the product.", 0, 1, version);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status.", 0, 1, status);
        case 247524032: /*statusDate*/  return new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate);
        case -1724546052: /*description*/  return new Property("description", "markdown", "General description of this product.", 0, 1, description);
        case -1992898487: /*combinedPharmaceuticalDoseForm*/  return new Property("combinedPharmaceuticalDoseForm", "CodeableConcept", "The dose form for a single part product, or combined form of a multiple part product.", 0, 1, combinedPharmaceuticalDoseForm);
        case -597168804: /*indication*/  return new Property("indication", "markdown", "General combined description of indication(s) for this product. See also MedicinalProductDefinitionIndication.", 0, 1, indication);
        case -844874031: /*legalStatusOfSupply*/  return new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply);
        case 1935999744: /*additionalMonitoringIndicator*/  return new Property("additionalMonitoringIndicator", "CodeableConcept", "Whether the Medicinal Product is subject to additional monitoring for regulatory reasons.", 0, 1, additionalMonitoringIndicator);
        case 975102638: /*specialMeasures*/  return new Property("specialMeasures", "CodeableConcept", "Whether the Medicinal Product is subject to special measures for regulatory reasons.", 0, java.lang.Integer.MAX_VALUE, specialMeasures);
        case -1019867160: /*paediatricUseIndicator*/  return new Property("paediatricUseIndicator", "CodeableConcept", "If authorised for use in children.", 0, 1, paediatricUseIndicator);
        case 1247936181: /*productClassification*/  return new Property("productClassification", "CodeableConcept", "Allows the product to be classified by various systems.", 0, java.lang.Integer.MAX_VALUE, productClassification);
        case 366313883: /*characteristic*/  return new Property("characteristic", "CodeableConcept", "Allows the key product features to be recorded, such as \"suger free\", \"modified release\", \"parallel import\".", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case 70767032: /*marketingStatus*/  return new Property("marketingStatus", "MarketingStatus", "Marketing status of the medicinal product, in contrast to marketing authorizaton.", 0, java.lang.Integer.MAX_VALUE, marketingStatus);
        case 443273260: /*pharmaceuticalProduct*/  return new Property("pharmaceuticalProduct", "Reference(AdministrableProductDefinition)", "Pharmaceutical aspects of product.", 0, java.lang.Integer.MAX_VALUE, pharmaceuticalProduct);
        case -361025513: /*packagedMedicinalProduct*/  return new Property("packagedMedicinalProduct", "Reference(PackagedProductDefinition)", "Package representation for the product.", 0, java.lang.Integer.MAX_VALUE, packagedMedicinalProduct);
        case -206409263: /*ingredient*/  return new Property("ingredient", "Reference(Ingredient)", "The ingredients of this medicinal product - when not specified elsewhere. This is only needed if the ingredients are not specified by the pharmaceuticalProduct or packagedMedicinalProduct references above. In cases where those levels of detail are not used, the ingredients may be specified directly here.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case -513945889: /*attachedDocument*/  return new Property("attachedDocument", "Reference(DocumentReference)", "Supporting documentation, typically for regulatory submission.", 0, java.lang.Integer.MAX_VALUE, attachedDocument);
        case -2039573762: /*masterFile*/  return new Property("masterFile", "Reference(DocumentReference)", "A master file for to the medicinal product (e.g. Pharmacovigilance System Master File).", 0, java.lang.Integer.MAX_VALUE, masterFile);
        case 951526432: /*contact*/  return new Property("contact", "", "A product specific contact, person (in a role), or an organization.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 1232866243: /*clinicalTrial*/  return new Property("clinicalTrial", "Reference(ResearchStudy)", "Clinical trials or studies that this product is involved in.", 0, java.lang.Integer.MAX_VALUE, clinicalTrial);
        case 3373707: /*name*/  return new Property("name", "", "The product's name, including full name and possibly coded parts.", 0, java.lang.Integer.MAX_VALUE, name);
        case -986968341: /*crossReference*/  return new Property("crossReference", "", "Reference to another product, e.g. for linking authorised to investigational product.", 0, java.lang.Integer.MAX_VALUE, crossReference);
        case -171103255: /*manufacturingBusinessOperation*/  return new Property("manufacturingBusinessOperation", "", "An operation applied to the product, for manufacturing or adminsitrative purpose.", 0, java.lang.Integer.MAX_VALUE, manufacturingBusinessOperation);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1326197564: /*domain*/ return this.domain == null ? new Base[0] : new Base[] {this.domain}; // CodeableConcept
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : new Base[] {this.statusDate}; // DateTimeType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1992898487: /*combinedPharmaceuticalDoseForm*/ return this.combinedPharmaceuticalDoseForm == null ? new Base[0] : new Base[] {this.combinedPharmaceuticalDoseForm}; // CodeableConcept
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // MarkdownType
        case -844874031: /*legalStatusOfSupply*/ return this.legalStatusOfSupply == null ? new Base[0] : new Base[] {this.legalStatusOfSupply}; // CodeableConcept
        case 1935999744: /*additionalMonitoringIndicator*/ return this.additionalMonitoringIndicator == null ? new Base[0] : new Base[] {this.additionalMonitoringIndicator}; // CodeableConcept
        case 975102638: /*specialMeasures*/ return this.specialMeasures == null ? new Base[0] : this.specialMeasures.toArray(new Base[this.specialMeasures.size()]); // CodeableConcept
        case -1019867160: /*paediatricUseIndicator*/ return this.paediatricUseIndicator == null ? new Base[0] : new Base[] {this.paediatricUseIndicator}; // CodeableConcept
        case 1247936181: /*productClassification*/ return this.productClassification == null ? new Base[0] : this.productClassification.toArray(new Base[this.productClassification.size()]); // CodeableConcept
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // CodeableConcept
        case 70767032: /*marketingStatus*/ return this.marketingStatus == null ? new Base[0] : this.marketingStatus.toArray(new Base[this.marketingStatus.size()]); // MarketingStatus
        case 443273260: /*pharmaceuticalProduct*/ return this.pharmaceuticalProduct == null ? new Base[0] : this.pharmaceuticalProduct.toArray(new Base[this.pharmaceuticalProduct.size()]); // Reference
        case -361025513: /*packagedMedicinalProduct*/ return this.packagedMedicinalProduct == null ? new Base[0] : this.packagedMedicinalProduct.toArray(new Base[this.packagedMedicinalProduct.size()]); // Reference
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // Reference
        case -513945889: /*attachedDocument*/ return this.attachedDocument == null ? new Base[0] : this.attachedDocument.toArray(new Base[this.attachedDocument.size()]); // Reference
        case -2039573762: /*masterFile*/ return this.masterFile == null ? new Base[0] : this.masterFile.toArray(new Base[this.masterFile.size()]); // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // MedicinalProductDefinitionContactComponent
        case 1232866243: /*clinicalTrial*/ return this.clinicalTrial == null ? new Base[0] : this.clinicalTrial.toArray(new Base[this.clinicalTrial.size()]); // Reference
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // MedicinalProductDefinitionNameComponent
        case -986968341: /*crossReference*/ return this.crossReference == null ? new Base[0] : this.crossReference.toArray(new Base[this.crossReference.size()]); // MedicinalProductDefinitionCrossReferenceComponent
        case -171103255: /*manufacturingBusinessOperation*/ return this.manufacturingBusinessOperation == null ? new Base[0] : this.manufacturingBusinessOperation.toArray(new Base[this.manufacturingBusinessOperation.size()]); // MedicinalProductDefinitionManufacturingBusinessOperationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1326197564: // domain
          this.domain = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1992898487: // combinedPharmaceuticalDoseForm
          this.combinedPharmaceuticalDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -597168804: // indication
          this.indication = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -844874031: // legalStatusOfSupply
          this.legalStatusOfSupply = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1935999744: // additionalMonitoringIndicator
          this.additionalMonitoringIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 975102638: // specialMeasures
          this.getSpecialMeasures().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1019867160: // paediatricUseIndicator
          this.paediatricUseIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1247936181: // productClassification
          this.getProductClassification().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 70767032: // marketingStatus
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value)); // MarketingStatus
          return value;
        case 443273260: // pharmaceuticalProduct
          this.getPharmaceuticalProduct().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -361025513: // packagedMedicinalProduct
          this.getPackagedMedicinalProduct().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -206409263: // ingredient
          this.getIngredient().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -513945889: // attachedDocument
          this.getAttachedDocument().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2039573762: // masterFile
          this.getMasterFile().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add((MedicinalProductDefinitionContactComponent) value); // MedicinalProductDefinitionContactComponent
          return value;
        case 1232866243: // clinicalTrial
          this.getClinicalTrial().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3373707: // name
          this.getName().add((MedicinalProductDefinitionNameComponent) value); // MedicinalProductDefinitionNameComponent
          return value;
        case -986968341: // crossReference
          this.getCrossReference().add((MedicinalProductDefinitionCrossReferenceComponent) value); // MedicinalProductDefinitionCrossReferenceComponent
          return value;
        case -171103255: // manufacturingBusinessOperation
          this.getManufacturingBusinessOperation().add((MedicinalProductDefinitionManufacturingBusinessOperationComponent) value); // MedicinalProductDefinitionManufacturingBusinessOperationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("domain")) {
          this.domain = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statusDate")) {
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("combinedPharmaceuticalDoseForm")) {
          this.combinedPharmaceuticalDoseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("indication")) {
          this.indication = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("legalStatusOfSupply")) {
          this.legalStatusOfSupply = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("additionalMonitoringIndicator")) {
          this.additionalMonitoringIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specialMeasures")) {
          this.getSpecialMeasures().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("paediatricUseIndicator")) {
          this.paediatricUseIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("productClassification")) {
          this.getProductClassification().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value));
        } else if (name.equals("pharmaceuticalProduct")) {
          this.getPharmaceuticalProduct().add(TypeConvertor.castToReference(value));
        } else if (name.equals("packagedMedicinalProduct")) {
          this.getPackagedMedicinalProduct().add(TypeConvertor.castToReference(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add(TypeConvertor.castToReference(value));
        } else if (name.equals("attachedDocument")) {
          this.getAttachedDocument().add(TypeConvertor.castToReference(value));
        } else if (name.equals("masterFile")) {
          this.getMasterFile().add(TypeConvertor.castToReference(value));
        } else if (name.equals("contact")) {
          this.getContact().add((MedicinalProductDefinitionContactComponent) value);
        } else if (name.equals("clinicalTrial")) {
          this.getClinicalTrial().add(TypeConvertor.castToReference(value));
        } else if (name.equals("name")) {
          this.getName().add((MedicinalProductDefinitionNameComponent) value);
        } else if (name.equals("crossReference")) {
          this.getCrossReference().add((MedicinalProductDefinitionCrossReferenceComponent) value);
        } else if (name.equals("manufacturingBusinessOperation")) {
          this.getManufacturingBusinessOperation().add((MedicinalProductDefinitionManufacturingBusinessOperationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getType();
        case -1326197564:  return getDomain();
        case 351608024:  return getVersionElement();
        case -892481550:  return getStatus();
        case 247524032:  return getStatusDateElement();
        case -1724546052:  return getDescriptionElement();
        case -1992898487:  return getCombinedPharmaceuticalDoseForm();
        case -597168804:  return getIndicationElement();
        case -844874031:  return getLegalStatusOfSupply();
        case 1935999744:  return getAdditionalMonitoringIndicator();
        case 975102638:  return addSpecialMeasures(); 
        case -1019867160:  return getPaediatricUseIndicator();
        case 1247936181:  return addProductClassification(); 
        case 366313883:  return addCharacteristic(); 
        case 70767032:  return addMarketingStatus(); 
        case 443273260:  return addPharmaceuticalProduct(); 
        case -361025513:  return addPackagedMedicinalProduct(); 
        case -206409263:  return addIngredient(); 
        case -513945889:  return addAttachedDocument(); 
        case -2039573762:  return addMasterFile(); 
        case 951526432:  return addContact(); 
        case 1232866243:  return addClinicalTrial(); 
        case 3373707:  return addName(); 
        case -986968341:  return addCrossReference(); 
        case -171103255:  return addManufacturingBusinessOperation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1326197564: /*domain*/ return new String[] {"CodeableConcept"};
        case 351608024: /*version*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {"dateTime"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1992898487: /*combinedPharmaceuticalDoseForm*/ return new String[] {"CodeableConcept"};
        case -597168804: /*indication*/ return new String[] {"markdown"};
        case -844874031: /*legalStatusOfSupply*/ return new String[] {"CodeableConcept"};
        case 1935999744: /*additionalMonitoringIndicator*/ return new String[] {"CodeableConcept"};
        case 975102638: /*specialMeasures*/ return new String[] {"CodeableConcept"};
        case -1019867160: /*paediatricUseIndicator*/ return new String[] {"CodeableConcept"};
        case 1247936181: /*productClassification*/ return new String[] {"CodeableConcept"};
        case 366313883: /*characteristic*/ return new String[] {"CodeableConcept"};
        case 70767032: /*marketingStatus*/ return new String[] {"MarketingStatus"};
        case 443273260: /*pharmaceuticalProduct*/ return new String[] {"Reference"};
        case -361025513: /*packagedMedicinalProduct*/ return new String[] {"Reference"};
        case -206409263: /*ingredient*/ return new String[] {"Reference"};
        case -513945889: /*attachedDocument*/ return new String[] {"Reference"};
        case -2039573762: /*masterFile*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {};
        case 1232866243: /*clinicalTrial*/ return new String[] {"Reference"};
        case 3373707: /*name*/ return new String[] {};
        case -986968341: /*crossReference*/ return new String[] {};
        case -171103255: /*manufacturingBusinessOperation*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("domain")) {
          this.domain = new CodeableConcept();
          return this.domain;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.version");
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.statusDate");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.description");
        }
        else if (name.equals("combinedPharmaceuticalDoseForm")) {
          this.combinedPharmaceuticalDoseForm = new CodeableConcept();
          return this.combinedPharmaceuticalDoseForm;
        }
        else if (name.equals("indication")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicinalProductDefinition.indication");
        }
        else if (name.equals("legalStatusOfSupply")) {
          this.legalStatusOfSupply = new CodeableConcept();
          return this.legalStatusOfSupply;
        }
        else if (name.equals("additionalMonitoringIndicator")) {
          this.additionalMonitoringIndicator = new CodeableConcept();
          return this.additionalMonitoringIndicator;
        }
        else if (name.equals("specialMeasures")) {
          return addSpecialMeasures();
        }
        else if (name.equals("paediatricUseIndicator")) {
          this.paediatricUseIndicator = new CodeableConcept();
          return this.paediatricUseIndicator;
        }
        else if (name.equals("productClassification")) {
          return addProductClassification();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("marketingStatus")) {
          return addMarketingStatus();
        }
        else if (name.equals("pharmaceuticalProduct")) {
          return addPharmaceuticalProduct();
        }
        else if (name.equals("packagedMedicinalProduct")) {
          return addPackagedMedicinalProduct();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("attachedDocument")) {
          return addAttachedDocument();
        }
        else if (name.equals("masterFile")) {
          return addMasterFile();
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("clinicalTrial")) {
          return addClinicalTrial();
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("crossReference")) {
          return addCrossReference();
        }
        else if (name.equals("manufacturingBusinessOperation")) {
          return addManufacturingBusinessOperation();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MedicinalProductDefinition";

  }

      public MedicinalProductDefinition copy() {
        MedicinalProductDefinition dst = new MedicinalProductDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.domain = domain == null ? null : domain.copy();
        dst.version = version == null ? null : version.copy();
        dst.status = status == null ? null : status.copy();
        dst.statusDate = statusDate == null ? null : statusDate.copy();
        dst.description = description == null ? null : description.copy();
        dst.combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm == null ? null : combinedPharmaceuticalDoseForm.copy();
        dst.indication = indication == null ? null : indication.copy();
        dst.legalStatusOfSupply = legalStatusOfSupply == null ? null : legalStatusOfSupply.copy();
        dst.additionalMonitoringIndicator = additionalMonitoringIndicator == null ? null : additionalMonitoringIndicator.copy();
        if (specialMeasures != null) {
          dst.specialMeasures = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialMeasures)
            dst.specialMeasures.add(i.copy());
        };
        dst.paediatricUseIndicator = paediatricUseIndicator == null ? null : paediatricUseIndicator.copy();
        if (productClassification != null) {
          dst.productClassification = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : productClassification)
            dst.productClassification.add(i.copy());
        };
        if (characteristic != null) {
          dst.characteristic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (marketingStatus != null) {
          dst.marketingStatus = new ArrayList<MarketingStatus>();
          for (MarketingStatus i : marketingStatus)
            dst.marketingStatus.add(i.copy());
        };
        if (pharmaceuticalProduct != null) {
          dst.pharmaceuticalProduct = new ArrayList<Reference>();
          for (Reference i : pharmaceuticalProduct)
            dst.pharmaceuticalProduct.add(i.copy());
        };
        if (packagedMedicinalProduct != null) {
          dst.packagedMedicinalProduct = new ArrayList<Reference>();
          for (Reference i : packagedMedicinalProduct)
            dst.packagedMedicinalProduct.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<Reference>();
          for (Reference i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (attachedDocument != null) {
          dst.attachedDocument = new ArrayList<Reference>();
          for (Reference i : attachedDocument)
            dst.attachedDocument.add(i.copy());
        };
        if (masterFile != null) {
          dst.masterFile = new ArrayList<Reference>();
          for (Reference i : masterFile)
            dst.masterFile.add(i.copy());
        };
        if (contact != null) {
          dst.contact = new ArrayList<MedicinalProductDefinitionContactComponent>();
          for (MedicinalProductDefinitionContactComponent i : contact)
            dst.contact.add(i.copy());
        };
        if (clinicalTrial != null) {
          dst.clinicalTrial = new ArrayList<Reference>();
          for (Reference i : clinicalTrial)
            dst.clinicalTrial.add(i.copy());
        };
        if (name != null) {
          dst.name = new ArrayList<MedicinalProductDefinitionNameComponent>();
          for (MedicinalProductDefinitionNameComponent i : name)
            dst.name.add(i.copy());
        };
        if (crossReference != null) {
          dst.crossReference = new ArrayList<MedicinalProductDefinitionCrossReferenceComponent>();
          for (MedicinalProductDefinitionCrossReferenceComponent i : crossReference)
            dst.crossReference.add(i.copy());
        };
        if (manufacturingBusinessOperation != null) {
          dst.manufacturingBusinessOperation = new ArrayList<MedicinalProductDefinitionManufacturingBusinessOperationComponent>();
          for (MedicinalProductDefinitionManufacturingBusinessOperationComponent i : manufacturingBusinessOperation)
            dst.manufacturingBusinessOperation.add(i.copy());
        };
      }

      protected MedicinalProductDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinition))
          return false;
        MedicinalProductDefinition o = (MedicinalProductDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(domain, o.domain, true)
           && compareDeep(version, o.version, true) && compareDeep(status, o.status, true) && compareDeep(statusDate, o.statusDate, true)
           && compareDeep(description, o.description, true) && compareDeep(combinedPharmaceuticalDoseForm, o.combinedPharmaceuticalDoseForm, true)
           && compareDeep(indication, o.indication, true) && compareDeep(legalStatusOfSupply, o.legalStatusOfSupply, true)
           && compareDeep(additionalMonitoringIndicator, o.additionalMonitoringIndicator, true) && compareDeep(specialMeasures, o.specialMeasures, true)
           && compareDeep(paediatricUseIndicator, o.paediatricUseIndicator, true) && compareDeep(productClassification, o.productClassification, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(marketingStatus, o.marketingStatus, true)
           && compareDeep(pharmaceuticalProduct, o.pharmaceuticalProduct, true) && compareDeep(packagedMedicinalProduct, o.packagedMedicinalProduct, true)
           && compareDeep(ingredient, o.ingredient, true) && compareDeep(attachedDocument, o.attachedDocument, true)
           && compareDeep(masterFile, o.masterFile, true) && compareDeep(contact, o.contact, true) && compareDeep(clinicalTrial, o.clinicalTrial, true)
           && compareDeep(name, o.name, true) && compareDeep(crossReference, o.crossReference, true) && compareDeep(manufacturingBusinessOperation, o.manufacturingBusinessOperation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinition))
          return false;
        MedicinalProductDefinition o = (MedicinalProductDefinition) other_;
        return compareValues(version, o.version, true) && compareValues(statusDate, o.statusDate, true) && compareValues(description, o.description, true)
           && compareValues(indication, o.indication, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, domain
          , version, status, statusDate, description, combinedPharmaceuticalDoseForm, indication
          , legalStatusOfSupply, additionalMonitoringIndicator, specialMeasures, paediatricUseIndicator
          , productClassification, characteristic, marketingStatus, pharmaceuticalProduct, packagedMedicinalProduct
          , ingredient, attachedDocument, masterFile, contact, clinicalTrial, name, crossReference
          , manufacturingBusinessOperation);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicinalProductDefinition;
   }

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>Allows the key product features to be recorded, such as "suger free", "modified release", "parallel import"</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="MedicinalProductDefinition.characteristic", description="Allows the key product features to be recorded, such as \"suger free\", \"modified release\", \"parallel import\"", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>Allows the key product features to be recorded, such as "suger free", "modified release", "parallel import"</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC);

 /**
   * Search parameter: <b>contact</b>
   * <p>
   * Description: <b>A product specific contact, person (in a role), or an organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicinalProductDefinition.contact.contact</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contact", path="MedicinalProductDefinition.contact.contact", description="A product specific contact, person (in a role), or an organization", type="reference", target={Organization.class, PractitionerRole.class } )
  public static final String SP_CONTACT = "contact";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contact</b>
   * <p>
   * Description: <b>A product specific contact, person (in a role), or an organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicinalProductDefinition.contact.contact</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTACT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTACT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicinalProductDefinition:contact</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTACT = new ca.uhn.fhir.model.api.Include("MedicinalProductDefinition:contact").toLocked();

 /**
   * Search parameter: <b>domain</b>
   * <p>
   * Description: <b>If this medicine applies to human or veterinary uses</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.domain</b><br>
   * </p>
   */
  @SearchParamDefinition(name="domain", path="MedicinalProductDefinition.domain", description="If this medicine applies to human or veterinary uses", type="token" )
  public static final String SP_DOMAIN = "domain";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>domain</b>
   * <p>
   * Description: <b>If this medicine applies to human or veterinary uses</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.domain</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOMAIN = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOMAIN);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this product. Could be an MPID</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="MedicinalProductDefinition.identifier", description="Business identifier for this product. Could be an MPID", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this product. Could be an MPID</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>master-file</b>
   * <p>
   * Description: <b>A master file for to the medicinal product (e.g. Pharmacovigilance System Master File)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicinalProductDefinition.masterFile</b><br>
   * </p>
   */
  @SearchParamDefinition(name="master-file", path="MedicinalProductDefinition.masterFile", description="A master file for to the medicinal product (e.g. Pharmacovigilance System Master File)", type="reference", target={DocumentReference.class } )
  public static final String SP_MASTER_FILE = "master-file";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>master-file</b>
   * <p>
   * Description: <b>A master file for to the medicinal product (e.g. Pharmacovigilance System Master File)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicinalProductDefinition.masterFile</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MASTER_FILE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MASTER_FILE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicinalProductDefinition:master-file</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MASTER_FILE = new ca.uhn.fhir.model.api.Include("MedicinalProductDefinition:master-file").toLocked();

 /**
   * Search parameter: <b>name-language</b>
   * <p>
   * Description: <b>Language code for this name</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.name.countryLanguage.language</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name-language", path="MedicinalProductDefinition.name.countryLanguage.language", description="Language code for this name", type="token" )
  public static final String SP_NAME_LANGUAGE = "name-language";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name-language</b>
   * <p>
   * Description: <b>Language code for this name</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.name.countryLanguage.language</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam NAME_LANGUAGE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_NAME_LANGUAGE);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>The full product name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>MedicinalProductDefinition.name.productName</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="MedicinalProductDefinition.name.productName", description="The full product name", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>The full product name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>MedicinalProductDefinition.name.productName</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>product-classification</b>
   * <p>
   * Description: <b>Allows the product to be classified by various systems</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.productClassification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product-classification", path="MedicinalProductDefinition.productClassification", description="Allows the product to be classified by various systems", type="token" )
  public static final String SP_PRODUCT_CLASSIFICATION = "product-classification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product-classification</b>
   * <p>
   * Description: <b>Allows the product to be classified by various systems</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.productClassification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRODUCT_CLASSIFICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRODUCT_CLASSIFICATION);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MedicinalProductDefinition.status", description="The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this product. A high level status, this is not intended to duplicate details carried elswhere such as legal status, or authorization status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Regulatory type, e.g. Investigational or Authorized</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="MedicinalProductDefinition.type", description="Regulatory type, e.g. Investigational or Authorized", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Regulatory type, e.g. Investigational or Authorized</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}