package org.hl7.fhir.r5.utils.client.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.ResourceUtilities;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.utils.client.ResourceFormat;
import org.hl7.fhir.utilities.MimeType;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.*;
import org.hl7.fhir.utilities.xhtml.XhtmlUtils;

@Slf4j
public class FhirRequestBuilder {

  protected static final String LOCATION_HEADER = "location";
  protected static final String CONTENT_LOCATION_HEADER = "content-location";
  protected static final String DEFAULT_CHARSET = "UTF-8";

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
  @Getter
  @Setter
  private ToolingClientLogger logger = null;

  private String source;

  public FhirRequestBuilder(HTTPRequest httpRequest, String source) {
    this.source = source;
    this.httpRequest = httpRequest;
  }

  /**
   * Adds necessary default headers, formatting headers, and any passed in
   * {@link HTTPHeader}s to the passed in {@link HTTPRequest}
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

  /**
   * Adds necessary headers for the given resource format provided.
   *
   * @param httpRequest {@link HTTPRequest} to add default headers to.
   * @param format     Expected {@link Resource} format.
   */
  protected static Iterable<HTTPHeader> getResourceFormatHeaders(HTTPRequest httpRequest, String format) {
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
   * Returns true if any of the {@link OperationOutcome.OperationOutcomeIssueComponent} within the
   * provided {@link OperationOutcome} have an {@link OperationOutcome.IssueSeverity} of
   * {@link OperationOutcome.IssueSeverity#ERROR} or
   * {@link OperationOutcome.IssueSeverity#FATAL}
   *
   * @param oo {@link OperationOutcome} to evaluate.
   * @return {@link Boolean#TRUE} if an error exists.
   */
  protected static boolean hasError(OperationOutcome oo) {
    return (oo.getIssue().stream().anyMatch(issue -> issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR
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
  protected static String getLocationHeader(Iterable<HTTPHeader> headers) {
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

    T resource = unmarshalReference(response, resourceFormat, null);
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
  protected <T extends Resource> T unmarshalReference(HTTPResult response, String format, String resourceType) {
    int code = response.getCode();
    boolean ok = code >= 200 && code < 300;
    if (response.getContent() == null) {
      if (!ok) {
        if (Utilities.noString(response.getMessage())) {
          throw new EFhirClientException(code, response.getMessagefromCode());
        } else {
          throw new EFhirClientException(code, response.getMessage());
        }
      } else {
        return null;
      }
    }
    String body;
    
    Resource resource = null;
    try {
      body = response.getContentAsString();
      String contentType = HTTPHeaderUtil.getSingleHeader(response.getHeaders(), "Content-Type");
      if (contentType == null) {
        if (ok) {
          resource = getParser(format).parse(body);
        } else {
          log.warn("Got error response with no Content-Type from "+source+" with status "+code);
          log.warn(body);
          resource = OperationOutcomeUtilities.outcomeFromTextError(body);
        }
      } else {
        if (contentType.contains(";")) {
          contentType = contentType.substring(0, contentType.indexOf(";"));
        }
        switch (contentType) {
        case "application/json":
        case "application/fhir+json":
          if (!format.contains("json")) {
            log.warn("Got json response expecting "+format+" from "+source+" with status "+code);
          }
          resource = getParser(ResourceFormat.RESOURCE_JSON.getHeader()).parse(body);
          break;
        case "application/xml":
        case "application/fhir+xml":
        case "text/xml":
          if (!format.contains("xml")) {
            log.warn("Got xml response expecting "+format+" from "+source+" with status "+code);
          }
          resource = getParser(ResourceFormat.RESOURCE_XML.getHeader()).parse(body);
          break;
        case "text/plain":
          resource = OperationOutcomeUtilities.outcomeFromTextError(body);
          break;
        case "text/html" : 
          resource = OperationOutcomeUtilities.outcomeFromTextError(XhtmlUtils.convertHtmlToText(response.getContentAsString(), source));
          break;
        default: // not sure what else to do? 
          log.warn("Got content-type '"+contentType+"' from "+source);
          log.warn(body);
          resource = OperationOutcomeUtilities.outcomeFromTextError(body);
        }
      }
    } catch (IOException ioe) {
      throw new EFhirClientException(code, "Error reading Http Response from "+source+":"+ioe.getMessage(), ioe);
    } catch (Exception e) {
      throw new EFhirClientException(code, "Error parsing response message from "+source+": "+e.getMessage(), e);
    }
    if (resource instanceof OperationOutcome && (!"OperationOutcome".equals(resourceType) || !ok)) {
      OperationOutcome error = (OperationOutcome) resource;  
      if (hasError((OperationOutcome) resource)) {
        throw new EFhirClientException(code, "Error from "+source+": " + ResourceUtilities.getErrorDescription(error), error);
      } else {
        // umm, weird...
        log.warn("Got OperationOutcome with no error from "+source+" with status "+code);
        log.warn(body);
        return null;
      }
    }
    if (resource == null) {
      log.error("No resource from "+source+" with status "+code);
      log.error(body);
      return null; // shouldn't get here?
    }
    if (resourceType != null && !resource.fhirType().equals(resourceType)) {
      throw new EFhirClientException(0, "Error parsing response message from "+source+": Found an "+resource.fhirType()+" looking for a "+resourceType);        
    }
    return (T) resource;
  }

  /**
   * Unmarshalls Bundle from response stream.
   */
  protected Bundle unmarshalFeed(HTTPResult response, String format) {
    return unmarshalReference(response, format, "Bundle");
  }

  /**
   * Returns the appropriate parser based on the format type passed in. Defaults
   * to XML parser if a blank format is provided...because reasons.
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
      throw new EFhirClientException(0, "Invalid format: " + format);
    }
  }
}
