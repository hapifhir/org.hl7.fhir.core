package org.hl7.fhir.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Getter;
import lombok.Setter;

public class SimpleHTTPClient {

  public enum AuthenticationMode {
    NONE,
    BASIC,
    TOKEN
  }

	public static class Header {
    private String name;
    private String value;
    public Header(String name, String value) {
      super();
      this.name = name;
      this.value = value;
    }
    public String getName() {
      return name;
    }
    public String getValue() {
      return value;
    }
  }

  private static final int MAX_REDIRECTS = 5;
  private static int counter = 1;

  public static class HTTPResultException extends Exception{
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

  public static class HTTPResult {
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
        String filename = Utilities.path("[tmp]", "http-log", "fhir-http-"+(++counter)+".log");
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

  private List<Header> headers = new ArrayList<>();

  @Getter @Setter
  private AuthenticationMode authenticationMode;

  @Getter @Setter
  private String username;

  @Getter @Setter
  private String password;

  @Getter @Setter
  private String token;
  
  public void addHeader(String name, String value) {
    headers.add(new Header(name, value));
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);    
  }
  
  public HTTPResult get(String url, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    
    URL u = new URL(url);
//    boolean isSSL = url.startsWith("https://");
    
    // handling redirects - setInstanceFollowRedirects(true) doesn't handle crossing http to https

    Map<String, Integer> visited = new HashMap<>();
    HttpURLConnection c = null;
    boolean done = false;

    while (!done) {
      int times = visited.compute(url, (key, count) -> count == null ? 1 : count + 1);
      if (times > MAX_REDIRECTS)
        throw new IOException("Stuck in redirect loop");

      u = new URL(url);
      c = (HttpURLConnection) u.openConnection();
      c.setRequestMethod("GET");
      if (accept != null) {
        c.setRequestProperty("Accept", accept);
      }
      setHeaders(c);
      c.setInstanceFollowRedirects(false);

      switch (c.getResponseCode()) {
      case HttpURLConnection.HTTP_MOVED_PERM:
      case HttpURLConnection.HTTP_MOVED_TEMP:
        String location = c.getHeaderField("Location");
        location = URLDecoder.decode(location, "UTF-8");
        URL base = new URL(url);               
        URL next = new URL(base, location);  // Deal with relative URLs
        url      = next.toExternalForm();
        continue;
      default:
        done = true;
      }
    }
    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(),  c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }

  private void setHeaders(HttpURLConnection c) {
    if (headers != null) {
      for (Header h : headers) {
        c.setRequestProperty(h.getName(), h.getValue());        
      }
    }
    c.setConnectTimeout(15000);
    c.setReadTimeout(15000);
    setAuthenticationHeader(c);
  }

  private void setAuthenticationHeader(HttpURLConnection c) {
    String authHeaderValue = null;
    if (authenticationMode == AuthenticationMode.TOKEN) {
      authHeaderValue = "Bearer " + new String(token);
    } else if (authenticationMode == AuthenticationMode.BASIC) {
      String auth = username+":"+password;
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      authHeaderValue = "Basic " + new String(encodedAuth);
    }

    if (authHeaderValue != null) {
      c.setRequestProperty("Authorization", authHeaderValue);
    }
  }

  public HTTPResult post(String url, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL u = new URL(url);
    HttpURLConnection c = (HttpURLConnection) u.openConnection();
    c.setDoOutput(true);
    c.setDoInput(true);
    c.setRequestMethod("POST");
    c.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      c.setRequestProperty("Accept", accept);
    }
    setHeaders(c);
    c.getOutputStream().write(content);
    c.getOutputStream().close();    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(), c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }

 
  public HTTPResult put(String url, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL u = new URL(url);
    HttpURLConnection c = (HttpURLConnection) u.openConnection();
    c.setDoOutput(true);
    c.setDoInput(true);
    c.setRequestMethod("PUT");
    c.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      c.setRequestProperty("Accept", accept);
    }
    setHeaders(c);
    c.getOutputStream().write(content);
    c.getOutputStream().close();    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(), c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }


}