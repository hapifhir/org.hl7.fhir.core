package org.hl7.fhir.convertors.conv43_N.datatypes43_N;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Address43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Age43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Count43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Distance43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.HumanName43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Money43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.MoneyQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Quantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Range43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Ratio43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SampledData43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Signature43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Timing43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.DataRequirement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.Expression43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ParameterDefinition43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.RelatedArtifact43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.TriggerDefinition43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Base64Binary43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Oid43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Time43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uuid43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Dosage43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.ElementDefinition43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Extension43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Meta43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Narrative43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.convertors.conv43_N.resources43_N.MarketingStatus43_N;
import org.hl7.fhir.convertors.conv43_N.resources43_N.ProductShelfLife43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Type43_N {

  private final BaseAdvisor_43_N advisor;

  public Type43_N(BaseAdvisor_43_N advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4b.model.Base64BinaryType)
      return Base64Binary43_N.convertBase64Binary((org.hl7.fhir.r4b.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4b.model.BooleanType)
      return Boolean43_N.convertBoolean((org.hl7.fhir.r4b.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4b.model.CanonicalType)
      return Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeType)
      return Code43_N.convertCode((org.hl7.fhir.r4b.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DateType)
      return Date43_N.convertDate((org.hl7.fhir.r4b.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DateTimeType)
      return DateTime43_N.convertDateTime((org.hl7.fhir.r4b.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DecimalType)
      return Decimal43_N.convertDecimal((org.hl7.fhir.r4b.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4b.model.IdType) return Id43_N.convertId((org.hl7.fhir.r4b.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4b.model.InstantType)
      return Instant43_N.convertInstant((org.hl7.fhir.r4b.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UnsignedIntType)
      return UnsignedInt43_N.convertUnsignedInt((org.hl7.fhir.r4b.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4b.model.PositiveIntType)
      return PositiveInt43_N.convertPositiveInt((org.hl7.fhir.r4b.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4b.model.IntegerType)
      return Integer43_N.convertInteger((org.hl7.fhir.r4b.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4b.model.MarkdownType)
      return MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4b.model.OidType) return Oid43_N.convertOid((org.hl7.fhir.r4b.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4b.model.TimeType)
      return Time43_N.convertTime((org.hl7.fhir.r4b.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UrlType) return Url43_N.convertUrl((org.hl7.fhir.r4b.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UuidType)
      return Uuid43_N.convertUuid((org.hl7.fhir.r4b.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UriType) return Uri43_N.convertUri((org.hl7.fhir.r4b.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4b.model.StringType)
      return String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4b.model.Extension)
      return Extension43_N.convertExtension((org.hl7.fhir.r4b.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4b.model.Narrative)
      return Narrative43_N.convertNarrative((org.hl7.fhir.r4b.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4b.model.Address)
      return Address43_N.convertAddress((org.hl7.fhir.r4b.model.Address) src);
    if (src instanceof org.hl7.fhir.r4b.model.Age) return Age43_N.convertAge((org.hl7.fhir.r4b.model.Age) src);
    if (src instanceof org.hl7.fhir.r4b.model.Annotation)
      return Annotation43_N.convertAnnotation((org.hl7.fhir.r4b.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4b.model.Attachment)
      return Attachment43_N.convertAttachment((org.hl7.fhir.r4b.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeableConcept)
      return CodeableConcept43_N.convertCodeableConcept((org.hl7.fhir.r4b.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4b.model.Coding)
      return Coding43_N.convertCoding((org.hl7.fhir.r4b.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4b.model.ContactDetail)
      return ContactDetail43_N.convertContactDetail((org.hl7.fhir.r4b.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4b.model.ContactPoint)
      return ContactPoint43_N.convertContactPoint((org.hl7.fhir.r4b.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4b.model.Count) return Count43_N.convertCount((org.hl7.fhir.r4b.model.Count) src);
    if (src instanceof org.hl7.fhir.r4b.model.DataRequirement)
      return DataRequirement43_N.convertDataRequirement((org.hl7.fhir.r4b.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4b.model.Distance)
      return Distance43_N.convertDistance((org.hl7.fhir.r4b.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Dosage)
      return Dosage43_N.convertDosage((org.hl7.fhir.r4b.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4b.model.Duration)
      return Duration43_N.convertDuration((org.hl7.fhir.r4b.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4b.model.Expression)
      return Expression43_N.convertExpression((org.hl7.fhir.r4b.model.Expression) src);
    if (src instanceof org.hl7.fhir.r4b.model.HumanName)
      return HumanName43_N.convertHumanName((org.hl7.fhir.r4b.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4b.model.Identifier)
      return Identifier43_N.convertIdentifier((org.hl7.fhir.r4b.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4b.model.MarketingStatus)
      return MarketingStatus43_N.convertMarketingStatus((org.hl7.fhir.r4b.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r4b.model.Meta) return Meta43_N.convertMeta((org.hl7.fhir.r4b.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4b.model.Money) return Money43_N.convertMoney((org.hl7.fhir.r4b.model.Money) src);
    if (src instanceof org.hl7.fhir.r4b.model.ParameterDefinition)
      return ParameterDefinition43_N.convertParameterDefinition((org.hl7.fhir.r4b.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Period)
      return Period43_N.convertPeriod((org.hl7.fhir.r4b.model.Period) src);
    if (src instanceof org.hl7.fhir.r4b.model.ProductShelfLife)
      return ProductShelfLife43_N.convertProductShelfLife((org.hl7.fhir.r4b.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r4b.model.MoneyQuantity)
      return MoneyQuantity43_N.convertMoneyQuantity((org.hl7.fhir.r4b.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.SimpleQuantity)
      return SimpleQuantity43_N.convertSimpleQuantity((org.hl7.fhir.r4b.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.Quantity)
      return Quantity43_N.convertQuantity((org.hl7.fhir.r4b.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.Range) return Range43_N.convertRange((org.hl7.fhir.r4b.model.Range) src);
    if (src instanceof org.hl7.fhir.r4b.model.Ratio) return Ratio43_N.convertRatio((org.hl7.fhir.r4b.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4b.model.Reference)
      return Reference43_N.convertReference((org.hl7.fhir.r4b.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4b.model.RelatedArtifact)
      return RelatedArtifact43_N.convertRelatedArtifact((org.hl7.fhir.r4b.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4b.model.SampledData)
      return SampledData43_N.convertSampledData((org.hl7.fhir.r4b.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4b.model.Signature)
      return Signature43_N.convertSignature((org.hl7.fhir.r4b.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4b.model.Timing)
      return Timing43_N.convertTiming((org.hl7.fhir.r4b.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4b.model.TriggerDefinition)
      return TriggerDefinition43_N.convertTriggerDefinition((org.hl7.fhir.r4b.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.UsageContext)
      return UsageContext43_N.convertUsageContext((org.hl7.fhir.r4b.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4b.model.ElementDefinition)
      return ElementDefinition43_N.convertElementDefinition((org.hl7.fhir.r4b.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.model.core.Base64BinaryType)
      return Base64Binary43_N.convertBase64Binary((org.hl7.fhir.model.core.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.model.core.BooleanType)
      return Boolean43_N.convertBoolean((org.hl7.fhir.model.core.BooleanType) src);
    if (src instanceof org.hl7.fhir.model.core.CanonicalType)
      return Canonical43_N.convertCanonical((org.hl7.fhir.model.core.CanonicalType) src);
    if (src instanceof org.hl7.fhir.model.core.CodeType)
      return Code43_N.convertCode((org.hl7.fhir.model.core.CodeType) src);
    if (src instanceof org.hl7.fhir.model.core.DateType)
      return Date43_N.convertDate((org.hl7.fhir.model.core.DateType) src);
    if (src instanceof org.hl7.fhir.model.core.DateTimeType)
      return DateTime43_N.convertDateTime((org.hl7.fhir.model.core.DateTimeType) src);
    if (src instanceof org.hl7.fhir.model.core.DecimalType)
      return Decimal43_N.convertDecimal((org.hl7.fhir.model.core.DecimalType) src);
    if (src instanceof org.hl7.fhir.model.core.IdType) return Id43_N.convertId((org.hl7.fhir.model.core.IdType) src);
    if (src instanceof org.hl7.fhir.model.core.InstantType)
      return Instant43_N.convertInstant((org.hl7.fhir.model.core.InstantType) src);
    if (src instanceof org.hl7.fhir.model.core.MarkdownType)
      return MarkDown43_N.convertMarkdown((org.hl7.fhir.model.core.MarkdownType) src);
    if (src instanceof org.hl7.fhir.model.core.OidType) return Oid43_N.convertOid((org.hl7.fhir.model.core.OidType) src);
    if (src instanceof org.hl7.fhir.model.core.PositiveIntType)
      return PositiveInt43_N.convertPositiveInt((org.hl7.fhir.model.core.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.model.core.StringType)
      return String43_N.convertString((org.hl7.fhir.model.core.StringType) src);
    if (src instanceof org.hl7.fhir.model.core.TimeType)
      return Time43_N.convertTime((org.hl7.fhir.model.core.TimeType) src);
    if (src instanceof org.hl7.fhir.model.core.UnsignedIntType)
      return UnsignedInt43_N.convertUnsignedInt((org.hl7.fhir.model.core.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.model.core.IntegerType)
      return Integer43_N.convertInteger((org.hl7.fhir.model.core.IntegerType) src);
    if (src instanceof org.hl7.fhir.model.core.Integer64Type)
      return Integer43_N.convertInteger64((org.hl7.fhir.model.core.Integer64Type) src);
    if (src instanceof org.hl7.fhir.model.core.UrlType) return Url43_N.convertUrl((org.hl7.fhir.model.core.UrlType) src);
    if (src instanceof org.hl7.fhir.model.core.UuidType)
      return Uuid43_N.convertUuid((org.hl7.fhir.model.core.UuidType) src);
    if (src instanceof org.hl7.fhir.model.core.UriType) return Uri43_N.convertUri((org.hl7.fhir.model.core.UriType) src);
    if (src instanceof org.hl7.fhir.model.core.Extension)
      return Extension43_N.convertExtension((org.hl7.fhir.model.core.Extension) src);
    if (src instanceof org.hl7.fhir.model.core.Narrative)
      return Narrative43_N.convertNarrative((org.hl7.fhir.model.core.Narrative) src);
    if (src instanceof org.hl7.fhir.model.core.Address)
      return Address43_N.convertAddress((org.hl7.fhir.model.core.Address) src);
    if (src instanceof org.hl7.fhir.model.core.Age) return Age43_N.convertAge((org.hl7.fhir.model.core.Age) src);
    if (src instanceof org.hl7.fhir.model.core.Annotation)
      return Annotation43_N.convertAnnotation((org.hl7.fhir.model.core.Annotation) src);
    if (src instanceof org.hl7.fhir.model.core.Attachment)
      return Attachment43_N.convertAttachment((org.hl7.fhir.model.core.Attachment) src);
    if (src instanceof org.hl7.fhir.model.core.CodeableConcept)
      return CodeableConcept43_N.convertCodeableConcept((org.hl7.fhir.model.core.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.model.core.Coding)
      return Coding43_N.convertCoding((org.hl7.fhir.model.core.Coding) src);
    if (src instanceof org.hl7.fhir.model.core.ContactDetail)
      return ContactDetail43_N.convertContactDetail((org.hl7.fhir.model.core.ContactDetail) src);
    if (src instanceof org.hl7.fhir.model.core.ContactPoint)
      return ContactPoint43_N.convertContactPoint((org.hl7.fhir.model.core.ContactPoint) src);
    if (src instanceof org.hl7.fhir.model.core.Count) return Count43_N.convertCount((org.hl7.fhir.model.core.Count) src);
    if (src instanceof org.hl7.fhir.model.core.DataRequirement)
      return DataRequirement43_N.convertDataRequirement((org.hl7.fhir.model.core.DataRequirement) src);
    if (src instanceof org.hl7.fhir.model.core.Distance)
      return Distance43_N.convertDistance((org.hl7.fhir.model.core.Distance) src);
    if (src instanceof org.hl7.fhir.model.core.Dosage)
      return Dosage43_N.convertDosage((org.hl7.fhir.model.core.Dosage) src);
    if (src instanceof org.hl7.fhir.model.core.Duration)
      return Duration43_N.convertDuration((org.hl7.fhir.model.core.Duration) src);
    if (src instanceof org.hl7.fhir.model.core.Expression)
      return Expression43_N.convertExpression((org.hl7.fhir.model.core.Expression) src);
    if (src instanceof org.hl7.fhir.model.core.HumanName)
      return HumanName43_N.convertHumanName((org.hl7.fhir.model.core.HumanName) src);
    if (src instanceof org.hl7.fhir.model.core.Identifier)
      return Identifier43_N.convertIdentifier((org.hl7.fhir.model.core.Identifier) src);
    if (src instanceof org.hl7.fhir.model.core.MarketingStatus)
      return MarketingStatus43_N.convertMarketingStatus((org.hl7.fhir.model.core.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.model.core.Meta) return Meta43_N.convertMeta((org.hl7.fhir.model.core.Meta) src);
    if (src instanceof org.hl7.fhir.model.core.Money) return Money43_N.convertMoney((org.hl7.fhir.model.core.Money) src);
    if (src instanceof org.hl7.fhir.model.core.ParameterDefinition)
      return ParameterDefinition43_N.convertParameterDefinition((org.hl7.fhir.model.core.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Period)
      return Period43_N.convertPeriod((org.hl7.fhir.model.core.Period) src);
    if (src instanceof org.hl7.fhir.model.core.ProductShelfLife)
      return ProductShelfLife43_N.convertProductShelfLife((org.hl7.fhir.model.core.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.model.core.SimpleQuantity)
      return SimpleQuantity43_N.convertSimpleQuantity((org.hl7.fhir.model.core.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.model.core.Quantity)
      return Quantity43_N.convertQuantity((org.hl7.fhir.model.core.Quantity) src);
    if (src instanceof org.hl7.fhir.model.core.Range) return Range43_N.convertRange((org.hl7.fhir.model.core.Range) src);
    if (src instanceof org.hl7.fhir.model.core.Ratio) return Ratio43_N.convertRatio((org.hl7.fhir.model.core.Ratio) src);
    if (src instanceof org.hl7.fhir.model.core.Reference)
      return Reference43_N.convertReference((org.hl7.fhir.model.core.Reference) src);
    if (src instanceof org.hl7.fhir.model.core.RelatedArtifact)
      return RelatedArtifact43_N.convertRelatedArtifact((org.hl7.fhir.model.core.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.model.core.SampledData)
      return SampledData43_N.convertSampledData((org.hl7.fhir.model.core.SampledData) src);
    if (src instanceof org.hl7.fhir.model.core.Signature)
      return Signature43_N.convertSignature((org.hl7.fhir.model.core.Signature) src);
    if (src instanceof org.hl7.fhir.model.core.Timing)
      return Timing43_N.convertTiming((org.hl7.fhir.model.core.Timing) src);
    if (src instanceof org.hl7.fhir.model.core.TriggerDefinition)
      return TriggerDefinition43_N.convertTriggerDefinition((org.hl7.fhir.model.core.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.UsageContext)
      return UsageContext43_N.convertUsageContext((org.hl7.fhir.model.core.UsageContext) src);
    if (src instanceof org.hl7.fhir.model.core.ElementDefinition)
      return ElementDefinition43_N.convertElementDefinition((org.hl7.fhir.model.core.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }
}
