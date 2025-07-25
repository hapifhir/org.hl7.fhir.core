package org.hl7.fhir.dstu3.support.utils.client.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.dstu3.formats.IParser;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.utils.ResourceUtilities;
import org.hl7.fhir.dstu3.support.utils.client.EFhirClientException;
import org.hl7.fhir.dstu3.support.utils.client.ResourceFormat;
import org.hl7.fhir.utilities.MimeType;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.*;


public class FhirRequestBuilder {

  public static final String LOCATION_HEADER = "location";
  public static final String CONTENT_LOCATION_HEADER = "content-location";
  public static final String DEFAULT_CHARSET = "UTF-8";

  private final HTTPRequest httpRequest;
  private String resourceFormat = null;
  private Iterable<HTTPHeader> headers = null;
  private String message = null;
  private int retryCount = 1;
  /**
   * The timeout quantity. Used in combination with {@link FhirRequestBuilder#timeoutUnit}.
   */
  private long timeout = 5000;
  /**
   * Time unit for {@link FhirRequestBuilder#timeout}.
   */
  private TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;
  /**
   * {@link ToolingClientLogger} for log output.
   */
  @Getter @Setter
  private ToolingClientLogger logger = null;
  private String source;

  public FhirRequestBuilder(HTTPRequest httpRequest, String source) {
    this.httpRequest = httpRequest;
    this.source = source;
  }

