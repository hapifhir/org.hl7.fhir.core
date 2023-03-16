package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Address10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Age10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Annotation10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Attachment10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Coding10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.ContactPoint10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Count10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Distance10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Duration10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.HumanName10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Money10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Quantity10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Range10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Ratio10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.SampledData10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Signature10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.SimpleQuantity10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Timing10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Base64Binary10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Code10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Date10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Decimal10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Id10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Integer10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.MarkDown10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Oid10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.PositiveInt10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Time10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.UnsignedInt10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uuid10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Type10_40 {

  private final BaseAdvisor_10_40 advisor;

  public Type10_40(BaseAdvisor_10_40 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
      return Base64Binary10_40.convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
      return Boolean10_40.convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
      return Code10_40.convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateType)
      return Date10_40.convertDate((org.hl7.fhir.dstu2.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
      return DateTime10_40.convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
      return Decimal10_40.convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IdType) return Id10_40.convertId((org.hl7.fhir.dstu2.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
      return Instant10_40.convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
      return MarkDown10_40.convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OidType)
      return Oid10_40.convertOid((org.hl7.fhir.dstu2.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
      return PositiveInt10_40.convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StringType)
      return String10_40.convertString((org.hl7.fhir.dstu2.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
      return Time10_40.convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
      return UnsignedInt10_40.convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
      return Integer10_40.convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
      return Uuid10_40.convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UriType)
      return Uri10_40.convertUri((org.hl7.fhir.dstu2.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Extension)
      return Extension10_40.convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
      return Narrative10_40.convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
      return Annotation10_40.convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
      return Attachment10_40.convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
      return CodeableConcept10_40.convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Coding)
      return Coding10_40.convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
      return Identifier10_40.convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Period)
      return Period10_40.convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
      return Quantity10_40.convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Range)
      return Range10_40.convertRange((org.hl7.fhir.dstu2.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
      return Ratio10_40.convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Reference)
      return Reference10_40.convertReference((org.hl7.fhir.dstu2.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
      return SampledData10_40.convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Signature)
      return Signature10_40.convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Address)
      return Address10_40.convertAddress((org.hl7.fhir.dstu2.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
      return ContactPoint10_40.convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
      return HumanName10_40.convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Meta) return Meta10_40.convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Timing)
      return Timing10_40.convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Age) return Age10_40.convertAge((org.hl7.fhir.dstu2.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Count)
      return Count10_40.convertCount((org.hl7.fhir.dstu2.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Distance)
      return Distance10_40.convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Duration)
      return Duration10_40.convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Money)
      return Money10_40.convertMoney((org.hl7.fhir.dstu2.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
      return SimpleQuantity10_40.convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R2 to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return Base64Binary10_40.convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return Boolean10_40.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return Code10_40.convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return Date10_40.convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return DateTime10_40.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return Decimal10_40.convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType) return Id10_40.convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return Instant10_40.convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return MarkDown10_40.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType) return Oid10_40.convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return PositiveInt10_40.convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return String10_40.convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return Time10_40.convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return UnsignedInt10_40.convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return Integer10_40.convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return Uuid10_40.convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType) return Uri10_40.convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return Extension10_40.convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return Narrative10_40.convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return Annotation10_40.convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return Attachment10_40.convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return CodeableConcept10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return Coding10_40.convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return Identifier10_40.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return Period10_40.convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity10_40.convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range) return Range10_40.convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio) return Ratio10_40.convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return Reference10_40.convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return SampledData10_40.convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return Signature10_40.convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return Address10_40.convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return ContactPoint10_40.convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return HumanName10_40.convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta) return Meta10_40.convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return Timing10_40.convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4.model.Age) return Age10_40.convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Count) return Count10_40.convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return Distance10_40.convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return Duration10_40.convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Money) return Money10_40.convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
      return SimpleQuantity10_40.convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R2");
    } else {
      return null;
    }
  }
}
