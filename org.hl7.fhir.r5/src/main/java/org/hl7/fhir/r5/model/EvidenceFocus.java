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
 * EvidenceFocus.
 */
@ResourceDef(name="EvidenceFocus", profile="http://hl7.org/fhir/StructureDefinition/EvidenceFocus")
public class EvidenceFocus extends MetadataResource {

    @Block()
    public static class EvidenceFocusCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Characteristic code.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Characteristic code", formalDefinition="Characteristic code." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/evfocus-characteristic-code")
        protected CodeableConcept code;

        /**
         * Characteristic value.
         */
        @Child(name = "value", type = {Reference.class, CodeableConcept.class, BooleanType.class, Quantity.class, Range.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Characteristic value", formalDefinition="Characteristic value." )
        protected DataType value;

        /**
         * Is used to express not the characteristic.
         */
        @Child(name = "exclude", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Is used to express not the characteristic", formalDefinition="Is used to express not the characteristic." )
        protected BooleanType exclude;

        /**
         * Timeframe for the characteristic.
         */
        @Child(name = "period", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Timeframe for the characteristic", formalDefinition="Timeframe for the characteristic." )
        protected Period period;

        private static final long serialVersionUID = 279867823L;

    /**
     * Constructor
     */
      public EvidenceFocusCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceFocusCharacteristicComponent(CodeableConcept code, DataType value) {
        super();
        this.setCode(code);
        this.setValue(value);
      }

        /**
         * @return {@link #code} (Characteristic code.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceFocusCharacteristicComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Characteristic code.)
         */
        public EvidenceFocusCharacteristicComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (Characteristic value.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Characteristic value.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        /**
         * @return {@link #value} (Characteristic value.)
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
         * @return {@link #value} (Characteristic value.)
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
         * @return {@link #value} (Characteristic value.)
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
         * @return {@link #value} (Characteristic value.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Characteristic value.)
         */
        public EvidenceFocusCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept || value instanceof BooleanType || value instanceof Quantity || value instanceof Range))
            throw new Error("Not the right type for EvidenceFocus.characteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #exclude} (Is used to express not the characteristic.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public BooleanType getExcludeElement() { 
          if (this.exclude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceFocusCharacteristicComponent.exclude");
            else if (Configuration.doAutoCreate())
              this.exclude = new BooleanType(); // bb
          return this.exclude;
        }

        public boolean hasExcludeElement() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        public boolean hasExclude() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        /**
         * @param value {@link #exclude} (Is used to express not the characteristic.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public EvidenceFocusCharacteristicComponent setExcludeElement(BooleanType value) { 
          this.exclude = value;
          return this;
        }

        /**
         * @return Is used to express not the characteristic.
         */
        public boolean getExclude() { 
          return this.exclude == null || this.exclude.isEmpty() ? false : this.exclude.getValue();
        }

        /**
         * @param value Is used to express not the characteristic.
         */
        public EvidenceFocusCharacteristicComponent setExclude(boolean value) { 
            if (this.exclude == null)
              this.exclude = new BooleanType();
            this.exclude.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (Timeframe for the characteristic.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceFocusCharacteristicComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Timeframe for the characteristic.)
         */
        public EvidenceFocusCharacteristicComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Characteristic code.", 0, 1, code));
          children.add(new Property("value[x]", "Reference(Any)|CodeableConcept|boolean|Quantity|Range", "Characteristic value.", 0, 1, value));
          children.add(new Property("exclude", "boolean", "Is used to express not the characteristic.", 0, 1, exclude));
          children.add(new Property("period", "Period", "Timeframe for the characteristic.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Characteristic code.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Reference(Any)|CodeableConcept|boolean|Quantity|Range", "Characteristic value.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Reference(Any)|CodeableConcept|boolean|Quantity|Range", "Characteristic value.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference(Any)", "Characteristic value.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Characteristic value.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Characteristic value.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Characteristic value.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Characteristic value.", 0, 1, value);
          case -1321148966: /*exclude*/  return new Property("exclude", "boolean", "Is used to express not the characteristic.", 0, 1, exclude);
          case -991726143: /*period*/  return new Property("period", "Period", "Timeframe for the characteristic.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1321148966: /*exclude*/ return this.exclude == null ? new Base[0] : new Base[] {this.exclude}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1321148966: // exclude
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("exclude")) {
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
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
        case -1321148966:  return getExcludeElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Reference", "CodeableConcept", "boolean", "Quantity", "Range"};
        case -1321148966: /*exclude*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
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
        else if (name.equals("exclude")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.characteristic.exclude");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public EvidenceFocusCharacteristicComponent copy() {
        EvidenceFocusCharacteristicComponent dst = new EvidenceFocusCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceFocusCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
        dst.exclude = exclude == null ? null : exclude.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceFocusCharacteristicComponent))
          return false;
        EvidenceFocusCharacteristicComponent o = (EvidenceFocusCharacteristicComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true) && compareDeep(exclude, o.exclude, true)
           && compareDeep(period, o.period, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceFocusCharacteristicComponent))
          return false;
        EvidenceFocusCharacteristicComponent o = (EvidenceFocusCharacteristicComponent) other_;
        return compareValues(exclude, o.exclude, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, exclude, period
          );
      }

  public String fhirType() {
    return "EvidenceFocus.characteristic";

  }

  }

    /**
     * An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this EvidenceFocus, represented as a globally unique URI", formalDefinition="An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique to the EvidenceFocus Resource", formalDefinition="A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of this summary", formalDefinition="The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name", formalDefinition="A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence focus instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Use context", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence focus instances." )
    protected List<UsageContext> useContext;

    /**
     * The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date created", formalDefinition="The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes." )
    protected DateTimeType date;

    /**
     * Used for general notes and annotations not coded elsewhere.
     */
    @Child(name = "note", type = {Annotation.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Used for general notes and annotations not coded elsewhere." )
    protected List<Annotation> note;

    /**
     * A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright", formalDefinition="A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus." )
    protected MarkdownType copyright;

    /**
     * Citation for this EvidenceFocus resource.
     */
    @Child(name = "citeAs", type = {Citation.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Citation for this EvidenceFocus resource", formalDefinition="Citation for this EvidenceFocus resource." )
    protected Reference citeAs;

    /**
     * Characteristic.
     */
    @Child(name = "characteristic", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Characteristic", formalDefinition="Characteristic." )
    protected List<EvidenceFocusCharacteristicComponent> characteristic;

    /**
     * Additional documentation.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation", formalDefinition="Additional documentation." )
    protected List<RelatedArtifact> relatedArtifact;

    private static final long serialVersionUID = 1053034569L;

  /**
   * Constructor
   */
    public EvidenceFocus() {
      super();
    }

  /**
   * Constructor
   */
    public EvidenceFocus(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public EvidenceFocus setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public EvidenceFocus setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setIdentifier(List<Identifier> theIdentifier) { 
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

    public EvidenceFocus addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public EvidenceFocus setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public EvidenceFocus setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.name");
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
     * @param value {@link #name} (A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public EvidenceFocus setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public EvidenceFocus setName(String value) { 
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
     * @return {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public EvidenceFocus setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this summary. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this summary. Enables tracking the life-cycle of the content.
     */
    public EvidenceFocus setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence focus instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public EvidenceFocus addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public EvidenceFocus setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.
     */
    public EvidenceFocus setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Used for general notes and annotations not coded elsewhere.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setNote(List<Annotation> theNote) { 
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

    public EvidenceFocus addNote(Annotation t) { //3
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

    /**
     * @return {@link #copyright} (A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public EvidenceFocus setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.
     */
    public EvidenceFocus setCopyright(String value) { 
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #citeAs} (Citation for this EvidenceFocus resource.)
     */
    public Reference getCiteAs() { 
      if (this.citeAs == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceFocus.citeAs");
        else if (Configuration.doAutoCreate())
          this.citeAs = new Reference(); // cc
      return this.citeAs;
    }

    public boolean hasCiteAs() { 
      return this.citeAs != null && !this.citeAs.isEmpty();
    }

    /**
     * @param value {@link #citeAs} (Citation for this EvidenceFocus resource.)
     */
    public EvidenceFocus setCiteAs(Reference value) { 
      this.citeAs = value;
      return this;
    }

    /**
     * @return {@link #characteristic} (Characteristic.)
     */
    public List<EvidenceFocusCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceFocusCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setCharacteristic(List<EvidenceFocusCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (EvidenceFocusCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceFocusCharacteristicComponent addCharacteristic() { //3
      EvidenceFocusCharacteristicComponent t = new EvidenceFocusCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceFocusCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public EvidenceFocus addCharacteristic(EvidenceFocusCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceFocusCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public EvidenceFocusCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Additional documentation.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public EvidenceFocus addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTitleMax() { 
      return 0;
    }
    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"title\"");
    }

    public boolean hasTitleElement() { 
      return false;
    }
    public boolean hasTitle() {
      return false;
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public EvidenceFocus setTitleElement(StringType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"title\"");
    }
    public String getTitle() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"title\"");
    }
    /**
     * @param value A short, descriptive, user-friendly title for the evidence focus.
     */
    public EvidenceFocus setTitle(String value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"title\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getExperimentalMax() { 
      return 0;
    }
    /**
     * @return {@link #experimental} (A Boolean value to indicate that this evidence focus is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"experimental\"");
    }

    public boolean hasExperimentalElement() { 
      return false;
    }
    public boolean hasExperimental() {
      return false;
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this evidence focus is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public EvidenceFocus setExperimentalElement(BooleanType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"experimental\"");
    }
    public boolean getExperimental() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"experimental\"");
    }
    /**
     * @param value A Boolean value to indicate that this evidence focus is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public EvidenceFocus setExperimental(boolean value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"experimental\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPublisherMax() { 
      return 0;
    }
    /**
     * @return {@link #publisher} (The name of the organization or individual that published the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"publisher\"");
    }

    public boolean hasPublisherElement() { 
      return false;
    }
    public boolean hasPublisher() {
      return false;
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the evidence focus.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public EvidenceFocus setPublisherElement(StringType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"publisher\"");
    }
    public String getPublisher() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"publisher\"");
    }
    /**
     * @param value The name of the organization or individual that published the evidence focus.
     */
    public EvidenceFocus setPublisher(String value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"publisher\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getContactMax() { 
      return 0;
    }
    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setContact(List<ContactDetail> theContact) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"contact\"");
    }
    public boolean hasContact() { 
      return false;
    }

    public ContactDetail addContact() { //3
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"contact\"");
    }
    public EvidenceFocus addContact(ContactDetail t) { //3
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"contact\"");
    }
    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {2}
     */
    public ContactDetail getContactFirstRep() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"contact\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getDescriptionMax() { 
      return 0;
    }
    /**
     * @return {@link #description} (A free text natural language description of the evidence focus from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"description\"");
    }

    public boolean hasDescriptionElement() { 
      return false;
    }
    public boolean hasDescription() {
      return false;
    }

    /**
     * @param value {@link #description} (A free text natural language description of the evidence focus from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public EvidenceFocus setDescriptionElement(MarkdownType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"description\"");
    }
    public String getDescription() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"description\"");
    }
    /**
     * @param value A free text natural language description of the evidence focus from a consumer's perspective.
     */
    public EvidenceFocus setDescription(String value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"description\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getJurisdictionMax() { 
      return 0;
    }
    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the evidence focus is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceFocus setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"jurisdiction\"");
    }
    public boolean hasJurisdiction() { 
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"jurisdiction\"");
    }
    public EvidenceFocus addJurisdiction(CodeableConcept t) { //3
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"jurisdiction\"");
    }
    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {2}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"jurisdiction\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this evidence focus is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this evidence focus is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public EvidenceFocus setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"purpose\"");
    }
    public String getPurpose() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"purpose\"");
    }
    /**
     * @param value Explanation of why this evidence focus is needed and why it has been designed as it has.
     */
    public EvidenceFocus setPurpose(String value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"purpose\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getApprovalDateMax() { 
      return 0;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"approvalDate\"");
    }

    public boolean hasApprovalDateElement() { 
      return false;
    }
    public boolean hasApprovalDate() {
      return false;
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public EvidenceFocus setApprovalDateElement(DateType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"approvalDate\"");
    }
    public Date getApprovalDate() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"approvalDate\"");
    }
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public EvidenceFocus setApprovalDate(Date value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"approvalDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getLastReviewDateMax() { 
      return 0;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"lastReviewDate\"");
    }

    public boolean hasLastReviewDateElement() { 
      return false;
    }
    public boolean hasLastReviewDate() {
      return false;
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public EvidenceFocus setLastReviewDateElement(DateType value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"lastReviewDate\"");
    }
    public Date getLastReviewDate() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public EvidenceFocus setLastReviewDate(Date value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEffectivePeriodMax() { 
      return 0;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the evidence focus content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"effectivePeriod\"");
    }
    public boolean hasEffectivePeriod() { 
      return false;
    }
    /**
     * @param value {@link #effectivePeriod} (The period during which the evidence focus content was or is planned to be in active use.)
     */
    public EvidenceFocus setEffectivePeriod(Period value) { 
      throw new Error("The resource type \"EvidenceFocus\" does not implement the property \"effectivePeriod\"");
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence focus instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.", 0, 1, date));
        children.add(new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.", 0, 1, copyright));
        children.add(new Property("citeAs", "Reference(Citation)", "Citation for this EvidenceFocus resource.", 0, 1, citeAs));
        children.add(new Property("characteristic", "", "Characteristic.", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Additional documentation.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this EvidenceFocus when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the evidence focus. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence focus instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the evidence focus was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence focus changes.", 0, 1, date);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the evidence focus and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence focus.", 0, 1, copyright);
        case -1360156695: /*citeAs*/  return new Property("citeAs", "Reference(Citation)", "Citation for this EvidenceFocus resource.", 0, 1, citeAs);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "Characteristic.", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Additional documentation.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case -1360156695: /*citeAs*/ return this.citeAs == null ? new Base[0] : new Base[] {this.citeAs}; // Reference
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // EvidenceFocusCharacteristicComponent
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1360156695: // citeAs
          this.citeAs = TypeConvertor.castToReference(value); // Reference
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((EvidenceFocusCharacteristicComponent) value); // EvidenceFocusCharacteristicComponent
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("citeAs")) {
          this.citeAs = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((EvidenceFocusCharacteristicComponent) value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case -892481550:  return getStatusElement();
        case -669707736:  return addUseContext(); 
        case 3076014:  return getDateElement();
        case 3387378:  return addNote(); 
        case 1522889671:  return getCopyrightElement();
        case -1360156695:  return getCiteAs();
        case 366313883:  return addCharacteristic(); 
        case 666807069:  return addRelatedArtifact(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case -1360156695: /*citeAs*/ return new String[] {"Reference"};
        case 366313883: /*characteristic*/ return new String[] {};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.name");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.status");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.date");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceFocus.copyright");
        }
        else if (name.equals("citeAs")) {
          this.citeAs = new Reference();
          return this.citeAs;
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EvidenceFocus";

  }

      public EvidenceFocus copy() {
        EvidenceFocus dst = new EvidenceFocus();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceFocus dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.status = status == null ? null : status.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        dst.date = date == null ? null : date.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.citeAs = citeAs == null ? null : citeAs.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<EvidenceFocusCharacteristicComponent>();
          for (EvidenceFocusCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
      }

      protected EvidenceFocus typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceFocus))
          return false;
        EvidenceFocus o = (EvidenceFocus) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(status, o.status, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(date, o.date, true) && compareDeep(note, o.note, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(citeAs, o.citeAs, true) && compareDeep(characteristic, o.characteristic, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceFocus))
          return false;
        EvidenceFocus o = (EvidenceFocus) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(copyright, o.copyright, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, status, useContext, date, note, copyright, citeAs, characteristic, relatedArtifact
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.EvidenceFocus;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the evidence focus</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(EvidenceFocus.useContext.value as Quantity) | (EvidenceFocus.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(EvidenceFocus.useContext.value as Quantity) | (EvidenceFocus.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the evidence focus", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the evidence focus</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(EvidenceFocus.useContext.value as Quantity) | (EvidenceFocus.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the evidence focus</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>EvidenceFocus.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="EvidenceFocus.useContext", description="A use context type and quantity- or range-based value assigned to the evidence focus", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the evidence focus</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>EvidenceFocus.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the evidence focus</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>EvidenceFocus.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="EvidenceFocus.useContext", description="A use context type and value assigned to the evidence focus", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the evidence focus</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>EvidenceFocus.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="EvidenceFocus.useContext.code", description="A type of use context assigned to the evidence focus", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(EvidenceFocus.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(EvidenceFocus.useContext.value as CodeableConcept)", description="A use context assigned to the evidence focus", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(EvidenceFocus.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The evidence focus publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>EvidenceFocus.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="EvidenceFocus.date", description="The evidence focus publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The evidence focus publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>EvidenceFocus.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="EvidenceFocus.identifier", description="External identifier for the evidence focus", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the evidence focus</b><br>
   * Type: <b>string</b><br>
   * Path: <b>EvidenceFocus.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="EvidenceFocus.name", description="Computationally friendly name of the evidence focus", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the evidence focus</b><br>
   * Type: <b>string</b><br>
   * Path: <b>EvidenceFocus.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="EvidenceFocus.status", description="The current status of the evidence focus", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the evidence focus</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>EvidenceFocus.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="EvidenceFocus.url", description="The uri that identifies the evidence focus", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the evidence focus</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>EvidenceFocus.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="EvidenceFocus.version", description="The business version of the evidence focus", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the evidence focus</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EvidenceFocus.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}