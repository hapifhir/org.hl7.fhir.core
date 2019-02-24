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


public class MedicinalProductPharmaceutical extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductPharmaceutical convertMedicinalProductPharmaceutical(org.hl7.fhir.r4.model.MedicinalProductPharmaceutical src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPharmaceutical tgt = new org.hl7.fhir.r5.model.MedicinalProductPharmaceutical();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasAdministrableDoseForm())
      tgt.setAdministrableDoseForm(convertCodeableConcept(src.getAdministrableDoseForm()));
    if (src.hasUnitOfPresentation())
      tgt.setUnitOfPresentation(convertCodeableConcept(src.getUnitOfPresentation()));
    for (org.hl7.fhir.r4.model.Reference t : src.getIngredient())
      tgt.addIngredient(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent t : src.getCharacteristics())
      tgt.addCharacteristics(convertMedicinalProductPharmaceuticalCharacteristicsComponent(t));
    for (org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent t : src.getRouteOfAdministration())
      tgt.addRouteOfAdministration(convertMedicinalProductPharmaceuticalRouteOfAdministrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPharmaceutical convertMedicinalProductPharmaceutical(org.hl7.fhir.r5.model.MedicinalProductPharmaceutical src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPharmaceutical tgt = new org.hl7.fhir.r4.model.MedicinalProductPharmaceutical();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasAdministrableDoseForm())
      tgt.setAdministrableDoseForm(convertCodeableConcept(src.getAdministrableDoseForm()));
    if (src.hasUnitOfPresentation())
      tgt.setUnitOfPresentation(convertCodeableConcept(src.getUnitOfPresentation()));
    for (org.hl7.fhir.r5.model.Reference t : src.getIngredient())
      tgt.addIngredient(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent t : src.getCharacteristics())
      tgt.addCharacteristics(convertMedicinalProductPharmaceuticalCharacteristicsComponent(t));
    for (org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent t : src.getRouteOfAdministration())
      tgt.addRouteOfAdministration(convertMedicinalProductPharmaceuticalRouteOfAdministrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent convertMedicinalProductPharmaceuticalCharacteristicsComponent(org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent convertMedicinalProductPharmaceuticalCharacteristicsComponent(org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalCharacteristicsComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationComponent(org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFirstDose())
      tgt.setFirstDose(convertQuantity(src.getFirstDose()));
    if (src.hasMaxSingleDose())
      tgt.setMaxSingleDose(convertQuantity(src.getMaxSingleDose()));
    if (src.hasMaxDosePerDay())
      tgt.setMaxDosePerDay(convertQuantity(src.getMaxDosePerDay()));
    if (src.hasMaxDosePerTreatmentPeriod())
      tgt.setMaxDosePerTreatmentPeriod(convertRatio(src.getMaxDosePerTreatmentPeriod()));
    if (src.hasMaxTreatmentPeriod())
      tgt.setMaxTreatmentPeriod(convertDuration(src.getMaxTreatmentPeriod()));
    for (org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent t : src.getTargetSpecies())
      tgt.addTargetSpecies(convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationComponent(org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFirstDose())
      tgt.setFirstDose(convertQuantity(src.getFirstDose()));
    if (src.hasMaxSingleDose())
      tgt.setMaxSingleDose(convertQuantity(src.getMaxSingleDose()));
    if (src.hasMaxDosePerDay())
      tgt.setMaxDosePerDay(convertQuantity(src.getMaxDosePerDay()));
    if (src.hasMaxDosePerTreatmentPeriod())
      tgt.setMaxDosePerTreatmentPeriod(convertRatio(src.getMaxDosePerTreatmentPeriod()));
    if (src.hasMaxTreatmentPeriod())
      tgt.setMaxTreatmentPeriod(convertDuration(src.getMaxTreatmentPeriod()));
    for (org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent t : src.getTargetSpecies())
      tgt.addTargetSpecies(convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent(org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent t : src.getWithdrawalPeriod())
      tgt.addWithdrawalPeriod(convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent(org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent t : src.getWithdrawalPeriod())
      tgt.addWithdrawalPeriod(convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent(org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent();
    copyElement(src, tgt);
    if (src.hasTissue())
      tgt.setTissue(convertCodeableConcept(src.getTissue()));
    if (src.hasValue())
      tgt.setValue(convertQuantity(src.getValue()));
    if (src.hasSupportingInformation())
      tgt.setSupportingInformationElement(convertString(src.getSupportingInformationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent convertMedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent(org.hl7.fhir.r5.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodComponent();
    copyElement(src, tgt);
    if (src.hasTissue())
      tgt.setTissue(convertCodeableConcept(src.getTissue()));
    if (src.hasValue())
      tgt.setValue(convertQuantity(src.getValue()));
    if (src.hasSupportingInformation())
      tgt.setSupportingInformationElement(convertString(src.getSupportingInformationElement()));
    return tgt;
  }


}
