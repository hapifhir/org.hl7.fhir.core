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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
 * functional description of an inventory item used in inventory and supply-related workflows.
 */
@ResourceDef(name="InventoryItem", profile="http://hl7.org/fhir/StructureDefinition/InventoryItem")
public class InventoryItem extends DomainResource {

    public enum InventoryItemStatusCodes {
        /**
         * The item is active and can be referenced.
         */
        ACTIVE, 
        /**
         * The item is presently inactive - there may be references to it but the item is not expected to be used.
         */
        INACTIVE, 
        /**
         * The item record was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * The item status has not been determined.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static InventoryItemStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown InventoryItemStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/inventoryitem-status";
            case INACTIVE: return "http://hl7.org/fhir/inventoryitem-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/inventoryitem-status";
            case UNKNOWN: return "http://hl7.org/fhir/inventoryitem-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The item is active and can be referenced.";
            case INACTIVE: return "The item is presently inactive - there may be references to it but the item is not expected to be used.";
            case ENTEREDINERROR: return "The item record was entered in error.";
            case UNKNOWN: return "The item status has not been determined.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class InventoryItemStatusCodesEnumFactory implements EnumFactory<InventoryItemStatusCodes> {
    public InventoryItemStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return InventoryItemStatusCodes.ACTIVE;
        if ("inactive".equals(codeString))
          return InventoryItemStatusCodes.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return InventoryItemStatusCodes.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return InventoryItemStatusCodes.UNKNOWN;
        throw new IllegalArgumentException("Unknown InventoryItemStatusCodes code '"+codeString+"'");
        }
        public Enumeration<InventoryItemStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.ACTIVE, code);
        if ("inactive".equals(codeString))
          return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.INACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.ENTEREDINERROR, code);
        if ("unknown".equals(codeString))
          return new Enumeration<InventoryItemStatusCodes>(this, InventoryItemStatusCodes.UNKNOWN, code);
        throw new FHIRException("Unknown InventoryItemStatusCodes code '"+codeString+"'");
        }
    public String toCode(InventoryItemStatusCodes code) {
      if (code == InventoryItemStatusCodes.ACTIVE)
        return "active";
      if (code == InventoryItemStatusCodes.INACTIVE)
        return "inactive";
      if (code == InventoryItemStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == InventoryItemStatusCodes.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(InventoryItemStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class InventoryItemNameComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of name e.g. 'brand-name', 'functional-name', 'common-name'.
         */
        @Child(name = "nameType", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of name e.g. 'brand-name', 'functional-name', 'common-name'", formalDefinition="The type of name e.g. 'brand-name', 'functional-name', 'common-name'." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/inventoryitem-nametype")
        protected Coding nameType;

