package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import java.util.ArrayList;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Address10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Age10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Annotation10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Attachment10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Count10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Distance10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Duration10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.HumanName10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Money10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Quantity10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Range10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Ratio10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.SampledData10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Signature10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.SimpleQuantity10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Timing10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Base64Binary10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Code10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Date10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Decimal10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Id10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Integer10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.MarkDown10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Oid10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.PositiveInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Time10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.UnsignedInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uuid10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Type10_30 {

  private final BaseAdvisor_10_30 advisor;

  public Type10_30(BaseAdvisor_10_30 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
      return Base64Binary10_30.convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
      return Boolean10_30.convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
      return Code10_30.convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateType)
      return Date10_30.convertDate((org.hl7.fhir.dstu2.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
      return DateTime10_30.convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
      return Decimal10_30.convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IdType) return Id10_30.convertId((org.hl7.fhir.dstu2.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
      return Instant10_30.convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
      return PositiveInt10_30.convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
      return UnsignedInt10_30.convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
      return Integer10_30.convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
      return MarkDown10_30.convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OidType)
      return Oid10_30.convertOid((org.hl7.fhir.dstu2.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StringType)
      return String10_30.convertString((org.hl7.fhir.dstu2.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
      return Time10_30.convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
      return Uuid10_30.convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UriType)
      return Uri10_30.convertUri((org.hl7.fhir.dstu2.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Extension)
      return Extension10_30.convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
      return Narrative10_30.convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
      return Annotation10_30.convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
      return Attachment10_30.convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
      return CodeableConcept10_30.convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Coding)
      return Coding10_30.convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
      return Identifier10_30.convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Period)
      return Period10_30.convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Age) return Age10_30.convertAge((org.hl7.fhir.dstu2.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Count)
      return Count10_30.convertCount((org.hl7.fhir.dstu2.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Distance)
      return Distance10_30.convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Duration)
      return Duration10_30.convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Money)
      return Money10_30.convertMoney((org.hl7.fhir.dstu2.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
      return SimpleQuantity10_30.convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
      return Quantity10_30.convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Range)
      return Range10_30.convertRange((org.hl7.fhir.dstu2.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
      return Ratio10_30.convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Reference)
      return Reference10_30.convertReference((org.hl7.fhir.dstu2.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
      return SampledData10_30.convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Signature)
      return Signature10_30.convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Address)
      return Address10_30.convertAddress((org.hl7.fhir.dstu2.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
      return ContactPoint10_30.convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ElementDefinition)
      return ElementDefinition10_30.convertElementDefinition((org.hl7.fhir.dstu2.model.ElementDefinition) src, new ArrayList<String>());
    if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
      return HumanName10_30.convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Meta) return Meta10_30.convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Timing)
      return Timing10_30.convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R2 to R3");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Base64BinaryType)
      return Base64Binary10_30.convertBase64Binary((org.hl7.fhir.dstu3.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BooleanType)
      return Boolean10_30.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeType)
      return Code10_30.convertCode((org.hl7.fhir.dstu3.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateType)
      return Date10_30.convertDate((org.hl7.fhir.dstu3.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateTimeType)
      return DateTime10_30.convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DecimalType)
      return Decimal10_30.convertDecimal((org.hl7.fhir.dstu3.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IdType) return Id10_30.convertId((org.hl7.fhir.dstu3.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.InstantType)
      return Instant10_30.convertInstant((org.hl7.fhir.dstu3.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PositiveIntType)
      return PositiveInt10_30.convertPositiveInt((org.hl7.fhir.dstu3.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UnsignedIntType)
      return UnsignedInt10_30.convertUnsignedInt((org.hl7.fhir.dstu3.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IntegerType)
      return Integer10_30.convertInteger((org.hl7.fhir.dstu3.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MarkdownType)
      return MarkDown10_30.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OidType)
      return Oid10_30.convertOid((org.hl7.fhir.dstu3.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StringType)
      return String10_30.convertString((org.hl7.fhir.dstu3.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TimeType)
      return Time10_30.convertTime((org.hl7.fhir.dstu3.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UuidType)
      return Uuid10_30.convertUuid((org.hl7.fhir.dstu3.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UriType)
      return Uri10_30.convertUri((org.hl7.fhir.dstu3.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Extension)
      return Extension10_30.convertExtension((org.hl7.fhir.dstu3.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Narrative)
      return Narrative10_30.convertNarrative((org.hl7.fhir.dstu3.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Annotation)
      return Annotation10_30.convertAnnotation((org.hl7.fhir.dstu3.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Attachment)
      return Attachment10_30.convertAttachment((org.hl7.fhir.dstu3.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
      return CodeableConcept10_30.convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Coding)
      return Coding10_30.convertCoding((org.hl7.fhir.dstu3.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Identifier)
      return Identifier10_30.convertIdentifier((org.hl7.fhir.dstu3.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Period)
      return Period10_30.convertPeriod((org.hl7.fhir.dstu3.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Age) return Age10_30.convertAge((org.hl7.fhir.dstu3.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Count)
      return Count10_30.convertCount((org.hl7.fhir.dstu3.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Distance)
      return Distance10_30.convertDistance((org.hl7.fhir.dstu3.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Duration)
      return Duration10_30.convertDuration((org.hl7.fhir.dstu3.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Money)
      return Money10_30.convertMoney((org.hl7.fhir.dstu3.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SimpleQuantity)
      return SimpleQuantity10_30.convertSimpleQuantity((org.hl7.fhir.dstu3.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Quantity)
      return Quantity10_30.convertQuantity((org.hl7.fhir.dstu3.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Range)
      return Range10_30.convertRange((org.hl7.fhir.dstu3.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Ratio)
      return Ratio10_30.convertRatio((org.hl7.fhir.dstu3.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Reference)
      return Reference10_30.convertReference((org.hl7.fhir.dstu3.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SampledData)
      return SampledData10_30.convertSampledData((org.hl7.fhir.dstu3.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Signature)
      return Signature10_30.convertSignature((org.hl7.fhir.dstu3.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Address)
      return Address10_30.convertAddress((org.hl7.fhir.dstu3.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactPoint)
      return ContactPoint10_30.convertContactPoint((org.hl7.fhir.dstu3.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ElementDefinition)
      return ElementDefinition10_30.convertElementDefinition((org.hl7.fhir.dstu3.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HumanName)
      return HumanName10_30.convertHumanName((org.hl7.fhir.dstu3.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Meta) return Meta10_30.convertMeta((org.hl7.fhir.dstu3.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Timing)
      return Timing10_30.convertTiming((org.hl7.fhir.dstu3.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R3 to R2");
    } else {
      return null;
    }
  }
}
