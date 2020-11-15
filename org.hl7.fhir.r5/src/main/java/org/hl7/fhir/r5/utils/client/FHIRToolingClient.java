package org.hl7.fhir.r5.utils.client;

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

import org.apache.http.HttpHost;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.utils.client.network.ByteUtils;
import org.hl7.fhir.r5.utils.client.network.Client;
import org.hl7.fhir.r5.utils.client.network.ResourceRequest;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Very Simple RESTful client. This is purely for use in the standalone
 * tools jar packages. It doesn't support many features, only what the tools
 * need.
 * <p>
 * To use, initialize class and set base service URI as follows:
 *
 * <pre><code>
 * FHIRSimpleClient fhirClient = new FHIRSimpleClient();
 * fhirClient.initialize("http://my.fhir.domain/myServiceRoot");
 * </code></pre>
 * <p>
 * Default Accept and Content-Type headers are application/fhir+xml and application/fhir+json.
 * <p>
 * These can be changed by invoking the following setter functions:
 *
 * <pre><code>
 * setPreferredResourceFormat()
 * setPreferredFeedFormat()
 * </code></pre>
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

  private static final long TIMEOUT_NORMAL_MILLIS = 1500;

  private static final int TIMEOUT_NORMAL = 1500;
  private static final int TIMEOUT_OPERATION = 30000;
  private static final int TIMEOUT_OPERATION_LONG = 60000;
  private static final int TIMEOUT_OPERATION_EXPAND = 120000;

  private String base;
  private ResourceAddress resourceAddress;
  private ResourceFormat preferredResourceFormat;
  private int maxResultSetSize = -1;//_count
  private CapabilityStatement capabilities;

  //private ClientUtils utils = new ClientUtils();

  //TODO temp
  private Client client = new Client();

  //Pass enpoint for client - URI
  public FHIRToolingClient(String baseServiceUrl) throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
    detectProxy();
    initialize(baseServiceUrl);
  }

  public FHIRToolingClient(String baseServiceUrl, String username, String password) throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
//    utils.setUsername(username);
//    utils.setPassword(password);
    detectProxy();
    initialize(baseServiceUrl);

    client.setUsername(username);
    client.setPassword(password);

  }

  public void configureProxy(String proxyHost, int proxyPort) {
//    utils.setProxy(new HttpHost(proxyHost, proxyPort));

//    client.setProxy(new HttpHost(proxyHost, proxyPort));
  }

  public void detectProxy() {
    String host = System.getenv(hostKey);
    String port = System.getenv(portKey);

    if (host == null) {
      host = System.getProperty(hostKey);
    }

    if (port == null) {
      port = System.getProperty(portKey);
    }

    if (host != null && port != null) {
      this.configureProxy(host, Integer.parseInt(port));
    }
  }

  public void initialize(String baseServiceUrl) throws URISyntaxException {
    base = baseServiceUrl;
    resourceAddress = new ResourceAddress(baseServiceUrl);
    this.maxResultSetSize = -1;
    checkCapabilities();
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
        getPreferredResourceFormat(), "TerminologyCapabilities", TIMEOUT_NORMAL_MILLIS).getReference();
    } catch (Exception e) {
      handleException("An error has occurred while trying to fetch the server's terminology capabilities", e);
    }
    return capabilities;
    //return (TerminologyCapabilities) utils.issueGetResourceRequest(resourceAddress.resolveMetadataTxCaps(), getPreferredResourceFormat(), "TerminologyCapabilities", TIMEOUT_NORMAL).getReference();
  }

  public CapabilityStatement getCapabilitiesStatement() {
    CapabilityStatement conformance = null;
    try {
      conformance = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(false),
        getPreferredResourceFormat(), "CapabilitiesStatement", TIMEOUT_NORMAL_MILLIS).getReference();
//      conformance = (CapabilityStatement) utils.issueGetResourceRequest(resourceAddress.resolveMetadataUri(false), getPreferredResourceFormat(), "CapabilitiesStatement", TIMEOUT_NORMAL).getReference();
    } catch (Exception e) {
      handleException("An error has occurred while trying to fetch the server's conformance statement", e);
    }
    return conformance;
  }

  public CapabilityStatement getCapabilitiesStatementQuick() throws EFhirClientException {
    if (capabilities != null) return capabilities;
    try {
      capabilities = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(true),
        getPreferredResourceFormat(), "CapabilitiesStatement-Quick", TIMEOUT_NORMAL_MILLIS).getReference();
//      capabilities = (CapabilityStatement) utils.issueGetResourceRequest(resourceAddress.resolveMetadataUri(true), getPreferredResourceFormat(), "CapabilitiesStatement-Quick", TIMEOUT_NORMAL).getReference();
    } catch (Exception e) {
      handleException("An error has occurred while trying to fetch the server's conformance statement", e);
    }
    return capabilities;
  }

  public <T extends Resource> T read(Class<T> resourceClass, String id) {//TODO Change this to AddressableResource
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
        getPreferredResourceFormat(), "Read " + resourceClass.getName() + "/" + id, TIMEOUT_NORMAL_MILLIS);
