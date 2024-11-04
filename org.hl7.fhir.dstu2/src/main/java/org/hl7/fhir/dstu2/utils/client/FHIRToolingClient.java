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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Coding;
import org.hl7.fhir.dstu2.model.ConceptMap;
import org.hl7.fhir.dstu2.model.Conformance;
import org.hl7.fhir.dstu2.model.OperationOutcome;
import org.hl7.fhir.dstu2.model.Parameters;
import org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.dstu2.model.PrimitiveType;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.utilities.FHIRBaseToolingClient;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

/**
 * Very Simple RESTful client. This is purely for use in the standalone tools
 * jar packages. It doesn't support many features, only what the tools need.
 * 
 * To use, initialize class and set base service URI as follows:
 * 
 * <pre>
 * <code>
 * FHIRSimpleClient fhirClient = new FHIRSimpleClient();
 * fhirClient.initialize("http://my.fhir.domain/myServiceRoot");
 * </code>
 * </pre>
 * 
 * Default Accept and Content-Type headers are application/xml+fhir and
 * application/j+fhir.
 * 
 * These can be changed by invoking the following setter functions:
 * 
 * <pre>
 * <code>
 * setPreferredResourceFormat()
 * setPreferredFeedFormat()
 * </code>
 * </pre>
 * 
 * TODO Review all sad paths.
 * 
 * @author Claude Nanjo
 *
 */
public class FHIRToolingClient extends FHIRBaseToolingClient {

  public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssK";
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String hostKey = "http.proxyHost";
  public static final String portKey = "http.proxyPort";

  private String base;
  private ResourceAddress resourceAddress;
  private ResourceFormat preferredResourceFormat;
  private HttpHost proxy;
  private int maxResultSetSize = -1;// _count
  private Conformance conf;
  private ClientUtils utils = null;
  private int useCount;

  protected ClientUtils getClientUtils() {
    return new ClientUtils();
  }

