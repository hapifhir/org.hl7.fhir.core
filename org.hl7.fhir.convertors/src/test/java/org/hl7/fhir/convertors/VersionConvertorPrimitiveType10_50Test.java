package org.hl7.fhir.convertors;

import org.hl7.fhir.dstu2.model.Base64BinaryType;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.CodeType;
import org.hl7.fhir.dstu2.model.DateTimeType;
import org.hl7.fhir.dstu2.model.DateType;
import org.hl7.fhir.dstu2.model.DecimalType;
import org.hl7.fhir.dstu2.model.InstantType;
import org.hl7.fhir.dstu2.model.IntegerType;
import org.hl7.fhir.dstu2.model.MarkdownType;
import org.hl7.fhir.dstu2.model.OidType;
import org.hl7.fhir.dstu2.model.PositiveIntType;
import org.hl7.fhir.dstu2.model.PrimitiveType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu2.model.TimeType;
import org.hl7.fhir.dstu2.model.UnsignedIntType;
import org.hl7.fhir.dstu2.model.UriType;
import org.hl7.fhir.dstu2.model.UuidType;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class VersionConvertorPrimitiveType10_50Test {

  private static final String AUDIT_EVENT_SOURCE = "{\"resourceType\" : \"AuditEvent\",\"id\" : \"example\",\"text\" : {\"status\" : \"generated\",\"div\" : \"<div>Application Start for under service login &quot;Grahame&quot; (id: Grahame's Test HL7Connect)</div>\"},\"event\" : {\"type\" : {\"system\" : \"http://nema.org/dicom/dicm\",\"code\" : \"110100\",\"display\" : \"Application Activity\"},\"subtype\" : [{\"system\" : \"http://nema.org/dicom/dicm\",\"code\" : \"110120\",\"display\" : \"Application Start\"}],\"action\" : \"E\",\"dateTime\" : \"2012-10-25T22:04:27+11:00\",\"outcome\" : \"0\"},\"participant\" : [{\"role\" : [{\"text\" : \"Service User (Logon)\"}],\"userId\" : {\"value\" : \"Grahame\"},\"requestor\" : false,\"network\" : {\"address\" : \"127.0.0.1\",\"type\" : \"2\"}}],\"source\" : {\"site\" : \"Development\",\"identifier\" : {\"value\" : \"Grahame's Laptop\"},\"type\" : [{\"system\" : \"http://hl7.org/fhir/audit-event-sub-type\",\"code\" : \"1\"}]},\"object\" : [{\"identifier\" : {\"type\" : {\"coding\" : [{\"system\" : \"http://hl7.org/fhir/identifier-type\",\"code\" : \"SNO\"}],\"text\" : \"Dell Serial Number\"},\"value\" : \"ABCDEF\"},\"type\" : {\"system\" : \"http://hl7.org/fhir/object-type\",\"code\" : \"4\",\"display\" : \"Other\"},\"role\" : {\"system\" : \"http://hl7.org/fhir/object-role\",\"code\" : \"4\",\"display\" : \"DomainResource\"},\"lifecycle\" : {\"system\" : \"http://hl7.org/fhir/object-lifecycle\",\"code\" : \"6\",\"display\" : \"Access / Use\"},\"name\" : \"Grahame's Laptop\"}]}";

  @Test
  public void testAuditEvent() throws FHIRFormatError, IOException {
    org.hl7.fhir.dstu2.model.AuditEvent ae2 = (org.hl7.fhir.dstu2.model.AuditEvent) new org.hl7.fhir.dstu2.formats.JsonParser().parse(AUDIT_EVENT_SOURCE);
    org.hl7.fhir.r5.model.AuditEvent ae5 = (org.hl7.fhir.r5.model.AuditEvent) VersionConvertor_10_50.convertResource(ae2);
    Assertions.assertEquals(ae5.getId(), ae2.getId());
  }

  @ParameterizedTest(name = "Testing dstu2 -> r5 conversion of null value {0}.")
  @MethodSource("dstu2PrimitiveTypes")
  public <T extends PrimitiveType> void testNullValueDstu2Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new StringType("A value"));
    Assertions.assertNull(((org.hl7.fhir.r4.model.PrimitiveType) VersionConvertor_10_40.convertType(obj)).getValue());
  }

  @ParameterizedTest(name = "Testing r5 -> dstu2 conversion of null value {0}.")
  @MethodSource("r5PrimitiveTypes")
  public <T extends org.hl7.fhir.r5.model.PrimitiveType> void testNullValueR5Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.r5.model.StringType("A value"));
    Assertions.assertNull(((PrimitiveType) VersionConvertor_10_50.convertType(obj)).getValue());
  }

  public static Stream<Arguments> dstu2PrimitiveTypes() {
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

