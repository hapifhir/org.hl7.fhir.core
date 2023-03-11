package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Address14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Age14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Annotation14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Attachment14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Coding14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Count14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Distance14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Duration14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.HumanName14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Identifier14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Money14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Period14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Quantity14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Range14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Ratio14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.SampledData14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Signature14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Timing14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Base64Binary14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Boolean14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Date14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Id14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Instant14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Integer14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.MarkDown14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Oid14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.PositiveInt14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Time14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.UnsignedInt14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uuid14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Type14_50 {

  private final BaseAdvisor_14_50 advisor;

  public Type14_50(BaseAdvisor_14_50 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2016may.model.Base64BinaryType)
      return Base64Binary14_50.convertBase64Binary((org.hl7.fhir.dstu2016may.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.BooleanType)
      return Boolean14_50.convertBoolean((org.hl7.fhir.dstu2016may.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeType)
      return Code14_50.convertCode((org.hl7.fhir.dstu2016may.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DateType)
      return Date14_50.convertDate((org.hl7.fhir.dstu2016may.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DateTimeType)
      return DateTime14_50.convertDateTime((org.hl7.fhir.dstu2016may.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DecimalType)
      return Decimal14_50.convertDecimal((org.hl7.fhir.dstu2016may.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.IdType)
      return Id14_50.convertId((org.hl7.fhir.dstu2016may.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.InstantType)
      return Instant14_50.convertInstant((org.hl7.fhir.dstu2016may.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.MarkdownType)
      return MarkDown14_50.convertMarkdown((org.hl7.fhir.dstu2016may.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OidType)
      return Oid14_50.convertOid((org.hl7.fhir.dstu2016may.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.PositiveIntType)
      return PositiveInt14_50.convertPositiveInt((org.hl7.fhir.dstu2016may.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StringType)
      return String14_50.convertString((org.hl7.fhir.dstu2016may.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.TimeType)
      return Time14_50.convertTime((org.hl7.fhir.dstu2016may.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UnsignedIntType)
      return UnsignedInt14_50.convertUnsignedInt((org.hl7.fhir.dstu2016may.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.IntegerType)
      return Integer14_50.convertInteger((org.hl7.fhir.dstu2016may.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UuidType)
      return Uuid14_50.convertUuid((org.hl7.fhir.dstu2016may.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UriType)
      return Uri14_50.convertUri((org.hl7.fhir.dstu2016may.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Extension)
      return Extension14_50.convertExtension((org.hl7.fhir.dstu2016may.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Narrative)
      return Narrative14_50.convertNarrative((org.hl7.fhir.dstu2016may.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Age)
      return Age14_50.convertAge((org.hl7.fhir.dstu2016may.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Annotation)
      return Annotation14_50.convertAnnotation((org.hl7.fhir.dstu2016may.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Attachment)
      return Attachment14_50.convertAttachment((org.hl7.fhir.dstu2016may.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeableConcept)
      return CodeableConcept14_50.convertCodeableConcept((org.hl7.fhir.dstu2016may.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Coding)
      return Coding14_50.convertCoding((org.hl7.fhir.dstu2016may.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Count)
      return Count14_50.convertCount((org.hl7.fhir.dstu2016may.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Distance)
      return Distance14_50.convertDistance((org.hl7.fhir.dstu2016may.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Duration)
      return Duration14_50.convertDuration((org.hl7.fhir.dstu2016may.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Identifier)
      return Identifier14_50.convertIdentifier((org.hl7.fhir.dstu2016may.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Money)
      return Money14_50.convertMoney((org.hl7.fhir.dstu2016may.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Period)
      return Period14_50.convertPeriod((org.hl7.fhir.dstu2016may.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Quantity)
      return Quantity14_50.convertQuantity((org.hl7.fhir.dstu2016may.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Range)
      return Range14_50.convertRange((org.hl7.fhir.dstu2016may.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Ratio)
      return Ratio14_50.convertRatio((org.hl7.fhir.dstu2016may.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Reference)
      return Reference14_50.convertReference((org.hl7.fhir.dstu2016may.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.SampledData)
      return SampledData14_50.convertSampledData((org.hl7.fhir.dstu2016may.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Signature)
      return Signature14_50.convertSignature((org.hl7.fhir.dstu2016may.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Address)
      return Address14_50.convertAddress((org.hl7.fhir.dstu2016may.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ContactPoint)
      return ContactPoint14_50.convertContactPoint((org.hl7.fhir.dstu2016may.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.HumanName)
      return HumanName14_50.convertHumanName((org.hl7.fhir.dstu2016may.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Meta)
      return Meta14_50.convertMeta((org.hl7.fhir.dstu2016may.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Timing)
      return Timing14_50.convertTiming((org.hl7.fhir.dstu2016may.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R2B to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return Base64Binary14_50.convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return Boolean14_50.convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return Code14_50.convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return Date14_50.convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return DateTime14_50.convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return Decimal14_50.convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType) return Id14_50.convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return Instant14_50.convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return MarkDown14_50.convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType) return Oid14_50.convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return PositiveInt14_50.convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return String14_50.convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return Time14_50.convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return UnsignedInt14_50.convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return Integer14_50.convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.Integer64Type)
      return Integer14_50.convertInteger64((org.hl7.fhir.r5.model.Integer64Type) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return Uuid14_50.convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType) return Uri14_50.convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return Extension14_50.convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return Narrative14_50.convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Age) return Age14_50.convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return Annotation14_50.convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return Attachment14_50.convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return CodeableConcept14_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return Coding14_50.convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.Count) return Count14_50.convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return Distance14_50.convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return Duration14_50.convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return Identifier14_50.convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.Money) return Money14_50.convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return Period14_50.convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return Quantity14_50.convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range) return Range14_50.convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio) return Ratio14_50.convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return Reference14_50.convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return SampledData14_50.convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return Signature14_50.convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return Address14_50.convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return ContactPoint14_50.convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return HumanName14_50.convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta) return Meta14_50.convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return Timing14_50.convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R5 to R2B");
    } else {
      return null;
    }
  }
}
