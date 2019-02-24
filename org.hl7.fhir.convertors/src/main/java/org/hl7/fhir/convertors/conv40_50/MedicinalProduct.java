package org.hl7.fhir.convertors.conv40_50;

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


public class MedicinalProduct extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProduct convertMedicinalProduct(org.hl7.fhir.r4.model.MedicinalProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct tgt = new org.hl7.fhir.r5.model.MedicinalProduct();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDomain())
      tgt.setDomain(convertCoding(src.getDomain()));
    if (src.hasCombinedPharmaceuticalDoseForm())
      tgt.setCombinedPharmaceuticalDoseForm(convertCodeableConcept(src.getCombinedPharmaceuticalDoseForm()));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    if (src.hasAdditionalMonitoringIndicator())
      tgt.setAdditionalMonitoringIndicator(convertCodeableConcept(src.getAdditionalMonitoringIndicator()));
    for (org.hl7.fhir.r4.model.StringType t : src.getSpecialMeasures())
      tgt.getSpecialMeasures().add(convertString(t));
    if (src.hasPaediatricUseIndicator())
      tgt.setPaediatricUseIndicator(convertCodeableConcept(src.getPaediatricUseIndicator()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProductClassification())
      tgt.addProductClassification(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.MarketingStatus t : src.getMarketingStatus())
      tgt.addMarketingStatus(convertMarketingStatus(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPharmaceuticalProduct())
      tgt.addPharmaceuticalProduct(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPackagedMedicinalProduct())
      tgt.addPackagedMedicinalProduct(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAttachedDocument())
      tgt.addAttachedDocument(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getMasterFile())
      tgt.addMasterFile(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getContact())
      tgt.addContact(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getClinicalTrial())
      tgt.addClinicalTrial(convertReference(t));
    for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent t : src.getName())
      tgt.addName(convertMedicinalProductNameComponent(t));
    for (org.hl7.fhir.r4.model.Identifier t : src.getCrossReference())
      tgt.addCrossReference(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent t : src.getManufacturingBusinessOperation())
      tgt.addManufacturingBusinessOperation(convertMedicinalProductManufacturingBusinessOperationComponent(t));
    for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent t : src.getSpecialDesignation())
      tgt.addSpecialDesignation(convertMedicinalProductSpecialDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct convertMedicinalProduct(org.hl7.fhir.r5.model.MedicinalProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct tgt = new org.hl7.fhir.r4.model.MedicinalProduct();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDomain())
      tgt.setDomain(convertCoding(src.getDomain()));
    if (src.hasCombinedPharmaceuticalDoseForm())
      tgt.setCombinedPharmaceuticalDoseForm(convertCodeableConcept(src.getCombinedPharmaceuticalDoseForm()));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    if (src.hasAdditionalMonitoringIndicator())
      tgt.setAdditionalMonitoringIndicator(convertCodeableConcept(src.getAdditionalMonitoringIndicator()));
    for (org.hl7.fhir.r5.model.StringType t : src.getSpecialMeasures())
      tgt.getSpecialMeasures().add(convertString(t));
    if (src.hasPaediatricUseIndicator())
      tgt.setPaediatricUseIndicator(convertCodeableConcept(src.getPaediatricUseIndicator()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProductClassification())
      tgt.addProductClassification(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.MarketingStatus t : src.getMarketingStatus())
      tgt.addMarketingStatus(convertMarketingStatus(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPharmaceuticalProduct())
      tgt.addPharmaceuticalProduct(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPackagedMedicinalProduct())
      tgt.addPackagedMedicinalProduct(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAttachedDocument())
      tgt.addAttachedDocument(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getMasterFile())
      tgt.addMasterFile(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getContact())
      tgt.addContact(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getClinicalTrial())
      tgt.addClinicalTrial(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameComponent t : src.getName())
      tgt.addName(convertMedicinalProductNameComponent(t));
    for (org.hl7.fhir.r5.model.Identifier t : src.getCrossReference())
      tgt.addCrossReference(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent t : src.getManufacturingBusinessOperation())
      tgt.addManufacturingBusinessOperation(convertMedicinalProductManufacturingBusinessOperationComponent(t));
    for (org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent t : src.getSpecialDesignation())
      tgt.addSpecialDesignation(convertMedicinalProductSpecialDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameComponent convertMedicinalProductNameComponent(org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameComponent tgt = new org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameComponent();
    copyElement(src, tgt);
    if (src.hasProductName())
      tgt.setProductNameElement(convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent t : src.getNamePart())
      tgt.addNamePart(convertMedicinalProductNameNamePartComponent(t));
    for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent t : src.getCountryLanguage())
      tgt.addCountryLanguage(convertMedicinalProductNameCountryLanguageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent convertMedicinalProductNameComponent(org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent tgt = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent();
    copyElement(src, tgt);
    if (src.hasProductName())
      tgt.setProductNameElement(convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameNamePartComponent t : src.getNamePart())
      tgt.addNamePart(convertMedicinalProductNameNamePartComponent(t));
    for (org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent t : src.getCountryLanguage())
      tgt.addCountryLanguage(convertMedicinalProductNameCountryLanguageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameNamePartComponent convertMedicinalProductNameNamePartComponent(org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameNamePartComponent tgt = new org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameNamePartComponent();
    copyElement(src, tgt);
    if (src.hasPart())
      tgt.setPartElement(convertString(src.getPartElement()));
    if (src.hasType())
      tgt.setType(convertCoding(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent convertMedicinalProductNameNamePartComponent(org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameNamePartComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent tgt = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent();
    copyElement(src, tgt);
    if (src.hasPart())
      tgt.setPartElement(convertString(src.getPartElement()));
    if (src.hasType())
      tgt.setType(convertCoding(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent convertMedicinalProductNameCountryLanguageComponent(org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent tgt = new org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent();
    copyElement(src, tgt);
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction())
      tgt.setJurisdiction(convertCodeableConcept(src.getJurisdiction()));
    if (src.hasLanguage())
      tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent convertMedicinalProductNameCountryLanguageComponent(org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent tgt = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent();
    copyElement(src, tgt);
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction())
      tgt.setJurisdiction(convertCodeableConcept(src.getJurisdiction()));
    if (src.hasLanguage())
      tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent convertMedicinalProductManufacturingBusinessOperationComponent(org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent tgt = new org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent();
    copyElement(src, tgt);
    if (src.hasOperationType())
      tgt.setOperationType(convertCodeableConcept(src.getOperationType()));
    if (src.hasAuthorisationReferenceNumber())
      tgt.setAuthorisationReferenceNumber(convertIdentifier(src.getAuthorisationReferenceNumber()));
    if (src.hasEffectiveDate())
      tgt.setEffectiveDateElement(convertDateTime(src.getEffectiveDateElement()));
    if (src.hasConfidentialityIndicator())
      tgt.setConfidentialityIndicator(convertCodeableConcept(src.getConfidentialityIndicator()));
    for (org.hl7.fhir.r4.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    if (src.hasRegulator())
      tgt.setRegulator(convertReference(src.getRegulator()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent convertMedicinalProductManufacturingBusinessOperationComponent(org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent tgt = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent();
    copyElement(src, tgt);
    if (src.hasOperationType())
      tgt.setOperationType(convertCodeableConcept(src.getOperationType()));
    if (src.hasAuthorisationReferenceNumber())
      tgt.setAuthorisationReferenceNumber(convertIdentifier(src.getAuthorisationReferenceNumber()));
    if (src.hasEffectiveDate())
      tgt.setEffectiveDateElement(convertDateTime(src.getEffectiveDateElement()));
    if (src.hasConfidentialityIndicator())
      tgt.setConfidentialityIndicator(convertCodeableConcept(src.getConfidentialityIndicator()));
    for (org.hl7.fhir.r5.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    if (src.hasRegulator())
      tgt.setRegulator(convertReference(src.getRegulator()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent convertMedicinalProductSpecialDesignationComponent(org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent tgt = new org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasIntendedUse())
      tgt.setIntendedUse(convertCodeableConcept(src.getIntendedUse()));
    if (src.hasIndication())
      tgt.setIndication(convertType(src.getIndication()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasSpecies())
      tgt.setSpecies(convertCodeableConcept(src.getSpecies()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent convertMedicinalProductSpecialDesignationComponent(org.hl7.fhir.r5.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent tgt = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductSpecialDesignationComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasIntendedUse())
      tgt.setIntendedUse(convertCodeableConcept(src.getIntendedUse()));
    if (src.hasIndication())
      tgt.setIndication(convertType(src.getIndication()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasSpecies())
      tgt.setSpecies(convertCodeableConcept(src.getSpecies()));
    return tgt;
  }


}
