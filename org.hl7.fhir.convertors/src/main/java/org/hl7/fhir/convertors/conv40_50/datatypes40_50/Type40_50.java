package org.hl7.fhir.convertors.conv40_50.datatypes40_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Address40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Age40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Count40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Distance40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Duration40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.HumanName40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Money40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.MoneyQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Range40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Ratio40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SampledData40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Signature40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Timing40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.Contributor40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.DataRequirement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.Expression40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ParameterDefinition40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.RelatedArtifact40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.TriggerDefinition40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Base64Binary40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Oid40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Time40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Url40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uuid40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Dosage40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.ElementDefinition40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Meta40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Narrative40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.MarketingStatus40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.ProdCharacteristic40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.ProductShelfLife40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.SubstanceAmount40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Type40_50 {

  private final BaseAdvisor_40_50 advisor;

  public Type40_50(BaseAdvisor_40_50 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return Base64Binary40_50.convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return Boolean40_50.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CanonicalType)
      return Canonical40_50.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return Code40_50.convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return Date40_50.convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return DateTime40_50.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return Decimal40_50.convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType) return Id40_50.convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return Instant40_50.convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return UnsignedInt40_50.convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return PositiveInt40_50.convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return Integer40_50.convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType) return Oid40_50.convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return Time40_50.convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UrlType) return Url40_50.convertUrl((org.hl7.fhir.r4.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return Uuid40_50.convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType) return Uri40_50.convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return String40_50.convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return Extension40_50.convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return Narrative40_50.convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return Address40_50.convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.Age) return Age40_50.convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return Annotation40_50.convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return Attachment40_50.convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return Coding40_50.convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactDetail)
      return ContactDetail40_50.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return ContactPoint40_50.convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.Contributor)
      return Contributor40_50.convertContributor((org.hl7.fhir.r4.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r4.model.Count) return Count40_50.convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.DataRequirement)
      return DataRequirement40_50.convertDataRequirement((org.hl7.fhir.r4.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return Distance40_50.convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Dosage)
      return Dosage40_50.convertDosage((org.hl7.fhir.r4.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return Duration40_50.convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Expression)
      return Expression40_50.convertExpression((org.hl7.fhir.r4.model.Expression) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return HumanName40_50.convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return Identifier40_50.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.MarketingStatus)
      return MarketingStatus40_50.convertMarketingStatus((org.hl7.fhir.r4.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta) return Meta40_50.convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.Money) return Money40_50.convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.ParameterDefinition)
      return ParameterDefinition40_50.convertParameterDefinition((org.hl7.fhir.r4.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return Period40_50.convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.ProdCharacteristic)
      return ProdCharacteristic40_50.convertProdCharacteristic((org.hl7.fhir.r4.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r4.model.ProductShelfLife)
      return ProductShelfLife40_50.convertProductShelfLife((org.hl7.fhir.r4.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r4.model.MoneyQuantity)
      return MoneyQuantity40_50.convertMoneyQuantity((org.hl7.fhir.r4.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
      return SimpleQuantity40_50.convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity40_50.convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range) return Range40_50.convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio) return Ratio40_50.convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedArtifact)
      return RelatedArtifact40_50.convertRelatedArtifact((org.hl7.fhir.r4.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return SampledData40_50.convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return Signature40_50.convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceAmount)
      return SubstanceAmount40_50.convertSubstanceAmount((org.hl7.fhir.r4.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return Timing40_50.convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4.model.TriggerDefinition)
      return TriggerDefinition40_50.convertTriggerDefinition((org.hl7.fhir.r4.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.UsageContext)
      return UsageContext40_50.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4.model.ElementDefinition)
      return ElementDefinition40_50.convertElementDefinition((org.hl7.fhir.r4.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return Base64Binary40_50.convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return Boolean40_50.convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CanonicalType)
      return Canonical40_50.convertCanonical((org.hl7.fhir.r5.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return Code40_50.convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return Date40_50.convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return DateTime40_50.convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return Decimal40_50.convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType) return Id40_50.convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return Instant40_50.convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return MarkDown40_50.convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType) return Oid40_50.convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return PositiveInt40_50.convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return String40_50.convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return Time40_50.convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return UnsignedInt40_50.convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return Integer40_50.convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.Integer64Type)
      return Integer40_50.convertInteger64((org.hl7.fhir.r5.model.Integer64Type) src);
    if (src instanceof org.hl7.fhir.r5.model.UrlType) return Url40_50.convertUrl((org.hl7.fhir.r5.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return Uuid40_50.convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType) return Uri40_50.convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return Extension40_50.convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return Narrative40_50.convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return Address40_50.convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.Age) return Age40_50.convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return Annotation40_50.convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return Attachment40_50.convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return Coding40_50.convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactDetail)
      return ContactDetail40_50.convertContactDetail((org.hl7.fhir.r5.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return ContactPoint40_50.convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.Contributor)
      return Contributor40_50.convertContributor((org.hl7.fhir.r5.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r5.model.Count) return Count40_50.convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.DataRequirement)
      return DataRequirement40_50.convertDataRequirement((org.hl7.fhir.r5.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return Distance40_50.convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Dosage)
      return Dosage40_50.convertDosage((org.hl7.fhir.r5.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return Duration40_50.convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Expression)
      return Expression40_50.convertExpression((org.hl7.fhir.r5.model.Expression) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return HumanName40_50.convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return Identifier40_50.convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.MarketingStatus)
      return MarketingStatus40_50.convertMarketingStatus((org.hl7.fhir.r5.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta) return Meta40_50.convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.Money) return Money40_50.convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.ParameterDefinition)
      return ParameterDefinition40_50.convertParameterDefinition((org.hl7.fhir.r5.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return Period40_50.convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.ProdCharacteristic)
      return ProdCharacteristic40_50.convertProdCharacteristic((org.hl7.fhir.r5.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r5.model.ProductShelfLife)
      return ProductShelfLife40_50.convertProductShelfLife((org.hl7.fhir.r5.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r5.model.MoneyQuantity)
      return MoneyQuantity40_50.convertMoneyQuantity((org.hl7.fhir.r5.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r5.model.SimpleQuantity)
      return SimpleQuantity40_50.convertSimpleQuantity((org.hl7.fhir.r5.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return Quantity40_50.convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range) return Range40_50.convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio) return Ratio40_50.convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return Reference40_50.convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedArtifact)
      return RelatedArtifact40_50.convertRelatedArtifact((org.hl7.fhir.r5.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return SampledData40_50.convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return Signature40_50.convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceAmount)
      return SubstanceAmount40_50.convertSubstanceAmount((org.hl7.fhir.r5.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return Timing40_50.convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (src instanceof org.hl7.fhir.r5.model.TriggerDefinition)
      return TriggerDefinition40_50.convertTriggerDefinition((org.hl7.fhir.r5.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.UsageContext)
      return UsageContext40_50.convertUsageContext((org.hl7.fhir.r5.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r5.model.ElementDefinition)
      return ElementDefinition40_50.convertElementDefinition((org.hl7.fhir.r5.model.ElementDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }
}
