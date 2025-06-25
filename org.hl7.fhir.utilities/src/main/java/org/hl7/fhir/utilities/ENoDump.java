package org.hl7.fhir.utilities;

public class ENoDump extends Error {

  private static final long serialVersionUID = 1L;

  public ENoDump(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ENoDump(String message, Throwable cause) {
    super(message, cause);
  }

  public ENoDump(String message) {
    super(message);
  }

  public ENoDump(Throwable cause) {
    super(cause);
  }

}
