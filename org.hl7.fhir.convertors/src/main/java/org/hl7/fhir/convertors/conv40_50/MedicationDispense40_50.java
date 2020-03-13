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
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes;
import org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory;

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
public class MedicationDispense40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense tgt = new org.hl7.fhir.r5.model.MedicationDispense();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertType(src.getStatusReason()));
        if (src.hasCategory())
            tgt.addCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(convertReference(src.getContext()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        for (org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(convertReference(src.getDestination()));
        for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertDosage(t));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r5.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertType(src.getStatusReason()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasMedication())
            tgt.setMedication(convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        for (org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(convertReference(src.getDestination()));
        for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertDosage(t));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    private static CodeType convertStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> src) {
        if (src == null)
            return null;
        CodeType tgt = new CodeType();
        copyElement(src, tgt);
        if (src.getValue() == MedicationDispenseStatusCodes.DECLINED)
            tgt.setValue("stopped");
        else
            tgt.setValue(src.getValueAsString());
        return tgt;
    }

    private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationStatus(org.hl7.fhir.r4.model.CodeType src) {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new MedicationDispenseStatusCodesEnumFactory());
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setValue(MedicationDispenseStatusCodes.fromCode(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent();
        copyElement(src, tgt);
        if (src.hasFunction())
            tgt.setFunction(convertCodeableConcept(src.getFunction()));
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent();
        copyElement(src, tgt);
        if (src.hasFunction())
            tgt.setFunction(convertCodeableConcept(src.getFunction()));
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        copyElement(src, tgt);
        if (src.hasWasSubstituted())
            tgt.setWasSubstitutedElement(convertBoolean(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) tgt.addReason(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty()) tgt.setResponsibleParty(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        copyElement(src, tgt);
        if (src.hasWasSubstituted())
            tgt.setWasSubstitutedElement(convertBoolean(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason()) tgt.addReason(convertCodeableConcept(t));
        if (src.hasResponsibleParty())
            tgt.addResponsibleParty(convertReference(src.getResponsibleParty()));
        return tgt;
    }
}
