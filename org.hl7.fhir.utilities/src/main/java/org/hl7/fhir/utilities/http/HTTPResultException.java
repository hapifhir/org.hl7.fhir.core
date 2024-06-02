package org.hl7.fhir.utilities.http;

public class HTTPResultException extends Exception{
  public final int httpCode;

  public final String message;

  public final String url;
  public final String logPath;

  public HTTPResultException(int httpCode, String message, String url, String logPath) {
    this.httpCode = httpCode;
    this.message = message;
    this.url = url;
    this.logPath = logPath;
  }

  public String getMessage() {
    return "Invalid HTTP response "+httpCode+" from "+url+" ("+message+") (" + (
      logPath != null ? "Response in " + logPath : "No response content")
    + ")";
  }

}