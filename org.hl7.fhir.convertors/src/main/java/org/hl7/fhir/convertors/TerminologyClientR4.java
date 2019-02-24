package org.hl7.fhir.convertors;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.net.URISyntaxException;
import java.util.Map;

import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.HTMLClientLogger;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.TerminologyClient;

public class TerminologyClientR4 implements TerminologyClient {

  private FHIRToolingClient client; // todo: use the R2 client
  
  public TerminologyClientR4(String address) throws URISyntaxException {
    client = new FHIRToolingClient(address);
  }

  @Override
  public TerminologyCapabilities getTerminologyCapabilities() throws FHIRException {
    return (TerminologyCapabilities) org.hl7.fhir.convertors.conv40_50.TerminologyCapabilities.convertTerminologyCapabilities(client.getTerminologyCapabilities());
  }

  @Override
  public String getAddress() {
    return client.getAddress();
  }

  @Override
  public ValueSet expandValueset(ValueSet vs, Parameters p, Map<String, String> params) throws FHIRException {
    org.hl7.fhir.r4.model.ValueSet vs2 = (org.hl7.fhir.r4.model.ValueSet) VersionConvertor_40_50.convertResource(vs);
    org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) VersionConvertor_40_50.convertResource(p);
    vs2 = client.expandValueset(vs2, p2, params); // todo: second parameter
    return (ValueSet) VersionConvertor_40_50.convertResource(vs2);
  }

  @Override
  public Parameters validateCS(Parameters pin) throws FHIRException {
    org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) VersionConvertor_40_50.convertResource(pin);
    p2 = client.operateType(org.hl7.fhir.r4.model.CodeSystem.class, "validate-code", p2);
    return (Parameters) VersionConvertor_40_50.convertResource(p2);
  }

  @Override
  public Parameters validateVS(Parameters pin) throws FHIRException {
    org.hl7.fhir.r4.model.Parameters p2 = (org.hl7.fhir.r4.model.Parameters) VersionConvertor_40_50.convertResource(pin);
    p2 = client.operateType(org.hl7.fhir.r4.model.ValueSet.class, "validate-code", p2);
    return (Parameters) VersionConvertor_40_50.convertResource(p2);
  }

  @Override
  public void setTimeout(int i) {
    // ignored in this version - need to roll R4 internal changes back to R2 if desired
  }

  @Override
  public void setLogger(HTMLClientLogger txLog) {
    // ignored in this version - need to roll R4 internal changes back to R2 if desired
  }

  @Override
  public CapabilityStatement getCapabilitiesStatementQuick() throws FHIRException {
    return (CapabilityStatement) VersionConvertor_40_50.convertResource(client.getCapabilitiesStatementQuick());
  }

  @Override
  public Parameters lookupCode(Map<String, String> params) throws FHIRException {
    return (Parameters) VersionConvertor_40_50.convertResource(client.lookupCode(params));
  }
  
}
