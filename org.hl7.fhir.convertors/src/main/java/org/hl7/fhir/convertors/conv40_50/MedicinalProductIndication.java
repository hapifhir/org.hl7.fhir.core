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


public class MedicinalProductIndication extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductIndication convertMedicinalProductIndication(org.hl7.fhir.r4.model.MedicinalProductIndication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIndication tgt = new org.hl7.fhir.r5.model.MedicinalProductIndication();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDiseaseSymptomProcedure())
      tgt.setDiseaseSymptomProcedure(convertCodeableConcept(src.getDiseaseSymptomProcedure()));
    if (src.hasDiseaseStatus())
      tgt.setDiseaseStatus(convertCodeableConcept(src.getDiseaseStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getComorbidity())
      tgt.addComorbidity(convertCodeableConcept(t));
    if (src.hasIntendedEffect())
      tgt.setIntendedEffect(convertCodeableConcept(src.getIntendedEffect()));
    if (src.hasDuration())
      tgt.setDuration(convertQuantity(src.getDuration()));
    for (org.hl7.fhir.r4.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent t : src.getOtherTherapy())
      tgt.addOtherTherapy(convertMedicinalProductIndicationOtherTherapyComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getUndesirableEffect())
      tgt.addUndesirableEffect(convertReference(t));
    for (org.hl7.fhir.r4.model.Population t : src.getPopulation())
      tgt.addPopulation(convertPopulation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIndication convertMedicinalProductIndication(org.hl7.fhir.r5.model.MedicinalProductIndication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIndication tgt = new org.hl7.fhir.r4.model.MedicinalProductIndication();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDiseaseSymptomProcedure())
      tgt.setDiseaseSymptomProcedure(convertCodeableConcept(src.getDiseaseSymptomProcedure()));
    if (src.hasDiseaseStatus())
      tgt.setDiseaseStatus(convertCodeableConcept(src.getDiseaseStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getComorbidity())
      tgt.addComorbidity(convertCodeableConcept(t));
    if (src.hasIntendedEffect())
      tgt.setIntendedEffect(convertCodeableConcept(src.getIntendedEffect()));
    if (src.hasDuration())
      tgt.setDuration(convertQuantity(src.getDuration()));
    for (org.hl7.fhir.r5.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent t : src.getOtherTherapy())
      tgt.addOtherTherapy(convertMedicinalProductIndicationOtherTherapyComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getUndesirableEffect())
      tgt.addUndesirableEffect(convertReference(t));
    for (org.hl7.fhir.r5.model.Population t : src.getPopulation())
      tgt.addPopulation(convertPopulation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent convertMedicinalProductIndicationOtherTherapyComponent(org.hl7.fhir.r4.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent();
    copyElement(src, tgt);
    if (src.hasTherapyRelationshipType())
      tgt.setTherapyRelationshipType(convertCodeableConcept(src.getTherapyRelationshipType()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent convertMedicinalProductIndicationOtherTherapyComponent(org.hl7.fhir.r5.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductIndication.MedicinalProductIndicationOtherTherapyComponent();
    copyElement(src, tgt);
    if (src.hasTherapyRelationshipType())
      tgt.setTherapyRelationshipType(convertCodeableConcept(src.getTherapyRelationshipType()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    return tgt;
  }


}
