package org.hl7.fhir.convertors;

import org.hl7.fhir.dstu3.model.Base64BinaryType;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DateType;
import org.hl7.fhir.dstu3.model.DecimalType;
import org.hl7.fhir.dstu3.model.InstantType;
import org.hl7.fhir.dstu3.model.IntegerType;
import org.hl7.fhir.dstu3.model.MarkdownType;
import org.hl7.fhir.dstu3.model.OidType;
import org.hl7.fhir.dstu3.model.PositiveIntType;
import org.hl7.fhir.dstu3.model.PrimitiveType;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.TimeType;
import org.hl7.fhir.dstu3.model.UnsignedIntType;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.dstu3.model.UuidType;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class VersionConvertorPrimitiveType30_50Test {

  private static final String AUDIT_EVENT_SOURCE = "{\"resourceType\" : \"AuditEvent\",\"id\" : \"example\",\"text\" : {\"status\" : \"generated\",\"div\" : \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">Application Start for under service login &quot;Grahame&quot; (id: Grahame's Test HL7Connect)</div>\"},\"type\" : {\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110100\",\"display\" : \"Application Activity\"},\"subtype\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110120\",\"display\" : \"Application Start\"}],\"action\" : \"E\",\"recorded\" : \"2012-10-25T22:04:27+11:00\",\"outcome\" : \"0\",\"agent\" : [{\"role\" : [{\"text\" : \"Service User (Logon)\"}],\"userId\" : {\"value\" : \"Grahame\"},\"requestor\" : false,\"network\" : {\"address\" : \"127.0.0.1\",\"type\" : \"2\"}},{\"role\" : [{\"coding\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110153\",\"display\" : \"Source Role ID\"}]}],\"userId\" : {\"value\" : \"2.16.840.1.113883.4.2|2.16.840.1.113883.4.2\"},\"altId\" : \"6580\",\"requestor\" : false,\"network\" : {\"address\" : \"Workstation1.ehr.familyclinic.com\",\"type\" : \"1\"}}],\"source\" : {\"site\" : \"Development\",\"identifier\" : {\"value\" : \"Grahame's Laptop\"},\"type\" : [{\"system\" : \"http://dicom.nema.org/resources/ontology/DCM\",\"code\" : \"110122\",\"display\" : \"Login\"}]},\"entity\" : [{\"identifier\" : {\"type\" : {\"coding\" : [{\"system\" : \"http://hl7.org/fhir/identifier-type\",\"code\" : \"SNO\"}],\"text\" : \"Dell Serial Number\"},\"value\" : \"ABCDEF\"},\"type\" : {\"system\" : \"http://hl7.org/fhir/object-type\",\"code\" : \"4\",\"display\" : \"Other\"},\"role\" : {\"system\" : \"http://hl7.org/fhir/object-role\",\"code\" : \"4\",\"display\" : \"Domain Resource\"},\"lifecycle\" : {\"system\" : \"http://hl7.org/fhir/dicom-audit-lifecycle\",\"code\" : \"6\",\"display\" : \"Access / Use\"},\"name\" : \"Grahame's Laptop\"}]}";
  private static final String PROVENANCE_SOURCE = "{\"resourceType\" : \"Provenance\",\"id\" : \"example\",\"text\" : {\"status\" : \"generated\",\"div\" : \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">procedure record authored on 27-June 2015 by Harold Hippocrates, MD Content extracted from XDS managed CDA Referral received 26-June</div>\"},\"target\" : [{\"reference\" : \"Procedure/example/_history/1\"}],\"period\" : {\"start\" : \"2015-06-27\",\"end\" : \"2015-06-28\"},\"recorded\" : \"2015-06-27T08:39:24+10:00\",\"policy\" : [\"http://acme.com/fhir/Consent/25\"],\"location\" : {\"reference\" : \"Location/1\"},\"reason\" : [{\"system\" : \"http://snomed.info/sct\",\"code\" : \"3457005\",\"display\" : \"Referral\"}],\"agent\" : [{\"role\" : [{\"coding\" : [{\"system\" : \"http://hl7.org/fhir/v3/ParticipationType\",\"code\" : \"AUT\"}]}],\"whoReference\" : {\"reference\" : \"Practitioner/xcda-author\"},\"onBehalfOfUri\" : \"#a1\",\"relatedAgentType\" : {\"text\" : \"used\"}},{\"id\" : \"a1\",\"role\" : [{\"coding\" : [{\"system\" : \"http://hl7.org/fhir/v3/ParticipationType\",\"code\" : \"DEV\"}]}],\"whoReference\" : {\"reference\" : \"Device/software\"}}],\"entity\" : [{\"role\" : \"source\",\"whatReference\" : {\"reference\" : \"DocumentReference/example\",\"display\" : \"CDA Document in XDS repository\"}}]}";
  
  @Test
  public void testAuditEvent() throws FHIRFormatError, IOException {
    org.hl7.fhir.dstu3.model.AuditEvent ae3 = (org.hl7.fhir.dstu3.model.AuditEvent) new org.hl7.fhir.dstu3.formats.JsonParser().parse(AUDIT_EVENT_SOURCE);
    org.hl7.fhir.r5.model.AuditEvent ae5 = (org.hl7.fhir.r5.model.AuditEvent) VersionConvertor_30_50.convertResource(ae3, false);
    Assertions.assertEquals(ae5.getId(), ae3.getId());
  }
  

  @Test
  public void testProvenance() throws FHIRFormatError, IOException {
    org.hl7.fhir.dstu3.model.Provenance ae3 = (org.hl7.fhir.dstu3.model.Provenance) new org.hl7.fhir.dstu3.formats.JsonParser().parse(PROVENANCE_SOURCE);
    org.hl7.fhir.r5.model.Provenance ae5 = (org.hl7.fhir.r5.model.Provenance) VersionConvertor_30_50.convertResource(ae3, false);
    Assertions.assertEquals(ae5.getId(), ae3.getId());
  }

  @ParameterizedTest(name = "Testing dstu3 -> r5 conversion of null value {0}.")
  @MethodSource("dstu3PrimitiveTypes")
  public <T extends PrimitiveType> void testNullValueDstu2Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new StringType("A value"));
    Assertions.assertNull(((org.hl7.fhir.r5.model.PrimitiveType) VersionConvertor_30_50.convertType(obj)).getValue());
  }

  @ParameterizedTest(name = "Testing r5 -> dstu3 conversion of null value {0}.")
  @MethodSource("r5PrimitiveTypes")
  public <T extends org.hl7.fhir.r5.model.PrimitiveType> void testNullValueR5Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.r5.model.StringType("A value"));
    Assertions.assertNull(((PrimitiveType) VersionConvertor_30_50.convertType(obj)).getValue());
  }

  public static Stream<Arguments> dstu3PrimitiveTypes() {
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

