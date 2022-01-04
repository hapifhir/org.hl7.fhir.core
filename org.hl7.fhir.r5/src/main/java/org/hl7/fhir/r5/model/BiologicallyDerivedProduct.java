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
 * A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.
 */
@ResourceDef(name="BiologicallyDerivedProduct", profile="http://hl7.org/fhir/StructureDefinition/BiologicallyDerivedProduct")
public class BiologicallyDerivedProduct extends DomainResource {

    public enum BiologicallyDerivedProductCategory {
        /**
         * A collection of tissues joined in a structural unit to serve a common function.
         */
        ORGAN, 
        /**
         * An ensemble of similar cells and their extracellular matrix from the same origin that together carry out a specific function.
         */
        TISSUE, 
        /**
         * Body fluid.
         */
        FLUID, 
        /**
         * Collection of cells.
         */
        CELLS, 
        /**
         * Biological agent of unspecified type.
         */
        BIOLOGICALAGENT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static BiologicallyDerivedProductCategory fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("organ".equals(codeString))
          return ORGAN;
        if ("tissue".equals(codeString))
          return TISSUE;
        if ("fluid".equals(codeString))
          return FLUID;
        if ("cells".equals(codeString))
          return CELLS;
        if ("biologicalAgent".equals(codeString))
          return BIOLOGICALAGENT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown BiologicallyDerivedProductCategory code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ORGAN: return "organ";
            case TISSUE: return "tissue";
            case FLUID: return "fluid";
            case CELLS: return "cells";
            case BIOLOGICALAGENT: return "biologicalAgent";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ORGAN: return "http://hl7.org/fhir/product-category";
            case TISSUE: return "http://hl7.org/fhir/product-category";
            case FLUID: return "http://hl7.org/fhir/product-category";
            case CELLS: return "http://hl7.org/fhir/product-category";
            case BIOLOGICALAGENT: return "http://hl7.org/fhir/product-category";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ORGAN: return "A collection of tissues joined in a structural unit to serve a common function.";
            case TISSUE: return "An ensemble of similar cells and their extracellular matrix from the same origin that together carry out a specific function.";
            case FLUID: return "Body fluid.";
            case CELLS: return "Collection of cells.";
            case BIOLOGICALAGENT: return "Biological agent of unspecified type.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ORGAN: return "Organ";
            case TISSUE: return "Tissue";
            case FLUID: return "Fluid";
            case CELLS: return "Cells";
            case BIOLOGICALAGENT: return "BiologicalAgent";
            default: return "?";
          }
        }
    }

  public static class BiologicallyDerivedProductCategoryEnumFactory implements EnumFactory<BiologicallyDerivedProductCategory> {
    public BiologicallyDerivedProductCategory fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("organ".equals(codeString))
          return BiologicallyDerivedProductCategory.ORGAN;
        if ("tissue".equals(codeString))
          return BiologicallyDerivedProductCategory.TISSUE;
        if ("fluid".equals(codeString))
          return BiologicallyDerivedProductCategory.FLUID;
        if ("cells".equals(codeString))
          return BiologicallyDerivedProductCategory.CELLS;
        if ("biologicalAgent".equals(codeString))
          return BiologicallyDerivedProductCategory.BIOLOGICALAGENT;
        throw new IllegalArgumentException("Unknown BiologicallyDerivedProductCategory code '"+codeString+"'");
        }
        public Enumeration<BiologicallyDerivedProductCategory> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<BiologicallyDerivedProductCategory>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("organ".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductCategory>(this, BiologicallyDerivedProductCategory.ORGAN);
        if ("tissue".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductCategory>(this, BiologicallyDerivedProductCategory.TISSUE);
        if ("fluid".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductCategory>(this, BiologicallyDerivedProductCategory.FLUID);
        if ("cells".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductCategory>(this, BiologicallyDerivedProductCategory.CELLS);
        if ("biologicalAgent".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductCategory>(this, BiologicallyDerivedProductCategory.BIOLOGICALAGENT);
        throw new FHIRException("Unknown BiologicallyDerivedProductCategory code '"+codeString+"'");
        }
    public String toCode(BiologicallyDerivedProductCategory code) {
      if (code == BiologicallyDerivedProductCategory.ORGAN)
        return "organ";
      if (code == BiologicallyDerivedProductCategory.TISSUE)
        return "tissue";
      if (code == BiologicallyDerivedProductCategory.FLUID)
        return "fluid";
      if (code == BiologicallyDerivedProductCategory.CELLS)
        return "cells";
      if (code == BiologicallyDerivedProductCategory.BIOLOGICALAGENT)
        return "biologicalAgent";
      return "?";
      }
    public String toSystem(BiologicallyDerivedProductCategory code) {
      return code.getSystem();
      }
    }

    public enum BiologicallyDerivedProductStatus {
        /**
         * Product is currently available for use.
         */
        AVAILABLE, 
        /**
         * Product is not currently available for use.
         */
        UNAVAILABLE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static BiologicallyDerivedProductStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return AVAILABLE;
        if ("unavailable".equals(codeString))
          return UNAVAILABLE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown BiologicallyDerivedProductStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AVAILABLE: return "available";
            case UNAVAILABLE: return "unavailable";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AVAILABLE: return "http://hl7.org/fhir/biological-product-status";
            case UNAVAILABLE: return "http://hl7.org/fhir/biological-product-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AVAILABLE: return "Product is currently available for use.";
            case UNAVAILABLE: return "Product is not currently available for use.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AVAILABLE: return "Available";
            case UNAVAILABLE: return "Unavailable";
            default: return "?";
          }
        }
    }

  public static class BiologicallyDerivedProductStatusEnumFactory implements EnumFactory<BiologicallyDerivedProductStatus> {
    public BiologicallyDerivedProductStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return BiologicallyDerivedProductStatus.AVAILABLE;
        if ("unavailable".equals(codeString))
          return BiologicallyDerivedProductStatus.UNAVAILABLE;
        throw new IllegalArgumentException("Unknown BiologicallyDerivedProductStatus code '"+codeString+"'");
        }
        public Enumeration<BiologicallyDerivedProductStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<BiologicallyDerivedProductStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("available".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductStatus>(this, BiologicallyDerivedProductStatus.AVAILABLE);
        if ("unavailable".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductStatus>(this, BiologicallyDerivedProductStatus.UNAVAILABLE);
        throw new FHIRException("Unknown BiologicallyDerivedProductStatus code '"+codeString+"'");
        }
    public String toCode(BiologicallyDerivedProductStatus code) {
      if (code == BiologicallyDerivedProductStatus.AVAILABLE)
        return "available";
      if (code == BiologicallyDerivedProductStatus.UNAVAILABLE)
        return "unavailable";
      return "?";
      }
    public String toSystem(BiologicallyDerivedProductStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class BiologicallyDerivedProductCollectionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Healthcare professional who is performing the collection.
         */
        @Child(name = "collector", type = {Practitioner.class, PractitionerRole.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual performing collection", formalDefinition="Healthcare professional who is performing the collection." )
        protected Reference collector;

        /**
         * The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product.
         */
        @Child(name = "source", type = {Patient.class, Organization.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who is product from", formalDefinition="The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product." )
        protected Reference source;

        /**
         * Time of product collection.
         */
        @Child(name = "collected", type = {DateTimeType.class, Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Time of product collection", formalDefinition="Time of product collection." )
        protected DataType collected;

        private static final long serialVersionUID = 626956533L;

    /**
     * Constructor
     */
      public BiologicallyDerivedProductCollectionComponent() {
        super();
      }

        /**
         * @return {@link #collector} (Healthcare professional who is performing the collection.)
         */
        public Reference getCollector() { 
          if (this.collector == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BiologicallyDerivedProductCollectionComponent.collector");
            else if (Configuration.doAutoCreate())
              this.collector = new Reference(); // cc
          return this.collector;
        }

        public boolean hasCollector() { 
          return this.collector != null && !this.collector.isEmpty();
        }

        /**
         * @param value {@link #collector} (Healthcare professional who is performing the collection.)
         */
        public BiologicallyDerivedProductCollectionComponent setCollector(Reference value) { 
          this.collector = value;
          return this;
        }

        /**
         * @return {@link #source} (The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product.)
         */
        public Reference getSource() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BiologicallyDerivedProductCollectionComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new Reference(); // cc
          return this.source;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product.)
         */
        public BiologicallyDerivedProductCollectionComponent setSource(Reference value) { 
          this.source = value;
          return this;
        }

        /**
         * @return {@link #collected} (Time of product collection.)
         */
        public DataType getCollected() { 
          return this.collected;
        }

        /**
         * @return {@link #collected} (Time of product collection.)
         */
        public DateTimeType getCollectedDateTimeType() throws FHIRException { 
          if (this.collected == null)
            this.collected = new DateTimeType();
          if (!(this.collected instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.collected.getClass().getName()+" was encountered");
          return (DateTimeType) this.collected;
        }

        public boolean hasCollectedDateTimeType() { 
          return this != null && this.collected instanceof DateTimeType;
        }

        /**
         * @return {@link #collected} (Time of product collection.)
         */
        public Period getCollectedPeriod() throws FHIRException { 
          if (this.collected == null)
            this.collected = new Period();
          if (!(this.collected instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.collected.getClass().getName()+" was encountered");
          return (Period) this.collected;
        }

        public boolean hasCollectedPeriod() { 
          return this != null && this.collected instanceof Period;
        }

        public boolean hasCollected() { 
          return this.collected != null && !this.collected.isEmpty();
        }

        /**
         * @param value {@link #collected} (Time of product collection.)
         */
        public BiologicallyDerivedProductCollectionComponent setCollected(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Period))
            throw new Error("Not the right type for BiologicallyDerivedProduct.collection.collected[x]: "+value.fhirType());
          this.collected = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("collector", "Reference(Practitioner|PractitionerRole)", "Healthcare professional who is performing the collection.", 0, 1, collector));
          children.add(new Property("source", "Reference(Patient|Organization)", "The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product.", 0, 1, source));
          children.add(new Property("collected[x]", "dateTime|Period", "Time of product collection.", 0, 1, collected));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1883491469: /*collector*/  return new Property("collector", "Reference(Practitioner|PractitionerRole)", "Healthcare professional who is performing the collection.", 0, 1, collector);
          case -896505829: /*source*/  return new Property("source", "Reference(Patient|Organization)", "The patient or entity, such as a hospital or vendor in the case of a processed/manipulated/manufactured product, providing the product.", 0, 1, source);
          case 1632037015: /*collected[x]*/  return new Property("collected[x]", "dateTime|Period", "Time of product collection.", 0, 1, collected);
          case 1883491145: /*collected*/  return new Property("collected[x]", "dateTime|Period", "Time of product collection.", 0, 1, collected);
          case 2005009924: /*collectedDateTime*/  return new Property("collected[x]", "dateTime", "Time of product collection.", 0, 1, collected);
          case 653185642: /*collectedPeriod*/  return new Property("collected[x]", "Period", "Time of product collection.", 0, 1, collected);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1883491469: /*collector*/ return this.collector == null ? new Base[0] : new Base[] {this.collector}; // Reference
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // Reference
        case 1883491145: /*collected*/ return this.collected == null ? new Base[0] : new Base[] {this.collected}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1883491469: // collector
          this.collector = TypeConvertor.castToReference(value); // Reference
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1883491145: // collected
          this.collected = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("collector")) {
          this.collector = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("collected[x]")) {
          this.collected = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1883491469:  return getCollector();
        case -896505829:  return getSource();
        case 1632037015:  return getCollected();
        case 1883491145:  return getCollected();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1883491469: /*collector*/ return new String[] {"Reference"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        case 1883491145: /*collected*/ return new String[] {"dateTime", "Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("collector")) {
          this.collector = new Reference();
          return this.collector;
        }
        else if (name.equals("source")) {
          this.source = new Reference();
          return this.source;
        }
        else if (name.equals("collectedDateTime")) {
          this.collected = new DateTimeType();
          return this.collected;
        }
        else if (name.equals("collectedPeriod")) {
          this.collected = new Period();
          return this.collected;
        }
        else
          return super.addChild(name);
      }

      public BiologicallyDerivedProductCollectionComponent copy() {
        BiologicallyDerivedProductCollectionComponent dst = new BiologicallyDerivedProductCollectionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BiologicallyDerivedProductCollectionComponent dst) {
        super.copyValues(dst);
        dst.collector = collector == null ? null : collector.copy();
        dst.source = source == null ? null : source.copy();
        dst.collected = collected == null ? null : collected.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductCollectionComponent))
          return false;
        BiologicallyDerivedProductCollectionComponent o = (BiologicallyDerivedProductCollectionComponent) other_;
        return compareDeep(collector, o.collector, true) && compareDeep(source, o.source, true) && compareDeep(collected, o.collected, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductCollectionComponent))
          return false;
        BiologicallyDerivedProductCollectionComponent o = (BiologicallyDerivedProductCollectionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(collector, source, collected
          );
      }

  public String fhirType() {
    return "BiologicallyDerivedProduct.collection";

  }

  }

    @Block()
    public static class BiologicallyDerivedProductPropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code that specifies the property.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that specifies the property", formalDefinition="Code that specifies the property." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/NamingSystem/ib")
        protected CodeableConcept type;

        /**
         * Property values.
         */
        @Child(name = "value", type = {BooleanType.class, IntegerType.class, CodeableConcept.class, Quantity.class, Range.class, StringType.class, Attachment.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Property values", formalDefinition="Property values." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public BiologicallyDerivedProductPropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public BiologicallyDerivedProductPropertyComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Code that specifies the property.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BiologicallyDerivedProductPropertyComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code that specifies the property.)
         */
        public BiologicallyDerivedProductPropertyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Property values.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @return {@link #value} (Property values.)
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
         * @param value {@link #value} (Property values.)
         */
        public BiologicallyDerivedProductPropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof BooleanType || value instanceof IntegerType || value instanceof CodeableConcept || value instanceof Quantity || value instanceof Range || value instanceof StringType || value instanceof Attachment))
            throw new Error("Not the right type for BiologicallyDerivedProduct.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Code that specifies the property.", 0, 1, type));
          children.add(new Property("value[x]", "boolean|integer|CodeableConcept|Quantity|Range|string|Attachment", "Property values.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code that specifies the property.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "boolean|integer|CodeableConcept|Quantity|Range|string|Attachment", "Property values.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "boolean|integer|CodeableConcept|Quantity|Range|string|Attachment", "Property values.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Property values.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "Property values.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Property values.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Property values.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Property values.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Property values.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "Property values.", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"boolean", "integer", "CodeableConcept", "Quantity", "Range", "string", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
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
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public BiologicallyDerivedProductPropertyComponent copy() {
        BiologicallyDerivedProductPropertyComponent dst = new BiologicallyDerivedProductPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BiologicallyDerivedProductPropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductPropertyComponent))
          return false;
        BiologicallyDerivedProductPropertyComponent o = (BiologicallyDerivedProductPropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductPropertyComponent))
          return false;
        BiologicallyDerivedProductPropertyComponent o = (BiologicallyDerivedProductPropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "BiologicallyDerivedProduct.property";

  }

  }

    /**
     * Broad category of this product.
     */
    @Child(name = "productCategory", type = {CodeType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="organ | tissue | fluid | cells | biologicalAgent", formalDefinition="Broad category of this product." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/product-category")
    protected Enumeration<BiologicallyDerivedProductCategory> productCategory;

    /**
     * A code that identifies the kind of this biologically derived product (SNOMED Ctcode).
     */
    @Child(name = "productCode", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What this biologically derived product is", formalDefinition="A code that identifies the kind of this biologically derived product (SNOMED Ctcode)." )
    protected CodeableConcept productCode;

    /**
     * Parent product (if any).
     */
    @Child(name = "parent", type = {BiologicallyDerivedProduct.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="BiologicallyDerivedProduct parent", formalDefinition="Parent product (if any)." )
    protected List<Reference> parent;

    /**
     * Procedure request to obtain this biologically derived product.
     */
    @Child(name = "request", type = {ServiceRequest.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Procedure request", formalDefinition="Procedure request to obtain this biologically derived product." )
    protected List<Reference> request;

    /**
     * This records identifiers associated with this biologically derived product instance that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).
     */
    @Child(name = "identifier", type = {Identifier.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External ids for this item", formalDefinition="This records identifiers associated with this biologically derived product instance that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation)." )
    protected List<Identifier> identifier;

    /**
     * An identifier that supports traceability to the biological entity that is the source of biological material in the product.
     */
    @Child(name = "biologicalSource", type = {Identifier.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="An identifier that supports traceability to the biological entity that is the source of biological material in the product", formalDefinition="An identifier that supports traceability to the biological entity that is the source of biological material in the product." )
    protected Identifier biologicalSource;

    /**
     * Processing facilities for this biologically derived product.
     */
    @Child(name = "processingFacility", type = {Organization.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Processing facility", formalDefinition="Processing facilities for this biologically derived product." )
    protected List<Reference> processingFacility;

    /**
     * Description of division.
     */
    @Child(name = "division", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of division", formalDefinition="Description of division." )
    protected StringType division;

    /**
     * Whether the product is currently available.
     */
    @Child(name = "status", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="available | unavailable", formalDefinition="Whether the product is currently available." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/biological-product-status")
    protected Enumeration<BiologicallyDerivedProductStatus> status;

    /**
     * Date of expiration.
     */
    @Child(name = "expirationDate", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date of expiration", formalDefinition="Date of expiration." )
    protected DateTimeType expirationDate;

    /**
     * How this product was collected.
     */
    @Child(name = "collection", type = {}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How this product was collected", formalDefinition="How this product was collected." )
    protected BiologicallyDerivedProductCollectionComponent collection;

    /**
     * Product storage temp requirements.
     */
    @Child(name = "storageTempRequirements", type = {Range.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Product storage temp requirements", formalDefinition="Product storage temp requirements." )
    protected Range storageTempRequirements;

    /**
     * A property that is specific to this BiologicallyDerviedProduct instance.
     */
    @Child(name = "property", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A property that is specific to this BiologicallyDerviedProduct instance", formalDefinition="A property that is specific to this BiologicallyDerviedProduct instance." )
    protected List<BiologicallyDerivedProductPropertyComponent> property;

    private static final long serialVersionUID = -2109673989L;

  /**
   * Constructor
   */
    public BiologicallyDerivedProduct() {
      super();
    }

    /**
     * @return {@link #productCategory} (Broad category of this product.). This is the underlying object with id, value and extensions. The accessor "getProductCategory" gives direct access to the value
     */
    public Enumeration<BiologicallyDerivedProductCategory> getProductCategoryElement() { 
      if (this.productCategory == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.productCategory");
        else if (Configuration.doAutoCreate())
          this.productCategory = new Enumeration<BiologicallyDerivedProductCategory>(new BiologicallyDerivedProductCategoryEnumFactory()); // bb
      return this.productCategory;
    }

    public boolean hasProductCategoryElement() { 
      return this.productCategory != null && !this.productCategory.isEmpty();
    }

    public boolean hasProductCategory() { 
      return this.productCategory != null && !this.productCategory.isEmpty();
    }

    /**
     * @param value {@link #productCategory} (Broad category of this product.). This is the underlying object with id, value and extensions. The accessor "getProductCategory" gives direct access to the value
     */
    public BiologicallyDerivedProduct setProductCategoryElement(Enumeration<BiologicallyDerivedProductCategory> value) { 
      this.productCategory = value;
      return this;
    }

    /**
     * @return Broad category of this product.
     */
    public BiologicallyDerivedProductCategory getProductCategory() { 
      return this.productCategory == null ? null : this.productCategory.getValue();
    }

    /**
     * @param value Broad category of this product.
     */
    public BiologicallyDerivedProduct setProductCategory(BiologicallyDerivedProductCategory value) { 
      if (value == null)
        this.productCategory = null;
      else {
        if (this.productCategory == null)
          this.productCategory = new Enumeration<BiologicallyDerivedProductCategory>(new BiologicallyDerivedProductCategoryEnumFactory());
        this.productCategory.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #productCode} (A code that identifies the kind of this biologically derived product (SNOMED Ctcode).)
     */
    public CodeableConcept getProductCode() { 
      if (this.productCode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.productCode");
        else if (Configuration.doAutoCreate())
          this.productCode = new CodeableConcept(); // cc
      return this.productCode;
    }

    public boolean hasProductCode() { 
      return this.productCode != null && !this.productCode.isEmpty();
    }

    /**
     * @param value {@link #productCode} (A code that identifies the kind of this biologically derived product (SNOMED Ctcode).)
     */
    public BiologicallyDerivedProduct setProductCode(CodeableConcept value) { 
      this.productCode = value;
      return this;
    }

    /**
     * @return {@link #parent} (Parent product (if any).)
     */
    public List<Reference> getParent() { 
      if (this.parent == null)
        this.parent = new ArrayList<Reference>();
      return this.parent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProduct setParent(List<Reference> theParent) { 
      this.parent = theParent;
      return this;
    }

    public boolean hasParent() { 
      if (this.parent == null)
        return false;
      for (Reference item : this.parent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addParent() { //3
      Reference t = new Reference();
      if (this.parent == null)
        this.parent = new ArrayList<Reference>();
      this.parent.add(t);
      return t;
    }

    public BiologicallyDerivedProduct addParent(Reference t) { //3
      if (t == null)
        return this;
      if (this.parent == null)
        this.parent = new ArrayList<Reference>();
      this.parent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #parent}, creating it if it does not already exist {3}
     */
    public Reference getParentFirstRep() { 
      if (getParent().isEmpty()) {
        addParent();
      }
      return getParent().get(0);
    }

    /**
     * @return {@link #request} (Procedure request to obtain this biologically derived product.)
     */
    public List<Reference> getRequest() { 
      if (this.request == null)
        this.request = new ArrayList<Reference>();
      return this.request;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProduct setRequest(List<Reference> theRequest) { 
      this.request = theRequest;
      return this;
    }

    public boolean hasRequest() { 
      if (this.request == null)
        return false;
      for (Reference item : this.request)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addRequest() { //3
      Reference t = new Reference();
      if (this.request == null)
        this.request = new ArrayList<Reference>();
      this.request.add(t);
      return t;
    }

    public BiologicallyDerivedProduct addRequest(Reference t) { //3
      if (t == null)
        return this;
      if (this.request == null)
        this.request = new ArrayList<Reference>();
      this.request.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #request}, creating it if it does not already exist {3}
     */
    public Reference getRequestFirstRep() { 
      if (getRequest().isEmpty()) {
        addRequest();
      }
      return getRequest().get(0);
    }

    /**
     * @return {@link #identifier} (This records identifiers associated with this biologically derived product instance that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProduct setIdentifier(List<Identifier> theIdentifier) { 
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

    public BiologicallyDerivedProduct addIdentifier(Identifier t) { //3
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
     * @return {@link #biologicalSource} (An identifier that supports traceability to the biological entity that is the source of biological material in the product.)
     */
    public Identifier getBiologicalSource() { 
      if (this.biologicalSource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.biologicalSource");
        else if (Configuration.doAutoCreate())
          this.biologicalSource = new Identifier(); // cc
      return this.biologicalSource;
    }

    public boolean hasBiologicalSource() { 
      return this.biologicalSource != null && !this.biologicalSource.isEmpty();
    }

    /**
     * @param value {@link #biologicalSource} (An identifier that supports traceability to the biological entity that is the source of biological material in the product.)
     */
    public BiologicallyDerivedProduct setBiologicalSource(Identifier value) { 
      this.biologicalSource = value;
      return this;
    }

    /**
     * @return {@link #processingFacility} (Processing facilities for this biologically derived product.)
     */
    public List<Reference> getProcessingFacility() { 
      if (this.processingFacility == null)
        this.processingFacility = new ArrayList<Reference>();
      return this.processingFacility;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProduct setProcessingFacility(List<Reference> theProcessingFacility) { 
      this.processingFacility = theProcessingFacility;
      return this;
    }

    public boolean hasProcessingFacility() { 
      if (this.processingFacility == null)
        return false;
      for (Reference item : this.processingFacility)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addProcessingFacility() { //3
      Reference t = new Reference();
      if (this.processingFacility == null)
        this.processingFacility = new ArrayList<Reference>();
      this.processingFacility.add(t);
      return t;
    }

    public BiologicallyDerivedProduct addProcessingFacility(Reference t) { //3
      if (t == null)
        return this;
      if (this.processingFacility == null)
        this.processingFacility = new ArrayList<Reference>();
      this.processingFacility.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #processingFacility}, creating it if it does not already exist {3}
     */
    public Reference getProcessingFacilityFirstRep() { 
      if (getProcessingFacility().isEmpty()) {
        addProcessingFacility();
      }
      return getProcessingFacility().get(0);
    }

    /**
     * @return {@link #division} (Description of division.). This is the underlying object with id, value and extensions. The accessor "getDivision" gives direct access to the value
     */
    public StringType getDivisionElement() { 
      if (this.division == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.division");
        else if (Configuration.doAutoCreate())
          this.division = new StringType(); // bb
      return this.division;
    }

    public boolean hasDivisionElement() { 
      return this.division != null && !this.division.isEmpty();
    }

    public boolean hasDivision() { 
      return this.division != null && !this.division.isEmpty();
    }

    /**
     * @param value {@link #division} (Description of division.). This is the underlying object with id, value and extensions. The accessor "getDivision" gives direct access to the value
     */
    public BiologicallyDerivedProduct setDivisionElement(StringType value) { 
      this.division = value;
      return this;
    }

    /**
     * @return Description of division.
     */
    public String getDivision() { 
      return this.division == null ? null : this.division.getValue();
    }

    /**
     * @param value Description of division.
     */
    public BiologicallyDerivedProduct setDivision(String value) { 
      if (Utilities.noString(value))
        this.division = null;
      else {
        if (this.division == null)
          this.division = new StringType();
        this.division.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (Whether the product is currently available.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<BiologicallyDerivedProductStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<BiologicallyDerivedProductStatus>(new BiologicallyDerivedProductStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Whether the product is currently available.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public BiologicallyDerivedProduct setStatusElement(Enumeration<BiologicallyDerivedProductStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Whether the product is currently available.
     */
    public BiologicallyDerivedProductStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Whether the product is currently available.
     */
    public BiologicallyDerivedProduct setStatus(BiologicallyDerivedProductStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<BiologicallyDerivedProductStatus>(new BiologicallyDerivedProductStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #expirationDate} (Date of expiration.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public DateTimeType getExpirationDateElement() { 
      if (this.expirationDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.expirationDate");
        else if (Configuration.doAutoCreate())
          this.expirationDate = new DateTimeType(); // bb
      return this.expirationDate;
    }

    public boolean hasExpirationDateElement() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    public boolean hasExpirationDate() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    /**
     * @param value {@link #expirationDate} (Date of expiration.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public BiologicallyDerivedProduct setExpirationDateElement(DateTimeType value) { 
      this.expirationDate = value;
      return this;
    }

    /**
     * @return Date of expiration.
     */
    public Date getExpirationDate() { 
      return this.expirationDate == null ? null : this.expirationDate.getValue();
    }

    /**
     * @param value Date of expiration.
     */
    public BiologicallyDerivedProduct setExpirationDate(Date value) { 
      if (value == null)
        this.expirationDate = null;
      else {
        if (this.expirationDate == null)
          this.expirationDate = new DateTimeType();
        this.expirationDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #collection} (How this product was collected.)
     */
    public BiologicallyDerivedProductCollectionComponent getCollection() { 
      if (this.collection == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.collection");
        else if (Configuration.doAutoCreate())
          this.collection = new BiologicallyDerivedProductCollectionComponent(); // cc
      return this.collection;
    }

    public boolean hasCollection() { 
      return this.collection != null && !this.collection.isEmpty();
    }

    /**
     * @param value {@link #collection} (How this product was collected.)
     */
    public BiologicallyDerivedProduct setCollection(BiologicallyDerivedProductCollectionComponent value) { 
      this.collection = value;
      return this;
    }

    /**
     * @return {@link #storageTempRequirements} (Product storage temp requirements.)
     */
    public Range getStorageTempRequirements() { 
      if (this.storageTempRequirements == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProduct.storageTempRequirements");
        else if (Configuration.doAutoCreate())
          this.storageTempRequirements = new Range(); // cc
      return this.storageTempRequirements;
    }

    public boolean hasStorageTempRequirements() { 
      return this.storageTempRequirements != null && !this.storageTempRequirements.isEmpty();
    }

    /**
     * @param value {@link #storageTempRequirements} (Product storage temp requirements.)
     */
    public BiologicallyDerivedProduct setStorageTempRequirements(Range value) { 
      this.storageTempRequirements = value;
      return this;
    }

    /**
     * @return {@link #property} (A property that is specific to this BiologicallyDerviedProduct instance.)
     */
    public List<BiologicallyDerivedProductPropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<BiologicallyDerivedProductPropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProduct setProperty(List<BiologicallyDerivedProductPropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (BiologicallyDerivedProductPropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public BiologicallyDerivedProductPropertyComponent addProperty() { //3
      BiologicallyDerivedProductPropertyComponent t = new BiologicallyDerivedProductPropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<BiologicallyDerivedProductPropertyComponent>();
      this.property.add(t);
      return t;
    }

    public BiologicallyDerivedProduct addProperty(BiologicallyDerivedProductPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<BiologicallyDerivedProductPropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public BiologicallyDerivedProductPropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("productCategory", "code", "Broad category of this product.", 0, 1, productCategory));
        children.add(new Property("productCode", "CodeableConcept", "A code that identifies the kind of this biologically derived product (SNOMED Ctcode).", 0, 1, productCode));
        children.add(new Property("parent", "Reference(BiologicallyDerivedProduct)", "Parent product (if any).", 0, java.lang.Integer.MAX_VALUE, parent));
        children.add(new Property("request", "Reference(ServiceRequest)", "Procedure request to obtain this biologically derived product.", 0, java.lang.Integer.MAX_VALUE, request));
        children.add(new Property("identifier", "Identifier", "This records identifiers associated with this biologically derived product instance that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("biologicalSource", "Identifier", "An identifier that supports traceability to the biological entity that is the source of biological material in the product.", 0, 1, biologicalSource));
        children.add(new Property("processingFacility", "Reference(Organization)", "Processing facilities for this biologically derived product.", 0, java.lang.Integer.MAX_VALUE, processingFacility));
        children.add(new Property("division", "string", "Description of division.", 0, 1, division));
        children.add(new Property("status", "code", "Whether the product is currently available.", 0, 1, status));
        children.add(new Property("expirationDate", "dateTime", "Date of expiration.", 0, 1, expirationDate));
        children.add(new Property("collection", "", "How this product was collected.", 0, 1, collection));
        children.add(new Property("storageTempRequirements", "Range", "Product storage temp requirements.", 0, 1, storageTempRequirements));
        children.add(new Property("property", "", "A property that is specific to this BiologicallyDerviedProduct instance.", 0, java.lang.Integer.MAX_VALUE, property));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 197299981: /*productCategory*/  return new Property("productCategory", "code", "Broad category of this product.", 0, 1, productCategory);
        case -1492131972: /*productCode*/  return new Property("productCode", "CodeableConcept", "A code that identifies the kind of this biologically derived product (SNOMED Ctcode).", 0, 1, productCode);
        case -995424086: /*parent*/  return new Property("parent", "Reference(BiologicallyDerivedProduct)", "Parent product (if any).", 0, java.lang.Integer.MAX_VALUE, parent);
        case 1095692943: /*request*/  return new Property("request", "Reference(ServiceRequest)", "Procedure request to obtain this biologically derived product.", 0, java.lang.Integer.MAX_VALUE, request);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "This records identifiers associated with this biologically derived product instance that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -883952260: /*biologicalSource*/  return new Property("biologicalSource", "Identifier", "An identifier that supports traceability to the biological entity that is the source of biological material in the product.", 0, 1, biologicalSource);
        case 39337686: /*processingFacility*/  return new Property("processingFacility", "Reference(Organization)", "Processing facilities for this biologically derived product.", 0, java.lang.Integer.MAX_VALUE, processingFacility);
        case 364720301: /*division*/  return new Property("division", "string", "Description of division.", 0, 1, division);
        case -892481550: /*status*/  return new Property("status", "code", "Whether the product is currently available.", 0, 1, status);
        case -668811523: /*expirationDate*/  return new Property("expirationDate", "dateTime", "Date of expiration.", 0, 1, expirationDate);
        case -1741312354: /*collection*/  return new Property("collection", "", "How this product was collected.", 0, 1, collection);
        case 1643599647: /*storageTempRequirements*/  return new Property("storageTempRequirements", "Range", "Product storage temp requirements.", 0, 1, storageTempRequirements);
        case -993141291: /*property*/  return new Property("property", "", "A property that is specific to this BiologicallyDerviedProduct instance.", 0, java.lang.Integer.MAX_VALUE, property);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 197299981: /*productCategory*/ return this.productCategory == null ? new Base[0] : new Base[] {this.productCategory}; // Enumeration<BiologicallyDerivedProductCategory>
        case -1492131972: /*productCode*/ return this.productCode == null ? new Base[0] : new Base[] {this.productCode}; // CodeableConcept
        case -995424086: /*parent*/ return this.parent == null ? new Base[0] : this.parent.toArray(new Base[this.parent.size()]); // Reference
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : this.request.toArray(new Base[this.request.size()]); // Reference
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -883952260: /*biologicalSource*/ return this.biologicalSource == null ? new Base[0] : new Base[] {this.biologicalSource}; // Identifier
        case 39337686: /*processingFacility*/ return this.processingFacility == null ? new Base[0] : this.processingFacility.toArray(new Base[this.processingFacility.size()]); // Reference
        case 364720301: /*division*/ return this.division == null ? new Base[0] : new Base[] {this.division}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<BiologicallyDerivedProductStatus>
        case -668811523: /*expirationDate*/ return this.expirationDate == null ? new Base[0] : new Base[] {this.expirationDate}; // DateTimeType
        case -1741312354: /*collection*/ return this.collection == null ? new Base[0] : new Base[] {this.collection}; // BiologicallyDerivedProductCollectionComponent
        case 1643599647: /*storageTempRequirements*/ return this.storageTempRequirements == null ? new Base[0] : new Base[] {this.storageTempRequirements}; // Range
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // BiologicallyDerivedProductPropertyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 197299981: // productCategory
          value = new BiologicallyDerivedProductCategoryEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.productCategory = (Enumeration) value; // Enumeration<BiologicallyDerivedProductCategory>
          return value;
        case -1492131972: // productCode
          this.productCode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -995424086: // parent
          this.getParent().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1095692943: // request
          this.getRequest().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -883952260: // biologicalSource
          this.biologicalSource = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 39337686: // processingFacility
          this.getProcessingFacility().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 364720301: // division
          this.division = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new BiologicallyDerivedProductStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<BiologicallyDerivedProductStatus>
          return value;
        case -668811523: // expirationDate
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1741312354: // collection
          this.collection = (BiologicallyDerivedProductCollectionComponent) value; // BiologicallyDerivedProductCollectionComponent
          return value;
        case 1643599647: // storageTempRequirements
          this.storageTempRequirements = TypeConvertor.castToRange(value); // Range
          return value;
        case -993141291: // property
          this.getProperty().add((BiologicallyDerivedProductPropertyComponent) value); // BiologicallyDerivedProductPropertyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("productCategory")) {
          value = new BiologicallyDerivedProductCategoryEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.productCategory = (Enumeration) value; // Enumeration<BiologicallyDerivedProductCategory>
        } else if (name.equals("productCode")) {
          this.productCode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("parent")) {
          this.getParent().add(TypeConvertor.castToReference(value));
        } else if (name.equals("request")) {
          this.getRequest().add(TypeConvertor.castToReference(value));
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("biologicalSource")) {
          this.biologicalSource = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("processingFacility")) {
          this.getProcessingFacility().add(TypeConvertor.castToReference(value));
        } else if (name.equals("division")) {
          this.division = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new BiologicallyDerivedProductStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<BiologicallyDerivedProductStatus>
        } else if (name.equals("expirationDate")) {
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("collection")) {
          this.collection = (BiologicallyDerivedProductCollectionComponent) value; // BiologicallyDerivedProductCollectionComponent
        } else if (name.equals("storageTempRequirements")) {
          this.storageTempRequirements = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("property")) {
          this.getProperty().add((BiologicallyDerivedProductPropertyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 197299981:  return getProductCategoryElement();
        case -1492131972:  return getProductCode();
        case -995424086:  return addParent(); 
        case 1095692943:  return addRequest(); 
        case -1618432855:  return addIdentifier(); 
        case -883952260:  return getBiologicalSource();
        case 39337686:  return addProcessingFacility(); 
        case 364720301:  return getDivisionElement();
        case -892481550:  return getStatusElement();
        case -668811523:  return getExpirationDateElement();
        case -1741312354:  return getCollection();
        case 1643599647:  return getStorageTempRequirements();
        case -993141291:  return addProperty(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 197299981: /*productCategory*/ return new String[] {"code"};
        case -1492131972: /*productCode*/ return new String[] {"CodeableConcept"};
        case -995424086: /*parent*/ return new String[] {"Reference"};
        case 1095692943: /*request*/ return new String[] {"Reference"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -883952260: /*biologicalSource*/ return new String[] {"Identifier"};
        case 39337686: /*processingFacility*/ return new String[] {"Reference"};
        case 364720301: /*division*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -668811523: /*expirationDate*/ return new String[] {"dateTime"};
        case -1741312354: /*collection*/ return new String[] {};
        case 1643599647: /*storageTempRequirements*/ return new String[] {"Range"};
        case -993141291: /*property*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("productCategory")) {
          throw new FHIRException("Cannot call addChild on a primitive type BiologicallyDerivedProduct.productCategory");
        }
        else if (name.equals("productCode")) {
          this.productCode = new CodeableConcept();
          return this.productCode;
        }
        else if (name.equals("parent")) {
          return addParent();
        }
        else if (name.equals("request")) {
          return addRequest();
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("biologicalSource")) {
          this.biologicalSource = new Identifier();
          return this.biologicalSource;
        }
        else if (name.equals("processingFacility")) {
          return addProcessingFacility();
        }
        else if (name.equals("division")) {
          throw new FHIRException("Cannot call addChild on a primitive type BiologicallyDerivedProduct.division");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type BiologicallyDerivedProduct.status");
        }
        else if (name.equals("expirationDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type BiologicallyDerivedProduct.expirationDate");
        }
        else if (name.equals("collection")) {
          this.collection = new BiologicallyDerivedProductCollectionComponent();
          return this.collection;
        }
        else if (name.equals("storageTempRequirements")) {
          this.storageTempRequirements = new Range();
          return this.storageTempRequirements;
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "BiologicallyDerivedProduct";

  }

      public BiologicallyDerivedProduct copy() {
        BiologicallyDerivedProduct dst = new BiologicallyDerivedProduct();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BiologicallyDerivedProduct dst) {
        super.copyValues(dst);
        dst.productCategory = productCategory == null ? null : productCategory.copy();
        dst.productCode = productCode == null ? null : productCode.copy();
        if (parent != null) {
          dst.parent = new ArrayList<Reference>();
          for (Reference i : parent)
            dst.parent.add(i.copy());
        };
        if (request != null) {
          dst.request = new ArrayList<Reference>();
          for (Reference i : request)
            dst.request.add(i.copy());
        };
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.biologicalSource = biologicalSource == null ? null : biologicalSource.copy();
        if (processingFacility != null) {
          dst.processingFacility = new ArrayList<Reference>();
          for (Reference i : processingFacility)
            dst.processingFacility.add(i.copy());
        };
        dst.division = division == null ? null : division.copy();
        dst.status = status == null ? null : status.copy();
        dst.expirationDate = expirationDate == null ? null : expirationDate.copy();
        dst.collection = collection == null ? null : collection.copy();
        dst.storageTempRequirements = storageTempRequirements == null ? null : storageTempRequirements.copy();
        if (property != null) {
          dst.property = new ArrayList<BiologicallyDerivedProductPropertyComponent>();
          for (BiologicallyDerivedProductPropertyComponent i : property)
            dst.property.add(i.copy());
        };
      }

      protected BiologicallyDerivedProduct typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProduct))
          return false;
        BiologicallyDerivedProduct o = (BiologicallyDerivedProduct) other_;
        return compareDeep(productCategory, o.productCategory, true) && compareDeep(productCode, o.productCode, true)
           && compareDeep(parent, o.parent, true) && compareDeep(request, o.request, true) && compareDeep(identifier, o.identifier, true)
           && compareDeep(biologicalSource, o.biologicalSource, true) && compareDeep(processingFacility, o.processingFacility, true)
           && compareDeep(division, o.division, true) && compareDeep(status, o.status, true) && compareDeep(expirationDate, o.expirationDate, true)
           && compareDeep(collection, o.collection, true) && compareDeep(storageTempRequirements, o.storageTempRequirements, true)
           && compareDeep(property, o.property, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProduct))
          return false;
        BiologicallyDerivedProduct o = (BiologicallyDerivedProduct) other_;
        return compareValues(productCategory, o.productCategory, true) && compareValues(division, o.division, true)
           && compareValues(status, o.status, true) && compareValues(expirationDate, o.expirationDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(productCategory, productCode
          , parent, request, identifier, biologicalSource, processingFacility, division, status
          , expirationDate, collection, storageTempRequirements, property);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.BiologicallyDerivedProduct;
   }

 /**
   * Search parameter: <b>biological-source</b>
   * <p>
   * Description: <b>The biological source for the biologically derived product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProduct.biologicalSource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="biological-source", path="BiologicallyDerivedProduct.biologicalSource", description="The biological source for the biologically derived product", type="token" )
  public static final String SP_BIOLOGICAL_SOURCE = "biological-source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>biological-source</b>
   * <p>
   * Description: <b>The biological source for the biologically derived product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProduct.biologicalSource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BIOLOGICAL_SOURCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BIOLOGICAL_SOURCE);


}

