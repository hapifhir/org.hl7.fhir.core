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
 * A sample to be used for analysis.
 */
@ResourceDef(name="Specimen", profile="http://hl7.org/fhir/StructureDefinition/Specimen")
public class Specimen extends DomainResource {

    public enum SpecimenCombined {
        /**
         * The specimen is in a group.
         */
        GROUPED, 
        /**
         * The specimen is pooled.
         */
        POOLED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SpecimenCombined fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("grouped".equals(codeString))
          return GROUPED;
        if ("pooled".equals(codeString))
          return POOLED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SpecimenCombined code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case GROUPED: return "grouped";
            case POOLED: return "pooled";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case GROUPED: return "http://hl7.org/fhir/specimen-combined";
            case POOLED: return "http://hl7.org/fhir/specimen-combined";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case GROUPED: return "The specimen is in a group.";
            case POOLED: return "The specimen is pooled.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case GROUPED: return "Grouped";
            case POOLED: return "Pooled";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SpecimenCombinedEnumFactory implements EnumFactory<SpecimenCombined> {
    public SpecimenCombined fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("grouped".equals(codeString))
          return SpecimenCombined.GROUPED;
        if ("pooled".equals(codeString))
          return SpecimenCombined.POOLED;
        throw new IllegalArgumentException("Unknown SpecimenCombined code '"+codeString+"'");
        }
        public Enumeration<SpecimenCombined> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SpecimenCombined>(this, SpecimenCombined.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SpecimenCombined>(this, SpecimenCombined.NULL, code);
        if ("grouped".equals(codeString))
          return new Enumeration<SpecimenCombined>(this, SpecimenCombined.GROUPED, code);
        if ("pooled".equals(codeString))
          return new Enumeration<SpecimenCombined>(this, SpecimenCombined.POOLED, code);
        throw new FHIRException("Unknown SpecimenCombined code '"+codeString+"'");
        }
    public String toCode(SpecimenCombined code) {
      if (code == SpecimenCombined.GROUPED)
        return "grouped";
      if (code == SpecimenCombined.POOLED)
        return "pooled";
      return "?";
      }
    public String toSystem(SpecimenCombined code) {
      return code.getSystem();
      }
    }

    public enum SpecimenStatus {
        /**
         * The physical specimen is present and in good condition.
         */
        AVAILABLE, 
        /**
         * There is no physical specimen because it is either lost, destroyed or consumed.
         */
        UNAVAILABLE, 
        /**
         * The specimen cannot be used because of a quality issue such as a broken container, contamination, or too old.
         */
        UNSATISFACTORY, 
        /**
         * The specimen was entered in error and therefore nullified.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SpecimenStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return AVAILABLE;
        if ("unavailable".equals(codeString))
          return UNAVAILABLE;
        if ("unsatisfactory".equals(codeString))
          return UNSATISFACTORY;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SpecimenStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AVAILABLE: return "available";
            case UNAVAILABLE: return "unavailable";
            case UNSATISFACTORY: return "unsatisfactory";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AVAILABLE: return "http://hl7.org/fhir/specimen-status";
            case UNAVAILABLE: return "http://hl7.org/fhir/specimen-status";
            case UNSATISFACTORY: return "http://hl7.org/fhir/specimen-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/specimen-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AVAILABLE: return "The physical specimen is present and in good condition.";
            case UNAVAILABLE: return "There is no physical specimen because it is either lost, destroyed or consumed.";
            case UNSATISFACTORY: return "The specimen cannot be used because of a quality issue such as a broken container, contamination, or too old.";
            case ENTEREDINERROR: return "The specimen was entered in error and therefore nullified.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AVAILABLE: return "Available";
            case UNAVAILABLE: return "Unavailable";
            case UNSATISFACTORY: return "Unsatisfactory";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SpecimenStatusEnumFactory implements EnumFactory<SpecimenStatus> {
    public SpecimenStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return SpecimenStatus.AVAILABLE;
        if ("unavailable".equals(codeString))
          return SpecimenStatus.UNAVAILABLE;
        if ("unsatisfactory".equals(codeString))
          return SpecimenStatus.UNSATISFACTORY;
        if ("entered-in-error".equals(codeString))
          return SpecimenStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown SpecimenStatus code '"+codeString+"'");
        }
        public Enumeration<SpecimenStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SpecimenStatus>(this, SpecimenStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SpecimenStatus>(this, SpecimenStatus.NULL, code);
        if ("available".equals(codeString))
          return new Enumeration<SpecimenStatus>(this, SpecimenStatus.AVAILABLE, code);
        if ("unavailable".equals(codeString))
          return new Enumeration<SpecimenStatus>(this, SpecimenStatus.UNAVAILABLE, code);
        if ("unsatisfactory".equals(codeString))
          return new Enumeration<SpecimenStatus>(this, SpecimenStatus.UNSATISFACTORY, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<SpecimenStatus>(this, SpecimenStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown SpecimenStatus code '"+codeString+"'");
        }
    public String toCode(SpecimenStatus code) {
      if (code == SpecimenStatus.AVAILABLE)
        return "available";
      if (code == SpecimenStatus.UNAVAILABLE)
        return "unavailable";
      if (code == SpecimenStatus.UNSATISFACTORY)
        return "unsatisfactory";
      if (code == SpecimenStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(SpecimenStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SpecimenFeatureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The landmark or feature being highlighted.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Highlighted feature", formalDefinition="The landmark or feature being highlighted." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected CodeableConcept type;

        /**
         * Description of the feature of the specimen.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Information about the feature", formalDefinition="Description of the feature of the specimen." )
        protected StringType description;

        private static final long serialVersionUID = 1762224562L;

    /**
     * Constructor
     */
      public SpecimenFeatureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SpecimenFeatureComponent(CodeableConcept type, String description) {
        super();
        this.setType(type);
        this.setDescription(description);
      }

        /**
         * @return {@link #type} (The landmark or feature being highlighted.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenFeatureComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The landmark or feature being highlighted.)
         */
        public SpecimenFeatureComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #description} (Description of the feature of the specimen.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenFeatureComponent.description");
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
         * @param value {@link #description} (Description of the feature of the specimen.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SpecimenFeatureComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of the feature of the specimen.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of the feature of the specimen.
         */
        public SpecimenFeatureComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The landmark or feature being highlighted.", 0, 1, type));
          children.add(new Property("description", "string", "Description of the feature of the specimen.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The landmark or feature being highlighted.", 0, 1, type);
          case -1724546052: /*description*/  return new Property("description", "string", "Description of the feature of the specimen.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Specimen.feature.description");
        }
        else
          return super.addChild(name);
      }

