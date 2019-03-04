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


public class MedicinalProductAuthorization extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductAuthorization convertMedicinalProductAuthorization(org.hl7.fhir.r4.model.MedicinalProductAuthorization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductAuthorization tgt = new org.hl7.fhir.r5.model.MedicinalProductAuthorization();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(convertDateTime(src.getStatusDateElement()));
    if (src.hasRestoreDate())
      tgt.setRestoreDateElement(convertDateTime(src.getRestoreDateElement()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    if (src.hasDataExclusivityPeriod())
      tgt.setDataExclusivityPeriod(convertPeriod(src.getDataExclusivityPeriod()));
    if (src.hasDateOfFirstAuthorization())
      tgt.setDateOfFirstAuthorizationElement(convertDateTime(src.getDateOfFirstAuthorizationElement()));
    if (src.hasInternationalBirthDate())
      tgt.setInternationalBirthDateElement(convertDateTime(src.getInternationalBirthDateElement()));
    if (src.hasLegalBasis())
      tgt.setLegalBasis(convertCodeableConcept(src.getLegalBasis()));
    for (org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent t : src.getJurisdictionalAuthorization())
      tgt.addJurisdictionalAuthorization(convertMedicinalProductAuthorizationJurisdictionalAuthorizationComponent(t));
    if (src.hasHolder())
      tgt.setHolder(convertReference(src.getHolder()));
    if (src.hasRegulator())
      tgt.setRegulator(convertReference(src.getRegulator()));
    if (src.hasProcedure())
      tgt.setProcedure(convertMedicinalProductAuthorizationProcedureComponent(src.getProcedure()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductAuthorization convertMedicinalProductAuthorization(org.hl7.fhir.r5.model.MedicinalProductAuthorization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductAuthorization tgt = new org.hl7.fhir.r4.model.MedicinalProductAuthorization();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(convertDateTime(src.getStatusDateElement()));
    if (src.hasRestoreDate())
      tgt.setRestoreDateElement(convertDateTime(src.getRestoreDateElement()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    if (src.hasDataExclusivityPeriod())
      tgt.setDataExclusivityPeriod(convertPeriod(src.getDataExclusivityPeriod()));
    if (src.hasDateOfFirstAuthorization())
      tgt.setDateOfFirstAuthorizationElement(convertDateTime(src.getDateOfFirstAuthorizationElement()));
    if (src.hasInternationalBirthDate())
      tgt.setInternationalBirthDateElement(convertDateTime(src.getInternationalBirthDateElement()));
    if (src.hasLegalBasis())
      tgt.setLegalBasis(convertCodeableConcept(src.getLegalBasis()));
    for (org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent t : src.getJurisdictionalAuthorization())
      tgt.addJurisdictionalAuthorization(convertMedicinalProductAuthorizationJurisdictionalAuthorizationComponent(t));
    if (src.hasHolder())
      tgt.setHolder(convertReference(src.getHolder()));
    if (src.hasRegulator())
      tgt.setRegulator(convertReference(src.getRegulator()));
    if (src.hasProcedure())
      tgt.setProcedure(convertMedicinalProductAuthorizationProcedureComponent(src.getProcedure()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent convertMedicinalProductAuthorizationJurisdictionalAuthorizationComponent(org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent convertMedicinalProductAuthorizationJurisdictionalAuthorizationComponent(org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationJurisdictionalAuthorizationComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasLegalStatusOfSupply())
      tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent convertMedicinalProductAuthorizationProcedureComponent(org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDate())
      tgt.setDate(convertType(src.getDate()));
    for (org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent t : src.getApplication())
      tgt.addApplication(convertMedicinalProductAuthorizationProcedureComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent convertMedicinalProductAuthorizationProcedureComponent(org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDate())
      tgt.setDate(convertType(src.getDate()));
    for (org.hl7.fhir.r5.model.MedicinalProductAuthorization.MedicinalProductAuthorizationProcedureComponent t : src.getApplication())
      tgt.addApplication(convertMedicinalProductAuthorizationProcedureComponent(t));
    return tgt;
  }


}
