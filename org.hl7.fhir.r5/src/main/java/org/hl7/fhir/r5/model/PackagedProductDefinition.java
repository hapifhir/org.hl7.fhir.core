package org.hl7.fhir.r5.model;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;

import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.utilities.Utilities;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
/**
 * A medicinal product in a container or package.
 */
@ResourceDef(name="PackagedProductDefinition", profile="http://hl7.org/fhir/StructureDefinition/PackagedProductDefinition")
public class PackagedProductDefinition extends DomainResource {

    @Block()
    public static class PackagedProductDefinitionBatchIdentifierComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A number appearing on the outer packaging of a specific batch.
         */
        @Child(name = "outerPackaging", type = {Identifier.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A number appearing on the outer packaging of a specific batch", formalDefinition="A number appearing on the outer packaging of a specific batch." )
        protected Identifier outerPackaging;

        /**
         * A number appearing on the immediate packaging (and not the outer packaging).
         */
        @Child(name = "immediatePackaging", type = {Identifier.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A number appearing on the immediate packaging (and not the outer packaging)", formalDefinition="A number appearing on the immediate packaging (and not the outer packaging)." )
        protected Identifier immediatePackaging;

        private static final long serialVersionUID = 1187365068L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionBatchIdentifierComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PackagedProductDefinitionBatchIdentifierComponent(Identifier outerPackaging) {
        super();
        this.outerPackaging = outerPackaging;
      }

        /**
         * @return {@link #outerPackaging} (A number appearing on the outer packaging of a specific batch.)
         */
        public Identifier getOuterPackaging() { 
          if (this.outerPackaging == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionBatchIdentifierComponent.outerPackaging");
            else if (Configuration.doAutoCreate())
              this.outerPackaging = new Identifier(); // cc
          return this.outerPackaging;
        }

        public boolean hasOuterPackaging() { 
          return this.outerPackaging != null && !this.outerPackaging.isEmpty();
        }

        /**
         * @param value {@link #outerPackaging} (A number appearing on the outer packaging of a specific batch.)
         */
        public PackagedProductDefinitionBatchIdentifierComponent setOuterPackaging(Identifier value) { 
          this.outerPackaging = value;
          return this;
        }

        /**
         * @return {@link #immediatePackaging} (A number appearing on the immediate packaging (and not the outer packaging).)
         */
        public Identifier getImmediatePackaging() { 
          if (this.immediatePackaging == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionBatchIdentifierComponent.immediatePackaging");
            else if (Configuration.doAutoCreate())
              this.immediatePackaging = new Identifier(); // cc
          return this.immediatePackaging;
        }

        public boolean hasImmediatePackaging() { 
          return this.immediatePackaging != null && !this.immediatePackaging.isEmpty();
        }

        /**
         * @param value {@link #immediatePackaging} (A number appearing on the immediate packaging (and not the outer packaging).)
         */
        public PackagedProductDefinitionBatchIdentifierComponent setImmediatePackaging(Identifier value) { 
          this.immediatePackaging = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("outerPackaging", "Identifier", "A number appearing on the outer packaging of a specific batch.", 0, 1, outerPackaging));
          children.add(new Property("immediatePackaging", "Identifier", "A number appearing on the immediate packaging (and not the outer packaging).", 0, 1, immediatePackaging));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -682249912: /*outerPackaging*/  return new Property("outerPackaging", "Identifier", "A number appearing on the outer packaging of a specific batch.", 0, 1, outerPackaging);
          case 721147602: /*immediatePackaging*/  return new Property("immediatePackaging", "Identifier", "A number appearing on the immediate packaging (and not the outer packaging).", 0, 1, immediatePackaging);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -682249912: /*outerPackaging*/ return this.outerPackaging == null ? new Base[0] : new Base[] {this.outerPackaging}; // Identifier
        case 721147602: /*immediatePackaging*/ return this.immediatePackaging == null ? new Base[0] : new Base[] {this.immediatePackaging}; // Identifier
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -682249912: // outerPackaging
          this.outerPackaging = castToIdentifier(value); // Identifier
          return value;
        case 721147602: // immediatePackaging
          this.immediatePackaging = castToIdentifier(value); // Identifier
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("outerPackaging")) {
          this.outerPackaging = castToIdentifier(value); // Identifier
        } else if (name.equals("immediatePackaging")) {
          this.immediatePackaging = castToIdentifier(value); // Identifier
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -682249912:  return getOuterPackaging();
        case 721147602:  return getImmediatePackaging();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -682249912: /*outerPackaging*/ return new String[] {"Identifier"};
        case 721147602: /*immediatePackaging*/ return new String[] {"Identifier"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("outerPackaging")) {
          this.outerPackaging = new Identifier();
          return this.outerPackaging;
        }
        else if (name.equals("immediatePackaging")) {
          this.immediatePackaging = new Identifier();
          return this.immediatePackaging;
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionBatchIdentifierComponent copy() {
        PackagedProductDefinitionBatchIdentifierComponent dst = new PackagedProductDefinitionBatchIdentifierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionBatchIdentifierComponent dst) {
        super.copyValues(dst);
        dst.outerPackaging = outerPackaging == null ? null : outerPackaging.copy();
        dst.immediatePackaging = immediatePackaging == null ? null : immediatePackaging.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionBatchIdentifierComponent))
          return false;
        PackagedProductDefinitionBatchIdentifierComponent o = (PackagedProductDefinitionBatchIdentifierComponent) other_;
        return compareDeep(outerPackaging, o.outerPackaging, true) && compareDeep(immediatePackaging, o.immediatePackaging, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionBatchIdentifierComponent))
          return false;
        PackagedProductDefinitionBatchIdentifierComponent o = (PackagedProductDefinitionBatchIdentifierComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(outerPackaging, immediatePackaging
          );
      }

  public String fhirType() {
    return "PackagedProductDefinition.batchIdentifier";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Including possibly Data Carrier Identifier.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Including possibly Data Carrier Identifier", formalDefinition="Including possibly Data Carrier Identifier." )
        protected List<Identifier> identifier;

        /**
         * The physical type of the container of the medicine.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The physical type of the container of the medicine", formalDefinition="The physical type of the container of the medicine." )
        protected CodeableConcept type;

        /**
         * The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1", formalDefinition="The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1." )
        protected Quantity quantity;

        /**
         * Material type of the package item.
         */
        @Child(name = "material", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Material type of the package item", formalDefinition="Material type of the package item." )
        protected List<CodeableConcept> material;

        /**
         * A possible alternate material for the packaging.
         */
        @Child(name = "alternateMaterial", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A possible alternate material for the packaging", formalDefinition="A possible alternate material for the packaging." )
        protected List<CodeableConcept> alternateMaterial;

        /**
         * Shelf Life and storage information.
         */
        @Child(name = "shelfLifeStorage", type = {ProductShelfLife.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Shelf Life and storage information", formalDefinition="Shelf Life and storage information." )
        protected List<ProductShelfLife> shelfLifeStorage;

        /**
         * Manufacturer of this Package Item.
         */
        @Child(name = "manufacturer", type = {Organization.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Manufacturer of this Package Item", formalDefinition="Manufacturer of this Package Item." )
        protected List<Reference> manufacturer;

        /**
         * General characteristics of this item.
         */
        @Child(name = "characteristic", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="General characteristics of this item", formalDefinition="General characteristics of this item." )
        protected List<PackagedProductDefinitionPackageCharacteristicComponent> characteristic;

        /**
         * The item(s) within the packaging).
         */
        @Child(name = "containedItem", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The item(s) within the packaging)", formalDefinition="The item(s) within the packaging)." )
        protected List<PackagedProductDefinitionPackageContainedItemComponent> containedItem;

        /**
         * Allows containers within containers.
         */
        @Child(name = "package", type = {PackagedProductDefinitionPackageComponent.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Allows containers within containers", formalDefinition="Allows containers within containers." )
        protected List<PackagedProductDefinitionPackageComponent> package_;

        private static final long serialVersionUID = 8053245L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackageComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Including possibly Data Carrier Identifier.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public PackagedProductDefinitionPackageComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #type} (The physical type of the container of the medicine.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackageComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The physical type of the container of the medicine.)
         */
        public PackagedProductDefinitionPackageComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackageComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1.)
         */
        public PackagedProductDefinitionPackageComponent setQuantity(Quantity value) { 
          this.quantity = value;
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
        public PackagedProductDefinitionPackageComponent setMaterial(List<CodeableConcept> theMaterial) { 
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

        public PackagedProductDefinitionPackageComponent addMaterial(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.material == null)
            this.material = new ArrayList<CodeableConcept>();
          this.material.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #material}, creating it if it does not already exist
         */
        public CodeableConcept getMaterialFirstRep() { 
          if (getMaterial().isEmpty()) {
            addMaterial();
          }
          return getMaterial().get(0);
        }

        /**
         * @return {@link #alternateMaterial} (A possible alternate material for the packaging.)
         */
        public List<CodeableConcept> getAlternateMaterial() { 
          if (this.alternateMaterial == null)
            this.alternateMaterial = new ArrayList<CodeableConcept>();
          return this.alternateMaterial;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setAlternateMaterial(List<CodeableConcept> theAlternateMaterial) { 
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

        public PackagedProductDefinitionPackageComponent addAlternateMaterial(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.alternateMaterial == null)
            this.alternateMaterial = new ArrayList<CodeableConcept>();
          this.alternateMaterial.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #alternateMaterial}, creating it if it does not already exist
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
        public PackagedProductDefinitionPackageComponent setShelfLifeStorage(List<ProductShelfLife> theShelfLifeStorage) { 
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

        public PackagedProductDefinitionPackageComponent addShelfLifeStorage(ProductShelfLife t) { //3
          if (t == null)
            return this;
          if (this.shelfLifeStorage == null)
            this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          this.shelfLifeStorage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #shelfLifeStorage}, creating it if it does not already exist
         */
        public ProductShelfLife getShelfLifeStorageFirstRep() { 
          if (getShelfLifeStorage().isEmpty()) {
            addShelfLifeStorage();
          }
          return getShelfLifeStorage().get(0);
        }

        /**
         * @return {@link #manufacturer} (Manufacturer of this Package Item.)
         */
        public List<Reference> getManufacturer() { 
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          return this.manufacturer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setManufacturer(List<Reference> theManufacturer) { 
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

        public PackagedProductDefinitionPackageComponent addManufacturer(Reference t) { //3
          if (t == null)
            return this;
          if (this.manufacturer == null)
            this.manufacturer = new ArrayList<Reference>();
          this.manufacturer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist
         */
        public Reference getManufacturerFirstRep() { 
          if (getManufacturer().isEmpty()) {
            addManufacturer();
          }
          return getManufacturer().get(0);
        }

        /**
         * @return {@link #characteristic} (General characteristics of this item.)
         */
        public List<PackagedProductDefinitionPackageCharacteristicComponent> getCharacteristic() { 
          if (this.characteristic == null)
            this.characteristic = new ArrayList<PackagedProductDefinitionPackageCharacteristicComponent>();
          return this.characteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setCharacteristic(List<PackagedProductDefinitionPackageCharacteristicComponent> theCharacteristic) { 
          this.characteristic = theCharacteristic;
          return this;
        }

        public boolean hasCharacteristic() { 
          if (this.characteristic == null)
            return false;
          for (PackagedProductDefinitionPackageCharacteristicComponent item : this.characteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackageCharacteristicComponent addCharacteristic() { //3
          PackagedProductDefinitionPackageCharacteristicComponent t = new PackagedProductDefinitionPackageCharacteristicComponent();
          if (this.characteristic == null)
            this.characteristic = new ArrayList<PackagedProductDefinitionPackageCharacteristicComponent>();
          this.characteristic.add(t);
          return t;
        }

        public PackagedProductDefinitionPackageComponent addCharacteristic(PackagedProductDefinitionPackageCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.characteristic == null)
            this.characteristic = new ArrayList<PackagedProductDefinitionPackageCharacteristicComponent>();
          this.characteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist
         */
        public PackagedProductDefinitionPackageCharacteristicComponent getCharacteristicFirstRep() { 
          if (getCharacteristic().isEmpty()) {
            addCharacteristic();
          }
          return getCharacteristic().get(0);
        }

        /**
         * @return {@link #containedItem} (The item(s) within the packaging).)
         */
        public List<PackagedProductDefinitionPackageContainedItemComponent> getContainedItem() { 
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackageContainedItemComponent>();
          return this.containedItem;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setContainedItem(List<PackagedProductDefinitionPackageContainedItemComponent> theContainedItem) { 
          this.containedItem = theContainedItem;
          return this;
        }

        public boolean hasContainedItem() { 
          if (this.containedItem == null)
            return false;
          for (PackagedProductDefinitionPackageContainedItemComponent item : this.containedItem)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackageContainedItemComponent addContainedItem() { //3
          PackagedProductDefinitionPackageContainedItemComponent t = new PackagedProductDefinitionPackageContainedItemComponent();
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackageContainedItemComponent>();
          this.containedItem.add(t);
          return t;
        }

        public PackagedProductDefinitionPackageComponent addContainedItem(PackagedProductDefinitionPackageContainedItemComponent t) { //3
          if (t == null)
            return this;
          if (this.containedItem == null)
            this.containedItem = new ArrayList<PackagedProductDefinitionPackageContainedItemComponent>();
          this.containedItem.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #containedItem}, creating it if it does not already exist
         */
        public PackagedProductDefinitionPackageContainedItemComponent getContainedItemFirstRep() { 
          if (getContainedItem().isEmpty()) {
            addContainedItem();
          }
          return getContainedItem().get(0);
        }

        /**
         * @return {@link #package_} (Allows containers within containers.)
         */
        public List<PackagedProductDefinitionPackageComponent> getPackage() { 
          if (this.package_ == null)
            this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
          return this.package_;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageComponent setPackage(List<PackagedProductDefinitionPackageComponent> thePackage) { 
          this.package_ = thePackage;
          return this;
        }

        public boolean hasPackage() { 
          if (this.package_ == null)
            return false;
          for (PackagedProductDefinitionPackageComponent item : this.package_)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagedProductDefinitionPackageComponent addPackage() { //3
          PackagedProductDefinitionPackageComponent t = new PackagedProductDefinitionPackageComponent();
          if (this.package_ == null)
            this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
          this.package_.add(t);
          return t;
        }

        public PackagedProductDefinitionPackageComponent addPackage(PackagedProductDefinitionPackageComponent t) { //3
          if (t == null)
            return this;
          if (this.package_ == null)
            this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
          this.package_.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #package_}, creating it if it does not already exist
         */
        public PackagedProductDefinitionPackageComponent getPackageFirstRep() { 
          if (getPackage().isEmpty()) {
            addPackage();
          }
          return getPackage().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Including possibly Data Carrier Identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("type", "CodeableConcept", "The physical type of the container of the medicine.", 0, 1, type));
          children.add(new Property("quantity", "Quantity", "The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1.", 0, 1, quantity));
          children.add(new Property("material", "CodeableConcept", "Material type of the package item.", 0, java.lang.Integer.MAX_VALUE, material));
          children.add(new Property("alternateMaterial", "CodeableConcept", "A possible alternate material for the packaging.", 0, java.lang.Integer.MAX_VALUE, alternateMaterial));
          children.add(new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage));
          children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of this Package Item.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
          children.add(new Property("characteristic", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, characteristic));
          children.add(new Property("containedItem", "", "The item(s) within the packaging).", 0, java.lang.Integer.MAX_VALUE, containedItem));
          children.add(new Property("package", "@PackagedProductDefinition.package", "Allows containers within containers.", 0, java.lang.Integer.MAX_VALUE, package_));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Including possibly Data Carrier Identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The physical type of the container of the medicine.", 0, 1, type);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The quantity of this package in the medicinal product, at the current level of packaging. If specified, the outermost level is always 1.", 0, 1, quantity);
          case 299066663: /*material*/  return new Property("material", "CodeableConcept", "Material type of the package item.", 0, java.lang.Integer.MAX_VALUE, material);
          case -1021448255: /*alternateMaterial*/  return new Property("alternateMaterial", "CodeableConcept", "A possible alternate material for the packaging.", 0, java.lang.Integer.MAX_VALUE, alternateMaterial);
          case 172049237: /*shelfLifeStorage*/  return new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage);
          case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of this Package Item.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
          case 366313883: /*characteristic*/  return new Property("characteristic", "", "General characteristics of this item.", 0, java.lang.Integer.MAX_VALUE, characteristic);
          case 1953679910: /*containedItem*/  return new Property("containedItem", "", "The item(s) within the packaging).", 0, java.lang.Integer.MAX_VALUE, containedItem);
          case -807062458: /*package*/  return new Property("package", "@PackagedProductDefinition.package", "Allows containers within containers.", 0, java.lang.Integer.MAX_VALUE, package_);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 299066663: /*material*/ return this.material == null ? new Base[0] : this.material.toArray(new Base[this.material.size()]); // CodeableConcept
        case -1021448255: /*alternateMaterial*/ return this.alternateMaterial == null ? new Base[0] : this.alternateMaterial.toArray(new Base[this.alternateMaterial.size()]); // CodeableConcept
        case 172049237: /*shelfLifeStorage*/ return this.shelfLifeStorage == null ? new Base[0] : this.shelfLifeStorage.toArray(new Base[this.shelfLifeStorage.size()]); // ProductShelfLife
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // PackagedProductDefinitionPackageCharacteristicComponent
        case 1953679910: /*containedItem*/ return this.containedItem == null ? new Base[0] : this.containedItem.toArray(new Base[this.containedItem.size()]); // PackagedProductDefinitionPackageContainedItemComponent
        case -807062458: /*package*/ return this.package_ == null ? new Base[0] : this.package_.toArray(new Base[this.package_.size()]); // PackagedProductDefinitionPackageComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case 3575610: // type
          this.type = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = castToQuantity(value); // Quantity
          return value;
        case 299066663: // material
          this.getMaterial().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1021448255: // alternateMaterial
          this.getAlternateMaterial().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 172049237: // shelfLifeStorage
          this.getShelfLifeStorage().add(castToProductShelfLife(value)); // ProductShelfLife
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(castToReference(value)); // Reference
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((PackagedProductDefinitionPackageCharacteristicComponent) value); // PackagedProductDefinitionPackageCharacteristicComponent
          return value;
        case 1953679910: // containedItem
          this.getContainedItem().add((PackagedProductDefinitionPackageContainedItemComponent) value); // PackagedProductDefinitionPackageContainedItemComponent
          return value;
        case -807062458: // package
          this.getPackage().add((PackagedProductDefinitionPackageComponent) value); // PackagedProductDefinitionPackageComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("type")) {
          this.type = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = castToQuantity(value); // Quantity
        } else if (name.equals("material")) {
          this.getMaterial().add(castToCodeableConcept(value));
        } else if (name.equals("alternateMaterial")) {
          this.getAlternateMaterial().add(castToCodeableConcept(value));
        } else if (name.equals("shelfLifeStorage")) {
          this.getShelfLifeStorage().add(castToProductShelfLife(value));
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(castToReference(value));
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((PackagedProductDefinitionPackageCharacteristicComponent) value);
        } else if (name.equals("containedItem")) {
          this.getContainedItem().add((PackagedProductDefinitionPackageContainedItemComponent) value);
        } else if (name.equals("package")) {
          this.getPackage().add((PackagedProductDefinitionPackageComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case 299066663:  return addMaterial(); 
        case -1021448255:  return addAlternateMaterial(); 
        case 172049237:  return addShelfLifeStorage(); 
        case -1969347631:  return addManufacturer(); 
        case 366313883:  return addCharacteristic(); 
        case 1953679910:  return addContainedItem(); 
        case -807062458:  return addPackage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 299066663: /*material*/ return new String[] {"CodeableConcept"};
        case -1021448255: /*alternateMaterial*/ return new String[] {"CodeableConcept"};
        case 172049237: /*shelfLifeStorage*/ return new String[] {"ProductShelfLife"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 366313883: /*characteristic*/ return new String[] {};
        case 1953679910: /*containedItem*/ return new String[] {};
        case -807062458: /*package*/ return new String[] {"@PackagedProductDefinition.package"};
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
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
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
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("containedItem")) {
          return addContainedItem();
        }
        else if (name.equals("package")) {
          return addPackage();
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionPackageComponent copy() {
        PackagedProductDefinitionPackageComponent dst = new PackagedProductDefinitionPackageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackageComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
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
        if (characteristic != null) {
          dst.characteristic = new ArrayList<PackagedProductDefinitionPackageCharacteristicComponent>();
          for (PackagedProductDefinitionPackageCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (containedItem != null) {
          dst.containedItem = new ArrayList<PackagedProductDefinitionPackageContainedItemComponent>();
          for (PackagedProductDefinitionPackageContainedItemComponent i : containedItem)
            dst.containedItem.add(i.copy());
        };
        if (package_ != null) {
          dst.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
          for (PackagedProductDefinitionPackageComponent i : package_)
            dst.package_.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageComponent))
          return false;
        PackagedProductDefinitionPackageComponent o = (PackagedProductDefinitionPackageComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(material, o.material, true) && compareDeep(alternateMaterial, o.alternateMaterial, true)
           && compareDeep(shelfLifeStorage, o.shelfLifeStorage, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(containedItem, o.containedItem, true)
           && compareDeep(package_, o.package_, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageComponent))
          return false;
        PackagedProductDefinitionPackageComponent o = (PackagedProductDefinitionPackageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, quantity
          , material, alternateMaterial, shelfLifeStorage, manufacturer, characteristic, containedItem
          , package_);
      }

  public String fhirType() {
    return "PackagedProductDefinition.package";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackageCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code expressing the type of characteristic.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code expressing the type of characteristic", formalDefinition="A code expressing the type of characteristic." )
        protected CodeableConcept code;

        /**
         * A value for the characteristic.
         */
        @Child(name = "value", type = {Coding.class, Quantity.class, StringType.class, DateType.class, BooleanType.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A value for the characteristic", formalDefinition="A value for the characteristic." )
        protected Type value;

        private static final long serialVersionUID = 884525025L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackageCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackageCharacteristicComponent(CodeableConcept code) {
        super();
        this.code = code;
      }

        /**
         * @return {@link #code} (A code expressing the type of characteristic.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagedProductDefinitionPackageCharacteristicComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code expressing the type of characteristic.)
         */
        public PackagedProductDefinitionPackageCharacteristicComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
         */
        public Type getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (A value for the characteristic.)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() { 
          return this != null && this.value instanceof Coding;
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
        public PackagedProductDefinitionPackageCharacteristicComponent setValue(Type value) { 
          if (value != null && !(value instanceof Coding || value instanceof Quantity || value instanceof StringType || value instanceof DateType || value instanceof BooleanType || value instanceof Attachment))
            throw new Error("Not the right type for PackagedProductDefinition.package.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, code));
          children.add(new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code expressing the type of characteristic.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Coding|Quantity|string|date|boolean|Attachment", "A value for the characteristic.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // Type
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = castToType(value); // Type
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = castToType(value); // Type
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Coding", "Quantity", "string", "date", "boolean", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
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

      public PackagedProductDefinitionPackageCharacteristicComponent copy() {
        PackagedProductDefinitionPackageCharacteristicComponent dst = new PackagedProductDefinitionPackageCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackageCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageCharacteristicComponent))
          return false;
        PackagedProductDefinitionPackageCharacteristicComponent o = (PackagedProductDefinitionPackageCharacteristicComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageCharacteristicComponent))
          return false;
        PackagedProductDefinitionPackageCharacteristicComponent o = (PackagedProductDefinitionPackageCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value);
      }

  public String fhirType() {
    return "PackagedProductDefinition.package.characteristic";

  }

  }

    @Block()
    public static class PackagedProductDefinitionPackageContainedItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The manufactured item or device as contained in the packaged medicinal product.
         */
        @Child(name = "item", type = {ManufacturedItemDefinition.class, DeviceDefinition.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The manufactured item or device as contained in the packaged medicinal product", formalDefinition="The manufactured item or device as contained in the packaged medicinal product." )
        protected List<Reference> item;

        /**
         * The number of this type of item within this packaging.
         */
        @Child(name = "amount", type = {Quantity.class, IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The number of this type of item within this packaging", formalDefinition="The number of this type of item within this packaging." )
        protected Type amount;

        private static final long serialVersionUID = 656616688L;

    /**
     * Constructor
     */
      public PackagedProductDefinitionPackageContainedItemComponent() {
        super();
      }

        /**
         * @return {@link #item} (The manufactured item or device as contained in the packaged medicinal product.)
         */
        public List<Reference> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<Reference>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagedProductDefinitionPackageContainedItemComponent setItem(List<Reference> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (Reference item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addItem() { //3
          Reference t = new Reference();
          if (this.item == null)
            this.item = new ArrayList<Reference>();
          this.item.add(t);
          return t;
        }

        public PackagedProductDefinitionPackageContainedItemComponent addItem(Reference t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<Reference>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist
         */
        public Reference getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        /**
         * @return {@link #amount} (The number of this type of item within this packaging.)
         */
        public Type getAmount() { 
          return this.amount;
        }

        /**
         * @return {@link #amount} (The number of this type of item within this packaging.)
         */
        public Quantity getAmountQuantity() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Quantity();
          if (!(this.amount instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Quantity) this.amount;
        }

        public boolean hasAmountQuantity() { 
          return this != null && this.amount instanceof Quantity;
        }

        /**
         * @return {@link #amount} (The number of this type of item within this packaging.)
         */
        public IntegerType getAmountIntegerType() throws FHIRException { 
          if (this.amount == null)
            this.amount = new IntegerType();
          if (!(this.amount instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (IntegerType) this.amount;
        }

        public boolean hasAmountIntegerType() { 
          return this != null && this.amount instanceof IntegerType;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (The number of this type of item within this packaging.)
         */
        public PackagedProductDefinitionPackageContainedItemComponent setAmount(Type value) { 
          if (value != null && !(value instanceof Quantity || value instanceof IntegerType))
            throw new Error("Not the right type for PackagedProductDefinition.package.containedItem.amount[x]: "+value.fhirType());
          this.amount = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "Reference(ManufacturedItemDefinition|DeviceDefinition)", "The manufactured item or device as contained in the packaged medicinal product.", 0, java.lang.Integer.MAX_VALUE, item));
          children.add(new Property("amount[x]", "Quantity|integer", "The number of this type of item within this packaging.", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "Reference(ManufacturedItemDefinition|DeviceDefinition)", "The manufactured item or device as contained in the packaged medicinal product.", 0, java.lang.Integer.MAX_VALUE, item);
          case 646780200: /*amount[x]*/  return new Property("amount[x]", "Quantity|integer", "The number of this type of item within this packaging.", 0, 1, amount);
          case -1413853096: /*amount*/  return new Property("amount[x]", "Quantity|integer", "The number of this type of item within this packaging.", 0, 1, amount);
          case 1664303363: /*amountQuantity*/  return new Property("amount[x]", "Quantity|integer", "The number of this type of item within this packaging.", 0, 1, amount);
          case 2053191110: /*amountInteger*/  return new Property("amount[x]", "Quantity|integer", "The number of this type of item within this packaging.", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // Reference
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Type
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.getItem().add(castToReference(value)); // Reference
          return value;
        case -1413853096: // amount
          this.amount = castToType(value); // Type
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.getItem().add(castToReference(value));
        } else if (name.equals("amount[x]")) {
          this.amount = castToType(value); // Type
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return addItem(); 
        case 646780200:  return getAmount();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference"};
        case -1413853096: /*amount*/ return new String[] {"Quantity", "integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          return addItem();
        }
        else if (name.equals("amountQuantity")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("amountInteger")) {
          this.amount = new IntegerType();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

      public PackagedProductDefinitionPackageContainedItemComponent copy() {
        PackagedProductDefinitionPackageContainedItemComponent dst = new PackagedProductDefinitionPackageContainedItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagedProductDefinitionPackageContainedItemComponent dst) {
        super.copyValues(dst);
        if (item != null) {
          dst.item = new ArrayList<Reference>();
          for (Reference i : item)
            dst.item.add(i.copy());
        };
        dst.amount = amount == null ? null : amount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageContainedItemComponent))
          return false;
        PackagedProductDefinitionPackageContainedItemComponent o = (PackagedProductDefinitionPackageContainedItemComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(amount, o.amount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinitionPackageContainedItemComponent))
          return false;
        PackagedProductDefinitionPackageContainedItemComponent o = (PackagedProductDefinitionPackageContainedItemComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, amount);
      }

  public String fhirType() {
    return "PackagedProductDefinition.package.containedItem";

  }

  }

    /**
     * Unique identifier.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier", formalDefinition="Unique identifier." )
    protected List<Identifier> identifier;

    /**
     * The product that this is a pack for.
     */
    @Child(name = "subject", type = {MedicinalProductDefinition.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The product that this is a pack for", formalDefinition="The product that this is a pack for." )
    protected List<Reference> subject;

    /**
     * Textual description.
     */
    @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Textual description", formalDefinition="Textual description." )
    protected StringType description;

    /**
     * The legal status of supply of the medicinal product as classified by the regulator.
     */
    @Child(name = "legalStatusOfSupply", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The legal status of supply of the medicinal product as classified by the regulator", formalDefinition="The legal status of supply of the medicinal product as classified by the regulator." )
    protected CodeableConcept legalStatusOfSupply;

    /**
     * Marketing information.
     */
    @Child(name = "marketingStatus", type = {MarketingStatus.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Marketing information", formalDefinition="Marketing information." )
    protected List<MarketingStatus> marketingStatus;

    /**
     * Manufacturer of this Package Item.
     */
    @Child(name = "marketingAuthorization", type = {RegulatedAuthorization.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of this Package Item", formalDefinition="Manufacturer of this Package Item." )
    protected Reference marketingAuthorization;

    /**
     * Manufacturer of this Package Item.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of this Package Item", formalDefinition="Manufacturer of this Package Item." )
    protected List<Reference> manufacturer;

    /**
     * Batch numbering.
     */
    @Child(name = "batchIdentifier", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Batch numbering", formalDefinition="Batch numbering." )
    protected List<PackagedProductDefinitionBatchIdentifierComponent> batchIdentifier;

    /**
     * A packaging item, as a contained for medicine, possibly with other packaging items within.
     */
    @Child(name = "package", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A packaging item, as a contained for medicine, possibly with other packaging items within", formalDefinition="A packaging item, as a contained for medicine, possibly with other packaging items within." )
    protected List<PackagedProductDefinitionPackageComponent> package_;

    private static final long serialVersionUID = -1124177667L;

  /**
   * Constructor
   */
    public PackagedProductDefinition() {
      super();
    }

    /**
     * @return {@link #identifier} (Unique identifier.)
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
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #subject} (The product that this is a pack for.)
     */
    public List<Reference> getSubject() { 
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      return this.subject;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setSubject(List<Reference> theSubject) { 
      this.subject = theSubject;
      return this;
    }

    public boolean hasSubject() { 
      if (this.subject == null)
        return false;
      for (Reference item : this.subject)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSubject() { //3
      Reference t = new Reference();
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return t;
    }

    public PackagedProductDefinition addSubject(Reference t) { //3
      if (t == null)
        return this;
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #subject}, creating it if it does not already exist
     */
    public Reference getSubjectFirstRep() { 
      if (getSubject().isEmpty()) {
        addSubject();
      }
      return getSubject().get(0);
    }

    /**
     * @return {@link #description} (Textual description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.description");
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
     * @param value {@link #description} (Textual description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public PackagedProductDefinition setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Textual description.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Textual description.
     */
    public PackagedProductDefinition setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #legalStatusOfSupply} (The legal status of supply of the medicinal product as classified by the regulator.)
     */
    public CodeableConcept getLegalStatusOfSupply() { 
      if (this.legalStatusOfSupply == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.legalStatusOfSupply");
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
    public PackagedProductDefinition setLegalStatusOfSupply(CodeableConcept value) { 
      this.legalStatusOfSupply = value;
      return this;
    }

    /**
     * @return {@link #marketingStatus} (Marketing information.)
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
     * @return The first repetition of repeating field {@link #marketingStatus}, creating it if it does not already exist
     */
    public MarketingStatus getMarketingStatusFirstRep() { 
      if (getMarketingStatus().isEmpty()) {
        addMarketingStatus();
      }
      return getMarketingStatus().get(0);
    }

    /**
     * @return {@link #marketingAuthorization} (Manufacturer of this Package Item.)
     */
    public Reference getMarketingAuthorization() { 
      if (this.marketingAuthorization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PackagedProductDefinition.marketingAuthorization");
        else if (Configuration.doAutoCreate())
          this.marketingAuthorization = new Reference(); // cc
      return this.marketingAuthorization;
    }

    public boolean hasMarketingAuthorization() { 
      return this.marketingAuthorization != null && !this.marketingAuthorization.isEmpty();
    }

    /**
     * @param value {@link #marketingAuthorization} (Manufacturer of this Package Item.)
     */
    public PackagedProductDefinition setMarketingAuthorization(Reference value) { 
      this.marketingAuthorization = value;
      return this;
    }

    /**
     * @return {@link #manufacturer} (Manufacturer of this Package Item.)
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
     * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist
     */
    public Reference getManufacturerFirstRep() { 
      if (getManufacturer().isEmpty()) {
        addManufacturer();
      }
      return getManufacturer().get(0);
    }

    /**
     * @return {@link #batchIdentifier} (Batch numbering.)
     */
    public List<PackagedProductDefinitionBatchIdentifierComponent> getBatchIdentifier() { 
      if (this.batchIdentifier == null)
        this.batchIdentifier = new ArrayList<PackagedProductDefinitionBatchIdentifierComponent>();
      return this.batchIdentifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setBatchIdentifier(List<PackagedProductDefinitionBatchIdentifierComponent> theBatchIdentifier) { 
      this.batchIdentifier = theBatchIdentifier;
      return this;
    }

    public boolean hasBatchIdentifier() { 
      if (this.batchIdentifier == null)
        return false;
      for (PackagedProductDefinitionBatchIdentifierComponent item : this.batchIdentifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PackagedProductDefinitionBatchIdentifierComponent addBatchIdentifier() { //3
      PackagedProductDefinitionBatchIdentifierComponent t = new PackagedProductDefinitionBatchIdentifierComponent();
      if (this.batchIdentifier == null)
        this.batchIdentifier = new ArrayList<PackagedProductDefinitionBatchIdentifierComponent>();
      this.batchIdentifier.add(t);
      return t;
    }

    public PackagedProductDefinition addBatchIdentifier(PackagedProductDefinitionBatchIdentifierComponent t) { //3
      if (t == null)
        return this;
      if (this.batchIdentifier == null)
        this.batchIdentifier = new ArrayList<PackagedProductDefinitionBatchIdentifierComponent>();
      this.batchIdentifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #batchIdentifier}, creating it if it does not already exist
     */
    public PackagedProductDefinitionBatchIdentifierComponent getBatchIdentifierFirstRep() { 
      if (getBatchIdentifier().isEmpty()) {
        addBatchIdentifier();
      }
      return getBatchIdentifier().get(0);
    }

    /**
     * @return {@link #package_} (A packaging item, as a contained for medicine, possibly with other packaging items within.)
     */
    public List<PackagedProductDefinitionPackageComponent> getPackage() { 
      if (this.package_ == null)
        this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
      return this.package_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PackagedProductDefinition setPackage(List<PackagedProductDefinitionPackageComponent> thePackage) { 
      this.package_ = thePackage;
      return this;
    }

    public boolean hasPackage() { 
      if (this.package_ == null)
        return false;
      for (PackagedProductDefinitionPackageComponent item : this.package_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PackagedProductDefinitionPackageComponent addPackage() { //3
      PackagedProductDefinitionPackageComponent t = new PackagedProductDefinitionPackageComponent();
      if (this.package_ == null)
        this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
      this.package_.add(t);
      return t;
    }

    public PackagedProductDefinition addPackage(PackagedProductDefinitionPackageComponent t) { //3
      if (t == null)
        return this;
      if (this.package_ == null)
        this.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
      this.package_.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #package_}, creating it if it does not already exist
     */
    public PackagedProductDefinitionPackageComponent getPackageFirstRep() { 
      if (getPackage().isEmpty()) {
        addPackage();
      }
      return getPackage().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("subject", "Reference(MedicinalProductDefinition)", "The product that this is a pack for.", 0, java.lang.Integer.MAX_VALUE, subject));
        children.add(new Property("description", "string", "Textual description.", 0, 1, description));
        children.add(new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply));
        children.add(new Property("marketingStatus", "MarketingStatus", "Marketing information.", 0, java.lang.Integer.MAX_VALUE, marketingStatus));
        children.add(new Property("marketingAuthorization", "Reference(RegulatedAuthorization)", "Manufacturer of this Package Item.", 0, 1, marketingAuthorization));
        children.add(new Property("manufacturer", "Reference(Organization)", "Manufacturer of this Package Item.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("batchIdentifier", "", "Batch numbering.", 0, java.lang.Integer.MAX_VALUE, batchIdentifier));
        children.add(new Property("package", "", "A packaging item, as a contained for medicine, possibly with other packaging items within.", 0, java.lang.Integer.MAX_VALUE, package_));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(MedicinalProductDefinition)", "The product that this is a pack for.", 0, java.lang.Integer.MAX_VALUE, subject);
        case -1724546052: /*description*/  return new Property("description", "string", "Textual description.", 0, 1, description);
        case -844874031: /*legalStatusOfSupply*/  return new Property("legalStatusOfSupply", "CodeableConcept", "The legal status of supply of the medicinal product as classified by the regulator.", 0, 1, legalStatusOfSupply);
        case 70767032: /*marketingStatus*/  return new Property("marketingStatus", "MarketingStatus", "Marketing information.", 0, java.lang.Integer.MAX_VALUE, marketingStatus);
        case 571831283: /*marketingAuthorization*/  return new Property("marketingAuthorization", "Reference(RegulatedAuthorization)", "Manufacturer of this Package Item.", 0, 1, marketingAuthorization);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Manufacturer of this Package Item.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case -1688395901: /*batchIdentifier*/  return new Property("batchIdentifier", "", "Batch numbering.", 0, java.lang.Integer.MAX_VALUE, batchIdentifier);
        case -807062458: /*package*/  return new Property("package", "", "A packaging item, as a contained for medicine, possibly with other packaging items within.", 0, java.lang.Integer.MAX_VALUE, package_);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : this.subject.toArray(new Base[this.subject.size()]); // Reference
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -844874031: /*legalStatusOfSupply*/ return this.legalStatusOfSupply == null ? new Base[0] : new Base[] {this.legalStatusOfSupply}; // CodeableConcept
        case 70767032: /*marketingStatus*/ return this.marketingStatus == null ? new Base[0] : this.marketingStatus.toArray(new Base[this.marketingStatus.size()]); // MarketingStatus
        case 571831283: /*marketingAuthorization*/ return this.marketingAuthorization == null ? new Base[0] : new Base[] {this.marketingAuthorization}; // Reference
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -1688395901: /*batchIdentifier*/ return this.batchIdentifier == null ? new Base[0] : this.batchIdentifier.toArray(new Base[this.batchIdentifier.size()]); // PackagedProductDefinitionBatchIdentifierComponent
        case -807062458: /*package*/ return this.package_ == null ? new Base[0] : this.package_.toArray(new Base[this.package_.size()]); // PackagedProductDefinitionPackageComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case -1867885268: // subject
          this.getSubject().add(castToReference(value)); // Reference
          return value;
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case -844874031: // legalStatusOfSupply
          this.legalStatusOfSupply = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 70767032: // marketingStatus
          this.getMarketingStatus().add(castToMarketingStatus(value)); // MarketingStatus
          return value;
        case 571831283: // marketingAuthorization
          this.marketingAuthorization = castToReference(value); // Reference
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(castToReference(value)); // Reference
          return value;
        case -1688395901: // batchIdentifier
          this.getBatchIdentifier().add((PackagedProductDefinitionBatchIdentifierComponent) value); // PackagedProductDefinitionBatchIdentifierComponent
          return value;
        case -807062458: // package
          this.getPackage().add((PackagedProductDefinitionPackageComponent) value); // PackagedProductDefinitionPackageComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("subject")) {
          this.getSubject().add(castToReference(value));
        } else if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("legalStatusOfSupply")) {
          this.legalStatusOfSupply = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("marketingStatus")) {
          this.getMarketingStatus().add(castToMarketingStatus(value));
        } else if (name.equals("marketingAuthorization")) {
          this.marketingAuthorization = castToReference(value); // Reference
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(castToReference(value));
        } else if (name.equals("batchIdentifier")) {
          this.getBatchIdentifier().add((PackagedProductDefinitionBatchIdentifierComponent) value);
        } else if (name.equals("package")) {
          this.getPackage().add((PackagedProductDefinitionPackageComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1867885268:  return addSubject(); 
        case -1724546052:  return getDescriptionElement();
        case -844874031:  return getLegalStatusOfSupply();
        case 70767032:  return addMarketingStatus(); 
        case 571831283:  return getMarketingAuthorization();
        case -1969347631:  return addManufacturer(); 
        case -1688395901:  return addBatchIdentifier(); 
        case -807062458:  return addPackage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -844874031: /*legalStatusOfSupply*/ return new String[] {"CodeableConcept"};
        case 70767032: /*marketingStatus*/ return new String[] {"MarketingStatus"};
        case 571831283: /*marketingAuthorization*/ return new String[] {"Reference"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -1688395901: /*batchIdentifier*/ return new String[] {};
        case -807062458: /*package*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("subject")) {
          return addSubject();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type PackagedProductDefinition.description");
        }
        else if (name.equals("legalStatusOfSupply")) {
          this.legalStatusOfSupply = new CodeableConcept();
          return this.legalStatusOfSupply;
        }
        else if (name.equals("marketingStatus")) {
          return addMarketingStatus();
        }
        else if (name.equals("marketingAuthorization")) {
          this.marketingAuthorization = new Reference();
          return this.marketingAuthorization;
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("batchIdentifier")) {
          return addBatchIdentifier();
        }
        else if (name.equals("package")) {
          return addPackage();
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
        if (subject != null) {
          dst.subject = new ArrayList<Reference>();
          for (Reference i : subject)
            dst.subject.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.legalStatusOfSupply = legalStatusOfSupply == null ? null : legalStatusOfSupply.copy();
        if (marketingStatus != null) {
          dst.marketingStatus = new ArrayList<MarketingStatus>();
          for (MarketingStatus i : marketingStatus)
            dst.marketingStatus.add(i.copy());
        };
        dst.marketingAuthorization = marketingAuthorization == null ? null : marketingAuthorization.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (batchIdentifier != null) {
          dst.batchIdentifier = new ArrayList<PackagedProductDefinitionBatchIdentifierComponent>();
          for (PackagedProductDefinitionBatchIdentifierComponent i : batchIdentifier)
            dst.batchIdentifier.add(i.copy());
        };
        if (package_ != null) {
          dst.package_ = new ArrayList<PackagedProductDefinitionPackageComponent>();
          for (PackagedProductDefinitionPackageComponent i : package_)
            dst.package_.add(i.copy());
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(subject, o.subject, true) && compareDeep(description, o.description, true)
           && compareDeep(legalStatusOfSupply, o.legalStatusOfSupply, true) && compareDeep(marketingStatus, o.marketingStatus, true)
           && compareDeep(marketingAuthorization, o.marketingAuthorization, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(batchIdentifier, o.batchIdentifier, true) && compareDeep(package_, o.package_, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagedProductDefinition))
          return false;
        PackagedProductDefinition o = (PackagedProductDefinition) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, subject, description
          , legalStatusOfSupply, marketingStatus, marketingAuthorization, manufacturer, batchIdentifier
          , package_);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PackagedProductDefinition;
   }

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
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The product that this is a pack for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="PackagedProductDefinition.subject", description="The product that this is a pack for", type="reference", target={MedicinalProductDefinition.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The product that this is a pack for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PackagedProductDefinition.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PackagedProductDefinition:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("PackagedProductDefinition:subject").toLocked();


}

