package org.hl7.fhir.convertors.txClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.utils.client.EFhirClientException;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.ITerminologyClientFactory;
import org.hl7.fhir.r5.utils.client.network.ClientHeaders;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPHeader;

public class TerminologyClientR4 implements ITerminologyClient {


  public static class TerminologyClientR4Factory implements ITerminologyClientFactory {

    @Override
    public ITerminologyClient makeClient(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
      return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent);
    }

    private String checkEndsWith(String term, String url) {
      if (url.endsWith(term))
        return url;
      if (Utilities.isTxFhirOrgServer(url)) {
        return Utilities.pathURL(url, term);
      }
      return url;
    }

    @Override
    public String getVersion() {
      return "4.0.1";
    }
  }
  
  private final FHIRToolingClient client; 
  private ClientHeaders clientHeaders;
  private String id;
  private ITerminologyConversionLogger logger;

  public TerminologyClientR4(String id, String address, String userAgent) throws URISyntaxException {
    this.client = new FHIRToolingClient(address, userAgent);
    setClientHeaders(new ClientHeaders());
    this.id = id;
  }

  public TerminologyClientR4(String id, String address, String userAgent, ClientHeaders clientHeaders) throws URISyntaxException {
    this.client = new FHIRToolingClient(address, userAgent);
    setClientHeaders(clientHeaders);
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
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
    return FhirPublication.R4;
  }
  
  
  @Override
  public TerminologyCapabilities getTerminologyCapabilities() throws FHIRException {
    return (TerminologyCapabilities) convertResource("getTerminologyCapabilities.response", client.getTerminologyCapabilities());
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p) throws FHIRException {
    org.hl7.fhir.r4.model.ValueSet vs2 = vs == null ? null : (org.hl7.fhir.r4.model.ValueSet) convertResource("expandValueset.valueset", vs);
    org.hl7.fhir.r4.model.Parameters p2 = p == null ? null :  (org.hl7.fhir.r4.model.Parameters) convertResource("expandValueset.parameters", p);
    try {
      vs2 = client.expandValueset(vs2, p2); // todo: second parameter
      return (ValueSet) convertResource("expandValueset.response", vs2);
    } catch (org.hl7.fhir.r4.utils.client.EFhirClientException e) {
      if (e.getServerErrors().size() > 0) {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), (org.hl7.fhir.r5.model.OperationOutcome) convertResource("expandValueset.error", e.getServerErrors().get(0)));
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage());        
      }
    }
  }


  @Override
  public Parameters validateCS(Parameters pin) throws FHIRException {
    try {
      org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) convertResource("validateCS.request", pin);
      p2 = client.operateType(org.hl7.fhir.r4.model.CodeSystem.class, "validate-code", p2);
      return (Parameters) convertResource("validateCS.response", p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) convertResource("validateCS.error", e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), e);        
      }
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }


  @Override
  public Parameters subsumes(Parameters pin) throws FHIRException {
    try {
      org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) convertResource("subsumes.request", pin);
      p2 = client.operateType(org.hl7.fhir.r4.model.CodeSystem.class, "subsumes", p2);
      return (Parameters) convertResource("subsumes.response", p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) convertResource("subsumes.error", e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), e);        
      }
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public Parameters validateVS(Parameters pin) throws FHIRException {
    try {
      org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) convertResource("validateVS.request", pin);
      p2 = client.operateType(org.hl7.fhir.r4.model.ValueSet.class, "validate-code", p2);
      return (Parameters) convertResource("validateVS.response", p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) convertResource("validateVS.error", e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), e);        
      }
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public ITerminologyClient setTimeoutFactor(int i) {
    client.setTimeoutFactor(i);
    return this;
  }

  @Override
  public ToolingClientLogger getLogger() {
    return client.getLogger();
  }

  @Override
  public ITerminologyClient setLogger(ToolingClientLogger txLog) {
    client.setLogger(txLog);
    return this;
  }

  @Override
  public ITerminologyClient setRetryCount(int retryCount) throws FHIRException {
    client.setRetryCount(retryCount);
    return this;
  }

  @Override
  public CapabilityStatement getCapabilitiesStatementQuick() throws FHIRException {
    return (CapabilityStatement) convertResource("getCapabilitiesStatementQuick.response", client.getCapabilitiesStatementQuick());
  }

  @Override
  public CapabilityStatement getCapabilitiesStatement() throws FHIRException {
    return (CapabilityStatement) convertResource("getCapabilitiesStatement.response", client.getCapabilitiesStatement());
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) throws FHIRException {
    return (Parameters) convertResource("lookupCode.response", client.lookupCode(params));
  }

  @Override
  public Parameters lookupCode(Parameters params) throws FHIRException {
    return (Parameters) convertResource("lookupCode.response", client.lookupCode((org.hl7.fhir.r4.model.Parameters) convertResource("lookupCode.request", params)));
  }

  @Override
  public int getRetryCount() throws FHIRException {
    return client.getRetryCount();
  }

  @Override
  public Bundle validateBatch(Bundle batch) {
    org.hl7.fhir.r4.model.Bundle result = client.transaction((org.hl7.fhir.r4.model.Bundle) convertResource("validateBatch.request", batch));
    return result == null ? null : (Bundle) convertResource("validateBatch.response", result);
  }

  @Override
  public CanonicalResource read(String type, String id) {
    Class<Resource> t;
    try {
      t = (Class<Resource>) Class.forName("org.hl7.fhir.r4.model." + type);// todo: do we have to deal with any resource renaming? Use cases are limited...
    } catch (ClassNotFoundException e) {
      throw new FHIRException("Unable to fetch resources of type " + type + " in R2");
    }
    org.hl7.fhir.r4.model.Resource r4 = client.read(t, id);
    if (r4 == null) {
      throw new FHIRException("Unable to fetch resource " + Utilities.pathURL(getAddress(), type, id));
    }
    org.hl7.fhir.r5.model.Resource r5 = convertResource("read.result", r4);
    if (r5 == null) {
      throw new FHIRException("Unable to convert resource " + Utilities.pathURL(getAddress(), type, id) + " to R5 (internal representation)");
    }
    if (!(r5 instanceof CanonicalResource)) {
      throw new FHIRException("Unable to convert resource " + Utilities.pathURL(getAddress(), type, id) + " to R5 canonical resource (internal representation)");
    }
    return (CanonicalResource) r5;
  }

  @Override
  public Iterable<HTTPHeader> getClientHeaders() {
    return clientHeaders.headers();
  }

  @Override
  public ITerminologyClient setClientHeaders(ClientHeaders clientHeaders) {
    this.clientHeaders = clientHeaders;
    if (this.clientHeaders != null) {
      this.client.setClientHeaders(this.clientHeaders.headers());
    }
    this.client.setVersionInMimeTypes(true);
    return this;
  }

  @Override
  public ITerminologyClient setUserAgent(String userAgent) {
    client.setUserAgent(userAgent);
    return this;
  }

  @Override
  public String getUserAgent() {
    return client.getUserAgent();
  }

  @Override
  public String getServerVersion() {
    return client.getServerVersion();
  }


  @Override
  public ITerminologyClient setAcceptLanguage(String lang) {
    client.setAcceptLanguage(lang);
    return this;
  }
  
  @Override
  public ITerminologyClient setContentLanguage(String lang) {
    client.setContentLanguage(lang);
    return this;
  }
  
  @Override
  public int getUseCount() {
    return client.getUseCount();
  }

  @Override
  public Bundle search(String type, String criteria) {    
    org.hl7.fhir.r4.model.Bundle result = client.search(type, criteria);
    return result == null ? null : (Bundle) convertResource("search.result", result);
  }

  @Override
  public Parameters translate(Parameters params) throws FHIRException {  
    return (Parameters) convertResource("translate.response", client.translate((org.hl7.fhir.r4.model.Parameters) convertResource("translate.request", params)));
  }

  private org.hl7.fhir.r4.model.Resource convertResource(String name, org.hl7.fhir.r5.model.Resource resource) {
    if (logger != null) {
      try {
        logger.log(name, resource.fhirType(), "r5", new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(resource));
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    }
    org.hl7.fhir.r4.model.Resource res = VersionConvertorFactory_40_50.convertResource(resource);
    if (logger != null) {
      try {
        logger.log(name, resource.fhirType(), "r4", new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).composeBytes(res));
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    }
    return res;
  }

  private org.hl7.fhir.r5.model.Resource convertResource(String name, org.hl7.fhir.r4.model.Resource resource) {
    if (logger != null && name != null) {
      try {
        logger.log(name, resource.fhirType(), "r4", new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).composeBytes(resource));
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    }
    org.hl7.fhir.r5.model.Resource res = VersionConvertorFactory_40_50.convertResource(resource);
    if (logger != null && name != null) {
      try {
        logger.log(name, resource.fhirType(), "r5", new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(res));
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    }
    return res;
  }

  @Override
  public void setConversionLogger(ITerminologyConversionLogger logger) {
    this.logger = logger;    
  }

  @Override
  public OperationOutcome validateResource(org.hl7.fhir.r5.model.Resource res) {
    try {
      org.hl7.fhir.r4.model.Resource r2 = convertResource("validate.request", res);
      Resource p2 = client.validate(r2, null);
      return (OperationOutcome) convertResource("validateVS.response", p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) convertResource("validateVS.error", e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getCode(), e.getMessage(), e);        
      }
    }
  }
  
}