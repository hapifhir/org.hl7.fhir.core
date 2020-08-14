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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class VersionConvertorPrimitiveType30_40Test {

  @ParameterizedTest(name = "Testing dstu3 -> r4 conversion of null value {0}.")
  @MethodSource("dstu3PrimitiveTypes")
  public <T extends PrimitiveType> void testNullValueDstu2Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new StringType("A value"));
    Assertions.assertNull(((org.hl7.fhir.r4.model.PrimitiveType) VersionConvertor_30_40.convertType(obj)).getValue());
  }

  @ParameterizedTest(name = "Testing r4 -> dstu3 conversion of null value {0}.")
  @MethodSource("r4PrimitiveTypes")
  public <T extends org.hl7.fhir.r4.model.PrimitiveType> void testNullValueR4Primitive(String classname, T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.r4.model.StringType("A value"));
    Assertions.assertNull(((PrimitiveType) VersionConvertor_30_40.convertType(obj)).getValue());
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

  public static Stream<Arguments> r4PrimitiveTypes() {
    return Stream.of(
      Arguments.arguments(org.hl7.fhir.r4.model.BooleanType.class.getSimpleName(), new org.hl7.fhir.r4.model.BooleanType()),
      Arguments.arguments(org.hl7.fhir.r4.model.CodeType.class.getSimpleName(), new org.hl7.fhir.r4.model.CodeType()),
      Arguments.arguments(org.hl7.fhir.r4.model.DateType.class.getSimpleName(), new org.hl7.fhir.r4.model.DateType()),
      Arguments.arguments(org.hl7.fhir.r4.model.DateTimeType.class.getSimpleName(), new org.hl7.fhir.r4.model.DateTimeType()),
      Arguments.arguments(org.hl7.fhir.r4.model.DecimalType.class.getSimpleName(), new org.hl7.fhir.r4.model.DecimalType()),
      Arguments.arguments(org.hl7.fhir.r4.model.InstantType.class.getSimpleName(), new org.hl7.fhir.r4.model.InstantType()),
      Arguments.arguments(org.hl7.fhir.r4.model.PositiveIntType.class.getSimpleName(), new org.hl7.fhir.r4.model.PositiveIntType()),
      Arguments.arguments(org.hl7.fhir.r4.model.UnsignedIntType.class.getSimpleName(), new org.hl7.fhir.r4.model.UnsignedIntType()),
      Arguments.arguments(org.hl7.fhir.r4.model.IntegerType.class.getSimpleName(), new org.hl7.fhir.r4.model.IntegerType()),
      Arguments.arguments(org.hl7.fhir.r4.model.MarkdownType.class.getSimpleName(), new org.hl7.fhir.r4.model.MarkdownType()),
      Arguments.arguments(org.hl7.fhir.r4.model.OidType.class.getSimpleName(), new org.hl7.fhir.r4.model.OidType()),
      Arguments.arguments(org.hl7.fhir.r4.model.StringType.class.getSimpleName(), new org.hl7.fhir.r4.model.StringType()),
      Arguments.arguments(org.hl7.fhir.r4.model.TimeType.class.getSimpleName(), new org.hl7.fhir.r4.model.TimeType()),
      Arguments.arguments(org.hl7.fhir.r4.model.UuidType.class.getSimpleName(), new org.hl7.fhir.r4.model.UuidType()),
      Arguments.arguments(org.hl7.fhir.r4.model.Base64BinaryType.class.getSimpleName(), new org.hl7.fhir.r4.model.Base64BinaryType()),
      Arguments.arguments(org.hl7.fhir.r4.model.UriType.class.getSimpleName(), new org.hl7.fhir.r4.model.UriType()));
  }
}