  /**
   * Adds necessary default headers, formatting headers, and any passed in {@link HTTPHeader}s to the passed in
   * {@link HTTPRequest}
   *
   * @param request {@link HTTPRequest} to add headers to.
   * @param format  Expected {@link Resource} format.
   * @param headers Any additional {@link HTTPHeader}s to add to the request.
   */
  protected static HTTPRequest formatHeaders(HTTPRequest request, String format, Iterable<HTTPHeader> headers) {
    List<HTTPHeader> allHeaders = new ArrayList<>();
    request.getHeaders().forEach(allHeaders::add);

    if (format != null) getResourceFormatHeaders(request, format).forEach(allHeaders::add);
    if (headers != null) headers.forEach(allHeaders::add);
    return request.withHeaders(allHeaders);
  }
  public static Iterable<HTTPHeader> getResourceFormatHeaders(HTTPRequest httpRequest, String format) {
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
   * Returns true if any of the {@link org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent} within the
   * provided {@link OperationOutcome} have an {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity} of
   * {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity#ERROR} or
   * {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity#FATAL}
   *
   * @param oo {@link OperationOutcome} to evaluate.
   * @return {@link Boolean#TRUE} if an error exists.
   */
  public static boolean hasError(OperationOutcome oo) {
    return (oo.getIssue().stream()
      .anyMatch(issue -> issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR
        || issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL));
  }

  /**
   * Extracts the 'location' header from the passed {@link Iterable<HTTPHeader>}. If no
   * value for 'location' exists, the value for 'content-location' is returned. If
   * neither header exists, we return null.
   *
   * @param headers {@link HTTPHeader} to evaluate
   * @return {@link String} header value, or null if no location headers are set.
   */
  public static String getLocationHeader(Iterable<HTTPHeader> headers) {
    String locationHeader = HTTPHeaderUtil.getSingleHeader(headers, LOCATION_HEADER);

    if (locationHeader != null) {
      return locationHeader;
    }
    return HTTPHeaderUtil.getSingleHeader(headers, CONTENT_LOCATION_HEADER);
  }

  protected ManagedFhirWebAccessor getManagedWebAccessor() {
    return ManagedWebAccess.fhirAccessor().withRetries(retryCount).withTimeout(timeout, timeoutUnit).withLogger(logger);
  }

  public FhirRequestBuilder withResourceFormat(String resourceFormat) {
    this.resourceFormat = resourceFormat;
    return this;
  }

  public FhirRequestBuilder withHeaders(Iterable<HTTPHeader> headers) {
    this.headers = headers;
    return this;
  }

  public FhirRequestBuilder withMessage(String message) {
    this.message = message;
    return this;
  }

  public FhirRequestBuilder withRetryCount(int retryCount) {
    this.retryCount = retryCount;
    return this;
  }

  public FhirRequestBuilder withLogger(ToolingClientLogger logger) {
    this.logger = logger;
    return this;
  }

  public FhirRequestBuilder withTimeout(long timeout, TimeUnit unit) {
    this.timeout = timeout;
    this.timeoutUnit = unit;
    return this;
  }

  public <T extends Resource> ResourceRequest<T> execute() throws IOException {
    HTTPRequest requestWithHeaders = formatHeaders(httpRequest, resourceFormat, headers);
    HTTPResult response = getManagedWebAccessor().httpCall(requestWithHeaders);
    T resource = unmarshalReference(response, resourceFormat);
    return new ResourceRequest<T>(resource, response.getCode(), getLocationHeader(response.getHeaders()));
  }

  public Bundle executeAsBatch() throws IOException {
    HTTPRequest requestWithHeaders = formatHeaders(httpRequest, resourceFormat, null);
    HTTPResult response = getManagedWebAccessor().httpCall(requestWithHeaders);
    return unmarshalFeed(response, resourceFormat);
  }

  /**
   * Unmarshalls a resource from the response stream.
   */
  @SuppressWarnings("unchecked")
  protected <T extends Resource> T unmarshalReference(HTTPResult response, String format) {
    T resource = null;
    OperationOutcome error = null;

    if (response.getContent() != null) {
      try {
        byte[] body = response.getContent();

        resource = (T) getParser(format).parse(body);
        if (resource instanceof OperationOutcome && hasError((OperationOutcome) resource)) {
          error = (OperationOutcome) resource;
        }
      } catch (IOException ioe) {
        throw new EFhirClientException(0, "Error reading Http Response from "+source+": " + ioe.getMessage(), ioe);
      } catch (Exception e) {
        throw new EFhirClientException(0, "Error parsing response message from "+source+": " + e.getMessage(), e);
      }
    }

    if (error != null) {
      throw new EFhirClientException(0, "Error from server: " + ResourceUtilities.getErrorDescription(error), error);
    }

    return resource;
  }

  /**
   * Unmarshalls Bundle from response stream.
   */
  protected Bundle unmarshalFeed(HTTPResult response, String format) {
    Bundle feed = null;
    OperationOutcome error = null;
    try {
      byte[] body = response.getContent();

      String contentType = HTTPHeaderUtil.getSingleHeader(response.getHeaders(), "Content-Type");
      if (body != null) {
        if (contentType.contains(ResourceFormat.RESOURCE_XML.getHeader()) || contentType.contains(ResourceFormat.RESOURCE_JSON.getHeader()) || contentType.contains("text/xml+fhir")) {
          Resource rf = getParser(format).parse(body);
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
      throw new EFhirClientException(0, "Error reading Http Response from "+source+": "+ioe.getMessage(), ioe);
    } catch (Exception e) {
      throw new EFhirClientException(0, "Error parsing response message from "+source+":"+e.getMessage(), e);
    }
    if (error != null) {
      throw new EFhirClientException(0, "Error from "+source+": " + ResourceUtilities.getErrorDescription(error), error);
    }
    return feed;
  }

  /**
   * Returns the appropriate parser based on the format type passed in. Defaults to XML parser if a blank format is
   * provided...because reasons.
   * <p/>
   * Currently supports only "json" and "xml" formats.
   *
   * @param format One of "json" or "xml".
   * @return {@link JsonParser} or {@link XmlParser}
   */
  protected IParser getParser(String format) {
    if (StringUtils.isBlank(format)) {
      format = ResourceFormat.RESOURCE_XML.getHeader();
    }
    MimeType mt = new MimeType(format);
    if (mt.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())) {
      return new JsonParser();
    } else if (mt.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())) {
      return new XmlParser();
    } else {
      throw new EFhirClientException("Invalid format: " + format);
    }
  }
}
