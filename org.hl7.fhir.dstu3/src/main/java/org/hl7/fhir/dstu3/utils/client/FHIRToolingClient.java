package org.hl7.fhir.dstu3.utils.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.CapabilityStatement;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.ConceptMap;
import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.dstu3.model.PrimitiveType;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.ValueSet;
import org.hl7.fhir.dstu3.utils.client.network.ByteUtils;
import org.hl7.fhir.dstu3.utils.client.network.Client;
import org.hl7.fhir.dstu3.utils.client.network.ResourceRequest;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FHIRBaseToolingClient;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

import org.hl7.fhir.utilities.http.HTTPHeader;

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
public class FHIRToolingClient extends FHIRBaseToolingClient {

  public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssK";
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String hostKey = "http.proxyHost";
  public static final String portKey = "http.proxyPort";

  private String base;
  private ResourceAddress resourceAddress;
  private ResourceFormat preferredResourceFormat;
  private int maxResultSetSize = -1;//_count
  private CapabilityStatement capabilities;
  private Client client = new Client();
  private List<HTTPHeader> headers = new ArrayList<>();
  @Setter
  @Getter
  private String userAgent;
  private EnumSet<FhirPublication> allowedVersions;
  @Setter
  @Getter
  private String acceptLanguage;
  @Setter
  private String contentLanguage;
  @Getter
  private int useCount;

  //Pass endpoint for client - URI
  public FHIRToolingClient(String baseServiceUrl, String userAgent) throws URISyntaxException {
    preferredResourceFormat = ResourceFormat.RESOURCE_XML;
    this.userAgent = userAgent;
    this.allowedVersions = supportableVersions();
    initialize(baseServiceUrl);
  }

  public void initialize(String baseServiceUrl) throws URISyntaxException {
    base = baseServiceUrl;
    client.setBase(base);
    resourceAddress = new ResourceAddress(baseServiceUrl);
    this.allowedVersions = supportableVersions();
    this.maxResultSetSize = -1;
  }

  public Client getClient() {
    return client;
  }

  public EnumSet<FhirPublication> supportableVersions() {
    // todo
    return EnumSet.range(FhirPublication.STU3, FhirPublication.R5);
  }
  
  public void setAllowedVersions(EnumSet<FhirPublication> versions) {
    // todo
  }
  
  public EnumSet<FhirPublication> getAllowedVersions() {
    return null; // todo
  }
  
  public FhirPublication getActualVersion() {
    return FhirPublication.STU3;
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

  public Parameters getTerminologyCapabilities() {
    Parameters capabilities = null;
    try {
      capabilities = (Parameters) client.issueGetResourceRequest(resourceAddress.resolveMetadataTxCaps(),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "TerminologyCapabilities",
        timeoutNormal).getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's terminology capabilities", e);
    }
    return capabilities;
  }

  public CapabilityStatement getCapabilitiesStatement() {
    CapabilityStatement conformance = null;
    try {
      conformance = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(false),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "CapabilitiesStatement",
        timeoutNormal).getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's conformance statement", e);
    }
    return conformance;
  }

