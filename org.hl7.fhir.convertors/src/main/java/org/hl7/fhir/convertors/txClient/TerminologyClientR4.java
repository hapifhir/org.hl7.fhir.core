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
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.utils.client.network.ClientHeaders;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

public class TerminologyClientR4 implements ITerminologyClient {

  private final FHIRToolingClient client; // todo: use the R2 client
  private ClientHeaders clientHeaders;
  private String id;

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
    return FhirPublication.STU3;
  }
  
  
  @Override
  public TerminologyCapabilities getTerminologyCapabilities() throws FHIRException {
    return (TerminologyCapabilities) VersionConvertorFactory_40_50.convertResource(client.getTerminologyCapabilities());
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p, Map<String, String> params) throws FHIRException {
    org.hl7.fhir.r4.model.ValueSet vs2 = vs == null ? null : (org.hl7.fhir.r4.model.ValueSet) VersionConvertorFactory_40_50.convertResource(vs);
    org.hl7.fhir.r4.model.Parameters p2 = p == null ? null :  (org.hl7.fhir.r4.model.Parameters) VersionConvertorFactory_40_50.convertResource(p);
    if (params == null) {
      params = new HashMap<>();
    }
    try {
      vs2 = client.expandValueset(vs2, p2, params); // todo: second parameter
      return (ValueSet) VersionConvertorFactory_40_50.convertResource(vs2);
    } catch (org.hl7.fhir.r4.utils.client.EFhirClientException e) {
      if (e.getServerErrors().size() > 0) {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage(), (org.hl7.fhir.r5.model.OperationOutcome) VersionConvertorFactory_40_50.convertResource(e.getServerErrors().get(0)));
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage());        
      }
    }
  }

  @Override
  public Parameters validateCS(Parameters pin) throws FHIRException {
    try {
      org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) VersionConvertorFactory_40_50.convertResource(pin);
      p2 = client.operateType(org.hl7.fhir.r4.model.CodeSystem.class, "validate-code", p2);
      return (Parameters) VersionConvertorFactory_40_50.convertResource(p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) VersionConvertorFactory_40_50.convertResource(e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage(), e);        
      }
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public Parameters validateVS(Parameters pin) throws FHIRException {
    try {
      org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) VersionConvertorFactory_40_50.convertResource(pin);
      p2 = client.operateType(org.hl7.fhir.r4.model.ValueSet.class, "validate-code", p2);
      return (Parameters) VersionConvertorFactory_40_50.convertResource(p2);
    } catch (EFhirClientException e) {
      if (e.getServerErrors().size() == 1) {
        OperationOutcome op =  (OperationOutcome) VersionConvertorFactory_40_50.convertResource(e.getServerErrors().get(0));
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage(), op, e);
      } else {
        throw new org.hl7.fhir.r5.utils.client.EFhirClientException(e.getMessage(), e);        
      }
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public ITerminologyClient setTimeout(int i) {
    client.setTimeout(i);
    return this;
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
    return (CapabilityStatement) VersionConvertorFactory_40_50.convertResource(client.getCapabilitiesStatementQuick());
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) throws FHIRException {
    return (Parameters) VersionConvertorFactory_40_50.convertResource(client.lookupCode(params));
  }

  @Override
  public int getRetryCount() throws FHIRException {
    return client.getRetryCount();
  }

  @Override
  public Bundle validateBatch(Bundle batch) {
    org.hl7.fhir.r4.model.Bundle result = client.transaction((org.hl7.fhir.r4.model.Bundle) VersionConvertorFactory_40_50.convertResource(batch));
    return result == null ? null : (Bundle) VersionConvertorFactory_40_50.convertResource(result);
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
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_40_50.convertResource(r4);
    if (r5 == null) {
      throw new FHIRException("Unable to convert resource " + Utilities.pathURL(getAddress(), type, id) + " to R5 (internal representation)");
    }
    if (!(r5 instanceof CanonicalResource)) {
      throw new FHIRException("Unable to convert resource " + Utilities.pathURL(getAddress(), type, id) + " to R5 canonical resource (internal representation)");
    }
    return (CanonicalResource) r5;
  }

  @Override
  public ClientHeaders getClientHeaders() {
    return clientHeaders;
  }

  @Override
  public ITerminologyClient setClientHeaders(ClientHeaders clientHeaders) {
    this.clientHeaders = clientHeaders;
    if (this.clientHeaders != null) {
      this.client.setClientHeaders(this.clientHeaders.headers());
    }
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
  public ITerminologyClient setLanguage(String lang) {
    client.setLanguage(lang);
    return this;
  }
}