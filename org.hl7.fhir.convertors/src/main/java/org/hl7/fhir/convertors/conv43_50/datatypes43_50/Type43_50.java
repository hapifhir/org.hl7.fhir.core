package org.hl7.fhir.convertors.conv43_50.datatypes43_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Address43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Age43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Count43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Distance43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Duration43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.HumanName43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.MoneyQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Range43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Ratio43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SampledData43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Signature43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Timing43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.Contributor43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.DataRequirement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.Expression43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ParameterDefinition43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.RelatedArtifact43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.TriggerDefinition43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Base64Binary43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Oid43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Time43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uuid43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Dosage43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.ElementDefinition43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Extension43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Meta43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Narrative43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.convertors.conv43_50.resources43_50.MarketingStatus43_50;
import org.hl7.fhir.convertors.conv43_50.resources43_50.ProdCharacteristic43_50;
import org.hl7.fhir.convertors.conv43_50.resources43_50.ProductShelfLife43_50;
import org.hl7.fhir.convertors.conv43_50.resources43_50.SubstanceAmount43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Type43_50 {

  private final BaseAdvisor_43_50 advisor;

  public Type43_50(BaseAdvisor_43_50 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4b.model.Base64BinaryType)
      return Base64Binary43_50.convertBase64Binary((org.hl7.fhir.r4b.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4b.model.BooleanType)
      return Boolean43_50.convertBoolean((org.hl7.fhir.r4b.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4b.model.CanonicalType)
      return Canonical43_50.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeType)
      return Code43_50.convertCode((org.hl7.fhir.r4b.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DateType)
      return Date43_50.convertDate((org.hl7.fhir.r4b.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DateTimeType)
      return DateTime43_50.convertDateTime((org.hl7.fhir.r4b.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.DecimalType)
      return Decimal43_50.convertDecimal((org.hl7.fhir.r4b.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4b.model.IdType) return Id43_50.convertId((org.hl7.fhir.r4b.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4b.model.InstantType)
      return Instant43_50.convertInstant((org.hl7.fhir.r4b.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UnsignedIntType)
      return UnsignedInt43_50.convertUnsignedInt((org.hl7.fhir.r4b.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4b.model.PositiveIntType)
      return PositiveInt43_50.convertPositiveInt((org.hl7.fhir.r4b.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4b.model.IntegerType)
      return Integer43_50.convertInteger((org.hl7.fhir.r4b.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4b.model.MarkdownType)
      return MarkDown43_50.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4b.model.OidType) return Oid43_50.convertOid((org.hl7.fhir.r4b.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4b.model.TimeType)
      return Time43_50.convertTime((org.hl7.fhir.r4b.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UrlType) return Url43_50.convertUrl((org.hl7.fhir.r4b.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UuidType)
      return Uuid43_50.convertUuid((org.hl7.fhir.r4b.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4b.model.UriType) return Uri43_50.convertUri((org.hl7.fhir.r4b.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4b.model.StringType)
      return String43_50.convertString((org.hl7.fhir.r4b.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4b.model.Extension)
      return Extension43_50.convertExtension((org.hl7.fhir.r4b.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4b.model.Narrative)
      return Narrative43_50.convertNarrative((org.hl7.fhir.r4b.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4b.model.Address)
      return Address43_50.convertAddress((org.hl7.fhir.r4b.model.Address) src);
    if (src instanceof org.hl7.fhir.r4b.model.Age) return Age43_50.convertAge((org.hl7.fhir.r4b.model.Age) src);
    if (src instanceof org.hl7.fhir.r4b.model.Annotation)
      return Annotation43_50.convertAnnotation((org.hl7.fhir.r4b.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4b.model.Attachment)
      return Attachment43_50.convertAttachment((org.hl7.fhir.r4b.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeableConcept)
      return CodeableConcept43_50.convertCodeableConcept((org.hl7.fhir.r4b.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4b.model.Coding)
      return Coding43_50.convertCoding((org.hl7.fhir.r4b.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4b.model.ContactDetail)
      return ContactDetail43_50.convertContactDetail((org.hl7.fhir.r4b.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4b.model.ContactPoint)
      return ContactPoint43_50.convertContactPoint((org.hl7.fhir.r4b.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4b.model.Contributor)
      return Contributor43_50.convertContributor((org.hl7.fhir.r4b.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r4b.model.Count) return Count43_50.convertCount((org.hl7.fhir.r4b.model.Count) src);
    if (src instanceof org.hl7.fhir.r4b.model.DataRequirement)
      return DataRequirement43_50.convertDataRequirement((org.hl7.fhir.r4b.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4b.model.Distance)
      return Distance43_50.convertDistance((org.hl7.fhir.r4b.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Dosage)
      return Dosage43_50.convertDosage((org.hl7.fhir.r4b.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4b.model.Duration)
      return Duration43_50.convertDuration((org.hl7.fhir.r4b.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4b.model.Expression)
      return Expression43_50.convertExpression((org.hl7.fhir.r4b.model.Expression) src);
    if (src instanceof org.hl7.fhir.r4b.model.HumanName)
      return HumanName43_50.convertHumanName((org.hl7.fhir.r4b.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4b.model.Identifier)
      return Identifier43_50.convertIdentifier((org.hl7.fhir.r4b.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4b.model.MarketingStatus)
      return MarketingStatus43_50.convertMarketingStatus((org.hl7.fhir.r4b.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r4b.model.Meta) return Meta43_50.convertMeta((org.hl7.fhir.r4b.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4b.model.Money) return Money43_50.convertMoney((org.hl7.fhir.r4b.model.Money) src);
    if (src instanceof org.hl7.fhir.r4b.model.ParameterDefinition)
      return ParameterDefinition43_50.convertParameterDefinition((org.hl7.fhir.r4b.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Period)
      return Period43_50.convertPeriod((org.hl7.fhir.r4b.model.Period) src);
    if (src instanceof org.hl7.fhir.r4b.model.ProdCharacteristic)
      return ProdCharacteristic43_50.convertProdCharacteristic((org.hl7.fhir.r4b.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r4b.model.ProductShelfLife)
      return ProductShelfLife43_50.convertProductShelfLife((org.hl7.fhir.r4b.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r4b.model.MoneyQuantity)
      return MoneyQuantity43_50.convertMoneyQuantity((org.hl7.fhir.r4b.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.SimpleQuantity)
      return SimpleQuantity43_50.convertSimpleQuantity((org.hl7.fhir.r4b.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.Quantity)
      return Quantity43_50.convertQuantity((org.hl7.fhir.r4b.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4b.model.Range) return Range43_50.convertRange((org.hl7.fhir.r4b.model.Range) src);
    if (src instanceof org.hl7.fhir.r4b.model.Ratio) return Ratio43_50.convertRatio((org.hl7.fhir.r4b.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4b.model.Reference)
      return Reference43_50.convertReference((org.hl7.fhir.r4b.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4b.model.RelatedArtifact)
      return RelatedArtifact43_50.convertRelatedArtifact((org.hl7.fhir.r4b.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4b.model.SampledData)
      return SampledData43_50.convertSampledData((org.hl7.fhir.r4b.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4b.model.Signature)
      return Signature43_50.convertSignature((org.hl7.fhir.r4b.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4b.model.SubstanceAmount)
      return SubstanceAmount43_50.convertSubstanceAmount((org.hl7.fhir.r4b.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r4b.model.Timing)
      return Timing43_50.convertTiming((org.hl7.fhir.r4b.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4b.model.TriggerDefinition)
      return TriggerDefinition43_50.convertTriggerDefinition((org.hl7.fhir.r4b.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.UsageContext)
      return UsageContext43_50.convertUsageContext((org.hl7.fhir.r4b.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4b.model.ElementDefinition)
      return ElementDefinition43_50.convertElementDefinition((org.hl7.fhir.r4b.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4B to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return Base64Binary43_50.convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return Boolean43_50.convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CanonicalType)
      return Canonical43_50.convertCanonical((org.hl7.fhir.r5.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return Code43_50.convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return Date43_50.convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return DateTime43_50.convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return Decimal43_50.convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType) return Id43_50.convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return Instant43_50.convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return MarkDown43_50.convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType) return Oid43_50.convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return PositiveInt43_50.convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return String43_50.convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return Time43_50.convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return UnsignedInt43_50.convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return Integer43_50.convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.UrlType) return Url43_50.convertUrl((org.hl7.fhir.r5.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return Uuid43_50.convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType) return Uri43_50.convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return Extension43_50.convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return Narrative43_50.convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return Address43_50.convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.Age) return Age43_50.convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return Annotation43_50.convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return Attachment43_50.convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return CodeableConcept43_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return Coding43_50.convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactDetail)
      return ContactDetail43_50.convertContactDetail((org.hl7.fhir.r5.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return ContactPoint43_50.convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.Contributor)
      return Contributor43_50.convertContributor((org.hl7.fhir.r5.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r5.model.Count) return Count43_50.convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.DataRequirement)
      return DataRequirement43_50.convertDataRequirement((org.hl7.fhir.r5.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return Distance43_50.convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Dosage)
      return Dosage43_50.convertDosage((org.hl7.fhir.r5.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return Duration43_50.convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Expression)
      return Expression43_50.convertExpression((org.hl7.fhir.r5.model.Expression) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return HumanName43_50.convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return Identifier43_50.convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.MarketingStatus)
      return MarketingStatus43_50.convertMarketingStatus((org.hl7.fhir.r5.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta) return Meta43_50.convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.Money) return Money43_50.convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.ParameterDefinition)
      return ParameterDefinition43_50.convertParameterDefinition((org.hl7.fhir.r5.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return Period43_50.convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.ProdCharacteristic)
      return ProdCharacteristic43_50.convertProdCharacteristic((org.hl7.fhir.r5.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r5.model.ProductShelfLife)
      return ProductShelfLife43_50.convertProductShelfLife((org.hl7.fhir.r5.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r5.model.MoneyQuantity)
      return MoneyQuantity43_50.convertMoneyQuantity((org.hl7.fhir.r5.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r5.model.SimpleQuantity)
      return SimpleQuantity43_50.convertSimpleQuantity((org.hl7.fhir.r5.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return Quantity43_50.convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range) return Range43_50.convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio) return Ratio43_50.convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return Reference43_50.convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedArtifact)
      return RelatedArtifact43_50.convertRelatedArtifact((org.hl7.fhir.r5.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return SampledData43_50.convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return Signature43_50.convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceAmount)
      return SubstanceAmount43_50.convertSubstanceAmount((org.hl7.fhir.r5.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return Timing43_50.convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (src instanceof org.hl7.fhir.r5.model.TriggerDefinition)
      return TriggerDefinition43_50.convertTriggerDefinition((org.hl7.fhir.r5.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.UsageContext)
      return UsageContext43_50.convertUsageContext((org.hl7.fhir.r5.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r5.model.ElementDefinition)
      return ElementDefinition43_50.convertElementDefinition((org.hl7.fhir.r5.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R4B");
    } else {
      return null;
    }
  }
}
