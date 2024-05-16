package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.SimpleHTTPClient.HTTPResultException;

public class HTTPResult {
  private int code;
  private String contentType;
  private byte[] content;
  private String source;
  private String message;
  
  
  public HTTPResult(String source, int code, String message, String contentType, byte[] content) {
    super();
    this.source = source;
    this.code = code;
    this.contentType = contentType;
    this.content = content;
    this.message = message;
  }
  
  public int getCode() {
    return code;
  }
  public String getContentType() {
    return contentType;
  }
  public byte[] getContent() {
    return content;
  }

  public String getSource() {
    return source;
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

  public String getMessage() {
    return message;
  }

  public String getContentAsString() {
    return new String(content, StandardCharsets.UTF_8);
  }    
}