  public CapabilityStatement getCapabilitiesStatementQuick() throws EFhirClientException {
    if (capabilities != null) return capabilities;
    try {
      capabilities = (CapabilityStatement) client.issueGetResourceRequest(resourceAddress.resolveMetadataUri(true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "CapabilitiesStatement-Quick",
        timeoutNormal).getReference();
    } catch (Exception e) {
      throw new FHIRException("Error fetching the server's capability statement: "+e.getMessage(), e);
    }
    return capabilities;
  }

  public <T extends Resource> T read(Class<T> resourceClass, String id) {//TODO Change this to AddressableResource
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "Read " + resourceClass.getName() + "/" + id,
        timeoutNormal);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T vread(Class<T> resourceClass, String id, String version) {
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndIdAndVersion(resourceClass, id, version),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "VRead " + resourceClass.getName() + "/" + id + "/?_history/" + version,
        timeoutNormal);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      throw new FHIRException("Error trying to read this version of the resource", e);
    }
    return result.getPayload();
  }

  public <T extends Resource> T getCanonical(Class<T> resourceClass, String canonicalURL) {
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveGetUriFromResourceClassAndCanonical(resourceClass, canonicalURL),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "Read " + resourceClass.getName() + "?url=" + canonicalURL,
        timeoutNormal);
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
    recordUse();
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePutRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resource.getClass(), resource.getId()),
        ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat()), false),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "Update " + resource.fhirType() + "/" + resource.getId(),
        timeoutOperation);
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
    recordUse();
    ResourceRequest<T> result = null;
    try {
      result = client.issuePutRequest(resourceAddress.resolveGetUriFromResourceClassAndId(resourceClass, id),
        ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat()), false),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "Update " + resource.fhirType() + "/" + id,
        timeoutOperation);
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
    recordUse();
    boolean complex = false;
    for (ParametersParameterComponent p : params.getParameter())
      complex = complex || !(p.getValue() instanceof PrimitiveType);
    String ps = "";
    try {
      if (!complex)
      for (ParametersParameterComponent p : params.getParameter())
        if (p.getValue() instanceof PrimitiveType)
          ps += Utilities.encodeUriParam(p.getName(), ((PrimitiveType<?>) p.getValue()).asStringValue()) + "&";
    ResourceRequest<T> result;
    URI url = resourceAddress.resolveOperationURLFromClass(resourceClass, name, ps);
    if (complex) {
      byte[] body = ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat()), true);
      if (client.getLogger() != null) {
        client.getLogger().logRequest("POST", url.toString(), null, body);
      }
      result = client.issuePostRequest(url, body, withVer(getPreferredResourceFormat(), "3.0"), generateHeaders(true),
          "POST " + resourceClass.getName() + "/$" + name, timeoutLong);
    } else {
      if (client.getLogger() != null) {
        client.getLogger().logRequest("GET", url.toString(), null, null);
      }
      result = client.issueGetResourceRequest(url, withVer(getPreferredResourceFormat(), "3.0"), generateHeaders(false), "GET " + resourceClass.getName() + "/$" + name, timeoutLong);
    }
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
  	  handleException("Error performing tx3 operation '"+name+": "+e.getMessage()+"' (parameters = \"" + ps+"\")", e);  		
    }
    return null;
  }


  public Bundle transaction(Bundle batch) {
    recordUse();
    Bundle transactionResult = null;
    try {
      transactionResult = client.postBatchRequest(resourceAddress.getBaseServiceUri(), ByteUtils.resourceToByteArray(batch, false, isJson(getPreferredResourceFormat()), false), withVer(getPreferredResourceFormat(), "3.0"), "transaction", timeoutOperation + (timeoutEntry * batch.getEntry().size()));
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
      result = client.issuePostRequest(resourceAddress.resolveValidateUri(resourceClass, id),
        ByteUtils.resourceToByteArray(resource, false, isJson(getPreferredResourceFormat()), false),
        withVer(getPreferredResourceFormat(), "3.0"), generateHeaders(true),
        "POST " + resourceClass.getName() + (id != null ? "/" + id : "") + "/$validate", timeoutLong);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (Exception e) {
      handleException("An error has occurred while trying to validate this resource", e);
    }
    return (OperationOutcome) result.getPayload();
  }

  /**
   * Helper method to prevent nesting of previously thrown EFhirClientExceptions. If the e param is an instance of
   * EFhirClientException, it will be rethrown. Otherwise, a new EFhirClientException will be thrown with e as the
   * cause.
   *

   * @param message The EFhirClientException message.
   * @param e The exception
   * @throws EFhirClientException EFhirClientException representing the exception.
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
   * @param format the format
   * @return true if the format is JSON, false otherwise
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
      feed = client.issueGetFeedRequest(new URI(url), getPreferredResourceFormat());
    } catch (Exception e) {
      handleException("An error has occurred while trying to read a bundle", e);
    }
    return feed;
  }

  public Parameters lookupCode(Map<String, String> params) {
    recordUse();
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issueGetResourceRequest(resourceAddress.resolveOperationUri(CodeSystem.class, "lookup", params),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(false),
        "CodeSystem/$lookup",
        timeoutNormal);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public Parameters lookupCode(Parameters p) {
    recordUse();
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(CodeSystem.class, "lookup"),
          ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat()), true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "CodeSystem/$lookup",
        timeoutNormal);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public Parameters transform(Parameters p) {
    recordUse();
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ConceptMap.class, "transform"),
          ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat()), true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "ConceptMap/$transform",
        timeoutNormal);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (result.isUnsuccessfulRequest()) {
      throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
    }
    return (Parameters) result.getPayload();
  }

  public ValueSet expandValueset(ValueSet source, Parameters expParams) {
    recordUse();
    Parameters p = expParams == null ? new Parameters() : expParams.copy();
    p.addParameter().setName("valueSet").setResource(source);
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(ValueSet.class, "expand"),
        ByteUtils.resourceToByteArray(p, false, isJson(getPreferredResourceFormat()), true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "ValueSet/$expand?url=" + source.getUrl(),
        timeoutExpand);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
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
    recordUse();
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat()), true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "Closure?name=" + name,
        timeoutNormal);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result == null ? null : (ConceptMap) result.getPayload();
  }

  public ConceptMap updateClosure(String name, Coding coding) {
    recordUse();
    Parameters params = new Parameters();
    params.addParameter().setName("name").setValue(new StringType(name));
    params.addParameter().setName("concept").setValue(coding);
    org.hl7.fhir.dstu3.utils.client.network.ResourceRequest<Resource> result = null;
    try {
      result = client.issuePostRequest(resourceAddress.resolveOperationUri(null, "closure", new HashMap<String, String>()),
        ByteUtils.resourceToByteArray(params, false, isJson(getPreferredResourceFormat()), true),
        withVer(getPreferredResourceFormat(), "3.0"),
        generateHeaders(true),
        "UpdateClosure?name=" + name,
        timeoutOperation);
      if (result.isUnsuccessfulRequest()) {
        throw new EFhirClientException("Server returned error code " + result.getHttpStatus(), (OperationOutcome) result.getPayload());
      }
    } catch (IOException e) {
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

  public void setClientHeaders(Iterable<HTTPHeader> headers) {
    this.headers =new ArrayList<>();
    headers.forEach(this.headers::add);
  }

  private Iterable<HTTPHeader> generateHeaders(boolean hasBody) {
    // Add any other headers
    List<HTTPHeader> headers = new ArrayList<>(this.headers);
    if (!Utilities.noString(userAgent)) {
      headers.add(new HTTPHeader("User-Agent",userAgent));
    }

    if (!Utilities.noString(acceptLanguage)) {
      headers.add(new HTTPHeader("Accept-Language", acceptLanguage));
    }

    if (hasBody && !Utilities.noString(contentLanguage)) {
      headers.add(new HTTPHeader("Content-Language",contentLanguage));
    }

    return headers;
  }

  public String getServerVersion() {
    checkCapabilities();
    return capabilities == null ? null : capabilities.getSoftware().getVersion();
  }

  private void recordUse() {
    useCount++;    
  }

  public Bundle search(String type, String criteria) {
    recordUse();
    return fetchFeed(Utilities.pathURL(base, type+criteria));
  }
  
}

