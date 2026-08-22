package org.hl7.fhir.convertors.conv40_N.datatypes40_N;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Address40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Age40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Count40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Distance40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Duration40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.HumanName40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Money40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.MoneyQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Range40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Ratio40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SampledData40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Signature40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Timing40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.DataRequirement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ParameterDefinition40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.RelatedArtifact40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.TriggerDefinition40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Base64Binary40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Oid40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Time40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uuid40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Dosage40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.ElementDefinition40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Extension40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Meta40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Narrative40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.convertors.conv40_N.resources40_N.MarketingStatus40_N;
import org.hl7.fhir.convertors.conv40_N.resources40_N.ProductShelfLife40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Type40_N {

  private final BaseAdvisor_40_N advisor;

  public Type40_N(BaseAdvisor_40_N advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return Base64Binary40_N.convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CanonicalType)
      return Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return Date40_N.convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return DateTime40_N.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return Decimal40_N.convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType) return Id40_N.convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return Instant40_N.convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return UnsignedInt40_N.convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return PositiveInt40_N.convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return Integer40_N.convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType) return Oid40_N.convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return Time40_N.convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UrlType) return Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return Uuid40_N.convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType) return Uri40_N.convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return String40_N.convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return Extension40_N.convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return Narrative40_N.convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return Address40_N.convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.Age) return Age40_N.convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return Annotation40_N.convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return Attachment40_N.convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactDetail)
      return ContactDetail40_N.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return ContactPoint40_N.convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.Count) return Count40_N.convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.DataRequirement)
      return DataRequirement40_N.convertDataRequirement((org.hl7.fhir.r4.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return Distance40_N.convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Dosage)
      return Dosage40_N.convertDosage((org.hl7.fhir.r4.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return Duration40_N.convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Expression)
      return Expression40_N.convertExpression((org.hl7.fhir.r4.model.Expression) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return HumanName40_N.convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return Identifier40_N.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.MarketingStatus)
      return MarketingStatus40_N.convertMarketingStatus((org.hl7.fhir.r4.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta) return Meta40_N.convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.Money) return Money40_N.convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.ParameterDefinition)
      return ParameterDefinition40_N.convertParameterDefinition((org.hl7.fhir.r4.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return Period40_N.convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.ProductShelfLife)
      return ProductShelfLife40_N.convertProductShelfLife((org.hl7.fhir.r4.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r4.model.MoneyQuantity)
      return MoneyQuantity40_N.convertMoneyQuantity((org.hl7.fhir.r4.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
      return SimpleQuantity40_N.convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity40_N.convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range) return Range40_N.convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio) return Ratio40_N.convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedArtifact)
      return RelatedArtifact40_N.convertRelatedArtifact((org.hl7.fhir.r4.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return SampledData40_N.convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return Signature40_N.convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return Timing40_N.convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4.model.TriggerDefinition)
      return TriggerDefinition40_N.convertTriggerDefinition((org.hl7.fhir.r4.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.UsageContext)
      return UsageContext40_N.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4.model.ElementDefinition)
      return ElementDefinition40_N.convertElementDefinition((org.hl7.fhir.r4.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.model.core.Base64BinaryType)
      return Base64Binary40_N.convertBase64Binary((org.hl7.fhir.model.core.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.model.core.BooleanType)
      return Boolean40_N.convertBoolean((org.hl7.fhir.model.core.BooleanType) src);
    if (src instanceof org.hl7.fhir.model.core.CanonicalType)
      return Canonical40_N.convertCanonical((org.hl7.fhir.model.core.CanonicalType) src);
    if (src instanceof org.hl7.fhir.model.core.CodeType)
      return Code40_N.convertCode((org.hl7.fhir.model.core.CodeType) src);
    if (src instanceof org.hl7.fhir.model.core.DateType)
      return Date40_N.convertDate((org.hl7.fhir.model.core.DateType) src);
    if (src instanceof org.hl7.fhir.model.core.DateTimeType)
      return DateTime40_N.convertDateTime((org.hl7.fhir.model.core.DateTimeType) src);
    if (src instanceof org.hl7.fhir.model.core.DecimalType)
      return Decimal40_N.convertDecimal((org.hl7.fhir.model.core.DecimalType) src);
    if (src instanceof org.hl7.fhir.model.core.IdType) return Id40_N.convertId((org.hl7.fhir.model.core.IdType) src);
    if (src instanceof org.hl7.fhir.model.core.InstantType)
      return Instant40_N.convertInstant((org.hl7.fhir.model.core.InstantType) src);
    if (src instanceof org.hl7.fhir.model.core.MarkdownType)
      return MarkDown40_N.convertMarkdown((org.hl7.fhir.model.core.MarkdownType) src);
    if (src instanceof org.hl7.fhir.model.core.OidType) return Oid40_N.convertOid((org.hl7.fhir.model.core.OidType) src);
    if (src instanceof org.hl7.fhir.model.core.PositiveIntType)
      return PositiveInt40_N.convertPositiveInt((org.hl7.fhir.model.core.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.model.core.StringType)
      return String40_N.convertString((org.hl7.fhir.model.core.StringType) src);
    if (src instanceof org.hl7.fhir.model.core.TimeType)
      return Time40_N.convertTime((org.hl7.fhir.model.core.TimeType) src);
    if (src instanceof org.hl7.fhir.model.core.UnsignedIntType)
      return UnsignedInt40_N.convertUnsignedInt((org.hl7.fhir.model.core.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.model.core.IntegerType)
      return Integer40_N.convertInteger((org.hl7.fhir.model.core.IntegerType) src);
    if (src instanceof org.hl7.fhir.model.core.Integer64Type)
      return Integer40_N.convertInteger64((org.hl7.fhir.model.core.Integer64Type) src);
    if (src instanceof org.hl7.fhir.model.core.UrlType) return Url40_N.convertUrl((org.hl7.fhir.model.core.UrlType) src);
    if (src instanceof org.hl7.fhir.model.core.UuidType)
      return Uuid40_N.convertUuid((org.hl7.fhir.model.core.UuidType) src);
    if (src instanceof org.hl7.fhir.model.core.UriType) return Uri40_N.convertUri((org.hl7.fhir.model.core.UriType) src);
    if (src instanceof org.hl7.fhir.model.core.Extension)
      return Extension40_N.convertExtension((org.hl7.fhir.model.core.Extension) src);
    if (src instanceof org.hl7.fhir.model.core.Narrative)
      return Narrative40_N.convertNarrative((org.hl7.fhir.model.core.Narrative) src);
    if (src instanceof org.hl7.fhir.model.core.Address)
      return Address40_N.convertAddress((org.hl7.fhir.model.core.Address) src);
    if (src instanceof org.hl7.fhir.model.core.Age) return Age40_N.convertAge((org.hl7.fhir.model.core.Age) src);
    if (src instanceof org.hl7.fhir.model.core.Annotation)
      return Annotation40_N.convertAnnotation((org.hl7.fhir.model.core.Annotation) src);
    if (src instanceof org.hl7.fhir.model.core.Attachment)
      return Attachment40_N.convertAttachment((org.hl7.fhir.model.core.Attachment) src);
    if (src instanceof org.hl7.fhir.model.core.CodeableConcept)
      return CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.model.core.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.model.core.Coding)
      return Coding40_N.convertCoding((org.hl7.fhir.model.core.Coding) src);
    if (src instanceof org.hl7.fhir.model.core.ContactDetail)
      return ContactDetail40_N.convertContactDetail((org.hl7.fhir.model.core.ContactDetail) src);
    if (src instanceof org.hl7.fhir.model.core.ContactPoint)
      return ContactPoint40_N.convertContactPoint((org.hl7.fhir.model.core.ContactPoint) src);
    if (src instanceof org.hl7.fhir.model.core.Count) return Count40_N.convertCount((org.hl7.fhir.model.core.Count) src);
    if (src instanceof org.hl7.fhir.model.core.DataRequirement)
      return DataRequirement40_N.convertDataRequirement((org.hl7.fhir.model.core.DataRequirement) src);
    if (src instanceof org.hl7.fhir.model.core.Distance)
      return Distance40_N.convertDistance((org.hl7.fhir.model.core.Distance) src);
    if (src instanceof org.hl7.fhir.model.core.Dosage)
      return Dosage40_N.convertDosage((org.hl7.fhir.model.core.Dosage) src);
    if (src instanceof org.hl7.fhir.model.core.Duration)
      return Duration40_N.convertDuration((org.hl7.fhir.model.core.Duration) src);
    if (src instanceof org.hl7.fhir.model.core.Expression)
      return Expression40_N.convertExpression((org.hl7.fhir.model.core.Expression) src);
    if (src instanceof org.hl7.fhir.model.core.HumanName)
      return HumanName40_N.convertHumanName((org.hl7.fhir.model.core.HumanName) src);
    if (src instanceof org.hl7.fhir.model.core.Identifier)
      return Identifier40_N.convertIdentifier((org.hl7.fhir.model.core.Identifier) src);
    if (src instanceof org.hl7.fhir.model.core.MarketingStatus)
      return MarketingStatus40_N.convertMarketingStatus((org.hl7.fhir.model.core.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.model.core.Meta) return Meta40_N.convertMeta((org.hl7.fhir.model.core.Meta) src);
    if (src instanceof org.hl7.fhir.model.core.Money) return Money40_N.convertMoney((org.hl7.fhir.model.core.Money) src);
    if (src instanceof org.hl7.fhir.model.core.ParameterDefinition)
      return ParameterDefinition40_N.convertParameterDefinition((org.hl7.fhir.model.core.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Period)
      return Period40_N.convertPeriod((org.hl7.fhir.model.core.Period) src);
    if (src instanceof org.hl7.fhir.model.core.ProductShelfLife)
      return ProductShelfLife40_N.convertProductShelfLife((org.hl7.fhir.model.core.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.model.core.SimpleQuantity)
      return SimpleQuantity40_N.convertSimpleQuantity((org.hl7.fhir.model.core.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.model.core.Quantity)
      return Quantity40_N.convertQuantity((org.hl7.fhir.model.core.Quantity) src);
    if (src instanceof org.hl7.fhir.model.core.Range) return Range40_N.convertRange((org.hl7.fhir.model.core.Range) src);
    if (src instanceof org.hl7.fhir.model.core.Ratio) return Ratio40_N.convertRatio((org.hl7.fhir.model.core.Ratio) src);
    if (src instanceof org.hl7.fhir.model.core.Reference)
      return Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src);
    if (src instanceof org.hl7.fhir.model.core.RelatedArtifact)
      return RelatedArtifact40_N.convertRelatedArtifact((org.hl7.fhir.model.core.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.model.core.SampledData)
      return SampledData40_N.convertSampledData((org.hl7.fhir.model.core.SampledData) src);
    if (src instanceof org.hl7.fhir.model.core.Signature)
      return Signature40_N.convertSignature((org.hl7.fhir.model.core.Signature) src);
    if (src instanceof org.hl7.fhir.model.core.Timing)
      return Timing40_N.convertTiming((org.hl7.fhir.model.core.Timing) src);
    if (src instanceof org.hl7.fhir.model.core.TriggerDefinition)
      return TriggerDefinition40_N.convertTriggerDefinition((org.hl7.fhir.model.core.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.UsageContext)
      return UsageContext40_N.convertUsageContext((org.hl7.fhir.model.core.UsageContext) src);
    if (src instanceof org.hl7.fhir.model.core.ElementDefinition)
      return ElementDefinition40_N.convertElementDefinition((org.hl7.fhir.model.core.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }
}
