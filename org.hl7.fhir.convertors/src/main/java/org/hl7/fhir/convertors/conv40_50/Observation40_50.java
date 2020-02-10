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
public class Observation40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Observation convertObservation(org.hl7.fhir.r4.model.Observation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Observation tgt = new org.hl7.fhir.r5.model.Observation();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(convertReference(t));
        }
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertInstant(src.getIssuedElement()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        }
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation()) tgt.addInterpretation(convertCodeableConcept(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        }
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(convertReference(src.getDevice()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        if (src.hasHasMember()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getHasMember()) tgt.addHasMember(convertReference(t));
        }
        if (src.hasDerivedFrom()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(convertReference(t));
        }
        if (src.hasComponent()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation convertObservation(org.hl7.fhir.r5.model.Observation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation tgt = new org.hl7.fhir.r4.model.Observation();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addFocus(convertReference(t));
        }
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertInstant(src.getIssuedElement()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        }
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation()) tgt.addInterpretation(convertCodeableConcept(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        }
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(convertReference(src.getDevice()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        if (src.hasHasMember()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getHasMember()) tgt.addHasMember(convertReference(t));
        }
        if (src.hasDerivedFrom()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(convertReference(t));
        }
        if (src.hasComponent()) {
            for (org.hl7.fhir.r5.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.ObservationStatus convertObservationStatus(org.hl7.fhir.r4.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.r5.model.Enumerations.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAppliesTo()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(convertCodeableConcept(t));
        }
        if (src.hasAge())
            tgt.setAge(convertRange(src.getAge()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAppliesTo()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(convertCodeableConcept(t));
        }
        if (src.hasAge())
            tgt.setAge(convertRange(src.getAge()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationComponentComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation()) tgt.addInterpretation(convertCodeableConcept(t));
        }
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationComponentComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation()) tgt.addInterpretation(convertCodeableConcept(t));
        }
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        return tgt;
    }
}
