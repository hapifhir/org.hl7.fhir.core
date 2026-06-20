package org.hl7.fhir.r5.model;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the UCUM time-unit arithmetic methods on {@link BaseDateTimeType}
 * ({@code add}/{@code subtract} with {@code long}/{@code String},
 * {@link Quantity}, and decimal values) and for {@link Quantity#isExactTime()}.
 *
 * <p>All date/time tests use {@link DateTimeType} as the concrete subclass
 * of {@link BaseDateTimeType}.</p>
 *
 * <p>The JVM default timezone is pinned to UTC for the duration of the test
 * class to avoid DST-related shifts when {@code DateUtils.addMonths} (and
 * similar) internally create a {@link java.util.Calendar} using the system
 * default timezone.</p>
 */
class BaseDateTimeTypeUcumTest {

  private static TimeZone originalTz;

  @BeforeAll
  static void pinTimezoneToUtc() {
    originalTz = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  @AfterAll
  static void restoreTimezone() {
    TimeZone.setDefault(originalTz);
  }

  // =========================================================================
  // Helper
  // =========================================================================

  private static DateTimeType utcDateTime(String fhirValue) {
    DateTimeType dt = new DateTimeType(fhirValue);
    dt.setTimeZone(TimeZone.getTimeZone("UTC"));
    return dt;
  }

  private static Quantity ucumQuantity(String value, String code) {
    return Quantity.fromUcum(value, code);
  }

  // =========================================================================
  // add(long, String) — one test per UCUM unit
  // =========================================================================

  @Nested
  class AddLongTests {

    @Test
    void addYears() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.add(3, "a");
      assertEquals("2023-06-15T10:30:00+00:00", dt.getValueAsString());
    }

    @Test
    void addMonths() {
      DateTimeType dt = utcDateTime("2020-01-31T12:00:00+00:00");
      dt.add(1, "mo");
      assertEquals("2020-02-29T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addWeeks() {
      DateTimeType dt = utcDateTime("2020-01-01T00:00:00+00:00");
      dt.add(2, "wk");
      assertEquals("2020-01-15T00:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addDays() {
      DateTimeType dt = utcDateTime("2020-12-30T08:00:00+00:00");
      dt.add(3, "d");
      assertEquals("2021-01-02T08:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addHours() {
      DateTimeType dt = utcDateTime("2020-06-15T22:00:00+00:00");
      dt.add(5, "h");
      assertEquals("2020-06-16T03:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addMinutes() {
      DateTimeType dt = utcDateTime("2020-06-15T23:50:00+00:00");
      dt.add(20, "min");
      assertEquals("2020-06-16T00:10:00+00:00", dt.getValueAsString());
    }

    @Test
    void addSeconds() {
      DateTimeType dt = utcDateTime("2020-06-15T23:59:50+00:00");
      dt.add(15, "s");
      assertEquals("2020-06-16T00:00:05+00:00", dt.getValueAsString());
    }

    @Test
    void addMilliseconds() {
      DateTimeType dt = utcDateTime("2020-06-15T12:00:00.500+00:00");
      dt.add(600, "ms");
      assertEquals("2020-06-15T12:00:01.100+00:00", dt.getValueAsString());
    }

    @Test
    void addZeroIsNoOp() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.add(0, "a");
      assertEquals("2020-06-15T10:30:00+00:00", dt.getValueAsString());
    }
  }

  // =========================================================================
  // subtract(long, String) — one test per UCUM unit
  // =========================================================================

  @Nested
  class SubtractLongTests {

    @Test
    void subtractYears() {
      DateTimeType dt = utcDateTime("2023-06-15T10:30:00+00:00");
      dt.subtract(3, "a");
      assertEquals("2020-06-15T10:30:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractMonths() {
      DateTimeType dt = utcDateTime("2020-03-31T12:00:00+00:00");
      dt.subtract(1, "mo");
      assertEquals("2020-02-29T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractWeeks() {
      DateTimeType dt = utcDateTime("2020-01-15T00:00:00+00:00");
      dt.subtract(2, "wk");
      assertEquals("2020-01-01T00:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractDays() {
      DateTimeType dt = utcDateTime("2021-01-02T08:00:00+00:00");
      dt.subtract(3, "d");
      assertEquals("2020-12-30T08:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractHours() {
      DateTimeType dt = utcDateTime("2020-06-16T03:00:00+00:00");
      dt.subtract(5, "h");
      assertEquals("2020-06-15T22:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractMinutes() {
      DateTimeType dt = utcDateTime("2020-06-16T00:10:00+00:00");
      dt.subtract(20, "min");
      assertEquals("2020-06-15T23:50:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractSeconds() {
      DateTimeType dt = utcDateTime("2020-06-16T00:00:05+00:00");
      dt.subtract(15, "s");
      assertEquals("2020-06-15T23:59:50+00:00", dt.getValueAsString());
    }

    @Test
    void subtractMilliseconds() {
      DateTimeType dt = utcDateTime("2020-06-15T12:00:01.100+00:00");
      dt.subtract(600, "ms");
      assertEquals("2020-06-15T12:00:00.500+00:00", dt.getValueAsString());
    }

    @Test
    void subtractZeroIsNoOp() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.subtract(0, "d");
      assertEquals("2020-06-15T10:30:00+00:00", dt.getValueAsString());
    }
  }

  // =========================================================================
  // Decimal values on fixed-duration units
  // =========================================================================

  @Nested
  class DecimalValueTests {

    @Test
    void addHalfHour() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("0.5", "h");
      dt.add(q);
      assertEquals("2020-06-15T10:30:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractHalfHour() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      Quantity q = ucumQuantity("0.5", "h");
      dt.subtract(q);
      assertEquals("2020-06-15T10:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addOneAndAHalfDays() {
      // 1.5 days = 36 hours
      DateTimeType dt = utcDateTime("2020-06-15T00:00:00+00:00");
      Quantity q = ucumQuantity("1.5", "d");
      dt.add(q);
      assertEquals("2020-06-16T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addDecimalMinutes() {
      // 2.5 min = 150,000 ms = 2 min 30 sec
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("2.5", "min");
      dt.add(q);
      assertEquals("2020-06-15T10:02:30+00:00", dt.getValueAsString());
    }

    @Test
    void addDecimalSeconds() {
      // 1.5 s = 1500 ms
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00.000+00:00");
      Quantity q = ucumQuantity("1.5", "s");
      dt.add(q);
      assertEquals("2020-06-15T10:00:01.500+00:00", dt.getValueAsString());
    }

    @Test
    void addDecimalWeeks() {
      // 0.5 weeks = 3.5 days = 84 hours
      DateTimeType dt = utcDateTime("2020-06-15T00:00:00+00:00");
      Quantity q = ucumQuantity("0.5", "wk");
      dt.add(q);
      assertEquals("2020-06-18T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addHalfHourRoundtrip() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("0.5", "h");
      dt.add(q);
      dt.subtract(q);
      assertEquals("2020-06-15T10:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void rejectsFractionalYear() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("1.5", "a");
      assertThrows(IllegalArgumentException.class, () -> dt.add(q));
    }

    @Test
    void rejectsFractionalMonth() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("0.5", "mo");
      assertThrows(IllegalArgumentException.class, () -> dt.add(q));
    }

    @Test
    void rejectsFractionalMillisecond() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("1.5", "ms");
      assertThrows(IllegalArgumentException.class, () -> dt.add(q));
    }

    @Test
    void rejectsSubMillisecondResult() {
      // 1.0001 seconds = 1000.1 ms — fractional ms
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("1.0001", "s");
      assertThrows(IllegalArgumentException.class, () -> dt.add(q));
    }

    @Test
    void acceptsWholeYearAsBigDecimal() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("2.0", "a");
      dt.add(q);
      assertEquals("2022-06-15T10:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void acceptsWholeMonthAsBigDecimal() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      Quantity q = ucumQuantity("3.00", "mo");
      dt.add(q);
      assertEquals("2020-09-15T10:00:00+00:00", dt.getValueAsString());
    }
  }

  // =========================================================================
  // add(Quantity) / subtract(Quantity)
  // =========================================================================

  @Nested
  class QuantityOverloadTests {

    @Test
    void addQuantityYears() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.add(ucumQuantity("3", "a"));
      assertEquals("2023-06-15T10:30:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractQuantityDays() {
      DateTimeType dt = utcDateTime("2021-01-02T08:00:00+00:00");
      dt.subtract(ucumQuantity("3", "d"));
      assertEquals("2020-12-30T08:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addQuantityWeeks() {
      DateTimeType dt = utcDateTime("2020-01-01T00:00:00+00:00");
      dt.add(ucumQuantity("2", "wk"));
      assertEquals("2020-01-15T00:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addQuantityRejectsNullQuantity() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      assertThrows(NullPointerException.class, () -> dt.add((Quantity) null));
    }

    @Test
    void addQuantityRejectsNullValue() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      Quantity q = new Quantity();
      q.setCode("d");
      assertThrows(NullPointerException.class, () -> dt.add(q));
    }

    @Test
    void addQuantityRejectsNullCode() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      Quantity q = new Quantity();
      q.setValue(new BigDecimal("5"));
      assertThrows(NullPointerException.class, () -> dt.add(q));
    }

    @Test
    void addQuantityRejectsNegativeValue() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      Quantity q = ucumQuantity("-3", "d");
      assertThrows(IllegalArgumentException.class, () -> dt.add(q));
    }

    @Test
    void subtractQuantityRejectsNegativeValue() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      Quantity q = ucumQuantity("-3", "d");
      assertThrows(IllegalArgumentException.class, () -> dt.subtract(q));
    }

    @Test
    void addQuantityMatchesAddLong() {
      DateTimeType qDt = utcDateTime("2020-06-15T10:30:00+00:00");
      DateTimeType lDt = utcDateTime("2020-06-15T10:30:00+00:00");
      qDt.add(ucumQuantity("5", "d"));
      lDt.add(5, "d");
      assertEquals(lDt.getValueAsString(), qDt.getValueAsString());
    }
  }

  // =========================================================================
  // Roundtrip: add then subtract returns to original value
  // =========================================================================

  @Nested
  class RoundtripTests {

    @ParameterizedTest(name = "unit={0}")
    @ValueSource(strings = {"a", "mo", "d", "h", "min", "s", "ms"})
    void addThenSubtractRoundtripsForAllUnits(String unit) {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00.000+00:00");
      String original = dt.getValueAsString();
      dt.add(5, unit);
      dt.subtract(5, unit);
      assertEquals(original, dt.getValueAsString());
    }

    @Test
    void addThenSubtractWeeksRoundtrips() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      String original = dt.getValueAsString();
      dt.add(3, "wk");
      dt.subtract(3, "wk");
      assertEquals(original, dt.getValueAsString());
    }

    @Test
    void decimalRoundtrip() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      String original = dt.getValueAsString();
      Quantity q = ucumQuantity("2.5", "h");
      dt.add(q);
      dt.subtract(q);
      assertEquals(original, dt.getValueAsString());
    }
  }

  // =========================================================================
  // Boundary / edge-case tests
  // =========================================================================

  @Nested
  class BoundaryTests {

    @Test
    void addMonthsAtLeapYearBoundary() {
      DateTimeType dt = utcDateTime("2020-02-29T12:00:00+00:00");
      dt.add(12, "mo");
      assertEquals("2021-02-28T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractMonthsAtLeapYearBoundary() {
      DateTimeType dt = utcDateTime("2021-02-28T12:00:00+00:00");
      dt.subtract(12, "mo");
      assertEquals("2020-02-28T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addDaysCrossesYearBoundary() {
      DateTimeType dt = utcDateTime("2020-12-31T23:00:00+00:00");
      dt.add(1, "d");
      assertEquals("2021-01-01T23:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void subtractDaysCrossesYearBoundary() {
      DateTimeType dt = utcDateTime("2021-01-01T23:00:00+00:00");
      dt.subtract(1, "d");
      assertEquals("2020-12-31T23:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addLargeWeekValue() {
      DateTimeType dt = utcDateTime("2020-01-01T00:00:00+00:00");
      dt.add(52, "wk");
      assertEquals("2020-12-30T00:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void addOneWeekEqualsSevenDays() {
      DateTimeType weekDt = utcDateTime("2020-06-01T00:00:00+00:00");
      DateTimeType dayDt = utcDateTime("2020-06-01T00:00:00+00:00");
      weekDt.add(1, "wk");
      dayDt.add(7, "d");
      assertEquals(dayDt.getValueAsString(), weekDt.getValueAsString());
    }
  }

  // =========================================================================
  // Precision preservation
  // =========================================================================

  @Nested
  class PrecisionTests {

    @Test
    void addPreservesSecondPrecision() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      assertEquals(TemporalPrecisionEnum.SECOND, dt.getPrecision());
      dt.add(1, "d");
      assertEquals(TemporalPrecisionEnum.SECOND, dt.getPrecision());
    }

    @Test
    void addPreservesMilliPrecision() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00.123+00:00");
      assertEquals(TemporalPrecisionEnum.MILLI, dt.getPrecision());
      dt.add(5, "h");
      assertEquals(TemporalPrecisionEnum.MILLI, dt.getPrecision());
    }

    @Test
    void subtractPreservesPrecision() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      TemporalPrecisionEnum original = dt.getPrecision();
      dt.subtract(2, "mo");
      assertEquals(original, dt.getPrecision());
    }
  }

  // =========================================================================
  // Validation — long/String overloads
  // =========================================================================

  @Nested
  class LongStringValidationTests {

    @Test
    void addRejectsNegativeValue() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> dt.add(-1, "d"));
      assertTrue(ex.getMessage().contains("non-negative"));
    }

    @Test
    void subtractRejectsNegativeValue() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> dt.subtract(-1, "d"));
      assertTrue(ex.getMessage().contains("non-negative"));
    }

    @Test
    void addRejectsNullUnit() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      assertThrows(NullPointerException.class, () -> dt.add(1, null));
    }

    @Test
    void subtractRejectsNullUnit() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      assertThrows(NullPointerException.class, () -> dt.subtract(1, null));
    }

    @ParameterizedTest(name = "unsupported unit: \"{0}\"")
    @ValueSource(strings = {"year", "month", "week", "day", "hour", "minute", "second",
      "millisecond", "us", "ns", "", "wks", "hrs", "Y", "M", "D", "H", "S", "kg", "m", "cm"})
    void addRejectsUnsupportedUnits(String badUnit) {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> dt.add(1, badUnit));
      assertTrue(ex.getMessage().contains("Unsupported UCUM time unit"));
    }

    @Test
    void addRejectsUnitsCaseSensitively() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      assertThrows(IllegalArgumentException.class, () -> dt.add(1, "A"));
      assertThrows(IllegalArgumentException.class, () -> dt.add(1, "Mo"));
      assertThrows(IllegalArgumentException.class, () -> dt.add(1, "MIN"));
      assertThrows(IllegalArgumentException.class, () -> dt.add(1, "Ms"));
    }
  }

  // =========================================================================
  // Parameterized: all supported units via CsvSource
  // =========================================================================

  @Nested
  class ParameterizedAddSubtractTests {

    @ParameterizedTest(name = "add {1} {0} to 2020-06-15T10:30:00Z → {2}")
    @CsvSource({
      "a,   2,  2022-06-15T10:30:00+00:00",
      "mo,  6,  2020-12-15T10:30:00+00:00",
      "wk,  1,  2020-06-22T10:30:00+00:00",
      "d,  10,  2020-06-25T10:30:00+00:00",
      "h,  24,  2020-06-16T10:30:00+00:00",
      "min, 90, 2020-06-15T12:00:00+00:00",
      "s, 3600, 2020-06-15T11:30:00+00:00",
    })
    void addParameterized(String unit, long value, String expected) {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.add(value, unit);
      assertEquals(expected, dt.getValueAsString());
    }

    @ParameterizedTest(name = "subtract {1} {0} from 2022-06-15T10:30:00Z → {2}")
    @CsvSource({
      "a,   2,  2020-06-15T10:30:00+00:00",
      "mo,  6,  2021-12-15T10:30:00+00:00",
      "wk,  1,  2022-06-08T10:30:00+00:00",
      "d,  10,  2022-06-05T10:30:00+00:00",
      "h,  24,  2022-06-14T10:30:00+00:00",
      "min, 90, 2022-06-15T09:00:00+00:00",
      "s, 3600, 2022-06-15T09:30:00+00:00",
    })
    void subtractParameterized(String unit, long value, String expected) {
      DateTimeType dt = utcDateTime("2022-06-15T10:30:00+00:00");
      dt.subtract(value, unit);
      assertEquals(expected, dt.getValueAsString());
    }
  }

  // =========================================================================
  // Existing add(int, int) still works
  // =========================================================================

  @Nested
  class ExistingAddMethodTests {

    @Test
    void originalAddIntIntStillWorks() {
      DateTimeType dt = utcDateTime("2020-06-15T10:30:00+00:00");
      dt.add(java.util.Calendar.YEAR, 1);
      assertEquals("2021-06-15T10:30:00+00:00", dt.getValueAsString());
    }

    @Test
    void ucumAddMatchesCalendarAdd() {
      DateTimeType ucumDt = utcDateTime("2020-06-15T10:30:00+00:00");
      DateTimeType calDt = utcDateTime("2020-06-15T10:30:00+00:00");
      ucumDt.add(5, "d");
      calDt.add(java.util.Calendar.DATE, 5);
      assertEquals(calDt.getValueAsString(), ucumDt.getValueAsString());
    }
  }

  // =========================================================================
  // Chained operations
  // =========================================================================

  @Nested
  class ChainedOperationTests {

    @Test
    void multipleAddsInSequence() {
      DateTimeType dt = utcDateTime("2020-01-01T00:00:00+00:00");
      dt.add(1, "a");
      dt.add(6, "mo");
      dt.add(15, "d");
      assertEquals("2021-07-16T00:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void mixedAddAndSubtract() {
      DateTimeType dt = utcDateTime("2020-06-15T12:00:00+00:00");
      dt.add(1, "a");
      dt.subtract(3, "mo");
      dt.add(2, "wk");
      assertEquals("2021-03-29T12:00:00+00:00", dt.getValueAsString());
    }

    @Test
    void mixedLongAndQuantityOps() {
      DateTimeType dt = utcDateTime("2020-06-15T10:00:00+00:00");
      dt.add(1, "a");
      dt.add(ucumQuantity("2.5", "h"));
      assertEquals("2021-06-15T12:30:00+00:00", dt.getValueAsString());
    }
  }

  // =========================================================================
  // Quantity.isExactTime()
  // =========================================================================

  @Nested
  class IsExactTimeTests {

    // --- Should return true ---

    @ParameterizedTest(name = "whole {0} is exact time")
    @ValueSource(strings = {"a", "mo", "ms"})
    void wholeValueCalendarRelativeUnitsAreExact(String unit) {
      assertTrue(ucumQuantity("5", unit).isExactTime());
    }

    @ParameterizedTest(name = "whole {0} with .0 is exact time")
    @ValueSource(strings = {"a", "mo", "ms"})
    void wholeValueWithTrailingZeroIsExact(String unit) {
      assertTrue(ucumQuantity("5.0", unit).isExactTime());
    }

    @ParameterizedTest(name = "whole {0} with .00 is exact time")
    @ValueSource(strings = {"a", "mo", "ms"})
    void wholeValueWithMultipleTrailingZerosIsExact(String unit) {
      assertTrue(ucumQuantity("3.000", unit).isExactTime());
    }

    @ParameterizedTest(name = "any value of {0} is exact time")
    @ValueSource(strings = {"wk", "d", "h", "min", "s"})
    void anyValueFixedDurationUnitsAreExact(String unit) {
      assertTrue(ucumQuantity("2.5", unit).isExactTime());
    }

    @ParameterizedTest(name = "whole value of {0} is exact time")
    @ValueSource(strings = {"wk", "d", "h", "min", "s"})
    void wholeValueFixedDurationUnitsAreExact(String unit) {
      assertTrue(ucumQuantity("7", unit).isExactTime());
    }

    @Test
    void zeroYearsIsExact() {
      assertTrue(ucumQuantity("0", "a").isExactTime());
    }

    @Test
    void negativeWholeYearsIsExact() {
      assertTrue(ucumQuantity("-2", "a").isExactTime());
    }

    @Test
    void negativeDecimalHoursIsExact() {
      assertTrue(ucumQuantity("-1.5", "h").isExactTime());
    }

    // --- Should return false ---

    @ParameterizedTest(name = "fractional {0} is not exact time")
    @ValueSource(strings = {"a", "mo", "ms"})
    void fractionalCalendarRelativeUnitsAreNotExact(String unit) {
      assertFalse(ucumQuantity("1.5", unit).isExactTime());
    }

    @Test
    void nonTimeUnitIsNotExact() {
      assertFalse(ucumQuantity("5", "kg").isExactTime());
    }

    @Test
    void emptyStringUnitIsNotExact() {
      assertFalse(ucumQuantity("5", "").isExactTime());
    }

    @Test
    void missingValueIsNotExact() {
      Quantity q = new Quantity();
      q.setCode("d");
      assertFalse(q.isExactTime());
    }

    @Test
    void missingCodeIsNotExact() {
      Quantity q = new Quantity();
      q.setValue(new BigDecimal("5"));
      assertFalse(q.isExactTime());
    }

    @Test
    void caseSensitive_AIsNotExact() {
      assertFalse(ucumQuantity("1", "A").isExactTime());
    }

    @Test
    void caseSensitive_MoIsNotExact() {
      assertFalse(ucumQuantity("1", "Mo").isExactTime());
    }

    @Test
    void caseSensitive_MINIsNotExact() {
      assertFalse(ucumQuantity("1", "MIN").isExactTime());
    }
  }
}