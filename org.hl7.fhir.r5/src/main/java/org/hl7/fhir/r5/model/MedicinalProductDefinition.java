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
 * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).
 */
@ResourceDef(name="MedicinalProductDefinition", profile="http://hl7.org/fhir/StructureDefinition/MedicinalProductDefinition")
public class MedicinalProductDefinition extends DomainResource {

    @Block()
    public static class MedicinalProductDefinitionContactComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information", formalDefinition="Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-contact-type")
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
         * @return {@link #type} (Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.)
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
         * @param value {@link #type} (Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.)
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
          children.add(new Property("type", "CodeableConcept", "Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.", 0, 1, type));
          children.add(new Property("contact", "Reference(Organization|PractitionerRole)", "A product specific contact, person (in a role), or an organization.", 0, 1, contact));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.", 0, 1, type);
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-name-type")
        protected CodeableConcept type;

        /**
         * Coding words or phrases of the name.
         */
        @Child(name = "part", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Coding words or phrases of the name", formalDefinition="Coding words or phrases of the name." )
        protected List<MedicinalProductDefinitionNamePartComponent> part;

        /**
         * Country and jurisdiction where the name applies, and associated language.
         */
        @Child(name = "usage", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Country and jurisdiction where the name applies", formalDefinition="Country and jurisdiction where the name applies, and associated language." )
        protected List<MedicinalProductDefinitionNameUsageComponent> usage;

        private static final long serialVersionUID = 890277480L;

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
         * @return {@link #part} (Coding words or phrases of the name.)
         */
        public List<MedicinalProductDefinitionNamePartComponent> getPart() { 
          if (this.part == null)
            this.part = new ArrayList<MedicinalProductDefinitionNamePartComponent>();
          return this.part;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionNameComponent setPart(List<MedicinalProductDefinitionNamePartComponent> thePart) { 
          this.part = thePart;
          return this;
        }

        public boolean hasPart() { 
          if (this.part == null)
            return false;
          for (MedicinalProductDefinitionNamePartComponent item : this.part)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicinalProductDefinitionNamePartComponent addPart() { //3
          MedicinalProductDefinitionNamePartComponent t = new MedicinalProductDefinitionNamePartComponent();
          if (this.part == null)
            this.part = new ArrayList<MedicinalProductDefinitionNamePartComponent>();
          this.part.add(t);
          return t;
        }

        public MedicinalProductDefinitionNameComponent addPart(MedicinalProductDefinitionNamePartComponent t) { //3
          if (t == null)
            return this;
          if (this.part == null)
            this.part = new ArrayList<MedicinalProductDefinitionNamePartComponent>();
          this.part.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #part}, creating it if it does not already exist {3}
         */
        public MedicinalProductDefinitionNamePartComponent getPartFirstRep() { 
          if (getPart().isEmpty()) {
            addPart();
          }
          return getPart().get(0);
        }

        /**
         * @return {@link #usage} (Country and jurisdiction where the name applies, and associated language.)
         */
        public List<MedicinalProductDefinitionNameUsageComponent> getUsage() { 
          if (this.usage == null)
            this.usage = new ArrayList<MedicinalProductDefinitionNameUsageComponent>();
          return this.usage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionNameComponent setUsage(List<MedicinalProductDefinitionNameUsageComponent> theUsage) { 
          this.usage = theUsage;
          return this;
        }

        public boolean hasUsage() { 
          if (this.usage == null)
            return false;
          for (MedicinalProductDefinitionNameUsageComponent item : this.usage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicinalProductDefinitionNameUsageComponent addUsage() { //3
          MedicinalProductDefinitionNameUsageComponent t = new MedicinalProductDefinitionNameUsageComponent();
          if (this.usage == null)
            this.usage = new ArrayList<MedicinalProductDefinitionNameUsageComponent>();
          this.usage.add(t);
          return t;
        }

        public MedicinalProductDefinitionNameComponent addUsage(MedicinalProductDefinitionNameUsageComponent t) { //3
          if (t == null)
            return this;
          if (this.usage == null)
            this.usage = new ArrayList<MedicinalProductDefinitionNameUsageComponent>();
          this.usage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #usage}, creating it if it does not already exist {3}
         */
        public MedicinalProductDefinitionNameUsageComponent getUsageFirstRep() { 
          if (getUsage().isEmpty()) {
            addUsage();
          }
          return getUsage().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("productName", "string", "The full product name.", 0, 1, productName));
          children.add(new Property("type", "CodeableConcept", "Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.", 0, 1, type));
          children.add(new Property("part", "", "Coding words or phrases of the name.", 0, java.lang.Integer.MAX_VALUE, part));
          children.add(new Property("usage", "", "Country and jurisdiction where the name applies, and associated language.", 0, java.lang.Integer.MAX_VALUE, usage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1491817446: /*productName*/  return new Property("productName", "string", "The full product name.", 0, 1, productName);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.", 0, 1, type);
          case 3433459: /*part*/  return new Property("part", "", "Coding words or phrases of the name.", 0, java.lang.Integer.MAX_VALUE, part);
          case 111574433: /*usage*/  return new Property("usage", "", "Country and jurisdiction where the name applies, and associated language.", 0, java.lang.Integer.MAX_VALUE, usage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1491817446: /*productName*/ return this.productName == null ? new Base[0] : new Base[] {this.productName}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3433459: /*part*/ return this.part == null ? new Base[0] : this.part.toArray(new Base[this.part.size()]); // MedicinalProductDefinitionNamePartComponent
        case 111574433: /*usage*/ return this.usage == null ? new Base[0] : this.usage.toArray(new Base[this.usage.size()]); // MedicinalProductDefinitionNameUsageComponent
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
        case 3433459: // part
          this.getPart().add((MedicinalProductDefinitionNamePartComponent) value); // MedicinalProductDefinitionNamePartComponent
          return value;
        case 111574433: // usage
          this.getUsage().add((MedicinalProductDefinitionNameUsageComponent) value); // MedicinalProductDefinitionNameUsageComponent
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
        } else if (name.equals("part")) {
          this.getPart().add((MedicinalProductDefinitionNamePartComponent) value);
        } else if (name.equals("usage")) {
          this.getUsage().add((MedicinalProductDefinitionNameUsageComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1491817446:  return getProductNameElement();
        case 3575610:  return getType();
        case 3433459:  return addPart(); 
        case 111574433:  return addUsage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1491817446: /*productName*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3433459: /*part*/ return new String[] {};
        case 111574433: /*usage*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("productName")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.name.productName");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("part")) {
          return addPart();
        }
        else if (name.equals("usage")) {
          return addUsage();
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
        if (part != null) {
          dst.part = new ArrayList<MedicinalProductDefinitionNamePartComponent>();
          for (MedicinalProductDefinitionNamePartComponent i : part)
            dst.part.add(i.copy());
        };
        if (usage != null) {
          dst.usage = new ArrayList<MedicinalProductDefinitionNameUsageComponent>();
          for (MedicinalProductDefinitionNameUsageComponent i : usage)
            dst.usage.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameComponent))
          return false;
        MedicinalProductDefinitionNameComponent o = (MedicinalProductDefinitionNameComponent) other_;
        return compareDeep(productName, o.productName, true) && compareDeep(type, o.type, true) && compareDeep(part, o.part, true)
           && compareDeep(usage, o.usage, true);
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(productName, type, part
          , usage);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionNamePartComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A fragment of a product name.
         */
        @Child(name = "part", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A fragment of a product name", formalDefinition="A fragment of a product name." )
        protected StringType part;

        /**
         * Identifying type for this part of the name (e.g. strength part).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifying type for this part of the name (e.g. strength part)", formalDefinition="Identifying type for this part of the name (e.g. strength part)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-name-part-type")
        protected CodeableConcept type;

        private static final long serialVersionUID = -1359126549L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNamePartComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNamePartComponent(String part, CodeableConcept type) {
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
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNamePartComponent.part");
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
        public MedicinalProductDefinitionNamePartComponent setPartElement(StringType value) { 
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
        public MedicinalProductDefinitionNamePartComponent setPart(String value) { 
            if (this.part == null)
              this.part = new StringType();
            this.part.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Identifying type for this part of the name (e.g. strength part).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNamePartComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Identifying type for this part of the name (e.g. strength part).)
         */
        public MedicinalProductDefinitionNamePartComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("part", "string", "A fragment of a product name.", 0, 1, part));
          children.add(new Property("type", "CodeableConcept", "Identifying type for this part of the name (e.g. strength part).", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433459: /*part*/  return new Property("part", "string", "A fragment of a product name.", 0, 1, part);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Identifying type for this part of the name (e.g. strength part).", 0, 1, type);
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
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.name.part.part");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionNamePartComponent copy() {
        MedicinalProductDefinitionNamePartComponent dst = new MedicinalProductDefinitionNamePartComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionNamePartComponent dst) {
        super.copyValues(dst);
        dst.part = part == null ? null : part.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNamePartComponent))
          return false;
        MedicinalProductDefinitionNamePartComponent o = (MedicinalProductDefinitionNamePartComponent) other_;
        return compareDeep(part, o.part, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNamePartComponent))
          return false;
        MedicinalProductDefinitionNamePartComponent o = (MedicinalProductDefinitionNamePartComponent) other_;
        return compareValues(part, o.part, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(part, type);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name.part";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionNameUsageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Country code for where this name applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Country code for where this name applies", formalDefinition="Country code for where this name applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/country")
        protected CodeableConcept country;

        /**
         * Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region).
         */
        @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Jurisdiction code for where this name applies", formalDefinition="Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
        protected CodeableConcept jurisdiction;

        /**
         * Language code for this name.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Language code for this name", formalDefinition="Language code for this name." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
        protected CodeableConcept language;

        private static final long serialVersionUID = 1627157564L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameUsageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionNameUsageComponent(CodeableConcept country, CodeableConcept language) {
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
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameUsageComponent.country");
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
        public MedicinalProductDefinitionNameUsageComponent setCountry(CodeableConcept value) { 
          this.country = value;
          return this;
        }

        /**
         * @return {@link #jurisdiction} (Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region).)
         */
        public CodeableConcept getJurisdiction() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameUsageComponent.jurisdiction");
            else if (Configuration.doAutoCreate())
              this.jurisdiction = new CodeableConcept(); // cc
          return this.jurisdiction;
        }

        public boolean hasJurisdiction() { 
          return this.jurisdiction != null && !this.jurisdiction.isEmpty();
        }

        /**
         * @param value {@link #jurisdiction} (Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region).)
         */
        public MedicinalProductDefinitionNameUsageComponent setJurisdiction(CodeableConcept value) { 
          this.jurisdiction = value;
          return this;
        }

        /**
         * @return {@link #language} (Language code for this name.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionNameUsageComponent.language");
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
        public MedicinalProductDefinitionNameUsageComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("country", "CodeableConcept", "Country code for where this name applies.", 0, 1, country));
          children.add(new Property("jurisdiction", "CodeableConcept", "Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region).", 0, 1, jurisdiction));
          children.add(new Property("language", "CodeableConcept", "Language code for this name.", 0, 1, language));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "Country code for where this name applies.", 0, 1, country);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "Jurisdiction code for where this name applies. A jurisdiction may be a sub- or supra-national entity (e.g. a state or a geographic region).", 0, 1, jurisdiction);
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

      public MedicinalProductDefinitionNameUsageComponent copy() {
        MedicinalProductDefinitionNameUsageComponent dst = new MedicinalProductDefinitionNameUsageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionNameUsageComponent dst) {
        super.copyValues(dst);
        dst.country = country == null ? null : country.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
        dst.language = language == null ? null : language.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameUsageComponent))
          return false;
        MedicinalProductDefinitionNameUsageComponent o = (MedicinalProductDefinitionNameUsageComponent) other_;
        return compareDeep(country, o.country, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(language, o.language, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionNameUsageComponent))
          return false;
        MedicinalProductDefinitionNameUsageComponent o = (MedicinalProductDefinitionNameUsageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(country, jurisdiction, language
          );
      }

  public String fhirType() {
    return "MedicinalProductDefinition.name.usage";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionCrossReferenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to another product, e.g. for linking authorised to investigational product.
         */
        @Child(name = "product", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to another product, e.g. for linking authorised to investigational product", formalDefinition="Reference to another product, e.g. for linking authorised to investigational product." )
        protected CodeableReference product;

        /**
         * The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of relationship, for instance branded to generic or virtual to actual product", formalDefinition="The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-cross-reference-type")
        protected CodeableConcept type;

        private static final long serialVersionUID = -1746125578L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCrossReferenceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCrossReferenceComponent(CodeableReference product) {
        super();
        this.setProduct(product);
      }

        /**
         * @return {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public CodeableReference getProduct() { 
          if (this.product == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionCrossReferenceComponent.product");
            else if (Configuration.doAutoCreate())
              this.product = new CodeableReference(); // cc
          return this.product;
        }

        public boolean hasProduct() { 
          return this.product != null && !this.product.isEmpty();
        }

        /**
         * @param value {@link #product} (Reference to another product, e.g. for linking authorised to investigational product.)
         */
        public MedicinalProductDefinitionCrossReferenceComponent setProduct(CodeableReference value) { 
          this.product = value;
          return this;
        }

        /**
         * @return {@link #type} (The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version.)
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
         * @param value {@link #type} (The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version.)
         */
        public MedicinalProductDefinitionCrossReferenceComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("product", "CodeableReference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product));
          children.add(new Property("type", "CodeableConcept", "The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -309474065: /*product*/  return new Property("product", "CodeableReference(MedicinalProductDefinition)", "Reference to another product, e.g. for linking authorised to investigational product.", 0, 1, product);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of relationship, for instance branded to generic, virtual to actual product, product to development product (investigational), parallel import version.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // CodeableReference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -309474065: // product
          this.product = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("product")) {
          this.product = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309474065:  return getProduct();
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return new String[] {"CodeableReference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("product")) {
          this.product = new CodeableReference();
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
    public static class MedicinalProductDefinitionOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here.
         */
        @Child(name = "type", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of manufacturing operation e.g. manufacturing itself, re-packaging", formalDefinition="The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here." )
        protected CodeableReference type;

        /**
         * Date range of applicability.
         */
        @Child(name = "effectiveDate", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Date range of applicability", formalDefinition="Date range of applicability." )
        protected Period effectiveDate;

        /**
         * The organization or establishment responsible for (or associated with) the particular process or step, examples include the manufacturer, importer, agent.
         */
        @Child(name = "organization", type = {Organization.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The organization responsible for the particular process, e.g. the manufacturer or importer", formalDefinition="The organization or establishment responsible for (or associated with) the particular process or step, examples include the manufacturer, importer, agent." )
        protected List<Reference> organization;

        /**
         * Specifies whether this particular business or manufacturing process is considered proprietary or confidential.
         */
        @Child(name = "confidentialityIndicator", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specifies whether this process is considered proprietary or confidential", formalDefinition="Specifies whether this particular business or manufacturing process is considered proprietary or confidential." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-confidentiality")
        protected CodeableConcept confidentialityIndicator;

        private static final long serialVersionUID = 1036054906L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionOperationComponent() {
        super();
      }

        /**
         * @return {@link #type} (The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here.)
         */
        public CodeableReference getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionOperationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableReference(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here.)
         */
        public MedicinalProductDefinitionOperationComponent setType(CodeableReference value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #effectiveDate} (Date range of applicability.)
         */
        public Period getEffectiveDate() { 
          if (this.effectiveDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionOperationComponent.effectiveDate");
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
        public MedicinalProductDefinitionOperationComponent setEffectiveDate(Period value) { 
          this.effectiveDate = value;
          return this;
        }

        /**
         * @return {@link #organization} (The organization or establishment responsible for (or associated with) the particular process or step, examples include the manufacturer, importer, agent.)
         */
        public List<Reference> getOrganization() { 
          if (this.organization == null)
            this.organization = new ArrayList<Reference>();
          return this.organization;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicinalProductDefinitionOperationComponent setOrganization(List<Reference> theOrganization) { 
          this.organization = theOrganization;
          return this;
        }

        public boolean hasOrganization() { 
          if (this.organization == null)
            return false;
          for (Reference item : this.organization)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addOrganization() { //3
          Reference t = new Reference();
          if (this.organization == null)
            this.organization = new ArrayList<Reference>();
          this.organization.add(t);
          return t;
        }

        public MedicinalProductDefinitionOperationComponent addOrganization(Reference t) { //3
          if (t == null)
            return this;
          if (this.organization == null)
            this.organization = new ArrayList<Reference>();
          this.organization.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #organization}, creating it if it does not already exist {3}
         */
        public Reference getOrganizationFirstRep() { 
          if (getOrganization().isEmpty()) {
            addOrganization();
          }
          return getOrganization().get(0);
        }

        /**
         * @return {@link #confidentialityIndicator} (Specifies whether this particular business or manufacturing process is considered proprietary or confidential.)
         */
        public CodeableConcept getConfidentialityIndicator() { 
          if (this.confidentialityIndicator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionOperationComponent.confidentialityIndicator");
            else if (Configuration.doAutoCreate())
              this.confidentialityIndicator = new CodeableConcept(); // cc
          return this.confidentialityIndicator;
        }

        public boolean hasConfidentialityIndicator() { 
          return this.confidentialityIndicator != null && !this.confidentialityIndicator.isEmpty();
        }

        /**
         * @param value {@link #confidentialityIndicator} (Specifies whether this particular business or manufacturing process is considered proprietary or confidential.)
         */
        public MedicinalProductDefinitionOperationComponent setConfidentialityIndicator(CodeableConcept value) { 
          this.confidentialityIndicator = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableReference(ActivityDefinition|PlanDefinition)", "The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here.", 0, 1, type));
          children.add(new Property("effectiveDate", "Period", "Date range of applicability.", 0, 1, effectiveDate));
          children.add(new Property("organization", "Reference(Organization)", "The organization or establishment responsible for (or associated with) the particular process or step, examples include the manufacturer, importer, agent.", 0, java.lang.Integer.MAX_VALUE, organization));
          children.add(new Property("confidentialityIndicator", "CodeableConcept", "Specifies whether this particular business or manufacturing process is considered proprietary or confidential.", 0, 1, confidentialityIndicator));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableReference(ActivityDefinition|PlanDefinition)", "The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the authorization of this, a RegulatedAuthorization would point to the same plan or activity referenced here.", 0, 1, type);
          case -930389515: /*effectiveDate*/  return new Property("effectiveDate", "Period", "Date range of applicability.", 0, 1, effectiveDate);
          case 1178922291: /*organization*/  return new Property("organization", "Reference(Organization)", "The organization or establishment responsible for (or associated with) the particular process or step, examples include the manufacturer, importer, agent.", 0, java.lang.Integer.MAX_VALUE, organization);
          case -1449404791: /*confidentialityIndicator*/  return new Property("confidentialityIndicator", "CodeableConcept", "Specifies whether this particular business or manufacturing process is considered proprietary or confidential.", 0, 1, confidentialityIndicator);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableReference
        case -930389515: /*effectiveDate*/ return this.effectiveDate == null ? new Base[0] : new Base[] {this.effectiveDate}; // Period
        case 1178922291: /*organization*/ return this.organization == null ? new Base[0] : this.organization.toArray(new Base[this.organization.size()]); // Reference
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
        case 1178922291: // organization
          this.getOrganization().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("organization")) {
          this.getOrganization().add(TypeConvertor.castToReference(value));
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
        case 1178922291:  return addOrganization(); 
        case -1449404791:  return getConfidentialityIndicator();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableReference"};
        case -930389515: /*effectiveDate*/ return new String[] {"Period"};
        case 1178922291: /*organization*/ return new String[] {"Reference"};
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
        else if (name.equals("organization")) {
          return addOrganization();
        }
        else if (name.equals("confidentialityIndicator")) {
          this.confidentialityIndicator = new CodeableConcept();
          return this.confidentialityIndicator;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionOperationComponent copy() {
        MedicinalProductDefinitionOperationComponent dst = new MedicinalProductDefinitionOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionOperationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.effectiveDate = effectiveDate == null ? null : effectiveDate.copy();
        if (organization != null) {
          dst.organization = new ArrayList<Reference>();
          for (Reference i : organization)
            dst.organization.add(i.copy());
        };
        dst.confidentialityIndicator = confidentialityIndicator == null ? null : confidentialityIndicator.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionOperationComponent))
          return false;
        MedicinalProductDefinitionOperationComponent o = (MedicinalProductDefinitionOperationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(effectiveDate, o.effectiveDate, true) && compareDeep(organization, o.organization, true)
           && compareDeep(confidentialityIndicator, o.confidentialityIndicator, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionOperationComponent))
          return false;
        MedicinalProductDefinitionOperationComponent o = (MedicinalProductDefinitionOperationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, effectiveDate, organization
          , confidentialityIndicator);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.operation";

  }

  }

    @Block()
    public static class MedicinalProductDefinitionCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code expressing the type of characteristic.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code expressing the type of characteristic", formalDefinition="A code expressing the type of characteristic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/product-characteristic-codes")
        protected CodeableConcept type;

        /**
         * A value for the characteristic.text.
         */
        @Child(name = "value", type = {CodeableConcept.class, MarkdownType.class, Quantity.class, IntegerType.class, DateType.class, BooleanType.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the characteristic", formalDefinition="A value for the characteristic.text." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicinalProductDefinitionCharacteristicComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicinalProductDefinitionCharacteristicComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code expressing the type of characteristic.)
         */
        public MedicinalProductDefinitionCharacteristicComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public MarkdownType getValueMarkdownType() throws FHIRException { 
          if (this.value == null)
            this.value = new MarkdownType();
          if (!(this.value instanceof MarkdownType))
            throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (MarkdownType) this.value;
        }

        public boolean hasValueMarkdownType() { 
          return this != null && this.value instanceof MarkdownType;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public DateType getValueDateType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateType();
          if (!(this.value instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateType) this.value;
        }

        public boolean hasValueDateType() { 
          return this != null && this.value instanceof DateType;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (A value for the characteristic.text.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (A value for the characteristic.text.)
         */
        public MedicinalProductDefinitionCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof MarkdownType || value instanceof Quantity || value instanceof IntegerType || value instanceof DateType || value instanceof BooleanType || value instanceof Attachment))
            throw new FHIRException("Not the right type for MedicinalProductDefinition.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|markdown|Quantity|integer|date|boolean|Attachment", "A value for the characteristic.text.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|markdown|Quantity|integer|date|boolean|Attachment", "A value for the characteristic.text.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|markdown|Quantity|integer|date|boolean|Attachment", "A value for the characteristic.text.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "A value for the characteristic.text.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "A value for the characteristic.text.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "A value for the characteristic.text.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "A value for the characteristic.text.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "A value for the characteristic.text.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "A value for the characteristic.text.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "A value for the characteristic.text.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "markdown", "Quantity", "integer", "date", "boolean", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicinalProductDefinitionCharacteristicComponent copy() {
        MedicinalProductDefinitionCharacteristicComponent dst = new MedicinalProductDefinitionCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicinalProductDefinitionCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionCharacteristicComponent))
          return false;
        MedicinalProductDefinitionCharacteristicComponent o = (MedicinalProductDefinitionCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicinalProductDefinitionCharacteristicComponent))
          return false;
        MedicinalProductDefinitionCharacteristicComponent o = (MedicinalProductDefinitionCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicinalProductDefinition.characteristic";

  }

  }

    /**
     * Business identifier for this product. Could be an MPID. When in development or being regulated, products are typically referenced by official identifiers, assigned by a manufacturer or regulator, and unique to a product (which, when compared to a product instance being prescribed, is actually a product type). See also MedicinalProductDefinition.code.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this product. Could be an MPID", formalDefinition="Business identifier for this product. Could be an MPID. When in development or being regulated, products are typically referenced by official identifiers, assigned by a manufacturer or regulator, and unique to a product (which, when compared to a product instance being prescribed, is actually a product type). See also MedicinalProductDefinition.code." )
    protected List<Identifier> identifier;

    /**
     * Regulatory type, e.g. Investigational or Authorized.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Regulatory type, e.g. Investigational or Authorized", formalDefinition="Regulatory type, e.g. Investigational or Authorized." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-type")
    protected CodeableConcept type;

    /**
     * If this medicine applies to human or veterinary uses.
     */
    @Child(name = "domain", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this medicine applies to human or veterinary uses", formalDefinition="If this medicine applies to human or veterinary uses." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-domain")
    protected CodeableConcept domain;

    /**
     * A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.
     */
    @Child(name = "version", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A business identifier relating to a specific version of the product", formalDefinition="A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product." )
    protected StringType version;

    /**
     * The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="The status within the lifecycle of this product record", formalDefinition="The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status." )
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
     * The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm).
     */
    @Child(name = "combinedPharmaceuticalDoseForm", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The dose form for a single part product, or combined form of a multiple part product", formalDefinition="The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/combined-dose-form")
    protected CodeableConcept combinedPharmaceuticalDoseForm;

    /**
     * The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. See also AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together.
     */
    @Child(name = "route", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The path by which the product is taken into or makes contact with the body", formalDefinition="The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. See also AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/route-codes")
    protected List<CodeableConcept> route;

    /**
     * Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.
     */
    @Child(name = "indication", type = {MarkdownType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Description of indication(s) for this product, used when structured indications are not required", formalDefinition="Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate." )
    protected MarkdownType indication;

    /**
     * The legal status of supply of the medicinal product as classified by the regulator.
     */
    @Child(name = "legalStatusOfSupply", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The legal status of supply of the medicinal product as classified by the regulator", formalDefinition="The legal status of supply of the medicinal product as classified by the regulator." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/legal-status-of-supply")
    protected CodeableConcept legalStatusOfSupply;

    /**
     * Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements.
     */
    @Child(name = "additionalMonitoringIndicator", type = {CodeableConcept.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether the Medicinal Product is subject to additional monitoring for regulatory reasons", formalDefinition="Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-additional-monitoring")
    protected CodeableConcept additionalMonitoringIndicator;

    /**
     * Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a requirement to conduct post-authorization studies.
     */
    @Child(name = "specialMeasures", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Whether the Medicinal Product is subject to special measures for regulatory reasons", formalDefinition="Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a requirement to conduct post-authorization studies." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-special-measures")
    protected List<CodeableConcept> specialMeasures;

    /**
     * If authorised for use in children, or infants, neonates etc.
     */
    @Child(name = "pediatricUseIndicator", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If authorised for use in children", formalDefinition="If authorised for use in children, or infants, neonates etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-pediatric-use")
    protected CodeableConcept pediatricUseIndicator;

    /**
     * Allows the product to be classified by various systems, commonly WHO ATC.
     */
    @Child(name = "classification", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows the product to be classified by various systems", formalDefinition="Allows the product to be classified by various systems, commonly WHO ATC." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-classification")
    protected List<CodeableConcept> classification;

    /**
     * Marketing status of the medicinal product, in contrast to marketing authorization. This refers to the product being actually 'on the market' as opposed to being allowed to be on the market (which is an authorization).
     */
    @Child(name = "marketingStatus", type = {MarketingStatus.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Marketing status of the medicinal product, in contrast to marketing authorization", formalDefinition="Marketing status of the medicinal product, in contrast to marketing authorization. This refers to the product being actually 'on the market' as opposed to being allowed to be on the market (which is an authorization)." )
    protected List<MarketingStatus> marketingStatus;

    /**
     * Package type for the product. See also the PackagedProductDefinition resource.
     */
    @Child(name = "packagedMedicinalProduct", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Package type for the product", formalDefinition="Package type for the product. See also the PackagedProductDefinition resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicinal-product-package-type")
    protected List<CodeableConcept> packagedMedicinalProduct;

    /**
     * Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes. Used as a direct link when the item's packaging is not being recorded (see also PackagedProductDefinition.package.containedItem.item).
     */
    @Child(name = "comprisedOf", type = {ManufacturedItemDefinition.class, DeviceDefinition.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes", formalDefinition="Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes. Used as a direct link when the item's packaging is not being recorded (see also PackagedProductDefinition.package.containedItem.item)." )
    protected List<Reference> comprisedOf;

    /**
     * The ingredients of this medicinal product - when not detailed in other resources. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those levels of detail are not used, the ingredients may be specified directly here as codes.
     */
    @Child(name = "ingredient", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The ingredients of this medicinal product - when not detailed in other resources", formalDefinition="The ingredients of this medicinal product - when not detailed in other resources. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those levels of detail are not used, the ingredients may be specified directly here as codes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
    protected List<CodeableConcept> ingredient;

    /**
     * Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product. This includes process-related impurities and contaminants, product-related impurities including degradation products.
     */
    @Child(name = "impurity", type = {CodeableReference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product", formalDefinition="Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product. This includes process-related impurities and contaminants, product-related impurities including degradation products." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
    protected List<CodeableReference> impurity;

    /**
     * Additional information or supporting documentation about the medicinal product.
     */
    @Child(name = "attachedDocument", type = {DocumentReference.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional documentation about the medicinal product", formalDefinition="Additional information or supporting documentation about the medicinal product." )
    protected List<Reference> attachedDocument;

    /**
     * A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug master files (DMFs) are documents submitted to regulatory agencies to provide confidential detailed information about facilities, processes or articles used in the manufacturing, processing, packaging and storing of drug products.
     */
    @Child(name = "masterFile", type = {DocumentReference.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A master file for the medicinal product (e.g. Pharmacovigilance System Master File)", formalDefinition="A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug master files (DMFs) are documents submitted to regulatory agencies to provide confidential detailed information about facilities, processes or articles used in the manufacturing, processing, packaging and storing of drug products." )
    protected List<Reference> masterFile;

    /**
     * A product specific contact, person (in a role), or an organization.
     */
    @Child(name = "contact", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A product specific contact, person (in a role), or an organization", formalDefinition="A product specific contact, person (in a role), or an organization." )
    protected List<MedicinalProductDefinitionContactComponent> contact;

    /**
     * Clinical trials or studies that this product is involved in.
     */
    @Child(name = "clinicalTrial", type = {ResearchStudy.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Clinical trials or studies that this product is involved in", formalDefinition="Clinical trials or studies that this product is involved in." )
    protected List<Reference> clinicalTrial;

    /**
     * A code that this product is known by, usually within some formal terminology, perhaps assigned by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend to be known by identifiers during development and within regulatory process. However when they are prescribed they tend to be identified by codes. The same product may be have multiple codes, applied to it by multiple organizations.
     */
    @Child(name = "code", type = {Coding.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A code that this product is known by, within some formal terminology", formalDefinition="A code that this product is known by, usually within some formal terminology, perhaps assigned by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend to be known by identifiers during development and within regulatory process. However when they are prescribed they tend to be identified by codes. The same product may be have multiple codes, applied to it by multiple organizations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected List<Coding> code;

    /**
     * The product's name, including full name and possibly coded parts.
     */
    @Child(name = "name", type = {}, order=25, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The product's name, including full name and possibly coded parts", formalDefinition="The product's name, including full name and possibly coded parts." )
    protected List<MedicinalProductDefinitionNameComponent> name;

    /**
     * Reference to another product, e.g. for linking authorised to investigational product, or a virtual product.
     */
    @Child(name = "crossReference", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Reference to another product, e.g. for linking authorised to investigational product", formalDefinition="Reference to another product, e.g. for linking authorised to investigational product, or a virtual product." )
    protected List<MedicinalProductDefinitionCrossReferenceComponent> crossReference;

    /**
     * A manufacturing or administrative process or step associated with (or performed on) the medicinal product.
     */
    @Child(name = "operation", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A manufacturing or administrative process for the medicinal product", formalDefinition="A manufacturing or administrative process or step associated with (or performed on) the medicinal product." )
    protected List<MedicinalProductDefinitionOperationComponent> operation;

    /**
     * Allows the key product features to be recorded, such as "sugar free", "modified release", "parallel import".
     */
    @Child(name = "characteristic", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Key product features such as \"sugar free\", \"modified release\"", formalDefinition="Allows the key product features to be recorded, such as \"sugar free\", \"modified release\", \"parallel import\"." )
    protected List<MedicinalProductDefinitionCharacteristicComponent> characteristic;

    private static final long serialVersionUID = 1105265034L;

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
     * @return {@link #identifier} (Business identifier for this product. Could be an MPID. When in development or being regulated, products are typically referenced by official identifiers, assigned by a manufacturer or regulator, and unique to a product (which, when compared to a product instance being prescribed, is actually a product type). See also MedicinalProductDefinition.code.)
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
     * @return {@link #version} (A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
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
     * @param value {@link #version} (A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public MedicinalProductDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.
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
     * @return {@link #status} (The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status.)
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
     * @param value {@link #status} (The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status.)
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
     * @return {@link #combinedPharmaceuticalDoseForm} (The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm).)
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
     * @param value {@link #combinedPharmaceuticalDoseForm} (The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm).)
     */
    public MedicinalProductDefinition setCombinedPharmaceuticalDoseForm(CodeableConcept value) { 
      this.combinedPharmaceuticalDoseForm = value;
      return this;
    }

    /**
     * @return {@link #route} (The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. See also AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together.)
     */
    public List<CodeableConcept> getRoute() { 
      if (this.route == null)
        this.route = new ArrayList<CodeableConcept>();
      return this.route;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setRoute(List<CodeableConcept> theRoute) { 
      this.route = theRoute;
      return this;
    }

    public boolean hasRoute() { 
      if (this.route == null)
        return false;
      for (CodeableConcept item : this.route)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addRoute() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.route == null)
        this.route = new ArrayList<CodeableConcept>();
      this.route.add(t);
      return t;
    }

    public MedicinalProductDefinition addRoute(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.route == null)
        this.route = new ArrayList<CodeableConcept>();
      this.route.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #route}, creating it if it does not already exist {3}
     */
    public CodeableConcept getRouteFirstRep() { 
      if (getRoute().isEmpty()) {
        addRoute();
      }
      return getRoute().get(0);
    }

    /**
     * @return {@link #indication} (Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.). This is the underlying object with id, value and extensions. The accessor "getIndication" gives direct access to the value
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
     * @param value {@link #indication} (Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.). This is the underlying object with id, value and extensions. The accessor "getIndication" gives direct access to the value
     */
    public MedicinalProductDefinition setIndicationElement(MarkdownType value) { 
      this.indication = value;
      return this;
    }

    /**
     * @return Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.
     */
    public String getIndication() { 
      return this.indication == null ? null : this.indication.getValue();
    }

    /**
     * @param value Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.
     */
    public MedicinalProductDefinition setIndication(String value) { 
      if (Utilities.noString(value))
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
     * @return {@link #additionalMonitoringIndicator} (Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements.)
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
     * @param value {@link #additionalMonitoringIndicator} (Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements.)
     */
    public MedicinalProductDefinition setAdditionalMonitoringIndicator(CodeableConcept value) { 
      this.additionalMonitoringIndicator = value;
      return this;
    }

    /**
     * @return {@link #specialMeasures} (Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a requirement to conduct post-authorization studies.)
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
     * @return {@link #pediatricUseIndicator} (If authorised for use in children, or infants, neonates etc.)
     */
    public CodeableConcept getPediatricUseIndicator() { 
      if (this.pediatricUseIndicator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicinalProductDefinition.pediatricUseIndicator");
        else if (Configuration.doAutoCreate())
          this.pediatricUseIndicator = new CodeableConcept(); // cc
      return this.pediatricUseIndicator;
    }

    public boolean hasPediatricUseIndicator() { 
      return this.pediatricUseIndicator != null && !this.pediatricUseIndicator.isEmpty();
    }

    /**
     * @param value {@link #pediatricUseIndicator} (If authorised for use in children, or infants, neonates etc.)
     */
    public MedicinalProductDefinition setPediatricUseIndicator(CodeableConcept value) { 
      this.pediatricUseIndicator = value;
      return this;
    }

    /**
     * @return {@link #classification} (Allows the product to be classified by various systems, commonly WHO ATC.)
     */
    public List<CodeableConcept> getClassification() { 
      if (this.classification == null)
        this.classification = new ArrayList<CodeableConcept>();
      return this.classification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setClassification(List<CodeableConcept> theClassification) { 
      this.classification = theClassification;
      return this;
    }

    public boolean hasClassification() { 
      if (this.classification == null)
        return false;
      for (CodeableConcept item : this.classification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClassification() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.classification == null)
        this.classification = new ArrayList<CodeableConcept>();
      this.classification.add(t);
      return t;
    }

    public MedicinalProductDefinition addClassification(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.classification == null)
        this.classification = new ArrayList<CodeableConcept>();
      this.classification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classification}, creating it if it does not already exist {3}
     */
    public CodeableConcept getClassificationFirstRep() { 
      if (getClassification().isEmpty()) {
        addClassification();
      }
      return getClassification().get(0);
    }

    /**
     * @return {@link #marketingStatus} (Marketing status of the medicinal product, in contrast to marketing authorization. This refers to the product being actually 'on the market' as opposed to being allowed to be on the market (which is an authorization).)
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
     * @return {@link #packagedMedicinalProduct} (Package type for the product. See also the PackagedProductDefinition resource.)
     */
    public List<CodeableConcept> getPackagedMedicinalProduct() { 
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<CodeableConcept>();
      return this.packagedMedicinalProduct;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setPackagedMedicinalProduct(List<CodeableConcept> thePackagedMedicinalProduct) { 
      this.packagedMedicinalProduct = thePackagedMedicinalProduct;
      return this;
    }

    public boolean hasPackagedMedicinalProduct() { 
      if (this.packagedMedicinalProduct == null)
        return false;
      for (CodeableConcept item : this.packagedMedicinalProduct)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addPackagedMedicinalProduct() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<CodeableConcept>();
      this.packagedMedicinalProduct.add(t);
      return t;
    }

    public MedicinalProductDefinition addPackagedMedicinalProduct(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.packagedMedicinalProduct == null)
        this.packagedMedicinalProduct = new ArrayList<CodeableConcept>();
      this.packagedMedicinalProduct.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #packagedMedicinalProduct}, creating it if it does not already exist {3}
     */
    public CodeableConcept getPackagedMedicinalProductFirstRep() { 
      if (getPackagedMedicinalProduct().isEmpty()) {
        addPackagedMedicinalProduct();
      }
      return getPackagedMedicinalProduct().get(0);
    }

    /**
     * @return {@link #comprisedOf} (Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes. Used as a direct link when the item's packaging is not being recorded (see also PackagedProductDefinition.package.containedItem.item).)
     */
    public List<Reference> getComprisedOf() { 
      if (this.comprisedOf == null)
        this.comprisedOf = new ArrayList<Reference>();
      return this.comprisedOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setComprisedOf(List<Reference> theComprisedOf) { 
      this.comprisedOf = theComprisedOf;
      return this;
    }

    public boolean hasComprisedOf() { 
      if (this.comprisedOf == null)
        return false;
      for (Reference item : this.comprisedOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addComprisedOf() { //3
      Reference t = new Reference();
      if (this.comprisedOf == null)
        this.comprisedOf = new ArrayList<Reference>();
      this.comprisedOf.add(t);
      return t;
    }

    public MedicinalProductDefinition addComprisedOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.comprisedOf == null)
        this.comprisedOf = new ArrayList<Reference>();
      this.comprisedOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #comprisedOf}, creating it if it does not already exist {3}
     */
    public Reference getComprisedOfFirstRep() { 
      if (getComprisedOf().isEmpty()) {
        addComprisedOf();
      }
      return getComprisedOf().get(0);
    }

    /**
     * @return {@link #ingredient} (The ingredients of this medicinal product - when not detailed in other resources. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those levels of detail are not used, the ingredients may be specified directly here as codes.)
     */
    public List<CodeableConcept> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setIngredient(List<CodeableConcept> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (CodeableConcept item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addIngredient() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      this.ingredient.add(t);
      return t;
    }

    public MedicinalProductDefinition addIngredient(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<CodeableConcept>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public CodeableConcept getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #impurity} (Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product. This includes process-related impurities and contaminants, product-related impurities including degradation products.)
     */
    public List<CodeableReference> getImpurity() { 
      if (this.impurity == null)
        this.impurity = new ArrayList<CodeableReference>();
      return this.impurity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setImpurity(List<CodeableReference> theImpurity) { 
      this.impurity = theImpurity;
      return this;
    }

    public boolean hasImpurity() { 
      if (this.impurity == null)
        return false;
      for (CodeableReference item : this.impurity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addImpurity() { //3
      CodeableReference t = new CodeableReference();
      if (this.impurity == null)
        this.impurity = new ArrayList<CodeableReference>();
      this.impurity.add(t);
      return t;
    }

    public MedicinalProductDefinition addImpurity(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.impurity == null)
        this.impurity = new ArrayList<CodeableReference>();
      this.impurity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #impurity}, creating it if it does not already exist {3}
     */
    public CodeableReference getImpurityFirstRep() { 
      if (getImpurity().isEmpty()) {
        addImpurity();
      }
      return getImpurity().get(0);
    }

    /**
     * @return {@link #attachedDocument} (Additional information or supporting documentation about the medicinal product.)
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
     * @return {@link #masterFile} (A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug master files (DMFs) are documents submitted to regulatory agencies to provide confidential detailed information about facilities, processes or articles used in the manufacturing, processing, packaging and storing of drug products.)
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
     * @return {@link #code} (A code that this product is known by, usually within some formal terminology, perhaps assigned by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend to be known by identifiers during development and within regulatory process. However when they are prescribed they tend to be identified by codes. The same product may be have multiple codes, applied to it by multiple organizations.)
     */
    public List<Coding> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setCode(List<Coding> theCode) { 
      this.code = theCode;
      return this;
    }

    public boolean hasCode() { 
      if (this.code == null)
        return false;
      for (Coding item : this.code)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Coding addCode() { //3
      Coding t = new Coding();
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      this.code.add(t);
      return t;
    }

    public MedicinalProductDefinition addCode(Coding t) { //3
      if (t == null)
        return this;
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      this.code.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
     */
    public Coding getCodeFirstRep() { 
      if (getCode().isEmpty()) {
        addCode();
      }
      return getCode().get(0);
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
     * @return {@link #crossReference} (Reference to another product, e.g. for linking authorised to investigational product, or a virtual product.)
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
     * @return {@link #operation} (A manufacturing or administrative process or step associated with (or performed on) the medicinal product.)
     */
    public List<MedicinalProductDefinitionOperationComponent> getOperation() { 
      if (this.operation == null)
        this.operation = new ArrayList<MedicinalProductDefinitionOperationComponent>();
      return this.operation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setOperation(List<MedicinalProductDefinitionOperationComponent> theOperation) { 
      this.operation = theOperation;
      return this;
    }

    public boolean hasOperation() { 
      if (this.operation == null)
        return false;
      for (MedicinalProductDefinitionOperationComponent item : this.operation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionOperationComponent addOperation() { //3
      MedicinalProductDefinitionOperationComponent t = new MedicinalProductDefinitionOperationComponent();
      if (this.operation == null)
        this.operation = new ArrayList<MedicinalProductDefinitionOperationComponent>();
      this.operation.add(t);
      return t;
    }

    public MedicinalProductDefinition addOperation(MedicinalProductDefinitionOperationComponent t) { //3
      if (t == null)
        return this;
      if (this.operation == null)
        this.operation = new ArrayList<MedicinalProductDefinitionOperationComponent>();
      this.operation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionOperationComponent getOperationFirstRep() { 
      if (getOperation().isEmpty()) {
        addOperation();
      }
      return getOperation().get(0);
    }

    /**
     * @return {@link #characteristic} (Allows the key product features to be recorded, such as "sugar free", "modified release", "parallel import".)
     */
    public List<MedicinalProductDefinitionCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<MedicinalProductDefinitionCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicinalProductDefinition setCharacteristic(List<MedicinalProductDefinitionCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (MedicinalProductDefinitionCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicinalProductDefinitionCharacteristicComponent addCharacteristic() { //3
      MedicinalProductDefinitionCharacteristicComponent t = new MedicinalProductDefinitionCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<MedicinalProductDefinitionCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public MedicinalProductDefinition addCharacteristic(MedicinalProductDefinitionCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<MedicinalProductDefinitionCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public MedicinalProductDefinitionCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this product. Could be an MPID. When in development or being regulated, products are typically referenced by official identifiers, assigned by a manufacturer or regulator, and unique to a product (which, when compared to a product instance being prescribed, is actually a product type). See also MedicinalProductDefinition.code.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "CodeableConcept", "Regulatory type, e.g. Investigational or Authorized.", 0, 1, type));
        children.add(new Property("domain", "CodeableConcept", "If this medicine applies to human or veterinary uses.", 0, 1, domain));
        children.add(new Property("version", "string", "A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.", 0, 1, version));
        children.add(new Property("status", "CodeableConcept", "The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status.", 0, 1, status));
        children.add(new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate));
        children.add(new Property("description", "markdown", "General description of this product.", 0, 1, description));
        children.add(new Property("combinedPharmaceuticalDoseForm", "CodeableConcept", "The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm).", 0, 1, combinedPharmaceuticalDoseForm));
        children.add(new Property("route", "CodeableConcept", "The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. See also AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together.", 0, java.lang.Integer.MAX_VALUE, route));
        children.add(new Property("indication", "markdown", "Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.", 0, 1, indication));
        children.add(new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply));
        children.add(new Property("additionalMonitoringIndicator", "CodeableConcept", "Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements.", 0, 1, additionalMonitoringIndicator));
        children.add(new Property("specialMeasures", "CodeableConcept", "Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a requirement to conduct post-authorization studies.", 0, java.lang.Integer.MAX_VALUE, specialMeasures));
        children.add(new Property("pediatricUseIndicator", "CodeableConcept", "If authorised for use in children, or infants, neonates etc.", 0, 1, pediatricUseIndicator));
        children.add(new Property("classification", "CodeableConcept", "Allows the product to be classified by various systems, commonly WHO ATC.", 0, java.lang.Integer.MAX_VALUE, classification));
        children.add(new Property("marketingStatus", "MarketingStatus", "Marketing status of the medicinal product, in contrast to marketing authorization. This refers to the product being actually 'on the market' as opposed to being allowed to be on the market (which is an authorization).", 0, java.lang.Integer.MAX_VALUE, marketingStatus));
        children.add(new Property("packagedMedicinalProduct", "CodeableConcept", "Package type for the product. See also the PackagedProductDefinition resource.", 0, java.lang.Integer.MAX_VALUE, packagedMedicinalProduct));
        children.add(new Property("comprisedOf", "Reference(ManufacturedItemDefinition|DeviceDefinition)", "Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes. Used as a direct link when the item's packaging is not being recorded (see also PackagedProductDefinition.package.containedItem.item).", 0, java.lang.Integer.MAX_VALUE, comprisedOf));
        children.add(new Property("ingredient", "CodeableConcept", "The ingredients of this medicinal product - when not detailed in other resources. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those levels of detail are not used, the ingredients may be specified directly here as codes.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("impurity", "CodeableReference(SubstanceDefinition)", "Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product. This includes process-related impurities and contaminants, product-related impurities including degradation products.", 0, java.lang.Integer.MAX_VALUE, impurity));
        children.add(new Property("attachedDocument", "Reference(DocumentReference)", "Additional information or supporting documentation about the medicinal product.", 0, java.lang.Integer.MAX_VALUE, attachedDocument));
        children.add(new Property("masterFile", "Reference(DocumentReference)", "A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug master files (DMFs) are documents submitted to regulatory agencies to provide confidential detailed information about facilities, processes or articles used in the manufacturing, processing, packaging and storing of drug products.", 0, java.lang.Integer.MAX_VALUE, masterFile));
        children.add(new Property("contact", "", "A product specific contact, person (in a role), or an organization.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("clinicalTrial", "Reference(ResearchStudy)", "Clinical trials or studies that this product is involved in.", 0, java.lang.Integer.MAX_VALUE, clinicalTrial));
        children.add(new Property("code", "Coding", "A code that this product is known by, usually within some formal terminology, perhaps assigned by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend to be known by identifiers during development and within regulatory process. However when they are prescribed they tend to be identified by codes. The same product may be have multiple codes, applied to it by multiple organizations.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("name", "", "The product's name, including full name and possibly coded parts.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("crossReference", "", "Reference to another product, e.g. for linking authorised to investigational product, or a virtual product.", 0, java.lang.Integer.MAX_VALUE, crossReference));
        children.add(new Property("operation", "", "A manufacturing or administrative process or step associated with (or performed on) the medicinal product.", 0, java.lang.Integer.MAX_VALUE, operation));
        children.add(new Property("characteristic", "", "Allows the key product features to be recorded, such as \"sugar free\", \"modified release\", \"parallel import\".", 0, java.lang.Integer.MAX_VALUE, characteristic));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this product. Could be an MPID. When in development or being regulated, products are typically referenced by official identifiers, assigned by a manufacturer or regulator, and unique to a product (which, when compared to a product instance being prescribed, is actually a product type). See also MedicinalProductDefinition.code.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Regulatory type, e.g. Investigational or Authorized.", 0, 1, type);
        case -1326197564: /*domain*/  return new Property("domain", "CodeableConcept", "If this medicine applies to human or veterinary uses.", 0, 1, domain);
        case 351608024: /*version*/  return new Property("version", "string", "A business identifier relating to a specific version of the product, this is commonly used to support revisions to an existing product.", 0, 1, version);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status.", 0, 1, status);
        case 247524032: /*statusDate*/  return new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate);
        case -1724546052: /*description*/  return new Property("description", "markdown", "General description of this product.", 0, 1, description);
        case -1992898487: /*combinedPharmaceuticalDoseForm*/  return new Property("combinedPharmaceuticalDoseForm", "CodeableConcept", "The dose form for a single part product, or combined form of a multiple part product. This is one concept that describes all the components. It does not represent the form with components physically mixed, if that might be necessary, for which see (AdministrableProductDefinition.administrableDoseForm).", 0, 1, combinedPharmaceuticalDoseForm);
        case 108704329: /*route*/  return new Property("route", "CodeableConcept", "The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. See also AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together.", 0, java.lang.Integer.MAX_VALUE, route);
        case -597168804: /*indication*/  return new Property("indication", "markdown", "Description of indication(s) for this product, used when structured indications are not required. In cases where structured indications are required, they are captured using the ClinicalUseDefinition resource. An indication is a medical situation for which using the product is appropriate.", 0, 1, indication);
        case -844874031: /*legalStatusOfSupply*/  return new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply);
        case 1935999744: /*additionalMonitoringIndicator*/  return new Property("additionalMonitoringIndicator", "CodeableConcept", "Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such as heightened reporting requirements.", 0, 1, additionalMonitoringIndicator);
        case 975102638: /*specialMeasures*/  return new Property("specialMeasures", "CodeableConcept", "Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a requirement to conduct post-authorization studies.", 0, java.lang.Integer.MAX_VALUE, specialMeasures);
        case -1515533081: /*pediatricUseIndicator*/  return new Property("pediatricUseIndicator", "CodeableConcept", "If authorised for use in children, or infants, neonates etc.", 0, 1, pediatricUseIndicator);
        case 382350310: /*classification*/  return new Property("classification", "CodeableConcept", "Allows the product to be classified by various systems, commonly WHO ATC.", 0, java.lang.Integer.MAX_VALUE, classification);
        case 70767032: /*marketingStatus*/  return new Property("marketingStatus", "MarketingStatus", "Marketing status of the medicinal product, in contrast to marketing authorization. This refers to the product being actually 'on the market' as opposed to being allowed to be on the market (which is an authorization).", 0, java.lang.Integer.MAX_VALUE, marketingStatus);
        case -361025513: /*packagedMedicinalProduct*/  return new Property("packagedMedicinalProduct", "CodeableConcept", "Package type for the product. See also the PackagedProductDefinition resource.", 0, java.lang.Integer.MAX_VALUE, packagedMedicinalProduct);
        case 1546078211: /*comprisedOf*/  return new Property("comprisedOf", "Reference(ManufacturedItemDefinition|DeviceDefinition)", "Types of medicinal manufactured items and/or devices that this product consists of, such as tablets, capsule, or syringes. Used as a direct link when the item's packaging is not being recorded (see also PackagedProductDefinition.package.containedItem.item).", 0, java.lang.Integer.MAX_VALUE, comprisedOf);
        case -206409263: /*ingredient*/  return new Property("ingredient", "CodeableConcept", "The ingredients of this medicinal product - when not detailed in other resources. This is only needed if the ingredients are not specified by incoming references from the Ingredient resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those levels of detail are not used, the ingredients may be specified directly here as codes.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case -416837467: /*impurity*/  return new Property("impurity", "CodeableReference(SubstanceDefinition)", "Any component of the drug product which is not the chemical entity defined as the drug substance, or an excipient in the drug product. This includes process-related impurities and contaminants, product-related impurities including degradation products.", 0, java.lang.Integer.MAX_VALUE, impurity);
        case -513945889: /*attachedDocument*/  return new Property("attachedDocument", "Reference(DocumentReference)", "Additional information or supporting documentation about the medicinal product.", 0, java.lang.Integer.MAX_VALUE, attachedDocument);
        case -2039573762: /*masterFile*/  return new Property("masterFile", "Reference(DocumentReference)", "A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug master files (DMFs) are documents submitted to regulatory agencies to provide confidential detailed information about facilities, processes or articles used in the manufacturing, processing, packaging and storing of drug products.", 0, java.lang.Integer.MAX_VALUE, masterFile);
        case 951526432: /*contact*/  return new Property("contact", "", "A product specific contact, person (in a role), or an organization.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 1232866243: /*clinicalTrial*/  return new Property("clinicalTrial", "Reference(ResearchStudy)", "Clinical trials or studies that this product is involved in.", 0, java.lang.Integer.MAX_VALUE, clinicalTrial);
        case 3059181: /*code*/  return new Property("code", "Coding", "A code that this product is known by, usually within some formal terminology, perhaps assigned by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend to be known by identifiers during development and within regulatory process. However when they are prescribed they tend to be identified by codes. The same product may be have multiple codes, applied to it by multiple organizations.", 0, java.lang.Integer.MAX_VALUE, code);
        case 3373707: /*name*/  return new Property("name", "", "The product's name, including full name and possibly coded parts.", 0, java.lang.Integer.MAX_VALUE, name);
        case -986968341: /*crossReference*/  return new Property("crossReference", "", "Reference to another product, e.g. for linking authorised to investigational product, or a virtual product.", 0, java.lang.Integer.MAX_VALUE, crossReference);
        case 1662702951: /*operation*/  return new Property("operation", "", "A manufacturing or administrative process or step associated with (or performed on) the medicinal product.", 0, java.lang.Integer.MAX_VALUE, operation);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "Allows the key product features to be recorded, such as \"sugar free\", \"modified release\", \"parallel import\".", 0, java.lang.Integer.MAX_VALUE, characteristic);
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
        case 108704329: /*route*/ return this.route == null ? new Base[0] : this.route.toArray(new Base[this.route.size()]); // CodeableConcept
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // MarkdownType
        case -844874031: /*legalStatusOfSupply*/ return this.legalStatusOfSupply == null ? new Base[0] : new Base[] {this.legalStatusOfSupply}; // CodeableConcept
        case 1935999744: /*additionalMonitoringIndicator*/ return this.additionalMonitoringIndicator == null ? new Base[0] : new Base[] {this.additionalMonitoringIndicator}; // CodeableConcept
        case 975102638: /*specialMeasures*/ return this.specialMeasures == null ? new Base[0] : this.specialMeasures.toArray(new Base[this.specialMeasures.size()]); // CodeableConcept
        case -1515533081: /*pediatricUseIndicator*/ return this.pediatricUseIndicator == null ? new Base[0] : new Base[] {this.pediatricUseIndicator}; // CodeableConcept
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : this.classification.toArray(new Base[this.classification.size()]); // CodeableConcept
        case 70767032: /*marketingStatus*/ return this.marketingStatus == null ? new Base[0] : this.marketingStatus.toArray(new Base[this.marketingStatus.size()]); // MarketingStatus
        case -361025513: /*packagedMedicinalProduct*/ return this.packagedMedicinalProduct == null ? new Base[0] : this.packagedMedicinalProduct.toArray(new Base[this.packagedMedicinalProduct.size()]); // CodeableConcept
        case 1546078211: /*comprisedOf*/ return this.comprisedOf == null ? new Base[0] : this.comprisedOf.toArray(new Base[this.comprisedOf.size()]); // Reference
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // CodeableConcept
        case -416837467: /*impurity*/ return this.impurity == null ? new Base[0] : this.impurity.toArray(new Base[this.impurity.size()]); // CodeableReference
        case -513945889: /*attachedDocument*/ return this.attachedDocument == null ? new Base[0] : this.attachedDocument.toArray(new Base[this.attachedDocument.size()]); // Reference
        case -2039573762: /*masterFile*/ return this.masterFile == null ? new Base[0] : this.masterFile.toArray(new Base[this.masterFile.size()]); // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // MedicinalProductDefinitionContactComponent
        case 1232866243: /*clinicalTrial*/ return this.clinicalTrial == null ? new Base[0] : this.clinicalTrial.toArray(new Base[this.clinicalTrial.size()]); // Reference
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // Coding
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // MedicinalProductDefinitionNameComponent
        case -986968341: /*crossReference*/ return this.crossReference == null ? new Base[0] : this.crossReference.toArray(new Base[this.crossReference.size()]); // MedicinalProductDefinitionCrossReferenceComponent
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // MedicinalProductDefinitionOperationComponent
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // MedicinalProductDefinitionCharacteristicComponent
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
        case 108704329: // route
          this.getRoute().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        case -1515533081: // pediatricUseIndicator
          this.pediatricUseIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 382350310: // classification
          this.getClassification().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 70767032: // marketingStatus
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value)); // MarketingStatus
          return value;
        case -361025513: // packagedMedicinalProduct
          this.getPackagedMedicinalProduct().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1546078211: // comprisedOf
          this.getComprisedOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -206409263: // ingredient
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -416837467: // impurity
          this.getImpurity().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
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
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case 3373707: // name
          this.getName().add((MedicinalProductDefinitionNameComponent) value); // MedicinalProductDefinitionNameComponent
          return value;
        case -986968341: // crossReference
          this.getCrossReference().add((MedicinalProductDefinitionCrossReferenceComponent) value); // MedicinalProductDefinitionCrossReferenceComponent
          return value;
        case 1662702951: // operation
          this.getOperation().add((MedicinalProductDefinitionOperationComponent) value); // MedicinalProductDefinitionOperationComponent
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((MedicinalProductDefinitionCharacteristicComponent) value); // MedicinalProductDefinitionCharacteristicComponent
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
        } else if (name.equals("route")) {
          this.getRoute().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("indication")) {
          this.indication = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("legalStatusOfSupply")) {
          this.legalStatusOfSupply = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("additionalMonitoringIndicator")) {
          this.additionalMonitoringIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specialMeasures")) {
          this.getSpecialMeasures().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("pediatricUseIndicator")) {
          this.pediatricUseIndicator = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classification")) {
          this.getClassification().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value));
        } else if (name.equals("packagedMedicinalProduct")) {
          this.getPackagedMedicinalProduct().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("comprisedOf")) {
          this.getComprisedOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("impurity")) {
          this.getImpurity().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("attachedDocument")) {
          this.getAttachedDocument().add(TypeConvertor.castToReference(value));
        } else if (name.equals("masterFile")) {
          this.getMasterFile().add(TypeConvertor.castToReference(value));
        } else if (name.equals("contact")) {
          this.getContact().add((MedicinalProductDefinitionContactComponent) value);
        } else if (name.equals("clinicalTrial")) {
          this.getClinicalTrial().add(TypeConvertor.castToReference(value));
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("name")) {
          this.getName().add((MedicinalProductDefinitionNameComponent) value);
        } else if (name.equals("crossReference")) {
          this.getCrossReference().add((MedicinalProductDefinitionCrossReferenceComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().add((MedicinalProductDefinitionOperationComponent) value);
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((MedicinalProductDefinitionCharacteristicComponent) value);
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
        case 108704329:  return addRoute(); 
        case -597168804:  return getIndicationElement();
        case -844874031:  return getLegalStatusOfSupply();
        case 1935999744:  return getAdditionalMonitoringIndicator();
        case 975102638:  return addSpecialMeasures(); 
        case -1515533081:  return getPediatricUseIndicator();
        case 382350310:  return addClassification(); 
        case 70767032:  return addMarketingStatus(); 
        case -361025513:  return addPackagedMedicinalProduct(); 
        case 1546078211:  return addComprisedOf(); 
        case -206409263:  return addIngredient(); 
        case -416837467:  return addImpurity(); 
        case -513945889:  return addAttachedDocument(); 
        case -2039573762:  return addMasterFile(); 
        case 951526432:  return addContact(); 
        case 1232866243:  return addClinicalTrial(); 
        case 3059181:  return addCode(); 
        case 3373707:  return addName(); 
        case -986968341:  return addCrossReference(); 
        case 1662702951:  return addOperation(); 
        case 366313883:  return addCharacteristic(); 
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
        case 108704329: /*route*/ return new String[] {"CodeableConcept"};
        case -597168804: /*indication*/ return new String[] {"markdown"};
        case -844874031: /*legalStatusOfSupply*/ return new String[] {"CodeableConcept"};
        case 1935999744: /*additionalMonitoringIndicator*/ return new String[] {"CodeableConcept"};
        case 975102638: /*specialMeasures*/ return new String[] {"CodeableConcept"};
        case -1515533081: /*pediatricUseIndicator*/ return new String[] {"CodeableConcept"};
        case 382350310: /*classification*/ return new String[] {"CodeableConcept"};
        case 70767032: /*marketingStatus*/ return new String[] {"MarketingStatus"};
        case -361025513: /*packagedMedicinalProduct*/ return new String[] {"CodeableConcept"};
        case 1546078211: /*comprisedOf*/ return new String[] {"Reference"};
        case -206409263: /*ingredient*/ return new String[] {"CodeableConcept"};
        case -416837467: /*impurity*/ return new String[] {"CodeableReference"};
        case -513945889: /*attachedDocument*/ return new String[] {"Reference"};
        case -2039573762: /*masterFile*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {};
        case 1232866243: /*clinicalTrial*/ return new String[] {"Reference"};
        case 3059181: /*code*/ return new String[] {"Coding"};
        case 3373707: /*name*/ return new String[] {};
        case -986968341: /*crossReference*/ return new String[] {};
        case 1662702951: /*operation*/ return new String[] {};
        case 366313883: /*characteristic*/ return new String[] {};
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
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.version");
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.statusDate");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.description");
        }
        else if (name.equals("combinedPharmaceuticalDoseForm")) {
          this.combinedPharmaceuticalDoseForm = new CodeableConcept();
          return this.combinedPharmaceuticalDoseForm;
        }
        else if (name.equals("route")) {
          return addRoute();
        }
        else if (name.equals("indication")) {
          throw new FHIRException("Cannot call addChild on a singleton property MedicinalProductDefinition.indication");
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
        else if (name.equals("pediatricUseIndicator")) {
          this.pediatricUseIndicator = new CodeableConcept();
          return this.pediatricUseIndicator;
        }
        else if (name.equals("classification")) {
          return addClassification();
        }
        else if (name.equals("marketingStatus")) {
          return addMarketingStatus();
        }
        else if (name.equals("packagedMedicinalProduct")) {
          return addPackagedMedicinalProduct();
        }
        else if (name.equals("comprisedOf")) {
          return addComprisedOf();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("impurity")) {
          return addImpurity();
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
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("crossReference")) {
          return addCrossReference();
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
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
        if (route != null) {
          dst.route = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : route)
            dst.route.add(i.copy());
        };
        dst.indication = indication == null ? null : indication.copy();
        dst.legalStatusOfSupply = legalStatusOfSupply == null ? null : legalStatusOfSupply.copy();
        dst.additionalMonitoringIndicator = additionalMonitoringIndicator == null ? null : additionalMonitoringIndicator.copy();
        if (specialMeasures != null) {
          dst.specialMeasures = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialMeasures)
            dst.specialMeasures.add(i.copy());
        };
        dst.pediatricUseIndicator = pediatricUseIndicator == null ? null : pediatricUseIndicator.copy();
        if (classification != null) {
          dst.classification = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classification)
            dst.classification.add(i.copy());
        };
        if (marketingStatus != null) {
          dst.marketingStatus = new ArrayList<MarketingStatus>();
          for (MarketingStatus i : marketingStatus)
            dst.marketingStatus.add(i.copy());
        };
        if (packagedMedicinalProduct != null) {
          dst.packagedMedicinalProduct = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : packagedMedicinalProduct)
            dst.packagedMedicinalProduct.add(i.copy());
        };
        if (comprisedOf != null) {
          dst.comprisedOf = new ArrayList<Reference>();
          for (Reference i : comprisedOf)
            dst.comprisedOf.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (impurity != null) {
          dst.impurity = new ArrayList<CodeableReference>();
          for (CodeableReference i : impurity)
            dst.impurity.add(i.copy());
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
        if (code != null) {
          dst.code = new ArrayList<Coding>();
          for (Coding i : code)
            dst.code.add(i.copy());
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
        if (operation != null) {
          dst.operation = new ArrayList<MedicinalProductDefinitionOperationComponent>();
          for (MedicinalProductDefinitionOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
        if (characteristic != null) {
          dst.characteristic = new ArrayList<MedicinalProductDefinitionCharacteristicComponent>();
          for (MedicinalProductDefinitionCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
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
           && compareDeep(route, o.route, true) && compareDeep(indication, o.indication, true) && compareDeep(legalStatusOfSupply, o.legalStatusOfSupply, true)
           && compareDeep(additionalMonitoringIndicator, o.additionalMonitoringIndicator, true) && compareDeep(specialMeasures, o.specialMeasures, true)
           && compareDeep(pediatricUseIndicator, o.pediatricUseIndicator, true) && compareDeep(classification, o.classification, true)
           && compareDeep(marketingStatus, o.marketingStatus, true) && compareDeep(packagedMedicinalProduct, o.packagedMedicinalProduct, true)
           && compareDeep(comprisedOf, o.comprisedOf, true) && compareDeep(ingredient, o.ingredient, true)
           && compareDeep(impurity, o.impurity, true) && compareDeep(attachedDocument, o.attachedDocument, true)
           && compareDeep(masterFile, o.masterFile, true) && compareDeep(contact, o.contact, true) && compareDeep(clinicalTrial, o.clinicalTrial, true)
           && compareDeep(code, o.code, true) && compareDeep(name, o.name, true) && compareDeep(crossReference, o.crossReference, true)
           && compareDeep(operation, o.operation, true) && compareDeep(characteristic, o.characteristic, true)
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
          , version, status, statusDate, description, combinedPharmaceuticalDoseForm, route
          , indication, legalStatusOfSupply, additionalMonitoringIndicator, specialMeasures, pediatricUseIndicator
          , classification, marketingStatus, packagedMedicinalProduct, comprisedOf, ingredient
          , impurity, attachedDocument, masterFile, contact, clinicalTrial, code, name, crossReference
          , operation, characteristic);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicinalProductDefinition;
   }

 /**
   * Search parameter: <b>characteristic-type</b>
   * <p>
   * Description: <b>A category for the characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic-type", path="MedicinalProductDefinition.characteristic.type", description="A category for the characteristic", type="token" )
  public static final String SP_CHARACTERISTIC_TYPE = "characteristic-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic-type</b>
   * <p>
   * Description: <b>A category for the characteristic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC_TYPE);

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>Allows the key product features to be recorded, such as "sugar free", "modified release", "parallel import"</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic.value.ofType(Quantity) | MedicinalProductDefinition.characteristic.value.ofType(CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="MedicinalProductDefinition.characteristic.value.ofType(Quantity) | MedicinalProductDefinition.characteristic.value.ofType(CodeableConcept)", description="Allows the key product features to be recorded, such as \"sugar free\", \"modified release\", \"parallel import\"", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>Allows the key product features to be recorded, such as "sugar free", "modified release", "parallel import"</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.characteristic.value.ofType(Quantity) | MedicinalProductDefinition.characteristic.value.ofType(CodeableConcept)</b><br>
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
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>An ingredient of this product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.ingredient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="MedicinalProductDefinition.ingredient", description="An ingredient of this product", type="token" )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>An ingredient of this product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.ingredient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT);

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
   * Path: <b>MedicinalProductDefinition.name.usage.language</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name-language", path="MedicinalProductDefinition.name.usage.language", description="Language code for this name", type="token" )
  public static final String SP_NAME_LANGUAGE = "name-language";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name-language</b>
   * <p>
   * Description: <b>Language code for this name</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.name.usage.language</b><br>
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
   * Path: <b>MedicinalProductDefinition.classification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product-classification", path="MedicinalProductDefinition.classification", description="Allows the product to be classified by various systems", type="token" )
  public static final String SP_PRODUCT_CLASSIFICATION = "product-classification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product-classification</b>
   * <p>
   * Description: <b>Allows the product to be classified by various systems</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.classification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRODUCT_CLASSIFICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRODUCT_CLASSIFICATION);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicinalProductDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MedicinalProductDefinition.status", description="The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this product record. A high-level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization status</b><br>
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