//      result = utils.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id), getPreferredResourceFormat(), "Read " + resourceClass.getName() + "/" + id, TIMEOUT_NORMAL);
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addSuccessStatus(200);//Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to read this resource", e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T vread(Class<T> resourceClass, String id, String version) {
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndIdAndVersion(resourceClass, id, version),
        getPreferredResourceFormat(), "VRead " + resourceClass.getName() + "/" + id + "/?_history/" + version, TIMEOUT_NORMAL_MILLIS);
//      result = utils.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndIdAndVersion(resourceClass, id, version), getPreferredResourceFormat(), "VRead " + resourceClass.getName() + "/" + id + "/?_history/" + version, TIMEOUT_NORMAL);
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addErrorStatus(405);//unknown
      result.addSuccessStatus(200);//Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to read this version of the resource", e);
    }
    return result.getPayload();
  }

  // GET fhir/ValueSet?url=http://hl7.org/fhir/ValueSet/clinical-findings&version=0.8

  public <T extends Resource> T getCanonical(Class<T> resourceClass, String canonicalURL) {
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndCanonical(resourceClass, canonicalURL),
        getPreferredResourceFormat(), "Read " + resourceClass.getName() + "?url=" + canonicalURL, TIMEOUT_NORMAL_MILLIS);
//      result = utils.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndCanonical(resourceClass, canonicalURL), getPreferredResourceFormat(), "Read " + resourceClass.getName() + "?url=" + canonicalURL, TIMEOUT_NORMAL);
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addErrorStatus(405);//unknown
      result.addSuccessStatus(200);//Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
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
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePutRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resource.getClass(), resource.getId()),
        ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(),
        "Update " + resource.fhirType() + "/" + resource.getId(), TIMEOUT_OPERATION);
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addErrorStatus(405);
      result.addErrorStatus(422);//Unprocessable Entity
      result.addSuccessStatus(200);
      result.addSuccessStatus(201);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new EFhirClientException("An error has occurred while trying to update this resource", e);
    }
    // TODO oe 26.1.2015 could be made nicer if only OperationOutcome locationheader is returned with an operationOutcome would be returned (and not  the resource also) we make another read
    try {
      OperationOutcome operationOutcome = (OperationOutcome) result.getPayload();
      ResourceAddress.ResourceVersionedIdentifier resVersionedIdentifier = ResourceAddress.parseCreateLocation(result.getLocation());
      return this.vread(resource.getClass(), resVersionedIdentifier.getId(), resVersionedIdentifier.getVersionId());
    } catch (ClassCastException e) {
      // if we fall throught we have the correct type already in the create
    }

    return result.getPayload();
  }

  public <T extends Resource> T update(Class<T> resourceClass, T resource, String id) {
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result = null;
    try {
      result = client.issuePutRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
        ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())),
        getPreferredResourceFormat(),"Update " + resource.fhirType() + "/" + id, TIMEOUT_OPERATION);
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addErrorStatus(405);
      result.addErrorStatus(422);//Unprocessable Entity
      result.addSuccessStatus(200);
      result.addSuccessStatus(201);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new EFhirClientException("An error has occurred while trying to update this resource", e);
    }
    // TODO oe 26.1.2015 could be made nicer if only OperationOutcome	locationheader is returned with an operationOutcome would be returned (and not	the resource also) we make another read
    try {
      OperationOutcome operationOutcome = (OperationOutcome) result.getPayload();
      ResourceAddress.ResourceVersionedIdentifier resVersionedIdentifier = ResourceAddress.parseCreateLocation(result.getLocation());
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
    Parameters searchResults = null;
    String ps = "";
    try {
      if (!complex)
        for (ParametersParameterComponent p : params.getParameter())
          if (p.getValue() instanceof PrimitiveType)
            ps += p.getName() + "=" + Utilities.encodeUri(((PrimitiveType) p.getValue()).asStringValue()) + "&";
      org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result;
      if (complex) {
        result = client.issuePostRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps), ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(),
          "POST " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
//        result = utils.issuePostRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps), utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(),
//          "POST " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
      } else {
        result = client.issueGetResourceRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps), getPreferredResourceFormat(), "GET " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
//        result = utils.issueGetResourceRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps), getPreferredResourceFormat(), "GET " + resourceClass.getName() + "/$" + name, TIMEOUT_OPERATION_LONG);
      }
      result.addErrorStatus(410);//gone
      result.addErrorStatus(404);//unknown
      result.addSuccessStatus(200);//Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
      if (result.getPayload() instanceof Parameters) {
        return (Parameters) result.getPayload();
      } else {
        Parameters p_out = new Parameters();
        p_out.addParameter().setName("return").setResource(result.getPayload());
        return p_out;
      }
    } catch (Exception e) {
      handleException("Error performing operation '" + name + "' with parameters " + ps, e);
    }
    return null;
  }


  public Bundle transaction(Bundle batch) {
    Bundle transactionResult = null;
    try {
      transactionResult = client.postBatchRequest(resourceAddress.getBaseServiceUri(), ByteUtils.resourceToByteArray(batch, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), "transaction", TIMEOUT_NORMAL + batch.getEntry().size());
//      transactionResult = utils.postBatchRequest(resourceAddress.getBaseServiceUri(), utils.getFeedAsByteArray(batch, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), "transaction", TIMEOUT_NORMAL + batch.getEntry().size());
    } catch (Exception e) {
      handleException("An error occurred trying to process this transaction request", e);
    }
    return transactionResult;
  }

  @SuppressWarnings("unchecked")
  public <T extends Resource> OperationOutcome validate(Class<T> resourceClass, T resource, String id) {
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<T> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveValidateUri(resourceClass, id), ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), "POST " + resourceClass.getName() + (id != null ? "/" + id : "") + "/$validate", TIMEOUT_OPERATION_LONG);
      result.addErrorStatus(400);//gone
      result.addErrorStatus(422);//Unprocessable Entity
      result.addSuccessStatus(200);//OK
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
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
   * Helper method to determine whether desired resource representation
   * is Json or XML.
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
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand"),
        ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), null, "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);

