package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Range40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class Observation40_50 {

  public static org.hl7.fhir.r5.model.Observation convertObservation(org.hl7.fhir.r4.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation tgt = new org.hl7.fhir.r5.model.Observation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    if (src.hasValue()) {
      if (src.hasValueStringType()) {
        tgt.setValue(String40_50.convertStringToMarkdown(src.getValueStringType()));
      } else {
        tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
      }
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept40_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference40_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference40_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getHasMember()) tgt.addHasMember(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation convertObservation(org.hl7.fhir.r5.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation tgt = new org.hl7.fhir.r4.model.Observation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    if (src.hasValue()) {
      if (src.hasValueMarkdownType()) {
        tgt.setValue(String40_50.convertMarkdownToString(src.getValueMarkdownType()));
      } else {
        tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
      }
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept40_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference40_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference40_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHasMember()) tgt.addHasMember(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Observation.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Observation.ObservationStatus> convertObservationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Observation.ObservationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Observation.ObservationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Observation.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity40_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity40_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range40_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertStringToMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity40_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity40_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range40_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationComponentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue()) {
      if (src.hasValueStringType()) {
        tgt.setValue(String40_50.convertStringToMarkdown(src.getValueStringType()));
      } else {
        tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
      }
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationComponentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue()) {
      if (src.hasValueMarkdownType()) {
        tgt.setValue(String40_50.convertMarkdownToString(src.getValueMarkdownType()));
      } else {
        tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
      }
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_50.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }
}