package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import lombok.Getter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class HTTPResult {

  @Getter
  private final int code;
  @Getter
  private final String contentType;
  @Getter
  private final byte[] content;
  @Getter
  private final String source;
  @Getter
  private final String message;
  @Getter
  private final Iterable<HTTPHeader> headers;

  public HTTPResult(String source, int code, String message, String contentType, byte[] content) {
    this(source, code, message, contentType, content, Collections.emptyList());
  }


  public HTTPResult(String source, int code, String message, String contentType, byte[] content, Iterable<HTTPHeader> headers) {
    super();
    this.source = source;
    this.code = code;
    this.contentType = contentType;
    this.content = content;
    this.message = message;
    this.headers = headers;
  }

  public void checkThrowException() throws IOException {
    if (code >= 300) {
      String filename = Utilities.path("[tmp]", "http-log", "fhir-http-"+(SimpleHTTPClient.nextCounter())+".log");
      if (content == null || content.length == 0) {
        HTTPResultException exception = new HTTPResultException(code, message, source, null);
        throw new IOException(exception.message, exception);
      } else {
        Utilities.createDirectory(Utilities.path("[tmp]", "http-log"));
        TextFile.bytesToFile(content, filename);
        HTTPResultException exception = new HTTPResultException(code, message, source, filename);
        throw new IOException(exception.message, exception);
      }
    }      
  }

  public String getContentAsString() {
    return new String(content, StandardCharsets.UTF_8);
  }
}