//    ResourceRequest<Resource> result = utils.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand"),
//      utils.getResourceAsByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), headers, "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);
    result.addErrorStatus(410);//gone
    result.addErrorStatus(404);//unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);//Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ValueSet) result.getPayload();
  }


  public Parameters lookupCode(Map<String, String> params) {
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveOperationUri(CodeSystem.class, "lookup", params), getPreferredResourceFormat(), "CodeSystem/$lookup", TIMEOUT_NORMAL);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
//    ResourceRequest<Resource> result = utils.issueGetResourceRequest(resourceAddress.resolveOperationUri(CodeSystem.class, "lookup", params), getPreferredResourceFormat(), "CodeSystem/$lookup", TIMEOUT_NORMAL);
    result.addErrorStatus(410);//gone
    result.addErrorStatus(404);//unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);//Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public ValueSet expandValueset(ValueSet source, Parameters expParams, Map<String, String> params) {
    Parameters p = expParams == null ? new Parameters() : expParams.copy();
    p.addParameter().setName("valueSet").setResource(source);
    for (String n : params.keySet()) {
      p.addParameter().setName(n).setValue(new StringType(params.get(n)));
    }
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand", params),
        ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), null, "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);

//    ResourceRequest<Resource> result = utils.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand", params),
//      utils.getResourceAsByteArray(p, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), headers, "ValueSet/$expand?url=" + source.getUrl(), TIMEOUT_OPERATION_EXPAND);
    result.addErrorStatus(410);//gone
    result.addErrorStatus(404);//unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);//Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    } catch (MalformedURLException e) {
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
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), null, "Closure?name=" + name, TIMEOUT_NORMAL);

//    ResourceRequest<Resource> result = utils.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
//      utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), headers, "Closure?name=" + name, TIMEOUT_NORMAL);
    result.addErrorStatus(410);//gone
    result.addErrorStatus(404);//unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);//Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ConceptMap) result.getPayload();
  }

  public ConceptMap updateClosure(String name, Coding coding) {
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    params.addParameter().setName("concept").setValue(coding);
    org.hl7.fhir.r5.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), null, "UpdateClosure?name=" + name, TIMEOUT_OPERATION);

//    ResourceRequest<Resource> result = utils.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
//      utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())), getPreferredResourceFormat(), headers, "UpdateClosure?name=" + name, TIMEOUT_OPERATION);
    result.addErrorStatus(410);//gone
    result.addErrorStatus(404);//unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);//Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ConceptMap) result.getPayload();
  }

  public long getTimeout() {
    return client.getTimeout();
  }

  public void setTimeout(long timeout) {
    client.setTimeout(timeout);
  }
//
//  public String getUsername() {
//    return utils.getUsername();
//  }
//
//  public void setUsername(String username) {
//    utils.setUsername(username);
//  }
//
//  public String getPassword() {
//    return utils.getPassword();
//  }
//
//  public void setPassword(String password) {
//    utils.setPassword(password);
//  }

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


}

