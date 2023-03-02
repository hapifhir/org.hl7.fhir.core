package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Range43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class Observation43_50 {

  public static org.hl7.fhir.r5.model.Observation convertObservation(org.hl7.fhir.r4b.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation tgt = new org.hl7.fhir.r5.model.Observation();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getFocus()) tgt.addFocus(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant43_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference43_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference43_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getHasMember()) tgt.addHasMember(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Observation convertObservation(org.hl7.fhir.r5.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Observation tgt = new org.hl7.fhir.r4b.model.Observation();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addFocus(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant43_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference43_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference43_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHasMember()) tgt.addHasMember(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity43_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity43_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range43_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertStringToMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity43_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity43_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range43_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4b.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4b.model.Observation.ObservationComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }
}