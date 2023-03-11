package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Address30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Age30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Attachment30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Count30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Distance30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Duration30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.HumanName30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Money30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Quantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Range30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Ratio30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SampledData30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Signature30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Base64Binary30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Id30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Integer30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.MarkDown30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Oid30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.PositiveInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Time30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.UnsignedInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uuid30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Type30_40 {

  private final BaseAdvisor_30_40 advisor;

  public Type30_40(BaseAdvisor_30_40 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Base64BinaryType)
      return Base64Binary30_40.convertBase64Binary((org.hl7.fhir.dstu3.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BooleanType)
      return Boolean30_40.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeType)
      return Code30_40.convertCode((org.hl7.fhir.dstu3.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateType)
      return Date30_40.convertDate((org.hl7.fhir.dstu3.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateTimeType)
      return DateTime30_40.convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DecimalType)
      return Decimal30_40.convertDecimal((org.hl7.fhir.dstu3.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IdType) return Id30_40.convertId((org.hl7.fhir.dstu3.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.InstantType)
      return Instant30_40.convertInstant((org.hl7.fhir.dstu3.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PositiveIntType)
      return PositiveInt30_40.convertPositiveInt((org.hl7.fhir.dstu3.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UnsignedIntType)
      return UnsignedInt30_40.convertUnsignedInt((org.hl7.fhir.dstu3.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IntegerType)
      return Integer30_40.convertInteger((org.hl7.fhir.dstu3.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MarkdownType)
      return MarkDown30_40.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OidType)
      return Oid30_40.convertOid((org.hl7.fhir.dstu3.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StringType)
      return String30_40.convertString((org.hl7.fhir.dstu3.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TimeType)
      return Time30_40.convertTime((org.hl7.fhir.dstu3.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UuidType)
      return Uuid30_40.convertUuid((org.hl7.fhir.dstu3.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UriType)
      return Uri30_40.convertUri((org.hl7.fhir.dstu3.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Extension)
      return Extension30_40.convertExtension((org.hl7.fhir.dstu3.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Narrative)
      return Narrative30_40.convertNarrative((org.hl7.fhir.dstu3.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Age) return Age30_40.convertAge((org.hl7.fhir.dstu3.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Annotation)
      return Annotation30_40.convertAnnotation((org.hl7.fhir.dstu3.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Attachment)
      return Attachment30_40.convertAttachment((org.hl7.fhir.dstu3.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
      return CodeableConcept30_40.convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Coding)
      return Coding30_40.convertCoding((org.hl7.fhir.dstu3.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Count)
      return Count30_40.convertCount((org.hl7.fhir.dstu3.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Distance)
      return Distance30_40.convertDistance((org.hl7.fhir.dstu3.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Duration)
      return Duration30_40.convertDuration((org.hl7.fhir.dstu3.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Identifier)
      return Identifier30_40.convertIdentifier((org.hl7.fhir.dstu3.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Money)
      return Money30_40.convertMoney((org.hl7.fhir.dstu3.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Period)
      return Period30_40.convertPeriod((org.hl7.fhir.dstu3.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SimpleQuantity)
      return SimpleQuantity30_40.convertSimpleQuantity((org.hl7.fhir.dstu3.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Quantity)
      return Quantity30_40.convertQuantity((org.hl7.fhir.dstu3.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Range)
      return Range30_40.convertRange((org.hl7.fhir.dstu3.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Ratio)
      return Ratio30_40.convertRatio((org.hl7.fhir.dstu3.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Reference)
      return Reference30_40.convertReference((org.hl7.fhir.dstu3.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SampledData)
      return SampledData30_40.convertSampledData((org.hl7.fhir.dstu3.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Signature)
      return Signature30_40.convertSignature((org.hl7.fhir.dstu3.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Address)
      return Address30_40.convertAddress((org.hl7.fhir.dstu3.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactDetail)
      return ContactDetail30_40.convertContactDetail((org.hl7.fhir.dstu3.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactPoint)
      return ContactPoint30_40.convertContactPoint((org.hl7.fhir.dstu3.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Contributor)
      return Contributor30_40.convertContributor((org.hl7.fhir.dstu3.model.Contributor) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Dosage)
      return Dosage30_40.convertDosage((org.hl7.fhir.dstu3.model.Dosage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HumanName)
      return HumanName30_40.convertHumanName((org.hl7.fhir.dstu3.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Meta) return Meta30_40.convertMeta((org.hl7.fhir.dstu3.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ParameterDefinition)
      return ParameterDefinition30_40.convertParameterDefinition((org.hl7.fhir.dstu3.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedArtifact)
      return RelatedArtifact30_40.convertRelatedArtifact((org.hl7.fhir.dstu3.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Timing)
      return Timing30_40.convertTiming((org.hl7.fhir.dstu3.model.Timing) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UsageContext)
      return Timing30_40.convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ElementDefinition)
      return ElementDefinition30_40.convertElementDefinition((org.hl7.fhir.dstu3.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataRequirement)
      return TriggerDefinition30_40.convertDataRequirement((org.hl7.fhir.dstu3.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TriggerDefinition)
      return TriggerDefinition30_40.convertTriggerDefinition((org.hl7.fhir.dstu3.model.TriggerDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R3 to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return Base64Binary30_40.convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return Boolean30_40.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return Code30_40.convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return Date30_40.convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return DateTime30_40.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return Decimal30_40.convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType) return Id30_40.convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return Instant30_40.convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return PositiveInt30_40.convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return UnsignedInt30_40.convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return Integer30_40.convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return MarkDown30_40.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType) return Oid30_40.convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return String30_40.convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return Time30_40.convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return Uuid30_40.convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType) return Uri30_40.convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return Extension30_40.convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return Narrative30_40.convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Age) return Age30_40.convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return Annotation30_40.convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return Attachment30_40.convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return CodeableConcept30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return Coding30_40.convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.Count) return Count30_40.convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return Distance30_40.convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return Duration30_40.convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return Identifier30_40.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.Money) return Money30_40.convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return Period30_40.convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
      return SimpleQuantity30_40.convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity30_40.convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range) return Range30_40.convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio) return Ratio30_40.convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return Reference30_40.convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return SampledData30_40.convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return Signature30_40.convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return Address30_40.convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactDetail)
      return ContactDetail30_40.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return ContactPoint30_40.convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.Contributor)
      return Contributor30_40.convertContributor((org.hl7.fhir.r4.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r4.model.Dosage)
      return Dosage30_40.convertDosage((org.hl7.fhir.r4.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return HumanName30_40.convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta) return Meta30_40.convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.ParameterDefinition)
      return ParameterDefinition30_40.convertParameterDefinition((org.hl7.fhir.r4.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedArtifact)
      return RelatedArtifact30_40.convertRelatedArtifact((org.hl7.fhir.r4.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return Timing30_40.convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4.model.UsageContext)
      return Timing30_40.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4.model.ElementDefinition)
      return ElementDefinition30_40.convertElementDefinition((org.hl7.fhir.r4.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.DataRequirement)
      return TriggerDefinition30_40.convertDataRequirement((org.hl7.fhir.r4.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4.model.TriggerDefinition)
      return TriggerDefinition30_40.convertTriggerDefinition((org.hl7.fhir.r4.model.TriggerDefinition) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R3");
    } else {
      return null;
    }
  }
}
