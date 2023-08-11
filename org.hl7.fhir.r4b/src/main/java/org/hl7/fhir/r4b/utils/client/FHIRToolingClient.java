package org.hl7.fhir.r4b.utils.client;

import okhttp3.Headers;
import okhttp3.internal.http2.Header;
import org.hl7.fhir.exceptions.FHIRException;

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

import org.hl7.fhir.r4b.model.*;
import org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r4b.utils.client.network.ByteUtils;
import org.hl7.fhir.r4b.utils.client.network.Client;
import org.hl7.fhir.r4b.utils.client.network.ClientHeaders;
import org.hl7.fhir.r4b.utils.client.network.ResourceRequest;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Very Simple RESTful client. This is purely for use in the standalone tools
 * jar packages. It doesn't support many features, only what the tools need.
 * <p>
 * To use, initialize class and set base service URI as follows:
 *
 * <pre>
 * <code>
 * FHIRSimpleClient fhirClient = new FHIRSimpleClient();
 * fhirClient.initialize("http://my.fhir.domain/myServiceRoot");
 * </code>
 * </pre>
 * <p>
 * Default Accept and Content-Type headers are application/fhir+xml and
 * application/fhir+json.
 * <p>
 * These can be changed by invoking the following setter functions:
 *
 * <pre>
 * <code>
 * setPreferredResourceFormat()
 * setPreferredFeedFormat()
 * </code>
 * </pre>
 * <p>
 * TODO Review all sad paths.
 *
 * @author Claude Nanjo
 */
public class FHIRToolingClient {

  public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssK";
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String hostKey = "http.proxyHost";
  public static final String portKey = "http.proxyPort";

  private static final int TIMEOUT_NORMAL = 1500;
  private static final int TIMEOUT_OPERATION = 30000;
  private static final int TIMEOUT_ENTRY = 500;
  private static final int TIMEOUT_OPERATION_LONG = 60000;
  private static final int TIMEOUT_OPERATION_EXPAND = 120000;

  private String base;
  private ResourceAddress resourceAddress;
  private ResourceFormat preferredResourceFormat;
  private int maxResultSetSize = -1;// _count
  private CapabilityStatement capabilities;
  private Client client = new Client();
  private ArrayList<Header> headers = new ArrayList<>();
  private String username;
  private String password;
  private String userAgent;

