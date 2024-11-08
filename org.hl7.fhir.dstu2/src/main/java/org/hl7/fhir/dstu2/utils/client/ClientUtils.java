package org.hl7.fhir.dstu2.utils.client;

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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import org.hl7.fhir.dstu2.formats.IParser;
import org.hl7.fhir.dstu2.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.OperationOutcome;
import org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ResourceType;
import org.hl7.fhir.dstu2.utils.ResourceUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.MimeType;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.*;
import org.hl7.fhir.utilities.settings.FhirSettings;

import javax.annotation.Nonnull;

/**
 * Helper class handling lower level HTTP transport concerns. TODO Document
 * methods.
 * 
 * @author Claude Nanjo
 */
public class ClientUtils {
  protected static final String LOCATION_HEADER = "location";
  protected static final String CONTENT_LOCATION_HEADER = "content-location";
  public static final String DEFAULT_CHARSET = "UTF-8";

  private static boolean debugging = false;

/*
  @Getter
  @Setter
  private HttpHost proxy;
*/
  @Getter
  @Setter
  private int timeout = 5000;



  @Setter
  @Getter
  private ToolingClientLogger logger;

  @Setter
  @Getter
  private int retryCount;

  @Getter
  @Setter
  private String userAgent;
  @Setter
  private String acceptLanguage;
  @Setter
  private String contentLanguage;
  private final TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;

