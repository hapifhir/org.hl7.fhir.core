package org.hl7.fhir.utilities;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
  private static final FastDateFormat ourHumanDateFormat = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM);
  private static final FastDateFormat ourHumanDateTimeFormat = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM);


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
        return ourHumanDateTimeFormat.format(value);
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
        return ourHumanDateTimeFormat.format(theValue);
    }
  }
}