  // Pass enpoint for client - URI
  public FHIRToolingClient(String baseServiceUrl, String userAgent) throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
    utils = getClientUtils();
    utils.setUserAgent(userAgent);
    initialize(baseServiceUrl);
  }

  public FHIRToolingClient(String baseServiceUrl, String userAgent, String username, String password)
      throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
    utils = getClientUtils();
    utils.setUserAgent(userAgent);
    utils.setUsername(username);
    utils.setPassword(password);
    initialize(baseServiceUrl);
  }





  public void initialize(String baseServiceUrl) throws URISyntaxException {
    base = baseServiceUrl;
    resourceAddress = new ResourceAddress(baseServiceUrl);
    this.maxResultSetSize = -1;
    checkConformance();
  }

  private void checkConformance() {
    try {
      conf = getConformanceStatementQuick();
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

  public Conformance getConformanceStatement() throws EFhirClientException {
    if (conf != null)
      return conf;
    return getConformanceStatement(false);
  }

  public Conformance getConformanceStatement(boolean useOptionsVerb) {
    Conformance conformance = null;
    try {
      if (useOptionsVerb) {
        conformance = (Conformance) utils
            .issueOptionsRequest(resourceAddress.getBaseServiceUri(), withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal)
            .getReference();// TODO fix this
      } else {
        conformance = (Conformance) utils.issueGetResourceRequest(resourceAddress.resolveMetadataUri(false),
            withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal).getReference();
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to fetch the server's conformance statement", e);
    }
    return conformance;
  }

  public Conformance getConformanceStatementQuick() throws EFhirClientException {
    if (conf != null)
      return conf;
    return getConformanceStatementQuick(false);
  }

  public Conformance getConformanceStatementQuick(boolean useOptionsVerb) {
    Conformance conformance = null;
    try {
      if (useOptionsVerb) {
        conformance = (Conformance) utils
            .issueOptionsRequest(resourceAddress.getBaseServiceUri(), withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal)
            .getReference();// TODO fix this
      } else {
        conformance = (Conformance) utils.issueGetResourceRequest(resourceAddress.resolveMetadataUri(true),
            withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal).getReference();
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to fetch the server's conformance statement", e);
    }
    return conformance;
  }

  public <T extends Resource> T read(Class<T> resourceClass, String id) {// TODO Change this to AddressableResource
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = utils.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
          withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal);
      result.addErrorStatus(410);// gone
      result.addErrorStatus(404);// unknown
      result.addSuccessStatus(200);// Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to read this resource", e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T vread(Class<T> resourceClass, String id, String version) {
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = utils.issueGetResourceRequest(
          resourceAddress.resolveGetUriFromResourceClassAndIdAndVersion(resourceClass, id, version),
          withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal);
      result.addErrorStatus(410);// gone
      result.addErrorStatus(404);// unknown
      result.addErrorStatus(405);// unknown
      result.addSuccessStatus(200);// Only one for now
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
            (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to read this version of the resource", e);
    }
    return result.getPayload();
  }

  // GET
  // fhir/ValueSet?url=http://hl7.org/fhir/ValueSet/clinical-findings&version=0.8

  public <T extends Resource> T getCanonical(Class<T> resourceClass, String canonicalURL) {
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = utils.issueGetResourceRequest(
          resourceAddress.resolveGetUriFromResourceClassAndCanonical(resourceClass, canonicalURL),
          withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal);
      result.addErrorStatus(410);// gone
      result.addErrorStatus(404);// unknown
      result.addErrorStatus(405);// unknown
      result.addSuccessStatus(200);// Only one for now
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
    recordUse();
    ResourceRequest<Resource> result = null;
    try {

      result = utils.issuePutRequest(
          resourceAddress.resolveGetUriFromResourceClassAndId(resource.getClass(), resource.getId()),
          utils.getResourceAsByteArray(resource, false, isJson(getPreferredResourceFormat())),
          withVer(getPreferredResourceFormat(), "1.0"), null, timeoutOperation);
      result.addErrorStatus(410);// gone
      result.addErrorStatus(404);// unknown
      result.addErrorStatus(405);
      result.addErrorStatus(422);// Unprocessable Entity
      result.addSuccessStatus(200);
      result.addSuccessStatus(201);
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
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = utils.issuePutRequest(
        resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
          utils.getResourceAsByteArray(resource, false, isJson(getPreferredResourceFormat())),
          withVer(getPreferredResourceFormat(), "1.0"),
        null,
        timeoutOperation);
      result.addErrorStatus(410);// gone
      result.addErrorStatus(404);// unknown
      result.addErrorStatus(405);
      result.addErrorStatus(422);// Unprocessable Entity
      result.addSuccessStatus(200);
      result.addSuccessStatus(201);
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
      // if we fall throught we have the correct type already in the create
    }

    return result.getPayload();
  }



  public <T extends Resource> Parameters operateType(Class<T> resourceClass, String name, Parameters params) {
    recordUse();
    boolean complex = false;
    for (ParametersParameterComponent p : params.getParameter())
      complex = complex || !(p.getValue() instanceof PrimitiveType);
    Parameters searchResults = null;
    String ps = "";
    if (!complex)
      for (ParametersParameterComponent p : params.getParameter())
        if (p.getValue() instanceof PrimitiveType)
          ps += p.getName() + "=" + Utilities.encodeUri(((PrimitiveType) p.getValue()).asStringValue()) + "&";
    ResourceRequest<T> result;
    if (complex)
      result = utils.issuePostRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps),
          utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())),
          withVer(getPreferredResourceFormat(), "1.0"), timeoutLong);
    else
      result = utils.issueGetResourceRequest(resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps),
          withVer(getPreferredResourceFormat(), "1.0"), timeoutLong);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addSuccessStatus(200);// Only one for now
    if (result.isUnsuccessfulRequest())
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    if (result.getPayload() instanceof Parameters)
      return (Parameters) result.getPayload();
    else {
      Parameters p_out = new Parameters();
      p_out.addParameter().setName("return").setResource(result.getPayload());
      return p_out;
    }
  }

  public Bundle transaction(Bundle batch) {
    recordUse();
    Bundle transactionResult = null;
    try {
      transactionResult = utils.postBatchRequest(resourceAddress.getBaseServiceUri(),
          utils.getFeedAsByteArray(batch, false, isJson(getPreferredResourceFormat())), withVer(getPreferredResourceFormat(), "1.0"),
          timeoutNormal + batch.getEntry().size());
    } catch (Exception e) {
      handleException("An error occurred trying to process this transaction request", e);
    }
    return transactionResult;
  }

  @SuppressWarnings("unchecked")
  public <T extends Resource> OperationOutcome validate(Class<T> resourceClass, T resource, String id) {
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = utils.issuePostRequest(resourceAddress.resolveValidateUri(resourceClass, id),
          utils.getResourceAsByteArray(resource, false, isJson(getPreferredResourceFormat())),
          withVer(getPreferredResourceFormat(), "1.0"), 3);
      result.addErrorStatus(400);// gone
      result.addErrorStatus(422);// Unprocessable Entity
      result.addSuccessStatus(200);// OK
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
    recordUse();
    Bundle feed = null;
    try {
      feed = utils.issueGetFeedRequest(new URI(url), getPreferredResourceFormat());
    } catch (Exception e) {
      handleException("An error has occurred while trying to retrieve history since last update", e);
    }
    return feed;
  }

  public Parameters lookupCode(Map<String, String> params) {
    recordUse();
    ResourceRequest<Resource> result = utils.issueGetResourceRequest(
        resourceAddress.resolveOperationUri(ValueSet.class, "lookup", params), withVer(getPreferredResourceFormat(), "1.0"),
        timeoutNormal);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);// Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public Parameters lookupCode(Parameters p) {
    recordUse();
    ResourceRequest<Resource> result = utils.issuePostRequest(
        resourceAddress.resolveOperationUri(ValueSet.class, "lookup"), 
        utils.getResourceAsByteArray(p, false, isJson(getPreferredResourceFormat())),
        withVer(getPreferredResourceFormat(), "1.0"), 
        timeoutNormal);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);// Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public Parameters translate(Parameters p) {
    recordUse();
    ResourceRequest<Resource> result = utils.issuePostRequest(
        resourceAddress.resolveOperationUri(ConceptMap.class, "translate"), 
        utils.getResourceAsByteArray(p, false, isJson(getPreferredResourceFormat())),
        withVer(getPreferredResourceFormat(), "1.0"), 
        timeoutNormal);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);// Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public ValueSet expandValueset(ValueSet source, Parameters expParams) {
    recordUse();

    Parameters p = expParams == null ? new Parameters() : expParams.copy();
    p.addParameter().setName("valueSet").setResource(source);
    ResourceRequest<Resource> result = utils.issuePostRequest(
        resourceAddress.resolveOperationUri(ValueSet.class, "expand"),
        utils.getResourceAsByteArray(p, false, isJson(getPreferredResourceFormat())), withVer(getPreferredResourceFormat(), "1.0"),
        null, 4);
    result.addErrorStatus(410); // gone
    result.addErrorStatus(404); // unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422); // Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (ValueSet) result.getPayload();
  }

  public String getAddress() {
    return base;
  }

  public ConceptMap initializeClosure(String name) {
    recordUse();
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));

    ResourceRequest<Resource> result = utils.issuePostRequest(
        resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())), withVer(getPreferredResourceFormat(), "1.0"),
        null, timeoutNormal);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);// Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (ConceptMap) result.getPayload();
  }

  public ConceptMap updateClosure(String name, Coding coding) {
    recordUse();
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    params.addParameter().setName("concept").setValue(coding);

    ResourceRequest<Resource> result = utils.issuePostRequest(
        resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        utils.getResourceAsByteArray(params, false, isJson(getPreferredResourceFormat())), withVer(getPreferredResourceFormat(), "1.0"),
        null, timeoutOperation);
    result.addErrorStatus(410);// gone
    result.addErrorStatus(404);// unknown
    result.addErrorStatus(405);
    result.addErrorStatus(422);// Unprocessable Entity
    result.addSuccessStatus(200);
    result.addSuccessStatus(201);
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(),
          (OperationOutcome) result.getPayload());
    }
    return (ConceptMap) result.getPayload();
  }

  public int getTimeout() {
    return utils.getTimeout();
  }

  public void setTimeout(int timeout) {
    utils.setTimeout(timeout);
  }

  public String getUsername() {
    return utils.getUsername();
  }

  public void setUsername(String username) {
    utils.setUsername(username);
  }

  public String getPassword() {
    return utils.getPassword();
  }

  public void setPassword(String password) {
    utils.setPassword(password);
  }

  public Parameters getTerminologyCapabilities() {
    return (Parameters) utils
        .issueGetResourceRequest(resourceAddress.resolveMetadataTxCaps(), withVer(getPreferredResourceFormat(), "1.0"), timeoutNormal)
        .getReference();
  }

  public org.hl7.fhir.utilities.ToolingClientLogger getLogger() {
    return utils.getLogger();
  }

  public void setLogger(ToolingClientLogger logger) {
    utils.setLogger(logger);
  }

  public int getRetryCount() {
    return utils.getRetryCount();
  }

  public void setRetryCount(int retryCount) {
    utils.setRetryCount(retryCount);
  }

  public String getUserAgent() {
    return utils.getUserAgent();
  }

  public void setUserAgent(String userAgent) {
    utils.setUserAgent(userAgent);
  }

  public String getServerVersion() {
    return conf == null ? null : conf.getSoftware().getVersion();
  }

  public void setContentLanguage(String lang) {
    utils.setContentLanguage(lang);
  }

  public void setAcceptLanguage(String lang) {
    utils.setAcceptLanguage(lang);
  }

  public int getUseCount() {
    return useCount;
  }

  private void recordUse() {
    useCount++;    
  }

  public Bundle search(String type, String criteria) {
    recordUse();
    return fetchFeed(Utilities.pathURL(base, type+criteria));
  }
 
}