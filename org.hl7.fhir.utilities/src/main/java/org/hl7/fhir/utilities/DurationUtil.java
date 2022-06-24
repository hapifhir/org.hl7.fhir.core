package org.hl7.fhir.utilities;

import java.util.concurrent.TimeUnit;

public class DurationUtil {
  public static String presentDuration(long duration) {
    duration = duration / 1000000;
    String res = "";    // ;
    long days       = TimeUnit.MILLISECONDS.toDays(duration);
    long hours      = TimeUnit.MILLISECONDS.toHours(duration) -
        TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
    long minutes    = TimeUnit.MILLISECONDS.toMinutes(duration) -
        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
    long seconds    = TimeUnit.MILLISECONDS.toSeconds(duration) -
        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
    long millis     = TimeUnit.MILLISECONDS.toMillis(duration) -
        TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));

    if (days > 0)
      res = String.format("%dd %02d:%02d:%02d.%03d", days, hours, minutes, seconds, millis);
    else if (hours > 0)
      res = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    else //
      res = String.format("%02d:%02d.%03d", minutes, seconds, millis);
//    else
//      res = String.format("%02d.%04d", seconds, millis);
    return res;
  }
}
