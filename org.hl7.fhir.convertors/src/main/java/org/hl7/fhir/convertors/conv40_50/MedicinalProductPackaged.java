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


public class MedicinalProductPackaged extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductPackaged convertMedicinalProductPackaged(org.hl7.fhir.r4.model.MedicinalProductPackaged src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPackaged tgt = new org.hl7.fhir.r5.model.MedicinalProductPackaged();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    for (org.hl7.fhir.r4.model.MarketingStatus t : src.getMarketingStatus())
      tgt.addMarketingStatus(convertMarketingStatus(t));
    if (src.hasMarketingAuthorization())
      tgt.setMarketingAuthorization(convertReference(src.getMarketingAuthorization()));
    for (org.hl7.fhir.r4.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    for (org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent t : src.getBatchIdentifier())
      tgt.addBatchIdentifier(convertMedicinalProductPackagedBatchIdentifierComponent(t));
    for (org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent t : src.getPackageItem())
      tgt.addPackageItem(convertMedicinalProductPackagedPackageItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPackaged convertMedicinalProductPackaged(org.hl7.fhir.r5.model.MedicinalProductPackaged src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPackaged tgt = new org.hl7.fhir.r4.model.MedicinalProductPackaged();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    for (org.hl7.fhir.r5.model.MarketingStatus t : src.getMarketingStatus())
      tgt.addMarketingStatus(convertMarketingStatus(t));
    if (src.hasMarketingAuthorization())
      tgt.setMarketingAuthorization(convertReference(src.getMarketingAuthorization()));
    for (org.hl7.fhir.r5.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent t : src.getBatchIdentifier())
      tgt.addBatchIdentifier(convertMedicinalProductPackagedBatchIdentifierComponent(t));
    for (org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent t : src.getPackageItem())
      tgt.addPackageItem(convertMedicinalProductPackagedPackageItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent convertMedicinalProductPackagedBatchIdentifierComponent(org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent();
    copyElement(src, tgt);
    if (src.hasOuterPackaging())
      tgt.setOuterPackaging(convertIdentifier(src.getOuterPackaging()));
    if (src.hasImmediatePackaging())
      tgt.setImmediatePackaging(convertIdentifier(src.getImmediatePackaging()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent convertMedicinalProductPackagedBatchIdentifierComponent(org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedBatchIdentifierComponent();
    copyElement(src, tgt);
    if (src.hasOuterPackaging())
      tgt.setOuterPackaging(convertIdentifier(src.getOuterPackaging()));
    if (src.hasImmediatePackaging())
      tgt.setImmediatePackaging(convertIdentifier(src.getImmediatePackaging()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent convertMedicinalProductPackagedPackageItemComponent(org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMaterial())
      tgt.addMaterial(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAlternateMaterial())
      tgt.addAlternateMaterial(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getManufacturedItem())
      tgt.addManufacturedItem(convertReference(t));
    for (org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent t : src.getPackageItem())
      tgt.addPackageItem(convertMedicinalProductPackagedPackageItemComponent(t));
    if (src.hasPhysicalCharacteristics())
      tgt.setPhysicalCharacteristics(convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOtherCharacteristics())
      tgt.addOtherCharacteristics(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(convertProductShelfLife(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent convertMedicinalProductPackagedPackageItemComponent(org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMaterial())
      tgt.addMaterial(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAlternateMaterial())
      tgt.addAlternateMaterial(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getManufacturedItem())
      tgt.addManufacturedItem(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicinalProductPackaged.MedicinalProductPackagedPackageItemComponent t : src.getPackageItem())
      tgt.addPackageItem(convertMedicinalProductPackagedPackageItemComponent(t));
    if (src.hasPhysicalCharacteristics())
      tgt.setPhysicalCharacteristics(convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getOtherCharacteristics())
      tgt.addOtherCharacteristics(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(convertProductShelfLife(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    return tgt;
  }


}
