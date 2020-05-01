package org.hl7.fhir.convertors;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.model.Base64BinaryType;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.DecimalType;
import org.hl7.fhir.r4.model.InstantType;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.MarkdownType;
import org.hl7.fhir.r4.model.OidType;
import org.hl7.fhir.r4.model.PositiveIntType;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.TimeType;
import org.hl7.fhir.r4.model.UnsignedIntType;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.model.UuidType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class VersionConvertorPrimitiveType40_50Test {

  private static final String AUDIT_EVENT_SOURCE = "{\"resourceType\" : \"AuditEvent\",\"id\" : \"example\",\"text\" : {\"status\" : \"generated\",\"div\" : \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">Application Start for under service login &quot;Grahame&quot; (id: Grahame's Test HL7Connect)</div>\"},\"type\" : {\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110100\",\"display\" : \"Application Activity\"},\"subtype\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110120\",\"display\" : \"Application Start\"}],\"action\" : \"E\",\"recorded\" : \"2012-10-25T22:04:27+11:00\",\"outcome\" : \"0\",\"agent\" : [{\"type\" : {\"coding\" : [{\"system\" : \"http://terminology.hl7.org/CodeSystem/extra-security-role-type\",\"code\" : \"humanuser\",\"display\" : \"human user\"}]},\"role\" : [{\"text\" : \"Service User (Logon)\"}],\"who\" : {\"identifier\" : {\"value\" : \"Grahame\"}},\"requestor\" : false,\"network\" : {\"address\" : \"127.0.0.1\",\"type\" : \"2\"}},{\"type\" : {\"coding\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110153\",\"display\" : \"Source Role ID\"}]},\"who\" : {\"identifier\" : {\"system\" : \"urn:oid:2.16.840.1.113883.4.2\",\"value\" : \"2.16.840.1.113883.4.2\"}},\"altId\" : \"6580\",\"requestor\" : false,\"network\" : {\"address\" : \"Workstation1.ehr.familyclinic.com\",\"type\" : \"1\"}}],\"source\" : {\"site\" : \"Development\",\"observer\" : {\"display\" : \"Grahame's Laptop\"},\"type\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110122\",\"display\" : \"Login\"}]},\"entity\" : [{\"what\" : {\"identifier\" : {\"type\" : {\"coding\" : [{\"system\" : \"http://terminology.hl7.org/CodeSystem/v2-0203\",\"code\" : \"SNO\"}],\"text\" : \"Dell Serial Number\"},\"value\" : \"ABCDEF\"}},\"type\" : {\"system\" : \"http://terminology.hl7.org/CodeSystem/audit-entity-type\",\"code\" : \"4\",\"display\" : \"Other\"},\"role\" : {\"system\" : \"http://terminology.hl7.org/CodeSystem/object-role\",\"code\" : \"4\",\"display\" : \"Domain Resource\"},\"lifecycle\" : {\"system\" : \"http://terminology.hl7.org/CodeSystem/dicom-audit-lifecycle\",\"code\" : \"6\",\"display\" : \"Access / Use\"},\"name\" : \"Grahame's Laptop\"}]}";
  private static final String PROVENANCE_SOURCE = "{\"resourceType\" : \"Provenance\",\"id\" : \"example\",\"text\" : {\"status\" : \"generated\",\"div\" : \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">procedure record authored on 27-June 2015 by Harold Hippocrates, MD Content extracted from XDS managed CDA Referral received 26-June as authorized by a referenced Consent.</div>\"},\"target\" : [{\"reference\" : \"Procedure/example/_history/1\"}],\"occurredPeriod\" : {\"start\" : \"2015-06-27\",\"end\" : \"2015-06-28\"},\"recorded\" : \"2015-06-27T08:39:24+10:00\",\"policy\" : [\"http://acme.com/fhir/Consent/25\"],\"location\" : {\"reference\" : \"Location/1\"},\"reason\" : [{\"coding\" : [{\"system\" : \"http://snomed.info/sct\",\"code\" : \"3457005\",\"display\" : \"Referral\"}]}],\"agent\" : [{\"type\" : {\"coding\" : [{\"system\" : \"http://terminology.hl7.org/CodeSystem/v3-ParticipationType\",\"code\" : \"AUT\"}]},\"who\" : {\"reference\" : \"Practitioner/xcda-author\"}},{\"id\" : \"a1\",\"type\" : {\"coding\" : [{\"system\" : \"http://terminology.hl7.org/CodeSystem/v3-ParticipationType\",\"code\" : \"DEV\"}]},\"who\" : {\"reference\" : \"Device/software\"}}],\"entity\" : [{\"role\" : \"source\",\"what\" : {\"reference\" : \"DocumentReference/example\",\"display\" : \"CDA Document in XDS repository\"}}]}";

  @Test
  public void testAuditEvent() throws FHIRFormatError, IOException {
    org.hl7.fhir.r4.model.AuditEvent ae4 = (org.hl7.fhir.r4.model.AuditEvent) new org.hl7.fhir.r4.formats.JsonParser().parse(AUDIT_EVENT_SOURCE);
    org.hl7.fhir.r5.model.AuditEvent ae5 = (org.hl7.fhir.r5.model.AuditEvent) VersionConvertor_40_50.convertResource(ae4);
    Assertions.assertEquals(ae5.getId(), ae4.getId());
  }


  @Test
  public void testProvenance() throws FHIRFormatError, IOException {
    org.hl7.fhir.r4.model.Provenance ae4 = (org.hl7.fhir.r4.model.Provenance) new org.hl7.fhir.r4.formats.JsonParser().parse(PROVENANCE_SOURCE);
    org.hl7.fhir.r5.model.Provenance ae5 = (org.hl7.fhir.r5.model.Provenance) VersionConvertor_40_50.convertResource(ae4);
    Assertions.assertEquals(ae5.getId(), ae4.getId());
  }


  @ParameterizedTest(name = "Testing r4 -> r5 conversion of null value {0}.")
  @MethodSource("r4PrimitiveTypes")
  public <T extends PrimitiveType> void testNullValueDstu2Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new StringType("A value"));
    Assertions.assertNull(((org.hl7.fhir.r5.model.PrimitiveType) VersionConvertor_40_50.convertType(obj)).getValue());
  }

  @ParameterizedTest(name = "Testing r5 -> r4 conversion of null value {0}.")
  @MethodSource("r5PrimitiveTypes")
  public <T extends org.hl7.fhir.r5.model.PrimitiveType> void testNullValueR5Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.r5.model.StringType("A value"));
    Assertions.assertNull(((PrimitiveType) VersionConvertor_40_50.convertType(obj)).getValue());
  }

  public static Stream<Arguments> r4PrimitiveTypes() {
    return Stream.of(
      Arguments.arguments(BooleanType.class.getSimpleName(), new BooleanType()),
      Arguments.arguments(CodeType.class.getSimpleName(), new CodeType()),
      Arguments.arguments(DateType.class.getSimpleName(), new DateType()),
      Arguments.arguments(DateTimeType.class.getSimpleName(), new DateTimeType()),
      Arguments.arguments(DecimalType.class.getSimpleName(), new DecimalType()),
      Arguments.arguments(InstantType.class.getSimpleName(), new InstantType()),
      Arguments.arguments(PositiveIntType.class.getSimpleName(), new PositiveIntType()),
      Arguments.arguments(UnsignedIntType.class.getSimpleName(), new UnsignedIntType()),
      Arguments.arguments(IntegerType.class.getSimpleName(), new IntegerType()),
      Arguments.arguments(MarkdownType.class.getSimpleName(), new MarkdownType()),
      Arguments.arguments(OidType.class.getSimpleName(), new OidType()),
      Arguments.arguments(StringType.class.getSimpleName(), new StringType()),
      Arguments.arguments(TimeType.class.getSimpleName(), new TimeType()),
      Arguments.arguments(UuidType.class.getSimpleName(), new UuidType()),
      Arguments.arguments(Base64BinaryType.class.getSimpleName(), new Base64BinaryType()),
      Arguments.arguments(UriType.class.getSimpleName(), new UriType()));
  }

  public static Stream<Arguments> r5PrimitiveTypes() {
    return Stream.of(
      Arguments.arguments(org.hl7.fhir.r5.model.BooleanType.class.getSimpleName(), new org.hl7.fhir.r5.model.BooleanType()),
      Arguments.arguments(org.hl7.fhir.r5.model.CodeType.class.getSimpleName(), new org.hl7.fhir.r5.model.CodeType()),
      Arguments.arguments(org.hl7.fhir.r5.model.DateType.class.getSimpleName(), new org.hl7.fhir.r5.model.DateType()),
      Arguments.arguments(org.hl7.fhir.r5.model.DateTimeType.class.getSimpleName(), new org.hl7.fhir.r5.model.DateTimeType()),
      Arguments.arguments(org.hl7.fhir.r5.model.DecimalType.class.getSimpleName(), new org.hl7.fhir.r5.model.DecimalType()),
      Arguments.arguments(org.hl7.fhir.r5.model.InstantType.class.getSimpleName(), new org.hl7.fhir.r5.model.InstantType()),
      Arguments.arguments(org.hl7.fhir.r5.model.PositiveIntType.class.getSimpleName(), new org.hl7.fhir.r5.model.PositiveIntType()),
      Arguments.arguments(org.hl7.fhir.r5.model.UnsignedIntType.class.getSimpleName(), new org.hl7.fhir.r5.model.UnsignedIntType()),
      Arguments.arguments(org.hl7.fhir.r5.model.IntegerType.class.getSimpleName(), new org.hl7.fhir.r5.model.IntegerType()),
      Arguments.arguments(org.hl7.fhir.r5.model.MarkdownType.class.getSimpleName(), new org.hl7.fhir.r5.model.MarkdownType()),
      Arguments.arguments(org.hl7.fhir.r5.model.OidType.class.getSimpleName(), new org.hl7.fhir.r5.model.OidType()),
      Arguments.arguments(org.hl7.fhir.r5.model.StringType.class.getSimpleName(), new org.hl7.fhir.r5.model.StringType()),
      Arguments.arguments(org.hl7.fhir.r5.model.TimeType.class.getSimpleName(), new org.hl7.fhir.r5.model.TimeType()),
      Arguments.arguments(org.hl7.fhir.r5.model.UuidType.class.getSimpleName(), new org.hl7.fhir.r5.model.UuidType()),
      Arguments.arguments(org.hl7.fhir.r5.model.Base64BinaryType.class.getSimpleName(), new org.hl7.fhir.r5.model.Base64BinaryType()),
      Arguments.arguments(org.hl7.fhir.r5.model.UriType.class.getSimpleName(), new org.hl7.fhir.r5.model.UriType()));
  }
}

