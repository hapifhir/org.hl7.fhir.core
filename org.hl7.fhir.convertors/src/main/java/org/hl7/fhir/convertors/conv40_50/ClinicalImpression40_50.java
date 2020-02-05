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
public class ClinicalImpression40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r4.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ClinicalImpression tgt = new org.hl7.fhir.r5.model.ClinicalImpression();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        // if (src.hasCode())
        // tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(convertType(src.getEffective()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasAssessor())
            tgt.setPerformer(convertReference(src.getAssessor()));
        if (src.hasPrevious())
            tgt.setPrevious(convertReference(src.getPrevious()));
        if (src.hasProblem()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getProblem()) tgt.addProblem(convertReference(t));
        }
        if (src.hasProtocol()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getProtocol()) tgt.getProtocol().add(convertUri(t));
        }
        if (src.hasSummary())
            tgt.setSummaryElement(convertString(src.getSummaryElement()));
        if (src.hasFinding()) {
            for (org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosisCodeableConcept()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(convertCodeableConcept(t));
        }
        if (src.hasPrognosisReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(convertReference(t));
        }
        if (src.hasSupportingInfo()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r5.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ClinicalImpression tgt = new org.hl7.fhir.r4.model.ClinicalImpression();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        // if (src.hasCode())
        // tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(convertType(src.getEffective()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPerformer())
            tgt.setAssessor(convertReference(src.getPerformer()));
        if (src.hasPrevious())
            tgt.setPrevious(convertReference(src.getPrevious()));
        if (src.hasProblem()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getProblem()) tgt.addProblem(convertReference(t));
        }
        if (src.hasProtocol()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getProtocol()) tgt.getProtocol().add(convertUri(t));
        }
        if (src.hasSummary())
            tgt.setSummaryElement(convertString(src.getSummaryElement()));
        if (src.hasFinding()) {
            for (org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosisCodeableConcept()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(convertCodeableConcept(t));
        }
        if (src.hasPrognosisReference()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(convertReference(t));
        }
        if (src.hasSupportingInfo()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.EventStatus convertClinicalImpressionStatus(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus convertClinicalImpressionStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            tgt.setItem(convertCodeableConceptToCodeableReference(src.getItemCodeableConcept()));
        if (src.hasItemReference())
            tgt.setItem(convertReferenceToCodeableReference(src.getItemReference()));
        if (src.hasBasis())
            tgt.setBasisElement(convertString(src.getBasisElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        copyElement(src, tgt);
        if (src.hasItem() && src.getItem().hasConcept())
            tgt.setItemCodeableConcept(convertCodeableConcept(src.getItem().getConcept()));
        if (src.hasItem() && src.getItem().hasReference())
            tgt.setItemReference(convertReference(src.getItem().getReference()));
        if (src.hasBasis())
            tgt.setBasisElement(convertString(src.getBasisElement()));
        return tgt;
    }
}
