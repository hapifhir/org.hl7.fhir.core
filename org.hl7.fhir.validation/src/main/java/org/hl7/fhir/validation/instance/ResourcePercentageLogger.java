package org.hl7.fhir.validation.instance;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import org.hl7.fhir.r5.elementmodel.Element;
import org.slf4j.Logger;

@SuppressWarnings("checkstyle:systemout")
public class ResourcePercentageLogger {

  private final Logger logger;
  private final int total;
  private final String fhirType;

  private static boolean loggingSuppressed;
  private volatile int last;
  // the entries of a Bundle may be validated on several threads at once (see InstanceValidator.setEntryExecutor)
  private final AtomicInteger current = new AtomicInteger();
  private final boolean log;
  @Getter
  private final String url;
  
  private static int instance;
  
  public ResourcePercentageLogger(Logger logger, int total, String fhirType, String url, boolean log) {
    this.logger = logger;
    this.total = total;
    this.fhirType = fhirType;
    instance++;
    last = 0;
    this.log = log;
    this.url = url;
    if (log && !loggingSuppressed) {
      String startString = "Validate " + fhirType + " against " + url;
      System.out.print(startString);
      this.logger.debug(startString);
    }
  }

  public void done() {
    if (log && !loggingSuppressed) {
      System.out.println("|");
      this.logger.debug("Done validating " + fhirType + " against " + url);
    }
  }

  public void seeElement(Element e) {
    if (e.getInstanceId() != instance) {
      e.setInstanceId(instance);
      int seen = current.incrementAndGet();
      int pct = total == 0 ? 0: (seen*100) / total;
      if (pct > last + 2) {
        progress(pct);
      }
    }
  }

  private synchronized void progress(int pct) {
    while (last + 2 < pct) {
      if (log) {
        System.out.print(".");
      }
      last = last + 2;
      if (last % 20 == 0) {
        if (log) {
          System.out.print(""+last);
          logger.debug(last + "% complete");
        }
      }
    }
  }

  public static boolean isLoggingSuppressed() {
    return loggingSuppressed;
  }

  public static void setLoggingSuppressed(boolean loggingSuppressed) {
    ResourcePercentageLogger.loggingSuppressed = loggingSuppressed;
  }

}
