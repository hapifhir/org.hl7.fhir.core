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
 * A medically related item or items, in a container or package.
 */
@ResourceDef(name="PackagedProductDefinition", profile="http://hl7.org/fhir/StructureDefinition/PackagedProductDefinition")
public class PackagedProductDefinition extends DomainResource {

    @Block()
    public static class PackagedProductDefinitionLegalStatusOfSupplyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual status of supply. Conveys in what situation this package type may be supplied for use.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual status of supply. In what situation this package type may be supplied for use", formalDefinition="The actual status of supply. Conveys in what situation this package type may be supplied for use." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/legal-status-of-supply")
        protected CodeableConcept code;

        /**
         * The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context.
         */
        @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The place where the legal status of supply applies", formalDefinition="The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
        protected CodeableConcept jurisdiction;

        private static final long serialVersionUID = 1072410156L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionLegalStatusOfSupplyComponent() {
        super();
      }

        /**
         * @return {@link #code} (The actual status of supply. Conveys in what situation this package type may be supplied for use.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionLegalStatusOfSupplyComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The actual status of supply. Conveys in what situation this package type may be supplied for use.)
         */
        public PackagedProductDefinitionLegalStatusOfSupplyComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #jurisdiction} (The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context.)
         */
        public CodeableConcept getJurisdiction() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionLegalStatusOfSupplyComponent.jurisdiction");
            else if (Configuration.doAutoCreate())
              this.jurisdiction = new CodeableConcept(); // cc
          return this.jurisdiction;
        }

        public boolean hasJurisdiction() { 
          return this.jurisdiction != null && !this.jurisdiction.isEmpty();
        }

        /**
         * @param value {@link #jurisdiction} (The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context.)
         */
        public PackagedProductDefinitionLegalStatusOfSupplyComponent setJurisdiction(CodeableConcept value) { 
          this.jurisdiction = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "The actual status of supply. Conveys in what situation this package type may be supplied for use.", 0, 1, code));
          children.add(new Property("jurisdiction", "CodeableConcept", "The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context.", 0, 1, jurisdiction));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The actual status of supply. Conveys in what situation this package type may be supplied for use.", 0, 1, code);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "The place where the legal status of supply applies. When not specified, this indicates it is unknown in this context.", 0, 1, jurisdiction);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : new Base[] {this.jurisdiction}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -507075711: // jurisdiction
          this.jurisdiction = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("jurisdiction")) {
          this.jurisdiction = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -507075711:  return getJurisdiction();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("jurisdiction")) {
          this.jurisdiction = new CodeableConcept();
          return this.jurisdiction;
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionLegalStatusOfSupplyComponent copy() {
        PackagedProductDefinitionLegalStatusOfSupplyComponent dst = new PackagedProductDefinitionLegalStatusOfSupplyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionLegalStatusOfSupplyComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionLegalStatusOfSupplyComponent))
          return false;
        PackagedProductDefinitionLegalStatusOfSupplyComponent o = (PackagedProductDefinitionLegalStatusOfSupplyComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(jurisdiction, o.jurisdiction, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionLegalStatusOfSupplyComponent))
          return false;
        PackagedProductDefinitionLegalStatusOfSupplyComponent o = (PackagedProductDefinitionLegalStatusOfSupplyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, jurisdiction);
      }

  public String fhirType() {
    return "PackagedProductDefinition.legalStatusOfSupply";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackagingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A business identifier that is specific to this particular part of the packaging, often assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="An identifier that is specific to this particular part of the packaging. Including possibly a Data Carrier Identifier", formalDefinition="A business identifier that is specific to this particular part of the packaging, often assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode)." )
        protected List<Identifier> identifier;

        /**
         * The physical type of the container of the items.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The physical type of the container of the items", formalDefinition="The physical type of the container of the items." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/packaging-type")
        protected CodeableConcept type;

        /**
         * Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.
         */
        @Child(name = "componentPart", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial)", formalDefinition="Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not." )
        protected BooleanType componentPart;

        /**
         * The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.
         */
        @Child(name = "quantity", type = {IntegerType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of this level of packaging in the package that contains it (with the outermost level being 1)", formalDefinition="The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2." )
        protected IntegerType quantity;

        /**
         * Material type of the package item.
         */
        @Child(name = "material", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Material type of the package item", formalDefinition="Material type of the package item." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/package-material")
        protected List<CodeableConcept> material;

        /**
         * A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material (e.g. different types of plastic for a blister sleeve).
         */
        @Child(name = "alternateMaterial", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material", formalDefinition="A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material (e.g. different types of plastic for a blister sleeve)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/package-material")
        protected List<CodeableConcept> alternateMaterial;

        /**
         * Shelf Life and storage information.
         */
        @Child(name = "shelfLifeStorage", type = {ProductShelfLife.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Shelf Life and storage information", formalDefinition="Shelf Life and storage information." )
        protected List<ProductShelfLife> shelfLifeStorage;

        /**
         * Manufacturer of this packaging item. When there are multiple values each one is a potential manufacturer of this packaging item.
         */
        @Child(name = "manufacturer", type = {Organization.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Manufacturer of this packaging item (multiple means these are all potential manufacturers)", formalDefinition="Manufacturer of this packaging item. When there are multiple values each one is a potential manufacturer of this packaging item." )
        protected List<Reference> manufacturer;

        /**
         * General characteristics of this item.
         */
        @Child(name = "property", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="General characteristics of this item", formalDefinition="General characteristics of this item." )
        protected List<PackagedProductDefinitionPackagingPropertyComponent> property;

        /**
         * The item(s) within the packaging.
         */
        @Child(name = "containedItem", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The item(s) within the packaging", formalDefinition="The item(s) within the packaging." )
        protected List<PackagedProductDefinitionPackagingContainedItemComponent> containedItem;

        /**
         * Allows containers (and parts of containers) within containers, still as a part of a single packaged product. See also PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).
         */
        @Child(name = "packaging", type = {PackagedProductDefinitionPackagingComponent.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Allows containers (and parts of containers) within containers, still as a part of single packaged product", formalDefinition="Allows containers (and parts of containers) within containers, still as a part of a single packaged product. See also PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition)." )
        protected List<PackagedProductDefinitionPackagingComponent> packaging;

        private static final long serialVersionUID = 2121836225L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackagingComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (A business identifier that is specific to this particular part of the packaging, often assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public PackagedProductDefinitionPackagingComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #type} (The physical type of the container of the items.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The physical type of the container of the items.)
         */
        public PackagedProductDefinitionPackagingComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #componentPart} (Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.). This is the underlying object with id, value and extensions. The accessor "getComponentPart" gives direct access to the value
         */
        public BooleanType getComponentPartElement() { 
          if (this.componentPart == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingComponent.componentPart");
            else if (Configuration.doAutoCreate())
              this.componentPart = new BooleanType(); // bb
          return this.componentPart;
        }

        public boolean hasComponentPartElement() { 
          return this.componentPart != null && !this.componentPart.isEmpty();
        }

        public boolean hasComponentPart() { 
          return this.componentPart != null && !this.componentPart.isEmpty();
        }

        /**
         * @param value {@link #componentPart} (Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.). This is the underlying object with id, value and extensions. The accessor "getComponentPart" gives direct access to the value
         */
        public PackagedProductDefinitionPackagingComponent setComponentPartElement(BooleanType value) { 
          this.componentPart = value;
          return this;
        }

        /**
         * @return Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.
         */
        public boolean getComponentPart() { 
          return this.componentPart == null || this.componentPart.isEmpty() ? false : this.componentPart.getValue();
        }

        /**
         * @param value Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.
         */
        public PackagedProductDefinitionPackagingComponent setComponentPart(boolean value) { 
            if (this.componentPart == null)
              this.componentPart = new BooleanType();
            this.componentPart.setValue(value);
          return this;
        }

        /**
         * @return {@link #quantity} (The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.). This is the underlying object with id, value and extensions. The accessor "getQuantity" gives direct access to the value
         */
        public IntegerType getQuantityElement() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new IntegerType(); // bb
          return this.quantity;
        }

        public boolean hasQuantityElement() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.). This is the underlying object with id, value and extensions. The accessor "getQuantity" gives direct access to the value
         */
        public PackagedProductDefinitionPackagingComponent setQuantityElement(IntegerType value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.
         */
        public int getQuantity() { 
          return this.quantity == null || this.quantity.isEmpty() ? 0 : this.quantity.getValue();
        }

        /**
         * @param value The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.
         */
        public PackagedProductDefinitionPackagingComponent setQuantity(int value) { 
            if (this.quantity == null)
              this.quantity = new IntegerType();
            this.quantity.setValue(value);
          return this;
        }

        /**
         * @return {@link #material} (Material type of the package item.)
         */
        public List<CodeableConcept> getMaterial() { 
          if (this.material == null)
            this.material = new ArrayList<CodeableConcept>();
          return this.material;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setMaterial(List<CodeableConcept> theMaterial) { 
          this.material = theMaterial;
          return this;
        }

        public boolean hasMaterial() { 
          if (this.material == null)
            return false;
          for (CodeableConcept item : this.material)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addMaterial() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.material == null)
            this.material = new ArrayList<CodeableConcept>();
          this.material.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addMaterial(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.material == null)
            this.material = new ArrayList<CodeableConcept>();
          this.material.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #material}, creating it if it does not already exist {3}
         */
        public CodeableConcept getMaterialFirstRep() { 
          if (getMaterial().isEmpty()) {
            addMaterial();
          }
          return getMaterial().get(0);
        }

        /**
         * @return {@link #alternateMaterial} (A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material (e.g. different types of plastic for a blister sleeve).)
         */
        public List<CodeableConcept> getAlternateMaterial() { 
          if (this.alternateMaterial == null)
            this.alternateMaterial = new ArrayList<CodeableConcept>();
          return this.alternateMaterial;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setAlternateMaterial(List<CodeableConcept> theAlternateMaterial) { 
          this.alternateMaterial = theAlternateMaterial;
          return this;
        }

        public boolean hasAlternateMaterial() { 
          if (this.alternateMaterial == null)
            return false;
          for (CodeableConcept item : this.alternateMaterial)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAlternateMaterial() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.alternateMaterial == null)
            this.alternateMaterial = new ArrayList<CodeableConcept>();
          this.alternateMaterial.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addAlternateMaterial(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.alternateMaterial == null)
            this.alternateMaterial = new ArrayList<CodeableConcept>();
          this.alternateMaterial.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #alternateMaterial}, creating it if it does not already exist {3}
         */
        public CodeableConcept getAlternateMaterialFirstRep() { 
          if (getAlternateMaterial().isEmpty()) {
            addAlternateMaterial();
          }
          return getAlternateMaterial().get(0);
        }

        /**
         * @return {@link #shelfLifeStorage} (Shelf Life and storage information.)
         */
        public List<ProductShelfLife> getShelfLifeStorage() { 
          if (this.shelfLifeStorage == null)
            this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          return this.shelfLifeStorage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setShelfLifeStorage(List<ProductShelfLife> theShelfLifeStorage) { 
          this.shelfLifeStorage = theShelfLifeStorage;
          return this;
        }

        public boolean hasShelfLifeStorage() { 
          if (this.shelfLifeStorage == null)
            return false;
          for (ProductShelfLife item : this.shelfLifeStorage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ProductShelfLife addShelfLifeStorage() { //3
          ProductShelfLife t = new ProductShelfLife();
          if (this.shelfLifeStorage == null)
            this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          this.shelfLifeStorage.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addShelfLifeStorage(ProductShelfLife t) { //3
          if (t == null)
            return this;
          if (this.shelfLifeStorage == null)
            this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          this.shelfLifeStorage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #shelfLifeStorage}, creating it if it does not already exist {3}
         */
        public ProductShelfLife getShelfLifeStorageFirstRep() { 
          if (getShelfLifeStorage().isEmpty()) {
            addShelfLifeStorage();
          }
          return getShelfLifeStorage().get(0);
        }

        /**
         * @return {@link #manufacturer} (Manufacturer of this packaging item. When there are multiple values each one is a potential manufacturer of this packaging item.)
         */
        public List<Reference> getManufacturer() { 
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          return this.manufacturer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setManufacturer(List<Reference> theManufacturer) { 
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

        public PackagedProductDefinitionPackagingComponent addManufacturer(Reference t) { //3
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
         * @return {@link #property} (General characteristics of this item.)
         */
        public List<PackagedProductDefinitionPackagingPropertyComponent> getProperty() { 
          if (this.property == null)
            this.property = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
          return this.property;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setProperty(List<PackagedProductDefinitionPackagingPropertyComponent> theProperty) { 
          this.property = theProperty;
          return this;
        }

        public boolean hasProperty() { 
          if (this.property == null)
            return false;
          for (PackagedProductDefinitionPackagingPropertyComponent item : this.property)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackagingPropertyComponent addProperty() { //3
          PackagedProductDefinitionPackagingPropertyComponent t = new PackagedProductDefinitionPackagingPropertyComponent();
          if (this.property == null)
            this.property = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
          this.property.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addProperty(PackagedProductDefinitionPackagingPropertyComponent t) { //3
          if (t == null)
            return this;
          if (this.property == null)
            this.property = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
          this.property.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
         */
        public PackagedProductDefinitionPackagingPropertyComponent getPropertyFirstRep() { 
          if (getProperty().isEmpty()) {
            addProperty();
          }
          return getProperty().get(0);
        }

        /**
         * @return {@link #containedItem} (The item(s) within the packaging.)
         */
        public List<PackagedProductDefinitionPackagingContainedItemComponent> getContainedItem() { 
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackagingContainedItemComponent>();
          return this.containedItem;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setContainedItem(List<PackagedProductDefinitionPackagingContainedItemComponent> theContainedItem) { 
          this.containedItem = theContainedItem;
          return this;
        }

        public boolean hasContainedItem() { 
          if (this.containedItem == null)
            return false;
          for (PackagedProductDefinitionPackagingContainedItemComponent item : this.containedItem)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackagingContainedItemComponent addContainedItem() { //3
          PackagedProductDefinitionPackagingContainedItemComponent t = new PackagedProductDefinitionPackagingContainedItemComponent();
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackagingContainedItemComponent>();
          this.containedItem.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addContainedItem(PackagedProductDefinitionPackagingContainedItemComponent t) { //3
          if (t == null)
            return this;
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackagingContainedItemComponent>();
          this.containedItem.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #containedItem}, creating it if it does not already exist {3}
         */
        public PackagedProductDefinitionPackagingContainedItemComponent getContainedItemFirstRep() { 
          if (getContainedItem().isEmpty()) {
            addContainedItem();
          }
          return getContainedItem().get(0);
        }

        /**
         * @return {@link #packaging} (Allows containers (and parts of containers) within containers, still as a part of a single packaged product. See also PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).)
         */
        public List<PackagedProductDefinitionPackagingComponent> getPackaging() { 
          if (this.packaging == null)
            this.packaging = new ArrayList<PackagedProductDefinitionPackagingComponent>();
          return this.packaging;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackagingComponent setPackaging(List<PackagedProductDefinitionPackagingComponent> thePackaging) { 
          this.packaging = thePackaging;
          return this;
        }

        public boolean hasPackaging() { 
          if (this.packaging == null)
            return false;
          for (PackagedProductDefinitionPackagingComponent item : this.packaging)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackagingComponent addPackaging() { //3
          PackagedProductDefinitionPackagingComponent t = new PackagedProductDefinitionPackagingComponent();
          if (this.packaging == null)
            this.packaging = new ArrayList<PackagedProductDefinitionPackagingComponent>();
          this.packaging.add(t);
          return t;
        }

        public PackagedProductDefinitionPackagingComponent addPackaging(PackagedProductDefinitionPackagingComponent t) { //3
          if (t == null)
            return this;
          if (this.packaging == null)
            this.packaging = new ArrayList<PackagedProductDefinitionPackagingComponent>();
          this.packaging.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #packaging}, creating it if it does not already exist {3}
         */
        public PackagedProductDefinitionPackagingComponent getPackagingFirstRep() { 
          if (getPackaging().isEmpty()) {
            addPackaging();
          }
          return getPackaging().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "A business identifier that is specific to this particular part of the packaging, often assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("type", "CodeableConcept", "The physical type of the container of the items.", 0, 1, type));
          children.add(new Property("componentPart", "boolean", "Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.", 0, 1, componentPart));
          children.add(new Property("quantity", "integer", "The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.", 0, 1, quantity));
          children.add(new Property("material", "CodeableConcept", "Material type of the package item.", 0, java.lang.Integer.MAX_VALUE, material));
          children.add(new Property("alternateMaterial", "CodeableConcept", "A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material (e.g. different types of plastic for a blister sleeve).", 0, java.lang.Integer.MAX_VALUE, alternateMaterial));
          children.add(new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage));
          children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of this packaging item. When there are multiple values each one is a potential manufacturer of this packaging item.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
          children.add(new Property("property", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, property));
          children.add(new Property("containedItem", "", "The item(s) within the packaging.", 0, java.lang.Integer.MAX_VALUE, containedItem));
          children.add(new Property("packaging", "@PackagedProductDefinition.packaging", "Allows containers (and parts of containers) within containers, still as a part of a single packaged product. See also PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).", 0, java.lang.Integer.MAX_VALUE, packaging));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A business identifier that is specific to this particular part of the packaging, often assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The physical type of the container of the items.", 0, 1, type);
          case 1706307216: /*componentPart*/  return new Property("componentPart", "boolean", "Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging itself (e.g. a bottle or vial). The latter type are designed be a container, but the former are not.", 0, 1, componentPart);
          case -1285004149: /*quantity*/  return new Property("quantity", "integer", "The quantity of packaging items contained at this layer of the package. This does not relate to the number of contained items but relates solely to the number of packaging items. When looking at the outermost layer it is always 1. If there are two boxes within, at the next layer it would be 2.", 0, 1, quantity);
          case 299066663: /*material*/  return new Property("material", "CodeableConcept", "Material type of the package item.", 0, java.lang.Integer.MAX_VALUE, material);
          case -1021448255: /*alternateMaterial*/  return new Property("alternateMaterial", "CodeableConcept", "A possible alternate material for this part of the packaging, that is allowed to be used instead of the usual material (e.g. different types of plastic for a blister sleeve).", 0, java.lang.Integer.MAX_VALUE, alternateMaterial);
          case 172049237: /*shelfLifeStorage*/  return new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage);
          case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of this packaging item. When there are multiple values each one is a potential manufacturer of this packaging item.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
          case -993141291: /*property*/  return new Property("property", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, property);
          case 1953679910: /*containedItem*/  return new Property("containedItem", "", "The item(s) within the packaging.", 0, java.lang.Integer.MAX_VALUE, containedItem);
          case 1802065795: /*packaging*/  return new Property("packaging", "@PackagedProductDefinition.packaging", "Allows containers (and parts of containers) within containers, still as a part of a single packaged product. See also PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).", 0, java.lang.Integer.MAX_VALUE, packaging);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1706307216: /*componentPart*/ return this.componentPart == null ? new Base[0] : new Base[] {this.componentPart}; // BooleanType
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // IntegerType
        case 299066663: /*material*/ return this.material == null ? new Base[0] : this.material.toArray(new Base[this.material.size()]); // CodeableConcept
        case -1021448255: /*alternateMaterial*/ return this.alternateMaterial == null ? new Base[0] : this.alternateMaterial.toArray(new Base[this.alternateMaterial.size()]); // CodeableConcept
        case 172049237: /*shelfLifeStorage*/ return this.shelfLifeStorage == null ? new Base[0] : this.shelfLifeStorage.toArray(new Base[this.shelfLifeStorage.size()]); // ProductShelfLife
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // PackagedProductDefinitionPackagingPropertyComponent
        case 1953679910: /*containedItem*/ return this.containedItem == null ? new Base[0] : this.containedItem.toArray(new Base[this.containedItem.size()]); // PackagedProductDefinitionPackagingContainedItemComponent
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : this.packaging.toArray(new Base[this.packaging.size()]); // PackagedProductDefinitionPackagingComponent
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
        case 1706307216: // componentPart
          this.componentPart = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 299066663: // material
          this.getMaterial().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1021448255: // alternateMaterial
          this.getAlternateMaterial().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 172049237: // shelfLifeStorage
          this.getShelfLifeStorage().add(TypeConvertor.castToProductShelfLife(value)); // ProductShelfLife
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -993141291: // property
          this.getProperty().add((PackagedProductDefinitionPackagingPropertyComponent) value); // PackagedProductDefinitionPackagingPropertyComponent
          return value;
        case 1953679910: // containedItem
          this.getContainedItem().add((PackagedProductDefinitionPackagingContainedItemComponent) value); // PackagedProductDefinitionPackagingContainedItemComponent
          return value;
        case 1802065795: // packaging
          this.getPackaging().add((PackagedProductDefinitionPackagingComponent) value); // PackagedProductDefinitionPackagingComponent
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
        } else if (name.equals("componentPart")) {
          this.componentPart = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("material")) {
          this.getMaterial().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("alternateMaterial")) {
          this.getAlternateMaterial().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("shelfLifeStorage")) {
          this.getShelfLifeStorage().add(TypeConvertor.castToProductShelfLife(value));
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("property")) {
          this.getProperty().add((PackagedProductDefinitionPackagingPropertyComponent) value);
        } else if (name.equals("containedItem")) {
          this.getContainedItem().add((PackagedProductDefinitionPackagingContainedItemComponent) value);
        } else if (name.equals("packaging")) {
          this.getPackaging().add((PackagedProductDefinitionPackagingComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getType();
        case 1706307216:  return getComponentPartElement();
        case -1285004149:  return getQuantityElement();
        case 299066663:  return addMaterial(); 
        case -1021448255:  return addAlternateMaterial(); 
        case 172049237:  return addShelfLifeStorage(); 
        case -1969347631:  return addManufacturer(); 
        case -993141291:  return addProperty(); 
        case 1953679910:  return addContainedItem(); 
        case 1802065795:  return addPackaging(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1706307216: /*componentPart*/ return new String[] {"boolean"};
        case -1285004149: /*quantity*/ return new String[] {"integer"};
        case 299066663: /*material*/ return new String[] {"CodeableConcept"};
        case -1021448255: /*alternateMaterial*/ return new String[] {"CodeableConcept"};
        case 172049237: /*shelfLifeStorage*/ return new String[] {"ProductShelfLife"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -993141291: /*property*/ return new String[] {};
        case 1953679910: /*containedItem*/ return new String[] {};
        case 1802065795: /*packaging*/ return new String[] {"@PackagedProductDefinition.packaging"};
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
        else if (name.equals("componentPart")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.packaging.componentPart");
        }
        else if (name.equals("quantity")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.packaging.quantity");
        }
        else if (name.equals("material")) {
          return addMaterial();
        }
        else if (name.equals("alternateMaterial")) {
          return addAlternateMaterial();
        }
        else if (name.equals("shelfLifeStorage")) {
          return addShelfLifeStorage();
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("containedItem")) {
          return addContainedItem();
        }
        else if (name.equals("packaging")) {
          return addPackaging();
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionPackagingComponent copy() {
        PackagedProductDefinitionPackagingComponent dst = new PackagedProductDefinitionPackagingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackagingComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.componentPart = componentPart == null ? null : componentPart.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        if (material != null) {
          dst.material = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : material)
            dst.material.add(i.copy());
        };
        if (alternateMaterial != null) {
          dst.alternateMaterial = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : alternateMaterial)
            dst.alternateMaterial.add(i.copy());
        };
        if (shelfLifeStorage != null) {
          dst.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          for (ProductShelfLife i : shelfLifeStorage)
            dst.shelfLifeStorage.add(i.copy());
        };
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
          for (PackagedProductDefinitionPackagingPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        if (containedItem != null) {
          dst.containedItem = new ArrayList<PackagedProductDefinitionPackagingContainedItemComponent>();
          for (PackagedProductDefinitionPackagingContainedItemComponent i : containedItem)
            dst.containedItem.add(i.copy());
        };
        if (packaging != null) {
          dst.packaging = new ArrayList<PackagedProductDefinitionPackagingComponent>();
          for (PackagedProductDefinitionPackagingComponent i : packaging)
            dst.packaging.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingComponent))
          return false;
        PackagedProductDefinitionPackagingComponent o = (PackagedProductDefinitionPackagingComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(componentPart, o.componentPart, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(material, o.material, true) && compareDeep(alternateMaterial, o.alternateMaterial, true)
           && compareDeep(shelfLifeStorage, o.shelfLifeStorage, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(property, o.property, true) && compareDeep(containedItem, o.containedItem, true)
           && compareDeep(packaging, o.packaging, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingComponent))
          return false;
        PackagedProductDefinitionPackagingComponent o = (PackagedProductDefinitionPackagingComponent) other_;
        return compareValues(componentPart, o.componentPart, true) && compareValues(quantity, o.quantity, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, componentPart
          , quantity, material, alternateMaterial, shelfLifeStorage, manufacturer, property
          , containedItem, packaging);
      }

  public String fhirType() {
    return "PackagedProductDefinition.packaging";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackagingPropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code expressing the type of characteristic.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code expressing the type of characteristic", formalDefinition="A code expressing the type of characteristic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/product-characteristic-codes")
        protected CodeableConcept type;

        /**
         * A value for the characteristic.
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class, DateType.class, BooleanType.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the characteristic", formalDefinition="A value for the characteristic." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackagingPropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackagingPropertyComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingPropertyComponent.type");
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
        public PackagedProductDefinitionPackagingPropertyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @return {@link #value} (A value for the characteristic.)
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
         * @param value {@link #value} (A value for the characteristic.)
         */
        public PackagedProductDefinitionPackagingPropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof DateType || value instanceof BooleanType || value instanceof Attachment))
            throw new FHIRException("Not the right type for PackagedProductDefinition.packaging.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "A value for the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "A value for the characteristic.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "A value for the characteristic.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "A value for the characteristic.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "A value for the characteristic.", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "date", "boolean", "Attachment"};
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
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
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

      public PackagedProductDefinitionPackagingPropertyComponent copy() {
        PackagedProductDefinitionPackagingPropertyComponent dst = new PackagedProductDefinitionPackagingPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackagingPropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingPropertyComponent))
          return false;
        PackagedProductDefinitionPackagingPropertyComponent o = (PackagedProductDefinitionPackagingPropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingPropertyComponent))
          return false;
        PackagedProductDefinitionPackagingPropertyComponent o = (PackagedProductDefinitionPackagingPropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "PackagedProductDefinition.packaging.property";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackagingContainedItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).
         */
        @Child(name = "item", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual item(s) of medication, as manufactured, or a device, or other medically related item (food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package", formalDefinition="The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging)." )
        protected CodeableReference item;

        /**
         * The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition).
         */
        @Child(name = "amount", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition)", formalDefinition="The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition)." )
        protected Quantity amount;

        private static final long serialVersionUID = 443863028L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackagingContainedItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackagingContainedItemComponent(CodeableReference item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingContainedItemComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).)
         */
        public PackagedProductDefinitionPackagingContainedItemComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        /**
         * @return {@link #amount} (The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition).)
         */
        public Quantity getAmount() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackagingContainedItemComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new Quantity(); // cc
          return this.amount;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition).)
         */
        public PackagedProductDefinitionPackagingContainedItemComponent setAmount(Quantity value) { 
          this.amount = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "CodeableReference(ManufacturedItemDefinition|DeviceDefinition|PackagedProductDefinition|BiologicallyDerivedProduct|NutritionProduct)", "The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).", 0, 1, item));
          children.add(new Property("amount", "Quantity", "The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition).", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "CodeableReference(ManufacturedItemDefinition|DeviceDefinition|PackagedProductDefinition|BiologicallyDerivedProduct|NutritionProduct)", "The actual item(s) of medication, as manufactured, or a device (typically, but not necessarily, a co-packaged one), or other medically related item (such as food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This also allows another whole packaged product to be included, which is solely for the case where a package of other entire packages is wanted - such as a wholesale or distribution pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).", 0, 1, item);
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "The number of this type of item within this packaging or for continuous items such as liquids it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity (especially the long definition).", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return getItem();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else if (name.equals("amount")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionPackagingContainedItemComponent copy() {
        PackagedProductDefinitionPackagingContainedItemComponent dst = new PackagedProductDefinitionPackagingContainedItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackagingContainedItemComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
        dst.amount = amount == null ? null : amount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingContainedItemComponent))
          return false;
        PackagedProductDefinitionPackagingContainedItemComponent o = (PackagedProductDefinitionPackagingContainedItemComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(amount, o.amount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackagingContainedItemComponent))
          return false;
        PackagedProductDefinitionPackagingContainedItemComponent o = (PackagedProductDefinitionPackagingContainedItemComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, amount);
      }

  public String fhirType() {
    return "PackagedProductDefinition.packaging.containedItem";

  }

  }

    /**
     * A unique identifier for this package as whole - not the the content of the package. Unique instance identifiers assigned to a package by manufacturers, regulators, drug catalogue custodians or other organizations.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A unique identifier for this package as whole - not for the content of the package", formalDefinition="A unique identifier for this package as whole - not the the content of the package. Unique instance identifiers assigned to a package by manufacturers, regulators, drug catalogue custodians or other organizations." )
    protected List<Identifier> identifier;

    /**
     * A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.
     */
    @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A name for this package. Typically as listed in a drug formulary, catalogue, inventory etc", formalDefinition="A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc." )
    protected StringType name;

    /**
     * A high level category e.g. medicinal product, raw material, shipping/transport container, etc.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A high level category e.g. medicinal product, raw material, shipping container etc", formalDefinition="A high level category e.g. medicinal product, raw material, shipping/transport container, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/package-type")
    protected CodeableConcept type;

    /**
     * The product this package model relates to, not the contents of the package (for which see package.containedItem).
     */
    @Child(name = "packageFor", type = {MedicinalProductDefinition.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The product that this is a pack for", formalDefinition="The product this package model relates to, not the contents of the package (for which see package.containedItem)." )
    protected List<Reference> packageFor;

    /**
     * The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="The status within the lifecycle of this item. High level - not intended to duplicate details elsewhere e.g. legal status, or authorization/marketing status", formalDefinition="The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected CodeableConcept status;

    /**
     * The date at which the given status became applicable.
     */
    @Child(name = "statusDate", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date at which the given status became applicable", formalDefinition="The date at which the given status became applicable." )
    protected DateTimeType statusDate;

    /**
     * A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. This attribute differs from containedItem.amount in that it can give a single aggregated count of all tablet types in a pack, even when these are different manufactured items. For example a pill pack of 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that the different item types in one pack type can be counted (e.g. a count of vials and count of syringes). Each repeat must have different units, so that it is clear what the different sets of counted items are, and it is not intended to allow different counts of similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this resource.
     */
    @Child(name = "containedItemQuantity", type = {Quantity.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. See also packaging.containedItem.amount (especially the long definition)", formalDefinition="A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. This attribute differs from containedItem.amount in that it can give a single aggregated count of all tablet types in a pack, even when these are different manufactured items. For example a pill pack of 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that the different item types in one pack type can be counted (e.g. a count of vials and count of syringes). Each repeat must have different units, so that it is clear what the different sets of counted items are, and it is not intended to allow different counts of similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this resource." )
    protected List<Quantity> containedItemQuantity;

    /**
     * Textual description. Note that this is not the name of the package or product.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Textual description. Note that this is not the name of the package or product", formalDefinition="Textual description. Note that this is not the name of the package or product." )
    protected MarkdownType description;

    /**
     * The legal status of supply of the packaged item as classified by the regulator.
     */
    @Child(name = "legalStatusOfSupply", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The legal status of supply of the packaged item as classified by the regulator", formalDefinition="The legal status of supply of the packaged item as classified by the regulator." )
    protected List<PackagedProductDefinitionLegalStatusOfSupplyComponent> legalStatusOfSupply;

    /**
     * Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.
     */
    @Child(name = "marketingStatus", type = {MarketingStatus.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated", formalDefinition="Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated." )
    protected List<MarketingStatus> marketingStatus;

    /**
     * Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.
     */
    @Child(name = "copackagedIndicator", type = {BooleanType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identifies if the drug product is supplied with another item such as a diluent or adjuvant", formalDefinition="Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant." )
    protected BooleanType copackagedIndicator;

    /**
     * Manufacturer of this package type. When there are multiple it means these are all possible manufacturers.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of this package type (multiple means these are all possible manufacturers)", formalDefinition="Manufacturer of this package type. When there are multiple it means these are all possible manufacturers." )
    protected List<Reference> manufacturer;

    /**
     * Additional information or supporting documentation about the packaged product.
     */
    @Child(name = "attachedDocument", type = {DocumentReference.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional information or supporting documentation about the packaged product", formalDefinition="Additional information or supporting documentation about the packaged product." )
    protected List<Reference> attachedDocument;

    /**
     * A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item).
     */
    @Child(name = "packaging", type = {}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap", formalDefinition="A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item)." )
    protected PackagedProductDefinitionPackagingComponent packaging;

    /**
     * Allows the key features to be recorded, such as "hospital pack", "nurse prescribable", "calendar pack".
     */
    @Child(name = "characteristic", type = {PackagedProductDefinitionPackagingPropertyComponent.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Allows the key features to be recorded, such as \"hospital pack\", \"nurse prescribable\"", formalDefinition="Allows the key features to be recorded, such as \"hospital pack\", \"nurse prescribable\", \"calendar pack\"." )
    protected List<PackagedProductDefinitionPackagingPropertyComponent> characteristic;

    private static final long serialVersionUID = -1670129447L;

  /**
   * Constructor
   */
    public PackagedProductDefinition() {
      super();
    }

    /**
     * @return {@link #identifier} (A unique identifier for this package as whole - not the the content of the package. Unique instance identifiers assigned to a package by manufacturers, regulators, drug catalogue custodians or other organizations.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public PackagedProductDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #name} (A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.name");
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
     * @param value {@link #name} (A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public PackagedProductDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.
     */
    public PackagedProductDefinition setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (A high level category e.g. medicinal product, raw material, shipping/transport container, etc.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (A high level category e.g. medicinal product, raw material, shipping/transport container, etc.)
     */
    public PackagedProductDefinition setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #packageFor} (The product this package model relates to, not the contents of the package (for which see package.containedItem).)
     */
    public List<Reference> getPackageFor() { 
      if (this.packageFor == null)
        this.packageFor = new ArrayList<Reference>();
      return this.packageFor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setPackageFor(List<Reference> thePackageFor) { 
      this.packageFor = thePackageFor;
      return this;
    }

    public boolean hasPackageFor() { 
      if (this.packageFor == null)
        return false;
      for (Reference item : this.packageFor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPackageFor() { //3
      Reference t = new Reference();
      if (this.packageFor == null)
        this.packageFor = new ArrayList<Reference>();
      this.packageFor.add(t);
      return t;
    }

    public PackagedProductDefinition addPackageFor(Reference t) { //3
      if (t == null)
        return this;
      if (this.packageFor == null)
        this.packageFor = new ArrayList<Reference>();
      this.packageFor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #packageFor}, creating it if it does not already exist {3}
     */
    public Reference getPackageForFirstRep() { 
      if (getPackageFor().isEmpty()) {
        addPackageFor();
      }
      return getPackageFor().get(0);
    }

    /**
     * @return {@link #status} (The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status.)
     */
    public PackagedProductDefinition setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #statusDate} (The date at which the given status became applicable.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
     */
    public DateTimeType getStatusDateElement() { 
      if (this.statusDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.statusDate");
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
    public PackagedProductDefinition setStatusDateElement(DateTimeType value) { 
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
    public PackagedProductDefinition setStatusDate(Date value) { 
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
     * @return {@link #containedItemQuantity} (A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. This attribute differs from containedItem.amount in that it can give a single aggregated count of all tablet types in a pack, even when these are different manufactured items. For example a pill pack of 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that the different item types in one pack type can be counted (e.g. a count of vials and count of syringes). Each repeat must have different units, so that it is clear what the different sets of counted items are, and it is not intended to allow different counts of similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this resource.)
     */
    public List<Quantity> getContainedItemQuantity() { 
      if (this.containedItemQuantity == null)
        this.containedItemQuantity = new ArrayList<Quantity>();
      return this.containedItemQuantity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setContainedItemQuantity(List<Quantity> theContainedItemQuantity) { 
      this.containedItemQuantity = theContainedItemQuantity;
      return this;
    }

    public boolean hasContainedItemQuantity() { 
      if (this.containedItemQuantity == null)
        return false;
      for (Quantity item : this.containedItemQuantity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Quantity addContainedItemQuantity() { //3
      Quantity t = new Quantity();
      if (this.containedItemQuantity == null)
        this.containedItemQuantity = new ArrayList<Quantity>();
      this.containedItemQuantity.add(t);
      return t;
    }

    public PackagedProductDefinition addContainedItemQuantity(Quantity t) { //3
      if (t == null)
        return this;
      if (this.containedItemQuantity == null)
        this.containedItemQuantity = new ArrayList<Quantity>();
      this.containedItemQuantity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #containedItemQuantity}, creating it if it does not already exist {3}
     */
    public Quantity getContainedItemQuantityFirstRep() { 
      if (getContainedItemQuantity().isEmpty()) {
        addContainedItemQuantity();
      }
      return getContainedItemQuantity().get(0);
    }

    /**
     * @return {@link #description} (Textual description. Note that this is not the name of the package or product.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.description");
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
     * @param value {@link #description} (Textual description. Note that this is not the name of the package or product.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public PackagedProductDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Textual description. Note that this is not the name of the package or product.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Textual description. Note that this is not the name of the package or product.
     */
    public PackagedProductDefinition setDescription(String value) { 
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
     * @return {@link #legalStatusOfSupply} (The legal status of supply of the packaged item as classified by the regulator.)
     */
    public List<PackagedProductDefinitionLegalStatusOfSupplyComponent> getLegalStatusOfSupply() { 
      if (this.legalStatusOfSupply == null)
        this.legalStatusOfSupply = new ArrayList<PackagedProductDefinitionLegalStatusOfSupplyComponent>();
      return this.legalStatusOfSupply;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setLegalStatusOfSupply(List<PackagedProductDefinitionLegalStatusOfSupplyComponent> theLegalStatusOfSupply) { 
      this.legalStatusOfSupply = theLegalStatusOfSupply;
      return this;
    }

    public boolean hasLegalStatusOfSupply() { 
      if (this.legalStatusOfSupply == null)
        return false;
      for (PackagedProductDefinitionLegalStatusOfSupplyComponent item : this.legalStatusOfSupply)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PackagedProductDefinitionLegalStatusOfSupplyComponent addLegalStatusOfSupply() { //3
      PackagedProductDefinitionLegalStatusOfSupplyComponent t = new PackagedProductDefinitionLegalStatusOfSupplyComponent();
      if (this.legalStatusOfSupply == null)
        this.legalStatusOfSupply = new ArrayList<PackagedProductDefinitionLegalStatusOfSupplyComponent>();
      this.legalStatusOfSupply.add(t);
      return t;
    }

    public PackagedProductDefinition addLegalStatusOfSupply(PackagedProductDefinitionLegalStatusOfSupplyComponent t) { //3
      if (t == null)
        return this;
      if (this.legalStatusOfSupply == null)
        this.legalStatusOfSupply = new ArrayList<PackagedProductDefinitionLegalStatusOfSupplyComponent>();
      this.legalStatusOfSupply.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #legalStatusOfSupply}, creating it if it does not already exist {3}
     */
    public PackagedProductDefinitionLegalStatusOfSupplyComponent getLegalStatusOfSupplyFirstRep() { 
      if (getLegalStatusOfSupply().isEmpty()) {
        addLegalStatusOfSupply();
      }
      return getLegalStatusOfSupply().get(0);
    }

    /**
     * @return {@link #marketingStatus} (Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.)
     */
    public List<MarketingStatus> getMarketingStatus() { 
      if (this.marketingStatus == null)
        this.marketingStatus = new ArrayList<MarketingStatus>();
      return this.marketingStatus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setMarketingStatus(List<MarketingStatus> theMarketingStatus) { 
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

    public PackagedProductDefinition addMarketingStatus(MarketingStatus t) { //3
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
     * @return {@link #copackagedIndicator} (Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.). This is the underlying object with id, value and extensions. The accessor "getCopackagedIndicator" gives direct access to the value
     */
    public BooleanType getCopackagedIndicatorElement() { 
      if (this.copackagedIndicator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.copackagedIndicator");
        else if (Configuration.doAutoCreate())
          this.copackagedIndicator = new BooleanType(); // bb
      return this.copackagedIndicator;
    }

    public boolean hasCopackagedIndicatorElement() { 
      return this.copackagedIndicator != null && !this.copackagedIndicator.isEmpty();
    }

    public boolean hasCopackagedIndicator() { 
      return this.copackagedIndicator != null && !this.copackagedIndicator.isEmpty();
    }

    /**
     * @param value {@link #copackagedIndicator} (Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.). This is the underlying object with id, value and extensions. The accessor "getCopackagedIndicator" gives direct access to the value
     */
    public PackagedProductDefinition setCopackagedIndicatorElement(BooleanType value) { 
      this.copackagedIndicator = value;
      return this;
    }

    /**
     * @return Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.
     */
    public boolean getCopackagedIndicator() { 
      return this.copackagedIndicator == null || this.copackagedIndicator.isEmpty() ? false : this.copackagedIndicator.getValue();
    }

    /**
     * @param value Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.
     */
    public PackagedProductDefinition setCopackagedIndicator(boolean value) { 
        if (this.copackagedIndicator == null)
          this.copackagedIndicator = new BooleanType();
        this.copackagedIndicator.setValue(value);
      return this;
    }

    /**
     * @return {@link #manufacturer} (Manufacturer of this package type. When there are multiple it means these are all possible manufacturers.)
     */
    public List<Reference> getManufacturer() { 
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      return this.manufacturer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setManufacturer(List<Reference> theManufacturer) { 
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

    public PackagedProductDefinition addManufacturer(Reference t) { //3
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
     * @return {@link #attachedDocument} (Additional information or supporting documentation about the packaged product.)
     */
    public List<Reference> getAttachedDocument() { 
      if (this.attachedDocument == null)
        this.attachedDocument = new ArrayList<Reference>();
      return this.attachedDocument;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setAttachedDocument(List<Reference> theAttachedDocument) { 
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

    public PackagedProductDefinition addAttachedDocument(Reference t) { //3
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
     * @return {@link #packaging} (A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item).)
     */
    public PackagedProductDefinitionPackagingComponent getPackaging() { 
      if (this.packaging == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.packaging");
        else if (Configuration.doAutoCreate())
          this.packaging = new PackagedProductDefinitionPackagingComponent(); // cc
      return this.packaging;
    }

    public boolean hasPackaging() { 
      return this.packaging != null && !this.packaging.isEmpty();
    }

    /**
     * @param value {@link #packaging} (A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item).)
     */
    public PackagedProductDefinition setPackaging(PackagedProductDefinitionPackagingComponent value) { 
      this.packaging = value;
      return this;
    }

    /**
     * @return {@link #characteristic} (Allows the key features to be recorded, such as "hospital pack", "nurse prescribable", "calendar pack".)
     */
    public List<PackagedProductDefinitionPackagingPropertyComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setCharacteristic(List<PackagedProductDefinitionPackagingPropertyComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (PackagedProductDefinitionPackagingPropertyComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PackagedProductDefinitionPackagingPropertyComponent addCharacteristic() { //3
      PackagedProductDefinitionPackagingPropertyComponent t = new PackagedProductDefinitionPackagingPropertyComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
      this.characteristic.add(t);
      return t;
    }

    public PackagedProductDefinition addCharacteristic(PackagedProductDefinitionPackagingPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public PackagedProductDefinitionPackagingPropertyComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier for this package as whole - not the the content of the package. Unique instance identifiers assigned to a package by manufacturers, regulators, drug catalogue custodians or other organizations.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("name", "string", "A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.", 0, 1, name));
        children.add(new Property("type", "CodeableConcept", "A high level category e.g. medicinal product, raw material, shipping/transport container, etc.", 0, 1, type));
        children.add(new Property("packageFor", "Reference(MedicinalProductDefinition)", "The product this package model relates to, not the contents of the package (for which see package.containedItem).", 0, java.lang.Integer.MAX_VALUE, packageFor));
        children.add(new Property("status", "CodeableConcept", "The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status.", 0, 1, status));
        children.add(new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate));
        children.add(new Property("containedItemQuantity", "Quantity", "A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. This attribute differs from containedItem.amount in that it can give a single aggregated count of all tablet types in a pack, even when these are different manufactured items. For example a pill pack of 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that the different item types in one pack type can be counted (e.g. a count of vials and count of syringes). Each repeat must have different units, so that it is clear what the different sets of counted items are, and it is not intended to allow different counts of similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this resource.", 0, java.lang.Integer.MAX_VALUE, containedItemQuantity));
        children.add(new Property("description", "markdown", "Textual description. Note that this is not the name of the package or product.", 0, 1, description));
        children.add(new Property("legalStatusOfSupply", "", "The legal status of supply of the packaged item as classified by the regulator.", 0, java.lang.Integer.MAX_VALUE, legalStatusOfSupply));
        children.add(new Property("marketingStatus", "MarketingStatus", "Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.", 0, java.lang.Integer.MAX_VALUE, marketingStatus));
        children.add(new Property("copackagedIndicator", "boolean", "Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.", 0, 1, copackagedIndicator));
        children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of this package type. When there are multiple it means these are all possible manufacturers.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("attachedDocument", "Reference(DocumentReference)", "Additional information or supporting documentation about the packaged product.", 0, java.lang.Integer.MAX_VALUE, attachedDocument));
        children.add(new Property("packaging", "", "A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item).", 0, 1, packaging));
        children.add(new Property("characteristic", "@PackagedProductDefinition.packaging.property", "Allows the key features to be recorded, such as \"hospital pack\", \"nurse prescribable\", \"calendar pack\".", 0, java.lang.Integer.MAX_VALUE, characteristic));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier for this package as whole - not the the content of the package. Unique instance identifiers assigned to a package by manufacturers, regulators, drug catalogue custodians or other organizations.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3373707: /*name*/  return new Property("name", "string", "A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.", 0, 1, name);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A high level category e.g. medicinal product, raw material, shipping/transport container, etc.", 0, 1, type);
        case 29307555: /*packageFor*/  return new Property("packageFor", "Reference(MedicinalProductDefinition)", "The product this package model relates to, not the contents of the package (for which see package.containedItem).", 0, java.lang.Integer.MAX_VALUE, packageFor);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status.", 0, 1, status);
        case 247524032: /*statusDate*/  return new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate);
        case -1686893359: /*containedItemQuantity*/  return new Property("containedItemQuantity", "Quantity", "A total of the complete count of contained items of a particular type/form, independent of sub-packaging or organization. This can be considered as the pack size. This attribute differs from containedItem.amount in that it can give a single aggregated count of all tablet types in a pack, even when these are different manufactured items. For example a pill pack of 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that the different item types in one pack type can be counted (e.g. a count of vials and count of syringes). Each repeat must have different units, so that it is clear what the different sets of counted items are, and it is not intended to allow different counts of similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this resource.", 0, java.lang.Integer.MAX_VALUE, containedItemQuantity);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Textual description. Note that this is not the name of the package or product.", 0, 1, description);
        case -844874031: /*legalStatusOfSupply*/  return new Property("legalStatusOfSupply", "", "The legal status of supply of the packaged item as classified by the regulator.", 0, java.lang.Integer.MAX_VALUE, legalStatusOfSupply);
        case 70767032: /*marketingStatus*/  return new Property("marketingStatus", "MarketingStatus", "Allows specifying that an item is on the market for sale, or that it is not available, and the dates and locations associated.", 0, java.lang.Integer.MAX_VALUE, marketingStatus);
        case -1638663195: /*copackagedIndicator*/  return new Property("copackagedIndicator", "boolean", "Identifies if the package contains different items, such as when a drug product is supplied with another item e.g. a diluent or adjuvant.", 0, 1, copackagedIndicator);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of this package type. When there are multiple it means these are all possible manufacturers.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case -513945889: /*attachedDocument*/  return new Property("attachedDocument", "Reference(DocumentReference)", "Additional information or supporting documentation about the packaged product.", 0, java.lang.Integer.MAX_VALUE, attachedDocument);
        case 1802065795: /*packaging*/  return new Property("packaging", "", "A packaging item, as a container for medically related items, possibly with other packaging items within, or a packaging component, such as bottle cap (which is not a device or a medication manufactured item).", 0, 1, packaging);
        case 366313883: /*characteristic*/  return new Property("characteristic", "@PackagedProductDefinition.packaging.property", "Allows the key features to be recorded, such as \"hospital pack\", \"nurse prescribable\", \"calendar pack\".", 0, java.lang.Integer.MAX_VALUE, characteristic);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 29307555: /*packageFor*/ return this.packageFor == null ? new Base[0] : this.packageFor.toArray(new Base[this.packageFor.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : new Base[] {this.statusDate}; // DateTimeType
        case -1686893359: /*containedItemQuantity*/ return this.containedItemQuantity == null ? new Base[0] : this.containedItemQuantity.toArray(new Base[this.containedItemQuantity.size()]); // Quantity
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -844874031: /*legalStatusOfSupply*/ return this.legalStatusOfSupply == null ? new Base[0] : this.legalStatusOfSupply.toArray(new Base[this.legalStatusOfSupply.size()]); // PackagedProductDefinitionLegalStatusOfSupplyComponent
        case 70767032: /*marketingStatus*/ return this.marketingStatus == null ? new Base[0] : this.marketingStatus.toArray(new Base[this.marketingStatus.size()]); // MarketingStatus
        case -1638663195: /*copackagedIndicator*/ return this.copackagedIndicator == null ? new Base[0] : new Base[] {this.copackagedIndicator}; // BooleanType
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -513945889: /*attachedDocument*/ return this.attachedDocument == null ? new Base[0] : this.attachedDocument.toArray(new Base[this.attachedDocument.size()]); // Reference
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : new Base[] {this.packaging}; // PackagedProductDefinitionPackagingComponent
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // PackagedProductDefinitionPackagingPropertyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 29307555: // packageFor
          this.getPackageFor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1686893359: // containedItemQuantity
          this.getContainedItemQuantity().add(TypeConvertor.castToQuantity(value)); // Quantity
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -844874031: // legalStatusOfSupply
          this.getLegalStatusOfSupply().add((PackagedProductDefinitionLegalStatusOfSupplyComponent) value); // PackagedProductDefinitionLegalStatusOfSupplyComponent
          return value;
        case 70767032: // marketingStatus
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value)); // MarketingStatus
          return value;
        case -1638663195: // copackagedIndicator
          this.copackagedIndicator = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -513945889: // attachedDocument
          this.getAttachedDocument().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1802065795: // packaging
          this.packaging = (PackagedProductDefinitionPackagingComponent) value; // PackagedProductDefinitionPackagingComponent
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((PackagedProductDefinitionPackagingPropertyComponent) value); // PackagedProductDefinitionPackagingPropertyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("packageFor")) {
          this.getPackageFor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statusDate")) {
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("containedItemQuantity")) {
          this.getContainedItemQuantity().add(TypeConvertor.castToQuantity(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("legalStatusOfSupply")) {
          this.getLegalStatusOfSupply().add((PackagedProductDefinitionLegalStatusOfSupplyComponent) value);
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().add(TypeConvertor.castToMarketingStatus(value));
        } else if (name.equals("copackagedIndicator")) {
          this.copackagedIndicator = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("attachedDocument")) {
          this.getAttachedDocument().add(TypeConvertor.castToReference(value));
        } else if (name.equals("packaging")) {
          this.packaging = (PackagedProductDefinitionPackagingComponent) value; // PackagedProductDefinitionPackagingComponent
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((PackagedProductDefinitionPackagingPropertyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3373707:  return getNameElement();
        case 3575610:  return getType();
        case 29307555:  return addPackageFor(); 
        case -892481550:  return getStatus();
        case 247524032:  return getStatusDateElement();
        case -1686893359:  return addContainedItemQuantity(); 
        case -1724546052:  return getDescriptionElement();
        case -844874031:  return addLegalStatusOfSupply(); 
        case 70767032:  return addMarketingStatus(); 
        case -1638663195:  return getCopackagedIndicatorElement();
        case -1969347631:  return addManufacturer(); 
        case -513945889:  return addAttachedDocument(); 
        case 1802065795:  return getPackaging();
        case 366313883:  return addCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 29307555: /*packageFor*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {"dateTime"};
        case -1686893359: /*containedItemQuantity*/ return new String[] {"Quantity"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -844874031: /*legalStatusOfSupply*/ return new String[] {};
        case 70767032: /*marketingStatus*/ return new String[] {"MarketingStatus"};
        case -1638663195: /*copackagedIndicator*/ return new String[] {"boolean"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -513945889: /*attachedDocument*/ return new String[] {"Reference"};
        case 1802065795: /*packaging*/ return new String[] {};
        case 366313883: /*characteristic*/ return new String[] {"@PackagedProductDefinition.packaging.property"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.name");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("packageFor")) {
          return addPackageFor();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.statusDate");
        }
        else if (name.equals("containedItemQuantity")) {
          return addContainedItemQuantity();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.description");
        }
        else if (name.equals("legalStatusOfSupply")) {
          return addLegalStatusOfSupply();
        }
        else if (name.equals("marketingStatus")) {
          return addMarketingStatus();
        }
        else if (name.equals("copackagedIndicator")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.copackagedIndicator");
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("attachedDocument")) {
          return addAttachedDocument();
        }
        else if (name.equals("packaging")) {
          this.packaging = new PackagedProductDefinitionPackagingComponent();
          return this.packaging;
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PackagedProductDefinition";

  }

      public PackagedProductDefinition copy() {
        PackagedProductDefinition dst = new PackagedProductDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        if (packageFor != null) {
          dst.packageFor = new ArrayList<Reference>();
          for (Reference i : packageFor)
            dst.packageFor.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusDate = statusDate == null ? null : statusDate.copy();
        if (containedItemQuantity != null) {
          dst.containedItemQuantity = new ArrayList<Quantity>();
          for (Quantity i : containedItemQuantity)
            dst.containedItemQuantity.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (legalStatusOfSupply != null) {
          dst.legalStatusOfSupply = new ArrayList<PackagedProductDefinitionLegalStatusOfSupplyComponent>();
          for (PackagedProductDefinitionLegalStatusOfSupplyComponent i : legalStatusOfSupply)
            dst.legalStatusOfSupply.add(i.copy());
        };
        if (marketingStatus != null) {
          dst.marketingStatus = new ArrayList<MarketingStatus>();
          for (MarketingStatus i : marketingStatus)
            dst.marketingStatus.add(i.copy());
        };
        dst.copackagedIndicator = copackagedIndicator == null ? null : copackagedIndicator.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (attachedDocument != null) {
          dst.attachedDocument = new ArrayList<Reference>();
          for (Reference i : attachedDocument)
            dst.attachedDocument.add(i.copy());
        };
        dst.packaging = packaging == null ? null : packaging.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<PackagedProductDefinitionPackagingPropertyComponent>();
          for (PackagedProductDefinitionPackagingPropertyComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
      }

      protected PackagedProductDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinition))
          return false;
        PackagedProductDefinition o = (PackagedProductDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true) && compareDeep(type, o.type, true)
           && compareDeep(packageFor, o.packageFor, true) && compareDeep(status, o.status, true) && compareDeep(statusDate, o.statusDate, true)
           && compareDeep(containedItemQuantity, o.containedItemQuantity, true) && compareDeep(description, o.description, true)
           && compareDeep(legalStatusOfSupply, o.legalStatusOfSupply, true) && compareDeep(marketingStatus, o.marketingStatus, true)
           && compareDeep(copackagedIndicator, o.copackagedIndicator, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(attachedDocument, o.attachedDocument, true) && compareDeep(packaging, o.packaging, true)
           && compareDeep(characteristic, o.characteristic, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinition))
          return false;
        PackagedProductDefinition o = (PackagedProductDefinition) other_;
        return compareValues(name, o.name, true) && compareValues(statusDate, o.statusDate, true) && compareValues(description, o.description, true)
           && compareValues(copackagedIndicator, o.copackagedIndicator, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, name, type, packageFor
          , status, statusDate, containedItemQuantity, description, legalStatusOfSupply, marketingStatus
          , copackagedIndicator, manufacturer, attachedDocument, packaging, characteristic);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PackagedProductDefinition;
   }

 /**
   * Search parameter: <b>biological</b>
   * <p>
   * Description: <b>A biologically derived product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="biological", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A biologically derived product within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_BIOLOGICAL = "biological";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>biological</b>
   * <p>
   * Description: <b>A biologically derived product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BIOLOGICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BIOLOGICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:biological</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BIOLOGICAL = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:biological").toLocked();

 /**
   * Search parameter: <b>contained-item</b>
   * <p>
   * Description: <b>Any of the contained items within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contained-item", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="Any of the contained items within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_CONTAINED_ITEM = "contained-item";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contained-item</b>
   * <p>
   * Description: <b>Any of the contained items within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTAINED_ITEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTAINED_ITEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:contained-item</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTAINED_ITEM = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:contained-item").toLocked();

 /**
   * Search parameter: <b>device</b>
   * <p>
   * Description: <b>A device within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A device within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_DEVICE = "device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device</b>
   * <p>
   * Description: <b>A device within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:device</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEVICE = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:device").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="PackagedProductDefinition.identifier", description="Unique identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>manufactured-item</b>
   * <p>
   * Description: <b>A manufactured item of medication within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufactured-item", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A manufactured item of medication within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_MANUFACTURED_ITEM = "manufactured-item";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufactured-item</b>
   * <p>
   * Description: <b>A manufactured item of medication within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURED_ITEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURED_ITEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:manufactured-item</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURED_ITEM = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:manufactured-item").toLocked();

 /**
   * Search parameter: <b>medication</b>
   * <p>
   * Description: <b>A manufactured item of medication within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="medication", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A manufactured item of medication within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_MEDICATION = "medication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>medication</b>
   * <p>
   * Description: <b>A manufactured item of medication within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEDICATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MEDICATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:medication</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEDICATION = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:medication").toLocked();

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="PackagedProductDefinition.name", description="A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.", type="token" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A name for this package. Typically what it would be listed as in a drug formulary or catalogue, inventory etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam NAME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_NAME);

 /**
   * Search parameter: <b>nutrition</b>
   * <p>
   * Description: <b>A nutrition product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="nutrition", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A nutrition product within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_NUTRITION = "nutrition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>nutrition</b>
   * <p>
   * Description: <b>A nutrition product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam NUTRITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_NUTRITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:nutrition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_NUTRITION = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:nutrition").toLocked();

 /**
   * Search parameter: <b>package-for</b>
   * <p>
   * Description: <b>The product that this is a pack for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packageFor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="package-for", path="PackagedProductDefinition.packageFor", description="The product that this is a pack for", type="reference", target={MedicinalProductDefinition.class } )
  public static final String SP_PACKAGE_FOR = "package-for";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>package-for</b>
   * <p>
   * Description: <b>The product that this is a pack for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packageFor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PACKAGE_FOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PACKAGE_FOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:package-for</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PACKAGE_FOR = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:package-for").toLocked();

 /**
   * Search parameter: <b>package</b>
   * <p>
   * Description: <b>A complete packaged product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="package", path="PackagedProductDefinition.packaging.containedItem.item.reference", description="A complete packaged product within this packaged product", type="reference", target={BiologicallyDerivedProduct.class, DeviceDefinition.class, ManufacturedItemDefinition.class, NutritionProduct.class, PackagedProductDefinition.class } )
  public static final String SP_PACKAGE = "package";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>package</b>
   * <p>
   * Description: <b>A complete packaged product within this packaged product</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.packaging.containedItem.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PACKAGE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PACKAGE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:package</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PACKAGE = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:package").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="PackagedProductDefinition.status", description="The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status within the lifecycle of this item. A high level status, this is not intended to duplicate details carried elsewhere such as legal status, or authorization or marketing status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PackagedProductDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