      public SpecimenFeatureComponent copy() {
        SpecimenFeatureComponent dst = new SpecimenFeatureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenFeatureComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenFeatureComponent))
          return false;
        SpecimenFeatureComponent o = (SpecimenFeatureComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenFeatureComponent))
          return false;
        SpecimenFeatureComponent o = (SpecimenFeatureComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, description);
      }

  public String fhirType() {
    return "Specimen.feature";

  }

  }

    @Block()
    public static class SpecimenCollectionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Person who collected the specimen.
         */
        @Child(name = "collector", type = {Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who collected the specimen", formalDefinition="Person who collected the specimen." )
        protected Reference collector;

        /**
         * Time when specimen was collected from subject - the physiologically relevant time.
         */
        @Child(name = "collected", type = {DateTimeType.class, Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Collection time", formalDefinition="Time when specimen was collected from subject - the physiologically relevant time." )
        protected DataType collected;

        /**
         * The span of time over which the collection of a specimen occurred.
         */
        @Child(name = "duration", type = {Duration.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="How long it took to collect specimen", formalDefinition="The span of time over which the collection of a specimen occurred." )
        protected Duration duration;

        /**
         * The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The quantity of specimen collected", formalDefinition="The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample." )
        protected Quantity quantity;

        /**
         * A coded value specifying the technique that is used to perform the procedure.
         */
        @Child(name = "method", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Technique used to perform collection", formalDefinition="A coded value specifying the technique that is used to perform the procedure." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-collection-method")
        protected CodeableConcept method;

        /**
         * A coded value specifying the technique that is used to perform the procedure.
         */
        @Child(name = "device", type = {CodeableReference.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device used to perform collection", formalDefinition="A coded value specifying the technique that is used to perform the procedure." )
        protected CodeableReference device;

        /**
         * The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample).
         */
        @Child(name = "procedure", type = {Procedure.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The procedure that collects the specimen", formalDefinition="The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample)." )
        protected Reference procedure;

        /**
         * Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens.
         */
        @Child(name = "bodySite", type = {CodeableReference.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Anatomical collection site", formalDefinition="Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected CodeableReference bodySite;

        /**
         * Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.
         */
        @Child(name = "fastingStatus", type = {CodeableConcept.class, Duration.class}, order=9, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Whether or how long patient abstained from food and/or drink", formalDefinition="Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0916")
        protected DataType fastingStatus;

        private static final long serialVersionUID = 953983070L;

    /**
     * Constructor
     */
      public SpecimenCollectionComponent() {
        super();
      }

        /**
         * @return {@link #collector} (Person who collected the specimen.)
         */
        public Reference getCollector() { 
          if (this.collector == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.collector");
            else if (Configuration.doAutoCreate())
              this.collector = new Reference(); // cc
          return this.collector;
        }

        public boolean hasCollector() { 
          return this.collector != null && !this.collector.isEmpty();
        }

        /**
         * @param value {@link #collector} (Person who collected the specimen.)
         */
        public SpecimenCollectionComponent setCollector(Reference value) { 
          this.collector = value;
          return this;
        }

        /**
         * @return {@link #collected} (Time when specimen was collected from subject - the physiologically relevant time.)
         */
        public DataType getCollected() { 
          return this.collected;
        }

        /**
         * @return {@link #collected} (Time when specimen was collected from subject - the physiologically relevant time.)
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
         * @return {@link #collected} (Time when specimen was collected from subject - the physiologically relevant time.)
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
         * @param value {@link #collected} (Time when specimen was collected from subject - the physiologically relevant time.)
         */
        public SpecimenCollectionComponent setCollected(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Period))
            throw new Error("Not the right type for Specimen.collection.collected[x]: "+value.fhirType());
          this.collected = value;
          return this;
        }

        /**
         * @return {@link #duration} (The span of time over which the collection of a specimen occurred.)
         */
        public Duration getDuration() { 
          if (this.duration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.duration");
            else if (Configuration.doAutoCreate())
              this.duration = new Duration(); // cc
          return this.duration;
        }

        public boolean hasDuration() { 
          return this.duration != null && !this.duration.isEmpty();
        }

        /**
         * @param value {@link #duration} (The span of time over which the collection of a specimen occurred.)
         */
        public SpecimenCollectionComponent setDuration(Duration value) { 
          this.duration = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample.)
         */
        public SpecimenCollectionComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #method} (A coded value specifying the technique that is used to perform the procedure.)
         */
        public CodeableConcept getMethod() { 
          if (this.method == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.method");
            else if (Configuration.doAutoCreate())
              this.method = new CodeableConcept(); // cc
          return this.method;
        }

        public boolean hasMethod() { 
          return this.method != null && !this.method.isEmpty();
        }

        /**
         * @param value {@link #method} (A coded value specifying the technique that is used to perform the procedure.)
         */
        public SpecimenCollectionComponent setMethod(CodeableConcept value) { 
          this.method = value;
          return this;
        }

        /**
         * @return {@link #device} (A coded value specifying the technique that is used to perform the procedure.)
         */
        public CodeableReference getDevice() { 
          if (this.device == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.device");
            else if (Configuration.doAutoCreate())
              this.device = new CodeableReference(); // cc
          return this.device;
        }

        public boolean hasDevice() { 
          return this.device != null && !this.device.isEmpty();
        }

        /**
         * @param value {@link #device} (A coded value specifying the technique that is used to perform the procedure.)
         */
        public SpecimenCollectionComponent setDevice(CodeableReference value) { 
          this.device = value;
          return this;
        }

        /**
         * @return {@link #procedure} (The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample).)
         */
        public Reference getProcedure() { 
          if (this.procedure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.procedure");
            else if (Configuration.doAutoCreate())
              this.procedure = new Reference(); // cc
          return this.procedure;
        }

        public boolean hasProcedure() { 
          return this.procedure != null && !this.procedure.isEmpty();
        }

        /**
         * @param value {@link #procedure} (The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample).)
         */
        public SpecimenCollectionComponent setProcedure(Reference value) { 
          this.procedure = value;
          return this;
        }

        /**
         * @return {@link #bodySite} (Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens.)
         */
        public CodeableReference getBodySite() { 
          if (this.bodySite == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenCollectionComponent.bodySite");
            else if (Configuration.doAutoCreate())
              this.bodySite = new CodeableReference(); // cc
          return this.bodySite;
        }

        public boolean hasBodySite() { 
          return this.bodySite != null && !this.bodySite.isEmpty();
        }

        /**
         * @param value {@link #bodySite} (Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens.)
         */
        public SpecimenCollectionComponent setBodySite(CodeableReference value) { 
          this.bodySite = value;
          return this;
        }

        /**
         * @return {@link #fastingStatus} (Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.)
         */
        public DataType getFastingStatus() { 
          return this.fastingStatus;
        }

        /**
         * @return {@link #fastingStatus} (Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.)
         */
        public CodeableConcept getFastingStatusCodeableConcept() throws FHIRException { 
          if (this.fastingStatus == null)
            this.fastingStatus = new CodeableConcept();
          if (!(this.fastingStatus instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.fastingStatus.getClass().getName()+" was encountered");
          return (CodeableConcept) this.fastingStatus;
        }

        public boolean hasFastingStatusCodeableConcept() { 
          return this != null && this.fastingStatus instanceof CodeableConcept;
        }

        /**
         * @return {@link #fastingStatus} (Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.)
         */
        public Duration getFastingStatusDuration() throws FHIRException { 
          if (this.fastingStatus == null)
            this.fastingStatus = new Duration();
          if (!(this.fastingStatus instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.fastingStatus.getClass().getName()+" was encountered");
          return (Duration) this.fastingStatus;
        }

        public boolean hasFastingStatusDuration() { 
          return this != null && this.fastingStatus instanceof Duration;
        }

        public boolean hasFastingStatus() { 
          return this.fastingStatus != null && !this.fastingStatus.isEmpty();
        }

        /**
         * @param value {@link #fastingStatus} (Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.)
         */
        public SpecimenCollectionComponent setFastingStatus(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Duration))
            throw new Error("Not the right type for Specimen.collection.fastingStatus[x]: "+value.fhirType());
          this.fastingStatus = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("collector", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson)", "Person who collected the specimen.", 0, 1, collector));
          children.add(new Property("collected[x]", "dateTime|Period", "Time when specimen was collected from subject - the physiologically relevant time.", 0, 1, collected));
          children.add(new Property("duration", "Duration", "The span of time over which the collection of a specimen occurred.", 0, 1, duration));
          children.add(new Property("quantity", "Quantity", "The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample.", 0, 1, quantity));
          children.add(new Property("method", "CodeableConcept", "A coded value specifying the technique that is used to perform the procedure.", 0, 1, method));
          children.add(new Property("device", "CodeableReference(Device)", "A coded value specifying the technique that is used to perform the procedure.", 0, 1, device));
          children.add(new Property("procedure", "Reference(Procedure)", "The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample).", 0, 1, procedure));
          children.add(new Property("bodySite", "CodeableReference(BodyStructure)", "Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens.", 0, 1, bodySite));
          children.add(new Property("fastingStatus[x]", "CodeableConcept|Duration", "Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.", 0, 1, fastingStatus));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1883491469: /*collector*/  return new Property("collector", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson)", "Person who collected the specimen.", 0, 1, collector);
          case 1632037015: /*collected[x]*/  return new Property("collected[x]", "dateTime|Period", "Time when specimen was collected from subject - the physiologically relevant time.", 0, 1, collected);
          case 1883491145: /*collected*/  return new Property("collected[x]", "dateTime|Period", "Time when specimen was collected from subject - the physiologically relevant time.", 0, 1, collected);
          case 2005009924: /*collectedDateTime*/  return new Property("collected[x]", "dateTime", "Time when specimen was collected from subject - the physiologically relevant time.", 0, 1, collected);
          case 653185642: /*collectedPeriod*/  return new Property("collected[x]", "Period", "Time when specimen was collected from subject - the physiologically relevant time.", 0, 1, collected);
          case -1992012396: /*duration*/  return new Property("duration", "Duration", "The span of time over which the collection of a specimen occurred.", 0, 1, duration);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The quantity of specimen collected; for instance the volume of a blood sample, or the physical measurement of an anatomic pathology sample.", 0, 1, quantity);
          case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "A coded value specifying the technique that is used to perform the procedure.", 0, 1, method);
          case -1335157162: /*device*/  return new Property("device", "CodeableReference(Device)", "A coded value specifying the technique that is used to perform the procedure.", 0, 1, device);
          case -1095204141: /*procedure*/  return new Property("procedure", "Reference(Procedure)", "The procedure event during which the specimen was collected (e.g. the surgery leading to the collection of a pathology sample).", 0, 1, procedure);
          case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableReference(BodyStructure)", "Anatomical location from which the specimen was collected (if subject is a patient). This is the target site.  This element is not used for environmental specimens.", 0, 1, bodySite);
          case -570577944: /*fastingStatus[x]*/  return new Property("fastingStatus[x]", "CodeableConcept|Duration", "Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.", 0, 1, fastingStatus);
          case -701550184: /*fastingStatus*/  return new Property("fastingStatus[x]", "CodeableConcept|Duration", "Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.", 0, 1, fastingStatus);
          case -1153232151: /*fastingStatusCodeableConcept*/  return new Property("fastingStatus[x]", "CodeableConcept", "Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.", 0, 1, fastingStatus);
          case -433140916: /*fastingStatusDuration*/  return new Property("fastingStatus[x]", "Duration", "Abstinence or reduction from some or all food, drink, or both, for a period of time prior to sample collection.", 0, 1, fastingStatus);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1883491469: /*collector*/ return this.collector == null ? new Base[0] : new Base[] {this.collector}; // Reference
        case 1883491145: /*collected*/ return this.collected == null ? new Base[0] : new Base[] {this.collected}; // DataType
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // Duration
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // CodeableReference
        case -1095204141: /*procedure*/ return this.procedure == null ? new Base[0] : new Base[] {this.procedure}; // Reference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableReference
        case -701550184: /*fastingStatus*/ return this.fastingStatus == null ? new Base[0] : new Base[] {this.fastingStatus}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1883491469: // collector
          this.collector = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1883491145: // collected
          this.collected = TypeConvertor.castToType(value); // DataType
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToDuration(value); // Duration
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1095204141: // procedure
          this.procedure = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -701550184: // fastingStatus
          this.fastingStatus = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("collector")) {
          this.collector = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("collected[x]")) {
          this.collected = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("duration")) {
          this.duration = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("procedure")) {
          this.procedure = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("fastingStatus[x]")) {
          this.fastingStatus = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1883491469:  return getCollector();
        case 1632037015:  return getCollected();
        case 1883491145:  return getCollected();
        case -1992012396:  return getDuration();
        case -1285004149:  return getQuantity();
        case -1077554975:  return getMethod();
        case -1335157162:  return getDevice();
        case -1095204141:  return getProcedure();
        case 1702620169:  return getBodySite();
        case -570577944:  return getFastingStatus();
        case -701550184:  return getFastingStatus();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1883491469: /*collector*/ return new String[] {"Reference"};
        case 1883491145: /*collected*/ return new String[] {"dateTime", "Period"};
        case -1992012396: /*duration*/ return new String[] {"Duration"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -1335157162: /*device*/ return new String[] {"CodeableReference"};
        case -1095204141: /*procedure*/ return new String[] {"Reference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableReference"};
        case -701550184: /*fastingStatus*/ return new String[] {"CodeableConcept", "Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("collector")) {
          this.collector = new Reference();
          return this.collector;
        }
        else if (name.equals("collectedDateTime")) {
          this.collected = new DateTimeType();
          return this.collected;
        }
        else if (name.equals("collectedPeriod")) {
          this.collected = new Period();
          return this.collected;
        }
        else if (name.equals("duration")) {
          this.duration = new Duration();
          return this.duration;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("device")) {
          this.device = new CodeableReference();
          return this.device;
        }
        else if (name.equals("procedure")) {
          this.procedure = new Reference();
          return this.procedure;
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableReference();
          return this.bodySite;
        }
        else if (name.equals("fastingStatusCodeableConcept")) {
          this.fastingStatus = new CodeableConcept();
          return this.fastingStatus;
        }
        else if (name.equals("fastingStatusDuration")) {
          this.fastingStatus = new Duration();
          return this.fastingStatus;
        }
        else
          return super.addChild(name);
      }

      public SpecimenCollectionComponent copy() {
        SpecimenCollectionComponent dst = new SpecimenCollectionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenCollectionComponent dst) {
        super.copyValues(dst);
        dst.collector = collector == null ? null : collector.copy();
        dst.collected = collected == null ? null : collected.copy();
        dst.duration = duration == null ? null : duration.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.method = method == null ? null : method.copy();
        dst.device = device == null ? null : device.copy();
        dst.procedure = procedure == null ? null : procedure.copy();
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        dst.fastingStatus = fastingStatus == null ? null : fastingStatus.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenCollectionComponent))
          return false;
        SpecimenCollectionComponent o = (SpecimenCollectionComponent) other_;
        return compareDeep(collector, o.collector, true) && compareDeep(collected, o.collected, true) && compareDeep(duration, o.duration, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(method, o.method, true) && compareDeep(device, o.device, true)
           && compareDeep(procedure, o.procedure, true) && compareDeep(bodySite, o.bodySite, true) && compareDeep(fastingStatus, o.fastingStatus, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenCollectionComponent))
          return false;
        SpecimenCollectionComponent o = (SpecimenCollectionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(collector, collected, duration
          , quantity, method, device, procedure, bodySite, fastingStatus);
      }

  public String fhirType() {
    return "Specimen.collection";

  }

  }

    @Block()
    public static class SpecimenProcessingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Textual description of procedure.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of procedure", formalDefinition="Textual description of procedure." )
        protected StringType description;

        /**
         * A coded value specifying the method used to process the specimen.
         */
        @Child(name = "method", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the treatment step  applied to the specimen", formalDefinition="A coded value specifying the method used to process the specimen." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-processing-method")
        protected CodeableConcept method;

        /**
         * Material used in the processing step.
         */
        @Child(name = "additive", type = {Substance.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Material used in the processing step", formalDefinition="Material used in the processing step." )
        protected List<Reference> additive;

        /**
         * A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.
         */
        @Child(name = "time", type = {DateTimeType.class, Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date and time of specimen processing", formalDefinition="A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin." )
        protected DataType time;

        private static final long serialVersionUID = -329044827L;

    /**
     * Constructor
     */
      public SpecimenProcessingComponent() {
        super();
      }

        /**
         * @return {@link #description} (Textual description of procedure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenProcessingComponent.description");
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
         * @param value {@link #description} (Textual description of procedure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SpecimenProcessingComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Textual description of procedure.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Textual description of procedure.
         */
        public SpecimenProcessingComponent setDescription(String value) { 
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
         * @return {@link #method} (A coded value specifying the method used to process the specimen.)
         */
        public CodeableConcept getMethod() { 
          if (this.method == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenProcessingComponent.method");
            else if (Configuration.doAutoCreate())
              this.method = new CodeableConcept(); // cc
          return this.method;
        }

        public boolean hasMethod() { 
          return this.method != null && !this.method.isEmpty();
        }

        /**
         * @param value {@link #method} (A coded value specifying the method used to process the specimen.)
         */
        public SpecimenProcessingComponent setMethod(CodeableConcept value) { 
          this.method = value;
          return this;
        }

        /**
         * @return {@link #additive} (Material used in the processing step.)
         */
        public List<Reference> getAdditive() { 
          if (this.additive == null)
            this.additive = new ArrayList<Reference>();
          return this.additive;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SpecimenProcessingComponent setAdditive(List<Reference> theAdditive) { 
          this.additive = theAdditive;
          return this;
        }

        public boolean hasAdditive() { 
          if (this.additive == null)
            return false;
          for (Reference item : this.additive)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addAdditive() { //3
          Reference t = new Reference();
          if (this.additive == null)
            this.additive = new ArrayList<Reference>();
          this.additive.add(t);
          return t;
        }

        public SpecimenProcessingComponent addAdditive(Reference t) { //3
          if (t == null)
            return this;
          if (this.additive == null)
            this.additive = new ArrayList<Reference>();
          this.additive.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #additive}, creating it if it does not already exist {3}
         */
        public Reference getAdditiveFirstRep() { 
          if (getAdditive().isEmpty()) {
            addAdditive();
          }
          return getAdditive().get(0);
        }

        /**
         * @return {@link #time} (A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.)
         */
        public DataType getTime() { 
          return this.time;
        }

        /**
         * @return {@link #time} (A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.)
         */
        public DateTimeType getTimeDateTimeType() throws FHIRException { 
          if (this.time == null)
            this.time = new DateTimeType();
          if (!(this.time instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.time.getClass().getName()+" was encountered");
          return (DateTimeType) this.time;
        }

        public boolean hasTimeDateTimeType() { 
          return this != null && this.time instanceof DateTimeType;
        }

        /**
         * @return {@link #time} (A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.)
         */
        public Period getTimePeriod() throws FHIRException { 
          if (this.time == null)
            this.time = new Period();
          if (!(this.time instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.time.getClass().getName()+" was encountered");
          return (Period) this.time;
        }

        public boolean hasTimePeriod() { 
          return this != null && this.time instanceof Period;
        }

        public boolean hasTime() { 
          return this.time != null && !this.time.isEmpty();
        }

        /**
         * @param value {@link #time} (A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.)
         */
        public SpecimenProcessingComponent setTime(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Period))
            throw new Error("Not the right type for Specimen.processing.time[x]: "+value.fhirType());
          this.time = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Textual description of procedure.", 0, 1, description));
          children.add(new Property("method", "CodeableConcept", "A coded value specifying the method used to process the specimen.", 0, 1, method));
          children.add(new Property("additive", "Reference(Substance)", "Material used in the processing step.", 0, java.lang.Integer.MAX_VALUE, additive));
          children.add(new Property("time[x]", "dateTime|Period", "A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.", 0, 1, time));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Textual description of procedure.", 0, 1, description);
          case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "A coded value specifying the method used to process the specimen.", 0, 1, method);
          case -1226589236: /*additive*/  return new Property("additive", "Reference(Substance)", "Material used in the processing step.", 0, java.lang.Integer.MAX_VALUE, additive);
          case -1313930605: /*time[x]*/  return new Property("time[x]", "dateTime|Period", "A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.", 0, 1, time);
          case 3560141: /*time*/  return new Property("time[x]", "dateTime|Period", "A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.", 0, 1, time);
          case 2135345544: /*timeDateTime*/  return new Property("time[x]", "dateTime", "A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.", 0, 1, time);
          case 693544686: /*timePeriod*/  return new Property("time[x]", "Period", "A record of the time or period when the specimen processing occurred.  For example the time of sample fixation or the period of time the sample was in formalin.", 0, 1, time);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case -1226589236: /*additive*/ return this.additive == null ? new Base[0] : this.additive.toArray(new Base[this.additive.size()]); // Reference
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1226589236: // additive
          this.getAdditive().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3560141: // time
          this.time = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("additive")) {
          this.getAdditive().add(TypeConvertor.castToReference(value));
        } else if (name.equals("time[x]")) {
          this.time = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -1077554975:  return getMethod();
        case -1226589236:  return addAdditive(); 
        case -1313930605:  return getTime();
        case 3560141:  return getTime();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -1226589236: /*additive*/ return new String[] {"Reference"};
        case 3560141: /*time*/ return new String[] {"dateTime", "Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Specimen.processing.description");
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("additive")) {
          return addAdditive();
        }
        else if (name.equals("timeDateTime")) {
          this.time = new DateTimeType();
          return this.time;
        }
        else if (name.equals("timePeriod")) {
          this.time = new Period();
          return this.time;
        }
        else
          return super.addChild(name);
      }

      public SpecimenProcessingComponent copy() {
        SpecimenProcessingComponent dst = new SpecimenProcessingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenProcessingComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.method = method == null ? null : method.copy();
        if (additive != null) {
          dst.additive = new ArrayList<Reference>();
          for (Reference i : additive)
            dst.additive.add(i.copy());
        };
        dst.time = time == null ? null : time.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenProcessingComponent))
          return false;
        SpecimenProcessingComponent o = (SpecimenProcessingComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(method, o.method, true) && compareDeep(additive, o.additive, true)
           && compareDeep(time, o.time, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenProcessingComponent))
          return false;
        SpecimenProcessingComponent o = (SpecimenProcessingComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, method, additive
          , time);
      }

  public String fhirType() {
    return "Specimen.processing";

  }

  }

    @Block()
    public static class SpecimenContainerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device.
         */
        @Child(name = "device", type = {Device.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device resource for the container", formalDefinition="The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device." )
        protected Reference device;

        /**
         * The location of the container holding the specimen.
         */
        @Child(name = "location", type = {Location.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Where the container is", formalDefinition="The location of the container holding the specimen." )
        protected Reference location;

        /**
         * The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type.
         */
        @Child(name = "specimenQuantity", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Quantity of specimen within container", formalDefinition="The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type." )
        protected Quantity specimenQuantity;

        private static final long serialVersionUID = 1973387427L;

    /**
     * Constructor
     */
      public SpecimenContainerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SpecimenContainerComponent(Reference device) {
        super();
        this.setDevice(device);
      }

        /**
         * @return {@link #device} (The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device.)
         */
        public Reference getDevice() { 
          if (this.device == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenContainerComponent.device");
            else if (Configuration.doAutoCreate())
              this.device = new Reference(); // cc
          return this.device;
        }

        public boolean hasDevice() { 
          return this.device != null && !this.device.isEmpty();
        }

        /**
         * @param value {@link #device} (The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device.)
         */
        public SpecimenContainerComponent setDevice(Reference value) { 
          this.device = value;
          return this;
        }

        /**
         * @return {@link #location} (The location of the container holding the specimen.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenContainerComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (The location of the container holding the specimen.)
         */
        public SpecimenContainerComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #specimenQuantity} (The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type.)
         */
        public Quantity getSpecimenQuantity() { 
          if (this.specimenQuantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenContainerComponent.specimenQuantity");
            else if (Configuration.doAutoCreate())
              this.specimenQuantity = new Quantity(); // cc
          return this.specimenQuantity;
        }

        public boolean hasSpecimenQuantity() { 
          return this.specimenQuantity != null && !this.specimenQuantity.isEmpty();
        }

        /**
         * @param value {@link #specimenQuantity} (The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type.)
         */
        public SpecimenContainerComponent setSpecimenQuantity(Quantity value) { 
          this.specimenQuantity = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("device", "Reference(Device)", "The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device.", 0, 1, device));
          children.add(new Property("location", "Reference(Location)", "The location of the container holding the specimen.", 0, 1, location));
          children.add(new Property("specimenQuantity", "Quantity", "The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type.", 0, 1, specimenQuantity));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "The device resource for the the container holding the specimen. If the container is in a holder then the referenced device will point to a parent device.", 0, 1, device);
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location of the container holding the specimen.", 0, 1, location);
          case 1485980595: /*specimenQuantity*/  return new Property("specimenQuantity", "Quantity", "The quantity of specimen in the container; may be volume, dimensions, or other appropriate measurements, depending on the specimen type.", 0, 1, specimenQuantity);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 1485980595: /*specimenQuantity*/ return this.specimenQuantity == null ? new Base[0] : new Base[] {this.specimenQuantity}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1485980595: // specimenQuantity
          this.specimenQuantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("specimenQuantity")) {
          this.specimenQuantity = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162:  return getDevice();
        case 1901043637:  return getLocation();
        case 1485980595:  return getSpecimenQuantity();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 1485980595: /*specimenQuantity*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("specimenQuantity")) {
          this.specimenQuantity = new Quantity();
          return this.specimenQuantity;
        }
        else
          return super.addChild(name);
      }

      public SpecimenContainerComponent copy() {
        SpecimenContainerComponent dst = new SpecimenContainerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenContainerComponent dst) {
        super.copyValues(dst);
        dst.device = device == null ? null : device.copy();
        dst.location = location == null ? null : location.copy();
        dst.specimenQuantity = specimenQuantity == null ? null : specimenQuantity.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenContainerComponent))
          return false;
        SpecimenContainerComponent o = (SpecimenContainerComponent) other_;
        return compareDeep(device, o.device, true) && compareDeep(location, o.location, true) && compareDeep(specimenQuantity, o.specimenQuantity, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenContainerComponent))
          return false;
        SpecimenContainerComponent o = (SpecimenContainerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(device, location, specimenQuantity
          );
      }

  public String fhirType() {
    return "Specimen.container";

  }

  }

    /**
     * Id for specimen.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Identifier", formalDefinition="Id for specimen." )
    protected List<Identifier> identifier;

    /**
     * The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures.
     */
    @Child(name = "accessionIdentifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identifier assigned by the lab", formalDefinition="The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures." )
    protected Identifier accessionIdentifier;

    /**
     * The availability of the specimen.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="available | unavailable | unsatisfactory | entered-in-error", formalDefinition="The availability of the specimen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-status")
    protected Enumeration<SpecimenStatus> status;

    /**
     * The kind of material that forms the specimen.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of material that forms the specimen", formalDefinition="The kind of material that forms the specimen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0487")
    protected CodeableConcept type;

    /**
     * Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, BiologicallyDerivedProduct.class, Substance.class, Location.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device", formalDefinition="Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device." )
    protected Reference subject;

    /**
     * Time when specimen is received by the testing laboratory for processing or testing.
     */
    @Child(name = "receivedTime", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The time when specimen is received by the testing laboratory", formalDefinition="Time when specimen is received by the testing laboratory for processing or testing." )
    protected DateTimeType receivedTime;

    /**
     * Reference to the parent (source) specimen which is used when the specimen was either derived from or a component of another specimen.
     */
    @Child(name = "parent", type = {Specimen.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Specimen from which this specimen originated", formalDefinition="Reference to the parent (source) specimen which is used when the specimen was either derived from or a component of another specimen." )
    protected List<Reference> parent;

    /**
     * Details concerning a service request that required a specimen to be collected.
     */
    @Child(name = "request", type = {ServiceRequest.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the specimen was collected", formalDefinition="Details concerning a service request that required a specimen to be collected." )
    protected List<Reference> request;

    /**
     * This element signifies if the specimen is part of a group or pooled.
     */
    @Child(name = "combined", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="grouped | pooled", formalDefinition="This element signifies if the specimen is part of a group or pooled." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-combined")
    protected Enumeration<SpecimenCombined> combined;

    /**
     * The role or reason for the specimen in the testing workflow.
     */
    @Child(name = "role", type = {CodeableConcept.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The role the specimen serves", formalDefinition="The role or reason for the specimen in the testing workflow." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-role")
    protected List<CodeableConcept> role;

    /**
     * A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g. surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor location).
     */
    @Child(name = "feature", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The physical feature of a specimen", formalDefinition="A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g. surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor location)." )
    protected List<SpecimenFeatureComponent> feature;

    /**
     * Details concerning the specimen collection.
     */
    @Child(name = "collection", type = {}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Collection details", formalDefinition="Details concerning the specimen collection." )
    protected SpecimenCollectionComponent collection;

    /**
     * Details concerning processing and processing steps for the specimen.
     */
    @Child(name = "processing", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Processing and processing step details", formalDefinition="Details concerning processing and processing steps for the specimen." )
    protected List<SpecimenProcessingComponent> processing;

    /**
     * The container holding the specimen.  The recursive nature of containers; i.e. blood in tube in tray in rack is not addressed here.
     */
    @Child(name = "container", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Direct container of specimen (tube/slide, etc.)", formalDefinition="The container holding the specimen.  The recursive nature of containers; i.e. blood in tube in tray in rack is not addressed here." )
    protected List<SpecimenContainerComponent> container;

    /**
     * A mode or state of being that describes the nature of the specimen.
     */
    @Child(name = "condition", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="State of the specimen", formalDefinition="A mode or state of being that describes the nature of the specimen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0493")
    protected List<CodeableConcept> condition;

    /**
     * To communicate any details or issues about the specimen or during the specimen collection. (for example: broken vial, sent with patient, frozen).
     */
    @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments", formalDefinition="To communicate any details or issues about the specimen or during the specimen collection. (for example: broken vial, sent with patient, frozen)." )
    protected List<Annotation> note;

    private static final long serialVersionUID = -445425000L;

  /**
   * Constructor
   */
    public Specimen() {
      super();
    }

    /**
     * @return {@link #identifier} (Id for specimen.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setIdentifier(List<Identifier> theIdentifier) { 
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

    public Specimen addIdentifier(Identifier t) { //3
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
     * @return {@link #accessionIdentifier} (The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures.)
     */
    public Identifier getAccessionIdentifier() { 
      if (this.accessionIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.accessionIdentifier");
        else if (Configuration.doAutoCreate())
          this.accessionIdentifier = new Identifier(); // cc
      return this.accessionIdentifier;
    }

    public boolean hasAccessionIdentifier() { 
      return this.accessionIdentifier != null && !this.accessionIdentifier.isEmpty();
    }

    /**
     * @param value {@link #accessionIdentifier} (The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures.)
     */
    public Specimen setAccessionIdentifier(Identifier value) { 
      this.accessionIdentifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The availability of the specimen.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<SpecimenStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SpecimenStatus>(new SpecimenStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The availability of the specimen.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Specimen setStatusElement(Enumeration<SpecimenStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The availability of the specimen.
     */
    public SpecimenStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The availability of the specimen.
     */
    public Specimen setStatus(SpecimenStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<SpecimenStatus>(new SpecimenStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (The kind of material that forms the specimen.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The kind of material that forms the specimen.)
     */
    public Specimen setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #subject} (Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device.)
     */
    public Specimen setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #receivedTime} (Time when specimen is received by the testing laboratory for processing or testing.). This is the underlying object with id, value and extensions. The accessor "getReceivedTime" gives direct access to the value
     */
    public DateTimeType getReceivedTimeElement() { 
      if (this.receivedTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.receivedTime");
        else if (Configuration.doAutoCreate())
          this.receivedTime = new DateTimeType(); // bb
      return this.receivedTime;
    }

    public boolean hasReceivedTimeElement() { 
      return this.receivedTime != null && !this.receivedTime.isEmpty();
    }

    public boolean hasReceivedTime() { 
      return this.receivedTime != null && !this.receivedTime.isEmpty();
    }

    /**
     * @param value {@link #receivedTime} (Time when specimen is received by the testing laboratory for processing or testing.). This is the underlying object with id, value and extensions. The accessor "getReceivedTime" gives direct access to the value
     */
    public Specimen setReceivedTimeElement(DateTimeType value) { 
      this.receivedTime = value;
      return this;
    }

    /**
     * @return Time when specimen is received by the testing laboratory for processing or testing.
     */
    public Date getReceivedTime() { 
      return this.receivedTime == null ? null : this.receivedTime.getValue();
    }

    /**
     * @param value Time when specimen is received by the testing laboratory for processing or testing.
     */
    public Specimen setReceivedTime(Date value) { 
      if (value == null)
        this.receivedTime = null;
      else {
        if (this.receivedTime == null)
          this.receivedTime = new DateTimeType();
        this.receivedTime.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #parent} (Reference to the parent (source) specimen which is used when the specimen was either derived from or a component of another specimen.)
     */
    public List<Reference> getParent() { 
      if (this.parent == null)
        this.parent = new ArrayList<Reference>();
      return this.parent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setParent(List<Reference> theParent) { 
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

    public Specimen addParent(Reference t) { //3
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
     * @return {@link #request} (Details concerning a service request that required a specimen to be collected.)
     */
    public List<Reference> getRequest() { 
      if (this.request == null)
        this.request = new ArrayList<Reference>();
      return this.request;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setRequest(List<Reference> theRequest) { 
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

    public Specimen addRequest(Reference t) { //3
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
     * @return {@link #combined} (This element signifies if the specimen is part of a group or pooled.). This is the underlying object with id, value and extensions. The accessor "getCombined" gives direct access to the value
     */
    public Enumeration<SpecimenCombined> getCombinedElement() { 
      if (this.combined == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.combined");
        else if (Configuration.doAutoCreate())
          this.combined = new Enumeration<SpecimenCombined>(new SpecimenCombinedEnumFactory()); // bb
      return this.combined;
    }

    public boolean hasCombinedElement() { 
      return this.combined != null && !this.combined.isEmpty();
    }

    public boolean hasCombined() { 
      return this.combined != null && !this.combined.isEmpty();
    }

    /**
     * @param value {@link #combined} (This element signifies if the specimen is part of a group or pooled.). This is the underlying object with id, value and extensions. The accessor "getCombined" gives direct access to the value
     */
    public Specimen setCombinedElement(Enumeration<SpecimenCombined> value) { 
      this.combined = value;
      return this;
    }

    /**
     * @return This element signifies if the specimen is part of a group or pooled.
     */
    public SpecimenCombined getCombined() { 
      return this.combined == null ? null : this.combined.getValue();
    }

    /**
     * @param value This element signifies if the specimen is part of a group or pooled.
     */
    public Specimen setCombined(SpecimenCombined value) { 
      if (value == null)
        this.combined = null;
      else {
        if (this.combined == null)
          this.combined = new Enumeration<SpecimenCombined>(new SpecimenCombinedEnumFactory());
        this.combined.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #role} (The role or reason for the specimen in the testing workflow.)
     */
    public List<CodeableConcept> getRole() { 
      if (this.role == null)
        this.role = new ArrayList<CodeableConcept>();
      return this.role;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setRole(List<CodeableConcept> theRole) { 
      this.role = theRole;
      return this;
    }

    public boolean hasRole() { 
      if (this.role == null)
        return false;
      for (CodeableConcept item : this.role)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addRole() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.role == null)
        this.role = new ArrayList<CodeableConcept>();
      this.role.add(t);
      return t;
    }

    public Specimen addRole(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.role == null)
        this.role = new ArrayList<CodeableConcept>();
      this.role.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #role}, creating it if it does not already exist {3}
     */
    public CodeableConcept getRoleFirstRep() { 
      if (getRole().isEmpty()) {
        addRole();
      }
      return getRole().get(0);
    }

    /**
     * @return {@link #feature} (A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g. surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor location).)
     */
    public List<SpecimenFeatureComponent> getFeature() { 
      if (this.feature == null)
        this.feature = new ArrayList<SpecimenFeatureComponent>();
      return this.feature;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setFeature(List<SpecimenFeatureComponent> theFeature) { 
      this.feature = theFeature;
      return this;
    }

    public boolean hasFeature() { 
      if (this.feature == null)
        return false;
      for (SpecimenFeatureComponent item : this.feature)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SpecimenFeatureComponent addFeature() { //3
      SpecimenFeatureComponent t = new SpecimenFeatureComponent();
      if (this.feature == null)
        this.feature = new ArrayList<SpecimenFeatureComponent>();
      this.feature.add(t);
      return t;
    }

    public Specimen addFeature(SpecimenFeatureComponent t) { //3
      if (t == null)
        return this;
      if (this.feature == null)
        this.feature = new ArrayList<SpecimenFeatureComponent>();
      this.feature.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #feature}, creating it if it does not already exist {3}
     */
    public SpecimenFeatureComponent getFeatureFirstRep() { 
      if (getFeature().isEmpty()) {
        addFeature();
      }
      return getFeature().get(0);
    }

    /**
     * @return {@link #collection} (Details concerning the specimen collection.)
     */
    public SpecimenCollectionComponent getCollection() { 
      if (this.collection == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Specimen.collection");
        else if (Configuration.doAutoCreate())
          this.collection = new SpecimenCollectionComponent(); // cc
      return this.collection;
    }

    public boolean hasCollection() { 
      return this.collection != null && !this.collection.isEmpty();
    }

    /**
     * @param value {@link #collection} (Details concerning the specimen collection.)
     */
    public Specimen setCollection(SpecimenCollectionComponent value) { 
      this.collection = value;
      return this;
    }

    /**
     * @return {@link #processing} (Details concerning processing and processing steps for the specimen.)
     */
    public List<SpecimenProcessingComponent> getProcessing() { 
      if (this.processing == null)
        this.processing = new ArrayList<SpecimenProcessingComponent>();
      return this.processing;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setProcessing(List<SpecimenProcessingComponent> theProcessing) { 
      this.processing = theProcessing;
      return this;
    }

    public boolean hasProcessing() { 
      if (this.processing == null)
        return false;
      for (SpecimenProcessingComponent item : this.processing)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SpecimenProcessingComponent addProcessing() { //3
      SpecimenProcessingComponent t = new SpecimenProcessingComponent();
      if (this.processing == null)
        this.processing = new ArrayList<SpecimenProcessingComponent>();
      this.processing.add(t);
      return t;
    }

    public Specimen addProcessing(SpecimenProcessingComponent t) { //3
      if (t == null)
        return this;
      if (this.processing == null)
        this.processing = new ArrayList<SpecimenProcessingComponent>();
      this.processing.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #processing}, creating it if it does not already exist {3}
     */
    public SpecimenProcessingComponent getProcessingFirstRep() { 
      if (getProcessing().isEmpty()) {
        addProcessing();
      }
      return getProcessing().get(0);
    }

    /**
     * @return {@link #container} (The container holding the specimen.  The recursive nature of containers; i.e. blood in tube in tray in rack is not addressed here.)
     */
    public List<SpecimenContainerComponent> getContainer() { 
      if (this.container == null)
        this.container = new ArrayList<SpecimenContainerComponent>();
      return this.container;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setContainer(List<SpecimenContainerComponent> theContainer) { 
      this.container = theContainer;
      return this;
    }

    public boolean hasContainer() { 
      if (this.container == null)
        return false;
      for (SpecimenContainerComponent item : this.container)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SpecimenContainerComponent addContainer() { //3
      SpecimenContainerComponent t = new SpecimenContainerComponent();
      if (this.container == null)
        this.container = new ArrayList<SpecimenContainerComponent>();
      this.container.add(t);
      return t;
    }

    public Specimen addContainer(SpecimenContainerComponent t) { //3
      if (t == null)
        return this;
      if (this.container == null)
        this.container = new ArrayList<SpecimenContainerComponent>();
      this.container.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #container}, creating it if it does not already exist {3}
     */
    public SpecimenContainerComponent getContainerFirstRep() { 
      if (getContainer().isEmpty()) {
        addContainer();
      }
      return getContainer().get(0);
    }

    /**
     * @return {@link #condition} (A mode or state of being that describes the nature of the specimen.)
     */
    public List<CodeableConcept> getCondition() { 
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      return this.condition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setCondition(List<CodeableConcept> theCondition) { 
      this.condition = theCondition;
      return this;
    }

    public boolean hasCondition() { 
      if (this.condition == null)
        return false;
      for (CodeableConcept item : this.condition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCondition() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      this.condition.add(t);
      return t;
    }

    public Specimen addCondition(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      this.condition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
     */
    public CodeableConcept getConditionFirstRep() { 
      if (getCondition().isEmpty()) {
        addCondition();
      }
      return getCondition().get(0);
    }

    /**
     * @return {@link #note} (To communicate any details or issues about the specimen or during the specimen collection. (for example: broken vial, sent with patient, frozen).)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Specimen setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public Specimen addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Id for specimen.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("accessionIdentifier", "Identifier", "The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures.", 0, 1, accessionIdentifier));
        children.add(new Property("status", "code", "The availability of the specimen.", 0, 1, status));
        children.add(new Property("type", "CodeableConcept", "The kind of material that forms the specimen.", 0, 1, type));
        children.add(new Property("subject", "Reference(Patient|Group|Device|BiologicallyDerivedProduct|Substance|Location)", "Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device.", 0, 1, subject));
        children.add(new Property("receivedTime", "dateTime", "Time when specimen is received by the testing laboratory for processing or testing.", 0, 1, receivedTime));
        children.add(new Property("parent", "Reference(Specimen)", "Reference to the parent (source) specimen which is used when the specimen was either derived from or a component of another specimen.", 0, java.lang.Integer.MAX_VALUE, parent));
        children.add(new Property("request", "Reference(ServiceRequest)", "Details concerning a service request that required a specimen to be collected.", 0, java.lang.Integer.MAX_VALUE, request));
        children.add(new Property("combined", "code", "This element signifies if the specimen is part of a group or pooled.", 0, 1, combined));
        children.add(new Property("role", "CodeableConcept", "The role or reason for the specimen in the testing workflow.", 0, java.lang.Integer.MAX_VALUE, role));
        children.add(new Property("feature", "", "A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g. surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor location).", 0, java.lang.Integer.MAX_VALUE, feature));
        children.add(new Property("collection", "", "Details concerning the specimen collection.", 0, 1, collection));
        children.add(new Property("processing", "", "Details concerning processing and processing steps for the specimen.", 0, java.lang.Integer.MAX_VALUE, processing));
        children.add(new Property("container", "", "The container holding the specimen.  The recursive nature of containers; i.e. blood in tube in tray in rack is not addressed here.", 0, java.lang.Integer.MAX_VALUE, container));
        children.add(new Property("condition", "CodeableConcept", "A mode or state of being that describes the nature of the specimen.", 0, java.lang.Integer.MAX_VALUE, condition));
        children.add(new Property("note", "Annotation", "To communicate any details or issues about the specimen or during the specimen collection. (for example: broken vial, sent with patient, frozen).", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Id for specimen.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 818734061: /*accessionIdentifier*/  return new Property("accessionIdentifier", "Identifier", "The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the same as the specimen identifier, depending on local lab procedures.", 0, 1, accessionIdentifier);
        case -892481550: /*status*/  return new Property("status", "code", "The availability of the specimen.", 0, 1, status);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of material that forms the specimen.", 0, 1, type);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|BiologicallyDerivedProduct|Substance|Location)", "Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an environmental sample), or a sampling of a substance, a biologically-derived product, or a device.", 0, 1, subject);
        case -767961010: /*receivedTime*/  return new Property("receivedTime", "dateTime", "Time when specimen is received by the testing laboratory for processing or testing.", 0, 1, receivedTime);
        case -995424086: /*parent*/  return new Property("parent", "Reference(Specimen)", "Reference to the parent (source) specimen which is used when the specimen was either derived from or a component of another specimen.", 0, java.lang.Integer.MAX_VALUE, parent);
        case 1095692943: /*request*/  return new Property("request", "Reference(ServiceRequest)", "Details concerning a service request that required a specimen to be collected.", 0, java.lang.Integer.MAX_VALUE, request);
        case -612455675: /*combined*/  return new Property("combined", "code", "This element signifies if the specimen is part of a group or pooled.", 0, 1, combined);
        case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role or reason for the specimen in the testing workflow.", 0, java.lang.Integer.MAX_VALUE, role);
        case -979207434: /*feature*/  return new Property("feature", "", "A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g. surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor location).", 0, java.lang.Integer.MAX_VALUE, feature);
        case -1741312354: /*collection*/  return new Property("collection", "", "Details concerning the specimen collection.", 0, 1, collection);
        case 422194963: /*processing*/  return new Property("processing", "", "Details concerning processing and processing steps for the specimen.", 0, java.lang.Integer.MAX_VALUE, processing);
        case -410956671: /*container*/  return new Property("container", "", "The container holding the specimen.  The recursive nature of containers; i.e. blood in tube in tray in rack is not addressed here.", 0, java.lang.Integer.MAX_VALUE, container);
        case -861311717: /*condition*/  return new Property("condition", "CodeableConcept", "A mode or state of being that describes the nature of the specimen.", 0, java.lang.Integer.MAX_VALUE, condition);
        case 3387378: /*note*/  return new Property("note", "Annotation", "To communicate any details or issues about the specimen or during the specimen collection. (for example: broken vial, sent with patient, frozen).", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 818734061: /*accessionIdentifier*/ return this.accessionIdentifier == null ? new Base[0] : new Base[] {this.accessionIdentifier}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SpecimenStatus>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -767961010: /*receivedTime*/ return this.receivedTime == null ? new Base[0] : new Base[] {this.receivedTime}; // DateTimeType
        case -995424086: /*parent*/ return this.parent == null ? new Base[0] : this.parent.toArray(new Base[this.parent.size()]); // Reference
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : this.request.toArray(new Base[this.request.size()]); // Reference
        case -612455675: /*combined*/ return this.combined == null ? new Base[0] : new Base[] {this.combined}; // Enumeration<SpecimenCombined>
        case 3506294: /*role*/ return this.role == null ? new Base[0] : this.role.toArray(new Base[this.role.size()]); // CodeableConcept
        case -979207434: /*feature*/ return this.feature == null ? new Base[0] : this.feature.toArray(new Base[this.feature.size()]); // SpecimenFeatureComponent
        case -1741312354: /*collection*/ return this.collection == null ? new Base[0] : new Base[] {this.collection}; // SpecimenCollectionComponent
        case 422194963: /*processing*/ return this.processing == null ? new Base[0] : this.processing.toArray(new Base[this.processing.size()]); // SpecimenProcessingComponent
        case -410956671: /*container*/ return this.container == null ? new Base[0] : this.container.toArray(new Base[this.container.size()]); // SpecimenContainerComponent
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // CodeableConcept
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 818734061: // accessionIdentifier
          this.accessionIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new SpecimenStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SpecimenStatus>
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -767961010: // receivedTime
          this.receivedTime = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -995424086: // parent
          this.getParent().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1095692943: // request
          this.getRequest().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -612455675: // combined
          value = new SpecimenCombinedEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.combined = (Enumeration) value; // Enumeration<SpecimenCombined>
          return value;
        case 3506294: // role
          this.getRole().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -979207434: // feature
          this.getFeature().add((SpecimenFeatureComponent) value); // SpecimenFeatureComponent
          return value;
        case -1741312354: // collection
          this.collection = (SpecimenCollectionComponent) value; // SpecimenCollectionComponent
          return value;
        case 422194963: // processing
          this.getProcessing().add((SpecimenProcessingComponent) value); // SpecimenProcessingComponent
          return value;
        case -410956671: // container
          this.getContainer().add((SpecimenContainerComponent) value); // SpecimenContainerComponent
          return value;
        case -861311717: // condition
          this.getCondition().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("accessionIdentifier")) {
          this.accessionIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new SpecimenStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SpecimenStatus>
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("receivedTime")) {
          this.receivedTime = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("parent")) {
          this.getParent().add(TypeConvertor.castToReference(value));
        } else if (name.equals("request")) {
          this.getRequest().add(TypeConvertor.castToReference(value));
        } else if (name.equals("combined")) {
          value = new SpecimenCombinedEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.combined = (Enumeration) value; // Enumeration<SpecimenCombined>
        } else if (name.equals("role")) {
          this.getRole().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("feature")) {
          this.getFeature().add((SpecimenFeatureComponent) value);
        } else if (name.equals("collection")) {
          this.collection = (SpecimenCollectionComponent) value; // SpecimenCollectionComponent
        } else if (name.equals("processing")) {
          this.getProcessing().add((SpecimenProcessingComponent) value);
        } else if (name.equals("container")) {
          this.getContainer().add((SpecimenContainerComponent) value);
        } else if (name.equals("condition")) {
          this.getCondition().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 818734061:  return getAccessionIdentifier();
        case -892481550:  return getStatusElement();
        case 3575610:  return getType();
        case -1867885268:  return getSubject();
        case -767961010:  return getReceivedTimeElement();
        case -995424086:  return addParent(); 
        case 1095692943:  return addRequest(); 
        case -612455675:  return getCombinedElement();
        case 3506294:  return addRole(); 
        case -979207434:  return addFeature(); 
        case -1741312354:  return getCollection();
        case 422194963:  return addProcessing(); 
        case -410956671:  return addContainer(); 
        case -861311717:  return addCondition(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 818734061: /*accessionIdentifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -767961010: /*receivedTime*/ return new String[] {"dateTime"};
        case -995424086: /*parent*/ return new String[] {"Reference"};
        case 1095692943: /*request*/ return new String[] {"Reference"};
        case -612455675: /*combined*/ return new String[] {"code"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -979207434: /*feature*/ return new String[] {};
        case -1741312354: /*collection*/ return new String[] {};
        case 422194963: /*processing*/ return new String[] {};
        case -410956671: /*container*/ return new String[] {};
        case -861311717: /*condition*/ return new String[] {"CodeableConcept"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("accessionIdentifier")) {
          this.accessionIdentifier = new Identifier();
          return this.accessionIdentifier;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Specimen.status");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("receivedTime")) {
          throw new FHIRException("Cannot call addChild on a primitive type Specimen.receivedTime");
        }
        else if (name.equals("parent")) {
          return addParent();
        }
        else if (name.equals("request")) {
          return addRequest();
        }
        else if (name.equals("combined")) {
          throw new FHIRException("Cannot call addChild on a primitive type Specimen.combined");
        }
        else if (name.equals("role")) {
          return addRole();
        }
        else if (name.equals("feature")) {
          return addFeature();
        }
        else if (name.equals("collection")) {
          this.collection = new SpecimenCollectionComponent();
          return this.collection;
        }
        else if (name.equals("processing")) {
          return addProcessing();
        }
        else if (name.equals("container")) {
          return addContainer();
        }
        else if (name.equals("condition")) {
          return addCondition();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Specimen";

  }

      public Specimen copy() {
        Specimen dst = new Specimen();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Specimen dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.accessionIdentifier = accessionIdentifier == null ? null : accessionIdentifier.copy();
        dst.status = status == null ? null : status.copy();
        dst.type = type == null ? null : type.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.receivedTime = receivedTime == null ? null : receivedTime.copy();
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
        dst.combined = combined == null ? null : combined.copy();
        if (role != null) {
          dst.role = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : role)
            dst.role.add(i.copy());
        };
        if (feature != null) {
          dst.feature = new ArrayList<SpecimenFeatureComponent>();
          for (SpecimenFeatureComponent i : feature)
            dst.feature.add(i.copy());
        };
        dst.collection = collection == null ? null : collection.copy();
        if (processing != null) {
          dst.processing = new ArrayList<SpecimenProcessingComponent>();
          for (SpecimenProcessingComponent i : processing)
            dst.processing.add(i.copy());
        };
        if (container != null) {
          dst.container = new ArrayList<SpecimenContainerComponent>();
          for (SpecimenContainerComponent i : container)
            dst.container.add(i.copy());
        };
        if (condition != null) {
          dst.condition = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : condition)
            dst.condition.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected Specimen typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Specimen))
          return false;
        Specimen o = (Specimen) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(accessionIdentifier, o.accessionIdentifier, true)
           && compareDeep(status, o.status, true) && compareDeep(type, o.type, true) && compareDeep(subject, o.subject, true)
           && compareDeep(receivedTime, o.receivedTime, true) && compareDeep(parent, o.parent, true) && compareDeep(request, o.request, true)
           && compareDeep(combined, o.combined, true) && compareDeep(role, o.role, true) && compareDeep(feature, o.feature, true)
           && compareDeep(collection, o.collection, true) && compareDeep(processing, o.processing, true) && compareDeep(container, o.container, true)
           && compareDeep(condition, o.condition, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Specimen))
          return false;
        Specimen o = (Specimen) other_;
        return compareValues(status, o.status, true) && compareValues(receivedTime, o.receivedTime, true) && compareValues(combined, o.combined, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, accessionIdentifier
          , status, type, subject, receivedTime, parent, request, combined, role, feature
          , collection, processing, container, condition, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Specimen;
   }

 /**
   * Search parameter: <b>accession</b>
   * <p>
   * Description: <b>The accession number associated with the specimen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Specimen.accessionIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="accession", path="Specimen.accessionIdentifier", description="The accession number associated with the specimen", type="token" )
  public static final String SP_ACCESSION = "accession";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>accession</b>
   * <p>
   * Description: <b>The accession number associated with the specimen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Specimen.accessionIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACCESSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACCESSION);

 /**
   * Search parameter: <b>bodysite</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.bodySite.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="bodysite", path="Specimen.collection.bodySite.reference", description="Reference to a resource (by instance)", type="reference", target={BodyStructure.class } )
  public static final String SP_BODYSITE = "bodysite";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>bodysite</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.bodySite.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BODYSITE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BODYSITE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:bodysite</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BODYSITE = new ca.uhn.fhir.model.api.Include("Specimen:bodysite").toLocked();

 /**
   * Search parameter: <b>collected</b>
   * <p>
   * Description: <b>The date the specimen was collected</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Specimen.collection.collected.ofType(dateTime) | Specimen.collection.collected.ofType(Period)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="collected", path="Specimen.collection.collected.ofType(dateTime) | Specimen.collection.collected.ofType(Period)", description="The date the specimen was collected", type="date" )
  public static final String SP_COLLECTED = "collected";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>collected</b>
   * <p>
   * Description: <b>The date the specimen was collected</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Specimen.collection.collected.ofType(dateTime) | Specimen.collection.collected.ofType(Period)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam COLLECTED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_COLLECTED);

 /**
   * Search parameter: <b>collector</b>
   * <p>
   * Description: <b>Who collected the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.collector</b><br>
   * </p>
   */
  @SearchParamDefinition(name="collector", path="Specimen.collection.collector", description="Who collected the specimen", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_COLLECTOR = "collector";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>collector</b>
   * <p>
   * Description: <b>Who collected the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.collector</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COLLECTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_COLLECTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:collector</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COLLECTOR = new ca.uhn.fhir.model.api.Include("Specimen:collector").toLocked();

 /**
   * Search parameter: <b>container-device</b>
   * <p>
   * Description: <b>The unique identifier associated with the specimen container</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.container.device.where(resolve() is Device)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="container-device", path="Specimen.container.device.where(resolve() is Device)", description="The unique identifier associated with the specimen container", type="reference", target={Device.class } )
  public static final String SP_CONTAINER_DEVICE = "container-device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>container-device</b>
   * <p>
   * Description: <b>The unique identifier associated with the specimen container</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.container.device.where(resolve() is Device)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTAINER_DEVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTAINER_DEVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:container-device</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTAINER_DEVICE = new ca.uhn.fhir.model.api.Include("Specimen:container-device").toLocked();

 /**
   * Search parameter: <b>parent</b>
   * <p>
   * Description: <b>The parent of the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.parent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="parent", path="Specimen.parent", description="The parent of the specimen", type="reference", target={Specimen.class } )
  public static final String SP_PARENT = "parent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>parent</b>
   * <p>
   * Description: <b>The parent of the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.parent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:parent</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARENT = new ca.uhn.fhir.model.api.Include("Specimen:parent").toLocked();

 /**
   * Search parameter: <b>procedure</b>
   * <p>
   * Description: <b>The procedure that collected the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.procedure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="procedure", path="Specimen.collection.procedure", description="The procedure that collected the specimen", type="reference", target={Procedure.class } )
  public static final String SP_PROCEDURE = "procedure";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>procedure</b>
   * <p>
   * Description: <b>The procedure that collected the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.collection.procedure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PROCEDURE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PROCEDURE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:procedure</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PROCEDURE = new ca.uhn.fhir.model.api.Include("Specimen:procedure").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>available | unavailable | unsatisfactory | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Specimen.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Specimen.status", description="available | unavailable | unsatisfactory | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>available | unavailable | unsatisfactory | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Specimen.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject of the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Specimen.subject", description="The subject of the specimen", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Patient.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject of the specimen</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Specimen.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Specimen:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Specimen:subject").toLocked();

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
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
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
   * the path value of "<b>Specimen:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Specimen:patient").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type", description="Multiple Resources: \r\n\r\n* [Account](account.html): E.g. patient, expense, depreciation\r\n* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)\r\n* [Composition](composition.html): Kind of composition (LOINC if possible)\r\n* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)\r\n* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)\r\n* [Encounter](encounter.html): Specific type of encounter\r\n* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management\r\n* [Invoice](invoice.html): Type of Invoice\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type\r\n* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence\r\n* [Specimen](specimen.html): The specimen type\r\n", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): E.g. patient, expense, depreciation
* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [Coverage](coverage.html): The kind of coverage (health plan, auto, Workers Compensation)
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
* [Invoice](invoice.html): Type of Invoice
* [MedicationDispense](medicationdispense.html): Returns dispenses of a specific type
* [MolecularSequence](molecularsequence.html): Amino Acid Sequence/ DNA Sequence / RNA Sequence
* [Specimen](specimen.html): The specimen type
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.type | AllergyIntolerance.type | Composition.type | Coverage.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type | Invoice.type | MedicationDispense.type | MolecularSequence.type | Specimen.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

