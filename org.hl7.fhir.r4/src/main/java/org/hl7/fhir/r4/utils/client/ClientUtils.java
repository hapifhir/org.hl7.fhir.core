package org.hl7.fhir.r4.utils.client;





/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.hl7.fhir.r4.formats.IParser;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.utils.ResourceUtilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

/**
 * Helper class handling lower level HTTP transport concerns.
 * TODO Document methods.
 * @author Claude Nanjo
 */
public class ClientUtils {

  public static final String DEFAULT_CHARSET = "UTF-8";
  public static final String HEADER_LOCATION = "location";
  private static boolean debugging = false;
  public static final int TIMEOUT_SOCKET = 5000;
  public static final int TIMEOUT_CONNECT = 1000;

  private HttpHost proxy;
  private int timeout = TIMEOUT_SOCKET;
  private String username;
  private String password;
  private String accessToken;
  private ToolingClientLogger logger;
  private int retryCount;
  private HttpClient httpclient;

  public HttpHost getProxy() {
    return proxy;
  }

  public void setProxy(HttpHost proxy) {
    this.proxy = proxy;
  }

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri, String resourceFormat, String message, int timeout) {
    HttpOptions options = new HttpOptions(optionsUri);
    return issueResourceRequest(resourceFormat, options, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri, String resourceFormat, String message, int timeout) {
    HttpGet httpget = new HttpGet(resourceUri);
    return issueResourceRequest(resourceFormat, httpget, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat, List<Header> headers, String message, int timeout) {
    HttpPut httpPut = new HttpPut(resourceUri);
    return issueResourceRequest(resourceFormat, httpPut, payload, headers, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
    HttpPut httpPut = new HttpPut(resourceUri);
    return issueResourceRequest(resourceFormat, httpPut, payload, null, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload, String resourceFormat, List<Header> headers, String message, int timeout) {
    HttpPost httpPost = new HttpPost(resourceUri);
    return issueResourceRequest(resourceFormat, httpPost, payload, headers, message, timeout);
  }


  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
    return issuePostRequest(resourceUri, payload, resourceFormat, null, message, timeout);
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) {
    HttpGet httpget = new HttpGet(resourceUri);
    configureFhirRequest(httpget, resourceFormat);
    HttpResponse response = sendRequest(httpget);
    return unmarshalReference(response, resourceFormat);
  }

  private void setAuth(HttpRequest httpget) {
    if (password != null) {
      try {
        byte[] b = Base64.encodeBase64((username+":"+password).getBytes("ASCII"));
        String b64 = new String(b, StandardCharsets.US_ASCII);
        httpget.setHeader("Authorization", "Basic " + b64);
      } catch (UnsupportedEncodingException e) {
      }
    }
    if (accessToken != null) {
        httpget.setHeader("Authorization", "Bearer " + accessToken);
        httpget.setHeader("api-version", "1");
      }
}

  public Bundle postBatchRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
    HttpPost httpPost = new HttpPost(resourceUri);
    configureFhirRequest(httpPost, resourceFormat);
    HttpResponse response = sendPayload(httpPost, payload, proxy, message, timeout);
    return unmarshalFeed(response, resourceFormat);
  }

  public boolean issueDeleteRequest(URI resourceUri) {
    HttpDelete deleteRequest = new HttpDelete(resourceUri);
    HttpResponse response = sendRequest(deleteRequest);
    int responseStatusCode = response.getStatusLine().getStatusCode();
    boolean deletionSuccessful = false;
    if(responseStatusCode == 204) {
      deletionSuccessful = true;
    }
    return deletionSuccessful;
  }

  /***********************************************************
   * Request/Response Helper methods
   ***********************************************************/

  protected <T extends Resource> ResourceRequest<T> issueResourceRequest(String resourceFormat, HttpUriRequest request, String message, int timeout) {
    return issueResourceRequest(resourceFormat, request, null, message, timeout);
  }

  /**
   * @param resourceFormat
   * @param options
   * @return
   */
  protected <T extends Resource> ResourceRequest<T> issueResourceRequest(String resourceFormat, HttpUriRequest request, byte[] payload, String message, int timeout) {
    return issueResourceRequest(resourceFormat, request, payload, null, message, timeout);
  }

  /**
   * @param resourceFormat
   * @param options
   * @return
   */
  protected <T extends Resource> ResourceRequest<T> issueResourceRequest(String resourceFormat, HttpUriRequest request, byte[] payload, List<Header> headers, String message, int timeout) {
    configureFhirRequest(request, resourceFormat, headers);
    HttpResponse response = null;
    if(request instanceof HttpEntityEnclosingRequest && payload != null) {
      response = sendPayload((HttpEntityEnclosingRequestBase)request, payload, proxy, message, timeout);
    } else if (request instanceof HttpEntityEnclosingRequest && payload == null){
      throw new EFhirClientException("PUT and POST requests require a non-null payload");
    } else {
      response = sendRequest(request);
    }
    T resource = null;
    System.out.println(response);
    if (response.getStatusLine().getStatusCode() != 404) {
      resource = unmarshalReference(response, resourceFormat);
    }
    return new ResourceRequest<T>(resource, response.getStatusLine().getStatusCode(), getLocationHeader(response));
  }


  /**
   * Method adds required request headers.
   * TODO handle JSON request as well.
   * 
   * @param request
   */
  protected void configureFhirRequest(HttpRequest request, String format) {
    configureFhirRequest(request, format, null);
  }

  /**
   * Method adds required request headers.
   * TODO handle JSON request as well.
   * 
   * @param request
   */
  protected void configureFhirRequest(HttpRequest request, String format, List<Header> headers) {
    request.addHeader("User-Agent", "Java FHIR Client for FHIR");

    if (format != null) {		
      request.addHeader("Accept",format);
      request.addHeader("Content-Type", format + ";charset=" + DEFAULT_CHARSET);
    }
    request.addHeader("Accept-Charset", DEFAULT_CHARSET);
    if(headers != null) {
      for(Header header : headers) {
        request.addHeader(header);
      }
    }
    setAuth(request);
  }

  /**
   * Method posts request payload
   * 
   * @param request
   * @param payload
   * @return
   */
  @SuppressWarnings({ "resource", "deprecation" })
  protected HttpResponse sendPayload(HttpEntityEnclosingRequestBase request, byte[] payload, HttpHost proxy, String message, int timeout) {
    HttpResponse response = null;
    boolean ok = false;
    long t = System.currentTimeMillis();
    int tryCount = 0;
    while (!ok) {
      try {
        tryCount++;
        if (httpclient == null) {
          makeClient(proxy);
        }
      HttpParams params = httpclient.getParams();
      HttpConnectionParams.setSoTimeout(params, timeout < 1 ? this.timeout : timeout * 1000);
        request.setEntity(new ByteArrayEntity(payload));
        log(request);
        response = httpclient.execute(request);
        ok = true;
      } catch(IOException ioe) {
        System.out.println(ioe.getMessage()+" ("+(System.currentTimeMillis()-t)+"ms / "+Utilities.describeSize(payload.length)+" for "+message+")");
        if (tryCount <= retryCount || (tryCount < 3 && ioe instanceof org.apache.http.conn.ConnectTimeoutException)) {
          ok = false;
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
          }
        } else {
          if (tryCount > 1) {
            System.out.println("Giving up: "+ioe.getMessage()+" (R4 / "+(System.currentTimeMillis()-t)+"ms / "+Utilities.describeSize(payload.length)+" for "+message+")");
          }
          throw new EFhirClientException("Error sending HTTP Post/Put Payload: "+ioe.getMessage(), ioe);
        }
      }
    }
    return response;
  }

  @SuppressWarnings("deprecation")
  public void makeClient(HttpHost proxy) {
    httpclient = new DefaultHttpClient();
    HttpParams params = httpclient.getParams();
    HttpConnectionParams.setConnectionTimeout(params, TIMEOUT_CONNECT);
    HttpConnectionParams.setSoTimeout(params, timeout);
    HttpConnectionParams.setSoKeepalive(params, true);
    if(proxy != null) {
      httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
    }
  }

  /**
   * 
   * @param request
   * @param payload
   * @return
   */
  protected HttpResponse sendRequest(HttpUriRequest request) {
    HttpResponse response = null;
    try {
      if (httpclient == null) {
        makeClient(proxy);
      }
      response = httpclient.execute(request);
    } catch(IOException ioe) {
      if (ClientUtils.debugging ) {
        ioe.printStackTrace();
      }
      throw new EFhirClientException("Error sending Http Request: "+ioe.getMessage(), ioe);
    }
    return response;
  }


  /**
   * Unmarshals a resource from the response stream.
   * 
   * @param response
   * @return
   */
  @SuppressWarnings("unchecked")
  protected <T extends Resource> T unmarshalReference(HttpResponse response, String format) {
    T resource = null;
    OperationOutcome error = null;
    byte[] cnt = log(response);
    if (cnt != null) {
      try {
        resource = (T)getParser(format).parse(cnt);
        if (resource instanceof OperationOutcome && hasError((OperationOutcome)resource)) {
          error = (OperationOutcome) resource;
        }
      } catch(IOException ioe) {
        throw new EFhirClientException("Error reading Http Response: "+ioe.getMessage(), ioe);
      } catch(Exception e) {
        throw new EFhirClientException("Error parsing response message: "+e.getMessage(), e);
      }
    }
    if(error != null) {
      throw new EFhirClientException("Error from server: "+ResourceUtilities.getErrorDescription(error), error);
    }
    return resource;
  }

  /**
   * Unmarshals Bundle from response stream.
   * 
   * @param response
   * @return
   */
  protected Bundle unmarshalFeed(HttpResponse response, String format) {
    Bundle feed = null;
    byte[] cnt = log(response);
    String contentType = response.getHeaders("Content-Type")[0].getValue();
    OperationOutcome error = null;
    try {
      if (cnt != null) {
        if(contentType.contains(ResourceFormat.RESOURCE_XML.getHeader()) || contentType.contains("text/xml+fhir")) {
          Resource rf = getParser(format).parse(cnt);
          if (rf instanceof Bundle)
            feed = (Bundle) rf;
          else if (rf instanceof OperationOutcome && hasError((OperationOutcome) rf)) {
            error = (OperationOutcome) rf;
          } else {
            throw new EFhirClientException("Error reading server response: a resource was returned instead");
          }
        }
      }
    } catch(IOException ioe) {
      throw new EFhirClientException("Error reading Http Response", ioe);
    } catch(Exception e) {
      throw new EFhirClientException("Error parsing response message", e);
    }
    if(error != null) {
      throw new EFhirClientException("Error from server: "+ResourceUtilities.getErrorDescription(error), error);
    }
    return feed;
  }

  private boolean hasError(OperationOutcome oo) {
    for (OperationOutcomeIssueComponent t : oo.getIssue())
      if (t.getSeverity() == IssueSeverity.ERROR || t.getSeverity() == IssueSeverity.FATAL)
        return true;
    return false;
  }

  protected String getLocationHeader(HttpResponse response) {
    String location = null;
    if(response.getHeaders("location").length > 0) {//TODO Distinguish between both cases if necessary
      location = response.getHeaders("location")[0].getValue();
    } else if(response.getHeaders("content-location").length > 0) {
      location = response.getHeaders("content-location")[0].getValue();
    }
    return location;
  }


  /*****************************************************************
   * Client connection methods
   * ***************************************************************/

  public HttpURLConnection buildConnection(URI baseServiceUri, String tail) {
    try {
      HttpURLConnection client = (HttpURLConnection) baseServiceUri.resolve(tail).toURL().openConnection();
      return client;
    } catch(MalformedURLException mue) {
      throw new EFhirClientException("Invalid Service URL", mue);
    } catch(IOException ioe) {
      throw new EFhirClientException("Unable to establish connection to server: " + baseServiceUri.toString() + tail, ioe);
    }
  }

  public HttpURLConnection buildConnection(URI baseServiceUri, ResourceType resourceType, String id) {
    return buildConnection(baseServiceUri, ResourceAddress.buildRelativePathFromResourceType(resourceType, id));
  }

  /******************************************************************
   * Other general helper methods
   * ****************************************************************/


  public  <T extends Resource>  byte[] getResourceAsByteArray(T resource, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if(isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? OutputStyle.PRETTY : OutputStyle.NORMAL);
      parser.compose(baos, resource);
      baos.close();
      byteArray =  baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try{
        baos.close();
      }catch(Exception ex) {
        throw new EFhirClientException("Error closing output stream", ex);
      }
      throw new EFhirClientException("Error converting output stream to byte array", e);
    }
    return byteArray;
  }

  public  byte[] getFeedAsByteArray(Bundle feed, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if(isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? OutputStyle.PRETTY : OutputStyle.NORMAL);
      parser.compose(baos, feed);
      baos.close();
      byteArray =  baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try{
        baos.close();
      }catch(Exception ex) {
        throw new EFhirClientException("Error closing output stream", ex);
      }
      throw new EFhirClientException("Error converting output stream to byte array", e);
    }
    return byteArray;
  }

  public Calendar getLastModifiedResponseHeaderAsCalendarObject(URLConnection serverConnection) {
    String dateTime = null;
    try {
      dateTime = serverConnection.getHeaderField("Last-Modified");
      SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("en", "US"));
      Date lastModifiedTimestamp = format.parse(dateTime);
      Calendar calendar=Calendar.getInstance();
      calendar.setTime(lastModifiedTimestamp);
      return calendar;
    } catch(ParseException pe) {
      throw new EFhirClientException("Error parsing Last-Modified response header " + dateTime, pe);
    }
  }

  protected IParser getParser(String format) {
    if(StringUtils.isBlank(format)) {
      format = ResourceFormat.RESOURCE_XML.getHeader();
    }
    if(format.equalsIgnoreCase("json") || format.equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader()) || format.equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())) {
      return new JsonParser();
    } else if(format.equalsIgnoreCase("xml") || format.equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader()) || format.equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())) {
      return new XmlParser();
    } else {
      throw new EFhirClientException("Invalid format: " + format);
    }
  }

  public Bundle issuePostFeedRequest(URI resourceUri, Map<String, String> parameters, String resourceName, Resource resource, String resourceFormat) throws IOException {
    HttpPost httppost = new HttpPost(resourceUri);
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
    httppost.addHeader("Content-Type", "multipart/form-data; boundary="+boundary);
    httppost.addHeader("Accept", resourceFormat);
    configureFhirRequest(httppost, null);
    HttpResponse response = sendPayload(httppost, encodeFormSubmission(parameters, resourceName, resource, boundary));
    return unmarshalFeed(response, resourceFormat);
  }

  private byte[] encodeFormSubmission(Map<String, String> parameters, String resourceName, Resource resource, String boundary) throws IOException {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    OutputStreamWriter w = new OutputStreamWriter(b, "UTF-8");  
    for (String name : parameters.keySet()) {
      w.write("--");
      w.write(boundary);
      w.write("\r\nContent-Disposition: form-data; name=\""+name+"\"\r\n\r\n");
      w.write(parameters.get(name)+"\r\n");
    }
    w.write("--");
    w.write(boundary);
    w.write("\r\nContent-Disposition: form-data; name=\""+resourceName+"\"\r\n\r\n");
    w.close(); 
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.NORMAL);
    json.compose(b, resource);
    b.close();
    w = new OutputStreamWriter(b, "UTF-8");  
    w.write("\r\n--");
    w.write(boundary);
    w.write("--");
    w.close();
    return b.toByteArray();
  }

  /**
   * Method posts request payload
   * 
   * @param request
   * @param payload
   * @return
   */
  protected HttpResponse sendPayload(HttpEntityEnclosingRequestBase request, byte[] payload) {
    HttpResponse response = null;
    try {
      log(request);
      if (httpclient == null) {
        makeClient(proxy);
      }
      request.setEntity(new ByteArrayEntity(payload));
      response = httpclient.execute(request);
      log(response);
    } catch(IOException ioe) {
      throw new EFhirClientException("Error sending HTTP Post/Put Payload: "+ioe.getMessage(), ioe);
    }
    return response;
  }

  private void log(HttpUriRequest request) {
    if (logger != null) {
      List<String> headers = new ArrayList<>();
      for (Header h : request.getAllHeaders()) {
        headers.add(h.toString());
      }
      logger.logRequest(request.getMethod(), request.getURI().toString(), headers, null);
    }    
  }
  private void log(HttpEntityEnclosingRequestBase request)  {
    if (logger != null) {
      List<String> headers = new ArrayList<>();
      for (Header h : request.getAllHeaders()) {
        headers.add(h.toString());
      }
      byte[] cnt = null;
      InputStream s;
      try {
        s = request.getEntity().getContent();
        cnt = IOUtils.toByteArray(s);
        s.close();
      } catch (Exception e) {
      }
      logger.logRequest(request.getMethod(), request.getURI().toString(), headers, cnt);
    }    
  }  

  private byte[] log(HttpResponse response) {
    byte[] cnt = null;
    try {
      InputStream s = response.getEntity().getContent();
      cnt = IOUtils.toByteArray(s);
      s.close();
    } catch (Exception e) {
    }
    if (logger != null) {
      List<String> headers = new ArrayList<>();
      for (Header h : response.getAllHeaders()) {
        headers.add(h.toString());
      }
      logger.logResponse(response.getStatusLine().toString(), headers, cnt);
    }
    return cnt;
  }

  public ToolingClientLogger getLogger() {
    return logger;
  }

  public void setLogger(ToolingClientLogger logger) {
    this.logger = logger;
  }


  /**
   * Used for debugging
   * 
   * @param instream
   * @return
   */
  protected String writeInputStreamAsString(InputStream instream) {
    String value = null;
    try {
      value = IOUtils.toString(instream, "UTF-8");
      System.out.println(value);

    } catch(IOException ioe) {
      //Do nothing
    }
    return value;
  }

  public int getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(int retryCount) {
    this.retryCount = retryCount;
  }


}