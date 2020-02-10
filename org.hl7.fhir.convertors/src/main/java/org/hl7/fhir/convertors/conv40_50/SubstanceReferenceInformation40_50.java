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
public class SubstanceReferenceInformation40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation convertSubstanceReferenceInformation(org.hl7.fhir.r4.model.SubstanceReferenceInformation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceReferenceInformation tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation();
        copyDomainResource(src, tgt);
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasGene()) {
            for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent t : src.getGene()) tgt.addGene(convertSubstanceReferenceInformationGeneComponent(t));
        }
        if (src.hasGeneElement()) {
            for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent t : src.getGeneElement()) tgt.addGeneElement(convertSubstanceReferenceInformationGeneElementComponent(t));
        }
        if (src.hasClassification()) {
            for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent t : src.getClassification()) tgt.addClassification(convertSubstanceReferenceInformationClassificationComponent(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent t : src.getTarget()) tgt.addTarget(convertSubstanceReferenceInformationTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation convertSubstanceReferenceInformation(org.hl7.fhir.r5.model.SubstanceReferenceInformation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceReferenceInformation tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation();
        copyDomainResource(src, tgt);
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasGene()) {
            for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent t : src.getGene()) tgt.addGene(convertSubstanceReferenceInformationGeneComponent(t));
        }
        if (src.hasGeneElement()) {
            for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent t : src.getGeneElement()) tgt.addGeneElement(convertSubstanceReferenceInformationGeneElementComponent(t));
        }
        if (src.hasClassification()) {
            for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent t : src.getClassification()) tgt.addClassification(convertSubstanceReferenceInformationClassificationComponent(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent t : src.getTarget()) tgt.addTarget(convertSubstanceReferenceInformationTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent convertSubstanceReferenceInformationGeneComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent();
        copyElement(src, tgt);
        if (src.hasGeneSequenceOrigin())
            tgt.setGeneSequenceOrigin(convertCodeableConcept(src.getGeneSequenceOrigin()));
        if (src.hasGene())
            tgt.setGene(convertCodeableConcept(src.getGene()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent convertSubstanceReferenceInformationGeneComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent();
        copyElement(src, tgt);
        if (src.hasGeneSequenceOrigin())
            tgt.setGeneSequenceOrigin(convertCodeableConcept(src.getGeneSequenceOrigin()));
        if (src.hasGene())
            tgt.setGene(convertCodeableConcept(src.getGene()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent convertSubstanceReferenceInformationGeneElementComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasElement())
            tgt.setElement(convertIdentifier(src.getElement()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent convertSubstanceReferenceInformationGeneElementComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasElement())
            tgt.setElement(convertIdentifier(src.getElement()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent convertSubstanceReferenceInformationClassificationComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent();
        copyElement(src, tgt);
        if (src.hasDomain())
            tgt.setDomain(convertCodeableConcept(src.getDomain()));
        if (src.hasClassification())
            tgt.setClassification(convertCodeableConcept(src.getClassification()));
        if (src.hasSubtype()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
        }
        if (src.hasSource()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent convertSubstanceReferenceInformationClassificationComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent();
        copyElement(src, tgt);
        if (src.hasDomain())
            tgt.setDomain(convertCodeableConcept(src.getDomain()));
        if (src.hasClassification())
            tgt.setClassification(convertCodeableConcept(src.getClassification()));
        if (src.hasSubtype()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
        }
        if (src.hasSource()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent convertSubstanceReferenceInformationTargetComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent();
        copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(convertIdentifier(src.getTarget()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasInteraction())
            tgt.setInteraction(convertCodeableConcept(src.getInteraction()));
        if (src.hasOrganism())
            tgt.setOrganism(convertCodeableConcept(src.getOrganism()));
        if (src.hasOrganismType())
            tgt.setOrganismType(convertCodeableConcept(src.getOrganismType()));
        if (src.hasAmount())
            tgt.setAmount(convertType(src.getAmount()));
        if (src.hasAmountType())
            tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent convertSubstanceReferenceInformationTargetComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent();
        copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(convertIdentifier(src.getTarget()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasInteraction())
            tgt.setInteraction(convertCodeableConcept(src.getInteraction()));
        if (src.hasOrganism())
            tgt.setOrganism(convertCodeableConcept(src.getOrganism()));
        if (src.hasOrganismType())
            tgt.setOrganismType(convertCodeableConcept(src.getOrganismType()));
        if (src.hasAmount())
            tgt.setAmount(convertType(src.getAmount()));
        if (src.hasAmountType())
            tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
        }
        return tgt;
    }
}
