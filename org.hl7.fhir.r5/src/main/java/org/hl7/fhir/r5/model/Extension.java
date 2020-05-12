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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

import org.hl7.fhir.instance.model.api.IBaseExtension;
import  org.hl7.fhir.instance.model.api.IBaseDatatype;
import  org.hl7.fhir.instance.model.api.IBaseHasExtensions;
/**
 * Base StructureDefinition for Extension Type: Optional Extension Element - found in all resources.
 */
@DatatypeDef(name="Extension")
public class Extension extends BaseExtension implements IBaseExtension<Extension, DataType>, IBaseHasExtensions {

    /**
     * Source of the definition for the extension code - a logical name or a URL.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="identifies the meaning of the extension", formalDefinition="Source of the definition for the extension code - a logical name or a URL." )
    protected UriType url;

    /**
     * Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).
     */
    @Child(name = "value", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Value of extension", formalDefinition="Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list)." )
    protected DataType value;

    private static final long serialVersionUID = 465890108L;

  /**
   * Constructor
   */
    public Extension() {
      super();
    }

  /**
   * Constructor
   */
    public Extension(String url) {
      super();
      this.setUrl(url);
    }

    /**
     * Constructor
     */
    public Extension(String theUrl, IBaseDatatype theValue) {
      setUrl(theUrl);
      setValue(theValue);
    }

    /**
     * @return {@link #url} (Source of the definition for the extension code - a logical name or a URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Extension.url");
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
     * @param value {@link #url} (Source of the definition for the extension code - a logical name or a URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Extension setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return Source of the definition for the extension code - a logical name or a URL.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value Source of the definition for the extension code - a logical name or a URL.
     */
    public Extension setUrl(String value) { 
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      return this;
    }

    /**
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
     */
    public DataType getValue() { 
      return this.value;
    }

    /**
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @return {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
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
     * @param value {@link #value} (Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).)
     */
    public Extension setValue(DataType value) { 
      if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
        throw new Error("Not the right type for Extension.value[x]: "+value.fhirType());
      this.value = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "Source of the definition for the extension code - a logical name or a URL.", 0, 1, url));
        children.add(new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "Source of the definition for the extension code - a logical name or a URL.", 0, 1, url);
        case -1410166417: /*value[x]*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 111972721: /*value*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -766209282: /*valueCode*/  return new Property("value[x]", "code", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -766192449: /*valueDate*/  return new Property("value[x]", "date", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 231604844: /*valueId*/  return new Property("value[x]", "id", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1668687056: /*valueInstant*/  return new Property("value[x]", "instant", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1122120181: /*valueInteger64*/  return new Property("value[x]", "integer64", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1410178407: /*valueOid*/  return new Property("value[x]", "oid", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1249932027: /*valuePositiveInt*/  return new Property("value[x]", "positiveInt", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -765708322: /*valueTime*/  return new Property("value[x]", "time", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 26529417: /*valueUnsignedInt*/  return new Property("value[x]", "unsignedInt", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -765667124: /*valueUuid*/  return new Property("value[x]", "uuid", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1410191922: /*valueAge*/  return new Property("value[x]", "Age", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 944904545: /*valueContactPoint*/  return new Property("value[x]", "ContactPoint", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 2017332766: /*valueCount*/  return new Property("value[x]", "Count", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -456359802: /*valueDistance*/  return new Property("value[x]", "Distance", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -2026205465: /*valueHumanName*/  return new Property("value[x]", "HumanName", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -130498310: /*valueIdentifier*/  return new Property("value[x]", "Identifier", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 2026560975: /*valueMoney*/  return new Property("value[x]", "Money", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -540985785: /*valueSignature*/  return new Property("value[x]", "Signature", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1406282469: /*valueTiming*/  return new Property("value[x]", "Timing", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1125200224: /*valueContactDetail*/  return new Property("value[x]", "ContactDetail", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1281021610: /*valueContributor*/  return new Property("value[x]", "Contributor", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1710554248: /*valueDataRequirement*/  return new Property("value[x]", "DataRequirement", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -307517719: /*valueExpression*/  return new Property("value[x]", "Expression", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1387478187: /*valueParameterDefinition*/  return new Property("value[x]", "ParameterDefinition", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 1748214124: /*valueRelatedArtifact*/  return new Property("value[x]", "RelatedArtifact", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 976830394: /*valueTriggerDefinition*/  return new Property("value[x]", "TriggerDefinition", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case 588000479: /*valueUsageContext*/  return new Property("value[x]", "UsageContext", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -1858636920: /*valueDosage*/  return new Property("value[x]", "Dosage", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        case -765920490: /*valueMeta*/  return new Property("value[x]", "Meta", "Value of extension - must be one of a constrained set of the data types (see [Extensibility](extensibility.html) for a list).", 0, 1, value);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case 111972721: /*value*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Extension.url");
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
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Extension";

  }

      public Extension copy() {
        Extension dst = new Extension();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Extension dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.value = value == null ? null : value.copy();
      }

      protected Extension typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Extension))
          return false;
        Extension o = (Extension) other_;
        return compareDeep(url, o.url, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Extension))
          return false;
        Extension o = (Extension) other_;
        return compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, value);
      }


}