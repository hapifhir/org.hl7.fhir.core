package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.factory.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.stream.Stream;

public class VersionConvertorPrimitiveTypeTests {

  private static String[] DEFAULT_DATE_PRECISION_STRINGS = {
    "1933", "1933-01", "1933-01-02"
  };

  private static String[] SECOND_DATE_PRECISION_STRINGS =
    Stream.concat(Arrays.stream(DEFAULT_DATE_PRECISION_STRINGS),Stream.of("1933-01-02T13:45:12"))
      .toArray(size -> (String[]) Array.newInstance(String.class, size));

  private static String[] MILLISECOND_DATE_PRECISION_STRINGS =
    Stream.concat(Arrays.stream(SECOND_DATE_PRECISION_STRINGS),Stream.of("1933-01-02T13:45:12.3", "1933-01-02T13:45:12.3456"))
      .toArray(size -> (String[]) Array.newInstance(String.class, size));

  private static String[] INSTANT_PRECISION_STRINGS = {
    "1933-01-02T13:45:12", "1933-01-02T13:45:12.3", "1933-01-02T13:45:12.3456"
  };
  
  private static <K,L>  Stream<Arguments> getDateTimeArgs(Class<? extends VersionConvertorFactory> versionConverterFactoryClazz, Class<K> firstTypeClazz, Class<?> firstTypeMethodClazz, Class<L> secondTypeClazz, Class<?> secondTypeMethodClazz, String[] testStrings) {

    return Arrays.stream(testStrings).map( it -> Arguments.of(versionConverterFactoryClazz,
      firstTypeClazz, firstTypeMethodClazz, it,
      secondTypeClazz, secondTypeMethodClazz, it
    ));
  }

  private static Stream<Arguments> getParams() {
      return Stream.of(
        //Date
        getDateTimeArgs(VersionConvertorFactory_10_30.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.dstu3.model.DateType.class, org.hl7.fhir.dstu3.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_40.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r4.model.DateType.class, org.hl7.fhir.r4.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_50.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r5.model.DateType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_30.class,
          org.hl7.fhir.dstu2016may.model.DateType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.dstu3.model.DateType.class, org.hl7.fhir.dstu3.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_40.class,
          org.hl7.fhir.dstu2016may.model.DateType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r4.model.DateType.class, org.hl7.fhir.r4.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_50.class,
          org.hl7.fhir.dstu2016may.model.DateType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r5.model.DateType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_40.class,
          org.hl7.fhir.dstu3.model.DateType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r4.model.DateType.class, org.hl7.fhir.r4.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_50.class,
          org.hl7.fhir.dstu3.model.DateType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r5.model.DateType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_40_50.class,
          org.hl7.fhir.r4.model.DateType.class, org.hl7.fhir.r4.model.Type.class,
          org.hl7.fhir.r5.model.DateType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),

        //Date DateTime
        getDateTimeArgs(VersionConvertorFactory_10_30.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.dstu3.model.DateTimeType.class, org.hl7.fhir.dstu3.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_40.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r4.model.DateTimeType.class, org.hl7.fhir.r4.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_50.class,
          org.hl7.fhir.dstu2.model.DateType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r5.model.DateTimeType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_30.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.dstu3.model.DateType.class, org.hl7.fhir.dstu3.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_40.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r4.model.DateType.class, org.hl7.fhir.r4.model.Type.class,
          DEFAULT_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_50.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r5.model.DateType.class, org.hl7.fhir.r5.model.DataType.class,
          DEFAULT_DATE_PRECISION_STRINGS),

        //DateTime
        getDateTimeArgs(VersionConvertorFactory_10_30.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.dstu3.model.DateTimeType.class, org.hl7.fhir.dstu3.model.Type.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_40.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r4.model.DateTimeType.class, org.hl7.fhir.r4.model.Type.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_50.class,
          org.hl7.fhir.dstu2.model.DateTimeType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r5.model.DateTimeType.class, org.hl7.fhir.r5.model.DataType.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_30.class,
          org.hl7.fhir.dstu2016may.model.DateTimeType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.dstu3.model.DateTimeType.class, org.hl7.fhir.dstu3.model.Type.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_40.class,
          org.hl7.fhir.dstu2016may.model.DateTimeType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r4.model.DateTimeType.class, org.hl7.fhir.r4.model.Type.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_50.class,
          org.hl7.fhir.dstu2016may.model.DateTimeType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r5.model.DateTimeType.class, org.hl7.fhir.r5.model.DataType.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_40.class,
          org.hl7.fhir.dstu3.model.DateTimeType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r4.model.DateTimeType.class, org.hl7.fhir.r4.model.Type.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_50.class,
          org.hl7.fhir.dstu3.model.DateTimeType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r5.model.DateTimeType.class, org.hl7.fhir.r5.model.DataType.class,
          MILLISECOND_DATE_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_40_50.class,
          org.hl7.fhir.r4.model.DateTimeType.class, org.hl7.fhir.r4.model.Type.class,
          org.hl7.fhir.r5.model.DateTimeType.class, org.hl7.fhir.r5.model.DataType.class,
          MILLISECOND_DATE_PRECISION_STRINGS),

        //Instant
        getDateTimeArgs(VersionConvertorFactory_10_30.class,
          org.hl7.fhir.dstu2.model.InstantType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.dstu3.model.InstantType.class, org.hl7.fhir.dstu3.model.Type.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_40.class,
          org.hl7.fhir.dstu2.model.InstantType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r4.model.InstantType.class, org.hl7.fhir.r4.model.Type.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_10_50.class,
          org.hl7.fhir.dstu2.model.InstantType.class, org.hl7.fhir.dstu2.model.Type.class,
          org.hl7.fhir.r5.model.InstantType.class, org.hl7.fhir.r5.model.DataType.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_30.class,
          org.hl7.fhir.dstu2016may.model.InstantType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.dstu3.model.InstantType.class, org.hl7.fhir.dstu3.model.Type.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_40.class,
          org.hl7.fhir.dstu2016may.model.InstantType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r4.model.InstantType.class, org.hl7.fhir.r4.model.Type.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_14_50.class,
          org.hl7.fhir.dstu2016may.model.InstantType.class, org.hl7.fhir.dstu2016may.model.Type.class,
          org.hl7.fhir.r5.model.InstantType.class, org.hl7.fhir.r5.model.DataType.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_40.class,
          org.hl7.fhir.dstu3.model.InstantType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r4.model.InstantType.class, org.hl7.fhir.r4.model.Type.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_30_50.class,
          org.hl7.fhir.dstu3.model.InstantType.class, org.hl7.fhir.dstu3.model.Type.class,
          org.hl7.fhir.r5.model.InstantType.class, org.hl7.fhir.r5.model.DataType.class,
          INSTANT_PRECISION_STRINGS),
        getDateTimeArgs(VersionConvertorFactory_40_50.class,
          org.hl7.fhir.r4.model.InstantType.class, org.hl7.fhir.r4.model.Type.class,
          org.hl7.fhir.r5.model.InstantType.class, org.hl7.fhir.r5.model.DataType.class,
          INSTANT_PRECISION_STRINGS)
      ).flatMap(i -> i);
  }