        /**
         * The language that the item name is expressed in.
         */
        @Child(name = "language", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The language used to express the item name", formalDefinition="The language that the item name is expressed in." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected Enumeration<CommonLanguages> language;

        /**
         * The name or designation that the item is given.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The name or designation of the item", formalDefinition="The name or designation that the item is given." )
        protected StringType name;

        private static final long serialVersionUID = 2074178414L;

    /**
     * Constructor
     */
      public InventoryItemNameComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InventoryItemNameComponent(Coding nameType, CommonLanguages language, String name) {
        super();
        this.setNameType(nameType);
        this.setLanguage(language);
        this.setName(name);
      }

        /**
         * @return {@link #nameType} (The type of name e.g. 'brand-name', 'functional-name', 'common-name'.)
         */
        public Coding getNameType() { 
          if (this.nameType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemNameComponent.nameType");
            else if (Configuration.doAutoCreate())
              this.nameType = new Coding(); // cc
          return this.nameType;
        }

        public boolean hasNameType() { 
          return this.nameType != null && !this.nameType.isEmpty();
        }

        /**
         * @param value {@link #nameType} (The type of name e.g. 'brand-name', 'functional-name', 'common-name'.)
         */
        public InventoryItemNameComponent setNameType(Coding value) { 
          this.nameType = value;
          return this;
        }

        /**
         * @return {@link #language} (The language that the item name is expressed in.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public Enumeration<CommonLanguages> getLanguageElement() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemNameComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory()); // bb
          return this.language;
        }

        public boolean hasLanguageElement() { 
          return this.language != null && !this.language.isEmpty();
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (The language that the item name is expressed in.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public InventoryItemNameComponent setLanguageElement(Enumeration<CommonLanguages> value) { 
          this.language = value;
          return this;
        }

        /**
         * @return The language that the item name is expressed in.
         */
        public CommonLanguages getLanguage() { 
          return this.language == null ? null : this.language.getValue();
        }

        /**
         * @param value The language that the item name is expressed in.
         */
        public InventoryItemNameComponent setLanguage(CommonLanguages value) { 
            if (this.language == null)
              this.language = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory());
            this.language.setValue(value);
          return this;
        }

        /**
         * @return {@link #name} (The name or designation that the item is given.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemNameComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (The name or designation that the item is given.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public InventoryItemNameComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name or designation that the item is given.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name or designation that the item is given.
         */
        public InventoryItemNameComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("nameType", "Coding", "The type of name e.g. 'brand-name', 'functional-name', 'common-name'.", 0, 1, nameType));
          children.add(new Property("language", "code", "The language that the item name is expressed in.", 0, 1, language));
          children.add(new Property("name", "string", "The name or designation that the item is given.", 0, 1, name));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1840595045: /*nameType*/  return new Property("nameType", "Coding", "The type of name e.g. 'brand-name', 'functional-name', 'common-name'.", 0, 1, nameType);
          case -1613589672: /*language*/  return new Property("language", "code", "The language that the item name is expressed in.", 0, 1, language);
          case 3373707: /*name*/  return new Property("name", "string", "The name or designation that the item is given.", 0, 1, name);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1840595045: /*nameType*/ return this.nameType == null ? new Base[0] : new Base[] {this.nameType}; // Coding
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // Enumeration<CommonLanguages>
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1840595045: // nameType
          this.nameType = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -1613589672: // language
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.language = (Enumeration) value; // Enumeration<CommonLanguages>
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("nameType")) {
          this.nameType = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("language")) {
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.language = (Enumeration) value; // Enumeration<CommonLanguages>
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1840595045:  return getNameType();
        case -1613589672:  return getLanguageElement();
        case 3373707:  return getNameElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1840595045: /*nameType*/ return new String[] {"Coding"};
        case -1613589672: /*language*/ return new String[] {"code"};
        case 3373707: /*name*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("nameType")) {
          this.nameType = new Coding();
          return this.nameType;
        }
        else if (name.equals("language")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.name.language");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.name.name");
        }
        else
          return super.addChild(name);
      }

      public InventoryItemNameComponent copy() {
        InventoryItemNameComponent dst = new InventoryItemNameComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemNameComponent dst) {
        super.copyValues(dst);
        dst.nameType = nameType == null ? null : nameType.copy();
        dst.language = language == null ? null : language.copy();
        dst.name = name == null ? null : name.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemNameComponent))
          return false;
        InventoryItemNameComponent o = (InventoryItemNameComponent) other_;
        return compareDeep(nameType, o.nameType, true) && compareDeep(language, o.language, true) && compareDeep(name, o.name, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemNameComponent))
          return false;
        InventoryItemNameComponent o = (InventoryItemNameComponent) other_;
        return compareValues(language, o.language, true) && compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(nameType, language, name
          );
      }

  public String fhirType() {
    return "InventoryItem.name";

  }

  }

    @Block()
    public static class InventoryItemResponsibleOrganizationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The role of the organization e.g. manufacturer, distributor, etc.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The role of the organization e.g. manufacturer, distributor, or other", formalDefinition="The role of the organization e.g. manufacturer, distributor, etc." )
        protected CodeableConcept role;

        /**
         * An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc.
         */
        @Child(name = "organization", type = {Organization.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An organization that is associated with the item", formalDefinition="An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc." )
        protected Reference organization;

        private static final long serialVersionUID = -575091539L;

    /**
     * Constructor
     */
      public InventoryItemResponsibleOrganizationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InventoryItemResponsibleOrganizationComponent(CodeableConcept role, Reference organization) {
        super();
        this.setRole(role);
        this.setOrganization(organization);
      }

        /**
         * @return {@link #role} (The role of the organization e.g. manufacturer, distributor, etc.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemResponsibleOrganizationComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The role of the organization e.g. manufacturer, distributor, etc.)
         */
        public InventoryItemResponsibleOrganizationComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #organization} (An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc.)
         */
        public Reference getOrganization() { 
          if (this.organization == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemResponsibleOrganizationComponent.organization");
            else if (Configuration.doAutoCreate())
              this.organization = new Reference(); // cc
          return this.organization;
        }

        public boolean hasOrganization() { 
          return this.organization != null && !this.organization.isEmpty();
        }

        /**
         * @param value {@link #organization} (An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc.)
         */
        public InventoryItemResponsibleOrganizationComponent setOrganization(Reference value) { 
          this.organization = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "The role of the organization e.g. manufacturer, distributor, etc.", 0, 1, role));
          children.add(new Property("organization", "Reference(Organization)", "An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc.", 0, 1, organization));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role of the organization e.g. manufacturer, distributor, etc.", 0, 1, role);
          case 1178922291: /*organization*/  return new Property("organization", "Reference(Organization)", "An organization that has an association with the item, e.g. manufacturer, distributor, responsible, etc.", 0, 1, organization);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 1178922291: /*organization*/ return this.organization == null ? new Base[0] : new Base[] {this.organization}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1178922291: // organization
          this.organization = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("organization")) {
          this.organization = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case 1178922291:  return getOrganization();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 1178922291: /*organization*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("organization")) {
          this.organization = new Reference();
          return this.organization;
        }
        else
          return super.addChild(name);
      }

      public InventoryItemResponsibleOrganizationComponent copy() {
        InventoryItemResponsibleOrganizationComponent dst = new InventoryItemResponsibleOrganizationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemResponsibleOrganizationComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.organization = organization == null ? null : organization.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemResponsibleOrganizationComponent))
          return false;
        InventoryItemResponsibleOrganizationComponent o = (InventoryItemResponsibleOrganizationComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(organization, o.organization, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemResponsibleOrganizationComponent))
          return false;
        InventoryItemResponsibleOrganizationComponent o = (InventoryItemResponsibleOrganizationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, organization);
      }

  public String fhirType() {
    return "InventoryItem.responsibleOrganization";

  }

  }

    @Block()
    public static class InventoryItemDescriptionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.
         */
        @Child(name = "language", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The language that is used in the item description", formalDefinition="The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected Enumeration<CommonLanguages> language;

        /**
         * Textual description of the item.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of the item", formalDefinition="Textual description of the item." )
        protected StringType description;

        private static final long serialVersionUID = -803271414L;

    /**
     * Constructor
     */
      public InventoryItemDescriptionComponent() {
        super();
      }

        /**
         * @return {@link #language} (The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public Enumeration<CommonLanguages> getLanguageElement() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemDescriptionComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory()); // bb
          return this.language;
        }

        public boolean hasLanguageElement() { 
          return this.language != null && !this.language.isEmpty();
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public InventoryItemDescriptionComponent setLanguageElement(Enumeration<CommonLanguages> value) { 
          this.language = value;
          return this;
        }

        /**
         * @return The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.
         */
        public CommonLanguages getLanguage() { 
          return this.language == null ? null : this.language.getValue();
        }

        /**
         * @param value The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.
         */
        public InventoryItemDescriptionComponent setLanguage(CommonLanguages value) { 
          if (value == null)
            this.language = null;
          else {
            if (this.language == null)
              this.language = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory());
            this.language.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #description} (Textual description of the item.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemDescriptionComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (Textual description of the item.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public InventoryItemDescriptionComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Textual description of the item.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Textual description of the item.
         */
        public InventoryItemDescriptionComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("language", "code", "The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.", 0, 1, language));
          children.add(new Property("description", "string", "Textual description of the item.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1613589672: /*language*/  return new Property("language", "code", "The language for the item description, when an item must be described in different languages and those languages may be authoritative and not translations of a 'main' language.", 0, 1, language);
          case -1724546052: /*description*/  return new Property("description", "string", "Textual description of the item.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // Enumeration<CommonLanguages>
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.language = (Enumeration) value; // Enumeration<CommonLanguages>
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.language = (Enumeration) value; // Enumeration<CommonLanguages>
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguageElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"code"};
        case -1724546052: /*description*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.description.language");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.description.description");
        }
        else
          return super.addChild(name);
      }

      public InventoryItemDescriptionComponent copy() {
        InventoryItemDescriptionComponent dst = new InventoryItemDescriptionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemDescriptionComponent dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemDescriptionComponent))
          return false;
        InventoryItemDescriptionComponent o = (InventoryItemDescriptionComponent) other_;
        return compareDeep(language, o.language, true) && compareDeep(description, o.description, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemDescriptionComponent))
          return false;
        InventoryItemDescriptionComponent o = (InventoryItemDescriptionComponent) other_;
        return compareValues(language, o.language, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, description);
      }

  public String fhirType() {
    return "InventoryItem.description";

  }

  }

    @Block()
    public static class InventoryItemAssociationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.
         */
        @Child(name = "associationType", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of association between the device and the other item", formalDefinition="This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with." )
        protected CodeableConcept associationType;

        /**
         * The related item or product.
         */
        @Child(name = "relatedItem", type = {InventoryItem.class, Medication.class, MedicationKnowledge.class, Device.class, DeviceDefinition.class, NutritionProduct.class, BiologicallyDerivedProduct.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The related item or product", formalDefinition="The related item or product." )
        protected Reference relatedItem;

        /**
         * The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product.
         */
        @Child(name = "quantity", type = {Ratio.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of the product in this product", formalDefinition="The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product." )
        protected Ratio quantity;

        private static final long serialVersionUID = -1001386921L;

    /**
     * Constructor
     */
      public InventoryItemAssociationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InventoryItemAssociationComponent(CodeableConcept associationType, Reference relatedItem, Ratio quantity) {
        super();
        this.setAssociationType(associationType);
        this.setRelatedItem(relatedItem);
        this.setQuantity(quantity);
      }

        /**
         * @return {@link #associationType} (This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.)
         */
        public CodeableConcept getAssociationType() { 
          if (this.associationType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemAssociationComponent.associationType");
            else if (Configuration.doAutoCreate())
              this.associationType = new CodeableConcept(); // cc
          return this.associationType;
        }

        public boolean hasAssociationType() { 
          return this.associationType != null && !this.associationType.isEmpty();
        }

        /**
         * @param value {@link #associationType} (This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.)
         */
        public InventoryItemAssociationComponent setAssociationType(CodeableConcept value) { 
          this.associationType = value;
          return this;
        }

        /**
         * @return {@link #relatedItem} (The related item or product.)
         */
        public Reference getRelatedItem() { 
          if (this.relatedItem == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemAssociationComponent.relatedItem");
            else if (Configuration.doAutoCreate())
              this.relatedItem = new Reference(); // cc
          return this.relatedItem;
        }

        public boolean hasRelatedItem() { 
          return this.relatedItem != null && !this.relatedItem.isEmpty();
        }

        /**
         * @param value {@link #relatedItem} (The related item or product.)
         */
        public InventoryItemAssociationComponent setRelatedItem(Reference value) { 
          this.relatedItem = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product.)
         */
        public Ratio getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemAssociationComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Ratio(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product.)
         */
        public InventoryItemAssociationComponent setQuantity(Ratio value) { 
          this.quantity = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("associationType", "CodeableConcept", "This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.", 0, 1, associationType));
          children.add(new Property("relatedItem", "Reference(InventoryItem|Medication|MedicationKnowledge|Device|DeviceDefinition|NutritionProduct|BiologicallyDerivedProduct)", "The related item or product.", 0, 1, relatedItem));
          children.add(new Property("quantity", "Ratio", "The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product.", 0, 1, quantity));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2050799451: /*associationType*/  return new Property("associationType", "CodeableConcept", "This attribute defined the type of association when establishing associations or relations between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.", 0, 1, associationType);
          case 1112702430: /*relatedItem*/  return new Property("relatedItem", "Reference(InventoryItem|Medication|MedicationKnowledge|Device|DeviceDefinition|NutritionProduct|BiologicallyDerivedProduct)", "The related item or product.", 0, 1, relatedItem);
          case -1285004149: /*quantity*/  return new Property("quantity", "Ratio", "The quantity of the related product in this product - Numerator is the quantity of the related product. Denominator is the quantity of the present product. For example a value of 20 means that this product contains 20 units of the related product; a value of 1:20 means the inverse - that the contained product contains 20 units of the present product.", 0, 1, quantity);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 2050799451: /*associationType*/ return this.associationType == null ? new Base[0] : new Base[] {this.associationType}; // CodeableConcept
        case 1112702430: /*relatedItem*/ return this.relatedItem == null ? new Base[0] : new Base[] {this.relatedItem}; // Reference
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Ratio
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 2050799451: // associationType
          this.associationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1112702430: // relatedItem
          this.relatedItem = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToRatio(value); // Ratio
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("associationType")) {
          this.associationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("relatedItem")) {
          this.relatedItem = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToRatio(value); // Ratio
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2050799451:  return getAssociationType();
        case 1112702430:  return getRelatedItem();
        case -1285004149:  return getQuantity();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2050799451: /*associationType*/ return new String[] {"CodeableConcept"};
        case 1112702430: /*relatedItem*/ return new String[] {"Reference"};
        case -1285004149: /*quantity*/ return new String[] {"Ratio"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("associationType")) {
          this.associationType = new CodeableConcept();
          return this.associationType;
        }
        else if (name.equals("relatedItem")) {
          this.relatedItem = new Reference();
          return this.relatedItem;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Ratio();
          return this.quantity;
        }
        else
          return super.addChild(name);
      }

      public InventoryItemAssociationComponent copy() {
        InventoryItemAssociationComponent dst = new InventoryItemAssociationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemAssociationComponent dst) {
        super.copyValues(dst);
        dst.associationType = associationType == null ? null : associationType.copy();
        dst.relatedItem = relatedItem == null ? null : relatedItem.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemAssociationComponent))
          return false;
        InventoryItemAssociationComponent o = (InventoryItemAssociationComponent) other_;
        return compareDeep(associationType, o.associationType, true) && compareDeep(relatedItem, o.relatedItem, true)
           && compareDeep(quantity, o.quantity, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemAssociationComponent))
          return false;
        InventoryItemAssociationComponent o = (InventoryItemAssociationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(associationType, relatedItem
          , quantity);
      }

  public String fhirType() {
    return "InventoryItem.association";

  }

  }

    @Block()
    public static class InventoryItemCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of characteristic that is being defined.
         */
        @Child(name = "characteristicType", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The characteristic that is being defined", formalDefinition="The type of characteristic that is being defined." )
        protected CodeableConcept characteristicType;

        /**
         * The value of the attribute.
         */
        @Child(name = "value", type = {StringType.class, IntegerType.class, DecimalType.class, BooleanType.class, UrlType.class, DateTimeType.class, Quantity.class, Range.class, Ratio.class, Annotation.class, Address.class, Duration.class, CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The value of the attribute", formalDefinition="The value of the attribute." )
        protected DataType value;

        private static final long serialVersionUID = -642436065L;

    /**
     * Constructor
     */
      public InventoryItemCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InventoryItemCharacteristicComponent(CodeableConcept characteristicType, DataType value) {
        super();
        this.setCharacteristicType(characteristicType);
        this.setValue(value);
      }

        /**
         * @return {@link #characteristicType} (The type of characteristic that is being defined.)
         */
        public CodeableConcept getCharacteristicType() { 
          if (this.characteristicType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemCharacteristicComponent.characteristicType");
            else if (Configuration.doAutoCreate())
              this.characteristicType = new CodeableConcept(); // cc
          return this.characteristicType;
        }

        public boolean hasCharacteristicType() { 
          return this.characteristicType != null && !this.characteristicType.isEmpty();
        }

        /**
         * @param value {@link #characteristicType} (The type of characteristic that is being defined.)
         */
        public InventoryItemCharacteristicComponent setCharacteristicType(CodeableConcept value) { 
          this.characteristicType = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
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
         * @return {@link #value} (The value of the attribute.)
         */
        public DecimalType getValueDecimalType() throws FHIRException { 
          if (this.value == null)
            this.value = new DecimalType();
          if (!(this.value instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DecimalType) this.value;
        }

        public boolean hasValueDecimalType() { 
          return this != null && this.value instanceof DecimalType;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
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
         * @return {@link #value} (The value of the attribute.)
         */
        public UrlType getValueUrlType() throws FHIRException { 
          if (this.value == null)
            this.value = new UrlType();
          if (!(this.value instanceof UrlType))
            throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UrlType) this.value;
        }

        public boolean hasValueUrlType() { 
          return this != null && this.value instanceof UrlType;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() { 
          return this != null && this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
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
         * @return {@link #value} (The value of the attribute.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public Ratio getValueRatio() throws FHIRException { 
          if (this.value == null)
            this.value = new Ratio();
          if (!(this.value instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Ratio) this.value;
        }

        public boolean hasValueRatio() { 
          return this != null && this.value instanceof Ratio;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public Annotation getValueAnnotation() throws FHIRException { 
          if (this.value == null)
            this.value = new Annotation();
          if (!(this.value instanceof Annotation))
            throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Annotation) this.value;
        }

        public boolean hasValueAnnotation() { 
          return this != null && this.value instanceof Annotation;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public Address getValueAddress() throws FHIRException { 
          if (this.value == null)
            this.value = new Address();
          if (!(this.value instanceof Address))
            throw new FHIRException("Type mismatch: the type Address was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Address) this.value;
        }

        public boolean hasValueAddress() { 
          return this != null && this.value instanceof Address;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
         */
        public Duration getValueDuration() throws FHIRException { 
          if (this.value == null)
            this.value = new Duration();
          if (!(this.value instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Duration) this.value;
        }

        public boolean hasValueDuration() { 
          return this != null && this.value instanceof Duration;
        }

        /**
         * @return {@link #value} (The value of the attribute.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the attribute.)
         */
        public InventoryItemCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof IntegerType || value instanceof DecimalType || value instanceof BooleanType || value instanceof UrlType || value instanceof DateTimeType || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Annotation || value instanceof Address || value instanceof Duration || value instanceof CodeableConcept))
            throw new Error("Not the right type for InventoryItem.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("characteristicType", "CodeableConcept", "The type of characteristic that is being defined.", 0, 1, characteristicType));
          children.add(new Property("value[x]", "string|integer|decimal|boolean|url|dateTime|Quantity|Range|Ratio|Annotation|Address|Duration|CodeableConcept", "The value of the attribute.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1172127605: /*characteristicType*/  return new Property("characteristicType", "CodeableConcept", "The type of characteristic that is being defined.", 0, 1, characteristicType);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "string|integer|decimal|boolean|url|dateTime|Quantity|Range|Ratio|Annotation|Address|Duration|CodeableConcept", "The value of the attribute.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "string|integer|decimal|boolean|url|dateTime|Quantity|Range|Ratio|Annotation|Address|Duration|CodeableConcept", "The value of the attribute.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The value of the attribute.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The value of the attribute.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The value of the attribute.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the attribute.", 0, 1, value);
          case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "The value of the attribute.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the attribute.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the attribute.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the attribute.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The value of the attribute.", 0, 1, value);
          case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "The value of the attribute.", 0, 1, value);
          case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "The value of the attribute.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The value of the attribute.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the attribute.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1172127605: /*characteristicType*/ return this.characteristicType == null ? new Base[0] : new Base[] {this.characteristicType}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1172127605: // characteristicType
          this.characteristicType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("characteristicType")) {
          this.characteristicType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1172127605:  return getCharacteristicType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1172127605: /*characteristicType*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"string", "integer", "decimal", "boolean", "url", "dateTime", "Quantity", "Range", "Ratio", "Annotation", "Address", "Duration", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("characteristicType")) {
          this.characteristicType = new CodeableConcept();
          return this.characteristicType;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueUrl")) {
          this.value = new UrlType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueAnnotation")) {
          this.value = new Annotation();
          return this.value;
        }
        else if (name.equals("valueAddress")) {
          this.value = new Address();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public InventoryItemCharacteristicComponent copy() {
        InventoryItemCharacteristicComponent dst = new InventoryItemCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.characteristicType = characteristicType == null ? null : characteristicType.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemCharacteristicComponent))
          return false;
        InventoryItemCharacteristicComponent o = (InventoryItemCharacteristicComponent) other_;
        return compareDeep(characteristicType, o.characteristicType, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemCharacteristicComponent))
          return false;
        InventoryItemCharacteristicComponent o = (InventoryItemCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(characteristicType, value
          );
      }

  public String fhirType() {
    return "InventoryItem.characteristic";

  }

  }

    @Block()
    public static class InventoryItemInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The identifier for the physical instance, typically a serial number.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The identifier for the physical instance, typically a serial number", formalDefinition="The identifier for the physical instance, typically a serial number." )
        protected List<Identifier> identifier;

        /**
         * The lot or batch number of the item.
         */
        @Child(name = "lotNumber", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The lot or batch number of the item", formalDefinition="The lot or batch number of the item." )
        protected StringType lotNumber;

        /**
         * The expiry date or date and time for the product.
         */
        @Child(name = "expiry", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The expiry date or date and time for the product", formalDefinition="The expiry date or date and time for the product." )
        protected DateTimeType expiry;

        /**
         * The subject that the item is associated with.
         */
        @Child(name = "subject", type = {Patient.class, Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The subject that the item is associated with", formalDefinition="The subject that the item is associated with." )
        protected Reference subject;

        /**
         * The location that the item is associated with.
         */
        @Child(name = "location", type = {Location.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The location that the item is associated with", formalDefinition="The location that the item is associated with." )
        protected Reference location;

        private static final long serialVersionUID = 657936980L;

    /**
     * Constructor
     */
      public InventoryItemInstanceComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (The identifier for the physical instance, typically a serial number.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public InventoryItemInstanceComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public InventoryItemInstanceComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #lotNumber} (The lot or batch number of the item.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
         */
        public StringType getLotNumberElement() { 
          if (this.lotNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemInstanceComponent.lotNumber");
            else if (Configuration.doAutoCreate())
              this.lotNumber = new StringType(); // bb
          return this.lotNumber;
        }

        public boolean hasLotNumberElement() { 
          return this.lotNumber != null && !this.lotNumber.isEmpty();
        }

        public boolean hasLotNumber() { 
          return this.lotNumber != null && !this.lotNumber.isEmpty();
        }

        /**
         * @param value {@link #lotNumber} (The lot or batch number of the item.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
         */
        public InventoryItemInstanceComponent setLotNumberElement(StringType value) { 
          this.lotNumber = value;
          return this;
        }

        /**
         * @return The lot or batch number of the item.
         */
        public String getLotNumber() { 
          return this.lotNumber == null ? null : this.lotNumber.getValue();
        }

        /**
         * @param value The lot or batch number of the item.
         */
        public InventoryItemInstanceComponent setLotNumber(String value) { 
          if (Utilities.noString(value))
            this.lotNumber = null;
          else {
            if (this.lotNumber == null)
              this.lotNumber = new StringType();
            this.lotNumber.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #expiry} (The expiry date or date and time for the product.). This is the underlying object with id, value and extensions. The accessor "getExpiry" gives direct access to the value
         */
        public DateTimeType getExpiryElement() { 
          if (this.expiry == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemInstanceComponent.expiry");
            else if (Configuration.doAutoCreate())
              this.expiry = new DateTimeType(); // bb
          return this.expiry;
        }

        public boolean hasExpiryElement() { 
          return this.expiry != null && !this.expiry.isEmpty();
        }

        public boolean hasExpiry() { 
          return this.expiry != null && !this.expiry.isEmpty();
        }

        /**
         * @param value {@link #expiry} (The expiry date or date and time for the product.). This is the underlying object with id, value and extensions. The accessor "getExpiry" gives direct access to the value
         */
        public InventoryItemInstanceComponent setExpiryElement(DateTimeType value) { 
          this.expiry = value;
          return this;
        }

        /**
         * @return The expiry date or date and time for the product.
         */
        public Date getExpiry() { 
          return this.expiry == null ? null : this.expiry.getValue();
        }

        /**
         * @param value The expiry date or date and time for the product.
         */
        public InventoryItemInstanceComponent setExpiry(Date value) { 
          if (value == null)
            this.expiry = null;
          else {
            if (this.expiry == null)
              this.expiry = new DateTimeType();
            this.expiry.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #subject} (The subject that the item is associated with.)
         */
        public Reference getSubject() { 
          if (this.subject == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemInstanceComponent.subject");
            else if (Configuration.doAutoCreate())
              this.subject = new Reference(); // cc
          return this.subject;
        }

        public boolean hasSubject() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        /**
         * @param value {@link #subject} (The subject that the item is associated with.)
         */
        public InventoryItemInstanceComponent setSubject(Reference value) { 
          this.subject = value;
          return this;
        }

        /**
         * @return {@link #location} (The location that the item is associated with.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryItemInstanceComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (The location that the item is associated with.)
         */
        public InventoryItemInstanceComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "The identifier for the physical instance, typically a serial number.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("lotNumber", "string", "The lot or batch number of the item.", 0, 1, lotNumber));
          children.add(new Property("expiry", "dateTime", "The expiry date or date and time for the product.", 0, 1, expiry));
          children.add(new Property("subject", "Reference(Patient|Organization)", "The subject that the item is associated with.", 0, 1, subject));
          children.add(new Property("location", "Reference(Location)", "The location that the item is associated with.", 0, 1, location));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The identifier for the physical instance, typically a serial number.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 462547450: /*lotNumber*/  return new Property("lotNumber", "string", "The lot or batch number of the item.", 0, 1, lotNumber);
          case -1289159373: /*expiry*/  return new Property("expiry", "dateTime", "The expiry date or date and time for the product.", 0, 1, expiry);
          case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Organization)", "The subject that the item is associated with.", 0, 1, subject);
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location that the item is associated with.", 0, 1, location);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 462547450: /*lotNumber*/ return this.lotNumber == null ? new Base[0] : new Base[] {this.lotNumber}; // StringType
        case -1289159373: /*expiry*/ return this.expiry == null ? new Base[0] : new Base[] {this.expiry}; // DateTimeType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 462547450: // lotNumber
          this.lotNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -1289159373: // expiry
          this.expiry = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("lotNumber")) {
          this.lotNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expiry")) {
          this.expiry = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 462547450:  return getLotNumberElement();
        case -1289159373:  return getExpiryElement();
        case -1867885268:  return getSubject();
        case 1901043637:  return getLocation();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 462547450: /*lotNumber*/ return new String[] {"string"};
        case -1289159373: /*expiry*/ return new String[] {"dateTime"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("lotNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.instance.lotNumber");
        }
        else if (name.equals("expiry")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.instance.expiry");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else
          return super.addChild(name);
      }

      public InventoryItemInstanceComponent copy() {
        InventoryItemInstanceComponent dst = new InventoryItemInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItemInstanceComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.lotNumber = lotNumber == null ? null : lotNumber.copy();
        dst.expiry = expiry == null ? null : expiry.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.location = location == null ? null : location.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItemInstanceComponent))
          return false;
        InventoryItemInstanceComponent o = (InventoryItemInstanceComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(lotNumber, o.lotNumber, true)
           && compareDeep(expiry, o.expiry, true) && compareDeep(subject, o.subject, true) && compareDeep(location, o.location, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItemInstanceComponent))
          return false;
        InventoryItemInstanceComponent o = (InventoryItemInstanceComponent) other_;
        return compareValues(lotNumber, o.lotNumber, true) && compareValues(expiry, o.expiry, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, lotNumber, expiry
          , subject, location);
      }

  public String fhirType() {
    return "InventoryItem.instance";

  }

  }

    /**
     * Business identifier for the inventory item.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for the inventory item", formalDefinition="Business identifier for the inventory item." )
    protected List<Identifier> identifier;

    /**
     * Status of the item entry.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error | unknown", formalDefinition="Status of the item entry." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/inventoryitem-status")
    protected Enumeration<InventoryItemStatusCodes> status;

    /**
     * Category or class of the item.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Category or class of the item", formalDefinition="Category or class of the item." )
    protected List<CodeableConcept> category;

    /**
     * Code designating the specific type of item.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Code designating the specific type of item", formalDefinition="Code designating the specific type of item." )
    protected List<CodeableConcept> code;

    /**
     * The item name(s) - the brand name, or common name, functional name, generic name.
     */
    @Child(name = "name", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The item name(s) - the brand name, or common name, functional name, generic name or others", formalDefinition="The item name(s) - the brand name, or common name, functional name, generic name." )
    protected List<InventoryItemNameComponent> name;

    /**
     * Organization(s) responsible for the product.
     */
    @Child(name = "responsibleOrganization", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Organization(s) responsible for the product", formalDefinition="Organization(s) responsible for the product." )
    protected List<InventoryItemResponsibleOrganizationComponent> responsibleOrganization;

    /**
     * The descriptive characteristics of the inventory item.
     */
    @Child(name = "description", type = {}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Descriptive characteristics of the item", formalDefinition="The descriptive characteristics of the inventory item." )
    protected InventoryItemDescriptionComponent description;

    /**
     * The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.
     */
    @Child(name = "inventoryStatus", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The usage status like recalled, in use, discarded", formalDefinition="The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc." )
    protected List<CodeableConcept> inventoryStatus;

    /**
     * The base unit of measure - the unit in which the product is used or counted.
     */
    @Child(name = "baseUnit", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The base unit of measure - the unit in which the product is used or counted", formalDefinition="The base unit of measure - the unit in which the product is used or counted." )
    protected CodeableConcept baseUnit;

    /**
     * Net content or amount present in the item.
     */
    @Child(name = "netContent", type = {Quantity.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Net content or amount present in the item", formalDefinition="Net content or amount present in the item." )
    protected Quantity netContent;

    /**
     * Association with other items or products.
     */
    @Child(name = "association", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Association with other items or products", formalDefinition="Association with other items or products." )
    protected List<InventoryItemAssociationComponent> association;

    /**
     * The descriptive or identifying characteristics of the item.
     */
    @Child(name = "characteristic", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Characteristic of the item", formalDefinition="The descriptive or identifying characteristics of the item." )
    protected List<InventoryItemCharacteristicComponent> characteristic;

    /**
     * Instances or occurrences of the product.
     */
    @Child(name = "instance", type = {}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Instances or occurrences of the product", formalDefinition="Instances or occurrences of the product." )
    protected InventoryItemInstanceComponent instance;

    /**
     * Link to a product resource used in clinical workflows.
     */
    @Child(name = "productReference", type = {Medication.class, Device.class, NutritionProduct.class, BiologicallyDerivedProduct.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Link to a product resource used in clinical workflows", formalDefinition="Link to a product resource used in clinical workflows." )
    protected Reference productReference;

    private static final long serialVersionUID = 2127201564L;

  /**
   * Constructor
   */
    public InventoryItem() {
      super();
    }

  /**
   * Constructor
   */
    public InventoryItem(InventoryItemStatusCodes status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Business identifier for the inventory item.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setIdentifier(List<Identifier> theIdentifier) { 
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

    public InventoryItem addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Status of the item entry.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<InventoryItemStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<InventoryItemStatusCodes>(new InventoryItemStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Status of the item entry.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public InventoryItem setStatusElement(Enumeration<InventoryItemStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Status of the item entry.
     */
    public InventoryItemStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Status of the item entry.
     */
    public InventoryItem setStatus(InventoryItemStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<InventoryItemStatusCodes>(new InventoryItemStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (Category or class of the item.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setCategory(List<CodeableConcept> theCategory) { 
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

    public InventoryItem addCategory(CodeableConcept t) { //3
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
     * @return {@link #code} (Code designating the specific type of item.)
     */
    public List<CodeableConcept> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<CodeableConcept>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setCode(List<CodeableConcept> theCode) { 
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

    public InventoryItem addCode(CodeableConcept t) { //3
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
     * @return {@link #name} (The item name(s) - the brand name, or common name, functional name, generic name.)
     */
    public List<InventoryItemNameComponent> getName() { 
      if (this.name == null)
        this.name = new ArrayList<InventoryItemNameComponent>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setName(List<InventoryItemNameComponent> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (InventoryItemNameComponent item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InventoryItemNameComponent addName() { //3
      InventoryItemNameComponent t = new InventoryItemNameComponent();
      if (this.name == null)
        this.name = new ArrayList<InventoryItemNameComponent>();
      this.name.add(t);
      return t;
    }

    public InventoryItem addName(InventoryItemNameComponent t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<InventoryItemNameComponent>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public InventoryItemNameComponent getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #responsibleOrganization} (Organization(s) responsible for the product.)
     */
    public List<InventoryItemResponsibleOrganizationComponent> getResponsibleOrganization() { 
      if (this.responsibleOrganization == null)
        this.responsibleOrganization = new ArrayList<InventoryItemResponsibleOrganizationComponent>();
      return this.responsibleOrganization;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setResponsibleOrganization(List<InventoryItemResponsibleOrganizationComponent> theResponsibleOrganization) { 
      this.responsibleOrganization = theResponsibleOrganization;
      return this;
    }

    public boolean hasResponsibleOrganization() { 
      if (this.responsibleOrganization == null)
        return false;
      for (InventoryItemResponsibleOrganizationComponent item : this.responsibleOrganization)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InventoryItemResponsibleOrganizationComponent addResponsibleOrganization() { //3
      InventoryItemResponsibleOrganizationComponent t = new InventoryItemResponsibleOrganizationComponent();
      if (this.responsibleOrganization == null)
        this.responsibleOrganization = new ArrayList<InventoryItemResponsibleOrganizationComponent>();
      this.responsibleOrganization.add(t);
      return t;
    }

    public InventoryItem addResponsibleOrganization(InventoryItemResponsibleOrganizationComponent t) { //3
      if (t == null)
        return this;
      if (this.responsibleOrganization == null)
        this.responsibleOrganization = new ArrayList<InventoryItemResponsibleOrganizationComponent>();
      this.responsibleOrganization.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #responsibleOrganization}, creating it if it does not already exist {3}
     */
    public InventoryItemResponsibleOrganizationComponent getResponsibleOrganizationFirstRep() { 
      if (getResponsibleOrganization().isEmpty()) {
        addResponsibleOrganization();
      }
      return getResponsibleOrganization().get(0);
    }

    /**
     * @return {@link #description} (The descriptive characteristics of the inventory item.)
     */
    public InventoryItemDescriptionComponent getDescription() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.description");
        else if (Configuration.doAutoCreate())
          this.description = new InventoryItemDescriptionComponent(); // cc
      return this.description;
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The descriptive characteristics of the inventory item.)
     */
    public InventoryItem setDescription(InventoryItemDescriptionComponent value) { 
      this.description = value;
      return this;
    }

    /**
     * @return {@link #inventoryStatus} (The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.)
     */
    public List<CodeableConcept> getInventoryStatus() { 
      if (this.inventoryStatus == null)
        this.inventoryStatus = new ArrayList<CodeableConcept>();
      return this.inventoryStatus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setInventoryStatus(List<CodeableConcept> theInventoryStatus) { 
      this.inventoryStatus = theInventoryStatus;
      return this;
    }

    public boolean hasInventoryStatus() { 
      if (this.inventoryStatus == null)
        return false;
      for (CodeableConcept item : this.inventoryStatus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addInventoryStatus() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.inventoryStatus == null)
        this.inventoryStatus = new ArrayList<CodeableConcept>();
      this.inventoryStatus.add(t);
      return t;
    }

    public InventoryItem addInventoryStatus(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.inventoryStatus == null)
        this.inventoryStatus = new ArrayList<CodeableConcept>();
      this.inventoryStatus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #inventoryStatus}, creating it if it does not already exist {3}
     */
    public CodeableConcept getInventoryStatusFirstRep() { 
      if (getInventoryStatus().isEmpty()) {
        addInventoryStatus();
      }
      return getInventoryStatus().get(0);
    }

    /**
     * @return {@link #baseUnit} (The base unit of measure - the unit in which the product is used or counted.)
     */
    public CodeableConcept getBaseUnit() { 
      if (this.baseUnit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.baseUnit");
        else if (Configuration.doAutoCreate())
          this.baseUnit = new CodeableConcept(); // cc
      return this.baseUnit;
    }

    public boolean hasBaseUnit() { 
      return this.baseUnit != null && !this.baseUnit.isEmpty();
    }

    /**
     * @param value {@link #baseUnit} (The base unit of measure - the unit in which the product is used or counted.)
     */
    public InventoryItem setBaseUnit(CodeableConcept value) { 
      this.baseUnit = value;
      return this;
    }

    /**
     * @return {@link #netContent} (Net content or amount present in the item.)
     */
    public Quantity getNetContent() { 
      if (this.netContent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.netContent");
        else if (Configuration.doAutoCreate())
          this.netContent = new Quantity(); // cc
      return this.netContent;
    }

    public boolean hasNetContent() { 
      return this.netContent != null && !this.netContent.isEmpty();
    }

    /**
     * @param value {@link #netContent} (Net content or amount present in the item.)
     */
    public InventoryItem setNetContent(Quantity value) { 
      this.netContent = value;
      return this;
    }

    /**
     * @return {@link #association} (Association with other items or products.)
     */
    public List<InventoryItemAssociationComponent> getAssociation() { 
      if (this.association == null)
        this.association = new ArrayList<InventoryItemAssociationComponent>();
      return this.association;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setAssociation(List<InventoryItemAssociationComponent> theAssociation) { 
      this.association = theAssociation;
      return this;
    }

    public boolean hasAssociation() { 
      if (this.association == null)
        return false;
      for (InventoryItemAssociationComponent item : this.association)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InventoryItemAssociationComponent addAssociation() { //3
      InventoryItemAssociationComponent t = new InventoryItemAssociationComponent();
      if (this.association == null)
        this.association = new ArrayList<InventoryItemAssociationComponent>();
      this.association.add(t);
      return t;
    }

    public InventoryItem addAssociation(InventoryItemAssociationComponent t) { //3
      if (t == null)
        return this;
      if (this.association == null)
        this.association = new ArrayList<InventoryItemAssociationComponent>();
      this.association.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #association}, creating it if it does not already exist {3}
     */
    public InventoryItemAssociationComponent getAssociationFirstRep() { 
      if (getAssociation().isEmpty()) {
        addAssociation();
      }
      return getAssociation().get(0);
    }

    /**
     * @return {@link #characteristic} (The descriptive or identifying characteristics of the item.)
     */
    public List<InventoryItemCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<InventoryItemCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryItem setCharacteristic(List<InventoryItemCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (InventoryItemCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InventoryItemCharacteristicComponent addCharacteristic() { //3
      InventoryItemCharacteristicComponent t = new InventoryItemCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<InventoryItemCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public InventoryItem addCharacteristic(InventoryItemCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<InventoryItemCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public InventoryItemCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #instance} (Instances or occurrences of the product.)
     */
    public InventoryItemInstanceComponent getInstance() { 
      if (this.instance == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.instance");
        else if (Configuration.doAutoCreate())
          this.instance = new InventoryItemInstanceComponent(); // cc
      return this.instance;
    }

    public boolean hasInstance() { 
      return this.instance != null && !this.instance.isEmpty();
    }

    /**
     * @param value {@link #instance} (Instances or occurrences of the product.)
     */
    public InventoryItem setInstance(InventoryItemInstanceComponent value) { 
      this.instance = value;
      return this;
    }

    /**
     * @return {@link #productReference} (Link to a product resource used in clinical workflows.)
     */
    public Reference getProductReference() { 
      if (this.productReference == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryItem.productReference");
        else if (Configuration.doAutoCreate())
          this.productReference = new Reference(); // cc
      return this.productReference;
    }

    public boolean hasProductReference() { 
      return this.productReference != null && !this.productReference.isEmpty();
    }

    /**
     * @param value {@link #productReference} (Link to a product resource used in clinical workflows.)
     */
    public InventoryItem setProductReference(Reference value) { 
      this.productReference = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for the inventory item.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Status of the item entry.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "Category or class of the item.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Code designating the specific type of item.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("name", "", "The item name(s) - the brand name, or common name, functional name, generic name.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("responsibleOrganization", "", "Organization(s) responsible for the product.", 0, java.lang.Integer.MAX_VALUE, responsibleOrganization));
        children.add(new Property("description", "", "The descriptive characteristics of the inventory item.", 0, 1, description));
        children.add(new Property("inventoryStatus", "CodeableConcept", "The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.", 0, java.lang.Integer.MAX_VALUE, inventoryStatus));
        children.add(new Property("baseUnit", "CodeableConcept", "The base unit of measure - the unit in which the product is used or counted.", 0, 1, baseUnit));
        children.add(new Property("netContent", "Quantity", "Net content or amount present in the item.", 0, 1, netContent));
        children.add(new Property("association", "", "Association with other items or products.", 0, java.lang.Integer.MAX_VALUE, association));
        children.add(new Property("characteristic", "", "The descriptive or identifying characteristics of the item.", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("instance", "", "Instances or occurrences of the product.", 0, 1, instance));
        children.add(new Property("productReference", "Reference(Medication|Device|NutritionProduct|BiologicallyDerivedProduct)", "Link to a product resource used in clinical workflows.", 0, 1, productReference));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for the inventory item.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Status of the item entry.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Category or class of the item.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Code designating the specific type of item.", 0, java.lang.Integer.MAX_VALUE, code);
        case 3373707: /*name*/  return new Property("name", "", "The item name(s) - the brand name, or common name, functional name, generic name.", 0, java.lang.Integer.MAX_VALUE, name);
        case -1704933559: /*responsibleOrganization*/  return new Property("responsibleOrganization", "", "Organization(s) responsible for the product.", 0, java.lang.Integer.MAX_VALUE, responsibleOrganization);
        case -1724546052: /*description*/  return new Property("description", "", "The descriptive characteristics of the inventory item.", 0, 1, description);
        case -1370922898: /*inventoryStatus*/  return new Property("inventoryStatus", "CodeableConcept", "The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.", 0, java.lang.Integer.MAX_VALUE, inventoryStatus);
        case -1721465867: /*baseUnit*/  return new Property("baseUnit", "CodeableConcept", "The base unit of measure - the unit in which the product is used or counted.", 0, 1, baseUnit);
        case 612796444: /*netContent*/  return new Property("netContent", "Quantity", "Net content or amount present in the item.", 0, 1, netContent);
        case -87499647: /*association*/  return new Property("association", "", "Association with other items or products.", 0, java.lang.Integer.MAX_VALUE, association);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "The descriptive or identifying characteristics of the item.", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case 555127957: /*instance*/  return new Property("instance", "", "Instances or occurrences of the product.", 0, 1, instance);
        case -669667556: /*productReference*/  return new Property("productReference", "Reference(Medication|Device|NutritionProduct|BiologicallyDerivedProduct)", "Link to a product resource used in clinical workflows.", 0, 1, productReference);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<InventoryItemStatusCodes>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // InventoryItemNameComponent
        case -1704933559: /*responsibleOrganization*/ return this.responsibleOrganization == null ? new Base[0] : this.responsibleOrganization.toArray(new Base[this.responsibleOrganization.size()]); // InventoryItemResponsibleOrganizationComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // InventoryItemDescriptionComponent
        case -1370922898: /*inventoryStatus*/ return this.inventoryStatus == null ? new Base[0] : this.inventoryStatus.toArray(new Base[this.inventoryStatus.size()]); // CodeableConcept
        case -1721465867: /*baseUnit*/ return this.baseUnit == null ? new Base[0] : new Base[] {this.baseUnit}; // CodeableConcept
        case 612796444: /*netContent*/ return this.netContent == null ? new Base[0] : new Base[] {this.netContent}; // Quantity
        case -87499647: /*association*/ return this.association == null ? new Base[0] : this.association.toArray(new Base[this.association.size()]); // InventoryItemAssociationComponent
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // InventoryItemCharacteristicComponent
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : new Base[] {this.instance}; // InventoryItemInstanceComponent
        case -669667556: /*productReference*/ return this.productReference == null ? new Base[0] : new Base[] {this.productReference}; // Reference
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
          value = new InventoryItemStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InventoryItemStatusCodes>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3373707: // name
          this.getName().add((InventoryItemNameComponent) value); // InventoryItemNameComponent
          return value;
        case -1704933559: // responsibleOrganization
          this.getResponsibleOrganization().add((InventoryItemResponsibleOrganizationComponent) value); // InventoryItemResponsibleOrganizationComponent
          return value;
        case -1724546052: // description
          this.description = (InventoryItemDescriptionComponent) value; // InventoryItemDescriptionComponent
          return value;
        case -1370922898: // inventoryStatus
          this.getInventoryStatus().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1721465867: // baseUnit
          this.baseUnit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 612796444: // netContent
          this.netContent = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -87499647: // association
          this.getAssociation().add((InventoryItemAssociationComponent) value); // InventoryItemAssociationComponent
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((InventoryItemCharacteristicComponent) value); // InventoryItemCharacteristicComponent
          return value;
        case 555127957: // instance
          this.instance = (InventoryItemInstanceComponent) value; // InventoryItemInstanceComponent
          return value;
        case -669667556: // productReference
          this.productReference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new InventoryItemStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InventoryItemStatusCodes>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("name")) {
          this.getName().add((InventoryItemNameComponent) value);
        } else if (name.equals("responsibleOrganization")) {
          this.getResponsibleOrganization().add((InventoryItemResponsibleOrganizationComponent) value);
        } else if (name.equals("description")) {
          this.description = (InventoryItemDescriptionComponent) value; // InventoryItemDescriptionComponent
        } else if (name.equals("inventoryStatus")) {
          this.getInventoryStatus().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("baseUnit")) {
          this.baseUnit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("netContent")) {
          this.netContent = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("association")) {
          this.getAssociation().add((InventoryItemAssociationComponent) value);
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((InventoryItemCharacteristicComponent) value);
        } else if (name.equals("instance")) {
          this.instance = (InventoryItemInstanceComponent) value; // InventoryItemInstanceComponent
        } else if (name.equals("productReference")) {
          this.productReference = TypeConvertor.castToReference(value); // Reference
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
        case 3059181:  return addCode(); 
        case 3373707:  return addName(); 
        case -1704933559:  return addResponsibleOrganization(); 
        case -1724546052:  return getDescription();
        case -1370922898:  return addInventoryStatus(); 
        case -1721465867:  return getBaseUnit();
        case 612796444:  return getNetContent();
        case -87499647:  return addAssociation(); 
        case 366313883:  return addCharacteristic(); 
        case 555127957:  return getInstance();
        case -669667556:  return getProductReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {};
        case -1704933559: /*responsibleOrganization*/ return new String[] {};
        case -1724546052: /*description*/ return new String[] {};
        case -1370922898: /*inventoryStatus*/ return new String[] {"CodeableConcept"};
        case -1721465867: /*baseUnit*/ return new String[] {"CodeableConcept"};
        case 612796444: /*netContent*/ return new String[] {"Quantity"};
        case -87499647: /*association*/ return new String[] {};
        case 366313883: /*characteristic*/ return new String[] {};
        case 555127957: /*instance*/ return new String[] {};
        case -669667556: /*productReference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type InventoryItem.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("responsibleOrganization")) {
          return addResponsibleOrganization();
        }
        else if (name.equals("description")) {
          this.description = new InventoryItemDescriptionComponent();
          return this.description;
        }
        else if (name.equals("inventoryStatus")) {
          return addInventoryStatus();
        }
        else if (name.equals("baseUnit")) {
          this.baseUnit = new CodeableConcept();
          return this.baseUnit;
        }
        else if (name.equals("netContent")) {
          this.netContent = new Quantity();
          return this.netContent;
        }
        else if (name.equals("association")) {
          return addAssociation();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("instance")) {
          this.instance = new InventoryItemInstanceComponent();
          return this.instance;
        }
        else if (name.equals("productReference")) {
          this.productReference = new Reference();
          return this.productReference;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "InventoryItem";

  }

      public InventoryItem copy() {
        InventoryItem dst = new InventoryItem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryItem dst) {
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
        if (code != null) {
          dst.code = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : code)
            dst.code.add(i.copy());
        };
        if (name != null) {
          dst.name = new ArrayList<InventoryItemNameComponent>();
          for (InventoryItemNameComponent i : name)
            dst.name.add(i.copy());
        };
        if (responsibleOrganization != null) {
          dst.responsibleOrganization = new ArrayList<InventoryItemResponsibleOrganizationComponent>();
          for (InventoryItemResponsibleOrganizationComponent i : responsibleOrganization)
            dst.responsibleOrganization.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (inventoryStatus != null) {
          dst.inventoryStatus = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : inventoryStatus)
            dst.inventoryStatus.add(i.copy());
        };
        dst.baseUnit = baseUnit == null ? null : baseUnit.copy();
        dst.netContent = netContent == null ? null : netContent.copy();
        if (association != null) {
          dst.association = new ArrayList<InventoryItemAssociationComponent>();
          for (InventoryItemAssociationComponent i : association)
            dst.association.add(i.copy());
        };
        if (characteristic != null) {
          dst.characteristic = new ArrayList<InventoryItemCharacteristicComponent>();
          for (InventoryItemCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
        dst.instance = instance == null ? null : instance.copy();
        dst.productReference = productReference == null ? null : productReference.copy();
      }

      protected InventoryItem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryItem))
          return false;
        InventoryItem o = (InventoryItem) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(category, o.category, true)
           && compareDeep(code, o.code, true) && compareDeep(name, o.name, true) && compareDeep(responsibleOrganization, o.responsibleOrganization, true)
           && compareDeep(description, o.description, true) && compareDeep(inventoryStatus, o.inventoryStatus, true)
           && compareDeep(baseUnit, o.baseUnit, true) && compareDeep(netContent, o.netContent, true) && compareDeep(association, o.association, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(instance, o.instance, true)
           && compareDeep(productReference, o.productReference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryItem))
          return false;
        InventoryItem o = (InventoryItem) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, category
          , code, name, responsibleOrganization, description, inventoryStatus, baseUnit, netContent
          , association, characteristic, instance, productReference);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.InventoryItem;
   }

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="InventoryItem.code", description="Search for products that match this code", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="InventoryItem.identifier", description="The identifier of the item", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="InventoryItem.status", description="The status of the item", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryItem.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>InventoryItem.instance.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="InventoryItem.instance.subject", description="The identity of a patient for whom to list associations", type="reference", target={Organization.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list associations</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>InventoryItem.instance.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>InventoryItem:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("InventoryItem:subject").toLocked();


}

