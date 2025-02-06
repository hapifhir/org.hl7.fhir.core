package org.hl7.fhir.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.hl7.fhir.exceptions.FHIRException;

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

  public static String lowBoundaryForDate(String value, int precision) {
    String[] res = splitTimezone(value);
    StringBuilder b = new StringBuilder(res[0]);
    if (b.length() == 4) {
      b.append("-01");
    }
    if (b.length() == 7) {
      b.append("-01");
    }
    if (b.length() == 10) {
      b.append("T00:00");
    }
    if (b.length() == 16) {
      b.append(":00");
    }
    if (b.length() == 19) {
      b.append(".000");
    }
    String tz;
    if (precision <= 10) {
      tz = "";
    } else {
      tz = Utilities.noString(res[1]) ? defLowTimezone(b.toString()) : res[1];
    }
    return applyDatePrecision(b.toString(), precision)+tz;
  }

  private static String defLowTimezone(String string) {
    return "+14:00"; // Kiribati permanent timezone since 1994 and we don't worry about before then
  }

  private static String defHighTimezone(String string) {
    return "-12:00"; // Parts of Russia, Antarctica, Baker Island and Midway Atoll
  }

  public static String lowBoundaryForTime(String value, int precision) {
    String[] res = splitTimezone(value);
    StringBuilder b = new StringBuilder(res[0]);
    if (b.length() == 2) {
      b.append(":00");
    }
    if (b.length() == 5) {
      b.append(":00");
    }
    if (b.length() == 8) {
      b.append(".000");
    }
    return applyTimePrecision(b.toString(), precision)+res[1];
  }

  public static String highBoundaryForTime(String value, int precision) {
    String[] res = splitTimezone(value);
    StringBuilder b = new StringBuilder(res[0]);
    if (b.length() == 2) {
      b.append(":59");
    }
    if (b.length() == 5) {
      b.append(":59");
    }
    if (b.length() == 8) {
      b.append(".999");
    }
    return applyTimePrecision(b.toString(), precision)+res[1];
  }

  private static Object applyDatePrecision(String v, int precision) {
    switch (precision) {
    case 4:
      return v.substring(0, 4);
    case 6:
    case 7:
      return v.substring(0, 7);
    case 8:
    case 10:
      return v.substring(0, 10);
    case 14: return v.substring(0, 17);
    case 17: return v;
    }
    throw new FHIRException("Unsupported Date precision for boundary operation: "+precision);
  }

  private static Object applyTimePrecision(String v, int precision) {
    switch (precision) {
    case 2: return v.substring(0, 3);
    case 4: return v.substring(0, 6);
    case 6: return v.substring(0, 9);
    case 9: return v;
    }
    throw new FHIRException("Unsupported Time precision for boundary operation: "+precision);
  }

  public static String highBoundaryForDate(String value, int precision) {
    String[] res = splitTimezone(value);
    StringBuilder b = new StringBuilder(res[0]);
    if (b.length() == 4) {
      b.append("-12");
    }
    if (b.length() == 7) {
      b.append("-"+ dayCount(Integer.parseInt(b.substring(0,4)), Integer.parseInt(b.substring(5,7))));
    }
    if (b.length() == 10) {
      b.append("T23:59");
    }
    if (b.length() == 16) {
      b.append(":59");
    }
    if (b.length() == 19) {
      b.append(".999");
    }
    String tz;
    if (precision <= 10) {
      tz = "";
    } else {
      tz = Utilities.noString(res[1]) ? defHighTimezone(b.toString()) : res[1];
    }
    return applyDatePrecision(b.toString(), precision)+tz;
  }

  private static String[] splitTimezone(String value) {
    String[] res = new String[2];

    if (value.contains("+")) {
      res[0] = value.substring(0, value.indexOf("+"));
      res[1] = value.substring(value.indexOf("+"));
    } else if (value.contains("-") && value.contains("T") && value.lastIndexOf("-") > value.indexOf("T")) {
      res[0] = value.substring(0, value.lastIndexOf("-"));
      res[1]  = value.substring(value.lastIndexOf("-"));
    } else if (value.contains("Z")) {
      res[0] = value.substring(0, value.indexOf("Z"));
      res[1] = value.substring(value.indexOf("Z"));
    } else {
      res[0] = value;
      res[1] = "";
    }
    return res;
  }

  public static Integer getDatePrecision(String value) {
    return splitTimezone(value)[0].replace("-", "").replace("T", "").replace(":", "").replace(".", "").length();
  }

  public static Integer getTimePrecision(String value) {
    return splitTimezone(value)[0].replace("T", "").replace(":", "").replace(".", "").length();
  }

  private static String dayCount(int y, int m) {
    switch (m) {
    case 1: return "31";
    case 2: return ((y % 4 == 0) && (y % 400 == 0 || !(y % 100 == 0))) ? "29" : "28";
    case 3: return "31";
    case 4: return "30";
    case 5: return "31";
    case 6: return "30";
    case 7: return "31";
    case 8: return "31";
    case 9: return "30";
    case 10: return "31";
    case 11: return "30";
    case 12: return "31";
    default: return "30"; // make the compiler happy
    }
  }
}