  @ParameterizedTest(name = "Test index: {index} ConvertorFactory={0} First Class={1} First Value={3} Second Class={4} Second Value={6}")
  @MethodSource("getParams")
  public <K, L> void testValidConversion(Class<VersionConvertorFactory> versionConverterFactoryClazz, Class<K> firstTypeClazz, Class<?> firstTypeMethodClazz, String firstString, Class<L> secondTypeClazz, Class<?> secondTypeMethodClazz, String secondString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    testValidConversion(versionConverterFactoryClazz, firstTypeClazz, firstTypeMethodClazz, firstString, secondTypeClazz, secondString);
    testValidConversion(versionConverterFactoryClazz, secondTypeClazz, secondTypeMethodClazz, secondString, firstTypeClazz, firstString);
  }

  public <K, L> void testValidConversion(Class<VersionConvertorFactory> versionConverterFactoryClazz, Class<K> srcTypeClazz, Class<?> srcTypeMethodClazz, String srcString, Class<L> tgtTypeClazz, String tgtString) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    K srcInstance = srcTypeClazz.getDeclaredConstructor().newInstance();

    Method srcSetValueAsStringMethod = srcTypeClazz.getMethod("setValueAsString", String.class);
    Method srcGetValueAsString =  srcTypeClazz.getMethod("getValueAsString");

    Method convertTypeMethod = versionConverterFactoryClazz.getMethod("convertType", srcTypeMethodClazz);

    Method tgtGetValueAsString = tgtTypeClazz.getMethod("getValueAsString");
    srcSetValueAsStringMethod.invoke(srcInstance, srcString);

    String srcValueAsString = (String) srcGetValueAsString.invoke(srcInstance);
    Assertions.assertEquals(srcString, srcValueAsString);

    L tgtInstance = (L) convertTypeMethod.invoke(null, srcInstance);

    String tgtValueAsString = (String) tgtGetValueAsString.invoke(tgtInstance);

    Assertions.assertEquals( tgtString, tgtValueAsString);
  }
}
