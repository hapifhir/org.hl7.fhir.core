package org.hl7.fhir.convertors.conv40_50;

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

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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

// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0


public class BiologicallyDerivedProduct extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r4.model.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasProductCategory())
      tgt.setProductCategory(convertBiologicallyDerivedProductCategory(src.getProductCategory()));
    if (src.hasProductCode())
      tgt.setProductCode(convertCodeableConcept(src.getProductCode()));
    if (src.hasStatus())
      tgt.setStatus(convertBiologicallyDerivedProductStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRequest())
      tgt.addRequest(convertReference(t));
    if (src.hasQuantity())
      tgt.setQuantityElement(convertInteger(src.getQuantityElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getParent())
      tgt.addParent(convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
    if (src.hasManipulation())
      tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
    for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorage())
      tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r5.model.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasProductCategory())
      tgt.setProductCategory(convertBiologicallyDerivedProductCategory(src.getProductCategory()));
    if (src.hasProductCode())
      tgt.setProductCode(convertCodeableConcept(src.getProductCode()));
    if (src.hasStatus())
      tgt.setStatus(convertBiologicallyDerivedProductStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRequest())
      tgt.addRequest(convertReference(t));
    if (src.hasQuantity())
      tgt.setQuantityElement(convertInteger(src.getQuantityElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getParent())
      tgt.addParent(convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
    if (src.hasManipulation())
      tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
    for (org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorage())
      tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory convertBiologicallyDerivedProductCategory(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ORGAN: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN;
    case TISSUE: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE;
    case FLUID: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID;
    case CELLS: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS;
    case BIOLOGICALAGENT: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT;
    default: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL;
  }
}

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory convertBiologicallyDerivedProductCategory(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ORGAN: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN;
    case TISSUE: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE;
    case FLUID: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID;
    case CELLS: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS;
    case BIOLOGICALAGENT: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT;
    default: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL;
  }
}

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus convertBiologicallyDerivedProductStatus(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AVAILABLE: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE;
    case UNAVAILABLE: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE;
    default: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus convertBiologicallyDerivedProductStatus(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AVAILABLE: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE;
    case UNAVAILABLE: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE;
    default: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    copyElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(convertReference(src.getCollector()));
    if (src.hasSource())
      tgt.setSource(convertReference(src.getSource()));
    if (src.hasCollected())
      tgt.setCollected(convertType(src.getCollected()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    copyElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(convertReference(src.getCollector()));
    if (src.hasSource())
      tgt.setSource(convertReference(src.getSource()));
    if (src.hasCollected())
      tgt.setCollected(convertType(src.getCollected()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasProcedure())
      tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
    if (src.hasAdditive())
      tgt.setAdditive(convertReference(src.getAdditive()));
    if (src.hasTime())
      tgt.setTime(convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasProcedure())
      tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
    if (src.hasAdditive())
      tgt.setAdditive(convertReference(src.getAdditive()));
    if (src.hasTime())
      tgt.setTime(convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasTime())
      tgt.setTime(convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasTime())
      tgt.setTime(convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasTemperature())
      tgt.setTemperatureElement(convertDecimal(src.getTemperatureElement()));
    if (src.hasScale())
      tgt.setScale(convertBiologicallyDerivedProductStorageScale(src.getScale()));
    if (src.hasDuration())
      tgt.setDuration(convertPeriod(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasTemperature())
      tgt.setTemperatureElement(convertDecimal(src.getTemperatureElement()));
    if (src.hasScale())
      tgt.setScale(convertBiologicallyDerivedProductStorageScale(src.getScale()));
    if (src.hasDuration())
      tgt.setDuration(convertPeriod(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FARENHEIT: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT;
    case CELSIUS: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS;
    case KELVIN: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN;
    default: return org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL;
  }
}

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FARENHEIT: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT;
    case CELSIUS: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS;
    case KELVIN: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN;
    default: return org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL;
  }
}


}
