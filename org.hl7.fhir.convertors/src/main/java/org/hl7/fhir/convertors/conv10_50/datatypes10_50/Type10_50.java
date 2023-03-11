package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Address10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Age10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Annotation10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Attachment10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Count10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Distance10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Duration10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.HumanName10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Money10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Quantity10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Range10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Ratio10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.SampledData10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Signature10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.SimpleQuantity10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Timing10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Base64Binary10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Date10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Id10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Instant10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Integer10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.MarkDown10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Oid10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.PositiveInt10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Time10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.UnsignedInt10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uuid10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Type10_50 {

  private final BaseAdvisor_10_50 advisor;

  public Type10_50(BaseAdvisor_10_50 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
      return Base64Binary10_50.convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
      return Boolean10_50.convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
      return Code10_50.convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateType)
      return Date10_50.convertDate((org.hl7.fhir.dstu2.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
      return DateTime10_50.convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
      return Decimal10_50.convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IdType) return Id10_50.convertId((org.hl7.fhir.dstu2.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
      return Instant10_50.convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
      return MarkDown10_50.convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OidType)
      return Oid10_50.convertOid((org.hl7.fhir.dstu2.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
      return PositiveInt10_50.convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StringType)
      return String10_50.convertString((org.hl7.fhir.dstu2.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
      return Time10_50.convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
      return UnsignedInt10_50.convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
      return Integer10_50.convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
      return Uuid10_50.convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UriType)
      return Uri10_50.convertUri((org.hl7.fhir.dstu2.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Extension)
      return Extension10_50.convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
      return Narrative10_50.convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
      return Annotation10_50.convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
      return Attachment10_50.convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
      return CodeableConcept10_50.convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Coding)
      return Coding10_50.convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
      return Identifier10_50.convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Period)
      return Period10_50.convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
      return Quantity10_50.convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Range)
      return Range10_50.convertRange((org.hl7.fhir.dstu2.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
      return Ratio10_50.convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Reference)
      return Reference10_50.convertReference((org.hl7.fhir.dstu2.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
      return SampledData10_50.convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Signature)
      return Signature10_50.convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Address)
      return Address10_50.convertAddress((org.hl7.fhir.dstu2.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
      return ContactPoint10_50.convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
      return HumanName10_50.convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Meta) return Meta10_50.convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Timing)
      return Timing10_50.convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Age) return Age10_50.convertAge((org.hl7.fhir.dstu2.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Count)
      return Count10_50.convertCount((org.hl7.fhir.dstu2.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Distance)
      return Distance10_50.convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Duration)
      return Duration10_50.convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Money)
      return Money10_50.convertMoney((org.hl7.fhir.dstu2.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
      return SimpleQuantity10_50.convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R2 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return Base64Binary10_50.convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return Boolean10_50.convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return Code10_50.convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return Date10_50.convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return DateTime10_50.convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return Decimal10_50.convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType) return Id10_50.convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return Instant10_50.convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return MarkDown10_50.convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType) return Oid10_50.convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return PositiveInt10_50.convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return String10_50.convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return Time10_50.convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return UnsignedInt10_50.convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return Integer10_50.convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return Uuid10_50.convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType) return Uri10_50.convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return Extension10_50.convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return Narrative10_50.convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return Annotation10_50.convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return Attachment10_50.convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return CodeableConcept10_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return Coding10_50.convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return Identifier10_50.convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return Period10_50.convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return Quantity10_50.convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range) return Range10_50.convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio) return Ratio10_50.convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return Reference10_50.convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return SampledData10_50.convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return Signature10_50.convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return Address10_50.convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return ContactPoint10_50.convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return HumanName10_50.convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta) return Meta10_50.convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return Timing10_50.convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (src instanceof org.hl7.fhir.r5.model.Age) return Age10_50.convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Count) return Count10_50.convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return Distance10_50.convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return Duration10_50.convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Money) return Money10_50.convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.SimpleQuantity)
      return SimpleQuantity10_50.convertSimpleQuantity((org.hl7.fhir.r5.model.SimpleQuantity) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R2");
    } else {
      return null;
    }
  }
}
