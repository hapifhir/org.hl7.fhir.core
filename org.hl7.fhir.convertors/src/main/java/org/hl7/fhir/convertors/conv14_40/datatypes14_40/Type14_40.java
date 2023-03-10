package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Address14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Age14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Annotation14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Attachment14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Count14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Distance14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Duration14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.HumanName14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Money14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Period14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Quantity14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Range14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Ratio14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.SampledData14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Signature14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Timing14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Base64Binary14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Boolean14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Date14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Decimal14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Id14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Instant14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Integer14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.MarkDown14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Oid14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.PositiveInt14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Time14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.UnsignedInt14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uuid14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Type14_40 {

  private final BaseAdvisor_14_40 advisor;

  public Type14_40(BaseAdvisor_14_40 advisor) {
    this.advisor = advisor;
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2016may.model.Base64BinaryType)
      return Base64Binary14_40.convertBase64Binary((org.hl7.fhir.dstu2016may.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.BooleanType)
      return Boolean14_40.convertBoolean((org.hl7.fhir.dstu2016may.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeType)
      return Code14_40.convertCode((org.hl7.fhir.dstu2016may.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DateType)
      return Date14_40.convertDate((org.hl7.fhir.dstu2016may.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DateTimeType)
      return DateTime14_40.convertDateTime((org.hl7.fhir.dstu2016may.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DecimalType)
      return Decimal14_40.convertDecimal((org.hl7.fhir.dstu2016may.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.IdType)
      return Id14_40.convertId((org.hl7.fhir.dstu2016may.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.InstantType)
      return Instant14_40.convertInstant((org.hl7.fhir.dstu2016may.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.MarkdownType)
      return MarkDown14_40.convertMarkdown((org.hl7.fhir.dstu2016may.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OidType)
      return Oid14_40.convertOid((org.hl7.fhir.dstu2016may.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.PositiveIntType)
      return PositiveInt14_40.convertPositiveInt((org.hl7.fhir.dstu2016may.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StringType)
      return String14_40.convertString((org.hl7.fhir.dstu2016may.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.TimeType)
      return Time14_40.convertTime((org.hl7.fhir.dstu2016may.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UnsignedIntType)
      return UnsignedInt14_40.convertUnsignedInt((org.hl7.fhir.dstu2016may.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.IntegerType)
      return Integer14_40.convertInteger((org.hl7.fhir.dstu2016may.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UuidType)
      return Uuid14_40.convertUuid((org.hl7.fhir.dstu2016may.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.UriType)
      return Uri14_40.convertUri((org.hl7.fhir.dstu2016may.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Extension)
      return Extension14_40.convertExtension((org.hl7.fhir.dstu2016may.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Narrative)
      return Narrative14_40.convertNarrative((org.hl7.fhir.dstu2016may.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Age)
      return Age14_40.convertAge((org.hl7.fhir.dstu2016may.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Annotation)
      return Annotation14_40.convertAnnotation((org.hl7.fhir.dstu2016may.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Attachment)
      return Attachment14_40.convertAttachment((org.hl7.fhir.dstu2016may.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeableConcept)
      return CodeableConcept14_40.convertCodeableConcept((org.hl7.fhir.dstu2016may.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Coding)
      return Coding14_40.convertCoding((org.hl7.fhir.dstu2016may.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Count)
      return Count14_40.convertCount((org.hl7.fhir.dstu2016may.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Distance)
      return Distance14_40.convertDistance((org.hl7.fhir.dstu2016may.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Duration)
      return Duration14_40.convertDuration((org.hl7.fhir.dstu2016may.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Identifier)
      return Identifier14_40.convertIdentifier((org.hl7.fhir.dstu2016may.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Money)
      return Money14_40.convertMoney((org.hl7.fhir.dstu2016may.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Period)
      return Period14_40.convertPeriod((org.hl7.fhir.dstu2016may.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Quantity)
      return Quantity14_40.convertQuantity((org.hl7.fhir.dstu2016may.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Range)
      return Range14_40.convertRange((org.hl7.fhir.dstu2016may.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Ratio)
      return Ratio14_40.convertRatio((org.hl7.fhir.dstu2016may.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Reference)
      return Reference14_40.convertReference((org.hl7.fhir.dstu2016may.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.SampledData)
      return SampledData14_40.convertSampledData((org.hl7.fhir.dstu2016may.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Signature)
      return Signature14_40.convertSignature((org.hl7.fhir.dstu2016may.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Address)
      return Address14_40.convertAddress((org.hl7.fhir.dstu2016may.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ContactPoint)
      return ContactPoint14_40.convertContactPoint((org.hl7.fhir.dstu2016may.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.HumanName)
      return HumanName14_40.convertHumanName((org.hl7.fhir.dstu2016may.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Meta)
      return Meta14_40.convertMeta((org.hl7.fhir.dstu2016may.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Timing)
      return Timing14_40.convertTiming((org.hl7.fhir.dstu2016may.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R2B to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return Base64Binary14_40.convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return Boolean14_40.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return Code14_40.convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return Date14_40.convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return DateTime14_40.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return Decimal14_40.convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType) return Id14_40.convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return Instant14_40.convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return MarkDown14_40.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType) return Oid14_40.convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return PositiveInt14_40.convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return String14_40.convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return Time14_40.convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return UnsignedInt14_40.convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return Integer14_40.convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return Uuid14_40.convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType) return Uri14_40.convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return Extension14_40.convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return Narrative14_40.convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Age) return Age14_40.convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return Annotation14_40.convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return Attachment14_40.convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return CodeableConcept14_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return Coding14_40.convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.Count) return Count14_40.convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return Distance14_40.convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return Duration14_40.convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return Identifier14_40.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.Money) return Money14_40.convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return Period14_40.convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity14_40.convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range) return Range14_40.convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio) return Ratio14_40.convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return Reference14_40.convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return SampledData14_40.convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return Signature14_40.convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return Address14_40.convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return ContactPoint14_40.convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return HumanName14_40.convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta) return Meta14_40.convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return Timing14_40.convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The type " + src.fhirType()+" cannot be converted from R4 to R2B");
    } else {
      return null;
    }
  }
}
