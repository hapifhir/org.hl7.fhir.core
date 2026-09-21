package org.hl7.fhir.model.core;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.parser.DataFormatException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.utilities.DateTimeUtil;

import javax.annotation.Nullable;
import java.io.Serial;
import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseDateTimeType extends PrimitiveType<ZonedDateTime> {

  private static final ZoneId SYSTEM_DEFAULT_ZONE_ID = ZoneId.systemDefault();
  static final int NANOS_PER_MILLIS = 1_000_000;
  static final int NANOS_PER_SECOND = 1_000_000_000;
  private static final Map<String, ZoneId> timezoneCache = new ConcurrentHashMap<>();

  @Serial
  private static final long serialVersionUID = 1L;

  private ChronoUnit myPrecision = null;
  private boolean myTimeZoneMissing;

  @Override
  public void assignValues(Base dst, EnumSet<CopyObjectOptions> options) {
    copyValues((BaseDateTimeType) dst, options);
  }

  /**
   * precision and timezone are state on this class rather than part of the Date value - copy()
   * used to rebuild them by round-tripping the string form through the constructor
   */
  public void copyValues(BaseDateTimeType dst, EnumSet<CopyObjectOptions> options) {
    super.copyValues(dst, options);
    dst.myTimeZoneMissing = this.myTimeZoneMissing;
    dst.myPrecision = myPrecision;
  }

  /**
   * Constructor
   */
  public BaseDateTimeType() {
    // nothing
  }

  /**
   * Constructor
   *
   * @param modelContext the model context this object belongs to - all objects in a tree must share the same context
   */
  public BaseDateTimeType(IModelContext modelContext) {
    this();
    this.modelContext = modelContext;
  }

  /**
   * Constructor
   *
   * @throws IllegalArgumentException
   *            If the specified precision is not allowed for this type
   */
  public BaseDateTimeType(IModelContext modelContext, ZonedDateTime theDate, ChronoUnit thePrecision) {
    this.modelContext = modelContext;
    setValue(theDate, thePrecision);
    validatePrecisionAndThrowIllegalArgumentException();
  }

  /**
   * Constructor
   *
   * @throws IllegalArgumentException
   *            If the specified precision is not allowed for this type
   */
  public BaseDateTimeType(ZonedDateTime theDate, ChronoUnit thePrecision) {
    setValue(theDate, thePrecision);
    validatePrecisionAndThrowIllegalArgumentException();
  }

  /**
   * Constructor
   *
   * @throws IllegalArgumentException
   *            If the specified precision is not allowed for this type
   */
  public BaseDateTimeType(IModelContext modelContext, String theString) {
    this.modelContext = modelContext;
    setValueAsString(theString);
    validatePrecisionAndThrowIllegalArgumentException();
  }

  /**
   * Constructor
   *
   * @throws IllegalArgumentException
   *            If the specified precision is not allowed for this type
   */
  public BaseDateTimeType(String theString) {
    setValueAsString(theString);
    validatePrecisionAndThrowIllegalArgumentException();
  }

  private void validatePrecisionAndThrowIllegalArgumentException() {
    if (!isPrecisionAllowed(getPrecision())) {
      throw new IllegalArgumentException("Invalid date/time string (datatype " + getClass().getSimpleName() + " does not support " + getPrecision() + " precision): " + getValueAsString());
    }
  }

  /**
   * Adds the given amount to the field specified by theField. This is a legacy method,
   * consider using {@link #add(long, ChronoUnit)} instead.
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theField
   *           The field, uses constants from {@link Calendar} such as {@link Calendar#YEAR}
   * @param theValue
   *           The number to add (or subtract for a negative number)
   * @deprecated Use {@link #add(long, ChronoUnit)} instead
   */
  @Deprecated
  public void add(int theField, int theValue) {
    ChronoUnit field = switch (theField) {
      case Calendar.YEAR -> ChronoUnit.YEARS;
      case Calendar.MONTH -> ChronoUnit.MONTHS;
      case Calendar.DATE -> ChronoUnit.DAYS;
      case Calendar.HOUR -> ChronoUnit.HOURS;
      case Calendar.MINUTE -> ChronoUnit.MINUTES;
      case Calendar.SECOND -> ChronoUnit.SECONDS;
      case Calendar.MILLISECOND -> ChronoUnit.MILLIS;
      default -> throw new DataFormatException("Unknown field constant: " + theField);
    };

    add(theValue, field);
  }

  /**
   * Adds the given amount to the field specified by theField
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theField
   *           The field, uses constants from {@link Calendar} such as {@link Calendar#YEAR}
   * @param theValue
   *           The number to add (or subtract for a negative number)
   */
  public void add(long theValue, ChronoUnit theField) {
    ZonedDateTime value = getValueNotNull();
    // FIXME: ensure that we have the right level of precision
    value = value.plus(theValue, theField);
    setValue(value, getPrecision());
  }

  /**
   * Adds the given amount of time in the specified UCUM unit to this date/time value.
   *
   * <p>Supported UCUM time unit codes:</p>
   * <ul>
   *   <li><code>a</code> - year</li>
   *   <li><code>mo</code> - month</li>
   *   <li><code>wk</code> - week</li>
   *   <li><code>d</code> - day</li>
   *   <li><code>h</code> - hour</li>
   *   <li><code>min</code> - minute</li>
   *   <li><code>s</code> - second</li>
   *   <li><code>ms</code> - millisecond</li>
   * </ul>
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theValue
   *           The number of units to add (must be non-negative; use {@link #subtract(long, String)} for subtraction)
   * @param theUcumUnit
   *           The UCUM unit code for the time unit (e.g. "a", "mo", "wk", "d", "h", "min", "s", "ms")
   * @throws IllegalArgumentException
   *           If the UCUM unit code is not a recognized time unit, or if theValue is negative
   * @throws NullPointerException
   *           If theUcumUnit is null
   */
  public void add(long theValue, String theUcumUnit) {
    if (theValue < 0) {
      throw new IllegalArgumentException("Value must be non-negative, got " + theValue + ". Use subtract() for subtraction.");
    }
    Validate.notNull(theUcumUnit, "theUcumUnit must not be null");
    applyUcumDelta(BigDecimal.valueOf(theValue), theUcumUnit);
  }

  /**
   * Subtracts the given amount of time in the specified UCUM unit from this date/time value.
   *
   * <p>Supported UCUM time unit codes are the same as for {@link #add(long, String)}.</p>
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theValue
   *           The number of units to subtract (must be non-negative)
   * @param theUcumUnit
   *           The UCUM unit code for the time unit (e.g. "a", "mo", "wk", "d", "h", "min", "s", "ms")
   * @throws IllegalArgumentException
   *           If the UCUM unit code is not a recognized time unit, or if theValue is negative
   * @throws NullPointerException
   *           If theUcumUnit is null
   */
  public void subtract(long theValue, String theUcumUnit) {
    if (theValue < 0) {
      throw new IllegalArgumentException("Value must be non-negative, got " + theValue + ". Use add() for addition.");
    }
    Validate.notNull(theUcumUnit, "theUcumUnit must not be null");
    applyUcumDelta(BigDecimal.valueOf(-theValue), theUcumUnit);
  }

  /**
   * Adds the given FHIR {@link Quantity} as a time duration to this date/time value.
   *
   * <p>The Quantity's {@link Quantity#getCode() code} must be a supported UCUM time unit.
   * For calendar-relative units ({@code a}, {@code mo}) and {@code ms} the value must
   * be a whole number. For fixed-duration units ({@code wk}, {@code d}, {@code h},
   * {@code min}, {@code s}) decimal values are accepted and converted down to
   * whole milliseconds. Use {@link Quantity#isExactTime()} to check in advance.</p>
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theQuantity
   *           A FHIR Quantity whose code is a UCUM time unit and whose value is non-negative
   * @throws IllegalArgumentException
   *           If the value is negative, fractional for a calendar-relative unit, or the
   *           code is not a recognised UCUM time unit
   * @throws NullPointerException
   *           If theQuantity, its value, or its code is null
   */
  public void add(Quantity theQuantity) {
    Validate.notNull(theQuantity, "theQuantity must not be null");
    Validate.notNull(theQuantity.getValue(), "theQuantity.getValue() must not be null");
    Validate.notNull(theQuantity.getCode(), "theQuantity.getCode() must not be null");
    BigDecimal val = theQuantity.getValue();
    if (val.signum() < 0) {
      throw new IllegalArgumentException("Value must be non-negative, got " + val + ". Use subtract() for subtraction.");
    }
    applyUcumDelta(val, theQuantity.getCode());
  }

  /**
   * Subtracts the given FHIR {@link Quantity} as a time duration from this date/time value.
   *
   * <p>See {@link #add(Quantity)} for details on supported units and decimal handling.</p>
   *
   * Note: beware of the effects of daylight saving  here - the maths is subject to the timezone the code is one.
   *
   * @param theQuantity
   *           A FHIR Quantity whose code is a UCUM time unit and whose value is non-negative
   * @throws IllegalArgumentException
   *           If the value is negative, fractional for a calendar-relative unit, or the
   *           code is not a recognised UCUM time unit
   * @throws NullPointerException
   *           If theQuantity, its value, or its code is null
   */
  public void subtract(Quantity theQuantity) {
    Validate.notNull(theQuantity, "theQuantity must not be null");
    Validate.notNull(theQuantity.getValue(), "theQuantity.getValue() must not be null");
    Validate.notNull(theQuantity.getCode(), "theQuantity.getCode() must not be null");
    BigDecimal val = theQuantity.getValue();
    if (val.signum() < 0) {
      throw new IllegalArgumentException("Value must be non-negative, got " + val + ". Use add() for addition.");
    }
    applyUcumDelta(val.negate(), theQuantity.getCode());
  }

  /**
   * Internal method that applies a signed {@link BigDecimal} delta in the given
   * UCUM time unit.
   *
   * <p>For calendar-relative units ({@code a}, {@code mo}) and {@code ms}, the
   * value must be a whole number and is delegated to {@link #add(int, int)}.
   * For fixed-duration units ({@code wk}, {@code d}, {@code h}, {@code min},
   * {@code s}) the value is converted to whole milliseconds first.</p>
   */
  private void applyUcumDelta(BigDecimal theDelta, String theUcumUnit) {
    switch (theUcumUnit) {
      case "a":
      case "mo":
      case "ms":
        // Calendar-relative units and ms: must be a whole number
        long whole;
        try {
          whole = theDelta.longValueExact();
        } catch (ArithmeticException e) {
          throw new IllegalArgumentException(
            "Fractional values are not supported for unit \"" + theUcumUnit + "\": " + theDelta);
        }
        if ("a".equals(theUcumUnit)) {
          add(whole, ChronoUnit.YEARS);
        } else if ("mo".equals(theUcumUnit)) {
          add(whole, ChronoUnit.MONTHS);
        } else {
          add(whole, ChronoUnit.MILLIS);
        }
        break;
      case "wk":
      case "d":
      case "h":
      case "min":
      case "s":
        // Fixed-duration units: convert to milliseconds
        BigDecimal millis = ucumToMillis(theDelta, theUcumUnit);
        long millisLong;
        try {
          millisLong = millis.longValueExact();
        } catch (ArithmeticException e) {
          throw new IllegalArgumentException(
            "Value " + theDelta + " " + theUcumUnit
              + " converts to a fractional number of milliseconds (" + millis
              + ") which cannot be represented");
        }
        add(millisLong, ChronoUnit.MILLIS);
        break;
      default:
        throw new IllegalArgumentException("Unsupported UCUM time unit: \"" + theUcumUnit
          + "\". Supported units are: a, mo, wk, d, h, min, s, ms");
    }
  }

  /**
   * Converts a value in the given fixed-duration UCUM unit to milliseconds.
   *
   * @param theValue the numeric value
   * @param theUcumUnit one of {@code wk}, {@code d}, {@code h}, {@code min}, or {@code s}
   * @return the equivalent number of milliseconds as a {@link BigDecimal}
   */
  private static BigDecimal ucumToMillis(BigDecimal theValue, String theUcumUnit) {
    BigDecimal factor;
    switch (theUcumUnit) {
      case "wk":  factor = new BigDecimal("604800000"); break;  // 7 * 24 * 60 * 60 * 1000
      case "d":   factor = new BigDecimal("86400000");  break;  // 24 * 60 * 60 * 1000
      case "h":   factor = new BigDecimal("3600000");   break;  // 60 * 60 * 1000
      case "min": factor = new BigDecimal("60000");     break;  // 60 * 1000
      case "s":   factor = new BigDecimal("1000");      break;
      default:
        throw new IllegalArgumentException("Not a fixed-duration UCUM unit: " + theUcumUnit);
    }
    return theValue.multiply(factor);
  }

  /**
   * Returns <code>true</code> if the given object represents a date/time before <code>this</code> object
   *
   * @throws NullPointerException
   *            If <code>this.getValue()</code> or <code>theDateTimeType.getValue()</code>
   *            return <code>null</code>
   */
  public boolean after(DateTimeType theDateTimeType) {
    validateBeforeOrAfter(theDateTimeType);
    return getValue().isAfter(theDateTimeType.getValue());
  }

  /**
   * Returns <code>true</code> if the given object represents a date/time before <code>this</code> object
   *
   * @throws NullPointerException
   *            If <code>this.getValue()</code> or <code>theDateTimeType.getValue()</code>
   *            return <code>null</code>
   */
  public boolean before(DateTimeType theDateTimeType) {
    validateBeforeOrAfter(theDateTimeType);
    return getValue().isBefore(theDateTimeType.getValue());
  }

  /**
   * @param thePrecision
   * @return the String value of this instance with the specified precision.
   */
  public String getValueAsString(ChronoUnit thePrecision) {
    return encode(getValue(), thePrecision);
  }

  @Override
  protected String encode(ZonedDateTime theValue) {
    return encode(theValue, myPrecision);
  }

  @Nullable
  private String encode(ZonedDateTime theValue, ChronoUnit thePrecision) {
    if (theValue == null) {
      return null;
    } else {
      StringBuilder b = new StringBuilder();
      leftPadWithZeros(theValue.getYear(), 4, b);

      if (thePrecision.ordinal() > ChronoUnit.YEARS.ordinal()) {
        b.append('-');
        leftPadWithZeros(theValue.getMonthValue(), 2, b);
        if (thePrecision.ordinal() > ChronoUnit.MONTHS.ordinal()) {
          b.append('-');
          leftPadWithZeros(theValue.getDayOfMonth(), 2, b);
          if (thePrecision.ordinal() > ChronoUnit.DAYS.ordinal()) {
            b.append('T');
            leftPadWithZeros(theValue.getHour(), 2, b);
            b.append(':');
            leftPadWithZeros(theValue.getMinute(), 2, b);
            if (thePrecision.ordinal() > ChronoUnit.MINUTES.ordinal()) {
              b.append(':');
              leftPadWithZeros(theValue.getSecond(), 2, b);
              if (thePrecision.ordinal() > ChronoUnit.SECONDS.ordinal()) {
                b.append('.');
                leftPadWithZeros(theValue.get(ChronoField.MILLI_OF_SECOND), 3, b);
              }
            }

            if (!myTimeZoneMissing) {
              ZoneId timeZone = theValue.getZone();
              if (timeZone.getId().equals("Z")) {
                b.append('Z');
              } else {
                int offset = timeZone.getRules().getOffset(theValue.toInstant()).getTotalSeconds();
                if (offset >= 0) {
                  b.append('+');
                } else {
                  b.append('-');
                  offset = Math.abs(offset);
                }

                int hoursOffset = (int) (offset / DateUtils.MILLIS_PER_HOUR);
                leftPadWithZeros(hoursOffset, 2, b);
                b.append(':');
                int minutesOffset = (int) (offset % DateUtils.MILLIS_PER_HOUR);
                minutesOffset = (int) (minutesOffset / DateUtils.MILLIS_PER_MINUTE);
                leftPadWithZeros(minutesOffset, 2, b);
              }
            }
          }
        }
      }
      return b.toString();
    }
  }

  /**
   * Returns the month with 1-index, e.g. 1=the first day of the month
   */
  public Integer getDay() {
    return getFieldValue(Calendar.DAY_OF_MONTH);
  }

  /**
   * Returns the default precision for the given datatype
   */
  protected abstract ChronoUnit getDefaultPrecisionForDatatype();

  private Integer getFieldValue(int theField) {
    if (getValue() == null) {
      return null;
    }
    Calendar cal = getValueAsCalendar();
    return cal.get(theField);
  }

  /**
   * Returns the hour of the day in a 24h clock, e.g. 13=1pm
   */
  public Integer getHour() {
    return getFieldValue(Calendar.HOUR_OF_DAY);
  }

  /**
   * Returns the milliseconds within the current second.
   * <p>
   * Note that this method returns the
   * same value as {@link #getNanos()} but with less precision.
   * </p>
   */
  public Integer getMillis() {
    return getFieldValue(Calendar.MILLISECOND);
  }

  /**
   * Returns the minute of the hour in the range 0-59
   */
  public Integer getMinute() {
    return getFieldValue(Calendar.MINUTE);
  }

  /**
   * Returns the month with 0-index, e.g. 0=January
   */
  public Integer getMonth() {
    return getFieldValue(Calendar.MONTH);
  }

  public float getSecondsMilli() {
    int sec = getSecond();
    int milli = getMillis();
    return sec + (milli / 1000.0f);
  }

  /**
   * Returns the nanoseconds within the current second
   * <p>
   * Note that this method returns the
   * same value as {@link #getMillis()} but with more precision.
   * </p>
   */
  public Long getNanos() {
    if (getPrecision().ordinal() > ChronoUnit.MILLIS.ordinal()) {
      return null;
    }
    return getValue().getLong(ChronoField.NANO_OF_SECOND);
  }

  private int getOffsetIndex(String theValueString) {
    int plusIndex = theValueString.indexOf('+', 16);
    int minusIndex = theValueString.indexOf('-', 16);
    int zIndex = theValueString.indexOf('Z', 16);
    int retVal = Math.max(Math.max(plusIndex, minusIndex), zIndex);
    if (retVal == -1) {
      return -1;
    }
    if ((retVal - 2) != (plusIndex + minusIndex + zIndex)) {
      throwBadDateFormat(theValueString);
    }
    return retVal;
  }

  /**
   * Gets the precision for this datatype (using the default for the given type if not set)
   *
   * @see #setPrecision(ChronoUnit)
   */
  public ChronoUnit getPrecision() {
    if (myPrecision == null) {
      return getDefaultPrecisionForDatatype();
    }
    return myPrecision;
  }

  /**
   * Returns the second of the minute in the range 0-59
   */
  public Integer getSecond() {
    return getFieldValue(Calendar.SECOND);
  }

  /**
   * Returns the TimeZone associated with this datatype's value. May return <code>null</code> if no timezone was
   * supplied. This is a legacy method that returns the legacy TimeZone object, and you should
   * consider using {@link #getZoneId()} instead.
   *
   * @see #getZoneId()
   */
  public TimeZone getTimeZone() {
    ZoneId zone = getValueNotNull().getZone();
    if (zone == null) {
      return null;
    }
    return TimeZone.getTimeZone(zone);
  }

  /**
   * Returns the ZoneId associated with this datatype's value. May return <code>null</code> if no timezone was
   * supplied, or if the value has a precision that does not include a timezone (i.e. {@link ChronoUnit#YEARS},
   * {@link ChronoUnit#MONTHS}, {@link ChronoUnit#DAYS})
   */
  public ZoneId getZoneId() {
    ZonedDateTime value = getValue();
    if (value == null || getPrecision().ordinal() >= ChronoUnit.DAYS.ordinal()) {
      return null;
    }
    return value.getZone();
  }

  /**
   * Returns the value of this object as a {@link GregorianCalendar}
   */
  public GregorianCalendar getValueAsCalendar() {
    if (getValue() == null) {
      return null;
    }
    return GregorianCalendar.from(getValue());
  }

  /**
   * Returns the year, e.g. 2015
   */
  public Integer getYear() {
    return getFieldValue(Calendar.YEAR);
  }

  /**
   * To be implemented by subclasses to indicate whether the given precision is allowed by this type
   */
  abstract boolean isPrecisionAllowed(ChronoUnit thePrecision);

  /**
   * Returns true if the timezone is set to GMT-0:00 (Z)
   */
  public boolean isTimeZoneZulu() {
    ZoneId zoneId = getZoneId();
    return zoneId != null && zoneId.getId().equals("Z");
  }

  /**
   * Returns <code>true</code> if this object represents a date that is today's date
   *
   * @throws NullPointerException
   *            if {@link #getValue()} returns <code>null</code>
   */
  public boolean isToday() {
    return getValueNotNull().toLocalDate().equals(LocalDate.now());
  }

  private void leftPadWithZeros(int theInteger, int theLength, StringBuilder theTarget) {
    String string = Integer.toString(theInteger);
    for (int i = string.length(); i < theLength; i++) {
      theTarget.append('0');
    }
    theTarget.append(string);
  }

  @Override
  protected ZonedDateTime parse(String theValue) throws DataFormatException {
    String value = theValue;

    if (value.length() > 0 && (value.charAt(0) == ' ' || value.charAt(value.length() - 1) == ' ')) {
      value = value.trim();
    }

    int length = value.length();
    if (length == 0) {
      return null;
    }

    if (length < 4) {
      throwBadDateFormat(value);
    }

    ChronoUnit precision;
    int year;
    int month = 1;
    int day = 1;
    int hour = 0;
    int minute = 0;
    int second = 0;
    int nanos = 0;
    ZoneId zoneId = SYSTEM_DEFAULT_ZONE_ID;
    year = parseInt(value, value.substring(0, 4), 0, 9999);
    precision = ChronoUnit.YEARS;
    if (length > 4) {
      validateCharAtIndexIs(value, 4, '-');
      validateLengthIsAtLeast(value, 7);
      month = parseInt(value, value.substring(5, 7), 1, 12) - 1;
      precision = ChronoUnit.MONTHS;
      if (length > 7) {
        validateCharAtIndexIs(value, 7, '-');
        validateLengthIsAtLeast(value, 10);
        int actualMaximum = 31; // FIXME: can we calculate this? Do we have tests about invalid dates?
        day = parseInt(value, value.substring(8, 10), 1, actualMaximum);
        precision = ChronoUnit.DAYS;
        if (length > 10) {
          validateLengthIsAtLeast(value, 17);
          validateCharAtIndexIs(value, 10, 'T'); // yyyy-mm-ddThh:mm:ss
          int offsetIdx = getOffsetIndex(value);
          String time;
          if (offsetIdx == -1) {
            // throwBadDateFormat(theValue);
            // No offset - should this be an error?
            time = value.substring(11);
          } else {
            time = value.substring(11, offsetIdx);
            String offsetString = value.substring(offsetIdx);
            zoneId = getTimeZone(offsetString);
          }
          int timeLength = time.length();

          validateCharAtIndexIs(value, 13, ':');
          hour = parseInt(value, value.substring(11, 13), 0, 23);
          minute = parseInt(value, value.substring(14, 16), 0, 59);
          precision = ChronoUnit.MINUTES;
          if (timeLength > 5) {
            validateLengthIsAtLeast(value, 19);
            validateCharAtIndexIs(value, 16, ':'); // yyyy-mm-ddThh:mm:ss
            second = parseInt(value, value.substring(17, 19), 0, 60); // note: this allows leap seconds
            precision = ChronoUnit.SECONDS;
            if (timeLength > 8) {
              validateCharAtIndexIs(value, 19, '.'); // yyyy-mm-ddThh:mm:ss.SSSS
              validateLengthIsAtLeast(value, 20);
              int endIndex = getOffsetIndex(value);
              if (endIndex == -1) {
                endIndex = value.length();
              }

              String millisString = value.substring(20, endIndex);
              int parsedMillis = parseInt(value, millisString, 0, NANOS_PER_SECOND);
              if (millisString.length() == 1) {
                nanos = parsedMillis * 100 * NANOS_PER_MILLIS;
                precision = ChronoUnit.MILLIS;
              } else if (millisString.length() == 2) {
                nanos = parsedMillis * 10 * NANOS_PER_MILLIS;
                precision = ChronoUnit.MILLIS;
              } else if (millisString.length() == 3) {
                nanos = parsedMillis * NANOS_PER_MILLIS;
                precision = ChronoUnit.MILLIS;
              } else {
                // FIXME: add tests
                nanos = parsedMillis;
                precision = ChronoUnit.NANOS;
              }
            }
          }
        }
      }
    }

    myPrecision = precision;

    return ZonedDateTime.of(year, month, day, hour, minute, second, nanos, zoneId);
  }

  private int parseInt(String theValue, String theSubstring, int theLowerBound, int theUpperBound) {
    int retVal = 0;
    try {
      retVal = Integer.parseInt(theSubstring);
    } catch (NumberFormatException e) {
      throwBadDateFormat(theValue);
    }

    if (retVal < theLowerBound || retVal > theUpperBound) {
      throwBadDateFormat(theValue);
    }

    return retVal;
  }

  /**
   * Sets the day of the month with 1-index, e.g. 1=the first day of the month
   */
  public BaseDateTimeType setDay(int theDay) {
    setFieldValue(ChronoField.DAY_OF_MONTH, theDay, 0, 31);
    return this;
  }

  private void setFieldValue(ChronoField theField, int theValue, int theMinimum, int theMaximum) {
    validateValueInRange(theValue, theMinimum, theMaximum);

    ZonedDateTime currentValue = getValue();
    ZonedDateTime newValue = switch (theField) {
      case YEAR -> currentValue.withYear(theValue);
      case MONTH_OF_YEAR -> currentValue.withMonth(theValue);
      case DAY_OF_MONTH -> currentValue.withDayOfMonth(theValue);
      case HOUR_OF_DAY -> currentValue.withHour(theValue);
      case MINUTE_OF_HOUR -> currentValue.withMinute(theValue);
      case SECOND_OF_MINUTE -> currentValue.withSecond(theValue);
      case MILLI_OF_SECOND -> currentValue.withNano(theValue * NANOS_PER_MILLIS);
      case NANO_OF_SECOND -> currentValue.withNano(theValue);
      default -> throw new DataFormatException("Unsupported ChronoField: " + theField);
    };

    super.setValue(newValue);
  }

  /**
   * Sets the hour of the day in a 24h clock, e.g. 13=1pm
   */
  public BaseDateTimeType setHour(int theHour) {
    setFieldValue(ChronoField.HOUR_OF_DAY, theHour, 0, 23);
    return this;
  }

  /**
   * Sets the milliseconds within the current second.
   * <p>
   * Note that this method sets the
   * same value as {@link #setNanos(long)} but with less precision.
   * </p>
   */
  public BaseDateTimeType setMillis(int theMillis) {
    setFieldValue(ChronoField.MILLI_OF_SECOND, theMillis, 0, 999);
    return this;
  }

  /**
   * Sets the minute of the hour in the range 0-59
   */
  public BaseDateTimeType setMinute(int theMinute) {
    setFieldValue(ChronoField.MINUTE_OF_HOUR, theMinute, 0, 59);
    return this;
  }

  /**
   * Sets the month with 0-index, e.g. 0=January
   *
   * @deprecated This method uses 0 index, unlike {@link #setDay(int)}, and unlike the way
   * that the <code>java.time</code> API uses 1-index. It is recommended to use {@link #setMonthOfYear(int)},
   * but <b>BE CAREFUL ABOUT THE DIFFERENCE BETWEEN 0 AND 1 INDEXING</b>.
   */
  @Deprecated
  public BaseDateTimeType setMonth(int theMonth) {
    setFieldValue(ChronoField.MONTH_OF_YEAR, theMonth - 1, 0, 11);
    return this;
  }

  /**
   * Sets the month with 1-index, e.g. 1=January
   */
  @Deprecated
  public BaseDateTimeType setMonthOfYear(int theMonth) {
    setFieldValue(ChronoField.MONTH_OF_YEAR, theMonth, 0, 11);
    return this;
  }

  /**
   * Sets the nanoseconds within the current second
   * <p>
   * Note that this method sets the
   * same value as {@link #setMillis(int)} but with more precision.
   * </p>
   */
  public BaseDateTimeType setNanos(long theNanos) {
    validateValueInRange(theNanos, 0, NANOS_PER_SECOND - 1);
    setFieldValue(ChronoField.NANO_OF_SECOND, Math.toIntExact(theNanos), 0, NANOS_PER_SECOND - 1);
    return this;
  }

  /**
   * Sets the precision for this datatype
   *
   * @throws NullPointerException If the precision is null
   * @throws DataFormatException If the precision is not allowed for this datatype
   */
  public void setPrecision(ChronoUnit thePrecision) throws DataFormatException {
    if (thePrecision == null) {
      throw new NullPointerException("Precision may not be null");
    }
    if (!isPrecisionAllowed(thePrecision)) {
      throw new DataFormatException("Precision " + thePrecision + " is not allowed for this datatype");
    }
    myPrecision = thePrecision;
    updateStringValue();
  }

  /**
   * Sets the second of the minute in the range 0-59
   */
  public BaseDateTimeType setSecond(int theSecond) {
    setFieldValue(ChronoField.SECOND_OF_MINUTE, theSecond, 0, 59);
    return this;
  }

  /**
   * Sets the timezone offset for this datatype. Changing the timezone offset will update the
   * {@link #getValue() parsed value} and the {@link #getValueAsString() string value} so that
   * this instance reflects the same instant. It will preserve
   * the instant by adjusting the local time portion to an appropriate value. For
   * example, changing the timezone offset from <code>Z</code> to <code>+01:00</code> would
   * change the string value from <code>2022-01-01T00:00:00Z</code> to
   * <code>2022-01-01T01:00:00+01:00</code>.
   */
  // FIXME: add test
  public void setZoneIdSameInstant(ZoneId theTimeZone) {
    if (getValue() == null) {
      throw new DataFormatException("Can not set the Zone ID because this datatype has no value");
    }

    if (theTimeZone == null) {
      myTimeZoneMissing = true;
    } else {
      ZonedDateTime currentValue = getValue();
      ZonedDateTime newValue = currentValue.withZoneSameInstant(theTimeZone);
      setValue(newValue);

      myTimeZoneMissing = false;
    }

    updateStringValue();
  }

  /**
   * Sets the timezone offset for this datatype. Changing the timezone offset will update the
   * {@link #getValue() parsed value} and the {@link #getValueAsString() string value} to keep
   * the local time the same, meaning this instance may reflect a different instant. For
   * example, changing the timezone offset from <code>Z</code> to <code>+01:00</code> would
   * change the string value from <code>2022-01-01T00:00:00Z</code> to
   * <code>2022-01-01T00:00:00+01:00</code> (which is a real-world instant that is one hour
   * different from the previous value).
   */
  // FIXME: add test
  public void setZoneIdSameLocal(ZoneId theTimeZone) {
    if (getValue() == null) {
      throw new DataFormatException("Can not set the Zone ID because this datatype has no value");
    }

    if (theTimeZone == null) {
      myTimeZoneMissing = true;
    } else {
      ZonedDateTime currentValue = getValue();
      ZonedDateTime newValue = currentValue.withZoneSameLocal(theTimeZone);
      setValue(newValue);

      myTimeZoneMissing = false;
    }

    updateStringValue();
  }



  /**
   * Sets the timezone offset for this datatype. Changing the timezone offset will update the
   * {@link #getValue() parsed value} and the {@link #getValueAsString() string value}. For
   * example, changing the timezone offset from <code>Z</code> to <code>+01:00</code> would
   * change the string value from <code>2022-01-01T00:00:00Z</code> to
   * <code>2022-01-01T01:00:00+01:00</code>.
   *
   * @see #setZoneIdSameInstant(ZoneId) Consider using this method instead, as it uses the modern Java time API.
   * @see #setZoneIdSameLocal(ZoneId) This method uses the modern Java time API, however it is not functionally equivalent to this method.
   */
  public BaseDateTimeType setTimeZone(TimeZone theTimeZone) {
    setZoneIdSameInstant(theTimeZone != null ? theTimeZone.toZoneId() : null);
    return this;
  }

  /**
   * If <code>true</code>, sets the timezone offset for this datatype to UTC. Changing the timezone offset will update the
   * {@link #getValue() parsed value} and the {@link #getValueAsString() string value}. For
   * example, changing the timezone offset from <code>Z</code> to <code>+01:00</code> would
   * change the string value from <code>2022-01-01T01:00:00+01:00</code>
   * to <code>2022-01-01T00:00:00Z</code>.
   * <p>
   * If <code>false</code>, clears the timezone offset, which may result in an string value
   * which is not valid in FHIR if the {@link #getPrecision() precision} of this datatype
   * includes a time component.
   * </p>
   */
  public BaseDateTimeType setTimeZoneZulu(boolean theTimeZoneZulu) {
    if (theTimeZoneZulu) {
      setZoneIdSameInstant(ZoneOffset.UTC);
    } else {
      setZoneIdSameInstant(null);
    }
    return this;
  }

  /**
   * Sets the value for this type using the given Java Date object as the time, and using the default precision for
   * this datatype (unless the precision is already set), as well as the local timezone as determined by the local operating
   * system. Both of these properties may be modified in subsequent calls if neccesary.
   */
  @Override
  public BaseDateTimeType setValue(ZonedDateTime theValue) {
    setValue(theValue, getPrecision());
    return this;
  }

  /**
   * Sets the value for this type using the given Java Date object as the time, and using the specified precision, as
   * well as the local timezone as determined by the local operating system. Both of
   * these properties may be modified in subsequent calls if neccesary.
   *
   * @param theValue
   *           The date value
   * @param thePrecision
   *           The precision
   * @throws DataFormatException
   */
  public void setValue(ZonedDateTime theValue, ChronoUnit thePrecision) throws DataFormatException {
    myPrecision = thePrecision;
    super.setValue(theValue);
  }

  protected void setValueAsV3String(String theV3String) {
    if (StringUtils.isBlank(theV3String)) {
      setValue(null);
    } else {
      StringBuilder b = new StringBuilder();
      String timeZone = null;
      for (int i = 0; i < theV3String.length(); i++) {
        char nextChar = theV3String.charAt(i);
        if (nextChar == '+' || nextChar == '-' || nextChar == 'Z') {
          timeZone = (theV3String.substring(i));
          break;
        }

        // assertEquals("2013-02-02T20:13:03-05:00", DateAndTime.parseV3("20130202201303-0500").toString());
        if (i == 4 || i == 6) {
          b.append('-');
        } else if (i == 8) {
          b.append('T');
        } else if (i == 10 || i == 12) {
          b.append(':');
        }

        b.append(nextChar);
      }

      if (b.length() == 13)
        b.append(":00"); // schema rule, must have minutes
      if (b.length() == 16)
        b.append(":00"); // schema rule, must have seconds
      if (timeZone != null && b.length() > 10) {
        if (timeZone.length() == 5) {
          b.append(timeZone.substring(0, 3));
          b.append(':');
          b.append(timeZone.substring(3));
        } else {
          b.append(timeZone);
        }
      }

      setValueAsString(b.toString());
    }
  }

  /**
   * Sets the year, e.g. 2015
   */
  public BaseDateTimeType setYear(int theYear) {
    setFieldValue(ChronoField.YEAR, theYear, 0, 9999);
    return this;
  }

  private void throwBadDateFormat(String theValue) {
    throw new DataFormatException("Invalid date/time format: \"" + theValue + "\"");
  }

  private void throwBadDateFormat(String theValue, String theMesssage) {
    throw new DataFormatException("Invalid date/time format: \"" + theValue + "\": " + theMesssage);
  }

  /**
   * Returns a view of this date/time as a Calendar object. Note that the returned
   * Calendar object is entirely independent from <code>this</code> object. Changes to the
   * calendar will not affect <code>this</code>.
   */
  public Calendar toCalendar() {
    return GregorianCalendar.from(getValue());
  }

  /**
   * Returns a human readable version of this date/time using the system local format.
   * <p>
   * <b>Note on time zones:</b> This method renders the value using the time zone that is contained within the value.
   * For example, if this date object contains the value "2012-01-05T12:00:00-08:00",
   * the human display will be rendered as "12:00:00" even if the application is being executed on a system in a
   * different time zone. If this behaviour is not what you want, use
   * {@link #toHumanDisplayLocalTimezone()} instead.
   * </p>
   */
  public String toHumanDisplay() {
    return DateTimeUtil.toHumanDisplay(getPrecision(), getValue());
  }

  public String toHumanDisplay(Locale locale) {
    return DateTimeUtil.toHumanDisplay(locale, getPrecision(), getValue());
  }


  /**
   * Returns a human readable version of this date/time using the system local format, converted to the local timezone
   * if neccesary.
   *
   * @see #toHumanDisplay() for a method which does not convert the time to the local timezone before rendering it.
   */
  public String toHumanDisplayLocalTimezone() {
    return DateTimeUtil.toHumanDisplayLocalTimezone(getPrecision(), getValue());
  }

  private void validateBeforeOrAfter(DateTimeType theDateTimeType) {
    if (getValue() == null) {
      throw new NullPointerException("This BaseDateTimeType does not contain a value (getValue() returns null)");
    }
    if (theDateTimeType == null) {
      throw new NullPointerException("theDateTimeType must not be null");
    }
    if (theDateTimeType.getValue() == null) {
      throw new NullPointerException("The given BaseDateTimeType does not contain a value (theDateTimeType.getValue() returns null)");
    }
  }

  private void validateCharAtIndexIs(String theValue, int theIndex, char theChar) {
    if (theValue.charAt(theIndex) != theChar) {
      throwBadDateFormat(theValue, "Expected character '" + theChar + "' at index " + theIndex + " but found " + theValue.charAt(theIndex));
    }
  }

  private void validateLengthIsAtLeast(String theValue, int theLength) {
    if (theValue.length() < theLength) {
      throwBadDateFormat(theValue);
    }
  }

  private void validateValueInRange(long theValue, long theMinimum, long theMaximum) {
    if (theValue < theMinimum || theValue > theMaximum) {
      throw new IllegalArgumentException("Value " + theValue + " is not between allowable range: " + theMinimum + " - " + theMaximum);
    }
  }

  @Override
  public boolean isDateTime() {
    return true;
  }

  @Override
  public BaseDateTimeType dateTimeValue() {
    return this;
  }

  public boolean hasTime() {
    return myPrecision.ordinal() <= ChronoUnit.HOURS.ordinal();
  }

  /**
   * This method implements a datetime equality check using the rules as defined by FHIRPath (R2)
   *
   * Caveat: this implementation assumes local timezone for unspecified timezones
   */
  public Boolean equalsUsingFhirPathRules(BaseDateTimeType theOther) {
    if (hasTimezone() != theOther.hasTimezone()) {
      if (!couldBeTheSameTime(this, theOther)) {
        return false;
      } else {
        return null;
      }
    } else {
      BaseDateTimeType left = (BaseDateTimeType) this.copy(Base.COPY_NOTHING);
      BaseDateTimeType right = (BaseDateTimeType) theOther.copy(Base.COPY_NOTHING);
      if (left.hasTimezone() && left.getPrecision().ordinal() <= ChronoUnit.HOURS.ordinal()) {
        left.setTimeZoneZulu(true);
      }
      if (right.hasTimezone() && right.getPrecision().ordinal() <= ChronoUnit.HOURS.ordinal()) {
        right.setTimeZoneZulu(true);
      }
      Integer i = compareTimes(left, right, null);
      return i == null ? null : i == 0;
    }
  }

  private boolean couldBeTheSameTime(BaseDateTimeType theArg1, BaseDateTimeType theArg2) {
    long lowLeft = theArg1.getValue().toInstant().toEpochMilli();
    long highLeft = theArg1.getHighEdge().getValue().toInstant().toEpochMilli();
    if (!theArg1.hasTimezone()) {
      lowLeft = lowLeft - (14 * DateUtils.MILLIS_PER_HOUR);
      highLeft = highLeft + (14 * DateUtils.MILLIS_PER_HOUR);
    }
    long lowRight = theArg2.getValue().toInstant().toEpochMilli();
    long highRight = theArg2.getHighEdge().getValue().toInstant().toEpochMilli();
    if (!theArg2.hasTimezone()) {
      lowRight = lowRight - (14 * DateUtils.MILLIS_PER_HOUR);
      highRight = highRight + (14 * DateUtils.MILLIS_PER_HOUR);
    }
    if (highRight < lowLeft) {
      return false;
    }
    if (highLeft < lowRight) {
      return false;
    }
    return true;
  }

  private BaseDateTimeType getHighEdge() {
    BaseDateTimeType result = (BaseDateTimeType) copy(Base.COPY_NOTHING);
    switch (getPrecision()) {
      case DAYS, MINUTES, MONTHS, SECONDS, YEARS -> result.add(1, getPrecision());
      default -> {
      }
    }
    return result;
  }

  boolean hasTimezoneIfRequired() {
    return getPrecision().ordinal() <= ChronoUnit.DAYS.ordinal() ||
      getTimeZone() != null;
  }


  boolean hasTimezone() {
    return getTimeZone() != null;
  }

  public static Integer compareTimes(BaseDateTimeType left, BaseDateTimeType right, Integer def) {
    if (left.getYear() < right.getYear()) {
      return -1;
    } else if (left.getYear() > right.getYear()) {
      return 1;
    } else if (left.getPrecision() == ChronoUnit.YEARS && right.getPrecision() == ChronoUnit.YEARS) {
      return 0;
    } else if (left.getPrecision() == ChronoUnit.YEARS || right.getPrecision() == ChronoUnit.YEARS) {
      return def;
    }

    if (left.getMonth() < right.getMonth()) {
      return -1;
    } else if (left.getMonth() > right.getMonth()) {
      return 1;
    } else if (left.getPrecision() == ChronoUnit.MONTHS && right.getPrecision() == ChronoUnit.MONTHS) {
      return 0;
    } else if (left.getPrecision() == ChronoUnit.MONTHS || right.getPrecision() == ChronoUnit.MONTHS) {
      return def;
    }

    if (left.getDay() < right.getDay()) {
      return -1;
    } else if (left.getDay() > right.getDay()) {
      return 1;
    } else if (left.getPrecision() == ChronoUnit.DAYS && right.getPrecision() == ChronoUnit.DAYS) {
      return 0;
    } else if (left.getPrecision() == ChronoUnit.DAYS || right.getPrecision() == ChronoUnit.DAYS) {
      return def;
    }

    if (left.getHour() < right.getHour()) {
      return -1;
    } else if (left.getHour() > right.getHour()) {
      return 1;
      // hour is not a valid precision
//      } else if (dateLeft.getPrecision() == ChronoUnit.YEARS && dateRight.getPrecision() == ChronoUnit.YEARS) {
//        return 0;
//      } else if (dateLeft.getPrecision() == TemporalPrecisionEnum.HOUR || dateRight.getPrecision() == TemporalPrecisionEnum.HOUR) {
//        return null;
    }

    if (left.getMinute() < right.getMinute()) {
      return -1;
    } else if (left.getMinute() > right.getMinute()) {
      return 1;
    } else if (left.getPrecision() == ChronoUnit.MINUTES && right.getPrecision() == ChronoUnit.MINUTES) {
      return 0;
    } else if (left.getPrecision() == ChronoUnit.MINUTES || right.getPrecision() == ChronoUnit.MINUTES) {
      return def;
    }

    if (left.getSecond() < right.getSecond()) {
      return -1;
    } else if (left.getSecond() > right.getSecond()) {
      return 1;
    } else if (left.getPrecision() == ChronoUnit.SECONDS && right.getPrecision() == ChronoUnit.SECONDS) {
      return 0;
    }

    if (left.getSecondsMilli() < right.getSecondsMilli()) {
      return -1;
    } else if (left.getSecondsMilli() > right.getSecondsMilli()) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public String fpValue() {
    return "@"+primitiveValue();
  }

  private ZoneId getTimeZone(String offset) {
    if ("Z".equals(offset) || "z".equals(offset)) {
      return ZoneOffset.UTC; // This constant has an ID of "Z"
    }
    if (offset.length() != 6) {
      throw new DataFormatException("Invalid timezone offset: " + offset);
    }
    if (offset.charAt(0) != '+' && offset.charAt(0) != '-') {
      throw new DataFormatException("Invalid timezone offset: " + offset);
    }
    if (!Character.isDigit(offset.charAt(1)) || !Character.isDigit(offset.charAt(2)) || !Character.isDigit(offset.charAt(4)) || !Character.isDigit(offset.charAt(5))) {
      throw new DataFormatException("Invalid timezone offset: " + offset);
    }
    if (offset.charAt(3) != ':') {
      throw new DataFormatException("Invalid timezone offset: " + offset);
    }
    return timezoneCache.computeIfAbsent(offset, ZoneOffset::of);
  }

  @Nullable
  static ZonedDateTime toZdt(@Nullable Date theDate) {
    if (theDate == null) {
      return null;
    }
    return ZonedDateTime.from(theDate.toInstant());
  }

  @Nullable
  static ZonedDateTime toZdt(@Nullable LocalDate theDate) {
    if (theDate == null) {
      return null;
    }
    return ZonedDateTime.of(theDate, LocalTime.MIDNIGHT, ZoneId.systemDefault());
  }

  @Nullable
  static ZonedDateTime toZdt(@Nullable Calendar theCalendar) {
    if (theCalendar == null) {
      return null;
    }
    return ZonedDateTime.ofInstant(
      theCalendar.toInstant(),
      theCalendar.getTimeZone().toZoneId()
    );
  }

  @Nullable
  static ZonedDateTime toZdt(@Nullable Date theDate, TimeZone theTimeZone) {
    if (theDate == null) {
      return null;
    }
    return ZonedDateTime.from(theDate.toInstant()).withZoneSameInstant(toZoneId(theTimeZone));
  }

  static ZoneId toZoneId(TimeZone theTimeZone) {
    return ZoneId.of(theTimeZone.getID());
  }

  static ChronoUnit toChronoUnit(TemporalPrecisionEnum thePrecision) {
    return switch (thePrecision) {
      case YEAR -> ChronoUnit.YEARS;
      case MONTH -> ChronoUnit.MONTHS;
      case DAY -> ChronoUnit.DAYS;
      case MINUTE -> ChronoUnit.MINUTES;
      case SECOND -> ChronoUnit.SECONDS;
      case MILLI -> ChronoUnit.MILLIS;
    };
  }


}