  protected ManagedFhirWebAccessor getManagedWebAccessBuilder() {
    return ManagedWebAccess.fhirBuilder().withRetries(retryCount).withTimeout(timeout, timeoutUnit).withLogger(logger);
  }

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri, String resourceFormat,
      int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.OPTIONS)
      .withUrl(optionsUri.toString());
    return issueResourceRequest(resourceFormat, httpRequest, timeoutLoading);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri, String resourceFormat,
      int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.GET)
      .withUrl(resourceUri.toString());
    return issueResourceRequest(resourceFormat, httpRequest, timeoutLoading);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      Iterable<HTTPHeader> headers, int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.PUT)
      .withUrl(resourceUri.toString())
      .withBody(payload);
    return issueResourceRequest(resourceFormat, httpRequest, headers, timeoutLoading);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.PUT)
      .withUrl(resourceUri.toString())
      .withBody(payload);
    return issueResourceRequest(resourceFormat, httpRequest, timeoutLoading);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, Iterable<HTTPHeader> headers, int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withUrl(resourceUri.toString())
      .withBody(payload);
    return issueResourceRequest(resourceFormat, httpRequest, headers, timeoutLoading);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, int timeoutLoading) {
    return issuePostRequest(resourceUri, payload, resourceFormat, null, timeoutLoading);
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.GET)
      .withUrl(resourceUri.toString());
    Iterable<HTTPHeader> headers = getFhirHeaders(httpRequest, resourceFormat);
    HTTPResult response = sendRequest(httpRequest.withHeaders(headers));
    return unmarshalReference(response, resourceFormat);
  }

  public Bundle postBatchRequest(URI resourceUri, byte[] payload, String resourceFormat, int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withUrl(resourceUri.toString())
      .withBody(payload);
    Iterable<HTTPHeader> headers =  getFhirHeaders(httpRequest, resourceFormat);
    HTTPResult response = sendPayload(httpRequest.withHeaders(headers));
    return unmarshalFeed(response, resourceFormat);
  }

  public boolean issueDeleteRequest(URI resourceUri) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    HTTPRequest request = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.DELETE)
      .withUrl(resourceUri.toString());
    HTTPResult response = sendRequest(request);
    int responseStatusCode = response.getCode();
    boolean deletionSuccessful = false;
    if (responseStatusCode == 204) {
      deletionSuccessful = true;
    }
    return deletionSuccessful;
  }

  /***********************************************************
   * Request/Response Helper methods
   ***********************************************************/

  protected <T extends Resource> ResourceRequest<T> issueResourceRequest(String resourceFormat, HTTPRequest request,
      int timeoutLoading) {
    return issueResourceRequest(resourceFormat, request, Collections.emptyList(), timeoutLoading);
  }
  /**
   * @param resourceFormat
   * @return
   */
  protected <T extends Resource> ResourceRequest<T> issueResourceRequest(String resourceFormat, HTTPRequest request,
                                                                         @Nonnull Iterable<HTTPHeader> headers, int timeoutLoading) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    Iterable<HTTPHeader> configuredHeaders = getFhirHeaders(request, resourceFormat, headers);
    try {

      HTTPResult response = getManagedWebAccessBuilder().httpCall(request.withHeaders(configuredHeaders));
      T resource = unmarshalReference(response, resourceFormat);
      return new ResourceRequest<T>(resource, response.getCode(), getLocationHeader(response.getHeaders()));
    } catch (IOException ioe) {
      throw new EFhirClientException("Error sending HTTP Post/Put Payload to " + "??" + ": " + ioe.getMessage(),
        ioe);
    }
  }

  /**
   * Method adds required request headers. TODO handle JSON request as well.
   * 
   * @param format
   */
  protected Iterable<HTTPHeader> getFhirHeaders(HTTPRequest httpRequest, String format) {
    return getFhirHeaders(httpRequest, format, null);
  }

  /**
   * Method adds required request headers. TODO handle JSON request as well.
   * 
   * @param format
   */
  protected Iterable<HTTPHeader> getFhirHeaders(HTTPRequest httpRequest, String format, Iterable<HTTPHeader> headers) {
    List<HTTPHeader> configuredHeaders = new ArrayList<>();
    if (!Utilities.noString(userAgent)) {
      configuredHeaders.add(new HTTPHeader("User-Agent", userAgent));
    }
    if (!Utilities.noString(acceptLanguage)) {
      configuredHeaders.add(new HTTPHeader("Accept-Language", acceptLanguage));
    }
    if (!Utilities.noString(contentLanguage)) {
      configuredHeaders.add(new HTTPHeader("Content-Language", acceptLanguage));
    }

    Iterable<HTTPHeader> resourceFormatHeaders = getResourceFormatHeaders(httpRequest, format);
    resourceFormatHeaders.forEach(configuredHeaders::add);

    if (headers != null) {
      headers.forEach(configuredHeaders::add);
    }
    return configuredHeaders;
  }

  protected static List<HTTPHeader> getResourceFormatHeaders(HTTPRequest httpRequest, String format) {
    List<HTTPHeader> headers = new ArrayList<>();
    headers.add(new HTTPHeader("Accept", format));
    if (httpRequest.getMethod() == HTTPRequest.HttpMethod.PUT
      || httpRequest.getMethod() == HTTPRequest.HttpMethod.POST
      || httpRequest.getMethod() == HTTPRequest.HttpMethod.PATCH
    ) {
      headers.add(new HTTPHeader("Content-Type", format + ";charset=" + DEFAULT_CHARSET));
    }
    return headers;
  }

  /**
   * 
   * @param request The request to be sent
   * @return The response from the server
   */
  protected HTTPResult sendRequest(HTTPRequest request) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    HTTPResult response = null;
    try {

      response = getManagedWebAccessBuilder().httpCall(request);
      return response;
    } catch (IOException ioe) {
      if (ClientUtils.debugging) {
        ioe.printStackTrace();
      }
      throw new EFhirClientException("Error sending Http Request: " + ioe.getMessage(), ioe);
    }
  }

  /**
   * Unmarshals a resource from the response stream.
   * 
   * @param response
   * @return
   */
  @SuppressWarnings("unchecked")
  protected <T extends Resource> T unmarshalReference(HTTPResult response, String format) {
    T resource = null;
    OperationOutcome error = null;
    if (response.getContent() != null) {
      try {
        resource = (T) getParser(format).parse(response.getContent());
        if (resource instanceof OperationOutcome && hasError((OperationOutcome) resource)) {
          error = (OperationOutcome) resource;
        }
      } catch (IOException ioe) {
        throw new EFhirClientException("Error reading Http Response: " + ioe.getMessage(), ioe);
      } catch (Exception e) {
        throw new EFhirClientException("Error parsing response message: " + e.getMessage(), e);
      }
    }
    if (error != null) {
      throw new EFhirClientException("Error from server: " + ResourceUtilities.getErrorDescription(error), error);
    }
    return resource;
  }

  /**
   * Unmarshals Bundle from response stream.
   * 
   * @param response
   * @return
   */
  protected Bundle unmarshalFeed(HTTPResult response, String format) {
    Bundle feed = null;

    String contentType = HTTPHeaderUtil.getSingleHeader(response.getHeaders(), "Content-Type");
    OperationOutcome error = null;
    try {
      if (response.getContent() != null) {
        if (contentType.contains(ResourceFormat.RESOURCE_XML.getHeader()) || contentType.contains("text/xml+fhir")) {
          Resource rf = getParser(format).parse(response.getContent());
          if (rf instanceof Bundle)
            feed = (Bundle) rf;
          else if (rf instanceof OperationOutcome && hasError((OperationOutcome) rf)) {
            error = (OperationOutcome) rf;
          } else {
            throw new EFhirClientException("Error reading server response: a resource was returned instead");
          }
        }
      }
    } catch (IOException ioe) {
      throw new EFhirClientException("Error reading Http Response", ioe);
    } catch (Exception e) {
      throw new EFhirClientException("Error parsing response message", e);
    }
    if (error != null) {
      throw new EFhirClientException("Error from server: " + ResourceUtilities.getErrorDescription(error), error);
    }
    return feed;
  }

  protected boolean hasError(OperationOutcome oo) {
    for (OperationOutcomeIssueComponent t : oo.getIssue())
      if (t.getSeverity() == IssueSeverity.ERROR || t.getSeverity() == IssueSeverity.FATAL)
        return true;
    return false;
  }

  protected static String getLocationHeader(Iterable<HTTPHeader> headers) {
    String locationHeader = HTTPHeaderUtil.getSingleHeader(headers, LOCATION_HEADER);

    if (locationHeader != null) {
      return locationHeader;
    }
    return HTTPHeaderUtil.getSingleHeader(headers, CONTENT_LOCATION_HEADER);
  }

  /*****************************************************************
   * Client connection methods
   ***************************************************************/

  public HttpURLConnection buildConnection(URI baseServiceUri, String tail) {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    try {
      HttpURLConnection client = (HttpURLConnection) baseServiceUri.resolve(tail).toURL().openConnection();
      return client;
    } catch (MalformedURLException mue) {
      throw new EFhirClientException("Invalid Service URL", mue);
    } catch (IOException ioe) {
      throw new EFhirClientException("Unable to establish connection to server: " + baseServiceUri.toString() + tail,
          ioe);
    }
  }

  public HttpURLConnection buildConnection(URI baseServiceUri, ResourceType resourceType, String id) {
    return buildConnection(baseServiceUri, ResourceAddress.buildRelativePathFromResourceType(resourceType, id));
  }

  /******************************************************************
   * Other general helper methods
   ****************************************************************/

  public <T extends Resource> byte[] getResourceAsByteArray(T resource, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if (isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? OutputStyle.PRETTY : OutputStyle.NORMAL);
      parser.compose(baos, resource);
      baos.close();
      byteArray = baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try {
        baos.close();
      } catch (Exception ex) {
        throw new EFhirClientException("Error closing output stream", ex);
      }
      throw new EFhirClientException("Error converting output stream to byte array", e);
    }
    return byteArray;
  }

  public byte[] getFeedAsByteArray(Bundle feed, boolean pretty, boolean isJson) {
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      IParser parser = null;
      if (isJson) {
        parser = new JsonParser();
      } else {
        parser = new XmlParser();
      }
      parser.setOutputStyle(pretty ? OutputStyle.PRETTY : OutputStyle.NORMAL);
      parser.compose(baos, feed);
      baos.close();
      byteArray = baos.toByteArray();
      baos.close();
    } catch (Exception e) {
      try {
        baos.close();
      } catch (Exception ex) {
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
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(lastModifiedTimestamp);
      return calendar;
    } catch (ParseException pe) {
      throw new EFhirClientException("Error parsing Last-Modified response header " + dateTime, pe);
    }
  }

  protected IParser getParser(String format) {
    if (StringUtils.isBlank(format)) {
      format = ResourceFormat.RESOURCE_XML.getHeader();
    }
    MimeType mm = new MimeType(format);
    if (mm.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())
        || format.equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())) {
      return new JsonParser();
    } else if (mm.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())
        || format.equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())) {
      return new XmlParser();
    } else {
      throw new EFhirClientException("Invalid format: " + format);
    }
  }

  public Bundle issuePostFeedRequest(URI resourceUri, Map<String, String> parameters, String resourceName,
      Resource resource, String resourceFormat) throws IOException {

    HTTPRequest httpRequest = new HTTPRequest()
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withUrl(resourceUri.toString());
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
  List<HTTPHeader> headers = new ArrayList<>();
    headers.add(new HTTPHeader("Content-Type", "multipart/form-data; boundary=" + boundary));
    headers.add(new HTTPHeader("Accept", resourceFormat));
    this.getFhirHeaders(httpRequest, null).forEach(headers::add);

    HTTPResult response = sendPayload(httpRequest.withBody(encodeFormSubmission(parameters, resourceName, resource, boundary)).withHeaders(headers));
    return unmarshalFeed(response, resourceFormat);
  }

  private byte[] encodeFormSubmission(Map<String, String> parameters, String resourceName, Resource resource,
      String boundary) throws IOException {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    OutputStreamWriter w = new OutputStreamWriter(b, "UTF-8");
    for (String name : parameters.keySet()) {
      w.write("--");
      w.write(boundary);
      w.write("\r\nContent-Disposition: form-data; name=\"" + name + "\"\r\n\r\n");
      w.write(parameters.get(name) + "\r\n");
    }
    w.write("--");
    w.write(boundary);
    w.write("\r\nContent-Disposition: form-data; name=\"" + resourceName + "\"\r\n\r\n");
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
   * @return
   */
  protected HTTPResult sendPayload(HTTPRequest request) {
    HTTPResult response = null;
    try {

      response = getManagedWebAccessBuilder().httpCall(request);
    } catch (IOException ioe) {
      throw new EFhirClientException("Error sending HTTP Post/Put Payload: " + ioe.getMessage(), ioe);
    }
    return response;
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

    } catch (IOException ioe) {
      // Do nothing
    }
    return value;
  }


}