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


import org.hl7.fhir.exceptions.FHIRException;

public interface VersionConvertorAdvisor50 {
  boolean ignoreEntry(org.hl7.fhir.r5.model.Bundle.BundleEntryComponent src);

  // called ?
  org.hl7.fhir.dstu2.model.Resource convertR2(org.hl7.fhir.r5.model.Resource resource) throws FHIRException;
  org.hl7.fhir.dstu2016may.model.Resource convertR2016May(org.hl7.fhir.r5.model.Resource resource) throws FHIRException;
  org.hl7.fhir.dstu3.model.Resource convertR3(org.hl7.fhir.r5.model.Resource resource) throws FHIRException;
  org.hl7.fhir.r4.model.Resource convertR4(org.hl7.fhir.r5.model.Resource resource) throws FHIRException;

  // called when an r2 value set has a codeSystem in it
  void handleCodeSystem(org.hl7.fhir.r5.model.CodeSystem tgtcs, org.hl7.fhir.r5.model.ValueSet source) throws FHIRException;

  org.hl7.fhir.r5.model.CodeSystem getCodeSystem(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException;
}
