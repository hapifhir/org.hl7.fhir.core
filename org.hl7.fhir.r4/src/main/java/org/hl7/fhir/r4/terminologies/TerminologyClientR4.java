package org.hl7.fhir.r4.terminologies;

import java.io.IOException;

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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.HTMLClientLogger;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.TerminologyCapabilities;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;

public class TerminologyClientR4 implements TerminologyClient {

  private FHIRToolingClient client;

  public TerminologyClientR4(String address, String userAgent) throws URISyntaxException {
    client = new FHIRToolingClient(address, userAgent);
  }

  @Override
  public TerminologyCapabilities getTerminologyCapabilities() {
    return client.getTerminologyCapabilities();
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p, Map<String, String> params) {
    return client.expandValueset(vs, p, params);
  }

  @Override
  public Parameters validateCS(Parameters pin) {
    try {
      return client.operateType(CodeSystem.class, "validate-code", pin);
    } catch (IOException e) {
     throw new FHIRException(e);
    }
  }

  @Override
  public Parameters validateVS(Parameters pin) {
    try {
      return client.operateType(ValueSet.class, "validate-code", pin);
    } catch (IOException e) {
      throw new FHIRException(e);
     }
  }

  @Override
  public void setTimeout(int i) {
    client.setTimeoutNormal(i); // #FIXME
  }

  @Override
  public void setLogger(HTMLClientLogger txLog) {
    client.setLogger(txLog);
  }

  @Override
  public CapabilityStatement getCapabilitiesStatementQuick() {
    return client.getCapabilitiesStatementQuick();
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) {
    return client.lookupCode(params);
  }

}