package org.hl7.fhir.model.core;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.parser.DataFormatException;
import net.sourceforge.plantuml.preproc.Sub;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test suite was copied and adapted from HAPI FHIR BaseDateTimeTypeDstu3Test
 */
@SuppressWarnings("JavadocLinkAsPlainText")
class BaseDateTimeTypeTest {
  private static final Logger ourLog = LoggerFactory.getLogger(BaseDateTimeTypeTest.class);

  // FIXME: rename
  private static final DateTimeFormatter myDateInstantParser = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  public static final ZoneId ZONE_ID_TORONTO = ZoneId.of("America/Toronto");

  /**
   * See https://github.com/hapifhir/hapi-fhir/issues/444
   */
  @Test
  public void testParseAndEncodeDateBefore1970() {
    LocalDateTime ldt = LocalDateTime.of(1960, 9, 7, 0, 44, 25, 12387401);
    ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC);
    InstantType type = new InstantType(zdt);
    String encoded = type.getValueAsString();

    ourLog.info("LDT:      {}", ldt);
    ourLog.info("Expected: {}", "1960-09-07T00:44:25.012");
    ourLog.info("Actual:   {}", encoded);

    assertEquals("1960-09-07T00:44:25.012Z", encoded);

    type = new InstantType(encoded);
    assertEquals(1960, type.getYear().intValue());
    assertEquals(8, type.getMonth().intValue()); // 0-indexed unlike LocalDateTime.of
    assertEquals(7, type.getDay().intValue());
    assertEquals(0, type.getHour().intValue());
    assertEquals(44, type.getMinute().intValue());
    assertEquals(25, type.getSecond().intValue());
    assertEquals(12, type.getMillis().intValue());
    assertEquals("UTC", type.getTimeZone().getID());
    assertEquals("Z", type.getValue().getZone().getId());
    assertEquals("Z", type.getValue().getZone().getDisplayName(TextStyle.FULL, Locale.US));

  }

  @Test
  public void setTimezoneToZulu() {
    DateTimeType dt = new DateTimeType(new Date(816411488000L));
    // assertEquals("1995-11-14T23:58:08", dt.getValueAsString());
    dt.setTimeZoneZulu(true);
    assertEquals("1995-11-15T04:58:08Z", dt.getValueAsString());
  }

  @Test
  public void testAfter() {
    assertTrue(new DateTimeType("2011-01-01T12:12:12Z").after(new DateTimeType("2011-01-01T12:12:11Z")));
    assertFalse(new DateTimeType("2011-01-01T12:12:11Z").after(new DateTimeType("2011-01-01T12:12:12Z")));
    assertFalse(new DateTimeType("2011-01-01T12:12:12Z").after(new DateTimeType("2011-01-01T12:12:12Z")));
  }

  @Test
  public void testBefore() {
    assertFalse(new DateTimeType("2011-01-01T12:12:12Z").before(new DateTimeType("2011-01-01T12:12:11Z")));
    assertTrue(new DateTimeType("2011-01-01T12:12:11Z").before(new DateTimeType("2011-01-01T12:12:12Z")));
    assertFalse(new DateTimeType("2011-01-01T12:12:12Z").before(new DateTimeType("2011-01-01T12:12:12Z")));
  }

  @Disabled
  @Test
  public void testParseMinuteShouldFail() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    try {
      dt.setValueAsString("2013-02-03T11:22");
      fail();
    } catch (DataFormatException e) {
      assertEquals(e.getMessage(), "Invalid date/time string (datatype DateTimeType does not support MINUTE precision): 2013-02-03T11:22");
    }
  }

  @Disabled
  @Test
  public void testParseMinuteZuluShouldFail() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    try {
      dt.setValueAsString("2013-02-03T11:22Z");
      fail();
    } catch (DataFormatException e) {
      assertEquals(e.getMessage(), "Invalid date/time string (datatype DateTimeType does not support MINUTE precision): 2013-02-03T11:22Z");
    }
  }

  @Test()
  public void testAfterNull() {
    try {
      assertTrue(new DateTimeType().after(new DateTimeType("2011-01-01T12:12:11Z")));
      fail();
    } catch (NullPointerException e) {
      assertEquals("This BaseDateTimeType does not contain a value (getValue() returns null)", e.getMessage());
    }
    try {
      assertTrue(new DateTimeType("2011-01-01T12:12:11Z").after(new DateTimeType()));
      fail();
    } catch (NullPointerException e) {
      assertEquals("The given BaseDateTimeType does not contain a value (theDateTimeType.getValue() returns null)", e.getMessage());
    }
    try {
      assertTrue(new DateTimeType("2011-01-01T12:12:11Z").after(null));
      fail();
    } catch (NullPointerException e) {
      assertEquals("theDateTimeType must not be null", e.getMessage());
    }
  }

  @Test()
  public void testBeforeNull1() {
    try {
      assertTrue(new DateTimeType().before(new DateTimeType("2011-01-01T12:12:11Z")));
      fail();
    } catch (NullPointerException e) {
      assertEquals("This BaseDateTimeType does not contain a value (getValue() returns null)", e.getMessage());
    }
    try {
      assertTrue(new DateTimeType("2011-01-01T12:12:11Z").before(new DateTimeType()));
      fail();
    } catch (NullPointerException e) {
      assertEquals("The given BaseDateTimeType does not contain a value (theDateTimeType.getValue() returns null)", e.getMessage());
    }
    try {
      assertTrue(new DateTimeType("2011-01-01T12:12:11Z").before(null));
      fail();
    } catch (NullPointerException e) {
      assertEquals("theDateTimeType must not be null", e.getMessage());
    }
  }

  /**
   * Test for #57
   */
  @Test
  public void testConstructorRejectsInvalidPrecision() {
    try {
      new DateType("2001-01-02T11:13:33");
      fail();
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage()).contains("precision");
    }
    try {
      new InstantType("2001-01-02");
      fail();
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage()).contains("precision");
    }
  }

  @Test
  public void testDateFormatsInvalid() {
    // No spaces in dates
    verifyFails("1974 12-25");
    verifyFails("1974-12 25");

    // No letters
    verifyFails("A974-12-25");
    verifyFails("1974-A2-25");
    verifyFails("1974-12-A5");

    // Date shouldn't have a time zone
    verifyFails("1974-12-25Z");
    verifyFails("1974-12-25+10:00");

    // Out of range
    verifyFails("2015-02-30");
    verifyFails("1974-13-25");
    verifyFails("1974-12-32");
    verifyFails("2015-02-29");
    verifyFails("-016-02-01");
    verifyFails("2016--2-01");
    verifyFails("2016-02--1");

    // Invalid length
    verifyFails("2");
    verifyFails("20");
    verifyFails("201");
    verifyFails("2016-0");
    verifyFails("2016-02-0");
  }

  @Test
  public void testDateTimeFormatsInvalid() {
    // Bad timezone
    verifyFails("1974-12-01T00:00:00A");
    verifyFails("1974-12-01T00:00:00=00:00");
    verifyFails("1974-12-01T00:00:00+", "Invalid date/time format: \"1974-12-01T00:00:00+\": Invalid timezone offset: +");
    verifyFails("1974-12-01T00:00:00+25:00");
    verifyFails("1974-12-01T00:00:00+00:61");
    verifyFails("1974-12-01T00:00:00+00 401");
    verifyFails("1974-12-01T00:00:00+0");
    verifyFails("1974-12-01T00:00:00+01");
    verifyFails("1974-12-01T00:00:00+011");
    verifyFails("1974-12-01T00:00:00+0110");

    // Out of range
    verifyFails("1974-12-25T25:00:00Z");
    verifyFails("1974-12-25T24:00:00Z");
    verifyFails("1974-12-25T23:60:00Z");
    verifyFails("1974-12-25T23:59:60Z");

    // Invalid Separators
    verifyFails("1974-12-25T23 59:00Z");
    verifyFails("1974-12-25T23:59 00Z");

    // Invalid length
    verifyFails("1974-12-25T2Z");
    verifyFails("1974-12-25T22:Z");
    verifyFails("1974-12-25T22:1Z");
    verifyFails("1974-12-25T22:11:Z");
    verifyFails("1974-12-25T22:11:1Z");
  }

  @Test
  public void testDateTimeFormatsInvalidMillis() {
    verifyFails("1974-12-01T00:00:00.AZ");
    verifyFails("1974-12-01T00:00:00.-Z");
    verifyFails("1974-12-01T00:00:00.-1Z");
    verifyFails("1974-12-01T00:00:00..1111Z");
  }

  @Test
  public void testDateTimeInLocalTimezone() {
    DateTimeType dt = DateTimeType.now();
    String str = dt.getValueAsString();
    char offset = str.charAt(19);
    if (offset != '+' && offset != '-' && offset != 'Z') {
      fail("No timezone provided: " + str);
    }
  }

  @Test
  public void testEncodeOffset() {
    String offset = InstantType.withCurrentTime().setTimeZone(TimeZone.getTimeZone("America/Toronto")).getValueAsString();
    assertThat(offset).satisfiesAnyOf(
      s -> s.endsWith("-05:00"),
      s -> s.endsWith("-04:00"));
  }

  @Test
  public void testEncodeZeroOffset() {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2011-01-01T12:00:00-04:00");
    dt.setTimeZone(TimeZone.getTimeZone("GMT-0:00"));

    String val = dt.getValueAsString();
    assertEquals("2011-01-01T16:00:00+00:00", val);
  }

  @Test
  public void testFromTime() {
    long millis;

    millis = 1466022208001L;
    String expected = "2016-06-15T20:23:28.001Z";
    validate(millis, expected);

    millis = 1466022208123L;
    expected = "2016-06-15T20:23:28.123Z";
    validate(millis, expected);

    millis = 1466022208100L;
    expected = "2016-06-15T20:23:28.100Z";
    validate(millis, expected);

    millis = 1466022208000L;
    expected = "2016-06-15T20:23:28.000Z";
    validate(millis, expected);

  }

  @ParameterizedTest
  @CsvSource(useHeadersInDisplayName = true, textBlock = """
    SubsecondInput                         , ExpectedMillis , ExpectedNanos , ExpectedPrecision
    99999999999999999999999999999999999999 , 999            , 999999999     , NANOS
    00000000000000000000000000000000000001 , 000            , 000000000     , NANOS
    27564757855254768473697463986328969635 , 275            , 275647578     , NANOS
    1                                      , 100            , 100000000     , MILLIS
    11                                     , 110            , 110000000     , MILLIS
    100                                    , 100            , 100000000     , MILLIS
    1000                                   , 100            , 100000000     , NANOS
    1100                                   , 110            , 110000000     , NANOS
    10000                                  , 100            , 100000000     , NANOS
    100000                                 , 100            , 100000000     , NANOS
    1000000                                , 100            , 100000000     , NANOS
    10000000                               , 100            , 100000000     , NANOS
    11000000                               , 110            , 110000000     , NANOS
    100000000                              , 100            , 100000000     , NANOS
    110000000                              , 110            , 110000000     , NANOS
    1000000000                             , 100            , 100000000     , NANOS
    1100000000                             , 110            , 110000000     , NANOS
    1100000000999                          , 110            , 110000000     , NANOS
    """)
  public void testGetPartials(String theSubsecondInput , int theExpectedMillis , int theExpectedNanos) {
    InstantType dt = new InstantType("2011-03-11T15:44:13." + theSubsecondInput + "-08:00");
    assertEquals(2011, dt.getYear());
    assertEquals(2, dt.getMonth());
    assertEquals(11, dt.getDay());
    assertEquals(15, dt.getHour());
    assertEquals(44, dt.getMinute());
    assertEquals(13, dt.getSecond());
    assertEquals(theExpectedMillis, dt.getMillis());
    assertEquals(theExpectedNanos, dt.getNanos());
  }

  @Test
  public void testGetValueAsCalendar() {
    assertNull(new InstantType().getValueAsCalendar());

    InstantType dt = new InstantType("2011-01-03T07:11:22.002-08:00");
    GregorianCalendar cal = dt.getValueAsCalendar();

    assertEquals(2011, cal.get(Calendar.YEAR));
    assertEquals(7, cal.get(Calendar.HOUR_OF_DAY));
    assertEquals(2, cal.get(Calendar.MILLISECOND));
    assertEquals("GMT-08:00", cal.getTimeZone().getID());
  }

  @Test
  public void testInstantInLocalTimezone() {
    InstantType dt = InstantType.withCurrentTime();
    String str = dt.getValueAsString();
    char offset = str.charAt(23);
    if (offset != '+' && offset != '-' && offset != 'Z') {
      fail("No timezone provided: " + str);
    }
  }

  @Test
  public void testLargeMilliPrecisionIsPreservedOnReEncode() {
    DateTimeType dt = new DateTimeType("2014-03-06T22:09:58.91211743846564536237+04:30");
    dt.add(1, ChronoUnit.HOURS);
    assertEquals("2014-03-06T23:09:58.91211743846564536237+04:30", dt.getValueAsString());
  }

  @Test
  public void testMinutePrecisionEncode() {
    ZonedDateTime zdt = ZonedDateTime.of(1990, 1, 3, 3, 22, 11, 0, ZoneId.of("Europe/Berlin"));

    DateTimeType date = new DateTimeType();
    date.setValue(zdt, ChronoUnit.MINUTES);
    assertEquals("1990-01-03T03:22+01:00", date.getValueAsString());

    date.setZoneIdSameInstant(ZoneId.of("America/New_York"));
    assertEquals("1990-01-02T21:22-05:00", date.getValueAsString());

    date.setTimeZoneZulu(true);
    assertEquals("1990-01-03T02:22Z", date.getValueAsString());
  }

  @Test
  public void testNewInstance() throws InterruptedException {
    InstantType now = InstantType.withCurrentTime();
    Thread.sleep(100);
    InstantType then = InstantType.withCurrentTime();
    assertTrue(now.getValue().isBefore(then.getValue()));
  }

  @Test
  public void testParseDate() {
    new DateType("2012-03-31");
  }

  @Test
  public void testParseDay() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013-02-03");

    assertEquals("2013-02-03", myDateInstantParser.format(dt.getValue()).substring(0, 10));
    assertEquals("2013-02-03", dt.getValueAsString());
    assertFalse(dt.isTimeZoneZulu());
    assertNull(dt.getTimeZone());
    assertEquals(ChronoUnit.DAYS, dt.getPrecision());
  }

  /**
   * See #381
   */
  @Test
  public void testParseFailsForInvalidDate() {
    try {
      DateTimeType dt = new DateTimeType("9999-13-01");
      fail(dt.getValue().toString());
    } catch (DataFormatException e) {
      // good
    }

  }

  @Test
  public void testParseHandlesMillis() {
    InstantType dt = new InstantType();
    dt.setValueAsString("2015-06-22T15:44:32.831-04:00");
    ZonedDateTime date = dt.getValue();

    InstantType dt2 = new InstantType();
    dt2.setValue(date);
    dt2.setTimeZoneZulu(true);
    String string = dt2.getValueAsString();

    assertEquals("2015-06-22T19:44:32.831Z", string);
  }

  @Test
  public void testParseHandlesMillisPartial() {
    // .12 should be 120ms
    validateMillisPartial("2015-06-22T00:00:00.1Z", 100);
    validateMillisPartial("2015-06-22T00:00:00.12Z", 120);
    validateMillisPartial("2015-06-22T00:00:00.123Z", 123);
    validateMillisPartial("2015-06-22T00:00:00.1234Z", 123);
    validateMillisPartial("2015-06-22T00:00:00.01Z", 10);
    validateMillisPartial("2015-06-22T00:00:00.012Z", 12);
    validateMillisPartial("2015-06-22T00:00:00.0123Z", 12);
    validateMillisPartial("2015-06-22T00:00:00.001Z", 1);
    validateMillisPartial("2015-06-22T00:00:00.0012Z", 1);
    validateMillisPartial("2015-06-22T00:00:00.00123Z", 1);
  }

  /*
   * Just to be lenient
   */
  @Test
  public void testParseIgnoresLeadingAndTrailingSpace() {
    DateTimeType dt = new DateTimeType("  2014-10-11T12:11:00Z      ");
    assertEquals("2014-10-11T12:11:00.000+0000", dt.getValue().format(myDateInstantParser));
    assertEquals("  2014-10-11T12:11:00Z      ", dt.getValueAsString());
  }

  @Test
  public void testParseInvalid() {
    verifyFails("1974-12-25+10:00", "Invalid date/time format: \"1974-12-25+10:00\": Expected character 'T' at index 10 but found +");
    verifyFails("1974-12-25Z", "Invalid date/time format: \"1974-12-25Z\"");
  }

  @Test
  public void testParseInvalidZoneOffset() {
    try {
      new DateTimeType("2010-01-01T00:00:00.1234-09:00Z");
      fail();
    } catch (DataFormatException e) {
      assertEquals("Invalid date/time format: \"2010-01-01T00:00:00.1234-09:00Z\"", e.getMessage());
    }
  }

  @Test
  public void testParseMalformatted() throws DataFormatException {
    try {
      new DateTimeType("20120102");
      fail();
    } catch (DataFormatException e) {
      assertEquals("Invalid date/time format: \"20120102\": Expected character '-' at index 4 but found 0", e.getMessage());
    }
  }

  @Test
  public void testParseMilli() throws DataFormatException {
    InstantType dt = new InstantType();
    dt.setValueAsString("2013-02-03T11:22:33.234");

    assertEquals("2013-02-03T11:22:33.234", myDateInstantParser.format(dt.getValue()).substring(0, 23));
    assertEquals("2013-02-03T11:22:33.234", dt.getValueAsString());
    assertEquals(false, dt.isTimeZoneZulu());
    assertNull(dt.getTimeZone());
    assertEquals(ChronoUnit.MILLIS, dt.getPrecision());
  }

  @Test
  public void testParseMilliZone() throws DataFormatException {
    InstantType dt = new InstantType();
    dt.setValueAsString("2013-02-03T11:22:33.234-02:00");

    assertEquals("2013-02-03T11:22:33.234-0200", dt.getValue().format(myDateInstantParser));
    assertEquals("2013-02-03T11:22:33.234-02:00", dt.getValueAsString());
    assertFalse(dt.isTimeZoneZulu());
    assertEquals(TimeZone.getTimeZone("GMT-02:00"), dt.getTimeZone());
    assertEquals(ChronoUnit.MILLIS, dt.getPrecision());
  }

  @Test
  public void testParseMilliZulu() throws DataFormatException {
    InstantType dt = new InstantType();
    dt.setValueAsString("2013-02-03T11:22:33.234Z");

    assertEquals("2013-02-03T11:22:33.234+0000", dt.getValue().format(myDateInstantParser));
    assertEquals("2013-02-03T11:22:33.234Z", dt.getValueAsString());
    assertTrue(dt.isTimeZoneZulu());
    assertEquals("UTC", dt.getTimeZone().getID());
    assertEquals(ChronoUnit.MILLIS, dt.getPrecision());
  }

  @Test
  public void testParseMonth() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013-02");

    ourLog.info("Date: {}", dt.getValue());
    assertEquals("2013-02", dt.getValueAsString());
    assertFalse(dt.isTimeZoneZulu());
    assertNull(dt.getTimeZone());
    assertEquals(ChronoUnit.MONTHS, dt.getPrecision());

    assertEquals("2013-02", myDateInstantParser.format(dt.getValue()).substring(0, 7));
  }

  @Test
  public void testParseMonthNoDashes() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    try {
      dt.setValueAsString("201302");
      fail();
    } catch (DataFormatException e) {
      assertEquals("Invalid date/time format: \"201302\": Expected character '-' at index 4 but found 0", e.getMessage());
    }
  }

  @Test
  public void testParseMinute() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    try {
      dt.setValueAsString("2013-02-03T11:22");
    } catch (DataFormatException e) {
      assertEquals("Invalid date/time string (datatype DateTimeType does not support MINUTE precision): 2013-02-03T11:22", e.getMessage());
    }
  }

  @Test
  public void testParseMinuteZulu() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    try {
      dt.setValueAsString("2013-02-03T11:22Z");
    } catch (Exception e) {
      assertEquals("Invalid date/time string (datatype DateTimeType does not support MINUTE precision): 2013-02-03T11:22Z", e.getMessage());
    }
  }

  @Test
  public void testParseSecond_NoTimeZoneSpecified() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013-02-03T11:22:33");

    assertEquals("2013-02-03T11:22:33.000+0000", myDateInstantParser.format(dt.getValue().withZoneSameLocal(ZoneOffset.UTC)));
    assertEquals("2013-02-03T11:22:33", dt.getValueAsString());
    assertEquals(2013, dt.getYear());
    assertEquals(1, dt.getMonth());
    assertEquals(3, dt.getDay());
    assertEquals(11, dt.getHour());
    assertEquals(22, dt.getMinute());
    assertEquals(33, dt.getSecond());
    assertEquals(0, dt.getMillis());
    assertNull(dt.getTimeZone());
    assertNull(dt.getZoneId());
    assertFalse(dt.isTimeZoneZulu());
    assertEquals(ChronoUnit.SECONDS, dt.getPrecision());
  }

  @Test
  public void testParseSecond_Zulu() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013-02-03T11:22:33Z");

    assertEquals("2013-02-03T11:22:33Z", dt.getValueAsString());
    assertTrue(dt.isTimeZoneZulu());
    assertEquals("Z", dt.getZoneId().getId());
    assertEquals(ChronoUnit.SECONDS, dt.getPrecision());
  }

  @Test
  public void testParseSecondZone() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013-02-03T11:22:33-02:00");

    assertEquals("2013-02-03T11:22:33-02:00", dt.getValueAsString());
    assertFalse(dt.isTimeZoneZulu());
    assertEquals("-02:00", dt.getZoneId().getId());
    assertEquals(ChronoUnit.SECONDS, dt.getPrecision());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly0millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00-09:00");

    assertEquals("2010-01-01T00:00:00-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.000-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());
    assertEquals("-09:00", dt.getZoneId().getId());
    assertEquals(-32400L, dt.getZoneId().getRules().getOffset(dt.getValue().toInstant()).getTotalSeconds());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00Z", dt.getValueAsString());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly1millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00.1-09:00");

    assertEquals("2010-01-01T00:00:00.1-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.100-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00.100Z", dt.getValueAsString());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly2millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00.12-09:00");

    assertEquals("2010-01-01T00:00:00.12-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.120-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00.120Z", dt.getValueAsString());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly3millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00.123-09:00");

    assertEquals("2010-01-01T00:00:00.123-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.123-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00.123Z", dt.getValueAsString());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly4millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00.1234-09:00");

    assertEquals("2010-01-01T00:00:00.1234-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.123-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00.123400000Z", dt.getValueAsString());
  }

  @Test
  public void testParseTimeZoneOffsetCorrectly5millis() {
    DateTimeType dt = new DateTimeType("2010-01-01T00:00:00.12345-09:00");

    assertEquals("2010-01-01T00:00:00.12345-09:00", dt.getValueAsString());
    assertEquals("2010-01-01T00:00:00.123-0900", myDateInstantParser.format(dt.getValue()));
    assertEquals("GMT-09:00", dt.getTimeZone().getID());
    assertEquals(-32400000L, dt.getTimeZone().getRawOffset());

    dt.setTimeZoneZulu(true);
    assertEquals("2010-01-01T09:00:00.123450000Z", dt.getValueAsString());
  }

  @Test
  public void testParseYear() throws DataFormatException {
    DateTimeType dt = new DateTimeType();
    dt.setValueAsString("2013");

    assertEquals("2013", myDateInstantParser.format(dt.getValue()).substring(0, 4));
    assertEquals("2013", dt.getValueAsString());
    assertEquals(2013, dt.getYear());
    assertFalse(dt.isTimeZoneZulu());
    assertNull(dt.getTimeZone());
    assertEquals(ChronoUnit.YEARS, dt.getPrecision());
  }

  /**
   * See HAPI #101 - https://github.com/hapifhir/hapi-fhir/issues/101
   */
  @Test
  public void testPrecisionRespectedForSetValue() {
    DateType dateType = new DateType();
    dateType.setValue(ZonedDateTime.parse("2012-01-02T22:31:02.333-0400", myDateInstantParser));
    assertEquals("2012-01-02", dateType.getValueAsString());
  }


  /**
   * See HAPI #101 - https://github.com/hapifhir/hapi-fhir/issues/101
   */
  @Test
  public void testPrecisionRespectedForSetValueWithPrecision() {
    DateType date = new DateType();
    date.setValue(ZonedDateTime.parse("2012-01-02T22:31:02.333-0400", myDateInstantParser), ChronoUnit.DAYS);
    assertEquals("2012-01-02", date.getValueAsString());

    date = new DateType();
    date.setValue(ZonedDateTime.parse("2012-01-02T22:31:02.333-0400", myDateInstantParser), ChronoUnit.MONTHS);
    assertEquals("2012-01", date.getValueAsString());

    date = new DateType();
    date.setValue(ZonedDateTime.parse("2012-01-02T22:31:02.333-0400", myDateInstantParser), ChronoUnit.YEARS);
    assertEquals("2012", date.getValueAsString());
  }

  @Test
  public void testSetPartialsDayFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setDay(15);
    assertEquals(15, dt.getDay().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-15T15:44:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsHourFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setHour(23);
    assertEquals(23, dt.getHour().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-11T23:44:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsInvalid() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setNanos(0);
    dt.setNanos(BaseDateTimeType.NANOS_PER_SECOND - 1);
    try {
      dt.setNanos(BaseDateTimeType.NANOS_PER_SECOND);
    } catch (IllegalArgumentException e) {
      assertEquals("Value 1000000000 is not between allowable range: 0 - 999999999", e.getMessage());
    }
  }

  @Test
  public void testSetPartialsMillisFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setMillis(12);
    assertEquals(12, dt.getMillis().intValue());
    assertEquals(12 * BaseDateTimeType.NANOS_PER_MILLIS, dt.getNanos().longValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-11T15:44:13.012-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsMinuteFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setMinute(54);
    assertEquals(54, dt.getMinute().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-11T15:54:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testSetPartialsMonthFromExisting_Legacy() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setMonth(3);
    assertEquals(3, dt.getMonth().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-04-11T15:44:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsMonthFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setMonthOfYear(4);
    assertEquals(4, dt.getMonthOfYear());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-04-11T15:44:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsNanosFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setNanos(12345678);
    assertEquals(12345678, dt.getNanos());
    assertEquals(12, dt.getMillis());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-11T15:44:13.012345678-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsSecondFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setSecond(1);
    assertEquals(1, dt.getSecond().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2011-03-11T15:44:01.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetPartialsYearFromExisting() {
    InstantType dt = new InstantType("2011-03-11T15:44:13.27564757855254768473697463986328969635-08:00");
    dt.setYear(2016);
    assertEquals(2016, dt.getYear().intValue());
    String valueAsString = dt.getValueAsString();
    ourLog.info(valueAsString);
    assertEquals("2016-03-11T15:44:13.27564757855254768473697463986328969635-08:00", valueAsString);
  }

  @Test
  public void testSetValueByZonedDateTime() {
    ZonedDateTime zdt = ZonedDateTime.parse("2014-06-20T20:22:09Z");

    DateTimeType dateTimeType = new DateTimeType();
    dateTimeType.setValue(zdt);

    assertEquals("2014-06-20T20:22:09Z", dateTimeType.getValueAsString());
  }


  @Test
  public void testSetValueByString() {
    InstantType i = new InstantType();
    i.setValueAsString("2014-06-20T20:22:09Z");

    assertNotNull(i.getValue());
    assertNotNull(i.getValueAsString());

    assertEquals(1403295729000L, i.getValue().toInstant().toEpochMilli());
    assertEquals("2014-06-20T20:22:09Z", i.getValueAsString());
  }

  @Test
  public void testToHumanDisplay() {
    DateTimeType dt = new DateTimeType("2012-01-05T12:00:00-08:00");
    String human = dt.toHumanDisplay();
    ourLog.info(human);
    assertThat(human).contains("2012");
    assertThat(human).contains("12");
  }

  private void validate(long millis, String expected) {
    InstantType dt;
    dt = new InstantType(new Date(millis));
    dt.setTimeZoneZulu(true);
    assertEquals(expected, dt.getValueAsString());

    assertEquals(millis % 1000, dt.getMillis().longValue());
    assertEquals((millis % 1000) * BaseDateTimeType.NANOS_PER_MILLIS, dt.getNanos().longValue());

    dt = new InstantType();
    dt.setValue(ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("Z")));
    assertEquals(expected, dt.getValueAsString());
  }

  private void validateMillisPartial(String input, int expected) {
    InstantType dt = new InstantType();
    dt.setValueAsString(input);
    ZonedDateTime date = dt.getValue();

    assertEquals(expected, date.toInstant().toEpochMilli() % 1000);
  }

  private static void verifyFails(String input) {
    String expectedMessage = "Invalid date/time format: \"" + input + "\"";
    verifyFails(input, expectedMessage);
  }

  private static void verifyFails(String input, String expectedMessage) {
    try {
      DateTimeType dt = new DateTimeType();
      dt.setValueAsString(input);
      fail();
    } catch (DataFormatException e) {
      assertThat(e.getMessage()).startsWith(expectedMessage);
    }
  }


}