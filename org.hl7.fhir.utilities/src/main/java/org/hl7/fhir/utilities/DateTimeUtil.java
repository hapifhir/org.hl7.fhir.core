package org.hl7.fhir.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class DateTimeUtil {

  public static String toHumanDisplay(TimeZone theTimeZone, TemporalPrecisionEnum thePrecision, Date theValue, String theValueAsString) {
    Calendar value = theTimeZone != null ? Calendar.getInstance(theTimeZone) : Calendar.getInstance();
    value.setTime(theValue);

    switch (thePrecision) {
      case YEAR:
      case MONTH:
      case DAY:
        return theValueAsString;
      case MILLI:
      case SECOND:
      default:
        return FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM).format(value);
    }

  }

  public static String toHumanDisplayLocalTimezone(TemporalPrecisionEnum thePrecision, Date theValue, String theValueAsString) {
    switch (thePrecision) {
      case YEAR:
      case MONTH:
      case DAY:
        return theValueAsString;
      case MILLI:
      case SECOND:
      default:
        return FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM).format(theValue);
    }
  }

  public static String toHumanDisplay(Locale locale, TimeZone theTimeZone, TemporalPrecisionEnum thePrecision, Date theValue) {
    Calendar value = theTimeZone != null ? Calendar.getInstance(theTimeZone) : Calendar.getInstance();
    value.setTime(theValue);

    FastDateFormat dateFormat = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM, locale);
    FastDateFormat dateTimeFormat = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM, locale);

    switch (thePrecision) {
      case YEAR:
      case MONTH:
      case DAY:
        return dateFormat.format(value);
      case MILLI:
      case SECOND:
      default:
        return dateTimeFormat.format(value);
    }

  }

}