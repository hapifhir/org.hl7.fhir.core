package org.hl7.fhir.convertors;

import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.CodeType;
import org.hl7.fhir.dstu2.model.DateType;
import org.hl7.fhir.dstu2.model.DateTimeType;
import org.hl7.fhir.dstu2.model.DecimalType;
import org.hl7.fhir.dstu2.model.IdType;
import org.hl7.fhir.dstu2.model.InstantType;
import org.hl7.fhir.dstu2.model.PositiveIntType;
import org.hl7.fhir.dstu2.model.UnsignedIntType;
import org.hl7.fhir.dstu2.model.IntegerType;
import org.hl7.fhir.dstu2.model.MarkdownType;
import org.hl7.fhir.dstu2.model.OidType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu2.model.TimeType;
import org.hl7.fhir.dstu2.model.UuidType;
import org.hl7.fhir.dstu2.model.PrimitiveType;
import org.hl7.fhir.dstu2.model.Base64BinaryType;
import org.hl7.fhir.dstu2.model.UriType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.Serializable;
import java.util.stream.Stream;

public class VersionConvertorPrimitiveType10_30Test {



  @Test
  @DisplayName("Test 10_30 UnsignedIntType preserves value on conversion.")
  public void testConvertUnsignedInt() {
    org.hl7.fhir.dstu3.model.UnsignedIntType output;
    output = (org.hl7.fhir.dstu3.model.UnsignedIntType)VersionConvertor_10_30.convertType(new org.hl7.fhir.dstu2.model.UnsignedIntType(33));
    Assertions.assertEquals(33, output.getValue().intValue());
  }

//  @Test
//  @DisplayName("Test 10_30 conversion has null safety for UnsignedIntType value.")
//  public void testConvertEmptyValuedUnsignedInt() {
//    org.hl7.fhir.dstu2.model.UnsignedIntType input = new org.hl7.fhir.dstu2.model.UnsignedIntType();
//    input.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.dstu2.model.StringType("A value"));
//    org.hl7.fhir.dstu3.model.UnsignedIntType output;
//    output = (org.hl7.fhir.dstu3.model.UnsignedIntType)VersionConvertor_10_30.convertType(input);
//    Assertions.assertNull(output.getValue());
//  }
//
//  @Test
//  @DisplayName("Test 10_30 conversion has null safety for UnsignedIntType value.")
//  public void testConvertEmptyValuedUnsignedInt() {
//    UnsignedIntType input = new UnsignedIntType();
//    input.addExtension().setUrl("http://example.com/AnyValue").setValue(new StringType("A value"));
//
//    Assertions.assertNull(((org.hl7.fhir.dstu3.model.PrimitiveType) VersionConvertor_10_30.convertType(input)).getValue(););
//  }

  @ParameterizedTest(name = "{0} converstion")
  @MethodSource("PrimitiveTypes")
  public <T extends PrimitiveType> void testNullValuePrimitive(T obj) {
    obj.addExtension().setUrl("http://example.com/AnyValue").setValue(new org.hl7.fhir.dstu3.model.StringType("A value"));
    Assertions.assertNull(((org.hl7.fhir.dstu3.model.PrimitiveType) VersionConvertor_10_30.convertType(obj)).getValue());
  }

  public Stream<? extends PrimitiveType> PrimitiveTypes() {
    return Stream.of(new UnsignedIntType(), new Base64BinaryType());
  }



}