  // Pass endpoint for client - URI
  public FHIRToolingClient(String baseServiceUrl, String userAgent) throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
    this.userAgent = userAgent;
    initialize(baseServiceUrl);
  }

  public void initialize(String baseServiceUrl) throws URISyntaxException {
    base = baseServiceUrl;
    client.setBase(base);
    resourceAddress = new ResourceAddress(baseServiceUrl);
    this.maxResultSetSize = -1;
    checkCapabilities();
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  private void checkCapabilities() {
    try {
      capabilities = getCapabilitiesStatementQuick();
    } catch (Throwable e) {
    }
  }

  public String getPreferredResourceFormat() {
    return preferredResourceFormat.getHeader();
  }

  public void setPreferredResourceFormat(ResourceFormat resourceFormat) {
    preferredResourceFormat = resourceFormat;
  }

  public int getMaximumRecordCount() {
    return maxResultSetSize;
  }

  public void setMaximumRecordCount(int maxResultSetSize) {
    this.maxResultSetSize = maxResultSetSize;
  }

  public TerminologyCapabilities getTerminologyCapabilities() {
    TerminologyCapabilities capabilities = null;
    try {
      capabilities = (TerminologyCapabilities) client.issueGetResourceRequest(resourceAddress.resolveMetadataTxCaps(),
          getPreferredResourceFormat(), generateHeaders(), "TerminologyCapabilities", TIMEOUT_NORMAL).getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's terminology capabilities", e);
    }
    return capabilities;
  }

  public CapabilityStatement getCapabilitiesStatement() {
    CapabilityStatement conformance = null;
    try {
      conformance = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(false),
          getPreferredResourceFormat(), generateHeaders(), "CapabilitiesStatement", TIMEOUT_NORMAL).getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's conformance statement", e);
    }
    return conformance;
  }

  public CapabilityStatement getCapabilitiesStatementQuick() throws EFhirClientException {
    if (capabilities != null)
      return capabilities;
    try {
      capabilities = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(true),
          getPreferredResourceFormat(), generateHeaders(), "CapabilitiesStatement-Quick", TIMEOUT_NORMAL)
          .getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's capability statement: " + e.getMessage(), e);
    }
    return capabilities;
  }

  public <T extends Resource> T read(Class<T> resourceClass, String id) {// TODO Change this to AddressableResource
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
          getPreferredResourceFormat(), generateHeaders(), "Read " + resourceClass.getName() + "/" + id,
          TIMEOUT_NORMAL);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T vread(Class<T> resourceClass, String id, String version) {
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(
          resourceAddress.resolveGetUriFromResourceClassAndIdAndVersion(resourceClass, id, version),
          getPreferredResourceFormat(), generateHeaders(),
          "VRead " + resourceClass.getName() + "/" + id + "/?_history/" + version, TIMEOUT_NORMAL);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new FHIRException("Error trying to read this version of the resource", e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T getCanonical(Class<T> resourceClass, String canonicalURL) {
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(
          resourceAddress.resolveGetUriFromResourceClassAndCanonical(resourceClass, canonicalURL),
          getPreferredResourceFormat(), generateHeaders(), "Read " + resourceClass.getName() + "?url=" + canonicalURL,
          TIMEOUT_NORMAL);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to read this version of the resource", e);
    }
    Bundle bnd = (Bundle) result.getPayload();
    if (bnd.getEntry().size() == 0)
      throw new EFhirClientException("No matching resource found for canonical URL '" + canonicalURL + "'");
    if (bnd.getEntry().size() > 1)
      throw new EFhirClientException("Multiple matching resources found for canonical URL '" + canonicalURL + "'");
    return (T) bnd.getEntry().get(0).getResource();
  }

  public Resource update(Resource resource) {
    org.hl7.fhir.r4b.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePutRequest(
          resourceAddress.resolveGetUriFromResourceClassAndId(resource.getClass(), resource.getId()),
          ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(), "Update " + resource.fhirType() + "/" + resource.getId(),
          TIMEOUT_OPERATION);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new EFhirClientException("An error has occurred while trying to update this resource", e);
    }
    // TODO oe 26.1.2015 could be made nicer if only OperationOutcome locationheader
    // is returned with an operationOutcome would be returned (and not the resource
    // also) we make another read
    try {
      OperationOutcome operationOutcome = (OperationOutcome) result.getPayload();
      ResourceAddress.ResourceVersionedIdentifier resVersionedIdentifier = ResourceAddress
          .parseCreateLocation(result.getLocation());
      return this.vread(resource.getClass(), resVersionedIdentifier.getId(), resVersionedIdentifier.getVersionId());
    } catch (ClassCastException e) {
      // if we fall throught we have the correct type already in the create
    }

    return result.getPayload();
  }

  public <T extends Resource> T update(Class<T> resourceClass, T resource, String id) {
    ResourceRequest<T> result = null;
    try {
      result = client.issuePutRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
          ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(), "Update " + resource.fhirType() + "/" + id,
          TIMEOUT_OPERATION);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new EFhirClientException("An error has occurred while trying to update this resource", e);
    }
    // TODO oe 26.1.2015 could be made nicer if only OperationOutcome locationheader
    // is returned with an operationOutcome would be returned (and not the resource
    // also) we make another read
    try {
      OperationOutcome operationOutcome = (OperationOutcome) result.getPayload();
      ResourceAddress.ResourceVersionedIdentifier resVersionedIdentifier = ResourceAddress
          .parseCreateLocation(result.getLocation());
      return this.vread(resourceClass, resVersionedIdentifier.getId(), resVersionedIdentifier.getVersionId());
    } catch (ClassCastException e) {
      // if we fall through we have the correct type already in the create
    }

    return result.getPayload();
  }

  public <T extends Resource> Parameters operateType(Class<T> resourceClass, String name, Parameters params) {
    boolean complex = false;
    for (ParametersParameterComponent p : params.getParameter())
      complex = complex || !(p.getValue() instanceof PrimitiveType);
    String ps = "";
    try {
      if (!complex)
        for (ParametersParameterComponent p : params.getParameter())
          if (p.getValue() instanceof PrimitiveType)
            ps += p.getName() + "=" + Utilities.encodeUri(((PrimitiveType) p.getValue()).asStringValue()) + "&";
      ResourceRequest<T> result;
      URI url = resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps);
      if (complex) {
        byte[] body = ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat()));
        result = client.issuePostRequest(url, body, getPreferredResourceFormat(), generateHeaders(),
            "POST " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
      } else {
        result = client.issueGetResourceRequest(url, getPreferredResourceFormat(), generateHeaders(),
            "GET " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
      }
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
      if (result.getPayload() instanceof Parameters) {
        return (Parameters) result.getPayload();
      } else {
        Parameters p_out = new Parameters();
        p_out.addParameter().setName("return").setResource(result.getPayload());
        return p_out;
      }
    } catch (Exception e) {
      handleException(
          "Error performing tx5 operation '" + name + ": " + e.getMessage() + "' (parameters = \"" + ps + "\")", e);
    }
    return null;
  }

  public Bundle transaction(Bundle batch) {
    Bundle transactionResult = null;
    try {
      transactionResult = client.postBatchRequest(resourceAddress.getBaseServiceUri(),
          ByteUtils.resourceToByteArray(batch, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(), "transaction",
          TIMEOUT_OPERATION + (TIMEOUT_ENTRY * batch.getEntry().size()));
    } catch (Exception e) {
      handleException("An error occurred trying to process this transaction request", e);
    }
    return transactionResult;
  }

  @SuppressWarnings("unchecked")
  public <T extends Resource> OperationOutcome validate(Class<T> resourceClass, T resource, String id) {
    ResourceRequest<T> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveValidateUri(resourceClass, id),
          ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(),
          "POST " + resourceClass.getName() + (id != null ? "/" + id : "") + "/$validate", TIMEOUT_OPERATION_LONG);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to validate this resource", e);
    }
    return (OperationOutcome) result.getPayload();
  }

  /**
   * Helper method to prevent nesting of previously thrown EFhirClientExceptions
   *
   * @param e
   * @throws EFhirClientException
   */
  protected void handleException(String message, Exception e) throws EFhirClientException {
    if (e instanceof EFhirClientException) {
      throw (EFhirClientException) e;
    } else {
      throw new EFhirClientException(message, e);
    }
  }

  /**
   * Helper method to determine whether desired resource representation is Json or
   * XML.
   *
   * @param format
   * @return
   */
  protected boolean isJson(String format) {
    boolean isJson = false;
    if (format.toLowerCase().contains("json")) {
      isJson = true;
    }
    return isJson;
  }

  public Bundle fetchFeed(String url) {
    Bundle feed = null;
    try {
      feed = client.issueGetFeedRequest(new URI(url), getPreferredResourceFormat());
    } catch (Exception e) {
      handleException("An error has occurred while trying to retrieve history since last update", e);
    }
    return feed;
  }

  public ValueSet expandValueset(ValueSet source, Parameters expParams) {
    Parameters p = expParams == null ? new Parameters() : expParams.copy();
    p.addParameter().setName("valueSet").setResource(source);
    org.hl7.fhir.r4b.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand"),
          ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(),
          generateHeaders(), "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ValueSet) result.getPayload();
  }

  public Parameters lookupCode(Map<String, String> params) {
    org.hl7.fhir.r4b.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveOperationUri(CodeSystem.class, "lookup", params),
          getPreferredResourceFormat(), generateHeaders(), "CodeSystem/$lookup", TIMEOUT_NORMAL);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public ValueSet expandValueset(ValueSet source, Parameters expParams, Map<String, String> params) {
    Parameters p = expParams == null ? new Parameters() : expParams.copy();
    p.addParameter().setName("valueSet").setResource(source);
    for (String n : params.keySet()) {
      p.addParameter().setName(n).setValue(new StringType(params.get(n)));
    }
    org.hl7.fhir.r4b.utils.client.network.ResourceRequest<Resource> result = null;
    try {

      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand", params),
          ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(),
          generateHeaders(), "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ValueSet) result.getPayload();
  }

  public String getAddress() {
    return base;
  }

  public ConceptMap initializeClosure(String name) {
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(
          resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
          ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(), "Closure?name=" + name, TIMEOUT_NORMAL);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ConceptMap) result.getPayload();
  }

  public ConceptMap updateClosure(String name, Coding coding) {
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    params.addParameter().setName("concept").setValue(coding);
    org.hl7.fhir.r4b.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(
          resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
          ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat())),
          getPreferredResourceFormat(), generateHeaders(), "UpdateClosure?name=" + name, TIMEOUT_OPERATION);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ConceptMap) result.getPayload();
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

  public long getTimeout() {
    return client.getTimeout();
  }

  public void setTimeout(long timeout) {
    client.setTimeout(timeout);
  }

  public ToolingClientLogger getLogger() {
    return client.getLogger();
  }

  public void setLogger(ToolingClientLogger logger) {
    client.setLogger(logger);
  }

  public int getRetryCount() {
    return client.getRetryCount();
  }

  public void setRetryCount(int retryCount) {
    client.setRetryCount(retryCount);
  }

  public void setClientHeaders(ArrayList<Header> headers) {
    this.headers = headers;
  }

  private Headers generateHeaders() {
    Headers.Builder builder = new Headers.Builder();
    // Add basic auth header if it exists
    if (basicAuthHeaderExists()) {
      builder.add(getAuthorizationHeader().toString());
    }
    // Add any other headers
    if (this.headers != null) {
      this.headers.forEach(header -> builder.add(header.toString()));
    }
    if (!Utilities.noString(userAgent)) {
      builder.add("User-Agent: " + userAgent);
    }
    return builder.build();
  }

  public boolean basicAuthHeaderExists() {
    return (username != null) && (password != null);
  }

  public Header getAuthorizationHeader() {
    String usernamePassword = username + ":" + password;
    String base64usernamePassword = Base64.getEncoder().encodeToString(usernamePassword.getBytes());
    return new Header("Authorization", "Basic " + base64usernamePassword);
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getServerVersion() {
    return capabilities == null ? null : capabilities.getSoftware().getVersion();
  }

}
