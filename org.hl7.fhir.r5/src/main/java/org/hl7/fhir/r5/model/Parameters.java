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

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
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

import org.hl7.fhir.instance.model.api.IBaseParameters;
/**
 * This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.
 */
@ResourceDef(name="Parameters", profile="http://hl7.org/fhir/StructureDefinition/Parameters")
public class Parameters extends Resource implements IBaseParameters {

    @Block()
    public static class ParametersParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the parameter (reference to the operation definition).
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name from the definition", formalDefinition="The name of the parameter (reference to the operation definition)." )
        protected StringType name;

        /**
         * If the parameter is a data type.
         */
        @Child(name = "value", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="If parameter is a data type", formalDefinition="If the parameter is a data type." )
        protected DataType value;

        /**
         * If the parameter is a whole resource.
         */
        @Child(name = "resource", type = {Resource.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="If parameter is a whole resource", formalDefinition="If the parameter is a whole resource." )
        protected Resource resource;

        /**
         * A named part of a multi-part parameter.
         */
        @Child(name = "part", type = {ParametersParameterComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Named part of a multi-part parameter", formalDefinition="A named part of a multi-part parameter." )
        protected List<ParametersParameterComponent> part;

        private static final long serialVersionUID = -1755858390L;

    /**
     * Constructor
     */
      public ParametersParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ParametersParameterComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (The name of the parameter (reference to the operation definition).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ParametersParameterComponent.name");
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
         * @param value {@link #name} (The name of the parameter (reference to the operation definition).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ParametersParameterComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of the parameter (reference to the operation definition).
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of the parameter (reference to the operation definition).
         */
        public ParametersParameterComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Base64BinaryType getValueBase64BinaryType() throws FHIRException { 
          if (this.value == null)
            this.value = new Base64BinaryType();
          if (!(this.value instanceof Base64BinaryType))
            throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Base64BinaryType) this.value;
        }

        public boolean hasValueBase64BinaryType() { 
          return this != null && this.value instanceof Base64BinaryType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public CanonicalType getValueCanonicalType() throws FHIRException { 
          if (this.value == null)
            this.value = new CanonicalType();
          if (!(this.value instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CanonicalType) this.value;
        }

        public boolean hasValueCanonicalType() { 
          return this != null && this.value instanceof CanonicalType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public CodeType getValueCodeType() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeType();
          if (!(this.value instanceof CodeType))
            throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeType) this.value;
        }

        public boolean hasValueCodeType() { 
          return this != null && this.value instanceof CodeType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public IdType getValueIdType() throws FHIRException { 
          if (this.value == null)
            this.value = new IdType();
          if (!(this.value instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IdType) this.value;
        }

        public boolean hasValueIdType() { 
          return this != null && this.value instanceof IdType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public InstantType getValueInstantType() throws FHIRException { 
          if (this.value == null)
            this.value = new InstantType();
          if (!(this.value instanceof InstantType))
            throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (InstantType) this.value;
        }

        public boolean hasValueInstantType() { 
          return this != null && this.value instanceof InstantType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Integer64Type getValueInteger64Type() throws FHIRException { 
          if (this.value == null)
            this.value = new Integer64Type();
          if (!(this.value instanceof Integer64Type))
            throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Integer64Type) this.value;
        }

        public boolean hasValueInteger64Type() { 
          return this != null && this.value instanceof Integer64Type;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public OidType getValueOidType() throws FHIRException { 
          if (this.value == null)
            this.value = new OidType();
          if (!(this.value instanceof OidType))
            throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (OidType) this.value;
        }

        public boolean hasValueOidType() { 
          return this != null && this.value instanceof OidType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public PositiveIntType getValuePositiveIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new PositiveIntType();
          if (!(this.value instanceof PositiveIntType))
            throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (PositiveIntType) this.value;
        }

        public boolean hasValuePositiveIntType() { 
          return this != null && this.value instanceof PositiveIntType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public TimeType getValueTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new TimeType();
          if (!(this.value instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TimeType) this.value;
        }

        public boolean hasValueTimeType() { 
          return this != null && this.value instanceof TimeType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public UnsignedIntType getValueUnsignedIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new UnsignedIntType();
          if (!(this.value instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.value;
        }

        public boolean hasValueUnsignedIntType() { 
          return this != null && this.value instanceof UnsignedIntType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() { 
          return this != null && this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public UuidType getValueUuidType() throws FHIRException { 
          if (this.value == null)
            this.value = new UuidType();
          if (!(this.value instanceof UuidType))
            throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UuidType) this.value;
        }

        public boolean hasValueUuidType() { 
          return this != null && this.value instanceof UuidType;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Age getValueAge() throws FHIRException { 
          if (this.value == null)
            this.value = new Age();
          if (!(this.value instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Age) this.value;
        }

        public boolean hasValueAge() { 
          return this != null && this.value instanceof Age;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public ContactPoint getValueContactPoint() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactPoint();
          if (!(this.value instanceof ContactPoint))
            throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactPoint) this.value;
        }

        public boolean hasValueContactPoint() { 
          return this != null && this.value instanceof ContactPoint;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Count getValueCount() throws FHIRException { 
          if (this.value == null)
            this.value = new Count();
          if (!(this.value instanceof Count))
            throw new FHIRException("Type mismatch: the type Count was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Count) this.value;
        }

        public boolean hasValueCount() { 
          return this != null && this.value instanceof Count;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Distance getValueDistance() throws FHIRException { 
          if (this.value == null)
            this.value = new Distance();
          if (!(this.value instanceof Distance))
            throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Distance) this.value;
        }

        public boolean hasValueDistance() { 
          return this != null && this.value instanceof Distance;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public HumanName getValueHumanName() throws FHIRException { 
          if (this.value == null)
            this.value = new HumanName();
          if (!(this.value instanceof HumanName))
            throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.value.getClass().getName()+" was encountered");
          return (HumanName) this.value;
        }

        public boolean hasValueHumanName() { 
          return this != null && this.value instanceof HumanName;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Identifier getValueIdentifier() throws FHIRException { 
          if (this.value == null)
            this.value = new Identifier();
          if (!(this.value instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Identifier) this.value;
        }

        public boolean hasValueIdentifier() { 
          return this != null && this.value instanceof Identifier;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Money getValueMoney() throws FHIRException { 
          if (this.value == null)
            this.value = new Money();
          if (!(this.value instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Money) this.value;
        }

        public boolean hasValueMoney() { 
          return this != null && this.value instanceof Money;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Period getValuePeriod() throws FHIRException { 
          if (this.value == null)
            this.value = new Period();
          if (!(this.value instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Period) this.value;
        }

        public boolean hasValuePeriod() { 
          return this != null && this.value instanceof Period;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
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
         * @return {@link #value} (If the parameter is a data type.)
         */
        public SampledData getValueSampledData() throws FHIRException { 
          if (this.value == null)
            this.value = new SampledData();
          if (!(this.value instanceof SampledData))
            throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
          return (SampledData) this.value;
        }

        public boolean hasValueSampledData() { 
          return this != null && this.value instanceof SampledData;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Signature getValueSignature() throws FHIRException { 
          if (this.value == null)
            this.value = new Signature();
          if (!(this.value instanceof Signature))
            throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Signature) this.value;
        }

        public boolean hasValueSignature() { 
          return this != null && this.value instanceof Signature;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Timing getValueTiming() throws FHIRException { 
          if (this.value == null)
            this.value = new Timing();
          if (!(this.value instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Timing) this.value;
        }

        public boolean hasValueTiming() { 
          return this != null && this.value instanceof Timing;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public ContactDetail getValueContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactDetail();
          if (!(this.value instanceof ContactDetail))
            throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactDetail) this.value;
        }

        public boolean hasValueContactDetail() { 
          return this != null && this.value instanceof ContactDetail;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Contributor getValueContributor() throws FHIRException { 
          if (this.value == null)
            this.value = new Contributor();
          if (!(this.value instanceof Contributor))
            throw new FHIRException("Type mismatch: the type Contributor was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Contributor) this.value;
        }

        public boolean hasValueContributor() { 
          return this != null && this.value instanceof Contributor;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public DataRequirement getValueDataRequirement() throws FHIRException { 
          if (this.value == null)
            this.value = new DataRequirement();
          if (!(this.value instanceof DataRequirement))
            throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DataRequirement) this.value;
        }

        public boolean hasValueDataRequirement() { 
          return this != null && this.value instanceof DataRequirement;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Expression getValueExpression() throws FHIRException { 
          if (this.value == null)
            this.value = new Expression();
          if (!(this.value instanceof Expression))
            throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Expression) this.value;
        }

        public boolean hasValueExpression() { 
          return this != null && this.value instanceof Expression;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public ParameterDefinition getValueParameterDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new ParameterDefinition();
          if (!(this.value instanceof ParameterDefinition))
            throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ParameterDefinition) this.value;
        }

        public boolean hasValueParameterDefinition() { 
          return this != null && this.value instanceof ParameterDefinition;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public RelatedArtifact getValueRelatedArtifact() throws FHIRException { 
          if (this.value == null)
            this.value = new RelatedArtifact();
          if (!(this.value instanceof RelatedArtifact))
            throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RelatedArtifact) this.value;
        }

        public boolean hasValueRelatedArtifact() { 
          return this != null && this.value instanceof RelatedArtifact;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public TriggerDefinition getValueTriggerDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new TriggerDefinition();
          if (!(this.value instanceof TriggerDefinition))
            throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TriggerDefinition) this.value;
        }

        public boolean hasValueTriggerDefinition() { 
          return this != null && this.value instanceof TriggerDefinition;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public UsageContext getValueUsageContext() throws FHIRException { 
          if (this.value == null)
            this.value = new UsageContext();
          if (!(this.value instanceof UsageContext))
            throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UsageContext) this.value;
        }

        public boolean hasValueUsageContext() { 
          return this != null && this.value instanceof UsageContext;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Dosage getValueDosage() throws FHIRException { 
          if (this.value == null)
            this.value = new Dosage();
          if (!(this.value instanceof Dosage))
            throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Dosage) this.value;
        }

        public boolean hasValueDosage() { 
          return this != null && this.value instanceof Dosage;
        }

        /**
         * @return {@link #value} (If the parameter is a data type.)
         */
        public Meta getValueMeta() throws FHIRException { 
          if (this.value == null)
            this.value = new Meta();
          if (!(this.value instanceof Meta))
            throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Meta) this.value;
        }

        public boolean hasValueMeta() { 
          return this != null && this.value instanceof Meta;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (If the parameter is a data type.)
         */
        public ParametersParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
            throw new Error("Not the right type for Parameters.parameter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #resource} (If the parameter is a whole resource.)
         */
        public Resource getResource() { 
          return this.resource;
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (If the parameter is a whole resource.)
         */
        public ParametersParameterComponent setResource(Resource value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return {@link #part} (A named part of a multi-part parameter.)
         */
        public List<ParametersParameterComponent> getPart() { 
          if (this.part == null)
            this.part = new ArrayList<ParametersParameterComponent>();
          return this.part;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ParametersParameterComponent setPart(List<ParametersParameterComponent> thePart) { 
          this.part = thePart;
          return this;
        }

        public boolean hasPart() { 
          if (this.part == null)
            return false;
          for (ParametersParameterComponent item : this.part)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ParametersParameterComponent addPart() { //3
          ParametersParameterComponent t = new ParametersParameterComponent();
          if (this.part == null)
            this.part = new ArrayList<ParametersParameterComponent>();
          this.part.add(t);
          return t;
        }

        public ParametersParameterComponent addPart(ParametersParameterComponent t) { //3
          if (t == null)
            return this;
          if (this.part == null)
            this.part = new ArrayList<ParametersParameterComponent>();
          this.part.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #part}, creating it if it does not already exist {3}
         */
        public ParametersParameterComponent getPartFirstRep() { 
          if (getPart().isEmpty()) {
            addPart();
          }
          return getPart().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name of the parameter (reference to the operation definition).", 0, 1, name));
          children.add(new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "If the parameter is a data type.", 0, 1, value));
          children.add(new Property("resource", "Resource", "If the parameter is a whole resource.", 0, 1, resource));
          children.add(new Property("part", "@Parameters.parameter", "A named part of a multi-part parameter.", 0, java.lang.Integer.MAX_VALUE, part));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name of the parameter (reference to the operation definition).", 0, 1, name);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "If the parameter is a data type.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "If the parameter is a data type.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "If the parameter is a data type.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "If the parameter is a data type.", 0, 1, value);
          case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "If the parameter is a data type.", 0, 1, value);
          case -766209282: /*valueCode*/  return new Property("value[x]", "code", "If the parameter is a data type.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "If the parameter is a data type.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "If the parameter is a data type.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "If the parameter is a data type.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "If the parameter is a data type.", 0, 1, value);
          case -1668687056: /*valueInstant*/  return new Property("value[x]", "instant", "If the parameter is a data type.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "If the parameter is a data type.", 0, 1, value);
          case -1122120181: /*valueInteger64*/  return new Property("value[x]", "integer64", "If the parameter is a data type.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "If the parameter is a data type.", 0, 1, value);
          case -1410178407: /*valueOid*/  return new Property("value[x]", "oid", "If the parameter is a data type.", 0, 1, value);
          case -1249932027: /*valuePositiveInt*/  return new Property("value[x]", "positiveInt", "If the parameter is a data type.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "If the parameter is a data type.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "If the parameter is a data type.", 0, 1, value);
          case 26529417: /*valueUnsignedInt*/  return new Property("value[x]", "unsignedInt", "If the parameter is a data type.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "If the parameter is a data type.", 0, 1, value);
          case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "If the parameter is a data type.", 0, 1, value);
          case -765667124: /*valueUuid*/  return new Property("value[x]", "uuid", "If the parameter is a data type.", 0, 1, value);
          case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "If the parameter is a data type.", 0, 1, value);
          case -1410191922: /*valueAge*/  return new Property("value[x]", "Age", "If the parameter is a data type.", 0, 1, value);
          case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "If the parameter is a data type.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "If the parameter is a data type.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "If the parameter is a data type.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "If the parameter is a data type.", 0, 1, value);
          case 944904545: /*valueContactPoint*/  return new Property("value[x]", "ContactPoint", "If the parameter is a data type.", 0, 1, value);
          case 2017332766: /*valueCount*/  return new Property("value[x]", "Count", "If the parameter is a data type.", 0, 1, value);
          case -456359802: /*valueDistance*/  return new Property("value[x]", "Distance", "If the parameter is a data type.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "If the parameter is a data type.", 0, 1, value);
          case -2026205465: /*valueHumanName*/  return new Property("value[x]", "HumanName", "If the parameter is a data type.", 0, 1, value);
          case -130498310: /*valueIdentifier*/  return new Property("value[x]", "Identifier", "If the parameter is a data type.", 0, 1, value);
          case 2026560975: /*valueMoney*/  return new Property("value[x]", "Money", "If the parameter is a data type.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "If the parameter is a data type.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "If the parameter is a data type.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "If the parameter is a data type.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "If the parameter is a data type.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "If the parameter is a data type.", 0, 1, value);
          case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "If the parameter is a data type.", 0, 1, value);
          case -540985785: /*valueSignature*/  return new Property("value[x]", "Signature", "If the parameter is a data type.", 0, 1, value);
          case -1406282469: /*valueTiming*/  return new Property("value[x]", "Timing", "If the parameter is a data type.", 0, 1, value);
          case -1125200224: /*valueContactDetail*/  return new Property("value[x]", "ContactDetail", "If the parameter is a data type.", 0, 1, value);
          case 1281021610: /*valueContributor*/  return new Property("value[x]", "Contributor", "If the parameter is a data type.", 0, 1, value);
          case 1710554248: /*valueDataRequirement*/  return new Property("value[x]", "DataRequirement", "If the parameter is a data type.", 0, 1, value);
          case -307517719: /*valueExpression*/  return new Property("value[x]", "Expression", "If the parameter is a data type.", 0, 1, value);
          case 1387478187: /*valueParameterDefinition*/  return new Property("value[x]", "ParameterDefinition", "If the parameter is a data type.", 0, 1, value);
          case 1748214124: /*valueRelatedArtifact*/  return new Property("value[x]", "RelatedArtifact", "If the parameter is a data type.", 0, 1, value);
          case 976830394: /*valueTriggerDefinition*/  return new Property("value[x]", "TriggerDefinition", "If the parameter is a data type.", 0, 1, value);
          case 588000479: /*valueUsageContext*/  return new Property("value[x]", "UsageContext", "If the parameter is a data type.", 0, 1, value);
          case -1858636920: /*valueDosage*/  return new Property("value[x]", "Dosage", "If the parameter is a data type.", 0, 1, value);
          case -765920490: /*valueMeta*/  return new Property("value[x]", "Meta", "If the parameter is a data type.", 0, 1, value);
          case -341064690: /*resource*/  return new Property("resource", "Resource", "If the parameter is a whole resource.", 0, 1, resource);
          case 3433459: /*part*/  return new Property("part", "@Parameters.parameter", "A named part of a multi-part parameter.", 0, java.lang.Integer.MAX_VALUE, part);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Resource
        case 3433459: /*part*/ return this.part == null ? new Base[0] : this.part.toArray(new Base[this.part.size()]); // ParametersParameterComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToResource(value); // Resource
          return value;
        case 3433459: // part
          this.getPart().add((ParametersParameterComponent) value); // ParametersParameterComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToResource(value); // Resource
        } else if (name.equals("part")) {
          this.getPart().add((ParametersParameterComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -341064690: throw new FHIRException("Cannot make property resource as it is not a complex type"); // Resource
        case 3433459:  return addPart(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        case -341064690: /*resource*/ return new String[] {"Resource"};
        case 3433459: /*part*/ return new String[] {"@Parameters.parameter"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Parameters.parameter.name");
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueCanonical")) {
          this.value = new CanonicalType();
          return this.value;
        }
        else if (name.equals("valueCode")) {
          this.value = new CodeType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("valueInstant")) {
          this.value = new InstantType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueInteger64")) {
          this.value = new Integer64Type();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueOid")) {
          this.value = new OidType();
          return this.value;
        }
        else if (name.equals("valuePositiveInt")) {
          this.value = new PositiveIntType();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueUnsignedInt")) {
          this.value = new UnsignedIntType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueUrl")) {
          this.value = new UrlType();
          return this.value;
        }
        else if (name.equals("valueUuid")) {
          this.value = new UuidType();
          return this.value;
        }
        else if (name.equals("valueAddress")) {
          this.value = new Address();
          return this.value;
        }
        else if (name.equals("valueAge")) {
          this.value = new Age();
          return this.value;
        }
        else if (name.equals("valueAnnotation")) {
          this.value = new Annotation();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueContactPoint")) {
          this.value = new ContactPoint();
          return this.value;
        }
        else if (name.equals("valueCount")) {
          this.value = new Count();
          return this.value;
        }
        else if (name.equals("valueDistance")) {
          this.value = new Distance();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else if (name.equals("valueHumanName")) {
          this.value = new HumanName();
          return this.value;
        }
        else if (name.equals("valueIdentifier")) {
          this.value = new Identifier();
          return this.value;
        }
        else if (name.equals("valueMoney")) {
          this.value = new Money();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
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
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueSignature")) {
          this.value = new Signature();
          return this.value;
        }
        else if (name.equals("valueTiming")) {
          this.value = new Timing();
          return this.value;
        }
        else if (name.equals("valueContactDetail")) {
          this.value = new ContactDetail();
          return this.value;
        }
        else if (name.equals("valueContributor")) {
          this.value = new Contributor();
          return this.value;
        }
        else if (name.equals("valueDataRequirement")) {
          this.value = new DataRequirement();
          return this.value;
        }
        else if (name.equals("valueExpression")) {
          this.value = new Expression();
          return this.value;
        }
        else if (name.equals("valueParameterDefinition")) {
          this.value = new ParameterDefinition();
          return this.value;
        }
        else if (name.equals("valueRelatedArtifact")) {
          this.value = new RelatedArtifact();
          return this.value;
        }
        else if (name.equals("valueTriggerDefinition")) {
          this.value = new TriggerDefinition();
          return this.value;
        }
        else if (name.equals("valueUsageContext")) {
          this.value = new UsageContext();
          return this.value;
        }
        else if (name.equals("valueDosage")) {
          this.value = new Dosage();
          return this.value;
        }
        else if (name.equals("valueMeta")) {
          this.value = new Meta();
          return this.value;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on an abstract type Parameters.parameter.resource");
        }
        else if (name.equals("part")) {
          return addPart();
        }
        else
          return super.addChild(name);
      }

      public ParametersParameterComponent copy() {
        ParametersParameterComponent dst = new ParametersParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ParametersParameterComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.value = value == null ? null : value.copy();
        dst.resource = resource == null ? null : resource.copy();
        if (part != null) {
          dst.part = new ArrayList<ParametersParameterComponent>();
          for (ParametersParameterComponent i : part)
            dst.part.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ParametersParameterComponent))
          return false;
        ParametersParameterComponent o = (ParametersParameterComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(value, o.value, true) && compareDeep(resource, o.resource, true)
           && compareDeep(part, o.part, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ParametersParameterComponent))
          return false;
        ParametersParameterComponent o = (ParametersParameterComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, value, resource, part
          );
      }

  public String fhirType() {
    return "Parameters.parameter";

  }

// added from java-adornments.txt:
  public String toString() {
    String s = getName() + " = ";
    if (hasValue()) {
      if (getValue().isPrimitive()) {
        s = s + getValue().primitiveValue();
      } else {
        s = s + "["+getValue().fhirType()+"]";
      }
    } else if (hasResource()) {
      s = s + "["+getResource().fhirType()+"]";
    } else {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (ParametersParameterComponent p : getPart()) {
        b.append(p.getName());
      }
      s = s + "{"+b.toString()+"}";
    }
    return s;
  }

// end addition
  }

    /**
     * A parameter passed to or received from the operation.
     */
    @Child(name = "parameter", type = {}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Operation Parameter", formalDefinition="A parameter passed to or received from the operation." )
    protected List<ParametersParameterComponent> parameter;

    private static final long serialVersionUID = -1495940293L;

  /**
   * Constructor
   */
    public Parameters() {
      super();
    }

    /**
     * @return {@link #parameter} (A parameter passed to or received from the operation.)
     */
    public List<ParametersParameterComponent> getParameter() { 
      if (this.parameter == null)
        this.parameter = new ArrayList<ParametersParameterComponent>();
      return this.parameter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Parameters setParameter(List<ParametersParameterComponent> theParameter) { 
      this.parameter = theParameter;
      return this;
    }

    public boolean hasParameter() { 
      if (this.parameter == null)
        return false;
      for (ParametersParameterComponent item : this.parameter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ParametersParameterComponent addParameter() { //3
      ParametersParameterComponent t = new ParametersParameterComponent();
      if (this.parameter == null)
        this.parameter = new ArrayList<ParametersParameterComponent>();
      this.parameter.add(t);
      return t;
    }

    public Parameters addParameter(ParametersParameterComponent t) { //3
      if (t == null)
        return this;
      if (this.parameter == null)
        this.parameter = new ArrayList<ParametersParameterComponent>();
      this.parameter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
     */
    public ParametersParameterComponent getParameterFirstRep() { 
      if (getParameter().isEmpty()) {
        addParameter();
      }
      return getParameter().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("parameter", "", "A parameter passed to or received from the operation.", 0, java.lang.Integer.MAX_VALUE, parameter));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1954460585: /*parameter*/  return new Property("parameter", "", "A parameter passed to or received from the operation.", 0, java.lang.Integer.MAX_VALUE, parameter);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // ParametersParameterComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1954460585: // parameter
          this.getParameter().add((ParametersParameterComponent) value); // ParametersParameterComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("parameter")) {
          this.getParameter().add((ParametersParameterComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1954460585:  return addParameter(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1954460585: /*parameter*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("parameter")) {
          return addParameter();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Parameters";

  }

      public Parameters copy() {
        Parameters dst = new Parameters();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Parameters dst) {
        super.copyValues(dst);
        if (parameter != null) {
          dst.parameter = new ArrayList<ParametersParameterComponent>();
          for (ParametersParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
      }

      protected Parameters typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Parameters))
          return false;
        Parameters o = (Parameters) other_;
        return compareDeep(parameter, o.parameter, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Parameters))
          return false;
        Parameters o = (Parameters) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(parameter);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Parameters;
   }

// Manual code (from Configuration.txt)t:
 
  public Parameters addParameter(String name, boolean b) {
    addParameter().setName(name).setValue(new BooleanType(b));
    return this;
  }

  public Parameters addParameter(String name, String s) {
    if (s != null)
      addParameter().setName(name).setValue(new StringType(s));
    return this;
  }

  public Parameters addParameter(String name, DataType v) {
    if (v != null)
      addParameter().setName(name).setValue(v);
    return this;
  }

  public Parameters setParameter(String name, boolean b) {
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name)) {
        p.setValue(new BooleanType(b));
        return this;
      }
    }
    addParameter().setName(name).setValue(new BooleanType(b));
    return this;
  }

  public Parameters setParameter(String name, String s) {
    if (s != null) {
      for (ParametersParameterComponent p : getParameter()) {
        if (p.getName().equals(name)) {
          p.setValue(new StringType(s));
          return this;
        }
      }
      addParameter().setName(name).setValue(new StringType(s));
    }
    return this;
  }

  public Parameters setParameter(String name, DataType v) {
    if (v != null) {
      for (ParametersParameterComponent p : getParameter()                                                                                     ) {
        if (p.getName().equals(name)) {
          p.setValue(v);
          return this;
        }
      }
      addParameter().setName(name).setValue(v);
    }
    return this;
  }

  public boolean hasParameter(String name) {
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name))
        return true;
    }
    return false;
  }

  public DataType getParameter(String name) {
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name))
        return p.getValue();
    }
    return null;
  }

  public List<DataType> getParameters(String name) {
    List<DataType> res = new ArrayList<>();
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name))
        res.add(p.getValue());
    }
    return res;
  }
  
  
  public boolean getParameterBool(String name) {
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name)) {
        if (p.getValue() instanceof BooleanType)
          return ((BooleanType) p.getValue()).booleanValue();
        boolean ok = Boolean.getBoolean(p.getValue().primitiveValue());
        return ok;
      }
    }
    return false;
  }

// end addition

}