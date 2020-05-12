package org.hl7.fhir.convertors;

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



import java.net.URISyntaxException;
import java.util.Map;

import org.hl7.fhir.dstu3.utils.client.FHIRToolingClient;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.utils.client.ToolingClientLogger;

public class TerminologyClientR3 implements TerminologyClient {

  private FHIRToolingClient client; // todo: use the R2 client
  
  public TerminologyClientR3(String address) throws URISyntaxException {
    client = new FHIRToolingClient(address);
  }

  @Override
  public TerminologyCapabilities getTerminologyCapabilities() throws FHIRException {
    return (TerminologyCapabilities) VersionConvertor_30_50.convertTerminologyCapabilities(client.getTerminologyCapabilities(), false);
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p, Map<String, String> params) throws FHIRException {
    org.hl7.fhir.dstu3.model.ValueSet vs2 = (org.hl7.fhir.dstu3.model.ValueSet) VersionConvertor_30_50.convertResource(vs, false);
    org.hl7.fhir.dstu3.model.ExpansionProfile p2 = (org.hl7.fhir.dstu3.model.ExpansionProfile) VersionConvertor_30_50.convertResource(p, false);
    vs2 = client.expandValueset(vs2, p2, params); // todo: second parameter
    return (ValueSet) VersionConvertor_30_50.convertResource(vs2, false);
  }

  @Override
  public Parameters validateCS(Parameters pin) throws FHIRException {
    org.hl7.fhir.dstu3.model.Parameters p2 = (org.hl7.fhir.dstu3.model.Parameters) VersionConvertor_30_50.convertResource(pin, false);
    p2 = client.operateType(org.hl7.fhir.dstu3.model.CodeSystem.class, "validate-code", p2);
    return (Parameters) VersionConvertor_30_50.convertResource(p2, false);
  }

  @Override
  public Parameters validateVS(Parameters pin) throws FHIRException {
    org.hl7.fhir.dstu3.model.Parameters p2 = (org.hl7.fhir.dstu3.model.Parameters) VersionConvertor_30_50.convertResource(pin, false);
    p2 = client.operateType(org.hl7.fhir.dstu3.model.ValueSet.class, "validate-code", p2);
    return (Parameters) VersionConvertor_30_50.convertResource(p2, false);
  }

  @Override
  public void setTimeout(int i) {
    // ignored in this version - need to roll R4 internal changes back to R2 if desired
  }

  @Override
  public void setLogger(ToolingClientLogger txLog) {
    // ignored in this version - need to roll R4 internal changes back to R2 if desired
  }

  @Override
  public CapabilityStatement getCapabilitiesStatementQuick() throws FHIRException {
    return (CapabilityStatement) VersionConvertor_30_50.convertResource(client.getCapabilitiesStatementQuick(), false);
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) throws FHIRException {
    return (Parameters) VersionConvertor_30_50.convertResource(client.lookupCode(params), false);
  }
  
}