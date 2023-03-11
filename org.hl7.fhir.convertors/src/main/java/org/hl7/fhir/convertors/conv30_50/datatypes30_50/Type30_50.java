package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Address30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Age30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.ContactPoint30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Count30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Distance30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Duration30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.HumanName30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Money30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Quantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Range30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Ratio30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SampledData30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Signature30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Timing30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Base64Binary30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Date30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Id30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Integer30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Oid30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.PositiveInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Time30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.UnsignedInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uuid30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Type30_50 {

  private final BaseAdvisor_30_50 advisor;

  public Type30_50(BaseAdvisor_30_50 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Base64BinaryType)
      return Base64Binary30_50.convertBase64Binary((org.hl7.fhir.dstu3.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BooleanType)
      return Boolean30_50.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeType)
      return Code30_50.convertCode((org.hl7.fhir.dstu3.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateType)
      return Date30_50.convertDate((org.hl7.fhir.dstu3.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateTimeType)
      return DateTime30_50.convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DecimalType)
      return Decimal30_50.convertDecimal((org.hl7.fhir.dstu3.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IdType) return Id30_50.convertId((org.hl7.fhir.dstu3.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.InstantType)
      return Instant30_50.convertInstant((org.hl7.fhir.dstu3.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PositiveIntType)
      return PositiveInt30_50.convertPositiveInt((org.hl7.fhir.dstu3.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UnsignedIntType)
      return UnsignedInt30_50.convertUnsignedInt((org.hl7.fhir.dstu3.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IntegerType)
      return Integer30_50.convertInteger((org.hl7.fhir.dstu3.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MarkdownType)
      return MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OidType)
      return Oid30_50.convertOid((org.hl7.fhir.dstu3.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StringType)
      return String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TimeType)
      return Time30_50.convertTime((org.hl7.fhir.dstu3.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UuidType)
      return Uuid30_50.convertUuid((org.hl7.fhir.dstu3.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UriType)
      return Uri30_50.convertUri((org.hl7.fhir.dstu3.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Extension)
      return Extension30_50.convertExtension((org.hl7.fhir.dstu3.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Narrative)
      return Narrative30_50.convertNarrative((org.hl7.fhir.dstu3.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Age) return Age30_50.convertAge((org.hl7.fhir.dstu3.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Annotation)
      return Annotation30_50.convertAnnotation((org.hl7.fhir.dstu3.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Attachment)
      return Attachment30_50.convertAttachment((org.hl7.fhir.dstu3.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
      return CodeableConcept30_50.convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Coding)
      return Coding30_50.convertCoding((org.hl7.fhir.dstu3.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Count)
      return Count30_50.convertCount((org.hl7.fhir.dstu3.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Distance)
      return Distance30_50.convertDistance((org.hl7.fhir.dstu3.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Duration)
      return Duration30_50.convertDuration((org.hl7.fhir.dstu3.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Identifier)
      return Identifier30_50.convertIdentifier((org.hl7.fhir.dstu3.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Money)
      return Money30_50.convertMoney((org.hl7.fhir.dstu3.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Period)
      return Period30_50.convertPeriod((org.hl7.fhir.dstu3.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Quantity)
      return Quantity30_50.convertQuantity((org.hl7.fhir.dstu3.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Range)
      return Range30_50.convertRange((org.hl7.fhir.dstu3.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Ratio)
      return Ratio30_50.convertRatio((org.hl7.fhir.dstu3.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Reference)
      return Reference30_50.convertReference((org.hl7.fhir.dstu3.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SampledData)
      return SampledData30_50.convertSampledData((org.hl7.fhir.dstu3.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Signature)
      return Signature30_50.convertSignature((org.hl7.fhir.dstu3.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Address)
      return Address30_50.convertAddress((org.hl7.fhir.dstu3.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactDetail)
      return ContactDetail30_50.convertContactDetail((org.hl7.fhir.dstu3.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactPoint)
      return ContactPoint30_50.convertContactPoint((org.hl7.fhir.dstu3.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Contributor)
      return Contributor30_50.convertContributor((org.hl7.fhir.dstu3.model.Contributor) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Dosage)
      return Dosage30_50.convertDosage((org.hl7.fhir.dstu3.model.Dosage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HumanName)
      return HumanName30_50.convertHumanName((org.hl7.fhir.dstu3.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Meta) return Meta30_50.convertMeta((org.hl7.fhir.dstu3.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ParameterDefinition)
      return ParameterDefinition30_50.convertParameterDefinition((org.hl7.fhir.dstu3.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedArtifact)
      return RelatedArtifact30_50.convertRelatedArtifact((org.hl7.fhir.dstu3.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Timing)
      return Timing30_50.convertTiming((org.hl7.fhir.dstu3.model.Timing) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UsageContext)
      return UsageContext30_50.convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ElementDefinition)
      return ElementDefinition30_50.convertElementDefinition((org.hl7.fhir.dstu3.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataRequirement)
      return DataRequirement30_50.convertDataRequirement((org.hl7.fhir.dstu3.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TriggerDefinition)
      return TriggerDefinition30_50.convertTriggerDefinition((org.hl7.fhir.dstu3.model.TriggerDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R3 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return Base64Binary30_50.convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return Boolean30_50.convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return Code30_50.convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return Date30_50.convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return DateTime30_50.convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return Decimal30_50.convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType) return Id30_50.convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return Instant30_50.convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return PositiveInt30_50.convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return UnsignedInt30_50.convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.Integer64Type)
      return Decimal30_50.convertInteger64((org.hl7.fhir.r5.model.Integer64Type) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return Integer30_50.convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return MarkDown30_50.convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType) return Oid30_50.convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return String30_50.convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return Time30_50.convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return Uuid30_50.convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType) return Uri30_50.convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return Extension30_50.convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return Narrative30_50.convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Age) return Age30_50.convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return Annotation30_50.convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return Attachment30_50.convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return CodeableConcept30_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return Coding30_50.convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.Count) return Count30_50.convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return Distance30_50.convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return Duration30_50.convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return Identifier30_50.convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.Money) return Money30_50.convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return Period30_50.convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return Quantity30_50.convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range) return Range30_50.convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio) return Ratio30_50.convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return Reference30_50.convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return SampledData30_50.convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return Signature30_50.convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return Address30_50.convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactDetail)
      return ContactDetail30_50.convertContactDetail((org.hl7.fhir.r5.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return ContactPoint30_50.convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.Contributor)
      return Contributor30_50.convertContributor((org.hl7.fhir.r5.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r5.model.Dosage)
      return Dosage30_50.convertDosage((org.hl7.fhir.r5.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return HumanName30_50.convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta) return Meta30_50.convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.ParameterDefinition)
      return ParameterDefinition30_50.convertParameterDefinition((org.hl7.fhir.r5.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedArtifact)
      return RelatedArtifact30_50.convertRelatedArtifact((org.hl7.fhir.r5.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return Timing30_50.convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (src instanceof org.hl7.fhir.r5.model.UsageContext)
      return UsageContext30_50.convertUsageContext((org.hl7.fhir.r5.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r5.model.ElementDefinition)
      return ElementDefinition30_50.convertElementDefinition((org.hl7.fhir.r5.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.DataRequirement)
      return DataRequirement30_50.convertDataRequirement((org.hl7.fhir.r5.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r5.model.TriggerDefinition)
      return TriggerDefinition30_50.convertTriggerDefinition((org.hl7.fhir.r5.model.TriggerDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R3");
    } else {
      return null;
    }
  }
}
