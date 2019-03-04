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


public class MedicinalProductInteraction extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductInteraction convertMedicinalProductInteraction(org.hl7.fhir.r4.model.MedicinalProductInteraction src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductInteraction tgt = new org.hl7.fhir.r5.model.MedicinalProductInteraction();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent t : src.getInteractant())
      tgt.addInteractant(convertMedicinalProductInteractionInteractantComponent(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasEffect())
      tgt.setEffect(convertCodeableConcept(src.getEffect()));
    if (src.hasIncidence())
      tgt.setIncidence(convertCodeableConcept(src.getIncidence()));
    if (src.hasManagement())
      tgt.setManagement(convertCodeableConcept(src.getManagement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductInteraction convertMedicinalProductInteraction(org.hl7.fhir.r5.model.MedicinalProductInteraction src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductInteraction tgt = new org.hl7.fhir.r4.model.MedicinalProductInteraction();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent t : src.getInteractant())
      tgt.addInteractant(convertMedicinalProductInteractionInteractantComponent(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasEffect())
      tgt.setEffect(convertCodeableConcept(src.getEffect()));
    if (src.hasIncidence())
      tgt.setIncidence(convertCodeableConcept(src.getIncidence()));
    if (src.hasManagement())
      tgt.setManagement(convertCodeableConcept(src.getManagement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent convertMedicinalProductInteractionInteractantComponent(org.hl7.fhir.r4.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent();
    copyElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent convertMedicinalProductInteractionInteractantComponent(org.hl7.fhir.r5.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductInteraction.MedicinalProductInteractionInteractantComponent();
    copyElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    return tgt;
  }


}
