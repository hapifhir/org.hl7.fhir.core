package org.hl7.fhir.convertors.txClient;

import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.Map;

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


import org.hl7.fhir.convertors.conv10_50.resources10_50.TerminologyCapabilities10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.utils.client.FHIRToolingClient;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.utils.client.network.ClientHeaders;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

public class TerminologyClientR2 implements ITerminologyClient {

  private final FHIRToolingClient client; // todo: use the R2 client
  private String id;

  public EnumSet<FhirPublication> supportableVersions() {
    return EnumSet.of(FhirPublication.DSTU2);
  }
  
  public void setAllowedVersions(EnumSet<FhirPublication> versions) {
    boolean found = false;
    for (FhirPublication version : versions) {
      if (version == FhirPublication.DSTU2) {
        found = true;
      } else {
        throw new Error("Unsupported version for DSTU2 client: "+version.toCode());
      }
    }
    if (!found) {
      throw new Error("DSTU2 client only supports DSTU2");      
    }
  }
  
  public EnumSet<FhirPublication> getAllowedVersions() {
    return EnumSet.of(FhirPublication.DSTU2);
  }
  
  public FhirPublication getActualVersion() {
    return FhirPublication.DSTU2;
  }

  public TerminologyClientR2(String id, String address, String userAgent) throws URISyntaxException {
    client = new FHIRToolingClient(address, userAgent);
    this.client.setVersionInMimeTypes(true);
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public TerminologyCapabilities getTerminologyCapabilities() throws FHIRException {
    return TerminologyCapabilities10_50.convertTerminologyCapabilities(client.getTerminologyCapabilities());
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p, Map<String, String> params) throws FHIRException {
    org.hl7.fhir.dstu2.model.ValueSet vs2 = (org.hl7.fhir.dstu2.model.ValueSet) VersionConvertorFactory_10_50.convertResource(vs);
    org.hl7.fhir.dstu2.model.Parameters p2 = (org.hl7.fhir.dstu2.model.Parameters) VersionConvertorFactory_10_50.convertResource(p);
    vs2 = client.expandValueset(vs2, p2, params);
    return (ValueSet) VersionConvertorFactory_10_50.convertResource(vs2);
  }

  @Override
  public Parameters validateCS(Parameters pin) throws FHIRException {
    org.hl7.fhir.dstu2.model.Parameters p2 = (org.hl7.fhir.dstu2.model.Parameters) VersionConvertorFactory_10_50.convertResource(pin);
    p2 = client.operateType(org.hl7.fhir.dstu2.model.ValueSet.class, "validate-code", p2);
    return (Parameters) VersionConvertorFactory_10_50.convertResource(p2);
  }

  @Override
  public Parameters validateVS(Parameters pin) throws FHIRException {
    org.hl7.fhir.dstu2.model.Parameters p2 = (org.hl7.fhir.dstu2.model.Parameters) VersionConvertorFactory_10_50.convertResource(pin);
    p2 = client.operateType(org.hl7.fhir.dstu2.model.ValueSet.class, "validate-code", p2);
    return (Parameters) VersionConvertorFactory_10_50.convertResource(p2);
  }

  @Override
  public ITerminologyClient setTimeoutFactor(int i) {
    client.setTimeoutFactor(i);
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
    return (CapabilityStatement) VersionConvertorFactory_10_50.convertResource(client.getConformanceStatementQuick());
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) throws FHIRException {
    return (Parameters) VersionConvertorFactory_10_50.convertResource(client.lookupCode(params));
  }

  @Override
  public int getRetryCount() throws FHIRException {
    return client.getRetryCount();
  }

  @Override
  public Bundle validateBatch(Bundle batch) {
    return (Bundle) VersionConvertorFactory_10_50.convertResource(client.transaction((org.hl7.fhir.dstu2.model.Bundle) VersionConvertorFactory_10_50.convertResource(batch)));
  }

  @Override
  public CanonicalResource read(String type, String id) {
    Class<Resource> t;
    try {
      t = (Class<Resource>) Class.forName("org.hl7.fhir.dstu2.model." + type);// todo: do we have to deal with any resource renaming? Use cases are limited...
    } catch (ClassNotFoundException e) {
      throw new FHIRException("Unable to fetch resources of type " + type + " in R2");
    }
    org.hl7.fhir.dstu2.model.Resource r2 = client.read(t, id);
    if (r2 == null) {
      throw new FHIRException("Unable to fetch resource " + Utilities.pathURL(getAddress(), type, id));
    }
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_10_50.convertResource(r2);
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
    return null;
  }

  @Override
  public ITerminologyClient setClientHeaders(ClientHeaders clientHeaders) {
    return null;
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
}